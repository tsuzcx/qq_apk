import android.annotation.SuppressLint;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

public class rcn
{
  private static final String jdField_a_of_type_JavaLangString = alud.a(2131716539);
  private int jdField_a_of_type_Int;
  @SuppressLint({"HandlerLeak"})
  private Handler jdField_a_of_type_AndroidOsHandler = new rco(this);
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private View jdField_a_of_type_AndroidViewView;
  private rgx jdField_a_of_type_Rgx;
  private rmf jdField_a_of_type_Rmf;
  private View b;
  
  public rcn(FragmentActivity paramFragmentActivity)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
  }
  
  private void a(View paramView1, View paramView2, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_Rmf != null) && (this.jdField_a_of_type_Rmf.isShowing())) {
      this.jdField_a_of_type_Rmf.dismiss();
    }
    if ((paramView1 != null) && ((paramView1.getParent() instanceof ViewGroup))) {
      ((ViewGroup)paramView1.getParent()).removeView(paramView1);
    }
    int i = bdaq.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 7.0F);
    int j = bdaq.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 12.0F);
    int k = bdaq.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 80.0F);
    int m = -(paramInt1 - paramView2.getWidth() + paramView2.getWidth() / 2 - j / 2 - (paramInt1 / 2 - k - j / 2));
    int n = bdaq.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, -8.0F);
    this.jdField_a_of_type_Rmf = new rmf(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_Rmf.setAnimationStyle(2131755823);
    this.jdField_a_of_type_Rmf.setContentView(paramView1);
    this.jdField_a_of_type_Rmf.setWidth(paramInt1);
    this.jdField_a_of_type_Rmf.a(k, 0, 0, 0);
    this.jdField_a_of_type_Rmf.a(j, i);
    this.jdField_a_of_type_Rmf.a(j / 2);
    this.jdField_a_of_type_Rmf.b(paramInt2);
    this.jdField_a_of_type_Rmf.c(paramInt3);
    try
    {
      this.jdField_a_of_type_Rmf.showAsDropDown(paramView2, m, n);
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
      i = bdaq.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 8.0F);
      int j = bdaq.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 10.0F);
      TextView localTextView = new TextView(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      localTextView.setId(2131377606);
      localTextView.setGravity(17);
      localTextView.setTextSize(2, 16.0F);
      localTextView.setText(jdField_a_of_type_JavaLangString);
      localTextView.setTextColor(-1);
      localTextView.setPadding(j, i, j, i);
      this.jdField_a_of_type_Int = ((int)localTextView.getPaint().measureText(jdField_a_of_type_JavaLangString) + j * 2);
      this.b = localTextView;
    }
    int i = bdaq.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 3.0F);
    a(this.b, paramView, this.jdField_a_of_type_Int, -16777216, i);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Rmf != null) && (this.jdField_a_of_type_Rmf.isShowing())) {
      this.jdField_a_of_type_Rmf.dismiss();
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
  
  public void a(rgx paramrgx)
  {
    this.jdField_a_of_type_Rgx = paramrgx;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Rmf != null) && (this.jdField_a_of_type_Rmf.isShowing());
  }
  
  public void b()
  {
    a();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rcn
 * JD-Core Version:    0.7.0.1
 */