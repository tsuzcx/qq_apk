package com.tencent.tmediacodec.reuse;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tmediacodec/reuse/ReuseHelper$ReuseType;", "", "(Ljava/lang/String;I)V", "KEEP_CODEC_RESULT_NO", "KEEP_CODEC_RESULT_YES_WITH_FLUSH", "KEEP_CODEC_RESULT_YES_WITH_RECONFIGURATION", "KEEP_CODEC_RESULT_YES_WITHOUT_RECONFIGURATION", "tmediacodec_lib_debug"}, k=1, mv={1, 1, 15})
public enum ReuseHelper$ReuseType
{
  static
  {
    ReuseType localReuseType1 = new ReuseType("KEEP_CODEC_RESULT_NO", 0);
    KEEP_CODEC_RESULT_NO = localReuseType1;
    ReuseType localReuseType2 = new ReuseType("KEEP_CODEC_RESULT_YES_WITH_FLUSH", 1);
    KEEP_CODEC_RESULT_YES_WITH_FLUSH = localReuseType2;
    ReuseType localReuseType3 = new ReuseType("KEEP_CODEC_RESULT_YES_WITH_RECONFIGURATION", 2);
    KEEP_CODEC_RESULT_YES_WITH_RECONFIGURATION = localReuseType3;
    ReuseType localReuseType4 = new ReuseType("KEEP_CODEC_RESULT_YES_WITHOUT_RECONFIGURATION", 3);
    KEEP_CODEC_RESULT_YES_WITHOUT_RECONFIGURATION = localReuseType4;
    $VALUES = new ReuseType[] { localReuseType1, localReuseType2, localReuseType3, localReuseType4 };
  }
  
  private ReuseHelper$ReuseType() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmediacodec.reuse.ReuseHelper.ReuseType
 * JD-Core Version:    0.7.0.1
 */