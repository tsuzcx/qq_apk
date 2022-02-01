import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommonCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager.11;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager.34;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager.35;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager.5;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager.6;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager.7;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager.9;
import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.FirstCommentCreateData;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.FirstCommentSinkData;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.FirstCommentStickyData;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.SubCommentCreateData;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.common.app.BaseApplicationImpl;
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

public class otv
  implements osl
{
  private static Map<String, otv> jdField_a_of_type_JavaUtilMap = new HashMap();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private blgz<Pair<String, BaseCommentData>> jdField_a_of_type_Blgz = new blgz();
  public CommonCommentData a;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  protected String a;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private ove jdField_a_of_type_Ove;
  private ovh jdField_a_of_type_Ovh;
  private ovj jdField_a_of_type_Ovj = new ovj();
  private ovm jdField_a_of_type_Ovm;
  private ovq jdField_a_of_type_Ovq = new ovq();
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
  private List<ovg> jdField_e_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_e_of_type_Boolean;
  private String jdField_f_of_type_JavaLangString = "";
  private boolean jdField_f_of_type_Boolean = true;
  private String jdField_g_of_type_JavaLangString = "";
  private boolean jdField_g_of_type_Boolean;
  private String h = "";
  
  private otv(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = "";
    paramString = ozs.a();
    if (paramString != null)
    {
      this.jdField_a_of_type_Ovh = ((pfg)paramString.getManager(163)).a().a();
      this.jdField_a_of_type_Ovh.a(this);
    }
    this.jdField_a_of_type_Ovm = new ovm();
    this.jdField_a_of_type_Ovm.a(this);
    a(this.jdField_a_of_type_Ovq);
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
      if (paramBaseCommentData.isDynamicComment()) {
        return 7;
      }
    } while (!paramBaseCommentData.isAd);
    return 9;
  }
  
  private List<otp> a(int paramInt, List<BaseCommentData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      BaseCommentData localBaseCommentData = (BaseCommentData)paramList.next();
      localArrayList.add(new otp(paramInt, a(localBaseCommentData), localBaseCommentData, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
    }
    return localArrayList;
  }
  
  private List<otp> a(boolean paramBoolean, BaseCommentData paramBaseCommentData, List<SubCommentData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean)
    {
      localArrayList.add(new otp(0, paramBaseCommentData, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
      localArrayList.add(new otp(3, paramBaseCommentData, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
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
          localArrayList.add(new otp(i, paramList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
          break;
        }
      }
    }
    return localArrayList;
  }
  
  public static otv a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return null;
    }
    return (otv)jdField_a_of_type_JavaUtilMap.get(paramArticleInfo.innerUniqueID);
  }
  
  public static otv a(ArticleInfo paramArticleInfo, int paramInt)
  {
    if (paramArticleInfo == null) {
      localObject = null;
    }
    otv localotv;
    do
    {
      return localObject;
      localotv = (otv)jdField_a_of_type_JavaUtilMap.get(paramArticleInfo.innerUniqueID);
      localObject = localotv;
    } while (localotv != null);
    Object localObject = new otv(paramArticleInfo.innerUniqueID);
    ((otv)localObject).b(paramArticleInfo);
    ((otv)localObject).jdField_a_of_type_Int = paramInt;
    if (paramInt == 1)
    {
      ((otv)localObject).jdField_a_of_type_JavaLangString = (paramArticleInfo.mArticleID + "");
      ((otv)localObject).jdField_g_of_type_JavaLangString = (paramArticleInfo.mArticleID + "");
    }
    for (;;)
    {
      jdField_a_of_type_JavaUtilMap.put(paramArticleInfo.innerUniqueID, localObject);
      ((otv)localObject).h = paramArticleInfo.innerUniqueID;
      QLog.d("ReadInJoyCommentDataManager", 2, new Object[] { "create commentDataManager, articleInfo : ", paramArticleInfo, ", src : ", Integer.valueOf(paramInt) });
      return localObject;
      ((otv)localObject).jdField_a_of_type_JavaLangString = paramArticleInfo.innerUniqueID;
      ((otv)localObject).h = paramArticleInfo.innerUniqueID;
    }
  }
  
  public static otv a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (otv)jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_Ovh == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      a(new otz(this, paramInt));
      return;
    }
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "fetch sub commentList, id : ", paramString1, ", fetchType : ", Integer.valueOf(paramInt), ", cookie : ", this.jdField_c_of_type_JavaLangString });
    this.jdField_a_of_type_Ovh.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, paramString1, paramString2, this.jdField_c_of_type_JavaLangString, 10, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData);
  }
  
  private void a(BaseCommentData paramBaseCommentData)
  {
    if (!(paramBaseCommentData instanceof CommentData)) {}
    do
    {
      return;
      int i = ((CommentData)paramBaseCommentData).subCommentNum;
      a((CommentData)paramBaseCommentData, -(i + 1));
      if (this.jdField_b_of_type_JavaUtilMap != null) {
        this.jdField_b_of_type_JavaUtilMap.remove(paramBaseCommentData.commentId);
      }
      if (this.jdField_a_of_type_JavaUtilList != null) {
        this.jdField_a_of_type_JavaUtilList.remove(paramBaseCommentData.commentId);
      }
      if (this.jdField_b_of_type_JavaUtilList != null) {
        this.jdField_b_of_type_JavaUtilList.remove(paramBaseCommentData.commentId);
      }
    } while (this.jdField_d_of_type_JavaUtilList == null);
    this.jdField_d_of_type_JavaUtilList.remove(paramBaseCommentData.commentId);
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
      paramArticleInfo = (otv)jdField_a_of_type_JavaUtilMap.remove(paramArticleInfo.innerUniqueID);
    } while (paramArticleInfo == null);
    paramArticleInfo.a();
    QLog.d("ReadInJoyCommentDataManager", 1, "removeCommentDataManager | destroy");
  }
  
  public static void a(ArticleInfo paramArticleInfo, int paramInt)
  {
    if (paramInt == 6)
    {
      paramArticleInfo = (otv)jdField_a_of_type_JavaUtilMap.get(paramArticleInfo.innerUniqueID);
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
  
  private void a(List<ovg> paramList, boolean paramBoolean, ovd paramovd)
  {
    int i = 0;
    if (i < paramList.size())
    {
      ovg localovg = (ovg)paramList.get(i);
      if (paramBoolean) {
        ThreadManager.getUIHandler().post(new ReadInJoyCommentDataManager.34(this, paramovd, localovg));
      }
      for (;;)
      {
        i += 1;
        break;
        paramovd.a(localovg);
      }
    }
  }
  
  private void a(ovd paramovd)
  {
    a(paramovd, true);
  }
  
  private void a(ovd paramovd, boolean paramBoolean)
  {
    if ((!this.jdField_e_of_type_JavaUtilList.isEmpty()) && (paramovd != null)) {
      a(this.jdField_e_of_type_JavaUtilList, paramBoolean, paramovd);
    }
    ArrayList localArrayList = new ArrayList();
    if (ord.a().a() != null) {
      localArrayList.addAll(ord.a().a());
    }
    if ((localArrayList != null) && (paramovd != null)) {
      a(localArrayList, paramBoolean, paramovd);
    }
  }
  
  private boolean a(List<CommentData> paramList)
  {
    if ((paramList == null) || (this.jdField_a_of_type_Ove == null) || (!this.jdField_a_of_type_Ove.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Ove.jdField_a_of_type_JavaLangString == null)) {
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      CommentData localCommentData = (CommentData)paramList.next();
      if ((localCommentData != null) && (this.jdField_a_of_type_Ove.jdField_a_of_type_JavaLangString.equals(localCommentData.commentId)))
      {
        localCommentData.isAnchor = true;
        return true;
      }
    }
    return false;
  }
  
  private List<otp> b(int paramInt, List<String> paramList)
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
        localArrayList.add(new otp(paramInt, a((BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(str)), (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(str), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
      }
    }
    return localArrayList;
  }
  
  private void b(BaseCommentData paramBaseCommentData)
  {
    if (!(paramBaseCommentData instanceof SubCommentData)) {}
    CommentData localCommentData;
    do
    {
      return;
      localCommentData = (CommentData)this.jdField_b_of_type_JavaUtilMap.get(((SubCommentData)paramBaseCommentData).parentCommentId);
    } while (localCommentData == null);
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
        if (localSubCommentData.commentId.equalsIgnoreCase(paramBaseCommentData.commentId)) {
          localList.remove(localSubCommentData);
        }
      }
    }
    a(localCommentData, -1);
    this.jdField_c_of_type_JavaUtilList.remove(paramBaseCommentData.commentId);
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
    if ((this.jdField_a_of_type_Ovh == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      a(new ovc(this, paramInt));
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
        if (this.jdField_a_of_type_Ove != null)
        {
          localObject1 = localObject2;
          if (this.jdField_a_of_type_Ove.jdField_a_of_type_Boolean) {
            localObject1 = this.jdField_a_of_type_Ove.jdField_a_of_type_JavaLangString;
          }
        }
      }
      ThreadManager.executeOnSubThread(new ReadInJoyCommentDataManager.9(this, (String)localObject1));
      return;
    }
  }
  
  private int d()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      int i = 0;
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        Object localObject = (String)localIterator.next();
        localObject = (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(localObject);
        j = i;
        if (localObject == null) {
          break;
        }
        j = i;
        if (!((BaseCommentData)localObject).isBanner) {
          break;
        }
        i += 1;
      }
    }
    int j = 0;
    return j;
  }
  
  private void d()
  {
    if (this.jdField_b_of_type_JavaUtilList != null) {
      this.jdField_b_of_type_JavaUtilList.clear();
    }
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_g_of_type_Boolean = false;
  }
  
  private void d(int paramInt)
  {
    if ((this.jdField_a_of_type_Ovh == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      a(new otx(this, paramInt));
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
        if (this.jdField_a_of_type_Ove != null)
        {
          localObject1 = localObject2;
          if (this.jdField_a_of_type_Ove.jdField_a_of_type_Boolean) {
            localObject1 = this.jdField_a_of_type_Ove.jdField_a_of_type_JavaLangString;
          }
        }
      }
      ThreadManager.executeOnSubThread(new ReadInJoyCommentDataManager.11(this, (String)localObject1));
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
    if ((this.jdField_a_of_type_Ovh == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      a(new oty(this, paramInt));
      return;
    }
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "fetchFamilyCommentList, fetchType : ", Integer.valueOf(paramInt), ", cookie : ", this.jdField_f_of_type_JavaLangString });
    if (paramInt == 1) {}
    for (String str = "";; str = this.jdField_f_of_type_JavaLangString)
    {
      this.jdField_f_of_type_JavaLangString = str;
      this.jdField_a_of_type_Ovh.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, this.jdField_f_of_type_JavaLangString, 10, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData);
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
      ((BaseCommentData)localObject1).uin = ozs.a();
      ((BaseCommentData)localObject1).homepage = ozs.h(((BaseCommentData)localObject1).uin);
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
        break label351;
      }
      localObject2 = ((ReadInJoyUserInfo)localObject3).nick;
      label133:
      ((BaseCommentData)localObject1).nickName = ((String)localObject2);
      if (localObject3 == null) {
        break label359;
      }
      localObject2 = ((ReadInJoyUserInfo)localObject3).faceUrl;
      label151:
      ((BaseCommentData)localObject1).avatar = ((String)localObject2);
    }
    label394:
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        ((BaseCommentData)localObject1).commentContent = new String(bhkv.decode(paramString.getString("comment"), 0));
        BaseCommentData localBaseCommentData;
        if (paramInt == 2)
        {
          localObject2 = (SubCommentData)localObject1;
          localObject3 = paramString.getString("commentId");
          localBaseCommentData = (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(localObject3);
          if (!(localBaseCommentData instanceof SubCommentData)) {
            continue;
          }
          ((SubCommentData)localObject2).parentCommentId = ((SubCommentData)localBaseCommentData).parentCommentId;
          if (paramString.optBoolean("isSecondReply", false))
          {
            ((SubCommentData)localObject2).repliedCommentId = ((String)localObject3);
            localObject3 = paramString.optString("replyUin");
            if (!TextUtils.isEmpty((CharSequence)localObject3))
            {
              ((SubCommentData)localObject2).repliedUserUin = ((String)localObject3);
              paramString = ReadInJoyUserInfoModule.a(Long.valueOf((String)localObject3).longValue(), null);
              if (paramString == null) {
                break label394;
              }
              paramString = paramString.nick;
              ((SubCommentData)localObject2).repliedUserNickname = paramString;
              ((SubCommentData)localObject2).repliedUserHomePage = ozs.h((String)localObject3);
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
        label351:
        localObject2 = ReadInJoyUserInfoModule.a();
        break label133;
        label359:
        localObject2 = "";
        break label151;
        if ((localBaseCommentData instanceof CommentData))
        {
          ((SubCommentData)localObject2).parentCommentId = localBaseCommentData.commentId;
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
  
  public List<otp> a()
  {
    ArrayList localArrayList1 = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      ArrayList localArrayList2 = new ArrayList();
      i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        CommentData localCommentData = (CommentData)this.jdField_b_of_type_JavaUtilMap.get(this.jdField_a_of_type_JavaUtilList.get(i));
        if ((localCommentData != null) && ((!localCommentData.isFamilyTopEntry()) || ((localCommentData.isFamilyTopEntry()) && (!orq.a())))) {
          localArrayList2.add(localCommentData);
        }
        i += 1;
      }
      if ((localArrayList2.size() > 0) && (this.jdField_f_of_type_Boolean)) {
        localArrayList1.add(new otp(1, null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
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
  
  public List<otp> a(int paramInt)
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
  
  public List<otp> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(paramString);
    if (paramString == null) {
      return localArrayList;
    }
    localArrayList.add(new otp(0, paramString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
    localArrayList.add(new otp(3, paramString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
    return localArrayList;
  }
  
  public ove a()
  {
    return this.jdField_a_of_type_Ove;
  }
  
  public ovj a()
  {
    return this.jdField_a_of_type_Ovj;
  }
  
  public ovq a()
  {
    return this.jdField_a_of_type_Ovq;
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
    if (this.jdField_a_of_type_Blgz != null) {
      this.jdField_a_of_type_Blgz.a();
    }
    if (this.jdField_e_of_type_JavaUtilList != null) {
      this.jdField_e_of_type_JavaUtilList.clear();
    }
    if (this.jdField_a_of_type_Ovh != null) {
      this.jdField_a_of_type_Ovh.a();
    }
    if (this.jdField_a_of_type_Ovm != null) {
      this.jdField_a_of_type_Ovm.a();
    }
  }
  
  public void a(int paramInt)
  {
    a(new ouw(this, paramInt));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Ovh == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      a(new ova(this, paramInt2));
      return;
    }
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "loadFirstCommentList | feedsType : " + paramInt1 + " contentSrc : " + this.jdField_a_of_type_Int + "; fetchType : " + paramInt2, ", cookie : ", this.jdField_b_of_type_JavaLangString });
    if (paramInt2 == 1) {}
    for (String str = "";; str = this.jdField_b_of_type_JavaLangString)
    {
      this.jdField_b_of_type_JavaLangString = str;
      if ((paramInt2 != 1) || (this.jdField_a_of_type_Ove == null) || (!this.jdField_a_of_type_Ove.jdField_a_of_type_Boolean)) {
        break;
      }
      ThreadManager.executeOnSubThread(new ReadInJoyCommentDataManager.5(this, this.jdField_a_of_type_Ove.jdField_a_of_type_JavaLangString));
      return;
    }
    if (paramInt1 == 6)
    {
      ThreadManager.executeOnSubThread(new ReadInJoyCommentDataManager.6(this));
      return;
    }
    ThreadManager.executeOnSubThread(new ReadInJoyCommentDataManager.7(this, null));
  }
  
  public void a(int paramInt, String paramString, ovk paramovk, ovl paramovl)
  {
    boolean bool2 = true;
    boolean bool3 = TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString);
    ovk localovk = paramovk;
    if (paramovk == null) {
      localovk = new ovk();
    }
    if (paramovl == null) {
      new ovl();
    }
    boolean bool1;
    if (paramInt == 0)
    {
      this.jdField_b_of_type_Boolean = localovk.jdField_a_of_type_Boolean;
      this.jdField_c_of_type_JavaLangString = localovk.jdField_a_of_type_JavaLangString;
      if (localovk.jdField_b_of_type_JavaUtilList == null) {
        break label342;
      }
      paramovk = localovk.jdField_b_of_type_JavaUtilList.iterator();
      while (paramovk.hasNext())
      {
        paramovl = (SubCommentData)paramovk.next();
        if (paramovl != null)
        {
          if (TextUtils.isEmpty(paramovl.parentCommentId)) {
            paramovl.parentCommentId = paramString;
          }
          this.jdField_b_of_type_JavaUtilMap.put(paramovl.commentId, paramovl);
          this.jdField_c_of_type_JavaUtilList.add(paramovl.commentId);
        }
      }
      paramovk = a(bool3, (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(paramString), localovk.jdField_b_of_type_JavaUtilList);
      bool1 = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        if (localovk.jdField_b_of_type_JavaUtilList == null) {
          break label331;
        }
        paramInt = localovk.jdField_b_of_type_JavaUtilList.size();
        label212:
        if ((localovk == null) || (!localovk.jdField_a_of_type_Boolean)) {
          break label336;
        }
      }
      for (;;)
      {
        QLog.d("ReadInJoyCommentDataManager", 2, new Object[] { "getSubCommentListResp ret : ", Boolean.valueOf(bool1), ", mainCommentID : ", paramString, ", size : ", Integer.valueOf(paramInt), ", hasNext : ", Boolean.valueOf(bool2), ", isFirstFetch : ", Boolean.valueOf(bool3) });
        a(new ouq(this, bool3, bool1, paramovk));
        return;
        paramovk = null;
        bool1 = false;
        break;
        label331:
        paramInt = 0;
        break label212;
        label336:
        bool2 = false;
      }
      label342:
      paramovk = null;
      bool1 = true;
    }
  }
  
  public void a(int paramInt, ovk paramovk1, ovk paramovk2, ovl paramovl)
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
      localObject = paramovk1;
      if (paramovk1 == null) {
        localObject = new ovk();
      }
      paramovk1 = paramovk2;
      if (paramovk2 == null) {
        paramovk1 = new ovk();
      }
      paramovk2 = paramovl;
      if (paramovl == null) {
        paramovk2 = new ovl();
      }
      if (bool1)
      {
        this.jdField_c_of_type_Boolean = paramovk1.jdField_a_of_type_Boolean;
        this.jdField_d_of_type_Boolean = ((ovk)localObject).jdField_a_of_type_Boolean;
        if (((ovk)localObject).jdField_a_of_type_JavaUtilList == null) {
          break label492;
        }
        l = ((ovk)localObject).jdField_a_of_type_JavaUtilList.size();
        this.jdField_c_of_type_Long = l;
        this.jdField_d_of_type_JavaLangString = paramovk1.jdField_a_of_type_JavaLangString;
        this.jdField_e_of_type_JavaLangString = ((ovk)localObject).jdField_a_of_type_JavaLangString;
        this.jdField_g_of_type_Boolean = paramovk2.jdField_a_of_type_Boolean;
        this.jdField_a_of_type_Ovj = paramovk2.jdField_a_of_type_Ovj;
        a(((ovk)localObject).jdField_a_of_type_JavaUtilList, paramovk1.jdField_a_of_type_JavaUtilList);
      }
      if (!bool2) {
        break label519;
      }
      if (paramovk2.jdField_a_of_type_Long > 0L) {
        this.jdField_b_of_type_Long = paramovk2.jdField_a_of_type_Long;
      }
      this.jdField_a_of_type_Long = paramovk2.jdField_b_of_type_Long;
      if ((this.jdField_a_of_type_Ove != null) && (this.jdField_a_of_type_Ove.jdField_b_of_type_Boolean))
      {
        if (!a(((ovk)localObject).jdField_a_of_type_JavaUtilList)) {
          a(new oue(this));
        }
        this.jdField_a_of_type_Ove.jdField_b_of_type_Boolean = false;
      }
      paramInt = 3;
      List localList = a(3);
      if (localList != null)
      {
        paramovl = localList;
        if (!localList.isEmpty()) {}
      }
      else
      {
        paramInt = 2;
        paramovl = a(2);
      }
      if (paramInt != 3) {
        break label498;
      }
      bool2 = this.jdField_d_of_type_Boolean;
      label284:
      if (!((ovk)localObject).a()) {
        break label507;
      }
      i = ((ovk)localObject).jdField_a_of_type_JavaUtilList.size();
      label304:
      localObject = new StringBuilder().append(", new size : ");
      if (!paramovk1.a()) {
        break label513;
      }
    }
    label513:
    for (int j = paramovk1.jdField_a_of_type_JavaUtilList.size();; j = 0)
    {
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "onLoadFirstCommentFinish, ret : ", Boolean.valueOf(bool1), ", hot size : ", Integer.valueOf(i), j, ", totalCnt : ", this.jdField_b_of_type_Long + " , hideCnt : " + this.jdField_a_of_type_Long });
      a(new ouf(this, bool1, paramovl, bool2, paramInt));
      if (this.jdField_a_of_type_Ove != null) {
        this.jdField_a_of_type_Ove.a(false);
      }
      this.jdField_a_of_type_Ovq.a(paramovk2.jdField_a_of_type_Int);
      this.jdField_a_of_type_Ovq.a(paramovk2.jdField_a_of_type_JavaLangString);
      return;
      bool1 = false;
      break;
      label492:
      l = 0L;
      break label105;
      label498:
      bool2 = this.jdField_c_of_type_Boolean;
      break label284;
      label507:
      i = 0;
      break label304;
    }
    label519:
    if (paramovk1 != null) {}
    for (paramovk1 = a(2, new ArrayList(paramovk1.jdField_a_of_type_JavaUtilList));; paramovk1 = new ArrayList())
    {
      bool2 = this.jdField_a_of_type_Boolean;
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "onLoadMoreComment, ret : ", Boolean.valueOf(bool1), ", size : ", Integer.valueOf(paramovk1.size()), ", hasNext : ", Boolean.valueOf(bool2) });
      a(new ouh(this, bool1, paramovk1));
      return;
    }
  }
  
  public void a(int paramInt, ovk paramovk, ovl paramovl, CommentData paramCommentData)
  {
    boolean bool2 = TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString);
    paramCommentData = paramovk;
    if (paramovk == null) {
      paramCommentData = new ovk();
    }
    paramovk = paramovl;
    if (paramovl == null) {
      paramovk = new ovl();
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
      if (paramovk.jdField_a_of_type_Long > 0L) {
        this.jdField_b_of_type_Long = paramovk.jdField_a_of_type_Long;
      }
      paramovk = b();
      paramovl = new StringBuilder().append(", new size : ");
      if (paramCommentData.jdField_a_of_type_JavaUtilList == null) {
        break label222;
      }
    }
    label222:
    for (paramInt = paramCommentData.jdField_a_of_type_JavaUtilList.size();; paramInt = 0)
    {
      QLog.d("ReadInJoyCommentDataManager", 2, new Object[] { "onLoadNewCommentFinish, ret : ", Boolean.valueOf(bool1), paramInt, ", totalCnt : ", Long.valueOf(this.jdField_b_of_type_Long) });
      a(new oui(this, bool1, paramovk));
      if (this.jdField_a_of_type_Ove != null) {
        this.jdField_a_of_type_Ove.a(false);
      }
      return;
      bool1 = false;
      break;
    }
    label227:
    if (paramCommentData.jdField_a_of_type_JavaUtilList != null) {}
    for (paramovk = a(2, new ArrayList(paramCommentData.jdField_a_of_type_JavaUtilList));; paramovk = new ArrayList())
    {
      bool2 = this.jdField_c_of_type_Boolean;
      QLog.d("ReadInJoyCommentDataManager", 2, new Object[] { "onLoadMoreNewComment, ret : ", Boolean.valueOf(bool1), ", size : ", Integer.valueOf(paramovk.size()), ", hasNext : ", Boolean.valueOf(bool2) });
      a(new ouj(this, bool1, paramovk, bool2));
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
    Pair localPair = (Pair)this.jdField_a_of_type_Blgz.a(paramLong);
    if (localPair == null) {
      QLog.d("ReadInJoyCommentDataManager", 1, "onCreateCommentResult | fake comment data not exist, return !");
    }
    BaseCommentData localBaseCommentData;
    do
    {
      return;
      localBaseCommentData = (BaseCommentData)localPair.second;
      this.jdField_a_of_type_Blgz.b(paramLong);
      if (paramBoolean)
      {
        osp.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, (String)localPair.first);
        a(localBaseCommentData, paramString, paramInt2);
        return;
      }
      if ((localBaseCommentData instanceof CommentData))
      {
        a(new ouu(this, paramInt2));
        return;
      }
    } while (!(localBaseCommentData instanceof SubCommentData));
    a(new ouv(this));
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
      ThreadManager.getUIHandler().post(new ReadInJoyCommentDataManager.35(this, paramBoolean, paramString2, paramString1));
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
          a(new oux(this, new otp(i, 0, paramBaseCommentData, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), bool, paramInt));
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
    a(paramString, 1);
    a(new ouy(this, paramBaseCommentData));
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
    this.jdField_a_of_type_Ovm.a(paramString, 1, paramInt, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    QLog.d("ReadInJoyCommentDataManager", 1, "onUpdateCommentStickyResult: id[" + paramString + "] success[" + paramBoolean1 + "] overtimes[" + paramBoolean2 + "]");
    int i;
    if (paramInt == 1) {
      i = 1;
    }
    while (paramBoolean1)
    {
      BaseCommentData localBaseCommentData = (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(paramString);
      if (localBaseCommentData == null)
      {
        return;
        i = 0;
      }
      else
      {
        if (paramInt == 1) {}
        for (paramBoolean1 = bool;; paramBoolean1 = false)
        {
          localBaseCommentData.isAuthorSticky = paramBoolean1;
          if (i == 0) {
            break;
          }
          this.jdField_a_of_type_JavaUtilList.remove(paramString);
          this.jdField_a_of_type_JavaUtilList.add(d(), paramString);
          paramInt = 2131717484;
          a(new ovb(this, a()));
          QQToast.a(BaseApplicationImpl.context, 2, anzj.a(paramInt), 0).a();
          return;
        }
        this.jdField_a_of_type_JavaUtilList.remove(paramString);
        if (this.jdField_a_of_type_JavaUtilList.size() > 10) {
          this.jdField_a_of_type_JavaUtilList.add(9, paramString);
        }
        for (;;)
        {
          paramInt = 2131717488;
          break;
          this.jdField_a_of_type_JavaUtilList.add(paramString);
        }
      }
    }
    if (i != 0) {
      if (paramBoolean2) {
        paramInt = 2131717483;
      }
    }
    for (;;)
    {
      QQToast.a(BaseApplicationImpl.context, paramInt, 0).a();
      return;
      paramInt = 2131717482;
      continue;
      paramInt = 2131717487;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    b();
    a(1, paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    BaseCommentData localBaseCommentData = (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(paramString1);
    this.jdField_a_of_type_Ovm.a(localBaseCommentData, this.jdField_a_of_type_JavaLangString, paramString2, paramInt, this.jdField_a_of_type_Int);
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "commentID : ", paramString1, ", reportReason : ", paramString2 });
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(paramString) == null) {
      return;
    }
    paramString = new FirstCommentStickyData(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, this.jdField_a_of_type_Int, "", paramString);
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      paramString.a(i);
      owr.a.a(paramString, this);
      return;
    }
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    QLog.d("ReadInJoyCommentDataManager", 1, "onSinkCommentResult: id[" + paramString + "] success[" + paramBoolean1 + "] overtimes[" + paramBoolean2 + "]");
    if (paramBoolean1)
    {
      if (this.jdField_d_of_type_Boolean) {
        this.jdField_b_of_type_JavaUtilMap.remove(paramString);
      }
      for (;;)
      {
        a(new ouz(this, a()));
        QQToast.a(BaseApplicationImpl.context, 2, anzj.a(2131717479), 0).a();
        return;
        localObject = (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(paramString);
        if (localObject != null) {
          ((BaseCommentData)localObject).isAuthorSticky = false;
        }
        this.jdField_a_of_type_JavaUtilList.remove(paramString);
        this.jdField_a_of_type_JavaUtilList.add(paramString);
      }
    }
    Object localObject = BaseApplicationImpl.context;
    if (paramBoolean2) {}
    for (paramString = anzj.a(2131717478);; paramString = anzj.a(2131717477))
    {
      QQToast.a((Context)localObject, paramString, 0).a();
      return;
    }
  }
  
  public void a(otp paramotp)
  {
    if (paramotp == null) {}
    do
    {
      do
      {
        return;
        paramotp = paramotp.a;
      } while (paramotp == null);
      if (this.jdField_b_of_type_JavaUtilMap != null) {
        this.jdField_b_of_type_JavaUtilMap.remove(paramotp);
      }
      paramotp = paramotp.commentId;
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.contains(paramotp)))
      {
        this.jdField_a_of_type_JavaUtilList.remove(paramotp);
        a(new otw(this));
      }
      if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.contains(paramotp)))
      {
        this.jdField_b_of_type_JavaUtilList.remove(paramotp);
        a(new oug(this));
      }
    } while ((this.jdField_d_of_type_JavaUtilList == null) || (!this.jdField_d_of_type_JavaUtilList.contains(paramotp)));
    this.jdField_d_of_type_JavaUtilList.remove(paramotp);
    a(new our(this));
  }
  
  public void a(otp paramotp, int paramInt)
  {
    if ((this.jdField_a_of_type_Ovm == null) || (paramotp == null) || (paramotp.a == null)) {
      return;
    }
    BaseCommentData localBaseCommentData = paramotp.a;
    if ((localBaseCommentData instanceof CommentData))
    {
      int i = ((CommentData)localBaseCommentData).subCommentNum;
      a((CommentData)localBaseCommentData, -(i + 1));
      if (this.jdField_b_of_type_JavaUtilMap != null) {
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
    a(new oua(this, localBaseCommentData.getCommentLevel(), paramotp, paramInt), false);
    this.jdField_a_of_type_Ovm.a(localBaseCommentData, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
  }
  
  public void a(ove paramove)
  {
    if ("setCommentAnchor | commentid : " + paramove != null) {}
    for (String str = paramove.jdField_a_of_type_JavaLangString;; str = "")
    {
      QLog.d("ReadInJoyCommentDataManager", 1, str);
      this.jdField_a_of_type_Ove = paramove;
      return;
    }
  }
  
  /* Error */
  public void a(ovg paramovg)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 82	otv:jdField_e_of_type_JavaUtilList	Ljava/util/List;
    //   6: aload_1
    //   7: invokeinterface 310 2 0
    //   12: istore_2
    //   13: iload_2
    //   14: ifeq +6 -> 20
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: aload_0
    //   21: getfield 82	otv:jdField_e_of_type_JavaUtilList	Ljava/util/List;
    //   24: aload_1
    //   25: invokeinterface 197 2 0
    //   30: pop
    //   31: goto -14 -> 17
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	otv
    //   0	39	1	paramovg	ovg
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
  
  public void a(boolean paramBoolean, BaseCommentData paramBaseCommentData, String paramString)
  {
    if (paramBaseCommentData == null) {}
    for (;;)
    {
      return;
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "del comment resp, ret : ", Boolean.valueOf(paramBoolean), ", data : ", paramBaseCommentData });
      if (paramBoolean)
      {
        QQToast.a(BaseApplication.getContext(), 2, anzj.a(2131711833), 0).a();
        paramString = BaseActivity.sTopActivity.getIntent().getBundleExtra("bundle");
        if (!(paramBaseCommentData instanceof CommentData)) {
          break label137;
        }
      }
      label137:
      for (int i = ((CommentData)paramBaseCommentData).subCommentNum + 1; paramString != null; i = 1)
      {
        pfd.a().a(true, this.jdField_a_of_type_JavaLangString, paramBaseCommentData.commentId, "onCommentDelete", paramString.getInt("seq"), i);
        return;
        QQToast.a(BaseApplication.getContext(), 1, paramString, 0).a();
        return;
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2)
  {
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "onLikeOrDislikeCommentResult ret : ", Boolean.valueOf(paramBoolean), ", commentID : ", paramString, ", opType ; ", Integer.valueOf(paramInt1), ", opValue : ", Integer.valueOf(paramInt2) });
    a(new out(this, paramBoolean, paramString, paramInt1, paramInt2));
    Object localObject = BaseActivity.sTopActivity;
    if (localObject != null)
    {
      localObject = ((Activity)localObject).getIntent().getBundleExtra("bundle");
      if (localObject != null) {
        pfd.a().a(paramBoolean, this.jdField_a_of_type_JavaLangString, paramString, String.valueOf(paramInt2), "onCommentLike", ((Bundle)localObject).getInt("seq"));
      }
    }
  }
  
  public void a(boolean paramBoolean1, otp paramotp, int paramInt, String paramString, boolean paramBoolean2)
  {
    QLog.d("ReadInJoyCommentDataManager", 1, "onAuthorDeleteCommentResult | bSuccess " + paramBoolean1 + " errMsg " + paramString);
    if (paramotp == null) {}
    do
    {
      return;
      paramString = paramotp.a;
    } while (paramString == null);
    if (paramBoolean1)
    {
      QQToast.a(BaseApplication.getContext(), 2, anzj.a(2131711833), 0).a();
      a(paramString);
      b(paramString);
      a(new ous(this, paramString.getCommentLevel(), paramotp, paramInt), false);
      return;
    }
    paramString = BaseApplicationImpl.context;
    if (paramBoolean2)
    {
      paramInt = 0;
      if (!paramBoolean2) {
        break label150;
      }
    }
    label150:
    for (paramotp = anzj.a(2131717473);; paramotp = anzj.a(2131717472))
    {
      QQToast.a(paramString, paramInt, paramotp, 0).a();
      return;
      paramInt = 1;
      break;
    }
  }
  
  public boolean a(ovg paramovg)
  {
    try
    {
      boolean bool = this.jdField_e_of_type_JavaUtilList.remove(paramovg);
      return bool;
    }
    finally
    {
      paramovg = finally;
      throw paramovg;
    }
  }
  
  public int b()
  {
    if (this.jdField_b_of_type_JavaUtilList != null) {
      return this.jdField_b_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public List<otp> b()
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
          if ((!localCommentData.isFamilyTopEntry()) || ((localCommentData.isFamilyTopEntry()) && (!orq.a()))) {
            localArrayList2.add(localCommentData);
          }
        }
      }
      if ((localArrayList2.size() > 0) && (this.jdField_f_of_type_Boolean)) {
        localArrayList1.add(new otp(2, null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
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
  
  public List<otp> b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = (CommentData)this.jdField_b_of_type_JavaUtilMap.get(paramString);
    if (paramString == null) {
      return localArrayList;
    }
    localArrayList.add(new otp(0, paramString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
    localArrayList.add(new otp(3, paramString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
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
  
  public void b(int paramInt, ovk paramovk, ovl paramovl, CommentData paramCommentData)
  {
    boolean bool2 = TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString);
    paramCommentData = paramovk;
    if (paramovk == null) {
      paramCommentData = new ovk();
    }
    paramovk = paramovl;
    if (paramovl == null) {
      paramovk = new ovl();
    }
    boolean bool1;
    if (paramInt == 0)
    {
      this.jdField_d_of_type_Boolean = paramCommentData.jdField_a_of_type_Boolean;
      this.jdField_e_of_type_JavaLangString = paramCommentData.jdField_a_of_type_JavaLangString;
      this.jdField_g_of_type_Boolean = paramovk.jdField_a_of_type_Boolean;
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
          a(new ouk(this, a(3)));
        }
      }
      else
      {
        if ((this.jdField_a_of_type_Ove != null) && (this.jdField_a_of_type_Ove.jdField_b_of_type_Boolean))
        {
          if (!a(paramCommentData.jdField_a_of_type_JavaUtilList)) {
            a(new oul(this));
          }
          this.jdField_a_of_type_Ove.jdField_b_of_type_Boolean = false;
        }
        paramovk = a();
        if (paramCommentData.jdField_a_of_type_JavaUtilList != null)
        {
          paramInt = paramCommentData.jdField_a_of_type_JavaUtilList.size();
          label235:
          paramovl = new StringBuilder().append(", hot size : ");
          if (paramCommentData.jdField_a_of_type_JavaUtilList == null) {
            break label372;
          }
        }
        label372:
        for (int i = paramCommentData.jdField_a_of_type_JavaUtilList.size();; i = 0)
        {
          QLog.d("ReadInJoyCommentDataManager", 2, new Object[] { "onLoadHotCommentFinish, ret : ", Boolean.valueOf(bool1), ", hot size : ", Integer.valueOf(paramInt), i, ", totalCnt : ", Long.valueOf(this.jdField_c_of_type_Long) });
          a(new oum(this, bool1, paramovk));
          if (this.jdField_a_of_type_Ove == null) {
            break;
          }
          this.jdField_a_of_type_Ove.a(false);
          return;
          paramInt = 0;
          break label235;
        }
      }
    }
    if (paramCommentData.jdField_a_of_type_JavaUtilList != null) {}
    for (paramovk = a(1, new ArrayList(paramCommentData.jdField_a_of_type_JavaUtilList));; paramovk = new ArrayList())
    {
      bool2 = this.jdField_d_of_type_Boolean;
      QLog.d("ReadInJoyCommentDataManager", 2, new Object[] { "onLoadMoreHotComment, ret : ", Boolean.valueOf(bool1), ", size : ", Integer.valueOf(paramovk.size()), ", hasNext : ", Boolean.valueOf(bool2) });
      a(new oun(this, bool1, paramovk, bool2));
      return;
    }
  }
  
  public void b(ArticleInfo paramArticleInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_Ovq.a(paramArticleInfo);
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    BaseCommentData localBaseCommentData;
    do
    {
      return;
      localBaseCommentData = a(1, paramString);
    } while (localBaseCommentData == null);
    FirstCommentCreateData localFirstCommentCreateData = new FirstCommentCreateData(this.jdField_a_of_type_Int, "");
    localFirstCommentCreateData.b(this.h);
    localFirstCommentCreateData.c(this.jdField_g_of_type_JavaLangString);
    localFirstCommentCreateData.a(localBaseCommentData.commentContent);
    owr.a.a(localFirstCommentCreateData, new oud(this), paramString, 2, true);
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
      this.jdField_a_of_type_Ovm.a(paramString, 0, paramInt, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      return;
    }
  }
  
  public void b(otp paramotp, int paramInt)
  {
    if ((paramotp == null) || (paramotp.a == null)) {
      return;
    }
    QLog.d("ReadInJoyCommentDataManager", 1, "authorDeleteComment | " + paramotp.a);
    owr.a.a(this.jdField_a_of_type_Int, paramotp, paramInt, this);
  }
  
  public void b(boolean paramBoolean, BaseCommentData paramBaseCommentData, String paramString)
  {
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "onReportCommentResp ret : ", Boolean.valueOf(paramBoolean), ", commentData : ", paramBaseCommentData, ", extraData : ", paramString });
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public List<otp> c()
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
        localArrayList1.add(new otp(2, null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
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
  
  public void c(int paramInt, ovk paramovk, ovl paramovl, CommentData paramCommentData)
  {
    paramCommentData = paramovk;
    if (paramovk == null) {
      paramCommentData = new ovk();
    }
    paramovk = paramovl;
    if (paramovl == null) {
      paramovk = new ovl();
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
      if (paramovk == null) {
        break label233;
      }
      l = paramovk.jdField_a_of_type_Long;
      label106:
      this.jdField_d_of_type_Long = l;
      paramovk = new StringBuilder();
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
      a(new ouo(this, bool1, c()));
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
    for (paramovk = a(4, new ArrayList(paramCommentData.jdField_a_of_type_JavaUtilList));; paramovk = new ArrayList())
    {
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "onLoadMoreFamilyComment, ret : ", Boolean.valueOf(bool1), ", size : ", Integer.valueOf(paramovk.size()), ", hasNext : ", Boolean.valueOf(this.jdField_e_of_type_Boolean) });
      a(new oup(this, bool1, paramovk));
      return;
    }
  }
  
  public void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(paramString) == null) {
      return;
    }
    paramString = new FirstCommentSinkData(paramString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, this.jdField_a_of_type_Int, "");
    owr.a.a(paramString, this);
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
    SubCommentCreateData localSubCommentCreateData = new SubCommentCreateData(this.jdField_a_of_type_Int, "");
    localSubCommentCreateData.a(localSubCommentData.parentCommentId);
    localSubCommentCreateData.b(this.h);
    localSubCommentCreateData.c(this.jdField_g_of_type_JavaLangString);
    localSubCommentCreateData.d(localSubCommentData.commentContent);
    if (localSubCommentData.hasTarget()) {
      localSubCommentCreateData.e(localSubCommentData.repliedCommentId);
    }
    try
    {
      localSubCommentCreateData.a(Long.parseLong(localSubCommentData.repliedUserUin));
      long l = owr.a.a(localSubCommentCreateData, new oub(this), paramString, paramInt, false);
      if (l != -1L) {
        this.jdField_a_of_type_Blgz.b(l, new Pair(paramString, localSubCommentData));
      }
      QLog.d("ReadInJoyCommentDataManager", 1, "create reply comment, seq : " + l + ", data : " + localSubCommentData);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        QLog.e("ReadInJoyCommentDataManager", 1, "replyComment: Invalid repliedSubAuthorId.");
      }
    }
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
    FirstCommentCreateData localFirstCommentCreateData = new FirstCommentCreateData(this.jdField_a_of_type_Int, "");
    localFirstCommentCreateData.b(this.h);
    localFirstCommentCreateData.c(this.jdField_g_of_type_JavaLangString);
    localFirstCommentCreateData.a(localBaseCommentData.commentContent);
    long l = owr.a.a(localFirstCommentCreateData, new ouc(this), paramString, paramInt, false);
    if (l != -1L) {
      this.jdField_a_of_type_Blgz.b(l, new Pair(paramString, localBaseCommentData));
    }
    QLog.d("ReadInJoyCommentDataManager", 1, "create main comment, seq : " + l + ", data : " + localBaseCommentData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     otv
 * JD-Core Version:    0.7.0.1
 */