package com.tencent.vas.update.entity.db;

import android.text.TextUtils;
import com.tencent.vas.update.callback.IVasLog;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;
import org.json.JSONObject;

public class ItemLocalVerPrt
{
  private static final String TAG = "VasUpdate_ItemLocalVerPrt";
  public String mItemId;
  public String mMd5;
  
  public static String convertItemLocalVerPrtToJson(ItemLocalVerPrt paramItemLocalVerPrt)
  {
    if (paramItemLocalVerPrt == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("itemId", paramItemLocalVerPrt.mItemId);
      localJSONObject.put("md5", paramItemLocalVerPrt.mMd5);
      return localJSONObject.toString();
    }
    catch (Exception paramItemLocalVerPrt)
    {
      for (;;)
      {
        paramItemLocalVerPrt.printStackTrace();
        VasUpdateWrapper.getLog().e("VasUpdate_ItemLocalVerPrt", "ItemLocal convertJson error ", paramItemLocalVerPrt);
      }
    }
  }
  
  public static ItemLocalVerPrt parseJsonToItemLocalVerPrt(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    ItemLocalVerPrt localItemLocalVerPrt = new ItemLocalVerPrt();
    try
    {
      paramString = new JSONObject(paramString);
      localItemLocalVerPrt.mItemId = paramString.optString("itemId");
      localItemLocalVerPrt.mMd5 = paramString.optString("md5");
      return localItemLocalVerPrt;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      VasUpdateWrapper.getLog().e("VasUpdate_ItemLocalVerPrt", "ItemLocal parseJson error ", paramString);
    }
    return localItemLocalVerPrt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.vas.update.entity.db.ItemLocalVerPrt
 * JD-Core Version:    0.7.0.1
 */