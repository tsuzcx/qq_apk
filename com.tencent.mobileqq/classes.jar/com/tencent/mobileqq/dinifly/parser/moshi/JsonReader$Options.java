package com.tencent.mobileqq.dinifly.parser.moshi;

import java.io.IOException;
import okio.Buffer;
import okio.ByteString;
import okio.Options;

public final class JsonReader$Options
{
  final Options doubleQuoteSuffix;
  final String[] strings;
  
  private JsonReader$Options(String[] paramArrayOfString, Options paramOptions)
  {
    this.strings = paramArrayOfString;
    this.doubleQuoteSuffix = paramOptions;
  }
  
  public static Options of(String... paramVarArgs)
  {
    try
    {
      ByteString[] arrayOfByteString = new ByteString[paramVarArgs.length];
      Buffer localBuffer = new Buffer();
      int i = 0;
      while (i < paramVarArgs.length)
      {
        JsonReader.access$000(localBuffer, paramVarArgs[i]);
        localBuffer.readByte();
        arrayOfByteString[i] = localBuffer.readByteString();
        i += 1;
      }
      paramVarArgs = new Options((String[])paramVarArgs.clone(), Options.of(arrayOfByteString));
      return paramVarArgs;
    }
    catch (IOException paramVarArgs)
    {
      paramVarArgs = new AssertionError(paramVarArgs);
    }
    for (;;)
    {
      throw paramVarArgs;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.moshi.JsonReader.Options
 * JD-Core Version:    0.7.0.1
 */