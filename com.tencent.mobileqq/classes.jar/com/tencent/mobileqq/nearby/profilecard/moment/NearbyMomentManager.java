package com.tencent.mobileqq.nearby.profilecard.moment;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.now.model.TopicInfo;
import com.tencent.mobileqq.nearby.profilecard.INearbyMomentManager;
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
import com.tencent.pb.now.ilive_feeds_read.TopicCfg;
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
  implements INearbyMomentManager, Manager
{
  protected DecimalFormat a = new DecimalFormat("#.##");
  private List<NearbyMomentManager.MomentDataChangeObserver> b = new CopyOnWriteArrayList();
  private QQAppInterface c;
  private String d;
  
  public NearbyMomentManager(QQAppInterface paramQQAppInterface)
  {
    this.c = paramQQAppInterface;
  }
  
  private MomentFeedInfo a(ilive_feeds_read.FeedsInfo paramFeedsInfo)
  {
    Object localObject1 = null;
    if (paramFeedsInfo == null) {
      return null;
    }
    int i = paramFeedsInfo.feed_type.get();
    boolean bool = true;
    Object localObject2;
    if (i == 5)
    {
      localObject1 = new LiveMomentFeedInfo();
      ((LiveMomentFeedInfo)localObject1).a = paramFeedsInfo.live_info.pic_url.get().toStringUtf8();
      ((LiveMomentFeedInfo)localObject1).s = paramFeedsInfo.live_info.desc.get().toStringUtf8();
    }
    else if ((paramFeedsInfo.feed_type.get() != 1) && (paramFeedsInfo.feed_type.get() != 3) && (paramFeedsInfo.feed_type.get() != 2))
    {
      if (paramFeedsInfo.feed_type.get() == 4)
      {
        localObject1 = new PicMomentFeedInfo();
        localObject2 = paramFeedsInfo.pic_info.infos.get();
        if (((List)localObject2).size() > 0)
        {
          localObject2 = (ilive_feeds_tmem.PicInfo)((List)localObject2).get(0);
          ((PicMomentFeedInfo)localObject1).c = ((ilive_feeds_tmem.PicInfo)localObject2).url.get().toStringUtf8();
          ((PicMomentFeedInfo)localObject1).a = ((ilive_feeds_tmem.PicInfo)localObject2).width.get();
          ((PicMomentFeedInfo)localObject1).b = ((ilive_feeds_tmem.PicInfo)localObject2).hight.get();
        }
        ((PicMomentFeedInfo)localObject1).s = paramFeedsInfo.pic_info.desc.get().toStringUtf8();
        localObject1 = (PicMomentFeedInfo)a(paramFeedsInfo.topic_cfg.get(), (MomentFeedInfo)localObject1);
      }
      else if (paramFeedsInfo.feed_type.get() == 6)
      {
        localObject1 = new ChangMomentFeedInfo();
        ((ChangMomentFeedInfo)localObject1).d = paramFeedsInfo.chang_info.pic_url.get().toStringUtf8();
        ((ChangMomentFeedInfo)localObject1).b = paramFeedsInfo.chang_info.width.get();
        ((ChangMomentFeedInfo)localObject1).c = paramFeedsInfo.chang_info.hight.get();
        if (paramFeedsInfo.chang_info.chang.size() > 0) {
          ((ChangMomentFeedInfo)localObject1).a = ((ilive_feeds_tmem.Chang)paramFeedsInfo.chang_info.chang.get(0)).id.get().toStringUtf8();
        }
        ((ChangMomentFeedInfo)localObject1).s = paramFeedsInfo.chang_info.desc.get().toStringUtf8();
        ((ChangMomentFeedInfo)localObject1).t = paramFeedsInfo.view_times.get();
        ((ChangMomentFeedInfo)localObject1).e = paramFeedsInfo.chang_info.chang.size();
      }
      else if (paramFeedsInfo.feed_type.get() == 10)
      {
        localObject1 = new TextMomentFeedInfo();
        ((TextMomentFeedInfo)localObject1).s = paramFeedsInfo.text_feed.text.get();
        localObject1 = (TextMomentFeedInfo)a(paramFeedsInfo.topic_cfg.get(), (MomentFeedInfo)localObject1);
      }
    }
    else
    {
      localObject1 = new ShortVideoMomentFeedInfo();
      ((ShortVideoMomentFeedInfo)localObject1).c = paramFeedsInfo.feed_info.pic_url.get().toStringUtf8();
      ((ShortVideoMomentFeedInfo)localObject1).e = paramFeedsInfo.feed_info.video_time.get();
      ((ShortVideoMomentFeedInfo)localObject1).a = paramFeedsInfo.feed_info.video_width.get();
      ((ShortVideoMomentFeedInfo)localObject1).b = paramFeedsInfo.feed_info.video_hight.get();
      ((ShortVideoMomentFeedInfo)localObject1).s = paramFeedsInfo.feed_info.desc.get().toStringUtf8();
      ((ShortVideoMomentFeedInfo)localObject1).t = paramFeedsInfo.view_times.get();
      localObject1 = (ShortVideoMomentFeedInfo)a(paramFeedsInfo.topic_cfg.get(), (MomentFeedInfo)localObject1);
    }
    if (localObject1 != null)
    {
      ((MomentFeedInfo)localObject1).g = paramFeedsInfo.feed_type.get();
      ((MomentFeedInfo)localObject1).i = String.valueOf(paramFeedsInfo.publish_info.uin.get());
      ((MomentFeedInfo)localObject1).f = paramFeedsInfo.feeds_id.get().toStringUtf8();
      ((MomentFeedInfo)localObject1).h = String.valueOf(paramFeedsInfo.publish_info.url.get().toStringUtf8());
      ((MomentFeedInfo)localObject1).r = paramFeedsInfo.jump_url.get().toStringUtf8();
      if (paramFeedsInfo.like.get() != 1) {
        bool = false;
      }
      ((MomentFeedInfo)localObject1).u = bool;
      ((MomentFeedInfo)localObject1).v = paramFeedsInfo.like_info.like_number.get();
      ((MomentFeedInfo)localObject1).w = paramFeedsInfo.comment_num.get();
      ((MomentFeedInfo)localObject1).j = paramFeedsInfo.create_time.get();
      ((MomentFeedInfo)localObject1).k = NearbyMomentUtils.a(paramFeedsInfo.create_time.get() * 1000L);
      ((MomentFeedInfo)localObject1).m = paramFeedsInfo.lbs_info.lng.get().toStringUtf8();
      ((MomentFeedInfo)localObject1).n = paramFeedsInfo.lbs_info.lat.get().toStringUtf8();
      ((MomentFeedInfo)localObject1).o = paramFeedsInfo.lbs_info.city.get().toStringUtf8();
      ((MomentFeedInfo)localObject1).p = paramFeedsInfo.lbs_info.name.get().toStringUtf8();
      if (paramFeedsInfo.distance.has())
      {
        double d2 = paramFeedsInfo.distance.get();
        double d1 = d2;
        if (d2 < 0.01D) {
          d1 = 0.01D;
        }
        if (d1 < 100.0D)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.a.format(d1));
          ((StringBuilder)localObject2).append("km");
          ((MomentFeedInfo)localObject1).q = ((StringBuilder)localObject2).toString();
        }
        else
        {
          this.a = new DecimalFormat("#");
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.a.format(d1));
          ((StringBuilder)localObject2).append("km");
          ((MomentFeedInfo)localObject1).q = ((StringBuilder)localObject2).toString();
        }
      }
      if (!TextUtils.isEmpty(paramFeedsInfo.lbs_info.name.get().toStringUtf8())) {
        ((MomentFeedInfo)localObject1).l = paramFeedsInfo.lbs_info.name.get().toStringUtf8();
      } else {
        ((MomentFeedInfo)localObject1).l = paramFeedsInfo.lbs_info.city.get().toStringUtf8();
      }
      localObject2 = paramFeedsInfo.comments.get();
      if (((List)localObject2).size() > 0)
      {
        paramFeedsInfo = new ArrayList();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          NowNearbyVideoCommentProto.Comment localComment = (NowNearbyVideoCommentProto.Comment)((Iterator)localObject2).next();
          CommentInfo localCommentInfo = new CommentInfo();
          localCommentInfo.a = localComment.comment_id.get();
          localCommentInfo.b = localComment.publish_info.anchor_name.get().toStringUtf8();
          localCommentInfo.c = localComment.reply_info.anchor_name.get().toStringUtf8();
          localCommentInfo.d = ((NowNearbyVideoCommentProto.CommentMsg)((NowNearbyVideoCommentProto.CommentMsgBody)localComment.content.get()).msgs.get().get(0)).msg.get().toStringUtf8();
          paramFeedsInfo.add(localCommentInfo);
        }
        ((MomentFeedInfo)localObject1).x = paramFeedsInfo;
      }
    }
    return localObject1;
  }
  
  private static MomentFeedInfo a(List<ilive_feeds_read.TopicCfg> paramList, MomentFeedInfo paramMomentFeedInfo)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = (ilive_feeds_read.TopicCfg)paramList.get(0);
      paramMomentFeedInfo.y = new TopicInfo();
      paramMomentFeedInfo.y.d(paramList.jump_url.get());
      paramMomentFeedInfo.y.b(paramList.topic_name.get());
      paramMomentFeedInfo.y.a(paramList.topic_desc.get());
      paramMomentFeedInfo.y.b(paramList.topic_parti_num.get());
      paramMomentFeedInfo.y.c(paramList.topic_pic_url.get());
      paramMomentFeedInfo.y.a(paramList.topic_tag.get());
      paramMomentFeedInfo.y.c(paramList.topic_type.get());
    }
    return paramMomentFeedInfo;
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
    if (paramMomentFeedInfo != null)
    {
      if (TextUtils.isEmpty(paramMomentFeedInfo.s)) {
        return;
      }
      Matcher localMatcher = Pattern.compile("\\[:([^(:\\])]+):\\]").matcher(paramMomentFeedInfo.s);
      StringBuffer localStringBuffer = new StringBuffer();
      while (localMatcher.find()) {
        localMatcher.appendReplacement(localStringBuffer, "");
      }
      localMatcher.appendTail(localStringBuffer);
      paramMomentFeedInfo.s = localStringBuffer.toString();
    }
  }
  
  public void a()
  {
    if (!TextUtils.isEmpty(this.d)) {
      f(this.d);
    }
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, NearbyMomentManager.GetMomentListCallback paramGetMomentListCallback)
  {
    NearbyMomentProtocol.a(this.c, paramLong1, paramLong2, paramInt1, paramInt2, paramInt3, new NearbyMomentManager.4(this, paramGetMomentListCallback));
  }
  
  public void a(NearbyMomentManager.MomentDataChangeObserver paramMomentDataChangeObserver)
  {
    try
    {
      this.b.add(paramMomentDataChangeObserver);
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
  
  public void a(String paramString, long paramLong, int paramInt, DeleteFeedCallback paramDeleteFeedCallback)
  {
    if (paramInt == 6) {
      paramInt = 10;
    }
    NearbyMomentProtocol.a(this.c, paramString, paramLong, paramInt, new NearbyMomentManager.3(this, paramDeleteFeedCallback));
  }
  
  public void b(NearbyMomentManager.MomentDataChangeObserver paramMomentDataChangeObserver)
  {
    try
    {
      this.b.remove(paramMomentDataChangeObserver);
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
    this.d = paramString;
  }
  
  public void d(String paramString)
  {
    NearbyMomentProtocol.a(this.c, paramString, new NearbyMomentManager.1(this, paramString));
  }
  
  public void e(String paramString)
  {
    NearbyMomentProtocol.a(this.c, paramString, new NearbyMomentManager.2(this, paramString));
  }
  
  public void f(String paramString)
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
  
  public void onDestroy()
  {
    try
    {
      this.b.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager
 * JD-Core Version:    0.7.0.1
 */