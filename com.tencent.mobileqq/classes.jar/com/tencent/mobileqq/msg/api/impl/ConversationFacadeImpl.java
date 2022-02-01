package com.tencent.mobileqq.msg.api.impl;

import com.tencent.imcore.message.ConversationFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;

public class ConversationFacadeImpl
  implements IConversationFacade
{
  public static final String TAG = "ConversationFacadeImpl";
  private QQAppInterface mApp;
  
  public void addNewSayHelloToSet(int paramInt, String paramString)
  {
    this.mApp.getConversationFacade().a(paramInt, paramString);
  }
  
  public void addUnread(List<MessageRecord> paramList)
  {
    this.mApp.getConversationFacade().a(paramList);
  }
  
  public void calculateNearbyBoxUnreadCount(String paramString, int paramInt)
  {
    this.mApp.getConversationFacade().n(paramString, paramInt);
  }
  
  public void cleanUnread(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    this.mApp.getConversationFacade().a(paramString, paramInt, paramLong, paramBoolean);
  }
  
  public void cleanUnread(String paramString, int paramInt, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mApp.getConversationFacade().a(paramString, paramInt, paramLong, paramBoolean1, paramBoolean2);
  }
  
  public void cleanUnread(String paramString, int paramInt1, long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    this.mApp.getConversationFacade().a(paramString, paramInt1, paramLong, paramBoolean1, paramBoolean2, paramInt2);
  }
  
  public void cleanUnreadFrom(String paramString, int paramInt, long paramLong)
  {
    this.mApp.getConversationFacade().a(paramString, paramInt, paramLong);
  }
  
  public void decreaseUnread(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    this.mApp.getConversationFacade().a(paramString, paramInt, paramMessageRecord);
  }
  
  public void decreaseUnreads(String paramString, int paramInt, List<MessageRecord> paramList)
  {
    this.mApp.getConversationFacade().a(paramString, paramInt, paramList);
  }
  
  public ConversationInfo getConversationInfo(String paramString, int paramInt)
  {
    return this.mApp.getConversationFacade().p(paramString, paramInt);
  }
  
  public Set<ConversationInfo> getConversationInfoSet()
  {
    return this.mApp.getConversationFacade().a();
  }
  
  public long getLastRead(String paramString, int paramInt)
  {
    return this.mApp.getConversationFacade().e(paramString, paramInt);
  }
  
  public int getPublicAccountConversationRedMask(String paramString, int paramInt)
  {
    return this.mApp.getConversationFacade().h(paramString, paramInt);
  }
  
  public int getReadUnreadCount(String paramString, int paramInt)
  {
    return this.mApp.getConversationFacade().c(paramString, paramInt);
  }
  
  public int getReadUnreadMark(String paramString, int paramInt)
  {
    return this.mApp.getConversationFacade().d(paramString, paramInt);
  }
  
  public ConversationInfo getTinyConvInfo(String paramString, int paramInt)
  {
    return this.mApp.getConversationFacade().q(paramString, paramInt);
  }
  
  public int getTroopMask(String paramString)
  {
    return this.mApp.getTroopMask(paramString);
  }
  
  public int getUnreadCount(String paramString, int paramInt)
  {
    return this.mApp.getConversationFacade().a(paramString, paramInt);
  }
  
  public int getUnreadCountConfess(String paramString, int paramInt1, int paramInt2)
  {
    return this.mApp.getConversationFacade().a(paramString, paramInt1, paramInt2);
  }
  
  public int getUnreadCountFromExtInt2(String paramString, int paramInt)
  {
    return this.mApp.getConversationFacade().b(paramString, paramInt);
  }
  
  public void increaseUnread(String paramString, int paramInt1, int paramInt2)
  {
    this.mApp.getConversationFacade().e(paramString, paramInt1, paramInt2);
  }
  
  public boolean isInMsgBox(String paramString, int paramInt)
  {
    return this.mApp.getConversationFacade().j(paramString, paramInt);
  }
  
  public boolean isInMsgBox(String paramString1, int paramInt, String paramString2)
  {
    return this.mApp.getConversationFacade().a(paramString1, paramInt, paramString2);
  }
  
  public boolean isSyncMsgFinish()
  {
    return (this.mApp.mAutomator != null) && (this.mApp.mAutomator.h());
  }
  
  public boolean isUinInRecentList(String paramString, int paramInt)
  {
    return this.mApp.getConversationFacade().o(paramString, paramInt);
  }
  
  public boolean isUinInRecentNotSubAccount(String paramString)
  {
    return this.mApp.getConversationFacade().a(paramString);
  }
  
  public void moveBoxToMessageTab(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    this.mApp.getConversationFacade().a(paramString1, paramInt1, paramString2, paramInt2);
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    if (QLog.isColorLevel())
    {
      boolean bool1 = false;
      boolean bool2 = paramAppRuntime instanceof QQAppInterface;
      if (paramAppRuntime == null) {
        bool1 = true;
      }
      QLog.d("ConversationFacadeImpl", 2, new Object[] { "ConversationFacadeImpl onCreate: app instanceOf QQApp: ", Boolean.valueOf(bool2), "app is null: ", Boolean.valueOf(bool1) });
    }
    if ((paramAppRuntime instanceof QQAppInterface)) {
      this.mApp = ((QQAppInterface)paramAppRuntime);
    }
  }
  
  public void onDestroy() {}
  
  public void removeUnreadItem(String paramString, int paramInt)
  {
    this.mApp.getConversationFacade().i(paramString, paramInt);
  }
  
  public void setSubAccountTroopUnReadMsg(String paramString, int paramInt1, int paramInt2)
  {
    this.mApp.getConversationFacade().c(paramString, paramInt1, paramInt2);
  }
  
  public void setTroopMsgFilterToServer(String paramString, Integer paramInteger)
  {
    this.mApp.setTroopMsgFilterToServer(paramString, paramInteger);
  }
  
  public void setUnreadMark(String paramString, int paramInt1, int paramInt2)
  {
    this.mApp.getConversationFacade().b(paramString, paramInt1, paramInt2);
  }
  
  public void updateLastRead(String paramString, int paramInt, long paramLong)
  {
    this.mApp.getConversationFacade().b(paramString, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msg.api.impl.ConversationFacadeImpl
 * JD-Core Version:    0.7.0.1
 */