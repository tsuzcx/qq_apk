package common.config.service;

public class QzoneLbsConfig
{
  private static volatile QzoneLbsConfig jdField_a_of_type_CommonConfigServiceQzoneLbsConfig = null;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  
  public static QzoneLbsConfig a()
  {
    if (jdField_a_of_type_CommonConfigServiceQzoneLbsConfig == null) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (jdField_a_of_type_CommonConfigServiceQzoneLbsConfig == null) {
          jdField_a_of_type_CommonConfigServiceQzoneLbsConfig = new QzoneLbsConfig();
        }
      }
    }
    return jdField_a_of_type_CommonConfigServiceQzoneLbsConfig;
  }
  
  public int a()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "POICacheDistance", 1000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     common.config.service.QzoneLbsConfig
 * JD-Core Version:    0.7.0.1
 */