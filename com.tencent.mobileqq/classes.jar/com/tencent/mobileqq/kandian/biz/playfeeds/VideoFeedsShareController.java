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
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdInfo;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdInfo.NegFeedback;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.dislike.ReadInJoyDisLikeDialogView;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
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
  private static HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static final HashSet<Integer> jdField_a_of_type_JavaUtilHashSet = new HashSet(Arrays.asList(new Integer[] { Integer.valueOf(9), Integer.valueOf(10), Integer.valueOf(12), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(72) }));
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  private SparseArray<ShareAction> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private EncryptUinHandler jdField_a_of_type_ComTencentBizPubaccountEncryptUinHandler;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable = null;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IColorNoteController jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
  private VideoFeedsPlayManager jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager;
  private VideoFeedsShareController.RIJObserver jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareController$RIJObserver;
  private VideoFeedsShareController.ShareSheetActionListener jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareController$ShareSheetActionListener;
  ReadInJoyShareHelperV2 jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInJoyShareHelperV2;
  private VideoInfo jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new VideoFeedsShareController.ShortVideoMqqHandler(this, null);
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private VideoInfo jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean = false;
  private boolean d = true;
  private boolean e = false;
  
  public VideoFeedsShareController(Activity paramActivity, QQAppInterface paramQQAppInterface, VideoFeedsPlayManager paramVideoFeedsPlayManager, int paramInt1, boolean paramBoolean, VideoFeedsShareController.ShareSheetActionListener paramShareSheetActionListener, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager = paramVideoFeedsPlayManager;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareController$ShareSheetActionListener = paramShareSheetActionListener;
    this.e = paramBoolean;
    this.jdField_a_of_type_ComTencentBizPubaccountEncryptUinHandler = ((EncryptUinHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.ENCRYPT_UIN_HANDLER));
    paramActivity = this.jdField_a_of_type_ComTencentBizPubaccountEncryptUinHandler;
    if (paramActivity != null) {
      paramActivity.a();
    }
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareController$RIJObserver = new VideoFeedsShareController.RIJObserver(this, null);
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareController$RIJObserver);
    d();
  }
  
  @NotNull
  private String a(VideoInfo paramVideoInfo)
  {
    String str = "";
    if (paramVideoInfo == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    EncryptUinHandler localEncryptUinHandler = this.jdField_a_of_type_ComTencentBizPubaccountEncryptUinHandler;
    if (localEncryptUinHandler != null) {
      str = localEncryptUinHandler.a();
    }
    if (!TextUtils.isEmpty(paramVideoInfo.jdField_f_of_type_JavaLangString))
    {
      localStringBuilder.append(paramVideoInfo.jdField_f_of_type_JavaLangString);
      if (!TextUtils.isEmpty(str))
      {
        localStringBuilder.append("&iid=");
        localStringBuilder.append(str);
      }
      localStringBuilder.append("&rowkey=");
      localStringBuilder.append(paramVideoInfo.g);
    }
    return localStringBuilder.toString();
  }
  
  private void a(int paramInt, VideoInfo paramVideoInfo)
  {
    if ((paramInt != 1) && (paramInt != 11) && (paramInt != 6) && (!this.e))
    {
      ReportInfo.VideoExtraRepoerData localVideoExtraRepoerData = new ReportInfo.VideoExtraRepoerData();
      localVideoExtraRepoerData.d = ((int)this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager.a());
      localVideoExtraRepoerData.e = (paramVideoInfo.c() * 1000);
      paramVideoInfo = this.jdField_a_of_type_AndroidAppActivity;
      if (paramVideoInfo != null)
      {
        localVideoExtraRepoerData.jdField_b_of_type_Int = paramVideoInfo.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
        paramInt = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);
      }
      else
      {
        paramInt = -1;
      }
      if (this.jdField_c_of_type_Int == 1)
      {
        localVideoInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
        paramVideoInfo = this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
        if (paramVideoInfo != null) {
          paramVideoInfo = paramVideoInfo.g;
        } else {
          paramVideoInfo = null;
        }
        VideoReporter.a(localVideoInfo, paramInt, 26, -1, localVideoExtraRepoerData, paramVideoInfo);
        return;
      }
      VideoInfo localVideoInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
      paramVideoInfo = this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
      if (paramVideoInfo != null) {
        paramVideoInfo = paramVideoInfo.g;
      } else {
        paramVideoInfo = null;
      }
      VideoReporter.b(localVideoInfo, paramInt, 26, -1, localVideoExtraRepoerData, paramVideoInfo);
    }
  }
  
  private void a(int paramInt1, VideoInfo paramVideoInfo, String paramString, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager.b(this.jdField_b_of_type_Boolean);
    boolean bool1;
    if (!TextUtils.isEmpty(paramVideoInfo.v))
    {
      paramString = paramVideoInfo.v;
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
    if (paramVideoInfo.n != null)
    {
      localObject1 = paramString;
      if (paramVideoInfo.n.contains("kandianshare.html5.qq.com")) {
        localObject1 = paramVideoInfo.n;
      }
    }
    Object localObject2 = new StringBuilder();
    if (paramVideoInfo.q > 0)
    {
      ((StringBuilder)localObject2).append(VideoFeedsHelper.b(paramVideoInfo.q));
      ((StringBuilder)localObject2).append(" ");
    }
    paramString = (BaseActivity)this.jdField_a_of_type_AndroidAppActivity;
    String str = paramVideoInfo.c;
    localObject2 = ((StringBuilder)localObject2).toString();
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    boolean bool2;
    if (paramInt1 == 9) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    VideoShareUtils.a(paramString, str, (String)localObject2, (String)localObject1, localBitmap, bool2, paramVideoInfo.g, bool1, new VideoFeedsShareController.WeChatShareResultCallback(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramInt2, paramInt3, paramVideoInfo));
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
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsShareController", 2, paramString);
    }
  }
  
  /* Error */
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 346
    //   4: invokespecial 284	com/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsShareController:a	(Ljava/lang/String;)V
    //   7: aload_0
    //   8: getfield 93	com/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsShareController:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   11: astore_2
    //   12: bipush 9
    //   14: anewarray 246	java/lang/String
    //   17: astore 6
    //   19: aload 6
    //   21: iconst_0
    //   22: ldc_w 347
    //   25: invokestatic 351	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   28: aastore
    //   29: aload 6
    //   31: iconst_1
    //   32: ldc_w 352
    //   35: invokestatic 351	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   38: aastore
    //   39: aload 6
    //   41: iconst_2
    //   42: ldc_w 353
    //   45: invokestatic 351	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   48: aastore
    //   49: aload 6
    //   51: iconst_3
    //   52: ldc_w 354
    //   55: invokestatic 351	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   58: aastore
    //   59: aload 6
    //   61: iconst_4
    //   62: ldc_w 355
    //   65: invokestatic 351	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   68: aastore
    //   69: aload 6
    //   71: iconst_5
    //   72: ldc_w 356
    //   75: invokestatic 351	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   78: aastore
    //   79: aload 6
    //   81: bipush 6
    //   83: ldc_w 357
    //   86: invokestatic 351	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   89: aastore
    //   90: aload 6
    //   92: bipush 7
    //   94: ldc_w 358
    //   97: invokestatic 351	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   100: aastore
    //   101: aload 6
    //   103: bipush 8
    //   105: ldc_w 359
    //   108: invokestatic 351	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   111: aastore
    //   112: aload 6
    //   114: new 361	java/util/Random
    //   117: dup
    //   118: invokespecial 362	java/util/Random:<init>	()V
    //   121: aload 6
    //   123: arraylength
    //   124: invokevirtual 366	java/util/Random:nextInt	(I)I
    //   127: aaload
    //   128: astore 6
    //   130: new 154	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   137: astore 7
    //   139: aload 7
    //   141: ldc_w 368
    //   144: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload 7
    //   150: aload 6
    //   152: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload 7
    //   158: ldc_w 370
    //   161: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload 7
    //   167: aload_1
    //   168: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload 7
    //   174: ldc_w 372
    //   177: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload 7
    //   183: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: astore_1
    //   187: aload_1
    //   188: invokestatic 169	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   191: ifne +311 -> 502
    //   194: aload_3
    //   195: invokestatic 169	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   198: ifeq +6 -> 204
    //   201: goto +301 -> 502
    //   204: aload_0
    //   205: getfield 91	com/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsShareController:jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager	Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsPlayManager;
    //   208: aload_0
    //   209: getfield 76	com/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsShareController:jdField_b_of_type_Boolean	Z
    //   212: invokevirtual 232	com/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsPlayManager:b	(Z)V
    //   215: aload_0
    //   216: ldc_w 374
    //   219: invokespecial 284	com/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsShareController:a	(Ljava/lang/String;)V
    //   222: aload_1
    //   223: ldc_w 376
    //   226: invokestatic 382	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   229: astore_1
    //   230: new 154	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   237: astore 6
    //   239: aload 6
    //   241: ldc_w 384
    //   244: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: aload 6
    //   250: ldc_w 386
    //   253: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: aload 6
    //   259: aload_1
    //   260: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: aload 6
    //   266: ldc_w 388
    //   269: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: aload 6
    //   275: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: astore_1
    //   279: aload_3
    //   280: ldc_w 376
    //   283: invokestatic 382	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   286: astore_3
    //   287: new 154	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   294: astore 6
    //   296: aload 6
    //   298: aload_1
    //   299: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: pop
    //   303: aload 6
    //   305: ldc_w 390
    //   308: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: pop
    //   312: aload 6
    //   314: aload_3
    //   315: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: aload 6
    //   321: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: astore_1
    //   325: aload 4
    //   327: ldc_w 376
    //   330: invokestatic 382	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   333: astore_3
    //   334: new 154	java/lang/StringBuilder
    //   337: dup
    //   338: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   341: astore 4
    //   343: aload 4
    //   345: aload_1
    //   346: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: pop
    //   350: aload 4
    //   352: ldc_w 392
    //   355: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: pop
    //   359: aload 4
    //   361: aload_3
    //   362: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: pop
    //   366: aload 4
    //   368: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   371: astore_1
    //   372: new 154	java/lang/StringBuilder
    //   375: dup
    //   376: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   379: astore_3
    //   380: aload_3
    //   381: aload_1
    //   382: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: pop
    //   386: aload_3
    //   387: ldc_w 394
    //   390: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: pop
    //   394: aload_3
    //   395: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   398: astore_1
    //   399: new 211	android/content/Intent
    //   402: dup
    //   403: aload_2
    //   404: ldc_w 396
    //   407: invokespecial 399	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   410: astore_3
    //   411: aload_3
    //   412: ldc_w 401
    //   415: aload_1
    //   416: invokevirtual 318	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   419: pop
    //   420: aload_0
    //   421: getfield 82	com/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsShareController:e	Z
    //   424: ifeq +115 -> 539
    //   427: ldc_w 402
    //   430: istore 5
    //   432: goto +3 -> 435
    //   435: aload_3
    //   436: ldc_w 404
    //   439: iload 5
    //   441: invokestatic 407	com/tencent/mobileqq/kandian/glue/router/RIJJumpUtils:a	(I)Ljava/lang/String;
    //   444: invokevirtual 318	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   447: pop
    //   448: aload_2
    //   449: aload_3
    //   450: invokevirtual 411	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   453: aload_0
    //   454: ldc_w 413
    //   457: invokespecial 284	com/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsShareController:a	(Ljava/lang/String;)V
    //   460: return
    //   461: astore_1
    //   462: goto +38 -> 500
    //   465: astore_1
    //   466: aload_0
    //   467: getfield 93	com/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsShareController:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   470: iconst_0
    //   471: ldc_w 414
    //   474: iconst_0
    //   475: invokestatic 419	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;III)Lcom/tencent/mobileqq/widget/QQToast;
    //   478: aload_0
    //   479: getfield 93	com/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsShareController:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   482: invokevirtual 423	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   485: ldc_w 424
    //   488: invokevirtual 429	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   491: invokevirtual 432	com/tencent/mobileqq/widget/QQToast:b	(I)Landroid/widget/Toast;
    //   494: pop
    //   495: aload_1
    //   496: invokevirtual 435	java/lang/Exception:printStackTrace	()V
    //   499: return
    //   500: aload_1
    //   501: athrow
    //   502: aload_0
    //   503: ldc_w 437
    //   506: invokespecial 284	com/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsShareController:a	(Ljava/lang/String;)V
    //   509: aload_0
    //   510: getfield 93	com/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsShareController:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   513: iconst_0
    //   514: ldc_w 414
    //   517: iconst_0
    //   518: invokestatic 419	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;III)Lcom/tencent/mobileqq/widget/QQToast;
    //   521: aload_0
    //   522: getfield 93	com/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsShareController:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   525: invokevirtual 423	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   528: ldc_w 424
    //   531: invokevirtual 429	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   534: invokevirtual 432	com/tencent/mobileqq/widget/QQToast:b	(I)Landroid/widget/Toast;
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
    //   430	111	5	i	int
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
    ReadInJoyLogicEngine.a().o();
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = jdField_a_of_type_JavaUtilHashMap.containsKey(paramString);
    boolean bool1 = true;
    if (bool2)
    {
      if (((Integer)jdField_a_of_type_JavaUtilHashMap.get(paramString)).intValue() == 0) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  public static int b()
  {
    return ((Integer)RIJSPUtils.a("CONFIG_LAST_SHARE_ACTION", Integer.valueOf(1))).intValue();
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
        localJSONObject.put("uin", paramVideoInfo.j);
        localJSONObject.put("rowkey", paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID);
        localJSONObject.put("version", VideoReporter.jdField_a_of_type_JavaLangString);
        localJSONObject.put("vid", paramVideoInfo.jdField_a_of_type_JavaLangString);
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
          break label376;
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
          break label309;
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
      label309:
      paramContext = new VideoR5.Builder(paramContext);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800979D", "0X800979D", 0, 0, "", String.valueOf(paramVideoInfo.g), String.valueOf(paramVideoInfo.jdField_f_of_type_Long), paramContext.a().a(), false);
      ShareReport.a.a(paramBoolean2);
      return;
      label376:
      if (paramBoolean2) {
        paramInt1 = 0;
      }
    }
  }
  
  private void c(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 6) && (paramInt != 26) && (paramInt != 82)) {
      return;
    }
    VideoFeedsPlayManager localVideoFeedsPlayManager = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager;
    if (localVideoFeedsPlayManager != null) {
      localVideoFeedsPlayManager.c();
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.put(13, new VideoFeedsShareController.SendToReadInJoyShareAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1, new VideoFeedsShareController.CopyLinkAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(11, new VideoFeedsShareController.ReportAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(72, new VideoFeedsShareController.SendToSpecialFriendShareAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(2, new VideoFeedsShareController.SendToFriendShareAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(73, new VideoFeedsShareController.SendToFriendShareAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(5, new VideoFeedsShareController.OpenInQQBrowserShareAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(4, new VideoFeedsShareController.OpenInSysBrowserShareAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(3, new VideoFeedsShareController.SendToQzoneShareAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(6, new VideoFeedsShareController.AddFavoriteAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(9, new VideoFeedsShareController.SendToWeChatShareAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(10, new VideoFeedsShareController.SendToWeChatCircleShareAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(12, new VideoFeedsShareController.SendToSinaShareAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(44, new VideoFeedsShareController.ReportDislikeAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(26, new VideoFeedsShareController.SendToPcAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(161, new VideoFeedsShareController.ReportVideoPlayFeedbackAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(134, new VideoFeedsShareController.AddVideoToTopic(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(70, new VideoFeedsShareController.AddColorNoteAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(82, new VideoFeedsShareController.RemoveColorNoteAction(this));
  }
  
  private static void d(int paramInt)
  {
    RIJSPUtils.a("CONFIG_LAST_SHARE_ACTION", Integer.valueOf(paramInt));
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo == null) {
      return;
    }
    try
    {
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      int i = VideoFeedsHelper.b(this.jdField_a_of_type_AndroidAppActivity)[0];
      int j = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.b(this.jdField_a_of_type_AndroidAppActivity);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = i;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = j;
      this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      localObject = this.jdField_a_of_type_ComTencentImageURLDrawable;
      if ((localObject != null) && (((URLDrawable)localObject).getStatus() == 1) && ((this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable() instanceof RegionDrawable)))
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap = ((RegionDrawable)this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable()).getBitmap();
        return;
      }
      localObject = this.jdField_a_of_type_ComTencentImageURLDrawable;
      if (localObject != null)
      {
        ((URLDrawable)localObject).setURLDrawableListener(new VideoFeedsShareController.7(this));
        this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
      }
      return;
    }
    catch (Exception localException)
    {
      label146:
      break label146;
    }
    a("initVideoThumbBitmap() URLDrawable.getDrawable ERROR, RETURN");
  }
  
  private void f()
  {
    VideoInfo localVideoInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidAppActivity, null));
    Object localObject = new VideoFeedsShareController.8(this);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.registerWatchDisMissActionListener((ActionSheet.WatchDismissActions)localObject);
    localObject = ((IRIJAdService)QRoute.api(IRIJAdService.class)).createReadInJoyDisLikeDialogViewForAd(this.jdField_a_of_type_AndroidAppActivity);
    ((ReadInJoyDisLikeDialogView)localObject).setOnUninterestConfirmListener(new VideoFeedsShareController.9(this, localVideoInfo));
    ((ReadInJoyDisLikeDialogView)localObject).setOnComplainListener(new VideoFeedsShareController.10(this, localVideoInfo));
    ArrayList localArrayList = new ArrayList();
    if ((localVideoInfo != null) && (localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo != null) && (localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo.e.size() > 0))
    {
      Iterator localIterator = localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo.e.iterator();
      while (localIterator.hasNext())
      {
        VideoAdInfo.NegFeedback localNegFeedback = (VideoAdInfo.NegFeedback)localIterator.next();
        DislikeInfo localDislikeInfo = new DislikeInfo();
        localDislikeInfo.jdField_a_of_type_JavaLangString = localNegFeedback.jdField_a_of_type_JavaLangString;
        localDislikeInfo.jdField_a_of_type_Long = ((int)localNegFeedback.jdField_a_of_type_Long);
        if (TextUtils.isEmpty(localVideoInfo.j)) {
          localDislikeInfo.jdField_b_of_type_JavaLangString = "";
        } else {
          localDislikeInfo.jdField_b_of_type_JavaLangString = localVideoInfo.j;
        }
        localArrayList.add(localDislikeInfo);
      }
    }
    if (localArrayList.size() == 0) {
      return;
    }
    ((ReadInJoyDisLikeDialogView)localObject).setUninterestData(localArrayList);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setActionContentView((View)localObject, null);
    try
    {
      if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())
      {
        if ((VersionUtils.g()) && (!ShortVideoUtils.isInFullScreenBlackList()))
        {
          this.jdField_a_of_type_ComTencentWidgetActionSheet.getWindow().setFlags(8, 8);
          this.jdField_a_of_type_ComTencentWidgetActionSheet.getWindow().getDecorView().setSystemUiVisibility(this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getSystemUiVisibility());
          this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnShowListener(new VideoFeedsShareController.11(this));
        }
        this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
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
    Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
    int j = 0;
    int i = j;
    if (localActivity != null)
    {
      i = j;
      if (localActivity.getIntent() != null) {
        i = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
      }
    }
    return i;
  }
  
  protected long a()
  {
    return ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin();
  }
  
  protected ShareAction a(int paramInt)
  {
    return (ShareAction)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public void a()
  {
    this.d = true;
  }
  
  @TargetApi(11)
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInJoyShareHelperV2 == null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInJoyShareHelperV2 = new ReadInJoyShareHelperV2(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new VideoFeedsShareController.SheetItemClickProcessor(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInJoyShareHelperV2.a().setActionSheetTitle("biu出去让更多好友看到");
    this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInJoyShareHelperV2.a().setCancelListener(new VideoFeedsShareController.4(this));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInJoyShareHelperV2.a().setOnDismissListener(new VideoFeedsShareController.5(this));
    for (;;)
    {
      try
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInJoyShareHelperV2.a().isShowing())
        {
          if ((VersionUtils.g()) && (!ShortVideoUtils.isInFullScreenBlackList())) {
            this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInJoyShareHelperV2.a().setOnShowListener(new VideoFeedsShareController.6(this));
          }
          this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInJoyShareHelperV2.a().setEnableNotTriggerVirtualNavigationBar(true);
          if (!ReadInJoyHelper.b()) {
            break label262;
          }
          if (paramInt != 2) {
            break label257;
          }
          i = 19;
          a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo);
          localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInJoyShareHelperV2;
          List[] arrayOfList = a(paramInt);
          if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo == null) {
            break label279;
          }
          String str1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.g;
          ((ReadInJoyShareHelperV2)localObject).a(arrayOfList, i, str1);
          e();
          return;
        }
      }
      catch (Exception localException)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("actionSheet.show exception=");
        ((StringBuilder)localObject).append(localException);
        a(((StringBuilder)localObject).toString());
      }
      return;
      label257:
      int i = 3;
      continue;
      label262:
      if (paramInt == 2)
      {
        i = 21;
      }
      else
      {
        i = 20;
        continue;
        label279:
        String str2 = "";
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    a("doOnShareButtonPressed()");
    this.jdField_b_of_type_Int = paramInt1;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
    if ((localObject != null) && (((VideoInfo)localObject).jdField_a_of_type_Int == 0))
    {
      a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
      if ((localObject != null) && (((VideoInfo)localObject).r) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.t == 1) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.b(this.jdField_a_of_type_AndroidAppActivity))) {
        f();
      } else {
        a(paramInt2);
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareController$ShareSheetActionListener;
    if (localObject != null) {
      ((VideoFeedsShareController.ShareSheetActionListener)localObject).f();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager;
    if ((localObject != null) && (((VideoFeedsPlayManager)localObject).d()))
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager.b();
      return;
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    paramIntent = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
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
        b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramIntent, 0, -1, false, bool);
        return;
      }
      b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramIntent, 1, -1, false, bool);
      a(bool);
    }
  }
  
  public void a(IColorNoteController paramIColorNoteController)
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController = paramIColorNoteController;
  }
  
  @TargetApi(11)
  void a(MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramMessageForShortVideo == null) {
      return;
    }
    String str1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131719114);
    String str2 = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131719074);
    String str3 = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131719115);
    String str4 = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131719093);
    String str5 = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131690728);
    String str6 = SVUtils.a(paramMessageForShortVideo, "mp4");
    Object localObject = new File(str6);
    long l = ((File)localObject).length();
    boolean bool;
    if ((((File)localObject).exists()) && (l >= paramMessageForShortVideo.videoFileSize)) {
      bool = true;
    } else {
      bool = false;
    }
    if (ImmersiveUtils.isSupporImmersive() == -1) {
      localObject = ActionSheet.createFullScreenDialog(this.jdField_a_of_type_AndroidAppActivity);
    } else {
      localObject = ActionSheet.create(this.jdField_a_of_type_AndroidAppActivity);
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
          ((ActionSheet)localObject).getWindow().getDecorView().setSystemUiVisibility(this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getSystemUiVisibility());
        }
        ((ActionSheet)localObject).setOnShowListener(new VideoFeedsShareController.2(this, (ActionSheet)localObject));
      }
      ((ActionSheet)localObject).show();
    }
    ((ActionSheet)localObject).setOnButtonClickListener(new VideoFeedsShareController.3(this, (ActionSheet)localObject, str1, paramMessageForShortVideo, str3, bool, str6, str2, str4));
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo = paramVideoInfo;
  }
  
  protected void a(VideoInfo paramVideoInfo, @NotNull String paramString1, int paramInt, String paramString2)
  {
    d(1);
    a(paramVideoInfo, this.jdField_a_of_type_AndroidAppActivity, (int)this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager.a(), paramString1, paramInt, paramString2);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager.b(this.jdField_b_of_type_Boolean);
  }
  
  protected void a(VideoInfo paramVideoInfo, String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    String str = "";
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (this.jdField_a_of_type_AndroidAppActivity != null) {
        localObject = GalleryReportedUtils.a(this.jdField_a_of_type_AndroidAppActivity);
      } else {
        localObject = Integer.valueOf(-1);
      }
      localJSONObject.put("network", localObject);
      localJSONObject.put("os", "1");
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append("");
      localJSONObject.put("source", ((StringBuilder)localObject).toString());
      localJSONObject.put("uin", paramString1);
      localJSONObject.put("rowkey", paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID);
      localJSONObject.put("version", VideoReporter.jdField_a_of_type_JavaLangString);
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
      localJSONObject.put("show", this.jdField_b_of_type_Int);
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
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009546", "0X8009546", 0, 0, "", String.valueOf(paramString2), String.valueOf(paramLong), paramVideoInfo.a().a(), false);
  }
  
  protected void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, String paramString6, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      int i = this.jdField_a_of_type_Int;
      if ((i == 9) || (i == 12))
      {
        str1 = "0X800929A";
        break label38;
      }
    }
    String str1 = "0X800740F";
    label38:
    String str2 = paramString3;
    paramString4 = new VideoR5.Builder(paramString4, paramString1, paramString5, str2).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager.a()).c(paramInt1 * 1000);
    if (!paramBoolean) {
      paramString4.e(paramLong).c(paramInt2).g(paramInt4).a(paramString6);
    }
    paramString4.a(paramInt3).M(this.jdField_c_of_type_Int);
    paramString5 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    if (TextUtils.isEmpty(paramString3)) {
      str2 = "0";
    }
    paramString5.publicAccountReportClickEvent(null, paramString1, str1, str1, 0, 0, "0", paramString2, str2, paramString4.a().a(), false);
  }
  
  protected boolean a(int paramInt)
  {
    if ((jdField_a_of_type_JavaUtilHashSet.contains(Integer.valueOf(paramInt))) && (paramInt != 2) && (paramInt != 3) && (paramInt != 72)) {
      a(true);
    }
    return true;
  }
  
  public boolean a(int paramInt, @NotNull ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo == null) {
      return false;
    }
    if (!a(paramInt)) {
      return false;
    }
    c(paramInt);
    VideoInfo localVideoInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareController$ShareSheetActionListener;
    if (localObject != null) {
      ((VideoFeedsShareController.ShareSheetActionListener)localObject).a(paramInt, localVideoInfo);
    }
    localObject = a(localVideoInfo);
    ShareAction localShareAction = a(paramInt);
    if (localShareAction == null) {
      return false;
    }
    int i = localShareAction.c();
    int j = localShareAction.a();
    int k = localShareAction.b();
    localShareAction.a(paramInt, localVideoInfo, (String)localObject, paramActionSheetItem);
    a(paramInt, localVideoInfo);
    localObject = localVideoInfo.d();
    paramInt = a();
    if (localVideoInfo.w != null) {
      paramActionSheetItem = localVideoInfo.w;
    } else {
      paramActionSheetItem = "";
    }
    a(localVideoInfo.j, Integer.toString(k), localVideoInfo.g, (String)localObject, localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.c(), localVideoInfo.jdField_f_of_type_Long, localVideoInfo.p, -1, paramInt, paramActionSheetItem, false);
    a(localVideoInfo, String.valueOf(a()), localVideoInfo.g, localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.jdField_f_of_type_Long, i, j, false);
    return true;
  }
  
  public List<Integer>[] a(int paramInt)
  {
    List localList = ReadInJoyShareHelperV2.a();
    if ((!RIJSocialBottomViewAladdinConfig.d()) && (paramInt == 2)) {
      return new List[] { localList };
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
    if ((localObject != null) && (((IColorNoteController)localObject).shouldDisplayColorNote())) {
      if (this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.isColorNoteExist())
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
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
    if ((localObject != null) && (RIJUgcUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((VideoInfo)localObject).k))) {
      localArrayList.add(Integer.valueOf(134));
    } else {
      localArrayList.add(Integer.valueOf(6));
    }
    localArrayList.add(Integer.valueOf(1));
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
    if ((localObject != null) && (((VideoInfo)localObject).jdField_b_of_type_JavaUtilArrayList != null) && (((VideoInfo)localObject).jdField_b_of_type_JavaUtilArrayList.size() > 0)) {
      localArrayList.add(Integer.valueOf(44));
    }
    localArrayList.add(Integer.valueOf(11));
    localArrayList.add(Integer.valueOf(161));
    return new List[] { localList, localArrayList };
  }
  
  public void b()
  {
    this.d = false;
  }
  
  public void b(VideoInfo paramVideoInfo)
  {
    this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo = paramVideoInfo;
  }
  
  public void c()
  {
    ReadInJoyShareHelperV2 localReadInJoyShareHelperV2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInJoyShareHelperV2;
    if (localReadInJoyShareHelperV2 != null) {
      localReadInJoyShareHelperV2.b();
    }
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareController$RIJObserver);
  }
  
  protected void c(VideoInfo paramVideoInfo)
  {
    a(paramVideoInfo, "", 0, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsShareController
 * JD-Core Version:    0.7.0.1
 */