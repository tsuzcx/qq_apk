import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.ugc.managecolumn.EditColumnFragment;
import com.tencent.biz.pubaccount.readinjoy.widgets.LimitWordCountEditText;
import com.tencent.mobileqq.widget.QQToast;

public class qtq
  implements DialogInterface.OnClickListener
{
  public qtq(EditColumnFragment paramEditColumnFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a(true);
    if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.a() > 0)
    {
      this.a.jdField_a_of_type_Qtv.a(EditColumnFragment.a(this.a), this.a.a());
      return;
    }
    QQToast.a(this.a.getActivity(), 0, 2131718777, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qtq
 * JD-Core Version:    0.7.0.1
 */