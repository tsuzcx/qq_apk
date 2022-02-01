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
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
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
    Object localObject1 = null;
    Object localObject2 = null;
    ArrayList localArrayList = null;
    paramView = null;
    switch (paramInt)
    {
    default: 
      this.this$0.jumpToDetail(paramMQMsg);
      return;
    case 7: 
      if ((paramMQMsg != null) && (paramMQMsg.postGuide != null) && (paramMQMsg.postGuide.bottom != null))
      {
        localObject1 = paramMQMsg.postGuide.bottom.jumpUrl;
        paramView = (View)localObject1;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          paramView = ((String)localObject1).replaceFirst("mqzone", "mqqzone");
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
      if ((paramMQMsg != null) && (paramMQMsg.msgInteractData != null)) {
        if ((paramMQMsg.msgInteractData.feed != null) && (paramMQMsg.msgInteractData.feed.singlefeed != null) && (paramMQMsg.msgInteractData.feed.singlefeed.size() > 0))
        {
          localObject1 = new Intent();
          QzonePluginProxyActivity.setActivityNameToIntent((Intent)localObject1, "com.qzone.misc.web.QZoneTranslucentActivity2");
          ((Intent)localObject1).putExtra("feed", paramMQMsg.msgInteractData.feed);
          ((Intent)localObject1).putExtra("action", 4);
          QZoneHelper.forwardToQzoneTransluentActivity2(this.this$0.getBaseActivity(), QZoneHelper.UserInfo.getInstance(), (Intent)localObject1);
        }
        else if (paramMQMsg.msgInteractData.shareToQzone != null)
        {
          localObject1 = new QZoneShareData();
          ((QZoneShareData)localObject1).mTitle = paramMQMsg.msgInteractData.shareToQzone.title;
          ((QZoneShareData)localObject1).mSummary = paramMQMsg.msgInteractData.shareToQzone.content;
          localArrayList = new ArrayList();
          localArrayList.add(paramMQMsg.msgInteractData.shareToQzone.imgUrl);
          ((QZoneShareData)localObject1).mImageUrls = localArrayList;
          ((QZoneShareData)localObject1).targetUrl = paramMQMsg.msgInteractData.shareToQzone.jumpUrl;
          QZoneShareManager.shareToQzone(this.this$0.getBaseActivity(), BaseApplicationImpl.getApplication().getRuntime().getAccount(), (QZoneShareData)localObject1, null, 0);
        }
      }
      if (paramMQMsg != null) {
        paramView = String.valueOf(paramMQMsg.msgType);
      }
      LpReportInfo_pf00064.allReport(133, 7, paramView);
      return;
    case 3: 
      if ((paramMQMsg != null) && (paramMQMsg.msgInteractData != null)) {
        if ((paramMQMsg.msgInteractData.feed != null) && (paramMQMsg.msgInteractData.feed.singlefeed != null) && (paramMQMsg.msgInteractData.feed.singlefeed.size() > 0))
        {
          paramView = new Intent();
          QzonePluginProxyActivity.setActivityNameToIntent(paramView, "com.qzone.misc.web.QZoneTranslucentActivity2");
          paramView.putExtra("feed", paramMQMsg.msgInteractData.feed);
          paramView.putExtra("action", 3);
          QZoneHelper.forwardToQzoneTransluentActivity2(this.this$0.getBaseActivity(), QZoneHelper.UserInfo.getInstance(), paramView);
        }
        else if (paramMQMsg.msgInteractData.shareToFriend != null)
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
        }
      }
      paramView = (View)localObject1;
      if (paramMQMsg != null) {
        paramView = String.valueOf(paramMQMsg.msgType);
      }
      LpReportInfo_pf00064.allReport(133, 8, paramView);
      return;
    case 2: 
      this.this$0.jumpToDetail(paramMQMsg);
      paramView = localObject2;
      if (paramMQMsg != null) {
        paramView = String.valueOf(paramMQMsg.msgType);
      }
      LpReportInfo_pf00064.allReport(133, 6, paramView);
      return;
    case 1: 
      if ((paramMQMsg != null) && (paramMQMsg.msgInteractData != null))
      {
        paramView = paramMQMsg.msgInteractData.likeCell;
        localObject1 = MobileQQ.sMobileQQ.peekAppRuntime();
        if (localObject1 != null) {
          ((IQzoneRuntimeService)((AppRuntime)localObject1).getRuntimeService(IQzoneRuntimeService.class, "")).likeFeed(paramView.likeKey, paramView.appid, paramView.liked, paramMQMsg.pushTime);
        }
      }
      paramView = localArrayList;
      if (paramMQMsg != null) {
        paramView = String.valueOf(paramMQMsg.msgType);
      }
      LpReportInfo_pf00064.allReport(133, 5, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgFragment.10
 * JD-Core Version:    0.7.0.1
 */