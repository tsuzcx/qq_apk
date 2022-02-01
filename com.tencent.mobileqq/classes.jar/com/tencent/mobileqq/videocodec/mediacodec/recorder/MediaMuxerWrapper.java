package com.tencent.mobileqq.videocodec.mediacodec.recorder;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.tencent.mobileqq.videocodec.mediacodec.Mp4ReEncoder;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@TargetApi(18)
public class MediaMuxerWrapper
{
  public final MediaMuxer a;
  private final Mp4ReEncoder b;
  private final List<MediaMuxerWrapper.SampleInfo> c = new ArrayList();
  private final HWEncodeListener d;
  private final String e;
  private MediaFormat f;
  private MediaFormat g;
  private MediaFormat h;
  private int i = 1;
  private int j;
  private int k;
  private int l;
  private ByteBuffer m;
  private boolean n;
  
  public MediaMuxerWrapper(Mp4ReEncoder paramMp4ReEncoder, String paramString, HWEncodeListener paramHWEncodeListener)
  {
    this.b = paramMp4ReEncoder;
    this.d = paramHWEncodeListener;
    this.e = paramString;
    this.a = new MediaMuxer(paramString, 0);
  }
  
  private int b(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2) {
          return this.l;
        }
        throw new AssertionError();
      }
      return this.k;
    }
    return this.j;
  }
  
  private void b()
  {
    if (this.f == null) {
      return;
    }
    if ((this.g == null) && (this.i > 0)) {
      return;
    }
    if ((this.i == 2) && (this.h == null)) {
      return;
    }
    this.j = this.a.addTrack(this.f);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Added track #");
    ((StringBuilder)localObject).append(this.j);
    ((StringBuilder)localObject).append(" with ");
    ((StringBuilder)localObject).append(this.f.getString("mime"));
    ((StringBuilder)localObject).append(" to muxer");
    QLog.d("MediaMuxerWrapper", 1, ((StringBuilder)localObject).toString());
    localObject = this.g;
    if (localObject != null)
    {
      this.k = this.a.addTrack((MediaFormat)localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Added track #");
      ((StringBuilder)localObject).append(this.k);
      ((StringBuilder)localObject).append(" with ");
      ((StringBuilder)localObject).append(this.g.getString("mime"));
      ((StringBuilder)localObject).append(" to muxer");
      QLog.d("MediaMuxerWrapper", 1, ((StringBuilder)localObject).toString());
    }
    localObject = this.h;
    int i1 = 0;
    if (localObject != null)
    {
      this.l = this.a.addTrack(this.g);
      QLog.d("MediaMuxerWrapper", 1, new Object[] { "Added second audiotrack #", Integer.valueOf(this.k), " with ", this.h.getString("mime"), " to muxer" });
    }
    this.a.start();
    this.n = true;
    if (this.m == null) {
      this.m = ByteBuffer.allocate(0);
    }
    this.m.flip();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Output format determined, writing ");
    ((StringBuilder)localObject).append(this.c.size());
    ((StringBuilder)localObject).append(" samples / ");
    ((StringBuilder)localObject).append(this.m.limit());
    ((StringBuilder)localObject).append(" bytes to muxer.");
    QLog.d("MediaMuxerWrapper", 1, ((StringBuilder)localObject).toString());
    localObject = new MediaCodec.BufferInfo();
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      MediaMuxerWrapper.SampleInfo localSampleInfo = (MediaMuxerWrapper.SampleInfo)localIterator.next();
      MediaMuxerWrapper.SampleInfo.a(localSampleInfo, (MediaCodec.BufferInfo)localObject, i1);
      this.a.writeSampleData(b(MediaMuxerWrapper.SampleInfo.a(localSampleInfo)), this.m, (MediaCodec.BufferInfo)localObject);
      i1 += MediaMuxerWrapper.SampleInfo.b(localSampleInfo);
    }
    this.c.clear();
    this.m = null;
  }
  
  public void a()
  {
    try
    {
      QLog.d("MediaMuxerWrapper", 1, "release");
      if (this.b.b())
      {
        QLog.d("MediaMuxerWrapper", 1, "release indeed");
        if (this.n)
        {
          this.n = false;
          this.a.stop();
        }
        this.a.release();
        if (this.d != null) {
          this.d.onEncodeFinish(this.e);
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void a(int paramInt, MediaFormat paramMediaFormat)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setOutputFormat ");
    localStringBuilder.append(paramInt);
    QLog.d("MediaMuxerWrapper", 1, localStringBuilder.toString());
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2) {
          this.h = paramMediaFormat;
        } else {
          throw new AssertionError();
        }
      }
      else {
        this.g = paramMediaFormat;
      }
    }
    else {
      this.f = paramMediaFormat;
    }
    b();
  }
  
  public void a(int paramInt, ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    try
    {
      if (this.n)
      {
        this.a.writeSampleData(b(paramInt), paramByteBuffer, paramBufferInfo);
        return;
      }
      paramByteBuffer.limit(paramBufferInfo.offset + paramBufferInfo.size);
      paramByteBuffer.position(paramBufferInfo.offset);
      if (this.m == null) {
        this.m = ByteBuffer.allocateDirect(65536).order(ByteOrder.nativeOrder());
      }
      this.m.put(paramByteBuffer);
      this.c.add(new MediaMuxerWrapper.SampleInfo(paramInt, paramBufferInfo.size, paramBufferInfo, null));
      return;
    }
    catch (Exception paramByteBuffer)
    {
      QLog.e("MediaMuxerWrapper", 1, "writeSampleData error, ", paramByteBuffer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.mediacodec.recorder.MediaMuxerWrapper
 * JD-Core Version:    0.7.0.1
 */