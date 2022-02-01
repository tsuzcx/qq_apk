package com.tencent.mobileqq.richmediabrowser.view;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.IProvider;
import com.tencent.mobileqq.richmediabrowser.ImmersionHelper;
import com.tencent.mobileqq.richmediabrowser.ParamsManager;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOBrowserBasePresenter;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOBrowserPresenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.api.BrowserParamsBuilder;
import com.tencent.richmediabrowser.api.decorator.IDecoratorView;
import com.tencent.richmediabrowser.api.event.IBrowserItemAnimationEvent;
import com.tencent.richmediabrowser.api.event.IBrowserItemClickEvent;
import com.tencent.richmediabrowser.api.event.IBrowserItemScrollEvent;
import com.tencent.richmediabrowser.api.event.IDecoratorViewEvent;
import com.tencent.richmediabrowser.api.event.IPictureScaleEvent;
import com.tencent.richmediabrowser.core.IBaseViewBuilder;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import com.tencent.richmediabrowser.utils.ScreenUtils;
import com.tencent.richmediabrowser.view.BrowserBaseView;
import java.util.Iterator;
import java.util.List;

public class AIOBrowserBaseView
  implements IDecoratorView, IBrowserItemAnimationEvent, IBrowserItemClickEvent, IBrowserItemScrollEvent, IDecoratorViewEvent, IPictureScaleEvent
{
  public int a;
  public Context a;
  public ImageButton a;
  public RelativeLayout a;
  public AIOBrowserBasePresenter a;
  public ShareActionSheet a;
  public BrowserBaseView a;
  public int b;
  public ImageButton b;
  private int c;
  public ImageButton c;
  
  public AIOBrowserBaseView(Context paramContext, AIOBrowserBasePresenter paramAIOBrowserBasePresenter)
  {
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter = paramAIOBrowserBasePresenter;
  }
  
  private int a()
  {
    int j = ParamsManager.a().c();
    int i = 1;
    if (j != 1) {
      if (j != 2)
      {
        if (j != 3) {
          i = 0;
        } else {
          i = 4;
        }
      }
      else {
        i = 5;
      }
    }
    if (ParamsManager.a().d()) {
      i = 6;
    }
    return i;
  }
  
  private int a(int paramInt)
  {
    if (paramInt == 0) {
      return 1;
    }
    if (paramInt == 1) {
      return 2;
    }
    if ((paramInt != 1004) && (paramInt != 1008) && (paramInt != 1009) && (paramInt != 1010) && (paramInt != 1011) && (paramInt != 1020) && (paramInt != 1021) && (paramInt != 1022) && (paramInt != 1023) && (paramInt != 1024) && (paramInt != 1025) && (paramInt != 1036) && (paramInt != 10002) && (paramInt != 10003) && (paramInt != 10004)) {
      return 4;
    }
    return 3;
  }
  
  private int a(RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    int i = 2;
    if ((paramRichMediaBrowserInfo != null) && (paramRichMediaBrowserInfo.baseData != null)) {}
    switch (paramRichMediaBrowserInfo.baseData.getType())
    {
    default: 
      break;
    case 103: 
      return 5;
    case 101: 
      paramRichMediaBrowserInfo = (AIOVideoData)paramRichMediaBrowserInfo.baseData;
      if (paramRichMediaBrowserInfo.d == 0) {
        return 4;
      }
      if (paramRichMediaBrowserInfo.d == 1) {
        return 3;
      }
    case 100: 
      paramRichMediaBrowserInfo = (AIOPictureData)paramRichMediaBrowserInfo.baseData;
      if ((paramRichMediaBrowserInfo.jdField_b_of_type_Int == 1) && (paramRichMediaBrowserInfo.i)) {
        return 2;
      }
      return 1;
      i = 0;
    }
    return i;
  }
  
  public View a(View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, View paramView) {}
  
  public void a(long paramLong) {}
  
  public void a(Intent paramIntent)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getRecyclerView() != null))
    {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getRecyclerView().getWidth();
      this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getRecyclerView().getHeight();
      return;
    }
    this.jdField_a_of_type_Int = ScreenUtils.getScreenWidth(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_b_of_type_Int = ScreenUtils.getScreenHeight(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void a(IBaseViewBuilder paramIBaseViewBuilder)
  {
    if ((paramIBaseViewBuilder instanceof BrowserBaseView))
    {
      this.jdField_a_of_type_ComTencentRichmediabrowserViewBrowserBaseView = ((BrowserBaseView)paramIBaseViewBuilder);
      this.jdField_a_of_type_ComTencentRichmediabrowserViewBrowserBaseView.setDecoratorViewEvent(this);
      this.jdField_a_of_type_ComTencentRichmediabrowserViewBrowserBaseView.setBrowserItemClickListener(this);
      this.jdField_a_of_type_ComTencentRichmediabrowserViewBrowserBaseView.setBrowserItemScrollEventListener(this);
      this.jdField_a_of_type_ComTencentRichmediabrowserViewBrowserBaseView.setBrowserItemAnimationListener(this);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ImageButton localImageButton = this.jdField_a_of_type_AndroidWidgetImageButton;
    if (localImageButton != null)
    {
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      localImageButton.setVisibility(i);
    }
  }
  
  public boolean a()
  {
    ImageButton localImageButton = this.jdField_a_of_type_AndroidWidgetImageButton;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localImageButton != null)
    {
      bool1 = bool2;
      if (localImageButton.getVisibility() == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean a(RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    return this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter.a(paramRichMediaBrowserInfo);
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
    if (localObject != null)
    {
      ((ShareActionSheet)localObject).setItemClickListener(null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter;
    if (localObject != null) {
      ((AIOBrowserBasePresenter)localObject).a().b();
    }
    localObject = this.jdField_a_of_type_ComTencentRichmediabrowserViewBrowserBaseView;
    if (localObject != null) {
      ((BrowserBaseView)localObject).onDestroy();
    }
  }
  
  public void b(int paramInt)
  {
    if (!ParamsManager.a().c()) {
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter.a())
      {
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.a != null) {
          this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.a.notifyImageModelDataChanged();
        }
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter != null)
      {
        int i = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getCount();
        if (ParamsManager.a().f()) {
          if ((i - paramInt <= 0) || (paramInt <= i - 25)) {}
        }
        for (;;)
        {
          paramInt = 1;
          break;
          do
          {
            paramInt = 0;
            break;
          } while (paramInt >= 25);
        }
        if ((i != 1) && (paramInt != 0) && (this.jdField_c_of_type_Int != i) && (!ParamsManager.a().a()))
        {
          localObject = BrowserLogHelper.getInstance().getGalleryLog();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onItemSelected loadMedias: mLastLoadCount=");
          localStringBuilder.append(this.jdField_c_of_type_Int);
          ((IBrowserLog)localObject).d("AIOBrowserBaseView", 4, localStringBuilder.toString());
          this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getCount();
          if ((this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null) && ((this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.getParamsBuilder().a() instanceof IProvider))) {
            ((IProvider)this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.getParamsBuilder().a()).a(0);
          }
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter.a().a = false;
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter.a().d();
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter.g();
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter.h();
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter.a().b();
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter.a().a();
    Object localObject = this.jdField_a_of_type_ComTencentRichmediabrowserViewBrowserBaseView;
    if ((localObject != null) && (!((BrowserBaseView)localObject).isInExitAnim)) {
      a(true);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (localRelativeLayout != null)
    {
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      localRelativeLayout.setVisibility(i);
    }
  }
  
  public boolean b()
  {
    return (!ParamsManager.a().d()) && (UinTypeUtil.a(ParamsManager.a().a()) != 1044) && (UinTypeUtil.a(ParamsManager.a().a()) != 1032) && (ParamsManager.a().c() != 3) && (ParamsManager.a().c() != 4) && (ParamsManager.a().c() != 6) && (ParamsManager.a().h());
  }
  
  public void c()
  {
    ShareActionSheet localShareActionSheet = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
    if (localShareActionSheet != null) {
      localShareActionSheet.dismiss();
    }
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet == null)
    {
      localObject = new ShareActionSheetV2.Param();
      ((ShareActionSheetV2.Param)localObject).context = this.jdField_a_of_type_AndroidContentContext;
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet = ShareActionSheetFactory.create((ShareActionSheetV2.Param)localObject);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
    int j = 0;
    ((ShareActionSheet)localObject).setRowVisibility(0, 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setOnDismissListener(new AIOBrowserBaseView.1(this));
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter == null) {
      return;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getSelectedItem();
    int k = a((RichMediaBrowserInfo)localObject);
    int i;
    if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null)) {
      i = ((AIOBrowserBaseData)((RichMediaBrowserInfo)localObject).baseData).jdField_b_of_type_Int;
    } else {
      i = 0;
    }
    int m = a(i);
    int n = a();
    if (paramInt == 2)
    {
      i = 1;
    }
    else
    {
      i = j;
      if (paramInt == 1) {
        i = 2;
      }
    }
    ReportController.b(null, "dc00898", "", "", "0X8009EFB", "0X8009EFB", k, 0, String.valueOf(m), String.valueOf(n), String.valueOf(i), "");
  }
  
  public void c(boolean paramBoolean)
  {
    ImageButton localImageButton = this.jdField_b_of_type_AndroidWidgetImageButton;
    if (localImageButton != null)
    {
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      localImageButton.setVisibility(i);
    }
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter == null) {
      return;
    }
    int i;
    if (ParamsManager.a().c() == 2) {
      i = 1;
    } else {
      i = 0;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getSelectedItem();
    ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).gotoChatHistoryActivity(this.jdField_a_of_type_AndroidContentContext, ParamsManager.a().c(), ParamsManager.a().a(), ((RichMediaBrowserInfo)localObject).baseData);
    localObject = this.jdField_a_of_type_AndroidContentContext;
    if ((localObject instanceof Activity))
    {
      localObject = (Activity)localObject;
      ((Activity)localObject).getIntent().putExtra("extra.IS_STARTING_CHAT_FILE_HISTORY", true);
      ((Activity)localObject).overridePendingTransition(2130772374, 2130772373);
      if (i == 0) {
        ((Activity)localObject).finish();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.e();
  }
  
  public void d(boolean paramBoolean)
  {
    ImageButton localImageButton = this.jdField_c_of_type_AndroidWidgetImageButton;
    if (localImageButton != null)
    {
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      localImageButton.setVisibility(i);
    }
  }
  
  protected void e()
  {
    ReportController.b(null, "CliOper", "", "", "View_pic", "View_pic_menu", 0, 0, "1", "", "", "");
    c(2);
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter.a().c();
  }
  
  public void f()
  {
    ImmersionHelper localImmersionHelper = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter.a();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doQuitImmersion, basePresenter.isActionSheetVisibleBeforeImm = ");
      localStringBuilder.append(localImmersionHelper.b);
      localStringBuilder.append(" , basePresenter.isActionSheetVisibleBeforeImm , basePresenter.isDanmakuVisibleBeforeImm = ");
      localStringBuilder.append(localImmersionHelper.c);
      QLog.d("AIOBrowserBaseView", 2, localStringBuilder.toString());
    }
    if (localImmersionHelper.b) {
      a(true);
    }
    if (localImmersionHelper.c) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter.b(true);
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter.a().d();
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter.g();
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter.h();
    f(true);
    b(true);
  }
  
  public void f(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.showContentView(paramBoolean);
    }
    if (paramBoolean) {
      g();
    }
  }
  
  public void g() {}
  
  public Rect getAnimationEndDstRect()
  {
    return null;
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter.a().b();
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter.a().a = false;
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter.a().a();
  }
  
  public void i()
  {
    f();
    h();
  }
  
  public boolean needEnterRectAnimation()
  {
    return !((IBrowserDepend)QRoute.api(IBrowserDepend.class)).isSoftInputPanel(ParamsManager.a().d());
  }
  
  public boolean needExitRectAnimation()
  {
    if (((ParamsManager.a().d() == -3321) || (((IBrowserDepend)QRoute.api(IBrowserDepend.class)).isSoftInputPanel(ParamsManager.a().d()))) && (!ParamsManager.a().f())) {
      return false;
    }
    int i = ParamsManager.a().e();
    int j = -2147483648;
    if (i == -2147483648) {
      return false;
    }
    Iterator localIterator = ((ActivityManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
    do
    {
      i = j;
      if (!localIterator.hasNext()) {
        break;
      }
      localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
    } while (!localRunningAppProcessInfo.processName.endsWith("mobileqq"));
    i = localRunningAppProcessInfo.pid;
    return i == ParamsManager.a().e();
  }
  
  public void onClickEvent()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter.d();
  }
  
  public void onDoubleTap(int paramInt) {}
  
  public void onEnterAnimationEnd()
  {
    a(true);
    if (ParamsManager.a().c() == 4) {
      a(false);
    }
  }
  
  public void onEnterAnimationStart()
  {
    a(false);
  }
  
  public void onExitAnimationEnd() {}
  
  public void onExitAnimationStart()
  {
    a(false);
    f(false);
  }
  
  public void onLongClickEvent()
  {
    ReportController.b(null, "CliOper", "", "", "View_pic", "View_pic_menu", 0, 0, "0", "", "", "");
    if (ParamsManager.a().c() == 4) {
      return;
    }
    try
    {
      c(1);
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOBrowserBaseView", 2, "onItemLongClick, showActionSheet");
      return;
    }
    catch (Throwable localThrowable)
    {
      IBrowserLog localIBrowserLog = BrowserLogHelper.getInstance().getGalleryLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onItemLongClick showActionSheet exception: ");
      localStringBuilder.append(localThrowable.getMessage());
      localIBrowserLog.d("AIOBrowserBaseView", 1, localStringBuilder.toString());
    }
  }
  
  public void onScale(int paramInt) {}
  
  public void onScaleBegin(int paramInt) {}
  
  public void onScaleEnd(int paramInt) {}
  
  public void onScrollEnd()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter != null)
    {
      AIOBrowserBasePresenter localAIOBrowserBasePresenter = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter;
      if (localAIOBrowserBasePresenter.a(localAIOBrowserBasePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getCurrentPosition())) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter.a();
      }
    }
    b(true);
  }
  
  public void onScrollHalfScreenWidth() {}
  
  public void onScrollStart()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter != null)
    {
      AIOBrowserBasePresenter localAIOBrowserBasePresenter = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter;
      if (localAIOBrowserBasePresenter.a(localAIOBrowserBasePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getCurrentPosition())) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter.a(false);
      }
    }
    b(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOBrowserBaseView
 * JD-Core Version:    0.7.0.1
 */