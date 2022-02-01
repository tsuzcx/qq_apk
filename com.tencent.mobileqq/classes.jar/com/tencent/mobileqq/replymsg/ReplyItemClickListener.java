package com.tencent.mobileqq.replymsg;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.coreui.msglist.FriendScroller;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.helper.WriteTogetherHelper;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie;
import com.tencent.mobileqq.adapter.ChatHistoryStructAdapter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.api.ArkCommonUtil;
import com.tencent.mobileqq.ark.api.IArkMsgReplyMgr;
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
import com.tencent.mobileqq.filebrowser.IFileBrowserModel;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.openbrowser.FileBrowserParam;
import com.tencent.mobileqq.filemanager.openbrowser.FileModelAdapter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.qroute.QRoute;
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
    Object localObject1 = paramView;
    Object localObject2 = ReplyTextItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForReplyText.frienduin, paramMessageForReplyText.istroop, paramMessageForReplyText, paramMessageForReplyText.mSourceMsgInfo);
    Object localObject5 = null;
    Object localObject6 = null;
    Object localObject3 = localObject2;
    Object localObject4;
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReplyItemClickListener", 2, "onClick, getMessage is null, query from db");
      }
      localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramMessageForReplyText.frienduin, paramMessageForReplyText.istroop, null).iterator();
      do
      {
        localObject3 = localObject2;
        if (!((Iterator)localObject4).hasNext()) {
          break;
        }
        localObject3 = (MessageRecord)((Iterator)localObject4).next();
      } while (((MessageRecord)localObject3).shmsgseq != paramMessageForReplyText.mSourceMsgInfo.mSourceMsgSeq);
    }
    if (QLog.isColorLevel())
    {
      if (localObject3 == null) {
        localObject2 = "null";
      } else {
        localObject2 = localObject3.getClass().getName();
      }
      QLog.d("ReplyItemClickListener", 2, new Object[] { "clicked sourceMsg Class=", localObject2 });
    }
    int i;
    if (paramMessageForReplyText.isBarrageMsg) {
      if ((localObject3 instanceof MessageForPic))
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A885", "0X800A885", 0, 0, "", "", "", "");
      }
      else if ((localObject3 instanceof MessageForShortVideo))
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A886", "0X800A886", 0, 0, "", "", "", "");
      }
      else if (FileManagerUtil.a((MessageRecord)localObject3))
      {
        localObject2 = ReplyTextItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject3);
        if ((localObject2 instanceof MessageForFile))
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(((MessageRecord)localObject2).uniseq, ((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop);
          if (localObject2 != null)
          {
            i = FileManagerUtil.a(((FileManagerEntity)localObject2).fileName);
            if (i == 0) {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A885", "0X800A885", 0, 0, "", "", "", "");
            } else if (i == 2) {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A886", "0X800A886", 0, 0, "", "", "", "");
            }
          }
        }
        else if ((localObject2 instanceof MessageForTroopFile))
        {
          localObject2 = (MessageForTroopFile)localObject2;
          localObject2 = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForTroopFile)localObject2);
          if (localObject2 != null)
          {
            i = FileManagerUtil.a(((TroopFileStatusInfo)localObject2).g);
            if (i == 0) {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A885", "0X800A885", 0, 0, "", "", "", "");
            } else if (i == 2) {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A886", "0X800A886", 0, 0, "", "", "", "");
            }
          }
        }
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade() != null) && (localObject3 != null))
    {
      localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ((MessageRecord)localObject3).shmsgseq);
      localObject2 = localObject4;
      if (localObject4 == null)
      {
        bool1 = false;
        localObject2 = localObject4;
        break label567;
      }
    }
    else
    {
      localObject2 = null;
    }
    boolean bool1 = true;
    label567:
    if (QLog.isColorLevel())
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("check source msg, isReplySrcMsgExist = ");
      ((StringBuilder)localObject4).append(bool1);
      QLog.d("ReplyItemClickListener", 2, ((StringBuilder)localObject4).toString());
    }
    boolean bool2 = localObject3 instanceof MessageForShortVideo;
    int j = 5;
    if (bool2)
    {
      if ((paramView.getId() != 2131364549) && (paramView.getId() != 2131378668)) {
        return false;
      }
      localObject2 = localObject6;
      if (paramView.getId() == 2131364549) {
        localObject2 = (ImageView)((View)localObject1).findViewById(2131378668);
      }
      paramView = (MessageForShortVideo)localObject3;
      if (paramView.busiType != 0)
      {
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localObject4 = this.jdField_a_of_type_AndroidContentContext;
        if (localObject2 == null) {
          localObject2 = (ImageView)localObject1;
        }
        ShortVideoRealItemBuilder.a((QQAppInterface)localObject3, (Context)localObject4, paramView, (View)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false, true, ReplyTextItemBuilder.a(paramMessageForReplyText.mSourceMsgInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), bool1, paramMessageForReplyText);
      }
      else
      {
        ShortVideoItemBuilder.a(paramView, 0L, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, ReplyTextItemBuilder.a(paramMessageForReplyText.mSourceMsgInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), bool1, paramMessageForReplyText);
      }
      a(5);
      return true;
    }
    if ((localObject3 instanceof MessageForText))
    {
      if ((paramView.getId() != 2131364549) && (paramView.getId() != 2131371529)) {
        return false;
      }
      if (paramView.getId() == 2131364549) {
        paramView = (ETTextView)((View)localObject1).findViewById(2131371529);
      } else {
        paramView = null;
      }
      localObject2 = (BaseActivity)this.jdField_a_of_type_AndroidContentContext;
      if (a((MessageRecord)localObject3, (BaseActivity)localObject2)) {
        return true;
      }
      paramMessageForReplyText = localObject5;
      if (localObject2 != null) {
        paramMessageForReplyText = ((BaseActivity)localObject2).getChatFragment();
      }
      if (paramMessageForReplyText == null)
      {
        paramMessageForReplyText = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (paramView == null) {
          paramView = (View)localObject1;
        }
        ChatActivityUtils.a(paramMessageForReplyText, paramView, (BaseActivity)this.jdField_a_of_type_AndroidContentContext);
      }
      else
      {
        paramMessageForReplyText = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (paramView == null) {
          paramView = (View)localObject1;
        }
        ChatActivityUtils.a(paramMessageForReplyText, paramView, (BaseActivity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      }
      a(1);
      return true;
    }
    bool2 = localObject3 instanceof MessageForMixedMsg;
    if ((!bool2) && (!(localObject3 instanceof MessageForPic))) {
      if (FileManagerUtil.a((MessageRecord)localObject3))
      {
        paramView = ReplyTextItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject3);
        if ((bool1) && (localObject2 != null)) {
          paramView.uniseq = ((MessageRecord)localObject2).uniseq;
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
            }
            else if (i == 2)
            {
              if (((FileManagerEntity)localObject1).status == 16) {
                return true;
              }
              if (!QFileUtils.a((FileManagerEntity)localObject1)) {
                return true;
              }
              if (((FileManagerEntity)localObject1).peerType == 0) {
                i = 1;
              } else if (((FileManagerEntity)localObject1).peerType == 3000) {
                i = 5;
              } else {
                i = 0;
              }
              QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageForFile)paramView, null, i, 10004, (FileManagerEntity)localObject1, false, true);
            }
            else
            {
              if (((FileManagerEntity)localObject1).peerType == 0) {
                i = 1;
              } else if (((FileManagerEntity)localObject1).peerType == 3000) {
                i = j;
              } else {
                i = 0;
              }
              paramView = new Bundle();
              paramView.putString("file_browser_extra_params_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
              paramView.putInt("FromChatHistoryTab", 106);
              paramMessageForReplyText = new FileModelAdapter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FileManagerEntity)localObject1);
              paramMessageForReplyText.a(paramView);
              paramView = new FileBrowserParam().a(i);
              ((IFileBrowserService)QRoute.api(IFileBrowserService.class)).browserFile(this.jdField_a_of_type_AndroidContentContext, paramMessageForReplyText, paramView);
            }
            a(6);
            return true;
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
            else if (i == 0)
            {
              i = ((TroopFileStatusInfo)localObject1).b;
              if ((i != 0) && (i != 1) && (i != 2) && (i != 3))
              {
                if ((i != 4) && (i != 5)) {
                  PicItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, null, paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true, ReplyTextItemBuilder.a(paramMessageForReplyText.mSourceMsgInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), bool1, paramMessageForReplyText);
                }
              }
              else
              {
                paramMessageForReplyText = new Intent();
                paramMessageForReplyText.putExtra(TroopFileProxyActivity.jdField_a_of_type_JavaLangString, paramView.frienduin);
                TroopFileProxyActivity.b((Activity)this.jdField_a_of_type_AndroidContentContext, paramMessageForReplyText, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
              }
            }
            else
            {
              QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramMessageForReplyText, (TroopFileStatusInfo)localObject1, paramView.senderuin, paramView.lastTime, 3, true);
            }
            a(6);
            return true;
          }
        }
      }
      else if ((localObject3 instanceof MessageForStructing))
      {
        if (!ChatHistoryStructAdapter.a((MessageRecord)localObject3)) {
          return false;
        }
        if (ReplyTextItemBuilder.b((MessageRecord)localObject3)) {
          return false;
        }
        paramView = (MessageForStructing)localObject3;
        if ((paramView.structingMsg != null) && ((paramView.structingMsg instanceof AbsShareMsg)))
        {
          paramView = (AbsShareMsg)paramView.structingMsg;
          if ((paramView instanceof StructMsgForGeneralShare))
          {
            ((View)localObject1).setTag(localObject3);
            paramMessageForReplyText = (StructMsgForGeneralShare)paramView;
            localObject2 = new StructMsgForGeneralShare.GeneralClickHandler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (View)localObject1, paramMessageForReplyText);
            StructMsgForGeneralShare.onClickEvent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramMessageForReplyText, (View)localObject1, (StructMsgForGeneralShare.GeneralClickHandler)localObject2);
          }
          else if ((paramView instanceof StructMsgForAudioShare))
          {
            paramMessageForReplyText = (StructMsgForAudioShare)paramView;
            StructMsgForAudioShare.onClickEvent(this.jdField_a_of_type_AndroidContentContext, paramMessageForReplyText);
          }
          paramView.getOnClickListener().onClick((View)localObject1);
          i = paramView.mMsgServiceID;
          if (i != 33)
          {
            if (i != 95)
            {
              a(9);
              return true;
            }
            a(7);
            return true;
          }
          a(8);
          return true;
        }
      }
      else if (!(localObject3 instanceof MessageForArkApp)) {}
    }
    for (;;)
    {
      try
      {
        paramMessageForReplyText = ((MessageForArkApp)localObject3).ark_app_message;
        if ((paramMessageForReplyText != null) && (((IArkMsgReplyMgr)QRoute.api(IArkMsgReplyMgr.class)).canReply(paramMessageForReplyText.appName, paramMessageForReplyText.appView)))
        {
          a(((IArkMsgReplyMgr)QRoute.api(IArkMsgReplyMgr.class)).msgReplyFromType(paramMessageForReplyText.appName, paramMessageForReplyText.appView));
          localObject3 = ((IArkMsgReplyMgr)QRoute.api(IArkMsgReplyMgr.class)).getReplyConfigFromMsg(new JSONObject(paramMessageForReplyText.toAppXml()));
          localObject2 = (String)((Map)localObject3).get("kArkMsgReplyAction");
          localObject3 = (String)((Map)localObject3).get("kArkMsgReplyJumpUrl");
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            if ("showLargeText".equals(localObject2))
            {
              if (paramView.getId() == 2131364549) {
                break label2624;
              }
              if (paramView.getId() != 2131371529) {
                return false;
              }
              if (paramView.getId() != 2131364549) {
                break label2627;
              }
              paramView = (ETTextView)((View)localObject1).findViewById(2131371529);
              paramMessageForReplyText = (BaseActivity)this.jdField_a_of_type_AndroidContentContext;
              if (paramMessageForReplyText == null) {
                break label2632;
              }
              paramMessageForReplyText = paramMessageForReplyText.getChatFragment();
              if (paramMessageForReplyText == null)
              {
                paramMessageForReplyText = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                if (paramView != null) {
                  break label2637;
                }
                ChatActivityUtils.a(paramMessageForReplyText, (View)localObject1, (BaseActivity)this.jdField_a_of_type_AndroidContentContext);
                return true;
              }
              paramMessageForReplyText = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              if (paramView != null) {
                break label2643;
              }
              ChatActivityUtils.a(paramMessageForReplyText, (View)localObject1, (BaseActivity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
              return true;
            }
          }
          else
          {
            ArkCommonUtil.a((String)localObject3, 0, paramMessageForReplyText.appName);
            return true;
          }
        }
      }
      catch (Exception paramView)
      {
        paramMessageForReplyText = new StringBuilder();
        paramMessageForReplyText.append("handle sourceMsg of MessageForArkApp error: ");
        paramMessageForReplyText.append(paramView.getMessage());
        QLog.e("ReplyItemClickListener", 1, paramMessageForReplyText.toString());
      }
      return false;
      if ((paramView.getId() != 2131364549) && (paramView.getId() != 2131371529) && (paramView.getId() != 2131378668)) {
        return false;
      }
      if ((bool2) && ((paramView.getId() == 2131364549) || (paramView.getId() == 2131371529)))
      {
        if (paramView.getId() == 2131364549) {
          paramView = (ETTextView)((View)localObject1).findViewById(2131371529);
        } else {
          paramView = null;
        }
        paramMessageForReplyText = (BaseActivity)this.jdField_a_of_type_AndroidContentContext;
        if (paramMessageForReplyText != null) {
          paramMessageForReplyText = paramMessageForReplyText.getChatFragment();
        } else {
          paramMessageForReplyText = null;
        }
        if (paramMessageForReplyText == null)
        {
          paramMessageForReplyText = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (paramView == null) {
            paramView = (View)localObject1;
          }
          ChatActivityUtils.a(paramMessageForReplyText, paramView, (BaseActivity)this.jdField_a_of_type_AndroidContentContext);
        }
        else
        {
          paramMessageForReplyText = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (paramView == null) {
            paramView = (View)localObject1;
          }
          ChatActivityUtils.a(paramMessageForReplyText, paramView, (BaseActivity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        }
        a(3);
        return true;
      }
      if (((localObject3 instanceof MessageForPic)) && (!(localObject1 instanceof URLImageView)))
      {
        localObject1 = (MessageForPic)localObject3;
        if (((IPicHelper)QRoute.api(IPicHelper.class)).isEmotion((MessageForPic)localObject1))
        {
          AIOEmotionFragment.a(this.jdField_a_of_type_AndroidContentContext, (MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, AnimationUtils.a(paramView), ReplyTextItemBuilder.a(paramMessageForReplyText.mSourceMsgInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), false);
          return true;
        }
        PicItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, null, (ChatMessage)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true, ReplyTextItemBuilder.a(paramMessageForReplyText.mSourceMsgInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), bool1, paramMessageForReplyText);
        return true;
      }
      paramView = (URLImageView)localObject1;
      localObject1 = (MessageForPic)paramView.getTag(2131364535);
      localObject2 = (URLDrawable)paramView.getDrawable();
      if (localObject2 == null) {
        return false;
      }
      i = ((URLDrawable)localObject2).getStatus();
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2) {}
        }
        else
        {
          for (;;)
          {
            if (FolderUtils.a(this.jdField_a_of_type_AndroidContentContext))
            {
              ((URLDrawable)localObject2).restartDownload();
              continue;
              if (!((IPicHelper)QRoute.api(IPicHelper.class)).isEmotion((MessageForPic)localObject1)) {
                break;
              }
              AIOEmotionFragment.a(this.jdField_a_of_type_AndroidContentContext, (MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, AnimationUtils.a(paramView), ReplyTextItemBuilder.a(paramMessageForReplyText.mSourceMsgInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), false);
            }
          }
          PicItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramView, (ChatMessage)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true, ReplyTextItemBuilder.a(paramMessageForReplyText.mSourceMsgInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), bool1, paramMessageForReplyText);
        }
      }
      else if (!((URLDrawable)localObject2).isDownloadStarted()) {
        ((URLDrawable)localObject2).startDownload();
      }
      if (bool2)
      {
        a(4);
        return true;
      }
      a(2);
      return true;
      label2624:
      continue;
      label2627:
      paramView = null;
      continue;
      label2632:
      paramMessageForReplyText = null;
      continue;
      label2637:
      localObject1 = paramView;
      continue;
      label2643:
      localObject1 = paramView;
    }
  }
  
  private boolean a(MessageRecord paramMessageRecord, BaseActivity paramBaseActivity)
  {
    if ((paramMessageRecord instanceof MessageForWriteTogether))
    {
      paramBaseActivity = paramBaseActivity.getChatFragment().a();
      if (paramBaseActivity != null)
      {
        paramBaseActivity = (WriteTogetherHelper)paramBaseActivity.a(74);
        if (paramBaseActivity != null)
        {
          paramBaseActivity.a(((MessageForWriteTogether)paramMessageRecord).padId, 4);
          return true;
        }
      }
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder.a())
    {
      long l = System.currentTimeMillis();
      if (l - this.jdField_a_of_type_Long >= 1000L)
      {
        this.jdField_a_of_type_Long = l;
        Object localObject1 = AIOUtils.a(paramView);
        Object localObject2 = localObject1;
        if ((localObject1 instanceof MessageForMixedMsg))
        {
          localObject1 = (MessageForMixedMsg)localObject1;
          if (((MessageForMixedMsg)localObject1).getReplyMessage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != null) {
            localObject2 = ((MessageForMixedMsg)localObject1).getReplyMessage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          }
        }
        else
        {
          boolean bool = localObject2 instanceof MessageForReplyText;
          localObject1 = "ReplyItemClickListener";
          Object localObject3;
          if (!bool)
          {
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("TextItemBuilder onClickListener: AIOUtils.getMessage(v) is not MessageForReplyText, it's");
              if (localObject2 != null) {
                localObject1 = localObject2.getClass().getSimpleName();
              } else {
                localObject1 = "null";
              }
              ((StringBuilder)localObject3).append((String)localObject1);
              QLog.w("ReplyItemClickListener", 2, ((StringBuilder)localObject3).toString());
            }
          }
          else
          {
            MessageForReplyText localMessageForReplyText = (MessageForReplyText)localObject2;
            MessageForReplyText.SourceMsgInfo localSourceMsgInfo1 = localMessageForReplyText.mSourceMsgInfo;
            int j = localMessageForReplyText.msgtype;
            int i = 1;
            if (j == -1003)
            {
              AIOUtils.o = true;
              localObject2 = PkgTools.decodeCgi(localMessageForReplyText.action);
              localObject2 = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.getContext(), (String)localObject2);
              if (localObject2 != null) {
                ((JumpAction)localObject2).a();
              }
            }
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("ReplyTextItemBuilder OnClickListener original sourceMsgInfo msgUid= ");
              ((StringBuilder)localObject2).append(localSourceMsgInfo1.origUid);
              ((StringBuilder)localObject2).append(", time = ");
              ((StringBuilder)localObject2).append(localSourceMsgInfo1.mSourceMsgTime);
              QLog.d("ReplyItemClickListener", 2, ((StringBuilder)localObject2).toString());
            }
            j = paramView.getId();
            localObject2 = null;
            switch (j)
            {
            default: 
              break;
            case 2131369413: 
              localObject2 = this.jdField_a_of_type_AndroidContentContext;
              if ((localObject2 instanceof BaseActivity))
              {
                Object localObject4 = ((BaseActivity)localObject2).getChatFragment();
                if (localObject4 != null)
                {
                  localObject3 = ReplyTextItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForReplyText.frienduin, localMessageForReplyText.istroop, localMessageForReplyText, localMessageForReplyText.mSourceMsgInfo);
                  localObject2 = localObject1;
                  if (localObject3 == null)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("ReplyItemClickListener", 2, "onClick, getMessage is null, query from db");
                    }
                    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(localMessageForReplyText.frienduin, localMessageForReplyText.istroop, null).iterator();
                    for (;;)
                    {
                      localObject2 = localObject1;
                      if (!localIterator.hasNext()) {
                        break;
                      }
                      localObject2 = (MessageRecord)localIterator.next();
                      l = ((MessageRecord)localObject2).shmsgseq;
                      MessageForReplyText.SourceMsgInfo localSourceMsgInfo2 = localMessageForReplyText.mSourceMsgInfo;
                      if (l == localSourceMsgInfo2.mSourceMsgSeq) {
                        break label538;
                      }
                    }
                  }
                  localObject1 = localObject2;
                  localObject2 = localObject3;
                  if ((localObject2 instanceof MessageForUniteGrayTip))
                  {
                    localObject3 = (MessageForUniteGrayTip)localObject2;
                    if ((((MessageForUniteGrayTip)localObject3).tipParam != null) && ((((MessageForUniteGrayTip)localObject3).tipParam.b == 1) || (((MessageForUniteGrayTip)localObject3).tipParam.b == 131073)))
                    {
                      if (((MessageForUniteGrayTip)localObject3).tipParam.b != 1) {
                        i = 0;
                      }
                      localObject1 = this.jdField_a_of_type_AndroidContentContext;
                      if (i != 0) {
                        j = 2131697699;
                      } else {
                        j = 2131697794;
                      }
                      QQToast.a((Context)localObject1, i ^ 0x1, j, 0).b(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getTitleBarHeight());
                      ReplyTextItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, "0X800A36B");
                      break;
                    }
                  }
                  localObject3 = ((ChatFragment)localObject4).a();
                  localObject4 = ((BaseChatPie)localObject3).b().a().a();
                  if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) && ((localObject3 instanceof FriendChatPie)))
                  {
                    ((FriendScroller)localObject4).a(22, localSourceMsgInfo1.origUid, localSourceMsgInfo1.mSourceMsgTime, 1, 1);
                  }
                  else if (((BaseChatPie)localObject3).e())
                  {
                    ((Scroller)localObject4).a(22, localSourceMsgInfo1.mSourceMsgSeq, (int)(localMessageForReplyText.shmsgseq - localSourceMsgInfo1.mSourceMsgSeq), 1, 1);
                    MessageForReplyText.reportReplyMsg(null, "replyMsg_bubble", "clk_original", localMessageForReplyText.frienduin, localMessageForReplyText);
                    if (QLog.isColorLevel()) {
                      QLog.w((String)localObject1, 2, "TextItemBuilder onClickListener: isReplyMsg = true");
                    }
                  }
                  else if ((localObject3 instanceof MultiForwardChatPie))
                  {
                    ((Scroller)localObject4).a(22, localSourceMsgInfo1.mSourceMsgSeq, (int)(localMessageForReplyText.shmsgseq - localSourceMsgInfo1.mSourceMsgSeq), 1, 1);
                    if (QLog.isColorLevel()) {
                      QLog.d((String)localObject1, 2, "MultiForwardChatPie onClickListener: isReplyMsg = true");
                    }
                  }
                  ReplyTextItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject2, "0X800A36A");
                }
                else
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ReplyItemClickListener", 2, "getChatFragment() is null");
                  }
                  QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131697698, 0).b(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getTitleBarHeight());
                }
              }
              break;
            case 2131364549: 
            case 2131371529: 
            case 2131378668: 
              label538:
              if (a(paramView, localMessageForReplyText))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("ReplyItemClickListener", 2, "handleSourceAreaClick success");
                }
              }
              else
              {
                if (QLog.isColorLevel()) {
                  QLog.d("ReplyItemClickListener", 2, "handleSourceAreaClick fail");
                }
                localObject3 = (BaseActivity)this.jdField_a_of_type_AndroidContentContext;
                localObject1 = localObject2;
                if (localObject3 != null) {
                  localObject1 = ((BaseActivity)localObject3).getChatFragment();
                }
                if (localObject1 == null) {
                  ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, (BaseActivity)this.jdField_a_of_type_AndroidContentContext);
                } else {
                  ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, (BaseActivity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
                }
                a(9);
              }
              break;
            }
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.replymsg.ReplyItemClickListener
 * JD-Core Version:    0.7.0.1
 */