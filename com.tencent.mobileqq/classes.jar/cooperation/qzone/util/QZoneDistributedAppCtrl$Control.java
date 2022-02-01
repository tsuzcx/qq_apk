package cooperation.qzone.util;

import java.util.HashMap;
import java.util.Map;

public final class QZoneDistributedAppCtrl$Control
{
  public int cmd;
  public Map<String, String> data = new HashMap();
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ctrl:[cmd = ");
    localStringBuilder.append(this.cmd);
    localStringBuilder.append(", data = ");
    localStringBuilder.append(this.data);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.util.QZoneDistributedAppCtrl.Control
 * JD-Core Version:    0.7.0.1
 */