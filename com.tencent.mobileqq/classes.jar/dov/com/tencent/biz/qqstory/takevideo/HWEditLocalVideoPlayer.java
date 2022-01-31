package dov.com.tencent.biz.qqstory.takevideo;

import alpo;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import azgq;
import bdcs;
import bkka;
import blmf;
import blpo;
import blun;
import bmeu;
import bmgy;
import bmiv;
import bmix;
import bmjh;
import bmkt;
import bmkv;
import bmlk;
import bmwn;
import bnjh;
import bnjk;
import bnjl;
import bnjp;
import bnjs;
import bnjx;
import bnkb;
import bnki;
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
import wsv;
import wta;
import xod;
import xom;

public class HWEditLocalVideoPlayer
  extends bmiv
  implements Handler.Callback, bmjh, bnki, HWDecodeListener
{
  protected int a;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bnjh jdField_a_of_type_Bnjh;
  protected LocalMediaInfo a;
  private FollowCaptureParam jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam;
  private HWEditLocalVideoPlayer.ConvertIFramesRunnable jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable;
  protected VideoFilterPlayView a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new HWEditLocalVideoPlayer.4(this);
  private String jdField_a_of_type_JavaLangString;
  protected List<bmkv> a;
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
  
  public HWEditLocalVideoPlayer(@NonNull bmix parambmix)
  {
    super(parambmix);
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
      localObject = xom.a(paramBitmap.getWidth(), paramBitmap.getHeight(), azgq.jdField_a_of_type_Int, azgq.jdField_b_of_type_Int);
      bnjx localbnjx = new bnjx();
      localbnjx.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam);
      localbnjx.a(paramBitmap.getWidth(), paramBitmap.getHeight());
      localbnjx.onSurfaceCreate();
      localbnjx.onSurfaceChange(((Integer)((Pair)localObject).first).intValue(), ((Integer)((Pair)localObject).second).intValue());
      GLImage localGLImage = new GLImage();
      localGLImage.loadTextureSync(paramBitmap);
      localbnjx.setInputTextureID(localGLImage.getTexture());
      localbnjx.onDrawFrame();
      localObject = GlUtil.captureFrame(localbnjx.getOutputTextureID(), ((Integer)((Pair)localObject).first).intValue(), ((Integer)((Pair)localObject).second).intValue());
      localbnjx.onSurfaceDestroy();
    }
    return localObject;
  }
  
  private Bitmap a(@NonNull bmkv parambmkv, boolean paramBoolean)
  {
    Object localObject1 = bmkv.a(parambmkv);
    long l = this.jdField_a_of_type_Bmix.c() / 1000000L;
    Object localObject2;
    if ((l != 0L) && (paramBoolean))
    {
      localObject2 = bnkb.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo, l);
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
      for (localObject2 = xod.a((Bitmap)localObject1, 360 - k);; localObject2 = localObject1)
      {
        bnjl localbnjl = new bnjl();
        int j = ((Bitmap)localObject2).getWidth();
        int i = ((Bitmap)localObject2).getHeight();
        if (this.e)
        {
          localObject1 = xom.a(((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight(), azgq.jdField_a_of_type_Int, azgq.jdField_b_of_type_Int);
          j = ((Integer)((Pair)localObject1).first).intValue();
          i = ((Integer)((Pair)localObject1).second).intValue();
        }
        localbnjl.a(j, i);
        localObject1 = localObject2;
        if (this.e) {
          localObject1 = a((Bitmap)localObject2);
        }
        QQFilterRenderManager localQQFilterRenderManager = bkka.a(bkka.jdField_c_of_type_Int);
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
            l = this.jdField_a_of_type_Bmix.c();
            localObject3 = localbnjl.a((Bitmap)localObject1, l);
            localObject2 = localObject1;
            if (localObject3 != null) {
              localObject2 = localObject3;
            }
          }
        }
        if ((bmkv.a(parambmkv)) && (bnjk.a(bmkv.a(parambmkv)))) {
          switch (bmkv.a(parambmkv))
          {
          default: 
            localObject1 = null;
            label315:
            if (localObject1 != null)
            {
              ((GPUBaseFilter)localObject1).init();
              localObject3 = localbnjl.a((Bitmap)localObject2, (GPUBaseFilter)localObject1);
              ((GPUBaseFilter)localObject1).destroy();
              wsv.a("Q.qqstory.record.HWEditLocalVideoPlayer", "updateFragmentThumbBitmapIfNeeded, filterThumbBitmap = %s", localObject3);
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
          if (bmkv.b(parambmkv))
          {
            localObject3 = localObject1;
            if (bmkv.b(parambmkv) != null)
            {
              bnjp localbnjp = (bnjp)bnjk.a(106);
              localbnjp.a(bmkv.b(parambmkv));
              localbnjp.init();
              localObject3 = localbnjl.a((Bitmap)localObject1, localbnjp);
              wsv.a("Q.qqstory.record.HWEditLocalVideoPlayer", "updateFragmentThumbBitmapIfNeeded, mosaicThumbBitmap = %s", localObject3);
              if (localObject3 != null) {
                localObject1 = localObject3;
              }
              localbnjp.destroy();
              localObject3 = localObject1;
            }
          }
          if ((localObject2 != null) && (localObject2 != bmkv.a(parambmkv)) && (localObject2 != localObject3)) {
            ((Bitmap)localObject2).recycle();
          }
          if ((localQQFilterRenderManager != null) && (localQQFilterRenderManager.hasQQFilter(183)))
          {
            localObject1 = (PKFilter)localQQFilterRenderManager.getQQFilters(183).get(0);
            localObject2 = new bnjs(((PKFilter)localObject1).getPKCoverPath(), ((PKFilter)localObject1).getPKTitleBmgPath());
            ((bnjs)localObject2).onOutputSizeChanged(((Bitmap)localObject3).getWidth(), ((Bitmap)localObject3).getHeight());
            ((bnjs)localObject2).init();
            localObject1 = localbnjl.a((Bitmap)localObject3, (GPUBaseFilter)localObject2);
            ((bnjs)localObject2).destroy();
            wsv.d("Q.qqstory.record.HWEditLocalVideoPlayer", "handle pk video video cover.");
            if (localObject1 == null) {}
          }
          for (;;)
          {
            localbnjl.a();
            localObject2 = localObject1;
            if (k != 0) {
              localObject2 = xod.a((Bitmap)localObject1, k);
            }
            if ((localObject2 != bmkv.a(parambmkv)) || (bmkv.a(parambmkv)) || (bmkv.b(parambmkv)))
            {
              return localObject2;
              label627:
              l = 0L;
              break;
              localObject1 = bnjk.a(7);
              break label315;
              localObject1 = bnjk.a(4);
              break label315;
              localObject1 = bnjk.a(6);
              break label315;
              localObject1 = bnjk.a(5);
              break label315;
            }
            return parambmkv.jdField_c_of_type_AndroidGraphicsBitmap;
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
  
  private void a(@NonNull bmkv parambmkv)
  {
    wsv.b("Q.qqstory.record.HWEditLocalVideoPlayer", "setPlayInfo，index : %d => %d", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(parambmkv.jdField_c_of_type_Int));
    if (parambmkv.jdField_a_of_type_JavaLangString == null)
    {
      if (!this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a().equalsIgnoreCase(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.c();
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setFilePath(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.b();
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.e();
        this.jdField_b_of_type_Int = 1;
      }
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setPlayRange((int)bmkv.a(parambmkv), (int)bmkv.b(parambmkv));
      if (this.jdField_a_of_type_Bmix.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter != null) {
        this.jdField_a_of_type_Bmix.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a(3, alpo.a(2131706055));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = parambmkv.jdField_c_of_type_Int;
      return;
      if (!this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a().equalsIgnoreCase(parambmkv.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.c();
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setFilePath(parambmkv.jdField_a_of_type_JavaLangString, parambmkv.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.f();
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.b();
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.e();
        this.jdField_b_of_type_Int = 1;
      }
      if (this.jdField_a_of_type_Bmix.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter != null) {
        this.jdField_a_of_type_Bmix.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a(3, "");
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
        localObject = (bmkv)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        if ((!((bmkv)localObject).jdField_a_of_type_Boolean) && (TextUtils.isEmpty(((bmkv)localObject).jdField_a_of_type_JavaLangString)))
        {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable = a(((bmkv)localObject).jdField_c_of_type_Int);
          this.jdField_b_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable, 300L);
        }
      }
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable == null)
      {
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          bmkv localbmkv = (bmkv)((Iterator)localObject).next();
          if ((!localbmkv.jdField_a_of_type_Boolean) && (TextUtils.isEmpty(localbmkv.jdField_a_of_type_JavaLangString)))
          {
            this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable = a(localbmkv.jdField_c_of_type_Int);
            this.jdField_b_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable, 300L);
          }
        }
      }
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable == null)
      {
        wsv.c("Q.qqstory.record.HWEditLocalVideoPlayer", "no fragment info should convert I frame");
        return;
      }
      wsv.b("Q.qqstory.record.HWEditLocalVideoPlayer", "triggerConvertIFramesRunnable, priorVideoIndex=%d, mFrameRate=%d, mIFrameInterval=%d, mFragmentIndex=%d", Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.jdField_b_of_type_Int), Integer.valueOf(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.jdField_c_of_type_Int));
      return;
    }
    wsv.b("Q.qqstory.record.HWEditLocalVideoPlayer", "triggerConvertIFramesRunnable ignore, mFrameRate=%d, mIFrameInterval=%d, mFragmentIndex=%d", Integer.valueOf(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.jdField_b_of_type_Int), Integer.valueOf(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.jdField_c_of_type_Int));
  }
  
  private void n()
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size()) {
      if ((bmkv.a((bmkv)this.jdField_a_of_type_JavaUtilList.get(i)) == 1) && (TextUtils.isEmpty(((bmkv)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_Bmix.e(false);
        if (this.jdField_a_of_type_Bmix.jdField_a_of_type_Bmgy != null) {
          this.jdField_a_of_type_Bmix.jdField_a_of_type_Bmgy.b(false);
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
      this.jdField_a_of_type_Bmix.e(true);
    } while (this.jdField_a_of_type_Bmix.jdField_a_of_type_Bmgy == null);
    this.jdField_a_of_type_Bmix.jdField_a_of_type_Bmgy.b(true);
  }
  
  public int a()
  {
    int i = this.jdField_a_of_type_Bmix.a();
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      bmkv localbmkv = (bmkv)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localbmkv != null) {
        return bmkv.a(localbmkv);
      }
    }
    return 0;
  }
  
  public long a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
    {
      bmkv localbmkv = (bmkv)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      return bmkv.b(localbmkv) - bmkv.a(localbmkv);
    }
    wsv.e("Q.qqstory.record.HWEditLocalVideoPlayer", "getDurationOfFragment with invalid index = %d", new Object[] { Integer.valueOf(paramInt) });
    return 0L;
  }
  
  public Bitmap a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return a((bmkv)this.jdField_a_of_type_JavaUtilList.get(paramInt), true);
    }
    wsv.e("Q.qqstory.record.HWEditLocalVideoPlayer", "getDurationOfFragment with invalid index = %d", new Object[] { Integer.valueOf(paramInt) });
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
  
  public List<? extends bmlk> a()
  {
    return Collections.unmodifiableList(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    if ((this.jdField_a_of_type_Bmix.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
    {
      Object localObject = (EditTakeVideoSource)this.jdField_a_of_type_Bmix.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
      this.jdField_b_of_type_JavaLangString = ((EditTakeVideoSource)localObject).jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = ((EditTakeVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
      this.jdField_a_of_type_JavaLangString = ((EditTakeVideoSource)localObject).jdField_a_of_type_JavaLangString;
      this.jdField_c_of_type_JavaLangString = ((EditTakeVideoSource)localObject).jdField_c_of_type_JavaLangString;
      if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (this.jdField_b_of_type_JavaLangString.endsWith(".mp3")))
      {
        localObject = (blpo)blmf.a().c(8);
        MusicItemInfo localMusicItemInfo = MusicProviderView.a(this.jdField_b_of_type_JavaLangString);
        if (localMusicItemInfo != null)
        {
          ((blpo)localObject).a(localMusicItemInfo);
          localObject = Image2Video.jdField_a_of_type_JavaLangString + "/noaudio";
          bdcs.c((String)localObject);
          this.jdField_b_of_type_JavaLangString = ((String)localObject);
        }
      }
      bool1 = bmix.a(this.jdField_a_of_type_Bmix.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Long, 262144);
      boolean bool2 = VideoEnvironment.b(7);
      wsv.d("Q.qqstory.record.HWEditLocalVideoPlayer", "recordMultiVideoFragment = %s, supportMultiVideoFragment = %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bool1) || (!bool2)) {
        break label511;
      }
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      if (this.jdField_a_of_type_Bmix.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam = ((FollowCaptureParam)this.jdField_a_of_type_Bmix.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle.getSerializable("extra_follow_capture_param"));
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam == null) {
          break label516;
        }
      }
    }
    label516:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.e = bool1;
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView = ((VideoFilterPlayView)a(2131367798));
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setFollowCaptureVideo(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setVisibility(0);
      if (this.jdField_a_of_type_Bmix.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("story_game_capture_type", 1) == 2) {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setStoryGamePaths(this.jdField_a_of_type_Bmix.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("game_pk_video_path"), this.jdField_a_of_type_Bmix.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("game_pk_cover_path"), this.jdField_a_of_type_Bmix.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("game_pk_result_path"));
      }
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setBgmFilePath(this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setMediaInfo(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setFilePath(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setRepeat(true);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setSpeedType(0);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setDecodeListener(this);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setPlayViewListener(this);
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setTrackerCallback(new bmkt(this));
      a(bmjh.class, this);
      this.jdField_a_of_type_Bmix.e(false);
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
    bmkv localbmkv;
    if ((paramInt == 5) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      localbmkv = (bmkv)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
      if (localbmkv.jdField_a_of_type_JavaLangString == null)
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
        this.jdField_a_of_type_Bmix.B();
        this.jdField_c_of_type_Boolean = false;
      }
      n();
      return;
      wsv.b("Q.qqstory.record.HWEditLocalVideoPlayer", "setPlayMode change to iframe video");
      a(localbmkv);
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
      wsv.a("Q.qqstory.record.HWEditLocalVideoPlayer", "setSlideMode lefPlayMode=%s rightMode=%s, offset=%s", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Float.valueOf(paramFloat));
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_Bmix.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
      {
        EditLocalVideoSource localEditLocalVideoSource = (EditLocalVideoSource)this.jdField_a_of_type_Bmix.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setColorFilterType(b(paramInt1), b(paramInt2), f, localEditLocalVideoSource.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation);
        return;
      }
    } while (!(this.jdField_a_of_type_Bmix.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource));
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setColorFilterType(b(paramInt1), b(paramInt2), f, 0);
  }
  
  public void a(int paramInt, @NonNull bmwn parambmwn)
  {
    int i;
    bmkv localbmkv;
    if ((parambmwn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
    {
      if (this.jdField_a_of_type_Bnjh != null)
      {
        this.jdField_a_of_type_Bnjh.c();
        this.jdField_a_of_type_Bnjh = null;
      }
      i = this.jdField_a_of_type_JavaUtilList.size();
      if (i <= 1) {
        break label380;
      }
      if (paramInt >= i) {
        break label351;
      }
      localbmkv = (bmkv)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      parambmwn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.hasFragments = true;
      parambmwn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoNeedRotate = false;
      parambmwn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeStart = ((int)bmkv.a(localbmkv));
      parambmwn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeEnd = ((int)bmkv.b(localbmkv));
      parambmwn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mIFrameVideoPath = localbmkv.jdField_a_of_type_JavaLangString;
      wsv.b("Q.qqstory.record.HWEditLocalVideoPlayer", "editVideoPrePublish : %s", localbmkv);
    }
    for (;;)
    {
      boolean bool = xom.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.record.HWEditLocalVideoPlayer", 2, "landscape:" + bool + " w:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth + " h:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight + " r:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation);
      }
      parambmwn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("landscape_video", Boolean.valueOf(bool));
      parambmwn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("is_follow_capture_video", Boolean.valueOf(this.e));
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam != null)
      {
        parambmwn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("follow_capture_param", FollowCaptureParam.parseToJson(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam));
        parambmwn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("video_type", Integer.valueOf(5));
        parambmwn = xom.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight, azgq.jdField_a_of_type_Int, azgq.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth = ((Integer)parambmwn.first).intValue();
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight = ((Integer)parambmwn.second).intValue();
      }
      return;
      label351:
      wsv.d("Q.qqstory.record.HWEditLocalVideoPlayer", "editVideoPrePublish : get invalid fragment index = %d, fragment count = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      continue;
      label380:
      if (i == 1)
      {
        localbmkv = (bmkv)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        parambmwn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoNeedRotate = false;
        parambmwn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mIFrameVideoPath = localbmkv.jdField_a_of_type_JavaLangString;
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
    int i = this.jdField_a_of_type_Bmix.a();
    bmkv localbmkv;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localbmkv = (bmkv)this.jdField_a_of_type_JavaUtilList.get(i);
      bmkv.a(localbmkv, paramBitmap);
      if ((!bmkv.b(localbmkv)) && (!paramBoolean)) {
        break label73;
      }
    }
    label73:
    for (paramBoolean = true;; paramBoolean = false)
    {
      bmkv.a(localbmkv, paramBoolean);
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
    int i = this.jdField_a_of_type_Bmix.a();
    if (i < this.jdField_a_of_type_JavaUtilList.size()) {
      bmkv.b((bmkv)this.jdField_a_of_type_JavaUtilList.get(i), paramBoolean);
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
        localbmeu = (bmeu)a(bmeu.class);
        if (localbmeu != null) {
          localbmeu.d();
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
    bmeu localbmeu = (bmeu)a(bmeu.class);
    if (localbmeu != null) {
      localbmeu.aj_();
    }
    this.jdField_c_of_type_Boolean = true;
  }
  
  public boolean a(long paramLong)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      bmkv localbmkv = (bmkv)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
      if ((localbmkv != null) && (localbmkv.jdField_a_of_type_JavaLangString != null))
      {
        if ((this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView != null) && (!this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a().equalsIgnoreCase(localbmkv.jdField_a_of_type_JavaLangString)))
        {
          this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.c();
          this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setFilePath(localbmkv.jdField_a_of_type_JavaLangString, localbmkv.jdField_b_of_type_JavaLangString);
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
      paramMessage = (bmkv)this.jdField_a_of_type_JavaUtilList.get(i);
      wsv.b("Q.qqstory.record.HWEditLocalVideoPlayer", "MESSAGE_PLAYING_FRAGMENT_CHANGED : fragment = %s", paramMessage);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setColorFilterType(b(bmkv.a(paramMessage)));
      a(bmkv.a(paramMessage));
      a(paramMessage);
      c(i);
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(j);
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(j);
    }
    for (;;)
    {
      return false;
      label184:
      wsv.e("Q.qqstory.record.HWEditLocalVideoPlayer", "MESSAGE_PLAYING_FRAGMENT_CHANGED : get invalid index=%d, video fragment count = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
    }
  }
  
  public void aZ_()
  {
    super.aZ_();
    this.jdField_d_of_type_Boolean = false;
    if (this.jdField_a_of_type_Bnjh != null)
    {
      this.jdField_a_of_type_Bnjh.c();
      this.jdField_a_of_type_Bnjh = null;
    }
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable = null;
    }
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_Bmix.B();
      this.jdField_c_of_type_Boolean = false;
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
    wsv.a("Q.qqstory.record.HWEditLocalVideoPlayer", "setPlayMode mode=%s", Integer.valueOf(paramInt));
    int i = this.jdField_a_of_type_Bmix.a();
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      bmkv localbmkv = (bmkv)this.jdField_a_of_type_JavaUtilList.get(i);
      if (bmkv.a(localbmkv) != paramInt)
      {
        bmkv.a(localbmkv, paramInt);
        bmkv.c(localbmkv, true);
      }
    }
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a((int)paramLong, paramBoolean);
    }
  }
  
  public void bd_()
  {
    super.bd_();
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
    if ((blun.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView != null) && (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.j > 100) && (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.c > 0L))
    {
      int i = this.jdField_a_of_type_Bmix.g();
      float f = this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.j / (float)this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.c * 1000.0F;
      if (wta.a((int)f, 0L, 30L)) {
        wta.a("CamEditFreq", true, 0L, new String[] { String.valueOf(this.jdField_a_of_type_Bmix.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int), String.valueOf(f), wta.b(i), String.valueOf(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.j), String.valueOf(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.c) });
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if ((i >= 0) && (i < this.jdField_a_of_type_JavaUtilList.size()))
    {
      paramMessage = (bmkv)this.jdField_a_of_type_JavaUtilList.get(i);
      Bitmap localBitmap = a(paramMessage, false);
      if ((localBitmap != null) && (localBitmap != paramMessage.jdField_c_of_type_AndroidGraphicsBitmap))
      {
        paramMessage = paramMessage.a(localBitmap);
        this.jdField_a_of_type_JavaUtilList.set(i, paramMessage);
        wsv.b("Q.qqstory.record.HWEditLocalVideoPlayer", "update fragment bitmap : %s", paramMessage);
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
    if (this.jdField_a_of_type_Bmix.jdField_a_of_type_Int == 42) {}
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
    this.jdField_a_of_type_Bmix.a(paramLong2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer
 * JD-Core Version:    0.7.0.1
 */