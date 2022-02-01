package org.xwalk.core.extension;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.Bundle;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkExternalExtensionManager;
import org.xwalk.core.XWalkNativeExtensionLoader;
import org.xwalk.core.XWalkView;

public class XWalkExternalExtensionManagerImpl
  extends XWalkExternalExtensionManager
  implements XWalkExtensionContextClient
{
  private static final String TAG = "XWalkExternalExtensionManagerImpl";
  private final Context mContext;
  private final HashMap<String, XWalkExternalExtensionBridge> mExtensions = new HashMap();
  private boolean mLoadExternalExtensions;
  private final XWalkNativeExtensionLoader mNativeExtensionLoader;
  private final XWalkView mXWalkView;
  
  public XWalkExternalExtensionManagerImpl(XWalkView paramXWalkView)
  {
    super(paramXWalkView);
    this.mXWalkView = paramXWalkView;
    if (getBridge() == null)
    {
      Log.e("XWalkExternalExtensionManagerImpl", "Cannot load external extensions due to old version of runtime library");
      this.mContext = null;
      this.mLoadExternalExtensions = false;
      this.mNativeExtensionLoader = null;
      return;
    }
    this.mContext = getViewContext();
    this.mLoadExternalExtensions = true;
    this.mNativeExtensionLoader = new XWalkNativeExtensionLoader();
    loadNativeExtensions();
  }
  
  private void createExternalExtension(String paramString1, String paramString2, String paramString3, XWalkExtensionContextClient paramXWalkExtensionContextClient)
  {
    paramXWalkExtensionContextClient = paramXWalkExtensionContextClient.getContext();
    try
    {
      paramXWalkExtensionContextClient.getClassLoader().loadClass(paramString2).getConstructor(new Class[] { String.class, String.class, XWalkExtensionContextClient.class }).newInstance(new Object[] { paramString1, paramString3, this });
      return;
    }
    catch (NoSuchMethodException paramString1)
    {
      handleException(paramString1);
      return;
    }
    catch (InvocationTargetException paramString1)
    {
      handleException(paramString1);
      return;
    }
    catch (InstantiationException paramString1)
    {
      handleException(paramString1);
      return;
    }
    catch (IllegalAccessException paramString1)
    {
      handleException(paramString1);
      return;
    }
    catch (ClassNotFoundException paramString1)
    {
      handleException(paramString1);
    }
  }
  
  private String getFileContent(Context paramContext, String paramString, boolean paramBoolean)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramBoolean) {
      localObject1 = localObject3;
    }
    for (;;)
    {
      try
      {
        localObject4 = paramContext.getResources();
        localObject1 = localObject3;
        str = new File(paramString).getName().split("\\.")[0];
        localObject1 = localObject3;
        i = ((Resources)localObject4).getIdentifier(str, "raw", paramContext.getPackageName());
        localObject1 = localObject2;
        if (i > 0) {
          localObject1 = localObject3;
        }
      }
      finally
      {
        Object localObject4;
        String str;
        int i;
        continue;
      }
      try
      {
        localObject4 = ((Resources)localObject4).openRawResource(i);
        localObject1 = localObject4;
      }
      catch (Resources.NotFoundException localNotFoundException) {}
    }
    localObject1 = localObject3;
    localObject4 = new StringBuilder();
    localObject1 = localObject3;
    ((StringBuilder)localObject4).append("Inputstream failed to open for R.raw.");
    localObject1 = localObject3;
    ((StringBuilder)localObject4).append(str);
    localObject1 = localObject3;
    ((StringBuilder)localObject4).append(", try to find it in assets");
    localObject1 = localObject3;
    Log.w("XWalkExternalExtensionManagerImpl", ((StringBuilder)localObject4).toString());
    localObject1 = localObject2;
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = paramContext.getAssets().open(paramString);
    }
    localObject1 = localObject2;
    paramContext = new byte[((InputStream)localObject2).available()];
    localObject1 = localObject2;
    ((InputStream)localObject2).read(paramContext);
    localObject1 = localObject2;
    paramContext = new String(paramContext);
    if (localObject2 != null) {
      ((InputStream)localObject2).close();
    }
    return paramContext;
    if (localObject1 != null) {
      localObject1.close();
    }
    throw paramContext;
  }
  
  private static void handleException(Exception paramException)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Error in calling methods of external extensions. ");
    localStringBuilder.append(paramException.toString());
    Log.e("XWalkExternalExtensionManagerImpl", localStringBuilder.toString());
    paramException.printStackTrace();
  }
  
  private void loadNativeExtensions()
  {
    try
    {
      str = this.mContext.getPackageManager().getApplicationInfo(this.mContext.getPackageName(), 0).nativeLibraryDir;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      String str;
      label25:
      break label25;
    }
    str = null;
    if ((str != null) && (new File(str).isDirectory())) {
      this.mNativeExtensionLoader.registerNativeExtensionsInPath(str);
    }
  }
  
  public void broadcastMessage(XWalkExternalExtension paramXWalkExternalExtension, String paramString)
  {
    paramXWalkExternalExtension = (XWalkExternalExtensionBridge)this.mExtensions.get(paramXWalkExternalExtension.getExtensionName());
    if (paramXWalkExternalExtension != null) {
      paramXWalkExternalExtension.broadcastMessage(paramString);
    }
  }
  
  public Activity getActivity()
  {
    Context localContext = this.mContext;
    if ((localContext instanceof Activity)) {
      return (Activity)localContext;
    }
    return null;
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public void loadExtension(String paramString)
  {
    if (!this.mLoadExternalExtensions) {
      return;
    }
    int i = paramString.length() - 1;
    Object localObject1 = paramString;
    if (paramString.charAt(i) == File.separatorChar) {
      localObject1 = paramString.substring(0, i);
    }
    paramString = ((String)localObject1).substring(((String)localObject1).lastIndexOf(File.separatorChar) + 1);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(File.separator);
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(".json");
    String str1 = ((StringBuilder)localObject2).toString();
    label334:
    try
    {
      paramString = getFileContent(this.mContext, str1, false);
    }
    catch (IOException paramString)
    {
      String str2;
      String str3;
      label234:
      label367:
      break label367;
    }
    try
    {
      paramString = new JSONObject(paramString);
      str2 = paramString.getString("name");
      str3 = paramString.getString("class");
      localObject2 = paramString.optString("jsapi");
      paramString = (String)localObject2;
      if (localObject2 != null)
      {
        paramString = (String)localObject2;
        if (((String)localObject2).length() != 0)
        {
          paramString = new StringBuilder();
          paramString.append((String)localObject1);
          paramString.append(File.separator);
          paramString.append((String)localObject2);
          paramString = paramString.toString();
        }
      }
      localObject2 = null;
      localObject1 = localObject2;
      if (paramString != null)
      {
        i = paramString.length();
        localObject1 = localObject2;
        if (i == 0) {}
      }
    }
    catch (JSONException paramString)
    {
      break label334;
    }
    try
    {
      localObject1 = getFileContent(this.mContext, paramString, false);
    }
    catch (IOException localIOException)
    {
      break label234;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Failed to read the file ");
    ((StringBuilder)localObject1).append(paramString);
    Log.w("XWalkExternalExtensionManagerImpl", ((StringBuilder)localObject1).toString());
    return;
    if ((str2 != null) && (str3 != null))
    {
      paramString = new StringBuilder();
      paramString.append("createExternalExtension: name: ");
      paramString.append(str2);
      paramString.append(" className: ");
      paramString.append(str3);
      Log.i("XWalkExternalExtensionManagerImpl", paramString.toString());
      createExternalExtension(str2, str3, (String)localObject1, this);
      return;
      paramString = new StringBuilder();
      paramString.append("Failed to parse json file: ");
      paramString.append(str1);
      Log.w("XWalkExternalExtensionManagerImpl", paramString.toString());
    }
    return;
    paramString = new StringBuilder();
    paramString.append("Failed to read json file: ");
    paramString.append(str1);
    Log.w("XWalkExternalExtensionManagerImpl", paramString.toString());
  }
  
  public void onDestroy()
  {
    Iterator localIterator = this.mExtensions.values().iterator();
    while (localIterator.hasNext()) {
      ((XWalkExternalExtensionBridge)localIterator.next()).onDestroy();
    }
    this.mExtensions.clear();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    Iterator localIterator = this.mExtensions.values().iterator();
    while (localIterator.hasNext()) {
      ((XWalkExternalExtensionBridge)localIterator.next()).onNewIntent(paramIntent);
    }
  }
  
  public void onPause()
  {
    Iterator localIterator = this.mExtensions.values().iterator();
    while (localIterator.hasNext()) {
      ((XWalkExternalExtensionBridge)localIterator.next()).onPause();
    }
  }
  
  public void onResume()
  {
    Iterator localIterator = this.mExtensions.values().iterator();
    while (localIterator.hasNext()) {
      ((XWalkExternalExtensionBridge)localIterator.next()).onResume();
    }
  }
  
  public void onStart()
  {
    Iterator localIterator = this.mExtensions.values().iterator();
    while (localIterator.hasNext()) {
      ((XWalkExternalExtensionBridge)localIterator.next()).onStart();
    }
  }
  
  public void onStop()
  {
    Iterator localIterator = this.mExtensions.values().iterator();
    while (localIterator.hasNext()) {
      ((XWalkExternalExtensionBridge)localIterator.next()).onStop();
    }
  }
  
  public void postBinaryMessage(XWalkExternalExtension paramXWalkExternalExtension, int paramInt, byte[] paramArrayOfByte)
  {
    paramXWalkExternalExtension = (XWalkExternalExtensionBridge)this.mExtensions.get(paramXWalkExternalExtension.getExtensionName());
    if (paramXWalkExternalExtension != null) {
      paramXWalkExternalExtension.postBinaryMessage(paramInt, paramArrayOfByte);
    }
  }
  
  public void postMessage(XWalkExternalExtension paramXWalkExternalExtension, int paramInt, String paramString)
  {
    paramXWalkExternalExtension = (XWalkExternalExtensionBridge)this.mExtensions.get(paramXWalkExternalExtension.getExtensionName());
    if (paramXWalkExternalExtension != null) {
      paramXWalkExternalExtension.postMessage(paramInt, paramString);
    }
  }
  
  public void registerExtension(XWalkExternalExtension paramXWalkExternalExtension)
  {
    if (this.mExtensions.get(paramXWalkExternalExtension.getExtensionName()) != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramXWalkExternalExtension.getExtensionName());
      ((StringBuilder)localObject).append("is already registered!");
      Log.e("XWalkExternalExtensionManagerImpl", ((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = XWalkExternalExtensionBridgeFactory.createInstance(paramXWalkExternalExtension);
    this.mExtensions.put(paramXWalkExternalExtension.getExtensionName(), localObject);
  }
  
  public void setAllowExternalExtensions(boolean paramBoolean)
  {
    this.mLoadExternalExtensions = paramBoolean;
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    throw new ActivityNotFoundException("This method is no longer supported");
  }
  
  public void unregisterExtension(String paramString)
  {
    XWalkExternalExtensionBridge localXWalkExternalExtensionBridge = (XWalkExternalExtensionBridge)this.mExtensions.get(paramString);
    if (localXWalkExternalExtensionBridge != null)
    {
      this.mExtensions.remove(paramString);
      localXWalkExternalExtensionBridge.onDestroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.extension.XWalkExternalExtensionManagerImpl
 * JD-Core Version:    0.7.0.1
 */