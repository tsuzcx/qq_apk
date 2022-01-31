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

public class sqh
  implements syt<sqj, sqk>
{
  private HashMap<String, sqa> jdField_a_of_type_JavaUtilHashMap;
  private sqi jdField_a_of_type_Sqi;
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.size() == 0)) {
      if (this.jdField_a_of_type_Sqi != null) {
        this.jdField_a_of_type_Sqi.a(new ErrorMessage(-1, "CheckBlackGeoHashHandler no photo"), null);
      }
    }
    List localList;
    do
    {
      return;
      localList = spq.a(this.jdField_a_of_type_JavaUtilHashMap);
      if (localList.size() != 0) {
        break;
      }
    } while (this.jdField_a_of_type_Sqi == null);
    this.jdField_a_of_type_Sqi.a(new ErrorMessage(-1, "CheckBlackGeoHashHandler gps error " + this.jdField_a_of_type_JavaUtilHashMap.toString()), null);
    return;
    sqj localsqj = new sqj();
    localsqj.a(localList);
    syr.a().a(localsqj, this);
  }
  
  public void a(@NonNull HashMap<String, sqa> paramHashMap)
  {
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
  }
  
  public void a(sqi paramsqi)
  {
    this.jdField_a_of_type_Sqi = paramsqi;
  }
  
  public void a(@NonNull sqj paramsqj, @Nullable sqk paramsqk, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramsqk == null) || (paramErrorMessage.isFail())) {
      if (this.jdField_a_of_type_Sqi != null) {
        this.jdField_a_of_type_Sqi.a(paramErrorMessage, null);
      }
    }
    label202:
    do
    {
      return;
      paramsqj = new ArrayList();
      if ((paramsqk.a != null) && (paramsqk.a.size() > 0))
      {
        paramsqk = paramsqk.a.iterator();
        for (;;)
        {
          if (!paramsqk.hasNext()) {
            break label202;
          }
          qqstory_struct.GpsMsg localGpsMsg1 = (qqstory_struct.GpsMsg)paramsqk.next();
          Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
          if (localIterator.hasNext())
          {
            sqa localsqa = (sqa)((Map.Entry)localIterator.next()).getValue();
            if (localsqa.jdField_a_of_type_Srg == null) {
              break;
            }
            qqstory_struct.GpsMsg localGpsMsg2 = localsqa.jdField_a_of_type_Srg.a();
            if ((localGpsMsg2.lat.get() != localGpsMsg1.lat.get()) || (localGpsMsg2.lng.get() != localGpsMsg1.lng.get())) {
              break;
            }
            paramsqj.add(localsqa.jdField_a_of_type_JavaLangString);
          }
        }
      }
    } while (this.jdField_a_of_type_Sqi == null);
    this.jdField_a_of_type_Sqi.a(paramErrorMessage, paramsqj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sqh
 * JD-Core Version:    0.7.0.1
 */