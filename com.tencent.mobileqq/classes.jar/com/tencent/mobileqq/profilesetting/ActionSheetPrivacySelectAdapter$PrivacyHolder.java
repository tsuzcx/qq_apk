package com.tencent.mobileqq.profilesetting;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.Metadata;
import kotlin.TypeCastException;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilesetting/ActionSheetPrivacySelectAdapter$PrivacyHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "checkIv", "Landroid/widget/ImageView;", "getCheckIv", "()Landroid/widget/ImageView;", "setCheckIv", "(Landroid/widget/ImageView;)V", "titleTv", "Landroid/widget/TextView;", "getTitleTv", "()Landroid/widget/TextView;", "setTitleTv", "(Landroid/widget/TextView;)V", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ActionSheetPrivacySelectAdapter$PrivacyHolder
  extends RecyclerView.ViewHolder
{
  @NotNull
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  @NotNull
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  
  public ActionSheetPrivacySelectAdapter$PrivacyHolder(@NotNull View paramView)
  {
    super(paramView);
    View localView = paramView.findViewById(2131378884);
    if (localView != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView);
      paramView = paramView.findViewById(2131364605);
      if (paramView != null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.widget.ImageView");
    }
    throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.ActionSheetPrivacySelectAdapter.PrivacyHolder
 * JD-Core Version:    0.7.0.1
 */