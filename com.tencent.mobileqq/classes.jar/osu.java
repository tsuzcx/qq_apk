import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public final class osu
  implements Runnable
{
  public osu(Context paramContext) {}
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.a, 230);
    localQQCustomDialog.setMessage("存储空间不足，请清理缓存后重试");
    localQQCustomDialog.setNegativeButton("取消", new osv(this));
    localQQCustomDialog.setPositiveButton("清理缓存", new osw(this));
    localQQCustomDialog.setCancelable(false);
    localQQCustomDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    localQQCustomDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     osu
 * JD-Core Version:    0.7.0.1
 */