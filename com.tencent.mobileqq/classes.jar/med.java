import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class med
  implements View.OnClickListener
{
  med(meb parammeb) {}
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    Object localObject = (mee)paramView.getTag();
    if (((mee)localObject).c) {
      if (this.a.jdField_a_of_type_Int == 1)
      {
        bdll.b(null, "CliOper", "", "", "0X8005C2A", "0X8005C2A", 0, 0, "", "", "", "");
        if ((!((mee)localObject).c) || (!((mee)localObject).d)) {
          break label242;
        }
        QQToast.a((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131695097, 1).a();
        if (this.a.jdField_a_of_type_Int != 1) {
          break label235;
        }
        localObject = "0x8007CB5";
        label108:
        llr.a((String)localObject);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.jdField_a_of_type_Int != 2) {
        break;
      }
      bdll.b(null, "CliOper", "", "", "0X8005C25", "0X8005C25", 0, 0, "", "", "", "");
      break;
      if (this.a.jdField_a_of_type_Int == 1)
      {
        bdll.b(null, "CliOper", "", "", "0X8005C29", "0X8005C29", 0, 0, "", "", "", "");
        break;
      }
      if (this.a.jdField_a_of_type_Int != 2) {
        break;
      }
      bdll.b(null, "CliOper", "", "", "0X8005C24", "0X8005C24", 0, 0, "", "", "", "");
      break;
      label235:
      localObject = "0x8007CB6";
      break label108;
      label242:
      VideoController localVideoController = this.a.jdField_a_of_type_ComTencentAvVideoController;
      long l = ((mee)localObject).a;
      if (!((mee)localObject).c) {
        bool = true;
      }
      if ((localVideoController.a(l, bool)) && (((mee)localObject).c)) {
        QQToast.a((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131694942, 1).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     med
 * JD-Core Version:    0.7.0.1
 */