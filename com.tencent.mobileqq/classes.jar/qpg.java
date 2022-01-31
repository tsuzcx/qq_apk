import android.content.ContextWrapper;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.lang.ref.WeakReference;
import mqq.app.MobileQQ;

class qpg
  extends QIPCModule
{
  qpg(qpf paramqpf, String paramString)
  {
    super(paramString);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ("CMD_SHORTVIDEO_REQUEST_MANUAL_DOWNLOAD".equals(paramString))
    {
      paramBundle.setClassLoader(MessageForShortVideo.class.getClassLoader());
      paramString = (MessageForShortVideo)paramBundle.getParcelable("VALUE_SHORTVIDEO_MSG");
      paramBundle = acwd.a((QQAppInterface)localObject);
      if (paramBundle != null)
      {
        if (qpf.a(this.a) == null) {
          qpf.a(this.a, new View(BaseApplicationImpl.getContext()));
        }
        qpf.a(this.a, new qph(this, paramString));
        paramBundle.a(qpf.a(this.a), qpf.a(this.a));
      }
      paramString.busiType = 0;
      paramString = axdo.a((QQAppInterface)localObject, paramString, 1);
      if (paramString != null) {
        axdo.a(paramString, (QQAppInterface)localObject);
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            for (;;)
            {
              return null;
              if ("CMD_SHORTVIDEO_UPDATE_MSG_BY_UNISEQ".equals(paramString))
              {
                paramBundle.setClassLoader(MessageForShortVideo.class.getClassLoader());
                paramString = (MessageForShortVideo)paramBundle.getParcelable("VALUE_SHORTVIDEO_MSG");
                ((QQAppInterface)localObject).a().a(paramString.frienduin, paramString.istroop, paramString.uniseq, paramString.msgData);
              }
              else if ("CMD_SHORTVIDEO_REQUEST_CLEAR".equals(paramString))
              {
                if (qpf.a(this.a) != null)
                {
                  if (acwd.a((QQAppInterface)localObject) != null) {
                    acwd.a((QQAppInterface)localObject).a(qpf.a(this.a), null);
                  }
                  qpf.a(this.a, null);
                }
                qpf.a(this.a, null);
              }
              else if ("CMD_HANDLE_FORWARD_DATA".equals(paramString))
              {
                qol.a((QQAppInterface)localObject, paramBundle);
              }
              else if ("CMD_INIT_READINJOY_MANAGER".equals(paramString))
              {
                ((QQAppInterface)localObject).getManager(96);
              }
              else
              {
                if ("CMD_PUB_ACCOUNT_CHECK_IS_FOLLOWED".equals(paramString)) {
                  try
                  {
                    bool = qol.a((QQAppInterface)localObject, paramBundle.getLong("VALUE_PUB_ACCOUNT_UIN"));
                    paramString = new Bundle();
                    paramString.putBoolean("VALUE_PUB_ACCOUNT_IS_FOLLOWED", bool);
                    return EIPCResult.createSuccessResult(paramString);
                  }
                  catch (Exception paramString)
                  {
                    for (;;)
                    {
                      boolean bool = true;
                    }
                  }
                }
                if ("CMD_FOLLOW_PUB_ACCOUNT".equals(paramString))
                {
                  qol.a((QQAppInterface)localObject, paramBundle.getString("VALUE_PUB_ACCOUNT_UIN"), false);
                }
                else
                {
                  if ("CMD_VOLUMECONTROL_INSTANCE_SHOULDMUTEINVIDEOFEEDS_GET".equals(paramString))
                  {
                    paramBundle = new Bundle();
                    paramBundle.putBoolean("VOLUMECONTROL_INSTANCE_SHOULDMUTEINVIDEOFEEDS", qvn.a().a(false));
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.pubaccount.video.feeds.VideoFeedsIPCServer", 2, paramString + " shouldMuteInVideoFeed = " + qvn.a().a(false));
                    }
                    return EIPCResult.createSuccessResult(paramBundle);
                  }
                  if ("CMD_VOLUMECONTROL_INSTANCE_SHOULDMUTEINVIDEOFEEDS_SET".equals(paramString))
                  {
                    localObject = Boolean.valueOf(false);
                    if (paramBundle != null) {
                      localObject = Boolean.valueOf(paramBundle.getBoolean("VOLUMECONTROL_INSTANCE_SHOULDMUTEINVIDEOFEEDS", false));
                    }
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.pubaccount.video.feeds.VideoFeedsIPCServer", 2, paramString + "  VOLUMECONTROL_INSTANCE_SHOULDMUTEINVIDEOFEEDS = " + localObject);
                    }
                    qvn.a().b(((Boolean)localObject).booleanValue());
                  }
                  else
                  {
                    if ("CMD_IS_VIDEO_PLAY_NEED_ALERT_IN_XG".equals(paramString))
                    {
                      paramBundle = new Bundle();
                      paramBundle.putBoolean("VALUE_VIDEO_NEED_ALERT", qku.a().d());
                      if (QLog.isColorLevel()) {
                        QLog.d("Q.pubaccount.video.feeds.VideoFeedsIPCServer", 2, paramString + " VALUE_VIDEO_NEED_ALERT = " + qku.a().d());
                      }
                      return EIPCResult.createSuccessResult(paramBundle);
                    }
                    if ("CMD_IS_VIDEO_CHATTING".equals(paramString))
                    {
                      paramString = new Bundle();
                      paramString.putBoolean("VALUE_IS_VIDEO_CHATTING", ((QQAppInterface)localObject).c());
                      return EIPCResult.createSuccessResult(paramString);
                    }
                    if ("CMD_COMFIRM_VIDEO_PLAY_NEED_ALERT_IN_XG".equals(paramString))
                    {
                      localObject = Boolean.valueOf(true);
                      if (paramBundle != null) {
                        localObject = Boolean.valueOf(paramBundle.getBoolean("VALUE_IS_CONFIRM_IN_XG"));
                      }
                      qku.a().b = ((Boolean)localObject).booleanValue();
                      if (QLog.isColorLevel()) {
                        QLog.d("Q.pubaccount.video.feeds.VideoFeedsIPCServer", 2, paramString + " VALUE_IS_CONFIRM_IN_XG = " + localObject);
                      }
                    }
                    else if ("CMD_NETWORK_CHANGE".equals(paramString))
                    {
                      localObject = Boolean.valueOf(true);
                      if (paramBundle != null) {
                        localObject = Boolean.valueOf(paramBundle.getBoolean("VALUE_NETWORK_CHANGE_IS_WIFI"));
                      }
                      qku.a().b(((Boolean)localObject).booleanValue());
                      if (QLog.isColorLevel()) {
                        QLog.d("Q.pubaccount.video.feeds.VideoFeedsIPCServer", 2, paramString + " VALUE_NETWORK_CHANGE_IS_WIFI = " + localObject);
                      }
                    }
                    else if ("CMD_IGNORE_VOLUME_CHANGE".equals(paramString))
                    {
                      qvn.a().c(true);
                    }
                    else if ("CMD_CANCEL_IGNORE_VOLUME_CHANGE".equals(paramString))
                    {
                      qvn.a().c(false);
                    }
                    else
                    {
                      if ("CMD_GET_CURRENT_NICK_NAME".equals(paramString))
                      {
                        paramString = ((QQAppInterface)localObject).getCurrentNickname();
                        paramBundle = new Bundle();
                        paramBundle.putString("VALUE_GET_CURRENT_NICK_NAME", paramString);
                        return EIPCResult.createSuccessResult(paramBundle);
                      }
                      if ("CMD_GET_CURRENT_USER_HEAD".equals(paramString))
                      {
                        paramString = ((QQAppInterface)localObject).a(1, ((QQAppInterface)localObject).c(), 200);
                        paramBundle = new Bundle();
                        paramBundle.putString("CMD_GET_CURRENT_USER_HEAD", paramString);
                        return EIPCResult.createSuccessResult(paramBundle);
                      }
                      if ("CMD_CAMERA_CAPTURE_CHECK_SO_READY".equals(paramString))
                      {
                        paramString = new Bundle();
                        paramString.putBoolean("VALUE_CAMERA_CAPTURE_IS_SO_READY", Boolean.valueOf(oeg.a((QQAppInterface)localObject, BaseApplicationImpl.getContext())).booleanValue());
                        paramString.putBoolean("VALUE_CAMERA_IS_VIDEO_CHATTING", ((QQAppInterface)localObject).c());
                        return EIPCResult.createSuccessResult(paramString);
                      }
                      if ("CMD_CAMERA_CAPTURE_SO_DOWNLOAD".equals(paramString))
                      {
                        if (qpf.a(this.a) == null) {
                          qpf.a(this.a, new oeh((QQAppInterface)localObject, BaseApplicationImpl.getContext()));
                        }
                        qpf.a(this.a).a(new qpi(this));
                        qpf.a(this.a).a();
                      }
                      else
                      {
                        if ("CMD_GET_NICK_NAME_BY_UIN".equals(paramString))
                        {
                          qpf.a(this.a, new qpj(this, (QQAppInterface)localObject));
                          ((QQAppInterface)localObject).addObserver(qpf.a(this.a));
                          paramString = new Bundle();
                          paramString.putString("VALUE_USER_NICK_NAME", bbcl.b((QQAppInterface)localObject, paramBundle.getString("VALUE_USER_UIN_TO_GET_NICK_NAME"), true));
                          return EIPCResult.createSuccessResult(paramString);
                        }
                        if ("CMD_GET_NICK_NAME_BY_UIN_CANCLE".equals(paramString))
                        {
                          ((QQAppInterface)localObject).removeObserver(qpf.a(this.a));
                        }
                        else
                        {
                          if (!"CMD_REPORT_START_TIME".equals(paramString)) {
                            break;
                          }
                          qtg.a(((QQAppInterface)localObject).getApplication().getApplicationContext());
                        }
                      }
                    }
                  }
                }
              }
            }
            if ("CMD_GET_CLICK_COMMENT_ACTICLEINFO".equals(paramString))
            {
              paramBundle = new Bundle();
              paramBundle.putString("VALUE_CLICK_COMMENT_ACTICLEINFO", qke.a().b());
              if (QLog.isColorLevel()) {
                QLog.d("Q.pubaccount.video.feeds.VideoFeedsIPCServer", 2, paramString + " VALUE_CLICK_COMMENT_ACTICLEINFO = " + qke.a().b());
              }
              return EIPCResult.createSuccessResult(paramBundle);
            }
            if (!"CMD_GET_UNREAD_MESSAGE_BOX_DATA".equals(paramString)) {
              break;
            }
          } while (qke.a().a().isEmpty());
          paramBundle = qke.a().a();
          localObject = new Bundle();
          ((Bundle)localObject).putString("VALUE_UNREAD_MESSAGE_BOX_DATA", paramBundle);
          if (QLog.isColorLevel()) {
            QLog.d("Q.pubaccount.video.feeds.VideoFeedsIPCServer", 2, paramString + " VALUE_CLICK_COMMENT_ACTICLEINFO = " + paramBundle);
          }
          return EIPCResult.createSuccessResult((Bundle)localObject);
          if (!"CMD_GET_WEB_RENDER_DATA".equals(paramString)) {
            break;
          }
          paramString = paramBundle.getString("bundle_params_render_url");
        } while (TextUtils.isEmpty(paramString));
        paramString = ost.a(paramString);
      } while (paramString == null);
      paramBundle = new Bundle();
      paramBundle.putString("VALUE_WEB_RENDER_DATA", paramString.a);
      return EIPCResult.createSuccessResult(paramBundle);
      if ("CMD_GET_REPORT_KANDIAN_MODE".equals(paramString))
      {
        paramInt = onk.e();
        paramString = new Bundle();
        paramString.putInt("VALUE_REPORT_KANDIAN_MODE", paramInt);
        return EIPCResult.createSuccessResult(paramString);
      }
      if ("CMD_GET_REPORT_KANDIAN_MODE_NEW".equals(paramString))
      {
        paramInt = npx.a();
        paramString = new Bundle();
        paramString.putInt("VALUE_REPORT_KANDIAN_MODE_NEW", paramInt);
        return EIPCResult.createSuccessResult(paramString);
      }
    } while (!"CMD_OPEN_VIOLA_FROM_TOOL".equals(paramString));
    localObject = paramBundle.getString("url");
    paramBundle = paramBundle.getString("webUrl");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if (TextUtils.isEmpty(paramBundle)) {
        break label1565;
      }
      if ((SplashActivity.a == null) || (SplashActivity.a.get() == null)) {
        break label1558;
      }
    }
    label1558:
    for (paramString = (ContextWrapper)SplashActivity.a.get();; paramString = BaseApplicationImpl.getContext())
    {
      rwa.a(paramString, "", (String)localObject, null, new qpk(this, paramBundle));
      return EIPCResult.createSuccessResult(null);
    }
    label1565:
    if ((SplashActivity.a != null) && (SplashActivity.a.get() != null)) {}
    for (paramString = (ContextWrapper)SplashActivity.a.get();; paramString = BaseApplicationImpl.getContext())
    {
      rwa.a(paramString, "", (String)localObject, null);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qpg
 * JD-Core Version:    0.7.0.1
 */