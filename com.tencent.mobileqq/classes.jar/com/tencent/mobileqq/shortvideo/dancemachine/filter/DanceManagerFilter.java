package com.tencent.mobileqq.shortvideo.dancemachine.filter;

import android.graphics.Rect;
import android.opengl.GLES20;
import com.tencent.mobileqq.shortvideo.dancemachine.GLViewContext;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager;
import com.tencent.mobileqq.shortvideo.dancemachine.TrAsyncTextureLoad;
import com.tencent.mobileqq.shortvideo.dancemachine.utils.DanceLog;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class DanceManagerFilter
  extends DanceBaseFilter
{
  private GLViewContext jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLViewContext = new GLViewContext();
  public DanceManagerFilter.GamePlayOutData a;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList(3);
  private boolean jdField_a_of_type_Boolean;
  private int e = 0;
  private int f;
  private int g;
  
  public DanceManagerFilter(int paramInt, QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(paramInt, paramQQFilterRenderManager);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter$GamePlayOutData = new DanceManagerFilter.GamePlayOutData();
    a(paramInt, paramQQFilterRenderManager);
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void a(int paramInt, QQFilterRenderManager paramQQFilterRenderManager)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(new DanceReadyFilter(paramInt, paramQQFilterRenderManager));
    this.jdField_a_of_type_JavaUtilArrayList.add(new DancePlayFilter(paramInt, paramQQFilterRenderManager));
    this.jdField_a_of_type_JavaUtilArrayList.add(new DanceScoreFilter(paramInt, paramQQFilterRenderManager));
    this.jdField_a_of_type_JavaUtilArrayList.add(new DanceTestFilter(paramInt, paramQQFilterRenderManager));
    paramQQFilterRenderManager = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (paramQQFilterRenderManager.hasNext()) {
      ((DanceBaseFilter)paramQQFilterRenderManager.next()).a(this);
    }
  }
  
  private void i()
  {
    ((DanceBaseFilter)this.jdField_a_of_type_JavaUtilArrayList.get(this.e)).c();
  }
  
  public int a()
  {
    return this.e;
  }
  
  public GLViewContext a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLViewContext;
  }
  
  public TreeSet a()
  {
    return ((DanceBaseFilter)this.jdField_a_of_type_JavaUtilArrayList.get(this.e)).a();
  }
  
  public void a()
  {
    this.e += 1;
    if (this.e == this.jdField_a_of_type_JavaUtilArrayList.size() - 1) {
      throw new RuntimeException("Invalid index = " + this.e);
    }
    if (this.jdField_a_of_type_Boolean) {
      i();
    }
  }
  
  public void a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 2))
    {
      this.e = paramInt;
      if (this.jdField_a_of_type_Boolean) {
        i();
      }
      return;
    }
    throw new RuntimeException("Invalid index = " + this.e);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLViewContext.a(new Rect(0, 0, paramInt1, paramInt2));
  }
  
  public boolean a()
  {
    return ((DanceBaseFilter)this.jdField_a_of_type_JavaUtilArrayList.get(this.e)).a();
  }
  
  public void b()
  {
    ((DanceBaseFilter)this.jdField_a_of_type_JavaUtilArrayList.get(this.e)).b();
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLViewContext.b(new Rect(0, 0, paramInt1, paramInt2));
  }
  
  public void d() {}
  
  public void e()
  {
    DanceLog.b("GLFrameImage", "[DanceMgrFilter]onSurfaceDestroy mHasInitedResource=" + this.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_Boolean)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((DanceBaseFilter)localIterator.next()).e();
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLViewContext.a();
      TrAsyncTextureLoad.a().e();
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void f()
  {
    ((DanceBaseFilter)this.jdField_a_of_type_JavaUtilArrayList.get(this.e)).f();
  }
  
  public void g()
  {
    ((DanceBaseFilter)this.jdField_a_of_type_JavaUtilArrayList.get(this.e)).g();
  }
  
  public void h()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      TrAsyncTextureLoad.a().a();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLViewContext.a(ResourceManager.a().b());
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((DanceBaseFilter)localIterator.next()).d();
      }
      localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((DanceBaseFilter)localIterator.next()).b(this.f, this.g);
      }
      i();
      this.jdField_a_of_type_Boolean = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLViewContext.b();
    ((DanceBaseFilter)this.jdField_a_of_type_JavaUtilArrayList.get(this.e)).h();
    GLES20.glFinish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.filter.DanceManagerFilter
 * JD-Core Version:    0.7.0.1
 */