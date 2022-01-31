import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqStorySubmitPollData;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspStorySubmitPollData;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;

public class syi
  implements slx<szf<qqstory_service.ReqStorySubmitPollData>, tbd>
{
  public static final String a;
  public int a;
  public String b;
  public String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = skt.a("StorySvc.submit_poll_data");
  }
  
  syi(String paramString1, String paramString2, int paramInt)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.c = paramString2;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a()
  {
    urk.a("Q.qqstory.pollData.SendVidPollDataHandler", "sendRequest() feed=%s, poll=%s, index=%d", this.jdField_b_of_type_JavaLangString, this.c, Integer.valueOf(this.jdField_a_of_type_Int));
    Object localObject = new qqstory_service.ReqStorySubmitPollData();
    ((qqstory_service.ReqStorySubmitPollData)localObject).vid.set(ByteStringMicro.copyFromUtf8(this.c));
    ((qqstory_service.ReqStorySubmitPollData)localObject).poll_data.set(this.jdField_a_of_type_Int);
    localObject = new szf(jdField_a_of_type_JavaLangString, (MessageMicro)localObject, null);
    slv.a().a((slz)localObject, this);
  }
  
  public static void a(@Nullable String paramString1, String paramString2, int paramInt)
  {
    new syi(paramString1, paramString2, paramInt).a();
  }
  
  public void a(@NonNull szf<qqstory_service.ReqStorySubmitPollData> paramszf, @Nullable tbd paramtbd, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramtbd == null))
    {
      urk.c("Q.qqstory.pollData.SendVidPollDataHandler", "onCmdRespond Request Error:%s", paramErrorMessage);
      return;
    }
    paramszf = new qqstory_service.RspStorySubmitPollData();
    StoryVideoItem localStoryVideoItem;
    try
    {
      paramszf.mergeFrom(paramtbd.a);
      paramtbd = new syj();
      paramtbd.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage(paramszf.result.error_code.get(), paramszf.result.error_desc.get().toStringUtf8());
      paramtbd.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      paramtbd.jdField_b_of_type_JavaLangString = this.c;
      paramtbd.jdField_a_of_type_Int = paramszf.comment_id.get();
      paramtbd.jdField_a_of_type_Long = paramszf.fake_id.get();
      paramtbd.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
      paramtbd.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramszf.video_poll_result.get());
      int j = paramtbd.jdField_a_of_type_JavaUtilArrayList.size();
      paramErrorMessage = (sqd)sqg.a(5);
      localStoryVideoItem = paramErrorMessage.a(this.c);
      urk.a("Q.qqstory.pollData.SendVidPollDataHandler", "onCmdRespond() feed=%s, vid=%s, index=%d", this.jdField_b_of_type_JavaLangString, this.c, Integer.valueOf(paramtbd.jdField_b_of_type_Int));
      if ((localStoryVideoItem == null) || (j <= 0)) {
        break label302;
      }
      if ((localStoryVideoItem.mPollNumbers == null) || (localStoryVideoItem.mPollNumbers.length != j)) {
        localStoryVideoItem.mPollNumbers = new int[j];
      }
      int i = 0;
      while (i < j)
      {
        localStoryVideoItem.mPollNumbers[i] = ((Integer)paramszf.video_poll_result.get(i)).intValue();
        i += 1;
      }
      localStoryVideoItem.mPollResult = this.jdField_a_of_type_Int;
    }
    catch (InvalidProtocolBufferMicroException paramszf)
    {
      paramszf.printStackTrace();
      urk.c("Q.qqstory.pollData.SendVidPollDataHandler", "onCmdRespond Request parse Error:%s", paramszf);
      return;
    }
    paramErrorMessage.a(localStoryVideoItem);
    label302:
    sgi.a().dispatch(paramtbd);
    vml.a(QQStoryContext.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     syi
 * JD-Core Version:    0.7.0.1
 */