package com.tencent.tkd.comment.publisher.qq.util;

import android.graphics.drawable.Drawable;
import com.tencent.tkd.comment.publisher.qq.model.TkdCommentLinkData;
import java.util.List;

public abstract interface QQViewCallback
{
  public abstract List<TkdCommentLinkData> getCommentLinkData();
  
  public abstract void onAddGif(Drawable paramDrawable);
  
  public abstract void onAddLink(TkdCommentLinkData paramTkdCommentLinkData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.comment.publisher.qq.util.QQViewCallback
 * JD-Core Version:    0.7.0.1
 */