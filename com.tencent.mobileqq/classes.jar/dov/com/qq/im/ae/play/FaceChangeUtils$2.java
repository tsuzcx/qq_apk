package dov.com.qq.im.ae.play;

import android.graphics.Bitmap;
import blhy;
import blhz;
import java.util.ArrayList;
import java.util.List;

public final class FaceChangeUtils$2
  implements Runnable
{
  public FaceChangeUtils$2(List paramList, Bitmap paramBitmap, blhz paramblhz) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localArrayList.add(blhy.a(this.jdField_a_of_type_AndroidGraphicsBitmap, (String)this.jdField_a_of_type_JavaUtilList.get(i)));
      i += 1;
    }
    this.jdField_a_of_type_Blhz.a(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.play.FaceChangeUtils.2
 * JD-Core Version:    0.7.0.1
 */