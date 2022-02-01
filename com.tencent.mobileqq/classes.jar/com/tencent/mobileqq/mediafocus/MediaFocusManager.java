package com.tencent.mobileqq.mediafocus;

import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class MediaFocusManager
  implements MediaFocusController.IMediaFocusStatusCallback
{
  private MediaFocusController jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController;
  private final MediaFocusManager.FocusEventHandlerDelegate jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusManager$FocusEventHandlerDelegate = new MediaFocusManager.FocusEventHandlerDelegate(this);
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private final HashMap<String, MediaFocusManager.OnMediaFocusChangeListener> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final HashMap<String, Integer> b = new HashMap();
  
  private MediaFocusManager.OnMediaFocusChangeListener a(String paramString)
  {
    return (MediaFocusManager.OnMediaFocusChangeListener)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public static final MediaFocusManager a()
  {
    return MediaFocusManager.MediaFocusMgrHolder.a();
  }
  
  private String a(MediaFocusManager.OnMediaFocusChangeListener paramOnMediaFocusChangeListener)
  {
    if (paramOnMediaFocusChangeListener == null) {
      return new String(toString());
    }
    return new String(toString() + paramOnMediaFocusChangeListener.toString());
  }
  
  private void a(MediaFocusManager.OnMediaFocusChangeListener paramOnMediaFocusChangeListener)
  {
    String str;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController == null) {
        this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController = new MediaFocusController(this);
      }
      str = a(paramOnMediaFocusChangeListener);
      if (this.b.containsKey(str))
      {
        int i = ((Integer)this.b.get(str)).intValue();
        this.b.put(str, Integer.valueOf(i + 1));
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(str)) {}
      }
      else
      {
        this.b.put(str, Integer.valueOf(1));
      }
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(str, paramOnMediaFocusChangeListener);
  }
  
  private boolean a(MediaFocusManager.OnMediaFocusChangeListener paramOnMediaFocusChangeListener, boolean paramBoolean)
  {
    boolean bool = true;
    label130:
    label145:
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        paramOnMediaFocusChangeListener = a(paramOnMediaFocusChangeListener);
        if (!paramBoolean)
        {
          this.b.remove(paramOnMediaFocusChangeListener);
          this.jdField_a_of_type_JavaUtilHashMap.remove(paramOnMediaFocusChangeListener);
          return true;
        }
        if (!this.b.containsKey(paramOnMediaFocusChangeListener)) {
          break label130;
        }
        int i = ((Integer)this.b.get(paramOnMediaFocusChangeListener)).intValue();
        if (i > 1)
        {
          this.b.put(paramOnMediaFocusChangeListener, Integer.valueOf(i - 1));
          paramBoolean = false;
          break label145;
          return paramBoolean;
        }
      }
      this.b.remove(paramOnMediaFocusChangeListener);
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramOnMediaFocusChangeListener);
      paramBoolean = true;
      break label145;
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramOnMediaFocusChangeListener);
      paramBoolean = bool;
    }
  }
  
  public int a(int paramInt, MediaFocusManager.OnMediaFocusChangeListener paramOnMediaFocusChangeListener)
  {
    if ((paramInt < 1) || (paramInt > 3))
    {
      QLog.e("MediaFocusManager", 1, new Object[] { "requestMediaFocus denied, Invalid type:", Integer.valueOf(paramInt) });
      return 1;
    }
    if (QLog.isColorLevel()) {
      if (paramOnMediaFocusChangeListener != null) {
        break label97;
      }
    }
    label97:
    for (String str = "null";; str = paramOnMediaFocusChangeListener.toString())
    {
      QLog.d("MediaFocusManager", 2, new Object[] { "requestMediaFocus focusType:", Integer.valueOf(paramInt), " ,listener:", str });
      a(paramOnMediaFocusChangeListener);
      return this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController.a(paramInt, a(paramOnMediaFocusChangeListener));
    }
  }
  
  public int a(MediaFocusManager.OnMediaFocusChangeListener paramOnMediaFocusChangeListener)
  {
    if (QLog.isColorLevel()) {
      if (paramOnMediaFocusChangeListener != null) {
        break label61;
      }
    }
    label61:
    for (String str = "null";; str = paramOnMediaFocusChangeListener.toString())
    {
      QLog.d("MediaFocusManager", 2, new Object[] { "abandonMediaFocus! listener:", str });
      if ((!a(paramOnMediaFocusChangeListener, true)) || (this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController == null)) {
        break;
      }
      return this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController.a(a(paramOnMediaFocusChangeListener));
    }
    return 1;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaFocusManager", 2, new Object[] { "onClear map:", Integer.valueOf(this.jdField_a_of_type_JavaUtilHashMap.size()) });
    }
    if ((this.jdField_a_of_type_JavaUtilHashMap.isEmpty()) && (this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController.a();
      this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController = null;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaFocusManager", 2, new Object[] { "onDispatch focus:", Integer.valueOf(paramInt), " ,id:", paramString });
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusManager$FocusEventHandlerDelegate.a().obtainMessage(paramInt, paramString);
    this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusManager$FocusEventHandlerDelegate.a().sendMessage(paramString);
  }
  
  protected boolean a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController != null) {
      return this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController.a(paramString1, paramString2);
    }
    return false;
  }
  
  public int b(MediaFocusManager.OnMediaFocusChangeListener paramOnMediaFocusChangeListener)
  {
    if (QLog.isColorLevel()) {
      if (paramOnMediaFocusChangeListener != null) {
        break label61;
      }
    }
    label61:
    for (String str = "null";; str = paramOnMediaFocusChangeListener.toString())
    {
      QLog.d("MediaFocusManager", 2, new Object[] { "abandonMediaFocusForce! listener:", str });
      if ((!a(paramOnMediaFocusChangeListener, false)) || (this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController == null)) {
        break;
      }
      return this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController.a(a(paramOnMediaFocusChangeListener));
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mediafocus.MediaFocusManager
 * JD-Core Version:    0.7.0.1
 */