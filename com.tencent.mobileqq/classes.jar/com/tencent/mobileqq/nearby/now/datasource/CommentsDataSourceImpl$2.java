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
import com.tencent.pb.now.NowNearbyVideoCommentProto.AddCommentNoFilterResp;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import tencent.im.oidb.cmd0xada.oidb_0xada.RspBody;

class CommentsDataSourceImpl$2
  extends ProtoUtils.TroopGiftProtocolObserver
{
  CommentsDataSourceImpl$2(CommentsDataSourceImpl paramCommentsDataSourceImpl, CommentsDataSource.PublishCommentCallback paramPublishCommentCallback, Comments.Comment paramComment) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    paramBundle = new StringBuilder();
    paramBundle.append("errorCode:");
    paramBundle.append(paramInt);
    QLog.i("CommentsDataSource", 1, paramBundle.toString());
    Object localObject = "";
    oidb_0xada.RspBody localRspBody;
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      localRspBody = new oidb_0xada.RspBody();
      paramBundle = (Bundle)localObject;
    }
    try
    {
      localRspBody.mergeFrom(paramArrayOfByte);
      paramBundle = (Bundle)localObject;
      if (QLog.isColorLevel())
      {
        paramBundle = (Bundle)localObject;
        paramArrayOfByte = new StringBuilder();
        paramBundle = (Bundle)localObject;
        paramArrayOfByte.append("err_msg:   ");
        paramBundle = (Bundle)localObject;
        paramArrayOfByte.append(localRspBody.err_msg.get());
        paramBundle = (Bundle)localObject;
        QLog.i("CommentsDataSource", 2, paramArrayOfByte.toString());
      }
      paramBundle = (Bundle)localObject;
      if (!localRspBody.busi_buf.has())
      {
        paramBundle = (Bundle)localObject;
        QLog.i("CommentsDataSource", 1, "rspBody.busi_buf is null");
        paramBundle = (Bundle)localObject;
        this.b.a(this.c, -1, "");
        return;
      }
      paramBundle = (Bundle)localObject;
      NowNearbyVideoCommentProto.AddCommentNoFilterResp localAddCommentNoFilterResp = new NowNearbyVideoCommentProto.AddCommentNoFilterResp();
      paramBundle = (Bundle)localObject;
      localAddCommentNoFilterResp.mergeFrom(localRspBody.busi_buf.get().toByteArray());
      paramArrayOfByte = (byte[])localObject;
      paramBundle = (Bundle)localObject;
      if (localAddCommentNoFilterResp.wording.has())
      {
        paramBundle = (Bundle)localObject;
        paramArrayOfByte = localAddCommentNoFilterResp.wording.get().toStringUtf8();
      }
      paramBundle = paramArrayOfByte;
      localObject = new StringBuilder();
      paramBundle = paramArrayOfByte;
      ((StringBuilder)localObject).append("id: ");
      paramBundle = paramArrayOfByte;
      ((StringBuilder)localObject).append(localAddCommentNoFilterResp.comment_id.get());
      paramBundle = paramArrayOfByte;
      ((StringBuilder)localObject).append(",ret:");
      paramBundle = paramArrayOfByte;
      ((StringBuilder)localObject).append(localAddCommentNoFilterResp.result.get());
      paramBundle = paramArrayOfByte;
      ((StringBuilder)localObject).append(", tip=");
      paramBundle = paramArrayOfByte;
      ((StringBuilder)localObject).append(paramArrayOfByte);
      paramBundle = paramArrayOfByte;
      QLog.d("CommentsDataSource", 1, ((StringBuilder)localObject).toString());
      paramBundle = paramArrayOfByte;
      if (localAddCommentNoFilterResp.result.get() != 0L)
      {
        paramBundle = paramArrayOfByte;
        localObject = new StringBuilder();
        paramBundle = paramArrayOfByte;
        ((StringBuilder)localObject).append("error code :");
        paramBundle = paramArrayOfByte;
        ((StringBuilder)localObject).append(localAddCommentNoFilterResp.result.get());
        paramBundle = paramArrayOfByte;
        QLog.i("CommentsDataSource", 1, ((StringBuilder)localObject).toString());
        paramBundle = paramArrayOfByte;
        this.b.a(this.c, (int)localAddCommentNoFilterResp.result.get(), paramArrayOfByte);
        return;
      }
      paramBundle = paramArrayOfByte;
      if (localAddCommentNoFilterResp.comment_id.get() <= 0L) {
        break label583;
      }
      paramBundle = paramArrayOfByte;
      this.c.a = localAddCommentNoFilterResp.comment_id.get();
      paramBundle = paramArrayOfByte;
      this.b.a(this.c);
      paramBundle = paramArrayOfByte;
      CommentsDataSourceImpl.a(this.d).add(Long.valueOf(localAddCommentNoFilterResp.comment_id.get()));
      paramBundle = paramArrayOfByte;
      localObject = (AppInterface)this.a.get();
      if (localObject == null) {
        break label583;
      }
      paramBundle = paramArrayOfByte;
      ((INearbyMomentManager)((AppInterface)localObject).getManager(QQManagerFactory.NEARBY_MOMENT_MANAGER)).a(CommentsDataSourceImpl.b(this.d).c);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      label535:
      break label535;
    }
    QLog.i("CommentsDataSource", 1, "merge publish resp data error");
    this.b.a(this.c, -1, paramBundle);
    return;
    QLog.i("CommentsDataSource", 1, "publishComment failed");
    this.b.a(this.c, -1, "");
    label583:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.datasource.CommentsDataSourceImpl.2
 * JD-Core Version:    0.7.0.1
 */