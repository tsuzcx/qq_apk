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
import org.jetbrains.annotations.NotNull;

public class tbp
{
  static CharSequence a(int paramInt, BaseArticleInfo paramBaseArticleInfo, pql parampql)
  {
    if (paramBaseArticleInfo == null) {
      return "";
    }
    Object localObject2;
    Object localObject1;
    int i;
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null))
    {
      localObject2 = paramBaseArticleInfo.mSocialFeedInfo;
      if ((((SocializeFeedsInfo)localObject2).jdField_a_of_type_Qxr != null) && (((SocializeFeedsInfo)localObject2).jdField_a_of_type_Qxr.a != null) && (((SocializeFeedsInfo)localObject2).jdField_a_of_type_Qxr.a.size() > 0) && ((((SocializeFeedsInfo)localObject2).jdField_a_of_type_Qxr.a.size() != 1) || ((!TextUtils.isEmpty(((SocializeFeedsInfo.BiuCommentInfo)((SocializeFeedsInfo)localObject2).jdField_a_of_type_Qxr.a.get(0)).jdField_a_of_type_JavaLangString)) && (!TextUtils.equals(((SocializeFeedsInfo.BiuCommentInfo)((SocializeFeedsInfo)localObject2).jdField_a_of_type_Qxr.a.get(0)).jdField_a_of_type_JavaLangString, ":")) && (!TextUtils.equals(((SocializeFeedsInfo.BiuCommentInfo)((SocializeFeedsInfo)localObject2).jdField_a_of_type_Qxr.a.get(0)).jdField_a_of_type_JavaLangString, "：")))))
      {
        localObject1 = new SpannableStringBuilder();
        localObject2 = ((SocializeFeedsInfo)localObject2).jdField_a_of_type_Qxr.a(paramInt, (ArticleInfo)paramBaseArticleInfo, "5", parampql);
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((SpannableStringBuilder)localObject1).append((CharSequence)localObject2);
        }
        i = 1;
      }
    }
    for (;;)
    {
      parampql = a(paramInt, (CharSequence)localObject1, paramBaseArticleInfo, parampql);
      QLog.d("Utils", 2, "makeBiuComment: " + paramBaseArticleInfo.rawkey + " ssb: " + parampql + " condition flag: " + i + ", linkTextColor " + paramInt);
      return parampql;
      if (!TextUtils.isEmpty(((SocializeFeedsInfo)localObject2).jdField_a_of_type_JavaLangString))
      {
        if (((SocializeFeedsInfo)localObject2).jdField_a_of_type_JavaLangString.length() >= 100) {
          ((SocializeFeedsInfo)localObject2).jdField_a_of_type_JavaLangString = (((SocializeFeedsInfo)localObject2).jdField_a_of_type_JavaLangString.substring(0, 99) + '…');
        }
        localObject1 = ((SocializeFeedsInfo)localObject2).jdField_a_of_type_JavaLangString;
        i = 1;
      }
      else
      {
        i = 0;
        localObject1 = "";
      }
    }
  }
  
  public static CharSequence a(int paramInt, CharSequence paramCharSequence, long paramLong, BaseArticleInfo paramBaseArticleInfo, pql parampql)
  {
    Object localObject = new StringBuilder().append(ReadInJoyUserInfoModule.a(paramLong, parampql, ReadInJoyUserInfoModule.a()));
    if (!TextUtils.isEmpty(paramBaseArticleInfo.articleViewModel.jdField_a_of_type_JavaLangString)) {}
    for (parampql = " ";; parampql = "：")
    {
      parampql = parampql;
      localObject = new SpannableStringBuilder(parampql);
      ((SpannableStringBuilder)localObject).append(paramCharSequence);
      ((SpannableStringBuilder)localObject).setSpan(new sws(paramLong, "2", (ArticleInfo)paramBaseArticleInfo, paramInt), 0, parampql.length(), 18);
      QLog.d("Utils", 1, "addPreAuthor: " + localObject + ", linkTextColor: " + paramInt);
      return localObject;
    }
  }
  
  public static CharSequence a(int paramInt, CharSequence paramCharSequence, BaseArticleInfo paramBaseArticleInfo, pql parampql)
  {
    CharSequence localCharSequence = paramCharSequence;
    if (paramBaseArticleInfo != null)
    {
      localCharSequence = paramCharSequence;
      if (paramBaseArticleInfo.articleViewModel != null)
      {
        if (TextUtils.isEmpty(paramBaseArticleInfo.articleViewModel.jdField_a_of_type_JavaLangString)) {
          break label113;
        }
        paramCharSequence = a(paramCharSequence, paramBaseArticleInfo.articleViewModel.jdField_a_of_type_JavaLangString);
      }
    }
    label113:
    for (;;)
    {
      localCharSequence = paramCharSequence;
      if (paramBaseArticleInfo.articleViewModel.jdField_a_of_type_Long != 0L) {
        localCharSequence = a(paramInt, paramCharSequence, paramBaseArticleInfo.articleViewModel.jdField_a_of_type_Long, paramBaseArticleInfo, parampql);
      }
      if (paramBaseArticleInfo.articleViewModel.jdField_a_of_type_Int != 0) {
        localCharSequence = a(localCharSequence, paramBaseArticleInfo.articleViewModel.jdField_a_of_type_Int);
      }
      for (;;)
      {
        return new begp(localCharSequence, 3, 16);
      }
    }
  }
  
  @NotNull
  private static CharSequence a(ArticleInfo paramArticleInfo)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyg != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyg.jdField_a_of_type_JavaLangString != null))
    {
      localSpannableStringBuilder.append(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyg.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.ui", 2, "Comment String: " + paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyg.jdField_a_of_type_JavaLangString);
      }
    }
    while (paramArticleInfo.mTitle == null) {
      return localSpannableStringBuilder;
    }
    localSpannableStringBuilder.append(paramArticleInfo.mTitle);
    return localSpannableStringBuilder;
  }
  
  private static CharSequence a(ArticleInfo paramArticleInfo, CharSequence paramCharSequence)
  {
    if ((paramArticleInfo != null) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyg != null) && (!TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyg.jdField_a_of_type_JavaLangString)))
    {
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 19191924) {
        try
        {
          paramArticleInfo = swp.a(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyg.jdField_a_of_type_JavaLangString, paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxz.a.b, paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxz.a.jdField_a_of_type_JavaLangString, paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxz.a.c, paramArticleInfo);
          return paramArticleInfo;
        }
        catch (NullPointerException paramArticleInfo)
        {
          QLog.e("Utils", 2, paramArticleInfo.toString());
          return paramCharSequence;
        }
      }
      return paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyg.jdField_a_of_type_JavaLangString;
    }
    if ((paramArticleInfo != null) && (!TextUtils.isEmpty(paramArticleInfo.mTitle))) {
      return paramArticleInfo.mTitle;
    }
    return "";
  }
  
  @NotNull
  private static CharSequence a(BaseArticleInfo paramBaseArticleInfo)
  {
    StringBuilder localStringBuilder1 = new StringBuilder(anzj.a(2131714810));
    qzd localqzd;
    StringBuilder localStringBuilder2;
    if (!sel.l(paramBaseArticleInfo))
    {
      localqzd = (qzd)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qzb.a.get(0);
      localStringBuilder2 = localStringBuilder1.append("“");
      if (!TextUtils.isEmpty(localqzd.c)) {
        break label92;
      }
      paramBaseArticleInfo = "";
      localStringBuilder2 = localStringBuilder2.append(paramBaseArticleInfo);
      if (!TextUtils.isEmpty(localqzd.jdField_a_of_type_JavaLangString)) {
        break label100;
      }
    }
    label92:
    label100:
    for (paramBaseArticleInfo = "";; paramBaseArticleInfo = localqzd.jdField_a_of_type_JavaLangString)
    {
      localStringBuilder2.append(paramBaseArticleInfo).append("”");
      return localStringBuilder1;
      paramBaseArticleInfo = localqzd.c;
      break;
    }
  }
  
  static CharSequence a(BaseArticleInfo paramBaseArticleInfo, pql parampql)
  {
    return a(-15504151, paramBaseArticleInfo, parampql);
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
  
  public static CharSequence a(CharSequence paramCharSequence, BaseArticleInfo paramBaseArticleInfo, pql parampql)
  {
    return a(-15504151, paramCharSequence, paramBaseArticleInfo, parampql);
  }
  
  public static CharSequence a(CharSequence paramCharSequence, String paramString)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramString);
    localSpannableStringBuilder.append(paramCharSequence);
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(-6908266), 0, paramString.length(), 18);
    QLog.d("Utils", 1, "addPreCommentText: " + localSpannableStringBuilder);
    return localSpannableStringBuilder;
  }
  
  @NotNull
  private static CharSequence a(String paramString)
  {
    String str2 = ozc.a(paramString);
    String str1 = str2;
    if (TextUtils.equals(str2, paramString)) {
      str1 = bcsa.b(paramString);
    }
    return new begp(str1, 3, 16);
  }
  
  public static ppu a(ArticleInfo paramArticleInfo)
  {
    return new pqk(null, paramArticleInfo, sel.c(paramArticleInfo), (int)paramArticleInfo.mChannelID, 0, 0, false, 0, null, null);
  }
  
  public static CharSequence b(int paramInt, BaseArticleInfo paramBaseArticleInfo, pql parampql)
  {
    QLog.d("Utils", 1, "makeSummaryText: " + paramInt);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    paramBaseArticleInfo = a((ArticleInfo)paramBaseArticleInfo);
    NativeSummaryView.a(paramInt, paramBaseArticleInfo, localSpannableStringBuilder, parampql);
    NativeSummaryView.a(paramBaseArticleInfo, localSpannableStringBuilder, parampql);
    return localSpannableStringBuilder;
  }
  
  static CharSequence b(BaseArticleInfo paramBaseArticleInfo, pql parampql)
  {
    int i1 = 0;
    int n = 0;
    ArticleInfo localArticleInfo = (ArticleInfo)paramBaseArticleInfo;
    if (localArticleInfo == null) {
      return "";
    }
    String str = "";
    int j;
    int k;
    int m;
    Object localObject;
    switch (sel.c(localArticleInfo))
    {
    default: 
      j = 0;
      k = 0;
      m = 0;
      i = n;
      localObject = str;
      if (paramBaseArticleInfo.mSocialFeedInfo != null)
      {
        if (paramBaseArticleInfo.isPGCShortContent())
        {
          i = 9;
          localObject = a(localArticleInfo, "");
        }
      }
      else
      {
        label177:
        parampql = a((CharSequence)localObject, paramBaseArticleInfo, parampql);
        QLog.d("Utils", 2, "makeNonBiuComment: " + paramBaseArticleInfo.rawkey + " ssb: " + parampql + " condition flag: " + i);
        return parampql;
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
      if (k != 0)
      {
        localObject = localArticleInfo.mTitle;
        i = 1;
        break label177;
      }
      if ((sel.a(localArticleInfo)) || (sel.i(localArticleInfo)) || (sel.h(localArticleInfo)))
      {
        if (m != 0)
        {
          localObject = a(localArticleInfo);
          i = 2;
          break label177;
        }
        if (j != 0)
        {
          if (!TextUtils.isEmpty(localArticleInfo.mTitle)) {}
          for (localObject = localArticleInfo.mTitle;; localObject = localArticleInfo.mSummary)
          {
            i = 3;
            break;
          }
        }
        if (sel.i(localArticleInfo))
        {
          localObject = a(paramBaseArticleInfo);
          i = 4;
          break label177;
        }
        localObject = localArticleInfo.mSummary;
        i = 5;
        break label177;
      }
      i = n;
      localObject = str;
      if (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl == null) {
        break label177;
      }
      qyl localqyl = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl;
      if (ozs.a(localqyl))
      {
        localObject = localqyl.jdField_a_of_type_Qxr.a(localArticleInfo, "3", parampql);
        i = 6;
        break label177;
      }
      if ((qno.c(localArticleInfo)) && (!sel.q(localArticleInfo)))
      {
        localObject = ((qyn)localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.b.get(0)).e;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label562;
        }
        localObject = a((String)localObject);
      }
      for (i = 7;; i = i1)
      {
        break;
        i = n;
        localObject = str;
        if (TextUtils.isEmpty(localqyl.jdField_a_of_type_JavaLangString)) {
          break;
        }
        localObject = null;
        try
        {
          str = bcsa.b(localqyl.jdField_a_of_type_JavaLangString);
          localObject = str;
        }
        catch (Exception localException)
        {
          label537:
          break label537;
        }
        localObject = new begp((CharSequence)localObject, 3, 16);
        i = 8;
        break;
        label562:
        localObject = "";
      }
    }
  }
  
  public static CharSequence c(BaseArticleInfo paramBaseArticleInfo, pql parampql)
  {
    return b(-15504151, paramBaseArticleInfo, parampql);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tbp
 * JD-Core Version:    0.7.0.1
 */