import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class seb
  extends BizTroopObserver
{
  public seb(Conversation paramConversation) {}
  
  public void a(int paramInt1, int paramInt2, Map paramMap, String paramString)
  {
    paramString = this.a.a();
    String str1 = this.a.a.getCurrentAccountUin();
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      Iterator localIterator = paramMap.keySet().iterator();
      paramInt1 = 0;
      if (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        paramInt2 = ((Integer)paramMap.get(str2)).intValue();
        if (paramInt2 == 4000) {
          SharedPreUtils.k(paramString, str1, str2);
        }
      }
    }
    for (;;)
    {
      break;
      if (paramInt2 != 0)
      {
        paramInt1 = 1;
        continue;
        if (paramInt1 == 0) {
          SharedPreUtils.m(this.a.a(), this.a.a.getCurrentAccountUin());
        }
        return;
      }
    }
  }
  
  protected void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (paramInt2 != 0)
    {
      paramString1 = paramString2;
      if (!this.a.a().isFinishing())
      {
        paramString1 = paramString2;
        if (Conversation.a(this.a))
        {
          paramString1 = paramString2;
          if (TextUtils.isEmpty(paramString2)) {
            paramString1 = this.a.a().getString(2131435563);
          }
          QQToast.a(this.a.a(), 1, paramString1, 0).a();
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "onSetCommonUsedTroop, retCode = " + paramInt2 + " , wording = " + paramString1);
      }
      return;
      this.a.a(9, paramString1, 1);
      paramString1 = paramString2;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null)) {
      this.a.a(8, paramString1, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     seb
 * JD-Core Version:    0.7.0.1
 */