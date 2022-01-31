import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListView;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentReportManager.1;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
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

public class ohc
{
  public static int a;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  protected Map<String, oif> a;
  private ohs jdField_a_of_type_Ohs;
  private int jdField_b_of_type_Int;
  private List<String> jdField_b_of_type_JavaUtilList = new ArrayList();
  protected Map<String, oif> b;
  private List<String> c;
  protected Map<String, oif> c;
  private List<Pair<Long, oif>> d;
  protected Map<String, oif> d;
  Map<Integer, oif> e = new HashMap();
  private Map<String, String> f = new HashMap();
  
  static
  {
    jdField_a_of_type_Int = 0;
  }
  
  public ohc(ohs paramohs, ArticleInfo paramArticleInfo, int paramInt)
  {
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_d_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    this.jdField_c_of_type_JavaUtilMap = new HashMap();
    this.jdField_d_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_Ohs = paramohs;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    jdField_a_of_type_Int = paramInt;
    if ((this.jdField_a_of_type_Ohs != null) && (this.jdField_a_of_type_Ohs.a() != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_Ohs.a().getAppRuntime());
    }
  }
  
  private int a()
  {
    int j = 0;
    int i = j;
    if (this.jdField_a_of_type_Ohs != null)
    {
      i = j;
      if (this.jdField_a_of_type_Ohs.a() != null) {
        i = this.jdField_a_of_type_Ohs.b();
      }
    }
    return i;
  }
  
