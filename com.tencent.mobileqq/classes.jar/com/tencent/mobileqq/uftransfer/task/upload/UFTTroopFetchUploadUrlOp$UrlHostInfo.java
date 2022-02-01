package com.tencent.mobileqq.uftransfer.task.upload;

import java.util.List;

public class UFTTroopFetchUploadUrlOp$UrlHostInfo
{
  String jdField_a_of_type_JavaLangString;
  List<String> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = false;
  boolean b = false;
  boolean c = false;
  
  protected UFTTroopFetchUploadUrlOp$UrlHostInfo(UFTTroopFetchUploadUrlOp paramUFTTroopFetchUploadUrlOp) {}
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UrlHostInfo{hostList=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilList);
    localStringBuilder.append(", useHttps=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", httpsDomain='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", useIpV6=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", useDnsIpV6=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTTroopFetchUploadUrlOp.UrlHostInfo
 * JD-Core Version:    0.7.0.1
 */