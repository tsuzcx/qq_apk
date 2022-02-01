import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class qhw
{
  private static qhw jdField_a_of_type_Qhw;
  private SparseArray<ChannelInfo> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private HashSet<Integer> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private boolean jdField_a_of_type_Boolean = true;
  
  public static qhw a()
  {
    if (jdField_a_of_type_Qhw == null) {}
    try
    {
      if (jdField_a_of_type_Qhw == null) {
        jdField_a_of_type_Qhw = new qhw();
      }
      return jdField_a_of_type_Qhw;
    }
    finally {}
  }
  
  public void a(List<Integer> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        int i = ((Integer)paramList.next()).intValue();
        this.jdField_a_of_type_AndroidUtilSparseArray.remove(i);
        this.jdField_a_of_type_JavaUtilHashSet.remove(Integer.valueOf(i));
      }
    }
  }
  
  public void b(List<Integer> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      ArrayList localArrayList = new ArrayList();
      int j = this.jdField_a_of_type_AndroidUtilSparseArray.size();
      int i = 0;
      while (i < j)
      {
        int k = this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i);
        if ((!pqu.a(k)) && (!paramList.contains(Integer.valueOf(k)))) {
          localArrayList.add(Integer.valueOf(k));
        }
        i += 1;
      }
      paramList = localArrayList.iterator();
      while (paramList.hasNext())
      {
        i = ((Integer)paramList.next()).intValue();
        this.jdField_a_of_type_AndroidUtilSparseArray.remove(i);
        this.jdField_a_of_type_JavaUtilHashSet.remove(Integer.valueOf(i));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qhw
 * JD-Core Version:    0.7.0.1
 */