package com.tencent.mobileqq.ptt.temp.api;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IVoice2TxtTmpApi
  extends QRouteApi
{
  public abstract int getCustomTitleViewBottom(BaseAIOContext paramBaseAIOContext);
  
  public abstract PopupWindow getTopMask();
  
  public abstract int getWaveViewLen(Context paramContext, int paramInt1, float paramFloat, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void hideChatPieOtherFunction(BaseAIOContext paramBaseAIOContext);
  
  public abstract void hideSoftInput(BaseAIOContext paramBaseAIOContext);
  
  public abstract void restoreChatPieOtherFunction(BaseAIOContext paramBaseAIOContext);
  
  public abstract void sendTxt(AppRuntime paramAppRuntime, BaseSessionInfo paramBaseSessionInfo, String paramString, Context paramContext);
  
  public abstract void sendVoiceAndTxt(BaseAIOContext paramBaseAIOContext, String paramString, int paramInt1, int paramInt2, RecordParams.RecorderParam paramRecorderParam, int paramInt3, boolean paramBoolean, int paramInt4);
  
  public abstract void setCustomTitleVisiable(BaseAIOContext paramBaseAIOContext, int paramInt);
  
  public abstract void setIsInVoiceTxt(boolean paramBoolean);
  
  public abstract PopupWindow showTopMaskPanel(Context paramContext, int paramInt1, int paramInt2, View paramView, int paramInt3, int paramInt4, int paramInt5);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.temp.api.IVoice2TxtTmpApi
 * JD-Core Version:    0.7.0.1
 */