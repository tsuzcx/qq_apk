package com.tencent.mobileqq.kandian.glue.viola.modules;

import android.app.Activity;
import com.tencent.mobileqq.kandian.biz.share.ReadInJoyShareHelperV2;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import org.json.JSONObject;

public class SheetItemClickProcessor$QQBrowserAction
  extends SheetItemClickProcessor.ClickAction
{
  SheetItemClickProcessor$QQBrowserAction(SheetItemClickProcessor paramSheetItemClickProcessor1, Activity paramActivity, SheetItemClickProcessor paramSheetItemClickProcessor2, JSONObject paramJSONObject)
  {
    super(paramSheetItemClickProcessor1, paramActivity, paramSheetItemClickProcessor2, paramJSONObject);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, int paramInt)
  {
    if ((paramString2 != null) && (paramString2.contains("kandianshare.html5.qq.com")))
    {
      SheetItemClickProcessor.a(this.a).mShareHelper.a(paramString2);
      return;
    }
    SheetItemClickProcessor.a(this.a).mShareHelper.a(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.SheetItemClickProcessor.QQBrowserAction
 * JD-Core Version:    0.7.0.1
 */