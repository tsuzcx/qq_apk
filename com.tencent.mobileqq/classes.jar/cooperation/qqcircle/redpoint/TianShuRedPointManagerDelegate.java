package cooperation.qqcircle.redpoint;

import android.text.TextUtils;
import azvi;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import qqcircle.QQCircleCounter.RedDisplayInfo;
import qqcircle.QQCircleCounter.RedPointInfo;

public class TianShuRedPointManagerDelegate
  implements IQCircleRedPointManagerDelegate
{
  private static final String TAG = "TianShuRedPointManagerDelegate";
  private static final String TIANSHU_QCIRCLE_RED_POINT_PATH = String.valueOf(140000);
  private QQAppInterface mApp;
  azvi mDelegateRedTouchManager;
  
  public TianShuRedPointManagerDelegate(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.mDelegateRedTouchManager = ((azvi)this.mApp.getManager(36));
  }
  
  private String getPathByAppid(String paramString)
  {
    return TIANSHU_QCIRCLE_RED_POINT_PATH;
  }
  
  public void asyncGetNumRedPointInfoByAppid(String paramString, QCircleRedPointManager.OnGetQQCircleNumRedMsgListener paramOnGetQQCircleNumRedMsgListener, boolean paramBoolean)
  {
    this.mDelegateRedTouchManager.a(paramOnGetQQCircleNumRedMsgListener, paramBoolean);
  }
  
  public void clearPedPoint() {}
  
  public QQCircleCounter.RedPointInfo getNumRedPointInfotByAppid(String paramString)
  {
    if (this.mDelegateRedTouchManager.a(getPathByAppid(paramString)) != null)
    {
      paramString = new QQCircleCounter.RedPointInfo();
      paramString.redType.set(2);
      int i = this.mDelegateRedTouchManager.a(null, true);
      paramString.redTotalNum.set(i);
      return paramString;
    }
    return null;
  }
  
  public QQCircleCounter.RedPointInfo getOuterEntranceRedPointInfoByAppid(String paramString)
  {
    return null;
  }
  
  public QQCircleCounter.RedPointInfo getSmallRedPointInfotByAppid(String paramString)
  {
    int i = 0;
    paramString = this.mDelegateRedTouchManager.a(getPathByAppid(paramString));
    if (paramString != null)
    {
      boolean bool;
      if (paramString.iNewFlag.get() == 1) {
        bool = true;
      }
      for (;;)
      {
        Object localObject1 = paramString.buffer.get();
        QLog.e("TianShuRedPointManagerDelegate", 1, "getSmallRedPointInfotByAppid hasSmallRedPoint: " + bool + ", buffer: " + (String)localObject1);
        if ((!bool) || (TextUtils.isEmpty((CharSequence)localObject1))) {
          break label219;
        }
        paramString = new QQCircleCounter.RedPointInfo();
        paramString.redType.set(1);
        try
        {
          localObject1 = new JSONObject((String)localObject1);
          Object localObject2 = ((JSONObject)localObject1).optString("_show_mission");
          localObject1 = ((JSONObject)localObject1).optJSONObject("param").optJSONObject((String)localObject2).optJSONArray("uin");
          if (localObject1 != null)
          {
            int j = ((JSONArray)localObject1).length();
            while (i < j)
            {
              localObject2 = new QQCircleCounter.RedDisplayInfo();
              ((QQCircleCounter.RedDisplayInfo)localObject2).headImg.set(((JSONArray)localObject1).getString(i));
              paramString.rptRedInfo.add((MessageMicro)localObject2);
              i += 1;
              continue;
              bool = false;
            }
          }
        }
        catch (Throwable localThrowable)
        {
          QLog.e("TianShuRedPointManagerDelegate", 1, "getSmallRedPointInfotByAppid buffer error!");
        }
      }
      return paramString;
    }
    label219:
    return null;
  }
  
  public void onDestroy()
  {
    this.mApp = null;
  }
  
  public void onNumRedPointClick(String paramString, ReportExtraInfo paramReportExtraInfo)
  {
    setNumRedPointReaded(paramString);
  }
  
  public void onNumRedPointExposure(String paramString, ReportExtraInfo paramReportExtraInfo) {}
  
  public void onOuterEntranceRedPointClick(String paramString, ReportExtraInfo paramReportExtraInfo) {}
  
  public void onOuterEntranceRedPointExposure(String paramString, ReportExtraInfo paramReportExtraInfo) {}
  
  public void onSmallRedPointClick(String paramString, ReportExtraInfo paramReportExtraInfo)
  {
    setSmallRedPointReaded(paramString);
  }
  
  public void onSmallRedPointExposure(String paramString, ReportExtraInfo paramReportExtraInfo) {}
  
  public void setNumRedPointReaded(String paramString)
  {
    paramString = this.mDelegateRedTouchManager.a(getPathByAppid(paramString));
    this.mDelegateRedTouchManager.a(paramString, 9, "");
  }
  
  public void setOuterEntranceRedPointReaded(String paramString, List<Integer> paramList) {}
  
  public void setSmallRedPointReaded(String paramString)
  {
    this.mDelegateRedTouchManager.b(getPathByAppid(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.redpoint.TianShuRedPointManagerDelegate
 * JD-Core Version:    0.7.0.1
 */