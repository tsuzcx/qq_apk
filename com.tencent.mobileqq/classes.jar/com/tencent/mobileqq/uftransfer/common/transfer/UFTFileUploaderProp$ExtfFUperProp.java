package com.tencent.mobileqq.uftransfer.common.transfer;

import com.tencent.mobileqq.uftransfer.api.UFTTransferConfig.ExtfUploadCfg;

public class UFTFileUploaderProp$ExtfFUperProp
{
  protected int a;
  protected long a;
  protected UFTTransferConfig.ExtfUploadCfg a;
  protected final UFTFileUploaderProp.ExtfFileInfo a;
  protected final UFTFileUploaderProp.ExtfSvrInfo a;
  protected String a;
  protected boolean a;
  protected int b;
  protected long b;
  protected int c;
  protected long c;
  protected int d;
  
  public UFTFileUploaderProp$ExtfFUperProp()
  {
    this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUFTFileUploaderProp$ExtfFileInfo = new UFTFileUploaderProp.ExtfFileInfo();
    this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUFTFileUploaderProp$ExtfSvrInfo = new UFTFileUploaderProp.ExtfSvrInfo();
    this.jdField_a_of_type_ComTencentMobileqqUftransferApiUFTTransferConfig$ExtfUploadCfg = new UFTTransferConfig.ExtfUploadCfg();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public UFTTransferConfig.ExtfUploadCfg a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqUftransferApiUFTTransferConfig$ExtfUploadCfg;
  }
  
  public UFTFileUploaderProp.ExtfFileInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUFTFileUploaderProp$ExtfFileInfo;
  }
  
  public UFTFileUploaderProp.ExtfSvrInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUFTFileUploaderProp$ExtfSvrInfo;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(UFTTransferConfig.ExtfUploadCfg paramExtfUploadCfg)
  {
    this.jdField_a_of_type_ComTencentMobileqqUftransferApiUFTTransferConfig$ExtfUploadCfg = paramExtfUploadCfg;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int b()
  {
    return this.d;
  }
  
  public long b()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void b(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public boolean b()
  {
    if (this.jdField_b_of_type_Int == 0)
    {
      this.jdField_a_of_type_JavaLangString = "businissId is 0";
      return false;
    }
    if (this.jdField_c_of_type_Int == 0)
    {
      this.jdField_a_of_type_JavaLangString = "bigDataCmdId is 0";
      return false;
    }
    UFTFileUploaderProp.ExtfFileInfo localExtfFileInfo = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUFTFileUploaderProp$ExtfFileInfo;
    if (localExtfFileInfo == null)
    {
      this.jdField_a_of_type_JavaLangString = "fileInfo is null";
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUFTFileUploaderProp$ExtfSvrInfo == null)
    {
      this.jdField_a_of_type_JavaLangString = "svrInfo is null";
      return false;
    }
    if (!localExtfFileInfo.a())
    {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUFTFileUploaderProp$ExtfFileInfo.c();
      return false;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUFTFileUploaderProp$ExtfSvrInfo.b())
    {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUFTFileUploaderProp$ExtfSvrInfo.b();
      return false;
    }
    return true;
  }
  
  public int c()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public long c()
  {
    return this.jdField_c_of_type_Long;
  }
  
  public void c(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void c(long paramLong)
  {
    this.jdField_c_of_type_Long = paramLong;
  }
  
  public int d()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public void d(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.common.transfer.UFTFileUploaderProp.ExtfFUperProp
 * JD-Core Version:    0.7.0.1
 */