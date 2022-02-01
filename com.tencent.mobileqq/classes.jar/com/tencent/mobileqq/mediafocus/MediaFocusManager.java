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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(toString());
    localStringBuilder.append(paramOnMediaFocusChangeListener.toString());
    return new String(localStringBuilder.toString());
  }
  
  private void a(MediaFocusManager.OnMediaFocusChangeListener paramOnMediaFocusChangeListener)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController == null) {
        this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController = new MediaFocusController(this);
      }
      String str = a(paramOnMediaFocusChangeListener);
      if (this.b.containsKey(str))
      {
        int i = ((Integer)this.b.get(str)).intValue();
        this.b.put(str, Integer.valueOf(i + 1));
      }
      else
      {
        this.b.put(str, Integer.valueOf(1));
      }
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(str)) {
        return;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(str, paramOnMediaFocusChangeListener);
      return;
    }
  }
  
  private boolean a(MediaFocusManager.OnMediaFocusChangeListener paramOnMediaFocusChangeListener, boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      paramOnMediaFocusChangeListener = a(paramOnMediaFocusChangeListener);
      boolean bool = true;
      if (!paramBoolean)
      {
        this.b.remove(paramOnMediaFocusChangeListener);
        this.jdField_a_of_type_JavaUtilHashMap.remove(paramOnMediaFocusChangeListener);
        return true;
      }
      if (this.b.containsKey(paramOnMediaFocusChangeListener))
      {
        int i = ((Integer)this.b.get(paramOnMediaFocusChangeListener)).intValue();
        if (i > 1)
        {
          this.b.put(paramOnMediaFocusChangeListener, Integer.valueOf(i - 1));
          paramBoolean = false;
        }
        else
        {
          this.b.remove(paramOnMediaFocusChangeListener);
          this.jdField_a_of_type_JavaUtilHashMap.remove(paramOnMediaFocusChangeListener);
          paramBoolean = bool;
        }
      }
      else
      {
        this.jdField_a_of_type_JavaUtilHashMap.remove(paramOnMediaFocusChangeListener);
        paramBoolean = bool;
      }
      return paramBoolean;
    }
  }
  
  public int a(int paramInt, MediaFocusManager.OnMediaFocusChangeListener paramOnMediaFocusChangeListener)
  {
    if ((paramInt >= 1) && (paramInt <= 3))
    {
      if (QLog.isColorLevel())
      {
        String str;
        if (paramOnMediaFocusChangeListener == null) {
          str = "null";
        } else {
          str = paramOnMediaFocusChangeListener.toString();
        }
        QLog.d("MediaFocusManager", 2, new Object[] { "requestMediaFocus focusType:", Integer.valueOf(paramInt), " ,listener:", str });
      }
      a(paramOnMediaFocusChangeListener);
      return this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController.a(paramInt, a(paramOnMediaFocusChangeListener));
    }
    QLog.e("MediaFocusManager", 1, new Object[] { "requestMediaFocus denied, Invalid type:", Integer.valueOf(paramInt) });
    return 1;
  }
  
  public int a(MediaFocusManager.OnMediaFocusChangeListener paramOnMediaFocusChangeListener)
  {
    boolean bool = QLog.isColorLevel();
    int j = 1;
    Object localObject;
    if (bool)
    {
      if (paramOnMediaFocusChangeListener == null) {
        localObject = "null";
      } else {
        localObject = paramOnMediaFocusChangeListener.toString();
      }
      QLog.d("MediaFocusManager", 2, new Object[] { "abandonMediaFocus! listener:", localObject });
    }
    int i = j;
    if (a(paramOnMediaFocusChangeListener, true))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController;
      i = j;
      if (localObject != null) {
        i = ((MediaFocusController)localObject).a(a(paramOnMediaFocusChangeListener));
      }
    }
    return i;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaFocusManager", 2, new Object[] { "onClear map:", Integer.valueOf(this.jdField_a_of_type_JavaUtilHashMap.size()) });
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.isEmpty())
    {
      MediaFocusController localMediaFocusController = this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController;
      if (localMediaFocusController != null)
      {
        localMediaFocusController.a();
        this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController = null;
      }
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
    MediaFocusController localMediaFocusController = this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController;
    if (localMediaFocusController != null) {
      return localMediaFocusController.a(paramString1, paramString2);
    }
    return false;
  }
  
  public int b(MediaFocusManager.OnMediaFocusChangeListener paramOnMediaFocusChangeListener)
  {
    boolean bool = QLog.isColorLevel();
    int j = 1;
    Object localObject;
    if (bool)
    {
      if (paramOnMediaFocusChangeListener == null) {
        localObject = "null";
      } else {
        localObject = paramOnMediaFocusChangeListener.toString();
      }
      QLog.d("MediaFocusManager", 2, new Object[] { "abandonMediaFocusForce! listener:", localObject });
    }
    int i = j;
    if (a(paramOnMediaFocusChangeListener, false))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController;
      i = j;
      if (localObject != null) {
        i = ((MediaFocusController)localObject).a(a(paramOnMediaFocusChangeListener));
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mediafocus.MediaFocusManager
 * JD-Core Version:    0.7.0.1
 */