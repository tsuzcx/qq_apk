package com.tencent.mobileqq.qwallet.hb.grap.draw.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletAioBodyReserve;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.qqpay.ui.R.drawable;
import com.tencent.mobileqq.qqpay.ui.R.id;
import com.tencent.mobileqq.qqpay.ui.R.layout;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qqpay.ui.R.style;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletPreferenceApi;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.qwallet.hb.aio.QQWalletBaseMsgElem;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.IPasswdRedBagService;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.PasswdRedBagInfo;
import com.tencent.mobileqq.qwallet.hb.grap.impl.RedPacketPopFragment;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import com.tencent.mobileqq.relation.api.IContactUtilsApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Random;
import mqq.app.AppRuntime;

public class DrawRedpacketPannelPreviewFragment
  extends RedPacketPopFragment
  implements View.OnClickListener
{
  public static final String a = "DrawRedpacketPannelPreviewFragment";
  static long b;
  public TextView c;
  private DoodleLayout d;
  private ImageView e;
  private TextView f;
  private ImageView g;
  private RelativeLayout h;
  private TextView i;
  private TextView j;
  private TextView k;
  private ImageView l;
  private ImageView m;
  private ImageView n;
  private ImageView o;
  private ImageView p;
  private View q;
  private TextView r;
  private Button s;
  private QQCustomDialog t;
  private Handler u = new DrawRedpacketPannelPreviewFragment.1(this, Looper.getMainLooper());
  private boolean v;
  private String[] w = { "#369FF5", "#E64C73", "#FF8E2E", "#8547D8", "#12C4AB", "#585E73" };
  private boolean x;
  
  public static Bitmap a(Context paramContext, Bitmap paramBitmap, String paramString, int paramInt1, int paramInt2)
  {
    Paint localPaint = new Paint(1);
    localPaint.setColor(paramInt2);
    localPaint.setTextSize(DisplayUtil.a(paramContext, paramInt1));
    Rect localRect = new Rect();
    localPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
    return a(paramContext, paramBitmap, paramString, localPaint, localRect, (paramBitmap.getWidth() - localRect.width()) / 2, paramBitmap.getHeight() - DisplayUtil.a(paramContext, 12.0F));
  }
  
  private static Bitmap a(Context paramContext, Bitmap paramBitmap, String paramString, Paint paramPaint, Rect paramRect, int paramInt1, int paramInt2)
  {
    paramRect = paramBitmap.getConfig();
    paramPaint.setDither(true);
    paramPaint.setFilterBitmap(true);
    paramContext = paramRect;
    if (paramRect == null) {
      paramContext = Bitmap.Config.ARGB_8888;
    }
    paramContext = paramBitmap.copy(paramContext, true);
    new Canvas(paramContext).drawText(paramString, paramInt1, paramInt2, paramPaint);
    return paramContext;
  }
  
  /* Error */
  public static String a(Bitmap paramBitmap, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aload 5
    //   8: astore_3
    //   9: new 161	java/io/File
    //   12: dup
    //   13: aload_2
    //   14: invokespecial 164	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 6
    //   19: aload 5
    //   21: astore_3
    //   22: aload 6
    //   24: invokevirtual 168	java/io/File:exists	()Z
    //   27: ifne +12 -> 39
    //   30: aload 5
    //   32: astore_3
    //   33: aload 6
    //   35: invokevirtual 171	java/io/File:mkdirs	()Z
    //   38: pop
    //   39: aload 5
    //   41: astore_3
    //   42: new 161	java/io/File
    //   45: dup
    //   46: aload_2
    //   47: aload_1
    //   48: invokespecial 174	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: astore_1
    //   52: aload 5
    //   54: astore_3
    //   55: aload_1
    //   56: invokevirtual 168	java/io/File:exists	()Z
    //   59: ifne +11 -> 70
    //   62: aload 5
    //   64: astore_3
    //   65: aload_1
    //   66: invokevirtual 177	java/io/File:createNewFile	()Z
    //   69: pop
    //   70: aload 5
    //   72: astore_3
    //   73: new 179	java/io/BufferedOutputStream
    //   76: dup
    //   77: new 181	java/io/FileOutputStream
    //   80: dup
    //   81: aload_1
    //   82: invokespecial 184	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   85: invokespecial 187	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   88: astore_2
    //   89: aload_0
    //   90: getstatic 193	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   93: bipush 80
    //   95: aload_2
    //   96: invokevirtual 197	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   99: pop
    //   100: aload_2
    //   101: invokevirtual 200	java/io/BufferedOutputStream:flush	()V
    //   104: aload_2
    //   105: invokevirtual 203	java/io/BufferedOutputStream:close	()V
    //   108: aload_1
    //   109: astore_2
    //   110: goto +52 -> 162
    //   113: astore_0
    //   114: aload_2
    //   115: astore_3
    //   116: goto +58 -> 174
    //   119: astore_3
    //   120: aload_2
    //   121: astore_0
    //   122: aload_3
    //   123: astore_2
    //   124: goto +20 -> 144
    //   127: astore_2
    //   128: aload 4
    //   130: astore_0
    //   131: goto +13 -> 144
    //   134: astore_0
    //   135: goto +39 -> 174
    //   138: astore_2
    //   139: aconst_null
    //   140: astore_1
    //   141: aload 4
    //   143: astore_0
    //   144: aload_0
    //   145: astore_3
    //   146: aload_2
    //   147: invokevirtual 206	java/lang/Throwable:printStackTrace	()V
    //   150: aload_1
    //   151: astore_2
    //   152: aload_0
    //   153: ifnull +9 -> 162
    //   156: aload_0
    //   157: invokevirtual 203	java/io/BufferedOutputStream:close	()V
    //   160: aload_1
    //   161: astore_2
    //   162: aload_2
    //   163: ifnull +8 -> 171
    //   166: aload_2
    //   167: invokevirtual 210	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   170: areturn
    //   171: ldc 212
    //   173: areturn
    //   174: aload_3
    //   175: ifnull +7 -> 182
    //   178: aload_3
    //   179: invokevirtual 203	java/io/BufferedOutputStream:close	()V
    //   182: aload_0
    //   183: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	paramBitmap	Bitmap
    //   0	184	1	paramString1	String
    //   0	184	2	paramString2	String
    //   8	108	3	localObject1	Object
    //   119	4	3	localThrowable	java.lang.Throwable
    //   145	34	3	localBitmap	Bitmap
    //   1	141	4	localObject2	Object
    //   4	67	5	localObject3	Object
    //   17	17	6	localFile	File
    // Exception table:
    //   from	to	target	type
    //   89	104	113	finally
    //   89	104	119	java/lang/Throwable
    //   55	62	127	java/lang/Throwable
    //   65	70	127	java/lang/Throwable
    //   73	89	127	java/lang/Throwable
    //   9	19	134	finally
    //   22	30	134	finally
    //   33	39	134	finally
    //   42	52	134	finally
    //   55	62	134	finally
    //   65	70	134	finally
    //   73	89	134	finally
    //   146	150	134	finally
    //   9	19	138	java/lang/Throwable
    //   22	30	138	java/lang/Throwable
    //   33	39	138	java/lang/Throwable
    //   42	52	138	java/lang/Throwable
  }
  
  public static void a(@NonNull Context paramContext, @NonNull Parcelable paramParcelable, @NonNull MessageForQQWalletMsg paramMessageForQQWalletMsg)
  {
    Intent localIntent = new Intent();
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    localIntent.putExtra("session", paramParcelable);
    localIntent.putExtra("uniseq", paramMessageForQQWalletMsg.uniseq);
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("fromHBList", paramMessageForQQWalletMsg.fromHBList);
    localIntent.putExtra("redPacketId", paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId);
    QPublicFragmentActivity.Launcher.a(paramContext, localIntent, QPublicTransFragmentActivity.class, DrawRedpacketPannelPreviewFragment.class);
  }
  
  private void a(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    ThreadManagerV2.excute(new DrawRedpacketPannelPreviewFragment.11(this, paramString1, paramInt1, paramString2, paramInt2), 64, null, true);
  }
  
  private String c()
  {
    return "{\"v\":\"5.5.5\",\"fr\":25,\"ip\":0,\"op\":50,\"w\":412,\"h\":196,\"nm\":\"预合成 2\",\"ddd\":0,\"assets\":[],\"layers\":[{\"ddd\":0,\"ind\":1,\"ty\":4,\"nm\":\"“图层 2”轮廓\",\"sr\":1,\"ks\":{\"o\":{\"a\":0,\"k\":100,\"ix\":11},\"r\":{\"a\":0,\"k\":0,\"ix\":10},\"p\":{\"a\":0,\"k\":[164.836,52.757,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[161.747,39.038,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100,100],\"ix\":6}},\"ao\":0,\"shapes\":[{\"ty\":\"gr\",\"it\":[{\"ind\":0,\"ty\":\"sh\",\"ix\":1,\"ks\":{\"a\":0,\"k\":{\"i\":[[0,0],[-102.631,31.761]],\"o\":[[86.365,35.971],[0,0]],\"v\":[[-141.747,-19.038],[141.747,-12.723]],\"c\":false},\"ix\":2},\"nm\":\"路径 1\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ty\":\"st\",\"c\":{\"a\":0,\"k\":[0.901960790157,0.298039227724,0.450980395079,1],\"ix\":3},\"o\":{\"a\":0,\"k\":100,\"ix\":4},\"w\":{\"a\":0,\"k\":8,\"ix\":5},\"lc\":2,\"lj\":2,\"bm\":0,\"nm\":\"描边 1\",\"mn\":\"ADBE Vector Graphic - Stroke\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[161.747,39.038],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":0,\"k\":100,\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"变换\"}],\"nm\":\"组 1\",\"np\":2,\"cix\":2,\"bm\":0,\"ix\":1,\"mn\":\"ADBE Vector Group\",\"hd\":false},{\"ty\":\"tm\",\"s\":{\"a\":0,\"k\":0,\"ix\":1},\"e\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"t\":0,\"s\":[0]},{\"t\":41,\"s\":[100]}],\"ix\":2},\"o\":{\"a\":0,\"k\":0,\"ix\":3},\"m\":1,\"ix\":2,\"nm\":\"修剪路径 1\",\"mn\":\"ADBE Vector Filter - Trim\",\"hd\":false}],\"ip\":0,\"op\":96,\"st\":0,\"bm\":0},{\"ddd\":0,\"ind\":2,\"ty\":4,\"nm\":\"“图层 1”轮廓\",\"sr\":1,\"ks\":{\"o\":{\"a\":0,\"k\":100,\"ix\":11},\"r\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"t\":0,\"s\":[4]},{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"t\":23,\"s\":[22.7]},{\"t\":40,\"s\":[0]}],\"ix\":10},\"p\":{\"a\":1,\"k\":[{\"i\":{\"x\":0.833,\"y\":0.833},\"o\":{\"x\":0.167,\"y\":0.167},\"t\":0,\"s\":[23.089,33.719,0],\"to\":[143.999,57.303,0],\"ti\":[-14.999,3.197,0]},{\"t\":40,\"s\":[306.583,40.034,0]}],\"ix\":2},\"a\":{\"a\":0,\"k\":[32.214,20.446,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100,100],\"ix\":6}},\"ao\":0,\"shapes\":[{\"ty\":\"gr\",\"it\":[{\"ind\":0,\"ty\":\"sh\",\"ix\":1,\"ks\":{\"a\":0,\"k\":{\"i\":[[1.746,-1.028],[-2.191,-7.149],[-5.223,-24.576],[1.535,1.8],[5.102,-5.048],[-4.58,-4.526],[-5.474,-11.162],[-12.659,-1.816],[-0.314,2.186],[2.186,0.314],[3.671,7.473],[7.61,7.52],[-1.712,1.693],[-2.636,-3.09],[-3.478,-3.378],[0.807,3.862],[2.473,8.066],[-2.725,-4.986],[-6.361,-22.371],[-2.125,0.604],[0.605,2.125],[1.792,5.686],[-2.642,-5.473],[-1.268,-6.009],[-2.163,0.455],[0.455,2.162],[1.758,4.638],[-1.169,-0.206],[-1.232,-2.293],[-0.962,-6.987],[-2.189,0.301],[0.302,2.189],[0.971,3.24],[-0.962,-1.035],[1.721,-9.756],[2.787,-4.141],[-1.832,-1.233],[-1.233,1.832],[-2.026,12.013],[5.505,5.922],[4.804,-0.918],[3.285,0.579],[3.079,-1.116],[7.342,-3.771],[1.871,3.421],[3.955,0]],\"o\":[[-5.257,3.096],[2.01,6.556],[-1.357,-1.549],[-5.632,-6.603],[-4.605,4.556],[6.983,6.901],[4.899,9.977],[2.187,0.315],[0.314,-2.186],[-10.163,-1.458],[-5.875,-11.981],[-1.05,-1.037],[1.771,-1.752],[6.214,7.288],[2.828,2.748],[-6.889,-33.05],[-2.241,-7.309],[3.214,5.88],[0.603,2.125],[2.125,-0.604],[-2.108,-7.416],[4.626,-2.983],[2.494,5.645],[0.455,2.162],[2.161,-0.456],[-1.025,-4.857],[1.567,-0.496],[0.828,0.146],[1.749,3.257],[0.301,2.188],[2.188,-0.302],[-0.592,-4.301],[1.309,0.092],[3.543,3.812],[-1.857,11.016],[-1.234,1.832],[1.833,1.234],[3.566,-5.298],[2.112,-11.971],[-3.33,-3.582],[-2.236,-3.754],[-2.783,-0.491],[-4.467,-7.344],[-2.637,-7.786],[-2.352,-4.304],[-1.843,0]],\"v\":[[-29.555,-59.673],[-34.864,-42.696],[-23.998,4.066],[-28.335,-0.958],[-46.555,-2.899],[-47.519,13.633],[-26.71,43.145],[-0.144,60.885],[4.383,57.495],[0.993,52.967],[-19.529,39.62],[-41.896,7.942],[-40.929,2.788],[-34.423,4.233],[-19.903,20.215],[-13.201,16.529],[-27.215,-45.041],[-20.962,-50.761],[-6.515,-8.226],[-1.575,-5.472],[1.179,-10.414],[-4.669,-30.061],[5.213,-26.558],[10.854,-9.079],[15.593,-5.99],[18.682,-10.73],[14.506,-24.975],[18.602,-25.389],[21.788,-21.968],[25.942,-6.615],[30.45,-3.198],[33.867,-7.706],[31.52,-19.024],[34.855,-17.325],[42.104,25.939],[35.054,48.73],[36.137,54.282],[41.689,53.197],[49.988,27.299],[40.713,-22.772],[28.278,-26.742],[19.99,-33.267],[11.192,-32.297],[-7.192,-37.808],[-13.942,-54.599],[-24.101,-61.2]],\"c\":true},\"ix\":2},\"nm\":\"路径 2\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ty\":\"fl\",\"c\":{\"a\":0,\"k\":[0.901960790157,0.298039227724,0.450980395079,1],\"ix\":4},\"o\":{\"a\":0,\"k\":100,\"ix\":5},\"r\":1,\"bm\":0,\"nm\":\"填充 1\",\"mn\":\"ADBE Vector Graphic - Fill\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[64.557,69.909],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":0,\"k\":100,\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"变换\"}],\"nm\":\"组 1\",\"np\":2,\"cix\":2,\"bm\":0,\"ix\":1,\"mn\":\"ADBE Vector Group\",\"hd\":false}],\"ip\":0,\"op\":96,\"st\":0,\"bm\":0}],\"markers\":[]}";
  }
  
  private String d()
  {
    return "{\"v\":\"5.5.5\",\"fr\":25,\"ip\":0,\"op\":38,\"w\":400,\"h\":100,\"nm\":\"预合成 1\",\"ddd\":0,\"assets\":[],\"layers\":[{\"ddd\":0,\"ind\":1,\"ty\":4,\"nm\":\"“图层 5”轮廓\",\"sr\":1,\"ks\":{\"o\":{\"a\":0,\"k\":100,\"ix\":11},\"r\":{\"a\":0,\"k\":0,\"ix\":10},\"p\":{\"a\":0,\"k\":[198.998,49.916,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[52.304,17.042,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100,100],\"ix\":6}},\"ao\":0,\"shapes\":[{\"ty\":\"gr\",\"it\":[{\"ind\":0,\"ty\":\"sh\",\"ix\":1,\"ks\":{\"a\":0,\"k\":{\"i\":[[0,0],[0,0],[0,0],[0,0]],\"o\":[[0,0],[0,0],[0,0],[0,0]],\"v\":[[37.439,-2.466],[28.512,-2.466],[28.512,2.573],[37.439,2.573]],\"c\":true},\"ix\":2},\"nm\":\"路径 1\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ind\":1,\"ty\":\"sh\",\"ix\":2,\"ks\":{\"a\":0,\"k\":{\"i\":[[0,0]],\"o\":[[0,0]],\"v\":[[37.439,2.573]],\"c\":false},\"ix\":2},\"nm\":\"路径 2\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ind\":2,\"ty\":\"sh\",\"ix\":3,\"ks\":{\"a\":0,\"k\":{\"i\":[[0,0],[0,0],[0,0],[-1.08,0],[0,0],[-0.252,0.54],[-0.216,2.088],[0,0],[0.325,-0.899],[1.872,-0.072],[0,0],[0,2.232],[0,0],[0.72,-0.72],[0,0],[-2.304,5.039],[0,0],[0.433,-0.935],[0,0],[0.36,-2.232],[2.664,0],[1.08,0.109],[0,0],[-0.719,0],[-0.143,1.152],[-0.073,7.091],[0,0],[0.828,-1.116],[0,0]],\"o\":[[0,0],[0,0],[0,0.9],[0,0],[0.719,-0.072],[0.181,-0.396],[0,0],[-0.252,2.16],[-0.503,1.513],[0,0],[-2.52,0],[0,0],[-0.719,0.791],[0,0],[3.096,-2.735],[0,0],[-0.431,1.008],[0,0],[0,9.576],[-0.36,2.232],[-0.432,0],[0,0],[1.008,0.108],[0.865,0],[0.217,-1.224],[0,0],[-0.792,1.296],[0,0],[0,0]],\"v\":[[41.219,5.957],[28.513,5.957],[28.513,11.5],[30.097,12.868],[46.439,12.868],[47.878,11.968],[48.49,8.225],[52.054,9.412],[51.189,13.983],[47.662,16.359],[28.513,16.359],[24.733,13.012],[24.733,-4.193],[22.609,-1.926],[19.945,-5.094],[28.009,-16.792],[31.824,-15.929],[30.492,-13.013],[50.002,-13.013],[49.426,4.697],[44.891,8.081],[42.587,7.9],[41.687,4.553],[44.278,4.733],[45.79,3.005],[46.187,-9.449],[28.513,-9.449],[26.101,-5.85],[41.219,-5.85]],\"c\":true},\"ix\":2},\"nm\":\"路径 3\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ind\":3,\"ty\":\"sh\",\"ix\":4,\"ks\":{\"a\":0,\"k\":{\"i\":[[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[0,0]],\"o\":[[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[0,0]],\"v\":[[-2.16,-10.745],[-2.16,-14.381],[15.586,-14.381],[15.586,-10.745],[8.639,-10.745],[8.639,11.752],[16.522,11.752],[16.522,15.424],[-3.168,15.424],[-3.168,11.752],[4.859,11.752],[4.859,-10.745]],\"c\":true},\"ix\":2},\"nm\":\"路径 4\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ind\":4,\"ty\":\"sh\",\"ix\":5,\"ks\":{\"a\":0,\"k\":{\"i\":[[0,0],[4.499,-0.792],[0,0],[-3.599,1.296]],\"o\":[[-3.563,1.295],[0,0],[4.787,-0.755],[0,0]],\"v\":[[-3.852,12.688],[-15.946,15.855],[-16.45,12.148],[-3.852,9.089]],\"c\":true},\"ix\":2},\"nm\":\"路径 5\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ind\":5,\"ty\":\"sh\",\"ix\":6,\"ks\":{\"a\":0,\"k\":{\"i\":[[0,0],[1.836,-2.664],[-1.332,0.216],[-0.829,1.548],[0,0],[2.196,-2.807],[-2.376,0.9],[0,0],[3.671,-0.504],[0,0],[-0.469,0.431],[-1.728,2.879],[0,0],[0,0],[-0.503,0.683],[-1.368,3.817]],\"o\":[[-1.764,4.175],[1.332,-0.144],[0.719,-1.368],[0,0],[-3.168,5.795],[2.304,-0.576],[0,0],[-4.139,1.584],[0,0],[0.648,-0.288],[1.152,-1.153],[0,0],[0,0],[0.576,-0.288],[1.836,-3.168],[0,0]],\"v\":[[-6.623,-15.064],[-12.023,-4.806],[-8.027,-5.346],[-5.687,-9.701],[-2.304,-8.405],[-10.331,4.481],[-3.348,2.249],[-3.348,5.669],[-15.082,8.765],[-16.054,5.345],[-14.362,4.23],[-10.007,-1.854],[-15.658,-1.099],[-16.594,-4.554],[-14.975,-5.993],[-10.187,-16.469]],\"c\":true},\"ix\":2},\"nm\":\"路径 6\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ind\":6,\"ty\":\"sh\",\"ix\":7,\"ks\":{\"a\":0,\"k\":{\"i\":[[0,0],[0,-0.216],[0,0],[0,0],[0,0]],\"o\":[[0,0.216],[0,0],[0,0],[0,0],[0,0]],\"v\":[[-40.176,-3.366],[-40.212,-2.754],[-31.141,-2.754],[-31.141,-11.033],[-40.176,-11.033]],\"c\":true},\"ix\":2},\"nm\":\"路径 7\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ind\":7,\"ty\":\"sh\",\"ix\":8,\"ks\":{\"a\":0,\"k\":{\"i\":[[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[1.044,-2.413],[3.203,-1.62],[0,0],[-1.008,2.519],[-0.288,2.447],[0,0],[0,0],[0,0],[0,0.216],[0,0],[0,0],[0,0]],\"o\":[[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[-0.36,3.527],[-1.404,3.023],[0,0],[2.915,-1.692],[0.648,-1.8],[0,0],[0,0],[0,0],[0,-0.216],[0,0],[0,0],[0,0],[0,0]],\"v\":[[-21.71,-14.669],[-21.71,-11.033],[-27.361,-11.033],[-27.361,-2.754],[-19.91,-2.754],[-19.91,0.882],[-27.361,0.882],[-27.361,16.323],[-31.141,16.323],[-31.141,0.882],[-40.464,0.882],[-42.587,9.809],[-49.498,16.792],[-51.55,13.588],[-45.683,7.253],[-44.279,0.882],[-52.054,0.882],[-52.054,-2.754],[-44.027,-2.754],[-43.991,-3.366],[-43.991,-11.033],[-50.219,-11.033],[-50.219,-14.669]],\"c\":true},\"ix\":2},\"nm\":\"路径 8\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ty\":\"mm\",\"mm\":1,\"nm\":\"合并路径 1\",\"mn\":\"ADBE Vector Filter - Merge\",\"hd\":false},{\"ty\":\"fl\",\"c\":{\"a\":0,\"k\":[1,0.948999980852,0.702000038297,1],\"ix\":4},\"o\":{\"a\":0,\"k\":100,\"ix\":5},\"r\":1,\"bm\":0,\"nm\":\"填充 1\",\"mn\":\"ADBE Vector Graphic - Fill\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[52.304,17.042],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":0,\"k\":100,\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"变换\"}],\"nm\":\"组 1\",\"np\":10,\"cix\":2,\"bm\":0,\"ix\":1,\"mn\":\"ADBE Vector Group\",\"hd\":false}],\"ip\":0,\"op\":96,\"st\":0,\"bm\":0},{\"ddd\":0,\"ind\":2,\"ty\":4,\"nm\":\"“图层 4”轮廓 2\",\"sr\":1,\"ks\":{\"o\":{\"a\":0,\"k\":100,\"ix\":11},\"r\":{\"a\":0,\"k\":0,\"ix\":10},\"p\":{\"a\":0,\"k\":[198.944,50.124,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[185.25,45.25,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100,100],\"ix\":6}},\"ao\":0,\"shapes\":[{\"ty\":\"gr\",\"it\":[{\"ind\":0,\"ty\":\"sh\",\"ix\":1,\"ks\":{\"a\":0,\"k\":{\"i\":[[0,0],[0,-22.091],[-22.091,0],[0,0],[0,22.091],[22.091,0]],\"o\":[[-22.091,0],[0,22.091],[0,0],[22.091,0],[0,-22.091],[0,0]],\"v\":[[-140,-40],[-180,0],[-140,40],[140,40],[180,0],[140,-40]],\"c\":true},\"ix\":2},\"nm\":\"路径 1\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ty\":\"fl\",\"c\":{\"a\":0,\"k\":[0.961000031116,0.211999990426,0.4,1],\"ix\":4},\"o\":{\"a\":0,\"k\":100,\"ix\":5},\"r\":1,\"bm\":0,\"nm\":\"填充 1\",\"mn\":\"ADBE Vector Graphic - Fill\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[185.25,45.25],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":0,\"k\":100,\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"变换\"}],\"nm\":\"组 1\",\"np\":2,\"cix\":2,\"bm\":0,\"ix\":1,\"mn\":\"ADBE Vector Group\",\"hd\":false}],\"ip\":0,\"op\":96,\"st\":0,\"bm\":0},{\"ddd\":0,\"ind\":3,\"ty\":4,\"nm\":\"“图层 4”轮廓 3\",\"sr\":1,\"ks\":{\"o\":{\"a\":0,\"k\":100,\"ix\":11},\"r\":{\"a\":0,\"k\":0,\"ix\":10},\"p\":{\"a\":0,\"k\":[198.944,50.124,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[185.25,45.25,0],\"ix\":1},\"s\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833,0.833,0.833],\"y\":[0.833,0.833,0.833]},\"o\":{\"x\":[0.167,0.167,0.167],\"y\":[0.167,0.167,0.167]},\"t\":13,\"s\":[100,100,100]},{\"i\":{\"x\":[0.833,0.833,0.833],\"y\":[0.833,0.833,0.833]},\"o\":{\"x\":[0.167,0.167,0.167],\"y\":[0.167,0.167,0.167]},\"t\":20,\"s\":[102.5,109.5,100]},{\"t\":31,\"s\":[107.5,121.5,100]}],\"ix\":6}},\"ao\":0,\"shapes\":[{\"ty\":\"gr\",\"it\":[{\"ind\":0,\"ty\":\"sh\",\"ix\":1,\"ks\":{\"a\":0,\"k\":{\"i\":[[0,0],[0,-22.091],[-22.091,0],[0,0],[0,22.091],[22.091,0]],\"o\":[[-22.091,0],[0,22.091],[0,0],[22.091,0],[0,-22.091],[0,0]],\"v\":[[-140,-40],[-180,0],[-140,40],[140,40],[180,0],[140,-40]],\"c\":true},\"ix\":2},\"nm\":\"路径 1\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ty\":\"fl\",\"c\":{\"a\":0,\"k\":[0.961000031116,0.211999990426,0.4,1],\"ix\":4},\"o\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"t\":10,\"s\":[0]},{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"t\":16,\"s\":[50]},{\"t\":38,\"s\":[0]}],\"ix\":5},\"r\":1,\"bm\":0,\"nm\":\"填充 1\",\"mn\":\"ADBE Vector Graphic - Fill\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[185.25,45.25],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":0,\"k\":100,\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"变换\"}],\"nm\":\"组 1\",\"np\":2,\"cix\":2,\"bm\":0,\"ix\":1,\"mn\":\"ADBE Vector Group\",\"hd\":false}],\"ip\":0,\"op\":96,\"st\":0,\"bm\":0},{\"ddd\":0,\"ind\":4,\"ty\":4,\"nm\":\"“图层 4”轮廓\",\"sr\":1,\"ks\":{\"o\":{\"a\":0,\"k\":100,\"ix\":11},\"r\":{\"a\":0,\"k\":0,\"ix\":10},\"p\":{\"a\":0,\"k\":[198.944,50.124,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[185.25,45.25,0],\"ix\":1},\"s\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833,0.833,0.833],\"y\":[0.833,0.833,0.833]},\"o\":{\"x\":[0.167,0.167,0.167],\"y\":[0.167,0.167,0.167]},\"t\":0,\"s\":[100,100,100]},{\"i\":{\"x\":[0.833,0.833,0.833],\"y\":[0.833,0.833,0.833]},\"o\":{\"x\":[0.167,0.167,0.167],\"y\":[0.167,0.167,0.167]},\"t\":16,\"s\":[107.5,121.5,100]},{\"i\":{\"x\":[0.833,0.833,0.833],\"y\":[0.833,0.833,0.833]},\"o\":{\"x\":[0.167,0.167,0.167],\"y\":[0.167,0.167,0.167]},\"t\":24,\"s\":[104.684,113.895,100]},{\"t\":31,\"s\":[107.5,121.5,100]}],\"ix\":6}},\"ao\":0,\"shapes\":[{\"ty\":\"gr\",\"it\":[{\"ind\":0,\"ty\":\"sh\",\"ix\":1,\"ks\":{\"a\":0,\"k\":{\"i\":[[0,0],[0,-22.091],[-22.091,0],[0,0],[0,22.091],[22.091,0]],\"o\":[[-22.091,0],[0,22.091],[0,0],[22.091,0],[0,-22.091],[0,0]],\"v\":[[-140,-40],[-180,0],[-140,40],[140,40],[180,0],[140,-40]],\"c\":true},\"ix\":2},\"nm\":\"路径 1\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ty\":\"fl\",\"c\":{\"a\":0,\"k\":[0.961000031116,0.211999990426,0.4,1],\"ix\":4},\"o\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"t\":0,\"s\":[0]},{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"t\":10,\"s\":[50]},{\"t\":33,\"s\":[0]}],\"ix\":5},\"r\":1,\"bm\":0,\"nm\":\"填充 1\",\"mn\":\"ADBE Vector Graphic - Fill\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[185.25,45.25],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":0,\"k\":100,\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"变换\"}],\"nm\":\"组 1\",\"np\":2,\"cix\":2,\"bm\":0,\"ix\":1,\"mn\":\"ADBE Vector Group\",\"hd\":false}],\"ip\":0,\"op\":96,\"st\":0,\"bm\":0}],\"markers\":[]}";
  }
  
  private void e()
  {
    this.o.setVisibility(0);
    this.k.setText(HardCodeUtil.a(R.string.aD));
    this.s.setVisibility(4);
    String str1 = this.J.mQQWalletRedPacketMsg.elem.c;
    String str2 = this.J.mQQWalletRedPacketMsg.body.feedId;
    if (getQBaseActivity() != null)
    {
      if (getQBaseActivity().isFinishing()) {
        return;
      }
      DrawClassifier.a().a(getQBaseActivity(), str2, str1, new DrawRedpacketPannelPreviewFragment.2(this, str1));
    }
  }
  
  private void f()
  {
    DrawClassifier.a().a(this.d.getDoodleItem(), new DrawRedpacketPannelPreviewFragment.4(this));
  }
  
  private void g()
  {
    String str = DrawClassifier.a().c();
    ThreadManager.getUIHandlerV2().post(new DrawRedpacketPannelPreviewFragment.5(this, str));
  }
  
  private String h()
  {
    int i1 = new Random().nextInt(this.w.length);
    return this.w[i1];
  }
  
  private void i()
  {
    Object localObject = QWalletTools.b();
    if (localObject != null)
    {
      localObject = (IPasswdRedBagService)((BaseQQAppInterface)localObject).getRuntimeService(IPasswdRedBagService.class);
      if ((localObject != null) && (this.v))
      {
        PasswdRedBagInfo localPasswdRedBagInfo = ((IPasswdRedBagService)localObject).getPasswdRedBagInfoById(this.J.mQQWalletRedPacketMsg.redPacketId);
        ((IPasswdRedBagService)localObject).setPasswdRedBagOpen(this.J.mQQWalletRedPacketMsg.redPacketId, this.I.b, this.I.a);
        Bundle localBundle = new Bundle();
        localBundle.putInt("subchannel", this.J.mQQWalletRedPacketMsg.body.subChannel);
        ((IPasswdRedBagService)localObject).openPasswdBagByTenpay(this.I, localPasswdRedBagInfo, 0L, 1000001, "", this.J.mQQWalletRedPacketMsg.elem.v, this.J.fromHBList, localBundle);
      }
    }
  }
  
  private String j()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(QWalletTools.a());
    ((StringBuilder)localObject1).append("Camera/");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("png");
    localObject2 = new File(((StringBuilder)localObject2).toString());
    if ((((File)localObject2).exists()) && (!((File)localObject2).isDirectory())) {
      ((File)localObject2).delete();
    }
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdir();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("png");
    return ((StringBuilder)localObject2).toString();
  }
  
  private Bitmap k()
  {
    Bitmap localBitmap = Bitmap.createBitmap(this.d.getWidth(), this.d.getHeight() + DisplayUtil.a(getQBaseActivity(), 50.0F), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Drawable localDrawable = this.d.getBackground();
    if (localDrawable != null) {
      localDrawable.draw(localCanvas);
    } else {
      localCanvas.drawColor(-1);
    }
    localCanvas.drawColor(-1);
    this.d.draw(localCanvas);
    return a(getQBaseActivity(), localBitmap, this.J.mQQWalletRedPacketMsg.elem.c, 40, Color.parseColor("#878B99"));
  }
  
  private void l()
  {
    this.u.post(new DrawRedpacketPannelPreviewFragment.12(this));
  }
  
  protected void a(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i(a, 2, "initUI");
    }
    super.a(paramView);
    ((ViewStub)paramView.findViewById(R.id.cm)).inflate();
    String str = h();
    this.c = ((TextView)getQBaseActivity().findViewById(R.id.cR));
    this.i = ((TextView)paramView.findViewById(R.id.ag));
    this.j = ((TextView)paramView.findViewById(R.id.ai));
    this.k = ((TextView)paramView.findViewById(R.id.ah));
    this.l = ((ImageView)paramView.findViewById(R.id.O));
    this.l.setOnClickListener(this);
    QWalletTools.a(this.l, 0.3F);
    this.m = ((ImageView)paramView.findViewById(R.id.G));
    a(this.m);
    this.q = paramView.findViewById(R.id.bY);
    this.e = ((ImageView)paramView.findViewById(R.id.r));
    this.e.setOnClickListener(this);
    this.s = ((Button)paramView.findViewById(R.id.s));
    this.s.setOnClickListener(this);
    QWalletTools.a(this.s, 0.3F);
    this.h = ((RelativeLayout)paramView.findViewById(R.id.ca));
    this.f = ((TextView)paramView.findViewById(R.id.bQ));
    this.o = ((ImageView)paramView.findViewById(R.id.av));
    Drawable localDrawable = getResources().getDrawable(R.drawable.q);
    this.o.setBackgroundDrawable(localDrawable);
    ((Animatable)localDrawable).start();
    this.n = ((ImageView)paramView.findViewById(R.id.as));
    this.n.setOnClickListener(this);
    this.r = ((TextView)paramView.findViewById(R.id.be));
    this.g = ((ImageView)paramView.findViewById(R.id.t));
    this.g.setOnClickListener(this);
    LottieComposition.Factory.fromJsonString(d(), new DrawRedpacketPannelPreviewFragment.6(this));
    this.d = ((DoodleLayout)paramView.findViewById(R.id.F));
    this.d.setColor(Color.parseColor(str));
    this.d.setDoodleLayoutListener(new DrawRedpacketPannelPreviewFragment.7(this));
    this.t = new QQCustomDialog(getQBaseActivity(), R.style.b);
    this.t.setContentView(R.layout.a);
    this.t.setTitle(HardCodeUtil.a(R.string.aF));
    this.t.setMessage(HardCodeUtil.a(R.string.aB));
    this.t.setNegativeButton(HardCodeUtil.a(R.string.ak), new DrawRedpacketPannelPreviewFragment.8(this));
    this.t.setPositiveButton(HardCodeUtil.a(R.string.at), new DrawRedpacketPannelPreviewFragment.9(this));
    this.p = ((ImageView)paramView.findViewById(R.id.n));
    this.p.setOnClickListener(this);
  }
  
  public void a(boolean paramBoolean, View paramView1, View paramView2, float paramFloat1, float paramFloat2)
  {
    float f1 = this.h.getWidth() / 2.0F;
    float f2 = this.h.getHeight() / 2.0F;
    Animation localAnimation = ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).createRotate3dAnimation(paramFloat1, paramFloat2, f1, f2, 610.0F, true);
    localAnimation.setDuration(250L);
    localAnimation.setFillAfter(true);
    localAnimation.setInterpolator(new AccelerateInterpolator());
    localAnimation.setAnimationListener(new DrawRedpacketPannelPreviewFragment.DisplayNextView(this, paramBoolean, paramView1, paramView2, null));
    this.h.startAnimation(localAnimation);
  }
  
  protected boolean a()
  {
    if (!super.a()) {
      return false;
    }
    this.G.setBackgroundDrawable(getResources().getDrawable(R.drawable.j));
    Object localObject1 = ((IContactUtilsApi)QRoute.api(IContactUtilsApi.class)).getBuddyName(this.J.senderuin, true);
    localObject1 = QWalletTools.a(getQBaseActivity(), (String)localObject1, 135.0F, this.F.getPaint());
    Object localObject2 = this.F;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(HardCodeUtil.a(R.string.aC));
    ((TextView)localObject2).setText(localStringBuilder.toString());
    localObject1 = this.r;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("【");
    ((StringBuilder)localObject2).append(this.J.mQQWalletRedPacketMsg.elem.c);
    ((StringBuilder)localObject2).append("】");
    ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
    ReportController.b(getQBaseActivity().getAppRuntime(), "P_CliOper", "Vip_pay_mywallet", "", "501", "draw.popup.show", 0, 0, "", "", "", "");
    return true;
  }
  
  protected boolean b()
  {
    View localView = this.q;
    return (localView == null) || (localView.getVisibility() != 0);
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    e();
    this.x = false;
    this.e.setOnLongClickListener(new DrawRedpacketPannelPreviewFragment.3(this));
  }
  
  public boolean onBackEvent()
  {
    ReportController.b(getQBaseActivity().getAppRuntime(), "P_CliOper", "Vip_pay_mywallet", "", "501", "draw.popup.flip", 0, 0, "", "", "", "");
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    int i1 = paramView.getId();
    if (i1 == R.id.n)
    {
      getQBaseActivity().doOnBackPressed();
      return;
    }
    if (i1 == R.id.r)
    {
      paramView = this.d;
      if (paramView != null)
      {
        if (paramView.b(false, false) == 0) {
          return;
        }
        this.d.a();
        l();
      }
      this.v = false;
      this.f.setTextColor(Color.parseColor("#878B99"));
      this.f.setText(HardCodeUtil.a(R.string.az));
      f();
      ReportController.b(getQBaseActivity().getAppRuntime(), "P_CliOper", "Vip_pay_mywallet", "", "501", "draw.popup.erase", 0, 0, "", "", "", "");
      return;
    }
    if (i1 == R.id.t)
    {
      i();
      a(this.I.b, this.I.a, this.I.c, this.I.v);
      ReportController.b(getQBaseActivity().getAppRuntime(), "P_CliOper", "Vip_pay_mywallet", "", "501", "draw.popup.open", 0, 0, "", "", "", "");
      return;
    }
    if (i1 == R.id.O)
    {
      long l1 = System.currentTimeMillis();
      if (!((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).isValideToDoAction(b, l1)) {
        return;
      }
      b = l1;
      if (!((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).getBoolean(getQBaseActivity().getAppRuntime().getCurrentAccountUin(), "", false))
      {
        this.e.setVisibility(8);
        this.d.setVisibility(8);
        this.n.setVisibility(0);
        LottieComposition.Factory.fromJsonString(c(), new DrawRedpacketPannelPreviewFragment.10(this));
      }
      else
      {
        this.n.setVisibility(8);
        this.e.setVisibility(0);
        this.d.setVisibility(0);
      }
      a(true, this.B, this.q, 0.0F, 90.0F);
      ReportController.b(getQBaseActivity().getAppRuntime(), "P_CliOper", "Vip_pay_mywallet", "", "501", "draw.popup.click", 0, 0, "", "", "", "");
      return;
    }
    if (i1 == R.id.as)
    {
      this.n.setVisibility(8);
      this.e.setVisibility(0);
      this.d.setVisibility(0);
      return;
    }
    if (i1 == R.id.s) {
      e();
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    Object localObject = this.u;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.t;
    if ((localObject != null) && (((QQCustomDialog)localObject).isShowing()))
    {
      this.t.dismiss();
      this.t = null;
    }
    b(this.n);
    b(this.g);
    b(this.m);
    DrawClassifier.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.DrawRedpacketPannelPreviewFragment
 * JD-Core Version:    0.7.0.1
 */