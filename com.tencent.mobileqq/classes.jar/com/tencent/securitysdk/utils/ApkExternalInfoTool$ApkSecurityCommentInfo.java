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
  Properties a = new Properties();
  byte[] b;
  
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
        j = new ZipShort(arrayOfByte).b();
        if (paramArrayOfByte.length - i - 2 < j)
        {
          QLog.i("ApkExternalInfoTool", 1, "data.length - securityMarkLength - 2 < len");
          QLog.i("ApkExternalInfoTool", 1, "exit");
          return;
        }
        arrayOfByte = new byte[j];
        ((ByteBuffer)localObject).get(arrayOfByte);
        this.a.load(new ByteArrayInputStream(arrayOfByte));
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
            j = new ZipShort(paramArrayOfByte).b();
            if (i - 2 < j)
            {
              QLog.i("ApkExternalInfoTool", 1, "data.length - oriMarkLength - 2 < len");
              QLog.i("ApkExternalInfoTool", 1, "exit");
              return;
            }
            this.b = new byte[j];
            ((ByteBuffer)localObject).get(this.b);
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
        i = new ZipShort(arrayOfByte).b();
        if (paramArrayOfByte.length - j - 2 < i)
        {
          QLog.i("ApkExternalInfoTool", 1, "data.length - oriMarkLength - 2 < len");
          QLog.i("ApkExternalInfoTool", 1, "exit");
          return;
        }
        this.b = new byte[i];
        ((ByteBuffer)localObject).get(this.b);
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
    if (this.a.size() > 0)
    {
      localByteArrayOutputStream.write(ApkExternalInfoTool.a().a());
      Iterator localIterator = this.a.keySet().iterator();
      StringBuilder localStringBuilder;
      for (localObject1 = ""; localIterator.hasNext(); localObject1 = localStringBuilder.toString())
      {
        Object localObject2 = localIterator.next();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(localObject2);
        localStringBuilder.append("=");
        localStringBuilder.append(this.a.getProperty((String)localObject2));
        localStringBuilder.append("\r\n");
      }
      localObject1 = ((String)localObject1).getBytes();
      localByteArrayOutputStream.write(new ZipShort(localObject1.length).a());
      localByteArrayOutputStream.write((byte[])localObject1);
    }
    Object localObject1 = this.b;
    if ((localObject1 != null) && (localObject1.length > 0))
    {
      localByteArrayOutputStream.write(ApkExternalInfoTool.b().a());
      localByteArrayOutputStream.write(new ZipShort(this.b.length).a());
      localByteArrayOutputStream.write(this.b);
    }
    return localByteArrayOutputStream.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.securitysdk.utils.ApkExternalInfoTool.ApkSecurityCommentInfo
 * JD-Core Version:    0.7.0.1
 */