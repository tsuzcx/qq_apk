import java.util.ArrayList;

class ojm
  extends ojq
{
  ojm(oio paramoio, int paramInt)
  {
    super(paramoio, null);
  }
  
  void a(ojt paramojt)
  {
    if (this.jdField_a_of_type_Int == 1) {
      paramojt.onCommentListLoad(1, false, new ArrayList(), false, 3, 3);
    }
    while (this.jdField_a_of_type_Int != 2) {
      return;
    }
    paramojt.onCommentLoadMore(1, false, new ArrayList(), false, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ojm
 * JD-Core Version:    0.7.0.1
 */