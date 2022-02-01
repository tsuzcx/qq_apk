package dov.com.tencent.biz.qqstory.takevideo;

import android.graphics.Bitmap;

public class HWEditImportVideoPlayer$Mp4VideoFragmentInfo
  extends VideoFragmentInfo
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  public String a;
  private boolean jdField_a_of_type_Boolean = false;
  private long jdField_b_of_type_Long = 0L;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap = null;
  public String b;
  private boolean jdField_b_of_type_Boolean = false;
  private Bitmap jdField_c_of_type_AndroidGraphicsBitmap;
  private boolean jdField_c_of_type_Boolean = false;
  
  public HWEditImportVideoPlayer$Mp4VideoFragmentInfo(int paramInt, Bitmap paramBitmap)
  {
    super(paramInt, paramBitmap);
    this.jdField_c_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public Mp4VideoFragmentInfo a(Bitmap paramBitmap)
  {
    paramBitmap = new Mp4VideoFragmentInfo(this.jdField_c_of_type_Int, paramBitmap);
    paramBitmap.jdField_c_of_type_AndroidGraphicsBitmap = this.jdField_c_of_type_AndroidGraphicsBitmap;
    paramBitmap.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    paramBitmap.jdField_b_of_type_Long = this.jdField_b_of_type_Long;
    paramBitmap.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    paramBitmap.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    paramBitmap.jdField_b_of_type_AndroidGraphicsBitmap = this.jdField_b_of_type_AndroidGraphicsBitmap;
    paramBitmap.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramBitmap.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    return paramBitmap;
  }
  
  public String toString()
  {
    return "Mp4VideoFragmentInfo{index=" + this.jdField_c_of_type_Int + ", bitmap=" + this.jdField_a_of_type_AndroidGraphicsBitmap + ", startTime=" + this.jdField_a_of_type_Long + ", endTime=" + this.jdField_b_of_type_Long + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.HWEditImportVideoPlayer.Mp4VideoFragmentInfo
 * JD-Core Version:    0.7.0.1
 */