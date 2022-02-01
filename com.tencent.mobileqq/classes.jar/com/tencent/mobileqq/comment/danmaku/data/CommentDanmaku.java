package com.tencent.mobileqq.comment.danmaku.data;

import android.text.TextUtils;
import com.tencent.mobileqq.comment.DanmuItemBean;

public class CommentDanmaku
{
  public long a;
  public String b;
  public String c;
  public String d;
  public long e;
  public long f;
  public boolean g;
  public String h;
  public int i;
  
  public CommentDanmaku(DanmuItemBean paramDanmuItemBean)
  {
    this.a = paramDanmuItemBean.b;
    this.b = String.valueOf(paramDanmuItemBean.a);
    this.c = paramDanmuItemBean.e;
    this.d = paramDanmuItemBean.d;
    this.e = paramDanmuItemBean.f;
    this.f = paramDanmuItemBean.c;
    this.g = paramDanmuItemBean.g;
    this.h = paramDanmuItemBean.h;
    this.i = paramDanmuItemBean.i;
  }
  
  public String a()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String str;
    if (this.g) {
      str = this.h;
    } else {
      str = this.c;
    }
    localStringBuffer.append(str);
    localStringBuffer.append(" : ");
    localStringBuffer.append(this.d);
    return localStringBuffer.toString();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = paramObject instanceof CommentDanmaku;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramObject = (CommentDanmaku)paramObject;
      bool1 = bool2;
      if (this.a == paramObject.a)
      {
        bool1 = bool2;
        if (this.e == paramObject.e)
        {
          bool1 = bool2;
          if (this.f == paramObject.f)
          {
            bool1 = bool2;
            if (!TextUtils.isEmpty(this.b))
            {
              bool1 = bool2;
              if (!TextUtils.isEmpty(paramObject.b))
              {
                bool1 = bool2;
                if (this.b.equals(paramObject.b)) {
                  bool1 = true;
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return String.valueOf(this.a).hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.comment.danmaku.data.CommentDanmaku
 * JD-Core Version:    0.7.0.1
 */