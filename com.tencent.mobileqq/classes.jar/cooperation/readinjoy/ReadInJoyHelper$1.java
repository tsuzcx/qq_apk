package cooperation.readinjoy;

import bkbr;
import com.tencent.ark.open.ArkAppMgr;

public final class ReadInJoyHelper$1
  implements Runnable
{
  public ReadInJoyHelper$1(String paramString1, String paramString2) {}
  
  public void run()
  {
    ArkAppMgr.getInstance().getAppPathByName(this.a, "", this.b, new Object(), new bkbr(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.readinjoy.ReadInJoyHelper.1
 * JD-Core Version:    0.7.0.1
 */