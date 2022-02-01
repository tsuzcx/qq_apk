package com.tencent.mobileqq.kandian.biz.pts.view;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.TextBase;
import com.tencent.mobileqq.kandian.base.view.widget.ticker.TickerView;

public class ProteusTickerView
  extends TextBase
{
  private TickerView a;
  
  public ProteusTickerView(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.a = new TickerView(paramVafContext.getContext());
    this.a.setCharacterLists(new String[] { "1234567890" });
    this.a.setAnimationDuration(500L);
  }
  
  public int getComMeasuredHeight()
  {
    return this.a.getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.a.getMeasuredWidth();
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
    super.onParseValueFinished();
    this.a.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
    this.a.setTextSize(this.mTextSize);
    this.a.setBackgroundColor(this.mBackground);
    this.a.setTextColor(this.mTextColor);
    if ((this.mTextStyle & 0x2) != 0) {
      this.a.setTypeface(Typeface.create(Typeface.DEFAULT, 2));
    }
    int i = 0;
    if ((this.mGravity & 0x4) != 0) {
      i = 1;
    } else if ((this.mGravity & 0x1) != 0) {
      i = 3;
    } else if ((0x2 & this.mGravity) != 0) {
      i = 5;
    }
    int j;
    if ((this.mGravity & 0x20) != 0)
    {
      j = i | 0x10;
    }
    else if ((this.mGravity & 0x8) != 0)
    {
      j = i | 0x30;
    }
    else
    {
      j = i;
      if ((this.mGravity & 0x10) != 0) {
        j = i | 0x50;
      }
    }
    this.a.setGravity(j);
    if ((!TextUtils.isEmpty(this.mText)) && ((this.mText instanceof String)))
    {
      this.a.setText((String)this.mText);
      return;
    }
    this.a.setText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.ProteusTickerView
 * JD-Core Version:    0.7.0.1
 */