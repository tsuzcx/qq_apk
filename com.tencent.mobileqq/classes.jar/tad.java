import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

class tad
  extends almg
{
  tad(tac paramtac) {}
  
  protected void a(boolean paramBoolean, Long paramLong, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(tac.a(this.a))))
    {
      paramLong = BaseApplicationImpl.getApplication().getBaseContext();
      if (paramBoolean) {
        QQToast.a(BaseApplicationImpl.getApplication(), 2, 2131719756, 0).b(paramLong.getResources().getDimensionPixelSize(2131298914));
      }
    }
    else
    {
      return;
    }
    QQToast.a(BaseApplicationImpl.getApplication(), 1, 2131719743, 0).b(paramLong.getResources().getDimensionPixelSize(2131298914));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tad
 * JD-Core Version:    0.7.0.1
 */