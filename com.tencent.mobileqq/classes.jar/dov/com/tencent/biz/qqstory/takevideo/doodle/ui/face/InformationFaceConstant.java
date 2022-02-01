package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.paster.QIMInformationPasterManager;
import dov.com.qq.im.capture.util.InfoStickerUtils;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.CalendarTimeStickerDrawable;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.CityStickerDrawable;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.EaseInInfoStickerDrawable;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.EaseInLocationStickerDrawable;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.ExpandLocationStickerDrawable;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.FilmDigitInfoStickerDrawable;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.InfoStickerDrawable;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.Left2RigthInfoStickerDrawable;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.LunaInfoStickerDrawable;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.RandomTextDrawable;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.TriangleLocationStickerDrawble;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.WeatherStickerDrawable;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class InformationFaceConstant
{
  private static final Set<Integer> a = new HashSet(5);
  private static final Set<Integer> b = new HashSet(5);
  
  static
  {
    a.add(Integer.valueOf(4));
    a.add(Integer.valueOf(5));
    a.add(Integer.valueOf(9));
    a.add(Integer.valueOf(10));
    b.add(Integer.valueOf(9));
    b.add(Integer.valueOf(10));
  }
  
  private InformationFaceConstant()
  {
    throw new UnsupportedOperationException("Can not create an instance.");
  }
  
  public static int a(InfomationFacePackage.Item paramItem)
  {
    int j = 0;
    int i = j;
    switch (paramItem.a)
    {
    default: 
      i = j;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "check num of download dir:" + i);
      }
      return i;
      i = 4;
      continue;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 14;
      continue;
      i = 1;
      continue;
      i = 33;
      continue;
      i = 5;
      continue;
      i = 2;
      continue;
      i = 2;
      continue;
      i = 3;
    }
  }
  
  public static BitmapDrawable a(String paramString1, Context paramContext, String paramString2)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.e("InformationFaceConstant", 2, "to be parsed" + paramString1);
      }
      localJSONObject = new JSONObject(paramString1);
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        JSONObject localJSONObject;
        if (QLog.isColorLevel()) {
          QLog.e("InformationFaceConstant", 2, localJSONException, new Object[0]);
        }
        localObject = null;
      }
      i = localObject.optInt("type", 0);
      switch (i)
      {
      case 6: 
      case 7: 
      case 8: 
      case 11: 
      default: 
        paramString1 = null;
      }
    }
    if (localJSONObject == null) {}
    for (;;)
    {
      return null;
      Object localObject;
      int i;
      while (paramString1 != null)
      {
        return new BitmapDrawable(paramContext.getResources(), paramString1.a());
        paramString1 = new Left2RigthInfoStickerDrawable(paramContext, paramString1).a(paramString1);
        paramString1 = new Left2RigthInfoStickerDrawable(paramContext, Left2RigthInfoStickerDrawable.a(i, paramString1[0], paramString2, paramString1[2]));
        continue;
        paramString1 = new EaseInLocationStickerDrawable(paramContext, paramString1).a(paramString1);
        paramString1 = new EaseInLocationStickerDrawable(paramContext, EaseInLocationStickerDrawable.a(i, paramString2, paramString1[1], paramString1[3], paramString1[2]));
        continue;
        paramString1 = new FilmDigitInfoStickerDrawable(paramContext, FilmDigitInfoStickerDrawable.a(i, new FilmDigitInfoStickerDrawable(paramContext, paramString1).a(paramString1)[1]));
        continue;
        paramString1 = new ExpandLocationStickerDrawable(paramContext, ExpandLocationStickerDrawable.a(i, new ExpandLocationStickerDrawable(paramContext, paramString1).a(paramString1)[0], paramString2));
        continue;
        paramString1 = new TriangleLocationStickerDrawble(paramContext, paramString1).a(paramString1);
        paramString1 = new TriangleLocationStickerDrawble(paramContext, TriangleLocationStickerDrawble.a(i, paramString1[0], paramString1[1], paramString2));
      }
    }
  }
  
  public static InfoStickerDrawable a(Context paramContext, String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.e("InformationFaceConstant", 2, "to be parsed" + paramString);
      }
      localJSONObject = new JSONObject(paramString);
    }
    catch (JSONException localJSONException)
    {
      Object localObject;
      for (;;)
      {
        JSONObject localJSONObject;
        if (QLog.isColorLevel()) {
          QLog.e("InformationFaceConstant", 2, localJSONException, new Object[0]);
        }
        localObject = null;
      }
      switch (localObject.optInt("type", 0))
      {
      case 8: 
      default: 
        return null;
      case 1: 
        return new EaseInInfoStickerDrawable(paramContext, paramString);
      case 2: 
        return new RandomTextDrawable(paramContext, paramString);
      case 3: 
        return new LunaInfoStickerDrawable(paramContext, paramString);
      }
    }
    if (localJSONObject == null) {
      return null;
    }
    return new Left2RigthInfoStickerDrawable(paramContext, paramString);
    return new EaseInLocationStickerDrawable(paramContext, paramString);
    return new WeatherStickerDrawable(paramContext, paramString);
    return new CityStickerDrawable(paramContext, paramString);
    return new FilmDigitInfoStickerDrawable(paramContext, paramString);
    return new ExpandLocationStickerDrawable(paramContext, paramString);
    return new TriangleLocationStickerDrawble(paramContext, paramString);
    return new CalendarTimeStickerDrawable(paramContext, paramString);
  }
  
  public static InfoStickerDrawable a(InfomationFacePackage.Item paramItem, Context paramContext, long paramLong)
  {
    int i = paramItem.a;
    String str2;
    Object localObject;
    String str1;
    switch (i)
    {
    case 8: 
    default: 
      return null;
    case 1: 
      return new EaseInInfoStickerDrawable(paramContext, EaseInInfoStickerDrawable.a(i, InfoStickerUtils.c(paramLong), InfoStickerUtils.d(paramLong), InfoStickerUtils.e(paramLong)));
    case 2: 
      return new RandomTextDrawable(paramContext, RandomTextDrawable.a(i, InfoStickerUtils.b(paramLong), InfoStickerUtils.a(paramLong)));
    case 3: 
      str2 = QIMInformationPasterManager.b(paramItem);
      paramItem = InfoStickerUtils.a(paramLong);
      localObject = str2 + File.separator + "eea02a45.ttf";
      str1 = str2 + File.separator + "outsideBorder.png";
      str2 = str2 + File.separator + "insideBorder.png";
      if (QLog.isColorLevel()) {
        QLog.d("InformationFaceConstant", 2, "luar.ttf file name:" + (String)localObject);
      }
      return new LunaInfoStickerDrawable(paramContext, LunaInfoStickerDrawable.a(i, paramItem[2], paramItem[3], paramItem[0], paramItem[1], (String)localObject, str1, str2));
    case 4: 
      str1 = QIMInformationPasterManager.b(paramItem) + File.separator + "Roboto-Condensed.ttf";
      localObject = paramItem.l;
      if (TextUtils.isEmpty(paramItem.l)) {
        localObject = HardCodeUtil.a(2131705786);
      }
      return new Left2RigthInfoStickerDrawable(paramContext, Left2RigthInfoStickerDrawable.a(i, InfoStickerUtils.b(paramLong), (String)localObject, str1));
    case 5: 
      localObject = QIMInformationPasterManager.b(paramItem);
      str1 = (String)localObject + File.separator + "Roboto-Condensed.ttf";
      str2 = (String)localObject + File.separator + "location_icon.png";
      localObject = paramItem.l;
      if (TextUtils.isEmpty(paramItem.l)) {
        localObject = HardCodeUtil.a(2131705783);
      }
      return new EaseInLocationStickerDrawable(paramContext, EaseInLocationStickerDrawable.a(i, (String)localObject, InfoStickerUtils.f(paramLong), str2, str1));
    case 6: 
      String str4 = QIMInformationPasterManager.b(paramItem);
      localObject = str4 + File.separator + "DINCond-Medium.ttf";
      str1 = str4 + File.separator + paramItem.k + ".apng";
      str2 = str4 + File.separator + "temperatureSymbol.png";
      String str3 = paramItem.j;
      str4 = str4 + File.separator + "line.png";
      int j = paramItem.c;
      if (paramItem.d == 3) {}
      for (boolean bool = true;; bool = false) {
        return new WeatherStickerDrawable(paramContext, WeatherStickerDrawable.a(i, j, str1, str3, str2, (String)localObject, str4, bool));
      }
    case 7: 
      paramItem = QIMInformationPasterManager.b(paramItem);
      return new CityStickerDrawable(paramContext, CityStickerDrawable.a(i, paramItem + File.separator + "city.bpng"));
    case 12: 
      return new FilmDigitInfoStickerDrawable(paramContext, FilmDigitInfoStickerDrawable.a(i, InfoStickerUtils.g(paramLong)));
    case 9: 
      str1 = paramItem.l;
      localObject = str1;
      if (TextUtils.isEmpty(str1)) {
        localObject = "YOUR CITY";
      }
      return new ExpandLocationStickerDrawable(paramContext, ExpandLocationStickerDrawable.a(i, QIMInformationPasterManager.b(paramItem) + File.separator + "location3_icon_3x.png", (String)localObject));
    case 10: 
      localObject = paramItem.l;
      return new TriangleLocationStickerDrawble(paramContext, TriangleLocationStickerDrawble.a(i, QIMInformationPasterManager.b(paramItem) + File.separator + "location4_icon.png", QIMInformationPasterManager.b(paramItem) + File.separator + "lantingzhonghei.ttf", (String)localObject));
    }
    return new CalendarTimeStickerDrawable(paramContext, CalendarTimeStickerDrawable.a(i, QIMInformationPasterManager.b(paramItem) + File.separator + "up.png", QIMInformationPasterManager.b(paramItem) + File.separator + "down.png", InfoStickerUtils.h(paramLong), InfoStickerUtils.i(paramLong)));
  }
  
  public static InfoStickerDrawable a(InfoStickerDrawable paramInfoStickerDrawable, Context paramContext, String paramString)
  {
    switch (paramInfoStickerDrawable.a())
    {
    case 3: 
    case 6: 
    case 7: 
    case 8: 
    default: 
      return null;
    case 1: 
      return new EaseInInfoStickerDrawable(paramContext, EaseInInfoStickerDrawable.a(paramInfoStickerDrawable.a(), InfoStickerUtils.c(-1L), InfoStickerUtils.d(-1L), InfoStickerUtils.e(-1L)));
    case 2: 
      return new RandomTextDrawable(paramContext, RandomTextDrawable.a(paramInfoStickerDrawable.a(), InfoStickerUtils.b(-1L), InfoStickerUtils.a(-1L)));
    case 4: 
      paramInfoStickerDrawable = (Left2RigthInfoStickerDrawable)paramInfoStickerDrawable;
      return new Left2RigthInfoStickerDrawable(paramContext, Left2RigthInfoStickerDrawable.a(paramInfoStickerDrawable.a(), paramInfoStickerDrawable.a(), paramString, paramInfoStickerDrawable.b()));
    case 5: 
      paramInfoStickerDrawable = (EaseInLocationStickerDrawable)paramInfoStickerDrawable;
      return new EaseInLocationStickerDrawable(paramContext, EaseInLocationStickerDrawable.a(paramInfoStickerDrawable.a(), paramString, InfoStickerUtils.f(-1L), paramInfoStickerDrawable.a(), paramInfoStickerDrawable.b()));
    case 12: 
      paramInfoStickerDrawable = (FilmDigitInfoStickerDrawable)paramInfoStickerDrawable;
      return new FilmDigitInfoStickerDrawable(paramContext, FilmDigitInfoStickerDrawable.a(paramInfoStickerDrawable.a(), paramInfoStickerDrawable.a()));
    case 11: 
      paramInfoStickerDrawable = (CalendarTimeStickerDrawable)paramInfoStickerDrawable;
      return new CalendarTimeStickerDrawable(paramContext, CalendarTimeStickerDrawable.a(paramInfoStickerDrawable.a(), paramInfoStickerDrawable.a(), paramInfoStickerDrawable.b(), InfoStickerUtils.h(-1L), InfoStickerUtils.i(-1L)));
    case 9: 
      paramInfoStickerDrawable = (ExpandLocationStickerDrawable)paramInfoStickerDrawable;
      return new ExpandLocationStickerDrawable(paramContext, ExpandLocationStickerDrawable.a(paramInfoStickerDrawable.a(), paramInfoStickerDrawable.a(), paramString));
    }
    paramInfoStickerDrawable = (TriangleLocationStickerDrawble)paramInfoStickerDrawable;
    return new TriangleLocationStickerDrawble(paramContext, TriangleLocationStickerDrawble.a(paramInfoStickerDrawable.a(), paramInfoStickerDrawable.a(), paramInfoStickerDrawable.b(), paramString));
  }
  
  public static boolean a(int paramInt)
  {
    return a.contains(Integer.valueOf(paramInt));
  }
  
  public static boolean b(int paramInt)
  {
    return b.contains(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.InformationFaceConstant
 * JD-Core Version:    0.7.0.1
 */