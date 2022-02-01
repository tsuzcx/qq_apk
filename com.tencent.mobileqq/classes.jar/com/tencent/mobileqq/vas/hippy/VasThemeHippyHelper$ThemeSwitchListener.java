package com.tencent.mobileqq.vas.hippy;

import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.manager.api.IThemeSwitchManager;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.mobileqq.vas.theme.ThemeSwitchCallback;
import com.tencent.mobileqq.vas.theme.api.ThemeLocator;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil.ThemeInfo;
import com.tencent.mobileqq.vas.theme.diy.ThemeBackground;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONArray;

class VasThemeHippyHelper$ThemeSwitchListener
  extends ThemeSwitchCallback
{
  String currentMethodName;
  private final boolean needSetCurrent;
  Promise promise;
  private final String themeId;
  ThemeUtil.ThemeInfo themeInfo;
  
  public VasThemeHippyHelper$ThemeSwitchListener(VasThemeHippyHelper paramVasThemeHippyHelper, String paramString, boolean paramBoolean, ThemeUtil.ThemeInfo paramThemeInfo, Promise paramPromise)
  {
    this.themeId = paramString;
    this.needSetCurrent = paramBoolean;
    this.themeInfo = paramThemeInfo;
    this.promise = paramPromise;
  }
  
  public boolean beforeSwitch(ThemeLocator paramThemeLocator)
  {
    ThreadManagerV2.getUIHandlerV2().post(new VasThemeHippyHelper.ThemeSwitchListener.1(this, paramThemeLocator));
    return true;
  }
  
  public void beginSwitch()
  {
    VasUtil.a().getThemeSwitchManager().openSwitchDialog(this.this$0.e);
  }
  
  public boolean postSwitch(int paramInt)
  {
    boolean bool = QLog.isColorLevel();
    int i = 2;
    if ((bool) || (paramInt != 0))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("themeSwitchListener,themeId=");
      ((StringBuilder)localObject1).append(this.themeId);
      ((StringBuilder)localObject1).append(",stateCode=");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.i("VasThemeHippyHelper", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("set skin theme back:");
    ((StringBuilder)localObject1).append(paramInt);
    localObject1 = ((StringBuilder)localObject1).toString();
    if (paramInt == 0)
    {
      if (this.needSetCurrent)
      {
        Object localObject2 = this.themeInfo.seriesID;
        Object localObject3 = this.themeInfo.themeArray;
        long l = this.themeInfo.startTime;
        Object localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("ThemeJsHandler switchThemeTask onPostExecute themeId=");
        ((StringBuilder)localObject4).append(this.themeId);
        ((StringBuilder)localObject4).append(",seriesID");
        ((StringBuilder)localObject4).append((String)localObject2);
        ((StringBuilder)localObject4).append(",themeArray:");
        if ((localObject3 != null) && (((JSONArray)localObject3).length() > 0)) {
          bool = true;
        } else {
          bool = false;
        }
        ((StringBuilder)localObject4).append(bool);
        QLog.i("VasThemeHippyHelper", 1, ((StringBuilder)localObject4).toString());
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (localObject3 != null) && (((JSONArray)localObject3).length() > 0)) {
          ThemeUtil.setWeekLoopTheme(this.this$0.d, (String)localObject2, ((JSONArray)localObject3).toString(), l);
        }
        localObject2 = (ChatBackgroundManager)this.this$0.d.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER);
        localObject3 = ThemeBackground.a(this.this$0.d.getApp(), this.this$0.d.getAccount(), 0).getString("theme_bg_aio_path", "null");
        localObject4 = ((ChatBackgroundManager)localObject2).c(null);
        if ((localObject3 != null) && (!"null".equals(localObject3)) && (((String)localObject3).equals(localObject4))) {
          ((ChatBackgroundManager)localObject2).a(this.this$0.d.getAccount(), null, "null", -1);
        }
        ThemeReporter.a(this.this$0.d, "theme_detail", "200", 155, NetworkUtil.getSystemNetwork(null), 31, this.themeId, "20000000", ThemeReporter.a, "");
      }
      i = 0;
    }
    else if (paramInt == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.i("VasThemeHippyHelper", 2, "ThemeJsHandler return because setupping.");
      }
      localObject1 = "is switching theme";
    }
    else
    {
      QLog.e("VasThemeHippyHelper", 1, "themeSwitchListener ret = false");
      i = -1;
    }
    if (i == 0) {
      this.promise.resolve(VasHippyUtils.a(0, (String)localObject1, null));
    } else {
      this.promise.reject(VasHippyUtils.a(paramInt, "", null));
    }
    if (paramInt != 0) {
      VasUtil.a().getThemeSwitchManager().clearOnErr();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.hippy.VasThemeHippyHelper.ThemeSwitchListener
 * JD-Core Version:    0.7.0.1
 */