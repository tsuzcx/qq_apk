import com.tencent.biz.qqstory.playmode.child.MsgTabPlayMode;
import com.tencent.biz.qqstory.playmode.util.MsgTabVideoDataProvider.MsgTabVideoDataEvent;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class noc
  implements Runnable
{
  public noc(MsgTabPlayMode paramMsgTabPlayMode, MsgTabVideoDataProvider.MsgTabVideoDataEvent paramMsgTabVideoDataEvent) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildMsgTabPlayMode.e = false;
    if (QLog.isColorLevel()) {
      QLog.d("wyx", 2, new Object[] { "before current setCurrentItem index=", Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMsgTabVideoDataProvider$MsgTabVideoDataEvent.jdField_a_of_type_Int), ", mCurrentIndex=", Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildMsgTabPlayMode.jdField_b_of_type_Int) });
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildMsgTabPlayMode.a.setCurrentItem(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMsgTabVideoDataProvider$MsgTabVideoDataEvent.jdField_a_of_type_Int, false);
    if ((!this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMsgTabVideoDataProvider$MsgTabVideoDataEvent.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMsgTabVideoDataProvider$MsgTabVideoDataEvent.jdField_a_of_type_JavaUtilList.isEmpty())) {
      MsgTabPlayMode.a(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildMsgTabPlayMode, this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMsgTabVideoDataProvider$MsgTabVideoDataEvent);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildMsgTabPlayMode.a(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildMsgTabPlayMode.jdField_b_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo, true);
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildMsgTabPlayMode.a(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildMsgTabPlayMode.c, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     noc
 * JD-Core Version:    0.7.0.1
 */