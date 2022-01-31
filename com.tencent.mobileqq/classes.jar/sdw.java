import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class sdw
  extends sdu<see>
{
  public sdw()
  {
    a(new see());
  }
  
  private List<sdf> a(seh paramseh, int paramInt1, int paramInt2)
  {
    if (((paramInt1 != -1) && (paramseh.jdField_a_of_type_Sei.jdField_a_of_type_Int >= paramInt1)) || (paramseh.jdField_a_of_type_JavaUtilList.size() <= 0))
    {
      if (paramseh.a() >= ((see)a()).b)
      {
        localObject1 = new sdf(((see)a()).jdField_a_of_type_Int);
        ((sdf)localObject1).a(this.a);
        ((sdf)localObject1).d = paramseh.jdField_a_of_type_Sei.jdField_a_of_type_JavaLangString;
        ((sdf)localObject1).jdField_a_of_type_JavaUtilList = new ArrayList();
        localObject2 = paramseh.a().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (seh)((Iterator)localObject2).next();
          ((sdf)localObject1).jdField_a_of_type_JavaUtilList.add(((seh)localObject3).jdField_a_of_type_Sei.jdField_a_of_type_JavaLangString);
        }
        paramseh.a();
        urk.a("Q.qqstory.recommendAlbum.logic_GeoHashSplitStrategy", "find leaf album=%s", localObject1);
        paramseh = new ArrayList(1);
        paramseh.add(localObject1);
        return paramseh;
      }
      return null;
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = new ArrayList();
    Object localObject3 = paramseh.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    Object localObject4;
    Object localObject5;
    if (((Iterator)localObject3).hasNext())
    {
      localObject4 = (seh)((Iterator)localObject3).next();
      localObject5 = a((seh)localObject4, paramInt1, paramInt2);
      if ((localObject5 != null) && (((List)localObject5).size() > 0)) {
        ((List)localObject1).addAll((Collection)localObject5);
      }
      for (;;)
      {
        break;
        ((ArrayList)localObject2).add(localObject4);
        i = ((seh)localObject4).a() + i;
      }
    }
    if ((((ArrayList)localObject2).size() > 0) && (i >= ((see)a()).b) && (paramseh.jdField_a_of_type_Sei.jdField_a_of_type_Int >= paramInt2))
    {
      localObject3 = new sdf(((see)a()).jdField_a_of_type_Int);
      ((sdf)localObject3).a(this.a);
      ((sdf)localObject3).d = paramseh.jdField_a_of_type_Sei.jdField_a_of_type_JavaLangString;
      ((sdf)localObject3).jdField_a_of_type_JavaUtilList = new ArrayList();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = ((seh)((Iterator)localObject2).next()).a().iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (seh)((Iterator)localObject4).next();
          ((sdf)localObject3).jdField_a_of_type_JavaUtilList.add(((seh)localObject5).jdField_a_of_type_Sei.jdField_a_of_type_JavaLangString);
        }
      }
      paramseh.a();
      urk.a("Q.qqstory.recommendAlbum.logic_GeoHashSplitStrategy", "find children album=%s", localObject3);
      ((List)localObject1).add(localObject3);
    }
    return localObject1;
  }
  
  private seg a(HashMap<String, List<sdg>> paramHashMap)
  {
    paramHashMap = new seg(paramHashMap);
    paramHashMap.a();
    return paramHashMap;
  }
  
  protected List<sdf> a(List<sdg> paramList)
  {
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    Object localObject1;
    Object localObject2;
    while (paramList.hasNext())
    {
      localObject1 = (sdg)paramList.next();
      if (localHashMap.containsKey(((sdg)localObject1).c))
      {
        ((List)localHashMap.get(((sdg)localObject1).c)).add(localObject1);
      }
      else
      {
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).add(localObject1);
        localHashMap.put(((sdg)localObject1).c, localObject2);
      }
    }
    paramList = a(localHashMap);
    urk.b("Q.qqstory.recommendAlbum.logic_GeoHashSplitStrategy", "start findAlbums node=%s, minGatherLevel=%d, maxGatherLevel=%s", paramList.a(), Integer.valueOf(((see)a()).d), Integer.valueOf(((see)a()).e));
    paramList = a(paramList.a(), ((see)a()).d, ((see)a()).e);
    if (paramList != null)
    {
      localObject1 = paramList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (sdf)((Iterator)localObject1).next();
        if ((((sdf)localObject2).jdField_a_of_type_JavaUtilList == null) || (((sdf)localObject2).jdField_a_of_type_JavaUtilList.size() == 0))
        {
          urk.e("Q.qqstory.recommendAlbum.logic_GeoHashSplitStrategy", "check why? album:" + localObject2);
          vkw.a("check why? album:", new Object[0]);
        }
        else
        {
          ArrayList localArrayList = new ArrayList();
          Iterator localIterator = ((sdf)localObject2).jdField_a_of_type_JavaUtilList.iterator();
          while (localIterator.hasNext()) {
            localArrayList.addAll((Collection)localHashMap.get((String)localIterator.next()));
          }
          ((sdf)localObject2).a(localArrayList);
          ((sdf)localObject2).a(a());
        }
      }
    }
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sdw
 * JD-Core Version:    0.7.0.1
 */