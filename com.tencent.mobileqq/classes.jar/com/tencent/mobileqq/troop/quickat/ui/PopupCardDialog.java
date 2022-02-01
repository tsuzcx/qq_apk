package com.tencent.mobileqq.troop.quickat.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contacts.alphabet.IndexBar;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.Method;

public class PopupCardDialog
  extends PopupWindow
  implements View.OnClickListener, Animation.AnimationListener, AtPanelTouchController.AtPanelTouchListener, SoftPanelStatus.AtPanelStatusListener
{
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private LayerDrawable jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable;
  private View jdField_a_of_type_AndroidViewView;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private PopupCardDialog.Listener jdField_a_of_type_ComTencentMobileqqTroopQuickatUiPopupCardDialog$Listener;
  private SoftPanelStatus jdField_a_of_type_ComTencentMobileqqTroopQuickatUiSoftPanelStatus;
  private Drawable b;
  
  private PopupCardDialog(BaseActivity paramBaseActivity, View paramView, int paramInt1, int paramInt2)
  {
    super(paramView, paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiSoftPanelStatus = new SoftPanelStatus(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    paramBaseActivity = (LayerDrawable)paramBaseActivity.getResources().getDrawable(2130838071);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable();
    this.b = paramBaseActivity.getDrawable(1);
    this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable = ((LayerDrawable)paramBaseActivity.mutate());
    this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable.setDrawableByLayerId(2131370053, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable);
  }
  
  private static View a(PopupCardDialog paramPopupCardDialog, Activity paramActivity, int paramInt)
  {
    View localView = paramPopupCardDialog.getContentView();
    AtPanelTouchController localAtPanelTouchController = (AtPanelTouchController)localView.findViewById(2131365294);
    int i = AIOUtils.a(60.0F, paramActivity.getResources());
    IndexBar localIndexBar = (IndexBar)localView.findViewById(2131369039);
    XListView localXListView = (XListView)localView.findViewById(2131379968);
    ViewGroup.LayoutParams localLayoutParams = localXListView.getLayoutParams();
    localXListView.setOverScrollMode(2);
    if (paramInt == 1) {
      localIndexBar.setVisibility(8);
    }
    for (localLayoutParams.height = -2;; localLayoutParams.height = -1)
    {
      localAtPanelTouchController.a(0, 500);
      localAtPanelTouchController.setAtPanelTouchListener(paramPopupCardDialog);
      localAtPanelTouchController.setMode(paramInt);
      localAtPanelTouchController.setPadding(0, i, 0, 0);
      localXListView.setLayoutParams(localLayoutParams);
      return localView;
      localIndexBar.setVisibility(0);
      ListAdapter localListAdapter = localXListView.getAdapter();
      if (((localListAdapter instanceof QuickAtListAdapter)) && (((QuickAtListAdapter)localListAdapter).b() == 1)) {
        localIndexBar.setVisibility(8);
      }
      i = AIOUtils.a(40.0F, paramActivity.getResources());
    }
  }
  
  public static PopupCardDialog a(BaseActivity paramBaseActivity, int paramInt1, int paramInt2)
  {
    View localView = LayoutInflater.from(paramBaseActivity).inflate(2131558669, null);
    PopupCardDialog localPopupCardDialog = new PopupCardDialog(paramBaseActivity, localView, paramInt1, paramInt2);
    a(localPopupCardDialog, paramBaseActivity, 1);
    localPopupCardDialog.setFocusable(false);
    localView.setOnClickListener(localPopupCardDialog);
    ((TextView)localView.findViewById(2131363077)).setOnClickListener(localPopupCardDialog);
    ((RelativeLayout)localView.findViewById(2131363078)).setOnClickListener(localPopupCardDialog);
    localPopupCardDialog.setInputMethodMode(32);
    localPopupCardDialog.setInputMethodMode(1);
    localPopupCardDialog.setClippingEnabled(false);
    localPopupCardDialog.setOutsideTouchable(true);
    if (AppSetting.d) {
      a(localPopupCardDialog);
    }
    return localPopupCardDialog;
  }
  
  public static void a(PopupWindow paramPopupWindow)
  {
    int i = 0;
    if (!AppSetting.d) {}
    for (;;)
    {
      return;
      Method[] arrayOfMethod = PopupWindow.class.getMethods();
      int j = arrayOfMethod.length;
      while (i < j)
      {
        Method localMethod = arrayOfMethod[i];
        if (localMethod.getName().equals("setTouchModal")) {
          try
          {
            localMethod.invoke(paramPopupWindow, new Object[] { Boolean.valueOf(false) });
            return;
          }
          catch (Exception paramPopupWindow)
          {
            paramPopupWindow.printStackTrace();
            return;
          }
        }
        i += 1;
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null)
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("input_method");
      if (localInputMethodManager != null) {
        localInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().getDecorView().getWindowToken(), 0);
      }
    }
  }
  
  public void a(int paramInt)
  {
    dismiss();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    View localView = getContentView().findViewById(2131362467);
    if (localView == null) {
      return;
    }
    localView.setVisibility(paramInt1);
    ((TextView)localView.findViewById(2131370757)).setText(localView.getResources().getText(paramInt2));
    if (paramInt2 != 2131689914) {}
    for (paramInt1 = 0;; paramInt1 = 8)
    {
      getContentView().findViewById(2131362374).setVisibility(paramInt1);
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = getHeight();
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      paramInt3 = 0;
      if (!SoftPanelStatus.a) {
        break label67;
      }
    }
    label67:
    for (int i = 0;; i = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      paramInt2 = paramInt2 - paramInt3 + i;
      if (paramInt2 != j) {
        update(0, 0, -1, paramInt2);
      }
      a(this, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramInt1);
      return;
      paramInt3 = this.jdField_a_of_type_AndroidViewView.getHeight();
      break;
    }
  }
  
  public void a(PopupCardDialog.Listener paramListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiPopupCardDialog$Listener = paramListener;
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable.setDrawableByLayerId(2131370053, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PopupCardDialog", 2, "JSKJSSKSKSKSK+" + paramBoolean);
      }
      return;
      this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable.setDrawableByLayerId(2131370053, this.b);
    }
  }
  
  public void b()
  {
    if (!isShowing()) {
      getContentView().scrollTo(0, -1000);
    }
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramInt1, paramInt2, -1);
  }
  
  @TargetApi(16)
  public void dismiss()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiSoftPanelStatus.a();
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiSoftPanelStatus.a(null);
    this.jdField_a_of_type_AndroidViewView = null;
    if (Build.VERSION.SDK_INT >= 11) {
      super.dismiss();
    }
    while ((!isShowing()) || ((this.jdField_a_of_type_AndroidViewAnimationAnimation != null) && (!this.jdField_a_of_type_AndroidViewAnimationAnimation.hasEnded()))) {
      return;
    }
    if (this.jdField_a_of_type_AndroidViewAnimationAnimation == null)
    {
      this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130772342);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
    }
    getContentView().startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PopupCardDialog", 2, "onAnimationEnd");
    }
    super.dismiss();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PopupCardDialog", 2, "onAnimationStart");
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131363077) {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiPopupCardDialog$Listener != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiPopupCardDialog$Listener.a(paramView);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView.getId() != 2131363078) {
        dismiss();
      }
    }
  }
  
  public void showAtLocation(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    super.showAtLocation(paramView, paramInt1, paramInt2, paramInt3);
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiSoftPanelStatus.a(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiSoftPanelStatus.a(this.jdField_a_of_type_AndroidViewView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.quickat.ui.PopupCardDialog
 * JD-Core Version:    0.7.0.1
 */