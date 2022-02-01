package com.tencent.tkd.comment.publisher.qq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.tkd.comment.publisher.qq.bridge.QQUrlImageBridge;
import com.tencent.tkd.comment.publisher.qq.model.TkdCommentLinkData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TkdCommentLinkView
  extends LinearLayout
{
  private List<TkdCommentLinkData> data;
  private TkdCommentLinkView.OnLinkDeleteLinstener linkDeleteLinstener;
  public QQUrlImageBridge urlImageBridge;
  
  public TkdCommentLinkView(Context paramContext)
  {
    super(paramContext);
  }
  
  public TkdCommentLinkView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TkdCommentLinkView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void addData(TkdCommentLinkData paramTkdCommentLinkData)
  {
    if (this.data == null) {
      this.data = new ArrayList();
    }
    this.data.add(paramTkdCommentLinkData);
    new TkdCommentLinkView.Holder(this, paramTkdCommentLinkData);
  }
  
  public List<TkdCommentLinkData> getData()
  {
    List localList = this.data;
    if (localList == null) {
      return Collections.emptyList();
    }
    return Collections.unmodifiableList(localList);
  }
  
  public void setLinkDeleteLinstener(TkdCommentLinkView.OnLinkDeleteLinstener paramOnLinkDeleteLinstener)
  {
    this.linkDeleteLinstener = paramOnLinkDeleteLinstener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.comment.publisher.qq.widget.TkdCommentLinkView
 * JD-Core Version:    0.7.0.1
 */