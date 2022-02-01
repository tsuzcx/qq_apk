package com.tencent.mobileqq.qcircle.api.helper;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.IQCircleRedPointService;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import qqcircle.QQCircleCounter.AllPushPointInfo;
import qqcircle.QQCircleCounter.OutLayerPointInfo;
import qqcircle.QQCircleCounter.RedDisplayInfo;
import qqcircle.QQCircleCounter.RedPointInfo;

public class QCircleRedDotDataHelper
{
  private static final String TAG = "QCircleRedDotDataHelper";
  
  public static int getAllRedNum(QQCircleCounter.RedPointInfo paramRedPointInfo)
  {
    int i = Math.max(paramRedPointInfo.redTotalNum.get(), 0);
    QLog.d("QCircleRedDotDataHelper", 2, String.format("%s : pushUnReadNum = %d,", new Object[] { "QCircleEeveeRedPoint_", Integer.valueOf(i) }));
    return i;
  }
  
  public static int getEntranceATabType(QQCircleCounter.RedPointInfo paramRedPointInfo)
  {
    int i = paramRedPointInfo.tabType.get();
    QLog.d("QCircleRedDotDataHelper", 2, String.format("%s : entranceTargetTabType = %d", new Object[] { "QCircleEeveeRedPoint_", Integer.valueOf(i) }));
    return i;
  }
  
  public static String getPymkWord(QQCircleCounter.RedPointInfo paramRedPointInfo)
  {
    return paramRedPointInfo.wording.get();
  }
  
  public static String getRecommendWord(QQCircleCounter.RedPointInfo paramRedPointInfo)
  {
    return paramRedPointInfo.wording.get();
  }
  
  public static String getRedDotReportExt(QQCircleCounter.RedPointInfo paramRedPointInfo)
  {
    return paramRedPointInfo.extend.get();
  }
  
  public static QQCircleCounter.RedPointInfo getRedPointInfo()
  {
    return ((IQCircleRedPointService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IQCircleRedPointService.class, "")).getOuterEntranceRedPointInfoByAppid("circle_entrance");
  }
  
  public static byte[] getTransInfo(QQCircleCounter.RedPointInfo paramRedPointInfo)
  {
    paramRedPointInfo = paramRedPointInfo.transInfo.get();
    int i = 0;
    if (paramRedPointInfo != null) {
      i = paramRedPointInfo.size();
    }
    QLog.d("QCircleRedDotDataHelper", 2, String.format("%s : getTransInfo = %d", new Object[] { "QCircleEeveeRedPoint_", Integer.valueOf(i) }));
    if ((paramRedPointInfo != null) && (paramRedPointInfo.size() > 0)) {
      return paramRedPointInfo.toByteArray();
    }
    return null;
  }
  
  public static List<String> getUserAvatarUrlList(QQCircleCounter.RedPointInfo paramRedPointInfo)
  {
    ArrayList localArrayList = new ArrayList();
    paramRedPointInfo = paramRedPointInfo.rptRedInfo.get();
    if ((paramRedPointInfo != null) && (paramRedPointInfo.size() > 0))
    {
      paramRedPointInfo = paramRedPointInfo.iterator();
      while (paramRedPointInfo.hasNext()) {
        localArrayList.add(((QQCircleCounter.RedDisplayInfo)paramRedPointInfo.next()).headImg.get());
      }
    }
    return localArrayList;
  }
  
  private static boolean isInvalidRecommendRedDot(QQCircleCounter.RedPointInfo paramRedPointInfo, int paramInt)
  {
    boolean bool = false;
    if (paramInt != 1) {
      return false;
    }
    if (paramRedPointInfo.allPushInfo.msgType.get() == 4) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean isShowActiveRedDot(QQCircleCounter.RedPointInfo paramRedPointInfo)
  {
    boolean bool = QCircleHostUtil.checkOperateMaskEnabled(paramRedPointInfo.outLayerInfo.combineRedTypes.get(), 1);
    QLog.d("QCircleRedDotDataHelper", 2, String.format("%s : showActiveRedDot = %b", new Object[] { "QCircleEeveeRedPoint_", Boolean.valueOf(bool) }));
    return bool;
  }
  
  public static boolean isShowPymkRedDot(QQCircleCounter.RedPointInfo paramRedPointInfo)
  {
    boolean bool = QCircleHostUtil.checkOperateMaskEnabled(paramRedPointInfo.outLayerInfo.combineRedTypes.get(), 6);
    QLog.d("QCircleRedDotDataHelper", 2, String.format("%s : showPYMKRedDot = %b", new Object[] { "QCircleEeveeRedPoint_", Boolean.valueOf(bool) }));
    return bool;
  }
  
  public static boolean isShowRecommendRedDot(QQCircleCounter.RedPointInfo paramRedPointInfo, int paramInt)
  {
    boolean bool = QCircleHostUtil.checkOperateMaskEnabled(paramRedPointInfo.outLayerInfo.combineRedTypes.get(), 3);
    QLog.d("QCircleRedDotDataHelper", 2, String.format("%s : showRecommendRedDot = %b, RedEntranceType:%d", new Object[] { "QCircleEeveeRedPoint_", Boolean.valueOf(bool), Integer.valueOf(paramInt) }));
    if (isInvalidRecommendRedDot(paramRedPointInfo, paramInt))
    {
      QLog.d("QCircleRedDotDataHelper", 2, String.format("%s : showRecommendRedDot = %b, RedEntranceType:%d, isInvalidRecommendRedDot", new Object[] { "QCircleEeveeRedPoint_", Boolean.valueOf(bool), Integer.valueOf(paramInt) }));
      return false;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.helper.QCircleRedDotDataHelper
 * JD-Core Version:    0.7.0.1
 */