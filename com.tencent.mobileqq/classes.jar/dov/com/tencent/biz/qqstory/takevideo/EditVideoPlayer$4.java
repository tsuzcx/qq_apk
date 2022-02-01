package dov.com.tencent.biz.qqstory.takevideo;

import boub;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import ykq;

public class EditVideoPlayer$4
  implements Runnable
{
  public EditVideoPlayer$4(boub paramboub, int paramInt, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    ykq.a("Q.qqstory.record.EditVideoPlayer", "setMosaic %d", Integer.valueOf(this.jdField_a_of_type_Int));
    VideoSourceHelper.nativeSetMosaic(this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoPlayer.4
 * JD-Core Version:    0.7.0.1
 */