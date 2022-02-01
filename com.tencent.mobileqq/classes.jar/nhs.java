import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

public class nhs
{
  public final int a;
  public final long a;
  public final String a;
  public final String b;
  
  private nhs(String paramString1, int paramInt, String paramString2, long paramLong)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt;
    this.b = paramString2;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public static nhs a(Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("key_from");
    long l = paramIntent.getLongExtra("key_msg_seq", 0L);
    int i = paramIntent.getIntExtra("uintype", 0);
    String str2 = paramIntent.getStringExtra("uin");
    Object localObject = null;
    paramIntent = localObject;
    if (!TextUtils.isEmpty(str1))
    {
      paramIntent = localObject;
      if (!TextUtils.isEmpty(str2)) {
        paramIntent = new nhs(str1, i, str2, l);
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("AVGameBackAction", 4, "parseAction, action[" + paramIntent + "]");
    }
    return paramIntent;
  }
  
  public static void a(Intent paramIntent, QQMessageFacade.Message paramMessage)
  {
    if ((paramIntent != null) && (paramMessage != null))
    {
      paramIntent.putExtra("key_from", "MsgPush");
      paramIntent.putExtra("key_msg_seq", paramMessage.uniseq);
      paramIntent.putExtra("uintype", paramMessage.istroop);
      paramIntent.putExtra("uin", paramMessage.frienduin);
      if (QLog.isDevelopLevel()) {
        QLog.i("AVGameBackAction", 4, "addAction, action[MsgPush," + paramMessage.istroop + "," + paramMessage.frienduin + "," + paramMessage.uniseq + "]");
      }
    }
  }
  
  public static void a(Intent paramIntent, nhs paramnhs)
  {
    if ((paramIntent != null) && (paramnhs != null))
    {
      paramIntent.putExtra("key_from", paramnhs.jdField_a_of_type_JavaLangString);
      paramIntent.putExtra("key_msg_seq", paramnhs.jdField_a_of_type_Long);
      paramIntent.putExtra("uintype", paramnhs.jdField_a_of_type_Int);
      paramIntent.putExtra("uin", paramnhs.b);
      if (QLog.isDevelopLevel()) {
        QLog.i("AVGameBackAction", 4, "addAction, action[" + paramnhs + "]");
      }
    }
  }
  
  public void a(Context paramContext)
  {
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = BaseApplicationImpl.getContext();
    }
    paramContext = new Intent((Context)localObject, SplashActivity.class);
    if (this.jdField_a_of_type_Int == 1024) {
      paramContext.putExtra("chat_subType", 1);
    }
    paramContext.putExtra("uin", this.b);
    paramContext.putExtra("uintype", this.jdField_a_of_type_Int);
    paramContext = AIOUtils.setOpenAIOIntent(paramContext, new int[] { 2 });
    paramContext.setAction("com.tencent.mobileqq.action.MAINACTIVITY");
    ((Context)localObject).startActivity(paramContext);
  }
  
  @NotNull
  public String toString()
  {
    return "{" + this.jdField_a_of_type_JavaLangString + "," + this.jdField_a_of_type_Int + "," + this.b + "," + this.jdField_a_of_type_Long + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nhs
 * JD-Core Version:    0.7.0.1
 */