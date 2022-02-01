package com.tencent.mobileqq.qrscan.minicode;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.mobileqq.qrscan.AIRect;
import com.tencent.mobileqq.qrscan.OnMiniCodeDetectCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class MiniCodeController$3
  implements OnMiniCodeDetectCallback
{
  MiniCodeController$3(MiniCodeController paramMiniCodeController, long paramLong, ArrayList paramArrayList, Object paramObject, MiniCodeDetector paramMiniCodeDetector, boolean[] paramArrayOfBoolean, Bitmap paramBitmap) {}
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqQrscanMinicodeMiniCodeDetector != null) && (MiniCodeController.a(this.jdField_a_of_type_ComTencentMobileqqQrscanMinicodeMiniCodeController) != null)) {
      this.jdField_a_of_type_ArrayOfBoolean[0] = this.jdField_a_of_type_ComTencentMobileqqQrscanMinicodeMiniCodeDetector.a(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_Long);
    } else {
      this.jdField_a_of_type_ArrayOfBoolean[0] = false;
    }
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("detectSync onDetectReady exec=");
      ((StringBuilder)???).append(this.jdField_a_of_type_ArrayOfBoolean[0]);
      QLog.i("MiniRecog.MiniCodeController", 2, ((StringBuilder)???).toString());
    }
    if (this.jdField_a_of_type_ArrayOfBoolean[0] == 0) {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaLangObject.notifyAll();
        return;
      }
    }
  }
  
  public void a(long paramLong) {}
  
  public void a(List<AIRect> arg1, long paramLong)
  {
    if (paramLong == this.jdField_a_of_type_Long)
    {
      int i = 0;
      while (i < ???.size())
      {
        AIRect localAIRect = (AIRect)???.get(i);
        if ((localAIRect != null) && (!localAIRect.a.isEmpty())) {
          this.jdField_a_of_type_JavaUtilArrayList.add(localAIRect);
        }
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog.MiniCodeController", 2, String.format("detectSync onDetectResult=%s", new Object[] { this.jdField_a_of_type_JavaUtilArrayList }));
      }
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaLangObject.notifyAll();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.minicode.MiniCodeController.3
 * JD-Core Version:    0.7.0.1
 */