package com.tencent.mobileqq.troop.quickat.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.LayerDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.Method;

public class GuildAtDialog
  extends PopupWindow
  implements View.OnClickListener, SoftPanelStatus.AtPanelStatusListener
{
  private SoftPanelStatus a;
  private GuildAtDialog.Listener b;
  private View c;
  private Activity d;
  
  private GuildAtDialog(QBaseActivity paramQBaseActivity, View paramView, int paramInt1, int paramInt2)
  {
    super(paramView, paramInt1, paramInt2);
    this.a = new SoftPanelStatus(paramQBaseActivity);
    this.d = paramQBaseActivity;
    paramView = (LayerDrawable)paramQBaseActivity.getResources().getDrawable(2130837942);
    paramQBaseActivity = new ColorDrawable();
    paramView = (LayerDrawable)paramView.mutate();
    paramView.setDrawableByLayerId(2131436853, paramQBaseActivity);
    setBackgroundDrawable(paramView);
  }
  
  public static GuildAtDialog a(QBaseActivity paramQBaseActivity, int paramInt1, int paramInt2)
  {
    View localView = LayoutInflater.from(paramQBaseActivity).inflate(2131624981, null);
    GuildAtDialog localGuildAtDialog = new GuildAtDialog(paramQBaseActivity, localView, paramInt1, paramInt2);
    a(localGuildAtDialog, paramQBaseActivity);
    localGuildAtDialog.setFocusable(false);
    localView.setOnClickListener(localGuildAtDialog);
    ((TextView)localView.findViewById(2131428826)).setOnClickListener(localGuildAtDialog);
    ((RelativeLayout)localView.findViewById(2131428827)).setOnClickListener(localGuildAtDialog);
    localGuildAtDialog.setInputMethodMode(32);
    localGuildAtDialog.setInputMethodMode(1);
    localGuildAtDialog.setClippingEnabled(false);
    localGuildAtDialog.setOutsideTouchable(false);
    if (AppSetting.e) {
      a(localGuildAtDialog);
    }
    return localGuildAtDialog;
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
  
  private static void a(GuildAtDialog paramGuildAtDialog, Activity paramActivity)
  {
    paramGuildAtDialog = paramGuildAtDialog.getContentView();
    RelativeLayout localRelativeLayout = (RelativeLayout)paramGuildAtDialog.findViewById(2131431322);
    int i = AIOUtils.b(60.0F, paramActivity.getResources());
    ((XListView)paramGuildAtDialog.findViewById(2131448034)).setOverScrollMode(2);
    localRelativeLayout.setPadding(0, i, 0, 0);
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
    int i = getHeight();
    View localView = this.c;
    if (localView == null) {
      paramInt1 = 0;
    } else {
      paramInt1 = localView.getHeight();
    }
    if (SoftPanelStatus.b) {
      paramInt3 = 0;
    } else {
      paramInt3 = ImmersiveUtils.getStatusBarHeight(this.d);
    }
    paramInt1 = paramInt2 - paramInt1 + paramInt3;
    if (paramInt1 != i) {
      update(0, 0, -1, paramInt1);
    }
    a(this, this.d);
  }
  
  public void a(GuildAtDialog.Listener paramListener)
  {
    this.b = paramListener;
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramInt1, paramInt2, -1);
  }
  
  @TargetApi(16)
  public void dismiss()
  {
    this.a.a();
    this.a.a(null);
    this.c = null;
    super.dismiss();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131428826)
    {
      GuildAtDialog.Listener localListener = this.b;
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
    this.c = paramView;
    super.showAtLocation(paramView, paramInt1, paramInt2, paramInt3);
    this.a.a(this);
    this.a.a(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.quickat.ui.GuildAtDialog
 * JD-Core Version:    0.7.0.1
 */