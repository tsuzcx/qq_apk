import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeSummaryView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class rja
{
  static CharSequence a(BaseArticleInfo paramBaseArticleInfo, oqi paramoqi)
  {
    if (paramBaseArticleInfo == null) {
      return "";
    }
    SocializeFeedsInfo localSocializeFeedsInfo;
    int i;
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null))
    {
      localSocializeFeedsInfo = paramBaseArticleInfo.mSocialFeedInfo;
      if ((localSocializeFeedsInfo.jdField_a_of_type_Pqm != null) && (localSocializeFeedsInfo.jdField_a_of_type_Pqm.a != null) && (localSocializeFeedsInfo.jdField_a_of_type_Pqm.a.size() > 0) && ((localSocializeFeedsInfo.jdField_a_of_type_Pqm.a.size() != 1) || ((!TextUtils.isEmpty(((SocializeFeedsInfo.BiuCommentInfo)localSocializeFeedsInfo.jdField_a_of_type_Pqm.a.get(0)).jdField_a_of_type_JavaLangString)) && (!TextUtils.equals(((SocializeFeedsInfo.BiuCommentInfo)localSocializeFeedsInfo.jdField_a_of_type_Pqm.a.get(0)).jdField_a_of_type_JavaLangString, ":")) && (!TextUtils.equals(((SocializeFeedsInfo.BiuCommentInfo)localSocializeFeedsInfo.jdField_a_of_type_Pqm.a.get(0)).jdField_a_of_type_JavaLangString, "：")))))
      {
        SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
        paramoqi = localSocializeFeedsInfo.jdField_a_of_type_Pqm.a((ArticleInfo)paramBaseArticleInfo, "5", paramoqi);
        if (!TextUtils.isEmpty(paramoqi)) {
          localSpannableStringBuilder.append(paramoqi);
        }
        i = 1;
        paramoqi = localSpannableStringBuilder;
      }
    }
    for (;;)
    {
      QLog.d("Utils", 2, "makeBiuComment: " + paramBaseArticleInfo.rawkey + " ssb: " + paramoqi + " condition flag: " + i);
      return paramoqi;
      if (!TextUtils.isEmpty(localSocializeFeedsInfo.jdField_a_of_type_JavaLangString))
      {
        if (localSocializeFeedsInfo.jdField_a_of_type_JavaLangString.length() >= 100) {
          localSocializeFeedsInfo.jdField_a_of_type_JavaLangString = (localSocializeFeedsInfo.jdField_a_of_type_JavaLangString.substring(0, 99) + '…');
        }
        paramoqi = localSocializeFeedsInfo.jdField_a_of_type_JavaLangString;
        i = 1;
      }
      else
      {
        i = 0;
        paramoqi = "";
      }
    }
  }
  
  public static opw a(ArticleInfo paramArticleInfo)
  {
    return new oqh(null, paramArticleInfo, qoe.c(paramArticleInfo), (int)paramArticleInfo.mChannelID, 0, 0, false, 0, null, null);
  }
  
  static CharSequence b(BaseArticleInfo paramBaseArticleInfo, oqi paramoqi)
  {
    int i1 = 0;
    int n = 0;
    Object localObject3 = (ArticleInfo)paramBaseArticleInfo;
    if (localObject3 == null) {
      return "";
    }
    Object localObject2 = "";
    int j;
    int k;
    int m;
    Object localObject1;
    switch (qoe.c((ArticleInfo)localObject3))
    {
    default: 
      j = 0;
      k = 0;
      m = 0;
      i = n;
      localObject1 = localObject2;
      if (paramBaseArticleInfo.mSocialFeedInfo != null)
      {
        if (!paramBaseArticleInfo.isPGCShortContent()) {
          break label329;
        }
        i = 9;
        if ((localObject3 != null) && (((ArticleInfo)localObject3).mSocialFeedInfo != null) && (((ArticleInfo)localObject3).mSocialFeedInfo.jdField_a_of_type_Pqz != null) && (!TextUtils.isEmpty(((ArticleInfo)localObject3).mSocialFeedInfo.jdField_a_of_type_Pqz.jdField_a_of_type_JavaLangString))) {
          localObject1 = ((ArticleInfo)localObject3).mSocialFeedInfo.jdField_a_of_type_Pqz.jdField_a_of_type_JavaLangString;
        }
      }
      else
      {
        label222:
        QLog.d("Utils", 2, "makeNonBiuComment: " + paramBaseArticleInfo.rawkey + " ssb: " + localObject1 + " condition flag: " + i);
        return localObject1;
      }
      break;
    }
    for (int i = 1;; i = 0)
    {
      k = 0;
      j = 1;
      m = i;
      break;
      j = 0;
      k = 1;
      m = 0;
      break;
      if ((localObject3 != null) && (!TextUtils.isEmpty(((ArticleInfo)localObject3).mTitle)))
      {
        localObject1 = ((ArticleInfo)localObject3).mTitle;
        break label222;
      }
      localObject1 = "";
      break label222;
      label329:
      if (k != 0)
      {
        localObject1 = ((ArticleInfo)localObject3).mTitle;
        i = 1;
        break label222;
      }
      if ((qoe.a((ArticleInfo)localObject3)) || (qoe.c((BaseArticleInfo)localObject3)) || (qoe.h((ArticleInfo)localObject3)))
      {
        if (m != 0)
        {
          localObject1 = new SpannableStringBuilder();
          if ((((ArticleInfo)localObject3).mSocialFeedInfo != null) && (((ArticleInfo)localObject3).mSocialFeedInfo.jdField_a_of_type_Pqz != null) && (((ArticleInfo)localObject3).mSocialFeedInfo.jdField_a_of_type_Pqz.jdField_a_of_type_JavaLangString != null))
          {
            ((SpannableStringBuilder)localObject1).append(((ArticleInfo)localObject3).mSocialFeedInfo.jdField_a_of_type_Pqz.jdField_a_of_type_JavaLangString);
            if (QLog.isColorLevel()) {
              QLog.d("Q.readinjoy.ui", 2, "Comment String: " + ((ArticleInfo)localObject3).mSocialFeedInfo.jdField_a_of_type_Pqz.jdField_a_of_type_JavaLangString);
            }
          }
          for (;;)
          {
            i = 2;
            break;
            if (((ArticleInfo)localObject3).mTitle != null) {
              ((SpannableStringBuilder)localObject1).append(((ArticleInfo)localObject3).mTitle);
            }
          }
        }
        if (j != 0)
        {
          if (!TextUtils.isEmpty(((ArticleInfo)localObject3).mTitle)) {}
          for (paramoqi = ((ArticleInfo)localObject3).mTitle;; paramoqi = ((ArticleInfo)localObject3).mSummary)
          {
            i = 3;
            localObject1 = paramoqi;
            break;
          }
        }
        if (qoe.c((BaseArticleInfo)localObject3))
        {
          localObject1 = new StringBuilder(ajjy.a(2131650238));
          if (!qoe.f(paramBaseArticleInfo))
          {
            localObject2 = (prx)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Prv.a.get(0);
            localObject3 = ((StringBuilder)localObject1).append("“");
            if (!TextUtils.isEmpty(((prx)localObject2).c)) {
              break label650;
            }
            paramoqi = "";
            label611:
            localObject3 = ((StringBuilder)localObject3).append(paramoqi);
            if (!TextUtils.isEmpty(((prx)localObject2).jdField_a_of_type_JavaLangString)) {
              break label659;
            }
          }
          label650:
          label659:
          for (paramoqi = "";; paramoqi = ((prx)localObject2).jdField_a_of_type_JavaLangString)
          {
            ((StringBuilder)localObject3).append(paramoqi).append("”");
            i = 4;
            break;
            paramoqi = ((prx)localObject2).c;
            break label611;
          }
        }
        localObject1 = ((ArticleInfo)localObject3).mSummary;
        i = 5;
        break label222;
      }
      i = n;
      localObject1 = localObject2;
      if (((ArticleInfo)localObject3).mSocialFeedInfo.jdField_a_of_type_Pre == null) {
        break label222;
      }
      pre localpre = ((ArticleInfo)localObject3).mSocialFeedInfo.jdField_a_of_type_Pre;
      if (obz.a(localpre))
      {
        localObject1 = localpre.jdField_a_of_type_Pqm.a((ArticleInfo)localObject3, "3", paramoqi);
        i = 6;
        break label222;
      }
      if ((pjg.c((ArticleInfo)localObject3)) && (!qoe.q((ArticleInfo)localObject3)))
      {
        localObject2 = ((prg)((ArticleInfo)localObject3).mSocialFeedInfo.jdField_a_of_type_Pre.b.get(0)).e;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label890;
        }
        localObject1 = obj.a((String)localObject2);
        paramoqi = (oqi)localObject1;
        if (TextUtils.equals((CharSequence)localObject1, (CharSequence)localObject2)) {
          paramoqi = awbk.b((String)localObject2);
        }
        paramoqi = new axkd(paramoqi, 7, 16);
      }
      for (i = 7;; i = i1)
      {
        localObject1 = paramoqi;
        break;
        i = n;
        localObject1 = localObject2;
        if (TextUtils.isEmpty(localpre.jdField_a_of_type_JavaLangString)) {
          break;
        }
        paramoqi = null;
        try
        {
          localObject1 = awbk.b(localpre.jdField_a_of_type_JavaLangString);
          paramoqi = (oqi)localObject1;
        }
        catch (Exception localException)
        {
          label865:
          break label865;
        }
        localObject1 = new axkd(paramoqi, 7, 16);
        i = 8;
        break;
        label890:
        paramoqi = "";
      }
    }
  }
  
  public static CharSequence c(BaseArticleInfo paramBaseArticleInfo, oqi paramoqi)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    paramBaseArticleInfo = a((ArticleInfo)paramBaseArticleInfo);
    NativeSummaryView.a(paramBaseArticleInfo, localSpannableStringBuilder, paramoqi);
    NativeSummaryView.b(paramBaseArticleInfo, localSpannableStringBuilder, paramoqi);
    return localSpannableStringBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rja
 * JD-Core Version:    0.7.0.1
 */