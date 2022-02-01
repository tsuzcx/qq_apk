package com.tencent.mobileqq.kandian.biz.search;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.mobileqq.kandian.biz.search.api.OnTipClickListener;
import com.tencent.mobileqq.kandian.biz.search.entity.TipsInfo;
import com.tencent.mobileqq.kandian.biz.search.entity.WordItem;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

public class ReadInJoySearchTipsContainer
  extends ViewGroup
  implements View.OnClickListener
{
  OnTipClickListener a;
  private int b = ViewUtils.dip2px(260.0F);
  private int c = 5;
  
  public ReadInJoySearchTipsContainer(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ReadInJoySearchTipsContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.b = (getResources().getDisplayMetrics().widthPixels / 2);
  }
  
  private void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if ((paramString1 != null) && (TextUtils.isEmpty(paramString1.trim()))) {
      return;
    }
    Button localButton = new Button(getContext());
    localButton.setBackgroundResource(2130851475);
    GradientDrawable localGradientDrawable = (GradientDrawable)((android.graphics.drawable.DrawableContainer.DrawableContainerState)((android.graphics.drawable.StateListDrawable)localButton.getBackground()).getConstantState()).getChildren()[1];
    if (paramInt2 == 0) {
      paramInt2 = -3355444;
    }
    localGradientDrawable.setStroke(1, paramInt2);
    localButton.setPadding(ViewUtils.dip2px(15.0F), ViewUtils.dip2px(5.0F), ViewUtils.dip2px(15.0F), ViewUtils.dip2px(6.0F));
    localButton.setText(paramString1);
    localButton.setTextSize(14.0F);
    localButton.setSingleLine();
    localButton.setEllipsize(TextUtils.TruncateAt.valueOf("MIDDLE"));
    localButton.setMaxWidth(this.b);
    if (paramInt1 == 0) {
      paramInt1 = -16777216;
    }
    localButton.setTextColor(paramInt1);
    localButton.setOnClickListener(this);
    localButton.setTag(paramString1);
    if (!TextUtils.isEmpty(paramString2)) {
      localButton.setContentDescription(paramString2);
    }
    super.addView(localButton);
  }
  
  protected int a(int paramInt)
  {
    int i6 = (int)DisplayUtils.a(getContext(), 7.0F);
    int j = (int)DisplayUtils.a(getContext(), 10.0F);
    int i7 = (int)DisplayUtils.a(getContext(), 10.0F);
    int i8 = (int)DisplayUtils.a(getContext(), 4.0F);
    int m = (int)DisplayUtils.a(getContext(), 12.0F);
    int i9 = (int)DisplayUtils.a(getContext(), 12.0F);
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
        j = this.c;
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
  
  public void a(List<TipsInfo> paramList)
  {
    removeAllViews();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TipsInfo localTipsInfo = (TipsInfo)paramList.next();
      a(localTipsInfo.word, localTipsInfo.textColor, localTipsInfo.frameColor, localTipsInfo.contentDescription);
    }
  }
  
  public void b(List<WordItem> paramList)
  {
    removeAllViews();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      WordItem localWordItem = (WordItem)paramList.next();
      a(localWordItem.word, localWordItem.textColor, localWordItem.frameColor, localWordItem.contentDescription);
    }
  }
  
  public void onClick(View paramView)
  {
    ReadInJoySearchTipsContainer.1 local1 = new ReadInJoySearchTipsContainer.1(this, Looper.getMainLooper());
    Message localMessage = local1.obtainMessage();
    localMessage.obj = paramView.getTag();
    local1.sendMessage(localMessage);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i2 = (int)DisplayUtils.a(getContext(), 7.0F);
    int n = (int)DisplayUtils.a(getContext(), 10.0F);
    int i3 = (int)DisplayUtils.a(getContext(), 4.0F);
    paramInt4 = (int)DisplayUtils.a(getContext(), 12.0F);
    int i4 = (int)DisplayUtils.a(getContext(), 12.0F);
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
        paramInt2 = this.c;
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
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int m = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getMode(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt2);
    super.measureChildren(paramInt1, paramInt2);
    if ((m != -2147483648) && (m != 1073741824)) {
      paramInt2 = 0;
    } else {
      paramInt2 = i;
    }
    if (k != -2147483648)
    {
      paramInt1 = j;
      if (k != 1073741824) {
        paramInt1 = a(i);
      }
    }
    else
    {
      paramInt1 = a(i);
    }
    super.setMeasuredDimension(paramInt2, paramInt1);
  }
  
  public void setMaxLines(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setOnTipsClickListener(OnTipClickListener paramOnTipClickListener)
  {
    this.a = paramOnTipClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.search.ReadInJoySearchTipsContainer
 * JD-Core Version:    0.7.0.1
 */