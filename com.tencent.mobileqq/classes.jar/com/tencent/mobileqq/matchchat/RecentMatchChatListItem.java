package com.tencent.mobileqq.matchchat;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.ExtendFriendUserInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.limitchat.SignalBombHelper;
import com.tencent.mobileqq.imcore.message.IMCoreMessageStub;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;

public class RecentMatchChatListItem
  extends RecentBaseData
{
  public static final String TAG = "expand.RecentMatchChatListItem";
  public int age = -1;
  public int career = -1;
  public int charmLevel;
  public String common;
  public int constellation = -1;
  public int gender = -1;
  public boolean mExtendFriendOnline;
  public boolean mHasFlowerMsg = false;
  public MessageRecord messageRecord;
  public int vip = -1;
  
  public RecentMatchChatListItem(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      throw new NullPointerException("RecentMatchChatListItem data is null");
    }
    this.messageRecord = paramMessageRecord;
  }
  
  public MsgSummary a()
  {
    return this.msgSummary;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    Object localObject1 = paramQQAppInterface.getMessageFacade();
    Object localObject2 = paramQQAppInterface.getConversationFacade();
    if (localObject1 != null) {}
    for (localObject1 = ((QQMessageFacade)localObject1).a(getRecentUserUin(), getRecentUserType());; localObject1 = null)
    {
      this.mExtraInfoColor = 0;
      this.mMsgExtroInfo = null;
      if (localObject1 != null)
      {
        this.mDisplayTime = ((Message)localObject1).time;
        if ((localObject2 != null) && (localObject1 != null))
        {
          this.mUnreadNum = ((ConversationFacade)localObject2).a(((Message)localObject1).frienduin, ((Message)localObject1).istroop);
          if (UinTypeUtil.a((MessageRecord)localObject1)) {
            this.mUnreadFlag = 3;
          }
          a(paramQQAppInterface, paramContext, (Message)localObject1);
          label95:
          localObject2 = super.getMsgSummaryTemp();
          super.buildMessageBody((IMCoreMessageStub)localObject1, getRecentUserType(), paramQQAppInterface, paramContext, (MsgSummary)localObject2);
          this.mHasFlowerMsg = false;
          this.mTitleName = ContactUtils.c(paramQQAppInterface, getRecentUserUin(), true);
          this.mAuthenIconId = 0;
          super.dealStatus(paramQQAppInterface);
          a(paramQQAppInterface, (MsgSummary)localObject2);
          super.extraUpdate(paramQQAppInterface, paramContext, (MsgSummary)localObject2);
          if (AppSetting.d)
          {
            paramQQAppInterface = new StringBuilder(24);
            paramQQAppInterface.append(this.mTitleName);
            if (this.mUnreadNum != 0) {
              break label274;
            }
          }
        }
      }
      for (;;)
      {
        if (this.mMsgExtroInfo != null) {
          paramQQAppInterface.append(this.mMsgExtroInfo + ",");
        }
        paramQQAppInterface.append(this.mLastMsg).append(' ').append(this.mShowTime);
        this.mContentDesc = paramQQAppInterface.toString();
        return;
        this.mUnreadNum = 0;
        break;
        this.mUnreadNum = 0;
        this.mDisplayTime = 0L;
        break label95;
        label274:
        if (this.mUnreadNum == 1) {
          paramQQAppInterface.append(paramContext.getResources().getString(2131698926));
        } else if (this.mUnreadNum == 2) {
          paramQQAppInterface.append(paramContext.getResources().getString(2131698927));
        } else if (this.mUnreadNum > 0) {
          paramQQAppInterface.append(paramContext.getResources().getString(2131698925, new Object[] { Integer.valueOf(this.mUnreadNum) }));
        }
      }
    }
  }
  
  protected void a(QQAppInterface paramQQAppInterface, Context paramContext, Message paramMessage)
  {
    paramQQAppInterface = ((ExtendFriendManager)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a(paramMessage.frienduin, false);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.isSignalBomb()) && (paramQQAppInterface.distance >= 0) && (paramQQAppInterface.showDistanceHLight))
    {
      this.mExtraInfoColor = paramContext.getResources().getColor(2131167145);
      this.mMsgExtroInfo = String.format(paramContext.getResources().getString(2131698822), new Object[] { SignalBombHelper.a(paramQQAppInterface.distance) });
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MsgSummary paramMsgSummary)
  {
    if (paramMsgSummary != null)
    {
      paramMsgSummary.bShowDraft = false;
      paramMsgSummary.mDraft = null;
    }
    paramQQAppInterface = paramQQAppInterface.getMessageFacade();
    if (paramQQAppInterface == null) {}
    do
    {
      long l;
      do
      {
        do
        {
          return;
          paramQQAppInterface = paramQQAppInterface.getDraftSummaryInfo(getRecentUserUin(), getRecentUserType());
        } while ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.getSummary())));
        l = paramQQAppInterface.getTime();
      } while (this.mDisplayTime > l);
      this.mDisplayTime = l;
    } while (paramMsgSummary == null);
    paramMsgSummary.bShowDraft = true;
    paramMsgSummary.mDraft = new QQText(paramQQAppInterface.getSummary(), 3, 16);
  }
  
  public void dealDraft(BaseQQAppInterface paramBaseQQAppInterface, MsgSummary paramMsgSummary)
  {
    if ((paramBaseQQAppInterface instanceof QQAppInterface)) {
      a((QQAppInterface)paramBaseQQAppInterface, paramMsgSummary);
    }
  }
  
  public long getLastDraftTime()
  {
    return 0L;
  }
  
  public long getLastMsgTime()
  {
    return this.messageRecord.time;
  }
  
  public int getRecentUserType()
  {
    return this.messageRecord.istroop;
  }
  
  public String getRecentUserUin()
  {
    return this.messageRecord.senderuin;
  }
  
  public void update(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    if ((paramBaseQQAppInterface instanceof QQAppInterface)) {
      a((QQAppInterface)paramBaseQQAppInterface, paramContext);
    }
    if (QLog.isColorLevel()) {
      QLog.d("expand.RecentMatchChatListItem", 1, "msg update");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.matchchat.RecentMatchChatListItem
 * JD-Core Version:    0.7.0.1
 */