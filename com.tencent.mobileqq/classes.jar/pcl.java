import java.util.ArrayList;

class pcl
  extends pcm
{
  pcl(pbe parampbe, int paramInt)
  {
    super(parampbe, null);
  }
  
  void a(pcp parampcp)
  {
    if (parampcp == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Int == 1)
      {
        parampcp.onCommentListLoad(1, false, new ArrayList(), false, 2, 2);
        return;
      }
    } while (this.jdField_a_of_type_Int != 2);
    parampcp.onCommentLoadMore(1, false, new ArrayList(), false, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pcl
 * JD-Core Version:    0.7.0.1
 */