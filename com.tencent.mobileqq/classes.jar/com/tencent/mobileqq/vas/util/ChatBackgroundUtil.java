package com.tencent.mobileqq.vas.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.utils.DiySecureFileHelper;
import com.tencent.mobileqq.vas.theme.diy.ThemeDiyStyleLogic;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChatBackgroundUtil
{
  public static SharedPreferences a(Context paramContext, String paramString, int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("chat_background_path_");
    ((StringBuilder)localObject1).append(paramString);
    paramContext = paramContext.getSharedPreferences(((StringBuilder)localObject1).toString(), paramInt);
    if (DiySecureFileHelper.a("QQThemeChatBackgroundMigration", paramString) < 1)
    {
      localObject1 = paramContext.edit();
      int i = 0;
      paramInt = 0;
      QLog.d("DiySecureFileHelper", 1, "Move Chatbackground SharedPreferences");
      if (paramContext.getAll() != null)
      {
        Iterator localIterator = paramContext.getAll().entrySet().iterator();
        for (;;)
        {
          i = paramInt;
          if (!localIterator.hasNext()) {
            break;
          }
          Object localObject2 = (Map.Entry)localIterator.next();
          Object localObject3;
          Object localObject4;
          Object localObject5;
          if ((((Map.Entry)localObject2).getValue() instanceof String))
          {
            localObject3 = (String)((Map.Entry)localObject2).getValue();
            i = paramInt;
            if (localObject3 != null)
            {
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("/custom_background/");
              ((StringBuilder)localObject4).append(paramString);
              ((StringBuilder)localObject4).append("/");
              i = paramInt;
              if (((String)localObject3).contains(((StringBuilder)localObject4).toString()))
              {
                localObject4 = (String)((Map.Entry)localObject2).getKey();
                localObject5 = new StringBuilder();
                ((StringBuilder)localObject5).append("/custom_background/");
                ((StringBuilder)localObject5).append(paramString);
                ((StringBuilder)localObject5).append("/");
                localObject5 = ((StringBuilder)localObject5).toString();
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("/custom_background/");
                localStringBuilder.append(DiySecureFileHelper.a(paramString));
                localStringBuilder.append("/");
                ((SharedPreferences.Editor)localObject1).putString((String)localObject4, ((String)localObject3).replace((CharSequence)localObject5, localStringBuilder.toString()));
                i = 1;
              }
            }
            paramInt = i;
            if (localObject3 != null)
            {
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("/");
              ((StringBuilder)localObject4).append(paramString);
              ((StringBuilder)localObject4).append("/custom_background/");
              paramInt = i;
              if (((String)localObject3).contains(((StringBuilder)localObject4).toString()))
              {
                localObject2 = (String)((Map.Entry)localObject2).getKey();
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append("/");
                ((StringBuilder)localObject4).append(paramString);
                ((StringBuilder)localObject4).append("/custom_background/");
                localObject4 = ((StringBuilder)localObject4).toString();
                localObject5 = new StringBuilder();
                ((StringBuilder)localObject5).append("/custom_background/");
                ((StringBuilder)localObject5).append(DiySecureFileHelper.a(paramString));
                ((StringBuilder)localObject5).append("/");
                ((SharedPreferences.Editor)localObject1).putString((String)localObject2, ((String)localObject3).replace((CharSequence)localObject4, ((StringBuilder)localObject5).toString()));
              }
            }
          }
          else
          {
            for (;;)
            {
              paramInt = 1;
              break;
              localObject3 = (String)((Map.Entry)localObject2).getKey();
              i = paramInt;
              if (localObject3 != null)
              {
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append("/custom_background/");
                ((StringBuilder)localObject4).append(paramString);
                ((StringBuilder)localObject4).append("/");
                i = paramInt;
                if (((String)localObject3).contains(((StringBuilder)localObject4).toString())) {
                  if ((((Map.Entry)localObject2).getValue() instanceof Integer))
                  {
                    localObject4 = new StringBuilder();
                    ((StringBuilder)localObject4).append("/custom_background/");
                    ((StringBuilder)localObject4).append(paramString);
                    ((StringBuilder)localObject4).append("/");
                    localObject4 = ((StringBuilder)localObject4).toString();
                    localObject5 = new StringBuilder();
                    ((StringBuilder)localObject5).append("/custom_background/");
                    ((StringBuilder)localObject5).append(DiySecureFileHelper.a(paramString));
                    ((StringBuilder)localObject5).append("/");
                    ((SharedPreferences.Editor)localObject1).putInt(((String)localObject3).replace((CharSequence)localObject4, ((StringBuilder)localObject5).toString()), ((Integer)((Map.Entry)localObject2).getValue()).intValue());
                    i = 1;
                  }
                  else
                  {
                    localObject4 = new StringBuilder();
                    ((StringBuilder)localObject4).append("value not int : ");
                    ((StringBuilder)localObject4).append(((Map.Entry)localObject2).getValue());
                    QLog.e("DiySecureFileHelper", 1, ((StringBuilder)localObject4).toString());
                    i = paramInt;
                  }
                }
              }
              paramInt = i;
              if (localObject3 == null) {
                break;
              }
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("/");
              ((StringBuilder)localObject4).append(paramString);
              ((StringBuilder)localObject4).append("/custom_background/");
              paramInt = i;
              if (!((String)localObject3).contains(((StringBuilder)localObject4).toString())) {
                break;
              }
              if (!(((Map.Entry)localObject2).getValue() instanceof Integer)) {
                break label883;
              }
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("/");
              ((StringBuilder)localObject4).append(paramString);
              ((StringBuilder)localObject4).append("/custom_background/");
              localObject4 = ((StringBuilder)localObject4).toString();
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append("/custom_background/");
              ((StringBuilder)localObject5).append(DiySecureFileHelper.a(paramString));
              ((StringBuilder)localObject5).append("/");
              ((SharedPreferences.Editor)localObject1).putInt(((String)localObject3).replace((CharSequence)localObject4, ((StringBuilder)localObject5).toString()), ((Integer)((Map.Entry)localObject2).getValue()).intValue());
            }
            label883:
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("value not int : ");
            ((StringBuilder)localObject3).append(((Map.Entry)localObject2).getValue());
            QLog.e("DiySecureFileHelper", 1, ((StringBuilder)localObject3).toString());
            paramInt = i;
          }
        }
      }
      QLog.e("DiySecureFileHelper", 1, "sf.getAll is null");
      if (i != 0) {
        ((SharedPreferences.Editor)localObject1).commit();
      }
      DiySecureFileHelper.a("QQThemeChatBackgroundMigration", paramString, 1);
    }
    return paramContext;
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("chat_background_path_");
    localStringBuilder.append(paramString1);
    paramString1 = paramContext.getSharedPreferences(localStringBuilder.toString(), 4);
    if (TextUtils.isEmpty(paramString2))
    {
      paramContext = paramString1.getString("chat_uniform_bg", null);
      if (TextUtils.isEmpty(paramContext)) {
        return "null";
      }
      return ThemeDiyStyleLogic.a(paramContext);
    }
    paramContext = paramString1.getString(paramString2, null);
    if (paramContext == null)
    {
      paramString1 = paramString1.getString("chat_uniform_bg", null);
      paramContext = paramString1;
      if (paramString1 == null) {
        paramContext = "null";
      }
    }
    if ((paramContext != null) && (paramContext.trim().length() != 0))
    {
      if (paramContext.equals("null")) {
        return "null";
      }
      if (paramContext.equals("none")) {
        return "null";
      }
      return ThemeDiyStyleLogic.a(paramContext);
    }
    return "null";
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.PATH_SYSTEM_BACKGROUND_RESOURCE);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(a(paramString));
      localStringBuilder.append(File.separatorChar);
      localStringBuilder.append("aioImage");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ThemeDiyStyleLogic.b());
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static final void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    a(paramContext, paramString1, paramString2, paramString3, -1);
  }
  
  public static final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    a(paramContext, paramString1, paramString2, paramString3, 0, paramInt);
  }
  
  public static final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatBackgroundUtil", 1, new Throwable(), new Object[0]);
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("setChatBackground, friendUin=");
    ((StringBuilder)localObject1).append(TextUtils.isEmpty(paramString2) ^ true);
    ((StringBuilder)localObject1).append(", path=");
    ((StringBuilder)localObject1).append(paramString3);
    QLog.d("ChatBackgroundUtil", 1, ((StringBuilder)localObject1).toString());
    paramString1 = a(paramContext, paramString1, 4);
    paramContext = paramString1.edit();
    if (paramString2 == null)
    {
      paramContext.putString("chat_uniform_bg", paramString3);
      paramContext.putInt("_chat_bg_effect", paramInt1);
      paramString2 = paramString1.getAll();
      if (paramString2 != null)
      {
        paramString2 = paramString2.keySet().iterator();
        while (paramString2.hasNext())
        {
          localObject1 = (String)paramString2.next();
          if (Pattern.compile("[0-9]*").matcher((CharSequence)localObject1).matches())
          {
            Object localObject2 = paramString1.getString((String)localObject1, "null");
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append("_is_c2c_set");
            boolean bool = paramString1.getBoolean(localStringBuilder.toString(), false);
            if ((localObject2 == null) || (((String)localObject2).trim().length() == 0) || (((String)localObject2).equals("null")) || (((String)localObject2).equals("none")) || (!bool))
            {
              paramContext.putString((String)localObject1, paramString3);
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append((String)localObject1);
              ((StringBuilder)localObject2).append("_chat_bg_effect");
              paramContext.putInt(((StringBuilder)localObject2).toString(), paramInt1);
            }
          }
        }
      }
    }
    else
    {
      paramContext.putString(paramString2, paramString3);
      paramString1 = new StringBuilder();
      paramString1.append(paramString2);
      paramString1.append("_uinType");
      paramContext.putInt(paramString1.toString(), paramInt2);
      if (paramString3.equals("null"))
      {
        paramString1 = new StringBuilder();
        paramString1.append(paramString2);
        paramString1.append("_is_c2c_set");
        paramContext.putBoolean(paramString1.toString(), false);
        paramString1 = new StringBuilder();
        paramString1.append(paramString2);
        paramString1.append("_chat_bg_effect");
        paramContext.remove(paramString1.toString());
      }
      else
      {
        paramString1 = new StringBuilder();
        paramString1.append(paramString2);
        paramString1.append("_is_c2c_set");
        paramContext.putBoolean(paramString1.toString(), true);
        paramString1 = new StringBuilder();
        paramString1.append(paramString2);
        paramString1.append("_chat_bg_effect");
        paramContext.putInt(paramString1.toString(), paramInt1);
      }
    }
    paramContext.commit();
  }
  
  public static String b(String paramString)
  {
    if ((paramString != null) && (paramString.trim().length() != 0))
    {
      if (paramString.equals("null")) {
        return "null";
      }
      if (paramString.equals("none")) {
        return "null";
      }
      int i = paramString.lastIndexOf(File.separatorChar);
      if ((i >= 0) && (i < paramString.length() - 1))
      {
        paramString = paramString.substring(0, i);
        i = paramString.lastIndexOf(File.separatorChar);
        if ((i >= 0) && (i < paramString.length() - 1))
        {
          i += 1;
          localObject = paramString.substring(0, i);
          if (AppConstants.PATH_SYSTEM_BACKGROUND_RESOURCE.equals(localObject))
          {
            localObject = paramString.substring(i);
            i = ((String)localObject).lastIndexOf('.');
            paramString = (String)localObject;
            if (i >= 0) {
              paramString = ((String)localObject).substring(0, i);
            }
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("resName is:");
              ((StringBuilder)localObject).append(paramString);
              QLog.d("ChatBackgroundUtil", 2, ((StringBuilder)localObject).toString());
            }
            return paramString;
          }
          return "custom";
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("parentPath is illegal,parentPath is:");
        ((StringBuilder)localObject).append(paramString);
        throw new IllegalStateException(((StringBuilder)localObject).toString());
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("picPath is illegal,picPath is:");
      ((StringBuilder)localObject).append(paramString);
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
    return "null";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.util.ChatBackgroundUtil
 * JD-Core Version:    0.7.0.1
 */