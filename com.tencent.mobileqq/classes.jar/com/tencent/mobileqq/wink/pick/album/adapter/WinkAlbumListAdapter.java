package com.tencent.mobileqq.wink.pick.album.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.wink.pick.album.fragment.WinkAbstractAlbumListFragment;
import com.tencent.mobileqq.wink.pick.album.logic.WinkAlbumListLogic;
import com.tencent.mobileqq.wink.pick.album.logic.WinkAlbumListLogic.IalbumListAdapterCallBack;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WinkAlbumListAdapter
  extends BaseAdapter
{
  public static final ColorDrawable a = new ColorDrawable(-2141891243);
  static final String[] j = { "bucket_id", "bucket_display_name", "MAX(_id) as _id", "date_modified", "_data", "orientation", "mime_type", "COUNT(_data) as count" };
  static final String k;
  static String[] l;
  static final String[] m = { "_id", "_data", "duration", "date_modified", "mime_type", "_size" };
  static final String[] n = { "bucket_id", "bucket_display_name", "MAX(_id) as _id", "date_modified", "_data", "mime_type", "COUNT(_data) as count" };
  WinkAlbumListLogic.IalbumListAdapterCallBack b;
  public Resources c;
  public int d;
  public int e;
  public boolean f;
  List<QQAlbumInfo> g = new ArrayList();
  public Drawable.ConstantState h;
  Handler i = new Handler();
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("_size>0 and ( _size < ");
    localStringBuilder.append(QAlbumUtil.CONFIG_LIMIT_MAX_IMAGE_FILE_SIZE);
    localStringBuilder.append(" )  and (");
    localStringBuilder.append("width");
    localStringBuilder.append(">= 240 or ");
    localStringBuilder.append("width");
    localStringBuilder.append(" IS NULL) and (");
    localStringBuilder.append("height");
    localStringBuilder.append(">= 240 or ");
    localStringBuilder.append("height");
    localStringBuilder.append(" IS NULL )  and ");
    localStringBuilder.append("height");
    localStringBuilder.append("  * 1.0 / ");
    localStringBuilder.append("width");
    localStringBuilder.append(">= 0.45 and ");
    localStringBuilder.append("height");
    localStringBuilder.append("  * 1.0 / ");
    localStringBuilder.append("width");
    localStringBuilder.append("<= 2.2 and (");
    localStringBuilder.append("mime_type");
    localStringBuilder.append("='");
    localStringBuilder.append("image/jpeg");
    localStringBuilder.append("' or (");
    localStringBuilder.append("mime_type");
    localStringBuilder.append("='");
    localStringBuilder.append("*/*");
    localStringBuilder.append("' and ");
    localStringBuilder.append("_display_name");
    localStringBuilder.append(" LIKE'%.jpg%' )  or (");
    localStringBuilder.append("mime_type");
    localStringBuilder.append("='");
    localStringBuilder.append("*/*");
    localStringBuilder.append("' and ");
    localStringBuilder.append("_display_name");
    localStringBuilder.append(" LIKE'%.jpeg%' )  or (");
    localStringBuilder.append("mime_type");
    localStringBuilder.append("='");
    localStringBuilder.append("*/*");
    localStringBuilder.append("' and ");
    localStringBuilder.append("_display_name");
    localStringBuilder.append(" LIKE'%.bmp%' )  or (");
    localStringBuilder.append("mime_type");
    localStringBuilder.append("='");
    localStringBuilder.append("*/*");
    localStringBuilder.append("' and ");
    localStringBuilder.append("_display_name");
    localStringBuilder.append(" LIKE'%.png%' )  or ");
    localStringBuilder.append("mime_type");
    localStringBuilder.append(" LIKE'%");
    localStringBuilder.append("bmp");
    localStringBuilder.append("%' or ");
    localStringBuilder.append("mime_type");
    localStringBuilder.append(" LIKE'%");
    localStringBuilder.append("bitmap");
    localStringBuilder.append("%' or ");
    localStringBuilder.append("mime_type");
    localStringBuilder.append("='");
    localStringBuilder.append("image/png");
    localStringBuilder.append("'");
    k = localStringBuilder.toString();
    if (Build.VERSION.SDK_INT >= 16) {
      l = new String[] { "_id", "_data", "mime_type", "date_modified", "orientation", "_size", "width" };
    } else {
      l = new String[] { "_id", "_data", "mime_type", "date_modified", "orientation", "_size" };
    }
  }
  
  public WinkAlbumListAdapter(WinkAbstractAlbumListFragment paramWinkAbstractAlbumListFragment)
  {
    this.b = paramWinkAbstractAlbumListFragment.b.e;
    this.c = paramWinkAbstractAlbumListFragment.getResources();
    this.h = this.c.getDrawable(2130853633).getConstantState();
    this.d = this.c.getDimensionPixelSize(2131296706);
    this.e = this.d;
  }
  
  public static boolean a(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    paramString = paramString.toLowerCase();
    if (paramString.equalsIgnoreCase("camera")) {
      return true;
    }
    return paramString.equalsIgnoreCase("100media");
  }
  
  public QQAlbumInfo a(int paramInt)
  {
    return (QQAlbumInfo)this.g.get(paramInt);
  }
  
  /* Error */
  public QQAlbumInfo a(Context paramContext)
  {
    // Byte code:
    //   0: new 225	com/tencent/mobileqq/data/QQAlbumInfo
    //   3: dup
    //   4: invokespecial 229	com/tencent/mobileqq/data/QQAlbumInfo:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: ldc 231
    //   13: putfield 234	com/tencent/mobileqq/data/QQAlbumInfo:id	Ljava/lang/String;
    //   16: aload 6
    //   18: getstatic 239	com/tencent/mobileqq/activity/photo/album/QAlbumCustomAlbumConstants:VIDEO_ALBUM_NAME	Ljava/lang/String;
    //   21: putfield 242	com/tencent/mobileqq/data/QQAlbumInfo:name	Ljava/lang/String;
    //   24: aload 6
    //   26: iconst_0
    //   27: putfield 245	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   30: aconst_null
    //   31: astore 5
    //   33: aconst_null
    //   34: astore 4
    //   36: aconst_null
    //   37: astore_3
    //   38: aload 5
    //   40: astore_2
    //   41: getstatic 251	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   44: astore 7
    //   46: aload 5
    //   48: astore_2
    //   49: aload_1
    //   50: invokevirtual 257	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   53: aload 7
    //   55: getstatic 149	com/tencent/mobileqq/wink/pick/album/adapter/WinkAlbumListAdapter:m	[Ljava/lang/String;
    //   58: ldc_w 259
    //   61: aconst_null
    //   62: ldc_w 261
    //   65: invokevirtual 267	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   68: astore_1
    //   69: iconst_2
    //   70: invokestatic 273	com/tencent/mobileqq/activity/photo/MediaFileFilter:getFilter	(I)Lcom/tencent/mobileqq/activity/photo/MediaFileFilter;
    //   73: astore 4
    //   75: aload_3
    //   76: astore_2
    //   77: aload 4
    //   79: ifnull +12 -> 91
    //   82: aload_0
    //   83: aload_1
    //   84: iconst_m1
    //   85: aload 4
    //   87: invokevirtual 276	com/tencent/mobileqq/wink/pick/album/adapter/WinkAlbumListAdapter:a	(Landroid/database/Cursor;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;)Ljava/util/List;
    //   90: astore_2
    //   91: invokestatic 282	com/tencent/biz/richframework/delegate/impl/RFApplication:getApplication	()Landroid/content/Context;
    //   94: invokestatic 288	com/tencent/mobileqq/activity/photo/MediaScanner:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/activity/photo/MediaScanner;
    //   97: iconst_0
    //   98: iconst_m1
    //   99: invokevirtual 292	com/tencent/mobileqq/activity/photo/MediaScanner:getMediaScannerInfos	(ZI)Ljava/util/ArrayList;
    //   102: astore_3
    //   103: aload_2
    //   104: ifnull +44 -> 148
    //   107: aload_2
    //   108: invokeinterface 296 1 0
    //   113: ifne +35 -> 148
    //   116: aload 6
    //   118: aload 6
    //   120: getfield 245	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   123: aload_2
    //   124: invokeinterface 300 1 0
    //   129: iadd
    //   130: putfield 245	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   133: aload 6
    //   135: aload_2
    //   136: iconst_0
    //   137: invokeinterface 223 2 0
    //   142: checkcast 302	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   145: putfield 306	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   148: aload_3
    //   149: ifnull +152 -> 301
    //   152: aload_3
    //   153: invokevirtual 307	java/util/ArrayList:isEmpty	()Z
    //   156: ifne +145 -> 301
    //   159: aload 6
    //   161: aload 6
    //   163: getfield 245	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   166: aload_3
    //   167: invokevirtual 308	java/util/ArrayList:size	()I
    //   170: iadd
    //   171: putfield 245	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   174: aload_3
    //   175: iconst_0
    //   176: invokevirtual 309	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   179: checkcast 311	com/tencent/mobileqq/activity/photo/MediaScannerInfo
    //   182: astore_2
    //   183: aload 6
    //   185: getfield 306	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   188: ifnull +19 -> 207
    //   191: aload 6
    //   193: getfield 306	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   196: getfield 315	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   199: aload_2
    //   200: getfield 316	com/tencent/mobileqq/activity/photo/MediaScannerInfo:modifiedDate	J
    //   203: lcmp
    //   204: ifge +97 -> 301
    //   207: aload 6
    //   209: new 302	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   212: dup
    //   213: invokespecial 317	com/tencent/mobileqq/activity/photo/LocalMediaInfo:<init>	()V
    //   216: putfield 306	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   219: aload 6
    //   221: getfield 306	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   224: aload_2
    //   225: getfield 319	com/tencent/mobileqq/activity/photo/MediaScannerInfo:id	I
    //   228: i2l
    //   229: putfield 321	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   232: aload 6
    //   234: getfield 306	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   237: aload_2
    //   238: getfield 323	com/tencent/mobileqq/activity/photo/MediaScannerInfo:duration	J
    //   241: putfield 326	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   244: aload 6
    //   246: getfield 306	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   249: aload_2
    //   250: getfield 329	com/tencent/mobileqq/activity/photo/MediaScannerInfo:fileSize	J
    //   253: putfield 330	com/tencent/mobileqq/activity/photo/LocalMediaInfo:fileSize	J
    //   256: aload 6
    //   258: getfield 306	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   261: aload_2
    //   262: getfield 333	com/tencent/mobileqq/activity/photo/MediaScannerInfo:path	Ljava/lang/String;
    //   265: putfield 334	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   268: aload 6
    //   270: getfield 306	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   273: aload_2
    //   274: getfield 316	com/tencent/mobileqq/activity/photo/MediaScannerInfo:modifiedDate	J
    //   277: putfield 315	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   280: aload 6
    //   282: getfield 306	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   285: aload_2
    //   286: getfield 337	com/tencent/mobileqq/activity/photo/MediaScannerInfo:mimeType	Ljava/lang/String;
    //   289: putfield 340	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   292: aload 6
    //   294: getfield 306	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   297: iconst_0
    //   298: putfield 343	com/tencent/mobileqq/activity/photo/LocalMediaInfo:isSystemMeidaStore	Z
    //   301: aload_1
    //   302: ifnull +64 -> 366
    //   305: aload_1
    //   306: invokeinterface 348 1 0
    //   311: aload 6
    //   313: areturn
    //   314: astore_2
    //   315: goto +54 -> 369
    //   318: astore_3
    //   319: goto +15 -> 334
    //   322: astore_3
    //   323: aload_2
    //   324: astore_1
    //   325: aload_3
    //   326: astore_2
    //   327: goto +42 -> 369
    //   330: astore_3
    //   331: aload 4
    //   333: astore_1
    //   334: aload_1
    //   335: astore_2
    //   336: invokestatic 353	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   339: ifeq +17 -> 356
    //   342: aload_1
    //   343: astore_2
    //   344: ldc_w 355
    //   347: iconst_2
    //   348: aload_3
    //   349: invokevirtual 358	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   352: aload_3
    //   353: invokestatic 361	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   356: aload_1
    //   357: ifnull +9 -> 366
    //   360: aload_1
    //   361: invokeinterface 348 1 0
    //   366: aload 6
    //   368: areturn
    //   369: aload_1
    //   370: ifnull +9 -> 379
    //   373: aload_1
    //   374: invokeinterface 348 1 0
    //   379: aload_2
    //   380: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	381	0	this	WinkAlbumListAdapter
    //   0	381	1	paramContext	Context
    //   40	246	2	localObject1	Object
    //   314	10	2	localObject2	Object
    //   326	54	2	localObject3	Object
    //   37	138	3	localArrayList	ArrayList
    //   318	1	3	localException1	java.lang.Exception
    //   322	4	3	localObject4	Object
    //   330	23	3	localException2	java.lang.Exception
    //   34	298	4	localMediaFileFilter	MediaFileFilter
    //   31	16	5	localObject5	Object
    //   7	360	6	localQQAlbumInfo	QQAlbumInfo
    //   44	10	7	localUri	android.net.Uri
    // Exception table:
    //   from	to	target	type
    //   69	75	314	finally
    //   82	91	314	finally
    //   91	103	314	finally
    //   107	148	314	finally
    //   152	207	314	finally
    //   207	301	314	finally
    //   69	75	318	java/lang/Exception
    //   82	91	318	java/lang/Exception
    //   91	103	318	java/lang/Exception
    //   107	148	318	java/lang/Exception
    //   152	207	318	java/lang/Exception
    //   207	301	318	java/lang/Exception
    //   41	46	322	finally
    //   49	69	322	finally
    //   336	342	322	finally
    //   344	356	322	finally
    //   41	46	330	java/lang/Exception
    //   49	69	330	java/lang/Exception
  }
  
  /* Error */
  QQAlbumInfo a(Context paramContext, int paramInt1, int paramInt2, MediaFileFilter paramMediaFileFilter)
  {
    // Byte code:
    //   0: iload_3
    //   1: ifle +265 -> 266
    //   4: new 225	com/tencent/mobileqq/data/QQAlbumInfo
    //   7: dup
    //   8: invokespecial 229	com/tencent/mobileqq/data/QQAlbumInfo:<init>	()V
    //   11: astore 10
    //   13: aload 10
    //   15: ldc_w 364
    //   18: putfield 234	com/tencent/mobileqq/data/QQAlbumInfo:id	Ljava/lang/String;
    //   21: aload 10
    //   23: getstatic 367	com/tencent/mobileqq/activity/photo/album/QAlbumCustomAlbumConstants:RECENT_ALBUM_NAME	Ljava/lang/String;
    //   26: putfield 242	com/tencent/mobileqq/data/QQAlbumInfo:name	Ljava/lang/String;
    //   29: aconst_null
    //   30: astore 9
    //   32: aconst_null
    //   33: astore 7
    //   35: aconst_null
    //   36: astore 8
    //   38: iload_3
    //   39: ifle +46 -> 85
    //   42: aload 9
    //   44: astore 5
    //   46: getstatic 251	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   49: invokevirtual 373	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   52: astore 6
    //   54: aload 9
    //   56: astore 5
    //   58: aload 6
    //   60: ldc_w 375
    //   63: iload_3
    //   64: invokestatic 379	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   67: invokevirtual 385	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   70: pop
    //   71: aload 9
    //   73: astore 5
    //   75: aload 6
    //   77: invokevirtual 389	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   80: astore 6
    //   82: goto +12 -> 94
    //   85: aload 9
    //   87: astore 5
    //   89: getstatic 251	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   92: astore 6
    //   94: aload 9
    //   96: astore 5
    //   98: aload_1
    //   99: invokevirtual 257	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   102: aload 6
    //   104: getstatic 149	com/tencent/mobileqq/wink/pick/album/adapter/WinkAlbumListAdapter:m	[Ljava/lang/String;
    //   107: ldc_w 259
    //   110: aconst_null
    //   111: ldc_w 261
    //   114: invokevirtual 267	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   117: astore_1
    //   118: aload 8
    //   120: astore 5
    //   122: aload 4
    //   124: ifnull +16 -> 140
    //   127: aload_0
    //   128: aload_1
    //   129: iload_3
    //   130: aload 4
    //   132: invokevirtual 276	com/tencent/mobileqq/wink/pick/album/adapter/WinkAlbumListAdapter:a	(Landroid/database/Cursor;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;)Ljava/util/List;
    //   135: astore 5
    //   137: goto +3 -> 140
    //   140: aload 5
    //   142: ifnull +47 -> 189
    //   145: aload 5
    //   147: invokeinterface 296 1 0
    //   152: ifne +37 -> 189
    //   155: aload 5
    //   157: invokeinterface 300 1 0
    //   162: istore_2
    //   163: aload 10
    //   165: iload_2
    //   166: putfield 245	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   169: iload_2
    //   170: ifle +19 -> 189
    //   173: aload 10
    //   175: aload 5
    //   177: iconst_0
    //   178: invokeinterface 223 2 0
    //   183: checkcast 302	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   186: putfield 306	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   189: aload_1
    //   190: ifnull +58 -> 248
    //   193: aload_1
    //   194: invokeinterface 348 1 0
    //   199: aload 10
    //   201: areturn
    //   202: astore 4
    //   204: goto +47 -> 251
    //   207: astore 4
    //   209: aload 7
    //   211: astore_1
    //   212: aload_1
    //   213: astore 5
    //   215: invokestatic 353	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   218: ifeq +20 -> 238
    //   221: aload_1
    //   222: astore 5
    //   224: ldc_w 355
    //   227: iconst_2
    //   228: aload 4
    //   230: invokevirtual 358	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   233: aload 4
    //   235: invokestatic 361	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   238: aload_1
    //   239: ifnull +9 -> 248
    //   242: aload_1
    //   243: invokeinterface 348 1 0
    //   248: aload 10
    //   250: areturn
    //   251: aload 5
    //   253: ifnull +10 -> 263
    //   256: aload 5
    //   258: invokeinterface 348 1 0
    //   263: aload 4
    //   265: athrow
    //   266: new 391	java/lang/IllegalArgumentException
    //   269: dup
    //   270: ldc_w 393
    //   273: invokespecial 396	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   276: athrow
    //   277: astore 4
    //   279: aload_1
    //   280: astore 5
    //   282: goto -31 -> 251
    //   285: astore 4
    //   287: goto -75 -> 212
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	290	0	this	WinkAlbumListAdapter
    //   0	290	1	paramContext	Context
    //   0	290	2	paramInt1	int
    //   0	290	3	paramInt2	int
    //   0	290	4	paramMediaFileFilter	MediaFileFilter
    //   44	237	5	localObject1	Object
    //   52	51	6	localObject2	Object
    //   33	177	7	localObject3	Object
    //   36	83	8	localObject4	Object
    //   30	65	9	localObject5	Object
    //   11	238	10	localQQAlbumInfo	QQAlbumInfo
    // Exception table:
    //   from	to	target	type
    //   46	54	202	finally
    //   58	71	202	finally
    //   75	82	202	finally
    //   89	94	202	finally
    //   98	118	202	finally
    //   215	221	202	finally
    //   224	238	202	finally
    //   46	54	207	java/lang/Exception
    //   58	71	207	java/lang/Exception
    //   75	82	207	java/lang/Exception
    //   89	94	207	java/lang/Exception
    //   98	118	207	java/lang/Exception
    //   127	137	277	finally
    //   145	169	277	finally
    //   173	189	277	finally
    //   127	137	285	java/lang/Exception
    //   145	169	285	java/lang/Exception
    //   173	189	285	java/lang/Exception
  }
  
  QQAlbumInfo a(Context paramContext, int paramInt1, int paramInt2, MediaFileFilter paramMediaFileFilter, int paramInt3, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    QQAlbumInfo localQQAlbumInfo = new QQAlbumInfo();
    localQQAlbumInfo.id = "$RecentAlbumId";
    localQQAlbumInfo.name = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
    paramArrayList = this.b.a(paramContext, paramInt1, paramInt2, paramMediaFileFilter, paramInt3, paramBoolean, paramArrayList);
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      localQQAlbumInfo.mCoverInfo = ((LocalMediaInfo)paramArrayList.get(0));
      localQQAlbumInfo.mMediaFileCount = paramArrayList.size();
    }
    if (localQQAlbumInfo.mMediaFileCount >= paramInt2) {
      return localQQAlbumInfo;
    }
    paramContext = QAlbumUtil.queryRecentVideos(paramContext, 0, paramInt2, paramMediaFileFilter, -1L);
    if (paramContext == null) {
      return localQQAlbumInfo;
    }
    if ((localQQAlbumInfo.mMediaFileCount == 0) && (paramContext.size() > 0)) {
      localQQAlbumInfo.mCoverInfo = ((LocalMediaInfo)paramContext.get(0));
    }
    if (localQQAlbumInfo.mMediaFileCount + paramContext.size() <= paramInt2)
    {
      localQQAlbumInfo.mMediaFileCount += paramContext.size();
      return localQQAlbumInfo;
    }
    localQQAlbumInfo.mMediaFileCount = paramInt2;
    return localQQAlbumInfo;
  }
  
  /* Error */
  public List<QQAlbumInfo> a(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 14
    //   3: aconst_null
    //   4: astore 15
    //   6: aconst_null
    //   7: astore 13
    //   9: iload_2
    //   10: ifge +11 -> 21
    //   13: getstatic 414	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   16: astore 12
    //   18: goto +539 -> 557
    //   21: getstatic 414	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   24: invokevirtual 373	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   27: astore 12
    //   29: aload 12
    //   31: ldc_w 375
    //   34: iload_2
    //   35: invokestatic 379	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   38: invokevirtual 385	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   41: pop
    //   42: aload 12
    //   44: invokevirtual 389	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   47: astore 12
    //   49: goto +508 -> 557
    //   52: aload_1
    //   53: invokevirtual 257	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   56: astore 16
    //   58: getstatic 60	com/tencent/mobileqq/wink/pick/album/adapter/WinkAlbumListAdapter:j	[Ljava/lang/String;
    //   61: astore 17
    //   63: aload 15
    //   65: astore_1
    //   66: aload 16
    //   68: aload 12
    //   70: aload 17
    //   72: aload_0
    //   73: getfield 175	com/tencent/mobileqq/wink/pick/album/adapter/WinkAlbumListAdapter:b	Lcom/tencent/mobileqq/wink/pick/album/logic/WinkAlbumListLogic$IalbumListAdapterCallBack;
    //   76: invokeinterface 416 1 0
    //   81: aconst_null
    //   82: ldc_w 418
    //   85: invokevirtual 267	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   88: astore 13
    //   90: aload 13
    //   92: ifnonnull +17 -> 109
    //   95: aload 13
    //   97: ifnull +10 -> 107
    //   100: aload 13
    //   102: invokeinterface 348 1 0
    //   107: aconst_null
    //   108: areturn
    //   109: new 420	java/util/LinkedList
    //   112: dup
    //   113: invokespecial 421	java/util/LinkedList:<init>	()V
    //   116: astore_1
    //   117: aload 13
    //   119: ldc 44
    //   121: invokeinterface 425 2 0
    //   126: istore_2
    //   127: aload 13
    //   129: ldc 46
    //   131: invokeinterface 425 2 0
    //   136: istore_3
    //   137: aload 13
    //   139: ldc 52
    //   141: invokeinterface 425 2 0
    //   146: istore 4
    //   148: aload 13
    //   150: ldc 50
    //   152: invokeinterface 425 2 0
    //   157: istore 5
    //   159: aload 13
    //   161: ldc 141
    //   163: invokeinterface 425 2 0
    //   168: istore 6
    //   170: aload 13
    //   172: ldc 54
    //   174: invokeinterface 425 2 0
    //   179: istore 7
    //   181: aload 13
    //   183: ldc 56
    //   185: invokeinterface 425 2 0
    //   190: istore 8
    //   192: aload 13
    //   194: ldc_w 427
    //   197: invokeinterface 425 2 0
    //   202: istore 9
    //   204: aload 13
    //   206: invokeinterface 430 1 0
    //   211: ifeq +204 -> 415
    //   214: aload 13
    //   216: iload_2
    //   217: invokeinterface 433 2 0
    //   222: astore 15
    //   224: aload 13
    //   226: iload_3
    //   227: invokeinterface 433 2 0
    //   232: astore 16
    //   234: aload 15
    //   236: invokestatic 438	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   239: ifne -35 -> 204
    //   242: aload 16
    //   244: invokestatic 438	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   247: ifeq +6 -> 253
    //   250: goto -46 -> 204
    //   253: aload 13
    //   255: iload 4
    //   257: invokeinterface 433 2 0
    //   262: astore 12
    //   264: aload 13
    //   266: iload 5
    //   268: invokeinterface 442 2 0
    //   273: lstore 10
    //   275: new 225	com/tencent/mobileqq/data/QQAlbumInfo
    //   278: dup
    //   279: invokespecial 229	com/tencent/mobileqq/data/QQAlbumInfo:<init>	()V
    //   282: astore 14
    //   284: aload 14
    //   286: aload 16
    //   288: putfield 242	com/tencent/mobileqq/data/QQAlbumInfo:name	Ljava/lang/String;
    //   291: aload 14
    //   293: aload 15
    //   295: putfield 234	com/tencent/mobileqq/data/QQAlbumInfo:id	Ljava/lang/String;
    //   298: aload 14
    //   300: lload 10
    //   302: putfield 445	com/tencent/mobileqq/data/QQAlbumInfo:coverDate	J
    //   305: aload 14
    //   307: getfield 306	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   310: astore 15
    //   312: aload 15
    //   314: aload 12
    //   316: putfield 334	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   319: aload 15
    //   321: aload 13
    //   323: iload 6
    //   325: invokeinterface 442 2 0
    //   330: putfield 321	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   333: aload 15
    //   335: lload 10
    //   337: putfield 315	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   340: aload 15
    //   342: aload 13
    //   344: iload 7
    //   346: invokeinterface 448 2 0
    //   351: putfield 450	com/tencent/mobileqq/activity/photo/LocalMediaInfo:orientation	I
    //   354: aload 15
    //   356: aload 13
    //   358: iload 8
    //   360: invokeinterface 433 2 0
    //   365: putfield 340	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   368: ldc 104
    //   370: aload 15
    //   372: getfield 340	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   375: invokevirtual 454	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   378: ifeq +11 -> 389
    //   381: aload 15
    //   383: ldc_w 456
    //   386: putfield 340	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   389: aload 14
    //   391: aload 13
    //   393: iload 9
    //   395: invokeinterface 448 2 0
    //   400: putfield 245	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   403: aload_1
    //   404: aload 14
    //   406: invokeinterface 459 2 0
    //   411: pop
    //   412: goto -208 -> 204
    //   415: aload_1
    //   416: astore 14
    //   418: aload 13
    //   420: ifnull +110 -> 530
    //   423: aload 13
    //   425: invokeinterface 348 1 0
    //   430: aload_1
    //   431: areturn
    //   432: astore 12
    //   434: goto +15 -> 449
    //   437: astore 12
    //   439: aload 13
    //   441: astore_1
    //   442: goto +96 -> 538
    //   445: astore 12
    //   447: aconst_null
    //   448: astore_1
    //   449: aload 12
    //   451: astore 14
    //   453: aload 13
    //   455: astore 12
    //   457: aload_1
    //   458: astore 13
    //   460: goto +26 -> 486
    //   463: astore_1
    //   464: goto +12 -> 476
    //   467: astore 12
    //   469: aload 13
    //   471: astore_1
    //   472: goto +66 -> 538
    //   475: astore_1
    //   476: aconst_null
    //   477: astore 13
    //   479: aload 14
    //   481: astore 12
    //   483: aload_1
    //   484: astore 14
    //   486: aload 12
    //   488: astore_1
    //   489: invokestatic 353	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   492: ifeq +18 -> 510
    //   495: aload 12
    //   497: astore_1
    //   498: ldc_w 461
    //   501: iconst_2
    //   502: ldc_w 463
    //   505: aload 14
    //   507: invokestatic 465	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   510: aload 13
    //   512: astore 14
    //   514: aload 12
    //   516: ifnull +14 -> 530
    //   519: aload 12
    //   521: invokeinterface 348 1 0
    //   526: aload 13
    //   528: astore 14
    //   530: aload 14
    //   532: areturn
    //   533: astore 12
    //   535: goto -63 -> 472
    //   538: aload_1
    //   539: ifnull +9 -> 548
    //   542: aload_1
    //   543: invokeinterface 348 1 0
    //   548: goto +6 -> 554
    //   551: aload 12
    //   553: athrow
    //   554: goto -3 -> 551
    //   557: goto -505 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	560	0	this	WinkAlbumListAdapter
    //   0	560	1	paramContext	Context
    //   0	560	2	paramInt	int
    //   136	91	3	i1	int
    //   146	110	4	i2	int
    //   157	110	5	i3	int
    //   168	156	6	i4	int
    //   179	166	7	i5	int
    //   190	169	8	i6	int
    //   202	192	9	i7	int
    //   273	63	10	l1	long
    //   16	299	12	localObject1	Object
    //   432	1	12	localException1	java.lang.Exception
    //   437	1	12	localObject2	Object
    //   445	5	12	localException2	java.lang.Exception
    //   455	1	12	localObject3	Object
    //   467	1	12	localObject4	Object
    //   481	39	12	localObject5	Object
    //   533	19	12	localObject6	Object
    //   7	520	13	localObject7	Object
    //   1	530	14	localObject8	Object
    //   4	378	15	localObject9	Object
    //   56	231	16	localObject10	Object
    //   61	10	17	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   117	204	432	java/lang/Exception
    //   204	250	432	java/lang/Exception
    //   253	389	432	java/lang/Exception
    //   389	412	432	java/lang/Exception
    //   109	117	437	finally
    //   117	204	437	finally
    //   204	250	437	finally
    //   253	389	437	finally
    //   389	412	437	finally
    //   109	117	445	java/lang/Exception
    //   66	90	463	java/lang/Exception
    //   13	18	467	finally
    //   21	49	467	finally
    //   52	63	467	finally
    //   13	18	475	java/lang/Exception
    //   21	49	475	java/lang/Exception
    //   52	63	475	java/lang/Exception
    //   66	90	533	finally
    //   489	495	533	finally
    //   498	510	533	finally
  }
  
  /* Error */
  public List<QQAlbumInfo> a(Context paramContext, int paramInt, MediaFileFilter paramMediaFileFilter)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 13
    //   3: aconst_null
    //   4: astore 14
    //   6: iload_2
    //   7: ifge +14 -> 21
    //   10: aload 14
    //   12: astore_3
    //   13: getstatic 251	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   16: astore 12
    //   18: goto +447 -> 465
    //   21: aload 14
    //   23: astore_3
    //   24: getstatic 251	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   27: invokevirtual 373	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   30: astore 12
    //   32: aload 14
    //   34: astore_3
    //   35: aload 12
    //   37: ldc_w 375
    //   40: iload_2
    //   41: invokestatic 379	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   44: invokevirtual 385	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   47: pop
    //   48: aload 14
    //   50: astore_3
    //   51: aload 12
    //   53: invokevirtual 389	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   56: astore 12
    //   58: goto +407 -> 465
    //   61: aload 14
    //   63: astore_3
    //   64: aload_1
    //   65: invokevirtual 257	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   68: aload 12
    //   70: getstatic 151	com/tencent/mobileqq/wink/pick/album/adapter/WinkAlbumListAdapter:n	[Ljava/lang/String;
    //   73: ldc_w 469
    //   76: aconst_null
    //   77: ldc_w 418
    //   80: invokevirtual 267	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   83: astore 12
    //   85: aload 12
    //   87: ifnonnull +17 -> 104
    //   90: aload 12
    //   92: ifnull +10 -> 102
    //   95: aload 12
    //   97: invokeinterface 348 1 0
    //   102: aconst_null
    //   103: areturn
    //   104: new 420	java/util/LinkedList
    //   107: dup
    //   108: invokespecial 421	java/util/LinkedList:<init>	()V
    //   111: astore_1
    //   112: aload 12
    //   114: ldc 44
    //   116: invokeinterface 425 2 0
    //   121: istore_2
    //   122: aload 12
    //   124: ldc 141
    //   126: invokeinterface 425 2 0
    //   131: istore 4
    //   133: aload 12
    //   135: ldc 46
    //   137: invokeinterface 425 2 0
    //   142: istore 5
    //   144: aload 12
    //   146: ldc 52
    //   148: invokeinterface 425 2 0
    //   153: istore 6
    //   155: aload 12
    //   157: ldc 50
    //   159: invokeinterface 425 2 0
    //   164: istore 7
    //   166: aload 12
    //   168: ldc 56
    //   170: invokeinterface 425 2 0
    //   175: istore 8
    //   177: aload 12
    //   179: ldc_w 427
    //   182: invokeinterface 425 2 0
    //   187: istore 9
    //   189: aload 12
    //   191: invokeinterface 430 1 0
    //   196: ifeq +159 -> 355
    //   199: aload 12
    //   201: iload_2
    //   202: invokeinterface 433 2 0
    //   207: astore 13
    //   209: aload 12
    //   211: iload 5
    //   213: invokeinterface 433 2 0
    //   218: astore 14
    //   220: aload 13
    //   222: invokestatic 438	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   225: ifne -36 -> 189
    //   228: aload 14
    //   230: invokestatic 438	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   233: ifeq +6 -> 239
    //   236: goto -47 -> 189
    //   239: aload 12
    //   241: iload 7
    //   243: invokeinterface 442 2 0
    //   248: lstore 10
    //   250: new 225	com/tencent/mobileqq/data/QQAlbumInfo
    //   253: dup
    //   254: invokespecial 229	com/tencent/mobileqq/data/QQAlbumInfo:<init>	()V
    //   257: astore_3
    //   258: aload_3
    //   259: aload 14
    //   261: putfield 242	com/tencent/mobileqq/data/QQAlbumInfo:name	Ljava/lang/String;
    //   264: aload_3
    //   265: aload 13
    //   267: putfield 234	com/tencent/mobileqq/data/QQAlbumInfo:id	Ljava/lang/String;
    //   270: aload_3
    //   271: lload 10
    //   273: putfield 445	com/tencent/mobileqq/data/QQAlbumInfo:coverDate	J
    //   276: aload_3
    //   277: getfield 306	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   280: astore 13
    //   282: aload 13
    //   284: aload 12
    //   286: iload 6
    //   288: invokeinterface 433 2 0
    //   293: putfield 334	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   296: aload 13
    //   298: aload 12
    //   300: iload 4
    //   302: invokeinterface 442 2 0
    //   307: putfield 321	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   310: aload 13
    //   312: lload 10
    //   314: putfield 315	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   317: aload 13
    //   319: aload 12
    //   321: iload 8
    //   323: invokeinterface 433 2 0
    //   328: putfield 340	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   331: aload_3
    //   332: aload 12
    //   334: iload 9
    //   336: invokeinterface 448 2 0
    //   341: putfield 245	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   344: aload_1
    //   345: aload_3
    //   346: invokeinterface 459 2 0
    //   351: pop
    //   352: goto -163 -> 189
    //   355: aload_1
    //   356: astore_3
    //   357: aload 12
    //   359: ifnull +86 -> 445
    //   362: aload 12
    //   364: invokeinterface 348 1 0
    //   369: aload_1
    //   370: areturn
    //   371: astore_3
    //   372: goto +13 -> 385
    //   375: astore_1
    //   376: aload 12
    //   378: astore_3
    //   379: goto +68 -> 447
    //   382: astore_3
    //   383: aconst_null
    //   384: astore_1
    //   385: aload_3
    //   386: astore 13
    //   388: goto +17 -> 405
    //   391: astore_1
    //   392: goto +55 -> 447
    //   395: astore_3
    //   396: aconst_null
    //   397: astore_1
    //   398: aload 13
    //   400: astore 12
    //   402: aload_3
    //   403: astore 13
    //   405: aload 12
    //   407: astore_3
    //   408: invokestatic 353	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   411: ifeq +18 -> 429
    //   414: aload 12
    //   416: astore_3
    //   417: ldc_w 461
    //   420: iconst_2
    //   421: ldc_w 471
    //   424: aload 13
    //   426: invokestatic 465	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   429: aload_1
    //   430: astore_3
    //   431: aload 12
    //   433: ifnull +12 -> 445
    //   436: aload 12
    //   438: invokeinterface 348 1 0
    //   443: aload_1
    //   444: astore_3
    //   445: aload_3
    //   446: areturn
    //   447: aload_3
    //   448: ifnull +9 -> 457
    //   451: aload_3
    //   452: invokeinterface 348 1 0
    //   457: goto +5 -> 462
    //   460: aload_1
    //   461: athrow
    //   462: goto -2 -> 460
    //   465: goto -404 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	468	0	this	WinkAlbumListAdapter
    //   0	468	1	paramContext	Context
    //   0	468	2	paramInt	int
    //   0	468	3	paramMediaFileFilter	MediaFileFilter
    //   131	170	4	i1	int
    //   142	70	5	i2	int
    //   153	134	6	i3	int
    //   164	78	7	i4	int
    //   175	147	8	i5	int
    //   187	148	9	i6	int
    //   248	65	10	l1	long
    //   16	421	12	localObject1	Object
    //   1	424	13	localObject2	Object
    //   4	256	14	str	String
    // Exception table:
    //   from	to	target	type
    //   112	189	371	java/lang/Exception
    //   189	236	371	java/lang/Exception
    //   239	352	371	java/lang/Exception
    //   104	112	375	finally
    //   112	189	375	finally
    //   189	236	375	finally
    //   239	352	375	finally
    //   104	112	382	java/lang/Exception
    //   13	18	391	finally
    //   24	32	391	finally
    //   35	48	391	finally
    //   51	58	391	finally
    //   64	85	391	finally
    //   408	414	391	finally
    //   417	429	391	finally
    //   13	18	395	java/lang/Exception
    //   24	32	395	java/lang/Exception
    //   35	48	395	java/lang/Exception
    //   51	58	395	java/lang/Exception
    //   64	85	395	java/lang/Exception
  }
  
  List<LocalMediaInfo> a(Cursor paramCursor, int paramInt, MediaFileFilter paramMediaFileFilter)
  {
    if (paramCursor.getCount() <= 0) {
      return null;
    }
    int i5 = paramCursor.getColumnIndexOrThrow("_id");
    int i2 = paramCursor.getColumnIndexOrThrow("_data");
    int i1 = paramCursor.getColumnIndexOrThrow("date_modified");
    int i6 = paramCursor.getColumnIndexOrThrow("duration");
    int i7 = paramCursor.getColumnIndexOrThrow("mime_type");
    int i8 = paramCursor.getColumnIndexOrThrow("_size");
    int i3 = 0;
    ArrayList localArrayList = new ArrayList();
    while (paramCursor.moveToNext())
    {
      String str = paramCursor.getString(i7);
      Object localObject;
      if ((paramMediaFileFilter != null) && (paramMediaFileFilter.filter(str)))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Filter mime type:");
          ((StringBuilder)localObject).append(str);
          QLog.i("AlbumListAdapter", 2, ((StringBuilder)localObject).toString());
        }
      }
      else
      {
        localObject = paramCursor.getString(i2);
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (new File((String)localObject).exists()))
        {
          long l1 = paramCursor.getLong(i1);
          LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
          localLocalMediaInfo._id = paramCursor.getLong(i5);
          localLocalMediaInfo.path = ((String)localObject);
          localLocalMediaInfo.mMimeType = str;
          localLocalMediaInfo.modifiedDate = l1;
          localLocalMediaInfo.mDuration = paramCursor.getLong(i6);
          localLocalMediaInfo.fileSize = paramCursor.getLong(i8);
          localArrayList.add(localLocalMediaInfo);
          int i4 = i3 + 1;
          i3 = i4;
          if (paramInt > 0)
          {
            i3 = i4;
            if (i4 >= paramInt) {
              return localArrayList;
            }
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.b.a(-1);
  }
  
  void a(QQAlbumInfo paramQQAlbumInfo)
  {
    List localList = this.g;
    if (localList == null) {
      return;
    }
    if (localList.isEmpty()) {
      this.g.add(paramQQAlbumInfo);
    } else if (((QQAlbumInfo)this.g.get(0)).id.equals("$RecentAlbumId")) {
      this.g.set(0, paramQQAlbumInfo);
    }
    b(paramQQAlbumInfo);
    notifyDataSetChanged();
  }
  
  void a(List<QQAlbumInfo> paramList)
  {
    this.g.clear();
    if (paramList != null) {
      this.g.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public QQAlbumInfo b(Context paramContext, int paramInt1, int paramInt2, MediaFileFilter paramMediaFileFilter, int paramInt3, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    if (paramMediaFileFilter == null) {
      return null;
    }
    if (paramMediaFileFilter.showImage()) {
      return a(paramContext, paramInt1, paramInt2, paramMediaFileFilter, paramInt3, paramBoolean, paramArrayList);
    }
    return a(paramContext, paramInt1, paramInt2, paramMediaFileFilter);
  }
  
  protected void b(QQAlbumInfo paramQQAlbumInfo) {}
  
  public void b(List<QQAlbumInfo> paramList)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      a(paramList);
      return;
    }
    this.i.post(new WinkAlbumListAdapter.1(this, paramList));
  }
  
  public void c(QQAlbumInfo paramQQAlbumInfo)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      a(paramQQAlbumInfo);
      return;
    }
    this.i.post(new WinkAlbumListAdapter.2(this, paramQQAlbumInfo));
  }
  
  void d(QQAlbumInfo paramQQAlbumInfo)
  {
    List localList = this.g;
    if (localList == null) {
      return;
    }
    if (localList.size() < 2)
    {
      this.g.add(paramQQAlbumInfo);
    }
    else
    {
      int i3 = 0;
      int i1 = 0;
      int i2;
      for (;;)
      {
        i2 = i3;
        if (i1 >= this.g.size()) {
          break;
        }
        if (((QQAlbumInfo)this.g.get(i1)).id.equals("$VideoAlbumId"))
        {
          i2 = 1;
          break;
        }
        i1 += 1;
      }
      if (i2 != 0)
      {
        if (paramQQAlbumInfo.mMediaFileCount > 0) {
          this.g.set(i1, paramQQAlbumInfo);
        } else {
          this.g.remove(i1);
        }
      }
      else if (paramQQAlbumInfo.mMediaFileCount > 0) {
        this.g.add(1, paramQQAlbumInfo);
      }
    }
    notifyDataSetChanged();
  }
  
  public void e(QQAlbumInfo paramQQAlbumInfo)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      d(paramQQAlbumInfo);
      return;
    }
    this.i.post(new WinkAlbumListAdapter.3(this, paramQQAlbumInfo));
  }
  
  public int getCount()
  {
    return this.g.size();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    return QAlbumUtil.getMediaType(((QQAlbumInfo)this.g.get(paramInt)).mCoverInfo);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = this.b.a(paramInt, paramView, paramViewGroup);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return QAlbumUtil.MEDIA_TYPE_MAPS.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.album.adapter.WinkAlbumListAdapter
 * JD-Core Version:    0.7.0.1
 */