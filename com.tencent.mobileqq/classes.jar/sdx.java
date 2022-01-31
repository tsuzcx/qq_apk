import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.AddressItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class sdx
  extends sdu<sec>
{
  private see a;
  private see b;
  private see c;
  
  public sdx()
  {
    int i = ((scu)sqg.a(30)).a().b();
    this.jdField_a_of_type_See = new see();
    this.jdField_a_of_type_See.a = 2;
    this.jdField_a_of_type_See.b = 6;
    this.jdField_a_of_type_See.d = i;
    this.jdField_a_of_type_See.e = (i - 1);
    this.b = new see();
    this.b.a = 4;
    this.b.b = 10;
    this.b.d = i;
    this.b.e = -1;
    this.c = new see();
    this.c.a = 3;
    this.c.b = 6;
    this.b.d = i;
    this.b.e = -1;
  }
  
  private List<sdf> a(List<sdf> paramList, int paramInt, see paramsee)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        sdf localsdf = (sdf)paramList.next();
        if (sdd.a(localsdf, paramInt)) {
          localArrayList.add(localsdf);
        }
      }
      return a(localArrayList, paramsee);
    }
    return new ArrayList(1);
  }
  
  private List<sdf> a(List<sdf> paramList, see paramsee)
  {
    Object localObject1 = new HashMap();
    paramList = paramList.iterator();
    Object localObject2;
    ArrayList localArrayList1;
    while (paramList.hasNext())
    {
      localObject2 = (sdf)paramList.next();
      if (((HashMap)localObject1).containsKey(((sdf)localObject2).b))
      {
        ((List)((HashMap)localObject1).get(((sdf)localObject2).b)).add(localObject2);
      }
      else
      {
        localArrayList1 = new ArrayList();
        localArrayList1.add(localObject2);
        ((HashMap)localObject1).put(((sdf)localObject2).b, localArrayList1);
      }
    }
    paramList = new ArrayList();
    localObject1 = ((HashMap)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      Object localObject4 = (List)((Map.Entry)localObject2).getValue();
      localObject2 = (String)((Map.Entry)localObject2).getKey();
      localArrayList1 = new ArrayList(((List)localObject4).size());
      ArrayList localArrayList2 = new ArrayList();
      Object localObject3 = new ArrayList();
      if (((List)localObject4).size() == 1)
      {
        paramList.add(((List)localObject4).get(0));
      }
      else
      {
        long l2 = 2147483647L;
        long l1 = 0L;
        localObject4 = ((List)localObject4).iterator();
        if (((Iterator)localObject4).hasNext())
        {
          sdf localsdf = (sdf)((Iterator)localObject4).next();
          if (!TextUtils.isEmpty(localsdf.d)) {
            localArrayList1.add(localsdf.d);
          }
          if ((localsdf.a != null) && (localsdf.a.size() > 0)) {
            localArrayList2.addAll(localsdf.a);
          }
          for (;;)
          {
            ((List)localObject3).addAll(localsdf.a());
            long l3 = l2;
            if (localsdf.f() < l2) {
              l3 = localsdf.f();
            }
            l2 = l3;
            if (localsdf.g() <= l1) {
              break;
            }
            l1 = localsdf.g();
            l2 = l3;
            break;
            urk.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "mergeSameNameAlbum album=%s", new Object[] { localsdf.toString() });
          }
        }
        localObject3 = new sdf(paramsee.a, (List)localObject3);
        ((sdf)localObject3).b = ((String)localObject2);
        ((sdf)localObject3).d = localArrayList1.toString();
        ((sdf)localObject3).a = localArrayList2;
        ((sdf)localObject3).a(l2, l1);
        ((sdf)localObject3).a(paramsee);
        paramList.add(localObject3);
        urk.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "mergeSameNameAlbum new album=%s", new Object[] { ((sdf)localObject3).toString() });
      }
    }
    return paramList;
  }
  
  private boolean a(AddressItem paramAddressItem)
  {
    return (paramAddressItem != null) && (paramAddressItem.poiType == 1);
  }
  
  private boolean b(AddressItem paramAddressItem)
  {
    return (paramAddressItem != null) && (TextUtils.equals(paramAddressItem.country, ajjy.a(2131639604)));
  }
  
  protected List<sdf> a(@NonNull List<sdg> paramList)
  {
    Object localObject3 = new ArrayList();
    Object localObject2 = new ArrayList();
    Object localObject1 = new ArrayList();
    paramList = paramList.iterator();
    Object localObject4;
    while (paramList.hasNext())
    {
      localObject4 = (sdg)paramList.next();
      AddressItem localAddressItem = ((sdg)localObject4).jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem;
      if (localAddressItem == null) {
        urk.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "handleSplit poi is null pic=%s", new Object[] { ((sdg)localObject4).c + ((sdg)localObject4).jdField_a_of_type_JavaLangString });
      } else if (a(localAddressItem)) {
        ((List)localObject3).add(localObject4);
      } else if (b(localAddressItem)) {
        ((List)localObject2).add(localObject4);
      } else {
        ((List)localObject1).add(localObject4);
      }
    }
    urk.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "handleSplit homeGroupPicCount%d, nativeGroupPicCount=%d, foreignGroupPicCount=%d", new Object[] { Integer.valueOf(((List)localObject3).size()), Integer.valueOf(((List)localObject2).size()), Integer.valueOf(((List)localObject1).size()) });
    paramList = new ArrayList();
    if (((List)localObject3).size() > 0)
    {
      localObject3 = new sdf(2, (List)localObject3);
      ((sdf)localObject3).a(this.jdField_a_of_type_Sdf);
      localObject4 = new sdv();
      ((sdv)localObject4).a((sdf)localObject3);
      ((sdv)localObject4).a(this.jdField_a_of_type_See);
      paramList.addAll(a(((sdv)localObject4).b(), 5, this.jdField_a_of_type_See));
    }
    if (((List)localObject2).size() > 0)
    {
      localObject2 = new sdf(4, (List)localObject2);
      ((sdf)localObject2).a(this.jdField_a_of_type_Sdf);
      localObject3 = new sdw();
      ((sdw)localObject3).a(this.b);
      ((sdw)localObject3).a((sdf)localObject2);
      paramList.addAll(a(((sdw)localObject3).b(), 3, this.b));
    }
    if (((List)localObject1).size() > 0)
    {
      localObject1 = new sdf(3, (List)localObject1);
      ((sdf)localObject1).a(this.jdField_a_of_type_Sdf);
      localObject2 = new sdw();
      ((sdw)localObject2).a(this.c);
      ((sdw)localObject2).a((sdf)localObject1);
      paramList.addAll(a(((sdw)localObject2).b(), 1, this.c));
    }
    return paramList;
  }
  
  public void a(see paramsee)
  {
    this.jdField_a_of_type_See = paramsee;
  }
  
  public void b(see paramsee)
  {
    this.b = paramsee;
  }
  
  public void c(see paramsee)
  {
    this.c = paramsee;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sdx
 * JD-Core Version:    0.7.0.1
 */