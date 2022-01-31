package com.tencent.mobileqq.richmedia.segment;

import android.app.Activity;
import android.media.MediaFormat;
import android.os.Bundle;
import avre;
import awbd;
import axrl;
import bbdj;
import blbn;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class SegmentManager$2
  implements Runnable
{
  public SegmentManager$2(awbd paramawbd, MediaFormat paramMediaFormat) {}
  
  public void run()
  {
    boolean bool = false;
    long l1 = System.currentTimeMillis();
    long l3 = awbd.a(this.this$0) - awbd.b(this.this$0);
    long l4 = awbd.c(this.this$0) - awbd.b(this.this$0);
    if (QLog.isColorLevel()) {
      QLog.d("SegmentManager", 2, "combineVideo,encodeVideoTime:" + l3 + " encodeAudioTime:" + l4);
    }
    Object localObject = this.this$0.b();
    int j;
    if (awbd.b(this.this$0).equals("AUDIO_PROBLEM"))
    {
      bbdj.d(awbd.c(this.this$0), (String)localObject);
      awbd.a(this.this$0, false);
      localObject = awbd.a(this.this$0);
      i = this.a.getInteger("width");
      j = this.a.getInteger("height");
      ((Bundle)localObject).putInt("video_slice_width", i);
      ((Bundle)localObject).putInt("video_slice_height", j);
      ((Bundle)localObject).putLong("video_duration", awbd.d(this.this$0));
      this.this$0.jdField_a_of_type_Avre.a(203, -1, (Bundle)localObject);
      bool = true;
      if (bool) {
        this.this$0.jdField_a_of_type_JavaUtilHashMap.put("param_succ_flag", "1");
      }
      axrl.a(BaseApplication.getContext()).a(null, "LightVideoEncode", bool, l1 - awbd.b(this.this$0), awbd.d(this.this$0), this.this$0.jdField_a_of_type_JavaUtilHashMap, null);
      ((Activity)this.this$0.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.getContext()).finish();
      return;
    }
    int i = blbn.a(awbd.c(this.this$0), awbd.b(this.this$0), (String)localObject, 0);
    if (i != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SegmentManager", 2, "HwVideoMerge.merge failed:" + i);
      }
      this.this$0.b();
      this.this$0.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(i));
    }
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("SegmentManager", 2, "combineVideo,timeCombineDone:" + (l2 - l1) + " timeFinish:" + (l2 - awbd.b(this.this$0)));
      }
      this.this$0.jdField_a_of_type_JavaUtilHashMap.put("param_combine_time", String.valueOf(l2 - l1));
      this.this$0.jdField_a_of_type_JavaUtilHashMap.put("param_video_time", String.valueOf(l3));
      this.this$0.jdField_a_of_type_JavaUtilHashMap.put("param_audio_time", String.valueOf(l4));
      l1 = l2;
      break;
      localObject = awbd.a(this.this$0);
      i = this.a.getInteger("width");
      j = this.a.getInteger("height");
      ((Bundle)localObject).putInt("video_slice_width", i);
      ((Bundle)localObject).putInt("video_slice_height", j);
      ((Bundle)localObject).putLong("video_duration", awbd.d(this.this$0));
      this.this$0.jdField_a_of_type_Avre.a(203, -1, (Bundle)localObject);
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.segment.SegmentManager.2
 * JD-Core Version:    0.7.0.1
 */