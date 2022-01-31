package dov.com.tencent.biz.qqstory.takevideo;

import ajed;
import android.os.SystemClock;
import bihz;
import bjho;
import bjhp;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import urk;
import vlm;
import vnb;
import vnc;

class HWEditLocalVideoPlayer$2
  implements Runnable
{
  HWEditLocalVideoPlayer$2(HWEditLocalVideoPlayer paramHWEditLocalVideoPlayer) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Boolean) {}
    Object localObject1;
    int i;
    for (long l1 = 10000L;; l1 = 2147483647L)
    {
      localObject1 = null;
      if (this.this$0.jdField_a_of_type_Boolean) {
        localObject1 = vnb.a(HWEditLocalVideoPlayer.a(this.this$0), l1);
      }
      if (localObject1 != null) {
        break label665;
      }
      localObject1 = new ArrayList();
      i = 0;
      while (i < this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration / l1)
      {
        ((ArrayList)localObject1).add(new vnc(i * l1, l1));
        i += 1;
      }
    }
    label648:
    label665:
    for (;;)
    {
      if (((ArrayList)localObject1).size() <= 0) {
        ((ArrayList)localObject1).add(new vnc(0L, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration));
      }
      long l3 = SystemClock.uptimeMillis();
      i = 0;
      Object localObject2;
      long l4;
      if (i < ((ArrayList)localObject1).size())
      {
        localObject2 = (vnc)((ArrayList)localObject1).get(i);
        l4 = SystemClock.uptimeMillis();
        long l2 = Math.min(((vnc)localObject2).a + ((vnc)localObject2).b, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration);
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
          bihz localbihz = new bihz(i, bjhp.a(HWEditLocalVideoPlayer.a(this.this$0), (int)((vnc)localObject2).a));
          bihz.a(localbihz, ((vnc)localObject2).a);
          bihz.b(localbihz, l1);
          this.this$0.jdField_a_of_type_JavaUtilList.add(localbihz);
          urk.b("Q.qqstory.record.HWEditLocalVideoPlayer", "create fragment info = %s, cost = %dms", localbihz, Long.valueOf(SystemClock.uptimeMillis() - l4));
          if (l1 >= this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration)
          {
            urk.b("Q.qqstory.record.HWEditLocalVideoPlayer", "create fragment info count = %d, cost = %dms", Integer.valueOf(this.this$0.jdField_a_of_type_JavaUtilList.size()), Long.valueOf(SystemClock.uptimeMillis() - l3));
            i = 0;
            if (i >= this.this$0.jdField_a_of_type_JavaUtilList.size()) {
              break label648;
            }
            localObject1 = (bihz)this.this$0.jdField_a_of_type_JavaUtilList.get(i);
            localObject2 = vlm.a(HWEditLocalVideoPlayer.a(this.this$0));
            localObject2 = ajed.bY + (String)localObject2 + "_" + i + ".IFrames.audio";
            HWEditLocalVideoPlayer.a(this.this$0, (String)localObject2);
            j = bjho.a(HWEditLocalVideoPlayer.b(this.this$0), (String)localObject2, (float)bihz.a((bihz)localObject1) * 1.0F / (float)this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration, (float)bihz.b((bihz)localObject1) * 1.0F / (float)this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration);
            if (j != 0) {
              break label584;
            }
            urk.b("Q.qqstory.record.HWEditLocalVideoPlayer", "clipAudioFile finished audioFilePath" + (String)localObject2);
            ((bihz)localObject1).b = ((String)localObject2);
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
        label584:
        urk.e("Q.qqstory.record.HWEditLocalVideoPlayer", "clipAudioFile failed. errcode =%s,  audioFilePath=%s, duration=%s, startTime=%s, endTime=%s", new Object[] { Integer.valueOf(j), localRuntimeException, Long.valueOf(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration), Long.valueOf(bihz.a((bihz)localObject1)), Long.valueOf(bihz.b((bihz)localObject1)) });
      }
      this.this$0.a(new HWEditLocalVideoPlayer.2.1(this), 0L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer.2
 * JD-Core Version:    0.7.0.1
 */