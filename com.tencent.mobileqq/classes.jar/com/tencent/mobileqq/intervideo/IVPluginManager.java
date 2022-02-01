package com.tencent.mobileqq.intervideo;

import android.content.Context;
import android.os.Bundle;
import com.tencent.shadow.dynamic.host.EnterCallback;
import com.tencent.shadow.dynamic.host.PluginManager;

public abstract interface IVPluginManager
  extends PluginManager
{
  public abstract void a(Context paramContext, long paramLong, Bundle paramBundle, EnterCallback paramEnterCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.IVPluginManager
 * JD-Core Version:    0.7.0.1
 */