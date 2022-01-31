import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetPromoteTaskList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;

class tcy
  implements syq<tns, tnt>
{
  tcy(tcx paramtcx) {}
  
  public void a(@NonNull tns paramtns, @Nullable tnt paramtnt, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramtnt == null) {
      ved.e("StoryPromoteTaskManager", "onCmdRespond() error: %s", new Object[] { paramtnt });
    }
    do
    {
      return;
      if (paramErrorMessage.errorCode == 15000)
      {
        ved.a("StoryPromoteTaskManager", "onCmdRespond() no change of the request %s", paramtnt);
        this.a.jdField_a_of_type_Long = paramtnt.a.uint64_expire_time.get();
        return;
      }
      if (paramErrorMessage.isFail())
      {
        ved.e("StoryPromoteTaskManager", "onCmdRespond() error: %s", new Object[] { paramtnt });
        return;
      }
    } while (this.a.jdField_a_of_type_Boolean);
    this.a.jdField_a_of_type_JavaLangString = paramtnt.a.bytes_cookie.get().toStringUtf8();
    this.a.jdField_a_of_type_Long = paramtnt.a.uint64_expire_time.get();
    this.a.a();
    this.a.a(paramtnt.a);
    paramtns = paramtnt.a.bytes_global_promote_url.get().toStringUtf8();
    if (!TextUtils.isEmpty(paramtns))
    {
      ((tcs)tcz.a(10)).b("key_story_player_promote_url", paramtns);
      this.a.b = paramtns;
    }
    this.a.a("onCmdRespond()");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tcy
 * JD-Core Version:    0.7.0.1
 */