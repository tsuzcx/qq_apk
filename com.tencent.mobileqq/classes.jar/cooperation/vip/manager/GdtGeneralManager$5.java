package cooperation.vip.manager;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.util.QQDeviceInfo;
import cooperation.qzone.util.QZLog;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;

class GdtGeneralManager$5
  implements Runnable
{
  GdtGeneralManager$5(GdtGeneralManager paramGdtGeneralManager) {}
  
  public void run()
  {
    try
    {
      if (GdtGeneralManager.a(this.this$0) == null) {
        GdtGeneralManager.a(this.this$0, this.this$0.a());
      }
      if (GdtGeneralManager.a(this.this$0) != null)
      {
        Object localObject2 = QQDeviceInfo.getMAC("35e972");
        String str = QQDeviceInfo.getIMEI("35e972");
        PBStringField localPBStringField = GdtGeneralManager.a(this.this$0).mac;
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localPBStringField.set((String)localObject1);
        localObject2 = GdtGeneralManager.a(this.this$0).imei;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.manager.GdtGeneralManager.5
 * JD-Core Version:    0.7.0.1
 */