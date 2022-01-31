package com.tencent.qqmini.sdk.utils;

import android.graphics.Color;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.StringTokenizer;

public class ColorUtils
{
  private static final int COLOR_RANGE = 255;
  private static final int HEX = 16;
  private static final String RGB = "rgb";
  private static final String RGBA = "rgba";
  private static final String RGBADELIM = "rgba()";
  private static final String RGBDELIM = "rgb()";
  private static final String TAG = "ColorUtils";
  private static final HashMap<String, Integer> sColorNameMap = new HashMap();
  
  static
  {
    sColorNameMap.put("transparent", Integer.valueOf(0));
    sColorNameMap.put("none", Integer.valueOf(0));
    sColorNameMap.put("aliceblue", Integer.valueOf(-984833));
    sColorNameMap.put("antiquewhite", Integer.valueOf(-332841));
    sColorNameMap.put("aqua", Integer.valueOf(-16711681));
    sColorNameMap.put("aquamarine", Integer.valueOf(-8388652));
    sColorNameMap.put("azure", Integer.valueOf(-983041));
    sColorNameMap.put("beige", Integer.valueOf(-657956));
    sColorNameMap.put("bisque", Integer.valueOf(-6972));
    sColorNameMap.put("black", Integer.valueOf(-16777216));
    sColorNameMap.put("blanchedalmond", Integer.valueOf(-5171));
    sColorNameMap.put("blue", Integer.valueOf(-16776961));
    sColorNameMap.put("blueViolet", Integer.valueOf(-7722014));
    sColorNameMap.put("brown", Integer.valueOf(-5952982));
    sColorNameMap.put("burlywood", Integer.valueOf(-2180985));
    sColorNameMap.put("cadetblue", Integer.valueOf(-10510688));
    sColorNameMap.put("chartreuse", Integer.valueOf(-8388864));
    sColorNameMap.put("chocolate", Integer.valueOf(-2987746));
    sColorNameMap.put("coral", Integer.valueOf(-32944));
    sColorNameMap.put("cornflowerblue", Integer.valueOf(-10185235));
    sColorNameMap.put("cornsilk", Integer.valueOf(-1828));
    sColorNameMap.put("crimson", Integer.valueOf(-2354116));
    sColorNameMap.put("cyan", Integer.valueOf(-16711681));
    sColorNameMap.put("darkblue", Integer.valueOf(-16777077));
    sColorNameMap.put("darkcyan", Integer.valueOf(-16741493));
    sColorNameMap.put("darkgoldenrod", Integer.valueOf(-4684277));
    sColorNameMap.put("darkgray", Integer.valueOf(-5658199));
    sColorNameMap.put("darkgreen", Integer.valueOf(-16751616));
    sColorNameMap.put("darkkhaki", Integer.valueOf(-4343957));
    sColorNameMap.put("darkmagenta", Integer.valueOf(-7667573));
    sColorNameMap.put("darkolivegreen", Integer.valueOf(-11179217));
    sColorNameMap.put("darkorange", Integer.valueOf(-29696));
    sColorNameMap.put("darkorchid", Integer.valueOf(-6737204));
    sColorNameMap.put("darkred", Integer.valueOf(-7667712));
    sColorNameMap.put("darksalmon", Integer.valueOf(-1468806));
    sColorNameMap.put("darkseagreen", Integer.valueOf(-7357297));
    sColorNameMap.put("darkslateblue", Integer.valueOf(-12042869));
    sColorNameMap.put("darkslategray", Integer.valueOf(-13676721));
    sColorNameMap.put("darkturquoise", Integer.valueOf(-16724271));
    sColorNameMap.put("darkviolet", Integer.valueOf(-7077677));
    sColorNameMap.put("deeppink", Integer.valueOf(-60269));
    sColorNameMap.put("deepskyblue", Integer.valueOf(-16728065));
    sColorNameMap.put("dimgray", Integer.valueOf(-9868951));
    sColorNameMap.put("dimgrey", Integer.valueOf(-9868951));
    sColorNameMap.put("dodgerblue", Integer.valueOf(-14774017));
    sColorNameMap.put("firebrick", Integer.valueOf(-5103070));
    sColorNameMap.put("floralwhite", Integer.valueOf(-1296));
    sColorNameMap.put("forestgreen", Integer.valueOf(-14513374));
    sColorNameMap.put("fuchsia", Integer.valueOf(-65281));
    sColorNameMap.put("gainsboro", Integer.valueOf(-2302756));
    sColorNameMap.put("ghostwhite", Integer.valueOf(-460545));
    sColorNameMap.put("gold", Integer.valueOf(-10496));
    sColorNameMap.put("goldenrod", Integer.valueOf(-2448096));
    sColorNameMap.put("gray", Integer.valueOf(-7829368));
    sColorNameMap.put("grey", Integer.valueOf(-8355712));
    sColorNameMap.put("green", Integer.valueOf(-16711936));
    sColorNameMap.put("greenyellow", Integer.valueOf(-5374161));
    sColorNameMap.put("honeydew", Integer.valueOf(-983056));
    sColorNameMap.put("hotpink", Integer.valueOf(-38476));
    sColorNameMap.put("indianred", Integer.valueOf(-3318692));
    sColorNameMap.put("indigo", Integer.valueOf(-11861886));
    sColorNameMap.put("ivory", Integer.valueOf(-16));
    sColorNameMap.put("khaki", Integer.valueOf(-989556));
    sColorNameMap.put("lavender", Integer.valueOf(-1644806));
    sColorNameMap.put("lavenderblush", Integer.valueOf(-3851));
    sColorNameMap.put("lawngreen", Integer.valueOf(-8586240));
    sColorNameMap.put("lemonchiffon", Integer.valueOf(-1331));
    sColorNameMap.put("lightblue", Integer.valueOf(-5383962));
    sColorNameMap.put("lightcoral", Integer.valueOf(-1015680));
    sColorNameMap.put("lightcyan", Integer.valueOf(-2031617));
    sColorNameMap.put("lightgoldenrodyellow", Integer.valueOf(-329006));
    sColorNameMap.put("lightgray", Integer.valueOf(-2894893));
    sColorNameMap.put("lightgrey", Integer.valueOf(-2894893));
    sColorNameMap.put("lightgreen", Integer.valueOf(-7278960));
    sColorNameMap.put("lightpink", Integer.valueOf(-18751));
    sColorNameMap.put("lightsalmon", Integer.valueOf(-24454));
    sColorNameMap.put("lightseagreen", Integer.valueOf(-14634326));
    sColorNameMap.put("lightskyblue", Integer.valueOf(-7876870));
    sColorNameMap.put("lightslategray", Integer.valueOf(-8943463));
    sColorNameMap.put("lightslategrey", Integer.valueOf(-8943463));
    sColorNameMap.put("lightsteelblue", Integer.valueOf(-5192482));
    sColorNameMap.put("lightyellow", Integer.valueOf(-32));
    sColorNameMap.put("lime", Integer.valueOf(-16711936));
    sColorNameMap.put("limegreen", Integer.valueOf(-13447886));
    sColorNameMap.put("linen", Integer.valueOf(-331546));
    sColorNameMap.put("magenta", Integer.valueOf(-65281));
    sColorNameMap.put("maroon", Integer.valueOf(-8388608));
    sColorNameMap.put("mediumaquamarine", Integer.valueOf(-10039894));
    sColorNameMap.put("mediumblue", Integer.valueOf(-16777011));
    sColorNameMap.put("mediumorchid", Integer.valueOf(-4565549));
    sColorNameMap.put("mediumpurple", Integer.valueOf(-7114533));
    sColorNameMap.put("mediumseagreen", Integer.valueOf(-12799119));
    sColorNameMap.put("mediumslateblue", Integer.valueOf(-8689426));
    sColorNameMap.put("mediumspringgreen", Integer.valueOf(-16713062));
    sColorNameMap.put("mediumturquoise", Integer.valueOf(-12004916));
    sColorNameMap.put("mediumvioletred", Integer.valueOf(-3730043));
    sColorNameMap.put("midnightblue", Integer.valueOf(-15132304));
    sColorNameMap.put("mintcream", Integer.valueOf(-655366));
    sColorNameMap.put("mistyrose", Integer.valueOf(-6943));
    sColorNameMap.put("moccasin", Integer.valueOf(-6987));
    sColorNameMap.put("navajowhite", Integer.valueOf(-8531));
    sColorNameMap.put("navy", Integer.valueOf(-16777088));
    sColorNameMap.put("oldlace", Integer.valueOf(-133658));
    sColorNameMap.put("olive", Integer.valueOf(-8355840));
    sColorNameMap.put("olivedrab", Integer.valueOf(-9728477));
    sColorNameMap.put("orange", Integer.valueOf(-23296));
    sColorNameMap.put("orangered", Integer.valueOf(-47872));
    sColorNameMap.put("orchid", Integer.valueOf(-2461482));
    sColorNameMap.put("palegoldenrod", Integer.valueOf(-1120086));
    sColorNameMap.put("palegreen", Integer.valueOf(-6751336));
    sColorNameMap.put("paleturquoise", Integer.valueOf(-5247250));
    sColorNameMap.put("palevioletred", Integer.valueOf(-2396013));
    sColorNameMap.put("papayawhip", Integer.valueOf(-4139));
    sColorNameMap.put("peachpuff", Integer.valueOf(-9543));
    sColorNameMap.put("peru", Integer.valueOf(-3308225));
    sColorNameMap.put("pink", Integer.valueOf(-16181));
    sColorNameMap.put("plum", Integer.valueOf(-2252579));
    sColorNameMap.put("powderblue", Integer.valueOf(-5185306));
    sColorNameMap.put("purple", Integer.valueOf(-8388480));
    sColorNameMap.put("rebeccapurple", Integer.valueOf(-10079335));
    sColorNameMap.put("red", Integer.valueOf(-65536));
    sColorNameMap.put("rosybrown", Integer.valueOf(-4419697));
    sColorNameMap.put("royalblue", Integer.valueOf(-12490271));
    sColorNameMap.put("saddlebrown", Integer.valueOf(-7650029));
    sColorNameMap.put("salmon", Integer.valueOf(-360334));
    sColorNameMap.put("sandybrown", Integer.valueOf(-744352));
    sColorNameMap.put("seagreen", Integer.valueOf(-13726889));
    sColorNameMap.put("seashell", Integer.valueOf(-2578));
    sColorNameMap.put("sienna", Integer.valueOf(-6270419));
    sColorNameMap.put("silver", Integer.valueOf(-4144960));
    sColorNameMap.put("skyblue", Integer.valueOf(-7876885));
    sColorNameMap.put("slateblue", Integer.valueOf(-9807155));
    sColorNameMap.put("slategray", Integer.valueOf(-9404272));
    sColorNameMap.put("slategrey", Integer.valueOf(-9404272));
    sColorNameMap.put("snow", Integer.valueOf(-1286));
    sColorNameMap.put("springgreen", Integer.valueOf(-16711809));
    sColorNameMap.put("steelblue", Integer.valueOf(-12156236));
    sColorNameMap.put("tan", Integer.valueOf(-2968436));
    sColorNameMap.put("teal", Integer.valueOf(-16744320));
    sColorNameMap.put("thistle", Integer.valueOf(-2572328));
    sColorNameMap.put("tomato", Integer.valueOf(-40121));
    sColorNameMap.put("turquoise", Integer.valueOf(-12525360));
    sColorNameMap.put("violet", Integer.valueOf(-1146130));
    sColorNameMap.put("wheat", Integer.valueOf(-663885));
    sColorNameMap.put("white", Integer.valueOf(-1));
    sColorNameMap.put("whitesmoke", Integer.valueOf(-657931));
    sColorNameMap.put("yellow", Integer.valueOf(-256));
    sColorNameMap.put("yellowgreen", Integer.valueOf(-6632142));
  }
  
