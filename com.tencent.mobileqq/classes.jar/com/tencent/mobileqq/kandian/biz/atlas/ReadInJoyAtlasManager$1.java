package com.tencent.mobileqq.kandian.biz.atlas;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.AppProtocolObserver;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.RspBiuCount;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.RspBody;

class ReadInJoyAtlasManager$1
  extends ProtoUtils.AppProtocolObserver
{
  ReadInJoyAtlasManager$1(ReadInJoyAtlasManager paramReadInJoyAtlasManager, ReadInJoyAtlasManager.AtlasCallbackImpl paramAtlasCallbackImpl, String paramString) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      paramBundle = ReadInJoyAtlasManager.TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("fetchAtlasBiuCount onResult, errorCode=");
      localStringBuilder.append(paramInt);
      QLog.d(paramBundle, 2, localStringBuilder.toString());
    }
    if ((paramInt != -1) && (paramArrayOfByte != null)) {}
    for (;;)
    {
      try
      {
        paramBundle = new oidb_cmd0xb54.RspBody();
        paramBundle.mergeFrom(paramArrayOfByte);
        if (this.b == null) {
          break label200;
        }
        paramArrayOfByte = this.b;
        if (!paramBundle.msg_rsp_biu_count.has()) {
          break label201;
        }
        l = paramBundle.msg_rsp_biu_count.uint64_biu_count.get();
        paramArrayOfByte.a(true, l, 0, this.c);
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        paramBundle = this.b;
        if (paramBundle != null) {
          paramBundle.a(false, 0L, paramInt, this.c);
        }
        paramBundle = ReadInJoyAtlasManager.TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("fetchAtlasBiuCount onResult(), exception=");
        localStringBuilder.append(paramArrayOfByte.toString());
        QLog.e(paramBundle, 1, localStringBuilder.toString());
        return;
      }
      paramArrayOfByte = this.b;
      if (paramArrayOfByte != null) {
        paramArrayOfByte.a(false, 0L, paramInt, this.c);
      }
      label200:
      return;
      label201:
      long l = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.atlas.ReadInJoyAtlasManager.1
 * JD-Core Version:    0.7.0.1
 */