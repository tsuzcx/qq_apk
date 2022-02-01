package com.tencent.mobileqq.mediafocus;

import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class MediaFocusManager
  implements MediaFocusController.IMediaFocusStatusCallback
{
  private final Object a = new Object();
  private final HashMap<String, MediaFocusManager.OnMediaFocusChangeListener> b = new HashMap();
  private final HashMap<String, Integer> c = new HashMap();
  private final MediaFocusManager.FocusEventHandlerDelegate d = new MediaFocusManager.FocusEventHandlerDelegate(this);
  private MediaFocusController e;
  
  private MediaFocusManager.OnMediaFocusChangeListener a(String paramString)
  {
    return (MediaFocusManager.OnMediaFocusChangeListener)this.b.get(paramString);
  }
  
  private boolean a(MediaFocusManager.OnMediaFocusChangeListener paramOnMediaFocusChangeListener, boolean paramBoolean)
  {
    synchronized (this.a)
    {
      paramOnMediaFocusChangeListener = d(paramOnMediaFocusChangeListener);
      boolean bool = true;
      if (!paramBoolean)
      {
        this.c.remove(paramOnMediaFocusChangeListener);
        this.b.remove(paramOnMediaFocusChangeListener);
        return true;
      }
      if (this.c.containsKey(paramOnMediaFocusChangeListener))
      {
        int i = ((Integer)this.c.get(paramOnMediaFocusChangeListener)).intValue();
        if (i > 1)
        {
          this.c.put(paramOnMediaFocusChangeListener, Integer.valueOf(i - 1));
          paramBoolean = false;
        }
        else
        {
          this.c.remove(paramOnMediaFocusChangeListener);
          this.b.remove(paramOnMediaFocusChangeListener);
          paramBoolean = bool;
        }
      }
      else
      {
        this.b.remove(paramOnMediaFocusChangeListener);
        paramBoolean = bool;
      }
      return paramBoolean;
    }
  }
  
  public static final MediaFocusManager b()
  {
    return MediaFocusManager.MediaFocusMgrHolder.a();
  }
  
  private void c(MediaFocusManager.OnMediaFocusChangeListener paramOnMediaFocusChangeListener)
  {
    synchronized (this.a)
    {
      if (this.e == null) {
        this.e = new MediaFocusController(this);
      }
      String str = d(paramOnMediaFocusChangeListener);
      if (this.c.containsKey(str))
      {
        int i = ((Integer)this.c.get(str)).intValue();
        this.c.put(str, Integer.valueOf(i + 1));
      }
      else
      {
        this.c.put(str, Integer.valueOf(1));
      }
      if (this.b.containsKey(str)) {
        return;
      }
      this.b.put(str, paramOnMediaFocusChangeListener);
      return;
    }
  }
  
  private String d(MediaFocusManager.OnMediaFocusChangeListener paramOnMediaFocusChangeListener)
  {
    if (paramOnMediaFocusChangeListener == null) {
      return new String(toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(toString());
    localStringBuilder.append(paramOnMediaFocusChangeListener.toString());
    return new String(localStringBuilder.toString());
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
      c(paramOnMediaFocusChangeListener);
      return this.e.a(paramInt, d(paramOnMediaFocusChangeListener));
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
      localObject = this.e;
      i = j;
      if (localObject != null) {
        i = ((MediaFocusController)localObject).a(d(paramOnMediaFocusChangeListener));
      }
    }
    return i;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaFocusManager", 2, new Object[] { "onClear map:", Integer.valueOf(this.b.size()) });
    }
    if (this.b.isEmpty())
    {
      MediaFocusController localMediaFocusController = this.e;
      if (localMediaFocusController != null)
      {
        localMediaFocusController.a();
        this.e = null;
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaFocusManager", 2, new Object[] { "onDispatch focus:", Integer.valueOf(paramInt), " ,id:", paramString });
    }
    paramString = this.d.a().obtainMessage(paramInt, paramString);
    this.d.a().sendMessage(paramString);
  }
  
  protected boolean a(String paramString1, String paramString2)
  {
    MediaFocusController localMediaFocusController = this.e;
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
      localObject = this.e;
      i = j;
      if (localObject != null) {
        i = ((MediaFocusController)localObject).a(d(paramOnMediaFocusChangeListener));
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mediafocus.MediaFocusManager
 * JD-Core Version:    0.7.0.1
 */