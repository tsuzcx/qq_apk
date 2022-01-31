import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailGroupListContainer;
import com.tencent.biz.pubaccount.PaConfigAttr.PaConfigInfo;
import com.tencent.widget.Switch;

public class kqz
  implements CompoundButton.OnCheckedChangeListener
{
  public kqz(AccountDetailGroupListContainer paramAccountDetailGroupListContainer, PaConfigAttr.PaConfigInfo paramPaConfigInfo, Switch paramSwitch) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.b)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.b = true;
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.f == 1) {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.a(this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo, paramBoolean);
    }
    for (;;)
    {
      AccountDetailGroupListContainer.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer, this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.a);
      return;
      if (this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.f == 2)
      {
        if (paramBoolean) {
          this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.a(this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch, paramBoolean);
        } else {
          this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.a(this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo, paramBoolean);
        }
      }
      else if (this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.f == 3)
      {
        if (!paramBoolean) {
          this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.a(this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch, paramBoolean);
        } else {
          this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.a(this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo, paramBoolean);
        }
      }
      else {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.a(this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo, paramBoolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kqz
 * JD-Core Version:    0.7.0.1
 */