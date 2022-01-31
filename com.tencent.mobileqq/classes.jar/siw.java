import android.graphics.Color;
import android.widget.TextView;
import com.tencent.mobileqq.activity.EditInfoActivity;

class siw
  implements Runnable
{
  siw(siv paramsiv) {}
  
  public void run()
  {
    this.a.a.a.setText(this.a.a.c);
    this.a.a.a.setTextColor(Color.rgb(119, 119, 119));
    if (this.a.a.e)
    {
      this.a.a.rightViewText.setEnabled(true);
      return;
    }
    this.a.a.rightViewText.setEnabled(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     siw
 * JD-Core Version:    0.7.0.1
 */