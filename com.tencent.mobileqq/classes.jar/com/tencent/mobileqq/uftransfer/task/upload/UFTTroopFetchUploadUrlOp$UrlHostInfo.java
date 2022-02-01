package com.tencent.mobileqq.uftransfer.task.upload;

import java.util.List;

public class UFTTroopFetchUploadUrlOp$UrlHostInfo
{
  List<String> a;
  boolean b = false;
  String c;
  boolean d = false;
  boolean e = false;
  
  protected UFTTroopFetchUploadUrlOp$UrlHostInfo(UFTTroopFetchUploadUrlOp paramUFTTroopFetchUploadUrlOp) {}
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UrlHostInfo{hostList=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", useHttps=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", httpsDomain='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", useIpV6=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", useDnsIpV6=");
    localStringBuilder.append(this.e);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTTroopFetchUploadUrlOp.UrlHostInfo
 * JD-Core Version:    0.7.0.1
 */