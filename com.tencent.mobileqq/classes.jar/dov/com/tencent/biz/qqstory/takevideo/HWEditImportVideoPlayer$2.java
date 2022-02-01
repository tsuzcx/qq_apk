package dov.com.tencent.biz.qqstory.takevideo;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.SystemClock;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.biz.qqstory.utils.VideoUtils;
import com.tencent.biz.qqstory.utils.VideoUtils.VideoKeyFrameFragment;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import dov.com.tencent.biz.qqstory.takevideo.localmedia.demos.MediaCodecThumbnailGenerator;
import dov.com.tencent.mobileqq.richmedia.mediacodec.utils.AudioDataUtil;
import dov.com.tencent.mobileqq.richmedia.mediacodec.utils.MediaUtil;
import dov.com.tencent.mobileqq.richmedia.mediacodec.utils.MediaUtil.FrameWithoutBlackResult;
import java.util.ArrayList;
import java.util.List;

class HWEditImportVideoPlayer$2
  implements Runnable
{
  HWEditImportVideoPlayer$2(HWEditImportVideoPlayer paramHWEditImportVideoPlayer) {}
  
  public void run()
  {
    SLog.d("Q.qqstory.record.HWEditImportVideoPlayer", "thumb get start");
    Object localObject2 = VideoUtils.a(HWEditImportVideoPlayer.a(this.this$0), 2147483647L);
    Object localObject1;
    if (localObject2 == null)
    {
      localObject1 = new ArrayList();
      i = 0;
      for (;;)
      {
        localObject2 = localObject1;
        if (i >= this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration / 2147483647L) {
          break;
        }
        ((ArrayList)localObject1).add(new VideoUtils.VideoKeyFrameFragment(i * 2147483647L, 2147483647L));
        i += 1;
      }
    }
    if (((ArrayList)localObject2).size() <= 0) {
      ((ArrayList)localObject2).add(new VideoUtils.VideoKeyFrameFragment(0L, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration));
    }
    long l3 = SystemClock.uptimeMillis();
    int i = 0;
    int j;
    if (i < ((ArrayList)localObject2).size())
    {
      localObject1 = (VideoUtils.VideoKeyFrameFragment)((ArrayList)localObject2).get(i);
      long l4 = SystemClock.uptimeMillis();
      long l2 = Math.min(HWEditImportVideoPlayer.a(this.this$0) + ((VideoUtils.VideoKeyFrameFragment)localObject1).b, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration);
      long l1 = l2;
      if (1000L + l2 > this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration) {
        l1 = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration;
      }
      if (i == 5) {
        l1 = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration;
      }
      Object localObject3 = MediaUtil.a(HWEditImportVideoPlayer.a(this.this$0), HWEditImportVideoPlayer.a(this.this$0));
      localObject1 = localObject3;
      if (i == 0)
      {
        localObject1 = localObject3;
        if (localObject3 != null)
        {
          float f = MediaCodecThumbnailGenerator.a((Bitmap)localObject3);
          SLog.b("Q.qqstory.record.HWEditImportVideoPlayer", "blackPrecent = %f start fix black frame.", Float.valueOf(f));
          localObject1 = localObject3;
          if (f > 0.9F)
          {
            MediaUtil.FrameWithoutBlackResult localFrameWithoutBlackResult = MediaUtil.a(HWEditImportVideoPlayer.a(this.this$0), HWEditImportVideoPlayer.a(this.this$0));
            localObject1 = localObject3;
            if (localFrameWithoutBlackResult.jdField_a_of_type_AndroidGraphicsBitmap != null)
            {
              localObject1 = localObject3;
              if (localFrameWithoutBlackResult.jdField_a_of_type_Long > 0L)
              {
                localObject1 = localObject3;
                if (MediaCodecThumbnailGenerator.a(localFrameWithoutBlackResult.jdField_a_of_type_AndroidGraphicsBitmap) <= 0.9F)
                {
                  if (!((Bitmap)localObject3).isRecycled()) {
                    ((Bitmap)localObject3).recycle();
                  }
                  localObject1 = localFrameWithoutBlackResult.jdField_a_of_type_AndroidGraphicsBitmap;
                  HWEditImportVideoPlayer.a(this.this$0, (int)(localFrameWithoutBlackResult.jdField_a_of_type_Long / 1000L));
                  SLog.d("Q.qqstory.record.HWEditImportVideoPlayer", "Fix black frame. adjust star time to " + HWEditImportVideoPlayer.a(this.this$0));
                }
              }
            }
          }
        }
      }
      localObject3 = localObject1;
      if (localObject1 != null)
      {
        j = CaptureUtil.a(((Bitmap)localObject1).getWidth());
        int k = CaptureUtil.a(((Bitmap)localObject1).getHeight());
        if (j == ((Bitmap)localObject1).getWidth())
        {
          localObject3 = localObject1;
          if (k == ((Bitmap)localObject1).getHeight()) {}
        }
        else
        {
          SLog.d("Q.qqstory.record.HWEditImportVideoPlayer", "origin bitmap width:%d, height:%d, should change size to w:%d, h:%d", new Object[] { Integer.valueOf(((Bitmap)localObject1).getWidth()), Integer.valueOf(((Bitmap)localObject1).getHeight()), Integer.valueOf(j), Integer.valueOf(j) });
          localObject3 = BitmapUtils.a((Bitmap)localObject1, new Rect(0, 0, j, k), true);
        }
      }
      localObject1 = new HWEditImportVideoPlayer.Mp4VideoFragmentInfo(i, (Bitmap)localObject3);
      HWEditImportVideoPlayer.Mp4VideoFragmentInfo.a((HWEditImportVideoPlayer.Mp4VideoFragmentInfo)localObject1, HWEditImportVideoPlayer.a(this.this$0));
      HWEditImportVideoPlayer.Mp4VideoFragmentInfo.b((HWEditImportVideoPlayer.Mp4VideoFragmentInfo)localObject1, HWEditImportVideoPlayer.b(this.this$0));
      this.this$0.jdField_a_of_type_JavaUtilList.add(localObject1);
      SLog.b("Q.qqstory.record.HWEditImportVideoPlayer", "create fragment info = %s, cost = %dms", localObject1, Long.valueOf(SystemClock.uptimeMillis() - l4));
      if (l1 < this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration) {}
    }
    else
    {
      SLog.b("Q.qqstory.record.HWEditImportVideoPlayer", "create fragment info count = %d, cost = %dms", Integer.valueOf(this.this$0.jdField_a_of_type_JavaUtilList.size()), Long.valueOf(SystemClock.uptimeMillis() - l3));
      i = 0;
      label672:
      if (i >= this.this$0.jdField_a_of_type_JavaUtilList.size()) {
        break label922;
      }
      localObject1 = (HWEditImportVideoPlayer.Mp4VideoFragmentInfo)this.this$0.jdField_a_of_type_JavaUtilList.get(i);
      localObject2 = FileUtils.a(HWEditImportVideoPlayer.a(this.this$0));
      localObject2 = AppConstants.SDCARD_AUDIO_CACHE + (String)localObject2 + "_" + i + ".IFrames.audio";
      j = AudioDataUtil.a(HWEditImportVideoPlayer.b(this.this$0), (String)localObject2, (float)HWEditImportVideoPlayer.Mp4VideoFragmentInfo.a((HWEditImportVideoPlayer.Mp4VideoFragmentInfo)localObject1) * 1.0F / (float)this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration, (float)HWEditImportVideoPlayer.Mp4VideoFragmentInfo.b((HWEditImportVideoPlayer.Mp4VideoFragmentInfo)localObject1) * 1.0F / (float)this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration);
      if (j != 0) {
        break label858;
      }
      SLog.b("Q.qqstory.record.HWEditImportVideoPlayer", "clipAudioFile finished audioFilePath" + (String)localObject2);
      ((HWEditImportVideoPlayer.Mp4VideoFragmentInfo)localObject1).b = ((String)localObject2);
    }
    for (;;)
    {
      i += 1;
      break label672;
      i += 1;
      break;
      label858:
      SLog.e("Q.qqstory.record.HWEditImportVideoPlayer", "clipAudioFile failed. errcode =%s,  audioFilePath=%s, duration=%s, startTime=%s, endTime=%s", new Object[] { Integer.valueOf(j), localObject2, Long.valueOf(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration), Long.valueOf(HWEditImportVideoPlayer.Mp4VideoFragmentInfo.a((HWEditImportVideoPlayer.Mp4VideoFragmentInfo)localObject1)), Long.valueOf(HWEditImportVideoPlayer.Mp4VideoFragmentInfo.b((HWEditImportVideoPlayer.Mp4VideoFragmentInfo)localObject1)) });
    }
    label922:
    this.this$0.a(new HWEditImportVideoPlayer.2.1(this), 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.HWEditImportVideoPlayer.2
 * JD-Core Version:    0.7.0.1
 */