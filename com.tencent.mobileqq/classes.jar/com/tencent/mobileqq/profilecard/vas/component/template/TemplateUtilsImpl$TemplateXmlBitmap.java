package com.tencent.mobileqq.profilecard.vas.component.template;

import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.profilecard.template.ITemplateUtils;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

class TemplateUtilsImpl$TemplateXmlBitmap
{
  static Drawable invoke(ITemplateUtils paramITemplateUtils, ProfileCardTemplate paramProfileCardTemplate, JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has("src")))
    {
      Object localObject = paramJSONObject.optString("src");
      if ((localObject != null) && (((String)localObject).length() > 0))
      {
        paramITemplateUtils = (BitmapDrawable)paramITemplateUtils.getTemplateDrawable(paramProfileCardTemplate, true, false, (String)localObject);
        localObject = paramJSONObject.keys();
        if (paramITemplateUtils != null)
        {
          while (((Iterator)localObject).hasNext()) {
            setDrawableAttr(paramProfileCardTemplate, paramJSONObject, paramITemplateUtils, (Iterator)localObject);
          }
          return paramITemplateUtils;
        }
      }
    }
    return null;
  }
  
  private static void setDrawableAttr(ProfileCardTemplate paramProfileCardTemplate, JSONObject paramJSONObject, BitmapDrawable paramBitmapDrawable, Iterator<String> paramIterator)
  {
    paramProfileCardTemplate = (String)paramIterator.next();
    if (paramProfileCardTemplate.equalsIgnoreCase("antialias"))
    {
      paramBitmapDrawable.setAntiAlias(paramJSONObject.optBoolean("antialias"));
      return;
    }
    if (paramProfileCardTemplate.equalsIgnoreCase("dither"))
    {
      paramBitmapDrawable.setDither(paramJSONObject.optBoolean("dither"));
      return;
    }
    if (paramProfileCardTemplate.equalsIgnoreCase("filter"))
    {
      paramBitmapDrawable.setFilterBitmap(paramJSONObject.optBoolean("filter"));
      return;
    }
    if (paramProfileCardTemplate.equalsIgnoreCase("gravity"))
    {
      paramProfileCardTemplate = paramJSONObject.optString("gravity").toLowerCase();
      if ((!TextUtils.isEmpty(paramProfileCardTemplate)) && (ProfileCardTemplate.GRAVITY_MAP.containsKey(paramProfileCardTemplate))) {
        paramBitmapDrawable.setGravity(((Integer)ProfileCardTemplate.GRAVITY_MAP.get(paramProfileCardTemplate)).intValue());
      }
    }
    else if (paramProfileCardTemplate.equalsIgnoreCase("tileMode"))
    {
      paramProfileCardTemplate = paramJSONObject.optString("tileMode", "disabled").toLowerCase();
      if ((!TextUtils.isEmpty(paramProfileCardTemplate)) && (ProfileCardTemplate.TILE_MODE_MAP.containsKey(paramProfileCardTemplate)))
      {
        paramProfileCardTemplate = (Shader.TileMode)ProfileCardTemplate.TILE_MODE_MAP.get(paramProfileCardTemplate);
        paramBitmapDrawable.setTileModeXY(paramProfileCardTemplate, paramProfileCardTemplate);
        return;
      }
      paramBitmapDrawable.setTileModeXY(null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.component.template.TemplateUtilsImpl.TemplateXmlBitmap
 * JD-Core Version:    0.7.0.1
 */