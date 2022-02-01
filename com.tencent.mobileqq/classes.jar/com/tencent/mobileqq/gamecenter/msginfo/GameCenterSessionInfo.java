package com.tencent.mobileqq.gamecenter.msginfo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class GameCenterSessionInfo
  implements Parcelable, Comparable<GameCenterSessionInfo>
{
  public static final Parcelable.Creator<GameCenterSessionInfo> CREATOR = new GameCenterSessionInfo.1();
  int a;
  String b;
  int c;
  String d;
  String e;
  String f;
  String g;
  String h;
  String i;
  String j;
  long k;
  int l;
  String m;
  long n;
  int o;
  int p;
  String q;
  String r;
  String s;
  String t;
  boolean u;
  long v;
  long w;
  GameCenterSessionInfo.SimpleMessage[] x = new GameCenterSessionInfo.SimpleMessage[0];
  
  public int a(@NonNull GameCenterSessionInfo paramGameCenterSessionInfo)
  {
    long l1 = paramGameCenterSessionInfo.n;
    long l2 = this.n;
    if (l1 > l2) {
      return 1;
    }
    if (l1 < l2) {
      return -1;
    }
    return 0;
  }
  
  public String a()
  {
    return this.t;
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.k = paramLong;
  }
  
  public void a(AppInterface paramAppInterface)
  {
    paramAppInterface = ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "")).getMessages(this.b, this.c, this.o);
    int i1 = 0;
    if ((paramAppInterface != null) && (paramAppInterface.size() > 0)) {
      try
      {
        this.x = new GameCenterSessionInfo.SimpleMessage[paramAppInterface.size()];
        while (i1 < paramAppInterface.size())
        {
          this.x[i1] = new GameCenterSessionInfo.SimpleMessage(((MessageRecord)paramAppInterface.get(i1)).time, ((MessageRecord)paramAppInterface.get(i1)).msg);
          i1 += 1;
        }
        return;
      }
      finally {}
    }
    try
    {
      if ((this.x != null) && (this.x.length != 0)) {
        this.x = new GameCenterSessionInfo.SimpleMessage[0];
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramAppInterface;
    }
  }
  
  public void a(String paramString)
  {
    this.t = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.u = paramBoolean;
  }
  
  public String b()
  {
    return this.r;
  }
  
  public void b(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void b(long paramLong)
  {
    this.n = paramLong;
  }
  
  public void b(String paramString)
  {
    this.r = paramString;
  }
  
  public void c()
  {
    this.l += 1;
  }
  
  public void c(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void c(long paramLong)
  {
    this.v = paramLong;
  }
  
  public void c(String paramString)
  {
    this.s = paramString;
  }
  
  public List<GameCenterSessionInfo.SimpleMessage> d()
  {
    try
    {
      List localList = Arrays.asList(this.x);
      return localList;
    }
    finally {}
  }
  
  public void d(int paramInt)
  {
    this.o = paramInt;
  }
  
  public void d(long paramLong)
  {
    this.w = paramLong;
  }
  
  public void d(String paramString)
  {
    this.q = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String e()
  {
    return this.q;
  }
  
  public void e(int paramInt)
  {
    this.p = paramInt;
  }
  
  public void e(String paramString)
  {
    this.b = paramString;
  }
  
  public int f()
  {
    return this.a;
  }
  
  public void f(String paramString)
  {
    this.d = paramString;
  }
  
  public String g()
  {
    return this.b;
  }
  
  public void g(String paramString)
  {
    this.e = paramString;
  }
  
  public String h()
  {
    return this.d;
  }
  
  public void h(String paramString)
  {
    this.f = paramString;
  }
  
  public String i()
  {
    if (TextUtils.isEmpty(this.e)) {
      this.e = "QQ手游";
    }
    return this.e;
  }
  
  public void i(String paramString)
  {
    this.g = paramString;
  }
  
  public String j()
  {
    return this.f;
  }
  
  public void j(String paramString)
  {
    this.i = paramString;
  }
  
  public String k()
  {
    if (TextUtils.isEmpty(this.g)) {
      this.g = "游戏好友";
    }
    return this.g;
  }
  
  public void k(String paramString)
  {
    this.h = paramString;
  }
  
  public int l()
  {
    return this.l;
  }
  
  public void l(String paramString)
  {
    this.j = paramString;
  }
  
  public String m()
  {
    return this.m;
  }
  
  public void m(String paramString)
  {
    this.m = paramString;
  }
  
  public long n()
  {
    return this.n;
  }
  
  public int o()
  {
    return this.o;
  }
  
  public JSONObject p()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("sessionType", this.a);
      localJSONObject.put("sessionId", this.b);
      localJSONObject.put("conversationType", this.c);
      localJSONObject.put("gameId", this.d);
      localJSONObject.put("gameName", i());
      localJSONObject.put("faceUrl", this.f);
      localJSONObject.put("nickName", k());
      localJSONObject.put("firstMsg", new QQText(this.j, 6, 32, -1).toPlainText());
      localJSONObject.put("firstMsgTime", this.k);
      localJSONObject.put("requestCount", this.l);
      localJSONObject.put("lastMsg", new QQText(this.m, 6, 32, -1).toPlainText());
      localJSONObject.put("lastMsgTime", this.n);
      localJSONObject.put("unreadMsg", this.o);
      localJSONObject.put("onlineType", this.p);
      localJSONObject.put("onlineDesc", this.s);
      localJSONObject.put("gameIcon", this.t);
      localJSONObject.put("fromTinyId", this.v);
      localJSONObject.put("toTinyId", this.w);
      localJSONObject.put("fromRoleId", this.q);
      localJSONObject.put("toRoleId", this.r);
      localJSONObject.put("qqUin", this.h);
      localJSONObject.put("qqNick", this.i);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("GameCenterSessionInfo", 1, localJSONException.getMessage());
    }
    return localJSONObject;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GameCenterSessionInfo{sessionType=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", sessionId='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", gameId='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", gameName='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", faceUrl='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", nickName='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", firstMsg='");
    localStringBuilder.append(this.j);
    localStringBuilder.append('\'');
    localStringBuilder.append(", firstMsgTime=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", requestCount=");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", lastMsg='");
    localStringBuilder.append(this.m);
    localStringBuilder.append('\'');
    localStringBuilder.append(", lastMsgTime=");
    localStringBuilder.append(this.n);
    localStringBuilder.append(", unreadMsg=");
    localStringBuilder.append(this.o);
    localStringBuilder.append(", onlienType=");
    localStringBuilder.append(this.p);
    localStringBuilder.append(", roleId='");
    localStringBuilder.append(this.q);
    localStringBuilder.append('\'');
    localStringBuilder.append(", myRoleId='");
    localStringBuilder.append(this.r);
    localStringBuilder.append('\'');
    localStringBuilder.append(", onLineDesc='");
    localStringBuilder.append(this.s);
    localStringBuilder.append('\'');
    localStringBuilder.append(", gameIcon='");
    localStringBuilder.append(this.t);
    localStringBuilder.append('\'');
    localStringBuilder.append(", fromTinyId='");
    localStringBuilder.append(this.v);
    localStringBuilder.append('\'');
    localStringBuilder.append(", toTinyId='");
    localStringBuilder.append(this.w);
    localStringBuilder.append('\'');
    localStringBuilder.append(", qqUin='");
    localStringBuilder.append(this.h);
    localStringBuilder.append('\'');
    localStringBuilder.append(", qqNick='");
    localStringBuilder.append(this.i);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeString(this.j);
    paramParcel.writeLong(this.k);
    paramParcel.writeInt(this.l);
    paramParcel.writeString(this.m);
    paramParcel.writeLong(this.n);
    paramParcel.writeInt(this.o);
    paramParcel.writeInt(this.p);
    paramParcel.writeString(this.q);
    paramParcel.writeString(this.r);
    paramParcel.writeString(this.s);
    paramParcel.writeString(this.t);
    paramParcel.writeLong(this.v);
    paramParcel.writeLong(this.w);
    try
    {
      paramParcel.writeParcelableArray(this.x, 0);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.msginfo.GameCenterSessionInfo
 * JD-Core Version:    0.7.0.1
 */