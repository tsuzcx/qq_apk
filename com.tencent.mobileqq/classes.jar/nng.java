import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.musicgene.MusicPlayerActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class nng
{
  public static String a;
  public static String b = "msg_back";
  long jdField_a_of_type_Long = 0L;
  awei jdField_a_of_type_Awei = new nnh(this);
  TroopMemberApiService jdField_a_of_type_ComTencentBizTroopTroopMemberApiService;
  private final String c = "QQMusicService";
  
  static
  {
    jdField_a_of_type_JavaLangString = "msg_key";
  }
  
  public nng(TroopMemberApiService paramTroopMemberApiService)
  {
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService = paramTroopMemberApiService;
  }
  
  private JSONObject a(SongInfo paramSongInfo)
  {
    if (paramSongInfo == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("id", paramSongInfo.jdField_a_of_type_Long);
    }
    catch (JSONException localJSONException4)
    {
      try
      {
        localJSONObject.put("audio_url", paramSongInfo.b);
      }
      catch (JSONException localJSONException4)
      {
        try
        {
          localJSONObject.put("title", paramSongInfo.c);
        }
        catch (JSONException localJSONException4)
        {
          try
          {
            localJSONObject.put("desc", paramSongInfo.d);
          }
          catch (JSONException localJSONException4)
          {
            try
            {
              for (;;)
              {
                localJSONObject.put("image_url", paramSongInfo.e);
                try
                {
                  localJSONObject.put("share_url", paramSongInfo.f);
                  return localJSONObject;
                }
                catch (JSONException paramSongInfo)
                {
                  paramSongInfo.printStackTrace();
                  return localJSONObject;
                }
                localJSONException1 = localJSONException1;
                localJSONException1.printStackTrace();
                continue;
                localJSONException2 = localJSONException2;
                localJSONException2.printStackTrace();
                continue;
                localJSONException3 = localJSONException3;
                localJSONException3.printStackTrace();
                continue;
                localJSONException4 = localJSONException4;
                localJSONException4.printStackTrace();
              }
            }
            catch (JSONException localJSONException5)
            {
              for (;;)
              {
                localJSONException5.printStackTrace();
              }
            }
          }
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      try
      {
        localObject = new JSONObject(paramString);
        paramString = (String)localObject;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          Object localObject;
          if (QLog.isColorLevel()) {
            QLog.i("QQMusicService", 2, "playQQMusic err:" + paramString);
          }
          localJSONException.printStackTrace();
          paramString = null;
        }
      }
    } while (paramString == null);
    paramString.optInt("mtype", 1);
    localObject = new SongInfo();
    ((SongInfo)localObject).jdField_a_of_type_Long = paramString.optLong("id");
    ((SongInfo)localObject).b = paramString.optString("audio_url");
    ((SongInfo)localObject).c = paramString.optString("title");
    ((SongInfo)localObject).d = paramString.optString("desc");
    ((SongInfo)localObject).e = paramString.optString("image_url");
    ((SongInfo)localObject).f = paramString.optString("share_url");
    this.jdField_a_of_type_Long = ((SongInfo)localObject).jdField_a_of_type_Long;
    QQPlayerService.a(new Intent(BaseApplication.getContext(), MusicPlayerActivity.class));
    QQPlayerService.a(this.jdField_a_of_type_Awei);
    QQPlayerService.a(BaseApplication.getContext(), this.jdField_a_of_type_Awei.getToken(), (SongInfo)localObject);
  }
  
  public void a(AppRuntime paramAppRuntime, Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    int i = paramBundle.getInt(jdField_a_of_type_JavaLangString);
    paramAppRuntime = new Bundle();
    paramAppRuntime.putInt(jdField_a_of_type_JavaLangString, i);
    int j = paramBundle.getInt("seq", -1);
    if (j != -1) {
      paramAppRuntime.putInt("seq", j);
    }
    switch (i)
    {
    default: 
      return;
    case 1: 
      a(paramBundle.getString("music"));
      return;
    case 2: 
      QQPlayerService.a(BaseApplication.getContext());
      return;
    case 3: 
      QQPlayerService.b(BaseApplication.getContext());
      return;
    case 4: 
      QQPlayerService.a(this.jdField_a_of_type_Awei);
      paramAppRuntime.putInt("state", QQPlayerService.a());
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(8, paramAppRuntime);
      return;
    case 5: 
      QQPlayerService.a(paramBundle.getInt("mode"));
      return;
    case 6: 
      QQPlayerService.a(this.jdField_a_of_type_Awei);
      paramAppRuntime.putInt("mode", QQPlayerService.b());
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(8, paramAppRuntime);
      return;
    case 7: 
      QQPlayerService.a(this.jdField_a_of_type_Awei);
      paramBundle = a(QQPlayerService.b());
      if (paramBundle != null) {
        paramAppRuntime.putString("music", paramBundle.toString());
      }
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(8, paramAppRuntime);
      return;
    }
    QQPlayerService.c(BaseApplication.getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nng
 * JD-Core Version:    0.7.0.1
 */