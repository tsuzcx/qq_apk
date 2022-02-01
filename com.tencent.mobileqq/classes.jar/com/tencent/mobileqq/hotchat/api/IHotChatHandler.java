package com.tencent.mobileqq.hotchat.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import java.util.List;

@QAPI(process={"all"})
public abstract interface IHotChatHandler
  extends QRouteApi
{
  public static final int KICK_MEM_ENTRANCE_AIO = 1;
  public static final int KICK_MEM_ENTRANCE_MEM_LIST = 2;
  
  public abstract void closeHotChatPie(String paramString);
  
  public abstract void deleteMember(String paramString1, String paramString2, String paramString3);
  
  public abstract void exitHotChat(IHotChatInfo paramIHotChatInfo, IHotChatStateWrapper paramIHotChatStateWrapper);
  
  public abstract void getGlobalAdmin(long paramLong, String paramString);
  
  public abstract boolean getHotChatAnnounce(byte[] paramArrayOfByte, String paramString);
  
  public abstract void getMyHotChatList();
  
  public abstract void getMyHotChatList(int paramInt);
  
  public abstract void getUinByTinyId(ArrayList<String> paramArrayList);
  
  public abstract boolean getUserCreateHotChatAnnounce(String paramString);
  
  public abstract void insertAtTroopMem(String paramString1, String paramString2, String paramString3);
  
  public abstract void joinHotChat(Object paramObject, boolean paramBoolean, int paramInt1, int paramInt2);
  
  public abstract boolean kickHotChatMember(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt);
  
  public abstract void notifyUI(int paramInt, boolean paramBoolean, Object paramObject);
  
  public abstract void openHotChatMemberProfileCard(String paramString1, String paramString2);
  
  public abstract boolean quickJoinHotChat(String paramString, int paramInt, boolean paramBoolean);
  
  public abstract boolean quickJoinHotChat(String paramString, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3);
  
  public abstract void sendGiftToPerson(String paramString1, String paramString2);
  
  public abstract void setHotChatAdminFlag(AppInterface paramAppInterface, String paramString, List<Long> paramList, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.api.IHotChatHandler
 * JD-Core Version:    0.7.0.1
 */