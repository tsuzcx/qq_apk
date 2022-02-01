package com.tencent.mobileqq.transfile;

import android.text.TextUtils;
import anzj;
import bdmc;
import bdow;
import berj;
import besx;
import beum;
import beuo;
import bevm;
import bews;
import bewy;
import bexv;
import beyb;
import beyg;
import bfau;
import bfaz;
import bfba;
import bfbj;
import bfbr;
import bfbs;
import bfca;
import bhsr;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import tencent.im.longconn.longmsg.LongMsg.MsgDownRsp;
import tencent.im.longconn.longmsg.LongMsg.RspBody;
import tencent.im.msg.im_msg_head.Head;
import tencent.im.msg.im_msg_head.HttpConnHead;

public class StructLongMessageDownloadProcessor
  extends berj
  implements Runnable
{
  private static ConcurrentHashMap<Long, beum> b = new ConcurrentHashMap();
  private static final ArrayList<beyg> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  AbsStructMsg jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private long jdField_c_of_type_Long;
  int jdField_d_of_type_Int = 4;
  private long jdField_d_of_type_Long;
  String e = "";
  String jdField_f_of_type_JavaLangString = "";
  boolean jdField_f_of_type_Boolean = true;
  String l;
  int q = 200;
  private int r = 5;
  private int s;
  
  public StructLongMessageDownloadProcessor(beyb parambeyb, beyg parambeyg)
  {
    super(parambeyb, parambeyg);
    this.jdField_l_of_type_JavaLangString = "";
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return null;
    }
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() < 2) {
        localStringBuilder.append(0);
      }
      localStringBuilder.append(str);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private void a(long paramLong, String paramString)
  {
    beum localbeum = new beum();
    localbeum.jdField_a_of_type_Beuq = this;
    localbeum.jdField_a_of_type_JavaLangString = paramString;
    localbeum.jdField_a_of_type_Int = 0;
    localbeum.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
    this.jdField_a_of_type_Beuo.a(localbeum);
    b.put(Long.valueOf(paramLong), localbeum);
    this.jdField_a_of_type_Bevl = localbeum;
    besx.a().a().b(bews.a(paramString));
    this.e = paramString;
    this.jdField_d_of_type_Long = System.nanoTime();
    if (QLog.isColorLevel())
    {
      QLog.d("StructLongMessageDownloadProcessor", 2, "receiveFile->msgid:" + paramLong + ", url:" + paramString);
      if (c(this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
        QLog.d("PaOldLongMsg", 2, "msgId=uniseq:" + paramLong + ", receiveFile->url:" + paramString);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    synchronized (jdField_c_of_type_JavaUtilArrayList)
    {
      if ((jdField_c_of_type_JavaUtilArrayList == null) || (jdField_c_of_type_JavaUtilArrayList.size() == 0) || (paramQQAppInterface == null)) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("StructLongMessageDownloadProcessor", 2, "deleteAllTask msgid" + paramLong);
      }
      paramQQAppInterface = paramQQAppInterface.a();
      if (paramQQAppInterface != null)
      {
        Iterator localIterator = jdField_c_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          beyg localbeyg = (beyg)localIterator.next();
          if (localbeyg.jdField_a_of_type_Long == paramLong)
          {
            paramQQAppInterface.c(localbeyg.c, localbeyg.jdField_a_of_type_Long);
            jdField_c_of_type_JavaUtilArrayList.remove(localbeyg);
            a(false, localbeyg.jdField_b_of_type_JavaLangString, localbeyg.c, localbeyg.jdField_a_of_type_Long, localbeyg);
          }
        }
      }
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    for (;;)
    {
      synchronized (jdField_c_of_type_JavaUtilArrayList)
      {
        Object localObject = jdField_c_of_type_JavaUtilArrayList.iterator();
        if (((Iterator)localObject).hasNext())
        {
          if (((beyg)((Iterator)localObject).next()).jdField_a_of_type_Long != paramMessageRecord.uniseq) {
            continue;
          }
          return;
        }
        localObject = new beyg();
        ((beyg)localObject).jdField_a_of_type_Boolean = false;
        ((beyg)localObject).c = paramMessageRecord.frienduin;
        ((beyg)localObject).e = 131079;
        ((beyg)localObject).jdField_b_of_type_Int = 131079;
        ((beyg)localObject).jdField_a_of_type_Long = paramMessageRecord.uniseq;
        ((beyg)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
        ((beyg)localObject).jdField_b_of_type_JavaLangString = paramMessageRecord.selfuin;
        if (paramQQAppInterface.a().a((beyg)localObject)) {
          jdField_c_of_type_JavaUtilArrayList.add(localObject);
        }
        if (QLog.isColorLevel())
        {
          if (c(paramMessageRecord))
          {
            QLog.d("StructLongMessageDownloadProcessor", 2, "getStructLongMessage(oldLongMsg) , messageRecord,msgid= " + paramMessageRecord.uniseq);
            QLog.d("PaOldLongMsg", 2, "msgId=uniseq:" + paramMessageRecord.uniseq + ", getStructLongMessage");
          }
        }
        else
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("StructLongMessageDownloadProcessor", 2, "LongMessage Download time start: " + System.currentTimeMillis());
          return;
        }
      }
      QLog.d("StructLongMessageDownloadProcessor", 2, "getStructLongMessage , messageRecord,msgid= " + paramMessageRecord.uniseq);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    ArrayList localArrayList2;
    synchronized (jdField_c_of_type_JavaUtilArrayList)
    {
      if ((jdField_c_of_type_JavaUtilArrayList == null) || (jdField_c_of_type_JavaUtilArrayList.size() == 0) || (paramString == null) || (paramQQAppInterface == null)) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("StructLongMessageDownloadProcessor", 2, "deleteAllTask uin" + paramString);
      }
      localArrayList2 = new ArrayList();
      paramQQAppInterface = paramQQAppInterface.a();
      if (paramQQAppInterface != null)
      {
        Iterator localIterator = jdField_c_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          beyg localbeyg = (beyg)localIterator.next();
          if (paramString.equalsIgnoreCase(localbeyg.c))
          {
            paramQQAppInterface.c(localbeyg.c, localbeyg.jdField_a_of_type_Long);
            localArrayList2.add(localbeyg);
            a(true, localbeyg.jdField_b_of_type_JavaLangString, localbeyg.c, localbeyg.jdField_a_of_type_Long, localbeyg);
          }
        }
      }
    }
    jdField_c_of_type_JavaUtilArrayList.removeAll(localArrayList2);
  }
  
  private static void a(boolean paramBoolean, String paramString1, String paramString2, long paramLong, beyg parambeyg)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("StructLongMessageDownloadProcessor", 2, "LongMessage Download Beacon Report Cancel");
      if (c(parambeyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
        QLog.d("PaOldLongMsg", 2, "msgId=uniseq:" + parambeyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq + ", delete download task!");
      }
    }
    HashMap localHashMap;
    if (c(parambeyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord))
    {
      parambeyg = "actOldLongMessageDownload";
      localHashMap = new HashMap();
      localHashMap.put("param_uin", paramString1);
      localHashMap.put("param_puin", paramString2);
      localHashMap.put("param_channel", "0");
      if (!paramBoolean) {
        break label264;
      }
      localHashMap.put("param_errcode", String.valueOf(11));
    }
    for (;;)
    {
      localHashMap.put("param_resid", "" + paramLong);
      if (!QLog.isColorLevel()) {
        break label281;
      }
      paramString1 = localHashMap.entrySet().iterator();
      while (paramString1.hasNext())
      {
        Object localObject = (Map.Entry)paramString1.next();
        paramString2 = (String)((Map.Entry)localObject).getKey();
        localObject = (String)((Map.Entry)localObject).getValue();
        QLog.d("StructLongMessageDownloadProcessorForReport", 2, paramString2 + (String)localObject);
      }
      parambeyg = "actLongMessageDownload";
      break;
      label264:
      localHashMap.put("param_errcode", String.valueOf(10));
    }
    label281:
    bdmc.a(BaseApplication.getContext()).a(null, parambeyg, false, 0L, 0L, localHashMap, "", true);
  }
  
  private boolean a()
  {
    this.jdField_f_of_type_Boolean = true;
    this.r = 5;
    MessageRecord localMessageRecord = this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    if (localMessageRecord == null) {}
    do
    {
      return false;
      localObject = localMessageRecord.getExtInfoFromExtStr("pub_long_msg_url");
      str1 = localMessageRecord.getExtInfoFromExtStr("pub_long_msg_download_key");
      this.jdField_f_of_type_JavaLangString = localMessageRecord.selfuin;
      this.jdField_l_of_type_JavaLangString = localMessageRecord.frienduin;
    } while ((localObject == null) || ("".equals(localObject)) || (str1 == null) || ("".equals(str1)));
    String str2 = (String)localObject + "&rkey=" + str1;
    String str1 = besx.a().a();
    Object localObject = str1;
    if (str1 == null)
    {
      localObject = besx.a().a().a();
      this.r = 10;
      this.s = besx.a().a().a();
    }
    if ((localObject == null) || (((String)localObject).length() == 0))
    {
      switch (besx.a().a())
      {
      default: 
        this.r = 7;
        return false;
      }
      this.r = 6;
      return false;
    }
    localObject = (String)localObject + str2;
    if (QLog.isColorLevel()) {
      QLog.d("StructLongMessageDownloadProcessor", 2, "directUrl = " + str2 + ",url:" + (String)localObject);
    }
    a(localMessageRecord.uniseq, (String)localObject);
    ThreadManager.getSubThreadHandler().postDelayed(this, 30000L);
    return true;
  }
  
  private byte[] a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructLongMessageDownloadProcessor", 2, "parseOldLongMsgContent->null bodyData");
      }
      paramArrayOfByte = null;
      return paramArrayOfByte;
    }
    int i = paramArrayOfByte.length;
    Object localObject2;
    Object localObject1;
    if ((paramArrayOfByte[0] != 40) || (paramArrayOfByte[(i - 1)] != 41))
    {
      localObject2 = "unexpected body data, len=" + i + ", data=";
      localObject1 = paramArrayOfByte.toString();
      localObject2 = new StringBuilder().append((String)localObject2);
      paramArrayOfByte = (byte[])localObject1;
      if (((String)localObject1).length() > 20) {
        paramArrayOfByte = ((String)localObject1).substring(0, 20);
      }
      paramArrayOfByte = paramArrayOfByte;
      if (QLog.isColorLevel()) {
        QLog.d("StructLongMessageDownloadProcessor", 2, "parseOldLongMsgContent->" + paramArrayOfByte);
      }
      return null;
    }
    for (;;)
    {
      int j;
      try
      {
        paramArrayOfByte = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
        paramArrayOfByte.readByte();
        int k = paramArrayOfByte.readInt();
        j = paramArrayOfByte.readInt();
        if ((k > i) || (j > i))
        {
          if (!QLog.isColorLevel()) {
            break label599;
          }
          QLog.d("StructLongMessageDownloadProcessor", 2, "parseOldLongMsgContent->unexpected length, headLen=" + k + ", bodyLen=" + j);
          break label599;
        }
        if (k <= 0) {
          break label594;
        }
        localObject1 = new byte[k];
        paramArrayOfByte.read((byte[])localObject1);
        localObject2 = new im_msg_head.Head();
        ((im_msg_head.Head)localObject2).mergeFrom((byte[])localObject1);
        i = ((im_msg_head.HttpConnHead)((im_msg_head.Head)localObject2).msg_httpconn_head.get()).uint32_error_code.get();
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return null;
      }
      if (!QLog.isColorLevel()) {
        break label612;
      }
      QLog.d("StructLongMessageDownloadProcessor", 2, "parseOldLongMsgContent->bodyLen= " + j + " errCode= " + i);
      break label612;
      localObject1 = new byte[j];
      paramArrayOfByte.read((byte[])localObject1);
      paramArrayOfByte = new Cryptor().decrypt((byte[])localObject1, this.jdField_a_of_type_ArrayOfByte);
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
      {
        if (!QLog.isColorLevel()) {
          break label614;
        }
        QLog.d("StructLongMessageDownloadProcessor", 2, "parseOldLongMsgContent->after decrypt: dBodyBytes==null ||dBodyBytes.length<=0");
        break label614;
      }
      localObject1 = new LongMsg.RspBody();
      ((LongMsg.RspBody)localObject1).mergeFrom(paramArrayOfByte);
      paramArrayOfByte = (LongMsg.MsgDownRsp)((LongMsg.RspBody)localObject1).rpt_msg_down_rsp.get(0);
      if (paramArrayOfByte == null)
      {
        if (!QLog.isColorLevel()) {
          break label616;
        }
        QLog.d("StructLongMessageDownloadProcessor", 2, "parseOldLongMsgContent->rspBody.rpt_msg_down_rsp == null");
        break label616;
      }
      if (!paramArrayOfByte.uint32_result.has())
      {
        if (!QLog.isColorLevel()) {
          break label618;
        }
        QLog.d("StructLongMessageDownloadProcessor", 2, "parseOldLongMsgContent->uint32_result NOT exists");
        break label618;
      }
      if (paramArrayOfByte.uint32_result.get() != 0)
      {
        if (!QLog.isColorLevel()) {
          break label620;
        }
        QLog.d("StructLongMessageDownloadProcessor", 2, "parseOldLongMsgContent->uint32_result != 0");
        break label620;
      }
      if (!paramArrayOfByte.bytes_msg_content.has())
      {
        if (!QLog.isColorLevel()) {
          break label622;
        }
        QLog.d("StructLongMessageDownloadProcessor", 2, "parseOldLongMsgContent->bytes_msg_content NOT exists");
        break label622;
      }
      localObject1 = paramArrayOfByte.bytes_msg_content.get().toByteArray();
      if (localObject1 != null)
      {
        paramArrayOfByte = (byte[])localObject1;
        if (localObject1.length > 0) {
          break;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("StructLongMessageDownloadProcessor", 2, "parseOldLongMsgContent->bytes_msg_content == null or empty");
      }
      return null;
      label594:
      i = 0;
      break label601;
      label599:
      return null;
      label601:
      if (j > 0) {
        if (i == 0) {}
      }
    }
    label612:
    return null;
    label614:
    return null;
    label616:
    return null;
    label618:
    return null;
    label620:
    return null;
    label622:
    return null;
  }
  
  public static boolean b(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    String str1;
    String str2;
    String str3;
    do
    {
      return false;
      str1 = paramMessageRecord.getExtInfoFromExtStr("pub_long_msg_url");
      str2 = paramMessageRecord.getExtInfoFromExtStr("pub_long_msg_download_key");
      str3 = paramMessageRecord.getExtInfoFromExtStr("pub_long_msg_resid");
    } while ((bhsr.a(str1)) || (bhsr.a(str2)) || (bhsr.a(str3)));
    if (QLog.isColorLevel()) {
      QLog.d("StructLongMessageDownloadProcessor", 2, "isPALongMsg , messageRecord,msgid= " + paramMessageRecord.msgId + " uid= " + paramMessageRecord.msgUid + " msgseq= " + paramMessageRecord.msgseq + " uniseq=" + paramMessageRecord.uniseq);
    }
    return true;
  }
  
  public static boolean c(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    while (bhsr.a(paramMessageRecord.getExtInfoFromExtStr("pub_old_long_msg"))) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StructLongMessageDownloadProcessor", 2, "isOldLongMsg , messageRecord,msgid= " + paramMessageRecord.msgId + " uid= " + paramMessageRecord.msgUid + " msgseq= " + paramMessageRecord.msgseq + " uniseq=" + paramMessageRecord.uniseq);
    }
    return true;
  }
  
  public static boolean d(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    String str1;
    String str2;
    String str3;
    do
    {
      return false;
      str1 = paramMessageRecord.getExtInfoFromExtStr("pub_old_long_msg");
      str2 = paramMessageRecord.getExtInfoFromExtStr("pub_long_msg_resid");
      str3 = paramMessageRecord.getExtInfoFromExtStr("longMsg_State");
    } while ((bhsr.a(str1)) || (bhsr.a(str3)) || (bhsr.a(str2)));
    if (QLog.isColorLevel()) {
      QLog.d("StructLongMessageDownloadProcessor", 2, "needFetchOldLongMsg , messageRecord,msgid= " + paramMessageRecord.msgId + " uid= " + paramMessageRecord.msgUid + " msgseq= " + paramMessageRecord.msgseq + " uniseq=" + paramMessageRecord.uniseq);
    }
    return true;
  }
  
  private void f(int paramInt)
  {
    MessageForStructing localMessageForStructing;
    if ((this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForStructing))
    {
      localMessageForStructing = (MessageForStructing)this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if (localMessageForStructing != null)
      {
        if (paramInt != 2003) {
          break label282;
        }
        localMessageForStructing.removeExtInfoToExtStr("pub_long_msg_url");
        localMessageForStructing.removeExtInfoToExtStr("pub_long_msg_download_key");
        localMessageForStructing.removeExtInfoToExtStr("pub_long_msg_resid");
        if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg instanceof StructMsgForGeneralShare))
        {
          str = ((StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg).mWarningTips;
          if (!TextUtils.isEmpty(str)) {
            localMessageForStructing.saveExtInfoToExtStr("pa_phone_msg_tip", str);
          }
        }
        l1 = 0L;
        if (localMessageForStructing.structingMsg != null) {
          l1 = localMessageForStructing.structingMsg.msgId;
        }
        localMessageForStructing.structingMsg = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
        localMessageForStructing.structingMsg.msgId = l1;
        if (QLog.isColorLevel()) {
          QLog.d("StructLongMessageDownloadProcessor", 2, "LongMessage data size: " + this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.getBytes().length);
        }
        localMessageForStructing.msgData = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.getBytes();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Beyg.c, this.jdField_a_of_type_Beyg.jdField_a_of_type_Int, localMessageForStructing.uniseq, localMessageForStructing.msgData);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Beyg.c, this.jdField_a_of_type_Beyg.jdField_a_of_type_Int, localMessageForStructing.uniseq, "extStr", localMessageForStructing.extStr);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().notifyUI(999, true, this.jdField_a_of_type_Beyg.c);
      }
    }
    label282:
    while (paramInt != 2005)
    {
      String str;
      long l1;
      return;
    }
    localMessageForStructing.saveExtInfoToExtStr("longMsg_State", String.valueOf(2));
    localMessageForStructing.structingMsg.mMsgBrief = anzj.a(2131713393);
    localMessageForStructing.msgData = localMessageForStructing.structingMsg.getBytes();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Beyg.c, this.jdField_a_of_type_Beyg.jdField_a_of_type_Int, localMessageForStructing.uniseq, localMessageForStructing.msgData);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Beyg.c, this.jdField_a_of_type_Beyg.jdField_a_of_type_Int, localMessageForStructing.uniseq, "extStr", localMessageForStructing.extStr);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().notifyUI(999, true, this.jdField_a_of_type_Beyg.c);
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForStructing)) {
      synchronized (jdField_c_of_type_JavaUtilArrayList)
      {
        Iterator localIterator = jdField_c_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          beyg localbeyg = (beyg)localIterator.next();
          if (localbeyg.jdField_a_of_type_Long == this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq) {
            jdField_c_of_type_JavaUtilArrayList.remove(localbeyg);
          }
        }
        return;
      }
    }
  }
  
  private void h()
  {
    this.jdField_f_of_type_Boolean = false;
    this.s = 0;
    Object localObject1 = this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    if (localObject1 == null)
    {
      this.jdField_d_of_type_Int = 15;
      d();
    }
    String str;
    Object localObject2;
    do
    {
      do
      {
        return;
        str = ((MessageRecord)localObject1).getExtInfoFromExtStr("pub_long_msg_resid");
        if ((str != null) && (!str.equals(""))) {
          break;
        }
      } while ((!b((MessageRecord)localObject1)) && (!c((MessageRecord)localObject1)));
      this.jdField_d_of_type_Int = 13;
      d();
      return;
      if (!c((MessageRecord)localObject1)) {
        break;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("StructLongMessageDownloadProcessor", 2, "sendGetUrlReq->oldLongMsg");
        QLog.d("PaOldLongMsg", 2, "msgId=uniseq:" + ((MessageRecord)localObject1).uniseq + ", sendGetUrlReq");
      }
      localObject2 = new bfba();
      ((bfba)localObject2).c = ((MessageRecord)localObject1).selfuin;
      ((bfba)localObject2).d = ((MessageRecord)localObject1).frienduin;
      ((bfba)localObject2).e = ((MessageRecord)localObject1).frienduin;
      ((bfba)localObject2).f = ((MessageRecord)localObject1).istroop;
      ((bfba)localObject2).jdField_a_of_type_ArrayOfByte = str.getBytes();
      localObject1 = new bfau();
      ((bfau)localObject1).jdField_a_of_type_Bfcb = this;
      ((bfau)localObject1).jdField_a_of_type_JavaLangString = "multi_msg_dw";
      ((bfau)localObject1).jdField_a_of_type_JavaUtilList.add(localObject2);
      ((bfau)localObject1).jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
      if (!e())
      {
        a(9366, "illegal app", null, this.jdField_a_of_type_Berr);
        this.jdField_d_of_type_Int = 16;
        d();
        return;
      }
    } while (!f());
    this.jdField_a_of_type_Bfau = ((bfau)localObject1);
    bfca.a((bfau)localObject1);
    for (;;)
    {
      this.jdField_c_of_type_Long = System.nanoTime();
      return;
      localObject2 = new bfau();
      ((bfau)localObject2).jdField_a_of_type_Bfcb = this;
      ((bfau)localObject2).jdField_a_of_type_JavaLangString = "pa_long_message";
      ((bfau)localObject2).jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
      if (!e())
      {
        a(9366, "illegal app", null, this.jdField_a_of_type_Berr);
        this.jdField_d_of_type_Int = 16;
        d();
        return;
      }
      if (!f()) {
        break;
      }
      this.jdField_a_of_type_Bfau = ((bfau)localObject2);
      bfaz localbfaz = new bfaz();
      localbfaz.jdField_a_of_type_JavaLangString = str;
      localbfaz.d = ((MessageRecord)localObject1).frienduin;
      ((bfau)localObject2).jdField_a_of_type_JavaUtilList.add(localbfaz);
      bfca.a((bfau)localObject2);
    }
  }
  
  private void i()
  {
    h();
  }
  
  private void p()
  {
    if (QLog.isColorLevel())
    {
      QLog.d("StructLongMessageDownloadProcessor", 2, "LongMessage Download Beacon Report Cancel");
      if (c(this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
        QLog.d("PaOldLongMsg", 2, "msgId=uniseq:" + this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq + ", cancle download task!");
      }
    }
    if (c(this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {}
    HashMap localHashMap;
    for (String str1 = "actOldLongMessageDownload";; str1 = "actLongMessageDownload")
    {
      localHashMap = new HashMap();
      localHashMap.put("param_uin", this.jdField_f_of_type_JavaLangString);
      localHashMap.put("param_puin", this.jdField_l_of_type_JavaLangString);
      localHashMap.put("param_channel", "0");
      localHashMap.put("param_errcode", String.valueOf(7));
      localHashMap.put("param_url", this.e);
      if (!QLog.isColorLevel()) {
        break;
      }
      Iterator localIterator = localHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        String str2 = (String)((Map.Entry)localObject).getKey();
        localObject = (String)((Map.Entry)localObject).getValue();
        QLog.d("StructLongMessageDownloadProcessorForReport", 2, str2 + (String)localObject);
      }
    }
    bdmc.a(BaseApplication.getContext()).a(null, str1, false, 0L, 0L, localHashMap, "", true);
  }
  
  public void a(int paramInt, MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("StructLongMessageDownloadProcessor", 2, "LongMessage Download Beacon Report Expired");
      if (c(this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
        QLog.d("PaOldLongMsg", 2, "msgId=uniseq:" + this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq + ", resource expired!");
      }
    }
    if (c(this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {}
    HashMap localHashMap;
    for (String str1 = "actOldLongMessageDownload";; str1 = "actLongMessageDownload")
    {
      localHashMap = new HashMap();
      localHashMap.put("param_uin", paramMessageRecord.selfuin);
      localHashMap.put("param_puin", paramMessageRecord.frienduin);
      localHashMap.put("param_resid", paramMessageRecord.getExtInfoFromExtStr("pub_long_msg_resid"));
      localHashMap.put("param_channel", "0");
      localHashMap.put("param_errcode", String.valueOf(paramInt));
      localHashMap.put("param_url", this.e);
      if (!QLog.isColorLevel()) {
        break;
      }
      paramMessageRecord = localHashMap.entrySet().iterator();
      while (paramMessageRecord.hasNext())
      {
        Object localObject = (Map.Entry)paramMessageRecord.next();
        String str2 = (String)((Map.Entry)localObject).getKey();
        localObject = (String)((Map.Entry)localObject).getValue();
        QLog.d("StructLongMessageDownloadProcessorForReport", 2, str2 + (String)localObject);
      }
    }
    bdmc.a(BaseApplication.getContext()).a(null, str1, false, 0L, 0L, localHashMap, "", true);
  }
  
  public void a(bfau parambfau, bfbj parambfbj)
  {
    if ((parambfbj != null) && (parambfbj.jdField_a_of_type_JavaUtilList != null) && (parambfbj.jdField_a_of_type_JavaUtilList.size() > 0) && ((parambfbj.jdField_a_of_type_JavaUtilList.get(0) instanceof bfbr)))
    {
      parambfau = (bfbr)parambfbj.jdField_a_of_type_JavaUtilList.get(0);
      if ((parambfau.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$RetInfo != null) && (parambfau.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$RetInfo.ret_code.get() == 0))
      {
        a(this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, parambfau.jdField_a_of_type_JavaLangString);
        bdmc.a(BaseApplication.getContext()).a(null, "actLongMessageTimeSSO", true, (System.nanoTime() - this.jdField_c_of_type_Long) / 1000000L, 0L, null, "", true);
        return;
      }
      this.jdField_d_of_type_Int = 1;
      d();
      return;
    }
    if ((parambfbj != null) && (parambfbj.jdField_a_of_type_JavaUtilList != null) && (parambfbj.jdField_a_of_type_JavaUtilList.size() > 0) && ((parambfbj.jdField_a_of_type_JavaUtilList.get(0) instanceof bfbs)))
    {
      parambfbj = (bfbs)parambfbj.jdField_a_of_type_JavaUtilList.get(0);
      if (QLog.isColorLevel())
      {
        QLog.d("StructLongMessageDownloadProcessor", 2, "onBusiProtoResp->oldLongMsg procUrl:" + parambfbj.toString());
        QLog.d("PaOldLongMsg", 2, "msgId=uniseq:" + this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq + ", onBusiProtoResp->oldLongMsg procUrl:" + parambfbj.toString());
      }
      if (parambfbj.c == 0) {
        switch (parambfbj.jdField_a_of_type_Int)
        {
        case 1: 
        default: 
          parambfau = "http://";
          bewy localbewy = (bewy)parambfbj.jdField_a_of_type_JavaUtilArrayList.get(0);
          parambfau = parambfau + localbewy.jdField_a_of_type_JavaLangString;
          if (localbewy.jdField_a_of_type_Int != 80) {
            parambfau = parambfau + ":" + localbewy.jdField_a_of_type_Int;
          }
          break;
        }
      }
    }
    for (;;)
    {
      parambfau = parambfau + parambfbj.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_ArrayOfByte = parambfbj.b;
      a(this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, parambfau);
      bdmc.a(BaseApplication.getContext()).a(null, "actOldLongMessageTimeSSO", true, (System.nanoTime() - this.jdField_c_of_type_Long) / 1000000L, 0L, null, "", true);
      return;
      parambfau = "http://";
      break;
      parambfau = "https://";
      break;
      this.jdField_d_of_type_Int = 1;
      d();
      return;
      this.jdField_d_of_type_Int = 1;
      d();
      return;
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    this.jdField_d_of_type_Int = 3;
    paramMessageRecord.saveExtInfoToExtStr("longMsg_State", String.valueOf(3));
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      MessageForStructing localMessageForStructing = (MessageForStructing)paramMessageRecord;
      localMessageForStructing.structingMsg.mMsgBrief = anzj.a(2131713392);
      localMessageForStructing.msgData = localMessageForStructing.structingMsg.getBytes();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Beyg.c, this.jdField_a_of_type_Beyg.jdField_a_of_type_Int, localMessageForStructing.uniseq, localMessageForStructing.msgData);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Beyg.c, this.jdField_a_of_type_Beyg.jdField_a_of_type_Int, localMessageForStructing.uniseq, "extStr", localMessageForStructing.extStr);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().notifyUI(999, true, this.jdField_a_of_type_Beyg.c);
    }
    g();
    a(this.jdField_d_of_type_Int, paramMessageRecord);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StructLongMessageDownloadProcessor", 2, String.format("LongMessage Download Beacon Report ErrCode=%d mReportedFlag=%x ", new Object[] { Integer.valueOf(this.jdField_d_of_type_Int), Integer.valueOf(this.n) }) + hashCode());
    }
    if ((this.j) || ((paramBoolean) && ((this.n & 0x2) > 0)) || ((!paramBoolean) && ((this.n & 0x1) > 0))) {
      return;
    }
    int j = this.n;
    int i;
    if (paramBoolean)
    {
      i = 2;
      this.n = (i | j);
      if (!c(this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
        break label436;
      }
    }
    long l1;
    label436:
    for (String str1 = "actOldLongMessageDownload";; str1 = "actLongMessageDownload")
    {
      this.jdField_l_of_type_Long = System.currentTimeMillis();
      l1 = (System.nanoTime() - this.jdField_k_of_type_Long) / 1000000L;
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uin", this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.selfuin);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_puin", this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_resid", this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getExtInfoFromExtStr("pub_long_msg_resid"));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_ip_source", "" + this.r);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_channel", "0");
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errcode", String.valueOf(this.jdField_d_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_url", this.e);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_http_error_code", String.valueOf(this.q));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_android_error_code", String.valueOf(this.jdField_k_of_type_Int));
      if (!QLog.isColorLevel()) {
        break label444;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        String str2 = (String)((Map.Entry)localObject).getKey();
        localObject = (String)((Map.Entry)localObject).getValue();
        QLog.d("StructLongMessageDownloadProcessorForReport", 2, str2 + (String)localObject);
      }
      i = 1;
      break;
    }
    label444:
    if (paramBoolean) {
      bdmc.a(BaseApplication.getContext()).a(null, str1, true, l1, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "", true);
    }
    for (;;)
    {
      m();
      return;
      bdmc.a(BaseApplication.getContext()).a(null, str1, false, l1, 0L, this.jdField_a_of_type_JavaUtilHashMap, "", true);
    }
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    long l1;
    do
    {
      return false;
      l1 = NetConnInfoCenter.getServerTime();
    } while (paramMessageRecord.time >= l1 - 604800L);
    return true;
  }
  
  public void aN_()
  {
    super.aN_();
    if (!a()) {
      h();
    }
  }
  
  public void b()
  {
    b(this.jdField_a_of_type_Beyg.jdField_a_of_type_Long);
    this.jdField_d_of_type_Int = 7;
    f();
  }
  
  public void b(long paramLong)
  {
    synchronized (jdField_c_of_type_JavaUtilArrayList)
    {
      if ((jdField_c_of_type_JavaUtilArrayList == null) || (jdField_c_of_type_JavaUtilArrayList.size() == 0)) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("StructLongMessageDownloadProcessor", 2, "cancelAllTask msgid" + paramLong);
      }
      beyb localbeyb = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (localbeyb != null)
      {
        Iterator localIterator = jdField_c_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          beyg localbeyg = (beyg)localIterator.next();
          if (localbeyg.jdField_a_of_type_Long == paramLong)
          {
            localbeyb.c(localbeyg.c, localbeyg.jdField_a_of_type_Long);
            jdField_c_of_type_JavaUtilArrayList.remove(localbeyg);
          }
        }
      }
      return;
    }
  }
  
  public int c()
  {
    return super.c();
  }
  
  public void d()
  {
    super.d();
    if (QLog.isColorLevel())
    {
      QLog.d("StructLongMessageDownloadProcessor", 2, "msgId=" + this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq + ", receiveError");
      if (c(this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
        QLog.d("PaOldLongMsg", 2, "msgId=uniseq:" + this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq + ", receiveError");
      }
    }
    f(2005);
    d(2005);
    g();
  }
  
  public void e()
  {
    super.e();
    if (QLog.isColorLevel())
    {
      QLog.d("StructLongMessageDownloadProcessor", 2, "msgId=" + this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq + ", receiveSuccess");
      if (c(this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
        QLog.d("PaOldLongMsg", 2, "msgId=uniseq:" + this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq + ", receiveSuccess");
      }
    }
    f(2003);
    d(2003);
    g();
  }
  
  public void f()
  {
    p();
  }
  
  public void onResp(bevm parambevm)
  {
    i = 1;
    if (this.jdField_f_of_type_Boolean) {
      ThreadManager.getSubThreadHandler().removeCallbacks(this);
    }
    if (parambevm == null) {
      return;
    }
    super.onResp(parambevm);
    this.jdField_k_of_type_Int = parambevm.jdField_b_of_type_Int;
    if (QLog.isColorLevel()) {
      QLog.d("StructLongMessageDownloadProcessor", 2, "LongMessage Download time end: " + System.currentTimeMillis());
    }
    if ((parambevm.jdField_a_of_type_Bevl instanceof beum))
    {
      b("onResp", "result:" + parambevm.jdField_a_of_type_Int + " errCode:" + parambevm.c + " errDesc:" + parambevm.jdField_a_of_type_JavaLangString);
      this.q = parambevm.c;
      beum localbeum = (beum)parambevm.jdField_a_of_type_Bevl;
      if (localbeum.jdField_a_of_type_JavaLangString != null)
      {
        Iterator localIterator = b.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if (localbeum.jdField_a_of_type_JavaLangString.equals(((beum)localEntry.getValue()).jdField_a_of_type_JavaLangString)) {
            b.remove(localEntry.getKey());
          }
        }
      }
    }
    if (this.jdField_a_of_type_Bevl != null) {
      this.jdField_a_of_type_Bevl.jdField_a_of_type_Beuq = null;
    }
    this.jdField_a_of_type_Bevl = null;
    if ((parambevm.jdField_a_of_type_Int == 0) && (parambevm.jdField_a_of_type_ArrayOfByte != null) && (parambevm.jdField_a_of_type_ArrayOfByte.length > 0))
    {
      parambevm = parambevm.jdField_a_of_type_ArrayOfByte;
      this.jdField_a_of_type_Long = parambevm.length;
      if ((!(this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForStructing)) || (c(this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord))) {}
      for (;;)
      {
        try
        {
          if (QLog.isColorLevel())
          {
            QLog.d("StructLongMessageDownloadProcessor", 2, "onResp->oldLongMsg");
            QLog.d("PaOldLongMsg", 2, "msgId=uniseq:" + this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq + ", onResp->getStructMsgFromXmlBuff");
          }
          this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = bdow.a(a(parambevm), -1);
        }
        catch (Exception parambevm)
        {
          continue;
          i = 0;
          continue;
        }
        if ((this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop == 1008) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null) && ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgBrief)) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mEmptyMsgBriefModified))) {
          this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgBrief = AbsStructMsg.PA_DEFAULT_MSG_BRIEF;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg == null) {
          continue;
        }
        this.jdField_d_of_type_Int = 0;
        e();
        if (!c(this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
          continue;
        }
        bdmc.a(BaseApplication.getContext()).a(null, "actOldLongMessageTimeDownload", true, (System.nanoTime() - this.jdField_d_of_type_Long) / 1000000L, 0L, null, "", true);
        return;
        this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = bdow.a(parambevm, -1);
      }
      bdmc.a(BaseApplication.getContext()).a(null, "actLongMessageTimeDownload", true, (System.nanoTime() - this.jdField_d_of_type_Long) / 1000000L, 0L, null, "", true);
      return;
      if ((this.e != null) && (!"".equals(this.e))) {
        besx.a().a().a(bews.a(this.e));
      }
      if (this.jdField_f_of_type_Boolean)
      {
        if (this.r == 5) {}
        for (i = 9;; i = 12)
        {
          this.r = i;
          i();
          return;
        }
      }
      this.jdField_d_of_type_Int = 12;
      d();
      return;
    }
    if ((this.e != null) && (!"".equals(this.e))) {
      besx.a().a().a(bews.a(this.e));
    }
    if (((this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForStructing)) && (a(this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) && (399 < this.q) && (this.q < 500))
    {
      if (i != 0)
      {
        a(this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
        return;
      }
      if ((parambevm.jdField_b_of_type_Int == 9364) && (this.m < 3))
      {
        this.m += 1;
        if (QLog.isColorLevel()) {
          QLog.d("StructLongMessageDownloadProcessor", 2, "LongMessage Download Fail. Net Changed. Retry " + this.m);
        }
        n();
        this.r = 15;
        h();
        return;
      }
      if (this.jdField_f_of_type_Boolean)
      {
        if (this.r == 5) {}
        for (i = 8;; i = 11)
        {
          this.r = i;
          i();
          return;
        }
      }
      this.jdField_d_of_type_Int = 14;
      d();
      return;
    }
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Bevl != null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("StructLongMessageDownloadProcessor", 2, "Direct download failed timeout");
      }
      this.jdField_a_of_type_Beuo.b(this.jdField_a_of_type_Bevl);
      this.jdField_a_of_type_Bevl = null;
    }
    if (this.r == 5) {}
    for (int i = 13;; i = 14)
    {
      this.r = i;
      if ((this.e != null) && (!"".equals(this.e))) {
        besx.a().a().a(bews.a(this.e));
      }
      h();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */