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
  private View jdField_a_of_type_AndroidViewView;
  @NotNull
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  @NotNull
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  
  public AtPersonListAdapter$ViewHolder(@NotNull ViewGroup paramViewGroup)
  {
    View localView = paramViewGroup.findViewById(R.id.e);
    Intrinsics.checkExpressionValueIsNotNull(localView, "layout.findViewById(R.id.img_avatar)");
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView);
    localView = paramViewGroup.findViewById(R.id.o);
    Intrinsics.checkExpressionValueIsNotNull(localView, "layout.findViewById(R.id.tv_name)");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView);
    paramViewGroup = paramViewGroup.findViewById(R.id.r);
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "layout.findViewById(R.id.view_divider)");
    this.jdField_a_of_type_AndroidViewView = paramViewGroup;
  }
  
  @NotNull
  public final View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  @NotNull
  public final ImageView a()
  {
    return this.jdField_a_of_type_AndroidWidgetImageView;
  }
  
  @NotNull
  public final TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.weibo.atContact.AtPersonListAdapter.ViewHolder
 * JD-Core Version:    0.7.0.1
 */