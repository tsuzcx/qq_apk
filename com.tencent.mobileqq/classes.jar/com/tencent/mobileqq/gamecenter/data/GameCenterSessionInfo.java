package com.tencent.mobileqq.gamecenter.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
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
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  GameCenterSessionInfo.SimpleMessage[] jdField_a_of_type_ArrayOfComTencentMobileqqGamecenterDataGameCenterSessionInfo$SimpleMessage = new GameCenterSessionInfo.SimpleMessage[0];
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long;
  String jdField_b_of_type_JavaLangString;
  int jdField_c_of_type_Int;
  long jdField_c_of_type_Long;
  String jdField_c_of_type_JavaLangString;
  int jdField_d_of_type_Int;
  long jdField_d_of_type_Long;
  String jdField_d_of_type_JavaLangString;
  int jdField_e_of_type_Int;
  String jdField_e_of_type_JavaLangString;
  String f;
  String g;
  String h;
  String i;
  String j;
  String k;
  String l;
  String m;
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(@NonNull GameCenterSessionInfo paramGameCenterSessionInfo)
  {
    if (paramGameCenterSessionInfo.jdField_b_of_type_Long > this.jdField_b_of_type_Long) {
      return 1;
    }
    if (paramGameCenterSessionInfo.jdField_b_of_type_Long < this.jdField_b_of_type_Long) {
      return -1;
    }
    return 0;
  }
  
  public long a()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public String a()
  {
    return this.m;
  }
  
  public List<GameCenterSessionInfo.SimpleMessage> a()
  {
    try
    {
      List localList = Arrays.asList(this.jdField_a_of_type_ArrayOfComTencentMobileqqGamecenterDataGameCenterSessionInfo$SimpleMessage);
      return localList;
    }
    finally {}
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("sessionType", this.jdField_a_of_type_Int);
      localJSONObject.put("sessionId", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("conversationType", this.jdField_b_of_type_Int);
      localJSONObject.put("gameId", this.jdField_b_of_type_JavaLangString);
      localJSONObject.put("gameName", f());
      localJSONObject.put("faceUrl", this.jdField_d_of_type_JavaLangString);
      localJSONObject.put("nickName", h());
      localJSONObject.put("firstMsg", new QQText(this.h, 6, 32, -1).toPlainText());
      localJSONObject.put("firstMsgTime", this.jdField_a_of_type_Long);
      localJSONObject.put("requestCount", this.jdField_c_of_type_Int);
      localJSONObject.put("lastMsg", new QQText(this.i, 6, 32, -1).toPlainText());
      localJSONObject.put("lastMsgTime", this.jdField_b_of_type_Long);
      localJSONObject.put("unreadMsg", this.jdField_d_of_type_Int);
      localJSONObject.put("onlineType", this.jdField_e_of_type_Int);
      localJSONObject.put("onlineDesc", this.l);
      localJSONObject.put("gameIcon", this.m);
      localJSONObject.put("fromTinyId", this.jdField_c_of_type_Long);
      localJSONObject.put("toTinyId", this.jdField_d_of_type_Long);
      localJSONObject.put("fromRoleId", this.j);
      localJSONObject.put("toRoleId", this.k);
      localJSONObject.put("qqUin", this.f);
      localJSONObject.put("qqNick", this.g);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("GameCenterSessionInfo", 1, localJSONException, new Object[0]);
    }
    return localJSONObject;
  }
  
  public void a()
  {
    this.jdField_c_of_type_Int += 1;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    try
    {
      paramQQAppInterface = paramQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int, this.jdField_d_of_type_Int);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0)) {
        try
        {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqGamecenterDataGameCenterSessionInfo$SimpleMessage = new GameCenterSessionInfo.SimpleMessage[paramQQAppInterface.size()];
          int n = 0;
          while (n < paramQQAppInterface.size())
          {
            this.jdField_a_of_type_ArrayOfComTencentMobileqqGamecenterDataGameCenterSessionInfo$SimpleMessage[n] = new GameCenterSessionInfo.SimpleMessage(((MessageRecord)paramQQAppInterface.get(n)).time, ((MessageRecord)paramQQAppInterface.get(n)).msg);
            n += 1;
          }
          return;
        }
        finally {}
      }
      try
      {
        if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqGamecenterDataGameCenterSessionInfo$SimpleMessage != null) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqGamecenterDataGameCenterSessionInfo$SimpleMessage.length != 0)) {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqGamecenterDataGameCenterSessionInfo$SimpleMessage = new GameCenterSessionInfo.SimpleMessage[0];
        }
        return;
      }
      finally {}
      return;
    }
    catch (Throwable paramQQAppInterface) {}
  }
  
  public void a(String paramString)
  {
    this.m = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int b()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public String b()
  {
    return this.k;
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public void b(String paramString)
  {
    this.k = paramString;
  }
  
  public int c()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public String c()
  {
    return this.j;
  }
  
  public void c(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void c(long paramLong)
  {
    this.jdField_c_of_type_Long = paramLong;
  }
  
  public void c(String paramString)
  {
    this.l = paramString;
  }
  
  public String d()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void d(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void d(long paramLong)
  {
    this.jdField_d_of_type_Long = paramLong;
  }
  
  public void d(String paramString)
  {
    this.j = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String e()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void e(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
  }
  
  public void e(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public String f()
  {
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      this.jdField_c_of_type_JavaLangString = "QQ手游";
    }
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void f(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public String g()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public void g(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public String h()
  {
    if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
      this.jdField_e_of_type_JavaLangString = "游戏好友";
    }
    return this.jdField_e_of_type_JavaLangString;
  }
  
  public void h(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
  }
  
  public String i()
  {
    return this.i;
  }
  
  public void i(String paramString)
  {
    this.jdField_e_of_type_JavaLangString = paramString;
  }
  
  public void j(String paramString)
  {
    this.g = paramString;
  }
  
  public void k(String paramString)
  {
    this.f = paramString;
  }
  
  public void l(String paramString)
  {
    this.h = paramString;
  }
  
  public void m(String paramString)
  {
    this.i = paramString;
  }
  
  public String toString()
  {
    return "GameCenterSessionInfo{sessionType=" + this.jdField_a_of_type_Int + ", sessionId='" + this.jdField_a_of_type_JavaLangString + '\'' + ", gameId='" + this.jdField_b_of_type_JavaLangString + '\'' + ", gameName='" + this.jdField_c_of_type_JavaLangString + '\'' + ", faceUrl='" + this.jdField_d_of_type_JavaLangString + '\'' + ", nickName='" + this.jdField_e_of_type_JavaLangString + '\'' + ", firstMsg='" + this.h + '\'' + ", firstMsgTime=" + this.jdField_a_of_type_Long + ", requestCount=" + this.jdField_c_of_type_Int + ", lastMsg='" + this.i + '\'' + ", lastMsgTime=" + this.jdField_b_of_type_Long + ", unreadMsg=" + this.jdField_d_of_type_Int + ", onlienType=" + this.jdField_e_of_type_Int + ", roleId='" + this.j + '\'' + ", myRoleId='" + this.k + '\'' + ", onLineDesc='" + this.l + '\'' + ", gameIcon='" + this.m + '\'' + ", fromTinyId='" + this.jdField_c_of_type_Long + '\'' + ", toTinyId='" + this.jdField_d_of_type_Long + '\'' + ", qqUin='" + this.f + '\'' + ", qqNick='" + this.g + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeString(this.i);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeInt(this.jdField_e_of_type_Int);
    paramParcel.writeString(this.j);
    paramParcel.writeString(this.k);
    paramParcel.writeString(this.l);
    paramParcel.writeString(this.m);
    paramParcel.writeLong(this.jdField_c_of_type_Long);
    paramParcel.writeLong(this.jdField_d_of_type_Long);
    try
    {
      paramParcel.writeParcelableArray(this.jdField_a_of_type_ArrayOfComTencentMobileqqGamecenterDataGameCenterSessionInfo$SimpleMessage, 0);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo
 * JD-Core Version:    0.7.0.1
 */