import android.app.Activity;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;

public class nwh
  implements ShareActionSheet.OnItemClickListener
{
  public nwh(AccountDetailActivity paramAccountDetailActivity, Activity paramActivity) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    Object localObject = null;
    int i = paramActionSheetItem.action;
    zsh localzsh = this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.a();
    String str1 = localzsh.a();
    int j = this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.a();
    String str2 = this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.b();
    switch (i)
    {
    default: 
      paramActionSheetItem = localObject;
    }
    for (;;)
    {
      paramShareActionSheet.dismiss();
      AccountDetailActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity, paramActionSheetItem, localzsh);
      return;
      paramActionSheetItem = AccountDetailActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity, paramActionSheetItem, localzsh, str1, j, str2, this.jdField_a_of_type_AndroidAppActivity);
      continue;
      paramActionSheetItem = AccountDetailActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity, localzsh, str1, j, str2, (BaseActivity)this.jdField_a_of_type_AndroidAppActivity);
      continue;
      paramActionSheetItem = AccountDetailActivity.b(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity, localzsh, str1, j, str2, (BaseActivity)this.jdField_a_of_type_AndroidAppActivity);
      continue;
      paramActionSheetItem = AccountDetailActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity, i, localzsh, str1, j, str2, (BaseActivity)this.jdField_a_of_type_AndroidAppActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nwh
 * JD-Core Version:    0.7.0.1
 */