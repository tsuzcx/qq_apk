package cooperation.qzone.contentbox;

import NS_MOBILE_FEEDS.single_feed;
import android.content.Intent;
import android.view.View;
import bheh;
import bhey;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.contentbox.model.MQMsg;
import cooperation.qzone.contentbox.model.MQMsgInteractData;
import cooperation.qzone.contentbox.model.MQShareCell;
import cooperation.qzone.contentbox.model.MsgOnClickListener;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import java.util.Map;
import mqq.app.AppRuntime;

class QZoneMsgFragment$9
  implements MsgOnClickListener
{
  QZoneMsgFragment$9(QZoneMsgFragment paramQZoneMsgFragment) {}
  
  public void onClick(MQMsg paramMQMsg, View paramView, int paramInt)
  {
    QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "clicktype:" + paramInt);
    if (paramMQMsg == null) {
      QLog.e("QZoneMsgManager.QZoneMsgFragment", 1, "MsgOnClickListener msg null");
    }
    switch (paramInt)
    {
    default: 
      this.this$0.jumpToDetail(paramMQMsg);
    case 1: 
    case 3: 
    case 4: 
    case 5: 
      label255:
      do
      {
        return;
        if ((paramMQMsg != null) && (paramMQMsg.msgInteractData != null)) {
          ((QZoneMsgManager)this.this$0.app.getManager(QQManagerFactory.QZONE_MSG_MANAGER)).likeFeed(paramMQMsg.msgInteractData.likeCell, paramMQMsg.pushTime);
        }
        LpReportInfo_pf00064.allReport(133, 5, String.valueOf(paramMQMsg.msgType));
        return;
        if ((paramMQMsg != null) && (paramMQMsg.msgInteractData != null))
        {
          if ((paramMQMsg.msgInteractData.feed == null) || (paramMQMsg.msgInteractData.feed.singlefeed == null) || (paramMQMsg.msgInteractData.feed.singlefeed.size() <= 0)) {
            break label255;
          }
          paramView = new Intent();
          QzonePluginProxyActivity.setActivityNameToIntent(paramView, "com.qzone.misc.web.QZoneTranslucentActivity2");
          paramView.putExtra("feed", paramMQMsg.msgInteractData.feed);
          paramView.putExtra("action", 3);
          QZoneHelper.forwardToQzoneTransluentActivity2(this.this$0.getActivity(), QZoneHelper.UserInfo.getInstance(), paramView);
        }
        for (;;)
        {
          LpReportInfo_pf00064.allReport(133, 8, String.valueOf(paramMQMsg.msgType));
          return;
          if (paramMQMsg.msgInteractData.shareToFriend != null)
          {
            paramView = new Intent(this.this$0.getActivity(), ForwardRecentActivity.class);
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
        if ((paramMQMsg != null) && (paramMQMsg.msgInteractData != null))
        {
          if ((paramMQMsg.msgInteractData.feed == null) || (paramMQMsg.msgInteractData.feed.singlefeed == null) || (paramMQMsg.msgInteractData.feed.singlefeed.size() <= 0)) {
            break label504;
          }
          paramView = new Intent();
          QzonePluginProxyActivity.setActivityNameToIntent(paramView, "com.qzone.misc.web.QZoneTranslucentActivity2");
          paramView.putExtra("feed", paramMQMsg.msgInteractData.feed);
          paramView.putExtra("action", 4);
          QZoneHelper.forwardToQzoneTransluentActivity2(this.this$0.getActivity(), QZoneHelper.UserInfo.getInstance(), paramView);
        }
        for (;;)
        {
          LpReportInfo_pf00064.allReport(133, 7, String.valueOf(paramMQMsg.msgType));
          return;
          if (paramMQMsg.msgInteractData.shareToQzone != null)
          {
            paramView = new QZoneShareData();
            paramView.mTitle = paramMQMsg.msgInteractData.shareToQzone.title;
            paramView.mSummary = paramMQMsg.msgInteractData.shareToQzone.content;
            ArrayList localArrayList = new ArrayList();
            localArrayList.add(paramMQMsg.msgInteractData.shareToQzone.imgUrl);
            paramView.mImageUrls = localArrayList;
            paramView.targetUrl = paramMQMsg.msgInteractData.shareToQzone.jumpUrl;
            QZoneShareManager.shareToQzone(this.this$0.getActivity(), BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramView, null, 0);
          }
        }
        paramMQMsg = bhey.a(this.this$0.app, this.this$0.getActivity(), "mqqzone://arouse/activefeed");
      } while (paramMQMsg == null);
      label504:
      paramMQMsg.a();
      return;
    }
    this.this$0.jumpToDetail(paramMQMsg);
    LpReportInfo_pf00064.allReport(133, 6, String.valueOf(paramMQMsg.msgType));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgFragment.9
 * JD-Core Version:    0.7.0.1
 */