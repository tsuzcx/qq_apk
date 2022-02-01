package com.tencent.mobileqq.qqexpand.widget;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.confess.ConfessShareHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ExtendFriendMultiLinesTagsView
  extends ViewGroup
  implements View.OnClickListener
{
  public int a = 30;
  public int b = 30;
  public ExtendFriendMultiLinesTagsView.OnItemClickListener c;
  
  public ExtendFriendMultiLinesTagsView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ExtendFriendMultiLinesTagsView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ExtendFriendMultiLinesTagsView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof ExtendFriendMultiLinesTagsView.TagInfo))
    {
      paramView = (ExtendFriendMultiLinesTagsView.TagInfo)paramView.getTag();
      ExtendFriendMultiLinesTagsView.OnItemClickListener localOnItemClickListener = this.c;
      if (localOnItemClickListener != null) {
        localOnItemClickListener.a(paramView.b, paramView.a);
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = paramInt3 - paramInt1;
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onLayout changed:");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" left:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" top:");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(" right:");
      ((StringBuilder)localObject).append(paramInt3);
      ((StringBuilder)localObject).append(" bottom:");
      ((StringBuilder)localObject).append(paramInt4);
      ((StringBuilder)localObject).append(" w:");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(" h:");
      ((StringBuilder)localObject).append(paramInt4 - paramInt2);
      QLog.d("ExtendFriendMultiLinesTagsView", 2, ((StringBuilder)localObject).toString());
    }
    int k = getChildCount();
    paramInt1 = getPaddingLeft();
    paramInt3 = getPaddingTop();
    paramInt2 = 0;
    while (paramInt2 < k)
    {
      localObject = getChildAt(paramInt2);
      int m = ((View)localObject).getMeasuredWidth();
      int n = ((View)localObject).getMeasuredHeight();
      int i = paramInt1;
      paramInt4 = paramInt3;
      if (paramInt1 + m > j - getPaddingRight())
      {
        i = getPaddingLeft();
        paramInt4 = paramInt3 + (this.a + n);
      }
      ((View)localObject).layout(i, paramInt4, i + m, n + paramInt4);
      paramInt1 = i + (this.a + m);
      paramInt2 += 1;
      paramInt3 = paramInt4;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int m = getDefaultSize(getSuggestedMinimumWidth(), paramInt1);
    int j = getPaddingTop();
    paramInt1 = getPaddingLeft();
    int i = getPaddingTop();
    int n = getChildCount();
    paramInt2 = 0;
    int k = j;
    Object localObject;
    while (paramInt2 < n)
    {
      localObject = getChildAt(paramInt2);
      ViewGroup.LayoutParams localLayoutParams = ((View)localObject).getLayoutParams();
      if (localLayoutParams.height > 0) {
        ((View)localObject).measure(0, View.MeasureSpec.makeMeasureSpec(Math.max(0, localLayoutParams.height), 1073741824));
      } else {
        ((View)localObject).measure(0, 0);
      }
      int i2 = ((View)localObject).getMeasuredWidth();
      int i1 = ((View)localObject).getMeasuredHeight();
      k = paramInt1;
      j = i;
      if (paramInt1 + i2 > m - getPaddingRight())
      {
        k = getPaddingLeft();
        j = i + (this.a + i1);
      }
      paramInt1 = k + (this.a + i2);
      k = i1 + j;
      paramInt2 += 1;
      i = j;
    }
    paramInt1 = k + getPaddingBottom();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onMeasure  measuredWidth:");
      ((StringBuilder)localObject).append(m);
      ((StringBuilder)localObject).append("  measuredHeight:");
      ((StringBuilder)localObject).append(paramInt1);
      QLog.d("ExtendFriendMultiLinesTagsView", 2, ((StringBuilder)localObject).toString());
    }
    setMeasuredDimension(m, paramInt1);
  }
  
  public void setOnItemClickListener(ExtendFriendMultiLinesTagsView.OnItemClickListener paramOnItemClickListener)
  {
    this.c = paramOnItemClickListener;
  }
  
  public void setSearchTags(ArrayList<String> paramArrayList)
  {
    if (getChildCount() > 0) {
      removeAllViews();
    }
    if (paramArrayList != null)
    {
      if (paramArrayList.isEmpty()) {
        return;
      }
      int j = AIOUtils.b(13.0F, getResources());
      int k = AIOUtils.b(26.0F, getResources());
      int i = 0;
      while (i < paramArrayList.size())
      {
        String str = (String)paramArrayList.get(i);
        if (!TextUtils.isEmpty(str))
        {
          TextView localTextView = new TextView(getContext());
          localTextView.setText(ConfessShareHelper.a(str, 8.5F));
          localTextView.setTag(new ExtendFriendMultiLinesTagsView.TagInfo(this, i, str));
          localTextView.setContentDescription(str);
          localTextView.setOnClickListener(this);
          localTextView.setTextSize(1, 14.0F);
          localTextView.setIncludeFontPadding(false);
          localTextView.setGravity(17);
          localTextView.setClickable(true);
          localTextView.setFocusable(true);
          localTextView.setPadding(j, 0, j, 0);
          localTextView.setBackgroundResource(2130846625);
          localTextView.setTextColor(getResources().getColorStateList(2131167223));
          localTextView.setEllipsize(TextUtils.TruncateAt.END);
          localTextView.setSingleLine();
          localTextView.setMaxLines(1);
          addView(localTextView, new ViewGroup.LayoutParams(-2, k));
        }
        i += 1;
      }
      requestLayout();
    }
  }
  
  public void setViewMargin(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.ExtendFriendMultiLinesTagsView
 * JD-Core Version:    0.7.0.1
 */