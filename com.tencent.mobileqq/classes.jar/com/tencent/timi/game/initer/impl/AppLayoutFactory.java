package com.tencent.timi.game.initer.impl;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater.Factory2;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.tencent.timi.game.IViewCreator;
import com.tencent.timi.game.live.api.IGameLiveService;
import com.tencent.timi.game.router.IService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.userinfo.api.IUserInfoService;
import com.yolo.esports.room.api.IRoomOperationService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/initer/impl/AppLayoutFactory;", "Landroid/view/LayoutInflater$Factory2;", "()V", "initProvideViews", "", "service", "Ljava/lang/Class;", "Lcom/tencent/timi/game/router/IService;", "initViewCreator", "onCreateView", "Landroid/view/View;", "parent", "name", "", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AppLayoutFactory
  implements LayoutInflater.Factory2
{
  public static final AppLayoutFactory.Companion a = new AppLayoutFactory.Companion(null);
  private static final HashMap<String, IViewCreator> b = new HashMap();
  private static final AtomicBoolean c = new AtomicBoolean(false);
  
  private final void a()
  {
    a(IUserInfoService.class);
    a(IRoomOperationService.class);
    a(IGameLiveService.class);
    c.set(true);
  }
  
  private final void a(Class<? extends IService> paramClass)
  {
    paramClass = (IViewCreator)ServiceCenter.a(paramClass);
    if (paramClass != null)
    {
      Object localObject = paramClass.a();
      if (localObject != null)
      {
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          Map localMap = (Map)b;
          Intrinsics.checkExpressionValueIsNotNull(str, "it");
          localMap.put(str, paramClass);
        }
      }
    }
  }
  
  @Nullable
  public View onCreateView(@Nullable View paramView, @NotNull String paramString, @NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    return onCreateView(paramString, paramContext, paramAttributeSet);
  }
  
  @Nullable
  public View onCreateView(@NotNull String paramString, @NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    if (!c.get()) {
      a();
    }
    Object localObject = (IViewCreator)b.get(paramString);
    if (localObject != null)
    {
      localObject = ((IViewCreator)localObject).a(paramString, paramContext, paramAttributeSet);
      if (localObject != null) {
        return localObject;
      }
    }
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 2059813682: 
      if (paramString.equals("ScrollView")) {
        return (View)new ScrollView(paramContext, paramAttributeSet);
      }
      break;
    case 2001146706: 
      if (paramString.equals("Button")) {
        return (View)new AppCompatButton(paramContext, paramAttributeSet);
      }
      break;
    case 1687083591: 
      if (paramString.equals("android.support.v4.view.ViewPager")) {
        return (View)new ViewPager(paramContext, paramAttributeSet);
      }
      break;
    case 1666676343: 
      if (paramString.equals("EditText")) {
        return (View)new AppCompatEditText(paramContext, paramAttributeSet);
      }
      break;
    case 1601505219: 
      if (paramString.equals("CheckBox")) {
        return (View)new AppCompatCheckBox(paramContext, paramAttributeSet);
      }
      break;
    case 1413872058: 
      if (paramString.equals("AutoCompleteTextView")) {
        return (View)new AppCompatAutoCompleteTextView(paramContext, paramAttributeSet);
      }
      break;
    case 1410352259: 
      if (paramString.equals("ListView")) {
        return (View)new ListView(paramContext, paramAttributeSet);
      }
      break;
    case 1310765783: 
      if (paramString.equals("FrameLayout")) {
        return (View)new FrameLayout(paramContext, paramAttributeSet);
      }
      break;
    case 1260470547: 
      if (paramString.equals("ViewStub")) {
        return (View)new ViewStub(paramContext, paramAttributeSet);
      }
      break;
    case 1127291599: 
      if (paramString.equals("LinearLayout")) {
        return (View)new LinearLayout(paramContext, paramAttributeSet);
      }
      break;
    case 1125864064: 
      if (paramString.equals("ImageView")) {
        return (View)new AppCompatImageView(paramContext, paramAttributeSet);
      }
      break;
    case 776382189: 
      if (paramString.equals("RadioButton")) {
        return (View)new AppCompatRadioButton(paramContext, paramAttributeSet);
      }
      break;
    case 141732585: 
      if (paramString.equals("androidx.recyclerview.widget.RecyclerView"))
      {
        paramString = new RecyclerView(paramContext, paramAttributeSet);
        paramString.setOverScrollMode(2);
        return (View)paramString;
      }
      break;
    case 2666181: 
      if (paramString.equals("View")) {
        return new View(paramContext, paramAttributeSet);
      }
      break;
    case -339785223: 
      if (paramString.equals("Spinner")) {
        return (View)new AppCompatSpinner(paramContext, paramAttributeSet);
      }
      break;
    case -443652810: 
      if (paramString.equals("RelativeLayout")) {
        return (View)new RelativeLayout(paramContext, paramAttributeSet);
      }
      break;
    case -658531749: 
      if (paramString.equals("SeekBar")) {
        return (View)new AppCompatSeekBar(paramContext, paramAttributeSet);
      }
      break;
    case -703660929: 
      if (paramString.equals("android.support.v7.widget.RecyclerView")) {
        return (View)new RecyclerView(paramContext, paramAttributeSet);
      }
      break;
    case -937446323: 
      if (paramString.equals("ImageButton")) {
        return (View)new AppCompatImageButton(paramContext, paramAttributeSet);
      }
      break;
    case -938935918: 
      if (paramString.equals("TextView")) {
        return (View)new AppCompatTextView(paramContext, paramAttributeSet);
      }
      break;
    case -979739473: 
      if (paramString.equals("androidx.constraintlayout.widget.ConstraintLayout")) {
        return (View)new ConstraintLayout(paramContext, paramAttributeSet);
      }
      break;
    case -1125439882: 
      if (paramString.equals("HorizontalScrollView")) {
        return (View)new HorizontalScrollView(paramContext, paramAttributeSet);
      }
      break;
    case -1346021293: 
      if (paramString.equals("MultiAutoCompleteTextView")) {
        return (View)new AppCompatMultiAutoCompleteTextView(paramContext, paramAttributeSet);
      }
      break;
    case -1455429095: 
      if (paramString.equals("CheckedTextView")) {
        return (View)new AppCompatCheckedTextView(paramContext, paramAttributeSet);
      }
      break;
    case -1881705304: 
      if (paramString.equals("androidx.constraintlayout.widget.Guideline")) {
        return (View)new Guideline(paramContext, paramAttributeSet);
      }
      break;
    case -1946472170: 
      if (paramString.equals("RatingBar")) {
        return (View)new AppCompatRatingBar(paramContext, paramAttributeSet);
      }
      break;
    }
    paramContext = new StringBuilder();
    paramContext.append("AppFactory: new view ");
    paramContext.append(paramString);
    paramContext.append(" not include in AppFactory, please add it");
    Log.e("AppLayoutFactory", paramContext.toString());
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.initer.impl.AppLayoutFactory
 * JD-Core Version:    0.7.0.1
 */