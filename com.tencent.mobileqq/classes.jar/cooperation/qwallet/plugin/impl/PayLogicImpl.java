package cooperation.qwallet.plugin.impl;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.emosm.DataFactory.EmojiPayReqData;
import com.tencent.mobileqq.emosm.DataFactory.EmojiPayRespData;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qqpay.ui.R.drawable;
import com.tencent.mobileqq.qqpay.ui.R.id;
import com.tencent.mobileqq.qqpay.ui.R.layout;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qqpay.ui.R.style;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletPayApi;
import com.tencent.mobileqq.qwallet.IQWalletPayApi.PCPayData;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.IPayLogic;
import cooperation.qwallet.plugin.QWalletPayBridge;
import java.util.HashSet;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class PayLogicImpl
  implements IPayLogic
{
  static HashSet<String> allowView = new HashSet();
  private static boolean isPaying = false;
  private static SparseArray<PayLogicImpl> sPayLogics = new SparseArray();
  private BaseQQAppInterface app;
  private Intent intent;
  private Bundle intentData = null;
  private boolean isFromPCPush = false;
  protected boolean isLockWithdraw = false;
  protected boolean isPCPushDesc = false;
  private QBaseActivity mActivity;
  private DataFactory.EmojiPayReqData mEmojiPayReqData;
  public boolean mIsStartReport;
  private String mMidasAid;
  private String mMidasOfferid;
  private String mMidasOrderId;
  PayLogicImpl.OnActivityResult mOnActivityResult = null;
  private String mOpenViewTag;
  private String mPayAppId;
  private String mPayBargainorId;
  private String mPayChannel;
  protected long mPayH5StartTime;
  private String mPayTokenId;
  protected int mPayType = -1;
  public long mReportSeq;
  private int mRequestCode = -1;
  protected ResultReceiver mResultReceiver;
  private int saveResultCode = -1;
  private Intent saveResultData = null;
  
  static
  {
    allowView.add("resetPsw");
    allowView.add("bindNewCard");
    allowView.add("balance");
    allowView.add("pswManage");
    allowView.add("modifyPsw");
    allowView.add("checkPsw");
    allowView.add("withdraw");
    allowView.add("transferInfor");
    allowView.add("transfer");
    allowView.add("graphb");
    allowView.add("qpay_hb_share");
    allowView.add("sendHb");
    allowView.add("sendHbCallback");
    allowView.add("makeHongbao");
    allowView.add("parseqrcode");
    allowView.add("verifyqrcode");
    allowView.add("findPsw");
    allowView.add("pushMsg");
    allowView.add("transferPush");
    allowView.add("transferqrcode");
    allowView.add("transferInput");
    allowView.add("redgiftDetail");
    allowView.add("redgiftRecord");
    allowView.add("idCardVerify");
    allowView.add("payCode");
    allowView.add("showWearPayAuthor");
    allowView.add("rewardTransferInput");
    allowView.add("hbPackConfirm");
    allowView.add("qpayCert");
    allowView.add("qrcodeHb");
    allowView.add("qrcodeHbCallback");
    allowView.add("payByFriendConfirm");
    allowView.add("goldmsg_open");
    allowView.add("goldmsg_close");
    allowView.add("openEmbelUrl");
    allowView.add("showHbDetail");
  }
  
  private void OnEmojimallPayResult(DataFactory.EmojiPayReqData paramEmojiPayReqData, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString)
  {
    if (paramEmojiPayReqData == null)
    {
      end();
      return;
    }
    Intent localIntent = new Intent();
    paramString = new DataFactory.EmojiPayRespData(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramString);
    localIntent.putExtras(paramEmojiPayReqData.a());
    localIntent.putExtras(paramString.a());
    this.mActivity.setResult(-1, localIntent);
    saveNonePCPayResultData(-1, localIntent);
    end();
  }
  
  private static void add(PayLogicImpl paramPayLogicImpl)
  {
    if (paramPayLogicImpl != null) {
      sPayLogics.append(paramPayLogicImpl.getTag(), paramPayLogicImpl);
    }
  }
  
  /* Error */
  protected static Bundle buyGoods(AppInterface paramAppInterface, Activity paramActivity, ResultReceiver paramResultReceiver, String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2, String paramString3)
  {
    // Byte code:
    //   0: new 212	android/os/Bundle
    //   3: dup
    //   4: invokespecial 213	android/os/Bundle:<init>	()V
    //   7: astore 14
    //   9: new 215	org/json/JSONObject
    //   12: dup
    //   13: aload 4
    //   15: invokespecial 218	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   18: astore 25
    //   20: aload 25
    //   22: ldc 220
    //   24: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   27: astore 22
    //   29: ldc 226
    //   31: astore_0
    //   32: aload 25
    //   34: ldc 228
    //   36: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   39: astore 24
    //   41: aload 25
    //   43: ldc 230
    //   45: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   48: astore 23
    //   50: aload 25
    //   52: ldc 232
    //   54: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   57: istore 12
    //   59: iload 12
    //   61: ifeq +23 -> 84
    //   64: aload 25
    //   66: ldc 232
    //   68: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   71: astore 15
    //   73: goto +15 -> 88
    //   76: astore_2
    //   77: aload_0
    //   78: astore_1
    //   79: aload_2
    //   80: astore_0
    //   81: goto +860 -> 941
    //   84: ldc 238
    //   86: astore 15
    //   88: aload 25
    //   90: ldc 240
    //   92: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   95: istore 12
    //   97: iload 12
    //   99: ifeq +23 -> 122
    //   102: aload 25
    //   104: ldc 240
    //   106: invokevirtual 243	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   109: istore 12
    //   111: goto +14 -> 125
    //   114: astore_2
    //   115: aload_0
    //   116: astore_1
    //   117: aload_2
    //   118: astore_0
    //   119: goto +822 -> 941
    //   122: iconst_1
    //   123: istore 12
    //   125: aload 25
    //   127: ldc 245
    //   129: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   132: istore 13
    //   134: iload 13
    //   136: ifeq +15 -> 151
    //   139: aload 25
    //   141: ldc 245
    //   143: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   146: astore 17
    //   148: goto +6 -> 154
    //   151: aconst_null
    //   152: astore 17
    //   154: aload 25
    //   156: ldc 247
    //   158: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   161: istore 13
    //   163: ldc 249
    //   165: astore 21
    //   167: iload 13
    //   169: ifeq +15 -> 184
    //   172: aload 25
    //   174: ldc 247
    //   176: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   179: astore 16
    //   181: goto +7 -> 188
    //   184: ldc 249
    //   186: astore 16
    //   188: aload 25
    //   190: ldc 251
    //   192: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   195: istore 13
    //   197: iload 13
    //   199: ifeq +15 -> 214
    //   202: aload 25
    //   204: ldc 251
    //   206: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   209: astore 18
    //   211: goto +7 -> 218
    //   214: ldc 249
    //   216: astore 18
    //   218: aload 25
    //   220: ldc 253
    //   222: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   225: istore 13
    //   227: iload 13
    //   229: ifeq +15 -> 244
    //   232: aload 25
    //   234: ldc 253
    //   236: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   239: astore 19
    //   241: goto +7 -> 248
    //   244: ldc 249
    //   246: astore 19
    //   248: aload 25
    //   250: ldc 255
    //   252: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   255: istore 13
    //   257: iload 13
    //   259: ifeq +15 -> 274
    //   262: aload 25
    //   264: ldc 255
    //   266: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   269: astore 20
    //   271: goto +7 -> 278
    //   274: ldc 249
    //   276: astore 20
    //   278: aload 25
    //   280: ldc_w 257
    //   283: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   286: istore 13
    //   288: iload 13
    //   290: ifeq +13 -> 303
    //   293: aload 25
    //   295: ldc_w 257
    //   298: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   301: astore 21
    //   303: aload 25
    //   305: ldc_w 259
    //   308: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   311: istore 13
    //   313: iload 13
    //   315: ifeq +16 -> 331
    //   318: aload 25
    //   320: ldc_w 259
    //   323: invokevirtual 263	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   326: istore 11
    //   328: goto +6 -> 334
    //   331: iconst_1
    //   332: istore 11
    //   334: new 265	java/lang/StringBuilder
    //   337: dup
    //   338: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   341: astore 26
    //   343: aload 26
    //   345: ldc_w 268
    //   348: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: pop
    //   352: aload 26
    //   354: aload 4
    //   356: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: pop
    //   360: aload 10
    //   362: invokestatic 277	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   365: istore 13
    //   367: iload 13
    //   369: ifne +20 -> 389
    //   372: aload 26
    //   374: ldc_w 279
    //   377: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: pop
    //   381: aload 26
    //   383: aload 10
    //   385: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: pop
    //   389: lload 8
    //   391: aconst_null
    //   392: ldc_w 281
    //   395: aload 26
    //   397: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: iconst_0
    //   401: aconst_null
    //   402: invokestatic 290	com/tencent/mobileqq/qwallet/report/VACDReportUtil:a	(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   405: new 212	android/os/Bundle
    //   408: dup
    //   409: invokespecial 213	android/os/Bundle:<init>	()V
    //   412: astore 4
    //   414: aload 4
    //   416: ldc 220
    //   418: aload 22
    //   420: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   423: aload 4
    //   425: ldc_w 296
    //   428: ldc_w 298
    //   431: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   434: aload 4
    //   436: ldc_w 300
    //   439: iconst_0
    //   440: invokevirtual 304	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   443: aload 4
    //   445: ldc_w 306
    //   448: iload 12
    //   450: invokestatic 312	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   453: invokevirtual 316	java/lang/Boolean:booleanValue	()Z
    //   456: invokevirtual 304	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   459: aload 17
    //   461: ifnull +20 -> 481
    //   464: aload 17
    //   466: invokevirtual 321	java/lang/String:length	()I
    //   469: ifle +12 -> 481
    //   472: aload 4
    //   474: ldc 245
    //   476: aload 17
    //   478: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   481: aload 4
    //   483: ldc_w 323
    //   486: aload_3
    //   487: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   490: aload 25
    //   492: ldc_w 325
    //   495: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   498: istore 12
    //   500: iload 12
    //   502: ifeq +15 -> 517
    //   505: aload 25
    //   507: ldc_w 325
    //   510: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   513: astore_3
    //   514: goto +47 -> 561
    //   517: new 265	java/lang/StringBuilder
    //   520: dup
    //   521: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   524: astore_3
    //   525: aload_3
    //   526: ldc_w 327
    //   529: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: pop
    //   533: aload_3
    //   534: invokestatic 332	com/tencent/common/config/AppSetting:d	()I
    //   537: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   540: pop
    //   541: aload_3
    //   542: ldc_w 337
    //   545: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: pop
    //   549: aload_3
    //   550: aload 16
    //   552: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: pop
    //   556: aload_3
    //   557: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   560: astore_3
    //   561: aload 4
    //   563: ldc 228
    //   565: aload 24
    //   567: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   570: aload 4
    //   572: ldc_w 339
    //   575: ldc_w 341
    //   578: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   581: aload 4
    //   583: ldc 232
    //   585: aload 15
    //   587: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   590: aload 4
    //   592: ldc_w 325
    //   595: aload_3
    //   596: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   599: aload 4
    //   601: ldc_w 343
    //   604: ldc_w 343
    //   607: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   610: aload 4
    //   612: ldc 230
    //   614: aload 23
    //   616: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   619: aload 4
    //   621: ldc_w 345
    //   624: iconst_0
    //   625: invokevirtual 349	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   628: aload 4
    //   630: ldc 251
    //   632: aload 18
    //   634: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   637: aload 4
    //   639: ldc 253
    //   641: aload 19
    //   643: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   646: aload 4
    //   648: ldc 255
    //   650: aload 20
    //   652: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   655: aload 4
    //   657: ldc_w 257
    //   660: aload 21
    //   662: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   665: aload 4
    //   667: ldc_w 259
    //   670: iload 11
    //   672: invokevirtual 349	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   675: aload 4
    //   677: ldc_w 351
    //   680: bipush 7
    //   682: invokevirtual 349	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   685: aload 4
    //   687: ldc_w 353
    //   690: iload 5
    //   692: invokevirtual 349	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   695: aload 4
    //   697: ldc_w 355
    //   700: lload 6
    //   702: invokevirtual 359	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   705: aload 4
    //   707: ldc_w 361
    //   710: lload 8
    //   712: invokevirtual 359	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   715: aload_2
    //   716: aload 4
    //   718: invokestatic 365	cooperation/qwallet/plugin/impl/PayLogicImpl:setIPCReceiver	(Landroid/os/ResultReceiver;Landroid/os/Bundle;)V
    //   721: lload 8
    //   723: aconst_null
    //   724: ldc_w 367
    //   727: aconst_null
    //   728: iconst_0
    //   729: aconst_null
    //   730: invokestatic 290	com/tencent/mobileqq/qwallet/report/VACDReportUtil:a	(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   733: invokestatic 372	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   736: istore 12
    //   738: iload 12
    //   740: ifeq +38 -> 778
    //   743: new 265	java/lang/StringBuilder
    //   746: dup
    //   747: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   750: astore_2
    //   751: aload_2
    //   752: ldc_w 374
    //   755: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   758: pop
    //   759: aload_2
    //   760: invokestatic 380	java/lang/System:currentTimeMillis	()J
    //   763: invokevirtual 383	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   766: pop
    //   767: ldc_w 385
    //   770: iconst_4
    //   771: aload_2
    //   772: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   775: invokestatic 388	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   778: aload_1
    //   779: aload 4
    //   781: invokestatic 394	cooperation/qwallet/plugin/QWalletPayBridge:launchForeground	(Landroid/app/Activity;Landroid/os/Bundle;)Z
    //   784: pop
    //   785: aload 14
    //   787: astore_0
    //   788: aload_0
    //   789: ldc_w 396
    //   792: iconst_0
    //   793: invokevirtual 349	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   796: aload_0
    //   797: ldc 220
    //   799: aload 22
    //   801: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   804: aload_0
    //   805: ldc 247
    //   807: aload 16
    //   809: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   812: aload_0
    //   813: ldc_w 398
    //   816: aload 23
    //   818: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   821: aload_0
    //   822: areturn
    //   823: astore_0
    //   824: goto +39 -> 863
    //   827: astore_0
    //   828: goto +28 -> 856
    //   831: astore_0
    //   832: goto +31 -> 863
    //   835: astore_0
    //   836: goto +20 -> 856
    //   839: astore_0
    //   840: goto +23 -> 863
    //   843: astore_0
    //   844: goto +12 -> 856
    //   847: astore_0
    //   848: goto +15 -> 863
    //   851: astore_0
    //   852: goto +4 -> 856
    //   855: astore_0
    //   856: ldc 226
    //   858: astore_1
    //   859: goto +82 -> 941
    //   862: astore_0
    //   863: invokestatic 401	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   866: ifeq +38 -> 904
    //   869: new 265	java/lang/StringBuilder
    //   872: dup
    //   873: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   876: astore_1
    //   877: aload_1
    //   878: ldc_w 403
    //   881: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   884: pop
    //   885: aload_1
    //   886: aload_0
    //   887: invokevirtual 406	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   890: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   893: pop
    //   894: ldc 226
    //   896: iconst_2
    //   897: aload_1
    //   898: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   901: invokestatic 409	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   904: invokestatic 372	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   907: ifeq +7 -> 914
    //   910: aload_0
    //   911: invokevirtual 412	java/lang/Exception:printStackTrace	()V
    //   914: aload 14
    //   916: ldc_w 396
    //   919: iconst_m1
    //   920: invokevirtual 349	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   923: aload 14
    //   925: ldc_w 414
    //   928: ldc_w 416
    //   931: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   934: aload 14
    //   936: areturn
    //   937: astore_0
    //   938: ldc 226
    //   940: astore_2
    //   941: invokestatic 401	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   944: ifeq +37 -> 981
    //   947: new 265	java/lang/StringBuilder
    //   950: dup
    //   951: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   954: astore_2
    //   955: aload_2
    //   956: ldc_w 418
    //   959: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   962: pop
    //   963: aload_2
    //   964: aload_0
    //   965: invokevirtual 419	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   968: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   971: pop
    //   972: aload_1
    //   973: iconst_2
    //   974: aload_2
    //   975: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   978: invokestatic 409	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   981: invokestatic 372	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   984: ifeq +7 -> 991
    //   987: aload_0
    //   988: invokevirtual 420	org/json/JSONException:printStackTrace	()V
    //   991: aload 14
    //   993: ldc_w 396
    //   996: iconst_m1
    //   997: invokevirtual 349	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1000: aload 14
    //   1002: ldc_w 414
    //   1005: ldc_w 422
    //   1008: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1011: aload_0
    //   1012: invokevirtual 420	org/json/JSONException:printStackTrace	()V
    //   1015: aload 14
    //   1017: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1018	0	paramAppInterface	AppInterface
    //   0	1018	1	paramActivity	Activity
    //   0	1018	2	paramResultReceiver	ResultReceiver
    //   0	1018	3	paramString1	String
    //   0	1018	4	paramString2	String
    //   0	1018	5	paramInt	int
    //   0	1018	6	paramLong1	long
    //   0	1018	8	paramLong2	long
    //   0	1018	10	paramString3	String
    //   326	345	11	i	int
    //   57	682	12	bool1	boolean
    //   132	236	13	bool2	boolean
    //   7	928	14	localBundle	Bundle
    //   71	515	15	str1	String
    //   179	629	16	str2	String
    //   146	331	17	str3	String
    //   209	424	18	str4	String
    //   239	403	19	str5	String
    //   269	382	20	str6	String
    //   165	496	21	str7	String
    //   27	773	22	str8	String
    //   48	769	23	str9	String
    //   39	527	24	str10	String
    //   18	488	25	localJSONObject	JSONObject
    //   341	55	26	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   64	73	76	org/json/JSONException
    //   102	111	114	org/json/JSONException
    //   139	148	114	org/json/JSONException
    //   172	181	114	org/json/JSONException
    //   202	211	114	org/json/JSONException
    //   232	241	114	org/json/JSONException
    //   262	271	114	org/json/JSONException
    //   293	303	114	org/json/JSONException
    //   318	328	114	org/json/JSONException
    //   372	389	114	org/json/JSONException
    //   464	481	114	org/json/JSONException
    //   505	514	114	org/json/JSONException
    //   743	778	114	org/json/JSONException
    //   788	821	823	java/lang/Exception
    //   788	821	827	org/json/JSONException
    //   88	97	831	java/lang/Exception
    //   102	111	831	java/lang/Exception
    //   125	134	831	java/lang/Exception
    //   139	148	831	java/lang/Exception
    //   154	163	831	java/lang/Exception
    //   172	181	831	java/lang/Exception
    //   188	197	831	java/lang/Exception
    //   202	211	831	java/lang/Exception
    //   218	227	831	java/lang/Exception
    //   232	241	831	java/lang/Exception
    //   248	257	831	java/lang/Exception
    //   262	271	831	java/lang/Exception
    //   278	288	831	java/lang/Exception
    //   293	303	831	java/lang/Exception
    //   303	313	831	java/lang/Exception
    //   318	328	831	java/lang/Exception
    //   334	367	831	java/lang/Exception
    //   372	389	831	java/lang/Exception
    //   389	459	831	java/lang/Exception
    //   464	481	831	java/lang/Exception
    //   481	500	831	java/lang/Exception
    //   505	514	831	java/lang/Exception
    //   517	561	831	java/lang/Exception
    //   561	738	831	java/lang/Exception
    //   743	778	831	java/lang/Exception
    //   778	785	831	java/lang/Exception
    //   88	97	835	org/json/JSONException
    //   125	134	835	org/json/JSONException
    //   154	163	835	org/json/JSONException
    //   188	197	835	org/json/JSONException
    //   218	227	835	org/json/JSONException
    //   248	257	835	org/json/JSONException
    //   278	288	835	org/json/JSONException
    //   303	313	835	org/json/JSONException
    //   334	367	835	org/json/JSONException
    //   389	459	835	org/json/JSONException
    //   481	500	835	org/json/JSONException
    //   517	561	835	org/json/JSONException
    //   561	738	835	org/json/JSONException
    //   778	785	835	org/json/JSONException
    //   41	59	839	java/lang/Exception
    //   64	73	839	java/lang/Exception
    //   41	59	843	org/json/JSONException
    //   32	41	847	java/lang/Exception
    //   32	41	851	org/json/JSONException
    //   9	29	855	org/json/JSONException
    //   9	29	862	java/lang/Exception
  }
  
  private boolean checkEmojiPayParam(DataFactory.EmojiPayReqData paramEmojiPayReqData)
  {
    return (paramEmojiPayReqData != null) && (!TextUtils.isEmpty(paramEmojiPayReqData.b)) && (!TextUtils.isEmpty(paramEmojiPayReqData.a)) && (!TextUtils.isEmpty(paramEmojiPayReqData.c)) && (!TextUtils.isEmpty(paramEmojiPayReqData.d)) && (!TextUtils.isEmpty(paramEmojiPayReqData.j));
  }
  
  public static void clearCache()
  {
    SparseArray localSparseArray = sPayLogics;
    if (localSparseArray != null) {
      localSparseArray.clear();
    }
  }
  
  private Dialog createCustomDialog(String paramString1, String paramString2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    Dialog localDialog = new Dialog(this.mActivity, R.style.b);
    localDialog.setContentView(R.layout.a);
    TextView localTextView = (TextView)localDialog.findViewById(R.id.E);
    if (localTextView != null) {
      localTextView.setText(paramString1);
    }
    paramString1 = (TextView)localDialog.findViewById(R.id.D);
    if (paramString1 != null) {
      paramString1.setText(paramString2);
    }
    paramString1 = (TextView)localDialog.findViewById(R.id.B);
    if (paramString1 != null) {
      paramString1.setText(17039360);
    }
    paramString1 = (TextView)localDialog.findViewById(R.id.C);
    if (paramString1 != null) {
      paramString1.setText(R.string.dn);
    }
    localDialog.setOnDismissListener(paramOnDismissListener);
    return localDialog;
  }
  
  private void doEmojimallPay(DataFactory.EmojiPayReqData paramEmojiPayReqData)
  {
    this.mEmojiPayReqData = paramEmojiPayReqData;
    this.mMidasOfferid = paramEmojiPayReqData.b;
    this.mMidasAid = getAidFromPf(paramEmojiPayReqData.h);
    Bundle localBundle = new Bundle();
    localBundle.putString("setEnv", "release");
    localBundle.putBoolean("setLogEnable", false);
    localBundle.putString("offerId", paramEmojiPayReqData.b);
    localBundle.putBoolean("isShowNum", false);
    localBundle.putString("userId", paramEmojiPayReqData.c);
    localBundle.putString("userKey", paramEmojiPayReqData.d);
    localBundle.putString("sessionId", paramEmojiPayReqData.e);
    localBundle.putString("sessionType", paramEmojiPayReqData.f);
    localBundle.putString("zoneId", paramEmojiPayReqData.g);
    localBundle.putString("pf", paramEmojiPayReqData.h);
    localBundle.putString("pfKey", paramEmojiPayReqData.i);
    localBundle.putString("tokenUrl", paramEmojiPayReqData.j);
    localBundle.putInt("resId", R.drawable.d);
    localBundle.putString("discountId", paramEmojiPayReqData.k);
    localBundle.putString("other", paramEmojiPayReqData.l);
    localBundle.putString("payload", paramEmojiPayReqData.m);
    localBundle.putString("drmInfo", paramEmojiPayReqData.n);
    localBundle.putInt("PayInvokerId", 1);
    localBundle.putInt("payparmas_paytype", this.mPayType);
    QWalletPayBridge.launchForeground(this.mActivity, localBundle);
    putProxyReceiverToBundle(localBundle);
  }
  
  private void doGoldCharge(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("offerid");
    String str2 = paramBundle.getString("uin");
    String str3 = paramBundle.getString("pf");
    String str4 = paramBundle.getString("discountId");
    String str5 = paramBundle.getString("other");
    String str6 = paramBundle.getString("payload");
    String str7 = paramBundle.getString("drmInfo");
    String str8 = paramBundle.getString("saveValue");
    boolean bool = paramBundle.getBoolean("isCanChange", true);
    this.mMidasOfferid = str1;
    this.mMidasAid = getAidFromPf(str3);
    paramBundle = new Bundle();
    paramBundle.putString("setEnv", "release");
    paramBundle.putBoolean("setLogEnable", false);
    paramBundle.putString("offerId", str1);
    paramBundle.putString("userId", str2);
    paramBundle.putString("sessionId", "uin");
    paramBundle.putString("zoneId", "1");
    paramBundle.putString("pf", str3);
    paramBundle.putString("pfKey", "pfKey");
    paramBundle.putString("acctType", "common");
    paramBundle.putInt("resId", R.drawable.z);
    paramBundle.putString("discountId", str4);
    paramBundle.putString("other", str5);
    paramBundle.putString("payload", str6);
    paramBundle.putString("drmInfo", str7);
    paramBundle.putInt("PayInvokerId", 2);
    paramBundle.putInt("payparmas_paytype", this.mPayType);
    if ((str8 != null) && (str8.trim().length() > 0))
    {
      paramBundle.putString("saveValue", str8);
      paramBundle.putBoolean("isCanChange", bool);
    }
    putProxyReceiverToBundle(paramBundle);
    QWalletPayBridge.launchForeground(this.mActivity, paramBundle);
  }
  
  private void doOpenQQReaderVip(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("offerid");
    String str2 = paramBundle.getString("uin");
    String str3 = paramBundle.getString("pf");
    String str4 = paramBundle.getString("provideUin");
    String str5 = paramBundle.getString("provideType");
    String str6 = paramBundle.getString("discountId");
    String str7 = paramBundle.getString("other");
    String str8 = paramBundle.getString("payload");
    paramBundle = paramBundle.getString("drmInfo");
    this.mMidasOfferid = str1;
    this.mMidasAid = getAidFromPf(str3);
    Bundle localBundle = new Bundle();
    localBundle.putString("setEnv", "release");
    localBundle.putBoolean("setLogEnable", false);
    localBundle.putString("offerId", str1);
    localBundle.putString("userId", str2);
    localBundle.putString("sessionId", "uin");
    localBundle.putString("pf", str3);
    localBundle.putString("pfKey", "pfKey");
    localBundle.putString("serviceCode", "QQYFSC");
    localBundle.putString("serviceName", "腾讯文学包月VIP");
    localBundle.putInt("resId", R.drawable.z);
    localBundle.putString("saveValue", "3");
    localBundle.putBoolean("isCanChange", true);
    localBundle.putString("remark", "");
    localBundle.putString("provideUin", str4);
    localBundle.putString("provideType", str5);
    localBundle.putString("discountId", str6);
    localBundle.putString("other", str7);
    localBundle.putString("payload", str8);
    localBundle.putString("drmInfo", paramBundle);
    localBundle.putInt("PayInvokerId", 3);
    localBundle.putInt("payparmas_paytype", this.mPayType);
    putProxyReceiverToBundle(localBundle);
    QWalletPayBridge.launchForeground(this.mActivity, localBundle);
  }
  
  private String generateMidasErrorResult()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("resultCode", -1);
      ((JSONObject)localObject).put("payState", -1);
      ((JSONObject)localObject).put("provideState", -1);
      ((JSONObject)localObject).put("resultMsg", "");
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (Exception localException) {}
    return "";
  }
  
  private String generateTenPayErrorResult()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("resultCode", -1);
      ((JSONObject)localObject).put("retmsg", "error");
      ((JSONObject)localObject).put("data", new JSONObject());
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (Exception localException)
    {
      label50:
      break label50;
    }
    return "";
  }
  
  public static String getAidFromPf(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    int i = paramString.lastIndexOf('-');
    if (i != -1) {
      return paramString.substring(i + 1);
    }
    return "";
  }
  
  private static String getPfPref(int paramInt)
  {
    if (paramInt == 9) {
      return "qqapp_qq-";
    }
    return "qq_m_qq-";
  }
  
  private static String invokerIdToAction(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 14)
      {
        if (paramInt != 17)
        {
          switch (paramInt)
          {
          default: 
            return null;
          case 9: 
            return "pay-h5";
          case 8: 
            return "rechargeQb";
          case 7: 
            return "buyGoods";
          }
          return "rechargeGameCurrency";
        }
        return "wechatPaySign";
      }
      return "monthCardPay";
    }
    return "openService";
  }
  
  private static boolean isEnterMidasTestEnv(JSONObject paramJSONObject)
  {
    return (paramJSONObject != null) && (paramJSONObject.optInt("setMidasEnv", 0) == 1) && (((IMiniAppService)QRoute.api(IMiniAppService.class)).isDebugMiniApp(paramJSONObject.optString("miniAppVertypeStr")));
  }
  
  public static boolean isLockWithdraw(int paramInt, Bundle paramBundle)
  {
    if (1 == paramInt) {
      try
      {
        boolean bool = isLockWithdraw(paramInt, new JSONObject(paramBundle.getString("json")).optJSONObject("extra_data"));
        return bool;
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
      }
    }
    return false;
  }
  
  public static boolean isLockWithdraw(int paramInt, JSONObject paramJSONObject)
  {
    if (1 == paramInt) {
      try
      {
        if ((paramJSONObject.has("pskey")) || (paramJSONObject.has("p_skey_forbid")))
        {
          boolean bool = paramJSONObject.has("banned_user_buff");
          if (bool) {
            return true;
          }
        }
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
    return false;
  }
  
  private boolean isLoginParamsValid()
  {
    int i;
    if ((!this.isLockWithdraw) && (this.intentData.getBoolean("payparmas_from_is_login_state", true))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      BaseQQAppInterface localBaseQQAppInterface = this.app;
      if ((localBaseQQAppInterface == null) || (localBaseQQAppInterface.getCurrentAccountUin() == null)) {
        return false;
      }
    }
    return true;
  }
  
  /* Error */
  protected static Bundle launchWeChat(AppInterface paramAppInterface, Activity paramActivity, ResultReceiver paramResultReceiver, String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2, String paramString3)
  {
    // Byte code:
    //   0: new 212	android/os/Bundle
    //   3: dup
    //   4: invokespecial 213	android/os/Bundle:<init>	()V
    //   7: astore_0
    //   8: new 215	org/json/JSONObject
    //   11: dup
    //   12: aload 4
    //   14: invokespecial 218	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   17: astore 23
    //   19: aload 23
    //   21: ldc_w 690
    //   24: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   27: astore 20
    //   29: aload 23
    //   31: ldc_w 692
    //   34: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   37: astore 21
    //   39: ldc_w 414
    //   42: astore 4
    //   44: aload 23
    //   46: ldc_w 694
    //   49: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   52: astore 22
    //   54: aload 23
    //   56: ldc_w 696
    //   59: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   62: istore 11
    //   64: aconst_null
    //   65: astore 19
    //   67: iload 11
    //   69: ifeq +41 -> 110
    //   72: aload 23
    //   74: ldc_w 696
    //   77: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   80: astore 12
    //   82: goto +31 -> 113
    //   85: astore 12
    //   87: ldc 226
    //   89: astore 10
    //   91: ldc_w 396
    //   94: astore_2
    //   95: aload_0
    //   96: astore_1
    //   97: aload 4
    //   99: astore_3
    //   100: aload 12
    //   102: astore_0
    //   103: aload 10
    //   105: astore 4
    //   107: goto +935 -> 1042
    //   110: aconst_null
    //   111: astore 12
    //   113: aload 23
    //   115: ldc_w 698
    //   118: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   121: ifeq +16 -> 137
    //   124: aload 23
    //   126: ldc_w 698
    //   129: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   132: astore 13
    //   134: goto +6 -> 140
    //   137: aconst_null
    //   138: astore 13
    //   140: aload 23
    //   142: ldc_w 700
    //   145: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   148: istore 11
    //   150: iload 11
    //   152: ifeq +39 -> 191
    //   155: aload 23
    //   157: ldc_w 700
    //   160: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   163: astore 14
    //   165: goto +29 -> 194
    //   168: astore_2
    //   169: aload_0
    //   170: astore_1
    //   171: aload 4
    //   173: astore_3
    //   174: ldc 226
    //   176: astore 4
    //   178: ldc_w 396
    //   181: astore 10
    //   183: aload_2
    //   184: astore_0
    //   185: aload 10
    //   187: astore_2
    //   188: goto +854 -> 1042
    //   191: aconst_null
    //   192: astore 14
    //   194: aload 23
    //   196: ldc_w 702
    //   199: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   202: istore 11
    //   204: iload 11
    //   206: ifeq +37 -> 243
    //   209: aload 23
    //   211: ldc_w 702
    //   214: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   217: astore 15
    //   219: goto +27 -> 246
    //   222: astore 10
    //   224: aload 4
    //   226: astore_3
    //   227: ldc 226
    //   229: astore 4
    //   231: ldc_w 396
    //   234: astore_2
    //   235: aload_0
    //   236: astore_1
    //   237: aload 10
    //   239: astore_0
    //   240: goto +802 -> 1042
    //   243: aconst_null
    //   244: astore 15
    //   246: aload 23
    //   248: ldc_w 704
    //   251: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   254: istore 11
    //   256: iload 11
    //   258: ifeq +16 -> 274
    //   261: aload 23
    //   263: ldc_w 704
    //   266: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   269: astore 16
    //   271: goto +6 -> 277
    //   274: aconst_null
    //   275: astore 16
    //   277: aload 23
    //   279: ldc_w 706
    //   282: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   285: istore 11
    //   287: iload 11
    //   289: ifeq +16 -> 305
    //   292: aload 23
    //   294: ldc_w 706
    //   297: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   300: astore 17
    //   302: goto +6 -> 308
    //   305: aconst_null
    //   306: astore 17
    //   308: aload 23
    //   310: ldc_w 708
    //   313: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   316: istore 11
    //   318: iload 11
    //   320: ifeq +16 -> 336
    //   323: aload 23
    //   325: ldc_w 708
    //   328: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   331: astore 18
    //   333: goto +6 -> 339
    //   336: aconst_null
    //   337: astore 18
    //   339: aload 23
    //   341: ldc_w 710
    //   344: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   347: istore 11
    //   349: iload 11
    //   351: ifeq +13 -> 364
    //   354: aload 23
    //   356: ldc_w 710
    //   359: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   362: astore 19
    //   364: new 265	java/lang/StringBuilder
    //   367: dup
    //   368: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   371: astore 23
    //   373: aload 23
    //   375: ldc_w 712
    //   378: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: pop
    //   382: aload 23
    //   384: aload 20
    //   386: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: pop
    //   390: aload 23
    //   392: ldc_w 714
    //   395: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: pop
    //   399: aload 23
    //   401: aload 21
    //   403: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: pop
    //   407: aload 23
    //   409: ldc_w 716
    //   412: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: pop
    //   416: aload 23
    //   418: aload 22
    //   420: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: pop
    //   424: aload 23
    //   426: ldc_w 718
    //   429: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: pop
    //   433: aload 23
    //   435: aload 12
    //   437: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: pop
    //   441: aload 23
    //   443: ldc_w 720
    //   446: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: pop
    //   450: aload 23
    //   452: aload 13
    //   454: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: pop
    //   458: aload 23
    //   460: ldc_w 722
    //   463: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: pop
    //   467: aload 23
    //   469: aload 14
    //   471: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: pop
    //   475: aload 23
    //   477: ldc_w 724
    //   480: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: pop
    //   484: aload 23
    //   486: aload 15
    //   488: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: pop
    //   492: aload 23
    //   494: ldc_w 726
    //   497: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: pop
    //   501: aload 23
    //   503: aload 16
    //   505: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: pop
    //   509: aload 23
    //   511: ldc_w 728
    //   514: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: pop
    //   518: aload 23
    //   520: aload 17
    //   522: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   525: pop
    //   526: aload 23
    //   528: ldc_w 730
    //   531: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: pop
    //   535: aload 23
    //   537: aload 18
    //   539: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: pop
    //   543: aload 23
    //   545: ldc_w 732
    //   548: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: pop
    //   552: aload 23
    //   554: aload 19
    //   556: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   559: pop
    //   560: aload 10
    //   562: invokestatic 277	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   565: istore 11
    //   567: iload 11
    //   569: ifne +20 -> 589
    //   572: aload 23
    //   574: ldc_w 279
    //   577: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   580: pop
    //   581: aload 23
    //   583: aload 10
    //   585: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: pop
    //   589: lload 8
    //   591: aconst_null
    //   592: ldc_w 281
    //   595: aload 23
    //   597: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   600: iconst_0
    //   601: aconst_null
    //   602: invokestatic 290	com/tencent/mobileqq/qwallet/report/VACDReportUtil:a	(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   605: new 212	android/os/Bundle
    //   608: dup
    //   609: invokespecial 213	android/os/Bundle:<init>	()V
    //   612: astore 10
    //   614: aload 10
    //   616: ldc_w 690
    //   619: aload 20
    //   621: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   624: aload 10
    //   626: ldc_w 692
    //   629: aload 21
    //   631: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   634: aload 10
    //   636: ldc_w 694
    //   639: aload 22
    //   641: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   644: aload 10
    //   646: ldc_w 696
    //   649: aload 12
    //   651: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   654: aload 10
    //   656: ldc_w 698
    //   659: aload 13
    //   661: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   664: aload 10
    //   666: ldc_w 700
    //   669: aload 14
    //   671: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   674: aload 10
    //   676: ldc_w 702
    //   679: aload 15
    //   681: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   684: aload 10
    //   686: ldc_w 704
    //   689: aload 16
    //   691: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   694: aload 10
    //   696: ldc_w 706
    //   699: aload 17
    //   701: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   704: aload 10
    //   706: ldc_w 708
    //   709: aload 18
    //   711: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   714: aload 10
    //   716: ldc_w 710
    //   719: aload 19
    //   721: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   724: aload 10
    //   726: ldc_w 323
    //   729: aload_3
    //   730: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   733: aload 10
    //   735: ldc_w 351
    //   738: bipush 17
    //   740: invokevirtual 349	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   743: aload 10
    //   745: ldc_w 353
    //   748: iload 5
    //   750: invokevirtual 349	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   753: aload 10
    //   755: ldc_w 355
    //   758: lload 6
    //   760: invokevirtual 359	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   763: aload 10
    //   765: ldc_w 361
    //   768: lload 8
    //   770: invokevirtual 359	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   773: aload_2
    //   774: aload 10
    //   776: invokestatic 365	cooperation/qwallet/plugin/impl/PayLogicImpl:setIPCReceiver	(Landroid/os/ResultReceiver;Landroid/os/Bundle;)V
    //   779: lload 8
    //   781: aconst_null
    //   782: ldc_w 367
    //   785: aconst_null
    //   786: iconst_0
    //   787: aconst_null
    //   788: invokestatic 290	com/tencent/mobileqq/qwallet/report/VACDReportUtil:a	(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   791: invokestatic 372	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   794: istore 11
    //   796: iload 11
    //   798: ifeq +38 -> 836
    //   801: new 265	java/lang/StringBuilder
    //   804: dup
    //   805: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   808: astore_2
    //   809: aload_2
    //   810: ldc_w 374
    //   813: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   816: pop
    //   817: aload_2
    //   818: invokestatic 380	java/lang/System:currentTimeMillis	()J
    //   821: invokevirtual 383	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   824: pop
    //   825: ldc_w 385
    //   828: iconst_4
    //   829: aload_2
    //   830: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   833: invokestatic 388	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   836: aload_1
    //   837: aload 10
    //   839: invokestatic 394	cooperation/qwallet/plugin/QWalletPayBridge:launchForeground	(Landroid/app/Activity;Landroid/os/Bundle;)Z
    //   842: pop
    //   843: ldc_w 396
    //   846: astore_2
    //   847: aload_0
    //   848: astore_1
    //   849: aload_1
    //   850: aload_2
    //   851: iconst_0
    //   852: invokevirtual 349	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   855: aload_1
    //   856: areturn
    //   857: astore_0
    //   858: goto +100 -> 958
    //   861: astore_0
    //   862: goto +76 -> 938
    //   865: astore_3
    //   866: ldc_w 396
    //   869: astore_2
    //   870: aload_0
    //   871: astore_1
    //   872: aload_3
    //   873: astore_0
    //   874: goto +84 -> 958
    //   877: astore_3
    //   878: ldc_w 396
    //   881: astore_2
    //   882: aload_0
    //   883: astore_1
    //   884: aload_3
    //   885: astore_0
    //   886: goto +52 -> 938
    //   889: astore_3
    //   890: aload_0
    //   891: astore_1
    //   892: ldc_w 396
    //   895: astore_2
    //   896: aload_3
    //   897: astore_0
    //   898: goto +60 -> 958
    //   901: astore_3
    //   902: aload_0
    //   903: astore_1
    //   904: ldc_w 396
    //   907: astore_2
    //   908: aload_3
    //   909: astore_0
    //   910: goto +28 -> 938
    //   913: astore_3
    //   914: goto +36 -> 950
    //   917: astore_3
    //   918: goto +12 -> 930
    //   921: astore_3
    //   922: goto +28 -> 950
    //   925: astore_3
    //   926: goto +4 -> 930
    //   929: astore_3
    //   930: ldc_w 396
    //   933: astore_2
    //   934: aload_0
    //   935: astore_1
    //   936: aload_3
    //   937: astore_0
    //   938: ldc_w 414
    //   941: astore_3
    //   942: ldc 226
    //   944: astore 4
    //   946: goto +96 -> 1042
    //   949: astore_3
    //   950: ldc_w 396
    //   953: astore_2
    //   954: aload_0
    //   955: astore_1
    //   956: aload_3
    //   957: astore_0
    //   958: invokestatic 401	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   961: ifeq +38 -> 999
    //   964: new 265	java/lang/StringBuilder
    //   967: dup
    //   968: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   971: astore_3
    //   972: aload_3
    //   973: ldc_w 734
    //   976: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   979: pop
    //   980: aload_3
    //   981: aload_0
    //   982: invokevirtual 406	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   985: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   988: pop
    //   989: ldc 226
    //   991: iconst_2
    //   992: aload_3
    //   993: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   996: invokestatic 409	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   999: invokestatic 372	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1002: ifeq +7 -> 1009
    //   1005: aload_0
    //   1006: invokevirtual 412	java/lang/Exception:printStackTrace	()V
    //   1009: aload_1
    //   1010: aload_2
    //   1011: iconst_m1
    //   1012: invokevirtual 349	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1015: aload_1
    //   1016: ldc_w 414
    //   1019: ldc_w 736
    //   1022: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1025: aload_1
    //   1026: areturn
    //   1027: astore_0
    //   1028: ldc_w 414
    //   1031: astore_0
    //   1032: ldc 226
    //   1034: astore_0
    //   1035: ldc_w 396
    //   1038: astore_0
    //   1039: aload_0
    //   1040: astore 10
    //   1042: invokestatic 401	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1045: ifeq +42 -> 1087
    //   1048: new 265	java/lang/StringBuilder
    //   1051: dup
    //   1052: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   1055: astore 10
    //   1057: aload 10
    //   1059: ldc_w 738
    //   1062: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1065: pop
    //   1066: aload 10
    //   1068: aload_0
    //   1069: invokevirtual 419	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   1072: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1075: pop
    //   1076: aload 4
    //   1078: iconst_2
    //   1079: aload 10
    //   1081: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1084: invokestatic 409	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1087: invokestatic 372	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1090: ifeq +7 -> 1097
    //   1093: aload_0
    //   1094: invokevirtual 420	org/json/JSONException:printStackTrace	()V
    //   1097: aload_1
    //   1098: aload_2
    //   1099: iconst_m1
    //   1100: invokevirtual 349	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1103: aload_1
    //   1104: aload_3
    //   1105: ldc_w 740
    //   1108: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1111: aload_1
    //   1112: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1113	0	paramAppInterface	AppInterface
    //   0	1113	1	paramActivity	Activity
    //   0	1113	2	paramResultReceiver	ResultReceiver
    //   0	1113	3	paramString1	String
    //   0	1113	4	paramString2	String
    //   0	1113	5	paramInt	int
    //   0	1113	6	paramLong1	long
    //   0	1113	8	paramLong2	long
    //   0	1113	10	paramString3	String
    //   62	735	11	bool	boolean
    //   80	1	12	str1	String
    //   85	16	12	localJSONException	JSONException
    //   111	539	12	str2	String
    //   132	528	13	str3	String
    //   163	507	14	str4	String
    //   217	463	15	str5	String
    //   269	421	16	str6	String
    //   300	400	17	str7	String
    //   331	379	18	str8	String
    //   65	655	19	str9	String
    //   27	593	20	str10	String
    //   37	593	21	str11	String
    //   52	588	22	str12	String
    //   17	579	23	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   72	82	85	org/json/JSONException
    //   155	165	168	org/json/JSONException
    //   209	219	222	org/json/JSONException
    //   261	271	222	org/json/JSONException
    //   292	302	222	org/json/JSONException
    //   323	333	222	org/json/JSONException
    //   354	364	222	org/json/JSONException
    //   572	589	222	org/json/JSONException
    //   801	836	222	org/json/JSONException
    //   849	855	857	java/lang/Exception
    //   849	855	861	org/json/JSONException
    //   194	204	865	java/lang/Exception
    //   209	219	865	java/lang/Exception
    //   246	256	865	java/lang/Exception
    //   261	271	865	java/lang/Exception
    //   277	287	865	java/lang/Exception
    //   292	302	865	java/lang/Exception
    //   308	318	865	java/lang/Exception
    //   323	333	865	java/lang/Exception
    //   339	349	865	java/lang/Exception
    //   354	364	865	java/lang/Exception
    //   364	567	865	java/lang/Exception
    //   572	589	865	java/lang/Exception
    //   589	796	865	java/lang/Exception
    //   801	836	865	java/lang/Exception
    //   836	843	865	java/lang/Exception
    //   194	204	877	org/json/JSONException
    //   246	256	877	org/json/JSONException
    //   277	287	877	org/json/JSONException
    //   308	318	877	org/json/JSONException
    //   339	349	877	org/json/JSONException
    //   364	567	877	org/json/JSONException
    //   589	796	877	org/json/JSONException
    //   836	843	877	org/json/JSONException
    //   140	150	889	java/lang/Exception
    //   155	165	889	java/lang/Exception
    //   140	150	901	org/json/JSONException
    //   113	134	913	java/lang/Exception
    //   113	134	917	org/json/JSONException
    //   44	64	921	java/lang/Exception
    //   72	82	921	java/lang/Exception
    //   44	64	925	org/json/JSONException
    //   8	39	929	org/json/JSONException
    //   8	39	949	java/lang/Exception
  }
  
  private void newPay(int paramInt, Bundle paramBundle)
  {
    String str1 = paramBundle.getString("callbackSn");
    String str2 = paramBundle.getString("json");
    String str3 = paramBundle.getString("payparmas_url_appinfo");
    if (this.mReportSeq == 0L)
    {
      int i = this.mPayType;
      if ((i == -1) || (i == 5) || (i == 2))
      {
        localObject = convertToReportAction(paramInt);
        if (localObject != null)
        {
          this.mReportSeq = VACDReportUtil.a(null, "qqwallet", (String)localObject, "payinvoke", null, 0, null);
          this.mIsStartReport = true;
        }
      }
    }
    Object localObject = (ResultReceiver)paramBundle.getParcelable("_qwallet_payresult_receiver");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = new PayLogicImpl.CompactReceiver(ThreadManager.getUIHandlerV2(), this);
    }
    localObject = this.mActivity;
    if (paramInt == 4) {
      paramBundle = openService(this.app, (Activity)localObject, paramBundle, str1, str2, this.mPayType, this.mPayH5StartTime, this.mReportSeq, null);
    } else if (paramInt == 6) {
      paramBundle = rechargeGameCurrency(this.app, (Activity)localObject, paramBundle, str1, str2, this.mPayType, this.mPayH5StartTime, this.mReportSeq, null);
    } else if (paramInt == 7) {
      paramBundle = buyGoods(this.app, (Activity)localObject, paramBundle, str1, str2, this.mPayType, this.mPayH5StartTime, this.mReportSeq, null);
    } else if (paramInt == 8) {
      paramBundle = rechargeQb(this.app, (Activity)localObject, paramBundle, str1, str2, this.mPayType, this.mPayH5StartTime, this.mReportSeq, null);
    } else if (paramInt == 9) {
      paramBundle = pay(this.app, (Activity)localObject, paramBundle, str1, str2, str3, this.mPayType, this.mPayH5StartTime, this.mReportSeq, null);
    } else if (paramInt == 14) {
      paramBundle = subscribeMonthCardPay(this.app, (Activity)localObject, paramBundle, str1, str2, this.mPayType, this.mPayH5StartTime, this.mReportSeq, null);
    } else {
      paramBundle = null;
    }
    if (paramBundle != null) {
      if (paramBundle.getInt("retCode", -1) != 0)
      {
        paramBundle = paramBundle.getString("retJson");
        if (paramBundle != null) {
          tenpayResult(str1, paramBundle);
        }
        long l = this.mReportSeq;
        if (l != 0L) {
          VACDReportUtil.endReport(l, "parseurl", null, 668801, paramBundle);
        }
      }
      else
      {
        if (paramInt == 9)
        {
          this.mPayTokenId = paramBundle.getString("token");
          this.mPayAppId = paramBundle.getString("appid");
          this.mPayChannel = paramBundle.getString("channel");
          this.mPayBargainorId = paramBundle.getString("bargainor");
          return;
        }
        this.mMidasOfferid = paramBundle.getString("offerId");
        this.mMidasAid = paramBundle.getString("aid");
        this.mMidasOrderId = paramBundle.getString("orderId");
      }
    }
  }
  
  private void onCheckWebankResult(Intent paramIntent)
  {
    this.mActivity.setResult(-1, paramIntent);
    end();
  }
  
  private void onEmojimallPayResult(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("QWalletPayBridge.PayResult.ExtraKey", 1);
    int j = paramIntent.getIntExtra("result", -1);
    int k = paramIntent.getIntExtra("realSaveNum", -1);
    int m = paramIntent.getIntExtra("payChannel", -1);
    int n = paramIntent.getIntExtra("payState", -1);
    int i1 = paramIntent.getIntExtra("provideState", -1);
    String str = paramIntent.getStringExtra("message");
    int i2 = paramIntent.getIntExtra("payRetCode", -1);
    long l = paramIntent.getLongExtra("reportSeq", 0L);
    if ((this.mIsStartReport) && (l > 0L)) {
      VACDReportUtil.endReport(l, "payEnd", null, i2, null);
    }
    if (i == 1)
    {
      paramIntent = this.mEmojiPayReqData;
      if (paramIntent != null)
      {
        OnEmojimallPayResult(paramIntent, j, k, m, n, i1, str);
        return;
      }
    }
    OnEmojimallPayResult(this.mEmojiPayReqData, -1, -1, -1, -1, -1, "");
  }
  
  private void onF2FRedpackCheckError()
  {
    Object localObject = this.mActivity;
    localObject = DialogUtil.a((Context)localObject, 231, null, ((QBaseActivity)localObject).getResources().getString(R.string.e), ((QBaseActivity)localObject).getResources().getString(R.string.d), null, null, new PayLogicImpl.1(this));
    ((QQCustomDialog)localObject).setCancelable(false);
    ((QQCustomDialog)localObject).show();
  }
  
  private void onGoldChargeResult(int paramInt1, String paramString1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString2)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putInt("result", paramInt1);
    localBundle.putString("retInnerCode", paramString1);
    localBundle.putInt("realSaveNum", paramInt2);
    localBundle.putInt("payChannel", paramInt3);
    localBundle.putInt("payState", paramInt4);
    localBundle.putInt("provideState", paramInt5);
    localBundle.putString("message", paramString2);
    localIntent.putExtras(localBundle);
    this.mActivity.setResult(paramInt1, localIntent);
    saveNonePCPayResultData(paramInt1, localIntent);
    end();
  }
  
  private void onGoldChargeResult(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("QWalletPayBridge.PayResult.ExtraKey", 1);
    int j = paramIntent.getIntExtra("result", -1);
    String str1 = paramIntent.getStringExtra("retInnerCode");
    int k = paramIntent.getIntExtra("realSaveNum", -1);
    int m = paramIntent.getIntExtra("payChannel", -1);
    int n = paramIntent.getIntExtra("payState", -1);
    int i1 = paramIntent.getIntExtra("provideState", -1);
    String str2 = paramIntent.getStringExtra("message");
    int i2 = paramIntent.getIntExtra("payRetCode", -1);
    long l = paramIntent.getLongExtra("reportSeq", 0L);
    if ((this.mIsStartReport) && (l > 0L)) {
      VACDReportUtil.endReport(l, "payEnd", null, i2, null);
    }
    if (i == 1)
    {
      onGoldChargeResult(j, str1, k, m, n, i1, str2);
      return;
    }
    onGoldChargeResult(-1, "", -1, -1, -1, -1, "");
  }
  
  private void onMidasPayResult(Intent paramIntent)
  {
    if (paramIntent.getIntExtra("QWalletPayBridge.PayResult.ExtraKey", 1) != 1) {
      paramIntent.putExtra("result", generateMidasErrorResult());
    }
    tenpayResult(paramIntent.getExtras());
  }
  
  private void onOpenQQReaderVipResult(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("QWalletPayBridge.PayResult.ExtraKey", 1);
    int j = paramIntent.getIntExtra("result", -1);
    String str1 = paramIntent.getStringExtra("retInnerCode");
    int k = paramIntent.getIntExtra("realSaveNum", -1);
    int m = paramIntent.getIntExtra("payChannel", -1);
    int n = paramIntent.getIntExtra("payState", -1);
    int i1 = paramIntent.getIntExtra("provideState", -1);
    String str2 = paramIntent.getStringExtra("message");
    int i2 = paramIntent.getIntExtra("payRetCode", -1);
    long l = paramIntent.getLongExtra("reportSeq", 0L);
    if ((this.mIsStartReport) && (l > 0L)) {
      VACDReportUtil.endReport(l, "payEnd", null, i2, null);
    }
    if (i == 1)
    {
      onGoldChargeResult(j, str1, k, m, n, i1, str2);
      return;
    }
    onGoldChargeResult(-1, "", -1, -1, -1, -1, "");
  }
  
  private void onOpenQzoneVipCallBack(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("retInnerCode", paramString1);
    localBundle.putString("msg", paramString2);
    localBundle.putInt("payState", paramInt2);
    localBundle.putInt("provideState", paramInt3);
    paramString1 = new Intent();
    paramString1.putExtras(localBundle);
    this.mActivity.setResult(paramInt1, paramString1);
    saveNonePCPayResultData(paramInt1, paramString1);
    end();
  }
  
  private void onOpenQzoneVipResult(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("QWalletPayBridge.PayResult.ExtraKey", 1);
    int j = paramIntent.getIntExtra("result", -1);
    String str1 = paramIntent.getStringExtra("retInnerCode");
    int k = paramIntent.getIntExtra("payState", -1);
    int m = paramIntent.getIntExtra("provideState", -1);
    String str2 = paramIntent.getStringExtra("message");
    int n = paramIntent.getIntExtra("payRetCode", -1);
    long l = paramIntent.getLongExtra("reportSeq", 0L);
    if ((this.mIsStartReport) && (l > 0L)) {
      VACDReportUtil.endReport(l, "payEnd", null, n, null);
    }
    if (i == 1)
    {
      onOpenQzoneVipCallBack(j, str1, str2, k, m);
      return;
    }
    onOpenQzoneVipCallBack(-1, "", "", -1, -1);
  }
  
  private void onOpenQzoneVipServiceCallBack(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("msg", paramString);
    localBundle.putInt("payState", paramInt2);
    localBundle.putInt("provideState", paramInt3);
    paramString = new Intent();
    paramString.putExtras(localBundle);
    this.mActivity.setResult(paramInt1, paramString);
    saveNonePCPayResultData(paramInt1, paramString);
    end();
  }
  
  private void onOpenTenpayViewResult(Intent paramIntent)
  {
    int j = paramIntent.getIntExtra("QWalletPayBridge.PayResult.ExtraKey", 1);
    String str = paramIntent.getStringExtra("result");
    int k = paramIntent.getIntExtra("viewRetCode", -9);
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onOpenTenpayViewResult mOpenViewTag=");
      ((StringBuilder)localObject1).append(this.mOpenViewTag);
      ((StringBuilder)localObject1).append(",nPayResult=");
      ((StringBuilder)localObject1).append(j);
      ((StringBuilder)localObject1).append(",result=");
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append(",viewRetCode=");
      ((StringBuilder)localObject1).append(k);
      QLog.d("Q.qwallet.pay.PayLogic", 2, ((StringBuilder)localObject1).toString());
    }
    Intent localIntent;
    int i;
    if (!TextUtils.isEmpty(str)) {
      try
      {
        localObject1 = new JSONObject(str).optJSONObject("retdata");
        if (localObject1 != null)
        {
          localIntent = new Intent();
          localIntent.putExtra("retdata", ((JSONObject)localObject1).toString());
          i = Integer.valueOf(((JSONObject)localObject1).optString("exec_code", "-1")).intValue();
          if ((i == 1) || (i == 2) || (i == 3))
          {
            this.mActivity.setResult(-1, localIntent);
            end();
            return;
          }
        }
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
    }
    if ((k == 0) && (!TextUtils.isEmpty(str)) && ("hbPackConfirm".equalsIgnoreCase(this.mOpenViewTag))) {}
    for (;;)
    {
      try
      {
        Object localObject2 = new JSONObject(new JSONObject(new JSONObject(str).optString("retmsg")).optString("user_msg"));
        if ((((JSONObject)localObject2).has("uin")) && (((JSONObject)localObject2).has("type")))
        {
          str = ((JSONObject)localObject2).getString("uin");
          i = ((JSONObject)localObject2).getInt("type");
          if (i == 0) {
            break label520;
          }
          if (i == 1) {
            break label513;
          }
          if (i == 2) {
            break label508;
          }
          if (i == 3) {
            break label501;
          }
          if (i == 4) {
            break label494;
          }
          i = -1;
          if (i != -1)
          {
            localObject2 = this.mActivity;
            localIntent = BaseAIOUtils.a(new Intent(), null);
            localIntent.putExtra("uin", str);
            localIntent.putExtra("uintype", i);
            localIntent.putExtra("isBack2Root", true);
            RouteUtils.a((Context)localObject2, localIntent, "/base/start/splash");
          }
        }
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
      if (j == 1)
      {
        paramIntent.putExtra("payRetCode", k);
        tenpayResult(paramIntent.getExtras());
        return;
      }
      paramIntent.putExtra("payRetCode", k);
      paramIntent.putExtra("result", generateTenPayErrorResult());
      tenpayResult(paramIntent.getExtras());
      return;
      label494:
      i = 1004;
      continue;
      label501:
      i = 1000;
      continue;
      label508:
      i = 1;
      continue;
      label513:
      i = 3000;
      continue;
      label520:
      i = 0;
    }
  }
  
  private void onPayResult(Intent paramIntent)
  {
    if (paramIntent.getIntExtra("QWalletPayBridge.PayResult.ExtraKey", 1) == 1)
    {
      tenpayResult(paramIntent.getExtras());
      return;
    }
    paramIntent.putExtra("result", generateTenPayErrorResult());
    tenpayResult(paramIntent.getExtras());
  }
  
  private void onQWalletCrash()
  {
    Object localObject1 = this.intent;
    if (localObject1 == null) {
      return;
    }
    QBaseActivity localQBaseActivity = this.mActivity;
    localObject1 = ((Intent)localObject1).getStringExtra("title");
    Object localObject2 = this.intent.getStringExtra("content");
    String str1 = this.intent.getStringExtra("btn");
    String str2 = this.intent.getStringExtra("url");
    QQCustomDialog localQQCustomDialog = DialogUtil.a(localQBaseActivity, 0);
    localQQCustomDialog.setTitle((String)localObject1);
    localQQCustomDialog.setMessage((CharSequence)localObject2);
    localQQCustomDialog.setCancelable(false);
    localObject2 = new PayLogicImpl.2(this, str2, localQBaseActivity);
    localObject1 = str1;
    if (TextUtils.isEmpty(str1)) {
      localObject1 = localQBaseActivity.getResources().getString(R.string.l);
    }
    localQQCustomDialog.setPositiveButton((String)localObject1, (DialogInterface.OnClickListener)localObject2);
    localQQCustomDialog.show();
  }
  
  /* Error */
  private void openQzoneVipService(Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 220
    //   3: invokevirtual 549	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   6: astore 4
    //   8: aload_1
    //   9: ldc 228
    //   11: invokevirtual 549	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   14: astore 5
    //   16: aload_1
    //   17: ldc_w 1009
    //   20: invokevirtual 549	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   23: astore 6
    //   25: aload_1
    //   26: ldc_w 573
    //   29: invokevirtual 549	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   32: astore 7
    //   34: aload_1
    //   35: ldc_w 577
    //   38: invokevirtual 549	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   41: astore 8
    //   43: aload_1
    //   44: ldc_w 814
    //   47: invokevirtual 549	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   50: astore 9
    //   52: aload_1
    //   53: ldc_w 1011
    //   56: invokevirtual 549	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   59: astore 10
    //   61: aload_1
    //   62: ldc_w 1013
    //   65: invokevirtual 549	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   68: astore 11
    //   70: aload_1
    //   71: ldc_w 553
    //   74: invokevirtual 1014	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   77: istore_2
    //   78: aload_1
    //   79: ldc_w 569
    //   82: invokevirtual 549	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   85: astore 12
    //   87: aload_1
    //   88: ldc_w 571
    //   91: invokevirtual 549	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   94: astore 13
    //   96: aload_1
    //   97: ldc 251
    //   99: invokevirtual 549	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   102: astore 14
    //   104: aload_1
    //   105: ldc 253
    //   107: invokevirtual 549	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   110: astore 15
    //   112: aload_1
    //   113: ldc 255
    //   115: invokevirtual 549	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   118: astore 16
    //   120: aload_1
    //   121: ldc_w 1016
    //   124: iconst_1
    //   125: invokevirtual 556	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   128: istore_3
    //   129: aload_1
    //   130: ldc_w 257
    //   133: invokevirtual 549	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   136: astore 17
    //   138: aload_1
    //   139: ldc 247
    //   141: invokevirtual 549	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   144: astore_1
    //   145: new 265	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   152: astore 18
    //   154: aload 18
    //   156: ldc_w 327
    //   159: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: aload 18
    //   165: invokestatic 332	com/tencent/common/config/AppSetting:d	()I
    //   168: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload 18
    //   174: ldc_w 337
    //   177: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload 18
    //   183: aload_1
    //   184: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload 18
    //   190: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: astore 18
    //   195: aload_0
    //   196: aload 4
    //   198: putfield 502	cooperation/qwallet/plugin/impl/PayLogicImpl:mMidasOfferid	Ljava/lang/String;
    //   201: aload_0
    //   202: aload_1
    //   203: putfield 510	cooperation/qwallet/plugin/impl/PayLogicImpl:mMidasAid	Ljava/lang/String;
    //   206: new 212	android/os/Bundle
    //   209: dup
    //   210: invokespecial 213	android/os/Bundle:<init>	()V
    //   213: astore 19
    //   215: aload 19
    //   217: ldc_w 296
    //   220: ldc_w 298
    //   223: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   226: aload 19
    //   228: ldc_w 300
    //   231: iconst_1
    //   232: invokevirtual 304	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   235: aload 19
    //   237: ldc 220
    //   239: aload 4
    //   241: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   244: aload 10
    //   246: ifnull +20 -> 266
    //   249: aload 10
    //   251: invokevirtual 321	java/lang/String:length	()I
    //   254: ifle +12 -> 266
    //   257: aload 19
    //   259: ldc 245
    //   261: aload 10
    //   263: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   266: aload 9
    //   268: ifnull +21 -> 289
    //   271: aload 9
    //   273: invokevirtual 321	java/lang/String:length	()I
    //   276: ifle +13 -> 289
    //   279: aload 19
    //   281: ldc_w 836
    //   284: aload 9
    //   286: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   289: aload 19
    //   291: ldc 228
    //   293: aload 5
    //   295: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   298: aload 19
    //   300: ldc_w 512
    //   303: aload 6
    //   305: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   308: aload 19
    //   310: ldc_w 339
    //   313: ldc_w 341
    //   316: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   319: aload 19
    //   321: ldc_w 516
    //   324: ldc_w 1009
    //   327: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   330: aload 19
    //   332: ldc_w 325
    //   335: aload 18
    //   337: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   340: aload 19
    //   342: ldc_w 343
    //   345: ldc_w 343
    //   348: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   351: aload 19
    //   353: ldc_w 573
    //   356: aload 7
    //   358: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   361: aload 19
    //   363: ldc_w 577
    //   366: aload 8
    //   368: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   371: aload 19
    //   373: ldc_w 1016
    //   376: iload_3
    //   377: invokevirtual 304	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   380: aload 19
    //   382: ldc_w 345
    //   385: iconst_0
    //   386: invokevirtual 349	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   389: aload 11
    //   391: ifnull +36 -> 427
    //   394: aload 11
    //   396: invokevirtual 321	java/lang/String:length	()I
    //   399: ifle +28 -> 427
    //   402: aload 19
    //   404: ldc_w 551
    //   407: aload 11
    //   409: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   412: aload 19
    //   414: ldc_w 553
    //   417: iload_2
    //   418: invokestatic 312	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   421: invokevirtual 316	java/lang/Boolean:booleanValue	()Z
    //   424: invokevirtual 304	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   427: aload 19
    //   429: ldc_w 583
    //   432: ldc 249
    //   434: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   437: aload 19
    //   439: ldc_w 569
    //   442: aload 12
    //   444: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   447: aload 19
    //   449: ldc_w 571
    //   452: aload 13
    //   454: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   457: aload 19
    //   459: ldc 251
    //   461: aload 14
    //   463: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   466: aload 19
    //   468: ldc 253
    //   470: aload 15
    //   472: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   475: aload 19
    //   477: ldc 255
    //   479: aload 16
    //   481: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   484: aload 19
    //   486: ldc_w 257
    //   489: aload 17
    //   491: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   494: aload 19
    //   496: ldc_w 351
    //   499: iconst_4
    //   500: invokevirtual 349	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   503: aload_0
    //   504: astore_1
    //   505: aload 19
    //   507: ldc_w 353
    //   510: aload_1
    //   511: getfield 148	cooperation/qwallet/plugin/impl/PayLogicImpl:mPayType	I
    //   514: invokevirtual 349	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   517: aload_1
    //   518: aload 19
    //   520: invokespecial 545	cooperation/qwallet/plugin/impl/PayLogicImpl:putProxyReceiverToBundle	(Landroid/os/Bundle;)V
    //   523: aload_1
    //   524: getfield 186	cooperation/qwallet/plugin/impl/PayLogicImpl:mActivity	Lcom/tencent/mobileqq/app/QBaseActivity;
    //   527: aload 19
    //   529: invokestatic 394	cooperation/qwallet/plugin/QWalletPayBridge:launchForeground	(Landroid/app/Activity;Landroid/os/Bundle;)Z
    //   532: pop
    //   533: return
    //   534: astore_1
    //   535: goto +8 -> 543
    //   538: astore_1
    //   539: goto +4 -> 543
    //   542: astore_1
    //   543: invokestatic 401	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   546: ifeq +42 -> 588
    //   549: new 265	java/lang/StringBuilder
    //   552: dup
    //   553: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   556: astore 4
    //   558: aload 4
    //   560: ldc_w 1018
    //   563: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: pop
    //   567: aload 4
    //   569: aload_1
    //   570: invokevirtual 406	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   573: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: pop
    //   577: ldc 226
    //   579: iconst_2
    //   580: aload 4
    //   582: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   585: invokestatic 409	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   588: aload_0
    //   589: bipush 251
    //   591: ldc_w 1020
    //   594: iconst_m1
    //   595: iconst_m1
    //   596: invokespecial 1022	cooperation/qwallet/plugin/impl/PayLogicImpl:onOpenQzoneVipServiceCallBack	(ILjava/lang/String;II)V
    //   599: aload_1
    //   600: invokevirtual 412	java/lang/Exception:printStackTrace	()V
    //   603: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	604	0	this	PayLogicImpl
    //   0	604	1	paramBundle	Bundle
    //   77	341	2	bool1	boolean
    //   128	249	3	bool2	boolean
    //   6	575	4	localObject1	Object
    //   14	280	5	str1	String
    //   23	281	6	str2	String
    //   32	325	7	str3	String
    //   41	326	8	str4	String
    //   50	235	9	str5	String
    //   59	203	10	str6	String
    //   68	340	11	str7	String
    //   85	358	12	str8	String
    //   94	359	13	str9	String
    //   102	360	14	str10	String
    //   110	361	15	str11	String
    //   118	362	16	str12	String
    //   136	354	17	str13	String
    //   152	184	18	localObject2	Object
    //   213	315	19	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   505	533	534	java/lang/Exception
    //   215	244	538	java/lang/Exception
    //   249	266	538	java/lang/Exception
    //   271	289	538	java/lang/Exception
    //   289	389	538	java/lang/Exception
    //   394	427	538	java/lang/Exception
    //   427	503	538	java/lang/Exception
    //   0	215	542	java/lang/Exception
  }
  
  private void openSVip(Bundle paramBundle)
  {
    this.mIsStartReport = true;
    int i;
    Object localObject1;
    if (this.mReportSeq == 0L)
    {
      i = this.mPayType;
      if ((i == -1) || (i == 5) || (i == 2))
      {
        localObject1 = convertToReportAction(this.mRequestCode);
        if (localObject1 != null)
        {
          this.mReportSeq = VACDReportUtil.a(null, "qqwallet", (String)localObject1, "payinvoke", null, 0, null);
          this.mIsStartReport = true;
        }
      }
    }
    String str18 = paramBundle.getString("callbackSn");
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("PayBridgeActivity openSVip request=");
      ((StringBuilder)localObject1).append(paramBundle.toString());
      ((StringBuilder)localObject1).append(",callbackSn=");
      ((StringBuilder)localObject1).append(String.valueOf(str18));
      QLog.i("Q.qwallet.pay.PayLogic", 2, ((StringBuilder)localObject1).toString());
    }
    for (;;)
    {
      try
      {
        Object localObject2 = new JSONObject(paramBundle.getString("json"));
        String str22 = ((JSONObject)localObject2).getString("offerId");
        String str19 = ((JSONObject)localObject2).getString("userId");
        String str20 = ((JSONObject)localObject2).getString("serviceCode");
        try
        {
          String str21 = ((JSONObject)localObject2).getString("serviceName");
          bool1 = ((JSONObject)localObject2).has("channel");
          String str11 = null;
          if (!bool1) {
            break label1529;
          }
          localObject1 = ((JSONObject)localObject2).getString("channel");
          if (!((JSONObject)localObject2).has("unit")) {
            break label1535;
          }
          str1 = ((JSONObject)localObject2).getString("unit");
          if (!((JSONObject)localObject2).has("openMonth")) {
            break label1541;
          }
          str2 = ((JSONObject)localObject2).getString("openMonth");
          if (!((JSONObject)localObject2).has("isCanChange")) {
            break label1547;
          }
          bool1 = ((JSONObject)localObject2).getBoolean("isCanChange");
          if (!((JSONObject)localObject2).has("isAutoPay")) {
            break label1553;
          }
          bool2 = ((JSONObject)localObject2).getBoolean("isAutoPay");
          boolean bool3 = ((JSONObject)localObject2).has("remark");
          String str17 = "";
          if (!bool3) {
            break label1559;
          }
          str3 = ((JSONObject)localObject2).getString("remark");
          if (!((JSONObject)localObject2).has("aid")) {
            break label1566;
          }
          str4 = ((JSONObject)localObject2).getString("aid");
          if (!((JSONObject)localObject2).has("actTitle")) {
            break label1573;
          }
          str5 = ((JSONObject)localObject2).getString("actTitle");
          if (!((JSONObject)localObject2).has("openType")) {
            break label1580;
          }
          i = ((JSONObject)localObject2).getInt("openType");
          if (!((JSONObject)localObject2).has("actHint")) {
            break label1585;
          }
          str6 = ((JSONObject)localObject2).getString("actHint");
          if (!((JSONObject)localObject2).has("actPayTotal")) {
            break label1591;
          }
          str7 = ((JSONObject)localObject2).getString("actPayTotal");
          if (!((JSONObject)localObject2).has("actPayDiscount")) {
            break label1597;
          }
          str8 = ((JSONObject)localObject2).getString("actPayDiscount");
          if (!((JSONObject)localObject2).has("actBtnTitle")) {
            break label1603;
          }
          str9 = ((JSONObject)localObject2).getString("actBtnTitle");
          if (!((JSONObject)localObject2).has("openServicePrice")) {
            break label1609;
          }
          str10 = ((JSONObject)localObject2).getString("openServicePrice");
          if (((JSONObject)localObject2).has("upgradeServicePrice")) {
            str11 = ((JSONObject)localObject2).getString("upgradeServicePrice");
          }
          if (!((JSONObject)localObject2).has("maxUpgradeMonth")) {
            break label1615;
          }
          j = ((JSONObject)localObject2).getInt("maxUpgradeMonth");
          if (!((JSONObject)localObject2).has("openTitle")) {
            break label1620;
          }
          str12 = ((JSONObject)localObject2).getString("openTitle");
          if (!((JSONObject)localObject2).has("upgradeTitle")) {
            break label1627;
          }
          str13 = ((JSONObject)localObject2).getString("upgradeTitle");
          if (!((JSONObject)localObject2).has("discountId")) {
            break label1634;
          }
          str14 = ((JSONObject)localObject2).getString("discountId");
          if (!((JSONObject)localObject2).has("other")) {
            break label1641;
          }
          str15 = ((JSONObject)localObject2).getString("other");
          if (!((JSONObject)localObject2).has("payload")) {
            break label1648;
          }
          str16 = ((JSONObject)localObject2).getString("payload");
          if (((JSONObject)localObject2).has("couponId")) {
            str17 = ((JSONObject)localObject2).getString("couponId");
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("json=");
          ((StringBuilder)localObject2).append(paramBundle.getString("json"));
          paramBundle = paramBundle.getString("payparmas_h5_url");
          if (!TextUtils.isEmpty(paramBundle))
          {
            ((StringBuilder)localObject2).append("&url=");
            ((StringBuilder)localObject2).append(paramBundle);
          }
          VACDReportUtil.a(this.mReportSeq, null, "parseurl", ((StringBuilder)localObject2).toString(), 0, null);
          this.mMidasOfferid = str22;
          this.mMidasAid = str4;
          paramBundle = new Bundle();
          paramBundle.putString("offerId", str22);
          paramBundle.putString("setEnv", "release");
          paramBundle.putBoolean("setLogEnable", false);
          if ((str1 != null) && (str1.length() > 0)) {
            paramBundle.putString("unit", str1);
          }
          if ((localObject1 != null) && (((String)localObject1).length() > 0)) {
            paramBundle.putString("payChannel", (String)localObject1);
          }
          paramBundle.putString("callbackSn", str18);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("qq_m_qq-2013-android-");
          ((StringBuilder)localObject1).append(AppSetting.d());
          ((StringBuilder)localObject1).append("-");
          ((StringBuilder)localObject1).append(str4);
          localObject1 = ((StringBuilder)localObject1).toString();
          paramBundle.putString("userId", str19);
          paramBundle.putString("sessionId", "uin");
          paramBundle.putString("pf", (String)localObject1);
          paramBundle.putString("pfKey", "pfKey");
          paramBundle.putString("serviceCode", str20);
          paramBundle.putString("serviceName", str21);
          paramBundle.putInt("resId", 0);
          if ((str2 != null) && (str2.length() > 0))
          {
            paramBundle.putString("openMonth", str2);
            paramBundle.putBoolean("isCanChange", Boolean.valueOf(bool1).booleanValue());
          }
          paramBundle.putBoolean("isAutoPay", Boolean.valueOf(bool2).booleanValue());
          paramBundle.putString("remark", str3);
          paramBundle.putString("actTitle", str5);
          paramBundle.putInt("openType", i);
          paramBundle.putString("actHint", str6);
          paramBundle.putString("actPayTotal", str7);
          paramBundle.putString("actPayDiscount", str8);
          paramBundle.putString("actBtnTitle", str9);
          paramBundle.putString("openServicePrice", str10);
          paramBundle.putString("upgradeServicePrice", str11);
          paramBundle.putInt("maxUpgradeMonth", j);
          paramBundle.putString("openTitle", str12);
          paramBundle.putString("upgradeTitle", str13);
          paramBundle.putString("discountId", str14);
          paramBundle.putString("other", str15);
          paramBundle.putString("payload", str16);
          paramBundle.putString("couponId", str17);
          paramBundle.putInt("PayInvokerId", 11);
          paramBundle.putInt("payparmas_paytype", this.mPayType);
          paramBundle.putLong("payparmas_h5_start", this.mPayH5StartTime);
          paramBundle.putLong("vacreport_key_seq", this.mReportSeq);
          VACDReportUtil.a(this.mReportSeq, null, "loadPluginStart", null, 0, null);
          if (QLog.isDevelopLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("PayBridgeActivity-loadPluginStart=");
            ((StringBuilder)localObject1).append(System.currentTimeMillis());
            QLog.d("loadQWalletPlugin", 4, ((StringBuilder)localObject1).toString());
          }
          putProxyReceiverToBundle(paramBundle);
          QWalletPayBridge.launchForeground(this.mActivity, paramBundle);
          return;
        }
        catch (Exception paramBundle) {}catch (JSONException paramBundle) {}
        if (!QLog.isColorLevel()) {
          break label1477;
        }
      }
      catch (Exception paramBundle)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("openSVip Exception:");
          ((StringBuilder)localObject1).append(paramBundle.getMessage());
          QLog.e("Q.qwallet.pay.PayLogic", 2, ((StringBuilder)localObject1).toString());
        }
        paramBundle = new Bundle();
        paramBundle.putString("callbackSn", str18);
        paramBundle.putString("result", "{'resultCode':-1,'resultMsg':'openSVip Exception'}");
        paramBundle.putInt("payRetCode", -1);
        paramBundle.putLong("reportSeq", this.mReportSeq);
        tenpayResult(paramBundle);
        return;
      }
      catch (JSONException paramBundle) {}
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("openSVip JSONException:");
      ((StringBuilder)localObject1).append(paramBundle.getMessage());
      QLog.e("Q.qwallet.pay.PayLogic", 2, ((StringBuilder)localObject1).toString());
      label1477:
      paramBundle = new Bundle();
      paramBundle.putString("callbackSn", str18);
      paramBundle.putString("result", "{'resultCode':-1,'resultMsg':'openSVip JSONException'}");
      paramBundle.putInt("payRetCode", -1);
      paramBundle.putLong("reportSeq", this.mReportSeq);
      tenpayResult(paramBundle);
      return;
      label1529:
      localObject1 = null;
      continue;
      label1535:
      String str1 = null;
      continue;
      label1541:
      String str2 = null;
      continue;
      label1547:
      boolean bool1 = true;
      continue;
      label1553:
      boolean bool2 = true;
      continue;
      label1559:
      String str3 = "";
      continue;
      label1566:
      String str4 = "";
      continue;
      label1573:
      String str5 = "";
      continue;
      label1580:
      i = 0;
      continue;
      label1585:
      String str6 = null;
      continue;
      label1591:
      String str7 = null;
      continue;
      label1597:
      String str8 = null;
      continue;
      label1603:
      String str9 = null;
      continue;
      label1609:
      String str10 = null;
      continue;
      label1615:
      int j = 0;
      continue;
      label1620:
      String str12 = "";
      continue;
      label1627:
      String str13 = "";
      continue;
      label1634:
      String str14 = "";
      continue;
      label1641:
      String str15 = "";
      continue;
      label1648:
      String str16 = "";
    }
  }
  
  /* Error */
  protected static Bundle openService(AppInterface paramAppInterface, Activity paramActivity, ResultReceiver paramResultReceiver, String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2, String paramString3)
  {
    // Byte code:
    //   0: new 212	android/os/Bundle
    //   3: dup
    //   4: invokespecial 213	android/os/Bundle:<init>	()V
    //   7: astore_0
    //   8: new 215	org/json/JSONObject
    //   11: dup
    //   12: aload 4
    //   14: invokespecial 218	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   17: astore 32
    //   19: aload 32
    //   21: ldc 220
    //   23: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   26: astore 28
    //   28: aload 32
    //   30: ldc 228
    //   32: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   35: astore 29
    //   37: aload 32
    //   39: ldc_w 573
    //   42: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   45: astore 30
    //   47: aload 32
    //   49: ldc_w 577
    //   52: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   55: astore 31
    //   57: aload 32
    //   59: ldc_w 814
    //   62: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   65: ifeq +1134 -> 1199
    //   68: aload 32
    //   70: ldc_w 814
    //   73: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   76: astore 13
    //   78: goto +3 -> 81
    //   81: aload 32
    //   83: ldc 245
    //   85: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   88: ifeq +1117 -> 1205
    //   91: aload 32
    //   93: ldc 245
    //   95: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   98: astore 14
    //   100: goto +3 -> 103
    //   103: aload 13
    //   105: astore 27
    //   107: aload 32
    //   109: ldc_w 1013
    //   112: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   115: ifeq +1096 -> 1211
    //   118: aload 32
    //   120: ldc_w 1013
    //   123: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   126: astore 13
    //   128: goto +3 -> 131
    //   131: aload 32
    //   133: ldc_w 553
    //   136: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   139: ifeq +1078 -> 1217
    //   142: aload 32
    //   144: ldc_w 553
    //   147: invokevirtual 243	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   150: istore 11
    //   152: goto +3 -> 155
    //   155: aload 32
    //   157: ldc_w 583
    //   160: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   163: istore 12
    //   165: ldc 249
    //   167: astore 26
    //   169: iload 12
    //   171: ifeq +1052 -> 1223
    //   174: aload 32
    //   176: ldc_w 583
    //   179: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   182: astore 15
    //   184: goto +3 -> 187
    //   187: aload 32
    //   189: ldc_w 569
    //   192: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   195: ifeq +1035 -> 1230
    //   198: aload 32
    //   200: ldc_w 569
    //   203: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   206: astore 16
    //   208: goto +3 -> 211
    //   211: aload 32
    //   213: ldc_w 571
    //   216: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   219: ifeq +1017 -> 1236
    //   222: aload 32
    //   224: ldc_w 571
    //   227: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   230: astore 17
    //   232: goto +3 -> 235
    //   235: aload 32
    //   237: ldc 251
    //   239: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   242: ifeq +1000 -> 1242
    //   245: aload 32
    //   247: ldc 251
    //   249: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   252: astore 18
    //   254: goto +3 -> 257
    //   257: aload 32
    //   259: ldc 253
    //   261: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   264: ifeq +985 -> 1249
    //   267: aload 32
    //   269: ldc 253
    //   271: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   274: astore 19
    //   276: goto +3 -> 279
    //   279: aload 32
    //   281: ldc 255
    //   283: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   286: ifeq +970 -> 1256
    //   289: aload 32
    //   291: ldc 255
    //   293: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   296: astore 20
    //   298: goto +3 -> 301
    //   301: aload 32
    //   303: ldc_w 1016
    //   306: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   309: ifeq +954 -> 1263
    //   312: aload 32
    //   314: ldc_w 1016
    //   317: invokevirtual 243	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   320: istore 12
    //   322: goto +3 -> 325
    //   325: aload 32
    //   327: ldc 247
    //   329: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   332: ifeq +937 -> 1269
    //   335: aload 32
    //   337: ldc 247
    //   339: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   342: astore 21
    //   344: goto +3 -> 347
    //   347: aload 32
    //   349: ldc_w 1059
    //   352: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   355: ifeq +921 -> 1276
    //   358: aload 32
    //   360: ldc_w 1059
    //   363: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   366: astore 22
    //   368: goto +3 -> 371
    //   371: aload 32
    //   373: ldc_w 1071
    //   376: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   379: ifeq +904 -> 1283
    //   382: aload 32
    //   384: ldc_w 1073
    //   387: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   390: ifeq +893 -> 1283
    //   393: aload 32
    //   395: ldc_w 1071
    //   398: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   401: astore 24
    //   403: aload 32
    //   405: ldc_w 1073
    //   408: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   411: astore 23
    //   413: goto +3 -> 416
    //   416: aload 32
    //   418: ldc_w 325
    //   421: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   424: ifeq +16 -> 440
    //   427: aload 32
    //   429: ldc_w 325
    //   432: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   435: astore 25
    //   437: goto +54 -> 491
    //   440: new 265	java/lang/StringBuilder
    //   443: dup
    //   444: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   447: astore 25
    //   449: aload 25
    //   451: ldc_w 327
    //   454: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: pop
    //   458: aload 25
    //   460: invokestatic 332	com/tencent/common/config/AppSetting:d	()I
    //   463: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   466: pop
    //   467: aload 25
    //   469: ldc_w 337
    //   472: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: pop
    //   476: aload 25
    //   478: aload 21
    //   480: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: pop
    //   484: aload 25
    //   486: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   489: astore 25
    //   491: aload 32
    //   493: ldc_w 257
    //   496: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   499: ifeq +13 -> 512
    //   502: aload 32
    //   504: ldc_w 257
    //   507: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   510: astore 26
    //   512: new 265	java/lang/StringBuilder
    //   515: dup
    //   516: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   519: astore 32
    //   521: aload 32
    //   523: ldc_w 268
    //   526: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: pop
    //   530: aload 32
    //   532: aload 4
    //   534: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: pop
    //   538: aload 10
    //   540: invokestatic 277	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   543: ifne +20 -> 563
    //   546: aload 32
    //   548: ldc_w 279
    //   551: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: pop
    //   555: aload 32
    //   557: aload 10
    //   559: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: pop
    //   563: lload 8
    //   565: aconst_null
    //   566: ldc_w 281
    //   569: aload 32
    //   571: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   574: iconst_0
    //   575: aconst_null
    //   576: invokestatic 290	com/tencent/mobileqq/qwallet/report/VACDReportUtil:a	(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   579: new 212	android/os/Bundle
    //   582: dup
    //   583: invokespecial 213	android/os/Bundle:<init>	()V
    //   586: astore 4
    //   588: aload 4
    //   590: ldc 220
    //   592: aload 28
    //   594: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   597: aload 4
    //   599: ldc_w 296
    //   602: ldc_w 298
    //   605: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   608: aload 4
    //   610: ldc_w 300
    //   613: iconst_0
    //   614: invokevirtual 304	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   617: aload 14
    //   619: ifnull +20 -> 639
    //   622: aload 14
    //   624: invokevirtual 321	java/lang/String:length	()I
    //   627: ifle +12 -> 639
    //   630: aload 4
    //   632: ldc 245
    //   634: aload 14
    //   636: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   639: aload 27
    //   641: ifnull +21 -> 662
    //   644: aload 27
    //   646: invokevirtual 321	java/lang/String:length	()I
    //   649: ifle +13 -> 662
    //   652: aload 4
    //   654: ldc_w 836
    //   657: aload 27
    //   659: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   662: aload 4
    //   664: ldc_w 323
    //   667: aload_3
    //   668: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   671: aload 4
    //   673: ldc 228
    //   675: aload 29
    //   677: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   680: aload 23
    //   682: ifnull +23 -> 705
    //   685: aload 4
    //   687: ldc_w 516
    //   690: aload 24
    //   692: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   695: aload 4
    //   697: ldc_w 512
    //   700: aload 23
    //   702: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   705: aload 4
    //   707: ldc_w 339
    //   710: ldc_w 341
    //   713: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   716: aload 4
    //   718: ldc_w 325
    //   721: aload 25
    //   723: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   726: aload 4
    //   728: ldc_w 343
    //   731: ldc_w 343
    //   734: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   737: aload 4
    //   739: ldc_w 573
    //   742: aload 30
    //   744: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   747: aload 4
    //   749: ldc_w 577
    //   752: aload 31
    //   754: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   757: aload 4
    //   759: ldc_w 345
    //   762: iconst_0
    //   763: invokevirtual 349	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   766: aload 13
    //   768: ifnull +37 -> 805
    //   771: aload 13
    //   773: invokevirtual 321	java/lang/String:length	()I
    //   776: ifle +29 -> 805
    //   779: aload 4
    //   781: ldc_w 551
    //   784: aload 13
    //   786: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   789: aload 4
    //   791: ldc_w 553
    //   794: iload 11
    //   796: invokestatic 312	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   799: invokevirtual 316	java/lang/Boolean:booleanValue	()Z
    //   802: invokevirtual 304	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   805: aload 4
    //   807: ldc_w 583
    //   810: aload 15
    //   812: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   815: aload 4
    //   817: ldc_w 569
    //   820: aload 16
    //   822: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   825: aload 4
    //   827: ldc_w 571
    //   830: aload 17
    //   832: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   835: aload 4
    //   837: ldc 251
    //   839: aload 18
    //   841: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   844: aload 4
    //   846: ldc 253
    //   848: aload 19
    //   850: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   853: aload 4
    //   855: ldc 255
    //   857: aload 20
    //   859: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   862: aload 4
    //   864: ldc_w 1016
    //   867: iload 12
    //   869: invokestatic 312	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   872: invokevirtual 316	java/lang/Boolean:booleanValue	()Z
    //   875: invokevirtual 304	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   878: aload 4
    //   880: ldc_w 1059
    //   883: aload 22
    //   885: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   888: aload 4
    //   890: ldc_w 257
    //   893: aload 26
    //   895: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   898: aload 4
    //   900: ldc_w 351
    //   903: iconst_4
    //   904: invokevirtual 349	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   907: aload 4
    //   909: ldc_w 353
    //   912: iload 5
    //   914: invokevirtual 349	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   917: aload 4
    //   919: ldc_w 355
    //   922: lload 6
    //   924: invokevirtual 359	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   927: aload 4
    //   929: ldc_w 361
    //   932: lload 8
    //   934: invokevirtual 359	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   937: aload_2
    //   938: aload 4
    //   940: invokestatic 365	cooperation/qwallet/plugin/impl/PayLogicImpl:setIPCReceiver	(Landroid/os/ResultReceiver;Landroid/os/Bundle;)V
    //   943: lload 8
    //   945: aconst_null
    //   946: ldc_w 367
    //   949: aconst_null
    //   950: iconst_0
    //   951: aconst_null
    //   952: invokestatic 290	com/tencent/mobileqq/qwallet/report/VACDReportUtil:a	(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   955: invokestatic 372	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   958: ifeq +38 -> 996
    //   961: new 265	java/lang/StringBuilder
    //   964: dup
    //   965: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   968: astore_2
    //   969: aload_2
    //   970: ldc_w 374
    //   973: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   976: pop
    //   977: aload_2
    //   978: invokestatic 380	java/lang/System:currentTimeMillis	()J
    //   981: invokevirtual 383	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   984: pop
    //   985: ldc_w 385
    //   988: iconst_4
    //   989: aload_2
    //   990: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   993: invokestatic 388	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   996: aload_1
    //   997: aload 4
    //   999: invokestatic 394	cooperation/qwallet/plugin/QWalletPayBridge:launchForeground	(Landroid/app/Activity;Landroid/os/Bundle;)Z
    //   1002: pop
    //   1003: aload_0
    //   1004: astore_1
    //   1005: aload_1
    //   1006: ldc_w 396
    //   1009: iconst_0
    //   1010: invokevirtual 349	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1013: aload_1
    //   1014: ldc 220
    //   1016: aload 28
    //   1018: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1021: aload_1
    //   1022: ldc 247
    //   1024: aload 21
    //   1026: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1029: aload_1
    //   1030: areturn
    //   1031: astore_1
    //   1032: goto +24 -> 1056
    //   1035: astore_1
    //   1036: goto +92 -> 1128
    //   1039: astore_1
    //   1040: goto +16 -> 1056
    //   1043: astore_1
    //   1044: goto +84 -> 1128
    //   1047: astore_1
    //   1048: goto +8 -> 1056
    //   1051: astore_1
    //   1052: goto +76 -> 1128
    //   1055: astore_1
    //   1056: invokestatic 401	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1059: ifeq +38 -> 1097
    //   1062: new 265	java/lang/StringBuilder
    //   1065: dup
    //   1066: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   1069: astore_2
    //   1070: aload_2
    //   1071: ldc_w 1018
    //   1074: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1077: pop
    //   1078: aload_2
    //   1079: aload_1
    //   1080: invokevirtual 406	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1083: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1086: pop
    //   1087: ldc 226
    //   1089: iconst_2
    //   1090: aload_2
    //   1091: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1094: invokestatic 409	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1097: invokestatic 372	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1100: ifeq +7 -> 1107
    //   1103: aload_1
    //   1104: invokevirtual 412	java/lang/Exception:printStackTrace	()V
    //   1107: aload_0
    //   1108: ldc_w 396
    //   1111: iconst_m1
    //   1112: invokevirtual 349	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1115: aload_0
    //   1116: ldc_w 414
    //   1119: ldc_w 1075
    //   1122: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1125: aload_0
    //   1126: areturn
    //   1127: astore_1
    //   1128: invokestatic 401	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1131: ifeq +38 -> 1169
    //   1134: new 265	java/lang/StringBuilder
    //   1137: dup
    //   1138: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   1141: astore_2
    //   1142: aload_2
    //   1143: ldc_w 1077
    //   1146: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1149: pop
    //   1150: aload_2
    //   1151: aload_1
    //   1152: invokevirtual 419	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   1155: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1158: pop
    //   1159: ldc 226
    //   1161: iconst_2
    //   1162: aload_2
    //   1163: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1166: invokestatic 409	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1169: invokestatic 372	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1172: ifeq +7 -> 1179
    //   1175: aload_1
    //   1176: invokevirtual 420	org/json/JSONException:printStackTrace	()V
    //   1179: aload_0
    //   1180: ldc_w 396
    //   1183: iconst_m1
    //   1184: invokevirtual 349	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1187: aload_0
    //   1188: ldc_w 414
    //   1191: ldc_w 1079
    //   1194: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1197: aload_0
    //   1198: areturn
    //   1199: aconst_null
    //   1200: astore 13
    //   1202: goto -1121 -> 81
    //   1205: aconst_null
    //   1206: astore 14
    //   1208: goto -1105 -> 103
    //   1211: aconst_null
    //   1212: astore 13
    //   1214: goto -1083 -> 131
    //   1217: iconst_1
    //   1218: istore 11
    //   1220: goto -1065 -> 155
    //   1223: ldc 249
    //   1225: astore 15
    //   1227: goto -1040 -> 187
    //   1230: aconst_null
    //   1231: astore 16
    //   1233: goto -1022 -> 211
    //   1236: aconst_null
    //   1237: astore 17
    //   1239: goto -1004 -> 235
    //   1242: ldc 249
    //   1244: astore 18
    //   1246: goto -989 -> 257
    //   1249: ldc 249
    //   1251: astore 19
    //   1253: goto -974 -> 279
    //   1256: ldc 249
    //   1258: astore 20
    //   1260: goto -959 -> 301
    //   1263: iconst_1
    //   1264: istore 12
    //   1266: goto -941 -> 325
    //   1269: ldc 249
    //   1271: astore 21
    //   1273: goto -926 -> 347
    //   1276: ldc 249
    //   1278: astore 22
    //   1280: goto -909 -> 371
    //   1283: aconst_null
    //   1284: astore 23
    //   1286: aload 23
    //   1288: astore 24
    //   1290: goto -874 -> 416
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1293	0	paramAppInterface	AppInterface
    //   0	1293	1	paramActivity	Activity
    //   0	1293	2	paramResultReceiver	ResultReceiver
    //   0	1293	3	paramString1	String
    //   0	1293	4	paramString2	String
    //   0	1293	5	paramInt	int
    //   0	1293	6	paramLong1	long
    //   0	1293	8	paramLong2	long
    //   0	1293	10	paramString3	String
    //   150	1069	11	bool1	boolean
    //   163	1102	12	bool2	boolean
    //   76	1137	13	str1	String
    //   98	1109	14	str2	String
    //   182	1044	15	str3	String
    //   206	1026	16	str4	String
    //   230	1008	17	str5	String
    //   252	993	18	str6	String
    //   274	978	19	str7	String
    //   296	963	20	str8	String
    //   342	930	21	str9	String
    //   366	913	22	str10	String
    //   411	876	23	str11	String
    //   401	888	24	localObject1	Object
    //   435	287	25	localObject2	Object
    //   167	727	26	str12	String
    //   105	553	27	str13	String
    //   26	991	28	str14	String
    //   35	641	29	str15	String
    //   45	698	30	str16	String
    //   55	698	31	str17	String
    //   17	553	32	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   1005	1029	1031	java/lang/Exception
    //   1005	1029	1035	org/json/JSONException
    //   28	78	1039	java/lang/Exception
    //   81	100	1039	java/lang/Exception
    //   107	128	1039	java/lang/Exception
    //   131	152	1039	java/lang/Exception
    //   155	165	1039	java/lang/Exception
    //   174	184	1039	java/lang/Exception
    //   187	208	1039	java/lang/Exception
    //   211	232	1039	java/lang/Exception
    //   235	254	1039	java/lang/Exception
    //   257	276	1039	java/lang/Exception
    //   279	298	1039	java/lang/Exception
    //   301	322	1039	java/lang/Exception
    //   325	344	1039	java/lang/Exception
    //   347	368	1039	java/lang/Exception
    //   371	413	1039	java/lang/Exception
    //   416	437	1039	java/lang/Exception
    //   440	491	1039	java/lang/Exception
    //   491	512	1039	java/lang/Exception
    //   512	563	1039	java/lang/Exception
    //   563	617	1039	java/lang/Exception
    //   622	639	1039	java/lang/Exception
    //   644	662	1039	java/lang/Exception
    //   662	680	1039	java/lang/Exception
    //   685	705	1039	java/lang/Exception
    //   705	766	1039	java/lang/Exception
    //   771	805	1039	java/lang/Exception
    //   805	996	1039	java/lang/Exception
    //   996	1003	1039	java/lang/Exception
    //   28	78	1043	org/json/JSONException
    //   81	100	1043	org/json/JSONException
    //   107	128	1043	org/json/JSONException
    //   131	152	1043	org/json/JSONException
    //   155	165	1043	org/json/JSONException
    //   174	184	1043	org/json/JSONException
    //   187	208	1043	org/json/JSONException
    //   211	232	1043	org/json/JSONException
    //   235	254	1043	org/json/JSONException
    //   257	276	1043	org/json/JSONException
    //   279	298	1043	org/json/JSONException
    //   301	322	1043	org/json/JSONException
    //   325	344	1043	org/json/JSONException
    //   347	368	1043	org/json/JSONException
    //   371	413	1043	org/json/JSONException
    //   416	437	1043	org/json/JSONException
    //   440	491	1043	org/json/JSONException
    //   491	512	1043	org/json/JSONException
    //   512	563	1043	org/json/JSONException
    //   563	617	1043	org/json/JSONException
    //   622	639	1043	org/json/JSONException
    //   644	662	1043	org/json/JSONException
    //   662	680	1043	org/json/JSONException
    //   685	705	1043	org/json/JSONException
    //   705	766	1043	org/json/JSONException
    //   771	805	1043	org/json/JSONException
    //   805	996	1043	org/json/JSONException
    //   996	1003	1043	org/json/JSONException
    //   19	28	1047	java/lang/Exception
    //   19	28	1051	org/json/JSONException
    //   8	19	1055	java/lang/Exception
    //   8	19	1127	org/json/JSONException
  }
  
  private void openTenpayView(Bundle paramBundle)
  {
    QBaseActivity localQBaseActivity = this.mActivity;
    String str2 = paramBundle.getString("callbackSn");
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("PayBridgeActivity openTenpayView request=");
      ((StringBuilder)localObject1).append(paramBundle.toString());
      ((StringBuilder)localObject1).append(",callbackSn=");
      ((StringBuilder)localObject1).append(String.valueOf(str2));
      QLog.i("Q.qwallet.pay.PayLogic", 2, ((StringBuilder)localObject1).toString());
    }
    int i;
    try
    {
      localJSONObject = new JSONObject(paramBundle.getString("json"));
      localObject1 = localJSONObject.optString("userId");
      boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
      if (!bool)
      {
        localObject2 = localObject1;
        if (!((String)localObject1).startsWith("0")) {}
      }
      else
      {
        localObject2 = this.app.getCurrentUin();
      }
      str3 = localJSONObject.getString("viewTag");
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("openTenpayView json = ");
        ((StringBuilder)localObject1).append(localJSONObject);
        QLog.i(str3, 2, ((StringBuilder)localObject1).toString());
      }
      if ((str3 != null) && (allowView.contains(str3)))
      {
        i = "transfer".compareTo(str3);
        localObject1 = "";
        if ((i != 0) && ("transferInput".compareTo(str3) != 0))
        {
          if ("makeHongbao".compareTo(str3) == 0)
          {
            localObject2 = localJSONObject.optJSONObject("extra_data");
            if (localObject2 != null)
            {
              localObject3 = ((JSONObject)localObject2).optString("hb_from_type", "0");
              if ((!((String)localObject3).equals("0")) && (!((String)localObject3).equals("1")) && (!((String)localObject3).equals("2")) && (!((String)localObject3).equals("100")))
              {
                tenpayResult(str2, "{'resultCode':-1001,'retmsg':'hb_from_type参数错误'}");
                return;
              }
              if (((String)localObject3).equals("0"))
              {
                if (((JSONObject)localObject2).has("hb_from")) {
                  ((JSONObject)localObject2).remove("hb_from");
                }
                if (((JSONObject)localObject2).has("makeHb_type")) {
                  ((JSONObject)localObject2).remove("makeHb_type");
                }
                if (((JSONObject)localObject2).has("skin_id")) {
                  ((JSONObject)localObject2).remove("skin_id");
                }
                if (((JSONObject)localObject2).has("feedsid")) {
                  ((JSONObject)localObject2).remove("feedsid");
                }
                if (((JSONObject)localObject2).has("total_amount")) {
                  ((JSONObject)localObject2).remove("total_amount");
                }
                if (((JSONObject)localObject2).has("total_num")) {
                  ((JSONObject)localObject2).remove("total_num");
                }
                if (((JSONObject)localObject2).has("wishing")) {
                  ((JSONObject)localObject2).remove("wishing");
                }
                if (((JSONObject)localObject2).has("biz_params")) {
                  ((JSONObject)localObject2).remove("biz_params");
                }
                localObject2 = new Intent();
                ((Intent)localObject2).putExtra("callbackSn", str2);
                ((Intent)localObject2).putExtra("come_from", 2);
                ((Intent)localObject2).putExtra("is_H5", true);
                if (!localJSONObject.has("appInfo")) {
                  break label2349;
                }
                paramBundle = localJSONObject.getString("appInfo");
                ((Intent)localObject2).putExtra("app_info", paramBundle);
                if (localJSONObject.has("extra_data")) {
                  localObject1 = localJSONObject.getString("extra_data");
                }
                ((Intent)localObject2).putExtra("extra_data", (String)localObject1);
                ((Intent)localObject2).putExtra("vacreport_key_seq", VACDReportUtil.a(null, "qqwallet", "makeHongbao", "click", "is_H5=true", 0, null));
                RouteUtils.a(localQBaseActivity, (Intent)localObject2, "/qwallet/redpacket/sendhb", 5);
                return;
              }
              if (((String)localObject3).equals("100"))
              {
                ((JSONObject)localObject2).put("domain", paramBundle.getString("h5_common_redpacket_domain"));
                paramBundle = ((JSONObject)localObject2).optJSONObject("selector");
                if (paramBundle != null)
                {
                  i = paramBundle.optInt("type");
                  if (i == 0)
                  {
                    paramBundle = new Intent();
                    paramBundle.putExtra("callbackSn", str2);
                    paramBundle.putExtra("come_from", 2);
                    paramBundle.putExtra("is_H5", true);
                    paramBundle.putExtra("extra_data", ((JSONObject)localObject2).toString());
                    paramBundle.putExtra("forward_type", 18);
                    RouteUtils.a(localQBaseActivity, paramBundle, "/base/forwardRecent", 5);
                    return;
                  }
                  if (i == 1)
                  {
                    localObject2 = new Intent();
                    ((Intent)localObject2).putExtra("callbackSn", str2);
                    ((Intent)localObject2).putExtra("come_from", 2);
                    ((Intent)localObject2).putExtra("is_H5", true);
                    if (!localJSONObject.has("appInfo")) {
                      break label2355;
                    }
                    paramBundle = localJSONObject.getString("appInfo");
                    label835:
                    ((Intent)localObject2).putExtra("app_info", paramBundle);
                    if (localJSONObject.has("extra_data")) {
                      localObject1 = localJSONObject.getString("extra_data");
                    }
                    ((Intent)localObject2).putExtra("extra_data", (String)localObject1);
                    ((Intent)localObject2).putExtra("vacreport_key_seq", VACDReportUtil.a(null, "qqwallet", "makeHongbao", "click", "is_H5=true", 0, null));
                    RouteUtils.a(localQBaseActivity, (Intent)localObject2, "/qwallet/redpacket/sendhb", 5);
                    return;
                  }
                  if (i == 2)
                  {
                    localObject2 = new Intent();
                    ((Intent)localObject2).putExtra("callbackSn", str2);
                    ((Intent)localObject2).putExtra("come_from", 2);
                    ((Intent)localObject2).putExtra("is_H5", true);
                    if (!localJSONObject.has("appInfo")) {
                      break label2361;
                    }
                    paramBundle = localJSONObject.getString("appInfo");
                    label983:
                    ((Intent)localObject2).putExtra("app_info", paramBundle);
                    if (localJSONObject.has("extra_data")) {
                      localObject1 = localJSONObject.getString("extra_data");
                    }
                    ((Intent)localObject2).putExtra("extra_data", (String)localObject1);
                    ((Intent)localObject2).putExtra("vacreport_key_seq", VACDReportUtil.a(null, "qqwallet", "makeHongbao", "click", "is_H5=true", 0, null));
                    RouteUtils.a(localQBaseActivity, (Intent)localObject2, "/qwallet/redpacket/sendhb", 5);
                  }
                }
              }
              else if (((JSONObject)localObject2).optJSONObject("extra_info") != null)
              {
                paramBundle = new Intent();
                paramBundle.putExtra("callbackSn", str2);
                paramBundle.putExtra("come_from", 2);
                paramBundle.putExtra("is_H5", true);
                paramBundle.putExtra("extra_data", ((JSONObject)localObject2).toString());
                paramBundle.putExtra("forward_type", 18);
                RouteUtils.a(localQBaseActivity, paramBundle, "/base/forwardRecent", 5);
                return;
              }
            }
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("callbackSn", str2);
            ((Intent)localObject2).putExtra("come_from", 2);
            ((Intent)localObject2).putExtra("is_H5", true);
            if (!localJSONObject.has("appInfo")) {
              break label2367;
            }
            paramBundle = localJSONObject.getString("appInfo");
            label1207:
            ((Intent)localObject2).putExtra("app_info", paramBundle);
            if (localJSONObject.has("extra_data")) {
              localObject1 = localJSONObject.getString("extra_data");
            }
            ((Intent)localObject2).putExtra("extra_data", (String)localObject1);
            ((Intent)localObject2).putExtra("vacreport_key_seq", VACDReportUtil.a(null, "qqwallet", "makeHongbao", "click", "is_H5=true", 0, null));
            RouteUtils.a(localQBaseActivity, (Intent)localObject2, "/qwallet/redpacket/sendhb", 5);
            return;
          }
          i = "parseqrcode".compareTo(str3);
          if (i == 0)
          {
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("callbackSn", str2);
            if (!localJSONObject.has("comeForm")) {
              break label2373;
            }
            i = localJSONObject.getInt("comeForm");
            label1342:
            ((Intent)localObject2).putExtra("come_from", i);
            if (!localJSONObject.has("appInfo")) {
              break label2378;
            }
            paramBundle = localJSONObject.getString("appInfo");
            label1375:
            ((Intent)localObject2).putExtra("app_info", paramBundle);
            if (localJSONObject.has("extra_data")) {
              localObject1 = localJSONObject.getString("extra_data");
            }
            ((Intent)localObject2).putExtra("extra_data", (String)localObject1);
            RouteUtils.a(localQBaseActivity, (Intent)localObject2, "/qwallet/tenpay/jump", 5);
            return;
          }
          if ("transferqrcode".compareTo(str3) == 0)
          {
            str4 = this.app.getCurrentNickname();
            localObject4 = localJSONObject.optJSONObject("extra_data");
            localObject3 = localObject4;
            if (localObject4 != null) {}
          }
        }
      }
    }
    catch (Exception paramBundle)
    {
      JSONObject localJSONObject;
      Object localObject2;
      String str3;
      Object localObject3;
      String str4;
      Object localObject4;
      label1501:
      label1652:
      label1788:
      if (QLog.isColorLevel()) {
        QLog.e("Q.qwallet.pay.PayLogic", 2, "openTenpayView Exception", paramBundle);
      }
      label1585:
      label1618:
      label1754:
      tenpayResult(str2, "{'resultCode':-1,'retmsg':'openTenpayView Exception'}");
      label1686:
      label1720:
      paramBundle.printStackTrace();
      return;
    }
    try
    {
      localObject3 = new JSONObject();
    }
    catch (Exception localException1)
    {
      break label1501;
    }
    try
    {
      ((JSONObject)localObject3).put("name", str4);
      localJSONObject.put("extra_data", localObject3);
    }
    catch (Exception localException2)
    {
      break label1501;
    }
    if ("graphb".compareTo(str3) == 0) {
      this.mIsStartReport = true;
    }
    localObject4 = new Bundle();
    if ((str3.equals("bindNewCard")) && (localJSONObject.has("bargainor_id"))) {
      ((Bundle)localObject4).putString("bargainor_id", localJSONObject.getString("bargainor_id"));
    }
    if (localJSONObject.has("comeForm"))
    {
      i = localJSONObject.getInt("comeForm");
      ((Bundle)localObject4).putInt("come_from", i);
      if (!localJSONObject.has("appInfo")) {
        break label2389;
      }
      localObject3 = localJSONObject.getString("appInfo");
      ((Bundle)localObject4).putString("app_info", (String)localObject3);
      if (!localJSONObject.has("extra_data")) {
        break label2396;
      }
      localObject3 = localJSONObject.getString("extra_data");
      ((Bundle)localObject4).putString("extra_data", (String)localObject3);
      if (!localJSONObject.has("grouptype")) {
        break label2403;
      }
      localObject3 = localJSONObject.getString("grouptype");
      ((Bundle)localObject4).putString("grouptype", (String)localObject3);
      if (!localJSONObject.has("guildId")) {
        break label2410;
      }
      localObject3 = localJSONObject.getString("guildId");
      ((Bundle)localObject4).putString("guildId", (String)localObject3);
      if (!localJSONObject.has("tinyId")) {
        break label2417;
      }
      localObject3 = localJSONObject.getString("tinyId");
      ((Bundle)localObject4).putString("tinyId", (String)localObject3);
      if (!localJSONObject.has("subGuildId")) {
        break label2424;
      }
      localObject3 = localJSONObject.getString("subGuildId");
      ((Bundle)localObject4).putString("subGuildId", (String)localObject3);
      if (localJSONObject.has("senderuin")) {
        localObject1 = localJSONObject.getString("senderuin");
      }
      ((Bundle)localObject4).putString("senderuin", (String)localObject1);
      this.mOpenViewTag = str3;
      localObject1 = new Bundle(paramBundle);
      ((Bundle)localObject1).putString("callbackSn", str2);
      ((Bundle)localObject1).putString("tag", str3);
      ((Bundle)localObject1).putString("uin", (String)localObject2);
      if (!TextUtils.isEmpty(this.app.getCurrentAccountUin())) {
        ((Bundle)localObject1).putString("nick_name", this.app.getCurrentNickname());
      }
      ((Bundle)localObject1).putBundle("params", (Bundle)localObject4);
      ((Bundle)localObject1).putInt("PayInvokerId", 5);
      ((Bundle)localObject1).putInt("payparmas_paytype", this.mPayType);
      ((Bundle)localObject1).putBoolean("payparmas_is_lock_withdraw", this.isLockWithdraw);
      localObject2 = paramBundle.getString("json");
      if (this.mReportSeq == 0L)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("view.");
        ((StringBuilder)localObject3).append(str3);
        this.mReportSeq = VACDReportUtil.a(null, "qqwallet", ((StringBuilder)localObject3).toString(), "loadPluginStart", (String)localObject2, 0, null);
        this.mIsStartReport = true;
      }
      else
      {
        VACDReportUtil.a(this.mReportSeq, null, "loadPluginStart", (String)localObject2, 0, null);
      }
      ((Bundle)localObject1).putLong("vacreport_key_seq", this.mReportSeq);
      if (QLog.isDevelopLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("PayBridgeActivity-loadPluginStart=");
        ((StringBuilder)localObject2).append(System.currentTimeMillis());
        QLog.d("loadQWalletPlugin", 4, ((StringBuilder)localObject2).toString());
      }
      paramBundle = paramBundle.getBundle("extra_ext_data");
      if (paramBundle != null) {
        ((Bundle)localObject1).putBundle("extra_ext_data", paramBundle);
      }
      putProxyReceiverToBundle((Bundle)localObject1);
      QWalletPayBridge.launchForeground(localQBaseActivity, (Bundle)localObject1);
      return;
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("callbackSn", str2);
      ((Intent)localObject2).putExtra("come_from", 1);
      ((Intent)localObject2).putExtra("isJumpToH5", false);
      ((Intent)localObject2).putExtra("tag", str3);
      if (!localJSONObject.has("appInfo")) {
        break label2431;
      }
      paramBundle = localJSONObject.getString("appInfo");
    }
    for (;;)
    {
      ((Intent)localObject2).putExtra("app_info", paramBundle);
      if (localJSONObject.has("extra_data")) {
        localObject1 = localJSONObject.getString("extra_data");
      }
      ((Intent)localObject2).putExtra("extra_data", (String)localObject1);
      ((Intent)localObject2).putExtra("vacreport_key_seq", VACDReportUtil.a(null, "qqwallet", "transfer", "click", "is_H5=true", 0, null));
      RouteUtils.a(localQBaseActivity, (Intent)localObject2, "/qwallet/transaction", 5);
      return;
      if (QLog.isColorLevel()) {
        QLog.e(str3, 2, "openTenpayView viewTag is not allow");
      }
      tenpayResult(str2, "{'resultCode':-1,'retmsg':'openTenpayView param viewTag error'}");
      return;
      label2349:
      paramBundle = "";
      break;
      label2355:
      paramBundle = "";
      break label835;
      label2361:
      paramBundle = "";
      break label983;
      label2367:
      paramBundle = "";
      break label1207;
      label2373:
      i = 5;
      break label1342;
      label2378:
      paramBundle = "";
      break label1375;
      i = 1;
      break label1585;
      label2389:
      String str1 = "";
      break label1618;
      label2396:
      str1 = "";
      break label1652;
      label2403:
      str1 = "";
      break label1686;
      label2410:
      str1 = "";
      break label1720;
      label2417:
      str1 = "";
      break label1754;
      label2424:
      str1 = "";
      break label1788;
      label2431:
      paramBundle = "";
    }
  }
  
  /* Error */
  protected static Bundle pay(AppInterface paramAppInterface, Activity paramActivity, ResultReceiver paramResultReceiver, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong1, long paramLong2, String paramString4)
  {
    // Byte code:
    //   0: new 212	android/os/Bundle
    //   3: dup
    //   4: invokespecial 213	android/os/Bundle:<init>	()V
    //   7: astore 17
    //   9: aload 5
    //   11: invokestatic 277	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifne +33 -> 47
    //   17: aload 5
    //   19: ldc_w 1228
    //   22: invokestatic 1233	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   25: astore 18
    //   27: goto +24 -> 51
    //   30: astore 18
    //   32: goto +3 -> 35
    //   35: aload 18
    //   37: invokevirtual 1234	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   40: aload 5
    //   42: astore 18
    //   44: goto +7 -> 51
    //   47: aload 5
    //   49: astore 18
    //   51: invokestatic 401	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   54: istore 15
    //   56: ldc_w 1084
    //   59: astore 5
    //   61: iload 15
    //   63: ifeq +59 -> 122
    //   66: new 265	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   73: astore 19
    //   75: aload 19
    //   77: ldc_w 1236
    //   80: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload 19
    //   86: aload 4
    //   88: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload 19
    //   94: ldc_w 1028
    //   97: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload 19
    //   103: aload_3
    //   104: invokestatic 1031	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   107: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: ldc 226
    //   113: iconst_2
    //   114: aload 19
    //   116: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 1033	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   122: new 215	org/json/JSONObject
    //   125: dup
    //   126: aload 4
    //   128: invokespecial 218	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   131: astore 23
    //   133: ldc_w 414
    //   136: astore 19
    //   138: aload_0
    //   139: invokevirtual 1239	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   142: astore 24
    //   144: aload_0
    //   145: invokevirtual 1243	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   148: astore_0
    //   149: ldc 226
    //   151: astore 19
    //   153: new 265	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   160: astore 19
    //   162: getstatic 1249	mqq/app/Constants$PropertiesKey:nickName	Lmqq/app/Constants$PropertiesKey;
    //   165: astore 20
    //   167: aload 19
    //   169: aload 20
    //   171: invokevirtual 1250	mqq/app/Constants$PropertiesKey:toString	()Ljava/lang/String;
    //   174: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload 19
    //   180: aload 24
    //   182: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: aload_0
    //   187: aload 19
    //   189: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: invokevirtual 1255	mqq/app/MobileQQ:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   195: astore 26
    //   197: aload 23
    //   199: ldc_w 702
    //   202: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   205: astore 25
    //   207: aload 23
    //   209: ldc_w 259
    //   212: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   215: istore 15
    //   217: iload 15
    //   219: ifeq +24 -> 243
    //   222: aload 23
    //   224: ldc_w 259
    //   227: invokevirtual 263	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   230: istore 12
    //   232: goto +14 -> 246
    //   235: astore_0
    //   236: goto +1001 -> 1237
    //   239: astore_0
    //   240: goto +1100 -> 1340
    //   243: iconst_1
    //   244: istore 12
    //   246: aload 23
    //   248: ldc_w 1140
    //   251: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   254: istore 15
    //   256: ldc 249
    //   258: astore 21
    //   260: iload 15
    //   262: ifeq +16 -> 278
    //   265: aload 23
    //   267: ldc_w 1140
    //   270: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   273: astore 20
    //   275: goto +7 -> 282
    //   278: ldc 249
    //   280: astore 20
    //   282: aload 23
    //   284: ldc_w 1257
    //   287: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   290: istore 15
    //   292: iload 15
    //   294: ifeq +15 -> 309
    //   297: aload 23
    //   299: ldc_w 1257
    //   302: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   305: astore_0
    //   306: goto +6 -> 312
    //   309: ldc 249
    //   311: astore_0
    //   312: aload 23
    //   314: ldc_w 1259
    //   317: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   320: istore 15
    //   322: iload 15
    //   324: ifeq +16 -> 340
    //   327: aload 23
    //   329: ldc_w 1259
    //   332: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   335: astore 19
    //   337: goto +7 -> 344
    //   340: ldc 249
    //   342: astore 19
    //   344: ldc_w 1261
    //   347: invokestatic 651	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   350: checkcast 1261	cooperation/qwallet/plugin/IQWalletHelper
    //   353: aload 20
    //   355: aload 18
    //   357: invokeinterface 1264 3 0
    //   362: astore 27
    //   364: aload 23
    //   366: ldc_w 664
    //   369: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   372: istore 15
    //   374: aload 21
    //   376: astore 18
    //   378: iload 15
    //   380: ifeq +13 -> 393
    //   383: aload 23
    //   385: ldc_w 664
    //   388: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   391: astore 18
    //   393: iconst_1
    //   394: iload 6
    //   396: if_icmpne +53 -> 449
    //   399: aload 23
    //   401: ldc_w 673
    //   404: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   407: ifne +14 -> 421
    //   410: aload 23
    //   412: ldc_w 675
    //   415: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   418: ifeq +31 -> 449
    //   421: aload 23
    //   423: ldc_w 677
    //   426: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   429: istore 15
    //   431: iload 15
    //   433: ifeq +16 -> 449
    //   436: iconst_1
    //   437: istore 15
    //   439: goto +13 -> 452
    //   442: astore 20
    //   444: aload 20
    //   446: invokevirtual 412	java/lang/Exception:printStackTrace	()V
    //   449: iconst_0
    //   450: istore 15
    //   452: new 265	java/lang/StringBuilder
    //   455: dup
    //   456: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   459: astore 20
    //   461: aload 20
    //   463: ldc_w 724
    //   466: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: pop
    //   470: aload 20
    //   472: aload 25
    //   474: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: pop
    //   478: aload 20
    //   480: ldc_w 1266
    //   483: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: pop
    //   487: aload 20
    //   489: iload 12
    //   491: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   494: pop
    //   495: aload 20
    //   497: ldc_w 714
    //   500: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: pop
    //   504: aload 20
    //   506: aload 27
    //   508: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: pop
    //   512: aload 20
    //   514: ldc_w 1268
    //   517: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: pop
    //   521: aload 20
    //   523: aload_0
    //   524: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: pop
    //   528: aload 20
    //   530: ldc_w 1270
    //   533: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: pop
    //   537: aload 20
    //   539: aload 19
    //   541: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: pop
    //   545: aload 20
    //   547: ldc_w 1272
    //   550: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: pop
    //   554: aload 20
    //   556: aload 23
    //   558: ldc_w 1274
    //   561: invokevirtual 1277	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   564: invokevirtual 1280	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   567: pop
    //   568: aload 11
    //   570: invokestatic 277	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   573: istore 16
    //   575: iload 16
    //   577: ifne +20 -> 597
    //   580: aload 20
    //   582: ldc_w 279
    //   585: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: pop
    //   589: aload 20
    //   591: aload 11
    //   593: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: pop
    //   597: new 215	org/json/JSONObject
    //   600: dup
    //   601: aload 18
    //   603: invokespecial 218	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   606: astore_0
    //   607: aload_0
    //   608: ldc_w 1282
    //   611: invokevirtual 1120	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   614: pop
    //   615: aload 11
    //   617: invokestatic 277	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   620: ifne +13 -> 633
    //   623: aload_0
    //   624: ldc_w 1282
    //   627: aload 11
    //   629: invokevirtual 1285	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   632: pop
    //   633: aload_0
    //   634: invokevirtual 601	org/json/JSONObject:toString	()Ljava/lang/String;
    //   637: astore 21
    //   639: goto +39 -> 678
    //   642: new 215	org/json/JSONObject
    //   645: dup
    //   646: invokespecial 585	org/json/JSONObject:<init>	()V
    //   649: astore_0
    //   650: aload 11
    //   652: invokestatic 277	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   655: istore 16
    //   657: iload 16
    //   659: ifne +13 -> 672
    //   662: aload_0
    //   663: ldc_w 1282
    //   666: aload 11
    //   668: invokevirtual 1285	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   671: pop
    //   672: aload_0
    //   673: invokevirtual 601	org/json/JSONObject:toString	()Ljava/lang/String;
    //   676: astore 21
    //   678: lload 9
    //   680: aload 25
    //   682: ldc_w 281
    //   685: aload 20
    //   687: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   690: iconst_0
    //   691: aconst_null
    //   692: invokestatic 290	com/tencent/mobileqq/qwallet/report/VACDReportUtil:a	(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   695: aload 27
    //   697: invokestatic 277	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   700: ifne +200 -> 900
    //   703: aload 27
    //   705: ldc_w 1287
    //   708: invokevirtual 1291	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   711: astore 28
    //   713: aload 5
    //   715: astore 11
    //   717: aload 11
    //   719: astore_0
    //   720: iconst_0
    //   721: istore 13
    //   723: aload 11
    //   725: astore 20
    //   727: aload_0
    //   728: astore 19
    //   730: aload 5
    //   732: astore 18
    //   734: iload 13
    //   736: aload 28
    //   738: arraylength
    //   739: if_icmpge +173 -> 912
    //   742: aload 11
    //   744: astore 19
    //   746: aload_0
    //   747: astore 20
    //   749: aload 5
    //   751: astore 22
    //   753: aload 28
    //   755: iload 13
    //   757: aaload
    //   758: invokestatic 277	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   761: ifne +114 -> 875
    //   764: aload 28
    //   766: iload 13
    //   768: aaload
    //   769: bipush 35
    //   771: invokevirtual 1294	java/lang/String:indexOf	(I)I
    //   774: istore 14
    //   776: aload 11
    //   778: astore 19
    //   780: aload_0
    //   781: astore 20
    //   783: aload 5
    //   785: astore 22
    //   787: iload 14
    //   789: iconst_m1
    //   790: if_icmpeq +85 -> 875
    //   793: aload 28
    //   795: iload 13
    //   797: aaload
    //   798: iload 14
    //   800: iconst_1
    //   801: iadd
    //   802: invokevirtual 616	java/lang/String:substring	(I)Ljava/lang/String;
    //   805: astore 18
    //   807: iload 13
    //   809: ifne +17 -> 826
    //   812: aload 11
    //   814: astore 19
    //   816: aload_0
    //   817: astore 20
    //   819: aload 18
    //   821: astore 22
    //   823: goto +52 -> 875
    //   826: iload 13
    //   828: iconst_1
    //   829: if_icmpne +18 -> 847
    //   832: aload 11
    //   834: astore 19
    //   836: aload 18
    //   838: astore 20
    //   840: aload 5
    //   842: astore 22
    //   844: goto +31 -> 875
    //   847: aload 11
    //   849: astore 19
    //   851: aload_0
    //   852: astore 20
    //   854: aload 5
    //   856: astore 22
    //   858: iload 13
    //   860: iconst_2
    //   861: if_icmpne +14 -> 875
    //   864: aload 5
    //   866: astore 22
    //   868: aload_0
    //   869: astore 20
    //   871: aload 18
    //   873: astore 19
    //   875: iload 13
    //   877: iconst_1
    //   878: iadd
    //   879: istore 13
    //   881: aload 19
    //   883: astore 11
    //   885: aload 20
    //   887: astore_0
    //   888: aload 22
    //   890: astore 5
    //   892: goto -169 -> 723
    //   895: astore 22
    //   897: goto +27 -> 924
    //   900: aload 5
    //   902: astore 20
    //   904: aload 20
    //   906: astore 19
    //   908: aload 5
    //   910: astore 18
    //   912: goto +52 -> 964
    //   915: astore 22
    //   917: aload 5
    //   919: astore 11
    //   921: aload 11
    //   923: astore_0
    //   924: invokestatic 401	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   927: istore 16
    //   929: aload 11
    //   931: astore 20
    //   933: aload_0
    //   934: astore 19
    //   936: aload 5
    //   938: astore 18
    //   940: iload 16
    //   942: ifeq -30 -> 912
    //   945: aload 22
    //   947: invokevirtual 412	java/lang/Exception:printStackTrace	()V
    //   950: aload 11
    //   952: astore 20
    //   954: aload_0
    //   955: astore 19
    //   957: aload 5
    //   959: astore 18
    //   961: goto -49 -> 912
    //   964: new 212	android/os/Bundle
    //   967: dup
    //   968: invokespecial 213	android/os/Bundle:<init>	()V
    //   971: astore_0
    //   972: aload_0
    //   973: ldc_w 323
    //   976: aload_3
    //   977: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   980: aload_0
    //   981: ldc_w 702
    //   984: aload 25
    //   986: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   989: aload_0
    //   990: ldc 228
    //   992: aload 24
    //   994: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   997: aload_0
    //   998: ldc_w 1296
    //   1001: aload 26
    //   1003: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1006: aload_0
    //   1007: ldc_w 259
    //   1010: iload 12
    //   1012: invokevirtual 349	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1015: aload_0
    //   1016: ldc_w 1140
    //   1019: aload 27
    //   1021: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1024: aload_0
    //   1025: ldc_w 664
    //   1028: aload 21
    //   1030: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1033: aload_0
    //   1034: ldc_w 1274
    //   1037: aload 23
    //   1039: ldc_w 1274
    //   1042: invokevirtual 1277	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   1045: invokevirtual 304	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   1048: aload_0
    //   1049: ldc_w 351
    //   1052: bipush 9
    //   1054: invokevirtual 349	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1057: aload_0
    //   1058: ldc_w 353
    //   1061: iload 6
    //   1063: invokevirtual 349	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1066: aload_0
    //   1067: ldc_w 355
    //   1070: lload 7
    //   1072: invokevirtual 359	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   1075: aload_0
    //   1076: ldc_w 361
    //   1079: lload 9
    //   1081: invokevirtual 359	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   1084: aload_0
    //   1085: ldc_w 1201
    //   1088: iload 15
    //   1090: invokevirtual 304	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   1093: iload 15
    //   1095: ifeq +12 -> 1107
    //   1098: aload_0
    //   1099: ldc_w 1298
    //   1102: aload 4
    //   1104: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1107: aload_2
    //   1108: aload_0
    //   1109: invokestatic 365	cooperation/qwallet/plugin/impl/PayLogicImpl:setIPCReceiver	(Landroid/os/ResultReceiver;Landroid/os/Bundle;)V
    //   1112: lload 9
    //   1114: aconst_null
    //   1115: ldc_w 367
    //   1118: aconst_null
    //   1119: iconst_0
    //   1120: aconst_null
    //   1121: invokestatic 290	com/tencent/mobileqq/qwallet/report/VACDReportUtil:a	(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   1124: invokestatic 372	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1127: istore 15
    //   1129: iload 15
    //   1131: ifeq +38 -> 1169
    //   1134: new 265	java/lang/StringBuilder
    //   1137: dup
    //   1138: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   1141: astore_2
    //   1142: aload_2
    //   1143: ldc_w 374
    //   1146: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1149: pop
    //   1150: aload_2
    //   1151: invokestatic 380	java/lang/System:currentTimeMillis	()J
    //   1154: invokevirtual 383	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1157: pop
    //   1158: ldc_w 385
    //   1161: iconst_4
    //   1162: aload_2
    //   1163: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1166: invokestatic 388	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1169: aload_1
    //   1170: aload_0
    //   1171: invokestatic 394	cooperation/qwallet/plugin/QWalletPayBridge:launchForeground	(Landroid/app/Activity;Landroid/os/Bundle;)Z
    //   1174: pop
    //   1175: aload 17
    //   1177: astore_0
    //   1178: aload_0
    //   1179: ldc_w 396
    //   1182: iconst_0
    //   1183: invokevirtual 349	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1186: aload_0
    //   1187: ldc_w 806
    //   1190: aload 25
    //   1192: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1195: aload_0
    //   1196: ldc_w 810
    //   1199: aload 18
    //   1201: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1204: aload_0
    //   1205: ldc_w 814
    //   1208: aload 20
    //   1210: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1213: aload_0
    //   1214: ldc_w 818
    //   1217: aload 19
    //   1219: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1222: aload_0
    //   1223: areturn
    //   1224: astore_0
    //   1225: goto +40 -> 1265
    //   1228: astore_0
    //   1229: goto +20 -> 1249
    //   1232: astore_0
    //   1233: goto +8 -> 1241
    //   1236: astore_0
    //   1237: goto +28 -> 1265
    //   1240: astore_0
    //   1241: goto +8 -> 1249
    //   1244: astore_0
    //   1245: goto +20 -> 1265
    //   1248: astore_0
    //   1249: goto +91 -> 1340
    //   1252: astore_0
    //   1253: goto +12 -> 1265
    //   1256: astore_0
    //   1257: goto +83 -> 1340
    //   1260: astore_0
    //   1261: goto +79 -> 1340
    //   1264: astore_0
    //   1265: invokestatic 401	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1268: ifeq +38 -> 1306
    //   1271: new 265	java/lang/StringBuilder
    //   1274: dup
    //   1275: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   1278: astore_1
    //   1279: aload_1
    //   1280: ldc_w 1300
    //   1283: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1286: pop
    //   1287: aload_1
    //   1288: aload_0
    //   1289: invokevirtual 406	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1292: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1295: pop
    //   1296: ldc 226
    //   1298: iconst_2
    //   1299: aload_1
    //   1300: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1303: invokestatic 409	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1306: invokestatic 372	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1309: ifeq +7 -> 1316
    //   1312: aload_0
    //   1313: invokevirtual 412	java/lang/Exception:printStackTrace	()V
    //   1316: aload 17
    //   1318: ldc_w 396
    //   1321: iconst_m1
    //   1322: invokevirtual 349	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1325: aload 17
    //   1327: ldc_w 414
    //   1330: ldc_w 1302
    //   1333: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1336: aload 17
    //   1338: areturn
    //   1339: astore_1
    //   1340: invokestatic 401	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1343: ifeq +38 -> 1381
    //   1346: new 265	java/lang/StringBuilder
    //   1349: dup
    //   1350: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   1353: astore_1
    //   1354: aload_1
    //   1355: ldc_w 1304
    //   1358: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1361: pop
    //   1362: aload_1
    //   1363: aload_0
    //   1364: invokevirtual 419	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   1367: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1370: pop
    //   1371: ldc 226
    //   1373: iconst_2
    //   1374: aload_1
    //   1375: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1378: invokestatic 409	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1381: invokestatic 372	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1384: ifeq +7 -> 1391
    //   1387: aload_0
    //   1388: invokevirtual 420	org/json/JSONException:printStackTrace	()V
    //   1391: aload 17
    //   1393: ldc_w 396
    //   1396: iconst_m1
    //   1397: invokevirtual 349	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1400: aload 17
    //   1402: ldc_w 414
    //   1405: ldc_w 1306
    //   1408: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1411: aload 17
    //   1413: areturn
    //   1414: astore_0
    //   1415: goto -773 -> 642
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1418	0	paramAppInterface	AppInterface
    //   0	1418	1	paramActivity	Activity
    //   0	1418	2	paramResultReceiver	ResultReceiver
    //   0	1418	3	paramString1	String
    //   0	1418	4	paramString2	String
    //   0	1418	5	paramString3	String
    //   0	1418	6	paramInt	int
    //   0	1418	7	paramLong1	long
    //   0	1418	9	paramLong2	long
    //   0	1418	11	paramString4	String
    //   230	781	12	i	int
    //   721	159	13	j	int
    //   774	28	14	k	int
    //   54	1076	15	bool1	boolean
    //   573	368	16	bool2	boolean
    //   7	1330	17	localBundle	Bundle
    //   25	1	18	str1	String
    //   30	6	18	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
    //   42	1158	18	localObject1	Object
    //   73	1145	19	localObject2	Object
    //   165	189	20	localObject3	Object
    //   442	3	20	localException1	Exception
    //   459	750	20	localObject4	Object
    //   258	771	21	str2	String
    //   751	138	22	localObject5	Object
    //   895	1	22	localException2	Exception
    //   915	31	22	localException3	Exception
    //   131	907	23	localJSONObject	JSONObject
    //   142	851	24	str3	String
    //   205	986	25	str4	String
    //   195	807	26	str5	String
    //   362	658	27	str6	String
    //   711	83	28	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   17	27	30	java/io/UnsupportedEncodingException
    //   222	232	235	java/lang/Exception
    //   246	256	235	java/lang/Exception
    //   265	275	235	java/lang/Exception
    //   282	292	235	java/lang/Exception
    //   297	306	235	java/lang/Exception
    //   312	322	235	java/lang/Exception
    //   327	337	235	java/lang/Exception
    //   344	374	235	java/lang/Exception
    //   383	393	235	java/lang/Exception
    //   444	449	235	java/lang/Exception
    //   452	575	235	java/lang/Exception
    //   580	597	235	java/lang/Exception
    //   642	657	235	java/lang/Exception
    //   662	672	235	java/lang/Exception
    //   672	678	235	java/lang/Exception
    //   678	695	235	java/lang/Exception
    //   924	929	235	java/lang/Exception
    //   945	950	235	java/lang/Exception
    //   964	1093	235	java/lang/Exception
    //   1098	1107	235	java/lang/Exception
    //   1107	1129	235	java/lang/Exception
    //   1134	1169	235	java/lang/Exception
    //   1169	1175	235	java/lang/Exception
    //   222	232	239	org/json/JSONException
    //   265	275	239	org/json/JSONException
    //   297	306	239	org/json/JSONException
    //   327	337	239	org/json/JSONException
    //   383	393	239	org/json/JSONException
    //   399	421	239	org/json/JSONException
    //   421	431	239	org/json/JSONException
    //   444	449	239	org/json/JSONException
    //   580	597	239	org/json/JSONException
    //   597	633	239	org/json/JSONException
    //   633	639	239	org/json/JSONException
    //   662	672	239	org/json/JSONException
    //   695	713	239	org/json/JSONException
    //   734	742	239	org/json/JSONException
    //   753	776	239	org/json/JSONException
    //   793	807	239	org/json/JSONException
    //   945	950	239	org/json/JSONException
    //   1098	1107	239	org/json/JSONException
    //   1134	1169	239	org/json/JSONException
    //   399	421	442	java/lang/Exception
    //   421	431	442	java/lang/Exception
    //   734	742	895	java/lang/Exception
    //   753	776	895	java/lang/Exception
    //   793	807	895	java/lang/Exception
    //   695	713	915	java/lang/Exception
    //   1178	1222	1224	java/lang/Exception
    //   1178	1222	1228	org/json/JSONException
    //   246	256	1232	org/json/JSONException
    //   282	292	1232	org/json/JSONException
    //   312	322	1232	org/json/JSONException
    //   344	374	1232	org/json/JSONException
    //   452	575	1232	org/json/JSONException
    //   642	657	1232	org/json/JSONException
    //   672	678	1232	org/json/JSONException
    //   678	695	1232	org/json/JSONException
    //   924	929	1232	org/json/JSONException
    //   964	1093	1232	org/json/JSONException
    //   1107	1129	1232	org/json/JSONException
    //   1169	1175	1232	org/json/JSONException
    //   167	217	1236	java/lang/Exception
    //   167	217	1240	org/json/JSONException
    //   153	167	1244	java/lang/Exception
    //   153	167	1248	org/json/JSONException
    //   138	149	1252	java/lang/Exception
    //   138	149	1256	org/json/JSONException
    //   122	133	1260	org/json/JSONException
    //   122	133	1264	java/lang/Exception
    //   597	633	1414	java/lang/Exception
    //   633	639	1414	java/lang/Exception
  }
  
  private void putProxyReceiverToBundle(Bundle paramBundle)
  {
    setIPCReceiver(new PayLogicImpl.CompactReceiver(ThreadManager.getUIHandlerV2(), this), paramBundle);
  }
  
  /* Error */
  protected static Bundle rechargeGameCurrency(AppInterface paramAppInterface, Activity paramActivity, ResultReceiver paramResultReceiver, String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2, String paramString3)
  {
    // Byte code:
    //   0: new 212	android/os/Bundle
    //   3: dup
    //   4: invokespecial 213	android/os/Bundle:<init>	()V
    //   7: astore 15
    //   9: new 215	org/json/JSONObject
    //   12: dup
    //   13: aload 4
    //   15: invokespecial 218	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   18: astore 25
    //   20: ldc 226
    //   22: astore_0
    //   23: aload 25
    //   25: ldc 220
    //   27: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   30: astore 23
    //   32: aload 25
    //   34: ldc 228
    //   36: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   39: astore 24
    //   41: aload 25
    //   43: ldc 232
    //   45: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   48: istore 12
    //   50: iload 12
    //   52: ifeq +18 -> 70
    //   55: aload 25
    //   57: ldc 232
    //   59: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   62: astore_0
    //   63: goto +10 -> 73
    //   66: astore_0
    //   67: goto +938 -> 1005
    //   70: ldc 238
    //   72: astore_0
    //   73: aload 25
    //   75: ldc_w 558
    //   78: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   81: istore 12
    //   83: iload 12
    //   85: ifeq +20 -> 105
    //   88: aload 25
    //   90: ldc_w 558
    //   93: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   96: astore 16
    //   98: goto +12 -> 110
    //   101: astore_0
    //   102: goto +903 -> 1005
    //   105: ldc_w 560
    //   108: astore 16
    //   110: aload 25
    //   112: ldc 240
    //   114: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   117: istore 12
    //   119: iload 12
    //   121: ifeq +15 -> 136
    //   124: aload 25
    //   126: ldc 240
    //   128: invokevirtual 243	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   131: istore 12
    //   133: goto +6 -> 139
    //   136: iconst_1
    //   137: istore 12
    //   139: aload 25
    //   141: ldc_w 551
    //   144: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   147: istore 13
    //   149: iload 13
    //   151: ifeq +16 -> 167
    //   154: aload 25
    //   156: ldc_w 551
    //   159: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   162: astore 17
    //   164: goto +6 -> 170
    //   167: aconst_null
    //   168: astore 17
    //   170: aload 25
    //   172: ldc_w 553
    //   175: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   178: istore 13
    //   180: iload 13
    //   182: ifeq +16 -> 198
    //   185: aload 25
    //   187: ldc_w 553
    //   190: invokevirtual 243	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   193: istore 13
    //   195: goto +6 -> 201
    //   198: iconst_1
    //   199: istore 13
    //   201: aload 25
    //   203: ldc 247
    //   205: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   208: istore 14
    //   210: ldc 249
    //   212: astore 22
    //   214: iload 14
    //   216: ifeq +15 -> 231
    //   219: aload 25
    //   221: ldc 247
    //   223: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   226: astore 18
    //   228: goto +7 -> 235
    //   231: ldc 249
    //   233: astore 18
    //   235: aload 25
    //   237: ldc 251
    //   239: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   242: istore 14
    //   244: iload 14
    //   246: ifeq +15 -> 261
    //   249: aload 25
    //   251: ldc 251
    //   253: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   256: astore 19
    //   258: goto +7 -> 265
    //   261: ldc 249
    //   263: astore 19
    //   265: aload 25
    //   267: ldc 253
    //   269: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   272: istore 14
    //   274: iload 14
    //   276: ifeq +15 -> 291
    //   279: aload 25
    //   281: ldc 253
    //   283: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   286: astore 20
    //   288: goto +7 -> 295
    //   291: ldc 249
    //   293: astore 20
    //   295: aload 25
    //   297: ldc 255
    //   299: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   302: istore 14
    //   304: iload 14
    //   306: ifeq +15 -> 321
    //   309: aload 25
    //   311: ldc 255
    //   313: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   316: astore 21
    //   318: goto +7 -> 325
    //   321: ldc 249
    //   323: astore 21
    //   325: aload 25
    //   327: ldc_w 257
    //   330: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   333: istore 14
    //   335: iload 14
    //   337: ifeq +13 -> 350
    //   340: aload 25
    //   342: ldc_w 257
    //   345: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   348: astore 22
    //   350: aload 25
    //   352: ldc_w 259
    //   355: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   358: istore 14
    //   360: iload 14
    //   362: ifeq +16 -> 378
    //   365: aload 25
    //   367: ldc_w 259
    //   370: invokevirtual 263	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   373: istore 11
    //   375: goto +6 -> 381
    //   378: iconst_1
    //   379: istore 11
    //   381: new 265	java/lang/StringBuilder
    //   384: dup
    //   385: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   388: astore 26
    //   390: aload 26
    //   392: ldc_w 268
    //   395: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: pop
    //   399: aload 26
    //   401: aload 4
    //   403: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: pop
    //   407: aload 10
    //   409: invokestatic 277	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   412: istore 14
    //   414: iload 14
    //   416: ifne +20 -> 436
    //   419: aload 26
    //   421: ldc_w 279
    //   424: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: pop
    //   428: aload 26
    //   430: aload 10
    //   432: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: pop
    //   436: lload 8
    //   438: aconst_null
    //   439: ldc_w 281
    //   442: aload 26
    //   444: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   447: iconst_0
    //   448: aconst_null
    //   449: invokestatic 290	com/tencent/mobileqq/qwallet/report/VACDReportUtil:a	(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   452: new 212	android/os/Bundle
    //   455: dup
    //   456: invokespecial 213	android/os/Bundle:<init>	()V
    //   459: astore 10
    //   461: aload 10
    //   463: ldc 220
    //   465: aload 23
    //   467: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   470: aload 25
    //   472: invokestatic 1308	cooperation/qwallet/plugin/impl/PayLogicImpl:isEnterMidasTestEnv	(Lorg/json/JSONObject;)Z
    //   475: istore 14
    //   477: iload 14
    //   479: ifeq +11 -> 490
    //   482: ldc_w 1310
    //   485: astore 4
    //   487: goto +8 -> 495
    //   490: ldc_w 298
    //   493: astore 4
    //   495: aload 10
    //   497: ldc_w 296
    //   500: aload 4
    //   502: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   505: aload 10
    //   507: ldc_w 300
    //   510: iconst_1
    //   511: invokevirtual 304	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   514: aload 10
    //   516: ldc_w 306
    //   519: iload 12
    //   521: invokestatic 312	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   524: invokevirtual 316	java/lang/Boolean:booleanValue	()Z
    //   527: invokevirtual 304	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   530: aload 10
    //   532: ldc_w 323
    //   535: aload_3
    //   536: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   539: new 265	java/lang/StringBuilder
    //   542: dup
    //   543: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   546: astore_3
    //   547: aload_3
    //   548: iload 11
    //   550: invokestatic 1312	cooperation/qwallet/plugin/impl/PayLogicImpl:getPfPref	(I)Ljava/lang/String;
    //   553: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: pop
    //   557: aload_3
    //   558: ldc_w 1314
    //   561: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: pop
    //   565: aload_3
    //   566: ldc_w 1316
    //   569: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: pop
    //   573: aload_3
    //   574: invokestatic 332	com/tencent/common/config/AppSetting:d	()I
    //   577: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   580: pop
    //   581: aload_3
    //   582: ldc_w 337
    //   585: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: pop
    //   589: aload_3
    //   590: aload 18
    //   592: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: pop
    //   596: aload_3
    //   597: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   600: astore_3
    //   601: aload 10
    //   603: ldc 228
    //   605: aload 24
    //   607: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   610: aload 10
    //   612: ldc_w 339
    //   615: ldc_w 341
    //   618: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   621: aload 10
    //   623: ldc 232
    //   625: aload_0
    //   626: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   629: aload 10
    //   631: ldc_w 325
    //   634: aload_3
    //   635: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   638: aload 10
    //   640: ldc_w 343
    //   643: ldc_w 343
    //   646: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   649: aload 10
    //   651: ldc_w 558
    //   654: aload 16
    //   656: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   659: aload 10
    //   661: ldc 251
    //   663: aload 19
    //   665: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   668: aload 10
    //   670: ldc 253
    //   672: aload 20
    //   674: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   677: aload 10
    //   679: ldc 255
    //   681: aload 21
    //   683: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   686: aload 10
    //   688: ldc_w 257
    //   691: aload 22
    //   693: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   696: aload 17
    //   698: ifnull +37 -> 735
    //   701: aload 17
    //   703: invokevirtual 321	java/lang/String:length	()I
    //   706: ifle +29 -> 735
    //   709: aload 10
    //   711: ldc_w 551
    //   714: aload 17
    //   716: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   719: aload 10
    //   721: ldc_w 553
    //   724: iload 13
    //   726: invokestatic 312	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   729: invokevirtual 316	java/lang/Boolean:booleanValue	()Z
    //   732: invokevirtual 304	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   735: aload 10
    //   737: ldc_w 345
    //   740: iconst_0
    //   741: invokevirtual 349	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   744: aload 10
    //   746: ldc_w 351
    //   749: bipush 6
    //   751: invokevirtual 349	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   754: aload 10
    //   756: ldc_w 353
    //   759: iload 5
    //   761: invokevirtual 349	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   764: aload 10
    //   766: ldc_w 355
    //   769: lload 6
    //   771: invokevirtual 359	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   774: aload 10
    //   776: ldc_w 361
    //   779: lload 8
    //   781: invokevirtual 359	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   784: aload 10
    //   786: ldc_w 259
    //   789: iload 11
    //   791: invokevirtual 349	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   794: aload_2
    //   795: aload 10
    //   797: invokestatic 365	cooperation/qwallet/plugin/impl/PayLogicImpl:setIPCReceiver	(Landroid/os/ResultReceiver;Landroid/os/Bundle;)V
    //   800: lload 8
    //   802: aconst_null
    //   803: ldc_w 367
    //   806: aconst_null
    //   807: iconst_0
    //   808: aconst_null
    //   809: invokestatic 290	com/tencent/mobileqq/qwallet/report/VACDReportUtil:a	(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   812: invokestatic 372	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   815: istore 12
    //   817: iload 12
    //   819: ifeq +38 -> 857
    //   822: new 265	java/lang/StringBuilder
    //   825: dup
    //   826: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   829: astore_0
    //   830: aload_0
    //   831: ldc_w 374
    //   834: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   837: pop
    //   838: aload_0
    //   839: invokestatic 380	java/lang/System:currentTimeMillis	()J
    //   842: invokevirtual 383	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   845: pop
    //   846: ldc_w 385
    //   849: iconst_4
    //   850: aload_0
    //   851: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   854: invokestatic 388	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   857: aload_1
    //   858: aload 10
    //   860: invokestatic 394	cooperation/qwallet/plugin/QWalletPayBridge:launchForeground	(Landroid/app/Activity;Landroid/os/Bundle;)Z
    //   863: pop
    //   864: aload 15
    //   866: astore_0
    //   867: aload_0
    //   868: ldc_w 396
    //   871: iconst_0
    //   872: invokevirtual 349	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   875: aload_0
    //   876: ldc 220
    //   878: aload 23
    //   880: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   883: aload_0
    //   884: ldc 247
    //   886: aload 18
    //   888: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   891: aload_0
    //   892: areturn
    //   893: astore_0
    //   894: goto +36 -> 930
    //   897: astore_0
    //   898: goto +24 -> 922
    //   901: astore_0
    //   902: goto +28 -> 930
    //   905: astore_0
    //   906: goto +16 -> 922
    //   909: astore_0
    //   910: goto +20 -> 930
    //   913: astore_0
    //   914: goto +8 -> 922
    //   917: astore_0
    //   918: goto +12 -> 930
    //   921: astore_0
    //   922: goto +83 -> 1005
    //   925: astore_0
    //   926: goto +79 -> 1005
    //   929: astore_0
    //   930: invokestatic 401	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   933: ifeq +38 -> 971
    //   936: new 265	java/lang/StringBuilder
    //   939: dup
    //   940: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   943: astore_1
    //   944: aload_1
    //   945: ldc_w 1318
    //   948: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   951: pop
    //   952: aload_1
    //   953: aload_0
    //   954: invokevirtual 406	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   957: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   960: pop
    //   961: ldc 226
    //   963: iconst_2
    //   964: aload_1
    //   965: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   968: invokestatic 409	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   971: invokestatic 372	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   974: ifeq +7 -> 981
    //   977: aload_0
    //   978: invokevirtual 412	java/lang/Exception:printStackTrace	()V
    //   981: aload 15
    //   983: ldc_w 396
    //   986: iconst_m1
    //   987: invokevirtual 349	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   990: aload 15
    //   992: ldc_w 414
    //   995: ldc_w 1320
    //   998: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1001: aload 15
    //   1003: areturn
    //   1004: astore_1
    //   1005: invokestatic 401	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1008: ifeq +38 -> 1046
    //   1011: new 265	java/lang/StringBuilder
    //   1014: dup
    //   1015: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   1018: astore_1
    //   1019: aload_1
    //   1020: ldc_w 1322
    //   1023: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1026: pop
    //   1027: aload_1
    //   1028: aload_0
    //   1029: invokevirtual 419	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   1032: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1035: pop
    //   1036: ldc 226
    //   1038: iconst_2
    //   1039: aload_1
    //   1040: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1043: invokestatic 409	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1046: invokestatic 372	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1049: ifeq +7 -> 1056
    //   1052: aload_0
    //   1053: invokevirtual 420	org/json/JSONException:printStackTrace	()V
    //   1056: aload 15
    //   1058: ldc_w 396
    //   1061: iconst_m1
    //   1062: invokevirtual 349	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1065: aload 15
    //   1067: ldc_w 414
    //   1070: ldc_w 1320
    //   1073: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1076: aload 15
    //   1078: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1079	0	paramAppInterface	AppInterface
    //   0	1079	1	paramActivity	Activity
    //   0	1079	2	paramResultReceiver	ResultReceiver
    //   0	1079	3	paramString1	String
    //   0	1079	4	paramString2	String
    //   0	1079	5	paramInt	int
    //   0	1079	6	paramLong1	long
    //   0	1079	8	paramLong2	long
    //   0	1079	10	paramString3	String
    //   373	417	11	i	int
    //   48	770	12	bool1	boolean
    //   147	578	13	bool2	boolean
    //   208	270	14	bool3	boolean
    //   7	995	15	localBundle	Bundle
    //   96	559	16	str1	String
    //   162	553	17	str2	String
    //   226	661	18	str3	String
    //   256	408	19	str4	String
    //   286	387	20	str5	String
    //   316	366	21	str6	String
    //   212	480	22	str7	String
    //   30	849	23	str8	String
    //   39	567	24	str9	String
    //   18	453	25	localJSONObject	JSONObject
    //   388	55	26	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   55	63	66	org/json/JSONException
    //   88	98	101	org/json/JSONException
    //   124	133	101	org/json/JSONException
    //   154	164	101	org/json/JSONException
    //   185	195	101	org/json/JSONException
    //   219	228	101	org/json/JSONException
    //   249	258	101	org/json/JSONException
    //   279	288	101	org/json/JSONException
    //   309	318	101	org/json/JSONException
    //   340	350	101	org/json/JSONException
    //   365	375	101	org/json/JSONException
    //   419	436	101	org/json/JSONException
    //   701	735	101	org/json/JSONException
    //   822	857	101	org/json/JSONException
    //   867	891	893	java/lang/Exception
    //   867	891	897	org/json/JSONException
    //   73	83	901	java/lang/Exception
    //   88	98	901	java/lang/Exception
    //   110	119	901	java/lang/Exception
    //   124	133	901	java/lang/Exception
    //   139	149	901	java/lang/Exception
    //   154	164	901	java/lang/Exception
    //   170	180	901	java/lang/Exception
    //   185	195	901	java/lang/Exception
    //   201	210	901	java/lang/Exception
    //   219	228	901	java/lang/Exception
    //   235	244	901	java/lang/Exception
    //   249	258	901	java/lang/Exception
    //   265	274	901	java/lang/Exception
    //   279	288	901	java/lang/Exception
    //   295	304	901	java/lang/Exception
    //   309	318	901	java/lang/Exception
    //   325	335	901	java/lang/Exception
    //   340	350	901	java/lang/Exception
    //   350	360	901	java/lang/Exception
    //   365	375	901	java/lang/Exception
    //   381	414	901	java/lang/Exception
    //   419	436	901	java/lang/Exception
    //   436	477	901	java/lang/Exception
    //   495	696	901	java/lang/Exception
    //   701	735	901	java/lang/Exception
    //   735	817	901	java/lang/Exception
    //   822	857	901	java/lang/Exception
    //   857	864	901	java/lang/Exception
    //   73	83	905	org/json/JSONException
    //   110	119	905	org/json/JSONException
    //   139	149	905	org/json/JSONException
    //   170	180	905	org/json/JSONException
    //   201	210	905	org/json/JSONException
    //   235	244	905	org/json/JSONException
    //   265	274	905	org/json/JSONException
    //   295	304	905	org/json/JSONException
    //   325	335	905	org/json/JSONException
    //   350	360	905	org/json/JSONException
    //   381	414	905	org/json/JSONException
    //   436	477	905	org/json/JSONException
    //   495	696	905	org/json/JSONException
    //   735	817	905	org/json/JSONException
    //   857	864	905	org/json/JSONException
    //   32	50	909	java/lang/Exception
    //   55	63	909	java/lang/Exception
    //   32	50	913	org/json/JSONException
    //   23	32	917	java/lang/Exception
    //   23	32	921	org/json/JSONException
    //   9	20	925	org/json/JSONException
    //   9	20	929	java/lang/Exception
  }
  
  /* Error */
  protected static Bundle rechargeQb(AppInterface paramAppInterface, Activity paramActivity, ResultReceiver paramResultReceiver, String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2, String paramString3)
  {
    // Byte code:
    //   0: new 212	android/os/Bundle
    //   3: dup
    //   4: invokespecial 213	android/os/Bundle:<init>	()V
    //   7: astore_0
    //   8: new 215	org/json/JSONObject
    //   11: dup
    //   12: aload 4
    //   14: invokespecial 218	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   17: astore 24
    //   19: aload 24
    //   21: ldc 220
    //   23: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   26: astore 22
    //   28: aload 24
    //   30: ldc 228
    //   32: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   35: astore 23
    //   37: ldc 226
    //   39: astore 12
    //   41: aload 24
    //   43: ldc_w 814
    //   46: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   49: istore 11
    //   51: aconst_null
    //   52: astore 18
    //   54: iload 11
    //   56: ifeq +965 -> 1021
    //   59: aload 24
    //   61: ldc_w 814
    //   64: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   67: astore 13
    //   69: goto +3 -> 72
    //   72: aload 24
    //   74: ldc 245
    //   76: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   79: ifeq +15 -> 94
    //   82: aload 24
    //   84: ldc 245
    //   86: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   89: astore 14
    //   91: goto +6 -> 97
    //   94: aconst_null
    //   95: astore 14
    //   97: aload 24
    //   99: ldc_w 551
    //   102: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   105: istore 11
    //   107: iload 11
    //   109: ifeq +35 -> 144
    //   112: aload 24
    //   114: ldc_w 551
    //   117: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   120: astore 15
    //   122: goto +25 -> 147
    //   125: astore_2
    //   126: aload_0
    //   127: astore_1
    //   128: aload 12
    //   130: astore_3
    //   131: ldc_w 396
    //   134: astore 4
    //   136: aload_2
    //   137: astore_0
    //   138: aload 4
    //   140: astore_2
    //   141: goto +808 -> 949
    //   144: aconst_null
    //   145: astore 15
    //   147: aload 24
    //   149: ldc 247
    //   151: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   154: istore 11
    //   156: ldc 249
    //   158: astore 21
    //   160: iload 11
    //   162: ifeq +32 -> 194
    //   165: aload 24
    //   167: ldc 247
    //   169: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   172: astore 16
    //   174: goto +24 -> 198
    //   177: astore 4
    //   179: aload 12
    //   181: astore_3
    //   182: ldc_w 396
    //   185: astore_2
    //   186: aload_0
    //   187: astore_1
    //   188: aload 4
    //   190: astore_0
    //   191: goto +758 -> 949
    //   194: ldc 249
    //   196: astore 16
    //   198: aload 24
    //   200: ldc_w 569
    //   203: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   206: istore 11
    //   208: iload 11
    //   210: ifeq +16 -> 226
    //   213: aload 24
    //   215: ldc_w 569
    //   218: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   221: astore 17
    //   223: goto +6 -> 229
    //   226: aconst_null
    //   227: astore 17
    //   229: aload 24
    //   231: ldc_w 571
    //   234: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   237: istore 11
    //   239: iload 11
    //   241: ifeq +13 -> 254
    //   244: aload 24
    //   246: ldc_w 571
    //   249: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   252: astore 18
    //   254: aload 24
    //   256: ldc 251
    //   258: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   261: istore 11
    //   263: iload 11
    //   265: ifeq +15 -> 280
    //   268: aload 24
    //   270: ldc 251
    //   272: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   275: astore 19
    //   277: goto +7 -> 284
    //   280: ldc 249
    //   282: astore 19
    //   284: aload 24
    //   286: ldc 253
    //   288: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   291: istore 11
    //   293: iload 11
    //   295: ifeq +15 -> 310
    //   298: aload 24
    //   300: ldc 253
    //   302: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   305: astore 20
    //   307: goto +7 -> 314
    //   310: ldc 249
    //   312: astore 20
    //   314: aload 24
    //   316: ldc 255
    //   318: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   321: istore 11
    //   323: iload 11
    //   325: ifeq +12 -> 337
    //   328: aload 24
    //   330: ldc 255
    //   332: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   335: astore 21
    //   337: new 265	java/lang/StringBuilder
    //   340: dup
    //   341: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   344: astore 24
    //   346: aload 24
    //   348: ldc_w 268
    //   351: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: pop
    //   355: aload 24
    //   357: aload 4
    //   359: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: pop
    //   363: aload 10
    //   365: invokestatic 277	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   368: istore 11
    //   370: iload 11
    //   372: ifne +20 -> 392
    //   375: aload 24
    //   377: ldc_w 279
    //   380: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: pop
    //   384: aload 24
    //   386: aload 10
    //   388: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: pop
    //   392: lload 8
    //   394: aconst_null
    //   395: ldc_w 281
    //   398: aload 24
    //   400: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   403: iconst_0
    //   404: aconst_null
    //   405: invokestatic 290	com/tencent/mobileqq/qwallet/report/VACDReportUtil:a	(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   408: new 212	android/os/Bundle
    //   411: dup
    //   412: invokespecial 213	android/os/Bundle:<init>	()V
    //   415: astore 4
    //   417: aload 4
    //   419: ldc 220
    //   421: aload 22
    //   423: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   426: aload 4
    //   428: ldc_w 296
    //   431: ldc_w 298
    //   434: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   437: aload 4
    //   439: ldc_w 300
    //   442: iconst_1
    //   443: invokevirtual 304	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   446: aload 14
    //   448: ifnull +20 -> 468
    //   451: aload 14
    //   453: invokevirtual 321	java/lang/String:length	()I
    //   456: ifle +12 -> 468
    //   459: aload 4
    //   461: ldc 245
    //   463: aload 14
    //   465: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   468: aload 13
    //   470: ifnull +21 -> 491
    //   473: aload 13
    //   475: invokevirtual 321	java/lang/String:length	()I
    //   478: ifle +13 -> 491
    //   481: aload 4
    //   483: ldc_w 836
    //   486: aload 13
    //   488: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   491: aload 4
    //   493: ldc_w 323
    //   496: aload_3
    //   497: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   500: new 265	java/lang/StringBuilder
    //   503: dup
    //   504: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   507: astore_3
    //   508: aload_3
    //   509: ldc_w 327
    //   512: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: pop
    //   516: aload_3
    //   517: invokestatic 332	com/tencent/common/config/AppSetting:d	()I
    //   520: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   523: pop
    //   524: aload_3
    //   525: ldc_w 337
    //   528: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: pop
    //   532: aload_3
    //   533: aload 16
    //   535: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: pop
    //   539: aload_3
    //   540: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   543: astore_3
    //   544: aload 4
    //   546: ldc 228
    //   548: aload 23
    //   550: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   553: aload 4
    //   555: ldc_w 339
    //   558: ldc_w 341
    //   561: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   564: aload 4
    //   566: ldc_w 325
    //   569: aload_3
    //   570: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   573: aload 4
    //   575: ldc_w 343
    //   578: ldc_w 343
    //   581: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   584: aload 4
    //   586: ldc_w 551
    //   589: aload 15
    //   591: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   594: aload 4
    //   596: ldc_w 569
    //   599: aload 17
    //   601: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   604: aload 4
    //   606: ldc_w 571
    //   609: aload 18
    //   611: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   614: aload 4
    //   616: ldc 251
    //   618: aload 19
    //   620: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   623: aload 4
    //   625: ldc 253
    //   627: aload 20
    //   629: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   632: aload 4
    //   634: ldc 255
    //   636: aload 21
    //   638: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   641: aload 4
    //   643: ldc_w 351
    //   646: bipush 8
    //   648: invokevirtual 349	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   651: aload 4
    //   653: ldc_w 353
    //   656: iload 5
    //   658: invokevirtual 349	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   661: aload 4
    //   663: ldc_w 355
    //   666: lload 6
    //   668: invokevirtual 359	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   671: aload 4
    //   673: ldc_w 361
    //   676: lload 8
    //   678: invokevirtual 359	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   681: aload_2
    //   682: aload 4
    //   684: invokestatic 365	cooperation/qwallet/plugin/impl/PayLogicImpl:setIPCReceiver	(Landroid/os/ResultReceiver;Landroid/os/Bundle;)V
    //   687: lload 8
    //   689: aconst_null
    //   690: ldc_w 367
    //   693: aconst_null
    //   694: iconst_0
    //   695: aconst_null
    //   696: invokestatic 290	com/tencent/mobileqq/qwallet/report/VACDReportUtil:a	(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   699: invokestatic 372	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   702: istore 11
    //   704: iload 11
    //   706: ifeq +38 -> 744
    //   709: new 265	java/lang/StringBuilder
    //   712: dup
    //   713: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   716: astore_2
    //   717: aload_2
    //   718: ldc_w 374
    //   721: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   724: pop
    //   725: aload_2
    //   726: invokestatic 380	java/lang/System:currentTimeMillis	()J
    //   729: invokevirtual 383	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   732: pop
    //   733: ldc_w 385
    //   736: iconst_4
    //   737: aload_2
    //   738: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   741: invokestatic 388	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   744: aload_1
    //   745: aload 4
    //   747: invokestatic 394	cooperation/qwallet/plugin/QWalletPayBridge:launchForeground	(Landroid/app/Activity;Landroid/os/Bundle;)Z
    //   750: pop
    //   751: ldc_w 396
    //   754: astore_2
    //   755: aload_0
    //   756: astore_1
    //   757: aload_1
    //   758: aload_2
    //   759: iconst_0
    //   760: invokevirtual 349	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   763: aload_1
    //   764: ldc 220
    //   766: aload 22
    //   768: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   771: aload_1
    //   772: ldc 247
    //   774: aload 16
    //   776: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   779: aload_1
    //   780: areturn
    //   781: astore_0
    //   782: goto +87 -> 869
    //   785: astore_0
    //   786: goto +68 -> 854
    //   789: astore_3
    //   790: ldc_w 396
    //   793: astore_2
    //   794: aload_0
    //   795: astore_1
    //   796: aload_3
    //   797: astore_0
    //   798: goto +71 -> 869
    //   801: astore_3
    //   802: ldc_w 396
    //   805: astore_2
    //   806: aload_0
    //   807: astore_1
    //   808: aload_3
    //   809: astore_0
    //   810: goto +44 -> 854
    //   813: astore_3
    //   814: aload_0
    //   815: astore_1
    //   816: ldc_w 396
    //   819: astore_2
    //   820: aload_3
    //   821: astore_0
    //   822: goto +47 -> 869
    //   825: astore_3
    //   826: aload_0
    //   827: astore_1
    //   828: ldc_w 396
    //   831: astore_2
    //   832: aload_3
    //   833: astore_0
    //   834: goto +20 -> 854
    //   837: astore_3
    //   838: goto +23 -> 861
    //   841: astore_3
    //   842: goto +4 -> 846
    //   845: astore_3
    //   846: ldc_w 396
    //   849: astore_2
    //   850: aload_0
    //   851: astore_1
    //   852: aload_3
    //   853: astore_0
    //   854: ldc 226
    //   856: astore_3
    //   857: goto +92 -> 949
    //   860: astore_3
    //   861: ldc_w 396
    //   864: astore_2
    //   865: aload_0
    //   866: astore_1
    //   867: aload_3
    //   868: astore_0
    //   869: invokestatic 401	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   872: ifeq +38 -> 910
    //   875: new 265	java/lang/StringBuilder
    //   878: dup
    //   879: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   882: astore_3
    //   883: aload_3
    //   884: ldc_w 1324
    //   887: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   890: pop
    //   891: aload_3
    //   892: aload_0
    //   893: invokevirtual 406	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   896: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   899: pop
    //   900: ldc 226
    //   902: iconst_2
    //   903: aload_3
    //   904: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   907: invokestatic 409	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   910: invokestatic 372	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   913: ifeq +7 -> 920
    //   916: aload_0
    //   917: invokevirtual 412	java/lang/Exception:printStackTrace	()V
    //   920: aload_1
    //   921: aload_2
    //   922: iconst_m1
    //   923: invokevirtual 349	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   926: aload_1
    //   927: ldc_w 414
    //   930: ldc_w 1326
    //   933: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   936: aload_1
    //   937: areturn
    //   938: astore_0
    //   939: ldc 226
    //   941: astore_0
    //   942: ldc_w 396
    //   945: astore_0
    //   946: aload_0
    //   947: astore 4
    //   949: invokestatic 401	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   952: ifeq +41 -> 993
    //   955: new 265	java/lang/StringBuilder
    //   958: dup
    //   959: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   962: astore 4
    //   964: aload 4
    //   966: ldc_w 1328
    //   969: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   972: pop
    //   973: aload 4
    //   975: aload_0
    //   976: invokevirtual 419	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   979: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   982: pop
    //   983: aload_3
    //   984: iconst_2
    //   985: aload 4
    //   987: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   990: invokestatic 409	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   993: invokestatic 372	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   996: ifeq +7 -> 1003
    //   999: aload_0
    //   1000: invokevirtual 420	org/json/JSONException:printStackTrace	()V
    //   1003: aload_1
    //   1004: aload_2
    //   1005: iconst_m1
    //   1006: invokevirtual 349	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1009: aload_1
    //   1010: ldc_w 414
    //   1013: ldc_w 1326
    //   1016: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1019: aload_1
    //   1020: areturn
    //   1021: aconst_null
    //   1022: astore 13
    //   1024: goto -952 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1027	0	paramAppInterface	AppInterface
    //   0	1027	1	paramActivity	Activity
    //   0	1027	2	paramResultReceiver	ResultReceiver
    //   0	1027	3	paramString1	String
    //   0	1027	4	paramString2	String
    //   0	1027	5	paramInt	int
    //   0	1027	6	paramLong1	long
    //   0	1027	8	paramLong2	long
    //   0	1027	10	paramString3	String
    //   49	656	11	bool	boolean
    //   39	141	12	str1	String
    //   67	420	13	str2	String
    //   89	375	14	str3	String
    //   120	470	15	str4	String
    //   172	603	16	str5	String
    //   221	379	17	str6	String
    //   52	558	18	str7	String
    //   275	344	19	str8	String
    //   305	323	20	str9	String
    //   158	479	21	str10	String
    //   26	741	22	str11	String
    //   35	514	23	str12	String
    //   17	382	24	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   112	122	125	org/json/JSONException
    //   165	174	177	org/json/JSONException
    //   213	223	177	org/json/JSONException
    //   244	254	177	org/json/JSONException
    //   268	277	177	org/json/JSONException
    //   298	307	177	org/json/JSONException
    //   328	337	177	org/json/JSONException
    //   375	392	177	org/json/JSONException
    //   451	468	177	org/json/JSONException
    //   473	491	177	org/json/JSONException
    //   709	744	177	org/json/JSONException
    //   757	779	781	java/lang/Exception
    //   757	779	785	org/json/JSONException
    //   147	156	789	java/lang/Exception
    //   165	174	789	java/lang/Exception
    //   198	208	789	java/lang/Exception
    //   213	223	789	java/lang/Exception
    //   229	239	789	java/lang/Exception
    //   244	254	789	java/lang/Exception
    //   254	263	789	java/lang/Exception
    //   268	277	789	java/lang/Exception
    //   284	293	789	java/lang/Exception
    //   298	307	789	java/lang/Exception
    //   314	323	789	java/lang/Exception
    //   328	337	789	java/lang/Exception
    //   337	370	789	java/lang/Exception
    //   375	392	789	java/lang/Exception
    //   392	446	789	java/lang/Exception
    //   451	468	789	java/lang/Exception
    //   473	491	789	java/lang/Exception
    //   491	704	789	java/lang/Exception
    //   709	744	789	java/lang/Exception
    //   744	751	789	java/lang/Exception
    //   147	156	801	org/json/JSONException
    //   198	208	801	org/json/JSONException
    //   229	239	801	org/json/JSONException
    //   254	263	801	org/json/JSONException
    //   284	293	801	org/json/JSONException
    //   314	323	801	org/json/JSONException
    //   337	370	801	org/json/JSONException
    //   392	446	801	org/json/JSONException
    //   491	704	801	org/json/JSONException
    //   744	751	801	org/json/JSONException
    //   97	107	813	java/lang/Exception
    //   112	122	813	java/lang/Exception
    //   97	107	825	org/json/JSONException
    //   41	51	837	java/lang/Exception
    //   59	69	837	java/lang/Exception
    //   72	91	837	java/lang/Exception
    //   41	51	841	org/json/JSONException
    //   59	69	841	org/json/JSONException
    //   72	91	841	org/json/JSONException
    //   8	37	845	org/json/JSONException
    //   8	37	860	java/lang/Exception
  }
  
  private static void remove(PayLogicImpl paramPayLogicImpl)
  {
    if (paramPayLogicImpl != null) {
      sPayLogics.remove(paramPayLogicImpl.getTag());
    }
  }
  
  private void saveNonePCPayResultData(int paramInt, Intent paramIntent)
  {
    if ((!this.isFromPCPush) && (this.saveResultData == null))
    {
      this.saveResultData = paramIntent;
      this.saveResultCode = paramInt;
    }
  }
  
  private void setActivityRef(QBaseActivity paramQBaseActivity)
  {
    if (paramQBaseActivity != null) {
      this.mActivity = paramQBaseActivity;
    }
  }
  
  public static void setIPCReceiver(ResultReceiver paramResultReceiver, Bundle paramBundle)
  {
    if ((paramResultReceiver != null) && (paramBundle != null))
    {
      Parcel localParcel = Parcel.obtain();
      paramResultReceiver.writeToParcel(localParcel, 0);
      localParcel.setDataPosition(0);
      paramResultReceiver = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(localParcel);
      localParcel.recycle();
      paramBundle.putParcelable("_qwallet_payresult_receiver", paramResultReceiver);
    }
  }
  
  public static void setIsPaying(boolean paramBoolean)
  {
    isPaying = paramBoolean;
  }
  
  /* Error */
  protected static Bundle subscribeMonthCardPay(AppInterface paramAppInterface, Activity paramActivity, ResultReceiver paramResultReceiver, String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2, String paramString3)
  {
    // Byte code:
    //   0: new 212	android/os/Bundle
    //   3: dup
    //   4: invokespecial 213	android/os/Bundle:<init>	()V
    //   7: astore_0
    //   8: new 215	org/json/JSONObject
    //   11: dup
    //   12: aload 4
    //   14: invokespecial 218	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   17: astore 27
    //   19: aload 27
    //   21: ldc 220
    //   23: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   26: astore 28
    //   28: aload 27
    //   30: ldc_w 306
    //   33: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   36: ifeq +16 -> 52
    //   39: aload 27
    //   41: ldc_w 306
    //   44: invokevirtual 243	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   47: istore 11
    //   49: goto +6 -> 55
    //   52: iconst_1
    //   53: istore 11
    //   55: aload 27
    //   57: ldc 245
    //   59: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   62: istore 12
    //   64: aconst_null
    //   65: astore 16
    //   67: iload 12
    //   69: ifeq +15 -> 84
    //   72: aload 27
    //   74: ldc 245
    //   76: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   79: astore 14
    //   81: goto +6 -> 87
    //   84: aconst_null
    //   85: astore 14
    //   87: aload 27
    //   89: ldc 228
    //   91: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   94: astore 29
    //   96: aload 27
    //   98: ldc_w 573
    //   101: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   104: astore 30
    //   106: aload 27
    //   108: ldc_w 577
    //   111: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   114: astore 31
    //   116: aload 27
    //   118: ldc_w 814
    //   121: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   124: ifeq +1100 -> 1224
    //   127: aload 27
    //   129: ldc_w 814
    //   132: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   135: astore 15
    //   137: goto +3 -> 140
    //   140: aload 27
    //   142: ldc_w 551
    //   145: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   148: ifeq +13 -> 161
    //   151: aload 27
    //   153: ldc_w 551
    //   156: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   159: astore 16
    //   161: aload 27
    //   163: ldc_w 553
    //   166: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   169: ifeq +1061 -> 1230
    //   172: aload 27
    //   174: ldc_w 553
    //   177: invokevirtual 243	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   180: istore 12
    //   182: goto +3 -> 185
    //   185: aload 27
    //   187: ldc_w 583
    //   190: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   193: istore 13
    //   195: ldc 249
    //   197: astore 26
    //   199: iload 13
    //   201: ifeq +1035 -> 1236
    //   204: aload 27
    //   206: ldc_w 583
    //   209: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   212: astore 18
    //   214: goto +3 -> 217
    //   217: aload 27
    //   219: ldc_w 1016
    //   222: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   225: ifeq +1018 -> 1243
    //   228: aload 27
    //   230: ldc_w 1016
    //   233: invokevirtual 243	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   236: istore 13
    //   238: goto +3 -> 241
    //   241: aload 27
    //   243: ldc 247
    //   245: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   248: ifeq +1001 -> 1249
    //   251: aload 27
    //   253: ldc 247
    //   255: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   258: astore 17
    //   260: goto +3 -> 263
    //   263: aload 27
    //   265: ldc_w 1367
    //   268: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   271: ifeq +985 -> 1256
    //   274: aload 27
    //   276: ldc_w 1367
    //   279: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   282: astore 19
    //   284: goto +3 -> 287
    //   287: aload 27
    //   289: ldc_w 1059
    //   292: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   295: ifeq +968 -> 1263
    //   298: aload 27
    //   300: ldc_w 1059
    //   303: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   306: astore 20
    //   308: goto +3 -> 311
    //   311: aload 27
    //   313: ldc 253
    //   315: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   318: ifeq +952 -> 1270
    //   321: aload 27
    //   323: ldc 253
    //   325: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   328: astore 21
    //   330: goto +3 -> 333
    //   333: aload 27
    //   335: ldc 255
    //   337: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   340: ifeq +937 -> 1277
    //   343: aload 27
    //   345: ldc 255
    //   347: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   350: astore 22
    //   352: goto +3 -> 355
    //   355: aload 27
    //   357: ldc_w 257
    //   360: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   363: ifeq +921 -> 1284
    //   366: aload 27
    //   368: ldc_w 257
    //   371: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   374: astore 23
    //   376: goto +3 -> 379
    //   379: aload 27
    //   381: ldc_w 569
    //   384: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   387: ifeq +904 -> 1291
    //   390: aload 27
    //   392: ldc_w 569
    //   395: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   398: astore 24
    //   400: goto +3 -> 403
    //   403: aload 27
    //   405: ldc_w 571
    //   408: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   411: ifeq +887 -> 1298
    //   414: aload 27
    //   416: ldc_w 571
    //   419: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   422: astore 25
    //   424: goto +3 -> 427
    //   427: aload 27
    //   429: ldc 251
    //   431: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   434: ifeq +12 -> 446
    //   437: aload 27
    //   439: ldc 251
    //   441: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   444: astore 26
    //   446: aload 27
    //   448: ldc_w 325
    //   451: invokevirtual 236	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   454: ifeq +16 -> 470
    //   457: aload 27
    //   459: ldc_w 325
    //   462: invokevirtual 224	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   465: astore 27
    //   467: goto +54 -> 521
    //   470: new 265	java/lang/StringBuilder
    //   473: dup
    //   474: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   477: astore 27
    //   479: aload 27
    //   481: ldc_w 327
    //   484: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: pop
    //   488: aload 27
    //   490: invokestatic 332	com/tencent/common/config/AppSetting:d	()I
    //   493: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   496: pop
    //   497: aload 27
    //   499: ldc_w 337
    //   502: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: pop
    //   506: aload 27
    //   508: aload 17
    //   510: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: pop
    //   514: aload 27
    //   516: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   519: astore 27
    //   521: new 265	java/lang/StringBuilder
    //   524: dup
    //   525: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   528: astore 32
    //   530: aload 32
    //   532: ldc_w 268
    //   535: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: pop
    //   539: aload 32
    //   541: aload 4
    //   543: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: pop
    //   547: aload 10
    //   549: invokestatic 277	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   552: ifne +20 -> 572
    //   555: aload 32
    //   557: ldc_w 279
    //   560: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: pop
    //   564: aload 32
    //   566: aload 10
    //   568: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: pop
    //   572: lload 8
    //   574: aconst_null
    //   575: ldc_w 281
    //   578: aload 32
    //   580: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   583: iconst_0
    //   584: aconst_null
    //   585: invokestatic 290	com/tencent/mobileqq/qwallet/report/VACDReportUtil:a	(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   588: new 212	android/os/Bundle
    //   591: dup
    //   592: invokespecial 213	android/os/Bundle:<init>	()V
    //   595: astore 4
    //   597: aload 4
    //   599: ldc_w 296
    //   602: ldc_w 298
    //   605: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   608: aload 4
    //   610: ldc_w 300
    //   613: iconst_0
    //   614: invokevirtual 304	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   617: aload 4
    //   619: ldc 220
    //   621: aload 28
    //   623: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   626: aload 4
    //   628: ldc_w 306
    //   631: iload 11
    //   633: invokevirtual 304	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   636: aload 14
    //   638: ifnull +20 -> 658
    //   641: aload 14
    //   643: invokevirtual 321	java/lang/String:length	()I
    //   646: ifle +12 -> 658
    //   649: aload 4
    //   651: ldc 245
    //   653: aload 14
    //   655: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   658: aload 15
    //   660: ifnull +21 -> 681
    //   663: aload 15
    //   665: invokevirtual 321	java/lang/String:length	()I
    //   668: ifle +13 -> 681
    //   671: aload 4
    //   673: ldc_w 836
    //   676: aload 15
    //   678: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   681: aload 4
    //   683: ldc_w 323
    //   686: aload_3
    //   687: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   690: aload 4
    //   692: ldc 228
    //   694: aload 29
    //   696: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   699: aload 4
    //   701: ldc_w 339
    //   704: ldc_w 341
    //   707: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   710: aload 4
    //   712: ldc_w 325
    //   715: aload 27
    //   717: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   720: aload 4
    //   722: ldc_w 343
    //   725: ldc_w 343
    //   728: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   731: aload 16
    //   733: ifnull +37 -> 770
    //   736: aload 16
    //   738: invokevirtual 321	java/lang/String:length	()I
    //   741: ifle +29 -> 770
    //   744: aload 4
    //   746: ldc_w 551
    //   749: aload 16
    //   751: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   754: aload 4
    //   756: ldc_w 553
    //   759: iload 12
    //   761: invokestatic 312	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   764: invokevirtual 316	java/lang/Boolean:booleanValue	()Z
    //   767: invokevirtual 304	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   770: aload 4
    //   772: ldc_w 345
    //   775: iconst_0
    //   776: invokevirtual 349	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   779: aload 4
    //   781: ldc_w 573
    //   784: aload 30
    //   786: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   789: aload 4
    //   791: ldc_w 577
    //   794: aload 31
    //   796: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   799: aload 4
    //   801: ldc_w 583
    //   804: aload 18
    //   806: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   809: aload 4
    //   811: ldc_w 1016
    //   814: iload 13
    //   816: invokestatic 312	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   819: invokevirtual 316	java/lang/Boolean:booleanValue	()Z
    //   822: invokevirtual 304	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   825: aload 4
    //   827: ldc_w 1367
    //   830: aload 19
    //   832: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   835: aload 4
    //   837: ldc_w 1059
    //   840: aload 20
    //   842: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   845: aload 4
    //   847: ldc 253
    //   849: aload 21
    //   851: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   854: aload 4
    //   856: ldc 255
    //   858: aload 22
    //   860: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   863: aload 4
    //   865: ldc_w 257
    //   868: aload 23
    //   870: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   873: aload 4
    //   875: ldc_w 569
    //   878: aload 24
    //   880: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   883: aload 4
    //   885: ldc_w 571
    //   888: aload 25
    //   890: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   893: aload 4
    //   895: ldc 251
    //   897: aload 26
    //   899: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   902: aload 4
    //   904: ldc_w 351
    //   907: bipush 14
    //   909: invokevirtual 349	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   912: aload 4
    //   914: ldc_w 353
    //   917: iload 5
    //   919: invokevirtual 349	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   922: aload 4
    //   924: ldc_w 355
    //   927: lload 6
    //   929: invokevirtual 359	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   932: aload 4
    //   934: ldc_w 361
    //   937: lload 8
    //   939: invokevirtual 359	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   942: aload_2
    //   943: aload 4
    //   945: invokestatic 365	cooperation/qwallet/plugin/impl/PayLogicImpl:setIPCReceiver	(Landroid/os/ResultReceiver;Landroid/os/Bundle;)V
    //   948: lload 8
    //   950: aconst_null
    //   951: ldc_w 367
    //   954: aconst_null
    //   955: iconst_0
    //   956: aconst_null
    //   957: invokestatic 290	com/tencent/mobileqq/qwallet/report/VACDReportUtil:a	(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   960: invokestatic 372	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   963: ifeq +38 -> 1001
    //   966: new 265	java/lang/StringBuilder
    //   969: dup
    //   970: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   973: astore_2
    //   974: aload_2
    //   975: ldc_w 374
    //   978: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   981: pop
    //   982: aload_2
    //   983: invokestatic 380	java/lang/System:currentTimeMillis	()J
    //   986: invokevirtual 383	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   989: pop
    //   990: ldc_w 385
    //   993: iconst_4
    //   994: aload_2
    //   995: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   998: invokestatic 388	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1001: aload_1
    //   1002: aload 4
    //   1004: invokestatic 394	cooperation/qwallet/plugin/QWalletPayBridge:launchForeground	(Landroid/app/Activity;Landroid/os/Bundle;)Z
    //   1007: pop
    //   1008: ldc_w 396
    //   1011: astore_2
    //   1012: aload_0
    //   1013: aload_2
    //   1014: iconst_0
    //   1015: invokevirtual 349	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1018: aload_0
    //   1019: ldc 220
    //   1021: aload 28
    //   1023: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1026: aload_0
    //   1027: ldc 247
    //   1029: aload 17
    //   1031: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1034: aload_0
    //   1035: areturn
    //   1036: astore_1
    //   1037: goto +44 -> 1081
    //   1040: astore_1
    //   1041: goto +114 -> 1155
    //   1044: astore_1
    //   1045: ldc_w 396
    //   1048: astore_2
    //   1049: goto +32 -> 1081
    //   1052: astore_1
    //   1053: ldc_w 396
    //   1056: astore_2
    //   1057: goto +98 -> 1155
    //   1060: astore_1
    //   1061: ldc_w 396
    //   1064: astore_2
    //   1065: goto +16 -> 1081
    //   1068: astore_1
    //   1069: ldc_w 396
    //   1072: astore_2
    //   1073: goto +82 -> 1155
    //   1076: astore_1
    //   1077: ldc_w 396
    //   1080: astore_2
    //   1081: invokestatic 401	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1084: ifeq +38 -> 1122
    //   1087: new 265	java/lang/StringBuilder
    //   1090: dup
    //   1091: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   1094: astore_3
    //   1095: aload_3
    //   1096: ldc_w 1369
    //   1099: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1102: pop
    //   1103: aload_3
    //   1104: aload_1
    //   1105: invokevirtual 406	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1108: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1111: pop
    //   1112: ldc 226
    //   1114: iconst_2
    //   1115: aload_3
    //   1116: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1119: invokestatic 409	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1122: invokestatic 372	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1125: ifeq +7 -> 1132
    //   1128: aload_1
    //   1129: invokevirtual 412	java/lang/Exception:printStackTrace	()V
    //   1132: aload_0
    //   1133: aload_2
    //   1134: iconst_m1
    //   1135: invokevirtual 349	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1138: aload_0
    //   1139: ldc_w 414
    //   1142: ldc_w 1371
    //   1145: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1148: aload_0
    //   1149: areturn
    //   1150: astore_1
    //   1151: ldc_w 396
    //   1154: astore_2
    //   1155: invokestatic 401	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1158: ifeq +38 -> 1196
    //   1161: new 265	java/lang/StringBuilder
    //   1164: dup
    //   1165: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   1168: astore_3
    //   1169: aload_3
    //   1170: ldc_w 1373
    //   1173: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1176: pop
    //   1177: aload_3
    //   1178: aload_1
    //   1179: invokevirtual 419	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   1182: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1185: pop
    //   1186: ldc 226
    //   1188: iconst_2
    //   1189: aload_3
    //   1190: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1193: invokestatic 409	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1196: invokestatic 372	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1199: ifeq +7 -> 1206
    //   1202: aload_1
    //   1203: invokevirtual 420	org/json/JSONException:printStackTrace	()V
    //   1206: aload_0
    //   1207: aload_2
    //   1208: iconst_m1
    //   1209: invokevirtual 349	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1212: aload_0
    //   1213: ldc_w 414
    //   1216: ldc_w 1375
    //   1219: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1222: aload_0
    //   1223: areturn
    //   1224: aconst_null
    //   1225: astore 15
    //   1227: goto -1087 -> 140
    //   1230: iconst_0
    //   1231: istore 12
    //   1233: goto -1048 -> 185
    //   1236: ldc 249
    //   1238: astore 18
    //   1240: goto -1023 -> 217
    //   1243: iconst_1
    //   1244: istore 13
    //   1246: goto -1005 -> 241
    //   1249: ldc 249
    //   1251: astore 17
    //   1253: goto -990 -> 263
    //   1256: ldc 249
    //   1258: astore 19
    //   1260: goto -973 -> 287
    //   1263: ldc 249
    //   1265: astore 20
    //   1267: goto -956 -> 311
    //   1270: ldc 249
    //   1272: astore 21
    //   1274: goto -941 -> 333
    //   1277: ldc 249
    //   1279: astore 22
    //   1281: goto -926 -> 355
    //   1284: ldc 249
    //   1286: astore 23
    //   1288: goto -909 -> 379
    //   1291: ldc 249
    //   1293: astore 24
    //   1295: goto -892 -> 403
    //   1298: ldc 249
    //   1300: astore 25
    //   1302: goto -875 -> 427
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1305	0	paramAppInterface	AppInterface
    //   0	1305	1	paramActivity	Activity
    //   0	1305	2	paramResultReceiver	ResultReceiver
    //   0	1305	3	paramString1	String
    //   0	1305	4	paramString2	String
    //   0	1305	5	paramInt	int
    //   0	1305	6	paramLong1	long
    //   0	1305	8	paramLong2	long
    //   0	1305	10	paramString3	String
    //   47	585	11	bool1	boolean
    //   62	1170	12	bool2	boolean
    //   193	1052	13	bool3	boolean
    //   79	575	14	str1	String
    //   135	1091	15	str2	String
    //   65	685	16	str3	String
    //   258	994	17	str4	String
    //   212	1027	18	str5	String
    //   282	977	19	str6	String
    //   306	960	20	str7	String
    //   328	945	21	str8	String
    //   350	930	22	str9	String
    //   374	913	23	str10	String
    //   398	896	24	str11	String
    //   422	879	25	str12	String
    //   197	701	26	str13	String
    //   17	699	27	localObject	Object
    //   26	996	28	str14	String
    //   94	601	29	str15	String
    //   104	681	30	str16	String
    //   114	681	31	str17	String
    //   528	51	32	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   1012	1034	1036	java/lang/Exception
    //   1012	1034	1040	org/json/JSONException
    //   87	137	1044	java/lang/Exception
    //   140	161	1044	java/lang/Exception
    //   161	182	1044	java/lang/Exception
    //   185	195	1044	java/lang/Exception
    //   204	214	1044	java/lang/Exception
    //   217	238	1044	java/lang/Exception
    //   241	260	1044	java/lang/Exception
    //   263	284	1044	java/lang/Exception
    //   287	308	1044	java/lang/Exception
    //   311	330	1044	java/lang/Exception
    //   333	352	1044	java/lang/Exception
    //   355	376	1044	java/lang/Exception
    //   379	400	1044	java/lang/Exception
    //   403	424	1044	java/lang/Exception
    //   427	446	1044	java/lang/Exception
    //   446	467	1044	java/lang/Exception
    //   470	521	1044	java/lang/Exception
    //   521	572	1044	java/lang/Exception
    //   572	636	1044	java/lang/Exception
    //   641	658	1044	java/lang/Exception
    //   663	681	1044	java/lang/Exception
    //   681	731	1044	java/lang/Exception
    //   736	770	1044	java/lang/Exception
    //   770	1001	1044	java/lang/Exception
    //   1001	1008	1044	java/lang/Exception
    //   87	137	1052	org/json/JSONException
    //   140	161	1052	org/json/JSONException
    //   161	182	1052	org/json/JSONException
    //   185	195	1052	org/json/JSONException
    //   204	214	1052	org/json/JSONException
    //   217	238	1052	org/json/JSONException
    //   241	260	1052	org/json/JSONException
    //   263	284	1052	org/json/JSONException
    //   287	308	1052	org/json/JSONException
    //   311	330	1052	org/json/JSONException
    //   333	352	1052	org/json/JSONException
    //   355	376	1052	org/json/JSONException
    //   379	400	1052	org/json/JSONException
    //   403	424	1052	org/json/JSONException
    //   427	446	1052	org/json/JSONException
    //   446	467	1052	org/json/JSONException
    //   470	521	1052	org/json/JSONException
    //   521	572	1052	org/json/JSONException
    //   572	636	1052	org/json/JSONException
    //   641	658	1052	org/json/JSONException
    //   663	681	1052	org/json/JSONException
    //   681	731	1052	org/json/JSONException
    //   736	770	1052	org/json/JSONException
    //   770	1001	1052	org/json/JSONException
    //   1001	1008	1052	org/json/JSONException
    //   55	64	1060	java/lang/Exception
    //   72	81	1060	java/lang/Exception
    //   55	64	1068	org/json/JSONException
    //   72	81	1068	org/json/JSONException
    //   8	49	1076	java/lang/Exception
    //   8	49	1150	org/json/JSONException
  }
  
  private void tenpayResult(Bundle paramBundle)
  {
    Object localObject1 = null;
    String str;
    if (paramBundle != null)
    {
      if (this.mIsStartReport)
      {
        int i = paramBundle.getInt("payRetCode", -1);
        long l = paramBundle.getLong("reportSeq", 0L);
        if ((this.mIsStartReport) && (l > 0L)) {
          VACDReportUtil.endReport(l, "payEnd", null, i, null);
        }
      }
      localObject1 = paramBundle.getString("callbackSn");
      str = paramBundle.getString("result");
    }
    else
    {
      paramBundle = new Bundle();
      str = null;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("get callbackSn = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.i("Q.qwallet.pay.PayLogic", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = localObject1;
    if (this.intentData != null)
    {
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = this.intentData.getString("callbackSn");
      }
    }
    if (this.mResultReceiver != null)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("receiver back : ");
        ((StringBuilder)localObject1).append(paramBundle);
        QLog.i("Q.qwallet.pay.PayLogic", 2, ((StringBuilder)localObject1).toString());
      }
      this.mResultReceiver.send(0, paramBundle);
    }
    paramBundle = new Intent();
    paramBundle.putExtra("result", str);
    paramBundle.putExtra("callbackSn", (String)localObject2);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("PayBridgeActivity tenpayResult:callbackSn=");
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(",result=");
      ((StringBuilder)localObject1).append(str);
      QLog.i("Q.qwallet.pay.PayLogic", 2, ((StringBuilder)localObject1).toString());
    }
    this.mActivity.setResult(-1, paramBundle);
    saveNonePCPayResultData(-1, paramBundle);
    end();
  }
  
  private void tenpayResult(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("callbackSn", paramString1);
    localBundle.putString("result", paramString2);
    tenpayResult(localBundle);
  }
  
  protected String convertToReportAction(int paramInt)
  {
    if (this.isFromPCPush)
    {
      if (paramInt == 4) {
        return "openService-push";
      }
      if (paramInt == 6) {
        return "rechargeGameCurrency-push";
      }
      if (paramInt == 7) {
        return "buyGoods-push";
      }
      if (paramInt == 8) {
        return "rechargeQb-push";
      }
      if (paramInt == 9) {
        return "pay-push";
      }
      if (paramInt == 14) {
        return "monthCardPay-push";
      }
      if (paramInt == 11) {
        return "openSVip-push";
      }
    }
    else
    {
      if (paramInt == 4) {
        return "openService-nt";
      }
      if (paramInt == 6) {
        return "rechargeGameCurrency-nt";
      }
      if (paramInt == 7) {
        return "buyGoods-nt";
      }
      if (paramInt == 8) {
        return "rechargeQb-nt";
      }
      if (paramInt == 9) {
        return "pay-native";
      }
      if (paramInt == 14) {
        return "monthCardPay-nt";
      }
      if (paramInt == 11) {
        return "openSVip-nt";
      }
    }
    return null;
  }
  
  public void doOnRestoreInstanceState(Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnRestoreInstanceState savedInstanceState=");
      localStringBuilder.append(paramBundle);
      QLog.i("Q.qwallet.pay.PayLogic", 2, localStringBuilder.toString());
    }
    if (paramBundle == null) {
      return;
    }
    this.mPayType = paramBundle.getInt("mPayType", -1);
    this.mPayTokenId = paramBundle.getString("mPayTokenId");
    this.mPayAppId = paramBundle.getString("mPayAppId");
    this.mPayChannel = paramBundle.getString("mPayChannel");
    this.mPayBargainorId = paramBundle.getString("mPayBargainorId");
    this.mMidasOfferid = paramBundle.getString("mMidasOfferid");
    this.mMidasAid = paramBundle.getString("mMidasAid");
    this.mMidasOrderId = paramBundle.getString("mMidasOrderId");
    this.mOpenViewTag = paramBundle.getString("mOpenViewTag");
  }
  
  public void doOnSaveInstanceState(Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnSaveInstanceState outState=");
      localStringBuilder.append(paramBundle);
      QLog.i("Q.qwallet.pay.PayLogic", 2, localStringBuilder.toString());
    }
    if (paramBundle == null) {
      return;
    }
    paramBundle.putInt("mPayType", this.mPayType);
    paramBundle.putString("mPayTokenId", this.mPayTokenId);
    paramBundle.putString("mPayAppId", this.mPayAppId);
    paramBundle.putString("mPayChannel", this.mPayChannel);
    paramBundle.putString("mPayBargainorId", this.mPayBargainorId);
    paramBundle.putString("mMidasOfferid", this.mMidasOfferid);
    paramBundle.putString("mMidasAid", this.mMidasAid);
    paramBundle.putString("mMidasOrderId", this.mMidasOrderId);
    paramBundle.putString("mOpenViewTag", this.mOpenViewTag);
  }
  
  public void end()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.pay.PayLogic", 2, "end()");
    }
    ((IQWalletPayApi)QRoute.api(IQWalletPayApi.class)).removePayingData();
    int i = ((IQWalletPayApi)QRoute.api(IQWalletPayApi.class)).getIdlePayDataCount();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("finish idlePayCount=");
      ((StringBuilder)localObject1).append(i);
      QLog.i("Q.qwallet.pay.PayLogic", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = this.mActivity;
    if ((i > 0) && (localObject1 != null))
    {
      Object localObject2 = new Intent();
      ((Intent)localObject2).addFlags(536870912);
      RouteUtils.a((Context)localObject1, (Intent)localObject2, "/base/payBridge");
      localObject1 = createCustomDialog("我的钱包", String.format(((QBaseActivity)localObject1).getString(R.string.do), new Object[] { Integer.valueOf(i) }), null);
      ((Dialog)localObject1).setCancelable(false);
      localObject2 = new PayLogicImpl.3(this, (Dialog)localObject1);
      ((Dialog)localObject1).findViewById(R.id.C).setOnClickListener((View.OnClickListener)localObject2);
      ((Dialog)localObject1).findViewById(R.id.B).setOnClickListener((View.OnClickListener)localObject2);
      ((Dialog)localObject1).setOnDismissListener(new PayLogicImpl.4(this));
      try
      {
        ((Dialog)localObject1).show();
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("Q.qwallet.pay.PayLogic", 2, localThrowable.getMessage());
        return;
      }
    }
    tryNonPCPay();
    setIsPaying(false);
    onEndFinished();
  }
  
  public void exec()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.pay.PayLogic", 2, "exec()");
    }
    Object localObject1 = this.mActivity;
    int i = this.mRequestCode;
    if (i == 12)
    {
      if (((IQWalletTemp)QRoute.api(IQWalletTemp.class)).GesturePWDUtils$getJumpLock((Context)localObject1, this.app.getCurrentAccountUin()))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.qwallet.push", 2, "moveTaskToBack and startUnlockActivity...");
        }
        ((QBaseActivity)localObject1).startUnlockActivity();
        onEndFinished();
        return;
      }
      if (isPaying)
      {
        onEndFinished();
        return;
      }
      isPaying = true;
      this.isFromPCPush = true;
      this.isPCPushDesc = true;
      startPCPushPay(((IQWalletPayApi)QRoute.api(IQWalletPayApi.class)).getIdlePayData(this.isPCPushDesc));
      return;
    }
    isPaying = true;
    if (i != 13)
    {
      if (i != 14)
      {
        if (i != 200) {
          if (i == 201) {}
        }
        switch (i)
        {
        default: 
          end();
          return;
        case 11: 
          openSVip(this.intentData);
          return;
        case 10: 
          openQzoneVipService(this.intentData);
          return;
        case 5: 
          openTenpayView(this.intentData);
          return;
        case 3: 
          doOpenQQReaderVip(this.intentData);
          return;
        case 2: 
          doGoldCharge(this.intentData);
          return;
        case 1: 
          localObject1 = DataFactory.EmojiPayReqData.a(this.intentData);
          if ((localObject1 != null) && (checkEmojiPayParam((DataFactory.EmojiPayReqData)localObject1)))
          {
            doEmojimallPay((DataFactory.EmojiPayReqData)localObject1);
            return;
          }
          OnEmojimallPayResult((DataFactory.EmojiPayReqData)localObject1, -1, 0, -1, -1, -1, "param error");
          if (localObject1 == null)
          {
            if (QLog.isColorLevel()) {
              QLog.i("Q.qwallet.pay.PayLogic", 2, "emojimall pay paramerror: reqData:null");
            }
          }
          else if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("emojimall pay paramerror:userid:");
            ((StringBuilder)localObject2).append(((DataFactory.EmojiPayReqData)localObject1).c);
            ((StringBuilder)localObject2).append("userkey:");
            ((StringBuilder)localObject2).append(((DataFactory.EmojiPayReqData)localObject1).d);
            ((StringBuilder)localObject2).append("sessionid:");
            ((StringBuilder)localObject2).append(((DataFactory.EmojiPayReqData)localObject1).e);
            ((StringBuilder)localObject2).append("sessionType:");
            ((StringBuilder)localObject2).append(((DataFactory.EmojiPayReqData)localObject1).f);
            ((StringBuilder)localObject2).append("zoneId:");
            ((StringBuilder)localObject2).append(((DataFactory.EmojiPayReqData)localObject1).g);
            ((StringBuilder)localObject2).append("pf:");
            ((StringBuilder)localObject2).append(((DataFactory.EmojiPayReqData)localObject1).h);
            ((StringBuilder)localObject2).append("pfKey:");
            ((StringBuilder)localObject2).append(((DataFactory.EmojiPayReqData)localObject1).i);
            ((StringBuilder)localObject2).append("tokenUrl:");
            ((StringBuilder)localObject2).append(((DataFactory.EmojiPayReqData)localObject1).j);
            ((StringBuilder)localObject2).append("discountId:");
            ((StringBuilder)localObject2).append(((DataFactory.EmojiPayReqData)localObject1).k);
            ((StringBuilder)localObject2).append("other:");
            ((StringBuilder)localObject2).append(((DataFactory.EmojiPayReqData)localObject1).l);
            ((StringBuilder)localObject2).append("payload:");
            ((StringBuilder)localObject2).append(((DataFactory.EmojiPayReqData)localObject1).m);
            QLog.i("Q.qwallet.pay.PayLogic", 2, ((StringBuilder)localObject2).toString());
          }
          isPaying = false;
          end();
          return;
          onQWalletCrash();
          return;
          onF2FRedpackCheckError();
          return;
        }
      }
      newPay(this.mRequestCode, this.intentData);
      return;
    }
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("PayInvokerId", 12);
    putProxyReceiverToBundle((Bundle)localObject2);
    QWalletPayBridge.launchForeground((Activity)localObject1, (Bundle)localObject2);
  }
  
  public IPayLogic getLogic(int paramInt)
  {
    return (IPayLogic)sPayLogics.get(paramInt);
  }
  
  public int getTag()
  {
    return hashCode();
  }
  
  public boolean init(Intent paramIntent, AppRuntime paramAppRuntime, Activity paramActivity)
  {
    this.intent = paramIntent;
    this.app = ((BaseQQAppInterface)paramAppRuntime);
    this.mActivity = ((QBaseActivity)paramActivity);
    add(this);
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.pay.PayLogic", 2, "init()");
    }
    if ((paramIntent != null) && (paramIntent.getExtras() != null))
    {
      this.intentData = paramIntent.getExtras();
      this.mResultReceiver = ((ResultReceiver)this.intentData.getParcelable("receiver"));
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("specified receiver = ");
        paramIntent.append(this.mResultReceiver);
        QLog.e("Q.qwallet.pay.PayLogic", 2, paramIntent.toString());
      }
      this.mRequestCode = this.intentData.getInt("pay_requestcode", -1);
      this.mPayType = this.intentData.getInt("payparmas_paytype", -1);
      this.isLockWithdraw = isLockWithdraw(this.mPayType, this.intentData);
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("isLockWithdraw = ");
        paramIntent.append(this.isLockWithdraw);
        QLog.e("Q.qwallet.pay.PayLogic", 2, paramIntent.toString());
      }
      if (!isLoginParamsValid())
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qwallet.pay.PayLogic", 2, "PayBridgeActivity.doOnCreate login params error");
        }
        return false;
      }
      QQNotificationManager.getInstance().cancel("Q.qwallet.pay.PayLogic", 238);
      this.isFromPCPush = this.intentData.getBoolean("payparmas_from_pcpush", false);
      this.mPayH5StartTime = this.intentData.getLong("payparmas_h5_start", 0L);
      this.mReportSeq = this.intentData.getLong("vacreport_key_seq", 0L);
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.qwallet.pay.PayLogic", 2, "init extras is null");
    }
    return false;
  }
  
  public boolean isPaying()
  {
    return isPaying;
  }
  
  public Bundle newPay(AppInterface paramAppInterface, Activity paramActivity, ResultReceiver paramResultReceiver, int paramInt, Bundle paramBundle)
  {
    Object localObject = paramActivity;
    Bundle localBundle = new Bundle();
    paramActivity = (Activity)localObject;
    if ((localObject instanceof BasePluginActivity))
    {
      localObject = ((BasePluginActivity)localObject).getOutActivity();
      paramActivity = (Activity)localObject;
      if ((localObject instanceof BasePluginActivity)) {
        paramActivity = ((BasePluginActivity)localObject).getOutActivity();
      }
    }
    int i = 1;
    if ((paramAppInterface == null) || (paramActivity == null)) {
      i = 0;
    }
    String str1;
    String str2;
    int j;
    long l2;
    String str3;
    long l1;
    if (paramBundle != null)
    {
      str1 = paramBundle.getString("payparmas_callback_sn");
      str2 = paramBundle.getString("payparmas_json");
      j = paramBundle.getInt("payparmas_paytype", -1);
      l2 = paramBundle.getLong("payparmas_h5_start", 0L);
      str3 = paramBundle.getString("payparmas_url_appinfo");
      l1 = paramBundle.getLong("vacreport_key_seq", 0L);
      localObject = paramBundle.getString("payparmas_h5_url");
      if ((j == -1) || (TextUtils.isEmpty(str2))) {
        i = 0;
      }
      if ((paramInt != 6) && (paramInt != 7) && (paramInt != 8) && (paramInt != 4) && (paramInt != 9) && (paramInt != 14) && (paramInt != 17)) {
        i = 0;
      }
    }
    else
    {
      str1 = "";
      str3 = str1;
      i = 0;
      str2 = null;
      j = -1;
      localObject = null;
      l2 = 0L;
      l1 = 0L;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("from static method invokerId:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" request=");
      localStringBuilder.append(str2);
      localStringBuilder.append(",callbackSn=");
      localStringBuilder.append(str1);
      QLog.i("Q.qwallet.pay.PayLogic", 2, localStringBuilder.toString());
    }
    if (i == 0)
    {
      localBundle.putInt("retCode", -1);
      localBundle.putString("retJson", "{'resultCode':-1,'resultMsg':'System error.'}");
      return localBundle;
    }
    long l3 = l1;
    if (l1 == 0L)
    {
      l3 = VACDReportUtil.a(null, "qqwallet", invokerIdToAction(paramInt), "payinvoke", null, 0, null);
      paramBundle.putLong("vacreport_key_seq", l3);
    }
    if (paramInt == 6) {
      return rechargeGameCurrency(paramAppInterface, paramActivity, paramResultReceiver, str1, str2, j, l2, l3, (String)localObject);
    }
    if (paramInt == 7) {
      return buyGoods(paramAppInterface, paramActivity, paramResultReceiver, str1, str2, j, l2, l3, (String)localObject);
    }
    if (paramInt == 8) {
      return rechargeQb(paramAppInterface, paramActivity, paramResultReceiver, str1, str2, j, l2, l3, (String)localObject);
    }
    if (paramInt == 4) {
      return openService(paramAppInterface, paramActivity, paramResultReceiver, str1, str2, j, l2, l3, (String)localObject);
    }
    if (paramInt == 9) {
      return pay(paramAppInterface, paramActivity, paramResultReceiver, str1, str2, str3, j, l2, l3, (String)localObject);
    }
    if (paramInt == 14) {
      return subscribeMonthCardPay(paramAppInterface, paramActivity, paramResultReceiver, str1, str2, j, l2, l3, (String)localObject);
    }
    paramBundle = localBundle;
    if (paramInt == 17) {
      paramBundle = launchWeChat(paramAppInterface, paramActivity, paramResultReceiver, str1, str2, j, l2, l3, (String)localObject);
    }
    return paramBundle;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("PayBridgeActivity onActivityResult requestCode=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(",resultCode=");
      localStringBuilder.append(paramInt2);
      QLog.d("Q.qwallet.pay.PayLogic", 1, localStringBuilder.toString());
    }
    if (this.mActivity == null)
    {
      this.mOnActivityResult = new PayLogicImpl.OnActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    int i = -1;
    if (((paramIntent != null) && (paramInt1 == 3001)) || (paramInt2 == -1))
    {
      paramInt1 = i;
      if (paramIntent != null) {
        paramInt1 = paramIntent.getIntExtra("PayInvokerId", -1);
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(System.currentTimeMillis());
        localStringBuilder.append(" nInvokerId = ");
        localStringBuilder.append(paramInt1);
        QLog.i("Q.qwallet.pay.PayLogic", 2, localStringBuilder.toString());
      }
      if ((paramInt1 != 14) && (paramInt1 != 17)) {
        switch (paramInt1)
        {
        default: 
          if (QLog.isColorLevel())
          {
            paramIntent = new StringBuilder();
            paramIntent.append("QvipPayBridge Unknown InvokerId : ");
            paramIntent.append(paramInt1);
            QLog.e("Q.qwallet.pay.PayLogic", 2, paramIntent.toString());
          }
          end();
          return;
        case 12: 
          onCheckWebankResult(paramIntent);
          return;
        case 10: 
          onOpenQzoneVipResult(paramIntent);
          return;
        case 9: 
          onPayResult(paramIntent);
          return;
        case 5: 
          onOpenTenpayViewResult(paramIntent);
          return;
        case 3: 
          onOpenQQReaderVipResult(paramIntent);
          return;
        case 2: 
          onGoldChargeResult(paramIntent);
          return;
        case 1: 
          onEmojimallPayResult(paramIntent);
          return;
        }
      }
      onMidasPayResult(paramIntent);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.qwallet.pay.PayLogic", 2, "QvipPayBridge Unknown data");
    }
    end();
  }
  
  @Deprecated
  public void onDestroy()
  {
    setIsPaying(false);
    this.mActivity = null;
  }
  
  public void onEndFinished()
  {
    this.mActivity.finish();
    remove(this);
  }
  
  public void startPCPushPay(IQWalletPayApi.PCPayData paramPCPayData)
  {
    if (paramPCPayData == null)
    {
      end();
      return;
    }
    paramPCPayData.h = 1;
    Bundle localBundle = new Bundle();
    localBundle.putString("json", paramPCPayData.d);
    localBundle.putString("callbackSn", "0");
    int i = ((IQWalletPayApi)QRoute.api(IQWalletPayApi.class)).getPayBridgeCode(paramPCPayData.c);
    if (i != 11)
    {
      if (i != 14) {
        switch (i)
        {
        default: 
          end();
          return;
        case 5: 
          localBundle = this.intent.getExtras();
          localBundle.putString("json", paramPCPayData.d);
          localBundle.putString("callbackSn", "0");
          openTenpayView(localBundle);
          return;
        }
      }
      newPay(i, localBundle);
      return;
    }
    openSVip(localBundle);
  }
  
  public boolean tryDoOnActivityResult(Activity paramActivity)
  {
    if ((paramActivity != null) && (this.mOnActivityResult != null))
    {
      setActivityRef((QBaseActivity)paramActivity);
      onActivityResult(this.mOnActivityResult.requestCode, this.mOnActivityResult.resultCode, this.mOnActivityResult.data);
      return true;
    }
    return false;
  }
  
  public void tryNonPCPay()
  {
    if (!this.isFromPCPush)
    {
      Intent localIntent = this.saveResultData;
      if (localIntent != null) {
        this.mActivity.setResult(this.saveResultCode, localIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qwallet.plugin.impl.PayLogicImpl
 * JD-Core Version:    0.7.0.1
 */