package com.tencent.mobileqq.qcircle.api.helper;

import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.IQCircleRedPointService;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import qqcircle.QQCircleCounter.AllPushPointInfo;
import qqcircle.QQCircleCounter.OutLayerPointInfo;
import qqcircle.QQCircleCounter.PymkRedPointInfo;
import qqcircle.QQCircleCounter.RedDisplayInfo;
import qqcircle.QQCircleCounter.RedPointInfo;

public class QCircleRedDotDataHelper
{
  private static final String TAG = "QCircleRedDotDataHelper";
  
  public static int getAllRedNum(QQCircleCounter.RedPointInfo paramRedPointInfo)
  {
    int k = QCircleChatBoxHelper.getInstance().getUnReadChatNum();
    int j = Math.max(k, 0);
    int m = paramRedPointInfo.redTotalNum.get();
    int i = j;
    if (m > 0) {
      i = j + m;
    }
    RFLog.d("QCircleRedDotDataHelper", RFLog.CLR, String.format("%s : pushUnReadNum = %d, chatUnReadNum = %d", new Object[] { "QCircleEeveeRedPoint_", Integer.valueOf(m), Integer.valueOf(k) }));
    return i;
  }
  
  public static int getEntranceATabType(QQCircleCounter.RedPointInfo paramRedPointInfo)
  {
    int i = paramRedPointInfo.tabType.get();
    RFLog.d("QCircleRedDotDataHelper", RFLog.CLR, String.format("%s : entranceTargetTabType = %d", new Object[] { "QCircleEeveeRedPoint_", Integer.valueOf(i) }));
    return i;
  }
  
  public static String getPymkWord(QQCircleCounter.RedPointInfo paramRedPointInfo)
  {
    return paramRedPointInfo.pymkRedInfo.wording.get();
  }
  
  public static String getRecommendWord(QQCircleCounter.RedPointInfo paramRedPointInfo)
  {
    return paramRedPointInfo.allPushInfo.wording.get();
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
    int j = RFLog.CLR;
    int i = 0;
    if (paramRedPointInfo != null) {
      i = paramRedPointInfo.size();
    }
    RFLog.d("QCircleRedDotDataHelper", j, String.format("%s : getTransInfo = %d", new Object[] { "QCircleEeveeRedPoint_", Integer.valueOf(i) }));
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
    RFLog.d("QCircleRedDotDataHelper", RFLog.CLR, String.format("%s : showActiveRedDot = %b", new Object[] { "QCircleEeveeRedPoint_", Boolean.valueOf(bool) }));
    return bool;
  }
  
  public static boolean isShowPymkRedDot(QQCircleCounter.RedPointInfo paramRedPointInfo)
  {
    boolean bool = QCircleHostUtil.checkOperateMaskEnabled(paramRedPointInfo.outLayerInfo.combineRedTypes.get(), 6);
    RFLog.d("QCircleRedDotDataHelper", RFLog.CLR, String.format("%s : showPYMKRedDot = %b", new Object[] { "QCircleEeveeRedPoint_", Boolean.valueOf(bool) }));
    return bool;
  }
  
  public static boolean isShowRecommendRedDot(QQCircleCounter.RedPointInfo paramRedPointInfo, int paramInt)
  {
    boolean bool;
    if ((QCircleChatBoxHelper.getInstance().getUnReadChatNum() <= 0) && (QCircleHostUtil.checkOperateMaskEnabled(paramRedPointInfo.outLayerInfo.combineRedTypes.get(), 3))) {
      bool = true;
    } else {
      bool = false;
    }
    RFLog.d("QCircleRedDotDataHelper", RFLog.CLR, String.format("%s : showRecommendRedDot = %b, RedEntranceType:%d", new Object[] { "QCircleEeveeRedPoint_", Boolean.valueOf(bool), Integer.valueOf(paramInt) }));
    if (isInvalidRecommendRedDot(paramRedPointInfo, paramInt))
    {
      RFLog.d("QCircleRedDotDataHelper", RFLog.CLR, String.format("%s : showRecommendRedDot = %b, RedEntranceType:%d, isInvalidRecommendRedDot", new Object[] { "QCircleEeveeRedPoint_", Boolean.valueOf(bool), Integer.valueOf(paramInt) }));
      return false;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.helper.QCircleRedDotDataHelper
 * JD-Core Version:    0.7.0.1
 */