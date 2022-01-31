package com.tencent.mobileqq.fts.entity;

import android.text.TextUtils;
import com.tencent.mobileqq.fts.utils.SQLUtils;
import com.tencent.mobileqq.fts.utils.SegmentUtils;
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
  @notIndex
  public byte[] exts;
  @notColumn
  public Map indexContentMap = new HashMap();
  
  public void doDeserialize() {}
  
  public void doSerialize() {}
  
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
      Iterator localIterator = SQLUtils.a(getClass()).iterator();
      while (localIterator.hasNext())
      {
        Field localField = (Field)localIterator.next();
        try
        {
          String str = (String)localField.get(this);
          if (!TextUtils.isEmpty(str))
          {
            str = SegmentUtils.a(str);
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