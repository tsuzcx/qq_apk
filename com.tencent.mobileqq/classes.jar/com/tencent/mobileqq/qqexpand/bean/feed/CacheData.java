package com.tencent.mobileqq.qqexpand.bean.feed;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CacheData
{
  public List<CacheData.TagCache> a;
  public boolean b;
  public boolean c;
  public int d;
  
  private void b()
  {
    if (this.a != null)
    {
      long l = System.currentTimeMillis();
      int i = this.a.size() - 1;
      while (i >= 0)
      {
        if (Math.abs(l - ((CacheData.TagCache)this.a.get(i)).b) > 60000L) {
          this.a.remove(i);
        }
        i -= 1;
      }
    }
  }
  
  private int c()
  {
    Object localObject = this.a;
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
        i += ((CacheData.TagCache)((Iterator)localObject).next()).a.size();
      }
    }
    return j;
  }
  
  public CacheData.TagCache a()
  {
    List localList = this.a;
    if ((localList != null) && (localList.size() > 0)) {
      return (CacheData.TagCache)this.a.get(0);
    }
    return null;
  }
  
  public CacheData.TagCache a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.a != null))
    {
      int i = 0;
      while (i < this.a.size())
      {
        if (paramString.equals(((CacheData.TagCache)this.a.get(i)).e))
        {
          paramString = (CacheData.TagCache)this.a.get(i);
          this.a.remove(i);
          break label89;
        }
        i += 1;
      }
    }
    paramString = null;
    label89:
    if (paramString != null) {
      this.a.add(0, paramString);
    }
    return paramString;
  }
  
  public void a(CacheData.TagCache paramTagCache, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this.b = paramBoolean1;
    this.c = paramBoolean2;
    this.d = paramInt;
    b();
    if (this.a == null) {
      this.a = new ArrayList();
    }
    this.a.remove(paramTagCache);
    if (paramTagCache != null)
    {
      if (paramTagCache.a.size() == 0) {
        return;
      }
      this.a.add(0, paramTagCache);
      while ((c() > 500) && (this.a.size() > 1))
      {
        paramTagCache = this.a;
        paramTagCache.remove(paramTagCache.size() - 1);
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("mProfileComplete");
    localStringBuilder.append("=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" ");
    localStringBuilder.append("mProfileComplete");
    localStringBuilder.append("=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" ");
    localStringBuilder.append("mShowCard");
    localStringBuilder.append("=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" ");
    localStringBuilder.append("mMaxLikeCount");
    localStringBuilder.append("=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" ");
    localStringBuilder.append("mTags");
    localStringBuilder.append("=");
    localStringBuilder.append(" [");
    if (this.a != null)
    {
      int i = 0;
      while (i < this.a.size())
      {
        CacheData.TagCache localTagCache = (CacheData.TagCache)this.a.get(i);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.bean.feed.CacheData
 * JD-Core Version:    0.7.0.1
 */