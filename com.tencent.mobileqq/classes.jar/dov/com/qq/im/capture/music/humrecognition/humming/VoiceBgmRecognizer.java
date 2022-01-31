package dov.com.qq.im.capture.music.humrecognition.humming;

import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegCommandAlreadyRunningException;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.music.humrecognition.HumUtils;
import dov.com.qq.im.capture.music.humrecognition.recognize.RecognitionManager;
import java.io.File;

public class VoiceBgmRecognizer
  implements IRecognizer
{
  private File a;
  
  public void a()
  {
    if ((this.a == null) || (!this.a.exists()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("VoiceBgmRecognizer", 2, "recognize: invoked. info: mTargetAudioFile = " + this.a);
      }
      return;
    }
    RecognitionManager localRecognitionManager = (RecognitionManager)QIMManager.a().c(10);
    localRecognitionManager.a(this.a);
    try
    {
      HumUtils.a(this.a.getAbsolutePath(), this.a.getAbsolutePath() + "_8kHz", localRecognitionManager);
      return;
    }
    catch (FFmpegCommandAlreadyRunningException localFFmpegCommandAlreadyRunningException)
    {
      QLog.d("VoiceBgmRecognizer", 1, String.format("e = %s", new Object[] { localFFmpegCommandAlreadyRunningException }));
    }
  }
  
  public void a(File paramFile)
  {
    this.a = paramFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.music.humrecognition.humming.VoiceBgmRecognizer
 * JD-Core Version:    0.7.0.1
 */