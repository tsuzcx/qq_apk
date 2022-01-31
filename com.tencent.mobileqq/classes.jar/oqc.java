import android.os.Bundle;
import android.os.Handler;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager.SlideItemInfo;
import com.tencent.biz.qqstory.takevideo.slideshow.TransitionHandler;
import com.tencent.biz.qqstory.utils.Image2Video;
import com.tencent.biz.qqstory.utils.ffmpeg.QimSegmentMergeUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.setting.CaptureEntranceParams;
import dov.com.qq.im.setting.CaptureVideoParams;
import dov.com.qq.im.setting.CaptureVideoParams.CaptureVideoParamsBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class oqc
  implements Runnable
{
  public oqc(SlideShowPhotoListManager paramSlideShowPhotoListManager) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SlideShowPhotoListManager", 2, "start combine");
    }
    Object localObject3 = new QimSegmentMergeUtil();
    Object localObject2 = new ArrayList(SlideShowPhotoListManager.a(this.a).size());
    TransitionHandler localTransitionHandler = (TransitionHandler)QQStoryContext.a().getBusinessHandler(1);
    Object localObject1 = SlideShowPhotoListManager.a(this.a).iterator();
    LocalMediaInfo localLocalMediaInfo;
    while (((Iterator)localObject1).hasNext())
    {
      localLocalMediaInfo = localTransitionHandler.a(((SlideShowPhotoListManager.SlideItemInfo)((Iterator)localObject1).next()).a);
      if (localLocalMediaInfo != null) {
        ((List)localObject2).add(localLocalMediaInfo.path);
      }
    }
    if (SlideShowPhotoListManager.a(this.a) == null)
    {
      if (localTransitionHandler.a() == null) {
        break label507;
      }
      SlideShowPhotoListManager.a(this.a, localTransitionHandler.a());
    }
    for (;;)
    {
      localObject1 = SlideShowPhotoListManager.a(this.a);
      boolean bool = ((QimSegmentMergeUtil)localObject3).a((List)localObject2, (String)localObject1, 720, 1280, SlideShowPhotoListManager.a(this.a));
      QLog.i("SlideShowPhotoListManager", 1, "merge video result " + bool);
      localLocalMediaInfo = new LocalMediaInfo();
      localLocalMediaInfo.path = ((String)localObject1);
      localLocalMediaInfo.mMimeType = "video";
      if (AudioHelper.f())
      {
        localLocalMediaInfo.mTransferPosList = ((QimSegmentMergeUtil)localObject3).a((List)localObject2, (String)localObject1);
        localObject3 = MediaScanner.a(BaseApplicationImpl.getContext());
      }
      try
      {
        ((MediaScanner)localObject3).b(localLocalMediaInfo);
        SlideShowPhotoListManager.a(this.a).post(new oqd(this));
        if (bool)
        {
          localObject3 = new CameraCaptureView.VideoCaptureResult();
          ((CameraCaptureView.VideoCaptureResult)localObject3).videoFrameCount = ((List)localObject2).size();
          ((CameraCaptureView.VideoCaptureResult)localObject3).audioDataFilePath = Image2Video.a();
          ((CameraCaptureView.VideoCaptureResult)localObject3).videoMp4FilePath = ((String)localObject1);
          localObject4 = new CaptureVideoParams.CaptureVideoParamsBuilder().a(false).d(true).e(true).f(true).h(true).a();
          localObject2 = new CaptureEntranceParams(10002, 1, 1);
          ((CaptureEntranceParams)localObject2).a((CaptureVideoParams)localObject4);
          localObject4 = new Bundle();
          ((Bundle)localObject4).putBoolean("PhotoConst.IS_FROM_QQSTORY_SLIDESHOW", true);
          ((Bundle)localObject4).putString("PhotoConst.FROM_QQSTORY_SLIDESHOW_DATA", (String)localObject1);
          ((Bundle)localObject4).putInt("extra_transiton_src_from", 1);
          if (!QQStoryContext.a().isBackground_Pause)
          {
            i = 1;
            if (i == 0) {
              break label562;
            }
            SlideShowPhotoListManager.a(this.a).post(new oqe(this, (CameraCaptureView.VideoCaptureResult)localObject3, localLocalMediaInfo, (CaptureEntranceParams)localObject2, (Bundle)localObject4));
            SlideShowPhotoListManager.a(this.a).post(new oqg(this, localTransitionHandler));
            Image2Video.a();
            if (QLog.isColorLevel()) {
              QLog.i("SlideShowPhotoListManager", 2, "combine video result =" + bool);
            }
            return;
            label507:
            SlideShowPhotoListManager.a(this.a, Image2Video.a());
            continue;
            localLocalMediaInfo.mTransferPosList = ((QimSegmentMergeUtil)localObject3).a((List)localObject2);
          }
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Object localObject4;
          localThrowable.printStackTrace();
          QLog.e("SlideShowPhotoListManager", 1, "pic2video err", localThrowable);
          continue;
          int i = 0;
          continue;
          label562:
          SlideShowPhotoListManager.a(this.a, localThrowable);
          SlideShowPhotoListManager.a(this.a, localLocalMediaInfo);
          SlideShowPhotoListManager.a(this.a, (CaptureEntranceParams)localObject2);
          SlideShowPhotoListManager.a(this.a, (Bundle)localObject4);
          SlideShowPhotoListManager.a(this.a, true);
          continue;
          SlideShowPhotoListManager.a(this.a).post(new oqf(this));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oqc
 * JD-Core Version:    0.7.0.1
 */