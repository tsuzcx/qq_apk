import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.AddressItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class sql
  extends JobSegment<List<spz>, List<spz>>
  implements sqb, sqf
{
  private HashMap<String, spx> jdField_a_of_type_JavaUtilHashMap;
  private sqm jdField_a_of_type_Sqm;
  
  public sql(sqm paramsqm)
  {
    this.jdField_a_of_type_Sqm = paramsqm;
  }
  
  public void a(ErrorMessage paramErrorMessage, HashMap<String, AddressItem> paramHashMap)
  {
    ved.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.PreProcessSegment", "handlePOIResult errorMessage=%s", new Object[] { paramErrorMessage.toString() });
    if (paramErrorMessage.isFail())
    {
      notifyError(new ErrorMessage(paramErrorMessage.errorCode, "request POI list error:" + paramErrorMessage.getErrorMessage()));
      return;
    }
    Object localObject;
    if ((paramHashMap != null) && (paramHashMap.size() > 0))
    {
      paramErrorMessage = paramHashMap.entrySet().iterator();
      while (paramErrorMessage.hasNext())
      {
        paramHashMap = (Map.Entry)paramErrorMessage.next();
        localObject = (String)paramHashMap.getKey();
        paramHashMap = (AddressItem)paramHashMap.getValue();
        localObject = (spx)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
        ((spx)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem = paramHashMap;
        localObject = ((spx)localObject).jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((spz)((Iterator)localObject).next()).jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem = paramHashMap;
        }
      }
    }
    paramErrorMessage = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      paramHashMap = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        localObject = (spx)((Map.Entry)paramHashMap.next()).getValue();
        paramErrorMessage.addAll(((spx)localObject).jdField_a_of_type_JavaUtilList);
        if (((spz)((spx)localObject).jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem == null) {
          ved.e("Q.qqstory.recommendAlbum.logic.StoryScanManager.PreProcessSegment", "后台返回的POI数据里缺少了 ：" + ((spx)localObject).jdField_a_of_type_Srd);
        }
      }
    }
    ved.a("Q.qqstory.recommendAlbum.logic.StoryScanManager.PreProcessSegment", "this segment is finish  : result=%s", paramErrorMessage);
    notifyResult(paramErrorMessage);
  }
  
  public void a(ErrorMessage paramErrorMessage, List<String> paramList)
  {
    String str = paramErrorMessage.toString();
    if (paramList == null) {}
    for (int i = 0;; i = paramList.size())
    {
      ved.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.PreProcessSegment", "handleBlackResult errorMessage=%s, blackGeohash count=%d", new Object[] { str, Integer.valueOf(i) });
      if (!paramErrorMessage.isFail()) {
        break;
      }
      notifyError(new ErrorMessage(paramErrorMessage.errorCode, "request black list error:" + paramErrorMessage.getErrorMessage()));
      return;
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramErrorMessage = paramList.iterator();
      while (paramErrorMessage.hasNext())
      {
        paramList = (String)paramErrorMessage.next();
        this.jdField_a_of_type_JavaUtilHashMap.remove(paramList);
      }
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.size() == 0)
    {
      notifyResult(new ArrayList());
      return;
    }
    if ((this.jdField_a_of_type_JavaUtilHashMap.size() == 1) && (this.jdField_a_of_type_JavaUtilHashMap.get("EMPTY") != null))
    {
      a(new ErrorMessage(), null);
      return;
    }
    paramErrorMessage = new sqa();
    paramErrorMessage.a(this.jdField_a_of_type_JavaUtilHashMap);
    paramErrorMessage.a(this);
    paramErrorMessage.a();
    ved.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.PreProcessSegment", "sendPOIRequest total count:%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilHashMap.size()) });
  }
  
  protected void a(JobContext paramJobContext, List<spz> paramList)
  {
    ved.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.PreProcessSegment", "start PreProcessSegment piccount=%d", new Object[] { Integer.valueOf(paramList.size()) });
    if (paramList.isEmpty())
    {
      notifyResult(paramList);
      return;
    }
    int i = ((spn)tcz.a(30)).a().b();
    ved.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.PreProcessSegment", "PreProcessSegment geohashlevel=%d", new Object[] { Integer.valueOf(i) });
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    paramJobContext = paramList.iterator();
    while (paramJobContext.hasNext())
    {
      paramList = (spz)paramJobContext.next();
      if ((paramList.jdField_a_of_type_Double == 0.0D) && (paramList.b == 0.0D)) {}
      for (paramList.c = "EMPTY";; paramList.c = src.a(paramList.jdField_a_of_type_Double, paramList.b, i))
      {
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramList.c)) {
          break label192;
        }
        ((spx)this.jdField_a_of_type_JavaUtilHashMap.get(paramList.c)).jdField_a_of_type_JavaUtilList.add(paramList);
        break;
      }
      label192:
      spx localspx = new spx(paramList.c);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramList);
      localspx.jdField_a_of_type_JavaUtilList = localArrayList;
      if ((!TextUtils.isEmpty(localspx.jdField_a_of_type_JavaLangString)) && (!TextUtils.equals(localspx.jdField_a_of_type_JavaLangString, "EMPTY"))) {
        localspx.jdField_a_of_type_Srd = src.a(localspx.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramList.c, localspx);
    }
    ved.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.PreProcessSegment", "group by geohash count:%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilHashMap.size()) });
    if ((this.jdField_a_of_type_JavaUtilHashMap.size() == 1) && (this.jdField_a_of_type_JavaUtilHashMap.get("EMPTY") != null))
    {
      a(new ErrorMessage(), null);
      return;
    }
    paramJobContext = new sqe();
    paramJobContext.a(this.jdField_a_of_type_JavaUtilHashMap);
    paramJobContext.a(this);
    paramJobContext.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sql
 * JD-Core Version:    0.7.0.1
 */