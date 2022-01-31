import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.APIParam;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.impl.commonModule.UserInfoModule;
import com.tencent.mobileqq.Doraemon.impl.commonModule.UserInfoModule.LoginInfo;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0xb6e.Oidb_0xb6e.AppFriendsInfo;
import tencent.im.oidb.cmd0xb6e.Oidb_0xb6e.RspBody;

public class rjn
  extends ProtoUtils.TroopProtocolObserver
{
  public rjn(UserInfoModule paramUserInfoModule, APICallback paramAPICallback) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i(UserInfoModule.jdField_a_of_type_JavaLangString, 2, "onResult appid=" + UserInfoModule.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserInfoModule).jdField_a_of_type_JavaLangString + ", openid=" + this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserInfoModule.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserInfoModule$LoginInfo.jdField_a_of_type_JavaLangString + ", openkey=" + this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserInfoModule.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserInfoModule$LoginInfo.b + ", code=" + paramInt);
    }
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, paramInt, "getappfriends result error, try again");
      return;
    }
    paramBundle = new Oidb_0xb6e.RspBody();
    try
    {
      paramBundle.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = paramBundle;
    }
    catch (InvalidProtocolBufferMicroException paramBundle)
    {
      ArrayList localArrayList;
      for (;;)
      {
        paramArrayOfByte = null;
        paramBundle.printStackTrace();
      }
      paramBundle.put("appfriends", localArrayList);
      DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, paramBundle);
      return;
    }
    if (paramArrayOfByte != null)
    {
      paramBundle = new APIParam();
      localArrayList = new ArrayList();
      paramArrayOfByte = paramArrayOfByte.rpt_friends_info.get().iterator();
      while (paramArrayOfByte.hasNext())
      {
        Object localObject = (Oidb_0xb6e.AppFriendsInfo)paramArrayOfByte.next();
        String str1 = ((Oidb_0xb6e.AppFriendsInfo)localObject).openid.get();
        String str2 = ((Oidb_0xb6e.AppFriendsInfo)localObject).nick.get().toStringUtf8();
        localObject = ((Oidb_0xb6e.AppFriendsInfo)localObject).figure_url_qq.get();
        if (!TextUtils.isEmpty(str1))
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("openid", str1.toUpperCase());
          localHashMap.put("nickName", str2);
          localHashMap.put("avatarUrl", localObject);
          localArrayList.add(localHashMap);
        }
      }
    }
    DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, -1, "parse result error, try again");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rjn
 * JD-Core Version:    0.7.0.1
 */