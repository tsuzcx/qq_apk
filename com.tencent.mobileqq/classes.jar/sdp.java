import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class sdp
  extends TroopObserver
{
  public sdp(ChatSettingForTroop paramChatSettingForTroop) {}
  
  protected void a(String paramString, boolean paramBoolean, List paramList)
  {
    if (!Utils.a(paramString, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) {
      return;
    }
    TroopInfo localTroopInfo = ((TroopManager)this.a.app.getManager(51)).a(paramString);
    paramString = new Message();
    paramString.what = 10;
    Bundle localBundle = paramString.getData();
    if (localTroopInfo != null)
    {
      localBundle.putStringArrayList("AVATAR_WALL_LIST", (ArrayList)localTroopInfo.mTroopPicList);
      paramList = localTroopInfo.mTroopVerifyingPics;
      if (paramList != null) {
        localBundle.putStringArray("VERIFYING_PICTURE_LIST", (String[])paramList.toArray(new String[paramList.size()]));
      }
    }
    for (;;)
    {
      localBundle.putBoolean("IS_DEFAULT_AVATAR", paramBoolean);
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
      return;
      localBundle.putStringArrayList("AVATAR_WALL_LIST", (ArrayList)paramList);
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, List paramList)
  {
    boolean bool = true;
    if (this.a.f) {}
    do
    {
      do
      {
        return;
      } while ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (!paramBoolean) || (!Utils.a(paramString1, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)));
      if (paramInt1 == 0)
      {
        if (paramInt2 == 0) {}
        for (paramBoolean = bool;; paramBoolean = false)
        {
          a(paramString1, paramBoolean, paramList);
          return;
        }
      }
      if (paramString2 != null)
      {
        QQToast.a(this.a, paramString2, 1).b(this.a.getTitleBarHeight());
        return;
      }
      if ((paramInt1 == 1) || (paramInt1 == 2))
      {
        QQToast.a(this.a, this.a.getString(2131430225), 1).b(this.a.getTitleBarHeight());
        return;
      }
      if (paramInt1 == 19)
      {
        QQToast.a(this.a, this.a.getString(2131430226), 1).b(this.a.getTitleBarHeight());
        return;
      }
    } while (paramInt1 != 65);
    QQToast.a(this.a, this.a.getString(2131430227), 1).b(this.a.getTitleBarHeight());
  }
  
  protected void b(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, List paramList)
  {
    if (this.a.f) {}
    while ((!paramBoolean) || (!Utils.a(paramString1, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))) {
      return;
    }
    if (paramInt1 == 0)
    {
      a(paramString1, false, paramList);
      return;
    }
    a(paramString1, false, paramList);
    if (paramString2 != null)
    {
      QQToast.a(this.a, paramString2, 1).b(this.a.getTitleBarHeight());
      return;
    }
    if (paramInt1 == 1)
    {
      QQToast.a(this.a, this.a.getString(2131430225), 1).b(this.a.getTitleBarHeight());
      return;
    }
    if (paramInt1 == 2)
    {
      QQToast.a(this.a, this.a.getString(2131430226), 1).b(this.a.getTitleBarHeight());
      return;
    }
    if (paramInt1 == 3)
    {
      QQToast.a(this.a, this.a.getString(2131430229), 1).b(this.a.getTitleBarHeight());
      return;
    }
    if (paramInt1 == 4)
    {
      QQToast.a(this.a, this.a.getString(2131430230), 1).b(this.a.getTitleBarHeight());
      return;
    }
    QQToast.a(this.a, this.a.getString(2131430231), 1).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sdp
 * JD-Core Version:    0.7.0.1
 */