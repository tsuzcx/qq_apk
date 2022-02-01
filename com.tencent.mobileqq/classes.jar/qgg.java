import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.Map;

public class qgg
{
  private static String a(String paramString)
  {
    paramString = bfwg.a(pay.a(), BaseApplicationImpl.getContext(), paramString);
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
    QLog.d("PGCShortContentUtils", 1, "getJumpType: " + paramString1 + " recommendType: " + paramString2);
    if (TextUtils.isEmpty(paramString1)) {}
    for (;;)
    {
      QLog.d("PGCShortContentUtils", 1, "getJumpType result is: " + paramString2);
      return paramString2;
      paramString2 = a(paramString1);
      if (!TextUtils.isEmpty(paramString2))
      {
        if (a(paramString1)) {
          paramString2 = "6";
        }
      }
      else if ((paramString1.startsWith("http:")) || (paramString1.startsWith("https:"))) {
        paramString2 = paramString1;
      } else {
        paramString2 = "-1";
      }
    }
  }
  
  public static void a(Context paramContext, ArticleInfo paramArticleInfo)
  {
    a(paramContext, paramArticleInfo, false);
  }
  
  public static void a(Context paramContext, ArticleInfo paramArticleInfo, boolean paramBoolean)
  {
    QLog.d("PGCShortContentUtils", 1, "redirectToOtherPage " + paramArticleInfo + " isComment: " + paramBoolean);
    if (paramArticleInfo == null)
    {
      QLog.d("PGCShortContentUtils", 1, "articleInfo is null");
      return;
    }
    if (paramArticleInfo.isCardJumpUrlAvailable == 1)
    {
      paramArticleInfo.clickJumpTarget = a(paramArticleInfo.getCardJumpUrl(), "-1");
      pay.d(paramContext, paramArticleInfo.getCardJumpUrl());
      return;
    }
    paramArticleInfo.clickJumpTarget = a(paa.e, "-1");
    pay.a(paramContext, paramArticleInfo, paramBoolean);
  }
  
  public static void a(KandianUrlImageView paramKandianUrlImageView, Context paramContext, URL paramURL1, URL paramURL2, Runnable paramRunnable)
  {
    if ((paramKandianUrlImageView == null) || ((paramURL2 != null) && (paramURL1 != null) && (paramURL2.hashCode() == paramURL1.hashCode()) && (paramKandianUrlImageView.mController != null) && (paramKandianUrlImageView.mController.a != null))) {
      return;
    }
    paramKandianUrlImageView.setPublicAccountImageDownListener(new qgh(paramRunnable));
    pai.a(paramKandianUrlImageView, paramURL2, paramContext);
  }
  
  public static boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = bfwg.a(pay.a(), BaseApplicationImpl.getContext(), paramString);
      if (localObject != null)
      {
        localObject = ((bfvp)localObject).a;
        if ((localObject != null) && ("6".equals((String)((Map)localObject).get("target"))) && (((Map)localObject).containsKey("v_url_base64"))) {
          return true;
        }
      }
      return tgc.b(tgc.b(paramString));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qgg
 * JD-Core Version:    0.7.0.1
 */