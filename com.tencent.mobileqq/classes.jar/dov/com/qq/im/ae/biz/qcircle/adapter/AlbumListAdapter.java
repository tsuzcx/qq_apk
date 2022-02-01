package dov.com.qq.im.ae.biz.qcircle.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.album.logic.AEAlbumListLogic.IalbumListAdapterCallBack;
import dov.com.qq.im.ae.biz.qcircle.AECircleAlbumListFragment;
import dov.com.qq.im.ae.biz.qcircle.AECircleAlbumListLogic;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AlbumListAdapter
  extends BaseAdapter
{
  public static final ColorDrawable a;
  static final String jdField_a_of_type_JavaLangString;
  static final String[] jdField_a_of_type_ArrayOfJavaLangString;
  static String[] jdField_b_of_type_ArrayOfJavaLangString;
  static final String[] c;
  static final String[] d;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  AEAlbumListLogic.IalbumListAdapterCallBack jdField_a_of_type_DovComQqImAeAlbumLogicAEAlbumListLogic$IalbumListAdapterCallBack;
  List<QQAlbumInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  public boolean a;
  private final String jdField_b_of_type_JavaLangString = BaseApplication.getContext().getResources().getString(2131698001);
  
  static
  {
    jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(-2141891243);
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "bucket_id", "bucket_display_name", "MAX(_id) as _id", "date_modified", "_data", "orientation", "mime_type", "COUNT(_data) as count" };
    jdField_a_of_type_JavaLangString = "_size>0 and ( _size < " + QAlbumUtil.CONFIG_LIMIT_MAX_IMAGE_FILE_SIZE + " )  and (" + "width" + ">= 240 or " + "width" + " IS NULL) and (" + "height" + ">= 240 or " + "height" + " IS NULL )  and " + "height" + "  * 1.0 / " + "width" + ">= 0.45 and " + "height" + "  * 1.0 / " + "width" + "<= 2.2 and (" + "mime_type" + "='" + "image/jpeg" + "' or (" + "mime_type" + "='" + "*/*" + "' and " + "_display_name" + " LIKE'%.jpg%' )  or (" + "mime_type" + "='" + "*/*" + "' and " + "_display_name" + " LIKE'%.jpeg%' )  or (" + "mime_type" + "='" + "*/*" + "' and " + "_display_name" + " LIKE'%.bmp%' )  or (" + "mime_type" + "='" + "*/*" + "' and " + "_display_name" + " LIKE'%.png%' )  or " + "mime_type" + " LIKE'%" + "bmp" + "%' or " + "mime_type" + " LIKE'%" + "bitmap" + "%' or " + "mime_type" + "='" + "image/png" + "'";
    if (Build.VERSION.SDK_INT >= 16) {}
    for (jdField_b_of_type_ArrayOfJavaLangString = new String[] { "_id", "_data", "mime_type", "date_modified", "orientation", "_size", "width" };; jdField_b_of_type_ArrayOfJavaLangString = new String[] { "_id", "_data", "mime_type", "date_modified", "orientation", "_size" })
    {
      c = new String[] { "_id", "_data", "duration", "date_modified", "mime_type", "_size" };
      d = new String[] { "bucket_id", "bucket_display_name", "MAX(_id) as _id", "date_modified", "_data", "mime_type", "COUNT(_data) as count" };
      return;
    }
  }
  
  public AlbumListAdapter(AECircleAlbumListFragment paramAECircleAlbumListFragment)
  {
    this.jdField_a_of_type_DovComQqImAeAlbumLogicAEAlbumListLogic$IalbumListAdapterCallBack = paramAECircleAlbumListFragment.a.jdField_a_of_type_DovComQqImAeAlbumLogicAEAlbumListLogic$IalbumListAdapterCallBack;
  }
  
  public static boolean a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      paramString = paramString.toLowerCase();
      if (paramString.equalsIgnoreCase("camera")) {
        return true;
      }
    } while (!paramString.equalsIgnoreCase("100media"));
    return true;
  }
  
  public QQAlbumInfo a(int paramInt)
  {
    return (QQAlbumInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  /* Error */
  public QQAlbumInfo a(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 201	com/tencent/mobileqq/data/QQAlbumInfo
    //   5: dup
    //   6: invokespecial 205	com/tencent/mobileqq/data/QQAlbumInfo:<init>	()V
    //   9: astore 4
    //   11: aload 4
    //   13: ldc 207
    //   15: putfield 210	com/tencent/mobileqq/data/QQAlbumInfo:id	Ljava/lang/String;
    //   18: aload 4
    //   20: getstatic 215	com/tencent/mobileqq/activity/photo/album/QAlbumCustomAlbumConstants:VIDEO_ALBUM_NAME	Ljava/lang/String;
    //   23: putfield 218	com/tencent/mobileqq/data/QQAlbumInfo:name	Ljava/lang/String;
    //   26: aload 4
    //   28: iconst_0
    //   29: putfield 221	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   32: getstatic 227	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   35: astore_2
    //   36: aload_1
    //   37: invokevirtual 233	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   40: aload_2
    //   41: getstatic 137	dov/com/qq/im/ae/biz/qcircle/adapter/AlbumListAdapter:c	[Ljava/lang/String;
    //   44: ldc 235
    //   46: aconst_null
    //   47: ldc 237
    //   49: invokevirtual 243	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   52: astore_2
    //   53: aload_2
    //   54: astore_1
    //   55: iconst_2
    //   56: invokestatic 249	com/tencent/mobileqq/activity/photo/MediaFileFilter:getFilter	(I)Lcom/tencent/mobileqq/activity/photo/MediaFileFilter;
    //   59: astore 5
    //   61: aload 5
    //   63: ifnull +14 -> 77
    //   66: aload_2
    //   67: astore_1
    //   68: aload_0
    //   69: aload_2
    //   70: iconst_m1
    //   71: aload 5
    //   73: invokevirtual 252	dov/com/qq/im/ae/biz/qcircle/adapter/AlbumListAdapter:a	(Landroid/database/Cursor;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;)Ljava/util/List;
    //   76: astore_3
    //   77: aload_2
    //   78: astore_1
    //   79: invokestatic 255	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   82: invokestatic 261	com/tencent/mobileqq/activity/photo/MediaScanner:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/activity/photo/MediaScanner;
    //   85: iconst_0
    //   86: iconst_m1
    //   87: invokevirtual 265	com/tencent/mobileqq/activity/photo/MediaScanner:getMediaScannerInfos	(ZI)Ljava/util/ArrayList;
    //   90: astore 5
    //   92: aload_3
    //   93: ifnull +50 -> 143
    //   96: aload_2
    //   97: astore_1
    //   98: aload_3
    //   99: invokeinterface 269 1 0
    //   104: ifne +39 -> 143
    //   107: aload_2
    //   108: astore_1
    //   109: aload 4
    //   111: aload 4
    //   113: getfield 221	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   116: aload_3
    //   117: invokeinterface 273 1 0
    //   122: iadd
    //   123: putfield 221	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   126: aload_2
    //   127: astore_1
    //   128: aload 4
    //   130: aload_3
    //   131: iconst_0
    //   132: invokeinterface 199 2 0
    //   137: checkcast 275	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   140: putfield 279	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   143: aload 5
    //   145: ifnull +181 -> 326
    //   148: aload_2
    //   149: astore_1
    //   150: aload 5
    //   152: invokevirtual 280	java/util/ArrayList:isEmpty	()Z
    //   155: ifne +171 -> 326
    //   158: aload_2
    //   159: astore_1
    //   160: aload 4
    //   162: aload 4
    //   164: getfield 221	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   167: aload 5
    //   169: invokevirtual 281	java/util/ArrayList:size	()I
    //   172: iadd
    //   173: putfield 221	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   176: aload_2
    //   177: astore_1
    //   178: aload 5
    //   180: iconst_0
    //   181: invokevirtual 282	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   184: checkcast 284	com/tencent/mobileqq/activity/photo/MediaScannerInfo
    //   187: astore_3
    //   188: aload_2
    //   189: astore_1
    //   190: aload 4
    //   192: getfield 279	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   195: ifnull +21 -> 216
    //   198: aload_2
    //   199: astore_1
    //   200: aload 4
    //   202: getfield 279	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   205: getfield 288	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   208: aload_3
    //   209: getfield 289	com/tencent/mobileqq/activity/photo/MediaScannerInfo:modifiedDate	J
    //   212: lcmp
    //   213: ifge +113 -> 326
    //   216: aload_2
    //   217: astore_1
    //   218: aload 4
    //   220: new 275	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   223: dup
    //   224: invokespecial 290	com/tencent/mobileqq/activity/photo/LocalMediaInfo:<init>	()V
    //   227: putfield 279	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   230: aload_2
    //   231: astore_1
    //   232: aload 4
    //   234: getfield 279	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   237: aload_3
    //   238: getfield 292	com/tencent/mobileqq/activity/photo/MediaScannerInfo:id	I
    //   241: i2l
    //   242: putfield 294	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   245: aload_2
    //   246: astore_1
    //   247: aload 4
    //   249: getfield 279	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   252: aload_3
    //   253: getfield 296	com/tencent/mobileqq/activity/photo/MediaScannerInfo:duration	J
    //   256: putfield 299	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   259: aload_2
    //   260: astore_1
    //   261: aload 4
    //   263: getfield 279	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   266: aload_3
    //   267: getfield 302	com/tencent/mobileqq/activity/photo/MediaScannerInfo:fileSize	J
    //   270: putfield 303	com/tencent/mobileqq/activity/photo/LocalMediaInfo:fileSize	J
    //   273: aload_2
    //   274: astore_1
    //   275: aload 4
    //   277: getfield 279	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   280: aload_3
    //   281: getfield 306	com/tencent/mobileqq/activity/photo/MediaScannerInfo:path	Ljava/lang/String;
    //   284: putfield 307	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   287: aload_2
    //   288: astore_1
    //   289: aload 4
    //   291: getfield 279	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   294: aload_3
    //   295: getfield 289	com/tencent/mobileqq/activity/photo/MediaScannerInfo:modifiedDate	J
    //   298: putfield 288	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   301: aload_2
    //   302: astore_1
    //   303: aload 4
    //   305: getfield 279	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   308: aload_3
    //   309: getfield 310	com/tencent/mobileqq/activity/photo/MediaScannerInfo:mimeType	Ljava/lang/String;
    //   312: putfield 313	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   315: aload_2
    //   316: astore_1
    //   317: aload 4
    //   319: getfield 279	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   322: iconst_0
    //   323: putfield 316	com/tencent/mobileqq/activity/photo/LocalMediaInfo:isSystemMeidaStore	Z
    //   326: aload_2
    //   327: ifnull +9 -> 336
    //   330: aload_2
    //   331: invokeinterface 321 1 0
    //   336: aload 4
    //   338: areturn
    //   339: astore_3
    //   340: aconst_null
    //   341: astore_2
    //   342: aload_2
    //   343: astore_1
    //   344: invokestatic 326	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   347: ifeq +17 -> 364
    //   350: aload_2
    //   351: astore_1
    //   352: ldc_w 328
    //   355: iconst_2
    //   356: aload_3
    //   357: invokevirtual 331	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   360: aload_3
    //   361: invokestatic 335	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   364: aload_2
    //   365: ifnull -29 -> 336
    //   368: aload_2
    //   369: invokeinterface 321 1 0
    //   374: aload 4
    //   376: areturn
    //   377: astore_2
    //   378: aconst_null
    //   379: astore_1
    //   380: aload_1
    //   381: ifnull +9 -> 390
    //   384: aload_1
    //   385: invokeinterface 321 1 0
    //   390: aload_2
    //   391: athrow
    //   392: astore_2
    //   393: goto -13 -> 380
    //   396: astore_3
    //   397: goto -55 -> 342
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	400	0	this	AlbumListAdapter
    //   0	400	1	paramContext	Context
    //   35	334	2	localObject1	java.lang.Object
    //   377	14	2	localObject2	java.lang.Object
    //   392	1	2	localObject3	java.lang.Object
    //   1	308	3	localObject4	java.lang.Object
    //   339	22	3	localException1	java.lang.Exception
    //   396	1	3	localException2	java.lang.Exception
    //   9	366	4	localQQAlbumInfo	QQAlbumInfo
    //   59	120	5	localObject5	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   32	53	339	java/lang/Exception
    //   32	53	377	finally
    //   55	61	392	finally
    //   68	77	392	finally
    //   79	92	392	finally
    //   98	107	392	finally
    //   109	126	392	finally
    //   128	143	392	finally
    //   150	158	392	finally
    //   160	176	392	finally
    //   178	188	392	finally
    //   190	198	392	finally
    //   200	216	392	finally
    //   218	230	392	finally
    //   232	245	392	finally
    //   247	259	392	finally
    //   261	273	392	finally
    //   275	287	392	finally
    //   289	301	392	finally
    //   303	315	392	finally
    //   317	326	392	finally
    //   344	350	392	finally
    //   352	364	392	finally
    //   55	61	396	java/lang/Exception
    //   68	77	396	java/lang/Exception
    //   79	92	396	java/lang/Exception
    //   98	107	396	java/lang/Exception
    //   109	126	396	java/lang/Exception
    //   128	143	396	java/lang/Exception
    //   150	158	396	java/lang/Exception
    //   160	176	396	java/lang/Exception
    //   178	188	396	java/lang/Exception
    //   190	198	396	java/lang/Exception
    //   200	216	396	java/lang/Exception
    //   218	230	396	java/lang/Exception
    //   232	245	396	java/lang/Exception
    //   247	259	396	java/lang/Exception
    //   261	273	396	java/lang/Exception
    //   275	287	396	java/lang/Exception
    //   289	301	396	java/lang/Exception
    //   303	315	396	java/lang/Exception
    //   317	326	396	java/lang/Exception
  }
  
  /* Error */
  QQAlbumInfo a(Context paramContext, int paramInt1, int paramInt2, MediaFileFilter paramMediaFileFilter)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: iload_3
    //   7: ifgt +14 -> 21
    //   10: new 338	java/lang/IllegalArgumentException
    //   13: dup
    //   14: ldc_w 340
    //   17: invokespecial 343	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   20: athrow
    //   21: new 201	com/tencent/mobileqq/data/QQAlbumInfo
    //   24: dup
    //   25: invokespecial 205	com/tencent/mobileqq/data/QQAlbumInfo:<init>	()V
    //   28: astore 8
    //   30: aload 8
    //   32: ldc_w 345
    //   35: putfield 210	com/tencent/mobileqq/data/QQAlbumInfo:id	Ljava/lang/String;
    //   38: aload 8
    //   40: aload_0
    //   41: getfield 171	dov/com/qq/im/ae/biz/qcircle/adapter/AlbumListAdapter:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   44: putfield 218	com/tencent/mobileqq/data/QQAlbumInfo:name	Ljava/lang/String;
    //   47: iload_3
    //   48: ifle +141 -> 189
    //   51: getstatic 227	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   54: invokevirtual 351	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   57: astore 5
    //   59: aload 5
    //   61: ldc_w 353
    //   64: iload_3
    //   65: invokestatic 356	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   68: invokevirtual 362	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   71: pop
    //   72: aload 5
    //   74: invokevirtual 366	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   77: astore 5
    //   79: aload_1
    //   80: invokevirtual 233	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   83: aload 5
    //   85: getstatic 137	dov/com/qq/im/ae/biz/qcircle/adapter/AlbumListAdapter:c	[Ljava/lang/String;
    //   88: ldc 235
    //   90: aconst_null
    //   91: ldc 237
    //   93: invokevirtual 243	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   96: astore_1
    //   97: aload 4
    //   99: ifnull +16 -> 115
    //   102: aload_1
    //   103: astore 5
    //   105: aload_0
    //   106: aload_1
    //   107: iload_3
    //   108: aload 4
    //   110: invokevirtual 252	dov/com/qq/im/ae/biz/qcircle/adapter/AlbumListAdapter:a	(Landroid/database/Cursor;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;)Ljava/util/List;
    //   113: astore 6
    //   115: aload 6
    //   117: ifnull +59 -> 176
    //   120: aload_1
    //   121: astore 5
    //   123: aload 6
    //   125: invokeinterface 269 1 0
    //   130: ifne +46 -> 176
    //   133: aload_1
    //   134: astore 5
    //   136: aload 6
    //   138: invokeinterface 273 1 0
    //   143: istore_2
    //   144: aload_1
    //   145: astore 5
    //   147: aload 8
    //   149: iload_2
    //   150: putfield 221	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   153: iload_2
    //   154: ifle +22 -> 176
    //   157: aload_1
    //   158: astore 5
    //   160: aload 8
    //   162: aload 6
    //   164: iconst_0
    //   165: invokeinterface 199 2 0
    //   170: checkcast 275	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   173: putfield 279	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   176: aload_1
    //   177: ifnull +9 -> 186
    //   180: aload_1
    //   181: invokeinterface 321 1 0
    //   186: aload 8
    //   188: areturn
    //   189: getstatic 227	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   192: astore 5
    //   194: goto -115 -> 79
    //   197: astore 4
    //   199: aconst_null
    //   200: astore_1
    //   201: aload_1
    //   202: astore 5
    //   204: invokestatic 326	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   207: ifeq +20 -> 227
    //   210: aload_1
    //   211: astore 5
    //   213: ldc_w 328
    //   216: iconst_2
    //   217: aload 4
    //   219: invokevirtual 331	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   222: aload 4
    //   224: invokestatic 335	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   227: aload_1
    //   228: ifnull -42 -> 186
    //   231: aload_1
    //   232: invokeinterface 321 1 0
    //   237: aload 8
    //   239: areturn
    //   240: astore_1
    //   241: aload 7
    //   243: astore 4
    //   245: aload 4
    //   247: ifnull +10 -> 257
    //   250: aload 4
    //   252: invokeinterface 321 1 0
    //   257: aload_1
    //   258: athrow
    //   259: astore_1
    //   260: aload 5
    //   262: astore 4
    //   264: goto -19 -> 245
    //   267: astore 4
    //   269: goto -68 -> 201
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	272	0	this	AlbumListAdapter
    //   0	272	1	paramContext	Context
    //   0	272	2	paramInt1	int
    //   0	272	3	paramInt2	int
    //   0	272	4	paramMediaFileFilter	MediaFileFilter
    //   57	204	5	localObject1	java.lang.Object
    //   4	159	6	localList	List
    //   1	241	7	localObject2	java.lang.Object
    //   28	210	8	localQQAlbumInfo	QQAlbumInfo
    // Exception table:
    //   from	to	target	type
    //   51	79	197	java/lang/Exception
    //   79	97	197	java/lang/Exception
    //   189	194	197	java/lang/Exception
    //   51	79	240	finally
    //   79	97	240	finally
    //   189	194	240	finally
    //   105	115	259	finally
    //   123	133	259	finally
    //   136	144	259	finally
    //   147	153	259	finally
    //   160	176	259	finally
    //   204	210	259	finally
    //   213	227	259	finally
    //   105	115	267	java/lang/Exception
    //   123	133	267	java/lang/Exception
    //   136	144	267	java/lang/Exception
    //   147	153	267	java/lang/Exception
    //   160	176	267	java/lang/Exception
  }
  
  QQAlbumInfo a(Context paramContext, int paramInt1, int paramInt2, MediaFileFilter paramMediaFileFilter, int paramInt3, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    QQAlbumInfo localQQAlbumInfo = new QQAlbumInfo();
    localQQAlbumInfo.id = "$RecentAlbumId";
    localQQAlbumInfo.name = this.jdField_b_of_type_JavaLangString;
    paramArrayList = this.jdField_a_of_type_DovComQqImAeAlbumLogicAEAlbumListLogic$IalbumListAdapterCallBack.a(paramContext, paramInt1, paramInt2, paramMediaFileFilter, paramInt3, paramBoolean, paramArrayList);
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
    if (localQQAlbumInfo.mMediaFileCount + paramContext.size() <= paramInt2) {}
    for (localQQAlbumInfo.mMediaFileCount += paramContext.size();; localQQAlbumInfo.mMediaFileCount = paramInt2) {
      return localQQAlbumInfo;
    }
  }
  
  /* Error */
  public List<QQAlbumInfo> a(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: iload_2
    //   1: ifge +63 -> 64
    //   4: getstatic 384	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   7: astore 12
    //   9: aload_1
    //   10: invokevirtual 233	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   13: aload 12
    //   15: getstatic 47	dov/com/qq/im/ae/biz/qcircle/adapter/AlbumListAdapter:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   18: aload_0
    //   19: getfield 181	dov/com/qq/im/ae/biz/qcircle/adapter/AlbumListAdapter:jdField_a_of_type_DovComQqImAeAlbumLogicAEAlbumListLogic$IalbumListAdapterCallBack	Ldov/com/qq/im/ae/album/logic/AEAlbumListLogic$IalbumListAdapterCallBack;
    //   22: invokeinterface 386 1 0
    //   27: aconst_null
    //   28: ldc_w 388
    //   31: invokevirtual 243	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   34: astore 12
    //   36: aload 12
    //   38: ifnonnull +57 -> 95
    //   41: aconst_null
    //   42: astore_1
    //   43: aload_1
    //   44: astore 13
    //   46: aload 12
    //   48: ifnull +13 -> 61
    //   51: aload 12
    //   53: invokeinterface 321 1 0
    //   58: aload_1
    //   59: astore 13
    //   61: aload 13
    //   63: areturn
    //   64: getstatic 384	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   67: invokevirtual 351	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   70: astore 12
    //   72: aload 12
    //   74: ldc_w 353
    //   77: iload_2
    //   78: invokestatic 356	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   81: invokevirtual 362	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   84: pop
    //   85: aload 12
    //   87: invokevirtual 366	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   90: astore 12
    //   92: goto -83 -> 9
    //   95: aload 12
    //   97: astore 13
    //   99: new 390	java/util/LinkedList
    //   102: dup
    //   103: invokespecial 391	java/util/LinkedList:<init>	()V
    //   106: astore_1
    //   107: aload 12
    //   109: astore 13
    //   111: aload 12
    //   113: ldc 31
    //   115: invokeinterface 395 2 0
    //   120: istore_2
    //   121: aload 12
    //   123: astore 13
    //   125: aload 12
    //   127: ldc 33
    //   129: invokeinterface 395 2 0
    //   134: istore_3
    //   135: aload 12
    //   137: astore 13
    //   139: aload 12
    //   141: ldc 39
    //   143: invokeinterface 395 2 0
    //   148: istore 4
    //   150: aload 12
    //   152: astore 13
    //   154: aload 12
    //   156: ldc 37
    //   158: invokeinterface 395 2 0
    //   163: istore 5
    //   165: aload 12
    //   167: astore 13
    //   169: aload 12
    //   171: ldc 129
    //   173: invokeinterface 395 2 0
    //   178: istore 6
    //   180: aload 12
    //   182: astore 13
    //   184: aload 12
    //   186: ldc 41
    //   188: invokeinterface 395 2 0
    //   193: istore 7
    //   195: aload 12
    //   197: astore 13
    //   199: aload 12
    //   201: ldc 43
    //   203: invokeinterface 395 2 0
    //   208: istore 8
    //   210: aload 12
    //   212: astore 13
    //   214: aload 12
    //   216: ldc_w 397
    //   219: invokeinterface 395 2 0
    //   224: istore 9
    //   226: aload 12
    //   228: astore 13
    //   230: aload 12
    //   232: invokeinterface 400 1 0
    //   237: ifeq +326 -> 563
    //   240: aload 12
    //   242: astore 13
    //   244: aload 12
    //   246: iload_2
    //   247: invokeinterface 401 2 0
    //   252: astore 16
    //   254: aload 12
    //   256: astore 13
    //   258: aload 12
    //   260: iload_3
    //   261: invokeinterface 401 2 0
    //   266: astore 17
    //   268: aload 12
    //   270: astore 13
    //   272: aload 16
    //   274: invokestatic 406	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   277: ifne -51 -> 226
    //   280: aload 12
    //   282: astore 13
    //   284: aload 17
    //   286: invokestatic 406	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   289: ifne -63 -> 226
    //   292: aload 12
    //   294: astore 13
    //   296: aload 12
    //   298: iload 4
    //   300: invokeinterface 401 2 0
    //   305: astore 14
    //   307: aload 12
    //   309: astore 13
    //   311: aload 12
    //   313: iload 5
    //   315: invokeinterface 410 2 0
    //   320: lstore 10
    //   322: aload 12
    //   324: astore 13
    //   326: new 201	com/tencent/mobileqq/data/QQAlbumInfo
    //   329: dup
    //   330: invokespecial 205	com/tencent/mobileqq/data/QQAlbumInfo:<init>	()V
    //   333: astore 15
    //   335: aload 12
    //   337: astore 13
    //   339: aload 15
    //   341: aload 17
    //   343: putfield 218	com/tencent/mobileqq/data/QQAlbumInfo:name	Ljava/lang/String;
    //   346: aload 12
    //   348: astore 13
    //   350: aload 15
    //   352: aload 16
    //   354: putfield 210	com/tencent/mobileqq/data/QQAlbumInfo:id	Ljava/lang/String;
    //   357: aload 12
    //   359: astore 13
    //   361: aload 15
    //   363: lload 10
    //   365: putfield 413	com/tencent/mobileqq/data/QQAlbumInfo:coverDate	J
    //   368: aload 12
    //   370: astore 13
    //   372: aload 15
    //   374: getfield 279	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   377: astore 16
    //   379: aload 12
    //   381: astore 13
    //   383: aload 16
    //   385: aload 14
    //   387: putfield 307	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   390: aload 12
    //   392: astore 13
    //   394: aload 16
    //   396: aload 12
    //   398: iload 6
    //   400: invokeinterface 410 2 0
    //   405: putfield 294	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   408: aload 12
    //   410: astore 13
    //   412: aload 16
    //   414: lload 10
    //   416: putfield 288	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   419: aload 12
    //   421: astore 13
    //   423: aload 16
    //   425: aload 12
    //   427: iload 7
    //   429: invokeinterface 417 2 0
    //   434: putfield 419	com/tencent/mobileqq/activity/photo/LocalMediaInfo:orientation	I
    //   437: aload 12
    //   439: astore 13
    //   441: aload 16
    //   443: aload 12
    //   445: iload 8
    //   447: invokeinterface 401 2 0
    //   452: putfield 313	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   455: aload 12
    //   457: astore 13
    //   459: ldc 92
    //   461: aload 16
    //   463: getfield 313	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   466: invokevirtual 423	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   469: ifeq +15 -> 484
    //   472: aload 12
    //   474: astore 13
    //   476: aload 16
    //   478: ldc_w 425
    //   481: putfield 313	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   484: aload 12
    //   486: astore 13
    //   488: aload 15
    //   490: aload 12
    //   492: iload 9
    //   494: invokeinterface 417 2 0
    //   499: putfield 221	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   502: aload 12
    //   504: astore 13
    //   506: aload_1
    //   507: aload 15
    //   509: invokeinterface 428 2 0
    //   514: pop
    //   515: goto -289 -> 226
    //   518: astore 14
    //   520: aload 12
    //   522: astore 13
    //   524: invokestatic 326	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   527: ifeq +19 -> 546
    //   530: aload 12
    //   532: astore 13
    //   534: ldc_w 430
    //   537: iconst_2
    //   538: ldc_w 432
    //   541: aload 14
    //   543: invokestatic 434	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   546: aload_1
    //   547: astore 13
    //   549: aload 12
    //   551: ifnull -490 -> 61
    //   554: aload 12
    //   556: invokeinterface 321 1 0
    //   561: aload_1
    //   562: areturn
    //   563: aload_1
    //   564: astore 13
    //   566: aload 12
    //   568: ifnull -507 -> 61
    //   571: aload 12
    //   573: invokeinterface 321 1 0
    //   578: aload_1
    //   579: areturn
    //   580: astore_1
    //   581: aconst_null
    //   582: astore 13
    //   584: aload 13
    //   586: ifnull +10 -> 596
    //   589: aload 13
    //   591: invokeinterface 321 1 0
    //   596: aload_1
    //   597: athrow
    //   598: astore_1
    //   599: goto -15 -> 584
    //   602: astore 14
    //   604: aconst_null
    //   605: astore 12
    //   607: aconst_null
    //   608: astore_1
    //   609: goto -89 -> 520
    //   612: astore 14
    //   614: aconst_null
    //   615: astore_1
    //   616: goto -96 -> 520
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	619	0	this	AlbumListAdapter
    //   0	619	1	paramContext	Context
    //   0	619	2	paramInt	int
    //   134	127	3	i	int
    //   148	151	4	j	int
    //   163	151	5	k	int
    //   178	221	6	m	int
    //   193	235	7	n	int
    //   208	238	8	i1	int
    //   224	269	9	i2	int
    //   320	95	10	l	long
    //   7	599	12	localObject1	java.lang.Object
    //   44	546	13	localObject2	java.lang.Object
    //   305	81	14	str1	String
    //   518	24	14	localException1	java.lang.Exception
    //   602	1	14	localException2	java.lang.Exception
    //   612	1	14	localException3	java.lang.Exception
    //   333	175	15	localQQAlbumInfo	QQAlbumInfo
    //   252	225	16	localObject3	java.lang.Object
    //   266	76	17	str2	String
    // Exception table:
    //   from	to	target	type
    //   111	121	518	java/lang/Exception
    //   125	135	518	java/lang/Exception
    //   139	150	518	java/lang/Exception
    //   154	165	518	java/lang/Exception
    //   169	180	518	java/lang/Exception
    //   184	195	518	java/lang/Exception
    //   199	210	518	java/lang/Exception
    //   214	226	518	java/lang/Exception
    //   230	240	518	java/lang/Exception
    //   244	254	518	java/lang/Exception
    //   258	268	518	java/lang/Exception
    //   272	280	518	java/lang/Exception
    //   284	292	518	java/lang/Exception
    //   296	307	518	java/lang/Exception
    //   311	322	518	java/lang/Exception
    //   326	335	518	java/lang/Exception
    //   339	346	518	java/lang/Exception
    //   350	357	518	java/lang/Exception
    //   361	368	518	java/lang/Exception
    //   372	379	518	java/lang/Exception
    //   383	390	518	java/lang/Exception
    //   394	408	518	java/lang/Exception
    //   412	419	518	java/lang/Exception
    //   423	437	518	java/lang/Exception
    //   441	455	518	java/lang/Exception
    //   459	472	518	java/lang/Exception
    //   476	484	518	java/lang/Exception
    //   488	502	518	java/lang/Exception
    //   506	515	518	java/lang/Exception
    //   4	9	580	finally
    //   9	36	580	finally
    //   64	92	580	finally
    //   99	107	598	finally
    //   111	121	598	finally
    //   125	135	598	finally
    //   139	150	598	finally
    //   154	165	598	finally
    //   169	180	598	finally
    //   184	195	598	finally
    //   199	210	598	finally
    //   214	226	598	finally
    //   230	240	598	finally
    //   244	254	598	finally
    //   258	268	598	finally
    //   272	280	598	finally
    //   284	292	598	finally
    //   296	307	598	finally
    //   311	322	598	finally
    //   326	335	598	finally
    //   339	346	598	finally
    //   350	357	598	finally
    //   361	368	598	finally
    //   372	379	598	finally
    //   383	390	598	finally
    //   394	408	598	finally
    //   412	419	598	finally
    //   423	437	598	finally
    //   441	455	598	finally
    //   459	472	598	finally
    //   476	484	598	finally
    //   488	502	598	finally
    //   506	515	598	finally
    //   524	530	598	finally
    //   534	546	598	finally
    //   4	9	602	java/lang/Exception
    //   9	36	602	java/lang/Exception
    //   64	92	602	java/lang/Exception
    //   99	107	612	java/lang/Exception
  }
  
  /* Error */
  public List<QQAlbumInfo> a(Context paramContext, int paramInt, MediaFileFilter paramMediaFileFilter)
  {
    // Byte code:
    //   0: iload_2
    //   1: ifge +51 -> 52
    //   4: getstatic 227	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   7: astore_3
    //   8: aload_1
    //   9: invokevirtual 233	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   12: aload_3
    //   13: getstatic 139	dov/com/qq/im/ae/biz/qcircle/adapter/AlbumListAdapter:d	[Ljava/lang/String;
    //   16: ldc_w 438
    //   19: aconst_null
    //   20: ldc_w 388
    //   23: invokevirtual 243	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   26: astore_3
    //   27: aload_3
    //   28: ifnonnull +51 -> 79
    //   31: aconst_null
    //   32: astore_1
    //   33: aload_1
    //   34: astore 12
    //   36: aload_3
    //   37: ifnull +12 -> 49
    //   40: aload_3
    //   41: invokeinterface 321 1 0
    //   46: aload_1
    //   47: astore 12
    //   49: aload 12
    //   51: areturn
    //   52: getstatic 227	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   55: invokevirtual 351	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   58: astore_3
    //   59: aload_3
    //   60: ldc_w 353
    //   63: iload_2
    //   64: invokestatic 356	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   67: invokevirtual 362	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   70: pop
    //   71: aload_3
    //   72: invokevirtual 366	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   75: astore_3
    //   76: goto -68 -> 8
    //   79: aload_3
    //   80: astore 12
    //   82: new 390	java/util/LinkedList
    //   85: dup
    //   86: invokespecial 391	java/util/LinkedList:<init>	()V
    //   89: astore_1
    //   90: aload_3
    //   91: astore 12
    //   93: aload_3
    //   94: ldc 31
    //   96: invokeinterface 395 2 0
    //   101: istore_2
    //   102: aload_3
    //   103: astore 12
    //   105: aload_3
    //   106: ldc 129
    //   108: invokeinterface 395 2 0
    //   113: istore 4
    //   115: aload_3
    //   116: astore 12
    //   118: aload_3
    //   119: ldc 33
    //   121: invokeinterface 395 2 0
    //   126: istore 5
    //   128: aload_3
    //   129: astore 12
    //   131: aload_3
    //   132: ldc 39
    //   134: invokeinterface 395 2 0
    //   139: istore 6
    //   141: aload_3
    //   142: astore 12
    //   144: aload_3
    //   145: ldc 37
    //   147: invokeinterface 395 2 0
    //   152: istore 7
    //   154: aload_3
    //   155: astore 12
    //   157: aload_3
    //   158: ldc 43
    //   160: invokeinterface 395 2 0
    //   165: istore 8
    //   167: aload_3
    //   168: astore 12
    //   170: aload_3
    //   171: ldc_w 397
    //   174: invokeinterface 395 2 0
    //   179: istore 9
    //   181: aload_3
    //   182: astore 12
    //   184: aload_3
    //   185: invokeinterface 400 1 0
    //   190: ifeq +245 -> 435
    //   193: aload_3
    //   194: astore 12
    //   196: aload_3
    //   197: iload_2
    //   198: invokeinterface 401 2 0
    //   203: astore 14
    //   205: aload_3
    //   206: astore 12
    //   208: aload_3
    //   209: iload 5
    //   211: invokeinterface 401 2 0
    //   216: astore 15
    //   218: aload_3
    //   219: astore 12
    //   221: aload 14
    //   223: invokestatic 406	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   226: ifne -45 -> 181
    //   229: aload_3
    //   230: astore 12
    //   232: aload 15
    //   234: invokestatic 406	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   237: ifne -56 -> 181
    //   240: aload_3
    //   241: astore 12
    //   243: aload_3
    //   244: iload 7
    //   246: invokeinterface 410 2 0
    //   251: lstore 10
    //   253: aload_3
    //   254: astore 12
    //   256: new 201	com/tencent/mobileqq/data/QQAlbumInfo
    //   259: dup
    //   260: invokespecial 205	com/tencent/mobileqq/data/QQAlbumInfo:<init>	()V
    //   263: astore 13
    //   265: aload_3
    //   266: astore 12
    //   268: aload 13
    //   270: aload 15
    //   272: putfield 218	com/tencent/mobileqq/data/QQAlbumInfo:name	Ljava/lang/String;
    //   275: aload_3
    //   276: astore 12
    //   278: aload 13
    //   280: aload 14
    //   282: putfield 210	com/tencent/mobileqq/data/QQAlbumInfo:id	Ljava/lang/String;
    //   285: aload_3
    //   286: astore 12
    //   288: aload 13
    //   290: lload 10
    //   292: putfield 413	com/tencent/mobileqq/data/QQAlbumInfo:coverDate	J
    //   295: aload_3
    //   296: astore 12
    //   298: aload 13
    //   300: getfield 279	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   303: astore 14
    //   305: aload_3
    //   306: astore 12
    //   308: aload 14
    //   310: aload_3
    //   311: iload 6
    //   313: invokeinterface 401 2 0
    //   318: putfield 307	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   321: aload_3
    //   322: astore 12
    //   324: aload 14
    //   326: aload_3
    //   327: iload 4
    //   329: invokeinterface 410 2 0
    //   334: putfield 294	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   337: aload_3
    //   338: astore 12
    //   340: aload 14
    //   342: lload 10
    //   344: putfield 288	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   347: aload_3
    //   348: astore 12
    //   350: aload 14
    //   352: aload_3
    //   353: iload 8
    //   355: invokeinterface 401 2 0
    //   360: putfield 313	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   363: aload_3
    //   364: astore 12
    //   366: aload 13
    //   368: aload_3
    //   369: iload 9
    //   371: invokeinterface 417 2 0
    //   376: putfield 221	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   379: aload_3
    //   380: astore 12
    //   382: aload_1
    //   383: aload 13
    //   385: invokeinterface 428 2 0
    //   390: pop
    //   391: goto -210 -> 181
    //   394: astore 13
    //   396: aload_3
    //   397: astore 12
    //   399: invokestatic 326	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   402: ifeq +18 -> 420
    //   405: aload_3
    //   406: astore 12
    //   408: ldc_w 430
    //   411: iconst_2
    //   412: ldc_w 440
    //   415: aload 13
    //   417: invokestatic 434	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   420: aload_1
    //   421: astore 12
    //   423: aload_3
    //   424: ifnull -375 -> 49
    //   427: aload_3
    //   428: invokeinterface 321 1 0
    //   433: aload_1
    //   434: areturn
    //   435: aload_1
    //   436: astore 12
    //   438: aload_3
    //   439: ifnull -390 -> 49
    //   442: aload_3
    //   443: invokeinterface 321 1 0
    //   448: aload_1
    //   449: areturn
    //   450: astore_1
    //   451: aconst_null
    //   452: astore 12
    //   454: aload 12
    //   456: ifnull +10 -> 466
    //   459: aload 12
    //   461: invokeinterface 321 1 0
    //   466: aload_1
    //   467: athrow
    //   468: astore_1
    //   469: goto -15 -> 454
    //   472: astore 13
    //   474: aconst_null
    //   475: astore_3
    //   476: aconst_null
    //   477: astore_1
    //   478: goto -82 -> 396
    //   481: astore 13
    //   483: aconst_null
    //   484: astore_1
    //   485: goto -89 -> 396
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	488	0	this	AlbumListAdapter
    //   0	488	1	paramContext	Context
    //   0	488	2	paramInt	int
    //   0	488	3	paramMediaFileFilter	MediaFileFilter
    //   113	215	4	i	int
    //   126	84	5	j	int
    //   139	173	6	k	int
    //   152	93	7	m	int
    //   165	189	8	n	int
    //   179	191	9	i1	int
    //   251	92	10	l	long
    //   34	426	12	localObject1	java.lang.Object
    //   263	121	13	localQQAlbumInfo	QQAlbumInfo
    //   394	22	13	localException1	java.lang.Exception
    //   472	1	13	localException2	java.lang.Exception
    //   481	1	13	localException3	java.lang.Exception
    //   203	148	14	localObject2	java.lang.Object
    //   216	55	15	str	String
    // Exception table:
    //   from	to	target	type
    //   93	102	394	java/lang/Exception
    //   105	115	394	java/lang/Exception
    //   118	128	394	java/lang/Exception
    //   131	141	394	java/lang/Exception
    //   144	154	394	java/lang/Exception
    //   157	167	394	java/lang/Exception
    //   170	181	394	java/lang/Exception
    //   184	193	394	java/lang/Exception
    //   196	205	394	java/lang/Exception
    //   208	218	394	java/lang/Exception
    //   221	229	394	java/lang/Exception
    //   232	240	394	java/lang/Exception
    //   243	253	394	java/lang/Exception
    //   256	265	394	java/lang/Exception
    //   268	275	394	java/lang/Exception
    //   278	285	394	java/lang/Exception
    //   288	295	394	java/lang/Exception
    //   298	305	394	java/lang/Exception
    //   308	321	394	java/lang/Exception
    //   324	337	394	java/lang/Exception
    //   340	347	394	java/lang/Exception
    //   350	363	394	java/lang/Exception
    //   366	379	394	java/lang/Exception
    //   382	391	394	java/lang/Exception
    //   4	8	450	finally
    //   8	27	450	finally
    //   52	76	450	finally
    //   82	90	468	finally
    //   93	102	468	finally
    //   105	115	468	finally
    //   118	128	468	finally
    //   131	141	468	finally
    //   144	154	468	finally
    //   157	167	468	finally
    //   170	181	468	finally
    //   184	193	468	finally
    //   196	205	468	finally
    //   208	218	468	finally
    //   221	229	468	finally
    //   232	240	468	finally
    //   243	253	468	finally
    //   256	265	468	finally
    //   268	275	468	finally
    //   278	285	468	finally
    //   288	295	468	finally
    //   298	305	468	finally
    //   308	321	468	finally
    //   324	337	468	finally
    //   340	347	468	finally
    //   350	363	468	finally
    //   366	379	468	finally
    //   382	391	468	finally
    //   399	405	468	finally
    //   408	420	468	finally
    //   4	8	472	java/lang/Exception
    //   8	27	472	java/lang/Exception
    //   52	76	472	java/lang/Exception
    //   82	90	481	java/lang/Exception
  }
  
  List<LocalMediaInfo> a(Cursor paramCursor, int paramInt, MediaFileFilter paramMediaFileFilter)
  {
    if (paramCursor.getCount() <= 0) {
      return null;
    }
    int k = paramCursor.getColumnIndexOrThrow("_id");
    int m = paramCursor.getColumnIndexOrThrow("_data");
    int n = paramCursor.getColumnIndexOrThrow("date_modified");
    int i1 = paramCursor.getColumnIndexOrThrow("duration");
    int i2 = paramCursor.getColumnIndexOrThrow("mime_type");
    int i3 = paramCursor.getColumnIndexOrThrow("_size");
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    int j;
    do
    {
      do
      {
        String str1;
        String str2;
        do
        {
          for (;;)
          {
            if (!paramCursor.moveToNext()) {
              break label298;
            }
            str1 = paramCursor.getString(i2);
            if ((paramMediaFileFilter == null) || (!paramMediaFileFilter.filter(str1))) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.i("AlbumListAdapter", 2, "Filter mime type:" + str1);
            }
          }
          str2 = paramCursor.getString(m);
        } while ((TextUtils.isEmpty(str2)) || (!new File(str2).exists()));
        long l = paramCursor.getLong(n);
        LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
        localLocalMediaInfo._id = paramCursor.getLong(k);
        localLocalMediaInfo.path = str2;
        localLocalMediaInfo.mMimeType = str1;
        localLocalMediaInfo.modifiedDate = l;
        localLocalMediaInfo.mDuration = paramCursor.getLong(i1);
        localLocalMediaInfo.fileSize = paramCursor.getLong(i3);
        localArrayList.add(localLocalMediaInfo);
        j = i + 1;
        i = j;
      } while (paramInt <= 0);
      i = j;
    } while (j < paramInt);
    label298:
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_DovComQqImAeAlbumLogicAEAlbumListLogic$IalbumListAdapterCallBack.a(-1);
  }
  
  void a(QQAlbumInfo paramQQAlbumInfo)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      this.jdField_a_of_type_JavaUtilList.add(paramQQAlbumInfo);
    }
    for (;;)
    {
      b(paramQQAlbumInfo);
      notifyDataSetChanged();
      return;
      if (((QQAlbumInfo)this.jdField_a_of_type_JavaUtilList.get(0)).id.equals("$RecentAlbumId")) {
        this.jdField_a_of_type_JavaUtilList.set(0, paramQQAlbumInfo);
      }
    }
  }
  
  void a(List<QQAlbumInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
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
    this.jdField_a_of_type_AndroidOsHandler.post(new AlbumListAdapter.1(this, paramList));
  }
  
  public void c(QQAlbumInfo paramQQAlbumInfo)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      a(paramQQAlbumInfo);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new AlbumListAdapter.2(this, paramQQAlbumInfo));
  }
  
  void d(QQAlbumInfo paramQQAlbumInfo)
  {
    int k = 0;
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList.size() < 2) {
      this.jdField_a_of_type_JavaUtilList.add(paramQQAlbumInfo);
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      int i = 0;
      for (;;)
      {
        int j = k;
        if (i < this.jdField_a_of_type_JavaUtilList.size())
        {
          if (((QQAlbumInfo)this.jdField_a_of_type_JavaUtilList.get(i)).id.equals("$VideoAlbumId")) {
            j = 1;
          }
        }
        else
        {
          if (j == 0) {
            break label131;
          }
          if (paramQQAlbumInfo.mMediaFileCount <= 0) {
            break label117;
          }
          this.jdField_a_of_type_JavaUtilList.set(i, paramQQAlbumInfo);
          break;
        }
        i += 1;
      }
      label117:
      this.jdField_a_of_type_JavaUtilList.remove(i);
      continue;
      label131:
      if (paramQQAlbumInfo.mMediaFileCount > 0) {
        this.jdField_a_of_type_JavaUtilList.add(1, paramQQAlbumInfo);
      }
    }
  }
  
  public void e(QQAlbumInfo paramQQAlbumInfo)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      d(paramQQAlbumInfo);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new AlbumListAdapter.3(this, paramQQAlbumInfo));
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    return QAlbumUtil.getMediaType(((QQAlbumInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).mCoverInfo);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = this.jdField_a_of_type_DovComQqImAeAlbumLogicAEAlbumListLogic$IalbumListAdapterCallBack.a(paramInt, paramView, paramViewGroup);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return QAlbumUtil.MEDIA_TYPE_MAPS.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.adapter.AlbumListAdapter
 * JD-Core Version:    0.7.0.1
 */