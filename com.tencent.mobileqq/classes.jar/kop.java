import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity;
import com.tencent.biz.pubaccount.PaConfigAttr.PaConfigInfo;
import com.tencent.widget.Switch;

public class kop
  implements CompoundButton.OnCheckedChangeListener
{
  public kop(EqqAccountDetailActivity paramEqqAccountDetailActivity, PaConfigAttr.PaConfigInfo paramPaConfigInfo, Switch paramSwitch) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.a)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.a = true;
      return;
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.f == 1) || (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.c))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch, paramBoolean);
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.c = false;
    }
    for (;;)
    {
      EqqAccountDetailActivity.e(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity, this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.a);
      return;
      if (this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.f == 2)
      {
        if (paramBoolean) {
          this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.b(this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch, paramBoolean);
        } else {
          this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch, paramBoolean);
        }
      }
      else if (this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.f == 3)
      {
        if (!paramBoolean) {
          this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.b(this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch, paramBoolean);
        } else {
          this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch, paramBoolean);
        }
      }
      else {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch, paramBoolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kop
 * JD-Core Version:    0.7.0.1
 */