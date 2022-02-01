package com.tencent.tbs.log.file;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class FilePrinter$Writer
{
  private File mLogFile;
  private String mLogFileName;
  private OutputStream mOutputStream;
  
  private FilePrinter$Writer(FilePrinter paramFilePrinter) {}
  
  /* Error */
  void appendLog(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 31	com/tencent/tbs/log/file/FilePrinter$Writer:mOutputStream	Ljava/io/OutputStream;
    //   4: ifnull +134 -> 138
    //   7: aload_0
    //   8: getfield 16	com/tencent/tbs/log/file/FilePrinter$Writer:this$0	Lcom/tencent/tbs/log/file/FilePrinter;
    //   11: invokestatic 37	com/tencent/tbs/log/file/FilePrinter:access$400	(Lcom/tencent/tbs/log/file/FilePrinter;)Z
    //   14: ifeq +40 -> 54
    //   17: invokestatic 43	com/tencent/tbs/log/file/Encryption:createKeyOfPlainText	()Ljava/lang/String;
    //   20: astore_2
    //   21: ldc 45
    //   23: aload_2
    //   24: invokestatic 49	com/tencent/tbs/log/file/Encryption:getEncryptedKeyBytes	(Ljava/lang/String;Ljava/lang/String;)[B
    //   27: astore_3
    //   28: aload_3
    //   29: ifnull +43 -> 72
    //   32: aload_2
    //   33: aload_1
    //   34: aload_3
    //   35: invokestatic 53	com/tencent/tbs/log/file/Encryption:getEncryptedLogBytes	(Ljava/lang/String;Ljava/lang/String;[B)[B
    //   38: astore_1
    //   39: aload_1
    //   40: ifnull +32 -> 72
    //   43: aload_0
    //   44: getfield 31	com/tencent/tbs/log/file/FilePrinter$Writer:mOutputStream	Ljava/io/OutputStream;
    //   47: aload_1
    //   48: invokevirtual 59	java/io/OutputStream:write	([B)V
    //   51: goto +21 -> 72
    //   54: aload_1
    //   55: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   58: ifne +14 -> 72
    //   61: aload_0
    //   62: getfield 31	com/tencent/tbs/log/file/FilePrinter$Writer:mOutputStream	Ljava/io/OutputStream;
    //   65: aload_1
    //   66: invokevirtual 71	java/lang/String:getBytes	()[B
    //   69: invokevirtual 59	java/io/OutputStream:write	([B)V
    //   72: aload_0
    //   73: getfield 31	com/tencent/tbs/log/file/FilePrinter$Writer:mOutputStream	Ljava/io/OutputStream;
    //   76: astore_1
    //   77: aload_1
    //   78: ifnull +60 -> 138
    //   81: aload_1
    //   82: invokevirtual 74	java/io/OutputStream:flush	()V
    //   85: return
    //   86: astore_1
    //   87: goto +28 -> 115
    //   90: astore_1
    //   91: aload_1
    //   92: invokevirtual 77	java/lang/Exception:printStackTrace	()V
    //   95: aload_0
    //   96: getfield 31	com/tencent/tbs/log/file/FilePrinter$Writer:mOutputStream	Ljava/io/OutputStream;
    //   99: astore_1
    //   100: aload_1
    //   101: ifnull +37 -> 138
    //   104: aload_1
    //   105: invokevirtual 74	java/io/OutputStream:flush	()V
    //   108: return
    //   109: astore_1
    //   110: aload_1
    //   111: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   114: return
    //   115: aload_0
    //   116: getfield 31	com/tencent/tbs/log/file/FilePrinter$Writer:mOutputStream	Ljava/io/OutputStream;
    //   119: astore_2
    //   120: aload_2
    //   121: ifnull +15 -> 136
    //   124: aload_2
    //   125: invokevirtual 74	java/io/OutputStream:flush	()V
    //   128: goto +8 -> 136
    //   131: astore_2
    //   132: aload_2
    //   133: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   136: aload_1
    //   137: athrow
    //   138: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	this	Writer
    //   0	139	1	paramString	String
    //   20	105	2	localObject	Object
    //   131	2	2	localIOException	IOException
    //   27	8	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   7	28	86	finally
    //   32	39	86	finally
    //   43	51	86	finally
    //   54	72	86	finally
    //   91	95	86	finally
    //   7	28	90	java/lang/Exception
    //   32	39	90	java/lang/Exception
    //   43	51	90	java/lang/Exception
    //   54	72	90	java/lang/Exception
    //   81	85	109	java/io/IOException
    //   104	108	109	java/io/IOException
    //   124	128	131	java/io/IOException
  }
  
  /* Error */
  boolean close()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 31	com/tencent/tbs/log/file/FilePrinter$Writer:mOutputStream	Ljava/io/OutputStream;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull +53 -> 59
    //   9: aload_1
    //   10: invokevirtual 82	java/io/OutputStream:close	()V
    //   13: aload_0
    //   14: aconst_null
    //   15: putfield 31	com/tencent/tbs/log/file/FilePrinter$Writer:mOutputStream	Ljava/io/OutputStream;
    //   18: aload_0
    //   19: aconst_null
    //   20: putfield 84	com/tencent/tbs/log/file/FilePrinter$Writer:mLogFile	Ljava/io/File;
    //   23: goto +36 -> 59
    //   26: astore_1
    //   27: goto +20 -> 47
    //   30: astore_1
    //   31: aload_1
    //   32: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   35: aload_0
    //   36: aconst_null
    //   37: putfield 31	com/tencent/tbs/log/file/FilePrinter$Writer:mOutputStream	Ljava/io/OutputStream;
    //   40: aload_0
    //   41: aconst_null
    //   42: putfield 84	com/tencent/tbs/log/file/FilePrinter$Writer:mLogFile	Ljava/io/File;
    //   45: iconst_0
    //   46: ireturn
    //   47: aload_0
    //   48: aconst_null
    //   49: putfield 31	com/tencent/tbs/log/file/FilePrinter$Writer:mOutputStream	Ljava/io/OutputStream;
    //   52: aload_0
    //   53: aconst_null
    //   54: putfield 84	com/tencent/tbs/log/file/FilePrinter$Writer:mLogFile	Ljava/io/File;
    //   57: aload_1
    //   58: athrow
    //   59: iconst_1
    //   60: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	Writer
    //   4	6	1	localOutputStream	OutputStream
    //   26	1	1	localObject	Object
    //   30	28	1	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   9	13	26	finally
    //   31	35	26	finally
    //   9	13	30	java/io/IOException
  }
  
  File getFile()
  {
    return this.mLogFile;
  }
  
  String getFileName()
  {
    return this.mLogFileName;
  }
  
  boolean isOpened()
  {
    return this.mOutputStream != null;
  }
  
  boolean open(String paramString)
  {
    this.mLogFileName = paramString;
    this.mLogFile = new File(FilePrinter.access$300(this.this$0), paramString);
    if (!this.mLogFile.exists()) {
      try
      {
        paramString = this.mLogFile.getParentFile();
        if (!paramString.exists()) {
          paramString.mkdirs();
        }
        this.mLogFile.createNewFile();
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        this.mLogFile = null;
        return false;
      }
    }
    try
    {
      this.mOutputStream = new BufferedOutputStream(new FileOutputStream(this.mLogFile, true));
      return true;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      this.mLogFile = null;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.log.file.FilePrinter.Writer
 * JD-Core Version:    0.7.0.1
 */