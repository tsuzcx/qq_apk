package com.tencent.mobileqq.kandian.biz.pts.view;

import android.graphics.Color;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeMiddleBodyView;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;

public class ReadInJoyMiddleBodyView
  extends ViewBase
{
  private NativeMiddleBodyView a;
  private int b = -1;
  private int c = -1;
  private int d = -1;
  private int e = -1;
  
  public ReadInJoyMiddleBodyView(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.a = new NativeMiddleBodyView(paramVafContext.getContext());
  }
  
  public int a()
  {
    return this.b;
  }
  
  public void a(RelativeLayout.LayoutParams paramLayoutParams)
  {
    if (e()) {
      paramLayoutParams.setMargins(0, 0, 0, 0);
    }
  }
  
  public int b()
  {
    return this.c;
  }
  
  public int c()
  {
    return this.d;
  }
  
  public int d()
  {
    return this.e;
  }
  
  public boolean e()
  {
    return (this.mPaddingLeft > 0) || (this.mPaddingRight > 0);
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
    this.a.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
  }
  
  protected boolean setAttribute(int paramInt, Object paramObject)
  {
    if (paramInt != 1082) {
      return super.setAttribute(paramInt, paramObject);
    }
    if ((paramObject instanceof JSONArray))
    {
      paramObject = (JSONArray)paramObject;
      if (paramObject.length() >= 4) {
        try
        {
          this.a.setRadius(paramObject.getString(0), paramObject.getString(1), paramObject.getString(2), paramObject.getString(3));
          return true;
        }
        catch (JSONException paramObject)
        {
          QLog.d("ReadInJoyMiddleBodyView", 2, "", paramObject);
        }
      }
    }
    return true;
  }
  
  protected boolean setAttribute(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return super.setAttribute(paramInt, paramString);
    case 1195: 
      try
      {
        this.e = Color.parseColor(String.valueOf(paramString));
        paramString = new StringBuilder();
        paramString.append("setLinkTextColor: ");
        paramString.append(this.e);
        QLog.d("ReadInJoyMiddleBodyView", 1, paramString.toString());
        return true;
      }
      catch (Exception paramString)
      {
        QLog.e("ReadInJoyMiddleBodyView", 1, paramString, new Object[0]);
        return false;
      }
    case 1194: 
      try
      {
        this.d = Utils.rp2px(Float.valueOf(String.valueOf(paramString)).floatValue());
        paramString = new StringBuilder();
        paramString.append("setEmotionlineSpace: ");
        paramString.append(this.d);
        QLog.d("ReadInJoyMiddleBodyView", 1, paramString.toString());
        return true;
      }
      catch (NumberFormatException paramString)
      {
        QLog.e("ReadInJoyMiddleBodyView", 1, paramString, new Object[0]);
        return false;
      }
    case 1193: 
      try
      {
        this.c = Color.parseColor(String.valueOf(paramString));
        paramString = new StringBuilder();
        paramString.append("setEmotionFontColor: ");
        paramString.append(this.c);
        QLog.d("ReadInJoyMiddleBodyView", 1, paramString.toString());
        return true;
      }
      catch (Exception paramString)
      {
        QLog.e("ReadInJoyMiddleBodyView", 1, paramString, new Object[0]);
        return false;
      }
    }
    try
    {
      this.b = Utils.dp2px(Integer.valueOf(String.valueOf(paramString)).intValue());
      paramString = new StringBuilder();
      paramString.append("setEmotionFontSize: ");
      paramString.append(this.b);
      QLog.d("ReadInJoyMiddleBodyView", 1, paramString.toString());
      return true;
    }
    catch (NumberFormatException paramString)
    {
      QLog.e("ReadInJoyMiddleBodyView", 1, paramString, new Object[0]);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoyMiddleBodyView
 * JD-Core Version:    0.7.0.1
 */