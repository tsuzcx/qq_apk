import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StMessageStatus;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFollowFeedsRsp;
import NS_COMM.COMM.StCommonExt;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderFollowTabFragment;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class sbg
  implements xgu<CertifiedAccountRead.StGetFollowFeedsRsp>
{
  public sbg(FolderFollowTabFragment paramFolderFollowTabFragment, wlg paramwlg) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetFollowFeedsRsp paramStGetFollowFeedsRsp)
  {
    boolean bool = true;
    if ((!paramBoolean) || (paramLong != 0L) || (paramStGetFollowFeedsRsp == null))
    {
      if (!TextUtils.isEmpty(paramString)) {
        bcql.a(FolderFollowTabFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment), 1, paramString, 0).a();
      }
      return;
    }
    if (paramStGetFollowFeedsRsp.messStatus.get() != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment.a(paramStGetFollowFeedsRsp.messStatus.noticeCount.get());
      FolderFollowTabFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment, paramStGetFollowFeedsRsp.messStatus.jumpURL.get());
    }
    paramString = paramStGetFollowFeedsRsp.feeds.get();
    wlg localwlg = this.jdField_a_of_type_Wlg;
    COMM.StCommonExt localStCommonExt = paramStGetFollowFeedsRsp.extInfo;
    if (paramStGetFollowFeedsRsp.isFinish.get() == 1) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localwlg.b(paramString, localStCommonExt, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sbg
 * JD-Core Version:    0.7.0.1
 */