package com.tencent.mobileqq.kandian.glue.viola.modules;

import android.app.Activity;
import com.tencent.mobileqq.kandian.biz.share.ImageActionItem;
import com.tencent.mobileqq.kandian.biz.share.ReadInJoyShareHelperV2;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import org.json.JSONObject;

public class SheetItemClickProcessor$SaveImageAction
  extends SheetItemClickProcessor.ClickAction
{
  SheetItemClickProcessor$SaveImageAction(SheetItemClickProcessor paramSheetItemClickProcessor1, Activity paramActivity, SheetItemClickProcessor paramSheetItemClickProcessor2, JSONObject paramJSONObject)
  {
    super(paramSheetItemClickProcessor1, paramActivity, paramSheetItemClickProcessor2, paramJSONObject);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, int paramInt)
  {
    paramString1 = SheetItemClickProcessor.a(this.a).mShareHelper.a(SheetItemClickProcessor.a(this.b), SheetItemClickProcessor.b(this.b), paramInt);
    if ((paramString1 instanceof ImageActionItem)) {
      BridgeModule.saveImageToLocal(((ImageActionItem)paramString1).b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.SheetItemClickProcessor.SaveImageAction
 * JD-Core Version:    0.7.0.1
 */