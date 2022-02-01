package cooperation.qqcircle.relation.request;

import cooperation.qqcircle.relation.entitys.NewRelationInfo;
import java.util.List;
import java.util.Map;

public abstract interface IQCircleRelationModel$OnLoadAtRelationListener
{
  public abstract void onLoadAtRelationFail(int paramInt, long paramLong, String paramString);
  
  public abstract void onLoadAtRelationFinish(int paramInt, Map<String, List<NewRelationInfo>> paramMap, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.relation.request.IQCircleRelationModel.OnLoadAtRelationListener
 * JD-Core Version:    0.7.0.1
 */