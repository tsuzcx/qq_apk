import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.takevideo.EditVideoDoodle;
import com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiItem;
import com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager.DoodleEmojiDownloadEvent;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePackage;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.NormalFacePackage;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class oeg
  extends QQUIEventReceiver
{
  public oeg(@NonNull EditVideoDoodle paramEditVideoDoodle)
  {
    super(paramEditVideoDoodle);
  }
  
  public void a(@NonNull EditVideoDoodle paramEditVideoDoodle, @NonNull DoodleEmojiManager.DoodleEmojiDownloadEvent paramDoodleEmojiDownloadEvent)
  {
    if (paramDoodleEmojiDownloadEvent.jdField_a_of_type_Int != 0) {
      paramEditVideoDoodle.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a("fail_face", 0, 0, new String[0]);
    }
    oej localoej = paramEditVideoDoodle.jdField_a_of_type_Oej;
    if (localoej != null)
    {
      Object localObject = localoej.a(paramDoodleEmojiDownloadEvent.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.a);
      if (!(localObject instanceof NormalFacePackage))
      {
        SLog.d(this.TAG, "DoodleEmojiDownloadEventReceiver no FacePackage found by pack id = " + paramDoodleEmojiDownloadEvent.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.a);
        return;
      }
      localObject = (NormalFacePackage)localObject;
      if (paramDoodleEmojiDownloadEvent.jdField_a_of_type_Int == 0)
      {
        if (paramDoodleEmojiDownloadEvent.jdField_a_of_type_Boolean)
        {
          SLog.b(this.TAG, "notify ui we finish downloading");
          ((NormalFacePackage)localObject).jdField_a_of_type_Boolean = false;
          ((NormalFacePackage)localObject).f = paramDoodleEmojiDownloadEvent.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.a();
          ((NormalFacePackage)localObject).jdField_a_of_type_Int = 0;
          ((NormalFacePackage)localObject).b = 0;
          localoej.a((FacePackage)localObject);
          return;
        }
        SLog.a(this.TAG, "notify ui we new progress : " + paramDoodleEmojiDownloadEvent.b + " / " + paramDoodleEmojiDownloadEvent.jdField_a_of_type_Long);
        ((NormalFacePackage)localObject).jdField_a_of_type_Boolean = true;
        ((NormalFacePackage)localObject).f = null;
        ((NormalFacePackage)localObject).jdField_a_of_type_Int = ((int)paramDoodleEmojiDownloadEvent.jdField_a_of_type_Long);
        ((NormalFacePackage)localObject).b = ((int)paramDoodleEmojiDownloadEvent.b);
        localoej.a((FacePackage)localObject);
        return;
      }
      ((NormalFacePackage)localObject).jdField_a_of_type_Boolean = false;
      ((NormalFacePackage)localObject).f = null;
      ((NormalFacePackage)localObject).jdField_a_of_type_Int = 0;
      ((NormalFacePackage)localObject).b = 0;
      localoej.a((FacePackage)localObject);
      SLog.e(this.TAG, "DoodleEmojiDownloadEventReceiver download error = " + paramDoodleEmojiDownloadEvent.jdField_a_of_type_Int);
      QQToast.a(paramEditVideoDoodle.a(), "下载失败，请稍后重试", 1).a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oeg
 * JD-Core Version:    0.7.0.1
 */