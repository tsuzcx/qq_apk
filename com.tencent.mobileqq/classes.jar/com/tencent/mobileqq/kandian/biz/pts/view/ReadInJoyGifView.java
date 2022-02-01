package com.tencent.mobileqq.kandian.biz.pts.view;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeGifView;
import com.tencent.qphone.base.util.QLog;

public class ReadInJoyGifView
  extends ViewBase
{
  private NativeGifView a;
  private int b;
  private int c;
  private String d;
  
  public ReadInJoyGifView(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.a = new NativeGifView(paramVafContext.getContext());
  }
  
  private boolean a()
  {
    return this.mParams.mLayoutHeight * this.mParams.mLayoutWidth > 2000000;
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
    if (this.b > 0)
    {
      int i = this.c;
      if (i > 0)
      {
        this.a.setGifHeight(i);
        this.a.setGifWidth(this.b);
      }
    }
    if (!TextUtils.isEmpty(this.d)) {
      this.a.setGifUrl(this.d);
    }
    this.a.setIsBigImg(a());
    this.a.setBackgroundColor(this.mBackground);
    this.a.displayGif(this.mParams.mLayoutWidth, this.mParams.mLayoutHeight);
    this.a.invalidate();
  }
  
  protected boolean setAttribute(int paramInt, Object paramObject)
  {
    Layout.Params localParams;
    if (paramInt != 58)
    {
      if (paramInt != 59) {
        return super.setAttribute(paramInt, paramObject);
      }
      try
      {
        localParams = this.mParams;
        paramInt = ((Integer)paramObject).intValue();
        localParams.mLayoutWidth = paramInt;
        this.b = paramInt;
      }
      catch (Exception paramObject)
      {
        QLog.d("ReadInJoyGifView", 2, paramObject.getMessage());
      }
      this.a.requestLayout();
      return true;
    }
    try
    {
      localParams = this.mParams;
      paramInt = ((Integer)paramObject).intValue();
      localParams.mLayoutHeight = paramInt;
      this.c = paramInt;
    }
    catch (Exception paramObject)
    {
      QLog.d("ReadInJoyGifView", 2, paramObject.getMessage());
    }
    this.a.requestLayout();
    return true;
  }
  
  protected boolean setAttribute(int paramInt, String paramString)
  {
    if (paramInt != 51)
    {
      if (paramInt != 1164)
      {
        if (paramInt != 1155)
        {
          if (paramInt != 1156) {
            return super.setAttribute(paramInt, paramString);
          }
          if (!TextUtils.isEmpty(paramString))
          {
            this.a.setNeedGifUrl("yes".equals(paramString.toLowerCase()));
            return true;
          }
          return false;
        }
        this.d = paramString;
        return true;
      }
      this.a.setCoverUrl(paramString);
      return true;
    }
    try
    {
      paramString = Utils.toInteger(paramString);
      if ((this.a != null) && (paramString != null))
      {
        this.a.setScaleType(paramString.intValue());
        return true;
      }
    }
    catch (Exception paramString)
    {
      QLog.d("ReadInJoyGifView", 2, paramString.getMessage());
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoyGifView
 * JD-Core Version:    0.7.0.1
 */