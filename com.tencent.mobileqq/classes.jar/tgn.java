import NS_KING_SOCIALIZE_META.stMetaUgcImage;
import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashMap<Ljava.lang.String;Ljava.lang.String;>;
import org.json.JSONException;
import org.json.JSONObject;

public class tgn
{
  private stSimpleMetaFeed a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      Gson localGson = new Gson();
      stSimpleMetaFeed localstSimpleMetaFeed = new stSimpleMetaFeed();
      localstSimpleMetaFeed.id = paramJSONObject.getString("id");
      localstSimpleMetaFeed.ding_count = paramJSONObject.getInt("dingCount");
      localstSimpleMetaFeed.is_ding = paramJSONObject.getInt("isDing");
      localstSimpleMetaFeed.total_comment_num = paramJSONObject.getInt("commentNum");
      localstSimpleMetaFeed.material_desc = paramJSONObject.getString("materialDesc");
      localstSimpleMetaFeed.material_thumburl = paramJSONObject.getString("materialThumburl");
      localstSimpleMetaFeed.feed_desc = paramJSONObject.getString("feedDesc");
      localstSimpleMetaFeed.video = ((stMetaUgcVideoSeg)localGson.fromJson(paramJSONObject.getJSONObject("video").toString(), stMetaUgcVideoSeg.class));
      localstSimpleMetaFeed.video_url = paramJSONObject.getString("videoUrl");
      ArrayList localArrayList = new ArrayList();
      stMetaUgcImage localstMetaUgcImage = new stMetaUgcImage();
      localstMetaUgcImage.url = paramJSONObject.getString("coverUrl");
      localstMetaUgcImage.height = paramJSONObject.getInt("coverHeight");
      localstMetaUgcImage.width = paramJSONObject.getInt("coverWidth");
      localArrayList.add(localstMetaUgcImage);
      localstSimpleMetaFeed.images = localArrayList;
      localstSimpleMetaFeed.poster_id = paramJSONObject.getString("posterId");
      localstSimpleMetaFeed.poster = ((stSimpleMetaPerson)localGson.fromJson(paramJSONObject.getJSONObject("poster").toString(), stSimpleMetaPerson.class));
      return localstSimpleMetaFeed;
    }
    return null;
  }
  
  private ArrayList<stSimpleMetaFeed> a(HashMap<String, String> paramHashMap)
  {
    if (paramHashMap == null) {
      return null;
    }
    Object localObject = (String)paramHashMap.get("feeds");
    paramHashMap = (String)paramHashMap.get("scene");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    if (TextUtils.isEmpty(paramHashMap)) {
      tlv.c(paramHashMap);
    }
    try
    {
      paramHashMap = URLDecoder.decode((String)localObject, "UTF-8");
      tlo.b("WSMiniAppHelper", "小程序传过来的feed： " + paramHashMap);
    }
    catch (UnsupportedEncodingException paramHashMap)
    {
      for (;;)
      {
        try
        {
          localObject = new ArrayList();
          paramHashMap = a(new JSONObject(paramHashMap));
          if (paramHashMap != null) {
            ((ArrayList)localObject).add(paramHashMap);
          }
          return localObject;
        }
        catch (JSONException paramHashMap)
        {
          paramHashMap.printStackTrace();
          tlo.d("WSMiniAppHelper", "parse json error: " + paramHashMap.getMessage());
        }
        paramHashMap = paramHashMap;
        paramHashMap.printStackTrace();
        paramHashMap = (HashMap<String, String>)localObject;
      }
    }
    return null;
  }
  
  public static tgn a()
  {
    return tgp.a();
  }
  
  public void a(Context paramContext, String paramString)
  {
    MiniAppLauncher.startMiniApp(paramContext, paramString, 2003, new tgo(this));
  }
  
  public boolean a(Context paramContext, HashMap<String, String> paramHashMap)
  {
    if (paramContext == null) {
      return false;
    }
    ArrayList localArrayList = a(paramHashMap);
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      paramHashMap = (stSimpleMetaFeed)localArrayList.get(0);
      if ((paramHashMap.poster == null) || (!TextUtils.equals(paramHashMap.poster.id, tlv.f()))) {}
    }
    for (paramHashMap = "mini_app_personal_main";; paramHashMap = "mini_app_personal_guest")
    {
      WSVerticalPageFragment.a((Activity)paramContext, paramHashMap, localArrayList, 0);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tgn
 * JD-Core Version:    0.7.0.1
 */