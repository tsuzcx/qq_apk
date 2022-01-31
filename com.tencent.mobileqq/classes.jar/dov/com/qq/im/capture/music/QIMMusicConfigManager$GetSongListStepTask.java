package dov.com.qq.im.capture.music;

import ayrx;
import aysa;
import aysy;
import aysz;
import bbdh;
import bjbs;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.app.TicketManagerImpl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class QIMMusicConfigManager$GetSongListStepTask
  extends QIMMusicConfigManager.LoadMusicStepTask
{
  String a;
  
  QIMMusicConfigManager$GetSongListStepTask(QIMMusicConfigManager paramQIMMusicConfigManager1, QIMMusicConfigManager paramQIMMusicConfigManager2)
  {
    super(paramQIMMusicConfigManager2);
  }
  
  public void onResp(aysz paramaysz)
  {
    if (paramaysz.c == 200)
    {
      if (paramaysz.a != null)
      {
        paramaysz = new String(paramaysz.a);
        PeakAppInterface.a.a(String.valueOf(1008), new Object[] { paramaysz });
        return;
      }
      QIMMusicConfigManager.a(this.this$0, false);
      this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager.a(1, false, "have no data.");
      return;
    }
    QIMMusicConfigManager.a(this.this$0, false);
    this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager.a(1, false, "Http Request fail, code=" + paramaysz.c);
  }
  
  public void run()
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = new JSONObject(this.jdField_a_of_type_JavaLangString);
        if (((JSONObject)localObject1).optInt("ret", -1) != 0) {
          break label389;
        }
        localObject1 = ((JSONObject)localObject1).optJSONArray("data");
        if (localObject1 == null) {
          break label389;
        }
        i = 0;
        if (i < ((JSONArray)localObject1).length())
        {
          Object localObject2 = ((JSONArray)localObject1).optJSONObject(i);
          if ((localObject2 == null) || (!"我喜欢".equals(((JSONObject)localObject2).optString("diss_name")))) {
            break label390;
          }
          l1 = ((JSONObject)localObject2).optLong("diss_id", -1L);
          if (l1 != -1L)
          {
            localObject1 = new ayrx();
            ((ayrx)localObject1).jdField_a_of_type_Int = 0;
            ((ayrx)localObject1).e = 1;
            ((ayrx)localObject1).jdField_a_of_type_Aysc = this;
            long l2 = System.currentTimeMillis() / 1000L;
            localObject2 = ((TicketManagerImpl)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(2)).getSkey(this.c);
            HashMap localHashMap = new HashMap();
            localHashMap.put("app_id", "2000000025");
            localHashMap.put("app_key", "SApgehUTVGxZKBQZTt");
            localHashMap.put("device_id", bbdh.a());
            localHashMap.put("timestamp", String.valueOf(l2));
            localHashMap.put("sign", a(l2));
            localHashMap.put("dissid", String.valueOf(l1));
            localHashMap.putAll(a(this.c, (String)localObject2));
            ((ayrx)localObject1).jdField_a_of_type_JavaLangString = a("https://open.music.qq.com/fcgi-bin/fcg_music_custom_get_songlist_detail.fcg", localHashMap);
            this.jdField_a_of_type_Aysa.a((aysy)localObject1);
            if (!QLog.isColorLevel()) {
              break label389;
            }
            QLog.d("QIMMusicConfigManager", 2, "QQMusicReq GetSongListStepTask req url=" + ((ayrx)localObject1).jdField_a_of_type_JavaLangString);
            return;
          }
          QIMMusicConfigManager.a(this.this$0, true);
          this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager.a(1, false, "can not find myFav diss.");
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        QIMMusicConfigManager.a(this.this$0, false);
        this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager.a(1, false, "parsed json error, json=" + this.jdField_a_of_type_JavaLangString);
        return;
      }
      long l1 = -1L;
      continue;
      label389:
      return;
      label390:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.music.QIMMusicConfigManager.GetSongListStepTask
 * JD-Core Version:    0.7.0.1
 */