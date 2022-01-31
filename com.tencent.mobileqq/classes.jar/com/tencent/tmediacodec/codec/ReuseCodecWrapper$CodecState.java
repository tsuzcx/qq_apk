package com.tencent.tmediacodec.codec;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tmediacodec/codec/ReuseCodecWrapper$CodecState;", "", "(Ljava/lang/String;I)V", "Uninitialized", "Configured", "Error", "Flushed", "Running", "EndOfStream", "Released", "tmediacodec_lib_debug"}, k=1, mv={1, 1, 15})
public enum ReuseCodecWrapper$CodecState
{
  static
  {
    CodecState localCodecState1 = new CodecState("Uninitialized", 0);
    Uninitialized = localCodecState1;
    CodecState localCodecState2 = new CodecState("Configured", 1);
    Configured = localCodecState2;
    CodecState localCodecState3 = new CodecState("Error", 2);
    Error = localCodecState3;
    CodecState localCodecState4 = new CodecState("Flushed", 3);
    Flushed = localCodecState4;
    CodecState localCodecState5 = new CodecState("Running", 4);
    Running = localCodecState5;
    CodecState localCodecState6 = new CodecState("EndOfStream", 5);
    EndOfStream = localCodecState6;
    CodecState localCodecState7 = new CodecState("Released", 6);
    Released = localCodecState7;
    $VALUES = new CodecState[] { localCodecState1, localCodecState2, localCodecState3, localCodecState4, localCodecState5, localCodecState6, localCodecState7 };
  }
  
  private ReuseCodecWrapper$CodecState() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmediacodec.codec.ReuseCodecWrapper.CodecState
 * JD-Core Version:    0.7.0.1
 */