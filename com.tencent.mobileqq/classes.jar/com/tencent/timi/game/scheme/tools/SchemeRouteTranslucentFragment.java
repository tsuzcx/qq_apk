package com.tencent.timi.game.scheme.tools;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.timi.game.utils.Logger;

public class SchemeRouteTranslucentFragment
  extends QPublicBaseFragment
{
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Object localObject = getActivity().getIntent();
    paramBundle = ((Intent)localObject).getStringExtra("schemestring");
    localObject = ((Intent)localObject).getStringExtra("src_biz");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCreate - ");
    localStringBuilder.append(paramBundle);
    Logger.a("wjySchemeRouteTranslucentFragment", localStringBuilder.toString());
    SchemeUtil.a(getActivity(), paramBundle, (String)localObject, true);
    getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.scheme.tools.SchemeRouteTranslucentFragment
 * JD-Core Version:    0.7.0.1
 */