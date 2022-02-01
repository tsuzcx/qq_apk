import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class mdm
  implements View.OnClickListener
{
  mdm(mdk parammdk) {}
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    Object localObject = (mdn)paramView.getTag();
    if (((mdn)localObject).c) {
      if (this.a.jdField_a_of_type_Int == 1)
      {
        bcef.b(null, "CliOper", "", "", "0X8005C2A", "0X8005C2A", 0, 0, "", "", "", "");
        if ((!((mdn)localObject).c) || (!((mdn)localObject).d)) {
          break label242;
        }
        QQToast.a((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131695236, 1).a();
        if (this.a.jdField_a_of_type_Int != 1) {
          break label235;
        }
        localObject = "0x8007CB5";
        label108:
        llj.a((String)localObject);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.jdField_a_of_type_Int != 2) {
        break;
      }
      bcef.b(null, "CliOper", "", "", "0X8005C25", "0X8005C25", 0, 0, "", "", "", "");
      break;
      if (this.a.jdField_a_of_type_Int == 1)
      {
        bcef.b(null, "CliOper", "", "", "0X8005C29", "0X8005C29", 0, 0, "", "", "", "");
        break;
      }
      if (this.a.jdField_a_of_type_Int != 2) {
        break;
      }
      bcef.b(null, "CliOper", "", "", "0X8005C24", "0X8005C24", 0, 0, "", "", "", "");
      break;
      label235:
      localObject = "0x8007CB6";
      break label108;
      label242:
      VideoController localVideoController = this.a.jdField_a_of_type_ComTencentAvVideoController;
      long l = ((mdn)localObject).a;
      if (!((mdn)localObject).c) {
        bool = true;
      }
      if ((localVideoController.a(l, bool)) && (((mdn)localObject).c)) {
        QQToast.a((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131695080, 1).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mdm
 * JD-Core Version:    0.7.0.1
 */