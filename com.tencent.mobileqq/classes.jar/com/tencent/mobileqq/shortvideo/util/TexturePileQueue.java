package com.tencent.mobileqq.shortvideo.util;

import android.opengl.GLES20;
import com.tencent.maxvideo.common.AVIOStruct;
import java.util.concurrent.atomic.AtomicInteger;

public class TexturePileQueue
{
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private int[] jdField_a_of_type_ArrayOfInt = new int[3];
  private TextureDataPipe[] jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoUtilTextureDataPipe = new TextureDataPipe[3];
  
  private boolean c()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1;
  }
  
  public TextureDataPipe a()
  {
    if (!c()) {
      return null;
    }
    int i = 0;
    TextureDataPipe localTextureDataPipe;
    if (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoUtilTextureDataPipe.length) {
      if (this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoUtilTextureDataPipe[i].b() == 0)
      {
        localTextureDataPipe = this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoUtilTextureDataPipe[i];
        localTextureDataPipe.d();
      }
    }
    for (;;)
    {
      return localTextureDataPipe;
      i += 1;
      break;
      localTextureDataPipe = null;
    }
  }
  
  public void a()
  {
    int i = 0;
    GLES20.glGenTextures(this.jdField_a_of_type_ArrayOfInt.length, this.jdField_a_of_type_ArrayOfInt, 0);
    while (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoUtilTextureDataPipe.length)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoUtilTextureDataPipe[i] = new TextureDataPipe(this.jdField_a_of_type_ArrayOfInt[i]);
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndSet(1);
  }
  
  public void a(TextureDataPipe.OnFrameAvailableListener paramOnFrameAvailableListener)
  {
    if (c())
    {
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoUtilTextureDataPipe.length)
      {
        this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoUtilTextureDataPipe[i].a(paramOnFrameAvailableListener);
        i += 1;
      }
    }
  }
  
  public boolean a()
  {
    if (!c()) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoUtilTextureDataPipe.length)
      {
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoUtilTextureDataPipe[i].a() == 3) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public TextureDataPipe b()
  {
    if (!c()) {
      return null;
    }
    int i = 0;
    TextureDataPipe localTextureDataPipe;
    if (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoUtilTextureDataPipe.length)
    {
      if (this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoUtilTextureDataPipe[i].c() == 0) {}
      while (this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoUtilTextureDataPipe[i].a() != 0)
      {
        i += 1;
        break;
      }
      localTextureDataPipe = this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoUtilTextureDataPipe[i];
      localTextureDataPipe.d();
    }
    for (;;)
    {
      return localTextureDataPipe;
      localTextureDataPipe = null;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndSet(0) == 1)
    {
      GLES20.glDeleteTextures(this.jdField_a_of_type_ArrayOfInt.length, this.jdField_a_of_type_ArrayOfInt, 0);
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoUtilTextureDataPipe.length)
      {
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoUtilTextureDataPipe[i] != null)
        {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoUtilTextureDataPipe[i].b();
          this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoUtilTextureDataPipe[i] = null;
        }
        this.jdField_a_of_type_ArrayOfInt[i] = 0;
        i += 1;
      }
    }
  }
  
  public boolean b()
  {
    int i = 0;
    if (!c()) {
      return false;
    }
    while (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoUtilTextureDataPipe.length)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoUtilTextureDataPipe[i].c();
      i += 1;
    }
    return true;
  }
  
  public TextureDataPipe c()
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (!c()) {}
    int i;
    label18:
    do
    {
      return localObject2;
      i = 0;
      localObject2 = localObject1;
    } while (i >= this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoUtilTextureDataPipe.length);
    TextureDataPipe localTextureDataPipe;
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoUtilTextureDataPipe[i].a() == 2)
    {
      localTextureDataPipe = this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoUtilTextureDataPipe[i];
      if (localObject1 == null) {
        localObject1 = localTextureDataPipe;
      }
    }
    for (;;)
    {
      i += 1;
      break label18;
      AVIOStruct localAVIOStruct = (AVIOStruct)localObject1.a.a;
      localObject2 = (AVIOStruct)localTextureDataPipe.a.a;
      long l = localAVIOStruct.vFrameTime;
      if (((AVIOStruct)localObject2).vFrameTime > l)
      {
        localObject2 = localObject1;
        if (localAVIOStruct.pFrameIndex == 0) {
          break;
        }
        localObject1.c();
        localObject1 = localTextureDataPipe;
        continue;
      }
      localTextureDataPipe.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.TexturePileQueue
 * JD-Core Version:    0.7.0.1
 */