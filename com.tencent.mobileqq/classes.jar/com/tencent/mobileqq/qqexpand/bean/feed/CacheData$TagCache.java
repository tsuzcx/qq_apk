package com.tencent.mobileqq.qqexpand.bean.feed;

import java.util.ArrayList;
import java.util.List;

public class CacheData$TagCache
{
  public int a;
  public long a;
  public String a;
  public List<StrangerInfo> a;
  public boolean a;
  public byte[] a;
  public int b;
  public int c;
  
  public CacheData$TagCache()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramObject != null)
    {
      bool1 = bool2;
      if ((paramObject instanceof TagCache))
      {
        paramObject = ((TagCache)paramObject).jdField_a_of_type_JavaLangString;
        bool1 = bool2;
        if (paramObject != null)
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_JavaLangString.equals(paramObject)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mUpdateTime");
    localStringBuilder.append("=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(" ");
    localStringBuilder.append("mUpdateTime");
    localStringBuilder.append("=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(" ");
    localStringBuilder.append("mSearchKey");
    localStringBuilder.append("=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" ");
    localStringBuilder.append("mLoadOver");
    localStringBuilder.append("=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(" ");
    localStringBuilder.append("mCurPos");
    localStringBuilder.append("=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" ");
    localStringBuilder.append("mOffset");
    localStringBuilder.append("=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" ");
    localStringBuilder.append("size");
    localStringBuilder.append("=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilList.size());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.bean.feed.CacheData.TagCache
 * JD-Core Version:    0.7.0.1
 */