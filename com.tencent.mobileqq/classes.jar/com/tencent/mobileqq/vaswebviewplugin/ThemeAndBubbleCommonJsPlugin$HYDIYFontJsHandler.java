package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.etrump.mixlayout.ETDIYConfig;
import com.etrump.mixlayout.ETDIYUtil;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.ETSubstitutionConfig;
import com.etrump.mixlayout.ETTextView;
import com.google.gson.Gson;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.adapter.SignatureFontAdapter;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import java.io.File;
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
      paramDealETTextView = new JSONObject();
      paramDealETTextView.put("result", i);
      paramJSONObject = new JSONObject();
      paramJSONObject.put("result", 0);
      paramJSONObject.put("message", "ok");
      paramJSONObject.put("data", paramDealETTextView);
      paramDealETTextView = new StringBuilder();
      paramDealETTextView.append(paramString);
      paramDealETTextView.append("(");
      paramDealETTextView.append(paramJSONObject.toString());
      paramDealETTextView.append(");");
      paramThemeAndBubbleCommonJsPlugin.callJs(paramDealETTextView.toString());
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private Object findAndDealView(int paramInt, ThemeAndBubbleCommonJsPlugin.HYDIYFontJsHandler.DealETTextView paramDealETTextView, ThemeAndBubbleCommonJsPlugin paramThemeAndBubbleCommonJsPlugin)
  {
    if (paramThemeAndBubbleCommonJsPlugin != null)
    {
      if (paramThemeAndBubbleCommonJsPlugin.mRuntime == null) {
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
    }
    return "";
  }
  
  /* Error */
  private String getDrawingCacheIamge(ETTextView paramETTextView)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 130	com/etrump/mixlayout/ETTextView:getVisibility	()I
    //   4: ifeq +6 -> 10
    //   7: ldc 88
    //   9: areturn
    //   10: aload_1
    //   11: iconst_1
    //   12: invokevirtual 134	com/etrump/mixlayout/ETTextView:setDrawingCacheEnabled	(Z)V
    //   15: aload_1
    //   16: invokevirtual 138	com/etrump/mixlayout/ETTextView:getDrawingCache	()Landroid/graphics/Bitmap;
    //   19: iconst_0
    //   20: iconst_0
    //   21: aload_1
    //   22: invokevirtual 141	com/etrump/mixlayout/ETTextView:getWidth	()I
    //   25: aload_1
    //   26: invokevirtual 144	com/etrump/mixlayout/ETTextView:getHeight	()I
    //   29: invokestatic 150	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   32: astore_2
    //   33: new 152	java/io/ByteArrayOutputStream
    //   36: dup
    //   37: invokespecial 153	java/io/ByteArrayOutputStream:<init>	()V
    //   40: astore 6
    //   42: aconst_null
    //   43: astore 5
    //   45: aconst_null
    //   46: astore 4
    //   48: aload_2
    //   49: getstatic 159	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   52: bipush 40
    //   54: aload 6
    //   56: invokevirtual 163	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   59: pop
    //   60: aload 6
    //   62: invokevirtual 167	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   65: iconst_0
    //   66: invokestatic 173	android/util/Base64:encode	([BI)[B
    //   69: astore_3
    //   70: aload_3
    //   71: astore_2
    //   72: aload 6
    //   74: invokevirtual 176	java/io/ByteArrayOutputStream:flush	()V
    //   77: aload_3
    //   78: astore_2
    //   79: aload 6
    //   81: invokevirtual 179	java/io/ByteArrayOutputStream:close	()V
    //   84: aload_3
    //   85: astore_2
    //   86: goto +39 -> 125
    //   89: astore_3
    //   90: aload_3
    //   91: invokevirtual 180	java/io/IOException:printStackTrace	()V
    //   94: goto +31 -> 125
    //   97: astore_1
    //   98: goto +72 -> 170
    //   101: astore_2
    //   102: aload_2
    //   103: invokevirtual 181	java/lang/Exception:printStackTrace	()V
    //   106: aload 4
    //   108: astore_2
    //   109: aload 6
    //   111: invokevirtual 176	java/io/ByteArrayOutputStream:flush	()V
    //   114: aload 4
    //   116: astore_2
    //   117: aload 6
    //   119: invokevirtual 179	java/io/ByteArrayOutputStream:close	()V
    //   122: aload 5
    //   124: astore_2
    //   125: aload_1
    //   126: iconst_0
    //   127: invokevirtual 134	com/etrump/mixlayout/ETTextView:setDrawingCacheEnabled	(Z)V
    //   130: aload_2
    //   131: ifnonnull +6 -> 137
    //   134: ldc 88
    //   136: areturn
    //   137: new 59	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   144: astore_1
    //   145: aload_1
    //   146: ldc 183
    //   148: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: aload_1
    //   153: new 185	java/lang/String
    //   156: dup
    //   157: aload_2
    //   158: invokespecial 188	java/lang/String:<init>	([B)V
    //   161: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload_1
    //   166: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: areturn
    //   170: aload 6
    //   172: invokevirtual 176	java/io/ByteArrayOutputStream:flush	()V
    //   175: aload 6
    //   177: invokevirtual 179	java/io/ByteArrayOutputStream:close	()V
    //   180: goto +8 -> 188
    //   183: astore_2
    //   184: aload_2
    //   185: invokevirtual 180	java/io/IOException:printStackTrace	()V
    //   188: aload_1
    //   189: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	this	HYDIYFontJsHandler
    //   0	190	1	paramETTextView	ETTextView
    //   32	54	2	localObject1	Object
    //   101	2	2	localException	Exception
    //   108	50	2	localObject2	Object
    //   183	2	2	localIOException1	java.io.IOException
    //   69	16	3	arrayOfByte	byte[]
    //   89	2	3	localIOException2	java.io.IOException
    //   46	69	4	localObject3	Object
    //   43	80	5	localObject4	Object
    //   40	136	6	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   72	77	89	java/io/IOException
    //   79	84	89	java/io/IOException
    //   109	114	89	java/io/IOException
    //   117	122	89	java/io/IOException
    //   48	70	97	finally
    //   102	106	97	finally
    //   48	70	101	java/lang/Exception
    //   170	180	183	java/io/IOException
  }
  
  @Nullable
  private ETTextView getEtTextView(int paramInt, String paramString, ThemeAndBubbleCommonJsPlugin.HYDIYFontJsHandler.AddViewData paramAddViewData, Activity paramActivity)
  {
    Object localObject = paramActivity.getResources();
    int i = ((Resources)localObject).getDimensionPixelSize(((Resources)localObject).getIdentifier("status_bar_height", "dimen", "android"));
    QQBrowserActivity localQQBrowserActivity = (QQBrowserActivity)paramActivity;
    FrameLayout localFrameLayout = localQQBrowserActivity.getRootView();
    localObject = new ETTextView(paramActivity);
    ((ETTextView)localObject).setGravity(1);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(AIOUtils.b(paramAddViewData.width, paramActivity.getResources()), AIOUtils.b(paramAddViewData.height, paramActivity.getResources()));
    localLayoutParams.leftMargin = AIOUtils.b(paramAddViewData.x, paramActivity.getResources());
    localLayoutParams.topMargin = (AIOUtils.b(paramAddViewData.y, paramActivity.getResources()) + i);
    ((ETTextView)localObject).setPadding(AIOUtils.b(paramAddViewData.params.contentLeft, paramActivity.getResources()), AIOUtils.b(paramAddViewData.params.contentTop, paramActivity.getResources()), AIOUtils.b(paramAddViewData.params.contentLeft, paramActivity.getResources()), AIOUtils.b(paramAddViewData.params.contentTop, paramActivity.getResources()));
    paramActivity = new SignatureFontAdapter((AppInterface)localQQBrowserActivity.getAppRuntime(), paramAddViewData.params.fontID, 1);
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
    paramInt = 0;
    paramString = "";
    while (paramInt < paramAddViewData.length - 1)
    {
      paramActivity = new StringBuilder();
      paramActivity.append(paramString);
      paramActivity.append(paramAddViewData[paramInt]);
      paramActivity.append(File.separator);
      paramString = paramActivity.toString();
      paramInt += 1;
    }
    try
    {
      paramAddViewData = new StringBuilder();
      paramAddViewData.append(paramString);
      paramAddViewData.append("previewBubble.9.png");
      ((ETTextView)localObject).setBackground(URLDrawable.getFileDrawable(paramAddViewData.toString(), null));
      return localObject;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return localObject;
  }
  
  public void addView(JSONObject paramJSONObject, String paramString, ThemeAndBubbleCommonJsPlugin paramThemeAndBubbleCommonJsPlugin)
  {
    int i = VIEW_ID;
    VIEW_ID = i + 1;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append("");
    localObject = ((StringBuilder)localObject).toString();
    if (paramThemeAndBubbleCommonJsPlugin != null)
    {
      if (paramThemeAndBubbleCommonJsPlugin.mRuntime == null) {
        return;
      }
      paramJSONObject = (ThemeAndBubbleCommonJsPlugin.HYDIYFontJsHandler.AddViewData)new Gson().fromJson(paramJSONObject.toString(), ThemeAndBubbleCommonJsPlugin.HYDIYFontJsHandler.AddViewData.class);
      Activity localActivity = paramThemeAndBubbleCommonJsPlugin.mRuntime.a();
      if (((localActivity instanceof QQBrowserActivity)) && (paramJSONObject != null) && (paramJSONObject.params != null))
      {
        if (paramJSONObject.params.fontType != 1) {
          return;
        }
        String[] arrayOfString = paramJSONObject.params.image.split(",");
        if (arrayOfString.length == 2) {
          ETDIYUtil.b.put(localObject, arrayOfString[1]);
        }
        localObject = getEtTextView(i, (String)localObject, paramJSONObject, localActivity);
        if (localObject == null) {
          return;
        }
        try
        {
          paramJSONObject = new JSONObject();
          paramJSONObject.put("viewID", ((ETTextView)localObject).getTag());
          localObject = new JSONObject();
          ((JSONObject)localObject).put("result", 0);
          ((JSONObject)localObject).put("message", "ok");
          ((JSONObject)localObject).put("data", paramJSONObject);
          paramJSONObject = new StringBuilder();
          paramJSONObject.append(paramString);
          paramJSONObject.append("(");
          paramJSONObject.append(((JSONObject)localObject).toString());
          paramJSONObject.append(");");
          paramThemeAndBubbleCommonJsPlugin.callJs(paramJSONObject.toString());
          return;
        }
        catch (JSONException paramJSONObject)
        {
          paramJSONObject.printStackTrace();
        }
      }
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
      paramJSONObject = new StringBuilder();
      paramJSONObject.append(paramString);
      paramJSONObject.append("(");
      paramJSONObject.append(((JSONObject)localObject).toString());
      paramJSONObject.append(");");
      paramThemeAndBubbleCommonJsPlugin.callJs(paramJSONObject.toString());
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public boolean handler(String paramString1, JSONObject paramJSONObject, String paramString2, ThemeAndBubbleCommonJsPlugin paramThemeAndBubbleCommonJsPlugin)
  {
    if ("addView".equals(paramString1))
    {
      addView(paramJSONObject, paramString2, paramThemeAndBubbleCommonJsPlugin);
    }
    else if ("getViewShot".equals(paramString1))
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
        break label111;
      }
      showView(paramJSONObject, paramString2, paramThemeAndBubbleCommonJsPlugin);
    }
    return true;
    label111:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ThemeAndBubbleCommonJsPlugin.HYDIYFontJsHandler
 * JD-Core Version:    0.7.0.1
 */