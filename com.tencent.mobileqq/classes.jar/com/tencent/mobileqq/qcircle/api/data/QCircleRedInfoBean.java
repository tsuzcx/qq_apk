package com.tencent.mobileqq.qcircle.api.data;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleLpReportDc05504DataBuilder;
import com.tencent.mobileqq.qcircle.api.event.QCircleFrameEvent;
import com.tencent.mobileqq.qcircle.api.helper.QCircleRedDotDataHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
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
  private static final int REPORT_QQCIRCLE_RED_DOT_THRD_ACTION_NEW = 7;
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
    int i;
    if ((this.mRedNum > 0) && (this.mIsShowActiveRedDot)) {
      i = 3;
    } else if (this.mIsShowActiveRedDot) {
      i = 1;
    } else if (this.mRedNum > 0) {
      i = 2;
    } else if (this.mIsShowRecommendRedDot) {
      i = 5;
    } else if (this.mIsShowPymkRedDot) {
      i = 6;
    } else {
      i = 4;
    }
    if (QzoneConfig.getQQCircleShowGuideOnLebaEntrance()) {
      i = 7;
    }
    return i;
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
    return this.mIsShowActiveRedDot;
  }
  
  public boolean isShowRecommendRedDot()
  {
    return this.mIsShowRecommendRedDot;
  }
  
  public boolean isShowRedDot()
  {
    return (this.mRedNum > 0) || (this.mIsShowActiveRedDot) || (this.mIsShowPymkRedDot) || (this.mIsShowRecommendRedDot);
  }
  
  public void refreshRedDotInfo()
  {
    QLog.d("QCircleRedInfoBean", 1, "refreshRedDotInfo");
    QQCircleCounter.RedPointInfo localRedPointInfo = QCircleRedDotDataHelper.getRedPointInfo();
    if (localRedPointInfo == null)
    {
      QLog.d("QCircleRedInfoBean", 1, "refreshRedDotInfo: redInfo is null");
      return;
    }
    int i = QCircleRedDotDataHelper.getAllRedNum(localRedPointInfo);
    boolean bool1 = QCircleRedDotDataHelper.isShowActiveRedDot(localRedPointInfo);
    boolean bool2 = QCircleRedDotDataHelper.isShowPymkRedDot(localRedPointInfo);
    boolean bool3 = QCircleRedDotDataHelper.isShowRecommendRedDot(localRedPointInfo, this.mRedEntranceType);
    setIsNeedReportFlag(localRedPointInfo, i, bool1, bool2, bool3);
    Object localObject1;
    if (bool2) {
      localObject1 = localRedPointInfo.wording.get();
    } else {
      localObject1 = null;
    }
    if (bool3)
    {
      localObject2 = localRedPointInfo.wording.get();
      localObject1 = localObject2;
      if (localRedPointInfo.redJumpInfo.has())
      {
        Object localObject3 = localRedPointInfo.redJumpInfo.redPointSources.get();
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject1 = localObject2;
          if (((List)localObject3).size() > 0)
          {
            localObject1 = localObject2;
            if (((List)localObject3).contains(Integer.valueOf(3)))
            {
              localObject3 = localRedPointInfo.redJumpInfo.jumpLink.get();
              localObject1 = localObject2;
              localObject2 = localObject3;
              break label198;
            }
          }
        }
      }
    }
    Object localObject2 = null;
    label198:
    this.mRedNum = i;
    this.mIsShowActiveRedDot = bool1;
    this.mIsShowPymkRedDot = bool2;
    this.mIsShowRecommendRedDot = bool3;
    this.mRedDotJumpUrl = ((String)localObject2);
    this.mRecommendRedDotWording = ((String)localObject1);
    if ((this.mRedNum <= 0) && (!this.mIsShowActiveRedDot) && (!this.mIsShowPymkRedDot) && (!this.mIsShowRecommendRedDot))
    {
      this.mRedDotTransInfo = null;
      this.mEntranceTabType = -1;
      return;
    }
    this.mRedDotTransInfo = QCircleRedDotDataHelper.getTransInfo(localRedPointInfo);
    this.mEntranceTabType = QCircleRedDotDataHelper.getEntranceATabType(localRedPointInfo);
  }
  
  public void reportQQCircleClick()
  {
    int i = getQQCircleReportThrdAction();
    if (i != 0)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("ext1", "1");
      localHashMap.put("ext5", this.mRedDotReportExt);
      ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(this.mActionEntry).setSubActionType(2).setThrActionType(i).setExtras(localHashMap));
      QLog.d("QCircleRedInfoBean", 1, "reportQQCircleClick");
    }
  }
  
  public void reportRedDotWhenValueChange()
  {
    int i = getQQCircleReportThrdAction();
    if ((!QzoneConfig.getQQCircleEnableNoneRedpointReport()) && (i == 4)) {
      return;
    }
    if ((!QzoneConfig.getQQCircleEnableHasRedpointReport()) && (i != 4)) {
      return;
    }
    if ((i != 0) && (this.mShouldReportRed))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("ext1", "1");
      localHashMap.put("ext5", this.mRedDotReportExt);
      ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(this.mActionEntry).setSubActionType(1).setThrActionType(i).setExtras(localHashMap));
      this.mShouldReportRed = false;
      QLog.d("QCircleRedInfoBean", 1, "reportRedDotWhenValueChange");
    }
  }
  
  public void reset()
  {
    QLog.d("QCircleRedInfoBean", 1, "reset");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.data.QCircleRedInfoBean
 * JD-Core Version:    0.7.0.1
 */