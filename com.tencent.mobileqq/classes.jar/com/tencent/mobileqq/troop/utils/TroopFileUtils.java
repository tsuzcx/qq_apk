package com.tencent.mobileqq.troop.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseIntArray;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.forward.ForwardOrderManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopFileData;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.troop.data.TroopFileInfo;>;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import org.json.JSONObject;
import tencent.im.msg.obj_msg.MsgContentInfo;
import tencent.im.msg.obj_msg.MsgContentInfo.MsgFile;
import tencent.im.msg.obj_msg.ObjMsg;

public class TroopFileUtils
{
  public static int a = 48;
  private static String[] b = { "\\", "/", ":", "*", "?", "\"", "<", ">", "|" };
  private static boolean c = false;
  
  public static int a(long paramLong1, long paramLong2)
  {
    if (paramLong2 == 0L) {
      return 0;
    }
    long l1 = paramLong1;
    long l2 = paramLong2;
    if (paramLong1 > paramLong2)
    {
      l1 = paramLong2;
      l2 = paramLong2;
    }
    while (l2 > 2147483647L)
    {
      l2 >>= 1;
      l1 >>= 1;
    }
    double d1 = l1;
    double d2 = l2;
    Double.isNaN(d1);
    Double.isNaN(d2);
    return (int)(d1 / d2 * 100.0D);
  }
  
  public static int a(Context paramContext)
  {
    int i = NetworkUtil.getSystemNetwork(paramContext);
    if (i == 0) {
      return 0;
    }
    if ((2 != i) && (3 != i) && (4 != i)) {
      return 2;
    }
    return 1;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, Context paramContext, long paramLong)
  {
    int i = a(paramContext);
    if (i == 0) {
      TroopFileError.a(paramQQAppInterface, paramLong, 106);
    }
    return i;
  }
  
