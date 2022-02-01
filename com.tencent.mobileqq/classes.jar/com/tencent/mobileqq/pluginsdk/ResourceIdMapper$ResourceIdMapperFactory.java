package com.tencent.mobileqq.pluginsdk;

public class ResourceIdMapper$ResourceIdMapperFactory
{
  public ResourceIdMapper getInstance(String paramString)
  {
    try
    {
      paramString = (ResourceIdMapper)Class.forName(paramString).newInstance();
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      paramString.printStackTrace();
    }
    catch (IllegalAccessException paramString)
    {
      paramString.printStackTrace();
    }
    catch (InstantiationException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.ResourceIdMapper.ResourceIdMapperFactory
 * JD-Core Version:    0.7.0.1
 */