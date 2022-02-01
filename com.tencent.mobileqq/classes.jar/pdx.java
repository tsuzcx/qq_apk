import java.util.ArrayList;

class pdx
  extends pfe
{
  pdx(pdv parampdv, int paramInt)
  {
    super(parampdv, null);
  }
  
  void a(pfh parampfh)
  {
    if (this.jdField_a_of_type_Int == 1) {
      parampfh.onCommentListLoad(1, false, new ArrayList(), false, 3, 3);
    }
    while (this.jdField_a_of_type_Int != 2) {
      return;
    }
    parampfh.onCommentLoadMore(1, false, new ArrayList(), false, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pdx
 * JD-Core Version:    0.7.0.1
 */