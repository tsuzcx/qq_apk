import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class mei
  implements View.OnClickListener
{
  mei(meg parammeg) {}
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    Object localObject = (mej)paramView.getTag();
    if (((mej)localObject).c) {
      if (this.a.jdField_a_of_type_Int == 1)
      {
        bdla.b(null, "CliOper", "", "", "0X8005C2A", "0X8005C2A", 0, 0, "", "", "", "");
        if ((!((mej)localObject).c) || (!((mej)localObject).d)) {
          break label242;
        }
        QQToast.a((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131695453, 1).a();
        if (this.a.jdField_a_of_type_Int != 1) {
          break label235;
        }
        localObject = "0x8007CB5";
        label108:
        llw.a((String)localObject);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.jdField_a_of_type_Int != 2) {
        break;
      }
      bdla.b(null, "CliOper", "", "", "0X8005C25", "0X8005C25", 0, 0, "", "", "", "");
      break;
      if (this.a.jdField_a_of_type_Int == 1)
      {
        bdla.b(null, "CliOper", "", "", "0X8005C29", "0X8005C29", 0, 0, "", "", "", "");
        break;
      }
      if (this.a.jdField_a_of_type_Int != 2) {
        break;
      }
      bdla.b(null, "CliOper", "", "", "0X8005C24", "0X8005C24", 0, 0, "", "", "", "");
      break;
      label235:
      localObject = "0x8007CB6";
      break label108;
      label242:
      VideoController localVideoController = this.a.jdField_a_of_type_ComTencentAvVideoController;
      long l = ((mej)localObject).a;
      if (!((mej)localObject).c) {
        bool = true;
      }
      if ((localVideoController.a(l, bool)) && (((mej)localObject).c)) {
        QQToast.a((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131695296, 1).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mei
 * JD-Core Version:    0.7.0.1
 */