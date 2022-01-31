import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class oke
{
  private int jdField_a_of_type_Int = 0;
  private BaseCommentData jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private JSONObject jdField_a_of_type_OrgJsonJSONObject = new JSONObject();
  
  public oke(ArticleInfo paramArticleInfo, BaseCommentData paramBaseCommentData)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData = paramBaseCommentData;
  }
  
  public oke(omt paramomt)
  {
    if (paramomt == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData = paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    this.jdField_a_of_type_Int = paramomt.b;
  }
  
  private int a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) {
      return 0;
    }
    switch (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.contentSrc)
    {
    default: 
      return 0;
    case 1: 
      return 1;
    case 3: 
      return 3;
    }
    return 2;
  }
  
  private oke e(int paramInt)
  {
    int j = 1;
    int i = 1;
    if (paramInt == 1) {}
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put("puin_type", 1);
      return this;
    }
    catch (JSONException localJSONException)
    {
      JSONObject localJSONObject1;
      localJSONException.printStackTrace();
      return this;
    }
    if ((paramInt == 2) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null))
    {
      localJSONObject1 = this.jdField_a_of_type_OrgJsonJSONObject;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAccountLess == 0) {}
      for (paramInt = i;; paramInt = 2)
      {
        localJSONObject1.put("puin_type", paramInt);
        return this;
      }
    }
    if ((paramInt == 3) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null))
    {
      JSONObject localJSONObject2 = this.jdField_a_of_type_OrgJsonJSONObject;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAccountLess == 0) {}
      for (paramInt = j;; paramInt = 2)
      {
        localJSONObject2.put("puin_type", paramInt);
        return this;
      }
    }
    return this;
  }
  
  private oke j()
  {
    omz localomz;
    String str;
    if (this.jdField_a_of_type_Int == 0)
    {
      localomz = omz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      if (localomz != null)
      {
        str = "";
        if (!(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData)) {
          break label65;
        }
        str = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentId;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = localomz.a(str);
      try
      {
        this.jdField_a_of_type_OrgJsonJSONObject.put("area", this.jdField_a_of_type_Int);
        return this;
      }
      catch (JSONException localJSONException)
      {
        label65:
        localJSONException.printStackTrace();
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof SubCommentData)) {
        str = ((SubCommentData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData).parentCommentId;
      }
    }
    return this;
  }
  
  public String a()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
        {
          this.jdField_a_of_type_OrgJsonJSONObject.put("algorithm_id", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAlgorithmID);
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID != -1L) {
            this.jdField_a_of_type_OrgJsonJSONObject.put("mp_article_id", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID);
          }
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData != null)
        {
          if (!(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData)) {
            continue;
          }
          this.jdField_a_of_type_OrgJsonJSONObject.put("comment_id", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentId);
        }
        this.jdField_a_of_type_OrgJsonJSONObject.put("kandian_mode", ors.e());
        this.jdField_a_of_type_OrgJsonJSONObject.put("comment_platform", 3);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        continue;
      }
      return this.jdField_a_of_type_OrgJsonJSONObject.toString();
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof SubCommentData)) {
        this.jdField_a_of_type_OrgJsonJSONObject.put("sub_comment_id", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentId);
      }
    }
  }
  
  public oke a()
  {
    j();
    c();
    d();
    e();
    h();
    return this;
  }
  
  public oke a(int paramInt)
  {
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put("amount", paramInt);
      return this;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return this;
  }
  
  public oke a(String paramString)
  {
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put("comment_id", paramString);
      return this;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return this;
  }
  
  public oke b()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof SubCommentData)))
      {
        this.jdField_a_of_type_OrgJsonJSONObject.put("comment_id", ((SubCommentData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData).parentCommentId);
        this.jdField_a_of_type_OrgJsonJSONObject.put("sub_comment_id", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentId);
      }
      return this;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return this;
  }
  
  public oke b(int paramInt)
  {
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put("actionsheet_choose", paramInt);
      return this;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return this;
  }
  
  public oke b(String paramString)
  {
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put("to_uin", paramString);
      return this;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return this;
  }
  
  public oke c()
  {
    int i = a();
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put("entry", i);
      return e(i);
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public oke c(int paramInt)
  {
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put("comment_number", paramInt);
      return this;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return this;
  }
  
  public oke d()
  {
    int i = 1;
    int j;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData != null)
    {
      j = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.getCommentLevel();
      if (j != 1) {
        break label42;
      }
      i = 0;
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_OrgJsonJSONObject.put("comment_level", i);
        return this;
      }
      catch (JSONException localJSONException)
      {
        label42:
        localJSONException.printStackTrace();
      }
      j = 2;
      break;
      if (j != 2) {
        i = 2;
      }
    }
    return this;
  }
  
  public oke d(int paramInt)
  {
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put("change_into", paramInt);
      return this;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return this;
  }
  
  public oke e()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData != null)
      {
        int i;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isAuthorSelection()) {
          i = 1;
        }
        while (i > 0)
        {
          this.jdField_a_of_type_OrgJsonJSONObject.put("comment_type", i);
          return this;
          boolean bool = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isAwesome();
          if (bool) {
            i = 2;
          } else {
            i = 3;
          }
        }
      }
      return this;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public oke f()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) {
      return this;
    }
    int i = 0;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isBanner()) {
      i = 1;
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_OrgJsonJSONObject.put("type", i);
        return this;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return this;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isActivity()) {
        i = 2;
      } else if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isFamilyTopEntry()) {
        i = 3;
      }
    }
  }
  
  public oke g()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) {
      return this;
    }
    String str1 = "";
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isActivity()) {
      str1 = String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.activityCfgID);
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_OrgJsonJSONObject.put("h5_id", str1);
        return this;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return this;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isBanner()) {
        String str2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentId;
      }
    }
  }
  
  public oke h()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.styleData))) {
      try
      {
        JSONObject localJSONObject = new JSONObject(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.styleData).optJSONObject("reportJson");
        if (localJSONObject != null)
        {
          Iterator localIterator = localJSONObject.keys();
          while (localIterator.hasNext())
          {
            String str1 = (String)localIterator.next();
            String str2 = localJSONObject.getString(str1);
            this.jdField_a_of_type_OrgJsonJSONObject.put(str1, str2);
          }
        }
        return this;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    QLog.d("CommentReportR5Builder", 2, "addFamilyReportData r5 " + this.jdField_a_of_type_OrgJsonJSONObject.toString());
    return this;
  }
  
  public oke i()
  {
    try
    {
      JSONObject localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData != null) {}
      for (int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.createSrc;; i = 0)
      {
        localJSONObject.put("into_app", i);
        return this;
      }
      return this;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oke
 * JD-Core Version:    0.7.0.1
 */