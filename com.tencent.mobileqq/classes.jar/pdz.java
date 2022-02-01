import java.util.ArrayList;

class pdz
  extends pfe
{
  pdz(pdv parampdv, int paramInt)
  {
    super(parampdv, null);
  }
  
  void a(pfh parampfh)
  {
    if (this.jdField_a_of_type_Int == 1) {
      parampfh.onCommentListLoad(2, false, new ArrayList(), false, 4, 4);
    }
    while (this.jdField_a_of_type_Int != 2) {
      return;
    }
    parampfh.onCommentLoadMore(2, false, new ArrayList(), false, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pdz
 * JD-Core Version:    0.7.0.1
 */