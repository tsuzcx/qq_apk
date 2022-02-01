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
  private int jdField_a_of_type_Int;
  @NotNull
  private final View jdField_a_of_type_AndroidViewView;
  private final ImageView jdField_a_of_type_AndroidWidgetImageView;
  private final TextView jdField_a_of_type_AndroidWidgetTextView;
  private final EcshopConfBean.TabConfBean jdField_a_of_type_ComTencentMobileqqEcshopConfEcshopConfBean$TabConfBean;
  private final ImageView b;
  
  public TabItemController(@NotNull EcshopConfBean.TabConfBean paramTabConfBean, @NotNull ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentMobileqqEcshopConfEcshopConfBean$TabConfBean = paramTabConfBean;
    paramTabConfBean = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561892, paramViewGroup, false);
    Intrinsics.checkExpressionValueIsNotNull(paramTabConfBean, "LayoutInflater.from(pare…_tab_item, parent, false)");
    this.jdField_a_of_type_AndroidViewView = paramTabConfBean;
    paramTabConfBean = this.jdField_a_of_type_AndroidViewView.findViewById(2131379740);
    Intrinsics.checkExpressionValueIsNotNull(paramTabConfBean, "itemView.findViewById(R.id.tv_item_title)");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramTabConfBean);
    paramTabConfBean = this.jdField_a_of_type_AndroidViewView.findViewById(2131368663);
    Intrinsics.checkExpressionValueIsNotNull(paramTabConfBean, "itemView.findViewById(R.id.img_item_icon)");
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramTabConfBean);
    paramTabConfBean = this.jdField_a_of_type_AndroidViewView.findViewById(2131368664);
    Intrinsics.checkExpressionValueIsNotNull(paramTabConfBean, "itemView.findViewById(R.id.img_item_red_point)");
    this.b = ((ImageView)paramTabConfBean);
    a(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)this.jdField_a_of_type_ComTencentMobileqqEcshopConfEcshopConfBean$TabConfBean.jdField_a_of_type_JavaLangString);
  }
  
  private final void a(String paramString, int paramInt)
  {
    if (paramInt == 1)
    {
      Object localObject = this.b.getLayoutParams();
      if (localObject != null)
      {
        localObject = (RelativeLayout.LayoutParams)localObject;
        ((RelativeLayout.LayoutParams)localObject).width = DisplayUtil.a(this.jdField_a_of_type_AndroidViewView.getContext(), 63.0F);
        ((RelativeLayout.LayoutParams)localObject).height = DisplayUtil.a(this.jdField_a_of_type_AndroidViewView.getContext(), 18.0F);
        ((RelativeLayout.LayoutParams)localObject).topMargin = (-DisplayUtil.a(this.jdField_a_of_type_AndroidViewView.getContext(), 3.0F));
        ((RelativeLayout.LayoutParams)localObject).leftMargin = (-DisplayUtil.a(this.jdField_a_of_type_AndroidViewView.getContext(), 10.0F));
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      }
    }
    paramString = QQShopPicUtil.a(paramString, null);
    if (paramString != null) {
      this.b.setImageDrawable((Drawable)paramString);
    }
  }
  
  @NotNull
  public final View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public final void a()
  {
    if (this.jdField_a_of_type_Int != 0)
    {
      this.b.setVisibility(8);
      QQShopRedPointUtil.a(this.jdField_a_of_type_ComTencentMobileqqEcshopConfEcshopConfBean$TabConfBean.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
    }
  }
  
  public final void a(@NotNull RedPointInfo paramRedPointInfo, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramRedPointInfo, "redPointInfo");
    this.b.postDelayed((Runnable)new TabItemController.showRedPointView.1(this, paramRedPointInfo), paramLong);
  }
  
  public final void a(boolean paramBoolean)
  {
    String str;
    if (paramBoolean)
    {
      str = this.jdField_a_of_type_ComTencentMobileqqEcshopConfEcshopConfBean$TabConfBean.f;
      Intrinsics.checkExpressionValueIsNotNull(str, "tabConfBean.textcolorSelected");
      localObject = this.jdField_a_of_type_ComTencentMobileqqEcshopConfEcshopConfBean$TabConfBean.d;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "tabConfBean.iconSelected");
      this.b.setVisibility(8);
    }
    else
    {
      str = this.jdField_a_of_type_ComTencentMobileqqEcshopConfEcshopConfBean$TabConfBean.e;
      Intrinsics.checkExpressionValueIsNotNull(str, "tabConfBean.textcolorNormal");
      localObject = this.jdField_a_of_type_ComTencentMobileqqEcshopConfEcshopConfBean$TabConfBean.c;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "tabConfBean.iconNormal");
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(str));
    Object localObject = QQShopPicUtil.a((String)localObject, URLDrawableHelperConstants.a);
    if (localObject != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.controller.TabItemController
 * JD-Core Version:    0.7.0.1
 */