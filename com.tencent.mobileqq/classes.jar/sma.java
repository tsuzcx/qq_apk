import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeSummaryView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class sma
{
  static CharSequence a(BaseArticleInfo paramBaseArticleInfo, pgr parampgr)
  {
    if (paramBaseArticleInfo == null) {
      return "";
    }
    SocializeFeedsInfo localSocializeFeedsInfo;
    int i;
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null))
    {
      localSocializeFeedsInfo = paramBaseArticleInfo.mSocialFeedInfo;
      if ((localSocializeFeedsInfo.jdField_a_of_type_Qmc != null) && (localSocializeFeedsInfo.jdField_a_of_type_Qmc.a != null) && (localSocializeFeedsInfo.jdField_a_of_type_Qmc.a.size() > 0) && ((localSocializeFeedsInfo.jdField_a_of_type_Qmc.a.size() != 1) || ((!TextUtils.isEmpty(((SocializeFeedsInfo.BiuCommentInfo)localSocializeFeedsInfo.jdField_a_of_type_Qmc.a.get(0)).jdField_a_of_type_JavaLangString)) && (!TextUtils.equals(((SocializeFeedsInfo.BiuCommentInfo)localSocializeFeedsInfo.jdField_a_of_type_Qmc.a.get(0)).jdField_a_of_type_JavaLangString, ":")) && (!TextUtils.equals(((SocializeFeedsInfo.BiuCommentInfo)localSocializeFeedsInfo.jdField_a_of_type_Qmc.a.get(0)).jdField_a_of_type_JavaLangString, "：")))))
      {
        SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
        parampgr = localSocializeFeedsInfo.jdField_a_of_type_Qmc.a((ArticleInfo)paramBaseArticleInfo, "5", parampgr);
        if (!TextUtils.isEmpty(parampgr)) {
          localSpannableStringBuilder.append(parampgr);
        }
        i = 1;
        parampgr = localSpannableStringBuilder;
      }
    }
    for (;;)
    {
      parampgr = a(parampgr, paramBaseArticleInfo);
      QLog.d("Utils", 2, "makeBiuComment: " + paramBaseArticleInfo.rawkey + " ssb: " + parampgr + " condition flag: " + i);
      return parampgr;
      if (!TextUtils.isEmpty(localSocializeFeedsInfo.jdField_a_of_type_JavaLangString))
      {
        if (localSocializeFeedsInfo.jdField_a_of_type_JavaLangString.length() >= 100) {
          localSocializeFeedsInfo.jdField_a_of_type_JavaLangString = (localSocializeFeedsInfo.jdField_a_of_type_JavaLangString.substring(0, 99) + '…');
        }
        parampgr = localSocializeFeedsInfo.jdField_a_of_type_JavaLangString;
        i = 1;
      }
      else
      {
        i = 0;
        parampgr = "";
      }
    }
  }
  
  public static CharSequence a(CharSequence paramCharSequence, int paramInt)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    int i = 0;
    while (i < paramInt)
    {
      localSpannableStringBuilder.append(" ");
      i += 1;
    }
    localSpannableStringBuilder.append(paramCharSequence);
    QLog.d("Utils", 1, "addPreBlank: " + localSpannableStringBuilder);
    return localSpannableStringBuilder;
  }
  
  public static CharSequence a(CharSequence paramCharSequence, long paramLong, BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject = new StringBuilder().append(ReadInJoyUserInfoModule.a(paramLong, null, ReadInJoyUserInfoModule.a()));
    if (!TextUtils.isEmpty(paramBaseArticleInfo.articleViewModel.jdField_a_of_type_JavaLangString)) {}
    for (String str = " ";; str = "：")
    {
      str = str;
      localObject = new SpannableStringBuilder(str);
      ((SpannableStringBuilder)localObject).append(paramCharSequence);
      ((SpannableStringBuilder)localObject).setSpan(new shh(paramLong, "2", (ArticleInfo)paramBaseArticleInfo), 0, str.length(), 18);
      QLog.d("Utils", 1, "addPreAuthor: " + localObject);
      return localObject;
    }
  }
  
  public static CharSequence a(CharSequence paramCharSequence, BaseArticleInfo paramBaseArticleInfo)
  {
    CharSequence localCharSequence = paramCharSequence;
    if (paramBaseArticleInfo != null)
    {
      localCharSequence = paramCharSequence;
      if (paramBaseArticleInfo.articleViewModel != null)
      {
        localCharSequence = paramCharSequence;
        if (!TextUtils.isEmpty(paramBaseArticleInfo.articleViewModel.jdField_a_of_type_JavaLangString)) {
          localCharSequence = a(paramCharSequence, paramBaseArticleInfo.articleViewModel.jdField_a_of_type_JavaLangString);
        }
        paramCharSequence = localCharSequence;
        if (paramBaseArticleInfo.articleViewModel.jdField_a_of_type_Long != 0L) {
          paramCharSequence = a(localCharSequence, paramBaseArticleInfo.articleViewModel.jdField_a_of_type_Long, paramBaseArticleInfo);
        }
        localCharSequence = paramCharSequence;
        if (paramBaseArticleInfo.articleViewModel.jdField_a_of_type_Int != 0) {
          localCharSequence = a(paramCharSequence, paramBaseArticleInfo.articleViewModel.jdField_a_of_type_Int);
        }
      }
    }
    return new baig(localCharSequence, 3, 16);
  }
  
  public static CharSequence a(CharSequence paramCharSequence, String paramString)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramString);
    localSpannableStringBuilder.append(paramCharSequence);
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(-6908266), 0, paramString.length(), 18);
    QLog.d("Utils", 1, "addPreCommentText: " + localSpannableStringBuilder);
    return localSpannableStringBuilder;
  }
  
  public static pgd a(ArticleInfo paramArticleInfo)
  {
    return new pgq(null, paramArticleInfo, rqj.c(paramArticleInfo), (int)paramArticleInfo.mChannelID, 0, 0, false, 0, null, null);
  }
  
  static CharSequence b(BaseArticleInfo paramBaseArticleInfo, pgr parampgr)
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
    switch (rqj.c((ArticleInfo)localObject3))
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
          break label428;
        }
        i = 9;
        if ((localObject3 == null) || (((ArticleInfo)localObject3).mSocialFeedInfo == null) || (((ArticleInfo)localObject3).mSocialFeedInfo.jdField_a_of_type_Qmr == null) || (TextUtils.isEmpty(((ArticleInfo)localObject3).mSocialFeedInfo.jdField_a_of_type_Qmr.jdField_a_of_type_JavaLangString))) {
          break label395;
        }
        if (((ArticleInfo)localObject3).mSocialFeedInfo.jdField_a_of_type_Int != 19191924) {
          break label379;
        }
      }
      break;
    }
    for (;;)
    {
      try
      {
        localObject1 = shf.a(((ArticleInfo)localObject3).mSocialFeedInfo.jdField_a_of_type_Qmr.jdField_a_of_type_JavaLangString, ((ArticleInfo)localObject3).mSocialFeedInfo.jdField_a_of_type_Qmk.a.b, ((ArticleInfo)localObject3).mSocialFeedInfo.jdField_a_of_type_Qmk.a.jdField_a_of_type_JavaLangString, ((ArticleInfo)localObject3).mSocialFeedInfo.jdField_a_of_type_Qmk.a.c, (ArticleInfo)localObject3);
        parampgr = a((CharSequence)localObject1, paramBaseArticleInfo);
        QLog.d("Utils", 2, "makeNonBiuComment: " + paramBaseArticleInfo.rawkey + " ssb: " + parampgr + " condition flag: " + i);
        return parampgr;
        i = 1;
        k = 0;
        j = 1;
        m = i;
        break;
        j = 0;
        k = 1;
        m = 0;
      }
      catch (NullPointerException parampgr)
      {
        QLog.e("Utils", 2, parampgr.toString());
        localObject1 = localObject2;
        continue;
      }
      label379:
      localObject1 = ((ArticleInfo)localObject3).mSocialFeedInfo.jdField_a_of_type_Qmr.jdField_a_of_type_JavaLangString;
      continue;
      label395:
      if ((localObject3 != null) && (!TextUtils.isEmpty(((ArticleInfo)localObject3).mTitle)))
      {
        localObject1 = ((ArticleInfo)localObject3).mTitle;
      }
      else
      {
        localObject1 = "";
        continue;
        label428:
        if (k != 0)
        {
          localObject1 = ((ArticleInfo)localObject3).mTitle;
          i = 1;
        }
        else if ((rqj.a((ArticleInfo)localObject3)) || (rqj.d((BaseArticleInfo)localObject3)) || (rqj.h((ArticleInfo)localObject3)))
        {
          if (m != 0)
          {
            localObject1 = new SpannableStringBuilder();
            if ((((ArticleInfo)localObject3).mSocialFeedInfo != null) && (((ArticleInfo)localObject3).mSocialFeedInfo.jdField_a_of_type_Qmr != null) && (((ArticleInfo)localObject3).mSocialFeedInfo.jdField_a_of_type_Qmr.jdField_a_of_type_JavaLangString != null))
            {
              ((SpannableStringBuilder)localObject1).append(((ArticleInfo)localObject3).mSocialFeedInfo.jdField_a_of_type_Qmr.jdField_a_of_type_JavaLangString);
              if (QLog.isColorLevel()) {
                QLog.d("Q.readinjoy.ui", 2, "Comment String: " + ((ArticleInfo)localObject3).mSocialFeedInfo.jdField_a_of_type_Qmr.jdField_a_of_type_JavaLangString);
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
            for (parampgr = ((ArticleInfo)localObject3).mTitle;; parampgr = ((ArticleInfo)localObject3).mSummary)
            {
              i = 3;
              localObject1 = parampgr;
              break;
            }
          }
          if (rqj.d((BaseArticleInfo)localObject3))
          {
            localObject1 = new StringBuilder(alpo.a(2131716412));
            if (!rqj.g(paramBaseArticleInfo))
            {
              localObject2 = (qno)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qnm.a.get(0);
              localObject3 = ((StringBuilder)localObject1).append("“");
              if (!TextUtils.isEmpty(((qno)localObject2).c)) {
                break label754;
              }
              parampgr = "";
              label714:
              localObject3 = ((StringBuilder)localObject3).append(parampgr);
              if (!TextUtils.isEmpty(((qno)localObject2).jdField_a_of_type_JavaLangString)) {
                break label763;
              }
            }
            label754:
            label763:
            for (parampgr = "";; parampgr = ((qno)localObject2).jdField_a_of_type_JavaLangString)
            {
              ((StringBuilder)localObject3).append(parampgr).append("”");
              i = 4;
              break;
              parampgr = ((qno)localObject2).c;
              break label714;
            }
          }
          localObject1 = ((ArticleInfo)localObject3).mSummary;
          i = 5;
        }
        else
        {
          i = n;
          localObject1 = localObject2;
          if (((ArticleInfo)localObject3).mSocialFeedInfo.jdField_a_of_type_Qmw != null)
          {
            qmw localqmw = ((ArticleInfo)localObject3).mSocialFeedInfo.jdField_a_of_type_Qmw;
            if (ors.a(localqmw))
            {
              localObject1 = localqmw.jdField_a_of_type_Qmc.a((ArticleInfo)localObject3, "3", parampgr);
              i = 6;
            }
            else
            {
              if ((qbs.c((ArticleInfo)localObject3)) && (!rqj.q((ArticleInfo)localObject3)))
              {
                localObject2 = ((qmy)((ArticleInfo)localObject3).mSocialFeedInfo.jdField_a_of_type_Qmw.b.get(0)).e;
                if (TextUtils.isEmpty((CharSequence)localObject2)) {
                  break label993;
                }
                localObject1 = orc.a((String)localObject2);
                parampgr = (pgr)localObject1;
                if (TextUtils.equals((CharSequence)localObject1, (CharSequence)localObject2)) {
                  parampgr = ayvy.b((String)localObject2);
                }
                parampgr = new baig(parampgr, 3, 16);
              }
              for (i = 7;; i = i1)
              {
                localObject1 = parampgr;
                break;
                i = n;
                localObject1 = localObject2;
                if (TextUtils.isEmpty(localqmw.jdField_a_of_type_JavaLangString)) {
                  break;
                }
                parampgr = null;
                try
                {
                  localObject1 = ayvy.b(localqmw.jdField_a_of_type_JavaLangString);
                  parampgr = (pgr)localObject1;
                }
                catch (Exception localException)
                {
                  label969:
                  break label969;
                }
                localObject1 = new baig(parampgr, 3, 16);
                i = 8;
                break;
                label993:
                parampgr = "";
              }
              i = 0;
            }
          }
        }
      }
    }
  }
  
  public static CharSequence c(BaseArticleInfo paramBaseArticleInfo, pgr parampgr)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    paramBaseArticleInfo = a((ArticleInfo)paramBaseArticleInfo);
    NativeSummaryView.a(paramBaseArticleInfo, localSpannableStringBuilder, parampgr);
    NativeSummaryView.b(paramBaseArticleInfo, localSpannableStringBuilder, parampgr);
    return localSpannableStringBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sma
 * JD-Core Version:    0.7.0.1
 */