import java.util.Deque;
import java.util.LinkedList;

class ree
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  Deque<reg> jdField_a_of_type_JavaUtilDeque = new LinkedList();
  int b;
  int c = 0;
  private final int d = 50;
  
  ree(rec paramrec) {}
  
  boolean a(reg paramreg)
  {
    if (this.jdField_a_of_type_JavaUtilDeque.size() >= 50) {
      this.jdField_a_of_type_JavaUtilDeque.poll();
    }
    return this.jdField_a_of_type_JavaUtilDeque.offer(paramreg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ree
 * JD-Core Version:    0.7.0.1
 */