import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class mfp
{
  public View a;
  public PopupWindow a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  WeakReference<AVActivity> jdField_a_of_type_JavaLangRefWeakReference;
  boolean jdField_a_of_type_Boolean;
  private Runnable b;
  public boolean b;
  
  private void a(long paramLong)
  {
    EffectSettingUi.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramLong);
    this.jdField_a_of_type_AndroidViewView.postDelayed(this.b, 3000L);
  }
  
  private void a(TextView paramTextView)
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379412) != null)
    {
      paramTextView.setVisibility(0);
      return;
    }
    paramTextView.measure(0, 0);
    int i = paramTextView.getMeasuredWidth();
    int j = paramTextView.getMeasuredHeight();
    Object localObject = new int[2];
    this.jdField_a_of_type_AndroidViewView.getLocationOnScreen((int[])localObject);
    int[] arrayOfInt1 = new int[2];
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLocationOnScreen((int[])localObject);
    int[] arrayOfInt2 = new int[2];
    localObject[0] -= arrayOfInt1[0];
    localObject[1] -= arrayOfInt1[1];
    float f1 = (arrayOfInt2[0] * 2 + this.jdField_a_of_type_AndroidViewView.getWidth() - i) / 2;
    int k = arrayOfInt2[1];
    float f2 = aekt.a(0, this.jdField_a_of_type_AndroidViewView.getResources()) + (k - j);
    QLog.d("qav_face_guide", 1, String.format("host(%s, %s), Parent(%s, %s), cur(%s, %s), dest(%s, %s), textview(%s, %s)", new Object[] { Integer.valueOf(localObject[0]), Integer.valueOf(localObject[1]), Integer.valueOf(arrayOfInt1[0]), Integer.valueOf(arrayOfInt1[1]), Integer.valueOf(arrayOfInt2[0]), Integer.valueOf(arrayOfInt2[1]), Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(j) }));
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(5);
    ((RelativeLayout.LayoutParams)localObject).addRule(6);
    ((RelativeLayout.LayoutParams)localObject).setMargins((int)f1, (int)f2, 0, 0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramTextView, (ViewGroup.LayoutParams)localObject);
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (AudioHelper.a(0) == 1) {}
    do
    {
      return true;
      if (paramBoolean)
      {
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
          return false;
        }
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().au) {
          return false;
        }
        if (!mww.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface)) {
          return false;
        }
      }
      if (this.jdField_a_of_type_AndroidViewView.getVisibility() != 0) {
        return false;
      }
      if (!this.jdField_a_of_type_AndroidViewView.isEnabled()) {
        return false;
      }
    } while (lsa.d());
    return false;
  }
  
  private void b(TextView paramTextView)
  {
    this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(this.jdField_a_of_type_AndroidViewView.getContext());
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setContentView(paramTextView);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setWidth(-2);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setHeight(-2);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setOutsideTouchable(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setAnimationStyle(2131755793);
    paramTextView.measure(0, 0);
    int j = paramTextView.getMeasuredWidth();
    int i = paramTextView.getMeasuredHeight();
    paramTextView = new int[2];
    this.jdField_a_of_type_AndroidViewView.getLocationOnScreen(paramTextView);
    j = (paramTextView[0] * 2 + this.jdField_a_of_type_AndroidViewView.getWidth() - j) / 2;
    int k = paramTextView[1];
    int m = aekt.a(0, this.jdField_a_of_type_AndroidViewView.getResources());
    this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(this.jdField_a_of_type_AndroidViewView, 0, j, k - i + m);
    QLog.d("qav_face_guide", 1, "showUserGuide_PopupWindow");
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow != null)
    {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
      this.jdField_a_of_type_AndroidWidgetPopupWindow = null;
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      TextView localTextView = (TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379412);
      if (localTextView != null)
      {
        localTextView.setVisibility(8);
        localTextView.setOnClickListener(null);
      }
    }
    this.jdField_a_of_type_AndroidViewView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  private void e()
  {
    if (!a(true)) {}
    TextView localTextView;
    do
    {
      do
      {
        return;
        localObject = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      } while (localObject == null);
      localTextView = null;
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        localTextView = (TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379412);
      }
    } while (localTextView == null);
    int i = ((AVActivity)localObject).getWindow().getDecorView().getWidth();
    int j = ((AVActivity)localObject).getWindow().getDecorView().getHeight();
    localTextView.measure(0, 0);
    int k = localTextView.getMeasuredWidth();
    localTextView.getMeasuredHeight();
    Object localObject = new int[2];
    this.jdField_a_of_type_AndroidViewView.getLocationInWindow((int[])localObject);
    int m = localObject[0];
    int n = localObject[1];
    localObject = (RelativeLayout)localTextView.getParent();
    int[] arrayOfInt = new int[2];
    ((RelativeLayout)localObject).getLocationInWindow(arrayOfInt);
    int i1 = i - arrayOfInt[0] - ((RelativeLayout)localObject).getWidth();
    int i2 = j - arrayOfInt[1] - ((RelativeLayout)localObject).getHeight();
    float f1 = i - m - this.jdField_a_of_type_AndroidViewView.getWidth() / 2 - k / 2 - i1 + aekt.a(0.0F, this.jdField_a_of_type_AndroidViewView.getResources());
    float f2 = j - n - i2 - aekt.a(11.0F, this.jdField_a_of_type_AndroidViewView.getResources());
    localObject = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, (int)f1, (int)f2);
    localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    QLog.e("qav_face_guide", 1, "qav_face_guide, location_Host[" + m + n + "], hostTop[" + n + "], hostRight[" + n + "], hostBottom[" + n + "], offsetDP_right[" + 0.0F + "], offsetDP_bottom[" + 11.0F + "], pos_right[" + f1 + "], pos_bottom[" + f2 + "], hostID[" + this.jdField_a_of_type_AndroidViewView.getId() + "], Width[" + this.jdField_a_of_type_AndroidViewView.getWidth() + "], Height[" + this.jdField_a_of_type_AndroidViewView.getHeight() + "], textViewWidth[" + k + "], parentRight[" + i1 + "], parentBottom[" + i2 + "]");
    localTextView.getViewTreeObserver().addOnPreDrawListener(new mfq(this, localTextView));
    d();
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      b(localTextView);
    }
    for (;;)
    {
      localTextView.setOnClickListener(new mfr(this));
      return;
      a(localTextView);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().au = true;
    mww.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    d();
  }
  
  public void b()
  {
    d();
  }
  
  public void c()
  {
    d();
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_AndroidViewView.removeCallbacks(this.b);
    this.jdField_a_of_type_AndroidViewView = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mfp
 * JD-Core Version:    0.7.0.1
 */