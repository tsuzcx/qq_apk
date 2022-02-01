package com.tencent.mobileqq.minigame.manager;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.minigame.data.BlockAdInfo;
import com.tencent.mobileqq.minigame.widget.BlockAdView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;

public class BlockAdManager
{
  private static final String ORIENTATION_LANDSCAPE = "landscape";
  private static final String ORIENTATION_VERTICAL = "vertical";
  private static final String TAG = "BlockAdManager";
  private static BlockAdManager mInstance;
  private HashMap<Integer, BlockAdInfo> blockAdInfoHashMap = new HashMap();
  private HashMap<Integer, BlockAdView> blockAdViewMap = new HashMap();
  private float mGameDensity = -1.0F;
  private int mGameHeight = 0;
  private int mGameWidth = 0;
  
  public static BlockAdManager getInstance()
  {
    if (mInstance == null) {
      mInstance = new BlockAdManager();
    }
    return mInstance;
  }
  
  public void destroyBlockAdView(int paramInt)
  {
    if (getBlockAdView(paramInt) != null) {
      this.blockAdViewMap.remove(Integer.valueOf(paramInt));
    }
    if (getBlockAdInfo(paramInt) != null) {
      this.blockAdInfoHashMap.remove(Integer.valueOf(paramInt));
    }
  }
  
  public int gameDpTopx(float paramFloat)
  {
    float f = this.mGameDensity;
    if (f > 0.0F) {
      return Math.round(paramFloat * f);
    }
    return Math.round(paramFloat * getDensity());
  }
  
  public BlockAdView genarateBlockAdView(Context paramContext, BlockAdInfo paramBlockAdInfo)
  {
    if (paramBlockAdInfo == null) {
      return null;
    }
    boolean bool;
    if (paramBlockAdInfo.getOri() == 90) {
      bool = true;
    } else {
      bool = false;
    }
    paramContext = new BlockAdView(paramContext, bool);
    paramContext.setData(paramBlockAdInfo);
    this.blockAdViewMap.put(Integer.valueOf(paramBlockAdInfo.getCompId()), paramContext);
    return paramContext;
  }
  
  public BlockAdInfo getBlockAdInfo(int paramInt)
  {
    return (BlockAdInfo)this.blockAdInfoHashMap.get(Integer.valueOf(paramInt));
  }
  
