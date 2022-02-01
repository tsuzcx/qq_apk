import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/pts/data/DataBiliDoubleItemWhite;", "Lcom/tencent/biz/pubaccount/readinjoy/pts/data/PTSLiteDataFactory$IPTSLiteDataJson;", "()V", "addR5ReportJson", "", "articleInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;", "r5", "Lorg/json/JSONObject;", "bindSubscriptInfo", "jsonData", "getItemJsonObject", "updateDataJson", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class qyf
  implements qyj
{
  public static final qyg a = new qyg(null);
  
  private final JSONObject a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return new JSONObject();
    }
    localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("rowKey", paramArticleInfo.innerUniqueID);
      localJSONObject.put("title", paramArticleInfo.mTitle);
      localJSONObject.put("cover_image_url", paramArticleInfo.mFirstPagePicUrl);
      localJSONObject.put("author", paramArticleInfo.mSubscribeName);
      Object localObject;
      if (!TextUtils.isEmpty((CharSequence)paramArticleInfo.mJsonVideoList))
      {
        localObject = six.a(paramArticleInfo.getVideoDuration() * 1000);
        if (localObject == null) {
          break label177;
        }
        localObject = ((StringBuilder)localObject).toString();
        if (localObject == null) {
          break label177;
        }
      }
      for (;;)
      {
        localJSONObject.put("duration", localObject);
        localJSONObject.put("comment", six.d(paramArticleInfo.mVideoCommentCount));
        localJSONObject.put("count", six.c(paramArticleInfo.mVideoPlayCount));
        if (paramArticleInfo.mCommentCount > 0L) {
          localJSONObject.put("comment", six.d((int)paramArticleInfo.mCommentCount));
        }
        localJSONObject.put("jump_url", paramArticleInfo.mArticleContentUrl);
        break;
        label177:
        localObject = "";
      }
      return localJSONObject;
    }
    catch (JSONException paramArticleInfo)
    {
      QLog.e("DataBiliDoubleItemWhite", 1, "[getItemJsonObject] e = " + paramArticleInfo);
    }
  }
  
  private final void c(ArticleInfo paramArticleInfo, JSONObject paramJSONObject)
  {
    Object localObject2 = null;
    Object localObject1 = paramArticleInfo.mSubArtilceList;
    if (localObject1 != null) {
      localObject1 = (ArticleInfo)((List)localObject1).get(0);
    }
    try
    {
      paramJSONObject.put("left_mark_text", paramArticleInfo.subscriptWording);
      paramJSONObject.put("left_mark_color", qzw.a(paramArticleInfo.subscriptWordingColor));
      paramJSONObject.put("left_mark_backgroundcolor", qzw.a(paramArticleInfo.subscriptBgColor));
      paramJSONObject.put("left_corner_mark", paramArticleInfo.subscriptType);
      if (localObject1 != null)
      {
        paramArticleInfo = ((ArticleInfo)localObject1).subscriptWording;
        label82:
        paramJSONObject.put("right_mark_text", paramArticleInfo);
        if (localObject1 == null) {
          break label164;
        }
        paramArticleInfo = ((ArticleInfo)localObject1).subscriptWordingColor;
        label99:
        paramJSONObject.put("right_mark_color", qzw.a(paramArticleInfo));
        if (localObject1 == null) {
          break label169;
        }
      }
      label164:
      label169:
      for (paramArticleInfo = ((ArticleInfo)localObject1).subscriptBgColor;; paramArticleInfo = null)
      {
        paramJSONObject.put("right_mark_backgroundcolor", qzw.a(paramArticleInfo));
        paramArticleInfo = localObject2;
        if (localObject1 != null) {
          paramArticleInfo = Integer.valueOf(((ArticleInfo)localObject1).subscriptType);
        }
        paramJSONObject.put("right_corner_mark", paramArticleInfo);
        return;
        localObject1 = null;
        break;
        paramArticleInfo = null;
        break label82;
        paramArticleInfo = null;
        break label99;
      }
      return;
    }
    catch (JSONException paramArticleInfo)
    {
      QLog.e("DataBiliDoubleItemWhite", 1, "[bindSubscriptInfo] e = " + paramArticleInfo);
    }
  }
  
  public void a(@NotNull ArticleInfo paramArticleInfo, @NotNull JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramArticleInfo, "articleInfo");
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "jsonData");
    Object localObject = paramArticleInfo.mSubArtilceList;
    if (localObject != null) {}
    for (int i = ((List)localObject).size(); i <= 0; i = 0) {
      return;
    }
    paramJSONObject.put("pts_page_name", "bili_double_items_white");
    JSONArray localJSONArray = new JSONArray();
    localJSONArray.put(0, a(paramArticleInfo));
    localObject = paramArticleInfo.mSubArtilceList;
    if (localObject != null) {}
    for (localObject = (ArticleInfo)((List)localObject).get(0);; localObject = null)
    {
      localJSONArray.put(1, a((ArticleInfo)localObject));
      paramJSONObject.put("datas", localJSONArray);
      c(paramArticleInfo, paramJSONObject);
      return;
    }
  }
  
  public void b(@NotNull ArticleInfo paramArticleInfo, @NotNull JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramArticleInfo, "articleInfo");
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "r5");
    String str;
    int i;
    try
    {
      paramJSONObject.put("feeds_type", 1056);
      if (!TextUtils.isEmpty((CharSequence)paramArticleInfo.mJsonVideoList)) {
        break label119;
      }
      str = "1";
      paramJSONObject.put("double_card_type", str);
      paramArticleInfo = paramArticleInfo.mSubArtilceList;
      if (paramArticleInfo == null) {
        break label126;
      }
      i = paramArticleInfo.size();
    }
    catch (JSONException paramArticleInfo)
    {
      label67:
      QLog.e("DataBiliDoubleItemWhite", 1, "[addR5ReportJson], e = " + paramArticleInfo);
      return;
    }
    paramJSONObject.put("double_card_pos", paramArticleInfo);
    return;
    label129:
    for (;;)
    {
      paramArticleInfo = "1";
      break label67;
      for (;;)
      {
        if (i <= 0) {
          break label129;
        }
        paramArticleInfo = "0";
        break label67;
        label119:
        str = "0";
        break;
        label126:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qyf
 * JD-Core Version:    0.7.0.1
 */