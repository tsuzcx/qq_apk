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

public class sdl
  implements slx<sdn, sdo>
{
  private HashMap<String, sde> jdField_a_of_type_JavaUtilHashMap;
  private sdm jdField_a_of_type_Sdm;
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.size() == 0)) {
      if (this.jdField_a_of_type_Sdm != null) {
        this.jdField_a_of_type_Sdm.a(new ErrorMessage(-1, "CheckBlackGeoHashHandler no photo"), null);
      }
    }
    List localList;
    do
    {
      return;
      localList = scu.a(this.jdField_a_of_type_JavaUtilHashMap);
      if (localList.size() != 0) {
        break;
      }
    } while (this.jdField_a_of_type_Sdm == null);
    this.jdField_a_of_type_Sdm.a(new ErrorMessage(-1, "CheckBlackGeoHashHandler gps error " + this.jdField_a_of_type_JavaUtilHashMap.toString()), null);
    return;
    sdn localsdn = new sdn();
    localsdn.a(localList);
    slv.a().a(localsdn, this);
  }
  
  public void a(@NonNull HashMap<String, sde> paramHashMap)
  {
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
  }
  
  public void a(sdm paramsdm)
  {
    this.jdField_a_of_type_Sdm = paramsdm;
  }
  
  public void a(@NonNull sdn paramsdn, @Nullable sdo paramsdo, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramsdo == null) || (paramErrorMessage.isFail())) {
      if (this.jdField_a_of_type_Sdm != null) {
        this.jdField_a_of_type_Sdm.a(paramErrorMessage, null);
      }
    }
    label202:
    do
    {
      return;
      paramsdn = new ArrayList();
      if ((paramsdo.a != null) && (paramsdo.a.size() > 0))
      {
        paramsdo = paramsdo.a.iterator();
        for (;;)
        {
          if (!paramsdo.hasNext()) {
            break label202;
          }
          qqstory_struct.GpsMsg localGpsMsg1 = (qqstory_struct.GpsMsg)paramsdo.next();
          Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
          if (localIterator.hasNext())
          {
            sde localsde = (sde)((Map.Entry)localIterator.next()).getValue();
            if (localsde.jdField_a_of_type_Sek == null) {
              break;
            }
            qqstory_struct.GpsMsg localGpsMsg2 = localsde.jdField_a_of_type_Sek.a();
            if ((localGpsMsg2.lat.get() != localGpsMsg1.lat.get()) || (localGpsMsg2.lng.get() != localGpsMsg1.lng.get())) {
              break;
            }
            paramsdn.add(localsde.jdField_a_of_type_JavaLangString);
          }
        }
      }
    } while (this.jdField_a_of_type_Sdm == null);
    this.jdField_a_of_type_Sdm.a(paramErrorMessage, paramsdn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sdl
 * JD-Core Version:    0.7.0.1
 */