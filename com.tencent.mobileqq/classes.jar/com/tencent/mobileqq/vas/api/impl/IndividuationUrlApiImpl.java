package com.tencent.mobileqq.vas.api.impl;

import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.api.IIndividuationUrlApi;
import java.util.Map;

public class IndividuationUrlApiImpl
  implements IIndividuationUrlApi
{
  public Map<String, String> getUrlMap()
  {
    return IndividuationUrlHelper.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.api.impl.IndividuationUrlApiImpl
 * JD-Core Version:    0.7.0.1
 */