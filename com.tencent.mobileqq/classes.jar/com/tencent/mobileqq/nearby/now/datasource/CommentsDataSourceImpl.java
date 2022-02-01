package com.tencent.mobileqq.nearby.now.datasource;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.now.NowNearbyVideoCommentProto.AddCommentNoFilterReq;
import com.tencent.pb.now.NowNearbyVideoCommentProto.CommentMsg;
import com.tencent.pb.now.NowNearbyVideoCommentProto.CommentMsgBody;
import com.tencent.pb.now.NowNearbyVideoCommentProto.DelCommentReq;
import com.tencent.pb.now.NowNearbyVideoCommentProto.GetCommentListNoFilterReq;
import com.tencent.pb.now.NowNearbyVideoCommentProto.UserInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import mqq.manager.TicketManager;
import tencent.im.oidb.cmd0xada.oidb_0xada.ReqBody;

public class CommentsDataSourceImpl
  implements CommentsDataSource
{
  QQAppInterface a = null;
  private Handler b = new Handler();
  private HashSet<Long> c = new HashSet();
  private VideoData d;
  
  public CommentsDataSourceImpl(VideoData paramVideoData, QQAppInterface paramQQAppInterface)
  {
    this.d = paramVideoData;
    this.a = paramQQAppInterface;
  }
  
  private boolean a(oidb_0xada.ReqBody paramReqBody)
  {
    paramReqBody.uid.set(Long.parseLong(this.a.getCurrentAccountUin()));
    paramReqBody.tinyid.set(Long.parseLong(this.a.getCurrentAccountUin()));
    Object localObject = (TicketManager)this.a.getManager(2);
    String str = ((TicketManager)localObject).getA2(this.a.getCurrentAccountUin());
    localObject = ((TicketManager)localObject).getSkey(this.a.getCurrentAccountUin());
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      paramReqBody.a2.set(str);
      paramReqBody.platform.set(1);
      paramReqBody.version.set("8.8.17");
      paramReqBody.original_id.set(this.a.getCurrentAccountUin());
      paramReqBody.original_key.set((String)localObject);
      paramReqBody.original_id_type.set(1);
      return true;
    }
    return false;
  }
  
  public int a()
  {
    try
    {
      int i = Integer.parseInt("8.8.17".replace(".", ""));
      return i;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getVersionInt exp:");
        localStringBuilder.append(localException.toString());
        QLog.e("CommentsDataSource", 2, localStringBuilder.toString());
      }
    }
    return 0;
  }
  
  public void a(int paramInt, CommentsDataSource.LoadCommentsCallback paramLoadCommentsCallback)
  {
    if (this.d != null)
    {
      if (this.a == null) {
        return;
      }
      oidb_0xada.ReqBody localReqBody = new oidb_0xada.ReqBody();
      if (!a(localReqBody))
      {
        QLog.i("CommentsDataSource", 1, "oidb_0xada configCommonFileds failed");
        paramLoadCommentsCallback.a();
      }
      NowNearbyVideoCommentProto.GetCommentListNoFilterReq localGetCommentListNoFilterReq = new NowNearbyVideoCommentProto.GetCommentListNoFilterReq();
      localGetCommentListNoFilterReq.count.set(20L);
      if (!TextUtils.isEmpty(this.d.c)) {
        localGetCommentListNoFilterReq.feed_id.set(this.d.c);
      }
      localGetCommentListNoFilterReq.feed_type.set(this.d.G);
      localGetCommentListNoFilterReq.page.set(paramInt);
      localGetCommentListNoFilterReq.filter.set(0L);
      localReqBody.cmd.set(857);
      localReqBody.subcmd.set(8);
      localReqBody.busi_buf.set(ByteStringMicro.copyFrom(localGetCommentListNoFilterReq.toByteArray()));
      ProtoUtils.a(this.a, new CommentsDataSourceImpl.1(this, paramLoadCommentsCallback), localReqBody.toByteArray(), "OidbSvc.0xada_0", 2778, 0, null, 0L);
    }
  }
  
  public void a(Comments.Comment paramComment, CommentsDataSource.DeleteCommentCallback paramDeleteCommentCallback)
  {
    if (this.d != null)
    {
      if (this.a == null) {
        return;
      }
      oidb_0xada.ReqBody localReqBody = new oidb_0xada.ReqBody();
      if (a(localReqBody))
      {
        localReqBody.cmd.set(857);
        localReqBody.subcmd.set(3);
        NowNearbyVideoCommentProto.DelCommentReq localDelCommentReq = new NowNearbyVideoCommentProto.DelCommentReq();
        localDelCommentReq.feed_id.set(ByteStringMicro.copyFrom(this.d.c.getBytes()));
        localDelCommentReq.comment_id.set(paramComment.a);
        localReqBody.busi_buf.set(ByteStringMicro.copyFrom(localDelCommentReq.toByteArray()));
        ProtoUtils.a(this.a, new CommentsDataSourceImpl.3(this, paramDeleteCommentCallback, paramComment), localReqBody.toByteArray(), "OidbSvc.0xada_0", 2778, 0, null, 0L);
        return;
      }
      paramDeleteCommentCallback.a(paramComment, -1);
    }
  }
  
  public void a(Comments.Comment paramComment, CommentsDataSource.PublishCommentCallback paramPublishCommentCallback)
  {
    if (this.d != null)
    {
      if (this.a == null) {
        return;
      }
      oidb_0xada.ReqBody localReqBody = new oidb_0xada.ReqBody();
      if (!a(localReqBody))
      {
        QLog.i("CommentsDataSource", 1, "oidb_0xada configCommonFileds failed");
        paramPublishCommentCallback.a(paramComment, -1, "");
        return;
      }
      Object localObject1 = new NowNearbyVideoCommentProto.AddCommentNoFilterReq();
      if (this.d.G == VideoData.a) {
        ((NowNearbyVideoCommentProto.AddCommentNoFilterReq)localObject1).feed_type.set(6L);
      } else if (this.d.G == 4) {
        ((NowNearbyVideoCommentProto.AddCommentNoFilterReq)localObject1).feed_type.set(4L);
      } else {
        ((NowNearbyVideoCommentProto.AddCommentNoFilterReq)localObject1).feed_type.set(3L);
      }
      ((NowNearbyVideoCommentProto.AddCommentNoFilterReq)localObject1).feed_id.set(this.d.c);
      Object localObject2 = new NowNearbyVideoCommentProto.UserInfo();
      ((NowNearbyVideoCommentProto.UserInfo)localObject2).uid.set(this.d.u);
      ((NowNearbyVideoCommentProto.UserInfo)localObject2).user_type.set(this.d.w);
      ((NowNearbyVideoCommentProto.UserInfo)localObject2).now_id.set(this.d.v);
      ((NowNearbyVideoCommentProto.AddCommentNoFilterReq)localObject1).video_recorder.set((MessageMicro)localObject2);
      if ((paramComment.k > 0L) || (paramComment.n > 0L))
      {
        localObject2 = new NowNearbyVideoCommentProto.UserInfo();
        ((NowNearbyVideoCommentProto.UserInfo)localObject2).uid.set(paramComment.k);
        ((NowNearbyVideoCommentProto.UserInfo)localObject2).user_type.set(paramComment.m);
        ((NowNearbyVideoCommentProto.UserInfo)localObject2).now_id.set(paramComment.n);
        ((NowNearbyVideoCommentProto.AddCommentNoFilterReq)localObject1).reply_user.set((MessageMicro)localObject2);
      }
      localObject2 = new NowNearbyVideoCommentProto.UserInfo();
      ((NowNearbyVideoCommentProto.UserInfo)localObject2).uid.set(this.d.C);
      ((NowNearbyVideoCommentProto.UserInfo)localObject2).now_id.set(this.d.D);
      ((NowNearbyVideoCommentProto.UserInfo)localObject2).user_type.set(this.d.E);
      ((NowNearbyVideoCommentProto.AddCommentNoFilterReq)localObject1).video_owner.set((MessageMicro)localObject2);
      ((NowNearbyVideoCommentProto.AddCommentNoFilterReq)localObject1).is_aggregate_short_video.set(0);
      localObject2 = new NowNearbyVideoCommentProto.UserInfo();
      ((NowNearbyVideoCommentProto.UserInfo)localObject2).uid.set(this.d.i);
      ((NowNearbyVideoCommentProto.UserInfo)localObject2).user_type.set(this.d.l);
      ((NowNearbyVideoCommentProto.UserInfo)localObject2).now_id.set(this.d.k);
      ((NowNearbyVideoCommentProto.AddCommentNoFilterReq)localObject1).video_anchor.set((MessageMicro)localObject2);
      localObject2 = new NowNearbyVideoCommentProto.CommentMsgBody();
      NowNearbyVideoCommentProto.CommentMsg localCommentMsg = new NowNearbyVideoCommentProto.CommentMsg();
      localCommentMsg.msg.set(ByteStringMicro.copyFromUtf8(paramComment.b));
      localCommentMsg.type.set(0);
      ((NowNearbyVideoCommentProto.CommentMsgBody)localObject2).msgs.add(localCommentMsg);
      ((NowNearbyVideoCommentProto.AddCommentNoFilterReq)localObject1).content.set((MessageMicro)localObject2);
      localReqBody.cmd.set(857);
      localReqBody.subcmd.set(9);
      localReqBody.busi_buf.set(ByteStringMicro.copyFrom(((NowNearbyVideoCommentProto.AddCommentNoFilterReq)localObject1).toByteArray()));
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("print bytes count =");
        ((StringBuilder)localObject2).append(((NowNearbyVideoCommentProto.AddCommentNoFilterReq)localObject1).toByteArray().length);
        QLog.i("CommentsDataSource", 2, ((StringBuilder)localObject2).toString());
      }
      int i = a();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("publishComment, qqver=");
      ((StringBuilder)localObject1).append(i);
      QLog.i("CommentsDataSource", 1, ((StringBuilder)localObject1).toString());
      if (i > 0) {
        localReqBody.version_code.set(i);
      }
      ProtoUtils.a(this.a, new CommentsDataSourceImpl.2(this, paramPublishCommentCallback, paramComment), localReqBody.toByteArray(), "OidbSvc.0xada_0", 2778, 0, null, 0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.datasource.CommentsDataSourceImpl
 * JD-Core Version:    0.7.0.1
 */