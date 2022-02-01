package com.tencent.mobileqq.filemanageraux.fileviewer.FileView;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class LocalTdsViewManager$OpenCallbackImpl$1
  implements Runnable
{
  LocalTdsViewManager$OpenCallbackImpl$1(LocalTdsViewManager.OpenCallbackImpl paramOpenCallbackImpl, Integer paramInteger, Object paramObject, Bundle paramBundle) {}
  
  public void run()
  {
    boolean bool2 = true;
    switch (this.jdField_a_of_type_JavaLangInteger.intValue())
    {
    default: 
    case 2001: 
      do
      {
        return;
        QLog.w("TdsReaderView_LocalTdsViewManager", 1, "showErrorCode:" + this.jdField_a_of_type_JavaLangObject);
      } while (LocalTdsViewManager.OpenCallbackImpl.a(this.this$0) == null);
      LocalTdsViewManager.OpenCallbackImpl.a(this.this$0).a(false);
      return;
    }
    boolean bool1;
    if (!((Boolean)this.jdField_a_of_type_JavaLangObject).booleanValue())
    {
      bool1 = true;
      if ((this.jdField_a_of_type_AndroidOsBundle == null) || (this.jdField_a_of_type_AndroidOsBundle.getInt("result_", -1) != 0)) {
        break label144;
      }
    }
    for (;;)
    {
      LocalTdsViewManager.OpenCallbackImpl.a(this.this$0).a(bool1, bool2);
      return;
      bool1 = false;
      break;
      label144:
      bool2 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.fileviewer.FileView.LocalTdsViewManager.OpenCallbackImpl.1
 * JD-Core Version:    0.7.0.1
 */