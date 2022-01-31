package com.tencent.mobileqq.mini.cache;

import java.util.HashMap;

public class Entry
{
  public static final String DATA_SPLITER = ":";
  public static final String DATA_TYPE_Array = "Array";
  public static final String DATA_TYPE_OBJ = "Object";
  public static final String DATA_TYPE_STRING = "String";
  public static HashMap<String, Entry.Coder> sCoderList = new HashMap();
  public String mContent;
  public String mDataType;
  
  public String decode()
  {
    return null;
  }
  
  public String encode()
  {
    return this.mContent + ":" + this.mDataType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.cache.Entry
 * JD-Core Version:    0.7.0.1
 */