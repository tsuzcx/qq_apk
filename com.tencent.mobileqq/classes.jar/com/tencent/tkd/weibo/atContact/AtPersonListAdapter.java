package com.tencent.tkd.weibo.atContact;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.tkd.weibo.R.layout;
import com.tencent.tkd.weibo.UiComponentSdkKt;
import com.tencent.tkd.weibo.bean.AtPersonItem;
import com.tencent.tkd.weibo.framework.ImageLoader;
import com.tencent.tkd.weibo.framework.ImageLoader.Companion;
import com.tencent.tkd.weibo.framework.color.IComponentColorStrategy;
import com.tencent.tkd.weibo.framework.mvp.BaseListAdapter;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/weibo/atContact/AtPersonListAdapter;", "Lcom/tencent/tkd/weibo/framework/mvp/BaseListAdapter;", "Lcom/tencent/tkd/weibo/bean/AtPersonItem;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getView", "Landroid/view/View;", "position", "", "convertView", "parent", "Landroid/view/ViewGroup;", "ViewHolder", "tkd-weibo-component_release"}, k=1, mv={1, 1, 16})
public final class AtPersonListAdapter
  extends BaseListAdapter<AtPersonItem>
{
  private final Context a;
  
  @NotNull
  public View getView(int paramInt, @Nullable View paramView, @Nullable ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a).inflate(R.layout.a, paramViewGroup, false);
      Intrinsics.checkExpressionValueIsNotNull(paramView, "LayoutInflater.from(cont…_contract, parent, false)");
      if (paramView == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
      }
      paramViewGroup = new AtPersonListAdapter.ViewHolder((ViewGroup)paramView);
      ((ViewGroup)paramView).setTag(paramViewGroup);
    }
    for (;;)
    {
      AtPersonItem localAtPersonItem = (AtPersonItem)getItem(paramInt);
      ImageLoader.Companion.a(ImageLoader.a, this.a, null, 2, null).a(36, 36).a().a(18).a(paramViewGroup.a()).a(localAtPersonItem.a());
      paramViewGroup.a().setText((CharSequence)localAtPersonItem.b());
      paramViewGroup.a().setTextColor(this.a.getResources().getColor(UiComponentSdkKt.a().a()));
      paramViewGroup.a().setBackgroundColor(this.a.getResources().getColor(UiComponentSdkKt.a().b()));
      return paramView;
      paramViewGroup = paramView.getTag();
      if (paramViewGroup == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.tkd.weibo.atContact.AtPersonListAdapter.ViewHolder");
      }
      paramViewGroup = (AtPersonListAdapter.ViewHolder)paramViewGroup;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.weibo.atContact.AtPersonListAdapter
 * JD-Core Version:    0.7.0.1
 */