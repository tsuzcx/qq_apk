package com.tencent.mobileqq.leba.impl;

import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.leba.ILebaFrameApi;
import com.tencent.mobileqq.leba.Leba;
import com.tencent.mobileqq.leba.feed.LebaFeedUtil;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;

public class LebaFrameApiImpl
  implements ILebaFrameApi
{
  public Class<? extends Frame> getLebaFrameClass()
  {
    return Leba.class;
  }
  
  public boolean isLeba(String paramString)
  {
    return paramString.equals(Leba.class.getName());
  }
  
  public boolean isLebaFrame(Frame paramFrame)
  {
    return paramFrame instanceof Leba;
  }
  
  public void onPostThemeChanged(Frame paramFrame)
  {
    if ((paramFrame != null) && ((paramFrame instanceof Leba))) {
      ((Leba)paramFrame).q();
    }
  }
  
  public void onSwitchToLeba(Frame paramFrame, boolean paramBoolean, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    if ((paramFrame != null) && ((paramFrame instanceof Leba))) {
      ((Leba)paramFrame).a(paramBoolean, paramRedTypeInfo);
    }
  }
  
  public void showLebaFrame()
  {
    LebaFeedUtil.a(false);
  }
  
  public void showQzoneFrame()
  {
    LebaFeedUtil.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.impl.LebaFrameApiImpl
 * JD-Core Version:    0.7.0.1
 */