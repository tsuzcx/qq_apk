package com.tencent.qcircle.shadow.core.runtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.qcircle.shadow.core.runtime.skin.entity.SkinItem;
import java.util.HashMap;

public class ShadowLayoutInflater
  extends ShadowWebViewLayoutInflater
{
  private ShadowLayoutInflater(LayoutInflater paramLayoutInflater, Context paramContext, String paramString)
  {
    super(paramLayoutInflater, paramContext);
  }
  
  public static ShadowLayoutInflater build(LayoutInflater paramLayoutInflater, Context paramContext, String paramString)
  {
    return build(paramLayoutInflater, paramContext, paramString, null);
  }
  
  public static ShadowLayoutInflater build(LayoutInflater paramLayoutInflater, Context paramContext, String paramString, HashMap<View, SkinItem> paramHashMap)
  {
    return new ShadowLayoutInflater(new ShadowLayoutInflater.InnerInflater(paramLayoutInflater, paramContext, paramString, paramHashMap, null), paramContext, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qcircle.shadow.core.runtime.ShadowLayoutInflater
 * JD-Core Version:    0.7.0.1
 */