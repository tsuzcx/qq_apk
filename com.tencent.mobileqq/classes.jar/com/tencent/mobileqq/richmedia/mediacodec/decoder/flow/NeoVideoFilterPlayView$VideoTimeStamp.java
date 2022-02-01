package com.tencent.mobileqq.richmedia.mediacodec.decoder.flow;

class NeoVideoFilterPlayView$VideoTimeStamp
{
  private final int jdField_a_of_type_Int;
  private final long jdField_a_of_type_Long;
  private final long b;
  
  private NeoVideoFilterPlayView$VideoTimeStamp(long paramLong1, long paramLong2, int paramInt)
  {
    this.jdField_a_of_type_Long = paramLong1;
    this.b = paramLong2;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public String toString()
  {
    return "VideoTimeStamp{TIME-CLOCK=" + this.jdField_a_of_type_Long + ", TIME-FRAME=" + this.b + ", CYCLE=" + this.jdField_a_of_type_Int + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.NeoVideoFilterPlayView.VideoTimeStamp
 * JD-Core Version:    0.7.0.1
 */