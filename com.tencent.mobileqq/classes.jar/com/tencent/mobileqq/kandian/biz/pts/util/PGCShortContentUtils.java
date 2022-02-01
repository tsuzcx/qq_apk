package com.tencent.mobileqq.kandian.biz.pts.util;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.base.image.imageloader.DrawableController;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.Map;

public class PGCShortContentUtils
{
  private static String a(String paramString)
  {
    paramString = JumpParser.a(RIJQQAppInterfaceUtil.a(), BaseApplicationImpl.getContext(), paramString);
    if (paramString != null)
    {
      paramString = paramString.a;
      if (paramString != null)
      {
        paramString = (String)paramString.get("target");
        if (!TextUtils.isEmpty(paramString)) {
          return paramString;
        }
      }
    }
    return null;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getJumpType: ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" recommendType: ");
    localStringBuilder.append(paramString2);
    QLog.d("PGCShortContentUtils", 1, localStringBuilder.toString());
    if (!TextUtils.isEmpty(paramString1))
    {
      do
      {
        paramString2 = a(paramString1);
        if (TextUtils.isEmpty(paramString2)) {
          break;
        }
      } while (!a(paramString1));
      paramString2 = "6";
      break label107;
      paramString2 = paramString1;
      if (!paramString1.startsWith("http:")) {
        if (paramString1.startsWith("https:")) {
          paramString2 = paramString1;
        } else {
          paramString2 = "-1";
        }
      }
    }
    label107:
    paramString1 = new StringBuilder();
    paramString1.append("getJumpType result is: ");
    paramString1.append(paramString2);
    QLog.d("PGCShortContentUtils", 1, paramString1.toString());
    return paramString2;
  }
  
  public static void a(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    a(paramContext, paramAbsBaseArticleInfo, false);
  }
  
  public static void a(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("redirectToOtherPage ");
    localStringBuilder.append(paramAbsBaseArticleInfo);
    localStringBuilder.append(" isComment: ");
    localStringBuilder.append(paramBoolean);
    QLog.d("PGCShortContentUtils", 1, localStringBuilder.toString());
    if (paramAbsBaseArticleInfo == null)
    {
      QLog.d("PGCShortContentUtils", 1, "articleInfo is null");
      return;
    }
    if (paramAbsBaseArticleInfo.isCardJumpUrlAvailable == 1)
    {
      paramAbsBaseArticleInfo.clickJumpTarget = a(paramAbsBaseArticleInfo.getCardJumpUrl(), "-1");
      RIJJumpUtils.a(paramContext, paramAbsBaseArticleInfo.getCardJumpUrl());
      return;
    }
    paramAbsBaseArticleInfo.clickJumpTarget = a(ReadInJoyConstants.e, "-1");
    RIJJumpUtils.a(paramContext, paramAbsBaseArticleInfo, paramBoolean);
  }
  
  public static void a(KandianUrlImageView paramKandianUrlImageView, Context paramContext, URL paramURL1, URL paramURL2, Runnable paramRunnable)
  {
    if (paramKandianUrlImageView != null)
    {
      if ((paramURL2 != null) && (paramURL1 != null) && (paramURL2.hashCode() == paramURL1.hashCode()) && (paramKandianUrlImageView.mController != null) && (paramKandianUrlImageView.mController.a != null)) {
        return;
      }
      paramKandianUrlImageView.setPublicAccountImageDownListener(new PGCShortContentUtils.1(paramRunnable));
      ReadInJoyDisplayUtils.a(paramKandianUrlImageView, paramURL2, paramContext);
    }
  }
  
  public static boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = JumpParser.a(RIJQQAppInterfaceUtil.a(), BaseApplicationImpl.getContext(), paramString);
      if (localObject != null)
      {
        localObject = ((JumpAction)localObject).a;
        if ((localObject != null) && ("6".equals((String)((Map)localObject).get("target"))) && (((Map)localObject).containsKey("v_url_base64"))) {
          return true;
        }
      }
      return ViolaAccessHelper.c(ViolaAccessHelper.c(paramString));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.util.PGCShortContentUtils
 * JD-Core Version:    0.7.0.1
 */