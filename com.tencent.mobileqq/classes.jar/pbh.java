import java.util.ArrayList;

class pbh
  extends pcm
{
  pbh(pbe parampbe, int paramInt)
  {
    super(parampbe, null);
  }
  
  void a(pcp parampcp)
  {
    if (this.jdField_a_of_type_Int == 1) {
      parampcp.onCommentListLoad(1, false, new ArrayList(), false, 6, 6);
    }
    while (this.jdField_a_of_type_Int != 2) {
      return;
    }
    parampcp.onCommentLoadMore(1, false, new ArrayList(), false, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pbh
 * JD-Core Version:    0.7.0.1
 */