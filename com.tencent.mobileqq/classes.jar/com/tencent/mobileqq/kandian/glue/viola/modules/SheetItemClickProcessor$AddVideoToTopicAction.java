package com.tencent.mobileqq.kandian.glue.viola.modules;

import android.app.Activity;
import com.tencent.mobileqq.kandian.biz.ugc.RIJUgcUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaInstance;
import org.json.JSONObject;

public class SheetItemClickProcessor$AddVideoToTopicAction
  extends SheetItemClickProcessor.ClickAction
{
  SheetItemClickProcessor$AddVideoToTopicAction(SheetItemClickProcessor paramSheetItemClickProcessor1, Activity paramActivity, SheetItemClickProcessor paramSheetItemClickProcessor2, JSONObject paramJSONObject)
  {
    super(paramSheetItemClickProcessor1, paramActivity, paramSheetItemClickProcessor2, paramJSONObject);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, int paramInt)
  {
    paramString1 = this.jdField_a_of_type_OrgJsonJSONObject.optString("rowkey", "");
    paramInt = this.jdField_a_of_type_OrgJsonJSONObject.optInt("from_page");
    if (paramString1.isEmpty())
    {
      paramString2 = SheetItemClickProcessor.a;
      paramString3 = new StringBuilder();
      paramString3.append("click add video to topic fail, rowkey=");
      paramString3.append(paramString1);
      QLog.e(paramString2, 1, paramString3.toString());
      return;
    }
    RIJUgcUtils.b(SheetItemClickProcessor.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesSheetItemClickProcessor).getViolaInstance().getActivity(), paramString1, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.SheetItemClickProcessor.AddVideoToTopicAction
 * JD-Core Version:    0.7.0.1
 */