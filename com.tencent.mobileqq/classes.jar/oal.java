import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.common.app.BaseApplicationImpl;

public class oal
{
  private static String a(String paramString)
  {
    String str = "0";
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        str = String.format("%.3f", new Object[] { Float.valueOf((float)Long.parseLong(paramString) * 1.0F / 1048576.0F) });
      }
      return str;
    }
    catch (Exception paramString) {}
    return "0";
  }
  
  public static void a(Context paramContext, DialogInterface.OnClickListener paramOnClickListener, SpannableStringBuilder paramSpannableStringBuilder, String paramString1, String paramString2, String paramString3)
  {
    bbgu localbbgu = new bbgu(paramContext, 2131755791);
    localbbgu.setContentView(2131558883);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localbbgu.getMessageTextView().getLayoutParams();
    localLayoutParams.leftMargin = actj.a(30.0F, paramContext.getResources());
    localLayoutParams.rightMargin = actj.a(30.0F, paramContext.getResources());
    localLayoutParams.width = -1;
    localbbgu.getMessageTextView().setLayoutParams(localLayoutParams);
    localbbgu.setMessage(paramSpannableStringBuilder);
    localbbgu.setTitle(paramString1);
    localbbgu.setPositiveButton(paramString2, new oan(paramOnClickListener));
    localbbgu.setNegativeButton(paramString3, new oao());
    localbbgu.show();
  }
  
  public static void a(Context paramContext, AdData paramAdData, DialogInterface.OnClickListener paramOnClickListener)
  {
    if ((paramAdData == null) || (paramAdData.a == null)) {
      return;
    }
    bbgu localbbgu = new bbgu(paramContext, 2131755791);
    localbbgu.setContentView(2131558883);
    paramContext = ajya.a(2131712863);
    if (!TextUtils.isEmpty(paramAdData.a.t)) {
      paramContext = paramAdData.a.t;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramContext);
    String str3 = ajya.a(2131712859);
    String str4 = "#E06F00";
    String str2 = str4;
    String str1 = str3;
    if (!TextUtils.isEmpty(paramAdData.a.u))
    {
      str2 = str4;
      str1 = str3;
      if (!TextUtils.isEmpty(paramAdData.a.v))
      {
        str1 = paramAdData.a.u;
        str2 = paramAdData.a.v;
      }
    }
    if (paramContext.contains(str1))
    {
      int i = paramContext.indexOf(str1);
      int j = str1.length();
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor(str2)), i, j + i, 33);
    }
    localbbgu.setMessage(localSpannableStringBuilder);
    paramContext = ajya.a(2131712937);
    if (!TextUtils.isEmpty(paramAdData.a.w)) {
      paramContext = paramAdData.a.w;
    }
    localbbgu.setTitle(paramContext);
    localbbgu.setPositiveButton(ajya.a(2131713078), new oam(paramOnClickListener));
    localbbgu.show();
  }
  
  public static void a(Context paramContext, AdData paramAdData, boolean paramBoolean1, boolean paramBoolean2, DialogInterface.OnClickListener paramOnClickListener)
  {
    if ((paramAdData == null) || (paramAdData.a == null)) {
      return;
    }
    String str1;
    SpannableStringBuilder localSpannableStringBuilder;
    String str2;
    if (!paramBoolean1)
    {
      str1 = ajya.a(2131712953);
      if (!a(paramAdData.a.q).equals("0")) {
        str1 = String.format(ajya.a(2131712822), new Object[] { a(paramAdData.a.q) });
      }
      if (!TextUtils.isEmpty(paramAdData.a.s)) {
        str1 = paramAdData.a.s;
      }
      localSpannableStringBuilder = new SpannableStringBuilder(str1);
      if (!paramBoolean2)
      {
        String str4 = ajya.a(2131713080);
        String str5 = "#E06F00";
        String str3 = str5;
        str2 = str4;
        if (!TextUtils.isEmpty(paramAdData.a.u))
        {
          str3 = str5;
          str2 = str4;
          if (!TextUtils.isEmpty(paramAdData.a.v))
          {
            str2 = paramAdData.a.u;
            str3 = paramAdData.a.v;
          }
        }
        if (str1.contains(str2))
        {
          int i = str1.indexOf(str2);
          int j = str2.length();
          localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor(str3)), i, j + i, 33);
        }
      }
      str1 = ajya.a(2131713077);
      if (paramBoolean2) {
        str1 = ajya.a(2131713048);
      }
      if (TextUtils.isEmpty(paramAdData.a.w)) {
        break label363;
      }
      str1 = paramAdData.a.w;
    }
    label363:
    for (;;)
    {
      str2 = ajya.a(2131712739);
      if (bbfr.a(BaseApplicationImpl.getContext(), paramAdData.a.b)) {
        str2 = ajya.a(2131712884);
      }
      if (paramBoolean2) {}
      for (paramAdData = ajya.a(2131713008);; paramAdData = ajya.a(2131712713))
      {
        a(paramContext, paramOnClickListener, localSpannableStringBuilder, str1, str2, paramAdData);
        return;
        str1 = ajya.a(2131712931);
        if (TextUtils.isEmpty(paramAdData.a.t)) {
          break;
        }
        str1 = paramAdData.a.t;
        break;
      }
    }
  }
  
  public static void a(Context paramContext, String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(ajya.a(2131712823));
    String str2 = ajya.a(2131712981);
    String str1 = ajya.a(2131712738);
    if (bbfr.a(BaseApplicationImpl.getContext(), paramString)) {
      str1 = ajya.a(2131713017);
    }
    a(paramContext, paramOnClickListener, localSpannableStringBuilder, str2, str1, ajya.a(2131713131));
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(String.format(ajya.a(2131712995), new Object[] { a(paramString1) }));
    String str = ajya.a(2131712900);
    paramString1 = ajya.a(2131713144);
    if (bbfr.a(BaseApplicationImpl.getContext(), paramString2)) {
      paramString1 = ajya.a(2131713112);
    }
    a(paramContext, paramOnClickListener, localSpannableStringBuilder, str, paramString1, ajya.a(2131712870));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oal
 * JD-Core Version:    0.7.0.1
 */