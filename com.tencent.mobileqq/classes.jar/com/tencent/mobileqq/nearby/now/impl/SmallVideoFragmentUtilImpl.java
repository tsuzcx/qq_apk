package com.tencent.mobileqq.nearby.now.impl;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.nearby.now.ISmallVideoFragmentUtil;
import com.tencent.mobileqq.nearby.now.SmallVideoFragment;

public class SmallVideoFragmentUtilImpl
  implements ISmallVideoFragmentUtil
{
  public void launch(Context paramContext, Bundle paramBundle)
  {
    SmallVideoFragment.a(paramContext, paramBundle);
  }
  
  public void launch(Context paramContext, String paramString)
  {
    SmallVideoFragment.a(paramContext, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.impl.SmallVideoFragmentUtilImpl
 * JD-Core Version:    0.7.0.1
 */