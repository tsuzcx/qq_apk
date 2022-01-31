package cooperation.qzone.plugin;

import azly;
import bjkr;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.Properties;

public class QZonePluginDownloadConfig$1
  implements Runnable
{
  public QZonePluginDownloadConfig$1(bjkr parambjkr, String paramString, Properties paramProperties) {}
  
  public void run()
  {
    azly.a(BaseApplicationImpl.getContext()).reportKVEvent(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilProperties);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.plugin.QZonePluginDownloadConfig.1
 * JD-Core Version:    0.7.0.1
 */