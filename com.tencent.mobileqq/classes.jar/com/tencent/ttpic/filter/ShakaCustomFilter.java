package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ShakaCustomFilter
  extends ShakaFilterBase
{
  private List<String> uniformList;
  
  public ShakaCustomFilter(String paramString1, String paramString2, List<String> paramList)
  {
    super(paramString1, paramString2);
    this.uniformList = paramList;
  }
  
  protected float getDefaultParamValue()
  {
    return 0.0F;
  }
  
  protected String[] getParamKeys()
  {
    if (this.uniformList != null) {
      return (String[])this.uniformList.toArray(new String[this.uniformList.size()]);
    }
    return null;
  }
  
  public void initParams()
  {
    if (this.uniformList != null)
    {
      Iterator localIterator = this.uniformList.iterator();
      while (localIterator.hasNext()) {
        addParam(new UniformParam.FloatParam((String)localIterator.next(), 1.0F));
      }
    }
    addParam(new UniformParam.FloatParam("progress", 0.0F));
  }
  
  public void setParameterDic(Map<String, Float> paramMap)
  {
    if (this.uniformList != null)
    {
      Iterator localIterator = this.uniformList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        addParam(new UniformParam.FloatParam(str, ((Float)paramMap.get(str)).floatValue()));
      }
    }
    if (paramMap.get("progress") != null) {
      addParam(new UniformParam.FloatParam("progress", ((Float)paramMap.get("progress")).floatValue()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.ShakaCustomFilter
 * JD-Core Version:    0.7.0.1
 */