package com.tencent.timi.game.component.chat.input;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.Editable.Factory;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.annotation.ColorInt;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiUniversalPanel;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiUniversalPanel.Builder;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelAppService;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.timi.game.component.chat.util.EmotionCodecUtils;
import com.tencent.timi.game.ex.LayoutExKt;
import com.tencent.timi.game.ui.span.ExcludeInnerLineSpaceSpan;
import com.tencent.timi.game.utils.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/timi/game/component/chat/input/IInputView;", "ctx", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "def", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "activityContext", "atInfoMap", "", "", "atPosUserNameList", "", "Lkotlin/Pair;", "getAtPosUserNameList", "()Ljava/util/List;", "currentState", "getCurrentState", "()I", "setCurrentState", "(I)V", "emojiCallback", "com/tencent/timi/game/component/chat/input/TimiBaseInputView$emojiCallback$1", "Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView$emojiCallback$1;", "emojiEditableFactory", "Landroid/text/Editable$Factory;", "getEmojiEditableFactory", "()Landroid/text/Editable$Factory;", "emojiEditableFactory$delegate", "Lkotlin/Lazy;", "excludeLineSpan", "Lcom/tencent/timi/game/ui/span/ExcludeInnerLineSpaceSpan;", "getExcludeLineSpan", "()Lcom/tencent/timi/game/ui/span/ExcludeInnerLineSpaceSpan;", "setExcludeLineSpan", "(Lcom/tencent/timi/game/ui/span/ExcludeInnerLineSpaceSpan;)V", "funcLayout", "Landroid/widget/FrameLayout;", "getFuncLayout", "()Landroid/widget/FrameLayout;", "setFuncLayout", "(Landroid/widget/FrameLayout;)V", "inputLayout", "keyboardHeight", "layoutListener", "Lcom/tencent/timi/game/component/chat/input/KeyboardUtils$OnSoftInputChangedListener;", "preState", "stateChangedListenerList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView$StateChangedListener;", "userNameHeadUrl", "userNameQQUserInfoMapIdMap", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "getUserNameQQUserInfoMapIdMap", "()Ljava/util/Map;", "addAtUserInfo", "", "userId", "showName", "headUrl", "addStateChangedListener", "listener", "clearAtUserInfoList", "clearEditText", "deleteAtMessage", "content", "deleteContent", "maxLength", "doBeforeSend", "view", "Landroid/view/View;", "forceRegisterSoftInputChangedListener", "forceUnregisterSoftInputChangedListener", "genEmojiPanel", "backgroundColor", "rowCount", "(Ljava/lang/Integer;I)Landroid/view/View;", "getContent", "getContentLimit", "getContentSubView", "getCurState", "getEmojiBtn", "getInputEditText", "Landroid/widget/EditText;", "getLayoutId", "getPreState", "getSendBtn", "getUniqueId", "hasAtNick", "", "hideKeyboard", "init", "initTimiEditText", "textSize", "", "lineHeight", "hintStr", "isContainAt", "isContainEmotion", "isIncludeUserId", "layoutInflated", "onAttachedToWindow", "onDelKeyClick", "onDetachedFromWindow", "onFuncClick", "removeStateChangedListener", "setState", "state", "showKeyBoard", "resetHeight", "height", "Companion", "StateChangedListener", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract class TimiBaseInputView
  extends LinearLayout
  implements IInputView
{
  public static final TimiBaseInputView.Companion b = new TimiBaseInputView.Companion(null);
  private static final int q = LayoutExKt.b(20);
  @NotNull
  private final Lazy a = LazyKt.lazy((Function0)TimiBaseInputView.emojiEditableFactory.2.INSTANCE);
  private final Map<String, String> c = (Map)new LinkedHashMap();
  @NotNull
  private final Map<String, CommonOuterClass.QQUserId> d = (Map)new LinkedHashMap();
  @NotNull
  private final List<Pair<Integer, String>> e = (List)new ArrayList();
  private final Map<String, String> f = (Map)new LinkedHashMap();
  private Context g;
  @Nullable
  private ExcludeInnerLineSpaceSpan h;
  private FrameLayout i;
  @Nullable
  private FrameLayout j;
  private int k = 1;
  private int l = 1;
  private int m;
  private final CopyOnWriteArrayList<TimiBaseInputView.StateChangedListener> n;
  private final KeyboardUtils.OnSoftInputChangedListener o;
  private final TimiBaseInputView.emojiCallback.1 p;
  
  @JvmOverloads
  public TimiBaseInputView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public TimiBaseInputView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public TimiBaseInputView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = TimiInputUtil.a;
    paramAttributeSet = MobileQQ.getContext();
    Intrinsics.checkExpressionValueIsNotNull(paramAttributeSet, "MobileQQ.getContext()");
    this.m = paramContext.a((Context)paramAttributeSet);
    this.n = new CopyOnWriteArrayList();
    this.o = ((KeyboardUtils.OnSoftInputChangedListener)new TimiBaseInputView.layoutListener.1(this));
    b();
    setOrientation(1);
    this.p = new TimiBaseInputView.emojiCallback.1(this);
  }
  
  private final String a(CommonOuterClass.QQUserId paramQQUserId)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(paramQQUserId.user_from.get()));
    localStringBuilder.append("_");
    localStringBuilder.append(paramQQUserId.uid.get());
    return localStringBuilder.toString();
  }
  
  private final void a(@NotNull View paramView, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("keyboardHeight: ");
    ((StringBuilder)localObject).append(paramInt);
    Logger.b("TimiInputView", ((StringBuilder)localObject).toString());
    localObject = paramView.getLayoutParams();
    if (localObject != null) {
      ((ViewGroup.LayoutParams)localObject).height = paramInt;
    }
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private final boolean a(String paramString)
  {
    return ((this.d.isEmpty() ^ true)) && (StringsKt.endsWith$default(paramString, " ", false, 2, null)) && (StringsKt.contains$default((CharSequence)paramString, (CharSequence)"@", false, 2, null));
  }
  
  private final int b(String paramString)
  {
    if (a(paramString))
    {
      int i1 = StringsKt.lastIndexOf$default((CharSequence)paramString, "@", 0, false, 6, null);
      if ((i1 >= 0) && (i1 < paramString.length() - 1))
      {
        int i2 = paramString.length();
        if (paramString != null)
        {
          paramString = paramString.substring(i1 + 1, i2 - 1);
          Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          if (this.d.containsKey(paramString)) {
            return paramString.length() + 2;
          }
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
      }
    }
    return 1;
  }
  
  private final void b()
  {
    Object localObject = new FrameLayout(getContext());
    this.i = ((FrameLayout)localObject);
    addView((View)localObject, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
    localObject = new FrameLayout(getContext());
    this.j = ((FrameLayout)localObject);
    ((FrameLayout)localObject).setBackgroundColor(-1);
    addView((View)localObject, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, LayoutExKt.b(0)));
    localObject = this.i;
    if (localObject != null) {
      LinearLayout.inflate(getContext(), getLayoutId(), (ViewGroup)localObject);
    }
    a();
    localObject = getInputEditText();
    if (localObject != null) {
      ((EditText)localObject).addTextChangedListener((TextWatcher)new TimiBaseInputView.init.4(this));
    }
    localObject = getSendBtn();
    if (localObject != null) {
      ((View)localObject).setOnClickListener((View.OnClickListener)new TimiBaseInputView.init.5(this));
    }
    localObject = getInputEditText();
    if (localObject != null) {
      ((EditText)localObject).setOnKeyListener((View.OnKeyListener)new TimiBaseInputView.init.6(this));
    }
  }
  
  private final void c()
  {
    Object localObject = getContentSubView();
    if (localObject != null) {
      localObject = ((View)localObject).getContext();
    } else {
      localObject = null;
    }
    this.g = ((Context)localObject);
    Context localContext = this.g;
    localObject = localContext;
    if (!(localContext instanceof Activity)) {
      localObject = null;
    }
    localObject = (Activity)localObject;
    if (localObject != null)
    {
      localObject = ((Activity)localObject).getWindow();
      if (localObject != null) {
        KeyboardUtils.a((View)this, (Window)localObject, this.o);
      }
    }
  }
  
  private final void d()
  {
    Context localContext = this.g;
    Object localObject = localContext;
    if (!(localContext instanceof Activity)) {
      localObject = null;
    }
    localObject = (Activity)localObject;
    if (localObject != null)
    {
      localObject = ((Activity)localObject).getWindow();
      if (localObject != null) {
        KeyboardUtils.a((View)this, (Window)localObject);
      }
    }
  }
  
  private final View getContentSubView()
  {
    Object localObject1 = getRootView();
    boolean bool = localObject1 instanceof ViewGroup;
    Object localObject2 = null;
    if (!bool) {
      localObject1 = null;
    }
    Object localObject3 = (ViewGroup)localObject1;
    localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = (FrameLayout)((ViewGroup)localObject3).findViewById(16908290);
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((FrameLayout)localObject3).getChildAt(0);
      }
    }
    return localObject1;
  }
  
  protected int a(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "content");
    int i1;
    if (a(paramString)) {
      i1 = b(paramString);
    } else {
      i1 = 1;
    }
    Object localObject = (CharSequence)paramString;
    localObject = new Regex("@(\\[m\\](\\d+?)\\[\\/m\\])").replace((CharSequence)localObject, "@");
    int i2 = ((String)localObject).length();
    if (localObject != null)
    {
      int i3 = ((String)localObject).codePointCount(0, i2);
      int i4 = ((String)localObject).length();
      if (localObject != null)
      {
        i2 = i1;
        if (((String)localObject).codePointCount(0, i4) - i1 > paramInt)
        {
          paramString = paramString.substring(paramString.offsetByCodePoints(0, 0), paramString.offsetByCodePoints(0, i3 - i1));
          Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          i2 = i1 + a(paramString, paramInt);
        }
        return i2;
      }
      throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  @NotNull
  protected final View a(@ColorInt @Nullable Integer paramInteger, int paramInt)
  {
    Object localObject = new SystemAndEmojiUniversalPanel.Builder(getContext());
    ((SystemAndEmojiUniversalPanel.Builder)localObject).setEmoticonCallback((EmoticonCallback)this.p);
    ((SystemAndEmojiUniversalPanel.Builder)localObject).setFilterSysFaceBeyond255Enable(true);
    ((SystemAndEmojiUniversalPanel.Builder)localObject).setShowDescribeInPreview(true);
    if (paramInt != -1) {
      ((SystemAndEmojiUniversalPanel.Builder)localObject).setRowCount(paramInt);
    }
    EditText localEditText = getInputEditText();
    if (localEditText != null) {
      ((SystemAndEmojiUniversalPanel.Builder)localObject).setShowDeleteButton(localEditText);
    }
    localObject = ((SystemAndEmojiUniversalPanel.Builder)localObject).create(((IEmoticonMainPanelAppService)QRoute.api(IEmoticonMainPanelAppService.class)).createEmoticonMainPanelApp(MobileQQ.sMobileQQ.waitAppRuntime(null)));
    if (paramInteger != null) {
      ((SystemAndEmojiUniversalPanel)localObject).setBackgroundColor(((Number)paramInteger).intValue());
    }
    Intrinsics.checkExpressionValueIsNotNull(localObject, "SystemAndEmojiUniversalP…oundColor(it) }\n        }");
    return (View)localObject;
  }
  
  public abstract void a();
  
  protected final void a(float paramFloat, int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "hintStr");
    EditText localEditText = getInputEditText();
    if (localEditText != null)
    {
      localEditText.setTextSize(1, paramFloat);
      paramString = new SpannableString((CharSequence)paramString);
      paramString.setSpan(new ExcludeInnerLineSpaceSpan(paramInt), 0, paramString.length(), 33);
      localEditText.setHint((CharSequence)paramString);
      this.h = new ExcludeInnerLineSpaceSpan(paramInt);
    }
  }
  
  protected void a(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
  }
  
  public void a(@NotNull TimiBaseInputView.StateChangedListener paramStateChangedListener)
  {
    Intrinsics.checkParameterIsNotNull(paramStateChangedListener, "listener");
    this.n.add(paramStateChangedListener);
  }
  
  public final void a(@NotNull CommonOuterClass.QQUserId paramQQUserId, @Nullable String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramQQUserId, "userId");
    Intrinsics.checkParameterIsNotNull(paramString2, "headUrl");
    if (paramString1 != null)
    {
      this.c.put(a(paramQQUserId), paramString1);
      this.d.put(paramString1, paramQQUserId);
      this.f.put(paramString1, paramString2);
    }
  }
  
  public void b(@NotNull TimiBaseInputView.StateChangedListener paramStateChangedListener)
  {
    Intrinsics.checkParameterIsNotNull(paramStateChangedListener, "listener");
    this.n.remove(paramStateChangedListener);
  }
  
  public final void e()
  {
    EditText localEditText = getInputEditText();
    if (localEditText != null) {
      localEditText.setText((CharSequence)"");
    }
  }
  
  public final boolean f()
  {
    Object localObject = getInputEditText();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      localObject = ((EditText)localObject).getEditableText();
      bool1 = bool2;
      if (localObject != null)
      {
        localObject = localObject.toString();
        bool1 = bool2;
        if (localObject != null)
        {
          localObject = EmotionCodecUtils.b((String)localObject);
          bool1 = bool2;
          if ((((Collection)this.e).isEmpty() ^ true))
          {
            Intrinsics.checkExpressionValueIsNotNull(localObject, "emotionText");
            bool1 = bool2;
            if (StringsKt.contains$default((CharSequence)localObject, (CharSequence)"@", false, 2, null)) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public final boolean g()
  {
    Object localObject = getInputEditText();
    if (localObject != null)
    {
      localObject = ((EditText)localObject).getEditableText();
      if (localObject != null)
      {
        localObject = localObject.toString();
        if (localObject != null) {
          return EmotionCodecUtils.a((String)localObject);
        }
      }
    }
    return false;
  }
  
  @NotNull
  public final List<Pair<Integer, String>> getAtPosUserNameList()
  {
    return this.e;
  }
  
  @NotNull
  public final String getContent()
  {
    Object localObject = getInputEditText();
    if (localObject != null)
    {
      localObject = ((EditText)localObject).getEditableText();
      if (localObject != null)
      {
        localObject = localObject.toString();
        if (localObject != null) {
          return localObject;
        }
      }
    }
    return "";
  }
  
  public int getContentLimit()
  {
    return -1;
  }
  
  public final int getCurState()
  {
    return this.l;
  }
  
  protected final int getCurrentState()
  {
    return this.l;
  }
  
  @Nullable
  public abstract View getEmojiBtn();
  
  @NotNull
  protected final Editable.Factory getEmojiEditableFactory()
  {
    return (Editable.Factory)this.a.getValue();
  }
  
  @Nullable
  protected final ExcludeInnerLineSpaceSpan getExcludeLineSpan()
  {
    return this.h;
  }
  
  @Nullable
  protected final FrameLayout getFuncLayout()
  {
    return this.j;
  }
  
  @Nullable
  public abstract EditText getInputEditText();
  
  public abstract int getLayoutId();
  
  public final int getPreState()
  {
    return this.k;
  }
  
  @Nullable
  public abstract View getSendBtn();
  
  @NotNull
  public final Map<String, CommonOuterClass.QQUserId> getUserNameQQUserInfoMapIdMap()
  {
    return this.d;
  }
  
  public void h()
  {
    EditText localEditText = getInputEditText();
    if (localEditText != null)
    {
      Object localObject1 = this.g;
      if (localObject1 != null)
      {
        if (localObject1 != null) {
          localObject1 = ((Context)localObject1).getSystemService("input_method");
        } else {
          localObject1 = null;
        }
        Object localObject2 = localObject1;
        if (!(localObject1 instanceof InputMethodManager)) {
          localObject2 = null;
        }
        localObject1 = (InputMethodManager)localObject2;
        localEditText.setFocusable(true);
        localEditText.setFocusableInTouchMode(true);
        localEditText.requestFocus();
        if (localObject1 != null) {
          ((InputMethodManager)localObject1).showSoftInput((View)localEditText, 0, (ResultReceiver)new TimiBaseInputView.showKeyBoard.1.1((InputMethodManager)localObject1, new Handler()));
        }
        if (localObject1 != null) {
          ((InputMethodManager)localObject1).toggleSoftInput(2, 1);
        }
      }
    }
  }
  
  public void i()
  {
    setState(1);
  }
  
  protected void j()
  {
    EditText localEditText = getInputEditText();
    if (localEditText != null)
    {
      int i1 = localEditText.getSelectionStart();
      String str1;
      if (localEditText.getEditableText() != null) {
        str1 = localEditText.getEditableText().toString();
      } else {
        str1 = "";
      }
      if (str1 != null)
      {
        String str2 = str1.substring(0, i1);
        Intrinsics.checkExpressionValueIsNotNull(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        int i2 = str2.length();
        if (str2 != null)
        {
          int i3 = str2.codePointCount(0, i2);
          if (b(str2) == 1)
          {
            TextUtils.backspace(localEditText);
            return;
          }
          int i4 = a(str2, 2147483647);
          if (str2 != null)
          {
            i2 = str2.offsetByCodePoints(0, 0);
            i3 = Math.max(i3 - i4, 0);
            if (str2 != null)
            {
              i3 = str2.offsetByCodePoints(0, i3);
              if (str2 != null)
              {
                str2 = str2.substring(i2, i3);
                Intrinsics.checkExpressionValueIsNotNull(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                i2 = str1.length();
                if (str1 != null)
                {
                  str1 = str1.substring(i1, i2);
                  Intrinsics.checkExpressionValueIsNotNull(str1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                  StringBuilder localStringBuilder = new StringBuilder();
                  localStringBuilder.append(str2);
                  localStringBuilder.append(str1);
                  str1 = localStringBuilder.toString();
                  localEditText.setText((CharSequence)str1);
                  localEditText.setSelection(Math.min(str2.length(), str1.length()));
                  return;
                }
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
              }
              throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
          }
          throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      }
      throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    c();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    d();
    this.g = ((Context)null);
  }
  
  protected final void setCurrentState(int paramInt)
  {
    this.l = paramInt;
  }
  
  protected final void setExcludeLineSpan(@Nullable ExcludeInnerLineSpaceSpan paramExcludeInnerLineSpaceSpan)
  {
    this.h = paramExcludeInnerLineSpaceSpan;
  }
  
  protected final void setFuncLayout(@Nullable FrameLayout paramFrameLayout)
  {
    this.j = paramFrameLayout;
  }
  
  public final void setState(int paramInt)
  {
    this.k = this.l;
    this.l = paramInt;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("state: ");
    ((StringBuilder)localObject).append(this.l);
    Logger.b("TimiInputView", ((StringBuilder)localObject).toString());
    new Throwable().printStackTrace();
    if ((getInputEditText() != null) && (this.l != 2))
    {
      localObject = this.j;
      if (localObject != null) {
        ((FrameLayout)localObject).post((Runnable)new TimiBaseInputView.setState..inlined.let.lambda.1(this));
      }
    }
    localObject = this.j;
    if (localObject != null)
    {
      localObject = (View)localObject;
      if (this.l == 1) {
        paramInt = 0;
      } else {
        paramInt = this.m;
      }
      a((View)localObject, paramInt);
    }
    if (this.l == 1)
    {
      localObject = getInputEditText();
      if (localObject != null) {
        ((EditText)localObject).clearFocus();
      }
      localObject = this.j;
      if (localObject != null) {
        ((FrameLayout)localObject).post((Runnable)new TimiBaseInputView.setState.2(this));
      }
    }
    localObject = ((Iterable)this.n).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((TimiBaseInputView.StateChangedListener)((Iterator)localObject).next()).a(this.l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.input.TimiBaseInputView
 * JD-Core Version:    0.7.0.1
 */