package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.etrump.mixlayout.ETDIYConfig;
import com.etrump.mixlayout.ETDIYUtil;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.ETSubstitutionConfig;
import com.etrump.mixlayout.ETTextView;
import com.google.gson.Gson;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.adapter.SignatureFontAdapter;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

class ThemeAndBubbleCommonJsPlugin$HYDIYFontJsHandler
{
  private static int VIEW_ID = 1;
  
  private void controlETTextView(JSONObject paramJSONObject, String paramString, ThemeAndBubbleCommonJsPlugin.HYDIYFontJsHandler.DealETTextView paramDealETTextView, ThemeAndBubbleCommonJsPlugin paramThemeAndBubbleCommonJsPlugin)
  {
    int i = ((Integer)findAndDealView(paramJSONObject.optInt("viewID", 0), paramDealETTextView, paramThemeAndBubbleCommonJsPlugin)).intValue();
    try
    {
      paramJSONObject = new JSONObject();
      paramJSONObject.put("result", i);
      paramDealETTextView = new JSONObject();
      paramDealETTextView.put("result", 0);
      paramDealETTextView.put("message", "ok");
      paramDealETTextView.put("data", paramJSONObject);
      paramThemeAndBubbleCommonJsPlugin.callJs(paramString + "(" + paramDealETTextView.toString() + ");");
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private Object findAndDealView(int paramInt, ThemeAndBubbleCommonJsPlugin.HYDIYFontJsHandler.DealETTextView paramDealETTextView, ThemeAndBubbleCommonJsPlugin paramThemeAndBubbleCommonJsPlugin)
  {
    if ((paramThemeAndBubbleCommonJsPlugin == null) || (paramThemeAndBubbleCommonJsPlugin.mRuntime == null)) {
      return "";
    }
    paramThemeAndBubbleCommonJsPlugin = paramThemeAndBubbleCommonJsPlugin.mRuntime.a();
    if (!(paramThemeAndBubbleCommonJsPlugin instanceof QQBrowserActivity)) {
      return "";
    }
    paramThemeAndBubbleCommonJsPlugin = ((QQBrowserActivity)paramThemeAndBubbleCommonJsPlugin).getRootView();
    int i = 0;
    while (i < paramThemeAndBubbleCommonJsPlugin.getChildCount())
    {
      View localView = paramThemeAndBubbleCommonJsPlugin.getChildAt(i);
      if (((localView instanceof ETTextView)) && (localView.getTag() != null) && (paramInt == ((Integer)localView.getTag()).intValue())) {
        return paramDealETTextView.deal(paramThemeAndBubbleCommonJsPlugin, (ETTextView)localView);
      }
      i += 1;
    }
    return "";
  }
  
  private String getDrawingCacheIamge(ETTextView paramETTextView)
  {
    if (paramETTextView.getVisibility() != 0) {
      return "";
    }
    paramETTextView.setDrawingCacheEnabled(true);
    Object localObject2 = Bitmap.createBitmap(paramETTextView.getDrawingCache(), 0, 0, paramETTextView.getWidth(), paramETTextView.getHeight());
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        ((Bitmap)localObject2).compress(Bitmap.CompressFormat.PNG, 40, localByteArrayOutputStream);
        localObject2 = Base64.encode(localByteArrayOutputStream.toByteArray(), 0);
        localObject1 = localObject2;
        localObject2 = localObject1;
        if (localByteArrayOutputStream == null) {}
      }
      catch (Exception localException)
      {
        Object localObject3;
        localException.printStackTrace();
        Object localObject4 = localObject1;
        if (localByteArrayOutputStream == null) {
          continue;
        }
        try
        {
          localByteArrayOutputStream.flush();
          localByteArrayOutputStream.close();
          localObject4 = localObject1;
        }
        catch (IOException localIOException3)
        {
          localIOException3.printStackTrace();
          localObject5 = localObject1;
        }
        continue;
      }
      finally
      {
        if (localByteArrayOutputStream == null) {
          continue;
        }
        try
        {
          localByteArrayOutputStream.flush();
          localByteArrayOutputStream.close();
          throw paramETTextView;
        }
        catch (IOException localIOException1)
        {
          localIOException1.printStackTrace();
          continue;
        }
      }
      try
      {
        localByteArrayOutputStream.flush();
        localByteArrayOutputStream.close();
        localObject2 = localObject1;
      }
      catch (IOException localIOException2)
      {
        localIOException2.printStackTrace();
        localObject3 = localObject1;
      }
    }
    paramETTextView.setDrawingCacheEnabled(false);
    if (localObject2 == null) {
      return "";
    }
    Object localObject5;
    return "data:image/png;base64," + new String(localObject5);
  }
  
