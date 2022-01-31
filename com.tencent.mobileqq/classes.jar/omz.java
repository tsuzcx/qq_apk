import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommonCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager.25;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager.26;
import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.widget.QQToast;
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

public class omz
  implements olp
{
  private static Map<String, omz> jdField_a_of_type_JavaUtilMap = new HashMap();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private bhsk<Pair<String, BaseCommentData>> jdField_a_of_type_Bhsk = new bhsk();
  protected CommonCommentData a;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  protected String a;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private ooc jdField_a_of_type_Ooc;
  private oof jdField_a_of_type_Oof;
  private ooi jdField_a_of_type_Ooi;
  private oon jdField_a_of_type_Oon = new oon();
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
  private List<ooe> jdField_e_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_e_of_type_Boolean;
  private String jdField_f_of_type_JavaLangString = "";
  private boolean jdField_f_of_type_Boolean = true;
  private String g = "";
  
  private omz(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = "";
    paramString = ors.a();
    if (paramString != null)
    {
      this.jdField_a_of_type_Oof = ((oxd)paramString.getManager(163)).a().a();
      this.jdField_a_of_type_Oof.a(this);
    }
    this.jdField_a_of_type_Ooi = new ooi();
    this.jdField_a_of_type_Ooi.a(this);
    a(this.jdField_a_of_type_Oon);
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
  
  private List<omt> a(int paramInt, List<BaseCommentData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      BaseCommentData localBaseCommentData = (BaseCommentData)paramList.next();
      localArrayList.add(new omt(paramInt, a(localBaseCommentData), localBaseCommentData, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
    }
    return localArrayList;
  }
  
  private List<omt> a(boolean paramBoolean, BaseCommentData paramBaseCommentData, List<SubCommentData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean)
    {
      localArrayList.add(new omt(0, paramBaseCommentData, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
      localArrayList.add(new omt(3, paramBaseCommentData, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
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
          localArrayList.add(new omt(i, paramList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
          break;
        }
      }
    }
    return localArrayList;
  }
  
  public static omz a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return null;
    }
    return (omz)jdField_a_of_type_JavaUtilMap.get(paramArticleInfo.innerUniqueID);
  }
  
  public static omz a(ArticleInfo paramArticleInfo, int paramInt)
  {
    if (paramArticleInfo == null) {
      localObject = null;
    }
    omz localomz;
    do
    {
      return localObject;
      localomz = (omz)jdField_a_of_type_JavaUtilMap.get(paramArticleInfo.innerUniqueID);
      localObject = localomz;
    } while (localomz != null);
    Object localObject = new omz(paramArticleInfo.innerUniqueID);
    ((omz)localObject).b(paramArticleInfo);
    ((omz)localObject).jdField_a_of_type_Int = paramInt;
    if (paramInt == 1) {}
    for (((omz)localObject).jdField_a_of_type_JavaLangString = (paramArticleInfo.mArticleID + "");; ((omz)localObject).jdField_a_of_type_JavaLangString = paramArticleInfo.innerUniqueID)
    {
      jdField_a_of_type_JavaUtilMap.put(paramArticleInfo.innerUniqueID, localObject);
      ((omz)localObject).g = paramArticleInfo.innerUniqueID;
      QLog.d("ReadInJoyCommentDataManager", 2, new Object[] { "create commentDataManager, articleInfo : ", paramArticleInfo, ", src : ", Integer.valueOf(paramInt) });
      return localObject;
    }
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_Oof == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      a(new onz(this, paramInt));
      return;
    }
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "fetch sub commentList, id : ", paramString1, ", fetchType : ", Integer.valueOf(paramInt), ", cookie : ", this.jdField_c_of_type_JavaLangString });
    this.jdField_a_of_type_Oof.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, paramString1, paramString2, this.jdField_c_of_type_JavaLangString, 10, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData);
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
      paramArticleInfo = (omz)jdField_a_of_type_JavaUtilMap.remove(paramArticleInfo.innerUniqueID);
    } while (paramArticleInfo == null);
    paramArticleInfo.a();
    QLog.d("ReadInJoyCommentDataManager", 1, "removeCommentDataManager | destroy");
  }
  
  public static void a(ArticleInfo paramArticleInfo, int paramInt)
  {
    if (paramInt == 6)
    {
      paramArticleInfo = (omz)jdField_a_of_type_JavaUtilMap.get(paramArticleInfo.innerUniqueID);
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
  
  private void a(List<ooe> paramList, boolean paramBoolean, oob paramoob)
  {
    int i = 0;
    if (i < paramList.size())
    {
      ooe localooe = (ooe)paramList.get(i);
      if (paramBoolean) {
        ThreadManager.getUIHandler().post(new ReadInJoyCommentDataManager.25(this, paramoob, localooe));
      }
      for (;;)
      {
        i += 1;
        break;
        paramoob.a(localooe);
      }
    }
  }
  
  private void a(oob paramoob)
  {
    a(paramoob, true);
  }
  
  private void a(oob paramoob, boolean paramBoolean)
  {
    if ((!this.jdField_e_of_type_JavaUtilList.isEmpty()) && (paramoob != null)) {
      a(this.jdField_e_of_type_JavaUtilList, paramBoolean, paramoob);
    }
    ArrayList localArrayList = new ArrayList();
    if (oki.a().a() != null) {
      localArrayList.addAll(oki.a().a());
    }
    if ((localArrayList != null) && (paramoob != null)) {
      a(localArrayList, paramBoolean, paramoob);
    }
  }
  
  private boolean a(List<CommentData> paramList)
  {
    if ((paramList == null) || (this.jdField_a_of_type_Ooc == null) || (!this.jdField_a_of_type_Ooc.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Ooc.jdField_a_of_type_JavaLangString == null)) {
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      CommentData localCommentData = (CommentData)paramList.next();
      if ((localCommentData != null) && (this.jdField_a_of_type_Ooc.jdField_a_of_type_JavaLangString.equals(localCommentData.commentId)))
      {
        localCommentData.isAnchor = true;
        return true;
      }
    }
    return false;
  }
  
  private List<omt> b(int paramInt, List<String> paramList)
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
        localArrayList.add(new omt(paramInt, a((BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(str)), (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(str), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
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
    if ((this.jdField_a_of_type_Oof == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      a(new onw(this, paramInt));
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
        if (this.jdField_a_of_type_Ooc != null)
        {
          localObject1 = localObject2;
          if (this.jdField_a_of_type_Ooc.jdField_a_of_type_Boolean) {
            localObject1 = this.jdField_a_of_type_Ooc.jdField_a_of_type_JavaLangString;
          }
        }
      }
      this.jdField_a_of_type_Oof.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, this.jdField_d_of_type_JavaLangString, 10, this.jdField_a_of_type_Int, (String)localObject1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData);
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
    if ((this.jdField_a_of_type_Oof == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      a(new onx(this, paramInt));
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
        if (this.jdField_a_of_type_Ooc != null)
        {
          localObject1 = localObject2;
          if (this.jdField_a_of_type_Ooc.jdField_a_of_type_Boolean) {
            localObject1 = this.jdField_a_of_type_Ooc.jdField_a_of_type_JavaLangString;
          }
        }
      }
      this.jdField_a_of_type_Oof.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, this.jdField_e_of_type_JavaLangString, 10, this.jdField_a_of_type_Int, (String)localObject1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData);
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
    if ((this.jdField_a_of_type_Oof == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      a(new ony(this, paramInt));
      return;
    }
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "fetchFamilyCommentList, fetchType : ", Integer.valueOf(paramInt), ", cookie : ", this.jdField_f_of_type_JavaLangString });
    if (paramInt == 1) {}
    for (String str = "";; str = this.jdField_f_of_type_JavaLangString)
    {
      this.jdField_f_of_type_JavaLangString = str;
      this.jdField_a_of_type_Oof.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, this.jdField_f_of_type_JavaLangString, 10, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData);
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
  
  public BaseCommentData a(int paramInt, String paramString)
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
      ((BaseCommentData)localObject1).uin = ors.a();
      ((BaseCommentData)localObject1).homepage = ors.h(((BaseCommentData)localObject1).uin);
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
        break label344;
      }
      localObject2 = ((ReadInJoyUserInfo)localObject3).nick;
      label133:
      ((BaseCommentData)localObject1).nickName = ((String)localObject2);
      if (localObject3 == null) {
        break label352;
      }
      localObject2 = ((ReadInJoyUserInfo)localObject3).faceUrl;
      label151:
      ((BaseCommentData)localObject1).avatar = ((String)localObject2);
    }
    label387:
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        ((BaseCommentData)localObject1).commentContent = new String(bdfr.decode(paramString.getString("comment"), 0));
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
                break label387;
              }
              paramString = paramString.nick;
              ((SubCommentData)localObject2).repliedUserNickname = paramString;
              ((SubCommentData)localObject2).repliedUserHomePage = ors.h((String)localObject3);
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
        label344:
        localObject2 = ReadInJoyUserInfoModule.a();
        break label133;
        label352:
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
  
  public BaseCommentData a(String paramString)
  {
    return (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(paramString);
  }
  
  public CommonCommentData a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData;
  }
  
  public String a(String paramString)
  {
    paramString = (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(paramString);
    if ((paramString instanceof SubCommentData)) {
      return ((SubCommentData)paramString).parentCommentId;
    }
    if ((paramString instanceof CommentData)) {
      return paramString.commentId;
    }
    return "";
  }
  
  public List<omt> a()
  {
    ArrayList localArrayList1 = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      ArrayList localArrayList2 = new ArrayList();
      i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        CommentData localCommentData = (CommentData)this.jdField_b_of_type_JavaUtilMap.get(this.jdField_a_of_type_JavaUtilList.get(i));
        if ((localCommentData != null) && ((!localCommentData.isFamilyTopEntry()) || ((localCommentData.isFamilyTopEntry()) && (!okv.a())))) {
          localArrayList2.add(localCommentData);
        }
        i += 1;
      }
      if ((localArrayList2.size() > 0) && (this.jdField_f_of_type_Boolean)) {
        localArrayList1.add(new omt(1, null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
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
  
  public List<omt> a(int paramInt)
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
  
  public List<omt> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(paramString);
    if (paramString == null) {
      return localArrayList;
    }
    localArrayList.add(new omt(0, paramString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
    localArrayList.add(new omt(3, paramString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
    return localArrayList;
  }
  
  public ooc a()
  {
    return this.jdField_a_of_type_Ooc;
  }
  
  public oon a()
  {
    return this.jdField_a_of_type_Oon;
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
    if (this.jdField_a_of_type_Bhsk != null) {
      this.jdField_a_of_type_Bhsk.a();
    }
    if (this.jdField_e_of_type_JavaUtilList != null) {
      this.jdField_e_of_type_JavaUtilList.clear();
    }
    if (this.jdField_a_of_type_Oof != null) {
      this.jdField_a_of_type_Oof.a();
    }
    if (this.jdField_a_of_type_Ooi != null) {
      this.jdField_a_of_type_Ooi.a();
    }
  }
  
  public void a(int paramInt)
  {
    a(new onr(this, paramInt));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Oof == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      a(new onv(this, paramInt2));
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
        if (this.jdField_a_of_type_Ooc != null)
        {
          localObject1 = localObject2;
          if (this.jdField_a_of_type_Ooc.jdField_a_of_type_Boolean) {
            localObject1 = this.jdField_a_of_type_Ooc.jdField_a_of_type_JavaLangString;
          }
        }
      }
      if (paramInt1 != 6) {
        break;
      }
      this.jdField_a_of_type_Oof.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, this.jdField_b_of_type_JavaLangString, 10, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData);
      return;
    }
    this.jdField_a_of_type_Oof.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, this.jdField_b_of_type_JavaLangString, 10, this.jdField_a_of_type_Int, (String)localObject1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData);
  }
  
  public void a(int paramInt, String paramString, oog paramoog, ooh paramooh)
  {
    boolean bool2 = false;
    boolean bool3 = TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString);
    oog localoog = paramoog;
    if (paramoog == null) {
      localoog = new oog();
    }
    if (paramooh == null) {
      new ooh();
    }
    boolean bool1;
    if (paramInt == 0)
    {
      this.jdField_b_of_type_Boolean = localoog.jdField_a_of_type_Boolean;
      this.jdField_c_of_type_JavaLangString = localoog.jdField_a_of_type_JavaLangString;
      if (localoog.jdField_b_of_type_JavaUtilList == null) {
        break label335;
      }
      paramoog = localoog.jdField_b_of_type_JavaUtilList.iterator();
      while (paramoog.hasNext())
      {
        paramooh = (SubCommentData)paramoog.next();
        if (paramooh != null)
        {
          if (TextUtils.isEmpty(paramooh.parentCommentId)) {
            paramooh.parentCommentId = paramString;
          }
          this.jdField_b_of_type_JavaUtilMap.put(paramooh.commentId, paramooh);
          this.jdField_c_of_type_JavaUtilList.add(paramooh.commentId);
        }
      }
      paramoog = a(bool3, (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(paramString), localoog.jdField_b_of_type_JavaUtilList);
      bool1 = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        if (localoog.jdField_b_of_type_JavaUtilList == null) {
          break label330;
        }
      }
      label330:
      for (paramInt = localoog.jdField_b_of_type_JavaUtilList.size();; paramInt = 0)
      {
        if (localoog != null) {
          bool2 = localoog.jdField_a_of_type_Boolean;
        }
        QLog.d("ReadInJoyCommentDataManager", 2, new Object[] { "getSubCommentListResp ret : ", Boolean.valueOf(bool1), ", mainCommentID : ", paramString, ", size : ", Integer.valueOf(paramInt), ", hasNext : ", Boolean.valueOf(bool2), ", isFirstFetch : ", Boolean.valueOf(bool3) });
        a(new onn(this, bool3, bool1, paramoog));
        return;
        paramoog = null;
        bool1 = false;
        break;
      }
      label335:
      paramoog = null;
      bool1 = true;
    }
  }
  
  public void a(int paramInt, oog paramoog1, oog paramoog2, ooh paramooh)
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
      localObject = paramoog1;
      if (paramoog1 == null) {
        localObject = new oog();
      }
      paramoog1 = paramoog2;
      if (paramoog2 == null) {
        paramoog1 = new oog();
      }
      paramoog2 = paramooh;
      if (paramooh == null) {
        paramoog2 = new ooh();
      }
      if (bool1)
      {
        this.jdField_c_of_type_Boolean = paramoog1.jdField_a_of_type_Boolean;
        this.jdField_d_of_type_Boolean = ((oog)localObject).jdField_a_of_type_Boolean;
        if (((oog)localObject).jdField_a_of_type_JavaUtilList == null) {
          break label476;
        }
        l = ((oog)localObject).jdField_a_of_type_JavaUtilList.size();
        this.jdField_c_of_type_Long = l;
        this.jdField_d_of_type_JavaLangString = paramoog1.jdField_a_of_type_JavaLangString;
        this.jdField_e_of_type_JavaLangString = ((oog)localObject).jdField_a_of_type_JavaLangString;
        a(((oog)localObject).jdField_a_of_type_JavaUtilList, paramoog1.jdField_a_of_type_JavaUtilList);
      }
      if (!bool2) {
        break label503;
      }
      if (paramoog2.jdField_a_of_type_Long > 0L) {
        this.jdField_b_of_type_Long = paramoog2.jdField_a_of_type_Long;
      }
      this.jdField_a_of_type_Long = paramoog2.jdField_b_of_type_Long;
      if ((this.jdField_a_of_type_Ooc != null) && (this.jdField_a_of_type_Ooc.jdField_b_of_type_Boolean))
      {
        if (!a(((oog)localObject).jdField_a_of_type_JavaUtilList)) {
          a(new onb(this));
        }
        this.jdField_a_of_type_Ooc.jdField_b_of_type_Boolean = false;
      }
      paramInt = 3;
      List localList = a(3);
      if (localList != null)
      {
        paramooh = localList;
        if (!localList.isEmpty()) {}
      }
      else
      {
        paramInt = 2;
        paramooh = a(2);
      }
      if (paramInt != 3) {
        break label482;
      }
      bool2 = this.jdField_d_of_type_Boolean;
      label268:
      if (!((oog)localObject).a()) {
        break label491;
      }
      i = ((oog)localObject).jdField_a_of_type_JavaUtilList.size();
      label288:
      localObject = new StringBuilder().append(", new size : ");
      if (!paramoog1.a()) {
        break label497;
      }
    }
    label476:
    label482:
    label491:
    label497:
    for (int j = paramoog1.jdField_a_of_type_JavaUtilList.size();; j = 0)
    {
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "onLoadFirstCommentFinish, ret : ", Boolean.valueOf(bool1), ", hot size : ", Integer.valueOf(i), j, ", totalCnt : ", this.jdField_b_of_type_Long + " , hideCnt : " + this.jdField_a_of_type_Long });
      a(new onc(this, bool1, paramooh, bool2, paramInt));
      if (this.jdField_a_of_type_Ooc != null) {
        this.jdField_a_of_type_Ooc.a(false);
      }
      this.jdField_a_of_type_Oon.a(paramoog2.jdField_a_of_type_Int);
      this.jdField_a_of_type_Oon.a(paramoog2.jdField_a_of_type_JavaLangString);
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
    label503:
    if (paramoog1 != null) {}
    for (paramoog1 = a(2, new ArrayList(paramoog1.jdField_a_of_type_JavaUtilList));; paramoog1 = new ArrayList())
    {
      bool2 = this.jdField_a_of_type_Boolean;
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "onLoadMoreComment, ret : ", Boolean.valueOf(bool1), ", size : ", Integer.valueOf(paramoog1.size()), ", hasNext : ", Boolean.valueOf(bool2) });
      a(new ond(this, bool1, paramoog1));
      return;
    }
  }
  
  public void a(int paramInt, oog paramoog, ooh paramooh, CommentData paramCommentData)
  {
    boolean bool2 = TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString);
    paramCommentData = paramoog;
    if (paramoog == null) {
      paramCommentData = new oog();
    }
    paramoog = paramooh;
    if (paramooh == null) {
      paramoog = new ooh();
    }
    boolean bool1;
    if (paramInt == 0)
    {
      this.jdField_c_of_type_Boolean = paramCommentData.jdField_a_of_type_Boolean;
      this.jdField_d_of_type_JavaLangString = paramCommentData.jdField_a_of_type_JavaLangString;
      a(null, paramCommentData.jdField_a_of_type_JavaUtilList);
      bool1 = true;
      if (!bool2) {
        break label227;
      }
      if (paramoog.jdField_a_of_type_Long > 0L) {
        this.jdField_b_of_type_Long = paramoog.jdField_a_of_type_Long;
      }
      paramoog = b();
      paramooh = new StringBuilder().append(", new size : ");
      if (paramCommentData.jdField_a_of_type_JavaUtilList == null) {
        break label222;
      }
    }
    label222:
    for (paramInt = paramCommentData.jdField_a_of_type_JavaUtilList.size();; paramInt = 0)
    {
      QLog.d("ReadInJoyCommentDataManager", 2, new Object[] { "onLoadNewCommentFinish, ret : ", Boolean.valueOf(bool1), paramInt, ", totalCnt : ", Long.valueOf(this.jdField_b_of_type_Long) });
      a(new one(this, bool1, paramoog));
      if (this.jdField_a_of_type_Ooc != null) {
        this.jdField_a_of_type_Ooc.a(false);
      }
      return;
      bool1 = false;
      break;
    }
    label227:
    if (paramCommentData.jdField_a_of_type_JavaUtilList != null) {}
    for (paramoog = a(2, new ArrayList(paramCommentData.jdField_a_of_type_JavaUtilList));; paramoog = new ArrayList())
    {
      bool2 = this.jdField_c_of_type_Boolean;
      QLog.d("ReadInJoyCommentDataManager", 2, new Object[] { "onLoadMoreNewComment, ret : ", Boolean.valueOf(bool1), ", size : ", Integer.valueOf(paramoog.size()), ", hasNext : ", Boolean.valueOf(bool2) });
      a(new onf(this, bool1, paramoog, bool2));
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
    Pair localPair = (Pair)this.jdField_a_of_type_Bhsk.a(paramLong);
    if (localPair == null) {
      QLog.d("ReadInJoyCommentDataManager", 1, "onCreateCommentResult | fake comment data not exist, return !");
    }
    BaseCommentData localBaseCommentData;
    do
    {
      return;
      localBaseCommentData = (BaseCommentData)localPair.second;
      this.jdField_a_of_type_Bhsk.b(paramLong);
      if (paramBoolean)
      {
        olt.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, (String)localPair.first);
        a(localBaseCommentData, paramString, paramInt2);
        return;
      }
      if ((localBaseCommentData instanceof CommentData))
      {
        a(new onp(this, paramInt2));
        return;
      }
    } while (!(localBaseCommentData instanceof SubCommentData));
    a(new onq(this));
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
      ThreadManager.getUIHandler().post(new ReadInJoyCommentDataManager.26(this, paramBoolean, paramString2, paramString1));
    }
  }
  
  public void a(BaseCommentData paramBaseCommentData, String paramString, int paramInt)
  {
    paramBaseCommentData.commentId = paramString;
    this.jdField_b_of_type_JavaUtilMap.put(paramBaseCommentData.commentId, paramBaseCommentData);
    label117:
    boolean bool;
    label131:
    int i;
    if ((paramBaseCommentData instanceof CommentData)) {
      if (paramInt == 6)
      {
        if (this.jdField_d_of_type_JavaUtilList == null) {
          this.jdField_d_of_type_JavaUtilList = new ArrayList();
        }
        if (this.jdField_d_of_type_JavaUtilList.size() == 0)
        {
          this.jdField_d_of_type_JavaUtilList.add(paramBaseCommentData.commentId);
          if (this.jdField_b_of_type_JavaUtilList.size() != 0) {
            break label319;
          }
          this.jdField_b_of_type_JavaUtilList.add(paramBaseCommentData.commentId);
          this.jdField_a_of_type_JavaUtilList.add(paramBaseCommentData.commentId);
          if ((paramInt != 3) && (paramInt != 6)) {
            break label417;
          }
          bool = true;
          a((CommentData)paramBaseCommentData, 1);
          if (paramInt != 6) {
            break label423;
          }
          i = 4;
          label149:
          QLog.d("ReadInJoyCommentDataManager", 2, "onCreateCommentResult | createComment feedsType " + i);
          a(new ons(this, new omt(i, 0, paramBaseCommentData, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), bool, paramInt));
        }
      }
    }
    label319:
    do
    {
      do
      {
        return;
        paramString = (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(this.jdField_d_of_type_JavaUtilList.get(0));
        if ((paramString != null) && (paramString.isBanner())) {
          if (this.jdField_d_of_type_JavaUtilList.size() < 2) {
            this.jdField_d_of_type_JavaUtilList.add(paramBaseCommentData.commentId);
          }
        }
        for (;;)
        {
          QLog.d("ReadInJoyCommentDataManager", 2, "onCreateCommentResult | familyCommentFeeds");
          break;
          this.jdField_d_of_type_JavaUtilList.add(1, paramBaseCommentData.commentId);
          continue;
          this.jdField_d_of_type_JavaUtilList.add(0, paramBaseCommentData.commentId);
        }
        paramInt = 2;
        break;
        paramString = (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(this.jdField_b_of_type_JavaUtilList.get(0));
        if ((paramString != null) && (paramString.isBanner()))
        {
          if (this.jdField_b_of_type_JavaUtilList.size() < 2)
          {
            this.jdField_b_of_type_JavaUtilList.add(paramBaseCommentData.commentId);
            break label117;
          }
          this.jdField_b_of_type_JavaUtilList.add(1, paramBaseCommentData.commentId);
          break label117;
        }
        this.jdField_b_of_type_JavaUtilList.add(0, paramBaseCommentData.commentId);
        break label117;
        bool = false;
        break label131;
        i = 2;
        break label149;
      } while (!(paramBaseCommentData instanceof SubCommentData));
      this.jdField_c_of_type_JavaUtilList.add(0, paramBaseCommentData.commentId);
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "add new sub comment, now size : ", Integer.valueOf(this.jdField_c_of_type_JavaUtilList.size()) });
      paramString = (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(((SubCommentData)paramBaseCommentData).parentCommentId);
      paramString = (CommentData)this.jdField_b_of_type_JavaUtilMap.get(((SubCommentData)paramBaseCommentData).parentCommentId);
    } while (paramString == null);
    label417:
    label423:
    paramString.subCommentNum += 1;
    if (paramString.subCommentList == null) {
      paramString.subCommentList = new ArrayList();
    }
    if (paramString.subCommentList.size() < 2) {
      paramString.subCommentList.add((SubCommentData)paramBaseCommentData);
    }
    a(paramString, 1);
    a(new ont(this, paramBaseCommentData));
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
    this.jdField_a_of_type_Ooi.a(paramString, 1, paramInt, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
  }
  
  public void a(String paramString1, String paramString2)
  {
    b();
    a(1, paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    BaseCommentData localBaseCommentData = (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(paramString1);
    this.jdField_a_of_type_Ooi.a(localBaseCommentData, this.jdField_a_of_type_JavaLangString, paramString2, paramInt, this.jdField_a_of_type_Int);
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "commentID : ", paramString1, ", reportReason : ", paramString2 });
  }
  
  public void a(omt paramomt)
  {
    if (paramomt == null) {}
    do
    {
      do
      {
        return;
        paramomt = paramomt.a;
      } while (paramomt == null);
      if (this.jdField_b_of_type_JavaUtilMap != null) {
        this.jdField_b_of_type_JavaUtilMap.remove(paramomt);
      }
      paramomt = paramomt.commentId;
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.contains(paramomt)))
      {
        this.jdField_a_of_type_JavaUtilList.remove(paramomt);
        a(new ona(this));
      }
      if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.contains(paramomt)))
      {
        this.jdField_b_of_type_JavaUtilList.remove(paramomt);
        a(new onl(this));
      }
    } while ((this.jdField_d_of_type_JavaUtilList == null) || (!this.jdField_d_of_type_JavaUtilList.contains(paramomt)));
    this.jdField_d_of_type_JavaUtilList.remove(paramomt);
    a(new onu(this));
  }
  
  public void a(omt paramomt, int paramInt)
  {
    if ((this.jdField_a_of_type_Ooi == null) || (paramomt == null) || (paramomt.a == null)) {
      return;
    }
    BaseCommentData localBaseCommentData = paramomt.a;
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
    a(new ooa(this, localBaseCommentData.getCommentLevel(), paramomt, paramInt), false);
    this.jdField_a_of_type_Ooi.a(localBaseCommentData, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
  }
  
  public void a(ooc paramooc)
  {
    if ("setCommentAnchor | commentid : " + paramooc != null) {}
    for (String str = paramooc.jdField_a_of_type_JavaLangString;; str = "")
    {
      QLog.d("ReadInJoyCommentDataManager", 1, str);
      this.jdField_a_of_type_Ooc = paramooc;
      return;
    }
  }
  
  /* Error */
  public void a(ooe paramooe)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 80	omz:jdField_e_of_type_JavaUtilList	Ljava/util/List;
    //   6: aload_1
    //   7: invokeinterface 282 2 0
    //   12: istore_2
    //   13: iload_2
    //   14: ifeq +6 -> 20
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: aload_0
    //   21: getfield 80	omz:jdField_e_of_type_JavaUtilList	Ljava/util/List;
    //   24: aload_1
    //   25: invokeinterface 181 2 0
    //   30: pop
    //   31: goto -14 -> 17
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	omz
    //   0	39	1	paramooe	ooe
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
        QQToast.a(BaseApplication.getContext(), 2, alud.a(2131713345), 0).a();
        Bundle localBundle = BaseActivity.sTopActivity.getIntent().getBundleExtra("bundle");
        if ((paramBaseCommentData instanceof CommentData)) {}
        for (int i = ((CommentData)paramBaseCommentData).subCommentNum + 1; localBundle != null; i = 1)
        {
          oxb.a().a(true, this.jdField_a_of_type_JavaLangString, paramBaseCommentData.commentId, "onCommentDelete", localBundle.getInt("seq"), i);
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
    a(new ono(this, paramBoolean, paramString, paramInt1, paramInt2));
    Object localObject = BaseActivity.sTopActivity;
    if (localObject != null)
    {
      localObject = ((Activity)localObject).getIntent().getBundleExtra("bundle");
      if (localObject != null) {
        oxb.a().a(paramBoolean, this.jdField_a_of_type_JavaLangString, paramString, String.valueOf(paramInt2), "onCommentLike", ((Bundle)localObject).getInt("seq"));
      }
    }
  }
  
  public boolean a(ooe paramooe)
  {
    try
    {
      boolean bool = this.jdField_e_of_type_JavaUtilList.remove(paramooe);
      return bool;
    }
    finally
    {
      paramooe = finally;
      throw paramooe;
    }
  }
  
  public List<omt> b()
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
          if ((!localCommentData.isFamilyTopEntry()) || ((localCommentData.isFamilyTopEntry()) && (!okv.a()))) {
            localArrayList2.add(localCommentData);
          }
        }
      }
      if ((localArrayList2.size() > 0) && (this.jdField_f_of_type_Boolean)) {
        localArrayList1.add(new omt(2, null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
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
  
  public List<omt> b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = (CommentData)this.jdField_b_of_type_JavaUtilMap.get(paramString);
    if (paramString == null) {
      return localArrayList;
    }
    localArrayList.add(new omt(0, paramString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
    localArrayList.add(new omt(3, paramString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
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
  
  public void b(int paramInt, oog paramoog, ooh paramooh, CommentData paramCommentData)
  {
    boolean bool2 = TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString);
    paramCommentData = paramoog;
    if (paramoog == null) {
      paramCommentData = new oog();
    }
    if (paramooh == null) {
      new ooh();
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
          a(new ong(this, a(3)));
        }
      }
      else
      {
        if ((this.jdField_a_of_type_Ooc != null) && (this.jdField_a_of_type_Ooc.jdField_b_of_type_Boolean))
        {
          if (!a(paramCommentData.jdField_a_of_type_JavaUtilList)) {
            a(new onh(this));
          }
          this.jdField_a_of_type_Ooc.jdField_b_of_type_Boolean = false;
        }
        paramoog = a();
        if (paramCommentData.jdField_a_of_type_JavaUtilList != null)
        {
          paramInt = paramCommentData.jdField_a_of_type_JavaUtilList.size();
          label225:
          paramooh = new StringBuilder().append(", hot size : ");
          if (paramCommentData.jdField_a_of_type_JavaUtilList == null) {
            break label362;
          }
        }
        label362:
        for (int i = paramCommentData.jdField_a_of_type_JavaUtilList.size();; i = 0)
        {
          QLog.d("ReadInJoyCommentDataManager", 2, new Object[] { "onLoadHotCommentFinish, ret : ", Boolean.valueOf(bool1), ", hot size : ", Integer.valueOf(paramInt), i, ", totalCnt : ", Long.valueOf(this.jdField_c_of_type_Long) });
          a(new oni(this, bool1, paramoog));
          if (this.jdField_a_of_type_Ooc == null) {
            break;
          }
          this.jdField_a_of_type_Ooc.a(false);
          return;
          paramInt = 0;
          break label225;
        }
      }
    }
    if (paramCommentData.jdField_a_of_type_JavaUtilList != null) {}
    for (paramoog = a(1, new ArrayList(paramCommentData.jdField_a_of_type_JavaUtilList));; paramoog = new ArrayList())
    {
      bool2 = this.jdField_d_of_type_Boolean;
      QLog.d("ReadInJoyCommentDataManager", 2, new Object[] { "onLoadMoreHotComment, ret : ", Boolean.valueOf(bool1), ", size : ", Integer.valueOf(paramoog.size()), ", hasNext : ", Boolean.valueOf(bool2) });
      a(new onj(this, bool1, paramoog, bool2));
      return;
    }
  }
  
  public void b(ArticleInfo paramArticleInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_Oon.a(paramArticleInfo);
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (a(1, paramString) == null) {
      return;
    }
    this.jdField_a_of_type_Ooi.a(paramString, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, 1, "", true, this.g, 2);
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
      this.jdField_a_of_type_Ooi.a(paramString, 0, paramInt, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      return;
    }
  }
  
  public List<omt> c()
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
        localArrayList1.add(new omt(2, null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
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
  
  public void c(int paramInt, oog paramoog, ooh paramooh, CommentData paramCommentData)
  {
    paramCommentData = paramoog;
    if (paramoog == null) {
      paramCommentData = new oog();
    }
    paramoog = paramooh;
    if (paramooh == null) {
      paramoog = new ooh();
    }
    boolean bool2 = TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString);
    boolean bool1;
    label91:
    long l;
    if (paramInt == 0)
    {
      bool1 = true;
      if (!bool1) {
        break label221;
      }
      this.jdField_f_of_type_JavaLangString = paramCommentData.jdField_a_of_type_JavaLangString;
      this.jdField_e_of_type_Boolean = paramCommentData.jdField_a_of_type_Boolean;
      b(paramCommentData.jdField_a_of_type_JavaUtilList, this.jdField_d_of_type_JavaUtilList);
      QLog.d("ReadInJoyCommentDataManager", 2, "onFetchFamilyCommentListResult succeed ");
      if (!bool2) {
        break label244;
      }
      if (paramoog == null) {
        break label233;
      }
      l = paramoog.jdField_a_of_type_Long;
      label106:
      this.jdField_d_of_type_Long = l;
      paramoog = new StringBuilder();
      if (!paramCommentData.a()) {
        break label239;
      }
    }
    label221:
    label233:
    label239:
    for (paramInt = paramCommentData.jdField_a_of_type_JavaUtilList.size();; paramInt = 0)
    {
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "onLoadFirstFaimilyCommentFinish, ret : ", Boolean.valueOf(bool1), ",  size : ", paramInt + ", mFamilyCommentCnt : ", Long.valueOf(this.jdField_d_of_type_Long) });
      a(new onk(this, bool1, c()));
      return;
      bool1 = false;
      break;
      QLog.d("ReadInJoyCommentDataManager", 2, "onFetchFamilyCommentListResult failed ");
      break label91;
      l = 0L;
      break label106;
    }
    label244:
    if (paramCommentData != null) {}
    for (paramoog = a(4, new ArrayList(paramCommentData.jdField_a_of_type_JavaUtilList));; paramoog = new ArrayList())
    {
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "onLoadMoreFamilyComment, ret : ", Boolean.valueOf(bool1), ", size : ", Integer.valueOf(paramoog.size()), ", hasNext : ", Boolean.valueOf(this.jdField_e_of_type_Boolean) });
      a(new onm(this, bool1, paramoog));
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
    long l = this.jdField_a_of_type_Ooi.a(paramString, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, 2, localSubCommentData.parentCommentId, this.g, paramInt);
    if (l != -1L) {
      this.jdField_a_of_type_Bhsk.b(l, new Pair(paramString, localSubCommentData));
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
    long l = this.jdField_a_of_type_Ooi.a(paramString, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, 1, "", this.g, paramInt);
    if (l != -1L) {
      this.jdField_a_of_type_Bhsk.b(l, new Pair(paramString, localBaseCommentData));
    }
    QLog.d("ReadInJoyCommentDataManager", 1, "create main comment, seq : " + l + ", data : " + localBaseCommentData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     omz
 * JD-Core Version:    0.7.0.1
 */