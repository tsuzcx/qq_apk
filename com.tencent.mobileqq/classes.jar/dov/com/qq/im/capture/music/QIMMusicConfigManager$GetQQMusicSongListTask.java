package dov.com.qq.im.capture.music;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
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
  
  public void onResp(NetResp paramNetResp)
  {
    if (paramNetResp.mHttpCode == 200)
    {
      if (paramNetResp.mRespData != null)
      {
        QIMMusicConfigManager.GetSongListStepTask localGetSongListStepTask = a();
        localGetSongListStepTask.a = new String(paramNetResp.mRespData);
        localGetSongListStepTask.a();
        this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager.a(0, true, localGetSongListStepTask.a);
        return;
      }
      QIMMusicConfigManager.a(this.this$0, false);
      this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager.a(0, false, "Have no data.");
      return;
    }
    QIMMusicConfigManager.a(this.this$0, false);
    this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager.a(0, false, "Http Request fail, code=" + paramNetResp.mHttpCode);
  }
  
  public void run()
  {
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mPrioty = 1;
    localHttpNetReq.mCallback = this;
    long l = System.currentTimeMillis() / 1000L;
    String str = ((TicketManagerImpl)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(2)).getSkey(this.c);
    HashMap localHashMap = new HashMap();
    localHashMap.put("app_id", "2000000228");
    localHashMap.put("app_key", "TCOHANTCNlddnsTY");
    localHashMap.put("device_id", DeviceInfoUtil.getIMEI());
    localHashMap.put("timestamp", String.valueOf(l));
    localHashMap.put("sign", a(l));
    localHashMap.putAll(a(this.c, str));
    localHttpNetReq.mReqUrl = a("https://open.music.qq.com/fcgi-bin/fcg_music_custom_get_songlist_self.fcg", localHashMap);
    if (QLog.isColorLevel()) {
      QLog.d("QIMMusicConfigManager", 2, "QQMusicReq SongList api request, req url=" + localHttpNetReq.mReqUrl);
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.sendReq(localHttpNetReq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.music.QIMMusicConfigManager.GetQQMusicSongListTask
 * JD-Core Version:    0.7.0.1
 */