package com.tencent.mobileqq.kandian.glue.viola.modules;

import android.app.Activity;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import org.json.JSONObject;

public class SheetItemClickProcessor$DefaultClickAction
  extends SheetItemClickProcessor.ClickAction
{
  SheetItemClickProcessor$DefaultClickAction(SheetItemClickProcessor paramSheetItemClickProcessor1, Activity paramActivity, SheetItemClickProcessor paramSheetItemClickProcessor2, JSONObject paramJSONObject)
  {
    super(paramSheetItemClickProcessor1, paramActivity, paramSheetItemClickProcessor2, paramJSONObject);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, int paramInt)
  {
    if (paramActionSheetItem.action == 72) {
      paramString1 = paramActionSheetItem.uin;
    } else {
      paramString1 = null;
    }
    SheetItemClickProcessor.a(this.a).mShareUtils.a(this.d, paramInt, this.b, paramString1, paramActionSheetItem.uinType, paramActionSheetItem.label);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.SheetItemClickProcessor.DefaultClickAction
 * JD-Core Version:    0.7.0.1
 */