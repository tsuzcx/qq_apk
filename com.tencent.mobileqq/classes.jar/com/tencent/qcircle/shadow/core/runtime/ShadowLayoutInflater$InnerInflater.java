package com.tencent.qcircle.shadow.core.runtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.qcircle.shadow.core.runtime.skin.entity.SkinItem;
import java.util.HashMap;

class ShadowLayoutInflater$InnerInflater
  extends ShadowLayoutInflater
{
  private ShadowLayoutInflater$InnerInflater(LayoutInflater paramLayoutInflater, Context paramContext, String paramString, HashMap<View, SkinItem> paramHashMap)
  {
    super(paramLayoutInflater, paramContext, paramString, null);
    setFactory2(new ShadowFactory2(paramString, this, paramHashMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qcircle.shadow.core.runtime.ShadowLayoutInflater.InnerInflater
 * JD-Core Version:    0.7.0.1
 */