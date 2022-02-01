package com.tencent.mobileqq.kandian.glue.businesshandler;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.repo.comment.entity.DiandianTopConfig;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.oidb_0xb7e.DiandianTopConfig;
import tencent.im.oidb.oidb_0xb7e.ReqBody;
import tencent.im.oidb.oidb_0xb7e.RspBody;

public class DiandianTopConfigManager
{
  public static final String a = "com.tencent.mobileqq.kandian.glue.businesshandler.DiandianTopConfigManager";
  protected static final Object b = new Object();
  private static DiandianTopConfigManager c;
  
  public static DiandianTopConfigManager a()
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new DiandianTopConfigManager();
        }
      }
      finally {}
    }
    return c;
  }
  
  public static void a(long paramLong)
  {
    AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("config_last_update_time");
    localStringBuilder.append(localAppInterface.getCurrentAccountUin());
    localEditor.putLong(localStringBuilder.toString(), paramLong);
    localEditor.commit();
  }
  
  private void a(oidb_0xb7e.RspBody paramRspBody)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "fabricateModel");
    }
    if (paramRspBody == null)
    {
      ReadInJoyLogicEngineEventDispatcher.a().a(false, null);
      return;
    }
    if (paramRspBody.rpt_top_item.has())
    {
      paramRspBody = paramRspBody.rpt_top_item.get();
      if (paramRspBody != null)
      {
        if (paramRspBody.size() <= 0) {
          return;
        }
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < paramRspBody.size())
        {
          oidb_0xb7e.DiandianTopConfig localDiandianTopConfig = (oidb_0xb7e.DiandianTopConfig)paramRspBody.get(i);
          DiandianTopConfig localDiandianTopConfig1 = new DiandianTopConfig();
          if (localDiandianTopConfig.bytes_jump_url.has()) {
            localDiandianTopConfig1.jumpUrl = localDiandianTopConfig.bytes_jump_url.get().toStringUtf8();
          }
          if (localDiandianTopConfig.bytes_title.has()) {
            localDiandianTopConfig1.title = localDiandianTopConfig.bytes_title.get().toStringUtf8();
          }
          if (localDiandianTopConfig.bytes_sub_title.has()) {
            localDiandianTopConfig1.subTitle = localDiandianTopConfig.bytes_sub_title.get().toStringUtf8();
          }
          if (localDiandianTopConfig.bytes_sub_title_color.has()) {
            localDiandianTopConfig1.subTitleColor = localDiandianTopConfig.bytes_sub_title_color.get().toStringUtf8();
          }
          if (localDiandianTopConfig.bytes_pic_url.has()) {
            localDiandianTopConfig1.picUrl = localDiandianTopConfig.bytes_pic_url.get().toStringUtf8();
          }
          if (localDiandianTopConfig.uint32_type.has()) {
            localDiandianTopConfig1.type = localDiandianTopConfig.uint32_type.get();
          }
          if (localDiandianTopConfig.uint32_topic_id.has()) {
            localDiandianTopConfig1.topicId = localDiandianTopConfig.uint32_topic_id.get();
          } else {
            localDiandianTopConfig1.topicId = 0;
          }
          localArrayList.add(localDiandianTopConfig1);
          i += 1;
        }
        ReadInJoyLogicEngineEventDispatcher.a().a(true, localArrayList);
        return;
      }
      return;
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(true, null);
  }
  
  private void a(byte[] paramArrayOfByte, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "saveDiandianTopConfig");
    }
    ThreadManager.post(new DiandianTopConfigManager.3(this, paramArrayOfByte, paramLong), 5, null, true);
  }
  
  public static boolean c()
  {
    AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("config_last_update_time");
    localStringBuilder.append(localAppInterface.getCurrentAccountUin());
    long l = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
    return System.currentTimeMillis() - l >= 43200000L;
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "requestDiandianTopConfig");
    }
    oidb_0xb7e.ReqBody localReqBody = new oidb_0xb7e.ReqBody();
    ProtoUtils.a((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), new DiandianTopConfigManager.1(this, paramBoolean), localReqBody.toByteArray(), "OidbSvc.0xb7e", 2942, 0, null, 0L);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "loadDiandianTopConfig");
    }
    ThreadManager.post(new DiandianTopConfigManager.2(this), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.DiandianTopConfigManager
 * JD-Core Version:    0.7.0.1
 */