package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.paster.QIMInformationPasterManager;
import dov.com.qq.im.capture.util.InfoStickerUtils;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.EaseInInfoStickerDrawable;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.EaseInLocationStickerDrawable;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.InfoStickerDrawable;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.Left2RigthInfoStickerDrawable;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.LunaInfoStickerDrawable;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.RandomTextDrawable;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class InformationFaceConstant
{
  private static final Set a = new HashSet(5);
  
  static
  {
    a.add(Integer.valueOf(4));
    a.add(Integer.valueOf(5));
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
      default: 
        return null;
      }
    }
    if (localJSONObject == null) {
      return null;
    }
    return new EaseInInfoStickerDrawable(paramContext, paramString);
    return new RandomTextDrawable(paramContext, paramString);
    return new LunaInfoStickerDrawable(paramContext, paramString);
    return new Left2RigthInfoStickerDrawable(paramContext, paramString);
    return new EaseInLocationStickerDrawable(paramContext, paramString);
  }
  
  public static InfoStickerDrawable a(InfomationFacePackage.Item paramItem, Context paramContext, long paramLong)
  {
    int i = paramItem.a;
    Object localObject = (QIMInformationPasterManager)QIMManager.a().c(12);
    switch (i)
    {
    default: 
      return null;
    case 1: 
      return new EaseInInfoStickerDrawable(paramContext, EaseInInfoStickerDrawable.a(i, InfoStickerUtils.c(paramLong), InfoStickerUtils.d(paramLong), InfoStickerUtils.e(paramLong)));
    case 2: 
      return new RandomTextDrawable(paramContext, RandomTextDrawable.a(i, InfoStickerUtils.b(paramLong), InfoStickerUtils.a(paramLong)));
    case 3: 
      localObject = InfoStickerUtils.a(paramLong);
      str1 = QIMInformationPasterManager.b(paramItem) + File.separator + "eea02a45.ttf";
      str2 = QIMInformationPasterManager.b(paramItem) + File.separator + "outsideBorder.png";
      paramItem = QIMInformationPasterManager.b(paramItem) + File.separator + "insideBorder.png";
      if (QLog.isColorLevel()) {
        QLog.d("InformationFaceConstant", 2, "luar.ttf file name:" + str1);
      }
      return new LunaInfoStickerDrawable(paramContext, LunaInfoStickerDrawable.a(i, localObject[2], localObject[3], localObject[0], localObject[1], str1, str2, paramItem));
    case 4: 
      str1 = QIMInformationPasterManager.b(paramItem) + File.separator + "Roboto-Condensed.ttf";
      localObject = paramItem.g;
      if (TextUtils.isEmpty(paramItem.g)) {
        localObject = "你所在的位置";
      }
      return new Left2RigthInfoStickerDrawable(paramContext, Left2RigthInfoStickerDrawable.a(i, InfoStickerUtils.b(paramLong), (String)localObject, str1));
    }
    String str1 = QIMInformationPasterManager.b(paramItem) + File.separator + "Roboto-Condensed.ttf";
    String str2 = QIMInformationPasterManager.b(paramItem) + File.separator + "location_icon.png";
    localObject = paramItem.g;
    if (TextUtils.isEmpty(paramItem.g)) {
      localObject = "你的所在位置…";
    }
    return new EaseInLocationStickerDrawable(paramContext, EaseInLocationStickerDrawable.a(i, (String)localObject, InfoStickerUtils.f(paramLong), str2, str1));
  }
  
  public static InfoStickerDrawable a(InfoStickerDrawable paramInfoStickerDrawable, Context paramContext, String paramString)
  {
    switch (paramInfoStickerDrawable.a())
    {
    case 3: 
    default: 
      return null;
    case 1: 
      return new EaseInInfoStickerDrawable(paramContext, EaseInInfoStickerDrawable.a(paramInfoStickerDrawable.a(), InfoStickerUtils.c(-1L), InfoStickerUtils.d(-1L), InfoStickerUtils.e(-1L)));
    case 2: 
      return new RandomTextDrawable(paramContext, RandomTextDrawable.a(paramInfoStickerDrawable.a(), InfoStickerUtils.b(-1L), InfoStickerUtils.a(-1L)));
    case 4: 
      paramInfoStickerDrawable = (Left2RigthInfoStickerDrawable)paramInfoStickerDrawable;
      return new Left2RigthInfoStickerDrawable(paramContext, Left2RigthInfoStickerDrawable.a(paramInfoStickerDrawable.a(), paramInfoStickerDrawable.a(), paramString, paramInfoStickerDrawable.b()));
    }
    paramInfoStickerDrawable = (EaseInLocationStickerDrawable)paramInfoStickerDrawable;
    return new EaseInLocationStickerDrawable(paramContext, EaseInLocationStickerDrawable.a(paramInfoStickerDrawable.a(), paramString, InfoStickerUtils.f(-1L), paramInfoStickerDrawable.a(), paramInfoStickerDrawable.b()));
  }
  
  public static boolean a(int paramInt)
  {
    return a.contains(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.InformationFaceConstant
 * JD-Core Version:    0.7.0.1
 */