package dov.com.tencent.mobileqq.shortvideo.util;

import java.util.concurrent.atomic.AtomicInteger;

public class TexturePileQueue
{
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private int[] jdField_a_of_type_ArrayOfInt = new int[3];
  private TextureDataPipe[] jdField_a_of_type_ArrayOfDovComTencentMobileqqShortvideoUtilTextureDataPipe = new TextureDataPipe[3];
  
  private boolean b()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1;
  }
  
  public TextureDataPipe a()
  {
    if (!b()) {
      return null;
    }
    int i = 0;
    TextureDataPipe localTextureDataPipe;
    if (i < this.jdField_a_of_type_ArrayOfDovComTencentMobileqqShortvideoUtilTextureDataPipe.length) {
      if (this.jdField_a_of_type_ArrayOfDovComTencentMobileqqShortvideoUtilTextureDataPipe[i].b() == 0)
      {
        localTextureDataPipe = this.jdField_a_of_type_ArrayOfDovComTencentMobileqqShortvideoUtilTextureDataPipe[i];
        localTextureDataPipe.c();
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
  
  public boolean a()
  {
    if (!b()) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfDovComTencentMobileqqShortvideoUtilTextureDataPipe.length)
      {
        if (this.jdField_a_of_type_ArrayOfDovComTencentMobileqqShortvideoUtilTextureDataPipe[i].a() == 3) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public TextureDataPipe b()
  {
    if (!b()) {
      return null;
    }
    int i = 0;
    TextureDataPipe localTextureDataPipe;
    if (i < this.jdField_a_of_type_ArrayOfDovComTencentMobileqqShortvideoUtilTextureDataPipe.length)
    {
      if (this.jdField_a_of_type_ArrayOfDovComTencentMobileqqShortvideoUtilTextureDataPipe[i].c() == 0) {}
      while (this.jdField_a_of_type_ArrayOfDovComTencentMobileqqShortvideoUtilTextureDataPipe[i].a() != 0)
      {
        i += 1;
        break;
      }
      localTextureDataPipe = this.jdField_a_of_type_ArrayOfDovComTencentMobileqqShortvideoUtilTextureDataPipe[i];
      localTextureDataPipe.c();
    }
    for (;;)
    {
      return localTextureDataPipe;
      localTextureDataPipe = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.util.TexturePileQueue
 * JD-Core Version:    0.7.0.1
 */