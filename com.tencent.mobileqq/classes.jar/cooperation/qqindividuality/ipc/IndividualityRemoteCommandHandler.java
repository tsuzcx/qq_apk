package cooperation.qqindividuality.ipc;

import alzz;
import amaa;
import amab;
import amac;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ClubContentUpdateHandler;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureHandler;
import com.tencent.mobileqq.app.UniPayHandler;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.remote.ToServiceMsg;
import protocol.KQQConfig.GetResourceReqInfo;

public class IndividualityRemoteCommandHandler
  implements IndividualityRemoteCommand.IRemoteCommandHandler
{
  public boolean a(int paramInt, Bundle paramBundle)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        String str1;
        String str2;
        do
        {
          return true;
          ClubContentUpdateHandler.a((QQAppInterface)localObject);
          return true;
          paramBundle = (UniPayHandler)((QQAppInterface)localObject).a(44);
          paramBundle.a(new alzz(this));
          paramBundle.a("");
          return true;
          paramBundle = (ConfigHandler)((QQAppInterface)localObject).a(4);
          paramBundle.a(null, new GetResourceReqInfo[] { paramBundle.d() });
          return true;
          ((QQAppInterface)localObject).addObserver(new amaa(this));
          return true;
          boolean bool = paramBundle.getBoolean("visible");
          ((LBSHandler)((QQAppInterface)localObject).a(3)).a(bool);
          return true;
          paramInt = paramBundle.getInt("iFaceType");
          str1 = paramBundle.getString("uinOrMobileNum");
          byte b = paramBundle.getByte("faceFileType");
          int i = paramBundle.getInt("idType");
          paramBundle = (FriendListHandler)((QQAppInterface)localObject).a(1);
          switch (paramInt)
          {
          default: 
            return true;
          case 1: 
            paramBundle.a(str1, (byte)0, b);
            return true;
          case 11: 
            paramBundle.b(str1, b);
            return true;
          case 4: 
            paramBundle.a(str1, b);
            return true;
          case 32: 
            paramBundle.a(str1, i, (byte)1, b);
            return true;
          }
          paramBundle.b(str1, i, (byte)1, b);
          return true;
          str1 = paramBundle.getString("mUin");
          str2 = paramBundle.getString("feedsId");
          paramInt = paramBundle.getInt("action");
          paramBundle = (SignatureHandler)((QQAppInterface)localObject).a(41);
        } while (paramBundle == null);
        paramBundle.a(str1, str2, 255, paramInt);
        return true;
        ((QQAppInterface)localObject).addObserver(new amab(this));
        return true;
        ((QQAppInterface)localObject).registObserver(new amac(this, null));
        return true;
        paramBundle = (SignatureHandler)((QQAppInterface)localObject).a(41);
      } while (paramBundle == null);
      paramBundle.b();
      return true;
      ((SignatureHandler)((QQAppInterface)localObject).a(41)).a(paramBundle.getString("uin"), paramBundle.getString("feedsId"), 255, true);
      return true;
      paramBundle = ContactUtils.l((QQAppInterface)localObject, ((QQAppInterface)localObject).getCurrentAccountUin());
      localObject = new Bundle();
      ((Bundle)localObject).putString("name", paramBundle);
      QQIndividualityPluginProxyService.a().a("qqindividuality_signature", 6, (Bundle)localObject);
      return true;
    } while (paramBundle == null);
    ((QQAppInterface)localObject).sendToService((ToServiceMsg)paramBundle.getParcelable("msg"));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqindividuality.ipc.IndividualityRemoteCommandHandler
 * JD-Core Version:    0.7.0.1
 */