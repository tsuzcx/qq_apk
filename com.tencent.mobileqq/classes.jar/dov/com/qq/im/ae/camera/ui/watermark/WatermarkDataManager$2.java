package dov.com.qq.im.ae.camera.ui.watermark;

import NS_QQ_STORY_CLIENT.CLIENT.StGetWatermarkDictRsp;
import NS_QQ_STORY_CLIENT.CLIENT.StWatermarkDict;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import dov.com.qq.im.ae.util.AEQLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class WatermarkDataManager$2
  implements VSDispatchObserver.onVSRspCallBack<CLIENT.StGetWatermarkDictRsp>
{
  WatermarkDataManager$2(WatermarkDataManager paramWatermarkDataManager, WatermarkDataManager.IWatermarkDictCallback paramIWatermarkDictCallback) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String arg5, CLIENT.StGetWatermarkDictRsp paramStGetWatermarkDictRsp)
  {
    if (paramBoolean)
    {
      ??? = paramStGetWatermarkDictRsp.vecWatermarkDict.get();
      paramBaseRequest = new HashMap();
      ??? = ???.iterator();
      while (???.hasNext())
      {
        paramStGetWatermarkDictRsp = (CLIENT.StWatermarkDict)???.next();
        paramBaseRequest.put(paramStGetWatermarkDictRsp.key.get(), paramStGetWatermarkDictRsp.value.get());
      }
      AEQLog.b("WaterMarkManager", "GetWatermarkDictRequest [onReceive] watermarkDict.size:" + paramBaseRequest.size());
      synchronized (this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkDataManager)
      {
        WatermarkDataManager.a(this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkDataManager).clear();
        WatermarkDataManager.a(this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkDataManager).putAll(paramBaseRequest);
        WatermarkDataManager.a(this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkDataManager, System.currentTimeMillis());
        this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkDataManager$IWatermarkDictCallback.onGetWatermarkDict(paramBaseRequest);
        return;
      }
    }
    AEQLog.d("WaterMarkManager", "GetWatermarkDictRequest retCode:" + paramLong + " errMSg:" + ???);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.watermark.WatermarkDataManager.2
 * JD-Core Version:    0.7.0.1
 */