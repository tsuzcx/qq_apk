package dov.com.tencent.biz.qqstory.takevideo;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.SystemClock;
import bbhm;
import bous;
import bouu;
import bpdt;
import bpqa;
import bpqb;
import bpqe;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import java.util.ArrayList;
import java.util.List;
import ykq;
import zdr;
import zeb;
import zfl;
import zfm;

public class HWEditImportVideoPlayer$2
  implements Runnable
{
  public HWEditImportVideoPlayer$2(bous parambous) {}
  
  public void run()
  {
    ykq.d("Q.qqstory.record.HWEditImportVideoPlayer", "thumb get start");
    Object localObject2 = zfl.a(bous.a(this.this$0), 2147483647L);
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
        ((ArrayList)localObject1).add(new zfm(i * 2147483647L, 2147483647L));
        i += 1;
      }
    }
    if (((ArrayList)localObject2).size() <= 0) {
      ((ArrayList)localObject2).add(new zfm(0L, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration));
    }
    long l3 = SystemClock.uptimeMillis();
    int i = 0;
    int j;
    if (i < ((ArrayList)localObject2).size())
    {
      localObject1 = (zfm)((ArrayList)localObject2).get(i);
      long l4 = SystemClock.uptimeMillis();
      long l2 = Math.min(bous.a(this.this$0) + ((zfm)localObject1).b, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration);
      long l1 = l2;
      if (1000L + l2 > this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration) {
        l1 = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration;
      }
      if (i == 5) {
        l1 = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration;
      }
      Object localObject3 = bpqb.a(bous.a(this.this$0), bous.a(this.this$0));
      localObject1 = localObject3;
      if (i == 0)
      {
        localObject1 = localObject3;
        if (localObject3 != null)
        {
          float f = bpdt.a((Bitmap)localObject3);
          ykq.b("Q.qqstory.record.HWEditImportVideoPlayer", "blackPrecent = %f start fix black frame.", Float.valueOf(f));
          localObject1 = localObject3;
          if (f > 0.9F)
          {
            bpqe localbpqe = bpqb.a(bous.a(this.this$0), bous.a(this.this$0));
            localObject1 = localObject3;
            if (localbpqe.jdField_a_of_type_AndroidGraphicsBitmap != null)
            {
              localObject1 = localObject3;
              if (localbpqe.jdField_a_of_type_Long > 0L)
              {
                localObject1 = localObject3;
                if (bpdt.a(localbpqe.jdField_a_of_type_AndroidGraphicsBitmap) <= 0.9F)
                {
                  if (!((Bitmap)localObject3).isRecycled()) {
                    ((Bitmap)localObject3).recycle();
                  }
                  localObject1 = localbpqe.jdField_a_of_type_AndroidGraphicsBitmap;
                  bous.a(this.this$0, (int)(localbpqe.jdField_a_of_type_Long / 1000L));
                  ykq.d("Q.qqstory.record.HWEditImportVideoPlayer", "Fix black frame. adjust star time to " + bous.a(this.this$0));
                }
              }
            }
          }
        }
      }
      localObject3 = localObject1;
      if (localObject1 != null)
      {
        j = bbhm.a(((Bitmap)localObject1).getWidth());
        int k = bbhm.a(((Bitmap)localObject1).getHeight());
        if (j == ((Bitmap)localObject1).getWidth())
        {
          localObject3 = localObject1;
          if (k == ((Bitmap)localObject1).getHeight()) {}
        }
        else
        {
          ykq.d("Q.qqstory.record.HWEditImportVideoPlayer", "origin bitmap width:%d, height:%d, should change size to w:%d, h:%d", new Object[] { Integer.valueOf(((Bitmap)localObject1).getWidth()), Integer.valueOf(((Bitmap)localObject1).getHeight()), Integer.valueOf(j), Integer.valueOf(j) });
          localObject3 = zdr.a((Bitmap)localObject1, new Rect(0, 0, j, k), true);
        }
      }
      localObject1 = new bouu(i, (Bitmap)localObject3);
      bouu.a((bouu)localObject1, bous.a(this.this$0));
      bouu.b((bouu)localObject1, bous.b(this.this$0));
      this.this$0.jdField_a_of_type_JavaUtilList.add(localObject1);
      ykq.b("Q.qqstory.record.HWEditImportVideoPlayer", "create fragment info = %s, cost = %dms", localObject1, Long.valueOf(SystemClock.uptimeMillis() - l4));
      if (l1 < this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration) {}
    }
    else
    {
      ykq.b("Q.qqstory.record.HWEditImportVideoPlayer", "create fragment info count = %d, cost = %dms", Integer.valueOf(this.this$0.jdField_a_of_type_JavaUtilList.size()), Long.valueOf(SystemClock.uptimeMillis() - l3));
      i = 0;
      label672:
      if (i >= this.this$0.jdField_a_of_type_JavaUtilList.size()) {
        break label922;
      }
      localObject1 = (bouu)this.this$0.jdField_a_of_type_JavaUtilList.get(i);
      localObject2 = zeb.a(bous.a(this.this$0));
      localObject2 = AppConstants.SDCARD_AUDIO_CACHE + (String)localObject2 + "_" + i + ".IFrames.audio";
      j = bpqa.a(bous.b(this.this$0), (String)localObject2, (float)bouu.a((bouu)localObject1) * 1.0F / (float)this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration, (float)bouu.b((bouu)localObject1) * 1.0F / (float)this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration);
      if (j != 0) {
        break label858;
      }
      ykq.b("Q.qqstory.record.HWEditImportVideoPlayer", "clipAudioFile finished audioFilePath" + (String)localObject2);
      ((bouu)localObject1).b = ((String)localObject2);
    }
    for (;;)
    {
      i += 1;
      break label672;
      i += 1;
      break;
      label858:
      ykq.e("Q.qqstory.record.HWEditImportVideoPlayer", "clipAudioFile failed. errcode =%s,  audioFilePath=%s, duration=%s, startTime=%s, endTime=%s", new Object[] { Integer.valueOf(j), localObject2, Long.valueOf(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration), Long.valueOf(bouu.a((bouu)localObject1)), Long.valueOf(bouu.b((bouu)localObject1)) });
    }
    label922:
    this.this$0.a(new HWEditImportVideoPlayer.2.1(this), 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.HWEditImportVideoPlayer.2
 * JD-Core Version:    0.7.0.1
 */