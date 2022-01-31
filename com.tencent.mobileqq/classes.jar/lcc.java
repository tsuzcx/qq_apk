import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;

public class lcc
  implements EmoticonCallback
{
  public lcc(ReadInJoyBaseDeliverActivity paramReadInJoyBaseDeliverActivity) {}
  
  public void a(EmoticonInfo paramEmoticonInfo)
  {
    if ((paramEmoticonInfo instanceof PicEmoticonInfo))
    {
      paramEmoticonInfo = (PicEmoticonInfo)paramEmoticonInfo;
      if ((this.a instanceof ReadInJoyDeliverUGCActivity)) {
        ((ReadInJoyDeliverUGCActivity)this.a).a(paramEmoticonInfo);
      }
      return;
    }
    ReadInJoyBaseDeliverActivity.a(paramEmoticonInfo, this.a.a);
  }
  
  public void a(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable) {}
  
  public boolean a(EmoticonInfo paramEmoticonInfo)
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
  
  public void b(EmoticonInfo paramEmoticonInfo) {}
  
  public void c() {}
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lcc
 * JD-Core Version:    0.7.0.1
 */