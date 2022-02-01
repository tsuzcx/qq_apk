package com.tencent.mobileqq.scribble;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.jsonconverter.JSONConverter;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.transfile.predownload.RunnableTask;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ScribbleResMgr
  extends BaseScribbleResMgr
{
  static ScribbleResMgr i;
  static Object j = new Object();
  public boolean g = false;
  protected Handler h = new Handler(ThreadManager.getSubThreadLooper());
  private final Handler k = new ScribbleResMgr.1(this, Looper.getMainLooper());
  private final ArrayList<ScribbleResMgr.CallbackPack> l = new ArrayList();
  private ArrayList<ResInfo> m = new ArrayList();
  private ArrayList<ResInfo> n = new ArrayList();
  private boolean o = false;
  private boolean p = false;
  private String q = "";
  private String r = "";
  private String s = "";
  private String t = "";
  private boolean u = false;
  private boolean v = true;
  private Lock w = new ReentrantLock();
  
  public static ScribbleResMgr a()
  {
    ??? = i;
    if (??? != null) {
      return ???;
    }
    synchronized (j)
    {
      if (i != null)
      {
        localScribbleResMgr = i;
        return localScribbleResMgr;
      }
      i = new ScribbleResMgr();
      ScribbleResMgr localScribbleResMgr = i;
      return localScribbleResMgr;
    }
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder;
    if (paramInt1 == 1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(d);
      localStringBuilder.append("line_icon_");
      localStringBuilder.append(String.valueOf(paramInt2));
      localStringBuilder.append(".png");
      return localStringBuilder.toString();
    }
    if (paramInt1 == 2)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(e);
      localStringBuilder.append("gif_icon_");
      localStringBuilder.append(String.valueOf(paramInt2));
      localStringBuilder.append(".png");
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public static ArrayList<ResInfo> a(JSONArray paramJSONArray, int paramInt)
  {
    if (paramJSONArray == null) {
      return null;
    }
    try
    {
      int i2 = paramJSONArray.length();
      if (i2 <= 0) {
        return null;
      }
      localObject = new ArrayList(i2);
      int i1 = 0;
      while (i1 < i2)
      {
        ResInfo localResInfo = (ResInfo)JSONConverter.a(paramJSONArray.getJSONObject(i1), ResInfo.class);
        if (localResInfo != null)
        {
          localResInfo.a = paramInt;
          ((ArrayList)localObject).add(localResInfo);
        }
        i1 += 1;
      }
      return localObject;
    }
    catch (JSONException paramJSONArray)
    {
      Object localObject;
      if (QLog.isDevelopLevel())
      {
        paramJSONArray.printStackTrace();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("convertFromErr: ");
        ((StringBuilder)localObject).append(paramJSONArray);
        QLog.e("ScribbleResMgr", 2, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  private void a(int paramInt1, int paramInt2, View paramView, ResCallback paramResCallback)
  {
    try
    {
      Iterator localIterator = this.l.iterator();
      while (localIterator.hasNext())
      {
        ScribbleResMgr.CallbackPack localCallbackPack = (ScribbleResMgr.CallbackPack)localIterator.next();
        if (localCallbackPack.a() == paramView)
        {
          localCallbackPack.b = new WeakReference(paramResCallback);
          return;
        }
      }
      this.l.add(new ScribbleResMgr.CallbackPack(this, paramInt1, paramInt2, paramView, paramResCallback));
      return;
    }
    finally {}
    for (;;)
    {
      throw paramView;
    }
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt1 == 3) {
      this.p = paramBoolean;
    }
    if (paramInt1 == 4) {
      this.o = paramBoolean;
    }
    Iterator localIterator;
    ResInfo localResInfo;
    if (paramInt1 == 2)
    {
      localIterator = this.m.iterator();
      while (localIterator.hasNext())
      {
        localResInfo = (ResInfo)localIterator.next();
        if ((localResInfo != null) && (localResInfo.b == paramInt2)) {
          localResInfo.g = paramBoolean;
        }
      }
    }
    if (paramInt1 == 1)
    {
      localIterator = this.n.iterator();
      while (localIterator.hasNext())
      {
        localResInfo = (ResInfo)localIterator.next();
        if ((localResInfo != null) && (localResInfo.b == paramInt2)) {
          localResInfo.g = paramBoolean;
        }
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    c(paramQQAppInterface);
    int i4 = 0;
    if (paramInt1 == 3)
    {
      if (TextUtils.isEmpty(this.q))
      {
        i2 = 1;
        break label48;
      }
      if (!this.p) {
        a(paramQQAppInterface, paramInt1, 50L);
      }
    }
    int i2 = 0;
    label48:
    int i1 = i2;
    if (paramInt1 == 4) {
      if (TextUtils.isEmpty(this.s))
      {
        i1 = 1;
      }
      else
      {
        i1 = i2;
        if (!this.o)
        {
          a(paramQQAppInterface, paramInt1, 50L);
          i1 = i2;
        }
      }
    }
    i2 = i1;
    Object localObject1;
    Object localObject2;
    if (paramInt1 == 1)
    {
      if (this.n.isEmpty()) {}
      int i3;
      label223:
      do
      {
        i2 = 1;
        break;
        localObject1 = d();
        if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
        {
          localObject1 = ((ArrayList)localObject1).iterator();
          while ((localObject1 != null) && (((Iterator)localObject1).hasNext()))
          {
            localObject2 = (ResInfo)((Iterator)localObject1).next();
            if ((localObject2 != null) && (((ResInfo)localObject2).b == paramInt2))
            {
              if (!((ResInfo)localObject2).g)
              {
                ((ResInfo)localObject2).g = true;
                a(paramQQAppInterface, (ResInfo)localObject2, 50L, false);
              }
              i3 = 1;
              break label223;
            }
          }
        }
        i3 = 0;
        i2 = i1;
      } while (i3 == 0);
    }
    i1 = i2;
    if (paramInt1 == 2)
    {
      if (this.m.isEmpty()) {}
      do
      {
        i1 = 1;
        break;
        localObject1 = e();
        paramInt1 = i4;
        if (localObject1 != null)
        {
          paramInt1 = i4;
          if (((ArrayList)localObject1).size() > 0)
          {
            localObject2 = ((ArrayList)localObject1).iterator();
            do
            {
              paramInt1 = i4;
              if (localObject2 == null) {
                break;
              }
              paramInt1 = i4;
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localObject1 = (ResInfo)((Iterator)localObject2).next();
            } while ((localObject1 == null) || (((ResInfo)localObject1).b != paramInt2));
            long l1;
            if (!((ResInfo)localObject1).g)
            {
              ((ResInfo)localObject1).g = true;
              l1 = Thread.currentThread().getId();
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("RESOURCE_TYPE_GIF threadId: ");
              ((StringBuilder)localObject2).append(l1);
              ((StringBuilder)localObject2).append(" inf.resType:  ");
              ((StringBuilder)localObject2).append(((ResInfo)localObject1).a);
              ((StringBuilder)localObject2).append(" resID: ");
              ((StringBuilder)localObject2).append(((ResInfo)localObject1).b);
              ((StringBuilder)localObject2).append(" downloading is false set true");
              QLog.i("ScribbleResMgr", 2, ((StringBuilder)localObject2).toString());
              a(paramQQAppInterface, (ResInfo)localObject1, 0L, false);
            }
            else
            {
              l1 = Thread.currentThread().getId();
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("RESOURCE_TYPE_GIF threadId: ");
              ((StringBuilder)localObject2).append(l1);
              ((StringBuilder)localObject2).append(" inf.resType:  ");
              ((StringBuilder)localObject2).append(((ResInfo)localObject1).a);
              ((StringBuilder)localObject2).append(" resID: ");
              ((StringBuilder)localObject2).append(((ResInfo)localObject1).b);
              ((StringBuilder)localObject2).append("is downloading  ");
              QLog.i("ScribbleResMgr", 2, ((StringBuilder)localObject2).toString());
            }
            paramInt1 = 1;
          }
        }
        i1 = i2;
      } while (paramInt1 == 0);
    }
    if ((i1 != 0) && (!this.u))
    {
      this.u = true;
      ConfigServlet.e(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin());
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, int paramInt, long paramLong)
  {
    this.h.postDelayed(new ScribbleResMgr.5(this, paramInt, paramQQAppInterface), paramLong);
  }
  
  private void a(QQAppInterface paramQQAppInterface, ResInfo paramResInfo, long paramLong, boolean paramBoolean)
  {
    if (paramResInfo == null) {
      return;
    }
    ScribbleResMgr.4 local4 = new ScribbleResMgr.4(this, paramResInfo);
    if (paramBoolean)
    {
      IPreDownloadController localIPreDownloadController = (IPreDownloadController)paramQQAppInterface.getRuntimeService(IPreDownloadController.class);
      if (localIPreDownloadController.isEnable())
      {
        String str = null;
        if (paramResInfo.a == 1) {
          str = b(paramResInfo.a, paramResInfo.b);
        }
        if (paramResInfo.a == 2) {
          str = d(paramResInfo.b);
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("download res, predownload enable:");
          localStringBuilder.append(paramResInfo.b);
          localStringBuilder.append(" ");
          localStringBuilder.append(paramResInfo.a);
          localStringBuilder.append(" outpath:");
          localStringBuilder.append(str);
          localStringBuilder.append(" url:");
          localStringBuilder.append(paramResInfo.c);
          QLog.d("ScribbleResMgr", 2, localStringBuilder.toString());
        }
        paramQQAppInterface = new RunnableTask(paramQQAppInterface, "doodle_msg_res", local4, 4000L);
        localIPreDownloadController.requestPreDownload(10068, "prd", String.valueOf(paramResInfo.b), 0, paramResInfo.c, str, 2, 0, true, paramQQAppInterface);
        return;
      }
    }
    paramQQAppInterface = (IPreDownloadController)paramQQAppInterface.getRuntimeService(IPreDownloadController.class);
    if (paramQQAppInterface.isEnable())
    {
      paramQQAppInterface.cancelPreDownload(paramResInfo.c);
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("download res, cancel predownload reqeust Url:");
        paramQQAppInterface.append(paramResInfo.c);
        QLog.d("ScribbleResMgr", 2, paramQQAppInterface.toString());
      }
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("download res, normal download:");
      paramQQAppInterface.append(paramResInfo.b);
      paramQQAppInterface.append(" ");
      paramQQAppInterface.append(paramResInfo.a);
      paramQQAppInterface.append(" Url:");
      paramQQAppInterface.append(paramResInfo.c);
      QLog.d("ScribbleResMgr", 2, paramQQAppInterface.toString());
    }
    this.h.postDelayed(local4, paramLong);
  }
  
  private void a(ResInfo paramResInfo, int paramInt)
  {
    Message localMessage = new Message();
    localMessage.what = paramInt;
    localMessage.obj = paramResInfo;
    localMessage.arg1 = paramResInfo.a;
    this.k.sendMessageDelayed(localMessage, 0L);
    b(paramResInfo.a, paramResInfo.b, false);
  }
  
  private void a(ArrayList<ResInfo> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() < 2) {
        return;
      }
      Collections.sort(paramArrayList, new ScribbleResMgr.3(this));
    }
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    boolean bool = SharedPreUtils.ba(paramContext, paramString);
    paramContext = new StringBuilder();
    paramContext.append("getNeedScribbleRedShow");
    paramContext.append(bool);
    QLog.d("ScribbleResMgr", 2, paramContext.toString());
    return bool;
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    String str = SharedPreUtils.R(paramQQAppInterface.getApp().getBaseContext());
    StringBuilder localStringBuilder = null;
    JSONArray localJSONArray = null;
    Object localObject1;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      if (localJSONObject.has("version")) {
        localObject1 = localJSONObject.getString("version");
      } else {
        localObject1 = null;
      }
      try
      {
        if (localJSONObject.has("iconUrl")) {
          this.q = localJSONObject.getString("iconUrl");
        }
        if (localJSONObject.has("iconMd5")) {
          this.r = localJSONObject.getString("iconMd5");
        }
        if (localJSONObject.has("content")) {
          localJSONArray = localJSONObject.getJSONArray("content");
        }
        bool = true;
      }
      catch (JSONException localJSONException1) {}
      localJSONException2.printStackTrace();
    }
    catch (JSONException localJSONException2)
    {
      localObject1 = null;
    }
    QLog.e("ScribbleResMgr", 2, "RESOURCE_CONFIG_TASK_ID_PAINT JSON EXCEPT");
    boolean bool = false;
    Object localObject2 = localStringBuilder;
    localObject2 = a((JSONArray)localObject2, 1);
    c((ArrayList)localObject2);
    if (((str == null) || (!str.equalsIgnoreCase((String)localObject1))) && (bool))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("RESOURCE_CONFIG_TASK_ID_PAINT newVersion = ");
      localStringBuilder.append((String)localObject1);
      QLog.i("ScribbleResMgr", 2, localStringBuilder.toString());
      SharedPreUtils.aV(paramQQAppInterface.getApp().getBaseContext(), (String)localObject1);
      SharedPreUtils.aX(paramQQAppInterface.getApp().getBaseContext(), paramString);
      a(paramQQAppInterface, 3, f.longValue());
      if ((localObject2 != null) && (!((ArrayList)localObject2).isEmpty())) {
        paramString = ((ArrayList)localObject2).iterator();
      }
    }
    else
    {
      while (paramString.hasNext())
      {
        localObject1 = (ResInfo)paramString.next();
        if (!((ResInfo)localObject1).g)
        {
          if ((((ResInfo)localObject1).f == 1) || (this.u)) {
            a(paramQQAppInterface, (ResInfo)localObject1, f.longValue(), true);
          }
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("mArrPaintInfo index :");
          ((StringBuilder)localObject2).append(((ResInfo)localObject1).b);
          ((StringBuilder)localObject2).append(" is downloading ");
          QLog.e("ScribbleResMgr", 2, ((StringBuilder)localObject2).toString());
          continue;
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("RESOURCE_CONFIG_TASK_ID_PAINT newVersion = ");
          paramQQAppInterface.append((String)localObject1);
          paramQQAppInterface.append(" oldVersion=  ");
          paramQQAppInterface.append(str);
          QLog.i("ScribbleResMgr", 2, paramQQAppInterface.toString());
        }
      }
    }
    return bool;
  }
  
  private boolean a(String paramString)
  {
    Object localObject = null;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      if (localJSONObject.has("iconUrl")) {
        this.q = localJSONObject.getString("iconUrl");
      }
      if (localJSONObject.has("iconMd5")) {
        this.r = localJSONObject.getString("iconMd5");
      }
      paramString = localObject;
      if (localJSONObject.has("content")) {
        paramString = localJSONObject.getJSONArray("content");
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      QLog.e("ScribbleResMgr", 2, "parsePaintConfigInfo JSON EXCEPT");
      paramString = localObject;
    }
    c(a(paramString, 1));
    return true;
  }
  
  /* Error */
  public static boolean a(String paramString1, Context paramContext, String paramString2)
  {
    // Byte code:
    //   0: fconst_0
    //   1: fstore 6
    //   3: fconst_0
    //   4: fstore 5
    //   6: fconst_0
    //   7: fstore 4
    //   9: iconst_0
    //   10: istore 15
    //   12: iconst_1
    //   13: istore 16
    //   15: new 429	org/json/JSONObject
    //   18: dup
    //   19: aload_0
    //   20: invokespecial 431	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   23: astore 17
    //   25: aload 17
    //   27: ldc_w 491
    //   30: invokevirtual 437	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   33: ifeq +31 -> 64
    //   36: aload 17
    //   38: ldc_w 491
    //   41: invokevirtual 441	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   44: invokestatic 496	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   47: invokevirtual 499	java/lang/Integer:intValue	()I
    //   50: istore 8
    //   52: iload 8
    //   54: iconst_1
    //   55: if_icmpne +9 -> 64
    //   58: iconst_1
    //   59: istore 10
    //   61: goto +6 -> 67
    //   64: iconst_0
    //   65: istore 10
    //   67: aload 17
    //   69: ldc_w 501
    //   72: invokevirtual 437	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   75: ifeq +21 -> 96
    //   78: aload 17
    //   80: ldc_w 501
    //   83: invokevirtual 441	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   86: invokestatic 506	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   89: invokevirtual 510	java/lang/Float:floatValue	()F
    //   92: fstore_3
    //   93: goto +5 -> 98
    //   96: fconst_0
    //   97: fstore_3
    //   98: aload 17
    //   100: ldc_w 512
    //   103: invokevirtual 437	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   106: ifeq +31 -> 137
    //   109: aload 17
    //   111: ldc_w 512
    //   114: invokevirtual 441	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   117: invokestatic 496	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   120: invokevirtual 499	java/lang/Integer:intValue	()I
    //   123: istore 8
    //   125: iload 8
    //   127: iconst_1
    //   128: if_icmpne +9 -> 137
    //   131: iconst_1
    //   132: istore 9
    //   134: goto +6 -> 140
    //   137: iconst_0
    //   138: istore 9
    //   140: fload 6
    //   142: fstore 5
    //   144: aload 17
    //   146: ldc_w 514
    //   149: invokevirtual 437	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   152: ifeq +23 -> 175
    //   155: fload 6
    //   157: fstore 5
    //   159: aload 17
    //   161: ldc_w 514
    //   164: invokevirtual 441	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   167: invokestatic 506	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   170: invokevirtual 510	java/lang/Float:floatValue	()F
    //   173: fstore 4
    //   175: fload 4
    //   177: fstore 5
    //   179: iload 9
    //   181: istore 14
    //   183: fload_3
    //   184: fstore 7
    //   186: iload 10
    //   188: istore 11
    //   190: fload 4
    //   192: fstore 6
    //   194: iload 15
    //   196: istore 12
    //   198: iload 16
    //   200: istore 13
    //   202: aload 17
    //   204: ldc_w 516
    //   207: invokevirtual 437	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   210: ifeq +146 -> 356
    //   213: fload 4
    //   215: fstore 5
    //   217: aload 17
    //   219: ldc_w 516
    //   222: invokevirtual 441	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   225: invokestatic 496	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   228: invokevirtual 499	java/lang/Integer:intValue	()I
    //   231: istore 8
    //   233: iload 9
    //   235: istore 14
    //   237: fload_3
    //   238: fstore 7
    //   240: iload 10
    //   242: istore 11
    //   244: fload 4
    //   246: fstore 6
    //   248: iload 15
    //   250: istore 12
    //   252: iload 16
    //   254: istore 13
    //   256: iload 8
    //   258: iconst_1
    //   259: if_icmpne +97 -> 356
    //   262: iconst_1
    //   263: istore 12
    //   265: iload 9
    //   267: istore 14
    //   269: fload_3
    //   270: fstore 7
    //   272: iload 10
    //   274: istore 11
    //   276: fload 4
    //   278: fstore 6
    //   280: iload 16
    //   282: istore 13
    //   284: goto +72 -> 356
    //   287: astore 17
    //   289: goto +31 -> 320
    //   292: astore 17
    //   294: iconst_0
    //   295: istore 9
    //   297: goto +23 -> 320
    //   300: astore 17
    //   302: iconst_0
    //   303: istore 9
    //   305: fconst_0
    //   306: fstore_3
    //   307: goto +13 -> 320
    //   310: astore 17
    //   312: iconst_0
    //   313: istore 9
    //   315: fconst_0
    //   316: fstore_3
    //   317: iconst_0
    //   318: istore 10
    //   320: aload 17
    //   322: invokevirtual 177	org/json/JSONException:printStackTrace	()V
    //   325: ldc 184
    //   327: iconst_2
    //   328: ldc_w 518
    //   331: invokestatic 187	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   334: iconst_0
    //   335: istore 13
    //   337: iload 15
    //   339: istore 12
    //   341: fload 5
    //   343: fstore 6
    //   345: iload 10
    //   347: istore 11
    //   349: fload_3
    //   350: fstore 7
    //   352: iload 9
    //   354: istore 14
    //   356: aload_1
    //   357: iload 11
    //   359: aload_2
    //   360: invokestatic 521	com/tencent/mobileqq/utils/SharedPreUtils:b	(Landroid/content/Context;ZLjava/lang/String;)V
    //   363: iload 14
    //   365: ifeq +95 -> 460
    //   368: aload_1
    //   369: aload_2
    //   370: invokestatic 525	com/tencent/mobileqq/utils/SharedPreUtils:bb	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Float;
    //   373: invokevirtual 510	java/lang/Float:floatValue	()F
    //   376: fstore_3
    //   377: fload 7
    //   379: fload_3
    //   380: fcmpl
    //   381: ifle +126 -> 507
    //   384: aload_1
    //   385: iload 14
    //   387: invokestatic 530	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   390: aload_2
    //   391: invokestatic 533	com/tencent/mobileqq/utils/SharedPreUtils:a	(Landroid/content/Context;Ljava/lang/Boolean;Ljava/lang/String;)V
    //   394: aload_1
    //   395: fload 7
    //   397: invokestatic 536	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   400: aload_2
    //   401: invokestatic 539	com/tencent/mobileqq/utils/SharedPreUtils:a	(Landroid/content/Context;Ljava/lang/Float;Ljava/lang/String;)V
    //   404: new 112	java/lang/StringBuilder
    //   407: dup
    //   408: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   411: astore 17
    //   413: aload 17
    //   415: ldc_w 541
    //   418: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: pop
    //   422: aload 17
    //   424: fload_3
    //   425: invokevirtual 544	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   428: pop
    //   429: aload 17
    //   431: ldc_w 546
    //   434: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: pop
    //   438: aload 17
    //   440: fload 7
    //   442: invokevirtual 544	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   445: pop
    //   446: ldc 184
    //   448: iconst_2
    //   449: aload 17
    //   451: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   454: invokestatic 279	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   457: goto +50 -> 507
    //   460: new 112	java/lang/StringBuilder
    //   463: dup
    //   464: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   467: astore 17
    //   469: aload 17
    //   471: ldc_w 548
    //   474: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: pop
    //   478: aload 17
    //   480: iload 14
    //   482: invokevirtual 412	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   485: pop
    //   486: ldc 184
    //   488: iconst_2
    //   489: aload 17
    //   491: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   494: invokestatic 279	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   497: aload_1
    //   498: iload 14
    //   500: invokestatic 530	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   503: aload_2
    //   504: invokestatic 533	com/tencent/mobileqq/utils/SharedPreUtils:a	(Landroid/content/Context;Ljava/lang/Boolean;Ljava/lang/String;)V
    //   507: iload 12
    //   509: ifeq +86 -> 595
    //   512: aload_1
    //   513: aload_2
    //   514: invokestatic 551	com/tencent/mobileqq/utils/SharedPreUtils:bd	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Float;
    //   517: invokevirtual 510	java/lang/Float:floatValue	()F
    //   520: fstore_3
    //   521: fload 6
    //   523: fload_3
    //   524: fcmpl
    //   525: ifle +114 -> 639
    //   528: aload_1
    //   529: fload 6
    //   531: invokestatic 536	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   534: aload_2
    //   535: invokestatic 553	com/tencent/mobileqq/utils/SharedPreUtils:b	(Landroid/content/Context;Ljava/lang/Float;Ljava/lang/String;)V
    //   538: aload_1
    //   539: iload 12
    //   541: aload_2
    //   542: invokestatic 555	com/tencent/mobileqq/utils/SharedPreUtils:c	(Landroid/content/Context;ZLjava/lang/String;)V
    //   545: new 112	java/lang/StringBuilder
    //   548: dup
    //   549: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   552: astore_1
    //   553: aload_1
    //   554: ldc_w 557
    //   557: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: pop
    //   561: aload_1
    //   562: fload_3
    //   563: invokevirtual 544	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   566: pop
    //   567: aload_1
    //   568: ldc_w 559
    //   571: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: pop
    //   575: aload_1
    //   576: fload 6
    //   578: invokevirtual 544	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   581: pop
    //   582: ldc 184
    //   584: iconst_2
    //   585: aload_1
    //   586: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   589: invokestatic 279	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   592: goto +47 -> 639
    //   595: new 112	java/lang/StringBuilder
    //   598: dup
    //   599: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   602: astore 17
    //   604: aload 17
    //   606: ldc_w 561
    //   609: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: pop
    //   613: aload 17
    //   615: iload 12
    //   617: invokevirtual 412	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   620: pop
    //   621: ldc 184
    //   623: iconst_2
    //   624: aload 17
    //   626: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   629: invokestatic 279	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   632: aload_1
    //   633: iload 12
    //   635: aload_2
    //   636: invokestatic 555	com/tencent/mobileqq/utils/SharedPreUtils:c	(Landroid/content/Context;ZLjava/lang/String;)V
    //   639: invokestatic 319	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   642: ifeq +50 -> 692
    //   645: new 112	java/lang/StringBuilder
    //   648: dup
    //   649: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   652: astore_1
    //   653: aload_1
    //   654: ldc_w 563
    //   657: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: pop
    //   661: aload_1
    //   662: iload 11
    //   664: invokevirtual 412	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   667: pop
    //   668: aload_1
    //   669: ldc_w 565
    //   672: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   675: pop
    //   676: aload_1
    //   677: aload_0
    //   678: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: pop
    //   682: ldc 184
    //   684: iconst_2
    //   685: aload_1
    //   686: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   689: invokestatic 279	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   692: iload 13
    //   694: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	695	0	paramString1	String
    //   0	695	1	paramContext	Context
    //   0	695	2	paramString2	String
    //   92	471	3	f1	float
    //   7	270	4	f2	float
    //   4	338	5	f3	float
    //   1	576	6	f4	float
    //   184	257	7	f5	float
    //   50	210	8	i1	int
    //   132	221	9	bool1	boolean
    //   59	287	10	bool2	boolean
    //   188	475	11	bool3	boolean
    //   196	438	12	bool4	boolean
    //   200	493	13	bool5	boolean
    //   181	318	14	bool6	boolean
    //   10	328	15	bool7	boolean
    //   13	268	16	bool8	boolean
    //   23	195	17	localJSONObject	JSONObject
    //   287	1	17	localJSONException1	JSONException
    //   292	1	17	localJSONException2	JSONException
    //   300	1	17	localJSONException3	JSONException
    //   310	11	17	localJSONException4	JSONException
    //   411	214	17	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   144	155	287	org/json/JSONException
    //   159	175	287	org/json/JSONException
    //   202	213	287	org/json/JSONException
    //   217	233	287	org/json/JSONException
    //   98	125	292	org/json/JSONException
    //   67	93	300	org/json/JSONException
    //   15	52	310	org/json/JSONException
  }
  
  public static String b(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(b);
      localStringBuilder.append("line_orig_");
      localStringBuilder.append(String.valueOf(paramInt2));
      localStringBuilder.append(".png");
      return localStringBuilder.toString();
    }
    if (paramInt1 == 2) {
      return e(paramInt2);
    }
    return null;
  }
  
  private void b(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Message localMessage = new Message();
    int i1;
    if (paramBoolean) {
      i1 = 1001;
    } else {
      i1 = 1002;
    }
    localMessage.what = i1;
    localMessage.arg1 = paramInt1;
    localMessage.arg2 = paramInt2;
    this.k.sendMessageDelayed(localMessage, 0L);
  }
  
  public static void b(Context paramContext, String paramString)
  {
    QLog.d("ScribbleResMgr", 2, "setScribbleRedShowed false");
    SharedPreUtils.a(paramContext, Boolean.valueOf(false), paramString);
  }
  
  private void b(ArrayList<ResInfo> paramArrayList)
  {
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      this.w.lock();
      try
      {
        this.m.clear();
        this.m.addAll(paramArrayList);
        a(this.m);
        return;
      }
      finally
      {
        this.w.unlock();
      }
    }
  }
  
  private boolean b(QQAppInterface paramQQAppInterface, String paramString)
  {
    String str = SharedPreUtils.Q(paramQQAppInterface.getApp().getBaseContext());
    StringBuilder localStringBuilder = null;
    JSONArray localJSONArray = null;
    Object localObject1;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      if (localJSONObject.has("version")) {
        localObject1 = localJSONObject.getString("version");
      } else {
        localObject1 = null;
      }
      try
      {
        if (localJSONObject.has("iconUrl")) {
          this.s = localJSONObject.getString("iconUrl");
        }
        if (localJSONObject.has("iconMd5")) {
          this.t = localJSONObject.getString("iconMd5");
        }
        if (localJSONObject.has("content")) {
          localJSONArray = localJSONObject.getJSONArray("content");
        }
        bool = true;
      }
      catch (JSONException localJSONException1) {}
      localJSONException2.printStackTrace();
    }
    catch (JSONException localJSONException2)
    {
      localObject1 = null;
    }
    QLog.e("ScribbleResMgr", 2, "RESOURCE_CONFIG_TASK_ID_Gif JSON EXCEPT");
    boolean bool = false;
    Object localObject2 = localStringBuilder;
    localObject2 = a((JSONArray)localObject2, 2);
    b((ArrayList)localObject2);
    if (((str == null) || (!str.equalsIgnoreCase((String)localObject1))) && (bool))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("RESOURCE_CONFIG_TASK_ID_GIF newVersion = ");
      localStringBuilder.append((String)localObject1);
      QLog.i("ScribbleResMgr", 2, localStringBuilder.toString());
      SharedPreUtils.aU(paramQQAppInterface.getApp().getBaseContext(), (String)localObject1);
      SharedPreUtils.aW(paramQQAppInterface.getApp().getBaseContext(), paramString);
      a(paramQQAppInterface, 4, f.longValue());
      if ((localObject2 != null) && (!((ArrayList)localObject2).isEmpty())) {
        paramString = ((ArrayList)localObject2).iterator();
      }
    }
    else
    {
      while ((paramString != null) && (paramString.hasNext()))
      {
        localObject1 = (ResInfo)paramString.next();
        if (!((ResInfo)localObject1).g)
        {
          if ((((ResInfo)localObject1).f == 1) || (this.u)) {
            a(paramQQAppInterface, (ResInfo)localObject1, f.longValue(), true);
          }
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("mArrGifInfo index :");
          ((StringBuilder)localObject2).append(((ResInfo)localObject1).b);
          ((StringBuilder)localObject2).append(" is downloading ");
          QLog.e("ScribbleResMgr", 2, ((StringBuilder)localObject2).toString());
          continue;
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("RESOURCE_CONFIG_TASK_ID_GIF newVersion = ");
          paramQQAppInterface.append((String)localObject1);
          paramQQAppInterface.append(" oldVersion=  ");
          paramQQAppInterface.append(str);
          QLog.i("ScribbleResMgr", 2, paramQQAppInterface.toString());
        }
      }
    }
    return bool;
  }
  
  private boolean b(String paramString)
  {
    Object localObject = null;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      if (localJSONObject.has("iconUrl")) {
        this.s = localJSONObject.getString("iconUrl");
      }
      if (localJSONObject.has("iconMd5")) {
        this.t = localJSONObject.getString("iconMd5");
      }
      paramString = localObject;
      if (localJSONObject.has("content")) {
        paramString = localJSONObject.getJSONArray("content");
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      QLog.e("ScribbleResMgr", 2, "RESOURCE_CONFIG_TASK_ID_Gif JSON EXCEPT");
      paramString = localObject;
    }
    b(a(paramString, 2));
    return true;
  }
  
  private static String c(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c);
    localStringBuilder.append("gif_zip_tmp");
    localStringBuilder.append(String.valueOf(paramInt));
    localStringBuilder.append("/");
    return localStringBuilder.toString();
  }
  
  private void c(QQAppInterface paramQQAppInterface)
  {
    if (!this.g)
    {
      long l1 = System.currentTimeMillis();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("init=======================timenow:");
      ((StringBuilder)localObject).append(l1);
      QLog.i("ScribbleResMgr", 2, ((StringBuilder)localObject).toString());
      localObject = SharedPreUtils.T(paramQQAppInterface.getApp().getApplicationContext());
      paramQQAppInterface = SharedPreUtils.S(paramQQAppInterface.getApp().getApplicationContext());
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        a((String)localObject);
      }
      if (!TextUtils.isEmpty(paramQQAppInterface)) {
        b(paramQQAppInterface);
      }
      this.g = true;
      long l2 = System.currentTimeMillis();
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("init=======================timenow:");
      paramQQAppInterface.append(l2);
      QLog.i("ScribbleResMgr", 2, paramQQAppInterface.toString());
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("init==========================timedec:");
      paramQQAppInterface.append(l2 - l1);
      QLog.i("ScribbleResMgr", 2, paramQQAppInterface.toString());
    }
  }
  
  private void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      paramString = paramString.substring(0, paramString.lastIndexOf(File.separator));
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      paramString = new File(paramString);
      if (!paramString.exists())
      {
        paramString.mkdirs();
        return;
      }
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("makedir execption: ");
      localStringBuilder.append(paramString);
      QLog.d("ScribbleResMgrdownloading", 2, localStringBuilder.toString());
    }
  }
  
  private void c(ArrayList<ResInfo> paramArrayList)
  {
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      this.w.lock();
      try
      {
        this.n.clear();
        this.n.addAll(paramArrayList);
        a(this.n);
        return;
      }
      finally
      {
        this.w.unlock();
      }
    }
  }
  
  public static boolean c(Context paramContext, String paramString)
  {
    boolean bool1 = e(paramContext, paramString);
    boolean bool2 = SharedPreUtils.bc(paramContext, paramString);
    paramContext = new StringBuilder();
    paramContext.append("getNeedScribblePlusRedShow");
    paramContext.append(bool2);
    QLog.d("ScribbleResMgr", 2, paramContext.toString());
    return (bool2) && (bool1);
  }
  
  private static String d(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c(paramInt));
    localStringBuilder.append("gif_zip_tmp");
    localStringBuilder.append(String.valueOf(paramInt));
    return localStringBuilder.toString();
  }
  
  private ArrayList<ResInfo> d()
  {
    ArrayList localArrayList = new ArrayList();
    this.w.lock();
    try
    {
      if ((this.n != null) && (this.n.size() > 0))
      {
        Iterator localIterator = this.n.iterator();
        while (localIterator.hasNext())
        {
          ResInfo localResInfo = (ResInfo)localIterator.next();
          if (localResInfo != null) {
            localArrayList.add(localResInfo.a(localResInfo));
          }
        }
      }
      this.w.unlock();
      return localArrayList;
    }
    finally
    {
      this.w.unlock();
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public static void d(Context paramContext, String paramString)
  {
    SharedPreUtils.c(paramContext, false, paramString);
    QLog.d("ScribbleResMgr", 2, "setScribblePlusRedShowed false");
  }
  
  private static String e(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c(paramInt));
    localStringBuilder.append("gif_orig_");
    localStringBuilder.append(String.valueOf(paramInt));
    localStringBuilder.append(".gif");
    return localStringBuilder.toString();
  }
  
  private ArrayList<ResInfo> e()
  {
    ArrayList localArrayList = new ArrayList();
    this.w.lock();
    try
    {
      if ((this.m != null) && (this.m.size() > 0))
      {
        Iterator localIterator = this.m.iterator();
        while (localIterator.hasNext())
        {
          ResInfo localResInfo = (ResInfo)localIterator.next();
          if (localResInfo != null) {
            localArrayList.add(localResInfo.a(localResInfo));
          }
        }
      }
      this.w.unlock();
      return localArrayList;
    }
    finally
    {
      this.w.unlock();
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public static boolean e(Context paramContext, String paramString)
  {
    boolean bool = SharedPreUtils.aZ(paramContext, paramString);
    paramContext = new StringBuilder();
    paramContext.append("canShowEnter");
    paramContext.append(bool);
    QLog.d("ScribbleResMgr", 2, paramContext.toString());
    return bool;
  }
  
  private String f()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SCRIBBLE_FILE_DIR);
    localStringBuilder.append("paint_icon");
    return localStringBuilder.toString();
  }
  
  private String g()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SCRIBBLE_FILE_DIR);
    localStringBuilder.append("gif_icon");
    return localStringBuilder.toString();
  }
  
  private void h()
  {
    Message localMessage = new Message();
    localMessage.what = 3;
    localMessage.obj = null;
    localMessage.arg1 = 0;
    this.k.sendMessageDelayed(localMessage, 0L);
  }
  
  public ArrayList<Integer> a(QQAppInterface paramQQAppInterface)
  {
    c(paramQQAppInterface);
    paramQQAppInterface = new ArrayList();
    this.w.lock();
    try
    {
      if ((this.n != null) && (this.n.size() > 0))
      {
        Iterator localIterator = this.n.iterator();
        while (localIterator.hasNext())
        {
          ResInfo localResInfo = (ResInfo)localIterator.next();
          if ((localResInfo.a == 1) && (localResInfo.h == 1) && ((localResInfo.i & 0x2) > 0)) {
            paramQQAppInterface.add(Integer.valueOf(localResInfo.b));
          }
        }
      }
      this.w.unlock();
      return paramQQAppInterface;
    }
    finally
    {
      this.w.unlock();
    }
    for (;;)
    {
      throw paramQQAppInterface;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, View paramView, ResCallback paramResCallback)
  {
    a(paramInt1, paramInt2, paramView, paramResCallback);
    paramQQAppInterface = new ScribbleResMgr.2(this, paramQQAppInterface, paramInt1, paramInt2);
    this.h.post(paramQQAppInterface);
  }
  
  public boolean a(String paramString, QQAppInterface paramQQAppInterface, int paramInt)
  {
    boolean bool;
    if (paramInt == 2598) {
      bool = a(paramQQAppInterface, paramString);
    } else {
      bool = true;
    }
    if (paramInt == 2599) {
      bool = b(paramQQAppInterface, paramString);
    }
    if (!bool) {
      h();
    }
    return bool;
  }
  
  public ArrayList<Integer> b(QQAppInterface paramQQAppInterface)
  {
    c(paramQQAppInterface);
    paramQQAppInterface = new ArrayList();
    this.w.lock();
    try
    {
      if ((this.m != null) && (this.m.size() > 0))
      {
        Iterator localIterator = this.m.iterator();
        while (localIterator.hasNext())
        {
          ResInfo localResInfo = (ResInfo)localIterator.next();
          if ((localResInfo.a == 2) && (localResInfo.h == 1) && ((localResInfo.i & 0x2) > 0)) {
            paramQQAppInterface.add(Integer.valueOf(localResInfo.b));
          }
        }
      }
      this.w.unlock();
      return paramQQAppInterface;
    }
    finally
    {
      this.w.unlock();
    }
    for (;;)
    {
      throw paramQQAppInterface;
    }
  }
  
  public void b()
  {
    this.u = false;
    QLog.d("ScribbleResMgr", 2, "setGetConfigFinished");
  }
  
  public void c()
  {
    h();
    b();
    QLog.e("ScribbleResMgr", 2, "onGetConfigFailed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.scribble.ScribbleResMgr
 * JD-Core Version:    0.7.0.1
 */