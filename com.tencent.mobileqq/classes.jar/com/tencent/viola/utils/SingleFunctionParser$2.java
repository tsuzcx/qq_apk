package com.tencent.viola.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SingleFunctionParser$2
  implements FunctionParser.Mapper<String, List<V>>
{
  SingleFunctionParser$2(SingleFunctionParser.NonUniformMapper paramNonUniformMapper) {}
  
  public Map<String, List<V>> map(String paramString, List<String> paramList)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramString, this.val$mapper.map(paramList));
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.utils.SingleFunctionParser.2
 * JD-Core Version:    0.7.0.1
 */