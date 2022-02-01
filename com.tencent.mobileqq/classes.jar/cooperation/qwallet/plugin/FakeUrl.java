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
import com.tencent.mobileqq.app.utils.RouteUtils;
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
  protected Activity context;
  protected FakeUrl.FakeInfo fakeInfo = new FakeUrl.FakeInfo();
  protected FakeUrl.FakeListener fl = null;
  private DialogInterface.OnClickListener lListener = new FakeUrl.1(this);
  private QQCustomDialog mDialog = null;
  private boolean mIsCloseAfterClickUrl = true;
  private DialogInterface.OnClickListener rListener = new FakeUrl.2(this);
  
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
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    try
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder("");
      Matcher localMatcher = URL_MATCH_TXT_REGEX.matcher(paramString);
      int m = 0;
      int j = 0;
      int k;
      for (int i = 0; localMatcher.find(); i = k)
      {
        m = localMatcher.start(0);
        j = localMatcher.end(0);
        String str1 = paramString.substring(localMatcher.start(1), localMatcher.end(1));
        String str2 = paramString.substring(localMatcher.start(2), localMatcher.end(2));
        k = i;
        if (i != m)
        {
          localSpannableStringBuilder.append(paramString.substring(i, m));
          k = j;
        }
        SpannableString localSpannableString = new SpannableString(str1);
        localSpannableString.setSpan(new FakeUrl.3(this, str2), 0, str1.length(), 33);
        localSpannableString.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(2131166411)), 0, str1.length(), 33);
        localSpannableStringBuilder.append(localSpannableString);
        m = 1;
      }
      if (m != 0)
      {
        localSpannableStringBuilder.append(paramString.substring(j));
        return localSpannableStringBuilder;
      }
      return paramString;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public void gotoH5(Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = paramContext;
    if ((paramContext instanceof BasePluginActivity)) {
      localObject = ((BasePluginActivity)paramContext).getOutActivity();
    }
    paramContext = new Intent();
    paramContext.putExtra("url", paramString);
    paramContext.putExtra("startOpenPageTime", System.currentTimeMillis());
    paramContext.putExtra("hide_operation_bar", paramBoolean1);
    paramContext.putExtra("hide_more_button", paramBoolean2);
    RouteUtils.a((Context)localObject, paramContext, "/base/browser");
  }
  
  public void gotoMqq(Context paramContext, String paramString)
  {
    Object localObject = paramContext;
    if ((paramContext instanceof BasePluginActivity)) {
      localObject = ((BasePluginActivity)paramContext).getOutActivity();
    }
    paramContext = new Intent((Context)localObject, JumpActivity.class);
    paramContext.setData(Uri.parse(paramString));
    ((Context)localObject).startActivity(paramContext);
  }
  
  public void gotoResultH5(Activity paramActivity, String paramString, boolean paramBoolean, int paramInt)
  {
    Activity localActivity = paramActivity;
    if ((paramActivity instanceof BasePluginActivity)) {
      localActivity = ((BasePluginActivity)paramActivity).getOutActivity();
    }
    paramActivity = new Intent();
    paramActivity.putExtra("url", paramString);
    paramActivity.putExtra("startOpenPageTime", System.currentTimeMillis());
    paramActivity.putExtra("hide_operation_bar", paramBoolean);
    RouteUtils.a(localActivity, paramActivity, "/base/browser", paramInt);
  }
  
  public void init(Context paramContext)
  {
    this.context = ((Activity)paramContext);
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
    paramFakeListener = this.fakeInfo;
    paramFakeListener.reqUrl = paramString;
    paramFakeListener.data = paramJSONObject;
    paramFakeListener.retcode = paramJSONObject.optInt("retcode");
    this.fakeInfo.retmsg = paramJSONObject.optString("retmsg");
    paramString = this.fakeInfo;
    paramFakeListener = paramJSONObject.optString("returl");
    paramString.retUrl = paramFakeListener;
    paramString.uri = parseUrl(paramFakeListener);
    if (this.fakeInfo.uri != null)
    {
      paramString = this.fakeInfo;
      paramString.host = paramString.uri.getHost();
    }
    QLog.i("FakeUrl", 2, "show fake url dialog...");
    paramFakeListener = paramJSONObject.optString("lbutton");
    if (TextUtils.isEmpty(paramFakeListener)) {
      paramString = null;
    } else {
      paramString = this.lListener;
    }
    this.mDialog = new QQCustomDialog(this.context, 2131953338);
    this.mDialog.setContentView(2131624611);
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
    return true;
  }
  
  protected boolean parseFakeUrl(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("parseFakeUrl url = ");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("FakeUrl", 2, ((StringBuilder)localObject).toString());
    localObject = Uri.parse(paramString);
    if (localObject == null) {
      return false;
    }
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
    if (((String)localObject).compareTo("mqqapi") == 0)
    {
      QLog.i("FakeUrl", 2, "goto mqq...");
      gotoMqq(this.context, paramString);
      return true;
    }
    return false;
  }
  
  public void setIsCloseAfterClickUrl(boolean paramBoolean)
  {
    this.mIsCloseAfterClickUrl = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qwallet.plugin.FakeUrl
 * JD-Core Version:    0.7.0.1
 */