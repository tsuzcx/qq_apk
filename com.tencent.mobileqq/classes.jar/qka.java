import java.util.Deque;
import java.util.LinkedList;

class qka
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  Deque<qkc> jdField_a_of_type_JavaUtilDeque = new LinkedList();
  int b;
  int c = 0;
  private final int d = 50;
  
  qka(qjz paramqjz) {}
  
  boolean a(qkc paramqkc)
  {
    if (this.jdField_a_of_type_JavaUtilDeque.size() >= 50) {
      this.jdField_a_of_type_JavaUtilDeque.poll();
    }
    return this.jdField_a_of_type_JavaUtilDeque.offer(paramqkc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qka
 * JD-Core Version:    0.7.0.1
 */