import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.AddressItem;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GpsMsg;
import com.tencent.mobileqq.pb.PBInt32Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class sqa
  implements syq<sqc, sqd>
{
  private long jdField_a_of_type_Long;
  private ErrorMessage jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
  private HashMap<String, spx> jdField_a_of_type_JavaUtilHashMap;
  private List<sqc> jdField_a_of_type_JavaUtilList = new ArrayList();
  private sqb jdField_a_of_type_Sqb;
  private HashMap<String, AddressItem> b = new HashMap();
  
  private void b()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      ved.d("Q.qqstory.recommendAlbum.logic.BatchGetPoiListHandler", "handleResult. all request has finish timecost=%s, errorInfo=%s", new Object[] { Long.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long), this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage });
      if (this.jdField_a_of_type_Sqb != null) {
        this.jdField_a_of_type_Sqb.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage, this.b);
      }
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.size() == 0))
    {
      if (this.jdField_a_of_type_Sqb != null) {
        this.jdField_a_of_type_Sqb.a(new ErrorMessage(-1, "BatchGetPoiListHandler no photo"), null);
      }
      return;
    }
    try
    {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      List localList1 = spn.a(this.jdField_a_of_type_JavaUtilHashMap);
      if (localList1.size() == 0)
      {
        if (this.jdField_a_of_type_Sqb != null) {
          this.jdField_a_of_type_Sqb.a(new ErrorMessage(-1, "BatchGetPoiListHandler gps error"), null);
        }
        return;
      }
    }
    finally {}
    int j = localObject.size() / 100;
    int i = j;
    if (localObject.size() % 100 > 0) {
      i = j + 1;
    }
    for (;;)
    {
      if (j < i)
      {
        int m = j * 100;
        if (m + 100 <= localObject.size()) {}
        for (int k = m + 100;; k = localObject.size())
        {
          ved.d("Q.qqstory.recommendAlbum.logic.BatchGetPoiListHandler", "send last batch length=%d", new Object[] { Integer.valueOf(k - m) });
          List localList2 = localObject.subList(m, k);
          sqc localsqc = new sqc();
          localsqc.a(localList2);
          this.jdField_a_of_type_JavaUtilList.add(localsqc);
          syo.a().a(localsqc, this);
          j += 1;
          break;
        }
      }
      ved.d("Q.qqstory.recommendAlbum.logic.BatchGetPoiListHandler", "sendRequest total=%d, batch count=%d", new Object[] { Integer.valueOf(localObject.size()), Integer.valueOf(i) });
      return;
      j = 0;
    }
  }
  
  public void a(@NonNull HashMap<String, spx> paramHashMap)
  {
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
  }
  
  public void a(sqb paramsqb)
  {
    this.jdField_a_of_type_Sqb = paramsqb;
  }
  
  public void a(@NonNull sqc paramsqc, @Nullable sqd paramsqd, @NonNull ErrorMessage paramErrorMessage)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramsqc);
      if ((this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage != null) && (this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()))
      {
        b();
        return;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      if ((paramsqd == null) || (paramErrorMessage.isFail()))
      {
        b();
        return;
      }
    }
    finally {}
    paramErrorMessage = new HashMap(this.jdField_a_of_type_JavaUtilHashMap.size());
    if (paramsqd.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      Iterator localIterator1 = paramsqd.jdField_a_of_type_JavaUtilList.iterator();
      for (;;)
      {
        if (!localIterator1.hasNext()) {
          break label234;
        }
        AddressItem localAddressItem = (AddressItem)localIterator1.next();
        Iterator localIterator2 = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
        if (localIterator2.hasNext())
        {
          spx localspx = (spx)((Map.Entry)localIterator2.next()).getValue();
          if (localspx.jdField_a_of_type_Srd == null) {
            break;
          }
          qqstory_struct.GpsMsg localGpsMsg = localspx.jdField_a_of_type_Srd.a();
          if ((localGpsMsg.lat.get() != localAddressItem.latitude) || (localGpsMsg.lng.get() != localAddressItem.longitude)) {
            break;
          }
          paramErrorMessage.put(localspx.jdField_a_of_type_JavaLangString, localAddressItem);
        }
      }
    }
    label234:
    if (paramsqd.jdField_a_of_type_JavaUtilList.size() != paramsqc.a()) {
      ved.e("Q.qqstory.recommendAlbum.logic.BatchGetPoiListHandler", "handle poi request. request length=%d, rsp length=%d", new Object[] { Integer.valueOf(paramsqc.a()), Integer.valueOf(paramsqd.jdField_a_of_type_JavaUtilList.size()) });
    }
    this.b.putAll(paramErrorMessage);
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sqa
 * JD-Core Version:    0.7.0.1
 */