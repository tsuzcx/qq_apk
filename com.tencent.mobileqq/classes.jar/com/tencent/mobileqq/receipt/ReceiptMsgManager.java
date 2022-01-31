package com.tencent.mobileqq.receipt;

import ahfg;
import ahfh;
import ahfi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade.SendMsgParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout29;
import com.tencent.mobileqq.structmsg.view.StructMsgItemType;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;

public class ReceiptMsgManager
{
  private static ReceiptMsgManager jdField_a_of_type_ComTencentMobileqqReceiptReceiptMsgManager;
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(8);
  public MessageForPtt a;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Map jdField_a_of_type_JavaUtilMap;
  
  private Bitmap a(Resources paramResources, int paramInt)
  {
    int i = AIOUtils.a(10.0F, paramResources);
    int j = AIOUtils.a(8.0F, paramResources);
    int k = AIOUtils.a(175.0F, paramResources);
    int m = AIOUtils.a(240.0F, paramResources);
    int n = AIOUtils.a(108.0F, paramResources);
    Bitmap localBitmap1 = c(paramResources, paramInt);
    Bitmap localBitmap2 = BitmapFactory.decodeResource(paramResources, 2130837732);
    Canvas localCanvas = new Canvas();
    Bitmap localBitmap3 = Bitmap.createBitmap(m, n, Bitmap.Config.ARGB_8888);
    localBitmap3.setDensity(paramResources.getDisplayMetrics().densityDpi);
    localCanvas.setBitmap(localBitmap3);
    paramResources = new Paint();
    localCanvas.drawBitmap(localBitmap2, k, 0.0F, paramResources);
    localCanvas.drawBitmap(localBitmap1, i, j, paramResources);
    localBitmap1.recycle();
    localBitmap2.recycle();
    return localBitmap3;
  }
  
