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

public class nxd
  implements nvt
{
  private static Map<String, nxd> jdField_a_of_type_JavaUtilMap = new HashMap();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private beey<Pair<String, BaseCommentData>> jdField_a_of_type_Beey = new beey();
  protected CommonCommentData a;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  protected String a;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private nyg jdField_a_of_type_Nyg;
  private nyj jdField_a_of_type_Nyj;
  private nym jdField_a_of_type_Nym;
  private nyr jdField_a_of_type_Nyr = new nyr();
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
  private List<nyi> jdField_e_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_e_of_type_Boolean;
  private String jdField_f_of_type_JavaLangString = "";
  private boolean jdField_f_of_type_Boolean = true;
  private String g = "";
  
  private nxd(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = "";
    paramString = obz.a();
    if (paramString != null)
    {
      this.jdField_a_of_type_Nyj = ((ohd)paramString.getManager(163)).a().a();
      this.jdField_a_of_type_Nyj.a(this);
    }
    this.jdField_a_of_type_Nym = new nym();
    this.jdField_a_of_type_Nym.a(this);
    a(this.jdField_a_of_type_Nyr);
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
      ((BaseCommentData)localObject1).uin = obz.a();
      ((BaseCommentData)localObject1).homepage = obz.h(((BaseCommentData)localObject1).uin);
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
        ((BaseCommentData)localObject1).commentContent = new String(baaw.decode(paramString.getString("comment"), 0));
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
              ((SubCommentData)localObject2).repliedUserHomePage = obz.h((String)localObject3);
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
  
  private List<nwx> a(int paramInt, List<BaseCommentData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      BaseCommentData localBaseCommentData = (BaseCommentData)paramList.next();
      localArrayList.add(new nwx(paramInt, a(localBaseCommentData), localBaseCommentData, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
    }
    return localArrayList;
  }
  
  private List<nwx> a(boolean paramBoolean, BaseCommentData paramBaseCommentData, List<SubCommentData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean)
    {
      localArrayList.add(new nwx(0, paramBaseCommentData, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
      localArrayList.add(new nwx(3, paramBaseCommentData, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
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
          localArrayList.add(new nwx(i, paramList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
          break;
        }
      }
    }
    return localArrayList;
  }
  
  public static nxd a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return null;
    }
    return (nxd)jdField_a_of_type_JavaUtilMap.get(paramArticleInfo.innerUniqueID);
  }
  
  public static nxd a(ArticleInfo paramArticleInfo, int paramInt)
  {
    if (paramArticleInfo == null) {
      localObject = null;
    }
    nxd localnxd;
    do
    {
      return localObject;
      localnxd = (nxd)jdField_a_of_type_JavaUtilMap.get(paramArticleInfo.innerUniqueID);
      localObject = localnxd;
    } while (localnxd != null);
    Object localObject = new nxd(paramArticleInfo.innerUniqueID);
    ((nxd)localObject).b(paramArticleInfo);
    ((nxd)localObject).jdField_a_of_type_Int = paramInt;
    if (paramInt == 1) {}
    for (((nxd)localObject).jdField_a_of_type_JavaLangString = (paramArticleInfo.mArticleID + "");; ((nxd)localObject).jdField_a_of_type_JavaLangString = paramArticleInfo.innerUniqueID)
    {
      jdField_a_of_type_JavaUtilMap.put(paramArticleInfo.innerUniqueID, localObject);
      ((nxd)localObject).g = paramArticleInfo.innerUniqueID;
      QLog.d("ReadInJoyCommentDataManager", 2, new Object[] { "create commentDataManager, articleInfo : ", paramArticleInfo, ", src : ", Integer.valueOf(paramInt) });
      return localObject;
    }
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_Nyj == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      a(new nyd(this, paramInt));
      return;
    }
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "fetch sub commentList, id : ", paramString1, ", fetchType : ", Integer.valueOf(paramInt), ", cookie : ", this.jdField_c_of_type_JavaLangString });
    this.jdField_a_of_type_Nyj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, paramString1, paramString2, this.jdField_c_of_type_JavaLangString, 10, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData);
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
      paramArticleInfo = (nxd)jdField_a_of_type_JavaUtilMap.remove(paramArticleInfo.innerUniqueID);
    } while (paramArticleInfo == null);
    paramArticleInfo.a();
    QLog.d("ReadInJoyCommentDataManager", 1, "removeCommentDataManager | destroy");
  }
  
  public static void a(ArticleInfo paramArticleInfo, int paramInt)
  {
    if (paramInt == 6)
    {
      paramArticleInfo = (nxd)jdField_a_of_type_JavaUtilMap.get(paramArticleInfo.innerUniqueID);
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
  
  private void a(List<nyi> paramList, boolean paramBoolean, nyf paramnyf)
  {
    int i = 0;
    if (i < paramList.size())
    {
      nyi localnyi = (nyi)paramList.get(i);
      if (paramBoolean) {
        ThreadManager.getUIHandler().post(new ReadInJoyCommentDataManager.27(this, paramnyf, localnyi));
      }
      for (;;)
      {
        i += 1;
        break;
        paramnyf.a(localnyi);
      }
    }
  }
  
  private void a(nyf paramnyf)
  {
    a(paramnyf, true);
  }
  
  private void a(nyf paramnyf, boolean paramBoolean)
  {
    if ((!this.jdField_e_of_type_JavaUtilList.isEmpty()) && (paramnyf != null)) {
      a(this.jdField_e_of_type_JavaUtilList, paramBoolean, paramnyf);
    }
    ArrayList localArrayList = new ArrayList();
    if (nuo.a().a() != null) {
      localArrayList.addAll(nuo.a().a());
    }
    if ((localArrayList != null) && (paramnyf != null)) {
      a(localArrayList, paramBoolean, paramnyf);
    }
  }
  
  private boolean a(List<CommentData> paramList)
  {
    if ((paramList == null) || (this.jdField_a_of_type_Nyg == null) || (!this.jdField_a_of_type_Nyg.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Nyg.jdField_a_of_type_JavaLangString == null)) {
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      CommentData localCommentData = (CommentData)paramList.next();
      if ((localCommentData != null) && (this.jdField_a_of_type_Nyg.jdField_a_of_type_JavaLangString.equals(localCommentData.commentId)))
      {
        localCommentData.isAnchor = true;
        return true;
      }
    }
    return false;
  }
  
  private List<nwx> b(int paramInt, List<String> paramList)
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
        localArrayList.add(new nwx(paramInt, a((BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(str)), (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(str), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
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
    if ((this.jdField_a_of_type_Nyj == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      a(new nya(this, paramInt));
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
        if (this.jdField_a_of_type_Nyg != null)
        {
          localObject1 = localObject2;
          if (this.jdField_a_of_type_Nyg.jdField_a_of_type_Boolean) {
            localObject1 = this.jdField_a_of_type_Nyg.jdField_a_of_type_JavaLangString;
          }
        }
      }
      this.jdField_a_of_type_Nyj.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, this.jdField_d_of_type_JavaLangString, 10, this.jdField_a_of_type_Int, (String)localObject1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData);
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
    if ((this.jdField_a_of_type_Nyj == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      a(new nyb(this, paramInt));
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
        if (this.jdField_a_of_type_Nyg != null)
        {
          localObject1 = localObject2;
          if (this.jdField_a_of_type_Nyg.jdField_a_of_type_Boolean) {
            localObject1 = this.jdField_a_of_type_Nyg.jdField_a_of_type_JavaLangString;
          }
        }
      }
      this.jdField_a_of_type_Nyj.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, this.jdField_e_of_type_JavaLangString, 10, this.jdField_a_of_type_Int, (String)localObject1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData);
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
    if ((this.jdField_a_of_type_Nyj == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      a(new nyc(this, paramInt));
      return;
    }
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "fetchFamilyCommentList, fetchType : ", Integer.valueOf(paramInt), ", cookie : ", this.jdField_f_of_type_JavaLangString });
    if (paramInt == 1) {}
    for (String str = "";; str = this.jdField_f_of_type_JavaLangString)
    {
      this.jdField_f_of_type_JavaLangString = str;
      this.jdField_a_of_type_Nyj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, this.jdField_f_of_type_JavaLangString, 10, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData);
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
  
  public List<nwx> a()
  {
    ArrayList localArrayList1 = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      ArrayList localArrayList2 = new ArrayList();
      i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        CommentData localCommentData = (CommentData)this.jdField_b_of_type_JavaUtilMap.get(this.jdField_a_of_type_JavaUtilList.get(i));
        if ((localCommentData != null) && ((!localCommentData.isFamilyTopEntry()) || ((localCommentData.isFamilyTopEntry()) && (!nva.a())))) {
          localArrayList2.add(localCommentData);
        }
        i += 1;
      }
      if ((localArrayList2.size() > 0) && (this.jdField_f_of_type_Boolean)) {
        localArrayList1.add(new nwx(1, null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
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
  
  public List<nwx> a(int paramInt)
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
  
  public List<nwx> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(paramString);
    if (paramString == null) {
      return localArrayList;
    }
    localArrayList.add(new nwx(0, paramString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
    localArrayList.add(new nwx(3, paramString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
    return localArrayList;
  }
  
  public nyg a()
  {
    return this.jdField_a_of_type_Nyg;
  }
  
  public nyr a()
  {
    return this.jdField_a_of_type_Nyr;
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
    if (this.jdField_a_of_type_Beey != null) {
      this.jdField_a_of_type_Beey.a();
    }
    if (this.jdField_e_of_type_JavaUtilList != null) {
      this.jdField_e_of_type_JavaUtilList.clear();
    }
    if (this.jdField_a_of_type_Nyj != null) {
      this.jdField_a_of_type_Nyj.a();
    }
  }
  
  public void a(int paramInt)
  {
    a(new nxx(this, paramInt));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Nyj == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      a(new nxz(this, paramInt2));
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
        if (this.jdField_a_of_type_Nyg != null)
        {
          localObject1 = localObject2;
          if (this.jdField_a_of_type_Nyg.jdField_a_of_type_Boolean) {
            localObject1 = this.jdField_a_of_type_Nyg.jdField_a_of_type_JavaLangString;
          }
        }
      }
      if (paramInt1 != 6) {
        break;
      }
      this.jdField_a_of_type_Nyj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, this.jdField_b_of_type_JavaLangString, 10, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData);
      return;
    }
    this.jdField_a_of_type_Nyj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, this.jdField_b_of_type_JavaLangString, 10, this.jdField_a_of_type_Int, (String)localObject1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData);
  }
  
  public void a(int paramInt, String paramString, nyk paramnyk, nyl paramnyl)
  {
    boolean bool2 = false;
    boolean bool3 = TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString);
    nyk localnyk = paramnyk;
    if (paramnyk == null) {
      localnyk = new nyk();
    }
    if (paramnyl == null) {
      new nyl();
    }
    boolean bool1;
    if (paramInt == 0)
    {
      this.jdField_b_of_type_Boolean = localnyk.jdField_a_of_type_Boolean;
      this.jdField_c_of_type_JavaLangString = localnyk.jdField_a_of_type_JavaLangString;
      if (localnyk.jdField_b_of_type_JavaUtilList == null) {
        break label336;
      }
      paramnyk = localnyk.jdField_b_of_type_JavaUtilList.iterator();
      while (paramnyk.hasNext())
      {
        paramnyl = (SubCommentData)paramnyk.next();
        if (paramnyl != null)
        {
          if (TextUtils.isEmpty(paramnyl.parentCommentId)) {
            paramnyl.parentCommentId = paramString;
          }
          this.jdField_b_of_type_JavaUtilMap.put(paramnyl.commentId, paramnyl);
          this.jdField_c_of_type_JavaUtilList.add(paramnyl.commentId);
        }
      }
      paramnyk = a(bool3, (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(paramString), localnyk.jdField_b_of_type_JavaUtilList);
      bool1 = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        if (localnyk.jdField_b_of_type_JavaUtilList == null) {
          break label331;
        }
      }
      label331:
      for (paramInt = localnyk.jdField_b_of_type_JavaUtilList.size();; paramInt = 0)
      {
        if (localnyk != null) {
          bool2 = localnyk.jdField_a_of_type_Boolean;
        }
        QLog.d("ReadInJoyCommentDataManager", 2, new Object[] { "getSubCommentListResp ret : ", Boolean.valueOf(bool1), ", mainCommentID : ", paramString, ", size : ", Integer.valueOf(paramInt), ", hasNext : ", Boolean.valueOf(bool2), ", isFirstFetch : ", Boolean.valueOf(bool3) });
        a(new nxr(this, bool3, bool1, paramnyk));
        return;
        paramnyk = null;
        bool1 = false;
        break;
      }
      label336:
      paramnyk = null;
      bool1 = true;
    }
  }
  
  public void a(int paramInt, nyk paramnyk1, nyk paramnyk2, nyl paramnyl)
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
      localObject = paramnyk1;
      if (paramnyk1 == null) {
        localObject = new nyk();
      }
      paramnyk1 = paramnyk2;
      if (paramnyk2 == null) {
        paramnyk1 = new nyk();
      }
      paramnyk2 = paramnyl;
      if (paramnyl == null) {
        paramnyk2 = new nyl();
      }
      if (bool1)
      {
        this.jdField_c_of_type_Boolean = paramnyk1.jdField_a_of_type_Boolean;
        this.jdField_d_of_type_Boolean = ((nyk)localObject).jdField_a_of_type_Boolean;
        if (((nyk)localObject).jdField_a_of_type_JavaUtilList == null) {
          break label477;
        }
        l = ((nyk)localObject).jdField_a_of_type_JavaUtilList.size();
        this.jdField_c_of_type_Long = l;
        this.jdField_d_of_type_JavaLangString = paramnyk1.jdField_a_of_type_JavaLangString;
        this.jdField_e_of_type_JavaLangString = ((nyk)localObject).jdField_a_of_type_JavaLangString;
        a(((nyk)localObject).jdField_a_of_type_JavaUtilList, paramnyk1.jdField_a_of_type_JavaUtilList);
      }
      if (!bool2) {
        break label504;
      }
      if (paramnyk2.jdField_a_of_type_Long > 0L) {
        this.jdField_b_of_type_Long = paramnyk2.jdField_a_of_type_Long;
      }
      this.jdField_a_of_type_Long = paramnyk2.jdField_b_of_type_Long;
      if ((this.jdField_a_of_type_Nyg != null) && (this.jdField_a_of_type_Nyg.jdField_b_of_type_Boolean))
      {
        if (!a(((nyk)localObject).jdField_a_of_type_JavaUtilList)) {
          a(new nxf(this));
        }
        this.jdField_a_of_type_Nyg.jdField_b_of_type_Boolean = false;
      }
      paramInt = 3;
      List localList = a(3);
      if (localList != null)
      {
        paramnyl = localList;
        if (!localList.isEmpty()) {}
      }
      else
      {
        paramInt = 2;
        paramnyl = a(2);
      }
      if (paramInt != 3) {
        break label483;
      }
      bool2 = this.jdField_d_of_type_Boolean;
      label268:
      if (!((nyk)localObject).a()) {
        break label492;
      }
      i = ((nyk)localObject).jdField_a_of_type_JavaUtilList.size();
      label288:
      localObject = new StringBuilder().append(", new size : ");
      if (!paramnyk1.a()) {
        break label498;
      }
    }
    label477:
    label483:
    label492:
    label498:
    for (int j = paramnyk1.jdField_a_of_type_JavaUtilList.size();; j = 0)
    {
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "onLoadFirstCommentFinish, ret : ", Boolean.valueOf(bool1), ", hot size : ", Integer.valueOf(i), j, ", totalCnt : ", this.jdField_b_of_type_Long + " , hideCnt : " + this.jdField_a_of_type_Long });
      a(new nxg(this, bool1, paramnyl, bool2, paramInt));
      if (this.jdField_a_of_type_Nyg != null) {
        this.jdField_a_of_type_Nyg.a(false);
      }
      this.jdField_a_of_type_Nyr.a(paramnyk2.jdField_a_of_type_Int);
      this.jdField_a_of_type_Nyr.a(paramnyk2.jdField_a_of_type_JavaLangString);
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
    if (paramnyk1 != null) {}
    for (paramnyk1 = a(2, new ArrayList(paramnyk1.jdField_a_of_type_JavaUtilList));; paramnyk1 = new ArrayList())
    {
      bool2 = this.jdField_a_of_type_Boolean;
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "onLoadMoreComment, ret : ", Boolean.valueOf(bool1), ", size : ", Integer.valueOf(paramnyk1.size()), ", hasNext : ", Boolean.valueOf(bool2) });
      a(new nxh(this, bool1, paramnyk1));
      return;
    }
  }
  
  public void a(int paramInt, nyk paramnyk, nyl paramnyl, CommentData paramCommentData)
  {
    boolean bool2 = TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString);
    paramCommentData = paramnyk;
    if (paramnyk == null) {
      paramCommentData = new nyk();
    }
    paramnyk = paramnyl;
    if (paramnyl == null) {
      paramnyk = new nyl();
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
      if (paramnyk.jdField_a_of_type_Long > 0L) {
        this.jdField_b_of_type_Long = paramnyk.jdField_a_of_type_Long;
      }
      paramnyk = b();
      paramnyl = new StringBuilder().append(", new size : ");
      if (paramCommentData.jdField_a_of_type_JavaUtilList == null) {
        break label223;
      }
    }
    label223:
    for (paramInt = paramCommentData.jdField_a_of_type_JavaUtilList.size();; paramInt = 0)
    {
      QLog.d("ReadInJoyCommentDataManager", 2, new Object[] { "onLoadNewCommentFinish, ret : ", Boolean.valueOf(bool1), paramInt, ", totalCnt : ", Long.valueOf(this.jdField_b_of_type_Long) });
      a(new nxi(this, bool1, paramnyk));
      if (this.jdField_a_of_type_Nyg != null) {
        this.jdField_a_of_type_Nyg.a(false);
      }
      return;
      bool1 = false;
      break;
    }
    label228:
    if (paramCommentData.jdField_a_of_type_JavaUtilList != null) {}
    for (paramnyk = a(2, new ArrayList(paramCommentData.jdField_a_of_type_JavaUtilList));; paramnyk = new ArrayList())
    {
      bool2 = this.jdField_c_of_type_Boolean;
      QLog.d("ReadInJoyCommentDataManager", 2, new Object[] { "onLoadMoreNewComment, ret : ", Boolean.valueOf(bool1), ", size : ", Integer.valueOf(paramnyk.size()), ", hasNext : ", Boolean.valueOf(bool2) });
      a(new nxj(this, bool1, paramnyk, bool2));
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
    Pair localPair = (Pair)this.jdField_a_of_type_Beey.a(paramLong);
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
          this.jdField_a_of_type_Beey.b(paramLong);
          if (!paramBoolean) {
            break;
          }
          nvx.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, (String)localPair.first);
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
              a(new nxt(this, new nwx(paramInt1, 0, localBaseCommentData, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), paramBoolean, paramInt2));
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
      a(new nxu(this, localBaseCommentData));
      return;
      if ((localBaseCommentData instanceof CommentData))
      {
        a(new nxv(this, paramInt2));
        return;
      }
    } while (!(localBaseCommentData instanceof SubCommentData));
    label582:
    label587:
    a(new nxw(this));
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
    this.jdField_a_of_type_Nym.a(paramString, 1, paramInt, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
  }
  
  public void a(String paramString1, String paramString2)
  {
    b();
    a(1, paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    BaseCommentData localBaseCommentData = (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(paramString1);
    this.jdField_a_of_type_Nym.a(localBaseCommentData, this.jdField_a_of_type_JavaLangString, paramString2, paramInt, this.jdField_a_of_type_Int);
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "commentID : ", paramString1, ", reportReason : ", paramString2 });
  }
  
  public void a(nwx paramnwx)
  {
    if (paramnwx == null) {}
    do
    {
      do
      {
        return;
        paramnwx = paramnwx.a;
      } while (paramnwx == null);
      if (this.jdField_b_of_type_JavaUtilMap != null) {
        this.jdField_b_of_type_JavaUtilMap.remove(paramnwx);
      }
      paramnwx = paramnwx.commentId;
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.contains(paramnwx)))
      {
        this.jdField_a_of_type_JavaUtilList.remove(paramnwx);
        a(new nxe(this));
      }
      if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.contains(paramnwx)))
      {
        this.jdField_b_of_type_JavaUtilList.remove(paramnwx);
        a(new nxp(this));
      }
    } while ((this.jdField_d_of_type_JavaUtilList == null) || (!this.jdField_d_of_type_JavaUtilList.contains(paramnwx)));
    this.jdField_d_of_type_JavaUtilList.remove(paramnwx);
    a(new nxy(this));
  }
  
  public void a(nwx paramnwx, int paramInt)
  {
    if ((this.jdField_a_of_type_Nym == null) || (paramnwx == null) || (paramnwx.a == null)) {
      return;
    }
    BaseCommentData localBaseCommentData = paramnwx.a;
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
    a(new nye(this, localBaseCommentData.getCommentLevel(), paramnwx, paramInt), false);
    this.jdField_a_of_type_Nym.a(localBaseCommentData, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
  }
  
  public void a(nyg paramnyg)
  {
    if ("setCommentAnchor | commentid : " + paramnyg != null) {}
    for (String str = paramnyg.jdField_a_of_type_JavaLangString;; str = "")
    {
      QLog.d("ReadInJoyCommentDataManager", 1, str);
      this.jdField_a_of_type_Nyg = paramnyg;
      return;
    }
  }
  
  /* Error */
  public void a(nyi paramnyi)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 80	nxd:jdField_e_of_type_JavaUtilList	Ljava/util/List;
    //   6: aload_1
    //   7: invokeinterface 429 2 0
    //   12: istore_2
    //   13: iload_2
    //   14: ifeq +6 -> 20
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: aload_0
    //   21: getfield 80	nxd:jdField_e_of_type_JavaUtilList	Ljava/util/List;
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
    //   0	39	0	this	nxd
    //   0	39	1	paramnyi	nyi
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
        bbmy.a(BaseApplication.getContext(), 2, ajjy.a(2131647162), 0).a();
        Bundle localBundle = BaseActivity.sTopActivity.getIntent().getBundleExtra("bundle");
        if ((paramBaseCommentData instanceof CommentData)) {}
        for (int i = ((CommentData)paramBaseCommentData).subCommentNum + 1; localBundle != null; i = 1)
        {
          ohb.a().a(true, this.jdField_a_of_type_JavaLangString, paramBaseCommentData.commentId, "onCommentDelete", localBundle.getInt("seq"), i);
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
    a(new nxs(this, paramBoolean, paramString, paramInt1, paramInt2));
    Object localObject = BaseActivity.sTopActivity;
    if (localObject != null)
    {
      localObject = ((Activity)localObject).getIntent().getBundleExtra("bundle");
      if (localObject != null) {
        ohb.a().a(paramBoolean, this.jdField_a_of_type_JavaLangString, paramString, String.valueOf(paramInt2), "onCommentLike", ((Bundle)localObject).getInt("seq"));
      }
    }
  }
  
  public boolean a(nyi paramnyi)
  {
    try
    {
      boolean bool = this.jdField_e_of_type_JavaUtilList.remove(paramnyi);
      return bool;
    }
    finally
    {
      paramnyi = finally;
      throw paramnyi;
    }
  }
  
  public List<nwx> b()
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
          if ((!localCommentData.isFamilyTopEntry()) || ((localCommentData.isFamilyTopEntry()) && (!nva.a()))) {
            localArrayList2.add(localCommentData);
          }
        }
      }
      if ((localArrayList2.size() > 0) && (this.jdField_f_of_type_Boolean)) {
        localArrayList1.add(new nwx(2, null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
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
  
  public List<nwx> b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = (CommentData)this.jdField_b_of_type_JavaUtilMap.get(paramString);
    if (paramString == null) {
      return localArrayList;
    }
    localArrayList.add(new nwx(0, paramString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
    localArrayList.add(new nwx(3, paramString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
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
  
  public void b(int paramInt, nyk paramnyk, nyl paramnyl, CommentData paramCommentData)
  {
    boolean bool2 = TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString);
    paramCommentData = paramnyk;
    if (paramnyk == null) {
      paramCommentData = new nyk();
    }
    if (paramnyl == null) {
      new nyl();
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
          a(new nxk(this, a(3)));
        }
      }
      else
      {
        if ((this.jdField_a_of_type_Nyg != null) && (this.jdField_a_of_type_Nyg.jdField_b_of_type_Boolean))
        {
          if (!a(paramCommentData.jdField_a_of_type_JavaUtilList)) {
            a(new nxl(this));
          }
          this.jdField_a_of_type_Nyg.jdField_b_of_type_Boolean = false;
        }
        paramnyk = a();
        if (paramCommentData.jdField_a_of_type_JavaUtilList != null)
        {
          paramInt = paramCommentData.jdField_a_of_type_JavaUtilList.size();
          label226:
          paramnyl = new StringBuilder().append(", hot size : ");
          if (paramCommentData.jdField_a_of_type_JavaUtilList == null) {
            break label364;
          }
        }
        label364:
        for (int i = paramCommentData.jdField_a_of_type_JavaUtilList.size();; i = 0)
        {
          QLog.d("ReadInJoyCommentDataManager", 2, new Object[] { "onLoadHotCommentFinish, ret : ", Boolean.valueOf(bool1), ", hot size : ", Integer.valueOf(paramInt), i, ", totalCnt : ", Long.valueOf(this.jdField_c_of_type_Long) });
          a(new nxm(this, bool1, paramnyk));
          if (this.jdField_a_of_type_Nyg == null) {
            break;
          }
          this.jdField_a_of_type_Nyg.a(false);
          return;
          paramInt = 0;
          break label226;
        }
      }
    }
    if (paramCommentData.jdField_a_of_type_JavaUtilList != null) {}
    for (paramnyk = a(1, new ArrayList(paramCommentData.jdField_a_of_type_JavaUtilList));; paramnyk = new ArrayList())
    {
      bool2 = this.jdField_d_of_type_Boolean;
      QLog.d("ReadInJoyCommentDataManager", 2, new Object[] { "onLoadMoreHotComment, ret : ", Boolean.valueOf(bool1), ", size : ", Integer.valueOf(paramnyk.size()), ", hasNext : ", Boolean.valueOf(bool2) });
      a(new nxn(this, bool1, paramnyk, bool2));
      return;
    }
  }
  
  public void b(ArticleInfo paramArticleInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_Nyr.a(paramArticleInfo);
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (a(1, paramString) == null) {
      return;
    }
    this.jdField_a_of_type_Nym.a(paramString, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, 1, "", true, this.g, 2);
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
      this.jdField_a_of_type_Nym.a(paramString, 0, paramInt, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      return;
    }
  }
  
  public List<nwx> c()
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
        localArrayList1.add(new nwx(2, null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
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
  
  public void c(int paramInt, nyk paramnyk, nyl paramnyl, CommentData paramCommentData)
  {
    paramCommentData = paramnyk;
    if (paramnyk == null) {
      paramCommentData = new nyk();
    }
    paramnyk = paramnyl;
    if (paramnyl == null) {
      paramnyk = new nyl();
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
      if (paramnyk == null) {
        break label236;
      }
      l = paramnyk.jdField_a_of_type_Long;
      label107:
      this.jdField_d_of_type_Long = l;
      paramnyk = new StringBuilder();
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
      a(new nxo(this, bool1, c()));
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
    for (paramnyk = a(4, new ArrayList(paramCommentData.jdField_a_of_type_JavaUtilList));; paramnyk = new ArrayList())
    {
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "onLoadMoreFamilyComment, ret : ", Boolean.valueOf(bool1), ", size : ", Integer.valueOf(paramnyk.size()), ", hasNext : ", Boolean.valueOf(this.jdField_e_of_type_Boolean) });
      a(new nxq(this, bool1, paramnyk));
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
    long l = this.jdField_a_of_type_Nym.a(paramString, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, 2, localSubCommentData.parentCommentId, this.g, paramInt);
    if (l != -1L) {
      this.jdField_a_of_type_Beey.b(l, new Pair(paramString, localSubCommentData));
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
    long l = this.jdField_a_of_type_Nym.a(paramString, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, 1, "", this.g, paramInt);
    if (l != -1L) {
      this.jdField_a_of_type_Beey.b(l, new Pair(paramString, localBaseCommentData));
    }
    QLog.d("ReadInJoyCommentDataManager", 1, "create main comment, seq : " + l + ", data : " + localBaseCommentData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     nxd
 * JD-Core Version:    0.7.0.1
 */