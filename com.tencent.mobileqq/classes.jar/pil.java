import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.qqlive.module.videoreport.PageParams;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/dt/RIJDtParamBuilder;", "", "()V", "params", "Ljava/util/HashMap;", "", "addActionID", "actionid", "addArea", "area", "addBackendInfo", "backendInfo", "addChannelID", "channelID", "", "addClickType", "clickType", "addContentType", "type", "addEid", "eid", "addKV", "key", "value", "addMap", "map", "", "addPgId", "id", "addRowkey", "rowkey", "addVideoInfo", "videoInfo", "Lcom/tencent/biz/pubaccount/VideoInfo;", "build", "buildPageParams", "Lcom/tencent/qqlive/module/videoreport/PageParams;", "isShortVideo", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class pil
{
  private final HashMap<String, Object> a = new HashMap();
  
  public pil()
  {
    Map localMap = (Map)this.a;
    String str = pik.a;
    Intrinsics.checkExpressionValueIsNotNull(str, "RIJDtConstant.APP_KEY");
    localMap.put("dt_appkey", str);
  }
  
  private final int a(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo != null)
    {
      String str = paramVideoInfo.y;
      if (str != null)
      {
        if (((CharSequence)str).length() > 0) {}
        for (int i = 1; i == 1; i = 0) {
          return new JSONObject(paramVideoInfo.y).optInt("short_v");
        }
      }
    }
    if ((paramVideoInfo != null) && (paramVideoInfo.c > paramVideoInfo.b)) {
      return 1;
    }
    return 0;
  }
  
  @NotNull
  public final PageParams a()
  {
    return new PageParams((Map)this.a);
  }
  
  @NotNull
  public final Map<String, Object> a()
  {
    return (Map)this.a;
  }
  
  @JvmOverloads
  @NotNull
  public final pil a()
  {
    return a(this, null, 1, null);
  }
  
  @NotNull
  public final pil a(@Nullable VideoInfo paramVideoInfo)
  {
    Map localMap = (Map)this.a;
    Object localObject;
    label55:
    int i;
    if (paramVideoInfo != null)
    {
      localObject = paramVideoInfo.a;
      if (localObject != null)
      {
        localMap.put("vid", localObject);
        localMap = (Map)this.a;
        if (paramVideoInfo == null) {
          break label204;
        }
        localObject = paramVideoInfo.g;
        if (localObject == null) {
          break label204;
        }
        localMap.put("rowkey", localObject);
        ((Map)this.a).put("cid", "");
        ((Map)this.a).put("cmsid", "");
        localObject = (Map)this.a;
        if (a(paramVideoInfo) != 1) {
          break label210;
        }
        i = 1;
        label119:
        ((Map)localObject).put("content_type", Integer.valueOf(i));
        localMap = (Map)this.a;
        if (paramVideoInfo == null) {
          break label216;
        }
        localObject = paramVideoInfo.y;
        if (localObject == null) {
          break label216;
        }
        label154:
        localMap.put("backend_info", localObject);
        localObject = (Map)this.a;
        if (paramVideoInfo == null) {
          break label222;
        }
        paramVideoInfo = paramVideoInfo.j;
        if (paramVideoInfo == null) {
          break label222;
        }
      }
    }
    for (;;)
    {
      ((Map)localObject).put("puin", paramVideoInfo);
      return this;
      localObject = "";
      break;
      label204:
      localObject = "";
      break label55;
      label210:
      i = 6;
      break label119;
      label216:
      localObject = "";
      break label154;
      label222:
      paramVideoInfo = "";
    }
  }
  
  @NotNull
  public final pil a(@NotNull Number paramNumber)
  {
    Intrinsics.checkParameterIsNotNull(paramNumber, "channelID");
    ((Map)this.a).put("channel_id", paramNumber.toString());
    return this;
  }
  
  @NotNull
  public final pil a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "id");
    ((Map)this.a).put("dt_pgid", paramString);
    return this;
  }
  
  @NotNull
  public final pil a(@NotNull String paramString, @NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    Intrinsics.checkParameterIsNotNull(paramObject, "value");
    ((Map)this.a).put(paramString, paramObject);
    return this;
  }
  
  @NotNull
  public final pil a(@NotNull Map<String, ? extends Object> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "map");
    this.a.putAll(paramMap);
    return this;
  }
  
  @NotNull
  public final pil b(@NotNull Number paramNumber)
  {
    Intrinsics.checkParameterIsNotNull(paramNumber, "type");
    ((Map)this.a).put("content_type", paramNumber);
    return this;
  }
  
  @NotNull
  public final pil b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "area");
    ((Map)this.a).put("area", paramString);
    return this;
  }
  
  @NotNull
  public final pil c(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "actionid");
    ((Map)this.a).put("actionid", paramString);
    return this;
  }
  
  @JvmOverloads
  @NotNull
  public final pil d(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "clickType");
    ((Map)this.a).put("click_type", paramString);
    return this;
  }
  
  @NotNull
  public final pil e(@Nullable String paramString)
  {
    Map localMap = (Map)this.a;
    if (paramString != null) {}
    for (;;)
    {
      localMap.put("rowkey", paramString);
      return this;
      paramString = "null";
    }
  }
  
  @NotNull
  public final pil f(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "eid");
    ((Map)this.a).put("eid", paramString);
    return this;
  }
  
  @NotNull
  public final pil g(@Nullable String paramString)
  {
    if (paramString != null) {
      ((Map)this.a).put("backend_info", paramString);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pil
 * JD-Core Version:    0.7.0.1
 */