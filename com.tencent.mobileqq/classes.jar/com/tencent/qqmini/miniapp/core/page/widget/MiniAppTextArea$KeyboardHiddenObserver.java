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
    MiniAppTextArea.access$1600(this.this$0, false);
  }
  
  public void onSoftKeyboardOpened(int paramInt)
  {
    QMLog.i("MiniAppTextArea", "onSoftKeyboardOpened true");
    MiniAppTextArea.access$002(this.this$0, true);
    for (;;)
    {
      try
      {
        if (MiniAppTextArea.access$100(this.this$0) == null) {
          break label359;
        }
        PageWebviewContainer localPageWebviewContainer = MiniAppTextArea.access$100(this.this$0).getPageWebviewContainer();
        MiniAppTextArea.access$100(this.this$0).setCurInputId(MiniAppTextArea.access$900(this.this$0));
        MiniAppTextArea.access$302(this.this$0, paramInt);
        Object localObject2 = MiniAppTextArea.access$1000(this.this$0);
        if (localObject2 != null)
        {
          boolean bool;
          if (Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
            bool = DisplayUtil.checkNavigationBarShow((Context)localObject2);
          } else {
            bool = MiniAppTextArea.access$1100(this.this$0, (Activity)localObject2);
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(" hasNavBar : ");
          ((StringBuilder)localObject2).append(bool);
          ((StringBuilder)localObject2).append("; ");
          ((StringBuilder)localObject2).append(Build.BRAND);
          QMLog.d("MiniAppTextArea", ((StringBuilder)localObject2).toString());
          if (bool) {
            MiniAppTextArea.access$302(this.this$0, MiniAppTextArea.access$300(this.this$0) + DisplayUtil.getNavigationBarHeight(MiniAppTextArea.access$100(this.this$0).getPageWebviewContainer().getAttachActivity()));
          }
        }
        if (this.this$0.isFocused())
        {
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("inputId", MiniAppTextArea.access$900(this.this$0));
          int i = MiniAppTextArea.access$300(this.this$0);
          if (!MiniAppTextArea.access$1200(this.this$0)) {
            break label365;
          }
          paramInt = MiniAppTextArea.access$1300(this.this$0);
          ((JSONObject)localObject2).put("height", (int)((i + paramInt) / DisplayUtil.getDensity(this.this$0.getContext()) + 0.5F));
          localPageWebviewContainer.evaluateSubscribeJS("onKeyboardShow", ((JSONObject)localObject2).toString());
          if (MiniAppTextArea.access$1200(this.this$0))
          {
            paramInt = MiniAppTextArea.access$1400(this.this$0);
            i = MiniAppTextArea.access$300(this.this$0);
            int j = MiniAppTextArea.access$1300(this.this$0);
            MiniAppTextArea.access$1500(this.this$0, paramInt - i - j);
            return;
          }
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      return;
      label359:
      Object localObject1 = null;
      continue;
      label365:
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.widget.MiniAppTextArea.KeyboardHiddenObserver
 * JD-Core Version:    0.7.0.1
 */