package com.tencent.mobileqq.colornote.settings;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import cooperation.qqreader.QRBridgeActivity;

public class HeaderClickHandlerReader
  implements IOnHeaderClickHandler
{
  public String a()
  {
    return HardCodeUtil.a(2131716902);
  }
  
  public void a(View paramView, int paramInt)
  {
    if (paramView == null) {}
    Context localContext;
    do
    {
      do
      {
        return;
      } while (paramInt != 16908289);
      localContext = paramView.getContext();
    } while (localContext == null);
    paramView = new Intent(paramView.getContext(), QRBridgeActivity.class);
    paramView.putExtra("readtype", "18");
    paramView.addFlags(268435456);
    localContext.startActivity(paramView);
    ReportController.b(null, "dc00898", "", "", "0X800AA81", "0X800AA81", 3, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.settings.HeaderClickHandlerReader
 * JD-Core Version:    0.7.0.1
 */