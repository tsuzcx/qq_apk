package com.tencent.mobileqq.shortvideo.dancemachine;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

class BadcaseReportUtils$BadCaseWriter
{
  byte[] byteArray = new byte[4];
  boolean mWriteOK = false;
  FileOutputStream outStream;
  
  BadcaseReportUtils$BadCaseWriter(String paramString)
  {
    File localFile = new File(paramString);
    if (localFile.exists()) {
      localFile.delete();
    }
    try
    {
      localFile.createNewFile();
      this.outStream = new FileOutputStream(paramString);
      this.mWriteOK = true;
      return;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void intToByteArray(int paramInt)
  {
    this.byteArray[0] = ((byte)(paramInt >> 24 & 0xFF));
    this.byteArray[1] = ((byte)(paramInt >> 16 & 0xFF));
    this.byteArray[2] = ((byte)(paramInt >> 8 & 0xFF));
    this.byteArray[3] = ((byte)(paramInt & 0xFF));
  }
  
  public void flush()
  {
    if ((this.outStream != null) && (this.mWriteOK)) {}
    try
    {
      this.outStream.flush();
      return;
    }
    catch (IOException localIOException)
    {
      this.mWriteOK = false;
    }
  }
  
  public void release()
  {
    if (this.outStream != null) {}
    try
    {
      this.outStream.close();
      this.outStream = null;
      this.mWriteOK = false;
      return;
    }
    catch (IOException localIOException) {}
  }
  
  public void writeBigInt(int paramInt)
  {
    if ((this.outStream != null) && (this.mWriteOK)) {}
    try
    {
      intToByteArray(paramInt);
      this.outStream.write(this.byteArray, 0, 4);
      return;
    }
    catch (IOException localIOException)
    {
      this.mWriteOK = false;
    }
  }
  
  public void writeByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((this.outStream != null) && (this.mWriteOK)) {}
    try
    {
      this.outStream.write(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      this.mWriteOK = false;
    }
  }
  
  public void writeCString(String paramString)
  {
    if ((this.outStream != null) && (this.mWriteOK)) {
      paramString = paramString.getBytes();
    }
    try
    {
      this.outStream.write(paramString);
      this.outStream.write(0);
      return;
    }
    catch (IOException paramString)
    {
      this.mWriteOK = false;
    }
  }
  
  public void writeFile(String paramString)
  {
    if (paramString == null)
    {
      writeBigInt(0);
      return;
    }
    paramString = new File(paramString);
    if (paramString.exists())
    {
      writeFileData(paramString);
      return;
    }
    writeBigInt(0);
  }
  
  /* Error */
  public void writeFileData(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_1
    //   4: invokevirtual 88	java/io/File:length	()J
    //   7: l2i
    //   8: istore_3
    //   9: new 90	java/io/FileInputStream
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 92	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   17: astore 5
    //   19: iload_3
    //   20: sipush 4096
    //   23: if_icmpge +24 -> 47
    //   26: iload_3
    //   27: newarray byte
    //   29: astore 6
    //   31: aload 6
    //   33: ifnonnull +32 -> 65
    //   36: aload 5
    //   38: ifnull +8 -> 46
    //   41: aload 5
    //   43: invokevirtual 93	java/io/FileInputStream:close	()V
    //   46: return
    //   47: sipush 4096
    //   50: newarray byte
    //   52: astore 6
    //   54: goto -23 -> 31
    //   57: astore 6
    //   59: aconst_null
    //   60: astore 6
    //   62: goto -31 -> 31
    //   65: aload_0
    //   66: aload_1
    //   67: invokevirtual 88	java/io/File:length	()J
    //   70: l2i
    //   71: invokevirtual 76	com/tencent/mobileqq/shortvideo/dancemachine/BadcaseReportUtils$BadCaseWriter:writeBigInt	(I)V
    //   74: iconst_0
    //   75: istore_2
    //   76: iload_2
    //   77: iload_3
    //   78: if_icmpge +34 -> 112
    //   81: aload 5
    //   83: aload 6
    //   85: invokevirtual 97	java/io/FileInputStream:read	([B)I
    //   88: istore 4
    //   90: iload 4
    //   92: ifle -16 -> 76
    //   95: aload_0
    //   96: aload 6
    //   98: iconst_0
    //   99: iload 4
    //   101: invokevirtual 99	com/tencent/mobileqq/shortvideo/dancemachine/BadcaseReportUtils$BadCaseWriter:writeByteArray	([BII)V
    //   104: iload_2
    //   105: iload 4
    //   107: iadd
    //   108: istore_2
    //   109: goto -33 -> 76
    //   112: aload 5
    //   114: ifnull -68 -> 46
    //   117: aload 5
    //   119: invokevirtual 93	java/io/FileInputStream:close	()V
    //   122: return
    //   123: astore_1
    //   124: return
    //   125: astore_1
    //   126: aload 6
    //   128: astore_1
    //   129: aload_1
    //   130: ifnull -84 -> 46
    //   133: aload_1
    //   134: invokevirtual 93	java/io/FileInputStream:close	()V
    //   137: return
    //   138: astore_1
    //   139: return
    //   140: astore_1
    //   141: aconst_null
    //   142: astore 5
    //   144: aload 5
    //   146: ifnull -100 -> 46
    //   149: aload 5
    //   151: invokevirtual 93	java/io/FileInputStream:close	()V
    //   154: return
    //   155: astore_1
    //   156: return
    //   157: astore_1
    //   158: aconst_null
    //   159: astore 5
    //   161: aload 5
    //   163: ifnull +8 -> 171
    //   166: aload 5
    //   168: invokevirtual 93	java/io/FileInputStream:close	()V
    //   171: aload_1
    //   172: athrow
    //   173: astore_1
    //   174: return
    //   175: astore 5
    //   177: goto -6 -> 171
    //   180: astore_1
    //   181: goto -20 -> 161
    //   184: astore_1
    //   185: goto -41 -> 144
    //   188: astore_1
    //   189: aload 5
    //   191: astore_1
    //   192: goto -63 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	this	BadCaseWriter
    //   0	195	1	paramFile	File
    //   75	34	2	i	int
    //   8	71	3	j	int
    //   88	20	4	k	int
    //   17	150	5	localFileInputStream	java.io.FileInputStream
    //   175	15	5	localIOException	IOException
    //   1	52	6	arrayOfByte1	byte[]
    //   57	1	6	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   60	67	6	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   26	31	57	java/lang/OutOfMemoryError
    //   47	54	57	java/lang/OutOfMemoryError
    //   117	122	123	java/io/IOException
    //   3	19	125	java/lang/Exception
    //   133	137	138	java/io/IOException
    //   3	19	140	java/lang/OutOfMemoryError
    //   149	154	155	java/io/IOException
    //   3	19	157	finally
    //   41	46	173	java/io/IOException
    //   166	171	175	java/io/IOException
    //   26	31	180	finally
    //   47	54	180	finally
    //   65	74	180	finally
    //   81	90	180	finally
    //   95	104	180	finally
    //   65	74	184	java/lang/OutOfMemoryError
    //   81	90	184	java/lang/OutOfMemoryError
    //   95	104	184	java/lang/OutOfMemoryError
    //   26	31	188	java/lang/Exception
    //   47	54	188	java/lang/Exception
    //   65	74	188	java/lang/Exception
    //   81	90	188	java/lang/Exception
    //   95	104	188	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.BadcaseReportUtils.BadCaseWriter
 * JD-Core Version:    0.7.0.1
 */