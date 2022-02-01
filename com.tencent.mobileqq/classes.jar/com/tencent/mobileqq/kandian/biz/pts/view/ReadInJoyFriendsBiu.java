package com.tencent.mobileqq.kandian.biz.pts.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyHeadImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public class ReadInJoyFriendsBiu
  extends ViewBase
{
  public static String a = "ReadInJoyFriendsBiu";
  private FrameLayout b;
  private TextView c;
  private Context d;
  private ArrayList<Long> e = new ArrayList();
  private int f = 22;
  private int g = 115;
  private int h;
  private int i;
  private int j = 351;
  private double k = 0.18D;
  private int l = 1;
  private int m = 11;
  private int n = 3;
  private int o = 0;
  private int p = 6;
  
  public ReadInJoyFriendsBiu(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.d = paramVafContext.getContext();
    this.b = new FrameLayout(this.d);
    this.c = new TextView(this.d);
    this.h = Utils.rp2px(this.f);
    this.i = Utils.rp2px(this.g);
    this.j = Utils.rp2px(this.j);
    this.m = Utils.rp2px(this.m);
    this.l = Utils.rp2px(this.l);
    this.p = Utils.rp2px(this.p);
  }
  
  private void a()
  {
    int i4 = b();
    double d1 = this.e.size();
    double d2 = i4;
    Double.isNaN(d1);
    Double.isNaN(d2);
    int i5 = (int)Math.ceil(d1 / d2);
    int i2 = 1;
    while (i2 <= i5)
    {
      int i6 = i2 - 1;
      int i7 = i6 * i4;
      int i1 = i7 + i4;
      if (i1 > this.e.size()) {
        i1 = this.e.size() % i4 + i7;
      }
      int i3 = this.n;
      if (i1 > i3) {
        i1 = i3;
      }
      a(i7 + 1, i1, i6 * this.h + this.m);
      i2 += 1;
    }
    a(i5);
  }
  
  private void a(int paramInt)
  {
    if (!this.e.isEmpty())
    {
      int i1 = this.e.size();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append("人也Biu了");
      localObject = ((StringBuilder)localObject).toString();
      long l1 = RIJQQAppInterfaceUtil.c();
      if ((this.e.size() == 1) && (l1 == ((Long)this.e.get(0)).longValue()))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("还Biu了");
        ((StringBuilder)localObject).append(this.o);
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131910487));
        localObject = ((StringBuilder)localObject).toString();
      }
      else if (i1 > this.n)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131910604));
        ((StringBuilder)localObject).append(i1);
        ((StringBuilder)localObject).append("人也Biu了");
        localObject = ((StringBuilder)localObject).toString();
      }
      this.c.setText((CharSequence)localObject);
      i1 = b();
      if (this.e.size() <= i1) {
        i1 = this.e.size();
      }
      int i3 = this.n;
      int i2 = i1;
      if (i1 > i3) {
        i2 = i3;
      }
      if (i2 > 1)
      {
        double d1 = i2 - 1;
        double d2 = this.k;
        Double.isNaN(d1);
        i1 = this.h;
        double d3 = i1;
        Double.isNaN(d3);
        double d4 = i1;
        Double.isNaN(d4);
        double d5 = this.i;
        Double.isNaN(d5);
        i1 = (int)(d1 * (1.0D - d2) * d3 + d4 + d5);
      }
      else
      {
        i1 = i2 * this.h + this.i;
      }
      if (i1 > this.j)
      {
        i2 = this.h;
      }
      else
      {
        paramInt -= 1;
        i2 = this.h;
      }
      i3 = this.i;
      localObject = new FrameLayout.LayoutParams(i3, -2);
      ((FrameLayout.LayoutParams)localObject).setMargins(i1 - i3, paramInt * i2 + this.m, 0, 0);
      this.c.setTextColor(this.d.getResources().getColor(2131165710));
      this.c.setPadding(this.p, 0, 0, 0);
      this.b.addView(this.c, (ViewGroup.LayoutParams)localObject);
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = paramInt2 - 1;
    while (i1 >= paramInt1 - 1)
    {
      ReadInJoyHeadImageView localReadInJoyHeadImageView = new ReadInJoyHeadImageView(this.d);
      int i2 = this.h;
      FrameLayout.LayoutParams localLayoutParams1 = new FrameLayout.LayoutParams(i2, i2);
      double d1 = i1 - paramInt1 + 1;
      double d2 = this.k;
      Double.isNaN(d1);
      double d3 = this.h;
      Double.isNaN(d3);
      int i3 = (int)(d1 * (1.0D - d2) * d3);
      if (paramInt2 == this.e.size()) {
        i2 = 20;
      } else {
        i2 = 0;
      }
      localLayoutParams1.setMargins(i3, paramInt3, 0, i2);
      localReadInJoyHeadImageView.setHeadImgByUin(((Long)this.e.get(i1)).longValue());
      int i4 = this.h;
      int i5 = this.l;
      FrameLayout.LayoutParams localLayoutParams2 = new FrameLayout.LayoutParams(i5 * 2 + i4, i4 + i5 * 2);
      ImageView localImageView = new ImageView(this.d);
      i4 = this.l;
      localLayoutParams2.setMargins(i3 - i4, paramInt3 - i4, 0, i2);
      localImageView.setBackgroundResource(2130851423);
      this.b.addView(localImageView, localLayoutParams2);
      this.b.addView(localReadInJoyHeadImageView, localLayoutParams1);
      i1 -= 1;
    }
  }
  
  private void a(Object paramObject)
  {
    try
    {
      if (this.b != null) {
        this.b.removeAllViews();
      }
      this.o = 0;
      this.e.clear();
      paramObject = (JSONObject)paramObject;
      localObject = paramObject.keys();
      while (((Iterator)localObject).hasNext())
      {
        long l1 = Long.parseLong(paramObject.get((String)((Iterator)localObject).next()).toString());
        this.o += 1;
        if (!this.e.contains(Long.valueOf(l1))) {
          this.e.add(Long.valueOf(l1));
        }
      }
      a();
      if (QLog.isColorLevel())
      {
        paramObject = a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("parseUinList :");
        ((StringBuilder)localObject).append(this.e.size());
        QLog.d(paramObject, 2, ((StringBuilder)localObject).toString());
        return;
      }
    }
    catch (Exception paramObject)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("parseUinList error:");
        localStringBuilder.append(paramObject.toString());
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
    }
  }
  
  private int b()
  {
    int i1 = this.j;
    int i2 = this.h;
    double d1 = i1 - i2;
    double d2 = i2;
    double d3 = this.k;
    Double.isNaN(d2);
    Double.isNaN(d1);
    return (int)(d1 / (d2 * (1.0D - d3)) + 1.0D);
  }
  
  private void b(Object paramObject)
  {
    int i1 = Utils.parseColor(paramObject.toString());
    if (i1 != 0) {
      this.c.setTextColor(i1);
    }
  }
  
  private void c(Object paramObject)
  {
    Object localObject = Utils.toDouble(paramObject);
    if (localObject != null)
    {
      int i1 = Utils.dp2px(((Double)localObject).doubleValue());
      this.c.setTextSize(i1);
      return;
    }
    localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setTextSize: fail to parse - ");
    localStringBuilder.append(paramObject);
    QLog.d((String)localObject, 2, localStringBuilder.toString());
  }
  
  public int getComMeasuredHeight()
  {
    return this.b.getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.b.getMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.b;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.b.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.b.measure(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
  }
  
  protected boolean setAttribute(int paramInt, Object paramObject)
  {
    boolean bool = super.setAttribute(paramInt, paramObject);
    if (paramInt != 15)
    {
      if (paramInt != 46)
      {
        if (paramInt != 19)
        {
          if (paramInt != 20) {
            return bool;
          }
          b(paramObject);
          return bool;
        }
        c(paramObject);
        return bool;
      }
      a(paramObject);
      return bool;
    }
    try
    {
      this.i = Utils.rp2px(Integer.valueOf(paramObject.toString()).intValue());
      return bool;
    }
    catch (Exception paramObject)
    {
      if (QLog.isColorLevel())
      {
        String str = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("parse STR_ID_BORDER_WIDTH error:");
        localStringBuilder.append(paramObject.toString());
        QLog.d(str, 2, localStringBuilder.toString());
      }
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoyFriendsBiu
 * JD-Core Version:    0.7.0.1
 */