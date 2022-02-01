package com.tencent.mobileqq.transfile;

import amrp;
import amtr;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import aqcn;
import aqco;
import avsq;
import aycx;
import aycy;
import ayeu;
import bcel;
import bcjc;
import bfuq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
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
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.transfile.report.RMServMonitorReport;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.PicCryptor;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import fd;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.manager.ProxyIpManager;
import mqq.manager.TicketManager;

public class BasePicDownloadProcessor
  extends BaseDownloadProcessor
  implements INetEngine.NetFailedListener
{
  public static final String C2C_PIC_DOWNLOAD_DOMAIN = "c2cpicdw.qpic.cn";
  public static final String C2C_PIC_DOWNLOAD_ERROR_CODE = "C2CPicDownloadErrorCode";
  static final int DOWNLOAD_ST_COMPLETE = 1;
  static final int DOWNLOAD_ST_HEAD = 2;
  static final int DOWNLOAD_ST_LEFT = 4;
  static final int DOWNLOAD_ST_PART = 3;
  private static final int ENCRYPT_APPID = 1600000226;
  public static final String GROUP_PIC_DOWNLOAD_DOMAIN = "gchat.qpic.cn";
  public static final String GROUP_PIC_DOWNLOAD_ERROR_CODE = "GroupPicDownloadErrorCode";
  public static final String KEY_PIC_DOWNLOAD_ERROR_CODE = "param_detail_code";
  public static final String REPORT_TAG_DIRECT_DOWNLOAD_FAIL = "report_direct_download_fail";
  private static final Pattern URL_ENCRYPR_PATH_PATTERN = Pattern.compile(".*//[^/]*/[^/]*/(.*)/.*");
  protected long decryptConsumeTime;
  private ArrayList<String> failIpReported = new ArrayList();
  protected String mDecryptErrorMsg;
  protected String mDirectDownFailReason = "";
  protected boolean mEncryptPic;
  protected boolean mEncryptUrl;
  protected boolean mIpFromInnerDns;
  protected TransferRequest.PicDownExtraInfo mPicDownExtra;
  protected boolean mPicEncryptRollback;
  protected int mSSORequestReason;
  protected byte[] mST;
  protected byte[] mSTKey;
  public WeakNetLearner mWeakNetLearner;
  
  public BasePicDownloadProcessor() {}
  
  public BasePicDownloadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    this.mWeakNetLearner = BaseTransProcessorStaticVariable.WEAK_NET_LEARNER;
    this.mProxyIpList = ((ProxyIpManager)this.app.getManager(3)).getProxyIp(3);
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
    String str;
    if ((paramNetResp.mReq != null) && (paramNetResp.mReq.mTempPath != null) && (paramNetResp.mReq.mTempPath.length() != 0) && (paramNetResp.mReq.mOutPath != null) && (paramNetResp.mReq.mOutPath.length() != 0))
    {
      str = paramNetResp.mReq.mTempPath;
      paramNetResp = paramNetResp.mReq.mOutPath;
      if (this.mUiRequest != null) {
        break label77;
      }
    }
    label77:
    int i;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        RichMediaUtil.log(this.mUiRequest.mUinType, this.mUiRequest.mIsUp, this.mUiRequest.mFileType, String.valueOf(this.mUiRequest.mUniseq), "handleProgressiveJPEG", "mUiRequest.mRequestOffset: " + this.mUiRequest.mRequestOffset + " mUiRequest.mRequestLength: " + this.mUiRequest.mRequestLength + " tempPath: " + str + " outPath: " + paramNetResp);
      }
      i = getDownloadStatus(this.mUiRequest);
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
    } while (i != 3);
    writeProgressiveMidSlice(paramNetResp, str);
  }
  
  /* Error */
  private void writeProgressiveFirstSlice(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 246	java/io/File
    //   3: dup
    //   4: aload_2
    //   5: invokespecial 249	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_3
    //   9: new 246	java/io/File
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 249	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 4
    //   19: aload 4
    //   21: invokevirtual 252	java/io/File:exists	()Z
    //   24: ifeq +9 -> 33
    //   27: aload 4
    //   29: invokevirtual 255	java/io/File:delete	()Z
    //   32: pop
    //   33: invokestatic 258	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   36: ifeq +43 -> 79
    //   39: ldc_w 260
    //   42: iconst_4
    //   43: new 194	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   50: ldc_w 262
    //   53: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_3
    //   57: invokevirtual 265	java/io/File:length	()J
    //   60: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   63: ldc_w 270
    //   66: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload_1
    //   70: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 274	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   79: aload_3
    //   80: invokevirtual 252	java/io/File:exists	()Z
    //   83: ifeq +90 -> 173
    //   86: new 276	java/io/RandomAccessFile
    //   89: dup
    //   90: aload_3
    //   91: ldc_w 278
    //   94: invokespecial 281	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   97: astore 4
    //   99: aload 4
    //   101: astore_3
    //   102: aload 4
    //   104: aload 4
    //   106: invokevirtual 282	java/io/RandomAccessFile:length	()J
    //   109: invokevirtual 286	java/io/RandomAccessFile:seek	(J)V
    //   112: aload 4
    //   114: astore_3
    //   115: aload 4
    //   117: iconst_2
    //   118: newarray byte
    //   120: dup
    //   121: iconst_0
    //   122: ldc_w 287
    //   125: bastore
    //   126: dup
    //   127: iconst_1
    //   128: ldc_w 288
    //   131: bastore
    //   132: invokevirtual 292	java/io/RandomAccessFile:write	([B)V
    //   135: aload 4
    //   137: ifnull +8 -> 145
    //   140: aload 4
    //   142: invokevirtual 295	java/io/RandomAccessFile:close	()V
    //   145: aload_2
    //   146: aload_1
    //   147: invokestatic 301	com/tencent/mobileqq/utils/FileUtils:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   150: ifne +23 -> 173
    //   153: aload_2
    //   154: aload_1
    //   155: invokestatic 304	com/tencent/mobileqq/utils/FileUtils:copyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   158: ifeq +24 -> 182
    //   161: new 246	java/io/File
    //   164: dup
    //   165: aload_2
    //   166: invokespecial 249	java/io/File:<init>	(Ljava/lang/String;)V
    //   169: invokevirtual 255	java/io/File:delete	()Z
    //   172: pop
    //   173: return
    //   174: astore_3
    //   175: aload_3
    //   176: invokevirtual 305	java/io/IOException:printStackTrace	()V
    //   179: goto -34 -> 145
    //   182: new 246	java/io/File
    //   185: dup
    //   186: aload_2
    //   187: invokespecial 249	java/io/File:<init>	(Ljava/lang/String;)V
    //   190: invokevirtual 255	java/io/File:delete	()Z
    //   193: pop
    //   194: return
    //   195: astore 5
    //   197: aconst_null
    //   198: astore 4
    //   200: aload 4
    //   202: astore_3
    //   203: aload 5
    //   205: invokevirtual 306	java/io/FileNotFoundException:printStackTrace	()V
    //   208: aload 4
    //   210: ifnull +8 -> 218
    //   213: aload 4
    //   215: invokevirtual 295	java/io/RandomAccessFile:close	()V
    //   218: aload_2
    //   219: aload_1
    //   220: invokestatic 301	com/tencent/mobileqq/utils/FileUtils:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   223: ifne -50 -> 173
    //   226: aload_2
    //   227: aload_1
    //   228: invokestatic 304	com/tencent/mobileqq/utils/FileUtils:copyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   231: ifeq +24 -> 255
    //   234: new 246	java/io/File
    //   237: dup
    //   238: aload_2
    //   239: invokespecial 249	java/io/File:<init>	(Ljava/lang/String;)V
    //   242: invokevirtual 255	java/io/File:delete	()Z
    //   245: pop
    //   246: return
    //   247: astore_3
    //   248: aload_3
    //   249: invokevirtual 305	java/io/IOException:printStackTrace	()V
    //   252: goto -34 -> 218
    //   255: new 246	java/io/File
    //   258: dup
    //   259: aload_2
    //   260: invokespecial 249	java/io/File:<init>	(Ljava/lang/String;)V
    //   263: invokevirtual 255	java/io/File:delete	()Z
    //   266: pop
    //   267: return
    //   268: astore 5
    //   270: aconst_null
    //   271: astore 4
    //   273: aload 4
    //   275: astore_3
    //   276: aload 5
    //   278: invokevirtual 305	java/io/IOException:printStackTrace	()V
    //   281: aload 4
    //   283: ifnull +8 -> 291
    //   286: aload 4
    //   288: invokevirtual 295	java/io/RandomAccessFile:close	()V
    //   291: aload_2
    //   292: aload_1
    //   293: invokestatic 301	com/tencent/mobileqq/utils/FileUtils:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   296: ifne -123 -> 173
    //   299: aload_2
    //   300: aload_1
    //   301: invokestatic 304	com/tencent/mobileqq/utils/FileUtils:copyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   304: ifeq +24 -> 328
    //   307: new 246	java/io/File
    //   310: dup
    //   311: aload_2
    //   312: invokespecial 249	java/io/File:<init>	(Ljava/lang/String;)V
    //   315: invokevirtual 255	java/io/File:delete	()Z
    //   318: pop
    //   319: return
    //   320: astore_3
    //   321: aload_3
    //   322: invokevirtual 305	java/io/IOException:printStackTrace	()V
    //   325: goto -34 -> 291
    //   328: new 246	java/io/File
    //   331: dup
    //   332: aload_2
    //   333: invokespecial 249	java/io/File:<init>	(Ljava/lang/String;)V
    //   336: invokevirtual 255	java/io/File:delete	()Z
    //   339: pop
    //   340: return
    //   341: astore 4
    //   343: aconst_null
    //   344: astore_3
    //   345: aload_3
    //   346: ifnull +7 -> 353
    //   349: aload_3
    //   350: invokevirtual 295	java/io/RandomAccessFile:close	()V
    //   353: aload_2
    //   354: aload_1
    //   355: invokestatic 301	com/tencent/mobileqq/utils/FileUtils:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   358: ifne +23 -> 381
    //   361: aload_2
    //   362: aload_1
    //   363: invokestatic 304	com/tencent/mobileqq/utils/FileUtils:copyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   366: ifeq +26 -> 392
    //   369: new 246	java/io/File
    //   372: dup
    //   373: aload_2
    //   374: invokespecial 249	java/io/File:<init>	(Ljava/lang/String;)V
    //   377: invokevirtual 255	java/io/File:delete	()Z
    //   380: pop
    //   381: aload 4
    //   383: athrow
    //   384: astore_3
    //   385: aload_3
    //   386: invokevirtual 305	java/io/IOException:printStackTrace	()V
    //   389: goto -36 -> 353
    //   392: new 246	java/io/File
    //   395: dup
    //   396: aload_2
    //   397: invokespecial 249	java/io/File:<init>	(Ljava/lang/String;)V
    //   400: invokevirtual 255	java/io/File:delete	()Z
    //   403: pop
    //   404: goto -23 -> 381
    //   407: astore 4
    //   409: goto -64 -> 345
    //   412: astore 5
    //   414: goto -141 -> 273
    //   417: astore 5
    //   419: goto -219 -> 200
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	422	0	this	BasePicDownloadProcessor
    //   0	422	1	paramString1	String
    //   0	422	2	paramString2	String
    //   8	107	3	localObject1	Object
    //   174	2	3	localIOException1	java.io.IOException
    //   202	1	3	localObject2	Object
    //   247	2	3	localIOException2	java.io.IOException
    //   275	1	3	localObject3	Object
    //   320	2	3	localIOException3	java.io.IOException
    //   344	6	3	localObject4	Object
    //   384	2	3	localIOException4	java.io.IOException
    //   17	270	4	localObject5	Object
    //   341	41	4	localObject6	Object
    //   407	1	4	localObject7	Object
    //   195	9	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   268	9	5	localIOException5	java.io.IOException
    //   412	1	5	localIOException6	java.io.IOException
    //   417	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   140	145	174	java/io/IOException
    //   86	99	195	java/io/FileNotFoundException
    //   213	218	247	java/io/IOException
    //   86	99	268	java/io/IOException
    //   286	291	320	java/io/IOException
    //   86	99	341	finally
    //   349	353	384	java/io/IOException
    //   102	112	407	finally
    //   115	135	407	finally
    //   203	208	407	finally
    //   276	281	407	finally
    //   102	112	412	java/io/IOException
    //   115	135	412	java/io/IOException
    //   102	112	417	java/io/FileNotFoundException
    //   115	135	417	java/io/FileNotFoundException
  }
  
  /* Error */
  private void writeProgressiveLastSlice(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 4
    //   6: new 194	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   13: aload_1
    //   14: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: ldc_w 308
    //   20: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: astore 7
    //   28: aload_1
    //   29: aload 7
    //   31: invokestatic 304	com/tencent/mobileqq/utils/FileUtils:copyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   34: pop
    //   35: new 246	java/io/File
    //   38: dup
    //   39: aload 7
    //   41: invokespecial 249	java/io/File:<init>	(Ljava/lang/String;)V
    //   44: astore 5
    //   46: new 246	java/io/File
    //   49: dup
    //   50: aload_2
    //   51: invokespecial 249	java/io/File:<init>	(Ljava/lang/String;)V
    //   54: astore 8
    //   56: invokestatic 258	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   59: ifeq +44 -> 103
    //   62: ldc_w 260
    //   65: iconst_4
    //   66: new 194	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   73: ldc_w 310
    //   76: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload 8
    //   81: invokevirtual 265	java/io/File:length	()J
    //   84: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   87: ldc_w 270
    //   90: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_1
    //   94: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 274	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: aload 5
    //   105: invokevirtual 252	java/io/File:exists	()Z
    //   108: ifeq +140 -> 248
    //   111: aload 8
    //   113: invokevirtual 252	java/io/File:exists	()Z
    //   116: ifeq +132 -> 248
    //   119: new 276	java/io/RandomAccessFile
    //   122: dup
    //   123: aload 5
    //   125: ldc_w 278
    //   128: invokespecial 281	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   131: astore_2
    //   132: aload_2
    //   133: aload_0
    //   134: getfield 167	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   137: getfield 204	com/tencent/mobileqq/transfile/TransferRequest:mRequestOffset	I
    //   140: i2l
    //   141: invokevirtual 286	java/io/RandomAccessFile:seek	(J)V
    //   144: new 312	java/io/FileInputStream
    //   147: dup
    //   148: aload 8
    //   150: invokespecial 315	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   153: astore 5
    //   155: sipush 1024
    //   158: newarray byte
    //   160: astore 4
    //   162: aload 5
    //   164: aload 4
    //   166: invokevirtual 319	java/io/FileInputStream:read	([B)I
    //   169: istore_3
    //   170: iload_3
    //   171: ifle +78 -> 249
    //   174: aload_2
    //   175: aload 4
    //   177: iconst_0
    //   178: iload_3
    //   179: invokevirtual 322	java/io/RandomAccessFile:write	([BII)V
    //   182: goto -20 -> 162
    //   185: astore 4
    //   187: aload_2
    //   188: astore 4
    //   190: aload 5
    //   192: astore_2
    //   193: aload 4
    //   195: ifnull +8 -> 203
    //   198: aload 4
    //   200: invokevirtual 295	java/io/RandomAccessFile:close	()V
    //   203: aload_2
    //   204: ifnull +7 -> 211
    //   207: aload_2
    //   208: invokevirtual 323	java/io/FileInputStream:close	()V
    //   211: aload 8
    //   213: invokevirtual 255	java/io/File:delete	()Z
    //   216: pop
    //   217: aload 7
    //   219: aload_1
    //   220: invokestatic 301	com/tencent/mobileqq/utils/FileUtils:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   223: ifne +25 -> 248
    //   226: aload 7
    //   228: aload_1
    //   229: invokestatic 304	com/tencent/mobileqq/utils/FileUtils:copyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   232: ifeq +121 -> 353
    //   235: new 246	java/io/File
    //   238: dup
    //   239: aload 7
    //   241: invokespecial 249	java/io/File:<init>	(Ljava/lang/String;)V
    //   244: invokevirtual 255	java/io/File:delete	()Z
    //   247: pop
    //   248: return
    //   249: aload_2
    //   250: ifnull +7 -> 257
    //   253: aload_2
    //   254: invokevirtual 295	java/io/RandomAccessFile:close	()V
    //   257: aload 5
    //   259: ifnull +8 -> 267
    //   262: aload 5
    //   264: invokevirtual 323	java/io/FileInputStream:close	()V
    //   267: aload 8
    //   269: invokevirtual 255	java/io/File:delete	()Z
    //   272: pop
    //   273: aload 7
    //   275: aload_1
    //   276: invokestatic 301	com/tencent/mobileqq/utils/FileUtils:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   279: ifne -31 -> 248
    //   282: aload 7
    //   284: aload_1
    //   285: invokestatic 304	com/tencent/mobileqq/utils/FileUtils:copyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   288: ifeq +33 -> 321
    //   291: new 246	java/io/File
    //   294: dup
    //   295: aload 7
    //   297: invokespecial 249	java/io/File:<init>	(Ljava/lang/String;)V
    //   300: invokevirtual 255	java/io/File:delete	()Z
    //   303: pop
    //   304: return
    //   305: astore_2
    //   306: aload_2
    //   307: invokevirtual 305	java/io/IOException:printStackTrace	()V
    //   310: goto -53 -> 257
    //   313: astore_2
    //   314: aload_2
    //   315: invokevirtual 305	java/io/IOException:printStackTrace	()V
    //   318: goto -51 -> 267
    //   321: new 246	java/io/File
    //   324: dup
    //   325: aload 7
    //   327: invokespecial 249	java/io/File:<init>	(Ljava/lang/String;)V
    //   330: invokevirtual 255	java/io/File:delete	()Z
    //   333: pop
    //   334: return
    //   335: astore 4
    //   337: aload 4
    //   339: invokevirtual 305	java/io/IOException:printStackTrace	()V
    //   342: goto -139 -> 203
    //   345: astore_2
    //   346: aload_2
    //   347: invokevirtual 305	java/io/IOException:printStackTrace	()V
    //   350: goto -139 -> 211
    //   353: new 246	java/io/File
    //   356: dup
    //   357: aload 7
    //   359: invokespecial 249	java/io/File:<init>	(Ljava/lang/String;)V
    //   362: invokevirtual 255	java/io/File:delete	()Z
    //   365: pop
    //   366: return
    //   367: astore 4
    //   369: aconst_null
    //   370: astore_2
    //   371: aload 6
    //   373: astore 5
    //   375: aload_2
    //   376: ifnull +7 -> 383
    //   379: aload_2
    //   380: invokevirtual 295	java/io/RandomAccessFile:close	()V
    //   383: aload 5
    //   385: ifnull +8 -> 393
    //   388: aload 5
    //   390: invokevirtual 323	java/io/FileInputStream:close	()V
    //   393: aload 8
    //   395: invokevirtual 255	java/io/File:delete	()Z
    //   398: pop
    //   399: aload 7
    //   401: aload_1
    //   402: invokestatic 301	com/tencent/mobileqq/utils/FileUtils:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   405: ifne +25 -> 430
    //   408: aload 7
    //   410: aload_1
    //   411: invokestatic 304	com/tencent/mobileqq/utils/FileUtils:copyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   414: ifeq +35 -> 449
    //   417: new 246	java/io/File
    //   420: dup
    //   421: aload 7
    //   423: invokespecial 249	java/io/File:<init>	(Ljava/lang/String;)V
    //   426: invokevirtual 255	java/io/File:delete	()Z
    //   429: pop
    //   430: aload 4
    //   432: athrow
    //   433: astore_2
    //   434: aload_2
    //   435: invokevirtual 305	java/io/IOException:printStackTrace	()V
    //   438: goto -55 -> 383
    //   441: astore_2
    //   442: aload_2
    //   443: invokevirtual 305	java/io/IOException:printStackTrace	()V
    //   446: goto -53 -> 393
    //   449: new 246	java/io/File
    //   452: dup
    //   453: aload 7
    //   455: invokespecial 249	java/io/File:<init>	(Ljava/lang/String;)V
    //   458: invokevirtual 255	java/io/File:delete	()Z
    //   461: pop
    //   462: goto -32 -> 430
    //   465: astore 4
    //   467: aload 6
    //   469: astore 5
    //   471: goto -96 -> 375
    //   474: astore 4
    //   476: goto -101 -> 375
    //   479: astore_2
    //   480: aconst_null
    //   481: astore_2
    //   482: goto -289 -> 193
    //   485: astore 4
    //   487: aconst_null
    //   488: astore 5
    //   490: aload_2
    //   491: astore 4
    //   493: aload 5
    //   495: astore_2
    //   496: goto -303 -> 193
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	499	0	this	BasePicDownloadProcessor
    //   0	499	1	paramString1	String
    //   0	499	2	paramString2	String
    //   169	10	3	i	int
    //   4	172	4	arrayOfByte	byte[]
    //   185	1	4	localThrowable1	Throwable
    //   188	11	4	str1	String
    //   335	3	4	localIOException	java.io.IOException
    //   367	64	4	localObject1	Object
    //   465	1	4	localObject2	Object
    //   474	1	4	localObject3	Object
    //   485	1	4	localThrowable2	Throwable
    //   491	1	4	str2	String
    //   44	450	5	localObject4	Object
    //   1	467	6	localObject5	Object
    //   26	428	7	str3	String
    //   54	340	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   155	162	185	java/lang/Throwable
    //   162	170	185	java/lang/Throwable
    //   174	182	185	java/lang/Throwable
    //   253	257	305	java/io/IOException
    //   262	267	313	java/io/IOException
    //   198	203	335	java/io/IOException
    //   207	211	345	java/io/IOException
    //   119	132	367	finally
    //   379	383	433	java/io/IOException
    //   388	393	441	java/io/IOException
    //   132	155	465	finally
    //   155	162	474	finally
    //   162	170	474	finally
    //   174	182	474	finally
    //   119	132	479	java/lang/Throwable
    //   132	155	485	java/lang/Throwable
  }
  
  /* Error */
  private void writeProgressiveMidSlice(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 4
    //   6: new 194	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   13: aload_1
    //   14: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: ldc_w 308
    //   20: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: astore 7
    //   28: aload_1
    //   29: aload 7
    //   31: invokestatic 304	com/tencent/mobileqq/utils/FileUtils:copyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   34: pop
    //   35: new 246	java/io/File
    //   38: dup
    //   39: aload 7
    //   41: invokespecial 249	java/io/File:<init>	(Ljava/lang/String;)V
    //   44: astore 5
    //   46: new 246	java/io/File
    //   49: dup
    //   50: aload_2
    //   51: invokespecial 249	java/io/File:<init>	(Ljava/lang/String;)V
    //   54: astore 8
    //   56: invokestatic 258	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   59: ifeq +44 -> 103
    //   62: ldc_w 260
    //   65: iconst_4
    //   66: new 194	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   73: ldc_w 325
    //   76: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload 8
    //   81: invokevirtual 265	java/io/File:length	()J
    //   84: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   87: ldc_w 270
    //   90: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_1
    //   94: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 274	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: aload 5
    //   105: invokevirtual 252	java/io/File:exists	()Z
    //   108: ifeq +140 -> 248
    //   111: aload 8
    //   113: invokevirtual 252	java/io/File:exists	()Z
    //   116: ifeq +132 -> 248
    //   119: new 276	java/io/RandomAccessFile
    //   122: dup
    //   123: aload 5
    //   125: ldc_w 278
    //   128: invokespecial 281	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   131: astore_2
    //   132: aload_2
    //   133: aload_0
    //   134: getfield 167	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   137: getfield 204	com/tencent/mobileqq/transfile/TransferRequest:mRequestOffset	I
    //   140: i2l
    //   141: invokevirtual 286	java/io/RandomAccessFile:seek	(J)V
    //   144: new 312	java/io/FileInputStream
    //   147: dup
    //   148: aload 8
    //   150: invokespecial 315	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   153: astore 5
    //   155: sipush 1024
    //   158: newarray byte
    //   160: astore 4
    //   162: aload 5
    //   164: aload 4
    //   166: invokevirtual 319	java/io/FileInputStream:read	([B)I
    //   169: istore_3
    //   170: iload_3
    //   171: ifle +78 -> 249
    //   174: aload_2
    //   175: aload 4
    //   177: iconst_0
    //   178: iload_3
    //   179: invokevirtual 322	java/io/RandomAccessFile:write	([BII)V
    //   182: goto -20 -> 162
    //   185: astore 4
    //   187: aload_2
    //   188: astore 4
    //   190: aload 5
    //   192: astore_2
    //   193: aload 4
    //   195: ifnull +8 -> 203
    //   198: aload 4
    //   200: invokevirtual 295	java/io/RandomAccessFile:close	()V
    //   203: aload_2
    //   204: ifnull +7 -> 211
    //   207: aload_2
    //   208: invokevirtual 323	java/io/FileInputStream:close	()V
    //   211: aload 8
    //   213: invokevirtual 255	java/io/File:delete	()Z
    //   216: pop
    //   217: aload 7
    //   219: aload_1
    //   220: invokestatic 301	com/tencent/mobileqq/utils/FileUtils:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   223: ifne +25 -> 248
    //   226: aload 7
    //   228: aload_1
    //   229: invokestatic 304	com/tencent/mobileqq/utils/FileUtils:copyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   232: ifeq +106 -> 338
    //   235: new 246	java/io/File
    //   238: dup
    //   239: aload 7
    //   241: invokespecial 249	java/io/File:<init>	(Ljava/lang/String;)V
    //   244: invokevirtual 255	java/io/File:delete	()Z
    //   247: pop
    //   248: return
    //   249: aload_2
    //   250: iconst_2
    //   251: newarray byte
    //   253: dup
    //   254: iconst_0
    //   255: ldc_w 287
    //   258: bastore
    //   259: dup
    //   260: iconst_1
    //   261: ldc_w 288
    //   264: bastore
    //   265: invokevirtual 292	java/io/RandomAccessFile:write	([B)V
    //   268: aload_2
    //   269: ifnull +7 -> 276
    //   272: aload_2
    //   273: invokevirtual 295	java/io/RandomAccessFile:close	()V
    //   276: aload 5
    //   278: ifnull +8 -> 286
    //   281: aload 5
    //   283: invokevirtual 323	java/io/FileInputStream:close	()V
    //   286: aload 8
    //   288: invokevirtual 255	java/io/File:delete	()Z
    //   291: pop
    //   292: aload 7
    //   294: aload_1
    //   295: invokestatic 301	com/tencent/mobileqq/utils/FileUtils:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   298: ifne -50 -> 248
    //   301: aload 7
    //   303: aload_1
    //   304: invokestatic 304	com/tencent/mobileqq/utils/FileUtils:copyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   307: ifeq +17 -> 324
    //   310: new 246	java/io/File
    //   313: dup
    //   314: aload 7
    //   316: invokespecial 249	java/io/File:<init>	(Ljava/lang/String;)V
    //   319: invokevirtual 255	java/io/File:delete	()Z
    //   322: pop
    //   323: return
    //   324: new 246	java/io/File
    //   327: dup
    //   328: aload 7
    //   330: invokespecial 249	java/io/File:<init>	(Ljava/lang/String;)V
    //   333: invokevirtual 255	java/io/File:delete	()Z
    //   336: pop
    //   337: return
    //   338: new 246	java/io/File
    //   341: dup
    //   342: aload 7
    //   344: invokespecial 249	java/io/File:<init>	(Ljava/lang/String;)V
    //   347: invokevirtual 255	java/io/File:delete	()Z
    //   350: pop
    //   351: return
    //   352: astore 4
    //   354: aconst_null
    //   355: astore_2
    //   356: aload 6
    //   358: astore 5
    //   360: aload_2
    //   361: ifnull +7 -> 368
    //   364: aload_2
    //   365: invokevirtual 295	java/io/RandomAccessFile:close	()V
    //   368: aload 5
    //   370: ifnull +8 -> 378
    //   373: aload 5
    //   375: invokevirtual 323	java/io/FileInputStream:close	()V
    //   378: aload 8
    //   380: invokevirtual 255	java/io/File:delete	()Z
    //   383: pop
    //   384: aload 7
    //   386: aload_1
    //   387: invokestatic 301	com/tencent/mobileqq/utils/FileUtils:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   390: ifne +25 -> 415
    //   393: aload 7
    //   395: aload_1
    //   396: invokestatic 304	com/tencent/mobileqq/utils/FileUtils:copyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   399: ifeq +19 -> 418
    //   402: new 246	java/io/File
    //   405: dup
    //   406: aload 7
    //   408: invokespecial 249	java/io/File:<init>	(Ljava/lang/String;)V
    //   411: invokevirtual 255	java/io/File:delete	()Z
    //   414: pop
    //   415: aload 4
    //   417: athrow
    //   418: new 246	java/io/File
    //   421: dup
    //   422: aload 7
    //   424: invokespecial 249	java/io/File:<init>	(Ljava/lang/String;)V
    //   427: invokevirtual 255	java/io/File:delete	()Z
    //   430: pop
    //   431: goto -16 -> 415
    //   434: astore_2
    //   435: goto -159 -> 276
    //   438: astore_2
    //   439: goto -153 -> 286
    //   442: astore 4
    //   444: goto -241 -> 203
    //   447: astore_2
    //   448: goto -237 -> 211
    //   451: astore_2
    //   452: goto -84 -> 368
    //   455: astore_2
    //   456: goto -78 -> 378
    //   459: astore 4
    //   461: aload 6
    //   463: astore 5
    //   465: goto -105 -> 360
    //   468: astore 4
    //   470: goto -110 -> 360
    //   473: astore_2
    //   474: aconst_null
    //   475: astore_2
    //   476: goto -283 -> 193
    //   479: astore 4
    //   481: aconst_null
    //   482: astore 5
    //   484: aload_2
    //   485: astore 4
    //   487: aload 5
    //   489: astore_2
    //   490: goto -297 -> 193
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	493	0	this	BasePicDownloadProcessor
    //   0	493	1	paramString1	String
    //   0	493	2	paramString2	String
    //   169	10	3	i	int
    //   4	172	4	arrayOfByte	byte[]
    //   185	1	4	localIOException1	java.io.IOException
    //   188	11	4	str1	String
    //   352	64	4	localObject1	Object
    //   442	1	4	localIOException2	java.io.IOException
    //   459	1	4	localObject2	Object
    //   468	1	4	localObject3	Object
    //   479	1	4	localIOException3	java.io.IOException
    //   485	1	4	str2	String
    //   44	444	5	localObject4	Object
    //   1	461	6	localObject5	Object
    //   26	397	7	str3	String
    //   54	325	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   155	162	185	java/io/IOException
    //   162	170	185	java/io/IOException
    //   174	182	185	java/io/IOException
    //   249	268	185	java/io/IOException
    //   119	132	352	finally
    //   272	276	434	java/io/IOException
    //   281	286	438	java/io/IOException
    //   198	203	442	java/io/IOException
    //   207	211	447	java/io/IOException
    //   364	368	451	java/io/IOException
    //   373	378	455	java/io/IOException
    //   132	155	459	finally
    //   155	162	468	finally
    //   162	170	468	finally
    //   174	182	468	finally
    //   249	268	468	finally
    //   119	132	473	java/io/IOException
    //   132	155	479	java/io/IOException
  }
  
  protected String appendInfoForSvr(String paramString, int paramInt)
  {
    String str = "&rf=other";
    if (this.mUiRequest.mDownMode == 0)
    {
      str = "&rf=aio";
      str = "cldver=8.4.8.4810" + str;
      paramInt = paramString.indexOf("?");
      if (paramInt <= 0) {
        break label219;
      }
      if (paramString.length() != paramInt + 1) {
        break label136;
      }
      paramString = paramString.substring(0, paramInt + 1) + str;
    }
    for (;;)
    {
      return paramString + "&msgTime=" + this.mUiRequest.mMsgTime;
      if (this.mUiRequest.mDownMode != 1) {
        break;
      }
      str = "&rf=naio";
      break;
      label136:
      paramInt = paramString.indexOf("#", paramInt);
      if (paramInt > -1)
      {
        paramString = paramString.substring(0, paramInt) + "&" + str + paramString.substring(paramInt);
      }
      else
      {
        paramString = paramString + "&" + str;
        continue;
        label219:
        paramString = paramString + "?" + str;
      }
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
      if (l2 < l1)
      {
        QLog.e("BaseTransProcessor", 1, "checkMemoryForEncrypt : memory is not enough ! remainMemory = " + l2 + ", picSize = " + l1);
        return false;
      }
      if (l1 > 5242880L)
      {
        QLog.e("BaseTransProcessor", 1, "checkMemoryForEncrypt : pic too large, picSize = " + l1);
        return false;
      }
    }
    return true;
  }
  
  void directMsgUrlDown(String paramString, int paramInt)
  {
    boolean bool = false;
    this.mUrlPath = this.mPicDownExtra.mUrlFromMsg;
    if ((this.mUrlPath == null) || (this.mUrlPath.length() == 0))
    {
      this.mSSORequestReason = 1;
      sendRequest();
      return;
    }
    if (!QLog.isColorLevel()) {}
    for (;;)
    {
      this.mIpList = selectIpList(makeServerIpList(InnerDns.getInstance().reqDnsForIpList(paramString, paramInt, true, 28, false), true), makeServerIpList(InnerDns.getInstance().reqDnsForIpList(paramString, paramInt, true, 1, false), false));
      if ((this.mIpList == null) || (this.mIpList.size() <= 0)) {
        break;
      }
      this.mIpFromInnerDns = true;
      this.mDirectMsgUrlDown = true;
      this.mStepDirectDown.logStartTime();
      paramString = aqcn.a();
      if (paramString != null)
      {
        bool = paramString.a();
        if (QLog.isColorLevel()) {
          QLog.d("BaseTransProcessor", 2, "isHttps: " + bool);
        }
        if (bool)
        {
          this.mEncryptPic = false;
          this.mEncryptUrl = false;
        }
      }
      receiveFile(bool);
      return;
      if (this.mUrlPath.contains("com.tencent.mobileqq"))
      {
        bcel.a("Download_Pic_URL_Invalid", this.mUrlPath);
        QLog.d("BaseTransProcessor", 1, "directMsgUrlDown Download_Pic_URL_Invalid:" + this.mUrlPath);
      }
    }
    this.mSSORequestReason = 2;
    sendRequest();
  }
  
  protected void doReport(boolean paramBoolean, String paramString, long paramLong, HashMap<String, String> paramHashMap)
  {
    int i;
    String str;
    if (!paramBoolean)
    {
      i = this.errCode;
      if (this.errCode != -9527) {
        break label71;
      }
      str = (String)this.mReportInfo.get("param_reason");
      if (str == null) {
        break label71;
      }
    }
    for (;;)
    {
      paramHashMap.put("param_detail_code", str);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, paramString, true, paramLong, this.mTotolLen, paramHashMap, null);
      return;
      label71:
      str = String.valueOf(i);
    }
  }
  
  public void encryptConfigInit()
  {
    Object localObject = (TicketManager)this.app.getManager(2);
    this.mSTKey = ((TicketManager)localObject).getStkey(this.app.getAccount(), 1600000226);
    this.mST = ((TicketManager)localObject).getSt(this.app.getAccount(), 1600000226);
    subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf localDownloadEncryptConf = FMTSrvAddrProvider.getInstance().getPicDownEncryptConf();
    if ((this.mST != null) && (this.mSTKey != null) && (this.mST.length > 0) && (this.mSTKey.length > 0) && (localDownloadEncryptConf != null))
    {
      this.mEncryptUrl = localDownloadEncryptConf.bool_enable_encrypt_request.get();
      this.mEncryptPic = localDownloadEncryptConf.bool_enable_encrypted_pic.get();
      if (this.mSTKey != null) {
        break label170;
      }
    }
    label170:
    for (localObject = "key or switch can't get!";; localObject = "STKey:" + MD5.toMD5(this.mSTKey))
    {
      logRichMediaEvent("ticketInit", (String)localObject);
      if ((!isAllowEncrypt(localDownloadEncryptConf)) || (!IS_MAIN_PROCESS))
      {
        this.mEncryptPic = false;
        this.mEncryptUrl = false;
      }
      return;
      this.mEncryptPic = false;
      this.mEncryptUrl = false;
      break;
    }
  }
  
  public void encryptReqInit(HttpNetReq paramHttpNetReq, String paramString)
  {
    if (this.mEncryptUrl)
    {
      paramHttpNetReq.mReqUrl = encryptURL(paramString);
      if (!paramString.equals(paramHttpNetReq.mReqUrl))
      {
        paramHttpNetReq.mReqProperties.put("Cookie", "mST=" + PkgTools.toHexStr(this.mST));
        if (this.mEncryptPic)
        {
          PicCryptor localPicCryptor = new PicCryptor(this.mSTKey);
          localPicCryptor.a = paramHttpNetReq;
          paramHttpNetReq.decoder = localPicCryptor;
          paramHttpNetReq.mTempPath = (paramHttpNetReq.mOutPath + "." + MD5.toMD5(RichMediaUtil.getUrlResoursePath(paramString, false)) + ".tmp");
        }
      }
    }
    for (;;)
    {
      if ((this.mPicEncryptRollback) && (!this.mEncryptPic))
      {
        paramHttpNetReq.mTempPath = (paramHttpNetReq.mOutPath + "." + MD5.toMD5(RichMediaUtil.getUrlResoursePath(paramString, false)) + ".tmp");
        paramHttpNetReq.mReqUrl = (paramString + "&rollback=1");
      }
      return;
      this.mEncryptPic = false;
    }
  }
  
  public String encryptURL(String paramString)
  {
    String str2 = getEncryptPath(paramString);
    Cryptor localCryptor = new Cryptor();
    if (str2 != null)
    {
      String str1 = str2 + "&encrypt=";
      if (this.mEncryptPic) {}
      for (str1 = str1 + "1";; str1 = str1 + "0") {
        return paramString.replace(str2, PkgTools.toHexStr(localCryptor.encrypt(str1.getBytes(), this.mSTKey)));
      }
    }
    this.mEncryptPic = false;
    return paramString;
  }
  
  int getDownloadStatus(TransferRequest paramTransferRequest)
  {
    if (paramTransferRequest.mRequestOffset < 0) {}
    do
    {
      return 1;
      if (paramTransferRequest.mRequestOffset > 0)
      {
        if (paramTransferRequest.mRequestLength > 0) {
          return 3;
        }
        return 4;
      }
    } while (paramTransferRequest.mRequestLength <= 0);
    return 2;
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
    if (GifDrawable.isGifFile(new File(this.mUiRequest.mOutFilePath))) {
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
    label247:
    label250:
    for (;;)
    {
      return;
      if (DeviceInfoUtil.getDispalyDpi() >= 240)
      {
        if ((localObject2 instanceof MessageForMixedMsg))
        {
          localObject1 = ((MessageForMixedMsg)localObject2).getSubMessage(this.mUiRequest.mSubMsgId);
          if ((localObject1 == null) || (!(localObject1 instanceof MessageForPic))) {
            break label247;
          }
        }
        for (localObject1 = (MessageForPic)localObject1;; localObject1 = null)
        {
          if (localObject1 == null) {
            break label250;
          }
          if (((amtr.a((MessageRecord)localObject1)) || (amrp.a((MessageRecord)localObject1))) && (!TextUtils.isEmpty(((MessageForPic)localObject1).md5)))
          {
            localObject2 = this.mUiRequest.mOutFilePath + "_fp";
            bfuq.a(this.mUiRequest.mOutFilePath, (String)localObject2, ((MessageForPic)localObject1).md5);
            return;
            localObject1 = localObject2;
            if (!(localObject2 instanceof MessageForStructing)) {
              break;
            }
            Object localObject3 = (MessageForStructing)localObject2;
            localObject1 = localObject2;
            if (!(((MessageForStructing)localObject3).structingMsg instanceof StructMsgForImageShare)) {
              break;
            }
            localObject3 = ((StructMsgForImageShare)((MessageForStructing)localObject3).structingMsg).getFirstImageElement();
            localObject1 = localObject2;
            if (localObject3 == null) {
              break;
            }
            localObject1 = localObject2;
            if (((bcjc)localObject3).a == null) {
              break;
            }
            localObject1 = ((bcjc)localObject3).a;
            break;
          }
          updateThumb((MessageForPic)localObject1);
          return;
        }
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
    Object localObject1;
    Object localObject2;
    boolean bool;
    if ((this.mEncryptPic) || (this.mEncryptUrl))
    {
      this.mEncryptPic = false;
      this.mEncryptUrl = false;
      this.mPicEncryptRollback = true;
      if (paramNetResp.mErrCode != -9527) {
        break label547;
      }
      localObject1 = (String)paramNetResp.mRespProperties.get(HttpMsg.Param_Reason);
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (((String)localObject1).split("_").length < 3)) {
        break label624;
      }
      Object localObject3 = ((String)localObject1).split("_");
      localObject1 = localObject3[0];
      localObject2 = localObject3[1];
      localObject3 = localObject3[2];
      if ((!"H".equals(localObject1)) || (!"400".equals(localObject2)) || (!((String)localObject3).equals("-106")) || (!this.mEncryptPic)) {
        break label624;
      }
      bool = true;
    }
    for (;;)
    {
      if (this.mNetReq != null)
      {
        if ("encryptReqError=" + bool + ", ResErroCode:" + paramNetResp.mErrCode + " ,erroDesc:" + paramNetResp.mErrDesc + " ,encryptUrl:" + ((HttpNetReq)this.mNetReq).mReqUrl == null)
        {
          localObject1 = "null";
          label278:
          this.mDecryptErrorMsg = ((String)localObject1);
        }
      }
      else
      {
        if (!this.mDirectMsgUrlDown) {
          break label605;
        }
        this.mSSORequestReason = 3;
        this.mDirectDownFailReason = paramNetResp.mErrDesc;
        sendRequest();
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("param_FailCode", String.valueOf(paramNetResp.mErrCode));
        ((HashMap)localObject1).put("param_errorDesc", paramNetResp.mErrDesc);
        if (this.mNetReq != null) {
          ((HashMap)localObject1).put("param_url", ((HttpNetReq)this.mNetReq).mReqUrl);
        }
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.mUiRequest.mSelfUin, "report_direct_download_fail", false, (System.nanoTime() - this.mStartTime) / 1000000L, this.mTotolLen, (HashMap)localObject1, "");
      }
      for (;;)
      {
        localObject1 = new StringBuffer();
        ((StringBuffer)localObject1).append(this.mUiRequest.mUinType);
        ((StringBuffer)localObject1).append(" isMsgDown:");
        ((StringBuffer)localObject1).append(this.mDirectMsgUrlDown);
        ((StringBuffer)localObject1).append(" result:");
        ((StringBuffer)localObject1).append(paramNetResp.mResult);
        ((StringBuffer)localObject1).append(" adr:");
        if (this.mIpList == null) {
          break label612;
        }
        paramNetResp = this.mIpList.iterator();
        while (paramNetResp.hasNext())
        {
          localObject2 = (ServerAddr)paramNetResp.next();
          try
          {
            ((StringBuffer)localObject1).append(StringUtil.toHexString(((ServerAddr)localObject2).mIp) + ",");
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
        label547:
        if (paramNetResp.mErrCode != 9058) {
          break label624;
        }
        bool = true;
        break;
        localObject1 = ((HttpNetReq)this.mNetReq).mReqUrl + " ,ST:" + PkgTools.toHexStr(this.mST);
        break label278;
        label605:
        onError();
      }
      label612:
      QLog.d("BaseTransProcessor", 1, ((StringBuffer)localObject1).toString());
      return;
      label624:
      bool = false;
    }
  }
  
  public void handleRespSuc(NetResp paramNetResp)
  {
    int i = 0;
    if (!this.mNetReq.mIsRenameInEngine) {
      handleProgressiveJPEG(paramNetResp);
    }
    if (((this.mEncryptUrl) || (this.mEncryptPic)) && (!checkPicFormat(paramNetResp)))
    {
      this.mEncryptPic = false;
      this.mEncryptUrl = false;
      this.mPicEncryptRollback = true;
      if (this.mNetReq != null) {
        this.mDecryptErrorMsg = ("checkPicFormat Erro, erroCode:" + paramNetResp.mErrCode + " ,erroDesc:" + paramNetResp.mErrDesc + " ,encryptUrl:" + ((HttpNetReq)this.mNetReq).mReqUrl + " ,ST:" + PkgTools.toHexStr(this.mST));
      }
      sendRequest();
      return;
    }
    onSuccess();
    RMServMonitorReport localRMServMonitorReport = this.mRSMReporter;
    long l = this.mRecvLen;
    if (this.mPicDownExtra == null) {}
    for (;;)
    {
      localRMServMonitorReport.mFileSize = (l - i);
      reportForServerMonitor(paramNetResp, true, "actRichMediaNetMonitor_picDown", this.mUiRequest.mServerPath);
      return;
      i = this.mPicDownExtra.mStartDownOffset;
    }
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
      ((TransferResult)localObject1).mErrCode = this.errCode;
      ((TransferResult)localObject1).mErrDesc = this.errDesc;
      ((TransferResult)localObject1).mOrigReq = this.mUiRequest;
    }
    Object localObject4;
    try
    {
      if (this.file != null) {
        this.file.status = 2005;
      }
      localObject1 = this.mDownCallBacks.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject4 = (aycx)((Iterator)localObject1).next();
        aycy localaycy = new aycy();
        localaycy.jdField_a_of_type_Int = -1;
        localaycy.jdField_b_of_type_Int = this.errCode;
        localaycy.jdField_a_of_type_JavaLangString = this.errDesc;
        ((aycx)localObject4).a(localaycy);
        if (QLog.isColorLevel()) {
          QLog.d("PIC_TAG", 2, "onError ");
        }
      }
      if (this.file == null) {
        break label174;
      }
    }
    finally {}
    logRichMediaEvent("notify", "start");
    label174:
    notifyAll();
    if (this.file != null) {
      logRichMediaEvent("notify", "end");
    }
    int i;
    if ((this.errCode == 9014) || (this.errCode == 9050))
    {
      Object localObject3 = RichMediaUtil.getIpAndPortFromUrl(((HttpNetReq)this.mNetReq).mReqUrl);
      if (localObject3 != null)
      {
        localObject3 = ((ServerAddr)localObject3).mIp;
        localObject4 = new ProbeChain();
        if (this.errCode != 9014) {
          break label374;
        }
        ((ProbeChain)localObject4).addProbeItem(new PingProbe());
        ((ProbeChain)localObject4).addProbeItem(new MtuProbe());
        ((ProbeChain)localObject4).addProbeItem(new TracerouteProbe());
        if (this.errCode != 9014) {
          break label401;
        }
        i = -1201;
        label308:
        localObject3 = new ProbeRequest((String)localObject3, i, (ProbeItem)localObject4);
        if (this.mWeakNetLearner != null) {
          this.mWeakNetLearner.startProbe(new ProbeTask((ProbeRequest)localObject3));
        }
      }
    }
    sendMessageToUpdate(2005);
    if (avsq.b(this.mUiRequest.mRec)) {
      avsq.a(String.valueOf(this.errCode), 3);
    }
    label374:
    while (!avsq.a(this.mUiRequest.mRec))
    {
      return;
      ((ProbeChain)localObject4).addProbeItem(new PingProbe());
      ((ProbeChain)localObject4).addProbeItem(new TracerouteProbe());
      break;
      i = -1202;
      break label308;
    }
    label401:
    avsq.a(String.valueOf(this.errCode), 2);
  }
  
  public void onFailed(NetResp paramNetResp)
  {
    RMServMonitorReport localRMServMonitorReport = this.mRSMReporter;
    long l = this.mRecvLen;
    if (this.mPicDownExtra == null) {}
    for (int i = 0;; i = this.mPicDownExtra.mStartDownOffset)
    {
      localRMServMonitorReport.mFileSize = (l - i);
      reportForServerMonitor(paramNetResp, false, "actRichMediaNetMonitor_picDown", this.mUiRequest.mServerPath);
      return;
    }
  }
  
  public void onResp(NetResp paramNetResp)
  {
    boolean bool2 = true;
    super.onResp(paramNetResp);
    Object localObject = new StringBuilder().append("directMsgUrlDown:").append(this.mDirectMsgUrlDown).append(" isEncrypt:");
    boolean bool1;
    if ((this.mEncryptPic) || (this.mEncryptUrl))
    {
      bool1 = true;
      localObject = ((StringBuilder)localObject).append(bool1).append(" isRollBack:").append(this.mPicEncryptRollback).append(" result:");
      if (paramNetResp.mResult != 0) {
        break label290;
      }
      bool1 = true;
      label87:
      logRichMediaEvent("onHttpResp", bool1);
      if ((QLog.isColorLevel()) && (this.mNetReq != null)) {
        QLog.d("big_thumb", 2, "onResp" + this.mUiRequest.mFileType + "mUiRequest.mOutFilePath=" + this.mUiRequest.mOutFilePath + "url=" + ((HttpNetReq)this.mNetReq).mReqUrl);
      }
      if (!this.mDirectMsgUrlDown) {
        break label295;
      }
      localObject = this.mStepDirectDown;
      label197:
      if (paramNetResp.mResult != 0) {
        break label304;
      }
      bool1 = bool2;
      label206:
      copyStatisInfoFromNetResp((BaseTransProcessor.StepInfo)localObject, paramNetResp, bool1);
      this.mTotolLen = paramNetResp.mTotalFileLen;
      if (this.mTotolLen <= 0L) {
        this.mTotolLen = (paramNetResp.mTotalBlockLen + paramNetResp.mReq.mStartDownOffset);
      }
      this.mRecvLen += paramNetResp.mWrittenBlockLen;
      if ((paramNetResp.mResult != 0) || (this.mNetReq == null)) {
        break label309;
      }
      handleRespSuc(paramNetResp);
    }
    for (;;)
    {
      this.mNetReq = null;
      return;
      bool1 = false;
      break;
      label290:
      bool1 = false;
      break label87;
      label295:
      localObject = this.mStepTrans;
      break label197;
      label304:
      bool1 = false;
      break label206;
      label309:
      handleRespErr(paramNetResp);
    }
  }
  
  void onSuccess()
  {
    super.onSuccess();
    if (QLog.isColorLevel()) {
      QLog.d("big_thumb", 2, "onsuccess mUiRequest.mFileType" + this.mUiRequest.mFileType + "mUiRequest.mOutFilePath=" + this.mUiRequest.mOutFilePath + "url=" + ((HttpNetReq)this.mNetReq).mReqUrl);
    }
    handleThumb();
    for (;;)
    {
      Object localObject3;
      aycy localaycy;
      boolean bool;
      try
      {
        if (this.file != null) {
          this.file.status = 2003;
        }
        Object localObject1 = this.mUiRequest;
        if (((TransferRequest)localObject1).mDisplayOutFilePath != null)
        {
          localObject3 = new File(((TransferRequest)localObject1).mDisplayOutFilePath);
          if ((((File)localObject3).exists()) && (((File)localObject3).delete()) && (QLog.isDevelopLevel())) {
            QLog.d("peak_pgjpeg", 4, "BasePicDownloadProcessor.onSuccess():Delete " + ((TransferRequest)localObject1).mDisplayOutFilePath);
          }
        }
        int i = getDownloadStatus(this.mUiRequest);
        localObject1 = this.mDownCallBacks.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label401;
        }
        localObject3 = (aycx)((Iterator)localObject1).next();
        localaycy = new aycy();
        localaycy.jdField_a_of_type_Int = 0;
        localaycy.jdField_b_of_type_JavaLangString = this.mUiRequest.mOutFilePath;
        localaycy.jdField_c_of_type_JavaLangString = this.mUiRequest.mMd5;
        localaycy.jdField_c_of_type_Int = this.mUiRequest.mFileType;
        localaycy.d = this.mUiRequest.mDownMode;
        if (i == 2) {
          break label490;
        }
        if (i != 3) {
          break label396;
        }
      }
      finally {}
      localaycy.jdField_a_of_type_Boolean = bool;
      ((aycx)localObject3).a(localaycy);
      if ((this.mUiRequest.mFileType == 131075) && (QLog.isDevelopLevel())) {
        QLog.d("peak_pgjpeg", 4, "BasePicDownloadProcessor.onSuccess():" + this.mUiRequest.mOutFilePath + ", isPart " + localaycy.jdField_a_of_type_Boolean);
      }
      if (QLog.isColorLevel())
      {
        QLog.d("PIC_TAG", 2, "onSuccess ");
        continue;
        label396:
        bool = false;
        continue;
        label401:
        if (this.file != null) {
          logRichMediaEvent("notify", "start");
        }
        notifyAll();
        if (this.file != null) {
          logRichMediaEvent("notify", "end");
        }
        sendMessageToUpdate(2003);
        if (avsq.b(this.mUiRequest.mRec)) {
          avsq.a("0", 3);
        }
        while (!avsq.a(this.mUiRequest.mRec)) {
          return;
        }
        avsq.a("0", 2);
        return;
        label490:
        bool = true;
      }
    }
  }
  
  /* Error */
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: ldc2_w 1127
    //   3: lload_2
    //   4: lmul
    //   5: lload 4
    //   7: ldiv
    //   8: l2i
    //   9: istore 6
    //   11: iload 6
    //   13: aload_0
    //   14: getfield 1131	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:mLastProgress	I
    //   17: if_icmple +33 -> 50
    //   20: aload_0
    //   21: iload 6
    //   23: putfield 1131	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:mLastProgress	I
    //   26: aload_0
    //   27: getfield 406	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:mPicDownExtra	Lcom/tencent/mobileqq/transfile/TransferRequest$PicDownExtraInfo;
    //   30: getfield 1135	com/tencent/mobileqq/transfile/TransferRequest$PicDownExtraInfo:mHandler	Lcom/tencent/image/URLDrawableHandler;
    //   33: ifnull +17 -> 50
    //   36: aload_0
    //   37: getfield 406	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:mPicDownExtra	Lcom/tencent/mobileqq/transfile/TransferRequest$PicDownExtraInfo;
    //   40: getfield 1135	com/tencent/mobileqq/transfile/TransferRequest$PicDownExtraInfo:mHandler	Lcom/tencent/image/URLDrawableHandler;
    //   43: iload 6
    //   45: invokeinterface 1140 2 0
    //   50: aload_0
    //   51: monitorenter
    //   52: aload_0
    //   53: getfield 970	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:file	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   56: ifnull +13 -> 69
    //   59: aload_0
    //   60: getfield 970	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:file	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   63: sipush 2002
    //   66: putfield 975	com/tencent/mobileqq/transfile/FileMsg:status	I
    //   69: iconst_0
    //   70: istore 10
    //   72: iconst_0
    //   73: istore 11
    //   75: iconst_0
    //   76: istore 9
    //   78: aload_0
    //   79: getfield 167	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   82: astore 13
    //   84: aload 13
    //   86: getfield 1143	com/tencent/mobileqq/transfile/TransferRequest:mRequestDisplayLength	I
    //   89: istore 7
    //   91: iload 9
    //   93: istore 8
    //   95: aload 13
    //   97: getfield 204	com/tencent/mobileqq/transfile/TransferRequest:mRequestOffset	I
    //   100: ifne +249 -> 349
    //   103: iload 9
    //   105: istore 8
    //   107: iload 7
    //   109: ifle +240 -> 349
    //   112: iload 9
    //   114: istore 8
    //   116: aload 13
    //   118: getfield 1102	com/tencent/mobileqq/transfile/TransferRequest:mDisplayOutFilePath	Ljava/lang/String;
    //   121: ifnull +228 -> 349
    //   124: new 246	java/io/File
    //   127: dup
    //   128: aload 13
    //   130: getfield 1102	com/tencent/mobileqq/transfile/TransferRequest:mDisplayOutFilePath	Ljava/lang/String;
    //   133: invokespecial 249	java/io/File:<init>	(Ljava/lang/String;)V
    //   136: astore 14
    //   138: new 246	java/io/File
    //   141: dup
    //   142: aload_1
    //   143: getfield 157	com/tencent/mobileqq/transfile/NetReq:mTempPath	Ljava/lang/String;
    //   146: invokespecial 249	java/io/File:<init>	(Ljava/lang/String;)V
    //   149: astore 16
    //   151: aload 16
    //   153: invokevirtual 265	java/io/File:length	()J
    //   156: lstore_2
    //   157: iload 9
    //   159: istore 8
    //   161: aload 14
    //   163: invokevirtual 252	java/io/File:exists	()Z
    //   166: ifne +183 -> 349
    //   169: iload 9
    //   171: istore 8
    //   173: lload_2
    //   174: lconst_0
    //   175: lcmp
    //   176: ifle +173 -> 349
    //   179: iload 9
    //   181: istore 8
    //   183: iload 7
    //   185: i2l
    //   186: lload_2
    //   187: lcmp
    //   188: ifge +161 -> 349
    //   191: new 246	java/io/File
    //   194: dup
    //   195: new 194	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   202: aload 13
    //   204: getfield 1102	com/tencent/mobileqq/transfile/TransferRequest:mDisplayOutFilePath	Ljava/lang/String;
    //   207: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: ldc_w 1145
    //   213: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokespecial 249	java/io/File:<init>	(Ljava/lang/String;)V
    //   222: astore 15
    //   224: aconst_null
    //   225: astore 12
    //   227: aconst_null
    //   228: astore_1
    //   229: aload 16
    //   231: aload 15
    //   233: iconst_0
    //   234: iload 7
    //   236: invokestatic 1149	com/tencent/mobileqq/utils/FileUtils:copyFileUsingFileChannels	(Ljava/io/File;Ljava/io/File;II)J
    //   239: lstore_2
    //   240: lload_2
    //   241: iload 7
    //   243: i2l
    //   244: lcmp
    //   245: ifeq +147 -> 392
    //   248: aload 15
    //   250: invokevirtual 252	java/io/File:exists	()Z
    //   253: ifeq +139 -> 392
    //   256: aload 15
    //   258: invokevirtual 255	java/io/File:delete	()Z
    //   261: pop
    //   262: iload 9
    //   264: istore 8
    //   266: aload_1
    //   267: ifnull +82 -> 349
    //   270: iload 10
    //   272: istore 9
    //   274: aload_1
    //   275: invokevirtual 295	java/io/RandomAccessFile:close	()V
    //   278: iload 10
    //   280: istore 9
    //   282: aload 15
    //   284: aload 14
    //   286: invokestatic 1153	com/tencent/mobileqq/utils/FileUtils:renameFile	(Ljava/io/File;Ljava/io/File;)Z
    //   289: pop
    //   290: iconst_1
    //   291: istore 11
    //   293: iconst_1
    //   294: istore 10
    //   296: iload 10
    //   298: istore 8
    //   300: iload 11
    //   302: istore 9
    //   304: invokestatic 258	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   307: ifeq +42 -> 349
    //   310: iload 11
    //   312: istore 9
    //   314: ldc_w 260
    //   317: iconst_4
    //   318: new 194	java/lang/StringBuilder
    //   321: dup
    //   322: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   325: ldc_w 1155
    //   328: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: aload 13
    //   333: getfield 1102	com/tencent/mobileqq/transfile/TransferRequest:mDisplayOutFilePath	Ljava/lang/String;
    //   336: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: invokestatic 274	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   345: iload 10
    //   347: istore 8
    //   349: aload_0
    //   350: getfield 978	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:mDownCallBacks	Ljava/util/ArrayList;
    //   353: invokevirtual 862	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   356: astore_1
    //   357: aload_1
    //   358: invokeinterface 867 1 0
    //   363: ifeq +255 -> 618
    //   366: aload_1
    //   367: invokeinterface 871 1 0
    //   372: checkcast 980	aycx
    //   375: iload 6
    //   377: iload 8
    //   379: invokeinterface 1158 3 0
    //   384: goto -27 -> 357
    //   387: astore_1
    //   388: aload_0
    //   389: monitorexit
    //   390: aload_1
    //   391: athrow
    //   392: new 276	java/io/RandomAccessFile
    //   395: dup
    //   396: aload 15
    //   398: ldc_w 278
    //   401: invokespecial 281	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   404: astore_1
    //   405: aload_1
    //   406: lload_2
    //   407: invokevirtual 286	java/io/RandomAccessFile:seek	(J)V
    //   410: aload_1
    //   411: iconst_2
    //   412: newarray byte
    //   414: dup
    //   415: iconst_0
    //   416: ldc_w 287
    //   419: bastore
    //   420: dup
    //   421: iconst_1
    //   422: ldc_w 288
    //   425: bastore
    //   426: invokevirtual 292	java/io/RandomAccessFile:write	([B)V
    //   429: goto -167 -> 262
    //   432: astore_1
    //   433: aload_1
    //   434: invokevirtual 305	java/io/IOException:printStackTrace	()V
    //   437: iload 9
    //   439: istore 8
    //   441: goto -92 -> 349
    //   444: astore_1
    //   445: aload 12
    //   447: astore_1
    //   448: iload 9
    //   450: istore 8
    //   452: aload_1
    //   453: ifnull -104 -> 349
    //   456: iload 11
    //   458: istore 9
    //   460: aload_1
    //   461: invokevirtual 295	java/io/RandomAccessFile:close	()V
    //   464: iload 11
    //   466: istore 9
    //   468: aload 15
    //   470: aload 14
    //   472: invokestatic 1153	com/tencent/mobileqq/utils/FileUtils:renameFile	(Ljava/io/File;Ljava/io/File;)Z
    //   475: pop
    //   476: iconst_1
    //   477: istore 11
    //   479: iconst_1
    //   480: istore 10
    //   482: iload 10
    //   484: istore 8
    //   486: iload 11
    //   488: istore 9
    //   490: invokestatic 258	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   493: ifeq -144 -> 349
    //   496: iload 11
    //   498: istore 9
    //   500: ldc_w 260
    //   503: iconst_4
    //   504: new 194	java/lang/StringBuilder
    //   507: dup
    //   508: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   511: ldc_w 1155
    //   514: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: aload 13
    //   519: getfield 1102	com/tencent/mobileqq/transfile/TransferRequest:mDisplayOutFilePath	Ljava/lang/String;
    //   522: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   525: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   528: invokestatic 274	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   531: iload 10
    //   533: istore 8
    //   535: goto -186 -> 349
    //   538: astore_1
    //   539: aload_1
    //   540: invokevirtual 305	java/io/IOException:printStackTrace	()V
    //   543: iload 9
    //   545: istore 8
    //   547: goto -198 -> 349
    //   550: astore 12
    //   552: aconst_null
    //   553: astore_1
    //   554: aload_1
    //   555: ifnull +52 -> 607
    //   558: aload_1
    //   559: invokevirtual 295	java/io/RandomAccessFile:close	()V
    //   562: aload 15
    //   564: aload 14
    //   566: invokestatic 1153	com/tencent/mobileqq/utils/FileUtils:renameFile	(Ljava/io/File;Ljava/io/File;)Z
    //   569: pop
    //   570: invokestatic 258	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   573: ifeq +34 -> 607
    //   576: ldc_w 260
    //   579: iconst_4
    //   580: new 194	java/lang/StringBuilder
    //   583: dup
    //   584: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   587: ldc_w 1155
    //   590: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: aload 13
    //   595: getfield 1102	com/tencent/mobileqq/transfile/TransferRequest:mDisplayOutFilePath	Ljava/lang/String;
    //   598: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   604: invokestatic 274	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   607: aload 12
    //   609: athrow
    //   610: astore_1
    //   611: aload_1
    //   612: invokevirtual 305	java/io/IOException:printStackTrace	()V
    //   615: goto -8 -> 607
    //   618: aload_0
    //   619: monitorexit
    //   620: return
    //   621: astore 12
    //   623: goto -69 -> 554
    //   626: astore 12
    //   628: goto -180 -> 448
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	631	0	this	BasePicDownloadProcessor
    //   0	631	1	paramNetReq	NetReq
    //   0	631	2	paramLong1	long
    //   0	631	4	paramLong2	long
    //   9	367	6	i	int
    //   89	153	7	j	int
    //   93	453	8	bool1	boolean
    //   76	468	9	bool2	boolean
    //   70	462	10	bool3	boolean
    //   73	424	11	bool4	boolean
    //   225	221	12	localObject1	Object
    //   550	58	12	localObject2	Object
    //   621	1	12	localObject3	Object
    //   626	1	12	localIOException	java.io.IOException
    //   82	512	13	localTransferRequest	TransferRequest
    //   136	429	14	localFile1	File
    //   222	341	15	localFile2	File
    //   149	81	16	localFile3	File
    // Exception table:
    //   from	to	target	type
    //   52	69	387	finally
    //   78	91	387	finally
    //   95	103	387	finally
    //   116	157	387	finally
    //   161	169	387	finally
    //   191	224	387	finally
    //   274	278	387	finally
    //   282	290	387	finally
    //   304	310	387	finally
    //   314	345	387	finally
    //   349	357	387	finally
    //   357	384	387	finally
    //   388	390	387	finally
    //   433	437	387	finally
    //   460	464	387	finally
    //   468	476	387	finally
    //   490	496	387	finally
    //   500	531	387	finally
    //   539	543	387	finally
    //   558	607	387	finally
    //   607	610	387	finally
    //   611	615	387	finally
    //   618	620	387	finally
    //   274	278	432	java/io/IOException
    //   282	290	432	java/io/IOException
    //   304	310	432	java/io/IOException
    //   314	345	432	java/io/IOException
    //   229	240	444	java/io/IOException
    //   248	262	444	java/io/IOException
    //   392	405	444	java/io/IOException
    //   460	464	538	java/io/IOException
    //   468	476	538	java/io/IOException
    //   490	496	538	java/io/IOException
    //   500	531	538	java/io/IOException
    //   229	240	550	finally
    //   248	262	550	finally
    //   392	405	550	finally
    //   558	607	610	java/io/IOException
    //   405	429	621	finally
    //   405	429	626	java/io/IOException
  }
  
  void receiveFile(boolean paramBoolean) {}
  
  void sendRequest() {}
  
  public void updateThumb(MessageForPic paramMessageForPic)
  {
    CompressInfo localCompressInfo;
    URL localURL;
    Object localObject;
    if (paramMessageForPic.fileSizeFlag == 1)
    {
      bool = true;
      if (this.mUiRequest.mFileType == URLDrawableHelper.getFileSizeType("chatimg", bool))
      {
        localCompressInfo = new CompressInfo(this.mUiRequest.mOutFilePath, 0);
        localURL = URLDrawableHelper.getURL(paramMessageForPic, 65537);
        localCompressInfo.f = true;
        localObject = AbsDownloader.getFilePath(localURL.toString());
        if (!((String)localObject).endsWith("_hd"))
        {
          if (!((String)localObject).endsWith("_big400")) {
            break label228;
          }
          ((String)localObject).replace("_big400", "_hd");
          label99:
          localCompressInfo.e = ((String)localObject);
          localCompressInfo.a = paramMessageForPic.thumbWidthHeightDP;
          ayeu.b(localCompressInfo);
          if (localCompressInfo.e != null)
          {
            localObject = new File((String)localObject);
            if (!localCompressInfo.e.equals(localCompressInfo.jdField_c_of_type_JavaLangString)) {
              break label257;
            }
          }
        }
      }
    }
    label257:
    for (boolean bool = fd.a(new File(localCompressInfo.jdField_c_of_type_JavaLangString), (File)localObject);; bool = true)
    {
      if ((bool) && (BaseApplicationImpl.sImageCache.get(localURL.toString()) != null))
      {
        BaseApplicationImpl.sImageCache.remove(localURL.toString());
        localObject = URLDrawable.getDrawable(localURL);
        if (localObject != null)
        {
          if (paramMessageForPic.thumbWidthHeightDP != null) {
            break label252;
          }
          ((URLDrawable)localObject).downloadImediatly(true);
        }
      }
      return;
      bool = false;
      break;
      label228:
      localObject = (String)localObject + "_hd";
      break label99;
      label252:
      ((URLDrawable)localObject).invalidateSelf();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BasePicDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */