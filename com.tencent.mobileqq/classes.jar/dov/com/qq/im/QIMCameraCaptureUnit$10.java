package dov.com.qq.im;

import agak;
import android.media.MediaFormat;
import bace;
import bhdi;
import bhdj;
import bjlx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import voc;

public class QIMCameraCaptureUnit$10
  implements Runnable
{
  public QIMCameraCaptureUnit$10(bhdi parambhdi, List paramList) {}
  
  public void run()
  {
    voc localvoc = new voc();
    ArrayList localArrayList1 = new ArrayList(this.a.size());
    ArrayList localArrayList2 = new ArrayList(this.a.size());
    this.this$0.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult = new CameraCaptureView.VideoCaptureResult();
    Object localObject1 = this.a.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (CameraCaptureView.VideoCaptureResult)((Iterator)localObject1).next();
      localArrayList1.add(((CameraCaptureView.VideoCaptureResult)localObject2).videoMp4FilePath);
      if (!((CameraCaptureView.VideoCaptureResult)localObject2).audioDataFilePath.endsWith("/noaudio")) {
        localArrayList2.add(((CameraCaptureView.VideoCaptureResult)localObject2).audioDataFilePath);
      }
      CameraCaptureView.VideoCaptureResult localVideoCaptureResult = this.this$0.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult;
      int i = localVideoCaptureResult.videoFrameCount;
      localVideoCaptureResult.videoFrameCount = (((CameraCaptureView.VideoCaptureResult)localObject2).videoFrameCount + i);
    }
    if (this.this$0.a() != null)
    {
      localObject2 = this.this$0.a() + "/" + System.currentTimeMillis() + ".mp4";
      if (localArrayList2.size() != this.a.size()) {
        break label509;
      }
      localObject1 = this.this$0.a() + File.separator + "audio_data_cache" + File.separator + bjlx.a();
      localvoc.a(localArrayList2, (String)localObject1);
      this.this$0.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.audioDataFilePath = ((String)localObject1);
      this.this$0.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.videoMp4FilePath = ((String)localObject2);
      this.this$0.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.type = ((CameraCaptureView.VideoCaptureResult)this.a.get(0)).type;
      this.this$0.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.orientation = ((CameraCaptureView.VideoCaptureResult)this.a.get(0)).orientation;
      bhdi.a(this.this$0, new LocalMediaInfo());
      bhdi.a(this.this$0).path = this.this$0.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.videoMp4FilePath;
      bhdi.a(this.this$0).mMimeType = "video";
      localObject1 = this.this$0.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a();
      if (localObject1 == null) {
        break label562;
      }
      bool = localvoc.a(localArrayList1, (String)localObject2, 0, 0, (MediaFormat)localObject1);
      if (!AudioHelper.f()) {
        break label542;
      }
      bhdi.a(this.this$0).mTransferPosList = localvoc.a(localArrayList1, (String)localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("QIMCameraCaptureUnit", 2, "[segmentCapture] onSegmentVideoCaptured segment video merge result: " + bool);
      }
      agak.a(BaseApplicationImpl.getContext()).a(new bhdj(this), bhdi.a(this.this$0));
    }
    label509:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        boolean bool;
        return;
        localObject1 = this.this$0.a() + "/noaudio";
        bace.c((String)localObject1);
        break;
        bhdi.a(this.this$0).mTransferPosList = localvoc.a(localArrayList1);
      }
    }
    label542:
    label562:
    QLog.e("QIMCameraCaptureUnit", 2, "[segmentCapture]onSegmentVideoCaptured mediaFormat null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.QIMCameraCaptureUnit.10
 * JD-Core Version:    0.7.0.1
 */