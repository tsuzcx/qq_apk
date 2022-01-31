import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import java.lang.ref.WeakReference;

class ngn
  implements View.OnClickListener
{
  ngn(nfu paramnfu, String paramString) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent("android.intent.action.CALL", Uri.parse("tel:" + this.jdField_a_of_type_JavaLangString));
    ((BaseActivity)this.jdField_a_of_type_Nfu.a.get()).startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ngn
 * JD-Core Version:    0.7.0.1
 */