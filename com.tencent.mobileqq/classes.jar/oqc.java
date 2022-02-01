import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.common.app.BaseApplicationImpl;

public class oqc
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
    bgpa localbgpa = new bgpa(paramContext, 2131755823);
    localbgpa.setContentView(2131558985);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localbgpa.getMessageTextView().getLayoutParams();
    localLayoutParams.leftMargin = afur.a(30.0F, paramContext.getResources());
    localLayoutParams.rightMargin = afur.a(30.0F, paramContext.getResources());
    localLayoutParams.width = -1;
    localbgpa.getMessageTextView().setLayoutParams(localLayoutParams);
    localbgpa.setMessage(paramSpannableStringBuilder);
    localbgpa.setTitle(paramString1);
    localbgpa.setPositiveButton(paramString2, new oqd(paramOnClickListener));
    localbgpa.setNegativeButton(paramString3, new oqe(paramOnClickListener));
    localbgpa.show();
  }
  
  public static void a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, boolean paramBoolean1, boolean paramBoolean2, DialogInterface.OnClickListener paramOnClickListener)
  {
    if ((paramAdvertisementInfo == null) || (paramAdvertisementInfo.gameAdComData == null)) {
      return;
    }
    String str1;
    SpannableStringBuilder localSpannableStringBuilder;
    String str2;
    if (!paramBoolean1)
    {
      str1 = anni.a(2131711716);
      if (!a(paramAdvertisementInfo.gameAdComData.m).equals("0")) {
        str1 = String.format(anni.a(2131711585), new Object[] { a(paramAdvertisementInfo.gameAdComData.m) });
      }
      if (!TextUtils.isEmpty(paramAdvertisementInfo.gameAdComData.y)) {
        str1 = paramAdvertisementInfo.gameAdComData.y;
      }
      localSpannableStringBuilder = new SpannableStringBuilder(str1);
      if (!paramBoolean2)
      {
        String str4 = anni.a(2131711843);
        String str5 = "#E06F00";
        String str3 = str5;
        str2 = str4;
        if (!TextUtils.isEmpty(paramAdvertisementInfo.gameAdComData.z))
        {
          str3 = str5;
          str2 = str4;
          if (!TextUtils.isEmpty(paramAdvertisementInfo.gameAdComData.A))
          {
            str2 = paramAdvertisementInfo.gameAdComData.z;
            str3 = paramAdvertisementInfo.gameAdComData.A;
          }
        }
        if (str1.contains(str2))
        {
          int i = str1.indexOf(str2);
          int j = str2.length();
          localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor(str3)), i, j + i, 33);
        }
      }
      str1 = anni.a(2131711840);
      if (paramBoolean2) {
        str1 = anni.a(2131711811);
      }
      if (TextUtils.isEmpty(paramAdvertisementInfo.gameAdComData.w)) {
        break label363;
      }
      str1 = paramAdvertisementInfo.gameAdComData.w;
    }
    label363:
    for (;;)
    {
      str2 = anni.a(2131711502);
      if (bgnw.a(BaseApplicationImpl.getContext(), paramAdvertisementInfo.gameAdComData.d)) {
        str2 = anni.a(2131711647);
      }
      if (paramBoolean2) {}
      for (paramAdvertisementInfo = anni.a(2131711771);; paramAdvertisementInfo = anni.a(2131711476))
      {
        a(paramContext, paramOnClickListener, localSpannableStringBuilder, str1, str2, paramAdvertisementInfo);
        return;
        str1 = anni.a(2131711694);
        if (TextUtils.isEmpty(paramAdvertisementInfo.gameAdComData.x)) {
          break;
        }
        str1 = paramAdvertisementInfo.gameAdComData.x;
        break;
      }
    }
  }
  
  public static void a(Context paramContext, String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(anni.a(2131711586));
    String str2 = anni.a(2131711744);
    String str1 = anni.a(2131711501);
    if (bgnw.a(BaseApplicationImpl.getContext(), paramString)) {
      str1 = anni.a(2131711780);
    }
    a(paramContext, paramOnClickListener, localSpannableStringBuilder, str2, str1, anni.a(2131711894));
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(String.format(anni.a(2131711758), new Object[] { a(paramString1) }));
    String str = anni.a(2131711663);
    paramString1 = anni.a(2131711907);
    if (bgnw.a(BaseApplicationImpl.getContext(), paramString2)) {
      paramString1 = anni.a(2131711875);
    }
    a(paramContext, paramOnClickListener, localSpannableStringBuilder, str, paramString1, anni.a(2131711633));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oqc
 * JD-Core Version:    0.7.0.1
 */