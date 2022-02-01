package com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.basic;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.BaseTemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class DynamicItemViewHelperCompatBase<D>
{
  public static int c;
  protected final Map<String, Integer> a = new ConcurrentHashMap();
  protected int b = 2147483647;
  protected int d = c + 1;
  protected int e = this.d;
  protected VafContext f;
  
  public void a(VafContext paramVafContext, int paramInt)
  {
    this.f = paramVafContext;
    int i = paramVafContext.getTemplateFactory().size();
    c = paramInt;
    this.d = (c + 1);
    paramInt = this.d;
    this.e = paramInt;
    int j = this.e;
    if ((j < paramInt + i) && (i > 0) && (j < this.b))
    {
      paramVafContext = paramVafContext.getTemplateFactory().getNameTemplateMap().keySet();
      paramInt = this.e;
      paramVafContext = paramVafContext.iterator();
      while (paramVafContext.hasNext())
      {
        String str = (String)paramVafContext.next();
        if (!this.a.containsKey(str))
        {
          this.a.put(str, Integer.valueOf(paramInt));
          paramInt += 1;
        }
      }
      this.e = (this.d + i);
      if (this.b == 2147483647) {
        this.b = (this.e + 30);
      }
      paramInt = this.e;
      j = this.b;
      if (paramInt > j) {
        this.e = j;
      }
      paramVafContext = new StringBuilder();
      paramVafContext.append("init: templateCount : ");
      paramVafContext.append(i);
      paramVafContext.append(" TYPE_DYNAMIC_END : ");
      paramVafContext.append(this.e);
      paramVafContext.append(" max : ");
      paramVafContext.append(this.b);
      QLog.d("DynamicItemViewHelperCompatBase", 1, paramVafContext.toString());
    }
    if (this.b == 2147483647) {
      this.b = (this.d + 100);
    }
  }
  
  public boolean a(int paramInt)
  {
    return (paramInt >= c) && (paramInt < this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.basic.DynamicItemViewHelperCompatBase
 * JD-Core Version:    0.7.0.1
 */