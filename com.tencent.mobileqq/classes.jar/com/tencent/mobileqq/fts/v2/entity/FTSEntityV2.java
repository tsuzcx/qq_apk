package com.tencent.mobileqq.fts.v2.entity;

import android.text.TextUtils;
import com.tencent.mobileqq.fts.utils.FTSV2FieldUtils;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class FTSEntityV2
{
  public String ext1 = null;
  public String ext2 = null;
  public String ext3 = null;
  @notIndex
  public byte[] exts = null;
  @notColumn
  public Map<String, String> indexContentMap = new HashMap();
  
  protected void doDeserialize() {}
  
  protected void doSerialize() {}
  
  public String getIndexColumnName(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_index");
    return localStringBuilder.toString();
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
      Iterator localIterator = FTSV2FieldUtils.a(getClass()).iterator();
      while (localIterator.hasNext())
      {
        Field localField = (Field)localIterator.next();
        try
        {
          String str = (String)localField.get(this);
          if (!TextUtils.isEmpty(str))
          {
            str = FTSV2FieldUtils.a(str);
            this.indexContentMap.put(localField.getName(), str);
          }
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          localIllegalAccessException.printStackTrace();
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fts.v2.entity.FTSEntityV2
 * JD-Core Version:    0.7.0.1
 */