package dov.com.qq.im.ae.camera.ui.watermark;

import NS_COMM.COMM.StCommonExt;
import com.dataline.util.DatalineMathUtil;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.GetWatermarkDictRequest;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import dov.com.qq.im.ae.data.AEMaterialMetaData;
import dov.com.qq.im.ae.util.AEQLog;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;

public class WatermarkDataManager
{
  private static volatile WatermarkDataManager jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkDataManager;
  private final int jdField_a_of_type_Int = 60000;
  private long jdField_a_of_type_Long = 0L;
  private SosoLocation jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLocation;
  private AEMaterialMetaData jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData;
  private final Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public static WatermarkDataManager a()
  {
    if (jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkDataManager == null) {}
    try
    {
      if (jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkDataManager == null) {
        jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkDataManager = new WatermarkDataManager();
      }
      return jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkDataManager;
    }
    finally {}
  }
  
  private void a(double paramDouble1, double paramDouble2, WatermarkDataManager.IWatermarkDictCallback paramIWatermarkDictCallback)
  {
    long l = DatalineMathUtil.a();
    GetWatermarkDictRequest localGetWatermarkDictRequest = new GetWatermarkDictRequest(new COMM.StCommonExt(), paramDouble1, paramDouble2, String.valueOf(l));
    VSNetworkHelper.getInstance().sendRequest(localGetWatermarkDictRequest, new WatermarkDataManager.2(this, paramIWatermarkDictCallback));
  }
  
  /* Error */
  private boolean a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 80	java/lang/System:currentTimeMillis	()J
    //   5: lstore_1
    //   6: aload_0
    //   7: getfield 26	dov/com/qq/im/ae/camera/ui/watermark/WatermarkDataManager:jdField_a_of_type_Long	J
    //   10: lstore_3
    //   11: lload_1
    //   12: lload_3
    //   13: lsub
    //   14: ldc2_w 81
    //   17: lcmp
    //   18: ifgt +11 -> 29
    //   21: iconst_1
    //   22: istore 5
    //   24: aload_0
    //   25: monitorexit
    //   26: iload 5
    //   28: ireturn
    //   29: iconst_0
    //   30: istore 5
    //   32: goto -8 -> 24
    //   35: astore 6
    //   37: aload_0
    //   38: monitorexit
    //   39: aload 6
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	WatermarkDataManager
    //   5	7	1	l1	long
    //   10	3	3	l2	long
    //   22	9	5	bool	boolean
    //   35	5	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	11	35	finally
  }
  
  private void b(WatermarkDataManager.IWatermarkDictCallback paramIWatermarkDictCallback)
  {
    AEQLog.b("WaterMarkManager", "updateWMProps start");
    ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).startLocation(new WatermarkDataManager.1(this, "qq_story_water_mark", false, paramIWatermarkDictCallback));
  }
  
  public SosoLocation a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLocation;
  }
  
  public AEMaterialMetaData a()
  {
    return this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData;
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData = null;
      this.jdField_a_of_type_Long = 0L;
      this.jdField_a_of_type_JavaUtilMap.clear();
      this.jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLocation = null;
      return;
    }
    finally {}
  }
  
  public void a(@Nonnull WatermarkDataManager.IWatermarkDictCallback paramIWatermarkDictCallback)
  {
    try
    {
      if (a())
      {
        paramIWatermarkDictCallback.onGetWatermarkDict(Collections.unmodifiableMap(this.jdField_a_of_type_JavaUtilMap));
        return;
      }
      b(paramIWatermarkDictCallback);
      return;
    }
    finally {}
  }
  
  public void a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData = paramAEMaterialMetaData;
  }
  
  public void a(boolean paramBoolean)
  {
    VSConfigManager.a().a("WM_LIST_CONFIG_CHANGED", Boolean.valueOf(paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.watermark.WatermarkDataManager
 * JD-Core Version:    0.7.0.1
 */