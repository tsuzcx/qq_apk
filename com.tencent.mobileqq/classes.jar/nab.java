import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.av.wtogether.data.ChooseFileInfo;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.widget.QQToast;

public class nab
  implements agin, agja
{
  public static final String a;
  private BaseChatPie a;
  
  static
  {
    jdField_a_of_type_JavaLangString = nab.class.getSimpleName();
  }
  
  public nab(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  public static String a(String paramString, int paramInt)
  {
    int i = 1;
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt == 1) {}
    for (paramInt = i;; paramInt = 2) {
      return bkyp.a(paramString, "fromid", paramInt + "");
    }
  }
  
  public static void a(@NonNull Activity paramActivity, int paramInt1, int paramInt2, String paramString)
  {
    argl localargl = (argl)aqxe.a().a(535);
    if ((localargl == null) || (localargl.a == null))
    {
      QQToast.a(paramActivity, 0, 2131692995, 0).a();
      return;
    }
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("key_from_type", paramInt1);
    localIntent.putExtra("watch_together_uinType", paramInt2);
    localIntent.putExtra("watch_together_uin", paramString);
    localIntent.putExtra("url", a(localargl.a.a(), paramInt1));
    if (paramInt1 == 1) {}
    paramActivity.startActivityForResult(localIntent, 2020);
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == 4660) && (paramInt1 == 2020) && (paramIntent != null))
    {
      paramInt1 = paramIntent.getIntExtra("watch_together_uinType", -1);
      String str = paramIntent.getStringExtra("watch_together_uin");
      paramIntent = (ChooseFileInfo)paramIntent.getParcelableExtra("ChooseFileInfo");
      if (ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity(), true, new nac(this, paramInt1, str, paramIntent)))
      {
        mzq.a().a(paramInt1, str, paramIntent);
        aftr.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getApp(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getSessionInfo(), true, "AIOQAVWatchTogether", null);
      }
    }
  }
  
  public int[] a()
  {
    return new int[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nab
 * JD-Core Version:    0.7.0.1
 */