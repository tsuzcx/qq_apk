import android.animation.ObjectAnimator;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.av.VideoController;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class lwq
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -1L;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new lwr(this);
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new lws(this);
  private View jdField_a_of_type_AndroidViewView;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private VideoController jdField_a_of_type_ComTencentAvVideoController;
  private AVActivity jdField_a_of_type_ComTencentAvUiAVActivity;
  private Queue<Long> jdField_a_of_type_JavaUtilQueue = new LinkedList();
  private lxx jdField_a_of_type_Lxx;
  private boolean jdField_a_of_type_Boolean;
  private ImageView[] jdField_a_of_type_ArrayOfAndroidWidgetImageView = new ImageView[3];
  private int b = -1;
  
  public lwq(View paramView, ViewStub paramViewStub, int paramInt, VideoController paramVideoController, AVActivity paramAVActivity)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidViewViewStub = paramViewStub;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
    this.jdField_a_of_type_ComTencentAvUiAVActivity = paramAVActivity;
    this.jdField_a_of_type_Lxx = new lxx(paramVideoController, paramAVActivity);
    this.jdField_a_of_type_Lxx.a();
    this.jdField_a_of_type_ComTencentAvUiAVActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("tencent.video.q2v.SVIP.PAY"));
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null)
    {
      this.jdField_a_of_type_AndroidViewViewStub.inflate();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(this.jdField_a_of_type_Int));
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0] = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131306770));
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0].setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1] = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131306776));
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1].setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[2] = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131306774));
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[2].setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new lww(this));
      this.b = 0;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_Lxx.a();
    }
    this.b = this.jdField_a_of_type_ComTencentAvVideoController.a().v;
    h();
  }
  
  private void h()
  {
    ImageView localImageView = this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0];
    Resources localResources = this.jdField_a_of_type_AndroidViewView.getResources();
    if (this.b == 0)
    {
      i = 2130841658;
      localImageView.setBackgroundDrawable(localResources.getDrawable(i));
      localImageView = this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1];
      localResources = this.jdField_a_of_type_AndroidViewView.getResources();
      if (this.b != 1) {
        break label111;
      }
      i = 2130841654;
      label60:
      localImageView.setBackgroundDrawable(localResources.getDrawable(i));
      localImageView = this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[2];
      localResources = this.jdField_a_of_type_AndroidViewView.getResources();
      if (this.b != 2) {
        break label117;
      }
    }
    label111:
    label117:
    for (int i = 2130841656;; i = 2130841655)
    {
      localImageView.setBackgroundDrawable(localResources.getDrawable(i));
      return;
      i = 2130841657;
      break;
      i = 2130841653;
      break label60;
    }
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0)) {
      return;
    }
    a();
  }
  
  private void j()
  {
    h();
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      kvq localkvq = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (localkvq != null) {
        this.jdField_a_of_type_ComTencentAvVideoController.a(Long.valueOf(localkvq.d).longValue(), this.b);
      }
    }
  }
  
  public int a()
  {
    return this.b + 1;
  }
  
  public void a()
  {
    g();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (this.jdField_a_of_type_JavaUtilQueue.size() < 5)
    {
      this.jdField_a_of_type_JavaUtilQueue.offer(Long.valueOf(paramLong2));
      if (this.jdField_a_of_type_JavaUtilQueue.size() != 5) {
        break label230;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilQueue.iterator();
      paramLong1 = 0L;
      label53:
      if (!localIterator.hasNext()) {
        break label118;
      }
      if (((Long)localIterator.next()).longValue() >= mhr.b()) {
        break label231;
      }
      paramLong1 = 1L + paramLong1;
    }
    label230:
    label231:
    for (;;)
    {
      break label53;
      this.jdField_a_of_type_JavaUtilQueue.poll();
      this.jdField_a_of_type_JavaUtilQueue.offer(Long.valueOf(paramLong2));
      break;
      label118:
      if (paramLong1 >= 4L)
      {
        paramLong2 = System.currentTimeMillis();
        if (paramLong2 - this.jdField_a_of_type_Long > 10000L)
        {
          this.jdField_a_of_type_Long = paramLong2;
          lqb.a(this.jdField_a_of_type_ComTencentAvVideoController.a, 1057, ajjy.a(2131643122));
          awqx.b(null, "CliOper", "", "", "0X800A346", "0X800A346", 0, 0, "", "", "", "");
        }
        if (QLog.isColorLevel()) {
          QLog.w("QavDoubleVideoSharpnessMangaer", 1, "onReceiveFrameRateInfo frameRate sum/5:=" + paramLong1 / 5L);
        }
      }
      return;
    }
  }
  
  public void a(long paramLong1, long paramLong2, String paramString)
  {
    if (paramLong1 == 0L) {
      if (paramLong2 == 0L) {
        if (QLog.isColorLevel()) {
          QLog.w("QavDoubleVideoSharpnessMangaer", 1, "onReceiveFrameModeResultInfo result ok");
        }
      }
    }
    while (paramLong1 != 1L)
    {
      return;
      lqb.a(this.jdField_a_of_type_ComTencentAvVideoController.a, 1057, paramString);
      return;
    }
    int i;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().v != paramLong2)
    {
      i = 1;
      if (paramLong2 != 0L) {
        break label177;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a().v = 0;
      this.jdField_a_of_type_JavaUtilQueue.clear();
      if (QLog.isColorLevel()) {
        QLog.w("QavDoubleVideoSharpnessMangaer", 1, "onReceiveFrameModeResultInfo 切换到自动模式了");
      }
    }
    for (;;)
    {
      lqb.a(this.jdField_a_of_type_ComTencentAvVideoController.a, 1057, paramString);
      if (i != 0)
      {
        i();
        paramLong1 = AudioHelper.b();
        this.jdField_a_of_type_ComTencentAvUiAVActivity.a.f(paramLong1, 1024);
      }
      this.b = this.jdField_a_of_type_ComTencentAvVideoController.a().v;
      return;
      i = 0;
      break;
      label177:
      if (paramLong2 == 1L)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a().v = 1;
        this.jdField_a_of_type_JavaUtilQueue.clear();
        if (QLog.isColorLevel()) {
          QLog.w("QavDoubleVideoSharpnessMangaer", 1, "onReceiveFrameModeResultInfo 切换到流畅模式了");
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a().v = 2;
        if (QLog.isColorLevel()) {
          QLog.w("QavDoubleVideoSharpnessMangaer", 1, "onReceiveFrameModeResultInfo 切换到高清模式了");
        }
      }
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0);
  }
  
  public void b()
  {
    g();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetRelativeLayout, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator.setDuration(500L);
    localObjectAnimator.setStartDelay(300L);
    localObjectAnimator.addListener(new lwv(this));
    localObjectAnimator.start();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Lxx != null) {
      this.jdField_a_of_type_Lxx.b();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Lxx != null) {
      this.jdField_a_of_type_Lxx.d();
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Lxx != null)
    {
      this.jdField_a_of_type_Lxx.e();
      this.jdField_a_of_type_Lxx = null;
    }
    if (this.jdField_a_of_type_ComTencentAvUiAVActivity != null) {
      this.jdField_a_of_type_ComTencentAvUiAVActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
    if (QLog.isColorLevel()) {
      QLog.w("QavDoubleVideoSharpnessMangaer", 1, "doDestroy");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lwq
 * JD-Core Version:    0.7.0.1
 */