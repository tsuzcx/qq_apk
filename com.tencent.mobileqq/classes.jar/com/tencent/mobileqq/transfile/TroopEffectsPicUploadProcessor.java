package com.tencent.mobileqq.transfile;

import azla;
import azlb;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import tencent.im.msg.im_msg_body.CustomFace;

public class TroopEffectsPicUploadProcessor
  extends GroupPicUploadProcessor
{
  public im_msg_body.CustomFace customFace;
  
  public TroopEffectsPicUploadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
  }
  
  protected void constructCustomFace()
  {
    im_msg_body.CustomFace localCustomFace = new im_msg_body.CustomFace();
    localCustomFace.uint32_file_id.set((int)this.mFileID);
    if ((this.mIpList != null) && (this.mIpList.size() > 0))
    {
      localObject = (ServerAddr)this.mIpList.get(0);
      localCustomFace.uint32_server_ip.set(ipToLong(((ServerAddr)localObject).mIp));
      localCustomFace.uint32_server_port.set(((ServerAddr)localObject).port);
    }
    localCustomFace.uint32_file_type.set(Integer.valueOf(66).intValue());
    localCustomFace.uint32_useful.set(1);
    if (this.app.getSessionKey() != null) {
      localCustomFace.bytes_signature.set(ByteStringMicro.copyFrom(this.app.getSessionKey()));
    }
    localCustomFace.bytes_md5.set(ByteStringMicro.copyFrom(this.mLocalMd5));
    localCustomFace.str_file_path.set(this.mFileName);
    Object localObject = localCustomFace.uint32_origin;
    if (this.mIsRawPic) {}
    for (int i = 1;; i = 0)
    {
      ((PBUInt32Field)localObject).set(i);
      localCustomFace.uint32_width.set(this.mWidth);
      localCustomFace.uint32_height.set(this.mHeight);
      localCustomFace.uint32_size.set((int)this.mFileSize);
      localCustomFace.uint32_source.set(200);
      this.customFace = localCustomFace;
      return;
    }
  }
  
  void sendMsg()
  {
    if (this.mUiRequest.mUpCallBack != null)
    {
      constructCustomFace();
      azlb localazlb = new azlb();
      localazlb.jdField_a_of_type_Long = this.mFileSize;
      localazlb.d = this.mMd5Str;
      localazlb.c = this.mFileName;
      localazlb.jdField_b_of_type_JavaLangString = this.mUiRequest.mLocalPath;
      localazlb.jdField_b_of_type_Long = this.mFileID;
      localazlb.jdField_a_of_type_JavaLangObject = this.customFace;
      this.mUiRequest.mUpCallBack.onSend(localazlb);
      doReport(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.TroopEffectsPicUploadProcessor
 * JD-Core Version:    0.7.0.1
 */