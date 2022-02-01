package com.tencent.mobileqq.kandian.biz.pts.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.util.ParseUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;

public class ReadInJoyCoordinateView
  extends ViewBase
{
  private RelativeLayout a;
  private TextView b;
  
  public ReadInJoyCoordinateView(VafContext paramVafContext)
  {
    super(paramVafContext);
    a(paramVafContext);
  }
  
  private void a(VafContext paramVafContext)
  {
    this.a = new RelativeLayout(paramVafContext.getContext());
    this.b = new TextView(paramVafContext.getContext());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, Utils.dp2px(20.0D));
    this.a.setLayoutParams(localLayoutParams);
    this.b.setGravity(17);
    this.b.setPadding(Utils.dp2px(5.0D), 0, Utils.dp2px(5.0D), 0);
    this.b.setTextSize(2, 12.0F);
    this.b.setTextColor(-1);
    this.b.setCompoundDrawablesWithIntrinsicBounds(paramVafContext.getContext().getResources().getDrawable(2130843763), null, null, null);
    this.b.setCompoundDrawablePadding(Utils.dp2px(2.0D));
    this.b.setBackgroundDrawable(paramVafContext.getContext().getResources().getDrawable(2130843717));
    paramVafContext = new RelativeLayout.LayoutParams(-2, Utils.dp2px(20.0D));
    paramVafContext.addRule(11);
    this.a.setPadding(0, 0, Utils.dp2px(12.0D), 0);
    this.a.addView(this.b, paramVafContext);
  }
  
  public int getComMeasuredHeight()
  {
    return this.a.getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return (int)(float)DeviceInfoUtil.D();
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
    return false;
  }
  
  protected boolean setAttribute(int paramInt, String paramString)
  {
    if (paramInt != 1031)
    {
      if (paramInt != 1068) {
        return super.setAttribute(paramInt, paramString);
      }
      paramInt = ParseUtil.a(paramString, 0);
      if (paramInt > 0) {
        this.a.setPadding(0, 0, Utils.dp2px(paramInt), 0);
      }
      return true;
    }
    if (!TextUtils.isEmpty(paramString)) {
      this.b.setText(paramString);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoyCoordinateView
 * JD-Core Version:    0.7.0.1
 */