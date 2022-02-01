package dov.com.tencent.mobileqq.shortvideo.util;

import java.util.concurrent.atomic.AtomicInteger;

public class TextureDataPipe
{
  private static float[] jdField_a_of_type_ArrayOfFloat = { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
  public int a;
  public TextureDataPipe.FrameMetaData a;
  private TextureDataPipe.OnFrameAvailableListener jdField_a_of_type_DovComTencentMobileqqShortvideoUtilTextureDataPipe$OnFrameAvailableListener;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private AtomicInteger b;
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndAdd(0);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilTextureDataPipe$OnFrameAvailableListener != null)
    {
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilTextureDataPipe$OnFrameAvailableListener.a();
      return;
    }
    b();
  }
  
  public void a(int paramInt, Object paramObject, boolean paramBoolean)
  {
    boolean bool = true;
    TextureDataPipe.FrameMetaData localFrameMetaData = this.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilTextureDataPipe$FrameMetaData;
    if (paramInt == 1) {}
    for (;;)
    {
      localFrameMetaData.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilTextureDataPipe$FrameMetaData.jdField_a_of_type_JavaLangObject = paramObject;
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilTextureDataPipe$FrameMetaData.b = paramBoolean;
      return;
      bool = false;
    }
  }
  
  public int b()
  {
    return this.b.getAndSet(1);
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndSet(0);
  }
  
  public int c()
  {
    return this.b.getAndAdd(0);
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndSet(1);
  }
  
  public void d()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndSet(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.util.TextureDataPipe
 * JD-Core Version:    0.7.0.1
 */