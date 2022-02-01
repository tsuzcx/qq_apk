import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;

public class nuy
  implements ShareActionSheet.OnItemClickListener
{
  public nuy(AccountDetailActivity paramAccountDetailActivity, Activity paramActivity) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    QQAppInterface localQQAppInterface = null;
    int i = paramActionSheetItem.action;
    aavu localaavu = this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.a();
    String str1 = localaavu.a();
    int j = this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.a();
    String str2 = this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.b();
    switch (i)
    {
    default: 
      paramActionSheetItem = localQQAppInterface;
      paramShareActionSheet.dismiss();
      if ((localaavu.c == aavu.b) && (!TextUtils.isEmpty(paramActionSheetItem)))
      {
        localQQAppInterface = this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.a;
        str1 = localaavu.a();
        if (!localaavu.a) {
          break label398;
        }
      }
      break;
    }
    label398:
    for (paramShareActionSheet = "02";; paramShareActionSheet = "01")
    {
      bdll.b(localQQAppInterface, "dc01160", "Pb_account_lifeservice", str1, "0X8007CA6", "0X8007CA6", 0, 0, paramShareActionSheet, paramActionSheetItem, String.valueOf(localaavu.d), "");
      return;
      aavs.b((BaseActivity)this.jdField_a_of_type_AndroidAppActivity, localaavu, j, str2);
      PublicAccountHandler.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.a, str1, "Grp_tribe", "interest_data", "share_qq");
      paramActionSheetItem = "01";
      break;
      aavs.a((BaseActivity)this.jdField_a_of_type_AndroidAppActivity, localaavu, j, str2);
      PublicAccountHandler.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.a, str1, "Grp_tribe", "interest_data", "share_qzone");
      paramActionSheetItem = "02";
      break;
      aavs.a((BaseActivity)this.jdField_a_of_type_AndroidAppActivity, localaavu, j, str2, i);
      localQQAppInterface = this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.a;
      if (i == 9)
      {
        paramActionSheetItem = "share_wechat";
        label299:
        PublicAccountHandler.a(localQQAppInterface, str1, "Grp_tribe", "interest_data", paramActionSheetItem);
        ocd.a(null, "P_CliOper", "Pb_account_lifeservice", str1, "0X8005A2C", "0X8005A2C", 0, 0, "", "", "", "", false);
        if (i != 9) {
          break label354;
        }
      }
      label354:
      for (paramActionSheetItem = "03";; paramActionSheetItem = "04")
      {
        break;
        paramActionSheetItem = "share_circle";
        break label299;
      }
      aavs.a(this.jdField_a_of_type_AndroidAppActivity, localaavu, j, str2, paramActionSheetItem);
      PublicAccountHandler.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.a, str1, "Grp_tribe", "interest_data", "share_qq");
      paramActionSheetItem = "01";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nuy
 * JD-Core Version:    0.7.0.1
 */