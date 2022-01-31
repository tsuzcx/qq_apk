package dov.com.qq.im.ae.play;

import abtq;
import abtr;
import actj;
import akwf;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bcpu;
import bfny;
import biio;
import bija;
import bijb;
import bixx;
import bixy;
import bixz;
import biya;
import biyb;
import biyc;
import biyd;
import biye;
import biyf;
import biyg;
import biyh;
import biyv;
import biyw;
import biyx;
import bizc;
import bizd;
import bizi;
import bizk;
import bizm;
import bizo;
import bizt;
import bjag;
import bjah;
import blce;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivityForPeak;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.facedetect.FaceInfo;
import com.tencent.ttpic.openapi.offlineset.OfflineConfig;
import com.tencent.ttpic.util.CosFunUtil;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.videoshelf.libpag.PagNotSupportSystemException;
import com.tencent.ttpic.videoshelf.model.VideoShelfEngine;
import com.tencent.ttpic.videoshelf.model.edit.NodeGroup;
import com.tencent.ttpic.videoshelf.model.edit.NodeItem;
import com.tencent.ttpic.videoshelf.model.edit.NodeText;
import com.tencent.ttpic.videoshelf.model.template.MaskNodeGroup;
import com.tencent.ttpic.videoshelf.model.template.MaskNodeItem;
import com.tencent.ttpic.videoshelf.model.template.VideoShelfTemplate;
import com.tencent.ttpic.videoshelf.parser.TemplateParser;
import com.tencent.ttpic.videoshelf.utils.TTPTLogger;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Timer;
import vyf;

