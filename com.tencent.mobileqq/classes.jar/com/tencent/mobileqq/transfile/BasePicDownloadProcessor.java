package com.tencent.mobileqq.transfile;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.FlashPicHelper;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.config.business.RichmediaHttpsConfProcessor;
import com.tencent.mobileqq.config.business.RichmediaHttpsConfProcessor.RichmediaHttpsConfigBean;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.netprobe.MtuProbe;
import com.tencent.mobileqq.highway.netprobe.PingProbe;
import com.tencent.mobileqq.highway.netprobe.ProbeChain;
import com.tencent.mobileqq.highway.netprobe.ProbeItem;
import com.tencent.mobileqq.highway.netprobe.ProbeRequest;
import com.tencent.mobileqq.highway.netprobe.ProbeTask;
import com.tencent.mobileqq.highway.netprobe.TracerouteProbe;
import com.tencent.mobileqq.highway.netprobe.WeakNetLearner;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf;
import com.tencent.mobileqq.mixedmsg.api.IMsgMixed;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.DownCallBack.DownResult;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.pic.api.IDep;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.pic.api.IPicTransFile.IPicDownloadPro;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.RichMediaBugReport;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.api.IMsgStructing;
import com.tencent.mobileqq.transfile.dns.BaseInnerDns;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.transfile.report.RMServMonitorReport;
import com.tencent.mobileqq.utils.DESUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.PicCryptor;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.manager.TicketManager;

