package com.tencent.mobileqq.nearby.now.datasource;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopGiftProtocolObserver;
import com.tencent.mobileqq.nearby.now.model.Comments;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.now.NowNearbyVideoCommentProto.Comment;
import com.tencent.pb.now.NowNearbyVideoCommentProto.CommentMsg;
import com.tencent.pb.now.NowNearbyVideoCommentProto.CommentMsgBody;
import com.tencent.pb.now.NowNearbyVideoCommentProto.GetCommentListResp;
import com.tencent.pb.now.NowNearbyVideoCommentProto.UserInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0xada.oidb_0xada.RspBody;

class CommentsDataSourceImpl$1
  extends ProtoUtils.TroopGiftProtocolObserver
{
  CommentsDataSourceImpl$1(CommentsDataSourceImpl paramCommentsDataSourceImpl, CommentsDataSource.LoadCommentsCallback paramLoadCommentsCallback) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    paramBundle = new StringBuilder();
    paramBundle.append("errorCode:");
    paramBundle.append(paramInt);
    QLog.i("CommentsDataSource", 1, paramBundle.toString());
    if ((paramInt == 0) && (paramArrayOfByte != null)) {
      paramBundle = new oidb_0xada.RspBody();
    }
    for (;;)
    {
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("err_msg:");
        paramArrayOfByte.append(paramBundle.err_msg.get());
        QLog.i("CommentsDataSource", 1, paramArrayOfByte.toString());
        if (!paramBundle.busi_buf.has())
        {
          QLog.i("CommentsDataSource", 1, "rspBody.busi_buf is null");
          this.b.a();
          return;
        }
        paramArrayOfByte = new NowNearbyVideoCommentProto.GetCommentListResp();
        paramArrayOfByte.mergeFrom(paramBundle.busi_buf.get().toByteArray());
        if (paramArrayOfByte.result.get() != 0L)
        {
          paramBundle = new StringBuilder();
          paramBundle.append("error code :");
          paramBundle.append(paramArrayOfByte.result.get());
          QLog.i("CommentsDataSource", 1, paramBundle.toString());
          this.b.a();
          return;
        }
        paramBundle = new Comments();
        paramBundle.a = paramArrayOfByte.total_num.get();
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("all comments count is: ");
        ((StringBuilder)localObject).append(paramBundle.a);
        QLog.i("CommentsDataSource", 1, ((StringBuilder)localObject).toString());
        if (paramArrayOfByte.end_flag.get() != 1L) {
          break label853;
        }
        bool = true;
        paramBundle.b = bool;
        paramBundle.c = new ArrayList();
        if (paramArrayOfByte.lists.has())
        {
          localObject = paramArrayOfByte.lists.get().iterator();
          if (((Iterator)localObject).hasNext())
          {
            NowNearbyVideoCommentProto.Comment localComment = (NowNearbyVideoCommentProto.Comment)((Iterator)localObject).next();
            Comments.Comment localComment1 = new Comments.Comment();
            localComment1.a = localComment.comment_id.get();
            localComment1.c = localComment.create_time.get();
            localComment1.d = localComment.type.get();
            if (localComment.publish_info.has())
            {
              localComment1.f = localComment.publish_info.uid.get();
              localComment1.e = localComment.publish_info.anchor_name.get().toStringUtf8();
              localComment1.g = localComment.publish_info.head_img_url.get().toStringUtf8();
              localComment1.h = localComment.publish_info.user_type.get();
              localComment1.i = localComment.publish_info.now_id.get();
              if (localComment.reply_info.has())
              {
                localComment1.k = localComment.reply_info.uid.get();
                localComment1.j = localComment.reply_info.anchor_name.get().toStringUtf8();
                localComment1.l = localComment.reply_info.head_img_url.get().toStringUtf8();
                localComment1.m = localComment.reply_info.user_type.get();
                localComment1.n = localComment.reply_info.now_id.get();
              }
            }
            if ((localComment.content.has()) && (localComment.content.msgs.has())) {
              localComment1.b = ((NowNearbyVideoCommentProto.CommentMsg)localComment.content.msgs.get(0)).msg.get().toStringUtf8();
            }
            if (!CommentsDataSourceImpl.a(this.c).contains(Long.valueOf(localComment.comment_id.get()))) {
              CommentsDataSourceImpl.a(this.c).add(Long.valueOf(localComment.comment_id.get()));
            }
            if (localComment1.d == 2) {
              paramBundle.d.add(localComment1);
            }
            paramBundle.c.add(localComment1);
            continue;
          }
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("total:");
        ((StringBuilder)localObject).append(paramArrayOfByte.total_num.get());
        ((StringBuilder)localObject).append(", ret:");
        ((StringBuilder)localObject).append(paramArrayOfByte.result.get());
        QLog.i("CommentsDataSource", 1, ((StringBuilder)localObject).toString());
        this.b.a(paramBundle);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        paramBundle = new StringBuilder();
        paramBundle.append("merge data error ");
        paramBundle.append(paramArrayOfByte);
        QLog.i("CommentsDataSource", 1, paramBundle.toString());
        this.b.a();
        return;
      }
      QLog.i("CommentsDataSource", 1, "getComments failed");
      this.b.a();
      return;
      label853:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.datasource.CommentsDataSourceImpl.1
 * JD-Core Version:    0.7.0.1
 */