package com.tencent.mobileqq.kandian.repo.feeds.preload;

import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.List;

public class FeedsPreloadDataModule$PreloadCache
{
  public ToServiceMsg a;
  public int b;
  public int c;
  public List<AbsBaseArticleInfo> d;
  public List<AbsBaseArticleInfo> e;
  public boolean f;
  public boolean g;
  public byte[] h;
  public String i;
  
  public PreloadCache a()
  {
    PreloadCache localPreloadCache = new PreloadCache();
    localPreloadCache.a(this.a).a(this.b).b(this.c).a(this.d).b(this.e).a(this.f).b(this.g).a(this.h).a(this.i);
    return localPreloadCache;
  }
  
  public PreloadCache a(int paramInt)
  {
    this.b = paramInt;
    return this;
  }
  
  public PreloadCache a(ToServiceMsg paramToServiceMsg)
  {
    this.a = paramToServiceMsg;
    return this;
  }
  
  public PreloadCache a(String paramString)
  {
    this.i = paramString;
    return this;
  }
  
  public PreloadCache a(List<AbsBaseArticleInfo> paramList)
  {
    this.d = paramList;
    return this;
  }
  
  public PreloadCache a(boolean paramBoolean)
  {
    this.f = paramBoolean;
    return this;
  }
  
  public PreloadCache a(byte[] paramArrayOfByte)
  {
    this.h = paramArrayOfByte;
    return this;
  }
  
  public PreloadCache b(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
  
  public PreloadCache b(List<AbsBaseArticleInfo> paramList)
  {
    this.e = paramList;
    return this;
  }
  
  public PreloadCache b(boolean paramBoolean)
  {
    this.g = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.preload.FeedsPreloadDataModule.PreloadCache
 * JD-Core Version:    0.7.0.1
 */