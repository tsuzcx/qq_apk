package cooperation.qqcircle.beans;

import com.tencent.biz.qcircleshadow.lib.variation.HostForwardUtils.ForwardInfoEntity;
import java.io.Serializable;

public class QCircleForwardInfoReportBean
  implements Serializable
{
  public static final long serialVersionUID = 1L;
  private HostForwardUtils.ForwardInfoEntity mForwardEntity;
  private int mPageId;
  private int mParentPageId;
  private QCircleForwardInfoReportBean.QCircleForwardExtraTypeInfo mReportExtra;
  
  public HostForwardUtils.ForwardInfoEntity getForwardEntity()
  {
    return this.mForwardEntity;
  }
  
  public int getPageId()
  {
    return this.mPageId;
  }
  
  public int getParentPageId()
  {
    return this.mParentPageId;
  }
  
  public QCircleForwardInfoReportBean.QCircleForwardExtraTypeInfo getReportExtra()
  {
    return this.mReportExtra;
  }
  
  public void setForwardEntity(HostForwardUtils.ForwardInfoEntity paramForwardInfoEntity)
  {
    this.mForwardEntity = paramForwardInfoEntity;
  }
  
  public void setPageId(int paramInt)
  {
    this.mPageId = paramInt;
  }
  
  public void setParentPageId(int paramInt)
  {
    this.mParentPageId = paramInt;
  }
  
  public void setReportExtra(QCircleForwardInfoReportBean.QCircleForwardExtraTypeInfo paramQCircleForwardExtraTypeInfo)
  {
    this.mReportExtra = paramQCircleForwardExtraTypeInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.beans.QCircleForwardInfoReportBean
 * JD-Core Version:    0.7.0.1
 */