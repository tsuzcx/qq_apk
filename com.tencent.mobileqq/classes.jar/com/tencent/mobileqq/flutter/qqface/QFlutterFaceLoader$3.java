package com.tencent.mobileqq.flutter.qqface;

import android.graphics.Bitmap;
import java.util.Iterator;
import java.util.List;

class QFlutterFaceLoader$3
  implements Runnable
{
  QFlutterFaceLoader$3(QFlutterFaceLoader paramQFlutterFaceLoader, DecodeRequest paramDecodeRequest, Bitmap paramBitmap, String paramString) {}
  
  public void run()
  {
    Iterator localIterator = QFlutterFaceLoader.d(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((QFlutterFaceLoader.FaceObserver)localIterator.next()).onFaceUpdate(this.a, this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.qqface.QFlutterFaceLoader.3
 * JD-Core Version:    0.7.0.1
 */