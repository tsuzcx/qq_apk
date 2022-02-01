package com.tencent.tkd.comment.publisher.qq.bridge;

import android.text.Editable;
import com.tencent.tkd.comment.publisher.qq.model.TkdCommentLinkData;
import java.util.List;

public abstract interface QQReportBridge
{
  public static final QQReportBridge EMPTY = new QQReportBridge.1();
  
  public abstract void reportCommentCancelEvent();
  
  public abstract void reportDeleteGif();
  
  public abstract void reportDeleteLink();
  
  public abstract void reportDeliver(Editable paramEditable, List<TkdCommentLinkData> paramList);
  
  public abstract void reportOpenCommentComponent(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void reportOpenEmotionPanel();
  
  public abstract void reportOpenGifPanel();
  
  public abstract void reportOpenLink();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.comment.publisher.qq.bridge.QQReportBridge
 * JD-Core Version:    0.7.0.1
 */