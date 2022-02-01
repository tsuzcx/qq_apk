package com.tencent.mobileqq.pic.operator;

import android.content.Intent;
import android.graphics.BitmapFactory.Options;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.GifDrawable;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicResult;
import com.tencent.mobileqq.pic.PicStatisticsManager;
import com.tencent.mobileqq.pic.PicUploadExtra;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.pic.PicUploadInfo.Builder;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.GeneralConfigUtils;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import cooperation.peak.PeakUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import tencent.im.msg.im_msg_body.RichText;

public class UploadPicOperator
  extends BasePicOperator
  implements UpCallBack, IPicInfoBuilder.UploadInfoBuilder
{
  public MessageRecord a(PicUploadInfo paramPicUploadInfo)
  {
    long l = System.currentTimeMillis();
    if ((paramPicUploadInfo != null) && (paramPicUploadInfo.jdField_g_of_type_JavaLangString != null))
    {
      MessageForPic localMessageForPic = MessageRecordFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramPicUploadInfo.jdField_c_of_type_JavaLangString, paramPicUploadInfo.jdField_d_of_type_JavaLangString, paramPicUploadInfo.jdField_b_of_type_Int);
      localMessageForPic.busiType = paramPicUploadInfo.jdField_a_of_type_Int;
      localMessageForPic.path = paramPicUploadInfo.jdField_g_of_type_JavaLangString;
      localMessageForPic.size = 0L;
      localMessageForPic.type = 1;
      localMessageForPic.isRead = true;
      localMessageForPic.extraflag = 32772;
      if (paramPicUploadInfo.jdField_g_of_type_Int == 1) {
        localMessageForPic.fileSizeFlag = 1;
      }
      localMessageForPic.localUUID = paramPicUploadInfo.jdField_a_of_type_JavaLangString;
      Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "bindUrlKeyAndUniseq", localMessageForPic.localUUID + "|" + localMessageForPic.uniseq);
      localMessageForPic.md5 = a(localMessageForPic.path);
      c(paramPicUploadInfo, localMessageForPic);
      localMessageForPic.thumbWidth = paramPicUploadInfo.jdField_e_of_type_Int;
      localMessageForPic.thumbHeight = paramPicUploadInfo.jdField_f_of_type_Int;
      b(paramPicUploadInfo, localMessageForPic);
      localMessageForPic.extLong = paramPicUploadInfo.jdField_i_of_type_Int;
      localMessageForPic.extStr = paramPicUploadInfo.jdField_i_of_type_JavaLangString;
      localMessageForPic.msgVia = paramPicUploadInfo.jdField_n_of_type_Int;
      localMessageForPic.sync2Story = paramPicUploadInfo.jdField_g_of_type_Boolean;
      String str = MessageConstants.m;
      Object localObject;
      if (localMessageForPic.sync2Story)
      {
        localObject = "1";
        localMessageForPic.saveExtInfoToExtStr(str, (String)localObject);
        a(localMessageForPic, paramPicUploadInfo);
        localObject = paramPicUploadInfo.jdField_a_of_type_JavaUtilArrayList;
        if ((localObject == null) || (((ArrayList)localObject).isEmpty())) {
          break label370;
        }
        a(paramPicUploadInfo, localMessageForPic);
        localMessageForPic.imageType = 1003;
      }
      for (;;)
      {
        localMessageForPic.serial();
        paramPicUploadInfo.jdField_a_of_type_Long = localMessageForPic.uniseq;
        Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "packMsg", "cost:" + (System.currentTimeMillis() - l));
        a(localMessageForPic);
        localMessageForPic.DSKey = paramPicUploadInfo.jdField_b_of_type_Long;
        return localMessageForPic;
        localObject = "0";
        break;
        label370:
        if (QLog.isColorLevel()) {
          QLog.d("peak_pgjpeg", 2, "Slice infos is null");
        }
      }
    }
    return null;
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "attachRichText2Msg", "");
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForRichText))) {
      ((MessageForRichText)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).richText = paramRichText;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  }
  
  public PicUploadInfo a(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      Object localObject2 = paramIntent.getStringExtra("uin");
      String str2 = paramIntent.getStringExtra("troop_uin");
      int i = paramIntent.getIntExtra("uintype", 1003);
      int j = paramIntent.getIntExtra("PhotoConst.SEND_SIZE_SPEC", 0);
      int k = paramIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1);
      String str3 = paramIntent.getStringExtra("PhotoConst.PHOTO_SEND_PATH");
      int m = paramIntent.getIntExtra("entrance", 0);
      int n = paramIntent.getIntExtra("key_confess_topicid", 0);
      boolean bool1 = paramIntent.getBooleanExtra("video_sync_to_story", false);
      boolean bool2 = paramIntent.getBooleanExtra("key_story_photo_to_recent", false);
      Object localObject1 = paramIntent.getStringExtra("widgetinfo");
      String str1 = paramIntent.getStringExtra("key_camera_material_name");
      boolean bool3 = paramIntent.getBooleanExtra("quick_send_is_emo_search", false);
      boolean bool4 = paramIntent.getBooleanExtra("HOT_PIC_SEND_PIC", false);
      PicUploadInfo.Builder localBuilder = new PicUploadInfo.Builder();
      localBuilder.d((String)localObject2);
      localBuilder.a(str3);
      localBuilder.e(i);
      localBuilder.e(str2);
      localBuilder.d(k);
      localBuilder.f(j);
      localBuilder.l(n);
      localBuilder.k(m);
      localBuilder.a(bool1);
      localBuilder.b(bool2);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = new PicUploadExtra();
        ((PicUploadExtra)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject1);
        ((PicUploadExtra)localObject2).jdField_b_of_type_JavaLangString = str1;
        localBuilder.a((PicUploadExtra)localObject2);
      }
      localObject1 = localBuilder.a();
      i = paramIntent.getIntExtra("key_is_sync_qzone", 0);
      if (i == 1)
      {
        str1 = paramIntent.getStringExtra("key_qzone_album_id");
        ((PicUploadInfo)localObject1).p = i;
        ((PicUploadInfo)localObject1).j = str1;
        ((PicUploadInfo)localObject1).jdField_d_of_type_Long = paramIntent.getLongExtra("key_qzone_batch_id", 0L);
        ((PicUploadInfo)localObject1).jdField_e_of_type_Long = paramIntent.getIntExtra("PhotoConst.PHOTO_COUNT", 0);
        ((PicUploadInfo)localObject1).jdField_f_of_type_Long = paramIntent.getIntExtra("PhotoConst.PHOTO_SEND_PATH_INDEX", 0);
      }
      i = paramIntent.getIntExtra("key_pic_send_source", 0);
      if (((PicUploadInfo)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicUploadExtra == null) {
        ((PicUploadInfo)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicUploadExtra = new PicUploadExtra();
      }
      ((PicUploadInfo)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicUploadExtra.jdField_a_of_type_Int = i;
      ((PicUploadInfo)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicUploadExtra.jdField_b_of_type_Boolean = bool3;
      ((PicUploadInfo)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicUploadExtra.jdField_c_of_type_Boolean = bool4;
      Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "createPicUploadInfo", "");
      return localObject1;
    }
    Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "createPicUploadInfo", "unknow obj");
    return null;
  }
  
  /* Error */
  protected com.tencent.mobileqq.transfile.TransferRequest a(PicReq paramPicReq, PicUploadInfo paramPicUploadInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 356	com/tencent/mobileqq/pic/operator/UploadPicOperator:b	()V
    //   4: new 358	com/tencent/mobileqq/pic/CompressInfo
    //   7: dup
    //   8: aload_2
    //   9: getfield 27	com/tencent/mobileqq/pic/PicUploadInfo:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   12: iconst_0
    //   13: invokespecial 361	com/tencent/mobileqq/pic/CompressInfo:<init>	(Ljava/lang/String;I)V
    //   16: astore 6
    //   18: aload 6
    //   20: invokestatic 366	com/tencent/mobileqq/pic/compress/CompressOperator:b	(Lcom/tencent/mobileqq/pic/CompressInfo;)Z
    //   23: pop
    //   24: aload 6
    //   26: getfield 368	com/tencent/mobileqq/pic/CompressInfo:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   29: ifnull +30 -> 59
    //   32: aload_2
    //   33: aload 6
    //   35: getfield 368	com/tencent/mobileqq/pic/CompressInfo:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   38: putfield 371	com/tencent/mobileqq/pic/PicUploadInfo:h	Ljava/lang/String;
    //   41: aload_2
    //   42: aload 6
    //   44: getfield 373	com/tencent/mobileqq/pic/CompressInfo:d	I
    //   47: putfield 121	com/tencent/mobileqq/pic/PicUploadInfo:jdField_e_of_type_Int	I
    //   50: aload_2
    //   51: aload 6
    //   53: getfield 374	com/tencent/mobileqq/pic/CompressInfo:jdField_e_of_type_Int	I
    //   56: putfield 127	com/tencent/mobileqq/pic/PicUploadInfo:jdField_f_of_type_Int	I
    //   59: aload_0
    //   60: aload_2
    //   61: invokevirtual 376	com/tencent/mobileqq/pic/operator/UploadPicOperator:a	(Lcom/tencent/mobileqq/pic/PicUploadInfo;)Lcom/tencent/mobileqq/data/MessageRecord;
    //   64: astore 6
    //   66: aload 6
    //   68: ifnonnull +18 -> 86
    //   71: aload_0
    //   72: getfield 82	com/tencent/mobileqq/pic/operator/UploadPicOperator:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   75: ldc_w 378
    //   78: ldc_w 380
    //   81: invokestatic 383	com/tencent/mobileqq/pic/Logger:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   84: aconst_null
    //   85: areturn
    //   86: invokestatic 206	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   89: ifeq +37 -> 126
    //   92: ldc_w 385
    //   95: iconst_2
    //   96: new 87	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   103: ldc_w 387
    //   106: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload 6
    //   111: checkcast 49	com/tencent/mobileqq/data/MessageForPic
    //   114: getfield 149	com/tencent/mobileqq/data/MessageForPic:msgVia	I
    //   117: invokevirtual 390	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   120: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   126: invokestatic 395	com/tencent/mobileqq/activity/aio/forward/ForwardOrderManager:a	()Lcom/tencent/mobileqq/activity/aio/forward/ForwardOrderManager;
    //   129: aload 6
    //   131: getfield 398	com/tencent/mobileqq/data/MessageRecord:uniseq	J
    //   134: lconst_0
    //   135: aload_1
    //   136: getfield 402	com/tencent/mobileqq/pic/PicReq:jdField_c_of_type_Int	I
    //   139: invokevirtual 405	com/tencent/mobileqq/activity/aio/forward/ForwardOrderManager:a	(JJI)V
    //   142: ldc 49
    //   144: aload 6
    //   146: invokevirtual 411	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   149: ifeq +19 -> 168
    //   152: aload_0
    //   153: aload_1
    //   154: aload 6
    //   156: aload_2
    //   157: invokevirtual 414	com/tencent/mobileqq/pic/operator/UploadPicOperator:a	(Lcom/tencent/mobileqq/pic/PicReq;Lcom/tencent/mobileqq/data/MessageRecord;Lcom/tencent/mobileqq/pic/PicUploadInfo;)V
    //   160: aload 6
    //   162: checkcast 49	com/tencent/mobileqq/data/MessageForPic
    //   165: invokevirtual 417	com/tencent/mobileqq/data/MessageForPic:cachePicToDisk	()V
    //   168: aload 6
    //   170: getfield 420	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   173: iconst_1
    //   174: if_icmpne +18 -> 192
    //   177: aload_2
    //   178: getfield 423	com/tencent/mobileqq/pic/PicUploadInfo:jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo$RetryInfo	Lcom/tencent/mobileqq/pic/PicUploadInfo$RetryInfo;
    //   181: ifnonnull +11 -> 192
    //   184: invokestatic 428	com/tencent/biz/anonymous/AnonymousChatHelper:a	()Lcom/tencent/biz/anonymous/AnonymousChatHelper;
    //   187: aload 6
    //   189: invokevirtual 431	com/tencent/biz/anonymous/AnonymousChatHelper:a	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   192: aload_2
    //   193: getfield 432	com/tencent/mobileqq/pic/PicUploadInfo:jdField_c_of_type_Boolean	Z
    //   196: ifeq +150 -> 346
    //   199: aload_2
    //   200: monitorenter
    //   201: aload_2
    //   202: aload 6
    //   204: putfield 435	com/tencent/mobileqq/pic/PicUploadInfo:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   207: aload_2
    //   208: invokevirtual 440	java/lang/Object:notifyAll	()V
    //   211: aload_0
    //   212: getfield 82	com/tencent/mobileqq/pic/operator/UploadPicOperator:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   215: ldc_w 442
    //   218: new 87	java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   225: ldc_w 444
    //   228: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: aload_2
    //   232: getfield 27	com/tencent/mobileqq/pic/PicUploadInfo:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   235: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: ldc_w 446
    //   241: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: aload_0
    //   245: getfield 83	com/tencent/mobileqq/pic/operator/UploadPicOperator:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   248: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: ldc_w 448
    //   254: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokestatic 383	com/tencent/mobileqq/pic/Logger:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   263: aload_2
    //   264: getfield 449	com/tencent/mobileqq/pic/PicUploadInfo:jdField_c_of_type_Int	I
    //   267: iconst_3
    //   268: if_icmpne +76 -> 344
    //   271: aload_0
    //   272: getfield 82	com/tencent/mobileqq/pic/operator/UploadPicOperator:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   275: aload_0
    //   276: getfield 83	com/tencent/mobileqq/pic/operator/UploadPicOperator:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   279: ldc_w 451
    //   282: ldc_w 453
    //   285: invokestatic 109	com/tencent/mobileqq/pic/Logger:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   288: aload_0
    //   289: getfield 82	com/tencent/mobileqq/pic/operator/UploadPicOperator:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   292: ldc_w 378
    //   295: new 87	java/lang/StringBuilder
    //   298: dup
    //   299: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   302: ldc_w 444
    //   305: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: aload_2
    //   309: getfield 27	com/tencent/mobileqq/pic/PicUploadInfo:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   312: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: ldc_w 446
    //   318: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: aload_0
    //   322: getfield 83	com/tencent/mobileqq/pic/operator/UploadPicOperator:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   325: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: ldc_w 455
    //   331: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   337: invokestatic 383	com/tencent/mobileqq/pic/Logger:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   340: aload_2
    //   341: monitorexit
    //   342: aconst_null
    //   343: areturn
    //   344: aload_2
    //   345: monitorexit
    //   346: aload_0
    //   347: aload 6
    //   349: putfield 221	com/tencent/mobileqq/pic/operator/UploadPicOperator:jdField_a_of_type_ComTencentMobileqqDataMessageRecord	Lcom/tencent/mobileqq/data/MessageRecord;
    //   352: invokestatic 21	java/lang/System:currentTimeMillis	()J
    //   355: lstore_3
    //   356: new 457	com/tencent/mobileqq/transfile/TransferRequest
    //   359: dup
    //   360: invokespecial 458	com/tencent/mobileqq/transfile/TransferRequest:<init>	()V
    //   363: astore_1
    //   364: aload_1
    //   365: aload_0
    //   366: getfield 30	com/tencent/mobileqq/pic/operator/UploadPicOperator:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   369: invokevirtual 463	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   372: putfield 466	com/tencent/mobileqq/transfile/TransferRequest:mSelfUin	Ljava/lang/String;
    //   375: aload_1
    //   376: aload 6
    //   378: getfield 469	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   381: putfield 472	com/tencent/mobileqq/transfile/TransferRequest:mPeerUin	Ljava/lang/String;
    //   384: aload_1
    //   385: aload 6
    //   387: getfield 475	com/tencent/mobileqq/data/MessageRecord:senderuin	Ljava/lang/String;
    //   390: putfield 478	com/tencent/mobileqq/transfile/TransferRequest:mSecondId	Ljava/lang/String;
    //   393: aload_1
    //   394: aload 6
    //   396: getfield 420	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   399: putfield 481	com/tencent/mobileqq/transfile/TransferRequest:mUinType	I
    //   402: aload_1
    //   403: iconst_1
    //   404: putfield 484	com/tencent/mobileqq/transfile/TransferRequest:mFileType	I
    //   407: aload_1
    //   408: aload 6
    //   410: getfield 398	com/tencent/mobileqq/data/MessageRecord:uniseq	J
    //   413: putfield 487	com/tencent/mobileqq/transfile/TransferRequest:mUniseq	J
    //   416: aload_1
    //   417: iconst_1
    //   418: putfield 490	com/tencent/mobileqq/transfile/TransferRequest:mIsUp	Z
    //   421: aload_1
    //   422: aload_2
    //   423: getfield 47	com/tencent/mobileqq/pic/PicUploadInfo:jdField_a_of_type_Int	I
    //   426: putfield 493	com/tencent/mobileqq/transfile/TransferRequest:mBusiType	I
    //   429: aload_1
    //   430: aload_2
    //   431: getfield 27	com/tencent/mobileqq/pic/PicUploadInfo:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   434: putfield 496	com/tencent/mobileqq/transfile/TransferRequest:mLocalPath	Ljava/lang/String;
    //   437: aload_1
    //   438: aload_2
    //   439: getfield 498	com/tencent/mobileqq/pic/PicUploadInfo:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   442: putfield 501	com/tencent/mobileqq/transfile/TransferRequest:mMd5	Ljava/lang/String;
    //   445: new 503	com/tencent/mobileqq/transfile/TransferRequest$PicUpExtraInfo
    //   448: dup
    //   449: invokespecial 504	com/tencent/mobileqq/transfile/TransferRequest$PicUpExtraInfo:<init>	()V
    //   452: astore 7
    //   454: aload_2
    //   455: invokevirtual 507	com/tencent/mobileqq/pic/PicUploadInfo:a	()I
    //   458: iconst_1
    //   459: if_icmpne +159 -> 618
    //   462: iconst_1
    //   463: istore 5
    //   465: aload 7
    //   467: iload 5
    //   469: putfield 510	com/tencent/mobileqq/transfile/TransferRequest$PicUpExtraInfo:mIsRaw	Z
    //   472: aload_1
    //   473: aload 7
    //   475: putfield 513	com/tencent/mobileqq/transfile/TransferRequest:mExtraObj	Ljava/lang/Object;
    //   478: aload_1
    //   479: aload_0
    //   480: putfield 517	com/tencent/mobileqq/transfile/TransferRequest:mUpCallBack	Lcom/tencent/mobileqq/pic/UpCallBack;
    //   483: aload_1
    //   484: aload_0
    //   485: getfield 221	com/tencent/mobileqq/pic/operator/UploadPicOperator:jdField_a_of_type_ComTencentMobileqqDataMessageRecord	Lcom/tencent/mobileqq/data/MessageRecord;
    //   488: putfield 520	com/tencent/mobileqq/transfile/TransferRequest:mRec	Lcom/tencent/mobileqq/data/MessageRecord;
    //   491: aload_1
    //   492: aload_2
    //   493: getfield 432	com/tencent/mobileqq/pic/PicUploadInfo:jdField_c_of_type_Boolean	Z
    //   496: putfield 523	com/tencent/mobileqq/transfile/TransferRequest:mIsPresend	Z
    //   499: aload_1
    //   500: aload_2
    //   501: getfield 525	com/tencent/mobileqq/pic/PicUploadInfo:jdField_e_of_type_Boolean	Z
    //   504: putfield 528	com/tencent/mobileqq/transfile/TransferRequest:myPresendInvalid	Z
    //   507: aload_2
    //   508: getfield 344	com/tencent/mobileqq/pic/PicUploadInfo:jdField_a_of_type_ComTencentMobileqqPicPicUploadExtra	Lcom/tencent/mobileqq/pic/PicUploadExtra;
    //   511: ifnull +14 -> 525
    //   514: aload_1
    //   515: aload_2
    //   516: getfield 344	com/tencent/mobileqq/pic/PicUploadInfo:jdField_a_of_type_ComTencentMobileqqPicPicUploadExtra	Lcom/tencent/mobileqq/pic/PicUploadExtra;
    //   519: getfield 345	com/tencent/mobileqq/pic/PicUploadExtra:jdField_a_of_type_Int	I
    //   522: putfield 531	com/tencent/mobileqq/transfile/TransferRequest:mPicSendSource	I
    //   525: aload_2
    //   526: getfield 432	com/tencent/mobileqq/pic/PicUploadInfo:jdField_c_of_type_Boolean	Z
    //   529: ifeq +286 -> 815
    //   532: aload_2
    //   533: monitorenter
    //   534: aload_2
    //   535: getfield 533	com/tencent/mobileqq/pic/PicUploadInfo:jdField_d_of_type_Boolean	Z
    //   538: ifeq +86 -> 624
    //   541: aload_0
    //   542: getfield 82	com/tencent/mobileqq/pic/operator/UploadPicOperator:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   545: aload_0
    //   546: getfield 83	com/tencent/mobileqq/pic/operator/UploadPicOperator:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   549: ldc_w 535
    //   552: ldc 218
    //   554: invokestatic 109	com/tencent/mobileqq/pic/Logger:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   557: aload_0
    //   558: getfield 82	com/tencent/mobileqq/pic/operator/UploadPicOperator:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   561: ldc_w 442
    //   564: new 87	java/lang/StringBuilder
    //   567: dup
    //   568: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   571: ldc_w 444
    //   574: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: aload_2
    //   578: getfield 27	com/tencent/mobileqq/pic/PicUploadInfo:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   581: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: ldc_w 446
    //   587: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: aload_0
    //   591: getfield 83	com/tencent/mobileqq/pic/operator/UploadPicOperator:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   594: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: ldc_w 537
    //   600: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   606: invokestatic 383	com/tencent/mobileqq/pic/Logger:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   609: aload_2
    //   610: monitorexit
    //   611: aconst_null
    //   612: areturn
    //   613: astore_1
    //   614: aload_2
    //   615: monitorexit
    //   616: aload_1
    //   617: athrow
    //   618: iconst_0
    //   619: istore 5
    //   621: goto -156 -> 465
    //   624: aload_0
    //   625: getfield 82	com/tencent/mobileqq/pic/operator/UploadPicOperator:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   628: aload_0
    //   629: getfield 83	com/tencent/mobileqq/pic/operator/UploadPicOperator:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   632: ldc_w 539
    //   635: ldc 218
    //   637: invokestatic 109	com/tencent/mobileqq/pic/Logger:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   640: aload_0
    //   641: getfield 30	com/tencent/mobileqq/pic/operator/UploadPicOperator:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   644: ldc_w 541
    //   647: invokevirtual 545	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;)Lmqq/app/api/IRuntimeService;
    //   650: checkcast 541	com/tencent/mobileqq/transfile/api/ITransFileController
    //   653: aload_1
    //   654: invokeinterface 549 2 0
    //   659: pop
    //   660: aload_0
    //   661: getfield 82	com/tencent/mobileqq/pic/operator/UploadPicOperator:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   664: ldc_w 442
    //   667: new 87	java/lang/StringBuilder
    //   670: dup
    //   671: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   674: ldc_w 444
    //   677: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   680: aload_2
    //   681: getfield 27	com/tencent/mobileqq/pic/PicUploadInfo:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   684: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: ldc_w 446
    //   690: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: aload_0
    //   694: getfield 83	com/tencent/mobileqq/pic/operator/UploadPicOperator:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   697: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   700: ldc_w 551
    //   703: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   706: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   709: invokestatic 383	com/tencent/mobileqq/pic/Logger:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   712: aload_2
    //   713: monitorexit
    //   714: aload_0
    //   715: getfield 82	com/tencent/mobileqq/pic/operator/UploadPicOperator:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   718: aload_0
    //   719: getfield 83	com/tencent/mobileqq/pic/operator/UploadPicOperator:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   722: ldc_w 553
    //   725: new 87	java/lang/StringBuilder
    //   728: dup
    //   729: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   732: ldc 191
    //   734: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   737: invokestatic 21	java/lang/System:currentTimeMillis	()J
    //   740: lload_3
    //   741: lsub
    //   742: invokevirtual 100	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   745: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   748: invokestatic 109	com/tencent/mobileqq/pic/Logger:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   751: aload_2
    //   752: getfield 554	com/tencent/mobileqq/pic/PicUploadInfo:jdField_b_of_type_Boolean	Z
    //   755: ifeq +37 -> 792
    //   758: aload_2
    //   759: getfield 432	com/tencent/mobileqq/pic/PicUploadInfo:jdField_c_of_type_Boolean	Z
    //   762: ifne +30 -> 792
    //   765: aload_0
    //   766: getfield 82	com/tencent/mobileqq/pic/operator/UploadPicOperator:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   769: aload_0
    //   770: getfield 83	com/tencent/mobileqq/pic/operator/UploadPicOperator:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   773: ldc_w 556
    //   776: ldc_w 558
    //   779: invokestatic 109	com/tencent/mobileqq/pic/Logger:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   782: aload_0
    //   783: aload 6
    //   785: aload_2
    //   786: getfield 560	com/tencent/mobileqq/pic/PicUploadInfo:jdField_g_of_type_Long	J
    //   789: invokevirtual 563	com/tencent/mobileqq/pic/operator/UploadPicOperator:a	(Lcom/tencent/mobileqq/data/MessageRecord;J)V
    //   792: aload_0
    //   793: getfield 82	com/tencent/mobileqq/pic/operator/UploadPicOperator:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   796: aload_0
    //   797: getfield 83	com/tencent/mobileqq/pic/operator/UploadPicOperator:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   800: ldc_w 565
    //   803: ldc 218
    //   805: invokestatic 109	com/tencent/mobileqq/pic/Logger:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   808: aload_1
    //   809: areturn
    //   810: astore_1
    //   811: aload_2
    //   812: monitorexit
    //   813: aload_1
    //   814: athrow
    //   815: aload_0
    //   816: getfield 30	com/tencent/mobileqq/pic/operator/UploadPicOperator:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   819: ldc_w 541
    //   822: invokevirtual 545	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;)Lmqq/app/api/IRuntimeService;
    //   825: checkcast 541	com/tencent/mobileqq/transfile/api/ITransFileController
    //   828: aload_1
    //   829: invokeinterface 549 2 0
    //   834: pop
    //   835: goto -121 -> 714
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	838	0	this	UploadPicOperator
    //   0	838	1	paramPicReq	PicReq
    //   0	838	2	paramPicUploadInfo	PicUploadInfo
    //   355	386	3	l	long
    //   463	157	5	bool	boolean
    //   16	768	6	localObject	Object
    //   452	22	7	localPicUpExtraInfo	com.tencent.mobileqq.transfile.TransferRequest.PicUpExtraInfo
    // Exception table:
    //   from	to	target	type
    //   201	342	613	finally
    //   344	346	613	finally
    //   614	616	613	finally
    //   534	611	810	finally
    //   624	714	810	finally
    //   811	813	810	finally
  }
  
  String a(String paramString)
  {
    long l = System.currentTimeMillis();
    try
    {
      String str1 = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
      paramString = str1;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        paramString = new File(paramString);
        if (!paramString.exists()) {
          break;
        }
        try
        {
          String str2 = MD5FileUtil.a(paramString);
          paramString = str2;
          if (str2 == null) {
            paramString = "";
          }
        }
        catch (IOException paramString)
        {
          paramString = "";
        }
      }
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = "";
      }
    }
    Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "calcMD5", "md5:" + paramString + ",cost:" + (System.currentTimeMillis() - l));
    return paramString;
  }
  
  public void a()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqPicPicReq);
  }
  
  protected void a(MessageForPic paramMessageForPic, PicUploadInfo paramPicUploadInfo)
  {
    ConfessMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic, paramPicUploadInfo.jdField_c_of_type_JavaLangString, paramPicUploadInfo.jdField_b_of_type_Int, paramPicUploadInfo.o);
    PicMessageExtraData localPicMessageExtraData1;
    if (paramPicUploadInfo.jdField_b_of_type_Int == 0)
    {
      ConfessMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic, paramPicUploadInfo.jdField_c_of_type_JavaLangString);
      if (paramPicUploadInfo.jdField_a_of_type_Int == 1036) {
        DatingUtil.a(paramMessageForPic);
      }
      if (paramPicUploadInfo.p == 1)
      {
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_is_sync_qzone", String.valueOf(1));
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_album_id", paramPicUploadInfo.j);
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_batch_id", String.valueOf(paramPicUploadInfo.jdField_d_of_type_Long));
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_is_raw", String.valueOf(paramPicUploadInfo.jdField_g_of_type_Int));
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_batch_count", String.valueOf(paramPicUploadInfo.jdField_e_of_type_Long));
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_photo_index", String.valueOf(paramPicUploadInfo.jdField_f_of_type_Long));
      }
      if (paramPicUploadInfo.jdField_i_of_type_Boolean) {
        paramMessageForPic.isStoryPhoto = true;
      }
      PicMessageExtraData localPicMessageExtraData2 = paramMessageForPic.picExtraData;
      localPicMessageExtraData1 = localPicMessageExtraData2;
      if (localPicMessageExtraData2 == null) {
        localPicMessageExtraData1 = new PicMessageExtraData();
      }
      if (!paramPicUploadInfo.d()) {
        break label215;
      }
      localPicMessageExtraData1.imageBizType = 13;
    }
    for (;;)
    {
      paramMessageForPic.picExtraData = localPicMessageExtraData1;
      return;
      if (paramPicUploadInfo.jdField_b_of_type_Int != 1) {
        break;
      }
      ConfessMsgUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic, paramPicUploadInfo.jdField_c_of_type_JavaLangString);
      break;
      label215:
      if (paramPicUploadInfo.e()) {
        localPicMessageExtraData1.imageBizType = 2;
      }
    }
  }
  
  public void a(PicReq paramPicReq)
  {
    Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "sendPic.start", "");
    if (a(paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo))
    {
      b(paramPicReq);
      return;
    }
    a(3, paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo);
  }
  
  protected void a(PicReq paramPicReq, MessageRecord paramMessageRecord, PicUploadInfo paramPicUploadInfo)
  {
    PicMessageExtraData localPicMessageExtraData;
    if (paramPicReq.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData != null)
    {
      ((MessageForPic)paramMessageRecord).picExtraData = paramPicReq.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData;
      localPicMessageExtraData = paramPicReq.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData;
      if (localPicMessageExtraData.stickerInfo != null) {
        paramMessageRecord.saveExtInfoToExtStr("sticker_info", localPicMessageExtraData.stickerInfo.toJsonString());
      }
      if (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("sticker_info")))
      {
        EmojiStickerManager.a(paramMessageRecord, null);
        EmojiStickerManager.a().a(paramMessageRecord);
      }
    }
    if (((MessageForPic)paramMessageRecord).checkGif())
    {
      localPicMessageExtraData = ((MessageForPic)paramMessageRecord).picExtraData;
      if (localPicMessageExtraData != null) {
        break label367;
      }
      localPicMessageExtraData = new PicMessageExtraData();
    }
    label364:
    label367:
    for (;;)
    {
      if (TextUtils.isEmpty(localPicMessageExtraData.textSummary)) {
        localPicMessageExtraData.textSummary = BaseApplicationImpl.getApplication().getString(2131691358);
      }
      localPicMessageExtraData.emojiPkgId = String.valueOf(paramPicUploadInfo.s);
      localPicMessageExtraData.from = paramPicUploadInfo.r;
      localPicMessageExtraData.source = paramPicUploadInfo.k;
      localPicMessageExtraData.webUrl = paramPicUploadInfo.l;
      localPicMessageExtraData.iconUrl = paramPicUploadInfo.m;
      localPicMessageExtraData.packageName = paramPicUploadInfo.jdField_n_of_type_JavaLangString;
      if ((localPicMessageExtraData.imageBizType <= 0) && ((paramPicReq.jdField_b_of_type_Int == 1050) || (paramPicReq.jdField_b_of_type_Int == 1051) || (paramPicReq.jdField_b_of_type_Int == 1052))) {
        localPicMessageExtraData.imageBizType = 11;
      }
      ((MessageForPic)paramMessageRecord).picExtraData = localPicMessageExtraData;
      if ((paramPicUploadInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadExtra != null) && (!TextUtils.isEmpty(paramPicUploadInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadExtra.jdField_a_of_type_JavaLangString)))
      {
        localPicMessageExtraData = ((MessageForPic)paramMessageRecord).picExtraData;
        if (localPicMessageExtraData != null) {
          break label364;
        }
        localPicMessageExtraData = new PicMessageExtraData();
      }
      for (;;)
      {
        localPicMessageExtraData.mTemplateId = paramPicUploadInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadExtra.jdField_a_of_type_JavaLangString;
        localPicMessageExtraData.mTemplateName = paramPicUploadInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadExtra.jdField_b_of_type_JavaLangString;
        ((MessageForPic)paramMessageRecord).picExtraData = localPicMessageExtraData;
        if (paramPicReq.jdField_b_of_type_Int == 1053)
        {
          paramPicUploadInfo = ((MessageForPic)paramMessageRecord).picExtraData;
          paramPicReq = paramPicUploadInfo;
          if (paramPicUploadInfo == null) {
            paramPicReq = new PicMessageExtraData();
          }
          paramPicReq.imageBizType = 14;
          ((MessageForPic)paramMessageRecord).picExtraData = paramPicReq;
        }
        return;
      }
    }
  }
  
  public void a(UpCallBack.SendResult paramSendResult)
  {
    if (paramSendResult != null)
    {
      Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "updateMsg", "resut:" + paramSendResult);
      MessageForPic localMessageForPic = (MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localMessageForPic.size = paramSendResult.jdField_a_of_type_Long;
      localMessageForPic.uuid = paramSendResult.jdField_c_of_type_JavaLangString;
      localMessageForPic.groupFileID = paramSendResult.jdField_b_of_type_Long;
      localMessageForPic.md5 = paramSendResult.jdField_d_of_type_JavaLangString;
      localMessageForPic.serial();
      b(localMessageForPic);
    }
  }
  
  protected boolean a(PicUploadInfo paramPicUploadInfo)
  {
    if (paramPicUploadInfo != null)
    {
      Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkPicUploadInfo", "info:" + paramPicUploadInfo);
      return paramPicUploadInfo.a();
    }
    Logger.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkPicUploadInfo", "info == null");
    return false;
  }
  
  void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().preConnect();
  }
  
  void b(MessageForPic paramMessageForPic)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, paramMessageForPic.msgData);
  }
  
  protected void b(PicReq paramPicReq)
  {
    PicUploadInfo localPicUploadInfo = paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo;
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManagerV2.excute(new UploadPicOperator.1(this, paramPicReq, localPicUploadInfo), 16, null, false);
      return;
    }
    a(paramPicReq, localPicUploadInfo);
  }
  
  void b(PicUploadInfo paramPicUploadInfo, MessageForPic paramMessageForPic)
  {
    Object localObject = new File(paramPicUploadInfo.jdField_g_of_type_JavaLangString);
    if (((File)localObject).exists()) {
      if (!GifDrawable.isGifFile((File)localObject)) {
        break label188;
      }
    }
    label188:
    for (paramMessageForPic.imageType = 2000;; paramMessageForPic.imageType = PeakUtils.a(paramPicUploadInfo.jdField_g_of_type_JavaLangString))
    {
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      ((BitmapFactory.Options)localObject).inSampleSize = 1;
      SafeBitmapFactory.decodeFile(paramPicUploadInfo.jdField_g_of_type_JavaLangString, (BitmapFactory.Options)localObject);
      paramMessageForPic.width = ((BitmapFactory.Options)localObject).outWidth;
      paramMessageForPic.height = ((BitmapFactory.Options)localObject).outHeight;
      if (RichMediaUtil.isPicLandscape(paramPicUploadInfo.jdField_g_of_type_JavaLangString))
      {
        paramMessageForPic.width = ((BitmapFactory.Options)localObject).outHeight;
        paramMessageForPic.height = ((BitmapFactory.Options)localObject).outWidth;
        if (QLog.isColorLevel()) {
          Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "packMsg", " pic is Landscape,swap w,h; options.outWidth = " + ((BitmapFactory.Options)localObject).outWidth + ",options.outHeight = " + ((BitmapFactory.Options)localObject).outHeight + ",mr.width = " + paramMessageForPic.width + ",mr.height = " + paramMessageForPic.height);
        }
      }
      return;
    }
  }
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    if (paramSendResult == null) {
      a(3, null);
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqPicPicReq == null) || ((this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_Int != 2) && (this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_Int != 4))) {
      return;
    }
    if (paramSendResult.jdField_a_of_type_Int == 0)
    {
      a(paramSendResult);
      c(paramSendResult);
      localObject = new PicResult();
      ((PicResult)localObject).jdField_a_of_type_Int = 0;
      ((PicResult)localObject).jdField_a_of_type_JavaLangObject = paramSendResult;
      a(3, (PicResult)localObject);
      return;
    }
    Object localObject = new PicInfoInterface.ErrInfo();
    ((PicInfoInterface.ErrInfo)localObject).jdField_b_of_type_JavaLangString = paramSendResult.jdField_a_of_type_JavaLangString;
    a(3, (PicInfoInterface.ErrInfo)localObject);
  }
  
  void c(PicUploadInfo paramPicUploadInfo, MessageForPic paramMessageForPic)
  {
    if (GeneralConfigUtils.a())
    {
      paramMessageForPic.bigThumbMsgUrl = paramPicUploadInfo.h;
      return;
    }
    paramMessageForPic.thumbMsgUrl = paramPicUploadInfo.h;
  }
  
  void c(UpCallBack.SendResult paramSendResult)
  {
    PicStatisticsManager localPicStatisticsManager = (PicStatisticsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PICTURE_STATISTICS_MANAGER);
    if (localPicStatisticsManager != null) {
      localPicStatisticsManager.a(13057, paramSendResult.jdField_a_of_type_Long);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.UploadPicOperator
 * JD-Core Version:    0.7.0.1
 */