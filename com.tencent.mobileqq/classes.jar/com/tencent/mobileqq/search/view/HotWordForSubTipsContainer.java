package com.tencent.mobileqq.search.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.kandian.biz.search.ReadInJoySearchTipsContainer;
import com.tencent.mobileqq.search.model.BusinessGroupWord.HotWordItem;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.Iterator;
import java.util.List;

public class HotWordForSubTipsContainer
  extends ReadInJoySearchTipsContainer
{
  private int b = 5;
  
  public HotWordForSubTipsContainer(Context paramContext)
  {
    super(paramContext);
  }
  
  public HotWordForSubTipsContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    if ((paramString1 != null) && (TextUtils.isEmpty(paramString1.trim()))) {
      return;
    }
    Button localButton = new Button(getContext());
    if (paramInt1 == 0) {
      localButton.setBackgroundResource(2130851475);
    } else {
      localButton.setBackgroundResource(paramInt1);
    }
    GradientDrawable localGradientDrawable = (GradientDrawable)((android.graphics.drawable.DrawableContainer.DrawableContainerState)((android.graphics.drawable.StateListDrawable)localButton.getBackground()).getConstantState()).getChildren()[1];
    if (paramInt3 == 0) {
      paramInt3 = -3355444;
    }
    localGradientDrawable.setStroke(1, paramInt3);
    localButton.setPadding(ViewUtils.dip2px(12.0F), ViewUtils.dip2px(3.0F), ViewUtils.dip2px(12.0F), ViewUtils.dip2px(4.0F));
    localButton.setText(paramString1);
    localButton.setTextSize(14.0F);
    localButton.setSingleLine();
    if (paramInt2 == 0) {
      paramInt2 = -16777216;
    }
    localButton.setTextColor(paramInt2);
    localButton.setOnClickListener(this);
    localButton.setTag(paramString1);
    if (!TextUtils.isEmpty(paramString2)) {
      localButton.setContentDescription(paramString2);
    }
    super.addView(localButton);
  }
  
  protected int a(int paramInt)
  {
    int i6 = (int)DisplayUtils.a(getContext(), 12.0F);
    int j = (int)DisplayUtils.a(getContext(), 10.0F);
    int i7 = (int)DisplayUtils.a(getContext(), 10.0F);
    int i8 = (int)DisplayUtils.a(getContext(), 10.0F);
    int m = (int)DisplayUtils.a(getContext(), 15.0F);
    int i9 = (int)DisplayUtils.a(getContext(), 15.0F);
    int i10 = getChildCount();
    int n = 0;
    int i1 = j;
    int k = m;
    int i2 = 1;
    int i;
    for (;;)
    {
      i = j;
      if (n >= i10) {
        break;
      }
      View localView = getChildAt(n);
      int i11 = localView.getMeasuredWidth();
      int i12 = localView.getMeasuredHeight();
      i = j;
      if (n == 0) {
        i = j + i12;
      }
      j = i;
      int i5 = k;
      int i4 = i2;
      int i3 = i1;
      if (k + i11 > paramInt - i9)
      {
        i4 = i2 + 1;
        j = this.b;
        if ((j > 0) && (i4 > j)) {
          break;
        }
        i3 = i1 + (i12 + i6);
        i5 = m;
        j = i12 + i3;
      }
      k = i5 + (i11 + i8);
      n += 1;
      i2 = i4;
      i1 = i3;
    }
    return i + i7;
  }
  
  public void a(List<BusinessGroupWord.HotWordItem> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    removeAllViews();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a(((BusinessGroupWord.HotWordItem)paramList.next()).b, paramInt1, paramInt2, paramInt3, null);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i2 = (int)DisplayUtils.a(getContext(), 12.0F);
    int n = (int)DisplayUtils.a(getContext(), 10.0F);
    int i3 = (int)DisplayUtils.a(getContext(), 10.0F);
    paramInt4 = (int)DisplayUtils.a(getContext(), 15.0F);
    int i4 = (int)DisplayUtils.a(getContext(), 15.0F);
    int i5 = getChildCount();
    int i = 0;
    paramInt2 = paramInt4;
    int k;
    for (int j = 1; i < i5; j = k)
    {
      View localView = getChildAt(i);
      int i6 = localView.getMeasuredWidth();
      int i7 = localView.getMeasuredHeight();
      int i1 = n;
      k = j;
      int m = paramInt2;
      if (paramInt2 + i6 > paramInt3 - paramInt1 - i4)
      {
        i1 = n + (i7 + i2);
        k = j + 1;
        paramInt2 = this.b;
        if ((paramInt2 > 0) && (k > paramInt2)) {
          return;
        }
        m = paramInt4;
      }
      localView.layout(m, i1, i6 + m, i7 + i1);
      i += 1;
      paramInt2 = i3 + i6 + m;
      n = i1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.HotWordForSubTipsContainer
 * JD-Core Version:    0.7.0.1
 */