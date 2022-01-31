import android.os.Bundle;
import android.widget.EditText;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverVideoActivity;

public class qew
  extends osm
{
  public qew(ReadInJoyDeliverVideoActivity paramReadInJoyDeliverVideoActivity) {}
  
  public void a(int paramInt, qbj paramqbj)
  {
    if ((paramInt == 0) && (ReadInJoyDeliverVideoActivity.a(this.a)))
    {
      ReadInJoyDeliverVideoActivity.a(this.a, new Bundle());
      ReadInJoyDeliverVideoActivity.a(this.a).putString("arg_video_cover_url", paramqbj.h);
      ReadInJoyDeliverVideoActivity.a(this.a).putString("arg_video_url", paramqbj.g);
      ReadInJoyDeliverVideoActivity.a(this.a).putString("arg_video_title", paramqbj.jdField_d_of_type_JavaLangString);
      ReadInJoyDeliverVideoActivity.a(this.a).putString("arg_video_uuid", paramqbj.f);
      ReadInJoyDeliverVideoActivity.a(this.a).putLong("arg_video_duration", paramqbj.jdField_a_of_type_Long);
      ReadInJoyDeliverVideoActivity.a(this.a).putInt("arg_video_cover_width", paramqbj.c);
      ReadInJoyDeliverVideoActivity.a(this.a).putInt("arg_video_cover_height", paramqbj.jdField_b_of_type_Int);
      ReadInJoyDeliverVideoActivity.a(this.a).putInt("arg_video_width", paramqbj.e);
      ReadInJoyDeliverVideoActivity.a(this.a).putInt("arg_video_height", paramqbj.jdField_d_of_type_Int);
      ReadInJoyDeliverVideoActivity.a(this.a).putString("arg_topic_id", paramqbj.jdField_a_of_type_Int + "");
      ReadInJoyDeliverVideoActivity.a(this.a).setHint("#" + paramqbj.jdField_a_of_type_JavaLangString + "#");
      ReadInJoyDeliverVideoActivity.a(this.a, paramqbj.jdField_b_of_type_JavaLangString);
      ReadInJoyDeliverVideoActivity.a(this.a, true);
      ReadInJoyDeliverVideoActivity.a(this.a, paramqbj.h);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qew
 * JD-Core Version:    0.7.0.1
 */