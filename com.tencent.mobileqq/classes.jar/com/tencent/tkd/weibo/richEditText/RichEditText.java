package com.tencent.tkd.weibo.richEditText;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.View.OnKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import com.tencent.tkd.weibo.bean.EditObject;
import com.tencent.tkd.weibo.bean.EditObject.EditObjectType;
import com.tencent.tkd.weibo.framework.IEmoJiBridge;
import com.tencent.tkd.weibo.framework.ILogger;
import com.tencent.tkd.weibo.richEditText.span.EmotionSpan;
import com.tencent.tkd.weibo.richEditText.span.RichSpan;
import com.tencent.tkd.weibo.richtext.R.color;
import com.tencent.tkd.weibo.richtext.R.styleable;
import com.tencent.tkd.weibo.utils.CollectionUtil;
import com.tencent.tkd.weibo.utils.EmoJiParser;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/weibo/richEditText/RichEditText;", "Landroid/widget/EditText;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "allowDeletedTopic", "", "getAllowDeletedTopic", "()Z", "setAllowDeletedTopic", "(Z)V", "allowMultiTopic", "getAllowMultiTopic", "setAllowMultiTopic", "atInputListener", "Lkotlin/Function0;", "", "getAtInputListener", "()Lkotlin/jvm/functions/Function0;", "setAtInputListener", "(Lkotlin/jvm/functions/Function0;)V", "countChangeListener", "Lkotlin/Function1;", "", "getCountChangeListener", "()Lkotlin/jvm/functions/Function1;", "setCountChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "value", "countLimit", "getCountLimit", "()I", "setCountLimit", "(I)V", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/tkd/weibo/bean/EditObject;", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "editObjectListener", "Lcom/tencent/tkd/weibo/richEditText/EditObjectListener;", "getEditObjectListener", "()Lcom/tencent/tkd/weibo/richEditText/EditObjectListener;", "setEditObjectListener", "(Lcom/tencent/tkd/weibo/richEditText/EditObjectListener;)V", "localEditObjectMap", "Ljava/util/HashMap;", "Landroid/util/Pair;", "Lcom/tencent/tkd/weibo/bean/EditObject$EditObjectType;", "", "Lkotlin/collections/HashMap;", "needTextTruncation", "getNeedTextTruncation", "setNeedTextTruncation", "richTextColor", "getRichTextColor", "setRichTextColor", "addEditObject", "editObject", "isUserAction", "inputPosition", "addPureContentToEditObjectList", "startPos", "endPos", "addTopicObject", "callCopyAction", "callPasteAction", "checkAndCallRichObjectChangeListener", "delKeyOnSameSelection", "getCurrentDataList", "startCalPos", "endCalPos", "getFirstTopicSpan", "Lcom/tencent/tkd/weibo/richEditText/span/RichSpan;", "getValidSelPosForRichText", "selection", "initKeyListener", "initTextWaterListener", "insertIcon", "drawable", "Landroid/graphics/drawable/Drawable;", "name", "size", "index", "alignRule", "insertNormalText", "insertNormalTextWithEmoJi", "wording", "emoJiPositionList", "", "emoJiTabList", "insertRichText", "insertWordingOverSize", "isIndexInSpan", "onCreateInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "onKeyCallbackFunction", "event", "Landroid/view/KeyEvent;", "keyCode", "onSelectionChanged", "selStart", "selEnd", "onTextContextMenuItem", "id", "removeElementOnTextByIndex", "textIndex", "restoreDataFromList", "editObjectList", "transEmotionFlagToName", "startPosition", "endPosition", "Companion", "tkd-weibo-richtext_release"}, k=1, mv={1, 1, 16})
public final class RichEditText
  extends EditText
{
  public static final RichEditText.Companion a;
  private int jdField_a_of_type_Int;
  @Nullable
  private EditObjectListener jdField_a_of_type_ComTencentTkdWeiboRichEditTextEditObjectListener;
  private final HashMap<Pair<EditObject.EditObjectType, String>, EditObject> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  @Nullable
  private Function0<Unit> jdField_a_of_type_KotlinJvmFunctionsFunction0;
  @Nullable
  private Function1<? super Integer, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = true;
  private boolean c = true;
  
  static
  {
    jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText$Companion = new RichEditText.Companion(null);
  }
  
  public RichEditText(@NotNull Context paramContext, @NotNull AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = paramContext.getResources().getColor(R.color.jdField_a_of_type_Int);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.jdField_a_of_type_ArrayOfInt);
    setCountLimit(paramContext.getInt(R.styleable.jdField_a_of_type_Int, 12));
    this.jdField_a_of_type_Int = paramContext.getColor(R.styleable.jdField_b_of_type_Int, this.jdField_a_of_type_Int);
    paramContext.recycle();
    a();
    b();
  }
  
  private final int a(int paramInt)
  {
    int j = 1;
    RichSpan[] arrayOfRichSpan = (RichSpan[])getText().getSpans(0, getText().length(), RichSpan.class);
    if ((paramInt == 0) && (!this.jdField_b_of_type_Boolean))
    {
      Intrinsics.checkExpressionValueIsNotNull(arrayOfRichSpan, "baseRichSpans");
      if (arrayOfRichSpan.length == 0)
      {
        i = 1;
        if (i != 0) {
          break label104;
        }
        i = 1;
        label60:
        if ((i == 0) || (arrayOfRichSpan[0].a() != EditObject.EditObjectType.TYPE_TOPIC)) {
          break label109;
        }
      }
    }
    label104:
    label109:
    for (int i = j;; i = 0)
    {
      if (i == 0) {
        break label114;
      }
      j = getText().getSpanEnd(arrayOfRichSpan[0]);
      return j;
      i = 0;
      break;
      i = 0;
      break label60;
    }
    label114:
    int k = arrayOfRichSpan.length;
    i = 0;
    for (;;)
    {
      j = paramInt;
      if (i >= k) {
        break;
      }
      RichSpan localRichSpan = arrayOfRichSpan[i];
      j = getText().getSpanStart(localRichSpan);
      int m = getText().getSpanEnd(localRichSpan);
      if ((j + 1 <= paramInt) && (m >= paramInt)) {
        return m;
      }
      i += 1;
    }
  }
  
  private final RichSpan a()
  {
    RichSpan[] arrayOfRichSpan = (RichSpan[])getText().getSpans(0, getText().length(), RichSpan.class);
    Intrinsics.checkExpressionValueIsNotNull(arrayOfRichSpan, "spans");
    int j = arrayOfRichSpan.length;
    int i = 0;
    while (i < j)
    {
      RichSpan localRichSpan = arrayOfRichSpan[i];
      if (localRichSpan.a() == EditObject.EditObjectType.TYPE_TOPIC) {
        return localRichSpan;
      }
      i += 1;
    }
    return null;
  }
  
  private final RichSpan a(int paramInt)
  {
    Object localObject = (RichSpan)null;
    RichSpan[] arrayOfRichSpan = (RichSpan[])getText().getSpans(0, getText().length(), RichSpan.class);
    int j = arrayOfRichSpan.length;
    int i = 0;
    if (i < j)
    {
      RichSpan localRichSpan = arrayOfRichSpan[i];
      int k = getText().getSpanStart(localRichSpan);
      int m = getText().getSpanEnd(localRichSpan);
      if (k + 1 > paramInt) {}
      for (;;)
      {
        i += 1;
        break;
        if (m >= paramInt) {
          localObject = localRichSpan;
        }
      }
    }
    return localObject;
  }
  
  private final String a(int paramInt1, int paramInt2)
  {
    String str = getText().toString();
    if (str == null) {
      throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
    str = str.substring(paramInt1, paramInt2);
    Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject1 = (EmotionSpan[])getText().getSpans(paramInt1, str.length() + paramInt1, EmotionSpan.class);
    List localList = (List)new ArrayList();
    int i = localObject1.length;
    paramInt2 = 0;
    Object localObject2;
    while (paramInt2 < i)
    {
      localObject2 = localObject1[paramInt2];
      localList.add(new Pair(Integer.valueOf(getText().getSpanStart(localObject2)), ((EmotionSpan)localObject2).a()));
      paramInt2 += 1;
    }
    int j = ((CharSequence)str).length();
    paramInt2 = 0;
    if (paramInt2 < j)
    {
      char c1 = str.charAt(paramInt2);
      localObject2 = (Iterable)localList;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      label276:
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        Integer localInteger = (Integer)((Pair)localObject3).first;
        if (localInteger == null) {}
        label240:
        for (i = 0;; i = 1)
        {
          if (i == 0) {
            break label276;
          }
          ((Collection)localObject1).add(localObject3);
          break;
          if (localInteger.intValue() != paramInt2 + paramInt1) {
            break label240;
          }
        }
      }
      localObject1 = (List)localObject1;
      if (Intrinsics.areEqual(String.valueOf(c1), "^")) {
        if (!((Collection)localObject1).isEmpty())
        {
          i = 1;
          label314:
          if (i == 0) {
            break label355;
          }
          localStringBuilder.append((String)((Pair)((List)localObject1).get(0)).second);
        }
      }
      for (;;)
      {
        paramInt2 += 1;
        break;
        i = 0;
        break label314;
        label355:
        localStringBuilder.append(c1);
      }
    }
    str = localStringBuilder.toString();
    Intrinsics.checkExpressionValueIsNotNull(str, "stringBuilder.toString()");
    return str;
  }
  
  private final ArrayList<EditObject> a(int paramInt1, int paramInt2)
  {
    RichEditText.Companion.a(jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText$Companion).b("RichEditText", "getCurrentDataList: startPos:" + paramInt1 + ", endPos:" + paramInt2, null);
    ArrayList localArrayList = new ArrayList();
    if (paramInt1 == paramInt2) {
      return localArrayList;
    }
    Object localObject2 = (RichSpan[])getText().getSpans(paramInt1, paramInt2, RichSpan.class);
    RichEditText.Companion.a(jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText$Companion).b("RichEditText", "getCurrentDataList | spanList: " + "startPos = " + paramInt1 + ", endPos = " + paramInt2 + ", size = " + localObject2.length, null);
    Object localObject1 = CollectionUtil.a;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "richSpans");
    Object localObject3 = getText();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "text");
    localObject1 = ((CollectionUtil)localObject1).a((RichSpan[])localObject2, (Editable)localObject3);
    int i;
    if (!((Collection)localObject1).isEmpty())
    {
      i = 1;
      if (((i == 0) || (paramInt1 >= getText().getSpanStart(localObject2[0]))) && (!((ArrayList)localObject1).isEmpty())) {
        break label472;
      }
      i = 1;
      label227:
      if (i == 0) {
        break label548;
      }
      if (((Collection)localObject1).isEmpty()) {
        break label477;
      }
      i = 1;
      label246:
      if (i == 0) {
        break label482;
      }
      i = getText().getSpanStart(localObject2[0]);
      label264:
      a(paramInt1, i, localArrayList);
      paramInt1 = i;
    }
    label543:
    label548:
    for (;;)
    {
      int j = ((ArrayList)localObject1).size();
      i = 0;
      int k;
      if (i < j)
      {
        localObject2 = ((ArrayList)localObject1).get(i);
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "sortedSpans[spanPos]");
        localObject2 = (RichSpan)localObject2;
        k = getText().getSpanEnd(localObject2);
        localObject3 = (EditObject)this.jdField_a_of_type_JavaUtilHashMap.get(new Pair(((RichSpan)localObject2).a(), ((RichSpan)localObject2).a()));
        RichEditText.Companion.a(jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText$Companion).b("RichEditText", "getCurrentDataList | getObjectInLocalMap: " + "key = [type: " + ((RichSpan)localObject2).a() + " , id: " + ((RichSpan)localObject2).a() + ']' + "curObject = " + localObject3 + ", curPos:" + paramInt1 + ", DataList added.", null);
        if (localObject3 != null) {
          localArrayList.add(localObject3);
        }
        if (k < paramInt2) {}
      }
      else
      {
        return localArrayList;
        i = 0;
        break;
        label472:
        i = 0;
        break label227;
        label477:
        i = 0;
        break label246;
        label482:
        i = paramInt2;
        break label264;
      }
      if (i < ((ArrayList)localObject1).size() - 1)
      {
        paramInt1 = 1;
        label500:
        if (paramInt1 == 0) {
          break label543;
        }
      }
      for (paramInt1 = getText().getSpanStart(((ArrayList)localObject1).get(i + 1));; paramInt1 = paramInt2)
      {
        a(k, paramInt1, localArrayList);
        i += 1;
        break;
        paramInt1 = 0;
        break label500;
      }
    }
  }
  
  private final void a()
  {
    addTextChangedListener((TextWatcher)new RichEditText.initTextWaterListener.1(this));
  }
  
  private final void a(int paramInt)
  {
    RichSpan localRichSpan = a(paramInt);
    if (localRichSpan != null) {
      getText().removeSpan(localRichSpan);
    }
    getText().delete(paramInt, paramInt + 1);
  }
  
  private final void a(int paramInt1, int paramInt2, ArrayList<EditObject> paramArrayList)
  {
    Object localObject = getText().toString();
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
    localObject = ((String)localObject).substring(paramInt1, paramInt2);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    if (((CharSequence)localObject).length() > 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = new EditObject(a(paramInt1, paramInt2), null, 2, null);
        paramArrayList.add(localObject);
        RichEditText.Companion.a(jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText$Companion).b("RichEditText", "getCurrentDataList | curObject = " + localObject + ", curPos:" + paramInt1 + ", DataList added.", null);
      }
      return;
    }
  }
  
  private final void a(int paramInt, String paramString, List<Integer> paramList, List<String> paramList1)
  {
    setSelection(paramInt);
    int j = ((Collection)paramList).size();
    int i = 0;
    paramInt = 0;
    if (i < j)
    {
      int k = ((Number)paramList.get(i)).intValue();
      String str = (String)paramList1.get(i);
      int m = str.length();
      getText().insert(getSelectionStart(), paramString.subSequence(paramInt, k));
      Object localObject = RichEditText.Companion.a(jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText$Companion);
      if (localObject != null)
      {
        localObject = ((IEmoJiBridge)localObject).a(str);
        label110:
        if (localObject == null) {
          break label150;
        }
        a(this, (Drawable)localObject, str, 0, 0, 0, 28, null);
      }
      for (;;)
      {
        i += 1;
        paramInt = k + m;
        break;
        localObject = null;
        break label110;
        label150:
        getText().insert(getSelectionStart(), (CharSequence)str);
      }
    }
    if (paramInt < paramString.length() - 1) {
      getText().insert(getSelectionStart(), paramString.subSequence(paramInt, paramString.length() - 1));
    }
  }
  
  private final void a(EditObject paramEditObject, int paramInt)
  {
    EmoJiParser localEmoJiParser = new EmoJiParser(paramEditObject.getWording());
    if ((localEmoJiParser.a()) && (localEmoJiParser.b())) {}
    for (int i = 1; i == 0; i = 0)
    {
      getText().insert(paramInt, (CharSequence)paramEditObject.getWording());
      return;
    }
    a(paramInt, paramEditObject.getWording(), localEmoJiParser.b(), localEmoJiParser.a());
  }
  
  private final void a(EditObject paramEditObject, int paramInt, boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      b(paramEditObject, paramInt, paramBoolean);
      return;
    }
    RichSpan localRichSpan = a();
    if (localRichSpan != null)
    {
      paramInt = getText().getSpanStart(localRichSpan);
      int i = getText().getSpanEnd(localRichSpan);
      if ((getText().length() > i) && (getText().charAt(i) == ' ')) {
        getText().delete(i, i + 1);
      }
      getText().delete(paramInt, i);
      getText().removeSpan(localRichSpan);
      EditObjectListener localEditObjectListener = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextEditObjectListener;
      if (localEditObjectListener != null) {
        localEditObjectListener.a(false, EditObject.EditObjectType.TYPE_TOPIC, localRichSpan.a());
      }
    }
    b(paramEditObject, 0, paramBoolean);
  }
  
  private final void a(String paramString, int paramInt)
  {
    int j = getText().length();
    int i = this.jdField_b_of_type_Int;
    int k = getText().length();
    if (j == paramInt)
    {
      if (paramString == null) {
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      }
      paramString = paramString.substring(0, i - k);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    }
    for (;;)
    {
      getText().insert(paramInt, (CharSequence)paramString);
      return;
      k = RangesKt.coerceAtMost(paramString.length() + j - this.jdField_b_of_type_Int, j - paramInt);
      i = j - 1;
      j -= k;
      if (i >= j) {
        for (;;)
        {
          a(i);
          if (i == j) {
            break;
          }
          i -= 1;
        }
      }
      i = RangesKt.coerceAtMost(paramString.length(), this.jdField_b_of_type_Int - paramInt);
      if (paramString == null) {
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      }
      paramString = paramString.substring(0, i);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    }
  }
  
  private final boolean a(KeyEvent paramKeyEvent, int paramInt)
  {
    boolean bool = false;
    if ((paramInt == 67) && (paramKeyEvent.getAction() == 0)) {}
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0)
      {
        if (getSelectionStart() != getSelectionEnd()) {
          break;
        }
        bool = b();
      }
      return bool;
    }
    c();
    return false;
  }
  
  private final void b()
  {
    setOnKeyListener((View.OnKeyListener)new RichEditText.initKeyListener.1(this));
  }
  
  private final void b(EditObject paramEditObject, int paramInt, boolean paramBoolean)
  {
    int i;
    if (((CharSequence)paramEditObject.getWording()).length() == 0)
    {
      i = 1;
      if ((i == 0) && (paramInt >= 0)) {
        break label79;
      }
      RichEditText.Companion.a(jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText$Companion).a("RichEditText", "addEditObject invalid params. EditObject:" + paramEditObject + ", inputPosition:" + paramInt, null);
    }
    label79:
    EditObjectListener localEditObjectListener;
    label122:
    do
    {
      do
      {
        return;
        i = 0;
        break;
        if ((getText().length() < this.jdField_b_of_type_Int) || (!this.jdField_a_of_type_Boolean)) {
          break label122;
        }
        localEditObjectListener = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextEditObjectListener;
      } while (localEditObjectListener == null);
      localEditObjectListener.a(paramEditObject);
      return;
      setSelection(paramInt);
      if (paramEditObject.getType() == EditObject.EditObjectType.TYPE_NORMAL)
      {
        a(paramEditObject, paramInt);
        return;
      }
      c(paramEditObject, paramInt, paramBoolean);
      localEditObjectListener = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextEditObjectListener;
    } while (localEditObjectListener == null);
    localEditObjectListener.a(true, paramEditObject.getType(), paramEditObject.getId());
  }
  
  private final boolean b()
  {
    Object localObject1 = (RichSpan)null;
    RichSpan[] arrayOfRichSpan = (RichSpan[])getText().getSpans(0, getText().length(), RichSpan.class);
    int k = arrayOfRichSpan.length;
    int j = 0;
    int i = 0;
    Object localObject2;
    if (j < k)
    {
      localObject2 = arrayOfRichSpan[j];
      if (getSelectionStart() != getText().getSpanEnd(localObject2)) {
        break label193;
      }
      i = 1;
      localObject1 = localObject2;
    }
    label193:
    for (;;)
    {
      j += 1;
      break;
      if ((i != 0) && (localObject1 != null))
      {
        i = getText().getSpanStart(localObject1);
        j = getText().getSpanEnd(localObject1);
        if ((((RichSpan)localObject1).a() == EditObject.EditObjectType.TYPE_TOPIC) && (!this.jdField_b_of_type_Boolean))
        {
          if (!this.c) {}
          do
          {
            return true;
            getText().delete(i, j);
            localObject2 = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextEditObjectListener;
          } while (localObject2 == null);
          ((EditObjectListener)localObject2).a(false, EditObject.EditObjectType.TYPE_TOPIC, ((RichSpan)localObject1).a());
          return true;
        }
        setSelection(i, j);
        return true;
      }
      return false;
    }
  }
  
  private final void c()
  {
    RichSpan[] arrayOfRichSpan = (RichSpan[])getText().getSpans(getSelectionStart(), getSelectionEnd() - getSelectionStart(), RichSpan.class);
    int j = arrayOfRichSpan.length;
    int i = 0;
    while (i < j)
    {
      RichSpan localRichSpan = arrayOfRichSpan[i];
      EditObjectListener localEditObjectListener = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextEditObjectListener;
      if (localEditObjectListener != null) {
        localEditObjectListener.a(false, localRichSpan.a(), localRichSpan.a());
      }
      i += 1;
    }
  }
  
  private final void c(EditObject paramEditObject, int paramInt, boolean paramBoolean)
  {
    String str = paramEditObject.getWording();
    if ((getText().length() + str.length() <= this.jdField_b_of_type_Int) || (!this.jdField_a_of_type_Boolean)) {
      getText().insert(paramInt, (CharSequence)str);
    }
    for (;;)
    {
      Object localObject = new RichSpan(this.jdField_a_of_type_Int, paramEditObject.getType(), paramEditObject.getId());
      if (getSelectionStart() - paramInt == str.length())
      {
        getText().setSpan(localObject, paramInt, getSelectionStart(), 33);
        ((Map)this.jdField_a_of_type_JavaUtilHashMap).put(new Pair(((RichSpan)localObject).a(), ((RichSpan)localObject).a()), paramEditObject);
        RichEditText.Companion.a(jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText$Companion).b("RichEditText", "addEditObject: Add to local map: " + "key = [type: " + ((RichSpan)localObject).a() + ",id: " + ((RichSpan)localObject).a() + "], value: " + paramEditObject, null);
      }
      if (paramBoolean)
      {
        getText().insert(getSelectionStart(), (CharSequence)" ");
        setSelection(getSelectionStart());
      }
      return;
      a(str, paramInt);
      localObject = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextEditObjectListener;
      if (localObject != null) {
        ((EditObjectListener)localObject).a(paramEditObject);
      }
    }
  }
  
  private final boolean c()
  {
    if (getSelectionStart() == getSelectionEnd()) {
      return false;
    }
    Object localObject1 = getContext().getSystemService("clipboard");
    if (localObject1 == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.content.ClipboardManager");
    }
    localObject1 = (ClipboardManager)localObject1;
    ArrayList localArrayList = a(getSelectionStart(), getSelectionEnd());
    Object localObject2 = new StringBuilder();
    Object localObject3 = ((Iterable)localArrayList).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((StringBuilder)localObject2).append(((EditObject)((Iterator)localObject3).next()).getWording());
    }
    localObject2 = ((StringBuilder)localObject2).toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "stringBuilder.toString()");
    localObject3 = new Intent();
    ((Intent)localObject3).putExtra("key_rich_edit_text_data", (Serializable)localArrayList);
    ((ClipboardManager)localObject1).setPrimaryClip(new ClipData(new ClipDescription((CharSequence)"key_rich_edit_text_data", new String[] { "text/plain", "text/vnd.android.intent" }), new ClipData.Item((CharSequence)localObject2, (Intent)localObject3, null)));
    setSelection(getSelectionEnd());
    return true;
  }
  
  private final boolean d()
  {
    Object localObject2 = null;
    Object localObject1 = getContext().getSystemService("clipboard");
    if (localObject1 == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.content.ClipboardManager");
    }
    localObject1 = ((ClipboardManager)localObject1).getPrimaryClip();
    int i;
    if (localObject1 != null)
    {
      localObject1 = ((ClipData)localObject1).getItemAt(0);
      if (localObject1 != null)
      {
        localObject1 = ((ClipData.Item)localObject1).getIntent();
        if (localObject1 != null)
        {
          localObject1 = ((Intent)localObject1).getExtras();
          if (localObject1 != null) {
            ((Bundle)localObject1).setClassLoader(EditObject.class.getClassLoader());
          }
          if (localObject1 != null) {
            localObject2 = ((Bundle)localObject1).getParcelableArrayList("key_rich_edit_text_data");
          }
          if (localObject2 == null) {
            break label172;
          }
          if (((Collection)localObject2).isEmpty()) {
            break label157;
          }
          i = 1;
        }
      }
    }
    label157:
    for (;;)
    {
      label108:
      if (i != 0)
      {
        localObject1 = ((ArrayList)localObject2).iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (EditObject)((Iterator)localObject1).next();
            Intrinsics.checkExpressionValueIsNotNull(localObject2, "data");
            a((EditObject)localObject2, false);
            continue;
            localObject1 = null;
            break;
            i = 0;
            break label108;
          }
        }
        setSelection(getSelectionEnd());
        return true;
      }
    }
    label172:
    return false;
  }
  
  public final int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  @NotNull
  public final ArrayList<EditObject> a()
  {
    return a(0, getText().length());
  }
  
  @Nullable
  public final Function0<Unit> a()
  {
    return this.jdField_a_of_type_KotlinJvmFunctionsFunction0;
  }
  
  @Nullable
  public final Function1<Integer, Unit> a()
  {
    return this.jdField_a_of_type_KotlinJvmFunctionsFunction1;
  }
  
  public final void a(@NotNull Drawable paramDrawable, @NotNull String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramDrawable, "drawable");
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    paramInt2 = RangesKt.coerceAtLeast(paramInt2, 0);
    if ((getText().length() + "^".length() <= this.jdField_b_of_type_Int) || (!this.jdField_a_of_type_Boolean))
    {
      paramDrawable.setBounds(0, 0, paramInt1, paramInt1);
      paramDrawable = new EmotionSpan(paramDrawable, paramString, paramInt3);
      paramString = new SpannableString((CharSequence)"^");
      paramString.setSpan(paramDrawable, 0, paramString.length(), 33);
      if (paramInt2 < length()) {
        break label127;
      }
      append((CharSequence)paramString);
    }
    for (;;)
    {
      setSelection(paramString.length() + paramInt2);
      return;
      label127:
      getText().insert(paramInt2, (CharSequence)paramString);
    }
  }
  
  public final void a(@NotNull EditObject paramEditObject, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramEditObject, "editObject");
    if (paramEditObject.getType() == EditObject.EditObjectType.TYPE_TOPIC)
    {
      a(paramEditObject, getSelectionStart(), paramBoolean);
      return;
    }
    b(paramEditObject, getSelectionStart(), paramBoolean);
  }
  
  public final void a(@NotNull List<EditObject> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "editObjectList");
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext()) {
      a((EditObject)paramList.next(), false);
    }
  }
  
  public final boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  @NotNull
  public InputConnection onCreateInputConnection(@Nullable EditorInfo paramEditorInfo)
  {
    paramEditorInfo = super.onCreateInputConnection(paramEditorInfo);
    return (InputConnection)new RichEditText.onCreateInputConnection.1(this, paramEditorInfo, paramEditorInfo, false);
  }
  
  protected void onSelectionChanged(int paramInt1, int paramInt2)
  {
    super.onSelectionChanged(paramInt1, paramInt2);
    setSelection(a(paramInt1), a(paramInt2));
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    if (paramInt == 16908321)
    {
      if (!c()) {}
    }
    else {
      while ((paramInt == 16908322) && (d())) {
        return true;
      }
    }
    return super.onTextContextMenuItem(paramInt);
  }
  
  public final void setAllowDeletedTopic(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public final void setAllowMultiTopic(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public final void setAtInputListener(@Nullable Function0<Unit> paramFunction0)
  {
    this.jdField_a_of_type_KotlinJvmFunctionsFunction0 = paramFunction0;
  }
  
  public final void setCountChangeListener(@Nullable Function1<? super Integer, Unit> paramFunction1)
  {
    this.jdField_a_of_type_KotlinJvmFunctionsFunction1 = paramFunction1;
  }
  
  public final void setCountLimit(int paramInt)
  {
    if (paramInt > 0)
    {
      this.jdField_b_of_type_Int = paramInt;
      if (this.jdField_a_of_type_Boolean) {
        setFilters(new InputFilter[] { (InputFilter)new InputFilter.LengthFilter(this.jdField_b_of_type_Int) });
      }
    }
  }
  
  public final void setEditObjectListener(@Nullable EditObjectListener paramEditObjectListener)
  {
    this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextEditObjectListener = paramEditObjectListener;
  }
  
  public final void setNeedTextTruncation(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public final void setRichTextColor(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.weibo.richEditText.RichEditText
 * JD-Core Version:    0.7.0.1
 */