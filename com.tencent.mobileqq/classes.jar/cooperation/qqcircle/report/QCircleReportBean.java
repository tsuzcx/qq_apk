package cooperation.qqcircle.report;

import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import java.io.Serializable;
import mqq.app.MobileQQ;

public class QCircleReportBean
  implements Serializable
{
  public static final String TAG = "QCircleReportBean";
  private static final long serialVersionUID = 2688137205670436632L;
  private String mElementIdStr;
  private String mFromElementIdStr;
  private String mFromModuleIdStr;
  private int mFromPageId;
  private String mFromPageIdStr;
  private String mModuleIdStr;
  private int mPageId;
  private String mPageIdStr;
  
  public static int getPageId(String paramString, QCircleReportBean paramQCircleReportBean)
  {
    if (paramQCircleReportBean != null)
    {
      RFLog.d(paramString, RFLog.USR, ":getPageId value:" + paramQCircleReportBean.getPageId());
      return paramQCircleReportBean.getPageId();
    }
    RFLog.d(paramString, RFLog.USR, ":getPageId return invalid value:0");
    return 0;
  }
  
  public static int getParentPageId(String paramString, QCircleReportBean paramQCircleReportBean)
  {
    if (paramQCircleReportBean != null)
    {
      RFLog.d(paramString, RFLog.USR, ":getParentPageId value:" + paramQCircleReportBean.getPageId());
      return paramQCircleReportBean.getFromPageId();
    }
    RFLog.d(paramString, RFLog.USR, ":getParentPageId return invalid value:0");
    return 0;
  }
  
  public static QCircleReportBean getReportBean(String paramString, QCircleReportBean paramQCircleReportBean)
  {
    QCircleReportBean localQCircleReportBean = paramQCircleReportBean;
    if (paramQCircleReportBean == null)
    {
      if (!((IAppSettingApi)QRoute.api(IAppSettingApi.class)).isDebugVersion()) {
        break label86;
      }
      QQToast.a(MobileQQ.sMobileQQ.getApplicationContext(), paramString + ":getReportBean is empty", 1).a();
    }
    for (;;)
    {
      RFLog.d("QCircleReportBean", RFLog.USR, paramString + ":getReportBean is empty");
      localQCircleReportBean = paramQCircleReportBean;
      return localQCircleReportBean;
      label86:
      paramQCircleReportBean = new QCircleReportBean();
    }
  }
  
  public static boolean isContentDetailPage(int paramInt)
  {
    return 57 == paramInt;
  }
  
  public static boolean isFeedDetailPage(int paramInt)
  {
    return 69 == paramInt;
  }
  
  public static QCircleReportBean setReportBean(String paramString, QCircleReportBean paramQCircleReportBean)
  {
    if (paramQCircleReportBean == null)
    {
      if (((IAppSettingApi)QRoute.api(IAppSettingApi.class)).isDebugVersion()) {
        QQToast.a(MobileQQ.sMobileQQ.getApplicationContext(), paramString + ":setReportBean input is null", 1).a();
      }
      RFLog.d("QCircleReportBean", RFLog.USR, paramString + ":setReportBean input is null");
      return null;
    }
    return paramQCircleReportBean.clone();
  }
  
  public void assembleFromReportData(QCircleReportBean paramQCircleReportBean)
  {
    this.mFromPageId = paramQCircleReportBean.mPageId;
    this.mFromPageIdStr = paramQCircleReportBean.mPageIdStr;
    this.mFromModuleIdStr = paramQCircleReportBean.mModuleIdStr;
    this.mFromElementIdStr = paramQCircleReportBean.mElementIdStr;
  }
  
  public QCircleReportBean clone()
  {
    QCircleReportBean localQCircleReportBean = new QCircleReportBean();
    localQCircleReportBean.mFromPageId = this.mFromPageId;
    localQCircleReportBean.mPageId = this.mPageId;
    localQCircleReportBean.mPageIdStr = this.mPageIdStr;
    localQCircleReportBean.mModuleIdStr = this.mModuleIdStr;
    localQCircleReportBean.mElementIdStr = this.mElementIdStr;
    localQCircleReportBean.mFromPageIdStr = this.mFromPageIdStr;
    localQCircleReportBean.mFromModuleIdStr = this.mFromModuleIdStr;
    localQCircleReportBean.mFromElementIdStr = this.mFromElementIdStr;
    return localQCircleReportBean;
  }
  
  public String getElementIdStr()
  {
    return this.mElementIdStr;
  }
  
  public String getFromElementIdStr()
  {
    return this.mFromElementIdStr;
  }
  
  public String getFromModuleIdStr()
  {
    return this.mFromModuleIdStr;
  }
  
  public int getFromPageId()
  {
    return this.mFromPageId;
  }
  
  public String getFromPageIdStr()
  {
    return this.mFromPageIdStr;
  }
  
  public String getModuleIdStr()
  {
    return this.mModuleIdStr;
  }
  
  public int getPageId()
  {
    return this.mPageId;
  }
  
  public String getPageIdStr()
  {
    return this.mPageIdStr;
  }
  
  public QCircleReportBean setElementIdStr(String paramString)
  {
    this.mElementIdStr = paramString;
    return this;
  }
  
  public QCircleReportBean setFromElementIdStr(String paramString)
  {
    this.mFromElementIdStr = paramString;
    return this;
  }
  
  public QCircleReportBean setFromModuleIdStr(String paramString)
  {
    this.mFromModuleIdStr = paramString;
    return this;
  }
  
  public QCircleReportBean setFromPageId(int paramInt)
  {
    this.mFromPageId = paramInt;
    return this;
  }
  
  public QCircleReportBean setFromPageIdStr(String paramString)
  {
    this.mFromPageIdStr = paramString;
    return this;
  }
  
  public QCircleReportBean setModuleIdStr(String paramString)
  {
    this.mModuleIdStr = paramString;
    return this;
  }
  
  public QCircleReportBean setPageId(int paramInt)
  {
    this.mPageId = paramInt;
    return this;
  }
  
  public QCircleReportBean setPageIdStr(String paramString)
  {
    this.mPageIdStr = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleReportBean
 * JD-Core Version:    0.7.0.1
 */