package cooperation.qqcircle.relation;

import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.relation.entitys.NewRelationInfo;
import cooperation.qqcircle.relation.request.IQCircleRelationModel.OnLoadAtRelationListener;
import java.util.List;
import java.util.Map;

class QCircleRelationGroupManager$1
  implements IQCircleRelationModel.OnLoadAtRelationListener
{
  QCircleRelationGroupManager$1(QCircleRelationGroupManager paramQCircleRelationGroupManager) {}
  
  public void onLoadAtRelationFail(int paramInt, long paramLong, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onLoadAtRelationFail] errCode: ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" | errMsg: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" | scene: ");
    localStringBuilder.append(paramInt);
    QLog.w("RFL-QCircleAtGroupManager", 1, localStringBuilder.toString());
  }
  
  public void onLoadAtRelationFinish(int paramInt, Map<String, List<NewRelationInfo>> paramMap, long paramLong)
  {
    if (paramInt == 0)
    {
      QCircleRelationGroupManager.access$000(this.this$0, paramMap, paramLong);
      return;
    }
    if (paramInt == 1) {
      QCircleRelationGroupManager.access$100(this.this$0, paramMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.relation.QCircleRelationGroupManager.1
 * JD-Core Version:    0.7.0.1
 */