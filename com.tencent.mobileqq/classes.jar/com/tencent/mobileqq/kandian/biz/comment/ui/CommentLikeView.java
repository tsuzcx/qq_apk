package com.tencent.mobileqq.kandian.biz.comment.ui;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;

public class CommentLikeView
  extends ViewBase
{
  private ReadInJoyCommentLikeView a;
  
  public CommentLikeView(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.a = new ReadInJoyCommentLikeView(paramVafContext.getContext());
  }
  
  public void a(ReadInJoyCommentLikeView.OnLikeStateChangeLinstener paramOnLikeStateChangeLinstener)
  {
    this.a.setOnLikeListener(paramOnLikeStateChangeLinstener);
  }
  
  public int getComMeasuredHeight()
  {
    return this.a.getComMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.a.getComMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.a;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.comLayout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.a.measureComponent(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    this.a.setVisibility(0);
  }
  
  protected boolean setAttribute(int paramInt, Object paramObject)
  {
    if (paramInt != 1059) {
      return super.setAttribute(paramInt, paramObject);
    }
    if ((paramObject instanceof CommentViewItem))
    {
      paramObject = (CommentViewItem)paramObject;
      if (paramObject.c != null) {
        this.a.a(paramObject.c);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ui.CommentLikeView
 * JD-Core Version:    0.7.0.1
 */