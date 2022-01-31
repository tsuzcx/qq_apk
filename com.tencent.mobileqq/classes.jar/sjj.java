import android.widget.BaseAdapter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class sjj
  extends BaseAdapter
  implements sjm
{
  private int jdField_a_of_type_Int;
  private HashMap<Object, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  protected void a(Object paramObject)
  {
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    localHashMap.put(paramObject, Integer.valueOf(i));
  }
  
  protected void a(List<?> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a(paramList.next());
    }
  }
  
  protected void b(Object paramObject)
  {
    this.jdField_a_of_type_JavaUtilHashMap.remove(paramObject);
  }
  
  public final long getItemId(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilHashMap.size())) {
      return -1L;
    }
    Object localObject = getItem(paramInt);
    return ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(localObject)).intValue();
  }
  
  public final boolean hasStableIds()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sjj
 * JD-Core Version:    0.7.0.1
 */