  public static ReceiptMsgManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqReceiptReceiptMsgManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqReceiptReceiptMsgManager == null) {
        jdField_a_of_type_ComTencentMobileqqReceiptReceiptMsgManager = new ReceiptMsgManager();
      }
      return jdField_a_of_type_ComTencentMobileqqReceiptReceiptMsgManager;
    }
    finally {}
  }
  
  private AbsShareMsg a(int paramInt)
  {
    AbsShareMsg localAbsShareMsg = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).b(107).a(BaseApplicationImpl.getContext().getString(2131438976)).a(3).a("viewReceiptMessage", "", null, null, null).a();
    StructMsgItemLayout29 localStructMsgItemLayout29 = new StructMsgItemLayout29();
    StructMsgItemType localStructMsgItemType = new StructMsgItemType();
    localStructMsgItemType.e = paramInt;
    localStructMsgItemLayout29.a(localStructMsgItemType);
    localAbsShareMsg.addItem(localStructMsgItemLayout29);
    return localAbsShareMsg;
  }
  
  public static String a(MessageRecord paramMessageRecord)
  {
    return paramMessageRecord.getExtInfoFromExtStr("receipt_msg_is_read");
  }
  
  private String a(String paramString)
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
    if (QLog.isColorLevel()) {
      QLog.d("ReceiptMsgManager", 2, new Object[] { "calcMD5", "md5:" + paramString + ",cost:" + (System.currentTimeMillis() - l) });
    }
    return paramString;
  }
  
  private void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, int paramInt)
  {
    Object localObject = ChatActivityFacade.a(paramQQAppInterface, paramSessionInfo, paramString);
    paramString = new ArrayList(1);
    if (localObject != null)
    {
      paramString.add(localObject);
      localObject = new Bundle();
      ((Bundle)localObject).putInt("ReceiptMsgManager.EXTRA_KEY_PHOTO_SIZE_SPEC", paramInt);
      a(paramQQAppInterface, paramSessionInfo, paramString, (Bundle)localObject);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.w("ReceiptMsgManager", 2, "create pic msg error");
  }
  
  private void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ArrayList paramArrayList, @Nonnull Bundle paramBundle)
  {
    ThreadManager.post(new ahfh(this, paramArrayList, paramBundle, paramQQAppInterface, paramSessionInfo), 8, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString)
  {
    paramMessageRecord.saveExtInfoToExtStr("receipt_msg_is_read", paramString);
    paramQQAppInterface.a().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq, "extStr", paramMessageRecord.extStr);
    paramQQAppInterface.a().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq, "extLong", Integer.valueOf(paramMessageRecord.extLong));
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, AbsStructMsg paramAbsStructMsg, boolean paramBoolean, ArrayList paramArrayList, @Nullable Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReceiptMsgManager", 4, " sendReceiptMsg start");
    }
    paramString2 = this.jdField_a_of_type_JavaUtilHashMap;
    paramAbsStructMsg = ShareMsgHelper.a(paramQQAppInterface, paramString1, paramInt, paramAbsStructMsg);
    if (paramAbsStructMsg != null)
    {
      paramAbsStructMsg.isReMultiMsg = true;
      if (paramBoolean) {
        paramQQAppInterface.a().b(paramString1, paramInt, 0L);
      }
      MultiMsgManager.a().a(paramQQAppInterface, paramString1, paramInt, paramArrayList, paramString2, paramAbsStructMsg, 5, paramBundle);
    }
  }
  
  private void a(MessageForPic paramMessageForPic, int paramInt)
  {
    CompressInfo localCompressInfo = new CompressInfo(paramMessageForPic.path, CompressOperator.a(paramInt), 1009);
    CompressOperator.a(localCompressInfo);
    paramMessageForPic.path = localCompressInfo.e;
    paramMessageForPic.size = FileUtil.a(paramMessageForPic.path);
  }
  
  private Bitmap b(Resources paramResources, int paramInt)
  {
    int i = AIOUtils.a(10.0F, paramResources);
    int j = AIOUtils.a(8.0F, paramResources);
    int k = AIOUtils.a(245.0F, paramResources);
    int m = AIOUtils.a(108.0F, paramResources);
    Bitmap localBitmap1 = c(paramResources, paramInt);
    Bitmap localBitmap2 = BitmapFactory.decodeResource(paramResources, 2130837731);
    Canvas localCanvas = new Canvas();
    Bitmap localBitmap3 = Bitmap.createBitmap(k, m, Bitmap.Config.ARGB_8888);
    localBitmap3.setDensity(paramResources.getDisplayMetrics().densityDpi);
    localCanvas.setBitmap(localBitmap3);
    paramResources = new Paint();
    localCanvas.drawBitmap(localBitmap2, 0.0F, 0.0F, paramResources);
    localCanvas.drawBitmap(localBitmap1, i, j, paramResources);
    localBitmap1.recycle();
    localBitmap2.recycle();
    return localBitmap3;
  }
  
  public static String b(MessageRecord paramMessageRecord)
  {
    return paramMessageRecord.getExtInfoFromExtStr("receipt_pic_size_spec");
  }
  
  private void b(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    String str = paramMessageRecord.senderuin;
    switch (paramMessageRecord.istroop)
    {
    }
    for (;;)
    {
      d(paramQQAppInterface, paramMessageRecord, str);
      return;
      str = ContactUtils.b(paramQQAppInterface, paramMessageRecord.senderuin, false);
      continue;
      str = ContactUtils.g(paramQQAppInterface, paramMessageRecord.frienduin, paramMessageRecord.senderuin);
      continue;
      str = ContactUtils.a(paramQQAppInterface, paramMessageRecord.frienduin, paramMessageRecord.senderuin);
    }
  }
  
  private Bitmap c(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return BitmapFactory.decodeResource(paramResources, 2130837735);
    case 2: 
      return BitmapFactory.decodeResource(paramResources, 2130837733);
    }
    return BitmapFactory.decodeResource(paramResources, 2130837734);
  }
  
  private static void c(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString)
  {
    paramMessageRecord.saveExtInfoToExtStr("receipt_pic_size_spec", paramString);
    paramQQAppInterface.a().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq, "extStr", paramMessageRecord.extStr);
    paramQQAppInterface.a().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq, "extLong", Integer.valueOf(paramMessageRecord.extLong));
  }
  
  private void d(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString)
  {
    Object localObject = String.format(BaseApplicationImpl.getContext().getString(2131439006), new Object[] { paramString });
    paramString = new MessageForUniteGrayTip();
    localObject = new UniteGrayTipParam(paramMessageRecord.frienduin, paramMessageRecord.senderuin, (String)localObject, paramMessageRecord.istroop, -5022, 3211265, paramMessageRecord.time);
    ((UniteGrayTipParam)localObject).f = false;
    paramString.initGrayTipMsg(paramQQAppInterface, (UniteGrayTipParam)localObject);
    paramString.msgUid = paramMessageRecord.msgUid;
    paramString.shmsgseq = paramMessageRecord.shmsgseq;
    UniteGrayTipUtil.a(paramQQAppInterface, paramString);
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800859B", "0X800859B", 0, 0, "", "", "", "");
  }
  
  public Bitmap a(Resources paramResources, boolean paramBoolean, int paramInt)
  {
    int i;
    if (paramBoolean)
    {
      i = 1000;
      i += paramInt;
    }
    for (;;)
    {
      try
      {
        Bitmap localBitmap = (Bitmap)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
        if (localBitmap != null)
        {
          paramResources = localBitmap;
          return paramResources;
          i = 2000;
          break;
        }
        if (paramBoolean)
        {
          paramResources = a(paramResources, paramInt);
          this.jdField_a_of_type_AndroidUtilSparseArray.put(i, paramResources);
        }
        else
        {
          paramResources = b(paramResources, paramInt);
        }
      }
      finally {}
    }
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_AndroidUtilSparseArray.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, int paramInt1, int paramInt2, QQRecorder.RecorderParam paramRecorderParam, int paramInt3, boolean paramBoolean)
  {
    if (!QLog.isColorLevel()) {}
    for (;;)
    {
      ThreadManager.post(new ahfg(this, paramInt2, paramInt3, paramRecorderParam, paramString, paramInt1, paramBoolean, paramQQAppInterface, paramSessionInfo), 8, null, false);
      return;
      QLog.d("ReceiptMsgManager", 2, "sendPttMsg: " + this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.toString());
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, ArrayList paramArrayList, ChatActivityFacade.SendMsgParams paramSendMsgParams)
  {
    ArrayList localArrayList = new ArrayList(1);
    paramString = ChatActivityFacade.a(paramQQAppInterface, paramSessionInfo, paramString, paramArrayList, paramSendMsgParams);
    if (paramString != null)
    {
      localArrayList.add(paramString);
      a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.b, a(1), false, localArrayList, null);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.w("ReceiptMsgManager", 2, "create text msg error");
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, List paramList, int paramInt)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a(paramQQAppInterface, paramSessionInfo, (String)paramList.next(), paramInt);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    String str = "receipt_gray_tip_showed-" + paramMessageRecord.istroop;
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      this.jdField_a_of_type_JavaUtilMap = new HashMap(3);
    }
    if (this.jdField_a_of_type_JavaUtilMap.get(paramQQAppInterface.getCurrentAccountUin() + str) != null) {
      if (QLog.isColorLevel()) {
        QLog.d("ReceiptMsgManager", 2, "mGrayTipsShowedMap has key: " + paramQQAppInterface.getCurrentAccountUin() + str);
      }
    }
    SharedPreferences localSharedPreferences;
    boolean bool;
    do
    {
      return;
      localSharedPreferences = paramQQAppInterface.getPreferences();
      bool = localSharedPreferences.getBoolean(str, false);
      if (QLog.isColorLevel()) {
        QLog.d("ReceiptMsgManager", 2, "addGrayTipIfNeeded hasShowed: " + bool + " with key: " + str);
      }
    } while (bool);
    ThreadManager.postImmediately(new ahfi(this, paramQQAppInterface, paramMessageRecord), null, false);
    this.jdField_a_of_type_JavaUtilMap.put(paramQQAppInterface.getCurrentAccountUin() + str, Boolean.valueOf(true));
    localSharedPreferences.edit().putBoolean(str, true).apply();
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, long paramLong, int paramInt2, DownCallBack paramDownCallBack)
  {
    MultiMsgManager.a().a(paramQQAppInterface, paramString1, paramString2, paramString3, paramString4, paramInt1, paramLong, 1035, paramDownCallBack);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMsgManager
 * JD-Core Version:    0.7.0.1
 */