package com.tencent.mobileqq.nearby.profilecard.moment;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.now.model.TopicInfo;
import com.tencent.mobileqq.nearby.profilecard.moment.data.ChangMomentFeedInfo;
import com.tencent.mobileqq.nearby.profilecard.moment.data.CommentInfo;
import com.tencent.mobileqq.nearby.profilecard.moment.data.LiveMomentFeedInfo;
import com.tencent.mobileqq.nearby.profilecard.moment.data.MomentFeedInfo;
import com.tencent.mobileqq.nearby.profilecard.moment.data.PicMomentFeedInfo;
import com.tencent.mobileqq.nearby.profilecard.moment.data.ShortVideoMomentFeedInfo;
import com.tencent.mobileqq.nearby.profilecard.moment.data.TextMomentFeedInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.now.FeedsProtocol.LbsInfo;
import com.tencent.pb.now.NowNearbyVideoCommentProto.Comment;
import com.tencent.pb.now.NowNearbyVideoCommentProto.CommentMsg;
import com.tencent.pb.now.NowNearbyVideoCommentProto.CommentMsgBody;
import com.tencent.pb.now.NowNearbyVideoCommentProto.UserInfo;
import com.tencent.pb.now.ilive_feeds_read.FeedUserInfo;
import com.tencent.pb.now.ilive_feeds_read.FeedsInfo;
import com.tencent.pb.now.ilive_feeds_tmem.Chang;
import com.tencent.pb.now.ilive_feeds_tmem.ChangFeed;
import com.tencent.pb.now.ilive_feeds_tmem.FeedsTmemLike;
import com.tencent.pb.now.ilive_feeds_tmem.LiveFeed;
import com.tencent.pb.now.ilive_feeds_tmem.PicFeed;
import com.tencent.pb.now.ilive_feeds_tmem.PicInfo;
import com.tencent.pb.now.ilive_feeds_tmem.TextFeed;
import com.tencent.pb.now.ilive_feeds_tmem.VideoFeed;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class NearbyMomentManager
  implements Manager
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  protected DecimalFormat a;
  private List<NearbyMomentManager.MomentDataChangeObserver> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  
  public NearbyMomentManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaTextDecimalFormat = new DecimalFormat("#.##");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private MomentFeedInfo a(ilive_feeds_read.FeedsInfo paramFeedsInfo)
  {
    if (paramFeedsInfo == null) {
      return null;
    }
    Object localObject1;
    if (paramFeedsInfo.feed_type.get() == 5)
    {
      localObject1 = new LiveMomentFeedInfo();
      ((LiveMomentFeedInfo)localObject1).jdField_a_of_type_JavaLangString = paramFeedsInfo.live_info.pic_url.get().toStringUtf8();
      ((LiveMomentFeedInfo)localObject1).n = paramFeedsInfo.live_info.desc.get().toStringUtf8();
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        ((MomentFeedInfo)localObject1).jdField_d_of_type_Int = paramFeedsInfo.feed_type.get();
        ((MomentFeedInfo)localObject1).e = String.valueOf(paramFeedsInfo.publish_info.uin.get());
        ((MomentFeedInfo)localObject1).c = paramFeedsInfo.feeds_id.get().toStringUtf8();
        ((MomentFeedInfo)localObject1).jdField_d_of_type_JavaLangString = String.valueOf(paramFeedsInfo.publish_info.url.get().toStringUtf8());
        ((MomentFeedInfo)localObject1).m = paramFeedsInfo.jump_url.get().toStringUtf8();
        boolean bool;
        label162:
        double d1;
        if (paramFeedsInfo.like.get() == 1)
        {
          bool = true;
          ((MomentFeedInfo)localObject1).jdField_a_of_type_Boolean = bool;
          ((MomentFeedInfo)localObject1).jdField_f_of_type_Int = paramFeedsInfo.like_info.like_number.get();
          ((MomentFeedInfo)localObject1).jdField_g_of_type_Int = paramFeedsInfo.comment_num.get();
          ((MomentFeedInfo)localObject1).jdField_a_of_type_Long = paramFeedsInfo.create_time.get();
          ((MomentFeedInfo)localObject1).jdField_f_of_type_JavaLangString = NearbyMomentUtils.a(paramFeedsInfo.create_time.get() * 1000L);
          ((MomentFeedInfo)localObject1).h = paramFeedsInfo.lbs_info.lng.get().toStringUtf8();
          ((MomentFeedInfo)localObject1).i = paramFeedsInfo.lbs_info.lat.get().toStringUtf8();
          ((MomentFeedInfo)localObject1).j = paramFeedsInfo.lbs_info.city.get().toStringUtf8();
          ((MomentFeedInfo)localObject1).k = paramFeedsInfo.lbs_info.name.get().toStringUtf8();
          if (paramFeedsInfo.distance.has())
          {
            double d2 = paramFeedsInfo.distance.get();
            d1 = d2;
            if (d2 < 0.01D) {
              d1 = 0.01D;
            }
            if (d1 >= 100.0D) {
              break label1093;
            }
            ((MomentFeedInfo)localObject1).l = (this.jdField_a_of_type_JavaTextDecimalFormat.format(d1) + "km");
          }
          label375:
          if (TextUtils.isEmpty(paramFeedsInfo.lbs_info.name.get().toStringUtf8())) {
            break label1141;
          }
        }
        label1093:
        label1141:
        for (((MomentFeedInfo)localObject1).jdField_g_of_type_JavaLangString = paramFeedsInfo.lbs_info.name.get().toStringUtf8();; ((MomentFeedInfo)localObject1).jdField_g_of_type_JavaLangString = paramFeedsInfo.lbs_info.city.get().toStringUtf8())
        {
          Object localObject2 = paramFeedsInfo.comments.get();
          if (((List)localObject2).size() <= 0) {
            break label1168;
          }
          paramFeedsInfo = new ArrayList();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            NowNearbyVideoCommentProto.Comment localComment = (NowNearbyVideoCommentProto.Comment)((Iterator)localObject2).next();
            CommentInfo localCommentInfo = new CommentInfo();
            localCommentInfo.jdField_a_of_type_Long = localComment.comment_id.get();
            localCommentInfo.jdField_a_of_type_JavaLangString = localComment.publish_info.anchor_name.get().toStringUtf8();
            localCommentInfo.jdField_b_of_type_JavaLangString = localComment.reply_info.anchor_name.get().toStringUtf8();
            localCommentInfo.c = ((NowNearbyVideoCommentProto.CommentMsg)((NowNearbyVideoCommentProto.CommentMsgBody)localComment.content.get()).msgs.get().get(0)).msg.get().toStringUtf8();
            paramFeedsInfo.add(localCommentInfo);
          }
          if ((paramFeedsInfo.feed_type.get() == 1) || (paramFeedsInfo.feed_type.get() == 3) || (paramFeedsInfo.feed_type.get() == 2))
          {
            localObject1 = new ShortVideoMomentFeedInfo();
            ((ShortVideoMomentFeedInfo)localObject1).jdField_a_of_type_JavaLangString = paramFeedsInfo.feed_info.pic_url.get().toStringUtf8();
            ((ShortVideoMomentFeedInfo)localObject1).jdField_b_of_type_Long = paramFeedsInfo.feed_info.video_time.get();
            ((ShortVideoMomentFeedInfo)localObject1).jdField_a_of_type_Int = paramFeedsInfo.feed_info.video_width.get();
            ((ShortVideoMomentFeedInfo)localObject1).jdField_b_of_type_Int = paramFeedsInfo.feed_info.video_hight.get();
            ((ShortVideoMomentFeedInfo)localObject1).n = paramFeedsInfo.feed_info.desc.get().toStringUtf8();
            ((ShortVideoMomentFeedInfo)localObject1).e = paramFeedsInfo.view_times.get();
            localObject1 = (ShortVideoMomentFeedInfo)TopicInfo.a(paramFeedsInfo.topic_cfg.get(), (MomentFeedInfo)localObject1);
            break;
          }
          if (paramFeedsInfo.feed_type.get() == 4)
          {
            localObject1 = new PicMomentFeedInfo();
            localObject2 = paramFeedsInfo.pic_info.infos.get();
            if (((List)localObject2).size() > 0)
            {
              localObject2 = (ilive_feeds_tmem.PicInfo)((List)localObject2).get(0);
              ((PicMomentFeedInfo)localObject1).jdField_a_of_type_JavaLangString = ((ilive_feeds_tmem.PicInfo)localObject2).url.get().toStringUtf8();
              ((PicMomentFeedInfo)localObject1).jdField_a_of_type_Int = ((ilive_feeds_tmem.PicInfo)localObject2).width.get();
              ((PicMomentFeedInfo)localObject1).jdField_b_of_type_Int = ((ilive_feeds_tmem.PicInfo)localObject2).hight.get();
            }
            ((PicMomentFeedInfo)localObject1).n = paramFeedsInfo.pic_info.desc.get().toStringUtf8();
            localObject1 = (PicMomentFeedInfo)TopicInfo.a(paramFeedsInfo.topic_cfg.get(), (MomentFeedInfo)localObject1);
            break;
          }
          if (paramFeedsInfo.feed_type.get() == 6)
          {
            localObject1 = new ChangMomentFeedInfo();
            ((ChangMomentFeedInfo)localObject1).jdField_b_of_type_JavaLangString = paramFeedsInfo.chang_info.pic_url.get().toStringUtf8();
            ((ChangMomentFeedInfo)localObject1).jdField_a_of_type_Int = paramFeedsInfo.chang_info.width.get();
            ((ChangMomentFeedInfo)localObject1).jdField_b_of_type_Int = paramFeedsInfo.chang_info.hight.get();
            if (paramFeedsInfo.chang_info.chang.size() > 0) {
              ((ChangMomentFeedInfo)localObject1).jdField_a_of_type_JavaLangString = ((ilive_feeds_tmem.Chang)paramFeedsInfo.chang_info.chang.get(0)).id.get().toStringUtf8();
            }
            ((ChangMomentFeedInfo)localObject1).n = paramFeedsInfo.chang_info.desc.get().toStringUtf8();
            ((ChangMomentFeedInfo)localObject1).e = paramFeedsInfo.view_times.get();
            ((ChangMomentFeedInfo)localObject1).c = paramFeedsInfo.chang_info.chang.size();
            break;
          }
          if (paramFeedsInfo.feed_type.get() != 10) {
            break label1171;
          }
          localObject1 = new TextMomentFeedInfo();
          ((TextMomentFeedInfo)localObject1).n = paramFeedsInfo.text_feed.text.get();
          localObject1 = (TextMomentFeedInfo)TopicInfo.a(paramFeedsInfo.topic_cfg.get(), (MomentFeedInfo)localObject1);
          break;
          bool = false;
          break label162;
          this.jdField_a_of_type_JavaTextDecimalFormat = new DecimalFormat("#");
          ((MomentFeedInfo)localObject1).l = (this.jdField_a_of_type_JavaTextDecimalFormat.format(d1) + "km");
          break label375;
        }
        ((MomentFeedInfo)localObject1).jdField_a_of_type_JavaUtilList = paramFeedsInfo;
      }
      label1168:
      return localObject1;
      label1171:
      localObject1 = null;
    }
  }
  
  private List<MomentFeedInfo> a(List<ilive_feeds_read.FeedsInfo> paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MomentFeedInfo localMomentFeedInfo = a((ilive_feeds_read.FeedsInfo)paramList.next());
      if (localMomentFeedInfo != null)
      {
        a(localMomentFeedInfo);
        localArrayList.add(localMomentFeedInfo);
      }
    }
    return localArrayList;
  }
  
  private void a(MomentFeedInfo paramMomentFeedInfo)
  {
    if ((paramMomentFeedInfo == null) || (TextUtils.isEmpty(paramMomentFeedInfo.n))) {
      return;
    }
    Matcher localMatcher = Pattern.compile("\\[:([^(:\\])]+):\\]").matcher(paramMomentFeedInfo.n);
    StringBuffer localStringBuffer = new StringBuffer();
    while (localMatcher.find()) {
      localMatcher.appendReplacement(localStringBuffer, "");
    }
    localMatcher.appendTail(localStringBuffer);
    paramMomentFeedInfo.n = localStringBuffer.toString();
  }
  
  public void a()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      c(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, NearbyMomentManager.GetMomentListCallback paramGetMomentListCallback)
  {
    NearbyMomentProtocol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong1, paramLong2, paramInt1, paramInt2, paramInt3, new NearbyMomentManager.4(this, paramGetMomentListCallback));
  }
  
  public void a(NearbyMomentManager.MomentDataChangeObserver paramMomentDataChangeObserver)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.add(paramMomentDataChangeObserver);
      return;
    }
    finally
    {
      paramMomentDataChangeObserver = finally;
      throw paramMomentDataChangeObserver;
    }
  }
  
  public void a(String paramString)
  {
    NearbyMomentProtocol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, new NearbyMomentManager.1(this, paramString));
  }
  
  public void a(String paramString, int paramInt)
  {
    try
    {
      ThreadManager.getUIHandler().post(new NearbyMomentManager.8(this, paramString, paramInt));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    try
    {
      ThreadManager.getUIHandler().post(new NearbyMomentManager.7(this, paramString, paramLong));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(String paramString, long paramLong, int paramInt, NearbyMomentManager.DeleteFeedCallback paramDeleteFeedCallback)
  {
    if (paramInt == 6) {
      paramInt = 10;
    }
    for (;;)
    {
      NearbyMomentProtocol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramLong, paramInt, new NearbyMomentManager.3(this, paramDeleteFeedCallback));
      return;
    }
  }
  
  public void b(NearbyMomentManager.MomentDataChangeObserver paramMomentDataChangeObserver)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramMomentDataChangeObserver);
      return;
    }
    finally
    {
      paramMomentDataChangeObserver = finally;
      throw paramMomentDataChangeObserver;
    }
  }
  
  public void b(String paramString)
  {
    NearbyMomentProtocol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, new NearbyMomentManager.2(this, paramString));
  }
  
  public void b(String paramString, int paramInt)
  {
    try
    {
      ThreadManager.getUIHandler().post(new NearbyMomentManager.9(this, paramString, paramInt));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void c(String paramString)
  {
    try
    {
      ThreadManager.getUIHandler().post(new NearbyMomentManager.5(this, paramString));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void d(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void e(String paramString)
  {
    try
    {
      ThreadManager.getUIHandler().post(new NearbyMomentManager.6(this, paramString));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void f(String paramString)
  {
    try
    {
      ThreadManager.getUIHandler().post(new NearbyMomentManager.10(this, paramString));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void onDestroy()
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager
 * JD-Core Version:    0.7.0.1
 */