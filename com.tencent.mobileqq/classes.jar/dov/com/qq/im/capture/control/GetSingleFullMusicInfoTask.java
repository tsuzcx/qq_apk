package dov.com.qq.im.capture.control;

import android.text.TextUtils;
import bkwk;
import bofz;
import bogd;
import bohc;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.data.FlowMusic;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
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
  implements INetEngine.INetEngineListener
{
  private bohc jdField_a_of_type_Bohc;
  protected FlowMusic a;
  private INetEngine jdField_a_of_type_ComTencentMobileqqTransfileINetEngine;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  protected FlowMusic b;
  private String b;
  private String c;
  
  public GetSingleFullMusicInfoTask(FlowMusic paramFlowMusic, bohc parambohc)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataFlowMusic = paramFlowMusic;
    this.jdField_a_of_type_Bohc = parambohc;
    paramFlowMusic = (QIMMusicConfigManager)bogd.a(2);
    this.c = paramFlowMusic.getApp().getCurrentAccountUin();
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine = paramFlowMusic.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine;
  }
  
  public GetSingleFullMusicInfoTask(String paramString, bohc parambohc)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Bohc = parambohc;
    paramString = (QIMMusicConfigManager)bogd.a(2);
    this.c = paramString.getApp().getCurrentAccountUin();
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine = paramString.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine;
  }
  
  private static String a(long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("OpitrtqeGzopIlwxs").append("_").append("2000000228").append("_").append("TCOHANTCNlddnsTY").append("_").append("uZliVvhTJzkDPlHX").append("_").append(paramLong);
    localObject = ((StringBuilder)localObject).toString();
    String str = bkwk.a((String)localObject).toLowerCase();
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
    if (this.jdField_a_of_type_Bohc != null)
    {
      this.jdField_a_of_type_Bohc.a(paramBoolean, ???);
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
      HttpNetReq localHttpNetReq = new HttpNetReq();
      localHttpNetReq.mHttpMethod = 0;
      localHttpNetReq.mPrioty = 1;
      localHttpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
      localHttpNetReq.mExcuteTimeLimit = 60000L;
      localHttpNetReq.mCallback = this;
      long l = System.currentTimeMillis() / 1000L;
      String str = ((TicketManagerImpl)bofz.a().getManager(2)).getSkey(this.c);
      HashMap localHashMap = new HashMap();
      localHashMap.put("app_id", "2000000228");
      localHashMap.put("app_key", "TCOHANTCNlddnsTY");
      localHashMap.put("device_id", DeviceInfoUtil.getIMEI());
      localHashMap.put("timestamp", String.valueOf(l));
      localHashMap.put("sign", a(l));
      localHashMap.put("song_mid", ???);
      localHashMap.putAll(a(this.c, str));
      localHttpNetReq.mReqUrl = a("https://open.music.qq.com/fcgi-bin/fcg_music_custom_get_song_info_batch.fcg", localHashMap);
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "QQMusicReq SingleFullMusicInfoTask songId:" + (String)???);
      }
      this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.sendReq(localHttpNetReq);
      if (this.jdField_a_of_type_Bohc != null) {}
    }
    try
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaLangObject.wait(30000L);
        label276:
        return 7;
        ??? = this.jdField_b_of_type_JavaLangString;
      }
    }
    catch (Exception localException)
    {
      break label276;
    }
  }
  
  public void onResp(NetResp paramNetResp)
  {
    if (paramNetResp.mHttpCode == 200)
    {
      if (paramNetResp.mRespData != null)
      {
        paramNetResp = new String(paramNetResp.mRespData);
        if (!TextUtils.isEmpty(paramNetResp))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQInitHandler", 2, "GetSingleFullMusicInfoTask respJson =" + paramNetResp);
          }
          try
          {
            paramNetResp = new JSONObject(paramNetResp);
            if (paramNetResp.optInt("ret", -1) == 0)
            {
              paramNetResp = paramNetResp.optJSONArray("songlist");
              if (paramNetResp == null) {
                return;
              }
              paramNetResp = paramNetResp.optJSONObject(0);
              if (paramNetResp == null) {
                return;
              }
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic = new FlowMusic();
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.albumId = paramNetResp.optInt("album_id");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.albumMid = paramNetResp.optString("album_mid");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.albumName = paramNetResp.optString("album_name");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.albumUrl = paramNetResp.optString("album_pic");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.singerId = paramNetResp.optInt("singer_id");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.singerMid = paramNetResp.optString("singer_mid");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.singerName = paramNetResp.optString("singer_name");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.songId = paramNetResp.optInt("song_id");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.songMid = paramNetResp.optString("song_mid");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.songName = paramNetResp.optString("song_name");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.songPlayTime = paramNetResp.optInt("song_play_time");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.userOwnRule = paramNetResp.optInt("user_own_rule");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.url = paramNetResp.optString("song_play_url");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.size = paramNetResp.optLong("song_size");
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.playable = paramNetResp.optInt("playable", 1);
              this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic.storeTimeStamp = System.currentTimeMillis();
              a(true, this.jdField_b_of_type_ComTencentMobileqqDataFlowMusic);
              return;
            }
            a(false, null);
            return;
          }
          catch (JSONException paramNetResp)
          {
            if (!QLog.isColorLevel()) {
              return;
            }
          }
          QLog.d("QQInitHandler", 2, "GetSingleFullMusicInfoTask e:" + paramNetResp.toString());
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
        QLog.d("QQInitHandler", 2, "GetSingleFullMusicInfoTask resp.mHttpCode:" + paramNetResp.mHttpCode);
      }
      a(false, null);
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.control.GetSingleFullMusicInfoTask
 * JD-Core Version:    0.7.0.1
 */