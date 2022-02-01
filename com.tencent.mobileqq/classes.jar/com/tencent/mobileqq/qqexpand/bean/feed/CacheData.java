package com.tencent.mobileqq.qqexpand.bean.feed;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CacheData
{
  public int a;
  public List<CacheData.TagCache> a;
  public boolean a;
  public boolean b;
  
  private int a()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    int j = 0;
    int i = 0;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        i += ((CacheData.TagCache)((Iterator)localObject).next()).jdField_a_of_type_JavaUtilList.size();
      }
    }
    return j;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      long l = System.currentTimeMillis();
      int i = this.jdField_a_of_type_JavaUtilList.size() - 1;
      while (i >= 0)
      {
        if (Math.abs(l - ((CacheData.TagCache)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Long) > 60000L) {
          this.jdField_a_of_type_JavaUtilList.remove(i);
        }
        i -= 1;
      }
    }
  }
  
  public CacheData.TagCache a()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (localList.size() > 0)) {
      return (CacheData.TagCache)this.jdField_a_of_type_JavaUtilList.get(0);
    }
    return null;
  }
  
  public CacheData.TagCache a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilList != null))
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        if (paramString.equals(((CacheData.TagCache)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString))
        {
          paramString = (CacheData.TagCache)this.jdField_a_of_type_JavaUtilList.get(i);
          this.jdField_a_of_type_JavaUtilList.remove(i);
          break label89;
        }
        i += 1;
      }
    }
    paramString = null;
    label89:
    if (paramString != null) {
      this.jdField_a_of_type_JavaUtilList.add(0, paramString);
    }
    return paramString;
  }
  
  public void a(CacheData.TagCache paramTagCache, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.b = paramBoolean2;
    this.jdField_a_of_type_Int = paramInt;
    a();
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.remove(paramTagCache);
    if (paramTagCache != null)
    {
      if (paramTagCache.jdField_a_of_type_JavaUtilList.size() == 0) {
        return;
      }
      this.jdField_a_of_type_JavaUtilList.add(0, paramTagCache);
      while ((a() > 500) && (this.jdField_a_of_type_JavaUtilList.size() > 1))
      {
        paramTagCache = this.jdField_a_of_type_JavaUtilList;
        paramTagCache.remove(paramTagCache.size() - 1);
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("mProfileComplete");
    localStringBuilder.append("=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(" ");
    localStringBuilder.append("mProfileComplete");
    localStringBuilder.append("=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(" ");
    localStringBuilder.append("mShowCard");
    localStringBuilder.append("=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" ");
    localStringBuilder.append("mMaxLikeCount");
    localStringBuilder.append("=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" ");
    localStringBuilder.append("mTags");
    localStringBuilder.append("=");
    localStringBuilder.append(" [");
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        CacheData.TagCache localTagCache = (CacheData.TagCache)this.jdField_a_of_type_JavaUtilList.get(i);
        localStringBuilder.append("\n");
        localStringBuilder.append("index_");
        localStringBuilder.append(i);
        localStringBuilder.append("=");
        localStringBuilder.append(localTagCache.toString());
        i += 1;
      }
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.bean.feed.CacheData
 * JD-Core Version:    0.7.0.1
 */