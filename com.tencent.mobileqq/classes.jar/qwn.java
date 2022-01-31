import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;

public class qwn
  extends alry
{
  public qwn(FastWebActivity paramFastWebActivity) {}
  
  public void onAddColorNote(Bundle paramBundle, boolean paramBoolean)
  {
    super.onAddColorNote(paramBundle, paramBoolean);
    raz.a(FastWebActivity.a(this.a), FastWebActivity.a(this.a), this.a.getApplicationContext());
    if (paramBundle.getInt("color_note_curd_from_type") != 1) {
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qwn
 * JD-Core Version:    0.7.0.1
 */