package dov.com.tencent.biz.qqstory.takevideo;

import ajjy;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import awmc;
import bace;
import bhey;
import bhfm;
import bhiu;
import bhnt;
import bibw;
import biea;
import bifz;
import bigb;
import bigl;
import bihx;
import bihz;
import biio;
import bitz;
import bjgv;
import bjgy;
import bjgz;
import bjhd;
import bjhg;
import bjhl;
import bjhp;
import bjhw;
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
import urk;
import urp;
import vms;
import vnb;

public class HWEditLocalVideoPlayer
  extends bifz
  implements Handler.Callback, bigl, bjhw, HWDecodeListener
{
  protected int a;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bjgv jdField_a_of_type_Bjgv;
  protected LocalMediaInfo a;
  private FollowCaptureParam jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam;
  private HWEditLocalVideoPlayer.ConvertIFramesRunnable jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable;
  protected VideoFilterPlayView a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new HWEditLocalVideoPlayer.4(this);
  private String jdField_a_of_type_JavaLangString;
  protected List<bihz> a;
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
  
  public HWEditLocalVideoPlayer(@NonNull bigb parambigb)
  {
    super(parambigb);
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
      localObject = vnb.a(paramBitmap.getWidth(), paramBitmap.getHeight(), awmc.jdField_a_of_type_Int, awmc.jdField_b_of_type_Int);
      bjhl localbjhl = new bjhl();
      localbjhl.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam);
      localbjhl.a(paramBitmap.getWidth(), paramBitmap.getHeight());
      localbjhl.onSurfaceCreate();
      localbjhl.onSurfaceChange(((Integer)((Pair)localObject).first).intValue(), ((Integer)((Pair)localObject).second).intValue());
      GLImage localGLImage = new GLImage();
      localGLImage.loadTextureSync(paramBitmap);
      localbjhl.setInputTextureID(localGLImage.getTexture());
      localbjhl.onDrawFrame();
      localObject = GlUtil.captureFrame(localbjhl.getOutputTextureID(), ((Integer)((Pair)localObject).first).intValue(), ((Integer)((Pair)localObject).second).intValue());
      localbjhl.onSurfaceDestroy();
    }
    return localObject;
  }
  
  private Bitmap a(@NonNull bihz parambihz, boolean paramBoolean)
  {
    Object localObject1 = bihz.a(parambihz);
    long l = this.jdField_a_of_type_Bigb.c() / 1000000L;
    Object localObject2;
    if ((l != 0L) && (paramBoolean))
    {
      localObject2 = bjhp.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo, l);
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
      for (localObject2 = vms.a((Bitmap)localObject1, 360 - k);; localObject2 = localObject1)
      {
        bjgz localbjgz = new bjgz();
        int j = ((Bitmap)localObject2).getWidth();
        int i = ((Bitmap)localObject2).getHeight();
        if (this.e)
        {
          localObject1 = vnb.a(((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight(), awmc.jdField_a_of_type_Int, awmc.jdField_b_of_type_Int);
          j = ((Integer)((Pair)localObject1).first).intValue();
          i = ((Integer)((Pair)localObject1).second).intValue();
        }
        localbjgz.a(j, i);
        localObject1 = localObject2;
        if (this.e) {
          localObject1 = a((Bitmap)localObject2);
        }
        QQFilterRenderManager localQQFilterRenderManager = bhey.a(bhey.jdField_c_of_type_Int);
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
            l = this.jdField_a_of_type_Bigb.c();
            localObject3 = localbjgz.a((Bitmap)localObject1, l);
            localObject2 = localObject1;
            if (localObject3 != null) {
              localObject2 = localObject3;
            }
          }
        }
        if ((bihz.a(parambihz)) && (bjgy.a(bihz.a(parambihz)))) {
          switch (bihz.a(parambihz))
          {
          default: 
            localObject1 = null;
            label315:
            if (localObject1 != null)
            {
              ((GPUBaseFilter)localObject1).init();
              localObject3 = localbjgz.a((Bitmap)localObject2, (GPUBaseFilter)localObject1);
              ((GPUBaseFilter)localObject1).destroy();
              urk.a("Q.qqstory.record.HWEditLocalVideoPlayer", "updateFragmentThumbBitmapIfNeeded, filterThumbBitmap = %s", localObject3);
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
          if (bihz.b(parambihz))
          {
            localObject3 = localObject1;
            if (bihz.b(parambihz) != null)
            {
              bjhd localbjhd = (bjhd)bjgy.a(106);
              localbjhd.a(bihz.b(parambihz));
              localbjhd.init();
              localObject3 = localbjgz.a((Bitmap)localObject1, localbjhd);
              urk.a("Q.qqstory.record.HWEditLocalVideoPlayer", "updateFragmentThumbBitmapIfNeeded, mosaicThumbBitmap = %s", localObject3);
              if (localObject3 != null) {
                localObject1 = localObject3;
              }
              localbjhd.destroy();
              localObject3 = localObject1;
            }
          }
          if ((localObject2 != null) && (localObject2 != bihz.a(parambihz)) && (localObject2 != localObject3)) {
            ((Bitmap)localObject2).recycle();
          }
          if ((localQQFilterRenderManager != null) && (localQQFilterRenderManager.hasQQFilter(183)))
          {
            localObject1 = (PKFilter)localQQFilterRenderManager.getQQFilters(183).get(0);
            localObject2 = new bjhg(((PKFilter)localObject1).getPKCoverPath(), ((PKFilter)localObject1).getPKTitleBmgPath());
            ((bjhg)localObject2).onOutputSizeChanged(((Bitmap)localObject3).getWidth(), ((Bitmap)localObject3).getHeight());
            ((bjhg)localObject2).init();
            localObject1 = localbjgz.a((Bitmap)localObject3, (GPUBaseFilter)localObject2);
            ((bjhg)localObject2).destroy();
            urk.d("Q.qqstory.record.HWEditLocalVideoPlayer", "handle pk video video cover.");
            if (localObject1 == null) {}
          }
          for (;;)
          {
            localbjgz.a();
            localObject2 = localObject1;
            if (k != 0) {
              localObject2 = vms.a((Bitmap)localObject1, k);
            }
            if ((localObject2 != bihz.a(parambihz)) || (bihz.a(parambihz)) || (bihz.b(parambihz)))
            {
              return localObject2;
              label627:
              l = 0L;
              break;
              localObject1 = bjgy.a(7);
              break label315;
              localObject1 = bjgy.a(4);
              break label315;
              localObject1 = bjgy.a(6);
              break label315;
              localObject1 = bjgy.a(5);
              break label315;
            }
            return parambihz.jdField_c_of_type_AndroidGraphicsBitmap;
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
  
  private void a(@NonNull bihz parambihz)
  {
    urk.b("Q.qqstory.record.HWEditLocalVideoPlayer", "setPlayInfo，index : %d => %d", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(parambihz.jdField_c_of_type_Int));
    if (parambihz.jdField_a_of_type_JavaLangString == null)
    {
      if (!this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a().equalsIgnoreCase(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.c();
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setFilePath(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.b();
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.e();
        this.jdField_b_of_type_Int = 1;
      }
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setPlayRange((int)bihz.a(parambihz), (int)bihz.b(parambihz));
      if (this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter != null) {
        this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a(3, ajjy.a(2131639887));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = parambihz.jdField_c_of_type_Int;
      return;
      if (!this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a().equalsIgnoreCase(parambihz.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.c();
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setFilePath(parambihz.jdField_a_of_type_JavaLangString, parambihz.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.f();
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.b();
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.e();
        this.jdField_b_of_type_Int = 1;
      }
      if (this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter != null) {
        this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a(3, "");
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
        localObject = (bihz)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        if ((!((bihz)localObject).jdField_a_of_type_Boolean) && (TextUtils.isEmpty(((bihz)localObject).jdField_a_of_type_JavaLangString)))
        {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable = a(((bihz)localObject).jdField_c_of_type_Int);
          this.jdField_b_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable, 300L);
        }
      }
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable == null)
      {
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          bihz localbihz = (bihz)((Iterator)localObject).next();
          if ((!localbihz.jdField_a_of_type_Boolean) && (TextUtils.isEmpty(localbihz.jdField_a_of_type_JavaLangString)))
          {
            this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable = a(localbihz.jdField_c_of_type_Int);
            this.jdField_b_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable, 300L);
          }
        }
      }
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable == null)
      {
        urk.c("Q.qqstory.record.HWEditLocalVideoPlayer", "no fragment info should convert I frame");
        return;
      }
      urk.b("Q.qqstory.record.HWEditLocalVideoPlayer", "triggerConvertIFramesRunnable, priorVideoIndex=%d, mFrameRate=%d, mIFrameInterval=%d, mFragmentIndex=%d", Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.jdField_b_of_type_Int), Integer.valueOf(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.jdField_c_of_type_Int));
      return;
    }
    urk.b("Q.qqstory.record.HWEditLocalVideoPlayer", "triggerConvertIFramesRunnable ignore, mFrameRate=%d, mIFrameInterval=%d, mFragmentIndex=%d", Integer.valueOf(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.jdField_b_of_type_Int), Integer.valueOf(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.jdField_c_of_type_Int));
  }
  
  private void n()
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size()) {
      if ((bihz.a((bihz)this.jdField_a_of_type_JavaUtilList.get(i)) == 1) && (TextUtils.isEmpty(((bihz)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_Bigb.e(false);
        if (this.jdField_a_of_type_Bigb.jdField_a_of_type_Biea != null) {
          this.jdField_a_of_type_Bigb.jdField_a_of_type_Biea.b(false);
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
      this.jdField_a_of_type_Bigb.e(true);
    } while (this.jdField_a_of_type_Bigb.jdField_a_of_type_Biea == null);
    this.jdField_a_of_type_Bigb.jdField_a_of_type_Biea.b(true);
  }
  
  public void B_()
  {
    super.B_();
    this.jdField_d_of_type_Boolean = true;
    c(0);
  }
  
  public int a()
  {
    int i = this.jdField_a_of_type_Bigb.a();
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      bihz localbihz = (bihz)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localbihz != null) {
        return bihz.a(localbihz);
      }
    }
    return 0;
  }
  
  public long a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
    {
      bihz localbihz = (bihz)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      return bihz.b(localbihz) - bihz.a(localbihz);
    }
    urk.e("Q.qqstory.record.HWEditLocalVideoPlayer", "getDurationOfFragment with invalid index = %d", new Object[] { Integer.valueOf(paramInt) });
    return 0L;
  }
  
  public Bitmap a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return a((bihz)this.jdField_a_of_type_JavaUtilList.get(paramInt), true);
    }
    urk.e("Q.qqstory.record.HWEditLocalVideoPlayer", "getDurationOfFragment with invalid index = %d", new Object[] { Integer.valueOf(paramInt) });
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
  
  public List<? extends biio> a()
  {
    return Collections.unmodifiableList(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    if ((this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
    {
      Object localObject = (EditTakeVideoSource)this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
      this.jdField_b_of_type_JavaLangString = ((EditTakeVideoSource)localObject).jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = ((EditTakeVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
      this.jdField_a_of_type_JavaLangString = ((EditTakeVideoSource)localObject).jdField_a_of_type_JavaLangString;
      this.jdField_c_of_type_JavaLangString = ((EditTakeVideoSource)localObject).jdField_c_of_type_JavaLangString;
      if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (this.jdField_b_of_type_JavaLangString.endsWith(".mp3")))
      {
        localObject = (bhiu)bhfm.a().c(8);
        MusicItemInfo localMusicItemInfo = MusicProviderView.a(this.jdField_b_of_type_JavaLangString);
        if (localMusicItemInfo != null)
        {
          ((bhiu)localObject).a(localMusicItemInfo);
          localObject = Image2Video.jdField_a_of_type_JavaLangString + "/noaudio";
          bace.c((String)localObject);
          this.jdField_b_of_type_JavaLangString = ((String)localObject);
        }
      }
      bool1 = bigb.a(this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Long, 262144);
      boolean bool2 = VideoEnvironment.b(7);
      urk.d("Q.qqstory.record.HWEditLocalVideoPlayer", "recordMultiVideoFragment = %s, supportMultiVideoFragment = %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bool1) || (!bool2)) {
        break label511;
      }
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      if (this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam = ((FollowCaptureParam)this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle.getSerializable("extra_follow_capture_param"));
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam == null) {
          break label516;
        }
      }
    }
    label516:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.e = bool1;
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView = ((VideoFilterPlayView)a(2131302051));
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setFollowCaptureVideo(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setVisibility(0);
      if (this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("story_game_capture_type", 1) == 2) {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setStoryGamePaths(this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("game_pk_video_path"), this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("game_pk_cover_path"), this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("game_pk_result_path"));
      }
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setBgmFilePath(this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setMediaInfo(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setFilePath(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setRepeat(true);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setSpeedType(0);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setDecodeListener(this);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setPlayViewListener(this);
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setTrackerCallback(new bihx(this));
      a(bigl.class, this);
      this.jdField_a_of_type_Bigb.e(false);
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
    bihz localbihz;
    if ((paramInt == 5) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      localbihz = (bihz)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
      if (localbihz.jdField_a_of_type_JavaLangString == null)
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
        this.jdField_a_of_type_Bigb.B();
        this.jdField_c_of_type_Boolean = false;
      }
      n();
      return;
      urk.b("Q.qqstory.record.HWEditLocalVideoPlayer", "setPlayMode change to iframe video");
      a(localbihz);
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
      urk.a("Q.qqstory.record.HWEditLocalVideoPlayer", "setSlideMode lefPlayMode=%s rightMode=%s, offset=%s", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Float.valueOf(paramFloat));
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
      {
        EditLocalVideoSource localEditLocalVideoSource = (EditLocalVideoSource)this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setColorFilterType(b(paramInt1), b(paramInt2), f, localEditLocalVideoSource.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation);
        return;
      }
    } while (!(this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource));
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setColorFilterType(b(paramInt1), b(paramInt2), f, 0);
  }
  
  public void a(int paramInt, @NonNull bitz parambitz)
  {
    int i;
    bihz localbihz;
    if ((parambitz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
    {
      if (this.jdField_a_of_type_Bjgv != null)
      {
        this.jdField_a_of_type_Bjgv.c();
        this.jdField_a_of_type_Bjgv = null;
      }
      i = this.jdField_a_of_type_JavaUtilList.size();
      if (i <= 1) {
        break label380;
      }
      if (paramInt >= i) {
        break label351;
      }
      localbihz = (bihz)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      parambitz.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.hasFragments = true;
      parambitz.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoNeedRotate = false;
      parambitz.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeStart = ((int)bihz.a(localbihz));
      parambitz.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeEnd = ((int)bihz.b(localbihz));
      parambitz.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mIFrameVideoPath = localbihz.jdField_a_of_type_JavaLangString;
      urk.b("Q.qqstory.record.HWEditLocalVideoPlayer", "editVideoPrePublish : %s", localbihz);
    }
    for (;;)
    {
      boolean bool = vnb.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.record.HWEditLocalVideoPlayer", 2, "landscape:" + bool + " w:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth + " h:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight + " r:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation);
      }
      parambitz.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("landscape_video", Boolean.valueOf(bool));
      parambitz.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("is_follow_capture_video", Boolean.valueOf(this.e));
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam != null)
      {
        parambitz.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("follow_capture_param", FollowCaptureParam.parseToJson(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam));
        parambitz.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("video_type", Integer.valueOf(5));
        parambitz = vnb.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight, awmc.jdField_a_of_type_Int, awmc.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth = ((Integer)parambitz.first).intValue();
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight = ((Integer)parambitz.second).intValue();
      }
      return;
      label351:
      urk.d("Q.qqstory.record.HWEditLocalVideoPlayer", "editVideoPrePublish : get invalid fragment index = %d, fragment count = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      continue;
      label380:
      if (i == 1)
      {
        localbihz = (bihz)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        parambitz.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoNeedRotate = false;
        parambitz.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mIFrameVideoPath = localbihz.jdField_a_of_type_JavaLangString;
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
    int i = this.jdField_a_of_type_Bigb.a();
    bihz localbihz;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localbihz = (bihz)this.jdField_a_of_type_JavaUtilList.get(i);
      bihz.a(localbihz, paramBitmap);
      if ((!bihz.b(localbihz)) && (!paramBoolean)) {
        break label73;
      }
    }
    label73:
    for (paramBoolean = true;; paramBoolean = false)
    {
      bihz.a(localbihz, paramBoolean);
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
    int i = this.jdField_a_of_type_Bigb.a();
    if (i < this.jdField_a_of_type_JavaUtilList.size()) {
      bihz.b((bihz)this.jdField_a_of_type_JavaUtilList.get(i), paramBoolean);
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
        localbibw = (bibw)a(bibw.class);
        if (localbibw != null) {
          localbibw.d();
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
    bibw localbibw = (bibw)a(bibw.class);
    if (localbibw != null) {
      localbibw.ae_();
    }
    this.jdField_c_of_type_Boolean = true;
  }
  
  public boolean a(long paramLong)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      bihz localbihz = (bihz)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
      if ((localbihz != null) && (localbihz.jdField_a_of_type_JavaLangString != null))
      {
        if ((this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView != null) && (!this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a().equalsIgnoreCase(localbihz.jdField_a_of_type_JavaLangString)))
        {
          this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.c();
          this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setFilePath(localbihz.jdField_a_of_type_JavaLangString, localbihz.jdField_b_of_type_JavaLangString);
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
      paramMessage = (bihz)this.jdField_a_of_type_JavaUtilList.get(i);
      urk.b("Q.qqstory.record.HWEditLocalVideoPlayer", "MESSAGE_PLAYING_FRAGMENT_CHANGED : fragment = %s", paramMessage);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setColorFilterType(b(bihz.a(paramMessage)));
      a(bihz.a(paramMessage));
      a(paramMessage);
      c(i);
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(j);
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(j);
    }
    for (;;)
    {
      return false;
      label184:
      urk.e("Q.qqstory.record.HWEditLocalVideoPlayer", "MESSAGE_PLAYING_FRAGMENT_CHANGED : get invalid index=%d, video fragment count = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
    }
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
    urk.a("Q.qqstory.record.HWEditLocalVideoPlayer", "setPlayMode mode=%s", Integer.valueOf(paramInt));
    int i = this.jdField_a_of_type_Bigb.a();
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      bihz localbihz = (bihz)this.jdField_a_of_type_JavaUtilList.get(i);
      if (bihz.a(localbihz) != paramInt)
      {
        bihz.a(localbihz, paramInt);
        bihz.c(localbihz, true);
      }
    }
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a((int)paramLong, paramBoolean);
    }
  }
  
  public void bb_()
  {
    super.bb_();
    this.jdField_d_of_type_Boolean = false;
    if (this.jdField_a_of_type_Bjgv != null)
    {
      this.jdField_a_of_type_Bjgv.c();
      this.jdField_a_of_type_Bjgv = null;
    }
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable = null;
    }
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_Bigb.B();
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  public void bf_()
  {
    super.bf_();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.d();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.onPause();
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
    if ((bhnt.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView != null) && (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.j > 100) && (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.c > 0L))
    {
      int i = this.jdField_a_of_type_Bigb.g();
      float f = this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.j / (float)this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.c * 1000.0F;
      if (urp.a((int)f, 0L, 30L)) {
        urp.a("CamEditFreq", true, 0L, new String[] { String.valueOf(this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int), String.valueOf(f), urp.b(i), String.valueOf(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.j), String.valueOf(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.c) });
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if ((i >= 0) && (i < this.jdField_a_of_type_JavaUtilList.size()))
    {
      paramMessage = (bihz)this.jdField_a_of_type_JavaUtilList.get(i);
      Bitmap localBitmap = a(paramMessage, false);
      if ((localBitmap != null) && (localBitmap != paramMessage.jdField_c_of_type_AndroidGraphicsBitmap))
      {
        paramMessage = paramMessage.a(localBitmap);
        this.jdField_a_of_type_JavaUtilList.set(i, paramMessage);
        urk.b("Q.qqstory.record.HWEditLocalVideoPlayer", "update fragment bitmap : %s", paramMessage);
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
    if (this.jdField_a_of_type_Bigb.jdField_a_of_type_Int == 42) {}
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
    this.jdField_a_of_type_Bigb.a(paramLong2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer
 * JD-Core Version:    0.7.0.1
 */