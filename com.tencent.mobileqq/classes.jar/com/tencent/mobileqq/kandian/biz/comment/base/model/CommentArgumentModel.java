package com.tencent.mobileqq.kandian.biz.comment.base.model;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager;
import com.tencent.mobileqq.kandian.biz.comment.entity.SimpleCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentCreateData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentData;
import com.tencent.mobileqq.kandian.biz.comment.helper.DraftDataUtil;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.repo.account.ArticleInfoHelper;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJBiuAndCommentAladdinUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tkd.comment.publisher.qq.model.TkdQQArgument;
import com.tencent.tkd.comment.publisher.qq.model.TkdQQArticleInfo;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class CommentArgumentModel
{
  public int a;
  public final Intent a;
  public SimpleCommentData a;
  public AbsBaseArticleInfo a;
  public TkdQQArgument a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public boolean c;
  public int d;
  public String d;
  public boolean d;
  public int e;
  public String e;
  public boolean e;
  public int f;
  public String f;
  public boolean f;
  public int g;
  public boolean g;
  public boolean h;
  public boolean i;
  
  public CommentArgumentModel(Intent paramIntent)
  {
    this.jdField_a_of_type_Int = 140;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_d_of_type_Int = -1;
    this.jdField_e_of_type_Int = 1;
    this.jdField_f_of_type_Int = 1;
    this.jdField_g_of_type_Boolean = true;
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    b();
    a();
  }
  
  private TkdQQArticleInfo a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo == null) {
      return null;
    }
    TkdQQArticleInfo localTkdQQArticleInfo = new TkdQQArticleInfo();
    localTkdQQArticleInfo.mFeedType = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mFeedType;
    localTkdQQArticleInfo.mFeedId = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mFeedId;
    localTkdQQArticleInfo.mArticleID = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleID;
    localTkdQQArticleInfo.innerUniqueID = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID;
    localTkdQQArticleInfo.toUin = ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
    return localTkdQQArticleInfo;
  }
  
  private CharSequence a()
  {
    Object localObject2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("comment_recreate_draft");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = DraftDataUtil.a(a());
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("arg_comment_default_txt");
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = EmotionCodecUtils.b(((CharSequence)localObject1).toString());
      }
    }
    return localObject2;
  }
  
  private static String a(AbsBaseArticleInfo paramAbsBaseArticleInfo, SimpleCommentData paramSimpleCommentData)
  {
    if (paramAbsBaseArticleInfo != null) {
      return paramAbsBaseArticleInfo.innerUniqueID;
    }
    if (paramSimpleCommentData != null) {
      return paramSimpleCommentData.c();
    }
    return "";
  }
  
  public static String a(AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString, SimpleCommentData paramSimpleCommentData)
  {
    String str1 = a(paramAbsBaseArticleInfo, paramSimpleCommentData);
    String str2 = a(paramString, paramSimpleCommentData);
    paramAbsBaseArticleInfo = b(paramAbsBaseArticleInfo, paramString, paramSimpleCommentData);
    try
    {
      paramSimpleCommentData = new JSONObject();
      if (!TextUtils.isEmpty(str1)) {
        paramSimpleCommentData.put("innerUniqueID", str1);
      }
      if (!TextUtils.isEmpty(paramString)) {
        paramSimpleCommentData.put("commentId", str2);
      }
      if (!TextUtils.isEmpty(paramAbsBaseArticleInfo)) {
        paramSimpleCommentData.put("firstCommentId", paramAbsBaseArticleInfo);
      }
      paramAbsBaseArticleInfo = paramSimpleCommentData.toString();
      return paramAbsBaseArticleInfo;
    }
    catch (JSONException paramAbsBaseArticleInfo)
    {
      paramAbsBaseArticleInfo.printStackTrace();
    }
    return "";
  }
  
  private static String a(String paramString, SimpleCommentData paramSimpleCommentData)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    if ((paramSimpleCommentData != null) && ((paramSimpleCommentData instanceof SubCommentCreateData))) {
      return ((SubCommentCreateData)paramSimpleCommentData).a();
    }
    return "";
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentTkdCommentPublisherQqModelTkdQQArgument = new TkdQQArgument();
    TkdQQArgument localTkdQQArgument = this.jdField_a_of_type_ComTencentTkdCommentPublisherQqModelTkdQQArgument;
    localTkdQQArgument.isNativeCommentComponet = this.jdField_d_of_type_Boolean;
    localTkdQQArgument.mArticleInfo = a();
    localTkdQQArgument = this.jdField_a_of_type_ComTencentTkdCommentPublisherQqModelTkdQQArgument;
    localTkdQQArgument.mParentCommentAuthorUin = this.jdField_f_of_type_JavaLangString;
    localTkdQQArgument.mClickCommentEditViewSrc = this.jdField_d_of_type_Int;
    localTkdQQArgument.mSourceType = this.jdField_c_of_type_Int;
    localTkdQQArgument.isSecondCommentReplyUin = this.jdField_b_of_type_JavaLangString;
    localTkdQQArgument.isSecondCommentReply = this.jdField_e_of_type_Boolean;
    localTkdQQArgument.commentId = b();
    localTkdQQArgument = this.jdField_a_of_type_ComTencentTkdCommentPublisherQqModelTkdQQArgument;
    localTkdQQArgument.mCommentAuthorUin = this.jdField_d_of_type_JavaLangString;
    localTkdQQArgument.isNewCommentComponentType = this.jdField_g_of_type_Boolean;
    localTkdQQArgument.mCommentType = this.jdField_b_of_type_Int;
    localTkdQQArgument.defaultTxt = a();
    this.jdField_a_of_type_ComTencentTkdCommentPublisherQqModelTkdQQArgument.placeHolder = c();
    localTkdQQArgument = this.jdField_a_of_type_ComTencentTkdCommentPublisherQqModelTkdQQArgument;
    localTkdQQArgument.maxCharCount = this.jdField_a_of_type_Int;
    localTkdQQArgument.linkReply = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("comment_to_reply_contain_link", 2);
    localTkdQQArgument = this.jdField_a_of_type_ComTencentTkdCommentPublisherQqModelTkdQQArgument;
    localTkdQQArgument.linkEnable = this.jdField_c_of_type_Boolean;
    localTkdQQArgument.showGif = this.i;
    localTkdQQArgument.showLink = this.jdField_b_of_type_Boolean;
    boolean bool = false;
    localTkdQQArgument.showBiu = false;
    if (ReadInJoyHelper.o(a()) == 1) {
      bool = true;
    }
    localTkdQQArgument.selectBiu = bool;
    this.jdField_a_of_type_ComTencentTkdCommentPublisherQqModelTkdQQArgument.biuAndCommentSwitch = RIJBiuAndCommentAladdinUtils.a();
    this.jdField_a_of_type_ComTencentTkdCommentPublisherQqModelTkdQQArgument.biuEditorGuideWording = RIJBiuAndCommentAladdinUtils.b();
    this.jdField_a_of_type_ComTencentTkdCommentPublisherQqModelTkdQQArgument.biuEditorConfirmBtnWording = RIJBiuAndCommentAladdinUtils.c();
    this.jdField_a_of_type_ComTencentTkdCommentPublisherQqModelTkdQQArgument.biuEditorCheckBoxHidden = RIJBiuAndCommentAladdinUtils.d();
    this.jdField_a_of_type_ComTencentTkdCommentPublisherQqModelTkdQQArgument.biuEditorCheckBoxWording = RIJBiuAndCommentAladdinUtils.d();
    this.jdField_a_of_type_ComTencentTkdCommentPublisherQqModelTkdQQArgument.biuEditorDefaultStatus = RIJBiuAndCommentAladdinUtils.b();
    this.jdField_a_of_type_ComTencentTkdCommentPublisherQqModelTkdQQArgument.editorDefaultEnableRemember = RIJBiuAndCommentAladdinUtils.c();
  }
  
  private void a(Bundle paramBundle)
  {
    if (paramBundle.containsKey("comment_is_pgc_author"))
    {
      this.h = paramBundle.getBoolean("comment_is_pgc_author");
      return;
    }
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    boolean bool;
    if ((paramBundle != null) && (ReadInJoyCommentDataManager.a(paramBundle.innerUniqueID))) {
      bool = true;
    } else {
      bool = false;
    }
    this.h = bool;
  }
  
  private boolean a()
  {
    return TextUtils.isEmpty(a(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntitySimpleCommentData));
  }
  
  private String b()
  {
    return a(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntitySimpleCommentData);
  }
  
  private static String b(AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString, SimpleCommentData paramSimpleCommentData)
  {
    if ((paramSimpleCommentData != null) && ((paramSimpleCommentData instanceof SubCommentCreateData))) {
      return ((SubCommentCreateData)paramSimpleCommentData).f();
    }
    paramAbsBaseArticleInfo = ReadInJoyCommentDataManager.a(paramAbsBaseArticleInfo);
    if (paramAbsBaseArticleInfo != null)
    {
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.a(paramString);
      if ((paramAbsBaseArticleInfo instanceof SubCommentData)) {
        return ((SubCommentData)paramAbsBaseArticleInfo).parentCommentId;
      }
    }
    return "";
  }
  
  private void b()
  {
    Bundle localBundle = this.jdField_a_of_type_AndroidContentIntent.getExtras();
    if (localBundle == null) {
      return;
    }
    c(localBundle);
    d(localBundle);
    b(localBundle);
    Intent localIntent = this.jdField_a_of_type_AndroidContentIntent;
    boolean bool4 = false;
    this.jdField_e_of_type_Boolean = localIntent.getBooleanExtra("comment_reply_second", false);
    if (this.jdField_e_of_type_Boolean) {
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("comment_reply_second_uin");
    }
    this.jdField_d_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("comment_native", false);
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = ((AbsBaseArticleInfo)this.jdField_a_of_type_AndroidContentIntent.getParcelableExtra("comment_article_info"));
      this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("comment_val");
      this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("comment_author_uin");
      this.jdField_e_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("biu_src", 1);
      this.jdField_f_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("feedsType", 1);
      this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("comment_id");
      this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("first_comment_uin");
      this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mIsGalleryChannel;
    }
    a(localBundle);
    e(localBundle);
    this.jdField_b_of_type_Int = localBundle.getInt("arg_comment_comment_type", 0);
    this.jdField_c_of_type_Int = localBundle.getInt("arg_comment_source_type", 0);
    this.jdField_d_of_type_Int = localBundle.getInt("click_comment_edit_src");
    boolean bool1 = localBundle.getBoolean("arg_ad_show_biu", true);
    try
    {
      bool2 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.a.jdField_a_of_type_Boolean;
      if (bool2) {
        bool1 = false;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      localNullPointerException.printStackTrace();
    }
    boolean bool3 = localBundle.getBoolean("comment_can_biu", true);
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    boolean bool2 = bool3;
    if (localAbsBaseArticleInfo != null)
    {
      bool2 = bool3;
      if (localAbsBaseArticleInfo.mSocialFeedInfo != null) {
        if ((RIJItemViewTypeUtils.e(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)) || (!ArticleInfoHelper.b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)))
        {
          bool2 = bool3;
          if (!this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.b()) {}
        }
        else
        {
          bool2 = false;
        }
      }
    }
    bool3 = bool4;
    if (bool1)
    {
      bool3 = bool4;
      if (bool2) {
        bool3 = true;
      }
    }
    this.jdField_f_of_type_Boolean = bool3;
    this.jdField_g_of_type_Boolean = localBundle.getBoolean("comment_type", true);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntitySimpleCommentData = ((SimpleCommentData)localBundle.getParcelable("comment_create_data"));
  }
  
  private void b(Bundle paramBundle)
  {
    this.i = paramBundle.getBoolean("arg_comment_gif_switch", true);
    if (ReadInJoyHelper.h(a()) == 1) {
      this.i = false;
    }
  }
  
  private String c()
  {
    Object localObject = this.jdField_a_of_type_JavaLangString;
    String str = d();
    if (!TextUtils.isEmpty(str)) {
      localObject = str;
    }
    return localObject;
  }
  
  private void c(@NotNull Bundle paramBundle)
  {
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("arg_comment_placeholder", "");
    paramBundle = new StringBuilder();
    paramBundle.append("initData | comment_placeholder : ");
    paramBundle.append(this.jdField_a_of_type_JavaLangString);
    QLog.d("CommentArgumentModel", 2, paramBundle.toString());
  }
  
  private String d()
  {
    if (a())
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
      if (localObject != null)
      {
        localObject = ReadInJoyCommentDataManager.a((AbsBaseArticleInfo)localObject);
        if (localObject != null) {
          return ((ReadInJoyCommentDataManager)localObject).a();
        }
      }
    }
    return "";
  }
  
  private void d(@NotNull Bundle paramBundle)
  {
    int j = paramBundle.getInt("arg_comment_max_length", -1);
    if (j > 0)
    {
      this.jdField_a_of_type_Int = ReadInJoyHelper.a(j);
    }
    else
    {
      this.jdField_a_of_type_Int = ReadInJoyHelper.a();
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("initData | comment_mMaxCharCount : ");
        paramBundle.append(this.jdField_a_of_type_Int);
        QLog.d("CommentArgumentModel", 2, paramBundle.toString());
      }
    }
    if (this.jdField_a_of_type_Int > 5000) {
      this.jdField_a_of_type_Int = 5000;
    }
    if (this.jdField_a_of_type_Int < 100) {
      this.jdField_a_of_type_Int = 100;
    }
  }
  
  private void e(@NotNull Bundle paramBundle)
  {
    boolean bool3 = ReadInJoyHelper.e();
    boolean bool1 = this.h;
    boolean bool2 = false;
    if ((bool1) && (bool3)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_c_of_type_Boolean = bool1;
    this.jdField_g_of_type_Int = ReadInJoyHelper.b();
    bool1 = bool2;
    if (this.jdField_c_of_type_Boolean)
    {
      bool1 = bool2;
      if (this.jdField_g_of_type_Int > 0) {
        bool1 = true;
      }
    }
    this.jdField_b_of_type_Boolean = bool1;
    paramBundle = new StringBuilder();
    paramBundle.append("linkSwitch = ");
    paramBundle.append(bool3);
    paramBundle.append(", insertLinkLimit = ");
    paramBundle.append(this.jdField_g_of_type_Int);
    paramBundle.append(", isPgcAuthor = ");
    paramBundle.append(this.h);
    QLog.d("CommentArgumentModel", 1, paramBundle.toString());
  }
  
  public QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public String a()
  {
    return a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntitySimpleCommentData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.base.model.CommentArgumentModel
 * JD-Core Version:    0.7.0.1
 */