package com.tencent.tmediacodec.codec;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tmediacodec/codec/ReuseCodecWrapper$DecodeState;", "", "(Ljava/lang/String;I)V", "Started", "DequeueIn", "QueueIn", "DequeueOut", "ReleaseOut", "tmediacodec_lib_debug"}, k=1, mv={1, 1, 15})
public enum ReuseCodecWrapper$DecodeState
{
  static
  {
    DecodeState localDecodeState1 = new DecodeState("Started", 0);
    Started = localDecodeState1;
    DecodeState localDecodeState2 = new DecodeState("DequeueIn", 1);
    DequeueIn = localDecodeState2;
    DecodeState localDecodeState3 = new DecodeState("QueueIn", 2);
    QueueIn = localDecodeState3;
    DecodeState localDecodeState4 = new DecodeState("DequeueOut", 3);
    DequeueOut = localDecodeState4;
    DecodeState localDecodeState5 = new DecodeState("ReleaseOut", 4);
    ReleaseOut = localDecodeState5;
    $VALUES = new DecodeState[] { localDecodeState1, localDecodeState2, localDecodeState3, localDecodeState4, localDecodeState5 };
  }
  
  private ReuseCodecWrapper$DecodeState() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmediacodec.codec.ReuseCodecWrapper.DecodeState
 * JD-Core Version:    0.7.0.1
 */