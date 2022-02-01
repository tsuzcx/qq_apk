package dov.com.qq.im.capture.control;

import android.text.TextUtils;
import beum;
import beuo;
import beuq;
import bevl;
import bevm;
import bevn;
import bhlo;
import bhnv;
import blev;
import bplg;
import bplq;
import bpmp;
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
  implements beuq
{
  private beuo jdField_a_of_type_Beuo;
  private bpmp jdField_a_of_type_Bpmp;
  protected FlowMusic a;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  protected FlowMusic b;
  private String b;
  private String c;
  
  public GetSingleFullMusicInfoTask(FlowMusic paramFlowMusic, bpmp parambpmp)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataFlowMusic = paramFlowMusic;
    this.jdField_a_of_type_Bpmp = parambpmp;
    paramFlowMusic = (QIMMusicConfigManager)bplq.a(2);
    this.c = paramFlowMusic.a().getCurrentAccountUin();
    this.jdField_a_of_type_Beuo = paramFlowMusic.jdField_a_of_type_Beuo;
  }
  
  public GetSingleFullMusicInfoTask(String paramString, bpmp parambpmp)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Bpmp = parambpmp;
    paramString = (QIMMusicConfigManager)bplq.a(2);
    this.c = paramString.a().getCurrentAccountUin();
    this.jdField_a_of_type_Beuo = paramString.jdField_a_of_type_Beuo;
  }
  
  private static String a(long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("OpitrtqeGzopIlwxs").append("_").append("2000000025").append("_").append("SApgehUTVGxZKBQZTt").append("_").append("QmnkKmaTHNDozKdIUA").append("_").append(paramLong);
    localObject = ((StringBuilder)localObject).toString();
    String str = blev.a((String)localObject).toLowerCase();
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
    if (this.jdField_a_of_type_Bpmp != null)
    {
      this.jdField_a_of_type_Bpmp.a(paramBoolean, ???);
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
      beum localbeum = new beum();
      localbeum.jdField_a_of_type_Int = 0;
      localbeum.d = 1;
      localbeum.b = bhnv.a(bevn.a().a());
      localbeum.c = 60000L;
      localbeum.jdField_a_of_type_Beuq = this;
      long l = System.currentTimeMillis() / 1000L;
      String str = ((TicketManagerImpl)bplg.a().getManager(2)).getSkey(this.c);
      HashMap localHashMap = new HashMap();
      localHashMap.put("app_id", "2000000025");
      localHashMap.put("app_key", "SApgehUTVGxZKBQZTt");
      localHashMap.put("device_id", bhlo.a());
      localHashMap.put("timestamp", String.valueOf(l));
      localHashMap.put("sign", a(l));
      localHashMap.put("song_mid", ???);
      localHashMap.putAll(a(this.c, str));
      localbeum.jdField_a_of_type_JavaLangString = a("https://open.music.qq.com/fcgi-bin/fcg_music_custom_get_song_info_batch.fcg", localHashMap);
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "QQMusicReq SingleFullMusicInfoTask songId:" + (String)???);
      }
      this.jdField_a_of_type_Beuo.a(localbeum);
      if (this.jdField_a_of_type_Bpmp != null) {}
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
  
  public void onResp(bevm parambevm)
  {
    if (parambevm.c == 200)
    {
      if (parambevm.a != null)
      {
        parambevm = new String(parambevm.a);
        if (!TextUtils.isEmpty(parambevm))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQInitHandler", 2, "GetSingleFullMusicInfoTask respJson =" + parambevm);
          }
          try
          {
            parambevm = new JSONObject(parambevm);
            if (parambevm.optInt("ret", -1) == 0)
            {
              parambevm = parambevm.optJSONArray("songlist");
              if (parambevm == null) {
                return;
              }
              parambevm = parambevm.optJSONObject(0);
              if (parambevm == null) {
                return;
              }
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic = new FlowMusic();
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.albumId = parambevm.optInt("album_id");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.albumMid = parambevm.optString("album_mid");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.albumName = parambevm.optString("album_name");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.albumUrl = parambevm.optString("album_pic");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.singerId = parambevm.optInt("singer_id");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.singerMid = parambevm.optString("singer_mid");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.singerName = parambevm.optString("singer_name");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.songId = parambevm.optInt("song_id");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.songMid = parambevm.optString("song_mid");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.songName = parambevm.optString("song_name");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.songPlayTime = parambevm.optInt("song_play_time");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.userOwnRule = parambevm.optInt("user_own_rule");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.url = parambevm.optString("song_play_url");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.size = parambevm.optLong("song_size");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.playable = parambevm.optInt("playable", 1);
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.storeTimeStamp = System.currentTimeMillis();
              a(true, this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic);
              return;
            }
            a(false, null);
            return;
          }
          catch (JSONException parambevm)
          {
            if (!QLog.isColorLevel()) {
              return;
            }
          }
          QLog.d("QQInitHandler", 2, "GetSingleFullMusicInfoTask e:" + parambevm.toString());
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
        QLog.d("QQInitHandler", 2, "GetSingleFullMusicInfoTask resp.mHttpCode:" + parambevm.c);
      }
      a(false, null);
    }
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.control.GetSingleFullMusicInfoTask
 * JD-Core Version:    0.7.0.1
 */