package com.tencent.mobileqq.structmsg;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.comic.api.IQQDcReporter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity;
import com.tencent.mobileqq.activity.aio.photo.AIOGallerySceneWithBusiness;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qqgamepub.api.IGameShareUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.open.sdk.report.SdkShareReporter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.BinderWarpper;
import java.io.File;
import mqq.app.AccountNotMatchException;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

final class StructMsgForImageShare$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    Object localObject3 = paramView.findViewById(2131446476);
    Object localObject1;
    StructMsgForImageShare localStructMsgForImageShare;
    Context localContext;
    if (localObject3 != null)
    {
      do
      {
        localObject1 = ((View)localObject3).getTag(2131446476);
      } while (!(localObject1 instanceof StructMsgForImageShare));
      localStructMsgForImageShare = (StructMsgForImageShare)localObject1;
      localContext = ((View)localObject3).getContext();
    }
    Object localObject4;
    label198:
    Object localObject2;
    label1758:
    label1774:
    for (;;)
    {
      try
      {
        localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime(localStructMsgForImageShare.currentAccountUin);
        AbsShareMsg.doReport((QQAppInterface)localObject1, localStructMsgForImageShare);
        if (localStructMsgForImageShare.msgId <= 0L) {
          break label1774;
        }
        ReportController.b((AppRuntime)localObject1, "P_CliOper", "Pb_account_lifeservice", localStructMsgForImageShare.uin, "mp_msg_msgpic_click", "aio_morpic_click", 0, 0, "", "", Long.toString(localStructMsgForImageShare.msgId), "");
        localObject4 = ThreadManager.getSubThreadHandler();
        try
        {
          ((MqqHandler)localObject4).postDelayed(new StructMsgForImageShare.1.1(this, localStructMsgForImageShare, (QQAppInterface)localObject1), 0L);
          if ((localStructMsgForImageShare.getFirstImageElement() == null) || (!localStructMsgForImageShare.getFirstImageElement().c())) {
            break label198;
          }
          SdkShareReporter.b(localStructMsgForImageShare.uinType, localStructMsgForImageShare.mSourceAppid, localStructMsgForImageShare.getTitleFromBrief());
        }
        catch (AccountNotMatchException localAccountNotMatchException1) {}
        if (!QLog.isColorLevel()) {
          break label198;
        }
      }
      catch (AccountNotMatchException localAccountNotMatchException2) {}
      QLog.d("StructMsg", 2, localAccountNotMatchException2.getStackTrace().toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(localStructMsgForImageShare.mMsgServiceID);
      ((StringBuilder)localObject2).append("");
      ReportController.b(null, "CliOper", "", "", "0X800567A", "0X800567A", 0, 0, ((StringBuilder)localObject2).toString(), "", "", "");
      ReportController.b(null, "CliOper", "", "", "0X8004B5C", "0X8004B5C", 1, 0, "", "", "", "");
      localObject4 = localStructMsgForImageShare.getFirstImageElement();
      int i = 0;
      MessageForPic localMessageForPic;
      if (localObject4 != null)
      {
        if ((!MessageRecordInfo.c(localStructMsgForImageShare.mIsSend)) && (((StructMsgItemImage)localObject4).aF != null))
        {
          localObject2 = PicItemBuilder.a(localContext, ((StructMsgItemImage)localObject4).aF);
          if (localObject2 != null)
          {
            if (((URLDrawable)localObject2).getStatus() == 2)
            {
              ((URLDrawable)localObject2).restartDownload();
              break label1758;
            }
            if ((((URLDrawable)localObject2).getStatus() == 0) && (!((URLDrawable)localObject2).isDownloadStarted()))
            {
              ((URLDrawable)localObject2).startDownload();
              break label1758;
            }
          }
        }
        localObject5 = new Intent(localContext, AIOGalleryActivity.class);
        ((Intent)localObject5).putExtra("curType", localStructMsgForImageShare.uinType);
        ((Intent)localObject5).putExtra("_id", localStructMsgForImageShare.uniseq);
        ((Intent)localObject5).putExtra("appid", localStructMsgForImageShare.mSourceAppid);
        ((Intent)localObject5).putExtra("image_share_by_server", ((StructMsgItemImage)localObject4).c());
        ((Intent)localObject5).putExtra("urlAtServer", ((StructMsgItemImage)localObject4).av);
        ((Intent)localObject5).putExtra("KEY_FILE_ID", ((StructMsgItemImage)localObject4).aB);
        ((Intent)localObject5).putExtra("picMD5", ((StructMsgItemImage)localObject4).aw);
        ((Intent)localObject5).putExtra("url", ((StructMsgItemImage)localObject4).au);
        ((Intent)localObject5).putExtra("friendUin", localStructMsgForImageShare.uin);
        ((Intent)localObject5).putExtra("KEY_MSG_VERSION_CODE", localStructMsgForImageShare.messageVersion);
        ((Intent)localObject5).putExtra("isSend", localStructMsgForImageShare.mIsSend);
        ((Intent)localObject5).putExtra("KEY_BUSI_TYPE", 1030);
        ((Intent)localObject5).putExtra("IS_FROMOTHER_TERMINAL_KEY", MessageRecordInfo.d(localStructMsgForImageShare.mIsSend));
        ((Intent)localObject5).putExtra("uin", localStructMsgForImageShare.uin);
        if (localStructMsgForImageShare.mIsSend == 1) {
          localObject2 = localStructMsgForImageShare.currentAccountUin;
        } else {
          localObject2 = localStructMsgForImageShare.uin;
        }
        ((Intent)localObject5).putExtra("KEY_TROOP_CODE", (String)localObject2);
        ((Intent)localObject5).putExtra("fileSize", ((StructMsgItemImage)localObject4).aC);
        ((Intent)localObject5).putExtra("KEY_TIME", ((StructMsgItemImage)localObject4).aD);
        ((Intent)localObject5).putExtra("KEY_SUB_VERSION", 5);
        ((Intent)localObject5).putExtra("KEY_FILE_SIZE_FLAG", 0);
        ((Intent)localObject5).putExtra("uniSeq", localStructMsgForImageShare.uniseq);
        ((Intent)localObject5).putExtra("KEY_THUMBNAL_BOUND", AnimationUtils.a((View)localObject3));
        ((Intent)localObject5).putExtra("title", localStructMsgForImageShare.getTitleFromBrief());
        localMessageForPic = ((StructMsgItemImage)localObject4).aF;
        if (localMessageForPic != null)
        {
          ((Intent)localObject5).addFlags(603979776);
          localObject2 = localMessageForPic.selfuin;
          localObject4 = localObject2;
          if (!localMessageForPic.isMultiMsg) {}
        }
      }
      try
      {
        localObject3 = MobileQQ.sMobileQQ.waitAppRuntime(null);
        localObject4 = localObject2;
        if ((localObject3 instanceof QQAppInterface)) {
          localObject4 = ((AppRuntime)localObject3).getAccount();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          AIOImageProviderService localAIOImageProviderService;
          Object localObject6;
          localObject4 = localObject2;
        }
      }
      localAIOImageProviderService = new AIOImageProviderService((String)localObject4, localMessageForPic.frienduin, localMessageForPic.istroop, localMessageForPic);
      localObject2 = AIOGalleryUtils.a(localMessageForPic);
      if (localStructMsgForImageShare.message != null)
      {
        ((AIOImageData)localObject2).N = localStructMsgForImageShare.message.time;
        ((AIOImageData)localObject2).P = localStructMsgForImageShare.message.shmsgseq;
      }
      if ((localStructMsgForImageShare.mMsgActionData != null) && (localStructMsgForImageShare.mMsgActionData.startsWith("comic_plugin.apk")))
      {
        ((AIOImageData)localObject2).r = 1;
        ((AIOImageData)localObject2).s = localStructMsgForImageShare.getBytes();
        localObject6 = AIOGallerySceneWithBusiness.b(localStructMsgForImageShare);
        ((AIOImageData)localObject2).y = AIOGallerySceneWithBusiness.a((String[])localObject6);
        if ((localObject6 != null) && (localObject6.length >= 8))
        {
          if (localObject6[7].equals("link")) {
            localObject3 = localObject6[4];
          } else if ((localObject6[7].equals("scrawl_link")) && (localObject6.length >= 9)) {
            localObject3 = localObject6[8];
          } else {
            localObject3 = "";
          }
          ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).reportDC00145(null, (String)localObject4, localContext, "3009", "2", "40054", localObject6[0], new String[] { localObject6[2], localObject6[4], localObject3 });
        }
        localObject3 = "uin";
      }
      else
      {
        localObject6 = "uin";
        if ((localStructMsgForImageShare.mMsgActionData != null) && (localStructMsgForImageShare.mMsgActionData.startsWith("ScreenShotShare")))
        {
          localObject4 = localObject2;
          ((AIOImageData)localObject4).r = 2;
          ((AIOImageData)localObject4).s = localStructMsgForImageShare.getBytes();
          localObject3 = localObject6;
          localObject2 = localObject4;
          if (MessageRecordInfo.c(localMessageForPic.issend))
          {
            localObject3 = localObject6;
            localObject2 = localObject4;
            if (!TextUtils.isEmpty(localMessageForPic.path))
            {
              localObject3 = localObject6;
              localObject2 = localObject4;
              if (new File(localMessageForPic.path).exists())
              {
                ((AIOImageData)localObject4).b = localMessageForPic.path;
                localObject3 = localObject6;
                localObject2 = localObject4;
              }
            }
          }
        }
        else
        {
          localObject4 = localObject2;
          if (localStructMsgForImageShare.mImageBizType == 2)
          {
            if ((MessageRecordInfo.c(localMessageForPic.issend)) && (!TextUtils.isEmpty(localMessageForPic.path)) && (TextUtils.isEmpty(localMessageForPic.md5)) && (new File(localMessageForPic.path).exists())) {
              ((AIOImageData)localObject4).b = localMessageForPic.path;
            }
            ((AIOImageData)localObject4).r = 4;
            localObject3 = localObject6;
            localObject2 = localObject4;
          }
          else
          {
            localObject3 = localObject6;
            localObject2 = localObject4;
            if (((IGameShareUtil)QRoute.api(IGameShareUtil.class)).isGameShare(localStructMsgForImageShare))
            {
              ((AIOImageData)localObject4).r = 5;
              ((IGameShareUtil)QRoute.api(IGameShareUtil.class)).convertDataForGallery(localObject4, localStructMsgForImageShare);
              localObject2 = localObject4;
              localObject3 = localObject6;
            }
          }
        }
      }
      localObject4 = localObject5;
      Object localObject5 = new Bundle();
      ((Bundle)localObject5).putParcelable("extra.IMAGE_PROVIDER", new BinderWarpper(localAIOImageProviderService.asBinder()));
      ((Bundle)localObject5).putParcelable("extra.EXTRA_CURRENT_IMAGE", (Parcelable)localObject2);
      ((Bundle)localObject5).putInt("forward_source_uin_type", localStructMsgForImageShare.uinType);
      if ((!(localContext instanceof SplashActivity)) && (!(localContext instanceof ChatActivity)) && (!(localContext instanceof ChatHistoryActivity)) && (!(localContext instanceof PublicFragmentActivity)) && (!(localContext instanceof ChatHistory))) {
        break label1521;
      }
      if ((localContext instanceof MultiForwardActivity))
      {
        localObject2 = ((BaseActivity)localContext).getAppInterface();
        if ((localObject2 instanceof QQAppInterface))
        {
          ((Bundle)localObject5).putBoolean("extra.FROM_AIO", true);
          ((Bundle)localObject5).putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
          ((Bundle)localObject5).putString((String)localObject3, ((MultiForwardActivity)localContext).getChatFragment().k().aE().b);
          localObject3 = ((Bundle)localObject5).getString("extra.GROUP_UIN");
          if ((localObject3 == null) || (((QQAppInterface)localObject2).getTroopMask((String)localObject3) != 2)) {
            break label1521;
          }
          ((Bundle)localObject5).putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
        }
      }
      else
      {
        ((Bundle)localObject5).putBoolean("extra.FROM_AIO", true);
        ((Bundle)localObject5).putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ((Activity)localContext).getClass().getName());
      }
      label1521:
      ((Intent)localObject4).putExtras((Bundle)localObject5);
      localContext.startActivity((Intent)localObject4);
      i = 1;
      localObject2 = localStructMsgForImageShare.uin;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(localStructMsgForImageShare.msgId);
      localObject3 = ((StringBuilder)localObject3).toString();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("");
      ((StringBuilder)localObject4).append(localStructMsgForImageShare.templateIDForPortal);
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", (String)localObject2, "0X80055C7", "0X80055C7", 0, i, (String)localObject3, ((StringBuilder)localObject4).toString(), "", localStructMsgForImageShare.mMsgUrl);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("MSGID=");
      ((StringBuilder)localObject2).append(Long.toString(localStructMsgForImageShare.msgId));
      ((StringBuilder)localObject2).append(";TEPLATEID=");
      ((StringBuilder)localObject2).append(localStructMsgForImageShare.templateIDForPortal);
      ((StringBuilder)localObject2).append(";ARTICALID=");
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(";REFERRER=");
      ((StringBuilder)localObject2).append(AbsStructMsgElement.a(localStructMsgForImageShare.mMsgUrl));
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", localStructMsgForImageShare.uin, "0X8005D49", "0X8005D49", 0, i, ((StringBuilder)localObject2).toString(), "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForImageShare.1
 * JD-Core Version:    0.7.0.1
 */