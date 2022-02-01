package com.tencent.mobileqq.kandian.biz.comment.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.mobileqq.kandian.biz.comment.CommentProteusUtil;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentListAdapter;
import com.tencent.mobileqq.kandian.biz.comment.ReadinjoyCommentListBaseAdapter;
import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyYAFolderTextView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class NativeCommentTextView
  extends ReadInJoyYAFolderTextView
  implements View.OnClickListener, View.OnLongClickListener, IView
{
  private CommentViewItem d;
  private Context e;
  private ReadinjoyCommentListBaseAdapter f;
  private View g;
  private ColorDrawable h;
  private int i = -1;
  
  public NativeCommentTextView(Context paramContext)
  {
    super(paramContext);
    this.e = paramContext;
  }
  
  public NativeCommentTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.e = paramContext;
  }
  
  private void a(View paramView)
  {
    this.h.setAlpha(0);
    paramView.setBackgroundDrawable(this.h);
  }
  
  private void b()
  {
    QLog.d("NativeCommentTextView", 2, "showAnchorAniation");
    Object localObject = this.d;
    if (localObject != null)
    {
      if (((CommentViewItem)localObject).c == null) {
        return;
      }
      if (!this.d.c.isAnchor) {
        return;
      }
      if (this.h == null) {
        this.h = new ColorDrawable(-15550475);
      }
      localObject = this.g;
      if (localObject == null) {
        return;
      }
      QLog.d("NativeCommentTextView", 2, "showAnchorAniation start");
      this.d.c.isAnchor = false;
      ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 26, 0, 26, 0 });
      localValueAnimator.setDuration(2400L);
      localValueAnimator.setStartDelay(600L);
      localValueAnimator.addUpdateListener(new NativeCommentTextView.1(this, (View)localObject));
      localValueAnimator.start();
    }
  }
  
  public void comLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    onComLayout(true, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int getComMeasuredHeight()
  {
    return getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return getMeasuredWidth();
  }
  
  public void measureComponent(int paramInt1, int paramInt2)
  {
    onComMeasure(paramInt1, paramInt2);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    b();
  }
  
  public void onClick(View paramView)
  {
    paramView = this.f;
    if (paramView == null) {
      return;
    }
    int j = this.i;
    if (j == -1)
    {
      setBackgroundResource(2130851361);
      this.f.a(this.d);
      return;
    }
    paramView = (ReadInJoyCommentListAdapter)paramView;
    CommentViewItem localCommentViewItem = this.d;
    paramView.a(localCommentViewItem, CommentProteusUtil.a(localCommentViewItem, j), 2);
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    measure(paramInt1, paramInt2);
  }
  
  public boolean onLongClick(View paramView)
  {
    if ((this.e != null) && (this.f != null))
    {
      if (this.i == -1)
      {
        setBackgroundColor(Color.parseColor("#EDEDED"));
        paramView = this.f;
        paramView.a(paramView.n(), this, this.d, new NativeCommentTextView.2(this));
      }
      return true;
    }
    return false;
  }
  
  public void setCommentModel(CommentViewItem paramCommentViewItem)
  {
    this.d = paramCommentViewItem;
    paramCommentViewItem = this.d;
    if (paramCommentViewItem != null)
    {
      if (paramCommentViewItem.c == null) {
        return;
      }
      setShouldCallClick(true);
      setMaxLines(100);
      setText(this.d.e);
      setSpanText("");
      setOnClickListener(this);
      setOnLongClickListener(this);
      b();
    }
  }
  
  public void setModel(ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, View paramView)
  {
    if ((paramView != null) && (this.e != null))
    {
      if (paramReadinjoyCommentListBaseAdapter == null) {
        return;
      }
      this.f = paramReadinjoyCommentListBaseAdapter;
      this.g = paramView;
      b();
    }
  }
  
  public void setModel(ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, View paramView, int paramInt)
  {
    if ((paramView != null) && (this.e != null))
    {
      if (paramReadinjoyCommentListBaseAdapter == null) {
        return;
      }
      this.i = paramInt;
      CommentViewItem localCommentViewItem = this.d;
      if ((localCommentViewItem != null) && (localCommentViewItem.i != null) && (this.d.i.size() > paramInt)) {
        setText((CharSequence)this.d.i.get(paramInt));
      }
      this.f = paramReadinjoyCommentListBaseAdapter;
      this.g = paramView;
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ui.NativeCommentTextView
 * JD-Core Version:    0.7.0.1
 */