import java.util.ArrayList;

class otz
  extends ovd
{
  otz(otv paramotv, int paramInt)
  {
    super(paramotv, null);
  }
  
  void a(ovg paramovg)
  {
    if (this.jdField_a_of_type_Int == 1) {
      paramovg.onCommentListLoad(2, false, new ArrayList(), false, 4, 4);
    }
    while (this.jdField_a_of_type_Int != 2) {
      return;
    }
    paramovg.onCommentLoadMore(2, false, new ArrayList(), false, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     otz
 * JD-Core Version:    0.7.0.1
 */