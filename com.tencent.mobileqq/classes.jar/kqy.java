import android.view.View;
import com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailBaseInfoModel;
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailGroupListContainer;
import com.tencent.biz.pubaccount.PaConfigAttr.PaConfigInfo;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class kqy
  implements ActionSheet.OnButtonClickListener
{
  public kqy(AccountDetailGroupListContainer paramAccountDetailGroupListContainer, PaConfigAttr.PaConfigInfo paramPaConfigInfo, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    int i = 1;
    if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.e) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.e = true;
    if (paramInt + 1 == 1) {}
    for (paramInt = i;; paramInt = 3)
    {
      AccountDetailBaseInfoModel.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo, paramInt);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kqy
 * JD-Core Version:    0.7.0.1
 */