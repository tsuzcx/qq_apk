package com.tencent.mobileqq.service;

import java.util.HashMap;

public class TextMsgPush
{
  private Long jdField_a_of_type_JavaLangLong;
  private HashMap<Integer, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Long b;
  
  public TextMsgPush(Long paramLong1, Long paramLong2)
  {
    this.jdField_a_of_type_JavaLangLong = paramLong1;
    this.b = paramLong2;
  }
  
  public String a()
  {
    String str = new String();
    if (!a()) {
      return str;
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilHashMap.size())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append((String)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i)));
      str = localStringBuilder.toString();
      i += 1;
    }
    return str;
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), paramString);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap.size() == this.jdField_a_of_type_JavaLangLong.longValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.TextMsgPush
 * JD-Core Version:    0.7.0.1
 */