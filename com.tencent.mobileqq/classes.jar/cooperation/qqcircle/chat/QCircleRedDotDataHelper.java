package cooperation.qqcircle.chat;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import cooperation.qqcircle.redpoint.QCircleRedPointManager;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
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
    int k = ((Integer)QCircleChatBoxHelper.getInstance().getUnReadInfo().first).intValue();
    int j = Math.max(k, 0);
    int m = paramRedPointInfo.redTotalNum.get();
    int i = j;
    if (m > 0) {
      i = j + m;
    }
    QLog.d("QCircleRedDotDataHelper", 2, String.format("%s : pushUnReadNum = %d, chatUnReadNum = %d", new Object[] { "QCircleEeveeRedPoint_", Integer.valueOf(m), Integer.valueOf(k) }));
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
    return ((QCircleRedPointManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.QCIRCLE_MGR_RED_TOUCH)).getOuterEntranceRedPointInfoByAppid("circle_entrance");
  }
  
  public static byte[] getTransInfo(QQCircleCounter.RedPointInfo paramRedPointInfo)
  {
    int i = 0;
    paramRedPointInfo = paramRedPointInfo.transInfo.get();
    if (paramRedPointInfo == null) {}
    for (;;)
    {
      QLog.d("QCircleRedDotDataHelper", 2, String.format("%s : getTransInfo = %d", new Object[] { "QCircleEeveeRedPoint_", Integer.valueOf(i) }));
      if ((paramRedPointInfo == null) || (paramRedPointInfo.size() <= 0)) {
        break;
      }
      return paramRedPointInfo.toByteArray();
      i = paramRedPointInfo.size();
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
  
  public static boolean isShowActiveRedDot(QQCircleCounter.RedPointInfo paramRedPointInfo)
  {
    boolean bool = QCircleCommonUtil.checkOperateMaskEnabled(paramRedPointInfo.outLayerInfo.combineRedTypes.get(), 1);
    QLog.d("QCircleRedDotDataHelper", 2, String.format("%s : showActiveRedDot = %b", new Object[] { "QCircleEeveeRedPoint_", Boolean.valueOf(bool) }));
    return bool;
  }
  
  public static boolean isShowPymkRedDot(QQCircleCounter.RedPointInfo paramRedPointInfo)
  {
    boolean bool = QCircleCommonUtil.checkOperateMaskEnabled(paramRedPointInfo.outLayerInfo.combineRedTypes.get(), 6);
    QLog.d("QCircleRedDotDataHelper", 2, String.format("%s : showPYMKRedDot = %b", new Object[] { "QCircleEeveeRedPoint_", Boolean.valueOf(bool) }));
    return bool;
  }
  
  public static boolean isShowRecommendRedDot(QQCircleCounter.RedPointInfo paramRedPointInfo)
  {
    if ((((Integer)QCircleChatBoxHelper.getInstance().getUnReadInfo().first).intValue() <= 0) && (QCircleCommonUtil.checkOperateMaskEnabled(paramRedPointInfo.outLayerInfo.combineRedTypes.get(), 3))) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("QCircleRedDotDataHelper", 2, String.format("%s : showRecommendRedDot = %b", new Object[] { "QCircleEeveeRedPoint_", Boolean.valueOf(bool) }));
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.chat.QCircleRedDotDataHelper
 * JD-Core Version:    0.7.0.1
 */