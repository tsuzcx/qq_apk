package com.tencent.mobileqq.wink.editor.filter;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.wink.edit.bean.AEFilterExtendBean;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.edit.util.WinkMapReport;
import com.tencent.mobileqq.wink.editor.MetaMaterialKt;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel.EditMode;
import com.tencent.mobileqq.wink.editor.WinkMaterialViewModel;
import com.tencent.mobileqq.wink.editor.menu.MenuType;
import com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart;
import com.tencent.mobileqq.wink.event.FilterSelectedEvent;
import com.tencent.mobileqq.wink.event.ReceiveSchemaEvent;
import com.tencent.mobileqq.wink.flow.ApplyMaterialTask;
import com.tencent.mobileqq.wink.flow.ApplyMaterialTask.MaterialStatusCallback;
import com.tencent.mobileqq.wink.flow.ApplyMaterialTask.Status;
import com.tencent.mobileqq.wink.flow.ApplyMaterialTaskHelper;
import com.tencent.mobileqq.wink.view.StartPointSeekBar;
import com.tencent.mobileqq.wink.view.WinkMaterialPanel;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class WinkEditorFilterMenuPart
  extends WinkEditorMenuPart
  implements SimpleEventReceiver, ApplyMaterialTask
{
  private WinkMaterialPanel g;
  private FilterMaterialPanelContentAdapter h;
  private View i;
  private StartPointSeekBar j;
  private TextView k;
  private TextView l;
  private TextView m;
  private ValueAnimator n;
  private WinkEditorFilterViewModel o;
  
  private void a(@NonNull MetaMaterial paramMetaMaterial)
  {
    this.l.setText(MetaMaterialKt.b(paramMetaMaterial));
    this.m.setText(MetaMaterialKt.e(paramMetaMaterial));
    this.n.start();
  }
  
  private void a(@NonNull MetaMaterial paramMetaMaterial, @NonNull ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback)
  {
    String str = FilterMetaMaterialKt.j(paramMetaMaterial);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("lutId = ");
    ((StringBuilder)localObject).append(str);
    ApplyMaterialTaskHelper.a("downloadLutResource", paramMetaMaterial, ((StringBuilder)localObject).toString());
    if (TextUtils.isEmpty(str))
    {
      FilterMetaMaterialKt.a(paramMetaMaterial, true);
      paramMaterialStatusCallback.onStatusChanged(ApplyMaterialTask.Status.SUCCEEDED, 100);
      return;
    }
    localObject = WinkEditorResourceManager.c().c(paramMetaMaterial);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("lutPath = ");
    localStringBuilder.append((String)localObject);
    ApplyMaterialTaskHelper.a("downloadLutResource", paramMetaMaterial, localStringBuilder.toString());
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (new File((String)localObject).exists()))
    {
      FilterMetaMaterialKt.a(paramMetaMaterial, true);
      paramMaterialStatusCallback.onStatusChanged(ApplyMaterialTask.Status.SUCCEEDED, 100);
      return;
    }
    WinkEditorResourceManager.c().a(str, new WinkEditorFilterMenuPart.4(this, paramMetaMaterial, paramMaterialStatusCallback));
  }
  
  private boolean a(MetaMaterial paramMetaMaterial, String paramString)
  {
    try
    {
      paramString = (AEFilterExtendBean)new Gson().fromJson(paramString, new WinkEditorFilterMenuPart.3(this).getType());
      if (paramString != null)
      {
        FilterMetaMaterialKt.b(paramMetaMaterial, true);
        FilterMetaMaterialKt.b(paramMetaMaterial, paramString.getDefaultEffectAlpha());
        if (!TextUtils.isEmpty(paramString.getLutID())) {
          FilterMetaMaterialKt.a(paramMetaMaterial, paramString.getLutID());
        }
        FilterMetaMaterialKt.c(paramMetaMaterial, paramString.getGlowStrength());
        if (!TextUtils.isEmpty(paramString.getMotionID())) {
          FilterMetaMaterialKt.b(paramMetaMaterial, paramString.getMotionID());
        }
        FilterMetaMaterialKt.a(paramMetaMaterial, paramString.getAdjustParams());
        return true;
      }
    }
    catch (JsonSyntaxException paramMetaMaterial)
    {
      paramString = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parse effect json exception: ");
      localStringBuilder.append(paramMetaMaterial.toString());
      AEQLog.d(paramString, localStringBuilder.toString());
    }
    return false;
  }
  
  private void b(View paramView)
  {
    this.i = paramView.findViewById(2131445497);
    this.k = ((TextView)paramView.findViewById(2131448214));
    this.j = ((StartPointSeekBar)paramView.findViewById(2131446268));
    this.j.setSectionEnable(true);
    this.j.setDefaultValue(80.0F);
    this.j.setOnSeekBarChangeListener(new WinkEditorFilterMenuPart.2(this));
    this.o.b().observe(j(), new -..Lambda.WinkEditorFilterMenuPart.Ip755vb20FO_rESei-JrNaJpRco(this));
    this.o.c().observe(j(), new -..Lambda.WinkEditorFilterMenuPart.jgy9dKByYXqASqsmXb_Y_2BuLo0(this));
  }
  
  private void s()
  {
    this.n = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F, 1.0F, 0.0F }).setDuration(800L);
    this.n.addUpdateListener(new -..Lambda.WinkEditorFilterMenuPart.HK8P3qbzFLSHxs-hXtCYjj8Loh4(this));
    this.n.addListener(new WinkEditorFilterMenuPart.1(this));
  }
  
  public void a(int paramInt, @NonNull MetaMaterial paramMetaMaterial, @NonNull ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback)
  {
    ApplyMaterialTaskHelper.a(paramMaterialStatusCallback);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.l = ((TextView)paramView.findViewById(2131433160));
    this.m = ((TextView)paramView.findViewById(2131433158));
    c(paramView);
  }
  
  public void a(WinkEditorViewModel.EditMode paramEditMode)
  {
    if (paramEditMode == WinkEditorViewModel.EditMode.Image)
    {
      F().setOnClickListener(new -..Lambda.WinkEditorFilterMenuPart.Fg_hvO7_81AlINu2I1ML2Pc5d0M(this));
      return;
    }
    F().setOnClickListener(null);
    F().setFocusable(false);
    F().setClickable(false);
  }
  
  public void a(ApplyMaterialTask.Status paramStatus, int paramInt, @NonNull MetaMaterial paramMetaMaterial, @NonNull ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback)
  {
    if (FilterMetaMaterialKt.c(paramMetaMaterial))
    {
      paramMaterialStatusCallback.onStatusChanged(ApplyMaterialTask.Status.SUCCEEDED, 100);
      return;
    }
    if (FilterMetaMaterialKt.d(paramMetaMaterial))
    {
      a(paramMetaMaterial, paramMaterialStatusCallback);
      return;
    }
    ThreadManager.getFileThreadHandler().post(new -..Lambda.WinkEditorFilterMenuPart.DD23G0406LBaaApoD75VIPFq-1Q(this, paramMetaMaterial, paramMaterialStatusCallback));
  }
  
  public boolean a(int paramInt, @NonNull MetaMaterial paramMetaMaterial)
  {
    return ApplyMaterialTaskHelper.a(paramMetaMaterial);
  }
  
  public boolean b(int paramInt, @NonNull MetaMaterial paramMetaMaterial)
  {
    return this.o.b(paramMetaMaterial);
  }
  
  public void c(int paramInt, @NonNull MetaMaterial paramMetaMaterial) {}
  
  protected void c(View paramView)
  {
    super.c(paramView);
    this.o = ((WinkEditorFilterViewModel)a(WinkEditorFilterViewModel.class));
    this.o.d().observe(j(), new -..Lambda.WinkEditorFilterMenuPart.ydK5zmnaAjIWs2c-7FqQebu-a-E(this));
    this.g = ((WinkMaterialPanel)paramView.findViewById(2131437998));
    this.g.setOnClearButtonClickListener(new -..Lambda.WinkEditorFilterMenuPart.agsTbSJKm5gZnYvEInL5ugNixGk(this));
    this.h = new FilterMaterialPanelContentAdapter(g());
    this.h.a(this);
    p().getFilterMaterialVOLiveData().observe(j(), new -..Lambda.WinkEditorFilterMenuPart.wI9Sn9b9R9u2AM4Ho4MOFsh18-s(this));
    s();
    b(paramView);
  }
  
  public int d()
  {
    return 2131433159;
  }
  
  public void d(int paramInt, @NonNull MetaMaterial paramMetaMaterial)
  {
    this.o.a(paramMetaMaterial);
    WinkMapReport.a().a(paramMetaMaterial.id, "video", "0");
  }
  
  @NonNull
  public MenuType e()
  {
    return MenuType.FILTER;
  }
  
  public void e(int paramInt, @NonNull MetaMaterial paramMetaMaterial)
  {
    this.h.a(paramInt);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(FilterSelectedEvent.class);
    localArrayList.add(ReceiveSchemaEvent.class);
    return localArrayList;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    Object localObject;
    if ((paramSimpleBaseEvent instanceof FilterSelectedEvent))
    {
      paramSimpleBaseEvent = ((FilterSelectedEvent)paramSimpleBaseEvent).getMaterial();
      localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onReceiveEvent] material=");
      localStringBuilder.append(paramSimpleBaseEvent);
      localStringBuilder.append("adapter=");
      localStringBuilder.append(this.h);
      AEQLog.a((String)localObject, localStringBuilder.toString());
      if (this.o.e() != paramSimpleBaseEvent)
      {
        localObject = this.h;
        if (localObject != null)
        {
          if (paramSimpleBaseEvent != null)
          {
            ((FilterMaterialPanelContentAdapter)localObject).a(paramSimpleBaseEvent.id);
            return;
          }
          this.o.a(null);
        }
      }
    }
    else if ((paramSimpleBaseEvent instanceof ReceiveSchemaEvent))
    {
      paramSimpleBaseEvent = (HashMap)((ReceiveSchemaEvent)paramSimpleBaseEvent).getAttrs();
      if ((paramSimpleBaseEvent != null) && (!paramSimpleBaseEvent.isEmpty()) && (paramSimpleBaseEvent.containsKey("filter")) && (!TextUtils.isEmpty((CharSequence)paramSimpleBaseEvent.get("filter"))))
      {
        localObject = this.h;
        if (localObject != null) {
          ((FilterMaterialPanelContentAdapter)localObject).a((String)paramSimpleBaseEvent.get("filter"));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.filter.WinkEditorFilterMenuPart
 * JD-Core Version:    0.7.0.1
 */