public class BasePicDownloadProcessor
  extends BaseDownloadProcessor
  implements IPicTransFile.IPicDownloadPro, NetFailedListener
{
  public static final String C2C_PIC_DOWNLOAD_ERROR_CODE = "C2CPicDownloadErrorCode";
  static final int DOWNLOAD_ST_COMPLETE = 1;
  static final int DOWNLOAD_ST_HEAD = 2;
  static final int DOWNLOAD_ST_LEFT = 4;
  static final int DOWNLOAD_ST_PART = 3;
  private static final int ENCRYPT_APPID = 1600000226;
  public static final String GROUP_PIC_DOWNLOAD_ERROR_CODE = "GroupPicDownloadErrorCode";
  public static final String KEY_PIC_DOWNLOAD_ERROR_CODE = "param_detail_code";
  public static final String REPORT_TAG_DIRECT_DOWNLOAD_FAIL = "report_direct_download_fail";
  private static final Pattern URL_ENCRYPR_PATH_PATTERN = Pattern.compile(".*//[^/]*/[^/]*/(.*)/.*");
  protected long decryptConsumeTime = 0L;
  private ArrayList<String> failIpReported = new ArrayList();
  protected String mDecryptErrorMsg;
  protected String mDirectDownFailReason = "";
  protected boolean mEncryptPic = false;
  protected boolean mEncryptUrl = false;
  protected boolean mIpFromInnerDns = false;
  protected TransferRequest.PicDownExtraInfo mPicDownExtra;
  protected boolean mPicEncryptRollback = false;
  protected int mSSORequestReason = 0;
  protected byte[] mST;
  protected byte[] mSTKey;
  public WeakNetLearner mWeakNetLearner;
  
  public BasePicDownloadProcessor() {}
  
  public BasePicDownloadProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramBaseTransFileController, paramTransferRequest);
    this.mWeakNetLearner = BaseTransProcessorStaticVariable.WEAK_NET_LEARNER;
    encryptConfigInit();
  }
  
  private boolean checkPicFormat(NetResp paramNetResp)
  {
    if (paramNetResp != null) {
      try
      {
        if (paramNetResp.mReq.mOutPath != null)
        {
          BitmapFactory.Options localOptions = new BitmapFactory.Options();
          localOptions.inJustDecodeBounds = true;
          BitmapFactory.decodeFile(paramNetResp.mReq.mOutPath, localOptions);
          if (localOptions.outHeight > 0)
          {
            int i = localOptions.outWidth;
            if (i > 0) {}
          }
          else
          {
            return false;
          }
        }
      }
      catch (Throwable paramNetResp)
      {
        paramNetResp.printStackTrace();
        return false;
      }
    }
    return true;
  }
  
  private void handleProgressiveJPEG(NetResp paramNetResp)
  {
    if ((paramNetResp.mReq != null) && (paramNetResp.mReq.mTempPath != null) && (paramNetResp.mReq.mTempPath.length() != 0) && (paramNetResp.mReq.mOutPath != null) && (paramNetResp.mReq.mOutPath.length() != 0))
    {
      String str = paramNetResp.mReq.mTempPath;
      paramNetResp = paramNetResp.mReq.mOutPath;
      if (this.mUiRequest == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        i = this.mUiRequest.mUinType;
        boolean bool = this.mUiRequest.mIsUp;
        int j = this.mUiRequest.mFileType;
        long l = this.mUiRequest.mUniseq;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("mUiRequest.mRequestOffset: ");
        localStringBuilder.append(this.mUiRequest.mRequestOffset);
        localStringBuilder.append(" mUiRequest.mRequestLength: ");
        localStringBuilder.append(this.mUiRequest.mRequestLength);
        localStringBuilder.append(" tempPath: ");
        localStringBuilder.append(str);
        localStringBuilder.append(" outPath: ");
        localStringBuilder.append(paramNetResp);
        RichMediaUtil.log(i, bool, j, String.valueOf(l), "handleProgressiveJPEG", localStringBuilder.toString());
      }
      int i = getDownloadStatus(this.mUiRequest);
      if (i == 4)
      {
        writeProgressiveLastSlice(paramNetResp, str);
        return;
      }
      if (i == 2)
      {
        writeProgressiveFirstSlice(paramNetResp, str);
        return;
      }
      if (i == 3) {
        writeProgressiveMidSlice(paramNetResp, str);
      }
    }
  }
  
  /* Error */
  private void writeProgressiveFirstSlice(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 234	java/io/File
    //   3: dup
    //   4: aload_2
    //   5: invokespecial 237	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 4
    //   10: new 234	java/io/File
    //   13: dup
    //   14: aload_1
    //   15: invokespecial 237	java/io/File:<init>	(Ljava/lang/String;)V
    //   18: astore_3
    //   19: aload_3
    //   20: invokevirtual 240	java/io/File:exists	()Z
    //   23: ifeq +8 -> 31
    //   26: aload_3
    //   27: invokevirtual 243	java/io/File:delete	()Z
    //   30: pop
    //   31: invokestatic 246	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   34: ifeq +53 -> 87
    //   37: new 177	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   44: astore_3
    //   45: aload_3
    //   46: ldc 248
    //   48: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: aload_3
    //   53: aload 4
    //   55: invokevirtual 251	java/io/File:length	()J
    //   58: invokevirtual 254	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload_3
    //   63: ldc_w 256
    //   66: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload_3
    //   71: aload_1
    //   72: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: ldc_w 258
    //   79: iconst_4
    //   80: aload_3
    //   81: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   87: aload 4
    //   89: invokevirtual 240	java/io/File:exists	()Z
    //   92: ifeq +349 -> 441
    //   95: aconst_null
    //   96: astore 5
    //   98: aconst_null
    //   99: astore 6
    //   101: aconst_null
    //   102: astore_3
    //   103: new 264	java/io/RandomAccessFile
    //   106: dup
    //   107: aload 4
    //   109: ldc_w 266
    //   112: invokespecial 269	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   115: astore 4
    //   117: aload 4
    //   119: aload 4
    //   121: invokevirtual 270	java/io/RandomAccessFile:length	()J
    //   124: invokevirtual 274	java/io/RandomAccessFile:seek	(J)V
    //   127: aload 4
    //   129: iconst_2
    //   130: newarray byte
    //   132: dup
    //   133: iconst_0
    //   134: ldc_w 275
    //   137: bastore
    //   138: dup
    //   139: iconst_1
    //   140: ldc_w 276
    //   143: bastore
    //   144: invokevirtual 280	java/io/RandomAccessFile:write	([B)V
    //   147: aload 4
    //   149: invokevirtual 283	java/io/RandomAccessFile:close	()V
    //   152: goto +8 -> 160
    //   155: astore_3
    //   156: aload_3
    //   157: invokevirtual 284	java/io/IOException:printStackTrace	()V
    //   160: aload_2
    //   161: aload_1
    //   162: invokestatic 290	com/tencent/mobileqq/utils/FileUtils:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   165: ifne +276 -> 441
    //   168: aload_2
    //   169: aload_1
    //   170: invokestatic 293	com/tencent/mobileqq/utils/FileUtils:copyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   173: ifeq +15 -> 188
    //   176: new 234	java/io/File
    //   179: dup
    //   180: aload_2
    //   181: invokespecial 237	java/io/File:<init>	(Ljava/lang/String;)V
    //   184: astore_1
    //   185: goto +173 -> 358
    //   188: new 234	java/io/File
    //   191: dup
    //   192: aload_2
    //   193: invokespecial 237	java/io/File:<init>	(Ljava/lang/String;)V
    //   196: astore_1
    //   197: goto +176 -> 373
    //   200: astore 5
    //   202: aload 4
    //   204: astore_3
    //   205: aload 5
    //   207: astore 4
    //   209: goto +170 -> 379
    //   212: astore 5
    //   214: goto +21 -> 235
    //   217: astore 5
    //   219: goto +88 -> 307
    //   222: astore 4
    //   224: goto +155 -> 379
    //   227: astore_3
    //   228: aload 5
    //   230: astore 4
    //   232: aload_3
    //   233: astore 5
    //   235: aload 4
    //   237: astore_3
    //   238: aload 5
    //   240: invokevirtual 284	java/io/IOException:printStackTrace	()V
    //   243: aload 4
    //   245: ifnull +16 -> 261
    //   248: aload 4
    //   250: invokevirtual 283	java/io/RandomAccessFile:close	()V
    //   253: goto +8 -> 261
    //   256: astore_3
    //   257: aload_3
    //   258: invokevirtual 284	java/io/IOException:printStackTrace	()V
    //   261: aload_2
    //   262: aload_1
    //   263: invokestatic 290	com/tencent/mobileqq/utils/FileUtils:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   266: ifne +175 -> 441
    //   269: aload_2
    //   270: aload_1
    //   271: invokestatic 293	com/tencent/mobileqq/utils/FileUtils:copyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   274: ifeq +15 -> 289
    //   277: new 234	java/io/File
    //   280: dup
    //   281: aload_2
    //   282: invokespecial 237	java/io/File:<init>	(Ljava/lang/String;)V
    //   285: astore_1
    //   286: goto +72 -> 358
    //   289: new 234	java/io/File
    //   292: dup
    //   293: aload_2
    //   294: invokespecial 237	java/io/File:<init>	(Ljava/lang/String;)V
    //   297: astore_1
    //   298: goto +75 -> 373
    //   301: astore 5
    //   303: aload 6
    //   305: astore 4
    //   307: aload 4
    //   309: astore_3
    //   310: aload 5
    //   312: invokevirtual 294	java/io/FileNotFoundException:printStackTrace	()V
    //   315: aload 4
    //   317: ifnull +16 -> 333
    //   320: aload 4
    //   322: invokevirtual 283	java/io/RandomAccessFile:close	()V
    //   325: goto +8 -> 333
    //   328: astore_3
    //   329: aload_3
    //   330: invokevirtual 284	java/io/IOException:printStackTrace	()V
    //   333: aload_2
    //   334: aload_1
    //   335: invokestatic 290	com/tencent/mobileqq/utils/FileUtils:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   338: ifne +103 -> 441
    //   341: aload_2
    //   342: aload_1
    //   343: invokestatic 293	com/tencent/mobileqq/utils/FileUtils:copyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   346: ifeq +18 -> 364
    //   349: new 234	java/io/File
    //   352: dup
    //   353: aload_2
    //   354: invokespecial 237	java/io/File:<init>	(Ljava/lang/String;)V
    //   357: astore_1
    //   358: aload_1
    //   359: invokevirtual 243	java/io/File:delete	()Z
    //   362: pop
    //   363: return
    //   364: new 234	java/io/File
    //   367: dup
    //   368: aload_2
    //   369: invokespecial 237	java/io/File:<init>	(Ljava/lang/String;)V
    //   372: astore_1
    //   373: aload_1
    //   374: invokevirtual 243	java/io/File:delete	()Z
    //   377: pop
    //   378: return
    //   379: aload_3
    //   380: ifnull +15 -> 395
    //   383: aload_3
    //   384: invokevirtual 283	java/io/RandomAccessFile:close	()V
    //   387: goto +8 -> 395
    //   390: astore_3
    //   391: aload_3
    //   392: invokevirtual 284	java/io/IOException:printStackTrace	()V
    //   395: aload_2
    //   396: aload_1
    //   397: invokestatic 290	com/tencent/mobileqq/utils/FileUtils:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   400: ifne +38 -> 438
    //   403: aload_2
    //   404: aload_1
    //   405: invokestatic 293	com/tencent/mobileqq/utils/FileUtils:copyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   408: ifeq +18 -> 426
    //   411: new 234	java/io/File
    //   414: dup
    //   415: aload_2
    //   416: invokespecial 237	java/io/File:<init>	(Ljava/lang/String;)V
    //   419: invokevirtual 243	java/io/File:delete	()Z
    //   422: pop
    //   423: goto +15 -> 438
    //   426: new 234	java/io/File
    //   429: dup
    //   430: aload_2
    //   431: invokespecial 237	java/io/File:<init>	(Ljava/lang/String;)V
    //   434: invokevirtual 243	java/io/File:delete	()Z
    //   437: pop
    //   438: aload 4
    //   440: athrow
    //   441: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	442	0	this	BasePicDownloadProcessor
    //   0	442	1	paramString1	String
    //   0	442	2	paramString2	String
    //   18	85	3	localObject1	Object
    //   155	2	3	localIOException1	java.io.IOException
    //   204	1	3	localObject2	Object
    //   227	6	3	localIOException2	java.io.IOException
    //   237	1	3	localObject3	Object
    //   256	2	3	localIOException3	java.io.IOException
    //   309	1	3	localObject4	Object
    //   328	56	3	localIOException4	java.io.IOException
    //   390	2	3	localIOException5	java.io.IOException
    //   8	200	4	localObject5	Object
    //   222	1	4	localObject6	Object
    //   230	209	4	localObject7	Object
    //   96	1	5	localObject8	Object
    //   200	6	5	localObject9	Object
    //   212	1	5	localIOException6	java.io.IOException
    //   217	12	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   233	6	5	localIOException7	java.io.IOException
    //   301	10	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   99	205	6	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   147	152	155	java/io/IOException
    //   117	147	200	finally
    //   117	147	212	java/io/IOException
    //   117	147	217	java/io/FileNotFoundException
    //   103	117	222	finally
    //   238	243	222	finally
    //   310	315	222	finally
    //   103	117	227	java/io/IOException
    //   248	253	256	java/io/IOException
    //   103	117	301	java/io/FileNotFoundException
    //   320	325	328	java/io/IOException
    //   383	387	390	java/io/IOException
  }
  
  /* Error */
  private void writeProgressiveLastSlice(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 177	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: aload_1
    //   12: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: pop
    //   16: aload 4
    //   18: ldc_w 296
    //   21: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload 4
    //   27: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: astore 7
    //   32: aload_1
    //   33: aload 7
    //   35: invokestatic 293	com/tencent/mobileqq/utils/FileUtils:copyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   38: pop
    //   39: new 234	java/io/File
    //   42: dup
    //   43: aload 7
    //   45: invokespecial 237	java/io/File:<init>	(Ljava/lang/String;)V
    //   48: astore 4
    //   50: new 234	java/io/File
    //   53: dup
    //   54: aload_2
    //   55: invokespecial 237	java/io/File:<init>	(Ljava/lang/String;)V
    //   58: astore 8
    //   60: invokestatic 246	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   63: ifeq +54 -> 117
    //   66: new 177	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   73: astore_2
    //   74: aload_2
    //   75: ldc_w 298
    //   78: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload_2
    //   83: aload 8
    //   85: invokevirtual 251	java/io/File:length	()J
    //   88: invokevirtual 254	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload_2
    //   93: ldc_w 256
    //   96: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload_2
    //   101: aload_1
    //   102: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: ldc_w 258
    //   109: iconst_4
    //   110: aload_2
    //   111: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   117: aload 4
    //   119: invokevirtual 240	java/io/File:exists	()Z
    //   122: ifeq +381 -> 503
    //   125: aload 8
    //   127: invokevirtual 240	java/io/File:exists	()Z
    //   130: ifeq +373 -> 503
    //   133: aconst_null
    //   134: astore 6
    //   136: aconst_null
    //   137: astore 5
    //   139: new 264	java/io/RandomAccessFile
    //   142: dup
    //   143: aload 4
    //   145: ldc_w 266
    //   148: invokespecial 269	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   151: astore 4
    //   153: aload 4
    //   155: aload_0
    //   156: getfield 155	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   159: getfield 187	com/tencent/mobileqq/transfile/TransferRequest:mRequestOffset	I
    //   162: i2l
    //   163: invokevirtual 274	java/io/RandomAccessFile:seek	(J)V
    //   166: new 300	java/io/FileInputStream
    //   169: dup
    //   170: aload 8
    //   172: invokespecial 303	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   175: astore_2
    //   176: sipush 1024
    //   179: newarray byte
    //   181: astore 5
    //   183: aload_2
    //   184: aload 5
    //   186: invokevirtual 307	java/io/FileInputStream:read	([B)I
    //   189: istore_3
    //   190: iload_3
    //   191: ifle +15 -> 206
    //   194: aload 4
    //   196: aload 5
    //   198: iconst_0
    //   199: iload_3
    //   200: invokevirtual 310	java/io/RandomAccessFile:write	([BII)V
    //   203: goto -20 -> 183
    //   206: aload 4
    //   208: invokevirtual 283	java/io/RandomAccessFile:close	()V
    //   211: goto +10 -> 221
    //   214: astore 4
    //   216: aload 4
    //   218: invokevirtual 284	java/io/IOException:printStackTrace	()V
    //   221: aload_2
    //   222: invokevirtual 311	java/io/FileInputStream:close	()V
    //   225: goto +8 -> 233
    //   228: astore_2
    //   229: aload_2
    //   230: invokevirtual 284	java/io/IOException:printStackTrace	()V
    //   233: aload 8
    //   235: invokevirtual 243	java/io/File:delete	()Z
    //   238: pop
    //   239: aload 7
    //   241: aload_1
    //   242: invokestatic 290	com/tencent/mobileqq/utils/FileUtils:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   245: ifne +258 -> 503
    //   248: aload 7
    //   250: aload_1
    //   251: invokestatic 293	com/tencent/mobileqq/utils/FileUtils:copyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   254: ifeq +16 -> 270
    //   257: new 234	java/io/File
    //   260: dup
    //   261: aload 7
    //   263: invokespecial 237	java/io/File:<init>	(Ljava/lang/String;)V
    //   266: astore_1
    //   267: goto +215 -> 482
    //   270: new 234	java/io/File
    //   273: dup
    //   274: aload 7
    //   276: invokespecial 237	java/io/File:<init>	(Ljava/lang/String;)V
    //   279: astore_1
    //   280: goto +218 -> 498
    //   283: astore 6
    //   285: aload_2
    //   286: astore 5
    //   288: aload 6
    //   290: astore_2
    //   291: goto +20 -> 311
    //   294: goto +118 -> 412
    //   297: astore_2
    //   298: goto +13 -> 311
    //   301: aload 6
    //   303: astore_2
    //   304: goto +108 -> 412
    //   307: astore_2
    //   308: aconst_null
    //   309: astore 4
    //   311: aload 4
    //   313: ifnull +18 -> 331
    //   316: aload 4
    //   318: invokevirtual 283	java/io/RandomAccessFile:close	()V
    //   321: goto +10 -> 331
    //   324: astore 4
    //   326: aload 4
    //   328: invokevirtual 284	java/io/IOException:printStackTrace	()V
    //   331: aload 5
    //   333: ifnull +18 -> 351
    //   336: aload 5
    //   338: invokevirtual 311	java/io/FileInputStream:close	()V
    //   341: goto +10 -> 351
    //   344: astore 4
    //   346: aload 4
    //   348: invokevirtual 284	java/io/IOException:printStackTrace	()V
    //   351: aload 8
    //   353: invokevirtual 243	java/io/File:delete	()Z
    //   356: pop
    //   357: aload 7
    //   359: aload_1
    //   360: invokestatic 290	com/tencent/mobileqq/utils/FileUtils:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   363: ifne +41 -> 404
    //   366: aload 7
    //   368: aload_1
    //   369: invokestatic 293	com/tencent/mobileqq/utils/FileUtils:copyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   372: ifeq +19 -> 391
    //   375: new 234	java/io/File
    //   378: dup
    //   379: aload 7
    //   381: invokespecial 237	java/io/File:<init>	(Ljava/lang/String;)V
    //   384: invokevirtual 243	java/io/File:delete	()Z
    //   387: pop
    //   388: goto +16 -> 404
    //   391: new 234	java/io/File
    //   394: dup
    //   395: aload 7
    //   397: invokespecial 237	java/io/File:<init>	(Ljava/lang/String;)V
    //   400: invokevirtual 243	java/io/File:delete	()Z
    //   403: pop
    //   404: aload_2
    //   405: athrow
    //   406: aconst_null
    //   407: astore 4
    //   409: aload 6
    //   411: astore_2
    //   412: aload 4
    //   414: ifnull +18 -> 432
    //   417: aload 4
    //   419: invokevirtual 283	java/io/RandomAccessFile:close	()V
    //   422: goto +10 -> 432
    //   425: astore 4
    //   427: aload 4
    //   429: invokevirtual 284	java/io/IOException:printStackTrace	()V
    //   432: aload_2
    //   433: ifnull +15 -> 448
    //   436: aload_2
    //   437: invokevirtual 311	java/io/FileInputStream:close	()V
    //   440: goto +8 -> 448
    //   443: astore_2
    //   444: aload_2
    //   445: invokevirtual 284	java/io/IOException:printStackTrace	()V
    //   448: aload 8
    //   450: invokevirtual 243	java/io/File:delete	()Z
    //   453: pop
    //   454: aload 7
    //   456: aload_1
    //   457: invokestatic 290	com/tencent/mobileqq/utils/FileUtils:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   460: ifne +43 -> 503
    //   463: aload 7
    //   465: aload_1
    //   466: invokestatic 293	com/tencent/mobileqq/utils/FileUtils:copyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   469: ifeq +19 -> 488
    //   472: new 234	java/io/File
    //   475: dup
    //   476: aload 7
    //   478: invokespecial 237	java/io/File:<init>	(Ljava/lang/String;)V
    //   481: astore_1
    //   482: aload_1
    //   483: invokevirtual 243	java/io/File:delete	()Z
    //   486: pop
    //   487: return
    //   488: new 234	java/io/File
    //   491: dup
    //   492: aload 7
    //   494: invokespecial 237	java/io/File:<init>	(Ljava/lang/String;)V
    //   497: astore_1
    //   498: aload_1
    //   499: invokevirtual 243	java/io/File:delete	()Z
    //   502: pop
    //   503: return
    //   504: astore_2
    //   505: goto -99 -> 406
    //   508: astore_2
    //   509: goto -208 -> 301
    //   512: astore 5
    //   514: goto -220 -> 294
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	517	0	this	BasePicDownloadProcessor
    //   0	517	1	paramString1	String
    //   0	517	2	paramString2	String
    //   189	11	3	i	int
    //   7	200	4	localObject1	Object
    //   214	3	4	localIOException1	java.io.IOException
    //   309	8	4	localObject2	Object
    //   324	3	4	localIOException2	java.io.IOException
    //   344	3	4	localIOException3	java.io.IOException
    //   407	11	4	localObject3	Object
    //   425	3	4	localIOException4	java.io.IOException
    //   137	200	5	localObject4	Object
    //   512	1	5	localThrowable	Throwable
    //   134	1	6	localObject5	Object
    //   283	127	6	localObject6	Object
    //   30	463	7	str	String
    //   58	391	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   206	211	214	java/io/IOException
    //   221	225	228	java/io/IOException
    //   176	183	283	finally
    //   183	190	283	finally
    //   194	203	283	finally
    //   153	176	297	finally
    //   139	153	307	finally
    //   316	321	324	java/io/IOException
    //   336	341	344	java/io/IOException
    //   417	422	425	java/io/IOException
    //   436	440	443	java/io/IOException
    //   139	153	504	java/lang/Throwable
    //   153	176	508	java/lang/Throwable
    //   176	183	512	java/lang/Throwable
    //   183	190	512	java/lang/Throwable
    //   194	203	512	java/lang/Throwable
  }
  
  /* Error */
  private void writeProgressiveMidSlice(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 177	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: aload_1
    //   12: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: pop
    //   16: aload 4
    //   18: ldc_w 296
    //   21: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload 4
    //   27: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: astore 7
    //   32: aload_1
    //   33: aload 7
    //   35: invokestatic 293	com/tencent/mobileqq/utils/FileUtils:copyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   38: pop
    //   39: new 234	java/io/File
    //   42: dup
    //   43: aload 7
    //   45: invokespecial 237	java/io/File:<init>	(Ljava/lang/String;)V
    //   48: astore 4
    //   50: new 234	java/io/File
    //   53: dup
    //   54: aload_2
    //   55: invokespecial 237	java/io/File:<init>	(Ljava/lang/String;)V
    //   58: astore 8
    //   60: invokestatic 246	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   63: ifeq +54 -> 117
    //   66: new 177	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   73: astore_2
    //   74: aload_2
    //   75: ldc_w 313
    //   78: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload_2
    //   83: aload 8
    //   85: invokevirtual 251	java/io/File:length	()J
    //   88: invokevirtual 254	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload_2
    //   93: ldc_w 256
    //   96: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload_2
    //   101: aload_1
    //   102: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: ldc_w 258
    //   109: iconst_4
    //   110: aload_2
    //   111: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   117: aload 4
    //   119: invokevirtual 240	java/io/File:exists	()Z
    //   122: ifeq +339 -> 461
    //   125: aload 8
    //   127: invokevirtual 240	java/io/File:exists	()Z
    //   130: ifeq +331 -> 461
    //   133: aconst_null
    //   134: astore 6
    //   136: aconst_null
    //   137: astore 5
    //   139: new 264	java/io/RandomAccessFile
    //   142: dup
    //   143: aload 4
    //   145: ldc_w 266
    //   148: invokespecial 269	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   151: astore 4
    //   153: aload 4
    //   155: aload_0
    //   156: getfield 155	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   159: getfield 187	com/tencent/mobileqq/transfile/TransferRequest:mRequestOffset	I
    //   162: i2l
    //   163: invokevirtual 274	java/io/RandomAccessFile:seek	(J)V
    //   166: new 300	java/io/FileInputStream
    //   169: dup
    //   170: aload 8
    //   172: invokespecial 303	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   175: astore_2
    //   176: sipush 1024
    //   179: newarray byte
    //   181: astore 5
    //   183: aload_2
    //   184: aload 5
    //   186: invokevirtual 307	java/io/FileInputStream:read	([B)I
    //   189: istore_3
    //   190: iload_3
    //   191: ifle +15 -> 206
    //   194: aload 4
    //   196: aload 5
    //   198: iconst_0
    //   199: iload_3
    //   200: invokevirtual 310	java/io/RandomAccessFile:write	([BII)V
    //   203: goto -20 -> 183
    //   206: aload 4
    //   208: iconst_2
    //   209: newarray byte
    //   211: dup
    //   212: iconst_0
    //   213: ldc_w 275
    //   216: bastore
    //   217: dup
    //   218: iconst_1
    //   219: ldc_w 276
    //   222: bastore
    //   223: invokevirtual 280	java/io/RandomAccessFile:write	([B)V
    //   226: aload 4
    //   228: invokevirtual 283	java/io/RandomAccessFile:close	()V
    //   231: aload_2
    //   232: invokevirtual 311	java/io/FileInputStream:close	()V
    //   235: aload 8
    //   237: invokevirtual 243	java/io/File:delete	()Z
    //   240: pop
    //   241: aload 7
    //   243: aload_1
    //   244: invokestatic 290	com/tencent/mobileqq/utils/FileUtils:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   247: ifne +214 -> 461
    //   250: aload 7
    //   252: aload_1
    //   253: invokestatic 293	com/tencent/mobileqq/utils/FileUtils:copyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   256: ifeq +16 -> 272
    //   259: new 234	java/io/File
    //   262: dup
    //   263: aload 7
    //   265: invokespecial 237	java/io/File:<init>	(Ljava/lang/String;)V
    //   268: astore_1
    //   269: goto +171 -> 440
    //   272: new 234	java/io/File
    //   275: dup
    //   276: aload 7
    //   278: invokespecial 237	java/io/File:<init>	(Ljava/lang/String;)V
    //   281: astore_1
    //   282: goto +174 -> 456
    //   285: astore 6
    //   287: aload_2
    //   288: astore 5
    //   290: aload 6
    //   292: astore_2
    //   293: goto +14 -> 307
    //   296: goto +92 -> 388
    //   299: astore_2
    //   300: goto +7 -> 307
    //   303: astore_2
    //   304: aconst_null
    //   305: astore 4
    //   307: aload 4
    //   309: ifnull +8 -> 317
    //   312: aload 4
    //   314: invokevirtual 283	java/io/RandomAccessFile:close	()V
    //   317: aload 5
    //   319: ifnull +8 -> 327
    //   322: aload 5
    //   324: invokevirtual 311	java/io/FileInputStream:close	()V
    //   327: aload 8
    //   329: invokevirtual 243	java/io/File:delete	()Z
    //   332: pop
    //   333: aload 7
    //   335: aload_1
    //   336: invokestatic 290	com/tencent/mobileqq/utils/FileUtils:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   339: ifne +41 -> 380
    //   342: aload 7
    //   344: aload_1
    //   345: invokestatic 293	com/tencent/mobileqq/utils/FileUtils:copyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   348: ifeq +19 -> 367
    //   351: new 234	java/io/File
    //   354: dup
    //   355: aload 7
    //   357: invokespecial 237	java/io/File:<init>	(Ljava/lang/String;)V
    //   360: invokevirtual 243	java/io/File:delete	()Z
    //   363: pop
    //   364: goto +16 -> 380
    //   367: new 234	java/io/File
    //   370: dup
    //   371: aload 7
    //   373: invokespecial 237	java/io/File:<init>	(Ljava/lang/String;)V
    //   376: invokevirtual 243	java/io/File:delete	()Z
    //   379: pop
    //   380: aload_2
    //   381: athrow
    //   382: aconst_null
    //   383: astore 4
    //   385: aload 6
    //   387: astore_2
    //   388: aload 4
    //   390: ifnull +8 -> 398
    //   393: aload 4
    //   395: invokevirtual 283	java/io/RandomAccessFile:close	()V
    //   398: aload_2
    //   399: ifnull +7 -> 406
    //   402: aload_2
    //   403: invokevirtual 311	java/io/FileInputStream:close	()V
    //   406: aload 8
    //   408: invokevirtual 243	java/io/File:delete	()Z
    //   411: pop
    //   412: aload 7
    //   414: aload_1
    //   415: invokestatic 290	com/tencent/mobileqq/utils/FileUtils:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   418: ifne +43 -> 461
    //   421: aload 7
    //   423: aload_1
    //   424: invokestatic 293	com/tencent/mobileqq/utils/FileUtils:copyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   427: ifeq +19 -> 446
    //   430: new 234	java/io/File
    //   433: dup
    //   434: aload 7
    //   436: invokespecial 237	java/io/File:<init>	(Ljava/lang/String;)V
    //   439: astore_1
    //   440: aload_1
    //   441: invokevirtual 243	java/io/File:delete	()Z
    //   444: pop
    //   445: return
    //   446: new 234	java/io/File
    //   449: dup
    //   450: aload 7
    //   452: invokespecial 237	java/io/File:<init>	(Ljava/lang/String;)V
    //   455: astore_1
    //   456: aload_1
    //   457: invokevirtual 243	java/io/File:delete	()Z
    //   460: pop
    //   461: return
    //   462: astore_2
    //   463: goto -81 -> 382
    //   466: astore_2
    //   467: aload 6
    //   469: astore_2
    //   470: goto -82 -> 388
    //   473: astore 5
    //   475: goto -179 -> 296
    //   478: astore 4
    //   480: goto -249 -> 231
    //   483: astore_2
    //   484: goto -249 -> 235
    //   487: astore 4
    //   489: goto -172 -> 317
    //   492: astore 4
    //   494: goto -167 -> 327
    //   497: astore 4
    //   499: goto -101 -> 398
    //   502: astore_2
    //   503: goto -97 -> 406
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	506	0	this	BasePicDownloadProcessor
    //   0	506	1	paramString1	String
    //   0	506	2	paramString2	String
    //   189	11	3	i	int
    //   7	387	4	localObject1	Object
    //   478	1	4	localIOException1	java.io.IOException
    //   487	1	4	localIOException2	java.io.IOException
    //   492	1	4	localIOException3	java.io.IOException
    //   497	1	4	localIOException4	java.io.IOException
    //   137	186	5	localObject2	Object
    //   473	1	5	localIOException5	java.io.IOException
    //   134	1	6	localObject3	Object
    //   285	183	6	localObject4	Object
    //   30	421	7	str	String
    //   58	349	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   176	183	285	finally
    //   183	190	285	finally
    //   194	203	285	finally
    //   206	226	285	finally
    //   153	176	299	finally
    //   139	153	303	finally
    //   139	153	462	java/io/IOException
    //   153	176	466	java/io/IOException
    //   176	183	473	java/io/IOException
    //   183	190	473	java/io/IOException
    //   194	203	473	java/io/IOException
    //   206	226	473	java/io/IOException
    //   226	231	478	java/io/IOException
    //   231	235	483	java/io/IOException
    //   312	317	487	java/io/IOException
    //   322	327	492	java/io/IOException
    //   393	398	497	java/io/IOException
    //   402	406	502	java/io/IOException
  }
  
  protected String appendInfoForSvr(String paramString, int paramInt)
  {
    if (this.mUiRequest.mDownMode == 0) {
      localObject = "&rf=aio";
    } else if (this.mUiRequest.mDownMode == 1) {
      localObject = "&rf=naio";
    } else {
      localObject = "&rf=other";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cldver=8.8.17.5770");
    localStringBuilder.append((String)localObject);
    Object localObject = localStringBuilder.toString();
    paramInt = paramString.indexOf("?");
    if (paramInt > 0)
    {
      int i = paramString.length();
      int j = paramInt + 1;
      if (i == j)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString.substring(0, j));
        localStringBuilder.append((String)localObject);
        paramString = localStringBuilder.toString();
      }
      else
      {
        paramInt = paramString.indexOf("#", paramInt);
        if (paramInt > -1)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString.substring(0, paramInt));
          localStringBuilder.append("&");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append(paramString.substring(paramInt));
          paramString = localStringBuilder.toString();
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append("&");
          localStringBuilder.append((String)localObject);
          paramString = localStringBuilder.toString();
        }
      }
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("?");
      localStringBuilder.append((String)localObject);
      paramString = localStringBuilder.toString();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("&msgTime=");
    ((StringBuilder)localObject).append(this.mUiRequest.mMsgTime);
    return ((StringBuilder)localObject).toString();
  }
  
  protected void checkFailCodeReport(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.mProcessorReport.errCode == 0))
    {
      if (!QLog.isColorLevel()) {
        return;
      }
      RichMediaBugReport.a("PIC_TRANS_0_ERROR", Arrays.toString(new Throwable().getStackTrace()));
    }
  }
  
  protected boolean checkMemoryForEncrypt()
  {
    if (this.mUiRequest.mFileType == 65537) {
      return true;
    }
    if ((this.mUiRequest.mRec instanceof MessageForPic))
    {
      long l1 = ((MessageForPic)this.mUiRequest.mRec).size;
      long l2 = Runtime.getRuntime().totalMemory();
      l2 = Runtime.getRuntime().maxMemory() - (l2 - Runtime.getRuntime().freeMemory());
      StringBuilder localStringBuilder;
      if (l2 < l1)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkMemoryForEncrypt : memory is not enough ! remainMemory = ");
        localStringBuilder.append(l2);
        localStringBuilder.append(", picSize = ");
        localStringBuilder.append(l1);
        QLog.e("BaseTransProcessor", 1, localStringBuilder.toString());
        return false;
      }
      if (l1 > 5242880L)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkMemoryForEncrypt : pic too large, picSize = ");
        localStringBuilder.append(l1);
        QLog.e("BaseTransProcessor", 1, localStringBuilder.toString());
        return false;
      }
    }
    return true;
  }
  
  void directMsgUrlDown(String paramString, int paramInt)
  {
    this.mUrlPath = this.mPicDownExtra.mUrlFromMsg;
    if ((this.mUrlPath != null) && (this.mUrlPath.length() != 0))
    {
      if ((QLog.isColorLevel()) && (this.mUrlPath.contains("com.tencent.mobileqq")))
      {
        RichMediaBugReport.a("Download_Pic_URL_Invalid", this.mUrlPath);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("directMsgUrlDown Download_Pic_URL_Invalid:");
        localStringBuilder.append(this.mUrlPath);
        QLog.d("BaseTransProcessor", 1, localStringBuilder.toString());
      }
      this.mIpList = selectIpList(makeServerIpList(BaseInnerDns.getInstance().reqDnsForIpList(paramString, paramInt, true, 28, false), true), makeServerIpList(BaseInnerDns.getInstance().reqDnsForIpList(paramString, paramInt, true, 1, false), false));
      if ((this.mIpList != null) && (this.mIpList.size() > 0))
      {
        this.mIpFromInnerDns = true;
        this.mDirectMsgUrlDown = true;
        this.mProcessorReport.mStepDirectDown.logStartTime();
        paramString = RichmediaHttpsConfProcessor.a();
        boolean bool1;
        if (paramString != null)
        {
          boolean bool2 = paramString.a();
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("isHttps: ");
            paramString.append(bool2);
            QLog.d("BaseTransProcessor", 2, paramString.toString());
          }
          bool1 = bool2;
          if (bool2)
          {
            this.mEncryptPic = false;
            this.mEncryptUrl = false;
            bool1 = bool2;
          }
        }
        else
        {
          bool1 = false;
        }
        receiveFile(bool1);
        return;
      }
      this.mSSORequestReason = 2;
      sendRequest();
      return;
    }
    this.mSSORequestReason = 1;
    sendRequest();
  }
  
  protected void doReport(boolean paramBoolean, String paramString, long paramLong, HashMap<String, String> paramHashMap)
  {
    if (!paramBoolean)
    {
      String str1 = String.valueOf(this.mProcessorReport.errCode);
      Object localObject = str1;
      if (this.mProcessorReport.errCode == -9527)
      {
        String str2 = (String)this.mProcessorReport.mReportInfo.get("param_reason");
        localObject = str1;
        if (str2 != null) {
          localObject = str2;
        }
      }
      paramHashMap.put("param_detail_code", localObject);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, paramString, true, paramLong, this.mTotolLen, paramHashMap, null);
    }
  }
  
  public void encryptConfigInit()
  {
    Object localObject = (TicketManager)this.app.getManager(2);
    this.mSTKey = ((TicketManager)localObject).getStkey(this.app.getAccount(), 1600000226);
    this.mST = ((TicketManager)localObject).getSt(this.app.getAccount(), 1600000226);
    subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf localDownloadEncryptConf = ((IDep)QRoute.api(IDep.class)).getPicDownEncryptConf();
    localObject = this.mST;
    if (localObject != null)
    {
      byte[] arrayOfByte = this.mSTKey;
      if ((arrayOfByte != null) && (localObject.length > 0) && (arrayOfByte.length > 0) && (localDownloadEncryptConf != null))
      {
        this.mEncryptUrl = localDownloadEncryptConf.bool_enable_encrypt_request.get();
        this.mEncryptPic = localDownloadEncryptConf.bool_enable_encrypted_pic.get();
        break label132;
      }
    }
    this.mEncryptPic = false;
    this.mEncryptUrl = false;
    label132:
    if (this.mSTKey == null)
    {
      localObject = "key or switch can't get!";
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("STKey:");
      ((StringBuilder)localObject).append(MD5.toMD5(this.mSTKey));
      localObject = ((StringBuilder)localObject).toString();
    }
    logRichMediaEvent("ticketInit", (String)localObject);
    if ((!isAllowEncrypt(localDownloadEncryptConf)) || (!IS_MAIN_PROCESS))
    {
      this.mEncryptPic = false;
      this.mEncryptUrl = false;
    }
  }
  
  public void encryptReqInit(HttpNetReq paramHttpNetReq, String paramString)
  {
    Object localObject;
    if (this.mEncryptUrl)
    {
      paramHttpNetReq.mReqUrl = encryptURL(paramString);
      if (!paramString.equals(paramHttpNetReq.mReqUrl))
      {
        localObject = paramHttpNetReq.mReqProperties;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("mST=");
        localStringBuilder.append(PkgTools.toHexStr(this.mST));
        ((HashMap)localObject).put("Cookie", localStringBuilder.toString());
        if (this.mEncryptPic)
        {
          localObject = new PicCryptor(this.mSTKey);
          ((PicCryptor)localObject).a = paramHttpNetReq;
          paramHttpNetReq.decoder = ((HttpNetReq.IFlowDecoder)localObject);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramHttpNetReq.mOutPath);
          ((StringBuilder)localObject).append(".");
          ((StringBuilder)localObject).append(MD5.toMD5(TransFileUtil.getUrlResoursePath(paramString, false)));
          ((StringBuilder)localObject).append(".tmp");
          paramHttpNetReq.mTempPath = ((StringBuilder)localObject).toString();
        }
      }
    }
    else
    {
      this.mEncryptPic = false;
    }
    if ((this.mPicEncryptRollback) && (!this.mEncryptPic))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramHttpNetReq.mOutPath);
      ((StringBuilder)localObject).append(".");
      ((StringBuilder)localObject).append(MD5.toMD5(TransFileUtil.getUrlResoursePath(paramString, false)));
      ((StringBuilder)localObject).append(".tmp");
      paramHttpNetReq.mTempPath = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("&rollback=1");
      paramHttpNetReq.mReqUrl = ((StringBuilder)localObject).toString();
    }
  }
  
  public String encryptURL(String paramString)
  {
    String str = getEncryptPath(paramString);
    Cryptor localCryptor = new Cryptor();
    if (str != null)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("&encrypt=");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder;
      if (this.mEncryptPic)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("1");
        localObject = localStringBuilder.toString();
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("0");
        localObject = localStringBuilder.toString();
      }
      return paramString.replace(str, PkgTools.toHexStr(localCryptor.encrypt(((String)localObject).getBytes(), this.mSTKey)));
    }
    this.mEncryptPic = false;
    return paramString;
  }
  
  int getDownloadStatus(TransferRequest paramTransferRequest)
  {
    int j = paramTransferRequest.mRequestOffset;
    int i = 1;
    if (j < 0) {
      return 1;
    }
    if (paramTransferRequest.mRequestOffset > 0)
    {
      if (paramTransferRequest.mRequestLength > 0) {
        return 3;
      }
      return 4;
    }
    if (paramTransferRequest.mRequestLength > 0) {
      i = 2;
    }
    return i;
  }
  
  public String getEncryptPath(String paramString)
  {
    paramString = URL_ENCRYPR_PATH_PATTERN.matcher(paramString);
    if (paramString.find()) {
      return paramString.group(1);
    }
    return null;
  }
  
  public void handleBigThumb()
  {
    Object localObject2 = this.mUiRequest.mRec;
    Object localObject1;
    if (GifDrawable.isGifFile(new File(this.mUiRequest.mOutFilePath)))
    {
      if ((localObject2 != null) && ((localObject2 instanceof MessageForPic)))
      {
        localObject1 = (MessageForPic)localObject2;
        if (!((MessageForPic)localObject1).checkGif())
        {
          ((MessageForPic)localObject1).imageType = 2000;
          ((MessageForPic)localObject1).updateMessage();
        }
      }
    }
    else if (DeviceInfoUtil.J() >= 240)
    {
      if (((IMsgMixed)QRoute.api(IMsgMixed.class)).isMessageForMixedMsg((MessageRecord)localObject2))
      {
        localObject1 = ((IMsgMixed)QRoute.api(IMsgMixed.class)).getMessageForPic((MessageRecord)localObject2, this.mUiRequest.mSubMsgId);
      }
      else
      {
        localObject1 = localObject2;
        if (((IMsgStructing)QRoute.api(IMsgStructing.class)).isMessageForStructing((MessageRecord)localObject2)) {
          localObject1 = ((IMsgStructing)QRoute.api(IMsgStructing.class)).getMessageForPic((MessageRecord)localObject2);
        }
      }
      if ((localObject1 != null) && ((localObject1 instanceof MessageForPic))) {
        localObject1 = (MessageForPic)localObject1;
      } else {
        localObject1 = null;
      }
      if (localObject1 != null)
      {
        if ((FlashPicHelper.a((MessageRecord)localObject1)) && (!TextUtils.isEmpty(((MessageForPic)localObject1).md5)))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.mUiRequest.mOutFilePath);
          ((StringBuilder)localObject2).append("_fp");
          localObject2 = ((StringBuilder)localObject2).toString();
          DESUtil.a(this.mUiRequest.mOutFilePath, (String)localObject2, ((MessageForPic)localObject1).md5);
          return;
        }
        updateThumb((MessageForPic)localObject1);
      }
    }
  }
  
  public void handleRespErr(NetResp paramNetResp)
  {
    if ((paramNetResp.mErrCode == 9364) && (this.mNetworkChgRetryCount < 3))
    {
      logRichMediaEvent("[netChg]", "failed.but net change detect.so retry");
      this.mSSORequestReason = 4;
      this.mDirectDownFailReason = paramNetResp.mErrDesc;
      this.mNetworkChgRetryCount += 1;
      clearReprotInfo();
      sendRequest();
      return;
    }
    Object localObject3;
    Object localObject2;
    if ((this.mEncryptPic) || (this.mEncryptUrl))
    {
      boolean bool2 = false;
      this.mEncryptPic = false;
      this.mEncryptUrl = false;
      this.mPicEncryptRollback = true;
      if (paramNetResp.mErrCode == -9527)
      {
        localObject1 = (String)paramNetResp.mRespProperties.get(HttpMsg.Param_Reason);
        bool1 = bool2;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label234;
        }
        bool1 = bool2;
        if (((String)localObject1).split("_").length < 3) {
          break label234;
        }
        localObject3 = ((String)localObject1).split("_");
        localObject1 = localObject3[0];
        localObject2 = localObject3[1];
        localObject3 = localObject3[2];
        bool1 = bool2;
        if (!"H".equals(localObject1)) {
          break label234;
        }
        bool1 = bool2;
        if (!"400".equals(localObject2)) {
          break label234;
        }
        bool1 = bool2;
        if (!((String)localObject3).equals("-106")) {
          break label234;
        }
        bool1 = bool2;
        if (!this.mEncryptPic) {
          break label234;
        }
      }
      else
      {
        bool1 = bool2;
        if (paramNetResp.mErrCode != 9058) {
          break label234;
        }
      }
      boolean bool1 = true;
      label234:
      if (this.mNetReq != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("encryptReqError=");
        ((StringBuilder)localObject1).append(bool1);
        ((StringBuilder)localObject1).append(", ResErroCode:");
        ((StringBuilder)localObject1).append(paramNetResp.mErrCode);
        ((StringBuilder)localObject1).append(" ,erroDesc:");
        ((StringBuilder)localObject1).append(paramNetResp.mErrDesc);
        ((StringBuilder)localObject1).append(" ,encryptUrl:");
        ((StringBuilder)localObject1).append(((HttpNetReq)this.mNetReq).mReqUrl);
        if (((StringBuilder)localObject1).toString() == null)
        {
          localObject1 = "null";
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(((HttpNetReq)this.mNetReq).mReqUrl);
          ((StringBuilder)localObject1).append(" ,ST:");
          ((StringBuilder)localObject1).append(PkgTools.toHexStr(this.mST));
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        this.mDecryptErrorMsg = ((String)localObject1);
      }
    }
    if (this.mDirectMsgUrlDown)
    {
      this.mSSORequestReason = 3;
      this.mDirectDownFailReason = paramNetResp.mErrDesc;
      sendRequest();
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("param_FailCode", String.valueOf(paramNetResp.mErrCode));
      ((HashMap)localObject1).put("param_errorDesc", paramNetResp.mErrDesc);
      if (this.mNetReq != null) {
        ((HashMap)localObject1).put("param_url", ((HttpNetReq)this.mNetReq).mReqUrl);
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.mUiRequest.mSelfUin, "report_direct_download_fail", false, (System.nanoTime() - this.mProcessorReport.mStartTime) / 1000000L, this.mTotolLen, (HashMap)localObject1, "");
    }
    else
    {
      onError();
    }
    Object localObject1 = new StringBuffer();
    ((StringBuffer)localObject1).append(this.mUiRequest.mUinType);
    ((StringBuffer)localObject1).append(" isMsgDown:");
    ((StringBuffer)localObject1).append(this.mDirectMsgUrlDown);
    ((StringBuffer)localObject1).append(" result:");
    ((StringBuffer)localObject1).append(paramNetResp.mResult);
    ((StringBuffer)localObject1).append(" adr:");
    if (this.mIpList != null)
    {
      paramNetResp = this.mIpList.iterator();
      while (paramNetResp.hasNext())
      {
        localObject2 = (ServerAddr)paramNetResp.next();
        try
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(StringUtil.toHexString(((ServerAddr)localObject2).mIp));
          ((StringBuilder)localObject3).append(",");
          ((StringBuffer)localObject1).append(((StringBuilder)localObject3).toString());
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
    QLog.d("BaseTransProcessor", 1, ((StringBuffer)localObject1).toString());
  }
  
  public void handleRespSuc(NetResp paramNetResp)
  {
    if (!this.mNetReq.mIsRenameInEngine) {
      handleProgressiveJPEG(paramNetResp);
    }
    boolean bool = this.mEncryptUrl;
    int i = 0;
    if (((bool) || (this.mEncryptPic)) && (!checkPicFormat(paramNetResp)))
    {
      this.mEncryptPic = false;
      this.mEncryptUrl = false;
      this.mPicEncryptRollback = true;
      if (this.mNetReq != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("checkPicFormat Erro, erroCode:");
        ((StringBuilder)localObject).append(paramNetResp.mErrCode);
        ((StringBuilder)localObject).append(" ,erroDesc:");
        ((StringBuilder)localObject).append(paramNetResp.mErrDesc);
        ((StringBuilder)localObject).append(" ,encryptUrl:");
        ((StringBuilder)localObject).append(((HttpNetReq)this.mNetReq).mReqUrl);
        ((StringBuilder)localObject).append(" ,ST:");
        ((StringBuilder)localObject).append(PkgTools.toHexStr(this.mST));
        this.mDecryptErrorMsg = ((StringBuilder)localObject).toString();
      }
      sendRequest();
      return;
    }
    onSuccess();
    Object localObject = this.mRSMReporter;
    long l = this.mRecvLen;
    TransferRequest.PicDownExtraInfo localPicDownExtraInfo = this.mPicDownExtra;
    if (localPicDownExtraInfo != null) {
      i = localPicDownExtraInfo.mStartDownOffset;
    }
    ((RMServMonitorReport)localObject).mFileSize = (l - i);
    reportForServerMonitor(paramNetResp, true, "actRichMediaNetMonitor_picDown", this.mUiRequest.mServerPath);
  }
  
  public void handleThumb()
  {
    TransferResult localTransferResult = this.mUiRequest.mResult;
    if (localTransferResult != null)
    {
      localTransferResult.mResult = 0;
      localTransferResult.mOrigReq = this.mUiRequest;
      try
      {
        if ((this.mUiRequest.mFileType == 65537) && (this.mUiRequest.mOutFilePath != null)) {
          return;
        }
        if (((this.mUiRequest.mFileType == 1) || (this.mUiRequest.mFileType == 131075)) && (this.mUiRequest.mOutFilePath != null) && (this.mUiRequest.mRec != null))
        {
          handleBigThumb();
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PIC_TAG", 2, localThrowable.getMessage());
        }
      }
    }
  }
  
  public boolean isAllowEncrypt(subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf paramDownloadEncryptConf)
  {
    return false;
  }
  
  protected ArrayList<ServerAddr> makeServerIpList(ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        ServerAddr localServerAddr = new ServerAddr();
        localServerAddr.mIp = str;
        localServerAddr.port = getPicDownloadPort();
        localServerAddr.isIpv6 = paramBoolean;
        localArrayList.add(localServerAddr);
      }
    }
    return localArrayList;
  }
  
  void onError()
  {
    super.onError();
    Object localObject1 = this.mUiRequest.mResult;
    if (localObject1 != null)
    {
      ((TransferResult)localObject1).mResult = -1;
      ((TransferResult)localObject1).mErrCode = this.mProcessorReport.errCode;
      ((TransferResult)localObject1).mErrDesc = this.mProcessorReport.errDesc;
      ((TransferResult)localObject1).mOrigReq = this.mUiRequest;
    }
    try
    {
      if (this.file != null) {
        this.file.status = 2005;
      }
      localObject1 = this.mDownCallBacks.iterator();
      Object localObject3;
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (DownCallBack)((Iterator)localObject1).next();
        DownCallBack.DownResult localDownResult = new DownCallBack.DownResult();
        localDownResult.a = -1;
        localDownResult.b = this.mProcessorReport.errCode;
        localDownResult.c = this.mProcessorReport.errDesc;
        ((DownCallBack)localObject3).a(localDownResult);
        if (QLog.isColorLevel()) {
          QLog.d("PIC_TAG", 2, "onError ");
        }
      }
      if (this.file != null) {
        logRichMediaEvent("notify", "start");
      }
      notifyAll();
      if (this.file != null) {
        logRichMediaEvent("notify", "end");
      }
      if ((this.mProcessorReport.errCode == 9014) || (this.mProcessorReport.errCode == 9050))
      {
        localObject1 = TransFileUtil.getIpAndPortFromUrl(((HttpNetReq)this.mNetReq).mReqUrl);
        if (localObject1 != null)
        {
          localObject1 = ((ServerAddr)localObject1).mIp;
          localObject3 = new ProbeChain();
          if (this.mProcessorReport.errCode == 9014)
          {
            ((ProbeChain)localObject3).addProbeItem(new PingProbe());
            ((ProbeChain)localObject3).addProbeItem(new MtuProbe());
            ((ProbeChain)localObject3).addProbeItem(new TracerouteProbe());
          }
          else
          {
            ((ProbeChain)localObject3).addProbeItem(new PingProbe());
            ((ProbeChain)localObject3).addProbeItem(new TracerouteProbe());
          }
          int i;
          if (this.mProcessorReport.errCode == 9014) {
            i = -1201;
          } else {
            i = -1202;
          }
          localObject1 = new ProbeRequest((String)localObject1, i, (ProbeItem)localObject3);
          localObject3 = this.mWeakNetLearner;
          if (localObject3 != null) {
            ((WeakNetLearner)localObject3).startProbe(new ProbeTask((ProbeRequest)localObject1));
          }
        }
      }
      sendMessageToUpdate(2005);
      ((IDep)QRoute.api(IDep.class)).reportEmotionPicMonitor(this.mUiRequest.mRec, String.valueOf(this.mProcessorReport.errCode), false);
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void onFailed(NetResp paramNetResp)
  {
    RMServMonitorReport localRMServMonitorReport = this.mRSMReporter;
    long l = this.mRecvLen;
    TransferRequest.PicDownExtraInfo localPicDownExtraInfo = this.mPicDownExtra;
    int i;
    if (localPicDownExtraInfo == null) {
      i = 0;
    } else {
      i = localPicDownExtraInfo.mStartDownOffset;
    }
    localRMServMonitorReport.mFileSize = (l - i);
    reportForServerMonitor(paramNetResp, false, "actRichMediaNetMonitor_picDown", this.mUiRequest.mServerPath);
  }
  
  public void onResp(NetResp paramNetResp)
  {
    super.onResp(paramNetResp);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("directMsgUrlDown:");
    ((StringBuilder)localObject).append(this.mDirectMsgUrlDown);
    ((StringBuilder)localObject).append(" isEncrypt:");
    boolean bool1 = this.mEncryptPic;
    boolean bool2 = false;
    if ((!bool1) && (!this.mEncryptUrl)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    ((StringBuilder)localObject).append(bool1);
    ((StringBuilder)localObject).append(" isRollBack:");
    ((StringBuilder)localObject).append(this.mPicEncryptRollback);
    ((StringBuilder)localObject).append(" result:");
    if (paramNetResp.mResult == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((StringBuilder)localObject).append(bool1);
    logRichMediaEvent("onHttpResp", ((StringBuilder)localObject).toString());
    if ((QLog.isColorLevel()) && (this.mNetReq != null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResp");
      ((StringBuilder)localObject).append(this.mUiRequest.mFileType);
      ((StringBuilder)localObject).append("mUiRequest.mOutFilePath=");
      ((StringBuilder)localObject).append(this.mUiRequest.mOutFilePath);
      ((StringBuilder)localObject).append("url=");
      ((StringBuilder)localObject).append(((HttpNetReq)this.mNetReq).mReqUrl);
      QLog.d("big_thumb", 2, ((StringBuilder)localObject).toString());
    }
    if (this.mDirectMsgUrlDown) {
      localObject = this.mProcessorReport.mStepDirectDown;
    } else {
      localObject = this.mProcessorReport.mStepTrans;
    }
    ProcessorReport localProcessorReport = this.mProcessorReport;
    bool1 = bool2;
    if (paramNetResp.mResult == 0) {
      bool1 = true;
    }
    localProcessorReport.copyStaticsInfoFromNetResp((StepInfo)localObject, paramNetResp, bool1);
    this.mTotolLen = paramNetResp.mTotalFileLen;
    if (this.mTotolLen <= 0L) {
      this.mTotolLen = (paramNetResp.mTotalBlockLen + paramNetResp.mReq.mStartDownOffset);
    }
    this.mRecvLen += paramNetResp.mWrittenBlockLen;
    if ((paramNetResp.mResult == 0) && (this.mNetReq != null)) {
      handleRespSuc(paramNetResp);
    } else {
      handleRespErr(paramNetResp);
    }
    this.mNetReq = null;
  }
  
  void onSuccess()
  {
    super.onSuccess();
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onsuccess mUiRequest.mFileType");
      ((StringBuilder)localObject1).append(this.mUiRequest.mFileType);
      ((StringBuilder)localObject1).append("mUiRequest.mOutFilePath=");
      ((StringBuilder)localObject1).append(this.mUiRequest.mOutFilePath);
      ((StringBuilder)localObject1).append("url=");
      ((StringBuilder)localObject1).append(((HttpNetReq)this.mNetReq).mReqUrl);
      QLog.d("big_thumb", 2, ((StringBuilder)localObject1).toString());
    }
    handleThumb();
    for (;;)
    {
      try
      {
        if (this.file != null) {
          this.file.status = 2003;
        }
        localObject1 = this.mUiRequest;
        if (((TransferRequest)localObject1).mDisplayOutFilePath != null)
        {
          localObject3 = new File(((TransferRequest)localObject1).mDisplayOutFilePath);
          if ((((File)localObject3).exists()) && (((File)localObject3).delete()) && (QLog.isDevelopLevel()))
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("BasePicDownloadProcessor.onSuccess():Delete ");
            ((StringBuilder)localObject3).append(((TransferRequest)localObject1).mDisplayOutFilePath);
            QLog.d("peak_pgjpeg", 4, ((StringBuilder)localObject3).toString());
          }
        }
        int i = getDownloadStatus(this.mUiRequest);
        localObject1 = this.mDownCallBacks.iterator();
        boolean bool2 = ((Iterator)localObject1).hasNext();
        bool1 = false;
        if (!bool2) {
          continue;
        }
        localObject4 = (DownCallBack)((Iterator)localObject1).next();
        localObject3 = new DownCallBack.DownResult();
        ((DownCallBack.DownResult)localObject3).a = 0;
        ((DownCallBack.DownResult)localObject3).e = this.mUiRequest.mOutFilePath;
        ((DownCallBack.DownResult)localObject3).g = this.mUiRequest.mMd5;
        ((DownCallBack.DownResult)localObject3).h = this.mUiRequest.mFileType;
        ((DownCallBack.DownResult)localObject3).i = this.mUiRequest.mDownMode;
        if (i == 2) {
          continue;
        }
        if (i != 3) {}
      }
      finally
      {
        Object localObject3;
        Object localObject4;
        continue;
        throw localObject2;
        continue;
        boolean bool1 = true;
        continue;
      }
      ((DownCallBack.DownResult)localObject3).j = bool1;
      ((DownCallBack)localObject4).a((DownCallBack.DownResult)localObject3);
      if ((this.mUiRequest.mFileType == 131075) && (QLog.isDevelopLevel()))
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("BasePicDownloadProcessor.onSuccess():");
        ((StringBuilder)localObject4).append(this.mUiRequest.mOutFilePath);
        ((StringBuilder)localObject4).append(", isPart ");
        ((StringBuilder)localObject4).append(((DownCallBack.DownResult)localObject3).j);
        QLog.d("peak_pgjpeg", 4, ((StringBuilder)localObject4).toString());
      }
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG", 2, "onSuccess ");
      }
    }
    if (this.file != null) {
      logRichMediaEvent("notify", "start");
    }
    notifyAll();
    if (this.file != null) {
      logRichMediaEvent("notify", "end");
    }
    sendMessageToUpdate(2003);
    ((IDep)QRoute.api(IDep.class)).reportEmotionPicMonitor(this.mUiRequest.mRec, null, false);
  }
  
  /* Error */
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: lload_2
    //   1: ldc2_w 1130
    //   4: lmul
    //   5: lload 4
    //   7: ldiv
    //   8: l2i
    //   9: istore 6
    //   11: iload 6
    //   13: aload_0
    //   14: getfield 1134	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:mLastProgress	I
    //   17: if_icmple +33 -> 50
    //   20: aload_0
    //   21: iload 6
    //   23: putfield 1134	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:mLastProgress	I
    //   26: aload_0
    //   27: getfield 422	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:mPicDownExtra	Lcom/tencent/mobileqq/transfile/TransferRequest$PicDownExtraInfo;
    //   30: getfield 1138	com/tencent/mobileqq/transfile/TransferRequest$PicDownExtraInfo:mHandler	Lcom/tencent/image/URLDrawableHandler;
    //   33: ifnull +17 -> 50
    //   36: aload_0
    //   37: getfield 422	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:mPicDownExtra	Lcom/tencent/mobileqq/transfile/TransferRequest$PicDownExtraInfo;
    //   40: getfield 1138	com/tencent/mobileqq/transfile/TransferRequest$PicDownExtraInfo:mHandler	Lcom/tencent/image/URLDrawableHandler;
    //   43: iload 6
    //   45: invokeinterface 1143 2 0
    //   50: aload_0
    //   51: monitorenter
    //   52: aload_0
    //   53: getfield 972	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:file	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   56: ifnull +13 -> 69
    //   59: aload_0
    //   60: getfield 972	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:file	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   63: sipush 2002
    //   66: putfield 977	com/tencent/mobileqq/transfile/FileMsg:status	I
    //   69: aload_0
    //   70: getfield 155	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   73: astore 14
    //   75: aload 14
    //   77: getfield 1146	com/tencent/mobileqq/transfile/TransferRequest:mRequestDisplayLength	I
    //   80: istore 7
    //   82: aload 14
    //   84: getfield 187	com/tencent/mobileqq/transfile/TransferRequest:mRequestOffset	I
    //   87: istore 8
    //   89: iconst_1
    //   90: istore 11
    //   92: iconst_1
    //   93: istore 10
    //   95: iload 8
    //   97: ifne +461 -> 558
    //   100: iload 7
    //   102: ifle +456 -> 558
    //   105: aload 14
    //   107: getfield 1102	com/tencent/mobileqq/transfile/TransferRequest:mDisplayOutFilePath	Ljava/lang/String;
    //   110: ifnull +448 -> 558
    //   113: new 234	java/io/File
    //   116: dup
    //   117: aload 14
    //   119: getfield 1102	com/tencent/mobileqq/transfile/TransferRequest:mDisplayOutFilePath	Ljava/lang/String;
    //   122: invokespecial 237	java/io/File:<init>	(Ljava/lang/String;)V
    //   125: astore 15
    //   127: new 234	java/io/File
    //   130: dup
    //   131: aload_1
    //   132: getfield 145	com/tencent/mobileqq/transfile/NetReq:mTempPath	Ljava/lang/String;
    //   135: invokespecial 237	java/io/File:<init>	(Ljava/lang/String;)V
    //   138: astore_1
    //   139: aload_1
    //   140: invokevirtual 251	java/io/File:length	()J
    //   143: lstore 4
    //   145: aload 15
    //   147: invokevirtual 240	java/io/File:exists	()Z
    //   150: ifne +408 -> 558
    //   153: lload 4
    //   155: lconst_0
    //   156: lcmp
    //   157: ifle +401 -> 558
    //   160: iload 7
    //   162: i2l
    //   163: lstore_2
    //   164: lload_2
    //   165: lload 4
    //   167: lcmp
    //   168: ifge +390 -> 558
    //   171: new 177	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   178: astore 12
    //   180: aload 12
    //   182: aload 14
    //   184: getfield 1102	com/tencent/mobileqq/transfile/TransferRequest:mDisplayOutFilePath	Ljava/lang/String;
    //   187: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload 12
    //   193: ldc_w 1148
    //   196: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: new 234	java/io/File
    //   203: dup
    //   204: aload 12
    //   206: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: invokespecial 237	java/io/File:<init>	(Ljava/lang/String;)V
    //   212: astore 16
    //   214: aconst_null
    //   215: astore 13
    //   217: aconst_null
    //   218: astore 12
    //   220: aload_1
    //   221: aload 16
    //   223: iconst_0
    //   224: iload 7
    //   226: invokestatic 1152	com/tencent/mobileqq/utils/FileUtils:copyFileUsingFileChannels	(Ljava/io/File;Ljava/io/File;II)J
    //   229: lstore 4
    //   231: lload 4
    //   233: lload_2
    //   234: lcmp
    //   235: ifeq +22 -> 257
    //   238: aload 16
    //   240: invokevirtual 240	java/io/File:exists	()Z
    //   243: ifeq +14 -> 257
    //   246: aload 16
    //   248: invokevirtual 243	java/io/File:delete	()Z
    //   251: pop
    //   252: aconst_null
    //   253: astore_1
    //   254: goto +38 -> 292
    //   257: new 264	java/io/RandomAccessFile
    //   260: dup
    //   261: aload 16
    //   263: ldc_w 266
    //   266: invokespecial 269	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   269: astore_1
    //   270: aload_1
    //   271: lload 4
    //   273: invokevirtual 274	java/io/RandomAccessFile:seek	(J)V
    //   276: aload_1
    //   277: iconst_2
    //   278: newarray byte
    //   280: dup
    //   281: iconst_0
    //   282: iconst_m1
    //   283: bastore
    //   284: dup
    //   285: iconst_1
    //   286: bipush 217
    //   288: bastore
    //   289: invokevirtual 280	java/io/RandomAccessFile:write	([B)V
    //   292: aload_1
    //   293: ifnull +265 -> 558
    //   296: aload_1
    //   297: invokevirtual 283	java/io/RandomAccessFile:close	()V
    //   300: aload 16
    //   302: aload 15
    //   304: invokestatic 1156	com/tencent/mobileqq/utils/FileUtils:renameFile	(Ljava/io/File;Ljava/io/File;)Z
    //   307: pop
    //   308: iload 11
    //   310: istore 9
    //   312: invokestatic 246	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   315: ifeq +246 -> 561
    //   318: new 177	java/lang/StringBuilder
    //   321: dup
    //   322: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   325: astore_1
    //   326: aload_1
    //   327: ldc_w 1158
    //   330: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: pop
    //   334: aload_1
    //   335: aload 14
    //   337: getfield 1102	com/tencent/mobileqq/transfile/TransferRequest:mDisplayOutFilePath	Ljava/lang/String;
    //   340: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: ldc_w 258
    //   347: iconst_4
    //   348: aload_1
    //   349: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   355: iload 11
    //   357: istore 9
    //   359: goto +202 -> 561
    //   362: astore_1
    //   363: iload 10
    //   365: istore 9
    //   367: goto +7 -> 374
    //   370: astore_1
    //   371: iconst_0
    //   372: istore 9
    //   374: aload_1
    //   375: invokevirtual 284	java/io/IOException:printStackTrace	()V
    //   378: goto +183 -> 561
    //   381: astore 13
    //   383: aload_1
    //   384: astore 12
    //   386: aload 13
    //   388: astore_1
    //   389: goto +7 -> 396
    //   392: goto +81 -> 473
    //   395: astore_1
    //   396: aload 12
    //   398: ifnull +73 -> 471
    //   401: aload 12
    //   403: invokevirtual 283	java/io/RandomAccessFile:close	()V
    //   406: aload 16
    //   408: aload 15
    //   410: invokestatic 1156	com/tencent/mobileqq/utils/FileUtils:renameFile	(Ljava/io/File;Ljava/io/File;)Z
    //   413: pop
    //   414: invokestatic 246	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   417: ifeq +54 -> 471
    //   420: new 177	java/lang/StringBuilder
    //   423: dup
    //   424: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   427: astore 12
    //   429: aload 12
    //   431: ldc_w 1158
    //   434: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: pop
    //   438: aload 12
    //   440: aload 14
    //   442: getfield 1102	com/tencent/mobileqq/transfile/TransferRequest:mDisplayOutFilePath	Ljava/lang/String;
    //   445: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: pop
    //   449: ldc_w 258
    //   452: iconst_4
    //   453: aload 12
    //   455: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   458: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   461: goto +10 -> 471
    //   464: astore 12
    //   466: aload 12
    //   468: invokevirtual 284	java/io/IOException:printStackTrace	()V
    //   471: aload_1
    //   472: athrow
    //   473: aload_1
    //   474: ifnull +84 -> 558
    //   477: aload_1
    //   478: invokevirtual 283	java/io/RandomAccessFile:close	()V
    //   481: aload 16
    //   483: aload 15
    //   485: invokestatic 1156	com/tencent/mobileqq/utils/FileUtils:renameFile	(Ljava/io/File;Ljava/io/File;)Z
    //   488: pop
    //   489: iload 11
    //   491: istore 9
    //   493: invokestatic 246	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   496: ifeq +65 -> 561
    //   499: new 177	java/lang/StringBuilder
    //   502: dup
    //   503: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   506: astore_1
    //   507: aload_1
    //   508: ldc_w 1158
    //   511: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: pop
    //   515: aload_1
    //   516: aload 14
    //   518: getfield 1102	com/tencent/mobileqq/transfile/TransferRequest:mDisplayOutFilePath	Ljava/lang/String;
    //   521: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: pop
    //   525: ldc_w 258
    //   528: iconst_4
    //   529: aload_1
    //   530: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   533: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   536: iload 11
    //   538: istore 9
    //   540: goto +21 -> 561
    //   543: astore_1
    //   544: iload 10
    //   546: istore 9
    //   548: goto -174 -> 374
    //   551: astore_1
    //   552: iconst_0
    //   553: istore 9
    //   555: goto -181 -> 374
    //   558: iconst_0
    //   559: istore 9
    //   561: aload_0
    //   562: getfield 980	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:mDownCallBacks	Ljava/util/ArrayList;
    //   565: invokevirtual 869	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   568: astore_1
    //   569: aload_1
    //   570: invokeinterface 874 1 0
    //   575: ifeq +24 -> 599
    //   578: aload_1
    //   579: invokeinterface 878 1 0
    //   584: checkcast 982	com/tencent/mobileqq/pic/DownCallBack
    //   587: iload 6
    //   589: iload 9
    //   591: invokeinterface 1161 3 0
    //   596: goto -27 -> 569
    //   599: aload_0
    //   600: monitorexit
    //   601: return
    //   602: astore_1
    //   603: aload_0
    //   604: monitorexit
    //   605: goto +5 -> 610
    //   608: aload_1
    //   609: athrow
    //   610: goto -2 -> 608
    //   613: astore_1
    //   614: aload 13
    //   616: astore_1
    //   617: goto -144 -> 473
    //   620: astore 12
    //   622: goto -230 -> 392
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	625	0	this	BasePicDownloadProcessor
    //   0	625	1	paramNetReq	NetReq
    //   0	625	2	paramLong1	long
    //   0	625	4	paramLong2	long
    //   9	579	6	i	int
    //   80	145	7	j	int
    //   87	9	8	k	int
    //   310	280	9	bool1	boolean
    //   93	452	10	bool2	boolean
    //   90	447	11	bool3	boolean
    //   178	276	12	localObject1	Object
    //   464	3	12	localIOException1	java.io.IOException
    //   620	1	12	localIOException2	java.io.IOException
    //   215	1	13	localObject2	Object
    //   381	234	13	localObject3	Object
    //   73	444	14	localTransferRequest	TransferRequest
    //   125	359	15	localFile1	File
    //   212	270	16	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   312	355	362	java/io/IOException
    //   296	308	370	java/io/IOException
    //   270	292	381	finally
    //   220	231	395	finally
    //   238	252	395	finally
    //   257	270	395	finally
    //   401	461	464	java/io/IOException
    //   493	536	543	java/io/IOException
    //   477	489	551	java/io/IOException
    //   52	69	602	finally
    //   69	89	602	finally
    //   105	153	602	finally
    //   171	214	602	finally
    //   296	308	602	finally
    //   312	355	602	finally
    //   374	378	602	finally
    //   401	461	602	finally
    //   466	471	602	finally
    //   471	473	602	finally
    //   477	489	602	finally
    //   493	536	602	finally
    //   561	569	602	finally
    //   569	596	602	finally
    //   599	601	602	finally
    //   603	605	602	finally
    //   220	231	613	java/io/IOException
    //   238	252	613	java/io/IOException
    //   257	270	613	java/io/IOException
    //   270	292	620	java/io/IOException
  }
  
  void receiveFile(boolean paramBoolean) {}
  
  protected void refreshURLDrawable(MessageForPic paramMessageForPic, URL paramURL, boolean paramBoolean)
  {
    if ((paramBoolean) && (GlobalImageCache.a.get(paramURL.toString()) != null))
    {
      GlobalImageCache.a.remove(paramURL.toString());
      paramURL = URLDrawable.getDrawable(paramURL);
      if (paramURL != null)
      {
        if (paramMessageForPic.thumbWidthHeightDP == null)
        {
          paramURL.downloadImediatly(true);
          return;
        }
        paramURL.invalidateSelf();
      }
    }
  }
  
  void sendRequest() {}
  
  public void updateThumb(MessageForPic paramMessageForPic)
  {
    int i = paramMessageForPic.fileSizeFlag;
    boolean bool2 = true;
    boolean bool1;
    if (i == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (this.mUiRequest.mFileType == ((IPicHelper)QRoute.api(IPicHelper.class)).getFileSizeType("chatimg", bool1))
    {
      CompressInfo localCompressInfo = new CompressInfo(this.mUiRequest.mOutFilePath, 0);
      URL localURL = ((IPicHelper)QRoute.api(IPicHelper.class)).getURL(paramMessageForPic, 65537, null);
      localCompressInfo.u = true;
      Object localObject = AbsDownloader.getFilePath(localURL.toString());
      if (!((String)localObject).endsWith("_hd"))
      {
        if (((String)localObject).endsWith("_big400"))
        {
          ((String)localObject).replace("_big400", "_hd");
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject);
          localStringBuilder.append("_hd");
          localObject = localStringBuilder.toString();
        }
        localCompressInfo.l = ((String)localObject);
        localCompressInfo.x = paramMessageForPic.thumbWidthHeightDP;
        ((ICompressOperator)QRoute.api(ICompressOperator.class)).startThumbnail(localCompressInfo);
        if (localCompressInfo.l != null)
        {
          localObject = new File((String)localObject);
          bool1 = bool2;
          if (localCompressInfo.l.equals(localCompressInfo.h)) {
            bool1 = FileUtils.copyFile(new File(localCompressInfo.h), (File)localObject);
          }
          refreshURLDrawable(paramMessageForPic, localURL, bool1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BasePicDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */