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

public class rvn
{
  static CharSequence a(BaseArticleInfo paramBaseArticleInfo, pbg parampbg)
  {
    if (paramBaseArticleInfo == null) {
      return "";
    }
    SocializeFeedsInfo localSocializeFeedsInfo;
    int i;
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null))
    {
      localSocializeFeedsInfo = paramBaseArticleInfo.mSocialFeedInfo;
      if ((localSocializeFeedsInfo.jdField_a_of_type_Qcg != null) && (localSocializeFeedsInfo.jdField_a_of_type_Qcg.a != null) && (localSocializeFeedsInfo.jdField_a_of_type_Qcg.a.size() > 0) && ((localSocializeFeedsInfo.jdField_a_of_type_Qcg.a.size() != 1) || ((!TextUtils.isEmpty(((SocializeFeedsInfo.BiuCommentInfo)localSocializeFeedsInfo.jdField_a_of_type_Qcg.a.get(0)).jdField_a_of_type_JavaLangString)) && (!TextUtils.equals(((SocializeFeedsInfo.BiuCommentInfo)localSocializeFeedsInfo.jdField_a_of_type_Qcg.a.get(0)).jdField_a_of_type_JavaLangString, ":")) && (!TextUtils.equals(((SocializeFeedsInfo.BiuCommentInfo)localSocializeFeedsInfo.jdField_a_of_type_Qcg.a.get(0)).jdField_a_of_type_JavaLangString, "：")))))
      {
        SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
        parampbg = localSocializeFeedsInfo.jdField_a_of_type_Qcg.a((ArticleInfo)paramBaseArticleInfo, "5", parampbg);
        if (!TextUtils.isEmpty(parampbg)) {
          localSpannableStringBuilder.append(parampbg);
        }
        i = 1;
        parampbg = localSpannableStringBuilder;
      }
    }
    for (;;)
    {
      QLog.d("Utils", 2, "makeBiuComment: " + paramBaseArticleInfo.rawkey + " ssb: " + parampbg + " condition flag: " + i);
      return parampbg;
      if (!TextUtils.isEmpty(localSocializeFeedsInfo.jdField_a_of_type_JavaLangString))
      {
        if (localSocializeFeedsInfo.jdField_a_of_type_JavaLangString.length() >= 100) {
          localSocializeFeedsInfo.jdField_a_of_type_JavaLangString = (localSocializeFeedsInfo.jdField_a_of_type_JavaLangString.substring(0, 99) + '…');
        }
        parampbg = localSocializeFeedsInfo.jdField_a_of_type_JavaLangString;
        i = 1;
      }
      else
      {
        i = 0;
        parampbg = "";
      }
    }
  }
  
  public static pau a(ArticleInfo paramArticleInfo)
  {
    return new pbf(null, paramArticleInfo, ram.c(paramArticleInfo), (int)paramArticleInfo.mChannelID, 0, 0, false, 0, null, null);
  }
  
  static CharSequence b(BaseArticleInfo paramBaseArticleInfo, pbg parampbg)
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
    int i;
    Object localObject1;
    switch (ram.c((ArticleInfo)localObject3))
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
          break label423;
        }
        i = 9;
        if ((localObject3 == null) || (((ArticleInfo)localObject3).mSocialFeedInfo == null) || (((ArticleInfo)localObject3).mSocialFeedInfo.jdField_a_of_type_Qcv == null) || (TextUtils.isEmpty(((ArticleInfo)localObject3).mSocialFeedInfo.jdField_a_of_type_Qcv.jdField_a_of_type_JavaLangString))) {
          break label390;
        }
        if (((ArticleInfo)localObject3).mSocialFeedInfo.jdField_a_of_type_Int != 19191924) {
          break label374;
        }
      }
      break;
    }
    for (;;)
    {
      try
      {
        localObject1 = rrg.a(((ArticleInfo)localObject3).mSocialFeedInfo.jdField_a_of_type_Qcv.jdField_a_of_type_JavaLangString, ((ArticleInfo)localObject3).mSocialFeedInfo.jdField_a_of_type_Qco.a.b, ((ArticleInfo)localObject3).mSocialFeedInfo.jdField_a_of_type_Qco.a.jdField_a_of_type_JavaLangString, ((ArticleInfo)localObject3).mSocialFeedInfo.jdField_a_of_type_Qco.a.c, (ArticleInfo)localObject3);
        QLog.d("Utils", 2, "makeNonBiuComment: " + paramBaseArticleInfo.rawkey + " ssb: " + localObject1 + " condition flag: " + i);
        return localObject1;
        i = 1;
        k = 0;
        j = 1;
        m = i;
        break;
        j = 0;
        k = 1;
        m = 0;
      }
      catch (NullPointerException parampbg)
      {
        QLog.e("Utils", 2, parampbg.toString());
        localObject1 = localObject2;
        continue;
      }
      label374:
      localObject1 = ((ArticleInfo)localObject3).mSocialFeedInfo.jdField_a_of_type_Qcv.jdField_a_of_type_JavaLangString;
      continue;
      label390:
      if ((localObject3 != null) && (!TextUtils.isEmpty(((ArticleInfo)localObject3).mTitle)))
      {
        localObject1 = ((ArticleInfo)localObject3).mTitle;
      }
      else
      {
        localObject1 = "";
        continue;
        label423:
        if (k != 0)
        {
          localObject1 = ((ArticleInfo)localObject3).mTitle;
          i = 1;
        }
        else if ((ram.a((ArticleInfo)localObject3)) || (ram.c((BaseArticleInfo)localObject3)) || (ram.h((ArticleInfo)localObject3)))
        {
          if (m != 0)
          {
            localObject1 = new SpannableStringBuilder();
            if ((((ArticleInfo)localObject3).mSocialFeedInfo != null) && (((ArticleInfo)localObject3).mSocialFeedInfo.jdField_a_of_type_Qcv != null) && (((ArticleInfo)localObject3).mSocialFeedInfo.jdField_a_of_type_Qcv.jdField_a_of_type_JavaLangString != null))
            {
              ((SpannableStringBuilder)localObject1).append(((ArticleInfo)localObject3).mSocialFeedInfo.jdField_a_of_type_Qcv.jdField_a_of_type_JavaLangString);
              if (QLog.isColorLevel()) {
                QLog.d("Q.readinjoy.ui", 2, "Comment String: " + ((ArticleInfo)localObject3).mSocialFeedInfo.jdField_a_of_type_Qcv.jdField_a_of_type_JavaLangString);
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
            for (parampbg = ((ArticleInfo)localObject3).mTitle;; parampbg = ((ArticleInfo)localObject3).mSummary)
            {
              i = 3;
              localObject1 = parampbg;
              break;
            }
          }
          if (ram.c((BaseArticleInfo)localObject3))
          {
            localObject1 = new StringBuilder(ajya.a(2131716040));
            if (!ram.f(paramBaseArticleInfo))
            {
              localObject2 = (qds)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qdq.a.get(0);
              localObject3 = ((StringBuilder)localObject1).append("“");
              if (!TextUtils.isEmpty(((qds)localObject2).c)) {
                break label744;
              }
              parampbg = "";
              label705:
              localObject3 = ((StringBuilder)localObject3).append(parampbg);
              if (!TextUtils.isEmpty(((qds)localObject2).jdField_a_of_type_JavaLangString)) {
                break label753;
              }
            }
            label744:
            label753:
            for (parampbg = "";; parampbg = ((qds)localObject2).jdField_a_of_type_JavaLangString)
            {
              ((StringBuilder)localObject3).append(parampbg).append("”");
              i = 4;
              break;
              parampbg = ((qds)localObject2).c;
              break label705;
            }
          }
          localObject1 = ((ArticleInfo)localObject3).mSummary;
          i = 5;
        }
        else
        {
          i = n;
          localObject1 = localObject2;
          if (((ArticleInfo)localObject3).mSocialFeedInfo.jdField_a_of_type_Qda != null)
          {
            qda localqda = ((ArticleInfo)localObject3).mSocialFeedInfo.jdField_a_of_type_Qda;
            if (onh.a(localqda))
            {
              localObject1 = localqda.jdField_a_of_type_Qcg.a((ArticleInfo)localObject3, "3", parampbg);
              i = 6;
            }
            else
            {
              if ((puy.c((ArticleInfo)localObject3)) && (!ram.q((ArticleInfo)localObject3)))
              {
                localObject2 = ((qdc)((ArticleInfo)localObject3).mSocialFeedInfo.jdField_a_of_type_Qda.b.get(0)).e;
                if (TextUtils.isEmpty((CharSequence)localObject2)) {
                  break label984;
                }
                localObject1 = omr.a((String)localObject2);
                parampbg = (pbg)localObject1;
                if (TextUtils.equals((CharSequence)localObject1, (CharSequence)localObject2)) {
                  parampbg = axau.b((String)localObject2);
                }
                parampbg = new aykk(parampbg, 7, 16);
              }
              for (i = 7;; i = i1)
              {
                localObject1 = parampbg;
                break;
                i = n;
                localObject1 = localObject2;
                if (TextUtils.isEmpty(localqda.jdField_a_of_type_JavaLangString)) {
                  break;
                }
                parampbg = null;
                try
                {
                  localObject1 = axau.b(localqda.jdField_a_of_type_JavaLangString);
                  parampbg = (pbg)localObject1;
                }
                catch (Exception localException)
                {
                  label959:
                  break label959;
                }
                localObject1 = new aykk(parampbg, 7, 16);
                i = 8;
                break;
                label984:
                parampbg = "";
              }
              i = 0;
            }
          }
        }
      }
    }
  }
  
  public static CharSequence c(BaseArticleInfo paramBaseArticleInfo, pbg parampbg)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    paramBaseArticleInfo = a((ArticleInfo)paramBaseArticleInfo);
    NativeSummaryView.a(paramBaseArticleInfo, localSpannableStringBuilder, parampbg);
    NativeSummaryView.b(paramBaseArticleInfo, localSpannableStringBuilder, parampbg);
    return localSpannableStringBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rvn
 * JD-Core Version:    0.7.0.1
 */