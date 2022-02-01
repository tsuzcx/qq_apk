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
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private Intent jdField_a_of_type_AndroidContentIntent;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable = null;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private VideoShareListener jdField_a_of_type_ComTencentMobileqqKandianBizShareVideoShareListener;
  private ChannelInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelInfo;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b = false;
  
  public TopicShareHelper(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidContentContext = paramActivity;
    paramActivity = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramActivity instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramActivity);
      paramActivity = RIJSPUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, true).getString("readinjoy_social_weburl_topicvideo", "");
      if (!TextUtils.isEmpty(paramActivity))
      {
        jdField_a_of_type_JavaLangString = paramActivity;
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
  
  private View a()
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131559102, null);
    float f = this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics().density;
    ElasticHorScrView localElasticHorScrView1 = (ElasticHorScrView)localView.findViewById(2131377008);
    ElasticHorScrView localElasticHorScrView2 = (ElasticHorScrView)localView.findViewById(2131377009);
    GridView localGridView2 = (GridView)localView.findViewById(2131367811);
    GridView localGridView1 = (GridView)localView.findViewById(2131367812);
    Object localObject1 = (TextView)localView.findViewById(2131362003);
    Object localObject2 = (LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
    ((LinearLayout.LayoutParams)localObject2).topMargin = ((int)(13.0F * f));
    ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((TextView)localObject1).setText(2131690728);
    ((TextView)localObject1).setOnClickListener(new TopicShareHelper.2(this));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new TopicShareHelper.3(this));
    if (Build.VERSION.SDK_INT >= 9)
    {
      localElasticHorScrView1.setOverScrollMode(2);
      localElasticHorScrView2.setOverScrollMode(2);
    }
    localGridView1.setSmoothScrollbarEnabled(false);
    localObject2 = a();
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
    int i = ((List)localObject1).size();
    localGridView2.setNumColumns(i);
    ViewGroup.LayoutParams localLayoutParams = localGridView2.getLayoutParams();
    localLayoutParams.width = ((int)((i * 75 + (i - 1) * 10 + 3) * f));
    localGridView2.setLayoutParams(localLayoutParams);
    localGridView2.setAdapter(new TopicShareHelper.ActionSheetItemAdapter(this.jdField_a_of_type_AndroidAppActivity, 0, (List)localObject1));
    localGridView2.setSelector(new ColorDrawable(0));
    localGridView2.setOnItemClickListener(this);
    i = localLayoutParams.width;
    int j = ((List)localObject2).size();
    localObject1 = localGridView1.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject1).width = ((int)((j * 75 + (j - 1) * 10 + 3) * f));
    localGridView1.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localGridView1.setNumColumns(j);
    localGridView1.setAdapter(new TopicShareHelper.ActionSheetItemAdapter(this.jdField_a_of_type_AndroidAppActivity, 0, (List)localObject2));
    localGridView1.setSelector(new ColorDrawable(0));
    localGridView1.setOnItemClickListener(this);
    localView.post(new TopicShareHelper.4(this, localElasticHorScrView1, i, localElasticHorScrView2, ((ViewGroup.LayoutParams)localObject1).width));
    return localView;
  }
  
  public static String a(ChannelInfo paramChannelInfo, int paramInt)
  {
    int i = 5;
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
                i = 6;
              }
            }
            else {
              i = 4;
            }
          }
          else {
            i = 3;
          }
        }
        else {
          i = 2;
        }
      }
      else {
        i = 1;
      }
    }
    else {
      i = 0;
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
    StringBuilder localStringBuilder = new StringBuilder(jdField_a_of_type_JavaLangString);
    localStringBuilder.append(paramChannelInfo.mChannelID);
    localStringBuilder.append("&topicname=");
    localStringBuilder.append(str2);
    localStringBuilder.append("&sourcefrom=");
    localStringBuilder.append(i);
    return localStringBuilder.toString();
  }
  
  /* Error */
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 95
    //   8: iconst_2
    //   9: ldc_w 305
    //   12: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_0
    //   16: getfield 39	com/tencent/mobileqq/kandian/biz/share/TopicShareHelper:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   19: astore_2
    //   20: aload_0
    //   21: getfield 266	com/tencent/mobileqq/kandian/biz/share/TopicShareHelper:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   24: ifnonnull +25 -> 49
    //   27: aload_0
    //   28: new 307	com/tencent/mobileqq/widget/QQProgressDialog
    //   31: dup
    //   32: aload_2
    //   33: aload_2
    //   34: invokevirtual 123	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   37: ldc_w 308
    //   40: invokevirtual 312	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   43: invokespecial 315	com/tencent/mobileqq/widget/QQProgressDialog:<init>	(Landroid/content/Context;I)V
    //   46: putfield 266	com/tencent/mobileqq/kandian/biz/share/TopicShareHelper:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   49: aload_1
    //   50: invokestatic 76	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   53: ifne +443 -> 496
    //   56: aload_3
    //   57: invokestatic 76	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   60: ifeq +6 -> 66
    //   63: goto +433 -> 496
    //   66: aload_0
    //   67: getfield 266	com/tencent/mobileqq/kandian/biz/share/TopicShareHelper:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   70: invokevirtual 318	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   73: ifne +20 -> 93
    //   76: aload_0
    //   77: getfield 266	com/tencent/mobileqq/kandian/biz/share/TopicShareHelper:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   80: ldc_w 319
    //   83: invokevirtual 322	com/tencent/mobileqq/widget/QQProgressDialog:c	(I)V
    //   86: aload_0
    //   87: getfield 266	com/tencent/mobileqq/kandian/biz/share/TopicShareHelper:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   90: invokevirtual 325	com/tencent/mobileqq/widget/QQProgressDialog:show	()V
    //   93: aload_0
    //   94: getfield 41	com/tencent/mobileqq/kandian/biz/share/TopicShareHelper:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   97: invokevirtual 331	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   100: astore 5
    //   102: aload 5
    //   104: ldc_w 333
    //   107: sipush 8192
    //   110: invokevirtual 339	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   113: astore 5
    //   115: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   118: ifeq +12 -> 130
    //   121: ldc 95
    //   123: iconst_2
    //   124: ldc_w 341
    //   127: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   130: new 343	com/tencent/mobileqq/kandian/biz/share/TopicShareHelper$6
    //   133: dup
    //   134: aload_0
    //   135: aload 4
    //   137: aload_1
    //   138: aload_3
    //   139: aload 5
    //   141: aload_2
    //   142: invokespecial 346	com/tencent/mobileqq/kandian/biz/share/TopicShareHelper$6:<init>	(Lcom/tencent/mobileqq/kandian/biz/share/TopicShareHelper;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/pm/ApplicationInfo;Landroid/app/Activity;)V
    //   145: invokestatic 352	com/tencent/mobileqq/app/ThreadManager:executeOnSubThread	(Ljava/lang/Runnable;)V
    //   148: goto +307 -> 455
    //   151: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   154: ifeq +12 -> 166
    //   157: ldc 95
    //   159: iconst_2
    //   160: ldc_w 354
    //   163: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   166: aload_1
    //   167: ldc_w 277
    //   170: invokestatic 282	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   173: astore_1
    //   174: new 86	java/lang/StringBuilder
    //   177: dup
    //   178: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   181: astore 5
    //   183: aload 5
    //   185: ldc_w 356
    //   188: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload 5
    //   194: ldc_w 358
    //   197: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload 5
    //   203: aload_1
    //   204: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload 5
    //   210: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: astore_1
    //   214: aload_3
    //   215: ldc_w 277
    //   218: invokestatic 282	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   221: astore_3
    //   222: new 86	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   229: astore 5
    //   231: aload 5
    //   233: aload_1
    //   234: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: aload 5
    //   240: ldc_w 360
    //   243: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: aload 5
    //   249: aload_3
    //   250: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: aload 5
    //   256: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: astore_1
    //   260: aload 4
    //   262: ldc_w 277
    //   265: invokestatic 282	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   268: astore_3
    //   269: new 86	java/lang/StringBuilder
    //   272: dup
    //   273: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   276: astore 4
    //   278: aload 4
    //   280: aload_1
    //   281: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: aload 4
    //   287: ldc_w 362
    //   290: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: aload 4
    //   296: aload_3
    //   297: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: aload 4
    //   303: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: astore_1
    //   307: new 86	java/lang/StringBuilder
    //   310: dup
    //   311: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   314: astore_3
    //   315: aload_3
    //   316: aload_1
    //   317: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: aload_3
    //   322: ldc_w 364
    //   325: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: pop
    //   329: aload_3
    //   330: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   333: astore_1
    //   334: new 366	android/content/Intent
    //   337: dup
    //   338: aload_2
    //   339: ldc_w 368
    //   342: invokespecial 371	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   345: astore_3
    //   346: aload_3
    //   347: ldc_w 373
    //   350: aload_1
    //   351: invokevirtual 377	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   354: pop
    //   355: aload_2
    //   356: aload_3
    //   357: invokevirtual 381	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   360: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   363: ifeq +12 -> 375
    //   366: ldc 95
    //   368: iconst_2
    //   369: ldc_w 383
    //   372: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   375: aload_0
    //   376: getfield 266	com/tencent/mobileqq/kandian/biz/share/TopicShareHelper:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   379: astore_1
    //   380: aload_1
    //   381: ifnull +74 -> 455
    //   384: aload_1
    //   385: invokevirtual 318	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   388: ifeq +67 -> 455
    //   391: goto +57 -> 448
    //   394: astore_1
    //   395: goto +76 -> 471
    //   398: astore_1
    //   399: aload_0
    //   400: getfield 41	com/tencent/mobileqq/kandian/biz/share/TopicShareHelper:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   403: iconst_0
    //   404: ldc_w 384
    //   407: iconst_0
    //   408: invokestatic 389	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;III)Lcom/tencent/mobileqq/widget/QQToast;
    //   411: aload_0
    //   412: getfield 41	com/tencent/mobileqq/kandian/biz/share/TopicShareHelper:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   415: invokevirtual 390	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   418: ldc_w 308
    //   421: invokevirtual 312	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   424: invokevirtual 393	com/tencent/mobileqq/widget/QQToast:b	(I)Landroid/widget/Toast;
    //   427: pop
    //   428: aload_1
    //   429: invokevirtual 394	java/lang/Exception:printStackTrace	()V
    //   432: aload_0
    //   433: getfield 266	com/tencent/mobileqq/kandian/biz/share/TopicShareHelper:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   436: astore_1
    //   437: aload_1
    //   438: ifnull +17 -> 455
    //   441: aload_1
    //   442: invokevirtual 318	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   445: ifeq +10 -> 455
    //   448: aload_0
    //   449: getfield 266	com/tencent/mobileqq/kandian/biz/share/TopicShareHelper:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   452: invokevirtual 397	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   455: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   458: ifeq +12 -> 470
    //   461: ldc 95
    //   463: iconst_2
    //   464: ldc_w 399
    //   467: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   470: return
    //   471: aload_0
    //   472: getfield 266	com/tencent/mobileqq/kandian/biz/share/TopicShareHelper:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   475: astore_2
    //   476: aload_2
    //   477: ifnull +17 -> 494
    //   480: aload_2
    //   481: invokevirtual 318	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   484: ifeq +10 -> 494
    //   487: aload_0
    //   488: getfield 266	com/tencent/mobileqq/kandian/biz/share/TopicShareHelper:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   491: invokevirtual 397	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   494: aload_1
    //   495: athrow
    //   496: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   499: ifeq +12 -> 511
    //   502: ldc 95
    //   504: iconst_2
    //   505: ldc_w 401
    //   508: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   511: aload_0
    //   512: getfield 266	com/tencent/mobileqq/kandian/biz/share/TopicShareHelper:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   515: astore_1
    //   516: aload_1
    //   517: ifnull +17 -> 534
    //   520: aload_1
    //   521: invokevirtual 318	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   524: ifeq +10 -> 534
    //   527: aload_0
    //   528: getfield 266	com/tencent/mobileqq/kandian/biz/share/TopicShareHelper:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   531: invokevirtual 397	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   534: aload_0
    //   535: getfield 41	com/tencent/mobileqq/kandian/biz/share/TopicShareHelper:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   538: iconst_0
    //   539: ldc_w 384
    //   542: iconst_0
    //   543: invokestatic 389	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;III)Lcom/tencent/mobileqq/widget/QQToast;
    //   546: aload_0
    //   547: getfield 41	com/tencent/mobileqq/kandian/biz/share/TopicShareHelper:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   550: invokevirtual 390	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   553: ldc_w 308
    //   556: invokevirtual 312	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   559: invokevirtual 393	com/tencent/mobileqq/widget/QQToast:b	(I)Landroid/widget/Toast;
    //   562: pop
    //   563: return
    //   564: astore 5
    //   566: goto -415 -> 151
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	569	0	this	TopicShareHelper
    //   0	569	1	paramString1	String
    //   0	569	2	paramString2	String
    //   0	569	3	paramString3	String
    //   0	569	4	paramString4	String
    //   100	155	5	localObject	Object
    //   564	1	5	localNameNotFoundException	android.content.pm.PackageManager.NameNotFoundException
    // Exception table:
    //   from	to	target	type
    //   166	375	394	finally
    //   399	432	394	finally
    //   166	375	398	java/lang/Exception
    //   102	130	564	android/content/pm/PackageManager$NameNotFoundException
    //   130	148	564	android/content/pm/PackageManager$NameNotFoundException
  }
  
  private List<IPublicAccountBrowser.ActionSheetItem>[] a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new IPublicAccountBrowser.ActionSheetItem();
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131696399);
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Int = 2130839067;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_Int = 2;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new IPublicAccountBrowser.ActionSheetItem();
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131696413);
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Int = 2130839068;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_Int = 3;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new IPublicAccountBrowser.ActionSheetItem();
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131696420);
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Int = 2130839071;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_Int = 9;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new IPublicAccountBrowser.ActionSheetItem();
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131696402);
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Int = 2130839065;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_Int = 10;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new IPublicAccountBrowser.ActionSheetItem();
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131696417);
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Int = 2130839070;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_Int = 12;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new IPublicAccountBrowser.ActionSheetItem();
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131696396);
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Int = 2130842737;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_Int = 4;
    ((IPublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new ArrayList();
    IPublicAccountBrowser.ActionSheetItem localActionSheetItem = new IPublicAccountBrowser.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131696391);
    localActionSheetItem.jdField_a_of_type_Int = 2130839063;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.jdField_b_of_type_Int = 1;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    localActionSheetItem = new IPublicAccountBrowser.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131696397);
    localActionSheetItem.jdField_a_of_type_Int = 2130842727;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.jdField_b_of_type_Int = 11;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList, localObject };
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    try
    {
      this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelInfo.mHeaderPicUrl, null, null);
      URLDrawable localURLDrawable = this.jdField_a_of_type_ComTencentImageURLDrawable;
      if ((localURLDrawable != null) && (localURLDrawable.getStatus() == 1) && ((this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable() instanceof RegionDrawable)))
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap = ((RegionDrawable)this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable()).getBitmap();
        return;
      }
      localURLDrawable = this.jdField_a_of_type_ComTencentImageURLDrawable;
      if (localURLDrawable != null)
      {
        localURLDrawable.setURLDrawableListener(new TopicShareHelper.1(this));
        this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
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
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidAppActivity, null));
    }
    View localView = a();
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setActionContentView(localView, null);
    try
    {
      if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
        b();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void a(ChannelInfo paramChannelInfo, Intent paramIntent, VideoShareListener paramVideoShareListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelInfo = paramChannelInfo;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizShareVideoShareListener = paramVideoShareListener;
    a();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramInt = 1;
    this.b = true;
    paramAdapterView = paramView.getTag();
    boolean bool = QLog.isColorLevel();
    int i = 2;
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
    paramView = this.jdField_a_of_type_ComTencentWidgetActionSheet;
    if ((paramView != null) && (paramView.isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
    int j = ((TopicShareHelper.ActionSheetItemViewHolder)paramAdapterView).a.jdField_b_of_type_Int;
    if (j == 2)
    {
      this.jdField_a_of_type_Boolean = false;
      ForwardBaseOption.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentIntent, 21);
      paramInt = 0;
    }
    else
    {
      paramView = null;
      if (j == 3)
      {
        this.jdField_a_of_type_Boolean = false;
        paramAdapterView = new Bundle();
        paramView = new StringBuilder();
        paramView.append(HardCodeUtil.a(2131714835));
        paramView.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelInfo.mChannelName);
        paramView.append(HardCodeUtil.a(2131714832));
        paramAdapterView.putString("title", paramView.toString());
        paramAdapterView.putString("detail_url", a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelInfo, 1));
        paramView = new ArrayList(1);
        paramView.add(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelInfo.mHeaderPicUrl);
        paramAdapterView.putStringArrayList("image_url", paramView);
        paramAdapterView.putLong("req_share_id", 0L);
        QZoneShareManager.jumpToQzoneShare(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, paramAdapterView, null);
      }
      else if ((j != 9) && (j != 10))
      {
        if (j == 12)
        {
          this.jdField_a_of_type_Boolean = false;
          paramInt = 5;
          paramAdapterView = new StringBuilder();
          paramAdapterView.append(HardCodeUtil.a(2131714836));
          paramAdapterView.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelInfo.mChannelName);
          paramAdapterView.append(HardCodeUtil.a(2131714833));
          a(paramAdapterView.toString(), null, a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelInfo, 4), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelInfo.mHeaderPicUrl);
          break label915;
        }
        if (j == 4)
        {
          this.jdField_a_of_type_Boolean = false;
          paramAdapterView = new Intent("android.intent.action.VIEW", Uri.parse(a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelInfo, 6)));
          paramAdapterView.putExtra("big_brother_source_key", RIJJumpUtils.a(0));
          paramAdapterView.putExtra("normal", true);
        }
      }
    }
    try
    {
      this.jdField_a_of_type_AndroidAppActivity.startActivity(paramAdapterView);
    }
    catch (ActivityNotFoundException paramAdapterView)
    {
      label449:
      label580:
      break label449;
    }
    QRUtils.a(1, 2131695222);
    break label725;
    if (j == 6)
    {
      paramAdapterView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      QfavBuilder.a(a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelInfo, 6)).c(paramAdapterView).b(this.jdField_a_of_type_AndroidAppActivity, paramAdapterView, 103, null);
      paramInt = 6;
    }
    else if (j == 1)
    {
      ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelInfo, 6));
      QRUtils.a(2, 2131691296);
    }
    else if (j == 11)
    {
      this.jdField_a_of_type_Boolean = false;
    }
    try
    {
      paramAdapterView = URLEncoder.encode(a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelInfo, 6), "UTF-8");
    }
    catch (UnsupportedEncodingException paramAdapterView)
    {
      Object localObject2;
      Object localObject1;
      Bitmap localBitmap;
      break label580;
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
    paramView.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelInfo.mChannelID);
    paramAdapterView = paramView.toString();
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("click jubao btn, reportUrl:");
      paramView.append(paramAdapterView);
      QLog.d("Q.readinjoy.video.TopicShareHelper", 2, paramView.toString());
    }
    paramView = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
    paramView.putExtra("url", paramAdapterView);
    paramView.putExtra("hide_more_button", true);
    this.jdField_a_of_type_AndroidAppActivity.startActivity(paramView);
    label725:
    paramInt = 3;
    break label915;
    this.jdField_a_of_type_Boolean = false;
    if (j == 9)
    {
      paramAdapterView = a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelInfo, 2);
      paramInt = i;
    }
    else
    {
      paramAdapterView = a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelInfo, 3);
      paramInt = 4;
    }
    localObject2 = new StringBuilder();
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelInfo.mFollowNum > 0)
    {
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelInfo.mFollowNum);
      ((StringBuilder)localObject2).append("人正在关注");
    }
    paramView = (BaseActivity)this.jdField_a_of_type_AndroidAppActivity;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(HardCodeUtil.a(2131714834));
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelInfo.mChannelName);
    ((StringBuilder)localObject1).append(HardCodeUtil.a(2131714831));
    localObject1 = ((StringBuilder)localObject1).toString();
    localObject2 = ((StringBuilder)localObject2).toString();
    localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (j == 9) {
      bool = true;
    } else {
      bool = false;
    }
    VideoShareUtils.a(paramView, (String)localObject1, (String)localObject2, paramAdapterView, localBitmap, bool, null, false, null);
    label915:
    paramAdapterView = new StringBuilder();
    paramAdapterView.append(paramInt);
    paramAdapterView.append("");
    ThreadManager.executeOnSubThread(new TopicShareHelper.5(this, paramAdapterView.toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.TopicShareHelper
 * JD-Core Version:    0.7.0.1
 */