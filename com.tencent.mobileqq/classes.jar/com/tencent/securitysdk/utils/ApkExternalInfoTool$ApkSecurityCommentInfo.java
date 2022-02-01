package com.tencent.securitysdk.utils;

import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

class ApkExternalInfoTool$ApkSecurityCommentInfo
{
  Properties jdField_a_of_type_JavaUtilProperties = new Properties();
  byte[] jdField_a_of_type_ArrayOfByte;
  
  void a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {}
    ByteBuffer localByteBuffer;
    int i;
    byte[] arrayOfByte;
    int j;
    do
    {
      do
      {
        return;
        localByteBuffer = ByteBuffer.wrap(paramArrayOfByte);
        i = ApkExternalInfoTool.a().a().length;
        arrayOfByte = new byte[i];
        localByteBuffer.get(arrayOfByte);
        if (!ApkExternalInfoTool.a().equals(new ZipLong(arrayOfByte))) {
          break;
        }
        if (paramArrayOfByte.length - i <= 2)
        {
          QLog.i("ApkExternalInfoTool", 1, "data.length - securityMarkLength <= 2");
          return;
        }
        arrayOfByte = new byte[2];
        localByteBuffer.get(arrayOfByte);
        j = new ZipShort(arrayOfByte).a();
        if (paramArrayOfByte.length - i - 2 < j)
        {
          QLog.i("ApkExternalInfoTool", 1, "data.length - securityMarkLength - 2 < len");
          QLog.i("ApkExternalInfoTool", 1, "exit");
          return;
        }
        arrayOfByte = new byte[j];
        localByteBuffer.get(arrayOfByte);
        this.jdField_a_of_type_JavaUtilProperties.load(new ByteArrayInputStream(arrayOfByte));
        i = paramArrayOfByte.length - i - j - 2;
      } while (i <= 0);
      j = ApkExternalInfoTool.b().a().length;
      paramArrayOfByte = new byte[j];
      localByteBuffer.get(paramArrayOfByte);
    } while (!ApkExternalInfoTool.b().equals(new ZipLong(paramArrayOfByte)));
    if (i - j <= 2)
    {
      QLog.i("ApkExternalInfoTool", 1, "data.length - oriMarkLength <= 2");
      return;
    }
    paramArrayOfByte = new byte[2];
    localByteBuffer.get(paramArrayOfByte);
    int k = new ZipShort(paramArrayOfByte).a();
    if (i - j - 2 < k)
    {
      QLog.i("ApkExternalInfoTool", 1, "data.length - oriMarkLength - 2 < len");
      QLog.i("ApkExternalInfoTool", 1, "exit");
      return;
    }
    this.jdField_a_of_type_ArrayOfByte = new byte[k];
    localByteBuffer.get(this.jdField_a_of_type_ArrayOfByte);
    return;
    if (ApkExternalInfoTool.b().equals(new ZipLong(arrayOfByte)))
    {
      j = ApkExternalInfoTool.b().a().length;
      if (paramArrayOfByte.length - i <= 2)
      {
        QLog.i("ApkExternalInfoTool", 1, "data.length - oriMarkLength <= 2");
        return;
      }
      arrayOfByte = new byte[2];
      localByteBuffer.get(arrayOfByte);
      i = new ZipShort(arrayOfByte).a();
      if (paramArrayOfByte.length - j - 2 < i)
      {
        QLog.i("ApkExternalInfoTool", 1, "data.length - oriMarkLength - 2 < len");
        QLog.i("ApkExternalInfoTool", 1, "exit");
        return;
      }
      this.jdField_a_of_type_ArrayOfByte = new byte[i];
      localByteBuffer.get(this.jdField_a_of_type_ArrayOfByte);
      return;
    }
    throw new ProtocolException("unknow protocl [" + Arrays.toString(paramArrayOfByte) + "]");
  }
  
  byte[] a()
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    if (this.jdField_a_of_type_JavaUtilProperties.size() > 0)
    {
      localByteArrayOutputStream.write(ApkExternalInfoTool.a().a());
      Iterator localIterator = this.jdField_a_of_type_JavaUtilProperties.keySet().iterator();
      Object localObject2;
      for (Object localObject1 = ""; localIterator.hasNext(); localObject1 = (String)localObject1 + localObject2 + "=" + this.jdField_a_of_type_JavaUtilProperties.getProperty((String)localObject2) + "\r\n") {
        localObject2 = localIterator.next();
      }
      localObject1 = ((String)localObject1).getBytes();
      localByteArrayOutputStream.write(new ZipShort(localObject1.length).a());
      localByteArrayOutputStream.write((byte[])localObject1);
    }
    if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ArrayOfByte.length > 0))
    {
      localByteArrayOutputStream.write(ApkExternalInfoTool.b().a());
      localByteArrayOutputStream.write(new ZipShort(this.jdField_a_of_type_ArrayOfByte.length).a());
      localByteArrayOutputStream.write(this.jdField_a_of_type_ArrayOfByte);
    }
    return localByteArrayOutputStream.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.securitysdk.utils.ApkExternalInfoTool.ApkSecurityCommentInfo
 * JD-Core Version:    0.7.0.1
 */