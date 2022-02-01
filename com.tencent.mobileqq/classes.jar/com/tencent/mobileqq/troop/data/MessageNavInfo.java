package com.tencent.mobileqq.troop.data;

import com.tencent.imcore.message.InitMsgModule;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageNavInfo
{
  public static MessageNavInfo.Callback a;
  public int a;
  public long a;
  public long b;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo$Callback = new MessageNavInfoDummyCallback();
    InitMsgModule.a();
  }
  
  public MessageNavInfo()
  {
    a();
  }
  
  public MessageNavInfo(MessageNavInfo paramMessageNavInfo)
  {
    a(paramMessageNavInfo);
  }
  
  private int a(AppRuntime paramAppRuntime, String paramString, int paramInt)
  {
    return jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo$Callback.a(paramAppRuntime, paramString, paramInt);
  }
  
  public static void a(MessageNavInfo.Callback paramCallback)
  {
    jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo$Callback = paramCallback;
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 13) || (paramInt == 24) || (paramInt == 12) || (paramInt == 20) || (paramInt == 22);
  }
  
  public static boolean a(int paramInt1, long paramLong1, int paramInt2, long paramLong2)
  {
    return (paramLong2 != -1L) && ((paramLong1 == -1L) || ((paramInt1 == paramInt2) && (paramLong1 > paramLong2)) || ((paramInt1 != paramInt2) && (MessageInfo.a(paramInt2, paramInt1))));
  }
  
  public String a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("biz_type", this.jdField_a_of_type_Int);
      localJSONObject.put("shmsgseq", this.jdField_a_of_type_Long);
      localJSONObject.put("uniseq", this.b);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject.toString();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = -1L;
    this.b = -1L;
  }
  
  public void a(int paramInt, long paramLong)
  {
    if ((this.jdField_a_of_type_Int == paramInt) && (this.jdField_a_of_type_Long != -1L))
    {
      this.b = paramLong;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateMsgSeq, preBizType = ");
        localStringBuilder.append(this.jdField_a_of_type_Int);
        localStringBuilder.append(", newBizType = ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(", msgSeq = ");
        localStringBuilder.append(paramLong);
        QLog.d("Navigate.MessageNavInfo", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void a(MessageNavInfo paramMessageNavInfo)
  {
    if (paramMessageNavInfo != null)
    {
      this.jdField_a_of_type_Int = paramMessageNavInfo.jdField_a_of_type_Int;
      this.jdField_a_of_type_Long = paramMessageNavInfo.jdField_a_of_type_Long;
      this.b = paramMessageNavInfo.b;
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.jdField_a_of_type_Int = paramString.optInt("biz_type");
      this.jdField_a_of_type_Long = paramString.getLong("shmsgseq");
      this.b = paramString.getLong("uniseq");
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Long != -1L;
  }
  
  public boolean a(int paramInt, long paramLong)
  {
    return a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, paramInt, paramLong);
  }
  
  public boolean a(int paramInt, long paramLong1, long paramLong2)
  {
    boolean bool = a(paramInt, paramLong1);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("update, preBizType = ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
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
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_Long = paramLong1;
      this.b = paramLong2;
      return true;
    }
    return false;
  }
  
  public boolean a(MessageNavInfo paramMessageNavInfo)
  {
    if (paramMessageNavInfo == null) {
      return false;
    }
    return a(paramMessageNavInfo.jdField_a_of_type_Int, paramMessageNavInfo.jdField_a_of_type_Long, paramMessageNavInfo.b);
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
  
  public void b(int paramInt, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateShMsgSeq, preBizType = ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(", newBizType = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", newShMsgSeq = ");
      localStringBuilder.append(paramLong);
      QLog.d("Navigate.MessageNavInfo", 2, localStringBuilder.toString());
    }
    int i = this.jdField_a_of_type_Int;
    if ((i != 0) && (i != paramInt)) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public boolean b(int paramInt)
  {
    return this.jdField_a_of_type_Int == paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.MessageNavInfo
 * JD-Core Version:    0.7.0.1
 */