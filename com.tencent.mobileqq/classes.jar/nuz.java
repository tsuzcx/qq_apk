import android.media.MediaCodec;
import android.media.MediaFormat;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaExtractor;

public class nuz
  extends nva
{
  private nuu a;
  
  public nuz(MediaExtractor paramMediaExtractor, boolean paramBoolean, int paramInt, nvc paramnvc, nuu paramnuu)
  {
    super(paramMediaExtractor, paramBoolean, paramInt, paramnvc);
    this.a = paramnuu;
    a();
  }
  
  protected void a(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
  {
    super.a(paramMediaCodec, paramMediaFormat);
    this.a.a(paramMediaFormat);
  }
  
  protected void a(MediaFormat paramMediaFormat)
  {
    this.a.a(paramMediaFormat);
  }
  
  public void a(nvb paramnvb, long paramLong)
  {
    this.a.a(paramnvb.jdField_a_of_type_JavaNioByteBuffer, paramnvb.jdField_a_of_type_Long);
    b(paramnvb);
  }
  
  protected boolean a()
  {
    if (!c()) {
      return this.a.a() < 200000L;
    }
    return super.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nuz
 * JD-Core Version:    0.7.0.1
 */