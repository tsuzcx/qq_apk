package dov.com.qq.im.ae.download.old;

public class AEOldShortVideoResManager$ConfigSession
{
  volatile int a = 0;
  int b;
  int c = 0;
  int d;
  
  String a()
  {
    switch (this.a)
    {
    default: 
      return "UNKNOWN_STATUS";
    case 0: 
      return "CONFIG_REQUEST_OK";
    case 1: 
      return "CONFIG_START_SERVLET";
    }
    return "CONFIG_SEND_REQ";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.download.old.AEOldShortVideoResManager.ConfigSession
 * JD-Core Version:    0.7.0.1
 */