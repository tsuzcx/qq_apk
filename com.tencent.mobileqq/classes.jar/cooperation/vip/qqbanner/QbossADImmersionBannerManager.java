package cooperation.vip.qqbanner;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.QbossADBannerConfigInfo;
import com.tencent.mobileqq.activity.recent.QbossADBannerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.zipanimate.ZipAnimationDrawable;

public class QbossADImmersionBannerManager
  extends QbossADBannerManager
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ZipAnimationDrawable jdField_a_of_type_CooperationQzoneZipanimateZipAnimationDrawable;
  private QbossADBannerImmersionInfo jdField_a_of_type_CooperationVipQqbannerQbossADBannerImmersionInfo;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  private TextView d;
  
  private int a(QbossADBannerImmersionInfo paramQbossADBannerImmersionInfo)
  {
    if ((paramQbossADBannerImmersionInfo == null) || (TextUtils.isEmpty(paramQbossADBannerImmersionInfo.k))) {
      return 24;
    }
    try
    {
      int i = Integer.parseInt(paramQbossADBannerImmersionInfo.k);
      return i;
    }
    catch (Exception paramQbossADBannerImmersionInfo)
    {
      paramQbossADBannerImmersionInfo.printStackTrace();
      QLog.i("QbossADBannerManager", 1, "getFrameRate exception");
    }
    return 24;
  }
  
  private void i()
  {
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    if (localLayoutParams == null) {
      localLayoutParams = new ViewGroup.LayoutParams(-1, -2);
    }
    for (;;)
    {
      localLayoutParams.width = b();
      localLayoutParams.height = c();
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      Object localObject = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication());
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = b();
      ((ViewGroup.LayoutParams)localObject).height = super.c();
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = ((int)(localLayoutParams.height * 2.050848F));
      ((ViewGroup.LayoutParams)localObject).height = localLayoutParams.height;
      this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidViewView.addOnLayoutChangeListener(new QbossADImmersionBannerManager.1(this));
      return;
    }
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app == null)) {
      return;
    }
    QLog.i("QbossADBannerManager", 1, "notifyBannerShow");
    Message localMessage = Message.obtain();
    localMessage.what = 3000;
    localMessage.obj = new View[] { this.jdField_a_of_type_AndroidViewView, this.c, this.d, this.jdField_a_of_type_AndroidWidgetImageView };
    BannerManager.a().b(23, localMessage);
  }
  
  private void k()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app == null)) {
      return;
    }
    QLog.i("QbossADBannerManager", 1, "notifyBannerHide");
    BannerManager.a().b(23, 3001);
  }
  
  public int a()
  {
    return 2131562097;
  }
  
  public View a()
  {
    View localView = super.a();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131380455));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131380588));
    this.c = ((TextView)localView.findViewById(2131380163));
    this.d = ((TextView)localView.findViewById(2131380170));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131365371));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368806));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131365362));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131370201));
    i();
    return new View(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  }
  
  public void a(QbossADBannerConfigInfo paramQbossADBannerConfigInfo)
  {
    super.a(paramQbossADBannerConfigInfo);
    ThreadManagerV2.getUIHandlerV2().post(new QbossADImmersionBannerManager.2(this, paramQbossADBannerConfigInfo));
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (this.jdField_a_of_type_CooperationQzoneZipanimateZipAnimationDrawable != null)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_CooperationQzoneZipanimateZipAnimationDrawable.stop();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_CooperationQzoneZipanimateZipAnimationDrawable.start();
  }
  
  public int c()
  {
    return super.c() + ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication()) + ViewUtils.b(50.0F);
  }
  
  public void c()
  {
    super.c();
    j();
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_CooperationQzoneZipanimateZipAnimationDrawable != null)
    {
      this.jdField_a_of_type_CooperationQzoneZipanimateZipAnimationDrawable.stop();
      this.jdField_a_of_type_CooperationQzoneZipanimateZipAnimationDrawable.release();
    }
    k();
  }
  
  public void f()
  {
    super.f();
    if (this.jdField_a_of_type_CooperationQzoneZipanimateZipAnimationDrawable != null)
    {
      this.jdField_a_of_type_CooperationQzoneZipanimateZipAnimationDrawable.stop();
      this.jdField_a_of_type_CooperationQzoneZipanimateZipAnimationDrawable.release();
      this.jdField_a_of_type_CooperationQzoneZipanimateZipAnimationDrawable = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.qqbanner.QbossADImmersionBannerManager
 * JD-Core Version:    0.7.0.1
 */