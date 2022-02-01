import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.SimpleCommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tkd.comment.publisher.qq.model.TkdQQArgument;
import com.tencent.tkd.comment.publisher.qq.model.TkdQQArticleInfo;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

public class pdl
{
  public int a;
  public final Intent a;
  public SimpleCommentData a;
  public ArticleInfo a;
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
  
  public pdl(Intent paramIntent)
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
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
      return null;
    }
    TkdQQArticleInfo localTkdQQArticleInfo = new TkdQQArticleInfo();
    localTkdQQArticleInfo.mFeedType = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType;
    localTkdQQArticleInfo.mFeedId = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId;
    localTkdQQArticleInfo.mArticleID = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID;
    localTkdQQArticleInfo.innerUniqueID = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID;
    localTkdQQArticleInfo.toUin = pbq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    return localTkdQQArticleInfo;
  }
  
  private void a()
  {
    boolean bool = true;
    this.jdField_a_of_type_ComTencentTkdCommentPublisherQqModelTkdQQArgument = new TkdQQArgument();
    this.jdField_a_of_type_ComTencentTkdCommentPublisherQqModelTkdQQArgument.isNativeCommentComponet = this.jdField_d_of_type_Boolean;
    this.jdField_a_of_type_ComTencentTkdCommentPublisherQqModelTkdQQArgument.mArticleInfo = a();
    this.jdField_a_of_type_ComTencentTkdCommentPublisherQqModelTkdQQArgument.mParentCommentAuthorUin = this.jdField_f_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentTkdCommentPublisherQqModelTkdQQArgument.mClickCommentEditViewSrc = this.jdField_d_of_type_Int;
    this.jdField_a_of_type_ComTencentTkdCommentPublisherQqModelTkdQQArgument.mSourceType = this.jdField_c_of_type_Int;
    this.jdField_a_of_type_ComTencentTkdCommentPublisherQqModelTkdQQArgument.isSecondCommentReplyUin = this.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentTkdCommentPublisherQqModelTkdQQArgument.isSecondCommentReply = this.jdField_e_of_type_Boolean;
    this.jdField_a_of_type_ComTencentTkdCommentPublisherQqModelTkdQQArgument.commentId = this.jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentTkdCommentPublisherQqModelTkdQQArgument.mCommentAuthorUin = this.jdField_d_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentTkdCommentPublisherQqModelTkdQQArgument.isNewCommentComponentType = this.jdField_g_of_type_Boolean;
    this.jdField_a_of_type_ComTencentTkdCommentPublisherQqModelTkdQQArgument.mCommentType = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_ComTencentTkdCommentPublisherQqModelTkdQQArgument.defaultTxt = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("arg_comment_default_txt");
    this.jdField_a_of_type_ComTencentTkdCommentPublisherQqModelTkdQQArgument.placeHolder = this.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentTkdCommentPublisherQqModelTkdQQArgument.maxCharCount = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentTkdCommentPublisherQqModelTkdQQArgument.linkReply = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("comment_to_reply_contain_link", 2);
    this.jdField_a_of_type_ComTencentTkdCommentPublisherQqModelTkdQQArgument.linkEnable = this.jdField_c_of_type_Boolean;
    this.jdField_a_of_type_ComTencentTkdCommentPublisherQqModelTkdQQArgument.showGif = this.i;
    this.jdField_a_of_type_ComTencentTkdCommentPublisherQqModelTkdQQArgument.showLink = this.jdField_b_of_type_Boolean;
    this.jdField_a_of_type_ComTencentTkdCommentPublisherQqModelTkdQQArgument.showBiu = this.jdField_f_of_type_Boolean;
    TkdQQArgument localTkdQQArgument = this.jdField_a_of_type_ComTencentTkdCommentPublisherQqModelTkdQQArgument;
    if (bmhv.p(a()) == 1) {}
    for (;;)
    {
      localTkdQQArgument.selectBiu = bool;
      this.jdField_a_of_type_ComTencentTkdCommentPublisherQqModelTkdQQArgument.biuAndCommentSwitch = oww.a();
      this.jdField_a_of_type_ComTencentTkdCommentPublisherQqModelTkdQQArgument.biuEditorGuideWording = oww.b();
      this.jdField_a_of_type_ComTencentTkdCommentPublisherQqModelTkdQQArgument.biuEditorConfirmBtnWording = oww.c();
      this.jdField_a_of_type_ComTencentTkdCommentPublisherQqModelTkdQQArgument.biuEditorCheckBoxHidden = oww.d();
      this.jdField_a_of_type_ComTencentTkdCommentPublisherQqModelTkdQQArgument.biuEditorCheckBoxWording = oww.d();
      this.jdField_a_of_type_ComTencentTkdCommentPublisherQqModelTkdQQArgument.biuEditorDefaultStatus = oww.b();
      this.jdField_a_of_type_ComTencentTkdCommentPublisherQqModelTkdQQArgument.editorDefaultEnableRemember = oww.c();
      return;
      bool = false;
    }
  }
  
  private void a(Bundle paramBundle)
  {
    if (paramBundle.containsKey("comment_is_pgc_author"))
    {
      this.h = paramBundle.getBoolean("comment_is_pgc_author");
      return;
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (pdv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID))) {}
    for (boolean bool = true;; bool = false)
    {
      this.h = bool;
      return;
    }
  }
  
  private void b()
  {
    boolean bool4 = false;
    Bundle localBundle = this.jdField_a_of_type_AndroidContentIntent.getExtras();
    if (localBundle == null) {
      return;
    }
    c(localBundle);
    d(localBundle);
    b(localBundle);
    this.jdField_e_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("comment_reply_second", false);
    if (this.jdField_e_of_type_Boolean) {
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("comment_reply_second_uin");
    }
    this.jdField_d_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("comment_native", false);
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)this.jdField_a_of_type_AndroidContentIntent.getParcelableExtra("comment_article_info"));
      this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("comment_val");
      this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("comment_author_uin");
      this.jdField_e_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("biu_src", 1);
      this.jdField_f_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("feedsType", 1);
      this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("comment_id");
      this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("first_comment_uin");
      this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mIsGalleryChannel;
    }
    a(localBundle);
    e(localBundle);
    this.jdField_b_of_type_Int = localBundle.getInt("arg_comment_comment_type", 0);
    this.jdField_c_of_type_Int = localBundle.getInt("arg_comment_source_type", 0);
    this.jdField_d_of_type_Int = localBundle.getInt("click_comment_edit_src");
    boolean bool1 = localBundle.getBoolean("arg_ad_show_biu", true);
    try
    {
      bool2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.a.jdField_a_of_type_Boolean;
      if (bool2) {
        bool1 = false;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        boolean bool2;
        boolean bool3;
        localNullPointerException.printStackTrace();
      }
    }
    bool3 = localBundle.getBoolean("comment_can_biu", true);
    bool2 = bool3;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
    {
      bool2 = bool3;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) {
        if ((ppe.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) || (!pid.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
        {
          bool2 = bool3;
          if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.b()) {}
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSimpleCommentData = ((SimpleCommentData)localBundle.getParcelable("comment_create_data"));
  }
  
  private void b(Bundle paramBundle)
  {
    this.i = paramBundle.getBoolean("arg_comment_gif_switch", true);
    if (bmhv.h(a()) == 1) {
      this.i = false;
    }
  }
  
  private void c(@NotNull Bundle paramBundle)
  {
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("arg_comment_placeholder", "");
    QLog.d("CommentArgumentModel", 2, "initData | comment_placeholder : " + this.jdField_a_of_type_JavaLangString);
  }
  
  private void d(@NotNull Bundle paramBundle)
  {
    int j = paramBundle.getInt("arg_comment_max_length", -1);
    if (j > 0) {
      this.jdField_a_of_type_Int = j;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Int > 5000) {
        this.jdField_a_of_type_Int = 5000;
      }
      if (this.jdField_a_of_type_Int < 100) {
        this.jdField_a_of_type_Int = 100;
      }
      return;
      this.jdField_a_of_type_Int = bmhv.a();
      if (QLog.isColorLevel()) {
        QLog.d("CommentArgumentModel", 2, "initData | comment_mMaxCharCount : " + this.jdField_a_of_type_Int);
      }
    }
  }
  
  private void e(@NotNull Bundle paramBundle)
  {
    boolean bool2 = true;
    boolean bool3 = bmhv.f();
    if ((this.h) && (bool3))
    {
      bool1 = true;
      this.jdField_c_of_type_Boolean = bool1;
      this.jdField_g_of_type_Int = bmhv.b();
      if ((!this.jdField_c_of_type_Boolean) || (this.jdField_g_of_type_Int <= 0)) {
        break label148;
      }
    }
    label148:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_b_of_type_Boolean = bool1;
      QLog.d("CommentArgumentModel", 2, "linkSwitch = " + bool3);
      QLog.d("CommentArgumentModel", 2, "insertLinkLimit = " + this.jdField_g_of_type_Int);
      QLog.d("CommentArgumentModel", 2, "isPgcAuthor = " + this.h);
      return;
      bool1 = false;
      break;
    }
  }
  
  public QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pdl
 * JD-Core Version:    0.7.0.1
 */