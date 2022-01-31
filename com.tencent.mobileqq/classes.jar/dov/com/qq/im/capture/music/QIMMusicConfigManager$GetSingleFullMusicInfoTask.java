package dov.com.qq.im.capture.music;

import amvw;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.FlowMusic;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.app.TicketManagerImpl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class QIMMusicConfigManager$GetSingleFullMusicInfoTask
  extends amvw
{
  QIMMusicConfigManager.GetSingleMusicInfoCallback jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager$GetSingleMusicInfoCallback;
  String jdField_a_of_type_JavaLangString;
  
  QIMMusicConfigManager$GetSingleFullMusicInfoTask(QIMMusicConfigManager paramQIMMusicConfigManager, String paramString, QIMMusicConfigManager.GetSingleMusicInfoCallback paramGetSingleMusicInfoCallback)
  {
    super(paramQIMMusicConfigManager);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager$GetSingleMusicInfoCallback = paramGetSingleMusicInfoCallback;
  }
  
  public void a(NetResp paramNetResp)
  {
    if (paramNetResp.jdField_c_of_type_Int == 200)
    {
      if (paramNetResp.a != null)
      {
        paramNetResp = new String(paramNetResp.a);
        if (!TextUtils.isEmpty(paramNetResp))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QIMMusicConfigManager", 2, "GetSingleFullMusicInfoTask respJson =" + paramNetResp);
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
              FlowMusic localFlowMusic = new FlowMusic();
              localFlowMusic.albumId = paramNetResp.optInt("album_id");
              localFlowMusic.albumMid = paramNetResp.optString("album_mid");
              localFlowMusic.albumName = paramNetResp.optString("album_name");
              localFlowMusic.singerId = paramNetResp.optInt("singer_id");
              localFlowMusic.singerMid = paramNetResp.optString("singer_mid");
              localFlowMusic.singerName = paramNetResp.optString("singer_name");
              localFlowMusic.songId = paramNetResp.optInt("song_id");
              localFlowMusic.songMid = paramNetResp.optString("song_mid");
              localFlowMusic.songName = paramNetResp.optString("song_name");
              localFlowMusic.songPlayTime = paramNetResp.optInt("song_play_time");
              localFlowMusic.userOwnRule = paramNetResp.optInt("user_own_rule");
              localFlowMusic.url = paramNetResp.optString("song_play_url");
              localFlowMusic.size = paramNetResp.optLong("song_size");
              localFlowMusic.playable = paramNetResp.optInt("playable", 1);
              localFlowMusic.storeTimeStamp = System.currentTimeMillis();
              if (this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager$GetSingleMusicInfoCallback == null) {
                return;
              }
              this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager$GetSingleMusicInfoCallback.a(true, localFlowMusic);
              return;
            }
            if (this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager$GetSingleMusicInfoCallback == null) {
              return;
            }
            this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager$GetSingleMusicInfoCallback.a(false, null);
            return;
          }
          catch (JSONException paramNetResp)
          {
            if (!QLog.isColorLevel()) {
              return;
            }
          }
          QLog.d("QIMMusicConfigManager", 2, "GetSingleFullMusicInfoTask e:" + paramNetResp.toString());
        }
      }
      else if (this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager$GetSingleMusicInfoCallback != null)
      {
        this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager$GetSingleMusicInfoCallback.a(false, null);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMMusicConfigManager", 2, "GetSingleFullMusicInfoTask resp.mHttpCode:" + paramNetResp.jdField_c_of_type_Int);
      }
      if (this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager$GetSingleMusicInfoCallback != null) {
        this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager$GetSingleMusicInfoCallback.a(false, null);
      }
    }
  }
  
  public void run()
  {
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.jdField_a_of_type_Int = 0;
    localHttpNetReq.e = 1;
    localHttpNetReq.jdField_c_of_type_Int = NetworkUtil.a(NetworkCenter.a().a());
    localHttpNetReq.jdField_c_of_type_Long = 60000L;
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
    long l = System.currentTimeMillis() / 1000L;
    String str = ((TicketManagerImpl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getSkey(this.b);
    HashMap localHashMap = new HashMap();
    localHashMap.put("app_id", "2000000025");
    localHashMap.put("app_key", "SApgehUTVGxZKBQZTt");
    localHashMap.put("device_id", DeviceInfoUtil.a());
    localHashMap.put("timestamp", String.valueOf(l));
    localHashMap.put("sign", a(l));
    localHashMap.put("song_mid", this.jdField_a_of_type_JavaLangString);
    localHashMap.putAll(a(this.b, str));
    localHttpNetReq.jdField_a_of_type_JavaLangString = a("https://open.music.qq.com/fcgi-bin/fcg_music_custom_get_song_info_batch.fcg", localHashMap);
    if (QLog.isColorLevel()) {
      QLog.d("QIMMusicConfigManager", 2, "GetSingleFullMusicInfoTask songId:" + this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.a(localHttpNetReq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.music.QIMMusicConfigManager.GetSingleFullMusicInfoTask
 * JD-Core Version:    0.7.0.1
 */