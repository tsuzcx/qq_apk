package com.tencent.mobileqq.richmediabrowser.api;

import android.content.Context;
import android.widget.TextView;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ICommentDanmakuDepend
  extends QRouteApi
{
  public abstract TextView createETTextView(Context paramContext, String paramString, int paramInt1, int paramInt2, float paramFloat);
  
  public abstract boolean getAioAnonymousStatus(String paramString);
  
  public abstract int getAnonymousHeadId(String paramString);
  
  public abstract String getAnonymousHeadUrl(int paramInt);
  
  public abstract String getAnonymousNickName(String paramString);
  
  public abstract int getChatEmotionSizeWithDP();
  
  public abstract String getTroopMemberName(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.api.ICommentDanmakuDepend
 * JD-Core Version:    0.7.0.1
 */