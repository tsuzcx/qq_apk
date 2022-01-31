import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class sqs
  extends sqq<sra>
{
  public sqs()
  {
    a(new sra());
  }
  
  private List<sqb> a(srd paramsrd, int paramInt1, int paramInt2)
  {
    if (((paramInt1 != -1) && (paramsrd.jdField_a_of_type_Sre.jdField_a_of_type_Int >= paramInt1)) || (paramsrd.jdField_a_of_type_JavaUtilList.size() <= 0))
    {
      if (paramsrd.a() >= ((sra)a()).b)
      {
        localObject1 = new sqb(((sra)a()).jdField_a_of_type_Int);
        ((sqb)localObject1).a(this.a);
        ((sqb)localObject1).d = paramsrd.jdField_a_of_type_Sre.jdField_a_of_type_JavaLangString;
        ((sqb)localObject1).jdField_a_of_type_JavaUtilList = new ArrayList();
        localObject2 = paramsrd.a().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (srd)((Iterator)localObject2).next();
          ((sqb)localObject1).jdField_a_of_type_JavaUtilList.add(((srd)localObject3).jdField_a_of_type_Sre.jdField_a_of_type_JavaLangString);
        }
        paramsrd.a();
        veg.a("Q.qqstory.recommendAlbum.logic_GeoHashSplitStrategy", "find leaf album=%s", localObject1);
        paramsrd = new ArrayList(1);
        paramsrd.add(localObject1);
        return paramsrd;
      }
      return null;
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = new ArrayList();
    Object localObject3 = paramsrd.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    Object localObject4;
    Object localObject5;
    if (((Iterator)localObject3).hasNext())
    {
      localObject4 = (srd)((Iterator)localObject3).next();
      localObject5 = a((srd)localObject4, paramInt1, paramInt2);
      if ((localObject5 != null) && (((List)localObject5).size() > 0)) {
        ((List)localObject1).addAll((Collection)localObject5);
      }
      for (;;)
      {
        break;
        ((ArrayList)localObject2).add(localObject4);
        i = ((srd)localObject4).a() + i;
      }
    }
    if ((((ArrayList)localObject2).size() > 0) && (i >= ((sra)a()).b) && (paramsrd.jdField_a_of_type_Sre.jdField_a_of_type_Int >= paramInt2))
    {
      localObject3 = new sqb(((sra)a()).jdField_a_of_type_Int);
      ((sqb)localObject3).a(this.a);
      ((sqb)localObject3).d = paramsrd.jdField_a_of_type_Sre.jdField_a_of_type_JavaLangString;
      ((sqb)localObject3).jdField_a_of_type_JavaUtilList = new ArrayList();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = ((srd)((Iterator)localObject2).next()).a().iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (srd)((Iterator)localObject4).next();
          ((sqb)localObject3).jdField_a_of_type_JavaUtilList.add(((srd)localObject5).jdField_a_of_type_Sre.jdField_a_of_type_JavaLangString);
        }
      }
      paramsrd.a();
      veg.a("Q.qqstory.recommendAlbum.logic_GeoHashSplitStrategy", "find children album=%s", localObject3);
      ((List)localObject1).add(localObject3);
    }
    return localObject1;
  }
  
  private src a(HashMap<String, List<sqc>> paramHashMap)
  {
    paramHashMap = new src(paramHashMap);
    paramHashMap.a();
    return paramHashMap;
  }
  
  protected List<sqb> a(List<sqc> paramList)
  {
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    Object localObject1;
    Object localObject2;
    while (paramList.hasNext())
    {
      localObject1 = (sqc)paramList.next();
      if (localHashMap.containsKey(((sqc)localObject1).c))
      {
        ((List)localHashMap.get(((sqc)localObject1).c)).add(localObject1);
      }
      else
      {
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).add(localObject1);
        localHashMap.put(((sqc)localObject1).c, localObject2);
      }
    }
    paramList = a(localHashMap);
    veg.b("Q.qqstory.recommendAlbum.logic_GeoHashSplitStrategy", "start findAlbums node=%s, minGatherLevel=%d, maxGatherLevel=%s", paramList.a(), Integer.valueOf(((sra)a()).d), Integer.valueOf(((sra)a()).e));
    paramList = a(paramList.a(), ((sra)a()).d, ((sra)a()).e);
    if (paramList != null)
    {
      localObject1 = paramList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (sqb)((Iterator)localObject1).next();
        if ((((sqb)localObject2).jdField_a_of_type_JavaUtilList == null) || (((sqb)localObject2).jdField_a_of_type_JavaUtilList.size() == 0))
        {
          veg.e("Q.qqstory.recommendAlbum.logic_GeoHashSplitStrategy", "check why? album:" + localObject2);
          vxs.a("check why? album:", new Object[0]);
        }
        else
        {
          ArrayList localArrayList = new ArrayList();
          Iterator localIterator = ((sqb)localObject2).jdField_a_of_type_JavaUtilList.iterator();
          while (localIterator.hasNext()) {
            localArrayList.addAll((Collection)localHashMap.get((String)localIterator.next()));
          }
          ((sqb)localObject2).a(localArrayList);
          ((sqb)localObject2).a(a());
        }
      }
    }
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sqs
 * JD-Core Version:    0.7.0.1
 */