  public BlockAdView getBlockAdView(int paramInt)
  {
    HashMap localHashMap = this.blockAdViewMap;
    if ((localHashMap != null) && (localHashMap.containsKey(Integer.valueOf(paramInt)))) {
      return (BlockAdView)this.blockAdViewMap.get(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  public float getDensity()
  {
    if (this.mGameDensity == -1.0F) {
      this.mGameDensity = ViewUtils.a();
    }
    return this.mGameDensity;
  }
  
  public int getGameHeight()
  {
    if (this.mGameHeight == 0) {
      this.mGameHeight = ViewUtils.b();
    }
    return this.mGameHeight;
  }
  
  public int getGameWidth()
  {
    if (this.mGameWidth == 0) {
      this.mGameWidth = ViewUtils.a();
    }
    return this.mGameWidth;
  }
  
  public ArrayList<String> getReportUrlList(List<GdtAd> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        GdtAd localGdtAd = (GdtAd)paramList.next();
        if ((localGdtAd != null) && (localGdtAd.info != null) && (localGdtAd.info.report_info != null) && (localGdtAd.info.report_info.exposure_url != null)) {
          localArrayList.add(localGdtAd.info.report_info.exposure_url.get());
        }
      }
    }
    return localArrayList;
  }
  
  public void initActivitySize(Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    if ((this.mGameDensity > 0.0F) && (this.mGameWidth > 0) && (this.mGameHeight > 0)) {
      return;
    }
    DisplayMetrics localDisplayMetrics = paramActivity.getResources().getDisplayMetrics();
    if (Build.VERSION.SDK_INT >= 17)
    {
      localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)paramActivity.getSystemService("window")).getDefaultDisplay().getRealMetrics(localDisplayMetrics);
    }
    this.mGameDensity = localDisplayMetrics.density;
    this.mGameWidth = localDisplayMetrics.widthPixels;
    this.mGameHeight = localDisplayMetrics.heightPixels;
    int i;
    int j;
    if (paramActivity.getResources().getConfiguration().orientation == 2)
    {
      i = this.mGameHeight;
      j = this.mGameWidth;
      if (i > j)
      {
        this.mGameHeight = j;
        this.mGameWidth = i;
      }
    }
    else
    {
      i = this.mGameWidth;
      j = this.mGameHeight;
      if (i > j)
      {
        this.mGameHeight = i;
        this.mGameWidth = j;
      }
    }
    paramActivity = new StringBuilder();
    paramActivity.append("density = ");
    paramActivity.append(localDisplayMetrics.density);
    paramActivity.append(", ViewUtils.density = ");
    paramActivity.append(ViewUtils.a());
    paramActivity.append(", screenW = ");
    paramActivity.append(this.mGameWidth);
    paramActivity.append(", screenH = ");
    paramActivity.append(this.mGameHeight);
    QLog.i("BlockAdManager", 1, paramActivity.toString());
  }
  
  /* Error */
  public BlockAdInfo parseBlockAdInfoFromJson(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 274	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: ldc_w 276
    //   12: astore 9
    //   14: iconst_m1
    //   15: istore 6
    //   17: aload 9
    //   19: astore 10
    //   21: new 278	org/json/JSONObject
    //   24: dup
    //   25: aload_1
    //   26: invokespecial 281	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   29: astore 11
    //   31: aload 9
    //   33: astore 10
    //   35: aload 11
    //   37: ldc_w 283
    //   40: invokevirtual 287	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   43: astore 9
    //   45: aload 9
    //   47: astore 10
    //   49: aload 11
    //   51: ldc_w 289
    //   54: invokevirtual 293	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   57: ldc_w 295
    //   60: invokevirtual 299	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   63: istore_3
    //   64: aload 11
    //   66: ldc_w 289
    //   69: invokevirtual 293	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   72: ldc_w 301
    //   75: invokevirtual 299	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   78: istore 4
    //   80: aload 11
    //   82: ldc_w 302
    //   85: iconst_1
    //   86: invokevirtual 306	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   89: istore 5
    //   91: aload 11
    //   93: ldc_w 307
    //   96: ldc 8
    //   98: invokevirtual 311	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   101: astore 10
    //   103: ldc 8
    //   105: aload 10
    //   107: invokevirtual 316	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   110: ifeq +9 -> 119
    //   113: bipush 90
    //   115: istore_2
    //   116: goto +24 -> 140
    //   119: ldc 11
    //   121: aload 10
    //   123: invokevirtual 316	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   126: istore 8
    //   128: iload 8
    //   130: ifeq +8 -> 138
    //   133: iconst_0
    //   134: istore_2
    //   135: goto +5 -> 140
    //   138: iconst_m1
    //   139: istore_2
    //   140: aload 11
    //   142: ldc_w 318
    //   145: invokevirtual 299	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   148: istore 7
    //   150: iload 7
    //   152: istore 6
    //   154: goto +84 -> 238
    //   157: astore 10
    //   159: goto +41 -> 200
    //   162: astore 10
    //   164: goto +34 -> 198
    //   167: astore 10
    //   169: goto +26 -> 195
    //   172: astore 10
    //   174: iconst_m1
    //   175: istore 4
    //   177: goto +18 -> 195
    //   180: astore 11
    //   182: iconst_m1
    //   183: istore 4
    //   185: iconst_m1
    //   186: istore_3
    //   187: aload 10
    //   189: astore 9
    //   191: aload 11
    //   193: astore 10
    //   195: iconst_m1
    //   196: istore 5
    //   198: iconst_m1
    //   199: istore_2
    //   200: new 236	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   207: astore 11
    //   209: aload 11
    //   211: ldc_w 320
    //   214: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: aload 11
    //   220: aload_1
    //   221: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: ldc 14
    //   227: iconst_2
    //   228: aload 11
    //   230: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: aload 10
    //   235: invokestatic 323	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   238: aload 9
    //   240: invokestatic 274	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   243: ifne +58 -> 301
    //   246: iload_3
    //   247: iflt +54 -> 301
    //   250: iload 4
    //   252: iflt +49 -> 301
    //   255: iload 6
    //   257: iflt +44 -> 301
    //   260: iload_2
    //   261: ifge +6 -> 267
    //   264: goto +37 -> 301
    //   267: new 85	com/tencent/mobileqq/minigame/data/BlockAdInfo
    //   270: dup
    //   271: aload 9
    //   273: iload_3
    //   274: iload 4
    //   276: iload 5
    //   278: iload_2
    //   279: iload 6
    //   281: invokespecial 326	com/tencent/mobileqq/minigame/data/BlockAdInfo:<init>	(Ljava/lang/String;IIIII)V
    //   284: astore_1
    //   285: aload_0
    //   286: getfield 37	com/tencent/mobileqq/minigame/manager/BlockAdManager:blockAdInfoHashMap	Ljava/util/HashMap;
    //   289: iload 6
    //   291: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   294: aload_1
    //   295: invokevirtual 105	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   298: pop
    //   299: aload_1
    //   300: areturn
    //   301: aconst_null
    //   302: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	303	0	this	BlockAdManager
    //   0	303	1	paramString	String
    //   115	164	2	i	int
    //   63	211	3	j	int
    //   78	197	4	k	int
    //   89	188	5	m	int
    //   15	275	6	n	int
    //   148	3	7	i1	int
    //   126	3	8	bool	boolean
    //   12	260	9	localObject1	Object
    //   19	103	10	localObject2	Object
    //   157	1	10	localException1	java.lang.Exception
    //   162	1	10	localException2	java.lang.Exception
    //   167	1	10	localException3	java.lang.Exception
    //   172	16	10	localException4	java.lang.Exception
    //   193	41	10	localObject3	Object
    //   29	112	11	localJSONObject	org.json.JSONObject
    //   180	12	11	localException5	java.lang.Exception
    //   207	22	11	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   140	150	157	java/lang/Exception
    //   91	113	162	java/lang/Exception
    //   119	128	162	java/lang/Exception
    //   80	91	167	java/lang/Exception
    //   64	80	172	java/lang/Exception
    //   21	31	180	java/lang/Exception
    //   35	45	180	java/lang/Exception
    //   49	64	180	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.BlockAdManager
 * JD-Core Version:    0.7.0.1
 */