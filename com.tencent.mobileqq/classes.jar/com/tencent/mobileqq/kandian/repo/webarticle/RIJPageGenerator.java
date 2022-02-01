package com.tencent.mobileqq.kandian.repo.webarticle;

import android.net.Uri;
import android.text.TextUtils;
import com.samskivert.mustache.MustacheException;
import com.samskivert.mustache.Template;
import com.tencent.mobileqq.kandian.repo.webarticle.api.IRIJPageGenerator;
import com.tencent.mobileqq.kandian.repo.webarticle.data.ArticleDetailInfo;
import com.tencent.mobileqq.kandian.repo.webarticle.data.ImageInfo;
import com.tencent.mobileqq.kandian.repo.webarticle.data.IndexInfo;
import com.tencent.mobileqq.kandian.repo.webarticle.data.TextInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/webarticle/RIJPageGenerator;", "Lcom/tencent/mobileqq/kandian/repo/webarticle/api/IRIJPageGenerator;", "()V", "TAG", "", "TPL_NAME_COMMENT_BAR_SCRIPT", "TPL_NAME_COOKIE_SCRIPT", "TPL_NAME_DEBUG_SCRIPT", "TPL_NAME_IMAGE", "TPL_NAME_LONG_PRESS_SCRIPT", "TPL_NAME_PREFIX_SCRIPT", "TPL_NAME_SEA_SCRIPT", "TPL_NAME_TEXT", "hitCacheList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "pageHtmlCache", "Ljava/util/concurrent/ConcurrentHashMap;", "bindHeadResource", "", "indexInfo", "Lcom/tencent/mobileqq/kandian/repo/webarticle/data/IndexInfo;", "bindScriptData", "generateArticleContent", "articleContentJson", "generatePageHtml", "articleDetail", "Lcom/tencent/mobileqq/kandian/repo/webarticle/data/ArticleDetailInfo;", "getDateFromTimeMills", "timeMillis", "", "getPageHtml", "rowKey", "getPageHtmlFromUrl", "Lcom/tencent/smtt/export/external/interfaces/WebResourceResponse;", "url", "getPageHtmlStringFromUrl", "isHitCache", "", "isPageHtmlExist", "renderTemplate", "templateName", "data", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJPageGenerator
  implements IRIJPageGenerator
{
  public static final RIJPageGenerator INSTANCE = new RIJPageGenerator();
  @NotNull
  public static final String TAG = "RIJPageGenerator";
  private static final String TPL_NAME_COMMENT_BAR_SCRIPT = "comment_bar_script";
  private static final String TPL_NAME_COOKIE_SCRIPT = "cookie_script";
  private static final String TPL_NAME_DEBUG_SCRIPT = "debug_script";
  private static final String TPL_NAME_IMAGE = "image";
  private static final String TPL_NAME_LONG_PRESS_SCRIPT = "long_press_script";
  private static final String TPL_NAME_PREFIX_SCRIPT = "prefix_script";
  private static final String TPL_NAME_SEA_SCRIPT = "sea_script";
  private static final String TPL_NAME_TEXT = "text";
  private static final ArrayList<String> hitCacheList = new ArrayList();
  private static final ConcurrentHashMap<String, String> pageHtmlCache = new ConcurrentHashMap();
  
  private final void bindHeadResource(IndexInfo paramIndexInfo)
  {
    String str = RIJWebResourceUtil.a.b("https://beaconcdn.qq.com/sdk/3.1.50/beacon_web.min.js");
    StringBuilder localStringBuilder;
    if (!TextUtils.isEmpty((CharSequence)str))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("<script>");
      localStringBuilder.append(str);
      localStringBuilder.append("</script>");
      paramIndexInfo.setBeaconWebScript(localStringBuilder.toString());
    }
    else
    {
      paramIndexInfo.setBeaconWebScript("<script src=\"https://beaconcdn.qq.com/sdk/3.1.50/beacon_web.min.js\"></script>");
    }
    str = RIJWebResourceUtil.a.b("https://tkd-fe.cdn-go.cn/KdDetailPage/latest/themes/default/client/article/article.css");
    if (!TextUtils.isEmpty((CharSequence)str))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("<style>");
      localStringBuilder.append(str);
      localStringBuilder.append("</style>");
      paramIndexInfo.setArticleCss(localStringBuilder.toString());
    }
    else
    {
      paramIndexInfo.setArticleCss("<link rel=\"stylesheet\" href=\"https://tkd-fe.cdn-go.cn/KdDetailPage/latest/themes/default/client/article/article.css\" type=\"text/css\" />");
    }
    str = RIJWebResourceUtil.a.b("https://watchspot.cdn-go.cn/article-new/latest/css/article_new.css");
    if (!TextUtils.isEmpty((CharSequence)str))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("<style>");
      localStringBuilder.append(str);
      localStringBuilder.append("</style>");
      paramIndexInfo.setArticleNewCss(localStringBuilder.toString());
      return;
    }
    paramIndexInfo.setArticleNewCss("<link rel=\"stylesheet\" href=\"https://watchspot.cdn-go.cn/article-new/latest/css/article_new.css\" type=\"text/css\" />");
  }
  
  private final void bindScriptData(IndexInfo paramIndexInfo)
  {
    String str = RIJWebTemplateFactory.a.b("prefix_script");
    if (str == null) {
      str = "";
    }
    paramIndexInfo.setPrefixScript(str);
    str = RIJWebTemplateFactory.a.b("comment_bar_script");
    if (str == null) {
      str = "";
    }
    paramIndexInfo.setCommentBarScript(str);
    str = RIJWebTemplateFactory.a.b("debug_script");
    if (str == null) {
      str = "";
    }
    paramIndexInfo.setDebugScript(str);
    str = RIJWebTemplateFactory.a.b("sea_script");
    if (str == null) {
      str = "";
    }
    paramIndexInfo.setSeaScript(str);
    str = RIJWebTemplateFactory.a.b("cookie_script");
    if (str == null) {
      str = "";
    }
    paramIndexInfo.setCookieScript(str);
    str = RIJWebTemplateFactory.a.b("long_press_script");
    if (str == null) {
      str = "";
    }
    paramIndexInfo.setLongPressScript(str);
  }
  
  private final String generateArticleContent(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      paramString = new JSONArray(paramString);
      int i = 0;
      int j = paramString.length();
      Object localObject;
      while (i < j)
      {
        localObject = paramString.optJSONObject(i);
        if (localObject != null)
        {
          String str = ((JSONObject)localObject).optString("type");
          if (Intrinsics.areEqual(str, "cnt_article")) {
            localStringBuilder.append(renderTemplate("text", new TextInfo((JSONObject)localObject)));
          } else if (Intrinsics.areEqual(str, "img_url")) {
            localStringBuilder.append(renderTemplate("image", new ImageInfo((JSONObject)localObject)));
          }
        }
        i += 1;
      }
      return paramString;
    }
    catch (JSONException paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[generateArticleContent] error, e = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.e("RIJPageGenerator", 1, ((StringBuilder)localObject).toString());
      paramString = localStringBuilder.toString();
      Intrinsics.checkExpressionValueIsNotNull(paramString, "contentSb.toString()");
    }
  }
  
  private final String getDateFromTimeMills(long paramLong)
  {
    Object localObject1 = new SimpleDateFormat("MM-dd", Locale.CHINA);
    Object localObject2 = Calendar.getInstance();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "calendar");
    ((Calendar)localObject2).setTimeInMillis(paramLong);
    localObject1 = ((SimpleDateFormat)localObject1).format(((Calendar)localObject2).getTime());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[getDateFromTimeMills] timeMillis = ");
    ((StringBuilder)localObject2).append(paramLong);
    ((StringBuilder)localObject2).append(", date = ");
    ((StringBuilder)localObject2).append((String)localObject1);
    QLog.i("RIJPageGenerator", 1, ((StringBuilder)localObject2).toString());
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "date");
    return localObject1;
  }
  
  private final String getPageHtml(String paramString)
  {
    String str = (String)pageHtmlCache.get(paramString);
    if (TextUtils.isEmpty((CharSequence)str))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[getPageHtml] rowKey = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", pageHtml is empty or null.");
      QLog.i("RIJPageGenerator", 1, localStringBuilder.toString());
    }
    return str;
  }
  
  private final String renderTemplate(String paramString, Object paramObject)
  {
    long l = System.currentTimeMillis();
    Template localTemplate = RIJWebTemplateFactory.a.a(paramString);
    Object localObject = "";
    if (localTemplate != null)
    {
      try
      {
        paramObject = localTemplate.execute(paramObject);
        Intrinsics.checkExpressionValueIsNotNull(paramObject, "template.execute(data)");
        try
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[renderTemplate] finished, templateName = ");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(", cost = ");
          ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
          ((StringBuilder)localObject).append(" ms.");
          QLog.i("RIJPageGenerator", 1, ((StringBuilder)localObject).toString());
          return paramObject;
        }
        catch (MustacheException localMustacheException)
        {
          localObject = paramObject;
          paramObject = localMustacheException;
        }
        localStringBuilder = new StringBuilder();
      }
      catch (MustacheException paramObject) {}
      StringBuilder localStringBuilder;
      localStringBuilder.append("[renderTemplate] error, templateName = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", e = ");
      localStringBuilder.append(paramObject);
      QLog.e("RIJPageGenerator", 1, localStringBuilder.toString());
      return localObject;
    }
    paramObject = new StringBuilder();
    paramObject.append("[renderTemplate] template is null, templateName = ");
    paramObject.append(paramString);
    QLog.i("RIJPageGenerator", 1, paramObject.toString());
    return "";
  }
  
  public void generatePageHtml(@NotNull ArticleDetailInfo paramArticleDetailInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramArticleDetailInfo, "articleDetail");
    Object localObject = new IndexInfo();
    ((IndexInfo)localObject).setTitle(paramArticleDetailInfo.getTitle());
    ((IndexInfo)localObject).setCoverImageUrl(paramArticleDetailInfo.getCoverImageUrl());
    ((IndexInfo)localObject).setReadCount(paramArticleDetailInfo.getReadCount());
    ((IndexInfo)localObject).setPublishTime(getDateFromTimeMills(paramArticleDetailInfo.getPublishTime() * 1000));
    ((IndexInfo)localObject).setAccountAvatarUrl(paramArticleDetailInfo.getAccountAvatarUrl());
    ((IndexInfo)localObject).setAccountName(paramArticleDetailInfo.getAccountName());
    ((IndexInfo)localObject).setArticleContent(generateArticleContent(paramArticleDetailInfo.getArticleContentJson()));
    ((IndexInfo)localObject).setPUin(paramArticleDetailInfo.getPUin());
    ((IndexInfo)localObject).setArticleId(paramArticleDetailInfo.getArticleId());
    ((IndexInfo)localObject).setRowKey(paramArticleDetailInfo.getRowKey());
    ((IndexInfo)localObject).setTags(paramArticleDetailInfo.getTags());
    ((IndexInfo)localObject).setExtendInfoJson(paramArticleDetailInfo.getExtendInfoJson());
    bindScriptData((IndexInfo)localObject);
    bindHeadResource((IndexInfo)localObject);
    localObject = renderTemplate("index", localObject);
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty((CharSequence)paramArticleDetailInfo.getRowKey())))
    {
      ((Map)pageHtmlCache).put(paramArticleDetailInfo.getRowKey(), localObject);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[generatePageHtml] failed, articleDetail = ");
    ((StringBuilder)localObject).append(paramArticleDetailInfo);
    QLog.i("RIJPageGenerator", 1, ((StringBuilder)localObject).toString());
  }
  
  @Nullable
  public WebResourceResponse getPageHtmlFromUrl(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    Object localObject1 = Uri.parse(paramString).getQueryParameter("rowkey");
    if (localObject1 == null) {
      localObject1 = "";
    }
    boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
    Object localObject2 = null;
    if (bool)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[getPageHtmlFromUrl] url = ");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(", rowKey is empty.");
      QLog.i("RIJPageGenerator", 1, ((StringBuilder)localObject1).toString());
      return null;
    }
    String str = getPageHtml((String)localObject1);
    if (TextUtils.isEmpty((CharSequence)str))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[getPageHtmlFromUrl] url = ");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(", pageHtml is empty.");
      QLog.i("RIJPageGenerator", 1, ((StringBuilder)localObject1).toString());
      return null;
    }
    if (!hitCacheList.contains(localObject1)) {
      hitCacheList.add(localObject1);
    }
    paramString = localObject2;
    if (str != null)
    {
      paramString = Charsets.UTF_8;
      if (str != null)
      {
        paramString = str.getBytes(paramString);
        Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).getBytes(charset)");
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      }
    }
    return new WebResourceResponse("text/html", "utf-8", (InputStream)new BufferedInputStream((InputStream)new ByteArrayInputStream(paramString)));
  }
  
  @Nullable
  public final String getPageHtmlStringFromUrl(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    Object localObject = Uri.parse(paramString).getQueryParameter("rowkey");
    if (localObject == null) {
      localObject = "";
    }
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[getPageHtmlFromUrl] url = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", rowKey is empty.");
      QLog.i("RIJPageGenerator", 1, ((StringBuilder)localObject).toString());
      return null;
    }
    String str = getPageHtml((String)localObject);
    if (TextUtils.isEmpty((CharSequence)str))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[getPageHtmlFromUrl] url = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", pageHtml is empty.");
      QLog.i("RIJPageGenerator", 1, ((StringBuilder)localObject).toString());
      return null;
    }
    if (!hitCacheList.contains(localObject)) {
      hitCacheList.add(localObject);
    }
    return str;
  }
  
  public boolean isHitCache(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rowKey");
    return (hitCacheList.contains(paramString)) && (isPageHtmlExist(paramString));
  }
  
  public boolean isPageHtmlExist(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rowKey");
    return pageHtmlCache.containsKey(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.webarticle.RIJPageGenerator
 * JD-Core Version:    0.7.0.1
 */