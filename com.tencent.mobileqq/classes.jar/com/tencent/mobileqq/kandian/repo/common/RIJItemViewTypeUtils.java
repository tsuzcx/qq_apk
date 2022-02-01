package com.tencent.mobileqq.kandian.repo.common;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfoKt;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.handler.BiuInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import tencent.im.oidb.articlesummary.articlesummary.PartnerAccountInfo;

public class RIJItemViewTypeUtils
{
  public static int A(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    int i = 21;
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.s != null))
    {
      switch (paramAbsBaseArticleInfo.mSocialFeedInfo.s.a)
      {
      default: 
        return 21;
      case 6: 
        if (BaseArticleInfoKt.c(paramAbsBaseArticleInfo)) {
          return 70;
        }
        if (BaseArticleInfoKt.b(paramAbsBaseArticleInfo)) {
          return 46;
        }
        if (paramAbsBaseArticleInfo.mChannelID == 0L) {
          return 71;
        }
        if ((paramAbsBaseArticleInfo.mChannelID != 70L) && (paramAbsBaseArticleInfo.mChannelID != 41403L)) {
          return 4;
        }
      case 4: 
      case 5: 
        return 23;
      case 2: 
      case 3: 
        if ((paramAbsBaseArticleInfo.mSocialFeedInfo.b == 9) && (paramAbsBaseArticleInfo.mSocialFeedInfo.s.b.size() > 1)) {
          return 36;
        }
        if (paramAbsBaseArticleInfo.mSocialFeedInfo.z != null) {
          return 80;
        }
        i = 22;
      }
      return i;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RIJItemViewType", 2, "ugc feeds info is null");
    }
    return 21;
  }
  
  public static int B(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.s != null))
    {
      int i = paramAbsBaseArticleInfo.mSocialFeedInfo.s.a;
      if ((i != 2) && (i != 3))
      {
        if ((i != 4) && (i != 5)) {
          return 54;
        }
        return 56;
      }
      return 55;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getTopicRecommendAndUpdateUGCType ugc feeds info is null. article info is: ");
    localStringBuilder.append(paramAbsBaseArticleInfo);
    QLog.d("RIJItemViewType", 1, localStringBuilder.toString());
    return 54;
  }
  
  public static boolean C(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.isAccountShown) && (paramAbsBaseArticleInfo.mPartnerAccountInfo != null);
  }
  
  public static int D(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    SocializeFeedsInfo localSocializeFeedsInfo = paramAbsBaseArticleInfo.mSocialFeedInfo;
    int i;
    if (e(paramAbsBaseArticleInfo))
    {
      if (c(paramAbsBaseArticleInfo))
      {
        i = localSocializeFeedsInfo.b;
        if (i != 1)
        {
          if (i == 9) {
            return 3;
          }
        }
        else {
          return 4;
        }
      }
      else
      {
        if (RIJFeedsType.r(paramAbsBaseArticleInfo)) {
          return 6;
        }
        if (RIJFeedsType.D(paramAbsBaseArticleInfo)) {
          return 10;
        }
        if (RIJFeedsType.C(paramAbsBaseArticleInfo)) {
          return 8;
        }
      }
    }
    else
    {
      if ((!a(paramAbsBaseArticleInfo)) && (paramAbsBaseArticleInfo.mFeedType != 10)) {}
      switch (paramAbsBaseArticleInfo.mFeedType)
      {
      default: 
        break;
      case 23: 
        return 5;
      case 22: 
        return 9;
      case 21: 
        return 7;
        if (localSocializeFeedsInfo != null)
        {
          i = localSocializeFeedsInfo.b;
          if (i != 1)
          {
            if (i == 9) {
              return 2;
            }
          }
          else {
            return 1;
          }
        }
        break;
      }
    }
    return 0;
  }
  
  public static boolean E(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mPartnerAccountInfo != null) && (paramAbsBaseArticleInfo.mPartnerAccountInfo.uint32_is_wechat_video.get() == 1);
  }
  
  public static boolean F(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo != null) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo.miniProgramName));
  }
  
  public static int G(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo.mNewPolymericInfo != null) {
      switch (paramAbsBaseArticleInfo.mNewPolymericInfo.d)
      {
      default: 
        break;
      case 9: 
      case 10: 
      case 11: 
        return 1;
      }
    }
    if (RIJFeedsType.b(paramAbsBaseArticleInfo)) {
      return 2;
    }
    if (RIJFeedsType.d(paramAbsBaseArticleInfo)) {
      return 2;
    }
    if (paramAbsBaseArticleInfo.mSinglePicture != null) {
      return 2;
    }
    return 0;
  }
  
  public static long a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    if ((!a(paramAbsBaseArticleInfo)) && (paramInt != 77) && (paramInt != 78))
    {
      if ((!m(paramAbsBaseArticleInfo)) && (paramInt != 72) && (paramInt != 74))
      {
        if (paramInt == 76)
        {
          if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.c != null)) {
            return paramAbsBaseArticleInfo.mSocialFeedInfo.c.a;
          }
        }
        else if (((e(paramAbsBaseArticleInfo)) || (paramInt == 73) || (paramInt == 75)) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.c != null)) {
          return paramAbsBaseArticleInfo.mSocialFeedInfo.c.a;
        }
      }
      else if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.s != null)) {
        return paramAbsBaseArticleInfo.mSocialFeedInfo.s.e;
      }
    }
    else if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mSubscribeID)) {
      try
      {
        long l = Long.parseLong(paramAbsBaseArticleInfo.mSubscribeID);
        return l;
      }
      catch (NumberFormatException paramAbsBaseArticleInfo)
      {
        paramAbsBaseArticleInfo.printStackTrace();
      }
    }
    return 0L;
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 49) || (paramInt == 62) || (paramInt == 63);
  }
  
  public static boolean a(int paramInt, long paramLong)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 4)
    {
      bool1 = bool2;
      if (paramInt != 5)
      {
        bool1 = bool2;
        if (paramInt != 25)
        {
          bool1 = bool2;
          if (paramInt != 32)
          {
            if (paramInt == 1)
            {
              bool1 = bool2;
              if (paramLong == 4L) {
                return bool1;
              }
              bool1 = bool2;
              if (paramLong == 5L) {
                return bool1;
              }
              bool1 = bool2;
              if (paramLong == 25L) {
                return bool1;
              }
              if (paramLong == 32L) {
                return true;
              }
            }
            bool1 = false;
          }
        }
      }
    }
    return bool1;
  }
  
  @Deprecated
  public static boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return false;
    }
    int i = paramAbsBaseArticleInfo.mFeedType;
    if (i != 12) {
      switch (i)
      {
      default: 
        return false;
      }
    }
    return true;
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt == 5) || (paramInt == 4) || (paramInt == 6);
  }
  
  public static boolean b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.b == 9);
  }
  
  public static boolean c(int paramInt)
  {
    return (paramInt == 10) || (paramInt == 11) || (paramInt == 12) || (paramInt == 27) || (paramInt == 28) || (paramInt == 33) || (paramInt == 35) || (paramInt == 43) || (paramInt == 44) || (paramInt == 45) || (paramInt == 49) || (paramInt == 62) || (paramInt == 63) || (paramInt == 94) || (paramInt == 95) || (paramInt == 112) || (paramInt == 113) || (paramInt == 114);
  }
  
  public static boolean c(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((e(paramAbsBaseArticleInfo)) && (paramAbsBaseArticleInfo.mSocialFeedInfo.n != null))
    {
      if (paramAbsBaseArticleInfo.mSocialFeedInfo.n.c == null) {
        return false;
      }
      int i = paramAbsBaseArticleInfo.mSocialFeedInfo.n.c.intValue();
      if ((i != 12) && (i != 27) && (i != 16) && (i != 17)) {
        switch (i)
        {
        default: 
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  public static boolean d(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (e(paramAbsBaseArticleInfo)) && (paramAbsBaseArticleInfo.mSocialFeedInfo.n != null);
  }
  
  public static boolean e(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool2 = false;
    if (paramAbsBaseArticleInfo == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (paramAbsBaseArticleInfo.mFeedType == 1)
    {
      bool1 = bool2;
      if (paramAbsBaseArticleInfo.mSocialFeedInfo != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean f(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if (paramAbsBaseArticleInfo.mSocialFeedInfo == null) {
        return false;
      }
      int i = paramAbsBaseArticleInfo.mSocialFeedInfo.b;
      return (i == 2) || (i == 6);
    }
    return false;
  }
  
  public static boolean g(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool = false;
    if (paramAbsBaseArticleInfo == null) {
      return false;
    }
    if (paramAbsBaseArticleInfo.mFeedType == 10) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean h(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mFeedType == 36);
  }
  
  public static boolean i(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.isAccountShown);
  }
  
  public static boolean j(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mKdLiveInfo != null);
  }
  
  public static boolean k(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.c != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.c.e == 1);
  }
  
  public static boolean l(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.n != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.n.c != null))
    {
      if (paramAbsBaseArticleInfo.mSocialFeedInfo.s == null) {
        return false;
      }
      int i = paramAbsBaseArticleInfo.mSocialFeedInfo.n.c.intValue();
      return (i == 4) || (i == 5) || (i == 18) || (i == 19) || (i == 21) || (i == 22) || (i == 25) || (i == 30) || (i == 32);
    }
    return false;
  }
  
  public static boolean m(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return false;
    }
    int i = paramAbsBaseArticleInfo.mFeedType;
    return (i == 4) || (i == 5);
  }
  
  public static boolean n(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool = false;
    if (paramAbsBaseArticleInfo == null) {
      return false;
    }
    if ((paramAbsBaseArticleInfo.mFeedType == 18) || (paramAbsBaseArticleInfo.mFeedType == 19)) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean o(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (m(paramAbsBaseArticleInfo)) || (l(paramAbsBaseArticleInfo)) || (n(paramAbsBaseArticleInfo)) || (p(paramAbsBaseArticleInfo)) || (paramAbsBaseArticleInfo.mFeedType == 25);
  }
  
  public static boolean p(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.n != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.s != null))
    {
      if (paramAbsBaseArticleInfo.mSocialFeedInfo.n.c == null) {
        return false;
      }
      int i = paramAbsBaseArticleInfo.mSocialFeedInfo.n.c.intValue();
      return (i == 18) || (i == 19);
    }
    return false;
  }
  
  public static boolean q(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (p(paramAbsBaseArticleInfo)) && (paramAbsBaseArticleInfo.mSocialFeedInfo.s.a == 1);
  }
  
  public static boolean r(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (l(paramAbsBaseArticleInfo)) && (paramAbsBaseArticleInfo.mSocialFeedInfo.s.a == 1);
  }
  
  public static boolean s(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo.mFeedType == 1) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.n != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.n.c != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.n.c.longValue() == 11L);
  }
  
  public static boolean t(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo.mFeedType == 11) && (paramAbsBaseArticleInfo.mTopicRecommendFeedsInfo != null) && (paramAbsBaseArticleInfo.mTopicRecommendFeedsInfo.g != null);
  }
  
  public static boolean u(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool = false;
    if (paramAbsBaseArticleInfo == null) {
      return false;
    }
    if ((paramAbsBaseArticleInfo.mFeedType == 16) || (paramAbsBaseArticleInfo.mFeedType == 17)) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean v(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo.mSocialFeedInfo == null) || (paramAbsBaseArticleInfo.mSocialFeedInfo.s == null);
  }
  
  public static boolean w(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo.mSocialFeedInfo == null) || (paramAbsBaseArticleInfo.mSocialFeedInfo.s == null) || (paramAbsBaseArticleInfo.mSocialFeedInfo.s.b.size() == 0);
  }
  
  public static boolean x(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo.mSocialFeedInfo == null) || (paramAbsBaseArticleInfo.mSocialFeedInfo.s == null) || (paramAbsBaseArticleInfo.mSocialFeedInfo.s.c.size() == 0);
  }
  
  public static boolean y(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo.mFeedType != 30) && ((paramAbsBaseArticleInfo.mSocialFeedInfo == null) || (paramAbsBaseArticleInfo.mSocialFeedInfo.s == null) || (paramAbsBaseArticleInfo.mSocialFeedInfo.s.d.isEmpty()));
  }
  
  public static boolean z(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo.mSocialFeedInfo.v == null) || (paramAbsBaseArticleInfo.mSocialFeedInfo.v.g == null) || (paramAbsBaseArticleInfo.mSocialFeedInfo.v.g.isEmpty());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils
 * JD-Core Version:    0.7.0.1
 */