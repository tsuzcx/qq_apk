package com.tencent.shadow.core.runtime.remoteview;

import android.content.Context;
import com.tencent.shadow.core.runtime.ShadowContext;

public class ShadowRemoteViewCreatorFactory
{
  public static ShadowRemoteViewCreator createRemoteViewCreator(Context paramContext)
  {
    return ((ShadowContext)paramContext).getRemoteViewCreatorProvider().createRemoteViewCreator(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.shadow.core.runtime.remoteview.ShadowRemoteViewCreatorFactory
 * JD-Core Version:    0.7.0.1
 */