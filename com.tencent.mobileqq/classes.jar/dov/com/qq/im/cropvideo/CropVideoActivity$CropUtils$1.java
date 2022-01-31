package dov.com.qq.im.cropvideo;

import blya;
import ulb;
import wsv;

public final class CropVideoActivity$CropUtils$1
  implements Runnable
{
  public CropVideoActivity$CropUtils$1(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong1, long paramLong2, ulb paramulb) {}
  
  public void run()
  {
    try
    {
      try
      {
        int i = blya.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.c, this.d, this.e, this.f, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long);
        if (this.jdField_a_of_type_Ulb != null) {
          this.jdField_a_of_type_Ulb.a(i, "", this.jdField_b_of_type_JavaLangString);
        }
        return;
      }
      finally {}
      return;
    }
    catch (Exception localException)
    {
      wsv.c("CropVideoActivity", "do composite exception", localException);
      if (this.jdField_a_of_type_Ulb != null) {
        this.jdField_a_of_type_Ulb.a(940001, localException.getMessage(), "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.cropvideo.CropVideoActivity.CropUtils.1
 * JD-Core Version:    0.7.0.1
 */