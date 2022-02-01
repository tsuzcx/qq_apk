package com.tencent.mobileqq.colornote.api.impl;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNoteRecentConfBean;
import com.tencent.mobileqq.colornote.data.ColorNoteRecentConfigProcessor;
import com.tencent.mobileqq.colornote.data.ColorNoteUtils;
import com.tencent.mobileqq.colornote.settings.ColorNoteSettingFragment;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenPermissionUtil;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenUtil;
import java.util.List;
import mqq.app.AppRuntime;

public class ColorNoteUtilImpl
  implements IColorNoteUtil
{
  public boolean checkPermission(Context paramContext)
  {
    return ColorNoteSmallScreenPermissionUtil.a(paramContext);
  }
  
  public ColorNote createRecentColorNote(ColorNote paramColorNote)
  {
    return ColorNoteUtils.a(paramColorNote);
  }
  
  public void decorateColorNote(ColorNote paramColorNote)
  {
    ColorNoteUtils.a(paramColorNote);
  }
  
  public String getContentDescription(List<ColorNote> paramList)
  {
    return ColorNoteUtils.a(paramList);
  }
  
  public int getHistoryType(int paramInt)
  {
    return ColorNoteUtils.b(paramInt);
  }
  
  public int getOriginType(int paramInt)
  {
    return ColorNoteUtils.a(paramInt);
  }
  
  public String getWebViewIconUrl(String paramString)
  {
    return ColorNoteUtils.a(paramString);
  }
  
  public void hideColorNoteSmallScreen(Context paramContext)
  {
    ColorNoteSmallScreenUtil.b(paramContext);
  }
  
  public boolean isAfterSyncMsg()
  {
    return ColorNoteSmallScreenUtil.b();
  }
  
  public boolean isDisableSwipeByUrl(String paramString)
  {
    return ColorNoteUtils.d(paramString);
  }
  
  public boolean isNeedNowNotify(ColorNote paramColorNote)
  {
    return ColorNoteUtils.c(paramColorNote);
  }
  
  public boolean isRecentColorNote(ColorNote paramColorNote)
  {
    return ColorNoteUtils.b(paramColorNote);
  }
  
  public boolean isUpcomingColorNote(ColorNote paramColorNote)
  {
    return ColorNoteUtils.d(paramColorNote);
  }
  
  public boolean isUrlBlocked(String paramString)
  {
    return ColorNoteUtils.a(paramString);
  }
  
  public boolean isUrlShareEntranceBlocked(String paramString)
  {
    return ColorNoteUtils.c(paramString);
  }
  
  public boolean isUrlSmallScreenBlocked(String paramString)
  {
    return ColorNoteUtils.b(paramString);
  }
  
  public ColorNoteRecentConfBean loadConfig()
  {
    return ColorNoteRecentConfigProcessor.a();
  }
  
  public void notifyUpcoming(Context paramContext, ColorNote paramColorNote)
  {
    ColorNoteUtils.a(paramContext, paramColorNote);
  }
  
  public boolean propertyEquals(String paramString1, String paramString2)
  {
    return ColorNoteUtils.a(paramString1, paramString2);
  }
  
  public void requestPermission(Context paramContext)
  {
    ColorNoteSmallScreenPermissionUtil.d(paramContext);
  }
  
  public void sendUpdateSmallScreenStateBroadcast(Context paramContext, int paramInt, boolean paramBoolean)
  {
    ColorNoteSmallScreenUtil.a(paramContext, paramInt, paramBoolean);
  }
  
  public void setAfterSyncMsg(boolean paramBoolean)
  {
    ColorNoteSmallScreenUtil.a(paramBoolean);
  }
  
  public void setAppOnForeground(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    ColorNoteSmallScreenUtil.a(paramAppRuntime, paramBoolean);
  }
  
  public void showFullDialog(Context paramContext)
  {
    ColorNoteUtils.a(paramContext);
  }
  
  public void showList(Context paramContext, boolean paramBoolean)
  {
    ColorNoteSmallScreenUtil.a(paramContext, paramBoolean);
  }
  
  public void showListFromAddTodo(Context paramContext, boolean paramBoolean)
  {
    ColorNoteSmallScreenUtil.b(paramContext, paramBoolean);
  }
  
  public void startColorNoteSettingPage(Context paramContext, Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("start_from", 2);
    ColorNoteSettingFragment.a(paramContext, ColorNoteSettingFragment.class, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.api.impl.ColorNoteUtilImpl
 * JD-Core Version:    0.7.0.1
 */