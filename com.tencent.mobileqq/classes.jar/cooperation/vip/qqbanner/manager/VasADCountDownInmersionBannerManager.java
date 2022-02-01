package cooperation.vip.qqbanner.manager;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.recent.bannerprocessor.VasADBannerProcessor;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.vip.qqbanner.data.CountDownImmersionData;
import cooperation.vip.qqbanner.info.VasADBannerConfigInfo;
import cooperation.vip.qqbanner.info.VasADBannerConfigInfo.ResourceInfo;
import cooperation.vip.qqbanner.info.VasADBannerCountDownImmersionInfo;
import java.util.Timer;
import java.util.TimerTask;

public class VasADCountDownInmersionBannerManager
  extends VasADBannerManager
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private VasADBannerCountDownImmersionInfo jdField_a_of_type_CooperationVipQqbannerInfoVasADBannerCountDownImmersionInfo;
  private Timer jdField_a_of_type_JavaUtilTimer;
  private TimerTask jdField_a_of_type_JavaUtilTimerTask;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private URLDrawable jdField_b_of_type_ComTencentImageURLDrawable;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private URLDrawable jdField_c_of_type_ComTencentImageURLDrawable;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private URLDrawable jdField_d_of_type_ComTencentImageURLDrawable;
  private URLDrawable e;
  
  private URLDrawable a(VasADBannerCountDownImmersionInfo paramVasADBannerCountDownImmersionInfo, int paramInt)
  {
    paramVasADBannerCountDownImmersionInfo = (VasADBannerConfigInfo.ResourceInfo)paramVasADBannerCountDownImmersionInfo.a.get(paramInt);
    if (paramVasADBannerCountDownImmersionInfo == null)
    {
      paramVasADBannerCountDownImmersionInfo = new StringBuilder();
      paramVasADBannerCountDownImmersionInfo.append("getApngDrawable error,type = ");
      paramVasADBannerCountDownImmersionInfo.append(paramInt);
      QLog.e("QbossADCountDownInmersi", 1, paramVasADBannerCountDownImmersionInfo.toString());
      return null;
    }
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = URLDrawableHelper.TRANSPARENT;
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = false;
    localObject = URLDrawable.getFileDrawable(paramVasADBannerCountDownImmersionInfo.c, (URLDrawable.URLDrawableOptions)localObject);
    if (((URLDrawable)localObject).getStatus() == 1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getLocalDrawable urlDrawable has memory data , url = ");
      localStringBuilder.append(paramVasADBannerCountDownImmersionInfo.a);
      QLog.i("QbossADCountDownInmersi", 1, localStringBuilder.toString());
      return localObject;
    }
    ((URLDrawable)localObject).setURLDrawableListener(new VasADCountDownInmersionBannerManager.2(this, paramVasADBannerCountDownImmersionInfo));
    ThreadManager.executeOnFileThread(new VasADCountDownInmersionBannerManager.3(this, (URLDrawable)localObject));
    return localObject;
  }
  
  private String a(long paramLong)
  {
    long l2 = 0L;
    if (paramLong <= 0L) {
      return "00:00:00";
    }
    long l1 = paramLong;
    if (paramLong >= 3600L)
    {
      l2 = paramLong / 3600L;
      l1 = paramLong % 3600L;
    }
    paramLong = l1 / 60L;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b(l2));
    localStringBuilder.append(":");
    localStringBuilder.append(b(paramLong));
    localStringBuilder.append(":");
    localStringBuilder.append(b(l1 % 60L));
    return localStringBuilder.toString();
  }
  
  private URLDrawable b(VasADBannerCountDownImmersionInfo paramVasADBannerCountDownImmersionInfo, int paramInt)
  {
    ApngOptions localApngOptions = new ApngOptions();
    localApngOptions.a(new ColorDrawable(7));
    localApngOptions.a(true);
    localApngOptions.a(new int[] { 2 });
    Object localObject = (VasADBannerConfigInfo.ResourceInfo)paramVasADBannerCountDownImmersionInfo.a.get(paramInt);
    paramVasADBannerCountDownImmersionInfo = null;
    if (localObject == null)
    {
      paramVasADBannerCountDownImmersionInfo = new StringBuilder();
      paramVasADBannerCountDownImmersionInfo.append("getApngDrawable error,type = ");
      paramVasADBannerCountDownImmersionInfo.append(paramInt);
      QLog.e("QbossADCountDownInmersi", 1, paramVasADBannerCountDownImmersionInfo.toString());
      return null;
    }
    String str = ((VasADBannerConfigInfo.ResourceInfo)localObject).a;
    localObject = ((VasADBannerConfigInfo.ResourceInfo)localObject).c;
    if (!FileUtils.isEmptyFile((String)localObject)) {
      return ((IVasApngFactory)QRoute.api(IVasApngFactory.class)).getApngURLDrawable("", localApngOptions, (String)localObject);
    }
    if (str.startsWith("https://")) {
      paramVasADBannerCountDownImmersionInfo = ((IVasApngFactory)QRoute.api(IVasApngFactory.class)).getApngURLDrawable(str, localApngOptions);
    }
    return paramVasADBannerCountDownImmersionInfo;
  }
  
  private String b(long paramLong)
  {
    if ((paramLong >= 0L) && (paramLong < 10L))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("0");
      localStringBuilder.append(Long.toString(paramLong));
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramLong);
    return localStringBuilder.toString();
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    URLDrawable localURLDrawable;
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      localURLDrawable = this.jdField_b_of_type_ComTencentImageURLDrawable;
      if (localURLDrawable != null) {
        this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(localURLDrawable);
      }
      localURLDrawable = this.jdField_d_of_type_ComTencentImageURLDrawable;
      if (localURLDrawable != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(localURLDrawable);
      }
      if (this.e != null) {
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.e);
      }
    }
    else
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localURLDrawable = this.jdField_a_of_type_ComTencentImageURLDrawable;
      if (localURLDrawable != null) {
        this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(localURLDrawable);
      }
      localURLDrawable = this.jdField_c_of_type_ComTencentImageURLDrawable;
      if (localURLDrawable != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localURLDrawable);
      }
    }
  }
  
  private void c(VasADBannerConfigInfo paramVasADBannerConfigInfo)
  {
    if (paramVasADBannerConfigInfo == null) {
      return;
    }
    if ((paramVasADBannerConfigInfo instanceof VasADBannerCountDownImmersionInfo))
    {
      paramVasADBannerConfigInfo = (VasADBannerCountDownImmersionInfo)paramVasADBannerConfigInfo;
      this.jdField_a_of_type_CooperationVipQqbannerInfoVasADBannerCountDownImmersionInfo = paramVasADBannerConfigInfo;
      CountDownImmersionData localCountDownImmersionData = this.jdField_a_of_type_CooperationVipQqbannerInfoVasADBannerCountDownImmersionInfo.a();
      if (localCountDownImmersionData == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentImageURLDrawable = b(paramVasADBannerConfigInfo, 5);
      this.jdField_b_of_type_ComTencentImageURLDrawable = b(paramVasADBannerConfigInfo, 6);
      this.jdField_c_of_type_ComTencentImageURLDrawable = a(paramVasADBannerConfigInfo, 3);
      this.jdField_d_of_type_ComTencentImageURLDrawable = a(paramVasADBannerConfigInfo, 4);
      this.e = a(paramVasADBannerConfigInfo, 7);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a(localCountDownImmersionData.e));
      n();
      this.jdField_a_of_type_Long = (localCountDownImmersionData.jdField_a_of_type_Long * 1000L);
      long l = (this.jdField_a_of_type_Long - System.currentTimeMillis()) / 1000L;
      paramVasADBannerConfigInfo = new StringBuilder();
      paramVasADBannerConfigInfo.append("handleBannerShow countDownTotalTime = ");
      paramVasADBannerConfigInfo.append(l);
      paramVasADBannerConfigInfo.append(" mCountDownTime = ");
      paramVasADBannerConfigInfo.append(this.jdField_a_of_type_Long);
      paramVasADBannerConfigInfo.append(" countDownTotalTime = ");
      paramVasADBannerConfigInfo.append(l);
      QLog.e("QbossADCountDownInmersi", 1, paramVasADBannerConfigInfo.toString());
      if (l > 0L)
      {
        k();
        return;
      }
      l();
    }
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
    localObject2 = this.jdField_d_of_type_AndroidWidgetImageView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject2).width = ((int)(((ViewGroup.LayoutParams)localObject1).height * 2.20339F));
    ((ViewGroup.LayoutParams)localObject2).height = ((ViewGroup.LayoutParams)localObject1).height;
    this.jdField_d_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject1 = this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject1).width = ViewUtils.b(40.0F);
    ((ViewGroup.LayoutParams)localObject1).height = ViewUtils.b(40.0F);
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject1).width = ViewUtils.b(244.0F);
    ((ViewGroup.LayoutParams)localObject1).height = ViewUtils.b(38.0F);
    this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app == null) {
        return;
      }
      QLog.i("QbossADCountDownInmersi", 1, "notifyBannerShow");
      Message localMessage = Message.obtain();
      localMessage.what = 3000;
      localMessage.obj = new View[] { this.jdField_a_of_type_AndroidViewView, this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_c_of_type_AndroidWidgetTextView, this.jdField_c_of_type_AndroidWidgetImageView };
      BannerManager.a().b(VasADBannerProcessor.jdField_a_of_type_Int, localMessage);
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app == null) {
        return;
      }
      QLog.i("QbossADCountDownInmersi", 1, "notifyBannerHide");
      BannerManager.a().b(VasADBannerProcessor.jdField_a_of_type_Int, 3001);
    }
  }
  
  private void k()
  {
    b(false);
    QLog.e("QbossADCountDownInmersi", 1, "startCountDown");
    m();
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.jdField_a_of_type_JavaUtilTimerTask = new VasADCountDownInmersionBannerManager.4(this);
    this.jdField_a_of_type_JavaUtilTimer.schedule(this.jdField_a_of_type_JavaUtilTimerTask, 0L, 1000L);
  }
  
  private void l()
  {
    QLog.e("QbossADCountDownInmersi", 1, "countDownComplete");
    m();
    b(true);
  }
  
  private void m()
  {
    QLog.e("QbossADCountDownInmersi", 1, "stopTimer");
    Object localObject = this.jdField_a_of_type_JavaUtilTimerTask;
    if (localObject != null) {
      ((TimerTask)localObject).cancel();
    }
    localObject = this.jdField_a_of_type_JavaUtilTimer;
    if (localObject != null) {
      ((Timer)localObject).cancel();
    }
    this.jdField_a_of_type_JavaUtilTimer = null;
    this.jdField_a_of_type_JavaUtilTimerTask = null;
  }
  
  private void n()
  {
    Object localObject = BaseApplicationImpl.getApplication().getAssets();
    if (localObject != null)
    {
      localObject = Typeface.createFromAsset((AssetManager)localObject, "fonts/DIN Alternate.ttf");
      if (localObject != null)
      {
        QLog.e("QbossADCountDownInmersi", 1, "setTypeFace");
        this.jdField_a_of_type_AndroidWidgetTextView.setTypeface((Typeface)localObject);
      }
    }
  }
  
  protected int a()
  {
    return 2131561932;
  }
  
  public View a()
  {
    View localView = super.a();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379599));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368549));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368550));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379486));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379492));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131365235));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368535));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131365226));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131369870));
    h();
    return new View(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  }
  
  public void a()
  {
    super.a();
    j();
    m();
  }
  
  protected void a(VasADBannerConfigInfo paramVasADBannerConfigInfo)
  {
    super.a(paramVasADBannerConfigInfo);
    ThreadManagerV2.getUIHandlerV2().post(new VasADCountDownInmersionBannerManager.1(this, paramVasADBannerConfigInfo));
  }
  
  public void b()
  {
    super.b();
    m();
    this.jdField_b_of_type_ComTencentImageURLDrawable = null;
    this.jdField_a_of_type_ComTencentImageURLDrawable = null;
  }
  
  protected int c()
  {
    this.jdField_a_of_type_Int = super.c();
    return this.jdField_a_of_type_Int + ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication()) + ViewUtils.b(50.0F);
  }
  
  public void d()
  {
    super.d();
    i();
  }
  
  public void e()
  {
    Object localObject = this.jdField_a_of_type_CooperationVipQqbannerInfoVasADBannerCountDownImmersionInfo;
    if (localObject != null)
    {
      localObject = ((VasADBannerCountDownImmersionInfo)localObject).a();
      if ((localObject != null) && (((CountDownImmersionData)localObject).jdField_a_of_type_Boolean)) {
        return;
      }
    }
    super.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.qqbanner.manager.VasADCountDownInmersionBannerManager
 * JD-Core Version:    0.7.0.1
 */