package com.tencent.mobileqq.search.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySearchTipsContainer;
import com.tencent.mobileqq.search.model.BusinessGroupWord.HotWordItem;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.Iterator;
import java.util.List;

public class HotWordForSubTipsContainer
  extends ReadInJoySearchTipsContainer
{
  private int a = 5;
  
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
    if (paramInt1 == 0)
    {
      localButton.setBackgroundResource(2130845503);
      GradientDrawable localGradientDrawable = (GradientDrawable)((android.graphics.drawable.DrawableContainer.DrawableContainerState)((android.graphics.drawable.StateListDrawable)localButton.getBackground()).getConstantState()).getChildren()[1];
      if (paramInt3 == 0) {
        break label172;
      }
      label68:
      localGradientDrawable.setStroke(1, paramInt3);
      localButton.setPadding(ViewUtils.a(12.0F), ViewUtils.a(3.0F), ViewUtils.a(12.0F), ViewUtils.a(4.0F));
      localButton.setText(paramString1);
      localButton.setTextSize(14.0F);
      localButton.setSingleLine();
      if (paramInt2 == 0) {
        break label179;
      }
    }
    for (;;)
    {
      localButton.setTextColor(paramInt2);
      localButton.setOnClickListener(this);
      localButton.setTag(paramString1);
      if (!TextUtils.isEmpty(paramString2)) {
        localButton.setContentDescription(paramString2);
      }
      super.addView(localButton);
      return;
      localButton.setBackgroundResource(paramInt1);
      break;
      label172:
      paramInt3 = -3355444;
      break label68;
      label179:
      paramInt2 = -16777216;
    }
  }
  
  protected int a(int paramInt)
  {
    int i6 = (int)DisplayUtils.a(getContext(), 12.0F);
    int i1 = (int)DisplayUtils.a(getContext(), 10.0F);
    int i7 = (int)DisplayUtils.a(getContext(), 10.0F);
    int i8 = (int)DisplayUtils.a(getContext(), 10.0F);
    int m = (int)DisplayUtils.a(getContext(), 15.0F);
    int i9 = (int)DisplayUtils.a(getContext(), 15.0F);
    int i10 = getChildCount();
    int n = 0;
    int k = m;
    int i = i1;
    int i2 = 1;
    for (;;)
    {
      int j = i;
      int i11;
      int i12;
      int i4;
      if (n < i10)
      {
        View localView = getChildAt(n);
        i11 = localView.getMeasuredWidth();
        i12 = localView.getMeasuredHeight();
        j = i;
        if (n == 0) {
          j = i + i12;
        }
        i = j;
        i4 = i2;
        i3 = i1;
        i5 = k;
        if (k + i11 <= paramInt - i9) {
          break label207;
        }
        i4 = i2 + 1;
        if ((this.a <= 0) || (i4 <= this.a)) {}
      }
      else
      {
        return j + i7;
      }
      int i3 = i1 + (i12 + i6);
      i = i3 + i12;
      int i5 = m;
      label207:
      n += 1;
      k = i8 + i11 + i5;
      i2 = i4;
      i1 = i3;
    }
  }
  
  public void a(List paramList, int paramInt1, int paramInt2, int paramInt3)
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
    int k = (int)DisplayUtils.a(getContext(), 10.0F);
    int i3 = (int)DisplayUtils.a(getContext(), 10.0F);
    paramInt4 = (int)DisplayUtils.a(getContext(), 15.0F);
    int i4 = (int)DisplayUtils.a(getContext(), 15.0F);
    int i5 = getChildCount();
    int i = 0;
    int j = 1;
    paramInt2 = paramInt4;
    for (;;)
    {
      View localView;
      int i6;
      int i7;
      int i1;
      int m;
      if (i < i5)
      {
        localView = getChildAt(i);
        i6 = localView.getMeasuredWidth();
        i7 = localView.getMeasuredHeight();
        i1 = j;
        m = k;
        n = paramInt2;
        if (paramInt2 + i6 <= paramInt3 - paramInt1 - i4) {
          break label166;
        }
        m = k + (i7 + i2);
        i1 = j + 1;
        if ((this.a <= 0) || (i1 <= this.a)) {}
      }
      else
      {
        return;
      }
      int n = paramInt4;
      label166:
      localView.layout(n, m, i6 + n, i7 + m);
      i += 1;
      paramInt2 = i3 + i6 + n;
      j = i1;
      k = m;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.HotWordForSubTipsContainer
 * JD-Core Version:    0.7.0.1
 */