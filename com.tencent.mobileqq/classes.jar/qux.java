import java.util.Deque;
import java.util.LinkedList;

class qux
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  Deque<quz> jdField_a_of_type_JavaUtilDeque = new LinkedList();
  int b;
  int c = 0;
  private final int d = 50;
  
  qux(quv paramquv) {}
  
  boolean a(quz paramquz)
  {
    if (this.jdField_a_of_type_JavaUtilDeque.size() >= 50) {
      this.jdField_a_of_type_JavaUtilDeque.poll();
    }
    return this.jdField_a_of_type_JavaUtilDeque.offer(paramquz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qux
 * JD-Core Version:    0.7.0.1
 */