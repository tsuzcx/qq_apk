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

public class ody
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
    bdfq localbdfq = new bdfq(paramContext, 2131755801);
    localbdfq.setContentView(2131558920);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localbdfq.getMessageTextView().getLayoutParams();
    localLayoutParams.leftMargin = aekt.a(30.0F, paramContext.getResources());
    localLayoutParams.rightMargin = aekt.a(30.0F, paramContext.getResources());
    localLayoutParams.width = -1;
    localbdfq.getMessageTextView().setLayoutParams(localLayoutParams);
    localbdfq.setMessage(paramSpannableStringBuilder);
    localbdfq.setTitle(paramString1);
    localbdfq.setPositiveButton(paramString2, new oea(paramOnClickListener));
    localbdfq.setNegativeButton(paramString3, new oeb());
    localbdfq.show();
  }
  
  public static void a(Context paramContext, AdData paramAdData, DialogInterface.OnClickListener paramOnClickListener)
  {
    if ((paramAdData == null) || (paramAdData.a == null)) {
      return;
    }
    bdfq localbdfq = new bdfq(paramContext, 2131755801);
    localbdfq.setContentView(2131558920);
    paramContext = alpo.a(2131713235);
    if (!TextUtils.isEmpty(paramAdData.a.t)) {
      paramContext = paramAdData.a.t;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramContext);
    String str3 = alpo.a(2131713231);
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
    localbdfq.setMessage(localSpannableStringBuilder);
    paramContext = alpo.a(2131713309);
    if (!TextUtils.isEmpty(paramAdData.a.w)) {
      paramContext = paramAdData.a.w;
    }
    localbdfq.setTitle(paramContext);
    localbdfq.setPositiveButton(alpo.a(2131713450), new odz(paramOnClickListener));
    localbdfq.show();
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
      str1 = alpo.a(2131713325);
      if (!a(paramAdData.a.q).equals("0")) {
        str1 = String.format(alpo.a(2131713194), new Object[] { a(paramAdData.a.q) });
      }
      if (!TextUtils.isEmpty(paramAdData.a.s)) {
        str1 = paramAdData.a.s;
      }
      localSpannableStringBuilder = new SpannableStringBuilder(str1);
      if (!paramBoolean2)
      {
        String str4 = alpo.a(2131713452);
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
      str1 = alpo.a(2131713449);
      if (paramBoolean2) {
        str1 = alpo.a(2131713420);
      }
      if (TextUtils.isEmpty(paramAdData.a.w)) {
        break label363;
      }
      str1 = paramAdData.a.w;
    }
    label363:
    for (;;)
    {
      str2 = alpo.a(2131713111);
      if (bdem.a(BaseApplicationImpl.getContext(), paramAdData.a.b)) {
        str2 = alpo.a(2131713256);
      }
      if (paramBoolean2) {}
      for (paramAdData = alpo.a(2131713380);; paramAdData = alpo.a(2131713085))
      {
        a(paramContext, paramOnClickListener, localSpannableStringBuilder, str1, str2, paramAdData);
        return;
        str1 = alpo.a(2131713303);
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
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(alpo.a(2131713195));
    String str2 = alpo.a(2131713353);
    String str1 = alpo.a(2131713110);
    if (bdem.a(BaseApplicationImpl.getContext(), paramString)) {
      str1 = alpo.a(2131713389);
    }
    a(paramContext, paramOnClickListener, localSpannableStringBuilder, str2, str1, alpo.a(2131713503));
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(String.format(alpo.a(2131713367), new Object[] { a(paramString1) }));
    String str = alpo.a(2131713272);
    paramString1 = alpo.a(2131713516);
    if (bdem.a(BaseApplicationImpl.getContext(), paramString2)) {
      paramString1 = alpo.a(2131713484);
    }
    a(paramContext, paramOnClickListener, localSpannableStringBuilder, str, paramString1, alpo.a(2131713242));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ody
 * JD-Core Version:    0.7.0.1
 */