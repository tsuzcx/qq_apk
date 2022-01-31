import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.IPlayVideoStatusChangeListener;
import com.tencent.biz.qqstory.playmode.VideoPlayModeBase;
import com.tencent.biz.qqstory.playvideo.player.IVideoView;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter.VideoViewHolder;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class nja
  extends IPlayVideoStatusChangeListener
{
  public nja(VideoPlayModeBase paramVideoPlayModeBase) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("videolistener_tag", 2, "onStartPlay:" + paramInt);
    }
    this.a.jdField_a_of_type_Long = System.currentTimeMillis();
    this.a.c = this.a.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter$VideoViewHolder.a.b();
    if ((paramInt < 0) || (paramInt >= this.a.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.size())) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.a.b.iterator();
      while (localIterator.hasNext()) {
        ((IPlayVideoStatusChangeListener)localIterator.next()).a(paramInt);
      }
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("videolistener_tag", 2, "onNext:" + paramInt);
    }
    if ((paramInt < 0) || (paramInt >= this.a.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.size())) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.a.b.iterator();
      while (localIterator.hasNext()) {
        ((IPlayVideoStatusChangeListener)localIterator.next()).b(paramInt);
      }
    }
  }
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("videolistener_tag", 2, "onSingleTapNext:" + paramInt);
    }
    if ((paramInt < 0) || (paramInt >= this.a.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.size())) {
      return;
    }
    this.a.a(paramInt, 3);
    Iterator localIterator = this.a.b.iterator();
    while (localIterator.hasNext()) {
      ((IPlayVideoStatusChangeListener)localIterator.next()).c(paramInt);
    }
    this.a.d(paramInt);
  }
  
  public void d(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("videolistener_tag", 2, "onSlideNext:" + paramInt);
    }
    StoryReportor.a("play_video", "clk_next", 0, 0, new String[] { "2", "", "", "" });
    if ((paramInt < 0) || (paramInt >= this.a.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.size())) {
      return;
    }
    this.a.a(paramInt, 3);
    Iterator localIterator = this.a.b.iterator();
    while (localIterator.hasNext()) {
      ((IPlayVideoStatusChangeListener)localIterator.next()).d(paramInt);
    }
    this.a.d(paramInt);
  }
  
  public void e(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("videolistener_tag", 2, "onSlidePrevious:" + paramInt);
    }
    StoryReportor.a("play_video", "clk_previous", 0, 0, new String[] { "", "", "", "" });
    if ((paramInt < 0) || (paramInt >= this.a.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.size())) {
      return;
    }
    this.a.a(paramInt, 3);
    Iterator localIterator = this.a.b.iterator();
    while (localIterator.hasNext()) {
      ((IPlayVideoStatusChangeListener)localIterator.next()).e(paramInt);
    }
    this.a.d(paramInt);
  }
  
  public void f(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("videolistener_tag", 2, "onClickClose:" + paramInt);
    }
    if ((paramInt < 0) || (paramInt >= this.a.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.size()))
    {
      StoryReportor.a("play_video", "clk_quit", 0, 0, new String[] { "", "", "", "" });
      return;
    }
    Object localObject = (StoryVideoItem)this.a.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.get(paramInt);
    this.a.a(paramInt, 2);
    StoryReportor.a("play_video", "clk_quit", 0, 0, new String[] { "", "", "", ((StoryVideoItem)localObject).mVid });
    localObject = this.a.b.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IPlayVideoStatusChangeListener)((Iterator)localObject).next()).f(paramInt);
    }
    this.a.d(paramInt);
  }
  
  public void g(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("videolistener_tag", 2, "onSlideClose:" + paramInt);
    }
    if ((paramInt < 0) || (paramInt >= this.a.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.size()))
    {
      StoryReportor.a("play_video", "slide_quit", 0, 0, new String[] { "", "", "", "" });
      return;
    }
    Object localObject = (StoryVideoItem)this.a.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.get(paramInt);
    this.a.a(paramInt, 2);
    StoryReportor.a("play_video", "slide_quit", 0, 0, new String[] { "", "", "", ((StoryVideoItem)localObject).mVid });
    localObject = this.a.b.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IPlayVideoStatusChangeListener)((Iterator)localObject).next()).g(paramInt);
    }
    this.a.d(paramInt);
  }
  
  public void h(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("videolistener_tag", 2, "onPlayEndClose:" + paramInt);
    }
    if ((paramInt < 0) || (paramInt >= this.a.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.size())) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.a.b.iterator();
      while (localIterator.hasNext()) {
        ((IPlayVideoStatusChangeListener)localIterator.next()).h(paramInt);
      }
    }
  }
  
  public void i(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("videolistener_tag", 2, "onPlayComplete:" + paramInt);
    }
    if ((paramInt < 0) || (paramInt >= this.a.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.size())) {
      return;
    }
    this.a.a(paramInt, 1);
    Iterator localIterator = this.a.b.iterator();
    while (localIterator.hasNext()) {
      ((IPlayVideoStatusChangeListener)localIterator.next()).i(paramInt);
    }
    this.a.d(paramInt);
    StoryReportor.c("video_ope", "play_finish", 0, 0, new String[] { "", "", "", ((StoryVideoItem)this.a.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.get(paramInt)).mVid });
  }
  
  public void j(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("videolistener_tag", 2, "onPressBackKeyClose:" + paramInt);
    }
    if ((paramInt < 0) || (paramInt >= this.a.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.size())) {
      return;
    }
    this.a.a(paramInt, 2);
    Iterator localIterator = this.a.b.iterator();
    while (localIterator.hasNext()) {
      ((IPlayVideoStatusChangeListener)localIterator.next()).j(paramInt);
    }
    this.a.d(paramInt);
  }
  
  public void k(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("videolistener_tag", 2, "onPause:" + paramInt);
    }
    if ((paramInt < 0) || (paramInt >= this.a.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.size())) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.a.b.iterator();
      while (localIterator.hasNext()) {
        ((IPlayVideoStatusChangeListener)localIterator.next()).k(paramInt);
      }
    }
  }
  
  public void l(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("videolistener_tag", 2, "onResume:" + paramInt);
    }
    if ((paramInt < 0) || (paramInt >= this.a.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.size())) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.a.b.iterator();
      while (localIterator.hasNext()) {
        ((IPlayVideoStatusChangeListener)localIterator.next()).l(paramInt);
      }
    }
  }
  
  public void m(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("videolistener_tag", 2, "onRemoveCover:" + paramInt);
    }
    if ((paramInt < 0) || (paramInt >= this.a.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.size())) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.a.b.iterator();
      while (localIterator.hasNext()) {
        ((IPlayVideoStatusChangeListener)localIterator.next()).m(paramInt);
      }
    }
  }
  
  public void n(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("videolistener_tag", 2, "onRestart:" + paramInt);
    }
    if ((paramInt < 0) || (paramInt >= this.a.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.size())) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.a.b.iterator();
      while (localIterator.hasNext()) {
        ((IPlayVideoStatusChangeListener)localIterator.next()).n(paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nja
 * JD-Core Version:    0.7.0.1
 */