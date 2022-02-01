package dov.com.qq.im.ae.download.old;

public class AEOldShortVideoResManager$ConfigSession
{
  volatile int a = 0;
  int b;
  int c = 0;
  int d;
  
  String a()
  {
    int i = this.a;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return "UNKNOWN_STATUS";
        }
        return "CONFIG_SEND_REQ";
      }
      return "CONFIG_START_SERVLET";
    }
    return "CONFIG_REQUEST_OK";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     dov.com.qq.im.ae.download.old.AEOldShortVideoResManager.ConfigSession
 * JD-Core Version:    0.7.0.1
 */