package com.tencent.mobileqq.gamecenter.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import avbv;
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
  public static final Parcelable.Creator<GameCenterSessionInfo> CREATOR = new avbv();
  public int a;
  public long a;
  public String a;
  boolean a;
  public GameCenterSessionInfo.SimpleMessage[] a;
  public int b;
  public long b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  
  public GameCenterSessionInfo()
  {
    this.jdField_a_of_type_ArrayOfComTencentMobileqqGamecenterDataGameCenterSessionInfo$SimpleMessage = new GameCenterSessionInfo.SimpleMessage[0];
  }
  
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
    return this.k;
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
      localJSONObject.put("firstMsg", new QQText(this.f, 6, 32, -1).toPlainText());
      localJSONObject.put("firstMsgTime", this.jdField_a_of_type_Long);
      localJSONObject.put("requestCount", this.jdField_c_of_type_Int);
      localJSONObject.put("lastMsg", new QQText(this.g, 6, 32, -1).toPlainText());
      localJSONObject.put("lastMsgTime", this.jdField_b_of_type_Long);
      localJSONObject.put("unreadMsg", this.jdField_d_of_type_Int);
      localJSONObject.put("onlineType", this.jdField_e_of_type_Int);
      localJSONObject.put("onlineDesc", this.j);
      localJSONObject.put("gameIcon", this.k);
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
    paramQQAppInterface = paramQQAppInterface.getMessageFacade().getMessages(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int, this.jdField_d_of_type_Int);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0)) {
      try
      {
        this.jdField_a_of_type_ArrayOfComTencentMobileqqGamecenterDataGameCenterSessionInfo$SimpleMessage = new GameCenterSessionInfo.SimpleMessage[paramQQAppInterface.size()];
        int m = 0;
        while (m < paramQQAppInterface.size())
        {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqGamecenterDataGameCenterSessionInfo$SimpleMessage[m] = new GameCenterSessionInfo.SimpleMessage(((MessageRecord)paramQQAppInterface.get(m)).time, ((MessageRecord)paramQQAppInterface.get(m)).msg);
          m += 1;
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
  }
  
  public void a(String paramString)
  {
    this.k = paramString;
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
    return this.i;
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
    this.i = paramString;
  }
  
  public int c()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public String c()
  {
    return this.h;
  }
  
  public void c(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void c(String paramString)
  {
    this.j = paramString;
  }
  
  public String d()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void d(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void d(String paramString)
  {
    this.h = paramString;
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
    return this.g;
  }
  
  public void i(String paramString)
  {
    this.jdField_e_of_type_JavaLangString = paramString;
  }
  
  public void j(String paramString)
  {
    this.f = paramString;
  }
  
  public void k(String paramString)
  {
    this.g = paramString;
  }
  
  public String toString()
  {
    return "GameCenterSessionInfo{sessionType=" + this.jdField_a_of_type_Int + ", sessionId='" + this.jdField_a_of_type_JavaLangString + '\'' + ", gameId='" + this.jdField_b_of_type_JavaLangString + '\'' + ", gameName='" + this.jdField_c_of_type_JavaLangString + '\'' + ", faceUrl='" + this.jdField_d_of_type_JavaLangString + '\'' + ", nickName='" + this.jdField_e_of_type_JavaLangString + '\'' + ", firstMsg='" + this.f + '\'' + ", firstMsgTime=" + this.jdField_a_of_type_Long + ", requestCount=" + this.jdField_c_of_type_Int + ", lastMsg='" + this.g + '\'' + ", lastMsgTime=" + this.jdField_b_of_type_Long + ", unreadMsg=" + this.jdField_d_of_type_Int + ", onlienType=" + this.jdField_e_of_type_Int + ", roleId='" + this.h + '\'' + ", myRoleId='" + this.i + '\'' + ", onLineDesc='" + this.j + '\'' + ", gameIcon='" + this.k + '\'' + '}';
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
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeString(this.g);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeInt(this.jdField_e_of_type_Int);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeString(this.j);
    paramParcel.writeString(this.k);
    try
    {
      paramParcel.writeParcelableArray(this.jdField_a_of_type_ArrayOfComTencentMobileqqGamecenterDataGameCenterSessionInfo$SimpleMessage, 0);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo
 * JD-Core Version:    0.7.0.1
 */