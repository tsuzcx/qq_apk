package com.tencent.mobileqq.troop.quickat.ui;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.apollo.script.api.ISpriteCommFunc;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.screendetect.ScreenShotDetector;
import com.tencent.mobileqq.screendetect.ScreenShotDetector.ScreenShotListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.onlinepush.api.TroopOnlinePushObserver;
import com.tencent.mobileqq.troop.quickat.network.TroopMembersHandler;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.List;

public class AtPanel
  implements PopupWindow.OnDismissListener, ScreenShotDetector.ScreenShotListener, AIOAtSearchManager.RefreshUIListener, AtPanelListener
{
  TroopMembersHandler a;
  private final TroopChatPie b;
  private BaseActivity c;
  private PopupCardDialog d;
  private QQAppInterface e;
  private SessionInfo f;
  private ListViewWrapper g;
  private TroopObserver h;
  private TroopOnlinePushObserver i;
  private String j;
  private boolean k = false;
  private AIOAtSearchManager l;
  private boolean m = false;
  private View n = null;
  private boolean o = false;
  private boolean p;
  
  public AtPanel(TroopChatPie paramTroopChatPie)
  {
    this.b = paramTroopChatPie;
    this.c = paramTroopChatPie.aX();
    this.e = paramTroopChatPie.d;
    this.f = paramTroopChatPie.ah;
    this.a = new TroopMembersHandler(this.e);
    this.l = new AIOAtSearchManager(this.e, this.f);
    this.l.a(this);
  }
  
  private void f()
  {
    if (this.i == null) {
      this.i = new AtPanel.1(this);
    }
    if (this.h == null) {
      this.h = new AtPanel.2(this);
    }
    this.e.addObserver(this.h);
    this.e.addObserver(this.i);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" addObservers = ");
      localStringBuilder.append(this.h);
      localStringBuilder.append(", businessObserver = ");
      localStringBuilder.append(this.i);
      QLog.d("AtPanel", 2, localStringBuilder.toString());
    }
  }
  
  private void g()
  {
    Object localObject = this.c.findViewById(2131435808);
    View localView = this.c.findViewById(2131427979);
    this.d = PopupCardDialog.a(this.c, -1, -1);
    this.d.setTouchInterceptor(new AtPanel.3(this, localView, (View)localObject));
    this.d.setOnDismissListener(this);
    localObject = (XListView)this.d.getContentView().findViewById(2131448034);
    this.g = new ListViewWrapper(this.e, BaseApplicationImpl.context, this.b, this.d.getContentView(), (XListView)localObject);
    this.g.b.a(this);
    this.d.a(this.g.b.f());
    f();
    ((ITroopRobotHandler)this.e.getBusinessHandler(BusinessHandlerFactory.TROOP_ROBOT_HANDLER)).a(this.f.b);
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AtPanel", 2, "initMultiSelectMode: invoked. ");
    }
    this.g.b.f().b = false;
    TextView localTextView = (TextView)this.d.getContentView().findViewById(2131428826);
    if (localTextView != null) {
      localTextView.setText(2131892030);
    }
  }
  
  public void a()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      d();
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new AtPanel.4(this));
  }
  
  public void a(View paramView, String paramString, boolean paramBoolean)
  {
    ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(this.e, "aio_at", true);
    if (this.d == null) {
      g();
    }
    this.m = true;
    this.o = false;
    this.n = paramView;
    if ((TextUtils.isEmpty(paramString)) && (TextUtils.isEmpty(this.j))) {
      h();
    }
    this.j = paramString;
    this.k = paramBoolean;
    boolean bool = this.l.b();
    if ((!TextUtils.isEmpty(paramString)) && (!bool))
    {
      this.d.a(8, 2131886468);
      this.l.a(paramString, paramBoolean, this.b.bG());
    }
    else
    {
      c();
      if ((!bool) && (this.a.b(this.f.b)) && (!this.p)) {
        bool = true;
      } else {
        bool = false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AtPanel", 2, new Object[] { "showDialogAtView: invoked. ", " noNeedToFetch: ", Boolean.valueOf(bool) });
      }
      if (bool)
      {
        this.l.a(paramString, paramBoolean, this.b.bG());
      }
      else
      {
        this.d.a(0, 2131886468);
        this.a.a(this.f.b);
        this.p = false;
      }
    }
    ReportController.b(this.e, "dc00898", "", "", "0X800A48E", "0X800A48E", 0, 0, "", "", "", "");
  }
  
  public void a(SearchTask.SearchResult paramSearchResult)
  {
    if (!this.m)
    {
      if (QLog.isColorLevel())
      {
        paramSearchResult = new StringBuilder();
        paramSearchResult.append("refreshUI =");
        paramSearchResult.append(this.m);
        QLog.d("AtPanel", 2, paramSearchResult.toString());
      }
      return;
    }
    if ((paramSearchResult.c != null) && (!paramSearchResult.c.isEmpty()))
    {
      this.d.a(8, 2131886468);
      c();
      this.g.b.a(paramSearchResult);
      if (this.o)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AtPanel", 2, "From Multi");
        }
        return;
      }
      this.g.a.setAdapter(this.g.a.getAdapter());
      this.g.a.setSelection(0);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AtPanel", 2, "resultList = null");
    }
    d();
  }
  
  public void a(String paramString)
  {
    if (this.g != null)
    {
      PopupCardDialog localPopupCardDialog = this.d;
      if ((localPopupCardDialog != null) && (localPopupCardDialog.isShowing())) {
        this.g.b.c(paramString);
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.o = true;
    this.l.a(paramString, paramBoolean, this.b.bG());
  }
  
  public void b()
  {
    Object localObject = this.i;
    if (localObject != null) {
      this.e.removeObserver((BusinessObserver)localObject);
    }
    localObject = this.h;
    if (localObject != null) {
      this.e.removeObserver((BusinessObserver)localObject);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" removeObserver =");
      ((StringBuilder)localObject).append(this.i);
      QLog.d("AtPanel", 2, ((StringBuilder)localObject).toString());
    }
    d();
    this.d = null;
    this.l.a(null);
    this.l.d();
    localObject = this.g;
    if ((localObject != null) && (((ListViewWrapper)localObject).b != null)) {
      this.g.b.d();
    }
  }
  
  public void c()
  {
    ScreenShotDetector.getInstance().a(this);
    SoftPanelStatus.a(this.c);
    this.d.a();
    this.d.showAtLocation(this.n, 48, 0, 0);
    this.d.a(SoftPanelStatus.b(this.c), SoftPanelStatus.a, -1);
    this.g.b.g();
  }
  
  public boolean d()
  {
    PopupCardDialog localPopupCardDialog = this.d;
    boolean bool;
    if ((localPopupCardDialog != null) && (localPopupCardDialog.isShowing()))
    {
      this.d.dismiss();
      bool = true;
    }
    else
    {
      bool = false;
    }
    this.l.c();
    return bool;
  }
  
  public boolean e()
  {
    ListViewWrapper localListViewWrapper = this.g;
    if (localListViewWrapper != null) {
      return localListViewWrapper.b.a;
    }
    return false;
  }
  
  public void onDismiss()
  {
    this.o = false;
    this.m = false;
    this.j = null;
    ScreenShotDetector.getInstance().a(null);
    ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(this.e, "aio_at", false);
    Object localObject = this.g;
    if (localObject != null) {
      ((ListViewWrapper)localObject).b.h();
    }
    int i1 = SoftPanelStatus.b(this.c);
    localObject = (InputMethodManager)this.c.getSystemService("input_method");
    View localView = this.c.findViewById(2131435808);
    if ((i1 == 2) && (localObject != null) && (localView != null)) {
      ((InputMethodManager)localObject).showSoftInput(localView, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.quickat.ui.AtPanel
 * JD-Core Version:    0.7.0.1
 */