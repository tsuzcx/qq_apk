package com.tencent.mobileqq.kandian.biz.skin;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.GuideInfo;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.RefreshInfo;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.RspBody;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.SkinInfo;

class ReadInJoySkinHandler$1
  extends ProtoUtils.TroopProtocolObserver
{
  ReadInJoySkinHandler$1(ReadInJoySkinHandler paramReadInJoySkinHandler) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    paramBundle = new oidb_0x5bd.RspBody();
    if ((paramInt == 0) && (paramArrayOfByte != null)) {}
    for (;;)
    {
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        if (QLog.isColorLevel())
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("errorCode = ");
          paramArrayOfByte.append(paramInt);
          paramArrayOfByte.append(", rspBody.msg_next_guide_info.has = ");
          paramArrayOfByte.append(paramBundle.msg_next_guide_info.has());
          QLog.d("ReadInJoySkinHandler", 2, paramArrayOfByte.toString());
        }
        int i = paramBundle.uint32_source.get();
        paramArrayOfByte = this.a;
        if (paramInt == 0)
        {
          bool = true;
          paramArrayOfByte.notifyUI(1, bool, new Object[] { paramBundle.msg_now_skin_info.get(), paramBundle.msg_next_guide_info.get(), paramBundle.msg_operation_guide_info.get(), paramBundle.msg_operation_refresh_info.get(), Integer.valueOf(i) });
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return;
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinHandler.1
 * JD-Core Version:    0.7.0.1
 */