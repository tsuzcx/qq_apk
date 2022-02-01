import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.managecolumn.EditColumnFragment;
import com.tencent.biz.pubaccount.readinjoy.widgets.LimitWordCountEditText;
import com.tencent.mobileqq.widget.QQToast;

public class rfr
  implements DialogInterface.OnClickListener
{
  public rfr(EditColumnFragment paramEditColumnFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a(true);
    if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.b() > 0)
    {
      this.a.jdField_a_of_type_Rfw.a(EditColumnFragment.a(this.a).columnID, this.a.a());
      return;
    }
    QQToast.a(this.a.getActivity(), 0, 2131717031, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rfr
 * JD-Core Version:    0.7.0.1
 */