import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.managecolumn.EditColumnFragment;
import com.tencent.biz.pubaccount.readinjoy.widgets.LimitWordCountEditText;
import com.tencent.mobileqq.widget.QQToast;

public class rzg
  implements DialogInterface.OnClickListener
{
  public rzg(EditColumnFragment paramEditColumnFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a(true);
    if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.b() > 0)
    {
      this.a.jdField_a_of_type_Rzl.a(EditColumnFragment.a(this.a).columnID, this.a.a());
      return;
    }
    QQToast.a(this.a.getActivity(), 0, 2131717630, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rzg
 * JD-Core Version:    0.7.0.1
 */