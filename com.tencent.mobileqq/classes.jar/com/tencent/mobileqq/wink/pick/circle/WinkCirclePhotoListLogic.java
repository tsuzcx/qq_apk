package com.tencent.mobileqq.wink.pick.circle;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.aelight.camera.qqstory.api.IPeakIpcController;
import com.tencent.aelight.camera.qqstory.api.IPeakIpcModuleServer;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._AEEditorConstants;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.mobileqq.activity.photo.AlbumThumbManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaScannerListener;
import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListBaseData;
import com.tencent.mobileqq.activity.photo.album.querymedia.MediaQueryHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.QQWinkActivity;
import com.tencent.mobileqq.wink.editor.WinkEditorFragment;
import com.tencent.mobileqq.wink.editor.export.WinkExportManager;
import com.tencent.mobileqq.wink.editor.music.WinkEditorMusicHelper;
import com.tencent.mobileqq.wink.pick.album.data.AlbumSelectionData;
import com.tencent.mobileqq.wink.pick.album.data.WinkAlbumLogicData;
import com.tencent.mobileqq.wink.pick.album.data.WinkPhotoCommonDataCreator;
import com.tencent.mobileqq.wink.pick.circle.model.PickAlbumViewModel;
import com.tencent.mobileqq.wink.pick.circle.model.WinkAlbumModel;
import com.tencent.mobileqq.wink.pick.circle.part.WinkCircleAlbumListPart;
import com.tencent.mobileqq.wink.pick.circle.part.WinkCirclePhotoListPart;
import com.tencent.mobileqq.wink.pick.circle.part.WinkCirclePreviewPart;
import com.tencent.mobileqq.wink.pick.circle.part.WinkCircleSelectPanelPart;
import com.tencent.mobileqq.wink.pick.circle.part.WinkCircleTitleChipPart;
import com.tencent.mobileqq.wink.pick.circle.widget.WinkCancelableProgressDialog;
import com.tencent.mobileqq.winkpublish.api.IPublishLauncher;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

