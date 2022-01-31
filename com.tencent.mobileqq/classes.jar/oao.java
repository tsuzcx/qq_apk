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

public class oao
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
    bbgg localbbgg = new bbgg(paramContext, 2131755791);
    localbbgg.setContentView(2131558883);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localbbgg.getMessageTextView().getLayoutParams();
    localLayoutParams.leftMargin = actn.a(30.0F, paramContext.getResources());
    localLayoutParams.rightMargin = actn.a(30.0F, paramContext.getResources());
    localLayoutParams.width = -1;
    localbbgg.getMessageTextView().setLayoutParams(localLayoutParams);
    localbbgg.setMessage(paramSpannableStringBuilder);
    localbbgg.setTitle(paramString1);
    localbbgg.setPositiveButton(paramString2, new oaq(paramOnClickListener));
    localbbgg.setNegativeButton(paramString3, new oar());
    localbbgg.show();
  }
  
  public static void a(Context paramContext, AdData paramAdData, DialogInterface.OnClickListener paramOnClickListener)
  {
    if ((paramAdData == null) || (paramAdData.a == null)) {
      return;
    }
    bbgg localbbgg = new bbgg(paramContext, 2131755791);
    localbbgg.setContentView(2131558883);
    paramContext = ajyc.a(2131712852);
    if (!TextUtils.isEmpty(paramAdData.a.t)) {
      paramContext = paramAdData.a.t;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramContext);
    String str3 = ajyc.a(2131712848);
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
    localbbgg.setMessage(localSpannableStringBuilder);
    paramContext = ajyc.a(2131712926);
    if (!TextUtils.isEmpty(paramAdData.a.w)) {
      paramContext = paramAdData.a.w;
    }
    localbbgg.setTitle(paramContext);
    localbbgg.setPositiveButton(ajyc.a(2131713067), new oap(paramOnClickListener));
    localbbgg.show();
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
      str1 = ajyc.a(2131712942);
      if (!a(paramAdData.a.q).equals("0")) {
        str1 = String.format(ajyc.a(2131712811), new Object[] { a(paramAdData.a.q) });
      }
      if (!TextUtils.isEmpty(paramAdData.a.s)) {
        str1 = paramAdData.a.s;
      }
      localSpannableStringBuilder = new SpannableStringBuilder(str1);
      if (!paramBoolean2)
      {
        String str4 = ajyc.a(2131713069);
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
      str1 = ajyc.a(2131713066);
      if (paramBoolean2) {
        str1 = ajyc.a(2131713037);
      }
      if (TextUtils.isEmpty(paramAdData.a.w)) {
        break label363;
      }
      str1 = paramAdData.a.w;
    }
    label363:
    for (;;)
    {
      str2 = ajyc.a(2131712728);
      if (bbfd.a(BaseApplicationImpl.getContext(), paramAdData.a.b)) {
        str2 = ajyc.a(2131712873);
      }
      if (paramBoolean2) {}
      for (paramAdData = ajyc.a(2131712997);; paramAdData = ajyc.a(2131712702))
      {
        a(paramContext, paramOnClickListener, localSpannableStringBuilder, str1, str2, paramAdData);
        return;
        str1 = ajyc.a(2131712920);
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
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(ajyc.a(2131712812));
    String str2 = ajyc.a(2131712970);
    String str1 = ajyc.a(2131712727);
    if (bbfd.a(BaseApplicationImpl.getContext(), paramString)) {
      str1 = ajyc.a(2131713006);
    }
    a(paramContext, paramOnClickListener, localSpannableStringBuilder, str2, str1, ajyc.a(2131713120));
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(String.format(ajyc.a(2131712984), new Object[] { a(paramString1) }));
    String str = ajyc.a(2131712889);
    paramString1 = ajyc.a(2131713133);
    if (bbfd.a(BaseApplicationImpl.getContext(), paramString2)) {
      paramString1 = ajyc.a(2131713101);
    }
    a(paramContext, paramOnClickListener, localSpannableStringBuilder, str, paramString1, ajyc.a(2131712859));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oao
 * JD-Core Version:    0.7.0.1
 */