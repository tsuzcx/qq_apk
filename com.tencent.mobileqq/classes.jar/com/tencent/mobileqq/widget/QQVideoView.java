package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

public class QQVideoView
  extends VideoView
{
  private int mHeight;
  private int mWidth;
  
  public QQVideoView(Context paramContext)
  {
    super(paramContext);
  }
  
  public QQVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QQVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(this.mWidth, this.mHeight);
  }
  
  public void release()
  {
    setOnPreparedListener(null);
    setOnErrorListener(null);
    setOnCompletionListener(null);
  }
  
  public void setDimension(int paramInt1, int paramInt2)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQVideoView
 * JD-Core Version:    0.7.0.1
 */