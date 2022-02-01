package cooperation.vip.qqbanner;

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
import com.tencent.mobileqq.activity.recent.QbossADBannerConfigInfo;
import com.tencent.mobileqq.activity.recent.QbossADBannerConfigInfo.ResourceInfo;
import com.tencent.mobileqq.activity.recent.QbossADBannerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.apng.api.VasApngFactory;
import com.tencent.mobileqq.vas.apng.api.VasApngFactory.Options;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.Timer;
import java.util.TimerTask;

public class QbossADCountDownInmersionBannerManager
  extends QbossADBannerManager
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private QbossADBannerCountDownImmersionInfo jdField_a_of_type_CooperationVipQqbannerQbossADBannerCountDownImmersionInfo;
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
  
  private URLDrawable a(QbossADBannerCountDownImmersionInfo paramQbossADBannerCountDownImmersionInfo, int paramInt)
  {
    paramQbossADBannerCountDownImmersionInfo = (QbossADBannerConfigInfo.ResourceInfo)paramQbossADBannerCountDownImmersionInfo.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (paramQbossADBannerCountDownImmersionInfo == null)
    {
      QLog.e("QbossADCountDownInmersi", 1, "getApngDrawable error,type = " + paramInt);
      return null;
    }
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = URLDrawableHelper.TRANSPARENT;
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = false;
    localObject = URLDrawable.getFileDrawable(paramQbossADBannerCountDownImmersionInfo.c, (URLDrawable.URLDrawableOptions)localObject);
    if (((URLDrawable)localObject).getStatus() == 1) {
      QLog.i("QbossADCountDownInmersi", 1, "getLocalDrawable urlDrawable has memory data , url = " + paramQbossADBannerCountDownImmersionInfo.a);
    }
    for (;;)
    {
      return localObject;
      ((URLDrawable)localObject).setURLDrawableListener(new QbossADCountDownInmersionBannerManager.2(this, paramQbossADBannerCountDownImmersionInfo));
      ThreadManager.executeOnFileThread(new QbossADCountDownInmersionBannerManager.3(this, (URLDrawable)localObject));
    }
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
    return b(l2) + ":" + b(paramLong) + ":" + b(l1 % 60L);
  }
  
  private URLDrawable b(QbossADBannerCountDownImmersionInfo paramQbossADBannerCountDownImmersionInfo, int paramInt)
  {
    VasApngFactory.Options localOptions = new VasApngFactory.Options();
    localOptions.a(new ColorDrawable(7));
    localOptions.a(true);
    localOptions.a(new int[] { 2 });
    Object localObject = (QbossADBannerConfigInfo.ResourceInfo)paramQbossADBannerCountDownImmersionInfo.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject == null)
    {
      QLog.e("QbossADCountDownInmersi", 1, "getApngDrawable error,type = " + paramInt);
      return null;
    }
    paramQbossADBannerCountDownImmersionInfo = ((QbossADBannerConfigInfo.ResourceInfo)localObject).a;
    localObject = ((QbossADBannerConfigInfo.ResourceInfo)localObject).c;
    if (!FileUtils.d((String)localObject)) {
      paramQbossADBannerCountDownImmersionInfo = VasApngFactory.a("", localOptions, (String)localObject);
    }
    for (;;)
    {
      return paramQbossADBannerCountDownImmersionInfo;
      if (paramQbossADBannerCountDownImmersionInfo.startsWith("https://")) {
        paramQbossADBannerCountDownImmersionInfo = VasApngFactory.a(paramQbossADBannerCountDownImmersionInfo, localOptions);
      } else {
        paramQbossADBannerCountDownImmersionInfo = null;
      }
    }
  }
  
  private String b(long paramLong)
  {
    if ((paramLong >= 0L) && (paramLong < 10L)) {
      return "0" + Long.toString(paramLong);
    }
    return "" + paramLong;
  }
  
  private void b(QbossADBannerConfigInfo paramQbossADBannerConfigInfo)
  {
    if (paramQbossADBannerConfigInfo == null) {}
    while (!(paramQbossADBannerConfigInfo instanceof QbossADBannerCountDownImmersionInfo)) {
      return;
    }
    this.jdField_a_of_type_CooperationVipQqbannerQbossADBannerCountDownImmersionInfo = ((QbossADBannerCountDownImmersionInfo)paramQbossADBannerConfigInfo);
    this.jdField_a_of_type_ComTencentImageURLDrawable = b((QbossADBannerCountDownImmersionInfo)paramQbossADBannerConfigInfo, 5);
    this.jdField_b_of_type_ComTencentImageURLDrawable = b((QbossADBannerCountDownImmersionInfo)paramQbossADBannerConfigInfo, 6);
    this.jdField_c_of_type_ComTencentImageURLDrawable = a((QbossADBannerCountDownImmersionInfo)paramQbossADBannerConfigInfo, 3);
    this.jdField_d_of_type_ComTencentImageURLDrawable = a((QbossADBannerCountDownImmersionInfo)paramQbossADBannerConfigInfo, 4);
    this.e = a((QbossADBannerCountDownImmersionInfo)paramQbossADBannerConfigInfo, 7);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a(this.jdField_a_of_type_CooperationVipQqbannerQbossADBannerCountDownImmersionInfo.i));
    o();
    this.jdField_a_of_type_Long = (this.jdField_a_of_type_CooperationVipQqbannerQbossADBannerCountDownImmersionInfo.jdField_a_of_type_Long * 1000L);
    long l = (this.jdField_a_of_type_Long - System.currentTimeMillis()) / 1000L;
    QLog.e("QbossADCountDownInmersi", 1, "handleBannerShow countDownTotalTime = " + l + " mCountDownTime = " + this.jdField_a_of_type_Long + " countDownTotalTime = " + l);
    if (l > 0L)
    {
      l();
      return;
    }
    m();
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if (this.jdField_b_of_type_ComTencentImageURLDrawable != null) {
        this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_b_of_type_ComTencentImageURLDrawable);
      }
      if (this.jdField_d_of_type_ComTencentImageURLDrawable != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_d_of_type_ComTencentImageURLDrawable);
      }
      if (this.e != null) {
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.e);
      }
    }
    do
    {
      return;
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentImageURLDrawable != null) {
        this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
      }
    } while (this.jdField_a_of_type_AndroidWidgetImageView == null);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_c_of_type_ComTencentImageURLDrawable);
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
      localObject = this.jdField_d_of_type_AndroidWidgetImageView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = ((int)(localLayoutParams.height * 2.20339F));
      ((ViewGroup.LayoutParams)localObject).height = localLayoutParams.height;
      this.jdField_d_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localLayoutParams = this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams.width = ViewUtils.b(40.0F);
      localLayoutParams.height = ViewUtils.b(40.0F);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      localLayoutParams = this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams.width = ViewUtils.b(244.0F);
      localLayoutParams.height = ViewUtils.b(38.0F);
      this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      return;
    }
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app == null)) {
      return;
    }
    QLog.i("QbossADCountDownInmersi", 1, "notifyBannerShow");
    Message localMessage = Message.obtain();
    localMessage.what = 3000;
    localMessage.obj = new View[] { this.jdField_a_of_type_AndroidViewView, this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_c_of_type_AndroidWidgetTextView, this.jdField_c_of_type_AndroidWidgetImageView };
    BannerManager.a().b(23, localMessage);
  }
  
  private void k()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app == null)) {
      return;
    }
    QLog.i("QbossADCountDownInmersi", 1, "notifyBannerHide");
    BannerManager.a().b(23, 3001);
  }
  
  private void l()
  {
    b(false);
    QLog.e("QbossADCountDownInmersi", 1, "startCountDown");
    n();
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.jdField_a_of_type_JavaUtilTimerTask = new QbossADCountDownInmersionBannerManager.4(this);
    this.jdField_a_of_type_JavaUtilTimer.schedule(this.jdField_a_of_type_JavaUtilTimerTask, 0L, 1000L);
  }
  
  private void m()
  {
    QLog.e("QbossADCountDownInmersi", 1, "countDownComplete");
    n();
    b(true);
  }
  
  private void n()
  {
    QLog.e("QbossADCountDownInmersi", 1, "stopTimer");
    if (this.jdField_a_of_type_JavaUtilTimerTask != null) {
      this.jdField_a_of_type_JavaUtilTimerTask.cancel();
    }
    if (this.jdField_a_of_type_JavaUtilTimer != null) {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
    }
    this.jdField_a_of_type_JavaUtilTimer = null;
    this.jdField_a_of_type_JavaUtilTimerTask = null;
  }
  
  private void o()
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
  
  public int a()
  {
    return 2131562096;
  }
  
  public View a()
  {
    View localView = super.a();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131380287));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368821));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368822));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131380163));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131380170));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131365371));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368806));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131365362));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131370201));
    i();
    return new View(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  }
  
  public void a(QbossADBannerConfigInfo paramQbossADBannerConfigInfo)
  {
    super.a(paramQbossADBannerConfigInfo);
    ThreadManagerV2.getUIHandlerV2().post(new QbossADCountDownInmersionBannerManager.1(this, paramQbossADBannerConfigInfo));
  }
  
  public int c()
  {
    this.jdField_a_of_type_Int = super.c();
    return this.jdField_a_of_type_Int + ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication()) + ViewUtils.b(50.0F);
  }
  
  public void c()
  {
    super.c();
    j();
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_CooperationVipQqbannerQbossADBannerCountDownImmersionInfo != null) && (this.jdField_a_of_type_CooperationVipQqbannerQbossADBannerCountDownImmersionInfo.jdField_a_of_type_Boolean)) {
      return;
    }
    super.d();
  }
  
  public void e()
  {
    super.e();
    k();
    n();
  }
  
  public void f()
  {
    super.f();
    n();
    this.jdField_b_of_type_ComTencentImageURLDrawable = null;
    this.jdField_a_of_type_ComTencentImageURLDrawable = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.qqbanner.QbossADCountDownInmersionBannerManager
 * JD-Core Version:    0.7.0.1
 */