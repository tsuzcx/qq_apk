import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class spv
  implements spw
{
  public int a;
  protected String a;
  protected List<sqq> a;
  protected spx a;
  protected boolean a;
  private List<sqc> b;
  private List<sqc> c = new ArrayList();
  
  public spv(int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = "Q.qqstory.recommendAlbum.logic_BaseAlbumFilter";
  }
  
  private void a(List<sqb> paramList, String paramString) {}
  
  @NonNull
  protected List<sqc> a()
  {
    if (this.b == null) {
      return new ArrayList();
    }
    return this.b;
  }
  
  public void a(List<sqc> paramList)
  {
    this.b = new ArrayList();
    this.b.addAll(paramList);
  }
  
  public void a(spx paramspx)
  {
    veg.b(this.jdField_a_of_type_JavaLangString, "start");
    this.jdField_a_of_type_Spx = paramspx;
    paramspx = a();
    if ((paramspx == null) || (paramspx.isEmpty()))
    {
      veg.e(this.jdField_a_of_type_JavaLangString, "can't find enough pic");
      b(null);
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      veg.e(this.jdField_a_of_type_JavaLangString, "must set split strategy");
      b(null);
      return;
    }
    paramspx = new sqb(this.jdField_a_of_type_Int, paramspx);
    Object localObject1 = new LinkedList();
    ((Queue)localObject1).offer(paramspx);
    paramspx = new LinkedList();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      Object localObject2 = (sqq)this.jdField_a_of_type_JavaUtilList.get(i);
      while (((Queue)localObject1).size() > 0)
      {
        Object localObject3 = (sqb)((Queue)localObject1).poll();
        if (localObject3 != null)
        {
          veg.b(this.jdField_a_of_type_JavaLangString, "to split StoryAlbum=%s", ((sqb)localObject3).toString());
          ((sqq)localObject2).a((sqb)localObject3);
          localObject3 = ((sqq)localObject2).b();
          if ((localObject3 == null) || (((List)localObject3).size() == 0))
          {
            veg.d(this.jdField_a_of_type_JavaLangString, "find no album strategy=" + localObject2.toString());
          }
          else
          {
            a((List)localObject3, localObject2.toString());
            veg.b(this.jdField_a_of_type_JavaLangString, "split strategy=%s, result=%s", localObject2.toString(), localObject3.toString());
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              sqb localsqb = (sqb)((Iterator)localObject3).next();
              if (i == this.jdField_a_of_type_JavaUtilList.size() - 1) {
                localArrayList.add(localsqb);
              } else {
                paramspx.add(localsqb);
              }
            }
          }
        }
      }
      if (paramspx.size() <= 0) {
        break;
      }
      i += 1;
      localObject2 = paramspx;
      paramspx = (spx)localObject1;
      localObject1 = localObject2;
    }
    b(localArrayList);
  }
  
  public void a(sqq paramsqq)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramsqq);
  }
  
  protected void b(List<sqb> paramList)
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
          Iterator localIterator = ((sqb)((Iterator)localObject).next()).a().iterator();
          while (localIterator.hasNext())
          {
            sqc localsqc = (sqc)localIterator.next();
            this.c.remove(localsqc);
          }
        }
      }
    }
    Object localObject = this.jdField_a_of_type_JavaLangString;
    if (paramList == null) {}
    for (int i = 0;; i = paramList.size())
    {
      veg.a((String)localObject, "handleResult, find album count=%d, leaving pic count=%d", Integer.valueOf(i), Integer.valueOf(this.c.size()));
      this.jdField_a_of_type_Spx.a(paramList, this.c);
      return;
    }
  }
  
  protected void c(List<sqb> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     spv
 * JD-Core Version:    0.7.0.1
 */