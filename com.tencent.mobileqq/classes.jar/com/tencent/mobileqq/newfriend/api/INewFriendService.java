package com.tencent.mobileqq.newfriend.api;

import com.tencent.mobileqq.data.QIMFollwerAdd;
import com.tencent.mobileqq.data.SysSuspiciousMsg;
import com.tencent.mobileqq.newfriend.config.NewFriendContactGuideConfBean;
import com.tencent.mobileqq.newfriend.interfaces.INewFriendListener;
import com.tencent.mobileqq.newfriend.msg.FriendSystemMessage;
import com.tencent.mobileqq.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface INewFriendService
  extends IRuntimeService
{
  public abstract void addListener(INewFriendListener paramINewFriendListener);
  
  public abstract void addObserver(Observer paramObserver);
  
  public abstract void clearAllSysSuspiciousMsg();
  
  public abstract void deleteObserver(Observer paramObserver);
  
  public abstract void deleteSysSuspiciousMsg(long paramLong);
  
  public abstract List<SysSuspiciousMsg> getAllSysSuspiciousMsg();
  
  public abstract int getAllUnreadMessageCount();
  
  public abstract List<Object> getAllUnreadMsg();
  
  public abstract NewFriendContactGuideConfBean getConfBean();
  
  public abstract NewFriendMessage getLastUnreadNewFriendMessage();
  
  public abstract void getUnreadMessageCountAsync();
  
  public abstract int getUnreadSystemMessageCount();
  
  public abstract boolean handleNewFrdAIOShow(int paramInt, String paramString);
  
  public abstract void handleQIMNewFollower(QIMFollwerAdd paramQIMFollwerAdd);
  
  public abstract void initNewFriendList();
  
  public abstract void insertCommonHobbyForAIOShowNewsMsg(String paramString1, String paramString2);
  
  public abstract void insertFriendFeedForAIOShowNewsMsg(String paramString1, String paramString2);
  
  public abstract boolean isFirstEnterNewFriendAio(String paramString);
  
  public abstract boolean isNewFriend(String paramString);
  
  public abstract void loadNewFriendMsg(boolean paramBoolean);
  
  public abstract void markAllDataReaded();
  
  public abstract void markSystemMsgReaded();
  
  public abstract boolean needShowAvatar();
  
  public abstract void refreshContactUnreadCount();
  
  public abstract void refreshNotificationWithFriendSystemMessage(FriendSystemMessage paramFriendSystemMessage);
  
  public abstract void reloadNewFriendMsg();
  
  public abstract void removeListener(INewFriendListener paramINewFriendListener);
  
  public abstract void saveNewFriend2Cache(String paramString);
  
  public abstract void setSysSuspiciousUnreadNum(int paramInt);
  
  public abstract void updateBindContactGuideState();
  
  public abstract void updateSuspiciousMsgListFromServer(ArrayList<SysSuspiciousMsg> paramArrayList, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.api.INewFriendService
 * JD-Core Version:    0.7.0.1
 */