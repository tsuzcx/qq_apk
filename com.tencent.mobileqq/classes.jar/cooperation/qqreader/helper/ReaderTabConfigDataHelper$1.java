package cooperation.qqreader.helper;

import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

class ReaderTabConfigDataHelper$1
  implements INetInfoHandler
{
  ReaderTabConfigDataHelper$1(ReaderTabConfigDataHelper paramReaderTabConfigDataHelper) {}
  
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString) {}
  
  public void onNetNone2Mobile(String paramString)
  {
    ReaderTabConfigDataHelper.a(this.a);
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    ReaderTabConfigDataHelper.a(this.a);
  }
  
  public void onNetWifi2Mobile(String paramString) {}
  
  public void onNetWifi2None() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.helper.ReaderTabConfigDataHelper.1
 * JD-Core Version:    0.7.0.1
 */