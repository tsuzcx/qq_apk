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
import qqcircle.QQCircleBase.UserCircleInfo;

public class QCircleHostUtil
{
  private static final String TAG = "QCircleHostUtil";
  
  public static String bigNumberFormatTranfer(long paramLong)
  {
    return bigNumberFormatTranfer(paramLong, false);
  }
  
  public static String bigNumberFormatTranfer(long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = HardCodeUtil.a(2131697848); paramLong < 10000L; str = "W") {
      return String.valueOf(paramLong);
    }
    if (paramLong < 1000000L)
    {
      DecimalFormat localDecimalFormat = new DecimalFormat();
      localDecimalFormat.setMaximumFractionDigits(1);
      localDecimalFormat.setGroupingSize(0);
      localDecimalFormat.setRoundingMode(RoundingMode.HALF_UP);
      return localDecimalFormat.format(paramLong / 10000.0D) + str;
    }
    if (paramLong < 100000000L) {
      return paramLong / 10000L + str;
    }
    return "9999" + str;
  }
  
  public static boolean checkOperateMaskEnabled(long paramLong, int paramInt)
  {
    return (1 << paramInt & paramLong) != 0L;
  }
  
  public static String fansNumberFormatTranfer(long paramLong)
  {
    if (paramLong < 10000L) {
      return String.valueOf(paramLong);
    }
    if (paramLong < 1000000L)
    {
      DecimalFormat localDecimalFormat = new DecimalFormat();
      localDecimalFormat.setMaximumFractionDigits(1);
      localDecimalFormat.setGroupingSize(0);
      localDecimalFormat.setRoundingMode(RoundingMode.HALF_UP);
      return localDecimalFormat.format(paramLong / 10000.0D) + "w";
    }
    if (paramLong < 100000000L) {
      return paramLong / 10000L + "w";
    }
    return "9999" + "w";
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
      if (paramStFeed.dittoFeed.dittoId.get() == 0) {
        break label31;
      }
      arrayOfInt[0] = 3;
      arrayOfInt[1] = 1;
    }
    label31:
    do
    {
      return arrayOfInt;
      if (paramStFeed.type.get() == 2)
      {
        arrayOfInt[0] = 1;
        arrayOfInt[1] = 1;
        return arrayOfInt;
      }
    } while (paramStFeed.type.get() != 3);
    arrayOfInt[0] = 1;
    arrayOfInt[1] = 2;
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
    return (paramStUser != null) && (!isOwner(paramStUser)) && ((paramStUser.followState.get() == 1) || (paramStUser.followState.get() == 2));
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
  
  public static void updateCircleAuthInfo(ArrayList<QQCircleBase.UserCircleInfo> paramArrayList, int paramInt, String paramString)
  {
    if ((paramArrayList == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      localUserCircleInfo = (QQCircleBase.UserCircleInfo)paramArrayList.get(i);
      if ((!paramString.equals(localUserCircleInfo.name.get())) || (localUserCircleInfo.circleTab.get() == 1))
      {
        i += 1;
      }
      else
      {
        localUserCircleInfo.circleTab.set(paramInt);
        return;
      }
    }
    QQCircleBase.UserCircleInfo localUserCircleInfo = new QQCircleBase.UserCircleInfo();
    localUserCircleInfo.name.set(paramString);
    localUserCircleInfo.circleTab.set(paramInt);
    paramArrayList.add(localUserCircleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.utils.QCircleHostUtil
 * JD-Core Version:    0.7.0.1
 */