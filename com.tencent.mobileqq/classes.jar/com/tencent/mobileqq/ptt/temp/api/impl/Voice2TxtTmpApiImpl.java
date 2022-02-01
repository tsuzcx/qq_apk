package com.tencent.mobileqq.ptt.temp.api.impl;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade.SendMsgParams;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelAioHelper;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.activity.aio.helper.ChatDrawerHelper;
import com.tencent.mobileqq.activity.aio.item.PttItemBuilder;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper;
import com.tencent.mobileqq.apollo.aio.api.IApolloAIOHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ptt.temp.api.IVoice2TxtTmpApi;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class Voice2TxtTmpApiImpl
  implements IVoice2TxtTmpApi
{
  public int getCustomTitleViewBottom(BaseAIOContext paramBaseAIOContext)
  {
    return paramBaseAIOContext.N();
  }
  
  public PopupWindow getTopMask()
  {
    return AudioPanel.getTopMask();
  }
  
  public int getWaveViewLen(Context paramContext, int paramInt1, float paramFloat, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    return PttItemBuilder.a(paramContext, paramInt1, paramFloat, paramInt2, paramInt3, paramBoolean1, paramBoolean2);
  }
  
  public void hideChatPieOtherFunction(BaseAIOContext paramBaseAIOContext)
  {
    Object localObject = (ChatDrawerHelper)paramBaseAIOContext.a(124);
    if (localObject != null) {
      ((ChatDrawerHelper)localObject).b(false);
    }
    localObject = (IApolloAIOHelper)paramBaseAIOContext.a(8);
    if (localObject != null) {
      ((IApolloAIOHelper)localObject).showApolloView(false);
    }
    paramBaseAIOContext = (AIOShortcutBarHelper)paramBaseAIOContext.a(52);
    if (paramBaseAIOContext != null) {
      paramBaseAIOContext.d(11);
    }
  }
  
  public void hideSoftInput(BaseAIOContext paramBaseAIOContext)
  {
    paramBaseAIOContext.M();
  }
  
  public void restoreChatPieOtherFunction(BaseAIOContext paramBaseAIOContext)
  {
    Object localObject = (ChatDrawerHelper)paramBaseAIOContext.a(124);
    if (localObject != null) {
      ((ChatDrawerHelper)localObject).b(true);
    }
    localObject = (IApolloAIOHelper)paramBaseAIOContext.a(8);
    if (localObject != null) {
      ((IApolloAIOHelper)localObject).showApolloView(true);
    }
    paramBaseAIOContext = (AIOShortcutBarHelper)paramBaseAIOContext.a(52);
    if (paramBaseAIOContext != null) {
      paramBaseAIOContext.d(12);
    }
  }
  
  public void sendTxt(AppRuntime paramAppRuntime, BaseSessionInfo paramBaseSessionInfo, String paramString, Context paramContext)
  {
    ChatActivityFacade.SendMsgParams localSendMsgParams = new ChatActivityFacade.SendMsgParams();
    ArrayList localArrayList = new ArrayList();
    ChatActivityFacade.a((QQAppInterface)paramAppRuntime, paramContext, paramBaseSessionInfo, paramString, localArrayList, localSendMsgParams);
  }
  
  public void sendVoiceAndTxt(BaseAIOContext paramBaseAIOContext, String paramString, int paramInt1, int paramInt2, RecordParams.RecorderParam paramRecorderParam, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    ((AudioPanelAioHelper)paramBaseAIOContext.a(128)).a(paramString, paramInt1, paramInt2, paramRecorderParam, paramInt3, paramBoolean, paramInt4);
  }
  
  public void setCustomTitleVisiable(BaseAIOContext paramBaseAIOContext, int paramInt)
  {
    paramBaseAIOContext.e(paramInt);
  }
  
  public void setIsInVoiceTxt(boolean paramBoolean)
  {
    com.tencent.mobileqq.activity.aio.item.PttConstants.c = paramBoolean;
  }
  
  public PopupWindow showTopMaskPanel(Context paramContext, int paramInt1, int paramInt2, View paramView, int paramInt3, int paramInt4, int paramInt5)
  {
    return AudioPanel.a(paramContext, paramInt1, paramInt2, paramView, paramInt3, paramInt4, paramInt5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.temp.api.impl.Voice2TxtTmpApiImpl
 * JD-Core Version:    0.7.0.1
 */