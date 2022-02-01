import java.util.ArrayList;

class pfa
  extends pfe
{
  pfa(pdv parampdv, int paramInt)
  {
    super(parampdv, null);
  }
  
  void a(pfh parampfh)
  {
    if (parampfh == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Int == 1)
      {
        parampfh.onCommentListLoad(1, false, new ArrayList(), false, 3, 3);
        return;
      }
    } while (this.jdField_a_of_type_Int != 2);
    parampfh.onCommentLoadMore(1, false, new ArrayList(), false, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pfa
 * JD-Core Version:    0.7.0.1
 */