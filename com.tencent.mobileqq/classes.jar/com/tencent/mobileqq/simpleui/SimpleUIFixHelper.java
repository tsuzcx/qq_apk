package com.tencent.mobileqq.simpleui;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.QQTheme;

public class SimpleUIFixHelper
{
  public static void a(Dialog paramDialog)
  {
    if (!QQTheme.isNowSimpleUI()) {
      return;
    }
    if (paramDialog == null) {
      return;
    }
    Context localContext = paramDialog.getContext();
    if (localContext == null) {
      return;
    }
    Resources localResources = localContext.getResources();
    if (localResources == null) {
      return;
    }
    Object localObject = paramDialog.findViewById(2131433638);
    if (localObject == null) {
      paramDialog = paramDialog.findViewById(2131431871);
    } else {
      paramDialog = ((View)localObject).findViewById(2131431871);
    }
    if (paramDialog == null) {
      return;
    }
    localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setColor(localResources.getColor(2131168094));
    ((GradientDrawable)localObject).setCornerRadius(DisplayUtil.a(localContext, 4.0F));
    paramDialog.setBackgroundDrawable((Drawable)localObject);
  }
  
  public static void b(Dialog paramDialog)
  {
    if (!QQTheme.isNowSimpleUI()) {
      return;
    }
    if (paramDialog == null) {
      return;
    }
    Object localObject = paramDialog.getContext();
    if (localObject == null) {
      return;
    }
    localObject = ((Context)localObject).getResources();
    if (localObject == null) {
      return;
    }
    TextView localTextView = (TextView)paramDialog.findViewById(2131431880);
    if (localTextView != null) {
      localTextView.setTextColor(((Resources)localObject).getColor(2131165784));
    }
    localTextView = (TextView)paramDialog.findViewById(2131431876);
    if (localTextView != null) {
      localTextView.setTextColor(((Resources)localObject).getColor(2131165784));
    }
    localTextView = (TextView)paramDialog.findViewById(2131431878);
    if (localTextView != null) {
      localTextView.setTextColor(((Resources)localObject).getColor(2131165784));
    }
    localTextView = (TextView)paramDialog.findViewById(2131431852);
    if (localTextView != null) {
      localTextView.setTextColor(((Resources)localObject).getColor(2131165784));
    }
    localTextView = (TextView)paramDialog.findViewById(2131431864);
    if (localTextView != null) {
      localTextView.setTextColor(((Resources)localObject).getColor(2131165784));
    }
    paramDialog = (TextView)paramDialog.findViewById(2131431870);
    if (paramDialog != null) {
      paramDialog.setTextColor(((Resources)localObject).getColor(2131165784));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.simpleui.SimpleUIFixHelper
 * JD-Core Version:    0.7.0.1
 */