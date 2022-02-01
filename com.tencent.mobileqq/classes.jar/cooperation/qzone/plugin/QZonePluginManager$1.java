package cooperation.qzone.plugin;

import bctj;
import bmdx;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.HashMap;

public class QZonePluginManager$1
  implements Runnable
{
  public QZonePluginManager$1(bmdx parambmdx, String paramString, int paramInt) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("plugin_id", this.jdField_a_of_type_JavaLangString);
    localHashMap.put("refer", String.valueOf(this.jdField_a_of_type_Int));
    bctj.a(BaseApplicationImpl.getContext()).a(null, "QzonePluginDownloadRefer", true, 0L, 0L, localHashMap, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.plugin.QZonePluginManager.1
 * JD-Core Version:    0.7.0.1
 */