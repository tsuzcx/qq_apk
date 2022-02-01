package com.tencent.mobileqq.troop.navigatebar;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager.TroopNotify;
import com.tencent.mobileqq.utils.NumberUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import org.json.JSONObject;

public class TroopAioMsgNavigateNotification
  extends BaseAioMsgNavigateBarDelegate
  implements Observer
{
  @Nullable
  private TroopAioMsgNavigateBar a;
  @Nullable
  private TroopFeedsDataManager g;
  private TroopFeedsDataManager.TroopNotify h;
  private long i;
  private Object j;
  
  TroopAioMsgNavigateNotification(QQAppInterface paramQQAppInterface, Context paramContext, TroopAioMsgNavigateBar paramTroopAioMsgNavigateBar, BaseSessionInfo paramBaseSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramBaseSessionInfo);
    this.c = 102;
    this.a = paramTroopAioMsgNavigateBar;
  }
  
  public int a(int paramInt)
  {
    return 2130853379;
  }
  
  @Nullable
  public BaseAioMsgNavigateBarDelegate.Entity a(int paramInt1, List<Long> paramList, long paramLong1, Object paramObject, long paramLong2, long paramLong3, int paramInt2)
  {
    this.i = paramLong1;
    this.j = paramObject;
    paramList = this.d.getMessageFacade().b(this.f.b, this.f.a, paramLong1);
    if ((paramList != null) && (a(paramList, paramLong2, paramLong3))) {
      return new BaseAioMsgNavigateBarDelegate.Entity(true, this.e.getString(2131895407), AioAgent.Message.a(paramInt1, paramLong1, paramInt2), paramList.senderuin);
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    this.h = null;
    Object localObject = (TroopInfoManager)this.d.getManager(QQManagerFactory.TROOPINFO_MANAGER);
    long l = NumberUtils.a(this.f.b);
    if (l == -1L) {
      return;
    }
    this.g = ((TroopInfoManager)localObject).a(Long.valueOf(l), true);
    localObject = this.g;
    if (localObject != null) {
      ((TroopFeedsDataManager)localObject).addObserver(this);
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.b, 2, "onInit");
    }
  }
  
  public void a(int paramInt, TextView paramTextView1, TextView paramTextView2, ImageView paramImageView, String paramString)
  {
    paramTextView1.setText(paramString);
    paramTextView1.setVisibility(0);
    paramTextView2.setVisibility(8);
  }
  
  public void a(int paramInt, Object paramObject, String paramString)
  {
    paramObject = (TroopManager)this.d.getManager(QQManagerFactory.TROOP_MANAGER);
    if (paramObject != null)
    {
      paramObject = paramObject.f(this.f.b);
      if (paramObject != null)
      {
        boolean bool = paramString.equals(this.e.getString(2131895419));
        paramString = this.d;
        String str = this.f.b;
        long l = paramObject.dwGroupClassExt;
        if (bool) {
          paramObject = "2";
        } else {
          paramObject = "1";
        }
        ReportController.b(paramString, "dc00898", "", "", "", "0X800AACB", 0, 1, 0, str, String.valueOf(l), paramObject, "");
      }
    }
  }
  
  public void b()
  {
    super.b();
    this.h = null;
    if (this.g != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.b, 2, "onUnInit");
      }
      this.g.deleteObserver(this);
      this.g = null;
    }
    this.a = null;
  }
  
  public void b(int paramInt, Object paramObject, String paramString)
  {
    paramObject = (TroopManager)this.d.getManager(QQManagerFactory.TROOP_MANAGER);
    if (paramObject != null)
    {
      paramObject = paramObject.f(this.f.b);
      if (paramObject != null)
      {
        boolean bool = paramString.equals(this.e.getString(2131895419));
        paramString = this.d;
        String str = this.f.b;
        long l = paramObject.dwGroupClassExt;
        if (bool) {
          paramObject = "2";
        } else {
          paramObject = "1";
        }
        ReportController.b(paramString, "dc00898", "", "", "", "0X800AACC", 0, 1, 0, str, String.valueOf(l), paramObject, "");
      }
    }
  }
  
  void d()
  {
    Object localObject1 = this.a;
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.b, 2, "mTroopAioMsgNavigateBar = null");
      }
      return;
    }
    boolean bool2 = ((TroopAioMsgNavigateBar)localObject1).s();
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = this.b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("showTroopNotifyBar troopNotifyData = ");
      ((StringBuilder)localObject2).append(this.h);
      ((StringBuilder)localObject2).append(",  mFIsShow = ");
      ((StringBuilder)localObject2).append(bool2);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if (this.h == null) {
      return;
    }
    if (this.a.j())
    {
      this.h = null;
      return;
    }
    boolean bool1 = false;
    if ((bool2) && (!this.h.n) && ((this.j instanceof MessageForArkApp)) && (!this.h.q))
    {
      localObject1 = (MessageForArkApp)this.j;
      if ((((MessageForArkApp)localObject1).ark_app_message != null) && ("com.tencent.mannounce".equals(((MessageForArkApp)localObject1).ark_app_message.appName))) {
        try
        {
          if (QLog.isColorLevel())
          {
            localObject2 = this.b;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("showTroopNotifyBar ark.ark_app_message.metaList:");
            localStringBuilder.append(((MessageForArkApp)localObject1).ark_app_message.metaList);
            QLog.d((String)localObject2, 2, localStringBuilder.toString());
            localObject2 = this.b;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("showTroopNotifyBar mTroopNotifyData confirmRequired:");
            localStringBuilder.append(this.h.o);
            localStringBuilder.append(" fid:");
            localStringBuilder.append(this.h.b);
            localStringBuilder.append(" isShowTipWindow:");
            localStringBuilder.append(this.h.n);
            QLog.d((String)localObject2, 2, localStringBuilder.toString());
          }
          localObject1 = new JSONObject(((MessageForArkApp)localObject1).ark_app_message.metaList).optJSONObject("mannounce");
          localObject2 = this.a.n();
          if ((localObject1 != null) && (localObject2 != null) && (((JSONObject)localObject1).optString("fid").equals(this.h.b)))
          {
            long l = ((MessageRecord)localObject2).shmsgseq;
            localObject1 = this.d.getMessageFacade().b(this.f.b, this.f.a, this.i);
            if ((localObject1 != null) && (a((MessageRecord)localObject1, l, this.a.t())))
            {
              if (this.h.o) {
                localObject1 = this.e.getString(2131895419);
              } else {
                localObject1 = this.e.getString(2131895407);
              }
              bool1 = true;
            }
          }
        }
        catch (Exception localException)
        {
          QLog.e(this.b, 1, "[showTroopNotifyBar] ", localException);
        }
      }
    }
    String str = "";
    this.a.a(new BaseAioMsgNavigateBarDelegate.Entity(bool1, str, null, ""));
    this.h = null;
    if (QLog.isColorLevel())
    {
      str = this.b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("showTroopNotifyBar mFIsShow:");
      ((StringBuilder)localObject2).append(bool1);
      QLog.d(str, 2, ((StringBuilder)localObject2).toString());
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.b, 2, "troopNotify update");
    }
    if (!(paramObject instanceof Integer)) {
      return;
    }
    paramObservable = (Integer)paramObject;
    if (QLog.isColorLevel())
    {
      paramObject = this.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("update. notifyType = ");
      localStringBuilder.append(paramObservable);
      QLog.d(paramObject, 2, localStringBuilder.toString());
    }
    if ((paramObservable.intValue() == 1007) || (paramObservable.intValue() == 1011))
    {
      paramObservable = this.g;
      if ((paramObservable != null) && (paramObservable.b != null)) {
        try
        {
          this.h = TroopFeedsDataManager.TroopNotify.a(this.d, this.f.b, this.g.b);
          d();
          return;
        }
        finally {}
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.b, 2, "update. mNewNorNotice = null!");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.navigatebar.TroopAioMsgNavigateNotification
 * JD-Core Version:    0.7.0.1
 */