public class AEVideoShelfEditFragment
  extends PublicBaseFragment
  implements abtr, View.OnClickListener, biyv, biyw, bizc, bizi
{
  private static double jdField_a_of_type_Double = 0.3D;
  private static int jdField_a_of_type_Int = 200;
  private static PowerManager.WakeLock jdField_a_of_type_AndroidOsPowerManager$WakeLock;
  private long jdField_a_of_type_Long;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  bcpu jdField_a_of_type_Bcpu;
  private bizk jdField_a_of_type_Bizk;
  private bizm jdField_a_of_type_Bizm = new biya(this);
  private VideoShelfEngine jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine;
  private VideoShelfTemplate jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate;
  private Boolean jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  private HashSet<ScaleMoveImageViewer> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private List<NodeGroup> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<String, Bitmap> jdField_a_of_type_JavaUtilMap = new HashMap();
  private Timer jdField_a_of_type_JavaUtilTimer = new Timer();
  private double jdField_b_of_type_Double;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private Dialog jdField_b_of_type_AndroidAppDialog;
  private View jdField_b_of_type_AndroidViewView;
  private String jdField_b_of_type_JavaLangString;
  private HashSet<EditTextViewer> jdField_b_of_type_JavaUtilHashSet = new HashSet();
  private List<Bitmap> jdField_b_of_type_JavaUtilList = new ArrayList();
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private HashSet<FaceImageViewer> jdField_c_of_type_JavaUtilHashSet = new HashSet();
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString;
  private int jdField_f_of_type_Int;
  private String jdField_f_of_type_JavaLangString;
  private final String g = "0";
  private final String h = "1";
  private final String i = "2";
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)TypedValue.applyDimension(1, paramFloat, paramContext.getResources().getDisplayMetrics());
  }
  
  private Bitmap a()
  {
    Bitmap localBitmap2;
    if ((this.jdField_b_of_type_Int > 0) && (this.jdField_c_of_type_Int > 0))
    {
      localBitmap2 = Bitmap.createBitmap(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, Bitmap.Config.ARGB_8888);
      if (!BitmapUtils.isLegal(localBitmap2))
      {
        Log.e("AEVideoShelfEditFrag", "CenterView bitmap is null");
        return null;
      }
      Canvas localCanvas = new Canvas(localBitmap2);
      localBitmap1 = localBitmap2;
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.draw(localCanvas);
      }
    }
    for (Bitmap localBitmap1 = localBitmap2;; localBitmap1 = null) {
      return localBitmap1;
    }
  }
  
  private static Bitmap a(RelativeLayout paramRelativeLayout, int paramInt1, int paramInt2)
  {
    if (paramRelativeLayout == null) {
      return null;
    }
    paramRelativeLayout.setDrawingCacheEnabled(true);
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    paramRelativeLayout.draw(new Canvas(localBitmap));
    paramRelativeLayout = Bitmap.createScaledBitmap(localBitmap, paramInt1 / 4, paramInt2 / 4, false);
    localBitmap.recycle();
    return paramRelativeLayout;
  }
  
  private bcpu a()
  {
    bcpu localbcpu = new bcpu(getActivity());
    localbcpu.a(actj.a(50.0F, getActivity().getResources()));
    localbcpu.a(true);
    localbcpu.c(false);
    localbcpu.f(-1);
    localbcpu.e(0);
    localbcpu.d(-15550475);
    localbcpu.g(3);
    localbcpu.jdField_f_of_type_Boolean = true;
    localbcpu.jdField_f_of_type_Int = 2;
    localbcpu.e(true);
    localbcpu.a(new biyb(this));
    return localbcpu;
  }
  
  private NodeItem a(NodeGroup paramNodeGroup, int paramInt)
  {
    paramNodeGroup = paramNodeGroup.nodeItemList.iterator();
    while (paramNodeGroup.hasNext())
    {
      NodeItem localNodeItem = (NodeItem)paramNodeGroup.next();
      if (paramInt == localNodeItem.nodeID) {
        return localNodeItem;
      }
    }
    return null;
  }
  
  private FaceImageViewer a(int paramInt)
  {
    Iterator localIterator = this.jdField_c_of_type_JavaUtilHashSet.iterator();
    while (localIterator.hasNext())
    {
      FaceImageViewer localFaceImageViewer = (FaceImageViewer)localIterator.next();
      if (localFaceImageViewer.a() == paramInt) {
        return localFaceImageViewer;
      }
    }
    return null;
  }
  
  private ScaleMoveImageViewer a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
    while (localIterator.hasNext())
    {
      ScaleMoveImageViewer localScaleMoveImageViewer = (ScaleMoveImageViewer)localIterator.next();
      if (localScaleMoveImageViewer.a() == paramInt) {
        return localScaleMoveImageViewer;
      }
    }
    return null;
  }
  
  /* Error */
  private String a(int paramInt, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: new 320	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 321	java/lang/StringBuilder:<init>	()V
    //   7: aload_0
    //   8: getfield 323	dov/com/qq/im/ae/play/AEVideoShelfEditFragment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: getstatic 332	java/io/File:separator	Ljava/lang/String;
    //   17: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: ldc_w 334
    //   23: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokestatic 340	java/lang/System:currentTimeMillis	()J
    //   29: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   32: ldc_w 345
    //   35: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: iload_1
    //   39: invokevirtual 348	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   42: ldc_w 350
    //   45: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 354	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: astore 4
    //   53: new 329	java/io/File
    //   56: dup
    //   57: aload 4
    //   59: invokespecial 357	java/io/File:<init>	(Ljava/lang/String;)V
    //   62: astore_3
    //   63: aload_3
    //   64: invokevirtual 360	java/io/File:createNewFile	()Z
    //   67: pop
    //   68: new 362	java/io/FileOutputStream
    //   71: dup
    //   72: aload_3
    //   73: invokespecial 365	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   76: astore_3
    //   77: aload_2
    //   78: getstatic 371	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   81: bipush 100
    //   83: aload_3
    //   84: invokevirtual 375	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   87: pop
    //   88: aload_3
    //   89: invokevirtual 378	java/io/FileOutputStream:flush	()V
    //   92: aload_3
    //   93: invokevirtual 381	java/io/FileOutputStream:close	()V
    //   96: aload 4
    //   98: areturn
    //   99: astore 5
    //   101: ldc 177
    //   103: new 320	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 321	java/lang/StringBuilder:<init>	()V
    //   110: ldc_w 383
    //   113: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload 5
    //   118: invokevirtual 384	java/io/IOException:toString	()Ljava/lang/String;
    //   121: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: invokevirtual 354	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokestatic 390	com/tencent/ttpic/videoshelf/utils/TTPTLogger:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: goto -62 -> 68
    //   133: astore_3
    //   134: aload_3
    //   135: invokevirtual 393	java/io/FileNotFoundException:printStackTrace	()V
    //   138: ldc 177
    //   140: new 320	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 321	java/lang/StringBuilder:<init>	()V
    //   147: ldc_w 395
    //   150: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_3
    //   154: invokevirtual 396	java/io/FileNotFoundException:toString	()Ljava/lang/String;
    //   157: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 354	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 390	com/tencent/ttpic/videoshelf/utils/TTPTLogger:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   166: aconst_null
    //   167: astore_3
    //   168: goto -91 -> 77
    //   171: astore_2
    //   172: aload_2
    //   173: invokevirtual 397	java/lang/Exception:printStackTrace	()V
    //   176: ldc 177
    //   178: new 320	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 321	java/lang/StringBuilder:<init>	()V
    //   185: ldc_w 399
    //   188: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: aload_2
    //   192: invokevirtual 400	java/lang/Exception:toString	()Ljava/lang/String;
    //   195: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: invokevirtual 354	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokestatic 390	com/tencent/ttpic/videoshelf/utils/TTPTLogger:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   204: aconst_null
    //   205: areturn
    //   206: astore_2
    //   207: aload_2
    //   208: invokevirtual 401	java/io/IOException:printStackTrace	()V
    //   211: ldc 177
    //   213: new 320	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 321	java/lang/StringBuilder:<init>	()V
    //   220: ldc_w 403
    //   223: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: aload_2
    //   227: invokevirtual 384	java/io/IOException:toString	()Ljava/lang/String;
    //   230: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 354	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokestatic 390	com/tencent/ttpic/videoshelf/utils/TTPTLogger:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   239: goto -147 -> 92
    //   242: astore_2
    //   243: aload_2
    //   244: invokevirtual 401	java/io/IOException:printStackTrace	()V
    //   247: ldc 177
    //   249: new 320	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 321	java/lang/StringBuilder:<init>	()V
    //   256: ldc_w 405
    //   259: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: aload_2
    //   263: invokevirtual 384	java/io/IOException:toString	()Ljava/lang/String;
    //   266: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: invokevirtual 354	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   272: invokestatic 390	com/tencent/ttpic/videoshelf/utils/TTPTLogger:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   275: aload 4
    //   277: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	278	0	this	AEVideoShelfEditFragment
    //   0	278	1	paramInt	int
    //   0	278	2	paramBitmap	Bitmap
    //   62	31	3	localObject1	Object
    //   133	21	3	localFileNotFoundException	java.io.FileNotFoundException
    //   167	1	3	localObject2	Object
    //   51	225	4	str	String
    //   99	18	5	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   63	68	99	java/io/IOException
    //   68	77	133	java/io/FileNotFoundException
    //   77	88	171	java/lang/Exception
    //   88	92	206	java/io/IOException
    //   92	96	242	java/io/IOException
  }
  
  private void a(int paramInt, String paramString)
  {
    b(paramInt, paramString, true);
  }
  
  private void a(int paramInt, String paramString, boolean paramBoolean)
  {
    this.jdField_f_of_type_Int = paramInt;
    FaceImageViewer localFaceImageViewer = a(this.jdField_f_of_type_Int);
    if (localFaceImageViewer == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (TextUtils.isEmpty(paramString));
        Bitmap localBitmap2 = (Bitmap)this.jdField_a_of_type_JavaUtilMap.get(paramString);
        localBitmap1 = localBitmap2;
        if (localBitmap2 == null)
        {
          localBitmap1 = BitmapUtils.decodeSampleBitmap(getActivity(), paramString, this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoWidth(), this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoHeight());
          this.jdField_a_of_type_JavaUtilMap.put(paramString, localBitmap1);
        }
      } while (!BitmapUtils.isLegal(localBitmap1));
      Bitmap localBitmap1 = bizo.a(localBitmap1, paramString);
      paramString = localBitmap1;
      if (localBitmap1.getWidth() == 1)
      {
        paramString = localBitmap1;
        if (localBitmap1.getHeight() == 1) {
          paramString = BitmapUtils.scaleBitmap(localBitmap1, 2.0F, true);
        }
      }
      localFaceImageViewer.setNodeBitmap(paramString);
      localFaceImageViewer.setImageBitmap(paramString);
      localFaceImageViewer.setImageSelected(true);
      localFaceImageViewer.setMovable(true);
      localFaceImageViewer.setScaleType(ImageView.ScaleType.MATRIX);
      localFaceImageViewer.c();
      biyx.a(new AEVideoShelfEditFragment.9(this, localFaceImageViewer, paramString), false, "");
    } while (!paramBoolean);
    d(localFaceImageViewer.b());
  }
  
  public static void a(Activity paramActivity, int paramInt1, String paramString1, String paramString2, String paramString3, ArrayList<String> paramArrayList, int paramInt2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("MaterialPath", paramString1);
    localIntent.putExtra("MaterialId", paramString2);
    localIntent.putExtra("MaterialName", paramString3);
    localIntent.putStringArrayListExtra("PhotoList", paramArrayList);
    localIntent.putExtra("jump_in_from", paramInt2);
    abtq.a(paramActivity, localIntent, PublicFragmentActivityForPeak.class, AEVideoShelfEditFragment.class, paramInt1);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, ArrayList<String> paramArrayList, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("MaterialPath", paramString2);
    localIntent.putExtra("MaterialId", paramString3);
    localIntent.putExtra("MaterialName", paramString4);
    localIntent.putExtra("loc_play_show_tab_name", paramString1);
    localIntent.putExtra("VIDEO_STORY_FROM_TYPE", AETemplateInfoFragment.a(paramContext));
    localIntent.putStringArrayListExtra("PhotoList", paramArrayList);
    localIntent.putExtra("jump_in_from", paramInt);
    abtq.a(paramContext, localIntent, PublicFragmentActivityForPeak.class, AEVideoShelfEditFragment.class);
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      jdField_a_of_type_AndroidOsPowerManager$WakeLock = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(536870918, AEVideoShelfEditFragment.class.getSimpleName());
      jdField_a_of_type_AndroidOsPowerManager$WakeLock.acquire();
      TTPTLogger.i("AEVideoShelfEditFrag", "keepScreenOn!");
      return;
    }
    if (jdField_a_of_type_AndroidOsPowerManager$WakeLock != null)
    {
      jdField_a_of_type_AndroidOsPowerManager$WakeLock.release();
      jdField_a_of_type_AndroidOsPowerManager$WakeLock = null;
    }
    TTPTLogger.i("AEVideoShelfEditFrag", "keepScreenOff!");
  }
  
  private void a(Intent paramIntent)
  {
    if (this.jdField_e_of_type_Int == 3)
    {
      getActivity().setResult(-1, paramIntent);
      getActivity().finish();
      return;
    }
    AEVideoShelfPreviewFragment.a(getActivity(), paramIntent, 2);
  }
  
  private void a(View paramView)
  {
    int j = ((NodeGroup)this.jdField_a_of_type_JavaUtilList.get(this.jdField_d_of_type_Int)).nodeGroupID;
    if (this.jdField_a_of_type_JavaUtilHashSet != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
      while (localIterator.hasNext())
      {
        ScaleMoveImageViewer localScaleMoveImageViewer = (ScaleMoveImageViewer)localIterator.next();
        if (localScaleMoveImageViewer.b() == j) {
          localScaleMoveImageViewer.onClick(paramView);
        }
      }
    }
  }
  
  private void a(ViewGroup paramViewGroup, int paramInt)
  {
    NodeGroup localNodeGroup = (NodeGroup)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    paramViewGroup.removeAllViews();
    Object localObject1 = this.jdField_a_of_type_JavaUtilHashSet.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ScaleMoveImageViewer)((Iterator)localObject1).next();
      if ((((ScaleMoveImageViewer)localObject2).b() == localNodeGroup.nodeGroupID) && (((ScaleMoveImageViewer)localObject2).a().zIndex < 10000))
      {
        paramViewGroup.addView((View)localObject2);
        a((ImageView)localObject2, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
      }
    }
    localObject1 = this.jdField_b_of_type_JavaUtilHashSet.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (EditTextViewer)((Iterator)localObject1).next();
      if ((((EditTextViewer)localObject2).a() == localNodeGroup.nodeGroupID) && (((EditTextViewer)localObject2).a().zIndex < 10000))
      {
        paramViewGroup.addView((View)localObject2);
        a((ImageView)localObject2, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
      }
    }
    localObject1 = this.jdField_c_of_type_JavaUtilHashSet.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (FaceImageViewer)((Iterator)localObject1).next();
      if ((((FaceImageViewer)localObject2).b() == localNodeGroup.nodeGroupID) && (((FaceImageViewer)localObject2).a().zIndex < 10000))
      {
        paramViewGroup.addView((View)localObject2);
        a((ImageView)localObject2, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
      }
    }
    localObject1 = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getMaterialPath() + File.separator + localNodeGroup.nodeDefaultMaskCoverImage;
    localObject1 = bizo.a(BitmapUtils.decodeSampleBitmap(getActivity(), (String)localObject1, this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoWidth(), this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoHeight()), (String)localObject1);
    Object localObject2 = new ImageView(getActivity());
    ((ImageView)localObject2).setImageBitmap((Bitmap)localObject1);
    paramViewGroup.addView((View)localObject2);
    int j;
    float f1;
    if (localObject1 != null)
    {
      paramInt = ((Bitmap)localObject1).getWidth();
      j = ((Bitmap)localObject1).getHeight();
      f1 = paramInt / j;
      if (f1 >= this.jdField_b_of_type_Int / this.jdField_b_of_type_Int) {
        break label550;
      }
      j = this.jdField_b_of_type_Int;
      paramInt = (int)(this.jdField_b_of_type_Int / f1);
    }
    for (;;)
    {
      ((ImageView)localObject2).measure(View.MeasureSpec.makeMeasureSpec(j, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt, 1073741824));
      ((ImageView)localObject2).layout((this.jdField_b_of_type_Int - j) / 2, (this.jdField_c_of_type_Int - paramInt) / 2, (j + this.jdField_b_of_type_Int) / 2, (paramInt + this.jdField_c_of_type_Int) / 2);
      localObject1 = this.jdField_a_of_type_JavaUtilHashSet.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ScaleMoveImageViewer)((Iterator)localObject1).next();
        if ((((ScaleMoveImageViewer)localObject2).b() == localNodeGroup.nodeGroupID) && (((ScaleMoveImageViewer)localObject2).a().zIndex >= 10000))
        {
          paramViewGroup.addView((View)localObject2);
          a((ImageView)localObject2, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
        }
      }
      label550:
      paramInt = this.jdField_c_of_type_Int;
      j = (int)(this.jdField_c_of_type_Int * f1);
    }
    localObject1 = this.jdField_b_of_type_JavaUtilHashSet.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (EditTextViewer)((Iterator)localObject1).next();
      if ((((EditTextViewer)localObject2).a() == localNodeGroup.nodeGroupID) && (((EditTextViewer)localObject2).a().zIndex >= 10000))
      {
        paramViewGroup.addView((View)localObject2);
        a((ImageView)localObject2, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
      }
    }
    localObject1 = this.jdField_c_of_type_JavaUtilHashSet.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (FaceImageViewer)((Iterator)localObject1).next();
      if ((((FaceImageViewer)localObject2).b() == localNodeGroup.nodeGroupID) && (((FaceImageViewer)localObject2).a().zIndex >= 10000))
      {
        paramViewGroup.addView((View)localObject2);
        a((ImageView)localObject2, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
      }
    }
  }
  
  private void a(ImageView paramImageView, int paramInt1, int paramInt2)
  {
    NodeItem localNodeItem = null;
    int j;
    int k;
    if ((paramImageView instanceof ScaleMoveImageViewer))
    {
      localNodeItem = ((ScaleMoveImageViewer)paramImageView).a();
      if (localNodeItem != null)
      {
        j = (int)(localNodeItem.maskRect.left * paramInt1);
        k = (int)(localNodeItem.maskRect.top * paramInt2);
        paramInt1 = (int)(localNodeItem.maskRect.right * paramInt1);
        paramInt2 = (int)(localNodeItem.maskRect.bottom * paramInt2);
        paramImageView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1 - j, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2 - k, 1073741824));
        paramImageView.layout(j, k, paramInt1, paramInt2);
        if (!(paramImageView instanceof ScaleMoveImageViewer)) {
          break label179;
        }
        ((ScaleMoveImageViewer)paramImageView).a(Math.abs(paramInt1 - j), Math.abs(paramInt2 - k));
      }
    }
    label179:
    do
    {
      return;
      if ((paramImageView instanceof FaceImageViewer))
      {
        localNodeItem = ((FaceImageViewer)paramImageView).a();
        break;
      }
      if (!(paramImageView instanceof EditTextViewer)) {
        break;
      }
      localNodeItem = ((EditTextViewer)paramImageView).a();
      break;
      if ((paramImageView instanceof FaceImageViewer))
      {
        ((FaceImageViewer)paramImageView).a(Math.abs(paramInt1 - j), Math.abs(paramInt2 - k));
        return;
      }
    } while (!(paramImageView instanceof EditTextViewer));
    ((EditTextViewer)paramImageView).a(Math.abs(paramInt1 - j), Math.abs(paramInt2 - k));
    paramInt1 = getResources().getDimensionPixelSize(2131296593);
    ((EditTextViewer)paramImageView).setActionBarHeight(paramInt1);
  }
  
  private void a(RelativeLayout paramRelativeLayout, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null)
    {
      bizk localbizk = (bizk)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getAdapter();
      paramRelativeLayout = a(paramRelativeLayout, paramRelativeLayout.getWidth(), paramRelativeLayout.getHeight());
      if ((localbizk != null) && (BitmapUtils.isLegal(paramRelativeLayout)))
      {
        localbizk.a(paramInt, paramRelativeLayout);
        localbizk.b();
      }
    }
  }
  
  private void a(NodeGroup paramNodeGroup)
  {
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
    if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate == null) {
      return;
    }
    paramNodeGroup = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getMaterialPath() + File.separator + paramNodeGroup.nodeDefaultMaskCoverImage;
    this.jdField_a_of_type_AndroidGraphicsBitmap = bizo.a(BitmapUtils.decodeSampleBitmap(getActivity(), paramNodeGroup, this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoWidth(), this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoHeight()), paramNodeGroup);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
  }
  
  private void a(FaceImageViewer paramFaceImageViewer, Bitmap paramBitmap)
  {
    paramBitmap = biyx.a(paramBitmap, 0.1666666666666667D);
    int j = paramBitmap.getFaceCount();
    Object localObject1 = new ArrayList();
    paramBitmap = paramBitmap.getFaceInfoList().iterator();
    Object localObject2;
    while (paramBitmap.hasNext())
    {
      localObject2 = (FaceInfo)paramBitmap.next();
      CosFunUtil.scale(((FaceInfo)localObject2).points, 1.0D / 0.1666666666666667D);
      FaceOffUtil.getFullCoords(((FaceInfo)localObject2).points, 1.5F);
      Object localObject3 = (PointF)((FaceInfo)localObject2).points.get(99);
      PointF localPointF = (PointF)((FaceInfo)localObject2).points.get(103);
      localObject3 = new bizd((int)((PointF)localObject3).x, (int)((PointF)localObject3).y, (int)localPointF.x, (int)localPointF.y);
      ((bizd)localObject3).jdField_a_of_type_ArrayOfFloat = ((FaceInfo)localObject2).angles;
      ((List)localObject1).add(localObject3);
    }
    bjah.a("AEVideoShelfEditFrag", "[PlayShow] onFaceImageChanged faceCount = " + j);
    if (j >= 1)
    {
      paramBitmap = (bizd)((List)localObject1).get(0);
      localObject2 = ((List)localObject1).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = (bizd)((Iterator)localObject2).next();
        if (((bizd)localObject1).a() <= paramBitmap.a()) {
          break label284;
        }
        paramBitmap = (Bitmap)localObject1;
      }
    }
    label284:
    for (;;)
    {
      break;
      bfny.a(new AEVideoShelfEditFragment.10(this, paramFaceImageViewer, paramBitmap));
      return;
      bfny.a(new AEVideoShelfEditFragment.11(this));
      return;
    }
  }
  
  private void a(FaceImageViewer paramFaceImageViewer, bizd parambizd)
  {
    float f1 = 1.0F;
    float f5 = paramFaceImageViewer.getWidth();
    float f6 = paramFaceImageViewer.getHeight();
    float f2 = (float)Math.toDegrees(parambizd.jdField_a_of_type_ArrayOfFloat[2]);
    float f3 = f5 / 2.0F;
    float f4 = (parambizd.jdField_a_of_type_AndroidGraphicsRect.left + parambizd.jdField_a_of_type_AndroidGraphicsRect.right) / 2;
    f6 /= 2.0F;
    float f7 = (parambizd.jdField_a_of_type_AndroidGraphicsRect.top + parambizd.jdField_a_of_type_AndroidGraphicsRect.bottom) / 2;
    float f8 = parambizd.jdField_a_of_type_AndroidGraphicsRect.width();
    if (f8 > 0.0F) {
      f1 = f5 / f8;
    }
    paramFaceImageViewer.a(f1, f2 * 1.0F, f3 - f4, f6 - f7);
  }
  
  private void a(String paramString)
  {
    Object localObject = getActivity();
    if ((localObject != null) && (!((FragmentActivity)localObject).isFinishing()))
    {
      if (this.jdField_a_of_type_AndroidAppDialog == null)
      {
        this.jdField_a_of_type_AndroidAppDialog = new Dialog((Context)localObject, 2131755791);
        this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
        this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
        this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559386);
      }
      localObject = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371557);
      if (TextUtils.isEmpty(paramString)) {
        break label98;
      }
      ((TextView)localObject).setText(paramString);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidAppDialog.show();
      return;
      label98:
      ((TextView)localObject).setText(2131695129);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      Log.i("AEVideoShelfEditFrag", "已经合成完视频，不进行实时预览。");
      TTPTLogger.i("AEVideoShelfEditFrag", "已经合成完视频，不进行实时预览。");
      if ((this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate == null) || (this.jdField_f_of_type_JavaLangString == null)) {
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("from", true);
      localIntent.putExtra("MaterialId", this.jdField_d_of_type_JavaLangString);
      localIntent.putExtra("FinalVideoPath", this.jdField_f_of_type_JavaLangString);
      localIntent.putExtra("usePagPreview", paramBoolean);
      localIntent.putExtra("MaterialPath", this.jdField_c_of_type_JavaLangString);
      localIntent.putExtra("MaterialName", this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoName());
      localIntent.putStringArrayListExtra("PhotoList", this.jdField_a_of_type_JavaUtilArrayList);
      localIntent.putExtra("loc_play_show_tab_name", this.jdField_e_of_type_JavaLangString);
      localIntent.putExtra("loc_play_show_material_id", this.jdField_d_of_type_JavaLangString);
      localIntent.putExtra("VIDEO_STORY_FROM_TYPE", AETemplateInfoFragment.a(getActivity()));
      localIntent.putExtra("isNeedEditButton", true);
      a(localIntent);
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
      return;
    }
    r();
  }
  
  private boolean a()
  {
    Object localObject4 = null;
    int m = 0;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
    Object localObject2 = null;
    int k = 0;
    Object localObject3;
    Object localObject1;
    int j;
    if (localIterator.hasNext())
    {
      localObject3 = (ScaleMoveImageViewer)localIterator.next();
      localObject1 = localObject2;
      j = k;
      if (!((ScaleMoveImageViewer)localObject3).a())
      {
        if (localObject2 != null) {
          break label90;
        }
        localObject1 = localObject3;
        j = 1;
      }
    }
    label192:
    for (;;)
    {
      localObject2 = localObject1;
      k = j;
      if (j != 0) {
        break;
      }
      ((ScaleMoveImageViewer)localObject3).a();
      localObject2 = localObject1;
      k = j;
      break;
      label90:
      if (localObject2.b() > ((ScaleMoveImageViewer)localObject3).b())
      {
        localObject1 = localObject3;
        j = 1;
        continue;
        localIterator = this.jdField_c_of_type_JavaUtilHashSet.iterator();
        if (localIterator.hasNext())
        {
          localObject3 = (FaceImageViewer)localIterator.next();
          localObject1 = localObject4;
          j = m;
          if (!((FaceImageViewer)localObject3).a())
          {
            if (localObject4 != null) {
              break label192;
            }
            localObject1 = localObject3;
            j = 1;
          }
        }
        for (;;)
        {
          localObject4 = localObject1;
          m = j;
          if (j != 0) {
            break;
          }
          ((FaceImageViewer)localObject3).a();
          localObject4 = localObject1;
          m = j;
          break;
          if (localObject4.b() > ((FaceImageViewer)localObject3).b())
          {
            localObject1 = localObject3;
            j = 1;
            continue;
            if ((k != 0) && (localObject2 != null)) {}
            for (j = Math.max(localObject2.b(), -1);; j = -1)
            {
              if ((m != 0) && (localObject4 != null)) {
                Math.max(localObject4.b(), j);
              }
              return true;
            }
          }
          else
          {
            j = 1;
            localObject1 = localObject4;
          }
        }
      }
      else
      {
        j = 1;
        localObject1 = localObject2;
      }
    }
  }
  
  static boolean a(@NonNull Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 23) {
      return true;
    }
    return akwf.a(paramContext);
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_Bcpu == null) {
      return;
    }
    this.jdField_a_of_type_Bcpu.a();
    this.jdField_a_of_type_Bcpu.c(paramInt);
    this.jdField_a_of_type_Bcpu.b(true);
    this.jdField_a_of_type_Bcpu.d(false);
    this.jdField_a_of_type_Bcpu.a(paramInt + "%");
  }
  
  private void b(int paramInt, String paramString, boolean paramBoolean)
  {
    ScaleMoveImageViewer localScaleMoveImageViewer = a(paramInt);
    if (localScaleMoveImageViewer == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (TextUtils.isEmpty(paramString));
        Bitmap localBitmap2 = (Bitmap)this.jdField_a_of_type_JavaUtilMap.get(paramString);
        localBitmap1 = localBitmap2;
        if (localBitmap2 == null)
        {
          localBitmap1 = BitmapUtils.decodeSampleBitmap(getActivity(), paramString, this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoWidth(), this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoHeight());
          this.jdField_a_of_type_JavaUtilMap.put(paramString, localBitmap1);
        }
      } while (!BitmapUtils.isLegal(localBitmap1));
      Bitmap localBitmap1 = bizo.a(localBitmap1, paramString);
      paramString = localBitmap1;
      if (localBitmap1.getWidth() == 1)
      {
        paramString = localBitmap1;
        if (localBitmap1.getHeight() == 1) {
          paramString = BitmapUtils.scaleBitmap(localBitmap1, 2.0F, true);
        }
      }
      localScaleMoveImageViewer.setNodeBitmap(paramString);
      localScaleMoveImageViewer.setImageBitmap(paramString);
      localScaleMoveImageViewer.setImageSelected(true);
      localScaleMoveImageViewer.setMovable(true);
      localScaleMoveImageViewer.c();
    } while (!paramBoolean);
    d(localScaleMoveImageViewer.b());
  }
  
  private static void b(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt3, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt4, 1073741824));
    paramView.layout(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
  }
  
  private boolean b()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate == null) {
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getPagFileName() != null) && (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getPagFilePath() != null) && (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getPreviewVideoType() == 1) && (!OfflineConfig.isNotSuptPagRealTime())) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  private void c(int paramInt)
  {
    NodeGroup localNodeGroup = (NodeGroup)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
    paramInt = 0;
    Object localObject;
    if (localIterator.hasNext())
    {
      localObject = (ScaleMoveImageViewer)localIterator.next();
      if ((((ScaleMoveImageViewer)localObject).b() != localNodeGroup.nodeGroupID) || (((ScaleMoveImageViewer)localObject).a().zIndex >= 10000)) {
        break label462;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject);
      paramInt = 1;
    }
    label462:
    for (;;)
    {
      break;
      localIterator = this.jdField_b_of_type_JavaUtilHashSet.iterator();
      while (localIterator.hasNext())
      {
        localObject = (EditTextViewer)localIterator.next();
        if ((((EditTextViewer)localObject).a() == localNodeGroup.nodeGroupID) && (((EditTextViewer)localObject).a().zIndex < 10000)) {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject);
        }
      }
      localIterator = this.jdField_c_of_type_JavaUtilHashSet.iterator();
      while (localIterator.hasNext())
      {
        localObject = (FaceImageViewer)localIterator.next();
        if ((((FaceImageViewer)localObject).b() == localNodeGroup.nodeGroupID) && (((FaceImageViewer)localObject).a().zIndex < 10000)) {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject);
        }
      }
      a(localNodeGroup);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView);
      localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
      while (localIterator.hasNext())
      {
        localObject = (ScaleMoveImageViewer)localIterator.next();
        if ((((ScaleMoveImageViewer)localObject).b() == localNodeGroup.nodeGroupID) && (((ScaleMoveImageViewer)localObject).a().zIndex >= 10000))
        {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject);
          paramInt = 1;
        }
      }
      localIterator = this.jdField_b_of_type_JavaUtilHashSet.iterator();
      while (localIterator.hasNext())
      {
        localObject = (EditTextViewer)localIterator.next();
        if ((((EditTextViewer)localObject).a() == localNodeGroup.nodeGroupID) && (((EditTextViewer)localObject).a().zIndex >= 10000)) {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject);
        }
      }
      localIterator = this.jdField_c_of_type_JavaUtilHashSet.iterator();
      while (localIterator.hasNext())
      {
        localObject = (FaceImageViewer)localIterator.next();
        if ((((FaceImageViewer)localObject).b() == localNodeGroup.nodeGroupID) && (((FaceImageViewer)localObject).a().zIndex >= 10000)) {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject);
        }
      }
      if (paramInt != 0)
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        return;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      return;
    }
  }
  
  private void d(int paramInt)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.postDelayed(new AEVideoShelfEditFragment.19(this, paramInt), 100L);
  }
  
  private void e(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null)
    {
      bizk localbizk = (bizk)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getAdapter();
      Bitmap localBitmap = a();
      if ((localbizk != null) && (BitmapUtils.isLegal(localBitmap)))
      {
        localbizk.a(paramInt, localBitmap);
        localbizk.b();
      }
    }
  }
  
  private void f()
  {
    Window localWindow = getActivity().getWindow();
    if (localWindow != null) {
      localWindow.setSoftInputMode(48);
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidViewView = getActivity().findViewById(2131362984);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)getActivity().findViewById(2131363638));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131689799);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView = getActivity().findViewById(2131365469);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)getActivity().findViewById(2131364007));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)getActivity().findViewById(2131363371));
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(getActivity());
    localLinearLayoutManager.setOrientation(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new biyh(this, a(getActivity(), 12.0F)));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.getViewTreeObserver().addOnGlobalLayoutListener(new bixx(this));
    h();
  }
  
  @TargetApi(14)
  private void h()
  {
    this.jdField_b_of_type_AndroidAppDialog = new Dialog(getActivity());
    Object localObject = this.jdField_b_of_type_AndroidAppDialog.getWindow();
    if (localObject != null)
    {
      ((Window)localObject).setBackgroundDrawable(new ColorDrawable());
      if (Build.VERSION.SDK_INT >= 14) {
        ((Window)localObject).setDimAmount(0.0F);
      }
    }
    this.jdField_b_of_type_AndroidAppDialog.requestWindowFeature(1);
    this.jdField_b_of_type_AndroidAppDialog.setContentView(2131561434);
    localObject = (ImageView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131371995);
    this.jdField_a_of_type_Bcpu = a();
    ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_Bcpu);
    ((TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131370452)).setText(2131689813);
    this.jdField_b_of_type_AndroidAppDialog.setCancelable(true);
    this.jdField_b_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
    this.jdField_b_of_type_AndroidAppDialog.setOnCancelListener(new bixz(this));
    this.jdField_a_of_type_Bcpu.c(0);
  }
  
  private void i()
  {
    if (this.jdField_b_of_type_AndroidAppDialog != null) {
      this.jdField_b_of_type_AndroidAppDialog.show();
    }
  }
  
  private void j()
  {
    if (this.jdField_b_of_type_AndroidAppDialog != null) {
      this.jdField_b_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  private void k()
  {
    Intent localIntent = getActivity().getIntent();
    if (localIntent == null) {
      return;
    }
    this.jdField_e_of_type_Int = localIntent.getIntExtra("jump_in_from", 0);
    this.jdField_e_of_type_JavaLangString = localIntent.getStringExtra("loc_play_show_tab_name");
    this.jdField_c_of_type_JavaLangString = localIntent.getStringExtra("MaterialPath");
    this.jdField_d_of_type_JavaLangString = localIntent.getStringExtra("MaterialId");
    this.jdField_a_of_type_JavaUtilArrayList = localIntent.getStringArrayListExtra("PhotoList");
    this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate = TemplateParser.parse(getActivity(), this.jdField_c_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate == null)
    {
      TTPTLogger.w("AEVideoShelfEditFrag", "parse template Error!");
      return;
    }
    try
    {
      this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine = new VideoShelfEngine(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVersion());
      if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine == null)
      {
        TTPTLogger.w("AEVideoShelfEditFrag", "init Engine Error!");
        return;
      }
    }
    catch (PagNotSupportSystemException localPagNotSupportSystemException)
    {
      for (;;)
      {
        this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine = null;
        TTPTLogger.e("AEVideoShelfEditFrag", localPagNotSupportSystemException.getMessage());
        bfny.a(new AEVideoShelfEditFragment.4(this), 2000L);
      }
      new biyc(this).execute(new Void[0]);
    }
  }
  
  private void l()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {}
    for (;;)
    {
      return;
      int j = 0;
      while (j < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        String str = (String)this.jdField_a_of_type_JavaUtilArrayList.get(j);
        this.jdField_a_of_type_JavaUtilMap.put(str, BitmapUtils.decodeSampleBitmap(getActivity(), str, this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoWidth(), this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoHeight()));
        j += 1;
      }
    }
  }
  
  private void m()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getActivity());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate == null) {}
    for (;;)
    {
      return;
      int j = 0;
      while (j < this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getNodeGroupList().size())
      {
        Object localObject1 = (MaskNodeGroup)this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getNodeGroupList().get(j);
        NodeGroup localNodeGroup = new NodeGroup();
        localNodeGroup.nodeCoverImage = ((MaskNodeGroup)localObject1).getNodeGroupCoverImage();
        localNodeGroup.nodeGroupID = ((MaskNodeGroup)localObject1).getNodeGroupID();
        localNodeGroup.nodeDefaultMaskCoverImage = ((MaskNodeGroup)localObject1).getNodeGroupMaskImage();
        localObject1 = ((MaskNodeGroup)localObject1).getNodeList();
        localNodeGroup.nodeItemList = new ArrayList();
        int k = 0;
        if (k < ((List)localObject1).size())
        {
          Object localObject2 = (MaskNodeItem)((List)localObject1).get(k);
          NodeItem localNodeItem = new NodeItem();
          localNodeItem.nodeID = ((MaskNodeItem)localObject2).getNodeID();
          Object localObject3 = ((MaskNodeItem)localObject2).getNodeDefaultMaskCoverImage();
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            if (((MaskNodeItem)localObject2).getType() == 1) {
              localNodeItem.coverURL = null;
            }
          }
          for (;;)
          {
            localObject3 = ((MaskNodeItem)localObject2).getMaskRect();
            localNodeItem.maskRect.set(localObject3[0], localObject3[1], localObject3[0] + localObject3[2], localObject3[1] + localObject3[3]);
            localNodeItem.once = true;
            localNodeItem.type = ((MaskNodeItem)localObject2).getType();
            localNodeItem.nodeGroupID = ((MaskNodeItem)localObject2).getNodeGroupID();
            localNodeItem.zIndex = ((MaskNodeItem)localObject2).getZIndex();
            localNodeItem.indexLayerForPag = ((MaskNodeItem)localObject2).getIndexLayerForPag();
            localNodeItem.nodeTextMaxCount = ((MaskNodeItem)localObject2).getNodeTextMaxCount();
            if (!TextUtils.isEmpty(localNodeItem.coverURL))
            {
              String str = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getMaterialPath() + File.separator + localNodeItem.coverURL;
              localNodeItem.bitmap = BitmapUtils.decodeSampleBitmap(getActivity(), str, this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoWidth(), this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoHeight());
              localNodeItem.bitmap = bizo.a(localNodeItem.bitmap, str);
            }
            if (((MaskNodeItem)localObject2).getNodeTextGroup() != null)
            {
              localNodeItem.nodeTextGroup.copyFrom(((MaskNodeItem)localObject2).getNodeTextGroup());
              if (TextUtils.isEmpty(localNodeItem.nodeTextGroup.fmtstr))
              {
                localNodeItem.nodeTextGroup.fmtstr = "请输入文字";
                if ((localNodeItem.type == 1) && (localNodeItem.bitmap != null) && (!localNodeItem.bitmap.isRecycled()))
                {
                  localNodeItem.bitmap.recycle();
                  localNodeItem.bitmap = null;
                }
              }
              if ((TextUtils.isEmpty(localNodeItem.coverURL)) && (localNodeItem.type == 1) && (localNodeItem.bitmap != null) && (!localNodeItem.bitmap.isRecycled()))
              {
                localNodeItem.bitmap.recycle();
                localNodeItem.bitmap = null;
              }
              localNodeItem.nodeTextGroup.width = ((int)(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoWidth() * localObject3[2]));
              localObject2 = localNodeItem.nodeTextGroup;
              float f1 = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoHeight();
              ((NodeText)localObject2).height = ((int)(localObject3[3] * f1));
              localNodeItem.nodeTextGroup.fontSize = (localNodeItem.nodeTextGroup.fontSize * this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoWidth() / 720.0F);
            }
            this.jdField_b_of_type_JavaUtilList.add(localNodeItem.bitmap);
            localNodeGroup.nodeItemList.add(localNodeItem);
            k += 1;
            break;
            localNodeItem.coverURL = localNodeGroup.nodeDefaultMaskCoverImage;
            continue;
            localNodeItem.coverURL = ((String)localObject3);
          }
        }
        this.jdField_a_of_type_JavaUtilList.add(localNodeGroup);
        j += 1;
      }
    }
  }
  
  private void o()
  {
    this.jdField_a_of_type_AndroidUtilSparseIntArray.clear();
    Iterator localIterator1 = this.jdField_a_of_type_JavaUtilList.iterator();
    int j = 0;
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((NodeGroup)localIterator1.next()).nodeItemList.iterator();
      while (localIterator2.hasNext())
      {
        NodeItem localNodeItem = (NodeItem)localIterator2.next();
        Object localObject;
        if (localNodeItem.type == 0)
        {
          localObject = new ScaleMoveImageViewer(getActivity());
          ((ScaleMoveImageViewer)localObject).getViewTreeObserver().addOnGlobalLayoutListener(new biyd(this, (ScaleMoveImageViewer)localObject, localNodeItem));
          ((ScaleMoveImageViewer)localObject).setOnSaveScrollInfoListener(this);
          ((ScaleMoveImageViewer)localObject).setNodeInfo(localNodeItem);
          ((ScaleMoveImageViewer)localObject).setMovable(false);
          ((ScaleMoveImageViewer)localObject).setImageSelected(false);
          this.jdField_a_of_type_JavaUtilHashSet.add(localObject);
          if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (j < this.jdField_a_of_type_JavaUtilArrayList.size()))
          {
            b(localNodeItem.nodeID, (String)this.jdField_a_of_type_JavaUtilArrayList.get(j), false);
            this.jdField_a_of_type_AndroidUtilSparseIntArray.put(localNodeItem.nodeID, j);
            j += 1;
          }
        }
        else
        {
          if (localNodeItem.type == 1)
          {
            localObject = new EditTextViewer(getActivity());
            ((EditTextViewer)localObject).getViewTreeObserver().addOnGlobalLayoutListener(new biye(this, (EditTextViewer)localObject, localNodeItem));
            ((EditTextViewer)localObject).setOnSaveTextInfoListener(this);
            ((EditTextViewer)localObject).setOnDownloadDialogListener(this);
            ((EditTextViewer)localObject).setNodeInfo(localNodeItem);
            if (localNodeItem.bitmap != null) {
              ((EditTextViewer)localObject).setImageBitmap(localNodeItem.bitmap);
            }
            for (;;)
            {
              ((EditTextViewer)localObject).setNodeBitmap(localNodeItem.bitmap);
              ((EditTextViewer)localObject).setTextSelected(true);
              ((EditTextViewer)localObject).setMaterialId(this.jdField_d_of_type_JavaLangString);
              this.jdField_b_of_type_JavaUtilHashSet.add(localObject);
              break;
              Bitmap localBitmap = ((EditTextViewer)localObject).a();
              if ((localBitmap != null) && (!localBitmap.isRecycled()))
              {
                ((EditTextViewer)localObject).setImageBitmap(localBitmap);
                localNodeItem.bitmap = localBitmap;
                ((EditTextViewer)localObject).setImageBitmap(localNodeItem.bitmap);
              }
            }
          }
          if (localNodeItem.type == 2)
          {
            localObject = new FaceImageViewer(getActivity());
            ((FaceImageViewer)localObject).getViewTreeObserver().addOnGlobalLayoutListener(new biyf(this, (FaceImageViewer)localObject, localNodeItem));
            ((FaceImageViewer)localObject).setOnSaveScrollInfoListener(this);
            ((FaceImageViewer)localObject).setNodeInfo(localNodeItem);
            ((FaceImageViewer)localObject).setMovable(false);
            ((FaceImageViewer)localObject).setImageSelected(false);
            this.jdField_c_of_type_JavaUtilHashSet.add(localObject);
            if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (j < this.jdField_a_of_type_JavaUtilArrayList.size()))
            {
              a(localNodeItem.nodeID, (String)this.jdField_a_of_type_JavaUtilArrayList.get(j), false);
              this.jdField_a_of_type_AndroidUtilSparseIntArray.put(localNodeItem.nodeID, j);
              j += 1;
            }
          }
        }
      }
    }
  }
  
  private void p()
  {
    Object localObject1 = new File(this.jdField_a_of_type_JavaLangString);
    if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
    {
      localObject1 = ((File)localObject1).list();
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        int k = localObject1.length;
        int j = 0;
        while (j < k)
        {
          Object localObject2 = localObject1[j];
          localObject2 = new File(this.jdField_a_of_type_JavaLangString, (String)localObject2);
          if (((File)localObject2).exists()) {
            ((File)localObject2).delete();
          }
          j += 1;
        }
      }
    }
  }
  
  private void q()
  {
    if (a())
    {
      if (!b()) {
        s();
      }
    }
    else {
      return;
    }
    a(true);
  }
  
  private void r()
  {
    Log.i("AEVideoShelfEditFrag", "未合成视频，将直接实时预览。");
    TTPTLogger.i("AEVideoShelfEditFrag", "未合成视频，将直接实时预览。");
    if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate == null) {
      return;
    }
    new bixy(this).execute(new Void[0]);
  }
  
  private void s()
  {
    if ((this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate == null) || (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine.setVideoFrameItemList(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getFrameList());
    this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine.setNodeGroupItemList(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine.setVideoTemplateType(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoTemplateType());
    String str = null;
    switch (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVersion())
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine.setSrcPath(str);
      this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine.setOutputVideoPath(ShortVideoUtils.c());
      this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine.setCallback(new biyg(this));
      this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine.setLutPath(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getFilterLutPath());
      if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getWatermarkRect() != null) {
        this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine.setWatermarkRect(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getWatermarkRect());
      }
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
      this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine.save(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoWidth(), this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoHeight());
      return;
      str = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoPath();
      continue;
      str = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getPagFilePath();
    }
  }
  
  private void t()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && (!localFragmentActivity.isFinishing()) && (this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  private void u()
  {
    if ((this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate == null) || (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine == null)) {
      return;
    }
    this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine.getOutputVideoPath();
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getAudioPath();
    Object localObject1 = new File(this.jdField_b_of_type_JavaLangString);
    boolean bool = a(BaseApplicationImpl.getContext());
    label97:
    StringBuilder localStringBuilder;
    if ((((File)localObject1).exists()) && (this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.toLowerCase().endsWith(".m4a")))
    {
      if (!bool) {
        break label279;
      }
      localObject1 = biio.a(biio.a());
      localStringBuilder = new StringBuilder().append("outputDir: ").append((String)localObject1);
      if (!new File((String)localObject1).exists()) {
        break label308;
      }
    }
    label279:
    label308:
    for (Object localObject2 = " exist";; localObject2 = " not exist")
    {
      TTPTLogger.i("AEVideoShelfEditFrag", (String)localObject2);
      this.jdField_a_of_type_JavaUtilTimer = new Timer();
      this.jdField_a_of_type_JavaUtilTimer.schedule(new AEVideoShelfEditFragment.16(this), 0L, jdField_a_of_type_Int);
      if (blce.a(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine.getOutputVideoPath(), this.jdField_b_of_type_JavaLangString, (String)localObject1, 0) == 0)
      {
        localObject2 = new File(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine.getOutputVideoPath());
        if (((File)localObject2).exists())
        {
          TTPTLogger.i("AEVideoShelfEditFrag", "finishAudioVideoMerge done!");
          ((File)localObject2).delete();
        }
        this.jdField_f_of_type_JavaLangString = ((String)localObject1);
      }
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
      if ((!bool) || (this.jdField_f_of_type_JavaLangString == null)) {
        break;
      }
      vyf.a(BaseApplication.getContext(), new File(this.jdField_f_of_type_JavaLangString));
      return;
      localObject1 = biio.a(bijb.jdField_e_of_type_JavaLangString + File.separator);
      break label97;
    }
  }
  
  public void a()
  {
    a(getResources().getString(2131689808));
  }
  
  public void a(int paramInt)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long > 200L)
    {
      bfny.a(new AEVideoShelfEditFragment.14(this, paramInt));
      this.jdField_a_of_type_Long = l;
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    this.jdField_b_of_type_Long = 0L;
    bfny.a(new AEVideoShelfEditFragment.17(this));
    TTPTLogger.w("AEVideoShelfEditFrag", "Merge Video step onError");
  }
  
  public void a(NodeItem paramNodeItem)
  {
    int m = 0;
    NodeGroup localNodeGroup = new NodeGroup();
    int j = 0;
    int k;
    for (;;)
    {
      k = m;
      if (j >= this.jdField_a_of_type_JavaUtilList.size()) {
        break;
      }
      if (paramNodeItem.nodeGroupID == ((NodeGroup)this.jdField_a_of_type_JavaUtilList.get(j)).nodeGroupID) {
        localNodeGroup = (NodeGroup)this.jdField_a_of_type_JavaUtilList.get(j);
      }
      j += 1;
    }
    while (k < localNodeGroup.nodeItemList.size())
    {
      if (paramNodeItem.nodeID == ((NodeItem)localNodeGroup.nodeItemList.get(k)).nodeID)
      {
        ((NodeItem)localNodeGroup.nodeItemList.get(k)).once = paramNodeItem.once;
        ((NodeItem)localNodeGroup.nodeItemList.get(k)).matrix.set(paramNodeItem.matrix);
        ((NodeItem)localNodeGroup.nodeItemList.get(k)).bitmap = paramNodeItem.bitmap;
        ((NodeItem)localNodeGroup.nodeItemList.get(k)).cropBitmap = paramNodeItem.cropBitmap;
      }
      k += 1;
    }
  }
  
  public void b()
  {
    t();
  }
  
  public void b(NodeItem paramNodeItem)
  {
    int m = 0;
    NodeGroup localNodeGroup = new NodeGroup();
    int j = 0;
    int k;
    for (;;)
    {
      k = m;
      if (j >= this.jdField_a_of_type_JavaUtilList.size()) {
        break;
      }
      if (paramNodeItem.nodeGroupID == ((NodeGroup)this.jdField_a_of_type_JavaUtilList.get(j)).nodeGroupID) {
        localNodeGroup = (NodeGroup)this.jdField_a_of_type_JavaUtilList.get(j);
      }
      j += 1;
    }
    while (k < localNodeGroup.nodeItemList.size())
    {
      if (paramNodeItem.nodeID == ((NodeItem)localNodeGroup.nodeItemList.get(k)).nodeID)
      {
        ((NodeItem)localNodeGroup.nodeItemList.get(k)).once = paramNodeItem.once;
        ((NodeItem)localNodeGroup.nodeItemList.get(k)).bitmap = paramNodeItem.bitmap;
        ((NodeItem)localNodeGroup.nodeItemList.get(k)).cropBitmap = paramNodeItem.cropBitmap;
        ((NodeItem)localNodeGroup.nodeItemList.get(k)).nodeTextMaxCount = paramNodeItem.nodeTextMaxCount;
      }
      k += 1;
    }
  }
  
  public void c()
  {
    TTPTLogger.i("AEVideoShelfEditFrag", "Merge Video step onStartGenerate");
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    bfny.a(new AEVideoShelfEditFragment.13(this));
  }
  
  public void c(NodeItem paramNodeItem)
  {
    d(paramNodeItem.nodeGroupID);
  }
  
  public void d()
  {
    TTPTLogger.i("AEVideoShelfEditFrag", "Merge Video step onCompleted");
    if (this.jdField_b_of_type_Long > 0L) {}
    for (long l = System.currentTimeMillis() - this.jdField_b_of_type_Long;; l = 0L)
    {
      this.jdField_b_of_type_Long = 0L;
      u();
      bfny.a(new AEVideoShelfEditFragment.15(this, l));
      a(false);
      return;
    }
  }
  
  public void e()
  {
    TTPTLogger.i("AEVideoShelfEditFrag", "Merge Video step onCancelCompleted");
    this.jdField_b_of_type_Long = 0L;
    bfny.a(new AEVideoShelfEditFragment.18(this));
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.requestWindowFeature(1);
    paramActivity.getWindow().setFlags(1024, 1024);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onBackPressed()
  {
    getActivity().finish();
  }
  
  public void onClick(View paramView)
  {
    if (bjag.a(paramView)) {}
    int j;
    do
    {
      return;
      j = paramView.getId();
      if (j == 2131362984)
      {
        onBackPressed();
        return;
      }
      if (j == 2131363638)
      {
        q();
        bizt.a().g();
        return;
      }
    } while (j != 2131365469);
    a(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2131558480, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(null);
    if (this.jdField_a_of_type_Bizk != null) {
      this.jdField_a_of_type_Bizk.a();
    }
    this.jdField_a_of_type_Bizk = null;
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(null);
    }
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(null);
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (Bitmap)localIterator.next();
      if (BitmapUtils.isLegal((Bitmap)localObject)) {
        ((Bitmap)localObject).recycle();
      }
    }
    localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      BitmapUtils.recycle((Bitmap)((Map.Entry)localIterator.next()).getValue());
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
    localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
    while (localIterator.hasNext()) {
      ((ScaleMoveImageViewer)localIterator.next()).d();
    }
    localIterator = this.jdField_b_of_type_JavaUtilHashSet.iterator();
    while (localIterator.hasNext())
    {
      localObject = (EditTextViewer)localIterator.next();
      ((EditTextViewer)localObject).c();
      ((EditTextViewer)localObject).setOnDownloadDialogListener(null);
    }
    localIterator = this.jdField_c_of_type_JavaUtilHashSet.iterator();
    while (localIterator.hasNext()) {
      ((FaceImageViewer)localIterator.next()).d();
    }
    j();
    a(getActivity(), false);
    super.onDestroy();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (paramIntent == null) {
      break label9;
    }
    label9:
    label162:
    for (;;)
    {
      return;
      if (paramIntent.getIntExtra("pic_result_back_type", -1) == 1)
      {
        String str = paramIntent.getStringExtra("PhotoConst.SELECTED_PATHS");
        int j = paramIntent.getIntExtra("pic_choose_in_node_id", 0);
        paramIntent = a((NodeGroup)this.jdField_a_of_type_JavaUtilList.get(this.jdField_d_of_type_Int), j);
        if (paramIntent == null) {
          break;
        }
        if (paramIntent.type == 0) {
          a(j, str);
        }
        for (;;)
        {
          if ((TextUtils.isEmpty(str)) || (this.jdField_a_of_type_AndroidUtilSparseIntArray.indexOfKey(j) < 0)) {
            break label162;
          }
          j = this.jdField_a_of_type_AndroidUtilSparseIntArray.get(j);
          if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (j < 0) || (j >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
            break;
          }
          this.jdField_a_of_type_JavaUtilArrayList.remove(j);
          this.jdField_a_of_type_JavaUtilArrayList.add(j, str);
          return;
          if (paramIntent.type == 2) {
            a(j, str, true);
          }
        }
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
      this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine.cancelSave();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
    while (localIterator.hasNext()) {
      ((ScaleMoveImageViewer)localIterator.next()).c();
    }
    localIterator = this.jdField_b_of_type_JavaUtilHashSet.iterator();
    while (localIterator.hasNext()) {
      EditTextViewer localEditTextViewer = (EditTextViewer)localIterator.next();
    }
    localIterator = this.jdField_c_of_type_JavaUtilHashSet.iterator();
    while (localIterator.hasNext()) {
      ((FaceImageViewer)localIterator.next()).c();
    }
    p();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    k();
    g();
    f();
    this.jdField_a_of_type_JavaLangString = bija.jdField_c_of_type_JavaLangString;
    paramView = new File(this.jdField_a_of_type_JavaLangString);
    if (!paramView.exists()) {
      paramView.mkdirs();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEVideoShelfEditFragment
 * JD-Core Version:    0.7.0.1
 */