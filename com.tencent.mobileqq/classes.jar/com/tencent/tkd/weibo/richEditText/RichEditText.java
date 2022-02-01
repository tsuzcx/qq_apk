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
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.View.OnKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import com.tencent.tkd.topicsdk.interfaces.ILogger;
import com.tencent.tkd.weibo.bean.EditObject;
import com.tencent.tkd.weibo.bean.EditObject.EditObjectType;
import com.tencent.tkd.weibo.framework.IEmoJiBridge;
import com.tencent.tkd.weibo.richEditText.connection.FixSharpConnectionWrapper;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/weibo/richEditText/RichEditText;", "Landroid/widget/EditText;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "allowDeletedTopic", "", "getAllowDeletedTopic", "()Z", "setAllowDeletedTopic", "(Z)V", "allowMultiTopic", "getAllowMultiTopic", "setAllowMultiTopic", "atInputListener", "Lkotlin/Function0;", "", "getAtInputListener", "()Lkotlin/jvm/functions/Function0;", "setAtInputListener", "(Lkotlin/jvm/functions/Function0;)V", "countChangeListener", "Lkotlin/Function1;", "", "getCountChangeListener", "()Lkotlin/jvm/functions/Function1;", "setCountChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "value", "countLimit", "getCountLimit", "()I", "setCountLimit", "(I)V", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/tkd/weibo/bean/EditObject;", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "editObjectListener", "Lcom/tencent/tkd/weibo/richEditText/EditObjectListener;", "getEditObjectListener", "()Lcom/tencent/tkd/weibo/richEditText/EditObjectListener;", "setEditObjectListener", "(Lcom/tencent/tkd/weibo/richEditText/EditObjectListener;)V", "localEditObjectMap", "Ljava/util/HashMap;", "Landroid/util/Pair;", "Lcom/tencent/tkd/weibo/bean/EditObject$EditObjectType;", "", "Lkotlin/collections/HashMap;", "needTextTruncation", "getNeedTextTruncation", "setNeedTextTruncation", "onSelectionChangeListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "selectionStart", "selectionEnd", "getOnSelectionChangeListener", "()Lkotlin/jvm/functions/Function2;", "setOnSelectionChangeListener", "(Lkotlin/jvm/functions/Function2;)V", "richTextColor", "getRichTextColor", "setRichTextColor", "addEditObject", "editObject", "needSpace", "extraInfo", "Lorg/json/JSONObject;", "inputPosition", "addPureContentToEditObjectList", "startPos", "endPos", "addTopicObject", "callCopyAction", "callPasteAction", "checkAndCallRichObjectChangeListener", "delKeyOnSameSelection", "getCurrentDataList", "startCalPos", "endCalPos", "getEditObjectFromMap", "wording", "curSpan", "Lcom/tencent/tkd/weibo/richEditText/span/RichSpan;", "getFirstTopicSpan", "getRichSpanOrNullIfBehind", "getValidSelPosForRichText", "selection", "initKeyListener", "initTextWatcherListener", "insertIcon", "drawable", "Landroid/graphics/drawable/Drawable;", "size", "index", "alignRule", "insertNormalText", "insertNormalTextWithEmoJi", "emoJiPositionList", "", "emoJiTabList", "insertRichText", "insertWordingOverSize", "isIndexInSpan", "onCreateInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "onKeyCallbackFunction", "event", "Landroid/view/KeyEvent;", "keyCode", "onSelectionChanged", "selStart", "selEnd", "onTextContextMenuItem", "id", "removeElementOnTextByIndex", "textIndex", "restoreDataFromList", "editObjectList", "transEmotionFlagToName", "startPosition", "endPosition", "Companion", "tkd-weibo-richtext_release"}, k=1, mv={1, 1, 16})
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
  @Nullable
  private Function2<? super Integer, ? super Integer, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction2;
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
    Object localObject1 = getText();
    int i = getText().length();
    int j = 0;
    localObject1 = (RichSpan[])((Editable)localObject1).getSpans(0, i, RichSpan.class);
    if ((paramInt == 0) && (!this.jdField_b_of_type_Boolean))
    {
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "baseRichSpans");
      if (localObject1.length == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (((i ^ 0x1) != 0) && (localObject1[0].a() == EditObject.EditObjectType.TYPE_TOPIC))
      {
        i = 1;
        break label92;
      }
    }
    i = 0;
    label92:
    if (i != 0) {
      return getText().getSpanEnd(localObject1[0]);
    }
    int k = localObject1.length;
    i = j;
    while (i < k)
    {
      Object localObject2 = localObject1[i];
      j = getText().getSpanStart(localObject2);
      int m = getText().getSpanEnd(localObject2);
      if ((j + 1 <= paramInt) && (m >= paramInt)) {
        return m;
      }
      i += 1;
    }
    return paramInt;
  }
  
  private final EditObject a(String paramString, RichSpan paramRichSpan)
  {
    EditObject localEditObject = (EditObject)this.jdField_a_of_type_JavaUtilHashMap.get(new Pair(paramRichSpan.a(), paramRichSpan.a()));
    if (localEditObject != null) {
      return localEditObject;
    }
    return new EditObject(paramString, paramRichSpan.a());
  }
  
  private final RichSpan a(int paramInt)
  {
    Object localObject = (RichSpan)null;
    Editable localEditable = getText();
    int j = getText().length();
    int i = 0;
    RichSpan[] arrayOfRichSpan = (RichSpan[])localEditable.getSpans(0, j, RichSpan.class);
    j = arrayOfRichSpan.length;
    while (i < j)
    {
      localEditable = arrayOfRichSpan[i];
      int k = getText().getSpanStart(localEditable);
      int m = getText().getSpanEnd(localEditable);
      if ((k + 1 <= paramInt) && (m >= paramInt)) {
        localObject = localEditable;
      }
      i += 1;
    }
    return localObject;
  }
  
  private final String a(int paramInt1, int paramInt2)
  {
    Object localObject1 = getText().toString();
    if (localObject1 != null)
    {
      localObject1 = ((String)localObject1).substring(paramInt1, paramInt2);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject2 = (EmotionSpan[])getText().getSpans(paramInt1, ((String)localObject1).length() + paramInt1, EmotionSpan.class);
      List localList = (List)new ArrayList();
      int i = localObject2.length;
      paramInt2 = 0;
      Object localObject3;
      while (paramInt2 < i)
      {
        localObject3 = localObject2[paramInt2];
        localList.add(new Pair(Integer.valueOf(getText().getSpanStart(localObject3)), ((EmotionSpan)localObject3).a()));
        paramInt2 += 1;
      }
      int j = ((CharSequence)localObject1).length();
      paramInt2 = 0;
      while (paramInt2 < j)
      {
        char c1 = ((String)localObject1).charAt(paramInt2);
        localObject3 = (Iterable)localList;
        localObject2 = (Collection)new ArrayList();
        localObject3 = ((Iterable)localObject3).iterator();
        for (;;)
        {
          boolean bool = ((Iterator)localObject3).hasNext();
          i = 1;
          if (!bool) {
            break;
          }
          Object localObject4 = ((Iterator)localObject3).next();
          Integer localInteger = (Integer)((Pair)localObject4).first;
          if ((localInteger == null) || (localInteger.intValue() != paramInt2 + paramInt1)) {
            i = 0;
          }
          if (i != 0) {
            ((Collection)localObject2).add(localObject4);
          }
        }
        localObject2 = (List)localObject2;
        if ((Intrinsics.areEqual(String.valueOf(c1), "^")) && ((((Collection)localObject2).isEmpty() ^ true))) {
          localStringBuilder.append((String)((Pair)((List)localObject2).get(0)).second);
        } else {
          localStringBuilder.append(c1);
        }
        paramInt2 += 1;
      }
      localObject1 = localStringBuilder.toString();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "stringBuilder.toString()");
      return localObject1;
    }
    localObject1 = new TypeCastException("null cannot be cast to non-null type java.lang.String");
    for (;;)
    {
      throw ((Throwable)localObject1);
    }
  }
  
  private final ArrayList<EditObject> a(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    Object localObject1 = RichEditText.Companion.a(jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText$Companion);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("getCurrentDataList: startPos:");
    ((StringBuilder)localObject2).append(i);
    ((StringBuilder)localObject2).append(", endPos:");
    ((StringBuilder)localObject2).append(paramInt2);
    ((ILogger)localObject1).a("RichEditText", ((StringBuilder)localObject2).toString(), null);
    localObject1 = new ArrayList();
    if (i == paramInt2) {
      return localObject1;
    }
    localObject2 = (RichSpan[])getText().getSpans(i, paramInt2, RichSpan.class);
    Object localObject3 = RichEditText.Companion.a(jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText$Companion);
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("getCurrentDataList | spanList: ");
    ((StringBuilder)localObject4).append("startPos = ");
    ((StringBuilder)localObject4).append(i);
    ((StringBuilder)localObject4).append(", endPos = ");
    ((StringBuilder)localObject4).append(paramInt2);
    ((StringBuilder)localObject4).append(", size = ");
    ((StringBuilder)localObject4).append(localObject2.length);
    ((ILogger)localObject3).a("RichEditText", ((StringBuilder)localObject4).toString(), null);
    localObject3 = CollectionUtil.a;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "richSpans");
    localObject4 = getText();
    Intrinsics.checkExpressionValueIsNotNull(localObject4, "text");
    localObject2 = ((CollectionUtil)localObject3).a((RichSpan[])localObject2, (Editable)localObject4);
    localObject3 = (Collection)localObject2;
    if ((((((Collection)localObject3).isEmpty() ^ true)) && (i < getText().getSpanStart(((ArrayList)localObject2).get(0)))) || (((ArrayList)localObject2).isEmpty())) {
      j = 1;
    } else {
      j = 0;
    }
    paramInt1 = i;
    if (j != 0)
    {
      if ((((Collection)localObject3).isEmpty() ^ true)) {
        paramInt1 = getText().getSpanStart(((ArrayList)localObject2).get(0));
      } else {
        paramInt1 = paramInt2;
      }
      a(i, paramInt1, (ArrayList)localObject1);
    }
    int j = ((ArrayList)localObject2).size();
    i = 0;
    while (i < j)
    {
      localObject3 = ((ArrayList)localObject2).get(i);
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "sortedSpans[spanPos]");
      localObject3 = (RichSpan)localObject3;
      int k = getText().getSpanEnd(localObject3);
      localObject4 = getText();
      Intrinsics.checkExpressionValueIsNotNull(localObject4, "text");
      localObject4 = a(((CharSequence)localObject4).subSequence(paramInt1, k).toString(), (RichSpan)localObject3);
      ILogger localILogger = RichEditText.Companion.a(jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText$Companion);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCurrentDataList | getObjectInLocalMap: ");
      localStringBuilder.append("key = [type: ");
      localStringBuilder.append(((RichSpan)localObject3).a());
      localStringBuilder.append(" , id: ");
      localStringBuilder.append(((RichSpan)localObject3).a());
      localStringBuilder.append(']');
      localStringBuilder.append("curObject = ");
      localStringBuilder.append(localObject4);
      localStringBuilder.append(", curPos:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", DataList added.");
      localILogger.a("RichEditText", localStringBuilder.toString(), null);
      ((ArrayList)localObject1).add(localObject4);
      if (k >= paramInt2) {
        return localObject1;
      }
      if (i < ((ArrayList)localObject2).size() - 1) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
      if (paramInt1 != 0) {
        paramInt1 = getText().getSpanStart(((ArrayList)localObject2).get(i + 1));
      } else {
        paramInt1 = paramInt2;
      }
      a(k, paramInt1, (ArrayList)localObject1);
      i += 1;
    }
    return localObject1;
  }
  
  private final void a()
  {
    addTextChangedListener((TextWatcher)new RichEditText.initTextWatcherListener.1(this));
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
    if (localObject != null)
    {
      localObject = ((String)localObject).substring(paramInt1, paramInt2);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      int i;
      if (((CharSequence)localObject).length() > 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        localObject = new EditObject(a(paramInt1, paramInt2), null, 2, null);
        paramArrayList.add(localObject);
        paramArrayList = RichEditText.Companion.a(jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText$Companion);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getCurrentDataList | curObject = ");
        localStringBuilder.append(localObject);
        localStringBuilder.append(", curPos:");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(", DataList added.");
        paramArrayList.a("RichEditText", localStringBuilder.toString(), null);
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  private final void a(int paramInt, String paramString, List<Integer> paramList, List<String> paramList1)
  {
    setSelection(paramInt);
    int j = ((Collection)paramList).size();
    paramInt = 0;
    int k;
    int m;
    for (int i = 0; paramInt < j; i = m + k)
    {
      k = ((Number)paramList.get(paramInt)).intValue();
      String str = (String)paramList1.get(paramInt);
      m = str.length();
      getText().insert(getSelectionStart(), paramString.subSequence(i, k));
      Object localObject = RichEditText.Companion.a(jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText$Companion);
      if (localObject != null) {
        localObject = ((IEmoJiBridge)localObject).a(str);
      } else {
        localObject = null;
      }
      if (localObject != null) {
        a(this, (Drawable)localObject, str, 0, 0, 0, 28, null);
      } else {
        getText().insert(getSelectionStart(), (CharSequence)str);
      }
      paramInt += 1;
    }
    if (i < paramString.length() - 1) {
      getText().insert(getSelectionStart(), paramString.subSequence(i, paramString.length() - 1));
    }
  }
  
  private final void a(EditObject paramEditObject, int paramInt)
  {
    EmoJiParser localEmoJiParser = new EmoJiParser(paramEditObject.getWording());
    int i;
    if ((localEmoJiParser.a()) && (localEmoJiParser.b())) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      getText().insert(paramInt, (CharSequence)paramEditObject.getWording());
      return;
    }
    a(paramInt, paramEditObject.getWording(), localEmoJiParser.b(), localEmoJiParser.a());
  }
  
  private final void a(EditObject paramEditObject, int paramInt, boolean paramBoolean)
  {
    Object localObject2 = paramEditObject.getWording();
    if ((getText().length() + ((String)localObject2).length() > this.jdField_b_of_type_Int) && (this.jdField_a_of_type_Boolean))
    {
      a((String)localObject2, paramInt);
      localObject1 = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextEditObjectListener;
      if (localObject1 != null) {
        EditObjectListener.DefaultImpls.a((EditObjectListener)localObject1, paramEditObject, null, 2, null);
      }
    }
    else
    {
      getText().insert(paramInt, (CharSequence)localObject2);
    }
    Object localObject1 = new RichSpan(this.jdField_a_of_type_Int, paramEditObject.getType(), paramEditObject.getId());
    if (getSelectionStart() - paramInt == ((String)localObject2).length())
    {
      getText().setSpan(localObject1, paramInt, getSelectionStart(), 33);
      if (!TextUtils.isEmpty((CharSequence)((RichSpan)localObject1).a())) {
        ((Map)this.jdField_a_of_type_JavaUtilHashMap).put(new Pair(((RichSpan)localObject1).a(), ((RichSpan)localObject1).a()), paramEditObject);
      }
      localObject2 = RichEditText.Companion.a(jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText$Companion);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addEditObject: Add to local map: ");
      localStringBuilder.append("key = [type: ");
      localStringBuilder.append(((RichSpan)localObject1).a());
      localStringBuilder.append(",id: ");
      localStringBuilder.append(((RichSpan)localObject1).a());
      localStringBuilder.append("], value: ");
      localStringBuilder.append(paramEditObject);
      ((ILogger)localObject2).a("RichEditText", localStringBuilder.toString(), null);
    }
    if (paramBoolean)
    {
      getText().insert(getSelectionStart(), (CharSequence)" ");
      setSelection(getSelectionStart());
    }
  }
  
  private final void a(EditObject paramEditObject, int paramInt, boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      b(paramEditObject, paramInt, paramBoolean, paramJSONObject);
      return;
    }
    RichSpan localRichSpan = b();
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
        localEditObjectListener.a(false, EditObject.EditObjectType.TYPE_TOPIC, localRichSpan.a(), paramJSONObject);
      }
    }
    b(paramEditObject, 0, paramBoolean, paramJSONObject);
  }
  
  private final void a(EditObject paramEditObject, boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramEditObject.getType() == EditObject.EditObjectType.TYPE_TOPIC)
    {
      a(paramEditObject, getSelectionStart(), paramBoolean, paramJSONObject);
      return;
    }
    b(paramEditObject, getSelectionStart(), paramBoolean, paramJSONObject);
  }
  
  private final void a(String paramString, int paramInt)
  {
    int j = getText().length();
    int i = this.jdField_b_of_type_Int;
    int k = getText().length();
    if (j == paramInt)
    {
      if (paramString != null)
      {
        paramString = paramString.substring(0, i - k);
        Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      }
    }
    else
    {
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
        break label173;
      }
      paramString = paramString.substring(0, i);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    }
    getText().insert(paramInt, (CharSequence)paramString);
    return;
    label173:
    paramString = new TypeCastException("null cannot be cast to non-null type java.lang.String");
    for (;;)
    {
      throw paramString;
    }
  }
  
  private final boolean a(KeyEvent paramKeyEvent, int paramInt)
  {
    if ((paramInt == 67) && (paramKeyEvent.getAction() == 0)) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (paramInt != 0)
    {
      if (getSelectionStart() == getSelectionEnd()) {
        return b();
      }
      c();
    }
    return false;
  }
  
  private final RichSpan b()
  {
    Object localObject = getText();
    int j = getText().length();
    int i = 0;
    localObject = (RichSpan[])((Editable)localObject).getSpans(0, j, RichSpan.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "spans");
    j = localObject.length;
    while (i < j)
    {
      RichSpan localRichSpan = localObject[i];
      if (localRichSpan.a() == EditObject.EditObjectType.TYPE_TOPIC) {
        return localRichSpan;
      }
      i += 1;
    }
    return null;
  }
  
  private final void b()
  {
    setOnKeyListener((View.OnKeyListener)new RichEditText.initKeyListener.1(this));
  }
  
  private final void b(EditObject paramEditObject, int paramInt, boolean paramBoolean, JSONObject paramJSONObject)
  {
    int i;
    if (((CharSequence)paramEditObject.getWording()).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i == 0) && (paramInt >= 0))
    {
      if ((getText().length() >= this.jdField_b_of_type_Int) && (this.jdField_a_of_type_Boolean))
      {
        paramJSONObject = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextEditObjectListener;
        if (paramJSONObject != null) {
          EditObjectListener.DefaultImpls.a(paramJSONObject, paramEditObject, null, 2, null);
        }
        return;
      }
      setSelection(paramInt);
      if (paramEditObject.getType() == EditObject.EditObjectType.TYPE_NORMAL)
      {
        a(paramEditObject, paramInt);
        return;
      }
      a(paramEditObject, paramInt, paramBoolean);
      EditObjectListener localEditObjectListener = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextEditObjectListener;
      if (localEditObjectListener != null) {
        localEditObjectListener.a(true, paramEditObject.getType(), paramEditObject.getId(), paramJSONObject);
      }
      return;
    }
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("addEditObject invalid params. object:");
    paramJSONObject.append(paramEditObject);
    paramJSONObject.append(", inputPos:");
    paramJSONObject.append(paramInt);
    paramEditObject = paramJSONObject.toString();
    RichEditText.Companion.a(jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText$Companion).b("RichEditText", paramEditObject, null);
  }
  
  private final boolean b()
  {
    Log.d("RichEditText", "delKeyOnSameSelection.");
    RichSpan localRichSpan = a();
    if (localRichSpan != null)
    {
      int i = getText().getSpanStart(localRichSpan);
      int j = getText().getSpanEnd(localRichSpan);
      if ((localRichSpan.a() == EditObject.EditObjectType.TYPE_TOPIC) && (!this.jdField_b_of_type_Boolean))
      {
        if (!this.c) {
          return true;
        }
        getText().delete(i, j);
        EditObjectListener localEditObjectListener = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextEditObjectListener;
        if (localEditObjectListener != null)
        {
          EditObjectListener.DefaultImpls.a(localEditObjectListener, false, EditObject.EditObjectType.TYPE_TOPIC, localRichSpan.a(), null, 8, null);
          return true;
        }
      }
      else
      {
        setSelection(i, j);
      }
      return true;
    }
    return false;
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
        EditObjectListener.DefaultImpls.a(localEditObjectListener, false, localRichSpan.a(), localRichSpan.a(), null, 8, null);
      }
      i += 1;
    }
  }
  
  private final boolean c()
  {
    if (getSelectionStart() == getSelectionEnd()) {
      return false;
    }
    Object localObject1 = getContext().getSystemService("clipboard");
    if (localObject1 != null)
    {
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
    localObject1 = new TypeCastException("null cannot be cast to non-null type android.content.ClipboardManager");
    for (;;)
    {
      throw ((Throwable)localObject1);
    }
  }
  
  private final boolean d()
  {
    Object localObject1 = getContext().getSystemService("clipboard");
    if (localObject1 != null)
    {
      localObject1 = ((ClipboardManager)localObject1).getPrimaryClip();
      Object localObject2 = null;
      if (localObject1 != null)
      {
        localObject1 = ((ClipData)localObject1).getItemAt(0);
        if (localObject1 != null)
        {
          localObject1 = ((ClipData.Item)localObject1).getIntent();
          if (localObject1 != null)
          {
            localObject1 = ((Intent)localObject1).getExtras();
            break label58;
          }
        }
      }
      localObject1 = null;
      label58:
      if (localObject1 != null) {
        ((Bundle)localObject1).setClassLoader(EditObject.class.getClassLoader());
      }
      if (localObject1 != null) {
        localObject2 = ((Bundle)localObject1).getParcelableArrayList("key_rich_edit_text_data");
      }
      if ((localObject2 != null) && ((((Collection)localObject2).isEmpty() ^ true)))
      {
        localObject1 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (EditObject)((Iterator)localObject1).next();
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "data");
          a(this, (EditObject)localObject2, false, null, 4, null);
        }
        setSelection(getSelectionEnd());
        return true;
      }
      return false;
    }
    localObject1 = new TypeCastException("null cannot be cast to non-null type android.content.ClipboardManager");
    for (;;)
    {
      throw ((Throwable)localObject1);
    }
  }
  
  public final int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  @Nullable
  public final RichSpan a()
  {
    RichSpan[] arrayOfRichSpan = (RichSpan[])getText().getSpans(getSelectionEnd(), getSelectionEnd(), RichSpan.class);
    Intrinsics.checkExpressionValueIsNotNull(arrayOfRichSpan, "baseRichSpans");
    int i;
    if (arrayOfRichSpan.length == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (((i ^ 0x1) != 0) && (getText().getSpanEnd(arrayOfRichSpan[0]) == getSelectionEnd())) {
      return arrayOfRichSpan[0];
    }
    return null;
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
    if ((getText().length() + 1 <= this.jdField_b_of_type_Int) || (!this.jdField_a_of_type_Boolean))
    {
      paramDrawable.setBounds(0, 0, paramInt1, paramInt1);
      paramDrawable = new EmotionSpan(paramDrawable, paramString, paramInt3);
      paramString = new SpannableString((CharSequence)"^");
      paramString.setSpan(paramDrawable, 0, paramString.length(), 33);
      if (paramInt2 >= length()) {
        append((CharSequence)paramString);
      } else {
        getText().insert(paramInt2, (CharSequence)paramString);
      }
      setSelection(paramInt2 + paramString.length());
    }
  }
  
  public final void a(@NotNull EditObject paramEditObject, @Nullable JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramEditObject, "editObject");
    a(paramEditObject, true, paramJSONObject);
  }
  
  public final void a(@NotNull List<EditObject> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "editObjectList");
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext()) {
      a(this, (EditObject)paramList.next(), false, null, 4, null);
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
    Intrinsics.checkExpressionValueIsNotNull(paramEditorInfo, "target");
    return (InputConnection)new FixSharpConnectionWrapper(this, paramEditorInfo, false);
  }
  
  protected void onSelectionChanged(int paramInt1, int paramInt2)
  {
    super.onSelectionChanged(paramInt1, paramInt2);
    Object localObject = this.jdField_a_of_type_KotlinJvmFunctionsFunction2;
    if (localObject != null) {
      localObject = (Unit)((Function2)localObject).invoke(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    }
    setSelection(a(paramInt1), a(paramInt2));
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    if (paramInt == 16908321)
    {
      if (c()) {
        return true;
      }
    }
    else if ((paramInt == 16908322) && (d())) {
      return true;
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
  
  public final void setOnSelectionChangeListener(@Nullable Function2<? super Integer, ? super Integer, Unit> paramFunction2)
  {
    this.jdField_a_of_type_KotlinJvmFunctionsFunction2 = paramFunction2;
  }
  
  public final void setRichTextColor(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.weibo.richEditText.RichEditText
 * JD-Core Version:    0.7.0.1
 */