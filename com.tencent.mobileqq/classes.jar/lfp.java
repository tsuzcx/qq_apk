import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import java.io.RandomAccessFile;

public class lfp
  extends lfo
{
  public float a;
  public long a;
  public MediaCodec.BufferInfo a;
  public MediaExtractor a;
  public RandomAccessFile a;
  public String a;
  public byte[] a;
  public int b = 0;
  public int c = 2147483647;
  public int d;
  public int e;
  
  public lfp()
  {
    super(null);
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Float = 1.0F;
  }
  
  public String toString()
  {
    return "FileInfo{filename = " + this.jdField_a_of_type_JavaLangString + ", fileType = " + this.b + ", volumeScale = " + this.jdField_a_of_type_Float + ", mixCnt = " + this.c + ", channelNum = " + this.jdField_a_of_type_Int + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lfp
 * JD-Core Version:    0.7.0.1
 */