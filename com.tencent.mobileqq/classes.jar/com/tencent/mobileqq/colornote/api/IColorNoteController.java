package com.tencent.mobileqq.colornote.api;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.colornote.IServiceInfo;
import com.tencent.mobileqq.colornote.OnColorNoteCurdListener;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.smallscreen.IServiceSyncListener;
import com.tencent.mobileqq.colornote.swipeback.IColorNoteSwipeLayout;
import com.tencent.mobileqq.colornote.swipeback.OnColorNoteAnimFinishListener;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.mobileqq.swipe.OnPageSwipeListener;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface IColorNoteController
  extends QRouteApi
{
  public abstract void addHistoryNote();
  
  public abstract void addToRecentNote();
  
  public abstract void attachToActivity(Activity paramActivity);
  
  public abstract boolean canAddColorNote();
  
  public abstract void deleteColorNote();
  
  public abstract boolean detectCacheFull(AppRuntime paramAppRuntime, int paramInt);
  
  public abstract void disableAutoRecentNote();
  
  public abstract void disablePostTable();
  
  public abstract void disableSwipe();
  
  public abstract void disableToast();
  
  public abstract void doSetPropertiesFromWebView(String paramString);
  
  public abstract void enablePostTable();
  
  public abstract void enableSwipe();
  
  public abstract void exitAnimation();
  
  public abstract IColorNoteSwipeLayout getSwipePostTableLayout();
  
  public abstract boolean hasShareEntr();
  
  public abstract void init(Context paramContext, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void init(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, IColorNoteSwipeLayout paramIColorNoteSwipeLayout, boolean paramBoolean3, boolean paramBoolean4, int paramInt);
  
  public abstract void init(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, IColorNoteSwipeLayout paramIColorNoteSwipeLayout, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt);
  
  public abstract void init(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt);
  
  public abstract void insertColorNote();
  
  public abstract boolean isColorNoteExist();
  
  public abstract boolean isColorNoteExist(ColorNote paramColorNote);
  
  public abstract boolean isFirstCloseRecentNote();
  
  public abstract boolean isSwipeBackExit();
  
  public abstract void onCannotAdd();
  
  public abstract void onDestroy();
  
  public abstract ColorNote onGetColorNote(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, byte[] paramArrayOfByte);
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void refreshPostTable(Activity paramActivity);
  
  public abstract void registerBroadcast();
  
  public abstract void setCustomNightMode(Context paramContext, boolean paramBoolean);
  
  public abstract void setFirstCloseRecentNote(AppRuntime paramAppRuntime);
  
  public abstract void setLeftSwipeScope(int paramInt);
  
  public abstract void setOnColorNoteAnimFinishListener(OnColorNoteAnimFinishListener paramOnColorNoteAnimFinishListener);
  
  public abstract void setOnColorNoteCurdListener(OnColorNoteCurdListener paramOnColorNoteCurdListener);
  
  public abstract void setOnPageSwipeListener(OnPageSwipeListener paramOnPageSwipeListener);
  
  public abstract void setRecentlyViewedSwitch(AppRuntime paramAppRuntime, boolean paramBoolean);
  
  public abstract void setServiceInfo(IServiceInfo paramIServiceInfo);
  
  public abstract void setServiceSyncListener(IServiceSyncListener paramIServiceSyncListener);
  
  public abstract void setShareEntr(boolean paramBoolean);
  
  public abstract void setSmallScreenShouldShow(boolean paramBoolean, int paramInt);
  
  public abstract boolean shouldDisplayColorNote();
  
  public abstract void updateColorNote(ColorNote paramColorNote);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.api.IColorNoteController
 * JD-Core Version:    0.7.0.1
 */