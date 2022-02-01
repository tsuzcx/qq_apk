import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;

public class ojq
  implements asmr
{
  public ojq(ReadInJoyBaseDeliverActivity paramReadInJoyBaseDeliverActivity) {}
  
  public void a(asmu paramasmu)
  {
    if ((paramasmu instanceof asre))
    {
      paramasmu = (asre)paramasmu;
      if ((this.a instanceof ReadInJoyDeliverUGCActivity)) {
        ((ReadInJoyDeliverUGCActivity)this.a).a(paramasmu);
      }
      return;
    }
    ReadInJoyBaseDeliverActivity.a(this.a.app, paramasmu, this.a.a);
  }
  
  public void a(asmu paramasmu1, asmu paramasmu2, Drawable paramDrawable) {}
  
  public boolean a(asmu paramasmu)
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
  
  public void b(asmu paramasmu) {}
  
  public void c() {}
  
  public void d() {}
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ojq
 * JD-Core Version:    0.7.0.1
 */