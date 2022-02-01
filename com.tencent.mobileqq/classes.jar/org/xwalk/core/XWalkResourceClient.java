package org.xwalk.core;

import android.net.http.SslError;
import android.webkit.ValueCallback;
import android.webkit.WebResourceResponse;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

public class XWalkResourceClient
{
  public static final int ERROR_AUTHENTICATION = -4;
  public static final int ERROR_BAD_URL = -12;
  public static final int ERROR_CONNECT = -6;
  public static final int ERROR_FAILED_SSL_HANDSHAKE = -11;
  public static final int ERROR_FILE = -13;
  public static final int ERROR_FILE_NOT_FOUND = -14;
  public static final int ERROR_HOST_LOOKUP = -2;
  public static final int ERROR_IO = -7;
  public static final int ERROR_OK = 0;
  public static final int ERROR_PROXY_AUTHENTICATION = -5;
  public static final int ERROR_REDIRECT_LOOP = -9;
  public static final int ERROR_TIMEOUT = -8;
  public static final int ERROR_TOO_MANY_REQUESTS = -15;
  public static final int ERROR_UNKNOWN = -1;
  public static final int ERROR_UNSUPPORTED_AUTH_SCHEME = -3;
  public static final int ERROR_UNSUPPORTED_SCHEME = -10;
  private Object bridge;
  private ArrayList<Object> constructorParams;
  private ArrayList<Object> constructorTypes = new ArrayList();
  private XWalkCoreWrapper coreWrapper;
  private LazyReflectMethod createXWalkWebResourceResponseStringStringInputStreamMethod = new LazyReflectMethod(null, "createXWalkWebResourceResponse", new Class[0]);
  private LazyReflectMethod createXWalkWebResourceResponseStringStringInputStreamintStringMapMethod = new LazyReflectMethod(null, "createXWalkWebResourceResponse", new Class[0]);
  private LazyReflectMethod doUpdateVisitedHistoryXWalkViewInternalStringbooleanMethod = new LazyReflectMethod(null, "doUpdateVisitedHistory", new Class[0]);
  private LazyReflectMethod onDocumentLoadedInFrameXWalkViewInternallongMethod = new LazyReflectMethod(null, "onDocumentLoadedInFrame", new Class[0]);
  private LazyReflectMethod onLoadFinishedXWalkViewInternalStringMethod = new LazyReflectMethod(null, "onLoadFinished", new Class[0]);
  private LazyReflectMethod onLoadStartedXWalkViewInternalStringMethod = new LazyReflectMethod(null, "onLoadStarted", new Class[0]);
  private LazyReflectMethod onProgressChangedXWalkViewInternalintMethod = new LazyReflectMethod(null, "onProgressChanged", new Class[0]);
  private LazyReflectMethod onReceivedClientCertRequestXWalkViewInternalClientCertRequestInternalMethod = new LazyReflectMethod(null, "onReceivedClientCertRequest", new Class[0]);
  private LazyReflectMethod onReceivedHttpAuthRequestXWalkViewInternalXWalkHttpAuthHandlerInternalStringStringMethod = new LazyReflectMethod(null, "onReceivedHttpAuthRequest", new Class[0]);
  private LazyReflectMethod onReceivedLoadErrorXWalkViewInternalintStringStringMethod = new LazyReflectMethod(null, "onReceivedLoadError", new Class[0]);
  private LazyReflectMethod onReceivedResponseHeadersXWalkViewInternalXWalkWebResourceRequestInternalXWalkWebResourceResponseInternalMethod = new LazyReflectMethod(null, "onReceivedResponseHeaders", new Class[0]);
  private LazyReflectMethod onReceivedSslErrorXWalkViewInternalValueCallbackSslErrorMethod = new LazyReflectMethod(null, "onReceivedSslError", new Class[0]);
  private LazyReflectMethod postWrapperMethod;
  private LazyReflectMethod shouldInterceptLoadRequestXWalkViewInternalStringMethod = new LazyReflectMethod(null, "shouldInterceptLoadRequest", new Class[0]);
  private LazyReflectMethod shouldInterceptLoadRequestXWalkViewInternalXWalkWebResourceRequestInternalMethod = new LazyReflectMethod(null, "shouldInterceptLoadRequest", new Class[0]);
  private LazyReflectMethod shouldOverrideUrlLoadingXWalkViewInternalStringMethod = new LazyReflectMethod(null, "shouldOverrideUrlLoading", new Class[0]);
  
  public XWalkResourceClient(XWalkView paramXWalkView)
  {
    this.constructorTypes.add("XWalkViewBridge");
    this.constructorParams = new ArrayList();
    this.constructorParams.add(paramXWalkView);
    reflectionInit();
  }
  
