import android.widget.Button;
import android.widget.TextView;
import com.tencent.av.app.SessionInfo.HeroDetail;
import com.tencent.av.guild.GameHeroesUi;

public class jji
  implements Runnable
{
  public jji(GameHeroesUi paramGameHeroesUi) {}
  
  public void run()
  {
    if ((this.a.a != null) && (this.a.a.a > 0))
    {
      this.a.f();
      this.a.e();
      if (this.a.b)
      {
        this.a.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
        this.a.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
    else
    {
      return;
    }
    this.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jji
 * JD-Core Version:    0.7.0.1
 */