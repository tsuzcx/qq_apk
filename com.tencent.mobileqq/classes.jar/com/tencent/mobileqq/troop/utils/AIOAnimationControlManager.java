package com.tencent.mobileqq.troop.utils;

import aiyo;
import aiyp;
import aiyq;
import aiyr;
import aiyt;
import aiyv;
import aiyw;
import aiyy;
import aiyz;
import aizc;
import aizf;
import aizg;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.av.utils.TroopMemberUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageForTroopEffectPic;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.mobileqq.pic.PicDownloadInfo;
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
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
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
import mqq.manager.Manager;

public class AIOAnimationControlManager
  extends Observable
  implements Manager
{
  public static final String a;
  public static volatile boolean a;
  public static int b;
  public int a;
  private long jdField_a_of_type_Long;
  public Activity a;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  public Handler a;
  public AppInterface a;
  public BaseChatPie a;
  FrameSprite.OnFrameEndListener jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener = new aiyr(this);
  public AIOAnimationControlManager.OnAnimationPlayEndListener a;
  TroopGiftAnimationController.OnCleanAnimationListener jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$OnCleanAnimationListener = new aiyq(this);
  public TroopGiftAnimationController a;
  public TroopInteractGiftAnimationController a;
  TroopPicEffectsController jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsController;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new aiyw(this);
  public Comparator a;
  public HashMap a;
  public String b;
  public HashMap b;
  public volatile boolean b;
  private int jdField_c_of_type_Int;
  public HashMap c;
  private boolean jdField_c_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaLangString = String.valueOf(10000L);
    jdField_b_of_type_Int = 9;
  }
  
  public AIOAnimationControlManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_c_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilComparator = new aiyv(this);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    a(paramAppInterface);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  private void a(AppInterface paramAppInterface)
  {
    if ((paramAppInterface != null) && ((paramAppInterface instanceof BrowserAppInterface)))
    {
      i();
      return;
    }
    ThreadManager.post(new aiyo(this), 8, null, true);
  }
  
  private void a(String paramString, MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    if ((!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) || (((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).intValue() == 4))
    {
      Object localObject = new File(TroopGiftUtil.a(paramString, paramMessageForDeliverGiftTips.animationType, paramMessageForDeliverGiftTips.isInteract()));
      Bundle localBundle = new Bundle();
      localBundle.putString("GiftAnimationId", paramString);
      localBundle.putString("TroopUin", paramMessageForDeliverGiftTips.frienduin);
      localBundle.putInt("GiftAnimationType", paramMessageForDeliverGiftTips.animationType);
      localBundle.putBoolean("GiftIsInteract", paramMessageForDeliverGiftTips.isInteract());
      localObject = new DownloadTask(TroopGiftUtil.c(paramMessageForDeliverGiftTips), (File)localObject);
      ((DownloadTask)localObject).jdField_b_of_type_Int = 2;
      if ((paramMessageForDeliverGiftTips instanceof MessageForTroopGift)) {
        ((MessageForTroopGift)paramMessageForDeliverGiftTips).isLoading = true;
      }
      a().a((DownloadTask)localObject, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, localBundle);
      if (QLog.isColorLevel()) {
        QLog.d("AIOAnimationControlManager", 2, "start Download PackageId:" + TroopGiftUtil.b(paramMessageForDeliverGiftTips));
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(2));
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    List localList = (List)this.jdField_b_of_type_JavaUtilHashMap.get(paramString1);
    if ((paramString2 == null) || (localList == null)) {
      return;
    }
    int i = 0;
    label25:
    if (i < localList.size())
    {
      paramString1 = (AIOAnimationControlManager.IAnimationMessage)localList.get(i);
      if (!(paramString1 instanceof MessageForDeliverGiftTips)) {
        break label87;
      }
      paramString1 = TroopGiftUtil.b((MessageForDeliverGiftTips)paramString1);
    }
    for (;;)
    {
      if (paramString2.equals(paramString1)) {
        localList.remove(i);
      }
      i += 1;
      break label25;
      break;
      label87:
      if ((paramString1 instanceof MessageForTroopEffectPic)) {
        paramString1 = ((MessageForTroopEffectPic)paramString1).effectId + "";
      } else {
        paramString1 = "";
      }
    }
  }
  
  private void b(String paramString1, String paramString2)
  {
    paramString1 = (List)this.jdField_c_of_type_JavaUtilHashMap.get(paramString1);
    if ((paramString2 == null) || (paramString1 == null)) {}
    for (;;)
    {
      return;
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
  
  private void i()
  {
    Object localObject = new File(AppConstants.cc);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    File[] arrayOfFile = ((File)localObject).listFiles();
    int j;
    int i;
    boolean bool;
    if (arrayOfFile != null)
    {
      j = 0;
      if (j < arrayOfFile.length) {
        if ((arrayOfFile[j].exists()) && (arrayOfFile[j].isDirectory()))
        {
          localObject = arrayOfFile[j].getName();
          if (!arrayOfFile[j].getName().endsWith("_HD")) {
            break label180;
          }
          localObject = ((String)localObject).substring(0, ((String)localObject).length() - 3);
          i = 0;
          bool = false;
        }
      }
    }
    for (;;)
    {
      label111:
      if (TroopGiftUtil.a((String)localObject, i, bool))
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(localObject, Integer.valueOf(3));
        if (QLog.isColorLevel()) {
          QLog.d("AIOAnimationControlManager", 2, "Package Downloaded:" + arrayOfFile[j].getName());
        }
      }
      for (;;)
      {
        j += 1;
        break;
        label180:
        if (arrayOfFile[j].getName().endsWith("_V"))
        {
          localObject = ((String)localObject).substring(0, ((String)localObject).length() - 2);
          i = 1;
          bool = false;
          break label111;
        }
        if (!arrayOfFile[j].getName().endsWith("_NEW")) {
          break label270;
        }
        localObject = ((String)localObject).substring(0, ((String)localObject).length() - 4);
        i = 1;
        bool = true;
        break label111;
        FileUtils.a(arrayOfFile[j].getAbsolutePath());
      }
      return;
      label270:
      i = 0;
      bool = false;
    }
  }
  
  public long a(String paramString)
  {
    paramString = (List)this.jdField_b_of_type_JavaUtilHashMap.get(paramString);
    long l1 = 0L;
    long l2 = l1;
    if (paramString != null)
    {
      paramString = paramString.iterator();
      l2 = l1;
      if (paramString.hasNext())
      {
        AIOAnimationControlManager.IAnimationMessage localIAnimationMessage = (AIOAnimationControlManager.IAnimationMessage)paramString.next();
        if (localIAnimationMessage.getShmsgseq() <= l1) {
          break label77;
        }
        l1 = localIAnimationMessage.getShmsgseq();
      }
    }
    label77:
    for (;;)
    {
      break;
      return l2;
    }
  }
  
  public DownloaderInterface a()
  {
    return ((DownloaderFactory)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(46)).a(1);
  }
  
  public void a()
  {
    int i = 0;
    Object localObject = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MobileQQ/.troop/pic_effects/");
    if (((File)localObject).exists())
    {
      localObject = ((File)localObject).listFiles();
      if (localObject == null) {}
    }
    for (;;)
    {
      if (i < localObject.length)
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
              FileUtils.d(localObject[i].getAbsolutePath());
            }
          }
          catch (Exception localException)
          {
            if (!QLog.isColorLevel()) {
              break label165;
            }
          }
          QLog.e("AIOAnimationControlManager", 2, "checkPicEffectPackageIdState: " + QLog.getStackTraceString(localException));
        }
      }
      else {
        return;
      }
      label165:
      i += 1;
    }
  }
  
  public void a(int paramInt, String paramString, MessageForTroopEffectPic paramMessageForTroopEffectPic)
  {
    paramMessageForTroopEffectPic = "" + paramInt;
    if ((!this.jdField_a_of_type_JavaUtilHashMap.containsKey("" + paramInt)) || (((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramMessageForTroopEffectPic)).intValue() == 4))
    {
      File localFile = new File(TroopGiftUtil.a(paramInt));
      Bundle localBundle = new Bundle();
      localBundle.putString("GiftAnimationId", paramMessageForTroopEffectPic);
      localBundle.putString("TroopUin", paramString);
      paramString = new DownloadTask(TroopGiftUtil.b(paramInt), localFile);
      paramString.jdField_b_of_type_Int = 2;
      a().a(paramString, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, localBundle);
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
    if (QLog.isColorLevel()) {
      QLog.d("AIOAnimationControlManager", 2, "set TroopChatPie ,troopUin:" + paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != paramBaseChatPie)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
      addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController = paramBaseChatPie.a();
      if (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof TroopChatPie)) {
        break label114;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.a(1);
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController = ((TroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).a();
      this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsController = ((TroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).a();
    }
    label114:
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof HotChatPie))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.a(4);
        return;
      }
    } while (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof NearbyChatPie));
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10002)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.a(8);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.a(6);
  }
  
  public void a(TroopGiftAnimationController paramTroopGiftAnimationController, String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController = paramTroopGiftAnimationController;
    this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.a(paramInt);
    this.jdField_a_of_type_AndroidAppActivity = this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.a();
    this.jdField_b_of_type_JavaLangString = paramString;
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
  
  public void a(String paramString, long[] paramArrayOfLong)
  {
    List localList = (List)this.jdField_b_of_type_JavaUtilHashMap.get(paramString);
    if (localList != null)
    {
      if ((paramArrayOfLong != null) && (paramArrayOfLong.length != 0)) {
        break label33;
      }
      a(paramString);
    }
    label33:
    while (paramArrayOfLong.length == localList.size()) {
      return;
    }
    paramString = new ArrayList();
    int i = 0;
    while (i < paramArrayOfLong.length)
    {
      paramString.add(Long.valueOf(paramArrayOfLong[i]));
      i += 1;
    }
    i = 0;
    label83:
    int k;
    if (i < localList.size())
    {
      paramArrayOfLong = (AIOAnimationControlManager.IAnimationMessage)localList.get(i);
      k = i;
      if ((paramArrayOfLong instanceof MessageForDeliverGiftTips))
      {
        paramArrayOfLong = (MessageForDeliverGiftTips)paramArrayOfLong;
        j = 0;
        label124:
        if (j >= paramString.size()) {
          break label212;
        }
        if (paramArrayOfLong.getId() != ((Long)paramString.get(j)).longValue()) {
          break label203;
        }
        k = 1;
        paramString.remove(j);
      }
    }
    label203:
    label212:
    for (int j = k;; j = 0)
    {
      k = i;
      if (j == 0)
      {
        localList.remove(i);
        k = i - 1;
      }
      i = k + 1;
      break label83;
      break;
      j += 1;
      break label124;
    }
  }
  
  public void a(Observer paramObserver)
  {
    AIOAnimationControlManager.DownloadGiftResStateObservable.a().addObserver(paramObserver);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) && (this.jdField_a_of_type_AndroidAppActivity == null) && (!jdField_a_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString))) {}
    Object localObject3;
    Object localObject5;
    label397:
    label752:
    label890:
    String str;
    label874:
    label1773:
    do
    {
      Object localObject4;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  this.jdField_c_of_type_Boolean = paramBoolean;
                  if (!jdField_a_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString)) {
                    break;
                  }
                  localObject1 = this.jdField_b_of_type_JavaLangString;
                  localObject3 = (List)this.jdField_c_of_type_JavaUtilHashMap.get(localObject1);
                  localObject4 = (List)this.jdField_b_of_type_JavaUtilHashMap.get(localObject1);
                } while ((!b()) && (TroopGiftUtil.a((List)localObject3)));
                if ((this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController == null) || (TroopGiftUtil.a((List)localObject3))) {
                  break label397;
                }
              } while ((this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController.b()) && (this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController.a()));
              this.jdField_a_of_type_Int = 2;
              localObject5 = (MessageForDeliverGiftTips)((List)localObject3).get(0);
              localObject6 = TroopGiftUtil.b((MessageForDeliverGiftTips)localObject5);
              if ((!this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject6)) || (((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(localObject6)).intValue() != 3)) {
                break;
              }
              if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a.a()))
              {
                this.jdField_a_of_type_AndroidOsHandler.postDelayed(new aiyy(this, paramBoolean), 500L);
                return;
                if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {}
                for (localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;; localObject1 = this.jdField_b_of_type_JavaLangString) {
                  break;
                }
              }
            } while (((MessageForDeliverGiftTips)localObject5).interactState == 2);
            ((TroopGiftManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(112)).a(((MessageForDeliverGiftTips)localObject5).frienduin, ((MessageForDeliverGiftTips)localObject5).interactId, ((MessageForDeliverGiftTips)localObject5).giftId, new aiyz(this, (MessageForDeliverGiftTips)localObject5, (List)localObject3, paramBoolean, (List)localObject4, (String)localObject6));
            return;
            if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject6)) && (((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(localObject6)).intValue() == 4))
            {
              b((String)localObject1, (String)localObject6);
              this.jdField_a_of_type_Int = 1;
              a(paramBoolean);
              return;
            }
            this.jdField_a_of_type_Int = 3;
            return;
          } while ((this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController == null) || (TroopGiftUtil.a((List)localObject4)));
          this.jdField_a_of_type_Int = 2;
          localObject3 = (AIOAnimationControlManager.IAnimationMessage)((List)localObject4).get(0);
          if (!(localObject3 instanceof MessageForDeliverGiftTips)) {
            break label1294;
          }
          localObject5 = (MessageForDeliverGiftTips)localObject3;
          if ((((MessageForDeliverGiftTips)localObject5).isToAll()) && (!((MessageForDeliverGiftTips)localObject5).hasFetchButFailed))
          {
            localObject3 = ((TroopGiftManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(112)).a((String)localObject1, ((MessageForDeliverGiftTips)localObject5).bagId, new aizc(this, (MessageForDeliverGiftTips)localObject5, (String)localObject1, paramBoolean));
            if (localObject3 == null)
            {
              this.jdField_a_of_type_Int = 1;
              return;
            }
            if ((!((TroopGiftBagInfo)localObject3).hasGrab()) || (((TroopGiftBagInfo)localObject3).myGrabResult == null)) {
              break label752;
            }
            ((MessageForDeliverGiftTips)localObject5).showButton = false;
            ((MessageForDeliverGiftTips)localObject5).resultText = ((TroopGiftBagInfo)localObject3).myGrabResult.jdField_a_of_type_JavaLangString;
            ((MessageForDeliverGiftTips)localObject5).resultType = 0;
          }
          for (;;)
          {
            if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
              ((MessageForDeliverGiftTips)localObject5).senderName = ContactUtils.g((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, (String)localObject1, "" + ((MessageForDeliverGiftTips)localObject5).senderUin);
            }
            localObject6 = TroopGiftUtil.b((MessageForDeliverGiftTips)localObject5);
            if ((!this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject6)) || (((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(localObject6)).intValue() != 3)) {
              break label1238;
            }
            this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener);
            if (QLog.isColorLevel()) {
              QLog.d("AIOAnimationControlManager", 2, "Playing! playMaigface id:" + TroopGiftUtil.b((MessageForDeliverGiftTips)localObject5));
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a.a())) {
              break;
            }
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(new aizf(this, paramBoolean), 500L);
            return;
            if (((TroopGiftBagInfo)localObject3).myGrabResult != null)
            {
              ((MessageForDeliverGiftTips)localObject5).showButton = false;
              ((MessageForDeliverGiftTips)localObject5).resultText = ((TroopGiftBagInfo)localObject3).myGrabResult.jdField_a_of_type_JavaLangString;
              ((MessageForDeliverGiftTips)localObject5).resultType = 1;
            }
            else
            {
              ((MessageForDeliverGiftTips)localObject5).showButton = true;
            }
          }
          if (RobotResourcesManager.a().a()) {
            RobotResourcesManager.a().b();
          }
          if (TextUtils.isEmpty(((MessageForDeliverGiftTips)localObject5).interactId)) {
            break;
          }
          ((List)localObject4).remove(localObject5);
        } while (this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController == null);
        this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController.a((MessageForDeliverGiftTips)localObject5, (String)localObject6, false, new aizg(this, paramBoolean));
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
        {
          localObject3 = "0";
          if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {
            break label1206;
          }
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          ReportController.b((QQAppInterface)localObject4, "P_CliOper", "Grp_flower", "", "cartoon", "show", 0, 0, (String)localObject1, (String)localObject6, (String)localObject3, "" + TroopMemberUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), (String)localObject1));
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder().append("Check isLimitGiftAnim: isEnterAIO:").append(paramBoolean).append(", isToMeGift:");
            if (((MessageForDeliverGiftTips)localObject5).receiverUin == this.jdField_a_of_type_ComTencentCommonAppAppInterface.getLongAccountUin()) {
              break label1212;
            }
          }
        }
        for (boolean bool = true;; bool = false)
        {
          QLog.d("AIOAnimationControlManager", 2, bool + ", count:" + this.jdField_c_of_type_Int + ", time:" + this.jdField_a_of_type_Long);
          if ((!paramBoolean) || (((MessageForDeliverGiftTips)localObject5).receiverUin == this.jdField_a_of_type_ComTencentCommonAppAppInterface.getLongAccountUin()) || (!a(true))) {
            break label1217;
          }
          if (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
            break;
          }
          localObject1 = (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface;
          localObject3 = ((QQAppInterface)localObject1).a().a().a(false).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (RecentUser)((Iterator)localObject3).next();
            if (((RecentUser)localObject4).msgType == 7)
            {
              if (QLog.isColorLevel()) {
                QLog.d("AIOAnimationControlManager", 2, "limitGiftAnim setRead RecentUser:" + localObject4);
              }
              ((QQAppInterface)localObject1).a().a().a(((RecentUser)localObject4).uin, ((RecentUser)localObject4).type, true, false);
            }
          }
          break;
          localObject3 = "1";
          break label874;
          localObject4 = null;
          break label890;
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.a((MessageForDeliverGiftTips)localObject5);
        this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$OnCleanAnimationListener = this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$OnCleanAnimationListener;
        return;
        if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject6)) && (((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(localObject6)).intValue() == 4))
        {
          a((String)localObject1, (String)localObject6);
          this.jdField_a_of_type_Int = 1;
          a(paramBoolean);
          return;
        }
        this.jdField_a_of_type_Int = 3;
        return;
      } while ((!(localObject3 instanceof MessageForTroopEffectPic)) || (this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsController == null));
      localObject5 = (MessageForTroopEffectPic)localObject3;
      localObject3 = "" + ((MessageForTroopEffectPic)localObject5).effectId;
      if ((((MessageForTroopEffectPic)localObject5).effectId < 40003) || (((MessageForTroopEffectPic)localObject5).effectId > 40005)) {
        this.jdField_a_of_type_JavaUtilHashMap.put(localObject3, Integer.valueOf(3));
      }
      if ((!this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject3)) || (((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(localObject3)).intValue() != 3) || (!TroopGiftUtil.a(((MessageForTroopEffectPic)localObject5).effectId))) {
        break;
      }
      Object localObject1 = ((MessageForTroopEffectPic)localObject5).getPicDownloadInfo();
      ((PicDownloadInfo)localObject1).e = "chatimg";
      Object localObject6 = ((PicDownloadInfo)localObject1).c();
      File localFile = new File((String)localObject6);
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localObject3 = null;
      int i;
      switch (JpegExifReader.readOrientation((String)localObject6))
      {
      case 4: 
      case 5: 
      case 7: 
      default: 
        i = 0;
      }
      for (;;)
      {
        localObject1 = localObject3;
        try
        {
          if (localFile.exists())
          {
            localObject1 = new BufferedInputStream(new FileInputStream(localFile), 2048);
            localOptions.inSampleSize = ((int)ImageUtil.a((InputStream)localObject1, 720, 1080));
            ((BufferedInputStream)localObject1).close();
            localObject6 = ImageUtil.a((String)localObject6, localOptions);
            localObject1 = localObject3;
            if (localObject6 != null)
            {
              localObject1 = new Matrix();
              ((Matrix)localObject1).reset();
              ((Matrix)localObject1).setRotate(i);
              localObject1 = Bitmap.createBitmap((Bitmap)localObject6, 0, 0, ((Bitmap)localObject6).getWidth(), ((Bitmap)localObject6).getHeight(), (Matrix)localObject1, true);
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            Object localObject2 = null;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("AIOAnimationControlManager", 2, "OOM: " + QLog.getStackTraceString(localOutOfMemoryError));
            }
            str = null;
          }
        }
        if ((localObject1 == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof TroopChatPie))) {
          break label1773;
        }
        localObject3 = (TroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
        this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsController.a(((MessageForTroopEffectPic)localObject5).effectId, (Bitmap)localObject1, ((TroopChatPie)localObject3).o, new aiyp(this, paramBoolean));
        ((List)localObject4).remove(localObject5);
        return;
        i = 90;
        continue;
        i = 180;
        continue;
        i = 270;
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof TroopChatPie)));
    label1206:
    label1212:
    label1217:
    label1238:
    this.jdField_a_of_type_Int = 3;
    label1294:
    this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsController.a((TroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, (MessageForTroopEffectPic)localObject5, false);
    return;
    if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject3)) && (((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(localObject3)).intValue() == 4))
    {
      a(str, (String)localObject3);
      this.jdField_a_of_type_Int = 1;
      a(paramBoolean);
      return;
    }
    a((MessageForTroopEffectPic)localObject5, false);
    this.jdField_a_of_type_Int = 3;
  }
  
  protected boolean a()
  {
    return jdField_a_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString);
  }
  
  public boolean a(MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    if (!a()) {}
    do
    {
      return false;
      e();
    } while (!b(paramMessageForDeliverGiftTips));
    g();
    return true;
  }
  
  public boolean a(MessageForDeliverGiftTips paramMessageForDeliverGiftTips, boolean paramBoolean)
  {
    if (paramMessageForDeliverGiftTips == null) {}
    while (!TroopGiftUtil.a(paramMessageForDeliverGiftTips)) {
      return false;
    }
    List localList = (List)this.jdField_b_of_type_JavaUtilHashMap.get(paramMessageForDeliverGiftTips.frienduin);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this.jdField_b_of_type_JavaUtilHashMap.put(paramMessageForDeliverGiftTips.frienduin, localObject);
    }
    for (;;)
    {
      try
      {
        ((List)localObject).add(paramMessageForDeliverGiftTips);
        if (((List)localObject).size() > 3) {
          ((List)localObject).remove(0);
        }
        if (paramMessageForDeliverGiftTips.interactState == 2)
        {
          g();
          return true;
        }
      }
      finally {}
      ((TroopGiftManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(112)).a(paramMessageForDeliverGiftTips.frienduin, paramMessageForDeliverGiftTips.interactId, paramMessageForDeliverGiftTips.giftId, new aiyt(this, paramMessageForDeliverGiftTips, paramBoolean));
    }
  }
  
  public boolean a(MessageForTroopEffectPic paramMessageForTroopEffectPic, boolean paramBoolean)
  {
    String str = "" + paramMessageForTroopEffectPic.effectId;
    if ((paramMessageForTroopEffectPic.effectId < 40003) || (paramMessageForTroopEffectPic.effectId > 40005))
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(str, Integer.valueOf(3));
      if (paramBoolean) {
        return a(paramMessageForTroopEffectPic, false);
      }
      return false;
    }
    int i;
    if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey(str)) && (((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(str)).intValue() == 3)) {
      if (!TroopGiftUtil.a(paramMessageForTroopEffectPic.effectId))
      {
        this.jdField_a_of_type_JavaUtilHashMap.remove(str);
        FileUtils.d(TroopGiftUtil.a(paramMessageForTroopEffectPic.effectId));
        a(paramMessageForTroopEffectPic.effectId, paramMessageForTroopEffectPic.frienduin, paramMessageForTroopEffectPic);
        i = 2;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOAnimationControlManager", 2, "MessageForTroopEffectPic id:" + str + ",state:" + i);
      }
      if (!paramBoolean) {
        break;
      }
      return a(paramMessageForTroopEffectPic, false);
      i = 3;
      continue;
      a(paramMessageForTroopEffectPic.effectId, paramMessageForTroopEffectPic.frienduin, paramMessageForTroopEffectPic);
      i = 2;
    }
    return i == 2;
  }
  
  public boolean a(AIOAnimationControlManager.IAnimationMessage paramIAnimationMessage, boolean paramBoolean)
  {
    if (paramIAnimationMessage == null) {
      return false;
    }
    if (((paramIAnimationMessage instanceof MessageForDeliverGiftTips)) && (!TroopGiftUtil.a((MessageForDeliverGiftTips)paramIAnimationMessage))) {
      return false;
    }
    List localList = (List)this.jdField_b_of_type_JavaUtilHashMap.get(paramIAnimationMessage.getFriendUin());
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this.jdField_b_of_type_JavaUtilHashMap.put(paramIAnimationMessage.getFriendUin(), localObject);
    }
    try
    {
      ((List)localObject).add(paramIAnimationMessage);
      if (((List)localObject).size() > 3) {
        ((List)localObject).remove(0);
      }
      if (paramBoolean)
      {
        setChanged();
        notifyObservers(paramIAnimationMessage);
      }
      return true;
    }
    finally {}
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
    boolean bool2 = false;
    boolean bool1;
    if (this.jdField_a_of_type_Long == 0L)
    {
      bool1 = bool2;
      if (paramBoolean)
      {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        this.jdField_c_of_type_Int = 1;
        bool1 = bool2;
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_AndroidContentSharedPreferences != null) && (paramBoolean))
      {
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("AIOAnimationControlManager_limit_gif_time", this.jdField_a_of_type_Long).apply();
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("AIOAnimationControlManager_limit_gif_count", this.jdField_c_of_type_Int).apply();
      }
      return bool1;
      if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 3600000L)
      {
        jdField_b_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("AIOAnimationControlManager_limit_gif_count_MAX", jdField_b_of_type_Int);
        if (this.jdField_c_of_type_Int >= jdField_b_of_type_Int)
        {
          this.jdField_a_of_type_Int = 4;
          bool1 = true;
        }
        else
        {
          bool1 = bool2;
          if (paramBoolean)
          {
            this.jdField_c_of_type_Int += 1;
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
    }
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {}
    for (Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;; localObject = this.jdField_b_of_type_JavaLangString)
    {
      localObject = (List)this.jdField_b_of_type_JavaUtilHashMap.get(localObject);
      if ((!this.jdField_b_of_type_Boolean) || (TroopGiftUtil.a((List)localObject))) {
        break label135;
      }
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
    }
    Collections.sort((List)localObject, this.jdField_a_of_type_JavaUtilComparator);
    label135:
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void b(Observer paramObserver)
  {
    AIOAnimationControlManager.DownloadGiftResStateObservable.a().deleteObserver(paramObserver);
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 4);
  }
  
  public boolean b(MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    if (!TroopGiftUtil.a(paramMessageForDeliverGiftTips)) {
      return false;
    }
    String str = TroopGiftUtil.b(paramMessageForDeliverGiftTips);
    int i;
    boolean bool;
    if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey(str)) && (((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(str)).intValue() == 3)) {
      if (!TroopGiftUtil.a(str, paramMessageForDeliverGiftTips.animationType, paramMessageForDeliverGiftTips.isInteract()))
      {
        this.jdField_a_of_type_JavaUtilHashMap.remove(str);
        FileUtils.a(TroopGiftUtil.a(paramMessageForDeliverGiftTips));
        a(str, paramMessageForDeliverGiftTips);
        i = 2;
        if (QLog.isColorLevel()) {
          QLog.d("AIOAnimationControlManager", 2, "giftRealAnimationId:" + TroopGiftUtil.b(paramMessageForDeliverGiftTips) + ",state:" + i);
        }
        if ((a()) && (i != 3)) {
          break label188;
        }
        if (!paramMessageForDeliverGiftTips.isInteract()) {
          break label178;
        }
        bool = a(paramMessageForDeliverGiftTips, false);
      }
    }
    for (;;)
    {
      return bool;
      i = 3;
      break;
      a(str, paramMessageForDeliverGiftTips);
      i = 4;
      break;
      label178:
      bool = a(paramMessageForDeliverGiftTips, false);
      continue;
      label188:
      bool = false;
    }
  }
  
  public boolean b(String paramString)
  {
    return (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) || (((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).intValue() != 3);
  }
  
  public void c()
  {
    deleteObservers();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAnimationControlManager", 2, "release TroopChatPie ,troopUin:" + this.jdField_b_of_type_JavaLangString);
    }
    AIOAnimationControlManager.DownloadGiftResStateObservable.a().deleteObservers();
    this.jdField_b_of_type_JavaUtilHashMap.remove(this.jdField_b_of_type_JavaLangString);
    this.jdField_c_of_type_JavaUtilHashMap.remove(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController = null;
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController = null;
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {}
    for (Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;; localObject = this.jdField_b_of_type_JavaLangString)
    {
      localObject = (List)this.jdField_b_of_type_JavaUtilHashMap.get(localObject);
      if (localObject != null) {
        break;
      }
      return false;
    }
    if ((!((List)localObject).isEmpty()) || (this.jdField_a_of_type_Int == 2)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {}
    for (String str = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;; str = this.jdField_b_of_type_JavaLangString)
    {
      this.jdField_b_of_type_JavaUtilHashMap.remove(str);
      this.jdField_c_of_type_JavaUtilHashMap.remove(str);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.c();
        this.jdField_a_of_type_Int = 1;
      }
      return;
    }
  }
  
  public void f()
  {
    this.jdField_a_of_type_AndroidAppActivity = null;
    this.jdField_a_of_type_Int = 1;
  }
  
  public void g()
  {
    a(false);
  }
  
  public void h()
  {
    if (RobotResourcesManager.a().a()) {
      RobotResourcesManager.a().b();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.a())) {
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.c();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController != null) && (!this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController.a())) {
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsController != null) {
      this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsController.a();
    }
    this.jdField_a_of_type_Int = 1;
  }
  
  public void onDestroy()
  {
    AIOAnimationControlManager.DownloadGiftResStateObservable.a().deleteObservers();
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && (QLog.isColorLevel())) {
      QLog.d("AIOAnimationControlManager", 2, "clear History. uin:" + this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount() + " app=" + String.valueOf(this.jdField_a_of_type_ComTencentCommonAppAppInterface));
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = null;
    this.jdField_a_of_type_AndroidAppActivity = null;
    this.jdField_a_of_type_AndroidOsHandler = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.AIOAnimationControlManager
 * JD-Core Version:    0.7.0.1
 */