package cooperation.qzone.webviewwrapper;

import com.tencent.common.app.BaseApplicationImpl;

public class QzoneWebViewPluginManager
{
  private static QzoneWebViewPluginManager mInstance;
  private static Object obj = new Object();
  private QzoneWebViewRuntime mApp;
  
  public static QzoneWebViewPluginManager getInstance()
  {
    if (mInstance == null) {
      synchronized (obj)
      {
        if (mInstance == null) {
          mInstance = new QzoneWebViewPluginManager();
        }
      }
    }
    return mInstance;
  }
  
  public QzoneWebViewRuntime getRuntime()
  {
    if (this.mApp == null) {
      synchronized (obj)
      {
        if (this.mApp == null)
        {
          QzoneWebViewRuntime localQzoneWebViewRuntime = new QzoneWebViewRuntime(BaseApplicationImpl.getApplication(), "qzonelive");
          localQzoneWebViewRuntime.onCreate(null);
          this.mApp = localQzoneWebViewRuntime;
        }
      }
    }
    return this.mApp;
  }
  
  public void initApp(QzoneWebViewRuntime paramQzoneWebViewRuntime)
  {
    this.mApp = paramQzoneWebViewRuntime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.webviewwrapper.QzoneWebViewPluginManager
 * JD-Core Version:    0.7.0.1
 */