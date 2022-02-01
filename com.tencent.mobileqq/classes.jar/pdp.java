import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.minigame.utils.DpUtil;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class pdp
{
  public int a;
  public SpannableStringBuilder a;
  public BaseCommentData a;
  public ArticleInfo a;
  public CharSequence a;
  public List<SpannableStringBuilder> a;
  public boolean a;
  public int b;
  public List<CharSequence> b;
  public int c;
  public List<CharSequence> c;
  private int d = 18;
  
  public pdp(int paramInt1, int paramInt2, BaseCommentData paramBaseCommentData, ArticleInfo paramArticleInfo)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData = paramBaseCommentData;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_b_of_type_Int = paramInt1;
    boolean bool1 = bool2;
    if (paramBaseCommentData != null)
    {
      bool1 = bool2;
      if (paramBaseCommentData.isAuthorSticky) {
        bool1 = true;
      }
    }
    this.jdField_a_of_type_Boolean = bool1;
    a();
  }
  
  public pdp(int paramInt, BaseCommentData paramBaseCommentData, ArticleInfo paramArticleInfo)
  {
    this(0, paramInt, paramBaseCommentData, paramArticleInfo);
  }
  
  private CharSequence a(SubCommentData paramSubCommentData)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (paramSubCommentData.hasTarget())
    {
      localSpannableStringBuilder.append("回复 ");
      int i = localSpannableStringBuilder.length();
      if (!TextUtils.isEmpty(paramSubCommentData.repliedUserNickname))
      {
        localSpannableStringBuilder.append(paramSubCommentData.repliedUserNickname);
        localSpannableStringBuilder.setSpan(new pds(this, paramSubCommentData), i, localSpannableStringBuilder.length(), 33);
        localSpannableStringBuilder.append("：");
      }
    }
    String str = bcsc.b(paramSubCommentData.commentContent);
    paramSubCommentData = str;
    if (localSpannableStringBuilder.length() > 0) {
      paramSubCommentData = localSpannableStringBuilder.append(str);
    }
    return paramSubCommentData;
  }
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return anvx.a(2131701713);
    }
    return anvx.a(2131701715);
  }
  
  private void a(SpannableStringBuilder paramSpannableStringBuilder)
  {
    if (BaseActivity.sTopActivity == null)
    {
      QLog.d("CommentViewItem", 1, "setAuthorText | sTopActivity is null");
      return;
    }
    int i = paramSpannableStringBuilder.length();
    paramSpannableStringBuilder.append(" ");
    paramSpannableStringBuilder.setSpan(new pdu(this, BaseActivity.sTopActivity, 2130849363, 2, DpUtil.dip2px(BaseActivity.sTopActivity, 32.0F), DpUtil.dip2px(BaseActivity.sTopActivity, 15.0F)), i, paramSpannableStringBuilder.length(), 17);
  }
  
  private void a(SpannableStringBuilder paramSpannableStringBuilder, SubCommentData paramSubCommentData)
  {
    if (!TextUtils.isEmpty(paramSubCommentData.nickName))
    {
      paramSpannableStringBuilder.append(paramSubCommentData.nickName);
      paramSpannableStringBuilder.setSpan(new pdq(this, paramSubCommentData), 0, paramSpannableStringBuilder.length(), 33);
    }
  }
  
  private void a(SpannableStringBuilder paramSpannableStringBuilder, String paramString1, String paramString2, String paramString3, BaseCommentData paramBaseCommentData)
  {
    int i = paramSpannableStringBuilder.length();
    paramSpannableStringBuilder.append(paramString1);
    paramSpannableStringBuilder.setSpan(new pdt(this, paramBaseCommentData, paramString2, paramString3), i, paramSpannableStringBuilder.length(), 33);
  }
  
  private void a(SubCommentData paramSubCommentData)
  {
    if (!TextUtils.isEmpty(paramSubCommentData.commentContent))
    {
      String str = a(paramSubCommentData.getCommentMediaType());
      paramSubCommentData = new QQText(bcsc.b(paramSubCommentData.commentContent) + str, 7, this.d);
      this.jdField_b_of_type_JavaUtilList.add(paramSubCommentData);
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      if (this.jdField_b_of_type_JavaUtilList != null) {
        break label67;
      }
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
    }
    for (;;)
    {
      if (this.c != null) {
        break label79;
      }
      this.c = new ArrayList();
      return;
      this.jdField_a_of_type_JavaUtilList.clear();
      break;
      label67:
      this.jdField_b_of_type_JavaUtilList.clear();
    }
    label79:
    this.c.clear();
  }
  
  private void b(SpannableStringBuilder paramSpannableStringBuilder)
  {
    int i = paramSpannableStringBuilder.length();
    paramSpannableStringBuilder.append(" ");
    paramSpannableStringBuilder.setSpan(new pdu(this, BaseActivity.sTopActivity, 2130849368, 2, DpUtil.dip2px(BaseActivity.sTopActivity, 51.0F), DpUtil.dip2px(BaseActivity.sTopActivity, 15.0F)), i, paramSpannableStringBuilder.length(), 17);
  }
  
  private void b(SpannableStringBuilder paramSpannableStringBuilder, SubCommentData paramSubCommentData)
  {
    if ((paramSubCommentData.hasTarget()) && (!TextUtils.isEmpty(paramSubCommentData.repliedUserNickname)))
    {
      paramSpannableStringBuilder.append(" 回复 ");
      int i = paramSpannableStringBuilder.length();
      paramSpannableStringBuilder.append(paramSubCommentData.repliedUserNickname);
      paramSpannableStringBuilder.setSpan(new pdr(this, paramSubCommentData), i, paramSpannableStringBuilder.length(), 33);
    }
  }
  
  private void c()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentContent))
    {
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData)) {
        this.jdField_a_of_type_JavaLangCharSequence = new QQText(bcsc.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentContent), 3, this.d);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_JavaLangCharSequence = new QQText(a((SubCommentData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData), 3, this.d);
  }
  
  private void d()
  {
    List localList;
    int i;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData))
    {
      localList = ((CommentData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData).subCommentList;
      if ((localList != null) && (localList.size() > 0))
      {
        int j = localList.size();
        i = 0;
        if ((i < j) && (i < 2)) {
          break label54;
        }
      }
    }
    return;
    label54:
    SubCommentData localSubCommentData = (SubCommentData)localList.get(i);
    if (localSubCommentData == null) {}
    for (;;)
    {
      i += 1;
      break;
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      a(localSpannableStringBuilder, localSubCommentData);
      b(localSpannableStringBuilder, localSubCommentData);
      this.jdField_a_of_type_JavaUtilList.add(localSpannableStringBuilder);
      a(localSubCommentData);
    }
  }
  
  private void e()
  {
    List localList;
    int i;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData))
    {
      localList = ((CommentData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData).subCommentList;
      if ((localList != null) && (localList.size() > 0))
      {
        int j = localList.size();
        i = 0;
        if ((i < j) && ((this.c == null) || (this.c.size() <= 2))) {
          break label69;
        }
      }
    }
    return;
    label69:
    SubCommentData localSubCommentData = (SubCommentData)localList.get(i);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (!TextUtils.isEmpty(localSubCommentData.nickName)) {
      a(localSpannableStringBuilder, localSubCommentData.nickName, localSubCommentData.uin, new paa(this).a().a(), localSubCommentData);
    }
    if (localSubCommentData.isAuthorReply()) {
      a(localSpannableStringBuilder);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(localSubCommentData.repliedUserNickname))
      {
        localSpannableStringBuilder.append(" 回复 ");
        a(localSpannableStringBuilder, localSubCommentData.repliedUserNickname, localSubCommentData.repliedUserUin, new paa(this).a().b(localSubCommentData.repliedUserUin).a(), localSubCommentData);
      }
      if (!TextUtils.isEmpty(localSubCommentData.commentContent))
      {
        localSpannableStringBuilder.append(": ");
        String str = a(localSubCommentData.getCommentMediaType());
        localSpannableStringBuilder.append(new QQText(bcsc.b(localSubCommentData.commentContent) + str, 7, this.d));
        this.c.add(localSpannableStringBuilder);
      }
      i += 1;
      break;
      if (localSubCommentData.isFollowing) {
        b(localSpannableStringBuilder);
      }
    }
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isAd) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.advertisementInfo == null)) {}
    do
    {
      return;
      AdvertisementInfo localAdvertisementInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.advertisementInfo;
      if (!TextUtils.isEmpty(localAdvertisementInfo.mAdTxt)) {
        this.jdField_a_of_type_JavaLangCharSequence = new QQText(bcsc.b(localAdvertisementInfo.mAdTxt), 3, this.d);
      }
      if (this.c != null) {
        this.c.clear();
      }
    } while (this.jdField_a_of_type_JavaUtilList == null);
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) {
      return;
    }
    b();
    c();
    d();
    e();
    f();
  }
  
  public boolean a()
  {
    return (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidTextSpannableStringBuilder)) || ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 0) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pdp
 * JD-Core Version:    0.7.0.1
 */