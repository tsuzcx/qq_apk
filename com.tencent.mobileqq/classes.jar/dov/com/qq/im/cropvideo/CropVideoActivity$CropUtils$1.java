package dov.com.qq.im.cropvideo;

import bpxl;
import wmr;
import yuk;

public final class CropVideoActivity$CropUtils$1
  implements Runnable
{
  public CropVideoActivity$CropUtils$1(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong1, long paramLong2, wmr paramwmr) {}
  
  public void run()
  {
    try
    {
      try
      {
        int i = bpxl.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.c, this.d, this.e, this.f, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long);
        if (this.jdField_a_of_type_Wmr != null) {
          this.jdField_a_of_type_Wmr.a(i, "", this.jdField_b_of_type_JavaLangString);
        }
        return;
      }
      finally {}
      return;
    }
    catch (Exception localException)
    {
      yuk.c("CropVideoActivity", "do composite exception", localException);
      if (this.jdField_a_of_type_Wmr != null) {
        this.jdField_a_of_type_Wmr.a(940001, localException.getMessage(), "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.cropvideo.CropVideoActivity.CropUtils.1
 * JD-Core Version:    0.7.0.1
 */