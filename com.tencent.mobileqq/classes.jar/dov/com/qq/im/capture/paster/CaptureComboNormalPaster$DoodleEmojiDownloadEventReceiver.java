package dov.com.qq.im.capture.paster;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import com.tribe.async.dispatch.QQUIEventReceiver;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager.DoodleEmojiDownloadEvent;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.NormalFacePackage;

public class CaptureComboNormalPaster$DoodleEmojiDownloadEventReceiver
  extends QQUIEventReceiver
{
  public CaptureComboNormalPaster$DoodleEmojiDownloadEventReceiver(@NonNull CaptureComboNormalPaster paramCaptureComboNormalPaster)
  {
    super(paramCaptureComboNormalPaster);
  }
  
  public void a(@NonNull CaptureComboNormalPaster paramCaptureComboNormalPaster, @NonNull DoodleEmojiManager.DoodleEmojiDownloadEvent paramDoodleEmojiDownloadEvent)
  {
    if (paramDoodleEmojiDownloadEvent.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.pack_id.equals(CaptureComboNormalPaster.b(paramCaptureComboNormalPaster)))
    {
      if (paramDoodleEmojiDownloadEvent.jdField_a_of_type_Int != 0) {
        break label296;
      }
      if (!paramDoodleEmojiDownloadEvent.jdField_a_of_type_Boolean) {
        break label155;
      }
      SLog.b(this.TAG, "notify ui we finish downloading");
      paramCaptureComboNormalPaster.a.b = false;
      paramCaptureComboNormalPaster.a.g = paramDoodleEmojiDownloadEvent.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.getLocalEmojiFolderPath();
      paramCaptureComboNormalPaster.a.c = 0;
      paramCaptureComboNormalPaster.a.d = 0;
      paramCaptureComboNormalPaster.c = 3;
      paramCaptureComboNormalPaster.b();
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "download finished id=" + CaptureComboNormalPaster.b(paramCaptureComboNormalPaster) + " name=" + CaptureComboNormalPaster.a(paramCaptureComboNormalPaster));
      }
      if (CaptureComboNormalPaster.a(paramCaptureComboNormalPaster) != null) {
        Dispatchers.get().unRegisterSubscriber(CaptureComboNormalPaster.a(paramCaptureComboNormalPaster));
      }
    }
    label155:
    label296:
    do
    {
      do
      {
        return;
        SLog.a(this.TAG, "notify ui we new progress : " + paramDoodleEmojiDownloadEvent.b + " / " + paramDoodleEmojiDownloadEvent.jdField_a_of_type_Long);
        paramCaptureComboNormalPaster.a.b = true;
        paramCaptureComboNormalPaster.a.g = null;
        paramCaptureComboNormalPaster.a.c = ((int)paramDoodleEmojiDownloadEvent.jdField_a_of_type_Long);
        paramCaptureComboNormalPaster.a.d = ((int)paramDoodleEmojiDownloadEvent.b);
        paramCaptureComboNormalPaster.c = 1;
      } while (!QLog.isColorLevel());
      QLog.d(this.TAG, 2, "downloading=" + paramCaptureComboNormalPaster.a.d + " max=" + paramCaptureComboNormalPaster.a.c);
      return;
      paramCaptureComboNormalPaster.a.b = false;
      paramCaptureComboNormalPaster.a.g = null;
      paramCaptureComboNormalPaster.a.c = 0;
      paramCaptureComboNormalPaster.a.d = 0;
      SLog.e(this.TAG, "DoodleEmojiDownloadEventReceiver download error = " + paramDoodleEmojiDownloadEvent.jdField_a_of_type_Int);
      VideoEditReport.a("0X80076C9");
      VideoEditReport.b("0X80075DE");
      paramCaptureComboNormalPaster.c = 2;
      paramCaptureComboNormalPaster.a(paramDoodleEmojiDownloadEvent.jdField_a_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "download error id=" + CaptureComboNormalPaster.b(paramCaptureComboNormalPaster) + " name=" + CaptureComboNormalPaster.a(paramCaptureComboNormalPaster));
      }
    } while (CaptureComboNormalPaster.a(paramCaptureComboNormalPaster) == null);
    Dispatchers.get().unRegisterSubscriber(CaptureComboNormalPaster.a(paramCaptureComboNormalPaster));
  }
  
  public Class acceptEventClass()
  {
    return DoodleEmojiManager.DoodleEmojiDownloadEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.paster.CaptureComboNormalPaster.DoodleEmojiDownloadEventReceiver
 * JD-Core Version:    0.7.0.1
 */