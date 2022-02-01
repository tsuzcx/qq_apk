package com.tencent.mobileqq.guild.temp.api.impl;

import android.content.Context;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.oneclickjump.JumpState;
import com.tencent.mobileqq.activity.aio.oneclickjump.JumpStateMachineController;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.guild.chatpie.GuildChatContext;
import com.tencent.mobileqq.guild.chatpie.GuildChatFragment;
import com.tencent.mobileqq.guild.chatpie.GuildChatPie;
import com.tencent.mobileqq.guild.chatpie.GuildChatPieCreator;
import com.tencent.mobileqq.guild.chatpie.GuildInputBarLayoutChangeCallback;
import com.tencent.mobileqq.guild.chatpie.GuildListUI;
import com.tencent.mobileqq.guild.chatpie.GuildLiveChannelChatFragment;
import com.tencent.mobileqq.guild.chatpie.GuildLiveChannelChatPie;
import com.tencent.mobileqq.guild.chatpie.GuildLiveChatPieCreator;
import com.tencent.mobileqq.guild.chatpie.GuildMsgItemBuildFactory;
import com.tencent.mobileqq.guild.chatpie.GuildPieAdapter;
import com.tencent.mobileqq.guild.chatpie.helper.GuildAIOMultiActionHelper;
import com.tencent.mobileqq.guild.chatpie.manager.GuildPngFrameManager;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.GuildMsgItemLayout;
import com.tencent.mobileqq.guild.chatpie.pluspanel.GuildMobaTeamAppInfo;
import com.tencent.mobileqq.guild.chatpie.pluspanel.GuildPlusPanelAppLoader;
import com.tencent.mobileqq.guild.chatpie.quickAt.GuildTextChangeCallback;
import com.tencent.mobileqq.guild.chatpie.sender.GuildMsgSendCallback;
import com.tencent.mobileqq.guild.chatpie.sender.GuildMsgSendListener;
import com.tencent.mobileqq.guild.forward.ForwardMobaTeamArkMsgOption;
import com.tencent.mobileqq.guild.live.QQGuildLiveRoomActivity;
import com.tencent.mobileqq.guild.message.GuildRegisterProxy;
import com.tencent.mobileqq.guild.message.data.GuildGuestMessageProcessorCallback;
import com.tencent.mobileqq.guild.message.data.GuildMessageManagerCallback;
import com.tencent.mobileqq.guild.message.data.GuildOfflineMessageProcessorCallback;
import com.tencent.mobileqq.guild.message.data.GuildPushMessageProcessorCallback;
import com.tencent.mobileqq.guild.message.data.GuildRoamMessageEventFlowProcessorCallback;
import com.tencent.mobileqq.guild.message.data.GuildRoamMessageProcessorCallback;
import com.tencent.mobileqq.guild.message.data.GuildSystemMessageProcessorCallback;
import com.tencent.mobileqq.guild.navigatebar.GuildAioMsgNavigateAtMe;
import com.tencent.mobileqq.guild.navigatebar.GuildAioMsgNavigateBar;
import com.tencent.mobileqq.guild.navigatebar.GuildAioMsgNavigateReply;
import com.tencent.mobileqq.guild.navigatebar.GuildAioMsgNavigateUnRead;
import com.tencent.mobileqq.guild.navigatebar.GuildAioNavigateBarManager;
import com.tencent.mobileqq.guild.navigatebar.GuildMessageNavigateInfo;
import com.tencent.mobileqq.guild.navigatebar.GuildMsgTipsFilter;
import com.tencent.mobileqq.guild.notification.GuildNotificationProcessor;
import com.tencent.mobileqq.guild.open.GuildOpenVerifyFragment;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.guild.vas.GuildGIftController;
import com.tencent.mobileqq.vas.troopgift.TroopGiftData;
import java.util.ArrayList;
import kotlin.jvm.functions.Function0;

