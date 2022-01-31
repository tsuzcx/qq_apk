import com.tencent.qphone.base.util.QLog;

class sag
  extends bfzr
{
  sag(saf paramsaf) {}
  
  public void a(String paramString)
  {
    saf.a = 1;
    saf.a(this.a);
    QLog.i("QzoneVerticalVideoPluginApk", 1, "QzoneVerticalVideoPluginApk state == STATE_DOWNLOADED onInstallBegin  STATE_PRELOAD_BEGIN sPreloadPluginState = " + saf.a);
  }
  
  public void a(String paramString, float paramFloat, long paramLong) {}
  
  public void a(String paramString, int paramInt)
  {
    saf.a = -1;
    QLog.i("QzoneVerticalVideoPluginApk", 1, "QzoneVerticalVideoPluginApk state == STATE_DOWNLOADED onInstallError  STATE_PRELOAD_ERR sPreloadPluginState = " + saf.a);
  }
  
  public void b(String paramString)
  {
    saf.a = 2;
    saf.a(this.a);
    QLog.i("QzoneVerticalVideoPluginApk", 1, "QzoneVerticalVideoPluginApk state == STATE_DOWNLOADED onInstallFinish  STATE_PRELOAD_FINISH sPreloadPluginState = " + saf.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sag
 * JD-Core Version:    0.7.0.1
 */