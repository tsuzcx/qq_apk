package com.tencent.mobileqq.kandian.biz.pts;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJShowKanDianTabSp;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfoKt;
import com.tencent.mobileqq.kandian.repo.feeds.RIJBaseItemViewType;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.pts.UtilsForComponent;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.articlesummary.articlesummary.FriendRecommendInfo;
import tencent.im.oidb.articlesummary.articlesummary.PackInfo;
import tencent.im.oidb.articlesummary.articlesummary.PackJumpInfo;
import tencent.im.oidb.articlesummary.articlesummary.SpecialTopicInfo;

public class ReadInJoyModelImpl
  implements IReadInJoyModel
{
  public int a;
  public int b;
  private Context c;
  private AbsBaseArticleInfo d;
  private AbsBaseArticleInfo e;
  private int f;
  private int g;
  private boolean h;
  private int i;
  private IReadInJoyBaseAdapter j;
  private VafContext k;
  
  public ReadInJoyModelImpl(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5, AbsBaseArticleInfo paramAbsBaseArticleInfo2, IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter)
  {
    this.c = paramContext;
    this.d = paramAbsBaseArticleInfo1;
    this.f = paramInt1;
    this.a = paramInt2;
    this.g = paramInt3;
    this.b = paramInt4;
    this.h = paramBoolean;
    this.i = paramInt5;
    this.e = paramAbsBaseArticleInfo2;
    this.j = paramIReadInJoyBaseAdapter;
  }
  
  private int a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return 0;
    }
    if ((paramAbsBaseArticleInfo.mFeedIndexInGroup == paramAbsBaseArticleInfo.mGroupCount - 1L) && (paramAbsBaseArticleInfo.mPackInfoObj != null) && (paramAbsBaseArticleInfo.mPackInfoObj.pack_type.has()))
    {
      Object localObject;
      String str;
      if (paramAbsBaseArticleInfo.mPackInfoObj.pack_type.get() == 2)
      {
        if ((paramAbsBaseArticleInfo.mPackInfoObj.msg_special_topic_info.has()) && (((articlesummary.SpecialTopicInfo)paramAbsBaseArticleInfo.mPackInfoObj.msg_special_topic_info.get()).rpt_jumps.has()))
        {
          localObject = ((articlesummary.SpecialTopicInfo)paramAbsBaseArticleInfo.mPackInfoObj.msg_special_topic_info.get()).rpt_jumps.get();
          if ((localObject != null) && (((List)localObject).size() > 0))
          {
            str = ((articlesummary.PackJumpInfo)((List)localObject).get(0)).str_url.get();
            localObject = ((articlesummary.PackJumpInfo)((List)localObject).get(0)).str_wording.get();
            if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
              return 2;
            }
          }
        }
      }
      else if ((paramAbsBaseArticleInfo.mPackInfoObj.pack_type.get() == 3) && (paramAbsBaseArticleInfo.mPackInfoObj.msg_friend_recommend_info.has()) && (((articlesummary.FriendRecommendInfo)paramAbsBaseArticleInfo.mPackInfoObj.msg_friend_recommend_info.get()).rpt_jumps.has()))
      {
        localObject = ((articlesummary.FriendRecommendInfo)paramAbsBaseArticleInfo.mPackInfoObj.msg_friend_recommend_info.get()).rpt_jumps.get();
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          str = ((articlesummary.PackJumpInfo)((List)localObject).get(0)).str_url.get();
          localObject = ((articlesummary.PackJumpInfo)((List)localObject).get(0)).str_wording.get();
          if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
            return 3;
          }
        }
      }
    }
    if ((paramAbsBaseArticleInfo.mGroupId == -1L) && (paramAbsBaseArticleInfo.hasChannelInfo()) && (this.f != 0) && ((this.c instanceof BaseActivity)) && (this.a == 0)) {
      return 1;
    }
    return 0;
  }
  
  public void a(VafContext paramVafContext)
  {
    this.k = paramVafContext;
  }
  
  public boolean a()
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.d;
    boolean bool2 = false;
    if (localAbsBaseArticleInfo == null) {
      return false;
    }
    if (b() == 3) {
      return true;
    }
    boolean bool1 = bool2;
    if (this.d.mGroupId != -1L)
    {
      bool1 = bool2;
      if (this.d.mFeedIndexInGroup == 0L)
      {
        bool1 = bool2;
        if (this.d.mGroupCount > 0L) {
          if (b() != 1)
          {
            bool1 = bool2;
            if (b() != 2) {}
          }
          else
          {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public int b()
  {
    return UtilsForComponent.c(this.d);
  }
  
  public boolean c()
  {
    return d() != 0;
  }
  
  public int d()
  {
    return a(this.d);
  }
  
  public boolean e()
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.d;
    boolean bool2 = false;
    if (localAbsBaseArticleInfo == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (!c())
    {
      bool1 = bool2;
      if (!f())
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(this.d.mArticleFriendLikeText)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean f()
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.d;
    boolean bool2 = false;
    if (localAbsBaseArticleInfo == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (!c())
    {
      bool1 = bool2;
      if (this.d.mCommentsObj != null)
      {
        bool1 = bool2;
        if (this.d.mCommentsObj.size() > 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean g()
  {
    int m = this.g;
    boolean bool2 = false;
    if (m == 7) {
      return false;
    }
    if (m == 3)
    {
      if ((RIJFeedsType.a(this.d)) && (!BaseArticleInfoKt.b(this.d))) {
        return false;
      }
      if (BaseArticleInfoKt.b(this.d)) {
        return false;
      }
    }
    if ((this.a == 0) && (118 == RIJBaseItemViewType.c(this.d))) {
      return false;
    }
    boolean bool1 = bool2;
    if (!i())
    {
      bool1 = bool2;
      if (this.b != this.i - 1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean h()
  {
    return f();
  }
  
  public boolean i()
  {
    int m = this.g;
    boolean bool2 = false;
    if (m == 7) {
      return false;
    }
    m = this.a;
    if (m == 41403) {
      return false;
    }
    if (DailyModeConfigHandler.a(m)) {
      return false;
    }
    if (RIJShowKanDianTabSp.a(this.a)) {
      return false;
    }
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.j.b(this.a);
    boolean bool1 = bool2;
    if (this.h)
    {
      Object localObject = this.d;
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (localAbsBaseArticleInfo != null)
        {
          if (this.b <= 0) {
            return false;
          }
          if (RIJFeedsType.G((AbsBaseArticleInfo)localObject))
          {
            localObject = this.d.mGroupSubArticleList.iterator();
            while (((Iterator)localObject).hasNext()) {
              if ((AbsBaseArticleInfo)((Iterator)localObject).next() == localAbsBaseArticleInfo) {
                return true;
              }
            }
          }
          bool1 = bool2;
          if (localAbsBaseArticleInfo == this.d) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public boolean j()
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.d;
    boolean bool = false;
    if (localAbsBaseArticleInfo == null) {
      return false;
    }
    if ((RIJShowKanDianTabSp.b(this.g)) || ((this.d.mGroupId != -1L) && (this.d.mGroupCount > 0L) && ((b() == 1) || (b() == 2))) || (RIJItemViewTypeUtils.c(o()))) {
      bool = true;
    }
    return bool;
  }
  
  public AbsBaseArticleInfo k()
  {
    return this.d;
  }
  
  public AbsBaseArticleInfo l()
  {
    return this.e;
  }
  
  public int m()
  {
    return this.a;
  }
  
  public ReadInJoyBaseAdapter n()
  {
    return (ReadInJoyBaseAdapter)this.j;
  }
  
  public int o()
  {
    return this.f;
  }
  
  public int p()
  {
    int m = this.b;
    if (m == this.i - 1) {
      return 154;
    }
    return this.j.getItemViewType(m + 1);
  }
  
  public int q()
  {
    return this.i;
  }
  
  public int r()
  {
    return this.b;
  }
  
  public boolean s()
  {
    return this.c instanceof SplashActivity;
  }
  
  public VafContext t()
  {
    return this.k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.ReadInJoyModelImpl
 * JD-Core Version:    0.7.0.1
 */