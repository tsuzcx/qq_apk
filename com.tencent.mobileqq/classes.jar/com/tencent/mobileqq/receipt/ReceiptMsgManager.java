package com.tencent.mobileqq.receipt;

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
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade.SendMsgParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout29;
import com.tencent.mobileqq.structmsg.view.StructMsgItemType;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
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
  private static ReceiptMsgManager b;
  public MessageForPtt a;
  private Map<String, Boolean> c;
  private SparseArray<Bitmap> d = new SparseArray(8);
  private HashMap<String, String> e = new HashMap();
  
  private Bitmap a(Resources paramResources, int paramInt)
  {
    int i = AIOUtils.b(10.0F, paramResources);
    int j = AIOUtils.b(8.0F, paramResources);
    int k = AIOUtils.b(175.0F, paramResources);
    int m = AIOUtils.b(240.0F, paramResources);
    int n = AIOUtils.b(108.0F, paramResources);
    Bitmap localBitmap1 = c(paramResources, paramInt);
    Bitmap localBitmap2 = BitmapFactory.decodeResource(paramResources, 2130838232);
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
    if (b == null) {
      try
      {
        if (b == null) {
          b = new ReceiptMsgManager();
        }
      }
      finally {}
    }
    return b;
  }
  
  private AbsShareMsg a(int paramInt)
  {
    AbsShareMsg localAbsShareMsg = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(107).a(BaseApplicationImpl.getContext().getString(2131896505)).a(3).a("viewReceiptMessage", "", null, null, null).a();
    StructMsgItemLayout29 localStructMsgItemLayout29 = new StructMsgItemLayout29();
    StructMsgItemType localStructMsgItemType = new StructMsgItemType();
    localStructMsgItemType.au = paramInt;
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
    localObject1 = "";
    long l = System.currentTimeMillis();
    try
    {
      try
      {
        localObject2 = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
        paramString = (String)localObject2;
      }
      catch (OutOfMemoryError paramString)
      {
        paramString.printStackTrace();
        paramString = (String)localObject1;
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      Object localObject2;
      label34:
      break label34;
    }
    localObject2 = new File(paramString);
    paramString = (String)localObject1;
    if (((File)localObject2).exists()) {}
    try
    {
      paramString = MD5FileUtil.a((File)localObject2);
      if (paramString == null) {
        paramString = "";
      }
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        paramString = (String)localObject1;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("md5:");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(",cost:");
      ((StringBuilder)localObject1).append(System.currentTimeMillis() - l);
      QLog.d("ReceiptMsgManager", 2, new Object[] { "calcMD5", ((StringBuilder)localObject1).toString() });
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
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("ReceiptMsgManager", 2, "create pic msg error");
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ArrayList<ChatMessage> paramArrayList, @Nonnull Bundle paramBundle)
  {
    ThreadManager.post(new ReceiptMsgManager.2(this, paramArrayList, paramBundle, paramQQAppInterface, paramSessionInfo), 8, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString)
  {
    if (paramMessageRecord != null)
    {
      paramMessageRecord.saveExtInfoToExtStr("receipt_msg_is_read", paramString);
      paramQQAppInterface.getMessageFacade().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq, "extStr", paramMessageRecord.extStr);
      paramQQAppInterface.getMessageFacade().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq, "extLong", Integer.valueOf(paramMessageRecord.extLong));
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, AbsStructMsg paramAbsStructMsg, boolean paramBoolean, ArrayList<ChatMessage> paramArrayList, @Nullable Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReceiptMsgManager", 4, " sendReceiptMsg start");
    }
    paramString2 = this.e;
    paramAbsStructMsg = ShareMsgHelper.a(paramQQAppInterface, paramString1, paramInt, paramAbsStructMsg);
    if (paramAbsStructMsg != null)
    {
      paramAbsStructMsg.isReMultiMsg = true;
      if (paramBoolean) {
        paramQQAppInterface.getMessageFacade().h(paramString1, paramInt, 0L);
      }
      MultiMsgManager.a().a(paramQQAppInterface, paramString1, paramInt, paramArrayList, paramString2, paramAbsStructMsg, 5, paramBundle);
    }
  }
  
  private void a(MessageForPic paramMessageForPic, int paramInt)
  {
    CompressInfo localCompressInfo = new CompressInfo(paramMessageForPic.path, ((ICompressOperator)QRoute.api(ICompressOperator.class)).transformQuality(paramInt), 1009);
    ((ICompressOperator)QRoute.api(ICompressOperator.class)).start(localCompressInfo);
    paramMessageForPic.path = localCompressInfo.l;
    paramMessageForPic.size = FileUtil.f(paramMessageForPic.path);
  }
  
  private Bitmap b(Resources paramResources, int paramInt)
  {
    int i = AIOUtils.b(10.0F, paramResources);
    int j = AIOUtils.b(8.0F, paramResources);
    int k = AIOUtils.b(245.0F, paramResources);
    int m = AIOUtils.b(108.0F, paramResources);
    Bitmap localBitmap1 = c(paramResources, paramInt);
    Bitmap localBitmap2 = BitmapFactory.decodeResource(paramResources, 2130838231);
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
    int i = paramMessageRecord.istroop;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 3000) {
          str = ContactUtils.a(paramQQAppInterface, paramMessageRecord.frienduin, paramMessageRecord.senderuin);
        }
      }
      else {
        str = ContactUtils.b(paramQQAppInterface, paramMessageRecord.frienduin, paramMessageRecord.senderuin);
      }
    }
    else {
      str = ContactUtils.a(paramQQAppInterface, paramMessageRecord.senderuin, false);
    }
    d(paramQQAppInterface, paramMessageRecord, str);
  }
  
  private Bitmap c(Resources paramResources, int paramInt)
  {
    if (paramInt != 2)
    {
      if (paramInt != 3) {
        return BitmapFactory.decodeResource(paramResources, 2130838238);
      }
      return BitmapFactory.decodeResource(paramResources, 2130838234);
    }
    return BitmapFactory.decodeResource(paramResources, 2130838233);
  }
  
  private static void c(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString)
  {
    paramMessageRecord.saveExtInfoToExtStr("receipt_pic_size_spec", paramString);
    paramQQAppInterface.getMessageFacade().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq, "extStr", paramMessageRecord.extStr);
    paramQQAppInterface.getMessageFacade().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq, "extLong", Integer.valueOf(paramMessageRecord.extLong));
  }
  
  private void d(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString)
  {
    Object localObject = String.format(BaseApplicationImpl.getContext().getString(2131896520), new Object[] { paramString });
    paramString = new MessageForUniteGrayTip();
    localObject = new UniteGrayTipParam(paramMessageRecord.frienduin, paramMessageRecord.senderuin, (String)localObject, paramMessageRecord.istroop, -5022, 3211265, paramMessageRecord.time);
    ((UniteGrayTipParam)localObject).q = false;
    paramString.initGrayTipMsg(paramQQAppInterface, (UniteGrayTipParam)localObject);
    paramString.msgUid = paramMessageRecord.msgUid;
    paramString.shmsgseq = paramMessageRecord.shmsgseq;
    UniteGrayTipMsgUtil.a(paramQQAppInterface, paramString);
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800859B", "0X800859B", 0, 0, "", "", "", "");
  }
  
  public Bitmap a(Resources paramResources, boolean paramBoolean, int paramInt)
  {
    int i;
    if (paramBoolean) {
      i = 1000;
    } else {
      i = 2000;
    }
    i += paramInt;
    try
    {
      Bitmap localBitmap = (Bitmap)this.d.get(i);
      if (localBitmap != null) {
        return localBitmap;
      }
      if (paramBoolean) {
        paramResources = a(paramResources, paramInt);
      } else {
        paramResources = b(paramResources, paramInt);
      }
      this.d.put(i, paramResources);
      return paramResources;
    }
    finally {}
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseSessionInfo paramBaseSessionInfo, String paramString, ArrayList<AtTroopMemberInfo> paramArrayList, ChatActivityFacade.SendMsgParams paramSendMsgParams)
  {
    ArrayList localArrayList = new ArrayList(1);
    paramString = ChatActivityFacade.a(paramQQAppInterface, (SessionInfo)paramBaseSessionInfo, paramString, paramArrayList, paramSendMsgParams);
    if (paramString != null)
    {
      localArrayList.add(paramString);
      a(paramQQAppInterface, paramBaseSessionInfo.b, paramBaseSessionInfo.a, paramBaseSessionInfo.c, a(1), false, localArrayList, null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("ReceiptMsgManager", 2, "create text msg error");
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, int paramInt1, int paramInt2, RecordParams.RecorderParam paramRecorderParam, int paramInt3, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendPttMsg: ");
      localStringBuilder.append(this.a.toString());
      QLog.d("ReceiptMsgManager", 2, localStringBuilder.toString());
    }
    ThreadManager.post(new ReceiptMsgManager.1(this, paramInt2, paramInt3, paramRecorderParam, paramString, paramInt1, paramBoolean, paramQQAppInterface, paramSessionInfo), 8, null, false);
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, List<String> paramList, int paramInt)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a(paramQQAppInterface, paramSessionInfo, (String)paramList.next(), paramInt);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("receipt_gray_tip_showed-");
    ((StringBuilder)localObject1).append(paramMessageRecord.istroop);
    localObject1 = ((StringBuilder)localObject1).toString();
    if (this.c == null) {
      this.c = new HashMap(3);
    }
    Object localObject2 = this.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    localStringBuilder.append((String)localObject1);
    if (((Map)localObject2).get(localStringBuilder.toString()) != null)
    {
      if (QLog.isColorLevel())
      {
        paramMessageRecord = new StringBuilder();
        paramMessageRecord.append("mGrayTipsShowedMap has key: ");
        paramMessageRecord.append(paramQQAppInterface.getCurrentAccountUin());
        paramMessageRecord.append((String)localObject1);
        QLog.d("ReceiptMsgManager", 2, paramMessageRecord.toString());
      }
      return;
    }
    localObject2 = paramQQAppInterface.getPreferences();
    boolean bool = ((SharedPreferences)localObject2).getBoolean((String)localObject1, false);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("addGrayTipIfNeeded hasShowed: ");
      localStringBuilder.append(bool);
      localStringBuilder.append(" with key: ");
      localStringBuilder.append((String)localObject1);
      QLog.d("ReceiptMsgManager", 2, localStringBuilder.toString());
    }
    if (!bool)
    {
      ThreadManager.postImmediately(new ReceiptMsgManager.3(this, paramQQAppInterface, paramMessageRecord), null, false);
      paramMessageRecord = this.c;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
      localStringBuilder.append((String)localObject1);
      paramMessageRecord.put(localStringBuilder.toString(), Boolean.valueOf(true));
      ((SharedPreferences)localObject2).edit().putBoolean((String)localObject1, true).apply();
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, long paramLong, int paramInt2, DownCallBack paramDownCallBack)
  {
    MultiMsgManager.a().a(paramQQAppInterface, paramString1, paramString2, paramString3, paramString4, paramInt1, paramLong, 1035, paramDownCallBack);
  }
  
  public void b()
  {
    try
    {
      this.d.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMsgManager
 * JD-Core Version:    0.7.0.1
 */