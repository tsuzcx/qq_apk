package com.tencent.mobileqq.kandian.repo.webarticle;

import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.base.utils.RIJPBFieldUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyEngineModule;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.webarticle.api.IDataPreloadModule;
import com.tencent.mobileqq.kandian.repo.webarticle.data.ArticleDetailInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xf24.oidb_cmd0xf24.RspBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/webarticle/DataPreloadModule;", "Lcom/tencent/mobileqq/kandian/repo/common/ReadInJoyEngineModule;", "Lcom/tencent/mobileqq/kandian/repo/webarticle/api/IDataPreloadModule;", "()V", "CGI_URL", "", "CMD_INT_ARTICLE_DETAIL", "", "CMD_STRING_ARTICLE_DETAIL", "REQUEST_TIME_OUT", "", "SERVICE_TYPE", "TAG", "articleDetailCache", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/kandian/repo/webarticle/data/ArticleDetailInfo;", "requestList", "", "kotlin.jvm.PlatformType", "", "getCSRFToken", "skey", "getUrlWithToken", "url", "handleArticleDetailCgiResponse", "", "result", "handleArticleDetailResponsePkg", "req", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "res", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "data", "", "isAbleToPreload", "", "rowKey", "isArticleDetailAvailable", "articleDetail", "onReceive", "preloadArticle", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "requestArticleDetailByCgi", "requestArticleDetailInWebProcess", "unInitialize", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class DataPreloadModule
  extends ReadInJoyEngineModule
  implements IDataPreloadModule
{
  private static final String CGI_URL = "https://cgi.kandian.qq.com/trpc.tkdqq.kd_web_article_detail.KDWebArticleDetail/GetDetail";
  private static final int CMD_INT_ARTICLE_DETAIL = 3876;
  private static final String CMD_STRING_ARTICLE_DETAIL = "OidbSvc.0xf24";
  public static final DataPreloadModule INSTANCE = new DataPreloadModule();
  private static final long REQUEST_TIME_OUT = 5000L;
  private static final int SERVICE_TYPE = 0;
  private static final String TAG = "DataPreloadModule";
  private static final ConcurrentHashMap<String, ArticleDetailInfo> articleDetailCache = new ConcurrentHashMap();
  private static final Set<String> requestList = Collections.synchronizedSet((Set)new HashSet());
  
  private final String getCSRFToken(String paramString)
  {
    int j = paramString.length();
    long l = 5381L;
    int i = 0;
    while (i < j)
    {
      l += (0x7FFFFFFF & l << 5) + paramString.charAt(i);
      i += 1;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("getCSRFToken ");
      paramString.append(l & 0x7FFFFFFF);
      QLog.w("DataPreloadModule", 2, paramString.toString());
    }
    return String.valueOf(l & 0x7FFFFFFF);
  }
  
  private final String getUrlWithToken(String paramString)
  {
    Object localObject2 = RIJQQAppInterfaceUtil.a();
    Object localObject1 = RIJQQAppInterfaceUtil.a();
    localObject2 = ((AppRuntime)localObject2).getManager(2);
    if (localObject2 != null)
    {
      localObject2 = ((TicketManager)localObject2).getSkey((String)localObject1);
      localObject1 = paramString;
      if (localObject2 != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("g_tk=");
        ((StringBuilder)localObject1).append(INSTANCE.getCSRFToken((String)localObject2));
        localObject1 = HtmlOffline.a(paramString, ((StringBuilder)localObject1).toString());
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "HtmlOffline.addParamToUr…k=${getCSRFToken(skey)}\")");
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("[getUrlWithToken] res = ");
        paramString.append((String)localObject1);
        QLog.i("DataPreloadModule", 1, paramString.toString());
      }
      return localObject1;
    }
    throw new TypeCastException("null cannot be cast to non-null type mqq.manager.TicketManager");
  }
  
  private final void handleArticleDetailCgiResponse(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[handleArticleDetailCgiResponse] result = ");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("DataPreloadModule", 1, ((StringBuilder)localObject).toString());
    if (!TextUtils.isEmpty((CharSequence)paramString))
    {
      localObject = new ArticleDetailInfo();
      try
      {
        paramString = new JSONObject(paramString);
        String str = paramString.optString("rowkey", "");
        Intrinsics.checkExpressionValueIsNotNull(str, "json.optString(\"rowkey\", \"\")");
        ((ArticleDetailInfo)localObject).setRowKey(str);
        ((ArticleDetailInfo)localObject).setArticleId(paramString.optLong("article_id", 0L));
        str = paramString.optString("title", "");
        Intrinsics.checkExpressionValueIsNotNull(str, "json.optString(\"title\", \"\")");
        ((ArticleDetailInfo)localObject).setTitle(str);
        str = paramString.optString("cover_image_url", "");
        Intrinsics.checkExpressionValueIsNotNull(str, "json.optString(\"cover_image_url\", \"\")");
        ((ArticleDetailInfo)localObject).setCoverImageUrl(str);
        ((ArticleDetailInfo)localObject).setReadCount(paramString.optLong("read_count", 0L));
        ((ArticleDetailInfo)localObject).setPublishTime(paramString.optLong("publish_time", 0L));
        ((ArticleDetailInfo)localObject).setPUin(paramString.optLong("puin", 0L));
        str = paramString.optString("account_avatar_url", "");
        Intrinsics.checkExpressionValueIsNotNull(str, "json.optString(\"account_avatar_url\", \"\")");
        ((ArticleDetailInfo)localObject).setAccountAvatarUrl(str);
        str = paramString.optString("account_name", "");
        Intrinsics.checkExpressionValueIsNotNull(str, "json.optString(\"account_name\", \"\")");
        ((ArticleDetailInfo)localObject).setAccountName(str);
        str = paramString.optString("json_article_content", "");
        Intrinsics.checkExpressionValueIsNotNull(str, "json.optString(\"json_article_content\", \"\")");
        ((ArticleDetailInfo)localObject).setArticleContentJson(str);
        str = paramString.optString("json_extend_info", "");
        Intrinsics.checkExpressionValueIsNotNull(str, "json.optString(\"json_extend_info\", \"\")");
        ((ArticleDetailInfo)localObject).setExtendInfoJson(str);
        paramString = paramString.optString("tags", "");
        Intrinsics.checkExpressionValueIsNotNull(paramString, "json.optString(\"tags\", \"\")");
        ((ArticleDetailInfo)localObject).setTags(paramString);
        paramString = new StringBuilder();
        paramString.append("[handleArticleDetailCgiResponse] articleDetailInfo = ");
        paramString.append(localObject);
        QLog.i("DataPreloadModule", 1, paramString.toString());
        if (isArticleDetailAvailable((ArticleDetailInfo)localObject))
        {
          ((Map)articleDetailCache).put(((ArticleDetailInfo)localObject).getRowKey(), localObject);
          RIJPageGenerator.INSTANCE.generatePageHtml((ArticleDetailInfo)localObject);
          RIJWebResourceUtil.a(RIJWebResourceUtil.a, false, 1, null);
          return;
        }
      }
      catch (JSONException paramString)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[handleArticleDetailCgiResponse] e = ");
        ((StringBuilder)localObject).append(paramString);
        QLog.e("DataPreloadModule", 1, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private final void handleArticleDetailResponsePkg(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0xf24.RspBody localRspBody = new oidb_cmd0xf24.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, (MessageMicro)localRspBody);
    if (paramToServiceMsg != null)
    {
      paramToServiceMsg = paramToServiceMsg.getAttribute("attribute_key_rowKey");
      if (paramToServiceMsg != null) {}
    }
    else
    {
      paramToServiceMsg = "";
    }
    if (paramToServiceMsg != null)
    {
      paramFromServiceMsg = (String)paramToServiceMsg;
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("[handleArticleDetailResponsePkg] requestRowKey = ");
      paramToServiceMsg.append(paramFromServiceMsg);
      paramToServiceMsg.append(", result = ");
      paramToServiceMsg.append(i);
      QLog.i("DataPreloadModule", 1, paramToServiceMsg.toString());
      requestList.remove(paramFromServiceMsg);
      if (i == 0)
      {
        paramToServiceMsg = new ArticleDetailInfo();
        if (RIJPBFieldUtils.a(localRspBody.over_length))
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("[handleArticleDetailResponsePkg] requestRowKey = ");
          paramToServiceMsg.append(paramFromServiceMsg);
          paramToServiceMsg.append(", isOverLength.");
          QLog.i("DataPreloadModule", 1, paramToServiceMsg.toString());
          requestArticleDetailByCgi(paramFromServiceMsg);
          return;
        }
        paramFromServiceMsg = RIJPBFieldUtils.a(localRspBody.rowkey, "");
        Intrinsics.checkExpressionValueIsNotNull(paramFromServiceMsg, "RIJPBFieldUtils.toString(rspBody.rowkey, \"\")");
        paramToServiceMsg.setRowKey(paramFromServiceMsg);
        paramToServiceMsg.setArticleId(RIJPBFieldUtils.a(localRspBody.article_id));
        paramFromServiceMsg = RIJPBFieldUtils.a(localRspBody.title, "");
        Intrinsics.checkExpressionValueIsNotNull(paramFromServiceMsg, "RIJPBFieldUtils.toString(rspBody.title, \"\")");
        paramToServiceMsg.setTitle(paramFromServiceMsg);
        paramFromServiceMsg = RIJPBFieldUtils.a(localRspBody.cover_image_url, "");
        Intrinsics.checkExpressionValueIsNotNull(paramFromServiceMsg, "RIJPBFieldUtils.toString…Body.cover_image_url, \"\")");
        paramToServiceMsg.setCoverImageUrl(paramFromServiceMsg);
        paramToServiceMsg.setReadCount(RIJPBFieldUtils.a(localRspBody.read_count));
        paramToServiceMsg.setPublishTime(RIJPBFieldUtils.a(localRspBody.publish_time));
        paramToServiceMsg.setPUin(RIJPBFieldUtils.a(localRspBody.puin));
        paramFromServiceMsg = RIJPBFieldUtils.a(localRspBody.account_avatar_url, "");
        Intrinsics.checkExpressionValueIsNotNull(paramFromServiceMsg, "RIJPBFieldUtils.toString…y.account_avatar_url, \"\")");
        paramToServiceMsg.setAccountAvatarUrl(paramFromServiceMsg);
        paramFromServiceMsg = RIJPBFieldUtils.a(localRspBody.account_name, "");
        Intrinsics.checkExpressionValueIsNotNull(paramFromServiceMsg, "RIJPBFieldUtils.toString(rspBody.account_name, \"\")");
        paramToServiceMsg.setAccountName(paramFromServiceMsg);
        paramFromServiceMsg = RIJPBFieldUtils.a(localRspBody.json_article_content, "");
        Intrinsics.checkExpressionValueIsNotNull(paramFromServiceMsg, "RIJPBFieldUtils.toString…json_article_content, \"\")");
        paramToServiceMsg.setArticleContentJson(paramFromServiceMsg);
        paramFromServiceMsg = RIJPBFieldUtils.a(localRspBody.json_extend_info, "");
        Intrinsics.checkExpressionValueIsNotNull(paramFromServiceMsg, "RIJPBFieldUtils.toString…ody.json_extend_info, \"\")");
        paramToServiceMsg.setExtendInfoJson(paramFromServiceMsg);
        paramFromServiceMsg = RIJPBFieldUtils.a(localRspBody.tags, "");
        Intrinsics.checkExpressionValueIsNotNull(paramFromServiceMsg, "RIJPBFieldUtils.toString(rspBody.tags, \"\")");
        paramToServiceMsg.setTags(paramFromServiceMsg);
        paramToServiceMsg.setOverLength(RIJPBFieldUtils.a(localRspBody.over_length));
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("[handleArticleDetailResponsePkg] articleDetailInfo = ");
        paramFromServiceMsg.append(paramToServiceMsg);
        QLog.i("DataPreloadModule", 1, paramFromServiceMsg.toString());
        if (isArticleDetailAvailable(paramToServiceMsg))
        {
          ((Map)articleDetailCache).put(paramToServiceMsg.getRowKey(), paramToServiceMsg);
          RIJPageGenerator.INSTANCE.generatePageHtml(paramToServiceMsg);
          RIJWebResourceUtil.a(RIJWebResourceUtil.a, false, 1, null);
        }
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
  }
  
  private final boolean isAbleToPreload(String paramString)
  {
    if (requestList.contains(paramString)) {
      return false;
    }
    return !articleDetailCache.containsKey(paramString);
  }
  
  private final boolean isArticleDetailAvailable(ArticleDetailInfo paramArticleDetailInfo)
  {
    if (TextUtils.isEmpty((CharSequence)paramArticleDetailInfo.getRowKey()))
    {
      QLog.i("DataPreloadModule", 1, "[isArticleDetailAvailable] rowKey is empty.");
      return false;
    }
    StringBuilder localStringBuilder;
    if (TextUtils.isEmpty((CharSequence)paramArticleDetailInfo.getTitle()))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[isArticleDetailAvailable] title is empty, rowKey = ");
      localStringBuilder.append(paramArticleDetailInfo.getRowKey());
      QLog.i("DataPreloadModule", 1, localStringBuilder.toString());
      return false;
    }
    if (TextUtils.isEmpty((CharSequence)paramArticleDetailInfo.getArticleContentJson()))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[isArticleDetailAvailable] articleContentJson is empty. rowKey = ");
      localStringBuilder.append(paramArticleDetailInfo.getRowKey());
      QLog.i("DataPreloadModule", 1, localStringBuilder.toString());
      return false;
    }
    return true;
  }
  
  private final void requestArticleDetailByCgi(String paramString)
  {
    paramString = (Runnable)new DataPreloadModule.requestArticleDetailByCgi.runnable.1(paramString);
    ThreadManager.getSubThreadHandler().post(paramString);
  }
  
  public void onReceive(@Nullable ToServiceMsg paramToServiceMsg, @Nullable FromServiceMsg paramFromServiceMsg, @Nullable Object paramObject)
  {
    CharSequence localCharSequence = (CharSequence)"OidbSvc.0xf24";
    String str;
    if (paramFromServiceMsg != null) {
      str = paramFromServiceMsg.getServiceCmd();
    } else {
      str = null;
    }
    if (TextUtils.equals(localCharSequence, (CharSequence)str)) {
      handleArticleDetailResponsePkg(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void preloadArticle(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "articleInfo");
    if (!RIJWebArticleUtil.a.g()) {
      return;
    }
    if (RIJFeedsType.a(paramAbsBaseArticleInfo))
    {
      QLog.i("DataPreloadModule", 2, "[preloadArticle] article is video type.");
      return;
    }
    if (TextUtils.isEmpty((CharSequence)paramAbsBaseArticleInfo.innerUniqueID))
    {
      QLog.i("DataPreloadModule", 2, "[preloadArticle] rowKey is null.");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[preloadArticle] rowKey = ");
    localStringBuilder.append(paramAbsBaseArticleInfo.innerUniqueID);
    localStringBuilder.append(", title = ");
    localStringBuilder.append(paramAbsBaseArticleInfo.mTitle);
    QLog.i("DataPreloadModule", 1, localStringBuilder.toString());
    paramAbsBaseArticleInfo = (Runnable)new DataPreloadModule.preloadArticle.runnable.1(paramAbsBaseArticleInfo);
    ThreadManager.getSubThreadHandler().post(paramAbsBaseArticleInfo);
  }
  
  public void requestArticleDetailInWebProcess(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rowKey");
    paramString = (Runnable)new DataPreloadModule.requestArticleDetailInWebProcess.runnable.1(paramString);
    ThreadManager.getSubThreadHandler().post(paramString);
  }
  
  public void unInitialize()
  {
    articleDetailCache.clear();
    requestList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.webarticle.DataPreloadModule
 * JD-Core Version:    0.7.0.1
 */