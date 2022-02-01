package com.tencent.mobileqq.relationx.friendclue;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.friends.intimate.CommonTroopListActivity;
import com.tencent.mobileqq.friends.intimate.IntimateInfoHandler;
import com.tencent.mobileqq.friends.intimate.IntimateInfoObserver;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class FriendClueCommonGroupHelper
  implements Handler.Callback
{
  IntimateInfoObserver a = new FriendClueCommonGroupHelper.2(this);
  private IntimateInfoHandler b;
  private Context c;
  private String d;
  private IntimateInfo e;
  private QQAppInterface f;
  private Handler g;
  
  public FriendClueCommonGroupHelper(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.c = paramContext;
    this.f = paramQQAppInterface;
    this.g = new Handler(Looper.getMainLooper(), this);
  }
  
  void a()
  {
    if (this.e.commonTroopInfoList != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendClueCommonGroupHelper", 2, "get intimateInfo finished");
      }
      localObject = new Intent();
      ((Intent)localObject).addFlags(268435456);
      ((Intent)localObject).putParcelableArrayListExtra("common_troop_list", (ArrayList)this.e.commonTroopInfoList);
      ((Intent)localObject).putExtra("report_friend_type", 1);
      PublicFragmentActivity.a(this.c, (Intent)localObject, CommonTroopListActivity.class);
      return;
    }
    Object localObject = this.d;
    if (localObject != null)
    {
      TroopWithCommonFriendsFragment.a((String)localObject);
      TroopWithCommonFriendsFragment.a(this.c, 2);
    }
  }
  
  public void a(String paramString)
  {
    this.d = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      if (NetworkUtil.isNetworkAvailable(this.c))
      {
        if (this.b == null) {
          this.b = ((IntimateInfoHandler)this.f.getBusinessHandler(BusinessHandlerFactory.INTIMATE_INFO_HANDLER));
        }
        this.f.addObserver(this.a);
        this.b.a(paramString, false);
        paramString = this.g.obtainMessage();
        paramString.what = 1;
        this.g.sendMessageDelayed(paramString, 10000L);
        return;
      }
      this.g.post(new FriendClueCommonGroupHelper.1(this));
      if (QLog.isColorLevel()) {
        QLog.d("FriendClueCommonGroupHelper", 1, String.format("requestIntimateInfo network is not available, uin: %s", new Object[] { paramString }));
      }
    }
  }
  
  public void b()
  {
    this.f.removeObserver(this.a);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return true;
    }
    this.f.removeObserver(this.a);
    paramMessage = this.c.getResources().getString(2131890981);
    QQToast.makeText(this.c, 1, paramMessage, 1).show();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.friendclue.FriendClueCommonGroupHelper
 * JD-Core Version:    0.7.0.1
 */