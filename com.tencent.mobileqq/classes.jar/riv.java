import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.jsp.EventApiPlugin;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class riv
  extends TroopObserver
{
  public riv(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      TroopUtils.a(this.a, paramInt2);
    }
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    if (1 == paramInt1) {}
    switch (paramInt2)
    {
    default: 
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      QQToast.a(this.a, 1, 2131434460, 1).b(this.a.getTitleBarHeight());
      return;
    case 0: 
    case 1: 
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      Object localObject = this.a.getIntent().getStringExtra("param_return_addr");
      if (localObject != null) {
        QQToast.a(this.a, 2, 2131434459, 1).b(this.a.getTitleBarHeight());
      }
      for (;;)
      {
        try
        {
          paramString = Class.forName((String)localObject);
          localObject = new Intent();
          ((Intent)localObject).setComponent(new ComponentName("com.tencent.mobileqq", paramString.getName()));
          ((Intent)localObject).setFlags(67108864);
          this.a.startActivity((Intent)localObject);
          if (TextUtils.isEmpty(this.a.g)) {
            break;
          }
          paramString = new ArrayList(1);
          paramString.add("admin.qun.qq.com");
          EventApiPlugin.a("closeJoinWebView", null, paramString, null);
          return;
        }
        catch (ClassNotFoundException paramString)
        {
          paramString.printStackTrace();
          this.a.setResult(-1);
          this.a.finish();
          continue;
        }
        if (this.a.getIntent().getBooleanExtra("from_newer_guide", false))
        {
          localObject = new Intent();
          ((Intent)localObject).putExtra("has_operation", true);
          ((Intent)localObject).putExtra("uin", paramString);
          this.a.setResult(-1, (Intent)localObject);
          this.a.finish();
        }
        else if (this.a.getIntent().getBooleanExtra("from_babyq", false))
        {
          this.a.app.a().b("babyq_add_troop");
          localObject = new Intent();
          ((Intent)localObject).putExtra("has_operation", true);
          ((Intent)localObject).putExtra("uin", paramString);
          this.a.setResult(-1, (Intent)localObject);
          this.a.finish();
        }
        else
        {
          paramInt1 = this.a.getIntent().getExtras().getShort("group_option", (short)2);
          paramString = (TroopHandler)this.a.app.a(20);
          if ((paramInt1 == 1) || (paramInt1 == 4)) {
            paramString.b(this.a.b, false);
          } else {
            paramString.b(Long.parseLong(this.a.b), Long.parseLong(this.a.app.getAccount()));
          }
        }
      }
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    QQToast.a(this.a, 1, 2131434431, 1).b(this.a.getTitleBarHeight());
  }
  
  protected void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QQToast.a(this.a, 2, 2131434459, 1).b(this.a.getTitleBarHeight());
      this.a.setResult(-1);
      if ((this.a.jdField_a_of_type_AndroidViewInputmethodInputMethodManager != null) && (AddFriendVerifyActivity.a(this.a) != null))
      {
        this.a.getWindow().setSoftInputMode(2);
        this.a.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(AddFriendVerifyActivity.a(this.a).getWindowToken(), 0);
        AddFriendVerifyActivity.a(this.a).clearFocus();
      }
      this.a.finish();
      return;
    }
    paramString = new rjt(this.a, paramString);
    this.a.jdField_a_of_type_AndroidOsHandler.post(paramString);
  }
  
  protected void a(boolean paramBoolean, TroopInfo paramTroopInfo, String paramString)
  {
    if (paramBoolean)
    {
      int i = this.a.getIntent().getExtras().getShort("group_option", (short)2);
      if (i == 4) {
        if (paramTroopInfo != null)
        {
          paramString = AIOUtils.a(new Intent(this.a, SplashActivity.class), null);
          paramString.putExtra("uin", paramTroopInfo.troopuin);
          paramString.putExtra("uintype", 1);
          paramString.putExtra("uinname", paramTroopInfo.getTroopName());
          this.a.startActivity(paramString);
        }
      }
      while ((TextUtils.isEmpty(this.a.b)) || (TextUtils.isEmpty(this.a.app.getAccount())) || (i != 1)) {
        return;
      }
      paramString = this.a.app.a();
      RecentUser localRecentUser = paramString.a().a(paramTroopInfo.troopuin, 1);
      localRecentUser.displayName = paramTroopInfo.troopname;
      localRecentUser.msgData = null;
      localRecentUser.msg = null;
      localRecentUser.msgType = 0;
      long l = NetConnInfoCenter.getServerTime();
      if (localRecentUser.lastmsgtime < l) {
        localRecentUser.lastmsgtime = l;
      }
      paramString.a().a(localRecentUser);
      this.a.setResult(-1);
      this.a.finish();
      return;
    }
    this.a.setResult(-1);
    if ((this.a.jdField_a_of_type_AndroidViewInputmethodInputMethodManager != null) && (AddFriendVerifyActivity.a(this.a) != null))
    {
      this.a.getWindow().setSoftInputMode(2);
      this.a.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(AddFriendVerifyActivity.a(this.a).getWindowToken(), 0);
      AddFriendVerifyActivity.a(this.a).clearFocus();
    }
    this.a.finish();
  }
  
  protected void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2) {}
  
  protected void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = true;
    if ((this.a.b == null) || (!this.a.b.equals(paramString))) {
      return;
    }
    if (!paramBoolean)
    {
      QQToast.a(this.a, this.a.getString(2131430391), 0).b(this.a.getTitleBarHeight());
      AddFriendVerifyActivity.b(this.a);
    }
    paramString = this.a;
    if (paramInt3 == 1) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      paramString.d = paramBoolean;
      return;
    }
  }
  
  protected void b(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString)
  {
    if (!Utils.a(String.valueOf(paramLong), this.a.b)) {}
    label262:
    do
    {
      do
      {
        do
        {
          return;
          if (!paramBoolean) {
            break label262;
          }
          long l = paramTroopInfo.dwGroupClassExt;
          if (QLog.isColorLevel()) {
            QLog.d("zivonchen", 2, "AddFriendVerifyActivity onOIDB0X88D_10_Ret isSuccess = " + paramBoolean + ", troopuin = " + paramLong + ", nFlag = " + paramInt1 + ", troopInfo = " + paramTroopInfo + ", dwGroupClassExt = " + l + ", onResult = " + paramInt2 + ", strErrorMsg = " + paramString);
          }
          if ((l != 10009L) && (l != 10010L) && (l != 10011L) && (l != 10012L) && (!paramTroopInfo.isHomeworkTroop())) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("zivonchen", 2, "AddFriendVerifyActivity onOIDB0X88D_10_Ret: 不需要显示城市、星座、性别这一交友信息~");
        return;
        paramTroopInfo = AddFriendVerifyActivity.c(this.a);
      } while (TextUtils.isEmpty(paramTroopInfo));
      paramTroopInfo = this.a.getString(2131430301, new Object[] { this.a.app.getCurrentNickname() }) + paramTroopInfo;
      this.a.e(paramTroopInfo);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("zivonchen", 2, "AddFriendVerifyActivity onOIDB0X88D_10_Ret isSuccess = " + paramBoolean + ", troopuin = " + paramLong + ", nFlag = " + paramInt1 + ", troopInfo = " + paramTroopInfo + ", onResult = " + paramInt2 + ", strErrorMsg = " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     riv
 * JD-Core Version:    0.7.0.1
 */