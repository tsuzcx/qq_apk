import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class qkn
  implements View.OnClickListener
{
  qkn(qkl paramqkl) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.TopicShareHelper", 2, "mShareActionSheet cancle button OnClick");
    }
    if (qkl.a(this.a).isShowing()) {
      qkl.a(this.a).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qkn
 * JD-Core Version:    0.7.0.1
 */