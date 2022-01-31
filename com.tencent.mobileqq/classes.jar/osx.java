import com.tencent.biz.qqstory.utils.Image2Video;
import com.tencent.biz.qqstory.utils.Image2Video.Image2VideoListener;
import com.tencent.biz.qqstory.utils.Image2Video.ResultInfo;

public class osx
  implements Image2Video.Image2VideoListener
{
  public osx(Image2Video paramImage2Video, Image2Video.ResultInfo paramResultInfo) {}
  
  public void a(Image2Video.ResultInfo paramResultInfo)
  {
    synchronized (this.jdField_a_of_type_ComTencentBizQqstoryUtilsImage2Video$ResultInfo)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryUtilsImage2Video$ResultInfo.a(paramResultInfo);
      this.jdField_a_of_type_ComTencentBizQqstoryUtilsImage2Video$ResultInfo.notify();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     osx
 * JD-Core Version:    0.7.0.1
 */