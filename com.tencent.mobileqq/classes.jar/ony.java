import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;

class ony
  implements Runnable
{
  ony(onx paramonx) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.b = false;
    if (!this.a.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.c) {
      StoryVideoPlayer.a(this.a.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer, this.a.jdField_a_of_type_AndroidOsBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ony
 * JD-Core Version:    0.7.0.1
 */