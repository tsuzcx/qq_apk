package com.tencent.mtt.hippy.views.textinput;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.dom.node.StyleNode;
import com.tencent.mtt.hippy.dom.node.TextExtra;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.utils.PixelUtil;
import java.util.LinkedList;

@HippyController(name="TextInput")
public class HippyTextInputController
  extends HippyViewController<HippyTextInput>
{
  public static final String CLASS_NAME = "TextInput";
  private static final String CLEAR_FUNCTION = "clear";
  public static final String COMMAND_BLUR = "blurTextInput";
  public static final String COMMAND_FOCUS = "focusTextInput";
  public static final String COMMAND_KEYBOARD_DISMISS = "dissmiss";
  public static final String COMMAND_getValue = "getValue";
  public static final String COMMAND_setValue = "setValue";
  private static final InputFilter[] EMPTY_FILTERS = new InputFilter[0];
  private static final int INPUT_TYPE_KEYBOARD_NUMBERED = 12290;
  private static final String KEYBOARD_TYPE_EMAIL_ADDRESS = "email";
  private static final String KEYBOARD_TYPE_NUMERIC = "numeric";
  private static final String KEYBOARD_TYPE_PASS_WORD = "password";
  private static final String KEYBOARD_TYPE_PHONE_PAD = "phone-pad";
  private static final String TAG = "HippyTextInputControlle";
  
  private static int parseFontWeight(String paramString)
  {
    if ((paramString.length() == 3) && (paramString.endsWith("00")) && (paramString.charAt(0) <= '9') && (paramString.charAt(0) >= '1')) {
      return (paramString.charAt(0) - '0') * 100;
    }
    return -1;
  }
  
  protected StyleNode createNode(boolean paramBoolean)
  {
    return new TextInputNode(paramBoolean);
  }
  
  protected View createViewImpl(Context paramContext)
  {
    return new HippyTextInput(paramContext);
  }
  
  public void dispatchFunction(HippyTextInput paramHippyTextInput, String paramString, HippyArray paramHippyArray)
  {
    int i = paramString.hashCode();
    int j = 0;
    switch (i)
    {
    default: 
      break;
    case 1690703013: 
      if (paramString.equals("focusTextInput")) {
        i = 2;
      }
      break;
    case 1406685743: 
      if (paramString.equals("setValue")) {
        i = 0;
      }
      break;
    case 287889441: 
      if (paramString.equals("dissmiss")) {
        i = 3;
      }
      break;
    case 94746189: 
      if (paramString.equals("clear")) {
        i = 1;
      }
      break;
    case -1699362314: 
      if (paramString.equals("blurTextInput")) {
        i = 4;
      }
      break;
    }
    i = -1;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i == 4)
            {
              for (ViewParent localViewParent = paramHippyTextInput.getParent(); (localViewParent != null) && (!(localViewParent instanceof HippyRootView)); localViewParent = localViewParent.getParent()) {}
              boolean bool = localViewParent instanceof HippyRootView;
              i = j;
              if (bool)
              {
                ViewGroup localViewGroup = (ViewGroup)localViewParent;
                i = localViewGroup.getDescendantFocusability();
                localViewGroup.setDescendantFocusability(393216);
              }
              paramHippyTextInput.hideInputMethod();
              paramHippyTextInput.clearFocus();
              if (bool) {
                ((ViewGroup)localViewParent).setDescendantFocusability(i);
              }
            }
          }
          else {
            paramHippyTextInput.hideInputMethod();
          }
        }
        else
        {
          paramHippyTextInput.setFocusableInTouchMode(true);
          Looper.getMainLooper();
          Looper.myQueue().addIdleHandler(new HippyTextInputController.1(this, paramHippyTextInput, paramHippyArray));
        }
      }
      else {
        paramHippyTextInput.jsSetValue("", 0);
      }
    }
    else if ((paramHippyArray != null) && (paramHippyArray.getString(0) != null))
    {
      i = paramHippyArray.getInt(1);
      if (paramHippyArray.size() < 2) {
        i = paramHippyArray.getString(0).length();
      }
      paramHippyTextInput.jsSetValue(paramHippyArray.getString(0), i);
    }
    super.dispatchFunction(paramHippyTextInput, paramString, paramHippyArray);
  }
  
  public void dispatchFunction(HippyTextInput paramHippyTextInput, String paramString, HippyArray paramHippyArray, Promise paramPromise)
  {
    if (("getValue".equals(paramString)) && (paramPromise != null)) {
      paramPromise.resolve(paramHippyTextInput.jsGetValue());
    }
  }
  
  @HippyControllerProps(defaultNumber=-1.0D, defaultType="number", name="letterSpacing")
  public void letterSpacing(HippyTextInput paramHippyTextInput, float paramFloat)
  {
    if ((Build.VERSION.SDK_INT >= 21) && (paramFloat != -1.0F)) {
      paramHippyTextInput.setLetterSpacing(PixelUtil.dp2px(paramFloat));
    }
  }
  
  @HippyControllerProps(defaultNumber=2147483647.0D, defaultType="number", name="maxLength")
  public void maxLength(HippyTextInput paramHippyTextInput, int paramInt)
  {
    InputFilter[] arrayOfInputFilter2 = paramHippyTextInput.getFilters();
    InputFilter[] arrayOfInputFilter3 = EMPTY_FILTERS;
    int i = 0;
    InputFilter[] arrayOfInputFilter1;
    if (paramInt == -1)
    {
      arrayOfInputFilter1 = arrayOfInputFilter3;
      if (arrayOfInputFilter2.length > 0)
      {
        LinkedList localLinkedList = new LinkedList();
        paramInt = i;
        while (paramInt < arrayOfInputFilter2.length)
        {
          if (!(arrayOfInputFilter2[paramInt] instanceof InputFilter.LengthFilter)) {
            localLinkedList.add(arrayOfInputFilter2[paramInt]);
          }
          paramInt += 1;
        }
        arrayOfInputFilter1 = arrayOfInputFilter3;
        if (!localLinkedList.isEmpty()) {
          arrayOfInputFilter1 = (InputFilter[])localLinkedList.toArray(new InputFilter[localLinkedList.size()]);
        }
      }
    }
    else if (arrayOfInputFilter2.length > 0)
    {
      i = 0;
      int j = 0;
      while (i < arrayOfInputFilter2.length)
      {
        if ((arrayOfInputFilter2[i] instanceof InputFilter.LengthFilter))
        {
          arrayOfInputFilter2[i] = new InputFilter.LengthFilter(paramInt);
          j = 1;
        }
        i += 1;
      }
      if (j == 0)
      {
        arrayOfInputFilter1 = new InputFilter[arrayOfInputFilter2.length + 1];
        System.arraycopy(arrayOfInputFilter2, 0, arrayOfInputFilter1, 0, arrayOfInputFilter2.length);
        arrayOfInputFilter2[arrayOfInputFilter2.length] = new InputFilter.LengthFilter(paramInt);
      }
      else
      {
        arrayOfInputFilter1 = arrayOfInputFilter2;
      }
    }
    else
    {
      arrayOfInputFilter1 = new InputFilter[1];
      arrayOfInputFilter1[0] = new InputFilter.LengthFilter(paramInt);
    }
    paramHippyTextInput.setFilters(arrayOfInputFilter1);
  }
  
  @HippyControllerProps(defaultBoolean=true, defaultType="boolean", name="multiline")
  public void multiLine(HippyTextInput paramHippyTextInput, boolean paramBoolean)
  {
    int i = paramHippyTextInput.getInputType();
    if (paramBoolean) {
      i |= 0x20000;
    } else {
      i &= 0xFFFDFFFF;
    }
    paramHippyTextInput.setInputType(i);
    if (paramBoolean) {
      paramHippyTextInput.setGravityVertical(48);
    }
  }
  
  @HippyControllerProps(defaultType="string", name="placeholder")
  public void placeHolder(HippyTextInput paramHippyTextInput, String paramString)
  {
    paramHippyTextInput.setHint(paramString);
  }
  
  @HippyControllerProps(defaultType="boolean", name="onBlur")
  public void setBlur(HippyTextInput paramHippyTextInput, boolean paramBoolean)
  {
    paramHippyTextInput.setBlurOrOnFocus(paramBoolean);
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="caret-color")
  public void setCaretColor(HippyTextInput paramHippyTextInput, int paramInt)
  {
    paramHippyTextInput.setCursorColor(paramInt);
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="caretColor")
  public void setCaretColorAlias(HippyTextInput paramHippyTextInput, int paramInt)
  {
    paramHippyTextInput.setCursorColor(paramInt);
  }
  
  @HippyControllerProps(defaultType="number", name="color")
  public void setColor(HippyTextInput paramHippyTextInput, int paramInt)
  {
    paramHippyTextInput.setTextColor(paramInt);
  }
  
  @HippyControllerProps(defaultType="string", name="defaultValue")
  public void setDefaultValue(HippyTextInput paramHippyTextInput, String paramString)
  {
    if (!TextUtils.equals(paramHippyTextInput.getText().toString(), paramString))
    {
      paramHippyTextInput.setText(paramString);
      if (!TextUtils.isEmpty(paramString)) {
        paramHippyTextInput.setSelection(paramString.length());
      }
    }
  }
  
  @HippyControllerProps(defaultBoolean=true, defaultType="boolean", name="editable")
  public void setEditable(HippyTextInput paramHippyTextInput, boolean paramBoolean)
  {
    paramHippyTextInput.setEnabled(paramBoolean);
  }
  
  @HippyControllerProps(defaultType="boolean", name="onEndEditing")
  public void setEndEditing(HippyTextInput paramHippyTextInput, boolean paramBoolean)
  {
    paramHippyTextInput.setOnEndEditingListener(paramBoolean);
  }
  
  @HippyControllerProps(defaultString="normal", defaultType="string", name="fontFamily")
  public void setFontFamily(HippyTextInput paramHippyTextInput, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    int i = 0;
    if (paramHippyTextInput.getTypeface() != null) {
      i = paramHippyTextInput.getTypeface().getStyle();
    }
    paramHippyTextInput.setTypeface(Typeface.create(paramString, i));
  }
  
  @HippyControllerProps(defaultNumber=14.0D, defaultType="number", name="fontSize")
  public void setFontSize(HippyTextInput paramHippyTextInput, float paramFloat)
  {
    paramHippyTextInput.setTextSize(0, (int)Math.ceil(PixelUtil.dp2px(paramFloat)));
  }
  
  @HippyControllerProps(defaultString="normal", defaultType="string", name="fontStyle")
  public void setFontStyle(HippyTextInput paramHippyTextInput, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    int i = -1;
    if ("italic".equals(paramString)) {
      i = 2;
    } else if ("normal".equals(paramString)) {
      i = 0;
    }
    Typeface localTypeface = paramHippyTextInput.getTypeface();
    paramString = localTypeface;
    if (localTypeface == null) {
      paramString = Typeface.DEFAULT;
    }
    if (i != paramString.getStyle()) {
      paramHippyTextInput.setTypeface(paramString, i);
    }
  }
  
  @HippyControllerProps(defaultString="normal", defaultType="string", name="fontWeight")
  public void setFontWeight(HippyTextInput paramHippyTextInput, String paramString)
  {
    int k = -1;
    int j;
    if (paramString != null) {
      j = parseFontWeight(paramString);
    } else {
      j = -1;
    }
    int i;
    if ((j < 500) && (!"bold".equals(paramString)))
    {
      if (!"normal".equals(paramString))
      {
        i = k;
        if (j != -1)
        {
          i = k;
          if (j >= 500) {}
        }
      }
      else
      {
        i = 0;
      }
    }
    else {
      i = 1;
    }
    Typeface localTypeface = paramHippyTextInput.getTypeface();
    paramString = localTypeface;
    if (localTypeface == null) {
      paramString = Typeface.DEFAULT;
    }
    if (i != paramString.getStyle()) {
      paramHippyTextInput.setTypeface(paramString, i);
    }
  }
  
  @HippyControllerProps(defaultType="string", name="keyboardType")
  public void setKeyboardType(HippyTextInput paramHippyTextInput, String paramString)
  {
    int i;
    if ("numeric".equalsIgnoreCase(paramString))
    {
      i = 12290;
    }
    else if ("email".equalsIgnoreCase(paramString))
    {
      i = 33;
    }
    else if ("phone-pad".equalsIgnoreCase(paramString))
    {
      i = 3;
    }
    else if ("password".equalsIgnoreCase(paramString))
    {
      i = 129;
      paramHippyTextInput.setTransformationMethod(PasswordTransformationMethod.getInstance());
    }
    else
    {
      i = 1;
    }
    paramHippyTextInput.setInputType(i);
  }
  
  @HippyControllerProps(defaultNumber=2147483647.0D, defaultType="number", name="numberOfLines")
  public void setMaxLines(HippyTextInput paramHippyTextInput, int paramInt)
  {
    paramHippyTextInput.setMaxLines(paramInt);
  }
  
  @HippyControllerProps(defaultType="boolean", name="onChangeText")
  public void setOnChangeText(HippyTextInput paramHippyTextInput, boolean paramBoolean)
  {
    paramHippyTextInput.setOnChangeListener(paramBoolean);
  }
  
  @HippyControllerProps(defaultType="boolean", name="onContentSizeChange")
  public void setOnContentSizeChange(HippyTextInput paramHippyTextInput, boolean paramBoolean)
  {
    paramHippyTextInput.setOnContentSizeChange(paramBoolean);
  }
  
  @HippyControllerProps(defaultType="boolean", name="onFocus")
  public void setOnFocus(HippyTextInput paramHippyTextInput, boolean paramBoolean)
  {
    paramHippyTextInput.setBlurOrOnFocus(paramBoolean);
  }
  
  @HippyControllerProps(defaultType="boolean", name="onSelectionChange")
  public void setOnSelectionChange(HippyTextInput paramHippyTextInput, boolean paramBoolean)
  {
    paramHippyTextInput.setOnSelectListener(paramBoolean);
  }
  
  @HippyControllerProps(name="returnKeyType")
  public void setReturnKeyType(HippyTextInput paramHippyTextInput, String paramString)
  {
    int j = 4;
    if (paramString != null)
    {
      switch (paramString.hashCode())
      {
      default: 
        break;
      case 3526536: 
        if (paramString.equals("send")) {
          i = 5;
        }
        break;
      case 3387192: 
        if (paramString.equals("none")) {
          i = 2;
        }
        break;
      case 3377907: 
        if (paramString.equals("next")) {
          i = 1;
        }
        break;
      case 3089282: 
        if (paramString.equals("done")) {
          i = 6;
        }
        break;
      case 3304: 
        if (paramString.equals("go")) {
          i = 0;
        }
        break;
      case -906336856: 
        if (paramString.equals("search")) {
          i = 4;
        }
        break;
      case -1273775369: 
        if (paramString.equals("previous")) {
          i = 3;
        }
        break;
      }
      i = -1;
      switch (i)
      {
      default: 
        break;
      case 6: 
        paramHippyTextInput.setSingleLine(true);
        break;
      case 4: 
        paramHippyTextInput.setSingleLine(true);
        i = 3;
        break;
      case 3: 
        j = 7;
      case 5: 
        paramHippyTextInput.setSingleLine(true);
        i = j;
        break;
      case 2: 
        i = 1;
        break;
      case 1: 
        paramHippyTextInput.setSingleLine(true);
        i = 5;
        break;
      case 0: 
        i = 2;
        break;
      }
    }
    int i = 6;
    paramHippyTextInput.setImeOptions(0x2000000 | i);
  }
  
  @HippyControllerProps(defaultType="string", name="textAlign")
  public void setTextAlign(HippyTextInput paramHippyTextInput, String paramString)
  {
    if ((paramString != null) && (!"auto".equals(paramString)))
    {
      if ("left".equals(paramString)) {}
      for (;;)
      {
        paramHippyTextInput.setGravityHorizontal(3);
        return;
        if ("right".equals(paramString))
        {
          i = 5;
          break;
        }
        if ("center".equals(paramString))
        {
          i = 1;
          break;
        }
        if (!"justify".equals(paramString)) {
          return;
        }
      }
    }
    int i = 0;
    paramHippyTextInput.setGravityHorizontal(i);
  }
  
  @HippyControllerProps(name="textAlignVertical")
  public void setTextAlignVertical(HippyTextInput paramHippyTextInput, String paramString)
  {
    int i;
    if ((paramString != null) && (!"auto".equals(paramString)))
    {
      if ("top".equals(paramString))
      {
        i = 48;
      }
      else if ("bottom".equals(paramString))
      {
        i = 80;
      }
      else
      {
        if (!"center".equals(paramString)) {
          return;
        }
        i = 16;
      }
    }
    else {
      i = 0;
    }
    paramHippyTextInput.setGravityVertical(i);
  }
  
  @HippyControllerProps(defaultNumber=-7829368.0D, defaultType="number", name="placeholderTextColor")
  public void setTextHitColor(HippyTextInput paramHippyTextInput, int paramInt)
  {
    paramHippyTextInput.setHintTextColor(paramInt);
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="underlineColorAndroid")
  public void setUnderlineColor(HippyTextInput paramHippyTextInput, Integer paramInteger)
  {
    if (paramInteger == null)
    {
      paramHippyTextInput.getBackground().clearColorFilter();
      return;
    }
    paramHippyTextInput.getBackground().setColorFilter(paramInteger.intValue(), PorterDuff.Mode.SRC_IN);
  }
  
  @HippyControllerProps(defaultType="string", name="validator")
  public void setValidator(HippyTextInput paramHippyTextInput, String paramString)
  {
    paramHippyTextInput.setValidator(paramString);
  }
  
  protected void updateExtra(View paramView, Object paramObject)
  {
    super.updateExtra(paramView, paramObject);
    if ((paramObject instanceof TextExtra))
    {
      paramObject = (TextExtra)paramObject;
      ((HippyTextInput)paramView).setPadding((int)Math.ceil(paramObject.mLeftPadding), (int)Math.ceil(paramObject.mTopPadding), (int)Math.ceil(paramObject.mRightPadding), (int)Math.ceil(paramObject.mBottomPadding));
    }
  }
  
  @HippyControllerProps(defaultType="string", name="value")
  public void value(HippyTextInput paramHippyTextInput, String paramString)
  {
    int i = paramHippyTextInput.getSelectionStart();
    int j = paramHippyTextInput.getSelectionEnd();
    LogUtils.d("HippyTextInputControlle", String.format("setText: selectionStart:%s sEnd:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
    paramHippyTextInput = paramHippyTextInput.getEditableText();
    if (paramHippyTextInput == null) {
      return;
    }
    String str1 = paramHippyTextInput.toString();
    String str2 = str1.substring(0, i);
    String str3 = str1.substring(j);
    LogUtils.d("HippyTextInputControlle", String.format("setText: sub1:[%s]  sub2:[%s]", new Object[] { str2, str3 }));
    if ((i == j) && (paramString.length() > str1.length()) && (paramString.startsWith(str2)) && (paramString.endsWith(str3)))
    {
      paramString = paramString.substring(i, paramString.length() - str3.length());
      LogUtils.d("HippyTextInputControlle", String.format("setText: InsertStr: [%s]", new Object[] { paramString }));
      paramHippyTextInput.insert(i, paramString);
      return;
    }
    if ((i < j) && (paramString.startsWith(str2)) && (paramString.endsWith(str3)))
    {
      paramString = paramString.substring(i, paramString.length() - str3.length());
      LogUtils.d("HippyTextInputControlle", String.format("setText: ReplaceStr: [%s]", new Object[] { paramString }));
      paramHippyTextInput.replace(i, j, paramString);
      return;
    }
    if ((i == j) && (paramString.length() < str1.length()) && (paramString.endsWith(str3)) && (paramString.startsWith(str2.substring(0, i - (str1.length() - paramString.length())))))
    {
      paramHippyTextInput.delete(j - (str1.length() - paramString.length()), j);
      return;
    }
    paramHippyTextInput.replace(0, paramHippyTextInput.length(), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.textinput.HippyTextInputController
 * JD-Core Version:    0.7.0.1
 */