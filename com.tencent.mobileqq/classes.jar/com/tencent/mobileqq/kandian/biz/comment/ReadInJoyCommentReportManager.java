package com.tencent.mobileqq.kandian.biz.comment;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData.CommentLinkData;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData.CommentRptData;
import com.tencent.mobileqq.kandian.biz.comment.entity.CommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentData;
import com.tencent.mobileqq.kandian.biz.comment.rptdata.at.RIJCommentAtUtil;
import com.tencent.mobileqq.kandian.biz.comment.rptdata.topic.RIJCommentTopicUtil;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.view.ReadInJoyCommentListView;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
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

public class ReadInJoyCommentReportManager
{
  public static int a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ReadinjoyCommentListBaseAdapter jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter;
  private AbsBaseArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  protected Map<String, CommentViewItem> a;
  private int jdField_b_of_type_Int = 0;
  private List<String> jdField_b_of_type_JavaUtilList = new ArrayList();
  protected Map<String, CommentViewItem> b;
  private List<String> c;
  protected Map<String, CommentViewItem> c;
  private List<Pair<Long, CommentViewItem>> d;
  protected Map<String, CommentViewItem> d;
  Map<Integer, CommentViewItem> e = new HashMap();
  private Map<String, String> f = new HashMap();
  
  public ReadInJoyCommentReportManager(ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_d_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    this.jdField_c_of_type_JavaUtilMap = new HashMap();
    this.jdField_d_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter = paramReadinjoyCommentListBaseAdapter;
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
    jdField_a_of_type_Int = paramInt;
    paramReadinjoyCommentListBaseAdapter = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter;
    if ((paramReadinjoyCommentListBaseAdapter != null) && (paramReadinjoyCommentListBaseAdapter.a() != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter.a().getAppRuntime());
    }
  }
  
