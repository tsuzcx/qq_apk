import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;

public class rzf
  extends FriendListObserver
{
  public rzf(ChatSettingActivity paramChatSettingActivity) {}
  
  protected void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if (paramBoolean) {
      if ((ChatSettingActivity.a(this.a) == 0) && (ChatSettingActivity.b(this.a) != null) && (ChatSettingActivity.b(this.a).equals(paramString1)) && (paramString2 != null) && (!ChatSettingActivity.e(this.a).equals(paramString2)))
      {
        if ((ChatSettingActivity.a(this.a) != null) && (ChatSettingActivity.a(this.a).isShowing()) && (!this.a.isFinishing()))
        {
          ChatSettingActivity.a(this.a, 2131435762, 2);
          ChatSettingActivity.a(this.a).dismiss();
        }
        ChatSettingActivity.b(this.a, paramString2);
        ChatSettingActivity.b(this.a, paramString2);
        ChatSettingActivity.c(this.a, paramString2);
      }
    }
    while (ChatSettingActivity.a(this.a) != 0) {
      return;
    }
    if ((ChatSettingActivity.a(this.a) != null) && (ChatSettingActivity.a(this.a).isShowing()) && (!this.a.isFinishing())) {
      ChatSettingActivity.a(this.a).dismiss();
    }
    ChatSettingActivity.b(this.a, ChatSettingActivity.e(this.a));
  }
  
  protected void onSetGenralSettingsTroopFilter(boolean paramBoolean, Map paramMap) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (paramString != null) && (paramString.equals(ChatSettingActivity.b(this.a))) && (ChatSettingActivity.a(this.a) != null))
    {
      if ((ChatSettingActivity.a(this.a) == 1010) || (ChatSettingActivity.a(this.a) == 1001) || (ChatSettingActivity.a(this.a) == 10002))
      {
        paramString = FaceDrawable.a(this.a.app, 200, ChatSettingActivity.b(this.a), true);
        ChatSettingActivity.a(this.a, new WeakReference(paramString));
        ChatSettingActivity.a(this.a).setImageDrawable(paramString);
      }
    }
    else {
      return;
    }
    if (ChatSettingActivity.a(this.a) == 1006)
    {
      paramString = FaceDrawable.b(this.a.app, ChatSettingActivity.b(this.a), (byte)3);
      ChatSettingActivity.a(this.a).setImageDrawable(paramString);
      return;
    }
    paramString = FaceDrawable.a(this.a.app, 1, ChatSettingActivity.b(this.a));
    ChatSettingActivity.a(this.a, new WeakReference(paramString));
    ChatSettingActivity.a(this.a).setImageDrawable(paramString);
  }
  
  protected void onUpdateFriendShieldFlag(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    ChatSettingActivity.d(this.a);
    ChatSettingActivity.c(this.a);
    if (paramBoolean2) {
      if (!ChatSettingActivity.b(this.a).endsWith(paramLong + "")) {}
    }
    do
    {
      return;
      if (!TextUtils.isEmpty(paramString))
      {
        ChatSettingActivity.a(this.a, paramString, 1);
        return;
      }
    } while (!ChatSettingActivity.b(this.a).endsWith(paramLong + ""));
    if (paramBoolean1)
    {
      ChatSettingActivity.a(this.a, 2131434493, 1);
      return;
    }
    ChatSettingActivity.a(this.a, 2131434494, 1);
  }
  
  protected void onUpdateHotFriendLevel(boolean paramBoolean, ArrayList paramArrayList)
  {
    super.onUpdateHotFriendLevel(paramBoolean, paramArrayList);
    if ((ChatSettingActivity.a(this.a) == 0) && (paramBoolean) && (paramArrayList != null) && (paramArrayList.contains(ChatSettingActivity.b(this.a))))
    {
      if (QLog.isColorLevel()) {
        QLog.d(ChatSettingActivity.a(this.a), 2, "onUpdateHotFriendLevel");
      }
      this.a.b();
    }
  }
  
  protected void onUpdateMobileQQHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (paramString != null) && (ChatSettingActivity.a(this.a) != null) && (ChatSettingActivity.c(this.a) != null) && (paramString.equals(ChatSettingActivity.c(this.a))))
    {
      paramString = FaceDrawable.b(this.a.app, paramString, (byte)3);
      ChatSettingActivity.a(this.a).setImageDrawable(paramString);
    }
  }
  
  protected void onUpdateSignature(boolean paramBoolean, String[] paramArrayOfString)
  {
    int j;
    int i;
    if ((paramBoolean) && (paramArrayOfString != null) && (this.a.f != null) && (ChatSettingActivity.a(this.a) == 0) && (!TextUtils.isEmpty(ChatSettingActivity.b(this.a))))
    {
      j = paramArrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        String str = paramArrayOfString[i];
        if (ChatSettingActivity.b(this.a).equals(str)) {
          ChatSettingActivity.a(this.a, ChatSettingActivity.a(this.a, ChatSettingActivity.b(this.a)), this.a.f);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  protected void onUpdateStrangerRichStatus(boolean paramBoolean, String[] paramArrayOfString, Map paramMap)
  {
    if ((this.a.f != null) && (!TextUtils.isEmpty(ChatSettingActivity.b(this.a))) && (paramMap != null) && (paramMap.containsKey(ChatSettingActivity.b(this.a)))) {
      ChatSettingActivity.a(this.a, (RichStatus)paramMap.get(ChatSettingActivity.b(this.a)), this.a.f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rzf
 * JD-Core Version:    0.7.0.1
 */