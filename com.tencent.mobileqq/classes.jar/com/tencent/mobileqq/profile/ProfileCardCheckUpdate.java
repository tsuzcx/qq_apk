package com.tencent.mobileqq.profile;

import KQQ.ReqItem;
import KQQ.RespItem;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.entity.ProfileLabelInfo;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.mobileqq.util.EndianUtil;
import com.tencent.mobileqq.util.ProfileCardTemplateUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.pb.profilecard.SummaryCardUpdate.SUpdateReq;
import com.tencent.pb.profilecard.SummaryCardUpdate.SUpdateReqBatch;
import com.tencent.pb.profilecard.SummaryCardUpdate.SUpdateRsp;
import com.tencent.pb.profilecard.SummaryCardUpdate.SUpdateRspBatch;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

public class ProfileCardCheckUpdate
  implements CheckUpdateItemInterface
{
  QQAppInterface a;
  int b = 0;
  
  public ProfileCardCheckUpdate(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private SummaryCardUpdate.SUpdateReq a(int paramInt, String paramString)
  {
    SummaryCardUpdate.SUpdateReq localSUpdateReq = new SummaryCardUpdate.SUpdateReq();
    localSUpdateReq.cmd.set(paramInt);
    localSUpdateReq.uin.set(this.a.getLongAccountUin());
    localSUpdateReq.version.set(paramString);
    localSUpdateReq.client_version.set("8.8.17");
    localSUpdateReq.platform.set(109);
    if (paramInt == 5) {
      localSUpdateReq.appname.set("fun_call");
    }
    return localSUpdateReq;
  }
  
  /* Error */
  private void a(File paramFile)
  {
    // Byte code:
    //   0: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +37 -> 40
    //   6: new 89	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   13: astore_3
    //   14: aload_3
    //   15: ldc 92
    //   17: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload_3
    //   22: aload_1
    //   23: invokevirtual 101	java/io/File:exists	()Z
    //   26: invokevirtual 104	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: ldc 106
    //   32: iconst_2
    //   33: aload_3
    //   34: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   40: aload_1
    //   41: invokevirtual 101	java/io/File:exists	()Z
    //   44: ifeq +211 -> 255
    //   47: aconst_null
    //   48: astore 5
    //   50: aconst_null
    //   51: astore_3
    //   52: new 116	java/io/FileInputStream
    //   55: dup
    //   56: aload_1
    //   57: invokespecial 118	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   60: astore 4
    //   62: new 120	java/io/ByteArrayOutputStream
    //   65: dup
    //   66: invokespecial 121	java/io/ByteArrayOutputStream:<init>	()V
    //   69: astore_3
    //   70: sipush 4096
    //   73: newarray byte
    //   75: astore 5
    //   77: aload 4
    //   79: aload 5
    //   81: iconst_0
    //   82: sipush 4096
    //   85: invokevirtual 127	java/io/InputStream:read	([BII)I
    //   88: istore_2
    //   89: iload_2
    //   90: iconst_m1
    //   91: if_icmpeq +14 -> 105
    //   94: aload_3
    //   95: aload 5
    //   97: iconst_0
    //   98: iload_2
    //   99: invokevirtual 131	java/io/ByteArrayOutputStream:write	([BII)V
    //   102: goto -25 -> 77
    //   105: aload 4
    //   107: invokevirtual 134	java/io/InputStream:close	()V
    //   110: aload_1
    //   111: new 98	java/io/File
    //   114: dup
    //   115: aload_0
    //   116: getfield 19	com/tencent/mobileqq/profile/ProfileCardCheckUpdate:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   119: invokevirtual 138	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   122: invokestatic 143	com/tencent/mobileqq/util/ProfileCardTemplateUtil:a	(Landroid/content/Context;)Ljava/lang/String;
    //   125: invokespecial 145	java/io/File:<init>	(Ljava/lang/String;)V
    //   128: invokevirtual 149	java/io/File:renameTo	(Ljava/io/File;)Z
    //   131: pop
    //   132: goto +8 -> 140
    //   135: astore_1
    //   136: aload_1
    //   137: invokevirtual 152	java/lang/Exception:printStackTrace	()V
    //   140: new 154	java/lang/String
    //   143: dup
    //   144: aload_3
    //   145: invokevirtual 158	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   148: ldc 160
    //   150: invokespecial 163	java/lang/String:<init>	([BLjava/lang/String;)V
    //   153: astore_1
    //   154: aload_1
    //   155: invokevirtual 167	java/lang/String:length	()I
    //   158: ifle +8 -> 166
    //   161: aload_0
    //   162: aload_1
    //   163: invokespecial 169	com/tencent/mobileqq/profile/ProfileCardCheckUpdate:a	(Ljava/lang/String;)V
    //   166: aload 4
    //   168: invokevirtual 134	java/io/InputStream:close	()V
    //   171: return
    //   172: astore_1
    //   173: goto +57 -> 230
    //   176: astore_3
    //   177: aload 4
    //   179: astore_1
    //   180: aload_3
    //   181: astore 4
    //   183: goto +15 -> 198
    //   186: astore_1
    //   187: aload_3
    //   188: astore 4
    //   190: goto +40 -> 230
    //   193: astore 4
    //   195: aload 5
    //   197: astore_1
    //   198: aload_1
    //   199: astore_3
    //   200: ldc 106
    //   202: iconst_1
    //   203: ldc 171
    //   205: aload 4
    //   207: invokestatic 175	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   210: aload_1
    //   211: ifnull +44 -> 255
    //   214: aload_1
    //   215: invokevirtual 134	java/io/InputStream:close	()V
    //   218: return
    //   219: astore_1
    //   220: ldc 106
    //   222: iconst_1
    //   223: ldc 171
    //   225: aload_1
    //   226: invokestatic 175	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   229: return
    //   230: aload 4
    //   232: ifnull +21 -> 253
    //   235: aload 4
    //   237: invokevirtual 134	java/io/InputStream:close	()V
    //   240: goto +13 -> 253
    //   243: astore_3
    //   244: ldc 106
    //   246: iconst_1
    //   247: ldc 171
    //   249: aload_3
    //   250: invokestatic 175	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   253: aload_1
    //   254: athrow
    //   255: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	256	0	this	ProfileCardCheckUpdate
    //   0	256	1	paramFile	File
    //   88	11	2	i	int
    //   13	132	3	localObject1	Object
    //   176	12	3	localException1	Exception
    //   199	1	3	localFile	File
    //   243	7	3	localException2	Exception
    //   60	129	4	localObject2	Object
    //   193	43	4	localException3	Exception
    //   48	148	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   110	132	135	java/lang/Exception
    //   62	77	172	finally
    //   77	89	172	finally
    //   94	102	172	finally
    //   105	110	172	finally
    //   110	132	172	finally
    //   136	140	172	finally
    //   140	166	172	finally
    //   62	77	176	java/lang/Exception
    //   77	89	176	java/lang/Exception
    //   94	102	176	java/lang/Exception
    //   105	110	176	java/lang/Exception
    //   136	140	176	java/lang/Exception
    //   140	166	176	java/lang/Exception
    //   52	62	186	finally
    //   200	210	186	finally
    //   52	62	193	java/lang/Exception
    //   166	171	219	java/lang/Exception
    //   214	218	219	java/lang/Exception
    //   235	240	243	java/lang/Exception
  }
  
  private void a(String paramString)
  {
    paramString = b(paramString);
    if (paramString != null)
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
      localObjectOutputStream.writeObject(paramString);
      localObjectOutputStream.flush();
      localObjectOutputStream.close();
      localByteArrayOutputStream.close();
      FileUtils.pushData2File(new File(BaseApplicationImpl.getApplication().getFilesDir(), "labelList").getAbsolutePath(), localByteArrayOutputStream.toByteArray(), false);
    }
  }
  
  private List<ProfileLabelTypeInfo> b(String paramString)
  {
    if (paramString != null)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("ProfileCardCheckUpdate downloadLabelConfigJson labelConfigJsonData length is :");
        ((StringBuilder)localObject1).append(paramString.length());
        QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject1 = new ArrayList();
      paramString = new JSONArray(paramString);
      int k = paramString.length();
      int i = 0;
      while (i < k)
      {
        Object localObject2 = paramString.optJSONObject(i);
        ProfileLabelTypeInfo localProfileLabelTypeInfo = new ProfileLabelTypeInfo();
        localProfileLabelTypeInfo.typeId = ((JSONObject)localObject2).optString("id");
        localProfileLabelTypeInfo.typeName = ((JSONObject)localObject2).optString("name");
        localProfileLabelTypeInfo.typeInfo = ((JSONObject)localObject2).optString("classinfo");
        localObject2 = ((JSONObject)localObject2).optJSONArray("taglist");
        int m = ((JSONArray)localObject2).length();
        int j = 0;
        while (j < m)
        {
          JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(j);
          ProfileLabelInfo localProfileLabelInfo = new ProfileLabelInfo();
          localProfileLabelInfo.labelId = Long.valueOf(localJSONObject.optLong("id"));
          localProfileLabelInfo.labelName = localJSONObject.optString("name");
          localProfileLabelInfo.typeId = localProfileLabelTypeInfo.typeId;
          localProfileLabelTypeInfo.labels.add(localProfileLabelInfo);
          j += 1;
        }
        ((List)localObject1).add(localProfileLabelTypeInfo);
        i += 1;
      }
      paramString = (String)localObject1;
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("downloadLabelConfigJson the new typeList size =");
        paramString.append(((List)localObject1).size());
        QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, paramString.toString());
        return localObject1;
      }
    }
    else
    {
      paramString = null;
    }
    return paramString;
  }
  
  private boolean c()
  {
    return false;
  }
  
  private boolean d()
  {
    boolean bool2 = false;
    for (;;)
    {
      try
      {
        long l1 = BaseApplicationImpl.getApplication().getSharedPreferences("com.tencent.mobileqq_preferences", 4).getLong("specialcareCheckUpdateTime", 0L);
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel())
        {
          String str1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(l1));
          String str2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(l2));
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("isSendSpecialCareUpdate nextCheckUpdateTime=");
          localStringBuilder.append(str1);
          localStringBuilder.append(",systemTimestamp=");
          localStringBuilder.append(str2);
          localStringBuilder.append(",isSend=");
          if (l2 > l1)
          {
            bool1 = true;
            localStringBuilder.append(bool1);
            QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, localStringBuilder.toString());
          }
        }
        else
        {
          if (l2 <= l1)
          {
            boolean bool3 = new File(BaseApplicationImpl.getApplication().getApplicationContext().getFilesDir(), "pddata/vas/special_remind/new_config.json").exists();
            bool1 = bool2;
            if (bool3) {}
          }
          else
          {
            bool1 = true;
          }
          return bool1;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return false;
      }
      boolean bool1 = false;
    }
  }
  
  private boolean e()
  {
    boolean bool2 = false;
    for (;;)
    {
      try
      {
        long l1 = this.a.getPreferences().getLong("nextCheckUpdateTimeMillis", 0L);
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel())
        {
          String str1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(l1));
          String str2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(l2));
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("isSendTemplateCheckUpdate nextCheckUpdateTime=");
          localStringBuilder.append(str1);
          localStringBuilder.append(",systemTimestamp=");
          localStringBuilder.append(str2);
          localStringBuilder.append(",isSend=");
          if (l2 > l1)
          {
            bool1 = true;
            localStringBuilder.append(bool1);
            QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, localStringBuilder.toString());
          }
        }
        else
        {
          bool1 = bool2;
          if (l2 > l1) {
            bool1 = true;
          }
          return bool1;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return false;
      }
      boolean bool1 = false;
    }
  }
  
  private boolean f()
  {
    boolean bool2 = false;
    for (;;)
    {
      try
      {
        long l1 = this.a.getPreferences().getLong("nextCheckLabelUpdateTimeMillis", 0L);
        long l2 = System.currentTimeMillis();
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(l1));
          String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(l2));
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("isSendCheckLabelUpdate nextCheckUpdateTime=");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append(",systemTimestamp=");
          localStringBuilder.append(str);
          localStringBuilder.append(",isSend=");
          if (l2 > l1)
          {
            bool1 = true;
            localStringBuilder.append(bool1);
            QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, localStringBuilder.toString());
          }
        }
        else
        {
          localObject = new File(ProfileCardTemplateUtil.a(this.a.getApplication()));
          if (l2 <= l1)
          {
            boolean bool3 = ((File)localObject).exists();
            bool1 = bool2;
            if (bool3) {}
          }
          else
          {
            bool1 = true;
          }
          return bool1;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return false;
      }
      boolean bool1 = false;
    }
  }
  
  private boolean g()
  {
    return false;
  }
  
  public int a()
  {
    return 3;
  }
  
  public ReqItem a(int paramInt)
  {
    if (!b()) {
      return null;
    }
    Object localObject1 = this.a.getPreferences();
    long l = System.currentTimeMillis();
    ((SharedPreferences)localObject1).edit().putLong("nextCheckUpdateTimeMillis", l + 3600000L).commit();
    String str1 = ((SharedPreferences)localObject1).getString("cardTemplateVersion", "0");
    String str2 = ((SharedPreferences)localObject1).getString("profileLabelVersion", "0");
    Object localObject3 = ((SharedPreferences)localObject1).getString("profileFuncallVersion", "0");
    String str3 = ((SharedPreferences)localObject1).getString("WebviewCGIWhitelistVersion", "0");
    localObject1 = new ReqItem();
    ((ReqItem)localObject1).eServiceID = 122;
    Object localObject2 = new SummaryCardUpdate.SUpdateReqBatch();
    SummaryCardUpdate.SUpdateReq localSUpdateReq;
    if ((this.b & 0x1) != 0)
    {
      localSUpdateReq = a(3, str1);
      ((SummaryCardUpdate.SUpdateReqBatch)localObject2).reqs.add(localSUpdateReq);
    }
    if ((this.b & 0x2) != 0)
    {
      localSUpdateReq = a(4, str2);
      ((SummaryCardUpdate.SUpdateReqBatch)localObject2).reqs.add(localSUpdateReq);
    }
    if ((this.b & 0x4) != 0)
    {
      localSUpdateReq = a(5, (String)localObject3);
      ((SummaryCardUpdate.SUpdateReqBatch)localObject2).reqs.add(localSUpdateReq);
    }
    if ((this.b & 0x8) != 0)
    {
      localObject3 = a(5, (String)localObject3);
      ((SummaryCardUpdate.SUpdateReq)localObject3).appname.set("special_remind");
      ((SummaryCardUpdate.SUpdateReqBatch)localObject2).reqs.add((MessageMicro)localObject3);
    }
    if ((this.b & 0x10) != 0)
    {
      localObject3 = a(6, str3);
      ((SummaryCardUpdate.SUpdateReq)localObject3).appname.set("white_list");
      ((SummaryCardUpdate.SUpdateReqBatch)localObject2).reqs.add((MessageMicro)localObject3);
    }
    localObject2 = ((SummaryCardUpdate.SUpdateReqBatch)localObject2).toByteArray();
    paramInt = localObject2.length;
    int i = paramInt + 4;
    localObject3 = new byte[i];
    System.arraycopy(EndianUtil.b(i), 0, localObject3, 0, 4);
    System.arraycopy(localObject2, 0, localObject3, 4, paramInt);
    ((ReqItem)localObject1).vecParam = ((byte[])localObject3);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getCheckUpdateItemData uin=");
      ((StringBuilder)localObject2).append(this.a.getLongAccountUin());
      ((StringBuilder)localObject2).append(",cardVersion=");
      ((StringBuilder)localObject2).append(str1);
      ((StringBuilder)localObject2).append("labelVersion=");
      ((StringBuilder)localObject2).append(str2);
      ((StringBuilder)localObject2).append(",client_version=");
      ((StringBuilder)localObject2).append("8.8.17");
      ((StringBuilder)localObject2).append(",dataLen=");
      ((StringBuilder)localObject2).append(i);
      QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, ((StringBuilder)localObject2).toString());
    }
    return localObject1;
  }
  
  public void a(RespItem paramRespItem)
  {
    if (paramRespItem != null)
    {
      int i = paramRespItem.cResult;
      paramRespItem = paramRespItem.vecUpdate;
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleCheckUpdateItemData result=");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(",dataLen=");
        ((StringBuilder)localObject).append(paramRespItem.length);
        QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, ((StringBuilder)localObject).toString());
      }
      if (i == 2) {
        try
        {
          if (paramRespItem.length <= 4) {
            break label329;
          }
          i = (int)PkgTools.getLongData(paramRespItem, 0) - 4;
          localObject = new byte[i];
          PkgTools.copyData((byte[])localObject, 0, paramRespItem, 4, i);
          paramRespItem = new SummaryCardUpdate.SUpdateRspBatch();
          paramRespItem.mergeFrom((byte[])localObject);
          if (paramRespItem.rsps.size() < 0)
          {
            if (!QLog.isColorLevel()) {
              return;
            }
            QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate SUpdateRspBatch have no rsp");
            return;
          }
          paramRespItem = paramRespItem.rsps.get().iterator();
          while (paramRespItem.hasNext())
          {
            localObject = (SummaryCardUpdate.SUpdateRsp)paramRespItem.next();
            if (localObject != null)
            {
              i = ((SummaryCardUpdate.SUpdateRsp)localObject).cmd.get();
              if (i == 3) {
                e((SummaryCardUpdate.SUpdateRsp)localObject);
              } else if (i == 4) {
                d((SummaryCardUpdate.SUpdateRsp)localObject);
              } else if (i == 5)
              {
                if ((((SummaryCardUpdate.SUpdateRsp)localObject).appname != null) && (((SummaryCardUpdate.SUpdateRsp)localObject).appname.get().equals("special_remind"))) {
                  b((SummaryCardUpdate.SUpdateRsp)localObject);
                } else {
                  a((SummaryCardUpdate.SUpdateRsp)localObject);
                }
              }
              else if (i == 6) {
                c((SummaryCardUpdate.SUpdateRsp)localObject);
              }
            }
          }
          if (!QLog.isColorLevel()) {
            break label329;
          }
        }
        catch (Exception paramRespItem)
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("ProfileCardCheckUpdate Exception msg=");
            ((StringBuilder)localObject).append(paramRespItem.getMessage());
            QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, ((StringBuilder)localObject).toString());
          }
          paramRespItem.printStackTrace();
          return;
        }
      }
    }
    else
    {
      QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate handleCheckUpdateItemData respitem is null");
    }
    label329:
    return;
  }
  
  public void a(SummaryCardUpdate.SUpdateRsp paramSUpdateRsp)
  {
    int i = paramSUpdateRsp.code.get();
    String str1 = paramSUpdateRsp.version.get();
    String str2 = paramSUpdateRsp.url.get();
    int j = paramSUpdateRsp.interv.get();
    paramSUpdateRsp.buff.get();
    if (QLog.isColorLevel())
    {
      paramSUpdateRsp = new StringBuilder();
      paramSUpdateRsp.append("ProfileCardCheckUpdate handleFunCallRsp data code=");
      paramSUpdateRsp.append(i);
      paramSUpdateRsp.append(",version=");
      paramSUpdateRsp.append(str1);
      paramSUpdateRsp.append(",url=");
      paramSUpdateRsp.append(str2);
      paramSUpdateRsp.append(",interval=");
      paramSUpdateRsp.append(j);
      QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, paramSUpdateRsp.toString());
    }
    if (i == 0)
    {
      if (QLog.isColorLevel())
      {
        paramSUpdateRsp = new StringBuilder();
        paramSUpdateRsp.append("ProfileCardCheckUpdate code == 0");
        paramSUpdateRsp.append(j);
        QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, paramSUpdateRsp.toString());
      }
    }
    else {
      ReportCenter.a().a("SummaryCardUpdate.EM_RT_FUN_CALL", 100, i, this.a.getCurrentAccountUin(), 1000277, HardCodeUtil.a(2131906228), true);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    ThreadManagerV2.excute(new ProfileCardCheckUpdate.2(this, paramString1, paramString2), 128, null, false);
  }
  
  public void b(SummaryCardUpdate.SUpdateRsp paramSUpdateRsp)
  {
    int i = paramSUpdateRsp.code.get();
    String str2 = paramSUpdateRsp.version.get();
    String str1 = paramSUpdateRsp.url.get();
    int j = paramSUpdateRsp.interv.get();
    if (QLog.isColorLevel())
    {
      paramSUpdateRsp = new StringBuilder();
      paramSUpdateRsp.append("ProfileCardCheckUpdate handleSpecialCareRsp data code=");
      paramSUpdateRsp.append(i);
      paramSUpdateRsp.append(",version=");
      paramSUpdateRsp.append(str2);
      paramSUpdateRsp.append(",url=");
      paramSUpdateRsp.append(str1);
      paramSUpdateRsp.append(",interval=");
      paramSUpdateRsp.append(j);
      QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, paramSUpdateRsp.toString());
    }
    if (i == 0)
    {
      paramSUpdateRsp = BaseApplicationImpl.getApplication().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
      str2 = paramSUpdateRsp.getString("specialcare_config", "");
      if (j >= 0)
      {
        long l1 = System.currentTimeMillis();
        long l2 = j * 1000;
        paramSUpdateRsp.edit().putLong("specialcareCheckUpdateTime", l1 + l2).commit();
      }
      if ((str1 != null) && (!str1.equals(str2)))
      {
        paramSUpdateRsp.edit().putString("specialcare_config", str1).commit();
        paramSUpdateRsp.edit().putBoolean("special_care_red_point_one", true).commit();
        paramSUpdateRsp.edit().putBoolean("special_care_red_point_two", true).commit();
        ThreadManager.post(new ProfileCardCheckUpdate.1(this), 5, null, true);
      }
    }
    else
    {
      ReportCenter.a().a("SummaryCardUpdate.EM_RT_SPECIAL_REMIND", 100, i, this.a.getCurrentAccountUin(), 1000277, HardCodeUtil.a(2131906263), true);
    }
  }
  
  public boolean b()
  {
    int k = e();
    boolean bool3 = f();
    boolean bool4 = c();
    boolean bool5 = d();
    boolean bool2 = g();
    this.b |= k;
    int j = this.b;
    boolean bool1 = false;
    int i;
    if (bool3) {
      i = 2;
    } else {
      i = 0;
    }
    this.b = (j | i);
    j = this.b;
    if (bool4) {
      i = 4;
    } else {
      i = 0;
    }
    this.b = (j | i);
    j = this.b;
    if (bool5) {
      i = 8;
    } else {
      i = 0;
    }
    this.b = (j | i);
    j = this.b;
    if (bool2) {
      i = 16;
    } else {
      i = 0;
    }
    this.b = (j | i);
    if ((k != 0) || (bool3) || (bool4) || (bool5) || (bool2)) {
      bool1 = true;
    }
    return bool1;
  }
  
  public void c(SummaryCardUpdate.SUpdateRsp paramSUpdateRsp) {}
  
  public void d(SummaryCardUpdate.SUpdateRsp paramSUpdateRsp)
  {
    int i = paramSUpdateRsp.code.get();
    String str1 = paramSUpdateRsp.version.get();
    String str2 = paramSUpdateRsp.url.get();
    int j = paramSUpdateRsp.interv.get();
    if (QLog.isColorLevel())
    {
      paramSUpdateRsp = new StringBuilder();
      paramSUpdateRsp.append("ProfileCardCheckUpdate handleSummaryLabelRsp data code=");
      paramSUpdateRsp.append(i);
      paramSUpdateRsp.append(",version=");
      paramSUpdateRsp.append(str1);
      paramSUpdateRsp.append(",url=");
      paramSUpdateRsp.append(str2);
      paramSUpdateRsp.append(",interval=");
      paramSUpdateRsp.append(j);
      QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, paramSUpdateRsp.toString());
    }
    if (i == 0)
    {
      paramSUpdateRsp = this.a.getPreferences();
      if (j >= 0)
      {
        long l1 = System.currentTimeMillis();
        long l2 = j * 1000;
        paramSUpdateRsp.edit().putLong("nextCheckLabelUpdateTimeMillis", l1 + l2).commit();
      }
      if ((!paramSUpdateRsp.getString("profileLabelVersion", "0").equals(str1)) && (str2 != null)) {
        a(str2, str1);
      }
    }
    else
    {
      ReportCenter.a().a("SummaryCardUpdate.EM_RT_SUMMARY_LABEL", 100, i, this.a.getCurrentAccountUin(), 1000277, HardCodeUtil.a(2131906233), true);
    }
  }
  
  public void e(SummaryCardUpdate.SUpdateRsp paramSUpdateRsp)
  {
    int i = paramSUpdateRsp.code.get();
    String str1 = paramSUpdateRsp.version.get();
    String str2 = paramSUpdateRsp.url.get();
    int j = paramSUpdateRsp.interv.get();
    if (QLog.isColorLevel())
    {
      paramSUpdateRsp = new StringBuilder();
      paramSUpdateRsp.append("ProfileCardCheckUpdate handleSummaryUpdateRsp data code=");
      paramSUpdateRsp.append(i);
      paramSUpdateRsp.append(",version=");
      paramSUpdateRsp.append(str1);
      paramSUpdateRsp.append(",url=");
      paramSUpdateRsp.append(str2);
      paramSUpdateRsp.append(",interval=");
      paramSUpdateRsp.append(j);
      QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, paramSUpdateRsp.toString());
    }
    if (i == 0)
    {
      if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str1)) && (j >= 0))
      {
        paramSUpdateRsp = this.a.getPreferences().edit();
        paramSUpdateRsp.putLong("nextCheckUpdateTimeMillis", System.currentTimeMillis() + j * 1000);
        paramSUpdateRsp.putString("cardTemplateServerUrl", str2);
        paramSUpdateRsp.putString("cardTemplateServerVersion", str1);
        paramSUpdateRsp.commit();
      }
    }
    else {
      ReportCenter.a().a("SummaryCardUpdate.EM_RT_SUMMARY_UPDATE", 100, i, this.a.getCurrentAccountUin(), 1000277, HardCodeUtil.a(2131906253), true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.ProfileCardCheckUpdate
 * JD-Core Version:    0.7.0.1
 */