package com.tencent.plato.sdk.element;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.plato.IPlatoRuntime;
import com.tencent.plato.core.utils.Ev;
import com.tencent.plato.core.utils.PLog;
import com.tencent.plato.layout.LayoutEngine;
import com.tencent.plato.layout.PDisplay;
import com.tencent.plato.layout.PMeasureFunction;
import com.tencent.plato.layout.PMeasureFunction.MeasureValue;
import com.tencent.plato.layout.PMeasureMode;
import com.tencent.plato.layout.PlatoNode;
import com.tencent.plato.sdk.render.PImageView;
import com.tencent.plato.sdk.utils.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class PImgElement
  extends PElement
{
  String src;
  
  public PImgElement(LayoutEngine paramLayoutEngine, int paramInt)
  {
    super(paramLayoutEngine, paramInt);
    setMeasureFunction(new ViewMeasureFunction());
  }
  
  public JSONObject dumpNode(JSONObject paramJSONObject)
  {
    localJSONObject2 = super.dumpNode(paramJSONObject);
    try
    {
      Object localObject = localJSONObject2.optJSONObject("attributes");
      paramJSONObject = (JSONObject)localObject;
      if (localObject == null)
      {
        paramJSONObject = new JSONObject();
        localJSONObject2.put("attributes", paramJSONObject);
      }
      JSONObject localJSONObject1 = paramJSONObject.optJSONObject("style");
      localObject = localJSONObject1;
      if (localJSONObject1 == null)
      {
        localObject = new JSONObject();
        paramJSONObject.put("style", localObject);
      }
      if (!TextUtils.isEmpty(this.src)) {
        paramJSONObject.put("src", this.src);
      }
      if (this.mNode.getDisplay() == PDisplay.FLEX) {
        ((JSONObject)localObject).put("display", "flex");
      }
      for (;;)
      {
        if ((this.width != null) && (!Float.isNaN(this.width.px))) {
          ((JSONObject)localObject).put("width", Dimension.devicePx2RemPx(this.width.px) + "px");
        }
        if ((this.height == null) || (Float.isNaN(this.height.px))) {
          break;
        }
        ((JSONObject)localObject).put("height", Dimension.devicePx2RemPx(this.height.px) + "px");
        return localJSONObject2;
        if (this.mNode.getDisplay() == PDisplay.NONE) {
          ((JSONObject)localObject).put("display", "none");
        }
      }
      return localJSONObject2;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public String getElementType()
  {
    return "image";
  }
  
  public boolean isLeafNode()
  {
    return true;
  }
  
  @Property("resizeMode")
  public void resizeMode(String paramString)
  {
    addUIStyle("resizeMode", paramString);
  }
  
  @Property("src")
  public void setSrc(IPlatoRuntime paramIPlatoRuntime, String paramString)
  {
    String str1 = paramString;
    String str2;
    if (!paramString.startsWith("http://"))
    {
      str1 = paramString;
      if (!paramString.startsWith("https://"))
      {
        str1 = paramString;
        if (!paramString.startsWith("data:image/"))
        {
          str1 = paramString;
          str2 = str1;
          if (paramString.startsWith("/")) {}
        }
      }
    }
    try
    {
      str2 = new File(paramIPlatoRuntime.getPath(), paramString).getCanonicalPath();
      str1 = "file://" + str2;
      this.src = str1;
      addUIStyle("src", this.src);
      this.mNode.dirty();
      return;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        paramString = "setSrc error." + Log.getStackTraceString(paramString);
        if (paramIPlatoRuntime != null) {
          paramIPlatoRuntime.onPlatoException(paramString);
        }
        PLog.e(paramString);
        str2 = str1;
      }
    }
  }
  
  public static class Provider
    implements IElement.IProvider<PImgElement, PImageView>
  {
    public PImgElement createElement(LayoutEngine paramLayoutEngine, int paramInt)
    {
      return new PImgElement(paramLayoutEngine, paramInt);
    }
    
    public PImageView createView()
    {
      return new PImageView();
    }
    
    public String getName()
    {
      return "image";
    }
  }
  
  public class ViewMeasureFunction
    implements PMeasureFunction
  {
    public ViewMeasureFunction() {}
    
    public PMeasureFunction.MeasureValue onMeasure(PlatoNode paramPlatoNode, float paramFloat1, PMeasureMode paramPMeasureMode1, float paramFloat2, PMeasureMode paramPMeasureMode2)
    {
      f1 = -1.0F;
      f2 = -1.0F;
      if (PImgElement.this.width != null)
      {
        if (!Float.isNaN(PImgElement.this.width.px)) {
          break label252;
        }
        if (paramPMeasureMode1 == PMeasureMode.AT_MOST) {
          f1 = (float)(PImgElement.this.width.percent * paramFloat1 / 100.0D);
        }
      }
      else
      {
        paramFloat1 = f2;
        if (PImgElement.this.height != null)
        {
          if (!Float.isNaN(PImgElement.this.height.px)) {
            break label273;
          }
          if (paramPMeasureMode2 != PMeasureMode.AT_MOST) {
            break label267;
          }
          paramFloat1 = (float)(PImgElement.this.height.percent * paramFloat2 / 100.0D);
        }
        label118:
        paramPMeasureMode1 = new BitmapFactory.Options();
        paramPMeasureMode1.inJustDecodeBounds = true;
      }
      for (;;)
      {
        try
        {
          if (!PImgElement.this.src.startsWith("file:///android_asset/")) {
            continue;
          }
          paramPlatoNode = Ev.appContext().getAssets().open(PImgElement.this.src.substring("file:///android_asset/".length()));
          BitmapFactory.decodeStream(paramPlatoNode, null, paramPMeasureMode1);
        }
        catch (IOException paramPlatoNode)
        {
          label252:
          PLog.e("Pimg decode error. " + Log.getStackTraceString(paramPlatoNode));
          label267:
          label273:
          continue;
          int i = 100;
          continue;
          int j = 100;
          continue;
          if ((paramFloat1 <= 0.0F) || (f1 != -1.0F)) {
            continue;
          }
          f2 = i * paramFloat1 / j;
          paramFloat2 = paramFloat1;
          continue;
          paramFloat2 = paramFloat1;
          f2 = f1;
          if (f1 != -1.0F) {
            continue;
          }
          paramFloat2 = paramFloat1;
          f2 = f1;
          if (paramFloat1 != -1.0F) {
            continue;
          }
          f2 = i;
          paramFloat2 = j;
          continue;
        }
        if (paramPMeasureMode1.outWidth <= 0) {
          continue;
        }
        i = paramPMeasureMode1.outWidth;
        if (paramPMeasureMode1.outHeight <= 0) {
          continue;
        }
        j = paramPMeasureMode1.outHeight;
        if ((f1 <= 0.0F) || (paramFloat1 != -1.0F)) {
          continue;
        }
        paramFloat2 = j * f1 / i;
        f2 = f1;
        return new PMeasureFunction.MeasureValue(f2, paramFloat2);
        f1 = paramFloat1;
        break;
        f1 = PImgElement.this.width.px;
        break;
        paramFloat1 = paramFloat2;
        break label118;
        paramFloat1 = PImgElement.this.height.px;
        break label118;
        paramPlatoNode = new FileInputStream(PImgElement.this.src.substring("file://".length()));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.sdk.element.PImgElement
 * JD-Core Version:    0.7.0.1
 */