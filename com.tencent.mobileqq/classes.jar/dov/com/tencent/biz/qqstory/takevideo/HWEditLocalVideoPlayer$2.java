package dov.com.tencent.biz.qqstory.takevideo;

import android.os.SystemClock;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.biz.qqstory.utils.VideoUtils.VideoKeyFrameFragment;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.mediacodec.utils.AudioDataUtil;
import dov.com.tencent.mobileqq.richmedia.mediacodec.utils.MediaUtil;
import java.util.ArrayList;
import java.util.List;

class HWEditLocalVideoPlayer$2
  implements Runnable
{
  HWEditLocalVideoPlayer$2(HWEditLocalVideoPlayer paramHWEditLocalVideoPlayer) {}
  
  public void run()
  {
    Object localObject1 = new ArrayList();
    int i = 0;
    while (i < this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration / 2147483647L)
    {
      ((ArrayList)localObject1).add(new VideoUtils.VideoKeyFrameFragment(i * 2147483647L, 2147483647L));
      i += 1;
    }
    if (((ArrayList)localObject1).size() <= 0) {
      ((ArrayList)localObject1).add(new VideoUtils.VideoKeyFrameFragment(0L, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration));
    }
    long l3 = SystemClock.uptimeMillis();
    i = 0;
    Object localObject2;
    long l4;
    long l1;
    if (i < ((ArrayList)localObject1).size())
    {
      localObject2 = (VideoUtils.VideoKeyFrameFragment)((ArrayList)localObject1).get(i);
      l4 = SystemClock.uptimeMillis();
      long l2 = Math.min(((VideoUtils.VideoKeyFrameFragment)localObject2).a + ((VideoUtils.VideoKeyFrameFragment)localObject2).b, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration);
      l1 = l2;
      if (1000L + l2 > this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration) {
        l1 = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration;
      }
      if (i == 5) {
        l1 = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration;
      }
    }
    for (;;)
    {
      int j;
      try
      {
        HWEditLocalVideoPlayer.Mp4VideoFragmentInfo localMp4VideoFragmentInfo = new HWEditLocalVideoPlayer.Mp4VideoFragmentInfo(i, MediaUtil.a(HWEditLocalVideoPlayer.a(this.this$0), (int)((VideoUtils.VideoKeyFrameFragment)localObject2).a));
        HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a(localMp4VideoFragmentInfo, ((VideoUtils.VideoKeyFrameFragment)localObject2).a);
        HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.b(localMp4VideoFragmentInfo, l1);
        this.this$0.jdField_a_of_type_JavaUtilList.add(localMp4VideoFragmentInfo);
        SLog.b("Q.qqstory.record.HWEditLocalVideoPlayer", "create fragment info = %s, cost = %dms", localMp4VideoFragmentInfo, Long.valueOf(SystemClock.uptimeMillis() - l4));
        if (l1 >= this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration)
        {
          SLog.b("Q.qqstory.record.HWEditLocalVideoPlayer", "create fragment info count = %d, cost = %dms", Integer.valueOf(this.this$0.jdField_a_of_type_JavaUtilList.size()), Long.valueOf(SystemClock.uptimeMillis() - l3));
          i = 0;
          if (i >= this.this$0.jdField_a_of_type_JavaUtilList.size()) {
            break label592;
          }
          localObject1 = (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)this.this$0.jdField_a_of_type_JavaUtilList.get(i);
          localObject2 = FileUtils.a(HWEditLocalVideoPlayer.a(this.this$0));
          localObject2 = AppConstants.SDCARD_AUDIO_CACHE + (String)localObject2 + "_" + i + ".IFrames.audio";
          j = AudioDataUtil.a(HWEditLocalVideoPlayer.b(this.this$0), (String)localObject2, (float)HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)localObject1) * 1.0F / (float)this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration, (float)HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.b((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)localObject1) * 1.0F / (float)this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration);
          if (j != 0) {
            break label528;
          }
          SLog.b("Q.qqstory.record.HWEditLocalVideoPlayer", "clipAudioFile finished audioFilePath" + (String)localObject2);
          ((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)localObject1).b = ((String)localObject2);
          i += 1;
          continue;
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        QLog.e("Q.qqstory.record.HWEditLocalVideoPlayer", 1, localRuntimeException, new Object[0]);
        continue;
        i += 1;
      }
      break;
      label528:
      SLog.e("Q.qqstory.record.HWEditLocalVideoPlayer", "clipAudioFile failed. errcode =%s,  audioFilePath=%s, duration=%s, startTime=%s, endTime=%s", new Object[] { Integer.valueOf(j), localRuntimeException, Long.valueOf(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration), Long.valueOf(HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)localObject1)), Long.valueOf(HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.b((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)localObject1)) });
    }
    label592:
    this.this$0.a(new HWEditLocalVideoPlayer.2.1(this), 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer.2
 * JD-Core Version:    0.7.0.1
 */