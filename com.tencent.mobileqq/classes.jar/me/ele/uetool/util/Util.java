package me.ele.uetool.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.SpannedString;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import me.ele.uetool.UETCore;
import me.ele.uetool.UETCore.DevAttrs;
import me.ele.uetool.UETool;
import me.ele.uetool.base.Application;
import me.ele.uetool.base.Element;
import me.ele.uetool.base.IAttrs;
import me.ele.uetool.base.ItemArrayList;
import me.ele.uetool.base.item.EditTextItem;
import me.ele.uetool.base.item.Item;
import me.ele.uetool.base.item.SwitchItem;
import me.ele.uetool.base.item.TextItem;
import me.ele.uetool.base.item.TitleItem;
import me.ele.uetool.colorpicker.ColorPicker;
import me.ele.uetool.colorpicker.listener.OnColorChangedListener;

public class Util
{
  public static List<String> supportAttrList = new ArrayList();
  
  static
  {
    supportAttrList.add("上外边距（dp）");
    supportAttrList.add("左外边距（dp）");
    supportAttrList.add("透明度");
    supportAttrList.add("背景颜色");
    supportAttrList.add("宽（dp）");
    supportAttrList.add("高（dp）");
    supportAttrList.add("左内边距（dp）");
    supportAttrList.add("右内边距（dp）");
    supportAttrList.add("上内边距（dp）");
    supportAttrList.add("下内边距（dp）");
    supportAttrList.add("ViewRes");
    supportAttrList.add("Id");
    supportAttrList.add("文字颜色");
    supportAttrList.add("文字加粗");
    supportAttrList.add("字号（px）");
  }
  
  private static void addSystemUiFlag(Window paramWindow, int paramInt)
  {
    paramWindow = paramWindow.getDecorView();
    if (paramWindow != null) {
      paramWindow.setSystemUiVisibility(paramWindow.getSystemUiVisibility() | paramInt);
    }
  }
  
  public static void clipText(String paramString)
  {
    Context localContext = Application.getApplicationContext();
    paramString = ClipData.newPlainText("", paramString);
    ((ClipboardManager)localContext.getSystemService("clipboard")).setPrimaryClip(paramString);
    Toast.makeText(localContext, "copied", 0).show();
  }
  
