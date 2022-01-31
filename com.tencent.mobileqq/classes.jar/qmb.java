import com.tencent.biz.pubaccount.VideoInfo;
import java.util.List;

class qmb
  extends pxo<VideoInfo>
{
  qmb(qma paramqma) {}
  
  public int a()
  {
    return 1;
  }
  
  protected List<VideoInfo> a()
  {
    return qma.a(this.a);
  }
  
  protected qig a(VideoInfo paramVideoInfo)
  {
    return new qig(paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, paramVideoInfo.jdField_a_of_type_Int, paramVideoInfo.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qmb
 * JD-Core Version:    0.7.0.1
 */