package com.tencent.mobileqq.kandian.biz.atlas;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.AppProtocolObserver;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.ArticleExtInfo;
import tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.RspBody;

class ReadInJoyAtlasManager$6
  extends ProtoUtils.AppProtocolObserver
{
  ReadInJoyAtlasManager$6(ReadInJoyAtlasManager paramReadInJoyAtlasManager, ReadInJoyAtlasManager.AtlasCallback paramAtlasCallback) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      paramBundle = ReadInJoyAtlasManager.TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getAtlasCommentCount onResult, errorCode=");
      localStringBuilder.append(paramInt);
      QLog.d(paramBundle, 2, localStringBuilder.toString());
    }
    if ((paramInt != -1) && (paramArrayOfByte != null)) {
      try
      {
        paramBundle = new oidb_cmd0xad6.RspBody();
        paramBundle.mergeFrom(paramArrayOfByte);
        if ((paramBundle.msg_ext_info.has()) && (((oidb_cmd0xad6.ArticleExtInfo)paramBundle.msg_ext_info.get()).uint64_comment.has()))
        {
          if (this.b != null) {
            this.b.a(true, ((oidb_cmd0xad6.ArticleExtInfo)paramBundle.msg_ext_info.get()).uint64_comment.get(), 0);
          }
        }
        else if (this.b != null)
        {
          this.b.a(false, 0L, -1);
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        paramBundle = this.b;
        if (paramBundle != null) {
          paramBundle.a(false, 0L, -1);
        }
        paramBundle = ReadInJoyAtlasManager.TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getAtlasCommentCount onResult(), exception=");
        localStringBuilder.append(paramArrayOfByte.toString());
        QLog.e(paramBundle, 1, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.atlas.ReadInJoyAtlasManager.6
 * JD-Core Version:    0.7.0.1
 */