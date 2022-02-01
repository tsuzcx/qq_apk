package dov.com.tencent.biz.qqstory.takevideo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.Pair;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.utils.VideoUtils;
import com.tencent.biz.videostory.support.VideoStoryDataBean;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener;
import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferData;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GaussianBlurFilter;
import dov.com.qq.im.QQFilterRenderManagerHolder;
import dov.com.qq.im.capture.util.CaptureFreqMonitor;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import dov.com.tencent.mobileqq.richmedia.mediacodec.MergeEditVideo;
import dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.FilterFactory;
import dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUBitmapImageRender;
import dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUImagePixelationFilter;
import dov.com.tencent.mobileqq.richmedia.mediacodec.utils.MediaUtil;
import dov.com.tencent.mobileqq.richmedia.mediacodec.widget.HWVideoPlayView.HWVideoPlayViewListener;
import dov.com.tencent.mobileqq.richmedia.mediacodec.widget.VideoFilterPlayView;
import dov.com.tencent.mobileqq.shortvideo.util.MediaMetadataUtils;
import dov.com.tencent.mobileqq.shortvideo.util.MediaMetadataUtils.MetaData;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class HWEditImportVideoPlayer
  extends EditVideoPart
  implements Handler.Callback, HWDecodeListener, EditVideoPlayerExport, HWVideoPlayView.HWVideoPlayViewListener
{
  protected int a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  protected LocalMediaInfo a;
  protected VideoFilterPlayView a;
  private String jdField_a_of_type_JavaLangString;
  protected List<HWEditImportVideoPlayer.Mp4VideoFragmentInfo> a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  final boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private Handler jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
  private String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 0;
  boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = 0;
  boolean jdField_e_of_type_Boolean = false;
  
  public HWEditImportVideoPlayer(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_Int = -1;
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
  
  public static Bitmap a(Context paramContext, Bitmap paramBitmap, GPUBitmapImageRender paramGPUBitmapImageRender)
  {
    if ((paramBitmap == null) || (paramGPUBitmapImageRender == null)) {
      return null;
    }
    Object localObject = VideoUtils.a(paramBitmap.getWidth(), paramBitmap.getHeight(), ScreenUtil.SCREEN_WIDTH, ScreenUtil.SCREEN_HIGHT);
    int j = ((Integer)((Pair)localObject).first).intValue();
    int k = ((Integer)((Pair)localObject).second).intValue();
    int i = MergeEditVideo.jdField_a_of_type_Int;
    if (k > i) {
      j = (int)(j * i / k);
    }
    for (;;)
    {
      j = CaptureUtil.a(j);
      i = CaptureUtil.a(i);
      paramGPUBitmapImageRender.a(j, i);
      localObject = new GaussianBlurFilter();
      ((GaussianBlurFilter)localObject).init(paramBitmap.getWidth(), paramBitmap.getHeight());
      if (((GaussianBlurFilter)localObject).isInitSucc())
      {
        paramContext = ImageUtil.a(paramContext, ImageUtil.c(paramBitmap), 0.4F, 25.0F);
        paramGPUBitmapImageRender = paramContext;
        if (paramContext != null)
        {
          localCanvas = new Canvas();
          if (!paramContext.isMutable()) {
            break label205;
          }
        }
        label205:
        for (paramGPUBitmapImageRender = paramContext;; paramGPUBitmapImageRender = paramContext.copy(paramContext.getConfig(), true))
        {
          localCanvas.setBitmap(paramGPUBitmapImageRender);
          localCanvas.drawColor(Color.parseColor("#3F000000"), PorterDuff.Mode.SRC_OVER);
          paramGPUBitmapImageRender = paramContext;
          paramContext = BitmapUtils.a(BitmapUtils.a(paramGPUBitmapImageRender, j, i, true), paramBitmap);
          ((GaussianBlurFilter)localObject).destroy();
          return paramContext;
        }
      }
      paramContext = paramBitmap.copy(paramBitmap.getConfig(), true);
      Canvas localCanvas = new Canvas();
      if (paramContext.isMutable()) {}
      for (paramGPUBitmapImageRender = paramContext;; paramGPUBitmapImageRender = paramContext.copy(paramContext.getConfig(), true))
      {
        localCanvas.setBitmap(paramGPUBitmapImageRender);
        localCanvas.drawColor(Color.parseColor("#CC000000"), PorterDuff.Mode.SRC_OVER);
        paramGPUBitmapImageRender = paramContext;
        break;
      }
      i = k;
    }
  }
  
  private Bitmap a(@NonNull HWEditImportVideoPlayer.Mp4VideoFragmentInfo paramMp4VideoFragmentInfo, boolean paramBoolean)
  {
    long l1 = 0L;
    int i = 180;
    Object localObject2 = HWEditImportVideoPlayer.Mp4VideoFragmentInfo.a(paramMp4VideoFragmentInfo);
    long l2 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.c() / 1000000L;
    Object localObject1;
    if ((l2 != 0L) && (paramBoolean))
    {
      localObject1 = MediaUtil.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo, l2);
      if (localObject1 != null) {
        localObject2 = localObject1;
      }
    }
    for (;;)
    {
      if (localObject2 == null)
      {
        localObject1 = null;
        return localObject1;
      }
      label84:
      GPUBitmapImageRender localGPUBitmapImageRender;
      if (VideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo))
      {
        i = 0;
        localObject1 = localObject2;
        if (i != 0) {
          localObject1 = UIUtils.a((Bitmap)localObject2, i);
        }
        localGPUBitmapImageRender = new GPUBitmapImageRender();
        if (!this.jdField_c_of_type_Boolean) {
          break label402;
        }
        localObject1 = a(a(), (Bitmap)localObject1, localGPUBitmapImageRender);
        label130:
        localObject2 = QQFilterRenderManagerHolder.a(QQFilterRenderManagerHolder.jdField_c_of_type_Int);
        if ((localObject2 == null) || (!((QQFilterRenderManager)localObject2).getBusinessOperation().hasAvOrSpecialEffect())) {
          break label420;
        }
        if (paramBoolean) {
          l1 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.c();
        }
        localObject2 = localGPUBitmapImageRender.a((Bitmap)localObject1, l1);
        if (localObject2 == null) {
          break label420;
        }
        localObject1 = localObject2;
      }
      label402:
      label420:
      for (;;)
      {
        localObject2 = localObject1;
        if (HWEditImportVideoPlayer.Mp4VideoFragmentInfo.a(paramMp4VideoFragmentInfo))
        {
          localObject2 = localObject1;
          if (HWEditImportVideoPlayer.Mp4VideoFragmentInfo.b(paramMp4VideoFragmentInfo) != null)
          {
            GPUImagePixelationFilter localGPUImagePixelationFilter = (GPUImagePixelationFilter)FilterFactory.a(106);
            localGPUImagePixelationFilter.a(HWEditImportVideoPlayer.Mp4VideoFragmentInfo.b(paramMp4VideoFragmentInfo));
            localGPUImagePixelationFilter.init();
            localObject2 = localGPUBitmapImageRender.a((Bitmap)localObject1, localGPUImagePixelationFilter);
            SLog.a("Q.qqstory.record.HWEditImportVideoPlayer", "updateFragmentThumbBitmapIfNeeded, mosaicThumbBitmap = %s", localObject2);
            if (localObject2 != null) {
              localObject1 = localObject2;
            }
            localGPUImagePixelationFilter.destroy();
            localObject2 = localObject1;
          }
        }
        if ((0 != 0) && (HWEditImportVideoPlayer.Mp4VideoFragmentInfo.a(paramMp4VideoFragmentInfo) != null) && (localObject2 != null)) {
          throw new NullPointerException();
        }
        localGPUBitmapImageRender.a();
        localObject1 = localObject2;
        if (i != 0) {
          localObject1 = UIUtils.a((Bitmap)localObject2, 360 - i);
        }
        localObject2 = localObject1;
        if (this.jdField_d_of_type_Boolean) {
          localObject2 = UIUtils.a((Bitmap)localObject1, 90.0F);
        }
        localObject1 = localObject2;
        if (localObject2 != HWEditImportVideoPlayer.Mp4VideoFragmentInfo.a(paramMp4VideoFragmentInfo)) {
          break;
        }
        localObject1 = localObject2;
        if (HWEditImportVideoPlayer.Mp4VideoFragmentInfo.b(paramMp4VideoFragmentInfo)) {
          break;
        }
        localObject1 = localObject2;
        if (HWEditImportVideoPlayer.Mp4VideoFragmentInfo.a(paramMp4VideoFragmentInfo)) {
          break;
        }
        return paramMp4VideoFragmentInfo.jdField_a_of_type_AndroidGraphicsBitmap;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation == 180) {
          break label84;
        }
        i = 0;
        break label84;
        localGPUBitmapImageRender.a(((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
        break label130;
      }
    }
  }
  
  private void a(@NonNull HWEditImportVideoPlayer.Mp4VideoFragmentInfo paramMp4VideoFragmentInfo)
  {
    SLog.b("Q.qqstory.record.HWEditImportVideoPlayer", "setPlayInfo，index : %d => %d", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramMp4VideoFragmentInfo.jdField_c_of_type_Int));
    if (paramMp4VideoFragmentInfo.jdField_a_of_type_JavaLangString == null)
    {
      if (!this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a().equalsIgnoreCase(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.c();
        this.jdField_d_of_type_Int = this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setFilePath(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, true, this.jdField_b_of_type_Boolean, this.jdField_c_of_type_Boolean);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.b();
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.e();
        this.jdField_e_of_type_Int = 1;
      }
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setPlayRange((int)HWEditImportVideoPlayer.Mp4VideoFragmentInfo.a(paramMp4VideoFragmentInfo), (int)HWEditImportVideoPlayer.Mp4VideoFragmentInfo.b(paramMp4VideoFragmentInfo));
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter.d(3, HardCodeUtil.a(2131705694));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramMp4VideoFragmentInfo.jdField_c_of_type_Int;
      return;
      if (!this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a().equalsIgnoreCase(paramMp4VideoFragmentInfo.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.c();
        this.jdField_d_of_type_Int = this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setFilePath(paramMp4VideoFragmentInfo.jdField_a_of_type_JavaLangString, paramMp4VideoFragmentInfo.jdField_b_of_type_JavaLangString, true, this.jdField_b_of_type_Boolean, this.jdField_c_of_type_Boolean);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.f();
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.b();
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.e();
        this.jdField_e_of_type_Int = 1;
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
  
  private void i()
  {
    int k;
    int j;
    float f;
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 14) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a() != null) && (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a().isLandTakePicToVideo()) && ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource)))
    {
      k = ((EditLocalVideoSource)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation;
      j = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a();
      i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b();
      if ((k == 90) || (k == 270))
      {
        j = Math.min(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a(), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b());
        i = Math.max(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a(), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b());
      }
      f = j / i;
      j = ScreenUtil.SCREEN_WIDTH;
      i = ScreenUtil.SCREEN_HIGHT;
      if (ScreenUtil.checkDeviceHasNavigationBar(a())) {
        break label333;
      }
    }
    label333:
    for (int i = ScreenUtil.getRealHeight(a());; i = ScreenUtil.SCREEN_HIGHT)
    {
      k = (int)(j / f);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.width = j;
        localLayoutParams.height = k;
        localLayoutParams.addRule(16);
        localLayoutParams.setMargins(0, i / 2 - (int)(j / f) / 2, 0, 0);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setLayoutParams(localLayoutParams);
      }
      QLog.d("Q.qqstory.record.HWEditImportVideoPlayer", 4, "adjust view size viewWidth ane viewHeight:" + j + " " + k);
      return;
    }
  }
  
  public Bitmap a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return a((HWEditImportVideoPlayer.Mp4VideoFragmentInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt), true);
    }
    SLog.e("Q.qqstory.record.HWEditImportVideoPlayer", "getDurationOfFragment with invalid index = %d", new Object[] { Integer.valueOf(paramInt) });
    return null;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    Object localObject;
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
    {
      localObject = (EditLocalVideoSource)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
      this.jdField_b_of_type_JavaLangString = ((EditLocalVideoSource)localObject).jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = ((EditLocalVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
      this.jdField_b_of_type_Int = ((EditLocalVideoSource)localObject).jdField_a_of_type_Int;
      this.jdField_c_of_type_Int = ((EditLocalVideoSource)localObject).jdField_b_of_type_Int;
      this.jdField_a_of_type_JavaLangString = ((EditLocalVideoSource)localObject).jdField_a_of_type_JavaLangString;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight == 0))
      {
        localObject = new MediaMetadataUtils.MetaData();
        MediaMetadataUtils.a(this.jdField_a_of_type_JavaLangString, (MediaMetadataUtils.MetaData)localObject);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth = localObject.a[0];
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight = localObject.a[1];
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation = localObject.a[2];
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.record.HWEditImportVideoPlayer", 2, "LocalMediaInfo:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.toString());
      }
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView = ((VideoFilterPlayView)a(2131368586));
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setVisibility(0);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 14) {
        break label486;
      }
      this.jdField_d_of_type_Int = this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
      this.jdField_b_of_type_Boolean = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_is_fit_center", false);
      this.jdField_c_of_type_Boolean = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_is_need_gaussion_blur", false);
      if (this.jdField_c_of_type_Boolean) {
        if (!VideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo)) {
          break label592;
        }
      }
    }
    label585:
    label587:
    label592:
    for (int i = -90;; i = 0)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a(i);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setMediaInfo(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setFilePath(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, true, this.jdField_b_of_type_Boolean, this.jdField_c_of_type_Boolean);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_AndroidOsBundle != null)
      {
        localObject = (VideoStoryDataBean)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_AndroidOsBundle.getSerializable("KEY_VIDEO_STORY_CAMERA_TYPE");
        if ((localObject == null) || (!((VideoStoryDataBean)localObject).isLandTakePicToVideo())) {
          break label587;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        this.jdField_d_of_type_Boolean = bool;
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setRepeat(true);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setSpeedType(0);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setDecodeListener(this);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setPlayViewListener(this);
        this.jdField_e_of_type_Int = 0;
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setTrackerCallback(new HWEditImportVideoPlayer.1(this));
        a(EditVideoPlayerExport.class, this);
        this.jdField_b_of_type_AndroidOsHandler.postDelayed(new HWEditImportVideoPlayer.2(this), 200L);
        return;
        throw new IllegalArgumentException("HWEditLocalVideoPlayer only support EditLocalVideoSource now");
        label486:
        if (((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a() != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a().isLandTakePicToVideo())) || (!VideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo))) {
          this.jdField_d_of_type_Int = this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
        }
        for (;;)
        {
          if (!VideoUtils.a()) {
            break label585;
          }
          i();
          QLog.d("Q.qqstory.record.HWEditImportVideoPlayer", 4, "adjust view size end");
          break;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation == 180) {
            this.jdField_d_of_type_Int = this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a(180);
          }
        }
        break;
      }
    }
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
    HWEditImportVideoPlayer.Mp4VideoFragmentInfo localMp4VideoFragmentInfo;
    if ((paramInt == 5) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      localMp4VideoFragmentInfo = (HWEditImportVideoPlayer.Mp4VideoFragmentInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
      if (localMp4VideoFragmentInfo.jdField_a_of_type_JavaLangString == null)
      {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.d();
        this.jdField_e_of_type_Int = 2;
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setSpeedType(5);
      }
    }
    for (;;)
    {
      if (this.jdField_e_of_type_Boolean)
      {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.z();
        this.jdField_e_of_type_Boolean = false;
      }
      return;
      SLog.b("Q.qqstory.record.HWEditImportVideoPlayer", "setPlayMode change to iframe video");
      a(localMp4VideoFragmentInfo);
      break;
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setSpeedType(paramInt);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.e();
      this.jdField_e_of_type_Int = 1;
    }
  }
  
  public void a(int paramInt1, int paramInt2, float paramFloat)
  {
    float f = 1.0F - paramFloat;
    if ((f == 0.0F) || (f > 0.95F))
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setColorFilterType(b(paramInt1));
      a(paramInt1);
      SLog.a("Q.qqstory.record.HWEditImportVideoPlayer", "setSlideMode lefPlayMode=%s rightMode=%s, offset=%s", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Float.valueOf(paramFloat));
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
    int i = this.jdField_a_of_type_JavaUtilList.size();
    HWEditImportVideoPlayer.Mp4VideoFragmentInfo localMp4VideoFragmentInfo;
    if (i > 1) {
      if (paramInt < i)
      {
        localMp4VideoFragmentInfo = (HWEditImportVideoPlayer.Mp4VideoFragmentInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        paramGenerateContext.a.hasFragments = true;
        paramGenerateContext.a.videoNeedRotate = false;
        paramGenerateContext.a.videoRangeStart = ((int)HWEditImportVideoPlayer.Mp4VideoFragmentInfo.a(localMp4VideoFragmentInfo));
        paramGenerateContext.a.videoRangeEnd = ((int)HWEditImportVideoPlayer.Mp4VideoFragmentInfo.b(localMp4VideoFragmentInfo));
        SLog.b("Q.qqstory.record.HWEditImportVideoPlayer", "editVideoPrePublish : %s", localMp4VideoFragmentInfo);
      }
    }
    for (;;)
    {
      paramGenerateContext.a.putExtra("local_import", Boolean.valueOf(true));
      paramGenerateContext.a.putExtra("video_rotation", Integer.valueOf(this.jdField_d_of_type_Int));
      boolean bool = VideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.record.HWEditImportVideoPlayer", 2, "landscape:" + bool + " w:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth + " h:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight + " r:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation);
      }
      paramGenerateContext.a.putExtra("landscape_video", Boolean.valueOf(bool));
      paramGenerateContext.a.putExtra("extra_is_need_gaussion_blur", Boolean.valueOf(this.jdField_c_of_type_Boolean));
      return;
      SLog.d("Q.qqstory.record.HWEditImportVideoPlayer", "editVideoPrePublish : get invalid fragment index = %d, fragment count = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      continue;
      if (i == 1)
      {
        localMp4VideoFragmentInfo = (HWEditImportVideoPlayer.Mp4VideoFragmentInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        paramGenerateContext.a.videoNeedRotate = false;
        paramGenerateContext.a.videoRangeStart = this.jdField_b_of_type_Int;
        paramGenerateContext.a.videoRangeEnd = this.jdField_c_of_type_Int;
        paramGenerateContext.a.hwEncodeRecordVideo = true;
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
    } while (this.jdField_e_of_type_Boolean);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.e();
    this.jdField_e_of_type_Int = 1;
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    throw new UnsupportedOperationException("please use setMosaicMp4(Bitmap,boolean) instead");
  }
  
  public void a(Bitmap paramBitmap) {}
  
  public void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a();
    HWEditImportVideoPlayer.Mp4VideoFragmentInfo localMp4VideoFragmentInfo;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localMp4VideoFragmentInfo = (HWEditImportVideoPlayer.Mp4VideoFragmentInfo)this.jdField_a_of_type_JavaUtilList.get(i);
      HWEditImportVideoPlayer.Mp4VideoFragmentInfo.a(localMp4VideoFragmentInfo, paramBitmap);
      if ((!HWEditImportVideoPlayer.Mp4VideoFragmentInfo.a(localMp4VideoFragmentInfo)) && (!paramBoolean)) {
        break label73;
      }
    }
    label73:
    for (paramBoolean = true;; paramBoolean = false)
    {
      HWEditImportVideoPlayer.Mp4VideoFragmentInfo.a(localMp4VideoFragmentInfo, paramBoolean);
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
      HWEditImportVideoPlayer.Mp4VideoFragmentInfo.b((HWEditImportVideoPlayer.Mp4VideoFragmentInfo)this.jdField_a_of_type_JavaUtilList.get(i), paramBoolean);
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setMuteAudio(paramBoolean);
  }
  
  public void a(boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (paramBoolean) {
      if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView != null)
      {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.h();
        this.jdField_e_of_type_Boolean = false;
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.e();
        this.jdField_e_of_type_Int = 1;
        localEditMusicExport = (EditMusicExport)a(EditMusicExport.class);
        if (localEditMusicExport != null) {
          localEditMusicExport.d();
        }
      }
    }
    while (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView == null) {
      return;
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a(paramFloat1, paramFloat2, paramFloat3, paramFloat4, 0L, this.jdField_d_of_type_Int);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.d();
    this.jdField_e_of_type_Int = 2;
    EditMusicExport localEditMusicExport = (EditMusicExport)a(EditMusicExport.class);
    if (localEditMusicExport != null) {
      localEditMusicExport.c();
    }
    this.jdField_e_of_type_Boolean = true;
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
        this.jdField_e_of_type_Int = 1;
        return true;
      }
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.c();
      this.jdField_e_of_type_Int = 0;
      return true;
    }
    return false;
  }
  
  public void aK_()
  {
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.d();
    this.jdField_e_of_type_Int = 2;
  }
  
  public void aM_()
  {
    super.aM_();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.d();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.onPause();
  }
  
  public void b(int paramInt)
  {
    SLog.a("Q.qqstory.record.HWEditImportVideoPlayer", "setPlayMode mode=%s", Integer.valueOf(paramInt));
    int i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a();
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      HWEditImportVideoPlayer.Mp4VideoFragmentInfo localMp4VideoFragmentInfo = (HWEditImportVideoPlayer.Mp4VideoFragmentInfo)this.jdField_a_of_type_JavaUtilList.get(i);
      if (HWEditImportVideoPlayer.Mp4VideoFragmentInfo.a(localMp4VideoFragmentInfo) != paramInt)
      {
        HWEditImportVideoPlayer.Mp4VideoFragmentInfo.a(localMp4VideoFragmentInfo, paramInt);
        HWEditImportVideoPlayer.Mp4VideoFragmentInfo.c(localMp4VideoFragmentInfo, true);
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_e_of_type_Int == 2)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.d();
      return;
    }
    this.jdField_e_of_type_Int = 1;
  }
  
  public void d()
  {
    this.jdField_e_of_type_Int = 0;
  }
  
  public void f()
  {
    super.f();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.onResume();
    if (this.jdField_e_of_type_Int != 2)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.e();
      return;
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.d();
  }
  
  public void g()
  {
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.c();
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setPlayViewListener(null);
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    super.g();
    if ((CaptureFreqMonitor.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.j > 100) && (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.c > 0L))
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
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      paramMessage = (HWEditImportVideoPlayer.Mp4VideoFragmentInfo)this.jdField_a_of_type_JavaUtilList.get(i);
      Bitmap localBitmap = a(paramMessage, false);
      if ((localBitmap != null) && (localBitmap != paramMessage.jdField_a_of_type_AndroidGraphicsBitmap))
      {
        paramMessage = paramMessage.a(localBitmap);
        this.jdField_a_of_type_JavaUtilList.set(i, paramMessage);
        SLog.b("Q.qqstory.record.HWEditImportVideoPlayer", "update fragment bitmap : %s", paramMessage);
        a(new HWEditImportVideoPlayer.3(this, i), 0L);
      }
    }
    return true;
  }
  
  public void j()
  {
    super.j();
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.z();
      this.jdField_e_of_type_Boolean = false;
    }
  }
  
  public void m()
  {
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.e();
    this.jdField_e_of_type_Int = 1;
  }
  
  public void onDecodeCancel() {}
  
  public void onDecodeError(int paramInt, Throwable paramThrowable)
  {
    QLog.e("Q.qqstory.record.HWEditImportVideoPlayer", 4, "onDecodeError errorCode = " + paramInt, paramThrowable);
    throw new RuntimeException(paramThrowable);
  }
  
  public void onDecodeFinish() {}
  
  public void onDecodeFrame(long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(paramLong2);
    a(new HWEditImportVideoPlayer.5(this, paramLong2), 0L);
  }
  
  public void onDecodeRepeat()
  {
    a(new HWEditImportVideoPlayer.6(this), 0L);
  }
  
  public void onDecodeSeekTo(long paramLong) {}
  
  public void onDecodeStart()
  {
    a(new HWEditImportVideoPlayer.4(this), 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.HWEditImportVideoPlayer
 * JD-Core Version:    0.7.0.1
 */