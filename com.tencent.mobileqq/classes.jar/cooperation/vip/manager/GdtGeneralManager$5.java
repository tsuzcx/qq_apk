package cooperation.vip.manager;

import befc;
import bgqd;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qzone.util.QZLog;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;

public class GdtGeneralManager$5
  implements Runnable
{
  public GdtGeneralManager$5(bgqd parambgqd) {}
  
  public void run()
  {
    try
    {
      if (bgqd.a(this.this$0) == null) {
        bgqd.a(this.this$0, this.this$0.a());
      }
      if (bgqd.a(this.this$0) != null)
      {
        Object localObject2 = befc.c("35e972");
        String str = befc.a("35e972");
        PBStringField localPBStringField = bgqd.a(this.this$0).mac;
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localPBStringField.set((String)localObject1);
        localObject2 = bgqd.a(this.this$0).imei;
        localObject1 = str;
        if (str == null) {
          localObject1 = "";
        }
        ((PBStringField)localObject2).set((String)localObject1);
        return;
      }
      QZLog.i("GdtGeneralManager", "@gdttaid  getDeviceInfo  gdtDeviceInfo is null");
      return;
    }
    catch (Exception localException)
    {
      QZLog.e("GdtGeneralManager", 2, new Object[] { localException.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.vip.manager.GdtGeneralManager.5
 * JD-Core Version:    0.7.0.1
 */