import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetPromoteTaskList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;

class tdb
  implements syt<tnv, tnw>
{
  tdb(tda paramtda) {}
  
  public void a(@NonNull tnv paramtnv, @Nullable tnw paramtnw, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramtnw == null) {
      veg.e("StoryPromoteTaskManager", "onCmdRespond() error: %s", new Object[] { paramtnw });
    }
    do
    {
      return;
      if (paramErrorMessage.errorCode == 15000)
      {
        veg.a("StoryPromoteTaskManager", "onCmdRespond() no change of the request %s", paramtnw);
        this.a.jdField_a_of_type_Long = paramtnw.a.uint64_expire_time.get();
        return;
      }
      if (paramErrorMessage.isFail())
      {
        veg.e("StoryPromoteTaskManager", "onCmdRespond() error: %s", new Object[] { paramtnw });
        return;
      }
    } while (this.a.jdField_a_of_type_Boolean);
    this.a.jdField_a_of_type_JavaLangString = paramtnw.a.bytes_cookie.get().toStringUtf8();
    this.a.jdField_a_of_type_Long = paramtnw.a.uint64_expire_time.get();
    this.a.a();
    this.a.a(paramtnw.a);
    paramtnv = paramtnw.a.bytes_global_promote_url.get().toStringUtf8();
    if (!TextUtils.isEmpty(paramtnv))
    {
      ((tcv)tdc.a(10)).b("key_story_player_promote_url", paramtnv);
      this.a.b = paramtnv;
    }
    this.a.a("onCmdRespond()");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tdb
 * JD-Core Version:    0.7.0.1
 */