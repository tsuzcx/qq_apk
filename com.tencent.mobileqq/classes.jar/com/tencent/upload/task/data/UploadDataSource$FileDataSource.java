package com.tencent.upload.task.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.upload.utils.FileUtils;
import java.io.File;
import java.io.FileInputStream;

public class UploadDataSource$FileDataSource
  extends UploadDataSource
{
  public static final Parcelable.Creator<FileDataSource> CREATOR = new UploadDataSource.FileDataSource.1();
  private File mFile;
  private String mFilePath;
  private FileInputStream sIns;
  private long sfileOffset;
  
  public UploadDataSource$FileDataSource(Parcel paramParcel)
  {
    this.mFilePath = paramParcel.readString();
    this.mFile = new File(this.mFilePath);
  }
  
  public UploadDataSource$FileDataSource(String paramString)
  {
    this.mFilePath = paramString;
    this.mFile = new File(paramString);
  }
  
  public String calcSha1()
  {
    return FileUtils.getFileSha1(this.mFile);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean exists()
  {
    return this.mFile.exists();
  }
  
  public long getDataLength()
  {
    if (this.mFile.exists()) {
      return this.mFile.length();
    }
    return 0L;
  }
  
  public String getFileName()
  {
    return this.mFile.getName();
  }
  
  /* Error */
  public long readData(long paramLong, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 74	com/tencent/upload/task/data/UploadDataSource$FileDataSource:sIns	Ljava/io/FileInputStream;
    //   6: ifnull +32 -> 38
    //   9: aload_0
    //   10: getfield 76	com/tencent/upload/task/data/UploadDataSource$FileDataSource:sfileOffset	J
    //   13: lload_1
    //   14: lcmp
    //   15: ifne +23 -> 38
    //   18: aload_0
    //   19: getfield 74	com/tencent/upload/task/data/UploadDataSource$FileDataSource:sIns	Ljava/io/FileInputStream;
    //   22: astore 6
    //   24: aload_0
    //   25: aload_0
    //   26: getfield 76	com/tencent/upload/task/data/UploadDataSource$FileDataSource:sfileOffset	J
    //   29: iload_3
    //   30: i2l
    //   31: ladd
    //   32: putfield 76	com/tencent/upload/task/data/UploadDataSource$FileDataSource:sfileOffset	J
    //   35: goto +61 -> 96
    //   38: aload_0
    //   39: getfield 74	com/tencent/upload/task/data/UploadDataSource$FileDataSource:sIns	Ljava/io/FileInputStream;
    //   42: ifnull +20 -> 62
    //   45: aload_0
    //   46: getfield 74	com/tencent/upload/task/data/UploadDataSource$FileDataSource:sIns	Ljava/io/FileInputStream;
    //   49: invokevirtual 81	java/io/FileInputStream:close	()V
    //   52: goto +10 -> 62
    //   55: astore 6
    //   57: aload 6
    //   59: invokevirtual 84	java/lang/Throwable:printStackTrace	()V
    //   62: new 78	java/io/FileInputStream
    //   65: dup
    //   66: aload_0
    //   67: getfield 42	com/tencent/upload/task/data/UploadDataSource$FileDataSource:mFile	Ljava/io/File;
    //   70: invokespecial 87	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   73: astore 6
    //   75: aload_0
    //   76: aload 6
    //   78: putfield 74	com/tencent/upload/task/data/UploadDataSource$FileDataSource:sIns	Ljava/io/FileInputStream;
    //   81: aload 6
    //   83: lload_1
    //   84: invokevirtual 93	java/io/InputStream:skip	(J)J
    //   87: pop2
    //   88: aload_0
    //   89: lload_1
    //   90: iload_3
    //   91: i2l
    //   92: ladd
    //   93: putfield 76	com/tencent/upload/task/data/UploadDataSource$FileDataSource:sfileOffset	J
    //   96: aload 6
    //   98: aload 4
    //   100: iload 5
    //   102: iload_3
    //   103: invokevirtual 97	java/io/InputStream:read	([BII)I
    //   106: istore_3
    //   107: iload_3
    //   108: i2l
    //   109: lstore_1
    //   110: aload_0
    //   111: getfield 76	com/tencent/upload/task/data/UploadDataSource$FileDataSource:sfileOffset	J
    //   114: aload_0
    //   115: getfield 42	com/tencent/upload/task/data/UploadDataSource$FileDataSource:mFile	Ljava/io/File;
    //   118: invokevirtual 60	java/io/File:length	()J
    //   121: lcmp
    //   122: iflt +27 -> 149
    //   125: aload_0
    //   126: getfield 74	com/tencent/upload/task/data/UploadDataSource$FileDataSource:sIns	Ljava/io/FileInputStream;
    //   129: ifnull +20 -> 149
    //   132: aload_0
    //   133: getfield 74	com/tencent/upload/task/data/UploadDataSource$FileDataSource:sIns	Ljava/io/FileInputStream;
    //   136: invokevirtual 81	java/io/FileInputStream:close	()V
    //   139: aload_0
    //   140: aconst_null
    //   141: putfield 74	com/tencent/upload/task/data/UploadDataSource$FileDataSource:sIns	Ljava/io/FileInputStream;
    //   144: aload_0
    //   145: lconst_0
    //   146: putfield 76	com/tencent/upload/task/data/UploadDataSource$FileDataSource:sfileOffset	J
    //   149: aload_0
    //   150: monitorexit
    //   151: lload_1
    //   152: lreturn
    //   153: astore 4
    //   155: goto +32 -> 187
    //   158: astore 4
    //   160: aload_0
    //   161: getfield 74	com/tencent/upload/task/data/UploadDataSource$FileDataSource:sIns	Ljava/io/FileInputStream;
    //   164: ifnull +20 -> 184
    //   167: aload_0
    //   168: getfield 74	com/tencent/upload/task/data/UploadDataSource$FileDataSource:sIns	Ljava/io/FileInputStream;
    //   171: invokevirtual 81	java/io/FileInputStream:close	()V
    //   174: aload_0
    //   175: aconst_null
    //   176: putfield 74	com/tencent/upload/task/data/UploadDataSource$FileDataSource:sIns	Ljava/io/FileInputStream;
    //   179: aload_0
    //   180: lconst_0
    //   181: putfield 76	com/tencent/upload/task/data/UploadDataSource$FileDataSource:sfileOffset	J
    //   184: aload 4
    //   186: athrow
    //   187: aload_0
    //   188: getfield 76	com/tencent/upload/task/data/UploadDataSource$FileDataSource:sfileOffset	J
    //   191: aload_0
    //   192: getfield 42	com/tencent/upload/task/data/UploadDataSource$FileDataSource:mFile	Ljava/io/File;
    //   195: invokevirtual 60	java/io/File:length	()J
    //   198: lcmp
    //   199: iflt +35 -> 234
    //   202: aload_0
    //   203: getfield 74	com/tencent/upload/task/data/UploadDataSource$FileDataSource:sIns	Ljava/io/FileInputStream;
    //   206: ifnull +28 -> 234
    //   209: aload_0
    //   210: getfield 74	com/tencent/upload/task/data/UploadDataSource$FileDataSource:sIns	Ljava/io/FileInputStream;
    //   213: invokevirtual 81	java/io/FileInputStream:close	()V
    //   216: aload_0
    //   217: aconst_null
    //   218: putfield 74	com/tencent/upload/task/data/UploadDataSource$FileDataSource:sIns	Ljava/io/FileInputStream;
    //   221: aload_0
    //   222: lconst_0
    //   223: putfield 76	com/tencent/upload/task/data/UploadDataSource$FileDataSource:sfileOffset	J
    //   226: goto +8 -> 234
    //   229: astore 4
    //   231: goto +6 -> 237
    //   234: aload 4
    //   236: athrow
    //   237: aload_0
    //   238: monitorexit
    //   239: aload 4
    //   241: athrow
    //   242: astore 4
    //   244: goto -95 -> 149
    //   247: astore 6
    //   249: goto -65 -> 184
    //   252: astore 6
    //   254: goto -20 -> 234
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	this	FileDataSource
    //   0	257	1	paramLong	long
    //   0	257	3	paramInt1	int
    //   0	257	4	paramArrayOfByte	byte[]
    //   0	257	5	paramInt2	int
    //   22	1	6	localFileInputStream1	FileInputStream
    //   55	3	6	localThrowable	java.lang.Throwable
    //   73	24	6	localFileInputStream2	FileInputStream
    //   247	1	6	localException1	java.lang.Exception
    //   252	1	6	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   38	52	55	java/lang/Throwable
    //   2	35	153	finally
    //   38	52	153	finally
    //   57	62	153	finally
    //   62	96	153	finally
    //   96	107	153	finally
    //   160	184	153	finally
    //   184	187	153	finally
    //   2	35	158	java/io/IOException
    //   38	52	158	java/io/IOException
    //   57	62	158	java/io/IOException
    //   62	96	158	java/io/IOException
    //   96	107	158	java/io/IOException
    //   110	149	229	finally
    //   149	151	229	finally
    //   187	226	229	finally
    //   234	237	229	finally
    //   237	239	229	finally
    //   110	149	242	java/lang/Exception
    //   160	184	247	java/lang/Exception
    //   187	226	252	java/lang/Exception
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[File:");
    localStringBuilder.append(this.mFilePath);
    localStringBuilder.append(",Size:");
    localStringBuilder.append(getDataLength());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mFilePath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.task.data.UploadDataSource.FileDataSource
 * JD-Core Version:    0.7.0.1
 */