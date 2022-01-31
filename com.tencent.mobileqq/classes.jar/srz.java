import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.lbs.LbsManager.2;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetPOIList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GpsMsg;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.util.WeakReference;

public class srz
  implements spo
{
  public static sry a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private List<ssc> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  protected boolean a;
  public sry b;
  private boolean b;
  
  public static sry a()
  {
    return jdField_a_of_type_Sry;
  }
  
  public void a()
  {
    urk.b("LbsManager", "onInit");
  }
  
  public void a(int paramInt)
  {
    c();
    new Handler().postDelayed(new LbsManager.2(this, paramInt), paramInt);
  }
  
  public void a(@NonNull sry paramsry, ssf paramssf, sse paramsse)
  {
    urk.a("LbsManager", "requestPOIList([lat]%d, [lng]%d, [mars]%d, %s)", Integer.valueOf(paramsry.jdField_a_of_type_Int), Integer.valueOf(paramsry.b), Integer.valueOf(paramsry.c), paramssf);
    WeakReference localWeakReference = new WeakReference(paramsse);
    if (paramssf == null) {
      paramsse = ssf.a();
    }
    for (;;)
    {
      urk.b("LbsManager", "requestPoiList");
      paramssf = skt.a("StorySvc.get_poi_list");
      qqstory_service.ReqGetPOIList localReqGetPOIList = new qqstory_service.ReqGetPOIList();
      if (!TextUtils.isEmpty(paramsse.jdField_a_of_type_JavaLangString)) {
        localReqGetPOIList.start_cookie.set(ByteStringMicro.copyFromUtf8(paramsse.jdField_a_of_type_JavaLangString));
      }
      localReqGetPOIList.coordinate.set(paramsry.c);
      localReqGetPOIList.count.set(paramsse.jdField_a_of_type_Int);
      if (!TextUtils.isEmpty(paramsse.jdField_b_of_type_JavaLangString)) {
        localReqGetPOIList.keyword.set(ByteStringMicro.copyFromUtf8(paramsse.jdField_b_of_type_JavaLangString));
      }
      localReqGetPOIList.gps.lat.set(paramsry.jdField_a_of_type_Int);
      localReqGetPOIList.gps.lng.set(paramsry.b);
      localReqGetPOIList.gps.setHasFlag(true);
      paramsry = new Bundle();
      slv.a().a(new szf(paramssf, localReqGetPOIList, paramsry), new ssb(this, localWeakReference, paramsse));
      return;
      paramsse = paramssf;
      if (!TextUtils.isEmpty(paramssf.jdField_a_of_type_JavaLangString))
      {
        paramssf.jdField_b_of_type_Boolean = false;
        paramsse = paramssf;
      }
    }
  }
  
  public void a(@NonNull ssc paramssc)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramssc))
    {
      urk.a("LbsManager", "registerLbsListener:%s", paramssc.getClass().getName());
      this.jdField_a_of_type_JavaUtilList.add(paramssc);
    }
  }
  
  public void a(boolean paramBoolean, sry paramsry)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ssc)localIterator.next()).a(paramBoolean, paramsry);
    }
  }
  
  public sry b()
  {
    return this.jdField_b_of_type_Sry;
  }
  
  public void b()
  {
    urk.b("LbsManager", "onDestroy");
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void b(@NonNull ssc paramssc)
  {
    if (this.jdField_a_of_type_JavaUtilList.contains(paramssc))
    {
      urk.a("LbsManager", "unregisterLbsListener:%s", paramssc.getClass().getName());
      this.jdField_a_of_type_JavaUtilList.remove(paramssc);
    }
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_Boolean)
    {
      urk.d("LbsManager", "is locating..... return directly.");
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        urk.d("LbsManager", "is locating..... return directly.");
        return;
      }
    }
    urk.b("LbsManager", "requestLbs...");
    this.jdField_a_of_type_Boolean = true;
    SosoInterface.a(new ssa(this, 0, true, false, 60000L, false, false, "NewStoryTakeVideoActivity"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     srz
 * JD-Core Version:    0.7.0.1
 */