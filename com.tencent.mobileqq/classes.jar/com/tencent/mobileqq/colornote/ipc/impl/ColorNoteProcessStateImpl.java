package com.tencent.mobileqq.colornote.ipc.impl;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.graphics.Point;
import com.tencent.mobileqq.colornote.ColorNoteRecentView;
import com.tencent.mobileqq.colornote.OnColorNoteCurdListener;
import com.tencent.mobileqq.colornote.data.ColorNoteUtils;
import com.tencent.mobileqq.colornote.ipc.IColorNoteProcessState;
import com.tencent.mobileqq.colornote.smallscreen.IServiceSyncListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

public class ColorNoteProcessStateImpl
  implements IColorNoteProcessState
{
  public static final String MODULE_NAME = "color_note_client_module";
  private static final byte[] S_DATA_LOCK = new byte[0];
  private static final byte[] S_INSTANCE_LOCK = new byte[0];
  private static final String TAG = "ColorNoteQIPCModule";
  private static ColorNoteProcessStateImpl sInstance;
  private boolean mCanAddColorNote = true;
  private WeakReference<OnColorNoteCurdListener> mColorNoteCurdListener;
  private Set<String> mColorNoteSet = new HashSet();
  private Point mFloatingWindowPosition = new Point();
  private BroadcastReceiver mReceiver = new ColorNoteProcessStateImpl.1(this);
  private WeakReference<IServiceSyncListener> mServiceSyncListener;
  private boolean mSyncState = true;
  
  public boolean getCanAddColorNote()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[getCanAddColorNote] ");
      localStringBuilder.append(ColorNoteUtils.a());
      QLog.d("ColorNoteQIPCModule", 2, localStringBuilder.toString());
    }
    return this.mCanAddColorNote;
  }
  
  public Point getFloatingWindowPosition()
  {
    return this.mFloatingWindowPosition;
  }
  
  public boolean getSyncState()
  {
    return this.mSyncState;
  }
  
  public boolean isColorNoteExist(int paramInt, String paramString)
  {
    return isColorNoteExist(paramInt, paramString, 0);
  }
  
  public boolean isColorNoteExist(int paramInt1, String paramString, int paramInt2)
  {
    if (paramInt2 != 2)
    {
      Set localSet = this.mColorNoteSet;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(paramString);
      localStringBuilder.append(paramInt2);
      if (localSet.contains(localStringBuilder.toString())) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isRecentColorNoteTurnOn(AppRuntime paramAppRuntime)
  {
    return ColorNoteRecentView.a(paramAppRuntime);
  }
  
  public void registerBroadcast()
  {
    IntentFilter localIntentFilter = new IntentFilter("key_float_window_position");
    localIntentFilter.addAction("key_delete_item_call");
    localIntentFilter.addAction("key_after_sync_msg");
    try
    {
      MobileQQ.getContext().registerReceiver(this.mReceiver, localIntentFilter);
    }
    catch (Exception localException)
    {
      QLog.e("ColorNoteQIPCModule", 2, "register failed", localException);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteQIPCModule", 1, "register broadcast");
    }
  }
  
  public void setCanAddColorNote(boolean paramBoolean)
  {
    this.mCanAddColorNote = paramBoolean;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[setCanAddColorNote] ");
      localStringBuilder.append(ColorNoteUtils.a());
      QLog.d("ColorNoteQIPCModule", 2, localStringBuilder.toString());
    }
  }
  
  public void setColorNoteCache(Set<String> paramSet)
  {
    this.mColorNoteSet = paramSet;
  }
  
  public void setColorNoteCurdListener(OnColorNoteCurdListener paramOnColorNoteCurdListener)
  {
    this.mColorNoteCurdListener = new WeakReference(paramOnColorNoteCurdListener);
  }
  
  public void setRecentColorNoteSwitch(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    ColorNoteRecentView.a(paramAppRuntime, paramBoolean);
  }
  
  public void setServiceSyncListener(IServiceSyncListener paramIServiceSyncListener)
  {
    this.mServiceSyncListener = new WeakReference(paramIServiceSyncListener);
  }
  
  public void setSyncState(boolean paramBoolean)
  {
    this.mSyncState = paramBoolean;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[setSyncState] ");
      localStringBuilder.append(ColorNoteUtils.a());
      QLog.d("ColorNoteQIPCModule", 2, localStringBuilder.toString());
    }
  }
  
  public void unregisterBroadcast()
  {
    try
    {
      MobileQQ.getContext().unregisterReceiver(this.mReceiver);
    }
    catch (Exception localException)
    {
      QLog.e("ColorNoteQIPCModule", 2, "unregister failed", localException);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteQIPCModule", 1, "unregister broadcast");
    }
  }
  
  public void updateColorNoteSet(int paramInt, String paramString, boolean paramBoolean)
  {
    updateColorNoteSet(paramInt, paramString, paramBoolean, 0);
  }
  
  public void updateColorNoteSet(int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[updateColorNoteSet] ");
      localStringBuilder.append(ColorNoteUtils.a());
      QLog.d("ColorNoteQIPCModule", 2, localStringBuilder.toString());
    }
    if (paramInt2 == 2) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(paramString);
    localStringBuilder.append(paramInt2);
    paramString = localStringBuilder.toString();
    if (paramBoolean)
    {
      this.mColorNoteSet.add(paramString);
      return;
    }
    this.mColorNoteSet.remove(paramString);
  }
  
  public void updateFloatingWindowPosition(Point paramPoint)
  {
    if ((paramPoint != null) && (paramPoint.x != 0) && (paramPoint.y != 0)) {
      this.mFloatingWindowPosition = paramPoint;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.ipc.impl.ColorNoteProcessStateImpl
 * JD-Core Version:    0.7.0.1
 */