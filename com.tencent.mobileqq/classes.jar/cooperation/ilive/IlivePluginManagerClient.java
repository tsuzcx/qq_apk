package cooperation.ilive;

import cooperation.qqreader.proxy.ReaderInterfacePluginBuilder;
import cooperation.qqreader.proxy.ReaderJsPluginBuilder;
import java.util.ArrayList;
import java.util.List;
import mqq.util.WeakReference;

public class IlivePluginManagerClient
{
  private long jdField_a_of_type_Long = 0L;
  private ReaderInterfacePluginBuilder jdField_a_of_type_CooperationQqreaderProxyReaderInterfacePluginBuilder = null;
  private ReaderJsPluginBuilder jdField_a_of_type_CooperationQqreaderProxyReaderJsPluginBuilder = null;
  private List<WeakReference<IlivePluginManagerClient.OnPluginReadyListener>> jdField_a_of_type_JavaUtilList = new ArrayList();
  private volatile boolean jdField_a_of_type_Boolean = false;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.ilive.IlivePluginManagerClient
 * JD-Core Version:    0.7.0.1
 */