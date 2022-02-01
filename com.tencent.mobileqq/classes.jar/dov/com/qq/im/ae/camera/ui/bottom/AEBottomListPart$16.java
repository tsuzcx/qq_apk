package dov.com.qq.im.ae.camera.ui.bottom;

import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.data.AEMaterialManager;
import dov.com.qq.im.ae.data.AEMaterialMetaData;
import dov.com.qq.im.ae.data.AEWatermarkMaterialManager;
import dov.com.qq.im.ae.util.AEQLog;
import java.util.List;
import mqq.os.MqqHandler;

class AEBottomListPart$16
  implements Runnable
{
  AEBottomListPart$16(AEBottomListPart paramAEBottomListPart, String paramString) {}
  
  public void run()
  {
    Object localObject = AEWatermarkMaterialManager.a().a();
    localObject = AEBottomListPart.a(this.this$0, this.a, (List)localObject);
    if (localObject != null)
    {
      if (((AEMaterialMetaData)localObject).e)
      {
        ThreadManager.getUIHandler().post(new AEBottomListPart.16.1(this, (AEMaterialMetaData)localObject));
        return;
      }
      this.this$0.a.a(this.this$0.a.getApp(), (AEMaterialMetaData)localObject, new AEBottomListPart.16.2(this, (AEMaterialMetaData)localObject));
      return;
    }
    AEQLog.d("AEBottomListPart", "meta data is null =======");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart.16
 * JD-Core Version:    0.7.0.1
 */