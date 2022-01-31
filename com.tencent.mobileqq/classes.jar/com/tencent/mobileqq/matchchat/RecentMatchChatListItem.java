package com.tencent.mobileqq.matchchat;

import akpc;
import akpy;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import anmg;
import ayki;
import bbcl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageRecord;

public class RecentMatchChatListItem
  extends RecentBaseData
{
  public int age = -1;
  public int career = -1;
  public int charmLevel;
  public String common;
  public int constellation = -1;
  public int gender = -1;
  public boolean mExtendFriendOnline;
  public boolean mHasFlowerMsg;
  MessageRecord messageRecord;
  public int vip = -1;
  
  public RecentMatchChatListItem(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      throw new NullPointerException("RecentMatchChatListItem data is null");
    }
    this.messageRecord = paramMessageRecord;
  }
  
  public int a()
  {
    return this.messageRecord.istroop;
  }
  
  public long a()
  {
    return this.messageRecord.time;
  }
  
  public String a()
  {
    return this.messageRecord.senderuin;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    Object localObject = paramQQAppInterface.a();
    akpc localakpc = paramQQAppInterface.a();
    if (localObject != null) {}
    for (localObject = ((QQMessageFacade)localObject).a(a(), a());; localObject = null)
    {
      label78:
      MsgSummary localMsgSummary;
      if (localObject != null)
      {
        this.mDisplayTime = ((QQMessageFacade.Message)localObject).time;
        if ((localakpc != null) && (localObject != null))
        {
          this.mUnreadNum = localakpc.a(((QQMessageFacade.Message)localObject).frienduin, ((QQMessageFacade.Message)localObject).istroop);
          if (akpy.d((MessageRecord)localObject)) {
            this.mUnreadFlag = 3;
          }
          localMsgSummary = super.a();
          this.mHasFlowerMsg = false;
          this.mExtraInfoColor = 0;
          this.mMsgExtroInfo = null;
          if (!anmg.a(paramQQAppInterface, a(), 1001)) {
            break label326;
          }
          this.mMsgExtroInfo = paramContext.getResources().getString(2131693287);
          this.mExtraInfoColor = paramContext.getResources().getColor(2131166955);
          if (localakpc != null) {
            localMsgSummary.strContent = localakpc.a(a(), 1001, paramContext.getResources().getString(2131693286), 0);
          }
          label171:
          this.mTitleName = bbcl.b(paramQQAppInterface, a(), true);
          this.mAuthenIconId = 0;
          super.a(paramQQAppInterface);
          a(paramQQAppInterface, localMsgSummary);
          super.a(paramQQAppInterface, paramContext, localMsgSummary);
          if (AppSetting.d)
          {
            paramQQAppInterface = new StringBuilder(24);
            paramQQAppInterface.append(this.mTitleName);
            if (this.mUnreadNum != 0) {
              break label390;
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
        break label78;
        label326:
        if (anmg.b(paramQQAppInterface, a(), 1001))
        {
          this.mHasFlowerMsg = true;
          this.mMsgExtroInfo = paramContext.getResources().getString(2131694401);
          this.mExtraInfoColor = paramContext.getResources().getColor(2131166955);
          break label171;
        }
        super.a((QQMessageFacade.Message)localObject, a(), paramQQAppInterface, paramContext, localMsgSummary);
        break label171;
        label390:
        if (this.mUnreadNum == 1) {
          paramQQAppInterface.append(paramContext.getResources().getString(2131699108));
        } else if (this.mUnreadNum == 2) {
          paramQQAppInterface.append(paramContext.getResources().getString(2131699109));
        } else if (this.mUnreadNum > 0) {
          paramQQAppInterface.append(paramContext.getResources().getString(2131699107, new Object[] { Integer.valueOf(this.mUnreadNum) }));
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MsgSummary paramMsgSummary)
  {
    if (paramMsgSummary != null)
    {
      paramMsgSummary.bShowDraft = false;
      paramMsgSummary.mDraft = null;
    }
    paramQQAppInterface = paramQQAppInterface.a();
    if (paramQQAppInterface == null) {}
    long l;
    do
    {
      do
      {
        return;
        paramQQAppInterface = paramQQAppInterface.a(a(), a());
      } while ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.getSummary())));
      l = paramQQAppInterface.getTime();
    } while (this.mDisplayTime > l);
    this.mDisplayTime = l;
    paramMsgSummary.bShowDraft = true;
    paramMsgSummary.mDraft = new ayki(paramQQAppInterface.getSummary(), 3, 16);
  }
  
  public long b()
  {
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.matchchat.RecentMatchChatListItem
 * JD-Core Version:    0.7.0.1
 */