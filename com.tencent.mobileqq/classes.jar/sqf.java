import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetPromoteTaskList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;

class sqf
  implements slx<taz, tba>
{
  sqf(sqe paramsqe) {}
  
  public void a(@NonNull taz paramtaz, @Nullable tba paramtba, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramtba == null) {
      urk.e("StoryPromoteTaskManager", "onCmdRespond() error: %s", new Object[] { paramtba });
    }
    do
    {
      return;
      if (paramErrorMessage.errorCode == 15000)
      {
        urk.a("StoryPromoteTaskManager", "onCmdRespond() no change of the request %s", paramtba);
        this.a.jdField_a_of_type_Long = paramtba.a.uint64_expire_time.get();
        return;
      }
      if (paramErrorMessage.isFail())
      {
        urk.e("StoryPromoteTaskManager", "onCmdRespond() error: %s", new Object[] { paramtba });
        return;
      }
    } while (this.a.jdField_a_of_type_Boolean);
    this.a.jdField_a_of_type_JavaLangString = paramtba.a.bytes_cookie.get().toStringUtf8();
    this.a.jdField_a_of_type_Long = paramtba.a.uint64_expire_time.get();
    this.a.a();
    this.a.a(paramtba.a);
    paramtaz = paramtba.a.bytes_global_promote_url.get().toStringUtf8();
    if (!TextUtils.isEmpty(paramtaz))
    {
      ((spz)sqg.a(10)).b("key_story_player_promote_url", paramtaz);
      this.a.b = paramtaz;
    }
    this.a.a("onCmdRespond()");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sqf
 * JD-Core Version:    0.7.0.1
 */