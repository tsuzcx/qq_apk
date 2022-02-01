package com.tencent.viola.utils;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ColorParseUtils
{
  private static final int COLOR_RANGE = 255;
  private static final SingleFunctionParser.NonUniformMapper<Number> FUNCTIONAL_RGBA_MAPPER;
  private static final SingleFunctionParser.FlatMapper<Integer> FUNCTIONAL_RGB_MAPPER;
  private static final int HEX = 16;
  private static final int HEX_LONG_SIZE = 7;
  private static final int HEX_SHORT_SIZE = 4;
  private static final String RGB = "rgb";
  private static final String RGBA = "rgba";
  private static final int RGBA_SIZE = 4;
  private static final int RGB_SIZE = 3;
  private static final Map<String, Integer> colorMap = new HashMap();
  
  static
  {
    FUNCTIONAL_RGB_MAPPER = new ColorParseUtils.1();
    FUNCTIONAL_RGBA_MAPPER = new ColorParseUtils.2();
    colorMap.put("aliceblue", Integer.valueOf(-984833));
    colorMap.put("antiquewhite", Integer.valueOf(-332841));
    colorMap.put("aqua", Integer.valueOf(-16711681));
    colorMap.put("aquamarine", Integer.valueOf(-8388652));
    colorMap.put("azure", Integer.valueOf(-983041));
    colorMap.put("beige", Integer.valueOf(-657956));
    colorMap.put("bisque", Integer.valueOf(-6972));
    colorMap.put("black", Integer.valueOf(-16777216));
    colorMap.put("blanchedalmond", Integer.valueOf(-5171));
    colorMap.put("blue", Integer.valueOf(-16776961));
    colorMap.put("blueviolet", Integer.valueOf(-7722014));
    colorMap.put("brown", Integer.valueOf(-5952982));
    colorMap.put("burlywood", Integer.valueOf(-2180985));
    colorMap.put("cadetblue", Integer.valueOf(-10510688));
    colorMap.put("chartreuse", Integer.valueOf(-8388864));
    colorMap.put("chocolate", Integer.valueOf(-2987746));
    colorMap.put("coral", Integer.valueOf(-32944));
    colorMap.put("cornflowerblue", Integer.valueOf(-10185235));
    colorMap.put("cornsilk", Integer.valueOf(-1828));
    colorMap.put("crimson", Integer.valueOf(-2354116));
    colorMap.put("cyan", Integer.valueOf(-16711681));
    colorMap.put("darkblue", Integer.valueOf(-16777077));
    colorMap.put("darkcyan", Integer.valueOf(-16741493));
    colorMap.put("darkgoldenrod", Integer.valueOf(-4684277));
    colorMap.put("darkgray", Integer.valueOf(-5658199));
    colorMap.put("darkgreen", Integer.valueOf(-16751616));
    colorMap.put("darkkhaki", Integer.valueOf(-4343957));
    colorMap.put("darkmagenta", Integer.valueOf(-7667573));
    colorMap.put("darkolivegreen", Integer.valueOf(-11179217));
    colorMap.put("darkorange", Integer.valueOf(-29696));
    colorMap.put("darkorchid", Integer.valueOf(-6737204));
    colorMap.put("darkred", Integer.valueOf(-7667712));
    colorMap.put("darksalmon", Integer.valueOf(-1468806));
    colorMap.put("darkseagreen", Integer.valueOf(-7357297));
    colorMap.put("darkslateblue", Integer.valueOf(-12042869));
    colorMap.put("darkslategray", Integer.valueOf(-13676721));
    colorMap.put("darkslategrey", Integer.valueOf(-13676721));
    colorMap.put("darkturquoise", Integer.valueOf(-16724271));
    colorMap.put("darkviolet", Integer.valueOf(-7077677));
    colorMap.put("deeppink", Integer.valueOf(-60269));
    colorMap.put("deepskyblue", Integer.valueOf(-16728065));
    colorMap.put("dimgray", Integer.valueOf(-9868951));
    colorMap.put("dimgrey", Integer.valueOf(-9868951));
    colorMap.put("dodgerblue", Integer.valueOf(-14774017));
    colorMap.put("firebrick", Integer.valueOf(-5103070));
    colorMap.put("floralwhite", Integer.valueOf(-1296));
    colorMap.put("forestgreen", Integer.valueOf(-14513374));
    colorMap.put("fuchsia", Integer.valueOf(-65281));
    colorMap.put("gainsboro", Integer.valueOf(-2302756));
    colorMap.put("ghostwhite", Integer.valueOf(-460545));
    colorMap.put("gold", Integer.valueOf(-10496));
    colorMap.put("goldenrod", Integer.valueOf(-2448096));
    colorMap.put("gray", Integer.valueOf(-8355712));
    colorMap.put("grey", Integer.valueOf(-8355712));
    colorMap.put("green", Integer.valueOf(-16744448));
    colorMap.put("greenyellow", Integer.valueOf(-5374161));
    colorMap.put("honeydew", Integer.valueOf(-983056));
    colorMap.put("hotpink", Integer.valueOf(-38476));
    colorMap.put("indianred", Integer.valueOf(-3318692));
    colorMap.put("indigo", Integer.valueOf(-11861886));
    colorMap.put("ivory", Integer.valueOf(-16));
    colorMap.put("khaki", Integer.valueOf(-989556));
    colorMap.put("lavender", Integer.valueOf(-1644806));
    colorMap.put("lavenderblush", Integer.valueOf(-3851));
    colorMap.put("lawngreen", Integer.valueOf(-8586240));
    colorMap.put("lemonchiffon", Integer.valueOf(-1331));
    colorMap.put("lightblue", Integer.valueOf(-5383962));
    colorMap.put("lightcoral", Integer.valueOf(-1015680));
    colorMap.put("lightcyan", Integer.valueOf(-2031617));
    colorMap.put("lightgoldenrodyellow", Integer.valueOf(-329006));
    colorMap.put("lightgray", Integer.valueOf(-2894893));
    colorMap.put("lightgrey", Integer.valueOf(-2894893));
    colorMap.put("lightgreen", Integer.valueOf(-7278960));
    colorMap.put("lightpink", Integer.valueOf(-18751));
    colorMap.put("lightsalmon", Integer.valueOf(-24454));
    colorMap.put("lightseagreen", Integer.valueOf(-14634326));
    colorMap.put("lightskyblue", Integer.valueOf(-7876870));
    colorMap.put("lightslategray", Integer.valueOf(-8943463));
    colorMap.put("lightslategrey", Integer.valueOf(-8943463));
    colorMap.put("lightsteelblue", Integer.valueOf(-5192482));
    colorMap.put("lightyellow", Integer.valueOf(-32));
    colorMap.put("lime", Integer.valueOf(-16711936));
    colorMap.put("limegreen", Integer.valueOf(-13447886));
    colorMap.put("linen", Integer.valueOf(-331546));
    colorMap.put("magenta", Integer.valueOf(-65281));
    colorMap.put("maroon", Integer.valueOf(-8388608));
    colorMap.put("mediumaquamarine", Integer.valueOf(-10039894));
    colorMap.put("mediumblue", Integer.valueOf(-16777011));
    colorMap.put("mediumorchid", Integer.valueOf(-4565549));
    colorMap.put("mediumpurple", Integer.valueOf(-7114533));
    colorMap.put("mediumseagreen", Integer.valueOf(-12799119));
    colorMap.put("mediumslateblue", Integer.valueOf(-8689426));
    colorMap.put("mediumspringgreen", Integer.valueOf(-16713062));
    colorMap.put("mediumturquoise", Integer.valueOf(-12004916));
    colorMap.put("mediumvioletred", Integer.valueOf(-3730043));
    colorMap.put("midnightblue", Integer.valueOf(-15132304));
    colorMap.put("mintcream", Integer.valueOf(-655366));
    colorMap.put("mistyrose", Integer.valueOf(-6943));
    colorMap.put("moccasin", Integer.valueOf(-6987));
    colorMap.put("navajowhite", Integer.valueOf(-8531));
    colorMap.put("navy", Integer.valueOf(-16777088));
    colorMap.put("oldlace", Integer.valueOf(-133658));
    colorMap.put("olive", Integer.valueOf(-8355840));
    colorMap.put("olivedrab", Integer.valueOf(-9728477));
    colorMap.put("orange", Integer.valueOf(-23296));
    colorMap.put("orangered", Integer.valueOf(-47872));
    colorMap.put("orchid", Integer.valueOf(-2461482));
    colorMap.put("palegoldenrod", Integer.valueOf(-1120086));
    colorMap.put("palegreen", Integer.valueOf(-6751336));
    colorMap.put("paleturquoise", Integer.valueOf(-5247250));
    colorMap.put("palevioletred", Integer.valueOf(-2396013));
    colorMap.put("papayawhip", Integer.valueOf(-4139));
    colorMap.put("peachpuff", Integer.valueOf(-9543));
    colorMap.put("peru", Integer.valueOf(-3308225));
    colorMap.put("pink", Integer.valueOf(-16181));
    colorMap.put("plum", Integer.valueOf(-2252579));
    colorMap.put("powderblue", Integer.valueOf(-5185306));
    colorMap.put("purple", Integer.valueOf(-8388480));
    colorMap.put("rebeccapurple", Integer.valueOf(-10079335));
    colorMap.put("red", Integer.valueOf(-65536));
    colorMap.put("rosybrown", Integer.valueOf(-4419697));
    colorMap.put("royalblue", Integer.valueOf(-12490271));
    colorMap.put("saddlebrown", Integer.valueOf(-7650029));
    colorMap.put("salmon", Integer.valueOf(-360334));
    colorMap.put("sandybrown", Integer.valueOf(-744352));
    colorMap.put("seagreen", Integer.valueOf(-13726889));
    colorMap.put("seashell", Integer.valueOf(-2578));
    colorMap.put("sienna", Integer.valueOf(-6270419));
    colorMap.put("silver", Integer.valueOf(-4144960));
    colorMap.put("skyblue", Integer.valueOf(-7876885));
    colorMap.put("slateblue", Integer.valueOf(-9807155));
    colorMap.put("slategray", Integer.valueOf(-9404272));
    colorMap.put("slategrey", Integer.valueOf(-9404272));
    colorMap.put("snow", Integer.valueOf(-1286));
    colorMap.put("springgreen", Integer.valueOf(-16711809));
    colorMap.put("steelblue", Integer.valueOf(-12156236));
    colorMap.put("tan", Integer.valueOf(-2968436));
    colorMap.put("teal", Integer.valueOf(-16744320));
    colorMap.put("thistle", Integer.valueOf(-2572328));
    colorMap.put("tomato", Integer.valueOf(-40121));
    colorMap.put("turquoise", Integer.valueOf(-12525360));
    colorMap.put("violet", Integer.valueOf(-1146130));
    colorMap.put("wheat", Integer.valueOf(-663885));
    colorMap.put("white", Integer.valueOf(-1));
    colorMap.put("whitesmoke", Integer.valueOf(-657931));
    colorMap.put("yellow", Integer.valueOf(-256));
    colorMap.put("yellowgreen", Integer.valueOf(-6632142));
    colorMap.put("transparent", Integer.valueOf(0));
  }
  
  public static boolean isNamedColor(String paramString)
  {
    return colorMap.containsKey(paramString);
  }
  
  private static int parseAlpha(float paramFloat)
  {
    return (int)(255.0F * paramFloat);
  }
  
  public static int parseColor(String paramString)
  {
    return parseColor(paramString, -2147483648);
  }
  
  public static int parseColor(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return paramInt;
      paramString = paramString.trim();
      if (isNamedColor(paramString)) {
        return ((Integer)colorMap.get(paramString)).intValue();
      }
      Pair localPair = transHexColor(paramString);
      if (((Boolean)localPair.first).booleanValue()) {
        return ((Integer)localPair.second).intValue();
      }
      try
      {
        if (paramString.indexOf("rgba") == 0)
        {
          localPair = transRGBAColor(paramString);
          if (((Boolean)localPair.first).booleanValue()) {
            return ((Integer)localPair.second).intValue();
          }
        }
        if (paramString.indexOf("rgb") == 0)
        {
          paramString = transRGBColor(paramString);
          if (((Boolean)paramString.first).booleanValue())
          {
            int i = ((Integer)paramString.second).intValue();
            return i;
          }
        }
      }
      catch (RuntimeException paramString)
      {
        ViolaLogUtils.e("ColorUtils", "parseColor " + paramString.getMessage());
      }
    }
    return paramInt;
  }
  
  @NonNull
  private static Pair<Boolean, Integer> transHexColor(String paramString)
  {
    if (paramString.length() == 4)
    {
      int i = Integer.parseInt(paramString.substring(1, 2), 16);
      int j = Integer.parseInt(paramString.substring(2, 3), 16);
      int k = Integer.parseInt(paramString.substring(3, 4), 16);
      return new Pair(Boolean.TRUE, Integer.valueOf(Color.rgb(i + (i << 4), j + (j << 4), k + (k << 4))));
    }
    if ((paramString.length() == 7) || (paramString.length() == 9)) {
      return new Pair(Boolean.TRUE, Integer.valueOf(Color.parseColor(paramString)));
    }
    return new Pair(Boolean.FALSE, Integer.valueOf(0));
  }
  
  @NonNull
  private static Pair<Boolean, Integer> transRGBAColor(String paramString)
  {
    paramString = new SingleFunctionParser(paramString, FUNCTIONAL_RGBA_MAPPER).parse("rgba");
    if ((paramString != null) && (paramString.size() == 4)) {
      return new Pair(Boolean.TRUE, Integer.valueOf(Color.argb(parseAlpha(((Number)paramString.get(3)).floatValue()), ((Number)paramString.get(0)).intValue(), ((Number)paramString.get(1)).intValue(), ((Number)paramString.get(2)).intValue())));
    }
    return new Pair(Boolean.FALSE, Integer.valueOf(0));
  }
  
  @NonNull
  private static Pair<Boolean, Integer> transRGBColor(String paramString)
  {
    paramString = new SingleFunctionParser(paramString, FUNCTIONAL_RGB_MAPPER).parse("rgb");
    if ((paramString != null) && (paramString.size() == 3)) {
      return new Pair(Boolean.TRUE, Integer.valueOf(Color.rgb(((Integer)paramString.get(0)).intValue(), ((Integer)paramString.get(1)).intValue(), ((Integer)paramString.get(2)).intValue())));
    }
    return new Pair(Boolean.FALSE, Integer.valueOf(0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.utils.ColorParseUtils
 * JD-Core Version:    0.7.0.1
 */