import com.tencent.biz.qqstory.playmode.child.VidListPlayMode;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;

public class nmc
  implements Runnable
{
  public nmc(VidListPlayMode paramVidListPlayMode, boolean paramBoolean) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildVidListPlayMode.e = false;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildVidListPlayMode.g();
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildVidListPlayMode.a.setCurrentItem(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildVidListPlayMode.b, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nmc
 * JD-Core Version:    0.7.0.1
 */