  private static List<Fragment> collectVisibleFragment(FragmentManager paramFragmentManager)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramFragmentManager.getFragments() == null) {
      return localArrayList;
    }
    paramFragmentManager = paramFragmentManager.getFragments().iterator();
    while (paramFragmentManager.hasNext())
    {
      Fragment localFragment = (Fragment)paramFragmentManager.next();
      if (localFragment.isVisible())
      {
        localArrayList.add(localFragment);
        localArrayList.addAll(collectVisibleFragment(localFragment.getChildFragmentManager()));
      }
    }
    return localArrayList;
  }
  
  public static void enableFullscreen(@NonNull Window paramWindow)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      addSystemUiFlag(paramWindow, 1280);
    }
  }
  
  public static List<Item> findDiff(List<Item> paramList1, List<Item> paramList2)
  {
    paramList2 = new HashSet(paramList2);
    ArrayList localArrayList = new ArrayList();
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      Item localItem = (Item)paramList1.next();
      if (((localItem instanceof TitleItem)) && (!paramList2.contains(localItem))) {
        localArrayList.add(localItem);
      }
    }
    return localArrayList;
  }
  
  public static String findDiffReport(Element paramElement)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("以下View需要修改属性至:\n");
    localStringBuilder.append("View信息:\n");
    int i;
    if (!(paramElement.getView().getParent() instanceof View))
    {
      localStringBuilder.append("父View类名:");
      localStringBuilder.append(paramElement.getView().getParent().getClass().toString());
      i = paramElement.getView().getId();
      if ((i != 0) && (i != -1)) {
        break label270;
      }
      localStringBuilder.append("类名:");
      localStringBuilder.append(paramElement.getView().getClass().toString());
    }
    for (;;)
    {
      localStringBuilder.append("\n");
      localStringBuilder.append("修改内容:\n");
      paramElement = findDiff(getItems(paramElement), paramElement.getChangeItem()).iterator();
      while (paramElement.hasNext())
      {
        localObject = (Item)paramElement.next();
        if ((localObject instanceof TitleItem))
        {
          String str = ((TitleItem)localObject).getName();
          if (supportAttrList.contains(str))
          {
            localStringBuilder.append(parseItemAttr((Item)localObject));
            localStringBuilder.append("\n");
          }
        }
      }
      Object localObject = (View)paramElement.getView().getParent();
      i = ((View)localObject).getId();
      if ((i == 0) || (i == -1))
      {
        localStringBuilder.append("父View类名:");
        localStringBuilder.append(localObject.getClass().toString());
      }
      for (;;)
      {
        localStringBuilder.append('\n');
        break;
        localStringBuilder.append("父View资源名:");
        localStringBuilder.append(getResourceName(i));
      }
      label270:
      localStringBuilder.append("资源名:");
      localStringBuilder.append(getResourceName(i));
    }
    localStringBuilder.append("------end------\n");
    return localStringBuilder.toString();
  }
  
  private static boolean findTargetView(View paramView1, View paramView2)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramView1 == paramView2) {
      bool1 = true;
    }
    do
    {
      return bool1;
      bool1 = bool2;
    } while (!(paramView1 instanceof ViewGroup));
    paramView1 = (ViewGroup)paramView1;
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= paramView1.getChildCount()) {
        break;
      }
      if (findTargetView(paramView1.getChildAt(i), paramView2)) {
        return true;
      }
      i += 1;
    }
  }
  
  public static Object getBackground(View paramView)
  {
    paramView = paramView.getBackground();
    if ((paramView instanceof ColorDrawable)) {
      return intToHexColor(((ColorDrawable)paramView).getColor());
    }
    if ((paramView instanceof GradientDrawable)) {}
    for (;;)
    {
      int i;
      try
      {
        Object localObject = GradientDrawable.class.getDeclaredField("mFillPaint");
        ((Field)localObject).setAccessible(true);
        paramView = ((Paint)((Field)localObject).get(paramView)).getShader();
        if ((paramView instanceof LinearGradient))
        {
          localObject = LinearGradient.class.getDeclaredField("mColors");
          ((Field)localObject).setAccessible(true);
          paramView = (int[])((Field)localObject).get(paramView);
          localObject = new StringBuilder();
          i = 0;
          int j = paramView.length;
          if (i < j)
          {
            ((StringBuilder)localObject).append(intToHexColor(paramView[i]));
            if (i >= j - 1) {
              break label165;
            }
            ((StringBuilder)localObject).append(" -> ");
            break label165;
          }
          paramView = ((StringBuilder)localObject).toString();
          return paramView;
        }
      }
      catch (NoSuchFieldException paramView)
      {
        paramView.printStackTrace();
        return null;
      }
      catch (IllegalAccessException paramView)
      {
        paramView.printStackTrace();
        continue;
      }
      return getDrawableBitmap(paramView);
      label165:
      i += 1;
    }
  }
  
  public static Activity getCurrentActivity()
  {
    try
    {
      Object localObject2 = Class.forName("android.app.ActivityThread");
      Object localObject1 = ((Class)localObject2).getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
      localObject2 = ((Class)localObject2).getDeclaredField("mActivities");
      ((Field)localObject2).setAccessible(true);
      localObject2 = ((Map)((Field)localObject2).get(localObject1)).values().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = ((Iterator)localObject2).next();
        Class localClass = localObject1.getClass();
        Field localField = localClass.getDeclaredField("paused");
        localField.setAccessible(true);
        if (!((Boolean)localField.get(localObject1)).booleanValue())
        {
          localObject2 = localClass.getDeclaredField("activity");
          ((Field)localObject2).setAccessible(true);
          localObject1 = (Activity)((Field)localObject2).get(localObject1);
          return localObject1;
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  @Nullable
  public static Fragment getCurrentFragment(View paramView)
  {
    Object localObject = UETool.getInstance().getTargetActivity();
    if ((localObject instanceof FragmentActivity))
    {
      localObject = collectVisibleFragment(((FragmentActivity)localObject).getSupportFragmentManager());
      int i = ((List)localObject).size() - 1;
      while (i >= 0)
      {
        Fragment localFragment = (Fragment)((List)localObject).get(i);
        if (findTargetView(localFragment.getView(), paramView)) {
          return localFragment;
        }
        i -= 1;
      }
    }
    return null;
  }
  
  @Nullable
  public static String getCurrentFragmentName(View paramView)
  {
    paramView = getCurrentFragment(paramView);
    if (paramView != null) {
      return paramView.getClass().getName();
    }
    return null;
  }
  
  public static int getDensityDpi()
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    WindowManager localWindowManager = (WindowManager)Application.getApplicationContext().getSystemService("window");
    if (localWindowManager == null) {
      return 0;
    }
    localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics.densityDpi;
  }
  
  private static Bitmap getDrawableBitmap(Drawable paramDrawable)
  {
    try
    {
      if ((paramDrawable instanceof BitmapDrawable)) {
        return ((BitmapDrawable)paramDrawable).getBitmap();
      }
      Field localField1;
      if ((paramDrawable instanceof NinePatchDrawable))
      {
        if (Build.VERSION.SDK_INT >= 24)
        {
          localField1 = NinePatchDrawable.class.getDeclaredField("mNinePatchState");
          localField1.setAccessible(true);
          paramDrawable = localField1.get(paramDrawable);
          localField1 = paramDrawable.getClass().getDeclaredField("mNinePatch");
          localField1.setAccessible(true);
          return ((NinePatch)localField1.get(paramDrawable)).getBitmap();
        }
        if (Build.VERSION.SDK_INT >= 19)
        {
          localField1 = NinePatchDrawable.class.getDeclaredField("mNinePatch");
          localField1.setAccessible(true);
          return ((NinePatch)localField1.get(paramDrawable)).getBitmap();
        }
      }
      else if ((paramDrawable instanceof ClipDrawable))
      {
        if (Build.VERSION.SDK_INT >= 23) {
          return ((BitmapDrawable)((ClipDrawable)paramDrawable).getDrawable()).getBitmap();
        }
      }
      else
      {
        if ((paramDrawable instanceof StateListDrawable)) {
          return ((BitmapDrawable)paramDrawable.getCurrent()).getBitmap();
        }
        if ((Build.VERSION.SDK_INT >= 21) && ((paramDrawable instanceof VectorDrawable)))
        {
          localField1 = VectorDrawable.class.getDeclaredField("mVectorState");
          localField1.setAccessible(true);
          Field localField2 = Class.forName("android.support.graphics.drawable.VectorDrawableCompat$VectorDrawableCompatState").getDeclaredField("mCachedBitmap");
          localField2.setAccessible(true);
          paramDrawable = (Bitmap)localField2.get(localField1.get(paramDrawable));
          return paramDrawable;
        }
      }
    }
    catch (Exception paramDrawable)
    {
      paramDrawable.printStackTrace();
    }
    return null;
  }
  
  public static int getHeight()
  {
    Display localDisplay = ((WindowManager)Application.getApplicationContext().getSystemService("window")).getDefaultDisplay();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localDisplay.getMetrics(localDisplayMetrics);
    return localDisplayMetrics.heightPixels + getStatusBarHeight();
  }
  
  public static int getImageBgName(View paramView)
  {
    int m = 0;
    int k = 0;
    try
    {
      if (Build.VERSION.SDK_INT < 28)
      {
        if (!(paramView instanceof ImageView)) {
          break label176;
        }
        i = getResFromImageView((ImageView)paramView);
        if (i == 0)
        {
          j = i;
          return j;
        }
      }
      try
      {
        j = getResBgId(paramView);
        return j;
      }
      catch (Exception localException2)
      {
        Object localObject;
        break label163;
      }
      localObject = Class.forName("android.view.View").getDeclaredField("mAttributes");
      ((Field)localObject).setAccessible(true);
      localObject = (Object[])((Field)localObject).get(paramView);
      int j = 0;
      for (;;)
      {
        i = m;
        if (j >= localObject.length) {
          break label168;
        }
        if ((((String)localObject[j]).contains("src")) || (((String)localObject[j]).contains("background")))
        {
          i = Integer.valueOf(((String)localObject[(j + 1)]).substring(1)).intValue();
          j = i;
          if (i != 0) {
            break;
          }
          return getResBgId(paramView);
        }
        j += 2;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        int i = k;
        label163:
        localException1.printStackTrace();
        label168:
        continue;
        label176:
        i = 0;
      }
    }
  }
  
  public static Bitmap getImageViewBitmap(ImageView paramImageView)
  {
    return getDrawableBitmap(paramImageView.getDrawable());
  }
  
  public static String getImageViewScaleType(ImageView paramImageView)
  {
    return paramImageView.getScaleType().name();
  }
  
  public static List<Item> getItems(Element paramElement)
  {
    ItemArrayList localItemArrayList = new ItemArrayList();
    Iterator localIterator = UETool.getInstance().getAttrsProvider().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        localItemArrayList.addAll(((IAttrs)Class.forName(str).newInstance()).getAttrs(paramElement));
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    if (!UETCore.getDevFlag()) {
      localItemArrayList.addAll(new UETCore.DevAttrs().getAttrs(paramElement));
    }
    return localItemArrayList;
  }
  
  public static int getRealHeightPixels()
  {
    Display localDisplay = ((WindowManager)Application.getApplicationContext().getSystemService("window")).getDefaultDisplay();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    try
    {
      Class.forName("android.view.Display").getMethod("getRealMetrics", new Class[] { DisplayMetrics.class }).invoke(localDisplay, new Object[] { localDisplayMetrics });
      int i = localDisplayMetrics.heightPixels;
      return i;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  public static String getReportData(Element paramElement, Boolean paramBoolean)
  {
    Object localObject1 = getItems(paramElement);
    paramBoolean = new StringBuilder();
    paramBoolean.append("parent class: ");
    int i;
    if (!(paramElement.getView().getParent() instanceof View))
    {
      paramBoolean.append(paramElement.getView().getParent().getClass().toString());
      paramBoolean.append("self class:");
      i = paramElement.getView().getId();
      if ((i != 0) && (i != -1)) {
        break label235;
      }
      paramBoolean.append(paramElement.getView().getClass().toString());
    }
    for (;;)
    {
      paramBoolean.append("\n");
      paramElement = ((List)localObject1).iterator();
      while (paramElement.hasNext())
      {
        localObject1 = (Item)paramElement.next();
        if ((localObject1 instanceof TitleItem))
        {
          localObject2 = ((TitleItem)localObject1).getName();
          if (supportAttrList.contains(localObject2))
          {
            paramBoolean.append(parseItemAttr((Item)localObject1));
            paramBoolean.append("\n");
          }
        }
      }
      Object localObject2 = (View)paramElement.getView().getParent();
      i = ((View)localObject2).getId();
      if ((i == 0) || (i == -1)) {
        paramBoolean.append(localObject2.getClass().toString());
      }
      for (;;)
      {
        paramBoolean.append('\n');
        break;
        paramBoolean.append(getResourceName(i));
      }
      label235:
      paramBoolean.append(getResourceName(i));
    }
    return paramBoolean.toString();
  }
  
  private static int getResBgId(View paramView)
  {
    try
    {
      Field localField = View.class.getDeclaredField("mBackgroundResource");
      localField.setAccessible(true);
      int i = localField.getInt(paramView);
      return i;
    }
    catch (Exception paramView) {}
    return 0;
  }
  
  private static int getResFromImageView(ImageView paramImageView)
  {
    try
    {
      Field localField = Reflect28Util.getDeclaredField(Reflect28Util.forName("android.widget.ImageView"), "mResource");
      localField.setAccessible(true);
      int i = localField.getInt(paramImageView);
      return i;
    }
    catch (IllegalAccessException paramImageView)
    {
      paramImageView.printStackTrace();
      return 0;
    }
    catch (NoSuchFieldException paramImageView)
    {
      paramImageView.printStackTrace();
      return 0;
    }
    catch (ClassNotFoundException paramImageView)
    {
      paramImageView.printStackTrace();
    }
    return 0;
  }
  
  public static String getResId(View paramView)
  {
    try
    {
      int i = paramView.getId();
      if (i == -1) {
        return "";
      }
      paramView = "0x" + Integer.toHexString(i);
      return paramView;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
    return "";
  }
  
  public static String getResourceName(int paramInt)
  {
    Object localObject = Application.getApplicationContext().getResources();
    if ((paramInt == -1) || (paramInt == 0)) {
      return "";
    }
    try
    {
      localObject = ((Resources)localObject).getResourceEntryName(paramInt);
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
  
  public static int getStatusBarHeight()
  {
    int i = 0;
    int j = Application.getApplicationContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (j > 0) {
      i = Application.getApplicationContext().getResources().getDimensionPixelSize(j);
    }
    return i;
  }
  
  public static List<Pair<String, Bitmap>> getTextViewBitmap(TextView paramTextView)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(getTextViewDrawableBitmap(paramTextView));
    localArrayList.addAll(getTextViewImageSpanBitmap(paramTextView));
    return localArrayList;
  }
  
  private static List<Pair<String, Bitmap>> getTextViewDrawableBitmap(TextView paramTextView)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramTextView = paramTextView.getCompoundDrawables();
      localArrayList.add(new Pair("DrawableLeft", getDrawableBitmap(paramTextView[0])));
      localArrayList.add(new Pair("DrawableTop", getDrawableBitmap(paramTextView[1])));
      localArrayList.add(new Pair("DrawableRight", getDrawableBitmap(paramTextView[2])));
      localArrayList.add(new Pair("DrawableBottom", getDrawableBitmap(paramTextView[3])));
      return localArrayList;
    }
    catch (Exception paramTextView)
    {
      paramTextView.printStackTrace();
    }
    return localArrayList;
  }
  
  private static List<Pair<String, Bitmap>> getTextViewImageSpanBitmap(TextView paramTextView)
  {
    localArrayList = new ArrayList();
    try
    {
      paramTextView = paramTextView.getText();
      if ((paramTextView instanceof SpannedString))
      {
        Field localField = Class.forName("android.text.SpannableStringInternal").getDeclaredField("mSpans");
        localField.setAccessible(true);
        paramTextView = (Object[])localField.get(paramTextView);
        int j = paramTextView.length;
        int i = 0;
        while (i < j)
        {
          localField = paramTextView[i];
          if ((localField instanceof ImageSpan)) {
            localArrayList.add(new Pair("SpanBitmap", getDrawableBitmap(((ImageSpan)localField).getDrawable())));
          }
          i += 1;
        }
      }
      return localArrayList;
    }
    catch (Exception paramTextView)
    {
      paramTextView.printStackTrace();
    }
  }
  
  public static int getWidth()
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    WindowManager localWindowManager = (WindowManager)Application.getApplicationContext().getSystemService("window");
    if (localWindowManager == null) {
      return 0;
    }
    localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics.widthPixels;
  }
  
  public static String intToHexColor(int paramInt)
  {
    return "#" + Integer.toHexString(paramInt).toUpperCase();
  }
  
  public static boolean isColdColor(@ColorInt int paramInt)
  {
    float[] arrayOfFloat = new float[3];
    Color.colorToHSV(paramInt, arrayOfFloat);
    return arrayOfFloat[2] <= 0.8F;
  }
  
  private static String parseItemAttr(Item paramItem)
  {
    StringBuilder localStringBuilder = new StringBuilder(32);
    if ((paramItem instanceof TitleItem))
    {
      localStringBuilder.append(((TitleItem)paramItem).getName());
      localStringBuilder.append(": ");
      if (!(paramItem instanceof EditTextItem)) {
        break label63;
      }
      localStringBuilder.append(((EditTextItem)paramItem).getDetail());
    }
    for (;;)
    {
      return localStringBuilder.toString();
      return null;
      label63:
      if ((paramItem instanceof TextItem)) {
        localStringBuilder.append(((TextItem)paramItem).getDetail());
      } else if ((paramItem instanceof SwitchItem)) {
        localStringBuilder.append(((SwitchItem)paramItem).isChecked());
      }
    }
  }
  
  public static void putToClipBoard(String paramString1, String paramString2)
  {
    ((ClipboardManager)Application.getApplicationContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(paramString1, paramString2));
    Toast.makeText(Application.getApplicationContext(), paramString2, 0).show();
  }
  
  public static void sendToMyFriend(String paramString)
  {
    try
    {
      Object localObject = Class.forName("com.tencent.mobileqq.activity.ForwardRecentActivity");
      localObject = new Intent(Application.getApplicationContext(), (Class)localObject);
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", -1);
      localBundle.putString("forward_text", paramString);
      localBundle.putInt("selection_mode", 0);
      localBundle.putBoolean("isFromShare", true);
      ((Intent)localObject).putExtras(localBundle);
      ((Intent)localObject).putExtra("direct_send_if_dataline_forward", true);
      Application.getApplicationContext().startActivity((Intent)localObject);
      return;
    }
    catch (ClassNotFoundException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static void setDebug(boolean paramBoolean)
  {
    try
    {
      Field localField = Reflect28Util.getDeclaredField(Reflect28Util.forName("android.view.View"), "mDebugViewAttributes");
      localField.setAccessible(true);
      localField.setBoolean(null, paramBoolean);
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.printStackTrace();
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      localNoSuchFieldException.printStackTrace();
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localClassNotFoundException.printStackTrace();
    }
  }
  
  public static void setStatusBarColor(@NonNull Window paramWindow, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramWindow.setStatusBarColor(paramInt);
    }
  }
  
  public static void showColorPickerDialog(int paramInt, OnColorChangedListener paramOnColorChangedListener)
  {
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(Integer.valueOf(Color.argb(255, 255, 255, 255)));
    ((ArrayList)localObject).add(Integer.valueOf(Color.argb(255, 245, 246, 250)));
    ((ArrayList)localObject).add(Integer.valueOf(Color.argb(255, 235, 237, 245)));
    ((ArrayList)localObject).add(Integer.valueOf(Color.argb(255, 176, 179, 191)));
    ((ArrayList)localObject).add(Integer.valueOf(Color.argb(255, 135, 139, 153)));
    ((ArrayList)localObject).add(Integer.valueOf(Color.argb(255, 0, 202, 252)));
    ((ArrayList)localObject).add(Integer.valueOf(Color.argb(255, 30, 186, 252)));
    ((ArrayList)localObject).add(Integer.valueOf(Color.argb(255, 77, 148, 255)));
    ((ArrayList)localObject).add(Integer.valueOf(Color.argb(255, 255, 89, 106)));
    ((ArrayList)localObject).add(Integer.valueOf(Color.argb(255, 33, 217, 198)));
    paramOnColorChangedListener = new ColorPicker(Application.getApplicationContext(), paramInt, (List)localObject, paramOnColorChangedListener).getDialog();
    localObject = paramOnColorChangedListener.getWindow();
    if (Build.VERSION.SDK_INT >= 26) {
      paramOnColorChangedListener.getWindow().setType(2038);
    }
    for (;;)
    {
      WindowManager.LayoutParams localLayoutParams = ((Window)localObject).getAttributes();
      localLayoutParams.width = ViewKnife.dip2px(300.0F);
      localLayoutParams.height = ViewKnife.dip2px(442.0F);
      ((Window)localObject).setAttributes(localLayoutParams);
      paramOnColorChangedListener.show();
      return;
      paramOnColorChangedListener.getWindow().setType(2003);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     me.ele.uetool.util.Util
 * JD-Core Version:    0.7.0.1
 */