package com.tencent.mobileqq.ecshop.view.controller;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.ecshop.conf.EcshopConfBean.TabConfBean;
import com.tencent.mobileqq.ecshop.redpoint.QQShopRedPointUtil;
import com.tencent.mobileqq.ecshop.redpoint.RedPointInfo;
import com.tencent.mobileqq.ecshop.utils.QQShopPicUtil;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.util.DisplayUtil;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/ecshop/view/controller/TabItemController;", "", "tabConfBean", "Lcom/tencent/mobileqq/ecshop/conf/EcshopConfBean$TabConfBean;", "parent", "Landroid/view/ViewGroup;", "(Lcom/tencent/mobileqq/ecshop/conf/EcshopConfBean$TabConfBean;Landroid/view/ViewGroup;)V", "iconImg", "Landroid/widget/ImageView;", "itemView", "Landroid/view/View;", "getItemView", "()Landroid/view/View;", "redPointImg", "redPointTaskId", "", "titleView", "Landroid/widget/TextView;", "disableClipOnParents", "", "v", "redPointClick", "showRedPointView", "redPointInfo", "Lcom/tencent/mobileqq/ecshop/redpoint/RedPointInfo;", "delay", "", "showRedPointViewByUrl", "redPointUrl", "", "redType", "updateTabStatus", "isSelect", "", "qqshop-feature-impl_release"}, k=1, mv={1, 1, 16})
public final class TabItemController
{
  @NotNull
  private final View a;
  private final TextView b;
  private final ImageView c;
  private final ImageView d;
  private int e;
  private final EcshopConfBean.TabConfBean f;
  
  public TabItemController(@NotNull EcshopConfBean.TabConfBean paramTabConfBean, @NotNull ViewGroup paramViewGroup)
  {
    this.f = paramTabConfBean;
    paramTabConfBean = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131628310, paramViewGroup, false);
    Intrinsics.checkExpressionValueIsNotNull(paramTabConfBean, "LayoutInflater.from(pare…_tab_item, parent, false)");
    this.a = paramTabConfBean;
    paramTabConfBean = this.a.findViewById(2131448545);
    Intrinsics.checkExpressionValueIsNotNull(paramTabConfBean, "itemView.findViewById(R.id.tv_item_title)");
    this.b = ((TextView)paramTabConfBean);
    paramTabConfBean = this.a.findViewById(2131435576);
    Intrinsics.checkExpressionValueIsNotNull(paramTabConfBean, "itemView.findViewById(R.id.img_item_icon)");
    this.c = ((ImageView)paramTabConfBean);
    paramTabConfBean = this.a.findViewById(2131435577);
    Intrinsics.checkExpressionValueIsNotNull(paramTabConfBean, "itemView.findViewById(R.id.img_item_red_point)");
    this.d = ((ImageView)paramTabConfBean);
    a(false);
    this.b.setText((CharSequence)this.f.c);
  }
  
  private final void a(String paramString, int paramInt)
  {
    if (paramInt == 1)
    {
      Object localObject = this.d.getLayoutParams();
      if (localObject != null)
      {
        localObject = (RelativeLayout.LayoutParams)localObject;
        ((RelativeLayout.LayoutParams)localObject).width = DisplayUtil.a(this.a.getContext(), 63.0F);
        ((RelativeLayout.LayoutParams)localObject).height = DisplayUtil.a(this.a.getContext(), 18.0F);
        ((RelativeLayout.LayoutParams)localObject).topMargin = (-DisplayUtil.a(this.a.getContext(), 3.0F));
        ((RelativeLayout.LayoutParams)localObject).leftMargin = (-DisplayUtil.a(this.a.getContext(), 10.0F));
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      }
    }
    paramString = QQShopPicUtil.a(paramString, null);
    if (paramString != null) {
      this.d.setImageDrawable((Drawable)paramString);
    }
  }
  
  @NotNull
  public final View a()
  {
    return this.a;
  }
  
  public final void a(@NotNull RedPointInfo paramRedPointInfo, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramRedPointInfo, "redPointInfo");
    this.d.postDelayed((Runnable)new TabItemController.showRedPointView.1(this, paramRedPointInfo), paramLong);
  }
  
  public final void a(boolean paramBoolean)
  {
    String str;
    if (paramBoolean)
    {
      str = this.f.h;
      Intrinsics.checkExpressionValueIsNotNull(str, "tabConfBean.textcolorSelected");
      localObject = this.f.f;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "tabConfBean.iconSelected");
      this.d.setVisibility(8);
    }
    else
    {
      str = this.f.g;
      Intrinsics.checkExpressionValueIsNotNull(str, "tabConfBean.textcolorNormal");
      localObject = this.f.e;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "tabConfBean.iconNormal");
    }
    this.b.setTextColor(Color.parseColor(str));
    Object localObject = QQShopPicUtil.a((String)localObject, URLDrawableHelperConstants.a);
    if (localObject != null) {
      this.c.setImageDrawable((Drawable)localObject);
    }
  }
  
  public final void b()
  {
    if (this.e != 0)
    {
      this.d.setVisibility(8);
      QQShopRedPointUtil.b(this.f.b, this.e);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.controller.TabItemController
 * JD-Core Version:    0.7.0.1
 */