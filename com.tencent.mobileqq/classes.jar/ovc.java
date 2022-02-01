import java.util.ArrayList;

class ovc
  extends ovd
{
  ovc(otv paramotv, int paramInt)
  {
    super(paramotv, null);
  }
  
  void a(ovg paramovg)
  {
    if (paramovg == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Int == 1)
      {
        paramovg.onCommentListLoad(1, false, new ArrayList(), false, 2, 2);
        return;
      }
    } while (this.jdField_a_of_type_Int != 2);
    paramovg.onCommentLoadMore(1, false, new ArrayList(), false, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ovc
 * JD-Core Version:    0.7.0.1
 */