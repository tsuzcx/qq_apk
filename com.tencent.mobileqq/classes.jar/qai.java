import java.util.Deque;
import java.util.LinkedList;

class qai
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  Deque<qak> jdField_a_of_type_JavaUtilDeque = new LinkedList();
  int b;
  int c = 0;
  private final int d = 50;
  
  qai(qah paramqah) {}
  
  boolean a(qak paramqak)
  {
    if (this.jdField_a_of_type_JavaUtilDeque.size() >= 50) {
      this.jdField_a_of_type_JavaUtilDeque.poll();
    }
    return this.jdField_a_of_type_JavaUtilDeque.offer(paramqak);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qai
 * JD-Core Version:    0.7.0.1
 */