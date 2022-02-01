package com.tencent.mobileqq.kandian.biz.hippy.module;

import android.content.DialogInterface.OnClickListener;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyGlobalConfigs;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.utils.UIThreadUtils;
import org.jetbrains.annotations.NotNull;

@HippyNativeModule(name="TKDAlertModule")
public class TKDAlertModule
  extends HippyNativeModuleBase
{
  private HippyEngineContext hippyEngineContext;
  
  public TKDAlertModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
    this.hippyEngineContext = paramHippyEngineContext;
  }
  
  @NotNull
  private DialogInterface.OnClickListener createOnClickListener(Promise paramPromise)
  {
    return new TKDAlertModule.2(this, paramPromise);
  }
  
  private void setDialogButton(@NonNull HippyArray paramHippyArray, @NonNull Promise paramPromise, @NonNull QQCustomDialog paramQQCustomDialog)
  {
    paramPromise = createOnClickListener(paramPromise);
    int i = 0;
    while (i < paramHippyArray.size())
    {
      Object localObject = paramHippyArray.getMap(i);
      if (localObject != null)
      {
        localObject = ((HippyMap)localObject).getString("text");
        if (i != 0)
        {
          if (i == 1) {
            paramQQCustomDialog.setPositiveButton((String)localObject, paramPromise);
          }
        }
        else {
          paramQQCustomDialog.setNegativeButton((String)localObject, paramPromise);
        }
      }
      i += 1;
    }
  }
  
  private void showAlertInUIThread(@NonNull HippyArray paramHippyArray, String paramString1, String paramString2, @NonNull Promise paramPromise)
  {
    if (paramHippyArray.size() > 3) {
      return;
    }
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.hippyEngineContext.getGlobalConfigs().getContext(), 230);
    localQQCustomDialog.setTitle(paramString1);
    localQQCustomDialog.setMessage(paramString2);
    setDialogButton(paramHippyArray, paramPromise, localQQCustomDialog);
    localQQCustomDialog.show();
  }
  
  @HippyMethod(name="showAlert")
  public void showAlert(String paramString1, String paramString2, HippyArray paramHippyArray, Promise paramPromise)
  {
    if (paramHippyArray != null)
    {
      if (paramPromise == null) {
        return;
      }
      UIThreadUtils.runOnUiThread(new TKDAlertModule.1(this, paramHippyArray, paramString1, paramString2, paramPromise));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.module.TKDAlertModule
 * JD-Core Version:    0.7.0.1
 */