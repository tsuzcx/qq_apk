package cooperation.qqreader.shadow;

import com.tencent.mobileqq.intervideo.CdnPmUpdater;
import com.tencent.shadow.dynamic.host.PluginManagerUpdater;
import java.io.File;
import java.util.concurrent.Future;

public class ReaderStablePmUpdater
  implements PluginManagerUpdater
{
  private CdnPmUpdater jdField_a_of_type_ComTencentMobileqqIntervideoCdnPmUpdater;
  private File jdField_a_of_type_JavaIoFile;
  
  public ReaderStablePmUpdater(CdnPmUpdater paramCdnPmUpdater, File paramFile)
  {
    this.jdField_a_of_type_ComTencentMobileqqIntervideoCdnPmUpdater = paramCdnPmUpdater;
    this.jdField_a_of_type_JavaIoFile = paramFile;
  }
  
  public File getLatest()
  {
    return this.jdField_a_of_type_JavaIoFile;
  }
  
  public Future isAvailable(File paramFile)
  {
    return this.jdField_a_of_type_ComTencentMobileqqIntervideoCdnPmUpdater.isAvailable(paramFile);
  }
  
  public Future update()
  {
    return this.jdField_a_of_type_ComTencentMobileqqIntervideoCdnPmUpdater.update();
  }
  
  public boolean wasUpdating()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.shadow.ReaderStablePmUpdater
 * JD-Core Version:    0.7.0.1
 */