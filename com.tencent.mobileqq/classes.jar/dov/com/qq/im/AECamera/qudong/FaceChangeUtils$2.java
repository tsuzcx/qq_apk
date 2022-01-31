package dov.com.qq.im.AECamera.qudong;

import android.graphics.Bitmap;
import bhbv;
import bhbw;
import java.util.ArrayList;
import java.util.List;

public final class FaceChangeUtils$2
  implements Runnable
{
  public FaceChangeUtils$2(List paramList, Bitmap paramBitmap, bhbw parambhbw) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localArrayList.add(bhbv.a(this.jdField_a_of_type_AndroidGraphicsBitmap, (String)this.jdField_a_of_type_JavaUtilList.get(i)));
      i += 1;
    }
    this.jdField_a_of_type_Bhbw.a(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.AECamera.qudong.FaceChangeUtils.2
 * JD-Core Version:    0.7.0.1
 */