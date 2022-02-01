package com.tencent.mobileqq.magicface.model;

import android.media.AudioRecord;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.qphone.base.util.QLog;

public class RecordVolume
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private AudioRecord jdField_a_of_type_AndroidMediaAudioRecord;
  private RecordVolume.RecordVolumeListener jdField_a_of_type_ComTencentMobileqqMagicfaceModelRecordVolume$RecordVolumeListener;
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  public RecordVolume(RecordVolume.RecordVolumeListener paramRecordVolumeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelRecordVolume$RecordVolumeListener = paramRecordVolumeListener;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void run()
  {
    try
    {
      int i = RecordParams.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = AudioRecord.getMinBufferSize(i, 2, 2);
      this.jdField_a_of_type_AndroidMediaAudioRecord = new AudioRecord(1, i, 2, 2, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidMediaAudioRecord.startRecording();
      short[] arrayOfShort = new short[this.jdField_a_of_type_Int];
      this.jdField_a_of_type_Boolean = true;
      for (;;)
      {
        boolean bool = this.jdField_a_of_type_Boolean;
        if (!bool) {
          break;
        }
        try
        {
          int j = this.jdField_a_of_type_AndroidMediaAudioRecord.read(arrayOfShort, 0, this.jdField_a_of_type_Int);
          long l = 0L;
          i = 0;
          while (i < arrayOfShort.length)
          {
            l += arrayOfShort[i] * arrayOfShort[i];
            i += 1;
          }
          if ((j != 0) && (l != 0L))
          {
            double d = 10.0D * Math.log10(l / j);
            if (QLog.isColorLevel()) {
              QLog.i("recordVolume", 2, "====dB===" + d);
            }
            if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelRecordVolume$RecordVolumeListener != null) {
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelRecordVolume$RecordVolumeListener.a((int)Math.round(d));
            }
          }
          Thread.sleep(100L);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
      try
      {
        if (this.jdField_a_of_type_AndroidMediaAudioRecord.getRecordingState() == 3) {
          this.jdField_a_of_type_AndroidMediaAudioRecord.stop();
        }
        this.jdField_a_of_type_AndroidMediaAudioRecord.release();
        this.jdField_a_of_type_AndroidMediaAudioRecord = null;
        if (QLog.isColorLevel()) {
          QLog.i("RecordVolume", 2, "====recordVolume release ok==");
        }
        throw localObject;
      }
      catch (Exception localException4)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("RecordVolume", 2, "RecordVolume exception=" + localException4.getMessage());
          }
        }
      }
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
      if (this.jdField_a_of_type_AndroidMediaAudioRecord != null) {}
      try
      {
        if (this.jdField_a_of_type_AndroidMediaAudioRecord.getRecordingState() == 3) {
          this.jdField_a_of_type_AndroidMediaAudioRecord.stop();
        }
        this.jdField_a_of_type_AndroidMediaAudioRecord.release();
        this.jdField_a_of_type_AndroidMediaAudioRecord = null;
        if (QLog.isColorLevel()) {
          QLog.i("RecordVolume", 2, "====recordVolume release ok==");
        }
        for (;;)
        {
          return;
          if (this.jdField_a_of_type_AndroidMediaAudioRecord == null) {
            continue;
          }
          try
          {
            if (this.jdField_a_of_type_AndroidMediaAudioRecord.getRecordingState() == 3) {
              this.jdField_a_of_type_AndroidMediaAudioRecord.stop();
            }
            this.jdField_a_of_type_AndroidMediaAudioRecord.release();
            this.jdField_a_of_type_AndroidMediaAudioRecord = null;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.i("RecordVolume", 2, "====recordVolume release ok==");
            return;
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.i("RecordVolume", 2, "RecordVolume exception=" + localException2.getMessage());
              }
            }
          }
        }
      }
      catch (Exception localException3)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("RecordVolume", 2, "RecordVolume exception=" + localException3.getMessage());
          }
        }
      }
    }
    finally
    {
      if (this.jdField_a_of_type_AndroidMediaAudioRecord == null) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.model.RecordVolume
 * JD-Core Version:    0.7.0.1
 */