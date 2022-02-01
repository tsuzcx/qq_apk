package com.tencent.mobileqq.filemanager.api.impl;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.filemanager.api.ITroopFileProtoReq;

public class TroopFileProtoReqMgrImpl$ProtoRequest
  implements ITroopFileProtoReq
{
  static long jdField_a_of_type_Long;
  public int a;
  public Bundle a;
  public ProtoUtils.TroopProtocolObserver a;
  TroopFileProtoReqMgrImpl.ProtoResponse jdField_a_of_type_ComTencentMobileqqFilemanagerApiImplTroopFileProtoReqMgrImpl$ProtoResponse;
  public String a;
  public boolean a;
  public byte[] a;
  public int b;
  long b;
  public boolean b;
  public int c = 3;
  public int d = 25;
  public int e = 450000;
  public int f = 1;
  
  public TroopFileProtoReqMgrImpl$ProtoRequest()
  {
    this.jdField_a_of_type_Int = 480000;
    this.jdField_b_of_type_Int = 9;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    long l = jdField_a_of_type_Long + 1L;
    jdField_a_of_type_Long = l;
    this.jdField_b_of_type_Long = l;
  }
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public void a(ProtoUtils.TroopProtocolObserver paramTroopProtocolObserver)
  {
    this.jdField_a_of_type_ComTencentBizProtoUtils$TroopProtocolObserver = paramTroopProtocolObserver;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.impl.TroopFileProtoReqMgrImpl.ProtoRequest
 * JD-Core Version:    0.7.0.1
 */