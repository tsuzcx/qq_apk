package cooperation.comic.ipc;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.redtouch.RedTouchUtils;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.VipComicJumpActivity;
import cooperation.comic.VipComicSoHelper;
import cooperation.comic.utils.BoodoHippyBirdge;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class QQComicIPCModule
  extends QIPCModule
{
  private static QQComicIPCModule jdField_a_of_type_CooperationComicIpcQQComicIPCModule;
  QQComicIPCModule.ComicConfigCallback jdField_a_of_type_CooperationComicIpcQQComicIPCModule$ComicConfigCallback;
  
  public QQComicIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static QQComicIPCModule a()
  {
    if (jdField_a_of_type_CooperationComicIpcQQComicIPCModule == null) {}
    try
    {
      if (jdField_a_of_type_CooperationComicIpcQQComicIPCModule == null) {
        jdField_a_of_type_CooperationComicIpcQQComicIPCModule = new QQComicIPCModule("QQComicIPCModule");
      }
      return jdField_a_of_type_CooperationComicIpcQQComicIPCModule;
    }
    finally {}
  }
  
  private void a(int paramInt)
  {
    ThreadManagerV2.excute(new QQComicIPCModule.2(this, paramInt), 64, null, false);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQComicIPCModule", 2, "action = " + paramString);
    }
    if (paramBundle == null)
    {
      QLog.d("QQComicIPCModule", 2, "QQComicIPCModule Err params = null, action = " + paramString);
      paramString = null;
      return paramString;
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localObject instanceof QQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQComicIPCModule", 2, "onRemoteInvoke cannot get QQAppInterface");
      }
      return null;
    }
    localObject = (QQAppInterface)localObject;
    if ("getIpExpressionConfig".equals(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQComicIPCModule", 2, " ACTION_GET_IP_EXPRESSION_CONFIGgetIpExpressionConfig");
      }
      a(paramInt);
      label131:
      return null;
    }
    if ("isLebaItemOpen".equals(paramString))
    {
      paramInt = paramBundle.getInt("appId", -1);
      paramString = ((RedTouchManager)((QQAppInterface)localObject).getManager(QQManagerFactory.MGR_RED_TOUCH)).a().iterator();
      do
      {
        if (!paramString.hasNext()) {
          break;
        }
        paramBundle = (BusinessInfoCheckUpdate.AppSetting)paramString.next();
      } while (paramBundle.appid.get() != paramInt);
    }
    for (boolean bool = paramBundle.setting.get();; bool = false)
    {
      for (;;)
      {
        paramString = new Bundle();
        paramString.putBoolean("isLebaItemOpen", bool);
        return EIPCResult.createResult(0, paramString);
        if ("getRedTouchInfo".equals(paramString))
        {
          paramString = (RedTouchManager)((QQAppInterface)localObject).getManager(QQManagerFactory.MGR_RED_TOUCH);
          localObject = paramBundle.getStringArrayList("pathList");
          if ((paramString == null) || (localObject == null)) {
            break;
          }
          paramBundle = new ArrayList();
          localObject = ((ArrayList)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            BusinessInfoCheckUpdate.AppInfo localAppInfo = paramString.a((String)((Iterator)localObject).next());
            if (localAppInfo != null) {
              paramBundle.add(RedTouchUtils.a(localAppInfo));
            }
          }
          paramString = new Bundle();
          paramString.putParcelableArrayList("redTouchInfoList", paramBundle);
          return EIPCResult.createResult(0, paramString);
        }
        if (!"reportRedTouchClick".equals(paramString)) {
          break label444;
        }
        paramString = (RedTouchManager)((QQAppInterface)localObject).getManager(QQManagerFactory.MGR_RED_TOUCH);
        paramBundle = paramBundle.getString("path");
        if ((paramString == null) || (paramBundle == null)) {
          break;
        }
        paramString.b(paramBundle);
        try
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("service_type", 2);
          ((JSONObject)localObject).put("act_id", 1002);
          paramString.c(paramString.a(paramBundle), ((JSONObject)localObject).toString());
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
        }
      }
      break label131;
      label444:
      if ("initPluginBeforeEnter".equals(paramString))
      {
        VipComicJumpActivity.a((AppInterface)localObject, paramBundle.getBoolean("doLoadModule"));
        break label131;
      }
      if ("check_qqcomic_plugin".equals(paramString))
      {
        BoodoHippyBirdge.a(BaseApplicationImpl.getContext(), (QQAppInterface)localObject, new QQComicIPCModule.1(this, paramInt));
        break label131;
      }
      if ("launch_qqcomic_hippy".equals(paramString))
      {
        if (!QLog.isColorLevel()) {
          break label131;
        }
        QLog.d("QQComicIPCModule", 2, "ACTION_LAUNCH_QQCOMIC_HIPPY launchHippyPage");
        break label131;
      }
      if ("getComicConfig".equals(paramString))
      {
        paramString = (IVasQuickUpdateService)((QQAppInterface)localObject).getRuntimeService(IVasQuickUpdateService.class, "");
        if ((paramInt > 0) && (paramString != null))
        {
          if (this.jdField_a_of_type_CooperationComicIpcQQComicIPCModule$ComicConfigCallback == null) {
            this.jdField_a_of_type_CooperationComicIpcQQComicIPCModule$ComicConfigCallback = new QQComicIPCModule.ComicConfigCallback(this, paramInt);
          }
          paramString.addCallBacker(this.jdField_a_of_type_CooperationComicIpcQQComicIPCModule$ComicConfigCallback);
        }
        paramString = VasUpdateUtil.a((AppRuntime)localObject, "vipComic_config_v2.json", true, null);
        if (paramString == null) {
          break label131;
        }
        paramBundle = new Bundle();
        paramBundle.putString("config_json", paramString.toString());
        paramBundle = EIPCResult.createResult(0, paramBundle);
        paramString = paramBundle;
        if (paramInt <= 0) {
          break;
        }
        callbackResult(paramInt, paramBundle);
        break label131;
      }
      if (!"getPlayerSo".equals(paramString)) {
        break label131;
      }
      VipComicSoHelper.a((QQAppInterface)localObject);
      break label131;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.comic.ipc.QQComicIPCModule
 * JD-Core Version:    0.7.0.1
 */