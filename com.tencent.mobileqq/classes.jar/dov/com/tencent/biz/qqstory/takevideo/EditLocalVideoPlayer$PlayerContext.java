package dov.com.tencent.biz.qqstory.takevideo;

import android.graphics.Bitmap;

public class EditLocalVideoPlayer$PlayerContext
  extends VideoFragmentInfo
{
  int jdField_a_of_type_Int;
  public String a;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  boolean jdField_b_of_type_Boolean = false;
  
  public EditLocalVideoPlayer$PlayerContext(int paramInt, Bitmap paramBitmap)
  {
    super(paramInt, paramBitmap);
  }
  
  public static PlayerContext a(PlayerContext paramPlayerContext, Bitmap paramBitmap)
  {
    paramBitmap = new PlayerContext(paramPlayerContext.c, paramBitmap);
    paramBitmap.jdField_a_of_type_Int = paramPlayerContext.jdField_a_of_type_Int;
    paramBitmap.jdField_b_of_type_Int = paramPlayerContext.jdField_b_of_type_Int;
    paramBitmap.jdField_a_of_type_JavaLangString = paramPlayerContext.jdField_a_of_type_JavaLangString;
    paramBitmap.jdField_a_of_type_Boolean = paramPlayerContext.jdField_a_of_type_Boolean;
    paramBitmap.jdField_b_of_type_Boolean = paramPlayerContext.jdField_b_of_type_Boolean;
    return paramBitmap;
  }
  
  public String toString()
  {
    return "PlayerContext{startTime=" + this.jdField_a_of_type_Int + ", endTime=" + this.jdField_b_of_type_Int + ", isMute=" + this.jdField_a_of_type_Boolean + ", isDeleted=" + this.jdField_b_of_type_Boolean + "} " + super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoPlayer.PlayerContext
 * JD-Core Version:    0.7.0.1
 */