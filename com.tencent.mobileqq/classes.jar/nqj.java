import android.media.MediaCodec;
import android.media.MediaFormat;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaExtractor;

public class nqj
  extends nqk
{
  private nqe a;
  
  public nqj(MediaExtractor paramMediaExtractor, boolean paramBoolean, int paramInt, nqm paramnqm, nqe paramnqe)
  {
    super(paramMediaExtractor, paramBoolean, paramInt, paramnqm);
    this.a = paramnqe;
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
  
  public void a(nql paramnql, long paramLong)
  {
    this.a.a(paramnql.jdField_a_of_type_JavaNioByteBuffer, paramnql.jdField_a_of_type_Long);
    b(paramnql);
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
 * Qualified Name:     nqj
 * JD-Core Version:    0.7.0.1
 */