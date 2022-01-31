import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class nzs
{
  HashMap<String, HashSet<Object>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  nzt jdField_a_of_type_Nzt;
  
  public nzs(nzt paramnzt)
  {
    this.jdField_a_of_type_Nzt = paramnzt;
  }
  
  private void b(String paramString, Object paramObject)
  {
    HashSet localHashSet2 = (HashSet)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if ((localHashSet2 != null) && (localHashSet2.contains(paramObject))) {
      return;
    }
    HashSet localHashSet1 = localHashSet2;
    if (localHashSet2 == null) {
      localHashSet1 = new HashSet();
    }
    localHashSet1.add(paramObject);
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localHashSet1);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public void a(String paramString, Object paramObject)
  {
    a(paramString, paramObject, true);
  }
  
  public void a(String paramString, Object paramObject, boolean paramBoolean)
  {
    b(paramString, paramObject);
    if (paramBoolean) {}
    while (this.jdField_a_of_type_Nzt == null) {
      return;
    }
    this.jdField_a_of_type_Nzt.a(paramString, paramObject);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Nzt != null) && (!this.jdField_a_of_type_JavaUtilHashMap.isEmpty()))
    {
      Iterator localIterator1 = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (localIterator1.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator1.next();
        Iterator localIterator2 = ((HashSet)localEntry.getValue()).iterator();
        while (localIterator2.hasNext())
        {
          Object localObject = localIterator2.next();
          this.jdField_a_of_type_Nzt.a((String)localEntry.getKey(), localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     nzs
 * JD-Core Version:    0.7.0.1
 */