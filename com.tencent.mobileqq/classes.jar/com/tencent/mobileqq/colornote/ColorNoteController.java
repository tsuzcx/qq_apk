package com.tencent.mobileqq.colornote;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.v4.util.SparseArrayCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ReportUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.colornote.anim.EnterExitAnimHelper;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNote.Builder;
import com.tencent.mobileqq.colornote.data.ColorNoteUtils;
import com.tencent.mobileqq.colornote.ipc.ColorNoteQIPCModule;
import com.tencent.mobileqq.colornote.launcher.BoodoLauncher;
import com.tencent.mobileqq.colornote.launcher.ILauncher;
import com.tencent.mobileqq.colornote.launcher.MiniAppLauncher;
import com.tencent.mobileqq.colornote.launcher.MusicLauncher;
import com.tencent.mobileqq.colornote.launcher.QFavLauncher;
import com.tencent.mobileqq.colornote.launcher.QFileColorNoteLauncher;
import com.tencent.mobileqq.colornote.launcher.QZoneLauncher;
import com.tencent.mobileqq.colornote.launcher.ReadInJoyLauncher;
import com.tencent.mobileqq.colornote.launcher.ReaderLauncher;
import com.tencent.mobileqq.colornote.launcher.SubscribeColorNoteLauncher;
import com.tencent.mobileqq.colornote.launcher.UpcomingLauncher;
import com.tencent.mobileqq.colornote.launcher.WebLauncher;
import com.tencent.mobileqq.colornote.list.DefaultItemBuilder;
import com.tencent.mobileqq.colornote.list.ItemBuilder;
import com.tencent.mobileqq.colornote.list.ReaderItemBuilder;
import com.tencent.mobileqq.colornote.settings.ColorNoteHistoryManager;
import com.tencent.mobileqq.colornote.share.ColorNoteStateNotice;
import com.tencent.mobileqq.colornote.share.ShareEntrance;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenService;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenUtil;
import com.tencent.mobileqq.colornote.smallscreen.IServiceSyncListener;
import com.tencent.mobileqq.colornote.swipeback.OnColorNoteAnimFinishListener;
import com.tencent.mobileqq.colornote.swipeback.SwipeBackLayout.OnSwipeListener;
import com.tencent.mobileqq.colornote.swipeback.SwipeLayoutUtils;
import com.tencent.mobileqq.colornote.swipeback.SwipePostTableLayout;
import com.tencent.mobileqq.colornote.swipeback.SwipePostTableLayout.OnPageSwipeListener;
import com.tencent.mobileqq.colornote.swipeback.TranslucentConvertor;
import com.tencent.mobileqq.colornote.swipeback.TranslucentConvertor.OnTranslucentConversionListener;
import com.tencent.mobileqq.intervideo.audioroom.colornote.QQVoiceLauncher;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class ColorNoteController
  implements SwipeBackLayout.OnSwipeListener, TranslucentConvertor.OnTranslucentConversionListener
{
  private static SparseArrayCompat<ItemBuilder> jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat;
  private EnterExitAnimHelper jdField_a_of_type_ComTencentMobileqqColornoteAnimEnterExitAnimHelper;
  private ColorNoteStateNotice jdField_a_of_type_ComTencentMobileqqColornoteShareColorNoteStateNotice;
  private ShareEntrance jdField_a_of_type_ComTencentMobileqqColornoteShareShareEntrance;
  private OnColorNoteAnimFinishListener jdField_a_of_type_ComTencentMobileqqColornoteSwipebackOnColorNoteAnimFinishListener;
  private SwipePostTableLayout jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout;
  private TranslucentConvertor jdField_a_of_type_ComTencentMobileqqColornoteSwipebackTranslucentConvertor;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ColorNoteController.1(this);
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b;
  private boolean c = true;
  private boolean d = false;
  
  public ColorNoteController(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramContext, paramBoolean1, paramBoolean2, null);
  }
  
  public ColorNoteController(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, SwipePostTableLayout paramSwipePostTableLayout)
  {
    this(paramContext, paramBoolean1, paramBoolean2, paramSwipePostTableLayout, false, false, 2131165528);
  }
  
  public ColorNoteController(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, SwipePostTableLayout paramSwipePostTableLayout, boolean paramBoolean3, boolean paramBoolean4, @DrawableRes int paramInt)
  {
    this(paramContext, paramBoolean1, paramBoolean2, paramSwipePostTableLayout, paramBoolean3, false, paramBoolean4, paramInt);
  }
  
  public ColorNoteController(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, SwipePostTableLayout paramSwipePostTableLayout, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, @DrawableRes int paramInt)
  {
    if (paramBoolean1)
    {
      if (paramSwipePostTableLayout != null) {
        break label129;
      }
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout = new SwipePostTableLayout(paramContext);
      if (paramBoolean3)
      {
        if ((SwipeLayoutUtils.a()) && ((!paramBoolean4) || (Build.VERSION.SDK_INT != 26))) {
          break label138;
        }
        this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setBackgroundResource(paramInt);
      }
    }
    for (;;)
    {
      this.c = paramBoolean2;
      if ((paramBoolean2) && (!paramBoolean1)) {
        this.jdField_a_of_type_ComTencentMobileqqColornoteShareColorNoteStateNotice = new ColorNoteStateNotice();
      }
      this.jdField_a_of_type_ComTencentMobileqqColornoteShareShareEntrance = new ShareEntrance(paramContext);
      ColorNoteQIPCModule.a();
      return;
      label129:
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout = paramSwipePostTableLayout;
      break;
      label138:
      paramSwipePostTableLayout = (Activity)paramContext;
      if (!paramBoolean3) {}
      for (paramBoolean3 = bool;; paramBoolean3 = false)
      {
        this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackTranslucentConvertor = new TranslucentConvertor(paramSwipePostTableLayout, paramBoolean3);
        this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackTranslucentConvertor.a(this);
        this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setTranslucentConvertor(this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackTranslucentConvertor);
        if (!paramBoolean5) {
          break label217;
        }
        this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setOnSwipeListener(this);
        this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setReadyToSlide(false);
        break;
      }
      label217:
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.post(new ColorNoteController.2(this));
    }
  }
  
  public ColorNoteController(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, @DrawableRes int paramInt)
  {
    this(paramContext, paramBoolean1, paramBoolean2, null, paramBoolean3, paramBoolean4, paramInt);
  }
  
  public static ItemBuilder a(ColorNote paramColorNote)
  {
    if (jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat == null) {
      q();
    }
    ItemBuilder localItemBuilder = (ItemBuilder)jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramColorNote.getServiceType());
    paramColorNote = localItemBuilder;
    if (localItemBuilder == null) {
      paramColorNote = (ItemBuilder)jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(65536);
    }
    return paramColorNote;
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    ColorNoteSmallScreenUtil.a(paramContext, 6, paramBoolean);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    ColorNoteQIPCModule.a().a(paramQQAppInterface, paramBoolean);
  }
  
  public static void a(boolean paramBoolean, int paramInt)
  {
    ColorNoteSmallScreenService.a(paramBoolean, paramInt);
  }
  
  public static boolean a(Context paramContext, ColorNote paramColorNote)
  {
    return a(paramContext, paramColorNote, null);
  }
  
  public static boolean a(Context paramContext, ColorNote paramColorNote, Bundle paramBundle)
  {
    boolean bool = false;
    Object localObject;
    switch (ColorNoteUtils.a(paramColorNote.getServiceType()))
    {
    default: 
      paramBundle = null;
      if (paramBundle != null)
      {
        if (!ColorNoteUtils.b(paramColorNote)) {
          break label359;
        }
        localObject = ReportUtil.a(paramColorNote);
        ReportController.b(null, "dc00898", "", "", "0X800A8AB", "0X800A8AB", ColorNoteConstants.b(ColorNoteUtils.a(paramColorNote.getServiceType())), 0, "", "", "", (String)localObject);
      }
      break;
    }
    for (;;)
    {
      localObject = paramColorNote;
      if (ColorNoteUtils.b(paramColorNote)) {
        localObject = ColorNoteUtils.b(paramColorNote);
      }
      paramBundle.launch(paramContext, (ColorNote)localObject);
      bool = true;
      return bool;
      paramBundle = new WebLauncher(paramBundle);
      break;
      localObject = paramBundle;
      if (paramBundle == null) {
        localObject = new Bundle();
      }
      ((Bundle)localObject).putBoolean("recent_note", ColorNoteUtils.b(paramColorNote));
      paramBundle = new ReaderLauncher((Bundle)localObject);
      break;
      paramBundle = new QFileColorNoteLauncher();
      break;
      paramBundle = new MiniAppLauncher();
      break;
      paramBundle = new MusicLauncher();
      break;
      paramBundle = new ReadInJoyLauncher();
      break;
      paramBundle = new BoodoLauncher();
      break;
      paramBundle = new QFavLauncher();
      break;
      paramBundle = new SubscribeColorNoteLauncher();
      break;
      paramBundle = new QZoneLauncher();
      break;
      paramBundle = new UpcomingLauncher();
      break;
      paramBundle = new QQVoiceLauncher();
      break;
      label359:
      ReportController.b(null, "dc00898", "", "", "0X800A749", "0X800A749", ColorNoteConstants.a(paramColorNote.getServiceType()), 0, "", "", "", "");
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    return ColorNoteQIPCModule.a().a();
  }
  
  public static void c(boolean paramBoolean)
  {
    ColorNoteQIPCModule.a().a(paramBoolean);
  }
  
  private void e(boolean paramBoolean)
  {
    boolean bool = true;
    int i = 0;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteAnimEnterExitAnimHelper != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
      localObject = ColorNoteQIPCModule.a().a();
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentMobileqqColornoteAnimEnterExitAnimHelper.a(((Point)localObject).x, ((Point)localObject).y);
      }
      if ((!c()) && ((this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout == null) || (!this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.f))) {
        break label245;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackTranslucentConvertor == null) || (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackTranslucentConvertor.a())) {
        break label152;
      }
      if (!paramBoolean) {
        break label117;
      }
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackOnColorNoteAnimFinishListener.onColorNoteAnimFinish();
    }
    label117:
    do
    {
      return;
      this.b = true;
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackTranslucentConvertor.a();
    } while (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout == null);
    this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
    return;
    label152:
    this.b = false;
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteShareShareEntrance != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqColornoteShareShareEntrance.a();
      if (localObject != null)
      {
        localObject = ((IServiceInfo)localObject).getColorNote();
        if ((localObject == null) || (((ColorNote)localObject).mServiceType != 16842752)) {}
      }
    }
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqColornoteAnimEnterExitAnimHelper;
      OnColorNoteAnimFinishListener localOnColorNoteAnimFinishListener = this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackOnColorNoteAnimFinishListener;
      if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout == null) {}
      for (;;)
      {
        ((EnterExitAnimHelper)localObject).a(localOnColorNoteAnimFinishListener, paramBoolean, i);
        return;
        i = this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.getScrollX();
      }
      label245:
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackOnColorNoteAnimFinishListener.onColorNoteAnimFinish();
      return;
    }
  }
  
  private static void q()
  {
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat();
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(65536, new DefaultItemBuilder());
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(16908289, new ReaderItemBuilder());
  }
  
  public ColorNote a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, byte[] paramArrayOfByte)
  {
    return new ColorNote.Builder().a(paramInt).a(paramString1).b(paramString2).c(paramString3).d(paramString4).a(paramArrayOfByte).a();
  }
  
  public SwipePostTableLayout a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteShareColorNoteStateNotice != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteShareColorNoteStateNotice.a();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setLeftScope(paramInt);
    }
  }
  
  public void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.a(paramActivity);
    }
    paramActivity = (ViewGroup)paramActivity.getWindow().getDecorView();
    View localView1 = paramActivity.getChildAt(0);
    View localView2 = paramActivity.findViewById(16908290);
    paramActivity = localView2;
    if (localView2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ColorNoteController", 2, "can not find content view");
      }
      paramActivity = localView1;
    }
    this.jdField_a_of_type_ComTencentMobileqqColornoteShareShareEntrance.a(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqColornoteAnimEnterExitAnimHelper = new EnterExitAnimHelper(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqColornoteAnimEnterExitAnimHelper.a();
    ColorNoteQIPCModule.a().a();
  }
  
  public void a(ColorNoteCurd.OnColorNoteCurdListener paramOnColorNoteCurdListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setOnColorNoteCurdListener(paramOnColorNoteCurdListener);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteShareColorNoteStateNotice != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteShareColorNoteStateNotice.a(paramOnColorNoteCurdListener);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteShareShareEntrance != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteShareShareEntrance.a(paramOnColorNoteCurdListener);
    }
    ColorNoteQIPCModule.a().a(paramOnColorNoteCurdListener);
  }
  
  public void a(IServiceInfo paramIServiceInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setServiceInfo(paramIServiceInfo);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteShareColorNoteStateNotice != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteShareColorNoteStateNotice.a(paramIServiceInfo);
    }
    this.jdField_a_of_type_ComTencentMobileqqColornoteShareShareEntrance.a(paramIServiceInfo);
  }
  
  public void a(ColorNote paramColorNote)
  {
    if (paramColorNote == null) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqColornoteShareShareEntrance == null);
      this.jdField_a_of_type_ComTencentMobileqqColornoteShareShareEntrance.a(paramColorNote);
    } while (!QLog.isColorLevel());
    QLog.d("ColorNoteController", 2, "update color note from share entrance: " + paramColorNote.getServiceType() + ", " + paramColorNote.mSubType + ", " + paramColorNote.mMainTitle);
  }
  
  public void a(IServiceSyncListener paramIServiceSyncListener)
  {
    ColorNoteQIPCModule.a().a(paramIServiceSyncListener);
  }
  
  public void a(OnColorNoteAnimFinishListener paramOnColorNoteAnimFinishListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackOnColorNoteAnimFinishListener = paramOnColorNoteAnimFinishListener;
  }
  
  public void a(SwipePostTableLayout.OnPageSwipeListener paramOnPageSwipeListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setOnPageSwipeListener(paramOnPageSwipeListener);
    }
  }
  
  public void a(String paramString)
  {
    int i = ColorNoteUtils.a(paramString);
    if (ColorNoteUtils.b(i)) {
      d(false);
    }
    while (ColorNoteUtils.a(i))
    {
      g();
      return;
      d(true);
    }
    h();
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackTranslucentConvertor != null)) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackTranslucentConvertor.a();
    }
  }
  
  public boolean a()
  {
    return ColorNoteQIPCModule.a().b();
  }
  
  public boolean a(ColorNote paramColorNote)
  {
    if (paramColorNote == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqColornoteShareShareEntrance == null) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentMobileqqColornoteShareShareEntrance.a(paramColorNote.getServiceType(), paramColorNote.getSubType());
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteShareColorNoteStateNotice != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteShareColorNoteStateNotice.b();
    }
  }
  
  public void b(Activity paramActivity)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.b(paramActivity);
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteShareShareEntrance != null) {
      return this.jdField_a_of_type_ComTencentMobileqqColornoteShareShareEntrance.a();
    }
    return false;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteShareColorNoteStateNotice != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteShareColorNoteStateNotice.b(this.d);
    }
    ColorNoteQIPCModule.a().b();
    this.jdField_a_of_type_ComTencentMobileqqColornoteShareShareEntrance = null;
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteShareShareEntrance != null) {
      return this.jdField_a_of_type_ComTencentMobileqqColornoteShareShareEntrance.b();
    }
    return false;
  }
  
  public void d()
  {
    e(false);
  }
  
  public void d(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public boolean d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      return this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.e;
    }
    return false;
  }
  
  public void d_(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.setReadyToSlide(true);
    }
    if (this.b) {
      d();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteShareShareEntrance != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqColornoteShareShareEntrance.a();
      ColorNote localColorNote = this.jdField_a_of_type_ComTencentMobileqqColornoteShareShareEntrance.a().getColorNote();
      if (localColorNote != null)
      {
        ColorNoteQIPCModule.a().a(localColorNote.mServiceType, localColorNote.mSubType, true);
        if (QLog.isColorLevel()) {
          QLog.d("ColorNoteController", 2, "insert color note from share entrance: " + localColorNote.getServiceType() + ", " + localColorNote.mSubType + ", " + localColorNote.mMainTitle);
        }
      }
    }
  }
  
  public boolean e()
  {
    return this.c;
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteShareShareEntrance != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqColornoteShareShareEntrance.b();
      ColorNote localColorNote = this.jdField_a_of_type_ComTencentMobileqqColornoteShareShareEntrance.a().getColorNote();
      if (localColorNote != null)
      {
        ColorNoteQIPCModule.a().a(localColorNote.mServiceType, localColorNote.mSubType, false);
        if (this.jdField_a_of_type_Boolean)
        {
          BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
          QQToast.a(localBaseApplication, 2, localBaseApplication.getString(2131690976), 2000).a();
        }
        if (QLog.isColorLevel()) {
          QLog.d("ColorNoteController", 2, "delete color note from share entrance: " + localColorNote.getServiceType() + ", " + localColorNote.mSubType + ", " + localColorNote.mMainTitle);
        }
      }
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.j();
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.k();
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteShareShareEntrance != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteShareShareEntrance.c();
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.e();
    }
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.f();
    }
  }
  
  public void l()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void m()
  {
    ColorNoteQIPCModule.a().a();
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout.i();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteShareColorNoteStateNotice != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqColornoteShareColorNoteStateNotice.c();
      return;
    }
    QLog.d("ColorNoteController", 1, "[addToRecentNote] mColorNoteStateNotice is null.");
  }
  
  public void o()
  {
    this.d = false;
  }
  
  public void p()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteShareShareEntrance != null) {
      ColorNoteHistoryManager.a(this.jdField_a_of_type_ComTencentMobileqqColornoteShareShareEntrance.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.ColorNoteController
 * JD-Core Version:    0.7.0.1
 */