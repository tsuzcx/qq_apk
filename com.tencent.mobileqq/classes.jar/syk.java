import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqStorySubmitRateData;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspStorySubmitRateData;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tribe.async.dispatch.Dispatcher;

public class syk
  implements slx<szf<qqstory_service.ReqStorySubmitRateData>, tbd>
{
  public static final String a;
  public final int a;
  public final String b;
  public final String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = skt.a("StorySvc.submit_rate_data");
  }
  
  syk(String paramString1, String paramString2, int paramInt)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.c = paramString2;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a()
  {
    urk.a("Q.qqstory.pollData.SendVidRateDataHandler", "sendRequest() feed=%s, vid=%s, rate=%d", this.jdField_b_of_type_JavaLangString, this.c, Integer.valueOf(this.jdField_a_of_type_Int));
    Object localObject = new qqstory_service.ReqStorySubmitRateData();
    ((qqstory_service.ReqStorySubmitRateData)localObject).vid.set(ByteStringMicro.copyFromUtf8(this.c));
    ((qqstory_service.ReqStorySubmitRateData)localObject).rate_data.set(this.jdField_a_of_type_Int);
    localObject = new szf(jdField_a_of_type_JavaLangString, (MessageMicro)localObject, null);
    slv.a().a((slz)localObject, this);
  }
  
  public static void a(@Nullable String paramString1, String paramString2, int paramInt)
  {
    new syk(paramString1, paramString2, paramInt).a();
  }
  
  public void a(@NonNull szf<qqstory_service.ReqStorySubmitRateData> paramszf, @Nullable tbd paramtbd, @NonNull ErrorMessage paramErrorMessage)
  {
    int j = -1;
    paramszf = (sqd)sqg.a(5);
    StoryVideoItem localStoryVideoItem = paramszf.a(this.c);
    int i;
    long l;
    label57:
    syl localsyl;
    if (localStoryVideoItem != null)
    {
      i = localStoryVideoItem.mRateResult;
      if (localStoryVideoItem != null) {
        j = localStoryVideoItem.mTotalRateCount;
      }
      if (localStoryVideoItem == null) {
        break label205;
      }
      l = localStoryVideoItem.mTotalScore;
      localsyl = new syl();
      if ((!paramErrorMessage.isFail()) && (paramtbd != null)) {
        break label213;
      }
      urk.e("Q.qqstory.pollData.SendVidRateDataHandler", "onCmdRespond Request Error:%s", new Object[] { paramErrorMessage.toString() });
      localsyl.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      localsyl.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      localsyl.jdField_b_of_type_JavaLangString = this.c;
      localsyl.jdField_a_of_type_Int = i;
      localsyl.jdField_b_of_type_Int = j;
      localsyl.jdField_a_of_type_Long = l;
    }
    for (;;)
    {
      if (localStoryVideoItem != null)
      {
        localStoryVideoItem.mRateResult = localsyl.jdField_a_of_type_Int;
        localStoryVideoItem.mTotalRateCount = localsyl.jdField_b_of_type_Int;
        localStoryVideoItem.mTotalScore = localsyl.jdField_a_of_type_Long;
        paramszf.a(localStoryVideoItem);
      }
      sgi.a().dispatch(localsyl);
      vml.a(QQStoryContext.a());
      return;
      i = -1;
      break;
      label205:
      l = -1L;
      break label57;
      label213:
      paramErrorMessage = new qqstory_service.RspStorySubmitRateData();
      try
      {
        paramErrorMessage.mergeFrom(paramtbd.a);
        localsyl.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage(paramErrorMessage.result.error_code.get(), paramErrorMessage.result.error_desc.get().toStringUtf8());
        localsyl.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
        localsyl.jdField_b_of_type_JavaLangString = this.c;
        localsyl.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        localsyl.jdField_b_of_type_Int = paramErrorMessage.total_rate_count.get();
        localsyl.jdField_a_of_type_Long = paramErrorMessage.total_rate_score.get();
        localsyl.c = paramErrorMessage.comment_id.get();
        localsyl.jdField_b_of_type_Long = paramErrorMessage.fake_id.get();
        urk.b("Q.qqstory.pollData.SendVidRateDataHandler", "onCmdRespond() feed=%s, vid=%s, rate=%s, rateCount=%s, rateScore=%s, commentId=%s, commentFakeId=%s", new Object[] { this.jdField_b_of_type_JavaLangString, this.c, Integer.valueOf(localsyl.jdField_a_of_type_Int), Integer.valueOf(localsyl.jdField_b_of_type_Int), Long.valueOf(localsyl.jdField_a_of_type_Long), Integer.valueOf(localsyl.c), Long.valueOf(localsyl.jdField_b_of_type_Long) });
      }
      catch (InvalidProtocolBufferMicroException paramszf)
      {
        paramszf.printStackTrace();
        urk.c("Q.qqstory.pollData.SendVidRateDataHandler", "onCmdRespond Request parse Error!", paramszf);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     syk
 * JD-Core Version:    0.7.0.1
 */