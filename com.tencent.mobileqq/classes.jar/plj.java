import com.tencent.component.network.utils.http.pool.PoolEntry;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public abstract class plj
{
  private final Object jdField_a_of_type_JavaLangObject;
  private final LinkedList jdField_a_of_type_JavaUtilLinkedList;
  private final Set jdField_a_of_type_JavaUtilSet;
  private final LinkedList b;
  
  plj(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    this.b = new LinkedList();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilLinkedList.size() + this.jdField_a_of_type_JavaUtilSet.size();
  }
  
  public PoolEntry a()
  {
    if (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) {
      return (PoolEntry)this.jdField_a_of_type_JavaUtilLinkedList.getLast();
    }
    return null;
  }
  
  protected abstract PoolEntry a(Object paramObject);
  
  public pli a()
  {
    return (pli)this.b.poll();
  }
  
  public void a()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((pli)localIterator.next()).cancel(true);
    }
    this.b.clear();
    localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
    while (localIterator.hasNext()) {
      ((PoolEntry)localIterator.next()).b();
    }
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext()) {
      ((PoolEntry)localIterator.next()).b();
    }
    this.jdField_a_of_type_JavaUtilSet.clear();
  }
  
  public void a(PoolEntry paramPoolEntry, boolean paramBoolean)
  {
    if (paramPoolEntry == null) {
      throw new IllegalArgumentException("Pool entry may not be null");
    }
    if (!this.jdField_a_of_type_JavaUtilSet.remove(paramPoolEntry)) {
      throw new IllegalStateException("Entry " + paramPoolEntry + " has not been leased from this pool");
    }
    if (paramBoolean) {
      this.jdField_a_of_type_JavaUtilLinkedList.addFirst(paramPoolEntry);
    }
  }
  
  public void a(pli parampli)
  {
    if (parampli == null) {
      return;
    }
    this.b.add(parampli);
  }
  
  public boolean a(PoolEntry paramPoolEntry)
  {
    if (paramPoolEntry == null) {
      throw new IllegalArgumentException("Pool entry may not be null");
    }
    return (this.jdField_a_of_type_JavaUtilLinkedList.remove(paramPoolEntry)) || (this.jdField_a_of_type_JavaUtilSet.remove(paramPoolEntry));
  }
  
  public PoolEntry b(Object paramObject)
  {
    if (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
    {
      Object localObject;
      if (paramObject != null)
      {
        localObject = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          PoolEntry localPoolEntry = (PoolEntry)((Iterator)localObject).next();
          if (paramObject.equals(localPoolEntry.c()))
          {
            ((Iterator)localObject).remove();
            this.jdField_a_of_type_JavaUtilSet.add(localPoolEntry);
            return localPoolEntry;
          }
        }
      }
      paramObject = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
      while (paramObject.hasNext())
      {
        localObject = (PoolEntry)paramObject.next();
        if (((PoolEntry)localObject).c() == null)
        {
          paramObject.remove();
          this.jdField_a_of_type_JavaUtilSet.add(localObject);
          return localObject;
        }
      }
    }
    return null;
  }
  
  public void b(pli parampli)
  {
    if (parampli == null) {
      return;
    }
    this.b.remove(parampli);
  }
  
  public PoolEntry c(Object paramObject)
  {
    paramObject = a(paramObject);
    this.jdField_a_of_type_JavaUtilSet.add(paramObject);
    return paramObject;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[route: ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangObject);
    localStringBuilder.append("][leased: ");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilSet.size());
    localStringBuilder.append("][available: ");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilLinkedList.size());
    localStringBuilder.append("][pending: ");
    localStringBuilder.append(this.b.size());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     plj
 * JD-Core Version:    0.7.0.1
 */