package com.tencent.mobileqq.kandian.base.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.CodedInputStreamMicro;
import com.tencent.mobileqq.pb.CodedOutputStreamMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class RIJPBFieldUtils
{
  public static int a(PBEnumField paramPBEnumField)
  {
    if (paramPBEnumField.has()) {
      return paramPBEnumField.get();
    }
    return 0;
  }
  
  public static int a(PBEnumField paramPBEnumField, int paramInt)
  {
    if (paramPBEnumField.has()) {
      return paramPBEnumField.get();
    }
    return paramInt;
  }
  
  public static int a(PBInt32Field paramPBInt32Field, int paramInt)
  {
    if (paramPBInt32Field.has()) {
      return paramPBInt32Field.get();
    }
    return paramInt;
  }
  
  public static int a(PBUInt32Field paramPBUInt32Field)
  {
    if (paramPBUInt32Field.has()) {
      return paramPBUInt32Field.get();
    }
    return 0;
  }
  
  public static int a(PBUInt32Field paramPBUInt32Field, int paramInt)
  {
    if (paramPBUInt32Field.has()) {
      return paramPBUInt32Field.get();
    }
    return paramInt;
  }
  
  public static long a(PBInt64Field paramPBInt64Field)
  {
    if (paramPBInt64Field.has()) {
      return paramPBInt64Field.get();
    }
    return 0L;
  }
  
  public static long a(PBUInt64Field paramPBUInt64Field)
  {
    if (paramPBUInt64Field.has()) {
      return paramPBUInt64Field.get();
    }
    return 0L;
  }
  
  public static long a(PBUInt64Field paramPBUInt64Field, long paramLong)
  {
    if (paramPBUInt64Field.has()) {
      return paramPBUInt64Field.get();
    }
    return paramLong;
  }
  
  public static <T extends MessageMicro<T>> T a(T paramT)
  {
    if (paramT.has()) {
      return paramT.get();
    }
    return null;
  }
  
  public static <T extends MessageMicro<T>> T a(byte[] paramArrayOfByte, T paramT)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
      try
      {
        paramT.mergeFrom(paramArrayOfByte);
        return paramT;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("postRead_mergeFrom");
          localStringBuilder.append(QLog.getStackTraceString(paramArrayOfByte));
          QLog.e("Q.readinjoy.RIJPBFieldUtils", 2, localStringBuilder.toString());
        }
        return paramT;
      }
    }
    return null;
  }
  
  public static <T extends MessageMicro<T>> PBRepeatMessageField<T> a(byte[] paramArrayOfByte, Class<T> paramClass)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length <= 0) {
        return null;
      }
      CodedInputStreamMicro localCodedInputStreamMicro = CodedInputStreamMicro.newInstance(paramArrayOfByte);
      paramClass = PBField.initRepeatMessage(paramClass);
      for (;;)
      {
        paramArrayOfByte = paramClass;
        try
        {
          if (!localCodedInputStreamMicro.isAtEnd())
          {
            localCodedInputStreamMicro.readTag();
            paramClass.readFrom(localCodedInputStreamMicro);
          }
        }
        catch (Exception paramArrayOfByte)
        {
          if (QLog.isColorLevel())
          {
            paramClass = new StringBuilder();
            paramClass.append("postRead_readFromStream");
            paramClass.append(QLog.getStackTraceString(paramArrayOfByte));
            QLog.e("Q.readinjoy.RIJPBFieldUtils", 2, paramClass.toString());
          }
          paramArrayOfByte = null;
        }
      }
      return paramArrayOfByte;
    }
    return null;
  }
  
  public static String a(PBBytesField paramPBBytesField)
  {
    if ((paramPBBytesField.has()) && (paramPBBytesField.get() != null)) {
      return paramPBBytesField.get().toStringUtf8();
    }
    return null;
  }
  
  public static String a(PBBytesField paramPBBytesField, String paramString)
  {
    if ((paramPBBytesField.has()) && (paramPBBytesField.get() != null)) {
      return paramPBBytesField.get().toStringUtf8();
    }
    return paramString;
  }
  
  public static String a(PBStringField paramPBStringField)
  {
    if (paramPBStringField.has()) {
      return paramPBStringField.get();
    }
    return null;
  }
  
  public static String a(PBStringField paramPBStringField, String paramString)
  {
    if (paramPBStringField.has()) {
      return paramPBStringField.get();
    }
    return paramString;
  }
  
  public static <T extends MessageMicro<T>> List<T> a(PBRepeatMessageField<T> paramPBRepeatMessageField)
  {
    if (paramPBRepeatMessageField.has()) {
      return paramPBRepeatMessageField.get();
    }
    return null;
  }
  
  public static <T extends MessageMicro<T>> List<T> a(byte[] paramArrayOfByte, Class<T> paramClass)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length <= 0) {
        return null;
      }
      paramArrayOfByte = a(paramArrayOfByte, paramClass);
      if ((paramArrayOfByte != null) && (paramArrayOfByte.has())) {
        return paramArrayOfByte.get();
      }
    }
    return null;
  }
  
  public static void a(PBBytesField paramPBBytesField, String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      paramPBBytesField.set(ByteStringMicro.copyFromUtf8(paramString));
    }
  }
  
  public static void a(PBUInt32Field paramPBUInt32Field, int paramInt)
  {
    if (paramInt != -1) {
      paramPBUInt32Field.set(paramInt);
    }
  }
  
  public static void a(PBUInt64Field paramPBUInt64Field, long paramLong)
  {
    if (paramLong != -1L) {
      paramPBUInt64Field.set(paramLong);
    }
  }
  
  public static boolean a(PBBoolField paramPBBoolField)
  {
    if (paramPBBoolField.has()) {
      return paramPBBoolField.get();
    }
    return false;
  }
  
  public static boolean a(PBBytesField paramPBBytesField)
  {
    return (paramPBBytesField != null) && (paramPBBytesField.has()) && (paramPBBytesField.get() != null);
  }
  
  public static boolean a(PBRepeatMessageField paramPBRepeatMessageField)
  {
    return (paramPBRepeatMessageField != null) && (paramPBRepeatMessageField.has()) && (paramPBRepeatMessageField.get().size() > 0);
  }
  
  public static byte[] a(PBBytesField paramPBBytesField)
  {
    if ((paramPBBytesField.has()) && (paramPBBytesField.get() != null)) {
      return paramPBBytesField.get().toByteArray();
    }
    return null;
  }
  
  public static <T extends MessageMicro<T>> byte[] a(PBRepeatMessageField<T> paramPBRepeatMessageField)
  {
    Object localObject = new ByteArrayOutputStream(paramPBRepeatMessageField.computeSize(1));
    try
    {
      CodedOutputStreamMicro localCodedOutputStreamMicro = CodedOutputStreamMicro.newInstance((OutputStream)localObject);
      paramPBRepeatMessageField.writeTo(localCodedOutputStreamMicro, 1);
      localCodedOutputStreamMicro.flush();
      paramPBRepeatMessageField = ((ByteArrayOutputStream)localObject).toByteArray();
      return paramPBRepeatMessageField;
    }
    catch (IOException paramPBRepeatMessageField)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("writePBToByteArray");
        ((StringBuilder)localObject).append(QLog.getStackTraceString(paramPBRepeatMessageField));
        QLog.e("Q.readinjoy.RIJPBFieldUtils", 2, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  public static <T extends MessageMicro<T>> byte[] a(List<T> paramList, Class<T> paramClass)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramClass = PBField.initRepeatMessage(paramClass);
      paramClass.addAll(paramList);
      return a(paramClass);
    }
    return null;
  }
  
  public static int b(PBEnumField paramPBEnumField, int paramInt)
  {
    if (paramPBEnumField.has()) {
      return paramPBEnumField.get();
    }
    return paramInt;
  }
  
  public static String b(PBBytesField paramPBBytesField)
  {
    if (a(paramPBBytesField)) {
      return paramPBBytesField.get().toStringUtf8();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.RIJPBFieldUtils
 * JD-Core Version:    0.7.0.1
 */