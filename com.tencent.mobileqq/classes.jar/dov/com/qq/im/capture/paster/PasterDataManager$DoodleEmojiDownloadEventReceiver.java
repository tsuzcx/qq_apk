package dov.com.qq.im.capture.paster;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tribe.async.dispatch.QQUIEventReceiver;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoDoodle.DoodleFacePanelAdapter;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager.DoodleEmojiDownloadEvent;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePackage;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.NormalFacePackage;

public class PasterDataManager$DoodleEmojiDownloadEventReceiver
  extends QQUIEventReceiver
{
  public PasterDataManager$DoodleEmojiDownloadEventReceiver(@NonNull PasterDataManager paramPasterDataManager)
  {
    super(paramPasterDataManager);
  }
  
  public void a(@NonNull PasterDataManager paramPasterDataManager, @NonNull DoodleEmojiManager.DoodleEmojiDownloadEvent paramDoodleEmojiDownloadEvent)
  {
    paramPasterDataManager = paramPasterDataManager.a;
    if (paramPasterDataManager != null)
    {
      Object localObject = paramPasterDataManager.a(paramDoodleEmojiDownloadEvent.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.pack_id);
      if (!(localObject instanceof NormalFacePackage))
      {
        SLog.d(this.TAG, "DoodleEmojiDownloadEventReceiver no FacePackage found by pack id = " + paramDoodleEmojiDownloadEvent.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.pack_id);
        return;
      }
      localObject = (NormalFacePackage)localObject;
      if (paramDoodleEmojiDownloadEvent.jdField_a_of_type_Int == 0)
      {
        if (paramDoodleEmojiDownloadEvent.jdField_a_of_type_Boolean)
        {
          SLog.b(this.TAG, "notify ui we finish downloading");
          ((NormalFacePackage)localObject).b = false;
          ((NormalFacePackage)localObject).g = paramDoodleEmojiDownloadEvent.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.getLocalEmojiFolderPath();
          ((NormalFacePackage)localObject).c = 0;
          ((NormalFacePackage)localObject).d = 0;
          paramPasterDataManager.a((FacePackage)localObject);
          return;
        }
        SLog.b(this.TAG, "notify ui we new progress : " + paramDoodleEmojiDownloadEvent.b + " / " + paramDoodleEmojiDownloadEvent.jdField_a_of_type_Long);
        ((NormalFacePackage)localObject).b = true;
        ((NormalFacePackage)localObject).g = null;
        ((NormalFacePackage)localObject).c = ((int)paramDoodleEmojiDownloadEvent.jdField_a_of_type_Long);
        ((NormalFacePackage)localObject).d = ((int)paramDoodleEmojiDownloadEvent.b);
        paramPasterDataManager.a((FacePackage)localObject);
        return;
      }
      ((NormalFacePackage)localObject).b = false;
      ((NormalFacePackage)localObject).g = null;
      ((NormalFacePackage)localObject).c = 0;
      ((NormalFacePackage)localObject).d = 0;
      paramPasterDataManager.a((FacePackage)localObject);
      SLog.e(this.TAG, "DoodleEmojiDownloadEventReceiver download error = " + paramDoodleEmojiDownloadEvent.jdField_a_of_type_Int);
      VideoEditReport.a("0X80076C9");
      VideoEditReport.b("0X80075DE");
      return;
    }
    SLog.b(this.TAG, "DoodleEmojiDownloadEventReceiver adapter is null");
  }
  
  public Class acceptEventClass()
  {
    return DoodleEmojiManager.DoodleEmojiDownloadEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.paster.PasterDataManager.DoodleEmojiDownloadEventReceiver
 * JD-Core Version:    0.7.0.1
 */