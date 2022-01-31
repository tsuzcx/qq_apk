import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

@TargetApi(16)
public class mce
{
  private int jdField_a_of_type_Int;
  private MediaCodec.BufferInfo jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo = new MediaCodec.BufferInfo();
  private MediaCodec jdField_a_of_type_AndroidMediaMediaCodec;
  private MediaExtractor jdField_a_of_type_AndroidMediaMediaExtractor;
  private MediaFormat jdField_a_of_type_AndroidMediaMediaFormat;
  private BufferedOutputStream jdField_a_of_type_JavaIoBufferedOutputStream;
  private FileOutputStream jdField_a_of_type_JavaIoFileOutputStream;
  private String jdField_a_of_type_JavaLangString;
  private mcf jdField_a_of_type_Mcf;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int c;
  private int d;
  private int e;
  private int f;
  
  public mce() {}
  
  public mce(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.c = paramInt3;
  }
  
  private void a()
  {
    ByteBuffer[] arrayOfByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getInputBuffers();
    int i = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueInputBuffer(10000L);
    Object localObject;
    int j;
    if (i >= 0)
    {
      localObject = arrayOfByteBuffer[i];
      ((ByteBuffer)localObject).clear();
      j = this.jdField_a_of_type_AndroidMediaMediaExtractor.readSampleData((ByteBuffer)localObject, 0);
      if (j < 0)
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(i, 0, 0, 0L, 0);
        label66:
        arrayOfByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
      }
    }
    for (;;)
    {
      i = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueOutputBuffer(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo, 10000L);
      if (i >= 0)
      {
        localObject = arrayOfByteBuffer[i];
        byte[] arrayOfByte = new byte[this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size];
        ((ByteBuffer)localObject).get(arrayOfByte);
        ((ByteBuffer)localObject).clear();
        this.jdField_a_of_type_AndroidMediaMediaCodec.releaseOutputBuffer(i, false);
        a(arrayOfByte);
        continue;
        this.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(i, 0, j, 0L, 0);
        this.jdField_a_of_type_AndroidMediaMediaExtractor.advance();
        break;
        if (i != -1) {
          break;
        }
        break label66;
      }
      if (i != -2) {
        return;
      }
      localObject = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputFormat();
      if (QLog.isColorLevel()) {
        QLog.d("AudioFileDecoder", 2, "encoder output format changed: " + localObject);
      }
    }
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {}
    while ((this.d == 0) || (this.e == 0) || (this.f == 0)) {
      return;
    }
    paramArrayOfByte = mch.a(paramArrayOfByte, this.d, this.e, this.f, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.c);
    try
    {
      this.jdField_a_of_type_JavaIoBufferedOutputStream.write(paramArrayOfByte, 0, paramArrayOfByte.length);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      QLog.e("AudioFileDecoder", 1, "writeFile exception", paramArrayOfByte);
      paramArrayOfByte.printStackTrace();
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaCodec != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaCodec.stop();
      this.jdField_a_of_type_AndroidMediaMediaCodec.release();
      this.jdField_a_of_type_AndroidMediaMediaCodec = null;
    }
    if (this.jdField_a_of_type_AndroidMediaMediaExtractor != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaExtractor.release();
      this.jdField_a_of_type_AndroidMediaMediaExtractor = null;
    }
    try
    {
      if (this.jdField_a_of_type_JavaIoBufferedOutputStream != null)
      {
        this.jdField_a_of_type_JavaIoBufferedOutputStream.flush();
        this.jdField_a_of_type_JavaIoBufferedOutputStream.close();
      }
      if (QLog.isColorLevel()) {
        QLog.d("AudioFileDecoder", 2, String.format("decode successful, save to %s, size: %sK", new Object[] { this.jdField_b_of_type_JavaLangString, Long.valueOf(new File(this.jdField_b_of_type_JavaLangString).length() / 1024L) }));
      }
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    int j = 0;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    paramString1 = new File(this.jdField_a_of_type_JavaLangString);
    if (!paramString1.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("AudioFileDecoder", 2, String.format("audio file %s is not exist", new Object[] { this.jdField_a_of_type_JavaLangString }));
      }
      if (this.jdField_a_of_type_Mcf != null) {
        this.jdField_a_of_type_Mcf.a(-2);
      }
      return;
    }
    int i;
    for (;;)
    {
      try
      {
        for (;;)
        {
          this.jdField_a_of_type_AndroidMediaMediaExtractor = new MediaExtractor();
          this.jdField_a_of_type_AndroidMediaMediaExtractor.setDataSource(this.jdField_a_of_type_JavaLangString);
          i = 0;
          if (i < this.jdField_a_of_type_AndroidMediaMediaExtractor.getTrackCount())
          {
            paramString2 = this.jdField_a_of_type_AndroidMediaMediaExtractor.getTrackFormat(i);
            String str = paramString2.getString("mime");
            if (!str.startsWith("audio")) {
              break label281;
            }
            this.jdField_a_of_type_AndroidMediaMediaFormat = paramString2;
            this.jdField_a_of_type_AndroidMediaMediaExtractor.selectTrack(i);
            this.jdField_a_of_type_AndroidMediaMediaCodec = MediaCodec.createDecoderByType(str);
          }
          try
          {
            this.jdField_a_of_type_AndroidMediaMediaCodec.configure(paramString2, null, null, 0);
            if (this.jdField_a_of_type_AndroidMediaMediaCodec != null) {
              break label288;
            }
            QLog.e("AudioFileDecoder", 1, "init audioCodec fail");
            if (this.jdField_a_of_type_Mcf == null) {
              break;
            }
            this.jdField_a_of_type_Mcf.a(-1);
            return;
          }
          catch (Throwable paramString2)
          {
            for (;;)
            {
              if (this.jdField_a_of_type_Mcf != null) {
                this.jdField_a_of_type_Mcf.a(-5);
              }
              QLog.e("AudioFileDecoder", 1, "decode configure exception:" + paramString2, paramString2);
            }
          }
        }
        if (this.jdField_a_of_type_Mcf == null) {
          break;
        }
      }
      catch (IOException paramString1)
      {
        paramString1.printStackTrace();
      }
      this.jdField_a_of_type_Mcf.a(-3);
      return;
      label281:
      i += 1;
    }
    label288:
    this.d = this.jdField_a_of_type_AndroidMediaMediaFormat.getInteger("sample-rate");
    this.f = this.jdField_a_of_type_AndroidMediaMediaFormat.getInteger("channel-count");
    this.e = 16;
    if (QLog.isColorLevel()) {
      QLog.d("AudioFileDecoder", 2, String.format("decode audio sampleRate: %s, channelCount: %s, bitDeepth: %s", new Object[] { Integer.valueOf(this.d), Integer.valueOf(this.f), Integer.valueOf(this.e) }));
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(this.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_JavaIoBufferedOutputStream = new BufferedOutputStream(this.jdField_a_of_type_JavaIoFileOutputStream);
        if (QLog.isColorLevel()) {
          QLog.d("AudioFileDecoder", 2, String.format("start decode file %s, size: %sK", new Object[] { this.jdField_a_of_type_JavaLangString, Long.valueOf(paramString1.length() / 1024L) }));
        }
      }
      catch (IOException paramString2)
      {
        try
        {
          this.jdField_a_of_type_AndroidMediaMediaCodec.start();
          if (this.jdField_a_of_type_Mcf != null) {
            this.jdField_a_of_type_Mcf.a(this.jdField_a_of_type_JavaLangString);
          }
          this.jdField_a_of_type_Boolean = false;
          if (this.jdField_a_of_type_Boolean) {
            break label652;
          }
          try
          {
            a();
          }
          catch (Throwable paramString1)
          {
            QLog.e("AudioFileDecoder", 1, "decode frame exception:" + paramString1, paramString1);
            i = j;
            if (this.jdField_a_of_type_Mcf != null)
            {
              this.jdField_a_of_type_Mcf.a(-6);
              i = j;
            }
          }
          b();
          if ((i == 0) || (this.jdField_a_of_type_Mcf == null)) {
            break;
          }
          this.jdField_a_of_type_Mcf.b(this.jdField_b_of_type_JavaLangString);
          return;
        }
        catch (Exception paramString1)
        {
          QLog.e("AudioFileDecoder", 1, "decode start exception:" + paramString1, paramString1);
        }
        paramString2 = paramString2;
        QLog.e("AudioFileDecoder", 1, "decode io exception:" + paramString2, paramString2);
        continue;
      }
      if (this.jdField_a_of_type_Mcf == null) {
        break;
      }
      this.jdField_a_of_type_Mcf.a(-4);
      return;
      label652:
      i = 1;
    }
  }
  
  public void a(mcf parammcf)
  {
    this.jdField_a_of_type_Mcf = parammcf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mce
 * JD-Core Version:    0.7.0.1
 */