  public XWalkWebResourceResponse createXWalkWebResourceResponse(String paramString1, String paramString2, InputStream paramInputStream)
  {
    try
    {
      paramString1 = (XWalkWebResourceResponse)this.coreWrapper.getWrapperObject(this.createXWalkWebResourceResponseStringStringInputStreamMethod.invoke(new Object[] { paramString1, paramString2, paramInputStream }));
      return paramString1;
    }
    catch (UnsupportedOperationException paramString1)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramString1);
        return null;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public XWalkWebResourceResponse createXWalkWebResourceResponse(String paramString1, String paramString2, InputStream paramInputStream, int paramInt, String paramString3, Map<String, String> paramMap)
  {
    try
    {
      paramString1 = (XWalkWebResourceResponse)this.coreWrapper.getWrapperObject(this.createXWalkWebResourceResponseStringStringInputStreamintStringMapMethod.invoke(new Object[] { paramString1, paramString2, paramInputStream, Integer.valueOf(paramInt), paramString3, paramMap }));
      return paramString1;
    }
    catch (UnsupportedOperationException paramString1)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramString1);
        return null;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void doUpdateVisitedHistory(XWalkView paramXWalkView, String paramString, boolean paramBoolean)
  {
    try
    {
      this.doUpdateVisitedHistoryXWalkViewInternalStringbooleanMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramString, Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  protected Object getBridge()
  {
    return this.bridge;
  }
  
  public void onDocumentLoadedInFrame(XWalkView paramXWalkView, long paramLong)
  {
    try
    {
      this.onDocumentLoadedInFrameXWalkViewInternallongMethod.invoke(new Object[] { paramXWalkView.getBridge(), Long.valueOf(paramLong) });
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void onLoadFinished(XWalkView paramXWalkView, String paramString)
  {
    try
    {
      this.onLoadFinishedXWalkViewInternalStringMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramString });
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void onLoadStarted(XWalkView paramXWalkView, String paramString)
  {
    try
    {
      this.onLoadStartedXWalkViewInternalStringMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramString });
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void onProgressChanged(XWalkView paramXWalkView, int paramInt)
  {
    try
    {
      this.onProgressChangedXWalkViewInternalintMethod.invoke(new Object[] { paramXWalkView.getBridge(), Integer.valueOf(paramInt) });
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void onReceivedClientCertRequest(XWalkView paramXWalkView, ClientCertRequest paramClientCertRequest)
  {
    try
    {
      this.onReceivedClientCertRequestXWalkViewInternalClientCertRequestInternalMethod.invoke(new Object[] { paramXWalkView.getBridge(), ((ClientCertRequestHandler)paramClientCertRequest).getBridge() });
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void onReceivedHttpAuthRequest(XWalkView paramXWalkView, XWalkHttpAuthHandler paramXWalkHttpAuthHandler, String paramString1, String paramString2)
  {
    try
    {
      this.onReceivedHttpAuthRequestXWalkViewInternalXWalkHttpAuthHandlerInternalStringStringMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramXWalkHttpAuthHandler.getBridge(), paramString1, paramString2 });
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void onReceivedHttpError(XWalkView paramXWalkView, XWalkWebResourceRequest paramXWalkWebResourceRequest, XWalkWebResourceResponse paramXWalkWebResourceResponse) {}
  
  public void onReceivedLoadError(XWalkView paramXWalkView, int paramInt, String paramString1, String paramString2)
  {
    try
    {
      this.onReceivedLoadErrorXWalkViewInternalintStringStringMethod.invoke(new Object[] { paramXWalkView.getBridge(), Integer.valueOf(paramInt), paramString1, paramString2 });
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void onReceivedResponseHeaders(XWalkView paramXWalkView, XWalkWebResourceRequest paramXWalkWebResourceRequest, XWalkWebResourceResponse paramXWalkWebResourceResponse)
  {
    try
    {
      this.onReceivedResponseHeadersXWalkViewInternalXWalkWebResourceRequestInternalXWalkWebResourceResponseInternalMethod.invoke(new Object[] { paramXWalkView.getBridge(), ((XWalkWebResourceRequestHandler)paramXWalkWebResourceRequest).getBridge(), paramXWalkWebResourceResponse.getBridge() });
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void onReceivedSslError(XWalkView paramXWalkView, ValueCallback<Boolean> paramValueCallback, SslError paramSslError)
  {
    try
    {
      this.onReceivedSslErrorXWalkViewInternalValueCallbackSslErrorMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramValueCallback, paramSslError });
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
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
    localObject1 = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkResourceClientBridge"), (Class[])localObject1);
    try
    {
      this.bridge = ((ReflectConstructor)localObject1).newInstance(this.constructorParams.toArray());
      localObject1 = this.postWrapperMethod;
      if (localObject1 != null) {
        ((LazyReflectMethod)localObject1).invoke(new Object[0]);
      }
      this.onDocumentLoadedInFrameXWalkViewInternallongMethod.init(this.bridge, null, "onDocumentLoadedInFrameSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), Long.TYPE });
      this.onLoadStartedXWalkViewInternalStringMethod.init(this.bridge, null, "onLoadStartedSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class });
      this.onLoadFinishedXWalkViewInternalStringMethod.init(this.bridge, null, "onLoadFinishedSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class });
      this.onProgressChangedXWalkViewInternalintMethod.init(this.bridge, null, "onProgressChangedSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), Integer.TYPE });
      this.shouldInterceptLoadRequestXWalkViewInternalStringMethod.init(this.bridge, null, "shouldInterceptLoadRequestSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class });
      this.shouldInterceptLoadRequestXWalkViewInternalXWalkWebResourceRequestInternalMethod.init(this.bridge, null, "shouldInterceptLoadRequestSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), this.coreWrapper.getBridgeClass("XWalkWebResourceRequestHandlerBridge") });
      this.onReceivedLoadErrorXWalkViewInternalintStringStringMethod.init(this.bridge, null, "onReceivedLoadErrorSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), Integer.TYPE, String.class, String.class });
      this.shouldOverrideUrlLoadingXWalkViewInternalStringMethod.init(this.bridge, null, "shouldOverrideUrlLoadingSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class });
      this.onReceivedSslErrorXWalkViewInternalValueCallbackSslErrorMethod.init(this.bridge, null, "onReceivedSslErrorSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), ValueCallback.class, SslError.class });
      this.onReceivedClientCertRequestXWalkViewInternalClientCertRequestInternalMethod.init(this.bridge, null, "onReceivedClientCertRequestSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), this.coreWrapper.getBridgeClass("ClientCertRequestHandlerBridge") });
      this.onReceivedResponseHeadersXWalkViewInternalXWalkWebResourceRequestInternalXWalkWebResourceResponseInternalMethod.init(this.bridge, null, "onReceivedResponseHeadersSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), this.coreWrapper.getBridgeClass("XWalkWebResourceRequestHandlerBridge"), this.coreWrapper.getBridgeClass("XWalkWebResourceResponseBridge") });
      this.doUpdateVisitedHistoryXWalkViewInternalStringbooleanMethod.init(this.bridge, null, "doUpdateVisitedHistorySuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class, Boolean.TYPE });
      this.onReceivedHttpAuthRequestXWalkViewInternalXWalkHttpAuthHandlerInternalStringStringMethod.init(this.bridge, null, "onReceivedHttpAuthRequestSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), this.coreWrapper.getBridgeClass("XWalkHttpAuthHandlerBridge"), String.class, String.class });
      this.createXWalkWebResourceResponseStringStringInputStreamMethod.init(this.bridge, null, "createXWalkWebResourceResponseSuper", new Class[] { String.class, String.class, InputStream.class });
      this.createXWalkWebResourceResponseStringStringInputStreamintStringMapMethod.init(this.bridge, null, "createXWalkWebResourceResponseSuper", new Class[] { String.class, String.class, InputStream.class, Integer.TYPE, String.class, Map.class });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException) {}
  }
  
  public WebResourceResponse shouldInterceptLoadRequest(XWalkView paramXWalkView, String paramString)
  {
    try
    {
      paramXWalkView = (WebResourceResponse)this.shouldInterceptLoadRequestXWalkViewInternalStringMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramString });
      return paramXWalkView;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
        return null;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public XWalkWebResourceResponse shouldInterceptLoadRequest(XWalkView paramXWalkView, XWalkWebResourceRequest paramXWalkWebResourceRequest)
  {
    try
    {
      paramXWalkView = (XWalkWebResourceResponse)this.coreWrapper.getWrapperObject(this.shouldInterceptLoadRequestXWalkViewInternalXWalkWebResourceRequestInternalMethod.invoke(new Object[] { paramXWalkView.getBridge(), ((XWalkWebResourceRequestHandler)paramXWalkWebResourceRequest).getBridge() }));
      return paramXWalkView;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
        return null;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public boolean shouldOverrideUrlLoading(XWalkView paramXWalkView, String paramString)
  {
    try
    {
      boolean bool = ((Boolean)this.shouldOverrideUrlLoadingXWalkViewInternalStringMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramString })).booleanValue();
      return bool;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
        return false;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public boolean shouldOverrideUrlLoading(XWalkView paramXWalkView, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.XWalkResourceClient
 * JD-Core Version:    0.7.0.1
 */