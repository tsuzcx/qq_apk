package cooperation.qzone.webviewplugin;

import amma;
import ammb;
import android.media.MediaRecorder;
import java.io.IOException;

public class QzoneAudioRecordPlugin$SimpleAACRecorder
{
  private double jdField_a_of_type_Double;
  private int jdField_a_of_type_Int;
  private MediaRecorder jdField_a_of_type_AndroidMediaMediaRecorder;
  private QzoneAudioRecordPlugin.SimpleAACRecorder.RecorderListener jdField_a_of_type_CooperationQzoneWebviewpluginQzoneAudioRecordPlugin$SimpleAACRecorder$RecorderListener;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  private int d;
  
  public QzoneAudioRecordPlugin$SimpleAACRecorder(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    if (paramInt3 > 0)
    {
      this.c = paramInt3;
      if (paramInt4 <= 0) {
        break label41;
      }
    }
    for (;;)
    {
      this.d = paramInt4;
      return;
      paramInt3 = 512000;
      break;
      label41:
      paramInt4 = 60000;
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_CooperationQzoneWebviewpluginQzoneAudioRecordPlugin$SimpleAACRecorder$RecorderListener != null) {
      this.jdField_a_of_type_CooperationQzoneWebviewpluginQzoneAudioRecordPlugin$SimpleAACRecorder$RecorderListener.a(this.jdField_a_of_type_JavaLangString, paramInt, paramString);
    }
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_Boolean = false;
      try
      {
        if (this.jdField_a_of_type_AndroidMediaMediaRecorder != null)
        {
          this.jdField_a_of_type_AndroidMediaMediaRecorder.stop();
          this.jdField_a_of_type_AndroidMediaMediaRecorder.release();
          this.jdField_a_of_type_AndroidMediaMediaRecorder = null;
        }
        label39:
        if (this.jdField_a_of_type_CooperationQzoneWebviewpluginQzoneAudioRecordPlugin$SimpleAACRecorder$RecorderListener == null) {
          continue;
        }
        double d1 = System.currentTimeMillis();
        double d2 = this.jdField_a_of_type_Double;
        this.jdField_a_of_type_CooperationQzoneWebviewpluginQzoneAudioRecordPlugin$SimpleAACRecorder$RecorderListener.a(this.jdField_a_of_type_JavaLangString, d1 - d2);
        return;
      }
      catch (Exception localException)
      {
        break label39;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        break label39;
      }
    }
  }
  
  public void a(QzoneAudioRecordPlugin.SimpleAACRecorder.RecorderListener paramRecorderListener)
  {
    this.jdField_a_of_type_CooperationQzoneWebviewpluginQzoneAudioRecordPlugin$SimpleAACRecorder$RecorderListener = paramRecorderListener;
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_CooperationQzoneWebviewpluginQzoneAudioRecordPlugin$SimpleAACRecorder$RecorderListener != null) {
        this.jdField_a_of_type_CooperationQzoneWebviewpluginQzoneAudioRecordPlugin$SimpleAACRecorder$RecorderListener.a(paramString, -2, "already running");
      }
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaRecorder = new MediaRecorder();
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setAudioSource(1);
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setAudioSamplingRate(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setAudioEncodingBitRate(this.b);
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setOutputFormat(2);
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setAudioEncoder(3);
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setMaxFileSize(this.c);
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setMaxDuration(this.d);
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setOnInfoListener(new amma(this));
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setOnErrorListener(new ammb(this));
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setOutputFile(paramString);
      this.jdField_a_of_type_AndroidMediaMediaRecorder.prepare();
      if (this.jdField_a_of_type_CooperationQzoneWebviewpluginQzoneAudioRecordPlugin$SimpleAACRecorder$RecorderListener != null) {
        this.jdField_a_of_type_CooperationQzoneWebviewpluginQzoneAudioRecordPlugin$SimpleAACRecorder$RecorderListener.a(paramString);
      }
      this.jdField_a_of_type_AndroidMediaMediaRecorder.start();
      if (this.jdField_a_of_type_CooperationQzoneWebviewpluginQzoneAudioRecordPlugin$SimpleAACRecorder$RecorderListener != null) {
        this.jdField_a_of_type_CooperationQzoneWebviewpluginQzoneAudioRecordPlugin$SimpleAACRecorder$RecorderListener.a();
      }
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Double = System.currentTimeMillis();
      return;
    }
    catch (IllegalStateException paramString)
    {
      a(-1, paramString.toString());
      return;
    }
    catch (IOException paramString)
    {
      a(-1, paramString.toString());
      return;
    }
    catch (Exception paramString)
    {
      a(-1, paramString.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneAudioRecordPlugin.SimpleAACRecorder
 * JD-Core Version:    0.7.0.1
 */