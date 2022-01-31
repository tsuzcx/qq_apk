import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class lcf
  extends WebViewPlugin
  implements lcd
{
  private bcbe jdField_a_of_type_Bcbe;
  private boolean jdField_a_of_type_Boolean;
  
  public lcf()
  {
    this.mPluginNameSpace = "aioShareMusic";
  }
  
  public void a(String paramString, JSONObject paramJSONObject)
  {
    if ((this.mRuntime == null) || (this.mRuntime.a() == null)) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AioShareMusic.AioShareMusicPlugin", 2, "onEvent（） actionType =" + paramString + " data = " + paramJSONObject.toString());
      }
      if (this.jdField_a_of_type_Bcbe == null) {
        this.jdField_a_of_type_Bcbe = new bcbe(this.mRuntime.a());
      }
      if ("checkAioShareMusic".equals(paramString))
      {
        this.jdField_a_of_type_Bcbe.a(paramJSONObject);
        return;
      }
      if ("startListenAioShareMusic".equals(paramString))
      {
        this.jdField_a_of_type_Bcbe.b(paramJSONObject);
        return;
      }
      if ("updateSongIdToAioShareMusic".equals(paramString)) {
        try
        {
          paramString = paramJSONObject.getString("current_song_id");
          this.jdField_a_of_type_Bcbe.a = paramString;
          if (QLog.isColorLevel())
          {
            QLog.d("AioShareMusicAioShareMusic.AioShareMusicPlugin", 2, "updateSongId() newSongId = " + paramString);
            return;
          }
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
        }
      }
    }
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if ((this.mRuntime == null) || (this.mRuntime.a() == null) || (this.mRuntime.a() == null)) {
      return true;
    }
    if (this.jdField_a_of_type_Bcbe == null) {
      this.jdField_a_of_type_Bcbe = new bcbe(this.mRuntime.a());
    }
    if (QLog.isColorLevel()) {
      QLog.d("AioShareMusicAioShareMusic.AioShareMusicPlugin", 2, "handleEvent() type = " + paramLong);
    }
    if (paramLong == 8589934594L)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Bcbe.a(this.mRuntime.a().getIntent());
        return true;
      }
    }
    else if (paramLong == 8589934622L)
    {
      Object localObject = paramMap.get("intent");
      if ((localObject != null) && ((localObject instanceof Intent)))
      {
        paramString = (Intent)localObject;
        this.jdField_a_of_type_Bcbe.b(paramString);
        return true;
      }
    }
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  public void onCreate()
  {
    super.onCreate();
    lcb.a().a(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Bcbe != null)
    {
      this.jdField_a_of_type_Bcbe.a();
      this.jdField_a_of_type_Bcbe = null;
    }
    lcb.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     lcf
 * JD-Core Version:    0.7.0.1
 */