package com.tencent.mobileqq.kandian.biz.pts.data;

import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/pts/data/PTSLiteDataFactory;", "", "()V", "Companion", "IPTSLiteDataJson", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PTSLiteDataFactory
{
  public static final PTSLiteDataFactory.Companion a = new PTSLiteDataFactory.Companion(null);
  private static final Map<Integer, PTSLiteDataFactory.IPTSLiteDataJson> b = (Map)new HashMap();
  
  static
  {
    b.put(Integer.valueOf(58), new DataBiliDoubleItemWhite());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.data.PTSLiteDataFactory
 * JD-Core Version:    0.7.0.1
 */