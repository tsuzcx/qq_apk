package dov.com.qq.im.ae.camera.ui.dashboard;

import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.ttpic.openapi.initializer.Feature;
import dov.com.qq.im.ae.util.AECameraPrefsUtil;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.os.MqqHandler;

public class AEDashboardUtil
{
  private static final MutableLiveData<AEDashboardUtil.NetInfo> jdField_a_of_type_AndroidArchLifecycleMutableLiveData;
  public static final AEDashboardUtil.ResolutionInfo a;
  private static final List<Feature> jdField_a_of_type_JavaUtilList;
  private static final List<Pair<String, Integer>> b;
  private static final List<AEDashboardUtil.NetInfo> c;
  
  static
  {
    jdField_a_of_type_DovComQqImAeCameraUiDashboardAEDashboardUtil$ResolutionInfo = new AEDashboardUtil.ResolutionInfo();
    jdField_a_of_type_JavaUtilList = new LinkedList();
    b = new LinkedList();
    c = new LinkedList();
    jdField_a_of_type_AndroidArchLifecycleMutableLiveData = new MutableLiveData();
    if (a())
    {
      a();
      b();
      c();
    }
  }
  
  public static MutableLiveData<AEDashboardUtil.NetInfo> a()
  {
    return jdField_a_of_type_AndroidArchLifecycleMutableLiveData;
  }
  
  public static List<AEDashboardUtil.NetInfo> a(@Nullable AEDashboardUtil.NetInfo paramNetInfo)
  {
    LinkedList localLinkedList = new LinkedList(c);
    if ((paramNetInfo == null) || (TextUtils.isEmpty(paramNetInfo.jdField_a_of_type_JavaLangString))) {
      return localLinkedList;
    }
    Iterator localIterator = localLinkedList.iterator();
    while (localIterator.hasNext())
    {
      AEDashboardUtil.NetInfo localNetInfo = (AEDashboardUtil.NetInfo)localIterator.next();
      if ((localNetInfo != null) && (!TextUtils.isEmpty(localNetInfo.jdField_a_of_type_JavaLangString)) && (localNetInfo.jdField_a_of_type_JavaLangString.equals(paramNetInfo.jdField_a_of_type_JavaLangString)))
      {
        localNetInfo.b = paramNetInfo.b;
        localNetInfo.c = paramNetInfo.c;
      }
    }
    return localLinkedList;
  }
  
  private static void a() {}
  
  public static void a(@Nullable AEVideoStoryDashboardPart.IDebugInfoCallback paramIDebugInfoCallback, long paramLong)
  {
    ThreadManager.getUIHandler().postDelayed(new AEDashboardUtil.1(paramIDebugInfoCallback), paramLong);
  }
  
  public static boolean a()
  {
    return false;
  }
  
  private static void b()
  {
    b.add(new Pair("app_alg_entrance_qzone_id_from833", Integer.valueOf(4)));
    b.add(new Pair("app_ui_playshow_ad_id", Integer.valueOf(4)));
  }
  
  private static void b(@Nullable AEVideoStoryDashboardPart.IDebugInfoCallback paramIDebugInfoCallback)
  {
    ThreadManager.excute(new AEDashboardUtil.2(paramIDebugInfoCallback), 64, null, true);
  }
  
  private static void b(@Nullable AEVideoStoryDashboardPart.IDebugInfoCallback paramIDebugInfoCallback, @NonNull List<AEDashboardUtil.BinaryInfo> paramList, @NonNull List<AEDashboardUtil.ABTestInfo> paramList1)
  {
    if (paramIDebugInfoCallback == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new AEDashboardUtil.3(paramIDebugInfoCallback, paramList, paramList1));
  }
  
  private static List<AEDashboardUtil.BinaryInfo> c()
  {
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Feature localFeature = (Feature)localIterator.next();
      AEDashboardUtil.BinaryInfo localBinaryInfo = new AEDashboardUtil.BinaryInfo();
      try
      {
        localBinaryInfo.jdField_a_of_type_JavaLangString = localFeature.getName();
        localBinaryInfo.jdField_a_of_type_Boolean = localFeature.isFunctionReady();
        localLinkedList.add(localBinaryInfo);
      }
      catch (Exception localException)
      {
        localBinaryInfo.jdField_a_of_type_Boolean = false;
        localBinaryInfo.b = localException.getMessage();
        localLinkedList.add(localBinaryInfo);
      }
      finally
      {
        localLinkedList.add(localBinaryInfo);
      }
    }
    Collections.sort(localLinkedList, new AEDashboardUtil.4());
    return localLinkedList;
  }
  
  private static void c()
  {
    c.add(new AEDashboardUtil.NetInfo("CameraModuleSvc.GetCameraConfig"));
    c.add(new AEDashboardUtil.NetInfo("CameraModuleSvc.GetCompressedCategoryMaterialV2.MqStoryCamera"));
    c.add(new AEDashboardUtil.NetInfo("CameraModuleSvc.GetCompressedCategoryMaterialV2.MqEmoCamera"));
    c.add(new AEDashboardUtil.NetInfo("CameraModuleSvc.GetCompressedCategoryMaterialV2.MqCircleWatermark"));
    c.add(new AEDashboardUtil.NetInfo("CameraModuleSvc.GetPlayShowCatMatTree"));
  }
  
  private static List<AEDashboardUtil.ABTestInfo> d()
  {
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = b.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      AEDashboardUtil.ABTestInfo localABTestInfo = new AEDashboardUtil.ABTestInfo();
      localABTestInfo.jdField_a_of_type_JavaLangString = ((String)localPair.first);
      localABTestInfo.b = AECameraPrefsUtil.a().a((String)localPair.first, "null", ((Integer)localPair.second).intValue());
      localLinkedList.add(localABTestInfo);
    }
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.dashboard.AEDashboardUtil
 * JD-Core Version:    0.7.0.1
 */