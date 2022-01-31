import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;

public class rji
  extends amgq
{
  public rji(FastWebActivity paramFastWebActivity) {}
  
  public void onAddColorNote(Bundle paramBundle, boolean paramBoolean)
  {
    super.onAddColorNote(paramBundle, paramBoolean);
    rno.a(FastWebActivity.a(this.a), FastWebActivity.a(this.a), this.a.getApplicationContext());
    if (paramBundle.getInt("color_note_curd_from_type") != 1) {
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rji
 * JD-Core Version:    0.7.0.1
 */