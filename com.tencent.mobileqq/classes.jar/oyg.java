import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.mobileqq.forward.ForwardBaseOption;

class oyg
  implements Runnable
{
  oyg(oyf paramoyf, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Oyf.a.isFinishing()) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 1);
    localBundle.putString("forward_filepath", this.jdField_a_of_type_JavaLangString);
    localBundle.putString("forward_thumb", this.jdField_a_of_type_JavaLangString);
    localBundle.putString("forward_urldrawable_big_url", this.jdField_a_of_type_JavaLangString);
    localBundle.putString("forward_extra", this.jdField_a_of_type_JavaLangString);
    Intent localIntent = new Intent();
    localIntent.putExtras(localBundle);
    ForwardBaseOption.a(this.jdField_a_of_type_Oyf.a, localIntent, 21);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oyg
 * JD-Core Version:    0.7.0.1
 */