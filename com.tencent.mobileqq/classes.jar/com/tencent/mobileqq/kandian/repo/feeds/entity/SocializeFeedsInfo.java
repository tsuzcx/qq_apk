package com.tencent.mobileqq.kandian.repo.feeds.entity;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.repo.handler.BiuInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.GameLiveInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.NowLiveInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.articlesummary.articlesummary.BiuMultiLevel;
import tencent.im.oidb.articlesummary.articlesummary.BuluoInfo;
import tencent.im.oidb.articlesummary.articlesummary.ColumnTopicInfo;
import tencent.im.oidb.articlesummary.articlesummary.GameLiveInfo;
import tencent.im.oidb.articlesummary.articlesummary.LongContentInfo;
import tencent.im.oidb.articlesummary.articlesummary.PGCFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.SocializeFeedsExtInfo;
import tencent.im.oidb.articlesummary.articlesummary.SocializeFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.SocializeFeedsInfoUser;
import tencent.im.oidb.articlesummary.articlesummary.TopicEntranceInfo;
import tencent.im.oidb.articlesummary.articlesummary.TopicRecommendFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.UGCFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.WendaInfo;
import tencent.im.oidb.articlesummary.feeds_info.IconWordingInfo;
import tencent.im.oidb.articlesummary.feeds_info.LocationInfo;
import tencent.im.oidb.articlesummary.feeds_info.ShareWebPageInfo;
import tencent.im.oidb.articlesummary.feeds_info.VisibleInfo;
import tencent.im.oidb.articlesummary.feeds_info.VisibleShowInfo;
import tencent.im.oidb.cmd0xb57.oidb_cmd0xb57.MedalInfo;

