import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class sgw
  extends CardObserver
{
  public sgw(ChatSettingActivity paramChatSettingActivity) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Card)) {}
    for (paramObject = (Card)paramObject;; paramObject = null)
    {
      if ((paramBoolean) && (paramObject != null))
      {
        if ((ChatSettingActivity.a(this.a) == 0) && (ChatSettingActivity.b(this.a).equals(paramObject.uin)))
        {
          String str = ContactUtils.a(this.a.app, ChatSettingActivity.b(this.a));
          if ((!TextUtils.isEmpty(str)) && (!str.equals(ChatSettingActivity.f(this.a)))) {
            ChatSettingActivity.c(this.a, str);
          }
        }
        if ((this.a.f != null) && (!TextUtils.isEmpty(ChatSettingActivity.b(this.a))) && (ChatSettingActivity.b(this.a).equals(paramObject.uin))) {
          ChatSettingActivity.a(this.a, ChatSettingActivity.a(this.a, ChatSettingActivity.b(this.a)), this.a.f);
        }
      }
      return;
    }
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (this.a.b != null) && (paramBoolean2 != this.a.b.a()))
    {
      this.a.b.setOnCheckedChangeListener(null);
      this.a.b.setChecked(paramBoolean2);
      this.a.b.setOnCheckedChangeListener(this.a);
    }
  }
  
  protected void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (this.a.b != null) && (paramBoolean2 != this.a.b.a()))
    {
      this.a.b.setOnCheckedChangeListener(null);
      this.a.b.setChecked(paramBoolean2);
      this.a.b.setOnCheckedChangeListener(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sgw
 * JD-Core Version:    0.7.0.1
 */