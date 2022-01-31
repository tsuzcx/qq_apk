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

public class olq
{
  public static int a;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  protected Map<String, omt> a;
  private omg jdField_a_of_type_Omg;
  private int jdField_b_of_type_Int;
  private List<String> jdField_b_of_type_JavaUtilList = new ArrayList();
  protected Map<String, omt> b;
  private List<String> c;
  protected Map<String, omt> c;
  private List<Pair<Long, omt>> d;
  protected Map<String, omt> d;
  Map<Integer, omt> e = new HashMap();
  private Map<String, String> f = new HashMap();
  
  static
  {
    jdField_a_of_type_Int = 0;
  }
  
  public olq(omg paramomg, ArticleInfo paramArticleInfo, int paramInt)
  {
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_d_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    this.jdField_c_of_type_JavaUtilMap = new HashMap();
    this.jdField_d_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_Omg = paramomg;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    jdField_a_of_type_Int = paramInt;
    if ((this.jdField_a_of_type_Omg != null) && (this.jdField_a_of_type_Omg.a() != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_Omg.a().getAppRuntime());
    }
  }
  
  private int a()
  {
    int j = 0;
    int i = j;
    if (this.jdField_a_of_type_Omg != null)
    {
      i = j;
      if (this.jdField_a_of_type_Omg.a() != null) {
        i = this.jdField_a_of_type_Omg.b();
      }
    }
    return i;
  }
  
