package cooperation.qqcircle.beans;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.chat.QCircleRedDotDataHelper;
import cooperation.qqcircle.events.QCircleFrameEvent;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
import qqcircle.QQCircleCounter.RedPointInfo;

public class QCircleRedInfoBean
  implements Serializable
{
  private static final String QQCIRCLE_REPORT_EXT1_RED_POINT_USE_EEVEE = "1";
  private static final int REPORT_QQCIRCLE_RED_DOT_ACTION_MAIN_TAB_ENTRY = 1;
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
  private int mEntranceTabType = -1;
  private boolean mIsShowActiveRedDot;
  private boolean mIsShowPymkRedDot;
  private boolean mIsShowRecommendRedDot;
  private String mRedDotReportExt;
  private byte[] mRedDotTransInfo;
  private int mRedNum;
  private boolean mShouldReportRed;
  
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
  
  public BusinessInfoCheckUpdate.RedTypeInfo getQQRedTypeInfo()
  {
    for (;;)
    {
      try
      {
        refreshRedDotInfo();
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
        localRedTypeInfo.red_type.set(-1);
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("cn", "#FF0000");
          localRedTypeInfo.red_desc.set(localJSONObject.toString());
          if (this.mRedNum > 0)
          {
            localRedTypeInfo.red_type.set(5);
            localRedTypeInfo.red_content.set(String.valueOf(this.mRedNum));
            return localRedTypeInfo;
          }
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
          continue;
        }
        if (!isShowActiveRedDot()) {
          continue;
        }
      }
      finally {}
      localObject.red_type.set(0);
    }
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
    boolean bool3 = QCircleRedDotDataHelper.isShowRecommendRedDot(localRedPointInfo);
    setIsNeedReportFlag(localRedPointInfo, i, bool1, bool2, bool3);
    this.mRedNum = i;
    this.mIsShowActiveRedDot = bool1;
    this.mIsShowPymkRedDot = bool2;
    this.mIsShowRecommendRedDot = bool3;
    this.mRedDotTransInfo = QCircleRedDotDataHelper.getTransInfo(localRedPointInfo);
    this.mEntranceTabType = QCircleRedDotDataHelper.getEntranceATabType(localRedPointInfo);
  }
  
  public void reportQQCircleClick()
  {
    int i = getQQCircleReportThrdAction();
    if (i != 0)
    {
      QCircleLpReportDc05504.report("", 1, 2, i, "1", "", this.mRedDotReportExt, null, "", "", null, -1, -1);
      QLog.d("QCircleRedInfoBean", 1, "reportQQCircleClick");
    }
  }
  
  public void reportRedDotWhenValueChange()
  {
    int i = getQQCircleReportThrdAction();
    if ((i != 0) && (this.mShouldReportRed))
    {
      QCircleLpReportDc05504.report("", 1, 1, i, "1", "", this.mRedDotReportExt, null, "", "", null, -1, -1);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.beans.QCircleRedInfoBean
 * JD-Core Version:    0.7.0.1
 */