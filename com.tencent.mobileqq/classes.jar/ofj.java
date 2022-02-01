import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.MalformedURLException;
import java.net.URL;

public class ofj
  implements View.OnClickListener
{
  public static String a;
  long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private View[] jdField_a_of_type_ArrayOfAndroidViewView = { this.jdField_a_of_type_AndroidViewView, this.b };
  private View b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "tag_on_nearby_tips_click";
  }
  
  public ofj(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public View a(String paramString, View.OnClickListener paramOnClickListener)
  {
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)this.jdField_a_of_type_AndroidViewView).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167337));
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130847011);
      ((TextView)this.jdField_a_of_type_AndroidViewView).setGravity(16);
      this.jdField_a_of_type_AndroidViewView.setTag(jdField_a_of_type_JavaLangString);
      ((TextView)this.jdField_a_of_type_AndroidViewView).setTextSize(this.jdField_a_of_type_AndroidContentContext.getResources().getInteger(2131427337));
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 18.0F);
    localLayoutParams.addRule(3, 2131374032);
    localLayoutParams.addRule(11);
    localLayoutParams.rightMargin = DisplayUtil.px2dip(this.jdField_a_of_type_AndroidContentContext, 20.0F);
    ((TextView)this.jdField_a_of_type_AndroidViewView).setText(paramString);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(paramOnClickListener);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    if (this.b != null)
    {
      ViewGroup localViewGroup = (ViewGroup)this.b.getParent();
      if (localViewGroup != null) {
        localViewGroup.removeView(this.b);
      }
    }
  }
  
  public void a(ViewGroup paramViewGroup, View paramView)
  {
    if ((paramViewGroup == null) || (paramView == null)) {}
    do
    {
      return;
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfAndroidViewView.length)
      {
        if ((this.jdField_a_of_type_ArrayOfAndroidViewView[i] != null) && (this.jdField_a_of_type_ArrayOfAndroidViewView[i] != paramView) && (paramViewGroup.indexOfChild(this.jdField_a_of_type_ArrayOfAndroidViewView[i]) != -1)) {
          paramViewGroup.removeView(this.jdField_a_of_type_ArrayOfAndroidViewView[i]);
        }
        i += 1;
      }
    } while (paramViewGroup.indexOfChild(paramView) != -1);
    paramViewGroup.addView(paramView);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    label55:
    do
    {
      return;
      Object localObject1 = null;
      try
      {
        localObject2 = (ViewGroup)((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().mAIORootView.findViewById(2131364407);
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        Object localObject2;
        int i;
        break label55;
      }
    } while (localObject1 == null);
    if (this.b == null)
    {
      this.b = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
      this.b.setId(2131362546);
      i = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 62.0F);
      localObject2 = new RelativeLayout.LayoutParams(i, i);
      ((RelativeLayout.LayoutParams)localObject2).topMargin = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 15.0F);
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 15.0F);
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131374032);
      ((RelativeLayout.LayoutParams)localObject2).addRule(11);
      this.b.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    this.b.setTag(2131362549, paramString2);
    this.b.setTag(2131362547, String.valueOf(paramInt1));
    this.b.setTag(2131362548, String.valueOf(paramInt2));
    this.b.setTag(2131362550, Integer.valueOf(paramInt3));
    this.b.setOnClickListener(this);
    paramString2 = URLDrawable.URLDrawableOptions.obtain();
    paramString2.mPlayGifImage = true;
    try
    {
      paramString1 = URLDrawable.getDrawable(new URL(paramString1), paramString2);
      ((URLImageView)this.b).setImageDrawable(paramString1);
      if (paramString1.getStatus() == 2)
      {
        paramString1.restartDownload();
        this.b.setVisibility(8);
      }
      ((URLImageView)this.b).setURLDrawableDownListener(new ofk(this));
    }
    catch (MalformedURLException paramString1)
    {
      label298:
      break label298;
    }
    a(localObject1, this.b);
    bcef.b(null, "dc00899", "Pb_account_lifeservice", "1", "0X80075A0", "0X80075A0", 0, 0, "", "", String.valueOf(paramInt1), String.valueOf(paramInt2));
  }
  
  public void onClick(View paramView)
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 1000L) {}
    do
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    } while ((paramView.getId() != 2131362546) || (this.jdField_a_of_type_AndroidContentContext == null));
    String str1 = (String)paramView.getTag(2131362549);
    String str2 = (String)paramView.getTag(2131362547);
    String str3 = (String)paramView.getTag(2131362548);
    Intent localIntent;
    if (((Integer)paramView.getTag(2131362550)).intValue() == 1)
    {
      localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("url", str1);
      localIntent.putExtra("fromAio", true);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    }
    for (;;)
    {
      bcef.b(null, "dc00899", "Pb_account_lifeservice", "1", "0X80075A1", "0X80075A1", 0, 0, "", "", str2, str3);
      break;
      localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, JumpActivity.class);
      localIntent.setData(Uri.parse(str1));
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ofj
 * JD-Core Version:    0.7.0.1
 */