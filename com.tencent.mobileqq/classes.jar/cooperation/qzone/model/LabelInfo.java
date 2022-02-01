package cooperation.qzone.model;

import java.io.Serializable;

public class LabelInfo
  implements Serializable, Comparable
{
  public boolean hasSelected;
  public String id;
  public String name;
  
  protected Object clone()
  {
    LabelInfo localLabelInfo = new LabelInfo();
    localLabelInfo.id = this.id;
    localLabelInfo.name = this.name;
    localLabelInfo.hasSelected = this.hasSelected;
    return localLabelInfo;
  }
  
  public int compareTo(Object paramObject)
  {
    if ((this.hasSelected) && (!((LabelInfo)paramObject).hasSelected)) {
      return -1;
    }
    if ((!this.hasSelected) && (((LabelInfo)paramObject).hasSelected)) {
      return 1;
    }
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass())) {
      return false;
    }
    paramObject = (LabelInfo)paramObject;
    return this.name.equals(paramObject.name);
  }
  
  public int hashCode()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.model.LabelInfo
 * JD-Core Version:    0.7.0.1
 */