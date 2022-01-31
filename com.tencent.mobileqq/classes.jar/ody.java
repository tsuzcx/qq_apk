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
    bdjz localbdjz = new bdjz(paramContext, 2131755801);
    localbdjz.setContentView(2131558919);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localbdjz.getMessageTextView().getLayoutParams();
    localLayoutParams.leftMargin = aepi.a(30.0F, paramContext.getResources());
    localLayoutParams.rightMargin = aepi.a(30.0F, paramContext.getResources());
    localLayoutParams.width = -1;
    localbdjz.getMessageTextView().setLayoutParams(localLayoutParams);
    localbdjz.setMessage(paramSpannableStringBuilder);
    localbdjz.setTitle(paramString1);
    localbdjz.setPositiveButton(paramString2, new oea(paramOnClickListener));
    localbdjz.setNegativeButton(paramString3, new oeb());
    localbdjz.show();
  }
  
  public static void a(Context paramContext, AdData paramAdData, DialogInterface.OnClickListener paramOnClickListener)
  {
    if ((paramAdData == null) || (paramAdData.a == null)) {
      return;
    }
    bdjz localbdjz = new bdjz(paramContext, 2131755801);
    localbdjz.setContentView(2131558919);
    paramContext = alud.a(2131713247);
    if (!TextUtils.isEmpty(paramAdData.a.t)) {
      paramContext = paramAdData.a.t;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramContext);
    String str3 = alud.a(2131713243);
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
    localbdjz.setMessage(localSpannableStringBuilder);
    paramContext = alud.a(2131713321);
    if (!TextUtils.isEmpty(paramAdData.a.w)) {
      paramContext = paramAdData.a.w;
    }
    localbdjz.setTitle(paramContext);
    localbdjz.setPositiveButton(alud.a(2131713462), new odz(paramOnClickListener));
    localbdjz.show();
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
      str1 = alud.a(2131713337);
      if (!a(paramAdData.a.q).equals("0")) {
        str1 = String.format(alud.a(2131713206), new Object[] { a(paramAdData.a.q) });
      }
      if (!TextUtils.isEmpty(paramAdData.a.s)) {
        str1 = paramAdData.a.s;
      }
      localSpannableStringBuilder = new SpannableStringBuilder(str1);
      if (!paramBoolean2)
      {
        String str4 = alud.a(2131713464);
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
      str1 = alud.a(2131713461);
      if (paramBoolean2) {
        str1 = alud.a(2131713432);
      }
      if (TextUtils.isEmpty(paramAdData.a.w)) {
        break label363;
      }
      str1 = paramAdData.a.w;
    }
    label363:
    for (;;)
    {
      str2 = alud.a(2131713123);
      if (bdiv.a(BaseApplicationImpl.getContext(), paramAdData.a.b)) {
        str2 = alud.a(2131713268);
      }
      if (paramBoolean2) {}
      for (paramAdData = alud.a(2131713392);; paramAdData = alud.a(2131713097))
      {
        a(paramContext, paramOnClickListener, localSpannableStringBuilder, str1, str2, paramAdData);
        return;
        str1 = alud.a(2131713315);
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
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(alud.a(2131713207));
    String str2 = alud.a(2131713365);
    String str1 = alud.a(2131713122);
    if (bdiv.a(BaseApplicationImpl.getContext(), paramString)) {
      str1 = alud.a(2131713401);
    }
    a(paramContext, paramOnClickListener, localSpannableStringBuilder, str2, str1, alud.a(2131713515));
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(String.format(alud.a(2131713379), new Object[] { a(paramString1) }));
    String str = alud.a(2131713284);
    paramString1 = alud.a(2131713528);
    if (bdiv.a(BaseApplicationImpl.getContext(), paramString2)) {
      paramString1 = alud.a(2131713496);
    }
    a(paramContext, paramOnClickListener, localSpannableStringBuilder, str, paramString1, alud.a(2131713254));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ody
 * JD-Core Version:    0.7.0.1
 */