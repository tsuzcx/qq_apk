import java.util.Deque;
import java.util.LinkedList;

class rbv
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  Deque<rbx> jdField_a_of_type_JavaUtilDeque = new LinkedList();
  int b;
  int c = 0;
  private final int d = 50;
  
  rbv(rbt paramrbt) {}
  
  boolean a(rbx paramrbx)
  {
    if (this.jdField_a_of_type_JavaUtilDeque.size() >= 50) {
      this.jdField_a_of_type_JavaUtilDeque.poll();
    }
    return this.jdField_a_of_type_JavaUtilDeque.offer(paramrbx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rbv
 * JD-Core Version:    0.7.0.1
 */