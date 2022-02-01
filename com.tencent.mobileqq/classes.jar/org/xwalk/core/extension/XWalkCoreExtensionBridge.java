package org.xwalk.core.extension;

import android.content.Intent;
import org.xwalk.core.XWalkExtension;

class XWalkCoreExtensionBridge
  extends XWalkExtension
  implements XWalkExternalExtensionBridge
{
  private XWalkExternalExtension mExtension;
  
  public XWalkCoreExtensionBridge(XWalkExternalExtension paramXWalkExternalExtension)
  {
    super(paramXWalkExternalExtension.getExtensionName(), paramXWalkExternalExtension.getJsApi(), paramXWalkExternalExtension.getEntryPoints());
    this.mExtension = paramXWalkExternalExtension;
  }
  
  public void broadcastMessage(String paramString)
  {
    super.broadcastMessage(paramString);
  }
  
  public void onBinaryMessage(int paramInt, byte[] paramArrayOfByte)
  {
    this.mExtension.onBinaryMessage(paramInt, paramArrayOfByte);
  }
  
  public void onDestroy()
  {
    this.mExtension.onDestroy();
  }
  
  public void onInstanceCreated(int paramInt)
  {
    this.mExtension.onInstanceCreated(paramInt);
  }
  
  public void onInstanceDestroyed(int paramInt)
  {
    this.mExtension.onInstanceDestroyed(paramInt);
  }
  
  public void onMessage(int paramInt, String paramString)
  {
    this.mExtension.onMessage(paramInt, paramString);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    this.mExtension.onNewIntent(paramIntent);
  }
  
  public void onPause()
  {
    this.mExtension.onPause();
  }
  
  public void onResume()
  {
    this.mExtension.onResume();
  }
  
  public void onStart()
  {
    this.mExtension.onStart();
  }
  
  public void onStop()
  {
    this.mExtension.onStop();
  }
  
  public String onSyncMessage(int paramInt, String paramString)
  {
    return this.mExtension.onSyncMessage(paramInt, paramString);
  }
  
  public void postBinaryMessage(int paramInt, byte[] paramArrayOfByte)
  {
    super.postBinaryMessage(paramInt, paramArrayOfByte);
  }
  
  public void postMessage(int paramInt, String paramString)
  {
    super.postMessage(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.extension.XWalkCoreExtensionBridge
 * JD-Core Version:    0.7.0.1
 */