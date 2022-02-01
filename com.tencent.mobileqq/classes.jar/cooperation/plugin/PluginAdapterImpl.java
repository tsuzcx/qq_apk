package cooperation.plugin;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.IPluginAdapter;
import com.tencent.mobileqq.pluginsdk.IPluginAdapterProxy;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.theme.SkinEngine;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import mqq.app.MobileQQ;

public class PluginAdapterImpl
  implements IPluginAdapter
{
  public static HashMap<String, Integer> a = new HashMap();
  
  static
  {
    a.put("qzone_plugin.apk", Integer.valueOf(2));
  }
  
  public static int a(String paramString)
  {
    if ((Integer)a.get(paramString) == null) {
      return 1;
    }
    return ((Integer)a.get(paramString)).intValue();
  }
  
  public void initSkin(Context paramContext)
  {
    InitSkin.initSkin(paramContext);
  }
  
  public void initSkinEngine(Context paramContext)
  {
    SkinEngine.init(paramContext, 8191, 2130837504, 2130853739, 1264, 2131165184, 2131168543, null);
  }
  
  public Object invoke(int paramInt, Object paramObject)
  {
    int i = 4;
    boolean bool = false;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5) {
              return null;
            }
            return Integer.valueOf(ImmersiveUtils.isSupporImmersive());
          }
          if (a((String)paramObject) > 1) {
            bool = true;
          }
          return Boolean.valueOf(bool);
        }
        paramObject = BaseApplicationImpl.getApplication();
        str = IPluginAdapterProxy.getProxy().currentUin;
        if (!TextUtils.isEmpty(str))
        {
          if (Build.VERSION.SDK_INT <= 10) {
            i = 0;
          }
          paramObject = paramObject.getSharedPreferences(str, i).getString("currentThemeId_6.3.5", "1000");
          if (("1000".equals(paramObject)) || ("999".equals(paramObject))) {
            return Boolean.valueOf(true);
          }
        }
        return Boolean.valueOf(false);
      }
      return ThreadManager.getSubThreadLooper();
    }
    paramObject = BaseApplicationImpl.getApplication();
    String str = IPluginAdapterProxy.getProxy().currentUin;
    if (!TextUtils.isEmpty(str))
    {
      if (Build.VERSION.SDK_INT <= 10) {
        i = 0;
      }
      paramObject = paramObject.getSharedPreferences(str, i).getString("currentThemeId_6.3.5", "1000");
      if (("1103".equals(paramObject)) || ("2920".equals(paramObject))) {
        return Boolean.valueOf(true);
      }
    }
    return Boolean.valueOf(false);
  }
  
  public boolean isBuiltinPluginAndUpToDay(String paramString, PluginBaseInfo paramPluginBaseInfo)
  {
    return BuiltinPluginManager.a(MobileQQ.sMobileQQ).a(paramString, paramPluginBaseInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.plugin.PluginAdapterImpl
 * JD-Core Version:    0.7.0.1
 */