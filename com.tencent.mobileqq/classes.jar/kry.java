import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailGroupListContainer;
import com.tencent.biz.pubaccount.PaConfigAttr.PaConfigInfo;
import com.tencent.widget.Switch;

public class kry
  implements DialogInterface.OnClickListener
{
  public kry(AccountDetailGroupListContainer paramAccountDetailGroupListContainer, PaConfigAttr.PaConfigInfo paramPaConfigInfo, boolean paramBoolean, Switch paramSwitch) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    boolean bool = true;
    if (paramInt == 0) {
      if ((3 == this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.e) && (this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.d == 0))
      {
        paramDialogInterface = this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer;
        localPaConfigInfo = this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo;
        if (!this.jdField_a_of_type_Boolean) {
          paramDialogInterface.a(localPaConfigInfo, bool);
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.a(this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch);
      }
    }
    while (paramInt != 1) {
      for (;;)
      {
        PaConfigAttr.PaConfigInfo localPaConfigInfo;
        return;
        bool = false;
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.a(this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kry
 * JD-Core Version:    0.7.0.1
 */