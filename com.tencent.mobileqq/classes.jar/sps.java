import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class sps
  implements spt
{
  public int a;
  protected String a;
  protected List<sqn> a;
  protected spu a;
  protected boolean a;
  private List<spz> b;
  private List<spz> c = new ArrayList();
  
  public sps(int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = "Q.qqstory.recommendAlbum.logic_BaseAlbumFilter";
  }
  
  private void a(List<spy> paramList, String paramString) {}
  
  @NonNull
  protected List<spz> a()
  {
    if (this.b == null) {
      return new ArrayList();
    }
    return this.b;
  }
  
  public void a(List<spz> paramList)
  {
    this.b = new ArrayList();
    this.b.addAll(paramList);
  }
  
  public void a(spu paramspu)
  {
    ved.b(this.jdField_a_of_type_JavaLangString, "start");
    this.jdField_a_of_type_Spu = paramspu;
    paramspu = a();
    if ((paramspu == null) || (paramspu.isEmpty()))
    {
      ved.e(this.jdField_a_of_type_JavaLangString, "can't find enough pic");
      b(null);
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      ved.e(this.jdField_a_of_type_JavaLangString, "must set split strategy");
      b(null);
      return;
    }
    paramspu = new spy(this.jdField_a_of_type_Int, paramspu);
    Object localObject1 = new LinkedList();
    ((Queue)localObject1).offer(paramspu);
    paramspu = new LinkedList();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      Object localObject2 = (sqn)this.jdField_a_of_type_JavaUtilList.get(i);
      while (((Queue)localObject1).size() > 0)
      {
        Object localObject3 = (spy)((Queue)localObject1).poll();
        if (localObject3 != null)
        {
          ved.b(this.jdField_a_of_type_JavaLangString, "to split StoryAlbum=%s", ((spy)localObject3).toString());
          ((sqn)localObject2).a((spy)localObject3);
          localObject3 = ((sqn)localObject2).b();
          if ((localObject3 == null) || (((List)localObject3).size() == 0))
          {
            ved.d(this.jdField_a_of_type_JavaLangString, "find no album strategy=" + localObject2.toString());
          }
          else
          {
            a((List)localObject3, localObject2.toString());
            ved.b(this.jdField_a_of_type_JavaLangString, "split strategy=%s, result=%s", localObject2.toString(), localObject3.toString());
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              spy localspy = (spy)((Iterator)localObject3).next();
              if (i == this.jdField_a_of_type_JavaUtilList.size() - 1) {
                localArrayList.add(localspy);
              } else {
                paramspu.add(localspy);
              }
            }
          }
        }
      }
      if (paramspu.size() <= 0) {
        break;
      }
      i += 1;
      localObject2 = paramspu;
      paramspu = (spu)localObject1;
      localObject1 = localObject2;
    }
    b(localArrayList);
  }
  
  public void a(sqn paramsqn)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramsqn);
  }
  
  protected void b(List<spy> paramList)
  {
    this.c = new ArrayList();
    this.c.addAll(this.b);
    if ((paramList != null) && (paramList.size() > 0))
    {
      c(paramList);
      if (!this.jdField_a_of_type_Boolean)
      {
        localObject = paramList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          Iterator localIterator = ((spy)((Iterator)localObject).next()).a().iterator();
          while (localIterator.hasNext())
          {
            spz localspz = (spz)localIterator.next();
            this.c.remove(localspz);
          }
        }
      }
    }
    Object localObject = this.jdField_a_of_type_JavaLangString;
    if (paramList == null) {}
    for (int i = 0;; i = paramList.size())
    {
      ved.a((String)localObject, "handleResult, find album count=%d, leaving pic count=%d", Integer.valueOf(i), Integer.valueOf(this.c.size()));
      this.jdField_a_of_type_Spu.a(paramList, this.c);
      return;
    }
  }
  
  protected void c(List<spy> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sps
 * JD-Core Version:    0.7.0.1
 */