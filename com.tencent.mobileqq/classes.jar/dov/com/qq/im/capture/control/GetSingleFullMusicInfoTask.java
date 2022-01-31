package dov.com.qq.im.capture.control;

import android.text.TextUtils;
import baps;
import bapv;
import bapx;
import baqv;
import baqw;
import baqx;
import bdcb;
import bdee;
import bhma;
import bllv;
import blmf;
import blne;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.data.FlowMusic;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.TicketManagerImpl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GetSingleFullMusicInfoTask
  extends AsyncStep
  implements bapx
{
  private bapv jdField_a_of_type_Bapv;
  private blne jdField_a_of_type_Blne;
  protected FlowMusic a;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  protected FlowMusic b;
  private String b;
  private String c;
  
  public GetSingleFullMusicInfoTask(FlowMusic paramFlowMusic, blne paramblne)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataFlowMusic = paramFlowMusic;
    this.jdField_a_of_type_Blne = paramblne;
    paramFlowMusic = (QIMMusicConfigManager)blmf.a(2);
    this.c = paramFlowMusic.a().getCurrentAccountUin();
    this.jdField_a_of_type_Bapv = paramFlowMusic.jdField_a_of_type_Bapv;
  }
  
  public GetSingleFullMusicInfoTask(String paramString, blne paramblne)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Blne = paramblne;
    paramString = (QIMMusicConfigManager)blmf.a(2);
    this.c = paramString.a().getCurrentAccountUin();
    this.jdField_a_of_type_Bapv = paramString.jdField_a_of_type_Bapv;
  }
  
  private static String a(long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("OpitrtqeGzopIlwxs").append("_").append("2000000025").append("_").append("SApgehUTVGxZKBQZTt").append("_").append("QmnkKmaTHNDozKdIUA").append("_").append(paramLong);
    localObject = ((StringBuilder)localObject).toString();
    String str = bhma.a((String)localObject).toLowerCase();
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "generate the sign string, pre=" + (String)localObject + ", md5=" + str);
    }
    return str;
  }
  
  private String a(String paramString, Map<String, String> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    if (!paramMap.isEmpty())
    {
      paramString = paramMap.entrySet().iterator();
      int i = 1;
      if (paramString.hasNext())
      {
        paramMap = (Map.Entry)paramString.next();
        if (i != 0)
        {
          localStringBuilder.append("?");
          i = 0;
        }
        for (;;)
        {
          localStringBuilder.append((String)paramMap.getKey()).append("=").append((String)paramMap.getValue());
          break;
          localStringBuilder.append("&");
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "genQQMusicReqUrl url" + localStringBuilder.toString());
    }
    return localStringBuilder.toString();
  }
  
  private static Map<String, String> a(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("login_type", String.valueOf(1));
    localHashMap.put("uin", paramString1);
    localHashMap.put("ticket_type", "skey");
    localHashMap.put("auth", paramString2);
    return localHashMap;
  }
  
  private void a(boolean paramBoolean, FlowMusic arg2)
  {
    if (this.jdField_a_of_type_Blne != null)
    {
      this.jdField_a_of_type_Blne.a(paramBoolean, ???);
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaLangObject.notify();
      return;
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataFlowMusic != null)
    {
      ??? = this.jdField_a_of_type_ComTencentMobileqqDataFlowMusic.songMid;
      baps localbaps = new baps();
      localbaps.jdField_a_of_type_Int = 0;
      localbaps.e = 1;
      localbaps.jdField_c_of_type_Int = bdee.a(baqx.a().a());
      localbaps.jdField_c_of_type_Long = 60000L;
      localbaps.jdField_a_of_type_Bapx = this;
      long l = System.currentTimeMillis() / 1000L;
      String str = ((TicketManagerImpl)bllv.a().getManager(2)).getSkey(this.c);
      HashMap localHashMap = new HashMap();
      localHashMap.put("app_id", "2000000025");
      localHashMap.put("app_key", "SApgehUTVGxZKBQZTt");
      localHashMap.put("device_id", bdcb.a());
      localHashMap.put("timestamp", String.valueOf(l));
      localHashMap.put("sign", a(l));
      localHashMap.put("song_mid", ???);
      localHashMap.putAll(a(this.c, str));
      localbaps.jdField_a_of_type_JavaLangString = a("https://open.music.qq.com/fcgi-bin/fcg_music_custom_get_song_info_batch.fcg", localHashMap);
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "QQMusicReq SingleFullMusicInfoTask songId:" + (String)???);
      }
      this.jdField_a_of_type_Bapv.a(localbaps);
      if (this.jdField_a_of_type_Blne != null) {}
    }
    try
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaLangObject.wait(30000L);
        label274:
        return 7;
        ??? = this.jdField_b_of_type_JavaLangString;
      }
    }
    catch (Exception localException)
    {
      break label274;
    }
  }
  
  public void onResp(baqw parambaqw)
  {
    if (parambaqw.jdField_c_of_type_Int == 200)
    {
      if (parambaqw.a != null)
      {
        parambaqw = new String(parambaqw.a);
        if (!TextUtils.isEmpty(parambaqw))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQInitHandler", 2, "GetSingleFullMusicInfoTask respJson =" + parambaqw);
          }
          try
          {
            parambaqw = new JSONObject(parambaqw);
            if (parambaqw.optInt("ret", -1) == 0)
            {
              parambaqw = parambaqw.optJSONArray("songlist");
              if (parambaqw == null) {
                return;
              }
              parambaqw = parambaqw.optJSONObject(0);
              if (parambaqw == null) {
                return;
              }
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic = new FlowMusic();
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.albumId = parambaqw.optInt("album_id");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.albumMid = parambaqw.optString("album_mid");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.albumName = parambaqw.optString("album_name");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.albumUrl = parambaqw.optString("album_pic");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.singerId = parambaqw.optInt("singer_id");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.singerMid = parambaqw.optString("singer_mid");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.singerName = parambaqw.optString("singer_name");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.songId = parambaqw.optInt("song_id");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.songMid = parambaqw.optString("song_mid");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.songName = parambaqw.optString("song_name");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.songPlayTime = parambaqw.optInt("song_play_time");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.userOwnRule = parambaqw.optInt("user_own_rule");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.url = parambaqw.optString("song_play_url");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.size = parambaqw.optLong("song_size");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.playable = parambaqw.optInt("playable", 1);
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.storeTimeStamp = System.currentTimeMillis();
              a(true, this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic);
              return;
            }
            a(false, null);
            return;
          }
          catch (JSONException parambaqw)
          {
            if (!QLog.isColorLevel()) {
              return;
            }
          }
          QLog.d("QQInitHandler", 2, "GetSingleFullMusicInfoTask e:" + parambaqw.toString());
        }
      }
      else
      {
        a(false, null);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "GetSingleFullMusicInfoTask resp.mHttpCode:" + parambaqw.jdField_c_of_type_Int);
      }
      a(false, null);
    }
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.capture.control.GetSingleFullMusicInfoTask
 * JD-Core Version:    0.7.0.1
 */