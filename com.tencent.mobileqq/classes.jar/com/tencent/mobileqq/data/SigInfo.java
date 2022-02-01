package com.tencent.mobileqq.data;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pic.api.IPicTransFile;
import tencent.im.msg.im_msg_body.CustomFace;

public class SigInfo
{
  public byte[] sessionKey;
  public byte[] signature;
  public short wSignatureLen;
  
  public static void fillCustomFaceSessionKey(AppInterface paramAppInterface, im_msg_body.CustomFace paramCustomFace)
  {
    paramAppInterface = ((IPicTransFile)paramAppInterface.getRuntimeService(IPicTransFile.class, "")).getSessionKey();
    if (paramAppInterface != null) {
      paramCustomFace.bytes_signature.set(ByteStringMicro.copyFrom(paramAppInterface));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.SigInfo
 * JD-Core Version:    0.7.0.1
 */