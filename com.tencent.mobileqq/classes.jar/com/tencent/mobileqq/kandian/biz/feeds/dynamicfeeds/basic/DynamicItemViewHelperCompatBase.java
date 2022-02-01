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
  public static int b;
  protected int a;
  protected VafContext a;
  protected final Map<String, Integer> a;
  protected int c = b + 1;
  protected int d = this.c;
  
  public DynamicItemViewHelperCompatBase()
  {
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_a_of_type_Int = 2147483647;
  }
  
  public void a(VafContext paramVafContext, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = paramVafContext;
    int i = paramVafContext.getTemplateFactory().size();
    b = paramInt;
    this.c = (b + 1);
    paramInt = this.c;
    this.d = paramInt;
    int j = this.d;
    if ((j < paramInt + i) && (i > 0) && (j < this.jdField_a_of_type_Int))
    {
      paramVafContext = paramVafContext.getTemplateFactory().getNameTemplateMap().keySet();
      paramInt = this.d;
      paramVafContext = paramVafContext.iterator();
      while (paramVafContext.hasNext())
      {
        String str = (String)paramVafContext.next();
        if (!this.jdField_a_of_type_JavaUtilMap.containsKey(str))
        {
          this.jdField_a_of_type_JavaUtilMap.put(str, Integer.valueOf(paramInt));
          paramInt += 1;
        }
      }
      this.d = (this.c + i);
      if (this.jdField_a_of_type_Int == 2147483647) {
        this.jdField_a_of_type_Int = (this.d + 30);
      }
      paramInt = this.d;
      j = this.jdField_a_of_type_Int;
      if (paramInt > j) {
        this.d = j;
      }
      paramVafContext = new StringBuilder();
      paramVafContext.append("init: templateCount : ");
      paramVafContext.append(i);
      paramVafContext.append(" TYPE_DYNAMIC_END : ");
      paramVafContext.append(this.d);
      paramVafContext.append(" max : ");
      paramVafContext.append(this.jdField_a_of_type_Int);
      QLog.d("DynamicItemViewHelperCompatBase", 1, paramVafContext.toString());
    }
    if (this.jdField_a_of_type_Int == 2147483647) {
      this.jdField_a_of_type_Int = (this.c + 100);
    }
  }
  
  public boolean a(int paramInt)
  {
    return (paramInt >= b) && (paramInt < this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.basic.DynamicItemViewHelperCompatBase
 * JD-Core Version:    0.7.0.1
 */