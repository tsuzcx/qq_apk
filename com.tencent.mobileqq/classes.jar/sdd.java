import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.AddressItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class sdd
  extends scz
{
  public sdd(int paramInt, sdt paramsdt)
  {
    super(2);
    this.jdField_a_of_type_JavaLangString = "Q.qqstory.recommendAlbum.logic.StoryScanManager.recommendAlbum_RecommendAlbumFilter";
    this.jdField_a_of_type_Boolean = false;
    Object localObject = new sdy();
    ((sdy)localObject).a(paramInt);
    ((sdy)localObject).a(paramsdt);
    a((sdu)localObject);
    paramsdt = new sdx();
    localObject = ((scu)sqg.a(30)).c();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        see localsee = (see)((Iterator)localObject).next();
        switch (localsee.a)
        {
        default: 
          break;
        case 2: 
          paramsdt.a(localsee);
          break;
        case 4: 
          paramsdt.b(localsee);
          break;
        case 3: 
          paramsdt.c(localsee);
        }
      }
    }
    paramsdt.a(new sec());
    a(paramsdt);
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    return (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (TextUtils.equals(paramString1, paramString2));
  }
  
  public static boolean a(@NonNull sdf paramsdf, int paramInt)
  {
    Object localObject = paramsdf.a();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      AddressItem localAddressItem = ((sdg)((List)localObject).get(0)).a;
      localObject = ((sdg)((List)localObject).get(((List)localObject).size() - 1)).a;
      if ((localAddressItem == null) || (localObject == null))
      {
        urk.e("Q.qqstory.recommendAlbum.logic.StoryScanManager.recommendAlbum_RecommendAlbumFilter", "initAlbumNameByPOI find no poi item :" + paramsdf);
        paramsdf.b = "";
        return false;
      }
      if ((paramInt <= 5) && (a(localAddressItem.building, ((AddressItem)localObject).building)))
      {
        paramsdf.b = localAddressItem.building;
        return true;
      }
      if ((paramInt <= 4) && (a(localAddressItem.district, ((AddressItem)localObject).district)))
      {
        paramsdf.b = localAddressItem.district;
        return true;
      }
      if ((paramInt <= 3) && (a(localAddressItem.city, ((AddressItem)localObject).city)))
      {
        paramsdf.b = localAddressItem.city;
        return true;
      }
      if ((paramInt <= 2) && (a(localAddressItem.province, ((AddressItem)localObject).province)))
      {
        paramsdf.b = localAddressItem.province;
        return true;
      }
      if ((paramInt <= 1) && (a(localAddressItem.country, ((AddressItem)localObject).country)))
      {
        paramsdf.b = localAddressItem.country;
        return true;
      }
    }
    paramsdf.b = "";
    return false;
  }
  
  protected List<sdg> a()
  {
    urk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.recommendAlbum_RecommendAlbumFilter", "get start Pic list=" + super.a().size());
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = super.a().iterator();
    while (localIterator.hasNext())
    {
      sdg localsdg = (sdg)localIterator.next();
      if (localsdg.a != null) {
        localArrayList.add(localsdg);
      }
    }
    urk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.recommendAlbum_RecommendAlbumFilter", "get end Pic list=" + localArrayList.size());
    return localArrayList;
  }
  
  protected void c(List<sdf> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sdd
 * JD-Core Version:    0.7.0.1
 */