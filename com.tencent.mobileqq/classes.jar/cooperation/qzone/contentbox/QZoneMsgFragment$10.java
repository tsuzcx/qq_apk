package cooperation.qzone.contentbox;

import NS_MOBILE_FEEDS.single_feed;
import NS_QZONE_MQMSG.PostBar;
import NS_QZONE_MQMSG.PostBarBottom;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
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
import cooperation.qzone.report.lp.LpReportInfo_dc02880;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import java.util.ArrayList;
import java.util.Map;
import mqq.app.AppRuntime;

class QZoneMsgFragment$10
  implements MsgOnClickListener
{
  QZoneMsgFragment$10(QZoneMsgFragment paramQZoneMsgFragment) {}
  
  public void onClick(MQMsg paramMQMsg, View paramView, int paramInt)
  {
    paramView = null;
    ArrayList localArrayList = null;
    Object localObject = null;
    QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "clicktype:" + paramInt);
    if (paramMQMsg == null) {
      QLog.e("QZoneMsgManager.QZoneMsgFragment", 1, "MsgOnClickListener msg null");
    }
    switch (paramInt)
    {
    default: 
      this.this$0.jumpToDetail(paramMQMsg);
    }
    label291:
    label551:
    do
    {
      do
      {
        return;
        if ((paramMQMsg != null) && (paramMQMsg.msgInteractData != null)) {
          ((QZoneMsgManager)this.this$0.app.getManager(QQManagerFactory.QZONE_MSG_MANAGER)).likeFeed(paramMQMsg.msgInteractData.likeCell, paramMQMsg.pushTime);
        }
        if (paramMQMsg != null) {}
        for (paramMQMsg = String.valueOf(paramMQMsg.msgType);; paramMQMsg = null)
        {
          LpReportInfo_pf00064.allReport(133, 5, paramMQMsg);
          return;
        }
        if ((paramMQMsg != null) && (paramMQMsg.msgInteractData != null))
        {
          if ((paramMQMsg.msgInteractData.feed == null) || (paramMQMsg.msgInteractData.feed.singlefeed == null) || (paramMQMsg.msgInteractData.feed.singlefeed.size() <= 0)) {
            break label291;
          }
          paramView = new Intent();
          QzonePluginProxyActivity.setActivityNameToIntent(paramView, "com.qzone.misc.web.QZoneTranslucentActivity2");
          paramView.putExtra("feed", paramMQMsg.msgInteractData.feed);
          paramView.putExtra("action", 3);
          QZoneHelper.forwardToQzoneTransluentActivity2(this.this$0.getActivity(), QZoneHelper.UserInfo.getInstance(), paramView);
        }
        for (;;)
        {
          paramView = (View)localObject;
          if (paramMQMsg != null) {
            paramView = String.valueOf(paramMQMsg.msgType);
          }
          LpReportInfo_pf00064.allReport(133, 8, paramView);
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
            break label551;
          }
          localObject = new Intent();
          QzonePluginProxyActivity.setActivityNameToIntent((Intent)localObject, "com.qzone.misc.web.QZoneTranslucentActivity2");
          ((Intent)localObject).putExtra("feed", paramMQMsg.msgInteractData.feed);
          ((Intent)localObject).putExtra("action", 4);
          QZoneHelper.forwardToQzoneTransluentActivity2(this.this$0.getActivity(), QZoneHelper.UserInfo.getInstance(), (Intent)localObject);
        }
        for (;;)
        {
          if (paramMQMsg != null) {
            paramView = String.valueOf(paramMQMsg.msgType);
          }
          LpReportInfo_pf00064.allReport(133, 7, paramView);
          return;
          if (paramMQMsg.msgInteractData.shareToQzone != null)
          {
            localObject = new QZoneShareData();
            ((QZoneShareData)localObject).mTitle = paramMQMsg.msgInteractData.shareToQzone.title;
            ((QZoneShareData)localObject).mSummary = paramMQMsg.msgInteractData.shareToQzone.content;
            localArrayList = new ArrayList();
            localArrayList.add(paramMQMsg.msgInteractData.shareToQzone.imgUrl);
            ((QZoneShareData)localObject).mImageUrls = localArrayList;
            ((QZoneShareData)localObject).targetUrl = paramMQMsg.msgInteractData.shareToQzone.jumpUrl;
            QZoneShareManager.shareToQzone(this.this$0.getActivity(), BaseApplicationImpl.getApplication().getRuntime().getAccount(), (QZoneShareData)localObject, null, 0);
          }
        }
        paramMQMsg = JumpParser.a(this.this$0.app, this.this$0.getActivity(), "mqqzone://arouse/activefeed");
      } while (paramMQMsg == null);
      paramMQMsg.a();
      return;
      this.this$0.jumpToDetail(paramMQMsg);
      paramView = localArrayList;
      if (paramMQMsg != null) {
        paramView = String.valueOf(paramMQMsg.msgType);
      }
      LpReportInfo_pf00064.allReport(133, 6, paramView);
      return;
      this.this$0.adapter.removeFirstMQMsg();
      this.this$0.adapter.notifyDataSetChanged();
      paramView = new LpReportInfo_dc02880(9, 3);
      if (paramMQMsg.postGuide != null) {
        paramView.reserves8 = String.valueOf(paramMQMsg.postGuide.leadType);
      }
      LpReportManager.getInstance().reportToDC02880(paramView, false, true);
      this.this$0.sendNegativeFeedBack(5, 3);
      return;
    } while ((paramMQMsg == null) || (paramMQMsg.postGuide == null) || (paramMQMsg.postGuide.bottom == null));
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgFragment.10
 * JD-Core Version:    0.7.0.1
 */