  private void d(long paramLong, int paramInt)
  {
    if ((this.f == null) || (this.jdField_a_of_type_Omg == null)) {}
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
          } while (this.jdField_a_of_type_Omg.getItem(paramInt) == null);
          localObject1 = (omt)this.jdField_a_of_type_Omg.getItem(paramInt);
        } while (localObject1 == null);
        localObject2 = ((omt)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
      } while (localObject2 == null);
      localObject2 = ((BaseCommentData)localObject2).commentId;
    } while ((((omt)localObject1).jdField_a_of_type_Int != 0) || (this.f.containsKey(localObject2)));
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
    if ((this.jdField_d_of_type_JavaUtilList == null) || (this.jdField_d_of_type_JavaUtilList.size() == 0)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_d_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        long l = ((Long)localPair.first).longValue();
        CommentData localCommentData = (CommentData)((omt)localPair.second).jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
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
          ((JSONObject)localObject).put("comment_type", ((omt)localPair.second).jdField_b_of_type_Int);
          ((JSONObject)localObject).put("show_sub_comment_id", bkbq.a(localArrayList));
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
    if (this.jdField_a_of_type_Omg == null) {}
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
        while ((i <= paramInt2) && (i < this.jdField_a_of_type_Omg.getCount()))
        {
          omt localomt = (omt)this.jdField_a_of_type_Omg.getItem(i);
          if ((localomt != null) && (localomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData != null) && (!TextUtils.isEmpty(localomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentId))) {
            this.jdField_c_of_type_JavaUtilList.add(localomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentId);
          }
          i += 1;
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, omt paramomt)
  {
    if (paramomt == null) {}
    while (paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) {
      return;
    }
    String str = "0X8009669";
    if (paramInt1 == 2) {
      str = "0X8009018";
    }
    a(new oke(paramomt).a().b(paramInt2).a(), str);
  }
  
  public void a(int paramInt, BaseCommentData paramBaseCommentData)
  {
    if (paramBaseCommentData == null)
    {
      a("", "0X8009BD7");
      return;
    }
    String str2 = new oke(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramBaseCommentData).a().a();
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
  
  public void a(int paramInt, omt paramomt)
  {
    if ((paramomt == null) || (paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null)) {}
    while (paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) {
      return;
    }
    String str = "0X8009010";
    if (paramInt == 2) {
      str = "0X8009014";
    }
    a(new oke(paramomt).a().c(1).a(), str);
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
  
  public void a(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(new ReadInJoyCommentReportManager.1(this, paramString2, paramString1));
  }
  
  public void a(omt paramomt)
  {
    if ((paramomt == null) || (paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null)) {}
    BaseCommentData localBaseCommentData;
    do
    {
      return;
      localBaseCommentData = paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    } while (localBaseCommentData == null);
    String str = "0X8009668";
    if ((localBaseCommentData instanceof SubCommentData)) {
      str = "0X8009013";
    }
    a(new oke(paramomt).a().a(), str);
  }
  
  public void a(omt paramomt, SubCommentData paramSubCommentData)
  {
    if ((paramomt != null) && (paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData != null)) {
      a(new oke(paramomt).a().a(((CommentData)paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData).subCommentNum).a(), "0X800901F");
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
    if (this.jdField_a_of_type_Omg == null) {
      return;
    }
    a(new oke(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, null).d(paramInt).a(), "0X8009D01");
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    QLog.d("ReadInJoyCommentReportManager", 2, "recordSubLeaveCommentIDList current screen firstpos " + paramInt1 + ", lastpos " + paramInt2);
    if (this.jdField_c_of_type_JavaUtilList != null) {
      this.jdField_c_of_type_JavaUtilList.clear();
    }
    for (;;)
    {
      if ((paramInt1 > paramInt2) || (paramInt1 >= this.jdField_a_of_type_Omg.getCount())) {
        return;
      }
      omt localomt = (omt)this.jdField_a_of_type_Omg.getItem(paramInt1);
      if ((localomt != null) && (localomt.jdField_a_of_type_Int == 0) && (localomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData != null) && (!TextUtils.isEmpty(localomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentId))) {
        this.jdField_c_of_type_JavaUtilList.add(localomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentId);
      }
      paramInt1 += 1;
    }
  }
  
  public void b(int paramInt, omt paramomt)
  {
    if (paramomt == null) {}
    Object localObject;
    do
    {
      return;
      localObject = paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    } while (localObject == null);
    if (paramInt == 1) {
      if (((BaseCommentData)localObject).isDisliked()) {
        localObject = "0X8009557";
      }
    }
    for (;;)
    {
      a(new oke(paramomt).a().a(), (String)localObject);
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
      localJSONObject.put("leave_comment_id_list", bkbq.a(this.jdField_c_of_type_JavaUtilList));
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
  
  public void b(omt paramomt)
  {
    if (paramomt == null) {}
    BaseCommentData localBaseCommentData;
    do
    {
      return;
      localBaseCommentData = paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    } while (localBaseCommentData == null);
    String str = "0X800900D";
    if ((localBaseCommentData instanceof SubCommentData)) {
      str = "0X800955B";
    }
    a(new oke(paramomt).a().a(), str);
  }
  
  public void c()
  {
    Iterator localIterator = this.e.values().iterator();
    while (localIterator.hasNext())
    {
      omt localomt = (omt)localIterator.next();
      if (localomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData != null) {
        ors.a(localomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.medalInfo);
      }
    }
    this.e.clear();
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_Omg == null) {
      return;
    }
    h((omt)this.jdField_a_of_type_Omg.getItem(paramInt));
    i((omt)this.jdField_a_of_type_Omg.getItem(paramInt));
    f(paramInt);
    k((omt)this.jdField_a_of_type_Omg.getItem(paramInt));
    d(System.currentTimeMillis(), paramInt);
    j((omt)this.jdField_a_of_type_Omg.getItem(paramInt));
    this.e.put(Integer.valueOf(paramInt), (omt)this.jdField_a_of_type_Omg.getItem(paramInt));
  }
  
  public void c(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (this.jdField_a_of_type_Omg == null) || (!(this.jdField_a_of_type_Omg instanceof omd))) {
      return;
    }
    QLog.d("ReadInJoyCommentReportManager", 2, "ReadCommentTime " + paramLong);
    if ((this.jdField_c_of_type_JavaUtilList != null) && (this.jdField_c_of_type_JavaUtilList.isEmpty()) && (this.jdField_a_of_type_Omg.a() != null)) {
      b(0, this.jdField_a_of_type_Omg.a().getLastVisiblePosition());
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("entry", jdField_a_of_type_Int);
      localJSONObject.put("comment_platform", 3);
      localJSONObject.put("website", 0);
      localJSONObject.put("read_time", paramLong);
      localJSONObject.put("leave_comment_id_list", bkbq.a(this.jdField_c_of_type_JavaUtilList));
      localJSONObject.put("shown_page", 2);
      localJSONObject.put("comment_id", ((omd)this.jdField_a_of_type_Omg).a());
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
    if (this.jdField_a_of_type_Omg == null) {}
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
          localObject = (omt)this.jdField_a_of_type_Omg.getItem(paramInt);
        } while (localObject == null);
        localBaseCommentData = ((omt)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
      } while (localBaseCommentData == null);
      str = localBaseCommentData.commentId;
    } while ((((omt)localObject).jdField_a_of_type_Int != 0) || (!(localBaseCommentData instanceof SubCommentData)) || (this.f.containsKey(str)));
    Object localObject = new Pair(Long.valueOf(paramLong), localObject);
    this.jdField_d_of_type_JavaUtilList.add(localObject);
    this.f.put(str, "");
  }
  
  public void c(omt paramomt)
  {
    if (paramomt == null) {
      return;
    }
    String str = "0X8009011";
    if ((paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof SubCommentData)) {
      str = "0X800901A";
    }
    a(new oke(paramomt).a().a(), str);
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
    if (this.jdField_a_of_type_Omg != null) {
      h((omt)this.jdField_a_of_type_Omg.getItem(paramInt));
    }
    c(System.currentTimeMillis(), paramInt);
  }
  
  public void d(omt paramomt)
  {
    if (paramomt == null) {
      return;
    }
    a(new oke(paramomt).g().c().f().a().a(), "0X8009993");
  }
  
  public void e()
  {
    if ((this.jdField_d_of_type_JavaUtilList == null) || (this.jdField_d_of_type_JavaUtilList.size() == 0) || (this.jdField_a_of_type_Omg == null)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_d_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Pair)localIterator.next();
        long l = ((Long)((Pair)localObject).first).longValue();
        localObject = (SubCommentData)((omt)((Pair)localObject).second).jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("entry", jdField_a_of_type_Int);
          localJSONObject.put("comment_platform", 3);
          localJSONObject.put("comment_id", ((omd)this.jdField_a_of_type_Omg).a());
          localJSONObject.put("sub_comment_id", ((SubCommentData)localObject).commentId);
          localJSONObject.put("time", l);
          localJSONObject.put("thumb_up_num", ((SubCommentData)localObject).likeCnt);
          localJSONObject.put("shown_page", 2);
          localJSONObject.put("come_in_action", 2);
          localJSONObject.put("proxy_bytes", ((SubCommentData)localObject).passthrough);
          a(localJSONObject.toString(), "0X8009992");
          ors.a(((SubCommentData)localObject).medalInfo);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public void e(omt paramomt)
  {
    if (paramomt == null) {
      return;
    }
    a(new oke(paramomt).g().c().f().a().a(), "0X8009994");
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
        omt localomt = (omt)localIterator.next();
        if (localomt != null) {
          d(localomt);
        }
      }
    }
  }
  
  public void f(omt paramomt)
  {
    if (paramomt == null) {
      return;
    }
    a(new oke(paramomt).a().b().a(), "0X800A001");
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
        omt localomt = (omt)localIterator.next();
        if (localomt != null) {
          d(localomt);
        }
      }
    }
  }
  
  public void g(omt paramomt)
  {
    if (paramomt == null) {
      return;
    }
    a(new oke(paramomt).a().b().i().a(), "0X8009E82");
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
        omt localomt = (omt)localIterator.next();
        if (localomt != null) {
          d(localomt);
        }
      }
    }
  }
  
  public void h(omt paramomt)
  {
    if ((paramomt == null) || (paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) || (this.jdField_a_of_type_JavaUtilMap == null)) {}
    BaseCommentData localBaseCommentData;
    do
    {
      do
      {
        return;
      } while (!paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isActivity());
      localBaseCommentData = paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    } while (this.jdField_a_of_type_JavaUtilMap.containsKey(localBaseCommentData.commentId));
    this.jdField_a_of_type_JavaUtilMap.put(localBaseCommentData.commentId, paramomt);
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
        omt localomt = (omt)localIterator.next();
        if (localomt != null) {
          a(new oke(localomt).a().b().i().a(), "0X800A2D2");
        }
      }
    }
  }
  
  public void i(omt paramomt)
  {
    if ((paramomt == null) || (paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) || (this.jdField_a_of_type_JavaUtilMap == null)) {}
    BaseCommentData localBaseCommentData;
    do
    {
      do
      {
        return;
      } while (!paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isBanner());
      localBaseCommentData = paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    } while (this.jdField_b_of_type_JavaUtilMap.containsKey(localBaseCommentData.commentId));
    this.jdField_b_of_type_JavaUtilMap.put(localBaseCommentData.commentId, paramomt);
  }
  
  public void j(omt paramomt)
  {
    if ((paramomt == null) || (paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) || (this.jdField_d_of_type_JavaUtilMap == null)) {}
    BaseCommentData localBaseCommentData;
    do
    {
      do
      {
        return;
      } while (!paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isDynamicComment());
      localBaseCommentData = paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    } while (this.jdField_d_of_type_JavaUtilMap.containsKey(localBaseCommentData.commentId));
    this.jdField_d_of_type_JavaUtilMap.put(localBaseCommentData.commentId, paramomt);
  }
  
  public void k(omt paramomt)
  {
    if ((paramomt == null) || (paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) || (this.jdField_c_of_type_JavaUtilMap == null)) {}
    BaseCommentData localBaseCommentData;
    do
    {
      do
      {
        return;
      } while (TextUtils.isEmpty(paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.flowGuidePtsData));
      localBaseCommentData = paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    } while (this.jdField_c_of_type_JavaUtilMap.containsKey(localBaseCommentData.commentId));
    this.jdField_c_of_type_JavaUtilMap.put(localBaseCommentData.commentId, paramomt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     olq
 * JD-Core Version:    0.7.0.1
 */