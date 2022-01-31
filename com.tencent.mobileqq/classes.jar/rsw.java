import android.os.Handler;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity;
import java.lang.ref.WeakReference;

public class rsw
  implements Runnable
{
  public rsw(AuthDevVerifyCodeActivity paramAuthDevVerifyCodeActivity) {}
  
  public void run()
  {
    TextView localTextView;
    if (AuthDevVerifyCodeActivity.b <= 1)
    {
      if (AuthDevVerifyCodeActivity.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        localTextView = (TextView)AuthDevVerifyCodeActivity.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localTextView != null)
        {
          localTextView.setText(2131434293);
          localTextView.setEnabled(true);
          localTextView.setClickable(true);
          return;
        }
      }
      AuthDevVerifyCodeActivity.a(this.a).setText(2131434293);
      AuthDevVerifyCodeActivity.a(this.a).setEnabled(true);
      AuthDevVerifyCodeActivity.a(this.a).setClickable(true);
      return;
    }
    AuthDevVerifyCodeActivity.b -= 1;
    if (AuthDevVerifyCodeActivity.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      localTextView = (TextView)AuthDevVerifyCodeActivity.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localTextView != null)
      {
        localTextView.setText(this.a.getString(2131434293) + "(" + AuthDevVerifyCodeActivity.b + ")");
        this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 1000L);
        return;
      }
    }
    AuthDevVerifyCodeActivity.a(this.a).setText(this.a.getString(2131434293) + "(" + AuthDevVerifyCodeActivity.b + ")");
    this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rsw
 * JD-Core Version:    0.7.0.1
 */