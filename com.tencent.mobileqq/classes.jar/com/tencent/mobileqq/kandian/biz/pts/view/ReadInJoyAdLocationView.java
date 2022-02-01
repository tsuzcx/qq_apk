package com.tencent.mobileqq.kandian.biz.pts.view;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import org.json.JSONObject;

public class ReadInJoyAdLocationView
  extends ViewBase
{
  private LinearLayout a;
  private TextView b;
  private TextView c;
  private JSONObject d;
  private int e = Utils.dp2px(233.0D);
  
  public ReadInJoyAdLocationView(VafContext paramVafContext)
  {
    super(paramVafContext);
    a(paramVafContext);
  }
  
  private int a(String paramString, int paramInt)
  {
    int i = Utils.dp2px(paramInt);
    paramInt = i;
    if (!TextUtils.isEmpty(this.d.optString(paramString)))
    {
      paramString = Utils.toDouble(this.d.optString(paramString));
      paramInt = i;
      if (paramString != null) {
        paramInt = Utils.dp2px(paramString.doubleValue());
      }
    }
    return paramInt;
  }
  
  private void a(VafContext paramVafContext)
  {
    ReadInJoyAdLocationView.BoringViewImpl localBoringViewImpl = new ReadInJoyAdLocationView.BoringViewImpl(paramVafContext.getContext());
    localBoringViewImpl.c(10);
    localBoringViewImpl.d(10);
    localBoringViewImpl.a(10);
    localBoringViewImpl.b(10);
    this.a = localBoringViewImpl;
    this.b = new TextView(paramVafContext.getContext());
    this.c = new TextView(paramVafContext.getContext());
    this.b.setMaxLines(1);
    this.b.setEllipsize(TextUtils.TruncateAt.END);
    this.c.setMaxLines(1);
    this.b.setIncludeFontPadding(false);
    this.c.setIncludeFontPadding(false);
    this.a.setOrientation(0);
    paramVafContext = new LinearLayout.LayoutParams(Utils.dp2px(20.0D), Utils.dp2px(20.0D));
    this.a.setGravity(16);
    this.a.setLayoutParams(paramVafContext);
    this.a.addView(this.b);
    this.a.addView(this.c);
  }
  
  private void a(String paramString, TextView paramTextView, int paramInt)
  {
    paramTextView.setTextSize(0, a(paramString, paramInt));
    a();
  }
  
  private void b()
  {
    b("setLocationTextColorString:", this.b, Color.parseColor("#4D7CAF"));
    a("setLocationTextSizeString:", this.b, 12);
    b("setDistanceTextColorString:", this.c, Color.parseColor("#737373"));
    a("setDistanceTextSizeString:", this.c, 12);
    if (!TextUtils.isEmpty(this.d.optString("setMidMarginString:")))
    {
      i = Utils.dp2px(3.0D);
      Object localObject = Utils.toInteger(this.d.optString("setMidMarginString:"));
      if (localObject != null) {
        i = Utils.dp2px(((Integer)localObject).intValue());
      }
      localObject = (LinearLayout.LayoutParams)this.b.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).rightMargin = i;
      this.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    int i = a("setTopPaddingString:", 6);
    int j = a("setBottomPaddingString:", 6);
    int k = a("setLeftPaddingString:", 7);
    int m = a("setRightPaddingString:", 7);
    this.a.setPadding(k, i, m, j);
    a();
  }
  
  private void b(String paramString, TextView paramTextView, int paramInt)
  {
    if (!TextUtils.isEmpty(this.d.optString(paramString)))
    {
      paramTextView.setTextColor(Utils.parseColor(this.d.optString(paramString)));
      return;
    }
    paramTextView.setTextColor(paramInt);
  }
  
  public void a()
  {
    float f1 = this.c.getPaint().measureText(this.c.getText().toString());
    int i = this.a.getPaddingLeft();
    int j = this.a.getPaddingRight();
    int k = ((LinearLayout.LayoutParams)this.b.getLayoutParams()).rightMargin;
    float f2 = this.e;
    float f3 = i;
    float f4 = j;
    float f5 = k;
    this.b.setMaxWidth((int)(f2 - f1 - f3 - f4 - f5));
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
  
  protected boolean setAttribute(int paramInt, Object paramObject)
  {
    if (paramInt != 1031)
    {
      if (paramInt != 1084) {
        return false;
      }
      if ((paramObject != null) && ((paramObject instanceof JSONObject)))
      {
        this.d = ((JSONObject)paramObject);
        if (this.d != null) {
          b();
        }
      }
      return true;
    }
    if ((paramObject != null) && ((paramObject instanceof JSONObject)))
    {
      paramObject = (JSONObject)paramObject;
      String str = paramObject.optString("ad_Location_content");
      if (!TextUtils.isEmpty(str))
      {
        this.b.setText(str);
        this.b.setVisibility(0);
      }
      else
      {
        this.b.setVisibility(8);
      }
      paramObject = paramObject.optString("ad_Location");
      if (!TextUtils.isEmpty(paramObject))
      {
        this.c.setText(paramObject);
        this.c.setVisibility(0);
        a();
        return true;
      }
      this.c.setVisibility(8);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoyAdLocationView
 * JD-Core Version:    0.7.0.1
 */