package com.tencent.mobileqq.emoticonview;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPSiteUtil
{
  private static final String TAG = "IPSiteUtil";
  
  public static SpannableString dealIPSiteString(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      String[] arrayOfString = paramString.split(" ");
      paramString = new SpannableString(paramString);
      int i = 0;
      while (i < arrayOfString.length)
      {
        String str = arrayOfString[i];
        if (isNumeric(str))
        {
          int k = i - 1;
          int j = 0;
          while (k >= 0)
          {
            j = j + arrayOfString[k].length() + 1;
            k -= 1;
          }
          k = str.length();
          paramString.setSpan(new ForegroundColorSpan(-15550475), j, k + j, 33);
        }
        i += 1;
      }
      return paramString;
    }
    return new SpannableString("");
  }
  
  public static Drawable getIPSiteDrawable(String paramString, URLDrawable.URLDrawableListener paramURLDrawableListener, Drawable paramDrawable)
  {
    return getIPSiteDrawable(paramString, false, false, paramURLDrawableListener, paramDrawable);
  }
  
  private static Drawable getIPSiteDrawable(String paramString, boolean paramBoolean1, boolean paramBoolean2, URLDrawable.URLDrawableListener paramURLDrawableListener, Drawable paramDrawable)
  {
    Object localObject5 = null;
    Object localObject4 = null;
    Object localObject1 = paramDrawable;
    Object localObject2;
    Object localObject3;
    if (paramDrawable == null)
    {
      localObject2 = localObject5;
      localObject3 = paramDrawable;
    }
    for (;;)
    {
      try
      {
        localObject1 = new ColorDrawable(-1513240);
        localObject2 = localObject5;
        localObject3 = localObject1;
        paramDrawable = URLDrawable.URLDrawableOptions.obtain();
        localObject2 = localObject5;
        localObject3 = localObject1;
        paramDrawable.mFailedDrawable = ((Drawable)localObject1);
        localObject2 = localObject5;
        localObject3 = localObject1;
        paramDrawable.mLoadingDrawable = ((Drawable)localObject1);
        StringBuilder localStringBuilder;
        if (paramBoolean1)
        {
          try
          {
            paramDrawable = URLDrawable.getDrawable(new URL("protocol_vas_extension_image", "COMIC_IP_SITE_ROUND_IMAGE", paramString), paramDrawable);
          }
          catch (Exception paramDrawable)
          {
            localObject2 = localObject5;
            localObject3 = localObject1;
            localStringBuilder = new StringBuilder();
            localObject2 = localObject5;
            localObject3 = localObject1;
            localStringBuilder.append("getIPSiteDrawable error = ");
            localObject2 = localObject5;
            localObject3 = localObject1;
            localStringBuilder.append(paramDrawable);
            localObject2 = localObject5;
            localObject3 = localObject1;
            QLog.e("IPSiteUtil", 1, localStringBuilder.toString());
            paramDrawable = localObject4;
            continue;
          }
        }
        else if (paramBoolean2)
        {
          try
          {
            paramDrawable = URLDrawable.getDrawable(new URL("protocol_vas_extension_image", "COMIC_IPSITE_GAME_IMAGE", paramString), paramDrawable);
          }
          catch (Exception paramDrawable)
          {
            localObject2 = localObject5;
            localObject3 = localObject1;
            localStringBuilder = new StringBuilder();
            localObject2 = localObject5;
            localObject3 = localObject1;
            localStringBuilder.append("getIPSiteDrawable error = ");
            localObject2 = localObject5;
            localObject3 = localObject1;
            localStringBuilder.append(paramDrawable);
            localObject2 = localObject5;
            localObject3 = localObject1;
            QLog.e("IPSiteUtil", 1, localStringBuilder.toString());
            paramDrawable = localObject4;
            continue;
          }
        }
        else
        {
          localObject2 = localObject5;
          localObject3 = localObject1;
          paramDrawable = URLDrawable.getDrawable(paramString, paramDrawable);
        }
      }
      catch (Exception paramURLDrawableListener)
      {
        paramDrawable = new StringBuilder();
        paramDrawable.append("getIPSiteDrawable error url = ");
        paramDrawable.append(paramString);
        paramDrawable.append("error msg = ");
        paramDrawable.append(paramURLDrawableListener);
        QLog.e("IPSiteUtil", 1, paramDrawable.toString());
      }
      localObject2 = paramDrawable;
      localObject3 = localObject1;
      if (paramDrawable != null)
      {
        localObject2 = paramDrawable;
        localObject3 = localObject1;
        if (paramDrawable.getTag() == null)
        {
          localObject2 = paramDrawable;
          localObject3 = localObject1;
          paramDrawable.setTag(Integer.valueOf(0));
        }
        localObject2 = paramDrawable;
        localObject3 = localObject1;
        paramDrawable.setURLDrawableListener(paramURLDrawableListener);
        localObject2 = paramDrawable;
        localObject3 = localObject1;
        paramDrawable.setAutoDownload(true);
        localObject2 = paramDrawable;
        localObject3 = localObject1;
      }
      if (localObject2 == null) {
        return localObject3;
      }
      return localObject2;
    }
  }
  
  private static boolean isNumeric(String paramString)
  {
    return Pattern.compile("^[-\\+]?[\\d]*$").matcher(paramString).matches();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.IPSiteUtil
 * JD-Core Version:    0.7.0.1
 */