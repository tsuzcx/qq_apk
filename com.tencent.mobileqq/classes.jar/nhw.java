import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;

class nhw
  implements View.OnClickListener
{
  nhw(nhu paramnhu, String paramString) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent("android.intent.action.CALL", Uri.parse("tel:" + this.jdField_a_of_type_JavaLangString));
    nhu.a(this.jdField_a_of_type_Nhu).startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nhw
 * JD-Core Version:    0.7.0.1
 */