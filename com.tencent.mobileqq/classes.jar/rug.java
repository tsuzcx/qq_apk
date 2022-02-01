import android.os.Bundle;
import android.widget.EditText;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverVideoActivity;

public class rug
  extends pvq
{
  public rug(ReadInJoyDeliverVideoActivity paramReadInJoyDeliverVideoActivity) {}
  
  public void a(int paramInt, rpo paramrpo)
  {
    if ((paramInt == 0) && (ReadInJoyDeliverVideoActivity.a(this.a)))
    {
      ReadInJoyDeliverVideoActivity.a(this.a, new Bundle());
      ReadInJoyDeliverVideoActivity.a(this.a).putString("arg_video_cover_url", paramrpo.h);
      ReadInJoyDeliverVideoActivity.a(this.a).putString("arg_video_url", paramrpo.g);
      ReadInJoyDeliverVideoActivity.a(this.a).putString("arg_video_title", paramrpo.jdField_d_of_type_JavaLangString);
      ReadInJoyDeliverVideoActivity.a(this.a).putString("arg_video_uuid", paramrpo.f);
      ReadInJoyDeliverVideoActivity.a(this.a).putLong("arg_video_duration", paramrpo.jdField_a_of_type_Long);
      ReadInJoyDeliverVideoActivity.a(this.a).putInt("arg_video_cover_width", paramrpo.c);
      ReadInJoyDeliverVideoActivity.a(this.a).putInt("arg_video_cover_height", paramrpo.jdField_b_of_type_Int);
      ReadInJoyDeliverVideoActivity.a(this.a).putInt("arg_video_width", paramrpo.e);
      ReadInJoyDeliverVideoActivity.a(this.a).putInt("arg_video_height", paramrpo.jdField_d_of_type_Int);
      ReadInJoyDeliverVideoActivity.a(this.a).putString("arg_topic_id", paramrpo.jdField_a_of_type_Int + "");
      ReadInJoyDeliverVideoActivity.a(this.a).setHint("#" + paramrpo.jdField_a_of_type_JavaLangString + "#");
      ReadInJoyDeliverVideoActivity.a(this.a, paramrpo.jdField_b_of_type_JavaLangString);
      ReadInJoyDeliverVideoActivity.a(this.a, true);
      ReadInJoyDeliverVideoActivity.a(this.a, paramrpo.h);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rug
 * JD-Core Version:    0.7.0.1
 */