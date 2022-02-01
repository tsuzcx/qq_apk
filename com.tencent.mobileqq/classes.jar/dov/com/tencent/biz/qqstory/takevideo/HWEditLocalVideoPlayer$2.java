package dov.com.tencent.biz.qqstory.takevideo;

import android.os.SystemClock;
import boux;
import bpqa;
import bpqb;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import ykq;
import zeb;
import zfm;

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
      ((ArrayList)localObject1).add(new zfm(i * 2147483647L, 2147483647L));
      i += 1;
    }
    if (((ArrayList)localObject1).size() <= 0) {
      ((ArrayList)localObject1).add(new zfm(0L, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration));
    }
    long l3 = SystemClock.uptimeMillis();
    i = 0;
    Object localObject2;
    long l4;
    long l1;
    if (i < ((ArrayList)localObject1).size())
    {
      localObject2 = (zfm)((ArrayList)localObject1).get(i);
      l4 = SystemClock.uptimeMillis();
      long l2 = Math.min(((zfm)localObject2).a + ((zfm)localObject2).b, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration);
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
        boux localboux = new boux(i, bpqb.a(HWEditLocalVideoPlayer.a(this.this$0), (int)((zfm)localObject2).a));
        boux.a(localboux, ((zfm)localObject2).a);
        boux.b(localboux, l1);
        this.this$0.jdField_a_of_type_JavaUtilList.add(localboux);
        ykq.b("Q.qqstory.record.HWEditLocalVideoPlayer", "create fragment info = %s, cost = %dms", localboux, Long.valueOf(SystemClock.uptimeMillis() - l4));
        if (l1 >= this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration)
        {
          ykq.b("Q.qqstory.record.HWEditLocalVideoPlayer", "create fragment info count = %d, cost = %dms", Integer.valueOf(this.this$0.jdField_a_of_type_JavaUtilList.size()), Long.valueOf(SystemClock.uptimeMillis() - l3));
          i = 0;
          if (i >= this.this$0.jdField_a_of_type_JavaUtilList.size()) {
            break label592;
          }
          localObject1 = (boux)this.this$0.jdField_a_of_type_JavaUtilList.get(i);
          localObject2 = zeb.a(HWEditLocalVideoPlayer.a(this.this$0));
          localObject2 = AppConstants.SDCARD_AUDIO_CACHE + (String)localObject2 + "_" + i + ".IFrames.audio";
          j = bpqa.a(HWEditLocalVideoPlayer.b(this.this$0), (String)localObject2, (float)boux.a((boux)localObject1) * 1.0F / (float)this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration, (float)boux.b((boux)localObject1) * 1.0F / (float)this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration);
          if (j != 0) {
            break label528;
          }
          ykq.b("Q.qqstory.record.HWEditLocalVideoPlayer", "clipAudioFile finished audioFilePath" + (String)localObject2);
          ((boux)localObject1).b = ((String)localObject2);
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
      ykq.e("Q.qqstory.record.HWEditLocalVideoPlayer", "clipAudioFile failed. errcode =%s,  audioFilePath=%s, duration=%s, startTime=%s, endTime=%s", new Object[] { Integer.valueOf(j), localRuntimeException, Long.valueOf(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration), Long.valueOf(boux.a((boux)localObject1)), Long.valueOf(boux.b((boux)localObject1)) });
    }
    label592:
    this.this$0.a(new HWEditLocalVideoPlayer.2.1(this), 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer.2
 * JD-Core Version:    0.7.0.1
 */