import java.util.ArrayList;

class pdy
  extends pfe
{
  pdy(pdv parampdv, int paramInt)
  {
    super(parampdv, null);
  }
  
  void a(pfh parampfh)
  {
    if (this.jdField_a_of_type_Int == 1) {
      parampfh.onCommentListLoad(1, false, new ArrayList(), false, 6, 6);
    }
    while (this.jdField_a_of_type_Int != 2) {
      return;
    }
    parampfh.onCommentLoadMore(1, false, new ArrayList(), false, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pdy
 * JD-Core Version:    0.7.0.1
 */