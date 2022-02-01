package org.xwalk.core;

import android.os.ResultReceiver;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import java.util.ArrayList;

public class XWalkExtendTextAreaClient
{
  private static final String TAG = "XWalkExtendTextAreaClient";
  private Object bridge;
  private ArrayList<Object> constructorParams;
  private ArrayList<Object> constructorTypes;
  private XWalkCoreWrapper coreWrapper;
  private XWalkView mXWalkView;
  private ReflectMethod onKeyboardHeightChangedbooleanintbooleanMethod = new ReflectMethod(null, "onKeyboardHeightChanged", new Class[0]);
  private ReflectMethod postWrapperMethod;
  
  public XWalkExtendTextAreaClient(XWalkView paramXWalkView)
  {
    this.mXWalkView = paramXWalkView;
    this.constructorTypes = new ArrayList();
    this.constructorTypes.add("XWalkViewBridge");
    this.constructorParams = new ArrayList();
    this.constructorParams.add(paramXWalkView);
    reflectionInit();
  }
  
  protected Object getBridge()
  {
    return this.bridge;
  }
  
  public int getToolBarHeight(int paramInt)
  {
    return 0;
  }
  
  public XWalkView getXWalkView()
  {
    return this.mXWalkView;
  }
  
  public boolean onHideKeyboard(String paramString, InputConnection paramInputConnection)
  {
    return false;
  }
  
  public void onKeyboardHeightChanged(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onKeyboardHeightChanged isKeyboardShowing:");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(",keyboardHeight:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",usingDefaultKeyboard:");
      localStringBuilder.append(paramBoolean2);
      Log.i("XWalkExtendTextAreaClient", localStringBuilder.toString());
      this.onKeyboardHeightChangedbooleanintbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean2) });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public boolean onShowKeyboard(String paramString, InputConnection paramInputConnection, ResultReceiver paramResultReceiver)
  {
    return false;
  }
  
  public boolean onShowKeyboardConfig(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4, EditorInfo paramEditorInfo)
  {
    return false;
  }
  
  public boolean performEditorAction(int paramInt)
  {
    return true;
  }
  
  void reflectionInit()
  {
    XWalkCoreWrapper.initEmbeddedMode();
    this.coreWrapper = XWalkCoreWrapper.getInstance();
    if (this.coreWrapper == null)
    {
      XWalkCoreWrapper.reserveReflectObject(this);
      return;
    }
    int j = this.constructorTypes.size();
    Object localObject1 = new Class[j + 1];
    int i = 0;
    while (i < j)
    {
      Object localObject2 = this.constructorTypes.get(i);
      if ((localObject2 instanceof String))
      {
        localObject1[i] = this.coreWrapper.getBridgeClass((String)localObject2);
        localObject2 = this.constructorParams;
        ((ArrayList)localObject2).set(i, this.coreWrapper.getBridgeObject(((ArrayList)localObject2).get(i)));
      }
      else if ((localObject2 instanceof Class))
      {
        localObject1[i] = ((Class)localObject2);
      }
      i += 1;
    }
    localObject1[j] = Object.class;
    this.constructorParams.add(this);
    localObject1 = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkExtendTextAreaClientBridge"), (Class[])localObject1);
    try
    {
      this.bridge = ((ReflectConstructor)localObject1).newInstance(this.constructorParams.toArray());
      localObject1 = this.postWrapperMethod;
      if (localObject1 != null) {
        ((ReflectMethod)localObject1).invoke(new Object[0]);
      }
      this.onKeyboardHeightChangedbooleanintbooleanMethod.init(this.bridge, null, "onKeyboardHeightChanged", new Class[] { Boolean.TYPE, Integer.TYPE, Boolean.TYPE });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.XWalkExtendTextAreaClient
 * JD-Core Version:    0.7.0.1
 */