  private int a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter;
    int i;
    if ((localObject != null) && (((ReadinjoyCommentListBaseAdapter)localObject).a() != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter.b() == 2)) {
      i = 2;
    } else {
      i = 1;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getReportSteamType | streamType ");
    ((StringBuilder)localObject).append(i);
    QLog.d("ReadInJoyCommentReportManager", 2, ((StringBuilder)localObject).toString());
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
    if (paramBaseCommentData.isAuthorReply())
    {
      localStringBuilder.append(1);
      localStringBuilder.append(",");
    }
    if (paramBaseCommentData.isAuthorLike)
    {
      localStringBuilder.append(2);
      localStringBuilder.append(",");
    }
    if (paramBaseCommentData.isFollowing)
    {
      localStringBuilder.append(3);
      localStringBuilder.append(",");
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
        if (localSubCommentData != null)
        {
          localStringBuilder.append("\"");
          localStringBuilder.append(localSubCommentData.commentId);
          localStringBuilder.append("\"");
          localStringBuilder.append(",");
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
    if (paramBaseCommentData != null)
    {
      if (TextUtils.isEmpty(paramBaseCommentData.avatarPendantUrl)) {
        return;
      }
      paramBaseCommentData = new JSONObject();
      try
      {
        paramBaseCommentData.put("os", "1");
        paramBaseCommentData.put("version", "8.7.0");
        paramBaseCommentData.put("entry", jdField_a_of_type_Int);
      }
      catch (JSONException localJSONException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[reportExposeAvatarPendent] e = ");
        localStringBuilder.append(localJSONException);
        QLog.e("ReadInJoyCommentReportManager", 1, localStringBuilder.toString());
      }
      a(paramBaseCommentData.toString(), "0X800B069");
    }
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, BaseCommentData paramBaseCommentData)
  {
    if (!(paramBaseCommentData instanceof SubCommentData)) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("version", "8.7.0");
      localJSONObject.put("entry", jdField_a_of_type_Int);
      localJSONObject.put("comment_platform", 3);
      localJSONObject.put("comment_id", ((SubCommentData)paramBaseCommentData).parentCommentId);
      localJSONObject.put("sub_comment_id", paramBaseCommentData.commentId);
      localJSONObject.put("comment_level", 2);
      localJSONObject.put("os", "1");
      StringBuilder localStringBuilder = new StringBuilder();
      if ((paramBaseCommentData.commentRptDataList != null) && (paramBaseCommentData.commentRptDataList.size() > 0))
      {
        Iterator localIterator = paramBaseCommentData.commentRptDataList.iterator();
        while (localIterator.hasNext())
        {
          BaseCommentData.CommentRptData localCommentRptData = (BaseCommentData.CommentRptData)localIterator.next();
          if ((localCommentRptData != null) && (localCommentRptData.jdField_a_of_type_Int == 3))
          {
            localStringBuilder.append(",");
            localStringBuilder.append(localCommentRptData.d);
          }
        }
      }
      if (localStringBuilder.length() > 0) {
        localStringBuilder.substring(1);
      }
      localJSONObject.put("subject_id", localStringBuilder.toString());
      ThreadManager.getSubThreadHandler().post(new ReadInJoyCommentReportManager.3(paramBaseCommentData, paramAbsBaseArticleInfo, localJSONObject));
      return;
    }
    catch (JSONException paramAbsBaseArticleInfo)
    {
      paramAbsBaseArticleInfo.printStackTrace();
    }
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, BaseCommentData paramBaseCommentData, int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("entry", jdField_a_of_type_Int);
      boolean bool = paramBaseCommentData instanceof CommentData;
      if (bool)
      {
        localJSONObject.put("comment_id", paramBaseCommentData.commentId);
        localJSONObject.put("comment_level", 0);
      }
      else if ((paramBaseCommentData instanceof SubCommentData))
      {
        localJSONObject.put("sub_comment_id", paramBaseCommentData.commentId);
        localJSONObject.put("comment_level", 1);
      }
      localJSONObject.put("comment_platform", 3);
      localJSONObject.put("link_type", paramInt);
      ThreadManager.getSubThreadHandler().post(new ReadInJoyCommentReportManager.2(paramAbsBaseArticleInfo, localJSONObject));
      return;
    }
    catch (JSONException paramAbsBaseArticleInfo)
    {
      paramAbsBaseArticleInfo.printStackTrace();
    }
  }
  
