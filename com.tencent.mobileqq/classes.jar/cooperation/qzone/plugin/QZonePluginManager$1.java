package cooperation.qzone.plugin;

import axql;
import bhjf;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.Properties;

public class QZonePluginManager$1
  implements Runnable
{
  public QZonePluginManager$1(bhjf parambhjf, String paramString, int paramInt) {}
  
  public void run()
  {
    Properties localProperties = new Properties();
    localProperties.put("plugin_id", this.jdField_a_of_type_JavaLangString);
    localProperties.put("refer", String.valueOf(this.jdField_a_of_type_Int));
    axql.a(BaseApplicationImpl.getContext()).reportKVEvent("QzonePluginDownloadRefer", localProperties);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.plugin.QZonePluginManager.1
 * JD-Core Version:    0.7.0.1
 */