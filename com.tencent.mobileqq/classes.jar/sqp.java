import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class sqp
  extends sqn<sqx>
{
  public sqp()
  {
    a(new sqx());
  }
  
  private List<spy> a(sra paramsra, int paramInt1, int paramInt2)
  {
    if (((paramInt1 != -1) && (paramsra.jdField_a_of_type_Srb.jdField_a_of_type_Int >= paramInt1)) || (paramsra.jdField_a_of_type_JavaUtilList.size() <= 0))
    {
      if (paramsra.a() >= ((sqx)a()).b)
      {
        localObject1 = new spy(((sqx)a()).jdField_a_of_type_Int);
        ((spy)localObject1).a(this.a);
        ((spy)localObject1).d = paramsra.jdField_a_of_type_Srb.jdField_a_of_type_JavaLangString;
        ((spy)localObject1).jdField_a_of_type_JavaUtilList = new ArrayList();
        localObject2 = paramsra.a().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (sra)((Iterator)localObject2).next();
          ((spy)localObject1).jdField_a_of_type_JavaUtilList.add(((sra)localObject3).jdField_a_of_type_Srb.jdField_a_of_type_JavaLangString);
        }
        paramsra.a();
        ved.a("Q.qqstory.recommendAlbum.logic_GeoHashSplitStrategy", "find leaf album=%s", localObject1);
        paramsra = new ArrayList(1);
        paramsra.add(localObject1);
        return paramsra;
      }
      return null;
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = new ArrayList();
    Object localObject3 = paramsra.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    Object localObject4;
    Object localObject5;
    if (((Iterator)localObject3).hasNext())
    {
      localObject4 = (sra)((Iterator)localObject3).next();
      localObject5 = a((sra)localObject4, paramInt1, paramInt2);
      if ((localObject5 != null) && (((List)localObject5).size() > 0)) {
        ((List)localObject1).addAll((Collection)localObject5);
      }
      for (;;)
      {
        break;
        ((ArrayList)localObject2).add(localObject4);
        i = ((sra)localObject4).a() + i;
      }
    }
    if ((((ArrayList)localObject2).size() > 0) && (i >= ((sqx)a()).b) && (paramsra.jdField_a_of_type_Srb.jdField_a_of_type_Int >= paramInt2))
    {
      localObject3 = new spy(((sqx)a()).jdField_a_of_type_Int);
      ((spy)localObject3).a(this.a);
      ((spy)localObject3).d = paramsra.jdField_a_of_type_Srb.jdField_a_of_type_JavaLangString;
      ((spy)localObject3).jdField_a_of_type_JavaUtilList = new ArrayList();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = ((sra)((Iterator)localObject2).next()).a().iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (sra)((Iterator)localObject4).next();
          ((spy)localObject3).jdField_a_of_type_JavaUtilList.add(((sra)localObject5).jdField_a_of_type_Srb.jdField_a_of_type_JavaLangString);
        }
      }
      paramsra.a();
      ved.a("Q.qqstory.recommendAlbum.logic_GeoHashSplitStrategy", "find children album=%s", localObject3);
      ((List)localObject1).add(localObject3);
    }
    return localObject1;
  }
  
  private sqz a(HashMap<String, List<spz>> paramHashMap)
  {
    paramHashMap = new sqz(paramHashMap);
    paramHashMap.a();
    return paramHashMap;
  }
  
  protected List<spy> a(List<spz> paramList)
  {
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    Object localObject1;
    Object localObject2;
    while (paramList.hasNext())
    {
      localObject1 = (spz)paramList.next();
      if (localHashMap.containsKey(((spz)localObject1).c))
      {
        ((List)localHashMap.get(((spz)localObject1).c)).add(localObject1);
      }
      else
      {
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).add(localObject1);
        localHashMap.put(((spz)localObject1).c, localObject2);
      }
    }
    paramList = a(localHashMap);
    ved.b("Q.qqstory.recommendAlbum.logic_GeoHashSplitStrategy", "start findAlbums node=%s, minGatherLevel=%d, maxGatherLevel=%s", paramList.a(), Integer.valueOf(((sqx)a()).d), Integer.valueOf(((sqx)a()).e));
    paramList = a(paramList.a(), ((sqx)a()).d, ((sqx)a()).e);
    if (paramList != null)
    {
      localObject1 = paramList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (spy)((Iterator)localObject1).next();
        if ((((spy)localObject2).jdField_a_of_type_JavaUtilList == null) || (((spy)localObject2).jdField_a_of_type_JavaUtilList.size() == 0))
        {
          ved.e("Q.qqstory.recommendAlbum.logic_GeoHashSplitStrategy", "check why? album:" + localObject2);
          vxp.a("check why? album:", new Object[0]);
        }
        else
        {
          ArrayList localArrayList = new ArrayList();
          Iterator localIterator = ((spy)localObject2).jdField_a_of_type_JavaUtilList.iterator();
          while (localIterator.hasNext()) {
            localArrayList.addAll((Collection)localHashMap.get((String)localIterator.next()));
          }
          ((spy)localObject2).a(localArrayList);
          ((spy)localObject2).a(a());
        }
      }
    }
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sqp
 * JD-Core Version:    0.7.0.1
 */