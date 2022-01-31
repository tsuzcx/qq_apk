import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.biz.pubaccount.readinjoy.logic.DiandianTopConfigManager.2;
import com.tencent.biz.pubaccount.readinjoy.logic.DiandianTopConfigManager.3;
import com.tencent.biz.pubaccount.readinjoy.model.DiandianTopConfig;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.oidb_0xb7e.DiandianTopConfig;
import tencent.im.oidb.oidb_0xb7e.ReqBody;
import tencent.im.oidb.oidb_0xb7e.RspBody;
import tencent.im.oidb.oidb_0xc90.ReqBody;

public class ped
{
  public static final String a;
  private static ped a;
  public final Object a;
  
  static
  {
    jdField_a_of_type_JavaLangString = ped.class.getName();
  }
  
  public ped()
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public static ped a()
  {
    if (jdField_a_of_type_Ped == null) {}
    try
    {
      if (jdField_a_of_type_Ped == null) {
        jdField_a_of_type_Ped = new ped();
      }
      return jdField_a_of_type_Ped;
    }
    finally {}
  }
  
  public static void a(long paramLong)
  {
    AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit();
    localEditor.putLong("config_last_update_time" + localAppInterface.getCurrentAccountUin(), paramLong);
    localEditor.commit();
  }
  
  private void a(oidb_0xb7e.RspBody paramRspBody)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "fabricateModel");
    }
    if (paramRspBody == null) {
      oxb.a().a(false, null);
    }
    do
    {
      return;
      if (!paramRspBody.rpt_top_item.has()) {
        break;
      }
      paramRspBody = paramRspBody.rpt_top_item.get();
    } while ((paramRspBody == null) || (paramRspBody.size() <= 0));
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramRspBody.size())
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
      if (localDiandianTopConfig.uint32_topic_id.has()) {}
      for (localDiandianTopConfig1.topicId = localDiandianTopConfig.uint32_topic_id.get();; localDiandianTopConfig1.topicId = 0)
      {
        localArrayList.add(localDiandianTopConfig1);
        i += 1;
        break;
      }
    }
    oxb.a().a(true, localArrayList);
    return;
    oxb.a().a(true, null);
  }
  
  private void a(byte[] paramArrayOfByte, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "saveDiandianTopConfig");
    }
    ThreadManager.post(new DiandianTopConfigManager.3(this, paramArrayOfByte, paramLong), 5, null, true);
  }
  
  public static boolean a()
  {
    AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    long l = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getLong("config_last_update_time" + localAppInterface.getCurrentAccountUin(), 0L);
    return System.currentTimeMillis() - l >= 43200000L;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "loadDiandianTopConfig");
    }
    ThreadManager.post(new DiandianTopConfigManager.2(this), 5, null, true);
  }
  
  public void a(List<Long> paramList, sec paramsec)
  {
    oidb_0xc90.ReqBody localReqBody = new oidb_0xc90.ReqBody();
    localReqBody.uint64_community_bid.set(paramList);
    mzy.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), new pef(this, paramsec), localReqBody.toByteArray(), "OidbSvc.0xc90", 3216, 1, null, 0L);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "requestDiandianTopConfig");
    }
    oidb_0xb7e.ReqBody localReqBody = new oidb_0xb7e.ReqBody();
    mzy.a((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), new pee(this, paramBoolean), localReqBody.toByteArray(), "OidbSvc.0xb7e", 2942, 0, null, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ped
 * JD-Core Version:    0.7.0.1
 */