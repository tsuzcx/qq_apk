import com.tencent.qphone.base.util.QLog;

class smz
  extends bhit
{
  smz(smy paramsmy) {}
  
  public void a(String paramString)
  {
    smy.a = 1;
    smy.a(this.a);
    QLog.i("QzoneVerticalVideoPluginApk", 1, "QzoneVerticalVideoPluginApk state == STATE_DOWNLOADED onInstallBegin  STATE_PRELOAD_BEGIN sPreloadPluginState = " + smy.a);
  }
  
  public void a(String paramString, float paramFloat, long paramLong) {}
  
  public void a(String paramString, int paramInt)
  {
    smy.a = -1;
    QLog.i("QzoneVerticalVideoPluginApk", 1, "QzoneVerticalVideoPluginApk state == STATE_DOWNLOADED onInstallError  STATE_PRELOAD_ERR sPreloadPluginState = " + smy.a);
  }
  
  public void b(String paramString)
  {
    smy.a = 2;
    smy.a(this.a);
    QLog.i("QzoneVerticalVideoPluginApk", 1, "QzoneVerticalVideoPluginApk state == STATE_DOWNLOADED onInstallFinish  STATE_PRELOAD_FINISH sPreloadPluginState = " + smy.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     smz
 * JD-Core Version:    0.7.0.1
 */