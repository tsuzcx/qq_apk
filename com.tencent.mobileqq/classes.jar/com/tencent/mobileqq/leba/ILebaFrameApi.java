package com.tencent.mobileqq.leba;

import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;

@QAPI(process={"all"})
public abstract interface ILebaFrameApi
  extends QRouteApi
{
  public abstract Class<? extends Frame> getLebaFrameClass();
  
  public abstract boolean isLeba(String paramString);
  
  public abstract boolean isLebaFrame(Frame paramFrame);
  
  public abstract void onPostThemeChanged(Frame paramFrame);
  
  public abstract void onSwitchToLeba(Frame paramFrame, boolean paramBoolean, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.ILebaFrameApi
 * JD-Core Version:    0.7.0.1
 */