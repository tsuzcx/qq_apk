package com.tencent.mobileqq.qqexpand.bean.match;

import android.text.TextUtils;
import com.tencent.mobileqq.qqexpand.bean.chat.ChatFriendInfo;
import com.tencent.mobileqq.util.Utils;

public class MatchInfo
{
  public String a = "";
  public byte[] b;
  public String c = "";
  public String d = "";
  public long e = -1L;
  public int f = 30;
  public String g = "";
  public String h = "0";
  public int i = 1;
  public String j = "";
  public ChatFriendInfo k;
  
  public void a()
  {
    this.a = "";
    this.b = Utils.h("");
    this.c = "";
    this.d = "";
    this.e = -1L;
    this.f = -1;
    this.h = "0";
    this.i = 0;
    this.j = "";
    this.k = null;
  }
  
  public boolean b()
  {
    String str = Utils.b(this.b);
    return (!TextUtils.isEmpty(this.c)) && (!TextUtils.isEmpty(this.c)) && (!TextUtils.isEmpty(str));
  }
  
  public MatchInfo c()
  {
    MatchInfo localMatchInfo = new MatchInfo();
    localMatchInfo.a = this.a;
    localMatchInfo.b = ((byte[])this.b.clone());
    localMatchInfo.c = this.c;
    localMatchInfo.d = this.d;
    localMatchInfo.e = this.e;
    localMatchInfo.f = this.f;
    localMatchInfo.h = this.h;
    return localMatchInfo;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = TextUtils.isEmpty(this.a);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      if (TextUtils.isEmpty(this.c)) {
        return false;
      }
      bool1 = bool2;
      if ((paramObject instanceof MatchInfo))
      {
        paramObject = (MatchInfo)paramObject;
        bool1 = bool2;
        if (this.a.equals(paramObject.a))
        {
          bool1 = bool2;
          if (this.c.equals(paramObject.c))
          {
            bool1 = bool2;
            if (this.e == paramObject.e) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{uin: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append("}");
    Object localObject = Utils.b(this.b);
    int m;
    if (localObject != null) {
      m = ((String)localObject).length();
    } else {
      m = 0;
    }
    localStringBuilder.append("{sig: ");
    localStringBuilder.append(m);
    localStringBuilder.append("}");
    localStringBuilder.append("{matchUin: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append("}");
    localStringBuilder.append("{tipsWording: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append("}");
    localStringBuilder.append("{timeStamp: ");
    localStringBuilder.append(this.e);
    localStringBuilder.append("}");
    localStringBuilder.append("{nickName: ");
    localStringBuilder.append(this.g);
    localStringBuilder.append("}");
    localStringBuilder.append("{algorithmID: ");
    localStringBuilder.append(this.h);
    localStringBuilder.append("}");
    localStringBuilder.append("{tagId: ");
    localStringBuilder.append(this.i);
    localStringBuilder.append("}");
    localStringBuilder.append("{tagName: ");
    localStringBuilder.append(this.j);
    localStringBuilder.append("}");
    localObject = this.k;
    if (localObject != null) {
      localStringBuilder.append(((ChatFriendInfo)localObject).toString());
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.bean.match.MatchInfo
 * JD-Core Version:    0.7.0.1
 */