package com.tencent.mobileqq.profilecard.vas.component.template;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.NinePatchDrawable;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.View;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.profile.VipWZRYTemplateConfig;
import com.tencent.mobileqq.profile.VipWZRYTemplateHelper;
import com.tencent.mobileqq.profilecard.template.ITemplateUtils;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.util.ProfileCardTemplateUtil;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class TemplateUtilsImpl
  implements ITemplateUtils
{
  private TemplateUtilsImpl.UpdateViewAttrDispatch updateDispatcher = new TemplateUtilsImpl.UpdateViewAttrDispatch();
  
  private boolean checkValidate(View paramView, String paramString1, ProfileCardTemplate paramProfileCardTemplate, String paramString2)
  {
    if ((paramView != null) && (paramProfileCardTemplate != null) && (!TextUtils.isEmpty(paramString1)))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return false;
      }
      if (ProfileTemplateApi.isDiyTemplateStyleID(paramProfileCardTemplate.styleId)) {
        return false;
      }
      return paramProfileCardTemplate.templateAttr.get(paramString2) != null;
    }
    return false;
  }
  
  private void closeResponse(InputStream paramInputStream)
  {
    if (paramInputStream != null) {
      try
      {
        paramInputStream.close();
        return;
      }
      catch (IOException paramInputStream)
      {
        paramInputStream.printStackTrace();
      }
    }
  }
  
  /* Error */
  private JSONObject loadConfigContent(long paramLong)
  {
    // Byte code:
    //   0: lload_1
    //   1: lconst_1
    //   2: lcmp
    //   3: ifne +10 -> 13
    //   6: ldc 66
    //   8: astore 4
    //   10: goto +7 -> 17
    //   13: ldc 68
    //   15: astore 4
    //   17: new 70	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   24: astore 5
    //   26: aload 5
    //   28: ldc 73
    //   30: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload 5
    //   36: aload 4
    //   38: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload_0
    //   43: aload 5
    //   45: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokespecial 85	com/tencent/mobileqq/profilecard/vas/component/template/TemplateUtilsImpl:profileCardColorLevelDebugQLog	(Ljava/lang/String;)V
    //   51: lload_1
    //   52: lconst_1
    //   53: lcmp
    //   54: ifne +13 -> 67
    //   57: getstatic 89	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:mWhiteStyleConfig	Lorg/json/JSONObject;
    //   60: ifnull +7 -> 67
    //   63: getstatic 89	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:mWhiteStyleConfig	Lorg/json/JSONObject;
    //   66: areturn
    //   67: lload_1
    //   68: lconst_1
    //   69: lcmp
    //   70: ifeq +13 -> 83
    //   73: getstatic 92	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:mBlackStyleConfig	Lorg/json/JSONObject;
    //   76: ifnull +7 -> 83
    //   79: getstatic 92	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:mBlackStyleConfig	Lorg/json/JSONObject;
    //   82: areturn
    //   83: new 70	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   90: astore 5
    //   92: aload 5
    //   94: ldc 94
    //   96: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload 5
    //   102: aload 4
    //   104: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload_0
    //   109: aload 5
    //   111: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokespecial 85	com/tencent/mobileqq/profilecard/vas/component/template/TemplateUtilsImpl:profileCardColorLevelDebugQLog	(Ljava/lang/String;)V
    //   117: ldc2_w 95
    //   120: invokestatic 102	com/tencent/mobileqq/util/ProfileCardTemplateUtil:a	(J)Ljava/lang/String;
    //   123: astore 5
    //   125: aload 5
    //   127: ifnull +309 -> 436
    //   130: aload 5
    //   132: invokevirtual 108	java/lang/String:length	()I
    //   135: ifle +301 -> 436
    //   138: new 70	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   145: astore 6
    //   147: aload 6
    //   149: aload 5
    //   151: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: aload 6
    //   157: getstatic 114	java/io/File:separator	Ljava/lang/String;
    //   160: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload 6
    //   166: aload 4
    //   168: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload 6
    //   174: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: astore 4
    //   179: new 110	java/io/File
    //   182: dup
    //   183: aload 4
    //   185: invokespecial 116	java/io/File:<init>	(Ljava/lang/String;)V
    //   188: astore 4
    //   190: aload 4
    //   192: invokevirtual 120	java/io/File:exists	()Z
    //   195: ifeq +190 -> 385
    //   198: new 122	java/io/FileInputStream
    //   201: dup
    //   202: aload 4
    //   204: invokespecial 125	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   207: astore 4
    //   209: aload 4
    //   211: astore 5
    //   213: new 127	java/io/ByteArrayOutputStream
    //   216: dup
    //   217: invokespecial 128	java/io/ByteArrayOutputStream:<init>	()V
    //   220: astore 6
    //   222: aload 4
    //   224: astore 5
    //   226: sipush 4096
    //   229: newarray byte
    //   231: astore 7
    //   233: aload 4
    //   235: astore 5
    //   237: aload 4
    //   239: aload 7
    //   241: iconst_0
    //   242: sipush 4096
    //   245: invokevirtual 132	java/io/InputStream:read	([BII)I
    //   248: istore_3
    //   249: iload_3
    //   250: iconst_m1
    //   251: if_icmpeq +19 -> 270
    //   254: aload 4
    //   256: astore 5
    //   258: aload 6
    //   260: aload 7
    //   262: iconst_0
    //   263: iload_3
    //   264: invokevirtual 136	java/io/ByteArrayOutputStream:write	([BII)V
    //   267: goto -34 -> 233
    //   270: aload 4
    //   272: astore 5
    //   274: new 104	java/lang/String
    //   277: dup
    //   278: aload 6
    //   280: invokevirtual 140	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   283: ldc 142
    //   285: invokespecial 145	java/lang/String:<init>	([BLjava/lang/String;)V
    //   288: astore 7
    //   290: aload 4
    //   292: astore 6
    //   294: aload 4
    //   296: astore 5
    //   298: aload 7
    //   300: invokevirtual 108	java/lang/String:length	()I
    //   303: ifle +114 -> 417
    //   306: lload_1
    //   307: lconst_1
    //   308: lcmp
    //   309: ifne +37 -> 346
    //   312: aload 4
    //   314: astore 5
    //   316: new 147	org/json/JSONObject
    //   319: dup
    //   320: aload 7
    //   322: invokespecial 148	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   325: putstatic 89	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:mWhiteStyleConfig	Lorg/json/JSONObject;
    //   328: aload 4
    //   330: astore 5
    //   332: getstatic 89	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:mWhiteStyleConfig	Lorg/json/JSONObject;
    //   335: astore 6
    //   337: aload_0
    //   338: aload 4
    //   340: invokespecial 150	com/tencent/mobileqq/profilecard/vas/component/template/TemplateUtilsImpl:closeResponse	(Ljava/io/InputStream;)V
    //   343: aload 6
    //   345: areturn
    //   346: aload 4
    //   348: astore 5
    //   350: new 147	org/json/JSONObject
    //   353: dup
    //   354: aload 7
    //   356: invokespecial 148	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   359: putstatic 92	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:mBlackStyleConfig	Lorg/json/JSONObject;
    //   362: aload 4
    //   364: astore 5
    //   366: getstatic 92	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:mBlackStyleConfig	Lorg/json/JSONObject;
    //   369: astore 6
    //   371: aload_0
    //   372: aload 4
    //   374: invokespecial 150	com/tencent/mobileqq/profilecard/vas/component/template/TemplateUtilsImpl:closeResponse	(Ljava/io/InputStream;)V
    //   377: aload 6
    //   379: areturn
    //   380: astore 6
    //   382: goto +22 -> 404
    //   385: aconst_null
    //   386: astore 6
    //   388: goto +29 -> 417
    //   391: astore 4
    //   393: aconst_null
    //   394: astore 5
    //   396: goto +31 -> 427
    //   399: astore 6
    //   401: aconst_null
    //   402: astore 4
    //   404: aload 4
    //   406: astore 5
    //   408: aload 6
    //   410: invokevirtual 151	java/lang/Exception:printStackTrace	()V
    //   413: aload 4
    //   415: astore 6
    //   417: aload_0
    //   418: aload 6
    //   420: invokespecial 150	com/tencent/mobileqq/profilecard/vas/component/template/TemplateUtilsImpl:closeResponse	(Ljava/io/InputStream;)V
    //   423: aconst_null
    //   424: areturn
    //   425: astore 4
    //   427: aload_0
    //   428: aload 5
    //   430: invokespecial 150	com/tencent/mobileqq/profilecard/vas/component/template/TemplateUtilsImpl:closeResponse	(Ljava/io/InputStream;)V
    //   433: aload 4
    //   435: athrow
    //   436: aconst_null
    //   437: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	438	0	this	TemplateUtilsImpl
    //   0	438	1	paramLong	long
    //   248	16	3	i	int
    //   8	365	4	localObject1	Object
    //   391	1	4	localObject2	Object
    //   402	12	4	localObject3	Object
    //   425	9	4	localObject4	Object
    //   24	405	5	localObject5	Object
    //   145	233	6	localObject6	Object
    //   380	1	6	localException1	Exception
    //   386	1	6	localObject7	Object
    //   399	10	6	localException2	Exception
    //   415	4	6	localObject8	Object
    //   231	124	7	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   213	222	380	java/lang/Exception
    //   226	233	380	java/lang/Exception
    //   237	249	380	java/lang/Exception
    //   258	267	380	java/lang/Exception
    //   274	290	380	java/lang/Exception
    //   298	306	380	java/lang/Exception
    //   316	328	380	java/lang/Exception
    //   332	337	380	java/lang/Exception
    //   350	362	380	java/lang/Exception
    //   366	371	380	java/lang/Exception
    //   179	209	391	finally
    //   179	209	399	java/lang/Exception
    //   213	222	425	finally
    //   226	233	425	finally
    //   237	249	425	finally
    //   258	267	425	finally
    //   274	290	425	finally
    //   298	306	425	finally
    //   316	328	425	finally
    //   332	337	425	finally
    //   350	362	425	finally
    //   366	371	425	finally
    //   408	413	425	finally
  }
  
  private void profileCardColorLevelDebugQLog(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, paramString);
    }
  }
  
  protected Drawable checkBitmapType(String paramString, Drawable paramDrawable, Resources paramResources, Bitmap paramBitmap)
  {
    if (paramString.endsWith(".9.png"))
    {
      byte[] arrayOfByte = paramBitmap.getNinePatchChunk();
      paramString = paramDrawable;
      if (arrayOfByte != null)
      {
        paramString = new NinePatchDrawable(paramResources, paramBitmap, arrayOfByte, new Rect(0, 0, 0, 0), null);
        paramString.setTargetDensity(paramResources.getDisplayMetrics());
        return paramString;
      }
    }
    else if ((!paramString.endsWith(".png")) && (!paramString.endsWith(".jpg")) && (!paramString.endsWith(".jpeg")))
    {
      paramString = paramDrawable;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "getTemplateDrawable file not ");
        return paramDrawable;
      }
    }
    else
    {
      paramString = new BitmapDrawable(paramResources, paramBitmap);
      paramString.setTargetDensity(paramResources.getDisplayMetrics());
    }
    return paramString;
  }
  
  protected Drawable checkCacheDrawable(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (paramBoolean)
    {
      paramString2 = (Pair)GlobalImageCache.a.get(paramString2);
      if ((paramString2 != null) && (paramString2.first != null))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getTemplateDrawable form sImageCache filePath=");
          localStringBuilder.append(paramString1);
          QLog.d("Q.profilecard.FrdProfileCard", 2, localStringBuilder.toString());
        }
        return ((Drawable.ConstantState)paramString2.first).newDrawable();
      }
    }
    return null;
  }
  
  protected Bitmap getBitmap(String paramString1, Resources paramResources, String paramString2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inDensity = 320;
    localOptions.inScreenDensity = paramResources.getDisplayMetrics().densityDpi;
    localOptions.inTargetDensity = paramResources.getDisplayMetrics().densityDpi;
    localOptions.inScaled = true;
    if ((paramString1.endsWith(".jpg")) || (paramString1.endsWith(".jpeg"))) {
      localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
    }
    paramString1 = new BufferedInputStream(new FileInputStream(paramString2));
    paramResources = BitmapFactory.decodeStream(paramString1, null, localOptions);
    paramString1.close();
    if ((paramResources == null) && (QLog.isColorLevel())) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "getTemplateDrawable bitmap is null");
    }
    return paramResources;
  }
  
  public Drawable getTemplateDrawable(ProfileCardTemplate paramProfileCardTemplate, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    paramProfileCardTemplate = new StringBuilder();
    paramProfileCardTemplate.append("getTemplateDrawable fileName=");
    paramProfileCardTemplate.append(paramString);
    profileCardColorLevelDebugQLog(paramProfileCardTemplate.toString());
    try
    {
      localObject1 = BaseApplication.getContext().getResources();
      paramProfileCardTemplate = ProfileCardTemplateUtil.a(-1L);
      if (isValid(paramString))
      {
        if (!isValid(paramProfileCardTemplate)) {
          return null;
        }
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramProfileCardTemplate);
        ((StringBuilder)localObject2).append(File.separator);
        ((StringBuilder)localObject2).append(paramString);
        paramProfileCardTemplate = ((StringBuilder)localObject2).toString();
        if (paramBoolean2) {
          paramProfileCardTemplate = paramString;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("profilecard:");
        ((StringBuilder)localObject2).append(paramProfileCardTemplate);
        localObject2 = ((StringBuilder)localObject2).toString();
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("getTemplateDrawable filePath=");
        ((StringBuilder)localObject3).append(paramProfileCardTemplate);
        profileCardColorLevelDebugQLog(((StringBuilder)localObject3).toString());
        localObject3 = checkCacheDrawable(paramBoolean1, paramProfileCardTemplate, (String)localObject2);
        if (localObject3 != null) {
          return localObject3;
        }
        paramProfileCardTemplate = getBitmap(paramString, (Resources)localObject1, paramProfileCardTemplate);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("getTemplateDrawable bitmap density=");
        ((StringBuilder)localObject3).append(paramProfileCardTemplate.getDensity());
        ((StringBuilder)localObject3).append(",width=");
        ((StringBuilder)localObject3).append(paramProfileCardTemplate.getWidth());
        ((StringBuilder)localObject3).append(",height=");
        ((StringBuilder)localObject3).append(paramProfileCardTemplate.getHeight());
        profileCardColorLevelDebugQLog(((StringBuilder)localObject3).toString());
        int i = Utils.getBitmapSize(paramProfileCardTemplate);
        paramProfileCardTemplate = checkBitmapType(paramString, null, (Resources)localObject1, paramProfileCardTemplate);
        if ((paramProfileCardTemplate != null) && (paramBoolean1)) {
          GlobalImageCache.a.put(localObject2, new Pair(paramProfileCardTemplate.getConstantState(), Integer.valueOf(i)));
        }
        return paramProfileCardTemplate;
      }
      return null;
    }
    catch (Throwable paramProfileCardTemplate)
    {
      paramProfileCardTemplate.printStackTrace();
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getTemplateDrawable exception fileName=");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(",msg=");
      ((StringBuilder)localObject1).append(paramProfileCardTemplate.getMessage());
      profileCardColorLevelDebugQLog(((StringBuilder)localObject1).toString());
      return null;
    }
    catch (OutOfMemoryError paramProfileCardTemplate)
    {
      paramProfileCardTemplate.printStackTrace();
    }
    return null;
  }
  
  protected Object getTypeObj(ProfileCardTemplate paramProfileCardTemplate, JSONObject paramJSONObject, String paramString)
  {
    if (paramString.equalsIgnoreCase("ColorStateList")) {
      return TemplateUtilsImpl.TemplateColorStateList.invoke(paramJSONObject.optJSONArray("data"));
    }
    if (paramString.equalsIgnoreCase("BitmapDrawable")) {
      return getTemplateDrawable(paramProfileCardTemplate, true, false, paramJSONObject.optString("data"));
    }
    if (paramString.equalsIgnoreCase("XMLBitmap")) {
      return TemplateUtilsImpl.TemplateXmlBitmap.invoke(this, paramProfileCardTemplate, paramJSONObject.optJSONObject("data"));
    }
    if (paramString.equalsIgnoreCase("StateListDrawable")) {
      return TemplateUtilsImpl.TemplateStateListDrawable.invoke(this, paramProfileCardTemplate, paramJSONObject.optJSONArray("data"));
    }
    if (paramString.equalsIgnoreCase("String")) {
      return paramJSONObject.optString("data");
    }
    if (paramString.equalsIgnoreCase("Color")) {
      return paramJSONObject.optString("data");
    }
    return null;
  }
  
  public boolean initTemplateConfig(ProfileCardTemplate paramProfileCardTemplate, long paramLong1, long paramLong2)
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("initTemplateConfig config file is ");
      ((StringBuilder)localObject1).append(paramLong1);
      profileCardColorLevelDebugQLog(((StringBuilder)localObject1).toString());
      Object localObject4 = "";
      String str = (String)ProfileCardTemplate.STYLE_NAME_MAP.get(String.valueOf(paramLong2));
      bool2 = true;
      localObject1 = localObject4;
      try
      {
        localObject6 = loadConfigContent(paramLong1);
        if (localObject6 == null) {
          return false;
        }
        localObject1 = localObject4;
        Iterator localIterator = ((JSONObject)localObject6).keys();
        for (;;)
        {
          localObject1 = localObject4;
          if (localIterator.hasNext())
          {
            localObject1 = localObject4;
            localObject4 = (String)localIterator.next();
            try
            {
              if ((!((String)localObject4).startsWith("common")) && ((TextUtils.isEmpty(str)) || (!((String)localObject4).startsWith(str))))
              {
                if (QLog.isColorLevel())
                {
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append("initTemplateConfig config key is not used,key=");
                  ((StringBuilder)localObject1).append((String)localObject4);
                  QLog.d("Q.profilecard.FrdProfileCard", 2, ((StringBuilder)localObject1).toString());
                }
              }
              else
              {
                bool1 = parseCommonJson(paramProfileCardTemplate, (String)localObject4, (JSONObject)localObject6);
                if (bool1) {
                  return false;
                }
              }
            }
            catch (Exception localException1)
            {
              break label281;
            }
          }
        }
        localObject2 = localObject4;
        if (paramLong2 != ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_STATIC)
        {
          localObject2 = localObject4;
          if (paramLong2 != ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_DYNAMIC) {
            break label439;
          }
        }
        localObject2 = localObject4;
        bool1 = parseWzryTemplate(paramProfileCardTemplate, true);
      }
      catch (Exception localException2)
      {
        Object localObject6;
        localObject4 = localObject2;
        Object localObject2 = localException2;
        label281:
        if (QLog.isColorLevel())
        {
          Object localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append(localObject2.getClass().getName());
          ((StringBuilder)localObject5).append(",");
          ((StringBuilder)localObject5).append(localObject2.getMessage());
          localObject5 = ((StringBuilder)localObject5).toString();
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append("initTemplateConfig key=");
          ((StringBuilder)localObject6).append((String)localObject4);
          ((StringBuilder)localObject6).append(",exception msg=");
          ((StringBuilder)localObject6).append((String)localObject5);
          QLog.d("Q.profilecard.FrdProfileCard", 2, ((StringBuilder)localObject6).toString());
        }
        localObject2.printStackTrace();
        bool1 = false;
      }
    }
    finally
    {
      for (;;)
      {
        boolean bool2;
        for (;;)
        {
          throw localObject3;
        }
        label439:
        boolean bool1 = true;
        continue;
        bool1 = false;
      }
    }
    if ((bool1) && (paramProfileCardTemplate.templateAttr.size() > 0))
    {
      bool1 = bool2;
      return bool1;
    }
  }
  
  protected boolean isValid(String paramString)
  {
    return (paramString != null) && (paramString.length() > 0);
  }
  
  protected boolean parseCommonJson(ProfileCardTemplate paramProfileCardTemplate, String paramString, JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONObject(paramString);
    if (paramJSONObject != null)
    {
      String str = paramJSONObject.optString("type");
      if ((str != null) && (str.length() > 0))
      {
        paramJSONObject = getTypeObj(paramProfileCardTemplate, paramJSONObject, str);
        if (paramJSONObject != null)
        {
          paramProfileCardTemplate.templateAttr.put(paramString, paramJSONObject);
          if (QLog.isColorLevel())
          {
            paramJSONObject = new StringBuilder();
            paramJSONObject.append("initTemplateConfig config key= ");
            paramJSONObject.append(paramString);
            paramJSONObject.append(",put templateAttr and size=");
            paramJSONObject.append(paramProfileCardTemplate.templateAttr.size());
            QLog.d("Q.profilecard.FrdProfileCard", 2, paramJSONObject.toString());
          }
        }
        else
        {
          if (QLog.isColorLevel())
          {
            paramProfileCardTemplate = new StringBuilder();
            paramProfileCardTemplate.append("initTemplateConfig config key= ");
            paramProfileCardTemplate.append(paramString);
            paramProfileCardTemplate.append(",init error");
            QLog.d("Q.profilecard.FrdProfileCard", 2, paramProfileCardTemplate.toString());
          }
          return true;
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      paramProfileCardTemplate = new StringBuilder();
      paramProfileCardTemplate.append("initTemplateConfig config key= ");
      paramProfileCardTemplate.append(paramString);
      paramProfileCardTemplate.append(",value is null");
      QLog.d("Q.profilecard.FrdProfileCard", 2, paramProfileCardTemplate.toString());
    }
    return false;
  }
  
  protected boolean parseWzryTemplate(ProfileCardTemplate paramProfileCardTemplate, boolean paramBoolean)
  {
    if (VipWZRYTemplateConfig.a())
    {
      String str = VipWZRYTemplateHelper.a();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("logo.png");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("logo.png");
      localObject = VasApngUtil.getOptimizedApngDrawable((String)localObject, "-wzry-card-logo-", getTemplateDrawable(paramProfileCardTemplate, true, true, localStringBuilder.toString()), new int[] { 7 }, "-wzry-card-logo-", null);
      paramProfileCardTemplate.templateAttr.put("wzryLogo", localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("bgImage.jpg");
      localObject = getTemplateDrawable(paramProfileCardTemplate, true, true, ((StringBuilder)localObject).toString());
      paramProfileCardTemplate.templateAttr.put("wzryGameInfoBackground", localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("logo_bg.png");
      localObject = getTemplateDrawable(paramProfileCardTemplate, true, true, ((StringBuilder)localObject).toString());
      paramProfileCardTemplate.templateAttr.put("wzryLogoBg", localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("shimmer_mask.png");
      localObject = getTemplateDrawable(paramProfileCardTemplate, true, true, ((StringBuilder)localObject).toString());
      paramProfileCardTemplate.templateAttr.put("wzryShimmer", localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("addIcon.png");
      localObject = getTemplateDrawable(paramProfileCardTemplate, true, true, ((StringBuilder)localObject).toString());
      paramProfileCardTemplate.templateAttr.put("addIcon", localObject);
      if (ProfileCardTemplate.wzryTTFChn == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append("font_chs.tff");
        ProfileCardTemplate.wzryTTFChn = Typeface.createFromFile(((StringBuilder)localObject).toString());
      }
      if (ProfileCardTemplate.wzryTTFNum == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append("font_num.tff");
        ProfileCardTemplate.wzryTTFNum = Typeface.createFromFile(((StringBuilder)localObject).toString());
      }
      paramProfileCardTemplate.templateAttr.put("commonMaskBackground", "#e61c212c");
      return paramBoolean;
    }
    return false;
  }
  
  @SuppressLint({"NewApi"})
  public void updateViewAttr(View paramView, String paramString1, ProfileCardTemplate paramProfileCardTemplate, String paramString2)
  {
    if (!checkValidate(paramView, paramString1, paramProfileCardTemplate, paramString2)) {
      return;
    }
    paramProfileCardTemplate = paramProfileCardTemplate.templateAttr.get(paramString2);
    paramString1 = paramString1.toLowerCase();
    this.updateDispatcher.dispatchColor(paramString1, paramView, paramProfileCardTemplate);
    this.updateDispatcher.dispatchBackground(paramString1, paramView, paramProfileCardTemplate);
    this.updateDispatcher.dispatchDrawableleft(paramString1, paramView, paramProfileCardTemplate);
    this.updateDispatcher.dispatchDrawableright(paramString1, paramView, paramProfileCardTemplate);
    this.updateDispatcher.dispatchSrc(paramString1, paramView, paramProfileCardTemplate);
    this.updateDispatcher.dispatchContentBackground(paramString1, paramView, paramProfileCardTemplate);
    this.updateDispatcher.dispatchApngDrawable(paramString1, paramView, paramProfileCardTemplate);
    this.updateDispatcher.dispatchShimmerMask(paramString1, paramView, paramProfileCardTemplate);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.component.template.TemplateUtilsImpl
 * JD-Core Version:    0.7.0.1
 */