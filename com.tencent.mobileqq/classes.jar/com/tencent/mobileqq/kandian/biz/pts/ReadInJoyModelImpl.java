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
  private Context jdField_a_of_type_AndroidContentContext;
  private VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  private IReadInJoyBaseAdapter jdField_a_of_type_ComTencentMobileqqKandianBizCommonBaseuiIReadInJoyBaseAdapter;
  private AbsBaseArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  private boolean jdField_a_of_type_Boolean;
  public int b;
  private AbsBaseArticleInfo b;
  private int c;
  private int d;
  private int e;
  
  public ReadInJoyModelImpl(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5, AbsBaseArticleInfo paramAbsBaseArticleInfo2, IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo1;
    this.c = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
    this.d = paramInt3;
    this.jdField_b_of_type_Int = paramInt4;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.e = paramInt5;
    this.jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo2;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonBaseuiIReadInJoyBaseAdapter = paramIReadInJoyBaseAdapter;
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
    if ((paramAbsBaseArticleInfo.mGroupId == -1L) && (paramAbsBaseArticleInfo.hasChannelInfo()) && (this.c != 0) && ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) && (this.jdField_a_of_type_Int == 0)) {
      return 1;
    }
    return 0;
  }
  
  public int a()
  {
    return UtilsForComponent.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
  }
  
  public VafContext a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  }
  
  public ReadInJoyBaseAdapter a()
  {
    return (ReadInJoyBaseAdapter)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonBaseuiIReadInJoyBaseAdapter;
  }
  
  public AbsBaseArticleInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  }
  
  public void a(VafContext paramVafContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = paramVafContext;
  }
  
  public boolean a()
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    boolean bool2 = false;
    if (localAbsBaseArticleInfo == null) {
      return false;
    }
    if (a() == 3) {
      return true;
    }
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mGroupId != -1L)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mFeedIndexInGroup == 0L)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mGroupCount > 0L) {
          if (a() != 1)
          {
            bool1 = bool2;
            if (a() != 2) {}
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
    return a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
  }
  
  public AbsBaseArticleInfo b()
  {
    return this.jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  }
  
  public boolean b()
  {
    return b() != 0;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public boolean c()
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    boolean bool2 = false;
    if (localAbsBaseArticleInfo == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (!b())
    {
      bool1 = bool2;
      if (!d())
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleFriendLikeText)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public int d()
  {
    return this.c;
  }
  
  public boolean d()
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    boolean bool2 = false;
    if (localAbsBaseArticleInfo == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (!b())
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mCommentsObj != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mCommentsObj.size() > 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public int e()
  {
    int i = this.jdField_b_of_type_Int;
    if (i == this.e - 1) {
      return 151;
    }
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonBaseuiIReadInJoyBaseAdapter.getItemViewType(i + 1);
  }
  
  public boolean e()
  {
    int i = this.d;
    boolean bool2 = false;
    if (i == 7) {
      return false;
    }
    if (i == 3)
    {
      if ((RIJFeedsType.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)) && (!BaseArticleInfoKt.b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo))) {
        return false;
      }
      if (BaseArticleInfoKt.b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)) {
        return false;
      }
    }
    if ((this.jdField_a_of_type_Int == 0) && (118 == RIJBaseItemViewType.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo))) {
      return false;
    }
    boolean bool1 = bool2;
    if (!g())
    {
      bool1 = bool2;
      if (this.jdField_b_of_type_Int != this.e - 1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int f()
  {
    return this.e;
  }
  
  public boolean f()
  {
    return d();
  }
  
  public int g()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public boolean g()
  {
    int i = this.d;
    boolean bool2 = false;
    if (i == 7) {
      return false;
    }
    i = this.jdField_a_of_type_Int;
    if (i == 41403) {
      return false;
    }
    if (DailyModeConfigHandler.a(i)) {
      return false;
    }
    if (RIJShowKanDianTabSp.a(this.jdField_a_of_type_Int)) {
      return false;
    }
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonBaseuiIReadInJoyBaseAdapter.b(this.jdField_a_of_type_Int);
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Boolean)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (localAbsBaseArticleInfo != null)
        {
          if (this.jdField_b_of_type_Int <= 0) {
            return false;
          }
          if (RIJFeedsType.A((AbsBaseArticleInfo)localObject))
          {
            localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mGroupSubArticleList.iterator();
            while (((Iterator)localObject).hasNext()) {
              if ((AbsBaseArticleInfo)((Iterator)localObject).next() == localAbsBaseArticleInfo) {
                return true;
              }
            }
          }
          bool1 = bool2;
          if (localAbsBaseArticleInfo == this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public boolean h()
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    boolean bool = false;
    if (localAbsBaseArticleInfo == null) {
      return false;
    }
    if ((RIJShowKanDianTabSp.a(this.d)) || ((this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mGroupId != -1L) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mGroupCount > 0L) && ((a() == 1) || (a() == 2))) || (RIJItemViewTypeUtils.c(d()))) {
      bool = true;
    }
    return bool;
  }
  
  public boolean i()
  {
    return this.jdField_a_of_type_AndroidContentContext instanceof SplashActivity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.ReadInJoyModelImpl
 * JD-Core Version:    0.7.0.1
 */