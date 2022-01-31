import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.AddressItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class sqt
  extends sqq<sqy>
{
  private sra a;
  private sra b;
  private sra c;
  
  public sqt()
  {
    int i = ((spq)tdc.a(30)).a().b();
    this.jdField_a_of_type_Sra = new sra();
    this.jdField_a_of_type_Sra.a = 2;
    this.jdField_a_of_type_Sra.b = 6;
    this.jdField_a_of_type_Sra.d = i;
    this.jdField_a_of_type_Sra.e = (i - 1);
    this.b = new sra();
    this.b.a = 4;
    this.b.b = 10;
    this.b.d = i;
    this.b.e = -1;
    this.c = new sra();
    this.c.a = 3;
    this.c.b = 6;
    this.b.d = i;
    this.b.e = -1;
  }
  
  private List<sqb> a(List<sqb> paramList, int paramInt, sra paramsra)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        sqb localsqb = (sqb)paramList.next();
        if (spz.a(localsqb, paramInt)) {
          localArrayList.add(localsqb);
        }
      }
      return a(localArrayList, paramsra);
    }
    return new ArrayList(1);
  }
  
  private List<sqb> a(List<sqb> paramList, sra paramsra)
  {
    Object localObject1 = new HashMap();
    paramList = paramList.iterator();
    Object localObject2;
    ArrayList localArrayList1;
    while (paramList.hasNext())
    {
      localObject2 = (sqb)paramList.next();
      if (((HashMap)localObject1).containsKey(((sqb)localObject2).b))
      {
        ((List)((HashMap)localObject1).get(((sqb)localObject2).b)).add(localObject2);
      }
      else
      {
        localArrayList1 = new ArrayList();
        localArrayList1.add(localObject2);
        ((HashMap)localObject1).put(((sqb)localObject2).b, localArrayList1);
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
          sqb localsqb = (sqb)((Iterator)localObject4).next();
          if (!TextUtils.isEmpty(localsqb.d)) {
            localArrayList1.add(localsqb.d);
          }
          if ((localsqb.a != null) && (localsqb.a.size() > 0)) {
            localArrayList2.addAll(localsqb.a);
          }
          for (;;)
          {
            ((List)localObject3).addAll(localsqb.a());
            long l3 = l2;
            if (localsqb.f() < l2) {
              l3 = localsqb.f();
            }
            l2 = l3;
            if (localsqb.g() <= l1) {
              break;
            }
            l1 = localsqb.g();
            l2 = l3;
            break;
            veg.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "mergeSameNameAlbum album=%s", new Object[] { localsqb.toString() });
          }
        }
        localObject3 = new sqb(paramsra.a, (List)localObject3);
        ((sqb)localObject3).b = ((String)localObject2);
        ((sqb)localObject3).d = localArrayList1.toString();
        ((sqb)localObject3).a = localArrayList2;
        ((sqb)localObject3).a(l2, l1);
        ((sqb)localObject3).a(paramsra);
        paramList.add(localObject3);
        veg.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "mergeSameNameAlbum new album=%s", new Object[] { ((sqb)localObject3).toString() });
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
    return (paramAddressItem != null) && (TextUtils.equals(paramAddressItem.country, ajyc.a(2131705389)));
  }
  
  protected List<sqb> a(@NonNull List<sqc> paramList)
  {
    Object localObject3 = new ArrayList();
    Object localObject2 = new ArrayList();
    Object localObject1 = new ArrayList();
    paramList = paramList.iterator();
    Object localObject4;
    while (paramList.hasNext())
    {
      localObject4 = (sqc)paramList.next();
      AddressItem localAddressItem = ((sqc)localObject4).jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem;
      if (localAddressItem == null) {
        veg.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "handleSplit poi is null pic=%s", new Object[] { ((sqc)localObject4).c + ((sqc)localObject4).jdField_a_of_type_JavaLangString });
      } else if (a(localAddressItem)) {
        ((List)localObject3).add(localObject4);
      } else if (b(localAddressItem)) {
        ((List)localObject2).add(localObject4);
      } else {
        ((List)localObject1).add(localObject4);
      }
    }
    veg.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "handleSplit homeGroupPicCount%d, nativeGroupPicCount=%d, foreignGroupPicCount=%d", new Object[] { Integer.valueOf(((List)localObject3).size()), Integer.valueOf(((List)localObject2).size()), Integer.valueOf(((List)localObject1).size()) });
    paramList = new ArrayList();
    if (((List)localObject3).size() > 0)
    {
      localObject3 = new sqb(2, (List)localObject3);
      ((sqb)localObject3).a(this.jdField_a_of_type_Sqb);
      localObject4 = new sqr();
      ((sqr)localObject4).a((sqb)localObject3);
      ((sqr)localObject4).a(this.jdField_a_of_type_Sra);
      paramList.addAll(a(((sqr)localObject4).b(), 5, this.jdField_a_of_type_Sra));
    }
    if (((List)localObject2).size() > 0)
    {
      localObject2 = new sqb(4, (List)localObject2);
      ((sqb)localObject2).a(this.jdField_a_of_type_Sqb);
      localObject3 = new sqs();
      ((sqs)localObject3).a(this.b);
      ((sqs)localObject3).a((sqb)localObject2);
      paramList.addAll(a(((sqs)localObject3).b(), 3, this.b));
    }
    if (((List)localObject1).size() > 0)
    {
      localObject1 = new sqb(3, (List)localObject1);
      ((sqb)localObject1).a(this.jdField_a_of_type_Sqb);
      localObject2 = new sqs();
      ((sqs)localObject2).a(this.c);
      ((sqs)localObject2).a((sqb)localObject1);
      paramList.addAll(a(((sqs)localObject2).b(), 1, this.c));
    }
    return paramList;
  }
  
  public void a(sra paramsra)
  {
    this.jdField_a_of_type_Sra = paramsra;
  }
  
  public void b(sra paramsra)
  {
    this.b = paramsra;
  }
  
  public void c(sra paramsra)
  {
    this.c = paramsra;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sqt
 * JD-Core Version:    0.7.0.1
 */