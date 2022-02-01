package cooperation.qqcircle.report;

import android.content.Context;
import android.widget.Toast;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;

public class QCircleReportBean
  implements Serializable
{
  public static final String TAG = "QCircleReportBean";
  private static final long serialVersionUID = 2688137205670436632L;
  private String mDtFromPageId;
  private String mDtPageId;
  private int mFromPageId;
  private int mPageId = -1;
  
  public QCircleReportBean() {}
  
  public QCircleReportBean(int paramInt)
  {
    this.mPageId = paramInt;
  }
  
  public static int getPageId(String paramString, QCircleReportBean paramQCircleReportBean)
  {
    if (paramQCircleReportBean != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(":getPageId value:");
      localStringBuilder.append(paramQCircleReportBean.getPageId());
      QLog.d(paramString, 1, localStringBuilder.toString());
      return paramQCircleReportBean.getPageId();
    }
    QLog.d(paramString, 1, ":getPageId return invalid value:-1");
    return -1;
  }
  
  public static int getParentPageId(String paramString, QCircleReportBean paramQCircleReportBean)
  {
    if (paramQCircleReportBean != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(":getParentPageId value:");
      localStringBuilder.append(paramQCircleReportBean.getPageId());
      QLog.d(paramString, 1, localStringBuilder.toString());
      return paramQCircleReportBean.getFromPageId();
    }
    QLog.d(paramString, 1, ":getParentPageId return invalid value:0");
    return 0;
  }
  
  public static QCircleReportBean getReportBean(String paramString, QCircleReportBean paramQCircleReportBean)
  {
    if (paramQCircleReportBean == null)
    {
      if (((IAppSettingApi)QRoute.api(IAppSettingApi.class)).isDebugVersion())
      {
        Object localObject = RFApplication.getApplication();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(":getReportBean is empty");
        Toast.makeText((Context)localObject, localStringBuilder.toString(), 1).show();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(":getReportBean is empty");
        QLog.d("QCircleReportBean", 1, ((StringBuilder)localObject).toString());
        return paramQCircleReportBean;
      }
      return new QCircleReportBean();
    }
    return paramQCircleReportBean;
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
      paramQCircleReportBean = new StringBuilder();
      paramQCircleReportBean.append(paramString);
      paramQCircleReportBean.append(":setReportBean input is null");
      QLog.d("QCircleReportBean", 1, paramQCircleReportBean.toString());
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
    localQCircleReportBean.mDtPageId = this.mDtPageId;
    localQCircleReportBean.mDtFromPageId = this.mDtFromPageId;
    return localQCircleReportBean;
  }
  
  public String getDtFromPageId()
  {
    return this.mDtFromPageId;
  }
  
  public String getDtPageId()
  {
    return this.mDtPageId;
  }
  
  public int getFromPageId()
  {
    return this.mFromPageId;
  }
  
  public int getPageId()
  {
    return this.mPageId;
  }
  
  public QCircleReportBean setDtFromPageId(String paramString)
  {
    this.mDtFromPageId = paramString;
    return this;
  }
  
  public QCircleReportBean setDtPageId(String paramString)
  {
    this.mDtPageId = paramString;
    return this;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleReportBean
 * JD-Core Version:    0.7.0.1
 */