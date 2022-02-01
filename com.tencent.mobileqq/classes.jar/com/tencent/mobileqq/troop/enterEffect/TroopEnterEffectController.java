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
  protected SpriteGLView b;
  protected LinearLayout c;
  protected ScrollView d;
  protected RelativeLayout e;
  protected Handler f = new Handler(Looper.getMainLooper());
  protected SparseArray<TroopEnterEffectData> g = new SparseArray();
  protected DownloaderInterface h;
  protected boolean i;
  protected String j;
  private CallBacker k = new TroopEnterEffectController.4(this);
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append(".troop/enter_effects/");
    a = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
  }
  
  public TroopEnterEffectController(QQAppInterface paramQQAppInterface, RelativeLayout paramRelativeLayout)
  {
    this.e = paramRelativeLayout;
    this.h = ((DownloaderFactory)paramQQAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
    ((IVasQuickUpdateService)paramQQAppInterface.getRuntimeService(IVasQuickUpdateService.class, "")).addCallBacker(this.k);
  }
  
  public static Bitmap a(String paramString, TroopEnterEffectData paramTroopEnterEffectData)
  {
    int m = paramTroopEnterEffectData.f;
    Object localObject = null;
    if (m == 2)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("/yearsvip/yearsvip_s");
      ((StringBuilder)localObject).append(paramTroopEnterEffectData.e);
      ((StringBuilder)localObject).append(".png");
      paramString = ((StringBuilder)localObject).toString();
    }
    try
    {
      paramString = ImageUtil.a(paramString, null);
      return paramString;
    }
    catch (OutOfMemoryError paramString) {}
    if (paramTroopEnterEffectData.f == 1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("/svip/svip_s");
      ((StringBuilder)localObject).append(paramTroopEnterEffectData.e);
      ((StringBuilder)localObject).append(".png");
      paramString = ((StringBuilder)localObject).toString();
      localObject = ImageUtil.a(paramString, null);
    }
    return localObject;
    return null;
  }
  
  public static String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append(paramInt);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramInt);
    localStringBuilder.append(".zip");
    return localStringBuilder.toString();
  }
  
  public static int b(String paramString)
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
  
  public static String b()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null) {
      return new File(localBaseApplicationImpl.getFilesDir(), "enterEffectVipIcons.zip").getAbsolutePath();
    }
    return null;
  }
  
  public static String c()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null) {
      return new File(localBaseApplicationImpl.getFilesDir(), "enterEffectVipIcons").getAbsolutePath();
    }
    return null;
  }
  
  public static void d()
  {
    String str = c();
    if (TextUtils.isEmpty(str))
    {
      QLog.e("TroopEnterEffect.Controller", 1, "checkVipIconsExists get null path");
      return;
    }
    if (ThemeUtil.getFileNumInFile(new File(str)) == 0) {
      ((IVasQuickUpdateService)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getRuntimeService(IVasQuickUpdateService.class, "")).downloadItem(1004L, "enterEffectVipIcons", "TroopEnterEffectController");
    }
  }
  
  private TroopEnterEffectConfig.GrayTipsConfig h()
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
      if (((TroopEnterEffectConfig)localObject1).d.size() > 0)
      {
        int m;
        if (localITroopEnterEffectService.hasSetEffect(this.j)) {
          m = 2;
        } else {
          m = 1;
        }
        int n = 0;
        while (n < ((TroopEnterEffectConfig)localObject1).d.size())
        {
          TroopEnterEffectConfig.GrayTipsConfig localGrayTipsConfig = (TroopEnterEffectConfig.GrayTipsConfig)((TroopEnterEffectConfig)localObject1).d.get(n);
          Object localObject2 = localITroopEnterEffectService.getSharedPreferences();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("gray_tips_no_longer_");
          localStringBuilder.append(localGrayTipsConfig.a);
          bool = ((SharedPreferences)localObject2).getBoolean(localStringBuilder.toString(), false);
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("getGrayTips id = ");
            ((StringBuilder)localObject2).append(localGrayTipsConfig.a);
            ((StringBuilder)localObject2).append(" nolongerShow = ");
            ((StringBuilder)localObject2).append(bool);
            QLog.d("TroopEnterEffect.Controller", 2, ((StringBuilder)localObject2).toString());
          }
          if ((!bool) && (localGrayTipsConfig.a(m, localQQAppInterface))) {
            return localGrayTipsConfig;
          }
          n += 1;
        }
      }
    }
    return null;
  }
  
  public void a()
  {
    if (DeviceInfoUtil.U())
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopEnterEffect.Controller", 2, "playAnimaions: isLowEndPhoneForPreDownload = true");
      }
      return;
    }
    if (SimpleUIUtil.e())
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopEnterEffect.Controller", 2, "playAnimaions: isSimpleUISwitch = true");
      }
      return;
    }
    ITroopEnterEffectService localITroopEnterEffectService = (ITroopEnterEffectService)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getRuntimeService(ITroopEnterEffectService.class, "all");
    TroopEnterEffectData localTroopEnterEffectData = localITroopEnterEffectService.getFirstEffectData(this.j);
    if ((localTroopEnterEffectData != null) && (b(localTroopEnterEffectData)))
    {
      if (System.currentTimeMillis() - localTroopEnterEffectData.d < 60000L)
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
      ((StringBuilder)localObject1).append(this.i);
      QLog.d("TroopEnterEffect.Controller", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.b == null)
    {
      Object localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      String str = ((QQAppInterface)localObject2).getCurrentUin();
      if ((!TextUtils.isEmpty(str)) && (str.equals(paramTroopEnterEffectData.b))) {
        VasWebviewUtil.a(str, "style", "0X8008E5F", "", 1, 0, 0, "", Integer.toString(paramTroopEnterEffectData.a), "");
      } else {
        VasWebviewUtil.a(str, "style", "0X8008E60", "", 1, 0, 0, "", Integer.toString(paramTroopEnterEffectData.a), "");
      }
      localObject1 = (ITroopEnterEffectService)((QQAppInterface)localObject2).getRuntimeService(ITroopEnterEffectService.class, "all");
      ((ITroopEnterEffectService)localObject1).removeEnterEffectData(paramTroopEnterEffectData);
      this.b = new SpriteGLView(this.e.getContext(), 1);
      this.b.v = true;
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, 0);
      View localView1 = this.e.findViewById(2131447879);
      View localView2 = this.e.findViewById(2131448070);
      View localView3 = this.e.findViewById(2131442214);
      if ((localView1 != null) && (localView1.getVisibility() == 0)) {
        localLayoutParams.topMargin = localView1.getBottom();
      } else if ((localView2 != null) && (localView2.getVisibility() == 0)) {
        localLayoutParams.topMargin = localView2.getBottom();
      } else if ((localView3 != null) && (localView3.getVisibility() == 0)) {
        localLayoutParams.topMargin = localView3.getBottom();
      } else {
        localLayoutParams.topMargin = DisplayUtil.a(this.e.getContext(), 50.0F);
      }
      if (this.c == null) {
        this.c = new LinearLayout(this.e.getContext());
      }
      if (this.d == null)
      {
        this.d = new TroopEnterEffectController.1(this, this.e.getContext());
        this.d.setClickable(false);
        this.d.setEnabled(false);
        this.d.addView(this.c, -1, DisplayUtil.a(this.e.getContext(), this.e.getHeight()));
      }
      this.e.addView(this.d, localLayoutParams);
      this.c.addView(this.b, -1, 0);
      this.b.setOnTouchListener(new TroopEnterEffectController.2(this, (QQAppInterface)localObject2, str, paramTroopEnterEffectData));
      this.b.post(new TroopEnterEffectController.3(this, paramTroopEnterEffectData));
      paramTroopEnterEffectData = (TroopEnterEffectManager)((QQAppInterface)localObject2).getManager(QQManagerFactory.TROOP_ENTER_EFFECT_MANAGER);
      localObject2 = h();
      if (localObject2 != null) {
        paramTroopEnterEffectData.a((TroopEnterEffectConfig.GrayTipsConfig)localObject2, this.j);
      }
      ((ITroopEnterEffectService)localObject1).report("Grp_AIO", "action_play", new String[0]);
    }
  }
  
  public void a(String paramString)
  {
    this.j = paramString;
  }
  
  public boolean b(TroopEnterEffectData paramTroopEnterEffectData)
  {
    int m = paramTroopEnterEffectData.a;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downloadAnimationResources: id = ");
      ((StringBuilder)localObject).append(m);
      QLog.d("TroopEnterEffect.Controller", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(a);
    ((StringBuilder)localObject).append(m);
    localObject = ((StringBuilder)localObject).toString();
    if (TroopGiftUtil.a(new File((String)localObject))) {
      return true;
    }
    if (this.g.get(m) != null) {
      return false;
    }
    FileUtils.deleteDirectory((String)localObject);
    localObject = (IVasQuickUpdateService)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getRuntimeService(IVasQuickUpdateService.class, "");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("groupeffect_item_");
    localStringBuilder.append(m);
    localStringBuilder.append(".zip");
    ((IVasQuickUpdateService)localObject).downloadItem(25L, localStringBuilder.toString(), "TroopEnterEffectController");
    this.g.put(m, paramTroopEnterEffectData);
    return false;
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopEnterEffect.Controller", 2, "onResume");
    }
    this.i = true;
  }
  
  public void f()
  {
    SpriteGLView localSpriteGLView = this.b;
    if (localSpriteGLView != null)
    {
      localSpriteGLView.o();
      this.d.removeAllViews();
      this.c.removeView(this.b);
      this.e.removeView(this.d);
      this.b = null;
      this.d = null;
      this.c = null;
    }
    this.i = false;
    this.f.removeCallbacksAndMessages(null);
    ((ITroopEnterEffectService)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getRuntimeService(ITroopEnterEffectService.class, "all")).removeAllEffectDatas(this.j);
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopEnterEffect.Controller", 2, "onDestroy remove quickupdate callback");
    }
    ((IVasQuickUpdateService)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getRuntimeService(IVasQuickUpdateService.class, "")).removeCallBacker(this.k);
    PobingManager.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController
 * JD-Core Version:    0.7.0.1
 */