  private String b(BaseCommentData paramBaseCommentData)
  {
    if ((paramBaseCommentData != null) && (paramBaseCommentData.hasLinkData()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramBaseCommentData = paramBaseCommentData.commentLinkDataList.iterator();
      while (paramBaseCommentData.hasNext())
      {
        BaseCommentData.CommentLinkData localCommentLinkData = (BaseCommentData.CommentLinkData)paramBaseCommentData.next();
        if (localCommentLinkData != null)
        {
          localStringBuilder.append(localCommentLinkData.type);
          localStringBuilder.append(",");
        }
      }
      return localStringBuilder.substring(0, localStringBuilder.length() - 1);
    }
    return null;
  }
  
  private void d(long paramLong, int paramInt)
  {
    if (this.f != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter == null) {
        return;
      }
      if (this.jdField_d_of_type_JavaUtilList == null) {
        this.jdField_d_of_type_JavaUtilList = new ArrayList();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter.getItem(paramInt) == null) {
        return;
      }
      Object localObject1 = (CommentViewItem)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter.getItem(paramInt);
      if (localObject1 == null) {
        return;
      }
      Object localObject2 = ((CommentViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData;
      if (localObject2 == null) {
        return;
      }
      localObject2 = ((BaseCommentData)localObject2).commentId;
      if ((((CommentViewItem)localObject1).jdField_a_of_type_Int == 0) && (!this.f.containsKey(localObject2)))
      {
        localObject1 = new Pair(Long.valueOf(paramLong), localObject1);
        this.jdField_d_of_type_JavaUtilList.add(localObject1);
        this.f.put(localObject2, "");
      }
    }
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
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null) {
      ((List)localObject).clear();
    } else {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    localObject = this.jdField_c_of_type_JavaUtilList;
    if (localObject != null) {
      ((List)localObject).clear();
    } else {
      this.jdField_c_of_type_JavaUtilList = new ArrayList();
    }
    localObject = this.f;
    if (localObject != null) {
      ((Map)localObject).clear();
    } else {
      this.f = new HashMap();
    }
    localObject = this.jdField_d_of_type_JavaUtilList;
    if (localObject != null) {
      ((List)localObject).clear();
    } else {
      this.jdField_d_of_type_JavaUtilList = new ArrayList();
    }
    localObject = this.jdField_a_of_type_JavaUtilMap;
    if (localObject != null) {
      ((Map)localObject).clear();
    } else {
      this.jdField_a_of_type_JavaUtilMap = new HashMap();
    }
    localObject = this.jdField_b_of_type_JavaUtilMap;
    if (localObject != null) {
      ((Map)localObject).clear();
    } else {
      this.jdField_b_of_type_JavaUtilMap = new HashMap();
    }
    localObject = this.e;
    if (localObject != null) {
      ((Map)localObject).clear();
    } else {
      this.e = new HashMap();
    }
    localObject = this.jdField_c_of_type_JavaUtilMap;
    if (localObject != null)
    {
      ((Map)localObject).clear();
      return;
    }
    this.jdField_c_of_type_JavaUtilMap = new HashMap();
  }
  
  public void a(int paramInt)
  {
    Object localObject1 = this.jdField_d_of_type_JavaUtilList;
    Object localObject2;
    long l;
    CommentData localCommentData;
    if (localObject1 != null)
    {
      if (((List)localObject1).isEmpty()) {
        return;
      }
      localObject1 = this.jdField_d_of_type_JavaUtilList.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Pair)((Iterator)localObject1).next();
        l = ((Long)((Pair)localObject2).first).longValue();
        localCommentData = (CommentData)((CommentViewItem)((Pair)localObject2).second).jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData;
      }
    }
    for (;;)
    {
      try
      {
        Object localObject3 = new JSONObject();
        ((JSONObject)localObject3).put("entry", jdField_a_of_type_Int);
        ((JSONObject)localObject3).put("comment_platform", 3);
        ((JSONObject)localObject3).put("comment_id", localCommentData.commentId);
        ((JSONObject)localObject3).put("time", l);
        ((JSONObject)localObject3).put("thumb_up_num", localCommentData.likeCnt);
        ((JSONObject)localObject3).put("sub_comment_num", localCommentData.subCommentNum);
        int j = 1;
        ((JSONObject)localObject3).put("shown_page", 1);
        ((JSONObject)localObject3).put("comment_type", ((CommentViewItem)((Pair)localObject2).second).jdField_b_of_type_Int);
        ((JSONObject)localObject3).put("show_sub_comment_id", a(localCommentData));
        ((JSONObject)localObject3).put("come_in_action", paramInt);
        ((JSONObject)localObject3).put("proxy_bytes", localCommentData.passthrough);
        ((JSONObject)localObject3).put("stream_type", a());
        ((JSONObject)localObject3).put("picture", a(localCommentData));
        ((JSONObject)localObject3).put("tag_type", a(localCommentData));
        if (!localCommentData.hasLinkData()) {
          break label450;
        }
        i = 1;
        ((JSONObject)localObject3).put("link", i);
        ((JSONObject)localObject3).put("link_type", b(localCommentData));
        if (!RIJCommentTopicUtil.a(localCommentData)) {
          break label455;
        }
        i = 1;
        ((JSONObject)localObject3).put("subject", i);
        if (!RIJCommentAtUtil.a(localCommentData)) {
          break label460;
        }
        i = j;
        ((JSONObject)localObject3).put("at", i);
        ((JSONObject)localObject3).put("comment_app", localCommentData.commentApp);
        localObject2 = ((JSONObject)localObject3).toString();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("reportExposedComments:");
        ((StringBuilder)localObject3).append((String)localObject2);
        QLog.d("ReadInJoyCommentReportManager", 2, ((StringBuilder)localObject3).toString());
        a((String)localObject2, "0X8009992");
        a(localCommentData);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      break;
      return;
      label450:
      int i = 0;
      continue;
      label455:
      i = 0;
      continue;
      label460:
      i = 0;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter == null) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("recordLeaveCommentIDList current screen firstpos ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", lastpos ");
    ((StringBuilder)localObject).append(paramInt2);
    QLog.d("ReadInJoyCommentReportManager", 2, ((StringBuilder)localObject).toString());
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 0;
    }
    localObject = this.jdField_c_of_type_JavaUtilList;
    if (localObject != null)
    {
      ((List)localObject).clear();
      while (i <= paramInt2)
      {
        if (i >= this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter.getCount()) {
          return;
        }
        localObject = (CommentViewItem)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter.getItem(i);
        if ((localObject != null) && (((CommentViewItem)localObject).jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData != null) && (!TextUtils.isEmpty(((CommentViewItem)localObject).jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.commentId))) {
          this.jdField_c_of_type_JavaUtilList.add(((CommentViewItem)localObject).jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.commentId);
        }
        i += 1;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, CommentViewItem paramCommentViewItem)
  {
    if (paramCommentViewItem == null) {
      return;
    }
    if (paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData == null) {
      return;
    }
    String str;
    if (paramInt1 == 2) {
      str = "0X8009018";
    } else {
      str = "0X8009669";
    }
    a(new CommentReportR5Builder(paramCommentViewItem).a().b(paramInt2).g().a(), str);
  }
  
  public void a(int paramInt, CommentViewItem paramCommentViewItem)
  {
    if (paramCommentViewItem != null)
    {
      if (paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData == null) {
        return;
      }
      if (paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData == null) {
        return;
      }
      String str;
      if (paramInt == 2) {
        str = "0X8009014";
      } else {
        str = "0X8009010";
      }
      a(new CommentReportR5Builder(paramCommentViewItem).a().c(1).b().a(), str);
    }
  }
  
  public void a(int paramInt, BaseCommentData paramBaseCommentData)
  {
    if (paramBaseCommentData == null)
    {
      a("", "0X8009BD7");
      return;
    }
    String str3 = new CommentReportR5Builder(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, paramBaseCommentData).a().a();
    String str2;
    String str1;
    if (paramInt == 2)
    {
      str2 = "0X8009015";
      str1 = "0X8009016";
    }
    else
    {
      str2 = "0X800900E";
      str1 = "0X800900F";
    }
    if (paramBaseCommentData.isLiked()) {
      str1 = str2;
    }
    a(str3, str1);
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
  
  public void a(CommentViewItem paramCommentViewItem)
  {
    if (paramCommentViewItem != null)
    {
      if (paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData == null) {
        return;
      }
      Object localObject = paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData;
      if (localObject == null) {
        return;
      }
      if ((localObject instanceof SubCommentData)) {
        localObject = "0X8009013";
      } else {
        localObject = "0X8009668";
      }
      a(new CommentReportR5Builder(paramCommentViewItem).a().a(), (String)localObject);
    }
  }
  
  public void a(CommentViewItem paramCommentViewItem, int paramInt)
  {
    if (paramCommentViewItem != null) {
      try
      {
        if ((paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData instanceof CommentData))
        {
          CommentData localCommentData = (CommentData)paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData;
          paramCommentViewItem = new CommentReportR5Builder(paramCommentViewItem).a().a(((CommentData)paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData).subCommentNum).a();
          paramCommentViewItem.put("entry_subcomment_type", paramInt);
          paramCommentViewItem.put("comment_id", localCommentData.commentId);
          paramCommentViewItem.put("show_sub_comment_id", a(localCommentData));
          paramCommentViewItem.put("tag_type", a(localCommentData));
          a(paramCommentViewItem.toString(), "0X800901F");
          return;
        }
      }
      catch (JSONException paramCommentViewItem)
      {
        QLog.d("ReadInJoyCommentReportManager", 2, paramCommentViewItem.getMessage());
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo == null) {
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
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null)
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      ThreadManager.getSubThreadHandler().post(new ReadInJoyCommentReportManager.1(this, paramString2, paramString1));
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo == null) {
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
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo == null) {
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
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter == null) {
      return;
    }
    a(new CommentReportR5Builder(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, null).d(paramInt).a(), "0X8009D01");
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("recordSubLeaveCommentIDList current screen firstpos ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", lastpos ");
    ((StringBuilder)localObject).append(paramInt2);
    QLog.d("ReadInJoyCommentReportManager", 2, ((StringBuilder)localObject).toString());
    localObject = this.jdField_c_of_type_JavaUtilList;
    if (localObject != null)
    {
      ((List)localObject).clear();
      while (paramInt1 <= paramInt2)
      {
        if (paramInt1 >= this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter.getCount()) {
          return;
        }
        localObject = (CommentViewItem)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter.getItem(paramInt1);
        if ((localObject != null) && (((CommentViewItem)localObject).jdField_a_of_type_Int == 0) && (((CommentViewItem)localObject).jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData != null) && (!TextUtils.isEmpty(((CommentViewItem)localObject).jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.commentId))) {
          this.jdField_c_of_type_JavaUtilList.add(((CommentViewItem)localObject).jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.commentId);
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void b(int paramInt, CommentViewItem paramCommentViewItem)
  {
    if (paramCommentViewItem == null) {
      return;
    }
    Object localObject = paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData;
    if (localObject == null) {
      return;
    }
    if (paramInt == 1)
    {
      if (((BaseCommentData)localObject).isDisliked()) {
        localObject = "0X8009557";
      } else {
        localObject = "0X8009558";
      }
    }
    else if (((BaseCommentData)localObject).isDisliked()) {
      localObject = "0X8009559";
    } else {
      localObject = "0X800955A";
    }
    a(new CommentReportR5Builder(paramCommentViewItem).a().a(), (String)localObject);
  }
  
  public void b(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null)
    {
      if (paramLong == 0L) {
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportReadCommentTime:");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("ReadInJoyCommentReportManager", 2, ((StringBuilder)localObject).toString());
      localObject = this.jdField_c_of_type_JavaUtilList;
      if ((localObject == null) || (((List)localObject).size() == 0)) {
        a(0, this.jdField_b_of_type_Int);
      }
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("entry", jdField_a_of_type_Int);
        ((JSONObject)localObject).put("comment_platform", 3);
        ((JSONObject)localObject).put("website", 0);
        ((JSONObject)localObject).put("read_comment_num", this.jdField_b_of_type_Int);
        ((JSONObject)localObject).put("read_time", paramLong);
        ((JSONObject)localObject).put("leave_comment_id_list", ReadInJoyHelper.a(this.jdField_c_of_type_JavaUtilList));
        ((JSONObject)localObject).put("shown_page", 1);
        ((JSONObject)localObject).put("stream_type", a());
        a(((JSONObject)localObject).toString(), "0X8009991");
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void b(long paramLong, int paramInt)
  {
    b(paramLong);
    e(paramInt);
  }
  
  public void b(CommentViewItem paramCommentViewItem)
  {
    if (paramCommentViewItem == null) {
      return;
    }
    Object localObject = paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData;
    if (localObject == null) {
      return;
    }
    if ((localObject instanceof SubCommentData)) {
      localObject = "0X800955B";
    } else {
      localObject = "0X800900D";
    }
    a(new CommentReportR5Builder(paramCommentViewItem).a().a(), (String)localObject);
  }
  
  public void b(String paramString1, String paramString2, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo == null) {
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
  
  public void c()
  {
    Iterator localIterator = this.e.values().iterator();
    while (localIterator.hasNext())
    {
      CommentViewItem localCommentViewItem = (CommentViewItem)localIterator.next();
      if (localCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData != null) {
        RIJMedalUtils.a(localCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.medalInfo);
      }
    }
    this.e.clear();
  }
  
  public void c(int paramInt)
  {
    ReadinjoyCommentListBaseAdapter localReadinjoyCommentListBaseAdapter = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter;
    if (localReadinjoyCommentListBaseAdapter == null) {
      return;
    }
    h((CommentViewItem)localReadinjoyCommentListBaseAdapter.getItem(paramInt));
    i((CommentViewItem)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter.getItem(paramInt));
    f(paramInt);
    k((CommentViewItem)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter.getItem(paramInt));
    d(System.currentTimeMillis(), paramInt);
    j((CommentViewItem)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter.getItem(paramInt));
    this.e.put(Integer.valueOf(paramInt), (CommentViewItem)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter.getItem(paramInt));
  }
  
  public void c(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter;
      if (localObject != null)
      {
        if (!(localObject instanceof ReadInJoySecondCommentListAdapter)) {
          return;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("ReadCommentTime ");
        ((StringBuilder)localObject).append(paramLong);
        QLog.d("ReadInJoyCommentReportManager", 2, ((StringBuilder)localObject).toString());
        localObject = this.jdField_c_of_type_JavaUtilList;
        if ((localObject != null) && (((List)localObject).isEmpty()) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter.a() != null)) {
          b(0, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter.a().getLastVisiblePosition());
        }
        try
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("entry", jdField_a_of_type_Int);
          ((JSONObject)localObject).put("comment_platform", 3);
          ((JSONObject)localObject).put("website", 0);
          ((JSONObject)localObject).put("read_time", paramLong);
          ((JSONObject)localObject).put("leave_comment_id_list", ReadInJoyHelper.a(this.jdField_c_of_type_JavaUtilList));
          ((JSONObject)localObject).put("shown_page", 2);
          ((JSONObject)localObject).put("comment_id", ((ReadInJoySecondCommentListAdapter)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter).a());
          a(((JSONObject)localObject).toString(), "0X8009991");
          return;
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
  
  public void c(long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter == null) {
      return;
    }
    if (this.jdField_d_of_type_JavaUtilList == null) {
      this.jdField_d_of_type_JavaUtilList = new ArrayList();
    }
    Object localObject = (CommentViewItem)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter.getItem(paramInt);
    if (localObject == null) {
      return;
    }
    BaseCommentData localBaseCommentData = ((CommentViewItem)localObject).jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData;
    if (localBaseCommentData == null) {
      return;
    }
    String str = localBaseCommentData.commentId;
    if ((((CommentViewItem)localObject).jdField_a_of_type_Int == 0) && ((localBaseCommentData instanceof SubCommentData)) && (!this.f.containsKey(str)))
    {
      localObject = new Pair(Long.valueOf(paramLong), localObject);
      this.jdField_d_of_type_JavaUtilList.add(localObject);
      this.f.put(str, "");
    }
  }
  
  public void c(CommentViewItem paramCommentViewItem)
  {
    if (paramCommentViewItem == null) {
      return;
    }
    String str;
    if ((paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData instanceof SubCommentData)) {
      str = "0X800901A";
    } else {
      str = "0X8009011";
    }
    a(new CommentReportR5Builder(paramCommentViewItem).a().a(), str);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo == null) {
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
    ReadinjoyCommentListBaseAdapter localReadinjoyCommentListBaseAdapter = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter;
    if (localReadinjoyCommentListBaseAdapter != null) {
      h((CommentViewItem)localReadinjoyCommentListBaseAdapter.getItem(paramInt));
    }
    c(System.currentTimeMillis(), paramInt);
  }
  
  public void d(CommentViewItem paramCommentViewItem)
  {
    if (paramCommentViewItem == null) {
      return;
    }
    a(new CommentReportR5Builder(paramCommentViewItem).i().d().h().a().a(), "0X8009993");
  }
  
  public void e()
  {
    Object localObject1 = this.jdField_d_of_type_JavaUtilList;
    Object localObject2;
    long l;
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter == null) {
        return;
      }
      localObject1 = this.jdField_d_of_type_JavaUtilList.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Pair)((Iterator)localObject1).next();
        l = ((Long)((Pair)localObject2).first).longValue();
        localObject2 = (SubCommentData)((CommentViewItem)((Pair)localObject2).second).jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData;
      }
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("entry", jdField_a_of_type_Int);
        localJSONObject.put("comment_platform", 3);
        localJSONObject.put("comment_id", ((ReadInJoySecondCommentListAdapter)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter).a());
        localJSONObject.put("sub_comment_id", ((SubCommentData)localObject2).commentId);
        localJSONObject.put("time", l);
        localJSONObject.put("thumb_up_num", ((SubCommentData)localObject2).likeCnt);
        localJSONObject.put("shown_page", 2);
        localJSONObject.put("come_in_action", 2);
        localJSONObject.put("proxy_bytes", ((SubCommentData)localObject2).passthrough);
        localJSONObject.put("tag_type", a((BaseCommentData)localObject2));
        localJSONObject.put("picture", a((BaseCommentData)localObject2));
        boolean bool = ((SubCommentData)localObject2).hasLinkData();
        int j = 1;
        if (!bool) {
          break label382;
        }
        i = 1;
        localJSONObject.put("link", i);
        localJSONObject.put("link_type", b((BaseCommentData)localObject2));
        if (!RIJCommentTopicUtil.a((BaseCommentData)localObject2)) {
          break label387;
        }
        i = 1;
        localJSONObject.put("subject", i);
        if (!RIJCommentAtUtil.a((BaseCommentData)localObject2)) {
          break label392;
        }
        i = j;
        localJSONObject.put("at", i);
        localJSONObject.put("comment_app", ((SubCommentData)localObject2).commentApp);
        a(localJSONObject.toString(), "0X8009992");
        RIJMedalUtils.a(((SubCommentData)localObject2).medalInfo);
        a((BaseCommentData)localObject2);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      break;
      return;
      label382:
      int i = 0;
      continue;
      label387:
      i = 0;
      continue;
      label392:
      i = 0;
    }
  }
  
  public void e(CommentViewItem paramCommentViewItem)
  {
    if (paramCommentViewItem == null) {
      return;
    }
    a(new CommentReportR5Builder(paramCommentViewItem).i().d().h().a().a(), "0X8009994");
  }
  
  public void f()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilMap;
    if (localObject != null)
    {
      if (((Map)localObject).isEmpty()) {
        return;
      }
      localObject = this.jdField_a_of_type_JavaUtilMap.values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        CommentViewItem localCommentViewItem = (CommentViewItem)((Iterator)localObject).next();
        if (localCommentViewItem != null) {
          d(localCommentViewItem);
        }
      }
    }
  }
  
  public void f(CommentViewItem paramCommentViewItem)
  {
    if (paramCommentViewItem == null) {
      return;
    }
    a(new CommentReportR5Builder(paramCommentViewItem).a().c().a(), "0X800A001");
  }
  
  public void g()
  {
    Object localObject = this.jdField_b_of_type_JavaUtilMap;
    if (localObject != null)
    {
      if (((Map)localObject).isEmpty()) {
        return;
      }
      localObject = this.jdField_b_of_type_JavaUtilMap.values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        CommentViewItem localCommentViewItem = (CommentViewItem)((Iterator)localObject).next();
        if (localCommentViewItem != null) {
          d(localCommentViewItem);
        }
      }
    }
  }
  
  public void g(CommentViewItem paramCommentViewItem)
  {
    if (paramCommentViewItem == null) {
      return;
    }
    a(new CommentReportR5Builder(paramCommentViewItem).a().c().k().a(), "0X8009E82");
  }
  
  public void h()
  {
    Object localObject = this.jdField_d_of_type_JavaUtilMap;
    if (localObject != null)
    {
      if (((Map)localObject).isEmpty()) {
        return;
      }
      localObject = this.jdField_d_of_type_JavaUtilMap.values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        CommentViewItem localCommentViewItem = (CommentViewItem)((Iterator)localObject).next();
        if (localCommentViewItem != null) {
          d(localCommentViewItem);
        }
      }
    }
  }
  
  public void h(CommentViewItem paramCommentViewItem)
  {
    if ((paramCommentViewItem != null) && (paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData != null))
    {
      if (this.jdField_a_of_type_JavaUtilMap == null) {
        return;
      }
      if (!paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.isActivity()) {
        return;
      }
      BaseCommentData localBaseCommentData = paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData;
      if (!this.jdField_a_of_type_JavaUtilMap.containsKey(localBaseCommentData.commentId)) {
        this.jdField_a_of_type_JavaUtilMap.put(localBaseCommentData.commentId, paramCommentViewItem);
      }
    }
  }
  
  public void i()
  {
    Object localObject = this.jdField_c_of_type_JavaUtilMap;
    if (localObject != null)
    {
      if (((Map)localObject).isEmpty()) {
        return;
      }
      localObject = this.jdField_c_of_type_JavaUtilMap.values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        CommentViewItem localCommentViewItem = (CommentViewItem)((Iterator)localObject).next();
        if (localCommentViewItem != null) {
          a(new CommentReportR5Builder(localCommentViewItem).a().c().k().a(), "0X800A2D2");
        }
      }
    }
  }
  
  public void i(CommentViewItem paramCommentViewItem)
  {
    if ((paramCommentViewItem != null) && (paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData != null))
    {
      if (this.jdField_a_of_type_JavaUtilMap == null) {
        return;
      }
      if (!paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.isBanner()) {
        return;
      }
      BaseCommentData localBaseCommentData = paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData;
      if (!this.jdField_b_of_type_JavaUtilMap.containsKey(localBaseCommentData.commentId)) {
        this.jdField_b_of_type_JavaUtilMap.put(localBaseCommentData.commentId, paramCommentViewItem);
      }
    }
  }
  
  public void j(CommentViewItem paramCommentViewItem)
  {
    if ((paramCommentViewItem != null) && (paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData != null))
    {
      if (this.jdField_d_of_type_JavaUtilMap == null) {
        return;
      }
      if (!paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.isDynamicComment()) {
        return;
      }
      BaseCommentData localBaseCommentData = paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData;
      if (!this.jdField_d_of_type_JavaUtilMap.containsKey(localBaseCommentData.commentId)) {
        this.jdField_d_of_type_JavaUtilMap.put(localBaseCommentData.commentId, paramCommentViewItem);
      }
    }
  }
  
  public void k(CommentViewItem paramCommentViewItem)
  {
    if ((paramCommentViewItem != null) && (paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData != null))
    {
      if (this.jdField_c_of_type_JavaUtilMap == null) {
        return;
      }
      if (TextUtils.isEmpty(paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.flowGuidePtsData)) {
        return;
      }
      BaseCommentData localBaseCommentData = paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData;
      if (!this.jdField_c_of_type_JavaUtilMap.containsKey(localBaseCommentData.commentId)) {
        this.jdField_c_of_type_JavaUtilMap.put(localBaseCommentData.commentId, paramCommentViewItem);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentReportManager
 * JD-Core Version:    0.7.0.1
 */