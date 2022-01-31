import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;

public class oyo
  implements Runnable
{
  public oyo(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void run()
  {
    int i = this.a.jdField_c_of_type_AndroidViewView.getHeight();
    int j = this.a.b.getHeight();
    View localView;
    LinearLayout.LayoutParams localLayoutParams;
    if (j < i)
    {
      localView = this.a.findViewById(2131367550);
      localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      if (this.a.jdField_c_of_type_Int != 2) {
        break label79;
      }
      localLayoutParams.topMargin = 0;
      localLayoutParams.bottomMargin = 0;
    }
    for (;;)
    {
      localView.setLayoutParams(localLayoutParams);
      return;
      label79:
      if (this.a.jdField_c_of_type_Int == 5)
      {
        int k = localLayoutParams.topMargin;
        localLayoutParams.topMargin = ((i - j) / 2 + k);
      }
      else
      {
        localLayoutParams.topMargin = 50;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oyo
 * JD-Core Version:    0.7.0.1
 */