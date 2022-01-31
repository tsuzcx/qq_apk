import android.os.Bundle;
import android.widget.EditText;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverVideoActivity;

public class qpc
  extends oxe
{
  public qpc(ReadInJoyDeliverVideoActivity paramReadInJoyDeliverVideoActivity) {}
  
  public void a(int paramInt, qlf paramqlf)
  {
    if ((paramInt == 0) && (ReadInJoyDeliverVideoActivity.a(this.a)))
    {
      ReadInJoyDeliverVideoActivity.a(this.a, new Bundle());
      ReadInJoyDeliverVideoActivity.a(this.a).putString("arg_video_cover_url", paramqlf.h);
      ReadInJoyDeliverVideoActivity.a(this.a).putString("arg_video_url", paramqlf.g);
      ReadInJoyDeliverVideoActivity.a(this.a).putString("arg_video_title", paramqlf.jdField_d_of_type_JavaLangString);
      ReadInJoyDeliverVideoActivity.a(this.a).putString("arg_video_uuid", paramqlf.f);
      ReadInJoyDeliverVideoActivity.a(this.a).putLong("arg_video_duration", paramqlf.jdField_a_of_type_Long);
      ReadInJoyDeliverVideoActivity.a(this.a).putInt("arg_video_cover_width", paramqlf.c);
      ReadInJoyDeliverVideoActivity.a(this.a).putInt("arg_video_cover_height", paramqlf.jdField_b_of_type_Int);
      ReadInJoyDeliverVideoActivity.a(this.a).putInt("arg_video_width", paramqlf.e);
      ReadInJoyDeliverVideoActivity.a(this.a).putInt("arg_video_height", paramqlf.jdField_d_of_type_Int);
      ReadInJoyDeliverVideoActivity.a(this.a).putString("arg_topic_id", paramqlf.jdField_a_of_type_Int + "");
      ReadInJoyDeliverVideoActivity.a(this.a).setHint("#" + paramqlf.jdField_a_of_type_JavaLangString + "#");
      ReadInJoyDeliverVideoActivity.a(this.a, paramqlf.jdField_b_of_type_JavaLangString);
      ReadInJoyDeliverVideoActivity.a(this.a, true);
      ReadInJoyDeliverVideoActivity.a(this.a, paramqlf.h);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qpc
 * JD-Core Version:    0.7.0.1
 */