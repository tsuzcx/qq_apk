package com.tencent.mobileqq.ecshop.temp.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

@QAPI(process={"all"})
public abstract interface IEcshopMessageApi
  extends QRouteApi
{
  public abstract void GdtC2SReportArkMsg(MessageRecord paramMessageRecord);
  
  public abstract void GdtC2SReportStructMsg(MessageRecord paramMessageRecord);
  
  public abstract ChatMessage buildMessageForArkApp(String paramString);
  
  public abstract void doArkAppContainerOnEvent(MessageRecord paramMessageRecord, int paramInt);
  
  @Nullable
  public abstract qq_ad_get.QQAdGetRsp.AdInfo getAdInfoByChatMessage(@Nullable MessageRecord paramMessageRecord);
  
  @Nullable
  public abstract String getArkMsgMetaList(MessageRecord paramMessageRecord);
  
  public abstract String getArkMsgMsg(MessageRecord paramMessageRecord);
  
  public abstract boolean getArkMsgReportClick(MessageRecord paramMessageRecord);
  
  @Nullable
  public abstract String getArkMsgSourceAd(MessageRecord paramMessageRecord);
  
  @NonNull
  public abstract String getDisType(@Nullable MessageRecord paramMessageRecord);
  
  public abstract ChatMessage getLastAmsMessage(List<ChatMessage> paramList);
  
  public abstract String getLastMsgQggExt(MessageRecord paramMessageRecord);
  
  public abstract String getLastMsgType(MessageRecord paramMessageRecord);
  
  @NonNull
  public abstract String getMessageImageUrl(MessageRecord paramMessageRecord);
  
  @NonNull
  public abstract String getMessageLandingUrl(MessageRecord paramMessageRecord);
  
  @NonNull
  public abstract String getMessageTitleText(MessageRecord paramMessageRecord);
  
  @Nullable
  public abstract String getSourceAd(MessageRecord paramMessageRecord);
  
  @Nullable
  public abstract JSONObject getSourceAdFromArk(MessageRecord paramMessageRecord);
  
  @Nullable
  public abstract String getStructMsgContentTitle(MessageRecord paramMessageRecord);
  
  @Nullable
  public abstract String getStructMsgGdtAid(MessageRecord paramMessageRecord);
  
  @Nullable
  public abstract String getStructMsgReportClick(MessageRecord paramMessageRecord);
  
  @Nullable
  public abstract String getStuctMsgAdInfo(MessageRecord paramMessageRecord);
  
  public abstract boolean isArkAppMessageValid(ChatMessage paramChatMessage);
  
  public abstract boolean isMessageForArkApp(MessageRecord paramMessageRecord);
  
  public abstract boolean isMessageForStructing(MessageRecord paramMessageRecord);
  
  public abstract void preloadEcshopAd(BaseQQAppInterface paramBaseQQAppInterface, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.temp.api.IEcshopMessageApi
 * JD-Core Version:    0.7.0.1
 */