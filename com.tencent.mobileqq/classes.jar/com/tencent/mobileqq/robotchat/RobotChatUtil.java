package com.tencent.mobileqq.robotchat;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.ThemeURLImageView;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

public class RobotChatUtil
{
  private static String jdField_a_of_type_JavaLangString = "";
  private static WeakReference<Drawable> jdField_a_of_type_JavaLangRefWeakReference;
  
  public static Drawable a(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    return paramContext.getResources().getDrawable(2130846369);
  }
  
  private static Drawable a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    paramQQAppInterface = jdField_a_of_type_JavaLangRefWeakReference;
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = (Drawable)paramQQAppInterface.get();
      if (paramQQAppInterface != null)
      {
        if ((TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) || (!jdField_a_of_type_JavaLangString.equals(ThemeUtil.curThemeId)))
        {
          ThemeUtil.setThemeFilter(paramQQAppInterface, ThemeUtil.curThemeId);
          jdField_a_of_type_JavaLangString = ThemeUtil.curThemeId;
        }
        return paramQQAppInterface;
      }
    }
    paramContext = a(paramContext);
    paramQQAppInterface = paramContext;
    if (paramContext != null)
    {
      paramQQAppInterface = paramContext.getConstantState().newDrawable().mutate();
      ThemeUtil.setThemeFilter(paramQQAppInterface, ThemeUtil.curThemeId);
      jdField_a_of_type_JavaLangString = ThemeUtil.curThemeId;
      jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    }
    return paramQQAppInterface;
  }
  
  public static ThemeURLImageView a(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    Drawable localDrawable = a(paramContext);
    if (localDrawable == null) {
      return null;
    }
    paramContext = new ThemeURLImageView(paramContext);
    paramContext.setContentDescription("BOT");
    paramContext.setImageDrawable(localDrawable);
    return paramContext;
  }
  
  public static void a(Context paramContext, SingleLineTextView paramSingleLineTextView, String paramString)
  {
    if ((paramSingleLineTextView != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (paramContext == null) {
        return;
      }
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = (QQAppInterface)localObject;
        if (RobotUtils.a((QQAppInterface)localObject, paramString))
        {
          paramString = a((QQAppInterface)localObject, paramContext);
          if (paramString == null) {
            return;
          }
          paramSingleLineTextView.setCompoundDrawablePadding((int)DisplayUtils.a(paramContext, 5.0F));
          paramSingleLineTextView.setDrawableRight2WithIntrinsicBounds(paramString);
          return;
        }
      }
      paramSingleLineTextView.setDrawableRight2WithIntrinsicBounds(null);
    }
  }
  
  public static boolean a(String paramString)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    return ((localAppRuntime instanceof QQAppInterface)) && (RobotUtils.a((QQAppInterface)localAppRuntime, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.robotchat.RobotChatUtil
 * JD-Core Version:    0.7.0.1
 */