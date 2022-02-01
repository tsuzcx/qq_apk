package cooperation.qzone.contentbox;

import NS_MOBILE_FEEDS.single_feed;
import NS_QZONE_MQMSG.PostBar;
import NS_QZONE_MQMSG.PostBarBottom;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQzoneRuntimeService;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.contentbox.model.MQLikeCell;
import cooperation.qzone.contentbox.model.MQMsg;
import cooperation.qzone.contentbox.model.MQMsgInteractData;
import cooperation.qzone.contentbox.model.MQShareCell;
import cooperation.qzone.contentbox.model.MsgOnClickListener;
import cooperation.qzone.report.lp.LpReportInfo_dc02880;
import cooperation.qzone.report.lp.LpReportManager;
import java.util.ArrayList;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class QZoneMsgFragment$10
  implements MsgOnClickListener
{
  QZoneMsgFragment$10(QZoneMsgFragment paramQZoneMsgFragment) {}
  
  public void onClick(MQMsg paramMQMsg, View paramView, int paramInt)
  {
    paramView = new StringBuilder();
    paramView.append("clicktype:");
    paramView.append(paramInt);
    QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, paramView.toString());
    if (paramMQMsg == null) {
      QLog.e("QZoneMsgManager.QZoneMsgFragment", 1, "MsgOnClickListener msg null");
    }
    Object localObject;
    switch (paramInt)
    {
    default: 
      this.this$0.jumpToDetail(paramMQMsg);
      return;
    case 7: 
      if ((paramMQMsg != null) && (paramMQMsg.postGuide != null) && (paramMQMsg.postGuide.bottom != null))
      {
        localObject = paramMQMsg.postGuide.bottom.jumpUrl;
        paramView = (View)localObject;
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          paramView = ((String)localObject).replaceFirst("mqzone", "mqqzone");
        }
        paramView = JumpParser.a(this.this$0.app, this.this$0.getActivity(), paramView);
        if (paramView != null) {
          paramView.a();
        }
        paramView = new LpReportInfo_dc02880(9, 2);
        if (paramMQMsg.postGuide != null) {
          paramView.reserves8 = String.valueOf(paramMQMsg.postGuide.leadType);
        }
        LpReportManager.getInstance().reportToDC02880(paramView, false, true);
        this.this$0.sendNegativeFeedBack(6, 3);
        return;
      }
      break;
    case 6: 
      this.this$0.adapter.removeFirstMQMsg();
      this.this$0.adapter.notifyDataSetChanged();
      paramView = new LpReportInfo_dc02880(9, 3);
      if (paramMQMsg.postGuide != null) {
        paramView.reserves8 = String.valueOf(paramMQMsg.postGuide.leadType);
      }
      LpReportManager.getInstance().reportToDC02880(paramView, false, true);
      this.this$0.sendNegativeFeedBack(5, 3);
      return;
    case 5: 
      paramMQMsg = JumpParser.a(this.this$0.app, this.this$0.getBaseActivity(), "mqqzone://arouse/activefeed");
      if (paramMQMsg != null)
      {
        paramMQMsg.a();
        return;
      }
      break;
    case 4: 
      if ((paramMQMsg != null) && (paramMQMsg.msgInteractData != null))
      {
        if ((paramMQMsg.msgInteractData.feed != null) && (paramMQMsg.msgInteractData.feed.singlefeed != null) && (paramMQMsg.msgInteractData.feed.singlefeed.size() > 0))
        {
          paramView = new Intent();
          QzonePluginProxyActivity.setActivityNameToIntent(paramView, "com.qzone.misc.web.QZoneTranslucentActivity2");
          paramView.putExtra("feed", paramMQMsg.msgInteractData.feed);
          paramView.putExtra("action", 4);
          QZoneHelper.forwardToQzoneTransluentActivity2(this.this$0.getBaseActivity(), QZoneHelper.UserInfo.getInstance(), paramView);
          return;
        }
        if (paramMQMsg.msgInteractData.shareToQzone != null)
        {
          paramView = new QZoneShareData();
          paramView.mTitle = paramMQMsg.msgInteractData.shareToQzone.title;
          paramView.mSummary = paramMQMsg.msgInteractData.shareToQzone.content;
          localObject = new ArrayList();
          ((ArrayList)localObject).add(paramMQMsg.msgInteractData.shareToQzone.imgUrl);
          paramView.mImageUrls = ((ArrayList)localObject);
          paramView.targetUrl = paramMQMsg.msgInteractData.shareToQzone.jumpUrl;
          QZoneShareManager.shareToQzone(this.this$0.getBaseActivity(), BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramView, null, 0);
          return;
        }
      }
      break;
    case 3: 
      if ((paramMQMsg != null) && (paramMQMsg.msgInteractData != null))
      {
        if ((paramMQMsg.msgInteractData.feed != null) && (paramMQMsg.msgInteractData.feed.singlefeed != null) && (paramMQMsg.msgInteractData.feed.singlefeed.size() > 0))
        {
          paramView = new Intent();
          QzonePluginProxyActivity.setActivityNameToIntent(paramView, "com.qzone.misc.web.QZoneTranslucentActivity2");
          paramView.putExtra("feed", paramMQMsg.msgInteractData.feed);
          paramView.putExtra("action", 3);
          QZoneHelper.forwardToQzoneTransluentActivity2(this.this$0.getBaseActivity(), QZoneHelper.UserInfo.getInstance(), paramView);
          return;
        }
        if (paramMQMsg.msgInteractData.shareToFriend != null)
        {
          paramView = new Intent(this.this$0.getBaseActivity(), ForwardRecentActivity.class);
          paramView.putExtra("forward_type", 2);
          paramView.putExtra("req_type", 1);
          paramView.putExtra("req_share_id", "1103584836");
          paramView.putExtra("image_url_remote", paramMQMsg.msgInteractData.shareToFriend.imgUrl);
          paramView.putExtra("detail_url", paramMQMsg.msgInteractData.shareToFriend.jumpUrl);
          paramView.putExtra("title", paramMQMsg.msgInteractData.shareToFriend.title);
          paramView.putExtra("desc", paramMQMsg.msgInteractData.shareToFriend.content);
          this.this$0.startActivity(paramView);
          return;
        }
      }
      break;
    case 2: 
      this.this$0.jumpToDetail(paramMQMsg);
      return;
    case 1: 
      if ((paramMQMsg != null) && (paramMQMsg.msgInteractData != null))
      {
        paramView = paramMQMsg.msgInteractData.likeCell;
        localObject = MobileQQ.sMobileQQ.peekAppRuntime();
        if (localObject != null) {
          ((IQzoneRuntimeService)((AppRuntime)localObject).getRuntimeService(IQzoneRuntimeService.class, "")).likeFeed(paramView.likeKey, paramView.appid, paramView.liked, paramMQMsg.pushTime);
        }
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgFragment.10
 * JD-Core Version:    0.7.0.1
 */