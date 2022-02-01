package cooperation.qqcircle.report;

import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;

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
      QLog.d(paramString, 1, ":getPageId value:" + paramQCircleReportBean.getPageId());
      return paramQCircleReportBean.getPageId();
    }
    QLog.d(paramString, 1, ":getPageId return invalid value:0");
    return 0;
  }
  
  public static int getParentPageId(String paramString, QCircleReportBean paramQCircleReportBean)
  {
    if (paramQCircleReportBean != null)
    {
      QLog.d(paramString, 1, ":getParentPageId value:" + paramQCircleReportBean.getPageId());
      return paramQCircleReportBean.getFromPageId();
    }
    QLog.d(paramString, 1, ":getParentPageId return invalid value:0");
    return 0;
  }
  
  public static QCircleReportBean getReportBean(String paramString, QCircleReportBean paramQCircleReportBean)
  {
    QCircleReportBean localQCircleReportBean = paramQCircleReportBean;
    if (paramQCircleReportBean == null)
    {
      localQCircleReportBean = new QCircleReportBean();
      QLog.d("QCircleReportBean", 1, paramString + ":getReportBean is empty");
    }
    return localQCircleReportBean;
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
      QLog.d("QCircleReportBean", 1, paramString + ":setReportBean input is null");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleReportBean
 * JD-Core Version:    0.7.0.1
 */