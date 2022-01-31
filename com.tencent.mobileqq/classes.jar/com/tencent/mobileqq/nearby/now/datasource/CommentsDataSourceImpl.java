package com.tencent.mobileqq.nearby.now.datasource;

import aefd;
import aefe;
import aeff;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.now.NowNearbyVideoCommentProto.AddCommentReq;
import com.tencent.pb.now.NowNearbyVideoCommentProto.CommentMsg;
import com.tencent.pb.now.NowNearbyVideoCommentProto.CommentMsgBody;
import com.tencent.pb.now.NowNearbyVideoCommentProto.DelCommentReq;
import com.tencent.pb.now.NowNearbyVideoCommentProto.GetCommentListReq;
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
  private HashSet jdField_a_of_type_JavaUtilHashSet = new HashSet();
  
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
      paramReqBody.version.set("7.6.0");
      paramReqBody.original_id.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      paramReqBody.original_key.set((String)localObject);
      paramReqBody.original_id_type.set(1);
      return true;
    }
    return false;
  }
  
  public void a(int paramInt, CommentsDataSource.LoadCommentsCallback paramLoadCommentsCallback)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    oidb_0xada.ReqBody localReqBody = new oidb_0xada.ReqBody();
    if (!a(localReqBody))
    {
      QLog.i("CommentsDataSource", 1, "oidb_0xada configCommonFileds failed");
      paramLoadCommentsCallback.a();
    }
    NowNearbyVideoCommentProto.GetCommentListReq localGetCommentListReq = new NowNearbyVideoCommentProto.GetCommentListReq();
    localGetCommentListReq.count.set(20L);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString)) {
      localGetCommentListReq.feed_id.set(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString);
    }
    localGetCommentListReq.feed_type.set(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.g);
    localGetCommentListReq.page.set(paramInt);
    localGetCommentListReq.filter.set(0L);
    localReqBody.cmd.set(857);
    localReqBody.subcmd.set(1);
    localReqBody.busi_buf.set(ByteStringMicro.copyFrom(localGetCommentListReq.toByteArray()));
    ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new aefd(this, paramLoadCommentsCallback), localReqBody.toByteArray(), "OidbSvc.0xada_0", 2778, 0, null, 0L);
  }
  
  public void a(Comments.Comment paramComment, CommentsDataSource.DeleteCommentCallback paramDeleteCommentCallback)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
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
      ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new aeff(this, paramDeleteCommentCallback, paramComment), localReqBody.toByteArray(), "OidbSvc.0xada_0", 2778, 0, null, 0L);
      return;
    }
    paramDeleteCommentCallback.a(paramComment, -1);
  }
  
  public void a(Comments.Comment paramComment, CommentsDataSource.PublishCommentCallback paramPublishCommentCallback)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    oidb_0xada.ReqBody localReqBody = new oidb_0xada.ReqBody();
    if (!a(localReqBody))
    {
      QLog.i("CommentsDataSource", 1, "oidb_0xada configCommonFileds failed");
      paramPublishCommentCallback.a(paramComment, -1);
      return;
    }
    NowNearbyVideoCommentProto.AddCommentReq localAddCommentReq = new NowNearbyVideoCommentProto.AddCommentReq();
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.g != 4) {
      localAddCommentReq.feed_type.set(3L);
    }
    for (;;)
    {
      localAddCommentReq.feed_id.set(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString);
      localAddCommentReq.record_uid.set(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.b);
      if (paramComment.d > 0L) {
        localAddCommentReq.reply_uid.set(paramComment.d);
      }
      localAddCommentReq.feed_owner.set(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.e);
      localAddCommentReq.is_aggregate_short_video.set(0);
      localAddCommentReq.anchor_uid.set(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Long);
      NowNearbyVideoCommentProto.CommentMsgBody localCommentMsgBody = new NowNearbyVideoCommentProto.CommentMsgBody();
      NowNearbyVideoCommentProto.CommentMsg localCommentMsg = new NowNearbyVideoCommentProto.CommentMsg();
      localCommentMsg.msg.set(ByteStringMicro.copyFromUtf8(paramComment.jdField_a_of_type_JavaLangString));
      localCommentMsg.type.set(0);
      localCommentMsgBody.msgs.add(localCommentMsg);
      localAddCommentReq.content.set(localCommentMsgBody);
      localReqBody.cmd.set(857);
      localReqBody.subcmd.set(2);
      localReqBody.busi_buf.set(ByteStringMicro.copyFrom(localAddCommentReq.toByteArray()));
      ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new aefe(this, paramPublishCommentCallback, paramComment), localReqBody.toByteArray(), "OidbSvc.0xada_0", 2778, 0, null, 0L);
      return;
      localAddCommentReq.feed_type.set(4L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.datasource.CommentsDataSourceImpl
 * JD-Core Version:    0.7.0.1
 */