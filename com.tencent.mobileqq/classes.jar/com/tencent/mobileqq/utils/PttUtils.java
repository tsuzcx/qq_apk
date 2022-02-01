package com.tencent.mobileqq.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.item.PttSlideStateHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.PttAutoChangeBean;
import com.tencent.mobileqq.config.business.qvip.QVipAutoPttConfig;
import com.tencent.mobileqq.config.business.qvip.QVipAutoPttProcessor;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import tencent.im.cs.ptt_waveform.ptt_waveform.PttWaveform;

public class PttUtils
{
  private static final SparseIntArray a = new SparseIntArray(8);
  
  static
  {
    a.put(4, 13);
    a.put(12, 14);
    a.put(20, 16);
    a.put(28, 18);
    a.put(36, 20);
    a.put(44, 21);
    a.put(52, 27);
    a.put(60, 32);
  }
  
  public static ptt_waveform.PttWaveform a(int[] paramArrayOfInt)
  {
    ptt_waveform.PttWaveform localPttWaveform = new ptt_waveform.PttWaveform();
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
    {
      localPttWaveform.uin32_size.set(paramArrayOfInt.length);
      byte[] arrayOfByte = new byte[paramArrayOfInt.length];
      int j = 0;
      if (j < paramArrayOfInt.length)
      {
        int k = paramArrayOfInt[j];
        int i;
        if (k < 0) {
          i = 0;
        }
        for (;;)
        {
          arrayOfByte[j] = ((byte)(i & 0xFF));
          j += 1;
          break;
          i = k;
          if (k > 255) {
            i = 255;
          }
        }
      }
      localPttWaveform.bytes_amplitudes.set(ByteStringMicro.copyFrom(arrayOfByte));
    }
    return localPttWaveform;
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      str1 = paramQQAppInterface.getCurrentUin();
      if (!TextUtils.equals(PttSlideStateHelper.jdField_a_of_type_JavaLangString, str1))
      {
        PttSlideStateHelper.jdField_a_of_type_JavaLangString = str1;
        PttSlideStateHelper.g = false;
        QLog.e("vip_ptt.PttUtils", 1, "it have change the account so init ptt state value");
      }
    } while (PttSlideStateHelper.g);
    String str1 = "businessinfo_ptt_auto_change_text_" + paramQQAppInterface.getCurrentAccountUin();
    String str2 = "businessinfo_ptt_auto_change_time_" + paramQQAppInterface.getCurrentAccountUin();
    String str3 = "businessinfo_ptt_auto_change_guide_has_show_" + paramQQAppInterface.getCurrentAccountUin();
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("check_update_sp_key", 0);
    PttAutoChangeBean localPttAutoChangeBean = (PttAutoChangeBean)QConfigManager.a().a(442);
    QVipAutoPttConfig localQVipAutoPttConfig = QVipAutoPttProcessor.c();
    boolean bool2 = VipUtils.b(paramQQAppInterface);
    boolean bool1;
    if (localQVipAutoPttConfig.a > 1)
    {
      bool1 = bool2;
      label159:
      QLog.e("vip_ptt.PttUtils", 1, "ignore initAutoToTextSwitch is svip=" + bool2 + " stage=" + localQVipAutoPttConfig.a);
      if (((localPttAutoChangeBean == null) || (localPttAutoChangeBean.a())) && (!bool1)) {
        break label334;
      }
      paramQQAppInterface = localSharedPreferences.edit();
      paramQQAppInterface.putBoolean(str1, false);
      paramQQAppInterface.apply();
      PttSlideStateHelper.c = false;
    }
    for (;;)
    {
      PttSlideStateHelper.jdField_a_of_type_Long = localSharedPreferences.getLong(str2, 9223372036854775807L);
      PttSlideStateHelper.d = localSharedPreferences.getBoolean(str3, false);
      PttSlideStateHelper.g = true;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("PttUtils", 2, "initAutoToTextSwitch switch:" + PttSlideStateHelper.c + ", time:" + PttSlideStateHelper.jdField_a_of_type_Long + ", hasAddTips:" + PttSlideStateHelper.d);
      return;
      bool1 = false;
      break label159;
      label334:
      PttSlideStateHelper.c = localSharedPreferences.getBoolean(str1, false);
      QLog.e("vip_ptt.PttUtils", 1, "initAutoToTextSwitch enable=" + PttSlideStateHelper.c);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    int i = 8;
    if (paramInt == 8) {}
    for (;;)
    {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004603", "0X8004603", 0, 0, i + "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("QQRecorder", 2, "report cancle send ptt, cancel source = " + paramInt);
      }
      return;
      if (paramInt == 1) {
        i = 1;
      } else if (paramInt == 2) {
        i = 2;
      } else {
        i = 3;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0)
    {
      paramInt1 = 1;
      if (paramInt2 != 8) {
        break label147;
      }
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8006189", "0X8006189", 0, 0, "", paramInt1 + "", paramInt3 + "", "");
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQRecorder", 2, "report send ptt, send source = " + paramInt2 + ", sessionType = " + paramInt1 + ", seconds = " + paramInt3);
      }
      return;
      if (paramInt1 == 3000)
      {
        paramInt1 = 2;
        break;
      }
      if (paramInt1 == 1)
      {
        paramInt1 = 3;
        break;
      }
      paramInt1 = 4;
      break;
      label147:
      if ((paramInt2 == 1) || (paramInt2 == 2))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        if (paramInt2 == 1) {}
        for (int i = 1;; i = 2)
        {
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004600", "0X8004600", 0, 0, i + "", paramInt1 + "", paramInt3 + "", "");
          break;
        }
      }
      if (paramInt2 == 4) {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005C1E", "0X8005C1E", 0, 0, "", paramInt1 + "", paramInt3 + "", "");
      } else {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004601", "0X8004601", 0, 0, "", paramInt1 + "", paramInt3 + "", "");
      }
    }
  }
  
  private static final boolean a(ByteArrayInputStream paramByteArrayInputStream, int[] paramArrayOfInt)
  {
    paramByteArrayInputStream.read("#!AMR\n".getBytes());
    int j = paramByteArrayInputStream.read();
    int i = 0;
    if ((i >= paramArrayOfInt.length) || (j == paramArrayOfInt[i])) {
      if (i != paramArrayOfInt.length) {
        break label45;
      }
    }
    label45:
    do
    {
      return false;
      i += 1;
      break;
      i = a.get(j, -1);
    } while (i == -1);
    paramArrayOfInt = new byte[i - 1];
    paramByteArrayInputStream.read(paramArrayOfInt);
    for (;;)
    {
      i = paramByteArrayInputStream.read();
      if (i == -1) {
        break label95;
      }
      if (i != j) {
        break;
      }
      paramByteArrayInputStream.read(paramArrayOfInt);
    }
    label95:
    return true;
  }
  
  /* Error */
  public static final boolean a(String paramString, int[] paramArrayOfInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: new 270	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 273	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore_0
    //   11: iload_3
    //   12: istore_2
    //   13: aload_0
    //   14: invokevirtual 276	java/io/File:exists	()Z
    //   17: ifeq +14 -> 31
    //   20: aload_0
    //   21: invokevirtual 280	java/io/File:length	()J
    //   24: lconst_0
    //   25: lcmp
    //   26: ifne +7 -> 33
    //   29: iload_3
    //   30: istore_2
    //   31: iload_2
    //   32: ireturn
    //   33: new 252	java/io/ByteArrayInputStream
    //   36: dup
    //   37: aload_0
    //   38: invokestatic 285	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;)[B
    //   41: invokespecial 288	java/io/ByteArrayInputStream:<init>	([B)V
    //   44: astore 4
    //   46: aload 4
    //   48: astore_0
    //   49: aload 4
    //   51: aload_1
    //   52: invokestatic 290	com/tencent/mobileqq/utils/PttUtils:a	(Ljava/io/ByteArrayInputStream;[I)Z
    //   55: istore_2
    //   56: iload_2
    //   57: istore_3
    //   58: iload_3
    //   59: istore_2
    //   60: aload 4
    //   62: ifnull -31 -> 31
    //   65: aload 4
    //   67: invokevirtual 293	java/io/ByteArrayInputStream:close	()V
    //   70: iload_3
    //   71: ireturn
    //   72: astore_0
    //   73: iload_3
    //   74: ireturn
    //   75: astore 5
    //   77: aconst_null
    //   78: astore_1
    //   79: aload_1
    //   80: astore_0
    //   81: invokestatic 192	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   84: ifeq +16 -> 100
    //   87: aload_1
    //   88: astore_0
    //   89: ldc 194
    //   91: iconst_2
    //   92: ldc_w 295
    //   95: aload 5
    //   97: invokestatic 298	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   100: iload_3
    //   101: istore_2
    //   102: aload_1
    //   103: ifnull -72 -> 31
    //   106: aload_1
    //   107: invokevirtual 293	java/io/ByteArrayInputStream:close	()V
    //   110: iconst_0
    //   111: ireturn
    //   112: astore_0
    //   113: iconst_0
    //   114: ireturn
    //   115: astore_1
    //   116: aconst_null
    //   117: astore_0
    //   118: aload_0
    //   119: ifnull +7 -> 126
    //   122: aload_0
    //   123: invokevirtual 293	java/io/ByteArrayInputStream:close	()V
    //   126: aload_1
    //   127: athrow
    //   128: astore_0
    //   129: goto -3 -> 126
    //   132: astore_1
    //   133: goto -15 -> 118
    //   136: astore 5
    //   138: aload 4
    //   140: astore_1
    //   141: goto -62 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	paramString	String
    //   0	144	1	paramArrayOfInt	int[]
    //   12	90	2	bool1	boolean
    //   1	100	3	bool2	boolean
    //   44	95	4	localByteArrayInputStream	ByteArrayInputStream
    //   75	21	5	localThrowable1	java.lang.Throwable
    //   136	1	5	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   65	70	72	java/lang/Exception
    //   33	46	75	java/lang/Throwable
    //   106	110	112	java/lang/Exception
    //   33	46	115	finally
    //   122	126	128	java/lang/Exception
    //   49	56	132	finally
    //   81	87	132	finally
    //   89	100	132	finally
    //   49	56	136	java/lang/Throwable
  }
  
  public static int[] a(ptt_waveform.PttWaveform paramPttWaveform)
  {
    int j;
    int[] arrayOfInt;
    if ((paramPttWaveform != null) && (paramPttWaveform.uin32_size.has()) && (paramPttWaveform.uin32_size.get() > 0) && (paramPttWaveform.bytes_amplitudes.has()))
    {
      j = paramPttWaveform.uin32_size.get();
      arrayOfInt = new int[j];
      paramPttWaveform = paramPttWaveform.bytes_amplitudes.get().toByteArray();
      if (paramPttWaveform.length != j) {
        QLog.e("PttUtils", 2, "changePtToWaveform, data error");
      }
    }
    else
    {
      return null;
    }
    int i = 0;
    while (i < j)
    {
      paramPttWaveform[i] &= 0xFF;
      i += 1;
    }
    return arrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.PttUtils
 * JD-Core Version:    0.7.0.1
 */