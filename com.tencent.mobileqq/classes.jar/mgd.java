import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.mobileqq.widget.QQToast;
import java.lang.ref.WeakReference;

class mgd
  implements View.OnClickListener
{
  mgd(mgb parammgb) {}
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    paramView = (mge)paramView.getTag();
    if (paramView.c) {
      if (this.a.jdField_a_of_type_Int == 1) {
        azqs.b(null, "CliOper", "", "", "0X8005C2A", "0X8005C2A", 0, 0, "", "", "", "");
      }
    }
    VideoController localVideoController;
    long l;
    do
    {
      if ((paramView.c) && (paramView.d))
      {
        QQToast.a((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131696174, 1).a();
        if (this.a.jdField_a_of_type_Int == 1) {}
        for (paramView = "0x8007CB5";; paramView = "0x8007CB6")
        {
          log.a(paramView);
          return;
          if (this.a.jdField_a_of_type_Int != 2) {
            break;
          }
          azqs.b(null, "CliOper", "", "", "0X8005C25", "0X8005C25", 0, 0, "", "", "", "");
          break;
          if (this.a.jdField_a_of_type_Int == 1)
          {
            azqs.b(null, "CliOper", "", "", "0X8005C29", "0X8005C29", 0, 0, "", "", "", "");
            break;
          }
          if (this.a.jdField_a_of_type_Int != 2) {
            break;
          }
          azqs.b(null, "CliOper", "", "", "0X8005C24", "0X8005C24", 0, 0, "", "", "", "");
          break;
        }
      }
      localVideoController = this.a.jdField_a_of_type_ComTencentAvVideoController;
      l = paramView.a;
      if (!paramView.c) {
        bool = true;
      }
    } while ((!localVideoController.a(l, bool)) || (!paramView.c));
    QQToast.a((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131696020, 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mgd
 * JD-Core Version:    0.7.0.1
 */