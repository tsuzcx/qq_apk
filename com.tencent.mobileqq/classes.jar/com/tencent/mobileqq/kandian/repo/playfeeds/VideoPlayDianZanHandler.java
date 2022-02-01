package com.tencent.mobileqq.kandian.repo.playfeeds;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.FeedsInfo;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.ReqBody;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.RspBody;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.FeedsInfo;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.RspBody;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.SocializeFeedsInfo;

public class VideoPlayDianZanHandler
  extends BusinessHandler
{
  static final String a;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Q.pubaccount.video.");
    localStringBuilder.append(VideoPlayDianZanObserver.class.getSimpleName());
    a = localStringBuilder.toString();
  }
  
  public VideoPlayDianZanHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public VideoPlayDianZanHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject1 = new oidb_cmd0x8c8.RspBody();
    int k = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, (MessageMicro)localObject1);
    paramObject = new Bundle();
    paramToServiceMsg = "";
    if (k == 0)
    {
      if ((((oidb_cmd0x8c8.RspBody)localObject1).rpt_social_feeds_info.has()) && (((oidb_cmd0x8c8.RspBody)localObject1).rpt_social_feeds_info.get() != null))
      {
        localObject1 = ((oidb_cmd0x8c8.RspBody)localObject1).rpt_social_feeds_info.get().iterator();
        paramToServiceMsg = "";
        i = 2;
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (oidb_cmd0x8c8.FeedsInfo)((Iterator)localObject1).next();
          if ((((oidb_cmd0x8c8.FeedsInfo)localObject2).bytes_rowkey.has()) && (((oidb_cmd0x8c8.FeedsInfo)localObject2).bytes_rowkey.get() != null))
          {
            paramFromServiceMsg = ((oidb_cmd0x8c8.FeedsInfo)localObject2).bytes_rowkey.get().toStringUtf8();
          }
          else
          {
            paramFromServiceMsg = paramToServiceMsg;
            if (QLog.isColorLevel())
            {
              QLog.e(a, 2, "getFavoriteState, 返回的articleId空");
              paramFromServiceMsg = paramToServiceMsg;
            }
          }
          paramToServiceMsg = paramFromServiceMsg;
          if (((oidb_cmd0x8c8.FeedsInfo)localObject2).has())
          {
            paramToServiceMsg = paramFromServiceMsg;
            if (((oidb_cmd0x8c8.FeedsInfo)localObject2).get() != null)
            {
              paramToServiceMsg = paramFromServiceMsg;
              if (((oidb_cmd0x8c8.FeedsInfo)localObject2).msg_social_fees_info.has())
              {
                paramToServiceMsg = paramFromServiceMsg;
                if (((oidb_cmd0x8c8.FeedsInfo)localObject2).msg_social_fees_info.get() != null)
                {
                  paramToServiceMsg = (oidb_cmd0x8c8.SocializeFeedsInfo)((oidb_cmd0x8c8.FeedsInfo)localObject2).msg_social_fees_info.get();
                  if (paramToServiceMsg.uint32_myself_like_status.has())
                  {
                    int j = paramToServiceMsg.uint32_myself_like_status.get();
                    i = j;
                    paramToServiceMsg = paramFromServiceMsg;
                    if (QLog.isColorLevel())
                    {
                      paramToServiceMsg = a;
                      localObject2 = new StringBuilder();
                      ((StringBuilder)localObject2).append("getFavoriteState，faviriteState为:");
                      ((StringBuilder)localObject2).append(j);
                      QLog.d(paramToServiceMsg, 2, ((StringBuilder)localObject2).toString());
                      i = j;
                      paramToServiceMsg = paramFromServiceMsg;
                    }
                  }
                  else
                  {
                    paramToServiceMsg = paramFromServiceMsg;
                    if (QLog.isColorLevel())
                    {
                      QLog.d(a, 2, "getFavoriteState，faviriteState为空");
                      paramToServiceMsg = paramFromServiceMsg;
                    }
                  }
                }
              }
            }
          }
        }
        break label335;
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.e(a, 2, "getFavoriteState, 返回直接出错了");
    }
    int i = 2;
    label335:
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = a;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getFavoriteState articleId :");
      ((StringBuilder)localObject1).append(paramToServiceMsg);
      ((StringBuilder)localObject1).append(" faviriteState :");
      ((StringBuilder)localObject1).append(i);
      QLog.d(paramFromServiceMsg, 2, ((StringBuilder)localObject1).toString());
    }
    paramObject.putInt("VALUE_VIDEO_FAVORITE_STATE", i);
    paramObject.putString("VALUE_VIDEO_ARTICLE_ID", paramToServiceMsg);
    boolean bool;
    if (k == 0) {
      bool = true;
    } else {
      bool = false;
    }
    super.notifyUI(1, bool, paramObject);
  }
  
  private void a(boolean paramBoolean1, long paramLong, int paramInt, String paramString, boolean paramBoolean2)
  {
    oidb_cmd0x83e.ReqBody localReqBody = new oidb_cmd0x83e.ReqBody();
    localReqBody.uint64_uin.set(Long.parseLong(RIJQQAppInterfaceUtil.d()));
    if (paramBoolean1)
    {
      localReqBody.uint64_feeds_id.set(paramLong);
      localReqBody.msg_feeds_info = new oidb_cmd0x83e.FeedsInfo();
      localReqBody.msg_feeds_info.feeds_type.set(paramInt);
    }
    else
    {
      localReqBody.bytes_inner_uniq_id.set(ByteStringMicro.copyFromUtf8(paramString));
    }
    if (paramBoolean2) {
      localReqBody.uint32_operation.set(2);
    } else {
      localReqBody.uint32_operation.set(3);
    }
    super.sendPbReq(super.makeOIDBPkg("OidbSvc.0x83e", 2110, 0, localReqBody.toByteArray()));
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new oidb_cmd0x83e.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    boolean bool = true;
    if (i == 0)
    {
      QLog.d(a, 1, "handle0x83eUpvoteAction result OK");
      if (QLog.isColorLevel())
      {
        if (paramToServiceMsg.uint64_feeds_id.has())
        {
          paramFromServiceMsg = a;
          paramObject = new StringBuilder();
          paramObject.append("upvote feeds id:");
          paramObject.append(paramToServiceMsg.uint64_feeds_id.get());
          QLog.d(paramFromServiceMsg, 2, paramObject.toString());
        }
        if (paramToServiceMsg.uint32_operation.has())
        {
          paramFromServiceMsg = a;
          paramObject = new StringBuilder();
          paramObject.append("upvote status:");
          if (paramToServiceMsg.uint32_operation.get() != 2) {
            bool = false;
          }
          paramObject.append(bool);
          QLog.d(paramFromServiceMsg, 2, paramObject.toString());
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      paramToServiceMsg = a;
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handle0x83eUpvoteAction result wrong:");
      paramFromServiceMsg.append(i);
      QLog.d(paramToServiceMsg, 1, paramFromServiceMsg.toString());
    }
  }
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    if (paramVideoInfo == null) {
      return;
    }
    if (paramVideoInfo.t)
    {
      a(true, paramVideoInfo.E, paramVideoInfo.F, null, paramBoolean);
      return;
    }
    a(false, -1L, -1, paramVideoInfo.l, paramBoolean);
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, boolean paramBoolean)
  {
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    if (!RIJItemViewTypeUtils.x(paramAbsBaseArticleInfo))
    {
      a(true, paramAbsBaseArticleInfo.mFeedId, paramAbsBaseArticleInfo.mFeedType, null, paramBoolean);
      return;
    }
    a(false, -1L, -1, paramAbsBaseArticleInfo.innerUniqueID, paramBoolean);
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0x8c8");
      this.allowCmdSet.add("OidbSvc.0x83e");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return VideoPlayDianZanObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "handleGetPlayCount onReceive");
    }
    if (msgCmdFilter(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    try
    {
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x8c8"))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x83e"))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    }
    catch (Exception paramToServiceMsg)
    {
      if (QLog.isColorLevel())
      {
        paramObject = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onReceive ERROR e=");
        localStringBuilder.append(paramToServiceMsg.getMessage());
        localStringBuilder.append(paramFromServiceMsg.getServiceCmd());
        QLog.e(paramObject, 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.playfeeds.VideoPlayDianZanHandler
 * JD-Core Version:    0.7.0.1
 */