import android.widget.BaseAdapter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class sxu<T>
  extends BaseAdapter
  implements sxw
{
  private int jdField_a_of_type_Int;
  private HashMap<T, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  protected void a(T paramT)
  {
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    localHashMap.put(paramT, Integer.valueOf(i));
  }
  
  protected void a(List<T> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a(paramList.next());
    }
  }
  
  protected void b()
  {
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public T getItem(int paramInt)
  {
    return null;
  }
  
  public final long getItemId(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilHashMap.size())) {
      return -1L;
    }
    Object localObject = getItem(paramInt);
    if (this.jdField_a_of_type_JavaUtilHashMap.get(localObject) != null) {
      return ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(localObject)).intValue();
    }
    return paramInt;
  }
  
  public final boolean hasStableIds()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sxu
 * JD-Core Version:    0.7.0.1
 */