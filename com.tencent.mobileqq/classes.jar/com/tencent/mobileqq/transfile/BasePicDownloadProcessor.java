package com.tencent.mobileqq.transfile;

import aiam;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.dataline.util.file.FileUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.FlashPicHelper;
import com.tencent.mobileqq.app.HotChatHelper;
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
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.DownCallBack.DownResult;
import com.tencent.mobileqq.pic.PicUiInterface;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.ptt.PttIpSaver;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.utils.DESUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.PicCryptor;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
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
  public static WeakNetLearner a;
  private static final Pattern a;
  protected TransferRequest.PicDownExtraInfo a;
  protected byte[] a;
  protected byte[] b;
  protected int c;
  private ArrayList c;
  protected boolean c;
  protected boolean d;
  protected boolean e;
  protected String f;
  protected boolean f;
  protected String g;
  protected boolean g;
  protected boolean h;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqHighwayNetprobeWeakNetLearner = new WeakNetLearner(BaseApplication.getContext(), new aiam());
    jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile(".*//[^/]*/[^/]*/(.*)/.*");
  }
  
  public BasePicDownloadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList = ((ProxyIpManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(3)).getProxyIp(3);
    f();
  }
  
  private boolean a(NetResp paramNetResp)
  {
    if (paramNetResp != null) {
      try
      {
        if (paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.jdField_c_of_type_JavaLangString != null)
        {
          BitmapFactory.Options localOptions = new BitmapFactory.Options();
          localOptions.inJustDecodeBounds = true;
          BitmapFactory.decodeFile(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.jdField_c_of_type_JavaLangString, localOptions);
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
  
  /* Error */
  private void c(NetResp paramNetResp)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 4
    //   9: aconst_null
    //   10: astore 6
    //   12: aconst_null
    //   13: astore_3
    //   14: iconst_2
    //   15: newarray byte
    //   17: astore 10
    //   19: aload 10
    //   21: dup
    //   22: iconst_0
    //   23: ldc 124
    //   25: bastore
    //   26: dup
    //   27: iconst_1
    //   28: ldc 125
    //   30: bastore
    //   31: pop
    //   32: aload_1
    //   33: getfield 93	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_ComTencentMobileqqTransfileNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   36: ifnull +74 -> 110
    //   39: aload_1
    //   40: getfield 93	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_ComTencentMobileqqTransfileNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   43: getfield 127	com/tencent/mobileqq/transfile/NetReq:d	Ljava/lang/String;
    //   46: ifnull +64 -> 110
    //   49: aload_1
    //   50: getfield 93	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_ComTencentMobileqqTransfileNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   53: getfield 127	com/tencent/mobileqq/transfile/NetReq:d	Ljava/lang/String;
    //   56: invokevirtual 133	java/lang/String:length	()I
    //   59: ifeq +51 -> 110
    //   62: aload_1
    //   63: getfield 93	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_ComTencentMobileqqTransfileNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   66: getfield 97	com/tencent/mobileqq/transfile/NetReq:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   69: ifnull +41 -> 110
    //   72: aload_1
    //   73: getfield 93	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_ComTencentMobileqqTransfileNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   76: getfield 97	com/tencent/mobileqq/transfile/NetReq:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   79: invokevirtual 133	java/lang/String:length	()I
    //   82: ifeq +28 -> 110
    //   85: aload_1
    //   86: getfield 93	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_ComTencentMobileqqTransfileNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   89: getfield 127	com/tencent/mobileqq/transfile/NetReq:d	Ljava/lang/String;
    //   92: astore 9
    //   94: aload_1
    //   95: getfield 93	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_ComTencentMobileqqTransfileNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   98: getfield 97	com/tencent/mobileqq/transfile/NetReq:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   101: astore 8
    //   103: aload_0
    //   104: getfield 136	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   107: ifnonnull +4 -> 111
    //   110: return
    //   111: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   114: ifeq +99 -> 213
    //   117: aload_0
    //   118: getfield 136	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   121: getfield 146	com/tencent/mobileqq/transfile/TransferRequest:jdField_a_of_type_Int	I
    //   124: aload_0
    //   125: getfield 136	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   128: getfield 148	com/tencent/mobileqq/transfile/TransferRequest:jdField_a_of_type_Boolean	Z
    //   131: aload_0
    //   132: getfield 136	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   135: getfield 150	com/tencent/mobileqq/transfile/TransferRequest:jdField_b_of_type_Int	I
    //   138: aload_0
    //   139: getfield 136	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   142: getfield 153	com/tencent/mobileqq/transfile/TransferRequest:jdField_a_of_type_Long	J
    //   145: invokestatic 157	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   148: ldc 159
    //   150: new 161	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   157: ldc 164
    //   159: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_0
    //   163: getfield 136	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   166: getfield 171	com/tencent/mobileqq/transfile/TransferRequest:i	I
    //   169: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   172: ldc 176
    //   174: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload_0
    //   178: getfield 136	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   181: getfield 179	com/tencent/mobileqq/transfile/TransferRequest:jdField_j_of_type_Int	I
    //   184: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   187: ldc 181
    //   189: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: aload 9
    //   194: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: ldc 183
    //   199: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload 8
    //   204: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokestatic 192	com/tencent/mobileqq/transfile/RichMediaUtil:a	(IZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   213: aload_0
    //   214: aload_0
    //   215: getfield 136	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   218: invokevirtual 195	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:a	(Lcom/tencent/mobileqq/transfile/TransferRequest;)I
    //   221: istore_2
    //   222: iload_2
    //   223: iconst_4
    //   224: if_icmpne +453 -> 677
    //   227: new 161	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   234: aload 8
    //   236: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: ldc 197
    //   241: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: astore 6
    //   249: aload 8
    //   251: aload 6
    //   253: invokestatic 202	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   256: pop
    //   257: new 204	java/io/File
    //   260: dup
    //   261: aload 6
    //   263: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   266: astore_1
    //   267: new 204	java/io/File
    //   270: dup
    //   271: aload 9
    //   273: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   276: astore 7
    //   278: invokestatic 210	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   281: ifeq +42 -> 323
    //   284: ldc 212
    //   286: iconst_4
    //   287: new 161	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   294: ldc 214
    //   296: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: aload 7
    //   301: invokevirtual 217	java/io/File:length	()J
    //   304: invokevirtual 220	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   307: ldc 222
    //   309: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: aload 8
    //   314: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: invokestatic 225	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   323: aload_1
    //   324: invokevirtual 228	java/io/File:exists	()Z
    //   327: ifeq -217 -> 110
    //   330: aload 7
    //   332: invokevirtual 228	java/io/File:exists	()Z
    //   335: ifeq -225 -> 110
    //   338: new 230	java/io/RandomAccessFile
    //   341: dup
    //   342: aload_1
    //   343: ldc 232
    //   345: invokespecial 235	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   348: astore_1
    //   349: aload_1
    //   350: aload_0
    //   351: getfield 136	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   354: getfield 171	com/tencent/mobileqq/transfile/TransferRequest:i	I
    //   357: i2l
    //   358: invokevirtual 239	java/io/RandomAccessFile:seek	(J)V
    //   361: new 241	java/io/FileInputStream
    //   364: dup
    //   365: aload 7
    //   367: invokespecial 244	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   370: astore 4
    //   372: sipush 1024
    //   375: newarray byte
    //   377: astore_3
    //   378: aload 4
    //   380: aload_3
    //   381: invokevirtual 248	java/io/FileInputStream:read	([B)I
    //   384: istore_2
    //   385: iload_2
    //   386: ifle +75 -> 461
    //   389: aload_1
    //   390: aload_3
    //   391: iconst_0
    //   392: iload_2
    //   393: invokevirtual 252	java/io/RandomAccessFile:write	([BII)V
    //   396: goto -18 -> 378
    //   399: astore_3
    //   400: aload_1
    //   401: astore_3
    //   402: aload 4
    //   404: astore_1
    //   405: aload_3
    //   406: ifnull +7 -> 413
    //   409: aload_3
    //   410: invokevirtual 255	java/io/RandomAccessFile:close	()V
    //   413: aload_1
    //   414: ifnull +7 -> 421
    //   417: aload_1
    //   418: invokevirtual 256	java/io/FileInputStream:close	()V
    //   421: aload 7
    //   423: invokevirtual 259	java/io/File:delete	()Z
    //   426: pop
    //   427: aload 6
    //   429: aload 8
    //   431: invokestatic 261	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   434: ifne -324 -> 110
    //   437: aload 6
    //   439: aload 8
    //   441: invokestatic 202	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   444: ifeq +121 -> 565
    //   447: new 204	java/io/File
    //   450: dup
    //   451: aload 6
    //   453: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   456: invokevirtual 259	java/io/File:delete	()Z
    //   459: pop
    //   460: return
    //   461: aload_1
    //   462: ifnull +7 -> 469
    //   465: aload_1
    //   466: invokevirtual 255	java/io/RandomAccessFile:close	()V
    //   469: aload 4
    //   471: ifnull +8 -> 479
    //   474: aload 4
    //   476: invokevirtual 256	java/io/FileInputStream:close	()V
    //   479: aload 7
    //   481: invokevirtual 259	java/io/File:delete	()Z
    //   484: pop
    //   485: aload 6
    //   487: aload 8
    //   489: invokestatic 261	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   492: ifne -382 -> 110
    //   495: aload 6
    //   497: aload 8
    //   499: invokestatic 202	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   502: ifeq +33 -> 535
    //   505: new 204	java/io/File
    //   508: dup
    //   509: aload 6
    //   511: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   514: invokevirtual 259	java/io/File:delete	()Z
    //   517: pop
    //   518: return
    //   519: astore_1
    //   520: aload_1
    //   521: invokevirtual 262	java/io/IOException:printStackTrace	()V
    //   524: goto -55 -> 469
    //   527: astore_1
    //   528: aload_1
    //   529: invokevirtual 262	java/io/IOException:printStackTrace	()V
    //   532: goto -53 -> 479
    //   535: new 204	java/io/File
    //   538: dup
    //   539: aload 6
    //   541: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   544: invokevirtual 259	java/io/File:delete	()Z
    //   547: pop
    //   548: return
    //   549: astore_3
    //   550: aload_3
    //   551: invokevirtual 262	java/io/IOException:printStackTrace	()V
    //   554: goto -141 -> 413
    //   557: astore_1
    //   558: aload_1
    //   559: invokevirtual 262	java/io/IOException:printStackTrace	()V
    //   562: goto -141 -> 421
    //   565: new 204	java/io/File
    //   568: dup
    //   569: aload 6
    //   571: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   574: invokevirtual 259	java/io/File:delete	()Z
    //   577: pop
    //   578: return
    //   579: astore_3
    //   580: aconst_null
    //   581: astore_1
    //   582: aload 5
    //   584: astore 4
    //   586: aload_1
    //   587: ifnull +7 -> 594
    //   590: aload_1
    //   591: invokevirtual 255	java/io/RandomAccessFile:close	()V
    //   594: aload 4
    //   596: ifnull +8 -> 604
    //   599: aload 4
    //   601: invokevirtual 256	java/io/FileInputStream:close	()V
    //   604: aload 7
    //   606: invokevirtual 259	java/io/File:delete	()Z
    //   609: pop
    //   610: aload 6
    //   612: aload 8
    //   614: invokestatic 261	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   617: ifne +26 -> 643
    //   620: aload 6
    //   622: aload 8
    //   624: invokestatic 202	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   627: ifeq +34 -> 661
    //   630: new 204	java/io/File
    //   633: dup
    //   634: aload 6
    //   636: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   639: invokevirtual 259	java/io/File:delete	()Z
    //   642: pop
    //   643: aload_3
    //   644: athrow
    //   645: astore_1
    //   646: aload_1
    //   647: invokevirtual 262	java/io/IOException:printStackTrace	()V
    //   650: goto -56 -> 594
    //   653: astore_1
    //   654: aload_1
    //   655: invokevirtual 262	java/io/IOException:printStackTrace	()V
    //   658: goto -54 -> 604
    //   661: new 204	java/io/File
    //   664: dup
    //   665: aload 6
    //   667: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   670: invokevirtual 259	java/io/File:delete	()Z
    //   673: pop
    //   674: goto -31 -> 643
    //   677: iload_2
    //   678: iconst_2
    //   679: if_icmpne +231 -> 910
    //   682: new 204	java/io/File
    //   685: dup
    //   686: aload 9
    //   688: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   691: astore_1
    //   692: new 204	java/io/File
    //   695: dup
    //   696: aload 8
    //   698: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   701: astore_3
    //   702: aload_3
    //   703: invokevirtual 228	java/io/File:exists	()Z
    //   706: ifeq +8 -> 714
    //   709: aload_3
    //   710: invokevirtual 259	java/io/File:delete	()Z
    //   713: pop
    //   714: invokestatic 210	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   717: ifeq +42 -> 759
    //   720: ldc 212
    //   722: iconst_4
    //   723: new 161	java/lang/StringBuilder
    //   726: dup
    //   727: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   730: ldc_w 264
    //   733: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   736: aload_1
    //   737: invokevirtual 217	java/io/File:length	()J
    //   740: invokevirtual 220	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   743: ldc 222
    //   745: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: aload 8
    //   750: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   753: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   756: invokestatic 225	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   759: aload_1
    //   760: invokevirtual 228	java/io/File:exists	()Z
    //   763: ifeq -653 -> 110
    //   766: new 230	java/io/RandomAccessFile
    //   769: dup
    //   770: aload_1
    //   771: ldc 232
    //   773: invokespecial 235	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   776: astore_3
    //   777: aload_3
    //   778: aload_3
    //   779: invokevirtual 265	java/io/RandomAccessFile:length	()J
    //   782: invokevirtual 239	java/io/RandomAccessFile:seek	(J)V
    //   785: aload_3
    //   786: aload 10
    //   788: invokevirtual 268	java/io/RandomAccessFile:write	([B)V
    //   791: aload_3
    //   792: ifnull +7 -> 799
    //   795: aload_3
    //   796: invokevirtual 255	java/io/RandomAccessFile:close	()V
    //   799: aload 9
    //   801: aload 8
    //   803: invokestatic 261	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   806: ifne -696 -> 110
    //   809: aload 9
    //   811: aload 8
    //   813: invokestatic 202	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   816: ifeq +17 -> 833
    //   819: new 204	java/io/File
    //   822: dup
    //   823: aload 9
    //   825: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   828: invokevirtual 259	java/io/File:delete	()Z
    //   831: pop
    //   832: return
    //   833: new 204	java/io/File
    //   836: dup
    //   837: aload 9
    //   839: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   842: invokevirtual 259	java/io/File:delete	()Z
    //   845: pop
    //   846: return
    //   847: astore_1
    //   848: aload 7
    //   850: astore_3
    //   851: aload_3
    //   852: ifnull +7 -> 859
    //   855: aload_3
    //   856: invokevirtual 255	java/io/RandomAccessFile:close	()V
    //   859: aload 9
    //   861: aload 8
    //   863: invokestatic 261	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   866: ifne +26 -> 892
    //   869: aload 9
    //   871: aload 8
    //   873: invokestatic 202	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   876: ifeq +18 -> 894
    //   879: new 204	java/io/File
    //   882: dup
    //   883: aload 9
    //   885: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   888: invokevirtual 259	java/io/File:delete	()Z
    //   891: pop
    //   892: aload_1
    //   893: athrow
    //   894: new 204	java/io/File
    //   897: dup
    //   898: aload 9
    //   900: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   903: invokevirtual 259	java/io/File:delete	()Z
    //   906: pop
    //   907: goto -15 -> 892
    //   910: iload_2
    //   911: iconst_3
    //   912: if_icmpne -802 -> 110
    //   915: new 161	java/lang/StringBuilder
    //   918: dup
    //   919: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   922: aload 8
    //   924: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   927: ldc 197
    //   929: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   932: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   935: astore 7
    //   937: aload 8
    //   939: aload 7
    //   941: invokestatic 202	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   944: pop
    //   945: new 204	java/io/File
    //   948: dup
    //   949: aload 7
    //   951: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   954: astore_1
    //   955: new 204	java/io/File
    //   958: dup
    //   959: aload 9
    //   961: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   964: astore 9
    //   966: invokestatic 210	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   969: ifeq +43 -> 1012
    //   972: ldc 212
    //   974: iconst_4
    //   975: new 161	java/lang/StringBuilder
    //   978: dup
    //   979: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   982: ldc_w 270
    //   985: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   988: aload 9
    //   990: invokevirtual 217	java/io/File:length	()J
    //   993: invokevirtual 220	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   996: ldc 222
    //   998: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1001: aload 8
    //   1003: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1006: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1009: invokestatic 225	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1012: aload_1
    //   1013: invokevirtual 228	java/io/File:exists	()Z
    //   1016: ifeq -906 -> 110
    //   1019: aload 9
    //   1021: invokevirtual 228	java/io/File:exists	()Z
    //   1024: ifeq -914 -> 110
    //   1027: new 230	java/io/RandomAccessFile
    //   1030: dup
    //   1031: aload_1
    //   1032: ldc 232
    //   1034: invokespecial 235	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   1037: astore_1
    //   1038: aload_1
    //   1039: aload_0
    //   1040: getfield 136	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   1043: getfield 171	com/tencent/mobileqq/transfile/TransferRequest:i	I
    //   1046: i2l
    //   1047: invokevirtual 239	java/io/RandomAccessFile:seek	(J)V
    //   1050: new 241	java/io/FileInputStream
    //   1053: dup
    //   1054: aload 9
    //   1056: invokespecial 244	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   1059: astore_3
    //   1060: sipush 1024
    //   1063: newarray byte
    //   1065: astore 4
    //   1067: aload_3
    //   1068: aload 4
    //   1070: invokevirtual 248	java/io/FileInputStream:read	([B)I
    //   1073: istore_2
    //   1074: iload_2
    //   1075: ifle +72 -> 1147
    //   1078: aload_1
    //   1079: aload 4
    //   1081: iconst_0
    //   1082: iload_2
    //   1083: invokevirtual 252	java/io/RandomAccessFile:write	([BII)V
    //   1086: goto -19 -> 1067
    //   1089: astore 4
    //   1091: aload_1
    //   1092: ifnull +7 -> 1099
    //   1095: aload_1
    //   1096: invokevirtual 255	java/io/RandomAccessFile:close	()V
    //   1099: aload_3
    //   1100: ifnull +7 -> 1107
    //   1103: aload_3
    //   1104: invokevirtual 256	java/io/FileInputStream:close	()V
    //   1107: aload 9
    //   1109: invokevirtual 259	java/io/File:delete	()Z
    //   1112: pop
    //   1113: aload 7
    //   1115: aload 8
    //   1117: invokestatic 261	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1120: ifne -1010 -> 110
    //   1123: aload 7
    //   1125: aload 8
    //   1127: invokestatic 202	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1130: ifeq +93 -> 1223
    //   1133: new 204	java/io/File
    //   1136: dup
    //   1137: aload 7
    //   1139: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   1142: invokevirtual 259	java/io/File:delete	()Z
    //   1145: pop
    //   1146: return
    //   1147: aload_1
    //   1148: aload 10
    //   1150: invokevirtual 268	java/io/RandomAccessFile:write	([B)V
    //   1153: aload_1
    //   1154: ifnull +7 -> 1161
    //   1157: aload_1
    //   1158: invokevirtual 255	java/io/RandomAccessFile:close	()V
    //   1161: aload_3
    //   1162: ifnull +7 -> 1169
    //   1165: aload_3
    //   1166: invokevirtual 256	java/io/FileInputStream:close	()V
    //   1169: aload 9
    //   1171: invokevirtual 259	java/io/File:delete	()Z
    //   1174: pop
    //   1175: aload 7
    //   1177: aload 8
    //   1179: invokestatic 261	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1182: ifne -1072 -> 110
    //   1185: aload 7
    //   1187: aload 8
    //   1189: invokestatic 202	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1192: ifeq +17 -> 1209
    //   1195: new 204	java/io/File
    //   1198: dup
    //   1199: aload 7
    //   1201: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   1204: invokevirtual 259	java/io/File:delete	()Z
    //   1207: pop
    //   1208: return
    //   1209: new 204	java/io/File
    //   1212: dup
    //   1213: aload 7
    //   1215: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   1218: invokevirtual 259	java/io/File:delete	()Z
    //   1221: pop
    //   1222: return
    //   1223: new 204	java/io/File
    //   1226: dup
    //   1227: aload 7
    //   1229: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   1232: invokevirtual 259	java/io/File:delete	()Z
    //   1235: pop
    //   1236: return
    //   1237: astore_3
    //   1238: aconst_null
    //   1239: astore_1
    //   1240: aload 6
    //   1242: astore 4
    //   1244: aload_1
    //   1245: ifnull +7 -> 1252
    //   1248: aload_1
    //   1249: invokevirtual 255	java/io/RandomAccessFile:close	()V
    //   1252: aload 4
    //   1254: ifnull +8 -> 1262
    //   1257: aload 4
    //   1259: invokevirtual 256	java/io/FileInputStream:close	()V
    //   1262: aload 9
    //   1264: invokevirtual 259	java/io/File:delete	()Z
    //   1267: pop
    //   1268: aload 7
    //   1270: aload 8
    //   1272: invokestatic 261	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1275: ifne +26 -> 1301
    //   1278: aload 7
    //   1280: aload 8
    //   1282: invokestatic 202	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1285: ifeq +18 -> 1303
    //   1288: new 204	java/io/File
    //   1291: dup
    //   1292: aload 7
    //   1294: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   1297: invokevirtual 259	java/io/File:delete	()Z
    //   1300: pop
    //   1301: aload_3
    //   1302: athrow
    //   1303: new 204	java/io/File
    //   1306: dup
    //   1307: aload 7
    //   1309: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   1312: invokevirtual 259	java/io/File:delete	()Z
    //   1315: pop
    //   1316: goto -15 -> 1301
    //   1319: astore_3
    //   1320: aload 6
    //   1322: astore 4
    //   1324: goto -80 -> 1244
    //   1327: astore 5
    //   1329: aload_3
    //   1330: astore 4
    //   1332: aload 5
    //   1334: astore_3
    //   1335: goto -91 -> 1244
    //   1338: astore_1
    //   1339: aconst_null
    //   1340: astore_1
    //   1341: aload 4
    //   1343: astore_3
    //   1344: goto -253 -> 1091
    //   1347: astore_3
    //   1348: aload 4
    //   1350: astore_3
    //   1351: goto -260 -> 1091
    //   1354: astore_1
    //   1355: goto -504 -> 851
    //   1358: astore_3
    //   1359: aload 5
    //   1361: astore 4
    //   1363: goto -777 -> 586
    //   1366: astore_3
    //   1367: goto -781 -> 586
    //   1370: astore_1
    //   1371: aconst_null
    //   1372: astore_1
    //   1373: goto -968 -> 405
    //   1376: astore_3
    //   1377: aconst_null
    //   1378: astore 4
    //   1380: aload_1
    //   1381: astore_3
    //   1382: aload 4
    //   1384: astore_1
    //   1385: goto -980 -> 405
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1388	0	this	BasePicDownloadProcessor
    //   0	1388	1	paramNetResp	NetResp
    //   221	862	2	i	int
    //   13	378	3	arrayOfByte1	byte[]
    //   399	1	3	localThrowable1	Throwable
    //   401	9	3	localNetResp1	NetResp
    //   549	2	3	localIOException	IOException
    //   579	65	3	localObject1	Object
    //   701	465	3	localObject2	Object
    //   1237	65	3	localObject3	Object
    //   1319	11	3	localObject4	Object
    //   1334	10	3	localObject5	Object
    //   1347	1	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   1350	1	3	localObject6	Object
    //   1358	1	3	localObject7	Object
    //   1366	1	3	localObject8	Object
    //   1376	1	3	localThrowable2	Throwable
    //   1381	1	3	localNetResp2	NetResp
    //   7	1073	4	localObject9	Object
    //   1089	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   1242	141	4	localObject10	Object
    //   1	582	5	localObject11	Object
    //   1327	33	5	localObject12	Object
    //   10	1311	6	str1	String
    //   4	1304	7	localObject13	Object
    //   101	1180	8	str2	String
    //   92	1171	9	localObject14	Object
    //   17	1132	10	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   372	378	399	java/lang/Throwable
    //   378	385	399	java/lang/Throwable
    //   389	396	399	java/lang/Throwable
    //   465	469	519	java/io/IOException
    //   474	479	527	java/io/IOException
    //   409	413	549	java/io/IOException
    //   417	421	557	java/io/IOException
    //   338	349	579	finally
    //   590	594	645	java/io/IOException
    //   599	604	653	java/io/IOException
    //   766	777	847	finally
    //   1060	1067	1089	java/io/FileNotFoundException
    //   1067	1074	1089	java/io/FileNotFoundException
    //   1078	1086	1089	java/io/FileNotFoundException
    //   1147	1153	1089	java/io/FileNotFoundException
    //   1027	1038	1237	finally
    //   1038	1060	1319	finally
    //   1060	1067	1327	finally
    //   1067	1074	1327	finally
    //   1078	1086	1327	finally
    //   1147	1153	1327	finally
    //   1027	1038	1338	java/io/FileNotFoundException
    //   1038	1060	1347	java/io/FileNotFoundException
    //   777	791	1354	finally
    //   349	372	1358	finally
    //   372	378	1366	finally
    //   378	385	1366	finally
    //   389	396	1366	finally
    //   338	349	1370	java/lang/Throwable
    //   349	372	1376	java/lang/Throwable
  }
  
  int a(TransferRequest paramTransferRequest)
  {
    if (paramTransferRequest.i < 0) {}
    do
    {
      return 1;
      if (paramTransferRequest.i > 0)
      {
        if (paramTransferRequest.jdField_j_of_type_Int > 0) {
          return 3;
        }
        return 4;
      }
    } while (paramTransferRequest.jdField_j_of_type_Int <= 0);
    return 2;
  }
  
  public String a(String paramString)
  {
    String str2 = b(paramString);
    Cryptor localCryptor = new Cryptor();
    if (str2 != null)
    {
      String str1 = str2 + "&encrypt=";
      if (this.e) {}
      for (str1 = str1 + "1";; str1 = str1 + "0") {
        return paramString.replace(str2, PkgTools.a(localCryptor.encrypt(str1.getBytes(), this.jdField_b_of_type_ArrayOfByte)));
      }
    }
    this.e = false;
    return paramString;
  }
  
  protected String a(String paramString, int paramInt)
  {
    String str = "&rf=other";
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.g == 0)
    {
      str = "&rf=aio";
      str = "cldver=7.6.0.3525" + str;
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
      return paramString + "&msgTime=" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.d;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.g != 1) {
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
  
  public void a(HttpNetReq paramHttpNetReq, String paramString)
  {
    if (this.jdField_f_of_type_Boolean)
    {
      paramHttpNetReq.jdField_a_of_type_JavaLangString = a(paramString);
      if (!paramString.equals(paramHttpNetReq.jdField_a_of_type_JavaLangString))
      {
        paramHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Cookie", "ST=" + PkgTools.a(this.jdField_a_of_type_ArrayOfByte));
        if (this.e)
        {
          PicCryptor localPicCryptor = new PicCryptor(this.jdField_b_of_type_ArrayOfByte);
          localPicCryptor.a = paramHttpNetReq;
          paramHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq$IFlowDecoder = localPicCryptor;
          paramHttpNetReq.d = (paramHttpNetReq.jdField_c_of_type_JavaLangString + "." + MD5.toMD5(RichMediaUtil.a(paramString, false)) + ".tmp");
        }
      }
    }
    for (;;)
    {
      if ((this.jdField_g_of_type_Boolean) && (!this.e))
      {
        paramHttpNetReq.d = (paramHttpNetReq.jdField_c_of_type_JavaLangString + "." + MD5.toMD5(RichMediaUtil.a(paramString, false)) + ".tmp");
        paramHttpNetReq.jdField_a_of_type_JavaLangString = (paramString + "&rollback=1");
      }
      return;
      this.e = false;
    }
  }
  
  /* Error */
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: ldc2_w 396
    //   3: lload_2
    //   4: lmul
    //   5: lload 4
    //   7: ldiv
    //   8: l2i
    //   9: istore 6
    //   11: iload 6
    //   13: aload_0
    //   14: getfield 398	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:jdField_b_of_type_Int	I
    //   17: if_icmple +33 -> 50
    //   20: aload_0
    //   21: iload 6
    //   23: putfield 398	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:jdField_b_of_type_Int	I
    //   26: aload_0
    //   27: getfield 400	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$PicDownExtraInfo	Lcom/tencent/mobileqq/transfile/TransferRequest$PicDownExtraInfo;
    //   30: getfield 405	com/tencent/mobileqq/transfile/TransferRequest$PicDownExtraInfo:a	Lcom/tencent/image/URLDrawableHandler;
    //   33: ifnull +17 -> 50
    //   36: aload_0
    //   37: getfield 400	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$PicDownExtraInfo	Lcom/tencent/mobileqq/transfile/TransferRequest$PicDownExtraInfo;
    //   40: getfield 405	com/tencent/mobileqq/transfile/TransferRequest$PicDownExtraInfo:a	Lcom/tencent/image/URLDrawableHandler;
    //   43: iload 6
    //   45: invokeinterface 411 2 0
    //   50: aload_0
    //   51: monitorenter
    //   52: aload_0
    //   53: getfield 414	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   56: ifnull +13 -> 69
    //   59: aload_0
    //   60: getfield 414	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   63: sipush 2002
    //   66: putfield 418	com/tencent/mobileqq/transfile/FileMsg:d	I
    //   69: iconst_0
    //   70: istore 10
    //   72: iconst_0
    //   73: istore 11
    //   75: iconst_0
    //   76: istore 9
    //   78: aload_0
    //   79: getfield 136	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   82: astore 13
    //   84: aload 13
    //   86: getfield 421	com/tencent/mobileqq/transfile/TransferRequest:k	I
    //   89: istore 7
    //   91: iload 9
    //   93: istore 8
    //   95: aload 13
    //   97: getfield 171	com/tencent/mobileqq/transfile/TransferRequest:i	I
    //   100: ifne +248 -> 348
    //   103: iload 9
    //   105: istore 8
    //   107: iload 7
    //   109: ifle +239 -> 348
    //   112: iload 9
    //   114: istore 8
    //   116: aload 13
    //   118: getfield 424	com/tencent/mobileqq/transfile/TransferRequest:m	Ljava/lang/String;
    //   121: ifnull +227 -> 348
    //   124: new 204	java/io/File
    //   127: dup
    //   128: aload 13
    //   130: getfield 424	com/tencent/mobileqq/transfile/TransferRequest:m	Ljava/lang/String;
    //   133: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   136: astore 14
    //   138: new 204	java/io/File
    //   141: dup
    //   142: aload_1
    //   143: getfield 127	com/tencent/mobileqq/transfile/NetReq:d	Ljava/lang/String;
    //   146: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   149: astore 16
    //   151: aload 16
    //   153: invokevirtual 217	java/io/File:length	()J
    //   156: lstore_2
    //   157: iload 9
    //   159: istore 8
    //   161: aload 14
    //   163: invokevirtual 228	java/io/File:exists	()Z
    //   166: ifne +182 -> 348
    //   169: iload 9
    //   171: istore 8
    //   173: lload_2
    //   174: lconst_0
    //   175: lcmp
    //   176: ifle +172 -> 348
    //   179: iload 9
    //   181: istore 8
    //   183: iload 7
    //   185: i2l
    //   186: lload_2
    //   187: lcmp
    //   188: ifge +160 -> 348
    //   191: new 204	java/io/File
    //   194: dup
    //   195: new 161	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   202: aload 13
    //   204: getfield 424	com/tencent/mobileqq/transfile/TransferRequest:m	Ljava/lang/String;
    //   207: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: ldc_w 426
    //   213: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   222: astore 15
    //   224: aconst_null
    //   225: astore 12
    //   227: aconst_null
    //   228: astore_1
    //   229: aload 16
    //   231: aload 15
    //   233: iconst_0
    //   234: iload 7
    //   236: invokestatic 429	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;Ljava/io/File;II)J
    //   239: lstore_2
    //   240: lload_2
    //   241: iload 7
    //   243: i2l
    //   244: lcmp
    //   245: ifeq +146 -> 391
    //   248: aload 15
    //   250: invokevirtual 228	java/io/File:exists	()Z
    //   253: ifeq +138 -> 391
    //   256: aload 15
    //   258: invokevirtual 259	java/io/File:delete	()Z
    //   261: pop
    //   262: iload 9
    //   264: istore 8
    //   266: aload_1
    //   267: ifnull +81 -> 348
    //   270: iload 10
    //   272: istore 9
    //   274: aload_1
    //   275: invokevirtual 255	java/io/RandomAccessFile:close	()V
    //   278: iload 10
    //   280: istore 9
    //   282: aload 15
    //   284: aload 14
    //   286: invokestatic 432	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/io/File;Ljava/io/File;)Z
    //   289: pop
    //   290: iconst_1
    //   291: istore 11
    //   293: iconst_1
    //   294: istore 10
    //   296: iload 10
    //   298: istore 8
    //   300: iload 11
    //   302: istore 9
    //   304: invokestatic 210	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   307: ifeq +41 -> 348
    //   310: iload 11
    //   312: istore 9
    //   314: ldc 212
    //   316: iconst_4
    //   317: new 161	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   324: ldc_w 434
    //   327: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: aload 13
    //   332: getfield 424	com/tencent/mobileqq/transfile/TransferRequest:m	Ljava/lang/String;
    //   335: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: invokestatic 225	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   344: iload 10
    //   346: istore 8
    //   348: aload_0
    //   349: getfield 436	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   352: invokevirtual 440	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   355: astore_1
    //   356: aload_1
    //   357: invokeinterface 445 1 0
    //   362: ifeq +250 -> 612
    //   365: aload_1
    //   366: invokeinterface 449 1 0
    //   371: checkcast 451	com/tencent/mobileqq/pic/DownCallBack
    //   374: iload 6
    //   376: iload 8
    //   378: invokeinterface 454 3 0
    //   383: goto -27 -> 356
    //   386: astore_1
    //   387: aload_0
    //   388: monitorexit
    //   389: aload_1
    //   390: athrow
    //   391: new 230	java/io/RandomAccessFile
    //   394: dup
    //   395: aload 15
    //   397: ldc 232
    //   399: invokespecial 235	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   402: astore_1
    //   403: aload_1
    //   404: lload_2
    //   405: invokevirtual 239	java/io/RandomAccessFile:seek	(J)V
    //   408: aload_1
    //   409: iconst_2
    //   410: newarray byte
    //   412: dup
    //   413: iconst_0
    //   414: ldc 124
    //   416: bastore
    //   417: dup
    //   418: iconst_1
    //   419: ldc 125
    //   421: bastore
    //   422: invokevirtual 268	java/io/RandomAccessFile:write	([B)V
    //   425: goto -163 -> 262
    //   428: astore_1
    //   429: aload_1
    //   430: invokevirtual 262	java/io/IOException:printStackTrace	()V
    //   433: iload 9
    //   435: istore 8
    //   437: goto -89 -> 348
    //   440: astore_1
    //   441: aload 12
    //   443: astore_1
    //   444: iload 9
    //   446: istore 8
    //   448: aload_1
    //   449: ifnull -101 -> 348
    //   452: iload 11
    //   454: istore 9
    //   456: aload_1
    //   457: invokevirtual 255	java/io/RandomAccessFile:close	()V
    //   460: iload 11
    //   462: istore 9
    //   464: aload 15
    //   466: aload 14
    //   468: invokestatic 432	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/io/File;Ljava/io/File;)Z
    //   471: pop
    //   472: iconst_1
    //   473: istore 11
    //   475: iconst_1
    //   476: istore 10
    //   478: iload 10
    //   480: istore 8
    //   482: iload 11
    //   484: istore 9
    //   486: invokestatic 210	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   489: ifeq -141 -> 348
    //   492: iload 11
    //   494: istore 9
    //   496: ldc 212
    //   498: iconst_4
    //   499: new 161	java/lang/StringBuilder
    //   502: dup
    //   503: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   506: ldc_w 434
    //   509: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: aload 13
    //   514: getfield 424	com/tencent/mobileqq/transfile/TransferRequest:m	Ljava/lang/String;
    //   517: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   523: invokestatic 225	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   526: iload 10
    //   528: istore 8
    //   530: goto -182 -> 348
    //   533: astore_1
    //   534: aload_1
    //   535: invokevirtual 262	java/io/IOException:printStackTrace	()V
    //   538: iload 9
    //   540: istore 8
    //   542: goto -194 -> 348
    //   545: astore 12
    //   547: aconst_null
    //   548: astore_1
    //   549: aload_1
    //   550: ifnull +51 -> 601
    //   553: aload_1
    //   554: invokevirtual 255	java/io/RandomAccessFile:close	()V
    //   557: aload 15
    //   559: aload 14
    //   561: invokestatic 432	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/io/File;Ljava/io/File;)Z
    //   564: pop
    //   565: invokestatic 210	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   568: ifeq +33 -> 601
    //   571: ldc 212
    //   573: iconst_4
    //   574: new 161	java/lang/StringBuilder
    //   577: dup
    //   578: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   581: ldc_w 434
    //   584: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: aload 13
    //   589: getfield 424	com/tencent/mobileqq/transfile/TransferRequest:m	Ljava/lang/String;
    //   592: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   598: invokestatic 225	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   601: aload 12
    //   603: athrow
    //   604: astore_1
    //   605: aload_1
    //   606: invokevirtual 262	java/io/IOException:printStackTrace	()V
    //   609: goto -8 -> 601
    //   612: aload_0
    //   613: monitorexit
    //   614: return
    //   615: astore 12
    //   617: goto -68 -> 549
    //   620: astore 12
    //   622: goto -178 -> 444
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	625	0	this	BasePicDownloadProcessor
    //   0	625	1	paramNetReq	NetReq
    //   0	625	2	paramLong1	long
    //   0	625	4	paramLong2	long
    //   9	366	6	i	int
    //   89	153	7	j	int
    //   93	448	8	bool1	boolean
    //   76	463	9	bool2	boolean
    //   70	457	10	bool3	boolean
    //   73	420	11	bool4	boolean
    //   225	217	12	localObject1	Object
    //   545	57	12	localObject2	Object
    //   615	1	12	localObject3	Object
    //   620	1	12	localIOException	IOException
    //   82	506	13	localTransferRequest	TransferRequest
    //   136	424	14	localFile1	File
    //   222	336	15	localFile2	File
    //   149	81	16	localFile3	File
    // Exception table:
    //   from	to	target	type
    //   52	69	386	finally
    //   78	91	386	finally
    //   95	103	386	finally
    //   116	157	386	finally
    //   161	169	386	finally
    //   191	224	386	finally
    //   274	278	386	finally
    //   282	290	386	finally
    //   304	310	386	finally
    //   314	344	386	finally
    //   348	356	386	finally
    //   356	383	386	finally
    //   387	389	386	finally
    //   429	433	386	finally
    //   456	460	386	finally
    //   464	472	386	finally
    //   486	492	386	finally
    //   496	526	386	finally
    //   534	538	386	finally
    //   553	601	386	finally
    //   601	604	386	finally
    //   605	609	386	finally
    //   612	614	386	finally
    //   274	278	428	java/io/IOException
    //   282	290	428	java/io/IOException
    //   304	310	428	java/io/IOException
    //   314	344	428	java/io/IOException
    //   229	240	440	java/io/IOException
    //   248	262	440	java/io/IOException
    //   391	403	440	java/io/IOException
    //   456	460	533	java/io/IOException
    //   464	472	533	java/io/IOException
    //   486	492	533	java/io/IOException
    //   496	526	533	java/io/IOException
    //   229	240	545	finally
    //   248	262	545	finally
    //   391	403	545	finally
    //   553	601	604	java/io/IOException
    //   403	425	615	finally
    //   403	425	620	java/io/IOException
  }
  
  public void a(NetResp paramNetResp)
  {
    boolean bool2 = false;
    super.a(paramNetResp);
    Object localObject1 = new StringBuilder().append("directMsgUrlDown:").append(this.jdField_a_of_type_Boolean).append(" isEncrypt:");
    boolean bool1;
    if ((this.e) || (this.jdField_f_of_type_Boolean)) {
      bool1 = true;
    }
    for (;;)
    {
      localObject1 = ((StringBuilder)localObject1).append(bool1).append(" isRollBack:").append(this.jdField_g_of_type_Boolean).append(" result:");
      if (paramNetResp.jdField_a_of_type_Int == 0)
      {
        bool1 = true;
        label87:
        b("onHttpResp", bool1);
        if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq != null)) {
          QLog.d("big_thumb", 2, "onResp" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int + "mUiRequest.mOutFilePath=" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h + "url=" + ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString);
        }
        if (!this.jdField_a_of_type_Boolean) {
          break label429;
        }
        localObject1 = this.d;
        label197:
        if (paramNetResp.jdField_a_of_type_Int != 0) {
          break label438;
        }
        bool1 = true;
        label206:
        a((BaseTransProcessor.StepInfo)localObject1, paramNetResp, bool1);
        this.jdField_a_of_type_Long = paramNetResp.jdField_a_of_type_Long;
        if (this.jdField_a_of_type_Long <= 0L) {
          this.jdField_a_of_type_Long = (paramNetResp.jdField_b_of_type_Long + paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.jdField_a_of_type_Long);
        }
        this.jdField_b_of_type_Long += paramNetResp.jdField_c_of_type_Long;
        if ((paramNetResp.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq != null) && (this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.j)) {}
      }
      try
      {
        c(paramNetResp);
        label289:
        if (((this.jdField_f_of_type_Boolean) || (this.e)) && (!a(paramNetResp)))
        {
          this.e = false;
          this.jdField_f_of_type_Boolean = false;
          this.jdField_g_of_type_Boolean = true;
          if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq != null) {
            this.jdField_g_of_type_JavaLangString = ("checkPicFormat Erro, erroCode:" + paramNetResp.jdField_b_of_type_Int + " ,erroDesc:" + paramNetResp.jdField_a_of_type_JavaLangString + " ,encryptUrl:" + ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString + " ,ST:" + PkgTools.a(this.jdField_a_of_type_ArrayOfByte));
          }
          b(true);
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = null;
          return;
          bool1 = false;
          break;
          bool1 = false;
          break label87;
          label429:
          localObject1 = this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo;
          break label197;
          label438:
          bool1 = false;
          break label206;
          e();
          a(paramNetResp, true);
          continue;
          if ((paramNetResp.jdField_b_of_type_Int == 9364) && (this.l < 3))
          {
            b("[netChg]", "failed.but net change detect.so retry");
            this.jdField_c_of_type_Int = 4;
            this.jdField_f_of_type_JavaLangString = paramNetResp.jdField_a_of_type_JavaLangString;
            this.l += 1;
            m();
            b(false);
            return;
          }
          if ((this.e) || (this.jdField_f_of_type_Boolean))
          {
            this.e = false;
            this.jdField_f_of_type_Boolean = false;
            this.jdField_g_of_type_Boolean = true;
            if (paramNetResp.jdField_b_of_type_Int != -9527) {
              break label811;
            }
            localObject1 = (String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get(HttpMsg.jdField_f_of_type_JavaLangString);
            bool1 = bool2;
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              bool1 = bool2;
              if (((String)localObject1).split("_").length >= 3)
              {
                Object localObject3 = ((String)localObject1).split("_");
                localObject1 = localObject3[0];
                Object localObject2 = localObject3[1];
                localObject3 = localObject3[2];
                bool1 = bool2;
                if ("H".equals(localObject1))
                {
                  bool1 = bool2;
                  if ("400".equals(localObject2))
                  {
                    bool1 = bool2;
                    if (((String)localObject3).equals("-106"))
                    {
                      bool1 = bool2;
                      if (this.e) {
                        bool1 = true;
                      }
                    }
                  }
                }
              }
            }
            label674:
            if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq != null) {
              this.jdField_g_of_type_JavaLangString = ("encryptReqError=" + bool1 + ", ResErroCode:" + paramNetResp.jdField_b_of_type_Int + " ,erroDesc:" + paramNetResp.jdField_a_of_type_JavaLangString + " ,encryptUrl:" + ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString + " ,ST:" + PkgTools.a(this.jdField_a_of_type_ArrayOfByte));
            }
          }
          if (this.jdField_a_of_type_Boolean)
          {
            this.jdField_c_of_type_Int = 3;
            this.jdField_f_of_type_JavaLangString = paramNetResp.jdField_a_of_type_JavaLangString;
            if ((this instanceof GroupPicDownloadProcessor)) {
              FMTSrvAddrProvider.a().a().a(2);
            }
            for (;;)
            {
              b(true);
              break;
              label811:
              bool1 = bool2;
              if (paramNetResp.jdField_b_of_type_Int != 9058) {
                break label674;
              }
              bool1 = true;
              break label674;
              if ((this instanceof C2CPicDownloadProcessor)) {
                FMTSrvAddrProvider.a().a().a(1);
              }
            }
          }
          d();
        }
      }
      catch (IOException localIOException)
      {
        break label289;
      }
    }
  }
  
  protected void a(NetResp paramNetResp, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq instanceof HttpNetReq))
    {
      localHashMap.put("file_url", ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString);
      ServerAddr localServerAddr = RichMediaUtil.a(((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString);
      if (localServerAddr != null)
      {
        if ((!paramBoolean) && (localServerAddr.jdField_a_of_type_JavaLangString != null))
        {
          if (this.jdField_c_of_type_JavaUtilArrayList.contains(localServerAddr.jdField_a_of_type_JavaLangString)) {
            return;
          }
          this.jdField_c_of_type_JavaUtilArrayList.add(localServerAddr.jdField_a_of_type_JavaLangString);
        }
        localHashMap.put("server_ip", localServerAddr.jdField_a_of_type_JavaLangString);
        localHashMap.put("server_port", localServerAddr.jdField_a_of_type_Int + "");
      }
    }
    localHashMap.put("transfer_type", "2");
    localHashMap.put("business_type", "1");
    localHashMap.put("http_errorCode", paramNetResp.jdField_c_of_type_Int + "");
    localHashMap.put("param_FailCode", String.valueOf(this.jdField_j_of_type_Int));
    localHashMap.put("param_errorDesc", this.jdField_j_of_type_JavaLangString);
    localHashMap.put("md5", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_f_of_type_JavaLangString);
    localHashMap.put("uuid", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.e);
    localHashMap.put("chatType", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int + "");
    localHashMap.put("chatUin", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString + "");
    StatisticCollector.a(BaseApplication.getContext()).a(null, "actRichMediaNetMonitor_picDown", paramBoolean, 0L, 0L, localHashMap, "");
  }
  
  public boolean a(subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf paramDownloadEncryptConf)
  {
    return false;
  }
  
  public String b(String paramString)
  {
    paramString = jdField_a_of_type_JavaUtilRegexPattern.matcher(paramString);
    if (paramString.find()) {
      return paramString.group(1);
    }
    return null;
  }
  
  public void b(NetResp paramNetResp)
  {
    a(paramNetResp, false);
  }
  
  void b(boolean paramBoolean) {}
  
  void c(boolean paramBoolean) {}
  
  void d()
  {
    super.d();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqTransfileTransferResult;
    if (localObject1 != null)
    {
      ((TransferResult)localObject1).jdField_a_of_type_Int = -1;
      ((TransferResult)localObject1).jdField_a_of_type_Long = this.jdField_j_of_type_Int;
      ((TransferResult)localObject1).jdField_a_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
      ((TransferResult)localObject1).jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest;
    }
    Object localObject4;
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg != null) {
        this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.d = 2005;
      }
      localObject1 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject4 = (DownCallBack)((Iterator)localObject1).next();
        DownCallBack.DownResult localDownResult = new DownCallBack.DownResult();
        localDownResult.jdField_a_of_type_Int = -1;
        localDownResult.jdField_b_of_type_Int = this.jdField_j_of_type_Int;
        localDownResult.jdField_a_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
        ((DownCallBack)localObject4).a(localDownResult);
        if (QLog.isColorLevel()) {
          QLog.d("PIC_TAG", 2, "onError ");
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg == null) {
        break label174;
      }
    }
    finally {}
    b("notify", "start");
    label174:
    notifyAll();
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg != null) {
      b("notify", "end");
    }
    Object localObject3;
    if ((this.jdField_j_of_type_Int == 9014) || (this.jdField_j_of_type_Int == 9050))
    {
      localObject3 = RichMediaUtil.a(((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString);
      if (localObject3 != null)
      {
        localObject3 = ((ServerAddr)localObject3).jdField_a_of_type_JavaLangString;
        localObject4 = new ProbeChain();
        if (this.jdField_j_of_type_Int != 9014) {
          break label342;
        }
        ((ProbeChain)localObject4).addProbeItem(new PingProbe());
        ((ProbeChain)localObject4).addProbeItem(new MtuProbe());
        ((ProbeChain)localObject4).addProbeItem(new TracerouteProbe());
        if (this.jdField_j_of_type_Int != 9014) {
          break label369;
        }
      }
    }
    label342:
    label369:
    for (int i = -1201;; i = -1202)
    {
      localObject3 = new ProbeRequest((String)localObject3, i, (ProbeItem)localObject4);
      jdField_a_of_type_ComTencentMobileqqHighwayNetprobeWeakNetLearner.startProbe(new ProbeTask((ProbeRequest)localObject3));
      d(2005);
      return;
      ((ProbeChain)localObject4).addProbeItem(new PingProbe());
      ((ProbeChain)localObject4).addProbeItem(new TracerouteProbe());
      break;
    }
  }
  
  void e()
  {
    super.e();
    if (QLog.isColorLevel()) {
      QLog.d("big_thumb", 2, "onsuccess mUiRequest.mFileType" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int + "mUiRequest.mOutFilePath=" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h + "url=" + ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString);
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqTransfileTransferResult;
    if (localObject1 != null)
    {
      ((TransferResult)localObject1).jdField_a_of_type_Int = 0;
      ((TransferResult)localObject1).jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest;
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int != 65537) {
          continue;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h;
        if (localObject1 == null) {
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        label336:
        Object localObject3;
        label562:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("PIC_TAG", 2, localThrowable.getMessage());
        continue;
        localObject4 = localObject5;
        if (!(localObject5 instanceof MessageForStructing)) {
          continue;
        }
        Object localObject6 = (MessageForStructing)localObject5;
        localObject4 = localObject5;
        if (!(((MessageForStructing)localObject6).structingMsg instanceof StructMsgForImageShare)) {
          continue;
        }
        localObject6 = ((StructMsgForImageShare)((MessageForStructing)localObject6).structingMsg).getFirstImageElement();
        localObject4 = localObject5;
        if (localObject6 == null) {
          continue;
        }
        localObject4 = localObject5;
        if (((StructMsgItemImage)localObject6).a == null) {
          continue;
        }
        localObject4 = ((StructMsgItemImage)localObject6).a;
        continue;
        Object localObject5 = (String)localObject5 + "_hd";
        continue;
        bool = false;
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg == null) {
          continue;
        }
        b("notify", "start");
        notifyAll();
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg == null) {
          continue;
        }
        b("notify", "end");
        d(2003);
        return;
      }
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg != null) {
          this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.d = 2003;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest;
        if (((TransferRequest)localObject1).m != null)
        {
          localObject5 = new File(((TransferRequest)localObject1).m);
          if ((((File)localObject5).exists()) && (((File)localObject5).delete()) && (QLog.isDevelopLevel())) {
            QLog.d("peak_pgjpeg", 4, "BasePicDownloadProcessor.onSuccess():Delete " + ((TransferRequest)localObject1).m);
          }
        }
        int i = a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest);
        localObject1 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          continue;
        }
        localObject5 = (DownCallBack)((Iterator)localObject1).next();
        localObject6 = new DownCallBack.DownResult();
        ((DownCallBack.DownResult)localObject6).jdField_a_of_type_Int = 0;
        ((DownCallBack.DownResult)localObject6).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h;
        ((DownCallBack.DownResult)localObject6).jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_f_of_type_JavaLangString;
        ((DownCallBack.DownResult)localObject6).jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int;
        ((DownCallBack.DownResult)localObject6).d = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.g;
        if (i == 2) {
          break label1037;
        }
        if (i != 3) {
          continue;
        }
      }
      finally {}
      ((DownCallBack.DownResult)localObject6).jdField_a_of_type_Boolean = bool;
      ((DownCallBack)localObject5).a((DownCallBack.DownResult)localObject6);
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int == 131075) && (QLog.isDevelopLevel())) {
        QLog.d("peak_pgjpeg", 4, "BasePicDownloadProcessor.onSuccess():" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h + ", isPart " + ((DownCallBack.DownResult)localObject6).jdField_a_of_type_Boolean);
      }
      if (QLog.isColorLevel())
      {
        QLog.d("PIC_TAG", 2, "onSuccess ");
        continue;
        if (((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int == 131075)) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h != null) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (!GifDrawable.isGifFile(new File(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h))) && (DeviceInfoUtil.d() >= 240))
        {
          localObject5 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
          if ((localObject5 instanceof MessageForMixedMsg))
          {
            localObject3 = ((MessageForMixedMsg)localObject5).getSubMessage(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Long);
            if ((localObject3 == null) || (!(localObject3 instanceof MessageForPic))) {
              break label1032;
            }
            localObject3 = (MessageForPic)localObject3;
            if (localObject3 == null) {
              break label1035;
            }
            if (((MessageForPic)localObject3).fileSizeFlag != 1) {
              break label1042;
            }
          }
        }
      }
    }
    label1027:
    label1032:
    label1035:
    label1037:
    label1042:
    for (boolean bool = true;; bool = false)
    {
      URL localURL;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int == URLDrawableHelper.a("chatimg", bool))
      {
        localObject6 = new CompressInfo(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h, 0);
        localURL = URLDrawableHelper.a((PicUiInterface)localObject3, 65537);
        ((CompressInfo)localObject6).jdField_f_of_type_Boolean = true;
        localObject5 = AbsDownloader.d(localURL.toString());
        if (!((String)localObject5).endsWith("_hd"))
        {
          if (!((String)localObject5).endsWith("_big400")) {
            break label948;
          }
          ((String)localObject5).replace("_big400", "_hd");
          ((CompressInfo)localObject6).e = ((String)localObject5);
          CompressOperator.b((CompressInfo)localObject6);
          if (((CompressInfo)localObject6).e != null)
          {
            localObject5 = new File((String)localObject5);
            if (!((CompressInfo)localObject6).e.equals(((CompressInfo)localObject6).jdField_c_of_type_JavaLangString)) {
              break label1027;
            }
          }
        }
      }
      label948:
      for (bool = FileUtil.a(new File(((CompressInfo)localObject6).jdField_c_of_type_JavaLangString), (File)localObject5);; bool = true)
      {
        if ((bool) && (BaseApplicationImpl.sImageCache.get(localURL.toString()) != null))
        {
          BaseApplicationImpl.sImageCache.remove(localURL.toString());
          localObject5 = URLDrawable.getDrawable(localURL);
          if (localObject5 != null) {
            ((URLDrawable)localObject5).downloadImediatly(true);
          }
        }
        if (((!HotChatHelper.a((MessageRecord)localObject3)) && (!FlashPicHelper.a((MessageRecord)localObject3))) || (TextUtils.isEmpty(((MessageForPic)localObject3).md5))) {
          break;
        }
        localObject5 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h + "_fp";
        DESUtil.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h, (String)localObject5, ((MessageForPic)localObject3).md5);
        break;
      }
      Object localObject4 = null;
      break label562;
      break;
      bool = true;
      break label336;
    }
  }
  
  public void f()
  {
    Object localObject = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
    this.jdField_b_of_type_ArrayOfByte = ((TicketManager)localObject).getStkey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 1600000226);
    this.jdField_a_of_type_ArrayOfByte = ((TicketManager)localObject).getSt(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 1600000226);
    subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf localDownloadEncryptConf = FMTSrvAddrProvider.a().a();
    if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_b_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ArrayOfByte.length > 0) && (this.jdField_b_of_type_ArrayOfByte.length > 0) && (localDownloadEncryptConf != null))
    {
      this.jdField_f_of_type_Boolean = localDownloadEncryptConf.bool_enable_encrypt_request.get();
      this.e = localDownloadEncryptConf.bool_enable_encrypted_pic.get();
      if (this.jdField_b_of_type_ArrayOfByte != null) {
        break label172;
      }
    }
    label172:
    for (localObject = "key or switch can't get!";; localObject = "STKey:" + MD5.toMD5(this.jdField_b_of_type_ArrayOfByte))
    {
      b("ticketInit", (String)localObject);
      if ((!a(localDownloadEncryptConf)) || (!jdField_b_of_type_Boolean))
      {
        this.e = false;
        this.jdField_f_of_type_Boolean = false;
      }
      return;
      this.e = false;
      this.jdField_f_of_type_Boolean = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BasePicDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */