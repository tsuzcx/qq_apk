import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class scz
  implements sda
{
  public int a;
  protected String a;
  protected List<sdu> a;
  protected sdb a;
  protected boolean a;
  private List<sdg> b;
  private List<sdg> c = new ArrayList();
  
  public scz(int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = "Q.qqstory.recommendAlbum.logic_BaseAlbumFilter";
  }
  
  private void a(List<sdf> paramList, String paramString) {}
  
  @NonNull
  protected List<sdg> a()
  {
    if (this.b == null) {
      return new ArrayList();
    }
    return this.b;
  }
  
  public void a(List<sdg> paramList)
  {
    this.b = new ArrayList();
    this.b.addAll(paramList);
  }
  
  public void a(sdb paramsdb)
  {
    urk.b(this.jdField_a_of_type_JavaLangString, "start");
    this.jdField_a_of_type_Sdb = paramsdb;
    paramsdb = a();
    if ((paramsdb == null) || (paramsdb.isEmpty()))
    {
      urk.e(this.jdField_a_of_type_JavaLangString, "can't find enough pic");
      b(null);
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      urk.e(this.jdField_a_of_type_JavaLangString, "must set split strategy");
      b(null);
      return;
    }
    paramsdb = new sdf(this.jdField_a_of_type_Int, paramsdb);
    Object localObject1 = new LinkedList();
    ((Queue)localObject1).offer(paramsdb);
    paramsdb = new LinkedList();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      Object localObject2 = (sdu)this.jdField_a_of_type_JavaUtilList.get(i);
      while (((Queue)localObject1).size() > 0)
      {
        Object localObject3 = (sdf)((Queue)localObject1).poll();
        if (localObject3 != null)
        {
          urk.b(this.jdField_a_of_type_JavaLangString, "to split StoryAlbum=%s", ((sdf)localObject3).toString());
          ((sdu)localObject2).a((sdf)localObject3);
          localObject3 = ((sdu)localObject2).b();
          if ((localObject3 == null) || (((List)localObject3).size() == 0))
          {
            urk.d(this.jdField_a_of_type_JavaLangString, "find no album strategy=" + localObject2.toString());
          }
          else
          {
            a((List)localObject3, localObject2.toString());
            urk.b(this.jdField_a_of_type_JavaLangString, "split strategy=%s, result=%s", localObject2.toString(), localObject3.toString());
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              sdf localsdf = (sdf)((Iterator)localObject3).next();
              if (i == this.jdField_a_of_type_JavaUtilList.size() - 1) {
                localArrayList.add(localsdf);
              } else {
                paramsdb.add(localsdf);
              }
            }
          }
        }
      }
      if (paramsdb.size() <= 0) {
        break;
      }
      i += 1;
      localObject2 = paramsdb;
      paramsdb = (sdb)localObject1;
      localObject1 = localObject2;
    }
    b(localArrayList);
  }
  
  public void a(sdu paramsdu)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramsdu);
  }
  
  protected void b(List<sdf> paramList)
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
          Iterator localIterator = ((sdf)((Iterator)localObject).next()).a().iterator();
          while (localIterator.hasNext())
          {
            sdg localsdg = (sdg)localIterator.next();
            this.c.remove(localsdg);
          }
        }
      }
    }
    Object localObject = this.jdField_a_of_type_JavaLangString;
    if (paramList == null) {}
    for (int i = 0;; i = paramList.size())
    {
      urk.a((String)localObject, "handleResult, find album count=%d, leaving pic count=%d", Integer.valueOf(i), Integer.valueOf(this.c.size()));
      this.jdField_a_of_type_Sdb.a(paramList, this.c);
      return;
    }
  }
  
  protected void c(List<sdf> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     scz
 * JD-Core Version:    0.7.0.1
 */