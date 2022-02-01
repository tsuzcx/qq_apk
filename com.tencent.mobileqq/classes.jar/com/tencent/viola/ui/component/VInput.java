package com.tencent.viola.ui.component;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import com.tencent.viola.annotation.JSMethod;
import com.tencent.viola.annotation.VComponentField;
import com.tencent.viola.annotation.VComponentProp;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.dom.style.BorderDrawable;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import com.tencent.viola.ui.view.VInputView;
import com.tencent.viola.utils.ColorParseUtils;
import com.tencent.viola.utils.ViolaLogUtils;
import com.tencent.viola.utils.ViolaUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VInput
  extends VComponent<VInputView>
{
  public static String TAG = "VInput";
  private String mCurrentMessage = "";
  @VComponentField(nativeReturnMethod="getHintTextColors", propertyName="placeholderColor")
  private int mHintTextColor;
  private String mLastMessage = "";
  private List<String> mListEvent = new ArrayList();
  @VComponentField(nativeReturnMethod="getPaddingLeft", propertyName="paddingLeft")
  private int mPaddingLeft;
  private int[] mPaddingList = { 0, 0, 0, 0 };
  @VComponentField(nativeReturnMethod="getPaddingRight", propertyName="paddingRight")
  private int mPaddingRight;
  @VComponentField(nativeReturnMethod="getTextColors", propertyName="color")
  private int mTextColors;
  @VComponentField(nativeReturnMethod="getTextSize", propertyName="fontSize")
  private int mTextSize;
  
  public VInput(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer);
  }
  
  private void trySetMulLine()
  {
    if ((this.mDomObj != null) && ("textarea".equals(this.mDomObj.getType()))) {
      ((VInputView)getHostView()).setSingleLine(false);
    }
  }
  
  public void addEvent(String paramString)
  {
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 100358090: 
      if (paramString.equals("input")) {
        i = 0;
      }
      break;
    case 97604824: 
      if (paramString.equals("focus")) {
        i = 2;
      }
      break;
    case 3027047: 
      if (paramString.equals("blur")) {
        i = 3;
      }
      break;
    case -934396624: 
      if (paramString.equals("return")) {
        i = 4;
      }
      break;
    case -1361636432: 
      if (paramString.equals("change")) {
        i = 1;
      }
      break;
    }
    int i = -1;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              super.addEvent(paramString);
              return;
            }
            this.mListEvent.add(paramString);
            return;
          }
          this.mListEvent.add(paramString);
          return;
        }
        this.mListEvent.add(paramString);
        return;
      }
      this.mListEvent.add(paramString);
      return;
    }
    this.mListEvent.add(paramString);
  }
  
  @JSMethod(uiThread=true)
  public void blur()
  {
    getParent().getRealView().setFocusable(true);
    getParent().getRealView().setFocusableInTouchMode(true);
    getParent().getRealView().requestFocus();
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getParent().getRealView().getWindowToken(), 0);
  }
  
  @JSMethod(uiThread=true)
  public void focus()
  {
    ((VInputView)getHostView()).requestFocus();
    ((VInputView)getHostView()).setFocusable(true);
    ((VInputView)getHostView()).setFocusableInTouchMode(true);
    ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput(getHostView(), 0);
  }
  
  @JSMethod(uiThread=true)
  public void getText(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("value", this.mCurrentMessage);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    JSONArray localJSONArray = new JSONArray();
    localJSONArray.put(paramString);
    ViolaBridgeManager.getInstance().callbackJavascript(this.mInstance.getInstanceId(), "", "callback", localJSONArray, localJSONObject, true);
  }
  
  protected VInputView initComponentHostView(@NonNull Context paramContext)
  {
    paramContext = new VInputView(paramContext, this.mDomObj.getType());
    paramContext.clearFocus();
    paramContext.bindComponent(this);
    paramContext.addTextChangedListener(new VInput.1(this));
    paramContext.setOnFocusChangeListener(new VInput.2(this));
    paramContext.setOnKeyListener(new VInput.3(this));
    return paramContext;
  }
  
  public void inputFireEvent(String paramString1, String paramString2)
  {
    if (!this.mListEvent.contains(paramString1)) {
      return;
    }
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("value", paramString2);
      paramString2 = new JSONArray();
      if (getDomObject() != null)
      {
        String str = getDomObject().getRef();
        if (str != null) {
          paramString2.put(str);
        }
      }
      paramString2.put(paramString1);
      fireEvent(paramString1, paramString2, localObject);
      return;
    }
    catch (Exception paramString1)
    {
      paramString2 = TAG;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("inputFireEvent error :");
      ((StringBuilder)localObject).append(paramString1.getMessage());
      ViolaLogUtils.e(paramString2, ((StringBuilder)localObject).toString());
    }
  }
  
  protected boolean resetAttr(String paramString)
  {
    if ((!super.resetAttr(paramString)) && (paramString.equals("type")))
    {
      ((VInputView)getHostView()).setInputType(0);
      return true;
    }
    return false;
  }
  
  @VComponentProp(initToHostView=true, name="autofocus", nativeReturnMethod="isFocused")
  public void setAutoFocus(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue())
    {
      ((VInputView)getHostView()).requestFocus();
      return;
    }
    ((VInputView)getHostView()).clearFocus();
  }
  
  public void setBackgroundColor(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = ViolaUtils.getColor(paramString);
      getOrCreateBorder().setColor(i);
    }
  }
  
  @VComponentProp(initToHostView=true, name="disabled", nativeReturnMethod="getInputType")
  public void setDisable(int paramInt)
  {
    if (paramInt == 1)
    {
      ((VInputView)getHostView()).setInputType(0);
      return;
    }
    ((VInputView)getHostView()).setInputType(1);
    trySetMulLine();
  }
  
  @VComponentProp(initToHostView=true, name="placeholder", nativeReturnMethod="getHint")
  public void setPlaceholder(String paramString)
  {
    ((VInputView)getHostView()).setHint(paramString);
  }
  
  public boolean setProperty(String paramString, Object paramObject)
  {
    String str = ViolaUtils.getString(paramObject, null);
    if (str != null)
    {
      int i = -1;
      switch (paramString.hashCode())
      {
      default: 
        break;
      case 713848971: 
        if (paramString.equals("paddingRight")) {
          i = 2;
        }
        break;
      case 365601008: 
        if (paramString.equals("fontSize")) {
          i = 4;
        }
        break;
      case 94842723: 
        if (paramString.equals("color")) {
          i = 3;
        }
        break;
      case -1501175880: 
        if (paramString.equals("paddingLeft")) {
          i = 1;
        }
        break;
      case -1576785488: 
        if (paramString.equals("placeholderColor")) {
          i = 0;
        }
        break;
      }
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
                ((VInputView)getHostView()).setTextSize(0, FlexConvertUtils.converPxByViewportToRealPx(str, 750));
                return true;
              }
            }
            else
            {
              ((VInputView)getHostView()).setTextColor(ColorParseUtils.parseColor(str));
              return true;
            }
          }
          else
          {
            this.mPaddingList[2] = ((int)FlexConvertUtils.converPxByViewportToRealPx(str, 750));
            paramString = (VInputView)getHostView();
            paramObject = this.mPaddingList;
            paramString.setPadding(paramObject[0], paramObject[1], paramObject[2], paramObject[3]);
            return true;
          }
        }
        else
        {
          this.mPaddingList[0] = ((int)FlexConvertUtils.converPxByViewportToRealPx(str, 750));
          paramString = (VInputView)getHostView();
          paramObject = this.mPaddingList;
          paramString.setPadding(paramObject[0], paramObject[1], paramObject[2], paramObject[3]);
          return true;
        }
      }
      else
      {
        this.mHintTextColor = ColorParseUtils.parseColor(str);
        ((VInputView)getHostView()).setHintTextColor(this.mHintTextColor);
        return true;
      }
    }
    return super.setProperty(paramString, paramObject);
  }
  
  @VComponentProp(initToHostView=true, name="returnKeyType", nativeReturnMethod="getImeOptions")
  public void setReturnKeyType(String paramString)
  {
    if ("next".equals(paramString))
    {
      ((VInputView)getHostView()).setImeOptions(5);
      return;
    }
    if ("go".equals(paramString))
    {
      ((VInputView)getHostView()).setImeOptions(2);
      return;
    }
    if ("search".equals(paramString))
    {
      ((VInputView)getHostView()).setImeOptions(3);
      return;
    }
    if ("send".equals(paramString))
    {
      ((VInputView)getHostView()).setImeOptions(4);
      return;
    }
    if ("done".equals(paramString)) {
      ((VInputView)getHostView()).setImeOptions(6);
    }
  }
  
  @JSMethod(uiThread=true)
  public void setText(String paramString)
  {
    setValue(paramString);
  }
  
  @VComponentProp(initToHostView=true, name="type", nativeReturnMethod="getInputType")
  public void setType(String paramString)
  {
    if ("text".equals(paramString)) {
      ((VInputView)getHostView()).setInputType(1);
    } else if ("password".equals(paramString)) {
      ((VInputView)getHostView()).setInputType(128);
    } else if ("number".equals(paramString)) {
      ((VInputView)getHostView()).setInputType(2);
    }
    trySetMulLine();
  }
  
  @VComponentProp(initToHostView=true, name="value", nativeReturnMethod="getText")
  public void setValue(String paramString)
  {
    if (!this.mCurrentMessage.equals(paramString))
    {
      ((VInputView)getHostView()).setText(paramString);
      ((VInputView)getHostView()).setSelection(((VInputView)getHostView()).getText().length());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.component.VInput
 * JD-Core Version:    0.7.0.1
 */