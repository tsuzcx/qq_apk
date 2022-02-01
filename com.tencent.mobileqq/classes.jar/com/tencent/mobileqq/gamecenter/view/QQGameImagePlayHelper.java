package com.tencent.mobileqq.gamecenter.view;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.widget.ImageSwitcher;
import com.tencent.TMG.utils.QLog;
import com.tencent.image.URLDrawable;
import java.lang.ref.WeakReference;
import java.util.List;

public class QQGameImagePlayHelper
  implements Handler.Callback
{
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private WeakReference<ImageSwitcher> jdField_a_of_type_JavaLangRefWeakReference;
  private List<String> jdField_a_of_type_JavaUtilList;
  private int jdField_b_of_type_Int;
  private WeakReference<ImageSwitcher> jdField_b_of_type_JavaLangRefWeakReference;
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return false;
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQGameImagePlayHelper", 0, "[handleMessage] set next image");
      }
      int i;
      if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
      {
        paramMessage = (ImageSwitcher)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        i = this.jdField_a_of_type_Int + 1;
        this.jdField_a_of_type_Int = i;
        if (i == this.jdField_a_of_type_JavaUtilList.size()) {
          this.jdField_a_of_type_Int = 0;
        }
        paramMessage.setImageDrawable(URLDrawable.getDrawable((String)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int)));
      }
      if ((this.jdField_b_of_type_JavaLangRefWeakReference != null) && (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null))
      {
        paramMessage = (ImageSwitcher)this.jdField_b_of_type_JavaLangRefWeakReference.get();
        i = this.jdField_b_of_type_Int + 1;
        this.jdField_b_of_type_Int = i;
        if (i == this.jdField_a_of_type_JavaUtilList.size()) {
          this.jdField_b_of_type_Int = 0;
        }
        paramMessage.setImageDrawable(URLDrawable.getDrawable((String)this.jdField_a_of_type_JavaUtilList.get(this.jdField_b_of_type_Int)));
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 5000L);
      return false;
    }
    catch (Exception paramMessage)
    {
      label208:
      break label208;
    }
    QLog.e("QQGameImagePlayHelper", 1, "[handleMessage] ");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.QQGameImagePlayHelper
 * JD-Core Version:    0.7.0.1
 */