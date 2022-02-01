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
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.Method;

public class PopupCardDialog
  extends PopupWindow
  implements View.OnClickListener, Animation.AnimationListener, AtPanelTouchController.AtPanelTouchListener, SoftPanelStatus.AtPanelStatusListener
{
  private QBaseActivity a;
  private Animation b;
  private SoftPanelStatus c;
  private View d;
  private LayerDrawable e;
  private Drawable f;
  private Drawable g;
  private PopupCardDialog.Listener h;
  
  private PopupCardDialog(QBaseActivity paramQBaseActivity, View paramView, int paramInt1, int paramInt2)
  {
    super(paramView, paramInt1, paramInt2);
    this.a = paramQBaseActivity;
    this.c = new SoftPanelStatus(this.a);
    paramQBaseActivity = (LayerDrawable)paramQBaseActivity.getResources().getDrawable(2130837942);
    this.f = new ColorDrawable();
    this.g = paramQBaseActivity.getDrawable(1);
    this.e = ((LayerDrawable)paramQBaseActivity.mutate());
    this.e.setDrawableByLayerId(2131436853, this.f);
    setBackgroundDrawable(this.e);
  }
  
  private static View a(PopupCardDialog paramPopupCardDialog, Activity paramActivity, int paramInt)
  {
    View localView = paramPopupCardDialog.getContentView();
    AtPanelTouchController localAtPanelTouchController = (AtPanelTouchController)localView.findViewById(2131431322);
    int i = AIOUtils.b(60.0F, paramActivity.getResources());
    IndexBar localIndexBar = (IndexBar)localView.findViewById(2131435678);
    XListView localXListView = (XListView)localView.findViewById(2131448034);
    ViewGroup.LayoutParams localLayoutParams = localXListView.getLayoutParams();
    localXListView.setOverScrollMode(2);
    if (paramInt == 1)
    {
      localIndexBar.setVisibility(8);
      localLayoutParams.height = -2;
    }
    else
    {
      localIndexBar.setVisibility(0);
      ListAdapter localListAdapter = localXListView.getAdapter();
      if (((localListAdapter instanceof QuickAtListAdapter)) && (((QuickAtListAdapter)localListAdapter).b() == 1)) {
        localIndexBar.setVisibility(8);
      }
      i = AIOUtils.b(40.0F, paramActivity.getResources());
      localLayoutParams.height = -1;
    }
    localAtPanelTouchController.a(0, 500);
    localAtPanelTouchController.setAtPanelTouchListener(paramPopupCardDialog);
    localAtPanelTouchController.setMode(paramInt);
    localAtPanelTouchController.setPadding(0, i, 0, 0);
    localXListView.setLayoutParams(localLayoutParams);
    return localView;
  }
  
  public static PopupCardDialog a(QBaseActivity paramQBaseActivity, int paramInt1, int paramInt2)
  {
    View localView = LayoutInflater.from(paramQBaseActivity).inflate(2131624124, null);
    PopupCardDialog localPopupCardDialog = new PopupCardDialog(paramQBaseActivity, localView, paramInt1, paramInt2);
    a(localPopupCardDialog, paramQBaseActivity, 1);
    localPopupCardDialog.setFocusable(false);
    localView.setOnClickListener(localPopupCardDialog);
    ((TextView)localView.findViewById(2131428826)).setOnClickListener(localPopupCardDialog);
    ((RelativeLayout)localView.findViewById(2131428827)).setOnClickListener(localPopupCardDialog);
    localPopupCardDialog.setInputMethodMode(32);
    localPopupCardDialog.setInputMethodMode(1);
    localPopupCardDialog.setClippingEnabled(false);
    localPopupCardDialog.setOutsideTouchable(true);
    if (AppSetting.e) {
      a(localPopupCardDialog);
    }
    return localPopupCardDialog;
  }
  
  public static void a(PopupWindow paramPopupWindow)
  {
    if (!AppSetting.e) {
      return;
    }
    Method[] arrayOfMethod = PopupWindow.class.getMethods();
    int j = arrayOfMethod.length;
    int i = 0;
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
  
  public void a()
  {
    if (!isShowing()) {
      getContentView().scrollTo(0, -1000);
    }
  }
  
  public void a(int paramInt)
  {
    dismiss();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    View localView = getContentView().findViewById(2131428031);
    if (localView == null) {
      return;
    }
    localView.setVisibility(paramInt1);
    ((TextView)localView.findViewById(2131437659)).setText(localView.getResources().getText(paramInt2));
    if (paramInt2 != 2131886469) {
      paramInt1 = 0;
    } else {
      paramInt1 = 8;
    }
    getContentView().findViewById(2131427930).setVisibility(paramInt1);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = getHeight();
    View localView = this.d;
    if (localView == null) {
      paramInt3 = 0;
    } else {
      paramInt3 = localView.getHeight();
    }
    int i;
    if (SoftPanelStatus.b) {
      i = 0;
    } else {
      i = ImmersiveUtils.getStatusBarHeight(this.a);
    }
    paramInt2 = paramInt2 - paramInt3 + i;
    if (paramInt2 != j) {
      update(0, 0, -1, paramInt2);
    }
    a(this, this.a, paramInt1);
  }
  
  public void a(PopupCardDialog.Listener paramListener)
  {
    this.h = paramListener;
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.e.setDrawableByLayerId(2131436853, this.f);
    } else {
      this.e.setDrawableByLayerId(2131436853, this.g);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("JSKJSSKSKSKSK+");
      localStringBuilder.append(paramBoolean);
      QLog.d("PopupCardDialog", 2, localStringBuilder.toString());
    }
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramInt1, paramInt2, -1);
  }
  
  public void d()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = (InputMethodManager)((QBaseActivity)localObject).getSystemService("input_method");
      if (localObject != null) {
        ((InputMethodManager)localObject).hideSoftInputFromWindow(this.a.getWindow().getDecorView().getWindowToken(), 0);
      }
    }
  }
  
  @TargetApi(16)
  public void dismiss()
  {
    this.c.a();
    this.c.a(null);
    this.d = null;
    if (Build.VERSION.SDK_INT >= 11)
    {
      super.dismiss();
      return;
    }
    if (isShowing())
    {
      Animation localAnimation = this.b;
      if ((localAnimation != null) && (!localAnimation.hasEnded())) {
        return;
      }
      if (this.b == null)
      {
        this.b = AnimationUtils.loadAnimation(this.a, 2130772464);
        this.b.setAnimationListener(this);
      }
      getContentView().startAnimation(this.b);
    }
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
    if (paramView.getId() == 2131428826)
    {
      PopupCardDialog.Listener localListener = this.h;
      if (localListener != null) {
        localListener.a(paramView);
      }
    }
    else if (paramView.getId() != 2131428827)
    {
      dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void showAtLocation(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.d = paramView;
    super.showAtLocation(paramView, paramInt1, paramInt2, paramInt3);
    this.c.a(this);
    this.c.a(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.quickat.ui.PopupCardDialog
 * JD-Core Version:    0.7.0.1
 */