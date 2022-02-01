package cooperation.qzone.util;

import java.util.HashMap;
import java.util.Map;

public final class QZoneDistributedAppCtrl$Control
{
  public int cmd;
  public Map<String, String> data = new HashMap();
  
  public String toString()
  {
    return "ctrl:[cmd = " + this.cmd + ", data = " + this.data + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.util.QZoneDistributedAppCtrl.Control
 * JD-Core Version:    0.7.0.1
 */