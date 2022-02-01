package com.tencent.qqmini.miniapp.core.page.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import com.tencent.qqmini.miniapp.core.page.NativeViewContainer;
import com.tencent.qqmini.miniapp.core.page.PageWebviewContainer;
import com.tencent.qqmini.sdk.core.utils.SoftKeyboardStateHelper.SoftKeyboardStateListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class MiniAppTextArea$KeyboardHiddenObserver
  implements SoftKeyboardStateHelper.SoftKeyboardStateListener
{
  public MiniAppTextArea$KeyboardHiddenObserver(MiniAppTextArea paramMiniAppTextArea) {}
  
  public void onSoftKeyboardClosed()
  {
    QMLog.i("MiniAppTextArea", "onSoftKeyboardClosed false");
    MiniAppTextArea.access$002(this.this$0, false);
    MiniAppTextArea.access$1400(this.this$0, false);
  }
  
  public void onSoftKeyboardOpened(int paramInt)
  {
    Object localObject3 = null;
    boolean bool2 = true;
    int i = 0;
    QMLog.i("MiniAppTextArea", "onSoftKeyboardOpened true");
    MiniAppTextArea.access$002(this.this$0, true);
    for (;;)
    {
      try
      {
        if (MiniAppTextArea.access$100(this.this$0) != null)
        {
          PageWebviewContainer localPageWebviewContainer = MiniAppTextArea.access$100(this.this$0).getPageWebviewContainer();
          MiniAppTextArea.access$100(this.this$0).setCurInputId(MiniAppTextArea.access$900(this.this$0));
          MiniAppTextArea.access$302(this.this$0, paramInt);
          Object localObject2 = localObject3;
          if (MiniAppTextArea.access$100(this.this$0) != null)
          {
            localObject2 = localObject3;
            if (MiniAppTextArea.access$100(this.this$0).getPageWebviewContainer() != null) {
              localObject2 = MiniAppTextArea.access$100(this.this$0).getPageWebviewContainer().getAttachActivity();
            }
          }
          boolean bool1;
          if (localObject2 != null)
          {
            if (!Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
              continue;
            }
            bool1 = DisplayUtil.checkNavigationBarShow((Context)localObject2);
            QMLog.d("MiniAppTextArea", " hasNavBar : " + bool1 + "; " + Build.BRAND);
            if (bool1) {
              MiniAppTextArea.access$302(this.this$0, MiniAppTextArea.access$300(this.this$0) + DisplayUtil.getNavigationBarHeight(MiniAppTextArea.access$100(this.this$0).getPageWebviewContainer().getAttachActivity()));
            }
          }
          int j;
          if (this.this$0.isFocused())
          {
            localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("inputId", MiniAppTextArea.access$900(this.this$0));
            j = MiniAppTextArea.access$300(this.this$0);
            paramInt = i;
            if (MiniAppTextArea.access$1000(this.this$0)) {
              paramInt = MiniAppTextArea.access$1100(this.this$0);
            }
            ((JSONObject)localObject2).put("height", (int)((paramInt + j) / DisplayUtil.getDensity(this.this$0.getContext()) + 0.5F));
            localPageWebviewContainer.evaluateSubscribeJS("onKeyboardShow", ((JSONObject)localObject2).toString());
          }
          if (MiniAppTextArea.access$1000(this.this$0))
          {
            paramInt = MiniAppTextArea.access$1200(this.this$0);
            i = MiniAppTextArea.access$300(this.this$0);
            j = MiniAppTextArea.access$1100(this.this$0);
            MiniAppTextArea.access$1300(this.this$0, paramInt - i - j);
            return;
            if (DisplayUtil.hasNavBar((Context)localObject2))
            {
              bool1 = bool2;
              if (DisplayUtil.isNavigationBarExist((Activity)localObject2)) {
                continue;
              }
            }
            boolean bool3 = DisplayUtil.isFlymeOS7NavBarShow();
            bool1 = bool2;
            if (bool3) {
              continue;
            }
            bool1 = false;
            continue;
          }
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      Object localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.widget.MiniAppTextArea.KeyboardHiddenObserver
 * JD-Core Version:    0.7.0.1
 */