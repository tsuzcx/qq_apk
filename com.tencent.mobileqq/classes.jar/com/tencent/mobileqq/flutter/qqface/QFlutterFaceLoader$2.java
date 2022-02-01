package com.tencent.mobileqq.flutter.qqface;

import android.graphics.Bitmap;
import atkh;
import atkl;
import atko;
import java.util.Iterator;
import java.util.List;

public class QFlutterFaceLoader$2
  implements Runnable
{
  public QFlutterFaceLoader$2(atkl paramatkl, atkh paramatkh, Bitmap paramBitmap, String paramString) {}
  
  public void run()
  {
    Iterator localIterator = atkl.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((atko)localIterator.next()).a(this.jdField_a_of_type_Atkh, this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.qqface.QFlutterFaceLoader.2
 * JD-Core Version:    0.7.0.1
 */