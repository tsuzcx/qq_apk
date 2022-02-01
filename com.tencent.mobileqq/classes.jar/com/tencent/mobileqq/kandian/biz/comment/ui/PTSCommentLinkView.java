package com.tencent.mobileqq.kandian.biz.comment.ui;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;

public class PTSCommentLinkView
  extends ViewBase
{
  private CommentLinkViewContainer a;
  
  public PTSCommentLinkView(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.a = new CommentLinkViewContainer(paramVafContext.getContext());
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
    this.a.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.a.measure(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
  }
  
  protected boolean setAttribute(int paramInt, Object paramObject)
  {
    if ((paramInt == 1059) && ((paramObject instanceof CommentViewItem)))
    {
      CommentViewItem localCommentViewItem = (CommentViewItem)paramObject;
      if (localCommentViewItem.c != null) {
        this.a.a(localCommentViewItem);
      }
    }
    return super.setAttribute(paramInt, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ui.PTSCommentLinkView
 * JD-Core Version:    0.7.0.1
 */