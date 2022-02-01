package com.tencent.mobileqq.qcircle.api.data;

import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.event.QCircleFrameEvent;
import com.tencent.mobileqq.qcircle.api.helper.QCircleRedDotDataHelper;
import com.tencent.mobileqq.qroute.QRoute;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import qqcircle.QQCircleCounter.AllPushPointInfo;
import qqcircle.QQCircleCounter.PymkRedPointInfo;
import qqcircle.QQCircleCounter.RedPointInfo;
import qqcircle.QQCircleCounter.RedPointJumpInfo;

public class QCircleRedInfoBean
  implements Serializable
{
  private static final String QQCIRCLE_REPORT_EXT1_RED_POINT_USE_EEVEE = "1";
  public static final int RED_ENTRANCE_TYPE_LEBA = 3;
  public static final int RED_ENTRANCE_TYPE_MAIN_TAB = 1;
  public static final int RED_ENTRANCE_TYPE_MESSAGE = 2;
  private static final int REPORT_QQCIRCLE_RED_DOT_ACTION_LEBA_ENTRY = 1;
  private static final int REPORT_QQCIRCLE_RED_DOT_SUB_ACTION_CLICK = 2;
  private static final int REPORT_QQCIRCLE_RED_DOT_SUB_ACTION_EXPOSE = 1;
  private static final int REPORT_QQCIRCLE_RED_DOT_THRD_ACTION_ACTIVE = 1;
  private static final int REPORT_QQCIRCLE_RED_DOT_THRD_ACTION_ACTIVE_AND_NUM = 3;
  private static final int REPORT_QQCIRCLE_RED_DOT_THRD_ACTION_IDLE = 0;
  private static final int REPORT_QQCIRCLE_RED_DOT_THRD_ACTION_NONE = 4;
  private static final int REPORT_QQCIRCLE_RED_DOT_THRD_ACTION_NUM = 2;
  private static final int REPORT_QQCIRCLE_RED_DOT_THRD_ACTION_PYMK = 6;
  private static final int REPORT_QQCIRCLE_RED_DOT_THRD_ACTION_RECOMMEND = 5;
  private static final String TAG = "QCircleRedInfoBean";
  private static final long serialVersionUID = 8760141975470995080L;
  private int mActionEntry = 1;
  private int mEntranceTabType = -1;
  private boolean mIsShowActiveRedDot = false;
  private boolean mIsShowPymkRedDot = false;
  private boolean mIsShowRecommendRedDot = false;
  private String mRecommendRedDotWording;
  private String mRedDotJumpUrl;
  private String mRedDotReportExt;
  private byte[] mRedDotTransInfo = null;
  private final int mRedEntranceType;
  private int mRedNum = 0;
  private boolean mShouldReportRed;
  
  public QCircleRedInfoBean(int paramInt)
  {
    this.mRedEntranceType = paramInt;
  }
  
  private int getQQCircleReportThrdAction()
  {
    int i = 0;
    if ((this.mRedNum > 0) && (this.mIsShowActiveRedDot)) {
      i = 3;
    }
    do
    {
      return i;
      if (this.mIsShowActiveRedDot) {
        return 1;
      }
      if (this.mRedNum > 0) {
        return 2;
      }
      if (this.mIsShowRecommendRedDot) {
        return 5;
      }
    } while (!this.mIsShowPymkRedDot);
    return 6;
  }
  
  private void isNeedSendRedNumChangeEvent(int paramInt)
  {
    if (paramInt != this.mRedNum)
    {
      QCircleFrameEvent localQCircleFrameEvent = new QCircleFrameEvent();
      localQCircleFrameEvent.mIsRefreshRedNum = true;
      SimpleEventBus.getInstance().dispatchEvent(localQCircleFrameEvent);
    }
  }
  
  private void setIsNeedReportFlag(QQCircleCounter.RedPointInfo paramRedPointInfo, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramInt != this.mRedNum) || (this.mIsShowPymkRedDot != paramBoolean2) || (this.mIsShowActiveRedDot != paramBoolean1) || (this.mIsShowRecommendRedDot != paramBoolean3))
    {
      this.mRedDotReportExt = QCircleRedDotDataHelper.getRedDotReportExt(paramRedPointInfo);
      this.mShouldReportRed = true;
      isNeedSendRedNumChangeEvent(paramInt);
    }
  }
  
  public int getAllRedNum()
  {
    return this.mRedNum;
  }
  
  public int getEntranceTabType()
  {
    return this.mEntranceTabType;
  }
  
  public String getRedDotJumpUrl()
  {
    return this.mRedDotJumpUrl;
  }
  
  public byte[] getRedDotTransInfo()
  {
    return this.mRedDotTransInfo;
  }
  
  public boolean isShowActiveRedDot()
  {
    return (this.mRedNum > 0) || (this.mIsShowActiveRedDot) || (this.mIsShowPymkRedDot) || (this.mIsShowRecommendRedDot);
  }
  
  public void refreshRedDotInfo()
  {
    RFLog.d("QCircleRedInfoBean", RFLog.USR, "refreshRedDotInfo");
    QQCircleCounter.RedPointInfo localRedPointInfo = QCircleRedDotDataHelper.getRedPointInfo();
    if (localRedPointInfo == null)
    {
      RFLog.d("QCircleRedInfoBean", RFLog.USR, "refreshRedDotInfo: redInfo is null");
      return;
    }
    int i = QCircleRedDotDataHelper.getAllRedNum(localRedPointInfo);
    boolean bool1 = QCircleRedDotDataHelper.isShowActiveRedDot(localRedPointInfo);
    boolean bool2 = QCircleRedDotDataHelper.isShowPymkRedDot(localRedPointInfo);
    boolean bool3 = QCircleRedDotDataHelper.isShowRecommendRedDot(localRedPointInfo, this.mRedEntranceType);
    setIsNeedReportFlag(localRedPointInfo, i, bool1, bool2, bool3);
    if (bool2) {}
    for (Object localObject1 = localRedPointInfo.pymkRedInfo.wording.get();; localObject1 = null)
    {
      Object localObject2;
      if (bool3)
      {
        String str = localRedPointInfo.allPushInfo.wording.get();
        localObject1 = str;
        if (localRedPointInfo.redJumpInfo.has())
        {
          localObject2 = localRedPointInfo.redJumpInfo.redPointSources.get();
          localObject1 = str;
          if (localObject2 != null)
          {
            localObject1 = str;
            if (((List)localObject2).size() > 0)
            {
              localObject1 = str;
              if (((List)localObject2).contains(Integer.valueOf(3)))
              {
                localObject2 = localRedPointInfo.redJumpInfo.jumpLink.get();
                localObject1 = str;
              }
            }
          }
        }
      }
      for (;;)
      {
        this.mRedNum = i;
        this.mIsShowActiveRedDot = bool1;
        this.mIsShowPymkRedDot = bool2;
        this.mIsShowRecommendRedDot = bool3;
        this.mRedDotJumpUrl = ((String)localObject2);
        this.mRecommendRedDotWording = ((String)localObject1);
        if ((this.mRedNum > 0) || (this.mIsShowActiveRedDot) || (this.mIsShowPymkRedDot) || (this.mIsShowRecommendRedDot))
        {
          this.mRedDotTransInfo = QCircleRedDotDataHelper.getTransInfo(localRedPointInfo);
          this.mEntranceTabType = QCircleRedDotDataHelper.getEntranceATabType(localRedPointInfo);
          return;
        }
        this.mRedDotTransInfo = null;
        this.mEntranceTabType = -1;
        return;
        localObject2 = null;
      }
    }
  }
  
  public void reportQQCircleClick()
  {
    int i = getQQCircleReportThrdAction();
    if (i != 0)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("ext1", "1");
      localHashMap.put("ext5", this.mRedDotReportExt);
      ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", this.mActionEntry, 2, i, localHashMap, null, null);
      RFLog.d("QCircleRedInfoBean", RFLog.USR, "reportQQCircleClick");
    }
  }
  
  public void reportRedDotWhenValueChange()
  {
    int i = getQQCircleReportThrdAction();
    if ((i != 0) && (this.mShouldReportRed))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("ext1", "1");
      localHashMap.put("ext5", this.mRedDotReportExt);
      ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", this.mActionEntry, 1, i, localHashMap, null, null);
      this.mShouldReportRed = false;
      RFLog.d("QCircleRedInfoBean", RFLog.USR, "reportRedDotWhenValueChange");
    }
  }
  
  public void reset()
  {
    RFLog.d("QCircleRedInfoBean", RFLog.USR, "reset");
    this.mRedNum = 0;
    this.mIsShowActiveRedDot = false;
    this.mIsShowPymkRedDot = false;
    this.mIsShowRecommendRedDot = false;
    this.mRedDotTransInfo = null;
    this.mEntranceTabType = -1;
    this.mRedDotReportExt = null;
  }
  
  public void setActionEntry(int paramInt)
  {
    this.mActionEntry = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.data.QCircleRedInfoBean
 * JD-Core Version:    0.7.0.1
 */