import java.util.ArrayList;

class pbg
  extends pcm
{
  pbg(pbe parampbe, int paramInt)
  {
    super(parampbe, null);
  }
  
  void a(pcp parampcp)
  {
    if (this.jdField_a_of_type_Int == 1) {
      parampcp.onCommentListLoad(1, false, new ArrayList(), false, 3, 3);
    }
    while (this.jdField_a_of_type_Int != 2) {
      return;
    }
    parampcp.onCommentLoadMore(1, false, new ArrayList(), false, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pbg
 * JD-Core Version:    0.7.0.1
 */