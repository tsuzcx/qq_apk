import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StMessageStatus;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFollowFeedsRsp;
import NS_COMM.COMM.StCommonExt;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderFollowTabFragment;
import com.tencent.biz.subscribe.component.base.ComponentPageView;
import com.tencent.biz.subscribe.network.SubscribeGetFollowFeedsRequest;
import com.tencent.biz.subscribe.widget.relativevideo.ServiceFolderFollowPBHeadView;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.biz.videostory.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.List;

public class sbe
  implements xgu<CertifiedAccountRead.StGetFollowFeedsRsp>
{
  public sbe(FolderFollowTabFragment paramFolderFollowTabFragment, SubscribeGetFollowFeedsRequest paramSubscribeGetFollowFeedsRequest, wlg paramwlg) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetFollowFeedsRsp paramStGetFollowFeedsRsp)
  {
    boolean bool1 = true;
    boolean bool2 = VSNetworkHelper.a(paramString);
    if ((!paramBoolean) || (paramLong != 0L) || (paramStGetFollowFeedsRsp == null))
    {
      if (!TextUtils.isEmpty(paramString)) {
        bcql.a(FolderFollowTabFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment), 1, paramString, 0).a();
      }
      if (!bool2)
      {
        VSBaseRequest.reMoveCache(this.jdField_a_of_type_ComTencentBizSubscribeNetworkSubscribeGetFollowFeedsRequest);
        if ((this.jdField_a_of_type_Wlg.getItemCount() == 0) && (FolderFollowTabFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment) != null)) {
          FolderFollowTabFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment).a(true);
        }
      }
      return;
    }
    paramString = paramStGetFollowFeedsRsp.feeds.get();
    if ((FolderFollowTabFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment) != null) && (!bool2) && (paramStGetFollowFeedsRsp.messStatus.get() != null))
    {
      FolderFollowTabFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment).a(paramStGetFollowFeedsRsp.messStatus.noticeCount.get());
      FolderFollowTabFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment).setJumpWebMessageListUrl(paramStGetFollowFeedsRsp.messStatus.jumpURL.get());
    }
    if ((!bool2) || (FolderFollowTabFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment)))
    {
      if (FolderFollowTabFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment)) {
        FolderFollowTabFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment, false);
      }
      if ((paramString == null) || (paramString.size() <= 0)) {
        break label336;
      }
      if (FolderFollowTabFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment) != null) {
        FolderFollowTabFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment).a(false);
      }
      wlg localwlg = this.jdField_a_of_type_Wlg;
      COMM.StCommonExt localStCommonExt = paramStGetFollowFeedsRsp.extInfo;
      if (paramStGetFollowFeedsRsp.isFinish.get() != 1) {
        break label330;
      }
      localwlg.a(paramString, localStCommonExt, bool1);
      if (!bool2)
      {
        FolderFollowTabFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment).a();
        FolderFollowTabFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment).notifyDataSetChanged();
        FolderFollowTabFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment).b(FolderFollowTabFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Wlg.d(paramBoolean);
      return;
      label330:
      bool1 = false;
      break;
      label336:
      if (!bool2)
      {
        VSBaseRequest.reMoveCache(this.jdField_a_of_type_ComTencentBizSubscribeNetworkSubscribeGetFollowFeedsRequest);
        FolderFollowTabFragment.c(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment, this.jdField_a_of_type_Wlg);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sbe
 * JD-Core Version:    0.7.0.1
 */