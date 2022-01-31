import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;

public class sjj
  implements TabBarView.OnTabChangeListener
{
  public sjj(EmosmActivity paramEmosmActivity) {}
  
  public void onTabSelected(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    if (paramInt2 == 0) {
      this.a.b = 1;
    }
    for (;;)
    {
      this.a.c = false;
      this.a.runOnUiThread(this.a.a);
      return;
      if (paramInt2 == 1) {
        this.a.b = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sjj
 * JD-Core Version:    0.7.0.1
 */