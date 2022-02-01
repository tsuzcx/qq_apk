package com.tencent.mobileqq.kandian.biz.pts.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.kandian.biz.pts.ui.PTSImageView;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler.FastBlurDecoder;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class PTSImageUtil
{
  private static HashMap<String, Drawable> a = new HashMap();
  
  private static int a(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (paramContext.getResources() != null) && (!TextUtils.isEmpty(paramString))) {
      return paramContext.getResources().getIdentifier(paramString, "drawable", paramContext.getPackageName());
    }
    return 0;
  }
  
  public static Drawable a(Context paramContext, String paramString, int paramInt)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!bool)
    {
      if (paramContext == null) {
        return null;
      }
      if (a(paramString))
      {
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        paramContext = paramContext.getResources().getDrawable(2130842687);
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = paramContext;
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = paramContext;
        paramContext = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject1);
        localObject1 = paramContext;
        if (paramInt > 0)
        {
          paramContext.setDecodeHandler(new URLDrawableDecodeHandler.FastBlurDecoder(paramInt));
          return paramContext;
        }
      }
      else
      {
        if (b(paramString))
        {
          paramString = paramString.substring(paramString.lastIndexOf("/") + 1, paramString.lastIndexOf("."));
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("qb_public_account_readinjoy_");
          ((StringBuilder)localObject1).append(paramString);
          paramString = ((StringBuilder)localObject1).toString();
          return paramContext.getResources().getDrawable(a(paramContext, paramString));
        }
        paramContext = new StringBuilder();
        paramContext.append("[getDrawable] null, imageUrl = ");
        paramContext.append(paramString);
        QLog.e("PTSImageUtil", 1, paramContext.toString());
        localObject1 = localObject2;
      }
    }
    return localObject1;
  }
  
  private static String a(String paramString, PTSImageView paramPTSImageView)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramPTSImageView != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("_");
      localStringBuilder.append(paramPTSImageView.getWidth());
      localStringBuilder.append("_");
      localStringBuilder.append(paramPTSImageView.getHeight());
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public static void a(PTSImageView paramPTSImageView, String paramString)
  {
    if (paramPTSImageView != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if (QLog.isDebugVersion())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[setLocalImageDrawable], localPath = ");
        ((StringBuilder)localObject).append(paramString);
        QLog.i("PTSImageUtil", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = (Drawable)a.get(a(paramString, paramPTSImageView));
      if (localObject != null)
      {
        paramPTSImageView.setImageDrawable((Drawable)localObject);
        return;
      }
      try
      {
        localObject = paramString.substring(paramString.lastIndexOf("/") + 1, paramString.lastIndexOf("."));
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("qb_public_account_readinjoy_");
        localStringBuilder.append((String)localObject);
        localObject = localStringBuilder.toString();
        int i = a(paramPTSImageView.getContext(), (String)localObject);
        if (i == 0)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[setLocalImageDrawable], cannot find the resource, localPath = ");
          ((StringBuilder)localObject).append(paramString);
          QLog.e("PTSImageUtil", 1, ((StringBuilder)localObject).toString());
          paramPTSImageView.setImageDrawable(new ColorDrawable(0));
          return;
        }
        paramPTSImageView.setImageResource(i);
        a.put(a(paramString, paramPTSImageView), paramPTSImageView.getDrawable());
        return;
      }
      catch (Exception paramString)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[setLocalImageDrawable] error, e = ");
        ((StringBuilder)localObject).append(paramString);
        QLog.e("PTSImageUtil", 1, ((StringBuilder)localObject).toString());
        paramPTSImageView.setImageDrawable(new ColorDrawable(0));
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if ((paramString.startsWith("http")) || (paramString.startsWith("pubaccount"))) {
      bool1 = true;
    }
    return bool1;
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.startsWith("images");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.util.PTSImageUtil
 * JD-Core Version:    0.7.0.1
 */