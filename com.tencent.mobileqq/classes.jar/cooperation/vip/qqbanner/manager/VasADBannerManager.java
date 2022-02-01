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
  protected View a;
  protected URLImageView a;
  protected BaseActivity a;
  private BannerManager jdField_a_of_type_ComTencentMobileqqBannerBannerManager;
  private Map<String, Boolean> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = false;
  protected View b;
  private boolean b;
  private boolean c = false;
  
  public VasADBannerManager()
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  public static VasADBannerManager a(BaseActivity paramBaseActivity, BannerManager paramBannerManager)
  {
    Object localObject = VasADBannerResDownloadManager.a().a(a());
    if (localObject != null)
    {
      localObject = ((VasADBannerConfigInfo)localObject).a();
      if (localObject != null) {
        ((VasADBannerManager)localObject).a(paramBaseActivity, paramBannerManager);
      }
      return localObject;
    }
    return null;
  }
  
  private static String a()
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
  
  private boolean b()
  {
    return ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).mAutomator.c();
  }
  
  private void c(VasADBannerConfigInfo paramVasADBannerConfigInfo)
  {
    this.jdField_b_of_type_Boolean = paramVasADBannerConfigInfo.a();
    if (this.jdField_b_of_type_Boolean)
    {
      this.c = b();
      if (this.c) {
        h();
      }
    }
    if (QLog.isColorLevel())
    {
      paramVasADBannerConfigInfo = new StringBuilder();
      paramVasADBannerConfigInfo.append("startPreloadWebView needed: ");
      paramVasADBannerConfigInfo.append(this.jdField_b_of_type_Boolean);
      paramVasADBannerConfigInfo.append(", done: ");
      paramVasADBannerConfigInfo.append(this.c);
      QLog.d("VasADBannerManager", 2, paramVasADBannerConfigInfo.toString());
    }
  }
  
  private void h()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("from", -1);
    localIntent.setAction("com.tencent.mobileqq.webprocess.preload_web_process");
    localIntent.setPackage(MobileQQ.getContext().getPackageName());
    BaseApplicationImpl.sApplication.sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
  }
  
  private void i()
  {
    this.jdField_b_of_type_Boolean = false;
    this.c = false;
    if (QLog.isColorLevel()) {
      QLog.d("VasADBannerManager", 2, "stopPreloadWebView");
    }
  }
  
  protected int a()
  {
    return 2131561930;
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
      int i = Color.parseColor((String)localObject);
      return i;
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
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(a(), null);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131368725);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368715));
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
    localLayoutParams.width = b();
    localLayoutParams.height = c();
    this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  protected String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    if ((localObject != null) && (((BaseActivity)localObject).app != null)) {
      localObject = ContactUtils.e(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getCurrentAccountUin());
    } else {
      localObject = "";
    }
    return paramString.replace("{nickname}", (CharSequence)localObject);
  }
  
  public void a()
  {
    QLog.e("VasADBannerManager", 1, "hideBanner");
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager;
    if (localObject != null)
    {
      ((BannerManager)localObject).b(VasADBannerProcessor.jdField_a_of_type_Int, 2000);
      i();
    }
    f();
  }
  
  public void a(BaseActivity paramBaseActivity, BannerManager paramBannerManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager = paramBannerManager;
  }
  
  protected void a(VasADBannerConfigInfo paramVasADBannerConfigInfo)
  {
    if (paramVasADBannerConfigInfo != null)
    {
      if (paramVasADBannerConfigInfo.a() == null) {
        return;
      }
      if (paramVasADBannerConfigInfo.b())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(a());
        localStringBuilder.append("");
        VasSplashUtil.a(localStringBuilder.toString());
        TianshuReportUtils.b(paramVasADBannerConfigInfo.a().c, 137, paramVasADBannerConfigInfo.a().jdField_b_of_type_JavaLangString);
        return;
      }
      TianshuReportUtils.b(paramVasADBannerConfigInfo.a().c, 101);
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
  
  public boolean a()
  {
    Object localObject = a();
    localObject = VasADBannerResDownloadManager.a().a((String)localObject);
    if ((localObject != null) && (((VasADBannerConfigInfo)localObject).a != null) && (((VasADBannerConfigInfo)localObject).a.size() != 0)) {
      return true;
    }
    QLog.i("VasADBannerManager", 1, "isNeedShowVasADBanner configInfo is null, return false.");
    return false;
  }
  
  protected int b()
  {
    return ViewUtils.a();
  }
  
  public void b()
  {
    QLog.e("VasADBannerManager", 1, "onRecycle");
  }
  
  public void b(VasADBannerConfigInfo paramVasADBannerConfigInfo)
  {
    if (paramVasADBannerConfigInfo != null)
    {
      if (paramVasADBannerConfigInfo.a() == null) {
        return;
      }
      if (paramVasADBannerConfigInfo.b())
      {
        TianshuReportUtils.b(paramVasADBannerConfigInfo.a().c, 138, paramVasADBannerConfigInfo.a().jdField_b_of_type_JavaLangString);
        return;
      }
      TianshuReportUtils.b(paramVasADBannerConfigInfo.a().c, 102);
    }
  }
  
  protected int c()
  {
    return (int)(b() * 0.1333333F);
  }
  
  public void c()
  {
    VasADBannerConfigInfo localVasADBannerConfigInfo = VasADBannerResDownloadManager.a().a(a());
    if (localVasADBannerConfigInfo != null)
    {
      if (localVasADBannerConfigInfo.a() == null) {
        return;
      }
      if (localVasADBannerConfigInfo.b())
      {
        TianshuReportUtils.b(localVasADBannerConfigInfo.a().c, 122, localVasADBannerConfigInfo.a().jdField_b_of_type_JavaLangString);
        return;
      }
      TianshuReportUtils.b(localVasADBannerConfigInfo.a().c, 122);
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_ComTencentImageURLImageView != null))
    {
      QLog.i("VasADBannerManager", 1, "start showVasADBanner");
      Object localObject2 = VasADBannerResDownloadManager.a().a(a());
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
          a();
          return;
        }
        if ((!TextUtils.isEmpty(localResourceInfo.c)) && ((((VasADBannerData)localObject1).jdField_a_of_type_Int == 1) || (((VasADBannerData)localObject1).jdField_a_of_type_Int == 0)))
        {
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mLoadingDrawable = URLDrawableHelperConstants.a;
          localURLDrawableOptions.mFailedDrawable = URLDrawableHelperConstants.a;
          localURLDrawableOptions.mRequestWidth = b();
          localURLDrawableOptions.mRequestHeight = c();
          boolean bool;
          if (((VasADBannerData)localObject1).jdField_a_of_type_Int == 1) {
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
            a();
            return;
          }
          this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
          if (((URLDrawable)localObject1).getStatus() == 1)
          {
            this.jdField_a_of_type_AndroidViewView.setVisibility(0);
            QLog.i("VasADBannerManager", 1, "showVasADBanner urlDrawable status is success");
            a((VasADBannerConfigInfo)localObject2);
            SetSplash.a(this.jdField_a_of_type_AndroidViewView);
            return;
          }
          ((URLDrawable)localObject1).setURLDrawableListener(new VasADBannerManager.1(this, (VasADBannerConfigInfo)localObject2));
          ThreadManager.executeOnFileThread(new VasADBannerManager.2(this, (URLDrawable)localObject1));
          return;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("initVasADBanner resType is wrong: ");
        ((StringBuilder)localObject2).append(((VasADBannerData)localObject1).jdField_a_of_type_Int);
        ((StringBuilder)localObject2).append(" file path = ");
        ((StringBuilder)localObject2).append(localResourceInfo.c);
        QLog.i("VasADBannerManager", 1, ((StringBuilder)localObject2).toString());
        a();
        return;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("initVasADBanner config info is null, uin: ");
      ((StringBuilder)localObject1).append(a());
      QLog.i("VasADBannerManager", 1, ((StringBuilder)localObject1).toString());
      a();
      return;
    }
    QLog.e("VasADBannerManager", 1, "showVasADBanner xml init error");
    a();
  }
  
  public void e()
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkIfHideBanner isClick: ");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      QLog.i("VasADBannerManager", 4, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_Boolean)
    {
      a();
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void f()
  {
    Map localMap = this.jdField_a_of_type_JavaUtilMap;
    if (localMap != null) {
      localMap.clear();
    }
  }
  
  public void g()
  {
    if ((this.jdField_b_of_type_Boolean) && (!this.c))
    {
      this.c = true;
      h();
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131368715)
    {
      if (i == 2131368725)
      {
        c();
        a();
        VasADBannerResDownloadManager.a().a(a());
      }
    }
    else
    {
      Object localObject1 = VasADBannerResDownloadManager.a().a(a());
      if ((localObject1 == null) || (((VasADBannerConfigInfo)localObject1).a() == null)) {
        break label587;
      }
      VasADBannerData localVasADBannerData = ((VasADBannerConfigInfo)localObject1).a();
      if ((localVasADBannerData == null) || (TextUtils.isEmpty(localVasADBannerData.jdField_a_of_type_JavaLangString))) {
        break label575;
      }
      b((VasADBannerConfigInfo)localObject1);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("qboss banner jump url = ");
        ((StringBuilder)localObject1).append(localVasADBannerData.jdField_a_of_type_JavaLangString);
        QLog.i("VasADBannerManager", 2, ((StringBuilder)localObject1).toString());
      }
      if (localVasADBannerData.jdField_b_of_type_Int == 1)
      {
        Object localObject2 = localVasADBannerData.jdField_a_of_type_JavaLangString;
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
          ((StringBuilder)localObject2).append(localVasADBannerData.jdField_b_of_type_JavaLangString);
          localObject1 = ((StringBuilder)localObject2).toString();
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("?qboss_trace=");
          ((StringBuilder)localObject2).append(localVasADBannerData.jdField_b_of_type_JavaLangString);
          localObject1 = ((StringBuilder)localObject2).toString();
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(MobileReportManager.getStringQboos2H5(BaseApplicationImpl.getApplication().getRuntime().getAccount(), localVasADBannerData.jdField_b_of_type_JavaLangString, "&"));
        localObject1 = ((StringBuilder)localObject2).toString();
        if (QLog.isDevelopLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("TraceInfo qboss banner final traceInfo jump url = ");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.i("VasADBannerManager", 4, ((StringBuilder)localObject2).toString());
        }
        this.jdField_a_of_type_Boolean = true;
        localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("url", (String)localObject1);
        ((Intent)localObject2).putExtra("big_brother_source_key", "biz_src_jc_vip");
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject2);
      }
      else if (localVasADBannerData.jdField_b_of_type_Int == 2)
      {
        localObject1 = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localVasADBannerData.jdField_a_of_type_JavaLangString);
        if (localObject1 != null)
        {
          this.jdField_a_of_type_Boolean = true;
          ((JumpAction)localObject1).a();
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("jumpAction is null, jump url = ");
          ((StringBuilder)localObject1).append(localVasADBannerData.jdField_a_of_type_JavaLangString);
          QLog.e("VasADBannerManager", 1, ((StringBuilder)localObject1).toString());
        }
      }
    }
    ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 11, 0, "", "", "", "");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.qqbanner.manager.VasADBannerManager
 * JD-Core Version:    0.7.0.1
 */