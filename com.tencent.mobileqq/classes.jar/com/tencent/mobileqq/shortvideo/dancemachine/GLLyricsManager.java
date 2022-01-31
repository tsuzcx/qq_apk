package com.tencent.mobileqq.shortvideo.dancemachine;

import android.graphics.Rect;
import android.graphics.RectF;
import android.os.SystemClock;
import java.util.Iterator;
import java.util.List;

public class GLLyricsManager
{
  private long jdField_a_of_type_Long;
  private GLLyricsView jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLLyricsView;
  private GLViewContext jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLViewContext;
  private String jdField_a_of_type_JavaLangString;
  
  public GLLyricsManager(GLViewContext paramGLViewContext, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLViewContext = paramGLViewContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLLyricsView = new GLLyricsView(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLViewContext, this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLLyricsView.a(DisplayUtils.a(56.0F));
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLLyricsView.b(DisplayUtils.a(20.0F));
  }
  
  private int a(ResourceManager.LyricItem paramLyricItem)
  {
    long l = SystemClock.uptimeMillis() - this.jdField_a_of_type_Long;
    if (paramLyricItem.b > l) {
      return 0;
    }
    if ((paramLyricItem.b <= l) && (paramLyricItem.c > l)) {
      return 1;
    }
    return 2;
  }
  
  private void a(String paramString)
  {
    if (paramString == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLLyricsView.f_(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLLyricsView.b();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLLyricsView.a(paramString, -1);
    paramString = this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLViewContext.b();
    int i = paramString.width();
    int j = paramString.height();
    paramString = new RectF(0.0F, 0.0F, i, j);
    float f1 = (i - this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLLyricsView.a() - this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLLyricsView.a()) / 2.0F;
    float f2 = j - DisplayUtils.a(100.0F) - this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLLyricsView.b() - this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLLyricsView.a();
    paramString.set(f1, f2, i - f1, this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLLyricsView.b() + f2 + this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLLyricsView.a());
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLLyricsView.b(paramString);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLLyricsView.d(paramString);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLLyricsView.f_(true);
  }
  
  public void a()
  {
    Object localObject = ResourceManager.a().c();
    if ((localObject != null) && (((List)localObject).size() > 0) && (this.jdField_a_of_type_Long > 0L)) {
      localObject = ((List)localObject).iterator();
    }
    for (;;)
    {
      ResourceManager.LyricItem localLyricItem;
      int i;
      if (((Iterator)localObject).hasNext())
      {
        localLyricItem = (ResourceManager.LyricItem)((Iterator)localObject).next();
        if (localLyricItem.jdField_a_of_type_Int == 2) {
          continue;
        }
        if (localLyricItem.jdField_a_of_type_Int != 1) {
          break label108;
        }
        i = a(localLyricItem);
        if (i == 2)
        {
          a(null);
          localLyricItem.jdField_a_of_type_Int = i;
          continue;
        }
        if (i != 1) {
          continue;
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLLyricsView.a();
        return;
        label108:
        i = a(localLyricItem);
        if (i != 1) {
          break;
        }
        a(localLyricItem.jdField_a_of_type_JavaLangString);
        localLyricItem.jdField_a_of_type_Int = i;
      }
      if (i == 2)
      {
        a(null);
        localLyricItem.jdField_a_of_type_Int = i;
      }
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLLyricsView.f_(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.GLLyricsManager
 * JD-Core Version:    0.7.0.1
 */