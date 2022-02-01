package com.tencent.mobileqq.guild.temp.api;

import com.tencent.mobileqq.activity.aio.oneclickjump.JumpState;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;

@QAPI(process={"all"})
public abstract interface IGuildFeatureAdapterApi
  extends QRouteApi
{
  public abstract int getCONTENTVIEW_MAX_WIDTH_SIZE();
  
  public abstract Class getForwardMobaTeamArkMsgOptionClass();
  
  public abstract Class getGuildAioNavigateBarManagerClass();
  
  public abstract String getGuildChatContextGuildId(Object paramObject);
  
  public abstract String getGuildChatFragmentClassName();
  
  public abstract Class getGuildChatPieClass();
  
  public abstract Object getGuildListUIJumpStateController(Object paramObject);
  
  public abstract String getGuildLiveChannelChatFragmentClassName();
  
  public abstract Class getGuildMessageNavigateInfoClass();
  
  public abstract Class getGuildNotificationProcessorClass();
  
  public abstract Class getGuildOpenVerifyFragmentClass();
  
  public abstract Object getGuildPieAdapterCallback(ChatMessage paramChatMessage, Object paramObject);
  
  public abstract Class getGuildPlusPanelAppLoaderClass();
  
  public abstract Class getGuildPngFrameManagerClass();
  
  public abstract Class getGuildRegisterProxyClass();
  
  public abstract JumpState getJumpLastStateFromGuildListUI(Object paramObject);
  
  public abstract JumpState getJumpStateFromGuildListUI(Object paramObject);
  
  public abstract Object getNewGuildAioMsgNavigateAtMe(Object paramObject1, Object paramObject2, Object paramObject3);
  
  public abstract Object getNewGuildAioMsgNavigateReply(Object paramObject1, Object paramObject2, Object paramObject3);
  
  public abstract Object getNewGuildAioMsgNavigateUnRead(Object paramObject1, Object paramObject2, Object paramObject3);
  
  public abstract Object getNewGuildChatPieCreator();
  
  public abstract Object getNewGuildGIftController(Object paramObject1, Object paramObject2, Object paramObject3);
  
  public abstract Object getNewGuildGuestMessageProcessorCallback();
  
  public abstract Object getNewGuildInputBarLayoutChangeCallback();
  
  public abstract Object getNewGuildLiveChatPieCreator();
  
  public abstract Object getNewGuildMessageManagerCallback();
  
  public abstract Object getNewGuildMobaTeamAppInfo();
  
  public abstract Object getNewGuildMsgSendCallback();
  
  public abstract Object getNewGuildMsgSendListener();
  
  public abstract Object getNewGuildMsgTipsFilter();
  
  public abstract Object getNewGuildOfflineMessageProcessorCallback();
  
  public abstract Object getNewGuildPushMessageProcessorCallback();
  
  public abstract Object getNewGuildRoamMessageEventFlowProcessorCallback();
  
  public abstract Object getNewGuildRoamMessageProcessorCallback();
  
  public abstract Object getNewGuildSystemMessageProcessorCallback();
  
  public abstract Object getNewGuildTextChangeCallback();
  
  public abstract String getQQGuildLiveRoomActivityClassName();
  
  public abstract void guildAIOMultiActionHelperPullNickName(Object paramObject, String paramString, ArrayList<String> paramArrayList);
  
  public abstract void guildChatFragmentNotifyHiddenChanged(Object paramObject, boolean paramBoolean, int paramInt);
  
  public abstract void guildListUISetStateGrayTipClick(Object paramObject);
  
  public abstract boolean judgeAdapterIsGuildPieAdapter(Object paramObject);
  
  public abstract boolean judgeBaseChatPieIsGuildChatPie(Object paramObject);
  
  public abstract boolean judgeGuildChatContextIsGuest(Object paramObject);
  
  public abstract boolean judgeGuildChatContextIsHomePageChannel(Object paramObject);
  
  public abstract boolean judgeGuildListUIJumpStateMachineControllerIsNotNull(Object paramObject);
  
  public abstract boolean judgeIsGuildAioMsgNavigateBar(Object paramObject);
  
  public abstract boolean judgeIsGuildChatContext(Object paramObject);
  
  public abstract boolean judgeIsGuildChatFragment(Object paramObject);
  
  public abstract boolean judgeIsGuildLiveChannelChatPie(Object paramObject);
  
  public abstract boolean judgeIsInGuildChatFragment(Object paramObject);
  
  public abstract boolean judgeIsQQGuildLiveRoomActivity();
  
  public abstract boolean judgeListUiIsGuildListUI(Object paramObject);
  
  public abstract void setGuildListUIJumpStateEND(Object paramObject);
  
  public abstract void setGuildListUIJumpStateINACTIVATED(Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi
 * JD-Core Version:    0.7.0.1
 */