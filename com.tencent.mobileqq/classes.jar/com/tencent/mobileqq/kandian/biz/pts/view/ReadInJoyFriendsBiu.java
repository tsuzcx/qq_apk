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
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyHeadImageView;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public class ReadInJoyFriendsBiu
  extends ViewBase
{
  public static String a = "ReadInJoyFriendsBiu";
  private double jdField_a_of_type_Double = 0.18D;
  private int jdField_a_of_type_Int = 22;
  private Context jdField_a_of_type_AndroidContentContext;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ArrayList<Long> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private int b = 115;
  private int c;
  private int d;
  private int e = 351;
  private int f = 1;
  private int g = 11;
  private int h = 3;
  private int i = 0;
  private int j = 6;
  
  public ReadInJoyFriendsBiu(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.jdField_a_of_type_AndroidContentContext = paramVafContext.getContext();
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    this.c = Utils.rp2px(this.jdField_a_of_type_Int);
    this.d = Utils.rp2px(this.b);
    this.e = Utils.rp2px(this.e);
    this.g = Utils.rp2px(this.g);
    this.f = Utils.rp2px(this.f);
    this.j = Utils.rp2px(this.j);
  }
  
  private int a()
  {
    int k = this.e;
    int m = this.c;
    double d1 = k - m;
    double d2 = m;
    double d3 = this.jdField_a_of_type_Double;
    Double.isNaN(d2);
    Double.isNaN(d1);
    return (int)(d1 / (d2 * (1.0D - d3)) + 1.0D);
  }
  
  private void a()
  {
    int i1 = a();
    double d1 = this.jdField_a_of_type_JavaUtilArrayList.size();
    double d2 = i1;
    Double.isNaN(d1);
    Double.isNaN(d2);
    int i2 = (int)Math.ceil(d1 / d2);
    int m = 1;
    while (m <= i2)
    {
      int i3 = m - 1;
      int i4 = i3 * i1;
      int k = i4 + i1;
      if (k > this.jdField_a_of_type_JavaUtilArrayList.size()) {
        k = this.jdField_a_of_type_JavaUtilArrayList.size() % i1 + i4;
      }
      int n = this.h;
      if (k > n) {
        k = n;
      }
      a(i4 + 1, k, i3 * this.c + this.g);
      m += 1;
    }
    a(i2);
  }
  
  private void a(int paramInt)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      int k = this.jdField_a_of_type_JavaUtilArrayList.size();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(k);
      ((StringBuilder)localObject).append("人也Biu了");
      localObject = ((StringBuilder)localObject).toString();
      long l = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin();
      if ((this.jdField_a_of_type_JavaUtilArrayList.size() == 1) && (l == ((Long)this.jdField_a_of_type_JavaUtilArrayList.get(0)).longValue()))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("还Biu了");
        ((StringBuilder)localObject).append(this.i);
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131712917));
        localObject = ((StringBuilder)localObject).toString();
      }
      else if (k > this.h)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131713043));
        ((StringBuilder)localObject).append(k);
        ((StringBuilder)localObject).append("人也Biu了");
        localObject = ((StringBuilder)localObject).toString();
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      k = a();
      if (this.jdField_a_of_type_JavaUtilArrayList.size() <= k) {
        k = this.jdField_a_of_type_JavaUtilArrayList.size();
      }
      int n = this.h;
      int m = k;
      if (k > n) {
        m = n;
      }
      if (m > 1)
      {
        double d1 = m - 1;
        double d2 = this.jdField_a_of_type_Double;
        Double.isNaN(d1);
        k = this.c;
        double d3 = k;
        Double.isNaN(d3);
        double d4 = k;
        Double.isNaN(d4);
        double d5 = this.d;
        Double.isNaN(d5);
        k = (int)(d1 * (1.0D - d2) * d3 + d4 + d5);
      }
      else
      {
        k = m * this.c + this.d;
      }
      if (k > this.e)
      {
        m = this.c;
      }
      else
      {
        paramInt -= 1;
        m = this.c;
      }
      n = this.d;
      localObject = new FrameLayout.LayoutParams(n, -2);
      ((FrameLayout.LayoutParams)localObject).setMargins(k - n, paramInt * m + this.g, 0, 0);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165414));
      this.jdField_a_of_type_AndroidWidgetTextView.setPadding(this.j, 0, 0, 0);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    int k = paramInt2 - 1;
    while (k >= paramInt1 - 1)
    {
      ReadInJoyHeadImageView localReadInJoyHeadImageView = new ReadInJoyHeadImageView(this.jdField_a_of_type_AndroidContentContext);
      int m = this.c;
      FrameLayout.LayoutParams localLayoutParams1 = new FrameLayout.LayoutParams(m, m);
      double d1 = k - paramInt1 + 1;
      double d2 = this.jdField_a_of_type_Double;
      Double.isNaN(d1);
      double d3 = this.c;
      Double.isNaN(d3);
      int n = (int)(d1 * (1.0D - d2) * d3);
      if (paramInt2 == this.jdField_a_of_type_JavaUtilArrayList.size()) {
        m = 20;
      } else {
        m = 0;
      }
      localLayoutParams1.setMargins(n, paramInt3, 0, m);
      localReadInJoyHeadImageView.setHeadImgByUin(((Long)this.jdField_a_of_type_JavaUtilArrayList.get(k)).longValue());
      int i1 = this.c;
      int i2 = this.f;
      FrameLayout.LayoutParams localLayoutParams2 = new FrameLayout.LayoutParams(i2 * 2 + i1, i1 + i2 * 2);
      ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      i1 = this.f;
      localLayoutParams2.setMargins(n - i1, paramInt3 - i1, 0, m);
      localImageView.setBackgroundResource(2130849714);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localImageView, localLayoutParams2);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localReadInJoyHeadImageView, localLayoutParams1);
      k -= 1;
    }
  }
  
  private void a(Object paramObject)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
      }
      this.i = 0;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      paramObject = (JSONObject)paramObject;
      localObject = paramObject.keys();
      while (((Iterator)localObject).hasNext())
      {
        long l = Long.parseLong(paramObject.get((String)((Iterator)localObject).next()).toString());
        this.i += 1;
        if (!this.jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(l))) {
          this.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(l));
        }
      }
      a();
      if (QLog.isColorLevel())
      {
        paramObject = jdField_a_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("parseUinList :");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilArrayList.size());
        QLog.d(paramObject, 2, ((StringBuilder)localObject).toString());
        return;
      }
    }
    catch (Exception paramObject)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("parseUinList error:");
        localStringBuilder.append(paramObject.toString());
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
    }
  }
  
  private void b(Object paramObject)
  {
    int k = Utils.parseColor(paramObject.toString());
    if (k != 0) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(k);
    }
  }
  
  private void c(Object paramObject)
  {
    Object localObject = Utils.toDouble(paramObject);
    if (localObject != null)
    {
      int k = Utils.dp2px(((Double)localObject).doubleValue());
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(k);
      return;
    }
    localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setTextSize: fail to parse - ");
    localStringBuilder.append(paramObject);
    QLog.d((String)localObject, 2, localStringBuilder.toString());
  }
  
  public int getComMeasuredHeight()
  {
    return this.jdField_a_of_type_AndroidWidgetFrameLayout.getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.jdField_a_of_type_AndroidWidgetFrameLayout.getMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.jdField_a_of_type_AndroidWidgetFrameLayout;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.measure(paramInt1, paramInt2);
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
      this.d = Utils.rp2px(Integer.valueOf(paramObject.toString()).intValue());
      return bool;
    }
    catch (Exception paramObject)
    {
      if (QLog.isColorLevel())
      {
        String str = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("parse STR_ID_BORDER_WIDTH error:");
        localStringBuilder.append(paramObject.toString());
        QLog.d(str, 2, localStringBuilder.toString());
      }
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoyFriendsBiu
 * JD-Core Version:    0.7.0.1
 */