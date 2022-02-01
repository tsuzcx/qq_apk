package cooperation.qqfav;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;

class QfavBuilder$1
  implements Runnable
{
  QfavBuilder$1(QfavBuilder paramQfavBuilder, Context paramContext, QQAppInterface paramQQAppInterface, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    QfavHelper.a(this.a, this.b.getAccount(), this.c, this.d, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqfav.QfavBuilder.1
 * JD-Core Version:    0.7.0.1
 */