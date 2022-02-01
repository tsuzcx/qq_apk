package com.tencent.mobileqq.kandian.biz.atlas;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.AppProtocolObserver;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xb74.cmd0xb74.RspBody;

class ReadInJoyAtlasManager$2
  extends ProtoUtils.AppProtocolObserver
{
  ReadInJoyAtlasManager$2(ReadInJoyAtlasManager paramReadInJoyAtlasManager, ReadInJoyAtlasManager.AtlasCallbackImpl paramAtlasCallbackImpl) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      paramBundle = ReadInJoyAtlasManager.TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("fetchAtlas0xb74 onResult, errorCode=");
      localStringBuilder.append(paramInt);
      QLog.d(paramBundle, 2, localStringBuilder.toString());
    }
    if ((paramInt != -1) && (paramArrayOfByte != null))
    {
      try
      {
        paramBundle = new cmd0xb74.RspBody();
        paramBundle.mergeFrom(paramArrayOfByte);
        if (this.b == null) {
          return;
        }
        this.b.a(true, paramBundle.rpt_like_info.get(), 0);
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        paramBundle = this.b;
        if (paramBundle != null) {
          paramBundle.a(false, null, paramInt);
        }
        paramBundle = ReadInJoyAtlasManager.TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("fetchAtlas0xbe0 onResult(), exception=");
        localStringBuilder.append(paramArrayOfByte.toString());
        QLog.e(paramBundle, 1, localStringBuilder.toString());
        return;
      }
    }
    else
    {
      paramArrayOfByte = this.b;
      if (paramArrayOfByte != null) {
        paramArrayOfByte.a(false, null, paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.atlas.ReadInJoyAtlasManager.2
 * JD-Core Version:    0.7.0.1
 */