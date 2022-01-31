import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.dataline.util.DatalineSessionAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.statistics.ReportController;

public class dc
  extends ClickableSpan
{
  public dc(DatalineSessionAdapter paramDatalineSessionAdapter) {}
  
  public void onClick(View paramView)
  {
    FileManagerUtil.a(DatalineSessionAdapter.a(this.a), DatalineSessionAdapter.a(this.a).getCurrentAccountUin(), "我的电脑", "我的电脑");
    ReportController.b(DatalineSessionAdapter.a(this.a), "CliOper", "", "", "0X800513D", "0X800513D", 0, 0, "", "", "", "");
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(Color.parseColor("#00a5e0"));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     dc
 * JD-Core Version:    0.7.0.1
 */