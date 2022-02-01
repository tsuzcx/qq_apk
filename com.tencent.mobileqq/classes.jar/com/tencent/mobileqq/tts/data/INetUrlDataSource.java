package com.tencent.mobileqq.tts.data;

import java.io.InputStream;

public abstract interface INetUrlDataSource
  extends ITtsDataSource
{
  public abstract InputStream a(TtsNetStreamParam paramTtsNetStreamParam);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.tts.data.INetUrlDataSource
 * JD-Core Version:    0.7.0.1
 */