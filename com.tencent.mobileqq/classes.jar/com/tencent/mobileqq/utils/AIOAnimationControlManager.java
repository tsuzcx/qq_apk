package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.av.utils.TroopMemberUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.JpegExifReader;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.helper.GiftPanelHelper;
import com.tencent.mobileqq.activity.aio.helper.TroopEffectHelper;
import com.tencent.mobileqq.activity.aio.helper.TroopGiftPanelHelper;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageForTroopEffectPic;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.emosm.AIOEmoticonUIHelper;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.mobileqq.pic.PicDownloadInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.qwallet.hb.aio.specify.ISpecifyRedPacketAnimMsg;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.OnFrameEndListener;
import com.tencent.mobileqq.troop.data.TroopGiftBagInfo;
import com.tencent.mobileqq.troop.data.TroopGiftBagPlayer;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import com.tencent.mobileqq.troop.robot.RobotResourcesManager;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.mobileqq.troopgift.TroopGiftAnimationController;
import com.tencent.mobileqq.troopgift.TroopGiftAnimationController.OnCleanAnimationListener;
import com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectsController;
import com.tencent.mobileqq.vas.troopgift.TroopGiftData;
import com.tencent.mobileqq.vas.troopgift.TroopGiftData.GiftDataBean;
import com.tencent.mobileqq.vas.troopgift.TroopGiftData.GiftDataBean.DataForClientBean;
import com.tencent.mobileqq.vas.troopgift.TroopGiftResManager;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class AIOAnimationControlManager
  extends Observable
  implements Manager
{
  public static final String b = String.valueOf(10000L);
  public static int c = 9;
  public static volatile boolean l = false;
  public int a = 1;
  HashMap<String, Integer> d = new HashMap();
  HashMap<String, List<AIOAnimationControlManager.IAnimationMessage>> e = new HashMap();
  TroopGiftAnimationController f;
  BaseChatPie g;
  Activity h;
  String i;
  Handler j;
  public AIOAnimationControlManager.OnAnimationPlayEndListener k;
  protected TroopInteractGiftAnimationController m;
  protected HashMap<String, List<MessageForDeliverGiftTips>> n = new HashMap();
  TroopPicEffectsController o;
  AppInterface p = null;
  public volatile boolean q = true;
  public Comparator<AIOAnimationControlManager.IAnimationMessage> r = new AIOAnimationControlManager.3(this);
  DownloadListener s = new AIOAnimationControlManager.4(this);
  TroopGiftAnimationController.OnCleanAnimationListener t = new AIOAnimationControlManager.15(this);
  FrameSprite.OnFrameEndListener u = new AIOAnimationControlManager.16(this);
  private long v;
  private int w;
  private SharedPreferences x;
  private boolean y = false;
  
  public AIOAnimationControlManager(AppInterface paramAppInterface)
  {
    this.p = paramAppInterface;
    a(paramAppInterface);
    this.j = new Handler(Looper.getMainLooper());
  }
  
  private void a(AppInterface paramAppInterface)
  {
    if ((paramAppInterface != null) && ((paramAppInterface instanceof BrowserAppInterface)))
    {
      l();
      return;
    }
    ThreadManager.post(new AIOAnimationControlManager.1(this), 8, null, true);
  }
  
  public static void a(BaseChatPie paramBaseChatPie, boolean paramBoolean)
  {
    if (((paramBaseChatPie.aX() instanceof SplashActivity)) && (SplashActivity.currentFragment != 2)) {
      return;
    }
    AIOAnimationControlManager localAIOAnimationControlManager = (AIOAnimationControlManager)paramBaseChatPie.d.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
    localAIOAnimationControlManager.a(paramBaseChatPie);
    if (paramBoolean) {
      localAIOAnimationControlManager.d();
    }
    localAIOAnimationControlManager.a(paramBaseChatPie.aX().getSharedPreferences("AIOAnimationControlManager_limit_key", 4));
    if (QLog.isColorLevel()) {
      QLog.d(".troop.send_gift", 2, "playTroopGiftAnimationPlayList");
    }
    paramBaseChatPie.j().post(new AIOAnimationControlManager.17(localAIOAnimationControlManager, paramBoolean));
  }
  
  private void a(AIOAnimationControlManager.IAnimationMessage paramIAnimationMessage)
  {
    List localList = (List)this.e.get(paramIAnimationMessage.getFriendUin());
    localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this.e.put(paramIAnimationMessage.getFriendUin(), localObject);
    }
    try
    {
      ((List)localObject).add(paramIAnimationMessage);
      i6 = paramIAnimationMessage.getLimitType();
      i1 = 0;
      i4 = 0;
      i2 = -1;
    }
    finally
    {
      for (;;)
      {
        int i6;
        int i1;
        int i3;
        for (;;)
        {
          throw paramIAnimationMessage;
        }
        int i5 = i4 + 1;
        i1 += 1;
        int i4 = i5;
        int i2 = i3;
      }
    }
    if (i1 < ((List)localObject).size())
    {
      paramIAnimationMessage = (AIOAnimationControlManager.IAnimationMessage)((List)localObject).get(i1);
      i5 = i4;
      i3 = i2;
      if (paramIAnimationMessage == null) {
        break label187;
      }
      i5 = i4;
      i3 = i2;
      if (paramIAnimationMessage.getLimitType() != i6) {
        break label187;
      }
      i3 = i2;
      if (i2 == -1) {
        i3 = i1;
      }
    }
    else
    {
      if (i4 > a(i6)) {
        ((List)localObject).remove(i2);
      }
      return;
    }
  }
  
  private void a(String paramString, MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    if ((!this.d.containsKey(paramString)) || (((Integer)this.d.get(paramString)).intValue() == 4))
    {
      Object localObject2 = new File(TroopGiftUtil.a(paramString, paramMessageForDeliverGiftTips.animationType, paramMessageForDeliverGiftTips.isInteract()));
      Object localObject1 = new Bundle();
      ((Bundle)localObject1).putString("GiftAnimationId", paramString);
      ((Bundle)localObject1).putString("TroopUin", paramMessageForDeliverGiftTips.frienduin);
      ((Bundle)localObject1).putInt("GiftAnimationType", paramMessageForDeliverGiftTips.animationType);
      ((Bundle)localObject1).putBoolean("GiftIsInteract", paramMessageForDeliverGiftTips.isInteract());
      localObject2 = new DownloadTask(TroopGiftUtil.d(paramMessageForDeliverGiftTips), (File)localObject2);
      ((DownloadTask)localObject2).e = 2;
      if ((paramMessageForDeliverGiftTips instanceof MessageForTroopGift)) {
        ((MessageForTroopGift)paramMessageForDeliverGiftTips).isLoading = true;
      }
      i().startDownload((DownloadTask)localObject2, this.s, (Bundle)localObject1);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("start Download PackageId:");
        ((StringBuilder)localObject1).append(TroopGiftUtil.b(paramMessageForDeliverGiftTips));
        QLog.d("AIOAnimationControlManager", 2, ((StringBuilder)localObject1).toString());
      }
      this.d.put(paramString, Integer.valueOf(2));
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    List localList = (List)this.e.get(paramString1);
    if (paramString2 != null)
    {
      if (localList == null) {
        return;
      }
      int i1 = 0;
      while (i1 < localList.size())
      {
        AIOAnimationControlManager.IAnimationMessage localIAnimationMessage = (AIOAnimationControlManager.IAnimationMessage)localList.get(i1);
        boolean bool = localIAnimationMessage instanceof MessageForDeliverGiftTips;
        paramString1 = "";
        if (bool)
        {
          paramString1 = TroopGiftUtil.b((MessageForDeliverGiftTips)localIAnimationMessage);
        }
        else if ((localIAnimationMessage instanceof MessageForTroopEffectPic))
        {
          paramString1 = new StringBuilder();
          paramString1.append(((MessageForTroopEffectPic)localIAnimationMessage).effectId);
          paramString1.append("");
          paramString1 = paramString1.toString();
        }
        if (paramString2.equals(paramString1)) {
          localList.remove(i1);
        }
        i1 += 1;
      }
    }
  }
  
  public static boolean a(BaseChatPie paramBaseChatPie, QQAppInterface paramQQAppInterface, Object paramObject)
  {
    if ((paramObject instanceof MessageForDeliverGiftTips))
    {
      if (!((MessageForDeliverGiftTips)paramObject).isInteract())
      {
        a(paramBaseChatPie, false);
      }
      else
      {
        if (((paramBaseChatPie.aX() instanceof SplashActivity)) && (SplashActivity.currentFragment != 2)) {
          return true;
        }
        ((AIOAnimationControlManager)paramQQAppInterface.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER)).a(paramBaseChatPie);
      }
    }
    else if ((paramObject instanceof MessageForArkApp))
    {
      MessageForArkApp localMessageForArkApp = (MessageForArkApp)paramObject;
      if ((localMessageForArkApp.ark_app_message != null) && (localMessageForArkApp.ark_app_message.appName.equals("com.tencent.qzone.qungift"))) {
        a(paramBaseChatPie, false);
      }
    }
    if (((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).specifyRedPacketIsValidAnim(paramObject, paramQQAppInterface)) {
      a(paramBaseChatPie, false);
    }
    return false;
  }
  
  private String[] a(String... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList();
    int i2 = paramVarArgs.length;
    int i1 = 0;
    while (i1 < i2)
    {
      String str = paramVarArgs[i1];
      if (!TextUtils.isEmpty(str)) {
        localArrayList.add(str);
      }
      i1 += 1;
    }
    return (String[])localArrayList.toArray(new String[0]);
  }
  
  private void b(TroopGiftData paramTroopGiftData)
  {
    TroopGiftAnimationController localTroopGiftAnimationController = this.f;
    if (localTroopGiftAnimationController == null) {
      return;
    }
    this.a = 2;
    localTroopGiftAnimationController.a(paramTroopGiftData, new AIOAnimationControlManager.7(this, paramTroopGiftData));
  }
  
  private void b(String paramString1, String paramString2)
  {
    paramString1 = (List)this.n.get(paramString1);
    if (paramString2 != null)
    {
      if (paramString1 == null) {
        return;
      }
      int i1 = 0;
      while (i1 < paramString1.size())
      {
        if (paramString2.equals(TroopGiftUtil.b((MessageForDeliverGiftTips)paramString1.get(i1)))) {
          paramString1.remove(i1);
        }
        i1 += 1;
      }
    }
  }
  
  private void l()
  {
    Object localObject = new File(AppConstants.SDCARD_GIFT_SAVE);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    File[] arrayOfFile = ((File)localObject).listFiles();
    if (arrayOfFile != null)
    {
      int i1 = 0;
      while (i1 < arrayOfFile.length)
      {
        if ((arrayOfFile[i1].exists()) && (arrayOfFile[i1].isDirectory()))
        {
          String str = arrayOfFile[i1].getName();
          boolean bool = arrayOfFile[i1].getName().endsWith("_HD");
          int i2 = 1;
          if (bool) {
            localObject = str.substring(0, str.length() - 3);
          }
          do
          {
            bool = false;
            i2 = 0;
            break;
            if (arrayOfFile[i1].getName().endsWith("_V"))
            {
              localObject = str.substring(0, str.length() - 2);
              bool = false;
              break;
            }
            localObject = str;
          } while (!arrayOfFile[i1].getName().endsWith("_NEW"));
          localObject = str.substring(0, str.length() - 4);
          bool = true;
          if (TroopGiftUtil.b((String)localObject, i2, bool))
          {
            this.d.put(localObject, Integer.valueOf(3));
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("Package Downloaded:");
              ((StringBuilder)localObject).append(arrayOfFile[i1].getName());
              QLog.d("AIOAnimationControlManager", 2, ((StringBuilder)localObject).toString());
            }
          }
          else
          {
            FileUtils.deleteDirectory(arrayOfFile[i1].getAbsolutePath());
          }
        }
        i1 += 1;
      }
    }
  }
  
  public int a(int paramInt)
  {
    if (paramInt == 0) {
      return 5;
    }
    if ((1 == paramInt) && ((this.p instanceof BaseQQAppInterface))) {
      return ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).getSpecifyHbAniMaxSize((BaseQQAppInterface)this.p);
    }
    return 0;
  }
  
  public void a(int paramInt, String paramString, MessageForTroopEffectPic paramMessageForTroopEffectPic)
  {
    paramMessageForTroopEffectPic = new StringBuilder();
    paramMessageForTroopEffectPic.append("");
    paramMessageForTroopEffectPic.append(paramInt);
    paramMessageForTroopEffectPic = paramMessageForTroopEffectPic.toString();
    Object localObject1 = this.d;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(paramInt);
    if ((!((HashMap)localObject1).containsKey(((StringBuilder)localObject2).toString())) || (((Integer)this.d.get(paramMessageForTroopEffectPic)).intValue() == 4))
    {
      localObject2 = new File(TroopGiftUtil.a(paramInt));
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("GiftAnimationId", paramMessageForTroopEffectPic);
      ((Bundle)localObject1).putString("TroopUin", paramString);
      paramString = new DownloadTask(TroopGiftUtil.b(paramInt), (File)localObject2);
      paramString.e = 2;
      i().startDownload(paramString, this.s, (Bundle)localObject1);
      this.d.put(paramMessageForTroopEffectPic, Integer.valueOf(2));
    }
  }
  
  public void a(Activity paramActivity)
  {
    if (this.f == null) {
      this.f = new TroopGiftAnimationController(null, paramActivity, this.p);
    }
    this.f.a(4);
    this.h = this.f.e();
    this.i = b;
  }
  
  public void a(SharedPreferences paramSharedPreferences)
  {
    this.x = paramSharedPreferences;
    this.v = this.x.getLong("AIOAnimationControlManager_limit_gif_time", 0L);
    this.w = this.x.getInt("AIOAnimationControlManager_limit_gif_count", 0);
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("set TroopChatPie ,troopUin:");
      localStringBuilder.append(paramBaseChatPie.ah.b);
      QLog.d("AIOAnimationControlManager", 2, localStringBuilder.toString());
    }
    if (this.g != paramBaseChatPie)
    {
      this.g = paramBaseChatPie;
      addObserver(this.g);
      this.f = ((GiftPanelHelper)paramBaseChatPie.q(136)).b();
      paramBaseChatPie = this.g;
      if ((paramBaseChatPie instanceof TroopChatPie))
      {
        this.f.a(1);
        this.m = ((TroopGiftPanelHelper)((TroopChatPie)this.g).q(136)).g();
        this.o = ((TroopEffectHelper)this.g.q(134)).a();
        return;
      }
      if ((paramBaseChatPie instanceof HotChatPie))
      {
        this.f.a(4);
        return;
      }
      if ((paramBaseChatPie instanceof NearbyChatPie))
      {
        if (paramBaseChatPie.ah.a == 10002)
        {
          this.f.a(8);
          return;
        }
        this.f.a(6);
      }
    }
  }
  
  public void a(TroopGiftData paramTroopGiftData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAnimationControlManager", 2, "downloadPAGAnimation");
    }
    if (paramTroopGiftData.isResInvalid())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downloadPAGAnimation: gift pag url is invalid. gift id: ");
      ((StringBuilder)localObject).append(paramTroopGiftData.giftData.dataForClient.giftId);
      QLog.e("AIOAnimationControlManager", 1, ((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = a(new String[] { paramTroopGiftData.giftData.dataForClient.continueAnimationAnd, paramTroopGiftData.giftData.dataForClient.giftResourceAnd });
    if (TroopGiftResManager.a.a((String[])localObject))
    {
      b(paramTroopGiftData);
      return;
    }
    this.a = 3;
    TroopGiftResManager.a.a(this.p.getApp().getBaseContext(), (String[])localObject, new AIOAnimationControlManager.6(this, paramTroopGiftData));
  }
  
  public void a(String paramString, boolean paramBoolean, long paramLong)
  {
    paramString = (TroopGiftData)new Gson().fromJson(paramString, TroopGiftData.class);
    paramString.setReaded(paramBoolean);
    paramString.setShmsgseq(paramLong);
    a(paramString);
    j();
  }
  
  public void a(Observer paramObserver)
  {
    AIOAnimationControlManager.DownloadGiftResStateObservable.a().addObserver(paramObserver);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.g == null) && (this.h == null) && (!b.equals(this.i))) {
      return;
    }
    this.y = paramBoolean;
    Object localObject1;
    if (b.equals(this.i))
    {
      localObject1 = this.i;
    }
    else if ((this.g != null) && (((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).judgeBaseChatPieIsGuildChatPie(this.g)))
    {
      localObject1 = this.g.ah.c;
    }
    else
    {
      localObject1 = this.g;
      if (localObject1 != null) {
        localObject1 = ((BaseChatPie)localObject1).ah.b;
      } else {
        localObject1 = this.i;
      }
    }
    Object localObject5 = (List)this.n.get(localObject1);
    Object localObject4 = (List)this.e.get(localObject1);
    if ((!b()) && (TroopGiftUtil.a((List)localObject5))) {
      return;
    }
    Object localObject3 = this.g;
    if (localObject3 != null) {
      localObject3 = (AIOEmoticonUIHelper)((BaseChatPie)localObject3).q(105);
    } else {
      localObject3 = null;
    }
    Object localObject6;
    Object localObject7;
    if ((this.m != null) && (!TroopGiftUtil.a((List)localObject5)))
    {
      if ((this.m.c()) && (this.m.b())) {
        return;
      }
      this.a = 2;
      localObject6 = (MessageForDeliverGiftTips)((List)localObject5).get(0);
      localObject7 = TroopGiftUtil.b((MessageForDeliverGiftTips)localObject6);
      if ((this.d.containsKey(localObject7)) && (((Integer)this.d.get(localObject7)).intValue() == 3))
      {
        if ((localObject3 != null) && (((AIOEmoticonUIHelper)localObject3).a() != null) && (((AIOEmoticonUIHelper)localObject3).a().q != null) && (((AIOEmoticonUIHelper)localObject3).a().q.h()))
        {
          this.j.postDelayed(new AIOAnimationControlManager.8(this, paramBoolean), 500L);
          return;
        }
        if (((MessageForDeliverGiftTips)localObject6).interactState != 2) {
          ((TroopGiftManager)this.p.getManager(QQManagerFactory.TROOP_GIFT_MANAGER)).a(((MessageForDeliverGiftTips)localObject6).frienduin, ((MessageForDeliverGiftTips)localObject6).interactId, ((MessageForDeliverGiftTips)localObject6).giftId, new AIOAnimationControlManager.9(this, (MessageForDeliverGiftTips)localObject6, (List)localObject5, paramBoolean, (List)localObject4, (String)localObject7));
        }
      }
      else
      {
        if ((this.d.containsKey(localObject7)) && (((Integer)this.d.get(localObject7)).intValue() == 4))
        {
          b((String)localObject1, (String)localObject7);
          this.a = 1;
          a(paramBoolean);
          return;
        }
        this.a = 3;
      }
    }
    else if ((this.f != null) && (!TroopGiftUtil.a((List)localObject4)))
    {
      int i1 = this.a;
      if (i1 != 2)
      {
        if (i1 == 3) {
          return;
        }
        this.a = 2;
        localObject5 = (AIOAnimationControlManager.IAnimationMessage)((List)localObject4).get(0);
        if ((localObject5 instanceof TroopGiftData))
        {
          QLog.d("AIOAnimationControlManager", 1, "animationMessage instanceof TroopGiftData");
          a((TroopGiftData)localObject5);
          ((List)localObject4).remove(localObject5);
        }
        if ((localObject5 instanceof MessageForDeliverGiftTips))
        {
          localObject5 = (MessageForDeliverGiftTips)localObject5;
          if ((((MessageForDeliverGiftTips)localObject5).isToAll()) && (!((MessageForDeliverGiftTips)localObject5).hasFetchButFailed))
          {
            localObject6 = ((TroopGiftManager)this.p.getManager(QQManagerFactory.TROOP_GIFT_MANAGER)).a((String)localObject1, ((MessageForDeliverGiftTips)localObject5).bagId, new AIOAnimationControlManager.10(this, (MessageForDeliverGiftTips)localObject5, (String)localObject1, paramBoolean));
            if (localObject6 == null)
            {
              this.a = 1;
              return;
            }
            if ((((TroopGiftBagInfo)localObject6).hasGrab()) && (((TroopGiftBagInfo)localObject6).myGrabResult != null))
            {
              ((MessageForDeliverGiftTips)localObject5).showButton = false;
              ((MessageForDeliverGiftTips)localObject5).resultText = ((TroopGiftBagInfo)localObject6).myGrabResult.e;
              ((MessageForDeliverGiftTips)localObject5).resultType = 0;
            }
            else if (((TroopGiftBagInfo)localObject6).myGrabResult != null)
            {
              ((MessageForDeliverGiftTips)localObject5).showButton = false;
              ((MessageForDeliverGiftTips)localObject5).resultText = ((TroopGiftBagInfo)localObject6).myGrabResult.e;
              ((MessageForDeliverGiftTips)localObject5).resultType = 1;
            }
            else
            {
              ((MessageForDeliverGiftTips)localObject5).showButton = true;
            }
            localObject6 = this.p;
            if ((localObject6 instanceof QQAppInterface))
            {
              localObject6 = (QQAppInterface)localObject6;
              localObject7 = new StringBuilder();
              ((StringBuilder)localObject7).append("");
              ((StringBuilder)localObject7).append(((MessageForDeliverGiftTips)localObject5).senderUin);
              ((MessageForDeliverGiftTips)localObject5).senderName = ContactUtils.b((AppInterface)localObject6, (String)localObject1, ((StringBuilder)localObject7).toString());
            }
          }
          localObject6 = TroopGiftUtil.b((MessageForDeliverGiftTips)localObject5);
          if ((this.d.containsKey(localObject6)) && (((Integer)this.d.get(localObject6)).intValue() == 3))
          {
            this.f.a(this.u);
            if (QLog.isColorLevel())
            {
              localObject7 = new StringBuilder();
              ((StringBuilder)localObject7).append("Playing! playMaigface id:");
              ((StringBuilder)localObject7).append(TroopGiftUtil.b((MessageForDeliverGiftTips)localObject5));
              QLog.d("AIOAnimationControlManager", 2, ((StringBuilder)localObject7).toString());
            }
            if ((localObject3 != null) && (((AIOEmoticonUIHelper)localObject3).a() != null) && (((AIOEmoticonUIHelper)localObject3).a().q != null) && (((AIOEmoticonUIHelper)localObject3).a().q.h()))
            {
              this.j.postDelayed(new AIOAnimationControlManager.11(this, paramBoolean), 500L);
              return;
            }
            if (RobotResourcesManager.a().d()) {
              RobotResourcesManager.a().c();
            }
            if (!TextUtils.isEmpty(((MessageForDeliverGiftTips)localObject5).interactId))
            {
              ((List)localObject4).remove(localObject5);
              localObject1 = this.m;
              if (localObject1 != null) {
                ((TroopInteractGiftAnimationController)localObject1).a((MessageForDeliverGiftTips)localObject5, (String)localObject6, false, new AIOAnimationControlManager.12(this, paramBoolean));
              }
            }
            else
            {
              if (this.g != null) {
                localObject3 = "0";
              } else {
                localObject3 = "1";
              }
              localObject4 = this.g;
              if (localObject4 != null) {
                localObject4 = ((BaseChatPie)localObject4).d;
              } else {
                localObject4 = null;
              }
              localObject7 = new StringBuilder();
              ((StringBuilder)localObject7).append("");
              AppInterface localAppInterface = this.p;
              ((StringBuilder)localObject7).append(TroopMemberUtil.a(localAppInterface, localAppInterface.getCurrentAccountUin(), (String)localObject1));
              ReportController.b((AppRuntime)localObject4, "P_CliOper", "Grp_flower", "", "cartoon", "show", 0, 0, (String)localObject1, (String)localObject6, (String)localObject3, ((StringBuilder)localObject7).toString());
              if (QLog.isColorLevel())
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("Check isLimitGiftAnim: isEnterAIO:");
                ((StringBuilder)localObject1).append(paramBoolean);
                ((StringBuilder)localObject1).append(", isToMeGift:");
                boolean bool;
                if (((MessageForDeliverGiftTips)localObject5).receiverUin != this.p.getLongAccountUin()) {
                  bool = true;
                } else {
                  bool = false;
                }
                ((StringBuilder)localObject1).append(bool);
                ((StringBuilder)localObject1).append(", count:");
                ((StringBuilder)localObject1).append(this.w);
                ((StringBuilder)localObject1).append(", time:");
                ((StringBuilder)localObject1).append(this.v);
                QLog.d("AIOAnimationControlManager", 2, ((StringBuilder)localObject1).toString());
              }
              if ((paramBoolean) && (((MessageForDeliverGiftTips)localObject5).receiverUin != this.p.getLongAccountUin()) && (b(true)))
              {
                localObject1 = this.p;
                if ((localObject1 instanceof QQAppInterface))
                {
                  localObject1 = (QQAppInterface)localObject1;
                  localObject3 = ((QQAppInterface)localObject1).getProxyManager().g().a(false).iterator();
                  while (((Iterator)localObject3).hasNext())
                  {
                    localObject4 = (RecentUser)((Iterator)localObject3).next();
                    if (((RecentUser)localObject4).msgType == 7)
                    {
                      if (QLog.isColorLevel())
                      {
                        localObject5 = new StringBuilder();
                        ((StringBuilder)localObject5).append("limitGiftAnim setRead RecentUser:");
                        ((StringBuilder)localObject5).append(localObject4);
                        QLog.d("AIOAnimationControlManager", 2, ((StringBuilder)localObject5).toString());
                      }
                      ((QQAppInterface)localObject1).getMessageFacade().p().b(((RecentUser)localObject4).uin, ((RecentUser)localObject4).getType(), true, false);
                    }
                  }
                }
                return;
              }
              this.f.a((MessageForDeliverGiftTips)localObject5);
              this.f.e = this.t;
            }
          }
          else
          {
            if ((this.d.containsKey(localObject6)) && (((Integer)this.d.get(localObject6)).intValue() == 4))
            {
              a((String)localObject1, (String)localObject6);
              this.a = 1;
              a(paramBoolean);
              return;
            }
            this.a = 3;
          }
        }
        else
        {
          if ((localObject5 instanceof ISpecifyRedPacketAnimMsg))
          {
            localObject1 = (ISpecifyRedPacketAnimMsg)localObject5;
            this.f.a((ISpecifyRedPacketAnimMsg)localObject1);
            ((ISpecifyRedPacketAnimMsg)localObject1).a(this.g, new AIOAnimationControlManager.13(this, paramBoolean));
            ((List)localObject4).remove(localObject5);
            return;
          }
          if (((localObject5 instanceof MessageForTroopEffectPic)) && (this.o != null))
          {
            localObject3 = (MessageForTroopEffectPic)localObject5;
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append("");
            ((StringBuilder)localObject5).append(((MessageForTroopEffectPic)localObject3).effectId);
            localObject5 = ((StringBuilder)localObject5).toString();
            if ((((MessageForTroopEffectPic)localObject3).effectId < 40003) || (((MessageForTroopEffectPic)localObject3).effectId > 40005)) {
              this.d.put(localObject5, Integer.valueOf(3));
            }
            Object localObject2;
            if ((this.d.containsKey(localObject5)) && (((Integer)this.d.get(localObject5)).intValue() == 3) && (TroopGiftUtil.c(((MessageForTroopEffectPic)localObject3).effectId)))
            {
              localObject1 = ((MessageForTroopEffectPic)localObject3).getPicDownloadInfo();
              ((PicDownloadInfo)localObject1).l = "chatimg";
              localObject1 = ((PicDownloadInfo)localObject1).f();
              localObject6 = new File((String)localObject1);
              localObject5 = new BitmapFactory.Options();
              i1 = JpegExifReader.readOrientation((String)localObject1);
              if (i1 != 3)
              {
                if (i1 != 6)
                {
                  if (i1 != 8) {
                    i1 = 0;
                  } else {
                    i1 = 270;
                  }
                }
                else {
                  i1 = 90;
                }
              }
              else {
                i1 = 180;
              }
              try
              {
                if (((File)localObject6).exists())
                {
                  localObject6 = new BufferedInputStream(new FileInputStream((File)localObject6), 2048);
                  ((BitmapFactory.Options)localObject5).inSampleSize = ((int)ImageUtil.a((InputStream)localObject6, 720, 1080));
                  ((BufferedInputStream)localObject6).close();
                  localObject1 = ImageUtil.a((String)localObject1, (BitmapFactory.Options)localObject5);
                  if (localObject1 != null)
                  {
                    localObject5 = new Matrix();
                    ((Matrix)localObject5).reset();
                    ((Matrix)localObject5).setRotate(i1);
                    localObject1 = Bitmap.createBitmap((Bitmap)localObject1, 0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), (Matrix)localObject5, true);
                  }
                }
              }
              catch (OutOfMemoryError localOutOfMemoryError)
              {
                if (QLog.isColorLevel())
                {
                  localObject5 = new StringBuilder();
                  ((StringBuilder)localObject5).append("OOM: ");
                  ((StringBuilder)localObject5).append(QLog.getStackTraceString(localOutOfMemoryError));
                  QLog.d("AIOAnimationControlManager", 2, ((StringBuilder)localObject5).toString());
                }
              }
              catch (Exception localException)
              {
                localException.printStackTrace();
              }
              localObject2 = null;
              if (localObject2 != null)
              {
                localObject5 = this.g;
                if ((localObject5 != null) && ((localObject5 instanceof TroopChatPie)))
                {
                  localObject5 = (TroopChatPie)localObject5;
                  this.o.a(((MessageForTroopEffectPic)localObject3).effectId, (Bitmap)localObject2, ((TroopChatPie)localObject5).bI, new AIOAnimationControlManager.14(this, paramBoolean));
                  ((List)localObject4).remove(localObject3);
                  return;
                }
              }
              localObject2 = this.g;
              if ((localObject2 != null) && ((localObject2 instanceof TroopChatPie)))
              {
                this.a = 3;
                this.o.a((TroopChatPie)localObject2, (MessageForTroopEffectPic)localObject3, false);
              }
            }
            else
            {
              if ((this.d.containsKey(localObject5)) && (((Integer)this.d.get(localObject5)).intValue() == 4))
              {
                a((String)localObject2, (String)localObject5);
                this.a = 1;
                a(paramBoolean);
                return;
              }
              a((MessageForTroopEffectPic)localObject3, false);
              this.a = 3;
            }
          }
        }
      }
    }
  }
  
  protected boolean a()
  {
    return b.equals(this.i);
  }
  
  public boolean a(MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    if (!a()) {
      return false;
    }
    h();
    if (b(paramMessageForDeliverGiftTips))
    {
      j();
      return true;
    }
    return false;
  }
  
  public boolean a(MessageForDeliverGiftTips paramMessageForDeliverGiftTips, boolean paramBoolean)
  {
    if (paramMessageForDeliverGiftTips == null) {
      return false;
    }
    if (!TroopGiftUtil.c(paramMessageForDeliverGiftTips)) {
      return false;
    }
    a(paramMessageForDeliverGiftTips);
    if (paramMessageForDeliverGiftTips.interactState == 2) {
      j();
    } else {
      ((TroopGiftManager)this.p.getManager(QQManagerFactory.TROOP_GIFT_MANAGER)).a(paramMessageForDeliverGiftTips.frienduin, paramMessageForDeliverGiftTips.interactId, paramMessageForDeliverGiftTips.giftId, new AIOAnimationControlManager.2(this, paramMessageForDeliverGiftTips, paramBoolean));
    }
    return true;
  }
  
  public boolean a(MessageForTroopEffectPic paramMessageForTroopEffectPic, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(paramMessageForTroopEffectPic.effectId);
    localObject = ((StringBuilder)localObject).toString();
    int i2 = paramMessageForTroopEffectPic.effectId;
    int i1 = 3;
    boolean bool = false;
    if ((i2 >= 40003) && (paramMessageForTroopEffectPic.effectId <= 40005))
    {
      if ((this.d.containsKey(localObject)) && (((Integer)this.d.get(localObject)).intValue() == 3))
      {
        if (TroopGiftUtil.c(paramMessageForTroopEffectPic.effectId)) {
          break label160;
        }
        this.d.remove(localObject);
        FileUtils.deleteFile(TroopGiftUtil.a(paramMessageForTroopEffectPic.effectId));
        a(paramMessageForTroopEffectPic.effectId, paramMessageForTroopEffectPic.frienduin, paramMessageForTroopEffectPic);
      }
      else
      {
        a(paramMessageForTroopEffectPic.effectId, paramMessageForTroopEffectPic.frienduin, paramMessageForTroopEffectPic);
      }
      i1 = 2;
      label160:
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("MessageForTroopEffectPic id:");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(",state:");
        localStringBuilder.append(i1);
        QLog.d("AIOAnimationControlManager", 2, localStringBuilder.toString());
      }
      if (paramBoolean) {
        return a(paramMessageForTroopEffectPic, false);
      }
      paramBoolean = bool;
      if (i1 == 2) {
        paramBoolean = true;
      }
      return paramBoolean;
    }
    this.d.put(localObject, Integer.valueOf(3));
    if (paramBoolean) {
      return a(paramMessageForTroopEffectPic, false);
    }
    return false;
  }
  
  public boolean a(AIOAnimationControlManager.IAnimationMessage paramIAnimationMessage, boolean paramBoolean)
  {
    if (paramIAnimationMessage == null) {
      return false;
    }
    if (((paramIAnimationMessage instanceof MessageForDeliverGiftTips)) && (!TroopGiftUtil.c((MessageForDeliverGiftTips)paramIAnimationMessage))) {
      return false;
    }
    a(paramIAnimationMessage);
    if (paramBoolean)
    {
      setChanged();
      notifyObservers(paramIAnimationMessage);
    }
    return true;
  }
  
  public boolean a(String paramString)
  {
    List localList = (List)this.n.get(paramString);
    if ((localList != null) && (!localList.isEmpty())) {
      return true;
    }
    paramString = (List)this.e.get(paramString);
    return (paramString != null) && (paramString.size() != 0);
  }
  
  public void b(String paramString)
  {
    List localList = (List)this.e.remove(paramString);
    if (localList != null) {
      localList.clear();
    }
    paramString = (List)this.n.remove(paramString);
    if (paramString != null) {
      paramString.clear();
    }
  }
  
  public void b(Observer paramObserver)
  {
    AIOAnimationControlManager.DownloadGiftResStateObservable.a().deleteObserver(paramObserver);
  }
  
  public boolean b()
  {
    int i1 = this.a;
    boolean bool = true;
    if (i1 != 1)
    {
      if (i1 == 4) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public boolean b(MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    boolean bool2 = TroopGiftUtil.c(paramMessageForDeliverGiftTips);
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    Object localObject = TroopGiftUtil.b(paramMessageForDeliverGiftTips);
    int i1;
    if ((this.d.containsKey(localObject)) && (((Integer)this.d.get(localObject)).intValue() == 3))
    {
      if (!TroopGiftUtil.b((String)localObject, paramMessageForDeliverGiftTips.animationType, paramMessageForDeliverGiftTips.isInteract()))
      {
        this.d.remove(localObject);
        FileUtils.deleteDirectory(TroopGiftUtil.a(paramMessageForDeliverGiftTips));
        a((String)localObject, paramMessageForDeliverGiftTips);
        i1 = 2;
      }
      else
      {
        i1 = 3;
      }
    }
    else
    {
      a((String)localObject, paramMessageForDeliverGiftTips);
      i1 = 4;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("giftRealAnimationId:");
      ((StringBuilder)localObject).append(TroopGiftUtil.b(paramMessageForDeliverGiftTips));
      ((StringBuilder)localObject).append(",state:");
      ((StringBuilder)localObject).append(i1);
      QLog.d("AIOAnimationControlManager", 2, ((StringBuilder)localObject).toString());
    }
    if ((!a()) || (i1 == 3))
    {
      if (paramMessageForDeliverGiftTips.isInteract()) {
        return a(paramMessageForDeliverGiftTips, false);
      }
      bool1 = a(paramMessageForDeliverGiftTips, false);
    }
    return bool1;
  }
  
  public boolean b(boolean paramBoolean)
  {
    long l1 = this.v;
    boolean bool2 = false;
    boolean bool1;
    if (l1 == 0L)
    {
      bool1 = bool2;
      if (paramBoolean)
      {
        this.v = System.currentTimeMillis();
        this.w = 1;
        bool1 = bool2;
      }
    }
    else if (System.currentTimeMillis() - this.v < 3600000L)
    {
      c = this.x.getInt("AIOAnimationControlManager_limit_gif_count_MAX", c);
      int i1 = this.w;
      if (i1 >= c)
      {
        this.a = 4;
        bool1 = true;
      }
      else
      {
        bool1 = bool2;
        if (paramBoolean)
        {
          this.w = (i1 + 1);
          bool1 = bool2;
        }
      }
    }
    else
    {
      bool1 = bool2;
      if (paramBoolean)
      {
        this.v = System.currentTimeMillis();
        this.w = 1;
        bool1 = bool2;
      }
    }
    SharedPreferences localSharedPreferences = this.x;
    if ((localSharedPreferences != null) && (paramBoolean))
    {
      localSharedPreferences.edit().putLong("AIOAnimationControlManager_limit_gif_time", this.v).apply();
      this.x.edit().putInt("AIOAnimationControlManager_limit_gif_count", this.w).apply();
    }
    return bool1;
  }
  
  protected void c()
  {
    Object localObject = new File(TroopGiftUtil.a(0)).getParentFile();
    if (((File)localObject).exists())
    {
      localObject = ((File)localObject).listFiles();
      if (localObject != null)
      {
        int i1 = 0;
        while (i1 < localObject.length)
        {
          if (localObject[i1].exists())
          {
            String str = localObject[i1].getName();
            try
            {
              str = str.substring(0, str.indexOf(".mp4"));
              if (TroopGiftUtil.c(Integer.parseInt(str))) {
                this.d.put(str, Integer.valueOf(3));
              } else {
                localObject[i1].delete();
              }
            }
            catch (Exception localException)
            {
              if (QLog.isColorLevel())
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("checkPicEffectPackageIdState: ");
                localStringBuilder.append(QLog.getStackTraceString(localException));
                QLog.e("AIOAnimationControlManager", 2, localStringBuilder.toString());
              }
            }
          }
          i1 += 1;
        }
      }
    }
  }
  
  public void c(String paramString)
  {
    TroopGiftData localTroopGiftData = new TroopGiftData();
    localTroopGiftData.giftData = new TroopGiftData.GiftDataBean();
    localTroopGiftData.giftData.dataForClient = ((TroopGiftData.GiftDataBean.DataForClientBean)new Gson().fromJson(paramString, TroopGiftData.GiftDataBean.DataForClientBean.class));
    if (e() == null)
    {
      paramString = BaseActivity.sTopActivity;
      if (paramString != null)
      {
        paramString = paramString.getChatFragment();
        if (paramString != null) {
          a(paramString.k());
        }
      }
    }
    this.p.runOnUiThread(new AIOAnimationControlManager.5(this, localTroopGiftData));
  }
  
  public void d()
  {
    Object localObject = this.g;
    if (localObject != null) {
      localObject = ((BaseChatPie)localObject).ah.b;
    } else {
      localObject = this.i;
    }
    localObject = (List)this.e.get(localObject);
    if ((this.q) && (!TroopGiftUtil.a((List)localObject)))
    {
      int i2;
      for (int i1 = 0; i1 < ((List)localObject).size(); i1 = i2 + 1)
      {
        AIOAnimationControlManager.IAnimationMessage localIAnimationMessage = (AIOAnimationControlManager.IAnimationMessage)((List)localObject).get(i1);
        i2 = i1;
        if (localIAnimationMessage.isReaded())
        {
          i2 = i1;
          if (localIAnimationMessage.getSenderUin() != this.p.getLongAccountUin())
          {
            ((List)localObject).remove(i1);
            i2 = i1 - 1;
          }
        }
      }
      Collections.sort((List)localObject, this.r);
    }
    this.q = true;
  }
  
  public boolean d(String paramString)
  {
    return (!this.d.containsKey(paramString)) || (((Integer)this.d.get(paramString)).intValue() != 3);
  }
  
  public BaseChatPie e()
  {
    return this.g;
  }
  
  public long[] e(String paramString)
  {
    Object localObject = (List)this.e.get(paramString);
    paramString = new ArrayList();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        AIOAnimationControlManager.IAnimationMessage localIAnimationMessage = (AIOAnimationControlManager.IAnimationMessage)((Iterator)localObject).next();
        if ((localIAnimationMessage instanceof MessageForDeliverGiftTips)) {
          paramString.add(Long.valueOf(((MessageForDeliverGiftTips)localIAnimationMessage).getId()));
        }
      }
    }
    localObject = new long[paramString.size()];
    int i1 = 0;
    while (i1 < paramString.size())
    {
      localObject[i1] = ((Long)paramString.get(i1)).longValue();
      i1 += 1;
    }
    return localObject;
  }
  
  public void f()
  {
    deleteObservers();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("release TroopChatPie ,troopUin:");
      localStringBuilder.append(this.i);
      QLog.d("AIOAnimationControlManager", 2, localStringBuilder.toString());
    }
    AIOAnimationControlManager.DownloadGiftResStateObservable.a().deleteObservers();
    this.e.remove(this.i);
    this.n.remove(this.i);
    this.g = null;
    this.f = null;
    this.a = 1;
    this.m = null;
  }
  
  public void g()
  {
    AIOAnimationControlManager.DownloadGiftResStateObservable.a().deleteObservers();
    this.h = null;
    this.e.remove(this.i);
    this.n.remove(this.i);
    this.f = null;
    this.a = 1;
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAnimationControlManager", 2, "releaseAnimationList");
    }
    Object localObject = this.g;
    if (localObject != null) {
      localObject = ((BaseChatPie)localObject).ah.b;
    } else {
      localObject = this.i;
    }
    this.e.remove(localObject);
    this.n.remove(localObject);
    localObject = this.f;
    if (localObject != null)
    {
      ((TroopGiftAnimationController)localObject).d();
      this.a = 1;
    }
  }
  
  public DownloaderInterface i()
  {
    return ((DownloaderFactory)this.p.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
  }
  
  public void j()
  {
    a(false);
  }
  
  public void k()
  {
    if (RobotResourcesManager.a().d()) {
      RobotResourcesManager.a().c();
    }
    Object localObject = this.f;
    if ((localObject != null) && (((TroopGiftAnimationController)localObject).c())) {
      this.f.d();
    }
    localObject = this.m;
    if ((localObject != null) && (!((TroopInteractGiftAnimationController)localObject).b())) {
      this.m.a();
    }
    localObject = this.o;
    if (localObject != null) {
      ((TroopPicEffectsController)localObject).a();
    }
    this.a = 1;
  }
  
  public void onDestroy()
  {
    AIOAnimationControlManager.DownloadGiftResStateObservable.a().deleteObservers();
    if ((this.p != null) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("clear History. uin:");
      localStringBuilder.append(this.p.getAccount());
      localStringBuilder.append(" app=");
      localStringBuilder.append(String.valueOf(this.p));
      QLog.d("AIOAnimationControlManager", 2, localStringBuilder.toString());
    }
    this.g = null;
    this.h = null;
    this.j = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AIOAnimationControlManager
 * JD-Core Version:    0.7.0.1
 */