  public static String getActualColor(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    String str = paramString.substring(paramString.length() - 2);
    paramString = paramString.substring(1, paramString.length() - 2);
    return "#" + str + paramString;
  }
  
  public static boolean isColor(String paramString)
  {
    if ((Integer)sColorNameMap.get(paramString.toLowerCase(Locale.ROOT)) != null) {
      return true;
    }
    if ((paramString.startsWith("#")) || (paramString.startsWith("rgb")) || (paramString.endsWith(")")) || (paramString.startsWith("rgba")) || (paramString.endsWith(")"))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static int parseColor(String paramString)
  {
    long l1;
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return 0;
      }
      StringTokenizer localStringTokenizer;
      if ((paramString.startsWith("rgba")) || (paramString.startsWith("rgb")))
      {
        localStringTokenizer = null;
        if (paramString.startsWith("rgba")) {
          localStringTokenizer = new StringTokenizer(paramString, "rgba()");
        }
      }
      while ((localStringTokenizer != null) && (localStringTokenizer.hasMoreElements()))
      {
        paramString = localStringTokenizer.nextToken();
        if (paramString != null)
        {
          paramString = paramString.split(",");
          if (paramString.length == 4)
          {
            return Color.argb((int)(Float.valueOf(paramString[3].trim()).floatValue() * 255.0F), Integer.valueOf(paramString[0].trim()).intValue(), Integer.valueOf(paramString[1].trim()).intValue(), Integer.valueOf(paramString[2].trim()).intValue());
            if (paramString.startsWith("rgb")) {
              localStringTokenizer = new StringTokenizer(paramString, "rgb()");
            }
          }
          else if (paramString.length == 3)
          {
            return Color.rgb(Integer.valueOf(paramString[0].trim()).intValue(), Integer.valueOf(paramString[1].trim()).intValue(), Integer.valueOf(paramString[2].trim()).intValue());
            int i;
            if (paramString.charAt(0) == '#')
            {
              long l2 = Long.parseLong(paramString.substring(1), 16);
              int k;
              int j;
              if (paramString.length() == 4)
              {
                k = Integer.parseInt(paramString.substring(1, 4), 16);
                i = k & 0xF00;
                j = k & 0xF0;
                k &= 0xF;
                l1 = Color.rgb(i >> 8 | i >> 4, j | j >> 4, k | k << 4);
                break label468;
              }
              if (paramString.length() == 5)
              {
                int m = Integer.parseInt(paramString.substring(1, 5), 16);
                i = m & 0xF;
                j = m & 0xF;
                k = m & 0xF;
                m &= 0xF;
                l1 = Color.argb(m | m << 4, i | i << 4, j | j << 4, k | k << 4);
                break label468;
              }
              if (paramString.length() == 7)
              {
                l1 = l2 | 0xFF000000;
                break label468;
              }
              l1 = l2;
              if (paramString.length() != 9) {
                break label468;
              }
              l1 = (l2 & 0xFFFFFF00) >> 8 | (0xFF & l2) << 24;
              break label468;
            }
            paramString = (Integer)sColorNameMap.get(paramString.toLowerCase(Locale.ROOT));
            if (paramString != null)
            {
              i = paramString.intValue();
              return i;
            }
          }
        }
      }
      return 0;
    }
    catch (Exception paramString)
    {
      return 0;
    }
    label468:
    return (int)l1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.ColorUtils
 * JD-Core Version:    0.7.0.1
 */