package com.tencent.mobileqq.shortvideo.dancegame;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.richmedia.capture.activity.CameraCaptureActivity;
import com.tencent.mobileqq.richmedia.capture.activity.CaptureSoDownloadActivity;
import com.tencent.mobileqq.richmedia.capture.fragment.AIOEffectsCameraCaptureFragment;
import com.tencent.mobileqq.richmedia.capture.fragment.AIOEffectsCameraCaptureFragment.Session;
import com.tencent.mobileqq.shortvideo.ShortVideoErrorReport;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.redbag.ShortVideoServlet;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.video.decode.ShortVideoSoLoad;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.Packet;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class DanceGameVideoManager
{
  private static DanceGameVideoManager jdField_a_of_type_ComTencentMobileqqShortvideoDancegameDanceGameVideoManager;
  private int jdField_a_of_type_Int = -1;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  
  public static DanceGameVideoManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqShortvideoDancegameDanceGameVideoManager == null) {
      jdField_a_of_type_ComTencentMobileqqShortvideoDancegameDanceGameVideoManager = new DanceGameVideoManager();
    }
    return jdField_a_of_type_ComTencentMobileqqShortvideoDancegameDanceGameVideoManager;
  }
  
  public static boolean a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool;
    if (paramBoolean) {
      if (paramInt2 == 5)
      {
        paramBoolean = true;
        if (paramInt2 != 6) {
          break label55;
        }
        bool = true;
        label19:
        switch (paramInt1)
        {
        }
      }
    }
    label55:
    label67:
    label82:
    do
    {
      return false;
      paramBoolean = false;
      break;
      bool = false;
      break label19;
      if (paramInt2 == 3)
      {
        paramBoolean = true;
        if (paramInt2 != 4) {
          break label82;
        }
      }
      for (bool = true;; bool = false)
      {
        break;
        paramBoolean = false;
        break label67;
      }
      return paramBoolean;
      return bool;
    } while ((!paramBoolean) && (!bool));
    return true;
  }
  
  public static boolean a(AppInterface paramAppInterface)
  {
    if (VideoEnvironment.a() == null) {}
    do
    {
      do
      {
        return false;
        if (ShortVideoUtils.a()) {
          break;
        }
        ShortVideoUtils.a(paramAppInterface);
      } while (!ShortVideoUtils.a());
    } while ((PtvFilterSoLoad.a(BaseApplicationImpl.getContext()) == 2) || (PtvFilterSoLoad.a() == 2));
    return true;
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 3000);
  }
  
  public static boolean b(AppInterface paramAppInterface)
  {
    paramAppInterface = VideoEnvironment.a();
    if (TextUtils.isEmpty(paramAppInterface)) {}
    do
    {
      String str;
      do
      {
        return false;
        if (ShortVideoUtils.a()) {
          break;
        }
        str = ShortVideoSoLoad.getShortVideoSoPath(VideoEnvironment.a());
      } while (!FileUtils.a(str + paramAppInterface));
    } while ((PtvFilterSoLoad.a(BaseApplicationImpl.getContext()) == 2) || (PtvFilterSoLoad.a() == 2));
    return true;
  }
  
  public void a(int paramInt, String paramString)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.sApplication.getRuntime().getApplication().getSharedPreferences("danceConfig", 4).edit();
    localEditor.putInt(paramString + "_max_score", paramInt);
    localEditor.commit();
    this.jdField_a_of_type_Int = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("DanceGameVideoManager", 2, "updateDanceMaxScore maxScore:" + this.jdField_a_of_type_Int + " ,new:" + paramInt);
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(Activity paramActivity, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (paramQQAppInterface.c())
    {
      QQToast.a(BaseApplicationImpl.getContext(), 2131428986, 1).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131558448));
      return;
    }
    AIOEffectsCameraCaptureFragment.Session localSession = null;
    if (paramSessionInfo != null) {
      localSession = new AIOEffectsCameraCaptureFragment.Session(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.d, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.b);
    }
    if (a(paramQQAppInterface))
    {
      CameraCaptureActivity.a(paramActivity, AIOEffectsCameraCaptureFragment.class.getName(), AIOEffectsCameraCaptureFragment.a(localSession, 10000, getClass().getName(), 0L, false, true, 10, ""));
      ShortVideoErrorReport.a(0);
      return;
    }
    ShortVideoErrorReport.a(1);
    paramQQAppInterface = CameraCaptureActivity.a(paramActivity, AIOEffectsCameraCaptureFragment.class.getName(), AIOEffectsCameraCaptureFragment.a(localSession, 10000, getClass().getName(), 0L, false, true, 10, ""));
    CaptureSoDownloadActivity.a(paramActivity, AIOEffectsCameraCaptureFragment.class.getName(), paramQQAppInterface.getExtras(), true);
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    try
    {
      if ((!paramFromServiceMsg.isSuccess()) || (paramArrayOfByte == null)) {
        break label297;
      }
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom(paramArrayOfByte);
      if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.uint32_result.has())) {
        break label252;
      }
      j = paramFromServiceMsg.uint32_result.get();
      if (j != 0) {
        break label197;
      }
      paramArrayOfByte = ByteBuffer.wrap(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
      paramFromServiceMsg = new oidb_0x5eb.RspBody();
      paramFromServiceMsg.mergeFrom(paramArrayOfByte.array());
      k = paramFromServiceMsg.rpt_msg_uin_data.size();
      i = 0;
    }
    catch (Exception paramFromServiceMsg)
    {
      for (;;)
      {
        int j;
        int k;
        int i;
        String str;
        int m;
        label197:
        label252:
        this.jdField_a_of_type_JavaLangString = paramFromServiceMsg.getMessage();
        QLog.e("DanceGameVideoManager", 1, "handleGetDanceMaxScore exception: ", paramFromServiceMsg);
        continue;
        paramFromServiceMsg = "no pkg result";
        continue;
        label297:
        this.jdField_a_of_type_JavaLangString = ("msg fail " + paramFromServiceMsg.getBusinessFailCode());
        continue;
        i += 1;
      }
    }
    if (i < k)
    {
      paramArrayOfByte = (oidb_0x5eb.UdcUinData)paramFromServiceMsg.rpt_msg_uin_data.get(i);
      str = String.valueOf(paramArrayOfByte.uint64_uin.get());
      if (paramArrayOfByte.uint32_dance_max_score.has())
      {
        m = paramArrayOfByte.uint32_dance_max_score.get();
        a(m, str);
        if (QLog.isColorLevel()) {
          QLog.d("DanceGameVideoManager", 2, new Object[] { "handleGetDanceMaxScore uin:", str, " maxScore:", Integer.valueOf(m) });
        }
      }
    }
    else
    {
      for (this.jdField_a_of_type_JavaLangString = ("error ret " + j);; this.jdField_a_of_type_JavaLangString = paramFromServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DanceGameVideoManager", 2, new Object[] { "handleGetDanceMaxScore result: ", this.jdField_a_of_type_JavaLangString });
        }
        return;
        if (paramFromServiceMsg != null) {
          break;
        }
        paramFromServiceMsg = "no pkg";
      }
    }
  }
  
  public void a(Packet paramPacket, String paramString)
  {
    Object localObject = new oidb_0x5eb.ReqBody();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(Long.parseLong(paramString)));
    ((oidb_0x5eb.ReqBody)localObject).rpt_uint64_uins.set(localArrayList);
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_dance_max_score.set(1);
    paramString = new oidb_sso.OIDBSSOPkg();
    paramString.uint32_command.set(1515);
    paramString.uint32_service_type.set(203);
    paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5eb.ReqBody)localObject).toByteArray()));
    paramString = paramString.toByteArray();
    localObject = ByteBuffer.allocate(paramString.length + 4);
    ((ByteBuffer)localObject).putInt(paramString.length + 4);
    ((ByteBuffer)localObject).put(paramString);
    paramPacket.putSendData(((ByteBuffer)localObject).array());
    paramPacket.setSSOCommand("OidbSvc.0x5eb_203");
  }
  
  public void a(Packet paramPacket, String paramString, int paramInt)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(13);
    long l = Long.parseLong(paramString);
    this.jdField_b_of_type_Int = paramInt;
    localByteBuffer.putInt(Utils.a(l)).put((byte)0).putShort((short)1).putShort((short)27245).putShort((short)2).putShort((short)paramInt);
    paramString = new oidb_sso.OIDBSSOPkg();
    paramString.uint32_command.set(1279);
    paramString.uint32_service_type.set(9);
    paramString.uint32_result.set(0);
    paramString.str_client_version.set(AppSetting.c());
    paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localByteBuffer.array()));
    paramString = paramString.toByteArray();
    localByteBuffer = ByteBuffer.allocate(paramString.length + 4);
    localByteBuffer.putInt(paramString.length + 4);
    localByteBuffer.put(paramString);
    paramPacket.putSendData(localByteBuffer.array());
    paramPacket.setSSOCommand("OidbSvc.0x4ff_203");
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    boolean bool = false;
    this.jdField_b_of_type_Boolean = false;
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    Object localObject;
    if ((this.jdField_a_of_type_Int == -1) && (localAppRuntime != null))
    {
      localObject = localAppRuntime.getApplication().getSharedPreferences("danceConfig", 4);
      String str = localAppRuntime.getAccount();
      this.jdField_a_of_type_Int = ((SharedPreferences)localObject).getInt(str + "_max_score", 0);
    }
    if (QLog.isColorLevel()) {
      QLog.d("DanceGameVideoManager", 2, "getDanceMaxScore:" + this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_Int == 0)
    {
      if (localAppRuntime != null)
      {
        localObject = new NewIntent(localAppRuntime.getApplication(), ShortVideoServlet.class);
        ((NewIntent)localObject).putExtra("action", 2);
        localAppRuntime.startServlet((NewIntent)localObject);
      }
      bool = true;
    }
    return bool;
  }
  
  public boolean a(int paramInt)
  {
    boolean bool = false;
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    Object localObject;
    if ((this.jdField_a_of_type_Int == -1) && (localAppRuntime != null))
    {
      localObject = BaseApplicationImpl.sApplication.getRuntime().getApplication().getSharedPreferences("danceConfig", 4);
      String str = localAppRuntime.getAccount();
      this.jdField_a_of_type_Int = ((SharedPreferences)localObject).getInt(str + "_max_score", 0);
    }
    if (QLog.isColorLevel()) {
      QLog.d("DanceGameVideoManager", 2, "checkDanceMaxScore maxScore:" + this.jdField_a_of_type_Int + " ,curr:" + paramInt);
    }
    if (paramInt > this.jdField_a_of_type_Int)
    {
      if (localAppRuntime != null)
      {
        localObject = new NewIntent(localAppRuntime.getApplication(), ShortVideoServlet.class);
        ((NewIntent)localObject).putExtra("key_dance_score", paramInt);
        ((NewIntent)localObject).putExtra("action", 3);
        localAppRuntime.startServlet((NewIntent)localObject);
      }
      bool = true;
    }
    return bool;
  }
  
  public void b(FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    for (;;)
    {
      try
      {
        if ((!paramFromServiceMsg.isSuccess()) || (paramArrayOfByte == null)) {
          continue;
        }
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom(paramArrayOfByte);
        if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.uint32_result.has())) {
          continue;
        }
        int i = paramFromServiceMsg.uint32_result.get();
        if (i == 0)
        {
          long l = Utils.a(ByteBuffer.wrap(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray()).getInt());
          if (this.jdField_b_of_type_Int > this.jdField_a_of_type_Int)
          {
            a(this.jdField_b_of_type_Int, String.valueOf(Long.valueOf(l)));
            this.jdField_b_of_type_Boolean = true;
          }
        }
        this.jdField_a_of_type_JavaLangString = ("error ret " + i);
      }
      catch (Exception paramFromServiceMsg)
      {
        this.jdField_a_of_type_JavaLangString = paramFromServiceMsg.getMessage();
        QLog.e("DanceGameVideoManager", 1, "handleSetDanceMaxScore exception: ", paramFromServiceMsg);
        continue;
        paramFromServiceMsg = "no pkg result";
        continue;
        this.jdField_a_of_type_JavaLangString = ("msg fail " + paramFromServiceMsg.getBusinessFailCode());
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("DanceGameVideoManager", 2, new Object[] { "handleSetDanceMaxScore result: ", this.jdField_a_of_type_JavaLangString });
      }
      return;
      if (paramFromServiceMsg != null) {
        continue;
      }
      paramFromServiceMsg = "no pkg";
      this.jdField_a_of_type_JavaLangString = paramFromServiceMsg;
    }
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancegame.DanceGameVideoManager
 * JD-Core Version:    0.7.0.1
 */