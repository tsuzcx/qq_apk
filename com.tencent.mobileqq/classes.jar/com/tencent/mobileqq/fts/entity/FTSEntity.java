package com.tencent.mobileqq.fts.entity;

import android.text.TextUtils;
import aprk;
import aprl;
import aprw;
import aprx;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class FTSEntity
{
  public String ext1;
  public String ext2;
  public String ext3;
  @aprl
  public byte[] exts;
  @aprk
  public Map<String, String> indexContentMap = new HashMap();
  
  protected void doDeserialize() {}
  
  protected void doSerialize() {}
  
  public String getIndexColumnName(String paramString)
  {
    return paramString + "_index";
  }
  
  public String getTableName()
  {
    return getClass().getSimpleName();
  }
  
  public boolean needCompress()
  {
    return false;
  }
  
  public void postRead() {}
  
  public void preWrite()
  {
    try
    {
      Iterator localIterator = aprw.a(getClass()).iterator();
      while (localIterator.hasNext())
      {
        Field localField = (Field)localIterator.next();
        try
        {
          String str = (String)localField.get(this);
          if (!TextUtils.isEmpty(str))
          {
            str = aprx.a(str);
            this.indexContentMap.put(localField.getName(), str);
          }
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          localIllegalAccessException.printStackTrace();
        }
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.fts.entity.FTSEntity
 * JD-Core Version:    0.7.0.1
 */