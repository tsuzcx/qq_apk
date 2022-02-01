package com.tencent.mobileqq.flashshow.utils;

import com.tencent.mobileqq.flashshow.basedata.FSFeedData;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StVideo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleReport.SingleDcData;

public class FSProtoUtils
{
  public static List<byte[]> a(List<QQCircleReport.SingleDcData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(((QQCircleReport.SingleDcData)paramList.next()).toByteArray());
    }
    return localArrayList;
  }
  
  public static boolean a(Object paramObject)
  {
    boolean bool2 = QCircleConfigHelper.aH();
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    FeedCloudMeta.StFeed localStFeed = null;
    if ((paramObject instanceof FeedCloudMeta.StFeed)) {
      localStFeed = (FeedCloudMeta.StFeed)paramObject;
    } else if ((paramObject instanceof FSFeedData)) {
      localStFeed = ((FSFeedData)paramObject).b();
    }
    if (localStFeed == null)
    {
      QLog.w("FSProtoUtils", 1, "isQUIC() false? invalid reportData");
      return false;
    }
    if (localStFeed.video.isQuic.get() != 0) {
      bool1 = true;
    }
    QLog.w("FSProtoUtils", 1, "isQUIC() true?");
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.utils.FSProtoUtils
 * JD-Core Version:    0.7.0.1
 */