package com.tencent.mobileqq.kandian.repo.comment.entity;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import java.math.BigInteger;

public class RIJBiuAndCommentRespData
{
  private int a;
  private String b;
  private String c;
  private int d;
  private String e;
  private int f;
  private String g;
  private String h;
  private String i;
  private AbsBaseArticleInfo j;
  private int k;
  private int l;
  private int m;
  private boolean n;
  private String o;
  private String p;
  private String q;
  
  public int a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    this.j = paramAbsBaseArticleInfo;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void b(String paramString)
  {
    this.c = paramString;
  }
  
  public int c()
  {
    return this.d;
  }
  
  public void c(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void c(String paramString)
  {
    this.i = paramString;
  }
  
  public String d()
  {
    return this.i;
  }
  
  public void d(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void d(String paramString)
  {
    this.e = paramString;
  }
  
  public long e()
  {
    if (!TextUtils.isEmpty(this.c)) {
      return new BigInteger(this.c).longValue();
    }
    return 0L;
  }
  
  public void e(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void e(String paramString)
  {
    this.o = paramString;
  }
  
  public AbsBaseArticleInfo f()
  {
    return this.j;
  }
  
  public void f(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void f(String paramString)
  {
    this.p = paramString;
  }
  
  public String g()
  {
    return this.e;
  }
  
  public void g(String paramString)
  {
    this.q = paramString;
  }
  
  public int h()
  {
    return this.l;
  }
  
  public void h(String paramString)
  {
    this.g = paramString;
  }
  
  public void i(String paramString)
  {
    this.h = paramString;
  }
  
  public boolean i()
  {
    return this.n;
  }
  
  public String j()
  {
    return this.o;
  }
  
  public String k()
  {
    return this.q;
  }
  
  public int l()
  {
    return this.f;
  }
  
  public String m()
  {
    return this.g;
  }
  
  public String n()
  {
    return this.h;
  }
  
  public int o()
  {
    return this.k;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RIJBiuAndCommentRespData{mResultCode=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mCommentId='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mFeedsId='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mFeedsType=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", mCommentString='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mCommentShareUrl='");
    localStringBuilder.append(this.i);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mCardAvailable=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", mCardJumpUrl='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mCommentBtnUrl='");
    localStringBuilder.append(this.h);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mArticleInfo=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", mContentSrc=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", mCommentType=");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", mListShowType=");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", mIsSecondReply=");
    localStringBuilder.append(this.n);
    localStringBuilder.append(", mReplyCommentId='");
    localStringBuilder.append(this.o);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mReplyUin='");
    localStringBuilder.append(this.q);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.comment.entity.RIJBiuAndCommentRespData
 * JD-Core Version:    0.7.0.1
 */