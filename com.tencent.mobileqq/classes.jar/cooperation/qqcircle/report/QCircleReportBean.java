package cooperation.qqcircle.report;

import android.content.Context;
import android.widget.Toast;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qroute.QRoute;
import java.io.Serializable;

public class QCircleReportBean
  implements Serializable
{
  public static final String TAG = "QCircleReportBean";
  private static final long serialVersionUID = 2688137205670436632L;
  private int mFromPageId;
  private int mPageId;
  
  public static int getPageId(String paramString, QCircleReportBean paramQCircleReportBean)
  {
    if (paramQCircleReportBean != null)
    {
      int i = RFLog.USR;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(":getPageId value:");
      localStringBuilder.append(paramQCircleReportBean.getPageId());
      RFLog.d(paramString, i, localStringBuilder.toString());
      return paramQCircleReportBean.getPageId();
    }
    RFLog.d(paramString, RFLog.USR, ":getPageId return invalid value:0");
    return 0;
  }
  
  public static int getParentPageId(String paramString, QCircleReportBean paramQCircleReportBean)
  {
    if (paramQCircleReportBean != null)
    {
      int i = RFLog.USR;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(":getParentPageId value:");
      localStringBuilder.append(paramQCircleReportBean.getPageId());
      RFLog.d(paramString, i, localStringBuilder.toString());
      return paramQCircleReportBean.getFromPageId();
    }
    RFLog.d(paramString, RFLog.USR, ":getParentPageId return invalid value:0");
    return 0;
  }
  
  public static QCircleReportBean getReportBean(String paramString, QCircleReportBean paramQCircleReportBean)
  {
    Object localObject = paramQCircleReportBean;
    if (paramQCircleReportBean == null)
    {
      if (((IAppSettingApi)QRoute.api(IAppSettingApi.class)).isDebugVersion())
      {
        localObject = RFApplication.getApplication();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(":getReportBean is empty");
        Toast.makeText((Context)localObject, localStringBuilder.toString(), 1).show();
      }
      else
      {
        paramQCircleReportBean = new QCircleReportBean();
      }
      int i = RFLog.USR;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(":getReportBean is empty");
      RFLog.d("QCircleReportBean", i, ((StringBuilder)localObject).toString());
      localObject = paramQCircleReportBean;
    }
    return localObject;
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
      if (((IAppSettingApi)QRoute.api(IAppSettingApi.class)).isDebugVersion())
      {
        paramQCircleReportBean = RFApplication.getApplication();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(":setReportBean input is null");
        Toast.makeText(paramQCircleReportBean, localStringBuilder.toString(), 1).show();
      }
      int i = RFLog.USR;
      paramQCircleReportBean = new StringBuilder();
      paramQCircleReportBean.append(paramString);
      paramQCircleReportBean.append(":setReportBean input is null");
      RFLog.d("QCircleReportBean", i, paramQCircleReportBean.toString());
      return null;
    }
    return paramQCircleReportBean.clone();
  }
  
  public void assembleFromReportData(QCircleReportBean paramQCircleReportBean)
  {
    this.mFromPageId = paramQCircleReportBean.mPageId;
  }
  
  public QCircleReportBean clone()
  {
    QCircleReportBean localQCircleReportBean = new QCircleReportBean();
    localQCircleReportBean.mFromPageId = this.mFromPageId;
    localQCircleReportBean.mPageId = this.mPageId;
    return localQCircleReportBean;
  }
  
  public int getFromPageId()
  {
    return this.mFromPageId;
  }
  
  public int getPageId()
  {
    return this.mPageId;
  }
  
  public QCircleReportBean setFromPageId(int paramInt)
  {
    this.mFromPageId = paramInt;
    return this;
  }
  
  public QCircleReportBean setPageId(int paramInt)
  {
    this.mPageId = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleReportBean
 * JD-Core Version:    0.7.0.1
 */