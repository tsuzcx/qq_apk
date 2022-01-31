import android.media.MediaCodec;
import android.media.MediaFormat;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaExtractor;

public class now
  extends nox
{
  private nor a;
  
  public now(MediaExtractor paramMediaExtractor, boolean paramBoolean, int paramInt, noz paramnoz, nor paramnor)
  {
    super(paramMediaExtractor, paramBoolean, paramInt, paramnoz);
    this.a = paramnor;
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
  
  public void a(noy paramnoy, long paramLong)
  {
    this.a.a(paramnoy.jdField_a_of_type_JavaNioByteBuffer, paramnoy.jdField_a_of_type_Long);
    b(paramnoy);
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
 * Qualified Name:     now
 * JD-Core Version:    0.7.0.1
 */