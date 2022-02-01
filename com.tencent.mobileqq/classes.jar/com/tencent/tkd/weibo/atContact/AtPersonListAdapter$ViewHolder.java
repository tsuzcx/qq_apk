package com.tencent.tkd.weibo.atContact;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.tkd.weibo.component.R.id;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/weibo/atContact/AtPersonListAdapter$ViewHolder;", "", "layout", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "avatarView", "Landroid/widget/ImageView;", "getAvatarView", "()Landroid/widget/ImageView;", "setAvatarView", "(Landroid/widget/ImageView;)V", "dividerView", "Landroid/view/View;", "getDividerView", "()Landroid/view/View;", "setDividerView", "(Landroid/view/View;)V", "nameView", "Landroid/widget/TextView;", "getNameView", "()Landroid/widget/TextView;", "setNameView", "(Landroid/widget/TextView;)V", "tkd-weibo-component_release"}, k=1, mv={1, 1, 16})
public class AtPersonListAdapter$ViewHolder
{
  @NotNull
  private ImageView a;
  @NotNull
  private TextView b;
  @NotNull
  private View c;
  
  public AtPersonListAdapter$ViewHolder(@NotNull ViewGroup paramViewGroup)
  {
    View localView = paramViewGroup.findViewById(R.id.b);
    Intrinsics.checkExpressionValueIsNotNull(localView, "layout.findViewById(R.id.img_avatar)");
    this.a = ((ImageView)localView);
    localView = paramViewGroup.findViewById(R.id.j);
    Intrinsics.checkExpressionValueIsNotNull(localView, "layout.findViewById(R.id.tv_name)");
    this.b = ((TextView)localView);
    paramViewGroup = paramViewGroup.findViewById(R.id.n);
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "layout.findViewById(R.id.view_divider)");
    this.c = paramViewGroup;
  }
  
  @NotNull
  public final ImageView a()
  {
    return this.a;
  }
  
  @NotNull
  public final TextView b()
  {
    return this.b;
  }
  
  @NotNull
  public final View c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.weibo.atContact.AtPersonListAdapter.ViewHolder
 * JD-Core Version:    0.7.0.1
 */