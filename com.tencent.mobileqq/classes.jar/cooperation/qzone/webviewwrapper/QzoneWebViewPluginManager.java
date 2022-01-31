package cooperation.qzone.webviewwrapper;

import com.tencent.common.app.BaseApplicationImpl;

public class QzoneWebViewPluginManager
{
  private static QzoneWebViewPluginManager jdField_a_of_type_CooperationQzoneWebviewwrapperQzoneWebViewPluginManager;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private QzoneWebViewRuntime jdField_a_of_type_CooperationQzoneWebviewwrapperQzoneWebViewRuntime;
  
  public static QzoneWebViewPluginManager a()
  {
    if (jdField_a_of_type_CooperationQzoneWebviewwrapperQzoneWebViewPluginManager == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_CooperationQzoneWebviewwrapperQzoneWebViewPluginManager == null) {
        jdField_a_of_type_CooperationQzoneWebviewwrapperQzoneWebViewPluginManager = new QzoneWebViewPluginManager();
      }
      return jdField_a_of_type_CooperationQzoneWebviewwrapperQzoneWebViewPluginManager;
    }
  }
  
  public QzoneWebViewRuntime a()
  {
    if (this.jdField_a_of_type_CooperationQzoneWebviewwrapperQzoneWebViewRuntime == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_CooperationQzoneWebviewwrapperQzoneWebViewRuntime == null)
      {
        QzoneWebViewRuntime localQzoneWebViewRuntime = new QzoneWebViewRuntime(BaseApplicationImpl.getApplication(), "qzonelive");
        localQzoneWebViewRuntime.onCreate(null);
        this.jdField_a_of_type_CooperationQzoneWebviewwrapperQzoneWebViewRuntime = localQzoneWebViewRuntime;
      }
      return this.jdField_a_of_type_CooperationQzoneWebviewwrapperQzoneWebViewRuntime;
    }
  }
  
  public void a(QzoneWebViewRuntime paramQzoneWebViewRuntime)
  {
    this.jdField_a_of_type_CooperationQzoneWebviewwrapperQzoneWebViewRuntime = paramQzoneWebViewRuntime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.webviewwrapper.QzoneWebViewPluginManager
 * JD-Core Version:    0.7.0.1
 */