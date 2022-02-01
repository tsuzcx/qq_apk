package com.tencent.mqp.app.sec;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.ims.bankcode_info.BankcodeCtrlInfo;
import com.tencent.ims.bankcode_info.BankcodeElem;
import com.tencent.ims.bankcode_info.ElemPos;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForSafeGrayTips;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import localpb.richMsg.SafeMsg.SafeMoreInfo;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class MQPSensitiveMsgUtil
{
  private static int jdField_a_of_type_Int;
  private static BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new MQPSensitiveMsgUtil.4();
  private static Bundle jdField_a_of_type_AndroidOsBundle = new Bundle();
  private static MQPSensitiveMsgUtil jdField_a_of_type_ComTencentMqpAppSecMQPSensitiveMsgUtil;
  private static String jdField_a_of_type_JavaLangString = "0";
  
  static
  {
    jdField_a_of_type_ComTencentMqpAppSecMQPSensitiveMsgUtil = null;
  }
  
  private static int a(String paramString, int paramInt)
  {
    int j = 0;
    int i;
    if (paramInt > 0) {
      i = paramInt;
    } else {
      i = 0;
    }
    for (;;)
    {
      if (j < paramInt) {}
      try
      {
        int m = paramString.codePointAt(j);
        if (m == 20) {}
        int k;
        do
        {
          k = i + 1;
          break;
          k = i;
          if (EmotcationConstants.EMOJI_MAP.get(m, -1) < 0) {
            break;
          }
          k = i;
        } while (m > 65535);
        j += 1;
        i = k;
      }
      catch (Exception paramString) {}
    }
    return i;
    return i;
  }
  
  public static MQPSensitiveMsgUtil a()
  {
    if (jdField_a_of_type_ComTencentMqpAppSecMQPSensitiveMsgUtil == null)
    {
      jdField_a_of_type_ComTencentMqpAppSecMQPSensitiveMsgUtil = new MQPSensitiveMsgUtil();
      a();
    }
    return jdField_a_of_type_ComTencentMqpAppSecMQPSensitiveMsgUtil;
  }
  
  private static Object a(String paramString, int paramInt, long paramLong, boolean paramBoolean, bankcode_info.BankcodeCtrlInfo paramBankcodeCtrlInfo)
  {
    return new MQPSensitiveMsgUtil.6(paramString, paramInt, paramLong, paramBankcodeCtrlInfo, paramBoolean);
  }
  
  private static void a()
  {
    Object localObject = new IntentFilter("mqq.intent.action.ACCOUNT_CHANGED");
    BaseApplication.getContext().registerReceiver(jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
    localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject == null) {
      return;
    }
    if (((AppRuntime)localObject).isLogin()) {
      c(((AppRuntime)localObject).getAccount());
    }
  }
  
  private static void a(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2)
  {
    if (paramSpannableStringBuilder == null) {
      return;
    }
    Object[] arrayOfObject = paramSpannableStringBuilder.getSpans(paramInt1, paramInt2, Object.class);
    int j = arrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfObject[i];
      int k = paramSpannableStringBuilder.getSpanStart(localObject);
      int m = paramSpannableStringBuilder.getSpanEnd(localObject);
      int n = paramSpannableStringBuilder.getSpanFlags(localObject);
      if ((k < paramInt1) && (m <= paramInt2))
      {
        paramSpannableStringBuilder.setSpan(localObject, k, paramInt1, n);
      }
      else if ((k >= paramInt1) && (m <= paramInt2) && (!(localObject instanceof EmoticonSpan)))
      {
        paramSpannableStringBuilder.removeSpan(localObject);
      }
      else if ((k > paramInt1) && (k < paramInt2) && (m > paramInt2))
      {
        paramSpannableStringBuilder.setSpan(localObject, paramInt2, m, n);
      }
      else if ((k < paramInt1) && (m > paramInt2))
      {
        paramSpannableStringBuilder.setSpan(localObject, k, paramInt1, n);
        paramSpannableStringBuilder.setSpan(localObject, paramInt2, m, n);
      }
      i += 1;
    }
  }
  
  public static void a(MessageRecord paramMessageRecord)
  {
    Object localObject1 = paramMessageRecord.getExtInfoFromExtStr("sens_msg_ctrl_info");
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return;
    }
    Object localObject3 = new bankcode_info.BankcodeCtrlInfo();
    Object localObject2;
    try
    {
      ((bankcode_info.BankcodeCtrlInfo)localObject3).mergeFrom(HexUtil.hexStr2Bytes((String)localObject1));
      if (((bankcode_info.BankcodeCtrlInfo)localObject3).bankcode_elems.has()) {
        localObject1 = ((bankcode_info.BankcodeCtrlInfo)localObject3).bankcode_elems.get();
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localObject2 = null;
    }
    if (localObject2 == null) {
      return;
    }
    localObject3 = ((List)localObject2).iterator();
    int j = 0;
    int i;
    while (((Iterator)localObject3).hasNext())
    {
      bankcode_info.BankcodeElem localBankcodeElem = (bankcode_info.BankcodeElem)((Iterator)localObject3).next();
      if (localBankcodeElem.bankcode_attr.has()) {
        i = localBankcodeElem.bankcode_attr.get();
      } else {
        i = 0;
      }
      if (i > j) {
        j = i;
      }
    }
    if (j != 20) {
      return;
    }
    localObject3 = ((List)localObject2).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject2 = (bankcode_info.BankcodeElem)((Iterator)localObject3).next();
      if (((bankcode_info.BankcodeElem)localObject2).bankcode_attr.has()) {
        i = ((bankcode_info.BankcodeElem)localObject2).bankcode_attr.get();
      } else {
        i = 0;
      }
      if (i == 20)
      {
        if (((bankcode_info.BankcodeElem)localObject2).clean_bankcode.has()) {
          localObject2 = ((bankcode_info.BankcodeElem)localObject2).clean_bankcode.get();
        } else {
          localObject2 = null;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          a().a((String)localObject2);
        }
      }
    }
    paramMessageRecord.saveExtInfoToExtStr("sens_msg_confirmed", "1");
  }
  
  /* Error */
  public static void a(MessageRecord paramMessageRecord, List<MessageRecord> paramList, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 151	com/tencent/ims/bankcode_info$BankcodeCtrlInfo
    //   3: dup
    //   4: invokespecial 152	com/tencent/ims/bankcode_info$BankcodeCtrlInfo:<init>	()V
    //   7: astore 16
    //   9: aload 16
    //   11: aload_3
    //   12: invokevirtual 162	com/tencent/ims/bankcode_info$BankcodeCtrlInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   15: pop
    //   16: aload 16
    //   18: getfield 230	com/tencent/ims/bankcode_info$BankcodeCtrlInfo:msgtail_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   21: invokevirtual 233	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   24: ifeq +16 -> 40
    //   27: aload 16
    //   29: getfield 230	com/tencent/ims/bankcode_info$BankcodeCtrlInfo:msgtail_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   32: invokevirtual 234	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   35: istore 5
    //   37: goto +6 -> 43
    //   40: iconst_0
    //   41: istore 5
    //   43: aload 16
    //   45: getfield 166	com/tencent/ims/bankcode_info$BankcodeCtrlInfo:bankcode_elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   48: invokevirtual 171	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   51: ifeq +15 -> 66
    //   54: aload 16
    //   56: getfield 166	com/tencent/ims/bankcode_info$BankcodeCtrlInfo:bankcode_elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   59: invokevirtual 174	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   62: astore_3
    //   63: goto +5 -> 68
    //   66: aconst_null
    //   67: astore_3
    //   68: iload 5
    //   70: istore 9
    //   72: goto +28 -> 100
    //   75: astore_3
    //   76: goto +14 -> 90
    //   79: astore_3
    //   80: goto +7 -> 87
    //   83: astore_3
    //   84: aconst_null
    //   85: astore 16
    //   87: iconst_0
    //   88: istore 5
    //   90: aload_3
    //   91: invokevirtual 177	java/lang/Exception:printStackTrace	()V
    //   94: aconst_null
    //   95: astore_3
    //   96: iload 5
    //   98: istore 9
    //   100: aload_3
    //   101: ifnonnull +4 -> 105
    //   104: return
    //   105: aload_0
    //   106: ldc 236
    //   108: invokevirtual 143	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   111: astore 17
    //   113: aload 17
    //   115: invokestatic 149	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   118: ifne +26 -> 144
    //   121: aload 17
    //   123: invokestatic 242	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   126: istore 6
    //   128: goto +94 -> 222
    //   131: astore 17
    //   133: aload 17
    //   135: invokevirtual 177	java/lang/Exception:printStackTrace	()V
    //   138: iconst_0
    //   139: istore 6
    //   141: goto +81 -> 222
    //   144: aload_3
    //   145: invokeinterface 183 1 0
    //   150: astore 17
    //   152: iconst_0
    //   153: istore 5
    //   155: iload 5
    //   157: istore 6
    //   159: aload 17
    //   161: invokeinterface 188 1 0
    //   166: ifeq +56 -> 222
    //   169: aload 17
    //   171: invokeinterface 192 1 0
    //   176: checkcast 194	com/tencent/ims/bankcode_info$BankcodeElem
    //   179: astore 18
    //   181: aload 18
    //   183: getfield 198	com/tencent/ims/bankcode_info$BankcodeElem:bankcode_attr	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   186: invokevirtual 201	com/tencent/mobileqq/pb/PBEnumField:has	()Z
    //   189: ifeq +16 -> 205
    //   192: aload 18
    //   194: getfield 198	com/tencent/ims/bankcode_info$BankcodeElem:bankcode_attr	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   197: invokevirtual 204	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   200: istore 6
    //   202: goto +6 -> 208
    //   205: iconst_0
    //   206: istore 6
    //   208: iload 6
    //   210: iload 5
    //   212: if_icmple -57 -> 155
    //   215: iload 6
    //   217: istore 5
    //   219: goto -64 -> 155
    //   222: iload 6
    //   224: bipush 20
    //   226: if_icmpne +164 -> 390
    //   229: aload_0
    //   230: ldc 244
    //   232: invokevirtual 143	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   235: astore 17
    //   237: aload 17
    //   239: invokestatic 149	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   242: ifne +23 -> 265
    //   245: aload 17
    //   247: invokestatic 250	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   250: istore 15
    //   252: goto +141 -> 393
    //   255: astore 17
    //   257: aload 17
    //   259: invokevirtual 177	java/lang/Exception:printStackTrace	()V
    //   262: goto +128 -> 390
    //   265: aload_3
    //   266: invokeinterface 183 1 0
    //   271: astore 18
    //   273: iconst_0
    //   274: istore 15
    //   276: aload 18
    //   278: invokeinterface 188 1 0
    //   283: ifeq +104 -> 387
    //   286: aload 18
    //   288: invokeinterface 192 1 0
    //   293: checkcast 194	com/tencent/ims/bankcode_info$BankcodeElem
    //   296: astore 17
    //   298: aload 17
    //   300: getfield 198	com/tencent/ims/bankcode_info$BankcodeElem:bankcode_attr	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   303: invokevirtual 201	com/tencent/mobileqq/pb/PBEnumField:has	()Z
    //   306: ifeq +16 -> 322
    //   309: aload 17
    //   311: getfield 198	com/tencent/ims/bankcode_info$BankcodeElem:bankcode_attr	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   314: invokevirtual 204	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   317: istore 5
    //   319: goto +6 -> 325
    //   322: iconst_0
    //   323: istore 5
    //   325: iload 5
    //   327: bipush 20
    //   329: if_icmpeq +6 -> 335
    //   332: goto -56 -> 276
    //   335: aload 17
    //   337: getfield 208	com/tencent/ims/bankcode_info$BankcodeElem:clean_bankcode	Lcom/tencent/mobileqq/pb/PBStringField;
    //   340: invokevirtual 211	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   343: ifeq +16 -> 359
    //   346: aload 17
    //   348: getfield 208	com/tencent/ims/bankcode_info$BankcodeElem:clean_bankcode	Lcom/tencent/mobileqq/pb/PBStringField;
    //   351: invokevirtual 213	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   354: astore 17
    //   356: goto +6 -> 362
    //   359: aconst_null
    //   360: astore 17
    //   362: aload 17
    //   364: invokestatic 149	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   367: ifne -91 -> 276
    //   370: invokestatic 215	com/tencent/mqp/app/sec/MQPSensitiveMsgUtil:a	()Lcom/tencent/mqp/app/sec/MQPSensitiveMsgUtil;
    //   373: aload 17
    //   375: invokevirtual 252	com/tencent/mqp/app/sec/MQPSensitiveMsgUtil:a	(Ljava/lang/String;)Z
    //   378: ifne -102 -> 276
    //   381: iconst_1
    //   382: istore 15
    //   384: goto -108 -> 276
    //   387: goto +6 -> 393
    //   390: iconst_0
    //   391: istore 15
    //   393: iload_2
    //   394: ifne +34 -> 428
    //   397: iload 9
    //   399: iconst_1
    //   400: if_icmpne +28 -> 428
    //   403: iload 6
    //   405: bipush 30
    //   407: if_icmpeq +15 -> 422
    //   410: iload 6
    //   412: bipush 20
    //   414: if_icmpne +14 -> 428
    //   417: iload 15
    //   419: ifeq +9 -> 428
    //   422: iconst_1
    //   423: istore 15
    //   425: goto +6 -> 431
    //   428: iconst_0
    //   429: istore 15
    //   431: aload_0
    //   432: ldc 254
    //   434: iload 15
    //   436: invokestatic 258	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   439: invokevirtual 225	com/tencent/mobileqq/data/MessageRecord:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   442: aload_1
    //   443: invokeinterface 183 1 0
    //   448: astore 20
    //   450: iconst_0
    //   451: istore 5
    //   453: iconst_0
    //   454: istore 10
    //   456: iconst_0
    //   457: istore 11
    //   459: aload_3
    //   460: astore_1
    //   461: aload 20
    //   463: invokeinterface 188 1 0
    //   468: ifeq +743 -> 1211
    //   471: aload 20
    //   473: invokeinterface 192 1 0
    //   478: checkcast 140	com/tencent/mobileqq/data/MessageRecord
    //   481: astore 21
    //   483: aload 21
    //   485: instanceof 260
    //   488: ifeq +710 -> 1198
    //   491: iload 5
    //   493: istore 6
    //   495: iload 6
    //   497: istore 7
    //   499: iload 6
    //   501: aload_1
    //   502: invokeinterface 263 1 0
    //   507: if_icmpge +609 -> 1116
    //   510: iload 6
    //   512: iconst_1
    //   513: iadd
    //   514: istore 12
    //   516: aload_1
    //   517: iload 6
    //   519: invokeinterface 266 2 0
    //   524: checkcast 194	com/tencent/ims/bankcode_info$BankcodeElem
    //   527: astore 18
    //   529: aload 18
    //   531: ifnonnull +10 -> 541
    //   534: aload_1
    //   535: astore_3
    //   536: aload_3
    //   537: astore_1
    //   538: goto +567 -> 1105
    //   541: aload 18
    //   543: getfield 270	com/tencent/ims/bankcode_info$BankcodeElem:bankcode_pos	Lcom/tencent/ims/bankcode_info$ElemPos;
    //   546: invokevirtual 273	com/tencent/ims/bankcode_info$ElemPos:has	()Z
    //   549: ifeq +76 -> 625
    //   552: aload 18
    //   554: getfield 270	com/tencent/ims/bankcode_info$BankcodeElem:bankcode_pos	Lcom/tencent/ims/bankcode_info$ElemPos;
    //   557: invokevirtual 276	com/tencent/ims/bankcode_info$ElemPos:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   560: checkcast 272	com/tencent/ims/bankcode_info$ElemPos
    //   563: astore_3
    //   564: aload_3
    //   565: getfield 279	com/tencent/ims/bankcode_info$ElemPos:start_offset	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   568: invokevirtual 233	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   571: ifeq +15 -> 586
    //   574: aload_3
    //   575: getfield 279	com/tencent/ims/bankcode_info$ElemPos:start_offset	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   578: invokevirtual 234	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   581: istore 6
    //   583: goto +6 -> 589
    //   586: iconst_0
    //   587: istore 6
    //   589: aload_3
    //   590: getfield 282	com/tencent/ims/bankcode_info$ElemPos:end_offset	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   593: invokevirtual 233	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   596: ifeq +19 -> 615
    //   599: aload_3
    //   600: getfield 282	com/tencent/ims/bankcode_info$ElemPos:end_offset	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   603: invokevirtual 234	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   606: istore 7
    //   608: iload 6
    //   610: istore 13
    //   612: goto +19 -> 631
    //   615: iconst_0
    //   616: istore 7
    //   618: iload 6
    //   620: istore 13
    //   622: goto +9 -> 631
    //   625: iconst_0
    //   626: istore 7
    //   628: iconst_0
    //   629: istore 13
    //   631: iload 7
    //   633: iload 10
    //   635: if_icmplt -101 -> 534
    //   638: iload 13
    //   640: aload 21
    //   642: getfield 285	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   645: invokevirtual 288	java/lang/String:length	()I
    //   648: iload 10
    //   650: iadd
    //   651: if_icmple +6 -> 657
    //   654: goto -120 -> 534
    //   657: aload 18
    //   659: getfield 291	com/tencent/ims/bankcode_info$BankcodeElem:bankcode_hidden_pos	Lcom/tencent/ims/bankcode_info$ElemPos;
    //   662: invokevirtual 273	com/tencent/ims/bankcode_info$ElemPos:has	()Z
    //   665: ifeq +68 -> 733
    //   668: aload 18
    //   670: getfield 291	com/tencent/ims/bankcode_info$BankcodeElem:bankcode_hidden_pos	Lcom/tencent/ims/bankcode_info$ElemPos;
    //   673: invokevirtual 276	com/tencent/ims/bankcode_info$ElemPos:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   676: checkcast 272	com/tencent/ims/bankcode_info$ElemPos
    //   679: astore_3
    //   680: aload_3
    //   681: getfield 279	com/tencent/ims/bankcode_info$ElemPos:start_offset	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   684: invokevirtual 233	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   687: ifeq +15 -> 702
    //   690: aload_3
    //   691: getfield 279	com/tencent/ims/bankcode_info$ElemPos:start_offset	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   694: invokevirtual 234	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   697: istore 8
    //   699: goto +6 -> 705
    //   702: iconst_0
    //   703: istore 8
    //   705: aload_3
    //   706: getfield 282	com/tencent/ims/bankcode_info$ElemPos:end_offset	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   709: invokevirtual 233	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   712: ifeq +15 -> 727
    //   715: aload_3
    //   716: getfield 282	com/tencent/ims/bankcode_info$ElemPos:end_offset	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   719: invokevirtual 234	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   722: istore 6
    //   724: goto +15 -> 739
    //   727: iconst_0
    //   728: istore 6
    //   730: goto +9 -> 739
    //   733: iconst_0
    //   734: istore 6
    //   736: iconst_0
    //   737: istore 8
    //   739: aload 21
    //   741: getfield 285	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   744: iload 13
    //   746: iload 11
    //   748: iadd
    //   749: iload 10
    //   751: isub
    //   752: invokestatic 293	com/tencent/mqp/app/sec/MQPSensitiveMsgUtil:a	(Ljava/lang/String;I)I
    //   755: istore 13
    //   757: aload 21
    //   759: getfield 285	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   762: iload 7
    //   764: iload 11
    //   766: iadd
    //   767: iload 10
    //   769: isub
    //   770: invokestatic 293	com/tencent/mqp/app/sec/MQPSensitiveMsgUtil:a	(Ljava/lang/String;I)I
    //   773: istore 7
    //   775: iload 8
    //   777: iload 13
    //   779: iadd
    //   780: istore 8
    //   782: iload 13
    //   784: aload 21
    //   786: getfield 285	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   789: invokevirtual 288	java/lang/String:length	()I
    //   792: if_icmpge +304 -> 1096
    //   795: iload 7
    //   797: iconst_1
    //   798: iadd
    //   799: istore 7
    //   801: iload 7
    //   803: aload 21
    //   805: getfield 285	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   808: invokevirtual 288	java/lang/String:length	()I
    //   811: if_icmple +6 -> 817
    //   814: goto +282 -> 1096
    //   817: aload 21
    //   819: getfield 285	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   822: iload 13
    //   824: iload 7
    //   826: invokevirtual 297	java/lang/String:substring	(II)Ljava/lang/String;
    //   829: astore 22
    //   831: ldc_w 299
    //   834: astore 19
    //   836: ldc_w 299
    //   839: astore 17
    //   841: iconst_0
    //   842: istore 7
    //   844: iload 7
    //   846: aload 22
    //   848: invokevirtual 288	java/lang/String:length	()I
    //   851: if_icmpge +74 -> 925
    //   854: aload 22
    //   856: iload 7
    //   858: invokevirtual 303	java/lang/String:charAt	(I)C
    //   861: istore 4
    //   863: iload 9
    //   865: iconst_1
    //   866: if_icmpeq +9 -> 875
    //   869: aload 17
    //   871: astore_3
    //   872: goto +41 -> 913
    //   875: aload 17
    //   877: astore_3
    //   878: iload 4
    //   880: invokestatic 309	java/lang/Character:isDigit	(C)Z
    //   883: ifeq +30 -> 913
    //   886: new 311	java/lang/StringBuilder
    //   889: dup
    //   890: invokespecial 312	java/lang/StringBuilder:<init>	()V
    //   893: astore_3
    //   894: aload_3
    //   895: aload 17
    //   897: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   900: pop
    //   901: aload_3
    //   902: iload 4
    //   904: invokevirtual 319	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   907: pop
    //   908: aload_3
    //   909: invokevirtual 321	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   912: astore_3
    //   913: iload 7
    //   915: iconst_1
    //   916: iadd
    //   917: istore 7
    //   919: aload_3
    //   920: astore 17
    //   922: goto -78 -> 844
    //   925: aload 17
    //   927: invokestatic 149	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   930: ifeq +13 -> 943
    //   933: iload 15
    //   935: ifeq +8 -> 943
    //   938: aload_1
    //   939: astore_3
    //   940: goto -404 -> 536
    //   943: aload 18
    //   945: getfield 208	com/tencent/ims/bankcode_info$BankcodeElem:clean_bankcode	Lcom/tencent/mobileqq/pb/PBStringField;
    //   948: invokevirtual 211	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   951: ifeq +16 -> 967
    //   954: aload 18
    //   956: getfield 208	com/tencent/ims/bankcode_info$BankcodeElem:clean_bankcode	Lcom/tencent/mobileqq/pb/PBStringField;
    //   959: invokevirtual 213	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   962: astore 18
    //   964: goto +6 -> 970
    //   967: aconst_null
    //   968: astore 18
    //   970: aload_1
    //   971: astore_3
    //   972: iload 15
    //   974: ifeq -438 -> 536
    //   977: aload_1
    //   978: astore_3
    //   979: aload 17
    //   981: aload 18
    //   983: invokestatic 325	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   986: ifeq -450 -> 536
    //   989: iconst_0
    //   990: istore 7
    //   992: aload 19
    //   994: astore_3
    //   995: iload 6
    //   997: iload 13
    //   999: iadd
    //   1000: iconst_1
    //   1001: iadd
    //   1002: istore 14
    //   1004: iload 7
    //   1006: iload 14
    //   1008: iload 8
    //   1010: isub
    //   1011: if_icmpge +43 -> 1054
    //   1014: new 311	java/lang/StringBuilder
    //   1017: dup
    //   1018: invokespecial 312	java/lang/StringBuilder:<init>	()V
    //   1021: astore 17
    //   1023: aload 17
    //   1025: aload_3
    //   1026: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1029: pop
    //   1030: aload 17
    //   1032: ldc_w 327
    //   1035: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1038: pop
    //   1039: aload 17
    //   1041: invokevirtual 321	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1044: astore_3
    //   1045: iload 7
    //   1047: iconst_1
    //   1048: iadd
    //   1049: istore 7
    //   1051: goto -56 -> 995
    //   1054: aload 21
    //   1056: checkcast 260	com/tencent/mobileqq/data/MessageForText
    //   1059: astore 18
    //   1061: new 111	android/text/SpannableStringBuilder
    //   1064: dup
    //   1065: aload 18
    //   1067: getfield 331	com/tencent/mobileqq/data/MessageForText:sb	Ljava/lang/CharSequence;
    //   1070: invokespecial 334	android/text/SpannableStringBuilder:<init>	(Ljava/lang/CharSequence;)V
    //   1073: astore 17
    //   1075: aload 17
    //   1077: iload 8
    //   1079: iload 14
    //   1081: aload_3
    //   1082: invokevirtual 338	android/text/SpannableStringBuilder:replace	(IILjava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    //   1085: pop
    //   1086: aload 18
    //   1088: aload 17
    //   1090: putfield 331	com/tencent/mobileqq/data/MessageForText:sb	Ljava/lang/CharSequence;
    //   1093: goto +12 -> 1105
    //   1096: iload 12
    //   1098: iconst_1
    //   1099: isub
    //   1100: istore 7
    //   1102: goto +14 -> 1116
    //   1105: iload 12
    //   1107: istore 6
    //   1109: iload 12
    //   1111: istore 7
    //   1113: goto -614 -> 499
    //   1116: aload_0
    //   1117: getfield 341	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   1120: aload_0
    //   1121: getfield 344	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   1124: aload_0
    //   1125: getfield 348	com/tencent/mobileqq/data/MessageRecord:uniseq	J
    //   1128: iload_2
    //   1129: aload 16
    //   1131: iload 5
    //   1133: iload 7
    //   1135: aload 21
    //   1137: checkcast 260	com/tencent/mobileqq/data/MessageForText
    //   1140: iload 10
    //   1142: iload 11
    //   1144: isub
    //   1145: invokestatic 351	com/tencent/mqp/app/sec/MQPSensitiveMsgUtil:a	(Ljava/lang/String;IJZLcom/tencent/ims/bankcode_info$BankcodeCtrlInfo;IILcom/tencent/mobileqq/data/MessageForText;I)V
    //   1148: iload 11
    //   1150: aload 21
    //   1152: getfield 285	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   1155: aload 21
    //   1157: getfield 285	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   1160: invokevirtual 288	java/lang/String:length	()I
    //   1163: invokestatic 293	com/tencent/mqp/app/sec/MQPSensitiveMsgUtil:a	(Ljava/lang/String;I)I
    //   1166: aload 21
    //   1168: getfield 285	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   1171: invokevirtual 288	java/lang/String:length	()I
    //   1174: isub
    //   1175: iadd
    //   1176: istore 11
    //   1178: iload 10
    //   1180: aload 21
    //   1182: getfield 285	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   1185: invokevirtual 288	java/lang/String:length	()I
    //   1188: iadd
    //   1189: istore 6
    //   1191: iload 7
    //   1193: istore 5
    //   1195: goto +9 -> 1204
    //   1198: iload 10
    //   1200: iconst_1
    //   1201: iadd
    //   1202: istore 6
    //   1204: iload 6
    //   1206: istore 10
    //   1208: goto -747 -> 461
    //   1211: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1212	0	paramMessageRecord	MessageRecord
    //   0	1212	1	paramList	List<MessageRecord>
    //   0	1212	2	paramBoolean	boolean
    //   0	1212	3	paramArrayOfByte	byte[]
    //   861	42	4	c	char
    //   35	1159	5	i	int
    //   126	1079	6	j	int
    //   497	695	7	k	int
    //   697	381	8	m	int
    //   70	797	9	n	int
    //   454	753	10	i1	int
    //   457	720	11	i2	int
    //   514	596	12	i3	int
    //   610	390	13	i4	int
    //   1002	78	14	i5	int
    //   250	723	15	bool	boolean
    //   7	1123	16	localBankcodeCtrlInfo	bankcode_info.BankcodeCtrlInfo
    //   111	11	17	str1	String
    //   131	3	17	localException1	Exception
    //   150	96	17	localObject1	Object
    //   255	3	17	localException2	Exception
    //   296	793	17	localObject2	Object
    //   179	908	18	localObject3	Object
    //   834	159	19	str2	String
    //   448	24	20	localIterator	Iterator
    //   481	700	21	localMessageRecord	MessageRecord
    //   829	26	22	str3	String
    // Exception table:
    //   from	to	target	type
    //   43	63	75	java/lang/Exception
    //   9	37	79	java/lang/Exception
    //   0	9	83	java/lang/Exception
    //   121	128	131	java/lang/Exception
    //   245	252	255	java/lang/Exception
  }
  
  public static void a(String paramString1, int paramInt, long paramLong, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (!(BaseActivity.sTopActivity instanceof MultiForwardActivity))
    {
      if ((BaseActivity.sTopActivity instanceof ChatHistoryActivity)) {
        return;
      }
      Object localObject1 = MobileQQ.sMobileQQ.waitAppRuntime(null);
      if (localObject1 == null) {
        return;
      }
      QQMessageFacade localQQMessageFacade = (QQMessageFacade)((AppRuntime)localObject1).getManager(QQManagerFactory.MGR_MSG_FACADE);
      if (localQQMessageFacade == null) {
        return;
      }
      Object localObject2 = localQQMessageFacade.a(paramString1, paramInt, paramLong);
      if (localObject2 == null) {
        return;
      }
      localObject1 = ((MessageRecord)localObject2).getExtInfoFromExtStr("sens_msg_ctrl_info");
      boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
      int j = 0;
      int i;
      if (!bool)
      {
        try
        {
          Object localObject3 = new bankcode_info.BankcodeCtrlInfo();
          ((bankcode_info.BankcodeCtrlInfo)localObject3).mergeFrom(HexUtil.hexStr2Bytes((String)localObject1));
          if (((bankcode_info.BankcodeCtrlInfo)localObject3).msgtail_id.has()) {
            i = ((bankcode_info.BankcodeCtrlInfo)localObject3).msgtail_id.get();
          } else {
            i = 0;
          }
          try
          {
            if (((bankcode_info.BankcodeCtrlInfo)localObject3).bankcode_elems.has())
            {
              localObject1 = ((bankcode_info.BankcodeCtrlInfo)localObject3).bankcode_elems.get().iterator();
              j = 0;
              for (;;)
              {
                k = j;
                try
                {
                  if (!((Iterator)localObject1).hasNext()) {
                    break label244;
                  }
                  localObject3 = (bankcode_info.BankcodeElem)((Iterator)localObject1).next();
                  if (((bankcode_info.BankcodeElem)localObject3).bankcode_attr.has()) {
                    k = ((bankcode_info.BankcodeElem)localObject3).bankcode_attr.get();
                  } else {
                    k = 0;
                  }
                  if (k > j) {
                    j = k;
                  }
                }
                catch (Exception localException1)
                {
                  break label261;
                }
              }
            }
            int k = 0;
            label244:
            j = k;
          }
          catch (Exception localException2) {}
          localException3.printStackTrace();
        }
        catch (Exception localException3)
        {
          i = 0;
        }
      }
      else
      {
        label261:
        if ((localObject2 instanceof MessageForSafeGrayTips))
        {
          MessageForSafeGrayTips localMessageForSafeGrayTips = (MessageForSafeGrayTips)localObject2;
          if ((localMessageForSafeGrayTips.safeInfo != null) && (localMessageForSafeGrayTips.safeInfo.strMsgTxt.has())) {
            try
            {
              j = Integer.parseInt(localMessageForSafeGrayTips.safeInfo.strMsgTxt.get());
              i = 2;
            }
            catch (Exception localException4)
            {
              localException4.printStackTrace();
            }
          }
          i = 2;
        }
        else
        {
          i = 0;
        }
        j = 0;
      }
      String str = ((MessageRecord)localObject2).senderuin;
      localObject2 = DialogUtil.a(BaseActivity.sTopActivity, 230);
      ((QQCustomDialog)localObject2).setTitle(paramString2);
      ((QQCustomDialog)localObject2).setMessage(paramString3);
      if (!TextUtils.isEmpty(paramString4)) {
        ((QQCustomDialog)localObject2).setPositiveButton(paramString4, new MQPSensitiveMsgUtil.1(str, i, j, localQQMessageFacade, paramString1, paramInt, paramLong));
      }
      if (!TextUtils.isEmpty(paramString5)) {
        ((QQCustomDialog)localObject2).setNegativeButton(paramString5, new MQPSensitiveMsgUtil.2(str, i, j));
      }
      ((QQCustomDialog)localObject2).show();
    }
  }
  
  private static void a(String paramString, int paramInt1, long paramLong, boolean paramBoolean, bankcode_info.BankcodeCtrlInfo paramBankcodeCtrlInfo, int paramInt2, int paramInt3, MessageForText paramMessageForText, int paramInt4)
  {
    if (paramBankcodeCtrlInfo != null)
    {
      if (!paramBankcodeCtrlInfo.bankcode_elems.has()) {
        return;
      }
      int j;
      if (paramBankcodeCtrlInfo.msgtail_id.has()) {
        j = paramBankcodeCtrlInfo.msgtail_id.get();
      } else {
        j = 0;
      }
      int k = paramInt2;
      while ((k < paramBankcodeCtrlInfo.bankcode_elems.size()) && (k < paramInt3))
      {
        Object localObject = (bankcode_info.BankcodeElem)paramBankcodeCtrlInfo.bankcode_elems.get(k);
        if (localObject != null)
        {
          if (((bankcode_info.BankcodeElem)localObject).bankcode_pos.has())
          {
            localObject = (bankcode_info.ElemPos)((bankcode_info.BankcodeElem)localObject).bankcode_pos.get();
            if (localObject != null)
            {
              if (((bankcode_info.ElemPos)localObject).start_offset.has()) {
                paramInt2 = ((bankcode_info.ElemPos)localObject).start_offset.get();
              } else {
                paramInt2 = 0;
              }
              if (((bankcode_info.ElemPos)localObject).end_offset.has())
              {
                i = ((bankcode_info.ElemPos)localObject).end_offset.get();
                break label183;
              }
              i = 0;
              break label183;
            }
          }
          int i = 0;
          paramInt2 = 0;
          label183:
          if ((i >= paramInt4) && (paramInt2 <= paramMessageForText.sb.length() + paramInt4))
          {
            String str = paramMessageForText.getExtInfoFromExtStr("sens_msg_original_text");
            localObject = str;
            if (TextUtils.isEmpty(str)) {
              localObject = paramMessageForText.sb.toString();
            }
            int n = a((String)localObject, paramInt2 - paramInt4);
            int i1 = a((String)localObject, i - paramInt4);
            paramInt2 = n;
            while ((j != 1) || (Character.isDigit(paramMessageForText.sb.charAt(paramInt2))))
            {
              i = paramInt2 - 1;
              paramInt2 = i;
              if (i < 0) {
                paramInt2 = i;
              }
            }
            if (paramInt2 < 0) {
              i = 0;
            } else {
              i = paramInt2;
            }
            paramInt2 = i1;
            while ((j != 1) || (Character.isDigit(paramMessageForText.sb.charAt(paramInt2))))
            {
              int m = paramInt2 + 1;
              paramInt2 = m;
              if (m >= paramMessageForText.sb.length()) {
                paramInt2 = m;
              }
            }
            localObject = new SpannableStringBuilder(paramMessageForText.sb);
            a((SpannableStringBuilder)localObject, i, paramInt2);
            ((SpannableStringBuilder)localObject).setSpan(a(paramString, paramInt1, paramLong, paramBoolean, paramBankcodeCtrlInfo), n, i1 + 1, 33);
            paramMessageForText.sb = ((CharSequence)localObject);
          }
        }
        k += 1;
      }
    }
  }
  
  private static void c(String paramString)
  {
    jdField_a_of_type_Int = 0;
    jdField_a_of_type_JavaLangString = paramString;
    if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
    {
      jdField_a_of_type_AndroidOsBundle.putBundle(jdField_a_of_type_JavaLangString, null);
      ThreadManager.executeOnFileThread(new MQPSensitiveMsgUtil.5());
    }
  }
  
  public void a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!a(paramString)))
    {
      jdField_a_of_type_Int = (jdField_a_of_type_Int + 1) % 10;
      String str1 = MD5Utils.encodeHexStr(paramString);
      String str2 = Integer.toString(jdField_a_of_type_Int);
      Bundle localBundle = jdField_a_of_type_AndroidOsBundle.getBundle(jdField_a_of_type_JavaLangString);
      if (localBundle != null)
      {
        Object localObject = null;
        Iterator localIterator = localBundle.keySet().iterator();
        String str3;
        do
        {
          paramString = localObject;
          if (!localIterator.hasNext()) {
            break;
          }
          paramString = (String)localIterator.next();
          str3 = localBundle.getString(paramString);
        } while ((TextUtils.isEmpty(str3)) || (!str3.equals(str2)));
        if (!TextUtils.isEmpty(paramString)) {
          localBundle.remove(paramString);
        }
        localBundle.putString(str1, str2);
      }
      ThreadManager.executeOnFileThread(new MQPSensitiveMsgUtil.3(this, str2, str1));
    }
  }
  
  public boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Bundle localBundle = jdField_a_of_type_AndroidOsBundle.getBundle(jdField_a_of_type_JavaLangString);
      if ((localBundle != null) && (localBundle.containsKey(MD5Utils.encodeHexStr(paramString)))) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mqp.app.sec.MQPSensitiveMsgUtil
 * JD-Core Version:    0.7.0.1
 */