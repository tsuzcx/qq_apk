package com.tencent.mobileqq.intervideo.singtogether;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.SingTogetherConfigBean;
import com.tencent.mobileqq.config.business.SingTogetherConfigBean.GeneralTogetherItem;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.together.TogetherControlManager;
import com.tencent.mobileqq.together.TogetherSession;
import com.tencent.mobileqq.together.TogetherUtils;
import com.tencent.mobileqq.together.delegate.TogetherDelegate;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import javax.annotation.Nullable;

public class TogetherSingDelegate
  implements TogetherDelegate
{
  private QQAppInterface a;
  
  public TogetherSingDelegate(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private void a(String paramString, int paramInt)
  {
    TogetherControlManager localTogetherControlManager = (TogetherControlManager)this.a.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
    if (paramInt == 4)
    {
      ReportController.b(this.a, "dc00899", "c2c_AIO", "", "sing_tab", "clk_join_suc", 0, 1, paramString, "", "", "");
      return;
    }
    if (paramInt == 9)
    {
      ReportController.b(this.a, "dc00899", "c2c_AIO", "", "sing_tab", "clk_singark_suc", 0, 1, paramString, "", "", "");
      return;
    }
    if (paramInt == 1)
    {
      localTogetherControlManager.a("sing_tab", "clk_join_suc", 0, paramString);
      return;
    }
    if (paramInt == 8) {
      localTogetherControlManager.a("sing_tab", "clk_setsing_suc", 0, paramString);
    }
  }
  
  private boolean a(boolean paramBoolean, Bundle paramBundle, String paramString, Context paramContext, int paramInt)
  {
    if (paramBoolean)
    {
      if (paramInt <= 0) {
        return true;
      }
      paramString = ((FetchOpenIdManager)this.a.getManager(QQManagerFactory.FETCH_OPENID_MANAGER)).a(Long.parseLong(paramString), paramInt, true);
      if (TextUtils.isEmpty(paramString))
      {
        Toast.makeText(paramContext, "加载中，请稍后再试。", 1).show();
        return false;
      }
      paramBundle.putString("TOGETHER_BUNDLE_KEY_C2C_FRIEND_OPENID", paramString);
    }
    return true;
  }
  
  public int a(int paramInt1, String paramString, Context paramContext, int paramInt2, Map<String, TogetherSession> paramMap, Bundle paramBundle)
  {
    a(paramString, paramInt2);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("4_");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("TogetherSingDelegate start SCHEMA=");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" from=");
      localStringBuilder.append(paramInt2);
      QLog.d("TogetherSingDelegate", 2, localStringBuilder.toString());
    }
    int i;
    if (paramInt1 == 2) {
      i = 2080;
    } else {
      i = 2081;
    }
    if (((paramInt2 == 4) || (paramInt2 == 1) || (paramInt2 == 9) || (paramInt2 == 8)) && (paramMap != null) && (paramMap.get(localObject) != null))
    {
      paramMap = (SingTogetherSession)paramMap.get(localObject);
      if (!TextUtils.isEmpty(paramMap.e))
      {
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(paramContext, paramMap.e, i, null);
        return 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TogetherSingDelegate", 2, "TogetherSingDelegate start SCHEMA is empty");
      }
    }
    if (TextUtils.isEmpty(""))
    {
      localObject = ((SingTogetherConfigBean)QConfigManager.b().b(551)).a(4);
      boolean bool;
      if ((localObject != null) && (((SingTogetherConfigBean.GeneralTogetherItem)localObject).e != 1))
      {
        bool = TextUtils.isEmpty(((SingTogetherConfigBean.GeneralTogetherItem)localObject).g);
        if (bool) {
          paramMap = "mqqapi://miniapp/open?_atype=0&_mappid=1109995692&_mvid=&_path=%2Fpages%2Findex%2Fmain&_vt=3&_sig=87d212c596d5dd75907b38e2a96705ec4d7eef6a557f4cbba1f69df0d0d991fc";
        } else {
          paramMap = ((SingTogetherConfigBean.GeneralTogetherItem)localObject).g;
        }
        if (bool) {
          paramInt2 = 2;
        } else {
          paramInt2 = ((SingTogetherConfigBean.GeneralTogetherItem)localObject).d;
        }
        if (paramInt1 == 2) {
          bool = true;
        } else {
          bool = false;
        }
        if (!a(bool, paramBundle, paramString, paramContext, ((SingTogetherConfigBean.GeneralTogetherItem)localObject).f)) {
          return 0;
        }
        TogetherUtils.a(this.a, paramInt2, paramMap, null, paramBundle, paramInt1);
        return 2;
      }
      if (paramInt1 == 2) {
        bool = true;
      } else {
        bool = false;
      }
      if (!a(bool, paramBundle, paramString, paramContext, 1109995692)) {
        return 0;
      }
      if (paramInt1 == 1) {
        paramString = TogetherUtils.a("mqqapi://miniapp/open?_atype=0&_mappid=1109995692&_mvid=&_path=%2Fpages%2Findex%2Fmain&_vt=3&_sig=87d212c596d5dd75907b38e2a96705ec4d7eef6a557f4cbba1f69df0d0d991fc", paramBundle);
      } else {
        paramString = TogetherUtils.b("mqqapi://miniapp/open?_atype=0&_mappid=1109995692&_mvid=&_path=%2Fpages%2Findex%2Fmain&_vt=3&_sig=87d212c596d5dd75907b38e2a96705ec4d7eef6a557f4cbba1f69df0d0d991fc", paramBundle);
      }
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(paramContext, paramString, i, null);
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("TogetherSingDelegate start SCHEMA=");
        paramContext.append(paramString);
        QLog.d("TogetherSingDelegate", 2, paramContext.toString());
      }
      return 3;
    }
    return -1;
  }
  
  public String a()
  {
    return "一起K歌";
  }
  
  public void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, @Nullable Map<String, TogetherSession> paramMap, @Nullable Bundle paramBundle) {}
  
  public void a(Context paramContext, SessionInfo paramSessionInfo, int paramInt) {}
  
  public void a(Context paramContext, String paramString, int paramInt1, int paramInt2, Bundle paramBundle) {}
  
  public void a(TogetherSession paramTogetherSession, int paramInt, String paramString, long paramLong1, long paramLong2, Object paramObject) {}
  
  public boolean a(Context paramContext, String paramString, int paramInt1, int paramInt2, @Nullable Map<String, TogetherSession> paramMap, @Nullable Bundle paramBundle)
  {
    a(paramInt1, paramString, paramContext, paramInt2, paramMap, paramBundle);
    return false;
  }
  
  public boolean a(Context paramContext, String paramString, int paramInt1, int paramInt2, boolean paramBoolean, Map<String, TogetherSession> paramMap, @Nullable Bundle paramBundle)
  {
    return true;
  }
  
  public QQCustomDialog b()
  {
    return null;
  }
  
  public boolean b(Context paramContext, String paramString, int paramInt1, int paramInt2, @Nullable Map<String, TogetherSession> paramMap, @Nullable Bundle paramBundle)
  {
    a(paramInt1, paramString, paramContext, paramInt2, paramMap, paramBundle);
    return false;
  }
  
  public int c()
  {
    return 9;
  }
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.singtogether.TogetherSingDelegate
 * JD-Core Version:    0.7.0.1
 */