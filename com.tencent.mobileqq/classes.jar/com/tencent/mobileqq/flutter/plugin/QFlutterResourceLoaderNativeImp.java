package com.tencent.mobileqq.flutter.plugin;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.qflutter.resource_loader.NativeAppInterface;
import com.qflutter.resource_loader.NativeColorInfo;
import com.qflutter.resource_loader.NativeImageInfo;
import com.qflutter.resource_loader.NinePatchInfo;
import com.qflutter.resource_loader.Utils;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.flutter.download.QFlutterInstaller;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.theme.SkinnableNinePatchDrawable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class QFlutterResourceLoaderNativeImp
  implements NativeAppInterface
{
  public static HashMap<String, Integer> a;
  public static HashMap<String, String> b;
  public static HashMap<String, Integer> c;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ArrayList<ColorStateList> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Handler b;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashMap.put("skinConversationPageBg", Integer.valueOf(2130850361));
    jdField_a_of_type_JavaUtilHashMap.put("skinSmallBtnBlueNormal", Integer.valueOf(2130850388));
    jdField_a_of_type_JavaUtilHashMap.put("skinSmallBtnBluePressed", Integer.valueOf(2130850387));
    jdField_a_of_type_JavaUtilHashMap.put("skinAIOBubbleNormal", Integer.valueOf(2130850159));
    jdField_a_of_type_JavaUtilHashMap.put("skinPageTitleBarBg", Integer.valueOf(2130850433));
    jdField_a_of_type_JavaUtilHashMap.put("skinPageTitleBarBackNormal", Integer.valueOf(2130850447));
    jdField_a_of_type_JavaUtilHashMap.put("skinPageTitleBarBackPressed", Integer.valueOf(2130850451));
    jdField_a_of_type_JavaUtilHashMap.put("skinPageBg", Integer.valueOf(2130850359));
    jdField_a_of_type_JavaUtilHashMap.put("skinFromItemRightArrow", Integer.valueOf(2130850483));
    jdField_a_of_type_JavaUtilHashMap.put("skinListItemBgNormal", Integer.valueOf(2130850703));
    jdField_a_of_type_JavaUtilHashMap.put("skinListItemBgPressed", Integer.valueOf(2130850700));
    jdField_a_of_type_JavaUtilHashMap.put("skinListItemTopBgNormal", Integer.valueOf(2130850723));
    jdField_a_of_type_JavaUtilHashMap.put("skinListItemTopBgPressed", Integer.valueOf(2130850721));
    jdField_a_of_type_JavaUtilHashMap.put("skinListItemMiddleBgNormal", Integer.valueOf(2130850717));
    jdField_a_of_type_JavaUtilHashMap.put("skinListItemMiddleBgPressed", Integer.valueOf(2130850715));
    jdField_a_of_type_JavaUtilHashMap.put("skinListItemBottomBgNormal", Integer.valueOf(2130850708));
    jdField_a_of_type_JavaUtilHashMap.put("skinListItemBottomBgPressed", Integer.valueOf(2130850706));
    jdField_a_of_type_JavaUtilHashMap.put("skinQuiSwitchBgOff", Integer.valueOf(2130850735));
    jdField_a_of_type_JavaUtilHashMap.put("skinQuiSwitchBgOn", Integer.valueOf(2130850736));
    jdField_a_of_type_JavaUtilHashMap.put("skinQuiSwitchThumbOff", Integer.valueOf(2130850733));
    jdField_a_of_type_JavaUtilHashMap.put("skinQuiSwitchThumbOn", Integer.valueOf(2130850731));
    jdField_a_of_type_JavaUtilHashMap.put("skinQuiSwitchThumbOnPressed", Integer.valueOf(2130850732));
    jdField_a_of_type_JavaUtilHashMap.put("skinQuiSwitchThumbOffPressed", Integer.valueOf(2130850734));
    jdField_a_of_type_JavaUtilHashMap.put("skinTipsNew", Integer.valueOf(2130850769));
    jdField_a_of_type_JavaUtilHashMap.put("zanRankingDefaultCardCover", Integer.valueOf(2130845923));
    jdField_a_of_type_JavaUtilHashMap.put("zanRankingNobodyBg", Integer.valueOf(2130846092));
    jdField_a_of_type_JavaUtilHashMap.put("zanRankingGoldIcon", Integer.valueOf(2130845518));
    jdField_a_of_type_JavaUtilHashMap.put("zanRankingSilverIcon", Integer.valueOf(2130845519));
    jdField_a_of_type_JavaUtilHashMap.put("zanRankingCopperIcon", Integer.valueOf(2130845520));
    jdField_a_of_type_JavaUtilHashMap.put("zanRankingChampionIcon", Integer.valueOf(2130845513));
    jdField_a_of_type_JavaUtilHashMap.put("qzoneAlbumCategoryLockIcon", Integer.valueOf(2130848840));
    int i = 0;
    while (i < 248)
    {
      HashMap localHashMap = jdField_a_of_type_JavaUtilHashMap;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(i);
      localStringBuilder.append("");
      localHashMap.put(localStringBuilder.toString(), Integer.valueOf(EmotcationConstants.FIRST_EMOJI_RES + i));
      i += 1;
    }
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
    c = new HashMap();
    c.put("skinConversationNickBlack", Integer.valueOf(2131167063));
    c.put("skinConversationMsgGray", Integer.valueOf(2131167142));
    c.put("skinBtnBlueTextColor", Integer.valueOf(2131167089));
    c.put("skinBtnWhiteTextColor", Integer.valueOf(2131167097));
    c.put("skinPageTitleBarBtnTextColor", Integer.valueOf(2131167050));
    c.put("skinPageTitleBarTextColor", Integer.valueOf(2131167053));
    c.put("skinFormItemBlack", Integer.valueOf(2131167056));
    c.put("skinFormItemGray", Integer.valueOf(2131167139));
  }
  
  public QFlutterResourceLoaderNativeImp(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManagerV2.getFileThreadLooper());
    this.jdField_b_of_type_AndroidOsHandler = ThreadManagerV2.getUIHandlerV2();
    a();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QFlutterResourceLoaderNativeImp", 0, "preCacheColors");
    }
    Object localObject = this.jdField_a_of_type_AndroidContentContext;
    if (localObject != null)
    {
      localObject = ((Context)localObject).getResources();
      ThreadManagerV2.executeOnSubThread(new QFlutterResourceLoaderNativeImp.1(this, this.jdField_a_of_type_JavaUtilArrayList, (Resources)localObject), true);
    }
  }
  
  public Bitmap getBitmapFromDrawable(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return null;
    }
    if ((paramDrawable instanceof SkinnableBitmapDrawable)) {
      return ((SkinnableBitmapDrawable)paramDrawable).getBitmap();
    }
    if ((paramDrawable instanceof SkinnableNinePatchDrawable)) {
      return ((SkinnableNinePatchDrawable)paramDrawable).getBitmap();
    }
    return null;
  }
  
  public String getLibPath()
  {
    String str = QFlutterInstaller.a("libqflutter-resource-loader.so");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("libPath isExist: ");
    localStringBuilder.append(FileUtil.b(str));
    localStringBuilder.append(", ");
    localStringBuilder.append(str);
    QLog.d("QFlutterResourceLoaderNativeImp", 3, localStringBuilder.toString());
    return str;
  }
  
  public NativeImageInfo getNativeAppImage(String paramString)
  {
    NativeImageInfo localNativeImageInfo = new NativeImageInfo();
    if (TextUtils.isEmpty(paramString)) {
      return localNativeImageInfo;
    }
    if (jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
    {
      localNativeImageInfo.drawableId = ((Integer)jdField_a_of_type_JavaUtilHashMap.get(paramString)).intValue();
      localNativeImageInfo.scale = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
      return localNativeImageInfo;
    }
    if (jdField_b_of_type_JavaUtilHashMap.containsKey(paramString))
    {
      localNativeImageInfo.assetsPath = ((String)jdField_b_of_type_JavaUtilHashMap.get(paramString));
      return localNativeImageInfo;
    }
    if ((!paramString.startsWith("https:")) && (!paramString.startsWith("http:")) && (!paramString.startsWith("HTTPS:"))) {
      paramString.startsWith("HTTP:");
    }
    return localNativeImageInfo;
  }
  
  public List<NativeColorInfo> getNativeThemeColors()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = c.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      NativeColorInfo localNativeColorInfo = new NativeColorInfo(str);
      localNativeColorInfo.resId = ((Integer)c.get(str));
      localArrayList.add(localNativeColorInfo);
    }
    return localArrayList;
  }
  
  public NinePatchInfo getNinePatchInfo(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof SkinnableNinePatchDrawable))
    {
      paramDrawable = ((SkinnableNinePatchDrawable)paramDrawable).getBitmap();
      if (paramDrawable != null) {
        return Utils.getNinePatchInfoFromChunk(paramDrawable.getNinePatchChunk());
      }
    }
    return null;
  }
  
  public Handler getSubThreadHandler()
  {
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public String getThemeId()
  {
    return ThemeUtil.getCurrentThemeId();
  }
  
  public Handler getUiThreadHandler()
  {
    return this.jdField_b_of_type_AndroidOsHandler;
  }
  
  public boolean isNinePatchDrawable(Drawable paramDrawable)
  {
    return ((paramDrawable instanceof SkinnableNinePatchDrawable)) || ((paramDrawable instanceof NinePatchDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.plugin.QFlutterResourceLoaderNativeImp
 * JD-Core Version:    0.7.0.1
 */