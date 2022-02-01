import android.util.SparseArray;
import java.util.Stack;

class swr
{
  SparseArray<Integer> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  Stack<String> jdField_a_of_type_JavaUtilStack = new Stack();
  SparseArray<Object> b = new SparseArray();
  
  public int a()
  {
    int j = -1;
    int i = 3;
    int k = 0;
    if (k < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      if (this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(k) <= j) {
        break label72;
      }
      i = this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(k);
      j = ((Integer)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(k)).intValue();
    }
    for (;;)
    {
      int m = k + 1;
      k = j;
      j = i;
      i = k;
      k = m;
      break;
      return i;
      label72:
      m = j;
      j = i;
      i = m;
    }
  }
  
  public int b()
  {
    int i = this.jdField_a_of_type_JavaUtilStack.size() - 1;
    while (i >= 0)
    {
      String str = (String)this.jdField_a_of_type_JavaUtilStack.get(i);
      if (swn.a().equals(str)) {
        return 3;
      }
      if (swn.b().equals(str)) {
        return 2;
      }
      i -= 1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     swr
 * JD-Core Version:    0.7.0.1
 */