package com.tencent.mobileqq.shortvideo.filter;

import aibf;
import aibg;
import aibh;
import android.annotation.SuppressLint;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.av.opengl.filter.qqavimage.QQAVImageFilterConstants;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.richmedia.capture.gesture.GLGestureProxy;
import com.tencent.mobileqq.richmedia.capture.gesture.MovieFilterGesture;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager;
import com.tencent.mobileqq.shortvideo.facedancegame.FaceDanceDetectTask;
import com.tencent.mobileqq.shortvideo.facedancegame.FaceDanceDetectTask.FaceDetectTaskResult;
import com.tencent.mobileqq.shortvideo.facedancegame.IFaceDetectCallBack;
import com.tencent.mobileqq.shortvideo.gesture.GestureKeyInfo;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgrRecognize;
import com.tencent.mobileqq.shortvideo.ptvfilter.GroupVideoFilterList;
import com.tencent.mobileqq.shortvideo.ptvfilter.VideoFilterList;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.MovieMaterial;
import com.tencent.mobileqq.shortvideo.resource.ArtFilterResource;
import com.tencent.mobileqq.shortvideo.resource.GestureResource;
import com.tencent.mobileqq.shortvideo.resource.PtuFilterResource;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.mobileqq.shortvideo.util.FileUtil;
import com.tencent.mobileqq.shortvideo.util.SoLoader;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import com.tencent.ttpic.facedetect.FaceDetector;
import com.tencent.ttpic.facedetect.FaceDetector.FACE_DETECT_MODE;
import com.tencent.ttpic.facedetect.FaceDetectorManager;
import com.tencent.ttpic.util.RetrieveDataManager;
import com.tencent.ttpic.util.RetrieveDataManager.DATA_TYPE;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoPrefsUtil;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;
import com.tencent.view.RendererUtils;
import com.tencent.ytcommon.util.YTCommonInterface;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@SuppressLint({"NewApi"})
public class QQFilterRenderManager
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  private aibh jdField_a_of_type_Aibh = new aibh(null);
  private MusicItemInfo jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
  private MovieFilterGesture jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureMovieFilterGesture;
  private QQDanceEventHandler jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQDanceEventHandler;
  public GestureKeyInfo a;
  private MovieMaterial jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterMaterialMovieMaterial;
  public FaceDetector a;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private List jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private final Map jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  public boolean a;
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long = 0L;
  private List jdField_b_of_type_JavaUtilList = new CopyOnWriteArrayList();
  public boolean b;
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long = 0L;
  public boolean c;
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long = 0L;
  public boolean d;
  private int jdField_e_of_type_Int;
  private long jdField_e_of_type_Long = 0L;
  public boolean e;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean = false;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean = false;
  
  public QQFilterRenderManager()
  {
    this.jdField_a_of_type_ComTencentTtpicFacedetectFaceDetector = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureKeyInfo = null;
    this.jdField_e_of_type_Boolean = false;
  }
  
  public QQFilterRenderManager(int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_ComTencentTtpicFacedetectFaceDetector = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureKeyInfo = null;
    this.jdField_e_of_type_Boolean = false;
    if (paramArrayOfInt != null)
    {
      int j = paramArrayOfInt.length;
      if (i < j)
      {
        switch (paramArrayOfInt[i])
        {
        }
        for (;;)
        {
          i += 1;
          break;
          r();
          continue;
          a();
          continue;
          a();
          continue;
          j();
          continue;
          i();
          continue;
          a();
          continue;
          h();
          continue;
          s();
          continue;
          m();
          continue;
          n();
          continue;
          a();
          continue;
          a();
        }
      }
    }
  }
  
  private void a(int paramInt, aibh paramaibh)
  {
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtimeNanos();
    int i = RetrieveDataManager.DATA_TYPE.RGBA.value;
    if (this.jdField_a_of_type_ComTencentTtpicFacedetectFaceDetector != null) {
      i = this.jdField_a_of_type_ComTencentTtpicFacedetectFaceDetector.getDataType().value;
    }
    paramaibh.jdField_a_of_type_ArrayOfByte = RetrieveDataManager.getInstance().retrieveData(i, paramInt, paramaibh.jdField_a_of_type_Int, paramaibh.jdField_b_of_type_Int);
    this.jdField_b_of_type_Long = SystemClock.elapsedRealtimeNanos();
    if (SLog.a()) {
      SLog.d("QQFilterRenderManager", "FilterProcessRender_showPreview[doFaceDetectInitAndFlip " + (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long) / 1000L + "us]");
    }
  }
  
  private void a(aibh paramaibh, boolean paramBoolean)
  {
    try
    {
      this.jdField_a_of_type_Long = SystemClock.elapsedRealtimeNanos();
      if (paramBoolean) {}
      for (;;)
      {
        this.jdField_b_of_type_Long = SystemClock.elapsedRealtimeNanos();
        long l = (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long) / 1000L;
        if (SLog.a()) {
          SLog.d("QQFilterRenderManager", "FilterProcessRender_showPreview[doTrackProceses=" + l + "us] forceDetect=" + paramBoolean);
        }
        if ((paramBoolean) || (this.jdField_a_of_type_ComTencentTtpicFacedetectFaceDetector.needDetectFace())) {
          this.jdField_a_of_type_ComTencentTtpicFacedetectFaceDetector.postJob(new aibg(this, paramaibh));
        }
        if (!this.jdField_a_of_type_ComTencentTtpicFacedetectFaceDetector.detectExpression(2)) {
          break;
        }
        this.jdField_a_of_type_Boolean = true;
        return;
        this.jdField_a_of_type_ComTencentTtpicFacedetectFaceDetector.doTrack(paramaibh.jdField_a_of_type_ArrayOfByte, paramaibh.jdField_a_of_type_Int, paramaibh.jdField_b_of_type_Int);
      }
      this.jdField_a_of_type_Boolean = false;
    }
    catch (Throwable paramaibh)
    {
      paramaibh.printStackTrace();
      return;
    }
  }
  
  private void b(FilterDesc paramFilterDesc)
  {
    Object localObject = a(70);
    if ((localObject != null) && (((List)localObject).size() == 1))
    {
      localObject = (QQAVFilter)((List)localObject).get(0);
      if (localObject != null) {
        ((QQAVFilter)localObject).a(paramFilterDesc);
      }
    }
  }
  
  private void c(FilterDesc paramFilterDesc)
  {
    Object localObject = a(80);
    if ((localObject != null) && (((List)localObject).size() == 1))
    {
      localObject = (QQSpecialAVFilter)((List)localObject).get(0);
      if (localObject != null) {
        ((QQSpecialAVFilter)localObject).a(paramFilterDesc);
      }
    }
  }
  
  private void d(FilterDesc paramFilterDesc)
  {
    List localList = a(90);
    if ((localList != null) && (localList.size() == 1))
    {
      if (paramFilterDesc == null) {
        QmcfManager.a().b(0);
      }
    }
    else {
      return;
    }
    int i = QmcfManager.a().a(paramFilterDesc.jdField_a_of_type_Int);
    QmcfManager.a().a(i, paramFilterDesc.b(SdkContext.a().a().a().a()));
  }
  
  private void d(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        FilterDesc localFilterDesc = (FilterDesc)paramList.next();
        this.jdField_a_of_type_JavaUtilList.add(localFilterDesc);
      }
    }
  }
  
  private void q()
  {
    this.jdField_g_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    GestureMgrRecognize.a().b();
  }
  
  private void r()
  {
    a(new QQPtvVideoFilter(40, this));
  }
  
  private void s()
  {
    a(new QQMovieFilter(this));
  }
  
  private void t()
  {
    VideoPreviewFaceOutlineDetector.getInstance().setFaceDetectMode(FaceDetector.FACE_DETECT_MODE.MULTIPLE);
    RendererUtils.setEnableLog(false);
  }
  
  private void u()
  {
    q();
    a(null);
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  public float a()
  {
    QQSpecialAVFilter.MusicWaveformSupporter localMusicWaveformSupporter = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localMusicWaveformSupporter = (QQSpecialAVFilter.MusicWaveformSupporter)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localMusicWaveformSupporter != null) {
      return localMusicWaveformSupporter.a();
    }
    return -1.0F;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(int paramInt)
  {
    QQFilterLogManager.b();
    QQBaseFilter localQQBaseFilter1 = a();
    int j;
    if (localQQBaseFilter1 != null)
    {
      i = 0;
      for (;;)
      {
        j = paramInt;
        if (i >= this.jdField_b_of_type_JavaUtilList.size()) {
          break;
        }
        QQFilterLogManager.a();
        QQBaseFilter localQQBaseFilter2 = (QQBaseFilter)this.jdField_b_of_type_JavaUtilList.get(i);
        j = paramInt;
        if (localQQBaseFilter1.a(localQQBaseFilter2.c()))
        {
          localQQBaseFilter2.b(paramInt);
          localQQBaseFilter2.h();
          j = localQQBaseFilter2.b();
        }
        QQFilterLogManager.a("ManualMode" + localQQBaseFilter2.getClass().getName());
        i += 1;
        paramInt = j;
      }
    }
    int i = 0;
    for (;;)
    {
      j = paramInt;
      if (i >= this.jdField_b_of_type_JavaUtilList.size()) {
        break;
      }
      QQFilterLogManager.a();
      localQQBaseFilter1 = (QQBaseFilter)this.jdField_b_of_type_JavaUtilList.get(i);
      j = paramInt;
      if (localQQBaseFilter1.d() != 1)
      {
        localQQBaseFilter1.b(paramInt);
        localQQBaseFilter1.h();
        j = localQQBaseFilter1.b();
      }
      QQFilterLogManager.a("NormalMode" + localQQBaseFilter1.getClass().getName());
      i += 1;
      paramInt = j;
    }
    QQFilterLogManager.c();
    return j;
  }
  
  public int a(String paramString)
  {
    paramString = (String)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (!TextUtils.isEmpty(paramString)) {
      return Integer.parseInt(paramString);
    }
    return -1;
  }
  
  public long a()
  {
    return this.jdField_e_of_type_Long;
  }
  
  public FilterDesc a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FilterDesc localFilterDesc = (FilterDesc)localIterator.next();
      if ((localFilterDesc != null) && (QQAVImageFilterConstants.a(localFilterDesc.jdField_b_of_type_Int) == paramInt)) {
        return localFilterDesc;
      }
    }
    return null;
  }
  
  public MusicItemInfo a()
  {
    FilterDesc localFilterDesc = a(2);
    if ((localFilterDesc != null) && (QQAVImageFilterConstants.a(localFilterDesc.jdField_b_of_type_Int))) {
      return this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
    }
    return null;
  }
  
  public QQAVFilter a()
  {
    QQAVFilter localQQAVFilter = new QQAVFilter(70, this);
    a(localQQAVFilter);
    return localQQAVFilter;
  }
  
  public QQBaseFilter a()
  {
    Object localObject = b(1);
    if (((List)localObject).size() > 0)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        QQBaseFilter localQQBaseFilter = (QQBaseFilter)((Iterator)localObject).next();
        if (localQQBaseFilter.i_()) {
          return localQQBaseFilter;
        }
      }
    }
    return null;
  }
  
  public QQDanceEventHandler a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQDanceEventHandler;
  }
  
  public QQDanceGameFilter a()
  {
    QQDanceGameFilter localQQDanceGameFilter = new QQDanceGameFilter(130, this);
    a(localQQDanceGameFilter);
    return localQQDanceGameFilter;
  }
  
  public QQFaceDanceMechineFilter a()
  {
    QQFaceDanceMechineFilter localQQFaceDanceMechineFilter = new QQFaceDanceMechineFilter(140, this);
    a(localQQFaceDanceMechineFilter);
    return localQQFaceDanceMechineFilter;
  }
  
  public QQSVArtFilterNew a()
  {
    QQSVArtFilterNew localQQSVArtFilterNew = new QQSVArtFilterNew(90, this);
    a(localQQSVArtFilterNew);
    return localQQSVArtFilterNew;
  }
  
  public QQSpecialAVFilter a()
  {
    QQSpecialAVFilter localQQSpecialAVFilter = new QQSpecialAVFilter(80, this);
    a(localQQSpecialAVFilter);
    return localQQSpecialAVFilter;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public List a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      QQBaseFilter localQQBaseFilter = (QQBaseFilter)localIterator.next();
      if (localQQBaseFilter.c() == paramInt) {
        localArrayList.add(localQQBaseFilter);
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    Iterator localIterator;
    if (QmcfManager.a().a() == 2)
    {
      localIterator = a(130).iterator();
      while (localIterator.hasNext()) {
        ((QQDanceGameFilter)localIterator.next()).a();
      }
    }
    if (QQFaceDanceMechineFilter.jdField_a_of_type_Boolean)
    {
      localIterator = a(140).iterator();
      while (localIterator.hasNext()) {
        ((QQFaceDanceMechineFilter)localIterator.next()).a();
      }
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterMaterialMovieMaterial == null) || (!FileUtil.b(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterMaterialMovieMaterial.e))) {}
    for (;;)
    {
      return;
      paramFloat1 = (paramFloat3 / 2.0F - paramFloat1) / (paramFloat3 / 2.0F);
      paramFloat2 = (paramFloat2 - paramFloat4 / 2.0F) / (paramFloat4 / 2.0F);
      Object localObject = a(100);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((QQMovieFilter)((Iterator)localObject).next()).a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterMaterialMovieMaterial.e, this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterMaterialMovieMaterial.f, this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterMaterialMovieMaterial.jdField_d_of_type_Boolean, paramFloat1 * 0.5F, paramFloat2 * 0.5F, null);
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    e();
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_Aibh.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Aibh.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
      if (this.jdField_f_of_type_Boolean)
      {
        a(paramInt, this.jdField_a_of_type_Aibh);
        a(this.jdField_a_of_type_Aibh, false);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    a(new QQScaleFilter(150, this, paramInt1, paramInt2));
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_d_of_type_Int = paramInt3;
    this.jdField_e_of_type_Int = paramInt4;
    this.jdField_f_of_type_Int = paramInt1;
    this.jdField_g_of_type_Int = paramInt2;
    this.jdField_a_of_type_Int = ((int)(this.jdField_f_of_type_Int * VideoMaterialUtil.SCALE_FACE_DETECT));
    this.jdField_b_of_type_Int = ((int)(this.jdField_g_of_type_Int * VideoMaterialUtil.SCALE_FACE_DETECT));
    this.jdField_c_of_type_Int = (this.jdField_a_of_type_Int * this.jdField_b_of_type_Int * 4);
    if (SLog.a()) {
      SLog.d("QQFilterRenderManager", "updatePreviewSize:: mSufaceWidth=" + this.jdField_d_of_type_Int + ";mSufaceHeight=" + this.jdField_e_of_type_Int + ";mFilterWidth=" + this.jdField_f_of_type_Int + ";mFilterHeight=" + this.jdField_g_of_type_Int + ";mFaceDetectWidth" + this.jdField_a_of_type_Int + ";mFaceDetectHeight=" + this.jdField_b_of_type_Int);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      QQBaseFilter localQQBaseFilter = (QQBaseFilter)localIterator.next();
      if (localQQBaseFilter.c() == paramInt1) {
        localQQBaseFilter.a(paramInt2, paramArrayOfInt);
      }
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_e_of_type_Long = paramLong;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.jdField_c_of_type_Long = paramLong1;
    this.jdField_d_of_type_Long = paramLong2;
  }
  
  public void a(FilterDesc paramFilterDesc)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramFilterDesc);
    d(localArrayList);
    if (paramFilterDesc == null)
    {
      b(null);
      c(null);
      d(null);
      SLog.c("FilterRender", "set currentFilter null");
      return;
    }
    SLog.c("FilterRender", "set currentFilter " + paramFilterDesc.e);
    if (paramFilterDesc.jdField_a_of_type_Int == 0)
    {
      b(paramFilterDesc);
      c(null);
      d(null);
      return;
    }
    if (paramFilterDesc.jdField_a_of_type_Int == 2)
    {
      b(null);
      c(paramFilterDesc);
      d(null);
      return;
    }
    if ((paramFilterDesc.jdField_a_of_type_Int == 1) || (paramFilterDesc.jdField_a_of_type_Int == 3))
    {
      b(null);
      c(null);
      d(paramFilterDesc);
      return;
    }
    SLog.a("FilterRender", "set currentFilter unKnown");
  }
  
  public void a(QQBaseFilter paramQQBaseFilter)
  {
    if (paramQQBaseFilter.c() <= 0) {
      return;
    }
    if (this.jdField_b_of_type_JavaUtilList.size() == 0)
    {
      this.jdField_b_of_type_JavaUtilList.add(paramQQBaseFilter);
      return;
    }
    int k = this.jdField_b_of_type_JavaUtilList.size();
    int i = 0;
    int j = -1;
    while ((i < k) && (paramQQBaseFilter.c() >= ((QQBaseFilter)this.jdField_b_of_type_JavaUtilList.get(i)).c()))
    {
      j = i + 1;
      i += 1;
    }
    if (j == -1)
    {
      this.jdField_b_of_type_JavaUtilList.add(0, paramQQBaseFilter);
      return;
    }
    this.jdField_b_of_type_JavaUtilList.add(j, paramQQBaseFilter);
  }
  
  public void a(QQDanceEventHandler paramQQDanceEventHandler)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQDanceEventHandler = paramQQDanceEventHandler;
  }
  
  public void a(QQSpecialAVFilter.MusicWaveformSupporter paramMusicWaveformSupporter)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramMusicWaveformSupporter);
    if (paramMusicWaveformSupporter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = paramMusicWaveformSupporter.a();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = null;
  }
  
  public void a(GroupVideoFilterList paramGroupVideoFilterList)
  {
    Object localObject = a(40);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((QQPtvVideoFilter)((Iterator)localObject).next()).a(paramGroupVideoFilterList, this.jdField_f_of_type_Int, this.jdField_g_of_type_Int, 1.0D);
      }
    }
  }
  
  public void a(VideoFilterList paramVideoFilterList)
  {
    Object localObject = a(40);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((QQPtvVideoFilter)((Iterator)localObject).next()).a(paramVideoFilterList, this.jdField_f_of_type_Int, this.jdField_g_of_type_Int, 1.0D);
      }
    }
  }
  
  public void a(MovieMaterial paramMovieMaterial)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterMaterialMovieMaterial = paramMovieMaterial;
    if ((paramMovieMaterial != null) && (paramMovieMaterial.jdField_a_of_type_Boolean)) {
      if (FileUtil.a(paramMovieMaterial.e))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureMovieFilterGesture == null) {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureMovieFilterGesture = new MovieFilterGesture(this, GLGestureProxy.a());
        }
        GLGestureProxy.a().b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureMovieFilterGesture);
        GLGestureProxy.a().a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureMovieFilterGesture);
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureMovieFilterGesture == null) {
      return;
    }
    GLGestureProxy.a().b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureMovieFilterGesture);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureMovieFilterGesture = null;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      QQFaceDanceMechineFilter.jdField_a_of_type_Boolean = false;
      ResourceManager.a().a(0);
    }
    List localList;
    do
    {
      return;
      a(null, null, null);
      QmcfManager.a().b(0);
      a(null);
      localList = a(140);
    } while ((localList == null) || (localList.size() != 1));
    ((QQBaseFilter)localList.get(0)).a(1, new int[] { 10, 20, 140 });
    ResourceManager.a().a(1);
    ResourceManager.a().a(paramString1);
    ResourceManager.a().b(paramString2);
    QQFaceDanceMechineFilter.jdField_a_of_type_Boolean = true;
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      if (QmcfManager.a().a() == 2) {
        QmcfManager.a().b(0);
      }
    }
    List localList;
    do
    {
      return;
      a(null, null);
      QQFaceDanceMechineFilter.jdField_a_of_type_Boolean = false;
      a(null);
      localList = a(130);
    } while ((localList == null) || (localList.size() != 1));
    ((QQBaseFilter)localList.get(0)).a(1, new int[] { 10, 130 });
    ResourceManager.a().a(0);
    ResourceManager.a().a(paramString1);
    ResourceManager.a().b(paramString2);
    QmcfManager.a().a(2, paramString3);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, HWDecodeListener paramHWDecodeListener, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f1 = 0.0F;
    float f2 = 0.0F;
    if ((paramFloat1 != 0.0F) || (paramFloat2 != 0.0F) || (paramFloat3 != 0.0F) || (paramFloat4 != 0.0F))
    {
      f1 = (paramFloat3 / 2.0F - paramFloat1) / (paramFloat3 / 2.0F) * 0.5F;
      f2 = (paramFloat2 - paramFloat4 / 2.0F) / (paramFloat4 / 2.0F) * 0.5F;
    }
    Object localObject = a(100);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((QQMovieFilter)((Iterator)localObject).next()).a(paramString1, paramString2, paramBoolean, f1, f2, paramHWDecodeListener);
      }
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    List localList = a(110);
    if ((localList != null) && (localList.size() > 0)) {
      ((QQTrackerStickersFilter)localList.get(0)).a(paramArrayList);
    }
  }
  
  public void a(List paramList)
  {
    d(paramList);
    b(null);
    c(null);
    if ((paramList == null) || (paramList.size() == 0)) {
      d(null);
    }
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        FilterDesc localFilterDesc = (FilterDesc)paramList.next();
        if (localFilterDesc != null)
        {
          int i = QQAVImageFilterConstants.a(localFilterDesc.jdField_b_of_type_Int);
          if (i == 0)
          {
            d(null);
            b(localFilterDesc);
          }
          else if (i == 2)
          {
            d(null);
            c(localFilterDesc);
          }
          else if (i == 1)
          {
            d(localFilterDesc);
          }
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, IFaceDetectCallBack paramIFaceDetectCallBack)
  {
    try
    {
      long l = SystemClock.elapsedRealtimeNanos();
      this.jdField_a_of_type_ComTencentTtpicFacedetectFaceDetector.doTrack(paramArrayOfByte, paramInt1, paramInt2);
      FaceDanceDetectTask.a("mFaceDetector.doTrack", l, SystemClock.elapsedRealtimeNanos());
      if (this.jdField_a_of_type_ComTencentTtpicFacedetectFaceDetector.needDetectFace())
      {
        this.jdField_a_of_type_ComTencentTtpicFacedetectFaceDetector.postJob(new aibf(this, paramArrayOfByte, paramInt1, paramInt2, paramIFaceDetectCallBack));
        return;
      }
      if (paramIFaceDetectCallBack == null) {
        return;
      }
      paramArrayOfByte = new FaceDanceDetectTask.FaceDetectTaskResult();
      if (this.jdField_a_of_type_ComTencentTtpicFacedetectFaceDetector.getFaceCount() <= 0) {
        break label161;
      }
      bool = true;
    }
    catch (Throwable paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        if (paramIFaceDetectCallBack == null) {
          break;
        }
        paramArrayOfByte = new FaceDanceDetectTask.FaceDetectTaskResult();
        paramArrayOfByte.jdField_a_of_type_Boolean = false;
        paramIFaceDetectCallBack.a(paramArrayOfByte);
        return;
        label161:
        boolean bool = false;
      }
    }
    paramArrayOfByte.jdField_a_of_type_Boolean = bool;
    if (paramArrayOfByte.jdField_a_of_type_Boolean)
    {
      paramArrayOfByte.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentTtpicFacedetectFaceDetector.getAllPoints(0);
      paramArrayOfByte.jdField_a_of_type_ArrayOfFloat = this.jdField_a_of_type_ComTencentTtpicFacedetectFaceDetector.getFaceAngles(0);
    }
    paramIFaceDetectCallBack.a(paramArrayOfByte);
    return;
  }
  
  public boolean a()
  {
    return (a() != null) && (a().size() > 0);
  }
  
  public boolean a(String paramString)
  {
    paramString = (String)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (!TextUtils.isEmpty(paramString)) {
      return Boolean.parseBoolean(paramString);
    }
    return false;
  }
  
  public byte[] a()
  {
    if (this.jdField_b_of_type_Boolean) {
      return this.jdField_a_of_type_Aibh.jdField_a_of_type_ArrayOfByte;
    }
    return null;
  }
  
  public byte[] a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtimeNanos();
    int i = RetrieveDataManager.DATA_TYPE.RGBA.value;
    if (this.jdField_a_of_type_ComTencentTtpicFacedetectFaceDetector != null) {
      i = this.jdField_a_of_type_ComTencentTtpicFacedetectFaceDetector.getDataType().value;
    }
    byte[] arrayOfByte = RetrieveDataManager.getInstance().retrieveData(i, paramInt1, paramInt2, paramInt3);
    this.jdField_b_of_type_Long = SystemClock.elapsedRealtimeNanos();
    if (SLog.a()) {
      SLog.d("QQFilterRenderManager", "FilterProcessRender_showPreview[doFaceDetectInitAndFlip " + (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long) / 1000L + "us]");
    }
    return arrayOfByte;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public long b()
  {
    return this.jdField_d_of_type_Long;
  }
  
  public List b(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      QQBaseFilter localQQBaseFilter = (QQBaseFilter)localIterator.next();
      if (localQQBaseFilter.d() == paramInt) {
        localArrayList.add(localQQBaseFilter);
      }
    }
    return localArrayList;
  }
  
  public void b()
  {
    Iterator localIterator;
    if (QmcfManager.a().a() == 2)
    {
      localIterator = a(130).iterator();
      while (localIterator.hasNext()) {
        ((QQDanceGameFilter)localIterator.next()).b();
      }
    }
    if (QQFaceDanceMechineFilter.jdField_a_of_type_Boolean)
    {
      localIterator = a(140).iterator();
      while (localIterator.hasNext()) {
        ((QQFaceDanceMechineFilter)localIterator.next()).b();
      }
    }
  }
  
  public void b(int paramInt)
  {
    Object localObject = a(25);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((QQPtBeautyFilter)((Iterator)localObject).next()).a(paramInt);
      }
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    a(new QQGaussianBlurFilter(145, this, paramInt1, paramInt2));
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    QQFilterLogManager.b("surfaceCreate");
    t();
    a(paramInt1, paramInt2, paramInt3, paramInt4);
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((QQBaseFilter)localIterator.next()).d();
    }
    QQFilterLogManager.c("surfaceCreate");
  }
  
  public void b(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilMap.put(paramString1, paramString2);
  }
  
  public void b(List paramList)
  {
    List localList = a(120);
    if ((localList != null) && (localList.size() > 0)) {
      ((QQDynamicStickersFilter)localList.get(0)).a(paramList);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    if (this.jdField_c_of_type_Boolean)
    {
      GestureMgrRecognize.a().a();
      return;
    }
    GestureMgrRecognize.a().b();
  }
  
  public boolean b()
  {
    boolean bool2 = false;
    List localList = a(100);
    boolean bool1 = bool2;
    if (localList != null)
    {
      bool1 = bool2;
      if (localList.size() > 0) {
        bool1 = ((QQMovieFilter)localList.get(0)).i_();
      }
    }
    return bool1;
  }
  
  public int c()
  {
    int k = 0;
    int j = 0;
    Object localObject = a(25);
    int i = k;
    if (localObject != null)
    {
      i = k;
      if (((List)localObject).size() > 0)
      {
        localObject = ((List)localObject).iterator();
        for (i = j; ((Iterator)localObject).hasNext(); i = ((QQPtBeautyFilter)((Iterator)localObject).next()).a()) {}
      }
    }
    return i;
  }
  
  public long c()
  {
    return this.jdField_c_of_type_Long;
  }
  
  public void c()
  {
    Iterator localIterator;
    if (QmcfManager.a().a() == 2)
    {
      localIterator = a(130).iterator();
      while (localIterator.hasNext()) {
        ((QQBaseFilter)localIterator.next()).g();
      }
    }
    if (QQFaceDanceMechineFilter.jdField_a_of_type_Boolean)
    {
      localIterator = a(140).iterator();
      while (localIterator.hasNext()) {
        ((QQBaseFilter)localIterator.next()).g();
      }
    }
  }
  
  public void c(int paramInt)
  {
    List localList = a(40);
    if ((localList != null) && (localList.size() > 0)) {
      ((QQPtvVideoFilter)localList.get(0)).a(paramInt);
    }
  }
  
  public void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    QQFilterLogManager.b("surfaceChange");
    a(paramInt1, paramInt2, paramInt3, paramInt4);
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((QQBaseFilter)localIterator.next()).b(paramInt1, paramInt2);
    }
    QQFilterLogManager.c("surfaceChange");
  }
  
  public void c(List paramList)
  {
    List localList = a(150);
    if ((localList != null) && (localList.size() > 0)) {
      ((QQScaleFilter)localList.get(0)).a(paramList);
    }
    localList = a(145);
    if ((localList != null) && (localList.size() > 0)) {
      ((QQGaussianBlurFilter)localList.get(0)).a(paramList);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    VideoPrefsUtil.setMaterialMute(paramBoolean);
    Object localObject = a(100);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        QQMovieFilter localQQMovieFilter = (QQMovieFilter)((Iterator)localObject).next();
        if (!paramBoolean) {}
        for (boolean bool = true;; bool = false)
        {
          localQQMovieFilter.a(bool);
          break;
        }
      }
    }
  }
  
  public boolean c()
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (((QQBaseFilter)localIterator.next()).i_()) {
        return true;
      }
    }
    return false;
  }
  
  public int d()
  {
    Object localObject = a(40);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      if (((Iterator)localObject).hasNext()) {
        return ((QQPtvVideoFilter)((Iterator)localObject).next()).a();
      }
    }
    return 0;
  }
  
  public void d()
  {
    Iterator localIterator;
    if (QmcfManager.a().a() == 2)
    {
      localIterator = a(130).iterator();
      while (localIterator.hasNext()) {
        ((QQBaseFilter)localIterator.next()).f();
      }
    }
    if (QQFaceDanceMechineFilter.jdField_a_of_type_Boolean)
    {
      localIterator = a(140).iterator();
      while (localIterator.hasNext()) {
        ((QQBaseFilter)localIterator.next()).f();
      }
    }
  }
  
  public void d(int paramInt)
  {
    List localList = a(150);
    if ((localList != null) && (localList.size() > 0)) {
      ((QQScaleFilter)localList.get(0)).a(paramInt);
    }
    localList = a(145);
    if ((localList != null) && (localList.size() > 0)) {
      ((QQGaussianBlurFilter)localList.get(0)).a(paramInt);
    }
  }
  
  public boolean d()
  {
    return SoLoader.a(SdkContext.a().a(), false);
  }
  
  public int e()
  {
    Object localObject = a(70);
    if ((localObject != null) && (((List)localObject).size() >= 1))
    {
      localObject = (QQAVFilter)((List)localObject).get(0);
      if (localObject != null) {
        return ((QQAVFilter)localObject).a();
      }
    }
    return 0;
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentTtpicFacedetectFaceDetector = FaceDetectorManager.getInstance().getCurrentFaceDetector();
    String str;
    if (!this.jdField_f_of_type_Boolean)
    {
      str = SdkContext.a().a().a().a();
      boolean bool = TextUtils.isEmpty(str);
      if (SoLoader.a(SdkContext.a().a(), bool))
      {
        YTCommonInterface.initAuth(SdkContext.a().a(), "youtusdk_mqq.licence", 0, true);
        if ((!bool) && (this.jdField_a_of_type_ComTencentTtpicFacedetectFaceDetector != null)) {
          this.jdField_a_of_type_ComTencentTtpicFacedetectFaceDetector.setModelPath(str);
        }
      }
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentTtpicFacedetectFaceDetector != null)
      {
        this.jdField_a_of_type_ComTencentTtpicFacedetectFaceDetector.init();
        this.jdField_f_of_type_Boolean = true;
      }
      if (SLog.a()) {
        SLog.d("QQFilterRenderManager", "mFaceDetector path:" + str);
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        SLog.a("QQFilterRenderManager", "QQFilterRenderManager OutOfMemoryError:", localOutOfMemoryError);
        this.jdField_f_of_type_Boolean = false;
      }
    }
    catch (Error localError)
    {
      for (;;)
      {
        SLog.a("QQFilterRenderManager", "QQFilterRenderManager Exception:", localError);
        this.jdField_f_of_type_Boolean = false;
      }
    }
  }
  
  public void e(int paramInt)
  {
    List localList = a(150);
    if ((localList != null) && (localList.size() > 0)) {
      ((QQScaleFilter)localList.get(0)).c(paramInt);
    }
    localList = a(145);
    if ((localList != null) && (localList.size() > 0)) {
      ((QQGaussianBlurFilter)localList.get(0)).c(paramInt);
    }
  }
  
  public int f()
  {
    return this.jdField_f_of_type_Int;
  }
  
  public void f()
  {
    boolean bool = TextUtils.isEmpty(SdkContext.a().a().a().a());
    if (SoLoader.a(SdkContext.a().a(), bool)) {
      FaceDetectorManager.getInstance().destroy();
    }
    this.jdField_a_of_type_ComTencentTtpicFacedetectFaceDetector = null;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public int g()
  {
    return this.jdField_g_of_type_Int;
  }
  
  public void g()
  {
    if (this.jdField_g_of_type_Boolean) {
      return;
    }
    this.jdField_g_of_type_Boolean = true;
    i = 200;
    m = 5;
    String str1 = SdkContext.a().a().a().b();
    String str2 = SdkContext.a().a().a().a();
    try
    {
      j = Integer.parseInt(str1);
      i = j;
      k = Integer.parseInt(str2);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        int k = m;
        int j = i;
        if (SLog.a())
        {
          SLog.d("GestureTestUse", "GestureMgr.getInstance().setRecognizeMillis number exception" + i);
          k = m;
          j = i;
        }
      }
    }
    if (SLog.a()) {
      SLog.d("GestureTestUse", "PtvTemplateManager.mGestureGapTime raw value " + str1 + ":GestureMgr.getInstance().setRecognizeMillis normal result" + j + ",frameRate is:" + k);
    }
    GestureMgrRecognize.a().a(j);
    GestureMgrRecognize.a().b(k);
  }
  
  public int h()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public void h()
  {
    a(new QQLowLightFilter(this));
  }
  
  public int i()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public void i()
  {
    a(new QQBeautyFilter(20, this));
  }
  
  public void j()
  {
    a(new QQPtBeautyFilter(25, this));
  }
  
  public void k()
  {
    Object localObject = a(40);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((QQPtvVideoFilter)((Iterator)localObject).next()).b();
      }
    }
  }
  
  public void l()
  {
    Object localObject = a(40);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((QQPtvVideoFilter)((Iterator)localObject).next()).c();
      }
    }
  }
  
  public void m()
  {
    a(new QQDynamicStickersFilter(120, this));
  }
  
  public void n()
  {
    a(new QQTrackerStickersFilter(110, this));
  }
  
  public void o()
  {
    QQFilterLogManager.b("surfaceDestroyed");
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((QQBaseFilter)localIterator.next()).e();
    }
    u();
    QQFilterLogManager.c("surfaceDestroyed");
  }
  
  public void p()
  {
    Object localObject = a(40);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((QQPtvVideoFilter)((Iterator)localObject).next()).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager
 * JD-Core Version:    0.7.0.1
 */