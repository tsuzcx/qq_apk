package com.tencent.mobileqq.flutter.qqface;

import android.graphics.Bitmap;
import aupb;
import aupf;
import aupj;
import java.util.Iterator;
import java.util.List;

public class QFlutterFaceLoader$3
  implements Runnable
{
  public QFlutterFaceLoader$3(aupf paramaupf, aupb paramaupb, Bitmap paramBitmap, String paramString) {}
  
  public void run()
  {
    Iterator localIterator = aupf.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((aupj)localIterator.next()).a(this.jdField_a_of_type_Aupb, this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.qqface.QFlutterFaceLoader.3
 * JD-Core Version:    0.7.0.1
 */