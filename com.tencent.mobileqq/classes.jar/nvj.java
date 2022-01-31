import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;

public class nvj
  implements anyg
{
  public nvj(ReadInJoyBaseDeliverActivity paramReadInJoyBaseDeliverActivity) {}
  
  public void a(anyh paramanyh)
  {
    if ((paramanyh instanceof aobp))
    {
      paramanyh = (aobp)paramanyh;
      if ((this.a instanceof ReadInJoyDeliverUGCActivity)) {
        ((ReadInJoyDeliverUGCActivity)this.a).a(paramanyh);
      }
      return;
    }
    ReadInJoyBaseDeliverActivity.a(this.a.app, paramanyh, this.a.a);
  }
  
  public void a(anyh paramanyh1, anyh paramanyh2, Drawable paramDrawable) {}
  
  public boolean a(anyh paramanyh)
  {
    return true;
  }
  
  public void b()
  {
    if (this.a.a.getSelectionStart() == 0) {}
    for (;;)
    {
      return;
      try
      {
        Editable localEditable = this.a.a.getText();
        int i = this.a.a.getSelectionStart();
        int j = TextUtils.getOffsetBefore(this.a.a.getText(), i);
        if (i != j)
        {
          localEditable.delete(Math.min(i, j), Math.max(i, j));
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void b(anyh paramanyh) {}
  
  public void c() {}
  
  public void d() {}
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nvj
 * JD-Core Version:    0.7.0.1
 */