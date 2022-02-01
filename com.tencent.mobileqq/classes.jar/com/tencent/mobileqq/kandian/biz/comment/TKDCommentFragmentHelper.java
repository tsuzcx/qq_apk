package com.tencent.mobileqq.kandian.biz.comment;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.hippy.qq.utils.HippyCommonUtils;
import com.tencent.qphone.base.util.QLog;

public class TKDCommentFragmentHelper
{
  private static AladdinConfig a;
  
  @Nullable
  public static TKDCommentFragment a(int paramInt, FragmentManager paramFragmentManager)
  {
    if (paramFragmentManager != null) {
      return a(paramInt, "https://viola.qq.com/js/TKDComment.js?_rij_violaUrl=1&v_tid=6&v_bundleName=TKDComment&hideNav=1&statusColor=1&v_nav_immer=1&v_bid=3740&framework=react", paramFragmentManager);
    }
    return null;
  }
  
  @Nullable
  public static TKDCommentFragment a(int paramInt, String paramString, FragmentManager paramFragmentManager)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[nestHippyFragment]hippyUrl: ");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(" fragmentManager: ");
    ((StringBuilder)localObject1).append(paramFragmentManager);
    QLog.d("HippyNestHelper", 1, ((StringBuilder)localObject1).toString());
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject3 = null;
    Object localObject2 = null;
    localObject1 = localObject3;
    if (!bool)
    {
      localObject1 = localObject3;
      if (paramFragmentManager != null)
      {
        localObject1 = localObject2;
        try
        {
          paramString = TKDCommentFragment.a(paramString, null, true);
          localObject1 = paramString;
          paramFragmentManager = paramFragmentManager.beginTransaction();
          localObject1 = paramString;
          paramFragmentManager.replace(paramInt, paramString);
          localObject1 = paramString;
          paramFragmentManager.commit();
          return paramString;
        }
        catch (Error paramString)
        {
          QLog.e("HippyNestHelper", 1, paramString.getMessage());
        }
      }
    }
    return localObject1;
  }
  
  public static void a()
  {
    try
    {
      a = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean b()
  {
    try
    {
      if (a == null) {
        a = Aladdin.get(383);
      }
      int i = HippyCommonUtils.getModuleOnlineConfig("TKDComment");
      Object localObject1 = a;
      boolean bool2 = false;
      int j = ((AladdinConfig)localObject1).getIntegerFromString("comment_hippy_switch", 0);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Hippy: hippySwitch=");
      ((StringBuilder)localObject1).append(j);
      ((StringBuilder)localObject1).append(", hippyOnlineConfig=");
      ((StringBuilder)localObject1).append(i);
      QLog.d("HippyNestHelper", 1, ((StringBuilder)localObject1).toString());
      boolean bool1 = bool2;
      if (i == 1)
      {
        bool1 = bool2;
        if (j == 1) {
          bool1 = true;
        }
      }
      return bool1;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.TKDCommentFragmentHelper
 * JD-Core Version:    0.7.0.1
 */