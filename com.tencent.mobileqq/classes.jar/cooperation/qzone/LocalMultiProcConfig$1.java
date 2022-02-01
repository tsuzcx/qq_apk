package cooperation.qzone;

final class LocalMultiProcConfig$1
  implements Runnable
{
  LocalMultiProcConfig$1(String paramString1, String paramString2, boolean paramBoolean) {}
  
  public void run()
  {
    LocalMultiProcConfig.putBool(this.val$prefName, this.val$key, this.val$value);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.LocalMultiProcConfig.1
 * JD-Core Version:    0.7.0.1
 */