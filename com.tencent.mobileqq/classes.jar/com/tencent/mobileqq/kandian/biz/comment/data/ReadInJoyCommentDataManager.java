package com.tencent.mobileqq.kandian.biz.comment.data;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.gson.Gson;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.comment.RIJCommentResultDispatcher;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentBubbleObserver;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentHelper;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentObserver;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils;
import com.tencent.mobileqq.kandian.biz.comment.emotion.cache.RIJEmotionCacheManager;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData.UserIdentityIcon;
import com.tencent.mobileqq.kandian.biz.comment.entity.CommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.CommonCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.CreateCommentResult;
import com.tencent.mobileqq.kandian.biz.comment.entity.FirstCommentCreateData;
import com.tencent.mobileqq.kandian.biz.comment.entity.FirstCommentSinkData;
import com.tencent.mobileqq.kandian.biz.comment.entity.FirstCommentStickyData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentCreateData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentData;
import com.tencent.mobileqq.kandian.biz.comment.guide.GuideHelper;
import com.tencent.mobileqq.kandian.biz.comment.helper.RIJCommentNetworkHelper;
import com.tencent.mobileqq.kandian.biz.comment.helper.RIJCommentNetworkWrapper;
import com.tencent.mobileqq.kandian.biz.comment.rptdata.RIJCommentRptDataUtil;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.comment.CommentReportInfo;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LongSparseArray;
import com.tencent.util.Pair;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyCommentDataManager
  extends ReadInJoyObserver
  implements ReadInJoyCommentBubbleObserver, ReadInJoyCommentObserver
{
  private static final LruCache<String, Boolean> jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(20);
  private static Map<String, ReadInJoyCommentDataManager> jdField_a_of_type_JavaUtilMap = new HashMap();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  private ReadInJoyCommentDataManager.CommentAnchor jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager$CommentAnchor;
  private ReadInJoyCommentPBModule.Label jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentPBModule$Label = new ReadInJoyCommentPBModule.Label();
  private ReadInJoyCommentPBModule jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentPBModule = null;
  private ReadInJoyCommentSSOModule jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentSSOModule = null;
  protected CommonCommentData a;
  private GuideHelper jdField_a_of_type_ComTencentMobileqqKandianBizCommentGuideGuideHelper = new GuideHelper();
  private AbsBaseArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  private LongSparseArray<Pair<String, BaseCommentData>> jdField_a_of_type_ComTencentUtilLongSparseArray = new LongSparseArray();
  protected String a;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = true;
  private long jdField_b_of_type_Long = 0L;
  private String jdField_b_of_type_JavaLangString = "";
  private List<String> jdField_b_of_type_JavaUtilList = new ArrayList();
  private Map<String, BaseCommentData> jdField_b_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_b_of_type_Boolean = true;
  private long jdField_c_of_type_Long = 0L;
  private String jdField_c_of_type_JavaLangString = "";
  private List<String> jdField_c_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_c_of_type_Boolean = true;
  private long jdField_d_of_type_Long = 0L;
  private String jdField_d_of_type_JavaLangString = "";
  private List<String> jdField_d_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_d_of_type_Boolean = true;
  private String jdField_e_of_type_JavaLangString = "";
  private List<ReadInJoyCommentDataManager.OnDataChangeListener> jdField_e_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_e_of_type_Boolean = false;
  private String jdField_f_of_type_JavaLangString = "";
  private boolean jdField_f_of_type_Boolean = true;
  private String jdField_g_of_type_JavaLangString = "";
  private boolean jdField_g_of_type_Boolean;
  private String jdField_h_of_type_JavaLangString = "";
  private boolean jdField_h_of_type_Boolean;
  private String jdField_i_of_type_JavaLangString = "";
  private boolean jdField_i_of_type_Boolean;
  
  private ReadInJoyCommentDataManager(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = "";
    Object localObject = ReadInJoyUserInfoModule.a();
    if (localObject != null)
    {
      localObject = ((IReadInJoyLogicEngine)localObject).b();
      if ((localObject instanceof ReadInJoyCommentPBModule))
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentPBModule = ((ReadInJoyCommentPBModule)localObject);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentPBModule.a(this);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentSSOModule = new ReadInJoyCommentSSOModule();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentSSOModule.a(this);
    a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentGuideGuideHelper);
    m();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("constructor: rowkey=");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", pbModule=");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentPBModule);
    QLog.d("ReadInJoyCommentDataManager", 1, ((StringBuilder)localObject).toString());
    RIJEmotionCacheManager.b();
  }
  
  private int a(BaseCommentData paramBaseCommentData)
  {
    int j = 0;
    if (paramBaseCommentData == null) {
      return 0;
    }
    if (paramBaseCommentData.isActivity()) {
      return 4;
    }
    if (paramBaseCommentData.isBanner()) {
      return 5;
    }
    if (paramBaseCommentData.isDynamicComment()) {
      j = 7;
    }
    return j;
  }
  
  public static ReadInJoyCommentDataManager a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return null;
    }
    return (ReadInJoyCommentDataManager)jdField_a_of_type_JavaUtilMap.get(paramAbsBaseArticleInfo.innerUniqueID);
  }
  
  public static ReadInJoyCommentDataManager a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    if (paramAbsBaseArticleInfo == null) {
      return null;
    }
    ReadInJoyCommentDataManager localReadInJoyCommentDataManager = (ReadInJoyCommentDataManager)jdField_a_of_type_JavaUtilMap.get(paramAbsBaseArticleInfo.innerUniqueID);
    if (localReadInJoyCommentDataManager != null) {
      return localReadInJoyCommentDataManager;
    }
    localReadInJoyCommentDataManager = new ReadInJoyCommentDataManager(paramAbsBaseArticleInfo.innerUniqueID);
    localReadInJoyCommentDataManager.b(paramAbsBaseArticleInfo);
    localReadInJoyCommentDataManager.jdField_a_of_type_Int = paramInt;
    if ((paramInt != 1) && (paramInt != 10))
    {
      localReadInJoyCommentDataManager.jdField_a_of_type_JavaLangString = paramAbsBaseArticleInfo.innerUniqueID;
      localReadInJoyCommentDataManager.jdField_h_of_type_JavaLangString = paramAbsBaseArticleInfo.innerUniqueID;
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramAbsBaseArticleInfo.mArticleID);
      localStringBuilder.append("");
      localReadInJoyCommentDataManager.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramAbsBaseArticleInfo.mArticleID);
      localStringBuilder.append("");
      localReadInJoyCommentDataManager.jdField_g_of_type_JavaLangString = localStringBuilder.toString();
    }
    jdField_a_of_type_JavaUtilMap.put(paramAbsBaseArticleInfo.innerUniqueID, localReadInJoyCommentDataManager);
    localReadInJoyCommentDataManager.jdField_h_of_type_JavaLangString = paramAbsBaseArticleInfo.innerUniqueID;
    QLog.d("ReadInJoyCommentDataManager", 2, new Object[] { "create commentDataManager, articleInfo : ", paramAbsBaseArticleInfo, ", src : ", Integer.valueOf(paramInt) });
    return localReadInJoyCommentDataManager;
  }
  
  private Pair<Integer, Integer> a()
  {
    int k = this.jdField_a_of_type_JavaUtilList.size() - 1;
    int j = 0;
    BaseCommentData localBaseCommentData;
    while (k >= 0)
    {
      localBaseCommentData = (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(this.jdField_a_of_type_JavaUtilList.get(k));
      if ((localBaseCommentData == null) || (!localBaseCommentData.isAuthorBottom)) {
        break;
      }
      j += 1;
      k -= 1;
    }
    k = b();
    int m = k;
    while (k <= this.jdField_a_of_type_JavaUtilList.size() - 1 - j)
    {
      localBaseCommentData = (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(this.jdField_a_of_type_JavaUtilList.get(k));
      if ((localBaseCommentData == null) || (!localBaseCommentData.isAuthorSticky)) {
        break;
      }
      m += 1;
      k += 1;
    }
    return new Pair(Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size() - m - j), Integer.valueOf(j));
  }
  
  private List<CommentViewItem> a(int paramInt, List<BaseCommentData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      BaseCommentData localBaseCommentData = (BaseCommentData)paramList.next();
      localArrayList.add(new CommentViewItem(paramInt, a(localBaseCommentData), localBaseCommentData, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo));
    }
    return localArrayList;
  }
  
  private List<CommentViewItem> a(boolean paramBoolean, BaseCommentData paramBaseCommentData, List<SubCommentData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean)
    {
      localArrayList.add(new CommentViewItem(0, paramBaseCommentData, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo));
      localArrayList.add(new CommentViewItem(3, paramBaseCommentData, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo));
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramBaseCommentData = paramList.iterator();
      while (paramBaseCommentData.hasNext())
      {
        paramList = (SubCommentData)paramBaseCommentData.next();
        int j;
        if (paramList.isActivity()) {
          j = 4;
        } else {
          j = 0;
        }
        localArrayList.add(new CommentViewItem(j, paramList, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo));
      }
    }
    return localArrayList;
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    s();
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentPBModule != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "fetch sub commentList, id : ", paramString1, ", fetchType : ", Integer.valueOf(paramInt), ", cookie : ", this.jdField_c_of_type_JavaLangString });
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentPBModule.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID, paramString1, paramString2, this.jdField_c_of_type_JavaLangString, 10, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityCommonCommentData);
      return;
    }
    a(new ReadInJoyCommentDataManager.13(this, paramInt));
  }
  
  private void a(ReadInJoyCommentDataManager.CallbackActionJob paramCallbackActionJob)
  {
    a(paramCallbackActionJob, true);
  }
  
  private void a(ReadInJoyCommentDataManager.CallbackActionJob paramCallbackActionJob, boolean paramBoolean)
  {
    if ((!this.jdField_e_of_type_JavaUtilList.isEmpty()) && (paramCallbackActionJob != null)) {
      a(this.jdField_e_of_type_JavaUtilList, paramBoolean, paramCallbackActionJob);
    }
    ArrayList localArrayList = new ArrayList();
    if (RIJCommentResultDispatcher.a().a() != null) {
      localArrayList.addAll(RIJCommentResultDispatcher.a().a());
    }
    if (paramCallbackActionJob != null) {
      a(localArrayList, paramBoolean, paramCallbackActionJob);
    }
  }
  
  private void a(BaseCommentData paramBaseCommentData)
  {
    if (!(paramBaseCommentData instanceof CommentData)) {
      return;
    }
    CommentData localCommentData = (CommentData)paramBaseCommentData;
    a(localCommentData, -(localCommentData.subCommentNum + 1));
    e(paramBaseCommentData.commentId);
  }
  
  private void a(CommentData paramCommentData, int paramInt)
  {
    if (paramCommentData == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).contains(paramCommentData.commentId)))
    {
      this.jdField_c_of_type_Long += paramInt;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateCommentCount | mHotCommentCnt ");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_Long);
      QLog.d("ReadInJoyCommentDataManager", 2, ((StringBuilder)localObject).toString());
    }
    long l1 = this.jdField_b_of_type_Long;
    long l2 = paramInt;
    this.jdField_b_of_type_Long = (l1 + l2);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateCommentCount | totalCommentCnt ");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_Long);
    QLog.d("ReadInJoyCommentDataManager", 2, ((StringBuilder)localObject).toString());
    localObject = this.jdField_d_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).contains(paramCommentData.commentId)))
    {
      this.jdField_d_of_type_Long += l2;
      paramCommentData = new StringBuilder();
      paramCommentData.append("updateCommentCount | mFamilyCommentCnt ");
      paramCommentData.append(this.jdField_d_of_type_Long);
      QLog.d("ReadInJoyCommentDataManager", 2, paramCommentData.toString());
    }
  }
  
  private void a(CreateCommentResult paramCreateCommentResult)
  {
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "onCreateCommentResult | create comment resp, seq ", Long.valueOf(paramCreateCommentResult.jdField_a_of_type_Long), " succ : ", Boolean.valueOf(paramCreateCommentResult.jdField_a_of_type_Boolean), " data : ", paramCreateCommentResult.jdField_a_of_type_JavaLangString });
    int j = paramCreateCommentResult.jdField_c_of_type_Int;
    if (this.jdField_b_of_type_JavaUtilList == null) {
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    Pair localPair = (Pair)this.jdField_a_of_type_ComTencentUtilLongSparseArray.a(paramCreateCommentResult.jdField_a_of_type_Long);
    if (localPair == null)
    {
      QLog.d("ReadInJoyCommentDataManager", 1, "onCreateCommentResult | fake comment data not exist, return !");
      return;
    }
    BaseCommentData localBaseCommentData = (BaseCommentData)localPair.second;
    this.jdField_a_of_type_ComTencentUtilLongSparseArray.b(paramCreateCommentResult.jdField_a_of_type_Long);
    if (!TextUtils.isEmpty(paramCreateCommentResult.jdField_c_of_type_JavaLangString)) {
      localBaseCommentData.commentContent = paramCreateCommentResult.jdField_c_of_type_JavaLangString;
    }
    localBaseCommentData.shareUrl = paramCreateCommentResult.jdField_d_of_type_JavaLangString;
    if (paramCreateCommentResult.jdField_a_of_type_Boolean)
    {
      localBaseCommentData.commentRptDataList = paramCreateCommentResult.jdField_a_of_type_JavaUtilList;
      ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, (String)localPair.first);
      c(localBaseCommentData);
      a(localBaseCommentData, paramCreateCommentResult.jdField_a_of_type_JavaLangString, j);
      return;
    }
    if ((localBaseCommentData instanceof CommentData))
    {
      a(new ReadInJoyCommentDataManager.33(this, paramCreateCommentResult));
      return;
    }
    if ((localBaseCommentData instanceof SubCommentData)) {
      a(new ReadInJoyCommentDataManager.34(this));
    }
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    paramAbsBaseArticleInfo = (ReadInJoyCommentDataManager)jdField_a_of_type_JavaUtilMap.remove(paramAbsBaseArticleInfo.innerUniqueID);
    if (paramAbsBaseArticleInfo != null)
    {
      paramAbsBaseArticleInfo.b();
      QLog.d("ReadInJoyCommentDataManager", 1, "removeCommentDataManager | destroy");
    }
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    if (paramInt == 6)
    {
      paramAbsBaseArticleInfo = (ReadInJoyCommentDataManager)jdField_a_of_type_JavaUtilMap.get(paramAbsBaseArticleInfo.innerUniqueID);
      if (paramAbsBaseArticleInfo != null) {
        paramAbsBaseArticleInfo.r();
      }
      paramAbsBaseArticleInfo = new StringBuilder();
      paramAbsBaseArticleInfo.append("removeCommentDataManager feedsType ");
      paramAbsBaseArticleInfo.append(paramInt);
      QLog.d("ReadInJoyCommentDataManager", 1, paramAbsBaseArticleInfo.toString());
      return;
    }
    a(paramAbsBaseArticleInfo);
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramBoolean)) {
      jdField_a_of_type_AndroidSupportV4UtilLruCache.put(b(paramString), Boolean.TRUE);
    }
  }
  
  private void a(List<ReadInJoyCommentDataManager.OnDataChangeListener> paramList, boolean paramBoolean, ReadInJoyCommentDataManager.CallbackActionJob paramCallbackActionJob)
  {
    int j = 0;
    while (j < paramList.size())
    {
      ReadInJoyCommentDataManager.OnDataChangeListener localOnDataChangeListener = (ReadInJoyCommentDataManager.OnDataChangeListener)paramList.get(j);
      if (paramBoolean) {
        ThreadManager.getUIHandler().post(new ReadInJoyCommentDataManager.36(this, paramCallbackActionJob, localOnDataChangeListener));
      } else {
        paramCallbackActionJob.a(localOnDataChangeListener);
      }
      j += 1;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (paramBoolean1)
    {
      QQToast.a(BaseApplicationImpl.getContext(), 2, HardCodeUtil.a(2131718285), 0).a();
      return;
    }
    BaseApplication localBaseApplication = BaseApplicationImpl.context;
    int j;
    if (paramBoolean2)
    {
      if (!TextUtils.isEmpty(paramString)) {
        break label61;
      }
      j = 2131718284;
    }
    else
    {
      j = 2131718283;
    }
    paramString = HardCodeUtil.a(j);
    label61:
    QQToast.a(localBaseApplication, 1, paramString, 0).a();
  }
  
  public static boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (jdField_a_of_type_AndroidSupportV4UtilLruCache.get(b(paramString)) != null);
  }
  
  private boolean a(List<CommentData> paramList)
  {
    if (paramList != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager$CommentAnchor;
      if ((localObject != null) && (((ReadInJoyCommentDataManager.CommentAnchor)localObject).jdField_b_of_type_Boolean))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager$CommentAnchor.jdField_a_of_type_JavaLangString == null) {
          return false;
        }
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject = (CommentData)paramList.next();
          if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager$CommentAnchor.jdField_a_of_type_JavaLangString.equals(((CommentData)localObject).commentId)))
          {
            ((CommentData)localObject).isAnchor = true;
            return true;
          }
        }
      }
    }
    return false;
  }
  
  private int b()
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilList;
    int m = 0;
    int j = 0;
    int k = m;
    if (localObject1 != null)
    {
      k = m;
      if (((List)localObject1).size() > 0)
      {
        localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
        for (;;)
        {
          k = j;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          Object localObject2 = (String)((Iterator)localObject1).next();
          localObject2 = (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(localObject2);
          k = j;
          if (localObject2 == null) {
            break;
          }
          k = j;
          if (!((BaseCommentData)localObject2).isBanner) {
            break;
          }
          j += 1;
        }
      }
    }
    return k;
  }
  
  private static String b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    localStringBuilder.append('_');
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private List<CommentViewItem> b(int paramInt, List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return localArrayList;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if ((!TextUtils.isEmpty(str)) && (this.jdField_b_of_type_JavaUtilMap.get(str) != null)) {
          localArrayList.add(new CommentViewItem(paramInt, a((BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(str)), (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(str), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo));
        }
      }
    }
    return localArrayList;
  }
  
  private void b(BaseCommentData paramBaseCommentData)
  {
    if (!(paramBaseCommentData instanceof SubCommentData)) {
      return;
    }
    CommentData localCommentData = (CommentData)this.jdField_b_of_type_JavaUtilMap.get(((SubCommentData)paramBaseCommentData).parentCommentId);
    if (localCommentData == null) {
      return;
    }
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
  
  private void b(CreateCommentResult paramCreateCommentResult)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null) {
      ThreadManager.getUIHandler().post(new ReadInJoyCommentDataManager.37(this, paramCreateCommentResult));
    }
  }
  
  private void c(BaseCommentData paramBaseCommentData)
  {
    ReadInJoyUserInfo localReadInJoyUserInfo = ReadInJoyUserInfoModule.a(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin(), null);
    if ((localReadInJoyUserInfo != null) && (!TextUtils.isEmpty(localReadInJoyUserInfo.upIconUrl)) && (paramBaseCommentData != null))
    {
      paramBaseCommentData.userIdentityIcon = new BaseCommentData.UserIdentityIcon();
      paramBaseCommentData.userIdentityIcon.jdField_a_of_type_JavaLangString = localReadInJoyUserInfo.upIconUrl;
    }
  }
  
  private void c(List<CommentData> paramList1, List<CommentData> paramList2)
  {
    if (this.jdField_b_of_type_JavaUtilMap == null) {
      return;
    }
    Object localObject;
    if ((paramList1 != null) && (paramList1.size() > 0))
    {
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        localObject = (CommentData)paramList1.next();
        if (localObject != null)
        {
          this.jdField_b_of_type_JavaUtilMap.put(((CommentData)localObject).commentId, localObject);
          List localList = this.jdField_a_of_type_JavaUtilList;
          if (localList != null) {
            localList.add(((CommentData)localObject).commentId);
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
          if (!this.jdField_b_of_type_JavaUtilMap.containsKey(paramList2.commentId)) {
            this.jdField_b_of_type_JavaUtilMap.put(paramList2.commentId, paramList2);
          }
          localObject = this.jdField_b_of_type_JavaUtilList;
          if (localObject != null) {
            ((List)localObject).add(paramList2.commentId);
          }
        }
      }
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      QQToast.a(BaseApplicationImpl.getContext(), 2, HardCodeUtil.a(2131712978), 0).a();
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 1, HardCodeUtil.a(2131699852), 0).a();
  }
  
  private void d(List<CommentData> paramList, List<String> paramList1)
  {
    if (this.jdField_b_of_type_JavaUtilMap == null) {
      return;
    }
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
  
  private void e(String paramString)
  {
    Object localObject = this.jdField_b_of_type_JavaUtilMap;
    if (localObject != null) {
      ((Map)localObject).remove(paramString);
    }
    localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null) {
      ((List)localObject).remove(paramString);
    }
    localObject = this.jdField_b_of_type_JavaUtilList;
    if (localObject != null) {
      ((List)localObject).remove(paramString);
    }
    localObject = this.jdField_d_of_type_JavaUtilList;
    if (localObject != null) {
      ((List)localObject).remove(paramString);
    }
    t();
  }
  
  public static void f()
  {
    jdField_a_of_type_JavaUtilMap.clear();
  }
  
  private void h(int paramInt)
  {
    s();
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentPBModule != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "fetch NewCommentList, fetchType : ", Integer.valueOf(paramInt), ", cookie : ", this.jdField_d_of_type_JavaLangString });
      if (paramInt == 1) {
        localObject1 = "";
      } else {
        localObject1 = this.jdField_d_of_type_JavaLangString;
      }
      this.jdField_d_of_type_JavaLangString = ((String)localObject1);
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (paramInt == 1)
      {
        ReadInJoyCommentDataManager.CommentAnchor localCommentAnchor = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager$CommentAnchor;
        localObject1 = localObject2;
        if (localCommentAnchor != null)
        {
          localObject1 = localObject2;
          if (localCommentAnchor.jdField_a_of_type_Boolean) {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager$CommentAnchor.jdField_a_of_type_JavaLangString;
          }
        }
      }
      ThreadManager.executeOnSubThread(new ReadInJoyCommentDataManager.9(this, (String)localObject1));
      return;
    }
    a(new ReadInJoyCommentDataManager.8(this, paramInt));
  }
  
  private void i(int paramInt)
  {
    s();
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentPBModule != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "fetch HotCommentList, fetchType : ", Integer.valueOf(paramInt), ", cookie : ", this.jdField_e_of_type_JavaLangString });
      if (paramInt == 1) {
        localObject1 = "";
      } else {
        localObject1 = this.jdField_e_of_type_JavaLangString;
      }
      this.jdField_e_of_type_JavaLangString = ((String)localObject1);
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (paramInt == 1)
      {
        ReadInJoyCommentDataManager.CommentAnchor localCommentAnchor = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager$CommentAnchor;
        localObject1 = localObject2;
        if (localCommentAnchor != null)
        {
          localObject1 = localObject2;
          if (localCommentAnchor.jdField_a_of_type_Boolean) {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager$CommentAnchor.jdField_a_of_type_JavaLangString;
          }
        }
      }
      ThreadManager.executeOnSubThread(new ReadInJoyCommentDataManager.11(this, (String)localObject1));
      return;
    }
    a(new ReadInJoyCommentDataManager.10(this, paramInt));
  }
  
  private void j(int paramInt)
  {
    s();
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentPBModule != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "fetchFamilyCommentList, fetchType : ", Integer.valueOf(paramInt), ", cookie : ", this.jdField_f_of_type_JavaLangString });
      String str;
      if (paramInt == 1) {
        str = "";
      } else {
        str = this.jdField_f_of_type_JavaLangString;
      }
      this.jdField_f_of_type_JavaLangString = str;
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentPBModule.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID, this.jdField_f_of_type_JavaLangString, 10, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityCommonCommentData);
      return;
    }
    a(new ReadInJoyCommentDataManager.12(this, paramInt));
  }
  
  private void m()
  {
    ReadInJoyUserInfoModule.a(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin(), null);
  }
  
  private void n()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      localList.clear();
    }
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_JavaLangString = "";
  }
  
  private void q()
  {
    List localList = this.jdField_b_of_type_JavaUtilList;
    if (localList != null) {
      localList.clear();
    }
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Long = 0L;
  }
  
  private void r()
  {
    List localList = this.jdField_d_of_type_JavaUtilList;
    if (localList != null) {
      localList.clear();
    }
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_d_of_type_Long = 0L;
    this.jdField_e_of_type_Boolean = false;
  }
  
  private void s()
  {
    if (!this.jdField_i_of_type_Boolean)
    {
      ReadInJoyCommentPBModule localReadInJoyCommentPBModule = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentPBModule;
      if (localReadInJoyCommentPBModule != null) {
        localReadInJoyCommentPBModule.a(this);
      }
    }
  }
  
  private void t()
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      if (((BaseCommentData)localIterator.next()).isComment())
      {
        j = 1;
        break label46;
      }
    }
    int j = 0;
    label46:
    if (j == 0) {
      u();
    }
  }
  
  private void u()
  {
    Object localObject = this.jdField_b_of_type_JavaUtilMap;
    if (localObject != null) {
      ((Map)localObject).clear();
    }
    localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null) {
      ((List)localObject).clear();
    }
    localObject = this.jdField_b_of_type_JavaUtilList;
    if (localObject != null) {
      ((List)localObject).clear();
    }
    localObject = this.jdField_d_of_type_JavaUtilList;
    if (localObject != null) {
      ((List)localObject).clear();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @VisibleForTesting
  int a(@NonNull CommentReportInfo paramCommentReportInfo)
  {
    paramCommentReportInfo = (CommentData)this.jdField_b_of_type_JavaUtilMap.get(paramCommentReportInfo.b());
    if (paramCommentReportInfo != null)
    {
      a(paramCommentReportInfo, -(paramCommentReportInfo.subCommentNum + 1));
      e(paramCommentReportInfo.commentId);
    }
    return 1;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getFirstCommentTotalCount | feedsType ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("; totalCount ");
    localStringBuilder.append(l);
    QLog.d("ReadInJoyCommentDataManager", 2, localStringBuilder.toString());
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
  
  public ReadInJoyCommentDataManager.CommentAnchor a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager$CommentAnchor;
  }
  
  public ReadInJoyCommentPBModule.Label a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentPBModule$Label;
  }
  
  @Nullable
  public BaseCommentData a(int paramInt, String paramString)
  {
    Object localObject1;
    if (paramInt == 1)
    {
      localObject1 = new CommentData();
    }
    else
    {
      if (paramInt != 2) {
        break label454;
      }
      localObject1 = new SubCommentData();
    }
    ((BaseCommentData)localObject1).level = paramInt;
    ((BaseCommentData)localObject1).anonymous = 0;
    ((BaseCommentData)localObject1).authorSelection = 0;
    ((BaseCommentData)localObject1).awesome = 0;
    ((BaseCommentData)localObject1).uin = RIJQQAppInterfaceUtil.a();
    ((BaseCommentData)localObject1).homepage = RIJJumpUtils.a(((BaseCommentData)localObject1).uin);
    ((BaseCommentData)localObject1).myself = 1;
    ((BaseCommentData)localObject1).like = 0;
    ((BaseCommentData)localObject1).disLike = 0;
    ((BaseCommentData)localObject1).likeCnt = 0;
    ((BaseCommentData)localObject1).rank = 0;
    ((BaseCommentData)localObject1).rowKey = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID;
    ((BaseCommentData)localObject1).contentSrc = this.jdField_a_of_type_Int;
    Object localObject3 = "";
    ((BaseCommentData)localObject1).authorComment = "";
    ((BaseCommentData)localObject1).commentTime = NetConnInfoCenter.getServerTime();
    Object localObject4 = ReadInJoyUserInfoModule.a(Long.parseLong(((BaseCommentData)localObject1).uin), null);
    if (localObject4 != null) {
      localObject2 = ((ReadInJoyUserInfo)localObject4).nick;
    } else {
      localObject2 = ReadInJoyUserInfoModule.a();
    }
    ((BaseCommentData)localObject1).nickName = ((String)localObject2);
    Object localObject2 = localObject3;
    if (localObject4 != null) {
      localObject2 = ((ReadInJoyUserInfo)localObject4).faceUrl;
    }
    ((BaseCommentData)localObject1).avatar = ((String)localObject2);
    try
    {
      paramString = new JSONObject(paramString);
      RIJCommentRptDataUtil.a(paramString, (BaseCommentData)localObject1);
      localObject2 = paramString.optJSONArray("linkList");
      if (localObject2 != null)
      {
        localObject3 = new ReadInJoyCommentDataManager.35(this).getType();
        ((BaseCommentData)localObject1).commentLinkDataList = ((List)new Gson().fromJson(((JSONArray)localObject2).toString(), (Type)localObject3));
      }
      if (paramInt == 2)
      {
        localObject2 = (SubCommentData)localObject1;
        localObject4 = paramString.getString("commentId");
        localObject3 = (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(localObject4);
        if ((localObject3 instanceof SubCommentData))
        {
          ((SubCommentData)localObject2).parentCommentId = ((SubCommentData)localObject3).parentCommentId;
        }
        else
        {
          if (!(localObject3 instanceof CommentData)) {
            break label445;
          }
          ((SubCommentData)localObject2).parentCommentId = ((BaseCommentData)localObject3).commentId;
        }
        if (paramString.optBoolean("isSecondReply", false))
        {
          ((SubCommentData)localObject2).repliedCommentId = ((String)localObject4);
          localObject4 = paramString.optString("replyUin");
          if (!TextUtils.isEmpty((CharSequence)localObject4))
          {
            ((SubCommentData)localObject2).repliedUserUin = ((String)localObject4);
            paramString = ReadInJoyUserInfoModule.a(Long.valueOf((String)localObject4).longValue(), null);
            if (paramString != null) {
              paramString = paramString.nick;
            } else {
              paramString = ReadInJoyUserInfoModule.a();
            }
            ((SubCommentData)localObject2).repliedUserNickname = paramString;
            ((SubCommentData)localObject2).repliedUserHomePage = RIJJumpUtils.a((String)localObject4);
            ((SubCommentData)localObject2).hasTarget = 1;
            if ((localObject3 instanceof SubCommentData))
            {
              RIJCommentRptDataUtil.a((SubCommentData)localObject2, (SubCommentData)localObject3);
              return localObject1;
              label445:
              return null;
            }
          }
        }
      }
      return localObject1;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    label454:
    return null;
  }
  
  public BaseCommentData a(String paramString)
  {
    return (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(paramString);
  }
  
  public CommonCommentData a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityCommonCommentData;
  }
  
  public GuideHelper a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentGuideGuideHelper;
  }
  
  @VisibleForTesting
  Pair<List<BaseCommentData>, List<BaseCommentData>> a(BaseCommentData paramBaseCommentData)
  {
    if (paramBaseCommentData == null) {
      return null;
    }
    String str = paramBaseCommentData.uin;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (TextUtils.isEmpty(str))
    {
      if ((paramBaseCommentData instanceof CommentData))
      {
        localArrayList1.add(paramBaseCommentData);
        a(paramBaseCommentData);
        return new Pair(localArrayList1, localArrayList2);
      }
      if ((paramBaseCommentData instanceof SubCommentData))
      {
        localArrayList2.add(paramBaseCommentData);
        b(paramBaseCommentData);
        return new Pair(localArrayList1, localArrayList2);
      }
      return null;
    }
    paramBaseCommentData = this.jdField_b_of_type_JavaUtilMap.values().iterator();
    while (paramBaseCommentData.hasNext())
    {
      BaseCommentData localBaseCommentData = (BaseCommentData)paramBaseCommentData.next();
      if ((localBaseCommentData != null) && (str.equals(localBaseCommentData.uin))) {
        if ((localBaseCommentData instanceof CommentData)) {
          localArrayList1.add(localBaseCommentData);
        } else if ((localBaseCommentData instanceof SubCommentData)) {
          localArrayList2.add(localBaseCommentData);
        }
      }
    }
    paramBaseCommentData = localArrayList1.iterator();
    while (paramBaseCommentData.hasNext()) {
      a((BaseCommentData)paramBaseCommentData.next());
    }
    paramBaseCommentData = localArrayList2.iterator();
    while (paramBaseCommentData.hasNext()) {
      b((BaseCommentData)paramBaseCommentData.next());
    }
    return new Pair(localArrayList1, localArrayList2);
  }
  
  public String a()
  {
    return this.jdField_i_of_type_JavaLangString;
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
  
  public List<CommentViewItem> a()
  {
    ArrayList localArrayList = new ArrayList();
    int j;
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      localObject = new ArrayList();
      j = 0;
      while (j < this.jdField_a_of_type_JavaUtilList.size())
      {
        CommentData localCommentData = (CommentData)this.jdField_b_of_type_JavaUtilMap.get(this.jdField_a_of_type_JavaUtilList.get(j));
        if ((localCommentData != null) && ((!localCommentData.isFamilyTopEntry()) || ((localCommentData.isFamilyTopEntry()) && (!ReadInJoyCommentHelper.a())))) {
          ((ArrayList)localObject).add(localCommentData);
        }
        j += 1;
      }
      if ((((ArrayList)localObject).size() > 0) && (this.jdField_f_of_type_Boolean)) {
        localArrayList.add(new CommentViewItem(1, null, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo));
      }
      localArrayList.addAll(a(1, new ArrayList((Collection)localObject)));
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getTotalHotCommentList ");
    ((StringBuilder)localObject).append(localArrayList);
    if (((StringBuilder)localObject).toString() != null) {
      j = localArrayList.size();
    } else {
      j = 0;
    }
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { Integer.valueOf(j) });
    return localArrayList;
  }
  
  public List<CommentViewItem> a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getCurrentFeedsTypeItemList | feedsType ");
    localStringBuilder.append(paramInt);
    QLog.d("ReadInJoyCommentDataManager", 1, localStringBuilder.toString());
    if (paramInt != 2)
    {
      if (paramInt != 3)
      {
        if (paramInt != 6) {
          return new ArrayList();
        }
        return c();
      }
      return a();
    }
    return b();
  }
  
  public List<CommentViewItem> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(paramString);
    if (paramString == null) {
      return localArrayList;
    }
    localArrayList.add(new CommentViewItem(0, paramString, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo));
    localArrayList.add(new CommentViewItem(3, paramString, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo));
    return localArrayList;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    s();
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentPBModule != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("loadFirstCommentList | feedsType : ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" contentSrc : ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append("; fetchType : ");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { ((StringBuilder)localObject).toString(), ", cookie : ", this.jdField_b_of_type_JavaLangString });
      if (paramInt2 == 1) {
        localObject = "";
      } else {
        localObject = this.jdField_b_of_type_JavaLangString;
      }
      this.jdField_b_of_type_JavaLangString = ((String)localObject);
      if (paramInt2 == 1)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager$CommentAnchor;
        if ((localObject != null) && (((ReadInJoyCommentDataManager.CommentAnchor)localObject).jdField_a_of_type_Boolean))
        {
          ThreadManager.executeOnSubThread(new ReadInJoyCommentDataManager.5(this, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager$CommentAnchor.jdField_a_of_type_JavaLangString));
          return;
        }
      }
      if (paramInt1 == 6)
      {
        ThreadManager.executeOnSubThread(new ReadInJoyCommentDataManager.6(this));
        return;
      }
      ThreadManager.executeOnSubThread(new ReadInJoyCommentDataManager.7(this, null));
      return;
    }
    a(new ReadInJoyCommentDataManager.4(this, paramInt2));
  }
  
  public void a(int paramInt, ReadInJoyCommentPBModule.ResponseCommentInfo paramResponseCommentInfo1, ReadInJoyCommentPBModule.ResponseCommentInfo paramResponseCommentInfo2, ReadInJoyCommentPBModule.ResponseExtraInfo paramResponseExtraInfo)
  {
    boolean bool1;
    if (paramInt == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2 = TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString);
    if (paramResponseCommentInfo1 == null) {
      paramResponseCommentInfo1 = new ReadInJoyCommentPBModule.ResponseCommentInfo();
    }
    if (paramResponseCommentInfo2 == null) {
      paramResponseCommentInfo2 = new ReadInJoyCommentPBModule.ResponseCommentInfo();
    }
    if (paramResponseExtraInfo == null) {
      paramResponseExtraInfo = new ReadInJoyCommentPBModule.ResponseExtraInfo();
    }
    if (bool1)
    {
      this.jdField_c_of_type_Boolean = paramResponseCommentInfo2.jdField_a_of_type_Boolean;
      this.jdField_d_of_type_Boolean = paramResponseCommentInfo1.jdField_a_of_type_Boolean;
      long l;
      if (paramResponseCommentInfo1.jdField_a_of_type_JavaUtilList != null) {
        l = paramResponseCommentInfo1.jdField_a_of_type_JavaUtilList.size();
      } else {
        l = 0L;
      }
      this.jdField_c_of_type_Long = l;
      this.jdField_d_of_type_JavaLangString = paramResponseCommentInfo2.jdField_a_of_type_JavaLangString;
      this.jdField_e_of_type_JavaLangString = paramResponseCommentInfo1.jdField_a_of_type_JavaLangString;
      a(this.jdField_h_of_type_JavaLangString, paramResponseExtraInfo.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentPBModule$Label = paramResponseExtraInfo.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentPBModule$Label;
      this.jdField_h_of_type_Boolean = paramResponseExtraInfo.jdField_b_of_type_Boolean;
      this.jdField_i_of_type_JavaLangString = paramResponseExtraInfo.jdField_b_of_type_JavaLangString;
      c(paramResponseCommentInfo1.jdField_a_of_type_JavaUtilList, paramResponseCommentInfo2.jdField_a_of_type_JavaUtilList);
    }
    if (bool2)
    {
      if (paramResponseExtraInfo.jdField_a_of_type_Long > 0L) {
        this.jdField_b_of_type_Long = paramResponseExtraInfo.jdField_a_of_type_Long;
      }
      this.jdField_a_of_type_Long = paramResponseExtraInfo.jdField_b_of_type_Long;
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager$CommentAnchor;
      if ((localObject != null) && (((ReadInJoyCommentDataManager.CommentAnchor)localObject).jdField_b_of_type_Boolean))
      {
        if (!a(paramResponseCommentInfo1.jdField_a_of_type_JavaUtilList)) {
          a(new ReadInJoyCommentDataManager.19(this));
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager$CommentAnchor.jdField_b_of_type_Boolean = false;
      }
      localObject = a(3);
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        paramInt = 3;
      }
      else
      {
        localObject = a(2);
        paramInt = 2;
      }
      if (paramInt == 3) {
        bool2 = this.jdField_d_of_type_Boolean;
      } else {
        bool2 = this.jdField_c_of_type_Boolean;
      }
      int j;
      if (paramResponseCommentInfo1.a()) {
        j = paramResponseCommentInfo1.jdField_a_of_type_JavaUtilList.size();
      } else {
        j = 0;
      }
      paramResponseCommentInfo1 = new StringBuilder();
      paramResponseCommentInfo1.append(", new size : ");
      int k;
      if (paramResponseCommentInfo2.a()) {
        k = paramResponseCommentInfo2.jdField_a_of_type_JavaUtilList.size();
      } else {
        k = 0;
      }
      paramResponseCommentInfo1.append(k);
      paramResponseCommentInfo1 = paramResponseCommentInfo1.toString();
      paramResponseCommentInfo2 = new StringBuilder();
      paramResponseCommentInfo2.append(this.jdField_b_of_type_Long);
      paramResponseCommentInfo2.append(" , hideCnt : ");
      paramResponseCommentInfo2.append(this.jdField_a_of_type_Long);
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "onLoadFirstCommentFinish, ret : ", Boolean.valueOf(bool1), ", hot size : ", Integer.valueOf(j), paramResponseCommentInfo1, ", totalCnt : ", paramResponseCommentInfo2.toString() });
      a(new ReadInJoyCommentDataManager.20(this, bool1, (List)localObject, bool2, paramInt));
      paramResponseCommentInfo1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager$CommentAnchor;
      if (paramResponseCommentInfo1 != null) {
        paramResponseCommentInfo1.a(false);
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentGuideGuideHelper.a(paramResponseExtraInfo.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentGuideGuideHelper.a(paramResponseExtraInfo.jdField_a_of_type_JavaLangString);
      return;
    }
    if (paramResponseCommentInfo2 != null) {
      paramResponseCommentInfo1 = a(2, new ArrayList(paramResponseCommentInfo2.jdField_a_of_type_JavaUtilList));
    } else {
      paramResponseCommentInfo1 = new ArrayList();
    }
    bool2 = this.jdField_a_of_type_Boolean;
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "onLoadMoreComment, ret : ", Boolean.valueOf(bool1), ", size : ", Integer.valueOf(paramResponseCommentInfo1.size()), ", hasNext : ", Boolean.valueOf(bool2) });
    a(new ReadInJoyCommentDataManager.21(this, bool1, paramResponseCommentInfo1));
  }
  
  public void a(int paramInt, ReadInJoyCommentPBModule.ResponseCommentInfo paramResponseCommentInfo, ReadInJoyCommentPBModule.ResponseExtraInfo paramResponseExtraInfo, CommentData paramCommentData)
  {
    boolean bool2 = TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString);
    paramCommentData = paramResponseCommentInfo;
    if (paramResponseCommentInfo == null) {
      paramCommentData = new ReadInJoyCommentPBModule.ResponseCommentInfo();
    }
    paramResponseCommentInfo = paramResponseExtraInfo;
    if (paramResponseExtraInfo == null) {
      paramResponseCommentInfo = new ReadInJoyCommentPBModule.ResponseExtraInfo();
    }
    boolean bool1;
    if (paramInt == 0)
    {
      this.jdField_c_of_type_Boolean = paramCommentData.jdField_a_of_type_Boolean;
      this.jdField_d_of_type_JavaLangString = paramCommentData.jdField_a_of_type_JavaLangString;
      c(null, paramCommentData.jdField_a_of_type_JavaUtilList);
      bool1 = true;
    }
    else
    {
      bool1 = false;
    }
    if (bool2)
    {
      if (paramResponseCommentInfo.jdField_a_of_type_Long > 0L) {
        this.jdField_b_of_type_Long = paramResponseCommentInfo.jdField_a_of_type_Long;
      }
      paramResponseCommentInfo = b();
      paramResponseExtraInfo = new StringBuilder();
      paramResponseExtraInfo.append(", new size : ");
      if (paramCommentData.jdField_a_of_type_JavaUtilList != null) {
        paramInt = paramCommentData.jdField_a_of_type_JavaUtilList.size();
      } else {
        paramInt = 0;
      }
      paramResponseExtraInfo.append(paramInt);
      QLog.d("ReadInJoyCommentDataManager", 2, new Object[] { "onLoadNewCommentFinish, ret : ", Boolean.valueOf(bool1), paramResponseExtraInfo.toString(), ", totalCnt : ", Long.valueOf(this.jdField_b_of_type_Long) });
      a(new ReadInJoyCommentDataManager.22(this, bool1, paramResponseCommentInfo));
      paramResponseCommentInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager$CommentAnchor;
      if (paramResponseCommentInfo != null) {
        paramResponseCommentInfo.a(false);
      }
    }
    else
    {
      if (paramCommentData.jdField_a_of_type_JavaUtilList != null) {
        paramResponseCommentInfo = a(2, new ArrayList(paramCommentData.jdField_a_of_type_JavaUtilList));
      } else {
        paramResponseCommentInfo = new ArrayList();
      }
      bool2 = this.jdField_c_of_type_Boolean;
      QLog.d("ReadInJoyCommentDataManager", 2, new Object[] { "onLoadMoreNewComment, ret : ", Boolean.valueOf(bool1), ", size : ", Integer.valueOf(paramResponseCommentInfo.size()), ", hasNext : ", Boolean.valueOf(bool2) });
      a(new ReadInJoyCommentDataManager.23(this, bool1, paramResponseCommentInfo, bool2));
    }
  }
  
  public void a(int paramInt, String paramString, ReadInJoyCommentPBModule.ResponseCommentInfo paramResponseCommentInfo, ReadInJoyCommentPBModule.ResponseExtraInfo paramResponseExtraInfo)
  {
    boolean bool3 = TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString);
    ReadInJoyCommentPBModule.ResponseCommentInfo localResponseCommentInfo = paramResponseCommentInfo;
    if (paramResponseCommentInfo == null) {
      localResponseCommentInfo = new ReadInJoyCommentPBModule.ResponseCommentInfo();
    }
    if (paramResponseExtraInfo == null) {
      new ReadInJoyCommentPBModule.ResponseExtraInfo();
    }
    paramResponseExtraInfo = null;
    paramResponseCommentInfo = null;
    boolean bool2 = true;
    boolean bool1;
    if (paramInt == 0)
    {
      this.jdField_b_of_type_Boolean = localResponseCommentInfo.jdField_a_of_type_Boolean;
      this.jdField_c_of_type_JavaLangString = localResponseCommentInfo.jdField_a_of_type_JavaLangString;
      if (localResponseCommentInfo.jdField_b_of_type_JavaUtilList != null)
      {
        paramResponseCommentInfo = localResponseCommentInfo.jdField_b_of_type_JavaUtilList.iterator();
        while (paramResponseCommentInfo.hasNext())
        {
          paramResponseExtraInfo = (SubCommentData)paramResponseCommentInfo.next();
          if (paramResponseExtraInfo != null)
          {
            if (TextUtils.isEmpty(paramResponseExtraInfo.parentCommentId)) {
              paramResponseExtraInfo.parentCommentId = paramString;
            }
            this.jdField_b_of_type_JavaUtilMap.put(paramResponseExtraInfo.commentId, paramResponseExtraInfo);
            this.jdField_c_of_type_JavaUtilList.add(paramResponseExtraInfo.commentId);
          }
        }
        paramResponseExtraInfo = (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(paramString);
        if (!this.jdField_g_of_type_Boolean)
        {
          paramResponseCommentInfo = paramResponseExtraInfo;
          if (paramResponseExtraInfo != null) {}
        }
        else
        {
          paramResponseCommentInfo = localResponseCommentInfo.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityCommentData;
          this.jdField_b_of_type_JavaUtilMap.put(paramString, paramResponseCommentInfo);
        }
        paramResponseCommentInfo = a(bool3, paramResponseCommentInfo, localResponseCommentInfo.jdField_b_of_type_JavaUtilList);
      }
      bool1 = true;
    }
    else
    {
      bool1 = false;
      paramResponseCommentInfo = paramResponseExtraInfo;
    }
    if (QLog.isColorLevel())
    {
      if (localResponseCommentInfo.jdField_b_of_type_JavaUtilList != null) {
        paramInt = localResponseCommentInfo.jdField_b_of_type_JavaUtilList.size();
      } else {
        paramInt = 0;
      }
      if ((localResponseCommentInfo == null) || (!localResponseCommentInfo.jdField_a_of_type_Boolean)) {
        bool2 = false;
      }
      QLog.d("ReadInJoyCommentDataManager", 2, new Object[] { "getSubCommentListResp ret : ", Boolean.valueOf(bool1), ", mainCommentID : ", paramString, ", size : ", Integer.valueOf(paramInt), ", hasNext : ", Boolean.valueOf(bool2), ", isFirstFetch : ", Boolean.valueOf(bool3) });
    }
    a(new ReadInJoyCommentDataManager.30(this, bool3, bool1, paramResponseCommentInfo));
  }
  
  public void a(CommentViewItem paramCommentViewItem)
  {
    if (paramCommentViewItem == null) {
      return;
    }
    paramCommentViewItem = paramCommentViewItem.a;
    if (paramCommentViewItem == null) {
      return;
    }
    Object localObject = this.jdField_b_of_type_JavaUtilMap;
    if (localObject != null) {
      ((Map)localObject).remove(paramCommentViewItem);
    }
    paramCommentViewItem = paramCommentViewItem.commentId;
    localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).contains(paramCommentViewItem)))
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramCommentViewItem);
      a(new ReadInJoyCommentDataManager.1(this));
    }
    localObject = this.jdField_b_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).contains(paramCommentViewItem)))
    {
      this.jdField_b_of_type_JavaUtilList.remove(paramCommentViewItem);
      a(new ReadInJoyCommentDataManager.2(this));
    }
    localObject = this.jdField_d_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).contains(paramCommentViewItem)))
    {
      this.jdField_d_of_type_JavaUtilList.remove(paramCommentViewItem);
      a(new ReadInJoyCommentDataManager.3(this));
    }
  }
  
  public void a(CommentViewItem paramCommentViewItem, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentSSOModule != null) && (paramCommentViewItem != null))
    {
      if (paramCommentViewItem.a == null) {
        return;
      }
      BaseCommentData localBaseCommentData = paramCommentViewItem.a;
      CommentData localCommentData;
      if ((localBaseCommentData instanceof CommentData))
      {
        localCommentData = (CommentData)localBaseCommentData;
        a(localCommentData, -(localCommentData.subCommentNum + 1));
        e(localBaseCommentData.commentId);
      }
      if ((localBaseCommentData instanceof SubCommentData))
      {
        localCommentData = (CommentData)this.jdField_b_of_type_JavaUtilMap.get(((SubCommentData)localBaseCommentData).parentCommentId);
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
      a(new ReadInJoyCommentDataManager.14(this, localBaseCommentData.getCommentLevel(), paramCommentViewItem, paramInt), false);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentSSOModule.a(localBaseCommentData, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    }
  }
  
  public void a(ReadInJoyCommentDataManager.CommentAnchor paramCommentAnchor)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setCommentAnchor | commentid : ");
    ((StringBuilder)localObject).append(paramCommentAnchor);
    if (((StringBuilder)localObject).toString() != null) {
      localObject = paramCommentAnchor.jdField_a_of_type_JavaLangString;
    } else {
      localObject = "";
    }
    QLog.d("ReadInJoyCommentDataManager", 1, (String)localObject);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager$CommentAnchor = paramCommentAnchor;
  }
  
  public void a(ReadInJoyCommentDataManager.OnDataChangeListener paramOnDataChangeListener)
  {
    try
    {
      boolean bool = this.jdField_e_of_type_JavaUtilList.contains(paramOnDataChangeListener);
      if (bool) {
        return;
      }
      this.jdField_e_of_type_JavaUtilList.add(paramOnDataChangeListener);
      return;
    }
    finally {}
  }
  
  public void a(BaseCommentData paramBaseCommentData, String paramString, int paramInt)
  {
    paramBaseCommentData.commentId = paramString;
    this.jdField_b_of_type_JavaUtilMap.put(paramBaseCommentData.commentId, paramBaseCommentData);
    if ((paramBaseCommentData instanceof CommentData))
    {
      if (paramInt == 6)
      {
        if (this.jdField_d_of_type_JavaUtilList == null) {
          this.jdField_d_of_type_JavaUtilList = new ArrayList();
        }
        if (this.jdField_d_of_type_JavaUtilList.size() == 0)
        {
          this.jdField_d_of_type_JavaUtilList.add(paramBaseCommentData.commentId);
        }
        else
        {
          paramString = (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(this.jdField_d_of_type_JavaUtilList.get(0));
          if ((paramString != null) && (paramString.isBanner()))
          {
            if (this.jdField_d_of_type_JavaUtilList.size() < 2) {
              this.jdField_d_of_type_JavaUtilList.add(paramBaseCommentData.commentId);
            } else {
              this.jdField_d_of_type_JavaUtilList.add(1, paramBaseCommentData.commentId);
            }
          }
          else {
            this.jdField_d_of_type_JavaUtilList.add(0, paramBaseCommentData.commentId);
          }
          QLog.d("ReadInJoyCommentDataManager", 2, "onCreateCommentResult | familyCommentFeeds");
        }
      }
      else
      {
        paramInt = 2;
      }
      if (this.jdField_b_of_type_JavaUtilList.size() == 0)
      {
        this.jdField_b_of_type_JavaUtilList.add(paramBaseCommentData.commentId);
      }
      else
      {
        paramString = (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(this.jdField_b_of_type_JavaUtilList.get(0));
        if ((paramString != null) && (paramString.isBanner()))
        {
          if (this.jdField_b_of_type_JavaUtilList.size() < 2) {
            this.jdField_b_of_type_JavaUtilList.add(paramBaseCommentData.commentId);
          } else {
            this.jdField_b_of_type_JavaUtilList.add(1, paramBaseCommentData.commentId);
          }
        }
        else {
          this.jdField_b_of_type_JavaUtilList.add(0, paramBaseCommentData.commentId);
        }
      }
      if ((!this.jdField_d_of_type_Boolean) && (!this.jdField_a_of_type_JavaUtilList.contains(paramBaseCommentData.commentId))) {
        this.jdField_a_of_type_JavaUtilList.add(paramBaseCommentData.commentId);
      }
      boolean bool;
      if ((paramInt != 3) && (paramInt != 6)) {
        bool = false;
      } else {
        bool = true;
      }
      a((CommentData)paramBaseCommentData, 1);
      int j;
      if (paramInt == 6) {
        j = 4;
      } else {
        j = 2;
      }
      paramString = new StringBuilder();
      paramString.append("onCreateCommentResult | createComment feedsType ");
      paramString.append(j);
      QLog.d("ReadInJoyCommentDataManager", 2, paramString.toString());
      a(new ReadInJoyCommentDataManager.39(this, new CommentViewItem(j, 0, paramBaseCommentData, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo), bool, paramInt));
      return;
    }
    if ((paramBaseCommentData instanceof SubCommentData))
    {
      this.jdField_c_of_type_JavaUtilList.add(0, paramBaseCommentData.commentId);
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "add new sub comment, now size : ", Integer.valueOf(this.jdField_c_of_type_JavaUtilList.size()) });
      Object localObject = this.jdField_b_of_type_JavaUtilMap;
      paramString = (SubCommentData)paramBaseCommentData;
      localObject = (BaseCommentData)((Map)localObject).get(paramString.parentCommentId);
      paramString = (CommentData)this.jdField_b_of_type_JavaUtilMap.get(paramString.parentCommentId);
      if (paramString != null)
      {
        paramString.subCommentNum += 1;
        a(paramString, 1);
        a(new ReadInJoyCommentDataManager.40(this, paramBaseCommentData));
      }
    }
  }
  
  public void a(CommonCommentData paramCommonCommentData)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityCommonCommentData = paramCommonCommentData;
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onSinkCommentResult: id[");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("] opType[");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("] success[");
    ((StringBuilder)localObject).append(paramBoolean1);
    ((StringBuilder)localObject).append("] overtimes[");
    ((StringBuilder)localObject).append(paramBoolean2);
    ((StringBuilder)localObject).append("]");
    QLog.d("ReadInJoyCommentDataManager", 1, ((StringBuilder)localObject).toString());
    boolean bool;
    if (paramInt == 3) {
      bool = true;
    } else {
      bool = false;
    }
    if (paramBoolean1)
    {
      localObject = (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(paramString);
      if (localObject == null) {
        return;
      }
      ((BaseCommentData)localObject).isAuthorSticky = false;
      ((BaseCommentData)localObject).isAuthorBottom = bool;
      if (bool)
      {
        if (this.jdField_d_of_type_Boolean)
        {
          this.jdField_b_of_type_JavaUtilMap.remove(paramString);
        }
        else
        {
          this.jdField_a_of_type_JavaUtilList.remove(paramString);
          this.jdField_a_of_type_JavaUtilList.add(paramString);
        }
        paramInt = 2131718295;
      }
      else
      {
        this.jdField_a_of_type_JavaUtilList.remove(paramString);
        localObject = a();
        paramInt = ((Integer)((Pair)localObject).first).intValue();
        int j = ((Integer)((Pair)localObject).second).intValue();
        if (paramInt >= 10)
        {
          this.jdField_a_of_type_JavaUtilList.add(9, paramString);
        }
        else if (paramInt >= 2)
        {
          localObject = this.jdField_a_of_type_JavaUtilList;
          ((List)localObject).add(((List)localObject).size() - j - 1, paramString);
        }
        else if (j > 0)
        {
          localObject = this.jdField_a_of_type_JavaUtilList;
          ((List)localObject).add(((List)localObject).size() - j, paramString);
        }
        else
        {
          this.jdField_a_of_type_JavaUtilList.add(paramString);
        }
        paramInt = 2131718306;
      }
      a(new ReadInJoyCommentDataManager.41(this, a()));
      QQToast.a(BaseApplicationImpl.context, 2, HardCodeUtil.a(paramInt), 0).a();
      return;
    }
    if (bool)
    {
      if (paramBoolean2) {
        paramInt = 2131718294;
      } else {
        paramInt = 2131718293;
      }
    }
    else {
      paramInt = 2131718305;
    }
    QQToast.a(BaseApplicationImpl.context, HardCodeUtil.a(paramInt), 0).a();
  }
  
  public void a(String paramString1, String paramString2)
  {
    d();
    a(1, paramString1, paramString2);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setTitleShowData | showFamilyTitle : ");
    localStringBuilder.append(this.jdField_f_of_type_Boolean);
    QLog.d("ReadInJoyCommentDataManager", 2, localStringBuilder.toString());
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString, @NonNull CommentReportInfo paramCommentReportInfo)
  {
    c(paramBoolean);
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "onCommentReportResult(): success : ", Boolean.valueOf(paramBoolean), ", retCode : ", Integer.valueOf(paramInt), ", retMsg : ", paramString, "reportInfo :", paramCommentReportInfo });
    if (paramBoolean)
    {
      if (!TextUtils.isEmpty(paramCommentReportInfo.c())) {
        paramInt = b(paramCommentReportInfo);
      } else {
        paramInt = a(paramCommentReportInfo);
      }
    }
    else {
      paramInt = 0;
    }
    a(new ReadInJoyCommentDataManager.18(this, paramInt, paramBoolean, paramCommentReportInfo), false);
  }
  
  public void a(boolean paramBoolean1, CommentViewItem paramCommentViewItem, int paramInt, String paramString, boolean paramBoolean2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAuthorDeleteCommentResult | bSuccess ");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append(" errMsg ");
    localStringBuilder.append(paramString);
    QLog.d("ReadInJoyCommentDataManager", 1, localStringBuilder.toString());
    if (paramCommentViewItem == null) {
      return;
    }
    paramString = paramCommentViewItem.a;
    if (paramString == null) {
      return;
    }
    if (paramBoolean1)
    {
      QQToast.a(BaseApplication.getContext(), 2, HardCodeUtil.a(2131712893), 0).a();
      a(paramString);
      b(paramString);
      a(new ReadInJoyCommentDataManager.31(this, paramString.getCommentLevel(), paramCommentViewItem, paramInt), false);
      return;
    }
    paramCommentViewItem = BaseApplicationImpl.context;
    if (paramBoolean2) {
      paramInt = 2131718288;
    } else {
      paramInt = 2131718287;
    }
    QQToast.a(paramCommentViewItem, paramBoolean2 ^ true, HardCodeUtil.a(paramInt), 0).a();
  }
  
  public void a(boolean paramBoolean1, CommentViewItem paramCommentViewItem, String paramString, boolean paramBoolean2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onBlockUserCommentResult | bSuccess ");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append(" errMsg ");
    localStringBuilder.append(paramString);
    QLog.d("ReadInJoyCommentDataManager", 1, localStringBuilder.toString());
    if (paramCommentViewItem == null) {
      return;
    }
    paramCommentViewItem = paramCommentViewItem.a;
    if (paramCommentViewItem == null) {
      return;
    }
    a(paramBoolean1, paramBoolean2, paramString);
    if (paramBoolean1)
    {
      paramString = a(paramCommentViewItem);
      a(new ReadInJoyCommentDataManager.43(this, paramCommentViewItem.getCommentLevel(), paramString), false);
    }
  }
  
  public void a(boolean paramBoolean, BaseCommentData paramBaseCommentData, int paramInt1, int paramInt2)
  {
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "onLikeOrDislikeCommentResult ret : ", Boolean.valueOf(paramBoolean), ", commentData : ", paramBaseCommentData, ", opType ; ", Integer.valueOf(paramInt1), ", opValue : ", Integer.valueOf(paramInt2) });
    a(new ReadInJoyCommentDataManager.32(this, paramBoolean, paramBaseCommentData, paramInt1, paramInt2));
    Object localObject = QBaseActivity.sTopActivity;
    if (localObject != null)
    {
      localObject = ((Activity)localObject).getIntent().getBundleExtra("bundle");
      if (localObject != null) {
        ReadInJoyLogicEngineEventDispatcher.a().a(paramBoolean, this.jdField_a_of_type_JavaLangString, paramBaseCommentData.commentId, String.valueOf(paramInt2), "onCommentLike", ((Bundle)localObject).getInt("seq"));
      }
    }
  }
  
  public void a(boolean paramBoolean, BaseCommentData paramBaseCommentData, String paramString)
  {
    if (paramBaseCommentData == null) {
      return;
    }
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "del comment resp, ret : ", Boolean.valueOf(paramBoolean), ", data : ", paramBaseCommentData });
    if (paramBoolean)
    {
      QQToast.a(BaseApplication.getContext(), 2, HardCodeUtil.a(2131712893), 0).a();
      paramString = QBaseActivity.sTopActivity.getIntent().getBundleExtra("bundle");
      int j;
      if ((paramBaseCommentData instanceof CommentData)) {
        j = 1 + ((CommentData)paramBaseCommentData).subCommentNum;
      } else {
        j = 1;
      }
      if (paramString != null) {
        ReadInJoyLogicEngineEventDispatcher.a().a(true, this.jdField_a_of_type_JavaLangString, paramBaseCommentData.commentId, "onCommentDelete", paramString.getInt("seq"), j);
      }
    }
    else
    {
      QQToast.a(BaseApplication.getContext(), 1, paramString, 0).a();
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      QQToast.a(BaseApplicationImpl.getContext(), 2, HardCodeUtil.a(2131718317), 0).a();
      return;
    }
    BaseApplication localBaseApplication = BaseApplicationImpl.context;
    if (TextUtils.isEmpty(paramString)) {
      paramString = HardCodeUtil.a(2131718316);
    }
    QQToast.a(localBaseApplication, 1, paramString, 0).a();
  }
  
  public boolean a()
  {
    return this.jdField_h_of_type_Boolean;
  }
  
  public boolean a(ReadInJoyCommentDataManager.OnDataChangeListener paramOnDataChangeListener)
  {
    try
    {
      boolean bool = this.jdField_e_of_type_JavaUtilList.remove(paramOnDataChangeListener);
      return bool;
    }
    finally
    {
      paramOnDataChangeListener = finally;
      throw paramOnDataChangeListener;
    }
  }
  
  public void a_(String paramString, int paramInt)
  {
    paramString = (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      paramString.disLike = paramInt;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentSSOModule.a(paramString, 1, paramInt, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
  }
  
  public void ao_()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this);
  }
  
  public void ap_()
  {
    try
    {
      this.jdField_e_of_type_JavaUtilList.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @VisibleForTesting
  int b(@NonNull CommentReportInfo paramCommentReportInfo)
  {
    CommentData localCommentData = (CommentData)this.jdField_b_of_type_JavaUtilMap.get(paramCommentReportInfo.b());
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
          if (localSubCommentData.commentId.equalsIgnoreCase(paramCommentReportInfo.c())) {
            localList.remove(localSubCommentData);
          }
        }
      }
    }
    a(localCommentData, -1);
    this.jdField_c_of_type_JavaUtilList.remove(paramCommentReportInfo.c());
    return 2;
  }
  
  public List<CommentViewItem> b()
  {
    ArrayList localArrayList = new ArrayList();
    int j;
    if (this.jdField_b_of_type_JavaUtilList.size() > 0)
    {
      localObject = new ArrayList();
      j = 0;
      while (j < this.jdField_b_of_type_JavaUtilList.size())
      {
        CommentData localCommentData = (CommentData)this.jdField_b_of_type_JavaUtilMap.get(this.jdField_b_of_type_JavaUtilList.get(j));
        if ((localCommentData != null) && ((!localCommentData.isFamilyTopEntry()) || ((localCommentData.isFamilyTopEntry()) && (!ReadInJoyCommentHelper.a())))) {
          ((ArrayList)localObject).add(localCommentData);
        }
        j += 1;
      }
      if ((((ArrayList)localObject).size() > 0) && (this.jdField_f_of_type_Boolean)) {
        localArrayList.add(new CommentViewItem(2, null, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo));
      }
      localArrayList.addAll(a(2, new ArrayList((Collection)localObject)));
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getTotalNewCommentList ");
    ((StringBuilder)localObject).append(localArrayList);
    if (((StringBuilder)localObject).toString() != null) {
      j = localArrayList.size();
    } else {
      j = 0;
    }
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { Integer.valueOf(j) });
    return localArrayList;
  }
  
  public List<CommentViewItem> b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = (CommentData)this.jdField_b_of_type_JavaUtilMap.get(paramString);
    if (paramString == null) {
      return localArrayList;
    }
    localArrayList.add(new CommentViewItem(0, paramString, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo));
    localArrayList.add(new CommentViewItem(3, paramString, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo));
    localArrayList.addAll(b(0, this.jdField_c_of_type_JavaUtilList));
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "get all sub comment list , parentID : ", paramString, ", sub list size : ", Integer.valueOf(this.jdField_c_of_type_JavaUtilList.size()) });
    return localArrayList;
  }
  
  public void b()
  {
    this.jdField_i_of_type_Boolean = true;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
    ((StringBuilder)localObject).append(", pbModuel=");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentPBModule);
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "CommentDataManager destroy, articleInfo=", ((StringBuilder)localObject).toString() });
    localObject = this.jdField_b_of_type_JavaUtilMap;
    if (localObject != null) {
      ((Map)localObject).clear();
    }
    n();
    q();
    r();
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = "";
    localObject = this.jdField_a_of_type_ComTencentUtilLongSparseArray;
    if (localObject != null) {
      ((LongSparseArray)localObject).a();
    }
    localObject = this.jdField_e_of_type_JavaUtilList;
    if (localObject != null) {
      ((List)localObject).clear();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentPBModule;
    if (localObject != null) {
      ((ReadInJoyCommentPBModule)localObject).unInitialize();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentSSOModule;
    if (localObject != null) {
      ((ReadInJoyCommentSSOModule)localObject).a();
    }
    ao_();
  }
  
  public void b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadMoreComment | with feedsType : ");
    localStringBuilder.append(paramInt);
    QLog.d("ReadInJoyCommentDataManager", 1, localStringBuilder.toString());
    if (paramInt != 2)
    {
      if ((paramInt != 3) && (paramInt != 5))
      {
        if (paramInt != 6) {
          return;
        }
        j(2);
        return;
      }
      i(2);
      return;
    }
    h(2);
  }
  
  public void b(int paramInt, ReadInJoyCommentPBModule.ResponseCommentInfo paramResponseCommentInfo, ReadInJoyCommentPBModule.ResponseExtraInfo paramResponseExtraInfo, CommentData paramCommentData)
  {
    boolean bool2 = TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString);
    paramCommentData = paramResponseCommentInfo;
    if (paramResponseCommentInfo == null) {
      paramCommentData = new ReadInJoyCommentPBModule.ResponseCommentInfo();
    }
    paramResponseCommentInfo = paramResponseExtraInfo;
    if (paramResponseExtraInfo == null) {
      paramResponseCommentInfo = new ReadInJoyCommentPBModule.ResponseExtraInfo();
    }
    boolean bool1;
    if (paramInt == 0)
    {
      this.jdField_d_of_type_Boolean = paramCommentData.jdField_a_of_type_Boolean;
      this.jdField_e_of_type_JavaLangString = paramCommentData.jdField_a_of_type_JavaLangString;
      a(this.jdField_h_of_type_JavaLangString, paramResponseCommentInfo.jdField_a_of_type_Boolean);
      c(paramCommentData.jdField_a_of_type_JavaUtilList, null);
      bool1 = true;
    }
    else
    {
      bool1 = false;
    }
    if (bool2)
    {
      if ((bool1) && ((paramCommentData.jdField_a_of_type_JavaUtilList == null) || (paramCommentData.jdField_a_of_type_JavaUtilList.isEmpty())))
      {
        if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
        {
          QLog.d("ReadInJoyCommentDataManager", 1, "switchCommentFeedsType | hot is empty or first change to new : ");
          h(1);
          return;
        }
        a(new ReadInJoyCommentDataManager.24(this, a(3)));
        return;
      }
      paramResponseCommentInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager$CommentAnchor;
      if ((paramResponseCommentInfo != null) && (paramResponseCommentInfo.jdField_b_of_type_Boolean))
      {
        if (!a(paramCommentData.jdField_a_of_type_JavaUtilList)) {
          a(new ReadInJoyCommentDataManager.25(this));
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager$CommentAnchor.jdField_b_of_type_Boolean = false;
      }
      paramResponseCommentInfo = a();
      if (paramCommentData.jdField_a_of_type_JavaUtilList != null) {
        paramInt = paramCommentData.jdField_a_of_type_JavaUtilList.size();
      } else {
        paramInt = 0;
      }
      paramResponseExtraInfo = new StringBuilder();
      paramResponseExtraInfo.append(", hot size : ");
      int j;
      if (paramCommentData.jdField_a_of_type_JavaUtilList != null) {
        j = paramCommentData.jdField_a_of_type_JavaUtilList.size();
      } else {
        j = 0;
      }
      paramResponseExtraInfo.append(j);
      QLog.d("ReadInJoyCommentDataManager", 2, new Object[] { "onLoadHotCommentFinish, ret : ", Boolean.valueOf(bool1), ", hot size : ", Integer.valueOf(paramInt), paramResponseExtraInfo.toString(), ", totalCnt : ", Long.valueOf(this.jdField_c_of_type_Long) });
      a(new ReadInJoyCommentDataManager.26(this, bool1, paramResponseCommentInfo));
      paramResponseCommentInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentDataManager$CommentAnchor;
      if (paramResponseCommentInfo != null) {
        paramResponseCommentInfo.a(false);
      }
    }
    else
    {
      if (paramCommentData.jdField_a_of_type_JavaUtilList != null) {
        paramResponseCommentInfo = a(1, new ArrayList(paramCommentData.jdField_a_of_type_JavaUtilList));
      } else {
        paramResponseCommentInfo = new ArrayList();
      }
      bool2 = this.jdField_d_of_type_Boolean;
      QLog.d("ReadInJoyCommentDataManager", 2, new Object[] { "onLoadMoreHotComment, ret : ", Boolean.valueOf(bool1), ", size : ", Integer.valueOf(paramResponseCommentInfo.size()), ", hasNext : ", Boolean.valueOf(bool2) });
      a(new ReadInJoyCommentDataManager.27(this, bool1, paramResponseCommentInfo, bool2));
    }
  }
  
  public void b(CommentViewItem paramCommentViewItem)
  {
    if (paramCommentViewItem != null)
    {
      if (paramCommentViewItem.a == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("blockUserComment | ");
      localStringBuilder.append(paramCommentViewItem.a);
      QLog.d("ReadInJoyCommentDataManager", 1, localStringBuilder.toString());
      RIJCommentNetworkHelper.a.a(paramCommentViewItem, this);
    }
  }
  
  public void b(CommentViewItem paramCommentViewItem, int paramInt)
  {
    if (paramCommentViewItem != null)
    {
      if (paramCommentViewItem.a == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("authorDeleteComment | ");
      localStringBuilder.append(paramCommentViewItem.a);
      QLog.d("ReadInJoyCommentDataManager", 1, localStringBuilder.toString());
      RIJCommentNetworkHelper.a.a(this.jdField_a_of_type_Int, paramCommentViewItem, paramInt, this);
    }
  }
  
  public void b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentGuideGuideHelper.a(paramAbsBaseArticleInfo);
  }
  
  public void b(String paramString)
  {
    a(2, paramString, null);
  }
  
  public void b(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onUpdateCommentStickyResult: id[");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("] success[");
    ((StringBuilder)localObject).append(paramBoolean1);
    ((StringBuilder)localObject).append("] overtimes[");
    ((StringBuilder)localObject).append(paramBoolean2);
    ((StringBuilder)localObject).append("]");
    localObject = ((StringBuilder)localObject).toString();
    boolean bool = true;
    QLog.d("ReadInJoyCommentDataManager", 1, (String)localObject);
    int j;
    if (paramInt == 1) {
      j = 1;
    } else {
      j = 0;
    }
    if (paramBoolean1)
    {
      localObject = (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(paramString);
      if (localObject == null) {
        return;
      }
      if (paramInt == 1) {
        paramBoolean1 = bool;
      } else {
        paramBoolean1 = false;
      }
      ((BaseCommentData)localObject).isAuthorSticky = paramBoolean1;
      ((BaseCommentData)localObject).isAuthorBottom = false;
      if (j != 0)
      {
        this.jdField_a_of_type_JavaUtilList.remove(paramString);
        this.jdField_a_of_type_JavaUtilList.add(b(), paramString);
        paramInt = 2131718300;
      }
      else
      {
        this.jdField_a_of_type_JavaUtilList.remove(paramString);
        localObject = a();
        paramInt = ((Integer)((Pair)localObject).first).intValue();
        j = ((Integer)((Pair)localObject).second).intValue();
        if (paramInt >= 10)
        {
          this.jdField_a_of_type_JavaUtilList.add(9, paramString);
        }
        else if (j > 0)
        {
          localObject = this.jdField_a_of_type_JavaUtilList;
          ((List)localObject).add(((List)localObject).size() - j, paramString);
        }
        else
        {
          this.jdField_a_of_type_JavaUtilList.add(paramString);
        }
        paramInt = 2131718304;
      }
      a(new ReadInJoyCommentDataManager.42(this, a()));
      QQToast.a(BaseApplicationImpl.context, 2, HardCodeUtil.a(paramInt), 0).a();
      return;
    }
    if (j != 0)
    {
      if (paramBoolean2) {
        paramInt = 2131718299;
      } else {
        paramInt = 2131718298;
      }
    }
    else {
      paramInt = 2131718303;
    }
    QQToast.a(BaseApplicationImpl.context, paramInt, 0).a();
  }
  
  public void b(String paramString1, String paramString2, int paramInt)
  {
    BaseCommentData localBaseCommentData = (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(paramString1);
    CommentReportInfo localCommentReportInfo = new CommentReportInfo();
    localCommentReportInfo.a(paramInt);
    localCommentReportInfo.d(paramString2);
    if ((localBaseCommentData instanceof CommentData))
    {
      localCommentReportInfo.a(localBaseCommentData.rowKey);
      localCommentReportInfo.b(localBaseCommentData.commentId);
      localCommentReportInfo.c("");
    }
    else if ((localBaseCommentData instanceof SubCommentData))
    {
      localCommentReportInfo.a(localBaseCommentData.rowKey);
      localCommentReportInfo.b(((SubCommentData)localBaseCommentData).parentCommentId);
      localCommentReportInfo.c(localBaseCommentData.commentId);
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(this);
    ReadInJoyLogicEngine.a().a(localCommentReportInfo);
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "commentID : ", paramString1, ", reportReason : ", "reportInfo :", localCommentReportInfo });
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if ((BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(paramString) == null) {
      return;
    }
    paramString = new FirstCommentSinkData(paramString, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID, this.jdField_a_of_type_Int, "");
    int j;
    if (paramBoolean) {
      j = 3;
    } else {
      j = 2;
    }
    paramString.a(j);
    RIJCommentNetworkHelper.a.a(paramString, this);
  }
  
  public void b(boolean paramBoolean, BaseCommentData paramBaseCommentData, String paramString)
  {
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "onReportCommentResp ret : ", Boolean.valueOf(paramBoolean), ", commentData : ", paramBaseCommentData, ", extraData : ", paramString });
  }
  
  public void b_(String paramString, int paramInt)
  {
    paramString = (BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(paramString);
    if (paramString != null)
    {
      paramString.like = paramInt;
      int k = paramString.likeCnt;
      int j;
      if (paramString.isLiked()) {
        j = 1;
      } else {
        j = -1;
      }
      paramString.likeCnt = (k + j);
      if (paramString.likeCnt < 0) {
        paramString.likeCnt = 0;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentSSOModule.a(paramString, 0, paramInt, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
  }
  
  public List<CommentViewItem> c()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.jdField_d_of_type_JavaUtilList;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = new ArrayList();
      Iterator localIterator = this.jdField_d_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (String)localIterator.next();
        localObject2 = (CommentData)this.jdField_b_of_type_JavaUtilMap.get(localObject2);
        if (localObject2 != null) {
          ((ArrayList)localObject1).add(localObject2);
        }
      }
      if ((((ArrayList)localObject1).size() > 0) && (this.jdField_f_of_type_Boolean))
      {
        QLog.d("ReadInJoyCommentDataManager", 1, "getTotalFamilyCommentList | showTitle dont showSwitch");
        localArrayList.add(new CommentViewItem(2, null, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo));
      }
      localArrayList.addAll(a(4, new ArrayList((Collection)localObject1)));
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("getTotalFamilyCommentList ");
    ((StringBuilder)localObject1).append(localArrayList);
    int j;
    if (((StringBuilder)localObject1).toString() != null) {
      j = localArrayList.size();
    } else {
      j = 0;
    }
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { Integer.valueOf(j) });
    return localArrayList;
  }
  
  public void c(int paramInt, ReadInJoyCommentPBModule.ResponseCommentInfo paramResponseCommentInfo, ReadInJoyCommentPBModule.ResponseExtraInfo paramResponseExtraInfo, CommentData paramCommentData)
  {
    paramCommentData = paramResponseCommentInfo;
    if (paramResponseCommentInfo == null) {
      paramCommentData = new ReadInJoyCommentPBModule.ResponseCommentInfo();
    }
    paramResponseCommentInfo = paramResponseExtraInfo;
    if (paramResponseExtraInfo == null) {
      paramResponseCommentInfo = new ReadInJoyCommentPBModule.ResponseExtraInfo();
    }
    boolean bool2 = TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString);
    int j = 0;
    boolean bool1;
    if (paramInt == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (bool1)
    {
      this.jdField_f_of_type_JavaLangString = paramCommentData.jdField_a_of_type_JavaLangString;
      this.jdField_e_of_type_Boolean = paramCommentData.jdField_a_of_type_Boolean;
      d(paramCommentData.jdField_a_of_type_JavaUtilList, this.jdField_d_of_type_JavaUtilList);
      QLog.d("ReadInJoyCommentDataManager", 2, "onFetchFamilyCommentListResult succeed ");
    }
    else
    {
      QLog.d("ReadInJoyCommentDataManager", 2, "onFetchFamilyCommentListResult failed ");
    }
    if (bool2)
    {
      long l;
      if (paramResponseCommentInfo != null) {
        l = paramResponseCommentInfo.jdField_a_of_type_Long;
      } else {
        l = 0L;
      }
      this.jdField_d_of_type_Long = l;
      paramResponseCommentInfo = new StringBuilder();
      paramInt = j;
      if (paramCommentData.a()) {
        paramInt = paramCommentData.jdField_a_of_type_JavaUtilList.size();
      }
      paramResponseCommentInfo.append(paramInt);
      paramResponseCommentInfo.append(", mFamilyCommentCnt : ");
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "onLoadFirstFaimilyCommentFinish, ret : ", Boolean.valueOf(bool1), ",  size : ", paramResponseCommentInfo.toString(), Long.valueOf(this.jdField_d_of_type_Long) });
      a(new ReadInJoyCommentDataManager.28(this, bool1, c()));
      return;
    }
    if (paramCommentData != null) {
      paramResponseCommentInfo = a(4, new ArrayList(paramCommentData.jdField_a_of_type_JavaUtilList));
    } else {
      paramResponseCommentInfo = new ArrayList();
    }
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "onLoadMoreFamilyComment, ret : ", Boolean.valueOf(bool1), ", size : ", Integer.valueOf(paramResponseCommentInfo.size()), ", hasNext : ", Boolean.valueOf(this.jdField_e_of_type_Boolean) });
    a(new ReadInJoyCommentDataManager.29(this, bool1, paramResponseCommentInfo));
  }
  
  public void c(@NotNull CommentViewItem paramCommentViewItem)
  {
    if (paramCommentViewItem != null)
    {
      if (paramCommentViewItem.a == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("patrolArbitration | ");
      localStringBuilder.append(paramCommentViewItem.a);
      QLog.d("ReadInJoyCommentDataManager", 1, localStringBuilder.toString());
      RIJCommentNetworkHelper.a.b(paramCommentViewItem, this);
    }
  }
  
  public void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    BaseCommentData localBaseCommentData = a(1, paramString);
    if (localBaseCommentData == null) {
      return;
    }
    FirstCommentCreateData localFirstCommentCreateData = new FirstCommentCreateData(this.jdField_a_of_type_Int, "");
    localFirstCommentCreateData.b(this.jdField_h_of_type_JavaLangString);
    localFirstCommentCreateData.c(this.jdField_g_of_type_JavaLangString);
    localFirstCommentCreateData.a(localBaseCommentData.commentContent);
    localFirstCommentCreateData.a(localBaseCommentData.commentRptDataList);
    localFirstCommentCreateData.b(localBaseCommentData.commentLinkDataList);
    RIJCommentNetworkWrapper.INSTANCE.createFirstComment(localFirstCommentCreateData, new ReadInJoyCommentDataManager.17(this), paramString, 2, true);
  }
  
  public void c(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if ((BaseCommentData)this.jdField_b_of_type_JavaUtilMap.get(paramString) == null) {
      return;
    }
    paramString = new FirstCommentStickyData(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID, this.jdField_a_of_type_Int, "", paramString);
    int j;
    if (paramBoolean) {
      j = 1;
    } else {
      j = 2;
    }
    paramString.a(j);
    RIJCommentNetworkHelper.a.a(paramString, this);
  }
  
  public void c_(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    SubCommentData localSubCommentData = (SubCommentData)a(2, paramString);
    if (localSubCommentData == null) {
      return;
    }
    SubCommentCreateData localSubCommentCreateData = new SubCommentCreateData(this.jdField_a_of_type_Int, "");
    localSubCommentCreateData.a(localSubCommentData.parentCommentId);
    localSubCommentCreateData.b(this.jdField_h_of_type_JavaLangString);
    localSubCommentCreateData.c(this.jdField_g_of_type_JavaLangString);
    localSubCommentCreateData.d(localSubCommentData.commentContent);
    localSubCommentCreateData.a(localSubCommentData.commentRptDataList);
    localSubCommentCreateData.b(localSubCommentData.commentLinkDataList);
    if (localSubCommentData.hasTarget()) {
      localSubCommentCreateData.e(localSubCommentData.repliedCommentId);
    }
    try
    {
      localSubCommentCreateData.a(Long.parseLong(localSubCommentData.repliedUserUin));
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label132:
      long l;
      break label132;
    }
    QLog.e("ReadInJoyCommentDataManager", 1, "replyComment: Invalid repliedSubAuthorId.");
    l = RIJCommentNetworkWrapper.INSTANCE.createSubComment(localSubCommentCreateData, new ReadInJoyCommentDataManager.15(this, paramString, localSubCommentData), paramString, paramInt, false);
    paramString = new StringBuilder();
    paramString.append("create reply comment, seq : ");
    paramString.append(l);
    paramString.append(", data : ");
    paramString.append(localSubCommentData);
    QLog.d("ReadInJoyCommentDataManager", 1, paramString.toString());
  }
  
  public void d()
  {
    Object localObject = this.jdField_c_of_type_JavaUtilList;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        this.jdField_b_of_type_JavaUtilMap.remove(str);
      }
      this.jdField_c_of_type_JavaUtilList.clear();
    }
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void d(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    BaseCommentData localBaseCommentData = a(1, paramString);
    if (localBaseCommentData == null) {
      return;
    }
    FirstCommentCreateData localFirstCommentCreateData = new FirstCommentCreateData(this.jdField_a_of_type_Int, "");
    localFirstCommentCreateData.b(this.jdField_h_of_type_JavaLangString);
    localFirstCommentCreateData.c(this.jdField_g_of_type_JavaLangString);
    localFirstCommentCreateData.a(localBaseCommentData.commentContent);
    localFirstCommentCreateData.a(localBaseCommentData.commentRptDataList);
    localFirstCommentCreateData.b(localBaseCommentData.commentLinkDataList);
    long l = RIJCommentNetworkWrapper.INSTANCE.createFirstComment(localFirstCommentCreateData, new ReadInJoyCommentDataManager.16(this, paramString, localBaseCommentData), paramString, paramInt, false);
    paramString = new StringBuilder();
    paramString.append("create main comment, seq : ");
    paramString.append(l);
    paramString.append(", data : ");
    paramString.append(localBaseCommentData);
    QLog.d("ReadInJoyCommentDataManager", 1, paramString.toString());
  }
  
  public void d_(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = paramBoolean;
  }
  
  public void i_(int paramInt)
  {
    a(new ReadInJoyCommentDataManager.38(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager
 * JD-Core Version:    0.7.0.1
 */