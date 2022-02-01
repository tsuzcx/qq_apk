package dov.com.tencent.biz.qqstory.takevideo;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.SystemClock;
import antf;
import bbgg;
import bqid;
import bqif;
import bqst;
import brgr;
import brgs;
import brgv;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.util.ArrayList;
import java.util.List;
import yuk;
import zoc;
import zom;
import zqb;
import zqc;

public class HWEditImportVideoPlayer$2
  implements Runnable
{
  public HWEditImportVideoPlayer$2(bqid parambqid) {}
  
  public void run()
  {
    yuk.d("Q.qqstory.record.HWEditImportVideoPlayer", "thumb get start");
    if (this.this$0.jdField_a_of_type_Boolean) {}
    Object localObject2;
    int i;
    for (long l1 = 10000L;; l1 = 2147483647L)
    {
      localObject2 = zqb.a(bqid.a(this.this$0), l1);
      if (localObject2 != null) {
        break label954;
      }
      localObject2 = new ArrayList();
      i = 0;
      while (i < this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration / l1)
      {
        ((ArrayList)localObject2).add(new zqc(i * l1, l1));
        i += 1;
      }
    }
    label687:
    label954:
    for (;;)
    {
      if (((ArrayList)localObject2).size() <= 0) {
        ((ArrayList)localObject2).add(new zqc(0L, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration));
      }
      long l3 = SystemClock.uptimeMillis();
      i = 0;
      Object localObject1;
      int j;
      if (i < ((ArrayList)localObject2).size())
      {
        localObject1 = (zqc)((ArrayList)localObject2).get(i);
        long l4 = SystemClock.uptimeMillis();
        long l2 = Math.min(bqid.a(this.this$0) + ((zqc)localObject1).b, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration);
        l1 = l2;
        if (1000L + l2 > this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration) {
          l1 = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration;
        }
        if (i == 5) {
          l1 = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration;
        }
        Object localObject3 = brgs.a(bqid.a(this.this$0), bqid.a(this.this$0));
        localObject1 = localObject3;
        if (i == 0)
        {
          localObject1 = localObject3;
          if (localObject3 != null)
          {
            float f = bqst.a((Bitmap)localObject3);
            yuk.b("Q.qqstory.record.HWEditImportVideoPlayer", "blackPrecent = %f start fix black frame.", Float.valueOf(f));
            localObject1 = localObject3;
            if (f > 0.9F)
            {
              brgv localbrgv = brgs.a(bqid.a(this.this$0), bqid.a(this.this$0));
              localObject1 = localObject3;
              if (localbrgv.jdField_a_of_type_AndroidGraphicsBitmap != null)
              {
                localObject1 = localObject3;
                if (localbrgv.jdField_a_of_type_Long > 0L)
                {
                  localObject1 = localObject3;
                  if (bqst.a(localbrgv.jdField_a_of_type_AndroidGraphicsBitmap) <= 0.9F)
                  {
                    if (!((Bitmap)localObject3).isRecycled()) {
                      ((Bitmap)localObject3).recycle();
                    }
                    localObject1 = localbrgv.jdField_a_of_type_AndroidGraphicsBitmap;
                    bqid.a(this.this$0, (int)(localbrgv.jdField_a_of_type_Long / 1000L));
                    yuk.d("Q.qqstory.record.HWEditImportVideoPlayer", "Fix black frame. adjust star time to " + bqid.a(this.this$0));
                  }
                }
              }
            }
          }
        }
        localObject3 = localObject1;
        if (localObject1 != null)
        {
          j = bbgg.a(((Bitmap)localObject1).getWidth());
          int k = bbgg.a(((Bitmap)localObject1).getHeight());
          if (j == ((Bitmap)localObject1).getWidth())
          {
            localObject3 = localObject1;
            if (k == ((Bitmap)localObject1).getHeight()) {}
          }
          else
          {
            yuk.d("Q.qqstory.record.HWEditImportVideoPlayer", "origin bitmap width:%d, height:%d, should change size to w:%d, h:%d", new Object[] { Integer.valueOf(((Bitmap)localObject1).getWidth()), Integer.valueOf(((Bitmap)localObject1).getHeight()), Integer.valueOf(j), Integer.valueOf(j) });
            localObject3 = zoc.a((Bitmap)localObject1, new Rect(0, 0, j, k), true);
          }
        }
        localObject1 = new bqif(i, (Bitmap)localObject3);
        bqif.a((bqif)localObject1, bqid.a(this.this$0));
        bqif.b((bqif)localObject1, bqid.b(this.this$0));
        this.this$0.jdField_a_of_type_JavaUtilList.add(localObject1);
        yuk.b("Q.qqstory.record.HWEditImportVideoPlayer", "create fragment info = %s, cost = %dms", localObject1, Long.valueOf(SystemClock.uptimeMillis() - l4));
        if (l1 < this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration) {}
      }
      else
      {
        yuk.b("Q.qqstory.record.HWEditImportVideoPlayer", "create fragment info count = %d, cost = %dms", Integer.valueOf(this.this$0.jdField_a_of_type_JavaUtilList.size()), Long.valueOf(SystemClock.uptimeMillis() - l3));
        i = 0;
        if (i >= this.this$0.jdField_a_of_type_JavaUtilList.size()) {
          break label937;
        }
        localObject1 = (bqif)this.this$0.jdField_a_of_type_JavaUtilList.get(i);
        localObject2 = zom.a(bqid.a(this.this$0));
        localObject2 = antf.ck + (String)localObject2 + "_" + i + ".IFrames.audio";
        j = brgr.a(bqid.b(this.this$0), (String)localObject2, (float)bqif.a((bqif)localObject1) * 1.0F / (float)this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration, (float)bqif.b((bqif)localObject1) * 1.0F / (float)this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration);
        if (j != 0) {
          break label873;
        }
        yuk.b("Q.qqstory.record.HWEditImportVideoPlayer", "clipAudioFile finished audioFilePath" + (String)localObject2);
        ((bqif)localObject1).b = ((String)localObject2);
      }
      for (;;)
      {
        i += 1;
        break label687;
        i += 1;
        break;
        label873:
        yuk.e("Q.qqstory.record.HWEditImportVideoPlayer", "clipAudioFile failed. errcode =%s,  audioFilePath=%s, duration=%s, startTime=%s, endTime=%s", new Object[] { Integer.valueOf(j), localObject2, Long.valueOf(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration), Long.valueOf(bqif.a((bqif)localObject1)), Long.valueOf(bqif.b((bqif)localObject1)) });
      }
      this.this$0.a(new HWEditImportVideoPlayer.2.1(this), 0L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.HWEditImportVideoPlayer.2
 * JD-Core Version:    0.7.0.1
 */