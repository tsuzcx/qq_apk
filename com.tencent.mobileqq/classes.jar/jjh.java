import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.av.app.SessionInfo.HeroDetail;
import com.tencent.av.guild.GameHeroesProtocol;
import com.tencent.av.random.RandomWebProtocol;
import com.tencent.av.utils.BitmapTools;
import com.tencent.mobileqq.troop.data.TroopBarShortVideoUploadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class jjh
  extends Thread
{
  long jdField_a_of_type_Long;
  SessionInfo.HeroDetail jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail;
  long b;
  
  public jjh(GameHeroesProtocol paramGameHeroesProtocol, long paramLong1, long paramLong2, SessionInfo.HeroDetail paramHeroDetail)
  {
    this.jdField_a_of_type_Long = paramLong1;
    this.b = paramLong2;
    this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail = paramHeroDetail;
  }
  
  long a(String paramString)
  {
    int i = 0;
    long l3 = -1L;
    long l2 = l3;
    try
    {
      paramString = new JSONObject(paramString);
      l4 = l3;
      l2 = l3;
      if (!paramString.has("data")) {
        break label881;
      }
      l2 = l3;
      paramString = paramString.getJSONObject("data");
      l4 = l3;
      l2 = l3;
      if (!paramString.has("testkey1")) {
        break label881;
      }
      l2 = l3;
      paramString = paramString.getJSONObject("testkey1");
      l4 = l3;
      l2 = l3;
      if (!paramString.has("retBody")) {
        break label881;
      }
      l2 = l3;
      paramString = paramString.getJSONObject("retBody");
      l1 = l3;
      l2 = l3;
      if (paramString.has("result"))
      {
        l2 = l3;
        l1 = paramString.getLong("result");
      }
      l4 = l1;
      l2 = l1;
      if (!paramString.has("data")) {
        break label881;
      }
      l2 = l1;
      localObject1 = paramString.getJSONObject("data");
      l2 = l1;
      if (((JSONObject)localObject1).has("achieve_base"))
      {
        l2 = l1;
        paramString = ((JSONObject)localObject1).getJSONArray("achieve_base");
        l2 = l1;
        j = paramString.length();
        if (j < 0)
        {
          l2 = l1;
          localObject2 = (JSONObject)paramString.get(0);
          l2 = l1;
          if (((JSONObject)localObject2).has("desc"))
          {
            l2 = l1;
            this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).getString("desc");
          }
          l2 = l1;
          if (((JSONObject)localObject2).has("value"))
          {
            l2 = l1;
            this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_b_of_type_JavaLangString = ((JSONObject)localObject2).getString("value");
          }
        }
        if (1 < j)
        {
          l2 = l1;
          localObject2 = (JSONObject)paramString.get(1);
          l2 = l1;
          if (((JSONObject)localObject2).has("desc"))
          {
            l2 = l1;
            this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_c_of_type_JavaLangString = ((JSONObject)localObject2).getString("desc");
          }
          l2 = l1;
          if (((JSONObject)localObject2).has("value"))
          {
            l2 = l1;
            this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.d = ((JSONObject)localObject2).getString("value");
          }
        }
        if (2 < j)
        {
          l2 = l1;
          localObject2 = (JSONObject)paramString.get(2);
          l2 = l1;
          if (((JSONObject)localObject2).has("desc"))
          {
            l2 = l1;
            this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.e = ((JSONObject)localObject2).getString("desc");
          }
          l2 = l1;
          if (((JSONObject)localObject2).has("value"))
          {
            l2 = l1;
            this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.f = ((JSONObject)localObject2).getString("value");
          }
        }
        if (3 < j)
        {
          l2 = l1;
          paramString = (JSONObject)paramString.get(3);
          l2 = l1;
          if (paramString.has("desc"))
          {
            l2 = l1;
            this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.g = paramString.getString("desc");
          }
          l2 = l1;
          if (paramString.has("value"))
          {
            l2 = l1;
            this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.h = paramString.getString("value");
          }
        }
      }
      l2 = l1;
      if (!((JSONObject)localObject1).has("hero_img_url_base")) {
        break label990;
      }
      l2 = l1;
      paramString = ((JSONObject)localObject1).getString("hero_img_url_base");
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        long l1;
        Object localObject1;
        int j;
        Object localObject2;
        l4 = l2;
        continue;
        paramString = null;
      }
      return l4;
    }
    long l4 = l1;
    l2 = l1;
    if (((JSONObject)localObject1).has("achieve_hero"))
    {
      l2 = l1;
      localObject1 = ((JSONObject)localObject1).getJSONArray("achieve_hero");
      l2 = l1;
      j = ((JSONArray)localObject1).length();
      l2 = l1;
      this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_a_of_type_ArrayOfJavaLangString = new String[j];
      l2 = l1;
      this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_b_of_type_ArrayOfJavaLangString = new String[j];
      l2 = l1;
      this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_c_of_type_ArrayOfJavaLangString = new String[j];
      l2 = l1;
      this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap = new Bitmap[j];
      for (;;)
      {
        l4 = l1;
        if (i >= j) {
          break;
        }
        l2 = l1;
        localObject2 = (JSONObject)((JSONArray)localObject1).get(i);
        l2 = l1;
        if (((JSONObject)localObject2).has("name"))
        {
          l2 = l1;
          this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_a_of_type_ArrayOfJavaLangString[i] = ((JSONObject)localObject2).getString("name");
        }
        l2 = l1;
        if (((JSONObject)localObject2).has("level"))
        {
          l2 = l1;
          this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_b_of_type_ArrayOfJavaLangString[i] = ((JSONObject)localObject2).getString("level");
        }
        if (paramString != null)
        {
          l2 = l1;
          if (((JSONObject)localObject2).has("id"))
          {
            l2 = l1;
            localObject2 = ((JSONObject)localObject2).getString("id");
            l2 = l1;
            this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_c_of_type_ArrayOfJavaLangString[i] = paramString.replace("$hero_id$", (CharSequence)localObject2);
            l2 = l1;
            if (QLog.isColorLevel())
            {
              l2 = l1;
              QLog.d("GameHeroesProtocol", 2, "[GameHeroesProtocol] hero head url --->>>: " + this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_c_of_type_ArrayOfJavaLangString[i]);
            }
            l2 = l1;
            this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[i] = BitmapTools.a(this.jdField_a_of_type_ComTencentAvGuildGameHeroesProtocol.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_c_of_type_ArrayOfJavaLangString[i]), 4);
          }
        }
        i += 1;
      }
    }
    try
    {
      label881:
      if ((this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_b_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.d != null) && (this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.f != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.h)))
      {
        this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_a_of_type_Int = 1;
        return l4;
      }
      if (this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_a_of_type_Int >= 0)
      {
        this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_a_of_type_Int = -1;
      }
      else
      {
        paramString = this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail;
        paramString.jdField_a_of_type_Int -= 1;
      }
    }
    catch (JSONException paramString) {}
    paramString.printStackTrace();
    return l4;
    label990:
    while (l4 != 0L) {}
    return -2L;
  }
  
  String a()
  {
    try
    {
      Object localObject = new JSONObject();
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("plat_id", 1);
      localJSONObject1.put("uin", this.jdField_a_of_type_Long);
      localJSONObject1.put("room_id", (int)this.b);
      localJSONObject1.put("tt", 1);
      localJSONObject1.put("qqver", this.jdField_a_of_type_ComTencentAvGuildGameHeroesProtocol.jdField_b_of_type_JavaLangString);
      localJSONObject1.put("net", com.tencent.mobileqq.app.AppConstants.jdField_c_of_type_ArrayOfJavaLangString[com.tencent.mobileqq.utils.NetworkUtil.a(this.jdField_a_of_type_ComTencentAvGuildGameHeroesProtocol.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getBaseContext())]);
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("param", localJSONObject1);
      localJSONObject2.put("module", "league_av_room");
      localJSONObject2.put("method", "get_achieve_info");
      ((JSONObject)localObject).put("testkey1", localJSONObject2);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  void a() {}
  
  void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameHeroesProtocol", 2, "[GameHeroesProtocol] ====== quit pull ====== pullCount: " + this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_ComTencentAvGuildGameHeroesProtocol.jdField_a_of_type_Jjg != null) {
      this.jdField_a_of_type_ComTencentAvGuildGameHeroesProtocol.jdField_a_of_type_Jjg.a();
    }
    a();
    this.jdField_a_of_type_ComTencentAvGuildGameHeroesProtocol.jdField_a_of_type_JavaUtilMap.remove("" + this.jdField_a_of_type_Long + this.b);
  }
  
  public void run()
  {
    try
    {
      String str1 = a();
      String str2 = "https://league.gamecenter.qq.com/cgi-bin/gc_league_asyn_fcgi?g_tk=" + TroopBarShortVideoUploadUtil.a(this.jdField_a_of_type_ComTencentAvGuildGameHeroesProtocol.jdField_c_of_type_JavaLangString) + "&param=" + URLEncoder.encode(str1, "UTF-8");
      String str3 = "uin=o0" + this.jdField_a_of_type_ComTencentAvGuildGameHeroesProtocol.jdField_a_of_type_JavaLangString + ";skey=" + this.jdField_a_of_type_ComTencentAvGuildGameHeroesProtocol.jdField_c_of_type_JavaLangString;
      if (QLog.isColorLevel())
      {
        QLog.d("GameHeroesProtocol", 2, "[GameHeroesProtocol] request: " + str1);
        QLog.d("GameHeroesProtocol", 2, "[GameHeroesProtocol] requestUrl: " + str2);
        QLog.d("GameHeroesProtocol", 2, "[GameHeroesProtocol] cookie: " + str3);
      }
      str1 = URLDecoder.decode(RandomWebProtocol.a(str2, null, str3), "UTF-8");
      long l = a(str1);
      if (QLog.isColorLevel()) {
        QLog.d("GameHeroesProtocol", 2, "[GameHeroesProtocol] *** response(" + l + ") *** : " + str1);
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      label245:
      break label245;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jjh
 * JD-Core Version:    0.7.0.1
 */