package com.tencent.mobileqq.c2cshortcutbar.store;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.av.utils.UITools;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.c2cshortcutbar.C2CShortcutAppInfo;
import com.tencent.mobileqq.troop.utils.TroopAppShortcutUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class C2CShortcutBarStoreView$C2CShortcutBarStoreAdapter
  extends RecyclerView.Adapter<C2CShortcutBarStoreView.C2CShortcutBarStoreViewHolder>
{
  public C2CShortcutBarStoreView$C2CShortcutBarStoreAdapter(C2CShortcutBarStoreView paramC2CShortcutBarStoreView) {}
  
  public C2CShortcutBarStoreView.C2CShortcutBarStoreViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131624348, paramViewGroup, false);
    return new C2CShortcutBarStoreView.C2CShortcutBarStoreViewHolder(this.a, paramViewGroup);
  }
  
  @SuppressLint({"RecyclerView"})
  public void a(C2CShortcutBarStoreView.C2CShortcutBarStoreViewHolder paramC2CShortcutBarStoreViewHolder, int paramInt)
  {
    C2CShortcutAppInfo localC2CShortcutAppInfo = (C2CShortcutAppInfo)C2CShortcutBarStoreView.f(this.a).get(paramInt);
    Object localObject = this.a.getContext();
    ImageView localImageView = paramC2CShortcutBarStoreViewHolder.b;
    String str = localC2CShortcutAppInfo.d;
    int i = localC2CShortcutAppInfo.i;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    TroopAppShortcutUtils.a((Context)localObject, localImageView, str, 19.0F, bool);
    paramC2CShortcutBarStoreViewHolder.c.setText(localC2CShortcutAppInfo.c);
    paramC2CShortcutBarStoreViewHolder.e.setText(localC2CShortcutAppInfo.f);
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
      paramC2CShortcutBarStoreViewHolder.c.setTextColor(Color.parseColor("#FFFFFF"));
    } else {
      paramC2CShortcutBarStoreViewHolder.c.setTextColor(Color.parseColor("#FF03081A"));
    }
    if ((localC2CShortcutAppInfo.m != null) && (localC2CShortcutAppInfo.m.size() > 0))
    {
      localObject = new Paint();
      ((Paint)localObject).setTextSize(ViewUtils.dpToPx(17.0F));
      float f1 = ViewUtils.getScreenWidth();
      float f2 = ((Paint)localObject).measureText(localC2CShortcutAppInfo.c);
      float f3 = UITools.a(this.a.getContext(), 72.0F);
      C2CShortcutBarStoreView.a(this.a, (int)(f1 - f2 - f3), paramC2CShortcutBarStoreViewHolder.d, localC2CShortcutAppInfo.m);
    }
    else
    {
      paramC2CShortcutBarStoreViewHolder.d.setVisibility(8);
    }
    paramC2CShortcutBarStoreViewHolder.a.setOnTouchListener(UITools.a);
    paramC2CShortcutBarStoreViewHolder.a.setOnClickListener(new C2CShortcutBarStoreView.C2CShortcutBarStoreAdapter.1(this, paramInt));
    EventCollector.getInstance().onRecyclerBindViewHolder(paramC2CShortcutBarStoreViewHolder, paramInt, getItemId(paramInt));
  }
  
  public int getItemCount()
  {
    return C2CShortcutBarStoreView.f(this.a).size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.c2cshortcutbar.store.C2CShortcutBarStoreView.C2CShortcutBarStoreAdapter
 * JD-Core Version:    0.7.0.1
 */