package com.tencent.mobileqq.studyroom.webview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.biz.ui.TouchWebView;

public class StudyRoomWebView
  extends TouchWebView
{
  public StudyRoomWebView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public StudyRoomWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public View getCurrentView()
  {
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.webview.StudyRoomWebView
 * JD-Core Version:    0.7.0.1
 */