package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.content.Context;
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
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder;
import com.tencent.mobileqq.adapter.ChatHistoryStructAdapter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.api.ArkCommonUtil;
import com.tencent.mobileqq.ark.api.IArkMsgReplyMgr;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare.GeneralClickHandler;
import com.tencent.mobileqq.utils.FolderUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class GuildReplyItemClickListener
  implements View.OnClickListener
{
  private final int a = 1000;
  private long b = 0L;
  private QQAppInterface c;
  private Context d;
  private SessionInfo e;
  private BaseGuildMsgViewBuild f;
  
  public GuildReplyItemClickListener(BaseGuildMsgViewBuild paramBaseGuildMsgViewBuild)
  {
    this.c = paramBaseGuildMsgViewBuild.g;
    this.d = paramBaseGuildMsgViewBuild.b;
    this.e = paramBaseGuildMsgViewBuild.c;
    this.f = paramBaseGuildMsgViewBuild;
  }
  
  private void a(int paramInt) {}
  
  private void a(MessageForReplyText paramMessageForReplyText, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo)
  {
    ChatFragment localChatFragment = ((BaseActivity)this.d).getChatFragment();
    if (localChatFragment == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuildReplyItemClickListener", 2, "getChatFragment() is null");
      }
      QQToast.makeText(this.d, 2131895471, 0).show(((BaseActivity)this.d).getTitleBarHeight());
      return;
    }
    MessageRecord localMessageRecord = ReplyTextItemBuilder.a(this.c, paramMessageForReplyText.frienduin, paramMessageForReplyText.istroop, paramMessageForReplyText, paramMessageForReplyText.mSourceMsgInfo);
    Object localObject = localMessageRecord;
    if (localMessageRecord == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuildReplyItemClickListener", 2, "onClick, getMessage is null, query from db");
      }
      Iterator localIterator = this.c.getMessageFacade().a(paramMessageForReplyText.frienduin, paramMessageForReplyText.istroop, null).iterator();
      do
      {
        localObject = localMessageRecord;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (MessageRecord)localIterator.next();
      } while (((MessageRecord)localObject).shmsgseq != paramMessageForReplyText.mSourceMsgInfo.mSourceMsgSeq);
    }
    if ((localObject instanceof MessageForUniteGrayTip))
    {
      localObject = (MessageForUniteGrayTip)localObject;
      if (((MessageForUniteGrayTip)localObject).tipParam != null)
      {
        int j = ((MessageForUniteGrayTip)localObject).tipParam.i;
        int i = 1;
        if ((j == 1) || (((MessageForUniteGrayTip)localObject).tipParam.i == 131073))
        {
          if (((MessageForUniteGrayTip)localObject).tipParam.i != 1) {
            i = 0;
          }
          paramMessageForReplyText = this.d;
          if (i != 0) {
            j = 2131895472;
          } else {
            j = 2131895567;
          }
          QQToast.makeText(paramMessageForReplyText, i ^ 0x1, j, 0).show(((BaseActivity)this.d).getTitleBarHeight());
          return;
        }
      }
    }
    localChatFragment.k().bv().e().d().a(22, paramSourceMsgInfo.mSourceMsgSeq, (int)(paramMessageForReplyText.shmsgseq - paramSourceMsgInfo.mSourceMsgSeq), 2, 1);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TextItemBuilder onClickListener: isReplyMsg = true. sourmsgSeq:");
      ((StringBuilder)localObject).append(paramSourceMsgInfo.mSourceMsgSeq);
      ((StringBuilder)localObject).append(" currentMsg:");
      ((StringBuilder)localObject).append(paramMessageForReplyText.shmsgseq);
      QLog.w("GuildReplyItemClickListener", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private boolean a(View paramView, MessageForReplyText paramMessageForReplyText)
  {
    Object localObject1 = paramView;
    Object localObject2 = ReplyTextItemBuilder.a(this.c, paramMessageForReplyText.frienduin, paramMessageForReplyText.istroop, paramMessageForReplyText, paramMessageForReplyText.mSourceMsgInfo);
    Context localContext = null;
    Object localObject4 = null;
    Object localObject3 = localObject2;
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuildReplyItemClickListener", 2, "onClick, getMessage is null, query from db");
      }
      Iterator localIterator = this.c.getMessageFacade().a(paramMessageForReplyText.frienduin, paramMessageForReplyText.istroop, null).iterator();
      do
      {
        localObject3 = localObject2;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject3 = (MessageRecord)localIterator.next();
      } while (((MessageRecord)localObject3).shmsgseq != paramMessageForReplyText.mSourceMsgInfo.mSourceMsgSeq);
    }
    if (QLog.isColorLevel())
    {
      if (localObject3 == null) {
        localObject2 = "null";
      } else {
        localObject2 = localObject3.getClass().getName();
      }
      QLog.d("GuildReplyItemClickListener", 2, new Object[] { "clicked sourceMsg Class=", localObject2 });
    }
    boolean bool1;
    if ((this.c.getMessageFacade() != null) && (localObject3 != null) && (this.c.getMessageFacade().c(this.e.b, this.e.a, ((MessageRecord)localObject3).shmsgseq) == null)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("check source msg, isReplySrcMsgExist = ");
      ((StringBuilder)localObject2).append(bool1);
      QLog.d("GuildReplyItemClickListener", 2, ((StringBuilder)localObject2).toString());
    }
    if ((localObject3 instanceof MessageForShortVideo))
    {
      if ((paramView.getId() != 2131430607) && (paramView.getId() != 2131447325)) {
        return false;
      }
      localObject2 = localObject4;
      if (paramView.getId() == 2131430607) {
        localObject2 = (ImageView)((View)localObject1).findViewById(2131447325);
      }
      paramView = (MessageForShortVideo)localObject3;
      if (paramView.subBusiType != 4602)
      {
        localObject3 = this.c;
        localContext = this.d;
        if (localObject2 == null) {
          localObject2 = (ImageView)localObject1;
        }
        GuildShortVideoItemBuilder.a((QQAppInterface)localObject3, localContext, paramView, (View)localObject2, this.e, false, true, ReplyTextItemBuilder.a(paramMessageForReplyText.mSourceMsgInfo, this.e, this.c), bool1, paramMessageForReplyText);
        return true;
      }
      GuildLongVideoItemBuilder.a(paramView, 0L, this.d, this.c, this.e, ReplyTextItemBuilder.a(paramMessageForReplyText.mSourceMsgInfo, this.e, this.c), bool1, paramMessageForReplyText);
      return true;
    }
    boolean bool2 = localObject3 instanceof MessageForMixedMsg;
    int i;
    if ((!bool2) && (!(localObject3 instanceof MessageForPic))) {
      if ((localObject3 instanceof MessageForStructing))
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
            localObject2 = new StructMsgForGeneralShare.GeneralClickHandler(this.c, (View)localObject1, paramMessageForReplyText);
            StructMsgForGeneralShare.onClickEvent(this.c, this.d, paramMessageForReplyText, (View)localObject1, (StructMsgForGeneralShare.GeneralClickHandler)localObject2);
          }
          else if ((paramView instanceof StructMsgForAudioShare))
          {
            paramMessageForReplyText = (StructMsgForAudioShare)paramView;
            StructMsgForAudioShare.onClickEvent(this.d, paramMessageForReplyText);
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
              if ((paramView.getId() != 2131430607) && (paramView.getId() != 2131438908)) {
                return false;
              }
              if (paramView.getId() != 2131430607) {
                break label1335;
              }
              paramView = (ETTextView)((View)localObject1).findViewById(2131438908);
              localObject2 = (BaseActivity)this.d;
              paramMessageForReplyText = localContext;
              if (localObject2 != null) {
                paramMessageForReplyText = ((BaseActivity)localObject2).getChatFragment();
              }
              if (paramMessageForReplyText == null)
              {
                paramMessageForReplyText = this.c;
                if (paramView != null) {
                  break label1340;
                }
                ChatActivityUtils.a(paramMessageForReplyText, (View)localObject1, (BaseActivity)this.d);
                return true;
              }
              paramMessageForReplyText = this.c;
              if (paramView != null) {
                break label1346;
              }
              ChatActivityUtils.a(paramMessageForReplyText, (View)localObject1, (BaseActivity)this.d, this.e.a);
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
        QLog.e("GuildReplyItemClickListener", 1, paramMessageForReplyText.toString());
      }
      return false;
      if ((paramView.getId() != 2131430607) && (paramView.getId() != 2131438908) && (paramView.getId() != 2131447325)) {
        return false;
      }
      if (((localObject3 instanceof MessageForPic)) && (!(localObject1 instanceof URLImageView)))
      {
        localObject1 = (MessageForPic)localObject3;
        if (((IPicHelper)QRoute.api(IPicHelper.class)).isEmotion((MessageForPic)localObject1))
        {
          AIOEmotionFragment.a(this.d, (MessageRecord)localObject1, this.e, AnimationUtils.a(paramView), ReplyTextItemBuilder.a(paramMessageForReplyText.mSourceMsgInfo, this.e, this.c), false);
          return true;
        }
        PicItemBuilder.a(this.c, this.d, null, (ChatMessage)localObject1, this.e, true, ReplyTextItemBuilder.a(paramMessageForReplyText.mSourceMsgInfo, this.e, this.c), bool1, paramMessageForReplyText);
        return true;
      }
      if (!(localObject1 instanceof URLImageView)) {
        return false;
      }
      paramView = (URLImageView)localObject1;
      localObject1 = (MessageForPic)paramView.getTag(2131430592);
      localObject2 = (URLDrawable)paramView.getDrawable();
      if (localObject2 == null) {
        return false;
      }
      i = ((URLDrawable)localObject2).getStatus();
      if (i != 0)
      {
        if (i != 1)
        {
          if ((i == 2) && (FolderUtils.a(this.d))) {
            ((URLDrawable)localObject2).restartDownload();
          }
        }
        else if (((IPicHelper)QRoute.api(IPicHelper.class)).isEmotion((MessageForPic)localObject1)) {
          AIOEmotionFragment.a(this.d, (MessageRecord)localObject1, this.e, AnimationUtils.a(paramView), ReplyTextItemBuilder.a(paramMessageForReplyText.mSourceMsgInfo, this.e, this.c), false);
        } else {
          PicItemBuilder.a(this.c, this.d, paramView, (ChatMessage)localObject1, this.e, true, ReplyTextItemBuilder.a(paramMessageForReplyText.mSourceMsgInfo, this.e, this.c), bool1, paramMessageForReplyText);
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
      label1335:
      paramView = null;
      continue;
      label1340:
      localObject1 = paramView;
      continue;
      label1346:
      localObject1 = paramView;
    }
  }
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.b < 1000L) {
      return;
    }
    this.b = l;
    Object localObject2 = AIOUtils.a(paramView);
    Object localObject1 = localObject2;
    if ((localObject2 instanceof MessageForMixedMsg))
    {
      localObject2 = (MessageForMixedMsg)localObject2;
      localObject1 = ((MessageForMixedMsg)localObject2).getReplyMessage(this.c);
      if (localObject1 == null) {
        return;
      }
      ((ChatMessage)localObject1).shmsgseq = ((MessageForMixedMsg)localObject2).shmsgseq;
    }
    if (!(localObject1 instanceof MessageForReplyText))
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("TextItemBuilder onClickListener: AIOUtils.getMessage(v) is not MessageForReplyText, it's");
        if (localObject1 != null) {
          paramView = localObject1.getClass().getSimpleName();
        } else {
          paramView = "null";
        }
        ((StringBuilder)localObject2).append(paramView);
        QLog.w("GuildReplyItemClickListener", 2, ((StringBuilder)localObject2).toString());
      }
      return;
    }
    localObject1 = (MessageForReplyText)localObject1;
    localObject2 = ((MessageForReplyText)localObject1).mSourceMsgInfo;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ReplyTextItemBuilder OnClickListener original sourceMsgInfo msgUid= ");
      localStringBuilder.append(((MessageForReplyText.SourceMsgInfo)localObject2).origUid);
      localStringBuilder.append(", time = ");
      localStringBuilder.append(((MessageForReplyText.SourceMsgInfo)localObject2).mSourceMsgTime);
      QLog.d("GuildReplyItemClickListener", 2, localStringBuilder.toString());
    }
    switch (paramView.getId())
    {
    default: 
    case 2131436449: 
      if ((this.d instanceof BaseActivity))
      {
        a((MessageForReplyText)localObject1, (MessageForReplyText.SourceMsgInfo)localObject2);
        return;
      }
      break;
    case 2131430607: 
    case 2131438908: 
    case 2131447325: 
      if ((a(paramView, (MessageForReplyText)localObject1)) && (QLog.isColorLevel())) {
        QLog.d("GuildReplyItemClickListener", 2, "handleSourceAreaClick success");
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildReplyItemClickListener
 * JD-Core Version:    0.7.0.1
 */