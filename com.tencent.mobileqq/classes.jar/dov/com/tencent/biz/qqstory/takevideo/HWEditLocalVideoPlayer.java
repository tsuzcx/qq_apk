package dov.com.tencent.biz.qqstory.takevideo;

import ajyc;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import axli;
import bbdj;
import biho;
import bjae;
import bjdm;
import bjil;
import bjst;
import bjux;
import bjwu;
import bjww;
import bjxg;
import bjys;
import bjyu;
import bjzj;
import bkkm;
import bkxg;
import bkxj;
import bkxk;
import bkxo;
import bkxr;
import bkxw;
import bkya;
import bkyh;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.takevideo.slideshow.Image2Video;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.FollowCaptureParam;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.dancemachine.GLImage;
import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.pkvideo.PKFilter;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import dov.com.qq.im.capture.view.MusicProviderView;
import dov.com.tencent.mobileqq.richmedia.mediacodec.widget.VideoFilterPlayView;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import veg;
import vel;
import vzo;
import vzx;

public class HWEditLocalVideoPlayer
  extends bjwu
  implements Handler.Callback, bjxg, bkyh, HWDecodeListener
{
  protected int a;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bkxg jdField_a_of_type_Bkxg;
  protected LocalMediaInfo a;
  private FollowCaptureParam jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam;
  private HWEditLocalVideoPlayer.ConvertIFramesRunnable jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable;
  protected VideoFilterPlayView a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new HWEditLocalVideoPlayer.4(this);
  private String jdField_a_of_type_JavaLangString;
  protected List<bjyu> a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  protected boolean a;
  private int jdField_b_of_type_Int = 0;
  private Handler jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
  private String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = false;
  private String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean = false;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean = true;
  private boolean e;
  
  public HWEditLocalVideoPlayer(@NonNull bjww parambjww)
  {
    super(parambjww);
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
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
  
  private Bitmap a(Bitmap paramBitmap)
  {
    Object localObject = paramBitmap;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam != null)
    {
      localObject = vzx.a(paramBitmap.getWidth(), paramBitmap.getHeight(), axli.jdField_a_of_type_Int, axli.jdField_b_of_type_Int);
      bkxw localbkxw = new bkxw();
      localbkxw.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam);
      localbkxw.a(paramBitmap.getWidth(), paramBitmap.getHeight());
      localbkxw.onSurfaceCreate();
      localbkxw.onSurfaceChange(((Integer)((Pair)localObject).first).intValue(), ((Integer)((Pair)localObject).second).intValue());
      GLImage localGLImage = new GLImage();
      localGLImage.loadTextureSync(paramBitmap);
      localbkxw.setInputTextureID(localGLImage.getTexture());
      localbkxw.onDrawFrame();
      localObject = GlUtil.captureFrame(localbkxw.getOutputTextureID(), ((Integer)((Pair)localObject).first).intValue(), ((Integer)((Pair)localObject).second).intValue());
      localbkxw.onSurfaceDestroy();
    }
    return localObject;
  }
  
  private Bitmap a(@NonNull bjyu parambjyu, boolean paramBoolean)
  {
    Object localObject1 = bjyu.a(parambjyu);
    long l = this.jdField_a_of_type_Bjww.c() / 1000000L;
    Object localObject2;
    if ((l != 0L) && (paramBoolean))
    {
      localObject2 = bkya.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo, l);
      if (localObject2 != null) {
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      if (localObject1 == null) {
        return null;
      }
      int k = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation;
      if (k != 0) {}
      for (localObject2 = vzo.a((Bitmap)localObject1, 360 - k);; localObject2 = localObject1)
      {
        bkxk localbkxk = new bkxk();
        int j = ((Bitmap)localObject2).getWidth();
        int i = ((Bitmap)localObject2).getHeight();
        if (this.e)
        {
          localObject1 = vzx.a(((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight(), axli.jdField_a_of_type_Int, axli.jdField_b_of_type_Int);
          j = ((Integer)((Pair)localObject1).first).intValue();
          i = ((Integer)((Pair)localObject1).second).intValue();
        }
        localbkxk.a(j, i);
        localObject1 = localObject2;
        if (this.e) {
          localObject1 = a((Bitmap)localObject2);
        }
        QQFilterRenderManager localQQFilterRenderManager = biho.a(biho.jdField_c_of_type_Int);
        localObject2 = localObject1;
        Object localObject3;
        if (localQQFilterRenderManager != null)
        {
          localObject2 = localObject1;
          if (localQQFilterRenderManager.getBusinessOperation().hasAvOrSpecialEffect())
          {
            if (!paramBoolean) {
              break label627;
            }
            l = this.jdField_a_of_type_Bjww.c();
            localObject3 = localbkxk.a((Bitmap)localObject1, l);
            localObject2 = localObject1;
            if (localObject3 != null) {
              localObject2 = localObject3;
            }
          }
        }
        if ((bjyu.a(parambjyu)) && (bkxj.a(bjyu.a(parambjyu)))) {
          switch (bjyu.a(parambjyu))
          {
          default: 
            localObject1 = null;
            label315:
            if (localObject1 != null)
            {
              ((GPUBaseFilter)localObject1).init();
              localObject3 = localbkxk.a((Bitmap)localObject2, (GPUBaseFilter)localObject1);
              ((GPUBaseFilter)localObject1).destroy();
              veg.a("Q.qqstory.record.HWEditLocalVideoPlayer", "updateFragmentThumbBitmapIfNeeded, filterThumbBitmap = %s", localObject3);
              if (localObject3 != null)
              {
                localObject2 = localObject3;
                localObject1 = localObject3;
              }
            }
            break;
          }
        }
        for (;;)
        {
          localObject3 = localObject1;
          if (bjyu.b(parambjyu))
          {
            localObject3 = localObject1;
            if (bjyu.b(parambjyu) != null)
            {
              bkxo localbkxo = (bkxo)bkxj.a(106);
              localbkxo.a(bjyu.b(parambjyu));
              localbkxo.init();
              localObject3 = localbkxk.a((Bitmap)localObject1, localbkxo);
              veg.a("Q.qqstory.record.HWEditLocalVideoPlayer", "updateFragmentThumbBitmapIfNeeded, mosaicThumbBitmap = %s", localObject3);
              if (localObject3 != null) {
                localObject1 = localObject3;
              }
              localbkxo.destroy();
              localObject3 = localObject1;
            }
          }
          if ((localObject2 != null) && (localObject2 != bjyu.a(parambjyu)) && (localObject2 != localObject3)) {
            ((Bitmap)localObject2).recycle();
          }
          if ((localQQFilterRenderManager != null) && (localQQFilterRenderManager.hasQQFilter(183)))
          {
            localObject1 = (PKFilter)localQQFilterRenderManager.getQQFilters(183).get(0);
            localObject2 = new bkxr(((PKFilter)localObject1).getPKCoverPath(), ((PKFilter)localObject1).getPKTitleBmgPath());
            ((bkxr)localObject2).onOutputSizeChanged(((Bitmap)localObject3).getWidth(), ((Bitmap)localObject3).getHeight());
            ((bkxr)localObject2).init();
            localObject1 = localbkxk.a((Bitmap)localObject3, (GPUBaseFilter)localObject2);
            ((bkxr)localObject2).destroy();
            veg.d("Q.qqstory.record.HWEditLocalVideoPlayer", "handle pk video video cover.");
            if (localObject1 == null) {}
          }
          for (;;)
          {
            localbkxk.a();
            localObject2 = localObject1;
            if (k != 0) {
              localObject2 = vzo.a((Bitmap)localObject1, k);
            }
            if ((localObject2 != bjyu.a(parambjyu)) || (bjyu.a(parambjyu)) || (bjyu.b(parambjyu)))
            {
              return localObject2;
              label627:
              l = 0L;
              break;
              localObject1 = bkxj.a(7);
              break label315;
              localObject1 = bkxj.a(4);
              break label315;
              localObject1 = bkxj.a(6);
              break label315;
              localObject1 = bkxj.a(5);
              break label315;
            }
            return parambjyu.jdField_c_of_type_AndroidGraphicsBitmap;
            localObject1 = localObject3;
          }
          localObject1 = localObject2;
          localObject2 = localObject3;
          continue;
          localObject1 = localObject2;
          localObject2 = null;
        }
      }
    }
  }
  
  private HWEditLocalVideoPlayer.ConvertIFramesRunnable a(int paramInt)
  {
    if ((Build.MODEL.equalsIgnoreCase("MX5")) || (Build.MODEL.contains("vivo X5")) || (Build.MODEL.equalsIgnoreCase("M2 Note")) || (Build.MODEL.equalsIgnoreCase("m1 metal")) || (Build.MODEL.equalsIgnoreCase("HLA Note3")) || (Build.MODEL.equalsIgnoreCase("OPPO R7")) || (Build.MODEL.equalsIgnoreCase("LON-AL00"))) {
      return new HWEditLocalVideoPlayer.ConvertIFramesRunnable(this, 3, 1, paramInt);
    }
    return new HWEditLocalVideoPlayer.ConvertIFramesRunnable(this, 30, 0, paramInt);
  }
  
  private void a(@NonNull bjyu parambjyu)
  {
    veg.b("Q.qqstory.record.HWEditLocalVideoPlayer", "setPlayInfo，index : %d => %d", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(parambjyu.jdField_c_of_type_Int));
    if (parambjyu.jdField_a_of_type_JavaLangString == null)
    {
      if (!this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a().equalsIgnoreCase(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.c();
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setFilePath(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.b();
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.e();
        this.jdField_b_of_type_Int = 1;
      }
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setPlayRange((int)bjyu.a(parambjyu), (int)bjyu.b(parambjyu));
      if (this.jdField_a_of_type_Bjww.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter != null) {
        this.jdField_a_of_type_Bjww.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a(3, ajyc.a(2131705672));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = parambjyu.jdField_c_of_type_Int;
      return;
      if (!this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a().equalsIgnoreCase(parambjyu.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.c();
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setFilePath(parambjyu.jdField_a_of_type_JavaLangString, parambjyu.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.f();
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.b();
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.e();
        this.jdField_b_of_type_Int = 1;
      }
      if (this.jdField_a_of_type_Bjww.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter != null) {
        this.jdField_a_of_type_Bjww.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a(3, "");
      }
    }
  }
  
  private int b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 7: 
      return 7;
    case 6: 
      return 6;
    case 5: 
      return 5;
    }
    return 4;
  }
  
  private void c(int paramInt)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable == null)
    {
      Object localObject;
      if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
      {
        localObject = (bjyu)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        if ((!((bjyu)localObject).jdField_a_of_type_Boolean) && (TextUtils.isEmpty(((bjyu)localObject).jdField_a_of_type_JavaLangString)))
        {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable = a(((bjyu)localObject).jdField_c_of_type_Int);
          this.jdField_b_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable, 300L);
        }
      }
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable == null)
      {
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          bjyu localbjyu = (bjyu)((Iterator)localObject).next();
          if ((!localbjyu.jdField_a_of_type_Boolean) && (TextUtils.isEmpty(localbjyu.jdField_a_of_type_JavaLangString)))
          {
            this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable = a(localbjyu.jdField_c_of_type_Int);
            this.jdField_b_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable, 300L);
          }
        }
      }
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable == null)
      {
        veg.c("Q.qqstory.record.HWEditLocalVideoPlayer", "no fragment info should convert I frame");
        return;
      }
      veg.b("Q.qqstory.record.HWEditLocalVideoPlayer", "triggerConvertIFramesRunnable, priorVideoIndex=%d, mFrameRate=%d, mIFrameInterval=%d, mFragmentIndex=%d", Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.jdField_b_of_type_Int), Integer.valueOf(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.jdField_c_of_type_Int));
      return;
    }
    veg.b("Q.qqstory.record.HWEditLocalVideoPlayer", "triggerConvertIFramesRunnable ignore, mFrameRate=%d, mIFrameInterval=%d, mFragmentIndex=%d", Integer.valueOf(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.jdField_b_of_type_Int), Integer.valueOf(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.jdField_c_of_type_Int));
  }
  
  private void n()
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size()) {
      if ((bjyu.a((bjyu)this.jdField_a_of_type_JavaUtilList.get(i)) == 1) && (TextUtils.isEmpty(((bjyu)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_Bjww.e(false);
        if (this.jdField_a_of_type_Bjww.jdField_a_of_type_Bjux != null) {
          this.jdField_a_of_type_Bjww.jdField_a_of_type_Bjux.b(false);
        }
      }
    }
    do
    {
      do
      {
        return;
        i += 1;
        break;
      } while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, true));
      this.jdField_a_of_type_Bjww.e(true);
    } while (this.jdField_a_of_type_Bjww.jdField_a_of_type_Bjux == null);
    this.jdField_a_of_type_Bjww.jdField_a_of_type_Bjux.b(true);
  }
  
  public int a()
  {
    int i = this.jdField_a_of_type_Bjww.a();
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      bjyu localbjyu = (bjyu)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localbjyu != null) {
        return bjyu.a(localbjyu);
      }
    }
    return 0;
  }
  
  public long a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
    {
      bjyu localbjyu = (bjyu)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      return bjyu.b(localbjyu) - bjyu.a(localbjyu);
    }
    veg.e("Q.qqstory.record.HWEditLocalVideoPlayer", "getDurationOfFragment with invalid index = %d", new Object[] { Integer.valueOf(paramInt) });
    return 0L;
  }
  
  public Bitmap a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return a((bjyu)this.jdField_a_of_type_JavaUtilList.get(paramInt), true);
    }
    veg.e("Q.qqstory.record.HWEditLocalVideoPlayer", "getDurationOfFragment with invalid index = %d", new Object[] { Integer.valueOf(paramInt) });
    return null;
  }
  
  public LocalMediaInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
  }
  
  public String a()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public List<? extends bjzj> a()
  {
    return Collections.unmodifiableList(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    if ((this.jdField_a_of_type_Bjww.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
    {
      Object localObject = (EditTakeVideoSource)this.jdField_a_of_type_Bjww.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
      this.jdField_b_of_type_JavaLangString = ((EditTakeVideoSource)localObject).jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = ((EditTakeVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
      this.jdField_a_of_type_JavaLangString = ((EditTakeVideoSource)localObject).jdField_a_of_type_JavaLangString;
      this.jdField_c_of_type_JavaLangString = ((EditTakeVideoSource)localObject).jdField_c_of_type_JavaLangString;
      if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (this.jdField_b_of_type_JavaLangString.endsWith(".mp3")))
      {
        localObject = (bjdm)bjae.a().c(8);
        MusicItemInfo localMusicItemInfo = MusicProviderView.a(this.jdField_b_of_type_JavaLangString);
        if (localMusicItemInfo != null)
        {
          ((bjdm)localObject).a(localMusicItemInfo);
          localObject = Image2Video.jdField_a_of_type_JavaLangString + "/noaudio";
          bbdj.c((String)localObject);
          this.jdField_b_of_type_JavaLangString = ((String)localObject);
        }
      }
      bool1 = bjww.a(this.jdField_a_of_type_Bjww.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Long, 262144);
      boolean bool2 = VideoEnvironment.b(7);
      veg.d("Q.qqstory.record.HWEditLocalVideoPlayer", "recordMultiVideoFragment = %s, supportMultiVideoFragment = %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bool1) || (!bool2)) {
        break label511;
      }
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      if (this.jdField_a_of_type_Bjww.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam = ((FollowCaptureParam)this.jdField_a_of_type_Bjww.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle.getSerializable("extra_follow_capture_param"));
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam == null) {
          break label516;
        }
      }
    }
    label516:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.e = bool1;
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView = ((VideoFilterPlayView)a(2131367669));
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setFollowCaptureVideo(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setVisibility(0);
      if (this.jdField_a_of_type_Bjww.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("story_game_capture_type", 1) == 2) {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setStoryGamePaths(this.jdField_a_of_type_Bjww.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("game_pk_video_path"), this.jdField_a_of_type_Bjww.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("game_pk_cover_path"), this.jdField_a_of_type_Bjww.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("game_pk_result_path"));
      }
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setBgmFilePath(this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setMediaInfo(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setFilePath(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setRepeat(true);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setSpeedType(0);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setDecodeListener(this);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setPlayViewListener(this);
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setTrackerCallback(new bjys(this));
      a(bjxg.class, this);
      this.jdField_a_of_type_Bjww.e(false);
      this.jdField_b_of_type_AndroidOsHandler.postDelayed(new HWEditLocalVideoPlayer.2(this), 200L);
      return;
      throw new IllegalArgumentException("HWEditLocalVideoPlayer only support EditTakeVideoSource now");
      label511:
      bool1 = false;
      break;
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
    bjyu localbjyu;
    if ((paramInt == 5) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      localbjyu = (bjyu)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
      if (localbjyu.jdField_a_of_type_JavaLangString == null)
      {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.d();
        this.jdField_b_of_type_Int = 2;
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setSpeedType(5);
      }
    }
    for (;;)
    {
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_Bjww.B();
        this.jdField_c_of_type_Boolean = false;
      }
      n();
      return;
      veg.b("Q.qqstory.record.HWEditLocalVideoPlayer", "setPlayMode change to iframe video");
      a(localbjyu);
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
      veg.a("Q.qqstory.record.HWEditLocalVideoPlayer", "setSlideMode lefPlayMode=%s rightMode=%s, offset=%s", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Float.valueOf(paramFloat));
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_Bjww.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
      {
        EditLocalVideoSource localEditLocalVideoSource = (EditLocalVideoSource)this.jdField_a_of_type_Bjww.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setColorFilterType(b(paramInt1), b(paramInt2), f, localEditLocalVideoSource.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation);
        return;
      }
    } while (!(this.jdField_a_of_type_Bjww.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource));
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setColorFilterType(b(paramInt1), b(paramInt2), f, 0);
  }
  
  public void a(int paramInt, @NonNull bkkm parambkkm)
  {
    int i;
    bjyu localbjyu;
    if ((parambkkm.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
    {
      if (this.jdField_a_of_type_Bkxg != null)
      {
        this.jdField_a_of_type_Bkxg.c();
        this.jdField_a_of_type_Bkxg = null;
      }
      i = this.jdField_a_of_type_JavaUtilList.size();
      if (i <= 1) {
        break label380;
      }
      if (paramInt >= i) {
        break label351;
      }
      localbjyu = (bjyu)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      parambkkm.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.hasFragments = true;
      parambkkm.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoNeedRotate = false;
      parambkkm.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeStart = ((int)bjyu.a(localbjyu));
      parambkkm.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeEnd = ((int)bjyu.b(localbjyu));
      parambkkm.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mIFrameVideoPath = localbjyu.jdField_a_of_type_JavaLangString;
      veg.b("Q.qqstory.record.HWEditLocalVideoPlayer", "editVideoPrePublish : %s", localbjyu);
    }
    for (;;)
    {
      boolean bool = vzx.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.record.HWEditLocalVideoPlayer", 2, "landscape:" + bool + " w:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth + " h:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight + " r:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation);
      }
      parambkkm.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("landscape_video", Boolean.valueOf(bool));
      parambkkm.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("is_follow_capture_video", Boolean.valueOf(this.e));
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam != null)
      {
        parambkkm.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("follow_capture_param", FollowCaptureParam.parseToJson(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam));
        parambkkm.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("video_type", Integer.valueOf(5));
        parambkkm = vzx.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight, axli.jdField_a_of_type_Int, axli.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth = ((Integer)parambkkm.first).intValue();
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight = ((Integer)parambkkm.second).intValue();
      }
      return;
      label351:
      veg.d("Q.qqstory.record.HWEditLocalVideoPlayer", "editVideoPrePublish : get invalid fragment index = %d, fragment count = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      continue;
      label380:
      if (i == 1)
      {
        localbjyu = (bjyu)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        parambkkm.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoNeedRotate = false;
        parambkkm.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mIFrameVideoPath = localbjyu.jdField_a_of_type_JavaLangString;
      }
    }
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    throw new UnsupportedOperationException("please use setMosaicMp4(Bitmap,boolean) instead");
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a((int)paramLong, paramBoolean);
    }
  }
  
  public void a(Bitmap paramBitmap) {}
  
  public void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_Bjww.a();
    bjyu localbjyu;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localbjyu = (bjyu)this.jdField_a_of_type_JavaUtilList.get(i);
      bjyu.a(localbjyu, paramBitmap);
      if ((!bjyu.b(localbjyu)) && (!paramBoolean)) {
        break label73;
      }
    }
    label73:
    for (paramBoolean = true;; paramBoolean = false)
    {
      bjyu.a(localbjyu, paramBoolean);
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
    int i = this.jdField_a_of_type_Bjww.a();
    if (i < this.jdField_a_of_type_JavaUtilList.size()) {
      bjyu.b((bjyu)this.jdField_a_of_type_JavaUtilList.get(i), paramBoolean);
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setMuteAudio(paramBoolean);
  }
  
  public void a(boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    boolean bool;
    if (!paramBoolean)
    {
      bool = true;
      this.jdField_b_of_type_Boolean = bool;
      if (!paramBoolean) {
        break label84;
      }
      this.jdField_a_of_type_Long = 0L;
      if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView != null)
      {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.h();
        this.jdField_c_of_type_Boolean = false;
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.e();
        this.jdField_b_of_type_Int = 1;
        localbjst = (bjst)a(bjst.class);
        if (localbjst != null) {
          localbjst.d();
        }
      }
    }
    label84:
    while (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView == null)
    {
      return;
      bool = false;
      break;
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a(paramFloat1, paramFloat2, paramFloat3, paramFloat4, 0L, 0);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.d();
    this.jdField_b_of_type_Int = 2;
    bjst localbjst = (bjst)a(bjst.class);
    if (localbjst != null) {
      localbjst.ab_();
    }
    this.jdField_c_of_type_Boolean = true;
  }
  
  public boolean a(long paramLong)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      bjyu localbjyu = (bjyu)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
      if ((localbjyu != null) && (localbjyu.jdField_a_of_type_JavaLangString != null))
      {
        if ((this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView != null) && (!this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a().equalsIgnoreCase(localbjyu.jdField_a_of_type_JavaLangString)))
        {
          this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.c();
          this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setFilePath(localbjyu.jdField_a_of_type_JavaLangString, localbjyu.jdField_b_of_type_JavaLangString);
          this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.f();
          this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.b();
          this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.d();
          if (paramLong >= 0L) {
            this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a((int)paramLong, true);
          }
          if (this.jdField_b_of_type_Int != 2) {
            this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.e();
          }
        }
        return true;
      }
    }
    return false;
  }
  
  public boolean a(Message paramMessage)
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
    int i;
    if (paramMessage.what == 6)
    {
      i = paramMessage.arg2;
      int j = paramMessage.arg1;
      if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label184;
      }
      paramMessage = (bjyu)this.jdField_a_of_type_JavaUtilList.get(i);
      veg.b("Q.qqstory.record.HWEditLocalVideoPlayer", "MESSAGE_PLAYING_FRAGMENT_CHANGED : fragment = %s", paramMessage);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setColorFilterType(b(bjyu.a(paramMessage)));
      a(bjyu.a(paramMessage));
      a(paramMessage);
      c(i);
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(j);
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(j);
    }
    for (;;)
    {
      return false;
      label184:
      veg.e("Q.qqstory.record.HWEditLocalVideoPlayer", "MESSAGE_PLAYING_FRAGMENT_CHANGED : get invalid index=%d, video fragment count = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
    }
  }
  
  public void aV_()
  {
    super.aV_();
    this.jdField_d_of_type_Boolean = false;
    if (this.jdField_a_of_type_Bkxg != null)
    {
      this.jdField_a_of_type_Bkxg.c();
      this.jdField_a_of_type_Bkxg = null;
    }
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable = null;
    }
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_Bjww.B();
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  public void aZ_()
  {
    super.aZ_();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.d();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.onPause();
  }
  
  public void a_(int paramInt, Object paramObject)
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView == null) {}
    do
    {
      return;
      switch (paramInt)
      {
      }
    } while (this.jdField_c_of_type_Boolean);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.e();
    this.jdField_b_of_type_Int = 1;
    return;
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.d();
    this.jdField_b_of_type_Int = 2;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void b(int paramInt)
  {
    veg.a("Q.qqstory.record.HWEditLocalVideoPlayer", "setPlayMode mode=%s", Integer.valueOf(paramInt));
    int i = this.jdField_a_of_type_Bjww.a();
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      bjyu localbjyu = (bjyu)this.jdField_a_of_type_JavaUtilList.get(i);
      if (bjyu.a(localbjyu) != paramInt)
      {
        bjyu.a(localbjyu, paramInt);
        bjyu.c(localbjyu, true);
      }
    }
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a((int)paramLong, paramBoolean);
    }
  }
  
  public void d()
  {
    if (this.jdField_b_of_type_Int == 2)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.d();
      return;
    }
    this.jdField_b_of_type_Int = 1;
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
      this.jdField_b_of_type_Boolean = false;
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
    if ((bjil.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView != null) && (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.j > 100) && (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.c > 0L))
    {
      int i = this.jdField_a_of_type_Bjww.g();
      float f = this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.j / (float)this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.c * 1000.0F;
      if (vel.a((int)f, 0L, 30L)) {
        vel.a("CamEditFreq", true, 0L, new String[] { String.valueOf(this.jdField_a_of_type_Bjww.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int), String.valueOf(f), vel.b(i), String.valueOf(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.j), String.valueOf(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.c) });
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if ((i >= 0) && (i < this.jdField_a_of_type_JavaUtilList.size()))
    {
      paramMessage = (bjyu)this.jdField_a_of_type_JavaUtilList.get(i);
      Bitmap localBitmap = a(paramMessage, false);
      if ((localBitmap != null) && (localBitmap != paramMessage.jdField_c_of_type_AndroidGraphicsBitmap))
      {
        paramMessage = paramMessage.a(localBitmap);
        this.jdField_a_of_type_JavaUtilList.set(i, paramMessage);
        veg.b("Q.qqstory.record.HWEditLocalVideoPlayer", "update fragment bitmap : %s", paramMessage);
        a(new HWEditLocalVideoPlayer.3(this, i), 0L);
      }
    }
    return true;
  }
  
  public void j()
  {
    this.jdField_b_of_type_Int = 0;
  }
  
  public void k()
  {
    VideoFilterPlayView localVideoFilterPlayView = this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView;
    if (this.jdField_a_of_type_Bjww.jdField_a_of_type_Int == 42) {}
    for (boolean bool = true;; bool = false)
    {
      localVideoFilterPlayView.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.d();
      this.jdField_b_of_type_Int = 2;
      return;
    }
  }
  
  public void l()
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
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_Long = paramLong1;
    }
    this.jdField_a_of_type_Bjww.a(paramLong2);
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
  
  public void z_()
  {
    super.z_();
    this.jdField_d_of_type_Boolean = true;
    c(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer
 * JD-Core Version:    0.7.0.1
 */