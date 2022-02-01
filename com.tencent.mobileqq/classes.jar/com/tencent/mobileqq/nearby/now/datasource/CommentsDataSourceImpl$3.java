package com.tencent.mobileqq.nearby.now.datasource;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopGiftProtocolObserver;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.profilecard.INearbyMomentManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.now.NowNearbyVideoCommentProto.DelCommentResp;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import tencent.im.oidb.cmd0xada.oidb_0xada.RspBody;

class CommentsDataSourceImpl$3
  extends ProtoUtils.TroopGiftProtocolObserver
{
  CommentsDataSourceImpl$3(CommentsDataSourceImpl paramCommentsDataSourceImpl, CommentsDataSource.DeleteCommentCallback paramDeleteCommentCallback, Comments.Comment paramComment) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    paramBundle = new StringBuilder();
    paramBundle.append("errorCode:");
    paramBundle.append(paramInt);
    QLog.i("CommentsDataSource", 1, paramBundle.toString());
    if ((paramInt == 0) && (paramArrayOfByte != null)) {
      paramBundle = new oidb_0xada.RspBody();
    }
    try
    {
      paramBundle.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("err_msg:");
      paramArrayOfByte.append(paramBundle.err_msg.get());
      QLog.i("CommentsDataSource", 1, paramArrayOfByte.toString());
      if (paramBundle.busi_buf.has())
      {
        paramArrayOfByte = new NowNearbyVideoCommentProto.DelCommentResp();
        paramArrayOfByte.mergeFrom(paramBundle.busi_buf.get().toByteArray());
        if (QLog.isColorLevel())
        {
          paramBundle = new StringBuilder();
          paramBundle.append("ret:");
          paramBundle.append(paramArrayOfByte.result.get());
          QLog.i("CommentsDataSource", 1, paramBundle.toString());
        }
        this.b.a(this.c, (int)paramArrayOfByte.result.get());
        paramArrayOfByte = (AppInterface)this.a.get();
        if (paramArrayOfByte == null) {
          break label295;
        }
        ((INearbyMomentManager)paramArrayOfByte.getManager(QQManagerFactory.NEARBY_MOMENT_MANAGER)).a(CommentsDataSourceImpl.b(this.d).c, this.c.a);
        return;
      }
      QLog.i("CommentsDataSource", 1, "rspBody.busi_buf is null");
      this.b.a(this.c, -1);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      label258:
      label295:
      break label258;
    }
    QLog.i("CommentsDataSource", 1, "merge delete resp data error");
    this.b.a(this.c, -1);
    return;
    this.b.a(this.c, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.datasource.CommentsDataSourceImpl.3
 * JD-Core Version:    0.7.0.1
 */