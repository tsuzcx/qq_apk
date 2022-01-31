import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.AddressItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class spw
  extends sps
{
  public spw(int paramInt, sqm paramsqm)
  {
    super(2);
    this.jdField_a_of_type_JavaLangString = "Q.qqstory.recommendAlbum.logic.StoryScanManager.recommendAlbum_RecommendAlbumFilter";
    this.jdField_a_of_type_Boolean = false;
    Object localObject = new sqr();
    ((sqr)localObject).a(paramInt);
    ((sqr)localObject).a(paramsqm);
    a((sqn)localObject);
    paramsqm = new sqq();
    localObject = ((spn)tcz.a(30)).c();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        sqx localsqx = (sqx)((Iterator)localObject).next();
        switch (localsqx.a)
        {
        default: 
          break;
        case 2: 
          paramsqm.a(localsqx);
          break;
        case 4: 
          paramsqm.b(localsqx);
          break;
        case 3: 
          paramsqm.c(localsqx);
        }
      }
    }
    paramsqm.a(new sqv());
    a(paramsqm);
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    return (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (TextUtils.equals(paramString1, paramString2));
  }
  
  public static boolean a(@NonNull spy paramspy, int paramInt)
  {
    Object localObject = paramspy.a();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      AddressItem localAddressItem = ((spz)((List)localObject).get(0)).a;
      localObject = ((spz)((List)localObject).get(((List)localObject).size() - 1)).a;
      if ((localAddressItem == null) || (localObject == null))
      {
        ved.e("Q.qqstory.recommendAlbum.logic.StoryScanManager.recommendAlbum_RecommendAlbumFilter", "initAlbumNameByPOI find no poi item :" + paramspy);
        paramspy.b = "";
        return false;
      }
      if ((paramInt <= 5) && (a(localAddressItem.building, ((AddressItem)localObject).building)))
      {
        paramspy.b = localAddressItem.building;
        return true;
      }
      if ((paramInt <= 4) && (a(localAddressItem.district, ((AddressItem)localObject).district)))
      {
        paramspy.b = localAddressItem.district;
        return true;
      }
      if ((paramInt <= 3) && (a(localAddressItem.city, ((AddressItem)localObject).city)))
      {
        paramspy.b = localAddressItem.city;
        return true;
      }
      if ((paramInt <= 2) && (a(localAddressItem.province, ((AddressItem)localObject).province)))
      {
        paramspy.b = localAddressItem.province;
        return true;
      }
      if ((paramInt <= 1) && (a(localAddressItem.country, ((AddressItem)localObject).country)))
      {
        paramspy.b = localAddressItem.country;
        return true;
      }
    }
    paramspy.b = "";
    return false;
  }
  
  protected List<spz> a()
  {
    ved.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.recommendAlbum_RecommendAlbumFilter", "get start Pic list=" + super.a().size());
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = super.a().iterator();
    while (localIterator.hasNext())
    {
      spz localspz = (spz)localIterator.next();
      if (localspz.a != null) {
        localArrayList.add(localspz);
      }
    }
    ved.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.recommendAlbum_RecommendAlbumFilter", "get end Pic list=" + localArrayList.size());
    return localArrayList;
  }
  
  protected void c(List<spy> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     spw
 * JD-Core Version:    0.7.0.1
 */