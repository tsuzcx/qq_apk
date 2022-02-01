package com.tencent.mobileqq.uftransfer.proto;

import com.tencent.mobileqq.uftransfer.depend.UFTDependFeatureApi;
import java.util.List;

public class UFTTroopUploadRsp
{
  private int jdField_a_of_type_Int = 0;
  private String jdField_a_of_type_JavaLangString;
  private List<String> jdField_a_of_type_JavaUtilList;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private List<String> jdField_b_of_type_JavaUtilList;
  private int jdField_c_of_type_Int = 0;
  private String jdField_c_of_type_JavaLangString;
  private String d;
  private String e;
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public List<String> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public byte[] a()
  {
    return this.jdField_a_of_type_ArrayOfByte;
  }
  
  public int b()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public List<String> b()
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void b(List<String> paramList)
  {
    this.jdField_b_of_type_JavaUtilList = paramList;
  }
  
  public String c()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void c(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void c(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public void d(String paramString)
  {
    this.d = paramString;
  }
  
  public String e()
  {
    return this.e;
  }
  
  public void e(String paramString)
  {
    this.e = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UFTTroopUploadRsp{retCode=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", retMsg='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", clientWording='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", fileId='");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", uploadIp='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", serverDns='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", checkKey=");
    localStringBuilder.append(UFTDependFeatureApi.a(this.jdField_a_of_type_ArrayOfByte));
    localStringBuilder.append(", busid=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", lanIpV4List=");
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    String str = "null";
    if (localObject != null) {
      localObject = localObject.toString();
    } else {
      localObject = "null";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(", lanIpV6List=");
    List localList = this.jdField_b_of_type_JavaUtilList;
    localObject = str;
    if (localList != null) {
      localObject = localList.toString();
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(", lanPort=");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.proto.UFTTroopUploadRsp
 * JD-Core Version:    0.7.0.1
 */