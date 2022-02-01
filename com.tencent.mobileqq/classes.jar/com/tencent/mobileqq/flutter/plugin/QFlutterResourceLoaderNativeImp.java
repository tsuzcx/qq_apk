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
  public static HashMap<String, Integer> a = new HashMap();
  public static HashMap<String, String> b;
  public static HashMap<String, Integer> c;
  private Context d;
  private ArrayList<ColorStateList> e = new ArrayList();
  private Handler f;
  private Handler g;
  
  static
  {
    a.put("skinConversationPageBg", Integer.valueOf(2130852152));
    a.put("skinSmallBtnBlueNormal", Integer.valueOf(2130852179));
    a.put("skinSmallBtnBluePressed", Integer.valueOf(2130852178));
    a.put("skinAIOBubbleNormal", Integer.valueOf(2130851944));
    a.put("skinPageTitleBarBg", Integer.valueOf(2130852228));
    a.put("skinPageTitleBarBackNormal", Integer.valueOf(2130852243));
    a.put("skinPageTitleBarBackPressed", Integer.valueOf(2130852247));
    a.put("skinPageBg", Integer.valueOf(2130852150));
    a.put("skinFromItemRightArrow", Integer.valueOf(2130852279));
    a.put("skinListItemBgNormal", Integer.valueOf(2130852507));
    a.put("skinListItemBgPressed", Integer.valueOf(2130852504));
    a.put("skinListItemTopBgNormal", Integer.valueOf(2130852527));
    a.put("skinListItemTopBgPressed", Integer.valueOf(2130852525));
    a.put("skinListItemMiddleBgNormal", Integer.valueOf(2130852521));
    a.put("skinListItemMiddleBgPressed", Integer.valueOf(2130852519));
    a.put("skinListItemBottomBgNormal", Integer.valueOf(2130852512));
    a.put("skinListItemBottomBgPressed", Integer.valueOf(2130852510));
    a.put("skinQuiSwitchBgOff", Integer.valueOf(2130852539));
    a.put("skinQuiSwitchBgOn", Integer.valueOf(2130852540));
    a.put("skinQuiSwitchThumbOff", Integer.valueOf(2130852537));
    a.put("skinQuiSwitchThumbOn", Integer.valueOf(2130852535));
    a.put("skinQuiSwitchThumbOnPressed", Integer.valueOf(2130852536));
    a.put("skinQuiSwitchThumbOffPressed", Integer.valueOf(2130852538));
    a.put("skinTipsNew", Integer.valueOf(2130852591));
    a.put("zanRankingDefaultCardCover", Integer.valueOf(2130847393));
    a.put("zanRankingNobodyBg", Integer.valueOf(2130847562));
    a.put("zanRankingGoldIcon", Integer.valueOf(2130846981));
    a.put("zanRankingSilverIcon", Integer.valueOf(2130846982));
    a.put("zanRankingCopperIcon", Integer.valueOf(2130846983));
    a.put("zanRankingChampionIcon", Integer.valueOf(2130846976));
    a.put("qzoneAlbumCategoryLockIcon", Integer.valueOf(2130850507));
    int i = 0;
    while (i < 248)
    {
      HashMap localHashMap = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(i);
      localStringBuilder.append("");
      localHashMap.put(localStringBuilder.toString(), Integer.valueOf(EmotcationConstants.FIRST_EMOJI_RES + i));
      i += 1;
    }
    b = new HashMap();
    c = new HashMap();
    c.put("skinConversationNickBlack", Integer.valueOf(2131168001));
    c.put("skinConversationMsgGray", Integer.valueOf(2131168122));
    c.put("skinBtnBlueTextColor", Integer.valueOf(2131168041));
    c.put("skinBtnWhiteTextColor", Integer.valueOf(2131168049));
    c.put("skinPageTitleBarBtnTextColor", Integer.valueOf(2131167987));
    c.put("skinPageTitleBarTextColor", Integer.valueOf(2131167990));
    c.put("skinFormItemBlack", Integer.valueOf(2131167993));
    c.put("skinFormItemGray", Integer.valueOf(2131168119));
  }
  
  public QFlutterResourceLoaderNativeImp(Context paramContext)
  {
    this.d = paramContext;
    this.f = new Handler(ThreadManagerV2.getFileThreadLooper());
    this.g = ThreadManagerV2.getUIHandlerV2();
    a();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QFlutterResourceLoaderNativeImp", 0, "preCacheColors");
    }
    Object localObject = this.d;
    if (localObject != null)
    {
      localObject = ((Context)localObject).getResources();
      ThreadManagerV2.executeOnSubThread(new QFlutterResourceLoaderNativeImp.1(this, this.e, (Resources)localObject), true);
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
    localStringBuilder.append(FileUtil.d(str));
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
    if (a.containsKey(paramString))
    {
      localNativeImageInfo.drawableId = ((Integer)a.get(paramString)).intValue();
      localNativeImageInfo.scale = this.d.getResources().getDisplayMetrics().density;
      return localNativeImageInfo;
    }
    if (b.containsKey(paramString))
    {
      localNativeImageInfo.assetsPath = ((String)b.get(paramString));
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
    return this.f;
  }
  
  public String getThemeId()
  {
    return ThemeUtil.getCurrentThemeId();
  }
  
  public Handler getUiThreadHandler()
  {
    return this.g;
  }
  
  public boolean isNinePatchDrawable(Drawable paramDrawable)
  {
    return ((paramDrawable instanceof SkinnableNinePatchDrawable)) || ((paramDrawable instanceof NinePatchDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.plugin.QFlutterResourceLoaderNativeImp
 * JD-Core Version:    0.7.0.1
 */