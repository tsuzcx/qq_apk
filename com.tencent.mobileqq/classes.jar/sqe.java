import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GpsMsg;
import com.tencent.mobileqq.pb.PBInt32Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class sqe
  implements syq<sqg, sqh>
{
  private HashMap<String, spx> jdField_a_of_type_JavaUtilHashMap;
  private sqf jdField_a_of_type_Sqf;
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.size() == 0)) {
      if (this.jdField_a_of_type_Sqf != null) {
        this.jdField_a_of_type_Sqf.a(new ErrorMessage(-1, "CheckBlackGeoHashHandler no photo"), null);
      }
    }
    List localList;
    do
    {
      return;
      localList = spn.a(this.jdField_a_of_type_JavaUtilHashMap);
      if (localList.size() != 0) {
        break;
      }
    } while (this.jdField_a_of_type_Sqf == null);
    this.jdField_a_of_type_Sqf.a(new ErrorMessage(-1, "CheckBlackGeoHashHandler gps error " + this.jdField_a_of_type_JavaUtilHashMap.toString()), null);
    return;
    sqg localsqg = new sqg();
    localsqg.a(localList);
    syo.a().a(localsqg, this);
  }
  
  public void a(@NonNull HashMap<String, spx> paramHashMap)
  {
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
  }
  
  public void a(sqf paramsqf)
  {
    this.jdField_a_of_type_Sqf = paramsqf;
  }
  
  public void a(@NonNull sqg paramsqg, @Nullable sqh paramsqh, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramsqh == null) || (paramErrorMessage.isFail())) {
      if (this.jdField_a_of_type_Sqf != null) {
        this.jdField_a_of_type_Sqf.a(paramErrorMessage, null);
      }
    }
    label202:
    do
    {
      return;
      paramsqg = new ArrayList();
      if ((paramsqh.a != null) && (paramsqh.a.size() > 0))
      {
        paramsqh = paramsqh.a.iterator();
        for (;;)
        {
          if (!paramsqh.hasNext()) {
            break label202;
          }
          qqstory_struct.GpsMsg localGpsMsg1 = (qqstory_struct.GpsMsg)paramsqh.next();
          Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
          if (localIterator.hasNext())
          {
            spx localspx = (spx)((Map.Entry)localIterator.next()).getValue();
            if (localspx.jdField_a_of_type_Srd == null) {
              break;
            }
            qqstory_struct.GpsMsg localGpsMsg2 = localspx.jdField_a_of_type_Srd.a();
            if ((localGpsMsg2.lat.get() != localGpsMsg1.lat.get()) || (localGpsMsg2.lng.get() != localGpsMsg1.lng.get())) {
              break;
            }
            paramsqg.add(localspx.jdField_a_of_type_JavaLangString);
          }
        }
      }
    } while (this.jdField_a_of_type_Sqf == null);
    this.jdField_a_of_type_Sqf.a(paramErrorMessage, paramsqg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sqe
 * JD-Core Version:    0.7.0.1
 */