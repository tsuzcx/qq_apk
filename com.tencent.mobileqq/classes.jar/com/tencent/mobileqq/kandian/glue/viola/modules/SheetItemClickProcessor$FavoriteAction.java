package com.tencent.mobileqq.kandian.glue.viola.modules;

import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import cooperation.qqfav.QfavBuilder;
import org.json.JSONObject;

public class SheetItemClickProcessor$FavoriteAction
  extends SheetItemClickProcessor.ClickAction
{
  SheetItemClickProcessor$FavoriteAction(SheetItemClickProcessor paramSheetItemClickProcessor1, Activity paramActivity, SheetItemClickProcessor paramSheetItemClickProcessor2, JSONObject paramJSONObject)
  {
    super(paramSheetItemClickProcessor1, paramActivity, paramSheetItemClickProcessor2, paramJSONObject);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, int paramInt)
  {
    paramString1 = (QQAppInterface)ReadInJoyUtils.a();
    if (paramString1 != null)
    {
      paramString1 = paramString1.getAccount();
      paramString2 = this.jdField_a_of_type_OrgJsonJSONObject.optString("title");
      paramString3 = this.jdField_a_of_type_OrgJsonJSONObject.optString("desc");
      paramActionSheetItem = this.jdField_a_of_type_OrgJsonJSONObject.optString("image_url");
      QfavBuilder.a(0, paramString2, this.jdField_a_of_type_OrgJsonJSONObject.optString("share_url"), null, paramString3, paramActionSheetItem, null, null, false, -1L).c(paramString1).b(this.jdField_a_of_type_AndroidAppActivity, paramString1, 2, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.SheetItemClickProcessor.FavoriteAction
 * JD-Core Version:    0.7.0.1
 */