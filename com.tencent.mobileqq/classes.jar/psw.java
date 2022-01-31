import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeText;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;

public class psw
{
  public static CharSequence a(ArticleInfo paramArticleInfo)
  {
    Object localObject;
    String str2;
    String str1;
    if (paramArticleInfo != null)
    {
      long l2 = paramArticleInfo.mTime;
      long l1 = l2;
      if (paramArticleInfo.mSocialFeedInfo != null)
      {
        l1 = l2;
        if (paramArticleInfo.mSocialFeedInfo.e > 0) {
          l1 = paramArticleInfo.mSocialFeedInfo.e;
        }
      }
      if (l1 > 0L)
      {
        localObject = orr.a(l1, true);
        str2 = "";
        if ((!pkm.b(paramArticleInfo)) || (paramArticleInfo.mSocialFeedInfo == null)) {
          break label105;
        }
        str1 = paramArticleInfo.mSocialFeedInfo.d;
        label79:
        if (!TextUtils.isEmpty(str1)) {
          break label171;
        }
      }
    }
    for (;;)
    {
      return ors.a((String)localObject, 36);
      localObject = alud.a(2131701531);
      break;
      label105:
      str1 = str2;
      if (paramArticleInfo.mSocialFeedInfo == null) {
        break label79;
      }
      str1 = str2;
      if (TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.d)) {
        break label79;
      }
      str1 = (String)localObject + " · " + paramArticleInfo.mSocialFeedInfo.d;
      break label79;
      return "";
      label171:
      localObject = str1;
    }
  }
  
  public static void a(ViewBase paramViewBase, ArticleInfo paramArticleInfo)
  {
    NativeText localNativeText = (NativeText)paramViewBase.findViewBaseByName("id_biu_time");
    if ((localNativeText != null) && (paramArticleInfo != null) && (paramArticleInfo.articleViewModel != null)) {
      if ((paramArticleInfo.mFeedType != 32) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.a == null) || (TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.a.d))) {
        break label168;
      }
    }
    label168:
    for (paramViewBase = " · " + paramArticleInfo.mSocialFeedInfo.a.d;; paramViewBase = "")
    {
      localNativeText.setText(paramArticleInfo.articleViewModel.a() + paramViewBase);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.proteus", 2, " " + paramArticleInfo + " time : " + paramArticleInfo.mTime);
      }
      return;
    }
  }
  
  public static void a(ViewBase paramViewBase, pgd parampgd)
  {
    String str = "";
    ViewBase localViewBase = paramViewBase.findViewBaseByName("id_jump_channel_bar");
    paramViewBase = str;
    boolean bool;
    if (parampgd != null)
    {
      paramViewBase = str;
      if (localViewBase != null)
      {
        bool = ors.c();
        if ((!bool) || (!ors.k(parampgd.a()))) {
          break label93;
        }
        localViewBase.setVisibility(0);
      }
    }
    for (paramViewBase = str;; paramViewBase = "no data bind, isintab:" + bool)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.proteus", 2, "bindJumpChannel,flag" + false + " resong : " + paramViewBase);
      }
      return;
      label93:
      localViewBase.setVisibility(8);
    }
  }
  
  public static void b(ViewBase paramViewBase, pgd parampgd)
  {
    paramViewBase = (prr)paramViewBase.findViewBaseByName("id_socialize_recommend_follow");
    if (paramViewBase != null) {
      paramViewBase.a(parampgd);
    }
  }
  
  public static void c(ViewBase paramViewBase, pgd parampgd)
  {
    parampgd = parampgd.a();
    paramViewBase = paramViewBase.findViewBaseByName("id_flow_guide_separator");
    if (paramViewBase != null)
    {
      try
      {
        if (pkm.a(parampgd))
        {
          if ((parampgd != null) && (parampgd.isPGCShortContent()))
          {
            paramViewBase.setVisibility(0);
            return;
          }
          paramViewBase.setVisibility(8);
          return;
        }
      }
      catch (JSONException paramViewBase)
      {
        QLog.e("BindViewHelper", 2, paramViewBase.getMessage());
        return;
      }
      paramViewBase.setVisibility(8);
    }
  }
  
  public static void d(ViewBase paramViewBase, pgd parampgd)
  {
    parampgd = parampgd.a();
    do
    {
      try
      {
        long l = Long.parseLong(parampgd.mSubscribeID);
        parampgd = ReadInJoyUserInfoModule.a(l, null);
        if (parampgd == null) {
          return;
        }
      }
      catch (NumberFormatException paramViewBase)
      {
        paramViewBase.printStackTrace();
        return;
      }
      paramViewBase = (NativeText)paramViewBase.findViewBaseByName("id_nickname");
    } while (paramViewBase == null);
    paramViewBase.setText(parampgd.nick);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     psw
 * JD-Core Version:    0.7.0.1
 */