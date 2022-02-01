package com.tencent.mobileqq.colornote.ipc;

import android.graphics.Point;
import com.tencent.mobileqq.colornote.OnColorNoteCurdListener;
import com.tencent.mobileqq.colornote.smallscreen.IServiceSyncListener;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IColorNoteProcessState
  extends QRouteApi
{
  public abstract boolean getCanAddColorNote();
  
  public abstract Point getFloatingWindowPosition();
  
  public abstract boolean getSyncState();
  
  public abstract boolean isColorNoteExist(int paramInt, String paramString);
  
  public abstract boolean isRecentColorNoteTurnOn(AppRuntime paramAppRuntime);
  
  public abstract void registerBroadcast();
  
  public abstract void setCanAddColorNote(boolean paramBoolean);
  
  public abstract void setColorNoteCurdListener(OnColorNoteCurdListener paramOnColorNoteCurdListener);
  
  public abstract void setRecentColorNoteSwitch(AppRuntime paramAppRuntime, boolean paramBoolean);
  
  public abstract void setServiceSyncListener(IServiceSyncListener paramIServiceSyncListener);
  
  public abstract void setSyncState(boolean paramBoolean);
  
  public abstract void unregisterBroadcast();
  
  public abstract void updateColorNoteSet(int paramInt, String paramString, boolean paramBoolean);
  
  public abstract void updateFloatingWindowPosition(Point paramPoint);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.ipc.IColorNoteProcessState
 * JD-Core Version:    0.7.0.1
 */