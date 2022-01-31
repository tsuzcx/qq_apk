package com.tencent.viola.utils;

import android.support.annotation.NonNull;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SingleFunctionParser<V>
  extends FunctionParser<String, List<V>>
{
  public SingleFunctionParser(@NonNull String paramString, @NonNull SingleFunctionParser.FlatMapper<V> paramFlatMapper)
  {
    super(paramString, new SingleFunctionParser.1(paramFlatMapper));
  }
  
  public SingleFunctionParser(@NonNull String paramString, @NonNull SingleFunctionParser.NonUniformMapper<V> paramNonUniformMapper)
  {
    super(paramString, new SingleFunctionParser.2(paramNonUniformMapper));
  }
  
  public List<V> parse(String paramString)
  {
    LinkedHashMap localLinkedHashMap = parse();
    if (localLinkedHashMap.containsKey(paramString)) {
      return (List)localLinkedHashMap.get(paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.utils.SingleFunctionParser
 * JD-Core Version:    0.7.0.1
 */