  @Nullable
  private ETTextView getEtTextView(int paramInt, String paramString, ThemeAndBubbleCommonJsPlugin.HYDIYFontJsHandler.AddViewData paramAddViewData, Activity paramActivity)
  {
    Object localObject = paramActivity.getResources();
    int i = ((Resources)localObject).getDimensionPixelSize(((Resources)localObject).getIdentifier("status_bar_height", "dimen", "android"));
    FrameLayout localFrameLayout = ((QQBrowserActivity)paramActivity).getRootView();
    localObject = new ETTextView(paramActivity);
    ((ETTextView)localObject).setGravity(1);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(AIOUtils.a(paramAddViewData.width, paramActivity.getResources()), AIOUtils.a(paramAddViewData.height, paramActivity.getResources()));
    localLayoutParams.leftMargin = AIOUtils.a(paramAddViewData.x, paramActivity.getResources());
    localLayoutParams.topMargin = (i + AIOUtils.a(paramAddViewData.y, paramActivity.getResources()));
    ((ETTextView)localObject).setPadding(AIOUtils.a(paramAddViewData.params.contentLeft, paramActivity.getResources()), AIOUtils.a(paramAddViewData.params.contentTop, paramActivity.getResources()), AIOUtils.a(paramAddViewData.params.contentLeft, paramActivity.getResources()), AIOUtils.a(paramAddViewData.params.contentTop, paramActivity.getResources()));
    paramActivity = new SignatureFontAdapter(((QQBrowserActivity)paramActivity).getAppInterface(), paramAddViewData.params.fontID, 1);
    paramActivity.a(-1);
    paramActivity.a((ETTextView)localObject, paramAddViewData.params.fontSize, true);
    paramActivity.a(paramAddViewData.params.fontID, 1);
    ((ETTextView)localObject).setTextSize(paramAddViewData.params.fontSize);
    ((ETTextView)localObject).setText(paramAddViewData.params.text);
    ((ETTextView)localObject).setTag(Integer.valueOf(paramInt));
    ((ETTextView)localObject).bringToFront();
    localFrameLayout.addView((View)localObject, localLayoutParams);
    if (((ETTextView)localObject).mFont == null) {
      return null;
    }
    paramString = ETDIYConfig.a(paramAddViewData.params.fontID, paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      long l = ETSubstitutionConfig.a(((ETTextView)localObject).mFont, paramString);
      ((ETTextView)localObject).mFont.set_substitution(l);
    }
    paramAddViewData = ((ETTextView)localObject).mFont.getPath().split(File.separator);
    paramString = "";
    paramInt = 0;
    while (paramInt < paramAddViewData.length - 1)
    {
      paramString = paramString + paramAddViewData[paramInt] + File.separator;
      paramInt += 1;
    }
    try
    {
      ((ETTextView)localObject).setBackground(URLDrawable.getFileDrawable(paramString + "previewBubble.9.png", null));
      return localObject;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void addView(JSONObject paramJSONObject, String paramString, ThemeAndBubbleCommonJsPlugin paramThemeAndBubbleCommonJsPlugin)
  {
    int i = VIEW_ID;
    VIEW_ID = i + 1;
    Object localObject = i + "";
    if ((paramThemeAndBubbleCommonJsPlugin == null) || (paramThemeAndBubbleCommonJsPlugin.mRuntime == null)) {}
    do
    {
      Activity localActivity;
      do
      {
        return;
        paramJSONObject = (ThemeAndBubbleCommonJsPlugin.HYDIYFontJsHandler.AddViewData)new Gson().fromJson(paramJSONObject.toString(), ThemeAndBubbleCommonJsPlugin.HYDIYFontJsHandler.AddViewData.class);
        localActivity = paramThemeAndBubbleCommonJsPlugin.mRuntime.a();
      } while ((!(localActivity instanceof QQBrowserActivity)) || (paramJSONObject == null) || (paramJSONObject.params == null) || (paramJSONObject.params.fontType != 1));
      String[] arrayOfString = paramJSONObject.params.image.split(",");
      if (arrayOfString.length == 2) {
        ETDIYUtil.b.put(localObject, arrayOfString[1]);
      }
      localObject = getEtTextView(i, (String)localObject, paramJSONObject, localActivity);
    } while (localObject == null);
    try
    {
      paramJSONObject = new JSONObject();
      paramJSONObject.put("viewID", ((ETTextView)localObject).getTag());
      localObject = new JSONObject();
      ((JSONObject)localObject).put("result", 0);
      ((JSONObject)localObject).put("message", "ok");
      ((JSONObject)localObject).put("data", paramJSONObject);
      paramThemeAndBubbleCommonJsPlugin.callJs(paramString + "(" + ((JSONObject)localObject).toString() + ");");
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public void getViewShot(JSONObject paramJSONObject, String paramString, ThemeAndBubbleCommonJsPlugin paramThemeAndBubbleCommonJsPlugin)
  {
    if (paramThemeAndBubbleCommonJsPlugin == null) {
      return;
    }
    Object localObject = (String)findAndDealView(paramJSONObject.optInt("viewID", 0), new ThemeAndBubbleCommonJsPlugin.HYDIYFontJsHandler.2(this), paramThemeAndBubbleCommonJsPlugin);
    try
    {
      paramJSONObject = new JSONObject();
      paramJSONObject.put("image", localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("result", 0);
      ((JSONObject)localObject).put("message", "ok");
      ((JSONObject)localObject).put("data", paramJSONObject);
      paramThemeAndBubbleCommonJsPlugin.callJs(paramString + "(" + ((JSONObject)localObject).toString() + ");");
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public boolean handler(String paramString1, JSONObject paramJSONObject, String paramString2, ThemeAndBubbleCommonJsPlugin paramThemeAndBubbleCommonJsPlugin)
  {
    if ("addView".equals(paramString1)) {
      addView(paramJSONObject, paramString2, paramThemeAndBubbleCommonJsPlugin);
    }
    for (;;)
    {
      return true;
      if ("getViewShot".equals(paramString1))
      {
        ThreadManagerV2.executeOnSubThread(new ThemeAndBubbleCommonJsPlugin.HYDIYFontJsHandler.1(this, paramJSONObject, paramString2, paramThemeAndBubbleCommonJsPlugin));
      }
      else if ("removeView".equals(paramString1))
      {
        removeView(paramJSONObject, paramString2, paramThemeAndBubbleCommonJsPlugin);
      }
      else if ("hiddenView".equals(paramString1))
      {
        hiddenView(paramJSONObject, paramString2, paramThemeAndBubbleCommonJsPlugin);
      }
      else
      {
        if (!"showView".equals(paramString1)) {
          break;
        }
        showView(paramJSONObject, paramString2, paramThemeAndBubbleCommonJsPlugin);
      }
    }
    return false;
  }
  
  public void hiddenView(JSONObject paramJSONObject, String paramString, ThemeAndBubbleCommonJsPlugin paramThemeAndBubbleCommonJsPlugin)
  {
    controlETTextView(paramJSONObject, paramString, new ThemeAndBubbleCommonJsPlugin.HYDIYFontJsHandler.4(this), paramThemeAndBubbleCommonJsPlugin);
  }
  
  public void removeView(JSONObject paramJSONObject, String paramString, ThemeAndBubbleCommonJsPlugin paramThemeAndBubbleCommonJsPlugin)
  {
    controlETTextView(paramJSONObject, paramString, new ThemeAndBubbleCommonJsPlugin.HYDIYFontJsHandler.3(this), paramThemeAndBubbleCommonJsPlugin);
  }
  
  public void showView(JSONObject paramJSONObject, String paramString, ThemeAndBubbleCommonJsPlugin paramThemeAndBubbleCommonJsPlugin)
  {
    controlETTextView(paramJSONObject, paramString, new ThemeAndBubbleCommonJsPlugin.HYDIYFontJsHandler.5(this), paramThemeAndBubbleCommonJsPlugin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ThemeAndBubbleCommonJsPlugin.HYDIYFontJsHandler
 * JD-Core Version:    0.7.0.1
 */