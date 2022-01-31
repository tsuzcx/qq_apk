package com.tencent.mobileqq.shortvideo.filter;

import ahnj;
import ahnk;
import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.Frame;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.shortvideo.gesture.GestureKeyInfo;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgrRecognize;
import com.tencent.mobileqq.shortvideo.ptvfilter.GroupVideoFilterList;
import com.tencent.mobileqq.shortvideo.ptvfilter.QQSharpFaceFilter;
import com.tencent.mobileqq.shortvideo.ptvfilter.VideoFilterList;
import com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureFilterManager;
import com.tencent.mobileqq.shortvideo.resource.PtuFilterResource;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.mobileqq.shortvideo.util.SoLoader;
import com.tencent.sveffects.DpcSwitcher;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import com.tencent.ttpic.filter.VideoFlipFilter;
import com.tencent.ttpic.gles.SegmentDataPipe;
import com.tencent.ttpic.thread.SegmentGLThread;
import com.tencent.ttpic.util.FabbyManager;
import com.tencent.ttpic.util.OnSegmentReadyListener;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoUtil;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;
import com.tencent.util.PhoneProperty;
import com.tencent.youtu.android.segmenter.SegmenterLib;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

@TargetApi(17)
public class QQPtvVideoFilter
  extends QQBaseFilter
{
  BaseFilter jdField_a_of_type_ComTencentFilterBaseFilter = new BaseFilter(GLSLRender.FILTER_SHADER_NONE);
  public Frame a;
  volatile GroupVideoFilterList jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGroupVideoFilterList;
  private QQSharpFaceFilter jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterQQSharpFaceFilter = new QQSharpFaceFilter();
  volatile VideoFilterList jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList;
  VideoFlipFilter jdField_a_of_type_ComTencentTtpicFilterVideoFlipFilter = VideoFlipFilter.createVideoFlipFilter();
  private volatile SegmentDataPipe jdField_a_of_type_ComTencentTtpicGlesSegmentDataPipe;
  private SegmentGLThread jdField_a_of_type_ComTencentTtpicThreadSegmentGLThread;
  private OnSegmentReadyListener jdField_a_of_type_ComTencentTtpicUtilOnSegmentReadyListener;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  volatile List jdField_a_of_type_JavaUtilList = new Vector();
  boolean jdField_a_of_type_Boolean = false;
  private int[] jdField_a_of_type_ArrayOfInt = new int[2];
  public Frame b;
  boolean b;
  Frame jdField_c_of_type_ComTencentFilterFrame = new Frame();
  boolean jdField_c_of_type_Boolean = false;
  private boolean d = false;
  private boolean e;
  private boolean f = false;
  
  public QQPtvVideoFilter(int paramInt, QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(paramInt, paramQQFilterRenderManager);
    this.jdField_a_of_type_ComTencentFilterFrame = new Frame();
    this.jdField_b_of_type_ComTencentFilterFrame = new Frame();
    this.jdField_b_of_type_Boolean = false;
  }
  
  private VideoFilterList a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      return (VideoFilterList)this.jdField_a_of_type_JavaUtilList.get(0);
    }
    return null;
  }
  
  private void a(SegmentDataPipe paramSegmentDataPipe)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ComTencentTtpicGlesSegmentDataPipe = paramSegmentDataPipe;
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      return;
    }
  }
  
  private void a(OnSegmentReadyListener paramOnSegmentReadyListener)
  {
    if (paramOnSegmentReadyListener != null) {
      this.jdField_a_of_type_ComTencentTtpicUtilOnSegmentReadyListener = paramOnSegmentReadyListener;
    }
    if (SLog.a()) {
      SLog.d("QQPtvVideoFilter", "setOnSegmentReadyListener listener:" + paramOnSegmentReadyListener);
    }
  }
  
  private void a(List paramList, int paramInt1, int paramInt2, double paramDouble)
  {
    if (SLog.a()) {
      SLog.b("QQPtvVideoFilter", "changeFilter videoFilters=" + paramList);
    }
    this.jdField_b_of_type_ComTencentFilterFrame.clear();
    this.jdField_a_of_type_ComTencentFilterFrame.clear();
    this.jdField_c_of_type_ComTencentFilterFrame.clear();
    Object localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      VideoFilterList localVideoFilterList = (VideoFilterList)((Iterator)localObject1).next();
      if ((localVideoFilterList != null) && (localVideoFilterList.a())) {
        try
        {
          localVideoFilterList.b();
        }
        catch (Error localError2) {}
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.e = true;
    if (this.jdField_a_of_type_ComTencentTtpicUtilOnSegmentReadyListener != null) {
      this.jdField_a_of_type_ComTencentTtpicUtilOnSegmentReadyListener.reset();
    }
    boolean bool2;
    if ((paramList == null) || (paramList.size() <= 1)) {
      if ((paramList != null) && (paramList.size() == 1))
      {
        localObject1 = (VideoFilterList)paramList.get(0);
        bool2 = a((VideoFilterList)localObject1, paramInt1, paramInt2, paramDouble);
        bool1 = bool2;
        if (bool2)
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList != null) {
            this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList);
          }
        }
      }
    }
    for (boolean bool1 = bool2;; bool1 = false)
    {
      if (!bool1)
      {
        if ((paramList != null) && (!paramList.isEmpty())) {
          this.jdField_a_of_type_JavaUtilList.addAll(paramList);
        }
        paramList = this.jdField_a_of_type_JavaUtilList.iterator();
        for (;;)
        {
          if (paramList.hasNext())
          {
            localObject1 = (VideoFilterList)paramList.next();
            if ((localObject1 != null) && (((VideoFilterList)localObject1).a()))
            {
              try
              {
                ((VideoFilterList)localObject1).d();
              }
              catch (Error localError1) {}
              continue;
              Object localObject2 = null;
              break;
            }
          }
        }
      }
      a(paramInt1, paramInt2, paramDouble);
      i();
      return;
    }
  }
  
  private boolean a(VideoFilterList paramVideoFilterList, int paramInt1, int paramInt2, double paramDouble)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramVideoFilterList == null) || (!paramVideoFilterList.b()))
    {
      paramInt1 = 1;
      if ((QQSharpFaceFilter.jdField_a_of_type_Int < 0) || (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterQQSharpFaceFilter == null) || (paramInt1 == 0)) {
        break label157;
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterQQSharpFaceFilter.a(paramVideoFilterList);
      if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList == null) || (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList.a() == null)) {
        break label149;
      }
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList.a().size() == 1)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList.a().get(0) == this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterQQSharpFaceFilter.a()) {
          bool1 = true;
        }
      }
    }
    label149:
    for (this.d = bool1;; this.d = false)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList != null) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList.a())) {}
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList.d();
        return true;
      }
      catch (Error paramVideoFilterList) {}
      paramInt1 = 0;
      break;
    }
    label157:
    this.d = false;
    return false;
    return true;
  }
  
  private int b(int paramInt)
  {
    return paramInt;
  }
  
  private static boolean b()
  {
    return (VideoUtil.hasJellyBeanMR1()) && (SdkContext.a().a().d());
  }
  
  private void i()
  {
    VideoPreviewFaceOutlineDetector.getInstance().clearActionCounter();
    Iterator localIterator;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    }
    for (;;)
    {
      if (localIterator.hasNext())
      {
        if (VideoMaterialUtil.isCosMaterial(((VideoFilterList)localIterator.next()).a())) {
          VideoPreviewFaceOutlineDetector.getInstance().setRefine(true);
        }
      }
      else {
        return;
      }
      VideoPreviewFaceOutlineDetector.getInstance().setRefine(false);
    }
  }
  
  private void j()
  {
    try
    {
      if ((b()) && (this.jdField_a_of_type_ComTencentTtpicThreadSegmentGLThread == null))
      {
        String str = SdkContext.a().a().a().b();
        if (!TextUtils.isEmpty(str))
        {
          SegmenterLib.setSegmentSoStatus(SoLoader.jdField_b_of_type_Boolean);
          FabbyManager.setModelPath(str);
          long l = System.currentTimeMillis();
          this.jdField_a_of_type_ComTencentTtpicThreadSegmentGLThread = new SegmentGLThread(EGL14.eglGetCurrentContext());
          this.jdField_a_of_type_ComTencentTtpicThreadSegmentGLThread.setOnDataReadyListener(new ahnj(this));
          a(new ahnk(this));
          if (SLog.a()) {
            SLog.d("QQPtvVideoFilter", "initSegmentGLThread create, cost:" + (float)(System.currentTimeMillis() - l) / 1000.0F);
          }
        }
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int a()
  {
    VideoFilterList localVideoFilterList = a();
    if (localVideoFilterList != null) {
      return localVideoFilterList.jdField_b_of_type_Int;
    }
    return 0;
  }
  
  public int a(int paramInt)
  {
    long l = System.currentTimeMillis();
    Object localObject4 = new ArrayList();
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGroupVideoFilterList != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGroupVideoFilterList.a(l);
      ((List)localObject4).addAll(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGroupVideoFilterList.b());
    }
    for (;;)
    {
      if ((localObject4 != null) && (!((List)localObject4).isEmpty()) && (!this.d))
      {
        this.jdField_c_of_type_Boolean = true;
        label70:
        if (!this.jdField_b_of_type_Boolean)
        {
          a().d();
          a(null, a().f(), a().g(), 1.0D);
          this.jdField_b_of_type_Boolean = true;
        }
        if ((localObject4 == null) || (((List)localObject4).isEmpty()) || ((this.d) && (!QQSharpFaceFilter.jdField_a_of_type_Boolean))) {
          break label1056;
        }
        if (this.jdField_a_of_type_Boolean) {
          break label218;
        }
        GLES20.glGenTextures(this.jdField_a_of_type_ArrayOfInt.length, this.jdField_a_of_type_ArrayOfInt, 0);
        a().d();
      }
      try
      {
        this.jdField_a_of_type_ComTencentTtpicFilterVideoFlipFilter.ClearGLSL();
        this.jdField_a_of_type_ComTencentTtpicFilterVideoFlipFilter.ApplyGLSLFilter();
        this.jdField_a_of_type_Boolean = true;
        label218:
        do
        {
          return paramInt;
          if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList == null) {
            break;
          }
          ((List)localObject4).add(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList);
          break;
          this.jdField_c_of_type_Boolean = false;
          break label70;
        } while (!this.jdField_a_of_type_Boolean);
        QQFilterLogManager.d();
        this.jdField_a_of_type_ComTencentTtpicFilterVideoFlipFilter.RenderProcess(paramInt, a().f(), a().g(), this.jdField_a_of_type_ArrayOfInt[0], 0.0D, this.jdField_a_of_type_ComTencentFilterFrame);
        QQFilterLogManager.d("第一次翻转texture耗时");
        Frame localFrame = this.jdField_a_of_type_ComTencentFilterFrame;
        int i = 0;
        Object localObject3 = null;
        localObject2 = localObject3;
        paramInt = i;
        if (localObject4 != null)
        {
          localObject2 = localObject3;
          paramInt = i;
          if (!((List)localObject4).isEmpty())
          {
            ??? = ((List)localObject4).iterator();
            do
            {
              localObject2 = localObject3;
              paramInt = i;
              if (!((Iterator)???).hasNext()) {
                break;
              }
              localObject2 = (VideoFilterList)((Iterator)???).next();
            } while (!((VideoFilterList)localObject2).b());
            paramInt = 1;
          }
        }
        if (paramInt != 0)
        {
          if (this.jdField_a_of_type_ComTencentTtpicThreadSegmentGLThread == null)
          {
            if (!SoLoader.e()) {
              break label1092;
            }
            j();
            paramInt = 0;
            localObject2 = localFrame;
            QQFilterLogManager.d();
            i = localFrame.getTextureId();
            if (this.d) {
              a().a(true);
            }
            a().a(i);
            QQFilterLogManager.d("人脸sdk耗时");
            a().g();
            if (a().jdField_c_of_type_Boolean)
            {
              localObject3 = a().a();
              GestureMgrRecognize.a().a(i, (byte[])localObject3, a().a(), a().b(), a().f(), a().g());
              localObject3 = GestureMgrRecognize.a().a();
              if ((localObject3 == null) || (!((GestureKeyInfo)localObject3).jdField_a_of_type_Boolean) || (!((GestureKeyInfo)localObject3).jdField_a_of_type_JavaLangString.equalsIgnoreCase(GestureFilterManager.jdField_a_of_type_JavaLangString))) {
                break label922;
              }
              i = 1;
              if (i != 0)
              {
                a().jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureKeyInfo = ((GestureKeyInfo)localObject3);
                a().jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureKeyInfo.jdField_a_of_type_Long = System.currentTimeMillis();
              }
              if (a().jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureKeyInfo != null) {
                break label927;
              }
              a().d = false;
            }
          }
          for (;;)
          {
            for (;;)
            {
              localObject3 = localFrame;
              if (localObject4 == null) {
                break;
              }
              localObject3 = localFrame;
              if (((List)localObject4).isEmpty()) {
                break;
              }
              localObject4 = ((List)localObject4).iterator();
              for (;;)
              {
                localObject3 = localFrame;
                if (!((Iterator)localObject4).hasNext()) {
                  break;
                }
                localObject3 = (VideoFilterList)((Iterator)localObject4).next();
                if (((VideoFilterList)localObject3).a())
                {
                  QQFilterLogManager.d();
                  localFrame = ((VideoFilterList)localObject3).a(localFrame.getFBO(), localFrame.getTextureId(), a().f(), a().g(), VideoMaterialUtil.SCALE_FACE_DETECT, a().jdField_a_of_type_ComTencentTtpicFacedetectFaceDetector, l);
                  QQFilterLogManager.d("挂件内部渲染耗时");
                  if (paramInt == 0) {
                    break label1069;
                  }
                  localFrame = ((VideoFilterList)localObject3).a((Frame)localObject2, localFrame, VideoPreviewFaceOutlineDetector.getInstance().getAllFaces(), VideoPreviewFaceOutlineDetector.getInstance().getAllFaceAngles(), VideoPreviewFaceOutlineDetector.getInstance().getFaceActionCounter(), VideoMaterialUtil.SCALE_FACE_DETECT);
                }
              }
              GLES20.glFinish();
              if (this.jdField_a_of_type_ComTencentTtpicUtilOnSegmentReadyListener == null) {
                break label1085;
              }
              if (SLog.a()) {
                SLog.d("QQPtvVideoFilter", "fabby wait start!");
              }
              if (this.e) {
                break label1079;
              }
              synchronized (this.jdField_a_of_type_JavaLangObject)
              {
                try
                {
                  while (this.jdField_a_of_type_ComTencentTtpicGlesSegmentDataPipe == null) {
                    this.jdField_a_of_type_JavaLangObject.wait();
                  }
                  this.jdField_a_of_type_ComTencentTtpicUtilOnSegmentReadyListener.onTextureReady(localFrame);
                }
                catch (InterruptedException localInterruptedException)
                {
                  localInterruptedException.printStackTrace();
                  localSegmentDataPipe = this.jdField_a_of_type_ComTencentTtpicGlesSegmentDataPipe;
                  this.jdField_a_of_type_ComTencentTtpicGlesSegmentDataPipe = null;
                }
                this.e = false;
                if ((localSegmentDataPipe == null) || (localSegmentDataPipe.mTexFrame.width != localFrame.width) || (localObject2 == null)) {
                  break label1072;
                }
                localFrame = ((VideoFilterList)localObject2).a(localSegmentDataPipe.mTexFrame, localSegmentDataPipe.mMaskFrame);
                this.jdField_a_of_type_ComTencentFilterBaseFilter.RenderProcess(localSegmentDataPipe.mTexFrame.getTextureId(), localSegmentDataPipe.mTexFrame.width, localSegmentDataPipe.mTexFrame.height, -1, 0.0D, this.jdField_c_of_type_ComTencentFilterFrame);
                localObject2 = this.jdField_c_of_type_ComTencentFilterFrame;
                if (SLog.a()) {
                  SLog.d("QQPtvVideoFilter", "fabby wait end!");
                }
              }
            }
            label922:
            i = 0;
            break;
            label927:
            if (a().jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureKeyInfo.jdField_a_of_type_Long + 2000L >= System.currentTimeMillis()) {
              a().d = true;
            } else {
              a().d = false;
            }
          }
          paramInt = localSegmentDataPipe.getTextureId();
          QQFilterLogManager.d();
          this.jdField_a_of_type_ComTencentTtpicFilterVideoFlipFilter.RenderProcess(paramInt, a().f(), a().g(), this.jdField_a_of_type_ArrayOfInt[1], 0.0D, this.jdField_b_of_type_ComTencentFilterFrame);
          paramInt = this.jdField_a_of_type_ArrayOfInt[1];
          if (PhoneProperty.instance().isCannotReuseFrameBuffer())
          {
            this.jdField_a_of_type_ComTencentFilterFrame.clear();
            this.jdField_b_of_type_ComTencentFilterFrame.clear();
          }
          QQFilterLogManager.d("第二次翻转texture耗时");
          QQFilterLogManager.a("QQPtvVideoFilter", true);
          return paramInt;
          label1056:
          QQFilterLogManager.a("QQPtvVideoFilter", false);
          return paramInt;
        }
      }
      catch (Error localError)
      {
        for (;;)
        {
          continue;
          label1069:
          continue;
          label1072:
          Object localObject2 = localError;
          continue;
          label1079:
          SegmentDataPipe localSegmentDataPipe = null;
          continue;
          label1085:
          localObject2 = localError;
          continue;
          label1092:
          paramInt = 0;
          localObject2 = localError;
        }
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGroupVideoFilterList != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGroupVideoFilterList.a(1);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterQQSharpFaceFilter != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterQQSharpFaceFilter.a(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2, double paramDouble)
  {
    this.jdField_b_of_type_ComTencentFilterFrame.clear();
    this.jdField_a_of_type_ComTencentFilterFrame.clear();
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        VideoFilterList localVideoFilterList = (VideoFilterList)localIterator.next();
        if (localVideoFilterList.a())
        {
          localVideoFilterList.a(paramInt1, paramInt2, paramDouble);
          localVideoFilterList.g();
        }
      }
    }
  }
  
  public void a(GroupVideoFilterList paramGroupVideoFilterList, int paramInt1, int paramInt2, double paramDouble)
  {
    if (paramGroupVideoFilterList != null) {}
    for (this.jdField_c_of_type_Boolean = true;; this.jdField_c_of_type_Boolean = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGroupVideoFilterList = paramGroupVideoFilterList;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList = null;
      if (paramGroupVideoFilterList == null) {
        break;
      }
      a(paramGroupVideoFilterList.a(), paramInt1, paramInt2, paramDouble);
      return;
    }
    a(null, paramInt1, paramInt2, paramDouble);
  }
  
  public void a(VideoFilterList paramVideoFilterList, int paramInt1, int paramInt2, double paramDouble)
  {
    if (paramVideoFilterList != null) {}
    for (this.jdField_c_of_type_Boolean = true;; this.jdField_c_of_type_Boolean = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGroupVideoFilterList = null;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList = paramVideoFilterList;
      ArrayList localArrayList = new ArrayList();
      if (paramVideoFilterList != null) {
        localArrayList.add(paramVideoFilterList);
      }
      a(localArrayList, paramInt1, paramInt2, paramDouble);
      return;
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        VideoFilterList localVideoFilterList = (VideoFilterList)localIterator.next();
        if ((localVideoFilterList != null) && (localVideoFilterList.a())) {
          try
          {
            localVideoFilterList.c();
          }
          catch (Error localError) {}
        }
      }
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    super.b(paramInt1, paramInt2);
    a(paramInt1, paramInt2, VideoMaterialUtil.SCALE_FACE_DETECT);
  }
  
  public void c()
  {
    VideoFilterList localVideoFilterList = a();
    if (localVideoFilterList != null) {
      localVideoFilterList.jdField_b_of_type_Int = 0;
    }
  }
  
  public void d()
  {
    if ((SoLoader.e()) && (a().d())) {
      j();
    }
  }
  
  public void e()
  {
    GLES20.glDeleteTextures(this.jdField_a_of_type_ArrayOfInt.length, this.jdField_a_of_type_ArrayOfInt, 0);
    if (this.jdField_a_of_type_ComTencentTtpicThreadSegmentGLThread != null)
    {
      this.jdField_a_of_type_ComTencentTtpicThreadSegmentGLThread.destroy();
      this.jdField_a_of_type_ComTencentTtpicThreadSegmentGLThread = null;
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      try
      {
        this.jdField_a_of_type_ComTencentTtpicFilterVideoFlipFilter.ClearGLSL();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext()) {
          ((VideoFilterList)localIterator.next()).b();
        }
        this.jdField_b_of_type_ComTencentFilterFrame.clear();
      }
      catch (Error localError) {}
    }
    this.jdField_a_of_type_ComTencentFilterFrame.clear();
    this.jdField_c_of_type_ComTencentFilterFrame.clear();
    this.jdField_a_of_type_Boolean = false;
    if (a() != null) {
      a().f();
    }
  }
  
  public void h()
  {
    this.jdField_b_of_type_Int = b(a(this.jdField_a_of_type_Int));
  }
  
  public boolean i_()
  {
    return this.jdField_c_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQPtvVideoFilter
 * JD-Core Version:    0.7.0.1
 */