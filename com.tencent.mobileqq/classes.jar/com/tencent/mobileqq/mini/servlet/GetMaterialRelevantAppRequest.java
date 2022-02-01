package com.tencent.mobileqq.mini.servlet;

import NS_MINI_FILE_MATERIAL.MiniAppFileMaterial.GetMaterialRelevantAppReq;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.pb.PBStringField;

class GetMaterialRelevantAppRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "miniapp.Openmaterial.GetMaterialRelevantApp";
  private final MiniAppFileMaterial.GetMaterialRelevantAppReq mReq = new MiniAppFileMaterial.GetMaterialRelevantAppReq();
  
  public GetMaterialRelevantAppRequest(@NonNull String paramString1, String paramString2)
  {
    this.mReq.mime_type.set(paramString1);
    if (paramString2 != null) {
      this.mReq.extra.set(paramString2);
    }
  }
  
  public byte[] getBusiBuf()
  {
    return this.mReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.GetMaterialRelevantAppRequest
 * JD-Core Version:    0.7.0.1
 */