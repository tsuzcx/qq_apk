package com.tencent.mobileqq.mini.entry.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"ANDROID_PREFIX", "", "IS_RESOURCE_REFERENCE", "Ljava/util/regex/Pattern;", "getIS_RESOURCE_REFERENCE", "()Ljava/util/regex/Pattern;", "NULL_VALUE", "attrTransformMap", "", "getAttrTransformMap", "()Ljava/util/Map;", "className", "funName", "projectDir", "getProjectDir", "()Ljava/lang/String;", "sourceXml", "getSourceXml", "targetDir", "getTargetDir", "createLayout", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "createLayoutFileTemplate", "content", "extractDigital", "value", "getAttrName", "key", "getAttributeData", "", "attr", "attrValue", "getGravity", "getLayoutEllipsize", "getLayoutGravity", "getLayoutWH", "getOrientation", "getScaleType", "getVisibility", "isNull", "", "isResourceReference", "obtainXmlResourceParser", "path", "parseGravityCompose", "xml2Layout", "AQQLiteApp_release"}, k=2, mv={1, 1, 16})
public final class Xml2LayoutKt
{
  @NotNull
  public static final String ANDROID_PREFIX = "android:";
  @NotNull
  private static final Pattern IS_RESOURCE_REFERENCE;
  @NotNull
  public static final String NULL_VALUE = "@null";
  @NotNull
  private static final Map<String, String> attrTransformMap = MapsKt.mapOf(new Pair[] { TuplesKt.to("background", "_background"), TuplesKt.to("text", "_text"), TuplesKt.to("clipChildren", "_clipChildren"), TuplesKt.to("clipPadding", "_clipPadding") });
  @NotNull
  public static final String className = "PopularityListLayout.kt";
  @NotNull
  public static final String funName = "buildPopularityListLayout";
  @NotNull
  private static final String projectDir;
  @NotNull
  private static final String sourceXml;
  @NotNull
  private static final String targetDir;
  
  static
  {
    Object localObject = Pattern.compile("^\\s*@");
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Pattern.compile(\"^\\\\s*@\")");
    IS_RESOURCE_REFERENCE = (Pattern)localObject;
    localObject = System.getProperty("user.dir");
    Intrinsics.checkExpressionValueIsNotNull(localObject, "System.getProperty(\"user.dir\")");
    projectDir = StringsKt.substringBefore$default((String)localObject, "AQQLite", null, 2, null);
    sourceXml = projectDir + "QQLite/res/layout/mini_app_desktop_popularity_list_layout.xml";
    targetDir = projectDir + "QQLite/src/com/tencent/mobileqq/mini/entry/layout/";
  }
  
  public static final void createLayout(@NotNull XmlPullParser paramXmlPullParser)
  {
    Intrinsics.checkParameterIsNotNull(paramXmlPullParser, "parser");
    Object localObject1 = projectDir;
    System.out.println(localObject1);
    int i = paramXmlPullParser.getEventType();
    Object localObject2 = "";
    if (i != 1)
    {
      String str1 = paramXmlPullParser.getName();
      localObject1 = "Creating view: " + str1;
      System.out.println(localObject1);
      switch (i)
      {
      }
      for (;;)
      {
        i = paramXmlPullParser.next();
        break;
        localObject1 = (String)localObject2 + str1 + " {\n";
        int j = paramXmlPullParser.getAttributeCount();
        i = 0;
        for (;;)
        {
          localObject2 = localObject1;
          if (i >= j) {
            break;
          }
          String str2 = paramXmlPullParser.getAttributeName(i);
          String str3 = paramXmlPullParser.getAttributeValue(i);
          Intrinsics.checkExpressionValueIsNotNull(str2, "key");
          localObject2 = localObject1;
          if (StringsKt.startsWith$default(str2, "android:", false, 2, null))
          {
            localObject1 = new StringBuilder().append((String)localObject1).append('\t').append(getAttrName(str2)).append(" = ");
            localObject2 = getAttrName(str2);
            Intrinsics.checkExpressionValueIsNotNull(str3, "value");
            localObject2 = getAttributeData((String)localObject2, str3) + '\n';
          }
          localObject1 = "Creating " + str1 + " attr key: " + str2 + ", value: " + str3;
          System.out.println(localObject1);
          i += 1;
          localObject1 = localObject2;
        }
        localObject2 = (String)localObject2 + "}\n";
        localObject1 = str1 + " end";
        System.out.println(localObject1);
      }
    }
    if (localObject2 == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }
    paramXmlPullParser = createLayoutFileTemplate("buildPopularityListLayout", StringsKt.trimStart((CharSequence)localObject2).toString());
    localObject1 = new File(targetDir + "PopularityListLayout.kt");
    if (!((File)localObject1).exists()) {
      ((File)localObject1).createNewFile();
    }
    FilesKt.writeText$default((File)localObject1, paramXmlPullParser, null, 2, null);
  }
  
