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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"ANDROID_PREFIX", "", "IS_RESOURCE_REFERENCE", "Ljava/util/regex/Pattern;", "getIS_RESOURCE_REFERENCE", "()Ljava/util/regex/Pattern;", "NULL_VALUE", "attrTransformMap", "", "getAttrTransformMap", "()Ljava/util/Map;", "className", "funName", "projectDir", "getProjectDir", "()Ljava/lang/String;", "sourceXml", "getSourceXml", "targetDir", "getTargetDir", "createLayout", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "createLayoutFileTemplate", "content", "extractDigital", "value", "getAttrName", "key", "getAttributeData", "", "attr", "attrValue", "getGravity", "getLayoutEllipsize", "getLayoutGravity", "getLayoutWH", "getOrientation", "getScaleType", "getVisibility", "isNull", "", "isResourceReference", "obtainXmlResourceParser", "path", "parseGravityCompose", "xml2Layout", "qqmini_impl_release"}, k=2, mv={1, 1, 16})
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
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(projectDir);
    ((StringBuilder)localObject).append("QQLite/res/layout/mini_app_desktop_popularity_list_layout.xml");
    sourceXml = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(projectDir);
    ((StringBuilder)localObject).append("QQLite/src/com/tencent/mobileqq/mini/entry/layout/");
    targetDir = ((StringBuilder)localObject).toString();
  }
  
  public static final void createLayout(@NotNull XmlPullParser paramXmlPullParser)
  {
    Intrinsics.checkParameterIsNotNull(paramXmlPullParser, "parser");
    Object localObject1 = projectDir;
    System.out.println(localObject1);
    int i = paramXmlPullParser.getEventType();
    localObject1 = "";
    while (i != 1)
    {
      String str1 = paramXmlPullParser.getName();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Creating view: ");
      ((StringBuilder)localObject2).append(str1);
      localObject2 = ((StringBuilder)localObject2).toString();
      System.out.println(localObject2);
      if (i != 2)
      {
        if (i == 3)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("}\n");
          localObject1 = ((StringBuilder)localObject2).toString();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(str1);
          ((StringBuilder)localObject2).append(" end");
          localObject2 = ((StringBuilder)localObject2).toString();
          System.out.println(localObject2);
        }
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(str1);
        ((StringBuilder)localObject2).append(" {\n");
        localObject1 = ((StringBuilder)localObject2).toString();
        int j = paramXmlPullParser.getAttributeCount();
        i = 0;
        while (i < j)
        {
          String str2 = paramXmlPullParser.getAttributeName(i);
          String str3 = paramXmlPullParser.getAttributeValue(i);
          Intrinsics.checkExpressionValueIsNotNull(str2, "key");
          localObject2 = localObject1;
          if (StringsKt.startsWith$default(str2, "android:", false, 2, null))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append('\t');
            ((StringBuilder)localObject2).append(getAttrName(str2));
            ((StringBuilder)localObject2).append(" = ");
            localObject1 = getAttrName(str2);
            Intrinsics.checkExpressionValueIsNotNull(str3, "value");
            ((StringBuilder)localObject2).append(getAttributeData((String)localObject1, str3));
            ((StringBuilder)localObject2).append('\n');
            localObject2 = ((StringBuilder)localObject2).toString();
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Creating ");
          ((StringBuilder)localObject1).append(str1);
          ((StringBuilder)localObject1).append(" attr key: ");
          ((StringBuilder)localObject1).append(str2);
          ((StringBuilder)localObject1).append(", value: ");
          ((StringBuilder)localObject1).append(str3);
          localObject1 = ((StringBuilder)localObject1).toString();
          System.out.println(localObject1);
          i += 1;
          localObject1 = localObject2;
        }
      }
      i = paramXmlPullParser.next();
    }
    if (localObject1 != null)
    {
      paramXmlPullParser = createLayoutFileTemplate("buildPopularityListLayout", StringsKt.trimStart((CharSequence)localObject1).toString());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(targetDir);
      ((StringBuilder)localObject1).append("PopularityListLayout.kt");
      localObject1 = new File(((StringBuilder)localObject1).toString());
      if (!((File)localObject1).exists()) {
        ((File)localObject1).createNewFile();
      }
      FilesKt.writeText$default((File)localObject1, paramXmlPullParser, null, 2, null);
      return;
    }
    paramXmlPullParser = new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    for (;;)
    {
      throw paramXmlPullParser;
    }
  }
  
  @NotNull
  public static final String createLayoutFileTemplate(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "funName");
    Intrinsics.checkParameterIsNotNull(paramString2, "content");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\npackage com.tencent.mobileqq.mini.entry.layout\n\nimport android.content.Context\nimport android.text.TextUtils\nimport android.view.Gravity\nimport android.view.View\nimport android.view.ViewGroup\nimport android.widget.ImageView\nimport com.tencent.mobileqq.R\n\ninline fun ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("(context: Context): View {\n    return context.run {\n        ");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("\n    }\n}\n");
    paramString1 = localStringBuilder.toString();
    if (paramString1 != null) {
      return StringsKt.trimStart((CharSequence)paramString1).toString();
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
  }
  
  @NotNull
  public static final String extractDigital(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    paramString = StringsKt.substringBefore$default(StringsKt.substringBefore$default(paramString, "dp", null, 2, null), "sp", null, 2, null);
    if (paramString != null) {
      return StringsKt.trim((CharSequence)paramString).toString();
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
  }
  
  @NotNull
  public static final String getAttrName(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    String str1 = paramString.substring(8);
    Intrinsics.checkExpressionValueIsNotNull(str1, "(this as java.lang.String).substring(startIndex)");
    paramString = str1;
    if (attrTransformMap.containsKey(str1))
    {
      String str2 = (String)attrTransformMap.get(str1);
      paramString = str1;
      if (str2 != null) {
        paramString = str2;
      }
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
    if (Intrinsics.areEqual(paramString1, "textSize"))
    {
      paramString1 = new StringBuilder();
      paramString1.append(extractDigital(paramString2));
      paramString1.append('f');
      return paramString1.toString();
    }
    if (StringsKt.endsWith$default(paramString2, "dp", false, 2, null)) {
      return extractDigital(paramString2);
    }
    if (StringsKt.endsWith$default(paramString2, "sp", false, 2, null))
    {
      paramString1 = new StringBuilder();
      paramString2 = StringsKt.substringBefore$default(paramString2, "sp", null, 2, null);
      if (paramString2 != null)
      {
        paramString1.append(StringsKt.trim((CharSequence)paramString2).toString());
        paramString1.append("f");
        return paramString1.toString();
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }
    if (isResourceReference(paramString2)) {
      return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(paramString2, "@", "R.", false, 4, null), "+", "", false, 4, null), "/", ".", false, 4, null);
    }
    String str;
    if ((!StringsKt.startsWith$default(paramString2, "#", false, 2, null)) && (!Intrinsics.areEqual(paramString1, "_text")))
    {
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
      if (!Intrinsics.areEqual(paramString1, "layout_weight"))
      {
        str = paramString2;
        if (!Intrinsics.areEqual(paramString1, "rotation")) {}
      }
      else
      {
        paramString1 = new StringBuilder();
        paramString1.append(paramString2);
        paramString1.append('f');
        return paramString1.toString();
      }
    }
    else
    {
      paramString1 = new StringBuilder();
      paramString1.append('"');
      paramString1.append(paramString2);
      paramString1.append('"');
      str = paramString1.toString();
    }
    return str;
  }
  
  @NotNull
  public static final String getGravity(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 1063616078: 
      if (paramString.equals("center_horizontal")) {
        return "Gravity.CENTER_HORIZONTAL";
      }
      break;
    case 109757538: 
      if (paramString.equals("start")) {
        return "Gravity.START";
      }
      break;
    case 108511772: 
      if (paramString.equals("right")) {
        return "Gravity.RIGHT";
      }
      break;
    case 3317767: 
      if (paramString.equals("left")) {
        return "Gravity.LEFT";
      }
      break;
    case 3143043: 
      if (paramString.equals("fill")) {
        return "Gravity.FILL";
      }
      break;
    case 115029: 
      if (paramString.equals("top")) {
        return "Gravity.TOP";
      }
      break;
    case 100571: 
      if (paramString.equals("end")) {
        return "Gravity.END";
      }
      break;
    case -55726203: 
      if (paramString.equals("clip_vertical")) {
        return "Gravity.CLIP_VERTICAL";
      }
      break;
    case -348726240: 
      if (paramString.equals("center_vertical")) {
        return "Gravity.CENTER_VERTICAL";
      }
      break;
    case -483365792: 
      if (paramString.equals("fill_horizontal")) {
        return "Gravity.FILL_HORIZONTAL";
      }
      break;
    case -831189901: 
      if (paramString.equals("clip_horizontal")) {
        return "Gravity.CLIP_HORIZONTAL";
      }
      break;
    case -1364013995: 
      if (paramString.equals("center")) {
        return "Gravity.CENTER";
      }
      break;
    case -1383228885: 
      if (paramString.equals("bottom")) {
        return "Gravity.BOTTOM";
      }
      break;
    case -1633016142: 
      if (paramString.equals("fill_vertical")) {
        return "Gravity.FILL_VERTICAL";
      }
      break;
    }
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
    int i = paramString.hashCode();
    String str = "TextUtils.TruncateAt.START";
    switch (i)
    {
    default: 
      return "TextUtils.TruncateAt.START";
    case 839444514: 
      if (paramString.equals("marquee")) {
        return "TextUtils.TruncateAt.MARQUEE";
      }
      break;
    case 109757538: 
      paramString.equals("start");
      return "TextUtils.TruncateAt.START";
    case 3387192: 
      paramString.equals("none");
      return "TextUtils.TruncateAt.START";
    case 100571: 
      if (paramString.equals("end")) {
        return "TextUtils.TruncateAt.END";
      }
      break;
    case -1074341483: 
      if (paramString.equals("middle")) {
        str = "TextUtils.TruncateAt.MIDDLE";
      }
      break;
    }
    return str;
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
    int i = paramString.hashCode();
    String str;
    if (i != 343327108)
    {
      if (i != 1261922022)
      {
        if (i != 1386124388) {
          return paramString;
        }
        str = paramString;
        if (!paramString.equals("match_parent")) {}
      }
      else
      {
        for (;;)
        {
          return "ViewGroup.LayoutParams.MATCH_PARENT";
          str = paramString;
          if (!paramString.equals("fill_parent")) {
            break;
          }
        }
      }
    }
    else
    {
      str = paramString;
      if (paramString.equals("wrap_content")) {
        str = "ViewGroup.LayoutParams.WRAP_CONTENT";
      }
    }
    return str;
  }
  
  @NotNull
  public static final String getOrientation(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    int i = paramString.hashCode();
    String str;
    if (i != -1984141450)
    {
      if (i != 1387629604) {
        return paramString;
      }
      str = paramString;
      if (paramString.equals("horizontal")) {
        return "HORIZONTAL";
      }
    }
    else
    {
      str = paramString;
      if (paramString.equals("vertical")) {
        str = "VERTICAL";
      }
    }
    return str;
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
    int i = paramString.hashCode();
    String str = "ImageView.ScaleType.FIT_CENTER";
    switch (i)
    {
    default: 
      return "ImageView.ScaleType.FIT_CENTER";
    case 1161480325: 
      if (paramString.equals("centerCrop")) {
        return "ImageView.ScaleType.CENTER_CROP";
      }
      break;
    case 520762310: 
      paramString.equals("fitCenter");
      return "ImageView.ScaleType.FIT_CENTER";
    case 97441490: 
      if (paramString.equals("fitXY")) {
        return "ImageView.ScaleType.FIT_XY";
      }
      break;
    case -340708175: 
      if (paramString.equals("centerInside")) {
        return "ImageView.ScaleType.CENTER_INSIDE";
      }
      break;
    case -522179887: 
      if (paramString.equals("fitStart")) {
        return "ImageView.ScaleType.FIT_START";
      }
      break;
    case -1081239615: 
      if (paramString.equals("matrix")) {
        return "ImageView.ScaleType.MATRIX";
      }
      break;
    case -1274298614: 
      if (paramString.equals("fitEnd")) {
        return "ImageView.ScaleType.FIT_END";
      }
      break;
    case -1364013995: 
      if (paramString.equals("center")) {
        str = "ImageView.ScaleType.CENTER";
      }
      break;
    }
    return str;
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
    int i = paramString.hashCode();
    String str = "View.VISIBLE";
    if (i != -1901805651)
    {
      if (i != 3178655)
      {
        if (i != 466743410) {
          return "View.VISIBLE";
        }
        paramString.equals("visible");
        return "View.VISIBLE";
      }
      if (paramString.equals("gone")) {
        return "View.GONE";
      }
    }
    else if (paramString.equals("invisible"))
    {
      str = "View.INVISIBLE";
    }
    return str;
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
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    paramString = (CharSequence)paramString;
    int i = 0;
    Iterator localIterator = ((Iterable)StringsKt.split$default(paramString, new String[] { "|" }, false, 0, 6, null)).iterator();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.util.Xml2LayoutKt
 * JD-Core Version:    0.7.0.1
 */