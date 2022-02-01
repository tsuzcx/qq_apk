package cooperation.qzone.model;

import java.io.Serializable;

public class LabelInfo
  implements Serializable, Comparable
{
  public boolean hasSelected = false;
  public String id;
  public String name;
  public String rank;
  
  protected Object clone()
  {
    LabelInfo localLabelInfo = new LabelInfo();
    localLabelInfo.id = this.id;
    localLabelInfo.name = this.name;
    localLabelInfo.rank = this.rank;
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
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("LabelInfo{\n");
    localStringBuffer.append("id='").append(this.id).append('\'').append('\n');
    localStringBuffer.append(", name='").append(this.name).append('\'').append('\n');
    localStringBuffer.append(", rank='").append(this.rank).append('\'').append('\n');
    localStringBuffer.append(", hasSelected=").append(this.hasSelected).append('\n');
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.model.LabelInfo
 * JD-Core Version:    0.7.0.1
 */