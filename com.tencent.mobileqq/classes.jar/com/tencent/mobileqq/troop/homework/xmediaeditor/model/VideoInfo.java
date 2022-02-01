package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import android.text.TextUtils;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditorAdapter;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.EditorViewHolderManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ImageItem.ImageViewHolder;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.VideoItem;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.VideoItem.VideoViewHolder;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoInfo
  extends ImageInfo
{
  public String q;
  public String r;
  public String s;
  
  public VideoInfo(String paramString)
  {
    this.r = paramString;
    k();
    this.e = String.valueOf(hashCode());
  }
  
  public VideoInfo(JSONObject paramJSONObject)
  {
    a(paramJSONObject);
    this.e = String.valueOf(hashCode());
  }
  
  /* Error */
  private void k()
  {
    // Byte code:
    //   0: invokestatic 46	java/lang/System:currentTimeMillis	()J
    //   3: lstore_2
    //   4: aload_0
    //   5: getfield 15	com/tencent/mobileqq/troop/homework/xmediaeditor/model/VideoInfo:r	Ljava/lang/String;
    //   8: invokestatic 52	com/tencent/mobileqq/utils/FileUtils:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   11: ifeq +388 -> 399
    //   14: aconst_null
    //   15: astore 7
    //   17: aconst_null
    //   18: astore 5
    //   20: new 54	android/media/MediaMetadataRetriever
    //   23: dup
    //   24: invokespecial 55	android/media/MediaMetadataRetriever:<init>	()V
    //   27: astore 6
    //   29: aload 6
    //   31: aload_0
    //   32: getfield 15	com/tencent/mobileqq/troop/homework/xmediaeditor/model/VideoInfo:r	Ljava/lang/String;
    //   35: invokevirtual 58	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   38: aload_0
    //   39: aload 6
    //   41: bipush 18
    //   43: invokevirtual 61	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   46: invokestatic 66	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   49: invokevirtual 69	java/lang/Integer:intValue	()I
    //   52: putfield 73	com/tencent/mobileqq/troop/homework/xmediaeditor/model/VideoInfo:f	I
    //   55: aload_0
    //   56: aload 6
    //   58: bipush 19
    //   60: invokevirtual 61	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   63: invokestatic 66	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   66: invokevirtual 69	java/lang/Integer:intValue	()I
    //   69: putfield 76	com/tencent/mobileqq/troop/homework/xmediaeditor/model/VideoInfo:j	I
    //   72: getstatic 81	android/os/Build$VERSION:SDK_INT	I
    //   75: bipush 17
    //   77: if_icmplt +80 -> 157
    //   80: aload 6
    //   82: bipush 24
    //   84: invokevirtual 61	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   87: invokestatic 66	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   90: invokevirtual 69	java/lang/Integer:intValue	()I
    //   93: istore_1
    //   94: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   97: ifeq +317 -> 414
    //   100: ldc 89
    //   102: iconst_2
    //   103: iconst_4
    //   104: anewarray 20	java/lang/Object
    //   107: dup
    //   108: iconst_0
    //   109: ldc 91
    //   111: aastore
    //   112: dup
    //   113: iconst_1
    //   114: getstatic 81	android/os/Build$VERSION:SDK_INT	I
    //   117: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   120: aastore
    //   121: dup
    //   122: iconst_2
    //   123: ldc 96
    //   125: aastore
    //   126: dup
    //   127: iconst_3
    //   128: iload_1
    //   129: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   132: aastore
    //   133: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   136: goto +278 -> 414
    //   139: aload_0
    //   140: getfield 73	com/tencent/mobileqq/troop/homework/xmediaeditor/model/VideoInfo:f	I
    //   143: istore_1
    //   144: aload_0
    //   145: aload_0
    //   146: getfield 76	com/tencent/mobileqq/troop/homework/xmediaeditor/model/VideoInfo:j	I
    //   149: putfield 73	com/tencent/mobileqq/troop/homework/xmediaeditor/model/VideoInfo:f	I
    //   152: aload_0
    //   153: iload_1
    //   154: putfield 76	com/tencent/mobileqq/troop/homework/xmediaeditor/model/VideoInfo:j	I
    //   157: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   160: istore 4
    //   162: iload 4
    //   164: ifeq +74 -> 238
    //   167: ldc 89
    //   169: iconst_2
    //   170: bipush 8
    //   172: anewarray 20	java/lang/Object
    //   175: dup
    //   176: iconst_0
    //   177: ldc 102
    //   179: aastore
    //   180: dup
    //   181: iconst_1
    //   182: aload_0
    //   183: getfield 15	com/tencent/mobileqq/troop/homework/xmediaeditor/model/VideoInfo:r	Ljava/lang/String;
    //   186: aastore
    //   187: dup
    //   188: iconst_2
    //   189: ldc 104
    //   191: aastore
    //   192: dup
    //   193: iconst_3
    //   194: aload_0
    //   195: getfield 73	com/tencent/mobileqq/troop/homework/xmediaeditor/model/VideoInfo:f	I
    //   198: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   201: aastore
    //   202: dup
    //   203: iconst_4
    //   204: ldc 106
    //   206: aastore
    //   207: dup
    //   208: iconst_5
    //   209: aload_0
    //   210: getfield 76	com/tencent/mobileqq/troop/homework/xmediaeditor/model/VideoInfo:j	I
    //   213: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   216: aastore
    //   217: dup
    //   218: bipush 6
    //   220: ldc 108
    //   222: aastore
    //   223: dup
    //   224: bipush 7
    //   226: invokestatic 46	java/lang/System:currentTimeMillis	()J
    //   229: lload_2
    //   230: lsub
    //   231: invokestatic 113	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   234: aastore
    //   235: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   238: aload_0
    //   239: getfield 73	com/tencent/mobileqq/troop/homework/xmediaeditor/model/VideoInfo:f	I
    //   242: ifle +10 -> 252
    //   245: aload_0
    //   246: getfield 76	com/tencent/mobileqq/troop/homework/xmediaeditor/model/VideoInfo:j	I
    //   249: ifgt +73 -> 322
    //   252: aload_0
    //   253: aload_0
    //   254: getfield 115	com/tencent/mobileqq/troop/homework/xmediaeditor/model/VideoInfo:k	I
    //   257: putfield 73	com/tencent/mobileqq/troop/homework/xmediaeditor/model/VideoInfo:f	I
    //   260: aload_0
    //   261: aload_0
    //   262: getfield 115	com/tencent/mobileqq/troop/homework/xmediaeditor/model/VideoInfo:k	I
    //   265: bipush 9
    //   267: imul
    //   268: i2f
    //   269: ldc 116
    //   271: fdiv
    //   272: f2i
    //   273: putfield 76	com/tencent/mobileqq/troop/homework/xmediaeditor/model/VideoInfo:j	I
    //   276: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   279: ifeq +43 -> 322
    //   282: ldc 89
    //   284: iconst_2
    //   285: iconst_4
    //   286: anewarray 20	java/lang/Object
    //   289: dup
    //   290: iconst_0
    //   291: ldc 118
    //   293: aastore
    //   294: dup
    //   295: iconst_1
    //   296: aload_0
    //   297: getfield 73	com/tencent/mobileqq/troop/homework/xmediaeditor/model/VideoInfo:f	I
    //   300: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   303: aastore
    //   304: dup
    //   305: iconst_2
    //   306: ldc 106
    //   308: aastore
    //   309: dup
    //   310: iconst_3
    //   311: aload_0
    //   312: getfield 76	com/tencent/mobileqq/troop/homework/xmediaeditor/model/VideoInfo:j	I
    //   315: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   318: aastore
    //   319: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   322: aload 6
    //   324: invokevirtual 121	android/media/MediaMetadataRetriever:release	()V
    //   327: return
    //   328: astore 5
    //   330: goto +56 -> 386
    //   333: goto +16 -> 349
    //   336: astore 7
    //   338: aload 5
    //   340: astore 6
    //   342: aload 7
    //   344: astore 5
    //   346: goto +40 -> 386
    //   349: aload 6
    //   351: astore 5
    //   353: ldc 89
    //   355: iconst_1
    //   356: iconst_2
    //   357: anewarray 20	java/lang/Object
    //   360: dup
    //   361: iconst_0
    //   362: ldc 123
    //   364: aastore
    //   365: dup
    //   366: iconst_1
    //   367: aload_0
    //   368: getfield 15	com/tencent/mobileqq/troop/homework/xmediaeditor/model/VideoInfo:r	Ljava/lang/String;
    //   371: aastore
    //   372: invokestatic 125	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   375: aload 6
    //   377: ifnull +22 -> 399
    //   380: aload 6
    //   382: invokevirtual 121	android/media/MediaMetadataRetriever:release	()V
    //   385: return
    //   386: aload 6
    //   388: ifnull +8 -> 396
    //   391: aload 6
    //   393: invokevirtual 121	android/media/MediaMetadataRetriever:release	()V
    //   396: aload 5
    //   398: athrow
    //   399: return
    //   400: astore 5
    //   402: aload 7
    //   404: astore 6
    //   406: goto -57 -> 349
    //   409: astore 5
    //   411: goto -78 -> 333
    //   414: iload_1
    //   415: bipush 90
    //   417: if_icmpeq -278 -> 139
    //   420: iload_1
    //   421: sipush 270
    //   424: if_icmpne -267 -> 157
    //   427: goto -288 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	430	0	this	VideoInfo
    //   93	332	1	i	int
    //   3	227	2	l	long
    //   160	3	4	bool	boolean
    //   18	1	5	localObject1	Object
    //   328	11	5	localObject2	Object
    //   344	53	5	localObject3	Object
    //   400	1	5	localException1	java.lang.Exception
    //   409	1	5	localException2	java.lang.Exception
    //   27	378	6	localObject4	Object
    //   15	1	7	localObject5	Object
    //   336	67	7	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   29	136	328	finally
    //   139	157	328	finally
    //   157	162	328	finally
    //   167	238	328	finally
    //   238	252	328	finally
    //   252	322	328	finally
    //   20	29	336	finally
    //   353	375	336	finally
    //   20	29	400	java/lang/Exception
    //   29	136	409	java/lang/Exception
    //   139	157	409	java/lang/Exception
    //   157	162	409	java/lang/Exception
    //   167	238	409	java/lang/Exception
    //   238	252	409	java/lang/Exception
    //   252	322	409	java/lang/Exception
  }
  
  public Stream<ImageInfo> a(XMediaEditor paramXMediaEditor)
  {
    Object localObject2 = Stream.of(this).map(new ThreadOffFunction("VideoInfo", 2));
    Object localObject1 = localObject2;
    if (!FileUtils.fileExistsAndNotEmpty(this.s))
    {
      if (this.o >= 0) {
        this.o = -2147483646;
      }
      localObject1 = ((Stream)localObject2).map(new VideoInfo.CompressVideoSegment(paramXMediaEditor));
    }
    String str = paramXMediaEditor.a("troopuin");
    localObject2 = localObject1;
    if (TextUtils.isEmpty(this.q))
    {
      if (this.o >= 0) {
        this.o = -2147483647;
      }
      localObject2 = ((Stream)localObject1).map(new ImageInfo.UploadMediaSegment(1, paramXMediaEditor, str));
    }
    localObject1 = localObject2;
    if (TextUtils.isEmpty(this.b))
    {
      if (this.o >= 0) {
        this.o = -2147483648;
      }
      localObject1 = ((Stream)localObject2).map(new ImageInfo.UploadMediaSegment(2, paramXMediaEditor, str));
    }
    localObject2 = paramXMediaEditor.findViewHolderForLayoutPosition(this.g);
    if ((localObject2 instanceof VideoItem.VideoViewHolder))
    {
      localObject2 = (VideoItem.VideoViewHolder)localObject2;
      if (this.e.equals(((VideoItem.VideoViewHolder)localObject2).g.getTag())) {
        ((VideoItem)((XMediaEditorAdapter)paramXMediaEditor.getAdapter()).a.a(2)).a((ImageItem.ImageViewHolder)localObject2, this, 0);
      }
    }
    return ((Stream)localObject1).map(new UIThreadOffFunction(null));
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoInfo", 2, new Object[] { "VideoInfo createFrom json: ", paramJSONObject });
    }
    this.h = paramJSONObject;
    b(paramJSONObject.optString("poster"));
    this.f = paramJSONObject.optInt("width");
    this.j = paramJSONObject.optInt("height");
    this.q = paramJSONObject.optString("url");
    if (!TextUtils.isEmpty(this.q)) {
      this.q = this.q.replace("https://", "http://");
    }
  }
  
  public int b()
  {
    return 2;
  }
  
  public Stream<VideoInfo> b(XMediaEditor paramXMediaEditor)
  {
    this.o = 1;
    if (FileUtils.fileExistsAndNotEmpty(this.c)) {
      return null;
    }
    Stream localStream2 = Stream.of(this).map(new ThreadOffFunction("VideoInfo", 2));
    Stream localStream1 = localStream2;
    if (!FileUtils.fileExistsAndNotEmpty(this.c))
    {
      this.o = -2147483645;
      localStream1 = localStream2.map(new VideoInfo.GenerateVideoPosterSegment(paramXMediaEditor, this.k)).map(new UIThreadOffFunction(null));
    }
    return localStream1;
  }
  
  public void b(String paramString)
  {
    try
    {
      this.d = new URL(paramString);
      this.b = paramString;
      return;
    }
    catch (MalformedURLException paramString)
    {
      label18:
      break label18;
    }
    QLog.e("VideoInfo", 1, "Video setURLFromContentUrl exception.");
  }
  
  public boolean c()
  {
    return TextUtils.isEmpty(this.q) ^ true;
  }
  
  public JSONObject d()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", "video");
      localJSONObject.put("url", this.q);
      localJSONObject.put("width", this.f);
      localJSONObject.put("height", this.j);
      localJSONObject.put("poster", this.b);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      label65:
      break label65;
    }
    if (QLog.isColorLevel()) {
      QLog.e("VideoInfo", 2, "VideoInfo getContent exception.");
    }
    return localJSONObject;
  }
  
  public String e()
  {
    if (TextUtils.isEmpty(this.r)) {
      return this.q;
    }
    return this.r;
  }
  
  public boolean g()
  {
    return (TextUtils.isEmpty(this.q)) || (TextUtils.isEmpty(this.b));
  }
  
  public int i()
  {
    switch (this.o)
    {
    default: 
      return this.o;
    }
    return 1;
  }
  
  public String j()
  {
    if (TextUtils.isEmpty(this.r)) {
      return this.q;
    }
    return this.r;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.VideoInfo
 * JD-Core Version:    0.7.0.1
 */