public class WinkCirclePhotoListLogic
  implements MediaScanner.OnMediaScannerListener
{
  private static final ArrayList<String> u = new WinkCirclePhotoListLogic.1();
  private static int w = 3000;
  private static int x = 3000;
  private boolean A = false;
  private Bundle B;
  private volatile boolean C = false;
  private volatile boolean D = false;
  private volatile CountDownLatch E;
  private WinkCancelableProgressDialog F;
  private String G;
  private final Map<String, String> H = new HashMap();
  protected long a;
  public int b;
  public WeakReference<WinkCirclePhotoListFragment> c;
  public PhotoCommonBaseData<OtherCommonData> d;
  public PhotoListBaseData e;
  public WinkCirclePhotoListLogic.PhotoListGuideData f;
  PickAlbumViewModel g;
  public ArrayList<LocalMediaInfo> h = new ArrayList();
  WinkCirclePhotoListPart i;
  WinkCircleAlbumListPart j;
  WinkCirclePreviewPart k;
  WinkCircleSelectPanelPart l;
  WinkCircleTitleChipPart m;
  public final WinkAlbumLogicData n = new WinkAlbumLogicData();
  private List<WinkCirclePhotoListLogic.InitResult> o = new ArrayList();
  private boolean p = false;
  private boolean q;
  private String r = "";
  private HashMap<String, String> s;
  private ArrayList<String> t;
  private Context v;
  private boolean y = false;
  private String z;
  
  public WinkCirclePhotoListLogic(WinkCirclePhotoListFragment paramWinkCirclePhotoListFragment)
  {
    Object localObject;
    if (paramWinkCirclePhotoListFragment == null) {
      localObject = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
    }
    this.c = new WeakReference(paramWinkCirclePhotoListFragment);
    this.d = WinkPhotoCommonDataCreator.a();
    this.d.addHoldNember();
    this.e = new PhotoListBaseData();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("PhotoListLogic new，fragment = ");
      ((StringBuilder)localObject).append(paramWinkCirclePhotoListFragment);
      ((StringBuilder)localObject).append(",PhotoCommonData = ");
      ((StringBuilder)localObject).append(this.d);
      QLog.d("QQAlbum", 2, ((StringBuilder)localObject).toString());
    }
    this.a = System.currentTimeMillis();
  }
  
  /* Error */
  public static int a(LocalMediaInfo paramLocalMediaInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 191	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   4: lstore_3
    //   5: lload_3
    //   6: ldc2_w 192
    //   9: lcmp
    //   10: ifgt +141 -> 151
    //   13: lload_3
    //   14: ldc2_w 194
    //   17: lcmp
    //   18: ifge +6 -> 24
    //   21: goto +130 -> 151
    //   24: new 197	android/media/MediaMetadataRetriever
    //   27: dup
    //   28: invokespecial 198	android/media/MediaMetadataRetriever:<init>	()V
    //   31: astore 6
    //   33: aload 6
    //   35: aload_0
    //   36: getfield 201	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   39: invokevirtual 205	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   42: aload 6
    //   44: bipush 19
    //   46: invokevirtual 209	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   49: invokestatic 215	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   52: istore_1
    //   53: aload 6
    //   55: bipush 18
    //   57: invokevirtual 209	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   60: invokestatic 215	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   63: istore_2
    //   64: aload 6
    //   66: bipush 12
    //   68: invokevirtual 209	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   71: astore_0
    //   72: iload_1
    //   73: invokestatic 218	com/tencent/mobileqq/wink/pick/circle/WinkCirclePhotoListLogic:b	()I
    //   76: if_icmpgt +43 -> 119
    //   79: iload_2
    //   80: invokestatic 220	com/tencent/mobileqq/wink/pick/circle/WinkCirclePhotoListLogic:c	()I
    //   83: if_icmple +6 -> 89
    //   86: goto +33 -> 119
    //   89: invokestatic 223	com/tencent/mobileqq/wink/pick/circle/WinkCirclePhotoListLogic:a	()Ljava/util/ArrayList;
    //   92: aload_0
    //   93: invokevirtual 227	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   96: istore 5
    //   98: iload 5
    //   100: ifne +12 -> 112
    //   103: iconst_3
    //   104: istore_1
    //   105: aload 6
    //   107: invokevirtual 230	android/media/MediaMetadataRetriever:release	()V
    //   110: iload_1
    //   111: ireturn
    //   112: aload 6
    //   114: invokevirtual 230	android/media/MediaMetadataRetriever:release	()V
    //   117: iconst_0
    //   118: ireturn
    //   119: iconst_2
    //   120: istore_1
    //   121: goto -16 -> 105
    //   124: astore_0
    //   125: goto +19 -> 144
    //   128: astore_0
    //   129: invokestatic 152	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   132: ifeq +7 -> 139
    //   135: aload_0
    //   136: invokevirtual 233	java/lang/Exception:printStackTrace	()V
    //   139: iconst_5
    //   140: istore_1
    //   141: goto -36 -> 105
    //   144: aload 6
    //   146: invokevirtual 230	android/media/MediaMetadataRetriever:release	()V
    //   149: aload_0
    //   150: athrow
    //   151: iconst_1
    //   152: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	paramLocalMediaInfo	LocalMediaInfo
    //   52	89	1	i1	int
    //   63	21	2	i2	int
    //   4	10	3	l1	long
    //   96	3	5	bool	boolean
    //   31	114	6	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    // Exception table:
    //   from	to	target	type
    //   33	86	124	finally
    //   89	98	124	finally
    //   129	139	124	finally
    //   33	86	128	java/lang/Exception
    //   89	98	128	java/lang/Exception
  }
  
  public static String a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return "";
    }
    paramIntent = (HashMap)paramIntent.getSerializableExtra("key_attrs");
    if (paramIntent == null) {
      return "";
    }
    if (paramIntent.containsKey("filter")) {
      return "filter";
    }
    if (paramIntent.containsKey("template")) {
      return "template";
    }
    if (paramIntent.containsKey("sticker")) {
      return "sticker";
    }
    if (paramIntent.containsKey("music")) {
      return "music";
    }
    return "";
  }
  
  public static ArrayList<String> a()
  {
    return u;
  }
  
  private void a(Context paramContext, int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 3)
      {
        if (paramInt != 4)
        {
          if (paramInt != 5) {
            return;
          }
          QQToast.makeText(paramContext, HardCodeUtil.a(2131886375), 0).show();
          return;
        }
        QQToast.makeText(paramContext, HardCodeUtil.a(2131886372), 0).show();
        return;
      }
      QQToast.makeText(paramContext, HardCodeUtil.a(2131886374), 0).show();
      return;
    }
    QQToast.makeText(paramContext, "请选择2秒到1小时之间的视频", 0).show();
  }
  
  /* Error */
  private void a(WinkAlbumModel paramWinkAlbumModel, LocalMediaInfo paramLocalMediaInfo, int paramInt)
  {
    // Byte code:
    //   0: getstatic 286	com/tencent/mobileqq/wink/edit/base/AEEditorPath$EDITOR$FILES:d	Ljava/lang/String;
    //   3: astore 8
    //   5: new 288	java/io/File
    //   8: dup
    //   9: aload 8
    //   11: invokespecial 290	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore 9
    //   16: aload 9
    //   18: invokevirtual 293	java/io/File:exists	()Z
    //   21: ifne +9 -> 30
    //   24: aload 9
    //   26: invokevirtual 296	java/io/File:mkdirs	()Z
    //   29: pop
    //   30: new 288	java/io/File
    //   33: dup
    //   34: aload_2
    //   35: getfield 201	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   38: invokespecial 290	java/io/File:<init>	(Ljava/lang/String;)V
    //   41: astore 9
    //   43: new 154	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   50: astore 10
    //   52: aload 10
    //   54: aload 8
    //   56: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload 10
    //   62: getstatic 299	java/io/File:separator	Ljava/lang/String;
    //   65: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload 10
    //   71: ldc_w 301
    //   74: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload 10
    //   80: invokestatic 181	java/lang/System:currentTimeMillis	()J
    //   83: invokevirtual 304	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload 10
    //   89: ldc_w 306
    //   92: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload 10
    //   98: aload 9
    //   100: invokevirtual 309	java/io/File:getName	()Ljava/lang/String;
    //   103: invokestatic 312	com/tencent/mobileqq/wink/pick/circle/WinkCirclePhotoListLogic:b	(Ljava/lang/String;)Ljava/lang/String;
    //   106: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload 10
    //   112: ldc_w 314
    //   115: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload 10
    //   121: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: astore 9
    //   126: iconst_0
    //   127: istore 7
    //   129: iconst_0
    //   130: istore 6
    //   132: aload_2
    //   133: getfield 201	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   136: getstatic 319	com/tencent/mobileqq/shortvideo/util/ScreenUtil:SCREEN_WIDTH	I
    //   139: getstatic 322	com/tencent/mobileqq/shortvideo/util/ScreenUtil:SCREEN_HIGHT	I
    //   142: invokestatic 327	com/tencent/mobileqq/wink/editor/sticker/BitmapUtils:a	(Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   145: astore 8
    //   147: aload 8
    //   149: new 288	java/io/File
    //   152: dup
    //   153: aload 9
    //   155: invokespecial 290	java/io/File:<init>	(Ljava/lang/String;)V
    //   158: invokestatic 332	com/tencent/mobileqq/utils/BaseImageUtil:b	(Landroid/graphics/Bitmap;Ljava/io/File;)Z
    //   161: istore 5
    //   163: iload 5
    //   165: istore 4
    //   167: aload 8
    //   169: ifnull +66 -> 235
    //   172: iload 5
    //   174: istore 4
    //   176: aload 8
    //   178: invokevirtual 337	android/graphics/Bitmap:isRecycled	()Z
    //   181: ifne +54 -> 235
    //   184: iload 5
    //   186: istore 4
    //   188: aload 8
    //   190: invokevirtual 340	android/graphics/Bitmap:recycle	()V
    //   193: goto +42 -> 235
    //   196: astore_1
    //   197: goto +149 -> 346
    //   200: astore 10
    //   202: aload 10
    //   204: invokevirtual 341	java/io/IOException:printStackTrace	()V
    //   207: iload 7
    //   209: istore 4
    //   211: aload 8
    //   213: ifnull +22 -> 235
    //   216: iload 7
    //   218: istore 4
    //   220: aload 8
    //   222: invokevirtual 337	android/graphics/Bitmap:isRecycled	()Z
    //   225: ifne +10 -> 235
    //   228: iload 6
    //   230: istore 4
    //   232: goto -44 -> 188
    //   235: iload 4
    //   237: ifne +72 -> 309
    //   240: new 154	java/lang/StringBuilder
    //   243: dup
    //   244: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   247: astore 8
    //   249: aload 8
    //   251: ldc_w 343
    //   254: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: aload 8
    //   260: aload_2
    //   261: getfield 201	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   264: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: pop
    //   268: ldc_w 345
    //   271: iconst_1
    //   272: aload 8
    //   274: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   280: aload_0
    //   281: getfield 117	com/tencent/mobileqq/wink/pick/circle/WinkCirclePhotoListLogic:H	Ljava/util/Map;
    //   284: aload_1
    //   285: invokevirtual 350	com/tencent/mobileqq/wink/pick/circle/model/WinkAlbumModel:getPath	()Ljava/lang/String;
    //   288: aload_2
    //   289: getfield 201	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   292: invokeinterface 356 3 0
    //   297: pop
    //   298: aload_1
    //   299: aload_2
    //   300: getfield 201	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   303: invokevirtual 359	com/tencent/mobileqq/wink/pick/circle/model/WinkAlbumModel:setPath	(Ljava/lang/String;)V
    //   306: goto +25 -> 331
    //   309: aload_0
    //   310: getfield 117	com/tencent/mobileqq/wink/pick/circle/WinkCirclePhotoListLogic:H	Ljava/util/Map;
    //   313: aload_1
    //   314: invokevirtual 350	com/tencent/mobileqq/wink/pick/circle/model/WinkAlbumModel:getPath	()Ljava/lang/String;
    //   317: aload 9
    //   319: invokeinterface 356 3 0
    //   324: pop
    //   325: aload_1
    //   326: aload 9
    //   328: invokevirtual 359	com/tencent/mobileqq/wink/pick/circle/model/WinkAlbumModel:setPath	(Ljava/lang/String;)V
    //   331: aload_0
    //   332: getfield 361	com/tencent/mobileqq/wink/pick/circle/WinkCirclePhotoListLogic:E	Ljava/util/concurrent/CountDownLatch;
    //   335: ifnull +10 -> 345
    //   338: aload_0
    //   339: getfield 361	com/tencent/mobileqq/wink/pick/circle/WinkCirclePhotoListLogic:E	Ljava/util/concurrent/CountDownLatch;
    //   342: invokevirtual 366	java/util/concurrent/CountDownLatch:countDown	()V
    //   345: return
    //   346: aload 8
    //   348: ifnull +16 -> 364
    //   351: aload 8
    //   353: invokevirtual 337	android/graphics/Bitmap:isRecycled	()Z
    //   356: ifne +8 -> 364
    //   359: aload 8
    //   361: invokevirtual 340	android/graphics/Bitmap:recycle	()V
    //   364: goto +5 -> 369
    //   367: aload_1
    //   368: athrow
    //   369: goto -2 -> 367
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	372	0	this	WinkCirclePhotoListLogic
    //   0	372	1	paramWinkAlbumModel	WinkAlbumModel
    //   0	372	2	paramLocalMediaInfo	LocalMediaInfo
    //   0	372	3	paramInt	int
    //   165	71	4	bool1	boolean
    //   161	24	5	bool2	boolean
    //   130	99	6	bool3	boolean
    //   127	90	7	bool4	boolean
    //   3	357	8	localObject1	Object
    //   14	313	9	localObject2	Object
    //   50	70	10	localStringBuilder	StringBuilder
    //   200	3	10	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   147	163	196	finally
    //   202	207	196	finally
    //   147	163	200	java/io/IOException
  }
  
  private void a(String paramString, Intent paramIntent)
  {
    paramIntent.setClass(((WinkCirclePhotoListFragment)this.c.get()).getContext(), QQWinkActivity.class);
    paramIntent.putExtra("public_fragment_class", paramString);
    ((WinkCirclePhotoListFragment)this.c.get()).getContext().startActivity(paramIntent);
  }
  
  private void a(ArrayList<WinkAlbumModel> paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      WinkExportManager.a();
      WinkExportManager.d();
    }
    a(paramBoolean1, paramBoolean2);
    AEQLog.a("WinkCirclePhotoListLogic", "after show, submit compress task");
    ThreadManagerV2.excute(new WinkCirclePhotoListLogic.5(this, paramArrayList, paramBoolean1, paramBoolean2), 16, new WinkCirclePhotoListLogic.6(this), true);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.F == null)
    {
      this.F = new WinkCancelableProgressDialog(((WinkCirclePhotoListFragment)this.c.get()).getActivity());
      if ((paramBoolean1) && (paramBoolean2)) {
        this.F.a(((WinkCirclePhotoListFragment)this.c.get()).getString(2131892601));
      } else if (paramBoolean1) {
        this.F.a(((WinkCirclePhotoListFragment)this.c.get()).getString(2131917837));
      } else if (paramBoolean2) {
        this.F.a(((WinkCirclePhotoListFragment)this.c.get()).getString(2131892593));
      }
      this.F.a(new WinkCirclePhotoListLogic.7(this));
    }
    this.F.show();
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    ThreadManager.getUIHandler().post(new WinkCirclePhotoListLogic.8(this, paramBoolean1, paramBoolean2, paramInt2, paramInt1));
  }
  
  public static int b()
  {
    return w;
  }
  
  public static String b(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      if (paramString.equals("")) {
        return paramString;
      }
      int i1 = paramString.lastIndexOf(".");
      int i2 = paramString.lastIndexOf(File.separator);
      if (i2 == -1)
      {
        if (i1 == -1) {
          return paramString;
        }
        return paramString.substring(0, i1);
      }
      if (i1 == -1) {
        return paramString.substring(i2 + 1);
      }
      if (i2 < i1) {
        return paramString.substring(i2 + 1, i1);
      }
      str = paramString.substring(i2 + 1);
    }
    return str;
  }
  
  private void b(WinkAlbumModel paramWinkAlbumModel, LocalMediaInfo paramLocalMediaInfo, int paramInt)
  {
    WinkExportManager.a().a(paramLocalMediaInfo, new WinkCirclePhotoListLogic.9(this, paramInt, paramWinkAlbumModel));
  }
  
  @WorkerThread
  private void b(ArrayList<WinkAlbumModel> paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i2 = paramArrayList.size();
    int i1 = 0;
    do
    {
      if (i1 >= i2) {
        break;
      }
      WinkAlbumModel localWinkAlbumModel = (WinkAlbumModel)paramArrayList.get(i1);
      LocalMediaInfo localLocalMediaInfo = c(localWinkAlbumModel.getPath());
      localWinkAlbumModel.setOriginPath(localWinkAlbumModel.getPath());
      i1 += 1;
      this.E = new CountDownLatch(1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("batchCompress---begin, index=");
      localStringBuilder.append(i1);
      AEQLog.b("WinkCirclePhotoListLogic", localStringBuilder.toString());
      a(paramBoolean1, paramBoolean2, i2, i1);
      if ((localLocalMediaInfo != null) && (QAlbumUtil.getMediaType(localLocalMediaInfo) == 1)) {
        b(localWinkAlbumModel, localLocalMediaInfo, i1);
      } else if ((localLocalMediaInfo != null) && (QAlbumUtil.getMediaType(localLocalMediaInfo) == 0)) {
        a(localWinkAlbumModel, localLocalMediaInfo, i1);
      }
      if (this.E != null)
      {
        try
        {
          this.E.await();
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
        this.E = null;
      }
    } while ((!this.C) && (!this.D));
  }
  
  public static int c()
  {
    return x;
  }
  
  @Nullable
  private LocalMediaInfo c(String paramString)
  {
    Object localObject1 = this.d;
    if ((localObject1 != null) && (((PhotoCommonBaseData)localObject1).selectedMediaInfoHashMap != null)) {
      localObject1 = (LocalMediaInfo)this.d.selectedMediaInfoHashMap.get(paramString);
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      Object localObject3 = new LinkedList(this.h);
      localObject2 = localObject1;
      if (!CollectionUtils.isEmpty((Collection)localObject3))
      {
        localObject3 = ((List)localObject3).iterator();
        do
        {
          localObject2 = localObject1;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject2 = (LocalMediaInfo)((Iterator)localObject3).next();
        } while ((localObject2 == null) || (TextUtils.isEmpty(((LocalMediaInfo)localObject2).path)) || (!((LocalMediaInfo)localObject2).path.equals(paramString)));
      }
    }
    return localObject2;
  }
  
  private void c(Intent paramIntent)
  {
    paramIntent = a(paramIntent);
    if (TextUtils.isEmpty(paramIntent)) {
      return;
    }
    if (paramIntent.equals("music")) {
      u();
    }
  }
  
  private void d(Intent paramIntent)
  {
    if (!TextUtils.isEmpty(this.z)) {
      ((IPeakIpcController)QRoute.api(IPeakIpcController.class)).report(this.z, ((IPeakIpcModuleServer)QRoute.api(IPeakIpcModuleServer.class)).ACTION_QCIRCLE_PICKER_READY());
    }
  }
  
  private void t()
  {
    HashMap localHashMap = this.s;
    if (localHashMap == null)
    {
      QLog.e("WinkCirclePhotoListLogic", 1, "[initDatongParams] mSchemaData is null.");
      return;
    }
    String str = "filter";
    if (!localHashMap.containsKey("filter")) {
      if (this.s.containsKey("template")) {
        str = "template";
      } else if (this.s.containsKey("sticker")) {
        str = "sticker";
      } else if (this.s.containsKey("music")) {
        str = "music";
      } else {
        str = "";
      }
    }
    if (!TextUtils.isEmpty(str))
    {
      WinkDatongCurrentParams.put("xsj_paitongkuan_type", str);
      WinkDatongCurrentParams.put("xsj_paitongkuan_id", this.s.get(str));
    }
  }
  
  private void u()
  {
    if (this.s == null) {
      return;
    }
    this.f = new WinkCirclePhotoListLogic.PhotoListGuideData(this);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.s.get("music"));
    this.t = localArrayList;
    WinkEditorMusicHelper.a(localArrayList, new WinkCirclePhotoListLogic.2(this));
  }
  
  private void v()
  {
    Intent localIntent = ((WinkCirclePhotoListFragment)this.c.get()).getActivity().getIntent();
    if (this.n.canMixPhotoAndVideo)
    {
      this.d.maxSelectNum = this.n.maxSelectNumForMix;
      this.e.B = true;
      this.d.isSingleMode = false;
      return;
    }
    this.d.maxSelectNum = this.n.maxSelectNumForNormal;
    this.e.B = localIntent.getBooleanExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", false);
    if (this.d.maxSelectNum > 1) {
      this.d.isSingleMode = false;
    }
    if (localIntent.getBooleanExtra("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", false)) {
      this.d.isSingleMode = false;
    }
  }
  
  private boolean w()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    LinkedList localLinkedList = new LinkedList(this.d.selectedPhotoList);
    int i1 = 0;
    boolean bool2 = false;
    boolean bool4;
    for (boolean bool1 = false; i1 < localLinkedList.size(); bool1 = bool4)
    {
      String str = (String)localLinkedList.get(i1);
      Object localObject1;
      boolean bool3;
      if (TextUtils.isEmpty(str))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handleClickNextBtnForMixPhotoAndVideo--empty path, drop it: ");
        ((StringBuilder)localObject1).append(str);
        AEQLog.d("WinkCirclePhotoListLogic", ((StringBuilder)localObject1).toString());
        bool3 = bool2;
        bool4 = bool1;
      }
      else if (!new File(str).exists())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handleClickNextBtnForMixPhotoAndVideo--file not exists, drop it: ");
        ((StringBuilder)localObject1).append(str);
        AEQLog.d("WinkCirclePhotoListLogic", ((StringBuilder)localObject1).toString());
        bool3 = bool2;
        bool4 = bool1;
      }
      else
      {
        Object localObject2 = c(str);
        StringBuilder localStringBuilder;
        if ((localObject2 != null) && (QAlbumUtil.getMediaType((LocalMediaInfo)localObject2) == 1))
        {
          int i2 = a((LocalMediaInfo)localObject2);
          if ((i2 != 2) && (i2 != 0))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("handleClickNextBtnForMixPhotoAndVideo--not supported video, drop it: ");
            ((StringBuilder)localObject1).append(str);
            AEQLog.d("WinkCirclePhotoListLogic", ((StringBuilder)localObject1).toString());
            bool3 = bool2;
            bool4 = bool1;
          }
          else
          {
            localObject1 = new WinkAlbumModel(str);
            ((WinkAlbumModel)localObject1).setOriginPath(str);
            localArrayList1.add(localObject1);
            if (i2 == 2)
            {
              localObject2 = (String)this.H.get(str);
              if (TextUtils.isEmpty((CharSequence)localObject2))
              {
                localArrayList2.add(localObject1);
              }
              else
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("hit cache, no need compress for: ");
                localStringBuilder.append(str);
                AEQLog.a("WinkCirclePhotoListLogic", localStringBuilder.toString());
                ((WinkAlbumModel)localObject1).setPath((String)localObject2);
              }
            }
            bool3 = true;
            bool4 = bool1;
          }
        }
        else
        {
          bool3 = bool2;
          bool4 = bool1;
          if (localObject2 != null)
          {
            bool3 = bool2;
            bool4 = bool1;
            if (QAlbumUtil.getMediaType((LocalMediaInfo)localObject2) == 0)
            {
              localObject1 = new WinkAlbumModel(str);
              ((WinkAlbumModel)localObject1).setOriginPath(str);
              localArrayList1.add(localObject1);
              bool3 = bool2;
              bool4 = bool1;
              if (!b((LocalMediaInfo)localObject2))
              {
                localObject2 = (String)this.H.get(str);
                if (TextUtils.isEmpty((CharSequence)localObject2))
                {
                  localArrayList2.add(localObject1);
                  bool4 = true;
                  bool3 = bool2;
                }
                else
                {
                  localStringBuilder = new StringBuilder();
                  localStringBuilder.append("hit cache, no need compress for: ");
                  localStringBuilder.append(str);
                  AEQLog.a("WinkCirclePhotoListLogic", localStringBuilder.toString());
                  ((WinkAlbumModel)localObject1).setPath((String)localObject2);
                  bool4 = bool1;
                  bool3 = bool2;
                }
              }
            }
          }
        }
      }
      i1 += 1;
      bool2 = bool3;
    }
    if (localArrayList2.isEmpty()) {
      return false;
    }
    a(localArrayList2, bool2, bool1);
    return true;
  }
  
  @NotNull
  private ArrayList<LocalMediaInfo> x()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.d.selectedPhotoList.iterator();
    while (localIterator.hasNext())
    {
      LocalMediaInfo localLocalMediaInfo = a((String)localIterator.next());
      if (localLocalMediaInfo != null) {
        localArrayList.add(localLocalMediaInfo);
      }
    }
    return localArrayList;
  }
  
  public int a(int paramInt)
  {
    AlbumSelectionData localAlbumSelectionData = AlbumSelectionData.a();
    if ((localAlbumSelectionData != null) && (localAlbumSelectionData.c() != null) && (localAlbumSelectionData.c().get(Integer.valueOf(paramInt)) != null)) {
      return ((ArrayList)localAlbumSelectionData.c().get(Integer.valueOf(paramInt))).size();
    }
    return 0;
  }
  
  @Nullable
  public LocalMediaInfo a(Object paramObject)
  {
    Object localObject1 = this.d;
    if ((localObject1 != null) && (((PhotoCommonBaseData)localObject1).selectedMediaInfoHashMap != null)) {
      localObject1 = (LocalMediaInfo)this.d.selectedMediaInfoHashMap.get(paramObject);
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      PhotoCommonBaseData localPhotoCommonBaseData = this.d;
      localObject2 = localObject1;
      if (localPhotoCommonBaseData != null)
      {
        localObject2 = localObject1;
        if (localPhotoCommonBaseData.allMediaInfoHashMap != null) {
          localObject2 = (LocalMediaInfo)this.d.allMediaInfoHashMap.get(paramObject);
        }
      }
    }
    return localObject2;
  }
  
  public List<LocalMediaInfo> a(boolean paramBoolean)
  {
    int i1;
    if (paramBoolean) {
      i1 = 15;
    } else {
      i1 = QzoneConfig.getMaxPhotoNumInRecentPhoto();
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("WinkCirclePhotoListLogic:QueryPhotoTask", 4, "getLocalMediaInfo start ");
    }
    long l1 = System.currentTimeMillis();
    if ((!TextUtils.isEmpty(this.r)) && (this.r.equals(this.d.albumId)))
    {
      this.d.mMediaQueryHelper.queryNext(i1);
    }
    else
    {
      this.r = this.d.albumId;
      this.d.createMediaQueryHelper(RFApplication.getApplication());
      this.d.mMediaQueryHelper.queryNext(i1);
    }
    List localList = this.d.mMediaQueryHelper.mediaList;
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getLocalMediaInfo end, cost ");
      localStringBuilder.append(System.currentTimeMillis() - l1);
      localStringBuilder.append("ms");
      QLog.d("WinkCirclePhotoListLogic:QueryPhotoTask", 4, localStringBuilder.toString());
    }
    LogTag.a("PEAK", "getAlbumMedias");
    if (localList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, "photoList is null");
      }
      return null;
    }
    if ((this.d.selectedPhotoList != null) && (this.d.selectedPhotoList.size() != 0))
    {
      i1 = 0;
      while (i1 < this.d.selectedPhotoList.size())
      {
        if (TextUtils.isEmpty((String)this.d.selectedPhotoList.get(i1))) {
          QZLog.e("QQAlbum:QueryPhotoTask", "doInBackground: filter photo error, tempPath null");
        }
        i1 += 1;
      }
    }
    return localList;
  }
  
  public Map<String, Object> a(String paramString)
  {
    Object localObject1 = this.d;
    if ((localObject1 != null) && (((PhotoCommonBaseData)localObject1).selectedPhotoList != null))
    {
      localObject1 = new ArrayList();
      Object localObject2 = this.d.selectedPhotoList.iterator();
      int i2 = 0;
      int i1 = 0;
      while (((Iterator)localObject2).hasNext())
      {
        LocalMediaInfo localLocalMediaInfo = a((String)((Iterator)localObject2).next());
        if (localLocalMediaInfo != null)
        {
          ((ArrayList)localObject1).add(localLocalMediaInfo);
          if (QAlbumUtil.getMediaType(localLocalMediaInfo) == 1) {
            i1 += 1;
          } else if (QAlbumUtil.getMediaType(localLocalMediaInfo) == 0) {
            i2 += 1;
          }
        }
      }
      localObject2 = this.d.selectedPhotoList;
      localObject1 = new HashMap();
      ((Map)localObject1).put("xsj_content_num", Integer.valueOf(((ArrayList)localObject2).size()));
      ((Map)localObject1).put("xsj_picture_num", Integer.valueOf(i2));
      ((Map)localObject1).put("xsj_video_num", Integer.valueOf(i1));
      ((Map)localObject1).put("xsj_eid", paramString);
      ((Map)localObject1).put("xsj_content_from_all_num", Integer.valueOf(a(1)));
      ((Map)localObject1).put("xsj_content_from_picture_num", Integer.valueOf(a(2)));
      ((Map)localObject1).put("xsj_content_from_video_num", Integer.valueOf(a(3)));
      ((Map)localObject1).put("xsj_content_from_default_album_name", Integer.valueOf(a(4)));
      ((Map)localObject1).put("xsj_content_from_qzone_album_num", Integer.valueOf(0));
      paramString = (String)WinkDatongCurrentParams.params.get("xsj_camera_clck_ref_pgid");
      if (!TextUtils.isEmpty(paramString)) {
        ((Map)localObject1).put("xsj_camera_clck_ref_pgid", paramString);
      }
      return localObject1;
    }
    return null;
  }
  
  public void a(Intent paramIntent, Context paramContext)
  {
    this.g = ((PickAlbumViewModel)new ViewModelProvider(r().getActivity()).get(PickAlbumViewModel.class));
    this.e.N = paramIntent.getBooleanExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
    this.q = paramIntent.getBooleanExtra("BUNDLE_KEY_FS_CAN_ONLY_EDIT_VIDEO", false);
    boolean bool = paramIntent.getBooleanExtra("album_enter_directly", false);
    this.v = paramContext;
    if (bool)
    {
      long l1 = System.currentTimeMillis();
      long l2 = QAlbumUtil.sLastAlbumRecordTime;
      if ((this.e.N) && (l1 - l2 < 60000L))
      {
        this.d.albumName = QAlbumUtil.sLastAlbumName;
        this.d.albumId = QAlbumUtil.sLastAlbumId;
      }
    }
    else
    {
      this.d.albumName = paramIntent.getStringExtra("ALBUM_NAME");
      this.d.albumId = paramIntent.getStringExtra("ALBUM_ID");
    }
    if (this.d.albumId == null)
    {
      localObject = this.d;
      ((PhotoCommonBaseData)localObject).albumId = "$RecentAlbumId";
      ((PhotoCommonBaseData)localObject).albumName = null;
    }
    this.e.Q = paramIntent.getBooleanExtra("PeakConstants.showGifTypeIcon", false);
    Object localObject = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty())) {
      this.d.selectedPhotoList = ((ArrayList)localObject);
    }
    if (this.d.selectedPhotoList == null) {
      this.d.selectedPhotoList = new ArrayList();
    }
    if (this.d.selectedMediaInfoHashMap == null) {
      this.d.selectedMediaInfoHashMap = new HashMap();
    }
    localObject = (HashMap)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
    if ((localObject != null) && (!((HashMap)localObject).isEmpty()) && (this.d.selectedPhotoList.size() == ((HashMap)localObject).size()))
    {
      this.d.selectedMediaInfoHashMap.clear();
      this.d.selectedMediaInfoHashMap.putAll((Map)localObject);
    }
    this.d.selectedIndex = new ArrayList();
    this.d.isSingleMode = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_MODE", true);
    this.d.showMediaType = paramIntent.getIntExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 0);
    localObject = this.d;
    ((PhotoCommonBaseData)localObject).filter = MediaFileFilter.getFilter(((PhotoCommonBaseData)localObject).showMediaType);
    this.s = ((HashMap)paramIntent.getSerializableExtra("key_attrs"));
    if (paramIntent.getBooleanExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", false))
    {
      this.d.filter.needVideo = false;
      this.d.filter.needGif = false;
    }
    this.e.O = paramIntent.getBooleanExtra("PhotoConst.IS_SHOW_CAMERA", false);
    if (this.e.O) {
      this.e.P = paramIntent.getBooleanExtra("PhotoConst.SHOW_CAMERA_IN_VIDEO", false);
    }
    this.e.F = paramIntent.getIntExtra("PHOTOLIST_START_POSITION", -1);
    paramIntent.removeExtra("PHOTOLIST_START_POSITION");
    this.d.filter.videoMaxDuration = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_FILTER_VIDEO_DURATION_LIMIT", 9223372036854775807L);
    int i1;
    if (this.d.showMediaType == 2)
    {
      paramContext = paramContext.getResources();
      i1 = 2131898413;
    }
    else
    {
      paramContext = paramContext.getResources();
      i1 = 2131898412;
    }
    this.G = paramContext.getString(i1);
    this.n.maxSelectNumForNormal = paramIntent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", 35);
    paramContext = this.n;
    paramContext.minSelectNumForMix = 2;
    paramContext.maxSelectNumForMix = 35;
    paramContext.minSelectNumForNormal = -2147483648;
    paramContext.canMixPhotoAndVideo = paramIntent.getBooleanExtra("BUNDLE_KEY_CIRCLE_CAN_MIX_PICK_PHOTO_AND_VIDEO", false);
    this.n.canSwitchSelectionMode = paramIntent.getBooleanExtra("BUNDLE_KEY_CIRCLE_CAN_SWITCH_SECTION_MODE", true);
    this.n.initialHasPickedNum = ((WinkCirclePhotoListFragment)this.c.get()).getActivity().getIntent().getIntExtra("BUNDLE_KEY_CIRCLE_HAS_PICKED_NUM", 0);
    this.n.canPickVideo = ((WinkCirclePhotoListFragment)this.c.get()).getActivity().getIntent().getBooleanExtra("BUNDLE_KEY_CIRCLE_CAN_PICK_VIDEO", true);
    paramContext = this.n;
    paramContext.canPickImage = true;
    paramContext.isSinglePickMode = ((WinkCirclePhotoListFragment)this.c.get()).getActivity().getIntent().getBooleanExtra("BUNDLE_KEY_CIRCLE_SINGLE_PICK_MODE", false);
    this.n.isHideSelectTab = ((WinkCirclePhotoListFragment)this.c.get()).getActivity().getIntent().getBooleanExtra("BUNDLE_KEY_CIRCLE_HIDE_PHOTOLIST_TAB", false);
    this.n.defaultSelectTab = ((WinkCirclePhotoListFragment)this.c.get()).getActivity().getIntent().getIntExtra("BUNDLE_KEY_CIRCLE_DEFAULT_SELECT_TAB", 1);
    v();
    paramContext = new StringBuilder();
    paramContext.append("initData---aeAlbumData=");
    paramContext.append(this.n);
    AEQLog.b("WinkCirclePhotoListLogic", paramContext.toString());
    this.d.filter.videoSizeLimit = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_SIZE", -1L);
    this.d.filter.videoMaxDuration = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_DURATION", -1L);
    paramContext = ((WinkCirclePhotoListFragment)this.c.get()).getActivity().getIntent().getStringExtra("albumName");
    localObject = ((WinkCirclePhotoListFragment)this.c.get()).getActivity().getIntent().getStringExtra("albumId");
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramContext)))
    {
      PhotoCommonBaseData localPhotoCommonBaseData = this.d;
      localPhotoCommonBaseData.albumName = paramContext;
      localPhotoCommonBaseData.albumId = ((String)localObject);
    }
    this.r = ((String)localObject);
    this.d.createMediaQueryHelper(RFApplication.getApplication());
    w = 3000;
    x = 3000;
    c(paramIntent);
    if (paramIntent.getBooleanExtra("key_qcircle_from_mid_page", false))
    {
      paramContext = (HashMap)paramIntent.getExtras().getSerializable("key_qcircle_mid_page_photo_path");
      if (paramContext != null)
      {
        localObject = (ArrayList)paramIntent.getExtras().getSerializable("QCIRCLE_PUBLISH_MID_PAGE_NEW_PHOTO_PATH");
        if (localObject != null) {
          this.d.selectedPhotoList.addAll((Collection)localObject);
        }
        if (this.d.selectedMediaInfoHashMap == null) {
          this.d.selectedMediaInfoHashMap = new HashMap();
        }
        this.d.selectedMediaInfoHashMap.putAll(paramContext);
      }
    }
    this.b = paramIntent.getIntExtra("WINK_PHOTO_LIST_SELECT_ENTRANCE", 0);
    this.z = paramIntent.getStringExtra("qcircle_client_traceid");
    this.B = paramIntent.getExtras();
    t();
  }
  
  public void a(View paramView)
  {
    paramView = this.c;
    if ((paramView != null) && (paramView.get() != null)) {
      ((WinkCirclePhotoListFragment)this.c.get()).a(this.z);
    }
  }
  
  public void a(View paramView, Map<String, Object> paramMap)
  {
    WeakReference localWeakReference = this.c;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((WinkCirclePhotoListFragment)this.c.get()).b(paramView, "ev_xsj_camera_action", paramMap);
    }
  }
  
  public void a(WinkCircleAlbumListPart paramWinkCircleAlbumListPart)
  {
    this.j = paramWinkCircleAlbumListPart;
  }
  
  public void a(WinkCirclePhotoListPart paramWinkCirclePhotoListPart)
  {
    this.i = paramWinkCirclePhotoListPart;
  }
  
  public void a(WinkCirclePreviewPart paramWinkCirclePreviewPart)
  {
    this.k = paramWinkCirclePreviewPart;
  }
  
  public void a(WinkCircleSelectPanelPart paramWinkCircleSelectPanelPart)
  {
    this.l = paramWinkCircleSelectPanelPart;
  }
  
  public void a(WinkCircleTitleChipPart paramWinkCircleTitleChipPart)
  {
    this.m = paramWinkCircleTitleChipPart;
  }
  
  public void a(Boolean paramBoolean)
  {
    ArrayList localArrayList = x();
    Object localObject1 = Parcel.obtain();
    ((Parcel)localObject1).writeList(localArrayList);
    ((Parcel)localObject1).setDataPosition(0);
    localObject1 = ((Parcel)localObject1).readArrayList(LocalMediaInfo.class.getClassLoader());
    Object localObject2 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (LocalMediaInfo)((Iterator)localObject2).next();
      if (!TextUtils.isEmpty((CharSequence)this.H.get(((LocalMediaInfo)localObject3).path))) {
        ((LocalMediaInfo)localObject3).path = ((String)this.H.get(((LocalMediaInfo)localObject3).path));
      }
    }
    localObject2 = new Intent();
    Object localObject3 = this.B;
    if (localObject3 != null) {
      ((Intent)localObject2).putExtras((Bundle)localObject3);
    }
    ((Intent)localObject2).putExtra("qcircle_client_traceid", this.z);
    if (this.c.get() != null)
    {
      ((Intent)localObject2).putExtra("IS_AUTO_TEMPLATE", this.A);
      ((Intent)localObject2).putExtra("IS_EDIT_TEXT", false);
      ((Intent)localObject2).putExtra("IS_IMAGE_MODEL", false);
      ((Intent)localObject2).putExtra("localMediaInfos", localArrayList);
      ((Intent)localObject2).putExtra("localMediaInfos_output", (Serializable)localObject1);
      ((Intent)localObject2).putExtra("EDITOR_ENTRANCE", 0);
      ((Intent)localObject2).putExtra("IS_FROM_CAPTURE", false);
      localArrayList = this.t;
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        ((Intent)localObject2).putExtra("PUBLISH_SCHEMA_MUSIC_ID", (String)this.t.get(0));
      }
      a(WinkEditorFragment.class.getName(), (Intent)localObject2);
      if ((!paramBoolean.booleanValue()) && (((WinkCirclePhotoListFragment)this.c.get()).h != null))
      {
        paramBoolean = a("em_xsj_next_button");
        a(((WinkCirclePhotoListFragment)this.c.get()).h.findViewById(2131448644), paramBoolean);
      }
      AlbumSelectionData.a().d();
    }
  }
  
  public boolean a(Context paramContext, LocalMediaInfo paramLocalMediaInfo)
  {
    int i1 = a(paramLocalMediaInfo);
    if ((i1 != 0) && (i1 != 2))
    {
      a(paramContext, i1);
      return false;
    }
    return true;
  }
  
  public boolean a(List<LocalMediaInfo> paramList, boolean paramBoolean)
  {
    this.h.clear();
    if (this.c.get() != null)
    {
      if (((WinkCirclePhotoListFragment)this.c.get()).getActivity() == null) {
        return false;
      }
      if (paramList == null)
      {
        this.i.a(paramList);
        if (paramBoolean) {
          this.i.G().post(new WinkCirclePhotoListLogic.3(this));
        }
        return false;
      }
      this.h.addAll(paramList);
      this.i.a(paramList);
      if ((paramBoolean) && (paramList.isEmpty())) {
        this.i.G().post(new WinkCirclePhotoListLogic.4(this));
      }
      if (!this.y)
      {
        this.y = true;
        paramList = (WinkCirclePhotoListFragment)this.c.get();
        if ((paramList != null) && (paramList.getActivity() != null)) {
          d(paramList.getActivity().getIntent());
        }
      }
      return true;
    }
    return false;
  }
  
  public void b(Intent paramIntent)
  {
    Object localObject = this.d.selectedPhotoList;
    HashMap localHashMap1 = this.d.selectedMediaInfoHashMap;
    paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject);
    HashMap localHashMap2 = new HashMap(localHashMap1);
    Iterator localIterator = ((ArrayList)localObject).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localObject = null;
      if (this.d.allMediaInfoHashMap != null) {
        localObject = (LocalMediaInfo)this.d.allMediaInfoHashMap.get(str);
      }
      if (localObject != null)
      {
        localHashMap2.put(str, localObject);
      }
      else
      {
        localObject = (LocalMediaInfo)localHashMap1.get(str);
        if (localObject != null) {
          localHashMap2.put(str, localObject);
        }
      }
    }
    paramIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", localHashMap2);
    paramIntent.putExtra("ALBUM_ID", this.d.albumId);
    paramIntent.putExtra("ALBUM_NAME", this.d.albumName);
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    if (!TextUtils.isEmpty(this.d.albumName))
    {
      if (this.G.equals(this.d.albumName)) {
        return;
      }
      this.G = this.d.albumName;
    }
  }
  
  protected boolean b(LocalMediaInfo paramLocalMediaInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isPicSupport... width:");
    localStringBuilder.append(paramLocalMediaInfo.mediaWidth);
    localStringBuilder.append(" height:");
    localStringBuilder.append(paramLocalMediaInfo.mediaHeight);
    localStringBuilder.append(" SCREEN_WIDTH:");
    localStringBuilder.append(ScreenUtil.SCREEN_WIDTH);
    QLog.d("WinkCirclePhotoListLogic", 1, localStringBuilder.toString());
    return Math.min(paramLocalMediaInfo.mediaWidth, paramLocalMediaInfo.mediaHeight) <= ScreenUtil.SCREEN_WIDTH * 2;
  }
  
  public boolean d()
  {
    return false;
  }
  
  public PhotoCommonBaseData<OtherCommonData> e()
  {
    return this.d;
  }
  
  public PhotoListBaseData f()
  {
    return this.e;
  }
  
  public WinkAlbumLogicData g()
  {
    return this.n;
  }
  
  public void h()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PhotoListLogic close，fragment = ");
      localStringBuilder.append(this.c.get());
      localStringBuilder.append(",PhotoCommonData = ");
      localStringBuilder.append(this.d);
      QLog.d("QQAlbum", 2, localStringBuilder.toString());
    }
    this.d.releaseCommonData();
  }
  
  public String i()
  {
    WeakReference localWeakReference = this.c;
    if (localWeakReference != null)
    {
      if (((WinkCirclePhotoListFragment)localWeakReference.get()).a().booleanValue()) {
        return "2";
      }
      return "1";
    }
    return "";
  }
  
  public void j()
  {
    if (!this.e.z) {
      AlbumThumbManager.getInstance(((WinkCirclePhotoListFragment)this.c.get()).getActivity()).clear();
    }
    h();
  }
  
  public void k()
  {
    if (this.d.selectedPhotoList != null) {
      this.d.selectedPhotoList.clear();
    }
    if (this.d.selectedMediaInfoHashMap != null) {
      this.d.selectedMediaInfoHashMap.clear();
    }
  }
  
  public void l()
  {
    int i1 = this.b;
    if (i1 == 0)
    {
      if (((IAECameraLauncher)QRoute.api(IAECameraLauncher.class)).isCameraResReady())
      {
        this.A = false;
        if (!w()) {
          a(Boolean.valueOf(false));
        }
      }
      else
      {
        m();
      }
    }
    else
    {
      if (i1 == 1)
      {
        o();
        return;
      }
      if (i1 == 2) {
        p();
      }
    }
  }
  
  public void m()
  {
    Object localObject3 = new ArrayList();
    Object localObject4 = this.d.selectedPhotoList.iterator();
    Object localObject1 = "";
    while (((Iterator)localObject4).hasNext())
    {
      localObject2 = (String)((Iterator)localObject4).next();
      LocalMediaInfo localLocalMediaInfo = a(localObject2);
      if (localLocalMediaInfo != null)
      {
        ((ArrayList)localObject3).add(localLocalMediaInfo);
        if (QAlbumUtil.getMediaType(localLocalMediaInfo) == 1) {
          localObject1 = localObject2;
        }
      }
    }
    Object localObject2 = new Intent();
    localObject3 = this.B;
    if (localObject3 != null) {
      ((Intent)localObject2).putExtras((Bundle)localObject3);
    }
    localObject3 = new ArrayList();
    ((ArrayList)localObject3).add(localObject1);
    ((Intent)localObject2).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject3);
    ((Intent)localObject2).putExtra("ae_editor_video_flag", true);
    localObject3 = new HashMap();
    localObject4 = a(localObject1);
    ((LocalMediaInfo)localObject4).isVideoReady = true;
    ((LocalMediaInfo)localObject4).missionID = UUID.randomUUID().toString();
    ((HashMap)localObject3).put(localObject1, localObject4);
    ((Intent)localObject2).putExtra("PeakConstants.selectedMediaInfoHashMap", (Serializable)localObject3);
    ((Intent)localObject2).putExtra("ae_editor_video_export_size_height", c());
    ((Intent)localObject2).putExtra("ae_editor_video_export_size_width", b());
    ((Intent)localObject2).putExtra("qcircle_client_traceid", this.z);
    ((Intent)localObject2).addFlags(268435456);
    ((IPublishLauncher)QRoute.api(IPublishLauncher.class)).launchPublishPage(((WinkCirclePhotoListFragment)this.c.get()).getContext(), (Intent)localObject2);
    ((WinkCirclePhotoListFragment)this.c.get()).getActivity().finish();
  }
  
  protected void n()
  {
    WinkExportManager.a().c();
  }
  
  public void o()
  {
    Object localObject = this.c;
    if ((localObject != null) && (((WeakReference)localObject).get() != null) && (((WinkCirclePhotoListFragment)this.c.get()).getActivity() != null) && (this.d.selectedPhotoList != null) && (!this.d.selectedPhotoList.isEmpty()))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra(QCircleHostConstants._AEEditorConstants.KEY_VIDEO_COVER_PATH(), (String)this.d.selectedPhotoList.get(0));
      ((WinkCirclePhotoListFragment)this.c.get()).getActivity().setResult(-1, (Intent)localObject);
      ((WinkCirclePhotoListFragment)this.c.get()).getActivity().finish();
    }
  }
  
  public void onPhotoListDatasetDurationChanged(int paramInt, LocalMediaInfo paramLocalMediaInfo) {}
  
  public void p()
  {
    Object localObject1 = this.c;
    if ((localObject1 != null) && (((WeakReference)localObject1).get() != null) && (((WinkCirclePhotoListFragment)this.c.get()).getActivity() != null) && (this.d.selectedPhotoList != null) && (!this.d.selectedPhotoList.isEmpty()))
    {
      localObject1 = new ArrayList();
      Object localObject2 = this.d.selectedPhotoList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        LocalMediaInfo localLocalMediaInfo = a((String)((Iterator)localObject2).next());
        if (localLocalMediaInfo != null) {
          ((ArrayList)localObject1).add(localLocalMediaInfo);
        }
      }
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("localMediaInfos", (Serializable)localObject1);
      ((WinkCirclePhotoListFragment)this.c.get()).getActivity().setResult(-1, (Intent)localObject2);
      ((WinkCirclePhotoListFragment)this.c.get()).getActivity().finish();
    }
  }
  
  public void q()
  {
    int i1 = this.b;
    if (i1 == 0)
    {
      if (((IAECameraLauncher)QRoute.api(IAECameraLauncher.class)).isCameraResReady())
      {
        this.A = true;
        if (!w()) {
          a(Boolean.valueOf(true));
        }
        if ((r() != null) && (r().h != null)) {
          a(r().h.findViewById(2131448285), a("em_xsj_auto_video_button"));
        }
      }
      else
      {
        m();
      }
    }
    else if (i1 == 1) {
      o();
    }
  }
  
  public WinkCirclePhotoListFragment r()
  {
    WeakReference localWeakReference = this.c;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      return (WinkCirclePhotoListFragment)this.c.get();
    }
    return null;
  }
  
  public void s()
  {
    WinkCircleAlbumListPart localWinkCircleAlbumListPart = this.j;
    if (localWinkCircleAlbumListPart != null) {
      localWinkCircleAlbumListPart.a(false, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.WinkCirclePhotoListLogic
 * JD-Core Version:    0.7.0.1
 */