  public static long a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, long paramLong1, String paramString3, int paramInt, String paramString4, long paramLong2)
  {
    return a(paramQQAppInterface, paramString1, paramString2, paramLong1, paramString3, paramInt, paramString4, paramLong2, 0, 0);
  }
  
  public static long a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, long paramLong1, String paramString3, int paramInt1, String paramString4, long paramLong2, int paramInt2, int paramInt3)
  {
    return a(paramQQAppInterface, paramString1, paramString2, paramLong1, paramString3, paramInt1, paramString4, paramLong2, paramInt2, paramInt3, 0);
  }
  
  public static long a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, long paramLong1, String paramString3, int paramInt1, String paramString4, long paramLong2, int paramInt2, int paramInt3, int paramInt4)
  {
    return a(paramQQAppInterface, paramString1, paramString2, paramLong1, paramString3, paramInt1, paramString4, paramLong2, paramInt2, paramInt3, paramInt4, 0L, 0);
  }
  
  public static long a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, long paramLong1, String paramString3, int paramInt1, String paramString4, long paramLong2, int paramInt2, int paramInt3, int paramInt4, long paramLong3, int paramInt5)
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(-2017);
    ForwardOrderManager.a().a(localMessageRecord.uniseq, paramLong3, paramInt5);
    localMessageRecord.selfuin = paramQQAppInterface.getCurrentAccountUin();
    localMessageRecord.frienduin = paramString1;
    localMessageRecord.senderuin = paramQQAppInterface.getCurrentAccountUin();
    localMessageRecord.msgUid = MessageUtils.a(paramInt1);
    localMessageRecord.msg = MsgUtils.a(null);
    localMessageRecord.msgtype = -2017;
    localMessageRecord.isread = true;
    localMessageRecord.issend = 1;
    localMessageRecord.istroop = 1;
    paramString1 = paramQQAppInterface.getMessageFacade().o(localMessageRecord.senderuin, 1);
    if ((paramString1 != null) && (!paramString1.isEmpty())) {
      localMessageRecord.shmsgseq = ((ChatMessage)paramString1.get(paramString1.size() - 1)).shmsgseq;
    } else {
      localMessageRecord.shmsgseq = Math.abs(new Random().nextInt());
    }
    localMessageRecord.time = MessageCache.c();
    paramString1 = (MessageForTroopFile)localMessageRecord;
    paramString1.fileName = paramString2;
    paramString1.uuid = paramString3;
    paramString1.fileSize = paramLong1;
    paramString1.FromUin = paramString4;
    paramString1.entitySessionId = paramLong2;
    paramString1.width = paramInt2;
    paramString1.height = paramInt3;
    paramString1.duration = paramInt4;
    if (localMessageRecord.isSend()) {
      ((ISVIPHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(localMessageRecord);
    }
    paramString1.serial();
    ThreadManager.post(new TroopFileUtils.1(paramQQAppInterface, localMessageRecord), 8, null, false);
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("Inser msg to AIO, msgInfo: mrUinseq[");
    paramQQAppInterface.append(String.valueOf(localMessageRecord.uniseq));
    paramQQAppInterface.append("], selfuin[");
    paramQQAppInterface.append(FileManagerUtil.k(localMessageRecord.selfuin));
    paramQQAppInterface.append("], frienduin[");
    paramQQAppInterface.append(FileManagerUtil.k(localMessageRecord.frienduin));
    paramQQAppInterface.append("], senderuin[");
    paramQQAppInterface.append(FileManagerUtil.k(localMessageRecord.senderuin));
    paramQQAppInterface.append("], issend[");
    paramQQAppInterface.append(String.valueOf(localMessageRecord.issend));
    paramQQAppInterface.append("], istroop[");
    paramQQAppInterface.append(String.valueOf(localMessageRecord.istroop));
    paramQQAppInterface.append("], shmsgseq[");
    paramQQAppInterface.append(String.valueOf(localMessageRecord.shmsgseq));
    paramQQAppInterface.append("], msgUid[");
    paramQQAppInterface.append(String.valueOf(localMessageRecord.msgUid));
    paramQQAppInterface.append("], time[");
    paramQQAppInterface.append(String.valueOf(localMessageRecord.time));
    paramQQAppInterface.append("], vipBubbleID[");
    paramQQAppInterface.append(String.valueOf(-1));
    paramQQAppInterface.append("]");
    QLog.i("TroopFile", 1, paramQQAppInterface.toString());
    return localMessageRecord.uniseq;
  }
  
  public static long a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, long paramLong1, String paramString3, int paramInt1, String paramString4, long paramLong2, int paramInt2, int paramInt3, long paramLong3, int paramInt4)
  {
    return a(paramQQAppInterface, paramString1, paramString2, paramLong1, paramString3, paramInt1, paramString4, paramLong2, paramInt2, paramInt3, 0, paramLong3, paramInt4);
  }
  
  public static long a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, long paramLong1, String paramString3, int paramInt1, String paramString4, long paramLong2, long paramLong3, int paramInt2)
  {
    return a(paramQQAppInterface, paramString1, paramString2, paramLong1, paramString3, paramInt1, paramString4, paramLong2, 0, 0, paramLong3, paramInt2);
  }
  
  public static Bitmap a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt2 < paramInt1) {
      i = paramInt2;
    } else {
      i = paramInt1;
    }
    Object localObject = ImageUtil.a(paramString, i);
    try
    {
      paramString = ImageUtil.a(paramString, (BitmapFactory.Options)localObject);
    }
    catch (OutOfMemoryError paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopFile", 2, "", paramString);
      }
      paramString = null;
    }
    if (paramString == null) {
      return null;
    }
    int i = paramString.getWidth();
    int j = paramString.getHeight();
    if (i > 0)
    {
      if (j <= 0) {
        return null;
      }
      if ((i <= paramInt1) && (j <= paramInt2)) {
        return paramString;
      }
      float f = Math.max(paramInt1 / i, paramInt2 / j);
      localObject = new Matrix();
      ((Matrix)localObject).setScale(f, f);
    }
    try
    {
      localObject = Bitmap.createBitmap(paramString, 0, 0, i, j, (Matrix)localObject, true);
      ((Bitmap)localObject).setDensity(BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().densityDpi);
      if (paramString != localObject) {
        paramString.recycle();
      }
      j = ((Bitmap)localObject).getWidth();
      int k = ((Bitmap)localObject).getHeight();
      paramString = new Rect();
      i = j;
      if (j >= paramInt1)
      {
        paramString.left = ((j - paramInt1) / 2);
        i = paramInt1;
      }
      j = k;
      if (k >= paramInt2)
      {
        paramString.top = 0;
        j = paramInt2;
      }
      paramString.bottom = (paramString.top + j);
      paramString.right = (paramString.left + i);
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      localBitmap.setDensity(BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().densityDpi);
      if (localBitmap != null) {
        new Canvas(localBitmap).drawBitmap((Bitmap)localObject, paramString, new Rect(0, 0, paramInt1, paramInt2), null);
      }
      ((Bitmap)localObject).recycle();
      return localBitmap;
    }
    catch (Throwable paramString) {}
    return null;
    return null;
  }
  
  public static TroopFileData a(obj_msg.ObjMsg paramObjMsg)
  {
    if (paramObjMsg == null) {
      return null;
    }
    if (paramObjMsg.uint32_msg_type.get() != 6L) {
      return null;
    }
    if (!paramObjMsg.msg_content_info.has()) {
      return null;
    }
    TroopFileData localTroopFileData = new TroopFileData();
    if (((obj_msg.MsgContentInfo)paramObjMsg.msg_content_info.get(0)).msg_file.bytes_file_path.has()) {
      localTroopFileData.fileUrl = new String(((obj_msg.MsgContentInfo)paramObjMsg.msg_content_info.get(0)).msg_file.bytes_file_path.get().toByteArray());
    } else {
      QLog.w("TroopFileUtils<QFile>", 1, "decodeTroopFileData. bytes_file_path is null");
    }
    if (TextUtils.isEmpty(localTroopFileData.fileUrl)) {
      return null;
    }
    if (((obj_msg.MsgContentInfo)paramObjMsg.msg_content_info.get(0)).msg_file.uint32_bus_id.has()) {
      localTroopFileData.bisID = ((obj_msg.MsgContentInfo)paramObjMsg.msg_content_info.get(0)).msg_file.uint32_bus_id.get();
    } else {
      QLog.w("TroopFileUtils<QFile>", 1, "decodeTroopFileData. uint32_bus_id is null");
    }
    if (((obj_msg.MsgContentInfo)paramObjMsg.msg_content_info.get(0)).msg_file.str_file_name.has()) {
      localTroopFileData.fileName = ((obj_msg.MsgContentInfo)paramObjMsg.msg_content_info.get(0)).msg_file.str_file_name.get();
    } else {
      QLog.w("TroopFileUtils<QFile>", 1, "decodeTroopFileData. str_file_name is null");
    }
    if (((obj_msg.MsgContentInfo)paramObjMsg.msg_content_info.get(0)).msg_file.uint64_file_size.has()) {
      localTroopFileData.lfileSize = ((obj_msg.MsgContentInfo)paramObjMsg.msg_content_info.get(0)).msg_file.uint64_file_size.get();
    } else {
      QLog.w("TroopFileUtils<QFile>", 1, "decodeTroopFileData. uint64_file_size is null");
    }
    if (((obj_msg.MsgContentInfo)paramObjMsg.msg_content_info.get(0)).msg_file.int64_dead_time.has()) {
      localTroopFileData.lastTime = ((obj_msg.MsgContentInfo)paramObjMsg.msg_content_info.get(0)).msg_file.int64_dead_time.get();
    } else {
      QLog.w("TroopFileUtils<QFile>", 1, "decodeTroopFileData. int64_dead_time is null");
    }
    if (((obj_msg.MsgContentInfo)paramObjMsg.msg_content_info.get(0)).msg_file.bytes_file_sha1.has()) {
      localTroopFileData.sha1 = new String(((obj_msg.MsgContentInfo)paramObjMsg.msg_content_info.get(0)).msg_file.bytes_file_sha1.get().toByteArray());
    } else {
      QLog.w("TroopFileUtils<QFile>", 1, "decodeTroopFileData. bytes_file_sha1 is null");
    }
    localTroopFileData.uuid = UUID.nameUUIDFromBytes(localTroopFileData.fileUrl.getBytes()).toString();
    if (((obj_msg.MsgContentInfo)paramObjMsg.msg_content_info.get(0)).msg_file.bytes_ext.has())
    {
      Object localObject = ((obj_msg.MsgContentInfo)paramObjMsg.msg_content_info.get(0)).msg_file.bytes_ext.get().toStringUtf8();
      try
      {
        localObject = new JSONObject((String)localObject);
        localTroopFileData.width = ((JSONObject)localObject).optInt("width");
        localTroopFileData.height = ((JSONObject)localObject).optInt("height");
        localTroopFileData.duration = ((JSONObject)localObject).optInt("duration");
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    localTroopFileData.dspFileName = new String(paramObjMsg.bytes_title.get().toByteArray());
    localTroopFileData.dspFileName = FileManagerUtil.a(localTroopFileData.dspFileName);
    if ((paramObjMsg.rpt_bytes_abstact.has()) && (!paramObjMsg.rpt_bytes_abstact.get().isEmpty())) {
      localTroopFileData.dspFileSize = new String(((ByteStringMicro)paramObjMsg.rpt_bytes_abstact.get(0)).toByteArray());
    }
    return localTroopFileData;
  }
  
  public static TroopFileStatusInfo a(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2, int paramInt)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(paramQQAppInterface, paramLong1);
    if ((localTroopFileTransferManager != null) && (!TextUtils.isEmpty(paramString1))) {
      paramQQAppInterface = localTroopFileTransferManager.g(UUID.fromString(paramString1));
    } else {
      paramQQAppInterface = null;
    }
    paramString1 = paramQQAppInterface;
    if (paramQQAppInterface == null)
    {
      paramString1 = paramQQAppInterface;
      if (!TextUtils.isEmpty(paramString2)) {
        paramString1 = localTroopFileTransferManager.a(paramString2);
      }
    }
    paramQQAppInterface = new TroopFileStatusInfo(paramString1);
    if (paramQQAppInterface.d == 0L) {
      paramQQAppInterface.d = paramLong1;
    }
    if (TextUtils.isEmpty(paramQQAppInterface.t)) {
      paramQQAppInterface.t = paramString3;
    }
    if (paramQQAppInterface.i == 0L) {
      paramQQAppInterface.i = paramLong2;
    }
    if (paramInt != 0) {
      paramQQAppInterface.u = paramInt;
    }
    if (TextUtils.isEmpty(paramQQAppInterface.r)) {
      paramQQAppInterface.r = paramString2;
    }
    return paramQQAppInterface;
  }
  
  public static TroopFileStatusInfo a(QQAppInterface paramQQAppInterface, MessageForTroopFile paramMessageForTroopFile)
  {
    Object localObject = null;
    if (paramMessageForTroopFile == null) {
      return null;
    }
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(paramQQAppInterface, Long.parseLong(paramMessageForTroopFile.frienduin));
    paramQQAppInterface = (QQAppInterface)localObject;
    if (localTroopFileTransferManager != null)
    {
      paramQQAppInterface = (QQAppInterface)localObject;
      if (!TextUtils.isEmpty(paramMessageForTroopFile.uuid)) {
        paramQQAppInterface = localTroopFileTransferManager.g(UUID.fromString(paramMessageForTroopFile.uuid));
      }
    }
    localObject = paramQQAppInterface;
    if (localTroopFileTransferManager != null)
    {
      localObject = paramQQAppInterface;
      if (paramQQAppInterface == null)
      {
        localObject = paramQQAppInterface;
        if (!TextUtils.isEmpty(paramMessageForTroopFile.url)) {
          localObject = localTroopFileTransferManager.a(paramMessageForTroopFile.url);
        }
      }
    }
    paramQQAppInterface = new TroopFileStatusInfo((TroopFileStatusInfo)localObject);
    if (TextUtils.isEmpty(paramQQAppInterface.t)) {
      paramQQAppInterface.t = paramMessageForTroopFile.fileName;
    }
    if (paramQQAppInterface.i == 0L) {
      paramQQAppInterface.i = paramMessageForTroopFile.fileSize;
    }
    if (paramMessageForTroopFile.bisID != 0) {
      paramQQAppInterface.u = paramMessageForTroopFile.bisID;
    }
    if (!TextUtils.isEmpty(paramMessageForTroopFile.url)) {
      paramQQAppInterface.r = paramMessageForTroopFile.url;
    }
    if (!TextUtils.isEmpty(paramMessageForTroopFile.frienduin)) {
      paramQQAppInterface.d = Long.valueOf(paramMessageForTroopFile.frienduin).longValue();
    }
    if (!TextUtils.isEmpty(paramMessageForTroopFile.sha1)) {
      paramQQAppInterface.s = paramMessageForTroopFile.sha1;
    }
    if (paramMessageForTroopFile.uniseq > 0L) {
      paramQQAppInterface.c = paramMessageForTroopFile.uniseq;
    }
    paramQQAppInterface.A = paramMessageForTroopFile.yybApkPackageName;
    paramQQAppInterface.B = paramMessageForTroopFile.yybApkName;
    paramQQAppInterface.C = paramMessageForTroopFile.yybApkIconUrl;
    return paramQQAppInterface;
  }
  
  public static TroopFileStatusInfo a(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    return a(paramQQAppInterface, paramFileManagerEntity.TroopUin, paramFileManagerEntity.strTroopFileID, paramFileManagerEntity.strTroopFilePath, paramFileManagerEntity.fileName, paramFileManagerEntity.fileSize, paramFileManagerEntity.busId);
  }
  
  public static String a(long paramLong)
  {
    if (paramLong < 1024L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("B");
      return ((StringBuilder)localObject).toString();
    }
    Object localObject = new DecimalFormat("##0.0");
    double d = paramLong;
    if (d < 1048576.0D)
    {
      localStringBuilder = new StringBuilder();
      Double.isNaN(d);
      localStringBuilder.append(((DecimalFormat)localObject).format(d / 1024.0D));
      localStringBuilder.append("K");
      return localStringBuilder.toString();
    }
    if (d < 1073741824.0D)
    {
      localStringBuilder = new StringBuilder();
      Double.isNaN(d);
      localStringBuilder.append(((DecimalFormat)localObject).format(d / 1048576.0D));
      localStringBuilder.append("M");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Double.isNaN(d);
    localStringBuilder.append(((DecimalFormat)localObject).format(d / 1073741824.0D));
    localStringBuilder.append("G");
    return localStringBuilder.toString();
  }
  
  public static String a(Context paramContext, long paramLong)
  {
    paramLong *= 1000L;
    long l = System.currentTimeMillis();
    if (paramLong <= l) {
      return paramContext.getString(2131895110);
    }
    paramLong = (paramLong - l) / 86400000L;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong + 1L);
    localStringBuilder.append(paramContext.getString(2131895083));
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString)
  {
    String str = "";
    if (paramString == null) {
      return "";
    }
    int i = paramString.lastIndexOf(".");
    if (((i != -1) && (i <= 9)) || ((i == -1) && (paramString.length() <= 13))) {
      return paramString;
    }
    if (i != -1)
    {
      str = paramString.substring(i);
      paramString = paramString.substring(0, i);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString.substring(0, 3));
    localStringBuilder.append("...");
    localStringBuilder.append(paramString.substring(paramString.length() - 3));
    paramString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, List<ChatMessage> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() < 1) {
        return;
      }
      Object localObject = new HashMap();
      Iterator localIterator = paramList.iterator();
      long l;
      while (localIterator.hasNext())
      {
        ChatMessage localChatMessage = (ChatMessage)localIterator.next();
        l = Long.parseLong(localChatMessage.frienduin);
        paramList = (List)((Map)localObject).get(Long.valueOf(l));
        paramActivity = paramList;
        if (paramList == null)
        {
          paramActivity = new ArrayList();
          ((Map)localObject).put(Long.valueOf(l), paramActivity);
        }
        paramList = a(paramQQAppInterface, (MessageForTroopFile)localChatMessage);
        if (paramList != null)
        {
          if (paramList.r == null) {
            return;
          }
          paramActivity.add(paramList);
        }
        else
        {
          return;
        }
      }
      paramActivity = ((Map)localObject).entrySet().iterator();
      while (paramActivity.hasNext())
      {
        paramList = (Map.Entry)paramActivity.next();
        l = ((Long)paramList.getKey()).longValue();
        paramList = (List)paramList.getValue();
        localObject = TroopFileTransferManager.a(paramQQAppInterface, l);
        if (localObject != null) {
          ((TroopFileTransferManager)localObject).a(paramList);
        }
      }
    }
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if (paramChatMessage != null)
    {
      if (!(paramChatMessage instanceof MessageForTroopFile)) {
        return;
      }
      if (TroopFileTransferManager.a(paramQQAppInterface, Long.parseLong(paramChatMessage.frienduin)) == null) {
        return;
      }
      paramChatMessage = (MessageForTroopFile)paramChatMessage;
      QFileUtils.a(paramQQAppInterface, paramContext, Long.parseLong(paramChatMessage.frienduin), paramChatMessage.uuid, paramChatMessage.url, paramChatMessage.fileName, paramChatMessage.fileSize, paramChatMessage.bisID);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, List<TroopFileInfo> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      Object localObject2 = new HashMap();
      Iterator localIterator = paramList.iterator();
      Object localObject1;
      while (localIterator.hasNext())
      {
        TroopFileInfo localTroopFileInfo = (TroopFileInfo)localIterator.next();
        localObject1 = (List)((Map)localObject2).get(Long.valueOf(paramLong));
        paramList = (List<TroopFileInfo>)localObject1;
        if (localObject1 == null)
        {
          paramList = new ArrayList();
          ((Map)localObject2).put(Long.valueOf(paramLong), paramList);
        }
        localObject1 = QFileUtils.a(paramQQAppInterface, paramLong, localTroopFileInfo);
        if (localObject1 != null)
        {
          if (((TroopFileStatusInfo)localObject1).r == null) {
            return;
          }
          paramList.add(localObject1);
        }
        else
        {
          return;
        }
      }
      paramList = ((Map)localObject2).entrySet().iterator();
      while (paramList.hasNext())
      {
        localObject1 = (Map.Entry)paramList.next();
        paramLong = ((Long)((Map.Entry)localObject1).getKey()).longValue();
        localObject1 = (List)((Map.Entry)localObject1).getValue();
        localObject2 = TroopFileTransferManager.a(paramQQAppInterface, paramLong);
        if (localObject2 != null) {
          ((TroopFileTransferManager)localObject2).a((List)localObject1);
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, boolean paramBoolean, long paramLong1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, long paramLong2, long paramLong3, String paramString6, String paramString7, int paramInt2)
  {
    long l2 = 0L;
    long l1;
    if (paramLong1 == 0L) {
      l1 = System.currentTimeMillis();
    } else {
      l1 = paramLong1;
    }
    if (l1 < 1L) {
      paramLong1 = 0L;
    } else {
      paramLong1 = System.currentTimeMillis() - l1;
    }
    long l3;
    if (paramLong1 <= 0L)
    {
      l3 = 0L;
      paramLong1 = l2;
      l2 = l3;
    }
    else
    {
      l3 = paramLong2 / paramLong1;
      l2 = paramLong1;
      paramLong1 = l3;
    }
    int i = HttpUtil.getNetWorkType();
    String str;
    if ((i < AppConstants.NET_TYPE_NAME.length) && (i >= 0)) {
      str = AppConstants.NET_TYPE_NAME[i];
    } else {
      str = "NONE";
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("netType", str);
    localHashMap.put("serverip", String.valueOf(paramString2));
    localHashMap.put("troopUin", String.valueOf(paramString3));
    localHashMap.put("filePath", paramString5);
    localHashMap.put("errorCode", String.valueOf(paramInt1));
    localHashMap.put("transferedSize", String.valueOf(paramLong2));
    localHashMap.put("fileSize", String.valueOf(paramLong3));
    localHashMap.put("url", String.valueOf(paramString6));
    localHashMap.put("rspHeader", String.valueOf(paramString7));
    localHashMap.put("retry", String.valueOf(paramInt2));
    if (paramBoolean == true) {
      i = 0;
    } else {
      i = 1;
    }
    paramString5 = new StringBuilder();
    paramString5.append(paramLong1);
    paramString5.append("KB/s");
    ReportController.b(paramQQAppInterface, "P_CliOper", "BizTechReport", "", "troop_troopfile", paramString1, 0, i, paramString3, paramString4, paramString5.toString(), localHashMap.toString());
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("ReportTransferFailedInfo actType[");
      paramQQAppInterface.append(paramString1);
      paramQQAppInterface.append("], isSuccess[");
      paramQQAppInterface.append(String.valueOf(paramBoolean));
      paramQQAppInterface.append("], errorCode[");
      paramQQAppInterface.append(String.valueOf(paramInt1));
      paramQQAppInterface.append("], startTime[");
      paramQQAppInterface.append(String.valueOf(l1));
      paramQQAppInterface.append("], duration[");
      paramQQAppInterface.append(String.valueOf(l2));
      paramQQAppInterface.append("],  transferSize[");
      paramQQAppInterface.append(String.valueOf(paramLong2));
      paramQQAppInterface.append("], fileSize[");
      paramQQAppInterface.append(String.valueOf(paramLong3));
      paramQQAppInterface.append("], fileType[");
      paramQQAppInterface.append(paramString4);
      paramQQAppInterface.append("], netType[");
      paramQQAppInterface.append(str);
      paramQQAppInterface.append("], fileTransferSpeed[");
      paramQQAppInterface.append(String.valueOf(paramLong1));
      paramQQAppInterface.append(" KB/s], serverip[");
      paramQQAppInterface.append(paramString2);
      paramQQAppInterface.append("], url[");
      paramQQAppInterface.append(String.valueOf(paramString6));
      paramQQAppInterface.append("], rspHeader[");
      paramQQAppInterface.append(String.valueOf(paramString7));
      paramQQAppInterface.append("], retryTimes[");
      paramQQAppInterface.append(String.valueOf(paramInt2));
      paramQQAppInterface.append("]");
      QLog.d("BizTechReport", 2, paramQQAppInterface.toString());
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file_config_");
    localStringBuilder.append(paramQQAppInterface.getCurrentUin());
    return localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).getBoolean("https_troop_down", false);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    Object localObject = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong);
    localStringBuilder.append("");
    localObject = ((TroopManager)localObject).f(localStringBuilder.toString());
    return (localObject != null) && (((((TroopInfo)localObject).troopowneruin != null) && (paramQQAppInterface.getCurrentAccountUin().equals(((TroopInfo)localObject).troopowneruin))) || ((((TroopInfo)localObject).Administrator != null) && (((TroopInfo)localObject).Administrator.contains(paramQQAppInterface.getCurrentAccountUin()))));
  }
  
  public static boolean a(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject2 == null;
    }
    return paramObject1.equals(paramObject2);
  }
  
  /* Error */
  public static boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_2
    //   2: iload_3
    //   3: invokestatic 970	com/tencent/mobileqq/troop/utils/TroopFileUtils:a	(Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   6: astore 5
    //   8: aload 5
    //   10: ifnonnull +5 -> 15
    //   13: iconst_0
    //   14: ireturn
    //   15: new 972	java/io/File
    //   18: dup
    //   19: aload_1
    //   20: invokespecial 973	java/io/File:<init>	(Ljava/lang/String;)V
    //   23: astore_1
    //   24: aload_1
    //   25: invokevirtual 976	java/io/File:exists	()Z
    //   28: ifeq +8 -> 36
    //   31: aload_1
    //   32: invokevirtual 979	java/io/File:delete	()Z
    //   35: pop
    //   36: aload_1
    //   37: invokevirtual 982	java/io/File:createNewFile	()Z
    //   40: pop
    //   41: goto +8 -> 49
    //   44: astore_0
    //   45: aload_0
    //   46: invokevirtual 983	java/io/IOException:printStackTrace	()V
    //   49: aconst_null
    //   50: astore 4
    //   52: aconst_null
    //   53: astore_0
    //   54: new 985	java/io/BufferedOutputStream
    //   57: dup
    //   58: new 987	java/io/FileOutputStream
    //   61: dup
    //   62: aload_1
    //   63: invokespecial 990	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   66: invokespecial 993	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   69: astore_1
    //   70: aload 5
    //   72: getstatic 999	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   75: bipush 100
    //   77: aload_1
    //   78: invokevirtual 1003	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   81: pop
    //   82: aload 5
    //   84: invokevirtual 375	android/graphics/Bitmap:recycle	()V
    //   87: aload_1
    //   88: invokevirtual 1006	java/io/BufferedOutputStream:flush	()V
    //   91: goto +50 -> 141
    //   94: astore_0
    //   95: invokestatic 318	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   98: ifeq +43 -> 141
    //   101: new 248	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   108: astore 4
    //   110: aload 4
    //   112: ldc_w 1008
    //   115: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload 4
    //   121: aload_0
    //   122: invokevirtual 1009	java/io/IOException:toString	()Ljava/lang/String;
    //   125: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: ldc_w 1011
    //   132: iconst_2
    //   133: aload 4
    //   135: invokevirtual 292	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 1013	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   141: aload_1
    //   142: invokevirtual 1016	java/io/BufferedOutputStream:close	()V
    //   145: iconst_1
    //   146: ireturn
    //   147: astore_0
    //   148: invokestatic 318	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   151: ifeq +39 -> 190
    //   154: new 248	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   161: astore_1
    //   162: aload_1
    //   163: ldc_w 1008
    //   166: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload_1
    //   171: aload_0
    //   172: invokevirtual 1009	java/io/IOException:toString	()Ljava/lang/String;
    //   175: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: ldc_w 1011
    //   182: iconst_2
    //   183: aload_1
    //   184: invokevirtual 292	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 1013	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   190: iconst_1
    //   191: ireturn
    //   192: astore 4
    //   194: aload_1
    //   195: astore_0
    //   196: aload 4
    //   198: astore_1
    //   199: goto +185 -> 384
    //   202: astore 4
    //   204: goto +14 -> 218
    //   207: astore_1
    //   208: goto +176 -> 384
    //   211: astore_0
    //   212: aload 4
    //   214: astore_1
    //   215: aload_0
    //   216: astore 4
    //   218: aload_1
    //   219: astore_0
    //   220: invokestatic 318	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   223: ifeq +52 -> 275
    //   226: aload_1
    //   227: astore_0
    //   228: new 248	java/lang/StringBuilder
    //   231: dup
    //   232: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   235: astore 5
    //   237: aload_1
    //   238: astore_0
    //   239: aload 5
    //   241: ldc_w 1008
    //   244: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: aload_1
    //   249: astore_0
    //   250: aload 5
    //   252: aload 4
    //   254: invokevirtual 1017	java/io/FileNotFoundException:toString	()Ljava/lang/String;
    //   257: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: pop
    //   261: aload_1
    //   262: astore_0
    //   263: ldc_w 1011
    //   266: iconst_2
    //   267: aload 5
    //   269: invokevirtual 292	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   272: invokestatic 1013	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   275: aload_1
    //   276: ifnull +106 -> 382
    //   279: aload_1
    //   280: invokevirtual 1006	java/io/BufferedOutputStream:flush	()V
    //   283: goto +50 -> 333
    //   286: astore_0
    //   287: invokestatic 318	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   290: ifeq +43 -> 333
    //   293: new 248	java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   300: astore 4
    //   302: aload 4
    //   304: ldc_w 1008
    //   307: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: aload 4
    //   313: aload_0
    //   314: invokevirtual 1009	java/io/IOException:toString	()Ljava/lang/String;
    //   317: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: ldc_w 1011
    //   324: iconst_2
    //   325: aload 4
    //   327: invokevirtual 292	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   330: invokestatic 1013	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   333: aload_1
    //   334: invokevirtual 1016	java/io/BufferedOutputStream:close	()V
    //   337: iconst_0
    //   338: ireturn
    //   339: astore_0
    //   340: invokestatic 318	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   343: ifeq +39 -> 382
    //   346: new 248	java/lang/StringBuilder
    //   349: dup
    //   350: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   353: astore_1
    //   354: aload_1
    //   355: ldc_w 1008
    //   358: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: pop
    //   362: aload_1
    //   363: aload_0
    //   364: invokevirtual 1009	java/io/IOException:toString	()Ljava/lang/String;
    //   367: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: pop
    //   371: ldc_w 1011
    //   374: iconst_2
    //   375: aload_1
    //   376: invokevirtual 292	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   379: invokestatic 1013	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   382: iconst_0
    //   383: ireturn
    //   384: aload_0
    //   385: ifnull +113 -> 498
    //   388: aload_0
    //   389: invokevirtual 1006	java/io/BufferedOutputStream:flush	()V
    //   392: goto +52 -> 444
    //   395: astore 4
    //   397: invokestatic 318	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   400: ifeq +44 -> 444
    //   403: new 248	java/lang/StringBuilder
    //   406: dup
    //   407: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   410: astore 5
    //   412: aload 5
    //   414: ldc_w 1008
    //   417: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: pop
    //   421: aload 5
    //   423: aload 4
    //   425: invokevirtual 1009	java/io/IOException:toString	()Ljava/lang/String;
    //   428: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: pop
    //   432: ldc_w 1011
    //   435: iconst_2
    //   436: aload 5
    //   438: invokevirtual 292	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   441: invokestatic 1013	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   444: aload_0
    //   445: invokevirtual 1016	java/io/BufferedOutputStream:close	()V
    //   448: goto +50 -> 498
    //   451: astore_0
    //   452: invokestatic 318	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   455: ifeq +43 -> 498
    //   458: new 248	java/lang/StringBuilder
    //   461: dup
    //   462: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   465: astore 4
    //   467: aload 4
    //   469: ldc_w 1008
    //   472: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: pop
    //   476: aload 4
    //   478: aload_0
    //   479: invokevirtual 1009	java/io/IOException:toString	()Ljava/lang/String;
    //   482: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: pop
    //   486: ldc_w 1011
    //   489: iconst_2
    //   490: aload 4
    //   492: invokevirtual 292	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   495: invokestatic 1013	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   498: aload_1
    //   499: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	500	0	paramString1	String
    //   0	500	1	paramString2	String
    //   0	500	2	paramInt1	int
    //   0	500	3	paramInt2	int
    //   50	84	4	localStringBuilder1	StringBuilder
    //   192	5	4	localObject1	Object
    //   202	11	4	localFileNotFoundException	java.io.FileNotFoundException
    //   216	110	4	localObject2	Object
    //   395	29	4	localIOException	java.io.IOException
    //   465	26	4	localStringBuilder2	StringBuilder
    //   6	431	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   36	41	44	java/io/IOException
    //   87	91	94	java/io/IOException
    //   141	145	147	java/io/IOException
    //   70	87	192	finally
    //   70	87	202	java/io/FileNotFoundException
    //   54	70	207	finally
    //   220	226	207	finally
    //   228	237	207	finally
    //   239	248	207	finally
    //   250	261	207	finally
    //   263	275	207	finally
    //   54	70	211	java/io/FileNotFoundException
    //   279	283	286	java/io/IOException
    //   333	337	339	java/io/IOException
    //   388	392	395	java/io/IOException
    //   444	448	451	java/io/IOException
  }
  
  public static void b(Context paramContext, QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if (paramChatMessage != null)
    {
      if (!(paramChatMessage instanceof MessageForTroopFile)) {
        return;
      }
      TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(paramQQAppInterface, Long.parseLong(paramChatMessage.frienduin));
      if (localTroopFileTransferManager == null) {
        return;
      }
      paramQQAppInterface = a(paramQQAppInterface, (MessageForTroopFile)paramChatMessage);
      if (paramQQAppInterface != null)
      {
        if (paramQQAppInterface.r == null) {
          return;
        }
        FMToastUtil.d(paramContext.getString(2131889761));
        localTroopFileTransferManager.b(paramQQAppInterface.r, paramQQAppInterface.t, paramQQAppInterface.i, paramQQAppInterface.u);
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, long paramLong)
  {
    TroopFileError.a(paramQQAppInterface, paramLong, 106);
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file_config_");
    localStringBuilder.append(paramQQAppInterface.getCurrentUin());
    return localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).getBoolean("https_troopzip_down", false);
  }
  
  public static boolean b(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    String[] arrayOfString = b;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (paramString.contains(arrayOfString[i])) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static String c(String paramString)
  {
    int k = paramString.length();
    char[] arrayOfChar = paramString.toCharArray();
    StringBuilder localStringBuilder = new StringBuilder();
    int j;
    for (int i = 0; i < k; i = j + 1)
    {
      int m = paramString.codePointAt(i);
      if (EmotcationConstants.EMOJI_MAP.get(m, -1) < 0)
      {
        localStringBuilder.append(arrayOfChar[i]);
        j = i;
      }
      else
      {
        j = i;
        if (m > 65535)
        {
          j = i;
          if (k >= i + 2) {
            j = i + 1;
          }
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface)
  {
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file_config_");
    localStringBuilder.append(paramQQAppInterface.getCurrentUin());
    return localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).getBoolean("https_troop_thumb", false);
  }
  
  public static boolean d(String paramString)
  {
    return paramString.trim().length() == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileUtils
 * JD-Core Version:    0.7.0.1
 */