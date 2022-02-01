package com.tencent.mobileqq.kandian.biz.comment;

import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData.CommentLinkData;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData.CommentRptData;
import com.tencent.mobileqq.kandian.biz.comment.entity.CommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentData;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.view.ReadInJoyCommentListView;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
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
  protected Map<String, CommentViewItem> b = new HashMap();
  protected Map<String, CommentViewItem> c = new HashMap();
  protected Map<String, CommentViewItem> d = new HashMap();
  protected Map<String, CommentViewItem> e = new HashMap();
  Map<Integer, CommentViewItem> f = new HashMap();
  private AbsBaseArticleInfo g;
  private ReadinjoyCommentListBaseAdapter h;
  private QQAppInterface i;
  private List<String> j = new ArrayList();
  private int k = 0;
  private List<String> l = new ArrayList();
  private List<String> m = new ArrayList();
  private List<Pair<Long, CommentViewItem>> n = new ArrayList();
  private Map<String, String> o = new HashMap();
  
  public ReadInJoyCommentReportManager(ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    this.h = paramReadinjoyCommentListBaseAdapter;
    this.g = paramAbsBaseArticleInfo;
    a = paramInt;
    paramReadinjoyCommentListBaseAdapter = this.h;
    if ((paramReadinjoyCommentListBaseAdapter != null) && (paramReadinjoyCommentListBaseAdapter.n() != null)) {
      this.i = ((QQAppInterface)this.h.n().getAppRuntime());
    }
  }
  
  private int a(BaseCommentData paramBaseCommentData)
  {
    if ((paramBaseCommentData != null) && (paramBaseCommentData.mediaDataList != null) && (paramBaseCommentData.mediaDataList.size() > 0)) {
      return 1;
    }
    return 0;
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
      int i1 = 0;
      while (i1 < paramCommentData.subCommentList.size())
      {
        SubCommentData localSubCommentData = (SubCommentData)paramCommentData.subCommentList.get(i1);
        if (localSubCommentData != null)
        {
          localStringBuilder.append("\"");
          localStringBuilder.append(localSubCommentData.commentId);
          localStringBuilder.append("\"");
          localStringBuilder.append(",");
        }
        i1 += 1;
      }
    }
    if (localStringBuilder.length() > 1) {
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, BaseCommentData paramBaseCommentData)
  {
    if (!(paramBaseCommentData instanceof SubCommentData)) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("version", "8.8.17");
      localJSONObject.put("entry", a);
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
          if ((localCommentRptData != null) && (localCommentRptData.a == 3))
          {
            localStringBuilder.append(",");
            localStringBuilder.append(localCommentRptData.e);
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
      localJSONObject.put("entry", a);
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
  
  private void a(JSONObject paramJSONObject, Pair<Long, CommentViewItem> paramPair)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private String b(BaseCommentData paramBaseCommentData)
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
  
  private String c(BaseCommentData paramBaseCommentData)
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
    if (this.o != null)
    {
      if (this.h == null) {
        return;
      }
      if (this.n == null) {
        this.n = new ArrayList();
      }
      if (this.h.getItem(paramInt) == null) {
        return;
      }
      Object localObject1 = (CommentViewItem)this.h.getItem(paramInt);
      if (localObject1 == null) {
        return;
      }
      Object localObject2 = ((CommentViewItem)localObject1).c;
      if (localObject2 == null) {
        return;
      }
      localObject2 = ((BaseCommentData)localObject2).commentId;
      if ((((CommentViewItem)localObject1).a == 0) && (!this.o.containsKey(localObject2)))
      {
        localObject1 = new Pair(Long.valueOf(paramLong), localObject1);
        this.n.add(localObject1);
        this.o.put(localObject2, "");
      }
    }
  }
  
  private void d(BaseCommentData paramBaseCommentData)
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
        paramBaseCommentData.put("version", "8.8.17");
        paramBaseCommentData.put("entry", a);
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
    if (paramInt > this.k) {
      this.k = paramInt;
    }
  }
  
  private int j()
  {
    Object localObject = this.h;
    int i1;
    if ((localObject != null) && (((ReadinjoyCommentListBaseAdapter)localObject).f() != null) && (this.h.o() == 2)) {
      i1 = 2;
    } else {
      i1 = 1;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getReportSteamType | streamType ");
    ((StringBuilder)localObject).append(i1);
    QLog.d("ReadInJoyCommentReportManager", 2, ((StringBuilder)localObject).toString());
    return i1;
  }
  
  public void a()
  {
    this.k = 0;
    Object localObject = this.j;
    if (localObject != null) {
      ((List)localObject).clear();
    } else {
      this.j = new ArrayList();
    }
    localObject = this.m;
    if (localObject != null) {
      ((List)localObject).clear();
    } else {
      this.m = new ArrayList();
    }
    localObject = this.o;
    if (localObject != null) {
      ((Map)localObject).clear();
    } else {
      this.o = new HashMap();
    }
    localObject = this.n;
    if (localObject != null) {
      ((List)localObject).clear();
    } else {
      this.n = new ArrayList();
    }
    localObject = this.b;
    if (localObject != null) {
      ((Map)localObject).clear();
    } else {
      this.b = new HashMap();
    }
    localObject = this.c;
    if (localObject != null) {
      ((Map)localObject).clear();
    } else {
      this.c = new HashMap();
    }
    localObject = this.f;
    if (localObject != null) {
      ((Map)localObject).clear();
    } else {
      this.f = new HashMap();
    }
    localObject = this.d;
    if (localObject != null)
    {
      ((Map)localObject).clear();
      return;
    }
    this.d = new HashMap();
  }
  
  public void a(int paramInt)
  {
    Object localObject1 = this.n;
    if (localObject1 != null)
    {
      if (((List)localObject1).isEmpty()) {
        return;
      }
      localObject1 = this.n.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Pair localPair = (Pair)((Iterator)localObject1).next();
        CommentData localCommentData = (CommentData)((CommentViewItem)localPair.second).c;
        try
        {
          Object localObject2 = new JSONObject();
          a((JSONObject)localObject2, localPair);
          ((JSONObject)localObject2).put("comment_type", ((CommentViewItem)localPair.second).b);
          ((JSONObject)localObject2).put("comment_id", localCommentData.commentId);
          ((JSONObject)localObject2).put("sub_comment_num", localCommentData.subCommentNum);
          ((JSONObject)localObject2).put("shown_page", 1);
          ((JSONObject)localObject2).put("show_sub_comment_id", a(localCommentData));
          ((JSONObject)localObject2).put("come_in_action", paramInt);
          ((JSONObject)localObject2).put("stream_type", j());
          localObject2 = ((JSONObject)localObject2).toString();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("reportExposedComments:");
          localStringBuilder.append((String)localObject2);
          QLog.d("ReadInJoyCommentReportManager", 2, localStringBuilder.toString());
          a((String)localObject2, "0X8009992");
          d(localCommentData);
          a(((CommentViewItem)localPair.second).d, localCommentData);
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
      this.n.clear();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.h == null) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("recordLeaveCommentIDList current screen firstpos ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", lastpos ");
    ((StringBuilder)localObject).append(paramInt2);
    QLog.d("ReadInJoyCommentReportManager", 2, ((StringBuilder)localObject).toString());
    int i1 = paramInt1;
    if (paramInt1 < 0) {
      i1 = 0;
    }
    localObject = this.m;
    if (localObject != null)
    {
      ((List)localObject).clear();
      while (i1 <= paramInt2)
      {
        if (i1 >= this.h.getCount()) {
          return;
        }
        localObject = (CommentViewItem)this.h.getItem(i1);
        if ((localObject != null) && (((CommentViewItem)localObject).c != null) && (!TextUtils.isEmpty(((CommentViewItem)localObject).c.commentId))) {
          this.m.add(((CommentViewItem)localObject).c.commentId);
        }
        i1 += 1;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, CommentViewItem paramCommentViewItem)
  {
    if (paramCommentViewItem == null) {
      return;
    }
    if (paramCommentViewItem.c == null) {
      return;
    }
    String str;
    if (paramInt1 == 2) {
      str = "0X8009018";
    } else {
      str = "0X8009669";
    }
    a(new CommentReportR5Builder(paramCommentViewItem).a().b(paramInt2).i().b(), str);
  }
  
  public void a(int paramInt, CommentViewItem paramCommentViewItem)
  {
    if (paramCommentViewItem != null)
    {
      if (paramCommentViewItem.c == null) {
        return;
      }
      if (paramCommentViewItem.c == null) {
        return;
      }
      String str;
      if (paramInt == 2) {
        str = "0X8009014";
      } else {
        str = "0X8009010";
      }
      a(new CommentReportR5Builder(paramCommentViewItem).a().c(1).d().b(), str);
    }
  }
  
  public void a(int paramInt, BaseCommentData paramBaseCommentData)
  {
    if (paramBaseCommentData == null)
    {
      a("", "0X8009BD7");
      return;
    }
    String str3 = new CommentReportR5Builder(this.g, paramBaseCommentData).a().b();
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
      if (paramCommentViewItem.c == null) {
        return;
      }
      Object localObject = paramCommentViewItem.c;
      if (localObject == null) {
        return;
      }
      if ((localObject instanceof SubCommentData)) {
        localObject = "0X8009013";
      } else {
        localObject = "0X8009668";
      }
      a(new CommentReportR5Builder(paramCommentViewItem).a().b(), (String)localObject);
    }
  }
  
  public void a(CommentViewItem paramCommentViewItem, int paramInt)
  {
    if (paramCommentViewItem != null) {
      try
      {
        if ((paramCommentViewItem.c instanceof CommentData))
        {
          CommentData localCommentData = (CommentData)paramCommentViewItem.c;
          paramCommentViewItem = new CommentReportR5Builder(paramCommentViewItem).a().a(((CommentData)paramCommentViewItem.c).subCommentNum).c();
          paramCommentViewItem.put("entry_subcomment_type", paramInt);
          paramCommentViewItem.put("comment_id", localCommentData.commentId);
          paramCommentViewItem.put("show_sub_comment_id", a(localCommentData));
          paramCommentViewItem.put("tag_type", b(localCommentData));
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
  
  @VisibleForTesting
  void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, CommentData paramCommentData)
  {
    if (!paramCommentData.shouldShowFollowButton) {
      return;
    }
    if (paramCommentData.isFollowButtonShown) {
      ReadinjoyReportUtils.a(paramAbsBaseArticleInfo, ReadinjoyReportUtils.g, true, paramCommentData.commentId, paramCommentData.uin);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.g == null) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("comment_id", paramString);
      localJSONObject.put("comment_level", 0);
      localJSONObject.put("shown_page", 1);
      localJSONObject.put("entry", a);
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
    if (this.g != null)
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      ThreadManager.getSubThreadHandler().post(new ReadInJoyCommentReportManager.1(this, paramString2, paramString1));
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (this.g == null) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("comment_id", paramString1);
      localJSONObject.put("sub_comment_id", paramString2);
      localJSONObject.put("comment_level", 2);
      localJSONObject.put("shown_page", 2);
      localJSONObject.put("entry", a);
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
    if (this.g == null) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("shown_page", 1);
      localJSONObject.put("entry", a);
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
    if (this.h == null) {
      return;
    }
    a(new CommentReportR5Builder(this.g, null).d(paramInt).b(), "0X8009D01");
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("recordSubLeaveCommentIDList current screen firstpos ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", lastpos ");
    ((StringBuilder)localObject).append(paramInt2);
    QLog.d("ReadInJoyCommentReportManager", 2, ((StringBuilder)localObject).toString());
    localObject = this.m;
    if (localObject != null)
    {
      ((List)localObject).clear();
      while (paramInt1 <= paramInt2)
      {
        if (paramInt1 >= this.h.getCount()) {
          return;
        }
        localObject = (CommentViewItem)this.h.getItem(paramInt1);
        if ((localObject != null) && (((CommentViewItem)localObject).a == 0) && (((CommentViewItem)localObject).c != null) && (!TextUtils.isEmpty(((CommentViewItem)localObject).c.commentId))) {
          this.m.add(((CommentViewItem)localObject).c.commentId);
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
    Object localObject = paramCommentViewItem.c;
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
    a(new CommentReportR5Builder(paramCommentViewItem).a().b(), (String)localObject);
  }
  
  public void b(long paramLong)
  {
    if (this.g != null)
    {
      if (paramLong == 0L) {
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportReadCommentTime:");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("ReadInJoyCommentReportManager", 2, ((StringBuilder)localObject).toString());
      localObject = this.m;
      if ((localObject == null) || (((List)localObject).size() == 0)) {
        a(0, this.k);
      }
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("entry", a);
        ((JSONObject)localObject).put("comment_platform", 3);
        ((JSONObject)localObject).put("website", 0);
        ((JSONObject)localObject).put("read_comment_num", this.k);
        ((JSONObject)localObject).put("read_time", paramLong);
        ((JSONObject)localObject).put("leave_comment_id_list", ReadInJoyHelper.a(this.m));
        ((JSONObject)localObject).put("shown_page", 1);
        ((JSONObject)localObject).put("stream_type", j());
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
    Object localObject = paramCommentViewItem.c;
    if (localObject == null) {
      return;
    }
    if ((localObject instanceof SubCommentData)) {
      localObject = "0X800955B";
    } else {
      localObject = "0X800900D";
    }
    a(new CommentReportR5Builder(paramCommentViewItem).a().b(), (String)localObject);
  }
  
  public void b(String paramString1, String paramString2, int paramInt)
  {
    if (this.g == null) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("comment_id", paramString1);
      localJSONObject.put("sub_comment_id", paramString2);
      localJSONObject.put("comment_level", 1);
      localJSONObject.put("shown_page", 2);
      localJSONObject.put("entry", a);
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
    Iterator localIterator = this.f.values().iterator();
    while (localIterator.hasNext())
    {
      CommentViewItem localCommentViewItem = (CommentViewItem)localIterator.next();
      if (localCommentViewItem.c != null) {
        RIJMedalUtils.a(localCommentViewItem.c.medalInfo);
      }
    }
    this.f.clear();
  }
  
  public void c(int paramInt)
  {
    ReadinjoyCommentListBaseAdapter localReadinjoyCommentListBaseAdapter = this.h;
    if (localReadinjoyCommentListBaseAdapter == null) {
      return;
    }
    h((CommentViewItem)localReadinjoyCommentListBaseAdapter.getItem(paramInt));
    i((CommentViewItem)this.h.getItem(paramInt));
    f(paramInt);
    k((CommentViewItem)this.h.getItem(paramInt));
    d(System.currentTimeMillis(), paramInt);
    j((CommentViewItem)this.h.getItem(paramInt));
    this.f.put(Integer.valueOf(paramInt), (CommentViewItem)this.h.getItem(paramInt));
  }
  
  public void c(long paramLong)
  {
    if (this.g != null)
    {
      Object localObject = this.h;
      if (localObject != null)
      {
        if (!(localObject instanceof ReadInJoySecondCommentListAdapter)) {
          return;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("ReadCommentTime ");
        ((StringBuilder)localObject).append(paramLong);
        QLog.d("ReadInJoyCommentReportManager", 2, ((StringBuilder)localObject).toString());
        localObject = this.m;
        if ((localObject != null) && (((List)localObject).isEmpty()) && (this.h.r() != null)) {
          b(0, this.h.r().getLastVisiblePosition());
        }
        try
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("entry", a);
          ((JSONObject)localObject).put("comment_platform", 3);
          ((JSONObject)localObject).put("website", 0);
          ((JSONObject)localObject).put("read_time", paramLong);
          ((JSONObject)localObject).put("leave_comment_id_list", ReadInJoyHelper.a(this.m));
          ((JSONObject)localObject).put("shown_page", 2);
          ((JSONObject)localObject).put("comment_id", ((ReadInJoySecondCommentListAdapter)this.h).b());
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
    if (this.h == null) {
      return;
    }
    if (this.n == null) {
      this.n = new ArrayList();
    }
    Object localObject = (CommentViewItem)this.h.getItem(paramInt);
    if (localObject == null) {
      return;
    }
    BaseCommentData localBaseCommentData = ((CommentViewItem)localObject).c;
    if (localBaseCommentData == null) {
      return;
    }
    String str = localBaseCommentData.commentId;
    if ((((CommentViewItem)localObject).a == 0) && ((localBaseCommentData instanceof SubCommentData)) && (!this.o.containsKey(str)))
    {
      localObject = new Pair(Long.valueOf(paramLong), localObject);
      this.n.add(localObject);
      this.o.put(str, "");
    }
  }
  
  public void c(CommentViewItem paramCommentViewItem)
  {
    if (paramCommentViewItem == null) {
      return;
    }
    String str;
    if ((paramCommentViewItem.c instanceof SubCommentData)) {
      str = "0X800901A";
    } else {
      str = "0X8009011";
    }
    a(new CommentReportR5Builder(paramCommentViewItem).a().b(), str);
  }
  
  public void d()
  {
    if (this.g == null) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("shown_page", 2);
      localJSONObject.put("entry", a);
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
    ReadinjoyCommentListBaseAdapter localReadinjoyCommentListBaseAdapter = this.h;
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
    a(new CommentReportR5Builder(paramCommentViewItem).k().f().j().a().b(), "0X8009993");
  }
  
  public void e()
  {
    Object localObject = this.n;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      if (this.h == null) {
        return;
      }
      localObject = this.n.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Pair localPair = (Pair)((Iterator)localObject).next();
        SubCommentData localSubCommentData = (SubCommentData)((CommentViewItem)localPair.second).c;
        try
        {
          JSONObject localJSONObject = new JSONObject();
          a(localJSONObject, localPair);
          localJSONObject.put("comment_id", ((ReadInJoySecondCommentListAdapter)this.h).b());
          localJSONObject.put("sub_comment_id", localSubCommentData.commentId);
          localJSONObject.put("shown_page", 2);
          localJSONObject.put("come_in_action", 2);
          a(localJSONObject.toString(), "0X8009992");
          RIJMedalUtils.a(localSubCommentData.medalInfo);
          d(localSubCommentData);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      this.n.clear();
    }
  }
  
  public void e(CommentViewItem paramCommentViewItem)
  {
    if (paramCommentViewItem == null) {
      return;
    }
    a(new CommentReportR5Builder(paramCommentViewItem).k().f().j().a().b(), "0X8009994");
  }
  
  public void f()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      if (((Map)localObject).isEmpty()) {
        return;
      }
      localObject = this.b.values().iterator();
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
    a(new CommentReportR5Builder(paramCommentViewItem).a().e().b(), "0X800A001");
  }
  
  public void g()
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      if (((Map)localObject).isEmpty()) {
        return;
      }
      localObject = this.c.values().iterator();
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
    a(new CommentReportR5Builder(paramCommentViewItem).a().e().m().b(), "0X8009E82");
  }
  
  public void h()
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      if (((Map)localObject).isEmpty()) {
        return;
      }
      localObject = this.e.values().iterator();
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
    if ((paramCommentViewItem != null) && (paramCommentViewItem.c != null))
    {
      if (this.b == null) {
        return;
      }
      if (!paramCommentViewItem.c.isActivity()) {
        return;
      }
      BaseCommentData localBaseCommentData = paramCommentViewItem.c;
      if (!this.b.containsKey(localBaseCommentData.commentId)) {
        this.b.put(localBaseCommentData.commentId, paramCommentViewItem);
      }
    }
  }
  
  public void i()
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      if (((Map)localObject).isEmpty()) {
        return;
      }
      localObject = this.d.values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        CommentViewItem localCommentViewItem = (CommentViewItem)((Iterator)localObject).next();
        if (localCommentViewItem != null) {
          a(new CommentReportR5Builder(localCommentViewItem).a().e().m().b(), "0X800A2D2");
        }
      }
    }
  }
  
  public void i(CommentViewItem paramCommentViewItem)
  {
    if ((paramCommentViewItem != null) && (paramCommentViewItem.c != null))
    {
      if (this.b == null) {
        return;
      }
      if (!paramCommentViewItem.c.isBanner()) {
        return;
      }
      BaseCommentData localBaseCommentData = paramCommentViewItem.c;
      if (!this.c.containsKey(localBaseCommentData.commentId)) {
        this.c.put(localBaseCommentData.commentId, paramCommentViewItem);
      }
    }
  }
  
  public void j(CommentViewItem paramCommentViewItem)
  {
    if ((paramCommentViewItem != null) && (paramCommentViewItem.c != null))
    {
      if (this.e == null) {
        return;
      }
      if (!paramCommentViewItem.c.isDynamicComment()) {
        return;
      }
      BaseCommentData localBaseCommentData = paramCommentViewItem.c;
      if (!this.e.containsKey(localBaseCommentData.commentId)) {
        this.e.put(localBaseCommentData.commentId, paramCommentViewItem);
      }
    }
  }
  
  public void k(CommentViewItem paramCommentViewItem)
  {
    if ((paramCommentViewItem != null) && (paramCommentViewItem.c != null))
    {
      if (this.d == null) {
        return;
      }
      if (TextUtils.isEmpty(paramCommentViewItem.c.flowGuidePtsData)) {
        return;
      }
      BaseCommentData localBaseCommentData = paramCommentViewItem.c;
      if (!this.d.containsKey(localBaseCommentData.commentId)) {
        this.d.put(localBaseCommentData.commentId, paramCommentViewItem);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentReportManager
 * JD-Core Version:    0.7.0.1
 */