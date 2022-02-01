import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListView;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentReportManager.1;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentReportManager.2;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData.CommentLinkData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class pbn
{
  public static int a;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  protected Map<String, pdp> a;
  private pcf jdField_a_of_type_Pcf;
  private int jdField_b_of_type_Int;
  private List<String> jdField_b_of_type_JavaUtilList = new ArrayList();
  protected Map<String, pdp> b;
  private List<String> c;
  protected Map<String, pdp> c;
  private List<Pair<Long, pdp>> d;
  protected Map<String, pdp> d;
  Map<Integer, pdp> e = new HashMap();
  private Map<String, String> f = new HashMap();
  
  static
  {
    jdField_a_of_type_Int = 0;
  }
  
  public pbn(pcf parampcf, ArticleInfo paramArticleInfo, int paramInt)
  {
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_d_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    this.jdField_c_of_type_JavaUtilMap = new HashMap();
    this.jdField_d_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_Pcf = parampcf;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    jdField_a_of_type_Int = paramInt;
    if ((this.jdField_a_of_type_Pcf != null) && (this.jdField_a_of_type_Pcf.a() != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_Pcf.a().getAppRuntime());
    }
  }
  
  private int a()
  {
    int j = 1;
    int i = j;
    if (this.jdField_a_of_type_Pcf != null)
    {
      i = j;
      if (this.jdField_a_of_type_Pcf.a() != null)
      {
        i = j;
        if (this.jdField_a_of_type_Pcf.b() == 2) {
          i = 2;
        }
      }
    }
    QLog.d("ReadInJoyCommentReportManager", 2, "getReportSteamType | streamType " + i);
    return i;
  }
  
  private int a(BaseCommentData paramBaseCommentData)
  {
    if ((paramBaseCommentData != null) && (paramBaseCommentData.mediaDataList != null) && (paramBaseCommentData.mediaDataList.size() > 0)) {
      return 1;
    }
    return 0;
  }
  
  private String a(BaseCommentData paramBaseCommentData)
  {
    if (paramBaseCommentData == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramBaseCommentData.isAuthorReply()) {
      localStringBuilder.append(1).append(",");
    }
    if (paramBaseCommentData.isAuthorLike) {
      localStringBuilder.append(2).append(",");
    }
    if (paramBaseCommentData.isFollowing) {
      localStringBuilder.append(3).append(",");
    }
    if (paramBaseCommentData.isAuthorSticky) {
      localStringBuilder.append(6);
    }
    if ((localStringBuilder.length() > 0) && (localStringBuilder.charAt(localStringBuilder.length() - 1) == ',')) {
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    }
    return localStringBuilder.toString();
  }
  
  private String a(CommentData paramCommentData)
  {
    if (paramCommentData == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    if ((paramCommentData.subCommentList != null) && (paramCommentData.subCommentList.size() > 0))
    {
      int i = 0;
      while (i < paramCommentData.subCommentList.size())
      {
        SubCommentData localSubCommentData = (SubCommentData)paramCommentData.subCommentList.get(i);
        if (localSubCommentData != null) {
          localStringBuilder.append("\"").append(localSubCommentData.commentId).append("\"").append(",");
        }
        i += 1;
      }
    }
    if (localStringBuilder.length() > 1) {
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  private void a(BaseCommentData paramBaseCommentData)
  {
    if ((paramBaseCommentData == null) || (TextUtils.isEmpty(paramBaseCommentData.avatarPendantUrl))) {
      return;
    }
    paramBaseCommentData = new JSONObject();
    try
    {
      paramBaseCommentData.put("os", "1");
      paramBaseCommentData.put("version", "8.4.10");
      paramBaseCommentData.put("entry", jdField_a_of_type_Int);
      a(paramBaseCommentData.toString(), "0X800B069");
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("ReadInJoyCommentReportManager", 1, "[reportExposeAvatarPendent] e = " + localJSONException);
      }
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, BaseCommentData paramBaseCommentData, int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("entry", jdField_a_of_type_Int);
      if ((paramBaseCommentData instanceof CommentData))
      {
        localJSONObject.put("comment_id", paramBaseCommentData.commentId);
        localJSONObject.put("comment_level", 0);
      }
      for (;;)
      {
        localJSONObject.put("comment_platform", 3);
        localJSONObject.put("link_type", paramInt);
        ThreadManager.getSubThreadHandler().post(new ReadInJoyCommentReportManager.2(paramArticleInfo, localJSONObject));
        return;
        if ((paramBaseCommentData instanceof SubCommentData))
        {
          localJSONObject.put("sub_comment_id", paramBaseCommentData.commentId);
          localJSONObject.put("comment_level", 1);
        }
      }
      return;
    }
    catch (JSONException paramArticleInfo)
    {
      paramArticleInfo.printStackTrace();
    }
  }
  
  private String b(BaseCommentData paramBaseCommentData)
  {
    if ((paramBaseCommentData == null) || (!paramBaseCommentData.hasLinkData())) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramBaseCommentData = paramBaseCommentData.commentLinkDataList.iterator();
    while (paramBaseCommentData.hasNext())
    {
      BaseCommentData.CommentLinkData localCommentLinkData = (BaseCommentData.CommentLinkData)paramBaseCommentData.next();
      if (localCommentLinkData != null) {
        localStringBuilder.append(localCommentLinkData.type).append(",");
      }
    }
    return localStringBuilder.substring(0, localStringBuilder.length() - 1);
  }
  
  private void d(long paramLong, int paramInt)
  {
    if ((this.f == null) || (this.jdField_a_of_type_Pcf == null)) {}
    Object localObject2;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (this.jdField_d_of_type_JavaUtilList == null) {
              this.jdField_d_of_type_JavaUtilList = new ArrayList();
            }
          } while (this.jdField_a_of_type_Pcf.getItem(paramInt) == null);
          localObject1 = (pdp)this.jdField_a_of_type_Pcf.getItem(paramInt);
        } while (localObject1 == null);
        localObject2 = ((pdp)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
      } while (localObject2 == null);
      localObject2 = ((BaseCommentData)localObject2).commentId;
    } while ((((pdp)localObject1).jdField_a_of_type_Int != 0) || (this.f.containsKey(localObject2)));
    Object localObject1 = new Pair(Long.valueOf(paramLong), localObject1);
    this.jdField_d_of_type_JavaUtilList.add(localObject1);
    this.f.put(localObject2, "");
  }
  
  private void e(int paramInt)
  {
    a(paramInt);
    f();
    g();
    c();
    i();
    h();
  }
  
  private void f(int paramInt)
  {
    if (paramInt > this.jdField_b_of_type_Int) {
      this.jdField_b_of_type_Int = paramInt;
    }
  }
  
  public void a()
  {
    this.jdField_b_of_type_Int = 0;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      if (this.jdField_c_of_type_JavaUtilList == null) {
        break label148;
      }
      this.jdField_c_of_type_JavaUtilList.clear();
      label37:
      if (this.f == null) {
        break label162;
      }
      this.f.clear();
      label53:
      if (this.jdField_d_of_type_JavaUtilList == null) {
        break label176;
      }
      this.jdField_d_of_type_JavaUtilList.clear();
      label69:
      if (this.jdField_a_of_type_JavaUtilMap == null) {
        break label190;
      }
      this.jdField_a_of_type_JavaUtilMap.clear();
      label85:
      if (this.jdField_b_of_type_JavaUtilMap == null) {
        break label204;
      }
      this.jdField_b_of_type_JavaUtilMap.clear();
      label101:
      if (this.e == null) {
        break label218;
      }
      this.e.clear();
    }
    for (;;)
    {
      if (this.jdField_c_of_type_JavaUtilMap == null) {
        break label232;
      }
      this.jdField_c_of_type_JavaUtilMap.clear();
      return;
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      break;
      label148:
      this.jdField_c_of_type_JavaUtilList = new ArrayList();
      break label37;
      label162:
      this.f = new HashMap();
      break label53;
      label176:
      this.jdField_d_of_type_JavaUtilList = new ArrayList();
      break label69;
      label190:
      this.jdField_a_of_type_JavaUtilMap = new HashMap();
      break label85;
      label204:
      this.jdField_b_of_type_JavaUtilMap = new HashMap();
      break label101;
      label218:
      this.e = new HashMap();
    }
    label232:
    this.jdField_c_of_type_JavaUtilMap = new HashMap();
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_d_of_type_JavaUtilList == null) || (this.jdField_d_of_type_JavaUtilList.size() == 0)) {
      return;
    }
    Iterator localIterator = this.jdField_d_of_type_JavaUtilList.iterator();
    label31:
    Pair localPair;
    long l;
    CommentData localCommentData;
    if (localIterator.hasNext())
    {
      localPair = (Pair)localIterator.next();
      l = ((Long)localPair.first).longValue();
      localCommentData = (CommentData)((pdp)localPair.second).jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("entry", jdField_a_of_type_Int);
        localJSONObject.put("comment_platform", 3);
        localJSONObject.put("comment_id", localCommentData.commentId);
        localJSONObject.put("time", l);
        localJSONObject.put("thumb_up_num", localCommentData.likeCnt);
        localJSONObject.put("sub_comment_num", localCommentData.subCommentNum);
        localJSONObject.put("shown_page", 1);
        localJSONObject.put("comment_type", ((pdp)localPair.second).jdField_b_of_type_Int);
        localJSONObject.put("show_sub_comment_id", a(localCommentData));
        localJSONObject.put("come_in_action", paramInt);
        localJSONObject.put("proxy_bytes", localCommentData.passthrough);
        localJSONObject.put("stream_type", a());
        localJSONObject.put("picture", a(localCommentData));
        localJSONObject.put("tag_type", a(localCommentData));
        if (!localCommentData.hasLinkData()) {
          break label338;
        }
        i = 1;
        localJSONObject.put("link", i);
        localJSONObject.put("link_type", b(localCommentData));
        a(localJSONObject.toString(), "0X8009992");
        a(localCommentData);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      break label31;
      break;
      label338:
      int i = 0;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Pcf == null) {}
    for (;;)
    {
      return;
      QLog.d("ReadInJoyCommentReportManager", 2, "recordLeaveCommentIDList current screen firstpos " + paramInt1 + ", lastpos " + paramInt2);
      int i = paramInt1;
      if (paramInt1 < 0) {
        i = 0;
      }
      if (this.jdField_c_of_type_JavaUtilList != null)
      {
        this.jdField_c_of_type_JavaUtilList.clear();
        while ((i <= paramInt2) && (i < this.jdField_a_of_type_Pcf.getCount()))
        {
          pdp localpdp = (pdp)this.jdField_a_of_type_Pcf.getItem(i);
          if ((localpdp != null) && (localpdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData != null) && (!TextUtils.isEmpty(localpdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentId))) {
            this.jdField_c_of_type_JavaUtilList.add(localpdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentId);
          }
          i += 1;
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, pdp parampdp)
  {
    if (parampdp == null) {}
    while (parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) {
      return;
    }
    String str = "0X8009669";
    if (paramInt1 == 2) {
      str = "0X8009018";
    }
    a(new paa(parampdp).a().b(paramInt2).g().a(), str);
  }
  
  public void a(int paramInt, BaseCommentData paramBaseCommentData)
  {
    if (paramBaseCommentData == null)
    {
      a("", "0X8009BD7");
      return;
    }
    String str2 = new paa(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramBaseCommentData).a().a();
    Object localObject = "0X800900E";
    String str1 = "0X800900F";
    if (paramInt == 2)
    {
      localObject = "0X8009015";
      str1 = "0X8009016";
    }
    if (paramBaseCommentData.isLiked()) {}
    for (;;)
    {
      a(str2, (String)localObject);
      return;
      localObject = str1;
    }
  }
  
  public void a(int paramInt, pdp parampdp)
  {
    if ((parampdp == null) || (parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null)) {}
    while (parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) {
      return;
    }
    String str = "0X8009010";
    if (paramInt == 2) {
      str = "0X8009014";
    }
    a(new paa(parampdp).a().c(1).b().a(), str);
  }
  
  public void a(long paramLong)
  {
    c(paramLong);
    e();
    f();
  }
  
  public void a(long paramLong, int paramInt)
  {
    b(paramLong);
    e(paramInt);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("comment_id", paramString);
      localJSONObject.put("comment_level", 0);
      localJSONObject.put("shown_page", 1);
      localJSONObject.put("entry", jdField_a_of_type_Int);
      localJSONObject.put("area", paramInt);
      localJSONObject.put("comment_platform", 3);
      a(localJSONObject.toString(), "0X800B211");
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(new ReadInJoyCommentReportManager.1(this, paramString2, paramString1));
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("comment_id", paramString1);
      localJSONObject.put("sub_comment_id", paramString2);
      localJSONObject.put("comment_level", 2);
      localJSONObject.put("shown_page", 2);
      localJSONObject.put("entry", jdField_a_of_type_Int);
      localJSONObject.put("area", paramInt);
      localJSONObject.put("comment_platform", 3);
      a(localJSONObject.toString(), "0X800B211");
      return;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void a(pdp parampdp)
  {
    if ((parampdp == null) || (parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null)) {}
    BaseCommentData localBaseCommentData;
    do
    {
      return;
      localBaseCommentData = parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    } while (localBaseCommentData == null);
    String str = "0X8009668";
    if ((localBaseCommentData instanceof SubCommentData)) {
      str = "0X8009013";
    }
    a(new paa(parampdp).a().a(), str);
  }
  
  public void a(pdp parampdp, int paramInt)
  {
    if (parampdp != null) {}
    try
    {
      if ((parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData))
      {
        CommentData localCommentData = (CommentData)parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
        parampdp = new paa(parampdp).a().a(((CommentData)parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData).subCommentNum).a();
        parampdp.put("entry_subcomment_type", paramInt);
        parampdp.put("comment_id", localCommentData.commentId);
        parampdp.put("show_sub_comment_id", a(localCommentData));
        parampdp.put("tag_type", a(localCommentData));
        a(parampdp.toString(), "0X800901F");
      }
      return;
    }
    catch (JSONException parampdp)
    {
      QLog.d("ReadInJoyCommentReportManager", 2, parampdp.getMessage());
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("shown_page", 1);
      localJSONObject.put("entry", jdField_a_of_type_Int);
      localJSONObject.put("area", 2);
      localJSONObject.put("comment_platform", 3);
      a(localJSONObject.toString(), "0X800966A");
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_Pcf == null) {
      return;
    }
    a(new paa(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, null).d(paramInt).a(), "0X8009D01");
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    QLog.d("ReadInJoyCommentReportManager", 2, "recordSubLeaveCommentIDList current screen firstpos " + paramInt1 + ", lastpos " + paramInt2);
    if (this.jdField_c_of_type_JavaUtilList != null) {
      this.jdField_c_of_type_JavaUtilList.clear();
    }
    for (;;)
    {
      if ((paramInt1 > paramInt2) || (paramInt1 >= this.jdField_a_of_type_Pcf.getCount())) {
        return;
      }
      pdp localpdp = (pdp)this.jdField_a_of_type_Pcf.getItem(paramInt1);
      if ((localpdp != null) && (localpdp.jdField_a_of_type_Int == 0) && (localpdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData != null) && (!TextUtils.isEmpty(localpdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentId))) {
        this.jdField_c_of_type_JavaUtilList.add(localpdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentId);
      }
      paramInt1 += 1;
    }
  }
  
  public void b(int paramInt, pdp parampdp)
  {
    if (parampdp == null) {}
    Object localObject;
    do
    {
      return;
      localObject = parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    } while (localObject == null);
    if (paramInt == 1) {
      if (((BaseCommentData)localObject).isDisliked()) {
        localObject = "0X8009557";
      }
    }
    for (;;)
    {
      a(new paa(parampdp).a().a(), (String)localObject);
      return;
      localObject = "0X8009558";
      continue;
      if (((BaseCommentData)localObject).isDisliked()) {
        localObject = "0X8009559";
      } else {
        localObject = "0X800955A";
      }
    }
  }
  
  public void b(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (paramLong == 0L)) {
      return;
    }
    QLog.d("ReadInJoyCommentReportManager", 2, "reportReadCommentTime ");
    if ((this.jdField_c_of_type_JavaUtilList == null) || (this.jdField_c_of_type_JavaUtilList.size() == 0)) {
      a(0, this.jdField_b_of_type_Int);
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("entry", jdField_a_of_type_Int);
      localJSONObject.put("comment_platform", 3);
      localJSONObject.put("website", 0);
      localJSONObject.put("read_comment_num", this.jdField_b_of_type_Int);
      localJSONObject.put("read_time", paramLong);
      localJSONObject.put("leave_comment_id_list", bmhv.a(this.jdField_c_of_type_JavaUtilList));
      localJSONObject.put("shown_page", 1);
      localJSONObject.put("stream_type", a());
      a(localJSONObject.toString(), "0X8009991");
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public void b(long paramLong, int paramInt)
  {
    b(paramLong);
    e(paramInt);
  }
  
  public void b(String paramString1, String paramString2, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("comment_id", paramString1);
      localJSONObject.put("sub_comment_id", paramString2);
      localJSONObject.put("comment_level", 1);
      localJSONObject.put("shown_page", 2);
      localJSONObject.put("entry", jdField_a_of_type_Int);
      localJSONObject.put("area", paramInt);
      localJSONObject.put("comment_platform", 3);
      a(localJSONObject.toString(), "0X800B211");
      return;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void b(pdp parampdp)
  {
    if (parampdp == null) {}
    BaseCommentData localBaseCommentData;
    do
    {
      return;
      localBaseCommentData = parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    } while (localBaseCommentData == null);
    String str = "0X800900D";
    if ((localBaseCommentData instanceof SubCommentData)) {
      str = "0X800955B";
    }
    a(new paa(parampdp).a().a(), str);
  }
  
  public void c()
  {
    Iterator localIterator = this.e.values().iterator();
    while (localIterator.hasNext())
    {
      pdp localpdp = (pdp)localIterator.next();
      if (localpdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData != null) {
        pnp.a(localpdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.medalInfo);
      }
    }
    this.e.clear();
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_Pcf == null) {
      return;
    }
    h((pdp)this.jdField_a_of_type_Pcf.getItem(paramInt));
    i((pdp)this.jdField_a_of_type_Pcf.getItem(paramInt));
    f(paramInt);
    k((pdp)this.jdField_a_of_type_Pcf.getItem(paramInt));
    d(System.currentTimeMillis(), paramInt);
    j((pdp)this.jdField_a_of_type_Pcf.getItem(paramInt));
    this.e.put(Integer.valueOf(paramInt), (pdp)this.jdField_a_of_type_Pcf.getItem(paramInt));
  }
  
  public void c(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (this.jdField_a_of_type_Pcf == null) || (!(this.jdField_a_of_type_Pcf instanceof pcb))) {
      return;
    }
    QLog.d("ReadInJoyCommentReportManager", 2, "ReadCommentTime " + paramLong);
    if ((this.jdField_c_of_type_JavaUtilList != null) && (this.jdField_c_of_type_JavaUtilList.isEmpty()) && (this.jdField_a_of_type_Pcf.a() != null)) {
      b(0, this.jdField_a_of_type_Pcf.a().getLastVisiblePosition());
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("entry", jdField_a_of_type_Int);
      localJSONObject.put("comment_platform", 3);
      localJSONObject.put("website", 0);
      localJSONObject.put("read_time", paramLong);
      localJSONObject.put("leave_comment_id_list", bmhv.a(this.jdField_c_of_type_JavaUtilList));
      localJSONObject.put("shown_page", 2);
      localJSONObject.put("comment_id", ((pcb)this.jdField_a_of_type_Pcf).a());
      a(localJSONObject.toString(), "0X8009991");
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public void c(long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_Pcf == null) {}
    BaseCommentData localBaseCommentData;
    String str;
    do
    {
      do
      {
        do
        {
          return;
          if (this.jdField_d_of_type_JavaUtilList == null) {
            this.jdField_d_of_type_JavaUtilList = new ArrayList();
          }
          localObject = (pdp)this.jdField_a_of_type_Pcf.getItem(paramInt);
        } while (localObject == null);
        localBaseCommentData = ((pdp)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
      } while (localBaseCommentData == null);
      str = localBaseCommentData.commentId;
    } while ((((pdp)localObject).jdField_a_of_type_Int != 0) || (!(localBaseCommentData instanceof SubCommentData)) || (this.f.containsKey(str)));
    Object localObject = new Pair(Long.valueOf(paramLong), localObject);
    this.jdField_d_of_type_JavaUtilList.add(localObject);
    this.f.put(str, "");
  }
  
  public void c(pdp parampdp)
  {
    if (parampdp == null) {
      return;
    }
    String str = "0X8009011";
    if ((parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof SubCommentData)) {
      str = "0X800901A";
    }
    a(new paa(parampdp).a().a(), str);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("shown_page", 2);
      localJSONObject.put("entry", jdField_a_of_type_Int);
      localJSONObject.put("area", 2);
      localJSONObject.put("comment_platform", 3);
      a(localJSONObject.toString(), "0X800966A");
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public void d(int paramInt)
  {
    if (this.jdField_a_of_type_Pcf != null) {
      h((pdp)this.jdField_a_of_type_Pcf.getItem(paramInt));
    }
    c(System.currentTimeMillis(), paramInt);
  }
  
  public void d(pdp parampdp)
  {
    if (parampdp == null) {
      return;
    }
    a(new paa(parampdp).i().d().h().a().a(), "0X8009993");
  }
  
  public void e()
  {
    if ((this.jdField_d_of_type_JavaUtilList == null) || (this.jdField_d_of_type_JavaUtilList.size() == 0) || (this.jdField_a_of_type_Pcf == null)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_d_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Pair)localIterator.next();
        long l = ((Long)((Pair)localObject).first).longValue();
        localObject = (SubCommentData)((pdp)((Pair)localObject).second).jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("entry", jdField_a_of_type_Int);
          localJSONObject.put("comment_platform", 3);
          localJSONObject.put("comment_id", ((pcb)this.jdField_a_of_type_Pcf).a());
          localJSONObject.put("sub_comment_id", ((SubCommentData)localObject).commentId);
          localJSONObject.put("time", l);
          localJSONObject.put("thumb_up_num", ((SubCommentData)localObject).likeCnt);
          localJSONObject.put("shown_page", 2);
          localJSONObject.put("come_in_action", 2);
          localJSONObject.put("proxy_bytes", ((SubCommentData)localObject).passthrough);
          localJSONObject.put("tag_type", a((BaseCommentData)localObject));
          localJSONObject.put("picture", a((BaseCommentData)localObject));
          a(localJSONObject.toString(), "0X8009992");
          pnp.a(((SubCommentData)localObject).medalInfo);
          a((BaseCommentData)localObject);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public void e(pdp parampdp)
  {
    if (parampdp == null) {
      return;
    }
    a(new paa(parampdp).i().d().h().a().a(), "0X8009994");
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_JavaUtilMap == null) || (this.jdField_a_of_type_JavaUtilMap.isEmpty())) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext())
      {
        pdp localpdp = (pdp)localIterator.next();
        if (localpdp != null) {
          d(localpdp);
        }
      }
    }
  }
  
  public void f(pdp parampdp)
  {
    if (parampdp == null) {
      return;
    }
    a(new paa(parampdp).a().c().a(), "0X800A001");
  }
  
  public void g()
  {
    if ((this.jdField_b_of_type_JavaUtilMap == null) || (this.jdField_b_of_type_JavaUtilMap.isEmpty())) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext())
      {
        pdp localpdp = (pdp)localIterator.next();
        if (localpdp != null) {
          d(localpdp);
        }
      }
    }
  }
  
  public void g(pdp parampdp)
  {
    if (parampdp == null) {
      return;
    }
    a(new paa(parampdp).a().c().k().a(), "0X8009E82");
  }
  
  public void h()
  {
    if ((this.jdField_d_of_type_JavaUtilMap == null) || (this.jdField_d_of_type_JavaUtilMap.isEmpty())) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_d_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext())
      {
        pdp localpdp = (pdp)localIterator.next();
        if (localpdp != null) {
          d(localpdp);
        }
      }
    }
  }
  
  public void h(pdp parampdp)
  {
    if ((parampdp == null) || (parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) || (this.jdField_a_of_type_JavaUtilMap == null)) {}
    BaseCommentData localBaseCommentData;
    do
    {
      do
      {
        return;
      } while (!parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isActivity());
      localBaseCommentData = parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    } while (this.jdField_a_of_type_JavaUtilMap.containsKey(localBaseCommentData.commentId));
    this.jdField_a_of_type_JavaUtilMap.put(localBaseCommentData.commentId, parampdp);
  }
  
  public void i()
  {
    if ((this.jdField_c_of_type_JavaUtilMap == null) || (this.jdField_c_of_type_JavaUtilMap.isEmpty())) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_c_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext())
      {
        pdp localpdp = (pdp)localIterator.next();
        if (localpdp != null) {
          a(new paa(localpdp).a().c().k().a(), "0X800A2D2");
        }
      }
    }
  }
  
  public void i(pdp parampdp)
  {
    if ((parampdp == null) || (parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) || (this.jdField_a_of_type_JavaUtilMap == null)) {}
    BaseCommentData localBaseCommentData;
    do
    {
      do
      {
        return;
      } while (!parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isBanner());
      localBaseCommentData = parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    } while (this.jdField_b_of_type_JavaUtilMap.containsKey(localBaseCommentData.commentId));
    this.jdField_b_of_type_JavaUtilMap.put(localBaseCommentData.commentId, parampdp);
  }
  
  public void j(pdp parampdp)
  {
    if ((parampdp == null) || (parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) || (this.jdField_d_of_type_JavaUtilMap == null)) {}
    BaseCommentData localBaseCommentData;
    do
    {
      do
      {
        return;
      } while (!parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isDynamicComment());
      localBaseCommentData = parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    } while (this.jdField_d_of_type_JavaUtilMap.containsKey(localBaseCommentData.commentId));
    this.jdField_d_of_type_JavaUtilMap.put(localBaseCommentData.commentId, parampdp);
  }
  
  public void k(pdp parampdp)
  {
    if ((parampdp == null) || (parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) || (this.jdField_c_of_type_JavaUtilMap == null)) {}
    BaseCommentData localBaseCommentData;
    do
    {
      do
      {
        return;
      } while (TextUtils.isEmpty(parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.flowGuidePtsData));
      localBaseCommentData = parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    } while (this.jdField_c_of_type_JavaUtilMap.containsKey(localBaseCommentData.commentId));
    this.jdField_c_of_type_JavaUtilMap.put(localBaseCommentData.commentId, parampdp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pbn
 * JD-Core Version:    0.7.0.1
 */