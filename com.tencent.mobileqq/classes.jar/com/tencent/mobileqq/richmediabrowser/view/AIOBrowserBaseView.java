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
  public AIOBrowserBasePresenter a;
  public ShareActionSheet b;
  public Context c;
  public ImageButton d;
  public ImageButton e;
  public ImageButton f;
  public RelativeLayout g;
  public BrowserBaseView h;
  public int i;
  public int j;
  private int k = 0;
  
  public AIOBrowserBaseView(Context paramContext, AIOBrowserBasePresenter paramAIOBrowserBasePresenter)
  {
    this.c = paramContext;
    this.a = paramAIOBrowserBasePresenter;
  }
  
  private int b(RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    int m = 2;
    if ((paramRichMediaBrowserInfo != null) && (paramRichMediaBrowserInfo.baseData != null)) {}
    switch (paramRichMediaBrowserInfo.baseData.getType())
    {
    default: 
      break;
    case 103: 
      return 5;
    case 101: 
      paramRichMediaBrowserInfo = (AIOVideoData)paramRichMediaBrowserInfo.baseData;
      if (paramRichMediaBrowserInfo.m == 0) {
        return 4;
      }
      if (paramRichMediaBrowserInfo.m == 1) {
        return 3;
      }
    case 100: 
      paramRichMediaBrowserInfo = (AIOPictureData)paramRichMediaBrowserInfo.baseData;
      if ((paramRichMediaBrowserInfo.f == 1) && (paramRichMediaBrowserInfo.A)) {
        return 2;
      }
      return 1;
      m = 0;
    }
    return m;
  }
  
  private int d(int paramInt)
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
  
  private int l()
  {
    int n = ParamsManager.a().o();
    int m = 1;
    if (n != 1) {
      if (n != 2)
      {
        if (n != 3) {
          m = 0;
        } else {
          m = 4;
        }
      }
      else {
        m = 5;
      }
    }
    if (ParamsManager.a().g()) {
      m = 6;
    }
    return m;
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
    if ((this.a.c != null) && (this.a.c.getRecyclerView() != null))
    {
      this.i = this.a.c.getRecyclerView().getWidth();
      this.j = this.a.c.getRecyclerView().getHeight();
      return;
    }
    this.i = ScreenUtils.getScreenWidth(this.c);
    this.j = ScreenUtils.getScreenHeight(this.c);
  }
  
  public void a(IBaseViewBuilder paramIBaseViewBuilder)
  {
    if ((paramIBaseViewBuilder instanceof BrowserBaseView))
    {
      this.h = ((BrowserBaseView)paramIBaseViewBuilder);
      this.h.setDecoratorViewEvent(this);
      this.h.setBrowserItemClickListener(this);
      this.h.setBrowserItemScrollEventListener(this);
      this.h.setBrowserItemAnimationListener(this);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ImageButton localImageButton = this.d;
    if (localImageButton != null)
    {
      int m;
      if (paramBoolean) {
        m = 0;
      } else {
        m = 8;
      }
      localImageButton.setVisibility(m);
    }
  }
  
  public boolean a(RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    return this.a.a(paramRichMediaBrowserInfo);
  }
  
  public void b(int paramInt)
  {
    if (!ParamsManager.a().d()) {
      if (this.a.a())
      {
        if (this.a.a.a != null) {
          this.a.a.a.notifyImageModelDataChanged();
        }
      }
      else if (this.a.c != null)
      {
        int m = this.a.c.getCount();
        if (ParamsManager.a().n()) {
          if ((m - paramInt <= 0) || (paramInt <= m - 25)) {}
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
        if ((m != 1) && (paramInt != 0) && (this.k != m) && (!ParamsManager.a().b()))
        {
          localObject = BrowserLogHelper.getInstance().getGalleryLog();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onItemSelected loadMedias: mLastLoadCount=");
          localStringBuilder.append(this.k);
          ((IBrowserLog)localObject).d("AIOBrowserBaseView", 4, localStringBuilder.toString());
          this.k = this.a.c.getCount();
          if ((this.a.a != null) && ((this.a.a.getParamsBuilder().a() instanceof IProvider))) {
            ((IProvider)this.a.a.getParamsBuilder().a()).a(0);
          }
        }
      }
    }
    this.a.g().a = false;
    this.a.g().d();
    this.a.m();
    this.a.n();
    this.a.g().b();
    this.a.g().a();
    Object localObject = this.h;
    if ((localObject != null) && (!((BrowserBaseView)localObject).isInExitAnim)) {
      a(true);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = this.g;
    if (localRelativeLayout != null)
    {
      int m;
      if (paramBoolean) {
        m = 0;
      } else {
        m = 8;
      }
      localRelativeLayout.setVisibility(m);
    }
  }
  
  public boolean b()
  {
    ImageButton localImageButton = this.d;
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
  
  public void c()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      ((ShareActionSheet)localObject).setItemClickListener(null);
      this.b.dismiss();
    }
    localObject = this.a;
    if (localObject != null) {
      ((AIOBrowserBasePresenter)localObject).g().b();
    }
    localObject = this.h;
    if (localObject != null) {
      ((BrowserBaseView)localObject).onDestroy();
    }
  }
  
  public void c(int paramInt)
  {
    if (this.b == null)
    {
      localObject = new ShareActionSheetV2.Param();
      ((ShareActionSheetV2.Param)localObject).context = this.c;
      this.b = ShareActionSheetFactory.create((ShareActionSheetV2.Param)localObject);
    }
    Object localObject = this.b;
    int n = 0;
    ((ShareActionSheet)localObject).setRowVisibility(0, 0, 0);
    this.b.setOnDismissListener(new AIOBrowserBaseView.1(this));
    if (this.a.c == null) {
      return;
    }
    localObject = this.a.c.getSelectedItem();
    int i1 = b((RichMediaBrowserInfo)localObject);
    int m;
    if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null)) {
      m = ((AIOBrowserBaseData)((RichMediaBrowserInfo)localObject).baseData).f;
    } else {
      m = 0;
    }
    int i2 = d(m);
    int i3 = l();
    if (paramInt == 2)
    {
      m = 1;
    }
    else
    {
      m = n;
      if (paramInt == 1) {
        m = 2;
      }
    }
    ReportController.b(null, "dc00898", "", "", "0X8009EFB", "0X8009EFB", i1, 0, String.valueOf(i2), String.valueOf(i3), String.valueOf(m), "");
  }
  
  public void c(boolean paramBoolean)
  {
    ImageButton localImageButton = this.e;
    if (localImageButton != null)
    {
      int m;
      if (paramBoolean) {
        m = 0;
      } else {
        m = 8;
      }
      localImageButton.setVisibility(m);
    }
  }
  
  public void d()
  {
    ShareActionSheet localShareActionSheet = this.b;
    if (localShareActionSheet != null) {
      localShareActionSheet.dismiss();
    }
  }
  
  public void d(boolean paramBoolean)
  {
    ImageButton localImageButton = this.f;
    if (localImageButton != null)
    {
      int m;
      if (paramBoolean) {
        m = 0;
      } else {
        m = 8;
      }
      localImageButton.setVisibility(m);
    }
  }
  
  protected void e()
  {
    if (this.a.c == null) {
      return;
    }
    int m;
    if (ParamsManager.a().o() == 2) {
      m = 1;
    } else {
      m = 0;
    }
    Object localObject = this.a.c.getSelectedItem();
    ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).gotoChatHistoryActivity(this.c, ParamsManager.a().j(), ParamsManager.a().i(), ((RichMediaBrowserInfo)localObject).baseData);
    localObject = this.c;
    if ((localObject instanceof Activity))
    {
      localObject = (Activity)localObject;
      ((Activity)localObject).getIntent().putExtra("extra.IS_STARTING_CHAT_FILE_HISTORY", true);
      ((Activity)localObject).overridePendingTransition(2130772470, 2130772469);
      if (m == 0) {
        ((Activity)localObject).finish();
      }
    }
    this.a.a.g();
  }
  
  public void e(boolean paramBoolean)
  {
    this.a.g().c();
  }
  
  protected void f()
  {
    ReportController.b(null, "CliOper", "", "", "View_pic", "View_pic_menu", 0, 0, "1", "", "", "");
    c(2);
  }
  
  public void f(boolean paramBoolean)
  {
    if (this.a.c != null) {
      this.a.c.showContentView(paramBoolean);
    }
    if (paramBoolean) {
      i();
    }
  }
  
  public boolean g()
  {
    return (!ParamsManager.a().g()) && (UinTypeUtil.e(ParamsManager.a().i()) != 1044) && (UinTypeUtil.e(ParamsManager.a().i()) != 1032) && (ParamsManager.a().o() != 3) && (ParamsManager.a().o() != 4) && (ParamsManager.a().o() != 6) && (ParamsManager.a().s());
  }
  
  public Rect getAnimationEndDstRect()
  {
    return null;
  }
  
  public void h()
  {
    ImmersionHelper localImmersionHelper = this.a.g();
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
      this.a.b(true);
    }
    this.a.g().d();
    this.a.m();
    this.a.n();
    f(true);
    b(true);
  }
  
  public void i() {}
  
  public void j()
  {
    this.a.g().b();
    this.a.g().a = false;
    this.a.g().a();
  }
  
  public void k()
  {
    h();
    j();
  }
  
  public boolean needEnterRectAnimation()
  {
    return !((IBrowserDepend)QRoute.api(IBrowserDepend.class)).isSoftInputPanel(ParamsManager.a().p());
  }
  
  public boolean needExitRectAnimation()
  {
    if (((ParamsManager.a().p() == -3321) || (((IBrowserDepend)QRoute.api(IBrowserDepend.class)).isSoftInputPanel(ParamsManager.a().p()))) && (!ParamsManager.a().n())) {
      return false;
    }
    int m = ParamsManager.a().q();
    int n = -2147483648;
    if (m == -2147483648) {
      return false;
    }
    Iterator localIterator = ((ActivityManager)this.c.getSystemService("activity")).getRunningAppProcesses().iterator();
    ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
    do
    {
      m = n;
      if (!localIterator.hasNext()) {
        break;
      }
      localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
    } while (!localRunningAppProcessInfo.processName.endsWith("mobileqq"));
    m = localRunningAppProcessInfo.pid;
    return m == ParamsManager.a().q();
  }
  
  public void onClickEvent()
  {
    this.a.j();
  }
  
  public void onDoubleTap(int paramInt) {}
  
  public void onEnterAnimationEnd()
  {
    a(true);
    if (ParamsManager.a().o() == 4) {
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
    if (ParamsManager.a().o() == 4) {
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
    if (this.a.c != null)
    {
      AIOBrowserBasePresenter localAIOBrowserBasePresenter = this.a;
      if (localAIOBrowserBasePresenter.a(localAIOBrowserBasePresenter.c.getCurrentPosition())) {
        this.a.c();
      }
    }
    b(true);
  }
  
  public void onScrollHalfScreenWidth() {}
  
  public void onScrollStart()
  {
    if (this.a.c != null)
    {
      AIOBrowserBasePresenter localAIOBrowserBasePresenter = this.a;
      if (localAIOBrowserBasePresenter.a(localAIOBrowserBasePresenter.c.getCurrentPosition())) {
        this.a.a(false);
      }
    }
    b(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOBrowserBaseView
 * JD-Core Version:    0.7.0.1
 */