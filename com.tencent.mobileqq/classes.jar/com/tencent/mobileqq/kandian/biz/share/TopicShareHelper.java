package com.tencent.mobileqq.kandian.biz.share;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser.ActionSheetItem;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoShareUtils;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelInfo;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qqfav.QfavBuilder;
import cooperation.qzone.QZoneShareManager;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class TopicShareHelper
  implements AdapterView.OnItemClickListener
{
  public static String a = "https://kandian.qq.com/mqq/html/topicvideo.html?_wv=3&_bid=2378&videotopicid=";
  private Activity b;
  private QQAppInterface c;
  private Context d;
  private Bitmap e = null;
  private URLDrawable f = null;
  private ChannelInfo g;
  private ActionSheet h;
  private QQProgressDialog i;
  private Intent j;
  private VideoShareListener k;
  private boolean l = true;
  private boolean m = false;
  
  public TopicShareHelper(Activity paramActivity)
  {
    this.b = paramActivity;
    this.d = paramActivity;
    paramActivity = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramActivity instanceof QQAppInterface))
    {
      this.c = ((QQAppInterface)paramActivity);
      paramActivity = RIJSPUtils.a(this.c, true, true).getString("readinjoy_social_weburl_topicvideo", "");
      if (!TextUtils.isEmpty(paramActivity))
      {
        a = paramActivity;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("update SHARE_URL_PREF from config, config=");
          localStringBuilder.append(paramActivity);
          QLog.d("Q.readinjoy.video.TopicShareHelper", 2, localStringBuilder.toString());
        }
      }
    }
  }
  
  public static String a(ChannelInfo paramChannelInfo, int paramInt)
  {
    int n = 5;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt != 5) {
                n = 6;
              }
            }
            else {
              n = 4;
            }
          }
          else {
            n = 3;
          }
        }
        else {
          n = 2;
        }
      }
      else {
        n = 1;
      }
    }
    else {
      n = 0;
    }
    String str2;
    try
    {
      String str1 = URLEncoder.encode(paramChannelInfo.mChannelName, "UTF-8");
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
      str2 = "";
    }
    StringBuilder localStringBuilder = new StringBuilder(a);
    localStringBuilder.append(paramChannelInfo.mChannelID);
    localStringBuilder.append("&topicname=");
    localStringBuilder.append(str2);
    localStringBuilder.append("&sourcefrom=");
    localStringBuilder.append(n);
    return localStringBuilder.toString();
  }
  
  /* Error */
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 106
    //   8: iconst_2
    //   9: ldc 154
    //   11: invokestatic 113	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: aload_0
    //   15: getfield 50	com/tencent/mobileqq/kandian/biz/share/TopicShareHelper:b	Landroid/app/Activity;
    //   18: astore_2
    //   19: aload_0
    //   20: getfield 156	com/tencent/mobileqq/kandian/biz/share/TopicShareHelper:i	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   23: ifnonnull +24 -> 47
    //   26: aload_0
    //   27: new 158	com/tencent/mobileqq/widget/QQProgressDialog
    //   30: dup
    //   31: aload_2
    //   32: aload_2
    //   33: invokevirtual 164	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   36: ldc 165
    //   38: invokevirtual 171	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   41: invokespecial 174	com/tencent/mobileqq/widget/QQProgressDialog:<init>	(Landroid/content/Context;I)V
    //   44: putfield 156	com/tencent/mobileqq/kandian/biz/share/TopicShareHelper:i	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   47: aload_1
    //   48: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   51: ifne +426 -> 477
    //   54: aload_3
    //   55: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   58: ifeq +6 -> 64
    //   61: goto +416 -> 477
    //   64: aload_0
    //   65: getfield 156	com/tencent/mobileqq/kandian/biz/share/TopicShareHelper:i	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   68: invokevirtual 177	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   71: ifne +19 -> 90
    //   74: aload_0
    //   75: getfield 156	com/tencent/mobileqq/kandian/biz/share/TopicShareHelper:i	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   78: ldc 178
    //   80: invokevirtual 181	com/tencent/mobileqq/widget/QQProgressDialog:c	(I)V
    //   83: aload_0
    //   84: getfield 156	com/tencent/mobileqq/kandian/biz/share/TopicShareHelper:i	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   87: invokevirtual 184	com/tencent/mobileqq/widget/QQProgressDialog:show	()V
    //   90: aload_0
    //   91: getfield 52	com/tencent/mobileqq/kandian/biz/share/TopicShareHelper:d	Landroid/content/Context;
    //   94: invokevirtual 190	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   97: astore 5
    //   99: aload 5
    //   101: ldc 192
    //   103: sipush 8192
    //   106: invokevirtual 198	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   109: astore 5
    //   111: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   114: ifeq +11 -> 125
    //   117: ldc 106
    //   119: iconst_2
    //   120: ldc 200
    //   122: invokestatic 113	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   125: new 202	com/tencent/mobileqq/kandian/biz/share/TopicShareHelper$6
    //   128: dup
    //   129: aload_0
    //   130: aload 4
    //   132: aload_1
    //   133: aload_3
    //   134: aload 5
    //   136: aload_2
    //   137: invokespecial 205	com/tencent/mobileqq/kandian/biz/share/TopicShareHelper$6:<init>	(Lcom/tencent/mobileqq/kandian/biz/share/TopicShareHelper;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/pm/ApplicationInfo;Landroid/app/Activity;)V
    //   140: invokestatic 211	com/tencent/mobileqq/app/ThreadManager:executeOnSubThread	(Ljava/lang/Runnable;)V
    //   143: goto +293 -> 436
    //   146: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   149: ifeq +11 -> 160
    //   152: ldc 106
    //   154: iconst_2
    //   155: ldc 213
    //   157: invokestatic 113	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   160: aload_1
    //   161: ldc 125
    //   163: invokestatic 130	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   166: astore_1
    //   167: new 97	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   174: astore 5
    //   176: aload 5
    //   178: ldc 215
    //   180: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload 5
    //   186: ldc 217
    //   188: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload 5
    //   194: aload_1
    //   195: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: aload 5
    //   201: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: astore_1
    //   205: aload_3
    //   206: ldc 125
    //   208: invokestatic 130	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   211: astore_3
    //   212: new 97	java/lang/StringBuilder
    //   215: dup
    //   216: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   219: astore 5
    //   221: aload 5
    //   223: aload_1
    //   224: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: aload 5
    //   230: ldc 219
    //   232: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: aload 5
    //   238: aload_3
    //   239: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: pop
    //   243: aload 5
    //   245: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: astore_1
    //   249: aload 4
    //   251: ldc 125
    //   253: invokestatic 130	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   256: astore_3
    //   257: new 97	java/lang/StringBuilder
    //   260: dup
    //   261: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   264: astore 4
    //   266: aload 4
    //   268: aload_1
    //   269: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: aload 4
    //   275: ldc 221
    //   277: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload 4
    //   283: aload_3
    //   284: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: aload 4
    //   290: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: astore_1
    //   294: new 97	java/lang/StringBuilder
    //   297: dup
    //   298: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   301: astore_3
    //   302: aload_3
    //   303: aload_1
    //   304: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: aload_3
    //   309: ldc 223
    //   311: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: aload_3
    //   316: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   319: astore_1
    //   320: new 225	android/content/Intent
    //   323: dup
    //   324: aload_2
    //   325: ldc 227
    //   327: invokespecial 230	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   330: astore_3
    //   331: aload_3
    //   332: ldc 232
    //   334: aload_1
    //   335: invokevirtual 236	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   338: pop
    //   339: aload_2
    //   340: aload_3
    //   341: invokevirtual 240	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   344: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   347: ifeq +11 -> 358
    //   350: ldc 106
    //   352: iconst_2
    //   353: ldc 242
    //   355: invokestatic 113	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   358: aload_0
    //   359: getfield 156	com/tencent/mobileqq/kandian/biz/share/TopicShareHelper:i	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   362: astore_1
    //   363: aload_1
    //   364: ifnull +72 -> 436
    //   367: aload_1
    //   368: invokevirtual 177	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   371: ifeq +65 -> 436
    //   374: goto +55 -> 429
    //   377: astore_1
    //   378: goto +74 -> 452
    //   381: astore_1
    //   382: aload_0
    //   383: getfield 52	com/tencent/mobileqq/kandian/biz/share/TopicShareHelper:d	Landroid/content/Context;
    //   386: iconst_0
    //   387: ldc 243
    //   389: iconst_0
    //   390: invokestatic 249	com/tencent/mobileqq/widget/QQToast:makeText	(Landroid/content/Context;III)Lcom/tencent/mobileqq/widget/QQToast;
    //   393: aload_0
    //   394: getfield 52	com/tencent/mobileqq/kandian/biz/share/TopicShareHelper:d	Landroid/content/Context;
    //   397: invokevirtual 250	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   400: ldc 165
    //   402: invokevirtual 171	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   405: invokevirtual 253	com/tencent/mobileqq/widget/QQToast:show	(I)Landroid/widget/Toast;
    //   408: pop
    //   409: aload_1
    //   410: invokevirtual 254	java/lang/Exception:printStackTrace	()V
    //   413: aload_0
    //   414: getfield 156	com/tencent/mobileqq/kandian/biz/share/TopicShareHelper:i	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   417: astore_1
    //   418: aload_1
    //   419: ifnull +17 -> 436
    //   422: aload_1
    //   423: invokevirtual 177	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   426: ifeq +10 -> 436
    //   429: aload_0
    //   430: getfield 156	com/tencent/mobileqq/kandian/biz/share/TopicShareHelper:i	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   433: invokevirtual 257	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   436: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   439: ifeq +12 -> 451
    //   442: ldc 106
    //   444: iconst_2
    //   445: ldc_w 259
    //   448: invokestatic 113	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   451: return
    //   452: aload_0
    //   453: getfield 156	com/tencent/mobileqq/kandian/biz/share/TopicShareHelper:i	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   456: astore_2
    //   457: aload_2
    //   458: ifnull +17 -> 475
    //   461: aload_2
    //   462: invokevirtual 177	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   465: ifeq +10 -> 475
    //   468: aload_0
    //   469: getfield 156	com/tencent/mobileqq/kandian/biz/share/TopicShareHelper:i	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   472: invokevirtual 257	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   475: aload_1
    //   476: athrow
    //   477: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   480: ifeq +12 -> 492
    //   483: ldc 106
    //   485: iconst_2
    //   486: ldc_w 261
    //   489: invokestatic 113	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   492: aload_0
    //   493: getfield 156	com/tencent/mobileqq/kandian/biz/share/TopicShareHelper:i	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   496: astore_1
    //   497: aload_1
    //   498: ifnull +17 -> 515
    //   501: aload_1
    //   502: invokevirtual 177	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   505: ifeq +10 -> 515
    //   508: aload_0
    //   509: getfield 156	com/tencent/mobileqq/kandian/biz/share/TopicShareHelper:i	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   512: invokevirtual 257	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   515: aload_0
    //   516: getfield 52	com/tencent/mobileqq/kandian/biz/share/TopicShareHelper:d	Landroid/content/Context;
    //   519: iconst_0
    //   520: ldc 243
    //   522: iconst_0
    //   523: invokestatic 249	com/tencent/mobileqq/widget/QQToast:makeText	(Landroid/content/Context;III)Lcom/tencent/mobileqq/widget/QQToast;
    //   526: aload_0
    //   527: getfield 52	com/tencent/mobileqq/kandian/biz/share/TopicShareHelper:d	Landroid/content/Context;
    //   530: invokevirtual 250	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   533: ldc 165
    //   535: invokevirtual 171	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   538: invokevirtual 253	com/tencent/mobileqq/widget/QQToast:show	(I)Landroid/widget/Toast;
    //   541: pop
    //   542: return
    //   543: astore 5
    //   545: goto -399 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	548	0	this	TopicShareHelper
    //   0	548	1	paramString1	String
    //   0	548	2	paramString2	String
    //   0	548	3	paramString3	String
    //   0	548	4	paramString4	String
    //   97	147	5	localObject	Object
    //   543	1	5	localNameNotFoundException	android.content.pm.PackageManager.NameNotFoundException
    // Exception table:
    //   from	to	target	type
    //   160	358	377	finally
    //   382	413	377	finally
    //   160	358	381	java/lang/Exception
    //   99	125	543	android/content/pm/PackageManager$NameNotFoundException
    //   125	143	543	android/content/pm/PackageManager$NameNotFoundException
  }
  
  private void b()
  {
    this.e = null;
    this.f = null;
    try
    {
      this.f = URLDrawable.getDrawable(this.g.mHeaderPicUrl, null, null);
      URLDrawable localURLDrawable = this.f;
      if ((localURLDrawable != null) && (localURLDrawable.getStatus() == 1) && ((this.f.getCurrDrawable() instanceof RegionDrawable)))
      {
        this.e = ((RegionDrawable)this.f.getCurrDrawable()).getBitmap();
        return;
      }
      localURLDrawable = this.f;
      if (localURLDrawable != null)
      {
        localURLDrawable.setURLDrawableListener(new TopicShareHelper.1(this));
        this.f.startDownload();
      }
      return;
    }
    catch (Exception localException)
    {
      label103:
      break label103;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.readinjoy.video.TopicShareHelper", 2, "initTopicThumbBitmap() URLDrawable.getDrawable ERROR, RETURN");
    }
  }
  
  private View c()
  {
    View localView = LayoutInflater.from(this.b).inflate(2131624763, null);
    float f1 = this.b.getResources().getDisplayMetrics().density;
    ElasticHorScrView localElasticHorScrView1 = (ElasticHorScrView)localView.findViewById(2131445372);
    ElasticHorScrView localElasticHorScrView2 = (ElasticHorScrView)localView.findViewById(2131445373);
    GridView localGridView2 = (GridView)localView.findViewById(2131434386);
    GridView localGridView1 = (GridView)localView.findViewById(2131434387);
    Object localObject1 = (TextView)localView.findViewById(2131427564);
    Object localObject2 = (LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
    ((LinearLayout.LayoutParams)localObject2).topMargin = ((int)(13.0F * f1));
    ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((TextView)localObject1).setText(2131887648);
    ((TextView)localObject1).setOnClickListener(new TopicShareHelper.2(this));
    this.h.setOnDismissListener(new TopicShareHelper.3(this));
    if (Build.VERSION.SDK_INT >= 9)
    {
      localElasticHorScrView1.setOverScrollMode(2);
      localElasticHorScrView2.setOverScrollMode(2);
    }
    localGridView1.setSmoothScrollbarEnabled(false);
    localObject2 = d();
    if (localObject2.length > 0) {
      localObject1 = localObject2[0];
    } else {
      localObject1 = new ArrayList(0);
    }
    if (localObject2.length > 1) {
      localObject2 = localObject2[1];
    } else {
      localObject2 = new ArrayList(0);
    }
    int n = ((List)localObject1).size();
    localGridView2.setNumColumns(n);
    ViewGroup.LayoutParams localLayoutParams = localGridView2.getLayoutParams();
    localLayoutParams.width = ((int)((n * 75 + (n - 1) * 10 + 3) * f1));
    localGridView2.setLayoutParams(localLayoutParams);
    localGridView2.setAdapter(new TopicShareHelper.ActionSheetItemAdapter(this.b, 0, (List)localObject1));
    localGridView2.setSelector(new ColorDrawable(0));
    localGridView2.setOnItemClickListener(this);
    n = localLayoutParams.width;
    int i1 = ((List)localObject2).size();
    localObject1 = localGridView1.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject1).width = ((int)((i1 * 75 + (i1 - 1) * 10 + 3) * f1));
    localGridView1.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localGridView1.setNumColumns(i1);
    localGridView1.setAdapter(new TopicShareHelper.ActionSheetItemAdapter(this.b, 0, (List)localObject2));
    localGridView1.setSelector(new ColorDrawable(0));
    localGridView1.setOnItemClickListener(this);
    localView.post(new TopicShareHelper.4(this, localElasticHorScrView1, n, localElasticHorScrView2, ((ViewGroup.LayoutParams)localObject1).width));
    return localView;
  }
  
  private List<IPublicAccountBrowser.ActionSheetItem>[] d()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new IPublicAccountBrowser.ActionSheetItem();
    ((IPublicAccountBrowser.ActionSheetItem)localObject).c = this.b.getResources().getString(2131894171);
    ((IPublicAccountBrowser.ActionSheetItem)localObject).a = 2130839221;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).b = true;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).d = 2;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).e = "";
    localArrayList.add(localObject);
    localObject = new IPublicAccountBrowser.ActionSheetItem();
    ((IPublicAccountBrowser.ActionSheetItem)localObject).c = this.b.getResources().getString(2131894185);
    ((IPublicAccountBrowser.ActionSheetItem)localObject).a = 2130839222;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).b = true;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).d = 3;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).e = "";
    localArrayList.add(localObject);
    localObject = new IPublicAccountBrowser.ActionSheetItem();
    ((IPublicAccountBrowser.ActionSheetItem)localObject).c = this.b.getResources().getString(2131894192);
    ((IPublicAccountBrowser.ActionSheetItem)localObject).a = 2130839225;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).d = 9;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).e = "";
    localArrayList.add(localObject);
    localObject = new IPublicAccountBrowser.ActionSheetItem();
    ((IPublicAccountBrowser.ActionSheetItem)localObject).c = this.b.getResources().getString(2131894174);
    ((IPublicAccountBrowser.ActionSheetItem)localObject).a = 2130839219;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).d = 10;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).e = "";
    localArrayList.add(localObject);
    localObject = new IPublicAccountBrowser.ActionSheetItem();
    ((IPublicAccountBrowser.ActionSheetItem)localObject).c = this.b.getResources().getString(2131894189);
    ((IPublicAccountBrowser.ActionSheetItem)localObject).a = 2130839224;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).d = 12;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).e = "";
    localArrayList.add(localObject);
    localObject = new IPublicAccountBrowser.ActionSheetItem();
    ((IPublicAccountBrowser.ActionSheetItem)localObject).c = this.b.getResources().getString(2131894168);
    ((IPublicAccountBrowser.ActionSheetItem)localObject).b = true;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).a = 2130843690;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).d = 4;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).e = "";
    localArrayList.add(localObject);
    localObject = new ArrayList();
    IPublicAccountBrowser.ActionSheetItem localActionSheetItem = new IPublicAccountBrowser.ActionSheetItem();
    localActionSheetItem.c = this.b.getResources().getString(2131894163);
    localActionSheetItem.a = 2130839217;
    localActionSheetItem.b = true;
    localActionSheetItem.d = 1;
    localActionSheetItem.e = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    localActionSheetItem = new IPublicAccountBrowser.ActionSheetItem();
    localActionSheetItem.c = this.b.getResources().getString(2131894169);
    localActionSheetItem.a = 2130843680;
    localActionSheetItem.b = true;
    localActionSheetItem.d = 11;
    localActionSheetItem.e = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList, localObject };
  }
  
  public void a()
  {
    if (this.h == null) {
      this.h = ((ActionSheet)ActionSheetHelper.b(this.b, null));
    }
    View localView = c();
    this.h.setActionContentView(localView, null);
    try
    {
      if (!this.h.isShowing())
      {
        this.h.show();
        b();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void a(ChannelInfo paramChannelInfo, Intent paramIntent, VideoShareListener paramVideoShareListener)
  {
    this.g = paramChannelInfo;
    this.j = paramIntent;
    this.k = paramVideoShareListener;
    a();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramInt = 1;
    this.m = true;
    paramAdapterView = paramView.getTag();
    boolean bool = QLog.isColorLevel();
    int n = 2;
    if (bool)
    {
      paramView = new StringBuilder();
      paramView.append("onItemClick, tag = ");
      if (paramAdapterView != null) {
        bool = true;
      } else {
        bool = false;
      }
      paramView.append(bool);
      QLog.d("Q.readinjoy.video.TopicShareHelper", 2, paramView.toString());
    }
    if (paramAdapterView == null) {
      return;
    }
    paramView = this.h;
    if ((paramView != null) && (paramView.isShowing())) {
      this.h.dismiss();
    }
    int i1 = ((TopicShareHelper.ActionSheetItemViewHolder)paramAdapterView).c.d;
    if (i1 == 2)
    {
      this.l = false;
      ForwardBaseOption.a(this.b, this.j, 21);
      paramInt = 0;
    }
    else
    {
      paramView = null;
      if (i1 == 3)
      {
        this.l = false;
        paramAdapterView = new Bundle();
        paramView = new StringBuilder();
        paramView.append(HardCodeUtil.a(2131912336));
        paramView.append(this.g.mChannelName);
        paramView.append(HardCodeUtil.a(2131912333));
        paramAdapterView.putString("title", paramView.toString());
        paramAdapterView.putString("detail_url", a(this.g, 1));
        paramView = new ArrayList(1);
        paramView.add(this.g.mHeaderPicUrl);
        paramAdapterView.putStringArrayList("image_url", paramView);
        paramAdapterView.putLong("req_share_id", 0L);
        QZoneShareManager.jumpToQzoneShare(this.c, this.b, paramAdapterView, null);
      }
      else if ((i1 != 9) && (i1 != 10))
      {
        if (i1 == 12)
        {
          this.l = false;
          paramInt = 5;
          paramAdapterView = new StringBuilder();
          paramAdapterView.append(HardCodeUtil.a(2131912337));
          paramAdapterView.append(this.g.mChannelName);
          paramAdapterView.append(HardCodeUtil.a(2131912334));
          a(paramAdapterView.toString(), null, a(this.g, 4), this.g.mHeaderPicUrl);
          break label912;
        }
        if (i1 == 4)
        {
          this.l = false;
          paramAdapterView = new Intent("android.intent.action.VIEW", Uri.parse(a(this.g, 6)));
          paramAdapterView.putExtra("big_brother_source_key", RIJJumpUtils.a(0));
          paramAdapterView.putExtra("normal", true);
        }
      }
    }
    try
    {
      this.b.startActivity(paramAdapterView);
    }
    catch (ActivityNotFoundException paramAdapterView)
    {
      label449:
      label579:
      break label449;
    }
    QRUtils.a(1, 2131892956);
    break label722;
    if (i1 == 6)
    {
      paramAdapterView = this.c.getCurrentAccountUin();
      QfavBuilder.a(a(this.g, 6)).c(paramAdapterView).b(this.b, paramAdapterView, 103, null);
      paramInt = 6;
    }
    else if (i1 == 1)
    {
      ((ClipboardManager)this.d.getSystemService("clipboard")).setText(a(this.g, 6));
      QRUtils.a(2, 2131888247);
    }
    else if (i1 == 11)
    {
      this.l = false;
    }
    try
    {
      paramAdapterView = URLEncoder.encode(a(this.g, 6), "UTF-8");
    }
    catch (UnsupportedEncodingException paramAdapterView)
    {
      Object localObject2;
      Object localObject1;
      Bitmap localBitmap;
      break label579;
    }
    paramAdapterView = paramView;
    if (QLog.isColorLevel())
    {
      QLog.d("Q.readinjoy.video.TopicShareHelper", 2, "encode url failed, because UTF-8 is unknown");
      paramAdapterView = paramView;
    }
    paramView = new StringBuilder();
    paramView.append("https://post.mp.qq.com/jubao/index?_wv=3&url=");
    paramView.append(paramAdapterView);
    paramView.append("&type=5&key=");
    paramView.append(this.g.mChannelID);
    paramAdapterView = paramView.toString();
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("click jubao btn, reportUrl:");
      paramView.append(paramAdapterView);
      QLog.d("Q.readinjoy.video.TopicShareHelper", 2, paramView.toString());
    }
    paramView = new Intent(this.b, QQBrowserActivity.class);
    paramView.putExtra("url", paramAdapterView);
    paramView.putExtra("hide_more_button", true);
    this.b.startActivity(paramView);
    label722:
    paramInt = 3;
    break label912;
    this.l = false;
    if (i1 == 9)
    {
      paramAdapterView = a(this.g, 2);
      paramInt = n;
    }
    else
    {
      paramAdapterView = a(this.g, 3);
      paramInt = 4;
    }
    localObject2 = new StringBuilder();
    if (this.g.mFollowNum > 0)
    {
      ((StringBuilder)localObject2).append(this.g.mFollowNum);
      ((StringBuilder)localObject2).append("人正在关注");
    }
    paramView = (BaseActivity)this.b;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(HardCodeUtil.a(2131912335));
    ((StringBuilder)localObject1).append(this.g.mChannelName);
    ((StringBuilder)localObject1).append(HardCodeUtil.a(2131912332));
    localObject1 = ((StringBuilder)localObject1).toString();
    localObject2 = ((StringBuilder)localObject2).toString();
    localBitmap = this.e;
    if (i1 == 9) {
      bool = true;
    } else {
      bool = false;
    }
    VideoShareUtils.a(paramView, (String)localObject1, (String)localObject2, paramAdapterView, localBitmap, bool, null, false, null);
    label912:
    paramAdapterView = new StringBuilder();
    paramAdapterView.append(paramInt);
    paramAdapterView.append("");
    ThreadManager.executeOnSubThread(new TopicShareHelper.5(this, paramAdapterView.toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.TopicShareHelper
 * JD-Core Version:    0.7.0.1
 */