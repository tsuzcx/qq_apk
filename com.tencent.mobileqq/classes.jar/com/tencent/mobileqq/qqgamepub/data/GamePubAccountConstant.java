package com.tencent.mobileqq.qqgamepub.data;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.qqgamepub.utils.UIUtils;
import com.tencent.qphone.base.util.QLog;

public class GamePubAccountConstant
{
  public static boolean a = true;
  
  public static StateListDrawable a(Context paramContext)
  {
    Object localObject1 = new Drawable[3];
    float f1 = UIUtils.a(4.0F, paramContext.getResources());
    float f2 = UIUtils.a(4.0F, paramContext.getResources());
    float f3 = UIUtils.a(4.0F, paramContext.getResources());
    float f4 = UIUtils.a(4.0F, paramContext.getResources());
    int i = 0;
    while (i < 2)
    {
      localObject2 = new RoundRectShape(new float[] { f1, f1, f2, f2, f3, f3, f4, f4 }, null, null);
      localShapeDrawable = new ShapeDrawable();
      localShapeDrawable.setPadding(UIUtils.a(2.0F, paramContext.getResources()), UIUtils.a(0.0F, paramContext.getResources()), UIUtils.a(2.0F, paramContext.getResources()), UIUtils.a(2.0F, paramContext.getResources()));
      localShapeDrawable.setShape((Shape)localObject2);
      localShapeDrawable.getPaint().setStyle(Paint.Style.FILL);
      localShapeDrawable.getPaint().setColor(83886080);
      localObject1[i] = localShapeDrawable;
      i += 1;
    }
    Object localObject2 = new float[8];
    localObject2[0] = f1;
    localObject2[1] = f1;
    localObject2[2] = f2;
    localObject2[3] = f2;
    localObject2[4] = f3;
    localObject2[5] = f3;
    localObject2[6] = f4;
    localObject2[7] = f4;
    paramContext = new RoundRectShape((float[])localObject2, null, null);
    ShapeDrawable localShapeDrawable = new ShapeDrawable();
    localShapeDrawable.setShape(paramContext);
    localShapeDrawable.getPaint().setStyle(Paint.Style.FILL);
    localShapeDrawable.getPaint().setColor(-1);
    localObject1[2] = localShapeDrawable;
    paramContext = new LayerDrawable((Drawable[])localObject1);
    localObject2 = new RoundRectShape((float[])localObject2, null, null);
    localShapeDrawable = new ShapeDrawable();
    localShapeDrawable.setShape((Shape)localObject2);
    localShapeDrawable.getPaint().setStyle(Paint.Style.FILL);
    localShapeDrawable.getPaint().setColor(-526345);
    localObject1[2] = localShapeDrawable;
    localObject1 = new LayerDrawable((Drawable[])localObject1);
    localObject2 = new StateListDrawable();
    ((StateListDrawable)localObject2).addState(new int[] { 16842919 }, (Drawable)localObject1);
    ((StateListDrawable)localObject2).addState(new int[] { 16842910 }, paramContext);
    return localObject2;
  }
  
  public static StateListDrawable a(Drawable paramDrawable1, Drawable paramDrawable2, String paramString1, String paramString2)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = paramDrawable1;
    localURLDrawableOptions.mFailedDrawable = paramDrawable1;
    paramDrawable1 = URLDrawable.getDrawable(paramString1, localURLDrawableOptions);
    paramString1 = URLDrawable.URLDrawableOptions.obtain();
    paramString1.mLoadingDrawable = paramDrawable2;
    paramString1.mFailedDrawable = paramDrawable2;
    paramDrawable2 = URLDrawable.getDrawable(paramString2, paramString1);
    paramString1 = new StateListDrawable();
    paramString1.addState(new int[] { 16842919 }, paramDrawable2);
    paramString1.addState(new int[] { 16842910 }, paramDrawable1);
    return paramString1;
  }
  
  public static StateListDrawable a(String paramString1, String paramString2, Context paramContext)
  {
    paramString1 = URLDrawable.getDrawable(paramString1, paramContext.getResources().getDrawable(2130852171), paramContext.getResources().getDrawable(2130852171));
    paramString2 = URLDrawable.getDrawable(paramString2);
    paramContext = new StateListDrawable();
    paramContext.addState(new int[] { 16842919 }, paramString1);
    paramContext.addState(new int[] { 16842908 }, paramString2);
    paramContext.addState(new int[] { 16842910 }, paramString2);
    paramContext.addState(new int[0], paramString2);
    return paramContext;
  }
  
  public static String a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("pubAccountAppid"))) {
      try
      {
        paramString = Uri.parse(paramString).getQueryParameter("pubAccountAppid");
        return paramString;
      }
      catch (Exception paramString)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getappid error=");
        localStringBuilder.append(paramString.toString());
        QLog.e("QQGamePub_", 1, localStringBuilder.toString());
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.data.GamePubAccountConstant
 * JD-Core Version:    0.7.0.1
 */