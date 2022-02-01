package com.tencent.mobileqq.kandian.glue.viola.modules;

import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

class ActionSheetHelper$2
  implements ActionSheet.OnButtonClickListener
{
  ActionSheetHelper$2(ActionSheetHelper paramActionSheetHelper, String paramString) {}
  
  public void onClick(View paramView, int paramInt)
  {
    paramView = new JSONObject();
    try
    {
      paramView.put("index", paramInt);
      boolean bool = this.b.b;
      if ((bool) && (paramInt == 0)) {
        paramView.put("type", 2);
      } else {
        paramView.put("type", 0);
      }
      if (ActionSheetHelper.a(this.b) != null) {
        ((BridgeModule)ActionSheetHelper.a(this.b).get()).invokeCallJS(this.a, paramView);
      }
    }
    catch (JSONException paramView)
    {
      label82:
      break label82;
    }
    ActionSheetHelper.b(this.b).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.ActionSheetHelper.2
 * JD-Core Version:    0.7.0.1
 */