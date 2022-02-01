package com.tencent.mobileqq.kandian.biz.comment.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData.CommentLinkData;
import java.util.Iterator;
import java.util.List;

public class CommentLinkViewContainer
  extends LinearLayout
  implements IView
{
  private Context a;
  
  public CommentLinkViewContainer(@NonNull Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
    a();
  }
  
  public CommentLinkViewContainer(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    a();
  }
  
  private void a()
  {
    inflate(this.a, 2131629132, this);
    setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    setOrientation(1);
  }
  
  public void a(CommentViewItem paramCommentViewItem)
  {
    if (paramCommentViewItem != null)
    {
      if (paramCommentViewItem.c == null) {
        return;
      }
      Object localObject = paramCommentViewItem.c.commentLinkDataList;
      if (localObject != null)
      {
        if (((List)localObject).size() == 0) {
          return;
        }
        removeAllViews();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          BaseCommentData.CommentLinkData localCommentLinkData = (BaseCommentData.CommentLinkData)((Iterator)localObject).next();
          if (localCommentLinkData != null)
          {
            CommentLinkItemView localCommentLinkItemView = new CommentLinkItemView(this.a);
            localCommentLinkItemView.a(paramCommentViewItem.d, paramCommentViewItem.c, localCommentLinkData);
            addView(localCommentLinkItemView);
          }
        }
      }
    }
  }
  
  public void comLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    onComLayout(true, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int getComMeasuredHeight()
  {
    if (getVisibility() == 0) {
      return getMeasuredHeight();
    }
    return 0;
  }
  
  public int getComMeasuredWidth()
  {
    if (getVisibility() == 0) {
      return getMeasuredWidth();
    }
    return 0;
  }
  
  public void measureComponent(int paramInt1, int paramInt2)
  {
    onComMeasure(paramInt1, paramInt2);
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    measure(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ui.CommentLinkViewContainer
 * JD-Core Version:    0.7.0.1
 */