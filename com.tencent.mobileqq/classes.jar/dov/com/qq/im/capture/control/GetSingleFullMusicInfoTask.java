package dov.com.qq.im.capture.control;

import android.text.TextUtils;
import ayrx;
import aysa;
import aysc;
import aysy;
import aysz;
import ayta;
import bbdh;
import bbfj;
import bflg;
import bjal;
import bjav;
import bjbu;
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
  implements aysc
{
  private aysa jdField_a_of_type_Aysa;
  private bjbu jdField_a_of_type_Bjbu;
  protected FlowMusic a;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  protected FlowMusic b;
  private String b;
  private String c;
  
  public GetSingleFullMusicInfoTask(FlowMusic paramFlowMusic, bjbu parambjbu)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataFlowMusic = paramFlowMusic;
    this.jdField_a_of_type_Bjbu = parambjbu;
    paramFlowMusic = (QIMMusicConfigManager)bjav.a(2);
    this.c = paramFlowMusic.a().getCurrentAccountUin();
    this.jdField_a_of_type_Aysa = paramFlowMusic.jdField_a_of_type_Aysa;
  }
  
  public GetSingleFullMusicInfoTask(String paramString, bjbu parambjbu)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Bjbu = parambjbu;
    paramString = (QIMMusicConfigManager)bjav.a(2);
    this.c = paramString.a().getCurrentAccountUin();
    this.jdField_a_of_type_Aysa = paramString.jdField_a_of_type_Aysa;
  }
  
  private static String a(long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("OpitrtqeGzopIlwxs").append("_").append("2000000025").append("_").append("SApgehUTVGxZKBQZTt").append("_").append("QmnkKmaTHNDozKdIUA").append("_").append(paramLong);
    localObject = ((StringBuilder)localObject).toString();
    String str = bflg.a((String)localObject).toLowerCase();
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
    if (this.jdField_a_of_type_Bjbu != null)
    {
      this.jdField_a_of_type_Bjbu.a(paramBoolean, ???);
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
      ayrx localayrx = new ayrx();
      localayrx.jdField_a_of_type_Int = 0;
      localayrx.e = 1;
      localayrx.jdField_c_of_type_Int = bbfj.a(ayta.a().a());
      localayrx.jdField_c_of_type_Long = 60000L;
      localayrx.jdField_a_of_type_Aysc = this;
      long l = System.currentTimeMillis() / 1000L;
      String str = ((TicketManagerImpl)bjal.a().getManager(2)).getSkey(this.c);
      HashMap localHashMap = new HashMap();
      localHashMap.put("app_id", "2000000025");
      localHashMap.put("app_key", "SApgehUTVGxZKBQZTt");
      localHashMap.put("device_id", bbdh.a());
      localHashMap.put("timestamp", String.valueOf(l));
      localHashMap.put("sign", a(l));
      localHashMap.put("song_mid", ???);
      localHashMap.putAll(a(this.c, str));
      localayrx.jdField_a_of_type_JavaLangString = a("https://open.music.qq.com/fcgi-bin/fcg_music_custom_get_song_info_batch.fcg", localHashMap);
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "QQMusicReq SingleFullMusicInfoTask songId:" + (String)???);
      }
      this.jdField_a_of_type_Aysa.a(localayrx);
      if (this.jdField_a_of_type_Bjbu != null) {}
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
  
  public void onResp(aysz paramaysz)
  {
    if (paramaysz.jdField_c_of_type_Int == 200)
    {
      if (paramaysz.a != null)
      {
        paramaysz = new String(paramaysz.a);
        if (!TextUtils.isEmpty(paramaysz))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQInitHandler", 2, "GetSingleFullMusicInfoTask respJson =" + paramaysz);
          }
          try
          {
            paramaysz = new JSONObject(paramaysz);
            if (paramaysz.optInt("ret", -1) == 0)
            {
              paramaysz = paramaysz.optJSONArray("songlist");
              if (paramaysz == null) {
                return;
              }
              paramaysz = paramaysz.optJSONObject(0);
              if (paramaysz == null) {
                return;
              }
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic = new FlowMusic();
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.albumId = paramaysz.optInt("album_id");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.albumMid = paramaysz.optString("album_mid");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.albumName = paramaysz.optString("album_name");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.albumUrl = paramaysz.optString("album_pic");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.singerId = paramaysz.optInt("singer_id");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.singerMid = paramaysz.optString("singer_mid");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.singerName = paramaysz.optString("singer_name");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.songId = paramaysz.optInt("song_id");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.songMid = paramaysz.optString("song_mid");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.songName = paramaysz.optString("song_name");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.songPlayTime = paramaysz.optInt("song_play_time");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.userOwnRule = paramaysz.optInt("user_own_rule");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.url = paramaysz.optString("song_play_url");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.size = paramaysz.optLong("song_size");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.playable = paramaysz.optInt("playable", 1);
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.storeTimeStamp = System.currentTimeMillis();
              a(true, this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic);
              return;
            }
            a(false, null);
            return;
          }
          catch (JSONException paramaysz)
          {
            if (!QLog.isColorLevel()) {
              return;
            }
          }
          QLog.d("QQInitHandler", 2, "GetSingleFullMusicInfoTask e:" + paramaysz.toString());
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
        QLog.d("QQInitHandler", 2, "GetSingleFullMusicInfoTask resp.mHttpCode:" + paramaysz.jdField_c_of_type_Int);
      }
      a(false, null);
    }
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.control.GetSingleFullMusicInfoTask
 * JD-Core Version:    0.7.0.1
 */