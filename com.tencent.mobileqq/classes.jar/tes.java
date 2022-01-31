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

public class tes
  implements tch
{
  public static ter a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private List<tev> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  protected boolean a;
  public ter b;
  private boolean b;
  
  public static ter a()
  {
    return jdField_a_of_type_Ter;
  }
  
  public void a()
  {
    ved.b("LbsManager", "onInit");
  }
  
  public void a(int paramInt)
  {
    c();
    new Handler().postDelayed(new LbsManager.2(this, paramInt), paramInt);
  }
  
  public void a(@NonNull ter paramter, tey paramtey, tex paramtex)
  {
    ved.a("LbsManager", "requestPOIList([lat]%d, [lng]%d, [mars]%d, %s)", Integer.valueOf(paramter.jdField_a_of_type_Int), Integer.valueOf(paramter.b), Integer.valueOf(paramter.c), paramtey);
    WeakReference localWeakReference = new WeakReference(paramtex);
    if (paramtey == null) {
      paramtex = tey.a();
    }
    for (;;)
    {
      ved.b("LbsManager", "requestPoiList");
      paramtey = sxm.a("StorySvc.get_poi_list");
      qqstory_service.ReqGetPOIList localReqGetPOIList = new qqstory_service.ReqGetPOIList();
      if (!TextUtils.isEmpty(paramtex.jdField_a_of_type_JavaLangString)) {
        localReqGetPOIList.start_cookie.set(ByteStringMicro.copyFromUtf8(paramtex.jdField_a_of_type_JavaLangString));
      }
      localReqGetPOIList.coordinate.set(paramter.c);
      localReqGetPOIList.count.set(paramtex.jdField_a_of_type_Int);
      if (!TextUtils.isEmpty(paramtex.jdField_b_of_type_JavaLangString)) {
        localReqGetPOIList.keyword.set(ByteStringMicro.copyFromUtf8(paramtex.jdField_b_of_type_JavaLangString));
      }
      localReqGetPOIList.gps.lat.set(paramter.jdField_a_of_type_Int);
      localReqGetPOIList.gps.lng.set(paramter.b);
      localReqGetPOIList.gps.setHasFlag(true);
      paramter = new Bundle();
      syo.a().a(new tly(paramtey, localReqGetPOIList, paramter), new teu(this, localWeakReference, paramtex));
      return;
      paramtex = paramtey;
      if (!TextUtils.isEmpty(paramtey.jdField_a_of_type_JavaLangString))
      {
        paramtey.jdField_b_of_type_Boolean = false;
        paramtex = paramtey;
      }
    }
  }
  
  public void a(@NonNull tev paramtev)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramtev))
    {
      ved.a("LbsManager", "registerLbsListener:%s", paramtev.getClass().getName());
      this.jdField_a_of_type_JavaUtilList.add(paramtev);
    }
  }
  
  public void a(boolean paramBoolean, ter paramter)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((tev)localIterator.next()).a(paramBoolean, paramter);
    }
  }
  
  public ter b()
  {
    return this.jdField_b_of_type_Ter;
  }
  
  public void b()
  {
    ved.b("LbsManager", "onDestroy");
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void b(@NonNull tev paramtev)
  {
    if (this.jdField_a_of_type_JavaUtilList.contains(paramtev))
    {
      ved.a("LbsManager", "unregisterLbsListener:%s", paramtev.getClass().getName());
      this.jdField_a_of_type_JavaUtilList.remove(paramtev);
    }
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_Boolean)
    {
      ved.d("LbsManager", "is locating..... return directly.");
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        ved.d("LbsManager", "is locating..... return directly.");
        return;
      }
    }
    ved.b("LbsManager", "requestLbs...");
    this.jdField_a_of_type_Boolean = true;
    SosoInterface.a(new tet(this, 0, true, false, 60000L, false, false, "NewStoryTakeVideoActivity"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tes
 * JD-Core Version:    0.7.0.1
 */