package com.tencent.mobileqq.kandian.biz.comment.ui;

import android.graphics.Color;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.TextBase;
import com.tencent.mobileqq.kandian.biz.comment.CommentProteusUtil;
import com.tencent.mobileqq.kandian.biz.comment.ReadinjoyCommentListBaseAdapter;
import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;

public class CommentContentView
  extends TextBase
{
  private static final int a = Color.parseColor("#262626");
  private static final int b = Utils.dp2px(16.0D);
  private NativeCommentTextView c;
  
  public CommentContentView(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.c = new NativeCommentTextView(paramVafContext.getContext());
  }
  
  public void a(ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, View paramView, int paramInt)
  {
    this.c.setModel(paramReadinjoyCommentListBaseAdapter, paramView, paramInt);
  }
  
  public int getComMeasuredHeight()
  {
    return this.c.getComMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.c.getComMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.c;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.c.comLayout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.c.measureComponent(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    this.c.setTextSize(0, b * CommentProteusUtil.a());
    this.c.setLineSpacing(Utils.rp2px(5.0D), 1.0F);
    this.c.setIncludeFontPadding(false);
    this.c.setTextColor(a);
  }
  
  protected boolean setAttribute(int paramInt, Object paramObject)
  {
    if ((paramInt == 1059) && ((paramObject instanceof CommentViewItem)))
    {
      this.c.setCommentModel((CommentViewItem)paramObject);
      return true;
    }
    return super.setAttribute(paramInt, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ui.CommentContentView
 * JD-Core Version:    0.7.0.1
 */