public class SocializeFeedsInfo
  implements Cloneable
{
  public LocationInfo A;
  public PrivacyShowInfo B;
  public int C = 0;
  public String D = "";
  public ShareWebPageInfo E;
  public NowLiveInfo F;
  public int G;
  public String H;
  public String I;
  public ReadInJoyMedalInfo J;
  public BuluoInfo K;
  public LongContentInfo L;
  public articlesummary.ColumnTopicInfo M;
  public articlesummary.TopicEntranceInfo N;
  public long a;
  public int b;
  public FeedsInfoUser c = new FeedsInfoUser();
  public List<FeedsInfoUser> d = new ArrayList();
  public String e;
  public String f;
  public String g;
  public int h;
  public int i;
  public int j;
  public int k;
  public int l;
  public int m;
  public BiuInfo n;
  public int o;
  public int p;
  public byte[] q;
  public long r;
  public UGCFeedsInfo s;
  public PGCFeedsInfo t;
  public GameLiveInfo u;
  public TopicRecommendFeedsInfo v;
  public String w;
  public WendaInfo x;
  public int y;
  public IconWordingInfo z;
  
  private void a(articlesummary.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    if (this.w != null) {
      paramSocializeFeedsInfo.bytes_recommend_account_reason.set(ByteStringMicro.copyFromUtf8(this.w));
    }
    if (this.g != null) {
      paramSocializeFeedsInfo.bytes_recommend_reason.set(ByteStringMicro.copyFromUtf8(this.g));
    }
    if (this.H != null)
    {
      paramSocializeFeedsInfo.uint32_is_jump_recommend_page.set(this.G);
      paramSocializeFeedsInfo.bytes_jump_recommend_url.set(ByteStringMicro.copyFromUtf8(this.H));
    }
    if (this.I != null) {
      paramSocializeFeedsInfo.bytes_jump_recommend_prompt.set(ByteStringMicro.copyFromUtf8(this.I));
    }
  }
  
  private void b(articlesummary.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    if (this.M != null) {
      paramSocializeFeedsInfo.msg_column_topic_info.set(this.M);
    }
    if (this.N != null) {
      paramSocializeFeedsInfo.msg_topic_entrance_info.set(this.N);
    }
    if (this.v != null) {
      paramSocializeFeedsInfo.msg_topic_recommend_feeds_info.set(this.v.a());
    }
  }
  
  private void c(articlesummary.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    if (this.s != null) {
      paramSocializeFeedsInfo.msg_ugc_topic_feeds_info.set(UGCFeedsInfo.a(this.s));
    }
    if (this.t != null) {
      paramSocializeFeedsInfo.msg_pgc_topic_feeds_info.set(PGCFeedsInfo.a(this.t));
    }
  }
  
  private void d(articlesummary.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    if (this.A != null)
    {
      feeds_info.LocationInfo localLocationInfo = new feeds_info.LocationInfo();
      PBBytesField localPBBytesField = localLocationInfo.bytes_name;
      boolean bool = TextUtils.isEmpty(this.A.a);
      String str2 = "";
      String str1;
      if (bool) {
        str1 = "";
      } else {
        str1 = this.A.a;
      }
      localPBBytesField.set(ByteStringMicro.copyFromUtf8(str1));
      localLocationInfo.uint32_longitude.set(this.A.b);
      localLocationInfo.uint32_latitude.set(this.A.c);
      localPBBytesField = localLocationInfo.bytes_icon_url;
      if (TextUtils.isEmpty(this.A.d)) {
        str1 = str2;
      } else {
        str1 = this.A.d;
      }
      localPBBytesField.set(ByteStringMicro.copyFromUtf8(str1));
      paramSocializeFeedsInfo.location_info.set(localLocationInfo);
    }
  }
  
  private void e(articlesummary.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    if (this.B != null)
    {
      feeds_info.VisibleInfo localVisibleInfo = new feeds_info.VisibleInfo();
      feeds_info.VisibleShowInfo localVisibleShowInfo = new feeds_info.VisibleShowInfo();
      localVisibleShowInfo.uint32_visible_type.set(this.B.a);
      localVisibleShowInfo.uint64_feed_id.set(this.B.c);
      localVisibleShowInfo.uint64_who.set(this.B.b);
      localVisibleInfo.visible_show_info.set(localVisibleShowInfo);
      paramSocializeFeedsInfo.visible_info.set(localVisibleInfo);
    }
  }
  
  private void f(articlesummary.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    if (this.K != null)
    {
      articlesummary.BuluoInfo localBuluoInfo = new articlesummary.BuluoInfo();
      localBuluoInfo.bytes_wording.set(ByteStringMicro.copyFromUtf8(this.K.a));
      localBuluoInfo.bytes_head_url.set(ByteStringMicro.copyFromUtf8(this.K.e));
      localBuluoInfo.bytes_jump_url.set(ByteStringMicro.copyFromUtf8(this.K.b));
      localBuluoInfo.bytes_name.set(ByteStringMicro.copyFromUtf8(this.K.d));
      localBuluoInfo.uint64_buluo_id.set(this.K.c);
      paramSocializeFeedsInfo.buluo_info.set(localBuluoInfo);
    }
  }
  
  private void g(articlesummary.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    if (this.J != null)
    {
      ArrayList localArrayList = new ArrayList();
      oidb_cmd0xb57.MedalInfo localMedalInfo = new oidb_cmd0xb57.MedalInfo();
      localMedalInfo.uint32_pic_width.set(this.J.g);
      localMedalInfo.uint32_pic_height.set(this.J.h);
      localMedalInfo.bytes_medal_url.set(ByteStringMicro.copyFromUtf8(this.J.c));
      localMedalInfo.uint64_medal_id.set(this.J.a);
      localMedalInfo.bytes_medal_name.set(ByteStringMicro.copyFromUtf8(this.J.b));
      localMedalInfo.uint32_is_jump.set(this.J.e);
      localMedalInfo.bytes_jump_url.set(ByteStringMicro.copyFromUtf8(this.J.f));
      localMedalInfo.uint32_medal_type.set(this.J.d);
      localArrayList.add(localMedalInfo);
      paramSocializeFeedsInfo.msg_master_uin.rpt_msg_medal_info.set(localArrayList);
    }
  }
  
  private void h(articlesummary.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    paramSocializeFeedsInfo.uint64_feeds_id.set(this.a);
    paramSocializeFeedsInfo.uint32_comments_count.set(this.j);
    paramSocializeFeedsInfo.uint32_biu_time.set(this.k);
    paramSocializeFeedsInfo.uint32_feeds_style.set(this.b);
    paramSocializeFeedsInfo.uint32_like_count.set(this.h);
    paramSocializeFeedsInfo.uint32_myself_like_status.set(this.i);
    Object localObject = new articlesummary.SocializeFeedsInfoUser();
    ((articlesummary.SocializeFeedsInfoUser)localObject).uint64_uin.set(this.c.a);
    ((articlesummary.SocializeFeedsInfoUser)localObject).enum_uin_type.set(this.c.b);
    ((articlesummary.SocializeFeedsInfoUser)localObject).uint32_star_style.set(this.c.c);
    if (!TextUtils.isEmpty(this.c.d)) {
      ((articlesummary.SocializeFeedsInfoUser)localObject).bytes_person_desc.set(ByteStringMicro.copyFromUtf8(this.c.d));
    }
    ((articlesummary.SocializeFeedsInfoUser)localObject).uint32_is_real_user.set(this.c.e);
    paramSocializeFeedsInfo.msg_master_uin.set((MessageMicro)localObject);
    paramSocializeFeedsInfo.uint32_follow_counts.set(this.p);
    paramSocializeFeedsInfo.uint32_follow_status.set(this.o);
    localObject = new ArrayList();
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      FeedsInfoUser localFeedsInfoUser = (FeedsInfoUser)localIterator.next();
      articlesummary.SocializeFeedsInfoUser localSocializeFeedsInfoUser = new articlesummary.SocializeFeedsInfoUser();
      localSocializeFeedsInfoUser.uint64_uin.set(localFeedsInfoUser.a);
      localSocializeFeedsInfoUser.enum_uin_type.set(localFeedsInfoUser.b);
      ((List)localObject).add(localSocializeFeedsInfoUser);
    }
    paramSocializeFeedsInfo.rpt_recommend_list.set((List)localObject);
    paramSocializeFeedsInfo.uint32_myself_biu_status.set(this.m);
    paramSocializeFeedsInfo.uint32_biu_count.set(this.l);
    paramSocializeFeedsInfo.uint64_article_id.set(this.r);
    paramSocializeFeedsInfo.uint32_is_origin_feeds_deleted.set(this.y);
    paramSocializeFeedsInfo.uint32_feed_status.set(this.C);
  }
  
  public SocializeFeedsInfo a()
  {
    SocializeFeedsInfo localSocializeFeedsInfo1;
    try
    {
      localSocializeFeedsInfo1 = (SocializeFeedsInfo)super.clone();
      try
      {
        localSocializeFeedsInfo1.c = this.c.a();
        localSocializeFeedsInfo1.d = new ArrayList();
        Object localObject = this.d.iterator();
        while (((Iterator)localObject).hasNext())
        {
          FeedsInfoUser localFeedsInfoUser = (FeedsInfoUser)((Iterator)localObject).next();
          localSocializeFeedsInfo1.d.add(localFeedsInfoUser.a());
        }
        localObject = localSocializeFeedsInfo1;
        if (this.n == null) {
          return ???;
        }
        localSocializeFeedsInfo1.n = this.n.a();
        return localSocializeFeedsInfo1;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException1) {}
      QLog.d("SocializeFeedsInfo", 1, "clone SocializeFeedsInfo failed ", localCloneNotSupportedException2);
    }
    catch (CloneNotSupportedException localCloneNotSupportedException2)
    {
      localSocializeFeedsInfo1 = null;
    }
    SocializeFeedsInfo localSocializeFeedsInfo2 = localSocializeFeedsInfo1;
    return localSocializeFeedsInfo2;
  }
  
  public byte[] b()
  {
    articlesummary.SocializeFeedsInfo localSocializeFeedsInfo = new articlesummary.SocializeFeedsInfo();
    h(localSocializeFeedsInfo);
    if (!TextUtils.isEmpty(this.D)) {
      localSocializeFeedsInfo.bytes_private_status_title.set(ByteStringMicro.copyFromUtf8(this.D));
    }
    Object localObject = this.L;
    if (localObject != null)
    {
      localObject = ((LongContentInfo)localObject).a();
      localSocializeFeedsInfo.long_content_info.set((MessageMicro)localObject);
    }
    if (this.E != null) {
      localSocializeFeedsInfo.share_web_page_info.set(this.E.a());
    }
    if (this.f != null) {
      localSocializeFeedsInfo.bytes_comments.set(ByteStringMicro.copyFromUtf8(this.f));
    }
    if (this.x != null) {
      localSocializeFeedsInfo.wenda_info.set(this.x.a());
    }
    if (this.z != null) {
      localSocializeFeedsInfo.icon_wording_info.set(this.z.a());
    }
    try
    {
      if (this.q != null) {
        localSocializeFeedsInfo.msg_socialize_feeds_ext_info.mergeFrom(this.q);
      }
      if (this.n != null) {
        localSocializeFeedsInfo.msg_biu_mutli_level.set(this.n.b());
      }
    }
    catch (Exception localException)
    {
      QLog.d("SocializeFeedsInfo", 1, "merge info failed ", localException);
    }
    if (this.u != null) {
      localSocializeFeedsInfo.game_live_info.set(GameLiveInfo.a(this.u));
    }
    b(localSocializeFeedsInfo);
    c(localSocializeFeedsInfo);
    a(localSocializeFeedsInfo);
    d(localSocializeFeedsInfo);
    e(localSocializeFeedsInfo);
    g(localSocializeFeedsInfo);
    f(localSocializeFeedsInfo);
    return localSocializeFeedsInfo.toByteArray();
  }
  
  public boolean c()
  {
    return this.C == 1;
  }
  
  public boolean d()
  {
    PrivacyShowInfo localPrivacyShowInfo = this.B;
    return (localPrivacyShowInfo != null) && (localPrivacyShowInfo.a != 0);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SocializeFeedsInfo{mFeedStyle=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mRecommUinList=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", mLikeCount=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", mLikeStatus=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", mCommentCount=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", mBiuTime=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", mCommentWording='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mRecommReason='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mRecommendAccountReason='");
    localStringBuilder.append(this.w);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mMasterUser.uin='");
    localStringBuilder.append(this.c.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mMasterUser.type='");
    localStringBuilder.append(this.c.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mMasterUser.starType='");
    localStringBuilder.append(this.c.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mBiuCount='");
    localStringBuilder.append(this.l);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mBiuStatus='");
    localStringBuilder.append(this.m);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mBiuInfo='");
    localStringBuilder.append(this.n);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mFollowStatus='");
    localStringBuilder.append(this.o);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mFollowCnt='");
    localStringBuilder.append(this.p);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mIsOriginFeedsDeleted='");
    localStringBuilder.append(this.y);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mFeedStatus='");
    localStringBuilder.append(this.C);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mPrivateStatusTitle='");
    localStringBuilder.append(this.D);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mIs_jump_recommend_page='");
    localStringBuilder.append(this.G);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mJump_recommend__url='");
    localStringBuilder.append(this.H);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mJump_recommend__prompt='");
    localStringBuilder.append(this.I);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mPGCFeedsInfo=");
    localStringBuilder.append(this.t);
    localStringBuilder.append(", mUGCFeedsInfo=");
    localStringBuilder.append(this.s);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo
 * JD-Core Version:    0.7.0.1
 */