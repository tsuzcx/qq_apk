package com.tencent.mobileqq.troop.enterEffect;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.vas.trooppobing.PobingManager;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Vector;

public class TroopEnterEffectController
{
  public static final String a;
  protected Handler a;
  protected SparseArray<TroopEnterEffectController.TroopEnterEffectData> a;
  protected LinearLayout a;
  protected RelativeLayout a;
  protected ScrollView a;
  protected SpriteGLView a;
  private CallBacker a;
  protected DownloaderInterface a;
  protected boolean a;
  protected String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + ".troop/enter_effects/");
  }
  
  public TroopEnterEffectController(QQAppInterface paramQQAppInterface, RelativeLayout paramRelativeLayout)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker = new TroopEnterEffectController.4(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface = ((DownloaderFactory)paramQQAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
    ((IVasQuickUpdateService)paramQQAppInterface.getRuntimeService(IVasQuickUpdateService.class, "")).addCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker);
  }
  
  public static int a(String paramString)
  {
    if (paramString.startsWith("groupeffect_item_"))
    {
      paramString = paramString.substring("groupeffect_item_".length(), paramString.length() - ".zip".length());
      if ((!TextUtils.isEmpty(paramString)) && (TextUtils.isDigitsOnly(paramString))) {
        return Integer.parseInt(paramString);
      }
    }
    return -1;
  }
  
  public static Bitmap a(String paramString, TroopEnterEffectController.TroopEnterEffectData paramTroopEnterEffectData)
  {
    Bitmap localBitmap = null;
    if (paramTroopEnterEffectData.c == 2) {
      paramString = paramString + "/yearsvip/yearsvip_s" + paramTroopEnterEffectData.b + ".png";
    }
    for (;;)
    {
      try
      {
        localBitmap = ImageUtil.a(paramString, null);
        return localBitmap;
      }
      catch (OutOfMemoryError paramString)
      {
        try
        {
          paramString = ImageUtil.a(paramString, null);
          return paramString;
        }
        catch (OutOfMemoryError paramString) {}
        paramString = paramString;
        return null;
      }
      if (paramTroopEnterEffectData.c == 1) {
        paramString = paramString + "/svip/svip_s" + paramTroopEnterEffectData.b + ".png";
      }
    }
    return null;
  }
  
  private TroopEnterEffectConfig.GrayTipsConfig a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    TroopEnterEffectManager localTroopEnterEffectManager = (TroopEnterEffectManager)localQQAppInterface.getManager(QQManagerFactory.TROOP_ENTER_EFFECT_MANAGER);
    boolean bool = localTroopEnterEffectManager.a();
    if (QLog.isColorLevel()) {
      QLog.d("TroopEnterEffect.Controller", 2, "getGrayTips isShowEnterEffectEveryTime = " + false + " hasShowToday = " + bool);
    }
    if (!bool)
    {
      TroopEnterEffectConfig localTroopEnterEffectConfig = localTroopEnterEffectManager.a();
      if (localTroopEnterEffectConfig.a.size() > 0)
      {
        int i;
        int j;
        if (localTroopEnterEffectManager.b(this.b))
        {
          i = 2;
          j = 0;
        }
        for (;;)
        {
          if (j >= localTroopEnterEffectConfig.a.size()) {
            break label243;
          }
          TroopEnterEffectConfig.GrayTipsConfig localGrayTipsConfig = (TroopEnterEffectConfig.GrayTipsConfig)localTroopEnterEffectConfig.a.get(j);
          bool = localTroopEnterEffectManager.a().getBoolean("gray_tips_no_longer_" + localGrayTipsConfig.jdField_a_of_type_Int, false);
          if (QLog.isColorLevel()) {
            QLog.d("TroopEnterEffect.Controller", 2, "getGrayTips id = " + localGrayTipsConfig.jdField_a_of_type_Int + " nolongerShow = " + bool);
          }
          if ((!bool) && (localGrayTipsConfig.a(i, localQQAppInterface)))
          {
            return localGrayTipsConfig;
            i = 1;
            break;
          }
          j += 1;
        }
      }
    }
    label243:
    return null;
  }
  
  public static String a()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null) {
      return new File(localBaseApplicationImpl.getFilesDir(), "enterEffectVipIcons.zip").getAbsolutePath();
    }
    return null;
  }
  
  public static String a(int paramInt)
  {
    return jdField_a_of_type_JavaLangString + paramInt + File.separator + paramInt + ".zip";
  }
  
  public static String b()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null) {
      return new File(localBaseApplicationImpl.getFilesDir(), "enterEffectVipIcons").getAbsolutePath();
    }
    return null;
  }
  
  public static void b()
  {
    String str = b();
    if (TextUtils.isEmpty(str)) {
      QLog.e("TroopEnterEffect.Controller", 1, "checkVipIconsExists get null path");
    }
    while (ThemeUtil.getFileNumInFile(new File(str)) != 0) {
      return;
    }
    ((IVasQuickUpdateService)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getRuntimeService(IVasQuickUpdateService.class, "")).downloadItem(1004L, "enterEffectVipIcons", "TroopEnterEffectController");
  }
  
  public void a()
  {
    if (DeviceInfoUtil.f()) {
      if (QLog.isColorLevel()) {
        QLog.d("TroopEnterEffect.Controller", 2, "playAnimaions: isLowEndPhoneForPreDownload = true");
      }
    }
    TroopEnterEffectManager localTroopEnterEffectManager;
    TroopEnterEffectController.TroopEnterEffectData localTroopEnterEffectData;
    do
    {
      do
      {
        do
        {
          return;
          if (!SimpleUIUtil.a()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("TroopEnterEffect.Controller", 2, "playAnimaions: isSimpleUISwitch = true");
        return;
        localTroopEnterEffectManager = (TroopEnterEffectManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.TROOP_ENTER_EFFECT_MANAGER);
      } while (localTroopEnterEffectManager == null);
      localTroopEnterEffectData = localTroopEnterEffectManager.a(this.b);
    } while ((localTroopEnterEffectData == null) || (!a(localTroopEnterEffectData)));
    if (System.currentTimeMillis() - localTroopEnterEffectData.jdField_a_of_type_Long < 60000L)
    {
      a(localTroopEnterEffectData);
      return;
    }
    localTroopEnterEffectManager.b(localTroopEnterEffectData);
  }
  
  protected void a(TroopEnterEffectController.TroopEnterEffectData paramTroopEnterEffectData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopEnterEffect.Controller", 2, "showAnimation: enterEffectData = " + paramTroopEnterEffectData + " isAio = " + this.jdField_a_of_type_Boolean);
    }
    Object localObject1;
    String str;
    Object localObject2;
    View localView2;
    View localView3;
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView == null)
    {
      localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      str = ((QQAppInterface)localObject1).getCurrentUin();
      if ((TextUtils.isEmpty(str)) || (!str.equals(paramTroopEnterEffectData.jdField_a_of_type_JavaLangString))) {
        break label431;
      }
      VasWebviewUtil.reportCommercialDrainage(str, "style", "0X8008E5F", "", 1, 0, 0, "", Integer.toString(paramTroopEnterEffectData.jdField_a_of_type_Int), "");
      localObject2 = (TroopEnterEffectManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.TROOP_ENTER_EFFECT_MANAGER);
      if (localObject2 != null) {
        ((TroopEnterEffectManager)localObject2).b(paramTroopEnterEffectData);
      }
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView = new SpriteGLView(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext(), 1);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.b = true;
      localObject2 = new RelativeLayout.LayoutParams(-1, 0);
      View localView1 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379814);
      localView2 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131380004);
      localView3 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131374581);
      if ((localView1 == null) || (localView1.getVisibility() != 0)) {
        break label460;
      }
      ((RelativeLayout.LayoutParams)localObject2).topMargin = localView1.getBottom();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext());
      }
      if (this.jdField_a_of_type_AndroidWidgetScrollView == null)
      {
        this.jdField_a_of_type_AndroidWidgetScrollView = new TroopEnterEffectController.1(this, this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext());
        this.jdField_a_of_type_AndroidWidgetScrollView.setClickable(false);
        this.jdField_a_of_type_AndroidWidgetScrollView.setEnabled(false);
        this.jdField_a_of_type_AndroidWidgetScrollView.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, -1, DisplayUtil.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext(), this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight()));
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetScrollView, (ViewGroup.LayoutParams)localObject2);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView, -1, 0);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.setOnTouchListener(new TroopEnterEffectController.2(this, str, paramTroopEnterEffectData));
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.post(new TroopEnterEffectController.3(this, paramTroopEnterEffectData));
      paramTroopEnterEffectData = (TroopEnterEffectManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.TROOP_ENTER_EFFECT_MANAGER);
      localObject1 = a();
      if (localObject1 != null) {
        paramTroopEnterEffectData.a((TroopEnterEffectConfig.GrayTipsConfig)localObject1, this.b);
      }
      TroopEnterEffectManager.a("Grp_AIO", "action_play", new String[0]);
      return;
      label431:
      VasWebviewUtil.reportCommercialDrainage(str, "style", "0X8008E60", "", 1, 0, 0, "", Integer.toString(paramTroopEnterEffectData.jdField_a_of_type_Int), "");
      break;
      label460:
      if ((localView2 != null) && (localView2.getVisibility() == 0)) {
        ((RelativeLayout.LayoutParams)localObject2).topMargin = localView2.getBottom();
      } else if ((localView3 != null) && (localView3.getVisibility() == 0)) {
        ((RelativeLayout.LayoutParams)localObject2).topMargin = localView3.getBottom();
      } else {
        ((RelativeLayout.LayoutParams)localObject2).topMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext(), 50.0F);
      }
    }
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public boolean a(TroopEnterEffectController.TroopEnterEffectData paramTroopEnterEffectData)
  {
    int i = paramTroopEnterEffectData.jdField_a_of_type_Int;
    if (QLog.isColorLevel()) {
      QLog.d("TroopEnterEffect.Controller", 2, "downloadAnimationResources: id = " + i);
    }
    String str = jdField_a_of_type_JavaLangString + i;
    if (TroopGiftUtil.a(new File(str))) {
      return true;
    }
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(i) != null) {
      return false;
    }
    FileUtils.a(str);
    ((IVasQuickUpdateService)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getRuntimeService(IVasQuickUpdateService.class, "")).downloadItem(25L, "groupeffect_item_" + i + ".zip", "TroopEnterEffectController");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(i, paramTroopEnterEffectData);
    return false;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopEnterEffect.Controller", 2, "onResume");
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.n();
      this.jdField_a_of_type_AndroidWidgetScrollView.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_AndroidWidgetScrollView);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView = null;
      this.jdField_a_of_type_AndroidWidgetScrollView = null;
      this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    TroopEnterEffectManager localTroopEnterEffectManager = (TroopEnterEffectManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.TROOP_ENTER_EFFECT_MANAGER);
    if (localTroopEnterEffectManager != null) {
      localTroopEnterEffectManager.b(this.b);
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopEnterEffect.Controller", 2, "onDestroy remove quickupdate callback");
    }
    ((IVasQuickUpdateService)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getRuntimeService(IVasQuickUpdateService.class, "")).removeCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker);
    PobingManager.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController
 * JD-Core Version:    0.7.0.1
 */