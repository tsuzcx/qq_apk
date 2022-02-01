package com.tencent.mobileqq.debug;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/debug/QShadowDebugSettingFragment$onViewCreated$2", "Landroid/widget/AdapterView$OnItemSelectedListener;", "onItemSelected", "", "parent", "Landroid/widget/AdapterView;", "view", "Landroid/view/View;", "position", "", "id", "", "onNothingSelected", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class QShadowDebugSettingFragment$onViewCreated$2
  implements AdapterView.OnItemSelectedListener
{
  public void onItemSelected(@Nullable AdapterView<?> paramAdapterView, @Nullable View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.a;
    QShadowDebugSettingFragment.a(paramAdapterView, ((Number)((Pair)QShadowDebugSettingFragment.a(paramAdapterView).get(paramInt)).getSecond()).intValue());
  }
  
  public void onNothingSelected(@Nullable AdapterView<?> paramAdapterView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.debug.QShadowDebugSettingFragment.onViewCreated.2
 * JD-Core Version:    0.7.0.1
 */