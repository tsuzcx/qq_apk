import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCameraCaptureHelper;
import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCameraCaptureSoManager;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyWebRenderEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyWebRenderEngine.RenderHtmlData;
import com.tencent.biz.pubaccount.readinjoy.video.ReadInJoyWebDataManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoAutoPlayController;
import com.tencent.biz.pubaccount.readinjoy.video.VideoBrightnessControl;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsIPCServer;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsStartStatistic;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.MobileQQ;

public class mck
  extends QIPCModule
{
  public mck(VideoFeedsIPCServer paramVideoFeedsIPCServer, String paramString)
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
      paramBundle = FileTransferManager.a((QQAppInterface)localObject);
      if (paramBundle != null)
      {
        if (VideoFeedsIPCServer.a(this.a) == null) {
          VideoFeedsIPCServer.a(this.a, new View(BaseApplicationImpl.getContext()));
        }
        VideoFeedsIPCServer.a(this.a, new mcl(this, paramString));
        paramBundle.a(VideoFeedsIPCServer.a(this.a), VideoFeedsIPCServer.a(this.a));
      }
      paramString.busiType = 0;
      paramString = ShortVideoBusiManager.a((QQAppInterface)localObject, paramString, 1);
      if (paramString != null) {
        ShortVideoBusiManager.a(paramString, (QQAppInterface)localObject);
      }
    }
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
              if (VideoFeedsIPCServer.a(this.a) != null)
              {
                if (FileTransferManager.a((QQAppInterface)localObject) != null) {
                  FileTransferManager.a((QQAppInterface)localObject).a(VideoFeedsIPCServer.a(this.a), null);
                }
                VideoFeedsIPCServer.a(this.a, null);
              }
              VideoFeedsIPCServer.a(this.a, null);
            }
            else if ("CMD_HANDLE_FORWARD_DATA".equals(paramString))
            {
              VideoFeedsHelper.a((QQAppInterface)localObject, paramBundle);
            }
            else if ("CMD_INIT_READINJOY_MANAGER".equals(paramString))
            {
              ((QQAppInterface)localObject).getManager(95);
            }
            else
            {
              if ("CMD_PUB_ACCOUNT_CHECK_IS_FOLLOWED".equals(paramString)) {
                try
                {
                  bool = VideoFeedsHelper.a((QQAppInterface)localObject, paramBundle.getLong("VALUE_PUB_ACCOUNT_UIN"));
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
                VideoFeedsHelper.a((QQAppInterface)localObject, paramBundle.getString("VALUE_PUB_ACCOUNT_UIN"), false);
              }
              else
              {
                if ("CMD_VOLUMECONTROL_INSTANCE_SHOULDMUTEINVIDEOFEEDS_GET".equals(paramString))
                {
                  paramBundle = new Bundle();
                  paramBundle.putBoolean("VOLUMECONTROL_INSTANCE_SHOULDMUTEINVIDEOFEEDS", VideoVolumeControl.a().a(false));
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.pubaccount.video.feeds.VideoFeedsIPCServer", 2, paramString + " shouldMuteInVideoFeed = " + VideoVolumeControl.a().a(false));
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
                  VideoVolumeControl.a().b(((Boolean)localObject).booleanValue());
                }
                else
                {
                  if ("CMD_IS_VIDEO_PLAY_NEED_ALERT_IN_XG".equals(paramString))
                  {
                    paramBundle = new Bundle();
                    paramBundle.putBoolean("VALUE_VIDEO_NEED_ALERT", VideoAutoPlayController.a(BaseApplicationImpl.getContext()).d());
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.pubaccount.video.feeds.VideoFeedsIPCServer", 2, paramString + " VALUE_VIDEO_NEED_ALERT = " + VideoAutoPlayController.a(BaseApplicationImpl.getContext()).d());
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
                    VideoAutoPlayController.a(BaseApplicationImpl.getContext()).b = ((Boolean)localObject).booleanValue();
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
                    VideoAutoPlayController.a(BaseApplicationImpl.getContext()).b(((Boolean)localObject).booleanValue());
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.pubaccount.video.feeds.VideoFeedsIPCServer", 2, paramString + " VALUE_NETWORK_CHANGE_IS_WIFI = " + localObject);
                    }
                  }
                  else if ("CMD_IGNORE_VOLUME_CHANGE".equals(paramString))
                  {
                    VideoVolumeControl.a().c(true);
                  }
                  else if ("CMD_CANCEL_IGNORE_VOLUME_CHANGE".equals(paramString))
                  {
                    VideoVolumeControl.a().c(false);
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
                    if ("CMD_CAMERA_CAPTURE_CHECK_SO_READY".equals(paramString))
                    {
                      paramString = new Bundle();
                      paramString.putBoolean("VALUE_CAMERA_CAPTURE_IS_SO_READY", Boolean.valueOf(ReadInJoyCameraCaptureHelper.a((QQAppInterface)localObject, BaseApplicationImpl.getContext())).booleanValue());
                      return EIPCResult.createSuccessResult(paramString);
                    }
                    if ("CMD_CAMERA_CAPTURE_SO_DOWNLOAD".equals(paramString))
                    {
                      if (VideoFeedsIPCServer.a(this.a) == null) {
                        VideoFeedsIPCServer.a(this.a, new ReadInJoyCameraCaptureSoManager((QQAppInterface)localObject, BaseApplicationImpl.getContext()));
                      }
                      VideoFeedsIPCServer.a(this.a).a(new mcm(this));
                      VideoFeedsIPCServer.a(this.a).a();
                    }
                    else
                    {
                      if ("CMD_GET_NICK_NAME_BY_UIN".equals(paramString))
                      {
                        VideoFeedsIPCServer.a(this.a, new mcn(this, (QQAppInterface)localObject));
                        ((QQAppInterface)localObject).addObserver(VideoFeedsIPCServer.a(this.a));
                        paramString = new Bundle();
                        paramString.putString("VALUE_USER_NICK_NAME", ContactUtils.b((QQAppInterface)localObject, paramBundle.getString("VALUE_USER_UIN_TO_GET_NICK_NAME"), true));
                        return EIPCResult.createSuccessResult(paramString);
                      }
                      if ("CMD_GET_NICK_NAME_BY_UIN_CANCLE".equals(paramString))
                      {
                        ((QQAppInterface)localObject).removeObserver(VideoFeedsIPCServer.a(this.a));
                      }
                      else if ("CMD_REPORT_START_TIME".equals(paramString))
                      {
                        VideoFeedsStartStatistic.a(((QQAppInterface)localObject).getApplication().getApplicationContext());
                      }
                      else
                      {
                        if ("CMD_GET_CLICK_COMMENT_ACTICLEINFO".equals(paramString))
                        {
                          paramBundle = new Bundle();
                          paramBundle.putString("VALUE_CLICK_COMMENT_ACTICLEINFO", ReadInJoyWebDataManager.a().b());
                          if (QLog.isColorLevel()) {
                            QLog.d("Q.pubaccount.video.feeds.VideoFeedsIPCServer", 2, paramString + " VALUE_CLICK_COMMENT_ACTICLEINFO = " + ReadInJoyWebDataManager.a().b());
                          }
                          return EIPCResult.createSuccessResult(paramBundle);
                        }
                        if ("CMD_GET_UNREAD_MESSAGE_BOX_DATA".equals(paramString))
                        {
                          if (!ReadInJoyWebDataManager.a().a().isEmpty())
                          {
                            paramBundle = ReadInJoyWebDataManager.a().a();
                            localObject = new Bundle();
                            ((Bundle)localObject).putString("VALUE_UNREAD_MESSAGE_BOX_DATA", paramBundle);
                            if (QLog.isColorLevel()) {
                              QLog.d("Q.pubaccount.video.feeds.VideoFeedsIPCServer", 2, paramString + " VALUE_CLICK_COMMENT_ACTICLEINFO = " + paramBundle);
                            }
                            return EIPCResult.createSuccessResult((Bundle)localObject);
                          }
                        }
                        else
                        {
                          if ("CMD_GET_VIDEO_LATEST_BRIGHTNESS".equals(paramString))
                          {
                            paramString = new Bundle();
                            paramString.putFloat("VALUE_VIDEO_LATEST_BRIGHTNESS", VideoBrightnessControl.a().a());
                            return EIPCResult.createSuccessResult(paramString);
                          }
                          if (!"CMD_SET_VIDEO_LATEST_BRIGHTNESS".equals(paramString)) {
                            break;
                          }
                          float f = paramBundle.getFloat("VALUE_VIDEO_LATEST_BRIGHTNESS", -1.0F);
                          VideoBrightnessControl.a().a(f);
                        }
                      }
                    }
                  }
                }
              }
            }
          }
          if (!"CMD_GET_WEB_RENDER_DATA".equals(paramString)) {
            break;
          }
          paramString = paramBundle.getString("bundle_params_render_url");
        } while (TextUtils.isEmpty(paramString));
        paramString = ReadInJoyWebRenderEngine.a(paramString);
      } while (paramString == null);
      paramBundle = new Bundle();
      paramBundle.putString("VALUE_WEB_RENDER_DATA", paramString.a);
      return EIPCResult.createSuccessResult(paramBundle);
      if ("CMD_GET_REPORT_KANDIAN_MODE".equals(paramString))
      {
        paramInt = ReadInJoyUtils.e();
        paramString = new Bundle();
        paramString.putInt("VALUE_REPORT_KANDIAN_MODE", paramInt);
        return EIPCResult.createSuccessResult(paramString);
      }
    } while (!"CMD_GET_REPORT_KANDIAN_MODE_NEW".equals(paramString));
    paramInt = VideoReporter.a();
    paramString = new Bundle();
    paramString.putInt("VALUE_REPORT_KANDIAN_MODE_NEW", paramInt);
    return EIPCResult.createSuccessResult(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mck
 * JD-Core Version:    0.7.0.1
 */