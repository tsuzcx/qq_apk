package com.tencent.qqmusic.mediaplayer.perf;

import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import org.xmlpull.v1.XmlSerializer;

public class PrefInfoCollector
  implements PlayerInfoCollector
{
  private static final String ENCODING_UTF_8 = "utf-8";
  private static final String FILE_NAME = "pref_infos.xml";
  private static final String NAMESPACE;
  private static final String ROOT = "root";
  private static final String TAG = "PrefInfoCollector";
  private static PrefInfoCollector instance;
  private HandlerThread mHandlerThread;
  private Handler mReportHandler;
  private FileOutputStream outputStream;
  private HashMap<String, Long> prefInfos = null;
  private String reportFilePath;
  private XmlSerializer xmlSerializer = null;
  
  /* Error */
  private void createOutputs()
  {
    // Byte code:
    //   0: new 78	java/io/File
    //   3: dup
    //   4: invokestatic 84	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   7: invokevirtual 87	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   10: ldc 13
    //   12: invokespecial 90	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: astore_1
    //   16: aload_1
    //   17: invokevirtual 94	java/io/File:exists	()Z
    //   20: ifeq +13 -> 33
    //   23: aload_1
    //   24: invokevirtual 97	java/io/File:delete	()Z
    //   27: pop
    //   28: aload_1
    //   29: invokevirtual 100	java/io/File:createNewFile	()Z
    //   32: pop
    //   33: getstatic 72	com/tencent/qqmusic/mediaplayer/perf/PrefInfoCollector:TAG	Ljava/lang/String;
    //   36: astore_2
    //   37: new 102	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   44: astore_3
    //   45: aload_3
    //   46: ldc 105
    //   48: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: aload_3
    //   53: aload_1
    //   54: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload_2
    //   59: aload_3
    //   60: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 120	com/tencent/qqmusic/mediaplayer/util/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: aload_0
    //   67: aload_1
    //   68: invokevirtual 87	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   71: putfield 122	com/tencent/qqmusic/mediaplayer/perf/PrefInfoCollector:reportFilePath	Ljava/lang/String;
    //   74: aload_0
    //   75: new 124	java/io/FileOutputStream
    //   78: dup
    //   79: aload_1
    //   80: invokespecial 127	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   83: putfield 129	com/tencent/qqmusic/mediaplayer/perf/PrefInfoCollector:outputStream	Ljava/io/FileOutputStream;
    //   86: getstatic 72	com/tencent/qqmusic/mediaplayer/perf/PrefInfoCollector:TAG	Ljava/lang/String;
    //   89: astore_1
    //   90: new 102	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   97: astore_2
    //   98: aload_2
    //   99: ldc 131
    //   101: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload_2
    //   106: aload_0
    //   107: getfield 122	com/tencent/qqmusic/mediaplayer/perf/PrefInfoCollector:reportFilePath	Ljava/lang/String;
    //   110: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload_1
    //   115: aload_2
    //   116: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 120	com/tencent/qqmusic/mediaplayer/util/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: aload_0
    //   123: getfield 44	com/tencent/qqmusic/mediaplayer/perf/PrefInfoCollector:xmlSerializer	Lorg/xmlpull/v1/XmlSerializer;
    //   126: ldc 133
    //   128: iconst_1
    //   129: invokeinterface 139 3 0
    //   134: aload_0
    //   135: getfield 44	com/tencent/qqmusic/mediaplayer/perf/PrefInfoCollector:xmlSerializer	Lorg/xmlpull/v1/XmlSerializer;
    //   138: aload_0
    //   139: getfield 129	com/tencent/qqmusic/mediaplayer/perf/PrefInfoCollector:outputStream	Ljava/io/FileOutputStream;
    //   142: ldc 10
    //   144: invokeinterface 143 3 0
    //   149: aload_0
    //   150: getfield 44	com/tencent/qqmusic/mediaplayer/perf/PrefInfoCollector:xmlSerializer	Lorg/xmlpull/v1/XmlSerializer;
    //   153: ldc 10
    //   155: iconst_1
    //   156: invokestatic 149	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   159: invokeinterface 153 3 0
    //   164: return
    //   165: astore_1
    //   166: getstatic 72	com/tencent/qqmusic/mediaplayer/perf/PrefInfoCollector:TAG	Ljava/lang/String;
    //   169: ldc 155
    //   171: aload_1
    //   172: invokestatic 159	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   175: new 102	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   182: astore_2
    //   183: aload_2
    //   184: ldc 161
    //   186: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload_2
    //   191: aload_1
    //   192: invokevirtual 164	java/io/IOException:getMessage	()Ljava/lang/String;
    //   195: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: new 166	java/lang/RuntimeException
    //   202: dup
    //   203: aload_2
    //   204: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: aload_1
    //   208: invokespecial 169	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   211: athrow
    //   212: astore_1
    //   213: getstatic 72	com/tencent/qqmusic/mediaplayer/perf/PrefInfoCollector:TAG	Ljava/lang/String;
    //   216: ldc 171
    //   218: aload_1
    //   219: invokestatic 159	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   222: new 102	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   229: astore_2
    //   230: aload_2
    //   231: ldc 173
    //   233: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: pop
    //   237: aload_2
    //   238: aload_1
    //   239: invokevirtual 164	java/io/IOException:getMessage	()Ljava/lang/String;
    //   242: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: pop
    //   246: new 166	java/lang/RuntimeException
    //   249: dup
    //   250: aload_2
    //   251: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: aload_1
    //   255: invokespecial 169	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   258: athrow
    //   259: astore_1
    //   260: getstatic 72	com/tencent/qqmusic/mediaplayer/perf/PrefInfoCollector:TAG	Ljava/lang/String;
    //   263: ldc 175
    //   265: aload_1
    //   266: invokestatic 159	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   269: new 102	java/lang/StringBuilder
    //   272: dup
    //   273: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   276: astore_2
    //   277: aload_2
    //   278: ldc 177
    //   280: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: pop
    //   284: aload_2
    //   285: aload_1
    //   286: invokevirtual 178	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   289: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: pop
    //   293: new 166	java/lang/RuntimeException
    //   296: dup
    //   297: aload_2
    //   298: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: aload_1
    //   302: invokespecial 169	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   305: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	306	0	this	PrefInfoCollector
    //   15	100	1	localObject1	Object
    //   165	43	1	localIOException1	java.io.IOException
    //   212	43	1	localIOException2	java.io.IOException
    //   259	43	1	localFileNotFoundException	java.io.FileNotFoundException
    //   36	262	2	localObject2	Object
    //   44	16	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   122	164	165	java/io/IOException
    //   0	33	212	java/io/IOException
    //   33	122	212	java/io/IOException
    //   0	33	259	java/io/FileNotFoundException
    //   33	122	259	java/io/FileNotFoundException
  }
  
  public static PrefInfoCollector getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new PrefInfoCollector();
      }
      PrefInfoCollector localPrefInfoCollector = instance;
      return localPrefInfoCollector;
    }
    finally {}
  }
  
  private void printPrefInfos(AudioInformation paramAudioInformation)
  {
    Object localObject = new ArrayList(this.prefInfos.entrySet());
    Collections.sort((List)localObject, new PrefInfoCollector.1(this));
    if (!((List)localObject).isEmpty())
    {
      this.xmlSerializer.startTag(NAMESPACE, "root");
      printProperty("device.manufacturer", Build.MANUFACTURER);
      printProperty("device.model", Build.MODEL);
      printProperty("device.apiLevel", String.valueOf(Build.VERSION.SDK_INT));
      printAudioInfomation(paramAudioInformation);
      paramAudioInformation = ((List)localObject).iterator();
      while (paramAudioInformation.hasNext())
      {
        localObject = (Map.Entry)paramAudioInformation.next();
        long l = ((Long)((Map.Entry)localObject).getValue()).longValue();
        localObject = (String)((Map.Entry)localObject).getKey();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(l);
        localStringBuilder.append("");
        printProperty((String)localObject, localStringBuilder.toString());
      }
      this.xmlSerializer.endTag(NAMESPACE, "root");
      this.xmlSerializer.endDocument();
      this.xmlSerializer.flush();
    }
  }
  
  private void printProperty(String paramString1, String paramString2)
  {
    this.xmlSerializer.startTag(NAMESPACE, paramString1);
    this.xmlSerializer.text(paramString2);
    this.xmlSerializer.endTag(NAMESPACE, paramString1);
  }
  
  private void upLoadByCommonPost()
  {
    Logger.i(TAG, "upLoadByCommonPost");
    Object localObject1 = (HttpURLConnection)new URL(" http://musict.proxy.music.qq.com/qmtm2/PlayPerformanceReport.fcg").openConnection();
    ((HttpURLConnection)localObject1).setDoInput(true);
    ((HttpURLConnection)localObject1).setDoOutput(true);
    ((HttpURLConnection)localObject1).setUseCaches(false);
    ((HttpURLConnection)localObject1).setRequestMethod("POST");
    ((HttpURLConnection)localObject1).setRequestProperty("Connection", "Keep-Alive");
    ((HttpURLConnection)localObject1).setRequestProperty("Charset", "UTF-8");
    ((HttpURLConnection)localObject1).setRequestProperty("Content-Type", "text/xml");
    DataOutputStream localDataOutputStream = new DataOutputStream(((HttpURLConnection)localObject1).getOutputStream());
    Object localObject2 = new FileInputStream(this.reportFilePath);
    Object localObject3 = new byte[8192];
    for (;;)
    {
      int i = ((FileInputStream)localObject2).read((byte[])localObject3);
      if (i == -1) {
        break;
      }
      localDataOutputStream.write((byte[])localObject3, 0, i);
    }
    ((FileInputStream)localObject2).close();
    localDataOutputStream.writeBytes("\r\n");
    localDataOutputStream.flush();
    localObject1 = ((HttpURLConnection)localObject1).getInputStream();
    localObject2 = new BufferedReader(new InputStreamReader((InputStream)localObject1, "UTF-8")).readLine();
    localObject3 = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("upload result:");
    localStringBuilder.append((String)localObject2);
    Logger.i((String)localObject3, localStringBuilder.toString());
    localDataOutputStream.close();
    ((InputStream)localObject1).close();
  }
  
  public void printAudioInfomation(AudioInformation paramAudioInformation)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramAudioInformation.getAudioType());
    localStringBuilder.append("");
    printProperty("audio.format", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramAudioInformation.getSampleRate());
    localStringBuilder.append("");
    printProperty("audio.sampleRate", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramAudioInformation.getPlaySample());
    localStringBuilder.append("");
    printProperty("audio.PlaySample", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramAudioInformation.getBitDepth());
    localStringBuilder.append("");
    printProperty("audio.bitDepth", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramAudioInformation.getChannels());
    localStringBuilder.append("");
    printProperty("audio.channels", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramAudioInformation.getDuration());
    localStringBuilder.append("");
    printProperty("audio.duration", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramAudioInformation.getBitrate());
    localStringBuilder.append("");
    printProperty("audio.bitRate", localStringBuilder.toString());
  }
  
  public void putBoolean(String paramString, boolean paramBoolean) {}
  
  public void putInt(String paramString, int paramInt) {}
  
  public void putLong(String paramString, long paramLong)
  {
    this.prefInfos.put(paramString, Long.valueOf(paramLong));
  }
  
  public void putString(String paramString1, String paramString2) {}
  
  public void putUri(String paramString, Uri paramUri) {}
  
  public void upLoadPrefInfos(AudioInformation paramAudioInformation)
  {
    HashMap localHashMap = this.prefInfos;
    if (localHashMap != null)
    {
      if (localHashMap.isEmpty()) {
        return;
      }
      if ((this.mHandlerThread == null) || (this.mReportHandler == null))
      {
        this.mHandlerThread = new HandlerThread("PrefInfoCollector");
        this.mHandlerThread.start();
        this.mReportHandler = new Handler(this.mHandlerThread.getLooper());
      }
      this.mReportHandler.post(new PrefInfoCollector.2(this, paramAudioInformation));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.perf.PrefInfoCollector
 * JD-Core Version:    0.7.0.1
 */