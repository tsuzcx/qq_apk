package com.tencent.mobileqq.kandian.glue.viola.modules;

import android.app.Activity;
import android.content.ClipboardManager;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import org.json.JSONObject;

public class SheetItemClickProcessor$CopyLinkAction
  extends SheetItemClickProcessor.ClickAction
{
  SheetItemClickProcessor$CopyLinkAction(SheetItemClickProcessor paramSheetItemClickProcessor1, Activity paramActivity, SheetItemClickProcessor paramSheetItemClickProcessor2, JSONObject paramJSONObject)
  {
    super(paramSheetItemClickProcessor1, paramActivity, paramSheetItemClickProcessor2, paramJSONObject);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, int paramInt)
  {
    paramString3 = (ClipboardManager)this.b.getSystemService("clipboard");
    if ((paramString2 != null) && (paramString2.contains("kandianshare.html5.qq.com"))) {
      paramString3.setText(paramString2);
    } else {
      paramString3.setText(paramString1);
    }
    QRUtils.a(2, 2131888247);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.SheetItemClickProcessor.CopyLinkAction
 * JD-Core Version:    0.7.0.1
 */