import com.tencent.biz.qqstory.playmode.util.MultiGroupVideoDataProvider;
import com.tencent.biz.qqstory.playmode.util.MultiGroupVideoDataProvider.DataObserver;
import com.tencent.biz.qqstory.playmode.util.VideoData;
import java.util.ArrayList;

public class nra
  implements Runnable
{
  public nra(MultiGroupVideoDataProvider paramMultiGroupVideoDataProvider, VideoData paramVideoData) {}
  
  public void run()
  {
    int i = 0;
    try
    {
      while (i < this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMultiGroupVideoDataProvider.c.size())
      {
        ((MultiGroupVideoDataProvider.DataObserver)this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMultiGroupVideoDataProvider.c.get(i)).a(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilVideoData);
        i += 1;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nra
 * JD-Core Version:    0.7.0.1
 */