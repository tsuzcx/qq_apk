package com.tencent.mobileqq.qqexpand.bean.feed;

import java.util.ArrayList;
import java.util.List;

public class CacheData$TagCache
{
  public List<StrangerInfo> a = new ArrayList();
  public long b;
  public int c;
  public byte[] d;
  public String e;
  public boolean f;
  public int g;
  public int h;
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramObject != null)
    {
      bool1 = bool2;
      if ((paramObject instanceof TagCache))
      {
        paramObject = ((TagCache)paramObject).e;
        bool1 = bool2;
        if (paramObject != null)
        {
          bool1 = bool2;
          if (this.e.equals(paramObject)) {
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
    localStringBuilder.append(this.b);
    localStringBuilder.append(" ");
    localStringBuilder.append("mUpdateTime");
    localStringBuilder.append("=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" ");
    localStringBuilder.append("mSearchKey");
    localStringBuilder.append("=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" ");
    localStringBuilder.append("mLoadOver");
    localStringBuilder.append("=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(" ");
    localStringBuilder.append("mCurPos");
    localStringBuilder.append("=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(" ");
    localStringBuilder.append("mOffset");
    localStringBuilder.append("=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(" ");
    localStringBuilder.append("size");
    localStringBuilder.append("=");
    localStringBuilder.append(this.a.size());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.bean.feed.CacheData.TagCache
 * JD-Core Version:    0.7.0.1
 */