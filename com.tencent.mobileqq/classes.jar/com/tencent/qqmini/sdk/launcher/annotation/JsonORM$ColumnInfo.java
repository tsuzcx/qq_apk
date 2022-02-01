package com.tencent.qqmini.sdk.launcher.annotation;

import java.lang.reflect.Field;

final class JsonORM$ColumnInfo
{
  public final Field field;
  public final String key;
  public final int type;
  
  public JsonORM$ColumnInfo(String paramString, int paramInt, Field paramField)
  {
    this.key = paramString;
    this.type = paramInt;
    this.field = paramField;
    paramField.setAccessible(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.annotation.JsonORM.ColumnInfo
 * JD-Core Version:    0.7.0.1
 */