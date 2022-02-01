package com.tencent.mobileqq.vas.theme.api.impl;

import com.tencent.mobileqq.vas.adapter.ThemeFontAdapter;
import com.tencent.mobileqq.vas.theme.api.IThemeFontAdapter;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/theme/api/impl/ThemeFontAdapterImpl;", "Lcom/tencent/mobileqq/vas/theme/api/IThemeFontAdapter;", "()V", "switchFont", "", "fontId", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ThemeFontAdapterImpl
  implements IThemeFontAdapter
{
  public void switchFont(int paramInt)
  {
    ThemeFontAdapter.b(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.api.impl.ThemeFontAdapterImpl
 * JD-Core Version:    0.7.0.1
 */