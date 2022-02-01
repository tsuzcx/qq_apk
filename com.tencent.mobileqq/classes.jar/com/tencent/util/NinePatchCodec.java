package com.tencent.util;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class NinePatchCodec
{
  private static final int NP_CHUNK_TYPE = 1852855395;
  private static final int NP_COLOR = -16777216;
  
  public static NinePatchCodec.NinePatch decodeNinePatch(InputStream paramInputStream)
  {
    return getNinePatch(new DataInputStream(paramInputStream));
  }
  
  public static void find9patchChunk(DataInput paramDataInput)
  {
    paramDataInput.skipBytes(8);
    for (;;)
    {
      int i = 0;
      try
      {
        int j = paramDataInput.readInt();
        i = j;
      }
      catch (IOException localIOException)
      {
        label20:
        break label20;
      }
      if (paramDataInput.readInt() == 1852855395) {
        return;
      }
      paramDataInput.skipBytes(i + 4);
    }
  }
  
  public static NinePatchCodec.NinePatch getNinePatch(DataInput paramDataInput)
  {
    find9patchChunk(paramDataInput);
    NinePatchCodec.NinePatch localNinePatch = new NinePatchCodec.NinePatch();
    localNinePatch.decode(paramDataInput);
    return localNinePatch;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.util.NinePatchCodec
 * JD-Core Version:    0.7.0.1
 */