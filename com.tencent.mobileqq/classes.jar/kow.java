import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity;
import com.tencent.biz.pubaccount.PaConfigAttr.PaConfigInfo;
import com.tencent.widget.Switch;

public class kow
  implements DialogInterface.OnClickListener
{
  public kow(EqqAccountDetailActivity paramEqqAccountDetailActivity, PaConfigAttr.PaConfigInfo paramPaConfigInfo, Switch paramSwitch, boolean paramBoolean) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 0) {
      if ((3 == this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.e) && (this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.d == 0))
      {
        paramDialogInterface = this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity;
        localPaConfigInfo = this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo;
        localSwitch = this.jdField_a_of_type_ComTencentWidgetSwitch;
        if (!this.jdField_a_of_type_Boolean)
        {
          bool = true;
          paramDialogInterface.a(localPaConfigInfo, localSwitch, bool);
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch);
        this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.a(true);
        this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.g();
        this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.b = false;
      }
    }
    while (paramInt != 1) {
      for (;;)
      {
        PaConfigAttr.PaConfigInfo localPaConfigInfo;
        Switch localSwitch;
        return;
        boolean bool = false;
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch, this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.a(true);
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.g();
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.b = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kow
 * JD-Core Version:    0.7.0.1
 */