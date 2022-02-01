package cooperation.qqcircle.relation.entitys;

import feedcloud.FeedCloudMeta.StRelationInfo;

public class NewRelationInfo
{
  private int mGroupFlag = 0;
  private FeedCloudMeta.StRelationInfo mRelationInfo;
  
  public int getGroupFlag()
  {
    return this.mGroupFlag;
  }
  
  public FeedCloudMeta.StRelationInfo getRelationInfo()
  {
    return this.mRelationInfo;
  }
  
  public void setGroupFlag(int paramInt)
  {
    this.mGroupFlag = paramInt;
  }
  
  public void setRelationInfo(FeedCloudMeta.StRelationInfo paramStRelationInfo)
  {
    this.mRelationInfo = paramStRelationInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.relation.entitys.NewRelationInfo
 * JD-Core Version:    0.7.0.1
 */