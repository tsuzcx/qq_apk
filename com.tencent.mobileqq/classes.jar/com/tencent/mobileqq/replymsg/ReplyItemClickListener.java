package com.tencent.mobileqq.replymsg;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.helper.WriteTogetherHelper;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie;
import com.tencent.mobileqq.adapter.ChatHistoryStructAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.API.ArkCommonUtil;
import com.tencent.mobileqq.config.business.ArkMsgReplyConfigMgr;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageForWriteTogether;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.open.CommonFileBrowserParams;
import com.tencent.mobileqq.filemanager.fileviewer.open.FileBrowserCreator;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare.GeneralClickHandler;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.FolderUtils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.troop.TroopFileProxyActivity;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class ReplyItemClickListener
  implements View.OnClickListener
{
  private final int jdField_a_of_type_Int = 1000;
  private long jdField_a_of_type_Long = 0L;
  private Context jdField_a_of_type_AndroidContentContext;
  private BaseBubbleBuilder jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public ReplyItemClickListener(BaseBubbleBuilder paramBaseBubbleBuilder)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseBubbleBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramBaseBubbleBuilder.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseBubbleBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder = paramBaseBubbleBuilder;
  }
  
  private void a(int paramInt)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A36C", "0X800A36C", paramInt, 0, "", "", "", "");
  }
  
  private boolean a(View paramView, MessageForReplyText paramMessageForReplyText)
  {
    Object localObject1 = ReplyTextItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForReplyText.frienduin, paramMessageForReplyText.istroop, paramMessageForReplyText, paramMessageForReplyText.mSourceMsgInfo);
    Object localObject2 = localObject1;
    Object localObject3;
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReplyItemClickListener", 2, "onClick, getMessage is null, query from db");
      }
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramMessageForReplyText.frienduin, paramMessageForReplyText.istroop, null).iterator();
      do
      {
        localObject2 = localObject1;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject2 = (MessageRecord)((Iterator)localObject3).next();
      } while (((MessageRecord)localObject2).shmsgseq != paramMessageForReplyText.mSourceMsgInfo.mSourceMsgSeq);
    }
    if (QLog.isColorLevel())
    {
      if (localObject2 == null)
      {
        localObject1 = "null";
        QLog.d("ReplyItemClickListener", 2, new Object[] { "clicked sourceMsg Class=", localObject1 });
      }
    }
    else if (paramMessageForReplyText.isBarrageMsg)
    {
      if (!(localObject2 instanceof MessageForPic)) {
        break label351;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A885", "0X800A885", 0, 0, "", "", "", "");
    }
    boolean bool1;
    label351:
    int i;
    for (;;)
    {
      boolean bool2 = true;
      localObject3 = null;
      localObject1 = localObject3;
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade() != null)
      {
        localObject1 = localObject3;
        bool1 = bool2;
        if (localObject2 != null)
        {
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ((MessageRecord)localObject2).shmsgseq);
          localObject1 = localObject3;
          bool1 = bool2;
          if (localObject3 == null)
          {
            bool1 = false;
            localObject1 = localObject3;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReplyItemClickListener", 2, "check source msg, isReplySrcMsgExist = " + bool1);
      }
      if (!(localObject2 instanceof MessageForShortVideo)) {
        break label784;
      }
      if ((paramView.getId() == 2131364662) || (paramView.getId() == 2131379316)) {
        break label635;
      }
      return false;
      localObject1 = localObject2.getClass().getName();
      break;
      if ((localObject2 instanceof MessageForShortVideo))
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A886", "0X800A886", 0, 0, "", "", "", "");
      }
      else if (FileManagerUtil.a((MessageRecord)localObject2))
      {
        localObject1 = ReplyTextItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject2);
        if ((localObject1 instanceof MessageForFile))
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(((MessageRecord)localObject1).uniseq, ((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).istroop);
          if (localObject1 != null)
          {
            i = FileManagerUtil.a(((FileManagerEntity)localObject1).fileName);
            if (i == 0) {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A885", "0X800A885", 0, 0, "", "", "", "");
            } else if (i == 2) {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A886", "0X800A886", 0, 0, "", "", "", "");
            }
          }
        }
        else if ((localObject1 instanceof MessageForTroopFile))
        {
          localObject1 = (MessageForTroopFile)localObject1;
          localObject1 = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForTroopFile)localObject1);
          if (localObject1 != null)
          {
            i = FileManagerUtil.a(((TroopFileStatusInfo)localObject1).g);
            if (i == 0) {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A885", "0X800A885", 0, 0, "", "", "", "");
            } else if (i == 2) {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A886", "0X800A886", 0, 0, "", "", "", "");
            }
          }
        }
      }
    }
    label635:
    if (paramView.getId() == 2131364662)
    {
      localObject1 = (ImageView)paramView.findViewById(2131379316);
      if (((MessageForShortVideo)localObject2).busiType != 0)
      {
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        Context localContext = this.jdField_a_of_type_AndroidContentContext;
        MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)localObject2;
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = (ImageView)paramView;
        }
        ShortVideoRealItemBuilder.a((QQAppInterface)localObject3, localContext, localMessageForShortVideo, (View)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false, true, ReplyTextItemBuilder.a(paramMessageForReplyText.mSourceMsgInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), bool1, paramMessageForReplyText);
      }
      for (;;)
      {
        a(5);
        return true;
        ShortVideoItemBuilder.a((MessageForShortVideo)localObject2, 0L, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, ReplyTextItemBuilder.a(paramMessageForReplyText.mSourceMsgInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), bool1, paramMessageForReplyText);
      }
      if ((localObject2 instanceof MessageForText))
      {
        if ((paramView.getId() != 2131364662) && (paramView.getId() != 2131371908)) {
          return false;
        }
        if (paramView.getId() != 2131364662) {
          break label2623;
        }
        paramMessageForReplyText = (ETTextView)paramView.findViewById(2131371908);
        localObject1 = (FragmentActivity)this.jdField_a_of_type_AndroidContentContext;
        if (a((MessageRecord)localObject2, (FragmentActivity)localObject1)) {
          return true;
        }
        if (localObject1 != null)
        {
          localObject1 = ((FragmentActivity)localObject1).getChatFragment();
          if (localObject1 == null)
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            if (paramMessageForReplyText == null) {}
            for (;;)
            {
              ChatActivityUtils.a((QQAppInterface)localObject1, paramView, (FragmentActivity)this.jdField_a_of_type_AndroidContentContext);
              a(1);
              return true;
              paramView = paramMessageForReplyText;
            }
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (paramMessageForReplyText == null) {}
          for (;;)
          {
            ChatActivityUtils.a((QQAppInterface)localObject1, paramView, (FragmentActivity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            break;
            paramView = paramMessageForReplyText;
          }
        }
      }
      else if (((localObject2 instanceof MessageForMixedMsg)) || ((localObject2 instanceof MessageForPic)))
      {
        if ((paramView.getId() != 2131364662) && (paramView.getId() != 2131371908) && (paramView.getId() != 2131379316)) {
          return false;
        }
        if (((localObject2 instanceof MessageForMixedMsg)) && ((paramView.getId() == 2131364662) || (paramView.getId() == 2131371908)))
        {
          if (paramView.getId() != 2131364662) {
            break label2612;
          }
          paramMessageForReplyText = (ETTextView)paramView.findViewById(2131371908);
          localObject1 = (FragmentActivity)this.jdField_a_of_type_AndroidContentContext;
          if (localObject1 == null) {
            break label2606;
          }
          localObject1 = ((FragmentActivity)localObject1).getChatFragment();
          if (localObject1 == null)
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            if (paramMessageForReplyText == null)
            {
              ChatActivityUtils.a((QQAppInterface)localObject1, paramView, (FragmentActivity)this.jdField_a_of_type_AndroidContentContext);
              a(3);
            }
          }
        }
        for (;;)
        {
          return true;
          paramView = paramMessageForReplyText;
          break;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (paramMessageForReplyText == null) {}
          for (;;)
          {
            ChatActivityUtils.a((QQAppInterface)localObject1, paramView, (FragmentActivity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            break;
            paramView = paramMessageForReplyText;
          }
          if (((localObject2 instanceof MessageForPic)) && (!(paramView instanceof URLImageView)))
          {
            localObject1 = (MessageForPic)localObject2;
            if (PicItemBuilder.a((MessageForPic)localObject1)) {
              AIOEmotionFragment.a(this.jdField_a_of_type_AndroidContentContext, (MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, AnimationUtils.a(paramView), ReplyTextItemBuilder.a(paramMessageForReplyText.mSourceMsgInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), false);
            }
            for (;;)
            {
              return true;
              PicItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, null, (MessageForPic)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true, ReplyTextItemBuilder.a(paramMessageForReplyText.mSourceMsgInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), bool1, paramMessageForReplyText);
            }
          }
          paramView = (URLImageView)paramView;
          localObject1 = (MessageForPic)paramView.getTag(2131364648);
          localObject3 = (URLDrawable)paramView.getDrawable();
          if (localObject3 == null) {
            return false;
          }
          switch (((URLDrawable)localObject3).getStatus())
          {
          }
          for (;;)
          {
            if (!(localObject2 instanceof MessageForMixedMsg)) {
              break label1438;
            }
            a(4);
            break;
            if (FolderUtils.a(this.jdField_a_of_type_AndroidContentContext))
            {
              ((URLDrawable)localObject3).restartDownload();
              continue;
              if (!((URLDrawable)localObject3).isDownloadStarted())
              {
                ((URLDrawable)localObject3).startDownload();
                continue;
                if (PicItemBuilder.a((MessageForPic)localObject1)) {
                  AIOEmotionFragment.a(this.jdField_a_of_type_AndroidContentContext, (MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, AnimationUtils.a(paramView), ReplyTextItemBuilder.a(paramMessageForReplyText.mSourceMsgInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), false);
                } else {
                  PicItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramView, (ChatMessage)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true, ReplyTextItemBuilder.a(paramMessageForReplyText.mSourceMsgInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), bool1, paramMessageForReplyText);
                }
              }
            }
          }
          a(2);
        }
      }
      else if (FileManagerUtil.a((MessageRecord)localObject2))
      {
        paramView = ReplyTextItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject2);
        if ((bool1) && (localObject1 != null)) {
          paramView.uniseq = ((MessageRecord)localObject1).uniseq;
        }
        paramView.isMultiMsg = paramMessageForReplyText.isMultiMsg;
        if ((paramView instanceof MessageForFile))
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramView.uniseq, paramView.frienduin, paramView.istroop);
          if (localObject1 != null)
          {
            if (((FileManagerEntity)localObject1).status == 16) {
              return false;
            }
            i = FileManagerUtil.a(((FileManagerEntity)localObject1).fileName);
            if (((FileManagerEntity)localObject1).cloudType == 0) {
              i = 11;
            }
            if (i == 0)
            {
              QFileUtils.a(this.jdField_a_of_type_AndroidContentContext, null, (MessageForFile)paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false, true, true, paramMessageForReplyText);
              a(6);
              return true;
            }
            if (i == 2)
            {
              if (((FileManagerEntity)localObject1).status == 16) {
                return true;
              }
              if (!QFileUtils.a((FileManagerEntity)localObject1)) {
                return true;
              }
              i = 0;
              if (((FileManagerEntity)localObject1).peerType == 0) {
                i = 1;
              }
              for (;;)
              {
                QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageForFile)paramView, null, i, 10004, (FileManagerEntity)localObject1, false, true);
                break;
                if (((FileManagerEntity)localObject1).peerType == 3000) {
                  i = 5;
                }
              }
            }
            i = 0;
            if (((FileManagerEntity)localObject1).peerType == 0) {
              i = 1;
            }
            for (;;)
            {
              paramView = new CommonFileBrowserParams(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (FileManagerEntity)localObject1, 10004);
              paramMessageForReplyText = new Bundle();
              paramMessageForReplyText.putString("file_browser_extra_params_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
              paramMessageForReplyText.putInt("FromChatHistoryTab", 106);
              paramView.a(paramMessageForReplyText);
              paramView = new FileBrowserCreator(this.jdField_a_of_type_AndroidContentContext, paramView);
              paramView.a(i);
              paramView.a();
              break;
              if (((FileManagerEntity)localObject1).peerType == 3000) {
                i = 5;
              }
            }
          }
        }
        else if ((paramView instanceof MessageForTroopFile))
        {
          long l = Long.parseLong(paramView.frienduin);
          paramView = (MessageForTroopFile)paramView;
          localObject1 = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
          if (localObject1 != null)
          {
            if (((TroopFileStatusInfo)localObject1).b == 12)
            {
              QLog.i("ReplyItemClickListener<QFile>", 1, "click reply. troop file message is expired");
              return false;
            }
            i = FileManagerUtil.a(((TroopFileStatusInfo)localObject1).g);
            if (i == 2)
            {
              if ((paramView.lastTime != 0L) && (paramView.lastTime <= NetConnInfoCenter.getServerTime()))
              {
                QLog.i("ReplyItemClickListener<QFile>", 1, "click reply. troop file message is expired");
                return false;
              }
              QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramView, l, (TroopFileStatusInfo)localObject1, paramView.senderuin, paramView.lastTime, 3, 3, null, false, true, true);
            }
            for (;;)
            {
              a(6);
              return true;
              if (i == 0) {
                switch (((TroopFileStatusInfo)localObject1).b)
                {
                case 4: 
                case 5: 
                default: 
                  PicItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, null, paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true, ReplyTextItemBuilder.a(paramMessageForReplyText.mSourceMsgInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), bool1, paramMessageForReplyText);
                  break;
                case 0: 
                case 1: 
                case 2: 
                case 3: 
                  paramMessageForReplyText = new Intent();
                  paramMessageForReplyText.putExtra(TroopFileProxyActivity.jdField_a_of_type_JavaLangString, paramView.frienduin);
                  TroopFileProxyActivity.b((Activity)this.jdField_a_of_type_AndroidContentContext, paramMessageForReplyText, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
                  break;
                }
              } else {
                QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramMessageForReplyText, l, (TroopFileStatusInfo)localObject1, paramView.senderuin, paramView.lastTime, 3, 3, null, false, true);
              }
            }
          }
        }
      }
      else if ((localObject2 instanceof MessageForStructing))
      {
        if (!ChatHistoryStructAdapter.a((MessageRecord)localObject2)) {
          return false;
        }
        if (ReplyTextItemBuilder.b((MessageRecord)localObject2)) {
          return false;
        }
        if ((((MessageForStructing)localObject2).structingMsg != null) && ((((MessageForStructing)localObject2).structingMsg instanceof AbsShareMsg)))
        {
          paramMessageForReplyText = (AbsShareMsg)((MessageForStructing)localObject2).structingMsg;
          if ((paramMessageForReplyText instanceof StructMsgForGeneralShare))
          {
            paramView.setTag(localObject2);
            localObject1 = (StructMsgForGeneralShare)paramMessageForReplyText;
            localObject2 = new StructMsgForGeneralShare.GeneralClickHandler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, (StructMsgForGeneralShare)localObject1);
            StructMsgForGeneralShare.onClickEvent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (StructMsgForGeneralShare)localObject1, paramView, (StructMsgForGeneralShare.GeneralClickHandler)localObject2);
            paramMessageForReplyText.getOnClickListener().onClick(paramView);
            switch (paramMessageForReplyText.mMsgServiceID)
            {
            default: 
              a(9);
            }
          }
          for (;;)
          {
            return true;
            if (!(paramMessageForReplyText instanceof StructMsgForAudioShare)) {
              break;
            }
            localObject1 = (StructMsgForAudioShare)paramMessageForReplyText;
            StructMsgForAudioShare.onClickEvent(this.jdField_a_of_type_AndroidContentContext, (StructMsgForAudioShare)localObject1);
            break;
            a(7);
            continue;
            a(8);
          }
        }
      }
      else if (!(localObject2 instanceof MessageForArkApp)) {}
    }
    for (;;)
    {
      try
      {
        label784:
        label831:
        label865:
        paramMessageForReplyText = ((MessageForArkApp)localObject2).ark_app_message;
        label1033:
        label1054:
        if ((paramMessageForReplyText != null) && (ArkMsgReplyConfigMgr.a().a(paramMessageForReplyText.appName, paramMessageForReplyText.appView)))
        {
          a(ArkMsgReplyConfigMgr.a(paramMessageForReplyText.appName, paramMessageForReplyText.appView));
          localObject2 = ArkMsgReplyConfigMgr.a().a(new JSONObject(paramMessageForReplyText.toAppXml()));
          localObject1 = (String)((Map)localObject2).get("kArkMsgReplyAction");
          localObject2 = (String)((Map)localObject2).get("kArkMsgReplyJumpUrl");
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label2587;
          }
          if ("showLargeText".equals(localObject1))
          {
            if ((paramView.getId() != 2131364662) && (paramView.getId() != 2131371908)) {
              return false;
            }
            paramMessageForReplyText = null;
            if (paramView.getId() == 2131364662) {
              paramMessageForReplyText = (ETTextView)paramView.findViewById(2131371908);
            }
            localObject1 = (FragmentActivity)this.jdField_a_of_type_AndroidContentContext;
            if (localObject1 == null) {
              break label2600;
            }
            localObject1 = ((FragmentActivity)localObject1).getChatFragment();
            if (localObject1 == null)
            {
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              if (paramMessageForReplyText != null) {
                break label2636;
              }
              ChatActivityUtils.a((QQAppInterface)localObject1, paramView, (FragmentActivity)this.jdField_a_of_type_AndroidContentContext);
            }
            else
            {
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              if (paramMessageForReplyText == null) {
                ChatActivityUtils.a((QQAppInterface)localObject1, paramView, (FragmentActivity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
              }
            }
          }
        }
      }
      catch (Exception paramView)
      {
        label1438:
        QLog.e("ReplyItemClickListener", 1, "handle sourceMsg of MessageForArkApp error: " + paramView.getMessage());
      }
      return false;
      paramView = paramMessageForReplyText;
      continue;
      label2587:
      ArkCommonUtil.a((String)localObject2, 0, paramMessageForReplyText.appName);
      return true;
      label2600:
      localObject1 = null;
      continue;
      label2606:
      localObject1 = null;
      break label1054;
      label2612:
      paramMessageForReplyText = null;
      break label1033;
      localObject1 = null;
      break label865;
      label2623:
      paramMessageForReplyText = null;
      break label831;
      localObject1 = null;
      break;
      return true;
      label2636:
      paramView = paramMessageForReplyText;
    }
  }
  
  private boolean a(MessageRecord paramMessageRecord, FragmentActivity paramFragmentActivity)
  {
    if ((paramMessageRecord instanceof MessageForWriteTogether))
    {
      paramFragmentActivity = paramFragmentActivity.getChatFragment().a();
      if (paramFragmentActivity != null)
      {
        paramFragmentActivity = (WriteTogetherHelper)paramFragmentActivity.a(74);
        if (paramFragmentActivity != null)
        {
          paramFragmentActivity.a(((MessageForWriteTogether)paramMessageRecord).padId, 4);
          return true;
        }
      }
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder.a()) {}
    do
    {
      long l;
      do
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        l = System.currentTimeMillis();
      } while (l - this.jdField_a_of_type_Long < 1000L);
      this.jdField_a_of_type_Long = l;
      localObject1 = AIOUtils.a(paramView);
      if (!(localObject1 instanceof MessageForMixedMsg)) {
        break;
      }
      localObject1 = (MessageForMixedMsg)localObject1;
    } while (((MessageForMixedMsg)localObject1).getReplyMessage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == null);
    Object localObject1 = ((MessageForMixedMsg)localObject1).getReplyMessage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    for (;;)
    {
      Object localObject2;
      if (!(localObject1 instanceof MessageForReplyText))
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder().append("TextItemBuilder onClickListener: AIOUtils.getMessage(v) is not MessageForReplyText, it's");
          if (localObject1 == null) {
            break label156;
          }
        }
        label156:
        for (localObject1 = localObject1.getClass().getSimpleName();; localObject1 = "null")
        {
          QLog.w("ReplyItemClickListener", 2, (String)localObject1);
          break;
        }
      }
      MessageForReplyText localMessageForReplyText = (MessageForReplyText)localObject1;
      MessageForReplyText.SourceMsgInfo localSourceMsgInfo = localMessageForReplyText.mSourceMsgInfo;
      if (localMessageForReplyText.msgtype == -1003)
      {
        AIOUtils.o = true;
        localObject1 = PkgTools.Decodecgi(localMessageForReplyText.action);
        localObject1 = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.getContext(), (String)localObject1);
        if (localObject1 != null) {
          ((JumpAction)localObject1).a();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReplyItemClickListener", 2, "ReplyTextItemBuilder OnClickListener original sourceMsgInfo msgUid= " + localSourceMsgInfo.origUid + ", time = " + localSourceMsgInfo.mSourceMsgTime);
      }
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131364662: 
      case 2131371908: 
      case 2131379316: 
        if (a(paramView, localMessageForReplyText))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ReplyItemClickListener", 2, "handleSourceAreaClick success");
        }
        break;
      case 2131369714: 
        if (!(this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)) {
          break;
        }
        ChatFragment localChatFragment = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
        if (localChatFragment != null)
        {
          localObject2 = ReplyTextItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForReplyText.frienduin, localMessageForReplyText.istroop, localMessageForReplyText, localMessageForReplyText.mSourceMsgInfo);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReplyItemClickListener", 2, "onClick, getMessage is null, query from db");
            }
            Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(localMessageForReplyText.frienduin, localMessageForReplyText.istroop, null).iterator();
            do
            {
              localObject1 = localObject2;
              if (!localIterator.hasNext()) {
                break;
              }
              localObject1 = (MessageRecord)localIterator.next();
            } while (((MessageRecord)localObject1).shmsgseq != localMessageForReplyText.mSourceMsgInfo.mSourceMsgSeq);
          }
          if (((localObject1 instanceof MessageForUniteGrayTip)) && (((MessageForUniteGrayTip)localObject1).tipParam != null) && ((((MessageForUniteGrayTip)localObject1).tipParam.b == 1) || (((MessageForUniteGrayTip)localObject1).tipParam.b == 131073)))
          {
            label570:
            int i;
            if (((MessageForUniteGrayTip)localObject1).tipParam.b == 1)
            {
              j = 1;
              localObject1 = this.jdField_a_of_type_AndroidContentContext;
              if (j == 0) {
                break label631;
              }
              i = 0;
              label582:
              if (j == 0) {
                break label636;
              }
            }
            label631:
            label636:
            for (int j = 2131697693;; j = 2131697788)
            {
              QQToast.a((Context)localObject1, i, j, 0).b(((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getTitleBarHeight());
              ReplyTextItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, "0X800A36B");
              break;
              j = 0;
              break label570;
              i = 1;
              break label582;
            }
          }
          localObject2 = localChatFragment.a();
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) && ((localObject2 instanceof FriendChatPie))) {
            ((FriendChatPie)localObject2).a(22, localSourceMsgInfo.origUid, localSourceMsgInfo.mSourceMsgTime, null, 1, 1);
          }
          for (;;)
          {
            ReplyTextItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject1, "0X800A36A");
            break;
            if (((BaseChatPie)localObject2).h())
            {
              ((BaseChatPie)localObject2).a(22, localSourceMsgInfo.mSourceMsgSeq, (int)(localMessageForReplyText.shmsgseq - localSourceMsgInfo.mSourceMsgSeq), localMessageForReplyText, 1, 1);
              MessageForReplyText.reportReplyMsg(null, "replyMsg_bubble", "clk_original", localMessageForReplyText.frienduin, localMessageForReplyText);
              if (QLog.isColorLevel()) {
                QLog.w("ReplyItemClickListener", 2, "TextItemBuilder onClickListener: isReplyMsg = true");
              }
            }
            else if ((localObject2 instanceof MultiForwardChatPie))
            {
              ((BaseChatPie)localObject2).a(22, localSourceMsgInfo.mSourceMsgSeq, (int)(localMessageForReplyText.shmsgseq - localSourceMsgInfo.mSourceMsgSeq), localMessageForReplyText, 1, 1);
              if (QLog.isColorLevel()) {
                QLog.d("ReplyItemClickListener", 2, "MultiForwardChatPie onClickListener: isReplyMsg = true");
              }
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("ReplyItemClickListener", 2, "getChatFragment() is null");
        }
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131697692, 0).b(((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getTitleBarHeight());
        break;
        if (QLog.isColorLevel()) {
          QLog.d("ReplyItemClickListener", 2, "handleSourceAreaClick fail");
        }
        localObject1 = (FragmentActivity)this.jdField_a_of_type_AndroidContentContext;
        if (localObject1 != null) {}
        for (localObject1 = ((FragmentActivity)localObject1).getChatFragment();; localObject1 = null)
        {
          if (localObject1 == null) {
            ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, (FragmentActivity)this.jdField_a_of_type_AndroidContentContext);
          }
          for (;;)
          {
            a(9);
            break;
            ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, (FragmentActivity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.replymsg.ReplyItemClickListener
 * JD-Core Version:    0.7.0.1
 */