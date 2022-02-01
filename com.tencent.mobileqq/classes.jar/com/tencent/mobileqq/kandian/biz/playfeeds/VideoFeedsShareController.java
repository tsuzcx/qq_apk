package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.Window;
import com.tencent.biz.pubaccount.EncryptUinHandler;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdInfo;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdInfo.NegFeedback;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.dislike.ReadInJoyDisLikeDialogView;
import com.tencent.mobileqq.kandian.biz.share.ReadInJoyShareHelperV2;
import com.tencent.mobileqq.kandian.biz.share.ShareAction;
import com.tencent.mobileqq.kandian.biz.ugc.RIJUgcUtils;
import com.tencent.mobileqq.kandian.biz.video.FeedsChannelDataHelper;
import com.tencent.mobileqq.kandian.biz.video.VideoStructMsgHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.GalleryReportedUtils;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJSocialBottomViewAladdinConfig;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeInfo;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo.VideoExtraRepoerData;
import com.tencent.mobileqq.kandian.repo.share.ShareReport;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.SVUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.WatchDismissActions;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class VideoFeedsShareController
{
  private static final HashSet<Integer> b = new HashSet(Arrays.asList(new Integer[] { Integer.valueOf(9), Integer.valueOf(10), Integer.valueOf(12), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(72) }));
  private static HashMap<String, Integer> c = new HashMap();
  ReadInJoyShareHelperV2 a;
  private VideoInfo d;
  private VideoInfo e;
  private VideoFeedsPlayManager f;
  private Activity g;
  private MqqHandler h = new VideoFeedsShareController.ShortVideoMqqHandler(this, null);
  private Bitmap i = null;
  private URLDrawable j = null;
  private ActionSheet k;
  private QQAppInterface l;
  private int m;
  private boolean n = false;
  private boolean o = false;
  private boolean p = false;
  private VideoFeedsShareController.ShareSheetActionListener q;
  private boolean r = true;
  private boolean s = false;
  private int t;
  private EncryptUinHandler u;
  private int v = 0;
  private IColorNoteController w;
  private VideoFeedsShareController.RIJObserver x;
  private SparseArray<ShareAction> y = new SparseArray();
  
  public VideoFeedsShareController(Activity paramActivity, QQAppInterface paramQQAppInterface, VideoFeedsPlayManager paramVideoFeedsPlayManager, int paramInt1, boolean paramBoolean, VideoFeedsShareController.ShareSheetActionListener paramShareSheetActionListener, int paramInt2)
  {
    this.f = paramVideoFeedsPlayManager;
    this.g = paramActivity;
    this.m = paramInt1;
    this.l = paramQQAppInterface;
    this.q = paramShareSheetActionListener;
    this.s = paramBoolean;
    this.u = ((EncryptUinHandler)this.l.getBusinessHandler(BusinessHandlerFactory.ENCRYPT_UIN_HANDLER));
    paramActivity = this.u;
    if (paramActivity != null) {
      paramActivity.b();
    }
    this.v = paramInt2;
    this.x = new VideoFeedsShareController.RIJObserver(this, null);
    ReadInJoyLogicEngineEventDispatcher.a().a(this.x);
    g();
  }
  
  private void a(int paramInt, VideoInfo paramVideoInfo)
  {
    if ((paramInt != 1) && (paramInt != 11) && (paramInt != 6) && (!this.s))
    {
      ReportInfo.VideoExtraRepoerData localVideoExtraRepoerData = new ReportInfo.VideoExtraRepoerData();
      localVideoExtraRepoerData.d = ((int)this.f.b());
      localVideoExtraRepoerData.e = (paramVideoInfo.k() * 1000);
      paramVideoInfo = this.g;
      if (paramVideoInfo != null)
      {
        localVideoExtraRepoerData.b = paramVideoInfo.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
        paramInt = this.g.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);
      }
      else
      {
        paramInt = -1;
      }
      if (this.v == 1)
      {
        localVideoInfo = this.d;
        paramVideoInfo = this.e;
        if (paramVideoInfo != null) {
          paramVideoInfo = paramVideoInfo.l;
        } else {
          paramVideoInfo = null;
        }
        VideoReporter.a(localVideoInfo, paramInt, 26, -1, localVideoExtraRepoerData, paramVideoInfo);
        return;
      }
      VideoInfo localVideoInfo = this.d;
      paramVideoInfo = this.e;
      if (paramVideoInfo != null) {
        paramVideoInfo = paramVideoInfo.l;
      } else {
        paramVideoInfo = null;
      }
      VideoReporter.b(localVideoInfo, paramInt, 26, -1, localVideoExtraRepoerData, paramVideoInfo);
    }
  }
  
  private void a(int paramInt1, VideoInfo paramVideoInfo, String paramString, int paramInt2, int paramInt3)
  {
    this.f.b(this.o);
    boolean bool1;
    if (!TextUtils.isEmpty(paramVideoInfo.ab))
    {
      paramString = paramVideoInfo.ab;
      bool1 = true;
    }
    else
    {
      if (paramInt1 == 9)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("&sourcefrom=2");
        paramString = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("&sourcefrom=3");
        paramString = ((StringBuilder)localObject1).toString();
      }
      bool1 = false;
    }
    Object localObject1 = paramString;
    if (paramVideoInfo.z != null)
    {
      localObject1 = paramString;
      if (paramVideoInfo.z.contains("kandianshare.html5.qq.com")) {
        localObject1 = paramVideoInfo.z;
      }
    }
    Object localObject2 = new StringBuilder();
    if (paramVideoInfo.aj > 0)
    {
      ((StringBuilder)localObject2).append(VideoFeedsHelper.b(paramVideoInfo.aj));
      ((StringBuilder)localObject2).append(" ");
    }
    paramString = (BaseActivity)this.g;
    String str = paramVideoInfo.g;
    localObject2 = ((StringBuilder)localObject2).toString();
    Bitmap localBitmap = this.i;
    boolean bool2;
    if (paramInt1 == 9) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    VideoShareUtils.a(paramString, str, (String)localObject2, (String)localObject1, localBitmap, bool2, paramVideoInfo.l, bool1, new VideoFeedsShareController.WeChatShareResultCallback(this.g, this.m, this.t, paramInt2, paramInt3, paramVideoInfo));
  }
  
  public static void a(VideoInfo paramVideoInfo, Activity paramActivity, int paramInt1, @NotNull String paramString1, int paramInt2, String paramString2)
  {
    if (paramVideoInfo == null) {
      return;
    }
    paramVideoInfo = VideoStructMsgHelper.a.a(FeedsChannelDataHelper.a(paramVideoInfo));
    Intent localIntent = new Intent();
    localIntent.putExtras(paramVideoInfo);
    if (TextUtils.isEmpty(paramString1))
    {
      ForwardBaseOption.a(paramActivity, localIntent, 21);
      return;
    }
    localIntent.putExtra("toUin", paramString1);
    localIntent.putExtra("uinType", paramInt2);
    localIntent.putExtra("uinname", paramString2);
    ForwardBaseOption.a(paramActivity, localIntent, DirectForwardActivity.class, 21, -1, "");
  }
  
  /* Error */
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 333
    //   4: invokespecial 279	com/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsShareController:b	(Ljava/lang/String;)V
    //   7: aload_0
    //   8: getfield 113	com/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsShareController:g	Landroid/app/Activity;
    //   11: astore_2
    //   12: bipush 9
    //   14: anewarray 240	java/lang/String
    //   17: astore 6
    //   19: aload 6
    //   21: iconst_0
    //   22: ldc_w 334
    //   25: invokestatic 338	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   28: aastore
    //   29: aload 6
    //   31: iconst_1
    //   32: ldc_w 339
    //   35: invokestatic 338	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   38: aastore
    //   39: aload 6
    //   41: iconst_2
    //   42: ldc_w 340
    //   45: invokestatic 338	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   48: aastore
    //   49: aload 6
    //   51: iconst_3
    //   52: ldc_w 341
    //   55: invokestatic 338	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   58: aastore
    //   59: aload 6
    //   61: iconst_4
    //   62: ldc_w 342
    //   65: invokestatic 338	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   68: aastore
    //   69: aload 6
    //   71: iconst_5
    //   72: ldc_w 343
    //   75: invokestatic 338	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   78: aastore
    //   79: aload 6
    //   81: bipush 6
    //   83: ldc_w 344
    //   86: invokestatic 338	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   89: aastore
    //   90: aload 6
    //   92: bipush 7
    //   94: ldc_w 345
    //   97: invokestatic 338	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   100: aastore
    //   101: aload 6
    //   103: bipush 8
    //   105: ldc_w 346
    //   108: invokestatic 338	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   111: aastore
    //   112: aload 6
    //   114: new 348	java/util/Random
    //   117: dup
    //   118: invokespecial 349	java/util/Random:<init>	()V
    //   121: aload 6
    //   123: arraylength
    //   124: invokevirtual 353	java/util/Random:nextInt	(I)I
    //   127: aaload
    //   128: astore 6
    //   130: new 220	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   137: astore 7
    //   139: aload 7
    //   141: ldc_w 355
    //   144: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload 7
    //   150: aload 6
    //   152: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload 7
    //   158: ldc_w 357
    //   161: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload 7
    //   167: aload_1
    //   168: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload 7
    //   174: ldc_w 359
    //   177: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload 7
    //   183: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: astore_1
    //   187: aload_1
    //   188: invokestatic 218	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   191: ifne +311 -> 502
    //   194: aload_3
    //   195: invokestatic 218	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   198: ifeq +6 -> 204
    //   201: goto +301 -> 502
    //   204: aload_0
    //   205: getfield 111	com/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsShareController:f	Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsPlayManager;
    //   208: aload_0
    //   209: getfield 96	com/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsShareController:o	Z
    //   212: invokevirtual 209	com/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsPlayManager:b	(Z)V
    //   215: aload_0
    //   216: ldc_w 361
    //   219: invokespecial 279	com/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsShareController:b	(Ljava/lang/String;)V
    //   222: aload_1
    //   223: ldc_w 363
    //   226: invokestatic 369	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   229: astore_1
    //   230: new 220	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   237: astore 6
    //   239: aload 6
    //   241: ldc_w 371
    //   244: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: aload 6
    //   250: ldc_w 373
    //   253: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: aload 6
    //   259: aload_1
    //   260: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: aload 6
    //   266: ldc_w 375
    //   269: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: aload 6
    //   275: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: astore_1
    //   279: aload_3
    //   280: ldc_w 363
    //   283: invokestatic 369	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   286: astore_3
    //   287: new 220	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   294: astore 6
    //   296: aload 6
    //   298: aload_1
    //   299: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: pop
    //   303: aload 6
    //   305: ldc_w 377
    //   308: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: pop
    //   312: aload 6
    //   314: aload_3
    //   315: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: aload 6
    //   321: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: astore_1
    //   325: aload 4
    //   327: ldc_w 363
    //   330: invokestatic 369	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   333: astore_3
    //   334: new 220	java/lang/StringBuilder
    //   337: dup
    //   338: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   341: astore 4
    //   343: aload 4
    //   345: aload_1
    //   346: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: pop
    //   350: aload 4
    //   352: ldc_w 379
    //   355: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: pop
    //   359: aload 4
    //   361: aload_3
    //   362: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: pop
    //   366: aload 4
    //   368: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   371: astore_1
    //   372: new 220	java/lang/StringBuilder
    //   375: dup
    //   376: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   379: astore_3
    //   380: aload_3
    //   381: aload_1
    //   382: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: pop
    //   386: aload_3
    //   387: ldc_w 381
    //   390: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: pop
    //   394: aload_3
    //   395: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   398: astore_1
    //   399: new 184	android/content/Intent
    //   402: dup
    //   403: aload_2
    //   404: ldc_w 383
    //   407: invokespecial 386	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   410: astore_3
    //   411: aload_3
    //   412: ldc_w 388
    //   415: aload_1
    //   416: invokevirtual 314	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   419: pop
    //   420: aload_0
    //   421: getfield 102	com/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsShareController:s	Z
    //   424: ifeq +115 -> 539
    //   427: ldc_w 389
    //   430: istore 5
    //   432: goto +3 -> 435
    //   435: aload_3
    //   436: ldc_w 391
    //   439: iload 5
    //   441: invokestatic 394	com/tencent/mobileqq/kandian/glue/router/RIJJumpUtils:a	(I)Ljava/lang/String;
    //   444: invokevirtual 314	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   447: pop
    //   448: aload_2
    //   449: aload_3
    //   450: invokevirtual 398	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   453: aload_0
    //   454: ldc_w 400
    //   457: invokespecial 279	com/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsShareController:b	(Ljava/lang/String;)V
    //   460: return
    //   461: astore_1
    //   462: goto +38 -> 500
    //   465: astore_1
    //   466: aload_0
    //   467: getfield 113	com/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsShareController:g	Landroid/app/Activity;
    //   470: iconst_0
    //   471: ldc_w 401
    //   474: iconst_0
    //   475: invokestatic 407	com/tencent/mobileqq/widget/QQToast:makeText	(Landroid/content/Context;III)Lcom/tencent/mobileqq/widget/QQToast;
    //   478: aload_0
    //   479: getfield 113	com/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsShareController:g	Landroid/app/Activity;
    //   482: invokevirtual 411	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   485: ldc_w 412
    //   488: invokevirtual 417	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   491: invokevirtual 421	com/tencent/mobileqq/widget/QQToast:show	(I)Landroid/widget/Toast;
    //   494: pop
    //   495: aload_1
    //   496: invokevirtual 424	java/lang/Exception:printStackTrace	()V
    //   499: return
    //   500: aload_1
    //   501: athrow
    //   502: aload_0
    //   503: ldc_w 426
    //   506: invokespecial 279	com/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsShareController:b	(Ljava/lang/String;)V
    //   509: aload_0
    //   510: getfield 113	com/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsShareController:g	Landroid/app/Activity;
    //   513: iconst_0
    //   514: ldc_w 401
    //   517: iconst_0
    //   518: invokestatic 407	com/tencent/mobileqq/widget/QQToast:makeText	(Landroid/content/Context;III)Lcom/tencent/mobileqq/widget/QQToast;
    //   521: aload_0
    //   522: getfield 113	com/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsShareController:g	Landroid/app/Activity;
    //   525: invokevirtual 411	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   528: ldc_w 412
    //   531: invokevirtual 417	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   534: invokevirtual 421	com/tencent/mobileqq/widget/QQToast:show	(I)Landroid/widget/Toast;
    //   537: pop
    //   538: return
    //   539: iconst_0
    //   540: istore 5
    //   542: goto -107 -> 435
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	545	0	this	VideoFeedsShareController
    //   0	545	1	paramString1	String
    //   0	545	2	paramString2	String
    //   0	545	3	paramString3	String
    //   0	545	4	paramString4	String
    //   430	111	5	i1	int
    //   17	303	6	localObject	Object
    //   137	45	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   222	427	461	finally
    //   435	460	461	finally
    //   466	499	461	finally
    //   222	427	465	java/lang/Exception
    //   435	460	465	java/lang/Exception
  }
  
  private void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    ReadInJoyLogicEngine.a().O();
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = c.containsKey(paramString);
    boolean bool1 = true;
    if (bool2)
    {
      if (((Integer)c.get(paramString)).intValue() == 0) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  private static void b(Context paramContext, int paramInt1, int paramInt2, VideoInfo paramVideoInfo, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str = "";
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("network", GalleryReportedUtils.a(paramContext));
        localJSONObject.put("os", "1");
        paramContext = new StringBuilder();
        paramContext.append(paramInt1);
        paramContext.append("");
        localJSONObject.put("source", paramContext.toString());
        localJSONObject.put("uin", paramVideoInfo.q);
        localJSONObject.put("rowkey", paramVideoInfo.aB.innerUniqueID);
        localJSONObject.put("version", VideoReporter.a);
        localJSONObject.put("vid", paramVideoInfo.b);
        paramInt1 = 1;
        if (paramBoolean1) {
          localJSONObject.put("cancel", String.valueOf(1));
        }
        if (paramInt3 >= 0)
        {
          paramContext = new StringBuilder();
          paramContext.append(paramInt3);
          paramContext.append("");
          localJSONObject.put("sourcefrom", paramContext.toString());
        }
        if (paramInt4 < 0) {
          break label371;
        }
        paramContext = new StringBuilder();
        paramContext.append(paramInt4);
        paramContext.append("");
        localJSONObject.put("share_unit", paramContext.toString());
      }
      catch (Exception localException)
      {
        JSONObject localJSONObject;
        paramContext = str;
        if (!QLog.isColorLevel()) {
          break label313;
        }
        paramContext = new StringBuilder();
        paramContext.append("shareReport:");
        paramContext.append(localException.toString());
        QLog.d("VideoFeedsShareController", 2, paramContext.toString());
        paramContext = str;
      }
      localJSONObject.put("result", paramInt1);
      localJSONObject.put("show", paramInt2);
      paramContext = localJSONObject.toString();
      label313:
      paramContext = new VideoR5.Builder(paramContext);
      PublicAccountReportUtils.a(null, "", "0X800979D", "0X800979D", 0, 0, "", String.valueOf(paramVideoInfo.l), String.valueOf(paramVideoInfo.ah), paramContext.b().a(), false);
      ShareReport.a.a(paramBoolean2);
      return;
      label371:
      if (paramBoolean2) {
        paramInt1 = 0;
      }
    }
  }
  
  private void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsShareController", 2, paramString);
    }
  }
  
  @NotNull
  private String d(VideoInfo paramVideoInfo)
  {
    String str = "";
    if (paramVideoInfo == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    EncryptUinHandler localEncryptUinHandler = this.u;
    if (localEncryptUinHandler != null) {
      str = localEncryptUinHandler.a();
    }
    if (!TextUtils.isEmpty(paramVideoInfo.k))
    {
      localStringBuilder.append(paramVideoInfo.k);
      if (!TextUtils.isEmpty(str))
      {
        localStringBuilder.append("&iid=");
        localStringBuilder.append(str);
      }
      localStringBuilder.append("&rowkey=");
      localStringBuilder.append(paramVideoInfo.l);
    }
    return localStringBuilder.toString();
  }
  
  public static int f()
  {
    return ((Integer)RIJSPUtils.b("CONFIG_LAST_SHARE_ACTION", Integer.valueOf(1))).intValue();
  }
  
  private void f(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 6) && (paramInt != 26) && (paramInt != 82)) {
      return;
    }
    VideoFeedsPlayManager localVideoFeedsPlayManager = this.f;
    if (localVideoFeedsPlayManager != null) {
      localVideoFeedsPlayManager.h();
    }
  }
  
  private void g()
  {
    this.y.put(13, new VideoFeedsShareController.SendToReadInJoyShareAction(this));
    this.y.put(1, new VideoFeedsShareController.CopyLinkAction(this));
    this.y.put(11, new VideoFeedsShareController.ReportAction(this));
    this.y.put(72, new VideoFeedsShareController.SendToSpecialFriendShareAction(this));
    this.y.put(2, new VideoFeedsShareController.SendToFriendShareAction(this));
    this.y.put(73, new VideoFeedsShareController.SendToFriendShareAction(this));
    this.y.put(5, new VideoFeedsShareController.OpenInQQBrowserShareAction(this));
    this.y.put(4, new VideoFeedsShareController.OpenInSysBrowserShareAction(this));
    this.y.put(3, new VideoFeedsShareController.SendToQzoneShareAction(this));
    this.y.put(6, new VideoFeedsShareController.AddFavoriteAction(this));
    this.y.put(9, new VideoFeedsShareController.SendToWeChatShareAction(this));
    this.y.put(10, new VideoFeedsShareController.SendToWeChatCircleShareAction(this));
    this.y.put(12, new VideoFeedsShareController.SendToSinaShareAction(this));
    this.y.put(44, new VideoFeedsShareController.ReportDislikeAction(this));
    this.y.put(26, new VideoFeedsShareController.SendToPcAction(this));
    this.y.put(161, new VideoFeedsShareController.ReportVideoPlayFeedbackAction(this));
    this.y.put(70, new VideoFeedsShareController.AddColorNoteAction(this));
    this.y.put(82, new VideoFeedsShareController.RemoveColorNoteAction(this));
    this.y.put(165, new VideoFeedsShareController.VideoSetAction(this));
  }
  
  private static void g(int paramInt)
  {
    RIJSPUtils.a("CONFIG_LAST_SHARE_ACTION", Integer.valueOf(paramInt));
  }
  
  private void h()
  {
    this.i = null;
    this.j = null;
    if (this.d == null) {
      return;
    }
    try
    {
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      int i1 = VideoFeedsHelper.c(this.g)[0];
      int i2 = this.d.d(this.g);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = i1;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i2;
      this.j = URLDrawable.getDrawable(this.d.f, (URLDrawable.URLDrawableOptions)localObject);
      localObject = this.j;
      if ((localObject != null) && (((URLDrawable)localObject).getStatus() == 1) && ((this.j.getCurrDrawable() instanceof RegionDrawable)))
      {
        this.i = ((RegionDrawable)this.j.getCurrDrawable()).getBitmap();
        return;
      }
      localObject = this.j;
      if (localObject != null)
      {
        ((URLDrawable)localObject).setURLDrawableListener(new VideoFeedsShareController.7(this));
        this.j.startDownload();
      }
      return;
    }
    catch (Exception localException)
    {
      label146:
      break label146;
    }
    b("initVideoThumbBitmap() URLDrawable.getDrawable ERROR, RETURN");
  }
  
  private void i()
  {
    VideoInfo localVideoInfo = this.d;
    this.k = ((ActionSheet)ActionSheetHelper.b(this.g, null));
    Object localObject = new VideoFeedsShareController.8(this);
    this.k.registerWatchDisMissActionListener((ActionSheet.WatchDismissActions)localObject);
    localObject = ((IRIJAdService)QRoute.api(IRIJAdService.class)).createReadInJoyDisLikeDialogViewForAd(this.g);
    ((ReadInJoyDisLikeDialogView)localObject).setOnUninterestConfirmListener(new VideoFeedsShareController.9(this, localVideoInfo));
    ((ReadInJoyDisLikeDialogView)localObject).setOnComplainListener(new VideoFeedsShareController.10(this, localVideoInfo));
    ArrayList localArrayList = new ArrayList();
    if ((localVideoInfo != null) && (localVideoInfo.as != null) && (localVideoInfo.as.P.size() > 0))
    {
      Iterator localIterator = localVideoInfo.as.P.iterator();
      while (localIterator.hasNext())
      {
        VideoAdInfo.NegFeedback localNegFeedback = (VideoAdInfo.NegFeedback)localIterator.next();
        DislikeInfo localDislikeInfo = new DislikeInfo();
        localDislikeInfo.c = localNegFeedback.b;
        localDislikeInfo.e = ((int)localNegFeedback.a);
        if (TextUtils.isEmpty(localVideoInfo.q)) {
          localDislikeInfo.f = "";
        } else {
          localDislikeInfo.f = localVideoInfo.q;
        }
        localArrayList.add(localDislikeInfo);
      }
    }
    if (localArrayList.size() == 0) {
      return;
    }
    ((ReadInJoyDisLikeDialogView)localObject).setUninterestData(localArrayList);
    this.k.setActionContentView((View)localObject, null);
    try
    {
      if (!this.k.isShowing())
      {
        if ((VersionUtils.g()) && (!ShortVideoUtils.isInFullScreenBlackList()))
        {
          this.k.getWindow().setFlags(8, 8);
          this.k.getWindow().getDecorView().setSystemUiVisibility(this.g.getWindow().getDecorView().getSystemUiVisibility());
          this.k.setOnShowListener(new VideoFeedsShareController.11(this));
        }
        this.k.show();
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected int a()
  {
    Activity localActivity = this.g;
    int i2 = 0;
    int i1 = i2;
    if (localActivity != null)
    {
      i1 = i2;
      if (localActivity.getIntent() != null) {
        i1 = this.g.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
      }
    }
    return i1;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    b("doOnShareButtonPressed()");
    this.t = paramInt1;
    Object localObject = this.d;
    if ((localObject != null) && (((VideoInfo)localObject).a == 0))
    {
      a(this.d.aQ);
    }
    else
    {
      localObject = this.d;
      if ((localObject != null) && (((VideoInfo)localObject).aq) && (this.d.ar == 1) && (this.d.e(this.g))) {
        i();
      } else {
        b(paramInt2);
      }
    }
    localObject = this.q;
    if (localObject != null) {
      ((VideoFeedsShareController.ShareSheetActionListener)localObject).e();
    }
    localObject = this.f;
    if ((localObject != null) && (((VideoFeedsPlayManager)localObject).k()))
    {
      this.o = true;
      this.f.g();
      return;
    }
    this.o = false;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    paramIntent = this.d;
    if (paramIntent != null)
    {
      boolean bool;
      if (paramInt2 == -1) {
        bool = true;
      } else {
        bool = false;
      }
      if (paramInt1 != 21)
      {
        if (paramInt1 != 102)
        {
          if (paramInt1 != 10001) {
            return;
          }
          ShareReport.a.a(bool);
          a(bool);
          return;
        }
        b(this.g, this.m, this.t, paramIntent, 0, -1, false, bool);
        return;
      }
      b(this.g, this.m, this.t, paramIntent, 1, -1, false, bool);
      a(bool);
    }
  }
  
  public void a(IColorNoteController paramIColorNoteController)
  {
    this.w = paramIColorNoteController;
  }
  
  @TargetApi(11)
  void a(MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramMessageForShortVideo == null) {
      return;
    }
    String str1 = this.g.getResources().getString(2131916650);
    String str2 = this.g.getResources().getString(2131916610);
    String str3 = this.g.getResources().getString(2131916651);
    String str4 = this.g.getResources().getString(2131916629);
    String str5 = this.g.getResources().getString(2131887648);
    String str6 = SVUtils.a(paramMessageForShortVideo, "mp4");
    Object localObject = new File(str6);
    long l1 = ((File)localObject).length();
    boolean bool;
    if ((((File)localObject).exists()) && (l1 >= paramMessageForShortVideo.videoFileSize)) {
      bool = true;
    } else {
      bool = false;
    }
    if (ImmersiveUtils.isSupporImmersive() == -1) {
      localObject = ActionSheet.createFullScreenDialog(this.g);
    } else {
      localObject = ActionSheet.create(this.g);
    }
    ((ActionSheet)localObject).addButton(str1);
    ((ActionSheet)localObject).setOnDismissListener(new VideoFeedsShareController.1(this));
    if (paramMessageForShortVideo.videoFileStatus != 5001) {
      ((ActionSheet)localObject).addButton(str3);
    }
    if (bool)
    {
      ((ActionSheet)localObject).addButton(str2);
      ((ActionSheet)localObject).addButton(str4);
    }
    else
    {
      ((ActionSheet)localObject).addButton(str2, 7);
      ((ActionSheet)localObject).addButton(str4, 7);
    }
    ((ActionSheet)localObject).addCancelButton(str5);
    if (!((ActionSheet)localObject).isShowing())
    {
      if ((VersionUtils.g()) && (!ShortVideoUtils.isInFullScreenBlackList()))
      {
        ((ActionSheet)localObject).getWindow().setFlags(8, 8);
        if (VersionUtils.g()) {
          ((ActionSheet)localObject).getWindow().getDecorView().setSystemUiVisibility(this.g.getWindow().getDecorView().getSystemUiVisibility());
        }
        ((ActionSheet)localObject).setOnShowListener(new VideoFeedsShareController.2(this, (ActionSheet)localObject));
      }
      ((ActionSheet)localObject).show();
    }
    ((ActionSheet)localObject).setOnButtonClickListener(new VideoFeedsShareController.3(this, (ActionSheet)localObject, str1, paramMessageForShortVideo, str3, bool, str6, str2, str4));
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    this.d = paramVideoInfo;
  }
  
  protected void a(VideoInfo paramVideoInfo, @NotNull String paramString1, int paramInt, String paramString2)
  {
    g(1);
    a(paramVideoInfo, this.g, (int)this.f.b(), paramString1, paramInt, paramString2);
    this.f.b(this.o);
  }
  
  protected void a(VideoInfo paramVideoInfo, String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    String str = "";
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (this.g != null) {
        localObject = GalleryReportedUtils.a(this.g);
      } else {
        localObject = Integer.valueOf(-1);
      }
      localJSONObject.put("network", localObject);
      localJSONObject.put("os", "1");
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.m);
      ((StringBuilder)localObject).append("");
      localJSONObject.put("source", ((StringBuilder)localObject).toString());
      localJSONObject.put("uin", paramString1);
      localJSONObject.put("rowkey", paramVideoInfo.aB.innerUniqueID);
      localJSONObject.put("version", VideoReporter.a);
      localJSONObject.put("vid", paramString3);
      if (paramBoolean) {
        localJSONObject.put("cancel", String.valueOf(1));
      }
      if (paramInt1 >= 0)
      {
        paramVideoInfo = new StringBuilder();
        paramVideoInfo.append(paramInt1);
        paramVideoInfo.append("");
        localJSONObject.put("sourcefrom", paramVideoInfo.toString());
      }
      if (paramInt2 >= 0)
      {
        paramVideoInfo = new StringBuilder();
        paramVideoInfo.append(paramInt2);
        paramVideoInfo.append("");
        localJSONObject.put("share_unit", paramVideoInfo.toString());
      }
      localJSONObject.put("show", this.t);
      localJSONObject.put("type", 1);
      paramVideoInfo = localJSONObject.toString();
    }
    catch (Exception paramString1)
    {
      paramVideoInfo = str;
      if (QLog.isColorLevel())
      {
        paramVideoInfo = new StringBuilder();
        paramVideoInfo.append("shareReport:");
        paramVideoInfo.append(paramString1.toString());
        QLog.d("VideoFeedsShareController", 2, paramVideoInfo.toString());
        paramVideoInfo = str;
      }
    }
    paramVideoInfo = new VideoR5.Builder(paramVideoInfo);
    PublicAccountReportUtils.a(null, "", "0X8009546", "0X8009546", 0, 0, "", String.valueOf(paramString2), String.valueOf(paramLong), paramVideoInfo.b().a(), false);
  }
  
  protected void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, String paramString6, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      int i1 = this.m;
      if ((i1 == 9) || (i1 == 12))
      {
        str = "0X800929A";
        break label38;
      }
    }
    String str = "0X800740F";
    label38:
    paramString4 = new VideoR5.Builder(paramString4, paramString1, paramString5, paramString3).a(this.f.b()).c(paramInt1 * 1000);
    if (!paramBoolean) {
      paramString4.e(paramLong).c(paramInt2).g(paramInt4).b(paramString6);
    }
    paramString4.a(paramInt3).M(this.v);
    if (TextUtils.isEmpty(paramString3)) {
      paramString3 = "0";
    }
    PublicAccountReportUtils.a(null, paramString1, str, str, 0, 0, "0", paramString2, paramString3, paramString4.b().a(), false);
  }
  
  protected boolean a(int paramInt)
  {
    if ((b.contains(Integer.valueOf(paramInt))) && (paramInt != 2) && (paramInt != 3) && (paramInt != 72)) {
      a(true);
    }
    return true;
  }
  
  public boolean a(int paramInt, @NotNull ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (this.d == null) {
      return false;
    }
    if (!a(paramInt)) {
      return false;
    }
    f(paramInt);
    VideoInfo localVideoInfo = this.d;
    Object localObject = this.q;
    if (localObject != null) {
      ((VideoFeedsShareController.ShareSheetActionListener)localObject).a(paramInt, localVideoInfo);
    }
    localObject = d(localVideoInfo);
    ShareAction localShareAction = d(paramInt);
    if (localShareAction == null) {
      return false;
    }
    int i1 = localShareAction.c();
    int i2 = localShareAction.a();
    int i3 = localShareAction.b();
    localShareAction.a(paramInt, localVideoInfo, (String)localObject, paramActionSheetItem);
    a(paramInt, localVideoInfo);
    localObject = localVideoInfo.l();
    paramInt = a();
    if (localVideoInfo.ao != null) {
      paramActionSheetItem = localVideoInfo.ao;
    } else {
      paramActionSheetItem = "";
    }
    a(localVideoInfo.q, Integer.toString(i3), localVideoInfo.l, (String)localObject, localVideoInfo.b, localVideoInfo.k(), localVideoInfo.ah, localVideoInfo.ai, -1, paramInt, paramActionSheetItem, false);
    a(localVideoInfo, String.valueOf(b()), localVideoInfo.l, localVideoInfo.b, localVideoInfo.ah, i1, i2, false);
    return true;
  }
  
  protected long b()
  {
    return RIJQQAppInterfaceUtil.c();
  }
  
  @TargetApi(11)
  public void b(int paramInt)
  {
    if (this.a == null) {
      this.a = new ReadInJoyShareHelperV2(this.g, this.l, new VideoFeedsShareController.SheetItemClickProcessor(this));
    }
    this.a.a().setActionSheetTitle("biu出去让更多好友看到");
    this.a.a().setCancelListener(new VideoFeedsShareController.4(this));
    this.a.a().setOnDismissListener(new VideoFeedsShareController.5(this));
    for (;;)
    {
      try
      {
        if (!this.a.a().isShowing())
        {
          if ((VersionUtils.g()) && (!ShortVideoUtils.isInFullScreenBlackList())) {
            this.a.a().setOnShowListener(new VideoFeedsShareController.6(this));
          }
          this.a.a().setEnableNotTriggerVirtualNavigationBar(true);
          if (!ReadInJoyHelper.b()) {
            break label262;
          }
          if (paramInt != 2) {
            break label257;
          }
          i1 = 19;
          d(this.d);
          localObject = this.a;
          List[] arrayOfList = c(paramInt);
          if (this.d == null) {
            break label279;
          }
          String str1 = this.d.l;
          ((ReadInJoyShareHelperV2)localObject).a(arrayOfList, i1, str1);
          h();
          return;
        }
      }
      catch (Exception localException)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("actionSheet.show exception=");
        ((StringBuilder)localObject).append(localException);
        b(((StringBuilder)localObject).toString());
      }
      return;
      label257:
      int i1 = 3;
      continue;
      label262:
      if (paramInt == 2)
      {
        i1 = 21;
      }
      else
      {
        i1 = 20;
        continue;
        label279:
        String str2 = "";
      }
    }
  }
  
  public void b(VideoInfo paramVideoInfo)
  {
    this.e = paramVideoInfo;
  }
  
  public void c()
  {
    this.r = true;
  }
  
  protected void c(VideoInfo paramVideoInfo)
  {
    a(paramVideoInfo, "", 0, "");
  }
  
  public List<Integer>[] c(int paramInt)
  {
    List localList = ReadInJoyShareHelperV2.i();
    if ((!RIJSocialBottomViewAladdinConfig.d()) && (paramInt == 2)) {
      return new List[] { localList };
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.w;
    if ((localObject != null) && (((IColorNoteController)localObject).shouldDisplayColorNote())) {
      if (this.w.isColorNoteExist())
      {
        localArrayList.add(0, Integer.valueOf(82));
        QLog.d("VideoFeedsShareController", 2, "mColorNoteController ： open sheet delete colorNote");
      }
      else
      {
        localArrayList.add(0, Integer.valueOf(70));
        QLog.d("VideoFeedsShareController", 2, "mColorNoteController ： open sheet add colorNote");
      }
    }
    localObject = this.d;
    if ((localObject == null) || (!RIJUgcUtils.a(this.l, ((VideoInfo)localObject).aa))) {
      localArrayList.add(Integer.valueOf(6));
    }
    localArrayList.add(Integer.valueOf(165));
    localArrayList.add(Integer.valueOf(1));
    localObject = this.d;
    if ((localObject != null) && (((VideoInfo)localObject).ax != null) && (((VideoInfo)localObject).ax.size() > 0)) {
      localArrayList.add(Integer.valueOf(44));
    }
    localArrayList.add(Integer.valueOf(11));
    localArrayList.add(Integer.valueOf(161));
    return new List[] { localList, localArrayList };
  }
  
  protected ShareAction d(int paramInt)
  {
    return (ShareAction)this.y.get(paramInt);
  }
  
  public void d()
  {
    this.r = false;
  }
  
  public void e()
  {
    ReadInJoyShareHelperV2 localReadInJoyShareHelperV2 = this.a;
    if (localReadInJoyShareHelperV2 != null) {
      localReadInJoyShareHelperV2.c();
    }
    ReadInJoyLogicEngineEventDispatcher.a().b(this.x);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsShareController
 * JD-Core Version:    0.7.0.1
 */