import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.video.VideoUploadManager;
import com.tencent.biz.qqstory.network.pb.qqstory_bhd_upload_pic.RspStoryVideo;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import java.util.HashMap;

public class mgb
  extends TransProcessorHandler
{
  public mgb(VideoUploadManager paramVideoUploadManager) {}
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject = (FileMsg)paramMessage.obj;
    if ((localObject == null) || ((((FileMsg)localObject).jdField_b_of_type_Int != 24) && (((FileMsg)localObject).jdField_b_of_type_Int != 32))) {}
    while ((((FileMsg)localObject).jdField_b_of_type_Int == 24) && (((FileMsg)localObject).c != 54)) {
      return;
    }
    switch (paramMessage.what)
    {
    case 1001: 
    case 1002: 
    case 1004: 
    case 1005: 
    case 2001: 
    case 2003: 
    default: 
      return;
    }
    paramMessage = (Bundle)this.a.b.remove(Long.valueOf(((FileMsg)localObject).jdField_b_of_type_Long));
    paramMessage.putLong("uniseq", ((FileMsg)localObject).jdField_b_of_type_Long);
    paramMessage.putString("pic_server_id", ((FileMsg)localObject).i);
    qqstory_bhd_upload_pic.RspStoryVideo localRspStoryVideo = new qqstory_bhd_upload_pic.RspStoryVideo();
    try
    {
      localRspStoryVideo.mergeFrom(((FileMsg)localObject).a);
      if (localRspStoryVideo.retcode.get() == 0)
      {
        localObject = localRspStoryVideo.cdn_url.get().toStringUtf8();
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          paramMessage.putString("cdn_url", (String)localObject);
        }
      }
      label214:
      this.a.a.a(84, paramMessage);
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      break label214;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mgb
 * JD-Core Version:    0.7.0.1
 */