  private void d(long paramLong, int paramInt)
  {
    if ((this.f == null) || (this.jdField_a_of_type_Ohs == null)) {}
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
          } while (this.jdField_a_of_type_Ohs.getItem(paramInt) == null);
          localObject1 = (oif)this.jdField_a_of_type_Ohs.getItem(paramInt);
        } while (localObject1 == null);
        localObject2 = ((oif)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
      } while (localObject2 == null);
      localObject2 = ((BaseCommentData)localObject2).commentId;
    } while ((((oif)localObject1).jdField_a_of_type_Int != 0) || (this.f.containsKey(localObject2)));
    Object localObject1 = new Pair(Long.valueOf(paramLong), localObject1);
    this.jdField_d_of_type_JavaUtilList.add(localObject1);
    this.f.put(localObject2, "");
  }
  
  private void e(int paramInt)
  {
    a(paramInt);
    g();
    h();
    d();
    j();
    i();
  }
  
  private void f(int paramInt)
  {
    if (this.jdField_a_of_type_Ohs == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = (oif)this.jdField_a_of_type_Ohs.getItem(paramInt);
      } while ((localObject == null) || (((oif)localObject).jdField_b_of_type_Int != 1));
      localObject = ((oif)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    } while ((localObject == null) || (this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.contains(((BaseCommentData)localObject).commentId)));
    this.jdField_a_of_type_JavaUtilList.add(((BaseCommentData)localObject).commentId);
  }
  
  private void g(int paramInt)
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
    if ((this.jdField_d_of_type_JavaUtilList == null) || (this.jdField_d_of_type_JavaUtilList.size() == 0)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_d_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        long l = ((Long)localPair.first).longValue();
        CommentData localCommentData = (CommentData)((oif)localPair.second).jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
        ArrayList localArrayList = new ArrayList();
        Object localObject;
        if ((localCommentData.subCommentList != null) && (localCommentData.subCommentList.size() > 0))
        {
          localObject = localCommentData.subCommentList.iterator();
          while (((Iterator)localObject).hasNext()) {
            localArrayList.add(((SubCommentData)((Iterator)localObject).next()).commentId);
          }
        }
        try
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("entry", jdField_a_of_type_Int);
          ((JSONObject)localObject).put("comment_platform", 3);
          ((JSONObject)localObject).put("comment_id", localCommentData.commentId);
          ((JSONObject)localObject).put("time", l);
          ((JSONObject)localObject).put("thumb_up_num", localCommentData.likeCnt);
          ((JSONObject)localObject).put("sub_comment_num", localCommentData.subCommentNum);
          ((JSONObject)localObject).put("shown_page", 1);
          ((JSONObject)localObject).put("comment_type", ((oif)localPair.second).jdField_b_of_type_Int);
          ((JSONObject)localObject).put("show_sub_comment_id", bhvy.a(localArrayList));
          ((JSONObject)localObject).put("come_in_action", paramInt);
          ((JSONObject)localObject).put("proxy_bytes", localCommentData.passthrough);
          ((JSONObject)localObject).put("stream_type", a());
          a(((JSONObject)localObject).toString(), "0X8009992");
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Ohs == null) {}
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
        while ((i <= paramInt2) && (i < this.jdField_a_of_type_Ohs.getCount()))
        {
          oif localoif = (oif)this.jdField_a_of_type_Ohs.getItem(i);
          if ((localoif != null) && (localoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData != null) && (!TextUtils.isEmpty(localoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentId))) {
            this.jdField_c_of_type_JavaUtilList.add(localoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentId);
          }
          i += 1;
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, oif paramoif)
  {
    if (paramoif == null) {}
    while (paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) {
      return;
    }
    String str = "0X8009669";
    if (paramInt1 == 2) {
      str = "0X8009018";
    }
    a(new ofs(paramoif).a().b(paramInt2).a(), str);
  }
  
  public void a(int paramInt, BaseCommentData paramBaseCommentData)
  {
    if (paramBaseCommentData == null)
    {
      a("", "0X8009BD7");
      return;
    }
    String str2 = new ofs(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramBaseCommentData).a().a();
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
      a(str2.toString(), (String)localObject);
      return;
      localObject = str1;
    }
  }
  
  public void a(int paramInt, oif paramoif)
  {
    if ((paramoif == null) || (paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null)) {}
    while (paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) {
      return;
    }
    String str = "0X8009010";
    if (paramInt == 2) {
      str = "0X8009014";
    }
    a(new ofs(paramoif).a().c(1).a(), str);
  }
  
  public void a(long paramLong)
  {
    c(paramLong);
    f();
    g();
  }
  
  public void a(long paramLong, int paramInt)
  {
    b();
    b(paramLong);
    e(paramInt);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(new ReadInJoyCommentReportManager.1(this, paramString2, paramString1));
  }
  
  public void a(oif paramoif)
  {
    if ((paramoif == null) || (paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null)) {}
    BaseCommentData localBaseCommentData;
    do
    {
      return;
      localBaseCommentData = paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    } while (localBaseCommentData == null);
    String str = "0X8009668";
    if ((localBaseCommentData instanceof SubCommentData)) {
      str = "0X8009013";
    }
    a(new ofs(paramoif).a().a(), str);
  }
  
  public void a(oif paramoif, SubCommentData paramSubCommentData)
  {
    if ((paramoif != null) && (paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData != null)) {
      a(new ofs(paramoif).a().a(((CommentData)paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData).subCommentNum).a(), "0X800901F");
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("comment_id", str);
        localJSONObject.put("comment_platform", 3);
        a(localJSONObject.toString(), "0X8009666");
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_Ohs == null) {
      return;
    }
    a(new ofs(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, null).d(paramInt).a(), "0X8009D01");
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    QLog.d("ReadInJoyCommentReportManager", 2, "recordSubLeaveCommentIDList current screen firstpos " + paramInt1 + ", lastpos " + paramInt2);
    if (this.jdField_c_of_type_JavaUtilList != null) {
      this.jdField_c_of_type_JavaUtilList.clear();
    }
    for (;;)
    {
      if ((paramInt1 > paramInt2) || (paramInt1 >= this.jdField_a_of_type_Ohs.getCount())) {
        return;
      }
      oif localoif = (oif)this.jdField_a_of_type_Ohs.getItem(paramInt1);
      if ((localoif != null) && (localoif.jdField_a_of_type_Int == 0) && (localoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData != null) && (!TextUtils.isEmpty(localoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentId))) {
        this.jdField_c_of_type_JavaUtilList.add(localoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentId);
      }
      paramInt1 += 1;
    }
  }
  
  public void b(int paramInt, oif paramoif)
  {
    if (paramoif == null) {}
    Object localObject;
    do
    {
      return;
      localObject = paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    } while (localObject == null);
    if (paramInt == 1) {
      if (((BaseCommentData)localObject).isDisliked()) {
        localObject = "0X8009557";
      }
    }
    for (;;)
    {
      a(new ofs(paramoif).a().a(), (String)localObject);
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
      localJSONObject.put("leave_comment_id_list", bhvy.a(this.jdField_c_of_type_JavaUtilList));
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
  
  public void b(oif paramoif)
  {
    if (paramoif == null) {}
    BaseCommentData localBaseCommentData;
    do
    {
      return;
      localBaseCommentData = paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    } while (localBaseCommentData == null);
    String str = "0X800900D";
    if ((localBaseCommentData instanceof SubCommentData)) {
      str = "0X800955B";
    }
    a(new ofs(paramoif).a().a(), str);
  }
  
  public void c()
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
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_Ohs == null) {
      return;
    }
    h((oif)this.jdField_a_of_type_Ohs.getItem(paramInt));
    i((oif)this.jdField_a_of_type_Ohs.getItem(paramInt));
    f(paramInt);
    g(paramInt);
    k((oif)this.jdField_a_of_type_Ohs.getItem(paramInt));
    d(System.currentTimeMillis(), paramInt);
    j((oif)this.jdField_a_of_type_Ohs.getItem(paramInt));
    this.e.put(Integer.valueOf(paramInt), (oif)this.jdField_a_of_type_Ohs.getItem(paramInt));
  }
  
  public void c(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (this.jdField_a_of_type_Ohs == null) || (!(this.jdField_a_of_type_Ohs instanceof ohp))) {
      return;
    }
    QLog.d("ReadInJoyCommentReportManager", 2, "ReadCommentTime " + paramLong);
    if ((this.jdField_c_of_type_JavaUtilList != null) && (this.jdField_c_of_type_JavaUtilList.isEmpty()) && (this.jdField_a_of_type_Ohs.a() != null)) {
      b(0, this.jdField_a_of_type_Ohs.a().getLastVisiblePosition());
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("entry", jdField_a_of_type_Int);
      localJSONObject.put("comment_platform", 3);
      localJSONObject.put("website", 0);
      localJSONObject.put("read_time", paramLong);
      localJSONObject.put("leave_comment_id_list", bhvy.a(this.jdField_c_of_type_JavaUtilList));
      localJSONObject.put("shown_page", 2);
      localJSONObject.put("comment_id", ((ohp)this.jdField_a_of_type_Ohs).a());
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
    if (this.jdField_a_of_type_Ohs == null) {}
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
          localObject = (oif)this.jdField_a_of_type_Ohs.getItem(paramInt);
        } while (localObject == null);
        localBaseCommentData = ((oif)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
      } while (localBaseCommentData == null);
      str = localBaseCommentData.commentId;
    } while ((((oif)localObject).jdField_a_of_type_Int != 0) || (!(localBaseCommentData instanceof SubCommentData)) || (this.f.containsKey(str)));
    Object localObject = new Pair(Long.valueOf(paramLong), localObject);
    this.jdField_d_of_type_JavaUtilList.add(localObject);
    this.f.put(str, "");
  }
  
  public void c(oif paramoif)
  {
    if (paramoif == null) {
      return;
    }
    String str = "0X8009011";
    if ((paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof SubCommentData)) {
      str = "0X800901A";
    }
    a(new ofs(paramoif).a().a(), str);
  }
  
  public void d()
  {
    Iterator localIterator = this.e.values().iterator();
    while (localIterator.hasNext())
    {
      oif localoif = (oif)localIterator.next();
      if (localoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData != null) {
        onh.a(localoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.medalInfo);
      }
    }
    this.e.clear();
  }
  
  public void d(int paramInt)
  {
    if (this.jdField_a_of_type_Ohs != null) {
      h((oif)this.jdField_a_of_type_Ohs.getItem(paramInt));
    }
    c(System.currentTimeMillis(), paramInt);
  }
  
  public void d(oif paramoif)
  {
    if (paramoif == null) {
      return;
    }
    a(new ofs(paramoif).g().c().f().a().a(), "0X8009993");
  }
  
  public void e()
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
  
  public void e(oif paramoif)
  {
    if (paramoif == null) {
      return;
    }
    a(new ofs(paramoif).g().c().f().a().a(), "0X8009994");
  }
  
  public void f()
  {
    if ((this.jdField_d_of_type_JavaUtilList == null) || (this.jdField_d_of_type_JavaUtilList.size() == 0) || (this.jdField_a_of_type_Ohs == null)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_d_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Pair)localIterator.next();
        long l = ((Long)((Pair)localObject).first).longValue();
        localObject = (SubCommentData)((oif)((Pair)localObject).second).jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("entry", jdField_a_of_type_Int);
          localJSONObject.put("comment_platform", 3);
          localJSONObject.put("comment_id", ((ohp)this.jdField_a_of_type_Ohs).a());
          localJSONObject.put("sub_comment_id", ((SubCommentData)localObject).commentId);
          localJSONObject.put("time", l);
          localJSONObject.put("thumb_up_num", ((SubCommentData)localObject).likeCnt);
          localJSONObject.put("shown_page", 2);
          localJSONObject.put("come_in_action", 2);
          localJSONObject.put("proxy_bytes", ((SubCommentData)localObject).passthrough);
          a(localJSONObject.toString(), "0X8009992");
          onh.a(((SubCommentData)localObject).medalInfo);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public void f(oif paramoif)
  {
    if (paramoif == null) {
      return;
    }
    a(new ofs(paramoif).a().b().a(), "0X800A001");
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_JavaUtilMap == null) || (this.jdField_a_of_type_JavaUtilMap.isEmpty())) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext())
      {
        oif localoif = (oif)localIterator.next();
        if (localoif != null) {
          d(localoif);
        }
      }
    }
  }
  
  public void g(oif paramoif)
  {
    if (paramoif == null) {
      return;
    }
    a(new ofs(paramoif).a().b().i().a(), "0X8009E82");
  }
  
  public void h()
  {
    if ((this.jdField_b_of_type_JavaUtilMap == null) || (this.jdField_b_of_type_JavaUtilMap.isEmpty())) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext())
      {
        oif localoif = (oif)localIterator.next();
        if (localoif != null) {
          d(localoif);
        }
      }
    }
  }
  
  public void h(oif paramoif)
  {
    if ((paramoif == null) || (paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) || (this.jdField_a_of_type_JavaUtilMap == null)) {}
    BaseCommentData localBaseCommentData;
    do
    {
      do
      {
        return;
      } while (!paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isActivity());
      localBaseCommentData = paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    } while (this.jdField_a_of_type_JavaUtilMap.containsKey(localBaseCommentData.commentId));
    this.jdField_a_of_type_JavaUtilMap.put(localBaseCommentData.commentId, paramoif);
  }
  
  public void i()
  {
    if ((this.jdField_d_of_type_JavaUtilMap == null) || (this.jdField_d_of_type_JavaUtilMap.isEmpty())) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_d_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext())
      {
        oif localoif = (oif)localIterator.next();
        if (localoif != null) {
          d(localoif);
        }
      }
    }
  }
  
  public void i(oif paramoif)
  {
    if ((paramoif == null) || (paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) || (this.jdField_a_of_type_JavaUtilMap == null)) {}
    BaseCommentData localBaseCommentData;
    do
    {
      do
      {
        return;
      } while (!paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isBanner());
      localBaseCommentData = paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    } while (this.jdField_b_of_type_JavaUtilMap.containsKey(localBaseCommentData.commentId));
    this.jdField_b_of_type_JavaUtilMap.put(localBaseCommentData.commentId, paramoif);
  }
  
  public void j()
  {
    if ((this.jdField_c_of_type_JavaUtilMap == null) || (this.jdField_c_of_type_JavaUtilMap.isEmpty())) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_c_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext())
      {
        oif localoif = (oif)localIterator.next();
        if (localoif != null) {
          a(new ofs(localoif).a().b().i().a(), "0X800A2D2");
        }
      }
    }
  }
  
  public void j(oif paramoif)
  {
    if ((paramoif == null) || (paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) || (this.jdField_d_of_type_JavaUtilMap == null)) {}
    BaseCommentData localBaseCommentData;
    do
    {
      do
      {
        return;
      } while (!paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isDynamicComment());
      localBaseCommentData = paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    } while (this.jdField_d_of_type_JavaUtilMap.containsKey(localBaseCommentData.commentId));
    this.jdField_d_of_type_JavaUtilMap.put(localBaseCommentData.commentId, paramoif);
  }
  
  public void k(oif paramoif)
  {
    if ((paramoif == null) || (paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) || (this.jdField_c_of_type_JavaUtilMap == null)) {}
    BaseCommentData localBaseCommentData;
    do
    {
      do
      {
        return;
      } while (TextUtils.isEmpty(paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.flowGuidePtsData));
      localBaseCommentData = paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    } while (this.jdField_c_of_type_JavaUtilMap.containsKey(localBaseCommentData.commentId));
    this.jdField_c_of_type_JavaUtilMap.put(localBaseCommentData.commentId, paramoif);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ohc
 * JD-Core Version:    0.7.0.1
 */