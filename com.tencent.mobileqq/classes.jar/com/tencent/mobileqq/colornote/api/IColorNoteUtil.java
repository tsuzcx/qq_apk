package com.tencent.mobileqq.colornote.api;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNoteRecentConfBean;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IColorNoteUtil
  extends QRouteApi
{
  public abstract boolean checkPermission(Context paramContext);
  
  public abstract ColorNote createRecentColorNote(ColorNote paramColorNote);
  
  public abstract void decorateColorNote(ColorNote paramColorNote);
  
  public abstract String getContentDescription(List<ColorNote> paramList);
  
  public abstract int getHistoryType(int paramInt);
  
  public abstract int getOriginType(int paramInt);
  
  public abstract String getWebViewIconUrl(String paramString);
  
  public abstract void hideColorNoteSmallScreen(Context paramContext);
  
  public abstract boolean isAfterSyncMsg();
  
  public abstract boolean isDisableSwipeByUrl(String paramString);
  
  public abstract boolean isNeedNowNotify(ColorNote paramColorNote);
  
  public abstract boolean isRecentColorNote(ColorNote paramColorNote);
  
  public abstract boolean isUpcomingColorNote(ColorNote paramColorNote);
  
  public abstract boolean isUrlBlocked(String paramString);
  
  public abstract boolean isUrlShareEntranceBlocked(String paramString);
  
  public abstract boolean isUrlSmallScreenBlocked(String paramString);
  
  public abstract ColorNoteRecentConfBean loadConfig();
  
  public abstract void notifyUpcoming(Context paramContext, ColorNote paramColorNote);
  
  public abstract boolean propertyEquals(String paramString1, String paramString2);
  
  public abstract void requestPermission(Context paramContext);
  
  public abstract void sendUpdateSmallScreenStateBroadcast(Context paramContext, int paramInt, boolean paramBoolean);
  
  public abstract void setAfterSyncMsg(boolean paramBoolean);
  
  public abstract void setAppOnForeground(AppRuntime paramAppRuntime, boolean paramBoolean);
  
  public abstract void showFullDialog(Context paramContext);
  
  public abstract void showList(Context paramContext, boolean paramBoolean);
  
  public abstract void showListFromAddTodo(Context paramContext, boolean paramBoolean);
  
  public abstract void startColorNoteSettingPage(Context paramContext, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.api.IColorNoteUtil
 * JD-Core Version:    0.7.0.1
 */