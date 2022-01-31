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

public class rvq
{
  static CharSequence a(BaseArticleInfo paramBaseArticleInfo, pbj parampbj)
  {
    if (paramBaseArticleInfo == null) {
      return "";
    }
    SocializeFeedsInfo localSocializeFeedsInfo;
    int i;
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null))
    {
      localSocializeFeedsInfo = paramBaseArticleInfo.mSocialFeedInfo;
      if ((localSocializeFeedsInfo.jdField_a_of_type_Qcj != null) && (localSocializeFeedsInfo.jdField_a_of_type_Qcj.a != null) && (localSocializeFeedsInfo.jdField_a_of_type_Qcj.a.size() > 0) && ((localSocializeFeedsInfo.jdField_a_of_type_Qcj.a.size() != 1) || ((!TextUtils.isEmpty(((SocializeFeedsInfo.BiuCommentInfo)localSocializeFeedsInfo.jdField_a_of_type_Qcj.a.get(0)).jdField_a_of_type_JavaLangString)) && (!TextUtils.equals(((SocializeFeedsInfo.BiuCommentInfo)localSocializeFeedsInfo.jdField_a_of_type_Qcj.a.get(0)).jdField_a_of_type_JavaLangString, ":")) && (!TextUtils.equals(((SocializeFeedsInfo.BiuCommentInfo)localSocializeFeedsInfo.jdField_a_of_type_Qcj.a.get(0)).jdField_a_of_type_JavaLangString, "：")))))
      {
        SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
        parampbj = localSocializeFeedsInfo.jdField_a_of_type_Qcj.a((ArticleInfo)paramBaseArticleInfo, "5", parampbj);
        if (!TextUtils.isEmpty(parampbj)) {
          localSpannableStringBuilder.append(parampbj);
        }
        i = 1;
        parampbj = localSpannableStringBuilder;
      }
    }
    for (;;)
    {
      QLog.d("Utils", 2, "makeBiuComment: " + paramBaseArticleInfo.rawkey + " ssb: " + parampbj + " condition flag: " + i);
      return parampbj;
      if (!TextUtils.isEmpty(localSocializeFeedsInfo.jdField_a_of_type_JavaLangString))
      {
        if (localSocializeFeedsInfo.jdField_a_of_type_JavaLangString.length() >= 100) {
          localSocializeFeedsInfo.jdField_a_of_type_JavaLangString = (localSocializeFeedsInfo.jdField_a_of_type_JavaLangString.substring(0, 99) + '…');
        }
        parampbj = localSocializeFeedsInfo.jdField_a_of_type_JavaLangString;
        i = 1;
      }
      else
      {
        i = 0;
        parampbj = "";
      }
    }
  }
  
  public static pax a(ArticleInfo paramArticleInfo)
  {
    return new pbi(null, paramArticleInfo, rap.c(paramArticleInfo), (int)paramArticleInfo.mChannelID, 0, 0, false, 0, null, null);
  }
  
  static CharSequence b(BaseArticleInfo paramBaseArticleInfo, pbj parampbj)
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
    switch (rap.c((ArticleInfo)localObject3))
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
        if ((localObject3 == null) || (((ArticleInfo)localObject3).mSocialFeedInfo == null) || (((ArticleInfo)localObject3).mSocialFeedInfo.jdField_a_of_type_Qcy == null) || (TextUtils.isEmpty(((ArticleInfo)localObject3).mSocialFeedInfo.jdField_a_of_type_Qcy.jdField_a_of_type_JavaLangString))) {
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
        localObject1 = rrj.a(((ArticleInfo)localObject3).mSocialFeedInfo.jdField_a_of_type_Qcy.jdField_a_of_type_JavaLangString, ((ArticleInfo)localObject3).mSocialFeedInfo.jdField_a_of_type_Qcr.a.b, ((ArticleInfo)localObject3).mSocialFeedInfo.jdField_a_of_type_Qcr.a.jdField_a_of_type_JavaLangString, ((ArticleInfo)localObject3).mSocialFeedInfo.jdField_a_of_type_Qcr.a.c, (ArticleInfo)localObject3);
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
      catch (NullPointerException parampbj)
      {
        QLog.e("Utils", 2, parampbj.toString());
        localObject1 = localObject2;
        continue;
      }
      label374:
      localObject1 = ((ArticleInfo)localObject3).mSocialFeedInfo.jdField_a_of_type_Qcy.jdField_a_of_type_JavaLangString;
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
        else if ((rap.a((ArticleInfo)localObject3)) || (rap.c((BaseArticleInfo)localObject3)) || (rap.h((ArticleInfo)localObject3)))
        {
          if (m != 0)
          {
            localObject1 = new SpannableStringBuilder();
            if ((((ArticleInfo)localObject3).mSocialFeedInfo != null) && (((ArticleInfo)localObject3).mSocialFeedInfo.jdField_a_of_type_Qcy != null) && (((ArticleInfo)localObject3).mSocialFeedInfo.jdField_a_of_type_Qcy.jdField_a_of_type_JavaLangString != null))
            {
              ((SpannableStringBuilder)localObject1).append(((ArticleInfo)localObject3).mSocialFeedInfo.jdField_a_of_type_Qcy.jdField_a_of_type_JavaLangString);
              if (QLog.isColorLevel()) {
                QLog.d("Q.readinjoy.ui", 2, "Comment String: " + ((ArticleInfo)localObject3).mSocialFeedInfo.jdField_a_of_type_Qcy.jdField_a_of_type_JavaLangString);
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
            for (parampbj = ((ArticleInfo)localObject3).mTitle;; parampbj = ((ArticleInfo)localObject3).mSummary)
            {
              i = 3;
              localObject1 = parampbj;
              break;
            }
          }
          if (rap.c((BaseArticleInfo)localObject3))
          {
            localObject1 = new StringBuilder(ajyc.a(2131716029));
            if (!rap.f(paramBaseArticleInfo))
            {
              localObject2 = (qdv)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qdt.a.get(0);
              localObject3 = ((StringBuilder)localObject1).append("“");
              if (!TextUtils.isEmpty(((qdv)localObject2).c)) {
                break label744;
              }
              parampbj = "";
              label705:
              localObject3 = ((StringBuilder)localObject3).append(parampbj);
              if (!TextUtils.isEmpty(((qdv)localObject2).jdField_a_of_type_JavaLangString)) {
                break label753;
              }
            }
            label744:
            label753:
            for (parampbj = "";; parampbj = ((qdv)localObject2).jdField_a_of_type_JavaLangString)
            {
              ((StringBuilder)localObject3).append(parampbj).append("”");
              i = 4;
              break;
              parampbj = ((qdv)localObject2).c;
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
          if (((ArticleInfo)localObject3).mSocialFeedInfo.jdField_a_of_type_Qdd != null)
          {
            qdd localqdd = ((ArticleInfo)localObject3).mSocialFeedInfo.jdField_a_of_type_Qdd;
            if (onk.a(localqdd))
            {
              localObject1 = localqdd.jdField_a_of_type_Qcj.a((ArticleInfo)localObject3, "3", parampbj);
              i = 6;
            }
            else
            {
              if ((pvb.c((ArticleInfo)localObject3)) && (!rap.q((ArticleInfo)localObject3)))
              {
                localObject2 = ((qdf)((ArticleInfo)localObject3).mSocialFeedInfo.jdField_a_of_type_Qdd.b.get(0)).e;
                if (TextUtils.isEmpty((CharSequence)localObject2)) {
                  break label984;
                }
                localObject1 = omu.a((String)localObject2);
                parampbj = (pbj)localObject1;
                if (TextUtils.equals((CharSequence)localObject1, (CharSequence)localObject2)) {
                  parampbj = axas.b((String)localObject2);
                }
                parampbj = new ayki(parampbj, 7, 16);
              }
              for (i = 7;; i = i1)
              {
                localObject1 = parampbj;
                break;
                i = n;
                localObject1 = localObject2;
                if (TextUtils.isEmpty(localqdd.jdField_a_of_type_JavaLangString)) {
                  break;
                }
                parampbj = null;
                try
                {
                  localObject1 = axas.b(localqdd.jdField_a_of_type_JavaLangString);
                  parampbj = (pbj)localObject1;
                }
                catch (Exception localException)
                {
                  label959:
                  break label959;
                }
                localObject1 = new ayki(parampbj, 7, 16);
                i = 8;
                break;
                label984:
                parampbj = "";
              }
              i = 0;
            }
          }
        }
      }
    }
  }
  
  public static CharSequence c(BaseArticleInfo paramBaseArticleInfo, pbj parampbj)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    paramBaseArticleInfo = a((ArticleInfo)paramBaseArticleInfo);
    NativeSummaryView.a(paramBaseArticleInfo, localSpannableStringBuilder, parampbj);
    NativeSummaryView.b(paramBaseArticleInfo, localSpannableStringBuilder, parampbj);
    return localSpannableStringBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rvq
 * JD-Core Version:    0.7.0.1
 */