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
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 0) {
        return;
      }
      Object localObject = ByteBuffer.wrap(paramArrayOfByte);
      int i = ApkExternalInfoTool.a().a().length;
      byte[] arrayOfByte = new byte[i];
      ((ByteBuffer)localObject).get(arrayOfByte);
      int j;
      if (ApkExternalInfoTool.a().equals(new ZipLong(arrayOfByte)))
      {
        if (paramArrayOfByte.length - i <= 2)
        {
          QLog.i("ApkExternalInfoTool", 1, "data.length - securityMarkLength <= 2");
          return;
        }
        arrayOfByte = new byte[2];
        ((ByteBuffer)localObject).get(arrayOfByte);
        j = new ZipShort(arrayOfByte).a();
        if (paramArrayOfByte.length - i - 2 < j)
        {
          QLog.i("ApkExternalInfoTool", 1, "data.length - securityMarkLength - 2 < len");
          QLog.i("ApkExternalInfoTool", 1, "exit");
          return;
        }
        arrayOfByte = new byte[j];
        ((ByteBuffer)localObject).get(arrayOfByte);
        this.jdField_a_of_type_JavaUtilProperties.load(new ByteArrayInputStream(arrayOfByte));
        i = paramArrayOfByte.length - i - j - 2;
        if (i > 0)
        {
          j = ApkExternalInfoTool.b().a().length;
          paramArrayOfByte = new byte[j];
          ((ByteBuffer)localObject).get(paramArrayOfByte);
          if (ApkExternalInfoTool.b().equals(new ZipLong(paramArrayOfByte)))
          {
            i -= j;
            if (i <= 2)
            {
              QLog.i("ApkExternalInfoTool", 1, "data.length - oriMarkLength <= 2");
              return;
            }
            paramArrayOfByte = new byte[2];
            ((ByteBuffer)localObject).get(paramArrayOfByte);
            j = new ZipShort(paramArrayOfByte).a();
            if (i - 2 < j)
            {
              QLog.i("ApkExternalInfoTool", 1, "data.length - oriMarkLength - 2 < len");
              QLog.i("ApkExternalInfoTool", 1, "exit");
              return;
            }
            this.jdField_a_of_type_ArrayOfByte = new byte[j];
            ((ByteBuffer)localObject).get(this.jdField_a_of_type_ArrayOfByte);
          }
        }
      }
      else
      {
        if (!ApkExternalInfoTool.b().equals(new ZipLong(arrayOfByte))) {
          break label400;
        }
        j = ApkExternalInfoTool.b().a().length;
        if (paramArrayOfByte.length - i <= 2)
        {
          QLog.i("ApkExternalInfoTool", 1, "data.length - oriMarkLength <= 2");
          return;
        }
        arrayOfByte = new byte[2];
        ((ByteBuffer)localObject).get(arrayOfByte);
        i = new ZipShort(arrayOfByte).a();
        if (paramArrayOfByte.length - j - 2 < i)
        {
          QLog.i("ApkExternalInfoTool", 1, "data.length - oriMarkLength - 2 < len");
          QLog.i("ApkExternalInfoTool", 1, "exit");
          return;
        }
        this.jdField_a_of_type_ArrayOfByte = new byte[i];
        ((ByteBuffer)localObject).get(this.jdField_a_of_type_ArrayOfByte);
      }
      return;
      label400:
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unknow protocl [");
      ((StringBuilder)localObject).append(Arrays.toString(paramArrayOfByte));
      ((StringBuilder)localObject).append("]");
      throw new ProtocolException(((StringBuilder)localObject).toString());
    }
  }
  
  byte[] a()
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    if (this.jdField_a_of_type_JavaUtilProperties.size() > 0)
    {
      localByteArrayOutputStream.write(ApkExternalInfoTool.a().a());
      Iterator localIterator = this.jdField_a_of_type_JavaUtilProperties.keySet().iterator();
      StringBuilder localStringBuilder;
      for (localObject1 = ""; localIterator.hasNext(); localObject1 = localStringBuilder.toString())
      {
        Object localObject2 = localIterator.next();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(localObject2);
        localStringBuilder.append("=");
        localStringBuilder.append(this.jdField_a_of_type_JavaUtilProperties.getProperty((String)localObject2));
        localStringBuilder.append("\r\n");
      }
      localObject1 = ((String)localObject1).getBytes();
      localByteArrayOutputStream.write(new ZipShort(localObject1.length).a());
      localByteArrayOutputStream.write((byte[])localObject1);
    }
    Object localObject1 = this.jdField_a_of_type_ArrayOfByte;
    if ((localObject1 != null) && (localObject1.length > 0))
    {
      localByteArrayOutputStream.write(ApkExternalInfoTool.b().a());
      localByteArrayOutputStream.write(new ZipShort(this.jdField_a_of_type_ArrayOfByte.length).a());
      localByteArrayOutputStream.write(this.jdField_a_of_type_ArrayOfByte);
    }
    return localByteArrayOutputStream.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.securitysdk.utils.ApkExternalInfoTool.ApkSecurityCommentInfo
 * JD-Core Version:    0.7.0.1
 */