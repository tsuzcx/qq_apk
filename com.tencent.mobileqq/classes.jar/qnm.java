import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

public class qnm
{
  private static final String jdField_a_of_type_JavaLangString = ajyc.a(2131716144);
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler = new qnn(this);
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private View jdField_a_of_type_AndroidViewView;
  private qwt jdField_a_of_type_Qwt;
  private View b;
  
  public qnm(FragmentActivity paramFragmentActivity)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
  }
  
  private void a(View paramView1, View paramView2, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_Qwt != null) && (this.jdField_a_of_type_Qwt.isShowing())) {
      this.jdField_a_of_type_Qwt.dismiss();
    }
    if ((paramView1 != null) && ((paramView1.getParent() instanceof ViewGroup))) {
      ((ViewGroup)paramView1.getParent()).removeView(paramView1);
    }
    int i = bawz.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 7.0F);
    int j = bawz.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 12.0F);
    int k = bawz.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 80.0F);
    int m = -(paramInt1 - paramView2.getWidth() + paramView2.getWidth() / 2 - j / 2 - (paramInt1 / 2 - k - j / 2));
    int n = bawz.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, -8.0F);
    this.jdField_a_of_type_Qwt = new qwt(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_Qwt.setAnimationStyle(2131755812);
    this.jdField_a_of_type_Qwt.setContentView(paramView1);
    this.jdField_a_of_type_Qwt.setWidth(paramInt1);
    this.jdField_a_of_type_Qwt.a(k, 0, 0, 0);
    this.jdField_a_of_type_Qwt.a(j, i);
    this.jdField_a_of_type_Qwt.a(j / 2);
    this.jdField_a_of_type_Qwt.b(paramInt2);
    this.jdField_a_of_type_Qwt.c(paramInt3);
    try
    {
      this.jdField_a_of_type_Qwt.showAsDropDown(paramView2, m, n);
      return;
    }
    catch (Exception paramView1)
    {
      QLog.e("VideoFeedsFloatWindowGuideController", 1, "showAtLocation", paramView1);
    }
  }
  
  private void b(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsFloatWindowGuideController", 2, "showPrompt: showGuidePrompt");
    }
    if (this.b == null)
    {
      i = bawz.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 8.0F);
      int j = bawz.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 10.0F);
      TextView localTextView = new TextView(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      localTextView.setId(2131377030);
      localTextView.setGravity(17);
      localTextView.setTextSize(2, 16.0F);
      localTextView.setText(jdField_a_of_type_JavaLangString);
      localTextView.setTextColor(-1);
      localTextView.setPadding(j, i, j, i);
      this.jdField_a_of_type_Int = ((int)localTextView.getPaint().measureText(jdField_a_of_type_JavaLangString) + j * 2);
      this.b = localTextView;
    }
    int i = bawz.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 3.0F);
    a(this.b, paramView, this.jdField_a_of_type_Int, -16777216, i);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Qwt != null) && (this.jdField_a_of_type_Qwt.isShowing())) {
      this.jdField_a_of_type_Qwt.dismiss();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView = paramView;
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsFloatWindowGuideController", 2, "showPrompt: count=" + 0);
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 1000L);
  }
  
  public void b()
  {
    a();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qnm
 * JD-Core Version:    0.7.0.1
 */