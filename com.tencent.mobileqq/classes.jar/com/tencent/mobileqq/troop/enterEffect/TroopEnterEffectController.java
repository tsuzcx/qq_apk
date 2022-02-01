package com.tencent.mobileqq.troop.enterEffect;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
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
import com.tencent.mobileqq.troop.entereffect.TroopEnterEffectConfig;
import com.tencent.mobileqq.troop.entereffect.TroopEnterEffectConfig.GrayTipsConfig;
import com.tencent.mobileqq.troop.entereffect.TroopEnterEffectData;
import com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.trooppobing.PobingManager;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
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
  protected SparseArray<TroopEnterEffectData> a;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append(".troop/enter_effects/");
    jdField_a_of_type_JavaLangString = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
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
      paramString = paramString.substring(17, paramString.length() - 4);
      if ((!TextUtils.isEmpty(paramString)) && (TextUtils.isDigitsOnly(paramString))) {
        return Integer.parseInt(paramString);
      }
    }
    return -1;
  }
  
  public static Bitmap a(String paramString, TroopEnterEffectData paramTroopEnterEffectData)
  {
    int i = paramTroopEnterEffectData.c;
    Object localObject = null;
    if (i == 2)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("/yearsvip/yearsvip_s");
      ((StringBuilder)localObject).append(paramTroopEnterEffectData.b);
      ((StringBuilder)localObject).append(".png");
      paramString = ((StringBuilder)localObject).toString();
    }
    try
    {
      paramString = ImageUtil.a(paramString, null);
      return paramString;
    }
    catch (OutOfMemoryError paramString) {}
    if (paramTroopEnterEffectData.c == 1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("/svip/svip_s");
      ((StringBuilder)localObject).append(paramTroopEnterEffectData.b);
      ((StringBuilder)localObject).append(".png");
      paramString = ((StringBuilder)localObject).toString();
      localObject = ImageUtil.a(paramString, null);
    }
    return localObject;
    return null;
  }
  
  private TroopEnterEffectConfig.GrayTipsConfig a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    ITroopEnterEffectService localITroopEnterEffectService = (ITroopEnterEffectService)localQQAppInterface.getRuntimeService(ITroopEnterEffectService.class, "all");
    boolean bool = localITroopEnterEffectService.hasShowGrayTipsToday();
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getGrayTips isShowEnterEffectEveryTime = ");
      ((StringBuilder)localObject1).append(false);
      ((StringBuilder)localObject1).append(" hasShowToday = ");
      ((StringBuilder)localObject1).append(bool);
      QLog.d("TroopEnterEffect.Controller", 2, ((StringBuilder)localObject1).toString());
    }
    if (!bool)
    {
      localObject1 = localITroopEnterEffectService.getTroopEnterEffectConfig();
      if (((TroopEnterEffectConfig)localObject1).a.size() > 0)
      {
        int i;
        if (localITroopEnterEffectService.hasSetEffect(this.b)) {
          i = 2;
        } else {
          i = 1;
        }
        int j = 0;
        while (j < ((TroopEnterEffectConfig)localObject1).a.size())
        {
          TroopEnterEffectConfig.GrayTipsConfig localGrayTipsConfig = (TroopEnterEffectConfig.GrayTipsConfig)((TroopEnterEffectConfig)localObject1).a.get(j);
          Object localObject2 = localITroopEnterEffectService.getSharedPreferences();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("gray_tips_no_longer_");
          localStringBuilder.append(localGrayTipsConfig.jdField_a_of_type_Int);
          bool = ((SharedPreferences)localObject2).getBoolean(localStringBuilder.toString(), false);
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("getGrayTips id = ");
            ((StringBuilder)localObject2).append(localGrayTipsConfig.jdField_a_of_type_Int);
            ((StringBuilder)localObject2).append(" nolongerShow = ");
            ((StringBuilder)localObject2).append(bool);
            QLog.d("TroopEnterEffect.Controller", 2, ((StringBuilder)localObject2).toString());
          }
          if ((!bool) && (localGrayTipsConfig.a(i, localQQAppInterface))) {
            return localGrayTipsConfig;
          }
          j += 1;
        }
      }
    }
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    localStringBuilder.append(paramInt);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramInt);
    localStringBuilder.append(".zip");
    return localStringBuilder.toString();
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
    if (TextUtils.isEmpty(str))
    {
      QLog.e("TroopEnterEffect.Controller", 1, "checkVipIconsExists get null path");
      return;
    }
    if (ThemeUtil.getFileNumInFile(new File(str)) == 0) {
      ((IVasQuickUpdateService)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getRuntimeService(IVasQuickUpdateService.class, "")).downloadItem(1004L, "enterEffectVipIcons", "TroopEnterEffectController");
    }
  }
  
  public void a()
  {
    if (DeviceInfoUtil.h())
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopEnterEffect.Controller", 2, "playAnimaions: isLowEndPhoneForPreDownload = true");
      }
      return;
    }
    if (SimpleUIUtil.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopEnterEffect.Controller", 2, "playAnimaions: isSimpleUISwitch = true");
      }
      return;
    }
    ITroopEnterEffectService localITroopEnterEffectService = (ITroopEnterEffectService)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getRuntimeService(ITroopEnterEffectService.class, "all");
    TroopEnterEffectData localTroopEnterEffectData = localITroopEnterEffectService.getFirstEffectData(this.b);
    if ((localTroopEnterEffectData != null) && (a(localTroopEnterEffectData)))
    {
      if (System.currentTimeMillis() - localTroopEnterEffectData.jdField_a_of_type_Long < 60000L)
      {
        a(localTroopEnterEffectData);
        return;
      }
      localITroopEnterEffectService.removeEnterEffectData(localTroopEnterEffectData);
    }
  }
  
  protected void a(TroopEnterEffectData paramTroopEnterEffectData)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("showAnimation: enterEffectData = ");
      ((StringBuilder)localObject1).append(paramTroopEnterEffectData);
      ((StringBuilder)localObject1).append(" isAio = ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_Boolean);
      QLog.d("TroopEnterEffect.Controller", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView == null)
    {
      Object localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      String str = ((QQAppInterface)localObject2).getCurrentUin();
      if ((!TextUtils.isEmpty(str)) && (str.equals(paramTroopEnterEffectData.jdField_a_of_type_JavaLangString))) {
        VasWebviewUtil.a(str, "style", "0X8008E5F", "", 1, 0, 0, "", Integer.toString(paramTroopEnterEffectData.jdField_a_of_type_Int), "");
      } else {
        VasWebviewUtil.a(str, "style", "0X8008E60", "", 1, 0, 0, "", Integer.toString(paramTroopEnterEffectData.jdField_a_of_type_Int), "");
      }
      localObject1 = (ITroopEnterEffectService)((QQAppInterface)localObject2).getRuntimeService(ITroopEnterEffectService.class, "all");
      ((ITroopEnterEffectService)localObject1).removeEnterEffectData(paramTroopEnterEffectData);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView = new SpriteGLView(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext(), 1);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.b = true;
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, 0);
      View localView1 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379143);
      View localView2 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379333);
      View localView3 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131374119);
      if ((localView1 != null) && (localView1.getVisibility() == 0)) {
        localLayoutParams.topMargin = localView1.getBottom();
      } else if ((localView2 != null) && (localView2.getVisibility() == 0)) {
        localLayoutParams.topMargin = localView2.getBottom();
      } else if ((localView3 != null) && (localView3.getVisibility() == 0)) {
        localLayoutParams.topMargin = localView3.getBottom();
      } else {
        localLayoutParams.topMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext(), 50.0F);
      }
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
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetScrollView, localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView, -1, 0);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.setOnTouchListener(new TroopEnterEffectController.2(this, (QQAppInterface)localObject2, str, paramTroopEnterEffectData));
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.post(new TroopEnterEffectController.3(this, paramTroopEnterEffectData));
      paramTroopEnterEffectData = (TroopEnterEffectManager)((QQAppInterface)localObject2).getManager(QQManagerFactory.TROOP_ENTER_EFFECT_MANAGER);
      localObject2 = a();
      if (localObject2 != null) {
        paramTroopEnterEffectData.a((TroopEnterEffectConfig.GrayTipsConfig)localObject2, this.b);
      }
      ((ITroopEnterEffectService)localObject1).report("Grp_AIO", "action_play", new String[0]);
    }
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public boolean a(TroopEnterEffectData paramTroopEnterEffectData)
  {
    int i = paramTroopEnterEffectData.jdField_a_of_type_Int;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downloadAnimationResources: id = ");
      ((StringBuilder)localObject).append(i);
      QLog.d("TroopEnterEffect.Controller", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append(i);
    localObject = ((StringBuilder)localObject).toString();
    if (TroopGiftUtil.a(new File((String)localObject))) {
      return true;
    }
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(i) != null) {
      return false;
    }
    FileUtils.deleteDirectory((String)localObject);
    localObject = (IVasQuickUpdateService)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getRuntimeService(IVasQuickUpdateService.class, "");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("groupeffect_item_");
    localStringBuilder.append(i);
    localStringBuilder.append(".zip");
    ((IVasQuickUpdateService)localObject).downloadItem(25L, localStringBuilder.toString(), "TroopEnterEffectController");
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
    SpriteGLView localSpriteGLView = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView;
    if (localSpriteGLView != null)
    {
      localSpriteGLView.n();
      this.jdField_a_of_type_AndroidWidgetScrollView.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_AndroidWidgetScrollView);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView = null;
      this.jdField_a_of_type_AndroidWidgetScrollView = null;
      this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    ((ITroopEnterEffectService)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getRuntimeService(ITroopEnterEffectService.class, "all")).removeAllEffectDatas(this.b);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController
 * JD-Core Version:    0.7.0.1
 */