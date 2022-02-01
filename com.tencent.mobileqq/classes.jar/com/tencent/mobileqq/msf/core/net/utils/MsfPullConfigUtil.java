package com.tencent.mobileqq.msf.core.net.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.InflaterInputStream;
import tencent.im.oidb.cmd0x769.Oidb_0x769.Config;
import tencent.im.oidb.cmd0x769.Oidb_0x769.ConfigSeq;
import tencent.im.oidb.cmd0x769.Oidb_0x769.Content;
import tencent.im.oidb.cmd0x769.Oidb_0x769.ReqBody;
import tencent.im.oidb.cmd0x769.Oidb_0x769.RspBody;

public class MsfPullConfigUtil
{
  public static final String KEY_TEST_CRASH_SWITCH = "key_test_crash_switch";
  public static final String SP_SAFEMODE_TEST_CRASH_CONFIG = "sp_safemode_test_crash_config";
  private static final String TAG = "MsfPullConfigUtil";
  private static final int TYPE_COMMAND = 283;
  private static final int TYPE_PATCH = 46;
  public static volatile boolean sRecvProxy = false;
  public static volatile boolean sRecvRegister = false;
  
  private static void execConfigCmd(int paramInt1, int paramInt2, List paramList)
  {
    if (paramInt1 != 46)
    {
      if (paramInt1 != 283) {
        return;
      }
      MsfCmdConfig.executeSafeModeCmd(paramInt2, (String)paramList.get(0));
      return;
    }
    MsfHandlePatchUtils.handlePatchConfig(paramInt2, paramList);
  }
  
