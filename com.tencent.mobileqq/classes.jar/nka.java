import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.hotpic.PublicAccountHotPicPanel;

public class nka
  implements bepj
{
  public nka(ReadInJoyBaseDeliverActivity paramReadInJoyBaseDeliverActivity) {}
  
  public View a(int paramInt)
  {
    EmoticonMainPanel localEmoticonMainPanel = null;
    if (paramInt == 3)
    {
      if (ReadInJoyBaseDeliverActivity.a(this.a) == null)
      {
        ReadInJoyBaseDeliverActivity.a(this.a, (EmoticonMainPanel)View.inflate(this.a, 2131493455, null));
        ReadInJoyBaseDeliverActivity.a(this.a).setCallBack(ReadInJoyBaseDeliverActivity.a(this.a));
        ReadInJoyBaseDeliverActivity.a(this.a).b = true;
        bool = this.a instanceof ReadInJoyDeliverBiuActivity;
        ReadInJoyBaseDeliverActivity.a(this.a).a(this.a.app, 99999, this.a, this.a.getTitleBarHeight(), null, null, bool);
        ReadInJoyBaseDeliverActivity.a(this.a).s();
      }
      localEmoticonMainPanel = ReadInJoyBaseDeliverActivity.a(this.a);
    }
    while (paramInt != 24)
    {
      boolean bool;
      return localEmoticonMainPanel;
    }
    if (ReadInJoyBaseDeliverActivity.a(this.a) == null)
    {
      ReadInJoyBaseDeliverActivity.a(this.a, (PublicAccountHotPicPanel)View.inflate(this.a, 2131493859, null));
      ReadInJoyBaseDeliverActivity.a(this.a).a(this.a.app, this.a, null, this.a.a);
      ReadInJoyBaseDeliverActivity.a(this.a).setPublicAccountGifListener(ReadInJoyBaseDeliverActivity.a(this.a));
    }
    return ReadInJoyBaseDeliverActivity.a(this.a);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    boolean bool;
    if ((paramInt1 == 24) && (ReadInJoyBaseDeliverActivity.a(this.a) != null)) {
      if (paramInt2 == 1)
      {
        bool = true;
        ReadInJoyBaseDeliverActivity.a(this.a).a(bool);
        label34:
        if (paramInt2 != 1) {
          break label82;
        }
        this.a.b(1);
      }
    }
    label82:
    do
    {
      return;
      bool = false;
      break;
      if ((paramInt2 != 24) || (ReadInJoyBaseDeliverActivity.a(this.a) == null)) {
        break label34;
      }
      ReadInJoyBaseDeliverActivity.a(this.a).f();
      break label34;
      if (paramInt2 == 3)
      {
        this.a.b(2);
        return;
      }
      if (paramInt2 == 0)
      {
        this.a.b(0);
        return;
      }
    } while (paramInt2 != 24);
    this.a.b(3);
  }
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  public void r() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nka
 * JD-Core Version:    0.7.0.1
 */