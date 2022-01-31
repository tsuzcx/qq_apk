import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommonCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager.27;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager.28;
import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class oio
  implements ohe
{
  private static Map<String, oio> jdField_a_of_type_JavaUtilMap = new HashMap();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private bfms<Pair<String, BaseCommentData>> jdField_a_of_type_Bfms = new bfms();
  protected CommonCommentData a;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  protected String a;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private ojr jdField_a_of_type_Ojr;
  private oju jdField_a_of_type_Oju;
  private ojx jdField_a_of_type_Ojx;
  private okc jdField_a_of_type_Okc = new okc();
  private boolean jdField_a_of_type_Boolean = true;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString = "";
  private List<String> jdField_b_of_type_JavaUtilList = new ArrayList();
  private Map<String, BaseCommentData> jdField_b_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_b_of_type_Boolean = true;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString = "";
  private List<String> jdField_c_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_c_of_type_Boolean = true;
  private long jdField_d_of_type_Long;
  private String jdField_d_of_type_JavaLangString = "";
  private List<String> jdField_d_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_d_of_type_Boolean = true;
  private String jdField_e_of_type_JavaLangString = "";
  private List<ojt> jdField_e_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_e_of_type_Boolean;
  private String jdField_f_of_type_JavaLangString = "";
  private boolean jdField_f_of_type_Boolean = true;
  private String g = "";
  
  private oio(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = "";
    paramString = onk.a();
    if (paramString != null)
    {
      this.jdField_a_of_type_Oju = ((oso)paramString.getManager(163)).a().a();
      this.jdField_a_of_type_Oju.a(this);
    }
    this.jdField_a_of_type_Ojx = new ojx();
    this.jdField_a_of_type_Ojx.a(this);
    a(this.jdField_a_of_type_Okc);
  }
  
  private int a(BaseCommentData paramBaseCommentData)
  {
    if (paramBaseCommentData == null) {}
    do
    {
      return 0;
      if (paramBaseCommentData.isActivity()) {
        return 4;
      }
      if (paramBaseCommentData.isBanner()) {
        return 5;
      }
    } while (!paramBaseCommentData.isDynamicComment());
    return 7;
  }
  
  private BaseCommentData a(int paramInt, String paramString)
  {
    Object localObject1;
    Object localObject3;
    Object localObject2;
    if (paramInt == 1)
    {
      localObject1 = new CommentData();
      ((BaseCommentData)localObject1).level = paramInt;
      ((BaseCommentData)localObject1).anonymous = 0;
      ((BaseCommentData)localObject1).authorSelection = 0;
      ((BaseCommentData)localObject1).awesome = 0;
      ((BaseCommentData)localObject1).uin = onk.a();
      ((BaseCommentData)localObject1).homepage = onk.h(((BaseCommentData)localObject1).uin);
      ((BaseCommentData)localObject1).myself = 1;
      ((BaseCommentData)localObject1).like = 0;
      ((BaseCommentData)localObject1).disLike = 0;
      ((BaseCommentData)localObject1).likeCnt = 0;
      ((BaseCommentData)localObject1).rank = 0;
      ((BaseCommentData)localObject1).rowKey = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID;
      ((BaseCommentData)localObject1).contentSrc = this.jdField_a_of_type_Int;
      ((BaseCommentData)localObject1).authorComment = "";
      ((BaseCommentData)localObject1).commentTime = NetConnInfoCenter.getServerTime();
      localObject3 = ReadInJoyUserInfoModule.a(Long.parseLong(((BaseCommentData)localObject1).uin), null);
      if (localObject3 == null) {
        break label343;
      }
      localObject2 = ((ReadInJoyUserInfo)localObject3).nick;
      label133:
      ((BaseCommentData)localObject1).nickName = ((String)localObject2);
      if (localObject3 == null) {
        break label351;
      }
      localObject2 = ((ReadInJoyUserInfo)localObject3).faceUrl;
      label151:
      ((BaseCommentData)localObject1).avatar = ((String)localObject2);
    }
    label386:
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        ((BaseCommentData)localObject1).commentContent = new String(bbca.decode(paramString.getString("comment"), 0));
        if (paramInt == 2)
        {
          localObject2 = (SubCommentData)localObject1;
          localObject3 = paramString.getString("commentId");
          localObject3 = (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(localObject3);
          if (!(localObject3 instanceof SubCommentData)) {
            continue;
          }
          ((SubCommentData)localObject2).parentCommentId = ((SubCommentData)localObject3).parentCommentId;
          if (paramString.optBoolean("isSecondReply", false))
          {
            localObject3 = paramString.optString("replyUin");
            if (!TextUtils.isEmpty((CharSequence)localObject3))
            {
              ((SubCommentData)localObject2).repliedUserUin = ((String)localObject3);
              paramString = ReadInJoyUserInfoModule.a(Long.valueOf((String)localObject3).longValue(), null);
              if (paramString == null) {
                break label386;
              }
              paramString = paramString.nick;
              ((SubCommentData)localObject2).repliedUserNickname = paramString;
              ((SubCommentData)localObject2).repliedUserHomePage = onk.h((String)localObject3);
              ((SubCommentData)localObject2).hasTarget = 1;
            }
          }
        }
        return localObject1;
        if (paramInt == 2)
        {
          localObject1 = new SubCommentData();
          break;
        }
        return null;
        label343:
        localObject2 = ReadInJoyUserInfoModule.a();
        break label133;
        label351:
        localObject2 = "";
        break label151;
        if ((localObject3 instanceof CommentData))
        {
          ((SubCommentData)localObject2).parentCommentId = ((BaseCommentData)localObject3).commentId;
          continue;
          paramString = ReadInJoyUserInfoModule.a();
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return null;
      }
    }
  }
  
  private List<oii> a(int paramInt, List<BaseCommentData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      BaseCommentData localBaseCommentData = (BaseCommentData)paramList.next();
      localArrayList.add(new oii(paramInt, a(localBaseCommentData), localBaseCommentData, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
    }
    return localArrayList;
  }
  
  private List<oii> a(boolean paramBoolean, BaseCommentData paramBaseCommentData, List<SubCommentData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean)
    {
      localArrayList.add(new oii(0, paramBaseCommentData, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
      localArrayList.add(new oii(3, paramBaseCommentData, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramBaseCommentData = paramList.iterator();
      if (paramBaseCommentData.hasNext())
      {
        paramList = (SubCommentData)paramBaseCommentData.next();
        if (paramList.isActivity()) {}
        for (int i = 4;; i = 0)
        {
          localArrayList.add(new oii(i, paramList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
          break;
        }
      }
    }
    return localArrayList;
  }
  
  public static oio a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return null;
    }
    return (oio)jdField_a_of_type_JavaUtilMap.get(paramArticleInfo.innerUniqueID);
  }
  
  public static oio a(ArticleInfo paramArticleInfo, int paramInt)
  {
    if (paramArticleInfo == null) {
      localObject = null;
    }
    oio localoio;
    do
    {
      return localObject;
      localoio = (oio)jdField_a_of_type_JavaUtilMap.get(paramArticleInfo.innerUniqueID);
      localObject = localoio;
    } while (localoio != null);
    Object localObject = new oio(paramArticleInfo.innerUniqueID);
    ((oio)localObject).b(paramArticleInfo);
    ((oio)localObject).jdField_a_of_type_Int = paramInt;
    if (paramInt == 1) {}
    for (((oio)localObject).jdField_a_of_type_JavaLangString = (paramArticleInfo.mArticleID + "");; ((oio)localObject).jdField_a_of_type_JavaLangString = paramArticleInfo.innerUniqueID)
    {
      jdField_a_of_type_JavaUtilMap.put(paramArticleInfo.innerUniqueID, localObject);
      ((oio)localObject).g = paramArticleInfo.innerUniqueID;
      QLog.d("ReadInJoyCommentDataManager", 2, new Object[] { "create commentDataManager, articleInfo : ", paramArticleInfo, ", src : ", Integer.valueOf(paramInt) });
      return localObject;
    }
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_Oju == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      a(new ojo(this, paramInt));
      return;
    }
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "fetch sub commentList, id : ", paramString1, ", fetchType : ", Integer.valueOf(paramInt), ", cookie : ", this.jdField_c_of_type_JavaLangString });
    this.jdField_a_of_type_Oju.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, paramString1, paramString2, this.jdField_c_of_type_JavaLangString, 10, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData);
  }
  
  private void a(CommentData paramCommentData, int paramInt)
  {
    if (paramCommentData == null) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.contains(paramCommentData.commentId)))
      {
        this.jdField_c_of_type_Long += paramInt;
        QLog.d("ReadInJoyCommentDataManager", 2, "updateCommentCount | mHotCommentCnt " + this.jdField_c_of_type_Long);
      }
      if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.contains(paramCommentData.commentId)))
      {
        this.jdField_b_of_type_Long += paramInt;
        QLog.d("ReadInJoyCommentDataManager", 2, "updateCommentCount | mNewCommentCnt " + this.jdField_b_of_type_Long);
      }
    } while ((this.jdField_d_of_type_JavaUtilList == null) || (!this.jdField_d_of_type_JavaUtilList.contains(paramCommentData.commentId)));
    this.jdField_d_of_type_Long += paramInt;
    QLog.d("ReadInJoyCommentDataManager", 2, "updateCommentCount | mFamilyCommentCnt " + this.jdField_d_of_type_Long);
  }
  
  public static void a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    do
    {
      return;
      paramArticleInfo = (oio)jdField_a_of_type_JavaUtilMap.remove(paramArticleInfo.innerUniqueID);
    } while (paramArticleInfo == null);
    paramArticleInfo.a();
    QLog.d("ReadInJoyCommentDataManager", 1, "removeCommentDataManager | destroy");
  }
  
  public static void a(ArticleInfo paramArticleInfo, int paramInt)
  {
    if (paramInt == 6)
    {
      paramArticleInfo = (oio)jdField_a_of_type_JavaUtilMap.get(paramArticleInfo.innerUniqueID);
      if (paramArticleInfo != null) {
        paramArticleInfo.e();
      }
      QLog.d("ReadInJoyCommentDataManager", 1, "removeCommentDataManager feedsType " + paramInt);
      return;
    }
    a(paramArticleInfo);
  }
  
  private void a(List<CommentData> paramList1, List<CommentData> paramList2)
  {
    if (this.jdField_b_of_type_JavaUtilMap == null) {}
    for (;;)
    {
      return;
      if ((paramList1 != null) && (paramList1.size() > 0))
      {
        paramList1 = paramList1.iterator();
        while (paramList1.hasNext())
        {
          CommentData localCommentData = (CommentData)paramList1.next();
          if (localCommentData != null)
          {
            this.jdField_b_of_type_JavaUtilMap.put(localCommentData.commentId, localCommentData);
            if (this.jdField_a_of_type_JavaUtilList != null) {
              this.jdField_a_of_type_JavaUtilList.add(localCommentData.commentId);
            }
          }
        }
      }
      if ((paramList2 != null) && (paramList2.size() > 0))
      {
        paramList1 = paramList2.iterator();
        while (paramList1.hasNext())
        {
          paramList2 = (CommentData)paramList1.next();
          if (paramList2 != null)
          {
            this.jdField_b_of_type_JavaUtilMap.put(paramList2.commentId, paramList2);
            if (this.jdField_b_of_type_JavaUtilList != null) {
              this.jdField_b_of_type_JavaUtilList.add(paramList2.commentId);
            }
          }
        }
      }
    }
  }
  
  private void a(List<ojt> paramList, boolean paramBoolean, ojq paramojq)
  {
    int i = 0;
    if (i < paramList.size())
    {
      ojt localojt = (ojt)paramList.get(i);
      if (paramBoolean) {
        ThreadManager.getUIHandler().post(new ReadInJoyCommentDataManager.27(this, paramojq, localojt));
      }
      for (;;)
      {
        i += 1;
        break;
        paramojq.a(localojt);
      }
    }
  }
  
  private void a(ojq paramojq)
  {
    a(paramojq, true);
  }
  
  private void a(ojq paramojq, boolean paramBoolean)
  {
    if ((!this.jdField_e_of_type_JavaUtilList.isEmpty()) && (paramojq != null)) {
      a(this.jdField_e_of_type_JavaUtilList, paramBoolean, paramojq);
    }
    ArrayList localArrayList = new ArrayList();
    if (ofz.a().a() != null) {
      localArrayList.addAll(ofz.a().a());
    }
    if ((localArrayList != null) && (paramojq != null)) {
      a(localArrayList, paramBoolean, paramojq);
    }
  }
  
  private boolean a(List<CommentData> paramList)
  {
    if ((paramList == null) || (this.jdField_a_of_type_Ojr == null) || (!this.jdField_a_of_type_Ojr.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Ojr.jdField_a_of_type_JavaLangString == null)) {
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      CommentData localCommentData = (CommentData)paramList.next();
      if ((localCommentData != null) && (this.jdField_a_of_type_Ojr.jdField_a_of_type_JavaLangString.equals(localCommentData.commentId)))
      {
        localCommentData.isAnchor = true;
        return true;
      }
    }
    return false;
  }
  
  private List<oii> b(int paramInt, List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.isEmpty())) {
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if ((!TextUtils.isEmpty(str)) && (this.jdField_b_of_type_JavaUtilMap.get(str) != null)) {
        localArrayList.add(new oii(paramInt, a((BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(str)), (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(str), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
      }
    }
    return localArrayList;
  }
  
  private void b(List<CommentData> paramList, List<String> paramList1)
  {
    if (this.jdField_b_of_type_JavaUtilMap == null) {}
    for (;;)
    {
      return;
      if ((paramList != null) && (paramList.size() > 0))
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          CommentData localCommentData = (CommentData)paramList.next();
          if (localCommentData != null)
          {
            this.jdField_b_of_type_JavaUtilMap.put(localCommentData.commentId, localCommentData);
            if (paramList1 != null) {
              paramList1.add(localCommentData.commentId);
            }
          }
        }
      }
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_JavaLangString = "";
  }
  
  private void c(int paramInt)
  {
    if ((this.jdField_a_of_type_Oju == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      a(new ojl(this, paramInt));
      return;
    }
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "fetch NewCommentList, fetchType : ", Integer.valueOf(paramInt), ", cookie : ", this.jdField_d_of_type_JavaLangString });
    if (paramInt == 1) {}
    for (Object localObject1 = "";; localObject1 = this.jdField_d_of_type_JavaLangString)
    {
      this.jdField_d_of_type_JavaLangString = ((String)localObject1);
      Object localObject2 = null;
      localObject1 = localObject2;
      if (paramInt == 1)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Ojr != null)
        {
          localObject1 = localObject2;
          if (this.jdField_a_of_type_Ojr.jdField_a_of_type_Boolean) {
            localObject1 = this.jdField_a_of_type_Ojr.jdField_a_of_type_JavaLangString;
          }
        }
      }
      this.jdField_a_of_type_Oju.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, this.jdField_d_of_type_JavaLangString, 10, this.jdField_a_of_type_Int, (String)localObject1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData);
      return;
    }
  }
  
  private void d()
  {
    if (this.jdField_b_of_type_JavaUtilList != null) {
      this.jdField_b_of_type_JavaUtilList.clear();
    }
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Long = 0L;
  }
  
  private void d(int paramInt)
  {
    if ((this.jdField_a_of_type_Oju == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      a(new ojm(this, paramInt));
      return;
    }
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "fetch HotCommentList, fetchType : ", Integer.valueOf(paramInt), ", cookie : ", this.jdField_e_of_type_JavaLangString });
    if (paramInt == 1) {}
    for (Object localObject1 = "";; localObject1 = this.jdField_e_of_type_JavaLangString)
    {
      this.jdField_e_of_type_JavaLangString = ((String)localObject1);
      Object localObject2 = null;
      localObject1 = localObject2;
      if (paramInt == 1)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Ojr != null)
        {
          localObject1 = localObject2;
          if (this.jdField_a_of_type_Ojr.jdField_a_of_type_Boolean) {
            localObject1 = this.jdField_a_of_type_Ojr.jdField_a_of_type_JavaLangString;
          }
        }
      }
      this.jdField_a_of_type_Oju.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, this.jdField_e_of_type_JavaLangString, 10, this.jdField_a_of_type_Int, (String)localObject1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData);
      return;
    }
  }
  
  private void e()
  {
    if (this.jdField_d_of_type_JavaUtilList != null) {
      this.jdField_d_of_type_JavaUtilList.clear();
    }
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_d_of_type_Long = 0L;
    this.jdField_e_of_type_Boolean = false;
  }
  
  private void e(int paramInt)
  {
    if ((this.jdField_a_of_type_Oju == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      a(new ojn(this, paramInt));
      return;
    }
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "fetchFamilyCommentList, fetchType : ", Integer.valueOf(paramInt), ", cookie : ", this.jdField_f_of_type_JavaLangString });
    if (paramInt == 1) {}
    for (String str = "";; str = this.jdField_f_of_type_JavaLangString)
    {
      this.jdField_f_of_type_JavaLangString = str;
      this.jdField_a_of_type_Oju.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, this.jdField_f_of_type_JavaLangString, 10, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData);
      return;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(String paramString)
  {
    BaseCommentData localBaseCommentData = (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(paramString);
    if (localBaseCommentData == null) {
      return 0;
    }
    if ((localBaseCommentData instanceof CommentData))
    {
      if (this.jdField_a_of_type_JavaUtilList.contains(paramString)) {
        return 1;
      }
      if (this.jdField_b_of_type_JavaUtilList.contains(paramString)) {
        return 2;
      }
    }
    else if ((localBaseCommentData instanceof SubCommentData))
    {
      return a(((SubCommentData)localBaseCommentData).parentCommentId);
    }
    return 0;
  }
  
  public long a()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public long a(int paramInt)
  {
    long l = this.jdField_b_of_type_Long;
    if (paramInt == 6) {
      l = this.jdField_d_of_type_Long;
    }
    QLog.d("ReadInJoyCommentDataManager", 2, "getFirstCommentTotalCount | feedsType " + paramInt + "; totalCount " + l);
    return l;
  }
  
  public long a(String paramString)
  {
    paramString = (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(paramString);
    if ((paramString != null) && ((paramString instanceof CommentData))) {
      return ((CommentData)paramString).subCommentNum;
    }
    return 0L;
  }
  
  public BaseCommentData a(String paramString)
  {
    return (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(paramString);
  }
  
  public CommonCommentData a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData;
  }
  
  public List<oii> a()
  {
    ArrayList localArrayList1 = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      ArrayList localArrayList2 = new ArrayList();
      i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        CommentData localCommentData = (CommentData)this.jdField_b_of_type_JavaUtilMap.get(this.jdField_a_of_type_JavaUtilList.get(i));
        if ((localCommentData != null) && ((!localCommentData.isFamilyTopEntry()) || ((localCommentData.isFamilyTopEntry()) && (!ogl.a())))) {
          localArrayList2.add(localCommentData);
        }
        i += 1;
      }
      if ((localArrayList2.size() > 0) && (this.jdField_f_of_type_Boolean)) {
        localArrayList1.add(new oii(1, null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
      }
      localArrayList1.addAll(a(1, new ArrayList(localArrayList2)));
    }
    if ("getTotalHotCommentList " + localArrayList1 != null) {}
    for (int i = localArrayList1.size();; i = 0)
    {
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { Integer.valueOf(i) });
      return localArrayList1;
    }
  }
  
  public List<oii> a(int paramInt)
  {
    QLog.d("ReadInJoyCommentDataManager", 1, "getCurrentFeedsTypeItemList | feedsType " + paramInt);
    switch (paramInt)
    {
    case 4: 
    case 5: 
    default: 
      return new ArrayList();
    case 3: 
      return a();
    case 2: 
      return b();
    }
    return c();
  }
  
  public List<oii> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(paramString);
    if (paramString == null) {
      return localArrayList;
    }
    localArrayList.add(new oii(0, paramString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
    localArrayList.add(new oii(3, paramString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
    return localArrayList;
  }
  
  public ojr a()
  {
    return this.jdField_a_of_type_Ojr;
  }
  
  public okc a()
  {
    return this.jdField_a_of_type_Okc;
  }
  
  public void a()
  {
    QLog.d("ReadInJoyCommentDataManager", 1, "CommentDataManager destroy");
    if (this.jdField_b_of_type_JavaUtilMap != null) {
      this.jdField_b_of_type_JavaUtilMap.clear();
    }
    c();
    d();
    e();
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = "";
    if (this.jdField_a_of_type_Bfms != null) {
      this.jdField_a_of_type_Bfms.a();
    }
    if (this.jdField_e_of_type_JavaUtilList != null) {
      this.jdField_e_of_type_JavaUtilList.clear();
    }
    if (this.jdField_a_of_type_Oju != null) {
      this.jdField_a_of_type_Oju.a();
    }
    if (this.jdField_a_of_type_Ojx != null) {
      this.jdField_a_of_type_Ojx.a();
    }
  }
  
  public void a(int paramInt)
  {
    a(new oji(this, paramInt));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Oju == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      a(new ojk(this, paramInt2));
      return;
    }
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "loadFirstCommentList | feedsType : " + paramInt1 + " contentSrc : " + this.jdField_a_of_type_Int + "; fetchType : " + paramInt2, ", cookie : ", this.jdField_b_of_type_JavaLangString });
    if (paramInt2 == 1) {}
    for (Object localObject1 = "";; localObject1 = this.jdField_b_of_type_JavaLangString)
    {
      this.jdField_b_of_type_JavaLangString = ((String)localObject1);
      Object localObject2 = null;
      localObject1 = localObject2;
      if (paramInt2 == 1)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Ojr != null)
        {
          localObject1 = localObject2;
          if (this.jdField_a_of_type_Ojr.jdField_a_of_type_Boolean) {
            localObject1 = this.jdField_a_of_type_Ojr.jdField_a_of_type_JavaLangString;
          }
        }
      }
      if (paramInt1 != 6) {
        break;
      }
      this.jdField_a_of_type_Oju.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, this.jdField_b_of_type_JavaLangString, 10, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData);
      return;
    }
    this.jdField_a_of_type_Oju.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, this.jdField_b_of_type_JavaLangString, 10, this.jdField_a_of_type_Int, (String)localObject1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData);
  }
  
  public void a(int paramInt, String paramString, ojv paramojv, ojw paramojw)
  {
    boolean bool2 = false;
    boolean bool3 = TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString);
    ojv localojv = paramojv;
    if (paramojv == null) {
      localojv = new ojv();
    }
    if (paramojw == null) {
      new ojw();
    }
    boolean bool1;
    if (paramInt == 0)
    {
      this.jdField_b_of_type_Boolean = localojv.jdField_a_of_type_Boolean;
      this.jdField_c_of_type_JavaLangString = localojv.jdField_a_of_type_JavaLangString;
      if (localojv.jdField_b_of_type_JavaUtilList == null) {
        break label336;
      }
      paramojv = localojv.jdField_b_of_type_JavaUtilList.iterator();
      while (paramojv.hasNext())
      {
        paramojw = (SubCommentData)paramojv.next();
        if (paramojw != null)
        {
          if (TextUtils.isEmpty(paramojw.parentCommentId)) {
            paramojw.parentCommentId = paramString;
          }
          this.jdField_b_of_type_JavaUtilMap.put(paramojw.commentId, paramojw);
          this.jdField_c_of_type_JavaUtilList.add(paramojw.commentId);
        }
      }
      paramojv = a(bool3, (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(paramString), localojv.jdField_b_of_type_JavaUtilList);
      bool1 = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        if (localojv.jdField_b_of_type_JavaUtilList == null) {
          break label331;
        }
      }
      label331:
      for (paramInt = localojv.jdField_b_of_type_JavaUtilList.size();; paramInt = 0)
      {
        if (localojv != null) {
          bool2 = localojv.jdField_a_of_type_Boolean;
        }
        QLog.d("ReadInJoyCommentDataManager", 2, new Object[] { "getSubCommentListResp ret : ", Boolean.valueOf(bool1), ", mainCommentID : ", paramString, ", size : ", Integer.valueOf(paramInt), ", hasNext : ", Boolean.valueOf(bool2), ", isFirstFetch : ", Boolean.valueOf(bool3) });
        a(new ojc(this, bool3, bool1, paramojv));
        return;
        paramojv = null;
        bool1 = false;
        break;
      }
      label336:
      paramojv = null;
      bool1 = true;
    }
  }
  
  public void a(int paramInt, ojv paramojv1, ojv paramojv2, ojw paramojw)
  {
    boolean bool1;
    boolean bool2;
    Object localObject;
    long l;
    label105:
    int i;
    if (paramInt == 0)
    {
      bool1 = true;
      bool2 = TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString);
      localObject = paramojv1;
      if (paramojv1 == null) {
        localObject = new ojv();
      }
      paramojv1 = paramojv2;
      if (paramojv2 == null) {
        paramojv1 = new ojv();
      }
      paramojv2 = paramojw;
      if (paramojw == null) {
        paramojv2 = new ojw();
      }
      if (bool1)
      {
        this.jdField_c_of_type_Boolean = paramojv1.jdField_a_of_type_Boolean;
        this.jdField_d_of_type_Boolean = ((ojv)localObject).jdField_a_of_type_Boolean;
        if (((ojv)localObject).jdField_a_of_type_JavaUtilList == null) {
          break label477;
        }
        l = ((ojv)localObject).jdField_a_of_type_JavaUtilList.size();
        this.jdField_c_of_type_Long = l;
        this.jdField_d_of_type_JavaLangString = paramojv1.jdField_a_of_type_JavaLangString;
        this.jdField_e_of_type_JavaLangString = ((ojv)localObject).jdField_a_of_type_JavaLangString;
        a(((ojv)localObject).jdField_a_of_type_JavaUtilList, paramojv1.jdField_a_of_type_JavaUtilList);
      }
      if (!bool2) {
        break label504;
      }
      if (paramojv2.jdField_a_of_type_Long > 0L) {
        this.jdField_b_of_type_Long = paramojv2.jdField_a_of_type_Long;
      }
      this.jdField_a_of_type_Long = paramojv2.jdField_b_of_type_Long;
      if ((this.jdField_a_of_type_Ojr != null) && (this.jdField_a_of_type_Ojr.jdField_b_of_type_Boolean))
      {
        if (!a(((ojv)localObject).jdField_a_of_type_JavaUtilList)) {
          a(new oiq(this));
        }
        this.jdField_a_of_type_Ojr.jdField_b_of_type_Boolean = false;
      }
      paramInt = 3;
      List localList = a(3);
      if (localList != null)
      {
        paramojw = localList;
        if (!localList.isEmpty()) {}
      }
      else
      {
        paramInt = 2;
        paramojw = a(2);
      }
      if (paramInt != 3) {
        break label483;
      }
      bool2 = this.jdField_d_of_type_Boolean;
      label268:
      if (!((ojv)localObject).a()) {
        break label492;
      }
      i = ((ojv)localObject).jdField_a_of_type_JavaUtilList.size();
      label288:
      localObject = new StringBuilder().append(", new size : ");
      if (!paramojv1.a()) {
        break label498;
      }
    }
    label477:
    label483:
    label492:
    label498:
    for (int j = paramojv1.jdField_a_of_type_JavaUtilList.size();; j = 0)
    {
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "onLoadFirstCommentFinish, ret : ", Boolean.valueOf(bool1), ", hot size : ", Integer.valueOf(i), j, ", totalCnt : ", this.jdField_b_of_type_Long + " , hideCnt : " + this.jdField_a_of_type_Long });
      a(new oir(this, bool1, paramojw, bool2, paramInt));
      if (this.jdField_a_of_type_Ojr != null) {
        this.jdField_a_of_type_Ojr.a(false);
      }
      this.jdField_a_of_type_Okc.a(paramojv2.jdField_a_of_type_Int);
      this.jdField_a_of_type_Okc.a(paramojv2.jdField_a_of_type_JavaLangString);
      return;
      bool1 = false;
      break;
      l = 0L;
      break label105;
      bool2 = this.jdField_c_of_type_Boolean;
      break label268;
      i = 0;
      break label288;
    }
    label504:
    if (paramojv1 != null) {}
    for (paramojv1 = a(2, new ArrayList(paramojv1.jdField_a_of_type_JavaUtilList));; paramojv1 = new ArrayList())
    {
      bool2 = this.jdField_a_of_type_Boolean;
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "onLoadMoreComment, ret : ", Boolean.valueOf(bool1), ", size : ", Integer.valueOf(paramojv1.size()), ", hasNext : ", Boolean.valueOf(bool2) });
      a(new ois(this, bool1, paramojv1));
      return;
    }
  }
  
  public void a(int paramInt, ojv paramojv, ojw paramojw, CommentData paramCommentData)
  {
    boolean bool2 = TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString);
    paramCommentData = paramojv;
    if (paramojv == null) {
      paramCommentData = new ojv();
    }
    paramojv = paramojw;
    if (paramojw == null) {
      paramojv = new ojw();
    }
    boolean bool1;
    if (paramInt == 0)
    {
      this.jdField_c_of_type_Boolean = paramCommentData.jdField_a_of_type_Boolean;
      this.jdField_d_of_type_JavaLangString = paramCommentData.jdField_a_of_type_JavaLangString;
      a(null, paramCommentData.jdField_a_of_type_JavaUtilList);
      bool1 = true;
      if (!bool2) {
        break label228;
      }
      if (paramojv.jdField_a_of_type_Long > 0L) {
        this.jdField_b_of_type_Long = paramojv.jdField_a_of_type_Long;
      }
      paramojv = b();
      paramojw = new StringBuilder().append(", new size : ");
      if (paramCommentData.jdField_a_of_type_JavaUtilList == null) {
        break label223;
      }
    }
    label223:
    for (paramInt = paramCommentData.jdField_a_of_type_JavaUtilList.size();; paramInt = 0)
    {
      QLog.d("ReadInJoyCommentDataManager", 2, new Object[] { "onLoadNewCommentFinish, ret : ", Boolean.valueOf(bool1), paramInt, ", totalCnt : ", Long.valueOf(this.jdField_b_of_type_Long) });
      a(new oit(this, bool1, paramojv));
      if (this.jdField_a_of_type_Ojr != null) {
        this.jdField_a_of_type_Ojr.a(false);
      }
      return;
      bool1 = false;
      break;
    }
    label228:
    if (paramCommentData.jdField_a_of_type_JavaUtilList != null) {}
    for (paramojv = a(2, new ArrayList(paramCommentData.jdField_a_of_type_JavaUtilList));; paramojv = new ArrayList())
    {
      bool2 = this.jdField_c_of_type_Boolean;
      QLog.d("ReadInJoyCommentDataManager", 2, new Object[] { "onLoadMoreNewComment, ret : ", Boolean.valueOf(bool1), ", size : ", Integer.valueOf(paramojv.size()), ", hasNext : ", Boolean.valueOf(bool2) });
      a(new oiu(this, bool1, paramojv, bool2));
      return;
    }
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt1, String paramString, int paramInt2)
  {
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "onCreateCommentResult | create comment resp, seq ", Long.valueOf(paramLong), " succ : ", Boolean.valueOf(paramBoolean), " data : ", paramString });
    if (this.jdField_b_of_type_JavaUtilList == null) {
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    Pair localPair = (Pair)this.jdField_a_of_type_Bfms.a(paramLong);
    if (localPair == null) {
      QLog.d("ReadInJoyCommentDataManager", 1, "onCreateCommentResult | fake comment data not exist, return !");
    }
    BaseCommentData localBaseCommentData;
    label263:
    label278:
    label478:
    do
    {
      do
      {
        do
        {
          return;
          localBaseCommentData = (BaseCommentData)localPair.second;
          this.jdField_a_of_type_Bfms.b(paramLong);
          if (!paramBoolean) {
            break;
          }
          ohi.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, (String)localPair.first);
          localBaseCommentData.commentId = paramString;
          this.jdField_b_of_type_JavaUtilMap.put(localBaseCommentData.commentId, localBaseCommentData);
          if ((localBaseCommentData instanceof CommentData))
          {
            if (paramInt2 == 6)
            {
              if (this.jdField_d_of_type_JavaUtilList == null) {
                this.jdField_d_of_type_JavaUtilList = new ArrayList();
              }
              if (this.jdField_d_of_type_JavaUtilList.size() == 0)
              {
                this.jdField_d_of_type_JavaUtilList.add(localBaseCommentData.commentId);
                if (this.jdField_b_of_type_JavaUtilList.size() != 0) {
                  break label478;
                }
                this.jdField_b_of_type_JavaUtilList.add(localBaseCommentData.commentId);
                if ((paramInt2 != 3) && (paramInt2 != 6)) {
                  break label582;
                }
                paramBoolean = true;
                a((CommentData)localBaseCommentData, 1);
                if (paramInt2 != 6) {
                  break label587;
                }
              }
            }
            for (paramInt1 = 4;; paramInt1 = 2)
            {
              QLog.d("ReadInJoyCommentDataManager", 2, "onCreateCommentResult | createComment feedsType " + paramInt1);
              a(new oje(this, new oii(paramInt1, 0, localBaseCommentData, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), paramBoolean, paramInt2));
              return;
              paramString = (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(this.jdField_d_of_type_JavaUtilList.get(0));
              if ((paramString != null) && (paramString.isBanner())) {
                if (this.jdField_d_of_type_JavaUtilList.size() < 2) {
                  this.jdField_d_of_type_JavaUtilList.add(localBaseCommentData.commentId);
                }
              }
              for (;;)
              {
                QLog.d("ReadInJoyCommentDataManager", 2, "onCreateCommentResult | familyCommentFeeds");
                break;
                this.jdField_d_of_type_JavaUtilList.add(1, localBaseCommentData.commentId);
                continue;
                this.jdField_d_of_type_JavaUtilList.add(0, localBaseCommentData.commentId);
              }
              paramInt2 = 2;
              break;
              paramString = (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(this.jdField_b_of_type_JavaUtilList.get(0));
              if ((paramString != null) && (paramString.isBanner()))
              {
                if (this.jdField_b_of_type_JavaUtilList.size() < 2)
                {
                  this.jdField_b_of_type_JavaUtilList.add(localBaseCommentData.commentId);
                  break label263;
                }
                this.jdField_b_of_type_JavaUtilList.add(1, localBaseCommentData.commentId);
                break label263;
              }
              this.jdField_b_of_type_JavaUtilList.add(0, localBaseCommentData.commentId);
              break label263;
              paramBoolean = false;
              break label278;
            }
          }
        } while (!(localBaseCommentData instanceof SubCommentData));
        this.jdField_c_of_type_JavaUtilList.add(0, localBaseCommentData.commentId);
        QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "add new sub comment, now size : ", Integer.valueOf(this.jdField_c_of_type_JavaUtilList.size()) });
        paramString = (CommentData)this.jdField_b_of_type_JavaUtilMap.get(((SubCommentData)localBaseCommentData).parentCommentId);
      } while (paramString == null);
      paramString.subCommentNum += 1;
      if (paramString.subCommentList == null) {
        paramString.subCommentList = new ArrayList();
      }
      if (paramString.subCommentList.size() < 2) {
        paramString.subCommentList.add((SubCommentData)localBaseCommentData);
      }
      a(paramString, 1);
      a(new ojf(this, localBaseCommentData));
      return;
      if ((localBaseCommentData instanceof CommentData))
      {
        a(new ojg(this, paramInt2));
        return;
      }
    } while (!(localBaseCommentData instanceof SubCommentData));
    label582:
    label587:
    a(new ojh(this));
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
      ThreadManager.getUIHandler().post(new ReadInJoyCommentDataManager.28(this, paramBoolean, paramString2, paramString1));
    }
  }
  
  public void a(CommonCommentData paramCommonCommentData)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData = paramCommonCommentData;
  }
  
  public void a(String paramString)
  {
    a(2, paramString, null);
  }
  
  public void a(String paramString, int paramInt)
  {
    paramString = (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      paramString.disLike = paramInt;
    }
    this.jdField_a_of_type_Ojx.a(paramString, 1, paramInt, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
  }
  
  public void a(String paramString1, String paramString2)
  {
    b();
    a(1, paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    BaseCommentData localBaseCommentData = (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(paramString1);
    this.jdField_a_of_type_Ojx.a(localBaseCommentData, this.jdField_a_of_type_JavaLangString, paramString2, paramInt, this.jdField_a_of_type_Int);
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "commentID : ", paramString1, ", reportReason : ", paramString2 });
  }
  
  public void a(oii paramoii)
  {
    if (paramoii == null) {}
    do
    {
      do
      {
        return;
        paramoii = paramoii.a;
      } while (paramoii == null);
      if (this.jdField_b_of_type_JavaUtilMap != null) {
        this.jdField_b_of_type_JavaUtilMap.remove(paramoii);
      }
      paramoii = paramoii.commentId;
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.contains(paramoii)))
      {
        this.jdField_a_of_type_JavaUtilList.remove(paramoii);
        a(new oip(this));
      }
      if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.contains(paramoii)))
      {
        this.jdField_b_of_type_JavaUtilList.remove(paramoii);
        a(new oja(this));
      }
    } while ((this.jdField_d_of_type_JavaUtilList == null) || (!this.jdField_d_of_type_JavaUtilList.contains(paramoii)));
    this.jdField_d_of_type_JavaUtilList.remove(paramoii);
    a(new ojj(this));
  }
  
  public void a(oii paramoii, int paramInt)
  {
    if ((this.jdField_a_of_type_Ojx == null) || (paramoii == null) || (paramoii.a == null)) {
      return;
    }
    BaseCommentData localBaseCommentData = paramoii.a;
    if ((localBaseCommentData instanceof CommentData))
    {
      int i = ((CommentData)localBaseCommentData).subCommentNum;
      a((CommentData)localBaseCommentData, -(i + 1));
      if ((this.jdField_b_of_type_JavaUtilMap != null) && (this.jdField_b_of_type_JavaUtilMap.containsKey(localBaseCommentData.commentId))) {
        this.jdField_b_of_type_JavaUtilMap.remove(localBaseCommentData.commentId);
      }
      if (this.jdField_a_of_type_JavaUtilList != null) {
        this.jdField_a_of_type_JavaUtilList.remove(localBaseCommentData.commentId);
      }
      if (this.jdField_b_of_type_JavaUtilList != null) {
        this.jdField_b_of_type_JavaUtilList.remove(localBaseCommentData.commentId);
      }
      if (this.jdField_d_of_type_JavaUtilList != null) {
        this.jdField_d_of_type_JavaUtilList.remove(localBaseCommentData.commentId);
      }
    }
    if ((localBaseCommentData instanceof SubCommentData))
    {
      CommentData localCommentData = (CommentData)this.jdField_b_of_type_JavaUtilMap.get(((SubCommentData)localBaseCommentData).parentCommentId);
      if (localCommentData != null)
      {
        if (localCommentData.subCommentNum > 0) {
          localCommentData.subCommentNum -= 1;
        }
        List localList = localCommentData.subCommentList;
        if (localList != null)
        {
          Iterator localIterator = localList.iterator();
          while (localIterator.hasNext())
          {
            SubCommentData localSubCommentData = (SubCommentData)localIterator.next();
            if (localSubCommentData.commentId.equalsIgnoreCase(localBaseCommentData.commentId)) {
              localList.remove(localSubCommentData);
            }
          }
        }
      }
      a(localCommentData, -1);
      this.jdField_c_of_type_JavaUtilList.remove(localBaseCommentData.commentId);
    }
    a(new ojp(this, localBaseCommentData.getCommentLevel(), paramoii, paramInt), false);
    this.jdField_a_of_type_Ojx.a(localBaseCommentData, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
  }
  
  public void a(ojr paramojr)
  {
    if ("setCommentAnchor | commentid : " + paramojr != null) {}
    for (String str = paramojr.jdField_a_of_type_JavaLangString;; str = "")
    {
      QLog.d("ReadInJoyCommentDataManager", 1, str);
      this.jdField_a_of_type_Ojr = paramojr;
      return;
    }
  }
  
  /* Error */
  public void a(ojt paramojt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 80	oio:jdField_e_of_type_JavaUtilList	Ljava/util/List;
    //   6: aload_1
    //   7: invokeinterface 429 2 0
    //   12: istore_2
    //   13: iload_2
    //   14: ifeq +6 -> 20
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: aload_0
    //   21: getfield 80	oio:jdField_e_of_type_JavaUtilList	Ljava/util/List;
    //   24: aload_1
    //   25: invokeinterface 356 2 0
    //   30: pop
    //   31: goto -14 -> 17
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	oio
    //   0	39	1	paramojt	ojt
    //   12	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	13	34	finally
    //   20	31	34	finally
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
    QLog.d("ReadInJoyCommentDataManager", 2, "setTitleShowData | showFamilyTitle : " + this.jdField_f_of_type_Boolean);
  }
  
  public void a(boolean paramBoolean, BaseCommentData paramBaseCommentData)
  {
    if (paramBaseCommentData == null) {}
    for (;;)
    {
      return;
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "del comment resp, ret : ", Boolean.valueOf(paramBoolean), ", data : ", paramBaseCommentData });
      if (paramBoolean)
      {
        bcpw.a(BaseApplication.getContext(), 2, ajyc.a(2131712950), 0).a();
        Bundle localBundle = BaseActivity.sTopActivity.getIntent().getBundleExtra("bundle");
        if ((paramBaseCommentData instanceof CommentData)) {}
        for (int i = ((CommentData)paramBaseCommentData).subCommentNum + 1; localBundle != null; i = 1)
        {
          osm.a().a(true, this.jdField_a_of_type_JavaLangString, paramBaseCommentData.commentId, "onCommentDelete", localBundle.getInt("seq"), i);
          return;
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, BaseCommentData paramBaseCommentData, String paramString)
  {
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "onReportCommentResp ret : ", Boolean.valueOf(paramBoolean), ", commentData : ", paramBaseCommentData, ", extraData : ", paramString });
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2)
  {
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "onLikeOrDislikeCommentResult ret : ", Boolean.valueOf(paramBoolean), ", commentID : ", paramString, ", opType ; ", Integer.valueOf(paramInt1), ", opValue : ", Integer.valueOf(paramInt2) });
    a(new ojd(this, paramBoolean, paramString, paramInt1, paramInt2));
    Object localObject = BaseActivity.sTopActivity;
    if (localObject != null)
    {
      localObject = ((Activity)localObject).getIntent().getBundleExtra("bundle");
      if (localObject != null) {
        osm.a().a(paramBoolean, this.jdField_a_of_type_JavaLangString, paramString, String.valueOf(paramInt2), "onCommentLike", ((Bundle)localObject).getInt("seq"));
      }
    }
  }
  
  public boolean a(ojt paramojt)
  {
    try
    {
      boolean bool = this.jdField_e_of_type_JavaUtilList.remove(paramojt);
      return bool;
    }
    finally
    {
      paramojt = finally;
      throw paramojt;
    }
  }
  
  public List<oii> b()
  {
    ArrayList localArrayList1 = new ArrayList();
    if (this.jdField_b_of_type_JavaUtilList.size() > 0)
    {
      ArrayList localArrayList2 = new ArrayList();
      i = 0;
      if (i < this.jdField_b_of_type_JavaUtilList.size())
      {
        CommentData localCommentData = (CommentData)this.jdField_b_of_type_JavaUtilMap.get(this.jdField_b_of_type_JavaUtilList.get(i));
        if (localCommentData == null) {}
        for (;;)
        {
          i += 1;
          break;
          if ((!localCommentData.isFamilyTopEntry()) || ((localCommentData.isFamilyTopEntry()) && (!ogl.a()))) {
            localArrayList2.add(localCommentData);
          }
        }
      }
      if ((localArrayList2.size() > 0) && (this.jdField_f_of_type_Boolean)) {
        localArrayList1.add(new oii(2, null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
      }
      localArrayList1.addAll(a(2, new ArrayList(localArrayList2)));
    }
    if ("getTotalNewCommentList " + localArrayList1 != null) {}
    for (int i = localArrayList1.size();; i = 0)
    {
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { Integer.valueOf(i) });
      return localArrayList1;
    }
  }
  
  public List<oii> b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = (CommentData)this.jdField_b_of_type_JavaUtilMap.get(paramString);
    if (paramString == null) {
      return localArrayList;
    }
    localArrayList.add(new oii(0, paramString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
    localArrayList.add(new oii(3, paramString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
    localArrayList.addAll(b(0, this.jdField_c_of_type_JavaUtilList));
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "get all sub comment list , parentID : ", paramString, ", sub list size : ", Integer.valueOf(this.jdField_c_of_type_JavaUtilList.size()) });
    return localArrayList;
  }
  
  public void b()
  {
    if (this.jdField_c_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        this.jdField_b_of_type_JavaUtilMap.remove(str);
      }
      this.jdField_c_of_type_JavaUtilList.clear();
    }
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void b(int paramInt)
  {
    QLog.d("ReadInJoyCommentDataManager", 1, "loadMoreComment | with feedsType : " + paramInt);
    switch (paramInt)
    {
    case 4: 
    default: 
      return;
    case 3: 
    case 5: 
      d(2);
      return;
    case 2: 
      c(2);
      return;
    }
    e(2);
  }
  
  public void b(int paramInt, ojv paramojv, ojw paramojw, CommentData paramCommentData)
  {
    boolean bool2 = TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString);
    paramCommentData = paramojv;
    if (paramojv == null) {
      paramCommentData = new ojv();
    }
    if (paramojw == null) {
      new ojw();
    }
    boolean bool1;
    if (paramInt == 0)
    {
      this.jdField_d_of_type_Boolean = paramCommentData.jdField_a_of_type_Boolean;
      this.jdField_e_of_type_JavaLangString = paramCommentData.jdField_a_of_type_JavaLangString;
      a(paramCommentData.jdField_a_of_type_JavaUtilList, null);
      bool1 = true;
    }
    while (bool2) {
      if ((bool1) && ((paramCommentData.jdField_a_of_type_JavaUtilList == null) || (paramCommentData.jdField_a_of_type_JavaUtilList.isEmpty())))
      {
        if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
        {
          QLog.d("ReadInJoyCommentDataManager", 1, "switchCommentFeedsType | hot is empty or first change to new : ");
          c(1);
          return;
          bool1 = false;
        }
        else
        {
          a(new oiv(this, a(3)));
        }
      }
      else
      {
        if ((this.jdField_a_of_type_Ojr != null) && (this.jdField_a_of_type_Ojr.jdField_b_of_type_Boolean))
        {
          if (!a(paramCommentData.jdField_a_of_type_JavaUtilList)) {
            a(new oiw(this));
          }
          this.jdField_a_of_type_Ojr.jdField_b_of_type_Boolean = false;
        }
        paramojv = a();
        if (paramCommentData.jdField_a_of_type_JavaUtilList != null)
        {
          paramInt = paramCommentData.jdField_a_of_type_JavaUtilList.size();
          label226:
          paramojw = new StringBuilder().append(", hot size : ");
          if (paramCommentData.jdField_a_of_type_JavaUtilList == null) {
            break label364;
          }
        }
        label364:
        for (int i = paramCommentData.jdField_a_of_type_JavaUtilList.size();; i = 0)
        {
          QLog.d("ReadInJoyCommentDataManager", 2, new Object[] { "onLoadHotCommentFinish, ret : ", Boolean.valueOf(bool1), ", hot size : ", Integer.valueOf(paramInt), i, ", totalCnt : ", Long.valueOf(this.jdField_c_of_type_Long) });
          a(new oix(this, bool1, paramojv));
          if (this.jdField_a_of_type_Ojr == null) {
            break;
          }
          this.jdField_a_of_type_Ojr.a(false);
          return;
          paramInt = 0;
          break label226;
        }
      }
    }
    if (paramCommentData.jdField_a_of_type_JavaUtilList != null) {}
    for (paramojv = a(1, new ArrayList(paramCommentData.jdField_a_of_type_JavaUtilList));; paramojv = new ArrayList())
    {
      bool2 = this.jdField_d_of_type_Boolean;
      QLog.d("ReadInJoyCommentDataManager", 2, new Object[] { "onLoadMoreHotComment, ret : ", Boolean.valueOf(bool1), ", size : ", Integer.valueOf(paramojv.size()), ", hasNext : ", Boolean.valueOf(bool2) });
      a(new oiy(this, bool1, paramojv, bool2));
      return;
    }
  }
  
  public void b(ArticleInfo paramArticleInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_Okc.a(paramArticleInfo);
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (a(1, paramString) == null) {
      return;
    }
    this.jdField_a_of_type_Ojx.a(paramString, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, 1, "", true, this.g, 2);
  }
  
  public void b(String paramString, int paramInt)
  {
    paramString = (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(paramString);
    int j;
    if (paramString != null)
    {
      paramString.like = paramInt;
      j = paramString.likeCnt;
      if (!paramString.isLiked()) {
        break label77;
      }
    }
    label77:
    for (int i = 1;; i = -1)
    {
      paramString.likeCnt = (i + j);
      if (paramString.likeCnt < 0) {
        paramString.likeCnt = 0;
      }
      this.jdField_a_of_type_Ojx.a(paramString, 0, paramInt, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      return;
    }
  }
  
  public List<oii> c()
  {
    ArrayList localArrayList1 = new ArrayList();
    if ((this.jdField_d_of_type_JavaUtilList != null) && (this.jdField_d_of_type_JavaUtilList.size() > 0))
    {
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator = this.jdField_d_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = (CommentData)this.jdField_b_of_type_JavaUtilMap.get(localObject);
        if (localObject != null) {
          localArrayList2.add(localObject);
        }
      }
      if ((localArrayList2.size() > 0) && (this.jdField_f_of_type_Boolean))
      {
        QLog.d("ReadInJoyCommentDataManager", 1, "getTotalFamilyCommentList | showTitle dont showSwitch");
        localArrayList1.add(new oii(2, null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
      }
      localArrayList1.addAll(a(4, new ArrayList(localArrayList2)));
    }
    if ("getTotalFamilyCommentList " + localArrayList1 != null) {}
    for (int i = localArrayList1.size();; i = 0)
    {
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { Integer.valueOf(i) });
      return localArrayList1;
    }
  }
  
  public void c(int paramInt, ojv paramojv, ojw paramojw, CommentData paramCommentData)
  {
    paramCommentData = paramojv;
    if (paramojv == null) {
      paramCommentData = new ojv();
    }
    paramojv = paramojw;
    if (paramojw == null) {
      paramojv = new ojw();
    }
    boolean bool2 = TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString);
    boolean bool1;
    label92:
    long l;
    if (paramInt == 0)
    {
      bool1 = true;
      if (!bool1) {
        break label223;
      }
      this.jdField_f_of_type_JavaLangString = paramCommentData.jdField_a_of_type_JavaLangString;
      this.jdField_e_of_type_Boolean = paramCommentData.jdField_a_of_type_Boolean;
      b(paramCommentData.jdField_a_of_type_JavaUtilList, this.jdField_d_of_type_JavaUtilList);
      QLog.d("ReadInJoyCommentDataManager", 2, "onFetchFamilyCommentListResult succeed ");
      if (!bool2) {
        break label247;
      }
      if (paramojv == null) {
        break label236;
      }
      l = paramojv.jdField_a_of_type_Long;
      label107:
      this.jdField_d_of_type_Long = l;
      paramojv = new StringBuilder();
      if (!paramCommentData.a()) {
        break label242;
      }
    }
    label223:
    label236:
    label242:
    for (paramInt = paramCommentData.jdField_a_of_type_JavaUtilList.size();; paramInt = 0)
    {
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "onLoadFirstFaimilyCommentFinish, ret : ", Boolean.valueOf(bool1), ",  size : ", paramInt + ", mFamilyCommentCnt : ", Long.valueOf(this.jdField_d_of_type_Long) });
      a(new oiz(this, bool1, c()));
      return;
      bool1 = false;
      break;
      QLog.d("ReadInJoyCommentDataManager", 2, "onFetchFamilyCommentListResult failed ");
      break label92;
      l = 0L;
      break label107;
    }
    label247:
    if (paramCommentData != null) {}
    for (paramojv = a(4, new ArrayList(paramCommentData.jdField_a_of_type_JavaUtilList));; paramojv = new ArrayList())
    {
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "onLoadMoreFamilyComment, ret : ", Boolean.valueOf(bool1), ", size : ", Integer.valueOf(paramojv.size()), ", hasNext : ", Boolean.valueOf(this.jdField_e_of_type_Boolean) });
      a(new ojb(this, bool1, paramojv));
      return;
    }
  }
  
  public void c(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    SubCommentData localSubCommentData;
    do
    {
      return;
      localSubCommentData = (SubCommentData)a(2, paramString);
    } while (localSubCommentData == null);
    long l = this.jdField_a_of_type_Ojx.a(paramString, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, 2, localSubCommentData.parentCommentId, this.g, paramInt);
    if (l != -1L) {
      this.jdField_a_of_type_Bfms.b(l, new Pair(paramString, localSubCommentData));
    }
    QLog.d("ReadInJoyCommentDataManager", 1, "create reply comment, seq : " + l + ", data : " + localSubCommentData);
  }
  
  public void d(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    BaseCommentData localBaseCommentData;
    do
    {
      return;
      localBaseCommentData = a(1, paramString);
    } while (localBaseCommentData == null);
    long l = this.jdField_a_of_type_Ojx.a(paramString, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, 1, "", this.g, paramInt);
    if (l != -1L) {
      this.jdField_a_of_type_Bfms.b(l, new Pair(paramString, localBaseCommentData));
    }
    QLog.d("ReadInJoyCommentDataManager", 1, "create main comment, seq : " + l + ", data : " + localBaseCommentData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     oio
 * JD-Core Version:    0.7.0.1
 */