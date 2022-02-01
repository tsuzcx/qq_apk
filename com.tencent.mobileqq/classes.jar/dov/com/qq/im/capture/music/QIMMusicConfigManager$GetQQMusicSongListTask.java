package dov.com.qq.im.capture.music;

import bdvs;
import bdvu;
import bdwt;
import bgln;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.app.TicketManagerImpl;

final class QIMMusicConfigManager$GetQQMusicSongListTask
  extends QIMMusicConfigManager.LoadMusicStepTask
{
  QIMMusicConfigManager$GetQQMusicSongListTask(QIMMusicConfigManager paramQIMMusicConfigManager1, QIMMusicConfigManager paramQIMMusicConfigManager2)
  {
    super(paramQIMMusicConfigManager2);
  }
  
  QIMMusicConfigManager.GetSongListStepTask a()
  {
    return new QIMMusicConfigManager.GetSongListStepTask(this.this$0, this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager);
  }
  
  public void onResp(bdwt parambdwt)
  {
    if (parambdwt.c == 200)
    {
      if (parambdwt.a != null)
      {
        QIMMusicConfigManager.GetSongListStepTask localGetSongListStepTask = a();
        localGetSongListStepTask.jdField_a_of_type_JavaLangString = new String(parambdwt.a);
        localGetSongListStepTask.a();
        this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager.a(0, true, localGetSongListStepTask.jdField_a_of_type_JavaLangString);
        return;
      }
      QIMMusicConfigManager.a(this.this$0, false);
      this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager.a(0, false, "Have no data.");
      return;
    }
    QIMMusicConfigManager.a(this.this$0, false);
    this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager.a(0, false, "Http Request fail, code=" + parambdwt.c);
  }
  
  public void run()
  {
    bdvs localbdvs = new bdvs();
    localbdvs.jdField_a_of_type_Int = 0;
    localbdvs.d = 1;
    localbdvs.jdField_a_of_type_Bdvw = this;
    long l = System.currentTimeMillis() / 1000L;
    String str = ((TicketManagerImpl)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(2)).getSkey(this.c);
    HashMap localHashMap = new HashMap();
    localHashMap.put("app_id", "2000000025");
    localHashMap.put("app_key", "SApgehUTVGxZKBQZTt");
    localHashMap.put("device_id", bgln.a());
    localHashMap.put("timestamp", String.valueOf(l));
    localHashMap.put("sign", a(l));
    localHashMap.putAll(a(this.c, str));
    localbdvs.jdField_a_of_type_JavaLangString = a("https://open.music.qq.com/fcgi-bin/fcg_music_custom_get_songlist_self.fcg", localHashMap);
    if (QLog.isColorLevel()) {
      QLog.d("QIMMusicConfigManager", 2, "QQMusicReq SongList api request, req url=" + localbdvs.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_Bdvu.a(localbdvs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.music.QIMMusicConfigManager.GetQQMusicSongListTask
 * JD-Core Version:    0.7.0.1
 */