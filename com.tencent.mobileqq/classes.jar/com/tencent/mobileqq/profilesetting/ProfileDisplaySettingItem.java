package com.tencent.mobileqq.profilesetting;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilesetting/ProfileDisplaySettingItem;", "", "type", "", "(I)V", "titleResId", "(II)V", "fieldId", "state", "(IIII)V", "secDescResId", "(IIIII)V", "changed", "", "getChanged", "()Z", "setChanged", "(Z)V", "getFieldId", "()I", "setFieldId", "formItemBgType", "getFormItemBgType", "setFormItemBgType", "getSecDescResId", "setSecDescResId", "getState", "setState", "getTitleResId", "setTitleResId", "getType", "setType", "getBaseVisibleState", "getOtherSwitchState", "toString", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ProfileDisplaySettingItem
{
  private int a = -1;
  private int b = -1;
  private int c = -1;
  private int d = -1;
  private int e = -1;
  private boolean f;
  private int g = -1;
  
  public ProfileDisplaySettingItem(int paramInt)
  {
    this.a = paramInt;
  }
  
  public ProfileDisplaySettingItem(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.c = paramInt2;
  }
  
  public ProfileDisplaySettingItem(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt4;
    this.e = paramInt3;
  }
  
  public final int a()
  {
    return this.a;
  }
  
  public final void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public final int b()
  {
    return this.b;
  }
  
  public final void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public final int c()
  {
    return this.c;
  }
  
  public final void c(int paramInt)
  {
    this.e = paramInt;
  }
  
  public final int d()
  {
    return this.d;
  }
  
  public final void d(int paramInt)
  {
    this.g = paramInt;
  }
  
  public final int e()
  {
    return this.e;
  }
  
  public final boolean f()
  {
    return this.f;
  }
  
  public final int g()
  {
    return this.g;
  }
  
  public final boolean h()
  {
    int i = this.e;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (i != 0) {
      if (i != 1) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    bool2 = bool1;
    if (ProfileSettingUtils.a.a(this.b)) {
      bool2 = bool1 ^ true;
    }
    return bool2;
  }
  
  public final int i()
  {
    int j = this.e;
    int i = j;
    if (j != 0)
    {
      i = j;
      if (j != 1)
      {
        i = j;
        if (j != 2) {
          i = 0;
        }
      }
    }
    return i;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ProfileDisplaySettingItem(type=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", fieldId=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", titleResId=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", state=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", changed=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.ProfileDisplaySettingItem
 * JD-Core Version:    0.7.0.1
 */