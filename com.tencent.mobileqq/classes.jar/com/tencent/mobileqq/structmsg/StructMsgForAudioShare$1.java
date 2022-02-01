package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.common.util.Util;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.StructingMsgViewHolder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.open.sdk.report.SdkShareReporter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AccountNotMatchException;
import mqq.os.MqqHandler;

final class StructMsgForAudioShare$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    Object localObject2 = paramView.findViewById(2131446476);
    if (localObject2 != null)
    {
      StructMsgForAudioShare localStructMsgForAudioShare;
      do
      {
        do
        {
          localObject1 = ((View)localObject2).getTag(2131446476);
        } while ((localObject1 == null) || (!(localObject1 instanceof StructMsgForAudioShare)));
        localStructMsgForAudioShare = (StructMsgForAudioShare)localObject1;
        localObject1 = paramView.getTag();
      } while ((localObject1 == null) || (!(localObject1 instanceof StructingMsgItemBuilder.StructingMsgViewHolder)));
      Object localObject1 = (StructingMsgItemBuilder.StructingMsgViewHolder)localObject1;
      localObject2 = ((View)localObject2).getContext();
      try
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime(localStructMsgForAudioShare.currentAccountUin);
        if (localStructMsgForAudioShare.msgId > 0L)
        {
          ReportController.b(localQQAppInterface, "P_CliOper", "Pb_account_lifeservice", localStructMsgForAudioShare.uin, "mp_msg_msgpic_click", "aio_morpic_click", 0, 0, "", "", Long.toString(localStructMsgForAudioShare.msgId), "");
          MqqHandler localMqqHandler = ThreadManager.getSubThreadHandler();
          try
          {
            localMqqHandler.postDelayed(new StructMsgForAudioShare.1.1(this, localStructMsgForAudioShare, localQQAppInterface), 0L);
            AbsShareMsg.doReport(localQQAppInterface, localStructMsgForAudioShare);
            if (localQQAppInterface == null) {
              break label325;
            }
            Util.a(localQQAppInterface, "", "click", localStructMsgForAudioShare.mSourceAppid, localStructMsgForAudioShare.mMsgServiceID, Util.a(((StructingMsgItemBuilder.StructingMsgViewHolder)localObject1).d.a));
            MediaPlayerManager.a(localQQAppInterface).a(true);
          }
          catch (AccountNotMatchException localAccountNotMatchException1) {}
        }
      }
      catch (AccountNotMatchException localAccountNotMatchException2)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("StructMsg", 4, localAccountNotMatchException2.getStackTrace().toString());
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localStructMsgForAudioShare.mMsgServiceID);
      localStringBuilder.append("");
      ReportController.b(null, "CliOper", "", "", "0X800567A", "0X800567A", 0, 0, localStringBuilder.toString(), "", "", "");
      ReportController.b(null, "CliOper", "", "", "0X8004B5C", "0X8004B5C", 1, 0, "", "", "", "");
      SdkShareReporter.b("2", localStructMsgForAudioShare.uinType, localStructMsgForAudioShare.mContentTitle, localStructMsgForAudioShare.mSourceAppid);
      StructMsgForAudioShare.onClickEvent((Context)localObject2, localStructMsgForAudioShare);
    }
    label325:
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForAudioShare.1
 * JD-Core Version:    0.7.0.1
 */