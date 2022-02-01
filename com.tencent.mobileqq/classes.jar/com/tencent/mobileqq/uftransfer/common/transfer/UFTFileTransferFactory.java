package com.tencent.mobileqq.uftransfer.common.transfer;

import com.tencent.mobileqq.uftransfer.common.transfer.upload.UFTExtfFileUploader;
import com.tencent.mobileqq.uftransfer.common.transfer.upload.UFTFtnFileUploader;
import mqq.app.AppRuntime;

public class UFTFileTransferFactory
{
  public static IUFTFileUploader a(AppRuntime paramAppRuntime, UFTFileUploaderProp.ExtfFUperProp paramExtfFUperProp)
  {
    return UFTExtfFileUploader.a(paramAppRuntime, paramExtfFUperProp);
  }
  
  public static IUFTFileUploader a(AppRuntime paramAppRuntime, UFTFileUploaderProp.FtnMoreUrlFUperProp paramFtnMoreUrlFUperProp)
  {
    return UFTFtnFileUploader.a(paramAppRuntime, paramFtnMoreUrlFUperProp);
  }
  
  public static IUFTFileUploader a(AppRuntime paramAppRuntime, UFTFileUploaderProp.FtnMoreUrlFUperPropV1 paramFtnMoreUrlFUperPropV1)
  {
    return UFTFtnFileUploader.a(paramAppRuntime, paramFtnMoreUrlFUperPropV1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.common.transfer.UFTFileTransferFactory
 * JD-Core Version:    0.7.0.1
 */