package com.tencent.mobileqq.qcircle.api.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StDittoFeed;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StRecomForward;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudMeta.StVideo;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import qqcircle.QQCircleBase.StUserBusiData;
import qqcircle.QQCircleCounter.RedDisplayInfo;

public class QCircleHostUtil
{
  private static final String TAG = "QCircleHostUtil";
  
  public static String bigNumberFormatTranfer(long paramLong)
  {
    return bigNumberFormatTranfer(paramLong, false);
  }
  
  public static String bigNumberFormatTranfer(long paramLong, boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = HardCodeUtil.a(2131895633);
    } else {
      str = "W";
    }
    if (paramLong < 10000L) {
      return String.valueOf(paramLong);
    }
    if (paramLong < 1000000L)
    {
      localObject = new DecimalFormat();
      ((DecimalFormat)localObject).setMaximumFractionDigits(1);
      ((DecimalFormat)localObject).setGroupingSize(0);
      ((DecimalFormat)localObject).setRoundingMode(RoundingMode.HALF_UP);
      StringBuilder localStringBuilder = new StringBuilder();
      double d = paramLong;
      Double.isNaN(d);
      localStringBuilder.append(((DecimalFormat)localObject).format(d / 10000.0D));
      localStringBuilder.append(str);
      return localStringBuilder.toString();
    }
    if (paramLong < 100000000L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramLong / 10000L);
      ((StringBuilder)localObject).append(str);
      return ((StringBuilder)localObject).toString();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("9999");
    ((StringBuilder)localObject).append(str);
    return ((StringBuilder)localObject).toString();
  }
  
  public static boolean checkOperateMaskEnabled(long paramLong, int paramInt)
  {
    return (paramLong & 1 << paramInt) != 0L;
  }
  
  public static List<String> convertRedDisplayInfoToString(List<QQCircleCounter.RedDisplayInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return localArrayList;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        QQCircleCounter.RedDisplayInfo localRedDisplayInfo = (QQCircleCounter.RedDisplayInfo)paramList.next();
        if (!TextUtils.isEmpty(localRedDisplayInfo.avatarURL.get())) {
          localArrayList.add(localRedDisplayInfo.avatarURL.get());
        } else {
          localArrayList.add(localRedDisplayInfo.headImg.get());
        }
      }
    }
    return localArrayList;
  }
  
  public static int convertSourceFromType(int paramInt)
  {
    int i = 6;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 6) {
              return 0;
            }
            return 10;
          }
          return 5;
        }
      }
      else {
        return 4;
      }
    }
    else {
      i = 1;
    }
    return i;
  }
  
  public static String fansNumberFormatTranfer(long paramLong)
  {
    if (paramLong < 10000L) {
      return String.valueOf(paramLong);
    }
    if (paramLong < 1000000L)
    {
      localObject = new DecimalFormat();
      ((DecimalFormat)localObject).setMaximumFractionDigits(1);
      ((DecimalFormat)localObject).setGroupingSize(0);
      ((DecimalFormat)localObject).setRoundingMode(RoundingMode.HALF_UP);
      StringBuilder localStringBuilder = new StringBuilder();
      double d = paramLong;
      Double.isNaN(d);
      localStringBuilder.append(((DecimalFormat)localObject).format(d / 10000.0D));
      localStringBuilder.append("w");
      return localStringBuilder.toString();
    }
    if (paramLong < 100000000L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramLong / 10000L);
      ((StringBuilder)localObject).append("w");
      return ((StringBuilder)localObject).toString();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("9999");
    ((StringBuilder)localObject).append("w");
    return ((StringBuilder)localObject).toString();
  }
  
  public static String getFeedTagName(FeedCloudMeta.StFeed paramStFeed)
  {
    Object localObject = paramStFeed.tagInfos.get();
    paramStFeed = new StringBuilder();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      FeedCloudMeta.StTagInfo localStTagInfo = (FeedCloudMeta.StTagInfo)((Iterator)localObject).next();
      if (!TextUtils.isEmpty(paramStFeed)) {
        paramStFeed.append("|");
      }
      paramStFeed.append(localStTagInfo.tagName.get());
    }
    return paramStFeed.toString();
  }
  
  public static int[] getReportFeedType(FeedCloudMeta.StFeed paramStFeed)
  {
    int[] arrayOfInt = new int[2];
    if (paramStFeed != null)
    {
      if (paramStFeed.dittoFeed.dittoId.get() != 0)
      {
        arrayOfInt[0] = 3;
        arrayOfInt[1] = 1;
        return arrayOfInt;
      }
      if (paramStFeed.type.get() == 2)
      {
        arrayOfInt[0] = 1;
        arrayOfInt[1] = 1;
        return arrayOfInt;
      }
      if (paramStFeed.type.get() == 3)
      {
        arrayOfInt[0] = 1;
        arrayOfInt[1] = 2;
      }
    }
    return arrayOfInt;
  }
  
  public static FeedCloudMeta.StFeed getSimpleFeed(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null)
    {
      QLog.e("QCircleHostUtil", 1, "getSimpleFeed param feed is null");
      return null;
    }
    FeedCloudMeta.StFeed localStFeed = new FeedCloudMeta.StFeed();
    localStFeed.id.set(paramStFeed.id.get());
    localStFeed.createTime.set(paramStFeed.createTime.get());
    if (paramStFeed.poster != null)
    {
      FeedCloudMeta.StUser localStUser = new FeedCloudMeta.StUser();
      localStUser.id.set(paramStFeed.poster.id.get());
      localStFeed.poster.set(localStUser);
      return localStFeed;
    }
    QLog.e("QCircleHostUtil", 1, "getSimpleFeed poster is null");
    return localStFeed;
  }
  
  public static QQCircleBase.StUserBusiData getUserExtraData(FeedCloudMeta.StUser paramStUser)
  {
    if ((paramStUser != null) && (paramStUser.busiData.get() != null)) {
      try
      {
        QQCircleBase.StUserBusiData localStUserBusiData = new QQCircleBase.StUserBusiData();
        localStUserBusiData.mergeFrom(paramStUser.busiData.get().toByteArray());
        return localStUserBusiData;
      }
      catch (Exception paramStUser)
      {
        paramStUser.printStackTrace();
      }
    }
    return null;
  }
  
  public static boolean isAuth(FeedCloudMeta.StUser paramStUser)
  {
    paramStUser = getUserExtraData(paramStUser);
    return (paramStUser != null) && (paramStUser.certification.get() == 1);
  }
  
  public static boolean isFeedOwner(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null) {
      return false;
    }
    if (paramStFeed.isRecomFd.get()) {
      return isOwner((FeedCloudMeta.StUser)paramStFeed.recomForward.poster.get());
    }
    return isOwner((FeedCloudMeta.StUser)paramStFeed.poster.get());
  }
  
  public static boolean isFollow(FeedCloudMeta.StUser paramStUser)
  {
    boolean bool = true;
    if ((paramStUser != null) && (!isOwner(paramStUser)))
    {
      if (paramStUser.followState.get() == 1) {
        return bool;
      }
      if (paramStUser.followState.get() == 3) {
        return true;
      }
    }
    bool = false;
    return bool;
  }
  
  public static boolean isOwner(FeedCloudMeta.StUser paramStUser)
  {
    return (paramStUser != null) && (MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount().equals(paramStUser.id.get()));
  }
  
  public static boolean isUnFollow(FeedCloudMeta.StUser paramStUser)
  {
    return (paramStUser != null) && (!isOwner(paramStUser)) && (paramStUser.followState.get() == 0);
  }
  
  public static boolean isVideoFeed(FeedCloudMeta.StFeed paramStFeed)
  {
    return (paramStFeed != null) && (!TextUtils.isEmpty(paramStFeed.video.fileId.get()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.utils.QCircleHostUtil
 * JD-Core Version:    0.7.0.1
 */