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
  private View jdField_a_of_type_AndroidViewView = null;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private final TroopChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver;
  private TroopOnlinePushObserver jdField_a_of_type_ComTencentMobileqqTroopOnlinepushApiTroopOnlinePushObserver;
  TroopMembersHandler jdField_a_of_type_ComTencentMobileqqTroopQuickatNetworkTroopMembersHandler;
  private AIOAtSearchManager jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAIOAtSearchManager;
  private ListViewWrapper jdField_a_of_type_ComTencentMobileqqTroopQuickatUiListViewWrapper;
  private PopupCardDialog jdField_a_of_type_ComTencentMobileqqTroopQuickatUiPopupCardDialog;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  private boolean c = false;
  private boolean d;
  
  public AtPanel(TroopChatPie paramTroopChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie = paramTroopChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramTroopChatPie.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatNetworkTroopMembersHandler = new TroopMembersHandler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAIOAtSearchManager = new AIOAtSearchManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAIOAtSearchManager.a(this);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopOnlinepushApiTroopOnlinePushObserver == null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopOnlinepushApiTroopOnlinePushObserver = new AtPanel.1(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver == null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver = new AtPanel.2(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopOnlinepushApiTroopOnlinePushObserver);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" addObservers = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
      localStringBuilder.append(", businessObserver = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTroopOnlinepushApiTroopOnlinePushObserver);
      QLog.d("AtPanel", 2, localStringBuilder.toString());
    }
  }
  
  private void e()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131368874);
    View localView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131362371);
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiPopupCardDialog = PopupCardDialog.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, -1, -1);
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiPopupCardDialog.setTouchInterceptor(new AtPanel.3(this, localView, (View)localObject));
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiPopupCardDialog.setOnDismissListener(this);
    localObject = (XListView)this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiPopupCardDialog.getContentView().findViewById(2131379297);
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiListViewWrapper = new ListViewWrapper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.context, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie, this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiPopupCardDialog.getContentView(), (XListView)localObject);
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiListViewWrapper.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiQuickAtListAdapter.a(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiPopupCardDialog.a(this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiListViewWrapper.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiQuickAtListAdapter.a());
    d();
    ((ITroopRobotHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_ROBOT_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AtPanel", 2, "initMultiSelectMode: invoked. ");
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiListViewWrapper.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiQuickAtListAdapter.a().jdField_a_of_type_Boolean = false;
    TextView localTextView = (TextView)this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiPopupCardDialog.getContentView().findViewById(2131363018);
    if (localTextView != null) {
      localTextView.setText(2131694356);
    }
  }
  
  public void a()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      a();
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new AtPanel.4(this));
  }
  
  public void a(View paramView, String paramString, boolean paramBoolean)
  {
    ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "aio_at", true);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiPopupCardDialog == null) {
      e();
    }
    this.b = true;
    this.c = false;
    this.jdField_a_of_type_AndroidViewView = paramView;
    if ((TextUtils.isEmpty(paramString)) && (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      f();
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAIOAtSearchManager.a();
    if ((!TextUtils.isEmpty(paramString)) && (!bool))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiPopupCardDialog.a(8, 2131689827);
      this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAIOAtSearchManager.a(paramString, paramBoolean, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.v());
    }
    else
    {
      c();
      if ((!bool) && (this.jdField_a_of_type_ComTencentMobileqqTroopQuickatNetworkTroopMembersHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (!this.d)) {
        bool = true;
      } else {
        bool = false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AtPanel", 2, new Object[] { "showDialogAtView: invoked. ", " noNeedToFetch: ", Boolean.valueOf(bool) });
      }
      if (bool)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAIOAtSearchManager.a(paramString, paramBoolean, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.v());
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiPopupCardDialog.a(0, 2131689827);
        this.jdField_a_of_type_ComTencentMobileqqTroopQuickatNetworkTroopMembersHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        this.d = false;
      }
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A48E", "0X800A48E", 0, 0, "", "", "", "");
  }
  
  public void a(SearchTask.SearchResult paramSearchResult)
  {
    if (!this.b)
    {
      if (QLog.isColorLevel())
      {
        paramSearchResult = new StringBuilder();
        paramSearchResult.append("refreshUI =");
        paramSearchResult.append(this.b);
        QLog.d("AtPanel", 2, paramSearchResult.toString());
      }
      return;
    }
    if ((paramSearchResult.a != null) && (!paramSearchResult.a.isEmpty()))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiPopupCardDialog.a(8, 2131689827);
      c();
      this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiListViewWrapper.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiQuickAtListAdapter.a(paramSearchResult);
      if (this.c)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AtPanel", 2, "From Multi");
        }
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiListViewWrapper.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiListViewWrapper.jdField_a_of_type_ComTencentWidgetXListView.getAdapter());
      this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiListViewWrapper.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AtPanel", 2, "resultList = null");
    }
    a();
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiListViewWrapper != null)
    {
      PopupCardDialog localPopupCardDialog = this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiPopupCardDialog;
      if ((localPopupCardDialog != null) && (localPopupCardDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiListViewWrapper.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiQuickAtListAdapter.a(paramString);
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.c = true;
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAIOAtSearchManager.a(paramString, paramBoolean, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.v());
  }
  
  public boolean a()
  {
    PopupCardDialog localPopupCardDialog = this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiPopupCardDialog;
    boolean bool;
    if ((localPopupCardDialog != null) && (localPopupCardDialog.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiPopupCardDialog.dismiss();
      bool = true;
    }
    else
    {
      bool = false;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAIOAtSearchManager.a();
    return bool;
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopOnlinepushApiTroopOnlinePushObserver;
    if (localObject != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver((BusinessObserver)localObject);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver;
    if (localObject != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver((BusinessObserver)localObject);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" removeObserver =");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqTroopOnlinepushApiTroopOnlinePushObserver);
      QLog.d("AtPanel", 2, ((StringBuilder)localObject).toString());
    }
    a();
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiPopupCardDialog = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAIOAtSearchManager.a(null);
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAIOAtSearchManager.b();
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiListViewWrapper;
    if ((localObject != null) && (((ListViewWrapper)localObject).jdField_a_of_type_ComTencentMobileqqTroopQuickatUiQuickAtListAdapter != null)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiListViewWrapper.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiQuickAtListAdapter.c();
    }
  }
  
  public boolean b()
  {
    ListViewWrapper localListViewWrapper = this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiListViewWrapper;
    if (localListViewWrapper != null) {
      return localListViewWrapper.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiQuickAtListAdapter.jdField_a_of_type_Boolean;
    }
    return false;
  }
  
  public void c()
  {
    ScreenShotDetector.getInstance().a(this);
    SoftPanelStatus.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiPopupCardDialog.b();
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiPopupCardDialog.showAtLocation(this.jdField_a_of_type_AndroidViewView, 48, 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiPopupCardDialog.a(SoftPanelStatus.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity), SoftPanelStatus.a, -1);
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiListViewWrapper.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiQuickAtListAdapter.a();
  }
  
  public void onDismiss()
  {
    this.c = false;
    this.b = false;
    this.jdField_a_of_type_JavaLangString = null;
    ScreenShotDetector.getInstance().a(null);
    ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "aio_at", false);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiListViewWrapper;
    if (localObject != null) {
      ((ListViewWrapper)localObject).jdField_a_of_type_ComTencentMobileqqTroopQuickatUiQuickAtListAdapter.b();
    }
    int i = SoftPanelStatus.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localObject = (InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("input_method");
    View localView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131368874);
    if ((i == 2) && (localObject != null) && (localView != null)) {
      ((InputMethodManager)localObject).showSoftInput(localView, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.quickat.ui.AtPanel
 * JD-Core Version:    0.7.0.1
 */