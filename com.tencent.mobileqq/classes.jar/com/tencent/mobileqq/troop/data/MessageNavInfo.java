package com.tencent.mobileqq.troop.data;

import com.tencent.imcore.message.InitMsgModule;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageNavInfo
{
  public static MessageNavInfo.Callback d = new MessageNavInfoDummyCallback();
  public int a;
  public long b;
  public long c;
  
  static
  {
    InitMsgModule.a();
  }
  
  public MessageNavInfo()
  {
    c();
  }
  
  public MessageNavInfo(MessageNavInfo paramMessageNavInfo)
  {
    a(paramMessageNavInfo);
  }
  
  private int a(AppRuntime paramAppRuntime, String paramString, int paramInt)
  {
    return d.a(paramAppRuntime, paramString, paramInt);
  }
  
  public static void a(MessageNavInfo.Callback paramCallback)
  {
    d = paramCallback;
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 13) || (paramInt == 24) || (paramInt == 12) || (paramInt == 20) || (paramInt == 22);
  }
  
  public static boolean a(int paramInt1, long paramLong1, int paramInt2, long paramLong2)
  {
    return (paramLong2 != -1L) && ((paramLong1 == -1L) || ((paramInt1 == paramInt2) && (paramLong1 > paramLong2)) || ((paramInt1 != paramInt2) && (MessageInfo.a(paramInt2, paramInt1))));
  }
  
  public void a(MessageNavInfo paramMessageNavInfo)
  {
    if (paramMessageNavInfo != null)
    {
      this.a = paramMessageNavInfo.a;
      this.b = paramMessageNavInfo.b;
      this.c = paramMessageNavInfo.c;
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.a = paramString.optInt("biz_type");
      this.b = paramString.getLong("shmsgseq");
      this.c = paramString.getLong("uniseq");
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public boolean a()
  {
    return this.b != -1L;
  }
  
  public boolean a(int paramInt, long paramLong)
  {
    return a(this.a, this.b, paramInt, paramLong);
  }
  
  public boolean a(int paramInt, long paramLong1, long paramLong2)
  {
    boolean bool = a(paramInt, paramLong1);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("update, preBizType = ");
      localStringBuilder.append(this.a);
      localStringBuilder.append(", newBizType = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", needUpdate = ");
      localStringBuilder.append(bool);
      localStringBuilder.append(", shmsgseq = ");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(", uniseq = ");
      localStringBuilder.append(paramLong2);
      QLog.d("Navigate.MessageNavInfo", 2, localStringBuilder.toString());
    }
    if (bool)
    {
      this.a = paramInt;
      this.b = paramLong1;
      this.c = paramLong2;
      return true;
    }
    return false;
  }
  
  public boolean a(AppRuntime paramAppRuntime, boolean paramBoolean, String paramString, long paramLong1, long paramLong2)
  {
    int i;
    if ((paramAppRuntime != null) && (paramBoolean)) {
      i = a(paramAppRuntime, paramString, 26);
    } else {
      i = 26;
    }
    return a(i, paramLong1, paramLong2);
  }
  
  public String b()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("biz_type", this.a);
      localJSONObject.put("shmsgseq", this.b);
      localJSONObject.put("uniseq", this.c);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject.toString();
  }
  
  public void b(int paramInt, long paramLong)
  {
    if ((this.a == paramInt) && (this.b != -1L))
    {
      this.c = paramLong;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateMsgSeq, preBizType = ");
        localStringBuilder.append(this.a);
        localStringBuilder.append(", newBizType = ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(", msgSeq = ");
        localStringBuilder.append(paramLong);
        QLog.d("Navigate.MessageNavInfo", 2, localStringBuilder.toString());
      }
    }
  }
  
  public boolean b(int paramInt)
  {
    return this.a == paramInt;
  }
  
  public boolean b(MessageNavInfo paramMessageNavInfo)
  {
    if (paramMessageNavInfo == null) {
      return false;
    }
    return a(paramMessageNavInfo.a, paramMessageNavInfo.b, paramMessageNavInfo.c);
  }
  
  public void c()
  {
    this.a = 0;
    this.b = -1L;
    this.c = -1L;
  }
  
  public void c(int paramInt, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateShMsgSeq, preBizType = ");
      localStringBuilder.append(this.a);
      localStringBuilder.append(", newBizType = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", newShMsgSeq = ");
      localStringBuilder.append(paramLong);
      QLog.d("Navigate.MessageNavInfo", 2, localStringBuilder.toString());
    }
    int i = this.a;
    if ((i != 0) && (i != paramInt)) {
      return;
    }
    this.a = paramInt;
    this.b = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.MessageNavInfo
 * JD-Core Version:    0.7.0.1
 */