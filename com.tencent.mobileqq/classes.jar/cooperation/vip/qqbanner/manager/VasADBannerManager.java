package cooperation.vip.qqbanner.manager;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.recent.bannerprocessor.VasADBannerProcessor;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.startup.step.SetSplash;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vassplash.common.VasSplashUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.mobilereport.MobileReportManager;
import cooperation.qzone.util.QZLog;
import cooperation.vip.ad.TianshuReportUtils;
import cooperation.vip.qqbanner.data.VasADBannerData;
import cooperation.vip.qqbanner.info.VasADBannerConfigInfo;
import cooperation.vip.qqbanner.info.VasADBannerConfigInfo.ResourceInfo;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class VasADBannerManager
  implements View.OnClickListener
{
  protected BaseActivity a;
  protected View b;
  protected View c;
  protected URLImageView d;
  private BannerManager e;
  private Map<String, Boolean> f = new HashMap();
  private boolean g = false;
  private boolean h = false;
  private boolean i = false;
  
  public static VasADBannerManager b(BaseActivity paramBaseActivity, BannerManager paramBannerManager)
  {
    Object localObject = VasADBannerResDownloadManager.a().c(m());
    if (localObject != null)
    {
      localObject = ((VasADBannerConfigInfo)localObject).c();
      if (localObject != null) {
        ((VasADBannerManager)localObject).a(paramBaseActivity, paramBannerManager);
      }
      return localObject;
    }
    return null;
  }
  
  private void c(VasADBannerConfigInfo paramVasADBannerConfigInfo)
  {
    this.h = paramVasADBannerConfigInfo.b();
    if (this.h)
    {
      this.i = n();
      if (this.i) {
        o();
      }
    }
    if (QLog.isColorLevel())
    {
      paramVasADBannerConfigInfo = new StringBuilder();
      paramVasADBannerConfigInfo.append("startPreloadWebView needed: ");
      paramVasADBannerConfigInfo.append(this.h);
      paramVasADBannerConfigInfo.append(", done: ");
      paramVasADBannerConfigInfo.append(this.i);
      QLog.d("VasADBannerManager", 2, paramVasADBannerConfigInfo.toString());
    }
  }
  
  private static String m()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null)
    {
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getCurrentUin = ");
        localStringBuilder.append(localAppRuntime.getAccount());
        QLog.i("VasADBannerManager", 4, localStringBuilder.toString());
      }
      return localAppRuntime.getAccount();
    }
    return null;
  }
  
  private boolean n()
  {
    return ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).mAutomator.h();
  }
  
  private void o()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("from", -1);
    localIntent.setAction("com.tencent.mobileqq.webprocess.preload_web_process");
    localIntent.setPackage(MobileQQ.getContext().getPackageName());
    BaseApplicationImpl.sApplication.sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
  }
  
  private void p()
  {
    this.h = false;
    this.i = false;
    if (QLog.isColorLevel()) {
      QLog.d("VasADBannerManager", 2, "stopPreloadWebView");
    }
  }
  
  protected int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    Object localObject = paramString;
    if (!paramString.startsWith("#"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("#");
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    try
    {
      int j = Color.parseColor((String)localObject);
      return j;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      paramString = new StringBuilder();
      paramString.append(" getValidTextColor error color = ");
      paramString.append((String)localObject);
      QZLog.i("VasADBannerManager", 1, paramString.toString());
    }
    return -1;
  }
  
  public View a()
  {
    QLog.i("VasADBannerManager", 1, "initVasADBanner");
    this.b = LayoutInflater.from(this.a).inflate(b(), null);
    this.c = this.b.findViewById(2131435638);
    this.d = ((URLImageView)this.b.findViewById(2131435628));
    ViewGroup.LayoutParams localLayoutParams = this.d.getLayoutParams();
    localLayoutParams.width = k();
    localLayoutParams.height = l();
    this.d.setLayoutParams(localLayoutParams);
    this.d.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.d.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.b.setVisibility(8);
    return this.b;
  }
  
  public void a(BaseActivity paramBaseActivity, BannerManager paramBannerManager)
  {
    this.a = paramBaseActivity;
    this.e = paramBannerManager;
  }
  
  protected void a(VasADBannerConfigInfo paramVasADBannerConfigInfo)
  {
    if (paramVasADBannerConfigInfo != null)
    {
      if (paramVasADBannerConfigInfo.a() == null) {
        return;
      }
      if (paramVasADBannerConfigInfo.d())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(m());
        localStringBuilder.append("");
        VasSplashUtil.b(localStringBuilder.toString());
        TianshuReportUtils.b(paramVasADBannerConfigInfo.a().e, 137, paramVasADBannerConfigInfo.a().d);
        return;
      }
      TianshuReportUtils.b(paramVasADBannerConfigInfo.a().e, 101);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onScrollChange isScroll = ");
      localStringBuilder.append(paramBoolean);
      QLog.i("VasADBannerManager", 2, localStringBuilder.toString());
    }
  }
  
  protected int b()
  {
    return 2131628354;
  }
  
  protected String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    Object localObject = this.a;
    if ((localObject != null) && (((BaseActivity)localObject).app != null)) {
      localObject = ContactUtils.f(this.a.app, this.a.app.getCurrentAccountUin());
    } else {
      localObject = "";
    }
    return paramString.replace("{nickname}", (CharSequence)localObject);
  }
  
  public void b(VasADBannerConfigInfo paramVasADBannerConfigInfo)
  {
    if (paramVasADBannerConfigInfo != null)
    {
      if (paramVasADBannerConfigInfo.a() == null) {
        return;
      }
      if (paramVasADBannerConfigInfo.d())
      {
        TianshuReportUtils.b(paramVasADBannerConfigInfo.a().e, 138, paramVasADBannerConfigInfo.a().d);
        return;
      }
      TianshuReportUtils.b(paramVasADBannerConfigInfo.a().e, 102);
    }
  }
  
  public void c()
  {
    QLog.e("VasADBannerManager", 1, "hideBanner");
    Object localObject = this.b;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.e;
    if (localObject != null)
    {
      ((BannerManager)localObject).b(VasADBannerProcessor.a, 2000);
      p();
    }
    i();
  }
  
  public void d()
  {
    QLog.e("VasADBannerManager", 1, "onRecycle");
  }
  
  public boolean e()
  {
    Object localObject = m();
    localObject = VasADBannerResDownloadManager.a().c((String)localObject);
    if ((localObject != null) && (((VasADBannerConfigInfo)localObject).a != null) && (((VasADBannerConfigInfo)localObject).a.size() != 0)) {
      return true;
    }
    QLog.i("VasADBannerManager", 1, "isNeedShowVasADBanner configInfo is null, return false.");
    return false;
  }
  
  public void f()
  {
    VasADBannerConfigInfo localVasADBannerConfigInfo = VasADBannerResDownloadManager.a().c(m());
    if (localVasADBannerConfigInfo != null)
    {
      if (localVasADBannerConfigInfo.a() == null) {
        return;
      }
      if (localVasADBannerConfigInfo.d())
      {
        TianshuReportUtils.b(localVasADBannerConfigInfo.a().e, 122, localVasADBannerConfigInfo.a().d);
        return;
      }
      TianshuReportUtils.b(localVasADBannerConfigInfo.a().e, 122);
    }
  }
  
  public void g()
  {
    if ((this.b != null) && (this.d != null))
    {
      QLog.i("VasADBannerManager", 1, "start showVasADBanner");
      Object localObject2 = VasADBannerResDownloadManager.a().c(m());
      Object localObject1 = null;
      if (localObject2 != null) {
        localObject1 = ((VasADBannerConfigInfo)localObject2).a();
      }
      if ((localObject2 != null) && (((VasADBannerConfigInfo)localObject2).a != null) && (localObject1 != null))
      {
        VasADBannerConfigInfo.ResourceInfo localResourceInfo = (VasADBannerConfigInfo.ResourceInfo)((VasADBannerConfigInfo)localObject2).a.get(1);
        if (localResourceInfo == null)
        {
          QLog.e("VasADBannerManager", 1, "initVasADBanner resourceInfo = null");
          c();
          return;
        }
        if ((!TextUtils.isEmpty(localResourceInfo.c)) && ((((VasADBannerData)localObject1).a == 1) || (((VasADBannerData)localObject1).a == 0)))
        {
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mLoadingDrawable = URLDrawableHelperConstants.a;
          localURLDrawableOptions.mFailedDrawable = URLDrawableHelperConstants.a;
          localURLDrawableOptions.mRequestWidth = k();
          localURLDrawableOptions.mRequestHeight = l();
          boolean bool;
          if (((VasADBannerData)localObject1).a == 1) {
            bool = true;
          } else {
            bool = false;
          }
          localURLDrawableOptions.mPlayGifImage = bool;
          localObject1 = URLDrawable.getFileDrawable(localResourceInfo.c, localURLDrawableOptions);
          if (localObject1 == null)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("initVasADBanner urlDrawable == null  file path = ");
            ((StringBuilder)localObject1).append(localResourceInfo.c);
            QLog.i("VasADBannerManager", 1, ((StringBuilder)localObject1).toString());
            c();
            return;
          }
          this.d.setImageDrawable((Drawable)localObject1);
          if (((URLDrawable)localObject1).getStatus() == 1)
          {
            this.b.setVisibility(0);
            QLog.i("VasADBannerManager", 1, "showVasADBanner urlDrawable status is success");
            a((VasADBannerConfigInfo)localObject2);
            SetSplash.a(this.b);
            return;
          }
          ((URLDrawable)localObject1).setURLDrawableListener(new VasADBannerManager.1(this, (VasADBannerConfigInfo)localObject2));
          ThreadManager.executeOnFileThread(new VasADBannerManager.2(this, (URLDrawable)localObject1));
          return;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("initVasADBanner resType is wrong: ");
        ((StringBuilder)localObject2).append(((VasADBannerData)localObject1).a);
        ((StringBuilder)localObject2).append(" file path = ");
        ((StringBuilder)localObject2).append(localResourceInfo.c);
        QLog.i("VasADBannerManager", 1, ((StringBuilder)localObject2).toString());
        c();
        return;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("initVasADBanner config info is null, uin: ");
      ((StringBuilder)localObject1).append(m());
      QLog.i("VasADBannerManager", 1, ((StringBuilder)localObject1).toString());
      c();
      return;
    }
    QLog.e("VasADBannerManager", 1, "showVasADBanner xml init error");
    c();
  }
  
  public void h()
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkIfHideBanner isClick: ");
      localStringBuilder.append(this.g);
      QLog.i("VasADBannerManager", 4, localStringBuilder.toString());
    }
    if (this.g)
    {
      c();
      this.g = false;
    }
  }
  
  public void i()
  {
    Map localMap = this.f;
    if (localMap != null) {
      localMap.clear();
    }
  }
  
  public void j()
  {
    if ((this.h) && (!this.i))
    {
      this.i = true;
      o();
    }
  }
  
  protected int k()
  {
    return ViewUtils.getScreenWidth();
  }
  
  protected int l()
  {
    return (int)(k() * 0.1333333F);
  }
  
  public void onClick(View paramView)
  {
    int j = paramView.getId();
    if (j != 2131435628)
    {
      if (j == 2131435638)
      {
        f();
        c();
        VasADBannerResDownloadManager.a().b(m());
      }
    }
    else
    {
      Object localObject1 = VasADBannerResDownloadManager.a().c(m());
      if ((localObject1 == null) || (((VasADBannerConfigInfo)localObject1).a() == null)) {
        break label587;
      }
      VasADBannerData localVasADBannerData = ((VasADBannerConfigInfo)localObject1).a();
      if ((localVasADBannerData == null) || (TextUtils.isEmpty(localVasADBannerData.b))) {
        break label575;
      }
      b((VasADBannerConfigInfo)localObject1);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("qboss banner jump url = ");
        ((StringBuilder)localObject1).append(localVasADBannerData.b);
        QLog.i("VasADBannerManager", 2, ((StringBuilder)localObject1).toString());
      }
      if (localVasADBannerData.c == 1)
      {
        Object localObject2 = localVasADBannerData.b;
        localObject1 = localObject2;
        if (!((String)localObject2).contains("http://"))
        {
          localObject1 = localObject2;
          if (!((String)localObject2).contains("https://"))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("https://");
            ((StringBuilder)localObject1).append((String)localObject2);
            localObject1 = ((StringBuilder)localObject1).toString();
          }
        }
        if (((String)localObject1).contains("?"))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("&qboss_trace=");
          ((StringBuilder)localObject2).append(localVasADBannerData.d);
          localObject1 = ((StringBuilder)localObject2).toString();
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("?qboss_trace=");
          ((StringBuilder)localObject2).append(localVasADBannerData.d);
          localObject1 = ((StringBuilder)localObject2).toString();
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(MobileReportManager.getStringQboos2H5(BaseApplicationImpl.getApplication().getRuntime().getAccount(), localVasADBannerData.d, "&"));
        localObject1 = ((StringBuilder)localObject2).toString();
        if (QLog.isDevelopLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("TraceInfo qboss banner final traceInfo jump url = ");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.i("VasADBannerManager", 4, ((StringBuilder)localObject2).toString());
        }
        this.g = true;
        localObject2 = new Intent(this.a, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("url", (String)localObject1);
        ((Intent)localObject2).putExtra("big_brother_source_key", "biz_src_jc_vip");
        this.a.startActivity((Intent)localObject2);
      }
      else if (localVasADBannerData.c == 2)
      {
        localObject1 = JumpParser.a(this.a.app, this.a, localVasADBannerData.b);
        if (localObject1 != null)
        {
          this.g = true;
          ((JumpAction)localObject1).a();
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("jumpAction is null, jump url = ");
          ((StringBuilder)localObject1).append(localVasADBannerData.b);
          QLog.e("VasADBannerManager", 1, ((StringBuilder)localObject1).toString());
        }
      }
    }
    ReportController.a(this.a.app, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 11, 0, "", "", "", "");
    break label596;
    label575:
    QLog.e("VasADBannerManager", 1, "bannerData is null || jumpUrl is empty");
    break label596;
    label587:
    QLog.e("VasADBannerManager", 1, "qboss banner configInfo = null || bannerData = null");
    label596:
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.qqbanner.manager.VasADBannerManager
 * JD-Core Version:    0.7.0.1
 */