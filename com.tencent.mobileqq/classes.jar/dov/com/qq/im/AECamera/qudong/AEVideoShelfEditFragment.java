package dov.com.qq.im.AECamera.qudong;

import abju;
import abjv;
import aciy;
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
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
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
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bbmh;
import befn;
import bgxx;
import bhav;
import bhaw;
import bhax;
import bhay;
import bhaz;
import bhba;
import bhbb;
import bhbc;
import bhbd;
import bhbe;
import bhbf;
import bhbt;
import bhbu;
import bhca;
import bhcb;
import bhcd;
import bhcf;
import bhch;
import bhci;
import bhcp;
import bjlc;
import com.tencent.mobileqq.activity.PublicFragmentActivityForPeak;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.offlineset.OfflineConfig;
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
import vlm;

public class AEVideoShelfEditFragment
  extends PublicBaseFragment
  implements abjv, View.OnClickListener, bhbt, bhbu, bhca, bhcb
{
  private static double jdField_a_of_type_Double = 0.3D;
  private static int jdField_a_of_type_Int = 200;
  private static PowerManager.WakeLock jdField_a_of_type_AndroidOsPowerManager$WakeLock;
  public static final String a;
  private long jdField_a_of_type_Long;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  bbmh jdField_a_of_type_Bbmh;
  private bhcd jdField_a_of_type_Bhcd;
  private bhcf jdField_a_of_type_Bhcf = new bhaw(this);
  private VideoShelfEngine jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine;
  private VideoShelfTemplate jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate;
  private Boolean jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
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
  private String f;
  private String g;
  
  static
  {
    jdField_a_of_type_JavaLangString = bgxx.jdField_d_of_type_JavaLangString;
  }
  
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
  
  private bbmh a()
  {
    bbmh localbbmh = new bbmh(getActivity());
    localbbmh.a(aciy.a(50.0F, getActivity().getResources()));
    localbbmh.a(true);
    localbbmh.c(false);
    localbbmh.f(-1);
    localbbmh.e(0);
    localbbmh.d(-15550475);
    localbbmh.g(3);
    localbbmh.jdField_f_of_type_Boolean = true;
    localbbmh.jdField_f_of_type_Int = 2;
    localbbmh.e(true);
    localbbmh.a(new bhay(this));
    return localbbmh;
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
    //   0: new 294	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 295	java/lang/StringBuilder:<init>	()V
    //   7: aload_0
    //   8: getfield 297	dov/com/qq/im/AECamera/qudong/AEVideoShelfEditFragment:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   11: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: getstatic 306	java/io/File:separator	Ljava/lang/String;
    //   17: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: ldc_w 308
    //   23: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokestatic 314	java/lang/System:currentTimeMillis	()J
    //   29: invokevirtual 317	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   32: ldc_w 319
    //   35: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: iload_1
    //   39: invokevirtual 322	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   42: ldc_w 324
    //   45: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 328	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: astore 4
    //   53: new 303	java/io/File
    //   56: dup
    //   57: aload 4
    //   59: invokespecial 331	java/io/File:<init>	(Ljava/lang/String;)V
    //   62: astore_3
    //   63: aload_3
    //   64: invokevirtual 334	java/io/File:createNewFile	()Z
    //   67: pop
    //   68: new 336	java/io/FileOutputStream
    //   71: dup
    //   72: aload_3
    //   73: invokespecial 339	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   76: astore_3
    //   77: aload_2
    //   78: getstatic 345	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   81: bipush 100
    //   83: aload_3
    //   84: invokevirtual 349	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   87: pop
    //   88: aload_3
    //   89: invokevirtual 352	java/io/FileOutputStream:flush	()V
    //   92: aload_3
    //   93: invokevirtual 355	java/io/FileOutputStream:close	()V
    //   96: aload 4
    //   98: areturn
    //   99: astore 5
    //   101: ldc 169
    //   103: new 294	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 295	java/lang/StringBuilder:<init>	()V
    //   110: ldc_w 357
    //   113: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload 5
    //   118: invokevirtual 358	java/io/IOException:toString	()Ljava/lang/String;
    //   121: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: invokevirtual 328	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokestatic 364	com/tencent/ttpic/videoshelf/utils/TTPTLogger:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: goto -62 -> 68
    //   133: astore_3
    //   134: aload_3
    //   135: invokevirtual 367	java/io/FileNotFoundException:printStackTrace	()V
    //   138: ldc 169
    //   140: new 294	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 295	java/lang/StringBuilder:<init>	()V
    //   147: ldc_w 369
    //   150: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_3
    //   154: invokevirtual 370	java/io/FileNotFoundException:toString	()Ljava/lang/String;
    //   157: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 328	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 364	com/tencent/ttpic/videoshelf/utils/TTPTLogger:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   166: aconst_null
    //   167: astore_3
    //   168: goto -91 -> 77
    //   171: astore_2
    //   172: aload_2
    //   173: invokevirtual 371	java/lang/Exception:printStackTrace	()V
    //   176: ldc 169
    //   178: new 294	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 295	java/lang/StringBuilder:<init>	()V
    //   185: ldc_w 373
    //   188: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: aload_2
    //   192: invokevirtual 374	java/lang/Exception:toString	()Ljava/lang/String;
    //   195: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: invokevirtual 328	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokestatic 364	com/tencent/ttpic/videoshelf/utils/TTPTLogger:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   204: aconst_null
    //   205: areturn
    //   206: astore_2
    //   207: aload_2
    //   208: invokevirtual 375	java/io/IOException:printStackTrace	()V
    //   211: ldc 169
    //   213: new 294	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 295	java/lang/StringBuilder:<init>	()V
    //   220: ldc_w 377
    //   223: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: aload_2
    //   227: invokevirtual 358	java/io/IOException:toString	()Ljava/lang/String;
    //   230: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 328	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokestatic 364	com/tencent/ttpic/videoshelf/utils/TTPTLogger:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   239: goto -147 -> 92
    //   242: astore_2
    //   243: aload_2
    //   244: invokevirtual 375	java/io/IOException:printStackTrace	()V
    //   247: ldc 169
    //   249: new 294	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 295	java/lang/StringBuilder:<init>	()V
    //   256: ldc_w 379
    //   259: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: aload_2
    //   263: invokevirtual 358	java/io/IOException:toString	()Ljava/lang/String;
    //   266: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: invokevirtual 328	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   272: invokestatic 364	com/tencent/ttpic/videoshelf/utils/TTPTLogger:w	(Ljava/lang/String;Ljava/lang/String;)V
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
    a(paramInt, paramString, true);
  }
  
  private void a(int paramInt, String paramString, boolean paramBoolean)
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
      Bitmap localBitmap1 = bhch.a(localBitmap1, paramString);
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
  
  public static void a(Activity paramActivity, int paramInt1, String paramString1, String paramString2, String paramString3, ArrayList<String> paramArrayList, int paramInt2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("MaterialPath", paramString1);
    localIntent.putExtra("MaterialId", paramString2);
    localIntent.putExtra("MaterialName", paramString3);
    localIntent.putStringArrayListExtra("PhotoList", paramArrayList);
    localIntent.putExtra("jump_in_from", paramInt2);
    abju.a(paramActivity, localIntent, PublicFragmentActivityForPeak.class, AEVideoShelfEditFragment.class, paramInt1);
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
    abju.a(paramContext, localIntent, PublicFragmentActivityForPeak.class, AEVideoShelfEditFragment.class);
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
    int i = ((NodeGroup)this.jdField_a_of_type_JavaUtilList.get(this.jdField_d_of_type_Int)).nodeGroupID;
    if (this.jdField_a_of_type_JavaUtilHashSet != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
      while (localIterator.hasNext())
      {
        ScaleMoveImageViewer localScaleMoveImageViewer = (ScaleMoveImageViewer)localIterator.next();
        if (localScaleMoveImageViewer.b() == i) {
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
      if ((((FaceImageViewer)localObject2).a() == localNodeGroup.nodeGroupID) && (((FaceImageViewer)localObject2).a().zIndex < 10000))
      {
        paramViewGroup.addView((View)localObject2);
        a((ImageView)localObject2, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
      }
    }
    localObject1 = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getMaterialPath() + File.separator + localNodeGroup.nodeDefaultMaskCoverImage;
    localObject1 = bhch.a(BitmapUtils.decodeSampleBitmap(getActivity(), (String)localObject1, this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoWidth(), this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoHeight()), (String)localObject1);
    Object localObject2 = new ImageView(getActivity());
    ((ImageView)localObject2).setImageBitmap((Bitmap)localObject1);
    paramViewGroup.addView((View)localObject2);
    int i;
    float f1;
    if (localObject1 != null)
    {
      paramInt = ((Bitmap)localObject1).getWidth();
      i = ((Bitmap)localObject1).getHeight();
      f1 = paramInt / i;
      if (f1 >= this.jdField_b_of_type_Int / this.jdField_b_of_type_Int) {
        break label550;
      }
      i = this.jdField_b_of_type_Int;
      paramInt = (int)(this.jdField_b_of_type_Int / f1);
    }
    for (;;)
    {
      ((ImageView)localObject2).measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt, 1073741824));
      ((ImageView)localObject2).layout((this.jdField_b_of_type_Int - i) / 2, (this.jdField_c_of_type_Int - paramInt) / 2, (i + this.jdField_b_of_type_Int) / 2, (paramInt + this.jdField_c_of_type_Int) / 2);
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
      i = (int)(this.jdField_c_of_type_Int * f1);
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
      if ((((FaceImageViewer)localObject2).a() == localNodeGroup.nodeGroupID) && (((FaceImageViewer)localObject2).a().zIndex >= 10000))
      {
        paramViewGroup.addView((View)localObject2);
        a((ImageView)localObject2, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
      }
    }
  }
  
  private void a(ImageView paramImageView, int paramInt1, int paramInt2)
  {
    NodeItem localNodeItem = null;
    int i;
    int j;
    if ((paramImageView instanceof ScaleMoveImageViewer))
    {
      localNodeItem = ((ScaleMoveImageViewer)paramImageView).a();
      if (localNodeItem != null)
      {
        i = (int)(localNodeItem.maskRect.left * paramInt1);
        j = (int)(localNodeItem.maskRect.top * paramInt2);
        paramInt1 = (int)(localNodeItem.maskRect.right * paramInt1);
        paramInt2 = (int)(localNodeItem.maskRect.bottom * paramInt2);
        paramImageView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1 - i, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2 - j, 1073741824));
        paramImageView.layout(i, j, paramInt1, paramInt2);
        if (!(paramImageView instanceof ScaleMoveImageViewer)) {
          break label179;
        }
        ((ScaleMoveImageViewer)paramImageView).a(Math.abs(paramInt1 - i), Math.abs(paramInt2 - j));
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
        ((FaceImageViewer)paramImageView).a(Math.abs(paramInt1 - i), Math.abs(paramInt2 - j));
        return;
      }
    } while (!(paramImageView instanceof EditTextViewer));
    ((EditTextViewer)paramImageView).a(Math.abs(paramInt1 - i), Math.abs(paramInt2 - j));
    paramInt1 = getResources().getDimensionPixelSize(2131165521);
    ((EditTextViewer)paramImageView).setActionBarHeight(paramInt1);
  }
  
  private void a(RelativeLayout paramRelativeLayout, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null)
    {
      bhcd localbhcd = (bhcd)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getAdapter();
      paramRelativeLayout = a(paramRelativeLayout, paramRelativeLayout.getWidth(), paramRelativeLayout.getHeight());
      if ((localbhcd != null) && (BitmapUtils.isLegal(paramRelativeLayout)))
      {
        localbhcd.a(paramInt, paramRelativeLayout);
        localbhcd.b();
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
    this.jdField_a_of_type_AndroidGraphicsBitmap = bhch.a(BitmapUtils.decodeSampleBitmap(getActivity(), paramNodeGroup, this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoWidth(), this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoHeight()), paramNodeGroup);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
  }
  
  private void a(String paramString)
  {
    Object localObject = getActivity();
    if ((localObject != null) && (!((FragmentActivity)localObject).isFinishing()))
    {
      if (this.jdField_a_of_type_AndroidAppDialog == null)
      {
        this.jdField_a_of_type_AndroidAppDialog = new Dialog((Context)localObject, 2131690181);
        this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
        this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
        this.jdField_a_of_type_AndroidAppDialog.setContentView(2131493818);
      }
      localObject = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131305861);
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
      ((TextView)localObject).setText(2131629447);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      Log.i("AEVideoShelfEditFrag", "已经合成完视频，不进行实时预览。");
      TTPTLogger.i("AEVideoShelfEditFrag", "已经合成完视频，不进行实时预览。");
      if ((this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate == null) || (this.g == null)) {
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("from", true);
      localIntent.putExtra("MaterialId", this.jdField_e_of_type_JavaLangString);
      localIntent.putExtra("FinalVideoPath", this.g);
      localIntent.putExtra("usePagPreview", paramBoolean);
      localIntent.putExtra("MaterialPath", this.jdField_d_of_type_JavaLangString);
      localIntent.putExtra("MaterialName", this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoName());
      localIntent.putStringArrayListExtra("PhotoList", this.jdField_a_of_type_JavaUtilArrayList);
      localIntent.putExtra("loc_play_show_tab_name", this.f);
      localIntent.putExtra("loc_play_show_material_id", this.jdField_e_of_type_JavaLangString);
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
    int k = 0;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
    Object localObject2 = null;
    int j = 0;
    Object localObject3;
    Object localObject1;
    int i;
    if (localIterator.hasNext())
    {
      localObject3 = (ScaleMoveImageViewer)localIterator.next();
      localObject1 = localObject2;
      i = j;
      if (!((ScaleMoveImageViewer)localObject3).a())
      {
        if (localObject2 != null) {
          break label90;
        }
        localObject1 = localObject3;
        i = 1;
      }
    }
    label192:
    for (;;)
    {
      localObject2 = localObject1;
      j = i;
      if (i != 0) {
        break;
      }
      ((ScaleMoveImageViewer)localObject3).a();
      localObject2 = localObject1;
      j = i;
      break;
      label90:
      if (localObject2.b() > ((ScaleMoveImageViewer)localObject3).b())
      {
        localObject1 = localObject3;
        i = 1;
        continue;
        localIterator = this.jdField_c_of_type_JavaUtilHashSet.iterator();
        if (localIterator.hasNext())
        {
          localObject3 = (FaceImageViewer)localIterator.next();
          localObject1 = localObject4;
          i = k;
          if (!((FaceImageViewer)localObject3).a())
          {
            if (localObject4 != null) {
              break label192;
            }
            localObject1 = localObject3;
            i = 1;
          }
        }
        for (;;)
        {
          localObject4 = localObject1;
          k = i;
          if (i != 0) {
            break;
          }
          ((FaceImageViewer)localObject3).a();
          localObject4 = localObject1;
          k = i;
          break;
          if (localObject4.a() > ((FaceImageViewer)localObject3).a())
          {
            localObject1 = localObject3;
            i = 1;
            continue;
            if ((j != 0) && (localObject2 != null)) {}
            for (i = Math.max(localObject2.b(), -1);; i = -1)
            {
              if ((k != 0) && (localObject4 != null)) {
                Math.max(localObject4.a(), i);
              }
              return true;
            }
          }
          else
          {
            i = 1;
            localObject1 = localObject4;
          }
        }
      }
      else
      {
        i = 1;
        localObject1 = localObject2;
      }
    }
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_Bbmh == null) {
      return;
    }
    this.jdField_a_of_type_Bbmh.a();
    this.jdField_a_of_type_Bbmh.c(paramInt);
    this.jdField_a_of_type_Bbmh.b(true);
    this.jdField_a_of_type_Bbmh.d(false);
    this.jdField_a_of_type_Bbmh.a(paramInt + "%");
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
        if ((((FaceImageViewer)localObject).a() == localNodeGroup.nodeGroupID) && (((FaceImageViewer)localObject).a().zIndex < 10000)) {
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
        if ((((FaceImageViewer)localObject).a() == localNodeGroup.nodeGroupID) && (((FaceImageViewer)localObject).a().zIndex >= 10000)) {
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
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.postDelayed(new AEVideoShelfEditFragment.16(this, paramInt), 100L);
  }
  
  private void e(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null)
    {
      bhcd localbhcd = (bhcd)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getAdapter();
      Bitmap localBitmap = a();
      if ((localbhcd != null) && (BitmapUtils.isLegal(localBitmap)))
      {
        localbhcd.a(paramInt, localBitmap);
        localbhcd.b();
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
    this.jdField_a_of_type_AndroidViewView = getActivity().findViewById(2131297445);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)getActivity().findViewById(2131298087));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131624255);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView = getActivity().findViewById(2131299890);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)getActivity().findViewById(2131298451));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)getActivity().findViewById(2131297826));
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(getActivity());
    localLinearLayoutManager.setOrientation(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new bhbf(this, a(getActivity(), 12.0F)));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.getViewTreeObserver().addOnGlobalLayoutListener(new bhav(this));
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
    this.jdField_b_of_type_AndroidAppDialog.setContentView(2131495844);
    localObject = (ImageView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131306298);
    this.jdField_a_of_type_Bbmh = a();
    ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_Bbmh);
    ((TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131304792)).setText(2131624268);
    this.jdField_b_of_type_AndroidAppDialog.setCancelable(true);
    this.jdField_b_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
    this.jdField_b_of_type_AndroidAppDialog.setOnCancelListener(new bhax(this));
    this.jdField_a_of_type_Bbmh.c(0);
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
    this.f = localIntent.getStringExtra("loc_play_show_tab_name");
    this.jdField_d_of_type_JavaLangString = localIntent.getStringExtra("MaterialPath");
    this.jdField_e_of_type_JavaLangString = localIntent.getStringExtra("MaterialId");
    this.jdField_a_of_type_JavaUtilArrayList = localIntent.getStringArrayListExtra("PhotoList");
    this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate = TemplateParser.parse(getActivity(), this.jdField_d_of_type_JavaLangString);
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
        befn.a(new AEVideoShelfEditFragment.4(this), 2000L);
      }
      new bhaz(this).execute(new Void[0]);
    }
  }
  
  private void l()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        String str = (String)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        this.jdField_a_of_type_JavaUtilMap.put(str, BitmapUtils.decodeSampleBitmap(getActivity(), str, this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoWidth(), this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoHeight()));
        i += 1;
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
      int i = 0;
      while (i < this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getNodeGroupList().size())
      {
        Object localObject1 = (MaskNodeGroup)this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getNodeGroupList().get(i);
        NodeGroup localNodeGroup = new NodeGroup();
        localNodeGroup.nodeCoverImage = ((MaskNodeGroup)localObject1).getNodeGroupCoverImage();
        localNodeGroup.nodeGroupID = ((MaskNodeGroup)localObject1).getNodeGroupID();
        localNodeGroup.nodeDefaultMaskCoverImage = ((MaskNodeGroup)localObject1).getNodeGroupMaskImage();
        localObject1 = ((MaskNodeGroup)localObject1).getNodeList();
        localNodeGroup.nodeItemList = new ArrayList();
        int j = 0;
        if (j < ((List)localObject1).size())
        {
          Object localObject2 = (MaskNodeItem)((List)localObject1).get(j);
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
              localNodeItem.bitmap = bhch.a(localNodeItem.bitmap, str);
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
            j += 1;
            break;
            localNodeItem.coverURL = localNodeGroup.nodeDefaultMaskCoverImage;
            continue;
            localNodeItem.coverURL = ((String)localObject3);
          }
        }
        this.jdField_a_of_type_JavaUtilList.add(localNodeGroup);
        i += 1;
      }
    }
  }
  
  private void o()
  {
    this.jdField_a_of_type_AndroidUtilSparseIntArray.clear();
    Iterator localIterator1 = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
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
          ((ScaleMoveImageViewer)localObject).getViewTreeObserver().addOnGlobalLayoutListener(new bhba(this, (ScaleMoveImageViewer)localObject, localNodeItem));
          ((ScaleMoveImageViewer)localObject).setOnSaveScrollInfoListener(this);
          ((ScaleMoveImageViewer)localObject).setNodeInfo(localNodeItem);
          ((ScaleMoveImageViewer)localObject).setMovable(false);
          ((ScaleMoveImageViewer)localObject).setImageSelected(false);
          this.jdField_a_of_type_JavaUtilHashSet.add(localObject);
          if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (i < this.jdField_a_of_type_JavaUtilArrayList.size()))
          {
            a(localNodeItem.nodeID, (String)this.jdField_a_of_type_JavaUtilArrayList.get(i), false);
            this.jdField_a_of_type_AndroidUtilSparseIntArray.put(localNodeItem.nodeID, i);
            i += 1;
          }
        }
        else
        {
          if (localNodeItem.type == 1)
          {
            localObject = new EditTextViewer(getActivity());
            ((EditTextViewer)localObject).getViewTreeObserver().addOnGlobalLayoutListener(new bhbb(this, (EditTextViewer)localObject, localNodeItem));
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
              ((EditTextViewer)localObject).setMaterialId(this.jdField_e_of_type_JavaLangString);
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
            ((FaceImageViewer)localObject).getViewTreeObserver().addOnGlobalLayoutListener(new bhbc(this, (FaceImageViewer)localObject, localNodeItem));
            ((FaceImageViewer)localObject).setOnSaveScrollInfoListener(this);
            ((FaceImageViewer)localObject).setNodeInfo(localNodeItem);
            ((FaceImageViewer)localObject).setMovable(false);
            ((FaceImageViewer)localObject).setImageSelected(false);
            this.jdField_c_of_type_JavaUtilHashSet.add(localObject);
          }
        }
      }
    }
  }
  
  private void p()
  {
    Object localObject1 = new File(this.jdField_b_of_type_JavaLangString);
    if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
    {
      localObject1 = ((File)localObject1).list();
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          localObject2 = new File(this.jdField_b_of_type_JavaLangString, (String)localObject2);
          if (((File)localObject2).exists()) {
            ((File)localObject2).delete();
          }
          i += 1;
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
    new bhbd(this).execute(new Void[0]);
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
      this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine.setCallback(new bhbe(this));
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
    this.g = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine.getOutputVideoPath();
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getAudioPath();
    String str;
    StringBuilder localStringBuilder;
    if ((new File(this.jdField_c_of_type_JavaLangString).exists()) && (this.jdField_c_of_type_JavaLangString != null) && (this.jdField_c_of_type_JavaLangString.toLowerCase().endsWith(".m4a")))
    {
      str = ShortVideoUtils.c();
      localStringBuilder = new StringBuilder().append("outputDir: ").append(str);
      if (!new File(str).exists()) {
        break label250;
      }
    }
    label250:
    for (Object localObject = " exist";; localObject = " not exist")
    {
      TTPTLogger.i("AEVideoShelfEditFrag", (String)localObject);
      this.jdField_a_of_type_JavaUtilTimer = new Timer();
      this.jdField_a_of_type_JavaUtilTimer.schedule(new AEVideoShelfEditFragment.13(this), 0L, jdField_a_of_type_Int);
      if (bjlc.a(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine.getOutputVideoPath(), this.jdField_c_of_type_JavaLangString, str, 0) == 0)
      {
        localObject = new File(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine.getOutputVideoPath());
        if (((File)localObject).exists())
        {
          TTPTLogger.i("AEVideoShelfEditFrag", "finishAudioVideoMerge done!");
          ((File)localObject).delete();
        }
        this.g = str;
      }
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
      vlm.a(BaseApplication.getContext(), new File(this.g));
      return;
    }
  }
  
  public void a()
  {
    a(getResources().getString(2131624263));
  }
  
  public void a(int paramInt)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long > 200L)
    {
      befn.a(new AEVideoShelfEditFragment.11(this, paramInt));
      this.jdField_a_of_type_Long = l;
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    this.jdField_b_of_type_Long = 0L;
    befn.a(new AEVideoShelfEditFragment.14(this));
    TTPTLogger.w("AEVideoShelfEditFrag", "Merge Video step onError");
  }
  
  public void a(NodeItem paramNodeItem)
  {
    int k = 0;
    NodeGroup localNodeGroup = new NodeGroup();
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
        break;
      }
      if (paramNodeItem.nodeGroupID == ((NodeGroup)this.jdField_a_of_type_JavaUtilList.get(i)).nodeGroupID) {
        localNodeGroup = (NodeGroup)this.jdField_a_of_type_JavaUtilList.get(i);
      }
      i += 1;
    }
    while (j < localNodeGroup.nodeItemList.size())
    {
      if (paramNodeItem.nodeID == ((NodeItem)localNodeGroup.nodeItemList.get(j)).nodeID)
      {
        ((NodeItem)localNodeGroup.nodeItemList.get(j)).once = paramNodeItem.once;
        ((NodeItem)localNodeGroup.nodeItemList.get(j)).matrix.set(paramNodeItem.matrix);
        ((NodeItem)localNodeGroup.nodeItemList.get(j)).bitmap = paramNodeItem.bitmap;
        ((NodeItem)localNodeGroup.nodeItemList.get(j)).cropBitmap = paramNodeItem.cropBitmap;
      }
      j += 1;
    }
  }
  
  public void b()
  {
    t();
  }
  
  public void b(NodeItem paramNodeItem)
  {
    int k = 0;
    NodeGroup localNodeGroup = new NodeGroup();
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
        break;
      }
      if (paramNodeItem.nodeGroupID == ((NodeGroup)this.jdField_a_of_type_JavaUtilList.get(i)).nodeGroupID) {
        localNodeGroup = (NodeGroup)this.jdField_a_of_type_JavaUtilList.get(i);
      }
      i += 1;
    }
    while (j < localNodeGroup.nodeItemList.size())
    {
      if (paramNodeItem.nodeID == ((NodeItem)localNodeGroup.nodeItemList.get(j)).nodeID)
      {
        ((NodeItem)localNodeGroup.nodeItemList.get(j)).once = paramNodeItem.once;
        ((NodeItem)localNodeGroup.nodeItemList.get(j)).bitmap = paramNodeItem.bitmap;
        ((NodeItem)localNodeGroup.nodeItemList.get(j)).cropBitmap = paramNodeItem.cropBitmap;
        ((NodeItem)localNodeGroup.nodeItemList.get(j)).nodeTextMaxCount = paramNodeItem.nodeTextMaxCount;
      }
      j += 1;
    }
  }
  
  public void c()
  {
    TTPTLogger.i("AEVideoShelfEditFrag", "Merge Video step onStartGenerate");
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    befn.a(new AEVideoShelfEditFragment.10(this));
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
      befn.a(new AEVideoShelfEditFragment.12(this, l));
      a(false);
      return;
    }
  }
  
  public void e()
  {
    TTPTLogger.i("AEVideoShelfEditFrag", "Merge Video step onCancelCompleted");
    this.jdField_b_of_type_Long = 0L;
    befn.a(new AEVideoShelfEditFragment.15(this));
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
    if (bhcp.a(paramView)) {}
    int i;
    do
    {
      return;
      i = paramView.getId();
      if (i == 2131297445)
      {
        onBackPressed();
        return;
      }
      if (i == 2131298087)
      {
        q();
        bhci.a().g();
        return;
      }
    } while (i != 2131299890);
    a(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2131492940, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(null);
    if (this.jdField_a_of_type_Bhcd != null) {
      this.jdField_a_of_type_Bhcd.a();
    }
    this.jdField_a_of_type_Bhcd = null;
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
    if (paramIntent == null) {}
    String str;
    int i;
    do
    {
      do
      {
        do
        {
          return;
        } while (paramIntent.getIntExtra("pic_result_back_type", -1) != 1);
        str = paramIntent.getStringExtra("PhotoConst.SELECTED_PATHS");
        i = paramIntent.getIntExtra("pic_choose_in_node_id", 0);
        a(i, str);
      } while ((TextUtils.isEmpty(str)) || (this.jdField_a_of_type_AndroidUtilSparseIntArray.indexOfKey(i) < 0));
      i = this.jdField_a_of_type_AndroidUtilSparseIntArray.get(i);
    } while ((this.jdField_a_of_type_JavaUtilArrayList == null) || (i < 0) || (i >= this.jdField_a_of_type_JavaUtilArrayList.size()));
    this.jdField_a_of_type_JavaUtilArrayList.remove(i);
    this.jdField_a_of_type_JavaUtilArrayList.add(i, str);
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
    this.jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.AECamera.qudong.AEVideoShelfEditFragment
 * JD-Core Version:    0.7.0.1
 */