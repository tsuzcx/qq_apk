import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xaf4.oidb_0xaf4.ExtraInfo;
import tencent.im.oidb.cmd0xaf4.oidb_0xaf4.RspBody;

public class saq
  extends TroopObserver
{
  public saq(ChatSettingForTroop paramChatSettingForTroop) {}
  
  protected void a(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if (QLog.isColorLevel())
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) {
        bool = true;
      }
      QLog.d("Q.chatopttroop", 2, new Object[] { "onTroopManagerFailed. reqType=", Integer.valueOf(paramInt1), ", result=", Integer.valueOf(paramInt2), ", hasTroopInfoData=", Boolean.valueOf(bool) });
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    do
    {
      return;
      if ((1 == paramInt1) && ((this.a.isResume()) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption == 1)))
      {
        this.a.s();
        TroopUtils.a(this.a, paramInt2);
        this.a.b = null;
        return;
      }
    } while ((!this.a.isResume()) || ((paramInt1 != 2) && (paramInt1 != 9)));
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this.a);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(2, 2131435270, 1500);
    this.a.finish();
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    Object localObject;
    boolean bool;
    if (QLog.isColorLevel())
    {
      if (TextUtils.isEmpty(paramString))
      {
        localObject = "";
        if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {
          break label107;
        }
        bool = true;
        label30:
        QLog.d("Q.chatopttroop", 2, new Object[] { "onTroopManagerSuccess. reqType=", Integer.valueOf(paramInt1), ", result=", Integer.valueOf(paramInt2), ", troopUin=", localObject, ", hasTroopInfoData=", Boolean.valueOf(bool) });
      }
    }
    else {
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) {
        break label113;
      }
    }
    label107:
    label113:
    do
    {
      for (;;)
      {
        return;
        localObject = paramString;
        break;
        bool = false;
        break label30;
        if ((1 == paramInt1) && ((this.a.isResume()) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption == 1)))
        {
          this.a.s();
          if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
            this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this.a);
          }
          switch (paramInt2)
          {
          default: 
            this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(2, 2131434449, 1500);
          }
          for (;;)
          {
            this.a.b = null;
            return;
            this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(2, 2131434448, 1500);
            this.a.finish();
            ChatSettingForTroop.g(this.a);
            localObject = (TroopManager)this.a.app.getManager(51);
            if (localObject != null)
            {
              ((TroopManager)localObject).d(((TroopManager)localObject).a(paramString));
              continue;
              this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(2, 2131434414, 1500);
            }
          }
        }
        if (this.a.isResume())
        {
          if (paramInt1 != 3) {
            break label483;
          }
          if (paramInt2 == 0)
          {
            paramString = (TroopManager)this.a.app.getManager(51);
            if (paramString == null) {}
            for (paramString = null;; paramString = paramString.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))
            {
              if ((paramString == null) || (paramString.wMemberNum == this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum)) {
                break label481;
              }
              this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateTroopAdmMemberNum(paramString.Administrator, paramString.wMemberNum, this.a.app.getCurrentAccountUin(), this.a.getResources());
              if (this.a.c == null) {
                break;
              }
              this.a.c.setText("共" + this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum + "人");
              return;
            }
          }
        }
      }
    } while ((paramInt1 != 2) && (paramInt1 != 9));
    label481:
    label483:
    if (paramInt2 == 0)
    {
      QQToast.a(this.a, 2, "操作成功", 0).a();
      paramString = new Intent();
      paramString.putExtra("isNeedFinish", true);
      this.a.setResult(-1, paramString);
      this.a.finish();
      return;
    }
    QQToast.a(this.a, 1, "操作失败", 0).a();
  }
  
  protected void a(oidb_0xaf4.RspBody paramRspBody, int paramInt)
  {
    if (paramRspBody.group_id.has())
    {
      localObject = String.valueOf(paramRspBody.group_id.get());
      if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (!TextUtils.equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, (CharSequence)localObject))) {
        if (QLog.isColorLevel()) {
          QLog.e("Q.chatopttroop", 2, "onGetNewTroopAppList troopUin not match. rsp uin=" + (String)localObject + ", current uin=" + this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      Object localObject;
      do
      {
        do
        {
          return;
        } while (paramInt != 3);
        if (QLog.isColorLevel()) {
          QLog.d("raymondguo", 2, "game feed service type 3 refresh");
        }
        localObject = this.a.jdField_a_of_type_ArrayOfAndroidViewView[29];
      } while (localObject == null);
      if (paramRspBody.extra_info.tab_infos.size() > 0)
      {
        ((View)localObject).setVisibility(0);
        this.a.b(paramRspBody.extra_info.tab_infos.get());
        return;
      }
      ((View)localObject).setVisibility(8);
      return;
    }
    QLog.e("Q.chatopttroop", 2, "onGetNewTroopAppList service 3 group_id lost. current uin=" + this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     saq
 * JD-Core Version:    0.7.0.1
 */