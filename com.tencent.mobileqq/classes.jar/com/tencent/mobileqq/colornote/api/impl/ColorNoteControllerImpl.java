package com.tencent.mobileqq.colornote.api.impl;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.util.SparseArrayCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.mobileqq.colornote.ColorNoteConstants;
import com.tencent.mobileqq.colornote.ColorNoteLauncherInjectUtil;
import com.tencent.mobileqq.colornote.ColorNoteRecentView;
import com.tencent.mobileqq.colornote.IServiceInfo;
import com.tencent.mobileqq.colornote.OnColorNoteCurdListener;
import com.tencent.mobileqq.colornote.anim.EnterExitAnimHelper;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNote.Builder;
import com.tencent.mobileqq.colornote.data.ColorNoteUtils;
import com.tencent.mobileqq.colornote.ipc.IColorNoteProcessState;
import com.tencent.mobileqq.colornote.launcher.ILauncher;
import com.tencent.mobileqq.colornote.list.DefaultItemBuilder;
import com.tencent.mobileqq.colornote.list.ItemBuilder;
import com.tencent.mobileqq.colornote.list.ReaderItemBuilder;
import com.tencent.mobileqq.colornote.settings.ColorNoteHistoryManager;
import com.tencent.mobileqq.colornote.share.ColorNoteStateNotice;
import com.tencent.mobileqq.colornote.share.ShareEntrance;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenService;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenUtil;
import com.tencent.mobileqq.colornote.smallscreen.IServiceSyncListener;
import com.tencent.mobileqq.colornote.swipeback.IColorNoteSwipeLayout;
import com.tencent.mobileqq.colornote.swipeback.OnColorNoteAnimFinishListener;
import com.tencent.mobileqq.colornote.swipeback.impl.SwipePostTableLayoutImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.swipe.OnPageSwipeListener;
import com.tencent.mobileqq.swipe.SwipeBackLayout.OnSwipeListener;
import com.tencent.mobileqq.swipe.SwipeLayoutUtils;
import com.tencent.mobileqq.utils.TranslucentConvertor;
import com.tencent.mobileqq.utils.TranslucentConvertor.OnTranslucentConversionListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ColorNoteControllerImpl
  implements IColorNoteController, SwipeBackLayout.OnSwipeListener, TranslucentConvertor.OnTranslucentConversionListener
{
  private static final String TAG = "ColorNoteController";
  private static SparseArrayCompat<ItemBuilder> itemBuilders;
  private static final Map<Integer, ILauncher> launchers = new TreeMap();
  private Runnable forceCloseRunnable = new ColorNoteControllerImpl.1(this);
  private boolean hasPendingExitAnim;
  private boolean hasShareEntr = true;
  private boolean mAutoRecentNote = false;
  private ColorNoteStateNotice mColorNoteStateNotice;
  private EnterExitAnimHelper mEnterExitAnimHelper;
  private OnColorNoteAnimFinishListener mOnColorNoteAnimFinishListener;
  private ShareEntrance mShareEntrance;
  private boolean mShowToast = true;
  private IColorNoteSwipeLayout mSwipePostTableLayout;
  private TranslucentConvertor translucentConvertor;
  
  static
  {
    try
    {
      Iterator localIterator = ColorNoteLauncherInjectUtil.a.iterator();
      while (localIterator.hasNext())
      {
        ILauncher localILauncher = (ILauncher)((Class)localIterator.next()).newInstance();
        launchers.put(Integer.valueOf(localILauncher.getType()), localILauncher);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ColorNoteController", 1, "[static]", localException);
    }
  }
  
  public static void addHistoryNote(ColorNote paramColorNote)
  {
    ColorNoteHistoryManager.a(paramColorNote);
  }
  
  private void exitAnimation(boolean paramBoolean)
  {
    if (this.mEnterExitAnimHelper != null)
    {
      Object localObject = this.mSwipePostTableLayout;
      if (localObject != null) {
        ((View)localObject).removeCallbacks(this.forceCloseRunnable);
      }
      localObject = ((IColorNoteProcessState)QRoute.api(IColorNoteProcessState.class)).getFloatingWindowPosition();
      if (localObject != null) {
        this.mEnterExitAnimHelper.a(((Point)localObject).x, ((Point)localObject).y);
      }
      if (!isColorNoteExist())
      {
        localObject = this.mSwipePostTableLayout;
        if ((localObject == null) || (!((IColorNoteSwipeLayout)localObject).getIsSwipeAdd()))
        {
          this.mOnColorNoteAnimFinishListener.onColorNoteAnimFinish();
          return;
        }
      }
      localObject = this.translucentConvertor;
      boolean bool = true;
      if ((localObject != null) && (!((TranslucentConvertor)localObject).a()))
      {
        if (paramBoolean)
        {
          this.mOnColorNoteAnimFinishListener.onColorNoteAnimFinish();
          return;
        }
        this.hasPendingExitAnim = true;
        this.translucentConvertor.b();
        localObject = this.mSwipePostTableLayout;
        if (localObject != null) {
          ((View)localObject).postDelayed(this.forceCloseRunnable, 500L);
        }
        return;
      }
      int i = 0;
      this.hasPendingExitAnim = false;
      localObject = this.mShareEntrance;
      if (localObject != null)
      {
        localObject = ((ShareEntrance)localObject).a();
        if (localObject != null)
        {
          localObject = ((IServiceInfo)localObject).getColorNote();
          if ((localObject != null) && (((ColorNote)localObject).mServiceType == 16842752))
          {
            paramBoolean = bool;
            break label247;
          }
        }
      }
      paramBoolean = false;
      label247:
      localObject = this.mEnterExitAnimHelper;
      OnColorNoteAnimFinishListener localOnColorNoteAnimFinishListener = this.mOnColorNoteAnimFinishListener;
      IColorNoteSwipeLayout localIColorNoteSwipeLayout = this.mSwipePostTableLayout;
      if (localIColorNoteSwipeLayout != null) {
        i = localIColorNoteSwipeLayout.getScrollX();
      }
      ((EnterExitAnimHelper)localObject).a(localOnColorNoteAnimFinishListener, paramBoolean, i);
    }
  }
  
  public static ItemBuilder getItemBuilder(ColorNote paramColorNote)
  {
    if (itemBuilders == null) {
      initItemBuilders();
    }
    ItemBuilder localItemBuilder = (ItemBuilder)itemBuilders.get(paramColorNote.getServiceType());
    paramColorNote = localItemBuilder;
    if (localItemBuilder == null) {
      paramColorNote = (ItemBuilder)itemBuilders.get(65536);
    }
    return paramColorNote;
  }
  
  private static void initItemBuilders()
  {
    itemBuilders = new SparseArrayCompat();
    itemBuilders.put(65536, new DefaultItemBuilder());
    itemBuilders.put(16908289, new ReaderItemBuilder());
  }
  
  public static boolean isRecentlyViewedSwitchOn(AppRuntime paramAppRuntime)
  {
    return ((IColorNoteProcessState)QRoute.api(IColorNoteProcessState.class)).isRecentColorNoteTurnOn(paramAppRuntime);
  }
  
  public static boolean launch(Context paramContext, ColorNote paramColorNote)
  {
    return launch(paramContext, paramColorNote, null);
  }
  
  public static boolean launch(Context paramContext, ColorNote paramColorNote, Bundle paramBundle)
  {
    int i = ColorNoteUtils.a(paramColorNote.getServiceType());
    ILauncher localILauncher = (ILauncher)launchers.get(Integer.valueOf(i));
    if (localILauncher != null)
    {
      localILauncher.onCreate(paramContext, paramColorNote, paramBundle);
      if (!ColorNoteUtils.d(paramColorNote)) {
        ReportController.b(null, "dc00898", "", "", "0X800A749", "0X800A749", ColorNoteConstants.a(paramColorNote.getServiceType()), 0, "", "", "", "");
      }
      paramBundle = paramColorNote;
      if (ColorNoteUtils.d(paramColorNote)) {
        paramBundle = ColorNoteUtils.e(paramColorNote);
      }
      localILauncher.launch(paramContext, paramBundle);
      return true;
    }
    return false;
  }
  
  public void addHistoryNote()
  {
    ShareEntrance localShareEntrance = this.mShareEntrance;
    if (localShareEntrance != null) {
      ColorNoteHistoryManager.a(localShareEntrance.g());
    }
  }
  
  public void addToRecentNote()
  {
    Object localObject = this.mSwipePostTableLayout;
    if (localObject != null)
    {
      ((IColorNoteSwipeLayout)localObject).noticeRecentColorNote();
      return;
    }
    localObject = this.mColorNoteStateNotice;
    if (localObject != null)
    {
      ((ColorNoteStateNotice)localObject).c();
      return;
    }
    QLog.d("ColorNoteController", 1, "[addToRecentNote] mColorNoteStateNotice is null.");
  }
  
  public void attachToActivity(Activity paramActivity)
  {
    Object localObject = this.mSwipePostTableLayout;
    if (localObject != null) {
      ((IColorNoteSwipeLayout)localObject).attachToActivity(paramActivity);
    }
    paramActivity = (ViewGroup)paramActivity.getWindow().getDecorView();
    localObject = paramActivity.getChildAt(0);
    View localView = paramActivity.findViewById(16908290);
    paramActivity = localView;
    if (localView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ColorNoteController", 2, "can not find content view");
      }
      paramActivity = (Activity)localObject;
    }
    this.mShareEntrance.a(paramActivity);
    this.mEnterExitAnimHelper = new EnterExitAnimHelper(paramActivity);
    this.mEnterExitAnimHelper.a();
    ((IColorNoteProcessState)QRoute.api(IColorNoteProcessState.class)).registerBroadcast();
  }
  
  public boolean canAddColorNote()
  {
    ShareEntrance localShareEntrance = this.mShareEntrance;
    if (localShareEntrance != null) {
      return localShareEntrance.d();
    }
    return false;
  }
  
  public void deleteColorNote()
  {
    Object localObject1 = this.mShareEntrance;
    if (localObject1 != null)
    {
      ((ShareEntrance)localObject1).c();
      localObject1 = this.mShareEntrance.a().getColorNote();
      if (localObject1 != null)
      {
        ((IColorNoteProcessState)QRoute.api(IColorNoteProcessState.class)).updateColorNoteSet(((ColorNote)localObject1).mServiceType, ((ColorNote)localObject1).mSubType, false);
        Object localObject2;
        if (this.mShowToast)
        {
          localObject2 = MobileQQ.getContext();
          QQToast.makeText((Context)localObject2, 2, ((Context)localObject2).getString(2131887835), 2000).show();
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("delete color note from share entrance: ");
          ((StringBuilder)localObject2).append(((ColorNote)localObject1).getServiceType());
          ((StringBuilder)localObject2).append(", ");
          ((StringBuilder)localObject2).append(((ColorNote)localObject1).mSubType);
          ((StringBuilder)localObject2).append(", ");
          ((StringBuilder)localObject2).append(((ColorNote)localObject1).mMainTitle);
          QLog.d("ColorNoteController", 2, ((StringBuilder)localObject2).toString());
        }
      }
    }
  }
  
  public boolean detectCacheFull(AppRuntime paramAppRuntime, int paramInt)
  {
    return ColorNoteHistoryManager.d(paramAppRuntime, paramInt);
  }
  
  public void disableAutoRecentNote()
  {
    this.mAutoRecentNote = false;
  }
  
  public void disablePostTable()
  {
    IColorNoteSwipeLayout localIColorNoteSwipeLayout = this.mSwipePostTableLayout;
    if (localIColorNoteSwipeLayout != null) {
      localIColorNoteSwipeLayout.disablePostTable();
    }
  }
  
  public void disableSwipe()
  {
    IColorNoteSwipeLayout localIColorNoteSwipeLayout = this.mSwipePostTableLayout;
    if (localIColorNoteSwipeLayout != null) {
      localIColorNoteSwipeLayout.disableSwipe();
    }
  }
  
  public void disableToast()
  {
    this.mShowToast = false;
  }
  
  public void doSetPropertiesFromWebView(String paramString)
  {
    int i = ColorNoteUtils.g(paramString);
    if (ColorNoteUtils.c(i)) {
      setShareEntr(false);
    } else {
      setShareEntr(true);
    }
    if (ColorNoteUtils.b(i))
    {
      disablePostTable();
      return;
    }
    enablePostTable();
  }
  
  public void enableAutoRecentNote()
  {
    this.mAutoRecentNote = true;
  }
  
  public void enablePostTable()
  {
    IColorNoteSwipeLayout localIColorNoteSwipeLayout = this.mSwipePostTableLayout;
    if (localIColorNoteSwipeLayout != null) {
      localIColorNoteSwipeLayout.enablePostTable();
    }
  }
  
  public void enableSwipe()
  {
    IColorNoteSwipeLayout localIColorNoteSwipeLayout = this.mSwipePostTableLayout;
    if (localIColorNoteSwipeLayout != null) {
      localIColorNoteSwipeLayout.enableSwipe();
    }
  }
  
  public void exitAnimation()
  {
    exitAnimation(false);
  }
  
  public IColorNoteSwipeLayout getSwipePostTableLayout()
  {
    return this.mSwipePostTableLayout;
  }
  
  public boolean hasShareEntr()
  {
    return this.hasShareEntr;
  }
  
  public void init(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    init(paramContext, paramBoolean1, paramBoolean2, null);
  }
  
  public void init(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, IColorNoteSwipeLayout paramIColorNoteSwipeLayout)
  {
    init(paramContext, paramBoolean1, paramBoolean2, paramIColorNoteSwipeLayout, false, false, 2131165829);
  }
  
  public void init(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, IColorNoteSwipeLayout paramIColorNoteSwipeLayout, boolean paramBoolean3, boolean paramBoolean4, int paramInt)
  {
    init(paramContext, paramBoolean1, paramBoolean2, paramIColorNoteSwipeLayout, paramBoolean3, false, paramBoolean4, paramInt);
  }
  
  public void init(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, IColorNoteSwipeLayout paramIColorNoteSwipeLayout, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt)
  {
    if (paramBoolean1)
    {
      if (paramIColorNoteSwipeLayout == null) {
        this.mSwipePostTableLayout = new SwipePostTableLayoutImpl(paramContext);
      } else {
        this.mSwipePostTableLayout = paramIColorNoteSwipeLayout;
      }
      if (paramBoolean3) {
        if ((SwipeLayoutUtils.a()) && ((!paramBoolean4) || (Build.VERSION.SDK_INT != 26)))
        {
          this.translucentConvertor = new TranslucentConvertor((Activity)paramContext, paramBoolean3 ^ true);
          this.translucentConvertor.a(this);
          this.mSwipePostTableLayout.setTranslucentConvertor(this.translucentConvertor);
          if (paramBoolean5)
          {
            this.mSwipePostTableLayout.setOnSwipeListener(this);
            this.mSwipePostTableLayout.setReadyToSlide(false);
          }
          else
          {
            ((View)this.mSwipePostTableLayout).post(new ColorNoteControllerImpl.2(this));
          }
        }
        else
        {
          this.mSwipePostTableLayout.setBackgroundResource(paramInt);
        }
      }
    }
    this.hasShareEntr = paramBoolean2;
    if ((paramBoolean2) && (!paramBoolean1)) {
      this.mColorNoteStateNotice = new ColorNoteStateNotice();
    }
    this.mShareEntrance = new ShareEntrance(paramContext);
    QRoute.api(IColorNoteProcessState.class);
  }
  
  public void init(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt)
  {
    init(paramContext, paramBoolean1, paramBoolean2, null, paramBoolean3, paramBoolean4, paramInt);
  }
  
  public void insertColorNote()
  {
    Object localObject = this.mShareEntrance;
    if (localObject != null)
    {
      ((ShareEntrance)localObject).b();
      localObject = this.mShareEntrance.a().getColorNote();
      if (localObject != null)
      {
        ((IColorNoteProcessState)QRoute.api(IColorNoteProcessState.class)).updateColorNoteSet(((ColorNote)localObject).mServiceType, ((ColorNote)localObject).mSubType, true);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("insert color note from share entrance: ");
          localStringBuilder.append(((ColorNote)localObject).getServiceType());
          localStringBuilder.append(", ");
          localStringBuilder.append(((ColorNote)localObject).mSubType);
          localStringBuilder.append(", ");
          localStringBuilder.append(((ColorNote)localObject).mMainTitle);
          QLog.d("ColorNoteController", 2, localStringBuilder.toString());
        }
      }
    }
  }
  
  public boolean isColorNoteExist()
  {
    ShareEntrance localShareEntrance = this.mShareEntrance;
    if (localShareEntrance != null) {
      return localShareEntrance.e();
    }
    return false;
  }
  
  public boolean isColorNoteExist(ColorNote paramColorNote)
  {
    if (paramColorNote == null) {
      return false;
    }
    ShareEntrance localShareEntrance = this.mShareEntrance;
    if (localShareEntrance != null) {
      return localShareEntrance.a(paramColorNote.getServiceType(), paramColorNote.getSubType());
    }
    return false;
  }
  
  public boolean isFirstCloseRecentNote()
  {
    return ColorNoteRecentView.a();
  }
  
  public boolean isSwipeBackExit()
  {
    IColorNoteSwipeLayout localIColorNoteSwipeLayout = this.mSwipePostTableLayout;
    if (localIColorNoteSwipeLayout != null) {
      return localIColorNoteSwipeLayout.getIsSwipeBacked();
    }
    return false;
  }
  
  public void onCannotAdd()
  {
    ShareEntrance localShareEntrance = this.mShareEntrance;
    if (localShareEntrance != null) {
      localShareEntrance.f();
    }
  }
  
  public void onDestroy()
  {
    Object localObject = this.mSwipePostTableLayout;
    if (localObject != null) {
      ((IColorNoteSwipeLayout)localObject).onDestroy();
    }
    localObject = this.mColorNoteStateNotice;
    if (localObject != null) {
      ((ColorNoteStateNotice)localObject).b(this.mAutoRecentNote);
    }
    ((IColorNoteProcessState)QRoute.api(IColorNoteProcessState.class)).unregisterBroadcast();
    this.mShareEntrance = null;
  }
  
  public ColorNote onGetColorNote(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, byte[] paramArrayOfByte)
  {
    return new ColorNote.Builder().a(paramInt).a(paramString1).b(paramString2).c(paramString3).d(paramString4).a(paramArrayOfByte).a();
  }
  
  public void onPause()
  {
    Object localObject = this.mSwipePostTableLayout;
    if (localObject != null) {
      ((IColorNoteSwipeLayout)localObject).onPause();
    }
    localObject = this.mColorNoteStateNotice;
    if (localObject != null) {
      ((ColorNoteStateNotice)localObject).b();
    }
  }
  
  public void onResume()
  {
    Object localObject = this.mSwipePostTableLayout;
    if (localObject != null) {
      ((IColorNoteSwipeLayout)localObject).onResume();
    }
    localObject = this.mColorNoteStateNotice;
    if (localObject != null) {
      ((ColorNoteStateNotice)localObject).a();
    }
  }
  
  public void onSwipe(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      TranslucentConvertor localTranslucentConvertor = this.translucentConvertor;
      if (localTranslucentConvertor != null) {
        localTranslucentConvertor.b();
      }
    }
  }
  
  public void onTranslucentConversionComplete(boolean paramBoolean)
  {
    IColorNoteSwipeLayout localIColorNoteSwipeLayout = this.mSwipePostTableLayout;
    if (localIColorNoteSwipeLayout != null) {
      localIColorNoteSwipeLayout.setReadyToSlide(true);
    }
    if (this.hasPendingExitAnim) {
      exitAnimation();
    }
  }
  
  public void refreshPostTable(Activity paramActivity)
  {
    IColorNoteSwipeLayout localIColorNoteSwipeLayout = this.mSwipePostTableLayout;
    if (localIColorNoteSwipeLayout != null) {
      localIColorNoteSwipeLayout.bringButtonToFront(paramActivity);
    }
  }
  
  public void registerBroadcast()
  {
    ((IColorNoteProcessState)QRoute.api(IColorNoteProcessState.class)).registerBroadcast();
  }
  
  public void setCustomNightMode(Context paramContext, boolean paramBoolean)
  {
    ColorNoteSmallScreenUtil.a(paramContext, 6, paramBoolean);
  }
  
  public void setFirstCloseRecentNote(AppRuntime paramAppRuntime)
  {
    ColorNoteRecentView.b(paramAppRuntime);
  }
  
  public void setLeftSwipeScope(int paramInt)
  {
    IColorNoteSwipeLayout localIColorNoteSwipeLayout = this.mSwipePostTableLayout;
    if (localIColorNoteSwipeLayout != null) {
      localIColorNoteSwipeLayout.setLeftScope(paramInt);
    }
  }
  
  public void setOnColorNoteAnimFinishListener(OnColorNoteAnimFinishListener paramOnColorNoteAnimFinishListener)
  {
    this.mOnColorNoteAnimFinishListener = paramOnColorNoteAnimFinishListener;
  }
  
  public void setOnColorNoteCurdListener(OnColorNoteCurdListener paramOnColorNoteCurdListener)
  {
    Object localObject = this.mSwipePostTableLayout;
    if (localObject != null) {
      ((IColorNoteSwipeLayout)localObject).setOnColorNoteCurdListener(paramOnColorNoteCurdListener);
    }
    localObject = this.mColorNoteStateNotice;
    if (localObject != null) {
      ((ColorNoteStateNotice)localObject).a(paramOnColorNoteCurdListener);
    }
    localObject = this.mShareEntrance;
    if (localObject != null) {
      ((ShareEntrance)localObject).a(paramOnColorNoteCurdListener);
    }
    ((IColorNoteProcessState)QRoute.api(IColorNoteProcessState.class)).setColorNoteCurdListener(paramOnColorNoteCurdListener);
  }
  
  public void setOnPageSwipeListener(OnPageSwipeListener paramOnPageSwipeListener)
  {
    IColorNoteSwipeLayout localIColorNoteSwipeLayout = this.mSwipePostTableLayout;
    if (localIColorNoteSwipeLayout != null) {
      localIColorNoteSwipeLayout.setOnPageSwipeListener(paramOnPageSwipeListener);
    }
  }
  
  public void setRecentlyViewedSwitch(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    ((IColorNoteProcessState)QRoute.api(IColorNoteProcessState.class)).setRecentColorNoteSwitch(paramAppRuntime, paramBoolean);
  }
  
  public void setServiceInfo(IServiceInfo paramIServiceInfo)
  {
    Object localObject = this.mSwipePostTableLayout;
    if (localObject != null) {
      ((IColorNoteSwipeLayout)localObject).setServiceInfo(paramIServiceInfo);
    }
    localObject = this.mColorNoteStateNotice;
    if (localObject != null) {
      ((ColorNoteStateNotice)localObject).a(paramIServiceInfo);
    }
    this.mShareEntrance.a(paramIServiceInfo);
  }
  
  public void setServiceSyncListener(IServiceSyncListener paramIServiceSyncListener)
  {
    ((IColorNoteProcessState)QRoute.api(IColorNoteProcessState.class)).setServiceSyncListener(paramIServiceSyncListener);
  }
  
  public void setShareEntr(boolean paramBoolean)
  {
    this.hasShareEntr = paramBoolean;
  }
  
  public void setSmallScreenShouldShow(boolean paramBoolean, int paramInt)
  {
    ColorNoteSmallScreenService.a(paramBoolean, paramInt);
  }
  
  public void setSwipePostTableLayout(IColorNoteSwipeLayout paramIColorNoteSwipeLayout)
  {
    this.mSwipePostTableLayout = paramIColorNoteSwipeLayout;
  }
  
  public boolean shouldDisplayColorNote()
  {
    return ((IColorNoteProcessState)QRoute.api(IColorNoteProcessState.class)).getSyncState();
  }
  
  public void unregisterBroadcast()
  {
    ((IColorNoteProcessState)QRoute.api(IColorNoteProcessState.class)).unregisterBroadcast();
  }
  
  public void updateColorNote(ColorNote paramColorNote)
  {
    if (paramColorNote == null) {
      return;
    }
    Object localObject = this.mShareEntrance;
    if (localObject != null)
    {
      ((ShareEntrance)localObject).a(paramColorNote);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("update color note from share entrance: ");
        ((StringBuilder)localObject).append(paramColorNote.getServiceType());
        ((StringBuilder)localObject).append(", ");
        ((StringBuilder)localObject).append(paramColorNote.mSubType);
        ((StringBuilder)localObject).append(", ");
        ((StringBuilder)localObject).append(paramColorNote.mMainTitle);
        QLog.d("ColorNoteController", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.api.impl.ColorNoteControllerImpl
 * JD-Core Version:    0.7.0.1
 */