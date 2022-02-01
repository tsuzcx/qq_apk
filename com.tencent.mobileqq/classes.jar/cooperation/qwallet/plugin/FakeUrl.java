package cooperation.qwallet.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class FakeUrl
{
  public static final String FAKE_LBUTTON = "lbutton";
  public static final String FAKE_RBUTTON = "rbutton";
  public static final String FAKE_RETURL = "returl";
  public static final String FAKE_TITLE = "title";
  private static final String TAG = "FakeUrl";
  public static final Pattern URL_MATCH_TXT_REGEX = Pattern.compile("<TITLE=\"([^>]+)\",URL=\"([^<]+)\">", 2);
  public Activity context;
  public FakeUrl.FakeInfo fakeInfo = new FakeUrl.FakeInfo();
  protected FakeUrl.FakeListener fl;
  private DialogInterface.OnClickListener lListener = new FakeUrl.1(this);
  private QQCustomDialog mDialog;
  private boolean mIsCloseAfterClickUrl = true;
  private DialogInterface.OnClickListener rListener = new FakeUrl.2(this);
  
  public FakeUrl(Context paramContext)
  {
    this.context = ((Activity)paramContext);
  }
  
  public static void gotoH5(Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = paramContext;
    if ((paramContext instanceof BasePluginActivity)) {
      localObject = ((BasePluginActivity)paramContext).getOutActivity();
    }
    paramContext = new Intent((Context)localObject, QQBrowserActivity.class);
    paramContext.putExtra("url", paramString);
    paramContext.putExtra("startOpenPageTime", System.currentTimeMillis());
    paramContext.putExtra("hide_operation_bar", paramBoolean1);
    paramContext.putExtra("hide_more_button", paramBoolean2);
    ((Context)localObject).startActivity(paramContext);
  }
  
  public static void gotoMqq(Context paramContext, String paramString)
  {
    Object localObject = paramContext;
    if ((paramContext instanceof BasePluginActivity)) {
      localObject = ((BasePluginActivity)paramContext).getOutActivity();
    }
    paramContext = new Intent((Context)localObject, JumpActivity.class);
    paramContext.setData(Uri.parse(paramString));
    ((Context)localObject).startActivity(paramContext);
  }
  
  public static void gotoResultH5(Activity paramActivity, String paramString, boolean paramBoolean, int paramInt)
  {
    Activity localActivity = paramActivity;
    if ((paramActivity instanceof BasePluginActivity)) {
      localActivity = ((BasePluginActivity)paramActivity).getOutActivity();
    }
    paramActivity = new Intent(localActivity, QQBrowserActivity.class);
    paramActivity.putExtra("url", paramString);
    paramActivity.putExtra("startOpenPageTime", System.currentTimeMillis());
    paramActivity.putExtra("hide_operation_bar", paramBoolean);
    localActivity.startActivityForResult(paramActivity, paramInt);
  }
  
  private Uri parseUrl(String paramString)
  {
    paramString = Uri.parse(paramString);
    if (paramString == null) {
      return null;
    }
    if (paramString.getScheme() == null)
    {
      QLog.i("FakeUrl", 2, "no scheme...");
      return null;
    }
    return paramString;
  }
  
  public QQCustomDialog getDialog()
  {
    return this.mDialog;
  }
  
  public CharSequence getSpanStr(String paramString)
  {
    int i = 0;
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return paramString;
      try
      {
        SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder("");
        Matcher localMatcher = URL_MATCH_TXT_REGEX.matcher(paramString);
        int j = 0;
        int k = 0;
        while (localMatcher.find())
        {
          int m = localMatcher.start(0);
          k = localMatcher.end(0);
          String str1 = paramString.substring(localMatcher.start(1), localMatcher.end(1));
          String str2 = paramString.substring(localMatcher.start(2), localMatcher.end(2));
          j = i;
          if (i != m)
          {
            localSpannableStringBuilder.append(paramString.substring(i, m));
            j = k;
          }
          SpannableString localSpannableString = new SpannableString(str1);
          localSpannableString.setSpan(new FakeUrl.3(this, str2), 0, str1.length(), 33);
          localSpannableString.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(2131165793)), 0, str1.length(), 33);
          localSpannableStringBuilder.append(localSpannableString);
          m = 1;
          i = j;
          j = m;
        }
        if (j != 0)
        {
          localSpannableStringBuilder.append(paramString.substring(k));
          return localSpannableStringBuilder;
        }
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  public boolean onFakePros(String paramString1, String paramString2, FakeUrl.FakeListener paramFakeListener)
  {
    try
    {
      boolean bool = onFakePros(paramString1, new JSONObject(paramString2), paramFakeListener);
      return bool;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    return false;
  }
  
  public boolean onFakePros(String paramString, JSONObject paramJSONObject, FakeUrl.FakeListener paramFakeListener)
  {
    this.fl = paramFakeListener;
    this.fakeInfo.reqUrl = paramString;
    this.fakeInfo.data = paramJSONObject;
    this.fakeInfo.retcode = paramJSONObject.optInt("retcode");
    this.fakeInfo.retmsg = paramJSONObject.optString("retmsg");
    paramString = this.fakeInfo;
    paramFakeListener = this.fakeInfo;
    String str = paramJSONObject.optString("returl");
    paramFakeListener.retUrl = str;
    paramString.uri = parseUrl(str);
    if (this.fakeInfo.uri != null) {
      this.fakeInfo.host = this.fakeInfo.uri.getHost();
    }
    QLog.i("FakeUrl", 2, "show fake url dialog...");
    paramFakeListener = paramJSONObject.optString("lbutton");
    if (TextUtils.isEmpty(paramFakeListener)) {}
    for (paramString = null;; paramString = this.lListener)
    {
      this.mDialog = new QQCustomDialog(this.context, 2131755826);
      this.mDialog.setContentView(2131559016);
      this.mDialog.setTitle(paramJSONObject.optString("title", null));
      this.mDialog.setMessageWithoutAutoLink(getSpanStr(this.fakeInfo.retmsg));
      this.mDialog.setNegativeButton(paramFakeListener, paramString);
      this.mDialog.setPositiveButton(paramJSONObject.optString("rbutton"), this.rListener);
      this.mDialog.setCanceledOnTouchOutside(true);
      this.mDialog.setCancelable(false);
      this.mDialog.setCanceledOnTouchOutside(false);
      try
      {
        this.mDialog.show();
        return true;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    return true;
  }
  
  protected boolean parseFakeUrl(String paramString)
  {
    QLog.i("FakeUrl", 2, "parseFakeUrl url = " + paramString);
    Object localObject = Uri.parse(paramString);
    if (localObject == null) {}
    do
    {
      return false;
      localObject = ((Uri)localObject).getScheme();
      if (localObject == null)
      {
        QLog.i("FakeUrl", 2, "no scheme...");
        return false;
      }
      if (((String)localObject).startsWith("http"))
      {
        QLog.i("FakeUrl", 2, "goto h5...");
        gotoH5(this.context, paramString, true, true);
        return true;
      }
    } while (((String)localObject).compareTo("mqqapi") != 0);
    QLog.i("FakeUrl", 2, "goto mqq...");
    gotoMqq(this.context, paramString);
    return true;
  }
  
  public void setIsCloseAfterClickUrl(boolean paramBoolean)
  {
    this.mIsCloseAfterClickUrl = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qwallet.plugin.FakeUrl
 * JD-Core Version:    0.7.0.1
 */