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
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  private VideoData jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData;
  private HashSet<Long> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  
  public CommentsDataSourceImpl(VideoData paramVideoData, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData = paramVideoData;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private boolean a(oidb_0xada.ReqBody paramReqBody)
  {
    paramReqBody.uid.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    paramReqBody.tinyid.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    Object localObject = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
    String str = ((TicketManager)localObject).getA2(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localObject = ((TicketManager)localObject).getSkey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      paramReqBody.a2.set(str);
      paramReqBody.platform.set(1);
      paramReqBody.version.set("8.7.0");
      paramReqBody.original_id.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
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
      int i = Integer.parseInt("8.7.0".replace(".", ""));
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
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
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
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString)) {
        localGetCommentListNoFilterReq.feed_id.set(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString);
      }
      localGetCommentListNoFilterReq.feed_type.set(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.k);
      localGetCommentListNoFilterReq.page.set(paramInt);
      localGetCommentListNoFilterReq.filter.set(0L);
      localReqBody.cmd.set(857);
      localReqBody.subcmd.set(8);
      localReqBody.busi_buf.set(ByteStringMicro.copyFrom(localGetCommentListNoFilterReq.toByteArray()));
      ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new CommentsDataSourceImpl.1(this, paramLoadCommentsCallback), localReqBody.toByteArray(), "OidbSvc.0xada_0", 2778, 0, null, 0L);
    }
  }
  
  public void a(Comments.Comment paramComment, CommentsDataSource.DeleteCommentCallback paramDeleteCommentCallback)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        return;
      }
      oidb_0xada.ReqBody localReqBody = new oidb_0xada.ReqBody();
      if (a(localReqBody))
      {
        localReqBody.cmd.set(857);
        localReqBody.subcmd.set(3);
        NowNearbyVideoCommentProto.DelCommentReq localDelCommentReq = new NowNearbyVideoCommentProto.DelCommentReq();
        localDelCommentReq.feed_id.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString.getBytes()));
        localDelCommentReq.comment_id.set(paramComment.jdField_a_of_type_Long);
        localReqBody.busi_buf.set(ByteStringMicro.copyFrom(localDelCommentReq.toByteArray()));
        ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new CommentsDataSourceImpl.3(this, paramDeleteCommentCallback, paramComment), localReqBody.toByteArray(), "OidbSvc.0xada_0", 2778, 0, null, 0L);
        return;
      }
      paramDeleteCommentCallback.a(paramComment, -1);
    }
  }
  
  public void a(Comments.Comment paramComment, CommentsDataSource.PublishCommentCallback paramPublishCommentCallback)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
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
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.k == VideoData.jdField_a_of_type_Int) {
        ((NowNearbyVideoCommentProto.AddCommentNoFilterReq)localObject1).feed_type.set(6L);
      } else if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.k == 4) {
        ((NowNearbyVideoCommentProto.AddCommentNoFilterReq)localObject1).feed_type.set(4L);
      } else {
        ((NowNearbyVideoCommentProto.AddCommentNoFilterReq)localObject1).feed_type.set(3L);
      }
      ((NowNearbyVideoCommentProto.AddCommentNoFilterReq)localObject1).feed_id.set(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString);
      Object localObject2 = new NowNearbyVideoCommentProto.UserInfo();
      ((NowNearbyVideoCommentProto.UserInfo)localObject2).uid.set(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_d_of_type_Long);
      ((NowNearbyVideoCommentProto.UserInfo)localObject2).user_type.set(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_h_of_type_Int);
      ((NowNearbyVideoCommentProto.UserInfo)localObject2).now_id.set(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.e);
      ((NowNearbyVideoCommentProto.AddCommentNoFilterReq)localObject1).video_recorder.set((MessageMicro)localObject2);
      if ((paramComment.e > 0L) || (paramComment.f > 0L))
      {
        localObject2 = new NowNearbyVideoCommentProto.UserInfo();
        ((NowNearbyVideoCommentProto.UserInfo)localObject2).uid.set(paramComment.e);
        ((NowNearbyVideoCommentProto.UserInfo)localObject2).user_type.set(paramComment.c);
        ((NowNearbyVideoCommentProto.UserInfo)localObject2).now_id.set(paramComment.f);
        ((NowNearbyVideoCommentProto.AddCommentNoFilterReq)localObject1).reply_user.set((MessageMicro)localObject2);
      }
      localObject2 = new NowNearbyVideoCommentProto.UserInfo();
      ((NowNearbyVideoCommentProto.UserInfo)localObject2).uid.set(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_h_of_type_Long);
      ((NowNearbyVideoCommentProto.UserInfo)localObject2).now_id.set(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_i_of_type_Long);
      ((NowNearbyVideoCommentProto.UserInfo)localObject2).user_type.set(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_i_of_type_Int);
      ((NowNearbyVideoCommentProto.AddCommentNoFilterReq)localObject1).video_owner.set((MessageMicro)localObject2);
      ((NowNearbyVideoCommentProto.AddCommentNoFilterReq)localObject1).is_aggregate_short_video.set(0);
      localObject2 = new NowNearbyVideoCommentProto.UserInfo();
      ((NowNearbyVideoCommentProto.UserInfo)localObject2).uid.set(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Long);
      ((NowNearbyVideoCommentProto.UserInfo)localObject2).user_type.set(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_d_of_type_Int);
      ((NowNearbyVideoCommentProto.UserInfo)localObject2).now_id.set(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.c);
      ((NowNearbyVideoCommentProto.AddCommentNoFilterReq)localObject1).video_anchor.set((MessageMicro)localObject2);
      localObject2 = new NowNearbyVideoCommentProto.CommentMsgBody();
      NowNearbyVideoCommentProto.CommentMsg localCommentMsg = new NowNearbyVideoCommentProto.CommentMsg();
      localCommentMsg.msg.set(ByteStringMicro.copyFromUtf8(paramComment.jdField_a_of_type_JavaLangString));
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
      ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new CommentsDataSourceImpl.2(this, paramPublishCommentCallback, paramComment), localReqBody.toByteArray(), "OidbSvc.0xada_0", 2778, 0, null, 0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.datasource.CommentsDataSourceImpl
 * JD-Core Version:    0.7.0.1
 */