package com.tencent.mobileqq.shortvideo.hwcodec;

class SVHwEncoder$HwEncode$HwTimeTool
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long;
  long[] jdField_a_of_type_ArrayOfLong = new long[3];
  int jdField_b_of_type_Int = 0;
  long jdField_b_of_type_Long;
  long[] jdField_b_of_type_ArrayOfLong = new long[3];
  int jdField_c_of_type_Int = 0;
  long jdField_c_of_type_Long;
  int jdField_d_of_type_Int = 0;
  long jdField_d_of_type_Long;
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
  
  SVHwEncoder$HwEncode$HwTimeTool(SVHwEncoder.HwEncode paramHwEncode) {}
  
  long a()
  {
    return System.currentTimeMillis() - this.jdField_a_of_type_Long;
  }
  
  void a()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  void a(boolean paramBoolean)
  {
    long[] arrayOfLong;
    if (paramBoolean)
    {
      i1 = this.jdField_a_of_type_Int;
      if (i1 < 3)
      {
        arrayOfLong = this.jdField_a_of_type_ArrayOfLong;
        this.jdField_a_of_type_Int = (i1 + 1);
        arrayOfLong[i1] = System.currentTimeMillis();
        return;
      }
    }
    int i1 = this.jdField_b_of_type_Int;
    if (i1 < 3)
    {
      arrayOfLong = this.jdField_b_of_type_ArrayOfLong;
      this.jdField_b_of_type_Int = (i1 + 1);
      arrayOfLong[i1] = System.currentTimeMillis();
    }
  }
  
  long b()
  {
    if (this.jdField_c_of_type_Int < 3) {
      return 0L;
    }
    return this.jdField_a_of_type_ArrayOfLong[0];
  }
  
  void b(boolean paramBoolean)
  {
    Object localObject1;
    long l1;
    Object localObject2;
    int i2;
    if (paramBoolean)
    {
      i1 = this.jdField_c_of_type_Int;
      if (i1 < 3)
      {
        localObject1 = this.jdField_a_of_type_ArrayOfLong;
        l1 = System.currentTimeMillis();
        localObject2 = this.jdField_a_of_type_ArrayOfLong;
        i2 = this.jdField_c_of_type_Int;
        localObject1[i1] = (l1 - localObject2[i2]);
        this.jdField_c_of_type_Int = (i2 + 1);
        if (this.jdField_c_of_type_Int != 3) {
          return;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode.this$0;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("videoEncodeTime:cnt20=");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_ArrayOfLong[0]);
        ((StringBuilder)localObject2).append(" cnt1=");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_ArrayOfLong[1]);
        ((StringBuilder)localObject2).append(" cnt2");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_ArrayOfLong[2]);
        ((SVHwEncoder)localObject1).a("hw_video_time_used_msg", ((StringBuilder)localObject2).toString());
        localObject1 = this.jdField_a_of_type_ArrayOfLong;
        localObject1[0] = ((localObject1[0] + localObject1[1] + localObject1[2]) / 3L * 1000L / 2L);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode.this$0;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("videoEncodeTime:timeout=");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_ArrayOfLong[0]);
        ((SVHwEncoder)localObject1).a("hw_video_time_used_msg", ((StringBuilder)localObject2).toString());
        return;
      }
    }
    int i1 = this.jdField_d_of_type_Int;
    if (i1 < 3)
    {
      localObject1 = this.jdField_b_of_type_ArrayOfLong;
      l1 = System.currentTimeMillis();
      localObject2 = this.jdField_b_of_type_ArrayOfLong;
      i2 = this.jdField_d_of_type_Int;
      localObject1[i1] = (l1 - localObject2[i2]);
      this.jdField_d_of_type_Int = (i2 + 1);
      if (this.jdField_d_of_type_Int == 3)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode.this$0;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("audioEncodeTime:cnt20=");
        ((StringBuilder)localObject2).append(this.jdField_b_of_type_ArrayOfLong[0]);
        ((StringBuilder)localObject2).append(" cnt1=");
        ((StringBuilder)localObject2).append(this.jdField_b_of_type_ArrayOfLong[1]);
        ((StringBuilder)localObject2).append(" cnt2");
        ((StringBuilder)localObject2).append(this.jdField_b_of_type_ArrayOfLong[2]);
        ((SVHwEncoder)localObject1).a("hw_video_time_used_msg", ((StringBuilder)localObject2).toString());
        localObject1 = this.jdField_b_of_type_ArrayOfLong;
        localObject1[0] = ((localObject1[0] + localObject1[1] + localObject1[2]) / 3L * 1000L / 2L);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode.this$0;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("audioEncodeTime:timeout=");
        ((StringBuilder)localObject2).append(this.jdField_b_of_type_ArrayOfLong[0]);
        ((SVHwEncoder)localObject1).a("hw_video_time_used_msg", ((StringBuilder)localObject2).toString());
      }
    }
  }
  
  long c()
  {
    if (this.jdField_d_of_type_Int < 3) {
      return 0L;
    }
    return this.jdField_b_of_type_ArrayOfLong[0];
  }
  
  void c(boolean paramBoolean)
  {
    long l1 = a();
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
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(" ");
    localStringBuilder.append("vInit=");
    localStringBuilder.append(this.jdField_c_of_type_Long);
    localStringBuilder.append(" ");
    localStringBuilder.append("vStart=");
    localStringBuilder.append(this.jdField_d_of_type_Long);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder.HwEncode.HwTimeTool
 * JD-Core Version:    0.7.0.1
 */