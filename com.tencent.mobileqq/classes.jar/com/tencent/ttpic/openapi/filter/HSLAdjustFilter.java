package com.tencent.ttpic.openapi.filter;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.util.AlgoUtils;
import java.util.Map;

public class HSLAdjustFilter
  extends BaseFilter
{
  private static final String FRAGMENT_SHADER = "precision highp float;\n \n varying highp vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;\n \n uniform float hueAdjustRed;\n uniform float satAdjustRed;\n uniform float lumAdjustRed;\n uniform float hueAdjustOrange;\n uniform float satAdjustOrange;\n uniform float lumAdjustOrange;\n uniform float hueAdjustYellow;\n uniform float satAdjustYellow;\n uniform float lumAdjustYellow;\n uniform float hueAdjustGreen;\n uniform float satAdjustGreen;\n uniform float lumAdjustGreen;\n uniform float hueAdjustCyan;\n uniform float satAdjustCyan;\n uniform float lumAdjustCyan;\n uniform float hueAdjustBlue;\n uniform float satAdjustBlue;\n uniform float lumAdjustBlue;\n uniform float hueAdjustPurple;\n uniform float satAdjustPurple;\n uniform float lumAdjustPurple;\n uniform float hueAdjustMagenta;\n uniform float satAdjustMagenta;\n uniform float lumAdjustMagenta;\n uniform float hueAdjustSelectColor;\n uniform float satAdjustSelectColor;\n uniform float lumAdjustSelectColor;\n uniform float hueAdjustAll;\n uniform float satAdjustAll;\n uniform float lumAdjustAll;\n \n uniform float hueCenterSelectColor;\n uniform float hueRangeSelectColor;\n \n uniform float hueCenterRed;\n uniform float hueRangeRed;\n \n uniform float hueCenterOrange;\n uniform float hueRangeOrange;\n \n uniform float hueCenterYellow;\n uniform float hueRangeYellow;\n \n uniform float hueCenterGreen;\n uniform float hueRangeGreen;\n \n uniform float hueCenterCyan;\n uniform float hueRangeCyan;\n \n uniform float hueCenterBlue;\n uniform float hueRangeBlue;\n \n uniform float hueCenterPurple;\n uniform float hueRangePurple;\n \n uniform float hueCenterMagenta;\n uniform float hueRangeMagenta;\n \n uniform float brightYellow;\n uniform float brightCyan;\n uniform float brightPurple;\n uniform float brightMagenta;\n// const float hueCenterRed = 0.9861;\n// const float hueRangeRed = 0.0833;\n// const float hueCenterOrange = 0.0625;\n// const float hueRangeOrange = 0.0694;\n// const float hueCenterYellow = 0.1319;\n// const float hueRangeYellow = 0.0694;\n// const float hueCenterGreen = 0.3125;\n// const float hueRangeGreen = 0.2917;\n// const float hueCenterCyan = 0.5208;\n// const float hueRangeCyan = 0.125;\n// const float hueCenterBlue = 0.6528;\n// const float hueRangeBlue = 0.1389;\n// const float hueCenterPurple = 0.75;\n// const float hueRangePurple = 0.0556;\n// const float hueCenterMagenta = 0.8611;\n// const float hueRangeMagenta = 0.1667;\n \n #if 0\n vec3 rgbToHsl(vec3 rgbColor) {\n     float rgbMin = min(rgbColor.r, min(rgbColor.g, rgbColor.b));\n     float rgbMax = max(rgbColor.r, max(rgbColor.g, rgbColor.b));\n     vec3 hslColor = vec3(0.0, 0.0, (rgbMin + rgbMax) * 0.5);\n     if (rgbMin != rgbMax) {\n         if (rgbMax == rgbColor.r) {\n             if (rgbColor.g >= rgbColor.b) {\n                 hslColor.x = (1.0 / 6.0) * (rgbColor.g - rgbColor.b) / (rgbMax - rgbMin);\n             } else {\n                 hslColor.x = (1.0 / 6.0) * (rgbColor.g - rgbColor.b) / (rgbMax - rgbMin) + 1.0;\n             }\n         } else if (rgbMax == rgbColor.g) {\n             hslColor.x = (1.0 / 6.0) * (rgbColor.b - rgbColor.r) / (rgbMax - rgbMin) + 1.0 / 3.0;\n         } else {\n             hslColor.x = (1.0 / 6.0) * (rgbColor.r - rgbColor.g) / (rgbMax - rgbMin) + 2.0 / 3.0;\n         }\n         \n         if (hslColor.z > 0.0) {\n             if (hslColor.z <= 0.5) {\n                 hslColor.y = (rgbMax - rgbMin) * 0.5 / hslColor.z;\n             } else {\n                 hslColor.y = (rgbMax - rgbMin) * 0.5 / (1.0 - hslColor.z);\n             }\n         }\n     }\n     return hslColor;\n }\n \n float hue2rgb(float p, float q, float t){\n     if(t < 0.0) t += 1.0;\n     if(t > 1.0) t -= 1.0;\n     if(t < 1.0/6.0) return p + (q - p) * 6.0 * t;\n     if(t < 1.0/2.0) return q;\n     if(t < 2.0/3.0) return p + (q - p) * (2.0/3.0 - t) * 6.0;\n     return p;\n }\n vec3 hslToRgb(vec3 hslColor) {\n     vec3 rgbColor = vec3(hslColor.z);\n     if(hslColor.y > 0.0){\n         float q = hslColor.z < 0.5 ? hslColor.z * (1.0 + hslColor.y) : hslColor.z + hslColor.y - hslColor.z * hslColor.y;\n         float p = 2.0 * hslColor.z - q;\n         rgbColor.r = hue2rgb(p, q, hslColor.x + 1.0/3.0);\n         rgbColor.g = hue2rgb(p, q, hslColor.x);\n         rgbColor.b = hue2rgb(p, q, hslColor.x - 1.0/3.0);\n     }\n     return rgbColor;\n }\n#endif\n \n vec3 rgbToHsv(vec3 c) {\n     vec4 K = vec4(0.0, -1.0 / 3.0, 2.0 / 3.0, -1.0);\n     vec4 p = c.g < c.b ? vec4(c.bg, K.wz) : vec4(c.gb, K.xy);\n     vec4 q = c.r < p.x ? vec4(p.xyw, c.r) : vec4(c.r, p.yzx);\n     \n     float d = q.x - min(q.w, q.y);\n     float e = 1.0e-10;\n     return vec3(abs(q.z + (q.w - q.y) / (6.0 * d + e)), d / (q.x + e), q.x);\n }\n \n vec3 hsvToRgb(vec3 c) {\n     vec4 K = vec4(1.0, 2.0 / 3.0, 1.0 / 3.0, 3.0);\n     vec3 p = abs(fract(c.xxx + K.xyz) * 6.0 - K.www);\n     return c.z * mix(K.xxx, clamp(p - K.xxx, 0.0, 1.0), c.y);\n }\n \n float getAdjustStrength(vec3 hslColor, vec3 hslMinus, vec3 hslPlus, float hueCenter, float hueRange) {\n     vec3 hslTarget = vec3(hueCenter, 0.7, 0.6);\n     float hueDistance = min(abs(hslColor.x-hslTarget.x), min(abs(hslMinus.x-hslTarget.x), abs(hslPlus.x-hslTarget.x)));\n     float hueStrength = min(1.0, hueDistance / hueRange);\n     float adjustStrength = hueStrength<0.5 ? 1.0-hueStrength*hueStrength*2.0 : (1.0-hueStrength)*(1.0-hueStrength)*2.0;\n     float satThreshold = 0.2;\n     float satStrength = min(1.0, hslColor.y / satThreshold);\n     adjustStrength *= satStrength * satStrength;\n     return adjustStrength;\n }\n \n vec3 adjustHslColor(vec3 hslColor, float hueAdjust, float satAdjust, float lumAdjust) {\n     vec3 adjustedHslColor = hslColor;\n     if (abs(hueAdjust) >= 0.01) {\n         adjustedHslColor.x += hueAdjust / 10.0;\n         if (adjustedHslColor.x < 0.0) {\n             adjustedHslColor.x += 1.0;\n         } else if (adjustedHslColor.x > 1.0) {\n             adjustedHslColor.x -= 1.0;\n         }\n     }\n     adjustedHslColor.y = clamp(adjustedHslColor.y * (satAdjust + 1.0), 0.0, 1.0);\n     adjustedHslColor.z = clamp(adjustedHslColor.z * (lumAdjust * 0.3 + 1.0), 0.0, 1.0);\n     return adjustedHslColor;\n }\n \n void main() {\n     vec4 iColor = texture2D(inputImageTexture, textureCoordinate);\n     \n     vec3 hslColor = rgbToHsv(iColor.rgb);\n     vec3 hslMinus = vec3(hslColor.x - 1.0, hslColor.y, hslColor.z);\n     vec3 hslPlus = vec3(hslColor.x + 1.0, hslColor.y, hslColor.z);\n     \n     float hueAdjustStrength = hueAdjustAll;\n     float satAdjustStrength = satAdjustAll;\n     float lumAdjustStrength = lumAdjustAll;\n     \n     // 红色\n     float adjustStrengthRed = getAdjustStrength(hslColor, hslMinus, hslPlus, hueCenterRed, hueRangeRed);\n     if (adjustStrengthRed > 0.0) {\n         hueAdjustStrength += adjustStrengthRed * 0.4 * hueAdjustRed;\n         satAdjustStrength += adjustStrengthRed * 0.3 * satAdjustRed;\n         lumAdjustStrength += adjustStrengthRed * 0.3 * lumAdjustRed;\n     }\n     \n     // 橙色\n     float adjustStrengthOrange = getAdjustStrength(hslColor, hslMinus, hslPlus, hueCenterOrange, hueRangeOrange);\n     if (adjustStrengthOrange > 0.0) {\n         hueAdjustStrength += adjustStrengthOrange * 0.2 * hueAdjustOrange;\n         satAdjustStrength += adjustStrengthOrange * 0.5 * satAdjustOrange;\n         lumAdjustStrength += adjustStrengthOrange * 0.3 * lumAdjustOrange;\n     }\n     \n     // 蓝色\n     float adjustStrengthBlue = getAdjustStrength(hslColor, hslMinus, hslPlus, hueCenterBlue, hueRangeBlue);\n     if (adjustStrengthBlue > 0.0) {\n         hueAdjustStrength += adjustStrengthBlue * hueAdjustBlue;\n         satAdjustStrength += adjustStrengthBlue * satAdjustBlue;\n         lumAdjustStrength += adjustStrengthBlue * lumAdjustBlue;\n     }\n     \n     // 绿色\n     float adjustStrengthGreen = getAdjustStrength(hslColor, hslMinus, hslPlus, hueCenterGreen, hueRangeGreen);\n     if (adjustStrengthGreen > 0.0) {\n         hueAdjustStrength += adjustStrengthGreen * hueAdjustGreen;\n         satAdjustStrength += adjustStrengthGreen * satAdjustGreen;\n         lumAdjustStrength += adjustStrengthGreen * lumAdjustGreen;\n     }\n     \n     // 选色1\n     float adjustStrengthYellow = getAdjustStrength(hslColor, hslMinus, hslPlus, hueCenterYellow, hueRangeYellow);\n     if (adjustStrengthYellow > 0.0) {\n         hueAdjustStrength += adjustStrengthYellow * 0.5 * hueAdjustYellow;\n         satAdjustStrength += adjustStrengthYellow * 0.5 * satAdjustYellow;\n         lumAdjustStrength += adjustStrengthYellow * 0.3 * lumAdjustYellow;\n     } else if (hueCenterYellow == 0.0 && brightYellow == 1.0) {\n         // 纯白色优化\n         lumAdjustStrength += 0.3 * lumAdjustYellow;\n     }\n     \n     // 选色2\n     float adjustStrengthMagenta = getAdjustStrength(hslColor, hslMinus, hslPlus, hueCenterMagenta, hueRangeMagenta);\n     if (adjustStrengthMagenta > 0.0) {\n         hueAdjustStrength += adjustStrengthMagenta * 0.5 * hueAdjustMagenta;\n         satAdjustStrength += adjustStrengthMagenta * 0.5 * satAdjustMagenta;\n         lumAdjustStrength += adjustStrengthMagenta * 0.3 * lumAdjustMagenta;\n     } else if (hueCenterMagenta == 0.0 && brightMagenta == 1.0) {\n         // 纯白色优化\n         lumAdjustStrength += 0.3 * lumAdjustMagenta;\n     }\n     \n     // 选色3\n     float adjustStrengthPurple = getAdjustStrength(hslColor, hslMinus, hslPlus, hueCenterPurple, hueRangePurple);\n     if (adjustStrengthPurple > 0.0) {\n         hueAdjustStrength += adjustStrengthPurple * 0.5 * hueAdjustPurple;\n         satAdjustStrength += adjustStrengthPurple * 0.5 * satAdjustPurple;\n         lumAdjustStrength += adjustStrengthPurple * 0.3 * lumAdjustPurple;\n     } else if (hueCenterPurple == 0.0 && brightPurple == 1.0) {\n         // 纯白色优化\n         lumAdjustStrength += 0.3 * lumAdjustPurple;\n     }\n     \n     // 选色4\n     float adjustStrengthCyan = getAdjustStrength(hslColor, hslMinus, hslPlus, hueCenterCyan, hueRangeCyan);\n     if (adjustStrengthCyan > 0.0) {\n         hueAdjustStrength += adjustStrengthCyan * 0.5 * hueAdjustCyan;\n         satAdjustStrength += adjustStrengthCyan * 0.5 * satAdjustCyan;\n         lumAdjustStrength += adjustStrengthCyan * 0.3 * lumAdjustCyan;\n     } else if (hueCenterCyan == 0.0 && brightCyan == 1.0) {\n         // 纯白色优化\n         lumAdjustStrength += 0.3 * lumAdjustCyan;\n     }\n     \n     // 自由选色\n     float adjustStrengthSelectColor = getAdjustStrength(hslColor, hslMinus, hslPlus, hueCenterSelectColor, hueRangeSelectColor);\n     if (adjustStrengthSelectColor > 0.0) {\n         hueAdjustStrength += adjustStrengthSelectColor * 0.5 * hueAdjustSelectColor;\n         satAdjustStrength += adjustStrengthSelectColor * 0.5 * satAdjustSelectColor;\n         lumAdjustStrength += adjustStrengthSelectColor * 0.3 * lumAdjustSelectColor;\n     }\n     \n     vec3 adjustedHslColor = adjustHslColor(hslColor, hueAdjustStrength, satAdjustStrength, lumAdjustStrength);\n     \n     vec3 oColor = hsvToRgb(adjustedHslColor);\n     gl_FragColor = vec4(oColor, iColor.a);\n     \n//     if (adjustStrengthYellow == 0.0) {\n//         gl_FragColor = vec4(0.5, 0.5, 0.5, iColor.a);\n//     }\n }\n";
  private static final String TAG = "HSLAdjustFilter";
  public static final String Uni_brightCyan = "brightCyan";
  public static final String Uni_brightMagenta = "brightMagenta";
  public static final String Uni_brightPurple = "brightPurple";
  public static final String Uni_brightYellow = "brightYellow";
  public static final String Uni_hueAdjustAll = "hueAdjustAll";
  public static final String Uni_hueAdjustBlue = "hueAdjustBlue";
  public static final String Uni_hueAdjustCyan = "hueAdjustCyan";
  public static final String Uni_hueAdjustGreen = "hueAdjustGreen";
  public static final String Uni_hueAdjustMagenta = "hueAdjustMagenta";
  public static final String Uni_hueAdjustOrange = "hueAdjustOrange";
  public static final String Uni_hueAdjustPurple = "hueAdjustPurple";
  public static final String Uni_hueAdjustRed = "hueAdjustRed";
  public static final String Uni_hueAdjustSelectColor = "hueAdjustSelectColor";
  public static final String Uni_hueAdjustYellow = "hueAdjustYellow";
  public static final String Uni_hueCenterBlue = "hueCenterBlue";
  public static final String Uni_hueCenterCyan = "hueCenterCyan";
  public static final String Uni_hueCenterGreen = "hueCenterGreen";
  public static final String Uni_hueCenterMagenta = "hueCenterMagenta";
  public static final String Uni_hueCenterOrange = "hueCenterOrange";
  public static final String Uni_hueCenterPurple = "hueCenterPurple";
  public static final String Uni_hueCenterRed = "hueCenterRed";
  public static final String Uni_hueCenterSelectColor = "hueCenterSelectColor";
  public static final String Uni_hueCenterYellow = "hueCenterYellow";
  public static final String Uni_hueRangeBlue = "hueRangeBlue";
  public static final String Uni_hueRangeCyan = "hueRangeCyan";
  public static final String Uni_hueRangeGreen = "hueRangeGreen";
  public static final String Uni_hueRangeMagenta = "hueRangeMagenta";
  public static final String Uni_hueRangeOrange = "hueRangeOrange";
  public static final String Uni_hueRangePurple = "hueRangePurple";
  public static final String Uni_hueRangeRed = "hueRangeRed";
  public static final String Uni_hueRangeSelectColor = "hueRangeSelectColor";
  public static final String Uni_hueRangeYellow = "hueRangeYellow";
  public static final String Uni_lumAdjustAll = "lumAdjustAll";
  public static final String Uni_lumAdjustBlue = "lumAdjustBlue";
  public static final String Uni_lumAdjustCyan = "lumAdjustCyan";
  public static final String Uni_lumAdjustGreen = "lumAdjustGreen";
  public static final String Uni_lumAdjustMagenta = "lumAdjustMagenta";
  public static final String Uni_lumAdjustOrange = "lumAdjustOrange";
  public static final String Uni_lumAdjustPurple = "lumAdjustPurple";
  public static final String Uni_lumAdjustRed = "lumAdjustRed";
  public static final String Uni_lumAdjustSelectColor = "lumAdjustSelectColor";
  public static final String Uni_lumAdjustYellow = "lumAdjustYellow";
  public static final String Uni_satAdjustAll = "satAdjustAll";
  public static final String Uni_satAdjustBlue = "satAdjustBlue";
  public static final String Uni_satAdjustCyan = "satAdjustCyan";
  public static final String Uni_satAdjustGreen = "satAdjustGreen";
  public static final String Uni_satAdjustMagenta = "satAdjustMagenta";
  public static final String Uni_satAdjustOrange = "satAdjustOrange";
  public static final String Uni_satAdjustPurple = "satAdjustPurple";
  public static final String Uni_satAdjustRed = "satAdjustRed";
  public static final String Uni_satAdjustSelectColor = "satAdjustSelectColor";
  public static final String Uni_satAdjustYellow = "satAdjustYellow";
  
  public HSLAdjustFilter()
  {
    super("precision highp float;\n \n varying highp vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;\n \n uniform float hueAdjustRed;\n uniform float satAdjustRed;\n uniform float lumAdjustRed;\n uniform float hueAdjustOrange;\n uniform float satAdjustOrange;\n uniform float lumAdjustOrange;\n uniform float hueAdjustYellow;\n uniform float satAdjustYellow;\n uniform float lumAdjustYellow;\n uniform float hueAdjustGreen;\n uniform float satAdjustGreen;\n uniform float lumAdjustGreen;\n uniform float hueAdjustCyan;\n uniform float satAdjustCyan;\n uniform float lumAdjustCyan;\n uniform float hueAdjustBlue;\n uniform float satAdjustBlue;\n uniform float lumAdjustBlue;\n uniform float hueAdjustPurple;\n uniform float satAdjustPurple;\n uniform float lumAdjustPurple;\n uniform float hueAdjustMagenta;\n uniform float satAdjustMagenta;\n uniform float lumAdjustMagenta;\n uniform float hueAdjustSelectColor;\n uniform float satAdjustSelectColor;\n uniform float lumAdjustSelectColor;\n uniform float hueAdjustAll;\n uniform float satAdjustAll;\n uniform float lumAdjustAll;\n \n uniform float hueCenterSelectColor;\n uniform float hueRangeSelectColor;\n \n uniform float hueCenterRed;\n uniform float hueRangeRed;\n \n uniform float hueCenterOrange;\n uniform float hueRangeOrange;\n \n uniform float hueCenterYellow;\n uniform float hueRangeYellow;\n \n uniform float hueCenterGreen;\n uniform float hueRangeGreen;\n \n uniform float hueCenterCyan;\n uniform float hueRangeCyan;\n \n uniform float hueCenterBlue;\n uniform float hueRangeBlue;\n \n uniform float hueCenterPurple;\n uniform float hueRangePurple;\n \n uniform float hueCenterMagenta;\n uniform float hueRangeMagenta;\n \n uniform float brightYellow;\n uniform float brightCyan;\n uniform float brightPurple;\n uniform float brightMagenta;\n// const float hueCenterRed = 0.9861;\n// const float hueRangeRed = 0.0833;\n// const float hueCenterOrange = 0.0625;\n// const float hueRangeOrange = 0.0694;\n// const float hueCenterYellow = 0.1319;\n// const float hueRangeYellow = 0.0694;\n// const float hueCenterGreen = 0.3125;\n// const float hueRangeGreen = 0.2917;\n// const float hueCenterCyan = 0.5208;\n// const float hueRangeCyan = 0.125;\n// const float hueCenterBlue = 0.6528;\n// const float hueRangeBlue = 0.1389;\n// const float hueCenterPurple = 0.75;\n// const float hueRangePurple = 0.0556;\n// const float hueCenterMagenta = 0.8611;\n// const float hueRangeMagenta = 0.1667;\n \n #if 0\n vec3 rgbToHsl(vec3 rgbColor) {\n     float rgbMin = min(rgbColor.r, min(rgbColor.g, rgbColor.b));\n     float rgbMax = max(rgbColor.r, max(rgbColor.g, rgbColor.b));\n     vec3 hslColor = vec3(0.0, 0.0, (rgbMin + rgbMax) * 0.5);\n     if (rgbMin != rgbMax) {\n         if (rgbMax == rgbColor.r) {\n             if (rgbColor.g >= rgbColor.b) {\n                 hslColor.x = (1.0 / 6.0) * (rgbColor.g - rgbColor.b) / (rgbMax - rgbMin);\n             } else {\n                 hslColor.x = (1.0 / 6.0) * (rgbColor.g - rgbColor.b) / (rgbMax - rgbMin) + 1.0;\n             }\n         } else if (rgbMax == rgbColor.g) {\n             hslColor.x = (1.0 / 6.0) * (rgbColor.b - rgbColor.r) / (rgbMax - rgbMin) + 1.0 / 3.0;\n         } else {\n             hslColor.x = (1.0 / 6.0) * (rgbColor.r - rgbColor.g) / (rgbMax - rgbMin) + 2.0 / 3.0;\n         }\n         \n         if (hslColor.z > 0.0) {\n             if (hslColor.z <= 0.5) {\n                 hslColor.y = (rgbMax - rgbMin) * 0.5 / hslColor.z;\n             } else {\n                 hslColor.y = (rgbMax - rgbMin) * 0.5 / (1.0 - hslColor.z);\n             }\n         }\n     }\n     return hslColor;\n }\n \n float hue2rgb(float p, float q, float t){\n     if(t < 0.0) t += 1.0;\n     if(t > 1.0) t -= 1.0;\n     if(t < 1.0/6.0) return p + (q - p) * 6.0 * t;\n     if(t < 1.0/2.0) return q;\n     if(t < 2.0/3.0) return p + (q - p) * (2.0/3.0 - t) * 6.0;\n     return p;\n }\n vec3 hslToRgb(vec3 hslColor) {\n     vec3 rgbColor = vec3(hslColor.z);\n     if(hslColor.y > 0.0){\n         float q = hslColor.z < 0.5 ? hslColor.z * (1.0 + hslColor.y) : hslColor.z + hslColor.y - hslColor.z * hslColor.y;\n         float p = 2.0 * hslColor.z - q;\n         rgbColor.r = hue2rgb(p, q, hslColor.x + 1.0/3.0);\n         rgbColor.g = hue2rgb(p, q, hslColor.x);\n         rgbColor.b = hue2rgb(p, q, hslColor.x - 1.0/3.0);\n     }\n     return rgbColor;\n }\n#endif\n \n vec3 rgbToHsv(vec3 c) {\n     vec4 K = vec4(0.0, -1.0 / 3.0, 2.0 / 3.0, -1.0);\n     vec4 p = c.g < c.b ? vec4(c.bg, K.wz) : vec4(c.gb, K.xy);\n     vec4 q = c.r < p.x ? vec4(p.xyw, c.r) : vec4(c.r, p.yzx);\n     \n     float d = q.x - min(q.w, q.y);\n     float e = 1.0e-10;\n     return vec3(abs(q.z + (q.w - q.y) / (6.0 * d + e)), d / (q.x + e), q.x);\n }\n \n vec3 hsvToRgb(vec3 c) {\n     vec4 K = vec4(1.0, 2.0 / 3.0, 1.0 / 3.0, 3.0);\n     vec3 p = abs(fract(c.xxx + K.xyz) * 6.0 - K.www);\n     return c.z * mix(K.xxx, clamp(p - K.xxx, 0.0, 1.0), c.y);\n }\n \n float getAdjustStrength(vec3 hslColor, vec3 hslMinus, vec3 hslPlus, float hueCenter, float hueRange) {\n     vec3 hslTarget = vec3(hueCenter, 0.7, 0.6);\n     float hueDistance = min(abs(hslColor.x-hslTarget.x), min(abs(hslMinus.x-hslTarget.x), abs(hslPlus.x-hslTarget.x)));\n     float hueStrength = min(1.0, hueDistance / hueRange);\n     float adjustStrength = hueStrength<0.5 ? 1.0-hueStrength*hueStrength*2.0 : (1.0-hueStrength)*(1.0-hueStrength)*2.0;\n     float satThreshold = 0.2;\n     float satStrength = min(1.0, hslColor.y / satThreshold);\n     adjustStrength *= satStrength * satStrength;\n     return adjustStrength;\n }\n \n vec3 adjustHslColor(vec3 hslColor, float hueAdjust, float satAdjust, float lumAdjust) {\n     vec3 adjustedHslColor = hslColor;\n     if (abs(hueAdjust) >= 0.01) {\n         adjustedHslColor.x += hueAdjust / 10.0;\n         if (adjustedHslColor.x < 0.0) {\n             adjustedHslColor.x += 1.0;\n         } else if (adjustedHslColor.x > 1.0) {\n             adjustedHslColor.x -= 1.0;\n         }\n     }\n     adjustedHslColor.y = clamp(adjustedHslColor.y * (satAdjust + 1.0), 0.0, 1.0);\n     adjustedHslColor.z = clamp(adjustedHslColor.z * (lumAdjust * 0.3 + 1.0), 0.0, 1.0);\n     return adjustedHslColor;\n }\n \n void main() {\n     vec4 iColor = texture2D(inputImageTexture, textureCoordinate);\n     \n     vec3 hslColor = rgbToHsv(iColor.rgb);\n     vec3 hslMinus = vec3(hslColor.x - 1.0, hslColor.y, hslColor.z);\n     vec3 hslPlus = vec3(hslColor.x + 1.0, hslColor.y, hslColor.z);\n     \n     float hueAdjustStrength = hueAdjustAll;\n     float satAdjustStrength = satAdjustAll;\n     float lumAdjustStrength = lumAdjustAll;\n     \n     // 红色\n     float adjustStrengthRed = getAdjustStrength(hslColor, hslMinus, hslPlus, hueCenterRed, hueRangeRed);\n     if (adjustStrengthRed > 0.0) {\n         hueAdjustStrength += adjustStrengthRed * 0.4 * hueAdjustRed;\n         satAdjustStrength += adjustStrengthRed * 0.3 * satAdjustRed;\n         lumAdjustStrength += adjustStrengthRed * 0.3 * lumAdjustRed;\n     }\n     \n     // 橙色\n     float adjustStrengthOrange = getAdjustStrength(hslColor, hslMinus, hslPlus, hueCenterOrange, hueRangeOrange);\n     if (adjustStrengthOrange > 0.0) {\n         hueAdjustStrength += adjustStrengthOrange * 0.2 * hueAdjustOrange;\n         satAdjustStrength += adjustStrengthOrange * 0.5 * satAdjustOrange;\n         lumAdjustStrength += adjustStrengthOrange * 0.3 * lumAdjustOrange;\n     }\n     \n     // 蓝色\n     float adjustStrengthBlue = getAdjustStrength(hslColor, hslMinus, hslPlus, hueCenterBlue, hueRangeBlue);\n     if (adjustStrengthBlue > 0.0) {\n         hueAdjustStrength += adjustStrengthBlue * hueAdjustBlue;\n         satAdjustStrength += adjustStrengthBlue * satAdjustBlue;\n         lumAdjustStrength += adjustStrengthBlue * lumAdjustBlue;\n     }\n     \n     // 绿色\n     float adjustStrengthGreen = getAdjustStrength(hslColor, hslMinus, hslPlus, hueCenterGreen, hueRangeGreen);\n     if (adjustStrengthGreen > 0.0) {\n         hueAdjustStrength += adjustStrengthGreen * hueAdjustGreen;\n         satAdjustStrength += adjustStrengthGreen * satAdjustGreen;\n         lumAdjustStrength += adjustStrengthGreen * lumAdjustGreen;\n     }\n     \n     // 选色1\n     float adjustStrengthYellow = getAdjustStrength(hslColor, hslMinus, hslPlus, hueCenterYellow, hueRangeYellow);\n     if (adjustStrengthYellow > 0.0) {\n         hueAdjustStrength += adjustStrengthYellow * 0.5 * hueAdjustYellow;\n         satAdjustStrength += adjustStrengthYellow * 0.5 * satAdjustYellow;\n         lumAdjustStrength += adjustStrengthYellow * 0.3 * lumAdjustYellow;\n     } else if (hueCenterYellow == 0.0 && brightYellow == 1.0) {\n         // 纯白色优化\n         lumAdjustStrength += 0.3 * lumAdjustYellow;\n     }\n     \n     // 选色2\n     float adjustStrengthMagenta = getAdjustStrength(hslColor, hslMinus, hslPlus, hueCenterMagenta, hueRangeMagenta);\n     if (adjustStrengthMagenta > 0.0) {\n         hueAdjustStrength += adjustStrengthMagenta * 0.5 * hueAdjustMagenta;\n         satAdjustStrength += adjustStrengthMagenta * 0.5 * satAdjustMagenta;\n         lumAdjustStrength += adjustStrengthMagenta * 0.3 * lumAdjustMagenta;\n     } else if (hueCenterMagenta == 0.0 && brightMagenta == 1.0) {\n         // 纯白色优化\n         lumAdjustStrength += 0.3 * lumAdjustMagenta;\n     }\n     \n     // 选色3\n     float adjustStrengthPurple = getAdjustStrength(hslColor, hslMinus, hslPlus, hueCenterPurple, hueRangePurple);\n     if (adjustStrengthPurple > 0.0) {\n         hueAdjustStrength += adjustStrengthPurple * 0.5 * hueAdjustPurple;\n         satAdjustStrength += adjustStrengthPurple * 0.5 * satAdjustPurple;\n         lumAdjustStrength += adjustStrengthPurple * 0.3 * lumAdjustPurple;\n     } else if (hueCenterPurple == 0.0 && brightPurple == 1.0) {\n         // 纯白色优化\n         lumAdjustStrength += 0.3 * lumAdjustPurple;\n     }\n     \n     // 选色4\n     float adjustStrengthCyan = getAdjustStrength(hslColor, hslMinus, hslPlus, hueCenterCyan, hueRangeCyan);\n     if (adjustStrengthCyan > 0.0) {\n         hueAdjustStrength += adjustStrengthCyan * 0.5 * hueAdjustCyan;\n         satAdjustStrength += adjustStrengthCyan * 0.5 * satAdjustCyan;\n         lumAdjustStrength += adjustStrengthCyan * 0.3 * lumAdjustCyan;\n     } else if (hueCenterCyan == 0.0 && brightCyan == 1.0) {\n         // 纯白色优化\n         lumAdjustStrength += 0.3 * lumAdjustCyan;\n     }\n     \n     // 自由选色\n     float adjustStrengthSelectColor = getAdjustStrength(hslColor, hslMinus, hslPlus, hueCenterSelectColor, hueRangeSelectColor);\n     if (adjustStrengthSelectColor > 0.0) {\n         hueAdjustStrength += adjustStrengthSelectColor * 0.5 * hueAdjustSelectColor;\n         satAdjustStrength += adjustStrengthSelectColor * 0.5 * satAdjustSelectColor;\n         lumAdjustStrength += adjustStrengthSelectColor * 0.3 * lumAdjustSelectColor;\n     }\n     \n     vec3 adjustedHslColor = adjustHslColor(hslColor, hueAdjustStrength, satAdjustStrength, lumAdjustStrength);\n     \n     vec3 oColor = hsvToRgb(adjustedHslColor);\n     gl_FragColor = vec4(oColor, iColor.a);\n     \n//     if (adjustStrengthYellow == 0.0) {\n//         gl_FragColor = vec4(0.5, 0.5, 0.5, iColor.a);\n//     }\n }\n");
    initParams();
  }
  
  public void initParams()
  {
    addParam(new UniformParam.FloatParam("hueAdjustRed", 0.0F));
    addParam(new UniformParam.FloatParam("satAdjustRed", 0.0F));
    addParam(new UniformParam.FloatParam("lumAdjustRed", 0.0F));
    addParam(new UniformParam.FloatParam("hueAdjustOrange", 0.0F));
    addParam(new UniformParam.FloatParam("satAdjustOrange", 0.0F));
    addParam(new UniformParam.FloatParam("lumAdjustOrange", 0.0F));
    addParam(new UniformParam.FloatParam("hueAdjustYellow", 0.0F));
    addParam(new UniformParam.FloatParam("satAdjustYellow", 0.0F));
    addParam(new UniformParam.FloatParam("lumAdjustYellow", 0.0F));
    addParam(new UniformParam.FloatParam("hueAdjustGreen", 0.0F));
    addParam(new UniformParam.FloatParam("satAdjustGreen", 0.0F));
    addParam(new UniformParam.FloatParam("lumAdjustGreen", 0.0F));
    addParam(new UniformParam.FloatParam("hueAdjustCyan", 0.0F));
    addParam(new UniformParam.FloatParam("satAdjustCyan", 0.0F));
    addParam(new UniformParam.FloatParam("lumAdjustCyan", 0.0F));
    addParam(new UniformParam.FloatParam("hueAdjustBlue", 0.0F));
    addParam(new UniformParam.FloatParam("satAdjustBlue", 0.0F));
    addParam(new UniformParam.FloatParam("lumAdjustBlue", 0.0F));
    addParam(new UniformParam.FloatParam("hueAdjustPurple", 0.0F));
    addParam(new UniformParam.FloatParam("satAdjustPurple", 0.0F));
    addParam(new UniformParam.FloatParam("lumAdjustPurple", 0.0F));
    addParam(new UniformParam.FloatParam("hueAdjustMagenta", 0.0F));
    addParam(new UniformParam.FloatParam("satAdjustMagenta", 0.0F));
    addParam(new UniformParam.FloatParam("lumAdjustMagenta", 0.0F));
    addParam(new UniformParam.FloatParam("hueAdjustSelectColor", 0.0F));
    addParam(new UniformParam.FloatParam("satAdjustSelectColor", 0.0F));
    addParam(new UniformParam.FloatParam("lumAdjustSelectColor", 0.0F));
    addParam(new UniformParam.FloatParam("hueAdjustAll", 0.0F));
    addParam(new UniformParam.FloatParam("satAdjustAll", 0.0F));
    addParam(new UniformParam.FloatParam("lumAdjustAll", 0.0F));
    addParam(new UniformParam.FloatParam("brightYellow", 0.0F));
    addParam(new UniformParam.FloatParam("brightCyan", 0.0F));
    addParam(new UniformParam.FloatParam("brightPurple", 0.0F));
    addParam(new UniformParam.FloatParam("brightMagenta", 0.0F));
    addParam(new UniformParam.FloatParam("hueCenterRed", 0.9861F));
    addParam(new UniformParam.FloatParam("hueRangeRed", 0.0833F));
    addParam(new UniformParam.FloatParam("hueCenterOrange", 0.0833F));
    addParam(new UniformParam.FloatParam("hueRangeOrange", 0.1111F));
    addParam(new UniformParam.FloatParam("hueCenterGreen", 0.3125F));
    addParam(new UniformParam.FloatParam("hueRangeGreen", 0.2917F));
    addParam(new UniformParam.FloatParam("hueCenterBlue", 0.6041F));
    addParam(new UniformParam.FloatParam("hueRangeBlue", 0.2361F));
    addParam(new UniformParam.FloatParam("hueCenterYellow", 0.1319F));
    addParam(new UniformParam.FloatParam("hueRangeYellow", 0.0833F));
    addParam(new UniformParam.FloatParam("hueCenterCyan", 0.5208F));
    addParam(new UniformParam.FloatParam("hueRangeCyan", 0.0833F));
    addParam(new UniformParam.FloatParam("hueCenterPurple", 0.75F));
    addParam(new UniformParam.FloatParam("hueRangePurple", 0.0833F));
    addParam(new UniformParam.FloatParam("hueCenterMagenta", 0.8611F));
    addParam(new UniformParam.FloatParam("hueRangeMagenta", 0.0833F));
    addParam(new UniformParam.FloatParam("hueRangeSelectColor", 0.0F));
    addParam(new UniformParam.FloatParam("hueCenterSelectColor", 0.0F));
  }
  
  public float[] rgb2hsl(int paramInt1, int paramInt2, int paramInt3)
  {
    return AlgoUtils.rgb2HSV(paramInt1, paramInt2, paramInt3);
  }
  
  public void setParams(Map<String, Float> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    LogUtils.v(TAG, paramMap.toString());
    if (paramMap.containsKey("hueAdjustRed")) {
      addParam(new UniformParam.FloatParam("hueAdjustRed", ((Float)paramMap.get("hueAdjustRed")).floatValue()));
    }
    if (paramMap.containsKey("satAdjustRed")) {
      addParam(new UniformParam.FloatParam("satAdjustRed", ((Float)paramMap.get("satAdjustRed")).floatValue()));
    }
    if (paramMap.containsKey("lumAdjustRed")) {
      addParam(new UniformParam.FloatParam("lumAdjustRed", ((Float)paramMap.get("lumAdjustRed")).floatValue()));
    }
    if (paramMap.containsKey("hueAdjustOrange")) {
      addParam(new UniformParam.FloatParam("hueAdjustOrange", ((Float)paramMap.get("hueAdjustOrange")).floatValue()));
    }
    if (paramMap.containsKey("satAdjustOrange")) {
      addParam(new UniformParam.FloatParam("satAdjustOrange", ((Float)paramMap.get("satAdjustOrange")).floatValue()));
    }
    if (paramMap.containsKey("lumAdjustOrange")) {
      addParam(new UniformParam.FloatParam("lumAdjustOrange", ((Float)paramMap.get("lumAdjustOrange")).floatValue()));
    }
    if (paramMap.containsKey("hueAdjustYellow")) {
      addParam(new UniformParam.FloatParam("hueAdjustYellow", ((Float)paramMap.get("hueAdjustYellow")).floatValue()));
    }
    if (paramMap.containsKey("satAdjustYellow")) {
      addParam(new UniformParam.FloatParam("satAdjustYellow", ((Float)paramMap.get("satAdjustYellow")).floatValue()));
    }
    if (paramMap.containsKey("lumAdjustYellow")) {
      addParam(new UniformParam.FloatParam("lumAdjustYellow", ((Float)paramMap.get("lumAdjustYellow")).floatValue()));
    }
    if (paramMap.containsKey("hueAdjustGreen")) {
      addParam(new UniformParam.FloatParam("hueAdjustGreen", ((Float)paramMap.get("hueAdjustGreen")).floatValue()));
    }
    if (paramMap.containsKey("satAdjustGreen")) {
      addParam(new UniformParam.FloatParam("satAdjustGreen", ((Float)paramMap.get("satAdjustGreen")).floatValue()));
    }
    if (paramMap.containsKey("lumAdjustGreen")) {
      addParam(new UniformParam.FloatParam("lumAdjustGreen", ((Float)paramMap.get("lumAdjustGreen")).floatValue()));
    }
    if (paramMap.containsKey("hueAdjustCyan")) {
      addParam(new UniformParam.FloatParam("hueAdjustCyan", ((Float)paramMap.get("hueAdjustCyan")).floatValue()));
    }
    if (paramMap.containsKey("satAdjustCyan")) {
      addParam(new UniformParam.FloatParam("satAdjustCyan", ((Float)paramMap.get("satAdjustCyan")).floatValue()));
    }
    if (paramMap.containsKey("lumAdjustCyan")) {
      addParam(new UniformParam.FloatParam("lumAdjustCyan", ((Float)paramMap.get("lumAdjustCyan")).floatValue()));
    }
    if (paramMap.containsKey("hueAdjustBlue")) {
      addParam(new UniformParam.FloatParam("hueAdjustBlue", ((Float)paramMap.get("hueAdjustBlue")).floatValue()));
    }
    if (paramMap.containsKey("satAdjustBlue")) {
      addParam(new UniformParam.FloatParam("satAdjustBlue", ((Float)paramMap.get("satAdjustBlue")).floatValue()));
    }
    if (paramMap.containsKey("lumAdjustBlue")) {
      addParam(new UniformParam.FloatParam("lumAdjustBlue", ((Float)paramMap.get("lumAdjustBlue")).floatValue()));
    }
    if (paramMap.containsKey("hueAdjustPurple")) {
      addParam(new UniformParam.FloatParam("hueAdjustPurple", ((Float)paramMap.get("hueAdjustPurple")).floatValue()));
    }
    if (paramMap.containsKey("satAdjustPurple")) {
      addParam(new UniformParam.FloatParam("satAdjustPurple", ((Float)paramMap.get("satAdjustPurple")).floatValue()));
    }
    if (paramMap.containsKey("lumAdjustPurple")) {
      addParam(new UniformParam.FloatParam("lumAdjustPurple", ((Float)paramMap.get("lumAdjustPurple")).floatValue()));
    }
    if (paramMap.containsKey("hueAdjustMagenta")) {
      addParam(new UniformParam.FloatParam("hueAdjustMagenta", ((Float)paramMap.get("hueAdjustMagenta")).floatValue()));
    }
    if (paramMap.containsKey("satAdjustMagenta")) {
      addParam(new UniformParam.FloatParam("satAdjustMagenta", ((Float)paramMap.get("satAdjustMagenta")).floatValue()));
    }
    if (paramMap.containsKey("lumAdjustMagenta")) {
      addParam(new UniformParam.FloatParam("lumAdjustMagenta", ((Float)paramMap.get("lumAdjustMagenta")).floatValue()));
    }
    if (paramMap.containsKey("hueAdjustSelectColor")) {
      addParam(new UniformParam.FloatParam("hueAdjustSelectColor", ((Float)paramMap.get("hueAdjustSelectColor")).floatValue()));
    }
    if (paramMap.containsKey("satAdjustSelectColor")) {
      addParam(new UniformParam.FloatParam("satAdjustSelectColor", ((Float)paramMap.get("satAdjustSelectColor")).floatValue()));
    }
    if (paramMap.containsKey("lumAdjustSelectColor")) {
      addParam(new UniformParam.FloatParam("lumAdjustSelectColor", ((Float)paramMap.get("lumAdjustSelectColor")).floatValue()));
    }
    if (paramMap.containsKey("hueCenterSelectColor")) {
      addParam(new UniformParam.FloatParam("hueCenterSelectColor", ((Float)paramMap.get("hueCenterSelectColor")).floatValue()));
    }
    if (paramMap.containsKey("hueRangeSelectColor")) {
      addParam(new UniformParam.FloatParam("hueRangeSelectColor", ((Float)paramMap.get("hueRangeSelectColor")).floatValue()));
    }
    if (paramMap.containsKey("hueAdjustAll")) {
      addParam(new UniformParam.FloatParam("hueAdjustAll", ((Float)paramMap.get("hueAdjustAll")).floatValue()));
    }
    if (paramMap.containsKey("satAdjustAll")) {
      addParam(new UniformParam.FloatParam("satAdjustAll", ((Float)paramMap.get("satAdjustAll")).floatValue()));
    }
    if (paramMap.containsKey("lumAdjustAll")) {
      addParam(new UniformParam.FloatParam("lumAdjustAll", ((Float)paramMap.get("lumAdjustAll")).floatValue()));
    }
    if (paramMap.containsKey("hueCenterRed")) {
      addParam(new UniformParam.FloatParam("hueCenterRed", ((Float)paramMap.get("hueCenterRed")).floatValue()));
    }
    if (paramMap.containsKey("hueRangeRed")) {
      addParam(new UniformParam.FloatParam("hueRangeRed", ((Float)paramMap.get("hueRangeRed")).floatValue()));
    }
    if (paramMap.containsKey("hueCenterOrange")) {
      addParam(new UniformParam.FloatParam("hueCenterOrange", ((Float)paramMap.get("hueCenterOrange")).floatValue()));
    }
    if (paramMap.containsKey("hueRangeOrange")) {
      addParam(new UniformParam.FloatParam("hueRangeOrange", ((Float)paramMap.get("hueRangeOrange")).floatValue()));
    }
    if (paramMap.containsKey("hueCenterYellow")) {
      addParam(new UniformParam.FloatParam("hueCenterYellow", ((Float)paramMap.get("hueCenterYellow")).floatValue()));
    }
    if (paramMap.containsKey("brightYellow")) {
      addParam(new UniformParam.FloatParam("brightYellow", ((Float)paramMap.get("brightYellow")).floatValue()));
    }
    if (paramMap.containsKey("hueRangeYellow")) {
      addParam(new UniformParam.FloatParam("hueRangeYellow", ((Float)paramMap.get("hueRangeYellow")).floatValue()));
    }
    if (paramMap.containsKey("hueCenterGreen")) {
      addParam(new UniformParam.FloatParam("hueCenterGreen", ((Float)paramMap.get("hueCenterGreen")).floatValue()));
    }
    if (paramMap.containsKey("hueRangeGreen")) {
      addParam(new UniformParam.FloatParam("hueRangeGreen", ((Float)paramMap.get("hueRangeGreen")).floatValue()));
    }
    if (paramMap.containsKey("hueCenterCyan")) {
      addParam(new UniformParam.FloatParam("hueCenterCyan", ((Float)paramMap.get("hueCenterCyan")).floatValue()));
    }
    if (paramMap.containsKey("brightCyan")) {
      addParam(new UniformParam.FloatParam("brightCyan", ((Float)paramMap.get("brightCyan")).floatValue()));
    }
    if (paramMap.containsKey("hueRangeCyan")) {
      addParam(new UniformParam.FloatParam("hueRangeCyan", ((Float)paramMap.get("hueRangeCyan")).floatValue()));
    }
    if (paramMap.containsKey("hueCenterBlue")) {
      addParam(new UniformParam.FloatParam("hueCenterBlue", ((Float)paramMap.get("hueCenterBlue")).floatValue()));
    }
    if (paramMap.containsKey("hueRangeBlue")) {
      addParam(new UniformParam.FloatParam("hueRangeBlue", ((Float)paramMap.get("hueRangeBlue")).floatValue()));
    }
    if (paramMap.containsKey("hueCenterPurple")) {
      addParam(new UniformParam.FloatParam("hueCenterPurple", ((Float)paramMap.get("hueCenterPurple")).floatValue()));
    }
    if (paramMap.containsKey("brightPurple")) {
      addParam(new UniformParam.FloatParam("brightPurple", ((Float)paramMap.get("brightPurple")).floatValue()));
    }
    if (paramMap.containsKey("hueRangePurple")) {
      addParam(new UniformParam.FloatParam("hueRangePurple", ((Float)paramMap.get("hueRangePurple")).floatValue()));
    }
    if (paramMap.containsKey("hueCenterMagenta")) {
      addParam(new UniformParam.FloatParam("hueCenterMagenta", ((Float)paramMap.get("hueCenterMagenta")).floatValue()));
    }
    if (paramMap.containsKey("brightMagenta")) {
      addParam(new UniformParam.FloatParam("brightMagenta", ((Float)paramMap.get("brightMagenta")).floatValue()));
    }
    if (paramMap.containsKey("hueRangeMagenta")) {
      addParam(new UniformParam.FloatParam("hueRangeMagenta", ((Float)paramMap.get("hueRangeMagenta")).floatValue()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.HSLAdjustFilter
 * JD-Core Version:    0.7.0.1
 */