package com.tencent.tkd.topicsdk.videoprocess.mediacodec.recorder;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.videoprocess.mediacodec.encoder.Mp4ReEncoder;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import java.util.List;

@TargetApi(18)
public class MediaMuxerWrapper
{
  public final MediaMuxer a;
  private final Mp4ReEncoder b;
  private final List<MediaMuxerWrapper.SampleInfo> c;
  private final HWEncodeListener d;
  private final String e;
  private MediaFormat f;
  private MediaFormat g;
  private MediaFormat h;
  private int i;
  private int j;
  private int k;
  private int l;
  private ByteBuffer m;
  private boolean n;
  
  private int a(int paramInt)
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
    TLog.b("MediaMuxerWrapper", ((StringBuilder)localObject).toString());
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
      TLog.b("MediaMuxerWrapper", ((StringBuilder)localObject).toString());
    }
    if (this.h != null)
    {
      this.l = this.a.addTrack(this.g);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Added second audiotrack #");
      ((StringBuilder)localObject).append(this.k);
      ((StringBuilder)localObject).append(" with ");
      ((StringBuilder)localObject).append(this.h.getString("mime"));
      ((StringBuilder)localObject).append(" to muxer");
      TLog.b("MediaMuxerWrapper", ((StringBuilder)localObject).toString());
    }
    this.a.start();
    this.n = true;
    localObject = this.m;
    int i1 = 0;
    if (localObject == null) {
      this.m = ByteBuffer.allocate(0);
    }
    this.m.flip();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Output format determined, writing ");
    ((StringBuilder)localObject).append(this.c.size());
    ((StringBuilder)localObject).append(" samples / ");
    ((StringBuilder)localObject).append(this.m.limit());
    ((StringBuilder)localObject).append(" bytes to muxer.");
    TLog.b("MediaMuxerWrapper", ((StringBuilder)localObject).toString());
    localObject = new MediaCodec.BufferInfo();
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      MediaMuxerWrapper.SampleInfo localSampleInfo = (MediaMuxerWrapper.SampleInfo)localIterator.next();
      MediaMuxerWrapper.SampleInfo.a(localSampleInfo, (MediaCodec.BufferInfo)localObject, i1);
      this.a.writeSampleData(a(MediaMuxerWrapper.SampleInfo.a(localSampleInfo)), this.m, (MediaCodec.BufferInfo)localObject);
      i1 += MediaMuxerWrapper.SampleInfo.b(localSampleInfo);
    }
    this.c.clear();
    this.m = null;
  }
  
  public void a()
  {
    try
    {
      TLog.b("MediaMuxerWrapper", "release");
      if (this.b.g())
      {
        TLog.b("MediaMuxerWrapper", "release indeed");
        if (this.n)
        {
          this.n = false;
          this.a.stop();
        }
        this.a.release();
        if (this.d != null) {
          this.d.a(this.e);
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(int paramInt, MediaFormat paramMediaFormat)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setOutputFormat ");
    localStringBuilder.append(paramInt);
    TLog.b("MediaMuxerWrapper", localStringBuilder.toString());
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
        this.a.writeSampleData(a(paramInt), paramByteBuffer, paramBufferInfo);
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
      TLog.b("MediaMuxerWrapper", "writeSampleData error, ", paramByteBuffer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.mediacodec.recorder.MediaMuxerWrapper
 * JD-Core Version:    0.7.0.1
 */