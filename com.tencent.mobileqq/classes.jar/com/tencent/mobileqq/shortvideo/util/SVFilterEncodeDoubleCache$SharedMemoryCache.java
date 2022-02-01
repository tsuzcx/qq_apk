package com.tencent.mobileqq.shortvideo.util;

import com.tencent.mobileqq.activity.richmedia.view.CameraFilterGLView.SharedMemWriteFile;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

public class SVFilterEncodeDoubleCache$SharedMemoryCache
{
  public int a;
  private long jdField_a_of_type_Long = 0L;
  public CameraFilterGLView.SharedMemWriteFile a;
  public ByteBuffer a;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  public SVFilterEncodeDoubleCache$SharedMemoryCache(int paramInt)
  {
    this.jdField_a_of_type_JavaNioByteBuffer = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$SharedMemWriteFile = null;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = false;
    this.b = 0;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndSet(0);
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt1 * paramInt2 * paramInt3;
    if ((this.jdField_a_of_type_Boolean) && (this.b == i) && (this.jdField_a_of_type_JavaNioByteBuffer != null)) {
      return true;
    }
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaNioByteBuffer = null;
    try
    {
      this.jdField_a_of_type_Long = PtvFilterUtils.getNativePtrIndex(paramInt1, paramInt2, paramInt3, this.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_Long == 0L) {
        return false;
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
    {
      for (;;)
      {
        this.jdField_a_of_type_Long = 0L;
      }
      try
      {
        this.jdField_a_of_type_JavaNioByteBuffer = PtvFilterUtils.allocateSharedMem(this.jdField_a_of_type_Long);
        if (this.jdField_a_of_type_JavaNioByteBuffer == null) {
          return false;
        }
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
      {
        for (;;)
        {
          this.jdField_a_of_type_JavaNioByteBuffer = null;
        }
        this.jdField_a_of_type_Boolean = true;
        this.b = i;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.SVFilterEncodeDoubleCache.SharedMemoryCache
 * JD-Core Version:    0.7.0.1
 */