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
    List localList = this.uniformList;
    if (localList != null) {
      return (String[])localList.toArray(new String[localList.size()]);
    }
    return null;
  }
  
  public void initParams()
  {
    Object localObject = this.uniformList;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        addParam(new UniformParam.FloatParam((String)((Iterator)localObject).next(), 1.0F));
      }
    }
    addParam(new UniformParam.FloatParam("progress", 0.0F));
  }
  
  public void setParameterDic(Map<String, Float> paramMap)
  {
    Object localObject = this.uniformList;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        addParam(new UniformParam.FloatParam(str, ((Float)paramMap.get(str)).floatValue()));
      }
    }
    if (paramMap.get("progress") != null) {
      addParam(new UniformParam.FloatParam("progress", ((Float)paramMap.get("progress")).floatValue()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.filter.ShakaCustomFilter
 * JD-Core Version:    0.7.0.1
 */