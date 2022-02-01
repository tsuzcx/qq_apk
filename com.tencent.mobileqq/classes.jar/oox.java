import android.content.Context;
import android.content.Intent;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.ecshopassit.view.CustomTabView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class oox
  implements ooy
{
  private CustomTabView a;
  
  public void a(Context paramContext)
  {
    if (paramContext != null) {
      paramContext.sendBroadcast(new Intent("com.tencent.biz.pubaccount.ecshop.tabpage.finish"));
    }
    if (this.a != null) {
      this.a.a();
    }
  }
  
  public void a(MessageRecord paramMessageRecord) {}
  
  public void a(List<ChatMessage> paramList, ooz paramooz)
  {
    if (paramList.size() > 0)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        ChatMessage localChatMessage = (ChatMessage)localIterator.next();
        localChatMessage.removeExtInfoToExtStr("add_title");
        if (opg.a(localChatMessage) == 1) {
          localIterator.remove();
        }
      }
    }
    if (paramooz != null) {
      paramooz.a(paramList);
    }
  }
  
  public boolean a(Context paramContext, RelativeLayout paramRelativeLayout)
  {
    opa localopa = opd.a();
    if (ope.a(localopa))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EcshopMinusViewChatPie", 2, "initPublicAccountMenu new qqshop pubaccount return");
      }
      this.a = new CustomTabView(paramContext);
      if (this.a.a(localopa))
      {
        this.a.setTag("echopCustomTabView");
        this.a.a(1);
        paramRelativeLayout.addView(this.a);
        paramContext = (RelativeLayout.LayoutParams)this.a.getLayoutParams();
        if (paramContext != null)
        {
          paramContext.width = -1;
          paramContext.height = -2;
          paramContext.addRule(12);
        }
        paramContext = opi.a();
        opi.a(paramContext);
        this.a.a(paramContext);
        return true;
      }
    }
    return false;
  }
  
  public boolean a(RelativeLayout paramRelativeLayout)
  {
    return (ope.a()) && (paramRelativeLayout != null) && (paramRelativeLayout.findViewWithTag("echopCustomTabView") != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oox
 * JD-Core Version:    0.7.0.1
 */