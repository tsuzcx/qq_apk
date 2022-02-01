package dov.com.tencent.biz.qqstory.takevideo;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.slideshow.Image2Video;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.utils.VideoUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener;
import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferData;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QQFilterRenderManagerHolder;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.music.QimMusicPlayer;
import dov.com.qq.im.capture.util.CaptureFreqMonitor;
import dov.com.qq.im.capture.view.MusicProviderView;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import dov.com.tencent.mobileqq.richmedia.mediacodec.encoder.Mp4ReEncoder;
import dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.FilterFactory;
import dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUBitmapImageRender;
import dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUImagePixelationFilter;
import dov.com.tencent.mobileqq.richmedia.mediacodec.utils.MediaUtil;
import dov.com.tencent.mobileqq.richmedia.mediacodec.widget.HWVideoPlayView.HWVideoPlayViewListener;
import dov.com.tencent.mobileqq.richmedia.mediacodec.widget.VideoFilterPlayView;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class HWEditLocalVideoPlayer
  extends EditVideoPart
  implements Handler.Callback, HWDecodeListener, EditVideoPlayerExport, HWVideoPlayView.HWVideoPlayViewListener
{
  protected int a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  protected LocalMediaInfo a;
  private HWEditLocalVideoPlayer.ConvertIFramesRunnable jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable;
  private Mp4ReEncoder jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecEncoderMp4ReEncoder;
  protected VideoFilterPlayView a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new HWEditLocalVideoPlayer.4(this);
  private String jdField_a_of_type_JavaLangString;
  protected List<HWEditLocalVideoPlayer.Mp4VideoFragmentInfo> a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private Handler jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
  private String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = false;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = true;
  
  public HWEditLocalVideoPlayer(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_Int = 0;
  }
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      return 0;
    case 1: 
      return 5;
    case 2: 
      return 1;
    case 3: 
      return 2;
    case 8: 
      return 3;
    }
    return 4;
  }
  
  private Bitmap a(@NonNull HWEditLocalVideoPlayer.Mp4VideoFragmentInfo paramMp4VideoFragmentInfo, boolean paramBoolean)
  {
    long l1 = 0L;
    Object localObject1 = HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a(paramMp4VideoFragmentInfo);
    long l2 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.c() / 1000000L;
    Object localObject2;
    if ((l2 != 0L) && (paramBoolean))
    {
      localObject2 = MediaUtil.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo, l2);
      if (localObject2 == null) {}
    }
    for (;;)
    {
      if (localObject2 == null)
      {
        localObject2 = null;
        return localObject2;
      }
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation;
      localObject1 = localObject2;
      if (i != 0) {
        localObject1 = UIUtils.a((Bitmap)localObject2, 360 - i);
      }
      GPUBitmapImageRender localGPUBitmapImageRender = new GPUBitmapImageRender();
      localGPUBitmapImageRender.a(((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
      localObject2 = QQFilterRenderManagerHolder.a(QQFilterRenderManagerHolder.c);
      if ((localObject2 != null) && (((QQFilterRenderManager)localObject2).getBusinessOperation().hasAvOrSpecialEffect()))
      {
        if (paramBoolean) {
          l1 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.c();
        }
        localObject2 = localGPUBitmapImageRender.a((Bitmap)localObject1, l1);
        if (localObject2 != null) {
          localObject1 = localObject2;
        }
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a(paramMp4VideoFragmentInfo))
        {
          localObject2 = localObject1;
          if (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.b(paramMp4VideoFragmentInfo) != null)
          {
            GPUImagePixelationFilter localGPUImagePixelationFilter = (GPUImagePixelationFilter)FilterFactory.a(106);
            localGPUImagePixelationFilter.a(HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.b(paramMp4VideoFragmentInfo));
            localGPUImagePixelationFilter.init();
            localObject2 = localGPUBitmapImageRender.a((Bitmap)localObject1, localGPUImagePixelationFilter);
            SLog.a("Q.qqstory.record.HWEditLocalVideoPlayer", "updateFragmentThumbBitmapIfNeeded, mosaicThumbBitmap = %s", localObject2);
            if (localObject2 != null) {
              localObject1 = localObject2;
            }
            localGPUImagePixelationFilter.destroy();
            localObject2 = localObject1;
          }
        }
        if ((0 != 0) && (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a(paramMp4VideoFragmentInfo) != null) && (localObject2 != null)) {
          throw new NullPointerException();
        }
        localGPUBitmapImageRender.a();
        localObject1 = localObject2;
        if (i != 0) {
          localObject1 = UIUtils.a((Bitmap)localObject2, i);
        }
        localObject2 = localObject1;
        if (localObject1 != HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a(paramMp4VideoFragmentInfo)) {
          break;
        }
        localObject2 = localObject1;
        if (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.b(paramMp4VideoFragmentInfo)) {
          break;
        }
        localObject2 = localObject1;
        if (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a(paramMp4VideoFragmentInfo)) {
          break;
        }
        return paramMp4VideoFragmentInfo.jdField_a_of_type_AndroidGraphicsBitmap;
      }
      localObject2 = localObject1;
    }
  }
  
  private HWEditLocalVideoPlayer.ConvertIFramesRunnable a(int paramInt)
  {
    if ((Build.MODEL.equalsIgnoreCase("MX5")) || (Build.MODEL.contains("vivo X5")) || (Build.MODEL.equalsIgnoreCase("M2 Note")) || (Build.MODEL.equalsIgnoreCase("m1 metal")) || (Build.MODEL.equalsIgnoreCase("HLA Note3")) || (Build.MODEL.equalsIgnoreCase("OPPO R7")) || (Build.MODEL.equalsIgnoreCase("LON-AL00"))) {
      return new HWEditLocalVideoPlayer.ConvertIFramesRunnable(this, 3, 1, paramInt);
    }
    return new HWEditLocalVideoPlayer.ConvertIFramesRunnable(this, 30, 0, paramInt);
  }
  
  private void a(@NonNull HWEditLocalVideoPlayer.Mp4VideoFragmentInfo paramMp4VideoFragmentInfo)
  {
    SLog.b("Q.qqstory.record.HWEditLocalVideoPlayer", "setPlayInfo，index : %d => %d", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramMp4VideoFragmentInfo.c));
    if (paramMp4VideoFragmentInfo.jdField_a_of_type_JavaLangString == null)
    {
      if (!this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a().equalsIgnoreCase(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.c();
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setFilePath(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.b();
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.e();
        this.jdField_b_of_type_Int = 1;
      }
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setPlayRange((int)HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a(paramMp4VideoFragmentInfo), (int)HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.b(paramMp4VideoFragmentInfo));
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter.d(3, HardCodeUtil.a(2131705699));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramMp4VideoFragmentInfo.c;
      return;
      if (!this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a().equalsIgnoreCase(paramMp4VideoFragmentInfo.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.c();
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setFilePath(paramMp4VideoFragmentInfo.jdField_a_of_type_JavaLangString, paramMp4VideoFragmentInfo.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.f();
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.b();
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.e();
        this.jdField_b_of_type_Int = 1;
      }
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter.d(3, "");
      }
    }
  }
  
  private int b(int paramInt)
  {
    return 0;
  }
  
  private void c(int paramInt)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable == null)
    {
      Object localObject;
      if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
      {
        localObject = (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        if ((!((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)localObject).jdField_a_of_type_Boolean) && (TextUtils.isEmpty(((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)localObject).jdField_a_of_type_JavaLangString)))
        {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable = a(((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)localObject).c);
          this.jdField_b_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable, 300L);
        }
      }
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable == null)
      {
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          HWEditLocalVideoPlayer.Mp4VideoFragmentInfo localMp4VideoFragmentInfo = (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)((Iterator)localObject).next();
          if ((!localMp4VideoFragmentInfo.jdField_a_of_type_Boolean) && (TextUtils.isEmpty(localMp4VideoFragmentInfo.jdField_a_of_type_JavaLangString)))
          {
            this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable = a(localMp4VideoFragmentInfo.c);
            this.jdField_b_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable, 300L);
          }
        }
      }
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable == null)
      {
        SLog.c("Q.qqstory.record.HWEditLocalVideoPlayer", "no fragment info should convert I frame");
        return;
      }
      SLog.b("Q.qqstory.record.HWEditLocalVideoPlayer", "triggerConvertIFramesRunnable, priorVideoIndex=%d, mFrameRate=%d, mIFrameInterval=%d, mFragmentIndex=%d", Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.jdField_b_of_type_Int), Integer.valueOf(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.c));
      return;
    }
    SLog.b("Q.qqstory.record.HWEditLocalVideoPlayer", "triggerConvertIFramesRunnable ignore, mFrameRate=%d, mIFrameInterval=%d, mFragmentIndex=%d", Integer.valueOf(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.jdField_b_of_type_Int), Integer.valueOf(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.c));
  }
  
  private void i()
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size()) {
      if ((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)this.jdField_a_of_type_JavaUtilList.get(i)) == 1) && (TextUtils.isEmpty(((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString))) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.d(false);
      }
    }
    while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, true))
    {
      return;
      i += 1;
      break;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.d(true);
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public Bitmap a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return a((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt), true);
    }
    SLog.e("Q.qqstory.record.HWEditLocalVideoPlayer", "getDurationOfFragment with invalid index = %d", new Object[] { Integer.valueOf(paramInt) });
    return null;
  }
  
  public LocalMediaInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
    {
      Object localObject = (EditTakeVideoSource)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
      this.jdField_b_of_type_JavaLangString = ((EditTakeVideoSource)localObject).jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = ((EditTakeVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
      this.jdField_a_of_type_JavaLangString = ((EditTakeVideoSource)localObject).jdField_a_of_type_JavaLangString;
      this.jdField_c_of_type_JavaLangString = ((EditTakeVideoSource)localObject).jdField_c_of_type_JavaLangString;
      if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (this.jdField_b_of_type_JavaLangString.endsWith(".mp3")))
      {
        localObject = (QimMusicPlayer)QIMManager.a().c(8);
        MusicItemInfo localMusicItemInfo = MusicProviderView.a(this.jdField_b_of_type_JavaLangString);
        if (localMusicItemInfo != null)
        {
          ((QimMusicPlayer)localObject).a(localMusicItemInfo);
          localObject = Image2Video.jdField_a_of_type_JavaLangString + "/noaudio";
          FileUtils.c((String)localObject);
          this.jdField_b_of_type_JavaLangString = ((String)localObject);
        }
      }
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView = ((VideoFilterPlayView)a(2131368586));
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setVisibility(0);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setBgmFilePath(this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setMediaInfo(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setFilePath(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setRepeat(true);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setSpeedType(0);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setDecodeListener(this);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setPlayViewListener(this);
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setTrackerCallback(new HWEditLocalVideoPlayer.1(this));
      a(EditVideoPlayerExport.class, this);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.d(false);
      this.jdField_b_of_type_AndroidOsHandler.postDelayed(new HWEditLocalVideoPlayer.2(this), 200L);
      return;
    }
    throw new IllegalArgumentException("HWEditLocalVideoPlayer only support EditTakeVideoSource now");
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setVolume(paramFloat);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
    }
  }
  
  public void a(int paramInt)
  {
    paramInt = a(paramInt);
    HWEditLocalVideoPlayer.Mp4VideoFragmentInfo localMp4VideoFragmentInfo;
    if ((paramInt == 5) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      localMp4VideoFragmentInfo = (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
      if (localMp4VideoFragmentInfo.jdField_a_of_type_JavaLangString == null)
      {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.d();
        this.jdField_b_of_type_Int = 2;
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setSpeedType(5);
      }
    }
    for (;;)
    {
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.z();
        this.jdField_b_of_type_Boolean = false;
      }
      i();
      return;
      SLog.b("Q.qqstory.record.HWEditLocalVideoPlayer", "setPlayMode change to iframe video");
      a(localMp4VideoFragmentInfo);
      break;
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setSpeedType(paramInt);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.e();
      this.jdField_b_of_type_Int = 1;
    }
  }
  
  public void a(int paramInt1, int paramInt2, float paramFloat)
  {
    float f = 1.0F - paramFloat;
    if ((f == 0.0F) || (f > 0.95F))
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setColorFilterType(b(paramInt1));
      a(paramInt1);
      SLog.a("Q.qqstory.record.HWEditLocalVideoPlayer", "setSlideMode lefPlayMode=%s rightMode=%s, offset=%s", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Float.valueOf(paramFloat));
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
      {
        EditLocalVideoSource localEditLocalVideoSource = (EditLocalVideoSource)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setColorFilterType(b(paramInt1), b(paramInt2), f, localEditLocalVideoSource.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation);
        return;
      }
    } while (!(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource));
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setColorFilterType(b(paramInt1), b(paramInt2), f, 0);
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    int i;
    HWEditLocalVideoPlayer.Mp4VideoFragmentInfo localMp4VideoFragmentInfo;
    if ((paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
    {
      if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecEncoderMp4ReEncoder != null)
      {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecEncoderMp4ReEncoder.a();
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecEncoderMp4ReEncoder = null;
      }
      i = this.jdField_a_of_type_JavaUtilList.size();
      if (i <= 1) {
        break label264;
      }
      if (paramInt >= i) {
        break label235;
      }
      localMp4VideoFragmentInfo = (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.hasFragments = true;
      paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoNeedRotate = false;
      paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeStart = ((int)HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a(localMp4VideoFragmentInfo));
      paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeEnd = ((int)HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.b(localMp4VideoFragmentInfo));
      paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mIFrameVideoPath = localMp4VideoFragmentInfo.jdField_a_of_type_JavaLangString;
      SLog.b("Q.qqstory.record.HWEditLocalVideoPlayer", "editVideoPrePublish : %s", localMp4VideoFragmentInfo);
    }
    for (;;)
    {
      boolean bool = VideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.record.HWEditLocalVideoPlayer", 2, "landscape:" + bool + " w:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth + " h:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight + " r:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation);
      }
      paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("landscape_video", Boolean.valueOf(bool));
      return;
      label235:
      SLog.d("Q.qqstory.record.HWEditLocalVideoPlayer", "editVideoPrePublish : get invalid fragment index = %d, fragment count = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      continue;
      label264:
      if (i == 1)
      {
        localMp4VideoFragmentInfo = (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoNeedRotate = false;
        paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mIFrameVideoPath = localMp4VideoFragmentInfo.jdField_a_of_type_JavaLangString;
      }
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView == null) {}
    do
    {
      return;
      switch (paramInt)
      {
      }
    } while (this.jdField_b_of_type_Boolean);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.e();
    this.jdField_b_of_type_Int = 1;
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    throw new UnsupportedOperationException("please use setMosaicMp4(Bitmap,boolean) instead");
  }
  
  public void a(Bitmap paramBitmap) {}
  
  public void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a();
    HWEditLocalVideoPlayer.Mp4VideoFragmentInfo localMp4VideoFragmentInfo;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localMp4VideoFragmentInfo = (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)this.jdField_a_of_type_JavaUtilList.get(i);
      HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a(localMp4VideoFragmentInfo, paramBitmap);
      if ((!HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a(localMp4VideoFragmentInfo)) && (!paramBoolean)) {
        break label73;
      }
    }
    label73:
    for (paramBoolean = true;; paramBoolean = false)
    {
      HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a(localMp4VideoFragmentInfo, paramBoolean);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setMosaicFilterType(paramBitmap);
      return;
    }
  }
  
  public void a(TransferData paramTransferData)
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setTransferData(paramTransferData);
    }
  }
  
  public void a(Runnable paramRunnable, long paramLong)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      if (paramLong != 0L) {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(paramRunnable, paramLong);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(paramRunnable);
  }
  
  public void a(boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a();
    if (i < this.jdField_a_of_type_JavaUtilList.size()) {
      HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.b((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)this.jdField_a_of_type_JavaUtilList.get(i), paramBoolean);
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setMuteAudio(paramBoolean);
  }
  
  public void a(boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    boolean bool;
    if (!paramBoolean)
    {
      bool = true;
      this.jdField_a_of_type_Boolean = bool;
      if (!paramBoolean) {
        break label79;
      }
      if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView != null)
      {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.h();
        this.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.e();
        this.jdField_b_of_type_Int = 1;
        localEditMusicExport = (EditMusicExport)a(EditMusicExport.class);
        if (localEditMusicExport != null) {
          localEditMusicExport.d();
        }
      }
    }
    label79:
    while (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView == null)
    {
      return;
      bool = false;
      break;
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a(paramFloat1, paramFloat2, paramFloat3, paramFloat4, 0L, 0);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.d();
    this.jdField_b_of_type_Int = 2;
    EditMusicExport localEditMusicExport = (EditMusicExport)a(EditMusicExport.class);
    if (localEditMusicExport != null) {
      localEditMusicExport.c();
    }
    this.jdField_b_of_type_Boolean = true;
  }
  
  protected boolean a(Message paramMessage)
  {
    if (paramMessage.what == 3)
    {
      switch (paramMessage.arg1)
      {
      case 3: 
      default: 
      case 1: 
        do
        {
          return true;
        } while (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView == null);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.b();
        this.jdField_b_of_type_Int = 1;
        return true;
      }
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.c();
      this.jdField_b_of_type_Int = 0;
      return true;
    }
    return false;
  }
  
  public void aK_()
  {
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.d();
    this.jdField_b_of_type_Int = 2;
  }
  
  public void aM_()
  {
    super.aM_();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.d();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.onPause();
  }
  
  public void b(int paramInt)
  {
    SLog.a("Q.qqstory.record.HWEditLocalVideoPlayer", "setPlayMode mode=%s", Integer.valueOf(paramInt));
    int i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a();
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      HWEditLocalVideoPlayer.Mp4VideoFragmentInfo localMp4VideoFragmentInfo = (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)this.jdField_a_of_type_JavaUtilList.get(i);
      if (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a(localMp4VideoFragmentInfo) != paramInt)
      {
        HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a(localMp4VideoFragmentInfo, paramInt);
        HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.c(localMp4VideoFragmentInfo, true);
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_b_of_type_Int == 2)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.d();
      return;
    }
    this.jdField_b_of_type_Int = 1;
  }
  
  public void d()
  {
    this.jdField_b_of_type_Int = 0;
  }
  
  public void f()
  {
    super.f();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.onResume();
    if (this.jdField_b_of_type_Int != 2) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.e();
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.d();
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView != null)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.c();
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.i();
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setPlayViewListener(null);
    }
    super.g();
    if ((CaptureFreqMonitor.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView != null) && (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.j > 100) && (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.c > 0L))
    {
      int i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.f();
      float f = this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.j / (float)this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.c * 1000.0F;
      if (StoryReportor.a((int)f, 0L, 30L)) {
        StoryReportor.a("CamEditFreq", true, 0L, new String[] { String.valueOf(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int), String.valueOf(f), StoryReportor.b(i), String.valueOf(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.j), String.valueOf(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.c) });
      }
    }
  }
  
  public void h()
  {
    super.h();
    this.jdField_c_of_type_Boolean = false;
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecEncoderMp4ReEncoder != null)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecEncoderMp4ReEncoder.a();
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecEncoderMp4ReEncoder = null;
    }
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable = null;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.z();
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if ((i >= 0) && (i < this.jdField_a_of_type_JavaUtilList.size()))
    {
      paramMessage = (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)this.jdField_a_of_type_JavaUtilList.get(i);
      Bitmap localBitmap = a(paramMessage, false);
      if ((localBitmap != null) && (localBitmap != paramMessage.jdField_a_of_type_AndroidGraphicsBitmap))
      {
        paramMessage = paramMessage.a(localBitmap);
        this.jdField_a_of_type_JavaUtilList.set(i, paramMessage);
        SLog.b("Q.qqstory.record.HWEditLocalVideoPlayer", "update fragment bitmap : %s", paramMessage);
        a(new HWEditLocalVideoPlayer.3(this, i), 0L);
      }
    }
    return true;
  }
  
  public void j()
  {
    super.j();
    this.jdField_c_of_type_Boolean = true;
    c(0);
  }
  
  public void m()
  {
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.e();
    this.jdField_b_of_type_Int = 1;
  }
  
  public void onDecodeCancel() {}
  
  public void onDecodeError(int paramInt, Throwable paramThrowable)
  {
    QLog.e("Q.qqstory.record.HWEditLocalVideoPlayer", 4, "onDecodeError errorCode = " + paramInt, paramThrowable);
    throw new RuntimeException(paramThrowable);
  }
  
  public void onDecodeFinish() {}
  
  public void onDecodeFrame(long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(paramLong2);
    a(new HWEditLocalVideoPlayer.5(this, paramLong2), 0L);
  }
  
  public void onDecodeRepeat()
  {
    if (this.jdField_b_of_type_Int != 2) {
      a(new HWEditLocalVideoPlayer.6(this), 0L);
    }
  }
  
  public void onDecodeSeekTo(long paramLong) {}
  
  public void onDecodeStart()
  {
    if ((this.jdField_b_of_type_Int != 2) && (this.jdField_a_of_type_AndroidOsHandler != null))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      a(this.jdField_a_of_type_JavaLangRunnable, 200L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer
 * JD-Core Version:    0.7.0.1
 */