package com.tencent.mobileqq.troop.utils;

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
import com.tencent.mobileqq.troopgift.TroopGiftAnimationController;
import com.tencent.mobileqq.troopgift.TroopGiftAnimationController.OnCleanAnimationListener;
import com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectsController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
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
  public static final String a;
  public static volatile boolean a;
  public static int b;
  public int a;
  private long jdField_a_of_type_Long;
  Activity jdField_a_of_type_AndroidAppActivity;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  Handler jdField_a_of_type_AndroidOsHandler;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface = null;
  BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  FrameSprite.OnFrameEndListener jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener = new AIOAnimationControlManager.16(this);
  public AIOAnimationControlManager.OnAnimationPlayEndListener a;
  TroopGiftAnimationController.OnCleanAnimationListener jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$OnCleanAnimationListener = new AIOAnimationControlManager.15(this);
  TroopGiftAnimationController jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController;
  protected TroopInteractGiftAnimationController a;
  TroopPicEffectsController jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsController;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new AIOAnimationControlManager.4(this);
  public Comparator<AIOAnimationControlManager.IAnimationMessage> a;
  HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  String jdField_b_of_type_JavaLangString;
  HashMap<String, List<AIOAnimationControlManager.IAnimationMessage>> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  public volatile boolean b;
  private int jdField_c_of_type_Int;
  protected HashMap<String, List<MessageForDeliverGiftTips>> c;
  private boolean jdField_c_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_JavaLangString = String.valueOf(10000L);
    jdField_b_of_type_Int = 9;
    jdField_a_of_type_Boolean = false;
  }
  
  public AIOAnimationControlManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_c_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilComparator = new AIOAnimationControlManager.3(this);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    a(paramAppInterface);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  private void a(AppInterface paramAppInterface)
  {
    if ((paramAppInterface != null) && ((paramAppInterface instanceof BrowserAppInterface)))
    {
      h();
      return;
    }
    ThreadManager.post(new AIOAnimationControlManager.1(this), 8, null, true);
  }
  
  public static void a(BaseChatPie paramBaseChatPie, boolean paramBoolean)
  {
    if (((paramBaseChatPie.a() instanceof SplashActivity)) && (SplashActivity.currentFragment != 2)) {
      return;
    }
    AIOAnimationControlManager localAIOAnimationControlManager = (AIOAnimationControlManager)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
    localAIOAnimationControlManager.a(paramBaseChatPie);
    if (paramBoolean) {
      localAIOAnimationControlManager.b();
    }
    localAIOAnimationControlManager.a(paramBaseChatPie.a().getSharedPreferences("AIOAnimationControlManager_limit_key", 4));
    if (QLog.isColorLevel()) {
      QLog.d(".troop.send_gift", 2, "playTroopGiftAnimationPlayList");
    }
    paramBaseChatPie.a().post(new AIOAnimationControlManager.17(localAIOAnimationControlManager, paramBoolean));
  }
  
  private void a(AIOAnimationControlManager.IAnimationMessage paramIAnimationMessage)
  {
    List localList = (List)this.jdField_b_of_type_JavaUtilHashMap.get(paramIAnimationMessage.getFriendUin());
    localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this.jdField_b_of_type_JavaUtilHashMap.put(paramIAnimationMessage.getFriendUin(), localObject);
    }
    try
    {
      ((List)localObject).add(paramIAnimationMessage);
      i1 = paramIAnimationMessage.getLimitType();
      i = 0;
      m = 0;
      j = -1;
    }
    finally
    {
      for (;;)
      {
        int i1;
        int i;
        int k;
        for (;;)
        {
          throw paramIAnimationMessage;
        }
        int n = m + 1;
        i += 1;
        int m = n;
        int j = k;
      }
    }
    if (i < ((List)localObject).size())
    {
      paramIAnimationMessage = (AIOAnimationControlManager.IAnimationMessage)((List)localObject).get(i);
      n = m;
      k = j;
      if (paramIAnimationMessage == null) {
        break label187;
      }
      n = m;
      k = j;
      if (paramIAnimationMessage.getLimitType() != i1) {
        break label187;
      }
      k = j;
      if (j == -1) {
        k = i;
      }
    }
    else
    {
      if (m > a(i1)) {
        ((List)localObject).remove(j);
      }
      return;
    }
  }
  
  private void a(String paramString, MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    if ((!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) || (((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).intValue() == 4))
    {
      Object localObject2 = new File(TroopGiftUtil.a(paramString, paramMessageForDeliverGiftTips.animationType, paramMessageForDeliverGiftTips.isInteract()));
      Object localObject1 = new Bundle();
      ((Bundle)localObject1).putString("GiftAnimationId", paramString);
      ((Bundle)localObject1).putString("TroopUin", paramMessageForDeliverGiftTips.frienduin);
      ((Bundle)localObject1).putInt("GiftAnimationType", paramMessageForDeliverGiftTips.animationType);
      ((Bundle)localObject1).putBoolean("GiftIsInteract", paramMessageForDeliverGiftTips.isInteract());
      localObject2 = new DownloadTask(TroopGiftUtil.c(paramMessageForDeliverGiftTips), (File)localObject2);
      ((DownloadTask)localObject2).jdField_b_of_type_Int = 2;
      if ((paramMessageForDeliverGiftTips instanceof MessageForTroopGift)) {
        ((MessageForTroopGift)paramMessageForDeliverGiftTips).isLoading = true;
      }
      a().startDownload((DownloadTask)localObject2, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, (Bundle)localObject1);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("start Download PackageId:");
        ((StringBuilder)localObject1).append(TroopGiftUtil.b(paramMessageForDeliverGiftTips));
        QLog.d("AIOAnimationControlManager", 2, ((StringBuilder)localObject1).toString());
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(2));
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    List localList = (List)this.jdField_b_of_type_JavaUtilHashMap.get(paramString1);
    if (paramString2 != null)
    {
      if (localList == null) {
        return;
      }
      int i = 0;
      while (i < localList.size())
      {
        AIOAnimationControlManager.IAnimationMessage localIAnimationMessage = (AIOAnimationControlManager.IAnimationMessage)localList.get(i);
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
          localList.remove(i);
        }
        i += 1;
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
        if (((paramBaseChatPie.a() instanceof SplashActivity)) && (SplashActivity.currentFragment != 2)) {
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
  
  private void b(String paramString1, String paramString2)
  {
    paramString1 = (List)this.jdField_c_of_type_JavaUtilHashMap.get(paramString1);
    if (paramString2 != null)
    {
      if (paramString1 == null) {
        return;
      }
      int i = 0;
      while (i < paramString1.size())
      {
        if (paramString2.equals(TroopGiftUtil.b((MessageForDeliverGiftTips)paramString1.get(i)))) {
          paramString1.remove(i);
        }
        i += 1;
      }
    }
  }
  
  private void h()
  {
    Object localObject = new File(AppConstants.SDCARD_GIFT_SAVE);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    File[] arrayOfFile = ((File)localObject).listFiles();
    if (arrayOfFile != null)
    {
      int i = 0;
      while (i < arrayOfFile.length)
      {
        if ((arrayOfFile[i].exists()) && (arrayOfFile[i].isDirectory()))
        {
          String str = arrayOfFile[i].getName();
          boolean bool = arrayOfFile[i].getName().endsWith("_HD");
          int j = 1;
          if (bool) {
            localObject = str.substring(0, str.length() - 3);
          }
          do
          {
            bool = false;
            j = 0;
            break;
            if (arrayOfFile[i].getName().endsWith("_V"))
            {
              localObject = str.substring(0, str.length() - 2);
              bool = false;
              break;
            }
            localObject = str;
          } while (!arrayOfFile[i].getName().endsWith("_NEW"));
          localObject = str.substring(0, str.length() - 4);
          bool = true;
          if (TroopGiftUtil.a((String)localObject, j, bool))
          {
            this.jdField_a_of_type_JavaUtilHashMap.put(localObject, Integer.valueOf(3));
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("Package Downloaded:");
              ((StringBuilder)localObject).append(arrayOfFile[i].getName());
              QLog.d("AIOAnimationControlManager", 2, ((StringBuilder)localObject).toString());
            }
          }
          else
          {
            FileUtils.deleteDirectory(arrayOfFile[i].getAbsolutePath());
          }
        }
        i += 1;
      }
    }
  }
  
  public int a(int paramInt)
  {
    if (paramInt == 0) {
      return 1;
    }
    if ((1 == paramInt) && ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof BaseQQAppInterface))) {
      return ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).getSpecifyHbAniMaxSize((BaseQQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
    return 0;
  }
  
  public BaseChatPie a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  }
  
  public DownloaderInterface a()
  {
    return ((DownloaderFactory)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
  }
  
  protected void a()
  {
    Object localObject = new File(TroopGiftUtil.a(0)).getParentFile();
    if (((File)localObject).exists())
    {
      localObject = ((File)localObject).listFiles();
      if (localObject != null)
      {
        int i = 0;
        while (i < localObject.length)
        {
          if (localObject[i].exists())
          {
            String str = localObject[i].getName();
            try
            {
              str = str.substring(0, str.indexOf(".mp4"));
              if (TroopGiftUtil.a(Integer.parseInt(str))) {
                this.jdField_a_of_type_JavaUtilHashMap.put(str, Integer.valueOf(3));
              } else {
                localObject[i].delete();
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
          i += 1;
        }
      }
    }
  }
  
  public void a(int paramInt, String paramString, MessageForTroopEffectPic paramMessageForTroopEffectPic)
  {
    paramMessageForTroopEffectPic = new StringBuilder();
    paramMessageForTroopEffectPic.append("");
    paramMessageForTroopEffectPic.append(paramInt);
    paramMessageForTroopEffectPic = paramMessageForTroopEffectPic.toString();
    Object localObject1 = this.jdField_a_of_type_JavaUtilHashMap;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(paramInt);
    if ((!((HashMap)localObject1).containsKey(((StringBuilder)localObject2).toString())) || (((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramMessageForTroopEffectPic)).intValue() == 4))
    {
      localObject2 = new File(TroopGiftUtil.a(paramInt));
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("GiftAnimationId", paramMessageForTroopEffectPic);
      ((Bundle)localObject1).putString("TroopUin", paramString);
      paramString = new DownloadTask(TroopGiftUtil.b(paramInt), (File)localObject2);
      paramString.jdField_b_of_type_Int = 2;
      a().startDownload(paramString, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, (Bundle)localObject1);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramMessageForTroopEffectPic, Integer.valueOf(2));
    }
  }
  
  public void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController == null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController = new TroopGiftAnimationController(null, paramActivity, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.a(4);
    this.jdField_a_of_type_AndroidAppActivity = this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.a();
    this.jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaLangString;
  }
  
  public void a(SharedPreferences paramSharedPreferences)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramSharedPreferences;
    this.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("AIOAnimationControlManager_limit_gif_time", 0L);
    this.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("AIOAnimationControlManager_limit_gif_count", 0);
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("set TroopChatPie ,troopUin:");
      localStringBuilder.append(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      QLog.d("AIOAnimationControlManager", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != paramBaseChatPie)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
      addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController = ((GiftPanelHelper)paramBaseChatPie.a(136)).a();
      paramBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
      if ((paramBaseChatPie instanceof TroopChatPie))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.a(1);
        this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController = ((TroopGiftPanelHelper)((TroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie).a(136)).a();
        this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsController = ((TroopEffectHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(134)).a();
        return;
      }
      if ((paramBaseChatPie instanceof HotChatPie))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.a(4);
        return;
      }
      if ((paramBaseChatPie instanceof NearbyChatPie))
      {
        if (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10002)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.a(8);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.a(6);
      }
    }
  }
  
  public void a(TroopGiftData paramTroopGiftData, boolean paramBoolean)
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
    Object localObject = new String[2];
    localObject[0] = paramTroopGiftData.giftData.dataForClient.continueAnimationAnd;
    localObject[1] = paramTroopGiftData.giftData.dataForClient.giftResourceAnd;
    if (TroopGiftResManager.a.a((String[])localObject))
    {
      a(paramTroopGiftData);
      if (paramBoolean) {
        f();
      }
    }
    else
    {
      this.jdField_a_of_type_Int = 3;
      TroopGiftResManager.a.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getBaseContext(), (String[])localObject, new AIOAnimationControlManager.6(this, paramTroopGiftData, paramBoolean));
    }
  }
  
  public void a(String paramString)
  {
    List localList = (List)this.jdField_b_of_type_JavaUtilHashMap.remove(paramString);
    if (localList != null) {
      localList.clear();
    }
    paramString = (List)this.jdField_c_of_type_JavaUtilHashMap.remove(paramString);
    if (paramString != null) {
      paramString.clear();
    }
  }
  
  public void a(String paramString, boolean paramBoolean, long paramLong)
  {
    paramString = (TroopGiftData)new Gson().fromJson(paramString, TroopGiftData.class);
    paramString.setReaded(paramBoolean);
    paramString.setShmsgseq(paramLong);
    a(paramString, false);
  }
  
  public void a(Observer paramObserver)
  {
    AIOAnimationControlManager.DownloadGiftResStateObservable.a().addObserver(paramObserver);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) && (this.jdField_a_of_type_AndroidAppActivity == null) && (!jdField_a_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString))) {
      return;
    }
    this.jdField_c_of_type_Boolean = paramBoolean;
    Object localObject1;
    if (jdField_a_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString))
    {
      localObject1 = this.jdField_b_of_type_JavaLangString;
    }
    else
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
      if (localObject1 != null) {
        localObject1 = ((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      } else {
        localObject1 = this.jdField_b_of_type_JavaLangString;
      }
    }
    Object localObject5 = (List)this.jdField_c_of_type_JavaUtilHashMap.get(localObject1);
    Object localObject4 = (List)this.jdField_b_of_type_JavaUtilHashMap.get(localObject1);
    if ((!b()) && (TroopGiftUtil.a((List)localObject5))) {
      return;
    }
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localObject3 != null) {
      localObject3 = (AIOEmoticonUIHelper)((BaseChatPie)localObject3).a(105);
    } else {
      localObject3 = null;
    }
    Object localObject6;
    Object localObject7;
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController != null) && (!TroopGiftUtil.a((List)localObject5)))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController.b()) && (this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController.a())) {
        return;
      }
      this.jdField_a_of_type_Int = 2;
      localObject6 = (MessageForDeliverGiftTips)((List)localObject5).get(0);
      localObject7 = TroopGiftUtil.b((MessageForDeliverGiftTips)localObject6);
      if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject7)) && (((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(localObject7)).intValue() == 3))
      {
        if ((localObject3 != null) && (((AIOEmoticonUIHelper)localObject3).a() != null) && (((AIOEmoticonUIHelper)localObject3).a().a != null) && (((AIOEmoticonUIHelper)localObject3).a().a.a()))
        {
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AIOAnimationControlManager.7(this, paramBoolean), 500L);
          return;
        }
        if (((MessageForDeliverGiftTips)localObject6).interactState != 2) {
          ((TroopGiftManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.TROOP_GIFT_MANAGER)).a(((MessageForDeliverGiftTips)localObject6).frienduin, ((MessageForDeliverGiftTips)localObject6).interactId, ((MessageForDeliverGiftTips)localObject6).giftId, new AIOAnimationControlManager.8(this, (MessageForDeliverGiftTips)localObject6, (List)localObject5, paramBoolean, (List)localObject4, (String)localObject7));
        }
      }
      else
      {
        if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject7)) && (((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(localObject7)).intValue() == 4))
        {
          b((String)localObject1, (String)localObject7);
          this.jdField_a_of_type_Int = 1;
          a(paramBoolean);
          return;
        }
        this.jdField_a_of_type_Int = 3;
      }
    }
    else if ((this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController != null) && (!TroopGiftUtil.a((List)localObject4)))
    {
      this.jdField_a_of_type_Int = 2;
      localObject5 = (AIOAnimationControlManager.IAnimationMessage)((List)localObject4).get(0);
      if ((localObject5 instanceof TroopGiftData))
      {
        QLog.d("AIOAnimationControlManager", 1, "animationMessage instanceof TroopGiftData");
        this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.a((TroopGiftData)localObject5, new AIOAnimationControlManager.9(this, (AIOAnimationControlManager.IAnimationMessage)localObject5));
      }
      if ((localObject5 instanceof MessageForDeliverGiftTips))
      {
        localObject5 = (MessageForDeliverGiftTips)localObject5;
        if ((((MessageForDeliverGiftTips)localObject5).isToAll()) && (!((MessageForDeliverGiftTips)localObject5).hasFetchButFailed))
        {
          localObject6 = ((TroopGiftManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.TROOP_GIFT_MANAGER)).a((String)localObject1, ((MessageForDeliverGiftTips)localObject5).bagId, new AIOAnimationControlManager.10(this, (MessageForDeliverGiftTips)localObject5, (String)localObject1, paramBoolean));
          if (localObject6 == null)
          {
            this.jdField_a_of_type_Int = 1;
            return;
          }
          if ((((TroopGiftBagInfo)localObject6).hasGrab()) && (((TroopGiftBagInfo)localObject6).myGrabResult != null))
          {
            ((MessageForDeliverGiftTips)localObject5).showButton = false;
            ((MessageForDeliverGiftTips)localObject5).resultText = ((TroopGiftBagInfo)localObject6).myGrabResult.jdField_a_of_type_JavaLangString;
            ((MessageForDeliverGiftTips)localObject5).resultType = 0;
          }
          else if (((TroopGiftBagInfo)localObject6).myGrabResult != null)
          {
            ((MessageForDeliverGiftTips)localObject5).showButton = false;
            ((MessageForDeliverGiftTips)localObject5).resultText = ((TroopGiftBagInfo)localObject6).myGrabResult.jdField_a_of_type_JavaLangString;
            ((MessageForDeliverGiftTips)localObject5).resultType = 1;
          }
          else
          {
            ((MessageForDeliverGiftTips)localObject5).showButton = true;
          }
          localObject6 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
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
        if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject6)) && (((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(localObject6)).intValue() == 3))
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener);
          if (QLog.isColorLevel())
          {
            localObject7 = new StringBuilder();
            ((StringBuilder)localObject7).append("Playing! playMaigface id:");
            ((StringBuilder)localObject7).append(TroopGiftUtil.b((MessageForDeliverGiftTips)localObject5));
            QLog.d("AIOAnimationControlManager", 2, ((StringBuilder)localObject7).toString());
          }
          if ((localObject3 != null) && (((AIOEmoticonUIHelper)localObject3).a() != null) && (((AIOEmoticonUIHelper)localObject3).a().a != null) && (((AIOEmoticonUIHelper)localObject3).a().a.a()))
          {
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AIOAnimationControlManager.11(this, paramBoolean), 500L);
            return;
          }
          if (RobotResourcesManager.a().a()) {
            RobotResourcesManager.a().b();
          }
          if (!TextUtils.isEmpty(((MessageForDeliverGiftTips)localObject5).interactId))
          {
            ((List)localObject4).remove(localObject5);
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController;
            if (localObject1 != null) {
              ((TroopInteractGiftAnimationController)localObject1).a((MessageForDeliverGiftTips)localObject5, (String)localObject6, false, new AIOAnimationControlManager.12(this, paramBoolean));
            }
          }
          else
          {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) {
              localObject3 = "0";
            } else {
              localObject3 = "1";
            }
            localObject4 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
            if (localObject4 != null) {
              localObject4 = ((BaseChatPie)localObject4).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            } else {
              localObject4 = null;
            }
            localObject7 = new StringBuilder();
            ((StringBuilder)localObject7).append("");
            AppInterface localAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
            ((StringBuilder)localObject7).append(TroopMemberUtil.a(localAppInterface, localAppInterface.getCurrentAccountUin(), (String)localObject1));
            ReportController.b((AppRuntime)localObject4, "P_CliOper", "Grp_flower", "", "cartoon", "show", 0, 0, (String)localObject1, (String)localObject6, (String)localObject3, ((StringBuilder)localObject7).toString());
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("Check isLimitGiftAnim: isEnterAIO:");
              ((StringBuilder)localObject1).append(paramBoolean);
              ((StringBuilder)localObject1).append(", isToMeGift:");
              boolean bool;
              if (((MessageForDeliverGiftTips)localObject5).receiverUin != this.jdField_a_of_type_ComTencentCommonAppAppInterface.getLongAccountUin()) {
                bool = true;
              } else {
                bool = false;
              }
              ((StringBuilder)localObject1).append(bool);
              ((StringBuilder)localObject1).append(", count:");
              ((StringBuilder)localObject1).append(this.jdField_c_of_type_Int);
              ((StringBuilder)localObject1).append(", time:");
              ((StringBuilder)localObject1).append(this.jdField_a_of_type_Long);
              QLog.d("AIOAnimationControlManager", 2, ((StringBuilder)localObject1).toString());
            }
            if ((paramBoolean) && (((MessageForDeliverGiftTips)localObject5).receiverUin != this.jdField_a_of_type_ComTencentCommonAppAppInterface.getLongAccountUin()) && (a(true)))
            {
              localObject1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
              if ((localObject1 instanceof QQAppInterface))
              {
                localObject1 = (QQAppInterface)localObject1;
                localObject3 = ((QQAppInterface)localObject1).getProxyManager().a().a(false).iterator();
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
                    ((QQAppInterface)localObject1).getMessageFacade().a().a(((RecentUser)localObject4).uin, ((RecentUser)localObject4).getType(), true, false);
                  }
                }
              }
              return;
            }
            this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.a((MessageForDeliverGiftTips)localObject5);
            this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$OnCleanAnimationListener = this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$OnCleanAnimationListener;
          }
        }
        else
        {
          if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject6)) && (((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(localObject6)).intValue() == 4))
          {
            a((String)localObject1, (String)localObject6);
            this.jdField_a_of_type_Int = 1;
            a(paramBoolean);
            return;
          }
          this.jdField_a_of_type_Int = 3;
        }
      }
      else
      {
        if ((localObject5 instanceof ISpecifyRedPacketAnimMsg))
        {
          localObject1 = (ISpecifyRedPacketAnimMsg)localObject5;
          this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.a((ISpecifyRedPacketAnimMsg)localObject1);
          ((ISpecifyRedPacketAnimMsg)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, new AIOAnimationControlManager.13(this, paramBoolean));
          ((List)localObject4).remove(localObject5);
          return;
        }
        if (((localObject5 instanceof MessageForTroopEffectPic)) && (this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsController != null))
        {
          localObject3 = (MessageForTroopEffectPic)localObject5;
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("");
          ((StringBuilder)localObject5).append(((MessageForTroopEffectPic)localObject3).effectId);
          localObject5 = ((StringBuilder)localObject5).toString();
          if ((((MessageForTroopEffectPic)localObject3).effectId < 40003) || (((MessageForTroopEffectPic)localObject3).effectId > 40005)) {
            this.jdField_a_of_type_JavaUtilHashMap.put(localObject5, Integer.valueOf(3));
          }
          Object localObject2;
          if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject5)) && (((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(localObject5)).intValue() == 3) && (TroopGiftUtil.a(((MessageForTroopEffectPic)localObject3).effectId)))
          {
            localObject1 = ((MessageForTroopEffectPic)localObject3).getPicDownloadInfo();
            ((PicDownloadInfo)localObject1).e = "chatimg";
            localObject1 = ((PicDownloadInfo)localObject1).c();
            localObject6 = new File((String)localObject1);
            localObject5 = new BitmapFactory.Options();
            int i = JpegExifReader.readOrientation((String)localObject1);
            if (i != 3)
            {
              if (i != 6)
              {
                if (i != 8) {
                  i = 0;
                } else {
                  i = 270;
                }
              }
              else {
                i = 90;
              }
            }
            else {
              i = 180;
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
                  ((Matrix)localObject5).setRotate(i);
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
              localObject5 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
              if ((localObject5 != null) && ((localObject5 instanceof TroopChatPie)))
              {
                localObject5 = (TroopChatPie)localObject5;
                this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsController.a(((MessageForTroopEffectPic)localObject3).effectId, (Bitmap)localObject2, ((TroopChatPie)localObject5).h, new AIOAnimationControlManager.14(this, paramBoolean));
                ((List)localObject4).remove(localObject3);
                return;
              }
            }
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
            if ((localObject2 != null) && ((localObject2 instanceof TroopChatPie)))
            {
              this.jdField_a_of_type_Int = 3;
              this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsController.a((TroopChatPie)localObject2, (MessageForTroopEffectPic)localObject3, false);
            }
          }
          else
          {
            if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject5)) && (((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(localObject5)).intValue() == 4))
            {
              a((String)localObject2, (String)localObject5);
              this.jdField_a_of_type_Int = 1;
              a(paramBoolean);
              return;
            }
            a((MessageForTroopEffectPic)localObject3, false);
            this.jdField_a_of_type_Int = 3;
          }
        }
      }
    }
  }
  
  protected boolean a()
  {
    return jdField_a_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString);
  }
  
  public boolean a(MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    if (!a()) {
      return false;
    }
    e();
    if (b(paramMessageForDeliverGiftTips))
    {
      f();
      return true;
    }
    return false;
  }
  
  public boolean a(MessageForDeliverGiftTips paramMessageForDeliverGiftTips, boolean paramBoolean)
  {
    if (paramMessageForDeliverGiftTips == null) {
      return false;
    }
    if (!TroopGiftUtil.a(paramMessageForDeliverGiftTips)) {
      return false;
    }
    a(paramMessageForDeliverGiftTips);
    if (paramMessageForDeliverGiftTips.interactState == 2) {
      f();
    } else {
      ((TroopGiftManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.TROOP_GIFT_MANAGER)).a(paramMessageForDeliverGiftTips.frienduin, paramMessageForDeliverGiftTips.interactId, paramMessageForDeliverGiftTips.giftId, new AIOAnimationControlManager.2(this, paramMessageForDeliverGiftTips, paramBoolean));
    }
    return true;
  }
  
  public boolean a(MessageForTroopEffectPic paramMessageForTroopEffectPic, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(paramMessageForTroopEffectPic.effectId);
    localObject = ((StringBuilder)localObject).toString();
    int j = paramMessageForTroopEffectPic.effectId;
    int i = 3;
    boolean bool = false;
    if ((j >= 40003) && (paramMessageForTroopEffectPic.effectId <= 40005))
    {
      if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject)) && (((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(localObject)).intValue() == 3))
      {
        if (TroopGiftUtil.a(paramMessageForTroopEffectPic.effectId)) {
          break label160;
        }
        this.jdField_a_of_type_JavaUtilHashMap.remove(localObject);
        FileUtils.deleteFile(TroopGiftUtil.a(paramMessageForTroopEffectPic.effectId));
        a(paramMessageForTroopEffectPic.effectId, paramMessageForTroopEffectPic.frienduin, paramMessageForTroopEffectPic);
      }
      else
      {
        a(paramMessageForTroopEffectPic.effectId, paramMessageForTroopEffectPic.frienduin, paramMessageForTroopEffectPic);
      }
      i = 2;
      label160:
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("MessageForTroopEffectPic id:");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(",state:");
        localStringBuilder.append(i);
        QLog.d("AIOAnimationControlManager", 2, localStringBuilder.toString());
      }
      if (paramBoolean) {
        return a(paramMessageForTroopEffectPic, false);
      }
      paramBoolean = bool;
      if (i == 2) {
        paramBoolean = true;
      }
      return paramBoolean;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(localObject, Integer.valueOf(3));
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
    if (((paramIAnimationMessage instanceof MessageForDeliverGiftTips)) && (!TroopGiftUtil.a((MessageForDeliverGiftTips)paramIAnimationMessage))) {
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
    List localList = (List)this.jdField_c_of_type_JavaUtilHashMap.get(paramString);
    if ((localList != null) && (!localList.isEmpty())) {
      return true;
    }
    paramString = (List)this.jdField_b_of_type_JavaUtilHashMap.get(paramString);
    return (paramString != null) && (paramString.size() != 0);
  }
  
  public boolean a(boolean paramBoolean)
  {
    long l = this.jdField_a_of_type_Long;
    boolean bool2 = false;
    boolean bool1;
    if (l == 0L)
    {
      bool1 = bool2;
      if (paramBoolean)
      {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        this.jdField_c_of_type_Int = 1;
        bool1 = bool2;
      }
    }
    else if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 3600000L)
    {
      jdField_b_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("AIOAnimationControlManager_limit_gif_count_MAX", jdField_b_of_type_Int);
      int i = this.jdField_c_of_type_Int;
      if (i >= jdField_b_of_type_Int)
      {
        this.jdField_a_of_type_Int = 4;
        bool1 = true;
      }
      else
      {
        bool1 = bool2;
        if (paramBoolean)
        {
          this.jdField_c_of_type_Int = (i + 1);
          bool1 = bool2;
        }
      }
    }
    else
    {
      bool1 = bool2;
      if (paramBoolean)
      {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        this.jdField_c_of_type_Int = 1;
        bool1 = bool2;
      }
    }
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_AndroidContentSharedPreferences;
    if ((localSharedPreferences != null) && (paramBoolean))
    {
      localSharedPreferences.edit().putLong("AIOAnimationControlManager_limit_gif_time", this.jdField_a_of_type_Long).apply();
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("AIOAnimationControlManager_limit_gif_count", this.jdField_c_of_type_Int).apply();
    }
    return bool1;
  }
  
  public long[] a(String paramString)
  {
    Object localObject = (List)this.jdField_b_of_type_JavaUtilHashMap.get(paramString);
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
    int i = 0;
    while (i < paramString.size())
    {
      localObject[i] = ((Long)paramString.get(i)).longValue();
      i += 1;
    }
    return localObject;
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localObject != null) {
      localObject = ((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    } else {
      localObject = this.jdField_b_of_type_JavaLangString;
    }
    localObject = (List)this.jdField_b_of_type_JavaUtilHashMap.get(localObject);
    if ((this.jdField_b_of_type_Boolean) && (!TroopGiftUtil.a((List)localObject)))
    {
      int j;
      for (int i = 0; i < ((List)localObject).size(); i = j + 1)
      {
        AIOAnimationControlManager.IAnimationMessage localIAnimationMessage = (AIOAnimationControlManager.IAnimationMessage)((List)localObject).get(i);
        j = i;
        if (localIAnimationMessage.isReaded())
        {
          j = i;
          if (localIAnimationMessage.getSenderUin() != this.jdField_a_of_type_ComTencentCommonAppAppInterface.getLongAccountUin())
          {
            ((List)localObject).remove(i);
            j = i - 1;
          }
        }
      }
      Collections.sort((List)localObject, this.jdField_a_of_type_JavaUtilComparator);
    }
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void b(String paramString)
  {
    TroopGiftData localTroopGiftData = new TroopGiftData();
    localTroopGiftData.giftData = new TroopGiftData.GiftDataBean();
    localTroopGiftData.giftData.dataForClient = ((TroopGiftData.GiftDataBean.DataForClientBean)new Gson().fromJson(paramString, TroopGiftData.GiftDataBean.DataForClientBean.class));
    if (a() == null)
    {
      paramString = BaseActivity.sTopActivity;
      if ((paramString instanceof BaseActivity)) {
        a(paramString.getChatFragment().a());
      }
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.runOnUiThread(new AIOAnimationControlManager.5(this, localTroopGiftData));
  }
  
  public void b(Observer paramObserver)
  {
    AIOAnimationControlManager.DownloadGiftResStateObservable.a().deleteObserver(paramObserver);
  }
  
  public boolean b()
  {
    int i = this.jdField_a_of_type_Int;
    boolean bool = true;
    if (i != 1)
    {
      if (i == 4) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public boolean b(MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    boolean bool2 = TroopGiftUtil.a(paramMessageForDeliverGiftTips);
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    Object localObject = TroopGiftUtil.b(paramMessageForDeliverGiftTips);
    int i;
    if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject)) && (((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(localObject)).intValue() == 3))
    {
      if (!TroopGiftUtil.a((String)localObject, paramMessageForDeliverGiftTips.animationType, paramMessageForDeliverGiftTips.isInteract()))
      {
        this.jdField_a_of_type_JavaUtilHashMap.remove(localObject);
        FileUtils.deleteDirectory(TroopGiftUtil.a(paramMessageForDeliverGiftTips));
        a((String)localObject, paramMessageForDeliverGiftTips);
        i = 2;
      }
      else
      {
        i = 3;
      }
    }
    else
    {
      a((String)localObject, paramMessageForDeliverGiftTips);
      i = 4;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("giftRealAnimationId:");
      ((StringBuilder)localObject).append(TroopGiftUtil.b(paramMessageForDeliverGiftTips));
      ((StringBuilder)localObject).append(",state:");
      ((StringBuilder)localObject).append(i);
      QLog.d("AIOAnimationControlManager", 2, ((StringBuilder)localObject).toString());
    }
    if ((!a()) || (i == 3))
    {
      if (paramMessageForDeliverGiftTips.isInteract()) {
        return a(paramMessageForDeliverGiftTips, false);
      }
      bool1 = a(paramMessageForDeliverGiftTips, false);
    }
    return bool1;
  }
  
  public boolean b(String paramString)
  {
    return (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) || (((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).intValue() != 3);
  }
  
  public void c()
  {
    deleteObservers();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("release TroopChatPie ,troopUin:");
      localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
      QLog.d("AIOAnimationControlManager", 2, localStringBuilder.toString());
    }
    AIOAnimationControlManager.DownloadGiftResStateObservable.a().deleteObservers();
    this.jdField_b_of_type_JavaUtilHashMap.remove(this.jdField_b_of_type_JavaLangString);
    this.jdField_c_of_type_JavaUtilHashMap.remove(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController = null;
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController = null;
  }
  
  public void d()
  {
    AIOAnimationControlManager.DownloadGiftResStateObservable.a().deleteObservers();
    this.jdField_a_of_type_AndroidAppActivity = null;
    this.jdField_b_of_type_JavaUtilHashMap.remove(this.jdField_b_of_type_JavaLangString);
    this.jdField_c_of_type_JavaUtilHashMap.remove(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController = null;
    this.jdField_a_of_type_Int = 1;
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAnimationControlManager", 2, "releaseAnimationList");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localObject != null) {
      localObject = ((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    } else {
      localObject = this.jdField_b_of_type_JavaLangString;
    }
    this.jdField_b_of_type_JavaUtilHashMap.remove(localObject);
    this.jdField_c_of_type_JavaUtilHashMap.remove(localObject);
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController;
    if (localObject != null)
    {
      ((TroopGiftAnimationController)localObject).c();
      this.jdField_a_of_type_Int = 1;
    }
  }
  
  public void f()
  {
    a(false);
  }
  
  public void g()
  {
    if (RobotResourcesManager.a().a()) {
      RobotResourcesManager.a().b();
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController;
    if ((localObject != null) && (((TroopGiftAnimationController)localObject).a())) {
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.c();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController;
    if ((localObject != null) && (!((TroopInteractGiftAnimationController)localObject).a())) {
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController.a();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsController;
    if (localObject != null) {
      ((TroopPicEffectsController)localObject).a();
    }
    this.jdField_a_of_type_Int = 1;
  }
  
  public void onDestroy()
  {
    AIOAnimationControlManager.DownloadGiftResStateObservable.a().deleteObservers();
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("clear History. uin:");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount());
      localStringBuilder.append(" app=");
      localStringBuilder.append(String.valueOf(this.jdField_a_of_type_ComTencentCommonAppAppInterface));
      QLog.d("AIOAnimationControlManager", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = null;
    this.jdField_a_of_type_AndroidAppActivity = null;
    this.jdField_a_of_type_AndroidOsHandler = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.AIOAnimationControlManager
 * JD-Core Version:    0.7.0.1
 */