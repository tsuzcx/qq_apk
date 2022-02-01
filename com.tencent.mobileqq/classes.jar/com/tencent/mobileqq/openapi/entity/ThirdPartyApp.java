package com.tencent.mobileqq.openapi.entity;

import com.tencent.mobileqq.openapi.ThirdAppConfigHelper.ThirdAppConfig;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;

public class ThirdPartyApp
{
  public int a;
  public long a;
  private Cryptor jdField_a_of_type_ComTencentQphoneBaseUtilCryptor;
  public String a;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  public long b;
  public String b;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private int c;
  public String c;
  private int d;
  private int e;
  
  public ThirdPartyApp(ThirdAppConfigHelper.ThirdAppConfig paramThirdAppConfig)
  {
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangString = paramThirdAppConfig.jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = paramThirdAppConfig.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_Int = paramThirdAppConfig.jdField_a_of_type_Int;
    this.d = paramThirdAppConfig.jdField_b_of_type_Int;
    this.e = paramThirdAppConfig.jdField_c_of_type_Int;
    if (paramThirdAppConfig.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_Long = paramThirdAppConfig.d;
      this.jdField_a_of_type_ArrayOfByte = a(paramThirdAppConfig.jdField_c_of_type_Long);
      this.jdField_b_of_type_Long = paramThirdAppConfig.jdField_b_of_type_Long;
      this.jdField_b_of_type_ArrayOfByte = a(paramThirdAppConfig.jdField_a_of_type_Long);
      return;
    }
    this.jdField_a_of_type_Long = paramThirdAppConfig.jdField_b_of_type_Long;
    this.jdField_a_of_type_ArrayOfByte = a(paramThirdAppConfig.jdField_a_of_type_Long);
  }
  
  private byte[] a(long paramLong)
  {
    for (Object localObject1 = this.jdField_a_of_type_JavaLangString; ((String)localObject1).length() < 16; localObject1 = ((StringBuilder)localObject2).toString())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append((String)localObject1);
    }
    Object localObject2 = ((String)localObject1).getBytes();
    byte[] arrayOfByte = String.valueOf(paramLong).getBytes();
    if (localObject2.length > arrayOfByte.length) {
      localObject1 = localObject2;
    } else {
      localObject1 = arrayOfByte;
    }
    int i = 0;
    while (i < Math.min(localObject2.length, arrayOfByte.length))
    {
      localObject1[i] = ((byte)(localObject2[i] ^ arrayOfByte[i]));
      i += 1;
    }
    if (this.jdField_a_of_type_ComTencentQphoneBaseUtilCryptor == null)
    {
      this.jdField_a_of_type_ComTencentQphoneBaseUtilCryptor = new Cryptor();
      this.jdField_a_of_type_ComTencentQphoneBaseUtilCryptor.enableResultRandom(false);
    }
    return localObject1;
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String a(String paramString)
  {
    try
    {
      paramString = HexUtil.bytes2HexStr(this.jdField_a_of_type_ComTencentQphoneBaseUtilCryptor.encrypt(paramString.getBytes(), this.jdField_a_of_type_ArrayOfByte));
      return paramString;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OpenApi.App", 2, "encrypt", paramString);
      }
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_Int = (paramInt1 & this.d);
    this.jdField_c_of_type_Int = (this.e & paramInt2);
  }
  
  public boolean a(int paramInt)
  {
    return (paramInt & this.jdField_a_of_type_Int) > 0;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    return ((paramInt1 & this.e) > 0) && ((this.d & paramInt2) > 0);
  }
  
  public int b()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public String b(String paramString)
  {
    try
    {
      paramString = HexUtil.hexStr2Bytes(paramString);
      paramString = new String(this.jdField_a_of_type_ComTencentQphoneBaseUtilCryptor.decrypt(paramString, this.jdField_a_of_type_ArrayOfByte));
      return paramString;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OpenApi.App", 2, "decrypt", paramString);
      }
    }
    return null;
  }
  
  public boolean b(int paramInt)
  {
    return ((paramInt & this.jdField_c_of_type_Int) > 0) && ((this.jdField_b_of_type_Int & 0x40000000) > 0);
  }
  
  public boolean b(int paramInt1, int paramInt2)
  {
    return ((paramInt1 & this.jdField_c_of_type_Int) > 0) && ((this.jdField_b_of_type_Int & paramInt2) > 0);
  }
  
  public String c(String paramString)
  {
    try
    {
      paramString = HexUtil.hexStr2Bytes(paramString);
      paramString = new String(this.jdField_a_of_type_ComTencentQphoneBaseUtilCryptor.decrypt(paramString, this.jdField_b_of_type_ArrayOfByte));
      return paramString;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OpenApi.App", 2, "decryptLastData", paramString);
      }
    }
    return null;
  }
  
  public boolean c(int paramInt)
  {
    return (paramInt & this.e) > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.openapi.entity.ThirdPartyApp
 * JD-Core Version:    0.7.0.1
 */