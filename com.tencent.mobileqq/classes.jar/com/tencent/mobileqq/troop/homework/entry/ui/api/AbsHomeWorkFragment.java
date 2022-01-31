package com.tencent.mobileqq.troop.homework.entry.ui.api;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import org.json.JSONObject;

public abstract class AbsHomeWorkFragment
  extends IphoneTitleBarFragment
{
  public int a = -2147483648;
  
  private static void a(Activity paramActivity, Class paramClass, Intent paramIntent, int paramInt1, int paramInt2, String paramString)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.putExtra("AbsHomeWorkFragment:valid", "AbsHomeWorkFragment:valid");
    localIntent.putExtra("HomeWorkConstants:homework_default_index_key", paramInt2);
    localIntent.putExtra("HomeWorkConstants:homework_default_request_key", paramString);
    PublicFragmentActivity.a(paramActivity, localIntent, paramClass, paramInt1);
  }
  
  public static void a(Activity paramActivity, Class paramClass, Intent paramIntent, int paramInt, String paramString)
  {
    a(paramActivity, paramClass, paramIntent, 258, paramInt, paramString);
  }
  
  private void b()
  {
    Object localObject = getArguments();
    if (localObject != null)
    {
      this.a = ((Bundle)localObject).getInt("HomeWorkConstants:homework_default_index_key", -2147483648);
      if (this.a != -2147483648)
      {
        localObject = ((Bundle)localObject).getString("HomeWorkConstants:homework_default_request_key");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          a((String)localObject);
          return;
        }
      }
      a("{}");
      return;
    }
    a("{}");
  }
  
  public final View a(int paramInt)
  {
    return this.mContentView.findViewById(paramInt);
  }
  
  public final QQAppInterface a()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && ((localFragmentActivity.getAppInterface() instanceof QQAppInterface))) {
      return (QQAppInterface)localFragmentActivity.getAppInterface();
    }
    return null;
  }
  
  public final void a()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.finish();
    }
  }
  
  public abstract void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle);
  
  public abstract void a(@Nullable String paramString);
  
  public final void a(@NonNull JSONObject paramJSONObject)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("HomeWorkConstants:homework_default_result_key", paramJSONObject.toString());
    localBundle.putInt("HomeWorkConstants:homework_default_index_key", this.a);
    localIntent.putExtras(localBundle);
    getActivity().setResult(257, localIntent);
  }
  
  protected final void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    a(paramLayoutInflater, paramViewGroup, paramBundle);
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.api.AbsHomeWorkFragment
 * JD-Core Version:    0.7.0.1
 */