public class GuildFeatureAdapterApiImpl
  implements IGuildFeatureAdapterApi
{
  public int getCONTENTVIEW_MAX_WIDTH_SIZE()
  {
    return GuildMsgItemLayout.o;
  }
  
  public Class getForwardMobaTeamArkMsgOptionClass()
  {
    return ForwardMobaTeamArkMsgOption.class;
  }
  
  public Class getGuildAioNavigateBarManagerClass()
  {
    return GuildAioNavigateBarManager.class;
  }
  
  public String getGuildChatContextGuildId(Object paramObject)
  {
    return ((GuildChatContext)((GuildChatPie)paramObject).bv()).S();
  }
  
  public String getGuildChatFragmentClassName()
  {
    return GuildChatFragment.class.getName();
  }
  
  public Class getGuildChatPieClass()
  {
    return GuildChatPie.class;
  }
  
  public Object getGuildListUIJumpStateController(Object paramObject)
  {
    return ((GuildListUI)paramObject).a();
  }
  
  public String getGuildLiveChannelChatFragmentClassName()
  {
    return GuildLiveChannelChatFragment.class.getName();
  }
  
  public Class getGuildMessageNavigateInfoClass()
  {
    return GuildMessageNavigateInfo.class;
  }
  
  public Class getGuildNotificationProcessorClass()
  {
    return GuildNotificationProcessor.class;
  }
  
  public Class getGuildOpenVerifyFragmentClass()
  {
    return GuildOpenVerifyFragment.class;
  }
  
  public Object getGuildPieAdapterCallback(ChatMessage paramChatMessage, Object paramObject)
  {
    paramObject = (GuildPieAdapter)paramObject;
    return paramObject.r.a(paramChatMessage, paramObject);
  }
  
  public Class getGuildPlusPanelAppLoaderClass()
  {
    return GuildPlusPanelAppLoader.class;
  }
  
  public Class getGuildPngFrameManagerClass()
  {
    return GuildPngFrameManager.class;
  }
  
  public Class getGuildRegisterProxyClass()
  {
    return GuildRegisterProxy.class;
  }
  
  public JumpState getJumpLastStateFromGuildListUI(Object paramObject)
  {
    return ((GuildListUI)paramObject).a().b();
  }
  
  public JumpState getJumpStateFromGuildListUI(Object paramObject)
  {
    return ((GuildListUI)paramObject).a().a();
  }
  
  public Object getNewGuildAioMsgNavigateAtMe(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    return new GuildAioMsgNavigateAtMe((QQAppInterface)paramObject1, (Context)paramObject2, (BaseSessionInfo)paramObject3);
  }
  
  public Object getNewGuildAioMsgNavigateReply(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    return new GuildAioMsgNavigateReply((QQAppInterface)paramObject1, (Context)paramObject2, (BaseSessionInfo)paramObject3);
  }
  
  public Object getNewGuildAioMsgNavigateUnRead(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    return new GuildAioMsgNavigateUnRead((QQAppInterface)paramObject1, (Context)paramObject2, (BaseSessionInfo)paramObject3);
  }
  
  public Object getNewGuildChatPieCreator()
  {
    return new GuildChatPieCreator();
  }
  
  public Object getNewGuildGIftController(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    return new GuildGIftController((TroopGiftData)paramObject1, (Function0)paramObject2, (BaseActivity)paramObject3);
  }
  
  public Object getNewGuildGuestMessageProcessorCallback()
  {
    return new GuildGuestMessageProcessorCallback();
  }
  
  public Object getNewGuildInputBarLayoutChangeCallback()
  {
    return new GuildInputBarLayoutChangeCallback();
  }
  
  public Object getNewGuildLiveChatPieCreator()
  {
    return new GuildLiveChatPieCreator();
  }
  
  public Object getNewGuildMessageManagerCallback()
  {
    return new GuildMessageManagerCallback();
  }
  
  public Object getNewGuildMobaTeamAppInfo()
  {
    return new GuildMobaTeamAppInfo();
  }
  
  public Object getNewGuildMsgSendCallback()
  {
    return new GuildMsgSendCallback();
  }
  
  public Object getNewGuildMsgSendListener()
  {
    return new GuildMsgSendListener();
  }
  
  public Object getNewGuildMsgTipsFilter()
  {
    return new GuildMsgTipsFilter();
  }
  
  public Object getNewGuildOfflineMessageProcessorCallback()
  {
    return new GuildOfflineMessageProcessorCallback();
  }
  
  public Object getNewGuildPushMessageProcessorCallback()
  {
    return new GuildPushMessageProcessorCallback();
  }
  
  public Object getNewGuildRoamMessageEventFlowProcessorCallback()
  {
    return new GuildRoamMessageEventFlowProcessorCallback();
  }
  
  public Object getNewGuildRoamMessageProcessorCallback()
  {
    return new GuildRoamMessageProcessorCallback();
  }
  
  public Object getNewGuildSystemMessageProcessorCallback()
  {
    return new GuildSystemMessageProcessorCallback();
  }
  
  public Object getNewGuildTextChangeCallback()
  {
    return new GuildTextChangeCallback();
  }
  
  public String getQQGuildLiveRoomActivityClassName()
  {
    return QQGuildLiveRoomActivity.class.getName();
  }
  
  public void guildAIOMultiActionHelperPullNickName(Object paramObject, String paramString, ArrayList<String> paramArrayList)
  {
    ((GuildAIOMultiActionHelper)((BaseChatPie)paramObject).q(147)).a(paramString, paramArrayList);
  }
  
  public void guildChatFragmentNotifyHiddenChanged(Object paramObject, boolean paramBoolean, int paramInt)
  {
    ((GuildChatFragment)paramObject).a(paramBoolean, paramInt);
  }
  
  public void guildListUISetStateGrayTipClick(Object paramObject)
  {
    ((GuildListUI)((GuildChatPie)paramObject).bv().e().b()).a().a(JumpState.GRAY_TIP_CLICK);
  }
  
  public boolean judgeAdapterIsGuildPieAdapter(Object paramObject)
  {
    return paramObject instanceof GuildPieAdapter;
  }
  
  public boolean judgeBaseChatPieIsGuildChatPie(Object paramObject)
  {
    return paramObject instanceof GuildChatPie;
  }
  
  public boolean judgeGuildChatContextIsGuest(Object paramObject)
  {
    return ((GuildChatContext)((GuildChatPie)paramObject).bv()).Y();
  }
  
  public boolean judgeGuildChatContextIsHomePageChannel(Object paramObject)
  {
    return ((GuildChatContext)paramObject).W();
  }
  
  public boolean judgeGuildListUIJumpStateMachineControllerIsNotNull(Object paramObject)
  {
    return ((GuildListUI)paramObject).a() != null;
  }
  
  public boolean judgeIsGuildAioMsgNavigateBar(Object paramObject)
  {
    return paramObject instanceof GuildAioMsgNavigateBar;
  }
  
  public boolean judgeIsGuildChatContext(Object paramObject)
  {
    return paramObject instanceof GuildChatContext;
  }
  
  public boolean judgeIsGuildChatFragment(Object paramObject)
  {
    return paramObject instanceof GuildChatFragment;
  }
  
  public boolean judgeIsGuildLiveChannelChatPie(Object paramObject)
  {
    return paramObject instanceof GuildLiveChannelChatPie;
  }
  
  public boolean judgeIsInGuildChatFragment(Object paramObject)
  {
    return ((GuildChatContext)paramObject).af();
  }
  
  public boolean judgeIsQQGuildLiveRoomActivity()
  {
    return BaseActivity.sTopActivity instanceof QQGuildLiveRoomActivity;
  }
  
  public boolean judgeListUiIsGuildListUI(Object paramObject)
  {
    return paramObject instanceof GuildListUI;
  }
  
  public void setGuildListUIJumpStateEND(Object paramObject)
  {
    ((GuildListUI)paramObject).a().a(JumpState.END);
  }
  
  public void setGuildListUIJumpStateINACTIVATED(Object paramObject)
  {
    ((GuildListUI)paramObject).a().a(JumpState.INACTIVATED);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.temp.api.impl.GuildFeatureAdapterApiImpl
 * JD-Core Version:    0.7.0.1
 */