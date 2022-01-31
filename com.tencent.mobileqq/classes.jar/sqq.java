import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.AddressItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class sqq
  extends sqn<sqv>
{
  private sqx a;
  private sqx b;
  private sqx c;
  
  public sqq()
  {
    int i = ((spn)tcz.a(30)).a().b();
    this.jdField_a_of_type_Sqx = new sqx();
    this.jdField_a_of_type_Sqx.a = 2;
    this.jdField_a_of_type_Sqx.b = 6;
    this.jdField_a_of_type_Sqx.d = i;
    this.jdField_a_of_type_Sqx.e = (i - 1);
    this.b = new sqx();
    this.b.a = 4;
    this.b.b = 10;
    this.b.d = i;
    this.b.e = -1;
    this.c = new sqx();
    this.c.a = 3;
    this.c.b = 6;
    this.b.d = i;
    this.b.e = -1;
  }
  
  private List<spy> a(List<spy> paramList, int paramInt, sqx paramsqx)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        spy localspy = (spy)paramList.next();
        if (spw.a(localspy, paramInt)) {
          localArrayList.add(localspy);
        }
      }
      return a(localArrayList, paramsqx);
    }
    return new ArrayList(1);
  }
  
  private List<spy> a(List<spy> paramList, sqx paramsqx)
  {
    Object localObject1 = new HashMap();
    paramList = paramList.iterator();
    Object localObject2;
    ArrayList localArrayList1;
    while (paramList.hasNext())
    {
      localObject2 = (spy)paramList.next();
      if (((HashMap)localObject1).containsKey(((spy)localObject2).b))
      {
        ((List)((HashMap)localObject1).get(((spy)localObject2).b)).add(localObject2);
      }
      else
      {
        localArrayList1 = new ArrayList();
        localArrayList1.add(localObject2);
        ((HashMap)localObject1).put(((spy)localObject2).b, localArrayList1);
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
          spy localspy = (spy)((Iterator)localObject4).next();
          if (!TextUtils.isEmpty(localspy.d)) {
            localArrayList1.add(localspy.d);
          }
          if ((localspy.a != null) && (localspy.a.size() > 0)) {
            localArrayList2.addAll(localspy.a);
          }
          for (;;)
          {
            ((List)localObject3).addAll(localspy.a());
            long l3 = l2;
            if (localspy.f() < l2) {
              l3 = localspy.f();
            }
            l2 = l3;
            if (localspy.g() <= l1) {
              break;
            }
            l1 = localspy.g();
            l2 = l3;
            break;
            ved.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "mergeSameNameAlbum album=%s", new Object[] { localspy.toString() });
          }
        }
        localObject3 = new spy(paramsqx.a, (List)localObject3);
        ((spy)localObject3).b = ((String)localObject2);
        ((spy)localObject3).d = localArrayList1.toString();
        ((spy)localObject3).a = localArrayList2;
        ((spy)localObject3).a(l2, l1);
        ((spy)localObject3).a(paramsqx);
        paramList.add(localObject3);
        ved.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "mergeSameNameAlbum new album=%s", new Object[] { ((spy)localObject3).toString() });
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
    return (paramAddressItem != null) && (TextUtils.equals(paramAddressItem.country, ajya.a(2131705400)));
  }
  
  protected List<spy> a(@NonNull List<spz> paramList)
  {
    Object localObject3 = new ArrayList();
    Object localObject2 = new ArrayList();
    Object localObject1 = new ArrayList();
    paramList = paramList.iterator();
    Object localObject4;
    while (paramList.hasNext())
    {
      localObject4 = (spz)paramList.next();
      AddressItem localAddressItem = ((spz)localObject4).jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem;
      if (localAddressItem == null) {
        ved.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "handleSplit poi is null pic=%s", new Object[] { ((spz)localObject4).c + ((spz)localObject4).jdField_a_of_type_JavaLangString });
      } else if (a(localAddressItem)) {
        ((List)localObject3).add(localObject4);
      } else if (b(localAddressItem)) {
        ((List)localObject2).add(localObject4);
      } else {
        ((List)localObject1).add(localObject4);
      }
    }
    ved.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "handleSplit homeGroupPicCount%d, nativeGroupPicCount=%d, foreignGroupPicCount=%d", new Object[] { Integer.valueOf(((List)localObject3).size()), Integer.valueOf(((List)localObject2).size()), Integer.valueOf(((List)localObject1).size()) });
    paramList = new ArrayList();
    if (((List)localObject3).size() > 0)
    {
      localObject3 = new spy(2, (List)localObject3);
      ((spy)localObject3).a(this.jdField_a_of_type_Spy);
      localObject4 = new sqo();
      ((sqo)localObject4).a((spy)localObject3);
      ((sqo)localObject4).a(this.jdField_a_of_type_Sqx);
      paramList.addAll(a(((sqo)localObject4).b(), 5, this.jdField_a_of_type_Sqx));
    }
    if (((List)localObject2).size() > 0)
    {
      localObject2 = new spy(4, (List)localObject2);
      ((spy)localObject2).a(this.jdField_a_of_type_Spy);
      localObject3 = new sqp();
      ((sqp)localObject3).a(this.b);
      ((sqp)localObject3).a((spy)localObject2);
      paramList.addAll(a(((sqp)localObject3).b(), 3, this.b));
    }
    if (((List)localObject1).size() > 0)
    {
      localObject1 = new spy(3, (List)localObject1);
      ((spy)localObject1).a(this.jdField_a_of_type_Spy);
      localObject2 = new sqp();
      ((sqp)localObject2).a(this.c);
      ((sqp)localObject2).a((spy)localObject1);
      paramList.addAll(a(((sqp)localObject2).b(), 1, this.c));
    }
    return paramList;
  }
  
  public void a(sqx paramsqx)
  {
    this.jdField_a_of_type_Sqx = paramsqx;
  }
  
  public void b(sqx paramsqx)
  {
    this.b = paramsqx;
  }
  
  public void c(sqx paramsqx)
  {
    this.c = paramsqx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sqq
 * JD-Core Version:    0.7.0.1
 */