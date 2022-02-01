package cooperation.vip.qqbanner.manager;

import android.graphics.drawable.Drawable;
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
import com.tencent.mobileqq.activity.recent.bannerprocessor.VasADBannerProcessor;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.vip.qqbanner.data.ImmersionData;
import cooperation.vip.qqbanner.info.VasADBannerConfigInfo;
import cooperation.vip.qqbanner.info.VasADBannerImmersionInfo;

public class VasADImmersionBannerManager
  extends VasADBannerManager
{
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private VasADBannerImmersionInfo jdField_a_of_type_CooperationVipQqbannerInfoVasADBannerImmersionInfo;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  private TextView d;
  
  private int a(VasADBannerImmersionInfo paramVasADBannerImmersionInfo)
  {
    if (paramVasADBannerImmersionInfo == null) {
      return 24;
    }
    paramVasADBannerImmersionInfo = this.jdField_a_of_type_CooperationVipQqbannerInfoVasADBannerImmersionInfo.a;
    if (paramVasADBannerImmersionInfo != null)
    {
      if (TextUtils.isEmpty(paramVasADBannerImmersionInfo.f)) {
        return 24;
      }
      try
      {
        int i = Integer.parseInt(paramVasADBannerImmersionInfo.f);
        return i;
      }
      catch (Exception paramVasADBannerImmersionInfo)
      {
        paramVasADBannerImmersionInfo.printStackTrace();
        QLog.i("VasADBannerManager", 1, "getFrameRate exception");
      }
    }
    return 24;
  }
  
  private void h()
  {
    Object localObject2 = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ViewGroup.LayoutParams(-1, -2);
    }
    ((ViewGroup.LayoutParams)localObject1).width = b();
    ((ViewGroup.LayoutParams)localObject1).height = c();
    this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject2 = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject2).topMargin = ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication());
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject2 = this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject2).width = b();
    ((ViewGroup.LayoutParams)localObject2).height = super.c();
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject2 = this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject2).width = ((int)(((ViewGroup.LayoutParams)localObject1).height * 2.050848F));
    ((ViewGroup.LayoutParams)localObject2).height = ((ViewGroup.LayoutParams)localObject1).height;
    this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    this.jdField_a_of_type_AndroidViewView.addOnLayoutChangeListener(new VasADImmersionBannerManager.1(this));
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app == null) {
        return;
      }
      QLog.i("VasADBannerManager", 1, "notifyBannerShow");
      Message localMessage = Message.obtain();
      localMessage.what = 3000;
      localMessage.obj = new View[] { this.jdField_a_of_type_AndroidViewView, this.c, this.d, this.jdField_a_of_type_AndroidWidgetImageView };
      BannerManager.a().b(VasADBannerProcessor.a, localMessage);
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app == null) {
        return;
      }
      QLog.i("VasADBannerManager", 1, "notifyBannerHide");
      BannerManager.a().b(VasADBannerProcessor.a, 3001);
    }
  }
  
  protected int a()
  {
    return 2131561933;
  }
  
  public View a()
  {
    View localView = super.a();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379767));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379870));
    this.c = ((TextView)localView.findViewById(2131379486));
    this.d = ((TextView)localView.findViewById(2131379492));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131365235));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368535));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131365226));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131369870));
    h();
    return new View(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).stop(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).release(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    j();
  }
  
  protected void a(VasADBannerConfigInfo paramVasADBannerConfigInfo)
  {
    super.a(paramVasADBannerConfigInfo);
    ThreadManagerV2.getUIHandlerV2().post(new VasADImmersionBannerManager.2(this, paramVasADBannerConfigInfo));
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      if (paramBoolean)
      {
        ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).stop(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        return;
      }
      ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).start(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).stop(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).release(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    }
  }
  
  protected int c()
  {
    return super.c() + ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication()) + ViewUtils.b(50.0F);
  }
  
  public void d()
  {
    super.d();
    i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.qqbanner.manager.VasADImmersionBannerManager
 * JD-Core Version:    0.7.0.1
 */