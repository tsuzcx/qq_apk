package com.tencent.mobileqq.config;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;
import tencent.im.oidb.cmd0x8dd.oidb_0x8dd.SelfInfo;

public class NearbyDataManager
  implements Manager
{
  public static byte a = 30;
  private int jdField_a_of_type_Int = 0;
  private INearbyAppInterface jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface;
  
  public NearbyDataManager(INearbyAppInterface paramINearbyAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface = paramINearbyAppInterface;
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    return ((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(paramQQAppInterface.getCurrentAccountUin(), "nearby_usercard_tab_host", Integer.valueOf(0))).intValue();
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    return ((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(paramQQAppInterface.getCurrentAccountUin(), "face_score_switch", Integer.valueOf(0))).intValue() == 1;
  }
  
  public static int b(QQAppInterface paramQQAppInterface)
  {
    return ((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(paramQQAppInterface.getCurrentAccountUin(), "nearby_usercard_tab_guest", Integer.valueOf(-1))).intValue();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a() {}
  
  public void a(INearbyAppInterface paramINearbyAppInterface, oidb_0x8dd.SelfInfo paramSelfInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("writeSelfInfo");
    ((StringBuilder)localObject).append(paramSelfInfo);
    localObject = ((StringBuilder)localObject).toString();
    int i = 2;
    QLog.d("NearbyNiche", 2, (String)localObject);
    if (paramSelfInfo == null) {
      return;
    }
    localObject = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("self_info");
    localStringBuilder.append(paramINearbyAppInterface.getCurrentAccountUin());
    localObject = ((BaseApplicationImpl)localObject).getSharedPreferences(localStringBuilder.toString(), 4);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit().putString("nick", paramSelfInfo.bytes_nick.get().toStringUtf8()).putInt("charm_level", paramSelfInfo.uint32_charm_level.get()).putInt("charm", paramSelfInfo.uint32_charm.get()).putString("third_line", paramSelfInfo.str_third_line_info.get()).putString("third_line_icon", paramSelfInfo.str_third_line_icon.get()).putInt("god_flag", paramSelfInfo.uint32_god_flag.get()).putInt("real_video_auth", paramSelfInfo.uint32_real_video_flag.get()).putInt("gender", paramSelfInfo.uint32_gender.get()).putInt("age", paramSelfInfo.uint32_age.get()).putInt("task_finished", paramSelfInfo.uint32_finish_task_num.get()).putInt("task_total", paramSelfInfo.uint32_all_task_num.get());
      if (paramSelfInfo.uint32_vote_num.get() >= 0) {
        ((SharedPreferences.Editor)localObject).putInt("vote", paramSelfInfo.uint32_vote_num.get());
      }
      if (paramSelfInfo.uint32_vote_increment.get() >= 0) {
        ((SharedPreferences.Editor)localObject).putInt("vote_increment", paramSelfInfo.uint32_vote_increment.get());
      }
      ((SharedPreferences.Editor)localObject).commit();
    }
    if (paramSelfInfo.uint32_gender.get() != -1)
    {
      int j = paramSelfInfo.uint32_gender.get();
      if (j != 0)
      {
        if (j != 1) {
          i = 0;
        }
      }
      else {
        i = 1;
      }
      ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(paramINearbyAppInterface.getAccount(), "self_gender", Integer.valueOf(i));
    }
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      this.jdField_a_of_type_Int = Integer.valueOf(paramString).intValue();
      return;
    }
    catch (Exception paramString)
    {
      label19:
      break label19;
    }
    this.jdField_a_of_type_Int = 0;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.NearbyDataManager
 * JD-Core Version:    0.7.0.1
 */