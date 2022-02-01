package com.tencent.mobileqq.subaccount.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.message.AbsSubAccountMessageProcessor;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface ISubAccountService
  extends IRuntimeService
{
  public static final int TYPE_INIT = 0;
  public static final int TYPE_NEW_MSG = 1;
  public static final int TYPE_REMOVE_MSG = 2;
  
  public abstract void addNewMessage(SubAccountMessage paramSubAccountMessage);
  
  public abstract void cancelHintIsNew(String paramString);
  
  public abstract void clearAllUnNotifySenderNum();
  
  public abstract void clearUnreadNum(String paramString);
  
  public abstract void countUnreadDatum(SubAccountInfo paramSubAccountInfo, ArrayList<SubAccountMessage> paramArrayList, int paramInt);
  
  public abstract AbsSubAccountMessageProcessor createSubAccountMessageProcessor(AppInterface paramAppInterface, BaseMessageHandler paramBaseMessageHandler);
  
  public abstract SubAccountMessage findSubAccountMessage(String paramString1, String paramString2);
  
  public abstract String getA2(String paramString);
  
  public abstract long getActionTime(String paramString);
  
  public abstract List<SubAccountMessage> getAllMessage(String paramString);
  
  public abstract ArrayList<SubAccountInfo> getAllSubAccountInfo();
  
  public abstract ArrayList<String> getAllSubUin();
  
  public abstract int getBindedNumber();
  
  public abstract byte[] getCookie(String paramString);
  
  public abstract CharSequence getLatestMsg(String paramString);
  
  public abstract String getLatestUin(String paramString);
  
  public abstract String getLatestUinNick(String paramString);
  
  public abstract HashMap<String, ArrayList<SubAccountMessage>> getMapSubMsg();
  
  public abstract boolean getNotifySwitch();
  
  public abstract Pair<Integer, String> getServerError(String paramString);
  
  public abstract int getStatus(String paramString);
  
  public abstract SubAccountInfo getSubAccountInfo(String paramString);
  
  public abstract int getUnNotifySenderNum(String paramString);
  
  public abstract int getUnreadAllMsgNum(String paramString);
  
  public abstract int getUnreadAllTroopMsgNum(String paramString);
  
  public abstract int getUnreadSenderNum(String paramString);
  
  public abstract boolean hintIsNew(String paramString);
  
  public abstract boolean isRecentListTop(String paramString);
  
  public abstract boolean isSubAccountUin(String paramString);
  
  public abstract void removeAllMessage();
  
  public abstract void removeAllMessage(String paramString);
  
  public abstract void removeAllSubAccount();
  
  public abstract int removeMessage(String paramString1, String paramString2);
  
  public abstract void removeSubAccountInfo(String paramString);
  
  public abstract void saveSubAccountInfo(SubAccountInfo paramSubAccountInfo);
  
  public abstract void setActionTime(String paramString, long paramLong);
  
  public abstract void setAllMessageReaded(String paramString);
  
  public abstract void setNotifySwitch(boolean paramBoolean);
  
  public abstract void setRecentListTop(String paramString, boolean paramBoolean);
  
  public abstract boolean setStatus(String paramString, int paramInt);
  
  public abstract void updateA2(String paramString1, String paramString2, boolean paramBoolean);
  
  public abstract void updateAnotherSubAccountUnreadMsg(String paramString);
  
  public abstract void updateCookie(String paramString, byte[] paramArrayOfByte);
  
  public abstract void updateMsgData2SupportSubUin(String paramString);
  
  public abstract void updateMsgTimeStr(String paramString);
  
  public abstract void updateNotifySwitch(AppInterface paramAppInterface);
  
  public abstract void updateServerError(String paramString1, int paramInt, String paramString2);
  
  public abstract void updateSubAccountInfo(SubAccountBackProtocData paramSubAccountBackProtocData);
  
  public abstract void updateTroopMsgRedDot(SubAccountMessage paramSubAccountMessage);
  
  public abstract void updateUnreadNum(AppInterface paramAppInterface, String paramString1, String paramString2, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.api.ISubAccountService
 * JD-Core Version:    0.7.0.1
 */