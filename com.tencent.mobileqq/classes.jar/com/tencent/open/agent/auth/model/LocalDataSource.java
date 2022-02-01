package com.tencent.open.agent.auth.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.open.settings.OpensdkPreference;
import java.util.ArrayList;
import java.util.Iterator;

public class LocalDataSource
  implements ILocalDataSource
{
  private SharedPreferences a;
  private SharedPreferences b;
  private SharedPreferences c;
  
  public LocalDataSource(Context paramContext)
  {
    this.a = OpensdkPreference.a(paramContext, "accountList");
    this.b = OpensdkPreference.a(paramContext, "uin_openid_store");
    this.c = OpensdkPreference.a(paramContext, "openid_encrytoken");
  }
  
  public void a(String paramString)
  {
    SharedPreferences.Editor localEditor = this.a.edit();
    localEditor.putString("last_account", paramString);
    Object localObject2 = this.a;
    Object localObject1 = null;
    localObject2 = ((SharedPreferences)localObject2).getString("accList", null);
    if (localObject2 != null) {
      localObject1 = ((String)localObject2).split(",");
    }
    localObject2 = new ArrayList();
    if (localObject1 != null)
    {
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        CharSequence localCharSequence = localObject1[i];
        if (!TextUtils.isEmpty(localCharSequence)) {
          ((ArrayList)localObject2).add(localCharSequence);
        }
        i += 1;
      }
    }
    ((ArrayList)localObject2).remove(paramString);
    ((ArrayList)localObject2).add(paramString);
    paramString = new StringBuilder();
    localObject1 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      paramString.append(",");
      paramString.append((String)localObject2);
    }
    localEditor.putString("accList", paramString.toString());
    localEditor.commit();
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      SharedPreferences.Editor localEditor = this.c.edit();
      localEditor.putString(paramString1, paramString2);
      localEditor.commit();
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    SharedPreferences.Editor localEditor = this.b.edit();
    localEditor.putString(paramString1, paramString3);
    if (!TextUtils.isEmpty(paramString2))
    {
      if (TextUtils.isEmpty(paramString3)) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append(":");
      localStringBuilder.append(paramString3);
      localEditor.putString(localStringBuilder.toString(), paramString1);
      localEditor.commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.auth.model.LocalDataSource
 * JD-Core Version:    0.7.0.1
 */