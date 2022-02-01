package com.tencent.mobileqq.shortvideo.hwcodec;

class SVHwEncoder$HwEncode$HwTimeTool
{
  long a;
  long b;
  long c;
  long d;
  long e;
  long f;
  long g;
  long h;
  long i;
  long j;
  long k;
  long l;
  long m;
  long n;
  long o;
  long p;
  long q = 9223372036854775807L;
  long r = 0L;
  long s = 9223372036854775807L;
  long t = 0L;
  int u = 0;
  int v = 0;
  int w = 0;
  int x = 0;
  long[] y = new long[3];
  long[] z = new long[3];
  
  SVHwEncoder$HwEncode$HwTimeTool(SVHwEncoder.HwEncode paramHwEncode) {}
  
  void a()
  {
    this.a = System.currentTimeMillis();
  }
  
  void a(boolean paramBoolean)
  {
    long[] arrayOfLong;
    if (paramBoolean)
    {
      i1 = this.u;
      if (i1 < 3)
      {
        arrayOfLong = this.y;
        this.u = (i1 + 1);
        arrayOfLong[i1] = System.currentTimeMillis();
        return;
      }
    }
    int i1 = this.v;
    if (i1 < 3)
    {
      arrayOfLong = this.z;
      this.v = (i1 + 1);
      arrayOfLong[i1] = System.currentTimeMillis();
    }
  }
  
  long b()
  {
    return System.currentTimeMillis() - this.a;
  }
  
  void b(boolean paramBoolean)
  {
    Object localObject1;
    long l1;
    Object localObject2;
    int i2;
    if (paramBoolean)
    {
      i1 = this.w;
      if (i1 < 3)
      {
        localObject1 = this.y;
        l1 = System.currentTimeMillis();
        localObject2 = this.y;
        i2 = this.w;
        localObject1[i1] = (l1 - localObject2[i2]);
        this.w = (i2 + 1);
        if (this.w != 3) {
          return;
        }
        localObject1 = this.A.this$0;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("videoEncodeTime:cnt20=");
        ((StringBuilder)localObject2).append(this.y[0]);
        ((StringBuilder)localObject2).append(" cnt1=");
        ((StringBuilder)localObject2).append(this.y[1]);
        ((StringBuilder)localObject2).append(" cnt2");
        ((StringBuilder)localObject2).append(this.y[2]);
        ((SVHwEncoder)localObject1).a("hw_video_time_used_msg", ((StringBuilder)localObject2).toString());
        localObject1 = this.y;
        localObject1[0] = ((localObject1[0] + localObject1[1] + localObject1[2]) / 3L * 1000L / 2L);
        localObject1 = this.A.this$0;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("videoEncodeTime:timeout=");
        ((StringBuilder)localObject2).append(this.y[0]);
        ((SVHwEncoder)localObject1).a("hw_video_time_used_msg", ((StringBuilder)localObject2).toString());
        return;
      }
    }
    int i1 = this.x;
    if (i1 < 3)
    {
      localObject1 = this.z;
      l1 = System.currentTimeMillis();
      localObject2 = this.z;
      i2 = this.x;
      localObject1[i1] = (l1 - localObject2[i2]);
      this.x = (i2 + 1);
      if (this.x == 3)
      {
        localObject1 = this.A.this$0;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("audioEncodeTime:cnt20=");
        ((StringBuilder)localObject2).append(this.z[0]);
        ((StringBuilder)localObject2).append(" cnt1=");
        ((StringBuilder)localObject2).append(this.z[1]);
        ((StringBuilder)localObject2).append(" cnt2");
        ((StringBuilder)localObject2).append(this.z[2]);
        ((SVHwEncoder)localObject1).a("hw_video_time_used_msg", ((StringBuilder)localObject2).toString());
        localObject1 = this.z;
        localObject1[0] = ((localObject1[0] + localObject1[1] + localObject1[2]) / 3L * 1000L / 2L);
        localObject1 = this.A.this$0;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("audioEncodeTime:timeout=");
        ((StringBuilder)localObject2).append(this.z[0]);
        ((SVHwEncoder)localObject1).a("hw_video_time_used_msg", ((StringBuilder)localObject2).toString());
      }
    }
  }
  
  long c()
  {
    if (this.w < 3) {
      return 0L;
    }
    return this.y[0];
  }
  
  void c(boolean paramBoolean)
  {
    long l1 = b();
    if (paramBoolean)
    {
      if (l1 > this.r) {
        this.r = l1;
      }
      if (l1 < this.q) {
        this.q = l1;
      }
    }
    else
    {
      if (l1 > this.t) {
        this.t = l1;
      }
      if (l1 < this.s) {
        this.s = l1;
      }
    }
  }
  
  long d()
  {
    if (this.x < 3) {
      return 0L;
    }
    return this.z[0];
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mThumbGen=");
    localStringBuilder.append(this.l);
    localStringBuilder.append(" ");
    localStringBuilder.append("mThumbGenFunc=");
    localStringBuilder.append(this.m);
    localStringBuilder.append(" ");
    localStringBuilder.append("mMuxerCreate=");
    localStringBuilder.append(this.n);
    localStringBuilder.append(" ");
    localStringBuilder.append("mMuxerAdd=");
    localStringBuilder.append(this.o);
    localStringBuilder.append(" ");
    localStringBuilder.append("mMuxerStart=");
    localStringBuilder.append(this.p);
    localStringBuilder.append(" ");
    localStringBuilder.append("mWriteVideoMax=");
    localStringBuilder.append(this.r);
    localStringBuilder.append(" ");
    localStringBuilder.append("mWriteVideoMIn=");
    localStringBuilder.append(this.q);
    localStringBuilder.append(" ");
    localStringBuilder.append("mWriteAudioMax=");
    localStringBuilder.append(this.t);
    localStringBuilder.append(" ");
    localStringBuilder.append("mWriteAudioMIn=");
    localStringBuilder.append(this.s);
    localStringBuilder.append(" ");
    localStringBuilder.append("vConfig=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" ");
    localStringBuilder.append("vInit=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" ");
    localStringBuilder.append("vStart=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" ");
    localStringBuilder.append("vStop=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" ");
    localStringBuilder.append("vRelease=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(" ");
    localStringBuilder.append("aConfig=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(" ");
    localStringBuilder.append("aInit=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(" ");
    localStringBuilder.append("aStart=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(" ");
    localStringBuilder.append("aStop=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(" ");
    localStringBuilder.append("aRelease=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(" ");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder.HwEncode.HwTimeTool
 * JD-Core Version:    0.7.0.1
 */