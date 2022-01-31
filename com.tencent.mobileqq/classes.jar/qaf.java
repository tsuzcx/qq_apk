import java.util.Deque;
import java.util.LinkedList;

class qaf
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  Deque<qah> jdField_a_of_type_JavaUtilDeque = new LinkedList();
  int b;
  int c = 0;
  private final int d = 50;
  
  qaf(qae paramqae) {}
  
  boolean a(qah paramqah)
  {
    if (this.jdField_a_of_type_JavaUtilDeque.size() >= 50) {
      this.jdField_a_of_type_JavaUtilDeque.poll();
    }
    return this.jdField_a_of_type_JavaUtilDeque.offer(paramqah);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qaf
 * JD-Core Version:    0.7.0.1
 */