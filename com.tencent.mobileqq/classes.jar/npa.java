import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.util.Log;
import android.view.Surface;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaExtractor;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer.SeekMode;

@TargetApi(16)
public class npa
  extends nox
{
  private Surface jdField_a_of_type_AndroidViewSurface;
  private boolean jdField_a_of_type_Boolean;
  
  public npa(MediaExtractor paramMediaExtractor, boolean paramBoolean1, int paramInt, noz paramnoz, Surface paramSurface, boolean paramBoolean2)
  {
    super(paramMediaExtractor, paramBoolean1, paramInt, paramnoz);
    this.jdField_a_of_type_AndroidViewSurface = paramSurface;
    this.jdField_a_of_type_Boolean = paramBoolean2;
    a();
  }
  
  @TargetApi(16)
  private long a(long paramLong, MediaExtractor paramMediaExtractor, MediaCodec paramMediaCodec)
  {
    paramMediaCodec.flush();
    paramMediaExtractor.a(paramLong, 0);
    if (paramMediaExtractor.a() == paramLong)
    {
      Log.d(this.jdField_a_of_type_JavaLangString, "skip fastseek, already there");
      return paramLong;
    }
    b();
    a(false);
    paramMediaExtractor.a(paramLong, 0);
    long l1 = 0L;
    long l3 = 9223372036854775807L;
    int i = 0;
    while ((paramMediaExtractor.a()) && (i < 20))
    {
      long l5 = paramLong - paramMediaExtractor.a();
      long l4 = l3;
      long l2 = l1;
      if (l5 >= 0L)
      {
        l4 = l3;
        l2 = l1;
        if (l5 < l3)
        {
          l2 = paramMediaExtractor.a();
          l4 = l5;
        }
      }
      l3 = l4;
      l1 = l2;
      if (l5 < 0L)
      {
        i += 1;
        l3 = l4;
        l1 = l2;
      }
    }
    paramMediaExtractor.a(l1, 0);
    while (paramMediaExtractor.a() != l1) {
      paramMediaExtractor.a();
    }
    Log.d(this.jdField_a_of_type_JavaLangString, "exact fastseek match:       " + paramMediaExtractor.a());
    return l1;
  }
  
  public int a()
  {
    MediaFormat localMediaFormat = a();
    if (localMediaFormat != null)
    {
      float f = localMediaFormat.getInteger("height");
      return (int)(localMediaFormat.getFloat("mpx-dar") * f);
    }
    return 0;
  }
  
  protected noy a(MediaPlayer.SeekMode paramSeekMode, long paramLong, MediaExtractor paramMediaExtractor, MediaCodec paramMediaCodec)
  {
    long l1 = -1L;
    long l2 = paramLong / 1000L;
    noy localnoy2 = super.a(paramSeekMode, paramLong, paramMediaExtractor, paramMediaCodec);
    if (localnoy2 == null)
    {
      paramSeekMode = null;
      return paramSeekMode;
    }
    noy localnoy1;
    if ((paramSeekMode.b() == 3) || (paramSeekMode.b() == 2) || (paramSeekMode.b() == 0) || (paramSeekMode.b() == 1))
    {
      Log.d(this.jdField_a_of_type_JavaLangString, "fast seek to " + paramLong + " arrived at " + localnoy2.jdField_a_of_type_Long);
      paramLong = l2;
      localnoy1 = localnoy2;
    }
    for (;;)
    {
      paramSeekMode = localnoy1;
      if (l1 != paramLong) {
        break;
      }
      Log.d(this.jdField_a_of_type_JavaLangString, "exact seek match!");
      return localnoy1;
      if (paramSeekMode.b() == 6)
      {
        a(localnoy2, false);
        a(paramLong, paramMediaExtractor, paramMediaCodec);
        paramMediaExtractor = a(true, true);
        if (paramMediaExtractor == null) {
          return null;
        }
        Log.d(this.jdField_a_of_type_JavaLangString, "fast_exact seek to " + paramLong + " arrived at " + paramMediaExtractor.jdField_a_of_type_Long);
        paramSeekMode = paramMediaExtractor;
        if (paramMediaExtractor.jdField_a_of_type_Long >= paramLong) {
          break;
        }
        Log.d(this.jdField_a_of_type_JavaLangString, "presentation is behind...");
        return paramMediaExtractor;
      }
      if (paramSeekMode.b() != 4)
      {
        localnoy1 = localnoy2;
        paramLong = l2;
        if (paramSeekMode.b() != 5) {}
      }
      else
      {
        paramLong = localnoy2.jdField_a_of_type_Long / 1000L;
        int i = 0;
        localnoy1 = localnoy2;
        l1 = l2;
        l2 = -1L;
        while (paramLong < l1)
        {
          if (i == 0) {
            Log.d(this.jdField_a_of_type_JavaLangString, "skipping frames...");
          }
          i += 1;
          if (b()) {
            l1 = localnoy1.jdField_a_of_type_Long / 1000L;
          }
          if (localnoy1.jdField_a_of_type_Boolean)
          {
            Log.d(this.jdField_a_of_type_JavaLangString, "end of stream reached, seeking to last frame");
            a(localnoy1, false);
            return a(paramSeekMode, l2, paramMediaExtractor, paramMediaCodec);
          }
          l2 = localnoy1.jdField_a_of_type_Long;
          a(localnoy1, false);
          localnoy1 = a(true, true);
          if (localnoy1 == null) {
            return null;
          }
          paramLong = localnoy1.jdField_a_of_type_Long / 1000L;
        }
        Log.d(this.jdField_a_of_type_JavaLangString, "frame new position:         " + localnoy1.jdField_a_of_type_Long);
        Log.d(this.jdField_a_of_type_JavaLangString, "seeking finished, skipped " + i + " frames");
        if ((paramSeekMode.b() == 5) && (paramLong > l1))
        {
          if (i == 0)
          {
            Log.w(this.jdField_a_of_type_JavaLangString, "this should never happen");
            l2 = paramLong;
            paramLong = l1;
            l1 = l2;
          }
          else
          {
            Log.d(this.jdField_a_of_type_JavaLangString, "exact seek: repeat seek for previous frame at " + l2);
            a(localnoy1, false);
            return a(paramSeekMode, l2, paramMediaExtractor, paramMediaCodec);
          }
        }
        else
        {
          l2 = paramLong;
          paramLong = l1;
          l1 = l2;
        }
      }
    }
  }
  
  protected void a(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
  {
    paramMediaCodec.configure(paramMediaFormat, this.jdField_a_of_type_AndroidViewSurface, null, 0);
  }
  
  public void a(Surface paramSurface)
  {
    if (paramSurface == null) {
      throw new RuntimeException("surface must not be null");
    }
    this.jdField_a_of_type_AndroidViewSurface = paramSurface;
    a();
  }
  
  @SuppressLint({"NewApi"})
  public void a(noy paramnoy, long paramLong)
  {
    a(paramnoy, true);
  }
  
  public void a(noy paramnoy, boolean paramBoolean)
  {
    a().releaseOutputBuffer(paramnoy.jdField_a_of_type_Int, paramBoolean);
    c(paramnoy);
  }
  
  public int b()
  {
    MediaFormat localMediaFormat = a();
    if (localMediaFormat != null) {
      return localMediaFormat.getInteger("height");
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     npa
 * JD-Core Version:    0.7.0.1
 */