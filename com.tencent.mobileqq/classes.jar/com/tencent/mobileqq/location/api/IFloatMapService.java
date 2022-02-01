package com.tencent.mobileqq.location.api;

import android.app.Dialog;
import android.support.annotation.UiThread;
import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.location.ThemeChangedListener;
import com.tencent.mobileqq.location.callback.IFloatMapCallback;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IFloatMapService
  extends IRuntimeService
{
  public abstract void addFloatMapCallback(IFloatMapCallback paramIFloatMapCallback);
  
  public abstract Dialog createFloatExitConfirmDialog(int paramInt, String paramString);
  
  public abstract LocationRoom.RoomKey currentFloatWindowVisibleRoomKey();
  
  public abstract boolean enterFloat(QBaseActivity paramQBaseActivity, LocationRoom.RoomKey paramRoomKey);
  
  public abstract boolean getBadNetOnFloatWindowDialogShown();
  
  public abstract List<IFloatMapCallback> getFloatMapCallbacks();
  
  public abstract View getFloatMapView();
  
  @UiThread
  public abstract void quitFloat(int paramInt);
  
  public abstract void removeFloatMapCallback(IFloatMapCallback paramIFloatMapCallback);
  
  public abstract void setBadNetOnFloatWindowDialogShown(boolean paramBoolean);
  
  public abstract void setThemeChangedListener(ThemeChangedListener paramThemeChangedListener);
  
  public abstract void showFloatTypeDialog(LocationRoom.RoomKey paramRoomKey);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.api.IFloatMapService
 * JD-Core Version:    0.7.0.1
 */