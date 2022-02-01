package com.tencent.mobileqq.vas.troopnick;

import android.graphics.Typeface;
import android.widget.TextView;
import com.etrump.mixlayout.FontInfo;
import com.etrump.mixlayout.FontManagerForTool;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.util.AppUtil;
import com.tencent.mobileqq.vas.VasResEngine.VasRes;
import com.tencent.mobileqq.vas.VasResEngine.VasResController;
import com.tencent.mobileqq.vas.adapter.SignatureFontAdapter;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public class TroopNickFontAdapter
  extends SignatureFontAdapter
{
  public static Map<String, Typeface> f = new HashMap();
  private static int g = 0;
  WeakReference<TextView> e;
  
  public TroopNickFontAdapter(TextView paramTextView, VasRes paramVasRes, AppRuntime paramAppRuntime, int paramInt)
  {
    super(paramVasRes, paramAppRuntime, paramInt);
    this.e = new WeakReference(paramTextView);
  }
  
  private boolean a(Typeface paramTypeface)
  {
    if (paramTypeface == null) {
      return false;
    }
    TextView localTextView = (TextView)this.e.get();
    if (localTextView == null) {
      return true;
    }
    localTextView.post(new TroopNickFontAdapter.2(this, localTextView, paramTypeface));
    return true;
  }
  
  public static Typeface c(int paramInt1, int paramInt2)
  {
    return (Typeface)f.get(e(paramInt1, paramInt2));
  }
  
  public static String e(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt2);
    return localStringBuilder.toString();
  }
  
  public void a()
  {
    Object localObject;
    if (AppUtil.a()) {
      localObject = b(this.a.b(), this.b);
    } else {
      localObject = FontManagerForTool.a().a(this.a.b(), this.b);
    }
    if (localObject != null)
    {
      d(((FontInfo)localObject).a, ((FontInfo)localObject).c);
      b();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("troop_nick_font_load,");
        ((StringBuilder)localObject).append(g);
        QLog.d("TroopNickFontAdapter", 1, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  protected void d(int paramInt1, int paramInt2)
  {
    ThreadManagerV2.executeOnFileThread(new TroopNickFontAdapter.1(this, paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopnick.TroopNickFontAdapter
 * JD-Core Version:    0.7.0.1
 */