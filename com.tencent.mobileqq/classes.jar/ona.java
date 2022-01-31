import android.os.Bundle;
import com.tencent.biz.ProtoUtils.StoryProtocolObserver;
import com.tencent.biz.qqstory.network.pb.qqstory_group.RspGroupVideoDelete;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.biz.qqstory.troop.TroopStoryManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;

public class ona
  extends ProtoUtils.StoryProtocolObserver
{
  public ona(TroopStoryManager paramTroopStoryManager) {}
  
  public qqstory_struct.ErrorInfo a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.troopstory.TroopStoryManager", 2, "troop story revoke result, code=" + paramInt);
    }
    if ((paramInt == 0) && (paramArrayOfByte != null)) {
      try
      {
        paramBundle = new qqstory_group.RspGroupVideoDelete();
        paramBundle.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = (qqstory_struct.ErrorInfo)paramBundle.result.get();
        if (paramArrayOfByte.error_code.has()) {
          QLog.d("Q.qqstory.troopstory.TroopStoryManager", 2, "revoke rsp.result.error_code=" + paramArrayOfByte.error_code.get());
        }
        return paramArrayOfByte;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.troopstory.TroopStoryManager", 2, "parse RspGroupVideoDelete error", paramArrayOfByte);
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ona
 * JD-Core Version:    0.7.0.1
 */