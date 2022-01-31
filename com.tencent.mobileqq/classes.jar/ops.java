import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;

class ops
  implements Runnable
{
  ops(opr paramopr) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.b = false;
    if (!this.a.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.c) {
      StoryVideoPlayer.a(this.a.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer, this.a.jdField_a_of_type_AndroidOsBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ops
 * JD-Core Version:    0.7.0.1
 */