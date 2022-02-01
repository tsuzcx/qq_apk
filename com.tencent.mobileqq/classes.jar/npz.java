import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.lebasearch.LebaSearchPluginManagerActivity;

public class npz
  implements View.OnTouchListener
{
  int jdField_a_of_type_Int = 0;
  Handler jdField_a_of_type_AndroidOsHandler = new nqa(this);
  
  public npz(LebaSearchPluginManagerActivity paramLebaSearchPluginManagerActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(), 5L);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     npz
 * JD-Core Version:    0.7.0.1
 */