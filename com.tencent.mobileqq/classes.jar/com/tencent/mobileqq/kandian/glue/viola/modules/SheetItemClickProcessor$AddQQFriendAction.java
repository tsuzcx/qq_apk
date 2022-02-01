package com.tencent.mobileqq.kandian.glue.viola.modules;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import org.json.JSONObject;

public class SheetItemClickProcessor$AddQQFriendAction
  extends SheetItemClickProcessor.ClickAction
{
  SheetItemClickProcessor$AddQQFriendAction(SheetItemClickProcessor paramSheetItemClickProcessor1, Activity paramActivity, SheetItemClickProcessor paramSheetItemClickProcessor2, JSONObject paramJSONObject)
  {
    super(paramSheetItemClickProcessor1, paramActivity, paramSheetItemClickProcessor2, paramJSONObject);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString3))
    {
      paramString1 = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(this.jdField_a_of_type_AndroidAppActivity, 1, paramString3, null, 3096, 1, this.jdField_a_of_type_OrgJsonJSONObject.optString("nick_name"), null, null, null, null);
      ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend(this.jdField_a_of_type_AndroidAppActivity, paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.SheetItemClickProcessor.AddQQFriendAction
 * JD-Core Version:    0.7.0.1
 */