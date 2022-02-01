import android.os.Bundle;
import android.widget.EditText;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverVideoActivity;

public class rat
  extends pfh
{
  public rat(ReadInJoyDeliverVideoActivity paramReadInJoyDeliverVideoActivity) {}
  
  public void a(int paramInt, qwk paramqwk)
  {
    if ((paramInt == 0) && (ReadInJoyDeliverVideoActivity.a(this.a)))
    {
      ReadInJoyDeliverVideoActivity.a(this.a, new Bundle());
      ReadInJoyDeliverVideoActivity.a(this.a).putString("arg_video_cover_url", paramqwk.h);
      ReadInJoyDeliverVideoActivity.a(this.a).putString("arg_video_url", paramqwk.g);
      ReadInJoyDeliverVideoActivity.a(this.a).putString("arg_video_title", paramqwk.jdField_d_of_type_JavaLangString);
      ReadInJoyDeliverVideoActivity.a(this.a).putString("arg_video_uuid", paramqwk.f);
      ReadInJoyDeliverVideoActivity.a(this.a).putLong("arg_video_duration", paramqwk.jdField_a_of_type_Long);
      ReadInJoyDeliverVideoActivity.a(this.a).putInt("arg_video_cover_width", paramqwk.c);
      ReadInJoyDeliverVideoActivity.a(this.a).putInt("arg_video_cover_height", paramqwk.jdField_b_of_type_Int);
      ReadInJoyDeliverVideoActivity.a(this.a).putInt("arg_video_width", paramqwk.e);
      ReadInJoyDeliverVideoActivity.a(this.a).putInt("arg_video_height", paramqwk.jdField_d_of_type_Int);
      ReadInJoyDeliverVideoActivity.a(this.a).putString("arg_topic_id", paramqwk.jdField_a_of_type_Int + "");
      ReadInJoyDeliverVideoActivity.a(this.a).setHint("#" + paramqwk.jdField_a_of_type_JavaLangString + "#");
      ReadInJoyDeliverVideoActivity.a(this.a, paramqwk.jdField_b_of_type_JavaLangString);
      ReadInJoyDeliverVideoActivity.a(this.a, true);
      ReadInJoyDeliverVideoActivity.a(this.a, paramqwk.h);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rat
 * JD-Core Version:    0.7.0.1
 */