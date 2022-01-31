import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoController;
import java.lang.ref.WeakReference;

class lsz
  implements View.OnClickListener
{
  lsz(lsx paramlsx) {}
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    paramView = (lta)paramView.getTag();
    if (paramView.c) {
      if (this.a.jdField_a_of_type_Int == 1) {
        awqx.b(null, "CliOper", "", "", "0X8005C2A", "0X8005C2A", 0, 0, "", "", "", "");
      }
    }
    VideoController localVideoController;
    long l;
    do
    {
      if ((paramView.c) && (paramView.d))
      {
        bbmy.a((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131630315, 1).a();
        if (this.a.jdField_a_of_type_Int == 1) {}
        for (paramView = "0x8007CB5";; paramView = "0x8007CB6")
        {
          lbr.a(paramView);
          return;
          if (this.a.jdField_a_of_type_Int != 2) {
            break;
          }
          awqx.b(null, "CliOper", "", "", "0X8005C25", "0X8005C25", 0, 0, "", "", "", "");
          break;
          if (this.a.jdField_a_of_type_Int == 1)
          {
            awqx.b(null, "CliOper", "", "", "0X8005C29", "0X8005C29", 0, 0, "", "", "", "");
            break;
          }
          if (this.a.jdField_a_of_type_Int != 2) {
            break;
          }
          awqx.b(null, "CliOper", "", "", "0X8005C24", "0X8005C24", 0, 0, "", "", "", "");
          break;
        }
      }
      localVideoController = this.a.jdField_a_of_type_ComTencentAvVideoController;
      l = paramView.a;
      if (!paramView.c) {
        bool = true;
      }
    } while ((!localVideoController.a(l, bool)) || (!paramView.c));
    bbmy.a((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131630169, 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lsz
 * JD-Core Version:    0.7.0.1
 */