  private static byte[] inflateConfigString(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      paramArrayOfByte = new InflaterInputStream(new ByteArrayInputStream(paramArrayOfByte));
      byte[] arrayOfByte = new byte[256];
      for (;;)
      {
        int i = paramArrayOfByte.read(arrayOfByte);
        if (-1 == i) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsfPullConfigUtil", 2, "inflateConfigString error", paramArrayOfByte);
      }
    }
    return null;
  }
  
  private static List parseConfigContent(Oidb_0x769.Config paramConfig)
  {
    Object localObject1 = paramConfig.rpt_msg_content_list;
    Object localObject2 = null;
    StringBuilder localStringBuilder;
    if ((localObject1 != null) && (paramConfig.rpt_msg_content_list.size() > 0))
    {
      localObject1 = new ArrayList();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("parseConfigContent rpt_msg_content_list size=");
        ((StringBuilder)localObject2).append(paramConfig.rpt_msg_content_list.size());
        QLog.i("MsfPullConfigUtil", 2, ((StringBuilder)localObject2).toString());
      }
      localObject2 = paramConfig.rpt_msg_content_list.get().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        paramConfig = (Oidb_0x769.Content)((Iterator)localObject2).next();
        if ((paramConfig != null) && (paramConfig.content.has()))
        {
          if (paramConfig.compress.get() == 1)
          {
            paramConfig = inflateConfigString(paramConfig.content.get().toByteArray());
            if (paramConfig != null) {
              try
              {
                paramConfig = new String(paramConfig, "UTF-8");
              }
              catch (Exception paramConfig)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("MsfPullConfigUtil", 2, "parseConfigContent rpt_msg_content_list uncompress failed", paramConfig);
                }
              }
            } else {
              paramConfig = null;
            }
          }
          else
          {
            paramConfig = paramConfig.content.get().toStringUtf8();
          }
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("parseConfigContent rpt_msg_content_list content item=");
            localStringBuilder.append(paramConfig);
            QLog.i("MsfPullConfigUtil", 2, localStringBuilder.toString());
          }
          if (!TextUtils.isEmpty(paramConfig)) {
            ((List)localObject1).add(paramConfig);
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.i("MsfPullConfigUtil", 2, "parseConfigContent rpt_msg_content_list content item empty");
        }
      }
      return localObject1;
    }
    if ((paramConfig.rpt_content_list != null) && (paramConfig.rpt_content_list.size() > 0))
    {
      localObject2 = new ArrayList();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("parseConfigContent rpt_content_list size=");
        ((StringBuilder)localObject1).append(paramConfig.rpt_content_list.size());
        QLog.i("MsfPullConfigUtil", 2, ((StringBuilder)localObject1).toString());
      }
      paramConfig = paramConfig.rpt_content_list.get().iterator();
      for (;;)
      {
        localObject1 = localObject2;
        if (!paramConfig.hasNext()) {
          break;
        }
        localObject1 = (String)paramConfig.next();
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          ((List)localObject2).add(localObject1);
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("parseConfigContent rpt_content_list content item=");
            localStringBuilder.append((String)localObject1);
            QLog.i("MsfPullConfigUtil", 2, localStringBuilder.toString());
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.i("MsfPullConfigUtil", 2, "parseConfigContent rpt_content_list content item empty");
        }
      }
    }
    localObject1 = localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("parseConfigContent msg_content_list and rpt_content_list are empty, version=");
      ((StringBuilder)localObject1).append(paramConfig.uint32_version.get());
      QLog.i("MsfPullConfigUtil", 2, ((StringBuilder)localObject1).toString());
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  public static void parseConfigResponse(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject2;
        Object localObject1;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("parseConfigResponse response len=");
          if (paramArrayOfByte == null) {
            localObject1 = "null";
          } else {
            localObject1 = Integer.valueOf(paramArrayOfByte.length);
          }
          ((StringBuilder)localObject2).append(localObject1);
          ((StringBuilder)localObject2).append(", isRegProxy=");
          ((StringBuilder)localObject2).append(paramBoolean);
          QLog.d("MsfPullConfigUtil", 2, ((StringBuilder)localObject2).toString());
        }
        if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
        {
          localObject2 = new Oidb_0x769.RspBody();
          i = 0;
          localObject1 = paramArrayOfByte;
          if (paramBoolean)
          {
            localObject1 = new byte[paramArrayOfByte.length - 4];
            System.arraycopy(paramArrayOfByte, 4, localObject1, 0, localObject1.length);
          }
          ((Oidb_0x769.RspBody)localObject2).mergeFrom((byte[])localObject1);
          int j = ((Oidb_0x769.RspBody)localObject2).uint32_result.get();
          if (j == 0)
          {
            if ((((Oidb_0x769.RspBody)localObject2).rpt_config_list != null) && (((Oidb_0x769.RspBody)localObject2).rpt_config_list.size() > 0))
            {
              j = ((Oidb_0x769.RspBody)localObject2).rpt_config_list.size();
              if (i < j)
              {
                paramArrayOfByte = (Oidb_0x769.Config)((Oidb_0x769.RspBody)localObject2).rpt_config_list.get(i);
                if ((paramArrayOfByte == null) || (!paramArrayOfByte.uint32_type.has())) {
                  break label367;
                }
                localObject1 = parseConfigContent(paramArrayOfByte);
                if ((localObject1 != null) && (((List)localObject1).size() > 0))
                {
                  execConfigCmd(paramArrayOfByte.uint32_type.get(), paramArrayOfByte.uint32_version.get(), (List)localObject1);
                  break label367;
                }
                if (paramArrayOfByte.uint32_type.get() != 46) {
                  break label367;
                }
                execConfigCmd(46, paramArrayOfByte.uint32_version.get(), (List)localObject1);
                break label367;
              }
            }
            else if (QLog.isColorLevel())
            {
              QLog.d("MsfPullConfigUtil", 2, "parseConfigResponse decode Oidb_0x769.RspBody --> rpt_config_list is empty");
            }
          }
          else if (QLog.isColorLevel())
          {
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("parseConfigResponse decode Oidb_0x769.RspBody --> result error=");
            paramArrayOfByte.append(j);
            QLog.d("MsfPullConfigUtil", 2, paramArrayOfByte.toString());
          }
        }
      }
      catch (Throwable paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MsfPullConfigUtil", 2, "parseConfigResponse decode Oidb_0x769.RspBody --> throwable=", paramArrayOfByte);
        }
      }
      if (paramBoolean)
      {
        sRecvProxy = true;
        return;
      }
      sRecvRegister = true;
      return;
      label367:
      i += 1;
    }
  }
  
  public static byte[] pullConfigRequest(boolean paramBoolean)
  {
    Oidb_0x769.ReqBody localReqBody = new Oidb_0x769.ReqBody();
    Object localObject = new Oidb_0x769.ConfigSeq();
    ((Oidb_0x769.ConfigSeq)localObject).type.set(46);
    ((Oidb_0x769.ConfigSeq)localObject).version.set(MsfHandlePatchUtils.getPatchConfigVersion());
    localReqBody.rpt_config_list.add((MessageMicro)localObject);
    localObject = new Oidb_0x769.ConfigSeq();
    ((Oidb_0x769.ConfigSeq)localObject).type.set(283);
    ((Oidb_0x769.ConfigSeq)localObject).version.set(0);
    localReqBody.rpt_config_list.add((MessageMicro)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("pullConfigRequest isRegProxy=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("MsfPullConfigUtil", 2, ((StringBuilder)localObject).toString());
    }
    return localReqBody.toByteArray();
  }
  
  public static void showToastForSafeModeTest(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.utils.MsfPullConfigUtil
 * JD-Core Version:    0.7.0.1
 */