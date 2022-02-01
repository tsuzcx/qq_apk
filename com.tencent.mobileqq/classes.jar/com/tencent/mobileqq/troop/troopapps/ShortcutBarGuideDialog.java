package com.tencent.mobileqq.troop.troopapps;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class ShortcutBarGuideDialog
  extends ReportDialog
{
  private static String a = "https://sola.gtimg.cn/aoi/sola/20200515111445_ChpLurYZBA.png";
  
  public ShortcutBarGuideDialog(Context paramContext)
  {
    super(paramContext, 2131755340);
    a();
  }
  
  private void a()
  {
    setCancelable(false);
    setCanceledOnTouchOutside(false);
    setContentView(2131558983);
    Object localObject1 = (URLImageView)findViewById(2131368461);
    Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
    ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#FFEBEDF5"));
    ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = localColorDrawable;
    ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = localColorDrawable;
    ((URLImageView)localObject1).setBackgroundDrawable(URLDrawable.getDrawable(a, (URLDrawable.URLDrawableOptions)localObject2));
    localObject1 = (TextView)findViewById(2131369690);
    ((TextView)localObject1).setClickable(true);
    localObject2 = new GradientDrawable();
    ((GradientDrawable)localObject2).setCornerRadius(12.0F);
    ((GradientDrawable)localObject2).setColor(-1315339);
    ((TextView)localObject1).setBackgroundDrawable((Drawable)localObject2);
    ((TextView)localObject1).setOnClickListener(new ShortcutBarGuideDialog.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.ShortcutBarGuideDialog
 * JD-Core Version:    0.7.0.1
 */