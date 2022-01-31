import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpeg;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegCommandUnit;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegExecuteResponseCallback;

public class otp
  extends BroadcastReceiver
{
  public otp(FFmpeg paramFFmpeg) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("android.intent.action.SCREEN_OFF")) {
      if ((this.a.jdField_a_of_type_Otq != null) && (!this.a.jdField_a_of_type_Otq.a()))
      {
        this.a.b = true;
        SLog.d("Q.qqstory.ffmpeg.FFmpegCmd", "屏幕灭屏了，FFmpeg还在执行当中");
      }
    }
    do
    {
      do
      {
        return;
      } while ((!paramContext.equals("android.intent.action.SCREEN_ON")) || (!this.a.b));
      this.a.b = false;
    } while ((this.a.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegCommandUnit == null) || (this.a.jdField_a_of_type_Int == -9999) || (this.a.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegCommandUnit.a == null));
    if (this.a.jdField_a_of_type_Int == 1)
    {
      this.a.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegCommandUnit.a.a("灭屏后，FFmpeg任务执行成功");
      this.a.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegCommandUnit.a.a(true);
      SLog.d("Q.qqstory.ffmpeg.FFmpegCmd", "灭屏后，FFmpeg任务执行成功");
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Int = -9999;
      return;
      this.a.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegCommandUnit.a.b("灭屏幕，FFmpeg任务执行失败");
      this.a.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegCommandUnit.a.a(false);
      SLog.d("Q.qqstory.ffmpeg.FFmpegCmd", "灭屏幕，FFmpeg任务执行失败");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     otp
 * JD-Core Version:    0.7.0.1
 */