package com.tencent.mobileqq.profilecard.bussiness.favor.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.util.Utils;

class ProfileCardFavorItemDetailView$Label
  extends TextView
{
  public ProfileCardFavorItemDetailView$Label(ProfileCardFavorItemDetailView paramProfileCardFavorItemDetailView, Context paramContext, Drawable paramDrawable, String paramString, int paramInt)
  {
    super(paramContext);
    setTextSize(1, 11.0F);
    setTextColor(-1);
    if (paramDrawable != null)
    {
      paramProfileCardFavorItemDetailView = new StringBuilder();
      paramProfileCardFavorItemDetailView.append("[icon] ");
      paramProfileCardFavorItemDetailView.append(paramString);
      paramProfileCardFavorItemDetailView = paramProfileCardFavorItemDetailView.toString();
      double d = Utils.a(11.0F, getResources());
      Double.isNaN(d);
      int i = (int)(d * 0.8D + 0.5D);
      paramDrawable.setBounds(0, 0, i, i);
      paramProfileCardFavorItemDetailView = new SpannableString(paramProfileCardFavorItemDetailView);
      paramProfileCardFavorItemDetailView.setSpan(new ImageSpan(paramDrawable, 1), 0, 6, 17);
    }
    else
    {
      paramProfileCardFavorItemDetailView = new SpannableString(paramString);
    }
    setText(paramProfileCardFavorItemDetailView);
    paramProfileCardFavorItemDetailView = new GradientDrawable();
    paramProfileCardFavorItemDetailView.setColor(paramInt);
    paramProfileCardFavorItemDetailView.setCornerRadius(8.0F);
    setBackgroundDrawable(paramProfileCardFavorItemDetailView);
    setPadding(Utils.a(4.0F, getResources()), 0, Utils.a(4.0F, getResources()), 0);
    setLayoutParams(new ViewGroup.LayoutParams(-2, Utils.a(15.0F, getResources())));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.favor.view.ProfileCardFavorItemDetailView.Label
 * JD-Core Version:    0.7.0.1
 */