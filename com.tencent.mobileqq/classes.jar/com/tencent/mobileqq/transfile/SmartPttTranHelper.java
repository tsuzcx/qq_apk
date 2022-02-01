package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.cs.smartptt.Smartptt.PttUpReq;
import tencent.im.cs.smartptt.Smartptt.ReqBody;

public class SmartPttTranHelper
{
  public static Smartptt.ReqBody getSmartPttReqBody(SmartPttTranHelper.PttSliceInfoBean paramPttSliceInfoBean)
  {
    int j = 0;
    Smartptt.ReqBody localReqBody = new Smartptt.ReqBody();
    localReqBody.uint32_sub_cmd.set(3);
    Smartptt.PttUpReq localPttUpReq = new Smartptt.PttUpReq();
    localPttUpReq.uint32_bits_per_sample.set(16);
    localPttUpReq.uint32_voice_file_type.set(1);
    localPttUpReq.uint32_voice_encode_type.set(paramPttSliceInfoBean.encodeType);
    localPttUpReq.uint32_samples_per_sec.set(16000);
    localPttUpReq.str_voice_id.set(paramPttSliceInfoBean.voiceId);
    PBUInt32Field localPBUInt32Field = localPttUpReq.uint32_is_first;
    if (paramPttSliceInfoBean.isfirst) {}
    for (int i = 1;; i = 0)
    {
      localPBUInt32Field.set(i);
      localPBUInt32Field = localPttUpReq.uint32_is_end;
      i = j;
      if (paramPttSliceInfoBean.isLast) {
        i = 1;
      }
      localPBUInt32Field.set(i);
      localPttUpReq.uint32_offset.set(paramPttSliceInfoBean.offset);
      localPttUpReq.str_Filemd5.set(paramPttSliceInfoBean.md5);
      localPttUpReq.uint32_chat_type.set(paramPttSliceInfoBean.chatType);
      localPttUpReq.uint32_service_id.set(1);
      localPttUpReq.uint32_voice_num.set(paramPttSliceInfoBean.vegNum);
      localPttUpReq.uint32_voice_offset.set(paramPttSliceInfoBean.vegPos);
      localReqBody.msg_ptt_up_req.set(localPttUpReq);
      return localReqBody;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.SmartPttTranHelper
 * JD-Core Version:    0.7.0.1
 */