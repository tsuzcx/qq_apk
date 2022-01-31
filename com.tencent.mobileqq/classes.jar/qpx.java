import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.video.LikeAnimationInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0xb73.oidb_0xb73.LikeAnimationConfig;
import tencent.im.oidb.cmd0xb73.oidb_0xb73.LikeAnimationIconConfig;
import tencent.im.oidb.cmd0xb73.oidb_0xb73.ReqBody;
import tencent.im.oidb.cmd0xb73.oidb_0xb73.RspBody;

public class qpx
  extends ajtd
{
  private String a;
  
  public qpx(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new oidb_0xb73.RspBody();
    boolean bool;
    if (parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg) == 0)
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsLikeAnimateHandler", 2, "isSuccess: " + bool);
      }
      paramFromServiceMsg = new Bundle();
      if (!bool) {
        break label341;
      }
      if (!paramToServiceMsg.uint32_next_req_interval.has()) {
        break label350;
      }
    }
    label341:
    label350:
    for (int i = paramToServiceMsg.uint32_next_req_interval.get();; i = 0)
    {
      if ((paramToServiceMsg.bytes_cookie.has()) && (paramToServiceMsg.bytes_cookie.get() != null)) {
        this.a = paramToServiceMsg.bytes_cookie.get().toStringUtf8();
      }
      paramObject = new LikeAnimationInfo();
      paramObject.jdField_a_of_type_Int = i;
      if ((paramToServiceMsg.msg_like_animation_config.has()) && (paramToServiceMsg.msg_like_animation_config.get() != null) && (paramToServiceMsg.msg_like_animation_config.rpt_msg_icon_config_list.has()) && (paramToServiceMsg.msg_like_animation_config.rpt_msg_icon_config_list.get() != null))
      {
        paramToServiceMsg = paramToServiceMsg.msg_like_animation_config.rpt_msg_icon_config_list.get();
        paramObject.jdField_a_of_type_ArrayOfJavaLangString = new String[paramToServiceMsg.size()];
        i = 0;
        for (;;)
        {
          if (i < paramToServiceMsg.size())
          {
            oidb_0xb73.LikeAnimationIconConfig localLikeAnimationIconConfig = (oidb_0xb73.LikeAnimationIconConfig)paramToServiceMsg.get(i);
            if ((localLikeAnimationIconConfig.has()) && (localLikeAnimationIconConfig.get() != null) && (localLikeAnimationIconConfig.bytes_icon_url.has()) && (localLikeAnimationIconConfig.bytes_icon_url.get() != null)) {
              paramObject.jdField_a_of_type_ArrayOfJavaLangString[i] = localLikeAnimationIconConfig.bytes_icon_url.get().toStringUtf8();
            }
            i += 1;
            continue;
            bool = false;
            break;
          }
        }
        paramFromServiceMsg.putParcelable("key_like_animation_info", paramObject);
        if (QLog.isColorLevel()) {
          QLog.d("VideoFeedsLikeAnimateHandler", 2, "LikeAnimationInfo: " + paramObject.toString());
        }
      }
      notifyUI(0, bool, paramFromServiceMsg);
      return;
    }
  }
  
  public void a(int paramInt)
  {
    oidb_0xb73.ReqBody localReqBody = new oidb_0xb73.ReqBody();
    if (this.a != null) {
      localReqBody.bytes_cookie.set(ByteStringMicro.copyFromUtf8(this.a));
    }
    localReqBody.uint32_req_type.set(paramInt);
    sendPbReq(makeOIDBPkg("OidbSvc.0xb73", 2931, 0, localReqBody.toByteArray()));
  }
  
  protected Class<? extends ajtg> observerClass()
  {
    return qpz.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qpx
 * JD-Core Version:    0.7.0.1
 */