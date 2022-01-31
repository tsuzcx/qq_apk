import android.text.TextUtils;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.playmode.child.MsgTabPlayMode;
import com.tencent.biz.qqstory.playvideo.ProgressControler;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;
import java.util.ArrayList;

public class nju
  implements Runnable
{
  public nju(MsgTabPlayMode paramMsgTabPlayMode, boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildMsgTabPlayMode.e = false;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildMsgTabPlayMode.g();
      return;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    for (Object localObject = this.b;; localObject = this.jdField_a_of_type_JavaLangString)
    {
      int i = this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildMsgTabPlayMode.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.a.a();
      if ((TextUtils.equals((CharSequence)localObject, this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildMsgTabPlayMode.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildMsgTabPlayMode.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.size() > 0) && (i > 1) && (i == this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildMsgTabPlayMode.j))
      {
        localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildMsgTabPlayMode.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.a;
        MsgTabPlayMode localMsgTabPlayMode = this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildMsgTabPlayMode;
        i = localMsgTabPlayMode.j - 1;
        localMsgTabPlayMode.j = i;
        ((ProgressControler)localObject).a(i);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildMsgTabPlayMode.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.setCurrentItem(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildMsgTabPlayMode.b, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nju
 * JD-Core Version:    0.7.0.1
 */