  @NotNull
  public static final String createLayoutFileTemplate(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "funName");
    Intrinsics.checkParameterIsNotNull(paramString2, "content");
    paramString1 = "\npackage com.tencent.mobileqq.mini.entry.layout\n\nimport android.content.Context\nimport android.text.TextUtils\nimport android.view.Gravity\nimport android.view.View\nimport android.view.ViewGroup\nimport android.widget.ImageView\nimport com.tencent.mobileqq.R\n\ninline fun " + paramString1 + "(context: Context): View {\n    return context.run {\n        " + paramString2 + "\n    }\n}\n";
    if (paramString1 == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }
    return StringsKt.trimStart((CharSequence)paramString1).toString();
  }
  
  @NotNull
  public static final String extractDigital(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    paramString = StringsKt.substringBefore$default(paramString, "dp", null, 2, null);
    if (paramString == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }
    return StringsKt.trim((CharSequence)paramString).toString();
  }
  
  @NotNull
  public static final String getAttrName(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    paramString = paramString.substring("android:".length());
    Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).substring(startIndex)");
    if (attrTransformMap.containsKey(paramString))
    {
      String str = (String)attrTransformMap.get(paramString);
      if (str != null) {
        return str;
      }
      return paramString;
    }
    return paramString;
  }
  
  @NotNull
  public static final Map<String, String> getAttrTransformMap()
  {
    return attrTransformMap;
  }
  
  @NotNull
  public static final Object getAttributeData(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "attr");
    Intrinsics.checkParameterIsNotNull(paramString2, "attrValue");
    String str;
    if (Intrinsics.areEqual(paramString1, "textSize")) {
      str = extractDigital(paramString2) + 'f';
    }
    do
    {
      return str;
      if (StringsKt.endsWith$default(paramString2, "dp", false, 2, null)) {
        return extractDigital(paramString2);
      }
      if (StringsKt.endsWith$default(paramString2, "sp", false, 2, null))
      {
        paramString1 = new StringBuilder();
        paramString2 = StringsKt.substringBefore$default(paramString2, "sp", null, 2, null);
        if (paramString2 == null) {
          throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
        }
        return StringsKt.trim((CharSequence)paramString2).toString() + "f";
      }
      if (isResourceReference(paramString2)) {
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(paramString2, "@", "R.", false, 4, null), "+", "", false, 4, null), "/", ".", false, 4, null);
      }
      if ((StringsKt.startsWith$default(paramString2, "#", false, 2, null)) || (Intrinsics.areEqual(paramString1, "_text"))) {
        return '"' + paramString2 + '"';
      }
      if (Intrinsics.areEqual(paramString1, "layout_width")) {
        return getLayoutWH(paramString2);
      }
      if (Intrinsics.areEqual(paramString1, "layout_height")) {
        return getLayoutWH(paramString2);
      }
      if (Intrinsics.areEqual(paramString1, "orientation")) {
        return getOrientation(paramString2);
      }
      if (Intrinsics.areEqual(paramString1, "scaleType")) {
        return getScaleType(paramString2);
      }
      if (Intrinsics.areEqual(paramString1, "visibility")) {
        return getVisibility(paramString2);
      }
      if (Intrinsics.areEqual(paramString1, "gravity")) {
        return getGravity(paramString2);
      }
      if (Intrinsics.areEqual(paramString1, "layout_gravity")) {
        return getLayoutGravity(paramString2);
      }
      if (Intrinsics.areEqual(paramString1, "ellipsize")) {
        return getLayoutEllipsize(paramString2);
      }
      if (Intrinsics.areEqual(paramString1, "layout_weight")) {
        break;
      }
      str = paramString2;
    } while (!Intrinsics.areEqual(paramString1, "rotation"));
    return paramString2 + 'f';
  }
  
  @NotNull
  public static final String getGravity(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    switch (paramString.hashCode())
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                String str = paramString;
                                if (StringsKt.contains$default((CharSequence)paramString, (CharSequence)"|", false, 2, null))
                                {
                                  paramString = parseGravityCompose(paramString);
                                  str = paramString;
                                  if (paramString == null)
                                  {
                                    Intrinsics.throwNpe();
                                    str = paramString;
                                  }
                                }
                                return str;
                              } while (!paramString.equals("bottom"));
                              return "Gravity.BOTTOM";
                            } while (!paramString.equals("clip_horizontal"));
                            return "Gravity.CLIP_HORIZONTAL";
                          } while (!paramString.equals("center"));
                          return "Gravity.CENTER";
                        } while (!paramString.equals("clip_vertical"));
                        return "Gravity.CLIP_VERTICAL";
                      } while (!paramString.equals("start"));
                      return "Gravity.START";
                    } while (!paramString.equals("right"));
                    return "Gravity.RIGHT";
                  } while (!paramString.equals("center_horizontal"));
                  return "Gravity.CENTER_HORIZONTAL";
                } while (!paramString.equals("fill"));
                return "Gravity.FILL";
              } while (!paramString.equals("fill_horizontal"));
              return "Gravity.FILL_HORIZONTAL";
            } while (!paramString.equals("top"));
            return "Gravity.TOP";
          } while (!paramString.equals("left"));
          return "Gravity.LEFT";
        } while (!paramString.equals("center_vertical"));
        return "Gravity.CENTER_VERTICAL";
      } while (!paramString.equals("fill_vertical"));
      return "Gravity.FILL_VERTICAL";
    } while (!paramString.equals("end"));
    return "Gravity.END";
  }
  
  @NotNull
  public static final Pattern getIS_RESOURCE_REFERENCE()
  {
    return IS_RESOURCE_REFERENCE;
  }
  
  @NotNull
  public static final String getLayoutEllipsize(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    switch (paramString.hashCode())
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return "TextUtils.TruncateAt.START";
            } while (!paramString.equals("middle"));
            return "TextUtils.TruncateAt.MIDDLE";
          } while (!paramString.equals("start"));
          return "TextUtils.TruncateAt.START";
        } while (!paramString.equals("end"));
        return "TextUtils.TruncateAt.END";
      } while (!paramString.equals("marquee"));
      return "TextUtils.TruncateAt.MARQUEE";
    } while (!paramString.equals("none"));
    return "TextUtils.TruncateAt.START";
  }
  
  @NotNull
  public static final String getLayoutGravity(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    return getGravity(paramString);
  }
  
  @NotNull
  public static final String getLayoutWH(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    switch (paramString.hashCode())
    {
    }
    do
    {
      do
      {
        do
        {
          return paramString;
        } while (!paramString.equals("fill_parent"));
        return "ViewGroup.LayoutParams.MATCH_PARENT";
      } while (!paramString.equals("wrap_content"));
      return "ViewGroup.LayoutParams.WRAP_CONTENT";
    } while (!paramString.equals("match_parent"));
    return "ViewGroup.LayoutParams.MATCH_PARENT";
  }
  
  @NotNull
  public static final String getOrientation(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    switch (paramString.hashCode())
    {
    }
    do
    {
      do
      {
        return paramString;
      } while (!paramString.equals("horizontal"));
      return "HORIZONTAL";
    } while (!paramString.equals("vertical"));
    return "VERTICAL";
  }
  
  @NotNull
  public static final String getProjectDir()
  {
    return projectDir;
  }
  
  @NotNull
  public static final String getScaleType(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    switch (paramString.hashCode())
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return "ImageView.ScaleType.FIT_CENTER";
                  } while (!paramString.equals("centerInside"));
                  return "ImageView.ScaleType.CENTER_INSIDE";
                } while (!paramString.equals("fitStart"));
                return "ImageView.ScaleType.FIT_START";
              } while (!paramString.equals("fitEnd"));
              return "ImageView.ScaleType.FIT_END";
            } while (!paramString.equals("center"));
            return "ImageView.ScaleType.CENTER";
          } while (!paramString.equals("matrix"));
          return "ImageView.ScaleType.MATRIX";
        } while (!paramString.equals("fitXY"));
        return "ImageView.ScaleType.FIT_XY";
      } while (!paramString.equals("fitCenter"));
      return "ImageView.ScaleType.FIT_CENTER";
    } while (!paramString.equals("centerCrop"));
    return "ImageView.ScaleType.CENTER_CROP";
  }
  
  @NotNull
  public static final String getSourceXml()
  {
    return sourceXml;
  }
  
  @NotNull
  public static final String getTargetDir()
  {
    return targetDir;
  }
  
  @NotNull
  public static final String getVisibility(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    switch (paramString.hashCode())
    {
    }
    do
    {
      do
      {
        do
        {
          return "View.VISIBLE";
        } while (!paramString.equals("visible"));
        return "View.VISIBLE";
      } while (!paramString.equals("invisible"));
      return "View.INVISIBLE";
    } while (!paramString.equals("gone"));
    return "View.GONE";
  }
  
  public static final boolean isNull(@Nullable String paramString)
  {
    return Intrinsics.areEqual("@null", paramString);
  }
  
  public static final boolean isResourceReference(@Nullable String paramString)
  {
    return (IS_RESOURCE_REFERENCE.matcher((CharSequence)paramString).find()) && (!isNull(paramString));
  }
  
  @NotNull
  public static final XmlPullParser obtainXmlResourceParser(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "path");
    XmlPullParser localXmlPullParser = XmlPullParserFactory.newInstance().newPullParser();
    localXmlPullParser.setInput((InputStream)new FileInputStream(paramString), "UTF-8");
    Intrinsics.checkExpressionValueIsNotNull(localXmlPullParser, "pullParser");
    return localXmlPullParser;
  }
  
  @Nullable
  public static final String parseGravityCompose(@NotNull String paramString)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    Iterator localIterator = ((Iterable)StringsKt.split$default((CharSequence)paramString, new String[] { "|" }, false, 0, 6, null)).iterator();
    paramString = "";
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (i < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      String str = (String)localObject;
      localObject = paramString;
      if (i != 0) {
        localObject = Intrinsics.stringPlus(paramString, " or ");
      }
      paramString = Intrinsics.stringPlus((String)localObject, getGravity(str));
      i += 1;
    }
    return paramString;
  }
  
  public static final void xml2Layout(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "path");
    createLayout(obtainXmlResourceParser(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.util.Xml2LayoutKt
 * JD-Core Version:    0.7.0.1
 */