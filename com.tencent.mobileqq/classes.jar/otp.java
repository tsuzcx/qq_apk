import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.minigame.utils.DpUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class otp
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
  
  public otp(int paramInt1, int paramInt2, BaseCommentData paramBaseCommentData, ArticleInfo paramArticleInfo)
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
  
  public otp(int paramInt, BaseCommentData paramBaseCommentData, ArticleInfo paramArticleInfo)
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
        localSpannableStringBuilder.setSpan(new ots(this, paramSubCommentData), i, localSpannableStringBuilder.length(), 33);
        localSpannableStringBuilder.append("：");
      }
    }
    String str = bcsa.b(paramSubCommentData.commentContent);
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
      return anzj.a(2131701127);
    }
    return anzj.a(2131701129);
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
    paramSpannableStringBuilder.setSpan(new otu(this, BaseActivity.sTopActivity, 2130849360, 2, DpUtil.dip2px(BaseActivity.sTopActivity, 32.0F), DpUtil.dip2px(BaseActivity.sTopActivity, 15.0F)), i, paramSpannableStringBuilder.length(), 17);
  }
  
  private void a(SpannableStringBuilder paramSpannableStringBuilder, String paramString1, String paramString2, String paramString3, BaseCommentData paramBaseCommentData)
  {
    int i = paramSpannableStringBuilder.length();
    paramSpannableStringBuilder.append(paramString1);
    paramSpannableStringBuilder.setSpan(new ott(this, paramBaseCommentData, paramString2, paramString3), i, paramSpannableStringBuilder.length(), 33);
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isAd) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.advertisementInfo == null)) {}
    do
    {
      return;
      AdvertisementInfo localAdvertisementInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.advertisementInfo;
      if (!TextUtils.isEmpty(localAdvertisementInfo.mAdTxt)) {
        this.jdField_a_of_type_JavaLangCharSequence = new begp(bcsa.b(localAdvertisementInfo.mAdTxt), 3, this.d);
      }
      if (this.c != null) {
        this.c.clear();
      }
    } while (this.jdField_a_of_type_JavaUtilList == null);
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  private void b(SpannableStringBuilder paramSpannableStringBuilder)
  {
    int i = paramSpannableStringBuilder.length();
    paramSpannableStringBuilder.append(" ");
    paramSpannableStringBuilder.setSpan(new otu(this, BaseActivity.sTopActivity, 2130849365, 2, DpUtil.dip2px(BaseActivity.sTopActivity, 51.0F), DpUtil.dip2px(BaseActivity.sTopActivity, 15.0F)), i, paramSpannableStringBuilder.length(), 17);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      if (this.jdField_b_of_type_JavaUtilList != null) {
        break label257;
      }
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
      label44:
      if (this.c != null) {
        break label269;
      }
      this.c = new ArrayList();
      label62:
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentContent)) {
        if (!(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData)) {
          break label281;
        }
      }
    }
    List localList;
    int i;
    label257:
    label269:
    label281:
    for (this.jdField_a_of_type_JavaLangCharSequence = new begp(bcsa.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentContent), 3, this.d);; this.jdField_a_of_type_JavaLangCharSequence = new begp(a((SubCommentData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData), 3, this.d))
    {
      int j;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData))
      {
        localList = ((CommentData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData).subCommentList;
        if ((localList != null) && (localList.size() > 0))
        {
          j = localList.size();
          i = 0;
          if ((i < j) && (i < 2)) {
            break label311;
          }
        }
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData))
      {
        localList = ((CommentData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData).subCommentList;
        if ((localList != null) && (localList.size() > 0))
        {
          j = localList.size();
          i = 0;
          if ((i < j) && ((this.c == null) || (this.c.size() <= 2))) {
            break label547;
          }
        }
      }
      b();
      return;
      this.jdField_a_of_type_JavaUtilList.clear();
      break;
      this.jdField_b_of_type_JavaUtilList.clear();
      break label44;
      this.c.clear();
      break label62;
    }
    label311:
    Object localObject1 = (SubCommentData)localList.get(i);
    if (localObject1 == null) {}
    for (;;)
    {
      i += 1;
      break;
      localObject2 = new SpannableStringBuilder();
      if (!TextUtils.isEmpty(((SubCommentData)localObject1).nickName))
      {
        ((SpannableStringBuilder)localObject2).append(((SubCommentData)localObject1).nickName);
        ((SpannableStringBuilder)localObject2).setSpan(new otq(this, (SubCommentData)localObject1), 0, ((SpannableStringBuilder)localObject2).length(), 33);
      }
      if ((((SubCommentData)localObject1).hasTarget()) && (!TextUtils.isEmpty(((SubCommentData)localObject1).repliedUserNickname)))
      {
        ((SpannableStringBuilder)localObject2).append(" 回复 ");
        int k = ((SpannableStringBuilder)localObject2).length();
        ((SpannableStringBuilder)localObject2).append(((SubCommentData)localObject1).repliedUserNickname);
        ((SpannableStringBuilder)localObject2).setSpan(new otr(this, (SubCommentData)localObject1), k, ((SpannableStringBuilder)localObject2).length(), 33);
      }
      this.jdField_a_of_type_JavaUtilList.add(localObject2);
      if (!TextUtils.isEmpty(((SubCommentData)localObject1).commentContent))
      {
        localObject2 = a(((SubCommentData)localObject1).getCommentMediaType());
        localObject1 = new begp(bcsa.b(((SubCommentData)localObject1).commentContent) + (String)localObject2, 7, this.d);
        this.jdField_b_of_type_JavaUtilList.add(localObject1);
      }
    }
    label547:
    localObject1 = (SubCommentData)localList.get(i);
    Object localObject2 = new SpannableStringBuilder();
    if (!TextUtils.isEmpty(((SubCommentData)localObject1).nickName)) {
      a((SpannableStringBuilder)localObject2, ((SubCommentData)localObject1).nickName, ((SubCommentData)localObject1).uin, new orb(this).a().a(), (BaseCommentData)localObject1);
    }
    if ((localObject1 != null) && (((SubCommentData)localObject1).isAuthorReply())) {
      a((SpannableStringBuilder)localObject2);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(((SubCommentData)localObject1).repliedUserNickname))
      {
        ((SpannableStringBuilder)localObject2).append(" 回复 ");
        a((SpannableStringBuilder)localObject2, ((SubCommentData)localObject1).repliedUserNickname, ((SubCommentData)localObject1).repliedUserUin, new orb(this).a().b(((SubCommentData)localObject1).repliedUserUin).a(), (BaseCommentData)localObject1);
      }
      if (!TextUtils.isEmpty(((SubCommentData)localObject1).commentContent))
      {
        ((SpannableStringBuilder)localObject2).append(": ");
        String str = a(((SubCommentData)localObject1).getCommentMediaType());
        ((SpannableStringBuilder)localObject2).append(new begp(bcsa.b(((SubCommentData)localObject1).commentContent) + str, 7, this.d));
        this.c.add(localObject2);
      }
      i += 1;
      break;
      if (((SubCommentData)localObject1).isFollowing) {
        b((SpannableStringBuilder)localObject2);
      }
    }
  }
  
  public boolean a()
  {
    return (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidTextSpannableStringBuilder)) || ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 0) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     otp
 * JD-Core Version:    0.7.0.1
 */