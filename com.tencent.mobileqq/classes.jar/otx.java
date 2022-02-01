import java.util.ArrayList;

class otx
  extends ovd
{
  otx(otv paramotv, int paramInt)
  {
    super(paramotv, null);
  }
  
  void a(ovg paramovg)
  {
    if (this.jdField_a_of_type_Int == 1) {
      paramovg.onCommentListLoad(1, false, new ArrayList(), false, 3, 3);
    }
    while (this.jdField_a_of_type_Int != 2) {
      return;
    }
    paramovg.onCommentLoadMore(1, false, new ArrayList(), false, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     otx
 * JD-Core Version:    0.7.0.1
 */