import java.util.ArrayList;

class pbi
  extends pcm
{
  pbi(pbe parampbe, int paramInt)
  {
    super(parampbe, null);
  }
  
  void a(pcp parampcp)
  {
    if (this.jdField_a_of_type_Int == 1) {
      parampcp.onCommentListLoad(2, false, new ArrayList(), false, 4, 4);
    }
    while (this.jdField_a_of_type_Int != 2) {
      return;
    }
    parampcp.onCommentLoadMore(2, false, new ArrayList(), false, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pbi
 * JD-Core Version:    0.7.0.1
 */