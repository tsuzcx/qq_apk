package com.tencent.mobileqq.wink.editor.sticker;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.LiveData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.wink.editor.WinkMaterialViewModel;
import com.tencent.mobileqq.wink.editor.menu.MenuType;
import com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart;
import com.tencent.mobileqq.wink.event.ReceiveSchemaEvent;
import com.tencent.mobileqq.wink.flow.ApplyMaterialTask;
import com.tencent.mobileqq.wink.view.WinkMaterialPanelCategoryAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WinkEditorStickerMenuPart
  extends WinkEditorMenuPart
  implements SimpleEventReceiver
{
  private RecyclerView g;
  private GridLayoutManager h;
  private WinkMaterialPanelCategoryAdapter i;
  private StickerMaterialPanelContentAdapter j;
  private BottomSheetBehavior<LinearLayout> k;
  private final List<MetaCategory> l = new ArrayList();
  private final List<MetaMaterial> m = new ArrayList();
  private boolean n;
  
  private void b(View paramView)
  {
    int i1 = DisplayUtil.a(g()).b;
    ((CoordinatorLayout)paramView.findViewById(2131431417)).getLayoutParams().height = ((int)(i1 * 2.0F / 3.0F));
    this.k = BottomSheetBehavior.b(paramView.findViewById(2131431328));
    this.k.b(new WinkEditorStickerMenuPart.2(this));
  }
  
  private void d(View paramView)
  {
    paramView = (RecyclerView)paramView.findViewById(2131430391);
    paramView.setLayoutManager(new LinearLayoutManager(g(), 0, false));
    paramView.setNestedScrollingEnabled(false);
    paramView.setAdapter(this.i);
  }
  
  private void e(View paramView)
  {
    this.g = ((RecyclerView)paramView.findViewById(2131431335));
    this.h = new GridLayoutManager(g(), 4);
    this.g.setLayoutManager(this.h);
    this.g.addOnScrollListener(new WinkEditorStickerMenuPart.3(this));
    this.g.addItemDecoration(new StickerMaterialPanelContentDecoration(g(), this.m));
    this.g.setAdapter(this.j);
  }
  
  private ApplyMaterialTask s()
  {
    return new WinkEditorStickerMenuPart.4(this);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.j = new StickerMaterialPanelContentAdapter(g());
    this.j.a(this.m);
    this.j.a(s());
    this.i = new WinkMaterialPanelCategoryAdapter(this.l, new WinkEditorStickerMenuPart.1(this));
    p().getStickerMaterialVOLiveData().observe(j(), new -..Lambda.WinkEditorStickerMenuPart.NesBfbyAWdFtWfDEi3PU6uS-NXg(this));
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  protected void c(View paramView)
  {
    super.c(paramView);
    b(paramView);
    d(paramView);
    e(paramView);
  }
  
  public int d()
  {
    return 2131446387;
  }
  
  @NonNull
  public MenuType e()
  {
    return MenuType.STICKER;
  }
  
  public void f()
  {
    super.f();
    this.k.d(3);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ReceiveSchemaEvent.class);
    return localArrayList;
  }
  
  public void n()
  {
    if (!this.f) {
      return;
    }
    if (this.k.d() != 4)
    {
      this.k.d(4);
      return;
    }
    super.n();
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
    if ((paramSimpleBaseEvent instanceof ReceiveSchemaEvent))
    {
      paramSimpleBaseEvent = (HashMap)((ReceiveSchemaEvent)paramSimpleBaseEvent).getAttrs();
      if ((paramSimpleBaseEvent != null) && (!paramSimpleBaseEvent.isEmpty()) && (paramSimpleBaseEvent.containsKey("sticker")) && (!TextUtils.isEmpty((CharSequence)paramSimpleBaseEvent.get("sticker"))))
      {
        StickerMaterialPanelContentAdapter localStickerMaterialPanelContentAdapter = this.j;
        if (localStickerMaterialPanelContentAdapter != null) {
          localStickerMaterialPanelContentAdapter.a((String)paramSimpleBaseEvent.get("sticker"));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.sticker.WinkEditorStickerMenuPart
 * JD-Core Version:    0.7.0.1
 */