package cooperation.qqindividuality.ipc;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ClubContentUpdateHandler;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureHandler;
import com.tencent.mobileqq.app.UniPayHandler;
import com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.remote.ToServiceMsg;
import protocol.KQQConfig.GetResourceReqInfo;

public class IndividualityRemoteCommandHandler
  implements IndividualityRemoteCommand.IRemoteCommandHandler
{
  public boolean a(int paramInt, Bundle paramBundle)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    String str1;
    switch (paramInt)
    {
    default: 
      return true;
    case 17: 
      if (paramBundle != null)
      {
        ((QQAppInterface)localObject).sendToService((ToServiceMsg)paramBundle.getParcelable("msg"));
        return true;
      }
      break;
    case 16: 
      paramBundle = ContactUtils.d((QQAppInterface)localObject, ((QQAppInterface)localObject).getCurrentAccountUin());
      localObject = new Bundle();
      ((Bundle)localObject).putString("name", paramBundle);
      QQIndividualityPluginProxyService.a().a("qqindividuality_signature", 6, (Bundle)localObject);
      return true;
    case 15: 
      ((SignatureHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.SIGNATURE_HANDLER)).a(paramBundle.getString("uin"), paramBundle.getString("feedsId"), 255, true);
      return true;
    case 14: 
      paramBundle = (SignatureHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.SIGNATURE_HANDLER);
      if (paramBundle != null)
      {
        paramBundle.a();
        return true;
      }
      break;
    case 13: 
      ((QQAppInterface)localObject).registObserver(new IndividualityRemoteCommandHandler.MyStatusObserver(this, null));
      return true;
    case 12: 
      ((QQAppInterface)localObject).addObserver(new IndividualityRemoteCommandHandler.3(this));
      return true;
    case 11: 
      str1 = paramBundle.getString("mUin");
      String str2 = paramBundle.getString("feedsId");
      paramInt = paramBundle.getInt("action");
      paramBundle = (SignatureHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.SIGNATURE_HANDLER);
      if (paramBundle != null)
      {
        paramBundle.a(str1, str2, 255, paramInt);
        return true;
      }
      break;
    case 10: 
      paramInt = paramBundle.getInt("iFaceType");
      str1 = paramBundle.getString("uinOrMobileNum");
      byte b = paramBundle.getByte("faceFileType");
      int i = paramBundle.getInt("idType");
      paramBundle = (IQQAvatarHandlerService)((QQAppInterface)localObject).getRuntimeService(IQQAvatarHandlerService.class, "");
      if (paramInt != 1)
      {
        if (paramInt != 4)
        {
          if (paramInt != 11)
          {
            if (paramInt != 16)
            {
              if (paramInt != 32) {
                return true;
              }
              paramBundle.getStrangerHead(str1, i, (byte)1, b);
              return true;
            }
            paramBundle.getQCallHead(str1, i, (byte)1, b);
            return true;
          }
          paramBundle.getMobileQQHead(str1, b);
          return true;
        }
        paramBundle.getTroopHead(str1, b);
        return true;
      }
      paramBundle.getCustomHead(str1, (byte)0, b);
      return true;
    case 9: 
      boolean bool = paramBundle.getBoolean("visible");
      ((LBSHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.LBS_HANDLER)).a(bool);
      return true;
    case 8: 
      ((QQAppInterface)localObject).addObserver(new IndividualityRemoteCommandHandler.2(this));
      return true;
    case 7: 
      paramBundle = (ConfigHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER);
      paramBundle.a(null, new GetResourceReqInfo[] { paramBundle.j() });
      return true;
    case 6: 
      paramBundle = (UniPayHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.UNI_PAY_HANDLER);
      paramBundle.a(new IndividualityRemoteCommandHandler.1(this));
      paramBundle.a("");
      return true;
    case 5: 
      ClubContentUpdateHandler.a((QQAppInterface)localObject);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqindividuality.ipc.IndividualityRemoteCommandHandler
 * JD-Core Version:    0.7.0.1
 */