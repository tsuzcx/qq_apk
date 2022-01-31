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

public class tev
  implements tck
{
  public static teu a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private List<tey> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  protected boolean a;
  public teu b;
  private boolean b;
  
  public static teu a()
  {
    return jdField_a_of_type_Teu;
  }
  
  public void a()
  {
    veg.b("LbsManager", "onInit");
  }
  
  public void a(int paramInt)
  {
    c();
    new Handler().postDelayed(new LbsManager.2(this, paramInt), paramInt);
  }
  
  public void a(@NonNull teu paramteu, tfb paramtfb, tfa paramtfa)
  {
    veg.a("LbsManager", "requestPOIList([lat]%d, [lng]%d, [mars]%d, %s)", Integer.valueOf(paramteu.jdField_a_of_type_Int), Integer.valueOf(paramteu.b), Integer.valueOf(paramteu.c), paramtfb);
    WeakReference localWeakReference = new WeakReference(paramtfa);
    if (paramtfb == null) {
      paramtfa = tfb.a();
    }
    for (;;)
    {
      veg.b("LbsManager", "requestPoiList");
      paramtfb = sxp.a("StorySvc.get_poi_list");
      qqstory_service.ReqGetPOIList localReqGetPOIList = new qqstory_service.ReqGetPOIList();
      if (!TextUtils.isEmpty(paramtfa.jdField_a_of_type_JavaLangString)) {
        localReqGetPOIList.start_cookie.set(ByteStringMicro.copyFromUtf8(paramtfa.jdField_a_of_type_JavaLangString));
      }
      localReqGetPOIList.coordinate.set(paramteu.c);
      localReqGetPOIList.count.set(paramtfa.jdField_a_of_type_Int);
      if (!TextUtils.isEmpty(paramtfa.jdField_b_of_type_JavaLangString)) {
        localReqGetPOIList.keyword.set(ByteStringMicro.copyFromUtf8(paramtfa.jdField_b_of_type_JavaLangString));
      }
      localReqGetPOIList.gps.lat.set(paramteu.jdField_a_of_type_Int);
      localReqGetPOIList.gps.lng.set(paramteu.b);
      localReqGetPOIList.gps.setHasFlag(true);
      paramteu = new Bundle();
      syr.a().a(new tmb(paramtfb, localReqGetPOIList, paramteu), new tex(this, localWeakReference, paramtfa));
      return;
      paramtfa = paramtfb;
      if (!TextUtils.isEmpty(paramtfb.jdField_a_of_type_JavaLangString))
      {
        paramtfb.jdField_b_of_type_Boolean = false;
        paramtfa = paramtfb;
      }
    }
  }
  
  public void a(@NonNull tey paramtey)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramtey))
    {
      veg.a("LbsManager", "registerLbsListener:%s", paramtey.getClass().getName());
      this.jdField_a_of_type_JavaUtilList.add(paramtey);
    }
  }
  
  public void a(boolean paramBoolean, teu paramteu)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((tey)localIterator.next()).a(paramBoolean, paramteu);
    }
  }
  
  public teu b()
  {
    return this.jdField_b_of_type_Teu;
  }
  
  public void b()
  {
    veg.b("LbsManager", "onDestroy");
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void b(@NonNull tey paramtey)
  {
    if (this.jdField_a_of_type_JavaUtilList.contains(paramtey))
    {
      veg.a("LbsManager", "unregisterLbsListener:%s", paramtey.getClass().getName());
      this.jdField_a_of_type_JavaUtilList.remove(paramtey);
    }
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_Boolean)
    {
      veg.d("LbsManager", "is locating..... return directly.");
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        veg.d("LbsManager", "is locating..... return directly.");
        return;
      }
    }
    veg.b("LbsManager", "requestLbs...");
    this.jdField_a_of_type_Boolean = true;
    SosoInterface.a(new tew(this, 0, true, false, 60000L, false, false, "NewStoryTakeVideoActivity"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tev
 * JD-Core Version:    0.7.0.1
 */