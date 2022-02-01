import java.util.ArrayList;

class pfd
  extends pfe
{
  pfd(pdv parampdv, int paramInt)
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
        parampfh.onCommentListLoad(1, false, new ArrayList(), false, 2, 2);
        return;
      }
    } while (this.jdField_a_of_type_Int != 2);
    parampfh.onCommentLoadMore(1, false, new ArrayList(), false, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pfd
 * JD-Core Version:    0.7.0.1
 */