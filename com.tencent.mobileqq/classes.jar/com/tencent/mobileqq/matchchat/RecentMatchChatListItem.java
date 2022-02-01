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
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageRecord;
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
    if (paramMessageRecord != null)
    {
      this.messageRecord = paramMessageRecord;
      return;
    }
    throw new NullPointerException("RecentMatchChatListItem data is null");
  }
  
  public MsgSummary a()
  {
    return this.msgSummary;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    Object localObject1 = paramQQAppInterface.getMessageFacade();
    Object localObject2 = paramQQAppInterface.getConversationFacade();
    if (localObject1 != null) {
      localObject1 = ((QQMessageFacade)localObject1).getLastMessage(getRecentUserUin(), getRecentUserType());
    } else {
      localObject1 = null;
    }
    this.mExtraInfoColor = 0;
    this.mMsgExtroInfo = null;
    if (localObject1 != null)
    {
      this.mDisplayTime = ((Message)localObject1).time;
      if ((localObject2 != null) && (localObject1 != null)) {
        this.mUnreadNum = ((ConversationFacade)localObject2).a(((Message)localObject1).frienduin, ((Message)localObject1).istroop);
      } else {
        this.mUnreadNum = 0;
      }
      if (UinTypeUtil.c((MessageRecord)localObject1)) {
        this.mUnreadFlag = 3;
      }
    }
    else
    {
      this.mUnreadNum = 0;
      this.mDisplayTime = 0L;
    }
    localObject2 = super.getMsgSummaryTemp();
    super.buildMessageBody((Message)localObject1, getRecentUserType(), paramQQAppInterface, paramContext, (MsgSummary)localObject2);
    this.mHasFlowerMsg = false;
    this.mTitleName = ContactUtils.a(paramQQAppInterface, getRecentUserUin(), true);
    this.mAuthenIconId = 0;
    super.dealStatus(paramQQAppInterface);
    a(paramQQAppInterface, (MsgSummary)localObject2);
    super.extraUpdate(paramQQAppInterface, paramContext, (MsgSummary)localObject2);
    if (AppSetting.e)
    {
      paramQQAppInterface = new StringBuilder(24);
      paramQQAppInterface.append(this.mTitleName);
      if (this.mUnreadNum == 1) {
        paramQQAppInterface.append(paramContext.getResources().getString(2131897009));
      } else if (this.mUnreadNum == 2) {
        paramQQAppInterface.append(paramContext.getResources().getString(2131897010));
      } else if (this.mUnreadNum > 0) {
        paramQQAppInterface.append(paramContext.getResources().getString(2131897008, new Object[] { Integer.valueOf(this.mUnreadNum) }));
      }
      if (this.mMsgExtroInfo != null)
      {
        paramContext = new StringBuilder();
        paramContext.append(this.mMsgExtroInfo);
        paramContext.append(",");
        paramQQAppInterface.append(paramContext.toString());
      }
      paramQQAppInterface.append(this.mLastMsg);
      paramQQAppInterface.append(' ');
      paramQQAppInterface.append(this.mShowTime);
      this.mContentDesc = paramQQAppInterface.toString();
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
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface = paramQQAppInterface.getDraftSummaryInfo(getRecentUserUin(), getRecentUserType());
    if (paramQQAppInterface != null)
    {
      if (TextUtils.isEmpty(paramQQAppInterface.getSummary())) {
        return;
      }
      long l = paramQQAppInterface.getTime();
      if (this.mDisplayTime > l) {
        return;
      }
      this.mDisplayTime = l;
      if (paramMsgSummary != null)
      {
        paramMsgSummary.bShowDraft = true;
        paramMsgSummary.mDraft = new QQText(paramQQAppInterface.getSummary(), 3, 16);
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.matchchat.RecentMatchChatListItem
 * JD-Core Version:    0.7.0.1
 */